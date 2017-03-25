<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信用户注册部门修改</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#bwhid').focus();
	});
	
	function clean(){
		$("input[clean=clean]").val("");
	}
	
	function save(){
		if(checkForm(document.all.registerDepartmentForm)){	
			$("img").removeAttr("onclick");   
			registerDepartmentForm.action = "updateWeiXinRegisterDepartmentPo.action";
			registerDepartmentForm.submit();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="registerDepartmentForm" method="post" action="">
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
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						 <TD class="table_body" width="10%" height="26" >微信账号原始ID</TD>
			             <TD class="table_none" colspan="5">
			               <input clean=clean class="text_input400" id="wrdaccount" name="weiXinRegisterDepartmentPo.wrdaccount" maxlength="50" value="${weiXinRegisterDepartmentPo.wrdaccount }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '微信账号原始ID不能为空！'}]">
			               <input type="hidden" name="weiXinRegisterDepartmentPo.wrdid" value="${weiXinRegisterDepartmentPo.wrdid }" />
			               <label style="color:red;">&nbsp;*&nbsp;</label>
						 </TD>
						</TR>
						<TR valign="middle">
                       	<TD height="30" class="table_body" align="right">AppId</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  type="text" class="text_input400" name="weiXinRegisterDepartmentPo.wrdappid" value="${weiXinRegisterDepartmentPo.wrdappid }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写AppId！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '请重新填写AppId！'}]">
                       		<label style="color:red;">&nbsp;*&nbsp;申请微信公众号时获得</label>
                       	</TD>
                       </TR>  
                        <TR valign="middle">
                       	<TD height="30" class="table_body" align="right">AppSecret</TD>
                       	<TD class="table_none" colspan="5">
                       		<input  type="password" class="text_input400" name="weiXinRegisterDepartmentPo.wrdappsecret" value="${weiXinRegisterDepartmentPo.wrdappsecret }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写AppSecret！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '请重新填写AppSecret！'}]">
                       		<label style="color:red;">&nbsp;*&nbsp;申请微信公众号时获得</label>
                       	</TD>
                       </TR>							
						<TR>
						 <TD class="table_body" width="10%" height="26" >注册部门</TD>
			             <TD class="table_none" colspan="5">
			                   	<select id="wrddepartmentid" name="weiXinRegisterDepartmentPo.wrddepartmentid">
						    	<c:forEach var="po" items="${departmentList}" varStatus="poIndex">
						    		<OPTION value="${po.bdpdepartmentid}" ${(po.bdpdepartmentid eq weiXinRegisterDepartmentPo.wrddepartmentid) ? 'selected="selected"' : ''} }>${po.bdpdepartmentname}</OPTION>
						    	</c:forEach>
						    	</select>
			               <label style="color:red;">&nbsp;*&nbsp;注：通过该微信号注册的新用户会注册到选定的门店</label>
						 </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
                        	  <!--<img src="${ctx}/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">-->
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