<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>凭证管理</title>
<script type="text/javascript">

$(document).ready(function() { 
    $("img[btn=btn]").attr("style","cursor: hand;"); 
    $("img[btn=btn]").mouseover(function () { 
    $(this).attr("src",$(this).attr("src").replace("0","1")); 
    }).mouseout(function () { 
      $(this).attr("src",$(this).attr("src").replace("1","0")); 
    }); 

    amount();
}); 


     var index = 0;      
 
	 /**
	  *  checkbox全选
	  */	
	 function chkAll(){	    
        var chk = document.getElementsByName("chk");
        var chks = document.all.chks;
        for (var i = 0; i < chk.length; i++){
           chk[i].checked = chks.checked;
        }
     }
     
     /**
	  *  添加一行
	  */	
     function addRow(){
        var table = document.getElementById('mainTable');
		index = accAdd(index,table.rows.length - 1);
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		
		row.className = 'row';
		row.height="28";
		c1.innerHTML = '<input type="checkbox" id="chk"/>';
        c2.innerHTML = '<select id="balanceDirection" name="voucherTallyTempPo.sLvtsBalanceDirection" onchange="isRead(this,'+index+');" sourceIndex="'+index+'">'
                       +'<option value="j" selected="selected"}>借</option><option value="d">贷</option></select>';
                       
        c3.innerHTML = '<input type="test" id="resume" name="voucherTallyTempPo.sLvtvtResume" class="text_input200" onblur="isValidResume(this);" maxlength="30">';
        
		c4.innerHTML = '<li class="horizontal_onlyRight"><input type="text" id=subject'+index+' name="subject" class="text_input200" readonly="readonly">'
		               +'<input type="hidden" id=subjectID'+index+' name="voucherTallyTempPo.sLvtvtSubjectID" class="text_input200"></li>'
		              +'<li class="horizontal_onlyRight"><button id=btn'+index+' name=btn'+index+' icon="icon-apply" value="选择科目" onClick="openSubject('+index+');"></button></li>'
		              +'<input type="hidden" name="voucherTallyTempPo.sLssOrderID" value="'+index+'" class="text_input200">';
		               
		              
		c5.innerHTML = '<div id="debitMoneyLayer'+index+'" name="debitMoneyLayer"><input id="debitMoney'+index+'" name="voucherTallyTempPo.sLvtvtDebitMoney" class="text_input200" onblur="isValidMoney(this);" value="0.00"></div>';
		c6.innerHTML = '<div id="lenderMoneyLayer'+index+'" name="lenderMoneyLayer" style="display: none"><input id="lenderMoney'+index+'" name="voucherTallyTempPo.sLvtvtLenderMoney" class="text_input200" onblur="isValidMoney(this);" value="0.00"></div>';
     
        $('#btn'+index).btn().init();
     } 
     
    /**
	 *  自动计算相关数据
	 */	       
	 function amount(){
	    var total = 0;
	    $('input[name=voucherTallyTempPo.sLvtvtDebitMoney]').each(function (){
	        total = accAdd(total,$(this).val());
	    });
	    $('#debitMoneyTotal').text(parseFloat(total).toFixed(2));

	    total = 0;
	    $('input[name=voucherTallyTempPo.sLvtvtLenderMoney]').each(function (){
	        total = accAdd(total,$(this).val());
	    });
	    $('#lenderMoneyTotal').text(parseFloat(total).toFixed(2));
	 }
	 
     /**
	  *  删除表格中选中的行
	  */        
	 function del(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('mainTable');
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
	    if (parseFloat(document.getElementById("debitMoneyTotal").innerText) != parseFloat(document.getElementById("lenderMoneyTotal").innerText)){
	        alert("借贷总金额不等!");
	        return;
	    }
	    $("img").removeAttr("onclick");    
	    editVoucherTempletFrm.action = "ykeditVoucherTally.action";
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
	       return;
	    }
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
            document.getElementById("lenderMoney"+index).value = "0.00";
            document.getElementById("debitMoneyLayer"+index).style.display = "";
        }else{
            document.getElementById("lenderMoneyLayer"+index).style.display = "";     
            document.getElementById("debitMoneyLayer"+index).style.display = "none";
            document.getElementById("debitMoney"+index).value = "0.00";
        }
        amount();   
     }    
   
    /**
	 * 科目开窗
	 */ 
     function openSubject(value){
         index = value;
         document.getElementById("indexs").value = index;
         openPopWindow("ykselSubjectOpen.action","科目查询");
     }
     
    /**
	 * 科目开窗赋值
	 */ 
     function openSubjectValue(json){         
         var indes= document.getElementById("indexs").value;
         document.getElementById("subject"+indes).value=json.subject;
         document.getElementById("subjectID"+indes).value=json.subjectID;
     }

 	function openPopWindow(url,msg){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【"+msg+"】";	
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
                          <TD width="8%" class="table_body">凭证号</TD>
                          <TD width="26%" class="table_none">${voucherID}<input id="voucherID" name="voucherID" type="hidden" class="text_input100" value="${voucherID}"/></TD>
                          <TD width="7%" class="table_body">凭证日期</TD>
                          <TD width="26%" class="table_none">
                              <input id="voucherDate" name="voucherDate" type="text" class="text_input100" 
					                 onFocus="WdatePicker({readOnly:true})"
					                 value="${voucherDate}" />
                          </TD>
                          <TD class="table_body">经手人</TD>
                          <TD class="table_none"><input id="handlePersonID" name="handlePersonID" type="text" class="text_input200" value="${po.sLvvHandlePersonID}" onblur="isValidResume(this);"></TD>
                        </TR>
                        <TR>
                          <TD class="table_body" >操作人</TD>
                          <TD class="table_none" >${createPerson}</TD>
                          <TD class="table_body">凭证类型</TD>
                          <TD class="table_none">${bType}&nbsp;&nbsp;&nbsp;&nbsp;${sType}</TD>
                          <TD class="table_body">结算方式</TD>
                          <TD class="table_none">
                              <select id="balanceMethod" name="balanceMethod" style="width:70%" disabled="disabled">                                
                                <option value=""></option>
                              </select>
                          </TD>
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
					<table id="mainTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="30"><input type="checkbox" id="chks" name="chks" onclick="chkAll()"/>全选</TH>
                          <TH scope=col width="3%" height="30">方向</TH>
                          <TH width="10%" height="30" scope=col>摘要</TH>
                          <TH width="14%" scope=col>科目</TH>
                          <TH scope=col width="10%">借方(精确到分)</TH>
                          <TH scope=col width="10%">贷方(精确到分)</TH>
                        </TR>
                        <TR class="table_title" align=middle>
                          <TD>&nbsp;</TD>
						  <TD height="28">合计:</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD><div id="debitMoneyTotal"></div></TD>
                          <TD><div id="lenderMoneyTotal"></div></TD>
                        </TR>
                       <s:iterator value="voucherTallyList" status="index">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28"><input type="checkbox" id="chk"/></TD>
                          <TD height="28">                            
                            <select id="balanceDirection" name="voucherTallyTempPo.sLvtsBalanceDirection" onchange="isRead(this,${index.index});" sourceIndex="${index.index+1}">                                
                                <option value='j' ${sLvtsBalanceDirection == 'j' ? 'selected="selected"' : '' }>借</option>
                                <option value='d' ${sLvtsBalanceDirection == 'd' ? 'selected="selected"' : '' }>贷</option>
                            </select>                            
                          </TD>
						  <TD height="28"><input type="test" id="resume" name="voucherTallyTempPo.sLvtvtResume" value="${sLvtvtResume}" class="text_input200" onblur="isValidResume(this);" maxlength="30"></TD>
						  <TD height="28">
						    <li class="horizontal_onlyRight">
                              <input type="text" id="subject${index.index}" name="subject" value="${sLvtvtSubjectID}${sLvtvtSubjectName}" class="text_input200" readonly="readonly">
                              <input type="hidden" id="subjectID${index.index}" name="voucherTallyTempPo.sLvtvtSubjectID" value="${sLssID}" class="text_input200">
                              <input type="hidden" name="voucherTallyTempPo.sLssOrderID" value="${sLvtvtOrderID}" class="text_input200">
                            </li>
                            <li class="horizontal_onlyRight">
                              <input id="btn" name="btn" icon='icon-apply' type='button' value="选择科目" onClick="openSubject(${index.index});">
                            </li>
						  </TD>
						  <TD height="28"><div id="debitMoneyLayer${index.index}" name="debitMoneyLayer" ${sLvtsBalanceDirection == 'd' ? 'style="display: none"' : '' } ><input id="debitMoney${index.index}" name="voucherTallyTempPo.sLvtvtDebitMoney" value="${sLvtvtDebitMoney}" class="text_input200" onblur="isValidMoney(this);"></div></TD>
						  <TD height="28"><div id="lenderMoneyLayer${index.index}" name="lenderMoneyLayer" ${sLvtsBalanceDirection == 'j' ? 'style="display: none"' : '' }><input id="lenderMoney${index.index}" name="voucherTallyTempPo.sLvtvtLenderMoney" value="${sLvtvtLenderMoney}" class="text_input200" onblur="isValidMoney(this);"></div></TD>                          
                       	</TR>
                       </s:iterator>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                       <TR>                         
                         <TD align="left">&nbsp;</TD>
					   </TR>
					   <TR>
						  <TD align="left">
						      <p>
						      <c:if test="${posting == '0'}">
						      <img btn=btn id="submitBtn" name="submitBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onClick="save()">
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