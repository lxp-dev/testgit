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
    	WeixinJSBridge.call('hideOptionMenu');
    });

    function indexPage(){
    	location.href="initPersonCenterSel.action?openID="+$('#openID').val(); 
    }
</script>
</head>
<body class="zc_bg" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

	<div class="xf_canting xf_panle ">
    <!-- 好友信息 -->
    <div class="login_bg">
    
    <c:choose>
    	<c:when test="${errorFlag eq '1'}">
    		<!-- 弹出ERROR1 -->
    		<div class="bg01">
		      <div class="qrdh wxtc2 yq">
		        <span class="yq">邀请好友失败！</span>
		        <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
		        <p>${weiXinDataConfigPo.wdcalertyaoqingerror2}</p>
		        <input class="wxyya zxzl1" type="button" value="确 定" onclick="indexPage();">
		      </div>
		    </div>
		    <!-- 弹出结束 -->
    	</c:when>
 	    <c:when test="${errorFlag eq '2'}">
   		   <!-- 弹出ERROR2 -->
		    <div class="bg01">
		      <div class="qrdh wxtc2 yq">
		        <span class="yq">邀请好友失败！</span>
		        <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
		        <p>${weiXinDataConfigPo.wdcalertyaoqingerror1}</p>
		        <input class="wxyya zxzl1" type="button" value="提 交" onclick="indexPage();">
		      </div>
		    </div>
		    <!-- 弹出结束 -->
    	</c:when>
    </c:choose>
  </div>  
  <!-- 好友信息结束 -->
</div>
</body>
</html>