<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户服务协议</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>
    function insert(){ 
    	location.href="initWeiXinMemberBindInfoUpdate.action?openID="+$('#openID').val();     
    }
    
    function inPersonCenter(){ 
    	location.href="initPersonCenterSel.action?openID="+$('#openID').val();       
    }

    function agreement(){ 
    	location.href="initWeiXinMemberBindSel.action?tjrPhone="+$('#tjrPhone').val()+"&toUserName="+$('#toUserName').val()+"&input1="+ $('#input1').val() +"&checkCode="+ $('#checkCode').val() +"&memberPhone="+ $('#memberPhone').val() +"&openID="+$('#openID').val();             
    } 
</script>
</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<input name="input1" id="input1" type="hidden" value="${input1}" readonly="readonly"/>
<input name="checkCode" id="checkCode" type="hidden" value="${checkCode}" readonly="readonly"/>
<input name="memberPhone" id="memberPhone" type="hidden" value="${memberPhone}" readonly="readonly"/>
<input name="toUserName" id="toUserName" type="hidden" value="${toUserName}" readonly="readonly"/>
<input name="tjrPhone" id="tjrPhone" type="hidden" value="${tjrPhone}" readonly="readonly"/>

<body class="lv_bg">
	<div class="loading"></div>
	<div class="xf_canting xf_panle lv_bg">
		<!-- 用户服务协议 -->
		<div class="xq">
			<div class="yscont">
					<span class="ystb"></span>
				${weiXinCmsContentPo.wcmsccontent}
				<div class="ysxy">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="ysan" type="button" value=" 继续 " onclick="agreement();"/>  
				</div>
			</div>

			<!-- 用户服务协议结束 -->
			<!-- 用户服务协议背景 -->
			<div class="sp4bg"></div>
			<!-- 用户服务协议结束 -->

		</div>
</body>
</html>