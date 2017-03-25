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

    function salesBillInTransit(salesBillID){ 
    	location.href="initWeiXinDzSalesBillInTransitSel.action?openID="+$('#openID').val() +"&salesBillID="+salesBillID;             
    }
</script>

</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

	<div class="xf_canting xf_panle">
		<c:choose>
    	<c:when test="${empty salesBasicList}">
    		<!-- 弹出ERROR1 -->
    		<div class="bg01">
		      <div class="qrdh wxtc2 yq">
		        <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
		        <p>暂无配镜单记录！</p>
		        <input class="wxyya zxzl1" type="button" value="确 定" onclick="history.go(-1);">
		      </div>
		    </div>
		    <!-- 弹出结束 -->
    	</c:when>
 	    <c:otherwise>
 			<!-- 物流提醒 -->
			<div class="xf_ctinner">
				<span class="h3bg "></span>
				<div class="xxzx">
					<ul>
					<c:forEach var="po" items="${salesBasicList}" varStatus="poIndex">
						<li class="ht2" onclick="salesBillInTransit('${po.ssesbsalesid }');"> 
							<span class="wltx1"></span>
							<i class="xxwz">${po.ssesbsalesid}</i>
							<a class="xxjt" href=""></a>
						</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!-- 物流提醒 -->
    	</c:otherwise>
    </c:choose>
		
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>