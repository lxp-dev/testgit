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

		document.getElementById('departmentID').value = '';
		document.getElementById('bdpdepartmentname').value = '';
		
        if ($('#sLpbpbTypeID').val() == '5'){
        	delRows2();
        }else{
        	delRows();
        }
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

	 function delRows2(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('addTable2');
		for(i = 0; i < chk.length; i++){
			var curRow = chk[i].parentNode.parentNode;		
			table.deleteRow(curRow.rowIndex);
			i = -1;
		}
        amount2();
	 }
	
	/**
	 *  增加凭证
	 */        
	 function save(){
        if ($('#sLpbpbTypeID').val() == '5'){
        	save2();
        	return;
        }
	        
	    var supplierID = document.getElementById('supplierID').value;	     
		var supplierName = document.getElementById('supplierName').value;
		if (supplierID == "" || supplierName == ""){
	        alert("制造商不能为空!");
	        return;
	    }
	    
	    if (checkForm(insertPayMentFrm)){
	        if (($('#sLpbpbTypeID').val()!='3' && $('#sLpbpbTypeID').val()!='6' && $('#sLpbpbTypeID').val()!='7') && (Number($('#sLpbpbCostPriceAmount').val()) != Number($('#payMentAmount').val()))){
	            alert("本次核销金额与源单核销总金额不相等!");
	            $('#sLpbpbCostPriceAmount').val($('#payMentAmount').val());
	            return;
	        }else if ($('#sLpbpbTypeID').val()=='3' || $('#sLpbpbTypeID').val()=='6' || $('#sLpbpbTypeID').val()=='7'){
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
	        
	     	var chk = document.getElementsByName("chk").length;	     
	        if (($('#sLpbpbTypeID').val()=='2' && chk != 0) || $('#sLpbpbTypeID').val()=='3' || $('#sLpbpbTypeID').val()=='4' || $('#sLpbpbTypeID').val()=='6' || $('#sLpbpbTypeID').val()=='7'){ 
			    var auditState = document.getElementsByName("auditState");
			    if (auditState != null  && auditState.length != 0 ){
				    if (!auditState[0].checked){
			            insertPayMentFrm.action = "insertPayMentBillSimple.action?auditState=0";
			        }else{
			            insertPayMentFrm.action = "insertPayMentBillSimple.action?auditState=1";
			        }
			    }else{
			        insertPayMentFrm.action = "insertPayMentBillSimple.action?auditState=0";
			    }			    
                $("img").removeAttr("onclick");
		        insertPayMentFrm.submit();         
		            
	        } else{
	            alert('请先选择数据!');
	        }
	        return;
	    }
	    
	 }

	/**
	 *  增加其他付款单
	 */        
	 function save2(){	
        if (Number($('#sLpbpbCostPriceAmount').val()) != Number($('#costPriceAmount').val())){
            alert("本次核销金额与源单核销总金额不相等!");
            $('#sLpbpbCostPriceAmount').select();
            return;
        }
   
	    if (checkForm(insertPayMentFrm)){

	    	var count = 0;
            if ($('#departmentID').val() != ''){
                count = accAdd(count,1);
            }
            if ($('#supplierID').val() != ''){
            	count = accAdd(count,1);
            }
            if (count > 1){
                alert('不能同时选取部门和制造商!');
                return;
            }
            if (count == 0){
                alert('请先选取部门或制造商!');
                return;
            }
		    
		    var chk = document.getElementsByName("chk").length;	     
	        if (chk != 0){ 
	        	var obj = document.getElementsByName("payMentBillEntryTempPo.sLpbpbeInvoiceID");
		        for (var i = 0; i < obj.length; i++){
		            if (obj[i].value == '' || obj[i].value == null){
		                alert("请选择科目!");
		                return;
		            }
		        }
			    var auditState = document.getElementsByName("auditState");
			    if (auditState != null  && auditState.length != 0 ){
				    if (!auditState[0].checked){
			            insertPayMentFrm.action = "insertPayMentBillOther.action?auditState=0";
			        }else{
			            insertPayMentFrm.action = "insertPayMentBillOther.action?auditState=1";
			        }
			    }else{
			        insertPayMentFrm.action = "insertPayMentBillOther.action?auditState=0";
			    }
	            $("img").removeAttr("onclick");
		        insertPayMentFrm.submit();  

		            
	        } else{
	            alert('请先选择数据!');
	        }
	        return; 
	    }    

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
	   if ($('#sLpbpbTypeID').val()==''){
	       alert("请先选择单据类型!");
	       return;
	   }
	   
	   var path = "";
	   if ($('#sLpbpbTypeID').val()=='2'){
	   	   path = "initProcurementBillOpen.action?" + url;
	   }else{
	   	   path = "initAdvancePayMentBillOpenSel.action?" + url;
	   }
	   
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(path,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(path,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【单据查询】";
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
		    if (chk[i].value == paymentbill.payMentBillID) return;
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
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + paymentbill.payMentBillID + '" >';
        c2.innerHTML = paymentbill.payMentBillID + '<input type="hidden" name="payMentBillEntryTempPo.sLpbpbeInvoiceID" value="' + paymentbill.payMentBillID +'" />';
        c3.innerHTML = paymentbill.payedMentDate;
		c4.innerHTML = paymentbill.payMentBillType;	
        
        c5.innerHTML = paymentbill.costPriceAmount;
        c6.innerHTML = paymentbill.payedMentAmount;
		c7.innerHTML = paymentbill.notPayedMentAmount+'<input id="notpayamount'+index+'" type="hidden" name="payMentBillEntryTempPo.sLpbpbeCostPriceAmount" value="' + paymentbill.notPayedMentAmount + '"/>';	
        c8.innerHTML = '<input type="text" id="payedamount'+index+'" name="payMentBillEntryTempPo.sLpbpbePayMentAmount" value="' + paymentbill.notPayedMentAmount + '" onblur="toFixAndNan(this,'+index+')"/>';
        c9.innerHTML = '<input type="text" name="payMentBillEntryTempPo.sLpbpbeRemark"/>';
    
        c5.id="td1";
        c6.id="td2";
        c7.id="td3";
        c8.id="td4";
    
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

	function toFixAndNan2(obj,index){
		if (obj.value == '' || obj.value == null || obj.value == 'NaN' || isNaN(obj.value)){
		    alert("不正确的金额!");
            obj.value = parseFloat(0.00).toFixed(2);
            amount2();
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
            amount2();
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
        amount2();
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

	 function del2(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('addTable2');
		for(var i = 0; i < chk.length; i++){
			if (chk[i].checked) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}				
		document.all.chks.checked = false;
		amount2();
	}
	        
	/**
	 *  自动计算相关数据
	 */	       
	 function amount(){
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
		$('#costPriceAmount').val(parseFloat($('#td3t').text()).toFixed(2));	
		$('#payMentAmount').val(parseFloat($('#td4t').text()).toFixed(2));
		$('#sLpbpbCostPriceAmount').val($('#payMentAmount').val());
		if ($('#sLpbpbTypeID').val()!='4' && $('#sLpbpbTypeID').val()!='3'){
		    $('#sLpbpbPayMentAmount').val($('#payMentAmount').val());
		}else{
		    $('#sLpbpbPayMentAmount').val("0.00");
		}
	}

	 function amount2(){
		var total = 0;
		$('input[name=payMentBillEntryTempPo.sLpbpbeCostPriceAmount]').each(function(){
            total=parseFloat(accAdd(total,$(this).val())).toFixed(2);    
		});
		$('#costPriceAmountTotal').text(parseFloat(total).toFixed(2));
		$('#costPriceAmount').val(parseFloat(total).toFixed(2));
		$('#sLpbpbCostPriceAmount').val(parseFloat(total).toFixed(2));
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

	function chkAll2(){  
        var chks=document.all.chks2;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }

    $(document).ready(function(){    
    	$("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    		 
        amount();
        cleanDepartment('2');
        changePayMentBillType(document.getElementById('queryClassify'));
        
        $('td[dpt2=dpt2]').hide();
        $('#payClassify2').attr('disabled','disabled');
	});
	
	function changePayMentBillType(obj){    
	    if (obj.value != '2' && obj.value != '4'){
	        document.getElementById('searchTab').style.display="none";
	    }else{
	        document.getElementById('searchTab').style.display="block";
	    }
	    if (obj.value != '2'){
	        document.getElementById('sLpbpbPayMentAmount').disabled="0";
	        document.getElementById('sLpbpbPayMentAmount').value="0.00"
	    }else{
	        document.getElementById('sLpbpbPayMentAmount').disabled=null;
	        document.getElementById('sLpbpbPayMentAmount').value="0.00"
	    }

        hideaddTRable(obj.value);
        
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
         	if($(this).val()== goodInfo.payMentBillID){
			   $(this).parent().parent().remove();	
           }
		});
		
		amount();
    }

    function cleanDepartment(val){
        $('#sLpbpbTypeID').val(val);

        if (val == '5'){
        	delRows();
        	$('#payClassify2').removeAttr('disabled');
        }else{
        	delRows2();
        	$('#payClassify2').attr('disabled','disabled');
        }

        $('td[dpt1=dpt1]').show();
        $('td[dpt2=dpt2]').hide();

        $('#payClassify1').attr('checked','checked');
        
        hideaddTRable(val);
        
    }

    function hideaddTRable(val){
        if (val == '5'){
            $('#addTable').hide();
            $('#queryBill').hide();
            $('#addTable2').show();
            $('#queryBill2').show();
        }else if (val == '2'){
            $('#addTable2').hide();
            $('#queryBill2').hide();
            $('#addTable').show();
            $('#queryBill').show();
        }else{
            $('#addTable2').hide();
            $('#queryBill2').hide();
            $('#addTable').hide();
            $('#queryBill').hide();
        }
    }

    /**
	 * 科目开窗
	 */ 
     function openSubject(value){
        document.getElementById("indexs").value = value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selSubjectOpenTree.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSubjectOpenTree.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【会计科目查询】";
     }
     
    /**
	 * 科目开窗赋值
	 */ 
     function openSubjectValue(json){         
         var indes= document.getElementById("indexs").value;
         document.getElementById("InOrOutComeType"+indes).value=json.subject;        
         document.getElementById("InOrOutComeTypeID"+indes).value=json.subjectID;
     }

 	function addRow2(){
 		var table = document.getElementById('addTable2');
 		index = accAdd(index,table.rows.length - 1);

 		var row = table.insertRow(table.rows.length);
 		var c1 = row.insertCell(0);
 		var c2 = row.insertCell(1);
 		var c3 = row.insertCell(2);
 		var c4 = row.insertCell(3);
 		
 		row.className = 'row';
 		c1.height="26";
 		
 		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" >';
 		c2.innerHTML = '<li class="horizontal_onlyRight"><input id=InOrOutComeType'+index+' readonly="readonly" class="text_input160" />'
 		              +'<input type="hidden" id=InOrOutComeTypeID'+index+' name="payMentBillEntryTempPo.sLpbpbeInvoiceID" /></li>'
 		              +'<li class="horizontal_onlyRight"><img btn=btn src="${ctx}/img/newbtn/btn_change_0.png" onClick="openSubject('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_0.png\');" style="cursor: hand;"/></li>';          		
 		       
        c3.innerHTML = '<input style="width:100" id="notpayamount'+index+'" type="text" name="payMentBillEntryTempPo.sLpbpbeCostPriceAmount" value="0.00" onblur="toFixAndNan2(this,'+index+')" maxlength="18"/>';
 		c4.innerHTML = '<input style="width:350" type="text" name="payMentBillEntryTempPo.sLpbpbeRemark" maxlength="200"/>';	
     }

    function cleanClassify(val){
        if (val == '1'){
            $('td[dpt1=dpt1]').show();
            $('td[dpt2=dpt2]').hide();
        }else{
            $('td[dpt1=dpt1]').hide();
            $('td[dpt2=dpt2]').show();
        }

		document.getElementById('departmentID').value = '';
		document.getElementById('bdpdepartmentname').value = '';
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';		
    }

	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentInOrOutStorageOpen.action?isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentInOrOutStorageOpen.action?isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}

	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(json){
		document.getElementById('departmentID').value = json.id;
		document.getElementById('bdpdepartmentname').value = json.value;

		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';		
	}

	function autoCostPriceAmount(obj){

		if ($('#sLpbpbTypeID').val() != '2'){
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
		
</script>
	</head>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" id="insertPayMentFrm">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="indexs" name="indexs">
		
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
                          <TD width="30%" class="table_none">
                              ${payMentID}
                              <input type="hidden" id="payMentID" name="payMentBillPo.sLpbpbID" class="text_input160" value="${payMentID}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body">付款日期</TD>
                          <TD width="18%" class="table_none">
                              ${payMentDate}
                              <input type="hidden" id="payMentDate" name="payMentBillPo.sLpbpbDate" class="text_input100" value="${payMentDate}" readonly="readonly">
                          </TD>
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none">
                              ${createPerson}
                              <input type="hidden" id="createPerson" name="payMentBillPo.sLpbpbCreatePersonID" class="text_input160" value="${createPersonID}" readonly="readonly">
                          </TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body">单据类型</TD>
                          <TD class="table_none">
                              <input type="radio" id="queryClassify" name="queryClassify" value="2" onclick="cleanDepartment('2');changePayMentBillType(this);" checked="checked"/>采购付款&nbsp;
                              <input type="radio" id="queryClassify" name="queryClassify" value="3" onclick="cleanDepartment('3');changePayMentBillType(this);"/>预付款&nbsp;
                              <input type="radio" id="queryClassify" name="queryClassify" value="6" onclick="cleanDepartment('6');changePayMentBillType(this);"/>厂商减账&nbsp;
                              <input type="radio" id="queryClassify" name="queryClassify" value="7" onclick="cleanDepartment('7');changePayMentBillType(this);"/>调账&nbsp;
                              <input type="radio" id="queryClassify" name="queryClassify" value="5" onclick="cleanDepartment('5');changePayMentBillType(this);"/>其他付款&nbsp;
                              <input type="hidden" id="sLpbpbTypeID" name="payMentBillPo.sLpbpbTypeID" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '单据类型不能为空！'}]">
                          </TD>
                          <TD class="table_body" >付款种类</TD>
                          <TD class="table_none">
                              <input type="radio" id="payClassify1" name="payClassify" value="1" onclick="cleanClassify('1');" checked="checked" />按制造商&nbsp;
                              <input type="radio" id="payClassify2" name="payClassify" value="2" onclick="cleanClassify('2');"/>按部门
                          </TD>
                          <TD width="9%" class="table_body" dpt1=dpt1>制造商</TD>
                          <TD width="20%" class="table_none" dpt1=dpt1>
                          <li class="horizontal_onlyRight">
                            <input type="text" id="supplierName" name="supplierName" class="text_input160" readonly="readonly" value="${supplierName}">
                            <input type="hidden" id="supplierID" name="payMentBillPo.sLpbpbSupplierID" class="text_input160" value="${supplierID}">
                          </li>
                            <li class="horizontal_onlyRight">                              
                              <img btn=btn id="searchBtn" name="searchBtn" src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onclick="openSupplier();" >
                            </li>
                          </TD>
                          <TD width="9%" class="table_body" dpt2=dpt2>部门</TD>
                          <TD width="20%" class="table_none" dpt2=dpt2>
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" id="bdpdepartmentname" name="bdpdepartmentname" type="text"  />						   		
						   		<input type="hidden" id="departmentID" name="payMentBillPo.sLpbpbPayMentDptID" class="text_input160" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openDepartment();">
						   </li>
                          </TD>
                        </TR>
                        <TR height="26px">
                          <TD class="table_body" >本次核销</TD>
                          <TD class="table_none">
                              <input type="text" id="sLpbpbCostPriceAmount" class="text_input100" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);};autoCostPriceAmount(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '本次核销金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '本次核销金额格式错误！'}]">
                              <input type="hidden" id="costPriceAmount" name="payMentBillPo.sLpbpbCostPriceAmount">
                              <input type="hidden" id="payMentAmount" name="payMentBillPo.sLpbpbPayMentAmount">
                              
                          </TD>
                          
                          <TD class="table_body" >本次付款</TD>
                          <TD class="table_none" colspan="5">
                              <input type="text" id="sLpbpbPayMentAmount" name="payMentBillPo.sLpbpbCurrentPayMentAmount" class="text_input100" disabled="disabled" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '本次付款金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '本次付款金额格式错误！'}]">
                          </TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">摘要</TD>
                          <TD class="table_none" colSpan=6><label>
                            <textarea name="payMentBillPo.sLpbpbRemark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${remark}</textarea>
                            </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id="queryBill" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" id="searchTab">
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn" src="${ctx }/img/newbtn/btn_xzdj_0.png" title="选择单据" onClick="javascript:search()" >
                            </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="delBtn" src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onclick="del()" >
                            </li>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id="queryBill2" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn2" src="${ctx }/img/newbtn/btn_tjkm_0.png" title="添加科目" onClick="addRow2();" >	
                            </li>
                            <li class="horizontal_onlyRight">
                             <img btn=btn id="delBtn" src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onClick="del2()">
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
                          <TH scope=col width="5%" height="26"><input type="checkbox" id="chks" name="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="15%">源单编号</TH>
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

                      </TBODY>
                    </TABLE>
                    
                    <table id="addTable2" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26"><input type="checkbox" id="chks2" name="chks2" onclick="chkAll2()">选择</TH>
                          <TH scope=col width="12%" >科目名称</TH>
                          <TH scope=col width="6%">金额(含税)</TH>
                          <TH scope=col width="20%">备注</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26" colspan="2" align="right">合计：</TD> 
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div></TD>
                          <TD></TD>
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