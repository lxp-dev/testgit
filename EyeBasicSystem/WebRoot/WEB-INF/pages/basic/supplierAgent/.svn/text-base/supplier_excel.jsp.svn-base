<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商批量导入</title>
</head>
<script>

	function excel(){
		var upload = document.getElementById("upload").value;
		if(upload == ""){
			alert("供应商Excel文件不能为空!!"); 
			return false;
		}else if(/\.xls^/.test(upload)){
			alert("请导入供应商.xls文件!!");
			return false;
		}
		$("img").removeAttr("onclick");
		supplierForm.action = "insertSupplierAgentExcel.action";
		supplierForm.submit();
      }  
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierForm" method="post" action="" enctype="multipart/form-data">

<input type="hidden" name="type" id="type" value="" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD> 
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="20%" height="30" class="table_body">供应商Excel文件</TD>
			               	<TD width="85%" height="30" align="left" class="table_none" >
						   	<input type="file" name="file" id="upload"/>
						    </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><input id="button1" icon='icon-save' type='button' value='导入' onClick="excel();">
                          </TD>
						  </TR>
						  
                      </TBODY>
                    </TABLE>
                    <font color="red">
                    	<ul>
                    		<li>填写Excel模板注意事项：</li>
                    		<li>系统提供导入供应商Excel模板所有列不能为空</li>
                    		<li>供应商代码必须为2位数字</li>
                    		<li>供应商简称不能超过30个字</li>
                    		<li>联系人不能超过16个字</li>
                    		<li>电话长度不能超过10数字</li>
                    		<li>传真不能超过10个字</li>
                    		<li>地址不能超过50个字</li>
                    		<li>备注不能超过200个字或不填</li>
                    		<li>类别不能超过50个字</li>
                    		<li>请慎重填写供应商信息，填写后仔细检查</li>
                    	</ul>
                    </font>
                  </DIV>
                </DIV>
                </TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
	
	
	




