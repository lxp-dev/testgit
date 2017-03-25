<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>凭证管理</title>
</head>
<script>

	/**
	 *  自动计算相关数据
	 */	       
	 function amount(){
	    var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("voucherEntryTempPo.sGoodsQuantity");		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
		
		var checkGoodsquantityTotal = 0;
		var checkGoodsquantity = document.getElementsByName("voucherEntryTempPo.sCheckGoodsQuantity");		
		for(i=0;i<checkGoodsquantity.length;i++){
			if(checkGoodsquantity[i].value == '') continue;
			checkGoodsquantityTotal = (parseFloat(checkGoodsquantityTotal).add(parseFloat(checkGoodsquantity[i].value))).toFixed(0);
		}		
		document.getElementById("checkGoodsquantityTotal").innerText=checkGoodsquantityTotal;
		
		var notTaxRateAmountTotal = 0;
		var notTaxRateAmount = document.getElementsByName("voucherEntryTempPo.sNotTaxRateAmount");		
		for(i=0;i<notTaxRateAmount.length;i++){
			if(notTaxRateAmount[i].value == '') continue;
			notTaxRateAmountTotal = (parseFloat(notTaxRateAmountTotal).add(parseFloat(notTaxRateAmount[i].value))).toFixed(2);
		}		
		document.getElementById("notTaxRateAmountTotal").innerText=notTaxRateAmountTotal;
		
		var taxAmountTotal = 0;
		var taxAmount = document.getElementsByName("voucherEntryTempPo.sTaxAmount");		
		for(i=0;i<taxAmount.length;i++){
			if(taxAmount[i].value == '') continue;
			taxAmountTotal = (parseFloat(taxAmountTotal).add(parseFloat(taxAmount[i].value))).toFixed(2);
		}		
		document.getElementById("taxAmountTotal").innerText=taxAmountTotal;
		
		var costPriceAmountTotal = 0;
		var costPriceAmount = document.getElementsByName("voucherEntryTempPo.sCostPriceAmount");		
		for(i=0;i<costPriceAmount.length;i++){
			if(costPriceAmount[i].value == '') continue;
			costPriceAmountTotal = (parseFloat(costPriceAmountTotal).add(parseFloat(costPriceAmount[i].value))).toFixed(2);
		}		
		document.getElementById("costPriceAmountTotal").innerText=costPriceAmountTotal;
	}
	window.onload = function(){
		amount();
	}
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="reversalDetailFrm" action="" method="post">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
							<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="9%" height="26" class="table_body">冲回号</TD>
                          <TD width="24%" class="table_none">${invoicePo.liiid }</TD>
                          <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">
                           ${fn:substring(invoicePo.liidate,0,10)}
                          </TD>
                         <TD width="9%" class="table_body">制造商</TD>
			               <TD width="24%" class="table_none">
						   			<li class="horizontal_onlyRight">
							   		${invoicePo.liisuppliername}
									</li>
						   			
						   	</TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body" >部门</TD>
                          <TD class="table_none" >${invoicePo.liidepartmentname }</TD>
                          <TD class="table_body" >制作人</TD>
                          <TD class="table_none" >${invoicePo.liicreatepersonname}</TD>
                          <TD class="table_body">&nbsp;</TD>
                          <TD class="table_none">&nbsp;</TD>
                          </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><label>
                         ${invoicePo.liiremark }
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="14%" height="26">单据号</TH>
                          <TH width="14%" scope=col>商品代码</TH>
                          <TH width="12%" scope=col>商品名称</TH>
                          <TH scope=col width="6%">型号</TH>
                          <TH scope=col width="4%">数量</TH>
                          <TH scope=col width="5%">核销数量</TH>
                          <TH scope=col width="8%">单位成本</TH>
						  <TH scope=col width="8%">成本合计</TH>
						  <TH scope=col width="8%">含税单价</TH>
                          <TH scope=col width="8%">税额合计</TH>
						  <TH scope=col width="9%">价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD><div id="goodsquantityTotal"></div></TD>
                          <TD><div id="checkGoodsquantityTotal"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD><div id="notTaxRateAmountTotal"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD><div id="taxAmountTotal"></div></TD>
                          <TD><div id="costPriceAmountTotal"></div></TD>
                        </TR>
                        <s:iterator value="invoiceEntryList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">	
						  <TD height="26">${lieiebillid }</TD>
						  <TD>${lieiegoodsid }</TD>
						  <TD>${lieiegoodsname }</TD>
						  <TD>${lieiespec }</TD>
                          <TD>${lieiegoodsquantity }<input type="hidden" name="voucherEntryTempPo.sGoodsQuantity" value="${lieiegoodsquantity}" /></TD>
                          <TD>${lieiecheckgoodsquantity }<input type="hidden" name="voucherEntryTempPo.sCheckGoodsQuantity" value="${lieiecheckgoodsquantity}" /></TD>
                          <TD>${fn:substring(lieienottaxrate,0,fn:indexOf(lieienottaxrate,'.')+3)}<input type="hidden" name="voucherEntryTempPo.sNotTaxRate" value="${lieienottaxrate}" /></TD>
						  <TD>${fn:substring(lieienottaxrateamount,0,fn:indexOf(lieienottaxrateamount,'.')+3)}<input type="hidden" name="voucherEntryTempPo.sNotTaxRateAmount" value="${lieienottaxrateamount}" /></TD>
                          <TD>${lieiecostprice }<input type="hidden" name="voucherEntryTempPo.sCostPrice" value="${lieiecostprice}"/></TD>
						  <TD>${lieietaxamount }<input type="hidden" name="voucherEntryTempPo.sTaxAmount" value="${lieietaxamount}"/></TD>
                          <TD>${lieiecostpriceamount}<input type="hidden" name="voucherEntryTempPo.sCostPriceAmount" value="${lieiecostpriceamount}"/></TD>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                       
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>