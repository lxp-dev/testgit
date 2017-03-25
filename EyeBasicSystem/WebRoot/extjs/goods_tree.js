Ext.onReady(function(){

    Ext.BLANK_IMAGE_URL = 'extjs/resources/images/gray/s.gif'; 
    var loader=new Ext.tree.TreeLoader(
    	{
    	
    	});
    
    	var root=new Ext.tree.AsyncTreeNode({
	    	id:"@", 
	    	text: '商品结构目录',
	        icon: 'extjs/resources/images/default/tree/frame_0.png',
	        draggable:false, 
	    	loader:loader
    	}); 
    	
    	var tree=new Ext.tree.TreePanel({
	    	renderTo:"tree-div",
	    	root:root,
	    	bodyStyle :'LINE-HEIGHT: 40px',
	    	title:'&nbsp;', 
	    	rootVisible:true,     		 
            border:true,         
            lines:true,			  
            animate:true,         
            autoScroll:true,  
            enableDD:false,    
            width: 295,
            containerScroll:true, 
            trackMouseOver:true,               
            //height:screen.height-100,
            height:parent.document.body.offsetHeight-4,
            loader:loader
    	});
    	
 
    
//    var Tree = Ext.tree;
//    var tree = new Tree.TreePanel({
//    	bodyStyle :'LINE-HEIGHT: 40px',
//    	title:'&nbsp;', 
//        el:'tree-div',
//        listeners : {
//	    	//beforeexpandnode : function(node, deep, animal) 
//	  	  	//{     
//		      	 // if (node.id != "@")   
//		      	  //{  
//		      		//Ext.Msg.alert("%%%%", "~~~~"+node.id);
//		      		//tree.loader.dataUrl='loadGoodsTree.action?pid='+EncodeUtf8(node.id)+'&hrefTarget='+EncodeUtf8($('#hrefTarget').val())+'&moduleID='+$('#moduleID').val()+'&isClosed='+$('#isClosed').val();                          
//		      		//tree.render(); 
//		      	 // }  
//	       // } , 
//            click : function(node, c) {
//    		Ext.Msg.alert("55", "66666666666");
//    	
//	    	if(node.isExpanded()) {
//	    		node.collapse(true);
//	          }else {
//	        	
//	        	  
//	        	  node.expand(node);
//	          }
//	        }
//       },
//         rootVisible:true,     		 
//                border:true,         
//                lines:true,			  
//                animate:true,         
//                autoScroll:true,      
//                enableDD:false,           
//                containerScroll:true, 
//                trackMouseOver:true, 
//                //height:screen.height-100,
//                height:parent.document.body.offsetHeight-4,
//        loader: new Tree.TreeLoader({
//        	
//        })    	 
//    });
//    
//    var root = new Tree.AsyncTreeNode({
//        text: '商品结构目录',
//        icon: 'extjs/resources/images/default/tree/frame_0.png',
//        draggable:false, 
//
//        id:'@'
//    });
//        
//    	tree.setRootNode(root);
	  	tree.on('beforeload', function(node)
        { 
 			tree.loader.dataUrl='loadGoodsTree.action?pid='+EncodeUtf8(node.id)+'&hrefTarget='+EncodeUtf8($('#hrefTarget').val())+'&moduleID='+$('#moduleID').val()+'&isClosed='+$('#isClosed').val();
 			//tree.expandPath(tree.getNodeById ('T_1').getPath());
        });
	  	tree.on('click', function(node)
	  			{ 
	  		  		
	  	 			//tree.loader.dataUrl='loadGoodsTree.action?pid='+EncodeUtf8(node.id)+'&hrefTarget='+EncodeUtf8($('#hrefTarget').val())+'&moduleID='+$('#moduleID').val()+'&isClosed='+$('#isClosed').val();
	  		
	  	 			if(node.isExpanded()) {
	  		    		node.collapse(true);
	  		          }else 
	  		          {
	  		        	
	  		        	  
//	  		        	Ext.Ajax.request({   
//	  		        		url : 'loadGoodsTree.action?pid='+EncodeUtf8(node.id)+'&hrefTarget='+EncodeUtf8($('#hrefTarget').val())+'&moduleID='+$('#moduleID').val()+'&isClosed='+$('#isClosed').val(),   
//	  		        		success : function(response, opts)
//	  		        		{   
//	  		        		
//	  		        		var child = Ext.decode(response.responseText);  
//	  		        		Ext.Msg.alert("999999", child);
//	  		        		
//	  		        		node.reload();   
//	  		        		}
//	  		        	}) ;
	  		        	refreNode();
	  		        	 // node.reload();  
	  		        	 // node.expand(node);
	  		          }

	  	        }); 
	  	

    	
        Ext.getDoc().on("contextmenu", function(e){
      	    e.stopEvent();
        });
        
        /*
        Ext.TaskMgr.start({     run:updateClock,     interval: 1000 }); 
        function updateClock(){
        	root.reload(function(node){            		
        		// node.expand(node.isExpanded(),false);

        		var path = node.getPath('id');
        		tree.getLoader().load(node,function(treeNode) { 
        		    tree.expandPath(path,'id', function(bSucess, oLastNode) {
        		        tree.getSelectionModel().select(oLastNode); 
        		    }); 
        		}, this);

        	});
        }
        */
        
    	//绑定节点右键菜单功能
        tree.on('contextmenu',function(node,event){ 
        	
              event.preventDefault(); //这行是必须的
              var nodes = node.id.split('_');
              node.select();

              if(node.id.substr(0,1)=='T'){                        // 商品类型
            	  goodsCategoryMenu(nodes[1]).showAt(event.getPoint());
              }else if(node.id.substr(0,1)=='S'){                  //制造商  
            	  if (nodes[2] == '3'){
            		  supplierMenu2(nodes[3],node.text,nodes[2]).showAt(event.getPoint());
            	  }
            	  if (nodes[2] == '4'){
            		  supplierMenu3(nodes[3],node.text,nodes[2]).showAt(event.getPoint());
            	  }
            	  if (nodes[2] != '3' && nodes[2] != '4'){
            		  supplierMenu(nodes[3],node.text,nodes[2]).showAt(event.getPoint());
            	  }
              }else if(node.id.substr(0,1)=='@'){                  //目录
            	  
              }else if(node.id.substr(0,1)=='B'){                  //品种
            	  if (nodes[3] == '3'){
            		  brandMenu2(nodes[4],nodes[5],node.text,nodes[3],'').showAt(event.getPoint());
            	  }
            	  if (nodes[3] == '4'){
            		  brandMenu3(nodes[4],nodes[5],node.text,nodes[3],'').showAt(event.getPoint());
            	  }
            	  if (nodes[3] != '3' && nodes[3] != '4'){
            		  brandMenu(nodes[4],nodes[5],node.text,nodes[3],'').showAt(event.getPoint());
            	  } 
              }

             }); 

        this.refreNode=function()
        {
        	
			var mm=tree.getSelectionModel().getSelectedNode();
			if(mm.id.substr(0,1)!='G')
			{
		        mm.reload();
		        mm.expand(mm);
			}
        }
        this.refreParentNode=function()
        {
			var mm=tree.getSelectionModel().getSelectedNode().parentNode;
			mm.select();
	        mm.reload();
	        mm.expand(mm);
        }
		
        function goodsCategoryMenu(node){            
            //商品类型定义右键菜单
            var rightClick = new Ext.menu.Menu({
                id :'rightClickCont',
                items : [{
                    id:'rMenu1',
                    text : '查看制造商列表',
                    //增加菜单点击事件
                    handler:function (){
                		var id = tree.getSelectionModel().getSelectedNode().id;
                         window.parent.mainFrame1.location='selSupplier.action?moduleID='+$('#moduleID').val()+'&goodsTree=1&goodsCategoryID='+node;
                    }
                }

                ,{
                    id:'rMenu14',
                    text : '新增制造商',
                    //增加菜单点击事件
                    handler:function (){
                		initSupplierInsert(node,$('#moduleID').val());
                    }
                }
                ]
             });
            
            return rightClick;
        }

        function initSupplierInsert(node,moduleID)
        {       	
        	$.get('',{moduleID:moduleID,selbspcategoryid:node,goodsTree:"1"},function() {

        		window.parent.mainFrame1.initSupplierInsert(moduleID,node);    
        		
        	}); 
        	 	
        }
        
        
        function supplierMenu(node,text,node2){
            //制造商定义右键菜单
            var rightClick2 = new Ext.menu.Menu({
                id :'rightClickCont2',
                items : [{
                    id:'rMenu2',
                    text : '制造商信息维护',
                    //增加菜单点击事件
                    handler:function (){
                         window.parent.mainFrame1.location='selSupplier.action?moduleID='+$('#moduleID').val()+'&supplierID='+node+'&goodsCategoryID='+node2+'&parent=1&goodsTree=1';
                    }
                }, {
                    id:'rMenu3',
                    text : '查看制造商信息',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='supplierDetail.action?moduleID='+$('#moduleID').val()+'&hid='+node;
                    }
                }, {
                    id:'rMenu4',
                    text : '查看品种列表',
                    //增加菜单点击事件
                    handler:function (){
                        window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbspcategoryid='+node2+'&selbspsuppliername='+text+'&parent=1&goodsTree=1';
                    }
                }

                , {
                    id:'rMenu17',
                    text : '新增品种',
                    //增加菜单点击事件
                    handler:function (){
                	   initBrandInsert(node2,node,text,$('#moduleID').val());
                   }

                }
                
                ]
             });
            
            return rightClick2;
        }
        
/*        
        $.ajaxSetup({   
        	async : false  
        });
*/               
        function initBrandInsert(node2,node,text,moduleID){
        	/*
        	$.get(window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbspcategoryid='+node2+'&selbspsuppliername='+text+'&goodsTree=1',function(data) {
        		window.parent.mainFrame1.insert(node2,node,text);
        	});
        	
        	$.post(window.parent.mainFrame1.location="selBrand.action",{moduleID:moduleID,selbbdsupplierid:node,selbspcategoryid:node2,selbspsuppliername:text,goodsTree:"1"},function(data) {
        		//window.parent.mainFrame1.insert(node2,node,text);
        	},"text");        	
        	
        	$.post(window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbspcategoryid='+node2+'&selbspsuppliername='+text+'&goodsTree=1',function(data) {
        		window.parent.mainFrame1.insert(node2,node,text);
        	});

        	        	*/
        	
        		//window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbspcategoryid='+node2+'&selbspsuppliername='+text+'&goodsTree=1';
        	$.get('',{moduleID:moduleID,selbbdsupplierid:node,selbspcategoryid:node2,selbspsuppliername:text,goodsTree:"1"},function() {

        		window.parent.mainFrame1.insertBrandTree(moduleID,node2,node,text);    
        		
        	}); 
        	/*
        	$.post(window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbspcategoryid='+node2+'&selbspsuppliername='+text+'&goodsTree=1',function(data) {

        		window.parent.mainFrame1.insert(node2,node,text);
        	});
         	*/       	
        }
        
        /*
        function insertBrand(node2,node,text){
        	//window.parent.mainFrame1.insert(node2,node,text);
        }
        */
        
        function supplierMenu2(node,text,node2){
            //制造商定义右键菜单
            var rightClick2 = new Ext.menu.Menu({
                id :'rightClickCont2',
                items : [{
                    id:'rMenu2',
                    text : '制造商信息维护',
                    //增加菜单点击事件
                    handler:function (){
                         window.parent.mainFrame1.location='selSupplier.action?moduleID='+$('#moduleID').val()+'&supplierID='+node+'&goodsCategoryID='+node2+'&goodsTree=1';
                    }
                }, {
                    id:'rMenu3',
                    text : '查看制造商信息',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='supplierDetail.action?moduleID='+$('#moduleID').val()+'&hid='+node;
                    }
                }, {
                    id:'rMenu4',
                    text : '查看品种列表',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbspcategoryid='+node2+'&selbspsuppliername='+text+'&goodsTree=1';
                    }
                },{
                    id:'rMenu17',
                    text : '新增品种',
                    //增加菜单点击事件
                    handler:function (){
                	   initBrandInsert(node2,node,text,$('#moduleID').val());
                   }
                }]
             });
            
            return rightClick2;
        }
       
        function supplierMenu3(node,text,node2){
            //制造商定义右键菜单
            var rightClick2 = new Ext.menu.Menu({
                id :'rightClickCont2',
                items : [{
                    id:'rMenu2',
                    text : '制造商信息维护',
                    //增加菜单点击事件
                    handler:function (){
                         window.parent.mainFrame1.location='selSupplier.action?moduleID='+$('#moduleID').val()+'&supplierID='+node+'&goodsCategoryID='+node2+'&goodsTree=1';
                    }
                }, {
                    id:'rMenu3',
                    text : '查看制造商信息',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='supplierDetail.action?moduleID='+$('#moduleID').val()+'&hid='+node;
                    }
                }, {
                    id:'rMenu4',
                    text : '查看品种列表',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbspcategoryid='+node2+'&selbspsuppliername='+text+'&goodsTree=1';
                    }
                }, {
                    id:'rMenu17',
                    text : '新增品种',
                    //增加菜单点击事件
                    handler:function (){
                	   initBrandInsert(node2,node,text,$('#moduleID').val());
                   }
                }]
             });
            
            return rightClick2;
        }
        
        function brandMenu(node,node2,text,node3,node4){
            //品种定义右键菜单
            var rightClick3 = new Ext.menu.Menu({
                id :'rightClickCont3',
                items : [{
                    id:'rMenu5',
                    text : '品种信息维护',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbbdid='+node2+'&selbbdbrandname='+text+'&selbspcategoryid='+node3+'&goodsTree=1';
                    }
                }, {
                    id:'rMenu6',
                    text : '查看品种信息',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='brandDetail.action?moduleID='+$('#moduleID').val()+'&bbdsupplierid='+node+'&hid='+node2;
                    }
                }
                ]
             });
            return rightClick3;
        }
        
        function initGoodsInsert(node,node2,text,node3,node4,moduleID)
        {       	
        	//Ext.Msg.alert("55", node+"!!"+node2+"@@"+text+"##"+node3+"$$"+node4+"%%"+moduleID);
        	$.get('',{moduleID:moduleID,supplierID:node,goodsTree:"1"},function() {
        		window.parent.mainFrame1.initGoodsInsert(node,node2,text,node3,node4,moduleID);    
        		
        	}); 
        	 	
        }
        function brandMenu2(node,node2,text,node3,node4){
            //品种定义右键菜单
            var rightClick3 = new Ext.menu.Menu({
                id :'rightClickCont7',
                items : [{
                    id:'rMenu5',
                    text : '品种信息维护',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbbdid='+node2+'&selbbdbrandname='+text+'&selbspcategoryid='+node3+'&goodsTree=1';
                    }
                }, {
                    id:'rMenu6',
                    text : '查看品种信息',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='brandDetail.action?moduleID='+$('#moduleID').val()+'&bbdsupplierid='+node+'&hid='+node2;
                    }
                }
                ]
             });
            return rightClick3;
        }
        
        function brandMenu3(node,node2,text,node3,node4){
            //品种定义右键菜单
            var rightClick3 = new Ext.menu.Menu({
                id :'rightClickCont8',
                items : [{
                    id:'rMenu5',
                    text : '品种信息维护',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='selBrand.action?moduleID='+$('#moduleID').val()+'&selbbdsupplierid='+node+'&selbbdid='+node2+'&selbbdbrandname='+text+'&selbspcategoryid='+node3+'&goodsTree=1';
                    }
                }, {
                    id:'rMenu6',
                    text : '查看品种信息',
                    //增加菜单点击事件
                    handler:function (){
                          window.parent.mainFrame1.location='brandDetail.action?moduleID='+$('#moduleID').val()+'&bbdsupplierid='+node+'&hid='+node2;
                    }
                }
                ]
             });
            return rightClick3;
        }
        
        
        
        
    	tree.render();    	
    	root.expand(); 
 	   
	});