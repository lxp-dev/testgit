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
<title>员工考勤维护</title>
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
		if(checkForm(attendanceManageForm))
		{
			
			document.all.submitButton.disabled="true";
			attendanceManageForm.action = "updateAttendanceManagePo.action";
			attendanceManageForm.submit();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="attendanceManageForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="">
<input type="hidden" value="${attendanceManagePo.mamuuid}" name="attendanceManagePo.mamuuid" id="mamuuid"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>员工薪酬管理</TD>
         
          <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：员工考勤修改</TD>
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
						   <TD class="table_body">年度</TD>
						   <TD height="30" align="left" class="table_none">${attendanceManagePo.mamyear }</TD>
      	                   <TD class="table_body">月份</TD>
						   <TD height="30" align="left" class="table_none">${attendanceManagePo.mammonth }</TD></TD>
      	                   <TD class="table_body">&nbsp;</TD>
						   <TD height="30" align="left" class="table_none">&nbsp;</TD>
      	                </TR>                         
                      </TBODY>
                    </TABLE>                  
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>                        
						<TR>
							<TD width="10%" height="30" class="table_body">迟到</TD>
				            <TD width="23%" class="table_none"><input class="text_input100" id="mamchidao" value="${attendanceManagePo.mamchidao}" name="attendanceManagePo.mamchidao" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>
							<TD width="10%" height="30" class="table_body">早退</TD>
	                        <TD width="24%" class="table_none"><input class="text_input100" id="mamzaotui" value="${attendanceManagePo.mamzaotui}" name="attendanceManagePo.mamzaotui" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>                         
							<TD width="10%" height="30" class="table_body">病假</TD>
	                        <TD width="23%" class="table_none"><input class="text_input100" id="mambingjia" value="${attendanceManagePo.mambingjia}" name="attendanceManagePo.mambingjia" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD> 
                        </TR>
						<TR>
							<TD width="10%" height="30" class="table_body">事假</TD>
				            <TD width="23%" class="table_none"><input class="text_input100" id="mamshijia" value="${attendanceManagePo.mamshijia}" name="attendanceManagePo.mamshijia" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>
							<TD width="10%" height="30" class="table_body">婚假</TD>
	                        <TD width="24%" class="table_none"><input class="text_input100" id="mamhunjia" value="${attendanceManagePo.mamhunjia}" name="attendanceManagePo.mamhunjia" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>                         
							<TD width="10%" height="30" class="table_body">丧假</TD>
	                        <TD width="23%" class="table_none"><input class="text_input100" id="mamsangjia" value="${attendanceManagePo.mamsangjia}" name="attendanceManagePo.mamsangjia" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD> 
                        </TR> 
						<TR>
							<TD width="10%" height="30" class="table_body">产假</TD>
				            <TD width="23%" class="table_none"><input class="text_input100" id="mamchanjia" value="${attendanceManagePo.mamchanjia}" name="attendanceManagePo.mamchanjia" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>
							<TD width="10%" height="30" class="table_body">探亲</TD>
	                        <TD width="24%" class="table_none"><input class="text_input100" id="mamtanqinjia" value="${attendanceManagePo.mamtanqinjia}" name="attendanceManagePo.mamtanqinjia" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>                         
							<TD width="10%" height="30" class="table_body">公假</TD>
	                        <TD width="23%" class="table_none"><input class="text_input100" id="mamgongjia" value="${attendanceManagePo.mamgongjia}" name="attendanceManagePo.mamgongjia" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD> 
                        </TR>                                                                      
						<TR>
							<TD width="10%" height="30" class="table_body">出差</TD>
				            <TD width="23%" class="table_none"><input class="text_input100" id="mamchuchai" value="${attendanceManagePo.mamchuchai}" name="attendanceManagePo.mamchuchai" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>
							<TD width="10%" height="30" class="table_body">外出学习</TD>
	                        <TD width="24%" class="table_none" colspan="3"><input class="text_input100" id="mamwaichuxuexi" value="${attendanceManagePo.mamwaichuxuexi}" name="attendanceManagePo.mamwaichuxuexi" maxlength="7" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '只能是整数或小数！'}]"></TD>                         
						</TR>  
						<TR>
							<TD width="10%" height="30" class="table_body">备注</TD>
				            <TD class="table_none" colspan="5">
								<textarea  id="mamremark" name="attendanceManagePo.mamremark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]" style="width:100%" cols="80" rows="7">${attendanceManagePo.mamremark}</textarea>
							</TD> 
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

