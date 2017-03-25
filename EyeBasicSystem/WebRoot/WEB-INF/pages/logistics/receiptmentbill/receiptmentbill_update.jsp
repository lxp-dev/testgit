<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>收款单管理</title>
<script type="text/javascript">
  
	/**
	 *  清除表格中所有行
	 */        
	 function delRows(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(i = 0; i < chk.length; i++){
			var curRow = chk[i].parentNode.parentNode;		
			table.deleteRow(curRow.rowIndex);
			i = -1;
		}
        amount();
     }
	
	/**
	 *  增加凭证
	 */        
	 function save(){

         if (checkForm(insertReceiptMentFrm)){
 	         if ($('input[name=receiptMentBillPo.sLrbrbTypeID]').val() == '1' && Number($('#sLpbpbCostPriceAmount').val()) != Number($('#receiptMentAmount').val())){
	             alert("本次核销金额与源单金额不相等!");
	             $('#sLpbpbCostPriceAmount').val($('#payMentAmount').val());
	             return;
	         }
	        
	 		 var chk = document.getElementsByName("chk").length;	     
	 	     if (chk != 0 || $('input[name=receiptMentBillPo.sLrbrbTypeID]').val() == '2'){ 
	 		     var auditState = document.getElementsByName("auditState");
	 			 if (auditState != null  && auditState.length != 0 ){
	 		         if (!auditState[0].checked){
	 		        	insertReceiptMentFrm.action = "updateReceiptMentBill.action?auditState=0";
	 			     }else{
	 			    	insertReceiptMentFrm.action = "updateReceiptMentBill.action?auditState=1";
	 			     }
	 			  }else{
	 				 insertReceiptMentFrm.action = "updateReceiptMentBill.action?auditState=0";
	 			  }
	 	          $("img").removeAttr("onclick");
	 	          insertReceiptMentFrm.submit();       
	 		            
	 	     }else{
	 	         alert('请先选择数据!');
	 	     }
	 	     return; 
           }
	 }
	        
	/**
	 *  选择单据开窗
	 */         
	 function search(){
         if (checkForm(insertReceiptMentFrm)){
     	     var topRows = top.document.getElementById("total").rows;
    		 var topCols = top.document.getElementById("btmframe").cols;		
    		 if(is_iPad()){
    		     showPopWin("initFranchiseeOpenSel.action?franchiseeID="+$('#franchiseeID').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
    		 }else{
    			 showPopWin("initFranchiseeOpenSel.action?franchiseeID="+$('#franchiseeID').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
    		 }
    		 document.getElementById('popupTitle').innerHTML="【客户批发调货单查询】";
         }
	 }
	        
	/**
	 *  选择单据开窗赋值
	 */        
    function openGoodSingleValues(objValue){
		var receiptmentbills = eval('(' + objValue + ')');
		for(var i = 0; i < receiptmentbills.length; i++){	
			addRow(receiptmentbills[i]);			
		}		
		amount();
	}

    var index = 0;
	function addRow(receiptmentbill){
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);

		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
		    if (chk[i].value == receiptmentbill.billid) return;
		}

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		
		row.className = 'row';
		c1.height="26";
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + receiptmentbill.billid + '" >';
        c2.innerHTML = receiptmentbill.billid + '<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeAllocateID" value="' + receiptmentbill.billid +'" />';
        c3.innerHTML = receiptmentbill.billtype + '<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeBillTypeID" value="' + receiptmentbill.billtype +'" />';	
        c4.innerHTML = receiptmentbill.billdate + '<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeBillDate" value="' + receiptmentbill.billdate +'" />';
        c5.innerHTML = receiptmentbill.costpriceamount + '<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeCostPriceAmount" value="' + receiptmentbill.costpriceamount +'" />';
        c6.innerHTML = receiptmentbill.receiptMentamount + '<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeReceiptedMentAmount" value="' + receiptmentbill.receiptMentamount +'" />';
        c7.innerHTML = receiptmentbill.notreceiptmentamount + '<input id="notreceiptamount'+index+'" type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeNotReceiptedMentAmount" value="' + receiptmentbill.notreceiptmentamount +'" />';
		c8.innerHTML = '<input type="text" id="receiptamount'+index+'" name="receiptMentBillEntryTempPo.sLrbrbeReceiptMentAmount" value="' + receiptmentbill.notreceiptmentamount + '" class="text_input100" onblur="toFixAndNan(this,'+index+')" maxlength="10" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写收款金额!\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请重新填写收款金额!\'}]"/>';	
		c9.innerHTML = '<input type="text" name="receiptMentBillEntryTempPo.sLrbrbeRemark" maxlength="200"/>';

        c5.id="td1";
        c6.id="td2";
        c7.id="td3";
        c8.id="td4";
        
	}

	function toFixAndNan(obj,index){
		if (obj.value == '' || obj.value == null || obj.value == 'NaN' || isNaN(obj.value)){
		    alert("请重新填写金额!");
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
            alert("请重新填写金额!");
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
                alert("请重新填写金额!");
                obj.value = parseFloat(0.00).toFixed(2);
                return;
            }
            count = 0;
        }        
        
        //金额只能保留两位小数     
        if (strLastIndexOf >= 0 && objLength-strLastIndexOf > 3){
            alert("请重新填写金额!");            
        }
        obj.value = parseFloat(obj.value).toFixed(2);
        
        if (Number($('#notreceiptamount'+index).val()) < 0){
            if (Number($('#notreceiptamount'+index).val()) > Number($('#receiptedamount'+index).val())){
                alert("请重新填写金额!");
                obj.value = parseFloat(0.00).toFixed(2);
                return;
            }
        }else{
            if (Number($('#notreceiptamount'+index).val()) < Number($('#receiptamount'+index).val())){
                alert("请重新填写金额!");
                obj.value = parseFloat(0.00).toFixed(2);
                return;
            }
        }
        if (accMul(Number($('#notreceiptamount'+index).val()), Number($('#receiptamount'+index).val())) <= 0){
            alert("请重新填写金额!");
            obj.value = parseFloat(0.00).toFixed(2);
            return;
        }
        
        amount();
	}
    
    /**
	 *  删除表格中选中的行
	 */	       
	 function del(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(var i = 0; i < chk.length; i++){
			if (chk[i].checked) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}				
		document.all.chks.checked = false;
		amount();
	 }
	        
	/**
	 *  自动计算相关数据
	 */	       
	function amount(){
		 amount2();
		 $('#sLrbrbCurrentReverseAmount').val(parseFloat($('#td4t').text()).toFixed(2));		
	}

	function amount2(){
  	    for(var i=1;i<5;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=parseFloat(accAdd(total,$(this).find("input").val())).toFixed(2);
				}else{
					total=parseFloat(accAdd(total,$(this).text())).toFixed(2);
				}
			});
			$('#td'+i+'t').text(parseFloat(total).toFixed(2));
		}

  	    $('#costPriceAmount').val(parseFloat($('#td1t').text()).toFixed(2));
  	    $('#receiptAmount').val(parseFloat($('#td2t').text()).toFixed(2));
		$('#notReceiptMentAmount').val(parseFloat($('#td3t').text()).toFixed(2));	
		$('#receiptMentAmount').val(parseFloat($('#td4t').text()).toFixed(2));
		$('#sLpbpbCostPriceAmount').val(parseFloat($('#td4t').text()).toFixed(2));		
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
	    
    //子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		amount();
	}
    
    function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.billid){
			   $(this).parent().parent().remove();	
           }
		});
		
		amount();
    }

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        }); 

        if ('${receiptMentBillPo.sLrbrbTypeID}' == '1'){
        	amount2();
        }else{
	        $('#sLpbpbCostPriceAmount').removeAttr('readonly');
	        $('#sLrbrbCurrentReverseAmount').attr('readonly','readonly');
        }
    }); 	
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form action="" method="post" id="insertReceiptMentFrm">
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
                          <TD width="9%" class="table_body">收款单号</TD>
                          <TD width="24%" class="table_none">
                              ${receiptMentBillPo.sLrbrbID}&nbsp;
                              <input type="hidden" id="receiptMentID" name="receiptMentBillPo.sLrbrbID" class="text_input160" value="${receiptMentBillPo.sLrbrbID}" readonly="readonly">
                              <input type="hidden" id="franchiseeID" name="receiptMentBillPo.sLrbrbFranchiseeID" class="text_input160" value="${receiptMentBillPo.sLrbrbFranchiseeID}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body">收款日期</TD>
                          <TD width="24%" class="table_none">${receiptMentBillPo.sLrbrbDate}&nbsp;</TD>
                          <TD width="9%" class="table_body">客户名称</TD>
                          <TD width="30%" class="table_none">${receiptMentBillPo.sLrbrbFranchiseeName}&nbsp;</TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none">${receiptMentBillPo.sLrbrbCreatePersonName}&nbsp;</TD>
                          <TD class="table_body">收款类型</TD>
                          <TD class="table_none">${receiptMentBillPo.sLrbrbTypeID == '1' ? '批发收款' : '调账' }&nbsp;
                          <input type="hidden" name="receiptMentBillPo.sLrbrbTypeID" value="${receiptMentBillPo.sLrbrbTypeID}" readonly="readonly">
                          </TD>  
                          <TD class="table_body" >核销金额</TD>
                          <TD class="table_none">
                              <input type="text" id="sLpbpbCostPriceAmount" name="sLpbpbCostPriceAmount" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写核销金额!'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '请重新填写核销金额!'}]" maxlength="10" value="${receiptMentBillPo.sLrbrbCurrentReceiptMentAmount}" readonly="readonly" onblur="$('#sLrbrbCurrentReverseAmount').val(this.value)">
                          </TD>
                        </TR>
                        <TR height="26px">
                          <TD class="table_body" >实际收款</TD>
                          <TD class="table_none" colspan="5">
                              <input type="text" id="sLrbrbCurrentReverseAmount" name="receiptMentBillPo.sLrbrbCurrentReverseAmount" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写实际金额!'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '请重新填写实际金额!'}]" maxlength="10" value="${receiptMentBillPo.sLrbrbCurrentReverseAmount }">
                          </TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">摘要</TD>
                          <TD class="table_none" colSpan=6><label>
                            <textarea name="receiptMentBillPo.sLrbrbRemark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [201]}, 'Message' : '摘要不能大于400字！'}]">${receiptMentBillPo.sLrbrbRemark}</textarea>
                            </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    
                <c:if test="${receiptMentBillPo.sLrbrbTypeID == '1'}">      
                    <TABLE id="searchTab" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_xzdj_0.png" title="选择单据" onClick="search()">
                            </li>
                            <li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onClick="del()">
                            </li>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                </c:if>
                         
                <c:if test="${not empty(receiptMentBillEntryList)}">                  
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
                          <TH scope=col width="15%">单据编号</TH>
                          <TH scope=col width="15%">单据类型</TH>
                          <TH scope=col width="15%">单据日期</TH>
                          <TH scope=col width="10%">单据金额</TH>
                          <TH scope=col width="10%">已收金额</TH>
                          <TH scope=col width="10%">未收金额</TH>
                          <TH scope=col width="10%">收款金额</TH>
                          <TH scope=col width="10%">摘要</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26" colspan="4">合计：</TD> 
                          <TD><div id="td1t"></div><input type="hidden" id="costPriceAmount" name="receiptMentBillPo.sLrbrbCostPriceAmount"></TD>
                          <TD><div id="td2t"></div><input type="hidden" id="receiptAmount" name="receiptMentBillPo.sLrbrbReceiptMentAmount"></TD>
                          <TD><div id="td3t"></div><input type="hidden" id="notReceiptMentAmount" name="receiptMentBillPo.sLrbrbNotReceiptMentAmount"></TD>
                          <TD><div id="td4t"></div><input type="hidden" id="receiptMentAmount" name="receiptMentBillPo.sLrbrbCurrentReceiptMentAmount"></TD>
                          <TD>&nbsp;</TD>
                        </TR>
                    <s:iterator value="receiptMentBillEntryList" status="idx">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD height="26"><input type="checkbox" id="chk" name="chk" value="${sLrbrbeAllocateID}"></TD>
						  <TD>${sLrbrbeAllocateID}<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeAllocateID" value="${sLrbrbeAllocateID}" readonly="readonly"></TD>
						  <TD>${sLrbrbeBillTypeID}<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeBillTypeID" value="${sLrbrbeBillTypeID}" readonly="readonly"></TD>
						  <TD>${sLrbrbeBillDate}<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeBillDate" value="${sLrbrbeBillDate}" readonly="readonly"></TD>
						  <TD id="td1">${sLrbrbeCostPriceAmount}<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeCostPriceAmount" value="${sLrbrbeCostPriceAmount}" readonly="readonly"></TD>
						  <TD id="td2">${sLrbrbeReceiptedMentAmount}<input type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeReceiptedMentAmount" value="${sLrbrbeReceiptedMentAmount}" readonly="readonly"></TD>
						  <TD id="td3">${sLrbrbeNotReceiptedMentAmount}<input id="notreceiptamount${idx.index}" type="hidden" name="receiptMentBillEntryTempPo.sLrbrbeNotReceiptedMentAmount" value="${sLrbrbeNotReceiptedMentAmount}" readonly="readonly"></TD>
						  <TD id="td4"><input id="receiptamount${idx.index}" type="text" name="receiptMentBillEntryTempPo.sLrbrbeReceiptMentAmount" value="${sLrbrbeReceiptMentAmount}" class="text_input100" onblur="toFixAndNan(this,'${idx.index}')" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写收款金额!'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '请重新填写收款金额!'}]"></TD>
						  <TD><input type="text" name="receiptMentBillEntryTempPo.sLrbrbeRemark" value="${sLrbrbeRemark}"  maxlength="200"></TD>
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
                          <c:if test="${permissionPo.keyg=='1'}"><input type="checkbox" id="auditState" name="auditState" value="1">保存并审核</c:if> </li>
                          </TD>
					   </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
               </div>
                </TD>
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