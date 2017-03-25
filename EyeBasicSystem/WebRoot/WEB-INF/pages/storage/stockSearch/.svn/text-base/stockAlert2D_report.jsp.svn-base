<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>库存预警查询(二维)</title>
</head>
<script>

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="reportFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>

<iframe id="reportFrame" src="report.action?reportlet=storage_kucunyujingerwei.cpt&__bypagesize__=false&goodsCategoryID=${goodsCategoryID}&supplierID=${supplierID}&brandID=${brandID}&warehouseID=${warehouseID}" width="100%" height="100%">
</iframe>

</DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>