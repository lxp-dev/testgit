<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区域配置</title>
</head>
<script>
	function save(){
		if(checkForm(document.all.regionalConfigurationForm)){ 	    
			$("img").removeAttr("onclick");
			regionalConfigurationForm.action = "updateRegionalConfiguration.action";
			regionalConfigurationForm.submit();
		}
	}	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<FORM name=regionalConfigurationForm method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="departmentsPo.bdpdepartmentid" value="${departmentsPo.bdpdepartmentid}">
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
              <table width="100%"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                </TABLE>
							<table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                              <TBODY>
                                <TR class=table_title align=middle>
                                  <TH scope=col width="16%"  height="30">门店名称</TH>
                                  <TH scope=col width="12%">所属区域</TH>
                                </TR>
                                <TR class="row">
                                  <TD  height="26">${departmentsPo.bdpdepartmentname}</TD>
                                  <TD>
                                  <SELECT  id="bdpregid" name="departmentsPo.bdpregid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '区域不能为空！'}]"> 
                             		<OPTION value="">----请选择----</OPTION>
	                             	<c:if test="${not empty(brcregList)}">
					               	  <s:iterator value="brcregList">
	                    	           <OPTION value="${bdpdepartmentid}" ${departmentsPo.bdpregid != bdpdepartmentid ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
									</SELECT><label style="color:red;">&nbsp;*</label>
								  </TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                          <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD> <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
		                        	  <!-- <input icon='icon-reload' type='reset' value='重置' > -->
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
			            </DIV>
			            
			                </DIV>
			                  <!--?End-->
			                   </TD>
			                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
			                  src="${ctx}/img/pic/tab_bg.gif" 
			width=1></TD></TR></TBODY></TABLE></TD></TR>
			        <TR>
			        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
			            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
			  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
<script>
	var index_bdpregid = 0;
	var arr = document.all.bdpregid.options.length;
	for(i=0;i<arr;i++){
		if(document.all.bdpregid.options.options[i].value == '<c:out value="${departmentsPo.bdpregid}"/>'){
			document.all.bdpregid.options.selectedIndex = index_bdpregid;
			break;
		}
		index_bdpregid++;
	}
</script>