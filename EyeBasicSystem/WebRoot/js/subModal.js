/**
 * SUBMODAL v1.6
 * Used for displaying DHTML only popups instead of using buggy modal windows.
 *
 * By Subimage LLC
 * http://www.subimage.com
 *
 * Contributions by:
 * 	Eric Angel - tab index code
 * 	Scott - hiding/showing selects for IE users
 *	Todd Huss - inserting modal dynamically and anchor classes
 *
 * Up to date code can be found at http://submodal.googlecode.com
 */

// Popup code
var gPopupMask = null;
var gPopupContainer = null;
var gPopFrame = null;
var gReturnFunc;
var gPopupIsShown = false;
var gDefaultPage = "";
var gHideSelects = false;
var gReturnVal = null;

//--------------开窗最大化时，保留原窗口参数值   By 莫永生 2012-12-04 14:33-------------
var minTop=0;
var minLeft=0;
var minWidth=0;
var minHeight=0;
var minPopFrameWidth=0;
var minPopFrameHeight=0;
//--------------开窗最大化时，保留原窗口参数值   By 莫永生 2012-12-04 14:33-------------

//--------------关闭层时，框架调整的高、宽参数   By 莫永生 2012-10-11 11:04-------------
var closeWidth = 0;
var closeTop = 0;

//--------------当关闭层需要刷新父页面，是否关闭会色层（gPopupMask）  By 莫永生 2012-11-3 14:51-------------
var closeEvent = true;

var gTabIndexes = new Array();
// Pre-defined list of tags we want to disable/enable tabbing into
var gTabbableTags = new Array("A","BUTTON","TEXTAREA","INPUT","IFRAME");	

// If using Mozilla or Firefox, use Tab-key trap.
if (!document.all) {
	document.onkeypress = keyDownHandler;
}

/**
 * Initializes popup code on load.	
 */
function initPopUp() {
	theBody = document.getElementsByTagName('BODY')[0];
	popmask = document.createElement('div');
	popmask.id = 'popupMask';
	popcont = document.createElement('div');
	popcont.id = 'popupContainer';
	//-------------------关闭页面是否刷新父页面  BY 沈兴贺 2012-10-11-------------------------
		
		popcont.innerHTML = '' +
		'<div id="popupInner">' +
			'<div id="popupTitleBar" ondblclick="">' +
				'<div id="popupTitle"></div>' +
				'<div id="popupControls" >' +
					'<img width="0" style="display:none;" title="复位窗口" src="img/min.png" onclick="" id="popMinBox" /><img style="display:none;" title="最大化窗口" src="img/max.png" onclick="" id="popMaxBox" width="0" /><img title="关闭窗口" src="img/close2.png" height="20" onclick="" id="popCloseBox" />' +
				'</div>' +
			'</div>' +
			'<iframe src="'+ gDefaultPage +'" style="width:100%;height:100%;background-color:transparent;" scrolling="auto" frameborder="0" allowtransparency="true" id="popupFrame" name="popupFrame" width="100%" height="100%"></iframe>' +
		'</div>';

	//------------------------------------------------------------------------------------
	theBody.appendChild(popmask);
	theBody.appendChild(popcont);

	
	gPopupMask = document.getElementById("popupMask");
	gPopupContainer = document.getElementById("popupContainer");
	gPopFrame = document.getElementById("popupFrame");	
	
	// check to see if this is IE version 6 or lower. hide select boxes if so
	// maybe they'll fix this in version 7?
	var brsVersion = parseInt(window.navigator.appVersion.charAt(0), 10);
	if (brsVersion <= 6 && window.navigator.userAgent.indexOf("MSIE") > -1) {
		gHideSelects = true;
	}
	
	// Add onclick handlers to 'a' elements of class submodal or submodal-width-height
	var elms = document.getElementsByTagName('a');
	for (i = 0; i < elms.length; i++) {
		if (elms[i].className.indexOf("submodal") == 0) { 
			// var onclick = 'function (){showPopWin(\''+elms[i].href+'\','+width+', '+height+', null);return false;};';
			// elms[i].onclick = eval(onclick);
			elms[i].onclick = function(){
				// default width and height
				var width = 400;
				var height = 200;
				// Parse out optional width and height from className
				params = this.className.split('-');
				if (params.length == 3) {
					width = parseInt(params[1]);
					height = parseInt(params[2]);
				}
				showPopWin(this.href,width,height,null); return false;
			}
		}
	}
}

