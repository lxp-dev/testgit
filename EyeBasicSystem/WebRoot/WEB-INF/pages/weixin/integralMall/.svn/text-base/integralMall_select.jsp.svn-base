<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的${weiXinDataConfigPo.wdcintroductionjifen}</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

	function myIntegralLog(){
		location.href="initIntegralLog.action?openID="+$('#openID').val();
	}

	function integralGoodsList(){
		location.href="initIntegralGoodsListSel.action?openID="+$('#openID').val();
	}

	function integralState(){
		location.href="initIntegralState.action?openID="+$('#openID').val();
	}

	function integralGuize(){
		location.href="initIntegralGuize.action?openID="+$('#openID').val();
	}		
</script>

</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<div class="xf_canting xf_panle ">
    <!-- 我的爱币 -->
    <div class="login_bg">      
      <div class="wdjf">
        <span>可用${weiXinDataConfigPo.wdcintroductionjifen}</span>
        <b>${customerInfoPo.smeciintegral}</b>
      </div>
      <div class="wdnc">
        <ul>
          <li class="wdncv" onclick="myIntegralLog();">
            <span>${weiXinDataConfigPo.wdcintroductionjifen}记录</span>
            <a href=""></a>
          </li>
          <li class="wdncj" onclick="integralGoodsList();">
            <span>${weiXinDataConfigPo.wdcintroductionjifen}兑换</span>
            <a href=""></a>
          </li>
           <li class="wdncv" onclick="integralState();">
            <span>领取状态</span>
            <a href=""></a>
          </li>
          <li class="wdncj" onclick="integralGuize();">
            <span>${weiXinDataConfigPo.wdcintroductionjifen}规则</span>
            <a href=""></a>
          </li>          
        </ul>
      </div>
    </div>  
    <!-- 我的爱币结束 -->
    <%@ include file="/weixin_personcenter/bottom.jsp" %>
  </div>

</body>
</html>