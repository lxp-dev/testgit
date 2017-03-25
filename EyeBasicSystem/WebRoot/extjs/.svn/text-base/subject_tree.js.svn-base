var tree;
var root;

Ext.onReady(function(){

    Ext.BLANK_IMAGE_URL = 'extjs/resources/images/gray/s.gif'; 
    var loader=new Ext.tree.TreeLoader(
        	{
        	
        	});
    root = new Ext.tree.AsyncTreeNode({
        text: '会计科目目录',
        icon: 'extjs/resources/images/default/tree/frame_0.png',
        draggable:false, 
        id:'S_1_1',
        loader:loader
    });
    
    tree = new Ext.tree.TreePanel({
    	bodyStyle :'LINE-HEIGHT: 40px',
    	title:'&nbsp;',
    	renderTo:"tree-div",
    	root:root,
//        el:'tree-div',
//        autoLoad:'loadSubjectTree.action?pid='+EncodeUtf8(node.id)+'&hrefTarget='+EncodeUtf8($('#hrefTarget').val())+'&moduleID='+$('#moduleID').val(),
         rootVisible:true,     		 
                border:true,         
                lines:true,			  
                animate:true,         
                autoScroll:true,      
                enableDD:false,           
                containerScroll:true, 
                trackMouseOver:true, 
                //height:screen.height-100,
                height:parent.document.body.offsetHeight-4,
        loader: loader
    });
    
       
 //   	tree.setRootNode(root);
	  	tree.on('beforeload', 
        function(node)
        { 
 			tree.loader.dataUrl='loadSubjectTree.action?pid='+EncodeUtf8(node.id)+'&hrefTarget='+EncodeUtf8($('#hrefTarget').val())+'&moduleID='+$('#moduleID').val();
        });    	
	  	
	  	tree.on('click', function(node)
	  			{ 
	  	 			if(node.isExpanded()) {
	  		    		node.collapse(true);
	  		          }else 
	  		          {
	  		        	//refreNode();
	  		        	node.expand(node);
	  		          }

	  	        }); 
	  	
	  	
        Ext.getDoc().on("contextmenu", function(e){
      	    e.stopEvent();
        });
        
    	//绑定节点右键菜单功能
        tree.on('contextmenu',function(node,event){        	
              event.preventDefault(); //这行是必须的
              var nodes = node.id.split('_');
              node.select();
              if (Boolean(node.leaf)){
            	  subjectMenu2(nodes[2],node.text,node.id).showAt(event.getPoint());
              }else{
            	  subjectMenu(nodes[2],node.text,node.id).showAt(event.getPoint());
              }
        }); 

        function subjectMenu(node,text,node2){            
            //商品类型定义右键菜单
            var rightClick = new Ext.menu.Menu({
                id :'rightClickCont',
                items : [{
                    id:'rMenu1',
                    text : '科目信息维护',
                    handler:function (){
                         window.parent.mainFrame1.location='selSubjectSet.action?moduleID='+$('#moduleID').val()+'&hid='+node+"&treeFlag=1&parentID="+node2;
                    }
                },{
                    id:'rMenu2',
                    text : '查看明细科目',
                    handler:function (){
                	     window.parent.mainFrame1.location='selSubjectSet.action?moduleID='+$('#moduleID').val()+'&parent=1&parentSubjectID='+node+'&parentSubjectName='+text+"&parentID="+node2;
                    }
                },{
                    id:'rMenu3',
                    text : '新增科目',
                    handler:function (){
                         window.parent.mainFrame1.insert(node,text,node2,'');
                    }
                }]
             });
            
            return rightClick;
        }
        
        function subjectMenu2(node,text,node2){            
            //商品类型定义右键菜单
            var rightClick = new Ext.menu.Menu({
                id :'rightClickCont2',
                items : [{
                    id:'rMenu4',
                    text : '科目信息维护',
                    handler:function (){
                         window.parent.mainFrame1.location='selSubjectSet.action?moduleID='+$('#moduleID').val()+'&hid='+node+"&treeFlag=1&parentID="+node2;
                    }
                },{
                    id:'rMenu5',
                    text : '新增科目',
                    handler:function (){
                	window.parent.mainFrame1.insert(node,text,node2,'1');
                    }
                }]
             });
            
            return rightClick;
        }
        
        this.refreNode=function()
        {     
        	try{
        		var mm=tree.getSelectionModel().getSelectedNode();    	
    	        mm.reload();
    	        mm.expand(mm);  
        	}catch(error){
        		var mm = root;
        		mm.select();
                mm.reload();
                mm.expand(mm);
        	}

        }
        this.refreParentNode=function()
        {
        	try{
        		var mm=tree.getSelectionModel().getSelectedNode().parentNode;
        		mm.select();
                mm.reload();
                mm.expand(mm);
        	}catch(error){
        		var mm = root;
        		mm.select();
                mm.reload();
                mm.expand(mm);
        	}

        }
 
    	tree.render();    	
    	root.expand(); 
 	        	
	});

    function checkchange(node,nodeID){
    	node.eachChild(function(node){
		    if (node.hasChildNodes()) {   
		        node.eachChild(function(child) {   
					if (child.id == nodeID){
						node1 = child.getPath();
					}  
		            child.fireEvent('checkchange', child);
		        });   
			} 
		    node.fireEvent('checkchange', node);
		});   	
    }
    
   

    function findchildnode(node,nodeID){ 
    	var childnodes = node.childNodes; 
    	for(var i=0;i<childnodes.length;i++){
    		var rootnode = roonodes[i];
    		if (rootnode.id == nodeID){ 
    			rootnode.checked = true;
    			rootnode.parentNode.checked = true;
    			return rootnode;
    		}
//    		alert(rootnode.text);
    		if(rootnode.childNodes.length>0){ 
    			findchildnode(rootnode);
    		}
    	}
    }
	function updateTree(nodeID){
//		alert(nodeID)
		
//        var roonodes = tree.getRootNode().childNodes;   //获取主节点 
//		var rootnode = findchildnode(roonodes,nodeID);  //开始递归 
//
//		alert(rootnode.getPath())
		
//		tree.expandAll();
//		var selNodes = tree.getChecked(); 
//		Ext.each(selNodes, function(node){ 
//			alert(node.id); 
//		});
//		tree.collapseAll();
		
		
//		var node1 = checkchange(root,nodeID);
		
//		root.eachChild(function(node){
//		    if (node.hasChildNodes()) {   
//		        node.eachChild(function(child) {   
//					if (child.id == nodeID){
//						node1 = child.getPath();
//					}  
//		            child.fireEvent('checkchange', child);
//		        });   
//			} 
//		    node.fireEvent('checkchange', node);
//		});

		
//		var node1 = root.findChild(id,nodeID);				
//		alert(node1);
		
		root.reload(function(node){
			if (nodeID != '' && nodeID != null && tree.getNodeById(nodeID) != null){
				tree.expandPath(tree.getNodeById(nodeID).getPath());
			}
		});
		
		
		
//		root.cascade(function(child){
//			if (child.id == nodeID){
//				node1 = child.getPath();
//			}
//		});
//		alert(node1);
		
	}

