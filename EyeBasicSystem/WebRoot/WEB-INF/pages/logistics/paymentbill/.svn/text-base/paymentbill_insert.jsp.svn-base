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
	  * 制造商开窗
	  */
	 function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
		 
	 }
	
	 /**
	  * 开窗赋值实现方法
	  */
	 function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;			
		delRows();
	 }
	        
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
	    var supplierID = document.getElementById('supplierID').value;	     
		var supplierName = document.getElementById('supplierName').value;
		if (supplierID == "" || supplierName == ""){
	        alert("制造商不能为空!");
	        return;
	    }

	    var chk = document.getElementsByName("chk").length;	     
        if (chk != 0){ 
		    var auditState = document.getElementsByName("auditState");
		    if (auditState != null  && auditState.length != 0 ){
			    if (!auditState[0].checked){
		            insertPayMentFrm.action = "insertPayMentBill.action?auditState=0";
		        }else{
		            insertPayMentFrm.action = "insertPayMentBill.action?auditState=1";
		        }
		    }else{
		        insertPayMentFrm.action = "insertPayMentBill.action?auditState=0";
		    }
            $("img").removeAttr("onclick");
	        insertPayMentFrm.submit();       
	            
        } else{
            alert('请先选择数据!');
        }
         return; 
	 }
	        
	/**
	 *  选择单据开窗
	 */         
	 function search(){
	    var supplierID = document.getElementById('supplierID').value;	     
		var supplierName = document.getElementById('supplierName').value;
		if (supplierID == "" || supplierName == ""){
	        alert("制造商不能为空!");
	        return;
	    }
	   
	   var url = "supplierName="+EncodeUtf8(supplierName)+"&supplierID="+supplierID;	              	 
	   	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInvoiceOpenSel.action?" + url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initInvoiceOpenSel.action?" + url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【发票查询】";
	 }
	        
	/**
	 *  选择单据开窗赋值
	 */        
    function openGoodSingleValues(objValue){
		var paymentbills = eval('(' + objValue + ')');
		for(var i = 0; i < paymentbills.length; i++){	
			addRow(paymentbills[i]);			
		}		
		amount();
	}

    var index = 0;
	function addRow(paymentbill){
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);

		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
		    if (chk[i].value == paymentbill.invoiceid) return;
		}

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		
		row.className = 'row';
		c1.height="26";
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + paymentbill.invoiceid + '" >';
        c2.innerHTML = paymentbill.invoiceid + '<input type="hidden" name="payMentBillEntryTempPo.sLpbpbeInvoiceID" value="' + paymentbill.invoiceid +'" />';
        c3.innerHTML = paymentbill.costpriceamount + '<input id="notpayamount'+index+'" type="hidden" name="payMentBillEntryTempPo.sLpbpbeCostPriceAmount" value="' + paymentbill.costpriceamount +'" />';
		c4.innerHTML = '<input type="text" id="payedamount'+index+'" name="payMentBillEntryTempPo.sLpbpbePayMentAmount" value="' + paymentbill.costpriceamount + '" onblur="toFixAndNan(this,'+index+')"/>';	
    }

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
         amount();
	});
	
	    
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
         	if($(this).val()== goodInfo.invoiceid){
			   $(this).parent().parent().remove();	
           }
		});
		
		amount();
    }	
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form action="" method="post" id="insertPayMentFrm">
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
                          <TD width="24%" class="table_none">
                              ${payMentID}
                              <input type="hidden" id="payMentID" name="payMentBillPo.sLpbpbID" class="text_input160" value="${payMentID}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body">付款日期</TD>
                          <TD width="24%" class="table_none">
                              ${payMentDate}
                              <input type="hidden" id="payMentDate" name="payMentBillPo.sLpbpbDate" class="text_input100" value="${payMentDate}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body">制造商</TD>
                          <TD width="30%" class="table_none">
                          <li class="horizontal_onlyRight">
                            <input type="text" id="supplierName" name="supplierName" class="text_input160" readonly="readonly" value="${supplierName}">
                            <input type="hidden" id="supplierID" name="payMentBillPo.sLpbpbSupplierID" class="text_input200" value="${supplierID}">
                          </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();" >	
                            </li></TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none" colSpan=5>
                              ${createPerson}
                              <input type="hidden" id="createPerson" name="payMentBillPo.sLpbpbCreatePersonID" class="text_input160" value="${createPersonID}" readonly="readonly">
                          </TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><label>
                            <textarea name="payMentBillPo.sLpbpbRemark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${remark}</textarea>
                            </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn" name="searchBtn"  src="${ctx }/img/newbtn/btn_xzdj_0.png" title="选择单据" onClick="search()">
                            </li>
                            <li class="horizontal_onlyRight">
                            <img btn=btn id="delBtn" src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onClick="del()">
                            </li>
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
                          <TH scope=col width="5%" height="30"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="15%" height="30">发票号</TH>
                          <TH scope=col width="10%">价税合计</TH>
                          <TH scope=col width="10%">付款金额</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="28" colspan="2">合计：</TD> 
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div><input type="hidden" id="costPriceAmount" name="payMentBillPo.sLpbpbCostPriceAmount"></TD>
                          <TD><div id="payMentAmountTotal" name="payMentAmountTotal"></div><input type="hidden" id="payMentAmount" name="payMentBillPo.sLpbpbPayMentAmount"></TD>
                        </TR>

                      </TBODY>
                    </TABLE>
              
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