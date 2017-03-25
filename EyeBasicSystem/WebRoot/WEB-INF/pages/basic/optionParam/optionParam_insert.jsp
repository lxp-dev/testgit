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
			optionParamForm.action = "insertOptionParam.action";
			optionParamForm.submit();
		}
	}
	
	function changeRadioType(obj){    
    	var objValue=obj.value;
    	if(objValue=="1"){  
    		document.getElementById("displayID1").style.display="";
    		document.getElementById("displayID").style.display="none";  
    		document.getElementById("fopparentid").validate="";
    		document.getElementById("fopmoduleid").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'ModuleID不能为空！\'}]";
    	}else{
    		document.getElementById("displayID").style.display="";
    		document.getElementById("displayID1").style.display="none"; 
    		document.getElementById("fopparentid").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'所属主值不能为空！\'}]";
    		document.getElementById("fopmoduleid").validate="";  		
    	}
    }

	function chk(){
		var obj = document.getElementById("fopparentid");
		$("#fopparamid").val(obj.value+"_");
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
								   <TD width="10%" height="26" class="table_body">新增类别</TD>
					               <TD width="40%" colspan="3" class="table_none">
					               <c:if test="${not empty optionParamPo.foptype }" >
							   			<input name="optionParamPo.foptype" id="foptype" type="radio" value="1"  ${optionParamPo.foptype == 1 ?  'checked="checked"':'' }   onClick="changeRadioType(this)"/>主值
			  				  		  	<input type="radio" id="foptype" name="optionParamPo.foptype" value="2" ${optionParamPo.foptype == 2 ?  'checked="checked"':'' } onClick="changeRadioType(this)"/>子值
			  				  	   </c:if>
			  				  	   <c:if test="${empty optionParamPo.foptype }" >
			  				  	   		<input name="optionParamPo.foptype" id="foptype" type="radio" value="1"  checked="checked"  onClick="changeRadioType(this)"/>主值
			  				  		  	<input type="radio" id="foptype" name="optionParamPo.foptype" value="2"  onClick="changeRadioType(this)"/>子值
			  				  	   </c:if>
			  				  	   </TD>
			  				  	</TR>
			  				  	<c:if test="${empty optionParamPo.fopparentid }" >
			  				  	
			  				  	<TR id="displayID" style="display:none;">
								   <TD width="10%" height="26" class="table_body">所属主值</TD>
					               <TD width="40%" colspan="3" class="table_none">			               	
					               		<select id="fopparentid" name="optionParamPo.fopparentid" validate="" onchange="chk()">

					               		<option value="">----请选择----</option>
								  		<c:if test="${not empty(optionParamMaxList)}">
						               	  <s:iterator value="optionParamMaxList">
		                    	           <OPTION value="${fopparamid}">${fopparamname}</OPTION>
		                    	          </s:iterator>
		                    	        </c:if>
									</select><label style="color:red;">&nbsp;*</label>
					               </TD>
								</TR>
								</c:if>
								<c:if test="${not empty optionParamPo.fopparentid }" >			  				  	
			  				  	<TR id="displayID" style="display: ;">
								   <TD width="10%" height="26" class="table_body">所属主值</TD>
					               <TD width="40%" colspan="3" class="table_none">			               	
					               		<select id="fopparentid" name="optionParamPo.fopparentid" validate="" onchange="getText()">
					               		<option value="">----请选择----</option>
								  		<c:if test="${not empty(optionParamMaxList)}">
						               	  <s:iterator value="optionParamMaxList">
		                    	           <OPTION value="${fnpid}" ${optionParamPo.fopparentid == fopparamid ?  'selected="selected"':'' } >${fopparamname}</OPTION>
		                    	          </s:iterator>
		                    	        </c:if>
									</select><label style="color:red;">&nbsp;*</label>
					               </TD>
								</TR>
								</c:if>
								<tr>					   
								   <TD width="10%" class="table_body">编号</TD>
								   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
								   	  <input class="text_input160" type="text" id="fopparamid" name="optionParamPo.fopparamid"  maxlength="20" value="${optionParamPo.fopparamid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '编号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [21]}, 'Message' : '编号不能大于20位！'}]"><label style="color:red;">&nbsp;*</label></TD>
								</tr>								
								<tr>					   
								   <TD width="10%" class="table_body">内容</TD>
								   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
								   	  <input class="text_input160" type="text" id="fopparamname" name="optionParamPo.fopparamname" value="${optionParamPo.fopparamname }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
								</tr>
								<tr id="displayID1">
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
								   	  <input class="text_input200" type="text" id="fopremark" name="optionParamPo.fopremark" value="${optionParamPo.fopremark }" maxlength="50" /></TD>
								</tr>								
                      </TBODY>
                    </TABLE>
 		
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img  src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  id="submitButton" title='保存' onclick="save();" >
                        	  <!-- <input icon='icon-reload' type="reset" value='清除' > -->
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