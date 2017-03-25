<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<SCRIPT src="<%=basePath %>js/pengsheng-checkform.js" type=text/javascript charset=utf-8></SCRIPT>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>

    <form id="fTest" name="fTest">
    	<table width="100%">
    		<tr>
    			<td>中文字符：<input type="text" id="custName" name="custName1" value="中文11" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.CN, 'Message' : '中文字符！'}]"/></td>
    		</tr>
    		<tr>	
    			<td>全中文字符串：<input type="text" id="custName" name="custName2" value="全中文字符串" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.ALL_CN, 'Message' : '全中文字符串！'}]"/></td>
    		</tr>
    		<tr>	
    			<td>不包含中文：<input type="text" id="custName" name="custName3" value="22" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '不包含中文！'}]"/></td>
    		</tr>
    		<tr>
    			<td>整数：<input type="text" id="custName" name="custName4" value="30" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '整数！'}]"/></td>
    		</tr>
    		<tr>
    			<td>不为空：<input type="text" id="custName" name="custName5" value="30" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '不为空！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>邮件：<input type="text" id="custName" name="custName6" value="xx@msn.com" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.email, 'Message' : '邮件！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>浮点数：<input type="text" id="custName" name="custName7" value="30.00" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '浮点数！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>电话：<input type="text" id="custName" name="custName8" value="77777777" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '电话！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>身份证：<input type="text" id="custName" name="custName9" value="1729291919191919" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.IdentityCard, 'Message' : '身份证！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>验证日期格式 yyyy-MM-dd：<input type="text" id="custName" name="custName11" value="2009-01-01" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.DateFormat, 'Message' : '验证日期格式 yyyy-MM-dd！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>验证时间格式 12:12:00：<input type="text" id="custName" name="custName12" value="12:12:00" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.TimeFormat, 'Message' : '验证时间格式 12:12:00！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>验证长日期 yyyy-MM-dd 12:12:00：<input type="text" id="custName" name="custName13" value="2009-01-01 12:12:00" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Message' : '验证长日期 yyyy-MM-dd 12:12:00！'}]"/></td>
    		</tr>
    		<tr>   			
    				
    			<td>等于字符串长度：<input type="text" id="custName" name="custName14" value="88888888" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.EQLength, Params : [8]}, 'Message' : '等于长度！'}]"/></td>

    		</tr>
    		<tr/>   			
    				
    			<td>大于字符串长度：<input type="text" id="custName" name="custName15" value="llllllllll" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.ThanLength, Params : [8]}, 'Message' : '大于长度！'}]"/></td>

    		</tr>
    		<tr/>   			
    				
    			<td>小于字符串长度：<input type="text" id="custName" name="custName16" value="555" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [8]}, 'Message' : '小于长度！'}]"/></td>

    		</tr>
    		
    		
    		<tr>
    			<td>中文字符或允许空：<input type="text" id="custName" name="custName1" value="中文11" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.CNORNULL, 'Message' : '中文字符或允许空！'}]"/></td>
    		</tr>
    		<tr>	
    			<td>全中文字符串或允许空：<input type="text" id="custName" name="custName2" value="全中文字符串" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.ALL_CNORNULL, 'Message' : '全中文字符串或允许空！'}]"/></td>
    		</tr>
    		<tr>	
    			<td>不包含中文或允许空：<input type="text" id="custName" name="custName3" value="22" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.NO_CNORNULL, 'Message' : '不包含中文或允许空！'}]"/></td>
    		</tr>
    		
    		<tr>
    			<td>允许空或整形：<input type="text" id="custName" name="custName4" value="30" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '允许空或整形！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>邮件或允许空：<input type="text" id="custName" name="custName6" value="xx@msn.com" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.emailORNULL, 'Message' : '邮件或允许空！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>浮点数或允许空：<input type="text" id="custName" name="custName7" value="30.00" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '浮点数或允许空！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>电话或允许空：<input type="text" id="custName" name="custName8" value="77777777" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '电话或允许空！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>身份证或允许空：<input type="text" id="custName" name="custName9" value="1729291919191919" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.IdentityCardORNULL, 'Message' : '身份证或允许空！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>验证日期格式或允许空 yyyy-MM-dd：<input type="text" id="custName" name="custName11" value="2009-01-01" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.DateFormatORNULL, 'Message' : '验证日期格式或允许空 yyyy-MM-dd！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>验证时间格式或允许空 12:12:00：<input type="text" id="custName" name="custName12" value="12:12:00" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.TimeFormatORNULL, 'Message' : '验证时间格式或允许空 12:12:00！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>验证长日期或允许空 yyyy-MM-dd 12:12:00：<input type="text" id="custName" name="custName13" value="2009-01-01 12:12:00" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormatORNULL, 'Message' : '验证长日期或允许空 yyyy-MM-dd 12:12:00！'}]"/></td>
    		</tr>
    		<tr>   			
    				
    			<td>等于字符串长度或允许空：<input type="text" id="custName" name="custName14" value="88888888" 
    				validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.EQLengthORNULL, Params : [8]}, 'Message' : '等于长度或允许空！'}]"/></td>

    		</tr>
    		<tr/>   			
    				
    			<td>大于字符串长度或允许空：<input type="text" id="custName" name="custName15" value="llllllllll" 
    				validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.ThanLengthORNULL, Params : [8]}, 'Message' : '大于长度或允许空！'}]"/></td>

    		</tr>
    		<tr/>   			
    				
    			<td>小于字符串长度或允许空：<input type="text" id="custName" name="custName16" value="555" 
    				validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [8]}, 'Message' : '小于长度或允许空！'}]"/></td>

    		</tr>
    		<tr/>   			
    				
    			<td>小数点位数限制：<input type="text" id="custName" name="custName16" value="555.00" 
    				validate="[{'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '小数点位数长度不符！'}]"/></td>

    		</tr>
    		<tr>		
    			<td>只允许输入整数和字母：<input type="text" id="custName" name="custName6" value="xx@msn.com" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '只允许输入整数和字母！'}]"/></td>
    		</tr>
    		<tr>		
    			<td>只允许输入整数和字母或为空：<input type="text" id="custName" name="custName6" value="xx@msn.com" 
    				validate="[{'Type' : Type.String, 'Formula' : Formula.WordNull, 'Message' : '只允许输入整数和字母或为空！'}]"/></td>
    		</tr>
    		
    		
    	</table>
    <input type="button" onclick="aa()" value="验证" />
    </form>
  </body>
  <script type="text/javascript">

function aa(){
		checkForm(document.all.fTest);
}
  </script>
</html>
