<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物流提醒</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });  
</script>

</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
			<header><h3 class="h3bg ">配镜单号：${salesBillID}</h3></header>
		<!-- 物流提醒 -->
		<div class="xf_ctinner">
			<div class="wlbg">
				<ul>
					<c:forEach var="po" items="${inTransitStateList}" varStatus="poIndex">
						<c:if test="${!empty po.sseitdate}">
							<li ${(poIndex.index eq '0') ? 'class="wlbg2"' : 'class="wlbg1"'}><span></span><i></i><p>${po.sseitintransitname}</p><a>${fn:substring(po.sseitdate, 0, 16) }</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!-- 个人中心结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>

</body>
</html>