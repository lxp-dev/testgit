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

    $(document).ready(function(){    		 
        amount();
	});

 	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    } 
    
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
                          <TD width="8%" class="table_body">付款单号</TD>
                          <TD width="24%" class="table_none">${payMentBillPo.sLpbpbID}
                          <input type="hidden" name="payMentBillPo.sLpbpbID" value="${payMentBillPo.sLpbpbID}" />
						  </TD>
                          <TD width="8%" class="table_body">付款单日期</TD>
                          <TD width="24%" class="table_none">${fn:substring(payMentBillPo.sLpbpbDate,0,10)}&nbsp;</TD>
                          <TD width="8%" class="table_body">制造商</TD>
                          <TD width="230%" class="table_none">${payMentBillPo.sLpbpbSupplierName}&nbsp;</TD>

                          </TR>
                        <TR height="26px">
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none" >${payMentBillPo.sLpbpbCreatePersonName}&nbsp;</TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${payMentBillPo.sLpbpbAuditPersonName}&nbsp;</TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">${fn:substring(payMentBillPo.sLpbpbAuditDate,0,10)}&nbsp;</TD>
                        </TR>
                        <TR height="26px">
                          <TD class="table_body" >单据类型</TD>
                          <TD class="table_none">其他付款&nbsp;</TD>
                          <TD class="table_body" >部门名称</TD>
                          <TD class="table_none" colspan="5">${payMentBillPo.sLpbpbPayMentDptName}&nbsp;</TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">摘要</TD>
                          <TD class="table_none" colSpan=7>${payMentBillPo.sLpbpbRemark}&nbsp;</TD>
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
                          <TH scope=col width="12%" >科目名称</TH>
                          <TH scope=col width="6%">金额(含税)</TH>
                          <TH scope=col width="20%">备注</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26" colspan="2">合计：</TD> 
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div></TD>                         
                          <TD></TD>
                        </TR>
                        <s:iterator value="payMentBillEntryList" status="index">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" height="26">
                          <TD><input type="checkbox" id="chk"></TD>                        
                          <TD>${sLpbpbeOutComeName}</TD>
                          <TD>${sLpbpbeCostPriceAmount}<input id="notpayamount${index.index }" type="hidden" name="payMentBillEntryTempPo.sLpbpbeCostPriceAmount" value="${sLpbpbeCostPriceAmount}"/></TD>
			              <TD>${sLpbpbeRemark}</TD>                          
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