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

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        });
	});

	function clean(){
		document.getElementById('id').value = "";
		document.getElementById('personName').value = "";
		document.getElementById('phone').value = "";
		document.getElementById('address').value = "";
		document.getElementById('email').value = "";
		document.getElementById('roleid').value="";
		document.getElementById('sex').checked = 1;
		document.getElementById('departmentID').value = "";
		document.getElementById('bdpdepartmentname').value = "";
		document.getElementById('cardid').value = "";
		document.getElementById('password').value = "";
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		if($("#personcompanyid").val() == ''){
			alert("请选择所属公司！");
			$("#personcompanyid").focus();
			return;
		}
	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action?companyid="+$("#personcompanyid").val()+"&readonlyopen=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action?companyid="+$("#personcompanyid").val()+"&readonlyopen=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
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

		$("#ds").html(document.getElementById('bdpdepartmentname').value);
	}
	
	function save(){
		if(checkForm(personInfoForm)){
			$("img").removeAttr("onclick");
			personInfoForm.action = "insertPersonInfo.action";
			personInfoForm.submit();
		}
	}
	
	function clearDepartment(){
		$("#ds").text("");
		$("#bdpdepartmentname").val("");
		$("#departmentID").val("");
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('syspsupplierid').value = json.id;
		document.getElementById('syspsuppliername').value = json.value;
		
	}

	function clearRole(id){
		$('#roleid').load("getAjaxRole.action?companyID="+ id);
    }
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
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
						   <TD width="10%" height="30" class="table_body">员工编号</TD>
			               <TD width="23%" class="table_none"><input class="text_input100" id="id" name="personInfoPo.id" value="${personInfoPo.id }" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '员工编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '员工编号只允许输入整数和字母！'}]"><label style="color:red;">&nbsp;*</label></TD>
						
                          
						  <TD width="10%" height="30" class="table_body">员工姓名</TD>
                          <TD width="23%" class="table_none"><input class="text_input100" id="personName" name="personInfoPo.personName" value="${personInfoPo.personName }" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '员工姓名不能为空！'},{'Type' : Type.String, 'Formula' : Formula.ALL_CN, 'Message' : '姓名为全中文！'}]"><label style="color:red;">&nbsp;*</label></TD>
						  <TD width="10%" height="30" class="table_body">性别</TD>
                          <TD width="24%" class="table_none"><input type="radio" id="sex" name="personInfoPo.sex" ${empty(personInfoPo.sex) ? 'checked="checked"' : '' } ${personInfoPo.sex != '1'? '' : 'checked="checked"' } value="1" />&nbsp;男 <input id="sex" type="radio" name="personInfoPo.sex" ${personInfoPo.sex != '2'? '' : 'checked="checked"' } value="2" />&nbsp;女</TD>
                        </TR>
                        
						<TR>
						   <TD width="10%" height="30" class="table_body">联系电话</TD>
			               <TD width="23%" class="table_none"><input class="text_input100" id="phone" name="personInfoPo.phone" value="${personInfoPo.phone }" maxlength="13" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '联系电话格式错误！'}]"><label style="color:red;">&nbsp;&nbsp;如：022-85123455</label></TD>
						
                          	<TD height="30" class="table_body">在职状态</TD>
				            <TD height="30" class="table_none" >
						    <select id="isinvocation" name="personInfoPo.isinvocation">
						  		<option value="0" ${personInfoPo.isinvocation == 0 ? 'selected="selected"':''}>在职</option>
						  		<option value="1" ${personInfoPo.isinvocation == 1 ? 'selected="selected"':''}>离职</option>							
							</select></TD>

			            
                          <TD width="10%" height="30" class="table_body">邮箱</TD>
                          <TD width="23%" class="table_none"><input class="text_input100" id="email" name="personInfoPo.email" value="${personInfoPo.email }" maxlength="25" validate="[{'Type' : Type.String, 'Formula' : Formula.emailORNULL, 'Message' : '邮箱格式错误！'}]"/><label style="color:red;">&nbsp;&nbsp;&nbsp;如：123@qq.com</label></TD>
						  
                        </TR>
                        
                        
						<TR>

							<TD width="10%" height="30" class="table_body">员工卡号</TD>
							<TD width="23%" class="table_none">
								<input class="text_input100" id="cardid" name="personInfoPo.cardid" validate="[{'Type' : Type.String, 'Formula' : Formula.WordNull, 'Message' : '员工卡号只允许输入整数和字母！'}]" value="${personInfoPo.cardid }" maxlength="20">
							</TD>
					    	<TD  height="30" class="table_body">员工密码</TD>
					    	<TD height="30"  class="table_none">
					    	<c:if test="${permissionPo.keyf == '1'}">
					    		<input type="text" class="text_input100" id="password" name="personInfoPo.password" value="${personInfoPo.password }" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '员工密码不能为空！'}]"/><label style="color:red;">&nbsp;*</label>
					    	</c:if>
					    	<c:if test="${permissionPo.keyf != '1'}">
					    	    <input type="password" class="text_input100" id="password" name="personInfoPo.password" value="${personInfoPo.password }" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '员工密码不能为空！'}]"/><label style="color:red;">&nbsp;*</label>
					    	</c:if>
					    	&nbsp;
					    	</TD>
					    	
					    	<TD height="26" class="table_body">所属公司</TD>
                        	<TD height="26" class="table_none">
                        	<c:if test="${person.personcompanytype ne '1'}">
                        		${person.personcompanyname }
                        		<input type="hidden" id="personcompanyid" name="personInfoPo.personcompanyid" value="${person.personcompanyid }">&nbsp;
                        	</c:if>
                        	<c:if test="${person.personcompanytype eq '1'}">
                        		<select clean="clean" id="personcompanyid" name="personInfoPo.personcompanyid" onchange="clearDepartment();clearRole(this.options[this.options.selectedIndex].value);">
                                  <option value="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" ${personInfoPo.personcompanyid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
	                              </s:iterator>
	                            </select><label style="color:red;">&nbsp;*</label>
                        	</c:if>
                        	</TD>
                        	
						</TR>
						<TR>
						   <TD width="10%" height="30" class="table_body">员工角色</TD>
			               <TD width="15%" class="table_none">
						   <select id="roleid" name="personInfoPo.roleid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择员工角色！'}]">
						   		<option value="">----请选择----</option>
					  			<c:forEach var="po" items="${roles}">
					  			<option value="${po.roleid }" ${personInfoPo.roleid != po.roleid ? '' : 'selected="selected"' }>${po.rolename }</option>
					  			</c:forEach>							
								</select><label style="color:red;">&nbsp;*</label></TD>
								
						  <TD width="10%" height="30" class="table_body">职务类型</TD>
                          <TD width="23%" class="table_none" colspan="3">
                          	<c:forEach var="personJobTypePo" items="${personJobTypePos }" >
                             	<input type="checkbox" name="personInfoPo.personjobtype" value="${personJobTypePo.bpjtid }">&nbsp;${personJobTypePo.bpjtname}&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:forEach>
                          </TD>

						</TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">家庭地址</TD>
                          <TD width="23%" class="table_none" colspan="5">
                              <input class="text_input200" id="address" name="personInfoPo.address" value="${personInfoPo.address }" maxlength="100" style="width: 600">
						      <input type="hidden" id="checkMac" name="personInfoPo.checkMac" value="1"/>
                          </TD>
						  
						</TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">部门名称</TD>
                          <TD width="90%" class="table_none" colspan="5">
                          	<li class="horizontal_onlyRight">
						   		<textarea class="textarea" id="ds" readonly="readonly" style="width: 900px; height: 60px;" >${personInfoPo.bdpdepartmentname }</textarea>
						   		<input type="hidden" class="text_input160" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" value="${personInfoPo.bdpdepartmentname }" readonly="readonly" style="width: 900px; height: 60px;" />
						   		<input type="hidden" id="departmentID" name="personInfoPo.departmentID" value="${personInfoPo.departmentID }"
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '部门名称不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li><label style="color:red;">&nbsp;*</label>
						  </TD>
						</TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();" >
						 	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()">
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
