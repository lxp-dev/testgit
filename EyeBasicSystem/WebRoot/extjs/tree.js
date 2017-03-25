Ext.onReady(function(){
	 
    Ext.BLANK_IMAGE_URL = 'extjs/resources/images/gray/s.gif'; 
    var Tree = Ext.tree;
    var loader=new Ext.tree.TreeLoader(
        	{
        	
        	});
    var root = new Tree.AsyncTreeNode({
        text: '组织结构目录',
        icon: 'extjs/resources/images/default/tree/frame_0.png',
        draggable:false, 
        
        id:'@'
    });
    var isClosed="0";
    var isRole="0";
    var isPerson="0";
    var tree = new Tree.TreePanel({
    	bodyStyle :'LINE-HEIGHT: 40px',
    	title:'&nbsp;', 
    	renderTo:"tree-div",
    	root:root,
//        el:'tree-div',
//        listeners : {
//            click : function(node, c) {
//	    	if(node.isExpanded()) {
//	    		node.collapse(true);
//	          }else {
//	            node.expand(node);
//	          }
//	        }
//       },
         rootVisible:true,     		 
                border:true,         
                lines:true,			  
                animate:true,         
                autoScroll:true,      
                enableDD:false,           
                containerScroll:true, 
                trackMouseOver:true, 
                //height:screen.height-100,
                height:parent.document.body.offsetHeight-45,
        loader: loader
    });
    
    // set the root node
    

//    	tree.setRootNode(root);
	  	tree.on('beforeload', 
        function(node)
        { 
	  		//Ext.Msg.alert("%%%%", isClosed+"***"+isRole+"^^^"+isPerson);
 			tree.loader.dataUrl='menus.action?pid='+node.id+'&hrefTarget='+$('#hrefTarget').val()+'&moduleID='+$('#moduleID').val()+'&isRole='+isRole+'&isPerson='+isPerson+'&isClosed='+isClosed;
        }); 
	  	tree.on('click', function(node)
	  	{ 
	  	 	if(node.isExpanded()) 
	  	 	{
	  	 		node.collapse(true);
	  		}else 
	  		{
	  		    refreNode();
	  		}
	  	 }); 
        
        Ext.getDoc().on("contextmenu", function(e){
      	    e.stopEvent();
        });
        	
    	//绑定节点右键菜单功能
        tree.on('contextmenu',function(node,event){  

              event.preventDefault(); //这行是必须的
              node.select();  
              if(node.id.substr(0,1)=='L'){

                  //部门定义右键菜单
                  var rightClick = new Ext.menu.Menu({
                      id :'rightClickCont',
                      items : [{
                          id:'rMenu1',
                          text : '部门信息维护',
                          // iconCls:"Tree-Delete",
                          handler:function (){
                               window.parent.mainFrame1.location='departmentSel.action?departmentID='+node.id.substr(2,node.id.length-2)+'&goodsTree=1&moduleID='+$('#moduleID').val();
                          }
                      },{
                          id:'rMenu2',
                          text : '查看部门信息',
                          // iconCls:"Tree-Delete",
                          handler:function (){
                               window.parent.mainFrame1.location='initDepartmentDetail.action?hid='+node.id.substr(2,node.id.length-2)+'&moduleID='+$('#moduleID').val();
                          }
                      }, {
                          id:'rMenu3',
                          text : '查看人员列表',
                          handler:function (){
                                window.parent.mainFrame1.location='selPersonInfo.action?moduleID='+$('#moduleID').val()+'&parent=1&goodsTree=1&selDepartmentID='+node.id.substr(2,node.id.length-2);
                          }
                      }, {
                          id:'rMenu17',
                          text : '新增人员',
                          //增加菜单点击事件
                          handler:function (){
                      	   initPersonInsertByDept(node.id.substr(2,node.id.length-2),node.text,'','',$('#moduleID').val());
                         }

                      }]
                   }).showAt(event.getPoint());//取得鼠标点击坐标，展示菜单  

              }else if(node.id.substr(0,1)=='R'){
            	  var pt=node.parentNode;
                  //角色定义右键菜单
                  var rightClick2 = new Ext.menu.Menu({
                      id :'rightClickCont2',
                      items : [{
                          id:'rMenu4',
                          text : '角色信息维护',
                          //增加菜单点击事件
                          handler:function (){
                    	        var hid = node.id.split('_');
                                window.parent.mainFrame1.location='initRoleList.action?moduleID='+$('#moduleID').val()+'&goodsTree=1&hid='+hid[hid.length-1]+'&roleName2='+EncodeUtf8(node.text);
                          }
                      }, {
                          id:'rMenu5',
                          text : '查看人员列表',
                          //增加菜单点击事件
                          handler:function (){
              	                var hid = node.id.split('_');
                                window.parent.mainFrame1.location='selPersonInfo.action?moduleID='+$('#moduleID').val()+'&parent=1&goodsTree=1&selRoleid='+hid[hid.length-1]+'&selDepartmentID='+hid[hid.length-2];
                          }
                      }, {
                          id:'rMenu10',
                          text : '新增人员', 
                          //增加菜单点击事件
                          handler:function (){
                    	  var hid = node.id.split('_');
                      	   initPersonInsertByDept(hid[hid.length-2],pt.text,hid[hid.length-1],node.text,$('#moduleID').val());
                         }

                      }]
                   }).showAt(event.getPoint());//取得鼠标点击坐标，展示菜单  

              }else if(node.id.substr(0,1)=='@'){
                  var rightClick4 = new Ext.menu.Menu({
                      id :'rightClickCont4',
                      items : [{
                          id:'rMenu6',
                          text : '查看部门列表',
                          handler:function (){
                                window.parent.mainFrame1.location='departmentSel.action?moduleID='+$('#moduleID').val()+'&parent=1&goodsTree=1&departmentFlag='+$('#isClosed').val()+'&treeFlag=1';
                          }
                      },{
                          id:'rMenu23',
                          text : '查看人员列表',
                          handler:function (){
                                window.parent.mainFrame1.location='selPersonInfo.action?parent=1&goodsTree=1&moduleID='+$('#moduleID').val();
                          }
                      }, {
                          id:'rMenu10',
                          text : '新增部门', 
                          //增加菜单点击事件
                          handler:function (){
                    	  var hid = node.id.split('_');
                    	  initDepartmentInsert($('#moduleID').val());
                         }

                      }]
                   }).showAt(event.getPoint());//取得鼠标点击坐标，展示菜单  

              }else{
            	 
	                  //人员定义右键菜单
	                  var rightClick3 = new Ext.menu.Menu({
	                      id :'rightClickCont3',
	                      items : [{
	                          id:'rMenu7',
	                          text : '人员信息维护',
	                          //增加菜单点击事件
	                          handler:function (){
	                                window.parent.mainFrame1.location='selPersonInfo.action?moduleID='+$('#moduleID').val()+'&goodsTree=1&selId='+node.id+'&selPersonName='+node.text;
	                          }
	                      },{
	                          id:'rMenu8',
	                          text : '查看人员信息',
	                          //增加菜单点击事件
	                          handler:function (){
	                                window.parent.mainFrame1.location='initPersonInfoDetail.action?moduleID='+$('#moduleID').val()+'&selId='+node.id;
	                          }
	                      }]
	                   }).showAt(event.getPoint());//取得鼠标点击坐标，展示菜单  

              }
        	 
             }); 
        
        this.refreNode=function()
        {        	
			var mm=tree.getSelectionModel().getSelectedNode();
			if(mm.id.substr(0,1)=='@' || mm.id.substr(0,1)=='L' || mm.id.substr(0,1)=='R')
			{
				mm.reload();
			    mm.expand(mm);
			}
        }
        this.refreParentNode=function()
        {
//        	var nb=tree.getNodeById("00");
//        	var bn=nb.parentNode;
//        	bn.select();
//	        bn.reload();
//	        bn.expand(bn);
        	
        	var nn=tree.getSelectionModel().getSelectedNode();
        	if(nn.id.substr(0,1)=='@')
        	{
        		nn.select();
		        nn.reload();
		        nn.expand(nn);
        	}else
        	{
				var mm=tree.getSelectionModel().getSelectedNode().parentNode;
				mm.select();
		        mm.reload();
		        mm.expand(mm);
        	}
        }
        function initPersonInsertByDept(node,text,rid,rname,moduleID)
        {       	
        	$.get('',{moduleID:moduleID,goodsTree:"1"},function() {

        		window.parent.mainFrame1.initPersonInsertByDept(moduleID,node,text,rid,rname);    
        		
        	}); 
        	 	
        }
        
        function initDepartmentInsert(moduleID)
        {       	
        	$.get('',{moduleID:moduleID,goodsTree:"1"},function() {

        		window.parent.mainFrame1.initDepartmentInsert(moduleID);    
        		
        	}); 
        	 	
        }
        
        this.search=function()
        {     
        	isClosed=$('#isClosed option:selected').val();
            isRole=$('#isRole option:selected').val();
            isPerson=$('#isPerson option:selected').val();
        	root.reload(function(node){
    			tree.expandPath(tree.getNodeById("@").getPath());

    		});
        }
        
    	tree.render();    	
    	root.expand(); 
    	
    	
    	$('div[class=x-panel-header x-unselectable]').prepend("部门状态:<select name='isClosed' id='isClosed' onchange='search()'><option value=''>全部</option><option value='0' selected=selected >正常启用</option><option value='1'>已停用</option> </select>&nbsp;&nbsp;&nbsp; 角色显示:<select name='isRole' id='isRole' onchange='search()'><option value='0'>是</option> <option value='1'>否</option>  </select><br/>人员状态:<select name='isPerson' id='isPerson' onchange='search()'><option value=''>全部</option><option value='0' selected=selected>在职</option><option value='1'>离职</option> </select>"  );
	    $('div[class=x-panel-header x-unselectable]').css("text-align","left");
	});