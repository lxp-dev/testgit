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
	});

	function save(){
	if(checkForm(document.all.customerForm)){	    
		$("img").removeAttr("onclick");
		customerForm.action = "updateCustomer.action";
		customerForm.submit();
		}
	}

 	function clean(){
		document.getElementById('bctcustomername').value = "";
		document.getElementById('bctcontactphone').value = "";
		document.getElementById('bctfax').value = "";
		document.getElementById('bctcontactperson').value = "";
		document.getElementById('bctaddress').value = "";
		document.getElementById('bctremark').value = "";
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
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD class="table_body" width="8%" height="30">客户代码</TD>
                          <TD class="table_none" width="20%">${customerPo.bctid}<input type="hidden" value="${customerPo.bctid}" class="text_input200" id="bctid" name="customerPo.bctid" ></TD>
                          <TD class="table_body" width="8%">客户名称</TD>
                          <TD class="table_none" width="15%"><input value="${customerPo.bctcustomername}" class="text_input200" id="bctcustomername" name="customerPo.bctcustomername" maxlength="30" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '客户名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [31]}, 'Message' : '客户名称输入长度大于系统规定值！'}]"><font color="red">&nbsp;*</font></TD>
                          <TD width="8%" class="table_body" height="30">电&nbsp;&nbsp;&nbsp;话</TD>
                          <TD width="30%" class="table_none"><input value="${customerPo.bctcontactphone}" class="text_input200" id="bctcontactphone" name="customerPo.bctcontactphone" maxlength="13" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '电话不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [20]}, 'Message' : '电话输入长度大于系统规定值！'},{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '输入信息必须为电话格式！'}]"><font color="red">&nbsp;*&nbsp;如：022-85123455</font></TD>
                        </TR>
						<TR>
						  <TD class="table_body">传&nbsp;&nbsp;&nbsp;真</TD>
                          <TD class="table_none"><input value="${customerPo.bctfax}" class="text_input200" id="bctfax" name="customerPo.bctfax" maxlength="13" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '传真不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [20]}, 'Message' : '传真输入长度大于系统规定值！'},{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '输入信息必须为传真格式！'}]"><font color="red">&nbsp;*&nbsp;如：022-85123455</font></TD>
                          <TD class="table_body" height="30">联系人</TD>
                          <TD class="table_none" ><input value="${customerPo.bctcontactperson}" class="text_input200" id="bctcontactperson" name="customerPo.bctcontactperson" maxlength="5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '联系人不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [6]}, 'Message' : '联系人输入长度大于系统规定值！'}]"><font color="red">&nbsp;*</font></TD>
                          <TD class="table_body">地&nbsp;&nbsp;&nbsp;址</TD>
                          <TD class="table_none"><input value="${customerPo.bctaddress}" class="text_input200" id="bctaddress" name="customerPo.bctaddress" maxlength="200" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '地址不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [201]}, 'Message' : '地址输入长度大于系统规定值！'}]"><font color="red">&nbsp;*</font></TD>
                        </TR>
                        <TR>
                          <TD width="10%" class="table_body">备&nbsp;&nbsp;&nbsp;注</TD>
                          <TD width="90%" colspan="5" class="table_none">
                            <textarea id="bctremark" name="customerPo.bctremark" cols="45" rows="5" class="text_textarea"  validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [2001]}, 'Message' : '备注输入长度大于系统规定值！'}]">${customerPo.bctremark}</textarea>
</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" id="submitButton" btn=btn title='保存' onClick="save()">
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' btn=btn onClick="clean()">
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