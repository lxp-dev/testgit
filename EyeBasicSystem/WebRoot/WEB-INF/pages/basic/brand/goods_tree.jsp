<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/extjs/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/extjs/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/extjs/ext-all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/extjs/goods_tree.js"></script> 
<script type="text/javascript">

	function test()
	{
		refreNode();
	}
	function testParent()
	{
		refreParentNode();
	}
	
</script>
</head>

<body>
<form>
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="hrefTarget" name="hrefTarget" value="${requestScope.hrefTarget}">
<input type="hidden" id="isClosed" name="isClosed" value="${requestScope.isClosed}">
<table width="100%" height="100%" border=0>
<tr>
<td width="100%">
<div  align="left" id="tree-div" style="overflow:auto; border:1px solid #c3daf9;width: 100%" ></div>

</td>
<td>

</td>
</tr>
</table>
</form>
</body>
</html>