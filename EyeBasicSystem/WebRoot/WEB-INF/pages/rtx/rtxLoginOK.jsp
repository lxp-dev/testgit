<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
    <script type="text/javascript">
		
        function affirmDepartment(departmentID,personID,departmentName,departmentType){
            window.open("initDepartment.action?departmentID="+departmentID+"&personID="+personID+"&departmentName="+EncodeUtf8(departmentName)+"&departmentType="+departmentType);
        }
    </script>
</head>
  <body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
    ${loginPersonName}&nbsp;&nbsp;您好：欢迎使用EIMS系统
     <c:forEach items="${departmentList}" var="departmentInfo" varStatus="status">
     	<p>
        <c:choose>
        	<c:when test="${departmentInfo.bdpisclosed=='0'}">
         	<a href onclick="affirmDepartment('${departmentInfo.bdpdepartmentid}','${personID}','${departmentInfo.bdpdepartmentname}','${departmentInfo.bdptype}')">
             	${ departmentInfo.bdpdepartmentname }
        		</a>
        	</c:when>
        	<c:when test="${departmentInfo.bdpisclosed=='1'}">
<!--             	${ departmentInfo.bdpdepartmentname }【已关闭】-->
        	</c:when>
        </c:choose>
        </p>
     </c:forEach>
  </body>
</html>
