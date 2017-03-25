<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门店列表</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<script>
	function link(id){
		departmentstForm.action = "initUserDepartmentsDetail.action?id="+id;
		departmentstForm.submit();
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
</script>
<body class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<div class="title"><a href="#" onclick="getParam()">分店信息</a></div>
<table width="100%">
<tr>
	<td align="center">
		<table width="90%" border="0" cellspacing="1" cellpadding="0">      
       <s:iterator value="departmentsList" status="count">      
         <s:if test="#count.odd||#cout.first">      
              <tr align="center">          
         </s:if>
       <td>
       	<table height="100%" width="100%">
       		<tr align="left" valign="top">
       			<TD valign="top" width="50%">
       			<c:choose>
       				<c:when test="${bdppicurl ne ''}">
       					<img src="${ctx }${bdppicurl}" width="150" height="100" onclick="link('${bdpdepartmentid}')" >
       				</c:when>
       				<c:otherwise>
       					<img src="${ctx }/weixin/images/departmentDefault.png" width="150" height="100">
       				</c:otherwise>
       			</c:choose>
       			</TD>
       		</tr>
			<tr>
       			<TD height="15" align="left">${bdpdepartmentname}</TD>
       		</tr>
       		<tr>
       			<TD height="30" align="left" valign="top">
       				<c:if test="${!empty bdpsdistance}">
       					距离您${bdpsdistance}公里
       				</c:if>
       			</TD>
       		</tr>          		
       		<tr>
       			<TD height="15" align="left"><a href="tel:${bdpphone}">${bdpphone}</a></TD>
       		</tr>
       		<tr>
       			<TD height="30" align="left" valign="top">${bdpaddress}</TD>
       		</tr>     
       	</table>
       </td>
        <s:if test="#count.even||#count.last">      
            </tr>          
        </s:if>      
        </s:iterator>      
</table>
	</td>
</tr>
</table>
</form>
</body></html>