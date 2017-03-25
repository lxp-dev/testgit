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
         rootVisible:true,     		 
                border:true,         
                lines:true,			  
                animate:true,         
                autoScroll:true,      
                enableDD:false,           
                containerScroll:true, 
                trackMouseOver:true, 
                height:parent.document.body.offsetHeight-4,
        loader: loader
    });

	  	tree.on('beforeload', 
        function(node)
        { 
 			tree.loader.dataUrl='loadSubjectOpenTree.action?pid='+EncodeUtf8(node.id)+'&hrefTarget='+EncodeUtf8($('#hrefTarget').val())+'&moduleID='+$('#moduleID').val();
        });    	
 
    	tree.render();    	
    	root.expand(); 
 	        	
	});

