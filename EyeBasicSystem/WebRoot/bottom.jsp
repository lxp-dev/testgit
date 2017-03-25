<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<TITLE>未标题文档</TITLE>
<link href="css/frame/style.css" rel="stylesheet" type="text/css">
</HEAD>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="buttomFrm" name="buttomFrm" action="" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="down_text">
  <tr>
    <td>
    <c:if test="${companyNamePo.fcnLoginShowFooter eq '1' }">
    Powered By 天津鹏升科技有限公司&nbsp;&nbsp;&nbsp;&nbsp;<A 
      href="http://www.pengshengsoft.com/" target=_blank>Http://www.pengshengtj.com</A>
      </c:if>
      </td>
  </tr>
</table>
</form>
</BODY></HTML>
