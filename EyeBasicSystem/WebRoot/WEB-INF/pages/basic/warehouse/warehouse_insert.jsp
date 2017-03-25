<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓位新增</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#bwhid').focus();
	});
	
	function clean(){
		document.getElementById('bwhid').value = "";
		document.getElementById('bwhdeptid').value = "";
		document.getElementById('bwhwarehouseName').value = "";
	}
	
	function save(){
	if(checkForm(document.all.warehouseForm)){	
		$("img").removeAttr("onclick");   
		warehouseForm.action = "insertWarehouse.action?departmentID=${departmentID}";
		warehouseForm.submit();
		}
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="warehouseForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						 <TD class="table_body" width="9%" height="26" >仓位代码</TD>
			             <TD class="table_none" width="24%"><input class="text_input100" id="bwhid" name="warehousePo.bwhid" maxlength="10" value="${warehousePo.bwhid }" validate="[{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '仓位代码只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '仓位代码不能大于10字符！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
						 <TD width="9%" class="table_body">所属部门</TD>
                         <TD width="24%" class="table_none">
                            <select id="bwhdeptid" name="warehousePo.bwhdeptid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择部门！'}]" ${departmentID=='' ? '' : 'disabled="disabled"'}>
							<option value="">----请选择----</option>
							<c:if test="${not empty(departmentsList)}">
			               	  <s:iterator value="departmentsList">
			               	  <c:choose>
				               	  <c:when test="${not empty departmentID}">
				               	  	 <OPTION value="${bdpdepartmentid}" ${departmentID == bdpdepartmentid ? 'selected="selected"' : ''}>${bdpdepartmentname}</OPTION>
				               	  </c:when>
				               	  <c:otherwise>
				               	  	 <OPTION value="${bdpdepartmentid}" ${warehousePo.bwhdeptid == bdpdepartmentid ? 'selected="selected"' : ''}>${bdpdepartmentname}</OPTION>
				               	  </c:otherwise>
			               	  </c:choose>
                   	          
                   	          </s:iterator>
                   	        </c:if>
							</select><label style="color:red;">&nbsp;*&nbsp;</label>
                         </TD>
						  <TD class="table_body" width="9%" height="26">仓位名称</TD>
                          <TD class="table_none" width="24%"><input class="text_input160" id="bwhwarehouseName" name="warehousePo.bwhwarehouseName" value="${warehousePo.bwhwarehouseName }" maxlength="16" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '仓位名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [17]}, 'Message' : '仓位名称不能大于16字符！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
                        </TR>
                        <TR>
						 <TD class="table_body" width="9%" height="26" >排序序号</TD>
			             <TD class="table_none" width="24%" colspan="5"><input class="text_input100" id="bwhid" name="warehousePo.bwhordernumber" maxlength="5" value="1" validate="[{'Type' : Type.String, 'Formula' : Formula.ZINT, 'Message' : '输入的内容必须是正整数！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [6]}, 'Message' : '仓位代码不能大于10字符！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
                        </TR>                                                  
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
                        	  <img src="${ctx}/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
    <TD height=5></TD></TR></TBODY></TABLE>
    </form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>