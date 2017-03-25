<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProjectManage</title>
</head>
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
            vspace=3 border=0>&nbsp;角色资料管理</TD>
                              <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();parent.window.document.forms(0).submit();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：角色应用权限管理</TD>
          <TD class=menubar_menu_td align=right>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
              <c:if test="${(permissionPo.secondKey==1)}">
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="JavaScript:window.location.href='${ctx}/initSysRoleManager.action?roleID=${jspSysRolePo.roleID}&applicationID=${jspSysApplicationsPo.applicationID}&moduleID=${requestScope.moduleID}';"  
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/look.gif" align=textTop 
                  border=0>&nbsp;角色资料</TD>
               </c:if>
               <c:if test="${(permissionPo.secondKey==0)}">
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="JavaScript:permissionMessage();"  
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/look.gif" align=textTop 
                  border=0>&nbsp;角色资料</TD>
               </c:if>
               <c:if test="${(permissionPo.thirdKey==1)}">
                <TD class=menubar_button id=button_1 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="JavaScript:window.location.href='${ctx}/initSysRolePermissionModify.action?roleID=${jspSysRolePo.roleID}&applicationID=${jspSysApplicationsPo.applicationID}&moduleID=${requestScope.moduleID}';"  
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/Edit.gif" align=textTop 
                  border=0>&nbsp;修改角色权限</TD>
                </c:if>
                <c:if test="${(permissionPo.thirdKey==0)}">
                <TD class=menubar_button id=button_1 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="JavaScript:permissionMessage();"  
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/Edit.gif" align=textTop 
                  border=0>&nbsp;修改角色权限</TD>
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
                      background=${ctx}/img/sys/tab_active_bg.gif 
                      UNSELECTABLE="on">角色应用权限管理</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/sys/tab_active_right.gif" 
                        width=3></TD></TR></TBODY></TABLE></TD><!--按钮 End--></TR></TBODY></TABLE></TD></TR>
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
                    <TR>
                      <TD class=table_body height="30" width="25%">角色名称</TD>
                      <TD class=table_none ><SPAN 
                        id=ctl00_PageBody_RoleName_Txt>${jspSysRolePo.roleName}</SPAN></TD></TR>
                    <TR>
                      <TD class=table_body height="30" width="25%">应用名称</TD>
                      <TD class=table_none ><SPAN 
                        id=ctl00_PageBody_AppName_Txt>${jspSysApplicationsPo.applicationAppName}</SPAN></TD></TR></TBODY></TABLE>
                  <DIV id=rightsTable 
                  ondblclick=javascript:Check_CheckBox(this);>
                  <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                    <TBODY>
 <c:if test="${not empty(requestScope.jspSysModulesList)}">
	<c:forEach items="${requestScope.jspSysModulesList}" var="item" varStatus="lineNum">
                   <TR class=table_title>
                      <TD colSpan=9 height="30" >${item.moduleCname}</TD></TR>
                    <TR class=table_body align=middle>
                      <TD align=left width="25%" height="30">栏目名称</TD>
                      <TD align=left colSpan=8>权限名称</TD></TR>
          <c:if test="${not empty(item.childList)}">
			<c:forEach items="${item.childList}" var="itemChild" varStatus="lineNumChild">
                    <TR class=table_none align=middle>
                      <TD align=left height="30">${itemChild.moduleCname}</TD>
                      <TD align=left colSpan=8>
                        <TABLE 
                        id=ctl00_PageBody_Module_Main_ctl00_Module_Sub_ctl00_PermissionList 
                        style="WIDTH: 100%" cellSpacing=3 cellPadding=1 
border=0>
                          <TBODY>
                          <TR>
                             <TD>
                             <c:choose>
                             	<c:when test="${not empty(itemChild.rolePermissionList)}">
									<c:forEach items="${itemChild.rolePermissionList}" var="itemPermission" varStatus="lineNumPermission">									
											<IMG src="${ctx}${(itemPermission.pageKey=='1') ? ('/img/sys/allow.gif') : ('/img/sys/disable.gif')}" align=absBottom>&nbsp;${itemPermission.pageName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</c:forEach>
								</c:when>
								<c:otherwise>
									<IMG src="${ctx}/img/sys/disable.gif" align=absBottom>
								</c:otherwise>
                             </c:choose></TD>                        
                          <TR>
                           </TR></TBODY></TABLE></TD></TR>
			</c:forEach>
		</c:if>                           
	</c:forEach>
</c:if>
</TBODY></TABLE></DIV></DIV><!--内容框End--></TD>
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