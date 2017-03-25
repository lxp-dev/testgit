<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>预约完成</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />
<script>
    function closeWindow(){   
    	WeixinJSBridge.call('closeWindow');    
    }

    function optometryAppointmentResult(){
        location.href="initWeiXinOptometryAppointmentResult.action?openID="+$('#openID').val();
    }     
</script>
</head>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
	<!-- 弹出 -->
	 <div class="bg01">
	   <div class="qrdh wxtc2 yq">
	     <span class="yq"><var></var></span>
	     <img src="${ctx}/weixin_personcenter/images/wx3.png" alt="" />
	     <p>${weiXinDataConfigPo.wdcalertyuyuesuccess}</p>
	     <input class="wxyya zxzl1" type="button" value="确 定" onclick="optometryAppointmentResult();">
	   </div>
	 </div>
	 <!-- 
	<div class="bg01">
		<div class="qrdh wxtc2">
			<span></span>
			<img src="${ctx}/weixin_personcenter/images/wx3.png" alt="" />
			<p>${weiXinDataConfigPo.wdcalertyuyuesuccess}</p>
			<input class="wxyya zxzl1" type="button" value="确 定" onclick="optometryAppointmentResult();">
		</div>
	</div>
	 -->
	<!-- 弹出结束 -->
</body>
</html>