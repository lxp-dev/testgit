<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>短信模板维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
        var text=parent.document.noteTemplateForm.birthdaycontent.value;
        text=text.replace(/%顾客姓名%/ig,"孙鹏");
        text=text.replace(/%性别%/ig,"先生");
        text=text.replace(/%配镜单号%/ig,"<font color='#0000ff'><u>X60010120131010182523</u></font>");
        text=text.replace(/%反馈内容%/ig,"反馈内容我要投诉 ");
        text=text.replace(/%销售门店%/ig,"中心店");
        text=text.replace(/%抛弃类型%/ig,"月抛");
        text=text.replace(/%商品名称%/ig,"CM-836");
        text=text.replace(/%门店电话%/ig,"<font color='#0000ff'><u>022-87896952</u></font>");
        text=text.replace(/%验光日期%/ig,"2013-08-01");
        text=text.replace(/%复验日期%/ig,"2013-09-01");
        text=text.replace(/%取镜门店%/ig,"中心店");
        text=text.replace(/%取镜门店电话%/ig,"<font color='#0000ff'><u>022-87896952</u></font>");
        text=text.replace(/%实收金额%/ig,"<font color='#0000ff'><u>1020.00</u></font>");
        text=text.replace(/%获取积分%/ig,"<font color='#0000ff'><u>102</u></font>");
        document.getElementById('previewtext').innerHTML=text;
        
    	//alert(text);
	});

	function del(){
		$('#submitButton').removeAttr("onclick"); 
		noteTemplateForm.action = "noteTemplateDelete.action";
		noteTemplateForm.submit();
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="noteTemplateForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="noteTemplatePo.bntid" value="${noteTemplatePo.bntid}">
<input type="hidden" name="noteTemplatePo.bntname" value="${noteTemplatePo.bntname}">
<input type="hidden" name="noteTemplatePo.bntcontent" value="${noteTemplatePo.bntcontent}">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<table border="0" width="100%" height="100%">
<tr><td align="center" vAlign="middle">
<table width="200"  border=0 align=center cellpadding=1 cellspacing=1 id="title1">
                      <TBODY>
                      <TR>
						   <TD  height="389" align="center" valign="middle" background="${ctx}/img/iphone.jpg">						   
						   <table width="90%" height="220" border="0">
						       <tr align="center" valign="top"><td align="left">
						         <label id="previewtext" ></label></td></tr></table></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
</td></tr>
</table>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>