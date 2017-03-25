<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事变动管理</title>
</head>

<body onkeydown="KeyDown()"    onhelp="Showhelp();return false;">
<form name="personForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="S2003">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    
            <TD width="15%" class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>人事变动</TD>
          <TD width="45%" align="left" height="27"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：人事变动详细</TD>
          <TD >
				
			</TD>
          
  </TR>
	<TR>
		 <TD class=menubar_function_text colspan="3"><table></table></TD>
	</TR>
</TBODY>
</TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png">&nbsp;</TD>
                                </TR>
                              </TBODY>
                      </TABLE>
					  <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                     
                      <TBODY>
					  	<TR height="26">
						   <TD width="9%" class="table_body">ID号</TD>
			               <TD width="24%" class="table_none">${personnelChangePo.mpcpersonid }</TD>
					
						   <TD width="9%" class="table_body">人员姓名</TD>
                          <TD width="24%" class="table_none">${personnelChangePo.mpcpersonname }</TD>
                      
                          <TD class="table_body">所属部门</TD>
                          <TD class="table_none">${personnelChangePo.mpcdepartmentname}</TD>
                        </TR>
					<TR height="26">
					   <TD width="9%" class="table_body">职务</TD>
			               <TD width="24%" class="table_none">${personnelChangePo.mpcpostname }</TD>
					
						   <TD width="9%" class="table_body">变动类型</TD>
                          <TD width="24%" class="table_none">${personnelChangePo.mpcchangetype }</TD>
                      
                          <TD class="table_body">变动时间</TD>
                          <TD class="table_none">${personnelChangePo.mpcchangedate }</TD>
			           

				    
                    <TR height="26">
					   <TD class="table_body">变动内容</TD>
			           <TD colspan="5" class="table_none">${personnelChangePo.mpccontent}
			           </TD>
			           </TR><br>
      
                    </TABLE>
                 
                       
                          
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
  

