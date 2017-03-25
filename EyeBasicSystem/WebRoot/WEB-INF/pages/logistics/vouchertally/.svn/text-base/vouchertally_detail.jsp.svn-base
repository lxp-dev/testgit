<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>凭证管理</title>
	<link href="<%=request.getContextPath()%>/voucher/voucher.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript">

	 /**
	  *  checkbox全选
	  */	
	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
    
    /**
	 *  自动计算相关数据
	 */	       
	 function amount(){
	    var total = 0;
	    $('input[name=voucherTallyTempPo.sLvtvtDebitMoney]').each(function (){
	        total = accAdd(total,$(this).val());
	    });
	    $('#debitMoneyTotal').val(total);

	    total = 0;
	    $('input[name=voucherTallyTempPo.sLvtvtLenderMoney]').each(function (){
	        total = accAdd(total,$(this).val());
	    });
	    $('#lenderMoneyTotal').val(total);

        // 负数变为红色
        if (Number($('#debitMoneyTotal').val()) < 0){
        	$('#debitMoneyTotal').css("color","red");
        	
        }
        if (Number($('#lenderMoneyTotal').val()) < 0){
        	$('#lenderMoneyTotal').css("color","red");
        }
	 }
	      
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 

	    amount();
    }); 

</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="editVoucherTempletFrm" action="" method="post">
<input type="hidden" id="sTypeID" name="sTypeID" value="${sTypeID}">
<input type="hidden" id="indexs" name="indexs">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
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
                          <TD width="24%" class="table_none">${po.sLvvID}<input id="voucherID" name="po.sLvvID" type="hidden" class="text_input100" value="${po.sLvvID }"/></TD>
                          <TD width="9%" class="table_body">凭证日期</TD>
                          <TD width="24%" class="table_none">${po.sLvvDate}</TD>
                          <TD class="table_body" width="9%">制单人</TD>
                          <TD class="table_none" width="24%">${po.sLvvPersonName}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body"  height="26px">
                              <c:if test="${po.sLvvTypeID eq '1'}">制造商</c:if>
                              <c:if test="${po.sLvvTypeID eq '2'}">部门</c:if>
                              <c:if test="${po.sLvvTypeID eq '3'}">客户</c:if>&nbsp;
                          </TD>
                          <TD class="table_none" colspan="5">${po.sLvvSupplierName}&nbsp;</TD>
                        </TR>
                        <TR height="26px">
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${po.sLvvAuditPersonName}&nbsp;</TD>
                         
                          <TD class="table_body">审核人日期</TD>
                          <TD class="table_none">${po.sLvvAuditDate}&nbsp;</TD>
                         
                          <TD class="table_body">附单数</TD>
                          <TD class="table_none">${po.sLvvAttchBillCount }&nbsp;</TD>
                         
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><label>
                            ${po.sLvvRemark}</TD>
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
            <div class="con_voucher">				
					<table id="tb_voucher" width="100%" align=center cellpadding=0 cellspacing=0 >
                      <TBODY id="tb_voucher2">
                        <TR>
                          <TH width="6%" height="26" rowspan="2">方向</TH>
                          <TH width="34%" rowspan="2">摘要</TH>
                          <TH width="34%" rowspan="2">会计科目</TH>
                          <TH width="168" class="double">借方金额</TH>
                          <TH width="168">贷方金额</TH>
                        </TR>
                <tr>
                    <th class="scale double" height="26"></th>
                    <th class="scale"></th>
                </tr>
                       <s:iterator value="voucherTallyList" status="index">
                        <TR class="line">
                          <TD height="26" align="center">
                                <c:if test="${sLvtsBalanceDirection == 'j'}">借</c:if>
                                <c:if test="${sLvtsBalanceDirection == 'd'}">贷</c:if>
                          </TD>
						  <TD>${sLvtvtResume}</TD>
						  <TD>${sLvtvtSubjectID}${sLvtvtSubjectName}</TD>
						  <TD class="s_line double"><div id="debitMoneyLayer${index.index}" name="debitMoneyLayer" ${sLvtsBalanceDirection == 'd' ? 'style="display: none"' : '' } ><input id="debitMoney${index.index}" name="voucherTallyTempPo.sLvtvtDebitMoney" value="${sLvtvtDebitMoney == null ? 000 : fn:replace(sLvtvtDebitMoney,'.','')}" class="debite" maxlength="14" style="width: 100%;height: 41" readonly="readonly"></div></TD>
						  <TD class="s_line"><div id="lenderMoneyLayer${index.index}" name="lenderMoneyLayer" ${sLvtsBalanceDirection == 'j' ? 'style="display: none"' : '' }><input id="lenderMoney${index.index}" name="voucherTallyTempPo.sLvtvtLenderMoney" value="${sLvtvtLenderMoney == null ? 000 : fn:replace(sLvtvtLenderMoney,'.','')}" class="credit" maxlength="14" style="width: 100%;height: 41" readonly="readonly"></div></TD>   <!-- onkeyup="isValidMoney(this);"  -->                       
                       	</TR>
                       </s:iterator>
                       <tfoot>
                       <TR>						 
						  <td height="26" colspan="3" class="total"><strong>合 计：&nbsp;
                              <input type="text" id="AmountWords" readonly="readonly">
                          </strong></td>
						  <TD class="s_line double">
						  <input type="text" id="debitMoneyTotal" readonly="readonly" class="debite" >
						  </TD>
                          <TD class="s_line">
                          <input type="text" id="lenderMoneyTotal" readonly="readonly" class="credit">
                          </TD>
                        </TR>
                        </tfoot>
                      </TBODY>
                    </TABLE>
                 </div>  
                  
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
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>