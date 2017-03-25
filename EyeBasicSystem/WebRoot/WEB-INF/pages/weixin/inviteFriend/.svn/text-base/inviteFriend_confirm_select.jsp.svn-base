<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>推荐好友</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

    function confirmSend(){
        location.href="initWeiXinInviteFriendSend.action?openID="+$('#openID').val();
    }    

    function indexPage(){
    	location.href="initPersonCenterSel.action?openID="+$('#openID').val(); 
    }
</script>
</head>
<body class="lv_bg" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
	<div class="xf_canting xf_panle">
		<!-- 推荐好友 -->
		<div class="thy">
			<p>${yqhytitle}</p>
		</div>
		<div class="thya"></div>
		<div class="thya2">
		<input class="zxanz zxzl1" type="button" value="是的，我推荐" onclick="confirmSend();" /></br>
		<input class="zxanr zxzl1" type="button" value="不，我放弃" onclick="indexPage();" />
		</div>

		<!-- 推荐好友结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>