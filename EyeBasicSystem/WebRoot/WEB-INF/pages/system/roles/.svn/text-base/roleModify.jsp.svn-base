<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProjectManage</title>
</head>
<script>
	function save(){
	if(checkForm(document.all.sysRoleForm)){
		$("img").removeAttr("onclick");
		sysRoleForm.action = "roleModify.action";
		sysRoleForm.submit();
		}
	}
	
	function del(){
	    var moduleID=document.all.moduleID.value;
        if ('${confirmSwitch}' == '1'){
	        if(confirm('你确认删除此角色么？')){
	             sysRoleForm.action = "sysRoleDelete.action?roleID=${rolePo.roleid}";
			     sysRoleForm.submit();
	        }
        }else{
      	    sysRoleForm.action = "sysRoleDelete.action?roleID=${rolePo.roleid}";
			sysRoleForm.submit();  
        }
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<FORM name="sysRoleForm"method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<s:token></s:token>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  
  <TBODY>
  <TR>
    <TD><!-- 头部菜单 Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><IMG hspace=3 
            src="${ctx}/img/pic/module.gif" align=absMiddle 
            vspace=3 border=0>&nbsp;角色维护</TD>
          <TD class=menubar_readme_text vAlign=bottom><TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this);
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE></TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：修改角色</TD>
          <TD class=menubar_menu_td align=right>&nbsp;</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- 头部菜单 End --><!-- 选项卡 Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/sys/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--按钮　Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/sys/tab_active_left.gif" 
                        width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/sys/tab_active_bg.gif 
                      UNSELECTABLE="on">修改角色</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/sys/tab_active_right.gif" 
                        width=3></TD></TR></TBODY></TABLE></TD>
                <!--按钮 End--></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 
                  background=${ctx}/img/sys/tab_bg.gif><IMG 
                  height=1 src="${ctx}/img/sys/tab_bg.gif" 
                  width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><INPUT id=FrameWork_YOYO_LzppccSelectIndex 
                  type=hidden value=0 name=FrameWork_YOYO_LzppccSelectIndex><!--内容框Start-->
                  <DIV id=tabContent__0 style="DISPLAY: ">
                  <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                    <TBODY>
                    <TR id=ctl00_PageBody_TopTr>
                      <TD class=table_body height="30">角色ID</TD>                      
                      <TD class=table_none><SPAN 
                        id=ctl00_PageBody_RoleID_Txt>${rolePo.roleid}<input type="hidden" name="rolePo.roleid" value="${rolePo.roleid}" ></SPAN></TD></TR>
                    <TR>
                      <TD class=table_body height="30">角色名称</TD>
                      <TD class=table_none><INPUT class=text_input 
                        id=roleName maxlength="25" title=请输入角色名称~50:! size=50 
                        value="${rolePo.rolename}" name="rolePo.rolename" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '角色名称不能为空！'}]"></TD></TR>
                    <TR>
                      <TD class=table_body height="30">角色介绍</TD>
                      <TD class=table_none><INPUT class=text_input 
                        id=roleDescription maxlength="120" title=请输入角色介绍~255: 
                        size=50 value="${rolePo.roledescription}"  name="rolePo.roledescription" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '角色介绍不能为空！'}]"></TD></TR>
                                        <TR id=ctl00_PageBody_SubmitTr>
                      <TD align=left colSpan=2><input icon='icon-save' id="submitButton" type='button' value='保存' onClick="save()">
                        	<input icon='icon-reset' type='reset' value='重置' >&nbsp; 
                      </TD></TR></TBODY></TABLE></DIV><!--内容框End--><!--内容框Start-->
                <TD width=1 
                  background=${ctx}/img/sys/tab_bg.gif><IMG 
                  height=1 src="${ctx}/img/sys/tab_bg.gif" 
                  width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/sys/tab_bg.gif 
          bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/sys/tab_bg.gif" 
        width=1></TD></TR></TBODY></TABLE><!--选项卡 End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></FORM></DIV></body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>