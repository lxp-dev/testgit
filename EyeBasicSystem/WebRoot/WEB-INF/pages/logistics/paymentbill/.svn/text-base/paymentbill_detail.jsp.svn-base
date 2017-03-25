<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>付款单管理</title>
<script type="text/javascript">
   /**
    *  自动计算相关数据
    */
	 function amount(){
		var total = 0;
		$('input[name=payMentBillEntryTempPo.sLpbpbeCostPriceAmount]').each(function(){
            total=parseFloat(accAdd(total,$(this).val())).toFixed(2);    
		});
		$('#costPriceAmountTotal').text(parseFloat(total).toFixed(2));
		
		total = 0;
		$('input[name=payMentBillEntryTempPo.sLpbpbePayMentAmount]').each(function(){
            total=parseFloat(accAdd(total,$(this).val())).toFixed(2);    
		});
		$('#payMentAmountTotal').text(parseFloat(total).toFixed(2));
	}
	
   /**
    *  根据发票（冲回）号查询发票（冲回）明细
    */
	function detail(invoiceID){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInvoiceDetail.action?invoiceID="+invoiceID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initInvoiceDetail.action?invoiceID="+invoiceID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【单据详细】";
	}
    
    $(document).ready(function(){    		 
        amount();
	});
	
	function print(billID){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("report.action?reportlet=logistics_payMentBillByBrandRpt.cpt&invoiceID="+billID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("report.action?reportlet=logistics_payMentBillByBrandRpt.cpt&invoiceID="+billID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【付款单】";
	}
	
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
	<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR align="right">
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--ťStart-->
                    <td width=60% align="right" >
                          <img btn=btn src="${ctx}/img/newbtn/btn_print_0.png"  title="打印单据" onClick="print('${payMentBillPo.sLpbpbID}')" />
                    </td>

					</TR></TBODY></TABLE></TD>
					
					</TR>
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
                          <TD width="9%" class="table_body">付款单号</TD>
                          <TD width="24%" class="table_none">${payMentBillPo.sLpbpbID}
                          <input type="hidden" name="payMentBillPo.sLpbpbID" value="${payMentBillPo.sLpbpbID}" />
						  </TD>
                          <TD width="9%" class="table_body">付款单日期</TD>
                          <TD width="24%" class="table_none">${fn:substring(payMentBillPo.sLpbpbDate,0,10)}</TD>
                          <TD width="9%" class="table_body">制造商</TD>
                          <TD width="24%" class="table_none">${payMentBillPo.sLpbpbSupplierName}</TD>

                          </TR>
                        <TR height="26px">
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none" >${payMentBillPo.sLpbpbCreatePersonName}</TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${payMentBillPo.sLpbpbAuditPersonName}</TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">${fn:substring(payMentBillPo.sLpbpbAuditDate,0,10)}</TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=7>${payMentBillPo.sLpbpbRemark}</TD>
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
              
              		<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="3%">操作</TH>
                          <TH scope=col width="15%" >发票号</TH>
                          <TH scope=col width="10%">价税合计</TH>
                          <TH scope=col width="10%">付款金额</TH>
                          
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26" colspan="3">合计：</TD> 
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div><input type="hidden" id="costPriceAmount" name="payMentBillPo.sLpbpbCostPriceAmount"></TD>
                          <TD><div id="payMentAmountTotal" name="payMentAmountTotal"></div><input type="hidden" id="payMentAmount" name="payMentBillPo.sLpbpbPayMentAmount"></TD>
                          
                        </TR>
                        <s:iterator value="payMentBillEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk"></TD>             
                          <TD>
                              <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLpbpbeInvoiceID}')">
		                  </TD>           
                          <TD>${sLpbpbeInvoiceID}<input type="hidden" name="payMentBillEntryTempPo.sLpbpbeInvoiceID" value="${sLpbpbeInvoiceID}" /></TD>
                          <TD>${sLpbpbeCostPriceAmount}<input type="hidden" name="payMentBillEntryTempPo.sLpbpbeCostPriceAmount" value="${sLpbpbeCostPriceAmount}" /></TD>
			              <TD>${sLpbpbePayMentAmount}<input type="hidden" name="payMentBillEntryTempPo.sLpbpbePayMentAmount" value="${sLpbpbePayMentAmount}" /></TD>                          

                         </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    
                 <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left">&nbsp;</TD>
					   </TR>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>