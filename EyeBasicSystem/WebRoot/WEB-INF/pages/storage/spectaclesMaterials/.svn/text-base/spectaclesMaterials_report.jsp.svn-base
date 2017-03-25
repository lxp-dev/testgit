<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜管理</title>
</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="reportFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="billID" name="billID" value="${billID}">
<DIV>

<iframe id="reportFrame" src="report.action?reportlet=${fittingTemplateTypePo.bftfilename}&__bypagesize__=false&billID=${billID}&printPerson=${printPerson}&printserialnumber=${printserialnumber}" width="100%" height="100%">
</iframe>
</DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>