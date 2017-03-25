<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>消息中心</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    }); 

    function myCaseHistory(){
        location.href="initMyCaseHistorySel.action?openID="+$('#openID').val();
    }  

    function salesBill(){
        location.href="initWeiXinDzSalesBillSel.action?openID="+$('#openID').val();
    }  

    function fucha(){
        location.href="initWeiXinFuchaSel.action?openID="+$('#openID').val();
    }   

    function newsContent(){
        location.href="initNewsContentSel.action?openID="+$('#openID').val();
    }  

    function optometryAppointmentResult(){
        location.href="initWeiXinOptometryAppointmentResult.action?openID="+$('#openID').val();
    }        
</script>
</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<!-- 消息中心-->
		<div class="xf_ctinner">
			<span class="h3bg "></span>
			<div class="xxzx">
				<ul>
					<li class="ht2" onclick="salesBill();"> 
						<span class="xx1"></span>
						<i class="xxwz">物流提醒</i>
						<a class="xxjt" href=""></a>
					</li>
					<li class="ht2" onclick="fucha();">
						<span class="xx2"></span>
						<i class="xxwz">复查提醒</i>
						<a class="xxjt" href=""></a>
					</li>
					<li class="ht2" onclick="myCaseHistory();">
					<span class="xx3"></span>
						<i class="xxwz">${weiXinDataConfigPo.wdcintroductionzuixinyizhu}</i>
						<a class="xxjt" href=""></a>
					</li>
					<li class="ht2" onclick="newsContent();">
						<span class="xx4"></span>
						<i class="xxwz">最新技术分享</i>
						<a class="xxjt" href=""></a>
					</li>
					<li class="ht2" onclick="optometryAppointmentResult();">
						<span class="xx5"></span>
						<i class="xxwz">我的预约信息</i>
						<a class="xxjt" href=""></a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 消息中心结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>