<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商维护</title>
</head>
<script>
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            </TD>
					</TR></TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
						   <TD width="9%" height="26" class="table_body">供应商代码</TD>
			               <TD width="19%" class="table_none">${supplierPo.bspid}&nbsp;
                            <input type="hidden" id="bspid" name="supplierPo.bspid" value="${supplierPo.bspid}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">供应商简称</TD>
			               <TD width="22%" class="table_none">${supplierPo.bspsuppliername}&nbsp;</TD>
			               <TD height="26" class="table_body">供应商全称</TD>
			               <TD class="table_none">${supplierPo.bspfroshort}&nbsp;</TD>
			               
                        </TR>
                        <TR>	
                           <TD height="26" class="table_body">所属制造商</TD>
			               <TD class="table_none">
			               	${supplierPo.bsplinksuppliername }
			               </TD>		               
						   <TD height="26" class="table_body">供应商电话</TD>
			               <TD class="table_none">${supplierPo.bspcontactphone}&nbsp;</TD>
			               <TD width="9%" height="26" class="table_body">供应商联系人</TD>
			               <TD width="19%" class="table_none">${supplierPo.bspcontactperson}&nbsp;</TD>
                        </TR>
                        <TR>	
			               <TD height="26" class="table_body">联系人电话</TD>
			               <TD class="table_none" colspan="5">${supplierPo.bsplinkmanphonel}&nbsp;</TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">供应商地址</TD>
			               <TD class="table_none" colspan="5">${supplierPo.bspaddress}&nbsp;</TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">三证号</TD>
			               <TD class="table_none">
                             ${supplierPo.bsplicenceid }&nbsp;
			               </TD>
			               <TD height="26" class="table_body">三证有效期</TD>
			               <TD class="table_none" colspan="3">
			               	 ${supplierPo.bsplicencevalidity}&nbsp;
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">医疗器械经营许可证号</TD>
			               <TD class="table_none">
                             ${supplierPo.bspylicenceid }&nbsp;
			               </TD>
			              <TD height="26" class="table_body">医疗器械经营许可证有效期</TD>
			               <TD class="table_none" colspan="3">
			               	 ${supplierPo.bspylicencevalidity }&nbsp;
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">全国工业品生产许可证号</TD>
			               <TD class="table_none">
                             ${supplierPo.bspglicenceid }&nbsp;
			               </TD>
			              <TD height="26" class="table_body">全国工业品生产许可证有效期</TD>
			               <TD class="table_none" colspan="3">
			               	 ${supplierPo.bspglicencevalidity}&nbsp;
			               </TD>
                        </TR>
                        <TR>
			              <TD height="62" class="table_body">备注</TD>
			               <TD class="table_none" colspan="5">
                             ${supplierPo.bspremark}&nbsp;
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
	
	
	




