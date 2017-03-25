<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>付款单管理</title>
<script type="text/javascript">

   /**
    *  根据发票（冲回）号查询发票（冲回）明细
    */
	function detail(invoiceID){	   
	   	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInvoiceDetail.action?invoiceID="+invoiceID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInvoiceDetail.action?invoiceID="+invoiceID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【发票详细】";
	}
	 
	/**
     *  修改付款单
     */        
	function save(voucherID){
	    var auditState = document.getElementsByName("auditState");
	    if (auditState != null  && auditState.length != 0 ){
		    if (!auditState[0].checked){
	            updatePayMentBillFrm.action = "updatePayMentBill.action?auditState=0";
	        }else{
	            updatePayMentBillFrm.action = "updatePayMentBill.action?auditState=1";
	        }
	    }else{
	        updatePayMentBillFrm.action = "updatePayMentBill.action?auditState=0";
	    }
	    $("img").removeAttr("onclick");
        updatePayMentBillFrm.submit();
        auditState.disabled="disabled";
	}
	
	/**
     *  自动计算相关数据
     */      
	 function amount(){
		var total = 0;
		$('input[name=payMentBillEntryTempPo.sLpbpbeCostPriceAmount]').each(function(){
            total=parseFloat(accAdd(total,$(this).val())).toFixed(2);    
		});
		$('#costPriceAmountTotal').text(parseFloat(total).toFixed(2));
		$('#costPriceAmount').val(parseFloat(total).toFixed(2));
		
		total = 0;
		$('input[name=payMentBillEntryTempPo.sLpbpbePayMentAmount]').each(function(){
            total=parseFloat(accAdd(total,$(this).val())).toFixed(2);    
		});
		$('#payMentAmountTotal').text(parseFloat(total).toFixed(2));
		$('#payMentAmount').val(parseFloat(total).toFixed(2));
	}
     
     $(document).ready(function(){    		 
         amount();
	});
	
	function toFixAndNan(obj,index){
		if (obj.value == '' || obj.value == null || obj.value == 'NaN' || isNaN(obj.value)){
		    alert("不正确的金额!");
            obj.value = parseFloat(0.00).toFixed(2);
            amount();
		    return;
		}
		      
        //验证小数点只有0个或1个并且不能以小数点开始
        var objLength = obj.value.length;
        var strIndexOf = obj.value.indexOf('.');
        var strLastIndexOf = obj.value.lastIndexOf('.');
        
        if (strLastIndexOf + 1 == objLength){
            return true;
        }
        
        if (strIndexOf != strLastIndexOf || strIndexOf == 0){
            alert("不正确的金额!");
            obj.value = parseFloat(0.00).toFixed(2);
            amount();
            return;
        }
       
        //判断是否只有数字或数字和1个小数点组成       
        var str = '-0123456789.';
        var count = 0;
        for(var i = 0; i < obj.value.length; i++){
            for(var j = 0; j < str.length; j++){
                if (obj.value.charAt(i) == str.charAt(j)){                    
                    count = 1;
                    break;
                }
            }
            if (count == 0){
                alert("不正确的金额!");
                obj.value = parseFloat(0.00).toFixed(2);
                return;
            }
            count = 0;
        }        
        
        //金额只能保留两位小数     
        if (strLastIndexOf >= 0 && objLength-strLastIndexOf > 3){
            alert("金额只能保留两位小数!");            
        }
        obj.value = parseFloat(obj.value).toFixed(2);
        
        if (parseFloat($('#notpayamount'+index).val()) < 0){
            if (parseFloat($('#notpayamount'+index).val()) > parseFloat($('#payedamount'+index).val())){
                alert("不正确的金额!");
                obj.value = parseFloat(0.00).toFixed(2);
                return;
            }
        }else{
            if (parseFloat($('#notpayamount'+index).val()) < parseFloat($('#payedamount'+index).val())){
                alert("不正确的金额!");
                obj.value = parseFloat(0.00).toFixed(2);
                return;
            }
        }
        if (accMul(parseFloat($('#notpayamount'+index).val()), parseFloat($('#payedamount'+index).val())) <= 0){
            alert("不正确的金额!");
            obj.value = parseFloat(0.00).toFixed(2);
            return;
        }
            
        amount();
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
	<form action="" method="post" id="updatePayMentBillFrm">
	<input id="parentID" name="parentID" type="hidden" value="${requestScope.parentID}">
	<input id="voucherID" name="voucherID" type="hidden" value="${requestScope.voucherID}">
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
                          <TD width="9%" class="table_body">付款单号</TD>
                          <TD width="24%" class="table_none">${payMentBillPo.sLpbpbID}
                          <input type="hidden" name="payMentBillPo.sLpbpbID" value="${payMentBillPo.sLpbpbID}" />
						  </TD>
                          <TD width="9%" class="table_body">付款单日期</TD>
                          <TD width="24%" class="table_none">${fn:substring(payMentBillPo.sLpbpbDate,0,10)}</TD>
                          <TD width="9%" class="table_body" >制造商</TD>
                          <TD width="30%" class="table_none" >${payMentBillPo.sLpbpbSupplierName}</TD>

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
                          <TD class="table_none" colSpan=9>
                            <label>
                              <textarea name="payMentBillPo.sLpbpbRemark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${payMentBillPo.sLpbpbRemark}</textarea>
                            </label>
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
                        <s:iterator value="payMentBillEntryList" status="index">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk"></TD>        
                          <TD>
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLpbpbeInvoiceID}')">
		                  </TD>                
                          <TD>${sLpbpbeInvoiceID}<input type="hidden" name="payMentBillEntryTempPo.sLpbpbeInvoiceID" value="${sLpbpbeInvoiceID}" /></TD>
                          <TD>${sLpbpbeCostPriceAmount}<input id="notpayamount${index.index }" type="hidden" name="payMentBillEntryTempPo.sLpbpbeCostPriceAmount" value="${sLpbpbeCostPriceAmount}" /></TD>
			              <TD><input type="text" id="payedamount${index.index }" name="payMentBillEntryTempPo.sLpbpbePayMentAmount" value="${sLpbpbePayMentAmount}" onblur="toFixAndNan(this,'${index.index }')"/></TD>                          

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