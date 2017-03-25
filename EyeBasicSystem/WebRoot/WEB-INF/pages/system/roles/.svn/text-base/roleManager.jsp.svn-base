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
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
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
          <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
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
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：查看角色</TD>
          <TD class=menubar_menu_td align=right>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
				<c:if test="${(permissionPo.thirdKey==1)}">
                <TD class=menubar_button id=button_1 
                onmouseover=javascript:MenuOnMouseOut(this); 
                 onclick="JavaScript:window.location.href='${ctx}/initSysRoleModify.action?roleID=${jspSysRolePo.roleID}&moduleID=${requestScope.moduleID}';" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/Edit.gif" align=textTop 
                  border=0>&nbsp;修改</TD>
                </c:if>
				<c:if test="${(permissionPo.thirdKey==0)}">
                <TD class=menubar_button id=button_1 
                onmouseover=javascript:MenuOnMouseOut(this); 
                 onclick="JavaScript:permissionMessage();" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/Edit.gif" align=textTop 
                  border=0>&nbsp;修改</TD>
                </c:if>
                
                  </TR></TBODY></TABLE></TD></TR>
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
                       onclick="JavaScript:window.location.href='${ctx}/initSysRoleManager.action?roleID=${jspSysRolePo.roleID}&moduleID=${requestScope.moduleID}';"
                      background=${ctx}/img/sys/tab_active_bg.gif 
                      UNSELECTABLE="on">查看角色</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/sys/tab_active_right.gif" 
                        width=3></TD></TR></TBODY></TABLE></TD>
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    <c:if test="${(permissionPo.secondKey==1)}"> 
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/sys/tab_unactive_left.gif" 
                        width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='${ctx}/initSysRolePermissionManager.action?roleID=${jspSysRolePo.roleID}&applicationID=${jspSysRolePo.moduleApplicationID }&moduleID=${requestScope.moduleID}';"
                      background=${ctx}/img/sys/tab_unactive_bg.gif 
                      UNSELECTABLE="on">设定角色应用权限</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/sys/tab_unactive_right.gif" 
                        width=3></TD>
                        </c:if>
                    <c:if test="${(permissionPo.secondKey==0)}"> 
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/sys/tab_unactive_left.gif" 
                        width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      onclick="JavaScript:permissionMessage();"
                      background=${ctx}/img/sys/tab_unactive_bg.gif 
                      UNSELECTABLE="on">设定角色应用权限</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/sys/tab_unactive_right.gif" 
                        width=3></TD>
                        </c:if>
                        
                        </TR></TBODY></TABLE></TD>
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
                        id=ctl00_PageBody_RoleID_Txt>${jspSysRolePo.roleID}</SPAN></TD></TR>
                    <TR>
                      <TD class=table_body height="30">角色名称</TD>
                      <TD class=table_none><SPAN 
                        id=ctl00_PageBody_R_RoleName_Txt>${jspSysRolePo.roleName}</SPAN> </TD></TR>
                    <TR>
                      <TD class=table_body height="30">角色介绍</TD>
                      <TD class=table_none><SPAN 
                        id=ctl00_PageBody_R_Description_Txt>${jspSysRolePo.roleDescription}</SPAN> </TD></TR>
                    </TBODY></TABLE></DIV><!--内容框End--></TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>