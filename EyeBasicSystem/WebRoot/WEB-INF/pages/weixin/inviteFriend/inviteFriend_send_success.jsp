<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>好友信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<script>    

	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.call('showOptionMenu');
	}); 
	
    function indexPage(){
    	location.href="initPersonCenterSel.action?openID="+$('#openID').val(); 
    }
</script>
</head>
<body class="xf_zt" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

	<div class="loading"></div>
	<div class="xf_canting xf_panle ">
		<!-- 好友信息 -->
		<div class="xq" style="position: relative;">
			<img src="${ctx}/weixin_personcenter/images/fx1.gif"  alt="" />
			<div class="xf_wz">
				<!--文章内容  -->
				${yqhysuccessstr}
			</div>
      		<div class="er_bg">
			<img src="${ctx}/weixin_personcenter/images/fx2_01.jpg"  alt="" />
            <div class="er_ico">
            <p class="er_left"><img src="http://open.weixin.qq.com/qr/code/?username=${toUserName}"  alt="" /></p>
            <p class="er_right"><img src="${ctx}/weixin_personcenter/images/fx2_04.jpg"  alt="" /></p>
            </div>
            <img src="${ctx}/weixin_personcenter/images/fx2_06.jpg"  alt="" />       
      	</div>			
		</div>
	</div>
</body>
</html>