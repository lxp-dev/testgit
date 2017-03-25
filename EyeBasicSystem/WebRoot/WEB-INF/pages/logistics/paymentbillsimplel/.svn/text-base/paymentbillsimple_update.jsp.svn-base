<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>付款单管理</title>
<script type="text/javascript">

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	});

	/**
     *  修改付款单
     */        
	function save(voucherID){
	    if (checkForm(updatePayMentBillFrm)){
	    	if (($('#sLpbpbTypeID').val()!='3' && $('#sLpbpbTypeID').val()!='6' && $('#sLpbpbTypeID').val()!='7' ) && (Number($('#sLpbpbCostPriceAmount').val()) != Number($('#payMentAmount').val()))){
	            alert("本次核销金额与源单核销总金额不相等!");
	            $('#sLpbpbCostPriceAmount').val($('#payMentAmount').val());
	            return;
	        }else if ($('#sLpbpbTypeID').val()=='3' || $('#sLpbpbTypeID').val()=='6' || $('#sLpbpbTypeID').val()=='7' ){
	            $('#costPriceAmount').val($('#sLpbpbCostPriceAmount').val());
	            $('#payMentAmount').val($('#sLpbpbCostPriceAmount').val());
	        }

	    	if (($('#sLpbpbTypeID').val()!='3' && $('#sLpbpbTypeID').val()!='6' && $('#sLpbpbTypeID').val()!='7' ) && (Number($('#sLpbpbCostPriceAmount').val()) < Number($('#sLpbpbPayMentAmount').val()))){
	            alert("本次核销金额不能低于本次付款金额!");
	            $('#sLpbpbPayMentAmount').select();
	            return;
	        }
	        
	        var costPriceAmounts = document.getElementsByName('payMentBillEntryTempPo.sLpbpbeCostPriceAmount');
	        var payMentAmounts = document.getElementsByName('payMentBillEntryTempPo.sLpbpbePayMentAmount');

	        for (var i = 0; i < costPriceAmounts.length; i++ ){
	            if (Number(costPriceAmounts[i].value) > 0){
		            if ((Number(costPriceAmounts[i].value) < Number(payMentAmounts[i].value)) || Number(payMentAmounts[i].value) < 0){
			            alert("请重新填写单据核销金额!");
			            payMentAmounts[i].select();
			            return;
		            }
	            }
	            if (Number(costPriceAmounts[i].value) < 0){
		            if (Number(payMentAmounts[i].value) > 0 || (Number(costPriceAmounts[i].value) > Number(payMentAmounts[i].value))){
			            alert("请重新填写单据核销金额!");
			            payMentAmounts[i].select();
			            return;
		            }
	            }
	            if (Number(costPriceAmounts[i].value) == 0){
		            if (Number(payMentAmounts[i].value) != 0){
			            alert("请重新填写单据核销金额!");
			            payMentAmounts[i].select();
			            return;
		            }
	            }
	        }
	        
		    var auditState = document.getElementsByName("auditState");
		    if (auditState != null  && auditState.length != 0 ){
			    if (!auditState[0].checked){
		            updatePayMentBillFrm.action = "updatePayMentBillSimple.action?auditState=0";
		        }else{
		            updatePayMentBillFrm.action = "updatePayMentBillSimple.action?auditState=1";
		        }
		    }else{
		        updatePayMentBillFrm.action = "updatePayMentBillSimple.action?auditState=0";
		    }
		    
            $("img").removeAttr("onclick");
	        updatePayMentBillFrm.submit();
	           
	        auditState.disabled="disabled";
	    }

	}
	
	/**
	 *  自动计算相关数据
	 */	       
	 function amount(){
  	    for(var i = 1; i < 5; i++){
			var total = 0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=parseFloat(accAdd(total,$(this).find("input").val())).toFixed(2);
				}else{
					total=parseFloat(accAdd(total,$(this).text())).toFixed(2);
				}
			});
			$('#td'+i+'t').text(parseFloat(total).toFixed(2));
		}
		$('#costPriceAmount').val(parseFloat($('#td3t').text()).toFixed(2));	
		$('#payMentAmount').val(parseFloat($('#td4t').text()).toFixed(2));
		// $('#sLpbpbCostPriceAmount').val($('#payMentAmount').val());
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
                amount();
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
                amount();
                return;
            }
        }else{
            if (parseFloat($('#notpayamount'+index).val()) < parseFloat($('#payedamount'+index).val())){
                alert("不正确的金额!");
                obj.value = parseFloat(0.00).toFixed(2);
                amount();
                return;
            }
        }
        if (accMul(parseFloat($('#notpayamount'+index).val()), parseFloat($('#payedamount'+index).val())) <= 0){
            alert("不正确的金额!");
            obj.value = parseFloat(0.00).toFixed(2);
            amount();
            return;
        }
            
        amount();
	}

	function autoCostPriceAmount(obj){

		if ('${payMentBillPo.sLpbpbTypeID}' == '5'){
            return;
	    }
	    
		var objVal = obj.value;
        var costPriceAmounts = document.getElementsByName('payMentBillEntryTempPo.sLpbpbeCostPriceAmount');
        var payMentAmounts = document.getElementsByName('payMentBillEntryTempPo.sLpbpbePayMentAmount');

        for (var i = 0; i < costPriceAmounts.length; i++ ){
            if (Number(accSub(Math.abs(costPriceAmounts[i].value),Math.abs(objVal))) >= 0){
            	payMentAmounts[i].value = parseFloat(objVal).toFixed(2);
            	objVal = 0;
            }else{
            	payMentAmounts[i].value = parseFloat(costPriceAmounts[i].value).toFixed(2);
            	objVal = Number(accSub(objVal,costPriceAmounts[i].value));
            }
        }
        amount();        
	}

 	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    } 
    
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form action="" method="post" id="updatePayMentBillFrm" name="updatePayMentBillFrm">
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
                          <TD width="24%" class="table_none">${fn:substring(payMentBillPo.sLpbpbDate,0,10)}&nbsp;</TD>
                          <TD width="9%" class="table_body" >制造商</TD>
                          <TD width="30%" class="table_none" >${payMentBillPo.sLpbpbSupplierName}&nbsp;</TD>

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
                          <TD class="table_none" >${payMentBillPo.sLpbpbTypeName}<input type="hidden" id="sLpbpbTypeID" value="${payMentBillPo.sLpbpbTypeID}" /></TD>
                          <TD class="table_body">本次核销</TD>
                          <TD class="table_none"><input type="text" id="sLpbpbCostPriceAmount" class="text_input100" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);};autoCostPriceAmount(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '本次核销金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '本次核销金额格式错误！'}]" value="${payMentBillPo.sLpbpbPayMentAmount}">
	                          <input type="hidden" id="costPriceAmount" name="payMentBillPo.sLpbpbCostPriceAmount">
	                          <input type="hidden" id="payMentAmount" name="payMentBillPo.sLpbpbPayMentAmount">
                          </TD>
                          <TD class="table_body">本次付款</TD>
                          <TD class="table_none"><input type="text" id="sLpbpbPayMentAmount" ${payMentBillPo.sLpbpbTypeID == '2' ? '' : 'disabled="disabled"'} name="payMentBillPo.sLpbpbCurrentPayMentAmount" class="text_input100" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '本次付款金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '本次付款金额格式错误！'}]" value="${payMentBillPo.sLpbpbCurrentPayMentAmount}"></TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">摘要</TD>
                          <TD class="table_none" colSpan=9>
                            <label>
                              <textarea name="payMentBillPo.sLpbpbRemark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${payMentBillPo.sLpbpbRemark}</textarea>
                            </label>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                <c:if test="${payMentBillPo.sLpbpbTypeID eq '2' || payMentBillPo.sLpbpbTypeID eq '1'}">  
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
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
                          <TH scope=col width="15%" >源单编号</TH>
                          <TH scope=col width="10%">单据日期</TH>
                          <TH scope=col width="10%">源单类型</TH>
                          <TH scope=col width="10%">单据金额(含税)</TH>
                          <TH scope=col width="10%">已核销金额(含税)</TH>
                          <TH scope=col width="10%">未核销金额(含税)</TH>
                          <TH scope=col width="10%">本次核销金额(含税)</TH>
                          <TH scope=col width="10%">备注</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26" colspan="4">合计：</TD> 
                          <TD><div id="td1t"></div></TD>
                          <TD><div id="td2t"></div></TD>
                          <TD><div id="td3t"></div></TD>
                          <TD><div id="td4t"></div></TD>
                          <TD></TD>
                        </TR>
                        <s:iterator value="payMentBillEntryList"  status="index">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" >
                          <TD height="26"><input type="checkbox" id="chk"></TD>                        
                          <TD>${sLpbpbeInvoiceID}<input type="hidden" name="payMentBillEntryTempPo.sLpbpbeInvoiceID" value="${sLpbpbeInvoiceID}" /></TD>
                          <TD>${sLpbpbePayedMentDate}</TD>
			              <TD>${sLpbpbeBillTypeID}</TD>
			              <TD id="td1">${sCstieCostPriceAmount}</TD>
                          <TD id="td2">${sLpbpbePayedMentAmount}</TD>
			              <TD id="td3">${sLpbpbeCostPriceAmount}<input id="notpayamount${index.index }" type="hidden" name="payMentBillEntryTempPo.sLpbpbeCostPriceAmount" value="${sLpbpbeCostPriceAmount}" /></TD>
			              <TD id="td4"><input type="text" id="payedamount${index.index }" name="payMentBillEntryTempPo.sLpbpbePayMentAmount" value="${sLpbpbePayMentAmount}" onblur="toFixAndNan(this,'${index.index }')"/></TD>
			              <TD><input type="text" name="payMentBillEntryTempPo.sLpbpbeRemark" value="${sLpbpbeRemark}" /></TD>
                         </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
              </c:if>  
                
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