<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>最新活动</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.call('hideOptionMenu');
	}); 
	
	function link(contentID){
		location.href="initUserCmsContentDetails.action?openID="+$('#openID').val() + "&hid="+contentID;
	}

</script>

</head>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle ">
		<!-- 最新活动 -->
		<div class="xq ">
			<div class="zxzt">
				<!-- 最新活动栏目1 -->
				<c:forEach var="po" items="${newsContentList}" varStatus="poIndex">
				<div class="zxbg2" onclick="link('${po.wcmscid}')">
					<div class="zxzp">
						<!-- span里放图片 -->
						<span><img src="${ctx}${po.wcmscpicurl}"  alt="" /></span>
					</div> 
					<div class="zxjs2">
						<span>
							<c:choose> 
							    <c:when test="${fn:length(po.wcmsctitle) > 10}"> 
							     <c:out value="${fn:substring(po.wcmsctitle, 0, 10)}..." /> 
							    </c:when> 
							    <c:otherwise> 
							     <c:out value="${po.wcmsctitle}" /> 
							    </c:otherwise>
						    </c:choose>
						</span>
						<b>${fn:substring(po.wcmsccreatedate, 0, 10) }</b>
					</div>
					<a class="zxyb2"><img src="${ctx}/weixin_personcenter/images/zxhd2.png"  alt="" /></a>
				</div>
				</c:forEach>
			</div>
		</div>

		<!-- 商品详情结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>

</body>
</html>