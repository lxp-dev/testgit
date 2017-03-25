<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<SCRIPT type="text/javascript">
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.call('showOptionMenu');
	}); 
</SCRIPT>

</head>
<body class="lv_bg" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle lv_bg">
		<!-- 文章页面 -->
		<div class="wzy">
			<h1>${weiXinCmsContentPo.wcmsctitle }</h1>
			<span>${fn:substring(weiXinCmsContentPo.wcmsccreatedate, 0, 10) }</span>
			<p>
				<c:if test="${weiXinCmsContentPo.wcmscpicurl ne '' && weiXinCmsContentPo.wcmscpicisshow eq '1'}" >
					<img src="${ctx}${weiXinCmsContentPo.wcmscpicurl}" style="max-width: 100%; height: auto !important" border="0"/>
				</c:if>
				${weiXinCmsContentPo.wcmsccontent}
			</p>
		</div>
		<!-- 文章页面结束 -->
		<c:if test="${openID ne ''}" >
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
		</c:if>
	</div>
</body>
</HTML>