<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统模块维护</title>
</head>
<script>	
	function save(){
		if(checkForm(moduleSystemForm)){
			$("img").removeAttr("onclick");
			moduleSystemForm.action = "insertSystemModule.action";
			moduleSystemForm.submit();
		}
	}
	
	function changeRadioType(obj){    
    	var objValue=obj.value;
    	if(objValue=="0"){  
    		document.getElementById("displayID").style.display="none";  
    		document.getElementById("displayID").style.display="none"; 
    		document.getElementById("moduleparentid").validate=""; 
    		document.getElementById("moduledirectory").validate="";      		
    	}else{
    		document.getElementById("displayID").style.display="";
    		document.getElementById("displayID").style.display="";
    		document.getElementById("moduleparentid").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'所属父节点不能为空！\'}]";  		
    		document.getElementById("moduledirectory").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'子节点URL不能为空！\'}]";  		
    	}
    }
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="moduleSystemForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
          <br/>
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
						   <TD width="10%" height="26" class="table_body">新增类别</TD>
			               <TD width="40%" colspan="3" class="table_none">
					   			<input name="modulePo.moduleID" id="moduleID" type="radio" value="0" checked="checked" onClick="changeRadioType(this)"/>父节点
	  				  		  	<input name="modulePo.moduleID" id="moduleID" type="radio" value="1" onClick="changeRadioType(this)"/>子节点
	  				  	   </TD>
	  				  	</TR>
	  				  	<TR id="displayID" style="display:none;">
						   <TD width="10%" height="26" class="table_body">所属父节点</TD>
			               <TD width="40%" colspan="3" class="table_none">			               	
			               		<select id="moduleparentid" name="modulePo.moduleparentid" validate="">
			               		<option value="">----请选择----</option>
						  		<c:if test="${not empty(modulePoMaxList)}">
				               	  <s:iterator value="modulePoMaxList">
                    	           <OPTION value="${moduleid}">${moduleid}${modulecname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
							</select><label style="color:red;">&nbsp;*</label>
			               </TD>
						</TR>
							<tr id="displayID1" style="display:none;">					   
						   <TD width="10%" class="table_body">子节点URL</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input200" id="moduledirectory" type="text" name="modulePo.moduledirectory" maxlength="50" ><label style="color:red;">&nbsp;*</label></TD>
						</tr>
						<tr >					   
						   <TD width="10%" class="table_body">顺序</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input200" type="text" name="modulePo.moduleorderlevel" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '顺序不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
						</tr>
						<tr>					   
						   <TD width="10%" class="table_body">图片路径</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input200" type="text" name="modulePo.moduleicon" maxlength="50">(父节点专用)</TD>
						</tr>
						<tr>					   
						   <TD width="10%" class="table_body">节点编号</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input200" type="text" name="modulePo.moduleid" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '节点编号不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
						</tr>
						<tr>					   
						   <TD width="10%" class="table_body">内容</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input200" type="text" name="modulePo.modulecname" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
						</tr>
						<tr>					   
						   <TD width="10%" class="table_body">描述</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input200" type="text" name="modulePo.moduleDescribe" value="${modulePo.moduleDescribe}" maxlength="100"></TD>
						</tr>
                      </TBODY>
                    </TABLE>
 		
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><input icon='icon-save' id="submitButton" type='button' value='保存' onclick="save();" >
                        	<input icon='icon-reload' type="reset" value='清除' >
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