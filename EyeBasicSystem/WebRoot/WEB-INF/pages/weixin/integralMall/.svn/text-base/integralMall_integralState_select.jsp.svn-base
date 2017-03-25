<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>领取状态</title>
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
        <a>兑换日期</a>
        <a>发生${weiXinDataConfigPo.wdcintroductionjifen}</a>
        <a>兑换门店</a>
        <a style="background:none;">是否领取</a>
      </div>
      <div class="jfnr">
        <ul>
          <c:forEach var="po" items="${integralStateList}" varStatus="poIndex">
          <li>
            <span>${fn:substring(po.wiecreatdate, 0, 10)}</span>
            <span>-<fmt:formatNumber value="${po.wieintegral}" pattern="0.00"/></span>
            <span>${po.wiedepartmentname}</span>
            <span>
			<c:choose>
				<c:when test="${po.wieflag eq '1'}">已领取</c:when>
				<c:when test="${po.wieflag eq '0'}">未领取</c:when>
			</c:choose>
			</span>
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

