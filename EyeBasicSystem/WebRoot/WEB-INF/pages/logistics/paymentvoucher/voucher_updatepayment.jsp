<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>付款单凭证管理</title>
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
    
    $(document).ready(function(){
        var total = 0;    		 
		$('span[id=sCostPriceAmount]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
			total = accAdd(total,$(this).text());
		});
		$('#costPriceAmountTotal').text(parseFloat(total).toFixed(2));
	});
	
	/**
	 *  增加凭证
	 */        
	 function save(){
	     var auditState = document.getElementsByName("auditState");
	     if (auditState != null  && auditState.length != 0){
	     	 if (auditState[0].checked){
	              updateVoucherFrm.action = "updatePayMentVoucher.action?auditState=1";
	         }else{
	              updateVoucherFrm.action = "updatePayMentVoucher.action?auditState=0";
	         }
	     }else{
	         updateVoucherFrm.action = "updatePayMentVoucher.action?auditState=0";
	     }

	     $("img").removeAttr("onclick");   
	     updateVoucherFrm.submit();	    
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
	<form id="updateVoucherFrm" action="" method="post">
	<input type="hidden" id="isUpdate" value="${isUpdate}"/>
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
                        <TR >
                          <TD width="9%" class="table_body" height="26px">凭证号</TD>
                          <TD width="24%" class="table_none">${po.sLvvID}<input type="hidden" name="po.sLvvID" value="${po.sLvvID}" />                              
						  </TD>
                          <TD width="9%" class="table_body">凭证日期</TD>
                          <TD width="24%" class="table_none">${fn:substring(po.sLvvDate,0,10)}</TD>
                          <TD width="9%" class="table_body">凭证类型</TD>
                          <TD width="24%" class="table_none">
                              ${po.sLvvVoucherParentTypeName}&nbsp;&nbsp;&nbsp;&nbsp;${po.sLvvVoucherTypeName}
                          </TD>

                          </TR>
                        <TR height="26px">
                          <TD class="table_body" height="26px">凭证人</TD>
                          <TD class="table_none">${po.sLvvPersonName}&nbsp;</TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${po.sLvvAuditPersonName}&nbsp;</TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">${fn:substring(po.sLvvAuditDate,0,10)}&nbsp;</TD>
                        </TR>
                        <TR height="26px">
                          <TD class="table_body" height="26px">制造商/客户</TD>
                          <TD class="table_none" colspan="5">${po.sLvvSupplierName}&nbsp;</TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5>
                              <textarea name="po.sLvvRemark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${po.sLvvRemark}</textarea>
                          </TD>
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
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26"><input type="checkbox" onclick="chkAll()" id="chks">选择</TH>
                          <TH scope=col width="15%" >单据号</TH>
                          <TH width="15%" scope=col>制单日期</TH>
                          <TH scope=col width="7%">单据金额</TH>
                        </TR>
						<TR class="table_title" align=middle>
						  <TD height="26" colspan="3" align="right">合计：</TD>
                          <TD><div id="costPriceAmountTotal"></div></TD>
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input id="chk" name="chk" type="checkbox"></TD>
						  <TD>${sLveveBillID}<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="${sLveveBillID}" /></TD>
						  <TD>${fn:substring(sBillDate,0,10)}</TD>
                          <TD><span id="sCostPriceAmount">${sCostPriceAmount}</span><input type="hidden" name="voucherEntryTempPo.sCostPriceAmount" value="${sCostPriceAmount}" /></TD>
                         </TR>
                        </s:iterator>
                       </TBODY>
                      </TABLE>
                 <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                      	<TR>
						  <TD align="left">
                          <li class="horizontal_onlyRight"><img btn=btn id="submitBtn" name="submitBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()"></li>
                          <li class="horizontal_onlyRight">
                          <c:if test="${permissionPo.keyf=='1'}"><input type="checkbox" id="auditState" name="auditState" value="1">保存并审核</c:if> </li>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>