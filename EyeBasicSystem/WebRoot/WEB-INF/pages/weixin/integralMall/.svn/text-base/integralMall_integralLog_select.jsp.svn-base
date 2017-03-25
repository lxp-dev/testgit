<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="getText('jifen.jifen')"/>记录</title>
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

<div class="xf_canting xf_panle ">
    <!-- 爱币商城 -->
    <div class="jfjl">
      <div class="jfbt">
        <a>日  期</a>
        <a>${weiXinDataConfigPo.wdcintroductionjifen}类型</a>
        <a>发生${weiXinDataConfigPo.wdcintroductionjifen}</a>
        <a style="background:none;">${weiXinDataConfigPo.wdcintroductionjifen}剩余</a>
      </div>
      <div class="jfnr">
        <ul>
          <c:forEach var="po" items="${salesBasicList}" varStatus="poIndex">
          <li ${integraltype eq '清除爱币' ? 'style="background-color: red;"':''}>
            <span>${fn:substring(po.integraldate, 0, 10)}</span>
            <span>
			<c:choose>
	           <c:when test="${po.integraltype=='消费累计' && po.ssesbcheckoutflag == '3'}">结款</c:when>
	           <c:when test="${po.integraltype=='消费累计' && po.ssesbcheckoutflag == '4'}">退款</c:when>
	           <c:when test="${po.integraltype=='消费累计' && po.ssesbcheckoutflag == '5'}">补齐欠款</c:when>
	           <c:when test="${po.integraltype=='消费累计' && po.ssesbcheckoutflag == '6'}">订金</c:when>
	           <c:when test="${po.integraltype=='清除积分'}">清除${weiXinDataConfigPo.wdcintroductionjifen}</c:when>
	           <c:when test="${po.integraltype=='积分兑换'}">${weiXinDataConfigPo.wdcintroductionjifen}兑换</c:when>
	           <c:when test="${po.integraltype=='积分赠送'}">${weiXinDataConfigPo.wdcintroductionjifen}赠送</c:when>
	           <c:when test="${po.integraltype=='会员升级'}">会员升级</c:when>
			</c:choose>
			</span>
            <span>${po.inintrgral}</span>
            <span>${po.nowintegral}</span>
          </li>
          </c:forEach>
        </ul>
      </div>
    </div>
    <!-- 爱币商城结束 -->
    <%@ include file="/weixin_personcenter/bottom.jsp" %>
  </div>

</body>
</html>

