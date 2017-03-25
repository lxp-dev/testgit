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
	  * 制造商开窗
	  */
	 function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("ykselSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("ykselSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var table = document.getElementById('billTable');
		for(i = 0; i < chk.length; i++){
			var curRow = chk[i].parentNode.parentNode;		
			table.deleteRow(curRow.rowIndex);
			i = -1;
		}
		if (table != null){
		    table.style.display = "none";    
		}
		
        //相关数据清零
        var goodsquantityTotal = document.getElementById("goodsquantityTotal");
        if (goodsquantityTotal != null){
            goodsquantityTotal.innerText='0';
        }
        var notTaxRateAmountTotal = document.getElementById("notTaxRateAmountTotal");
        if (notTaxRateAmountTotal != null){
            notTaxRateAmountTotal.innerText='0';
        }
        var taxAmountTotal = document.getElementById("taxAmountTotal");
        if (taxAmountTotal != null){
            taxAmountTotal.innerText='0';
        }
        var costPriceAmountTotal = document.getElementById("costPriceAmountTotal");
        if (costPriceAmountTotal != null){
            costPriceAmountTotal.innerText='0';
        }
     }
     
    /**
	 *  根据凭证基本类型改变凭证具体类型
	 */         
	 function changeParentID(){
        delRows();
        $('#'+'sVoucherType').load("ykinitVoucherTypeByParentID.action?parentID="+document.getElementById('bVoucherType').value);
        
        var bVoucherType = document.getElementById('bVoucherType').value;
	    if (bVoucherType == "5" || bVoucherType == "6" || bVoucherType == "3" || bVoucherType == "8"){
	        document.getElementsByName('searchBtn')[0].style.visibility = "hidden";	
	        document.getElementsByName('supplierID')[0].value = "";
	        document.getElementsByName('supplierName')[0].value = "";
	    }else{
	        document.getElementsByName('searchBtn')[0].style.visibility = "visible";
	    }	                
	 }       
	 function changeSubID(){
        delRows();           
	 }
	
	/**
	 *  增加凭证
	 */        
	 function save(){
         if (document.getElementsByName('searchBtn')[0].style.visibility == "visible" ){
	         var supplierID = document.getElementById('supplierID').value;	     
		     var supplierName = document.getElementById('supplierName').value;
		     if (supplierID == "" || supplierName == ""){
	             alert("制造商不能为空!");
	             return;
	         }
	     }
	     var bVoucherType = document.getElementById('bVoucherType').value;
	     if (bVoucherType == ""){
	        alert("基本类型不能为空!");
	        return;
	     }
	     
	     if (bVoucherType == '5' || bVoucherType == '6' || bVoucherType == '8'){
	         var stocksID = document.getElementsByName('voucherEntryTempPo.sStockID');
	         if (stocksID.length != 0){
	         	 var stockID = stocksID[0];
	         	 for (var i = 1; i < stocksID.length; i++){
	                 if (stockID.value != stocksID[i].value){
	                     if (bVoucherType == '5' || bVoucherType == '6'){
	                         alert("请选择同一仓位的商品!");
	                     }else if (bVoucherType == '8'){
	                         alert("请选择同一部门的商品!");
	                     }	                     
	                     return;
	                 }
	             }	
	         }
     
	     }   
	     
	        
		 var sVoucherType = document.getElementById('sVoucherType').value;
		 if (sVoucherType == ""){
	        alert("具体类型不能为空!");
	        return;
	     }
	     switch(sVoucherType){
	       //发票
	       case '103':
	       case '104':
	       case '203':
	       case '204':
	       case '109':
	       case '110':
	       case '209':
	       case '210':	       
	                 sVoucherType = 'f';
	                 break;
	       //冲回
	       case '102':
	       case '106':
	       case '108':
	       case '202':
	       case '206':
	       case '208':
	                 sVoucherType = 'c';
	                 break;
	       //单据
	       default:  
	       	         sVoucherType = 'd';
	    }

	    var chk = document.getElementsByName("chk").length;	     
        if (chk != 0){
            var auditState = document.getElementsByName("auditState");
            $("img").removeAttr("onclick"); 
            if (auditState != null && auditState.length != 0){
	            if (!auditState[0].checked){
	                 insertVoucherFrm.action = "ykinsertVoucher.action?auditState=0&id="+sVoucherType;
	            }else{
	                 insertVoucherFrm.action = "ykinsertVoucher.action?auditState=1&id="+sVoucherType;
	            }   
            }else{
                insertVoucherFrm.action = "ykinsertVoucher.action?auditState=0&id="+sVoucherType;
            }        
	        insertVoucherFrm.submit();          
        } else{
            alert('请先选择数据!');
        }
                
        return; 
	 }
	        
	/**
	 *  选择单据开窗
	 */         
	 function search(){
	   var bVoucherType = document.getElementById('bVoucherType').value;
	   if (bVoucherType == ""){
	       alert("基本类型不能为空!");
	       return;
	   }	     
	   var sVoucherType = document.getElementById('sVoucherType').value;
	   if (sVoucherType == ""){
	       alert("具体类型不能为空!");
	       return;
	   }
	   var supplierID = document.getElementById('supplierID').value;	     
	   var supplierName = document.getElementById('supplierName').value;	  
       if (document.getElementsByName('searchBtn')[0].style.visibility == "visible"){
		   if (sVoucherType != '701' && sVoucherType != '801'){
		   	  if (supplierID == "" || supplierName == ""){
	              alert("制造商不能为空!");
	              return;
	          }
		   }
	   }	   

	   var type = null;
	   switch(sVoucherType){
	       //发票
	       case '103':
	       case '104':
	       case '203':
	       case '204':
	       case '109':
	       case '110':
	       case '209':
	       case '210':
	                 type = 'f';
	                 break;
	       //冲回
	       case '102':
	       case '106':
	       case '108':
	       case '202':
	       case '206':
	       case '208':
	                 type = 'c';
	                 break;
	       //盘点
	       case '501':
	       case '502':
	                 type = '5';
	                 break;
	       case '601':
	                 type = '6';
	                 break;
	       //销售出库
	       case '301':
	       case '302':
	       case '303':
	       case '304':
	       case '305':
	       case '306':
	                 type = '3';
	                 break;	      
	       //其他出库
	       case '801':
	                 type = '8';
	                 break;
	       //单据
	       default:  
	       	         type = 'd';
	   }	
	   var voucherID = document.getElementById('voucherID').value;
	   var voucherDate = document.getElementById('voucherDate').value;
	   var createPerson = document.getElementById('createPerson').value;
	   var remark = document.getElementById('remark').value;
	   
	   var url = "supplierName="+EncodeUtf8(supplierName)+"&supplierID="+supplierID+"&bVoucherType="+bVoucherType+"&sVoucherType="+sVoucherType+"&voucherID="+voucherID
	              +"&voucherDate="+voucherDate+"&createPerson="+EncodeUtf8(createPerson)+"&remark="+EncodeUtf8(remark)+"&type="+EncodeUtf8(type);
	 
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("ykinitSelectBillSels.action?moduleID=${moduleID}&" + url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("ykinitSelectBillSels.action?moduleID=${moduleID}&" + url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【单据查询】";	 
	 }
	        
	/**
	 *  选择单据开窗赋值
	 */        
	 function openGoodSingleValues(objValue){
	      var sVoucherType = document.getElementById('sVoucherType').value;	     	  
	      switch(sVoucherType){
	          //发票
	          case '103':
	          case '104':
	          case '203':
	          case '204':
	          case '109':
	          case '110':
	          case '209':
	          case '210':
	                     insertVoucherFrm.action="ykinitInvoiceVoucherInsert.action?moduleID="+$('#moduleID').val()+"&billID="+objValue+"&id="+"F";
	                     insertVoucherFrm.submit();
	                     break;
	          //冲回
	          case '102':
	          case '106':
	          case '108':
	          case '202':
	          case '206':
	          case '208':
	                	 insertVoucherFrm.action="ykinitReversalVoucherInsert.action?moduleID="+$('#moduleID').val()+"${moduleID}&billID="+objValue+"&id="+"C";
		                 insertVoucherFrm.submit();
	                     break;
	          //单据
	          default:  
	       	             insertVoucherFrm.action="ykselectBillGoodsInsert.action?moduleID="+$('#moduleID').val()+"&billID="+objValue+"&id="+"D";
	       	             insertVoucherFrm.submit();		
	     }
	 }
    
    /**
	 *  删除表格中选中的行
	 */	       
	 function del(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('billTable');
		var bills = new Array();
		var j = 0;
		for(var i = 0; i < chk.length; i++){
			if (chk[i].checked) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				bills[j++] = chk[i].value;
				i = -1;
			}
		}	
		
		delOtherByBillID(bills);
				
		document.all.chks.checked = false;
		if (chk.length == 0){
		    if (table != null){
		        table.style.display = "none";  
		    }
		}
		amount();
	 }
	
	/**
	 *  删除相同单据号的商品
	 */
	 function delOtherByBillID(bills){
     	var chk = document.getElementsByName("chk");
     	var table = document.getElementById('billTable');
     	for(var i = 0; i < chk.length; i++){
	     	for(var j = 0; j < bills.length; j++){
				if (chk[i].value == bills[j]) {
					var curRow = chk[i].parentNode.parentNode;		
					table.deleteRow(curRow.rowIndex);
					i = -1;
				}
			}
		}
	 }
	        
	/**
	 *  自动计算相关数据
	 */	       
	 function amount(){
	    var goodsquantityTotal = 0;
	    var goodsquantity = document.getElementsByName("voucherEntryTempPo.sGoodsQuantity");
	    if (goodsquantity.length != 0){	    				
		    for(i=0;i<goodsquantity.length;i++){
			    if(goodsquantity[i].value == '') continue;
			        goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		    }		
		    document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	    }
				
		var notTaxRateAmountTotal = 0;
		var notTaxRateAmount = document.getElementsByName("voucherEntryTempPo.sNotTaxRateAmount");		
		for(i=0;i<notTaxRateAmount.length;i++){
			if(notTaxRateAmount[i].value == '') continue;
			notTaxRateAmountTotal = (parseFloat(notTaxRateAmountTotal).add(parseFloat(notTaxRateAmount[i].value))).toFixed(2);
		}		
		document.getElementById("notTaxRateAmountTotal").innerText=notTaxRateAmountTotal;
		document.getElementById("notTaxRateAmount").innerText=notTaxRateAmountTotal;		
		
		var taxAmountTotal = 0;
		var taxAmount = document.getElementsByName("voucherEntryTempPo.sTaxAmount");		
		for(i=0;i<taxAmount.length;i++){
			if(taxAmount[i].value == '') continue;
			taxAmountTotal = (parseFloat(taxAmountTotal).add(parseFloat(taxAmount[i].value))).toFixed(2);
		}		
		document.getElementById("taxAmountTotal").innerText=taxAmountTotal;
		document.getElementById("taxAmount").innerText=taxAmountTotal;
		
		var costPriceAmountTotal = 0;
		var costPriceAmount = document.getElementsByName("voucherEntryTempPo.sCostPriceAmount");		
		for(i=0;i<costPriceAmount.length;i++){
			if(costPriceAmount[i].value == '') continue;
			costPriceAmountTotal = (parseFloat(costPriceAmountTotal).add(parseFloat(costPriceAmount[i].value))).toFixed(2);
		}		
		document.getElementById("costPriceAmountTotal").innerText=costPriceAmountTotal;
		document.getElementById("costPriceAmount").innerText=costPriceAmountTotal;
	}
	window.onload = function(){
		if (document.getElementsByName("notTaxRateAmount").length != 0){
		    amount();
		}
		
		if (document.all.sVoucherType.options.length == 0){
		    document.all.sVoucherType.options.add(new Option("----请选择----","")); 
		}
	}
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk = document.getElementsByName("chk");
        var chks = document.all.chks;
        for(var i = 0; i < chk.length; i++){
           chk[i].checked = chks.checked;
        }
    }
    
   /**
    *  根据发票（冲回）号查询发票（冲回）明细
    */
	function detail(invoiceID){
	   var path = '';
	   if (invoiceID.substring(0,1)=='I'){
	       path = 'ykinitInvoiceDetail.action?invoiceID='+invoiceID;
	   }else if (invoiceID.substring(0,1)=='R'){
	       path = 'ykselReversalDetail.action?reversalID='+invoiceID;
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
	 * 验证是否是合法的备注
	 */  
     function isValidRemark(szStr){
        if (document.activeElement.id == "button_0"){
	        return;
	    }     
        var voidChar = "'\"><";
        for(var i = 0 ; i < voidChar.length; i++){
            aChar = voidChar.substring(i, i + 1);
            if(szStr.value.indexOf(aChar) > -1){
                szStr.focus();
                alert("包含非法字符!");
                return;
            }
        }
     }
     
     $(document).ready(function(){    		 
		$('span[id=sNotTaxRateAmount]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});
		$('span[id=sNotTaxRate]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});		
		$('input[name=voucherEntryTempPo.sNotTaxRateAmount]').each(function(){
			$(this).val(parseFloat($(this).val()).toFixed(2));
		});

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
	<form action="" method="post" id="insertVoucherFrm">
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
                        <TR height="26">
                          <TD width="8%" class="table_body">凭证号</TD>
                          <TD width="26%" class="table_none">
                              ${voucherID}
                              <input type="hidden" id="voucherID" name="voucherID" class="text_input200" value="${voucherID}" readonly="readonly">
                          </TD>
                          <TD width="7%" class="table_body">凭证日期</TD>
                          <TD width="26%" class="table_none">
                              ${voucherDate}
                              <input type="hidden" id="voucherDate" name="voucherDate" class="text_input100" value="${voucherDate}" readonly="readonly">
                          </TD>
                          <TD class="table_body">制造商</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                            <input type="text" id="supplierName" name="supplierName" class="text_input200" readonly="readonly" value="${supplierName}">
                            <input type="hidden" id="supplierID" name="supplierID" class="text_input200" value="${supplierID}">
                          </li>
                            <li class="horizontal_onlyRight">
                               <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" id="searchBtn" name="searchBtn" onclick="openSupplier();" style="visibility: visible">
                            </li></TD>
                          </TR>
                        <TR height="26">
                          <TD class="table_body" >凭证人</TD>
                          <TD class="table_none" >
                              ${createPerson}
                              <input type="hidden" id="createPerson" name="createPerson" class="text_input200" value="${createPerson}" readonly="readonly">
                          </TD>
                          <TD class="table_body">凭证类型</TD>
                          <TD class="table_none" colspan="3">
                            <li class="horizontal_onlyRight">
                            <select id="bVoucherType" name="bVoucherType" ${empty(voucherTopIDList) ? 'disabled="disabled"' : ''} onChange="changeParentID()">
                                <option value="">----请选择----</option>
                              <s:iterator value="voucherTopIDList">
                                <c:if test="${sLvtvtId != '3' && sLvtvtId != '11'}">
                                <option value="${sLvtvtId}" ${parentID == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
                                </c:if>
	     	                  </s:iterator>                            
                            </select></li>
                            <li class="horizontal_onlyRight">                               
                            <select name="sVoucherType" id="sVoucherType" onchange="changeSubID()">
                              <s:iterator value="voucherSubsetIDList">
                                <option value="${sLvtvtId}"} ${subID == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
	     	                  </s:iterator>
                            </select>
                            </li>
						  </TD>
                        </TR>
                        <TR height="60px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><label>
                            <textarea name="remark" id="remark" onblur="isValidRemark(this)">${remark}</textarea>
                            </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_xzdj_0.png" title="选择单据" id="searchBtn" onClick="search()">
                            </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" id="delBtn" onClick="del()">
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
                 <c:if test="${id == 'D'}">
					<table id="billTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26"><input type="checkbox" onclick="chkAll()" id="chks">选择</TH>
                          <TH scope=col width="15%" height="26">单据号</TH>
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH scope=col width="5%">规格</TH>
                          <TH scope=col width="7%">数量</TH>
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
                          <TD><div id="notTaxRateAmountTotal"></div><input type="hidden" name="notTaxRateAmount"/></TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div id="taxAmountTotal"></div><input type="hidden" name="taxAmount"/></TD>
                          <TD><div id="costPriceAmountTotal"></div><input type="hidden" name="costPriceAmount"/></TD>
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input id="chk" name="chk" type="checkbox" value="${sLveveBillID}"><input type="hidden" name="voucherEntryTempPo.sLveveID" value="${sLveveID}" /></TD>
						  <TD height="26">${sLveveBillID}<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="${sLveveBillID}" /></TD>
						  <TD height="26">${sLveveGoodsID}<input type="hidden" name="voucherEntryTempPo.sLveveGoodsID" value="${sLveveGoodsID}" /></TD>
						  <TD>${sGoodsName}<input type="hidden" name="voucherEntryTempPo.sGoodsName" value="${sGoodsName}" /></TD>
						  <TD>${sSpec}<input type="hidden" name="voucherEntryTempPo.sSpec" value="${sSpec}" /></TD>
                          <TD>${sGoodsQuantity}<input type="hidden" name="voucherEntryTempPo.sGoodsQuantity" value="${sGoodsQuantity}"/></TD>
                          <TD><span id="sNotTaxRate">${sNotTaxRate}</span>
                          <input type="hidden" name="voucherEntryTempPo.sNotTaxRate" value="${sNotTaxRate}"/><input type="hidden" name="voucherEntryTempPo.sStockID" value="${sStockID}"/></TD>
						  <TD><span id="sNotTaxRateAmount">${sNotTaxRateAmount}</span><input type="hidden" name="voucherEntryTempPo.sNotTaxRateAmount" value="${sNotTaxRateAmount}"/></TD>
                          <TD>${sTaxRate}%<input type="hidden" name="voucherEntryTempPo.sTaxRate" value="${sTaxRate}"/></TD>
                          <TD>${sCostPrice}<input type="hidden" name="voucherEntryTempPo.sCostPrice" value="${sCostPrice}"/></TD>
						  <TD>${sTaxAmount}<input type="hidden" name="voucherEntryTempPo.sTaxAmount" value="${sTaxAmount}"/></TD>
                          <TD>${sCostPriceAmount}<input type="hidden" name="voucherEntryTempPo.sCostPriceAmount" value="${sCostPriceAmount}"/>
                          <input type="hidden" name="voucherEntryTempPo.sInvoiceState" value="${sInvoiceState}"/>
                          </TD>

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
                          <TH scope=col width="15%" height="26">发票号</TH>
                          <TH width="10%" height="26" scope=col>单据日期</TH>
                          <TH width="20%" scope=col>制造商名称</TH>
                          <TH scope=col width="10%">部门</TH>
                          <TH scope=col width="10%">审核人</TH>
                          <TH width="10%" scope=col>成本合计</TH>
                          <TH scope=col width="10%">税额合计</TH>
                          <TH scope=col width="10%">价税合计</TH>
                          <TH scope=col width="10%">详细</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>                          
                          <TD><div id="notTaxRateAmountTotal" name="notTaxRateAmountTotal"></div><input type="hidden" name="notTaxRateAmount"/></TD>                          
                          <TD><div id="taxAmountTotal" name="taxAmountTotal"></div><input type="hidden" name="taxAmount"/></TD>
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div><input type="hidden" name="costPriceAmount"/></TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk"></TD>                        
                          <TD>${sLveveBillID}<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="${sLveveBillID}" /></TD>
                          <TD>${fn:substring(sDate,0,10)}<input type="hidden" name="voucherEntryTempPo.sDate" value="${sDate}" /></TD>
			              <TD>${sSupplierName}<input type="hidden" name="voucherEntryTempPo.sSupplierName" value="${sSupplierName}" /></TD>
                          <TD>${sDepartment }<input type="hidden" name="voucherEntryTempPo.sDepartment" value="${sDepartment }" /></TD>
                          <TD>${sPersonID}<input type="hidden" name="voucherEntryTempPo.sPersonID" value="${sPersonID}" /></TD>
                          <TD><span id="sNotTaxRateAmount">${sNotTaxRateAmount}</span><input type="hidden" name="voucherEntryTempPo.sNotTaxRateAmount" value="${sNotTaxRateAmount}"/></TD>
             			  <TD>${sTaxAmount}<input type="hidden" name="voucherEntryTempPo.sTaxAmount" value="${sTaxAmount}"/></TD>
                          <TD>${sCostPriceAmount}<input type="hidden" name="voucherEntryTempPo.sCostPriceAmount" value="${sCostPriceAmount}"/></TD>
                          <TD>
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLveveBillID}')">
		                  </TD>
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
                          <TH scope=col width="15%" height="26">冲回号</TH>
                          <TH width="10%" height="26" scope=col>单据日期</TH>
                          <TH width="20%" scope=col>制造商名称</TH>
                          <TH scope=col width="10%">部门</TH>
                          <TH scope=col width="10%">审核人</TH>
                          <TH width="10%" scope=col>成本合计</TH>
                          <TH scope=col width="10%">税额合计</TH>
                          <TH scope=col width="10%">价税合计</TH>
                          <TH scope=col width="10%">详细</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>                          
                          <TD><div id="notTaxRateAmountTotal" name="notTaxRateAmountTotal"></div><input type="hidden" name="notTaxRateAmount"/></TD>                          
                          <TD><div id="taxAmountTotal" name="taxAmountTotal"></div><input type="hidden" name="taxAmount"/></TD>
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div><input type="hidden" name="costPriceAmount"/></TD>
                          <TD>&nbsp;</TD>
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk"></TD>                        
                          <TD>${sLveveBillID}<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="${sLveveBillID}" /></TD>
                          <TD>${fn:substring(sDate,0,10)}<input type="hidden" name="voucherEntryTempPo.sDate" value="${sDate}" /></TD>
			              <TD>${sSupplierName}<input type="hidden" name="voucherEntryTempPo.sSupplierName" value="${sSupplierName}" /></TD>
                          <TD>${sDepartment }<input type="hidden" name="voucherEntryTempPo.sDepartment" value="${sDepartment }" /></TD>
                          <TD>${sPersonID}<input type="hidden" name="voucherEntryTempPo.sPersonID" value="${sPersonID}" /></TD>
                          <TD><span id="sNotTaxRateAmount">${sNotTaxRateAmount}</span><input type="hidden" name="voucherEntryTempPo.sNotTaxRateAmount" value="${sNotTaxRateAmount}"/></TD>
             			  <TD>${sTaxAmount}<input type="hidden" name="voucherEntryTempPo.sTaxAmount" value="${sTaxAmount}"/></TD>
                          <TD>${sCostPriceAmount}<input type="hidden" name="voucherEntryTempPo.sCostPriceAmount" value="${sCostPriceAmount}"/></TD>
                          <TD>
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLveveBillID}')">
		                  </TD>
                         </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                 </c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
						  <TD align="left">
						      <p>
						      <input type="checkbox" id="auditState" name="auditState" value="1">保存并审核
						      </p>
						  </TD>
                        </TR>
					   <TR>
						  <TD align="left">
						      <p>
						      <img btn=btn id="submitBtn" name="submitBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()">
						      </p>
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