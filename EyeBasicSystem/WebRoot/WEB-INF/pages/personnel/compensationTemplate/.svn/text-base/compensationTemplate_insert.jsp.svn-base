<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000;
	font-weight: bold;
}
-->
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工薪酬模板维护</title>
</head>
<script>	
$(document).ready(function() {
		document.getElementById("personid").focus();
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	/**
	 * 人员开窗
	 */
	function openPersonInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selPersonOpen.action?isOpen=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selPersonOpen.action?isOpen=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【人员开窗】";
	}
	
	
	/**
	 * 部门开窗赋值实现方法
	 */
	function openPersonValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departmentname = new Array();
		var persons = eval('(' + objValue + ')');
		for(var i = 0; i < persons.length; i++){	
			arrayID[i] = persons[i].personid;
			arrayName[i] = persons[i].personname;
			departmentname[i] = persons[i].departmentname;
			
		}
		
		document.getElementById('personid').value = arrayID.join(",");
		document.getElementById('personname').value = arrayName.join(",");
		document.getElementById('departmentname').value = departmentname.join(",");
		personInfoForm.action="initCompensationTemplateInsert.action?pid="+document.getElementById("personid").value.trim();
		personInfoForm.submit();
	}
	
	function selectPerson()
	{
		if(document.getElementById("personid").value.trim() != '')
		if(event.keyCode == 13)
		{
			personInfoForm.action="initCompensationTemplateInsert.action?pid="+document.getElementById("personid").value.trim();
			personInfoForm.submit();
		}
		
	}
	function save(){
		if(checkForm(personInfoForm))
		{
			
			document.all.submitButton.disabled="true";
			personInfoForm.action = "insertCompensationTemplatePo.action";
			personInfoForm.submit();
		}
	}
</script>
<body  onkeydown="KeyDown()"    onhelp="Showhelp();return false;">
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>员工薪酬管理</TD>
          
          <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：员工薪酬模板新增</TD>
          <TD align=right>&nbsp;</TD>
          </TR>
        <TR>         
<TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
						   <TD width="10%" height="30" class="table_body">ID号</TD>
			               <TD width="23%" class="table_none">
			                <li class="horizontal_onlyRight">
			               <input class="text_input100" id="personid" name="compensationTemplatePo.mctpersonid" value="${compensationTemplatePo.mctpersonid }" onkeyup="selectPerson()" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : 'ID号不能为空!'}]">
			                 		                 
                          </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openPersonInfo();">
						   </li>
			                 
			                 </TD>
						
                          
						  <TD width="10%" height="30" class="table_body">姓名</TD>
                          <TD width="23%" class="table_none"><input class="text_input100" id="personname" name="compensationTemplatePo.personname" value="${compensationTemplatePo.personname }" readonly="readonly" >
                            </TD>
						  <TD width="10%" height="30" class="table_body">部门名称</TD>
                          <TD width="24%" class="table_none"><input class="text_input100" id="departmentname" name="compensationTemplatePo.departmentname" value="${compensationTemplatePo.departmentname }" readonly="readonly"></TD>
                        </TR>
                          
                           </TBODY>
                    </TABLE>  
                    
                   <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                   <tr>
                   <td align="left">
                   基本工资信息
                   
                   </td>
                   </tr>
                    </TABLE>                 
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>                        
						<TR>
							<TD width="10%" height="30" class="table_body">基本工资</TD>
				            <TD width="23%" class="table_none"><input class="text_input100" id="mctjibengongzi" name="compensationTemplatePo.mctjibengongzi" maxlength="7" value="${compensationTemplatePo.mctjibengongzi }" disabled='disabled'> ${compensationTemplatePo.mctxueliname}</TD>
							<TD width="10%" height="30" class="table_body">岗位津贴</TD>
	                        <TD width="24%" class="table_none"><input class="text_input100" id="mctgangweijintie" name="compensationTemplatePo.mctgangweijintie" maxlength="7" value="${ compensationTemplatePo.mctgangweijintie}" disabled='disabled'> ${compensationTemplatePo.mctzhichengname}</TD>                         
							<TD width="10%" height="30" class="table_body">工龄工资</TD>
	                        <TD width="23%" class="table_none"><input class="text_input100" id="mctgonglingjintie"" name="compensationTemplatePo.mctgonglingjintie" maxlength="7" value="${compensationTemplatePo.mctgonglingjintie }" disabled='disabled'> ${compensationTemplatePo.mctgonglingname}年</TD> 
                        </TR>
						<TR>
							<TD width="10%" height="30" class="table_body">保险</TD>
				            <TD width="23%" class="table_none"><input class="text_input100" id="mctbaoxian"" name="compensationTemplatePo.mctbaoxian" maxlength="7" value="${compensationTemplatePo.mctbaoxian }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>
							<TD width="10%" height="30" class="table_body">公积金</TD>
	                        <TD width="24%" class="table_none"><input class="text_input100" id="mctgongjijin" name="compensationTemplatePo.mctgongjijin" maxlength="7" value="${ compensationTemplatePo.mctgongjijin}" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>                         
							<TD width="10%" height="30" class="table_body">误餐费</TD>
	                        <TD width="23%" class="table_none"><input class="text_input100" id="mctwucanfei"" name="compensationTemplatePo.mctwucanfei" maxlength="7" value="${compensationTemplatePo.mctwucanfei }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD> 
                        </TR> 
						<TR>
							<TD width="10%" height="30" class="table_body">洗理费</TD>
				            <TD width="23%" class="table_none"><input class="text_input100" id="mctxilifei"" name="compensationTemplatePo.mctxilifei" maxlength="7" value="${compensationTemplatePo.mctxilifei }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>
							<TD width="10%" height="30" class="table_body">&nbsp;</TD>
	                        <TD width="24%" class="table_none">&nbsp;</TD>                         
							<TD width="10%" height="30" class="table_body">&nbsp;</TD>
	                        <TD width="23%" class="table_none">&nbsp;</TD> 
                        </TR>                                               
                      </TBODY>
                    </TABLE>  
                    
                    
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">	
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>