addEvent(window, "load", initPopUp);
 /**
	* @argument width - int in pixels
	* @argument height - int in pixels
	* @argument url - url to display
	* @argument returnFunc - function to call when returning true from the window.
	* @argument showCloseBox - show the close box - default true
	*/
function showPopWin(url, width, height, closeTopArg, closeWidthArg, returnFunc, showCloseBox) {
	if(!document.getElementById("popMaxBox")){
		initPopUp();
	}
	
	//--------------树开窗 ：  By 莫永生 2012-11-2 17:04-------------
	if(parent.document.getElementById("btmframeTmp")!=null){
		var frame = parent.document.getElementById("btmframeTmp");
		frame.cols= "0,*";
	}
	//--------------树开窗 ：  By 莫永生 2012-11-2 17:04-------------
	
	// show or hide the window close widget
	//--------------新开层时，如果父页面也为弹出层，则隐藏popupTitleBar  By 莫永生 2012-10-11 11:04-------------
	if(parent.document.getElementById("popupTitleBar")!=null){
//		parent.document.getElementById("popupTitleBar").style.display = "none";
		
	}
	//--------------新开层时，关闭层后的高、宽参数赋值  By 莫永生 2012-10-11 11:04-------------
	if(closeTop !=null){
		closeWidth=closeWidthArg;
	}
	if(closeTopArg !=null){
		closeTop=closeTopArg;
	}
	//--------------开窗最大化  莫永生 2012-12-4 13:16-------------	
	document.getElementById("popMaxBox").style.display = "block";
	document.getElementById("popMinBox").style.display = "none";
	//--------------双击弹出层的头控制开窗最大最小化  莫永生 2013-1-19 17:03-------------
	$('#popupTitleBar').bind('dblclick',function(){dblClickMaxMin();});
	$('#popMaxBox').bind('click',function(){maxSize();});
	$('#popMinBox').bind('click',function(){minSize(minTop,minLeft,minWidth,minHeight,minPopFrameWidth,minPopFrameHeight);});
	//--------------新开层时，关闭层后的高、宽参数赋值  By 莫永生 2012-10-11 11:04-------------
	if (showCloseBox == null || showCloseBox == true) {
		closeEvent = true;//--------------当关闭层需要刷新父页面，不关闭关闭会色层（gPopupMask）  By 莫永生 2012-11-3 14:51-------------
		document.getElementById("popCloseBox").style.display = "block";
		//document.getElementById("popCloseBox").attachEvent("onclick", function(){hidePopWin(true);window.document.forms(0).submit();});
		$('#popCloseBox').bind('click',function(){hidePopWin(true);$("form:first").submit();});
	} else {
		closeEvent = false;//--------------当关闭层需要刷新父页面，关闭关闭会色层（gPopupMask）  By 莫永生 2012-11-3 14:51-------------
		document.getElementById("popCloseBox").style.display = "block";
		//document.getElementById("popCloseBox").attachEvent("onclick", function(){hidePopWin(true);});
		$('#popCloseBox').bind('click',function(){hidePopWin(true);});
	}
	gPopupIsShown = true;
	disableTabIndexes();
	
	document.getElementById("popupTitleBar").style.display = "block";
	gPopupMask.style.display = "block";
	gPopupContainer.style.display = "block";
	// calculate where to place the window on screen
	centerPopWin(width, height);
	
	//var titleBarHeight= parseInt(document.getElementById("popupTitleBar").offsetHeight, 10);
	//--------------设定高为0，目的是第二层弹出框不上移  莫永生 2012-10-11 11:04-------------
	var titleBarHeight = 5;

	gPopupContainer.style.width = width + "px";
	gPopupContainer.style.height = (height+titleBarHeight) + "px";
	
	setMaskSize();

	// need to set the width of the iframe to the title bar width because of the dropshadow
	// some oddness was occuring and causing the frame to poke outside the border in IE6
	gPopFrame.style.width = parseInt(document.getElementById("popupTitleBar").offsetWidth, 10) + "px";
	gPopFrame.style.height = (height) + "px";

	//--------------最小化开窗参数赋值  莫永生 2012-12-5 13:08-------------
	minTop=gPopupContainer.style.top;
	minLeft=gPopupContainer.style.left;
	minWidth=gPopupContainer.style.width;
	minHeight=gPopupContainer.style.height;
	minPopFrameWidth=gPopFrame.style.width;
	minPopFrameHeight=gPopFrame.style.height;
	//--------------最小化开窗参数赋值  莫永生 2012-12-5 13:08-------------
	
	// set the url
	gPopFrame.src = url;
	
	gReturnFunc = returnFunc;
	// for IE
	if (gHideSelects == true) {
		hideSelectBoxes();
	}
	window.setTimeout("setPopTitle();", 600);
	//--------------初始化是否最大开窗  莫永生 2012-12-10 14:31-------------
	if(isMaxWindowOpen&&width>600){
		maxSize();
	}
	//--------------初始化是否最大开窗  莫永生 2012-12-10 14:31-------------	
}

