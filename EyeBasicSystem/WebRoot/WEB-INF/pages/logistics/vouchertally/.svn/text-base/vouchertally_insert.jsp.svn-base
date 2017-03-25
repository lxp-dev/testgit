<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>凭证管理</title>
<link href="<%=request.getContextPath()%>/voucher/voucher.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/voucher/voucher.js" type="text/javascript" charset="utf-8"></script>
		
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
		var queryClassify = $('input[name=queryClassify]:checked').val();
		if (queryClassify == '1'){
			document.getElementById('supplierID').value = json.id;
			document.getElementById('supplierName').value = json.value;
	    } 
		if (queryClassify == '3'){
			openFranchiseeValues(json);
	    }
	    		
	 }
	 
     var index = 0;      
 
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
	  *  添加一行
	  */	
     function addRow(){
        var table = document.getElementById('tb_voucher2');
		index = accAdd(index,table.rows.length - 1);
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		
		row.className = "line";
		c1.height="26";
		c1.align="center";
		c2.align="center";
        c5.className = 's_line double';
        c6.className = 's_line';
        			
		c1.innerHTML = '<input type="checkbox" id="chk"/>';
        c2.innerHTML = '<select id="balanceDirection" name="voucherTallyTempPo.sLvtsBalanceDirection" onchange="isRead(this,'+index+');" sourceIndex="'+index+'">'
                       +'<option value="j" selected="selected"}>借</option><option value="d">贷</option></select>';
                       
        c3.innerHTML = '<div class="relative_summary"><textarea id="resume" name="voucherTallyTempPo.sLvtvtResume" class="summary ac_input" style="width: 100%;height: 100%;" autocomplete="off" onblur="isValidResume(this);"></textarea></div>';
        
		c4.innerHTML = '<input type="text" id=subject'+index+' name="subject" readonly="readonly" onclick="openSubject('+index+');" class="subject ac_input" autocomplete="off" style="width: 80%;height: 100%;">'
		               +'<input type="hidden" id=subjectID'+index+' name="voucherTallyTempPo.sLvtvtSubjectID">'		              
		              +'<input type="hidden" name="voucherTallyTempPo.sLssOrderID" value="'+index+'">';
        
		c5.innerHTML = '<div id="debitMoneyLayer'+index+'" name="debitMoneyLayer"><input id="debitMoney'+index+'" name="voucherTallyTempPo.sLvtvtDebitMoney" class="debite" maxlength="14" style="width: 100%;height: 41" value="000"></div>';
		c6.innerHTML = '<div id="lenderMoneyLayer'+index+'" name="lenderMoneyLayer" style="display: none"><input id="lenderMoney'+index+'" name="voucherTallyTempPo.sLvtvtLenderMoney" class="credit" maxlength="14" style="width: 100%;height: 41" value="000"></div>';

		unBindFun();
		bindFun();
		chkAll();
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
	 
     /**
	  *  删除表格中选中的行
	  */        
	 function del(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('tb_voucher2');
		for(i = 0; i < chk.length; i++){
			 if (chk[i].checked) {
				 var curRow = chk[i].parentNode.parentNode;		
				 table.deleteRow(curRow.rowIndex);
				 i = -1;
			 }
		}
		amount();
		document.all.chks.checked = false;
	 } 
	 
	/**
	 * 保存凭证模板
	 */
	 function save(){
	 	var supplierID = document.getElementsByName("po.sLvvSupplierID").length;	   
	    if ($('#supplierID').val() == '' && $('#departmentID').val() == '' && $('#franchiseeID').val() == ''){
	        alert("请先选择制造商、部门或客户!");
	        return;
	    }
	    	   
	    var subjectCount = document.getElementsByName("subject").length;	   
	    var subject = document.getElementsByName("subject");	    
	    for (var i = 0; i < subjectCount; i++){
	        if (subject[i].value.trim() == null || subject[i].value.trim() == ""){
	            subject[i].focus();
	            alert("请填写科目!");
	            return;
	        }
	    }
	   	  	
	    var sTypeID = document.getElementsByName("sTypeID")[0].value;
	    if (sTypeID.substring(0,1) != "5" && sTypeID.substring(0,1) != "6"){
	        var resumeCount = document.getElementsByName("voucherTallyTempPo.sLvtvtResume").length;	   
	        var resume = document.getElementsByName("voucherTallyTempPo.sLvtvtResume");	 
	        for (var i = 0; i < resumeCount; i++){
	            if (resume[i].value.trim() == null || resume[i].value.trim() == ""){
	               	resume[i].focus();
	                alert("请填写摘要!");
	                return;
	            }
	        }
	    }
	    amount();
	    if (parseFloat(document.getElementById("debitMoneyTotal").value) != parseFloat(document.getElementById("lenderMoneyTotal").value)){
	        alert("借贷总金额不等!");
	        return;
	    }
	    
	    var balanceDirectionCount = document.getElementsByName("voucherTallyTempPo.sLvtsBalanceDirection").length;
	    var debitCount = 0;
	    var lenderCount = 0;
	    for (var i = 0; i < balanceDirectionCount; i++){
	        if (document.getElementsByName("voucherTallyTempPo.sLvtsBalanceDirection")[i].value=="j"){
	            debitCount = accAdd(debitCount,1);
	        }
	        if (document.getElementsByName("voucherTallyTempPo.sLvtsBalanceDirection")[i].value=="d"){
	            lenderCount = accAdd(lenderCount,1);
	        }
	    }
	    if (debitCount==0 || lenderCount==0){
	        alert("缺少借方或贷方金额!");
	        return;
	    }
	    
	    if (checkForm(editVoucherTempletFrm)){
		    var chk = document.getElementsByName("chk").length;	     
	        if (chk != 0){ 
			    var auditState = document.getElementsByName("auditState");
				var queryClassify = $('input[name=queryClassify]:checked').val();
			    if (auditState != null  && auditState.length != 0 ){
				    if (!auditState[0].checked){
			            editVoucherTempletFrm.action = "voucherTallyInsert.action?auditState=0&queryClassify="+queryClassify;
			        }else{
			            editVoucherTempletFrm.action = "voucherTallyInsert.action?auditState=1&queryClassify="+queryClassify;
			        }
			    }else{
			        editVoucherTempletFrm.action = "voucherTallyInsert.action?auditState=0&queryClassify="+queryClassify;
			    }
	            $("img").removeAttr("onclick");
		        editVoucherTempletFrm.submit();  
		            
	        } else{
	            alert('请先选择数据!');
	        } 
	    }

	 }
	 	
	/**
	 * 验证是否是合法的金额
	 */     
	 function isValidMoney(money){      
	    if (document.activeElement.id == "button_0"){
	        return;
	    }
	    if (isFloat(money.value)){	                    
	       money.focus();
	       alert("金额输入有误!");
	       money.value="0.00";
	       return;
	    }
	    money.value=parseFloat(money.value).toFixed(2);
	    amount();
     }
     	 
	/**
	 *  验证参数是否是浮点数 
	 */
	 function isFloat(str){
	     if (str.trim().indexOf(".") < 0){
	         str += ".00";
	     }
	     var type = /^(\+|-)?[0-9]+[.]?[0-9]?[0-9]?$/;
         var req = new RegExp(type);
	     return !req.test(str);
	 } 
	 
    /**
	 * 验证是否是合法的摘要
	 */  
     function isValidResume(szStr){
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
     
    /**
	 * 不能同时输入借贷金额
	 */ 
     function isRead(balanceDirection,index){
        var direction = balanceDirection.value;
        if (direction == "j"){
            document.getElementById("lenderMoneyLayer"+index).style.display = "none";
            document.getElementById("lenderMoney"+index).value = "000";
            document.getElementById("debitMoneyLayer"+index).style.display = "";
        }else{
            document.getElementById("lenderMoneyLayer"+index).style.display = "";     
            document.getElementById("debitMoneyLayer"+index).style.display = "none";
            document.getElementById("debitMoney"+index).value = "000";
        }
        amount();   
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
         document.getElementById("subject"+indes).value=json.subject;
         document.getElementById("subjectID"+indes).value=json.subjectID;
     }
     
     $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 

	    cleanDepartment('1');
    }); 

    function cleanDepartment(type){
        $('td[dpt1=dpt1]').hide();
        $('td[dpt2=dpt2]').hide();
        $('td[dpt3=dpt3]').hide();
        $('td[dpt'+type+'=dpt'+type+']').show();

        $('#supplierName').val('');
        $('#supplierID').val('');
        $('#bdpdepartmentname').val('');
        $('#departmentID').val('');
        $('#franchiseeName').val('');
        $('#franchiseeID').val('');
    }

	 /**
	  * 客户开窗
	  */
	 function openFranchisee(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var url = 'selOnlyFranchiseeOpen.action';
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【客户查询】";
	 }
	
	 /**
	  * 客户开窗赋值实现方法
	  */
	 function openFranchiseeValues(json){
		document.getElementById('franchiseeID').value = json.id;
		document.getElementById('franchiseeName').value = json.value;
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
	}
		
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
                        <TR>
                          <TD width="9%" class="table_body" height="26">凭证号</TD>
                          <TD width="24%" class="table_none">${voucherID}<input id="voucherID" name="po.sLvvID" type="hidden" class="text_input160" value="${voucherID}"/></TD>
                          <TD width="9%" class="table_body">凭证日期</TD>
                          <TD width="24%" class="table_none">
                              <input id="voucherDate" name="po.sLvvDate" type="text" class="text_input100" 
					                 onFocus="WdatePicker({readOnly:true})"
					                 value="${voucherDate}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '填写凭证日期！'}]"/>
                          </TD>
                          <TD class="table_body" width="9%">制单人</TD>
                          <TD class="table_none" width="24%">${createPerson}</TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">附单数</TD>
                          <TD class="table_none"><input id="attchBillCount" name="po.sLvvAttchBillCount" type="text" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '填写附单数！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '填写的附单数不正确！'}]"/></TD>
                          <TD class="table_body">单据种类</TD>
                          <TD class="table_none">
								<input type="radio" id="queryClassify" name="queryClassify" value="1" onclick="cleanDepartment('1');" checked="checked"/>制造商&nbsp;
								<input type="radio" id="queryClassify" name="queryClassify" value="2" onclick="cleanDepartment('2');"/>部门&nbsp;
								
								<c:if test="${person.personcompanytype == '1'}">
								<input type="radio" id="queryClassify" name="queryClassify" value="3" onclick="cleanDepartment('3');"/>客户&nbsp;
								</c:if>
                          </TD>
                          <TD class="table_body" dpt1=dpt1>制造商</TD>
                          <TD class="table_none" dpt1=dpt1>
                            <li class="horizontal_onlyRight">
                              <input type="text" id="supplierName" name="supplierName" class="text_input160" readonly="readonly">
                              <input type="hidden" id="supplierID" name="po.sLvvSupplierID" class="text_input160">
                            </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn" name="searchBtn"  src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onclick="openSupplier();">
                            </li>
                          </TD>
                          <TD class="table_body" dpt2=dpt2>部门</TD>
                          <TD class="table_none" dpt2=dpt2>
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" id="bdpdepartmentname" name="bdpdepartmentname" type="text"  />						   		
						   		<input type="hidden" id="departmentID" name="po.sLvvDepartmentID" class="text_input160" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openDepartment();">
						   </li>
                          </TD>
                          <TD class="table_body" dpt3=dpt3>客户</TD>
                          <TD class="table_none" dpt3=dpt3>
                            <li class="horizontal_onlyRight">
                              <input type="text" id="franchiseeName" name="franchiseeName" class="text_input160" readonly="readonly">
                              <input type="hidden" id="franchiseeID" name="po.sLvvFranchiseeDptID" class="text_input160">
                            </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn" name="searchBtn"  src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onclick="openFranchisee();">
                            </li>
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
                              <img btn=btn src="${ctx }/img/newbtn/btn_tianjia_0.png" title="添加" onClick="addRow();">
                            </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onClick="del();">
                            </li>
                          </TD>
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
                          <TH width="6%" height="26" rowspan="2"><input type="checkbox" id="chks" name="chks" onclick="chkAll()"/>选择</TH>
                          <TH width="6%" height="26" rowspan="2">方向</TH>
                          <TH width="30%" rowspan="2">摘要</TH>
                          <TH width="30%" rowspan="2">会计科目</TH>
                          <TH width="168" class="double">借方金额</TH>
                          <TH width="168">贷方金额</TH>
                        </TR>
                <tr>
                    <th class="scale double" height="26"></th>
                    <th class="scale"></th>
                </tr>

                       <tfoot>
                       <TR>						 
						  <td height="26" colspan="4" class="total"><strong>合 计：&nbsp;
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
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>