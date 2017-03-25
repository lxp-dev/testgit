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
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initRoleModify.action?roleID="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initRoleModify.action?roleID="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【角色修改】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initRoleAdd.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initRoleAdd.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【角色新增】";
	}
	function setRole(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initRolePermissionModifyNew.action?roleID="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initRolePermissionModifyNew.action?roleID="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【角色设置】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initRoleDelete.action?roleID="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initRoleDelete.action?roleID="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【角色删除】";
	}

	function search(){
		$("img").removeAttr("onclick");
		roleFrm.action = "initRoleList.action";
		roleFrm.submit();
		showLoadingBar();
	}

	function clean(){
		$('#roleFrm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#companyID').val(''); 
	}

	function copyRole(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initRoleCopyInsert.action?moduleID=${requestScope.moduleID}",600,300,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【复制角色】";
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="roleFrm" name="roleFrm" method="post" action="">
	<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<input type="hidden" name="dengji" value="2">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- 头部菜单 Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%">
          	<IMG hspace=3 src="${ctx }/img/pic/module.gif" align=absMiddle vspace=3 border=0>基础信息
          </TD>
          <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：角色维护</TD>
          <td align="right" valign="bottom">&nbsp;
          	<c:if test="${(permissionPo.keya == 1)}">
          	    <c:if test="${person.personcompanytype eq '1'}">
          	    <img src="${ctx }/img/newbtn/btn_copyrole_0.png" btn=btn title="复制角色" onclick="copyRole();"/>
          	    </c:if>
          		<img src="${ctx }/img/newbtn/btn_roleinsert_0.png" btn=btn title="新增角色" onclick="insert();"/>
          	</c:if>
          </td>
        </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
        </TR>
       </TR></TBODY></TABLE><!-- 头部菜单 End --><!-- 选项卡 Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/sys/tab_bg.gif>
          </TD></TR>
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
					      <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
					      <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
					      </TR>
					    </TBODY>
					  </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="10%" height="26" class="table_body">角色名称</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input160" id="roleName2" name="roleName2" value="${roleName2}" maxlength="50"/></TD>
                          <TD width="10%" height="26" class="table_body">角色描述</TD>
                          <TD width="23%" class="table_none">
                          <input clean="clean" class="text_input160" id="roleDescription2" name="roleDescription2" value="${roleDescription2}" maxlength="50"/>
                          </TD>
                          <TD width="10%" height="26" class="table_body">所属公司</TD>
                          <TD width="23%" class="table_none">
                              <c:if test="${person.personcompanytype == '1'}">
                              	<select id="companyID" name="companyID">
	                              <option value="" ${companyID == '' ? 'selected="selected"' : '' }>----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" ${companyID == fcnId ? 'selected="selected"' : '' }>${fcnName}</option>
	                              </s:iterator>
	                            </select>
                              </c:if>
                              
                              <c:if test="${person.personcompanytype == '2'}">
                              	${person.personcompanyname}
                              	<input id="companyID" name="companyID" value="${person.personcompanyid}" maxlength="50" type="hidden"/>
                              </c:if>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${(permissionPo.keyd==1)}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" ></td>
						</tr>
					</table>
					</c:if>
				    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                   <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                    <TR class=table_title align=middle>                      
                      <TH width="8%" scope=col colspan="2">操作</TH>
                      <TH height="26" scope=col>角色名称</TH>
                      <TH scope=col>角色描述</TH>
                      <TH scope=col>所属公司</TH>
                    </TR>
                    <c:if test="${not empty(requestScope.jspSysRoleList)}">
	                   <c:forEach items="${requestScope.jspSysRoleList}" var="item" varStatus="lineNum">
	                       <tr class=row style="HEIGHT: 26px" align=middle>
	                          <TD width="4%">
	                          	<c:if test="${(permissionPo.keyl==1)}">
	                          	  <c:if test="${(item.isDelete != '1' ) || (personid eq 'admin')}">
	                          		<img src="${ctx }/img/newbtn/configure_0.png" btn=btn title='设置' onClick="setRole('${item.roleid }')">
	                          	  </c:if>
	                          	</c:if>  
	                          </TD>
	                          <TD width="4%">
	                          	<c:if test="${(permissionPo.keyb==1)}">
	                          	  <c:if test="${(item.isDelete != '1' ) }">
	                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${item.roleid }')" >
	                          	  </c:if>
	                          	</c:if>
	                          </TD>  
	                          <TD height="26">${item.rolename}</TD>
	                          <TD>${item.roledescription} </TD>
	                          <TD>${item.rolecompanyname} </TD>
	                       </tr>
	                   </c:forEach>
                    </c:if>
                      </TBODY>
                    </table>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
