<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    function detail(id){
    	if(checkForm(memeberFrm)){
    		memeberFrm.action = "initWeiXinSalesBillDetailSel.action?salesBillID="+id;
    		memeberFrm.submit();
        }
    }

    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });
</script>

</head>

<body  class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<div class="title">配镜单查询</div>

<form name="memeberFrm" method="post" action="">
<table width="100%" border="0" cellpadding="0" cellspacing="2" class="list_tab">
  <tr>
    <th colspan="3" align="left"><font size="3">最近一笔配镜单记录：</font></th>
  </tr>
  <tr>
    <th class="jifen_tit" height="26">销售门店</th>
    <th class="jifen_tit">配镜单号</th>
    <th class="jifen_tit">销售时间</th>
  </tr>
     <tr onclick="detail('${requestScope.salesBasicPo.ssesbsalesid}');" style="cursor: hand">
       <td bgcolor="#FFFFFF" class="tab_line" id="list_tab_name" align="center" height="26">${requestScope.salesBasicPo.ssesbshopName }</td> 	   
       <td bgcolor="#FFFFFF" class="tab_line" align="center">${requestScope.salesBasicPo.ssesbsalesid }</td>    
       <td bgcolor="#FFFFFF" class="tab_line" align="center">${requestScope.salesBasicPo.ssesbsalesdatetime }</td>
     </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="2" class="list_tab">
  <tr>
    <th colspan="3" align="left"><font size="3">最近一年的配镜单记录：</font></th>
  </tr>
  <tr>
    <th class="jifen_tit" height="26">销售门店</th>
    <th class="jifen_tit">配镜单号</th>
    <th class="jifen_tit">销售时间</th>
  </tr>
   <s:iterator value="salesBasicList">
     <tr onclick="detail('${ssesbsalesid}');" style="cursor: hand">
       <td bgcolor="#FFFFFF" class="tab_line" id="list_tab_name" align="center" height="26">${ssesbshopName }</td> 	   
       <td bgcolor="#FFFFFF" class="tab_line" align="center">${ssesbsalesid }</td>    
       <td bgcolor="#FFFFFF" class="tab_line" align="center">${ssesbsalesdatetime }</td>
     </tr>
    </s:iterator>
</table>

<p>&nbsp;</p>
</form>
</body>
</html>

