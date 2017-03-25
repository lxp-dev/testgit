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
        amount();
     }
     
    /**
	 *  根据凭证基本类型改变凭证具体类型
	 */         
	 function changeParentID(){
        delRows();
        if ($('#bVoucherType').val() == '12'){           
            $('#voucherClassif').text('客户名称');
            $('#queryClassify').val('3');
        }else{
        	$('#voucherClassif').text('制造商');
        	$('#queryClassify').val('1');
        }
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';
		
        $('#'+'sVoucherType').load("initVoucherTypeByParentID.action?parentID="+document.getElementById('bVoucherType').value);               
	 }       
	 function changeSubID(){
        delRows();           
	 }
	
	/**
	 *  增加凭证
	 */        
	 function save(){
	     var bVoucherType = document.getElementById('bVoucherType').value;
	     if (bVoucherType == ""){
	        alert("凭证类型不能为空!");
	        return;
	     }	     
		 var sVoucherType = document.getElementById('sVoucherType').value;
		 if (sVoucherType == ""){
	        alert("凭证类型不能为空!");
	        return;
	     }
        var supplierID = document.getElementById('supplierID').value;
	    if (supplierID == ""){	      
	        if ($('#bVoucherType').val() == '12'){   
	            $('#queryClassify').val('3');        
	        	alert("客户不能为空!");
	        }else{
	            $('#queryClassify').val('1');  
	        	alert("制造商不能为空!");
	        }
	       return;
	    }
	   
	    var chk = document.getElementsByName("chk").length;	     
        if (chk != 0){ 
            var auditState=document.getElementsByName("auditState");            
            if (auditState != null  && auditState.length != 0){
	            if (!auditState[0].checked){
	                insertVoucherFrm.action = "insertPayMentVoucher.action?auditState=0";
	            }else{
	                insertVoucherFrm.action = "insertPayMentVoucher.action?auditState=1";
	            }    
            }else{
                insertVoucherFrm.action = "insertPayMentVoucher.action?auditState=0";
            }
            $("img").removeAttr("onclick");
	        insertVoucherFrm.submit();      
        } else{
            alert('请先选择数据!');
        }
	 }
	        
	/**
	 *  选择单据开窗
	 */         
	 function search(){
	     var bVoucherType = document.getElementById('bVoucherType').value;
	     if (bVoucherType == ""){
	         alert("凭证类型不能为空!");
	         return;
	     }	     
	     var sVoucherType = document.getElementById('sVoucherType').value;
	     if (sVoucherType == ""){
	         alert("凭证类型不能为空!");
	         return;
	     }	   
	     var supplierID = document.getElementById('supplierID').value;
	     if (supplierID == ""){
             if ($('#bVoucherType').val() == '12'){           
                 alert("客户不能为空!");
             }else{
                 alert("制造商不能为空!");
             }
	         return;
	      }	
	   
	     var url = "initPayMentBillOpenSel.action?supplierID="+supplierID+"&supplierName="+EncodeUtf8($('#supplierName').val());
         if ($('#bVoucherType').val() == '12'){           
        	 url = "selReceiptMentBillOpen.action?franchiseeID="+supplierID+"&franchiseeName="+EncodeUtf8($('#supplierName').val());
         }
       
	  	 var topRows = top.document.getElementById("total").rows;
		 var topCols = top.document.getElementById("btmframe").cols;		
		 if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		 }else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		 }		
		 document.getElementById('popupTitle').innerHTML="【单据查询】";
	   
	 }
    
    /**
	 *  删除表格中选中的行
	 */	       
	 function del(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('billTable');
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
		var costPriceAmountTotal = 0;
		var costPriceAmount = document.getElementsByName("voucherEntryTempPo.sCostPriceAmount");		
		for(i=0;i<costPriceAmount.length;i++){
			if(costPriceAmount[i].value == '') continue;
			costPriceAmountTotal = parseFloat(parseFloat(costPriceAmountTotal).add(parseFloat(costPriceAmount[i].value))).toFixed(2);
		}		
		document.getElementById("costPriceAmountTotal").innerText=parseFloat(costPriceAmountTotal).toFixed(2);
		document.getElementById("costPriceAmount").value=parseFloat(costPriceAmountTotal).toFixed(2);
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
		if (document.all.sVoucherType.options.length == 0){
		    document.all.sVoucherType.options.add(new Option("----请选择----","")); 
		}
	});
	
	 /**
	  * 制造商开窗
	  */
	 function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var url = '';
		var title = '';
        if ($('#bVoucherType').val() == '12'){           
        	url = 'selOnlyFranchiseeOpen.action';
        	 title = "【客户查询】";
        }else{
        	url = 'selSupplierOpen.action';
        	 title = "【制造商查询】";
        }	
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML=title;
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
		var table = document.getElementById('billTable');
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
		
		row.className = 'row';
		c1.height="26";
                         
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + paymentbill.payMentBillID + '" >';
        c2.innerHTML = paymentbill.payMentBillID + '<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="' + paymentbill.payMentBillID +'" />';
        c3.innerHTML = paymentbill.payedMentDate;
		c4.innerHTML = paymentbill.payedMentAmount + '<input type="hidden" name="voucherEntryTempPo.sCostPriceAmount" value="'+ paymentbill.payedMentAmount +'" />';	
    }
    
    $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
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
         	if($(this).val()== goodInfo.payMentBillID){
			   $(this).parent().parent().remove();	
           }
		});
		
		amount();
    }
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form action="" method="post" id="insertVoucherFrm">
	<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
	<input type="hidden" id="queryClassify" name="po.sLvvTypeID" />
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
                          <TD width="9%" class="table_body">凭证号</TD>
                          <TD width="24%" class="table_none">
                              ${voucherID}
                              <input type="hidden" id="voucherID" name="po.sLvvID" class="text_input160" value="${voucherID}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body">凭证日期</TD>
                          <TD width="24%" class="table_none">
                              ${voucherDate}
                              <input type="hidden" id="voucherDate" name="voucherDate" class="text_input100" value="${voucherDate}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body" >凭证人</TD>
                          <TD width="24%" class="table_none" >
                              ${createPerson}
                              <input type="hidden" id="createPerson" name="createPerson" class="text_input160" value="${createPerson}" readonly="readonly">
                              <input type="hidden" id="createPersonID" name="po.sLvvPersonID" class="text_input160" value="${createPersonID}" readonly="readonly">
                          </TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body">凭证类型</TD>
                          <TD class="table_none" >
                            <li class="horizontal_onlyRight">
                            <select id="bVoucherType" name="bVoucherType" ${empty(voucherTopIDList) ? 'disabled="disabled"' : ''} onChange="changeParentID()">
                                <option value="">----请选择----</option>
                              <s:iterator value="voucherTopIDList">	     	                    
	     	                        <c:if test="${person.personcompanytype == '1'}">
		                                <c:if test="${sLvtvtId=='11' || sLvtvtId=='12'}">
		                                	<option value="${sLvtvtId}"} ${bVoucherType == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
			     	                    </c:if>                                   
                                    </c:if>
                                    
                                    <c:if test="${person.personcompanytype == '2'}">
		                                <c:if test="${sLvtvtId=='11'}">
		                                	<option value="${sLvtvtId}"} ${bVoucherType == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
			     	                    </c:if> 
                                    </c:if>                                    
	     	                  </s:iterator>                            
                            </select></li>
                            <li class="horizontal_onlyRight">                               
                            <select name="po.sLvvVoucherTypeID" id="sVoucherType" onchange="changeSubID()">
                              <s:iterator value="voucherSubsetIDList">
                                <option value="${sLvtvtId}"} ${sVoucherType == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
	     	                  </s:iterator>
                            </select>
                            </li>
                            <label style="color:red;">&nbsp;*&nbsp;</label>
						  </TD>
						<TD class="table_body"><span id="voucherClassif">制造商</span></TD>
                        <TD class="table_none" colspan="3">
                          <li class="horizontal_onlyRight">
                            <input type="text" id="supplierName" name="supplierName" class="text_input160" readonly="readonly" value="${supplierName}">
                            <input type="hidden" id="supplierID" name="po.sLvvSupplierID" class="text_input160" value="${supplierID}">
                          </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" id="searchBtn" name="searchBtn" onclick="openSupplier();" >
                            </li><label style="color:red;">&nbsp;*&nbsp;</label>
                            </TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><label>
                            <textarea name="po.sLvvRemark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${remark}</textarea>
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
					<table id="billTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26"><input type="checkbox" onclick="chkAll()" id="chks">选择</TH>
                          <TH scope=col width="15%" >单据号</TH>
                          <TH width="15%" scope=col>制单日期</TH>
                          <TH scope=col width="7%">单据金额</TH>
                        </TR>
						<TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>                        
                          <TD><div id="costPriceAmountTotal">0.00</div><input type="hidden" id="costPriceAmount" name="po.sLvvCostPriceAmount"></TD>
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