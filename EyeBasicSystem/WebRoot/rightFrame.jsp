<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
	</head>
	<script>	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 

		window.onload=function(){ 
			$("#mm-tabcloseall").click();
			addTab("我的主页（右键点击窗口顶部可关闭任意窗口）", "initNoticeStore.action", "");
		} 
	});

</script>
	<link href="easyui/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="easyui/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/icon.css" />
    <script type="text/javascript" src="easyui/jquery.easyui.min-1.2.0.js"></script>
	<script type="text/javascript" src='easyui/outlook.js'></script>
	
	<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } class="easyui-layout" style="overflow-y: hidden"  scroll="no">
		<input type="text" id="fpsodivframetype" name="fpsodivframetype" value="${personSetOptionPo.fpsodivframetype}" />
		<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden"  style=" width:auto">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false"  style=" width:auto">
        	<div title="Home" style="padding:20px;overflow:hidden;" id="home">
			</div>
		</div>
    </div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<!--<div id="mm-tabupdate">刷新</div>
			<div class="menu-sep"></div>
		 	<div id="mm-tabclose">关闭</div>
			<div id="mm-exit">退出</div>
		 -->
		<div id="mm-tabcloseall">全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>

	</div>
				
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp"%>