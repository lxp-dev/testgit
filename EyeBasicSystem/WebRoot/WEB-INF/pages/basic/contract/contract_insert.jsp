<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制造商维护</title>
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

	function clean(){
		document.getElementById('bctcontracttitle').value = "";
		document.getElementById('bctcontractcontent').value = "";
		document.getElementById('bctcontractstartdate').value = "";
		document.getElementById('bctcontractenddate').value = "";
		document.getElementById('upload').value = "";
	}
	
	function save(){
		if(checkForm(document.all.contractForm)){ 
         	$("img").removeAttr("onclick");
			contractForm.action = "insertContract.action?hid=${hid}";
			contractForm.submit();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="contractForm" method="post" action="" enctype="multipart/form-data">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="hid" value="${requestScope.hid}" />
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
						   <TD width="8%" height="26" class="table_body">合同标题</TD>
			               <TD width="24%" class="table_none">
			                 <input class="text_input160" maxlength="25" type="text" id="bctcontracttitle" name="contractPo.bctcontracttitle" 
                            validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '合同标题不能为空！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
			               <TD width="8%" class="table_body">合同时间</TD>
			               <TD width="24%" class="table_none"><input class="text_input100"
				               id="bctcontractstartdate"
						       name="contractPo.bctcontractstartdate" value="${contractPo.bctcontractstartdate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'bctcontractenddate\')}'})"
						       readonly="readonly"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '起始时间不能为空！'}]" />
						       至
					         <input class="text_input100"
						       id="bctcontractenddate"
						       name="contractPo.bctcontractenddate" value="${contractPo.bctcontractenddate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'bctcontractstartdate\')}'})"
						       readonly="readonly"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '结束时间不能为空！'}]" /><label style="color:red;">&nbsp;*&nbsp;</label></TD>
						    <TD width="8%" class="table_body">合同附件</TD>
			                <TD class="table_none"><input type="file" name="upload"></TD>
			               </TR>
                           <TR>
						   <TD width="8%" class="table_body">合同内容</TD>
			               <TD colspan="5" class="table_none"><textarea id="bctcontractcontent" name="contractPo.bctcontractcontent" style="width:98%; overflow:auto" rows="4" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '合同内容不能为空！'}]">${contractPo.bctcontractcontent }</textarea><label style="color:red;">&nbsp;*&nbsp;</label></TD>
			               </TR>
                        </table>   
                		<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      	<TBODY>
                        	<TR>
                          		<TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
                        	  		<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
