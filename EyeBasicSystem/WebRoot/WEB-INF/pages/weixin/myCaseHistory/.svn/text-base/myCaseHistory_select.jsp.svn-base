<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${weiXinDataConfigPo.wdcintroductionwodebingli}</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });   

    function newRefraction(customerID){ 
    	location.href="initWeiXinNewRefractionSel.action?openID="+$('#openID').val() +"&tmpCustomerID="+customerID;       
    }

    function newZhenliao(customerID){ 
    	location.href="initWeiXinNewZhenliaoSel.action?openID="+$('#openID').val() +"&tmpCustomerID="+customerID;             
    }
</script>

</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<!-- 我的病历 -->
		<div class="xf_ctinner">
			<!-- 栏目1 -->
			<div class="fctx">
			<c:forEach var="po" items="${list1}" varStatus="poIndex">
				<div class="zfnr">
					<span class="zfl">${po.smeciname}</span>
					<ul>
						<li><a class="zf1" href="#" onclick="newRefraction('${po.smecicustomerid }');">屈光信息</a></li>
						<li><a class="zf2" href="#" onclick="newZhenliao('${po.smecicustomerid }');">${weiXinDataConfigPo.wdcintroductionzuixinzhenliao}</a></li>
					</ul>
				</div>
				</c:forEach>
				<!-- 栏目3 -->
				<c:forEach var="po" items="${list2}" varStatus="poIndex">
				<div class="zfnr">
					<span class="zfl2">${po.smeciname}</span>
					<ul>
						<li><a class="zf1" href="#" onclick="newRefraction('${po.smecicustomerid }');">屈光信息</a></li>
						<li><a class="zf2" href="#" onclick="newZhenliao('${po.smecicustomerid }');">${weiXinDataConfigPo.wdcintroductionzuixinzhenliao}</a></li>
					</ul>
				</div>
				</c:forEach>
			</div>
		</div>
		<!-- 我的病历结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>