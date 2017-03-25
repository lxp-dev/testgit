<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提醒窗口设置</title>
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

	function changeSearch(obj){
		location.href="initReminderWindowSel.action?frwsid="+obj.value;
	}

	function save(){
		$("img").removeAttr("onclick");
		reminderWindowForm.action = "updateReminderWindow.action";
		reminderWindowForm.submit();
	}	

	$(function() {
        $("#checkAll").click(function() {
             $('input[name="roleids"]').attr("checked",this.checked); 
         });
         var $roleids = $("input[name='roleids']");
         $roleids.click(function(){
             $("#checkAll").attr("checked",$roleids.length == $("input[name='roleids']:checked").length ? true : false);
         });
     });
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="reminderWindowForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：提醒窗口设置 </td>
          </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
	      </TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%""><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                       <TR>
                         <TD height="30" class="table_body" align="right" width="15%">提醒类型&nbsp;&nbsp;</TD>
                         <TD class="table_none" width="85%">
                         	<select name="frwsid" onchange="javascript:changeSearch(this);">
                         	<option value="">--请选择--</option>
							    <c:forEach var="reminderWindowPoTmp" items="${reminderWindowList}" > 
									<option value="${reminderWindowPoTmp.frwsid}" ${(reminderWindowPo.frwsid eq reminderWindowPoTmp.frwsid)? 'selected':''}>${reminderWindowPoTmp.frwsname}</option>                                	
	                            </c:forEach>       
                            </select>      
                         </TD>
                       </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                       <TR>
                         <TD height="30" class="table_body" align="right" width="15%">允许查看的部门类型&nbsp;&nbsp;</TD>
                         <TD class="table_none" width="85%">
                         	<c:set value="${ fn:split(reminderWindowPo.frwsdepartmenttypeid, ',') }" var="str" />   
						    <c:forEach var="departmentTypePoTmp" items="${departmentTypeList}" > 
						   		<c:set value="" var="checkStr" />
						   		<c:forEach items="${ str }" var="s">
						   			<c:if test="${fn:trim(s) == fn:trim(departmentTypePoTmp.bdtid)}">
						   				<c:set value="checked=checked" var="checkStr" />
						   			</c:if>									          											
									</c:forEach> 																			   		 
			   					<input name="departmenttypeids" type="checkbox" ${checkStr}  value="${departmentTypePoTmp.bdtid }">${departmentTypePoTmp.bdtname}                                    	
                            </c:forEach>             
                         </TD>
                       </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                       <TR>
                         <TD height="30" class="table_body" align="right" width="15%">
                         	允许查看的角色&nbsp;&nbsp;<br/>
                         	全选<input id="checkAll" type="checkbox" />&nbsp;&nbsp;
                         </TD>
                         <TD width="85%">
                         	<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">
	                         	<c:set value="${ fn:split(reminderWindowPo.frwsroleid, ',') }" var="str" />   
							    <c:forEach var="rolePoTmp" items="${roleList}"  varStatus="status"> 
						    		<c:if test="${status.count%4==1}">
										<tr>
									</c:if> 
										<td>
								   		<c:set value="" var="checkStr" />
								   		<c:forEach items="${ str }" var="s">
								   			<c:if test="${(fn:trim(s) == fn:trim(rolePoTmp.roleid)) || reminderWindowPo.frwsroleid eq ''}">
								   				<c:set value="checked=checked" var="checkStr" />
								   			</c:if>									          											
										</c:forEach> 																			   		 
					   					<input name="roleids" type="checkbox" ${checkStr}  value="${rolePoTmp.roleid }">${rolePoTmp.rolename} 									
										</td>
									<c:if test="${status.count%4==0}">
										</tr>
									</c:if>                                   	
                            </c:forEach>  
                            </table>           
                         </TD>
                       </TR>
                      </TBODY>
                    </TABLE>                                          
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<font color="red" size="3"><b>* 注：员工想查看某提醒信息，需要进行三部配置，且设置中都要包含该提醒信息；</b></font><br/>
                          	<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、员工所在的部门类型，需要设置允许查看该提醒信息；</font><br/>
                          	<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、员工所属的角色，需要设置允许查看该提醒信息；</font><br/>
                          	<font size="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、员工个人设置中，需要设置允许查看该提醒信息；</font><br/>
                          </TD>
                        </TR>
                        <c:if test="${reminderWindowPo!=null && reminderWindowPo.frwsid ne ''}">                      
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();">
                          </TD>
                        </TR>
                        </c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY>
    </html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
