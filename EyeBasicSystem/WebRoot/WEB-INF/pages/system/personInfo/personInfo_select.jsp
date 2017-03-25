<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工维护</title>
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
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	personInfoForm.action=link;
	  	personInfoForm.submit();
		showLoadingBar();
	}
	function search(){
		personInfoForm.action = "selPersonInfo.action";
		personInfoForm.submit();
		showLoadingBar();
	}
	
	function invocation(invocation,cid){
		var moduleID = document.getElementById("moduleID").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdatePersonInfoInvocation.action?invocation="+invocation+"&cid="+cid+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdatePersonInfoInvocation.action?invocation="+invocation+"&cid="+cid+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工启用/停用】";
	}
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initPersonInfoUpdate.action?hid="+id+"&goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPersonInfoUpdate.action?hid="+id+"&goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工更新】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initPersonInfoInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPersonInfoInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initPersonInfoDelete.action?hid="+id+"&goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",400,160,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPersonInfoDelete.action?hid="+id+"&goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",400,160,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工删除】";
	}	
		
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initPersonInfoDetail.action?selId="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPersonInfoDetail.action?selId="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【员工详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
	    document.all.selId.value="";
	    document.all.selPersonName.value="";
	    document.all.selDepartmentID.value="";
	    document.all.selRoleid.value="";
	    document.all.isinvocation.value="";
	    document.getElementById('departmentID').value="";
	    document.all.bdpdepartmentname.value="";
	    
	    $("[clean=clean]").val("");
	}
	
	//导出员工
	function exportCashCoupon(){
	    if ('${confirmSwitch}' == '1'){
	        if (confirm("此功能将根据您在查询条件中输入的数据导出员工信息，是否确认导出？")){
	    	    if ($('#addTable').size() == 0){
		            alert("请先查询出需要导出的员工信息！");
		            return;
		        }else{
		            personInfoForm.action="exportPersonInfo.action";
		            personInfoForm.submit();
		        }	
	       }
	    }else{
		    if ($('#addTable').size() == 0){
			    alert("请先查询出需要导出的员工信息！");
			    return;
			}else{
			    personInfoForm.action="exportPersonInfo.action";
			    personInfoForm.submit();
			}
	    }

	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		if($("#companysid").val() == ''){
			alert("请选择所属公司！");
			$("#companysid").focus();
			return;
		}
	
		var companyid = $("#companysid").val();
	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action?companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action?companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input  id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：员工维护</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}"> 
            		<img src="${ctx }/img/newbtn/btn_personinsert_0.png" btn=btn title="员工新增" onclick="insert()"/>
            	</c:if>
            	<img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
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
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                     
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">员工编号</TD>
			               <TD width="24%" class="table_none"><input class="text_input100" name="selId" value="${selId }" /></TD>
					
						   <TD width="8%" height="26" class="table_body">员工姓名</TD>
                          <TD width="24%" class="table_none"><input class="text_input100" name="selPersonName" value="${selPersonName }"></TD>
                      
                      <TD width="8%" height="26" class="table_body">员工角色</TD>
			           <TD height="26" class="table_none">
					   <select name="selRoleid">
					  		<option value="">----请选择----</option>
					  		<c:forEach var="po" items="${roles}">
					  		<option value="${po.roleid }" ${selRoleid != po.roleid ? '' : 'selected="selected"' }>${po.rolename }</option>
					  		</c:forEach>							
						</select></TD>
						
                     </TR>
					<TR>
						  <TD height="26" class="table_body">所属公司</TD>
                        	<TD height="26" class="table_none" >
							<c:if test="${person.personcompanytype eq '1'}">
								<select clean="clean" id="companysid" name="companysid">
	                              <option value="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" ctype="${fcnmasterorvice }" ${companysid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
	                              </s:iterator>
	                            </select>
							</c:if>
							<c:if test="${person.personcompanytype ne '1'}">
								${person.personcompanyname}
								<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid}"/>
							</c:if>
                        	</TD>
                          <TD height="26" class="table_body">所属部门</TD>
                          <TD class="table_none" colspan="3">

                           <li class="horizontal_onlyRight">
						   		<input class="text_input240" id="bdpdepartmentname" name="selDepartmentName" readonly="readonly" value="${selDepartmentName}"/>
						   		<input type="hidden" id="departmentID" name="selDepartmentID" value="${selDepartmentID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openDepartment();">
						   </li>
						  </TD>
					   	   
				       </TR>
				       <TR>
                        	<TD height="26" class="table_body">在职状态</TD>
				            <TD height="26" class="table_none" colspan="5">
						    <select name="isinvocation">
						   		<option value="">----请选择----</option>
						  		<option value="0" ${isinvocation == 0 ? 'selected="selected"':''}>在职</option>
						  		<option value="1" ${isinvocation == 1 ? 'selected="selected"':''}>离职</option>							
							</select>
							</TD>
                       </TR>	
                      </TBODY>
                    </TABLE>
               		<c:if test="${(permissionPo.keyd==1)}">  
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >
							  	<img src="${ctx }/img/newbtn/btn_exportexecl_0.png" btn=btn title='导出EXCEL' onclick="exportCashCoupon()">
							</td>
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
					<c:if test="${not empty(persons)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="12%" height="26" scope=col colspan="4">操作</TH>
                          <TH width="8%" scope=col>员工编号</TH>
                          <TH width="10%" scope=col>员工姓名</TH>
                          <th width="20%">所属公司</th>
						  <th>所属部门</th>
                          <TH width="10%" scope=col>员工角色</TH>
                        </TR>
                        <c:forEach var="po" items="${persons}" >
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keye==1)}">
                          		<img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="detail('${po.id }')">
                          	</c:if>		
                          </TD>
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyc==1)}">
                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${po.id }')">
                          	</c:if>		
                          </TD>
                          
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyb==1)}">
                          		<c:if test="${sessionScope.person.id!=po.id }">
                          			<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.id }')" >
                          		</c:if>	
                          	</c:if>	
                          </TD>
                            
                          <TD width="3%">
							<c:if test="${po.isinvocation==0}">
								<c:if test="${sessionScope.person.id!=po.id }">
									<img src="${ctx }/img/newbtn/inservice_0.png" btn=btn title='离职' onClick="javascript:invocation('${po.isinvocation }','${po.id}')">
								</c:if>
							</c:if>
							<c:if test="${po.isinvocation==1}">
								<c:if test="${sessionScope.person.id!=po.id }">
									<img src="${ctx }/img/newbtn/quit_0.png" btn=btn title='在职' onClick="javascript:invocation('${po.isinvocation }','${po.id}')">
								</c:if>
							</c:if>
						  </TD>
                          <TD height="26">${po.id }</TD>
                          <TD>${po.personName }</TD>
                          <td>${po.personcompanyname }</td>
						  <td>${po.bdpdepartmentname }</td>
                          <TD>${po.rolename }</TD>
                        </TR>
                        </c:forEach>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
