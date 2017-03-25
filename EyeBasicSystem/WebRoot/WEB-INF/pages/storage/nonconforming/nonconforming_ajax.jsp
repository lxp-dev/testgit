<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:if test="${not empty(nonconformingProductMinList)}">
	<response>
	<s:iterator value="nonconformingProductMinList">
		<res>${fnpid}|${fnpcontent}</res>
	</s:iterator>
	</response>
</c:if>    
	<response>	
		<res>4028806926732cfc0126732e71050002|现象1</res>	
		<res>402880692673973f012673ba3de60000|现象2.2</res>	
		<res>402880692673973f012673ba68bf0001|现象3</res>	
	</response>
