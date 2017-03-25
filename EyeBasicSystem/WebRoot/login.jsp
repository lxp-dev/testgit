<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>眼视光信息管理系统</title>
</head>
<script>
	function login(){
		if(document.all.userID.value==""){
			alert("请输入工号!");
			return false;
		}else if(document.all.userPassword.value==""){
			alert("请输入密码!");
			return false;
		}else{
			loginForm.action = "loginSearch.action";
			loginForm.submit();
		}
	}
</script>
<body >
	<form name="loginForm" method="post" action="" onsubmit="return login();">
<br/><br/><br/><br/><br/>
<table width="99%" border="0" align="left" cellpadding="0" cellspacing="0">
  <tr>
    <td> 
      <table width="780" height="500%" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
      <tr>
        <td colspan="7"><img src="img/login/login-pms-01_01.gif" width="780" height="102" title=""></td>
      </tr>
      <tr>
        <td><img src="img/login/login-pms-01_02.gif" width="237" height="96" title=""></td>
        <td colspan="5"><img src="img/login/login-pms-01_03.gif" width="308" height="96" title=""></td>
        <td><img src="img/login/login-pms-01_04.gif" width="235" height="96" title=""></td>
      </tr>
      <tr>
        <td rowspan="3"><img src="img/login/login-pms-01_05.gif" width="237" height="139" title=""></td>
        <td colspan="5"><table align="center">
			
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userID" id="userID"  value="" style="width:130px" /></td>
			</tr>
			<tr>
				<td>密　码:</td>
				<td><input type="password" style="width:130px" name="userPassword" id="userPassword"  value="" /></td>
			</tr>
		</table></td>
        <td rowspan="3"><img src="img/login/login-pms-01_07.gif" width="235" height="139" title=""></td>
      </tr>
      <tr>
        <td rowspan="2"><img src="img/login/login-pms-01_08.gif" width="56" height="41" title=""></td>
        <td><input type="image" src="img/login/button02.jpg" />
        </td>
        <td rowspan="2"><img src="img/login/login-pms-01_10.gif" width="14" height="41" title=""></td>
        <td><img src="img/login/button01.jpg" width="76" style="cursor: hand;" height="23" title="" onclick="loginForm.reset();"></td>
        <td rowspan="2"><img src="img/login/login-pms-01_12.gif" width="86" height="41" title=""></td>
      </tr>
      <tr>
        <td><img src="img/login/login-pms-01_13.gif" width="76" height="18" title=""></td>
        <td><img src="img/login/login-pms-01_14.gif" width="76" height="18" title=""></td>
      </tr>
      <tr>
        <td><img src="img/login/login-pms-01_15.gif" width="237" height="70" title=""></td>
        <td colspan="5"><img src="img/login/login-pms-01_16.gif" width="308" height="70" title=""></td>
        <td><img src="img/login/login-pms-01_17.gif" width="235" height="70" title=""></td>
      </tr>
      <tr>
        <td colspan="7"><img src="img/login/login-pms-01_18.gif" width="780" height="93" title=""></td>
      </tr>
    </table></td>
  </tr>
</table>
	</form>
</body>
</html>
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