<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD><TITLE>-后台管理</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.5726" name=GENERATOR>
<link rel="StyleSheet" href="${ctx}/css/dtree/dtree.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/dtree/dtree.js"></script>
</HEAD>
<BODY bgColor=#9aadcd leftMargin=0 topMargin=0><BR>
<form>
<c:if test="${requestScope.flag == null }">
<div class="dtree">
	<p><a href="javascript: myTree.openAll();">open all</a> | <a href="javascript: myTree.closeAll();">close all</a></p>

	<script type="text/javascript">
		<!--
		myTree = new dTree('myTree');
		myTree.add('0',-1,'我的项目');
		<c:if test="${not empty(list)}">
			<s:iterator value="list">
				myTree.add('${moduleID }','${moduleParentID }','${moduleCname }','${moduleDirectory }','','mainFrame');
			</s:iterator>
		</c:if>
		
		/*myTree.add('S01',0,'Node 1','1');
		myTree.add('S0101','S01','Node 1','1');
		myTree.add('S010101','S0101','Node 1','1');
		myTree.add('S0102','S01','Node 1','1');
		myTree.add('S02',0,'Node 1','1');
		myTree.add('S0201','S02','Node 1','1');
		myTree.add('S0202','S02','Node 1','1');*/
		document.write(myTree);
		//-->
	</script>
  </div>
</c:if>
</form>
</BODY></HTML>
<s:if test="hasActionMessages()">    
	<s:iterator value="actionMessages">    
	    <script language="JavaScript">    
	    	alert("<s:property escape="false"/>");
	    </script>    
	</s:iterator>    
</s:if>  
<s:if test="hasActionErrors()">    
	<s:iterator value="actionErrors">    
		<script language="JavaScript">    
			alert("<s:property escape="false"/>");
		</script>    
	</s:iterator>    
</s:if>    
