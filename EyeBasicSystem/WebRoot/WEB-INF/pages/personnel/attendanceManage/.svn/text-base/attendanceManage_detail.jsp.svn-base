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
<title>员工工资维护</title>
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
</script>
<body onkeydown="KeyDown()"    onhelp="Showhelp();return false;">
<form name="salaryForm" method="post" action="">
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
          <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：人员考勤详细</TD>
          <TD>&nbsp;</TD></TR>
        <TR>
          <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD></TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
			               <TD width="23%" class="table_none">${attendanceManagePo.mampersonid }</TD>
							<TD width="10%" height="30" class="table_body">姓名</TD>
                          	<TD width="24%" class="table_none">${attendanceManagePo.mampersonname }</TD>
						  	<TD width="10%" height="30" class="table_body">部门名称</TD>
                         	<TD width="23%" class="table_none">${attendanceManagePo.mamdepartmentname }</TD>
                        </TR>
                        <TR>	
						   <TD class="table_body" width="9%">年度</TD>
						   <TD height="30" align="left" class="table_none" width="23%">${attendanceManagePo.mamyear }</TD>
      	                   <TD class="table_body" width="9%">月份</TD>
						   <TD height="30" align="left" class="table_none" width="24%">${attendanceManagePo.mammonth }</TD>
      	                   <TD class="table_body">&nbsp;</TD>
						   <TD height="30" align="left" class="table_none">&nbsp;</TD>
      	                </TR>
                       </TBODY>
                    </TABLE>                
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>                        
						<TR>
							<TD width="10%" height="30" class="table_body">迟到</TD>
				            <TD width="23%" class="table_none">${attendanceManagePo.mamchidao }</TD>
							<TD width="10%" height="30" class="table_body">早退</TD>
	                        <TD width="24%" class="table_none">${attendanceManagePo.mamzaotui }</TD>                         
							<TD width="10%" height="30" class="table_body">病假</TD>
	                        <TD width="23%" class="table_none">${attendanceManagePo.mambingjia }</TD> 
                        </TR>
						<TR>
							<TD width="10%" height="30" class="table_body">事假</TD>
				            <TD width="23%" class="table_none">${attendanceManagePo.mamshijia }</TD>
							<TD width="10%" height="30" class="table_body">婚假</TD>
	                        <TD width="24%" class="table_none">${attendanceManagePo.mamhunjia }</TD>                         
							<TD width="10%" height="30" class="table_body">丧假</TD>
	                        <TD width="23%" class="table_none">${attendanceManagePo.mamsangjia }</TD> 
                        </TR> 
						<TR>
							<TD width="10%" height="30" class="table_body">产假</TD>
				            <TD width="23%" class="table_none">${attendanceManagePo.mamchanjia }</TD>
							<TD width="10%" height="30" class="table_body">探亲</TD>
	                        <TD width="24%" class="table_none">${attendanceManagePo.mamtanqinjia }</TD>                         
							<TD width="10%" height="30" class="table_body">公假</TD>
	                        <TD width="23%" class="table_none">${attendanceManagePo.mamgongjia }</TD> 
                        </TR>                                                                      
						<TR>
							<TD width="10%" height="30" class="table_body">出差</TD>
				            <TD width="23%" class="table_none">${attendanceManagePo.mamchuchai }</TD>
							<TD width="10%" height="30" class="table_body">外出学习</TD>
	                        <TD width="24%" class="table_none" colspan="3">${attendanceManagePo.mamwaichuxuexi }</TD>                         
						</TR>  
						<TR>
							<TD width="10%" height="30" class="table_body">备注</TD>
				            <TD class="table_none" colspan="5">${attendanceManagePo.mamremark }</TD> 
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