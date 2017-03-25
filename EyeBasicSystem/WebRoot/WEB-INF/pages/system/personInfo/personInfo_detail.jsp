<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员维护</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
    	var personjobtype="${personInfoPo.personjobtype }".split(",");
    	$("a[id=personjobtype]").hide();
		for(var i=0; i<personjobtype.length; i++){
			$("a[id=personjobtype][value="+personjobtype[i].trim()+"]").show();
		}
	});

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="8%" height="26" class="table_body">人员编号</TD>
			               <TD width="23%" class="table_none">&nbsp;${personInfoPo.id }</TD>
						
                          
						  <TD width="8%" height="26" class="table_body">人员姓名</TD>
                          <TD width="23%" class="table_none">${personInfoPo.personName }</TD>
						  <TD width="8%" height="26" class="table_body">性别</TD>
                          <TD class="table_none">${personInfoPo.sex != '1'? '女' : '男' }</TD>
                        </TR>
						<TR>
						   <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">${personInfoPo.phone }</TD>
						
							<TD height="26" class="table_body">在职状态</TD>
				            <TD height="26" class="table_none" >
				            ${personInfoPo.isinvocation == 0 ? '在职':'离职'}
						    </TD>

                          <TD height="26" class="table_body">邮箱</TD>
                          <TD class="table_none">
                          ${personInfoPo.email }
                          </TD>
						  
                        </TR>                        
                        <TR>
						    <TD width="10%" height="26" class="table_body">人员角色</TD>
			                <TD width="15%" class="table_none">
						        ${personInfoPo.rolename}
						    </TD>
							<TD width="10%" height="26" class="table_body">员工卡号</TD>
							<TD width="23%" class="table_none">
								${personInfoPo.cardid }
							</TD>
					    	<TD  height="26" class="table_body">员工密码</TD>
					    	<TD height="26"  class="table_none">
					    		<c:if test="${permissionPo.keyf == '1'}">
					    		${personInfoPo.password }
					    		</c:if>
					    		&nbsp;
					    	</TD>
						</TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">职务类型</TD>
                          <TD width="23%" class="table_none" colspan="3">
                          	<c:forEach var="personJobTypePo" items="${personJobTypePos }">
                             	<a id="personjobtype" value="${personJobTypePo.bpjtid}">${personJobTypePo.bpjtname}</a>
                            </c:forEach>
                          </TD>
                          
                          <TD width="10%" height="30" class="table_body">所属公司</TD>
                          <TD width="23%" class="table_none">
                          	${personInfoPo.personcompanyname }&nbsp;
                          </TD>
						</TR>
						<TR>
						  <TD height="26" class="table_body">家庭地址</TD>
                          <TD class="table_none" colspan="5">${personInfoPo.address }</TD>			            
						</TR>
						<TR>
						  <TD height="26" class="table_body">部门名称</TD>
                          <TD class="table_none" colspan="5">${personInfoPo.bdpdepartmentname }</TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
