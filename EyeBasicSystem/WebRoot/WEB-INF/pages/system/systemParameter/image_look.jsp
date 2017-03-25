<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css"> 
body { font-family: "Verdana", "Arial", "Helvetica", "sans-serif"; font-size: 12px; line-height: 180%; } 
td { font-size: 12px; line-height: 150%; } 
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script type="text/javascript" src="/WebReport/ReportServer?op=emb&resource=finereport.js"></script>
<SCRIPT language=JavaScript> 
	drag = 0 
	move = 0 
	
	// 拖拽对象 
	// 参见：http://blog.sina.com.cn/u/4702ecbe010007pe 
	var ie=document.all; 
	var nn6=document.getElementById&&!document.all; 
	var isdrag=false; 
	var y,x; 
	var oDragObj; 

	function moveMouse(e) { 
		if (isdrag) { 
			oDragObj.style.top = (nn6 ? nTY + e.clientY - y : nTY + event.clientY - y)+"px"; 
			oDragObj.style.left = (nn6 ? nTX + e.clientX - x : nTX + event.clientX - x)+"px"; 
			return false; 
		} 
	} 	

	function initDrag(e) { 
		var oDragHandle = nn6 ? e.target : event.srcElement; 
		var topElement = "HTML"; 
		while (oDragHandle.tagName != topElement && oDragHandle.className != "dragAble") { 
			oDragHandle = nn6 ? oDragHandle.parentNode : oDragHandle.parentElement; 
		} 
		if (oDragHandle.className=="dragAble") { 
			isdrag = true; 
			oDragObj = oDragHandle; 
			nTY = parseInt(oDragObj.style.top+0); 
			y = nn6 ? e.clientY : event.clientY; 
			nTX = parseInt(oDragObj.style.left+0); 
			x = nn6 ? e.clientX : event.clientX; 
			document.onmousemove=moveMouse; 
			return false; 
		} 
	} 
	document.onmousedown=initDrag; 
	document.onmouseup=new Function("isdrag=false"); 

	function clickMove(s){ 
		if(s=="up"){ 
			dragObj.style.top = parseInt(dragObj.style.top) + 100; 
		}else if(s=="down"){ 
			dragObj.style.top = parseInt(dragObj.style.top) - 100; 
		}else if(s=="left"){ 
			dragObj.style.left = parseInt(dragObj.style.left) + 100; 
		}else if(s=="right"){ 
			dragObj.style.left = parseInt(dragObj.style.left) - 100; 
		} 
	
	} 

	function smallit(){ 
		var height1=images1.height; 
		var width1=images1.width; 
		images1.height=height1/1.2; 
		images1.width=width1/1.2; 
	} 

	function bigit(){ 
		var height1=images1.height; 
		var width1=images1.width; 
		images1.height=height1*1.2; 
		images1.width=width1*1.2; 
	} 
	function realsize() 
	{ 
		images1.height=images2.height; 
		images1.width=images2.width; 
		block1.style.left = 0; 
		block1.style.top = 0; 
	
	} 
	function featsize() 
	{ 
		var width1=images2.width; 
		var height1=images2.height; 
		var width2=360; 
		var height2=200; 
		var h=height1/height2; 
		var w=width1/width2; 
		if(height1<height2&&width1<width2) 
		{ 
			images1.height=height1; 
			images1.width=width1; 
		} 
		else 
		{ 
			if(h>w) 
			{ 
				images1.height=height2; 
				images1.width=width1*height2/height1; 
			} 
		else 
		{ 
			images1.width=width2; 
			images1.height=height1*width2/width1; 
		} 
	} 
		block1.style.left = 0; 
		block1.style.top = 0; 
} 

 /***********************
  * 函数：判断滚轮滚动方向
  * 作者：walkingp
  * 参数：event
  * 返回：滚轮方向 1：向上 -1：向下
 *************************/

 var scrollFunc=function(e){
     var direct=0;
     e=e || window.event;
     if(e.wheelDelta){//IE/Opera/Chrome
     	if(e.wheelDelta>0){
     		smallit();
     	}else{
     		bigit();
     	}
     }else if(e.detail){//Firefox
         if(e.detail>0){
     		smallit();
     	}else{
     		bigit();
     	}
     }
     //ScrollText(direct);
 }
 /*注册事件*/
 if(document.addEventListener){
     document.addEventListener('DOMMouseScroll',scrollFunc,false);
 }//W3C
 window.onmousewheel=document.onmousewheel=scrollFunc;


function keygo(){
	key = window.event.keyCode; 
	if (key==38){//↑
		clickMove('down');
	}
	
	if (key==40){//↓
		clickMove('up');
	}
	
	if (key==37){//←
		clickMove('right');
	}
	
	if (key==39){//→
		clickMove('left');
	}
}

	$(document).ready(function (){
		wsize();
	});
	
	function wsize(){
		$("div[id=block1]").attr("style","z-index:10; height: 0; left: "+(document.getElementsByTagName('BODY')[0].clientWidth-600)/2+"px; position: absolute; top: "+(document.getElementsByTagName('BODY')[0].clientHeight-400)/2+"px; width: 0");
	}

</SCRIPT> 
<style type="text/css"> 
<!-- 
td, a { font-size:12px; color:#000000 } 
#Layer1 { position:absolute; z-index:100; top: 70px; } 
#Layer2 { position:absolute; z-index:1; } 
--> 
</style> 
</head> 
<body onkeydown="keygo()" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"  ondragstart="return false" onselectstart ="return false" onselect="document.selection.empty()" oncopy="document.selection.empty()" onbeforecopy="return false" onmouseup="document.selection.empty()" style="overflow-y:hidden;overflow-x:hidden;"> 

<p>

<div id='hiddenPic' style='position:absolute; left:0px; top:0px; width:0px; height:0px; z-index:1; visibility: hidden;'><img width="${width }" height="${height }" name='images2' src='${id }' border='0'></div> 
<div id='block1' onmouseout='drag=0' onmouseover='dragObj=block1; drag=1;' style='z-index:10; height: 0; left: 0px; position: absolute; top: 0px; width: 0;' class="dragAble"> <img name='images1' width="${width }" height="${height }" src='${id }' border='1'></div> 
</body> 
</html>