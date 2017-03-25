<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
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

<link href="<%=request.getContextPath()%>/css/mall/header.css" type="text/css" rel="stylesheet"> 	
<link href="<%=request.getContextPath()%>/css/mall/style.css" type="text/css" rel="stylesheet">    	
<link href="<%=request.getContextPath()%>/css/mall/main.css" type="text/css" rel="stylesheet">

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
  <div id="mypay" style="display:none;"></div> 
    <div class="lay_header">
	    <a href="selectUserCenterList.action" class="func_page_tab">
	    	<i class="tab_i">
	        	<img src="<%=request.getContextPath()%>/img/mall/user.jpg">
	    	</i>
	    </a>
	    <span class="page_title">我的账户</span>
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
   <div class="user"> 
    <div class="userM"> 
     <ul class="user_ul"> 
      <li><a href="selectUserCenterOrders.action"><span class="user_s1">我的订单</span></a> </li> 
      <li><a href="selectMallShoppingFavoriteList.action"><span class="user_s5">收藏夹</span> </a> </li> 
      <li><a href="http://www.jiayi9.com/01/m/user_center.asp"><span class="user_s8">会员资料</span> </a> </li> 
     </ul> 
    </div> 
   </div> 
  </div>
</BODY>
</HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>