//
var gi = 0;
function centerPopWin(width, height) {
	if (gPopupIsShown == true) {
		if (width == null || isNaN(width)) {
			width = gPopupContainer.offsetWidth;
		}
		if (height == null) {
			height = gPopupContainer.offsetHeight;
		}
		
		//var theBody = document.documentElement;
		var theBody = document.getElementsByTagName("BODY")[0];
		//theBody.style.overflow = "hidden";
		var scTop = parseInt(getScrollTop(),10);
		var scLeft = parseInt(theBody.scrollLeft,10);
	
		setMaskSize();
		
		//window.status = gPopupMask.style.top + " " + gPopupMask.style.left + " " + gi++;
		
		//var titleBarHeight = parseInt(document.getElementById("popupTitleBar").offsetHeight, 10);
		//--------------设定高为0，目的是第二层弹出框不上移  莫永生 2012-10-11 11:04-------------
		var titleBarHeight = 5;
		var fullHeight = getViewportHeight();
		var fullWidth = getViewportWidth();
		
		gPopupContainer.style.top = (scTop + ((fullHeight - (height+titleBarHeight)) / 2)) + "px";
		gPopupContainer.style.left =  (scLeft + ((fullWidth - width) / 2)) + "px";
		//alert(fullWidth + " " + width + " " + gPopupContainer.style.left);
	}
}
addEvent(window, "resize", centerPopWin);
addEvent(window, "scroll", centerPopWin);
window.onscroll = centerPopWin;

//--------------双击弹出层的头控制开窗最大最小化  莫永生 2013-1-19 17:03-------------
function dblClickMaxMin(){
	if(document.getElementById("popMaxBox").style.display == "none"){
		minSize(minTop,minLeft,minWidth,minHeight,minPopFrameWidth,minPopFrameHeight);
	}else{
		maxSize();
	}
}

//--------------开窗最大化  莫永生 2012-12-4 13:16-------------
function maxSize() {

	document.getElementById("popMaxBox").style.display = "none";
	document.getElementById("popMinBox").style.display = "block";
	
	var theBody = document.getElementsByTagName("BODY")[0];			
	var fullHeight = getViewportHeight();
	var fullWidth = getViewportWidth();
	
	// Determine what's bigger, scrollHeight or fullHeight / width
	if (fullHeight > theBody.scrollHeight) {
		popHeight = theBody.scrollHeight;
	} else {
		popHeight = fullHeight;
	}
	
	if (fullWidth > theBody.scrollWidth) {
		popWidth = theBody.scrollWidth;
	} else {
		popWidth = fullWidth;
	}
	
	gPopupContainer.style.top=parseInt(getScrollTop(),10)-5;
	gPopupContainer.style.left=parseInt(theBody.scrollLeft,10)-1;
	gPopupContainer.style.width = popWidth;
	gPopupContainer.style.height = popHeight-4;
	gPopFrame.style.width = popWidth-2;
	gPopFrame.style.height = popHeight-32;
	
    
}
//--------------开窗最小化  莫永生 2012-12-4 13:16-------------
function minSize(minTop,minLeft,minWidth,minHeight,minPopFrameWidth,minPopFrameHeight) {	
	gPopupContainer.style.top = minTop;
	gPopupContainer.style.left = minLeft;
	gPopupContainer.style.width = minWidth;
	gPopupContainer.style.height = minHeight;
	gPopFrame.style.width = minPopFrameWidth;
	gPopFrame.style.height = minPopFrameHeight;	

	document.getElementById("popMinBox").style.display = "none";
	document.getElementById("popMaxBox").style.display = "block";
}
/**
 * Sets the size of the popup mask.
 *
 */
