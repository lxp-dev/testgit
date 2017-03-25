<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的享福记录</title>
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
    <!-- 储值卡流水 -->
    <div class="jfjl">
      <div class="jfbt">
        <a>日  期</a>
        <a>福币类型</a>
        <a>发生福币</a>
        <a style="background:none;">福币剩余</a>
      </div>
      <div class="jfnr">
        <ul>
          <c:forEach var="po" items="${chuzhikaLogPos}" varStatus="poIndex">
          <li>
            <span>${fn:substring(po.smeasdodate, 0, 10)}</span>
            <span>
			<c:choose>
		  		<c:when test="${(po.smeasaddorsub eq '0')}">
		  			建卡
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '1')}">
		  			充值
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '2')}">
		  			提现
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '3')}">
		  			结款
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '4')}">
		  			退款
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '5')}">
		  			补齐欠款
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '6')}">
		  			订金
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '7')}">
		  			挂号费
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '8')}">
		  			维修费
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq '9')}">
		  			退挂号费
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq 'C3')}">
		  			冲结款
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq 'C4')}">
		  			冲退款
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq 'C5')}">
		  			冲补齐欠款
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq 'C6')}">
		  			冲订金
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq 'C7')}">
		  			冲挂号费
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq 'C8')}">
		  			冲维修费
		  		</c:when>
		  		<c:when test="${(po.smeasaddorsub eq 'C9')}">
		  			冲退挂号费
		  		</c:when>
		  	</c:choose>
			</span>
            <span>${po.smeascintegral}</span>
            <span>${po.smeasxintegral}</span>
          </li>
          </c:forEach>
        </ul>
      </div>
    </div>
    <!-- 储值卡流水结束 -->
    <%@ include file="/weixin_personcenter/bottom.jsp" %>
  </div>
</body>
</html>