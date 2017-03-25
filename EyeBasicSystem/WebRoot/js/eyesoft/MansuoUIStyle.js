var MansuoUI = Class.create();
MansuoUI.VERSION="1.0";


var MansuoUIStyle = Class.create();
MansuoUIStyle.VERSION="1.0";
MansuoUIStyle.decorateButtons=function(buttons){
	for(var x=0;x<buttons.length;x++){
		var button = buttons[x];
		if(button==null){
			continue;
		}
//		if (!(/MSIE/.test(navigator.userAgent))){
//			this.style.width='100px';
//		}
		if(button.disabled && button.all.tags("IMG").length>0){
			button.all.tags("IMG")[0].style.cursor = "text";
		}
		button.onmouseover = function(){
			//this.style.borderColor = "#FFFFFF";
			this.style.backgroundColor = "#EEFFFF";
			//this.style.borderWidth = "1px";
			
		}
		button.onmouseout = function(){
			//this.style.borderColor = "#FFFFFF";
			this.style.backgroundColor = "#e0e3ef";
			//this.style.borderWidth = "1px";
		}
	}	
};
MansuoUIStyle.disableButtons=function(buttons,disable){
	for(var x=0;x<buttons.length;x++){
		var button = buttons[x];
		if(button==null){
			continue;
		}
		button.disabled = disable;
		if(button.all.tags("IMG").length>0){
		    if(disable){
				button.all.tags("IMG")[0].style.cursor = "text";
			}else{
				button.all.tags("IMG")[0].style.cursor = "hand";
			}
		}
	}	
};
MansuoUIStyle.decorateFunctionIcons=function(buttons,hoverClass,outClass){
	var hc = hoverClass?hoverClass:"FunctionIconHover";
	var oc = outClass?outClass:"FunctionIconNormal";
	for(var x=0;x<buttons.length;x++){
		var button = buttons[x];
		if(button==null){
			continue;
		}

		button.onmouseover = function(){
			this.className = hc;
			
		}
		button.onmouseout = function(){
			this.className = oc;
		}
	}	
};
MansuoUIStyle.decorateMenuButtons=function(button,menu){
//		if (!(/MSIE/.test(navigator.userAgent))){
//			this.style.width='100px';
//		}
		if(button==null){
			return;
		}
		button.onmouseover = function(){
			this.style.borderColor = "#A0C5FC";
			this.style.backgroundColor = "#EEFFFF";
			this.style.borderWidth = "1px";
			
		}
		button.onmouseout = function(){
			this.style.borderColor = "#FFFFFF";
			this.style.backgroundColor = "#FFFFFF";
			this.style.borderWidth = "1px";
			webFXMenuHandler.hideMenu(menu)
		}
		button.onblur = function(){
			webFXMenuHandler.hideMenu(menu)
		}
		button.onclick = function(){
			webFXMenuHandler.showMenu(menu, button)
		}
		
};
MansuoUIStyle.decorateActionButtons=function(buttons){
	for(var x=0;x<buttons.length;x++){
		var button = buttons[x];
		if(button==null){
			continue;
		}
		button.style.borderColor = "#A0C5FC";
		button.style.verticalAlign = "middle";
		button.style.paddingTop = "2px";
		button.onmouseover = function(){
			this.style.backgroundColor = "#EEFFFF";
			this.style.borderWidth = "1px";
			
		}
		button.onmouseout = function(){
			this.style.backgroundColor = "#FFFFFF";
			this.style.borderWidth = "1px";
		}
	}	
};
MansuoUIStyle.showReview=function(table,simg){
	if(table==null || simg==null){
		return;
	}
	if(table.tBodies[0].style.display=="none"){
		table.tBodies[0].style.display=""
		simg.src="images/review_min.gif";
		simg.title="隐藏";
	}else{
		table.tBodies[0].style.display="none";
		simg.src="images/review_max.gif";
		simg.title="显示";
	}
};