function setMaskSize() {
	var theBody = document.getElementsByTagName("BODY")[0];
			
	var fullHeight = getViewportHeight();
	var fullWidth = getViewportWidth();

	// Determine what's bigger, scrollHeight or fullHeight / width
	if (fullHeight > theBody.scrollHeight) {
		popHeight = fullHeight;
	} else {
		popHeight = theBody.scrollHeight;
	}
	
	if (fullWidth > theBody.scrollWidth) {
		popWidth = fullWidth;
	} else {
		popWidth = theBody.scrollWidth;
	}
	
	gPopupMask.style.height = popHeight + "px";
	gPopupMask.style.width = popWidth + "px";
	
}

/**
 * @argument callReturnFunc - bool - determines if we call the return function specified
 * @argument returnVal - anything - return value 
 */
function hidePopWin(callReturnFunc) {
	//--------------树开窗 ：  By 莫永生 2012-11-2 17:04-------------
	if(parent.document.getElementById("btmframeTmp")!=null){
		var frame = parent.document.getElementById("btmframeTmp");
		frame.cols= "300,*";
	}
	//--------------树开窗 ：  By 莫永生 2012-11-2 17:04-------------
	
	if(parent.document.getElementById("popupTitleBar")!=null){
		parent.document.getElementById("popupTitleBar").style.display = "block";
	}
	
	//--------------恢复框架布局 By 莫永生 2012-10-11 11:04-------------
		var frame = top.document.getElementById("total");
		frame.rows= closeTop;
		var frame = top.document.getElementById("btmframe");
		frame.cols= closeWidth;
			
		//alert(frame.cols);
	//--------------恢复框架布局 By 莫永生 2012-10-11 11:04-------------
	
	gPopupIsShown = false;
	var theBody = document.getElementsByTagName("BODY")[0];
	theBody.style.overflow = "";
	restoreTabIndexes();
	if (gPopupMask == null) {
		return;
	}
	//--------------当关闭层需要刷新父页面，不关闭灰色层。不需要刷新，关闭灰色层  By 莫永生 2012-11-3 14:51-------------
	if(closeEvent == false){
		gPopupMask.style.display = "none";
	}
	//--------------当关闭层需要刷新父页面，不关闭灰色层。不需要刷新，关闭灰色层  By 莫永生 2012-11-3 14:51-------------
	//--------------恢复框架布局 By 莫永生 2012-10-11 11:04-------------
	gPopupContainer.style.display = "none";
	if (callReturnFunc == true && gReturnFunc != null) {
		// Set the return code to run in a timeout.
		// Was having issues using with an Ajax.Request();
		gReturnVal = window.frames["popupFrame"].returnVal;
		window.setTimeout('gReturnFunc(gReturnVal);', 1);
	}
	gPopFrame.src = gDefaultPage;
	// display all select boxes
	if (gHideSelects == true) {
		displaySelectBoxes();
	}
}

/**
 * Sets the popup title based on the title of the html document it contains.
 * Uses a timeout to keep checking until the title is valid.
 */
function setPopTitle() {
	return;
	if (window.frames["popupFrame"].document.title == null) {
		window.setTimeout("setPopTitle();", 10);
	} else {
		document.getElementById("popupTitle").innerHTML = window.frames["popupFrame"].document.title;
	}
	
}

// Tab key trap. iff popup is shown and key was [TAB], suppress it.
// @argument e - event - keyboard event that caused this function to be called.
function keyDownHandler(e) {
    if (gPopupIsShown && e.keyCode == 9)  return false;
}

