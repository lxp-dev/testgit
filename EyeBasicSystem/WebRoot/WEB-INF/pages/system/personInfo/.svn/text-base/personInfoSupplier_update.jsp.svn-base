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

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        });
	});

	function clean(){
		$("[clean=clean]").val("");
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
			showPopWin("initDepartmentOpen.action?companyid="+$("#personcompanyid").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action?companyid="+$("#personcompanyid").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
			personInfoForm.action = "updatePersonInfoSupplier.action";
			personInfoForm.submit();
		}
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
<input type="hidden" name="personInfoPo.syspsupplierid" id="syspsupplierid" value="${personInfoPo.syspsupplierid}" >
<input type="hidden" name="hidden" id="hid" value="${personInfoPo.syspsupplierid}" >
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
              	<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif
                      onClick="JavaScript:window.location.href='initSupplierUpdate.action?hid=${personInfoPo.syspsupplierid }&parent=${parent}&goodsTree=${goodsTree}&moduleID=B0109';" 
                      UNSELECTABLE="on">制造商修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                    </TD>
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">制造商维护人</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    
					</TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					</TR>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
						   <TD width="10%" height="30" class="table_body">人员编号</TD>
			               <TD width="23%" class="table_none">${personInfoPo.id }<input class="text_input100" type="hidden" id="id" name="personInfoPo.id" value="${personInfoPo.id }" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '人员编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '人员编号只允许输入整数和字母！'}]"></TD>
						  <TD width="10%" height="30" class="table_body">人员姓名</TD>
                          <TD class="table_none"><input class="text_input100" clean=clean id="personName" name="personInfoPo.personName" value="${personInfoPo.personName }" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '人员姓名不能为空！'},{'Type' : Type.String, 'Formula' : Formula.ALL_CN, 'Message' : '姓名为全中文！'}]"><label style="color:red;">&nbsp;*</label></TD>
                        </TR>
                        
                        
						<TR>
						   <TD width="10%" height="30" class="table_body">人员角色</TD>
			               <TD width="23%" class="table_none">
						   <select id="roleid" clean=clean name="personInfoPo.roleid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择人员角色！'}]">
						   		<option value="">----请选择----</option>
					  			<c:forEach var="po" items="${roles}">
					  			<option value="${po.roleid }" ${personInfoPo.roleid != po.roleid ? '' : 'selected="selected"' }>${po.rolename }</option>
					  			</c:forEach>							
								</select><label style="color:red;">&nbsp;*</label></TD>
					    	<TD height="30" class="table_body">员工密码</TD>
					    	<TD height="30"  class="table_none">
					    	<c:if test="${permissionPo.keyf == '1'}">
					    		<input type="text" class="text_input100" clean=clean id="password" name="personInfoPo.password" value="${personInfoPo.password }" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '人员密码不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '人员密码只允许输入整数和字母！'}]"/><label style="color:red;">&nbsp;*</label>
					    	</c:if>
					    	<c:if test="${permissionPo.keyf != '1'}">
					    	    <input type="password" class="text_input100" clean=clean id="password" name="personInfoPo.password" value="${personInfoPo.password }" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '人员密码不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '人员密码只允许输入整数和字母！'}]"/><label style="color:red;">&nbsp;*</label>
					    	</c:if>
					    	&nbsp;
					    	<input type="hidden" id="departmentID" name="personInfoPo.departmentID" value="600"/>
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
