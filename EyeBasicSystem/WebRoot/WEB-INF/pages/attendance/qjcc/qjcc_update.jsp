<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事考勤</title>
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
		if(checkForm(personInfoForm)){
			
			document.all.submitButton.disabled="true";
			personInfoForm.action = "updateQjcc.action";
			personInfoForm.submit();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>请假出差管理</TD>
         
          <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：请假出差修改</TD>
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
						   <TD width="10%" height="30" class="table_body">登记日期</TD>
			               <TD width="40%" class="table_none">${qjccPo.dateb }<input type="hidden" class="text_input200" id="dateb" name="qjccPo.dateb" value="${qjccPo.dateb}" maxlength="20" readonly="readonly"></TD>
						  <TD width="10%" height="30" class="table_body">请假出差类型</TD>
                          <TD width="40%" class="table_none">
                          <input type="hidden" class="text_input200" id="dateb" name="qjccPo.typemain" value="${qjccPo.typemain}" maxlength="20" readonly="readonly">
                          <input type="hidden" class="text_input200" id="dateb" name="qjccPo.typezi" value="${qjccPo.typezi}" maxlength="20" readonly="readonly">
                           ${qjccPo.typemainname}&nbsp;&nbsp;&nbsp;&nbsp;${qjccPo.typeziname}
                          </TD>
						</TR>
						<TR>
						   <TD width="10%" height="30" class="table_body">人员</TD>
			               <TD class="table_none" colspan="3">
                            ${qjccPo.personname}
							<input clean=clean class="text_input100" type="hidden" id="pinfoid" name="qjccPo.pinfoid" value="${qjccPo.pinfoid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取人员！'}]"/>									    
                            <input type="hidden" name="qjccPo.id" value="${qjccPo.id}"> 
                          </TD>
						</TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">发生时间</TD>
                          <TD width="40%" class="table_none">
                          <input id="timeb"
					       name="qjccPo.timeb" clean="clean" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'timee\')}',dateFmt:'yyyy-MM-dd HH:mm'})"
					       value="${qjccPo.timeb}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取发生时间！'}]"/> 
					                  至 
					       <input id="timee" clean="clean" 
					       name="qjccPo.timee" 
					       type="text" class="text_input120" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'timeb\')}',dateFmt:'yyyy-MM-dd HH:mm'})" 
					        value="${qjccPo.timee}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取发生时间！'}]"/> 
                          </TD>
                          <TD width="10%" height="30" class="table_body">合计小时数</TD>
                          <TD width="40%" class="table_none">
                           <input clean=clean class="text_input100" id="sumxs" name="qjccPo.sumxs" value="${qjccPo.sumxs}" type="text" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写合计小时数！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '合计小时数应为整数！'}]"/>              
                          </TD>
                        </TR>
						<TR>
						  <TD width="10%" height="30" class="table_body">备注</TD>
                          <TD colspan="3" class="table_none">
                             <textarea clean=clean id="typesay"  name="qjccPo.typesay" >${qjccPo.typesay}</textarea>
                          </TD>
                        </TR>                

                      </TBODY>
                    </TABLE>
					
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()"></TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
