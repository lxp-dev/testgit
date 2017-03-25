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
     var index = 1;      
 
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
	    var subjectCount = document.getElementsByName("subject").length;	   
	    var subject = document.getElementsByName("subject");	    
	    for (var i = 0; i < subjectCount; i++){
	        if (subject[i].value.trim() == null || subject[i].value.trim() == ""){
	            subject[i].focus();
	            alert("包含空白科目!");
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
	    $("img").removeAttr("onclick");    
	    editVoucherTempletFrm.action = "editVoucherTally.action";
	    editVoucherTempletFrm.submit();
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
    }); 
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
                          <TD width="8%" class="table_body">凭证号</TD>
                          <TD width="26%" class="table_none">${voucherID}<input id="voucherID" name="voucherID" type="hidden" class="text_input100" value="${voucherID}"/></TD>
                          <TD width="7%" class="table_body">凭证日期</TD>
                          <TD width="26%" class="table_none">
                              <input id="voucherDate" name="voucherDate" type="text" class="text_input100" 
					                 onFocus="WdatePicker({readOnly:true})"
					                 value="${voucherDate}" />
                          </TD>
                          <TD class="table_body" width="7%">操作人</TD>
                          <TD class="table_none" >${createPerson}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body">凭证类型</TD>
                          <TD class="table_none" colspan="5">${bType}&nbsp;&nbsp;&nbsp;&nbsp;${sType}</TD>
                          
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_tjkm_0.png" title="添加科目" onClick="addRow();">
                            </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" title="删除"  onClick="del();">
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
                       <s:iterator value="voucherTallyList" status="index">
                        <TR class="line">
                          <TD height="26" align="center">                            
                              <input type="checkbox" id="chk"/>
                          </TD>
                          <TD height="26" align="center">
                            <select id="balanceDirection" name="voucherTallyTempPo.sLvtsBalanceDirection" onchange="isRead(this,${index.index});" sourceIndex="${index.index+1}">                                
                                <option value='j' ${sLvtsBalanceDirection == 'j' ? 'selected="selected"' : '' }>借</option>
                                <option value='d' ${sLvtsBalanceDirection == 'd' ? 'selected="selected"' : '' }>贷</option>
                            </select>
                          </TD>
						  <TD><div class="relative_summary">
						  <textarea id="resume" name="voucherTallyTempPo.sLvtvtResume" class="summary ac_input" style="width: 100%;height: 100%;" autocomplete="off" onblur="isValidResume(this);">${sLvtvtResume}</textarea>						 
						  </div>
						  </TD>
						  <TD><input type="text" id="subject${index.index}" name="subject" value="${sLvtvtSubjectID}${sLvtvtSubjectName}" readonly="readonly" class="subject ac_input" autocomplete="off" style="width: 80%;height: 100%;" onclick="openSubject(${index.index});"><input type="hidden" id="subjectID${index.index}" name="voucherTallyTempPo.sLvtvtSubjectID" value="${sLssID}"><input type="hidden" name="voucherTallyTempPo.sLssOrderID" value="${sLvtvtOrderID}"></TD>
						  <TD class="s_line double"><div id="debitMoneyLayer${index.index}" name="debitMoneyLayer" ${sLvtsBalanceDirection == 'd' ? 'style="display: none"' : '' } ><input id="debitMoney${index.index}" name="voucherTallyTempPo.sLvtvtDebitMoney" value="${sLvtvtDebitMoney == null ? 000 : fn:replace(sLvtvtDebitMoney,'.','')}" class="debite" maxlength="14" style="width: 100%;height: 41"></div></TD>
						  <TD class="s_line"><div id="lenderMoneyLayer${index.index}" name="lenderMoneyLayer" ${sLvtsBalanceDirection == 'j' ? 'style="display: none"' : '' }><input id="lenderMoney${index.index}" name="voucherTallyTempPo.sLvtvtLenderMoney" value="${sLvtvtLenderMoney == null ? 000 : fn:replace(sLvtvtLenderMoney,'.','')}" class="credit" maxlength="14" style="width: 100%;height: 41"></div></TD>   <!-- onkeyup="isValidMoney(this);"  -->                       
                       	</TR>
                       </s:iterator>
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
						      <p>
						      <c:if test="${posting == '0'}">
						      <img btn=btn id="submitBtn" name="submitBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()">
						      </c:if>
						      </p>
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