// For IE.  Go through predefined tags and disable tabbing into them.
function disableTabIndexes() {
	if (document.all) {
		var i = 0;
		for (var j = 0; j < gTabbableTags.length; j++) {
			var tagElements = document.getElementsByTagName(gTabbableTags[j]);
			for (var k = 0 ; k < tagElements.length; k++) {
				gTabIndexes[i] = tagElements[k].tabIndex;
				tagElements[k].tabIndex="-1";
				i++;
			}
		}
	}
}

// For IE. Restore tab-indexes.
function restoreTabIndexes() {
	if (document.all) {
		var i = 0;
		for (var j = 0; j < gTabbableTags.length; j++) {
			var tagElements = document.getElementsByTagName(gTabbableTags[j]);
			for (var k = 0 ; k < tagElements.length; k++) {
				tagElements[k].tabIndex = gTabIndexes[i];
				tagElements[k].tabEnabled = true;
				i++;
			}
		}
	}
}


/**
 * Hides all drop down form select boxes on the screen so they do not appear above the mask layer.
 * IE has a problem with wanted select form tags to always be the topmost z-index or layer
 *
 * Thanks for the code Scott!
 */
function hideSelectBoxes() {
  var x = document.getElementsByTagName("SELECT");

  for (i=0;x && i < x.length; i++) {
    x[i].style.visibility = "hidden";
  }
}

/**
 * Makes all drop down form select boxes on the screen visible so they do not 
 * reappear after the dialog is closed.
 * 
 * IE has a problem with wanting select form tags to always be the 
 * topmost z-index or layer.
 */
function displaySelectBoxes() {
  var x = document.getElementsByTagName("SELECT");

  for (i=0;x && i < x.length; i++){
    x[i].style.visibility = "visible";
  }
}

//--------------新开层时，调用的函数  By 莫永生 2012-10-11 11:04-------------
function returnRefresh(returnVal) {
	
	document.body.style.overflow='hidden';	//父页面滚动条不显示
	//--------------调整框架布局，当前页面为满屏 By 莫永生 2012-10-11 11:04-------------	
		var frame = top.document.getElementById("total");
		frame.rows="0,8,*,0";
		var frame = top.document.getElementById("btmframe");
		frame.cols= "0,8,*";
	//--------------调整框架布局，当前页面为满屏 By 莫永生 2012-10-11 11:04-------------
		
		
	// window.document.reload();
	//alert(returnVal);

	 if(returnVal){
	 	
		}
}

//--------------判断浏览器是否为IPAD  By 莫永生 2012-10-15 12:22-------------
function is_iPad(){
//	var ua = navigator.userAgent.toLowerCase();
//	if(ua.match(/iPad/i)=="ipad") {
//		return true;
//	} else {
//		return false;
//	}
	
	var browser={ 
		    versions:function(){ 
		            var u = navigator.userAgent, app = navigator.appVersion; 
		            return {         //移动终端浏览器版本信息 
		                 trident: u.indexOf('Trident') > -1, //IE内核 
		                presto: u.indexOf('Presto') > -1, //opera内核 
		                webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核 
		                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核 
		                mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端 
		                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端 
		                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或uc浏览器 
		                iPhone: u.indexOf('iPhone') > -1 , //是否为iPhone或者QQHD浏览器 
		                iPad: u.indexOf('iPad') > -1, //是否iPad 
		                webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部 
		            }; 
		         }(), 
		         language:(navigator.browserLanguage || navigator.language).toLowerCase() 
		} 
	//	alert("语言版本: "+browser.language); 
	//	alert(" 是否为移动终端: "+browser.versions.mobile); 
	//	alert(" ios终端: "+browser.versions.ios); 
	//	alert(" android终端: "+browser.versions.android); 
	//	alert(" 是否为iPhone: "+browser.versions.iPhone); 
	//	alert(" 是否iPad: "+browser.versions.iPad); 
	//	alert(navigator.userAgent); 
	
	return browser.versions.mobile;
}


