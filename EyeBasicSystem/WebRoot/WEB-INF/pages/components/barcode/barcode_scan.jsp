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
			if( ('${jm }'&&isNaN('${goodsInfoPo.bgiwholesaleprice}')) || ('${jm }'&&'${goodsInfoPo.bgiwholesaleprice}' == 0) ){
				alert("该商品批发金额设置有误！");
				return;
			}
			var json = {'bgigoodsid':'${goodsInfoPo.bgigoodsid}'.toUpperCase(),'bgigoodsbarcode':'${scancode}'.toUpperCase(),'bgipcbarcode':'${scancode}'.toUpperCase(),
			     				'bgigoodsname':'${goodsInfoPo.bgigoodsname}','bgiunitname':'${goodsInfoPo.bgiunitname}','bgicostprice':'${goodsInfoPo.bgicostprice}',
			     				'bgiretailprice':'${goodsInfoPo.bgiretailprice}','bgitaxrate':'${goodsInfoPo.bgitaxrate}','bginottaxrate':'${goodsInfoPo.bginottaxrate}',
			     				'bgispec':'${goodsInfoPo.bgispec}','bgicolor':'${goodsInfoPo.bgicolor}','bgisph':'${goodsInfoPo.bgisph}','bgicyl':'${goodsInfoPo.bgicyl}','cshaaemaxquantity':'${goodsInfoPo.cshaaemaxquantity}',
			     				'bgiaxis':'${goodsInfoPo.bgiaxis}','bgicurvature1':'${goodsInfoPo.bgicurvature1}','bgidia':'${goodsInfoPo.bgidia}','bgiwholesaleprice':'${goodsInfoPo.bgiwholesaleprice}',
			     				'bgibrandname':'${goodsInfoPo.bgibrandname}','bgisource':'${goodsInfoPo.bgisource}','guaranteeperiod':'${goodsInfoPo.guaranteeperiod}','batch':'${goodsInfoPo.batch}','bgigoodsquantity':'0'};
	
			if('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2'){
				if('${goodsInfoPo.bgigoodsid}'.substring(0,1) == '4' || '${goodsInfoPo.bgigoodsid}'.substring(0,1) == '5'){
					window.parent.addRow(json);
					window.parent.loadBar('${scancode}'.toUpperCase());
				}else{
					window.parent.addRowUpdateNumber(json);
					window.parent.loadBarUpdateNumber('${scancode}'.toUpperCase());
				}
			}else{
				window.parent.addRowUpdateNumber(json);
				window.parent.loadBarUpdateNumber('${scancode}');
			}
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
			if('${systemParameterPo.fspisallocationcategory}' == '1' && window.parent.$("#allocation").val() == 'allocation'){
				if(window.parent.$("#goodscategoryID").val()){
					if(window.parent.$("#goodscategoryID").val() != $("#scancode").val().substring(0,1)){
						alert("商品条码与商品类别不匹配！");
						return;
					}
				}
			}
			if(window.parent.$("#cstisupplierid").val() != '' && typeof(window.parent.$("#cstisupplierid").val()) != 'undefined'){
				if(window.parent.$("#cstisupplierid").val().toUpperCase() != $("#scancode").val().substring(1,3).toUpperCase()){
					alert("商品条码与制造商不匹配！");
					return;
				}
			}
			
			if('${categoryid}' != '' && '${categoryid}' != null){
				if($("#scancode").val().substring(0,1) != '${categoryid}'){
					alert("此类商品不在查询范围内！");
					$("#scancode").select();
					return;
				}
			}
			
			barcodeScanForm.action="scanBarcode.action?scancode="+$("#scancode").val()+"&indptid="+$('#indptid').val();
			barcodeScanForm.submit();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } style="overflow：none;">
<form name="barcodeScanForm" method="post">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID }" />
<input type="text" style="display:none" />
<input type="hidden" name="categoryid" id="categoryid" value="${categoryid }" />
<input type="hidden" name="jm" id="jm" value="${jm }" />  
<input type="hidden" name="outstockid" id="outstockid" value="${outstockid }" />  
<input type="hidden" id="indptid" name="indptid" value="${indptid }"/>

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