<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户机维护</title>
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
	
	function search(){
		$("img").removeAttr("onclick");
		macForm.action = "selMacForPerson.action";
		macForm.submit();		
		showLoadingBar();
	}
	function clean(){
	    $("input[clean=clean]").val("");
	    $("select[clean=clean]").val("");
	}	
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateMac.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateMac.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【客户机更新】";
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertMacForPerson.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertMacForPerson.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		/*if(is_iPad()){
			showPopWin("initMacPersonInfoSel.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initMacPersonInfoSel.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}*/
		document.getElementById('popupTitle').innerHTML="【例外人员新增】";
	}
	
	function initDel() {
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var flag = false;
		$('input[id=insertPersonIDs]').each(function() {
			if($(this).attr('checked')) {
				flag = true;
				return;
			}
		});
		
		if(flag) {
			if(is_iPad()){
				showPopWin("initDelMacForPerson.action",400,140,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initDelMacForPerson.action",400,140,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【例外人员批量删除】";
		} else {
			alert("请选择删除的人员!");
		}
	}
	function del(){
		$("img").removeAttr("onclick");
		macForm.action = "updatePersonCheckMac.action?&updateOrDelFlag=del";
		macForm.submit();
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var companyid = '';
		if ('${person.personcompanytype}' == '2'){
			companyid = '${person.personcompanyid}';
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action?isClosed=1&companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action?isClosed=1&companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
	}	
	/**
	 * 人员开窗
	 */
	function openPersonInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWagePersonInfoSel.action?isOpen=1&moduleID=M0302",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWagePersonInfoSel.action?isOpen=1&moduleID=M0302",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【人员查询】";
	}
	/**
	 * 开窗赋值实现方法
	 */
	function openCustomerValues(json){
		/*document.getElementById('mwpersonid').value = json.id;
		document.getElementById('personName').value = json.value;
		document.getElementById('departmentName').value = json.dept;
		document.getElementById('mwbasicsalary').value = json.mctbasicsalary;
		document.getElementById('mwattendanceward').value = json.mctattendanceaward;
		document.getElementById('mwdutyallowance').value = json.mctdutyallowance;
		document.getElementById('mwsubsidy').value = json.mctsubsidy;
		document.getElementById('mwhousingreserve').value = json.mcthousingreserve;
		document.getElementById('mwpersonalsecuring').value = json.mctpersonalsecurity;
		document.getElementById('mwyearendbonus').value = json.mctyearendbonus;
		sum();*/
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="macForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统设置</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：Mac地址验证例外人员</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keye==1)}">
            		<img src="${ctx }/img/newbtn/btn_khjy_0.png" title="Mac地址验证例外人员新增" btn=btn onClick="insert()">
            	</c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
          <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    <c:if test="${(permissionPo.keya==1) || (permissionPo.keyb==1) || (permissionPo.keyc==1) || (permissionPo.keyd==1)}">
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initMacSel.action?moduleID=${requestScope.moduleID}'"
                      UNSELECTABLE="on">客户机维护</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">Mac地址验证例外人员</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
                            </table>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						  <TD width="9%" height="26" class="table_body">员工编号</TD>
			              <TD class="table_none"><input clean=clean class="text_input100" id="personID" name="selPersonID" value="${selPersonID}" maxlength="32"></TD>
						  <TD width="9%" height="26" class="table_body">员工姓名</TD>
                          <TD class="table_none"><input clean=clean class="text_input160" id="personName" name="selPersonName" value="${selPersonName}" maxlength="50"></TD>
                           <TD height="26" class="table_body">所属部门</TD>
                          <TD class="table_none">

                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input240" id="bdpdepartmentname" name="selDepartmentName" readonly="readonly" value="${selDepartmentName}"/>
						   		<input clean=clean type="hidden" id="departmentID" name="selDepartmentID" value="${selDepartmentID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openDepartment();">
						   </li>
						  </TD>
                          <%--<TD width="9%" height="26" class="table_body">所属部门</TD>
                          <TD class="table_none">
                            <select id="pg_sysmacdepartmentid" name="pg_sysmacdepartmentid">
							<option value="">----请选择----</option>
							<c:if test="${not empty(departmentsList)}">
			               	  <s:iterator value="departmentsList">
                   	           <OPTION value="${bdpdepartmentid}" ${pg_sysmacdepartmentid == bdpdepartmentid ? 'selected="selected"' : '' } >${bdpdepartmentname}</OPTION>
                   	          </s:iterator>
                   	        </c:if>
							</select>
                          </TD>--%>
                        </TR>
						<TR>
                      <TD width="8%" height="26" class="table_body">员工角色</TD>
			           <TD height="26" class="table_none" colspan="5">
					   <select clean=clean name="selRoleid">
					  		<option value="">----请选择----</option>
					  		<c:forEach var="po" items="${roles}">
					  		<option value="${po.roleid }" ${selRoleid != po.roleid ? '' : 'selected="selected"' }>${po.rolename }</option>
					  		</c:forEach>							
						</select></TD>
						  <%--<TD width="9%" height="26" class="table_body">当前状态</TD>
                          <TD class="table_none" colspan="3">
							<select id="pg_sysmaccurrentloginpersonid" name="pg_sysmaccurrentloginpersonid">
								<option value="">全部客户机</option>
								<option value="1" ${pg_sysmaccurrentloginpersonid == '1' ? 'selected="selected"' : '' }>在线客户机</option>
							</select>
						  </TD>--%>
                          
                        </TR>                        
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
						      <c:if test="${(permissionPo.keyg==1)}">
								<img src="${ctx }/img/newbtn/btn_search_0.png" id="submitButton" btn=btn title='查询' onClick="javascript:search()">
	                       		<img src="${ctx }/img/newbtn/btn_empty_0.png" title="清空" btn=btn onClick="clean()">
	                          </c:if>
						      <c:if test="${(permissionPo.keyf==1)}">
	                       		<img src="${ctx }/img/newbtn/btn_plsc_0.png" btn=btn id="submitButton" title='批量删除' onClick="javascript:initDel()">  
	                       	  </c:if>
	                        </td>
						</tr>
					</table>
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
                    <c:if test="${not empty(personInfoList)}">		
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="6%" scope=col >
                          <input type="checkbox" id="chks" onclick="javascript:$('input[id=insertPersonIDs]').attr('checked',this.checked);"/>      
                                                        全选</TH>
                          <TH width="20%" height="26" scope=col>员工工号</TH>
                          <TH width="14%" scope=col>员工姓名</TH>
                          <TH width="25%" scope=col>所属部门</TH>
                          <TH width="15%" scope=col>角色名称</TH>
                          <TH width="20%" scope=col >验证Mac地址状态</TH>
                        </TR>
                        <s:iterator value="personInfoList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                  <TD width="3%">
                         	<input type="checkbox" id="insertPersonIDs" name="insertPersonIDs" value="${id}"/>
		                  	<%--<c:if test="${(permissionPo.keyd==1)}">
                              <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${id}')">
		                  	</c:if>--%>
		                  </TD>
						  </TD>
                          <TD height="26">${id}</TD>
                          <TD>${personName}</TD>
                          <TD>${bdpdepartmentname}</TD>
                          <TD>${rolename }</TD>
                          <TD>${checkMac eq '0' ? '否' : '是'}</TD>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
                    </c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>