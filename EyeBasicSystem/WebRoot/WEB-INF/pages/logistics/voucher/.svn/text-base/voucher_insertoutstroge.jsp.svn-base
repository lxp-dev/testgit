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
		
        //相关数据清零
        var notTaxRateAmountTotal = document.getElementById("notTaxRateAmountTotal");
        if (notTaxRateAmountTotal != null){
            notTaxRateAmountTotal.innerText='0.00';
        }
        var costPriceAmountTotal = document.getElementById("costPriceAmountTotal");
        if (costPriceAmountTotal != null){
            costPriceAmountTotal.innerText='0.00';
        }
     }
     
    /**
	 *  根据凭证基本类型改变凭证具体类型
	 */         
	 function changeParentID(){
        delRows();
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
	        alert("基本类型不能为空!");
	        return;
	     }	     
		 var sVoucherType = document.getElementById('sVoucherType').value;
		 if (sVoucherType == ""){
	        alert("具体类型不能为空!");
	        return;
	     }
	     
	    var sDepartment = document.getElementsByName("voucherEntryTempPo.sDepartmentID");
        if (sDepartment.length != 0){
            var departmentName = sDepartment[0];
            for (var i = 1; i < sDepartment.length; i++){
                if (departmentName.value != sDepartment[i].value){
                    alert("请选择同一部门的销售出库单!");
                    return;
                }
            }
        }
        
	    var chk = document.getElementsByName("chk").length;	     
        if (chk != 0){ 
            var auditState = document.getElementsByName("auditState");
            if (auditState != null  && auditState.length != 0){
	            if (!auditState[0].checked){
	                insertVoucherFrm.action = "insertOutStrogeVoucher.action?auditState=0";
	            }else{
	                insertVoucherFrm.action = "insertOutStrogeVoucher.action?auditState=1";
	            }      
            }else{
                insertVoucherFrm.action = "insertOutStrogeVoucher.action?auditState=0";
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
	       alert("基本类型不能为空!");
	       return;
	   }	     
	   var sVoucherType = document.getElementById('sVoucherType').value;
	   if (sVoucherType == ""){
	       alert("具体类型不能为空!");
	       return;
	   }	   
	  
	   var voucherID = document.getElementById('voucherID').value;
	   var voucherDate = document.getElementById('voucherDate').value;
	   var createPerson = document.getElementById('createPerson').value;
	   var remark = document.getElementById('remark').value;
	   
	   var url = "&bVoucherType="+bVoucherType+"&sVoucherType="+sVoucherType+"&voucherID="+voucherID
	              +"&voucherDate="+voucherDate+"&createPerson="+EncodeUtf8(createPerson)+"&remark="+EncodeUtf8(remark)+"&type=3";

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initSelectBillSels.action?" + url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelectBillSels.action?" + url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【单据查询】";	   
	   
	 }
	        
	/**
	 *  选择单据开窗赋值
	 */        
	 function openGoodSingleValues(objValue){
	      var sVoucherType = document.getElementById('sVoucherType').value;
	      insertVoucherFrm.action="selSalesBills.action?billID="+objValue;
	      insertVoucherFrm.submit();
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
		var notTaxRateAmountTotal = 0;
		var notTaxRateAmount = document.getElementsByName("voucherEntryTempPo.sNotTaxRateAmount");		
		for(i=0;i<notTaxRateAmount.length;i++){
			if(notTaxRateAmount[i].value == '') continue;
			notTaxRateAmountTotal = parseFloat(parseFloat(notTaxRateAmountTotal).add(parseFloat(notTaxRateAmount[i].value))).toFixed(2);
		}		
		document.getElementById("notTaxRateAmountTotal").innerText=parseFloat(notTaxRateAmountTotal).toFixed(2);	
		
		var costPriceAmountTotal = 0;
		var costPriceAmount = document.getElementsByName("voucherEntryTempPo.sCostPriceAmount");		
		for(i=0;i<costPriceAmount.length;i++){
			if(costPriceAmount[i].value == '') continue;
			costPriceAmountTotal = parseFloat(parseFloat(costPriceAmountTotal).add(parseFloat(costPriceAmount[i].value))).toFixed(2);
		}		
		document.getElementById("costPriceAmountTotal").innerText=parseFloat(costPriceAmountTotal).toFixed(2);
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
		
		if (document.getElementsByName("voucherEntryTempPo.sNotTaxRateAmount").length != 0){
		    amount();
		}
		
		if (document.all.sVoucherType.options.length == 0){
		    document.all.sVoucherType.options.add(new Option("----请选择----","")); 
		}
	});
	
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
                        <TR height="26px">
                          <TD width="9%" class="table_body">凭证号</TD>
                          <TD width="24%" class="table_none">
                              ${voucherID}
                              <input type="hidden" id="voucherID" name="voucherID" class="text_input160" value="${voucherID}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body">凭证日期</TD>
                          <TD width="30%" class="table_none">
                              ${voucherDate}
                              <input type="hidden" id="voucherDate" name="voucherDate" class="text_input100" value="${voucherDate}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body" >凭证人</TD>
                          <TD width="24%" class="table_none" >
                              ${createPerson}
                              <input type="hidden" id="createPerson" name="createPerson" class="text_input160" value="${createPerson}" readonly="readonly">
                          </TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body">凭证类型</TD>
                          <TD class="table_none" colspan="5">
                            <li class="horizontal_onlyRight">
                            <select id="bVoucherType" name="bVoucherType" ${empty(voucherTopIDList) ? 'disabled="disabled"' : ''} onChange="changeParentID()">
                                <option value="">----请选择----</option>
                              <s:iterator value="voucherTopIDList">
                                <c:if test="${sLvtvtId=='3'}">
                                <option value="${sLvtvtId}" ${bVoucherType == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
	     	                    </c:if>
	     	                  </s:iterator>                            
                            </select></li>
                            <li class="horizontal_onlyRight">                               
                            <select name="sVoucherType" id="sVoucherType" onchange="changeSubID()">
                              <s:iterator value="voucherSubsetIDList">                               
                                <option value="${sLvtvtId}" ${sVoucherType == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
	     	                  </s:iterator>
                            </select>
                            </li>
						  </TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><label>
                            <textarea name="remark" id="remark" onblur="isValidRemark(this)" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${remark}</textarea>
                            </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_xzdj_0.png" id="searchBtn" title="选择" onClick="search()">
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
                          <TH width="15%" scope=col>单据日期</TH>
                          <TH width="13%" scope=col>部门名称</TH>
                          <TH scope=col width="5%">销售成本</TH>
                          <TH scope=col width="7%">销售收入</TH>
                        </TR>
						<TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>	
                          <TD>&nbsp;</TD>					
                          <TD><div id="notTaxRateAmountTotal">0.00</div></TD>                          
                          <TD><div id="costPriceAmountTotal">0.00</div></TD>
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input id="chk" name="chk" type="checkbox"><input type="hidden" name="voucherEntryTempPo.sLveveID" value="${sLveveID}" /></TD>
						  <TD>${sLveveBillID}<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="${sLveveBillID}" /></TD>
						  <TD>${sBillDate}<input type="hidden" name="voucherEntryTempPo.sDate" value="${sBillDate}" /></TD>
						  <TD>${sDepartment}<input type="hidden" name="voucherEntryTempPo.sDepartment" value="${sDepartment}" /><input type="hidden" name="voucherEntryTempPo.sDepartmentID" value="${sDepartmentID}" /></TD>
						  <TD><span id="sNotTaxRateAmount">${sNotTaxRateAmount}</span><input type="hidden" name="voucherEntryTempPo.sNotTaxRateAmount" value="${sNotTaxRateAmount}" /></TD>                          
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