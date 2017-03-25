<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>条码扫描</title>
</head>

<script>

	$(document).ready(function (){
		if('${goodsInfoPo.bgigoodsid}' == 'nofound'){
			alert("该条码商品不存在,或被停用！");
			$("#scancode").select();
		}else if('${goodsInfoPo.bgigoodsid}' != 'nofound' && '${goodsInfoPo.bgigoodsid}' != '' && '${goodsInfoPo.bgigoodsid}' != null){

			var json = {'bgigoodsid':'${goodsInfoPo.bgigoodsid}'.toUpperCase(),'bgigoodsname':'${goodsInfoPo.bgigoodsname}','bgispec':'${goodsInfoPo.bgispec}','bgigoodsquantity':'0'};

			window.parent.addRow(json);
			window.parent.loadBarUpdateNumber('${scancode}');
		}
		$("#scancode").select();
		$("#scancode").focus();
	});

	function getGoods(){
		if(event.keyCode==13){
			if($("#scancode").val().length != 26){
				alert("条码格式有误！");
				$("#scancode").select();
				return;
			}
			barcodeScanForm.action="scanGoodsID.action?scancode="+$("#scancode").val();
			barcodeScanForm.submit();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } style="overflow：none;">
<form name="barcodeScanForm" method="post">
<input type="hidden" name="moduleID" value="${requestScope.moduleID }" />

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-TOP: 5px;" vAlign=top>
        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 >
        	<tr>
        		<td class="table_body" width="30%" >
        			商品条码
        		</td>
        		<td class="table_none" width="70%">
        			<input id="scancode" name="scancode" type="text" maxlength="26" class="text_input200" onkeypress="getGoods()"/>
           		</td>
           	</tr>
           </TABLE>
      </TD>
  </TR>
  </TBODY>
</TABLE>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>