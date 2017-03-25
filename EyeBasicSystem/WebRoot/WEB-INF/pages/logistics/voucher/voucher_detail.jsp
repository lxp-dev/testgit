<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>凭证管理</title>
<script type="text/javascript">
   /**
    *  自动计算相关数据
    */
    function amount(){		
		var notTaxRateAmountTotal = 0;
		var notTaxRateAmount = document.getElementsByName("notTaxRateAmount");		
		for(i=0;i<notTaxRateAmount.length;i++){
			if(notTaxRateAmount[i].value == '') continue;
			notTaxRateAmountTotal = (parseFloat(notTaxRateAmountTotal).add(parseFloat(notTaxRateAmount[i].value))).toFixed(2);
		}		
		document.getElementById("notTaxRateAmountTotal").innerText=notTaxRateAmountTotal;
		
		var taxAmountTotal = 0;
		var taxAmount = document.getElementsByName("taxAmount");		
		for(i=0;i<taxAmount.length;i++){
			if(taxAmount[i].value == '') continue;
			taxAmountTotal = (parseFloat(taxAmountTotal).add(parseFloat(taxAmount[i].value))).toFixed(2);
		}		
		document.getElementById("taxAmountTotal").innerText=taxAmountTotal;
		
		var costPriceAmountTotal = 0;
		var costPriceAmount = document.getElementsByName("costPriceAmount");		
		for(i=0;i<costPriceAmount.length;i++){
			if(costPriceAmount[i].value == '') continue;
			costPriceAmountTotal = (parseFloat(costPriceAmountTotal).add(parseFloat(costPriceAmount[i].value))).toFixed(2);
		}		
		document.getElementById("costPriceAmountTotal").innerText=costPriceAmountTotal;
		
		var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsquantity");
		if (goodsquantity.length != 0){
			for(i=0;i<goodsquantity.length;i++){
			    if(goodsquantity[i].value == '') continue;
			    goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		    }		
		    document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
		}	

	}
	window.onload = function(){
		amount();
	}
	
   /**
    *  生成凭证开窗
    */
	function search(voucherID,voucherDate,bType,sType,sVoucherType,supplierName,createPerson,posting){
	   var notTaxRateAmountTotal = document.getElementsByName("notTaxRateAmountTotal");
	   if (notTaxRateAmountTotal.length == 0){
	       notTaxRateAmountTotal = "";
	   }else{
	       notTaxRateAmountTotal = document.getElementById("notTaxRateAmountTotal").innerText;
	   } 	  
	   var taxAmountTotal = document.getElementsByName("taxAmountTotal");
	   if (taxAmountTotal.length == 0){
	       taxAmountTotal = "";
	   }else{
	       taxAmountTotal = document.getElementById("taxAmountTotal").innerText;
	   } 
	   var costPriceAmountTotal = document.getElementsByName("costPriceAmountTotal");
	   if (costPriceAmountTotal.length == 0){
	       costPriceAmountTotal = "";
	   }else{
	       costPriceAmountTotal = document.getElementById("costPriceAmountTotal").innerText;
	   } 
	   var url = "voucherID="+EncodeUtf8(voucherID)+"&voucherDate="+EncodeUtf8(voucherDate)+"&bType="+EncodeUtf8(bType)+"&sType="+EncodeUtf8(sType)
	             +"&sVoucherType="+EncodeUtf8(sVoucherType)+"&supplierName="+EncodeUtf8(supplierName)+"&createPerson="+EncodeUtf8(createPerson)
	             +"&posting="+EncodeUtf8(posting)+"&notTaxRateAmountTotal="+notTaxRateAmountTotal
	             +"&taxAmountTotal="+taxAmountTotal+"&costPriceAmountTotal="+costPriceAmountTotal;
	   
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin('selVoucherTally.action?moduleID=${moduleID}&'+url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin('selVoucherTally.action?moduleID=${moduleID}&'+url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【记账凭证新增】";	   
	}
	
   /**
    *  根据发票（冲回）号查询发票（冲回）明细
    */
	function detail(invoiceID){
	   var path = '';
	   if (invoiceID.substring(0,1)=='I'){
	       path = 'initInvoiceDetail.action?invoiceID='+invoiceID;
	   }else if (invoiceID.substring(0,1)=='R'){
	       path = 'selReversalDetail.action?reversalID='+invoiceID;
	   }
	   
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(path,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin(path,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【单据详细】";	   
	   
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
    
    $(document).ready(function(){    		 
		$('span[id=sNotTaxRateAmount]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});
		$('span[id=sNotTaxRate]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});
	});
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form id="voucherDetailFrm" action="" method="post">
	<input type="hidden" id="isUpdate" value="${isUpdate}"/>
	<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
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
                        <TR height="26px">
                          <TD width="9%" class="table_body">凭证号</TD>
                          <TD width="24%" class="table_none">
                            <li class="horizontal_onlyRight">
                              ${po.sLvvID}
                            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_jzpzxz_0.png" title='记账凭证新增'  
						         onClick="search('${po.sLvvID}','${fn:substring(po.sLvvDate,0,10)}','${po.sLvvVoucherParentTypeName}','${po.sLvvVoucherTypeName}','${po.sLvvVoucherTypeID}','${po.sLvvSupplierName}','${createPerson}','${po.sLvvPosting}');">
                            </li>
						  </TD>
                          <TD width="9%" class="table_body">凭证日期</TD>
                          <TD width="24%" class="table_none">${fn:substring(po.sLvvDate,0,10)}</TD>
                          <TD width="9%" class="table_body">凭证类型</TD>
                          <TD width="24%" class="table_none">
                              ${po.sLvvVoucherParentTypeName}&nbsp;&nbsp;&nbsp;&nbsp;${po.sLvvVoucherTypeName}
                          </TD>

                          </TR>
                        <TR height="26px">
                          <TD class="table_body">制造商</TD>
                          <TD class="table_none"><c:if test="${sType != '3'}">${po.sLvvSupplierName}</c:if></TD>
                          <TD class="table_body" >凭证人</TD>
                          <TD class="table_none" >${po.sLvvPersonName}</TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${po.sLvvAuditPersonName}</TD>
                        </TR>
                        <TR height="26px">                          
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none" colspan="5">${fn:substring(po.sLvvAuditDate,0,10)}</TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5>${po.sLvvRemark}</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                          <TR>
                            <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                            <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                          </TR>
                       </TBODY>
                    </TABLE>
                   <c:if test="${id == 'D'}">
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="5%" height="26"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="15%" >单据号</TH>
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH scope=col width="5%">型号</TH>
                          <TH scope=col width="7%">未核销数量</TH>
                          <TH scope=col width="5%">单位成本</TH>
						  <TH scope=col width="5%">成本合计</TH>
                          <TH scope=col width="5%">税率</TH>
						  <TH scope=col width="5%">含税单价</TH>
                          <TH scope=col width="5%">税额合计</TH>
						  <TH scope=col width="5%">价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div id="goodsquantityTotal"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD><div id="notTaxRateAmountTotal" name="notTaxRateAmountTotal"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div id="taxAmountTotal" name="taxAmountTotal"></div></TD>
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div></TD>
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk"></TD>
						  <TD>${sLveveBillID}</TD>
						  <TD>${sLveveGoodsID}</TD>
						  <TD>${sGoodsName}</TD>
						  <TD>${sSpec}</TD>
                          <TD>${sGoodsQuantity}<input type="hidden" name="goodsquantity" value="${sGoodsQuantity}"/></TD>
                          <TD><span id="sNotTaxRate">${sNotTaxRate}</span><input type="hidden" name="notTaxRate" value="${sNotTaxRate}"/></TD>
						  <TD><span id="sNotTaxRateAmount">${sNotTaxRateAmount}</span><input type="hidden" name="notTaxRateAmount" value="${sNotTaxRateAmount}"/></TD>
                          <TD>${sTaxRate}%</TD>
                          <TD>${sCostPrice}</TD>
						  <TD>${sTaxAmount}<input type="hidden" name="taxAmount" value="${sTaxAmount}"/></TD>
                          <TD>${sCostPriceAmount}<input type="hidden" name="costPriceAmount" value="${sCostPriceAmount}"/></TD>
                         </TR>
                        </s:iterator>
                        </TBODY>
                      </TABLE>
                  </c:if>
                  <c:if test="${id == 'F'}">
              		<table id="billTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="3%">操作</TH>
                          <TH scope=col width="15%" >发票号</TH>
                          <TH width="10%" scope=col>单据日期</TH>
                          <TH width="20%" scope=col>制造商简称</TH>
                          <TH scope=col width="10%">部门</TH>
                          <TH scope=col width="10%">审核人</TH>
                          <TH width="10%" scope=col>成本合计</TH>
                          <TH scope=col width="10%">税额合计</TH>
                          <TH scope=col width="10%">价税合计</TH>
                          
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>                          
                          <TD><div id="notTaxRateAmountTotal" name="notTaxRateAmountTotal"></div></TD>                          
                          <TD><div id="taxAmountTotal" name="taxAmountTotal"></div></TD>
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div></TD>
                          
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk"></TD>
                          <TD>
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLveveBillID}')">
		                  </TD>                        
                          <TD>${sLveveBillID}<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="${sLveveBillID}" /></TD>
                          <TD>${fn:substring(sDate,0,10)}<input type="hidden" name="voucherEntryTempPo.sDate" value="${sDate}" /></TD>
			              <TD>${sSupplierName}<input type="hidden" name="voucherEntryTempPo.sSupplierName" value="${sSupplierName}" /></TD>
                          <TD>${sDepartment }<input type="hidden" name="voucherEntryTempPo.sDepartment" value="${sDepartment }" /></TD>
                          <TD>${sPersonID}<input type="hidden" name="voucherEntryTempPo.sPersonID" value="${sPersonID}" /></TD>
                          <TD><span id="sNotTaxRateAmount">${sNotTaxRateAmount}</span><input type="hidden" name="notTaxRateAmount" value="${sNotTaxRateAmount}" /></TD>
                          <TD>${sTaxAmount}<input type="hidden" name="taxAmount" value="${sTaxAmount }" /></TD>
                          <TD>${sCostPriceAmount}<input type="hidden" name="costPriceAmount" value="${sCostPriceAmount}" /></TD>

                         </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                   </c:if>
                <c:if test="${id == 'C'}">
              		<table id="billTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="3%">操作</TH>
                          <TH scope=col width="15%" >冲回号</TH>
                          <TH width="10%" scope=col>单据日期</TH>
                          <TH width="20%" scope=col>制造商简称</TH>
                          <TH scope=col width="10%">部门</TH>
                          <TH scope=col width="10%">审核人</TH>
                          <TH width="10%" scope=col>成本合计</TH>
                          <TH scope=col width="10%">税额合计</TH>
                          <TH scope=col width="10%">价税合计</TH>
                          
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>                          
                          <TD><div id="notTaxRateAmountTotal" name="notTaxRateAmountTotal"></div></TD>                          
                          <TD><div id="taxAmountTotal" name="taxAmountTotal"></div></TD>
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div></TD>
                       
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk"></TD>   
                         <TD>
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLveveBillID}')">
		                  </TD>                     
                          <TD>${sLveveBillID}<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="${sLveveBillID}" /></TD>
                          <TD>${fn:substring(sDate,0,10)}<input type="hidden" name="voucherEntryTempPo.sDate" value="${sDate}" /></TD>
			              <TD>${sSupplierName}<input type="hidden" name="voucherEntryTempPo.sSupplierName" value="${sSupplierName}" /></TD>
                          <TD>${sDepartment }<input type="hidden" name="voucherEntryTempPo.sDepartment" value="${sDepartment }" /></TD>
                          <TD>${sPersonID}<input type="hidden" name="voucherEntryTempPo.sPersonID" value="${sPersonID}" /></TD>
                          <TD><span id="sNotTaxRateAmount">${sNotTaxRateAmount}</span><input type="hidden" name="notTaxRateAmount" value="${sNotTaxRateAmount}" /></TD>
                          <TD>${sTaxAmount}<input type="hidden" name="taxAmount" value="${sTaxAmount }" /></TD>
                          <TD>${sCostPriceAmount}<input type="hidden" name="costPriceAmount" value="${sCostPriceAmount}" /></TD>

                         </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                 </c:if>                   
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>