<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script>

	function init(departmentID,departmentName,departmentType){
	var targeturl="affirmDepartment.action?departmentID="+departmentID+"&departmentName="+EncodeUtf8(departmentName)+"&departmentType="+departmentType;
	newwin=window.open("","",'scrollbars');
	newwin.moveTo(0,0);
	newwin.resizeTo(screen.width,screen.height);
	newwin.location=targeturl;
	window.opener=null;
	window.open("","_self"); 
	window.close();
}
</script>
</head>
  <body onload="init('${departmentID}','${departmentName}','${departmentType}');">
  </body>
</html>