function insertBrandTree(moduleID,selbspcategoryid,selbbdsupplierid,selbspsuppliername){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initBrandInsert.action?moduleID="+moduleID+"&selbbdsupplierid="+selbbdsupplierid+"&selbspcategoryid="+selbspcategoryid+"&selbspsuppliername="+EncodeUtf8(selbspsuppliername)+"&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}else{
		showPopWin("initBrandInsert.action?moduleID="+moduleID+"&selbbdsupplierid="+selbbdsupplierid+"&selbspcategoryid="+selbspcategoryid+"&selbspsuppliername="+EncodeUtf8(selbspsuppliername)+"&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}
	document.getElementById('popupTitle').innerHTML="【"+ selbspsuppliername +"：品种新增】";
	
}

function initSupplierInsert(moduleID,selbspcategoryid){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initSupplierInsert.action?moduleID="+moduleID+"&selbspcategoryid="+selbspcategoryid+"&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}else{
		showPopWin("initSupplierInsert.action?moduleID="+moduleID+"&selbspcategoryid="+selbspcategoryid+"&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}
	document.getElementById('popupTitle').innerHTML="【制造商新增】";
	
}

function initPersonInsertByDept(moduleID,departmentId,departmentName,roleid,roleName){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initPersonInfoInsert.action?moduleID="+moduleID+"&deptid="+departmentId+"&deptName="+EncodeUtf8(departmentName)+"&roleid="+roleid+"&roleName="+EncodeUtf8(roleName)+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}else{
		showPopWin("initPersonInfoInsert.action?moduleID="+moduleID+"&deptid="+departmentId+"&deptName="+EncodeUtf8(departmentName)+"&roleid="+roleid+"&roleName="+EncodeUtf8(roleName)+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}
	document.getElementById('popupTitle').innerHTML="【人员新增】";
}

function initDepartmentInsert(moduleID){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initDepartmentInsert.action?parent=1&goodsTree=1&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}else{
		showPopWin("initDepartmentInsert.action?parent=1&goodsTree=1&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}		
	document.getElementById('popupTitle').innerHTML="【部门新增】";
}

function initGoodsInsert(node,node2,text,node3,node4,moduleID)
{
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		if(node3=="1")
		{
			showPopWin("initGlassesFrameInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="2")
		{
			showPopWin("initGlassesAccessoriesInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="3")
		{
			if (node4 == '0')
			{   //成品
				showPopWin("initLensFinishedInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
	    	}else
	    	{
	    		showPopWin("initLensCustomInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);	    		
	    	}
		}
		if(node3=="4")
		{
			if (node4 == '0')
			{   //成品
				showPopWin("initStealthFinishedInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
	    	}else
	    	{
	    		showPopWin("initStealthCustomLensesInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);	    		
	    	}
		}
		if(node3=="5")
		{
			showPopWin("initStealthAccessoriesInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="6")
		{
			showPopWin("initGlassesFinishInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="7")
		{
			showPopWin("initOtherGoodsInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="8")
		{
			showPopWin("initPresbyopicGlassesInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="9")
		{
			
			showPopWin("initVisualOpticsInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
	
	}else{
		if(node3=="1")
		{
			showPopWin("initGlassesFrameInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="2")
		{
			showPopWin("initGlassesAccessoriesInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="3")
		{
			if (node4 == '0')
			{   //成品
				showPopWin("initLensFinishedInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
	    	}else
	    	{
	    		showPopWin("initLensCustomInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);	    		
	    	}
		}
		if(node3=="4")
		{
			if (node4 == '0')
			{   //成品
				showPopWin("initStealthFinishedInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
	    	}else
	    	{
	    		showPopWin("initStealthCustomLensesInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);	    		
	    	}
		}
		if(node3=="5")
		{
			showPopWin("initStealthAccessoriesInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="6")
		{
			showPopWin("initGlassesFinishInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="7")
		{
			showPopWin("initOtherGoodsInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="8")
		{
			showPopWin("initPresbyopicGlassesInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		if(node3=="9")
		{
			showPopWin("initVisualOpticsInsert.action?moduleID="+moduleID+"&brandID="+node2+"&brandName="+EncodeUtf8(text)+"&supplierID="+node+"&parent=1&goodsTree=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
	}
	document.getElementById('popupTitle').innerHTML="【商品新增】";
	
}




