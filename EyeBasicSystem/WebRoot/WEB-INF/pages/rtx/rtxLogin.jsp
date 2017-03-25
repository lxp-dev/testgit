<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="rtx.*,java.net.*,java.io.*;"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<script LANGUAGE="JavaScript">
<!--
function init()
{ 

    try
    {
           var objKernalRoot = RTXAX.GetObject("KernalRoot");
           var objRtcData = objKernalRoot.Sign;
           var strAccount = objKernalRoot.Account;
           var strSgin = objRtcData.GetString("Sign");
           
			form1.user.value = strAccount;
			form1.sign.value = strSgin;
			form1.submit();
			
   }
	catch(e)
	{
	}
}
//-->
</script>
  <body onload="javascript:init();">
        <OBJECT classid=clsid:5EEEA87D-160E-4A2D-8427-B6C333FEDA4D id=RTXAX></OBJECT>
          <form name="form1" method="get" action="rtxLogin.action">
      <input type="hidden" name="user">  
      <input type="hidden" name="sign"> 
  </form>
    </body>
</html>