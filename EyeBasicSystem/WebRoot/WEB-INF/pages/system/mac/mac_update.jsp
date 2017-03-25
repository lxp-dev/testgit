<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户机修改</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#sysmacname').focus();
	});
	
	function clean(){
		document.getElementById('sysmacname').value = "";
		document.getElementById('sysmackey').value = "";
		document.getElementById('sysmacdepartmentid').value = "";
	}
	
	function save(){
	if(checkForm(document.all.macForm)){	
		$("img").removeAttr("onclick");   
		macForm.action = "updateMac.action";
		macForm.submit();
		}
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="macForm" method="post" action="">
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
						 <TD class="table_body" width="10%" height="26" >客户机名称</TD>
			             <TD class="table_none" width="40%">
			             <input type="hidden"  id="sysmacid" name="macPo.sysmacid" value="${macPo.sysmacid }" />
			             <input class="text_input200" id="sysmacname" name="macPo.sysmacname" maxlength="20" value="${macPo.sysmacname }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '客户机名称不允许为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [41]}, 'Message' : '客户机名称不能大于40字符！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
			            </tr>
                        <TR>
						 <TD class="table_body" width="10%" height="26" >客户机MAC</TD>
			             <TD class="table_none" width="40%"><input class="text_input200" id="sysmackey" name="macPo.sysmackey" maxlength="20" value="${macPo.sysmackey }"  onblur="javascript:this.value=this.value.replace(/-/g,':');" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '客户机MAC不允许为空！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '客户机MAC不允许输入中文！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [41]}, 'Message' : '客户机名称不能大于40字符！'}]"><label style="color:red;">&nbsp;*&nbsp;Mac地址格式：74:E5:0B:95:34:68</label></TD>
			            </tr>	
                        <TR>
						 <TD class="table_body" width="10%" height="26" >所属部门</TD>
			             <TD class="table_none" width="40%">
							<select id="sysmacdepartmentid" name="macPo.sysmacdepartmentid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择部门！'}]">
							<option value="">----请选择----</option>
							<c:if test="${not empty(departmentsList)}">	
			               	  <s:iterator value="departmentsList">
			               	  <OPTION value="${bdpdepartmentid}" ${macPo.sysmacdepartmentid == bdpdepartmentid ? 'selected="selected"' : '' } >${bdpdepartmentname}</OPTION>
                   	          </s:iterator>
                   	        </c:if>
							</select><label style="color:red;">&nbsp;*&nbsp;</label>
						</TD>
			            </tr>			            		            
						<TR>
						 <TD class="table_body" width="10%" height="26" >是否允许登入</TD>
			             <TD class="table_none" width="40%">
			             <select id="sysmacisable" name="macPo.sysmacisable">
							<option value="1" ${macPo.sysmacisable == 1 ? 'selected="selected"' : '' } >是</option>
							<option value="0" ${macPo.sysmacisable == 0 ? 'selected="selected"' : '' } >否</option>
						</select>
						</TD>
			            </tr>                        
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