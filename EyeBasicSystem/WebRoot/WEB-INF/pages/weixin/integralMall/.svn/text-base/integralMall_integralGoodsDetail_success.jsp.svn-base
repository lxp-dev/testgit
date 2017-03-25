<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${companyNamePo.fcnName }</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
</head>
<script>	
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideOptionMenu');
});

function integralGoodsList(goodsID){
	location.href="initIntegralGoodsListSel.action?openID="+$('#openID').val();
}

function integralState(){
	location.href="initIntegralState.action?openID="+$('#openID').val();
}
</script>
<body class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

 <div class="bg01">
   <div class="qrdh wxtc2 yq">
     <span class="yq"><var>恭喜您，兑换成功！</var></span>
     <img src="${ctx}/weixin_personcenter/images/wx3.png" alt="" />
     <p>${weiXinDataConfigPo.wdcalertjifenduihuansuccess}</p>
     <input class="wxyya zxzl1" type="button" value="继续挑选宝贝" onclick="integralGoodsList();">
   </div>
 </div>
		
</body></html>