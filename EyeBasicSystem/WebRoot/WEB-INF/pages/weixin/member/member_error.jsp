<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的资料</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />

<script>
    function insert(){ 
    	location.href="initWeiXinMemberBindInfoUpdate.action?openID="+$('#openID').val();     
    }
    
    function inPersonCenter(){ 
    	location.href="initPersonCenterSel.action?openID="+$('#openID').val();       
    }
</script>

</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="text" value="${openID}" readonly="readonly"/>
<table border="0" cellpadding="0" cellspacing="0" class="butt">
<h>您填写的电话号码已经被绑定，请到我店进行处理！</h>
  <tr onclick="insert();" style="cursor: hand">
    <td class="butt_left" scope="col">&nbsp;</td>
    <td class="butt_midd" scope="col">修改资料</td>
    <td class="butt_right" scope="col">&nbsp;</td>
  </tr>
  <tr onclick="inPersonCenter();" style="cursor: hand">
    <td class="butt_left" scope="col">&nbsp;</td>
    <td class="butt_midd" scope="col">返回个人中心</td>
    <td class="butt_right" scope="col">&nbsp;</td>
  </tr>  
</table>
</body>
</html>

