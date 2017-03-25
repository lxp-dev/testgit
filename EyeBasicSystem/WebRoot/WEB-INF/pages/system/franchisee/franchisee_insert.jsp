<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
#１ {
	color: #F00;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 14px;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 18px;
}
.STYLE1 {	color: #FF0000;
	font-weight: bold;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        });
        
        $('#bdppayables').val('0.00');
    	$('#bdpdepartmentid').focus();
	});

	function clean(){
		$('#departmentsForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentsForm').find("textarea[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
	function save(){
		if(checkForm(departmentsForm)){		    
			$("img").removeAttr("onclick");
			departmentsForm.action = "insertFranchisee.action";
		    departmentsForm.submit();
		}
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentsForm" name="departmentsForm" method="post" action="">
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
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
							<TD width="9%" height="26" class="table_body">客户编号</TD>
			            	<TD width="24%" class="table_none"><input clean="clean" class="text_input160" id="bdpdepartmentid" name="departmentsPo.bdpdepartmentid" value="" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '客户编码只允许输入整数和字母！'}]">
			            	<span class="STYLE1">自动添加"KH"前缀</span>
			            	</TD>
			            	<TD width="9%" height="26" class="table_body">客户名称</TD>
			            	<TD width="24%" class="table_none"><span class="STYLE1">
			            	  <input clean="clean" class="text_input160" id="bdpdepartmentname" name="departmentsPo.bdpdepartmentname" value="" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '客户名称不能为空！'}]">
			            	  </TD>
			              <TD width="9%" height="26" class="table_body">传真</TD>
			              <TD width="24%" class="table_none"><input clean="clean" class="text_input160" id="bdpfax" name="departmentsPo.bdpfax" value="" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '客户传真格式错误！'}]">
			              <span class="STYLE1">打印在调货单据中</span>
			              </TD>
			             
			            </TR>
			            <TR>
			              <TD height="26" class="table_body">电话</TD>
			              <TD class="table_none">
			              <input clean="clean" class="text_input160" id="bdpphone" name="departmentsPo.bdpphone" value="" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '客户电话格式错误！'}]">
                              <span class="STYLE1">打印在调货单据中</span></TD>
           				  <TD height="26" class="table_body">联系人</TD>
                        	<TD height="26" class="table_none">
                        	<input clean="clean" class="text_input160" id="bdpperson" name="departmentsPo.bdpperson" value="" maxlength="20" >
                        	  <span class="STYLE1">打印在调货单据中</span></TD>
                        	<TD height="26" class="table_body">期初应收金额</TD>
                        	<TD height="26" class="table_none">
                        	 <input clean="clean" class="text_input160" id="bdppayables" name="departmentsPo.bdppayables" value="${departmentsPo.bdppayables}" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请重新填写客户期初应收金额!'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}">
                        	</TD>
			            </TR>
			            <TR>
                        	<TD height="26" class="table_body">地址</TD>
							<TD class="table_none" colspan="5"><input clean="clean" class="text_input200" id="bdpaddress" name="departmentsPo.bdpaddress" value="" maxlength="200" style="width: 500">
                              <span class="STYLE1">打印在调货单据中</span></TD>
			            </TR>
			            <TR>
			            	<TD height="26" class="table_body">备注</TD>
							<TD class="table_none" colspan="5">
                               <textarea clean="clean" id="bdpremark" name="departmentsPo.bdpremark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [1001]}, 'Message' : '备注不能大于1000字！'}]"></textarea>
                            </TD>
			              </TR>
                    </TABLE>

                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
						 	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							  
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
  

