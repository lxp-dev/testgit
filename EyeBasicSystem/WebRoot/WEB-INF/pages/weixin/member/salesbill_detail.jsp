<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${companyNamePo.fcnName }</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />

<script>
	function setBillState(){
	    var billStateStr = '${salesBasicPo.ssesbintransit2 }';
	    var billStateStrs = billStateStr.split(',');
	    $("#currState").html(billStateStrs[0]);
	    if(billStateStrs.length >= 2) {
	      $("#nextState").html(billStateStrs[1]);
	    } else {
	      $("#nextState").html("");
	    }
	}
	$(document).ready(function() {
		setBillState();
	});
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });
</script>

</head>

<body class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<div class="title">配镜单查询</div>
<form name="memeberFrm" method="post" action="" style="margin-top: 0px;">
<table width="100%" border="0" cellspacing="2" cellpadding="0">
  <tr>
    <th colspan="3" align="left"><font size="3">订单信息：</font></th>
  </tr>
  <tr>
    <th class="jifen_tit" bgcolor="#FFFFFF" height="26">配镜单号</th>
    <th class="jifen_tit" bgcolor="#FFFFFF">销售时间</th>
    <th class="jifen_tit" bgcolor="#FFFFFF">销售门店</th>
  </tr>
  	  <tr>
	    <td align="center" bgcolor="#FFFFFF" height="26">${salesBasicPo.ssesbsalesid }</td>
	    <td align="center" bgcolor="#FFFFFF">${salesBasicPo.ssesbsalesdatetime }</td>
	    <td align="center" bgcolor="#FFFFFF">${salesBasicPo.ssesbshopName }</td>
	  </tr>
</table>

<table width="100%" border="0" cellspacing="2" cellpadding="0">
  <tr>
    <th colspan="3" align="left"><font size="3">订单详情：</font></th>
  </tr>
  <tr>
    <th class="jifen_tit" bgcolor="#FFFFFF" height="26" width="80%">商品名称</th>
    <th class="jifen_tit" bgcolor="#FFFFFF" width="10%">数量</th>
    <th class="jifen_tit" bgcolor="#FFFFFF" width="10%">金额</th>
  </tr>
  <s:iterator value="salesDetailList">
	  <tr>
	    <td align="center" bgcolor="#FFFFFF" height="26">${ssesdsalesitemname }</td>
	    <td align="center" bgcolor="#FFFFFF">${ssesdnumber }</td>
	    <td align="center" bgcolor="#FFFFFF">${ssesdsalesvalue }</td>
	  </tr>
  </s:iterator>
</table>

<%--<div class="jifen_left">
<span><b><font size="3">配镜单实时查询：</font></b></span><br/>
<span class="jifen_txt" height="26">${salesBasicPo.ssesbintransit2 }</span></div>--%>
<table width="100%" border="0" cellspacing="2" cellpadding="0">
  <tr>
    <th colspan="3" align="left"><font size="3">配镜单实时查询：</font></th>
  </tr>
  <tr>
	<td align="center" bgcolor="#FFFFFF" height="26" width="30%">当前状态：</td>
	<td align="center" bgcolor="#FFFFFF" width="70%" id="currState">&nbsp;</td>
  </tr>
  <tr style="color: red;">
	<td align="center" bgcolor="#FFFFFF" height="26">将要进行：</td>
	<td align="center" bgcolor="#FFFFFF" id="nextState">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
    </form>
</body>
</html>
