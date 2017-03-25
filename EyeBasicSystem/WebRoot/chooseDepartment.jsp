<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>选取部门</title>
    <script type="text/javascript">
		function exitSys(){
			location.href='loginOut.action';
		}
		 
        function affirmDepartment(departmentID,departmentName,departmentType){
            $('#departmentID').val(departmentID);
            $('#departmentName').val(departmentName);
            $('#departmentType').val(departmentType);
            
            affirmDepartmentFrm.action = "affirmDepartment.action";
            affirmDepartmentFrm.submit();
        }
    </script>
  </head>
  
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>

<form name="affirmDepartmentFrm" id="affirmDepartmentFrm" action="" method="post">
<input type="hidden" id="departmentID" name="departmentID" >
<input type="hidden" id="departmentName" name="departmentName" >
<input type="hidden" id="departmentType" name="departmentType" >
</br></br>
<table width="99%" border="0" align="left" cellpadding="0" cellspacing="0">
  <tr>
    <td> 
      <table width="780" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
      <tr>
        <td colspan="2" style="background-image: url(${ctx}/${companyNamePo.fcndepgroundPath});" width="780" height="102">&nbsp;&nbsp;&nbsp;
         <span id="fcnName" style="font-family: 微软雅黑;font-size: 35;color: white;font: bold">${companyNamePo.fcnName}</span>
        </td>
      </tr>
      <tr> 
        <td style="background-image: url(img/login/P3.jpg)" width="780" valign="top">                    
             <table >               
                <tr valign="top">
                    <td style="padding-left: 100px;padding-top: 20px">
                        <span style="font-size: 18">${loginPersonName}，您好。请选择需要登录的部门，或重新登录！</span>
                    </td>
                    <td>&nbsp;</td>
                </tr>    
                 <tr valign="top">
                    <td colspan="2" height="20px">&nbsp;</td>
                </tr>           
            </table>
            <table align="center" > 
   
   <c:if test="${rowCount == ''}">
        <c:set value="5" var="rowCount" />       <!-- 行数 -->
   </c:if>
   <c:if test="${rowCount != ''}">
        <c:set value="${rowCount}" var="rowCount" />       <!-- 行数 -->
   </c:if>
            
             <c:set value="3" var="columnCount" />    <!-- 列数 -->
             <c:set value="0" var="currentIndex" />   <!-- 索引变化量 -->
                     
              <c:forEach begin="1" end="${rowCount}" step="1" >
              <c:set value="1" var="currentCount" />   <!-- 当前行数 -->
                <tr style="padding-left: 90px;" >               
                  <c:forEach items="${departmentList}" var="departmentInfo" varStatus="status">
                    <c:if test="${status.index >= currentIndex && currentCount <= columnCount }" >
                    <c:choose>
                    	<c:when test="${departmentInfo.bdpisclosed=='0'}">
	                    	<td width="200" onclick="affirmDepartment('${departmentInfo.bdpdepartmentid}','${departmentInfo.bdpdepartmentname}','${departmentInfo.bdptype}')">
	                        	<span style="cursor: hand;font-size: 18;">${ departmentInfo.bdpdepartmentname }</span>
	                   		</td>
                    	</c:when>
                    	<c:when test="${departmentInfo.bdpisclosed=='1'}">
	                    	<td width="200" >
	                        	<span style="cursor: hand;font-size: 18;">${ departmentInfo.bdpdepartmentname }【已关闭】</span>
	                   		</td>
                    	</c:when>
                    </c:choose>
                    <c:set value="${currentCount + 1}" var="currentCount" />
                    </c:if>
                  </c:forEach>  
                  <c:set value="${currentIndex + 3}" var="currentIndex" />  
                </tr>
               </c:forEach>       
            </table>
        </td>
      </tr>      
      <tr>
        <td colspan="2" style="background-image: url(img/login/P3.jpg);padding-right: 30" width="780" height="80" align="right">
            <img src="img/login/login.jpg" onclick="javascript:exitSys();" style="cursor: hand">
        </td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
