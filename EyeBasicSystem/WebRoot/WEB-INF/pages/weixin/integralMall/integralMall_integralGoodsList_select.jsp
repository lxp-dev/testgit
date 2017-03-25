<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${weiXinDataConfigPo.wdcintroductionjifen}商城</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
</head>
<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

	function integralGoodsDetail(goodsID){
		location.href="initIntegralGoodsDetailSel.action?openID="+$('#openID').val() + "&goodsID="+goodsID;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle lv_bg">
		<!-- 爱币商城 -->
		<div class="xq">
			<!-- 爱币背景 -->
			<div class="xqtop">
				<b>我的${weiXinDataConfigPo.wdcintroductionjifen}：<i>${customerInfoPo.smeciintegral }</i></b>
				<span>兑换后将消耗相应的${weiXinDataConfigPo.wdcintroductionjifen}</span>
			</div>
			<!-- 商品需本人手持 -->
			<img src="${ctx}/weixin_personcenter/images/sp2.png"  alt="" />
			<!-- 商品基本信息 -->
			<div class="jfcx sp4bg">
				<ul>
					<c:forEach var="po" items="${goodsInfoPos}" varStatus="poIndex">
					<li onclick="integralGoodsDetail('${po.bgigoodsid }');">
						<c:choose>
							<c:when test="${po.bgipicurl ne ''}">
								<img src="${ctx}${po.bgipicurl}" alt="" />	
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
						<a class="jfcxt">
							<b>${po.bgiIntegralCount }</b>
							<p>
								<i>积 分兑 换 </i>
							</p>
						</a>
					</li>
					</c:forEach>
				</ul>
			</div>
			<!-- 商品基本信息结束 -->
			<!-- 商品详情底部背景 -->
			<div class="sp4bg"></div>
			<!-- 商品详情底部背景结束 -->
		</div>
		<!-- 商品详情结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body></html>