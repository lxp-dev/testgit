<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微商城</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
</head>
<link href="<%=request.getContextPath()%>/css/mall/style.css" type="text/css" rel="stylesheet">    	
<script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/common.js"></script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
    <div class="lay_header">
	    <a href="selectUserCenterList.action" class="func_page_tab">
	    	<i class="tab_i">
	        	<img src="<%=request.getContextPath()%>/img/mall/user.jpg">
	    	</i>
	    </a>
	    <span class="page_title">商品详情</span>
	    <a href="selectMallGoodsList.action" class="func_page_tab">
	    	<i class="tab_i">
	    		<img src="<%=request.getContextPath()%>/img/mall/mainpage.png">
	    	</i>
	    </a>
	    <a href="selectMallShoppingCartList.action" class="func_page_tab_last" rel="nofollow">
	    	<i class="last_tab_i">
	    		<img src="<%=request.getContextPath()%>/img/mall/gouwuche1.png">
	   		</i> 
	   	</a>
    </div>
    <div class="blockwidth" id="main">
    <div class="content">
        ${mallTypeSmallPo.mtscontent}
    </div>
    </div>
</BODY>
</HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>