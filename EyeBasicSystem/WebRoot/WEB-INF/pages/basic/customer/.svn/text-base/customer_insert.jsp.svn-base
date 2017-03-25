<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#bctid').focus();
	});

	function clean(){
		document.getElementById('bctid').value = "";
		document.getElementById('bctcustomername').value = "";
		document.getElementById('bctcontactphone').value = "";
		document.getElementById('bctfax').value = "";
		document.getElementById('bctcontactperson').value = "";
		document.getElementById('bctaddress').value = "";
		document.getElementById('bctremark').value = "";
	}
	
	function save(){
	if(checkForm(document.all.customerForm)){	    
		$("img").removeAttr("onclick");
		customerForm.action = "insertCustomer.action";
		customerForm.submit();
		}
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form name="customerForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
          </TD>
		</TR>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD class="table_body" width="8%" height="26">客户代码</TD>
                          <TD class="table_none" width="32%"><input class="text_input160" id="bctid" name="customerPo.bctid" value="${customerPo.bctid }" maxlength="5" validate="[{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '客户代码只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [6]}, 'Message' : '客户代码输入长度大于系统规定值！'}]"><font color="red">&nbsp;*&nbsp;客户代码只允许输入字母、数字</font></TD>
                          <TD class="table_body" width="8%">客户名称</TD>
                          <TD class="table_none" width="18%"><input class="text_input160" id="bctcustomername" name="customerPo.bctcustomername" value="${customerPo.bctcustomername }" maxlength="30" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '客户名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [31]}, 'Message' : '客户名称输入长度大于系统规定值！'}]"><font color="red">&nbsp;*</font></TD>
                          <TD width="8%" class="table_body">电&nbsp;&nbsp;&nbsp;话</TD>
                          <TD class="table_none"><input class="text_input160" id="bctcontactphone" name="customerPo.bctcontactphone" value="${customerPo.bctcontactphone }" maxlength="13" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '电话不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [20]}, 'Message' : '电话输入长度大于系统规定值！'},{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '输入信息必须为电话格式！'}]"><font color="red">&nbsp;*&nbsp;如：022-85123455</font></TD>
                        </TR>
						<TR>
						  <TD class="table_body">传&nbsp;&nbsp;&nbsp;真</TD>
                          <TD class="table_none"><input class="text_input160" id="bctfax" name="customerPo.bctfax" maxlength="13" value="${customerPo.bctfax}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '传真不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [20]}, 'Message' : '传真输入长度大于系统规定值！'},{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '输入信息必须为传真格式！'}]"><font color="red">&nbsp;*&nbsp;如：022-85123455</font></TD>
                          <TD class="table_body" height="26">联系人</TD>
                          <TD class="table_none"><input class="text_input160" id="bctcontactperson" name="customerPo.bctcontactperson" value="${customerPo.bctcontactperson }" maxlength="5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '联系人不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [6]}, 'Message' : '联系人输入长度大于系统规定值！'}]"><font color="red">&nbsp;*</font></TD>
                          <TD class="table_body">地&nbsp;&nbsp;&nbsp;址</TD>
                          <TD class="table_none"><input class="text_input160" id="bctaddress" name="customerPo.bctaddress" value="${customerPo.bctaddress }" maxlength="200" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '地址不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [201]}, 'Message' : '地址输入长度大于系统规定值！'}]"><font color="red">&nbsp;*</font></TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备&nbsp;&nbsp;&nbsp;注</TD>
                          <TD colspan="5" class="table_none">
                            <textarea id="bctremark" name="customerPo.bctremark" cols="45" rows="5" class="text_textarea" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [2001]}, 'Message' : '备注输入长度大于系统规定值！'}]">${customerPo.bctremark }</textarea>
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" id="submitButton" btn=btn title='保存' onClick="save()">
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn img='清空' onClick="clean()">
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE>
    </form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>