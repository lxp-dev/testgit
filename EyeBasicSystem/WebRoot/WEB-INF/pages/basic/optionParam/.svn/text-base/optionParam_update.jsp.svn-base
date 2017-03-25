<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下拉值维护</title>
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

	function save(){
		if(checkForm(optionParamForm)){
			$("img").removeAttr("onclick");
			optionParamForm.action = "updateOptionParam.action";
			optionParamForm.submit();
		}
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="optionParamForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
						   <TD width="10%" height="26" class="table_body">所属类别</TD>
			               <TD width="40%" colspan="3" class="table_none">
			               <input type="hidden" value="${optionParamPo.fopparamid}" class="text_input100" id="fopparamid" name="optionParamPo.fopparamid">
			               <input type="hidden" value="${optionParamPo.foptype}" class="text_input100" id="foptype" name="optionParamPo.foptype">
			               <input type="hidden" value="${optionParamPo.fopparentid}" class="text_input100" id="fopparentid" name="optionParamPo.fopparentid">
					   		<c:choose>
                          	<c:when test="${optionParamPo.foptype=='1'}">
                          		主值
                          	</c:when>
                          	<c:when test="${optionParamPo.foptype=='2'}">
                          		子值
                          	</c:when>
                        	<c:otherwise>
		               			---错误---
			               	</c:otherwise>
	                       </c:choose>
	  				  	   </TD>
	  				  	</TR>
	  				  	<c:if test="${optionParamPo.foptype=='2'}">
	  				  	<TR>
						   <TD width="10%" height="26" class="table_body">所属主值</TD>
			               <TD width="40%" colspan="3" class="table_none">	
			               <input type="hidden" value="${optionParamPo.fopparentname}" class="text_input100" id="fopparentname" name="optionParamPo.fopparentname">		               	
			               		${optionParamPo.fopparentname}
			               </TD>
						</TR>
						</c:if>
						<tr>					   
						   <TD width="10%" class="table_body">内容</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input160" type="text" value="${optionParamPo.fopparamname}" name="optionParamPo.fopparamname" maxlength="25" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
						</tr>
						<tr>					   
						   <TD width="10%" class="table_body">所属模块</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
				   			  <select id="fopmoduleid" name="optionParamPo.fopmoduleid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : 'ModuleID不能为空！'}]">
			               		<option value="">----请选择----</option>
				               	  <s:iterator value="moduleList">
                    	           <OPTION value="${moduleid}" ${optionParamPo.fopmoduleid == moduleid ?  'selected="selected"':'' } >(${moduleid})${modulecname}</OPTION>
                    	          </s:iterator>
							  </select><label style="color:red;">&nbsp;*</label>									  
						   </TD>
						</tr>
						<tr>					   
						   <TD width="10%" class="table_body">备注</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input200" type="text" value="${optionParamPo.fopremark}" name="optionParamPo.fopremark" maxlength="50"></TD>
						</tr>												
                      </TBODY>
                    </TABLE>
 		
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();" >
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