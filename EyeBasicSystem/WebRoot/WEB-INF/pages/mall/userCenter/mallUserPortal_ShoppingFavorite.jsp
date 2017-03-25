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
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/common.js"></script> 
    
    <link href="<%=request.getContextPath()%>/css/mall/header.css" type="text/css" rel="stylesheet">    
    <link href="<%=request.getContextPath()%>/css/mall/style.css" type="text/css" rel="stylesheet">    	
	<link href="<%=request.getContextPath()%>/css/mall/main.css" type="text/css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/css/mall/shop_pcs.css" type="text/css" rel="stylesheet">
</head>

<body>
  <div class="lay_header">        
   <a href="selectUserCenterList.action" class="func_page_tab">
   	<i class="tab_i">
       	<img src="<%=request.getContextPath()%>/img/mall/user.jpg">
   	</i>
   </a>
   <span class="page_title">我的收藏</span>
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
   <div class="content2 posit"> 
    <div class="px_list2">
    <s:iterator value="mallShoppingFavoriteList" var="po">
     <dl> 
      <dt>
       <a href="selectMallGoodsDetail.action?hid=${po.msfsmallid }"> <img src="<%=request.getContextPath()%>${po.msfsmallpicurl }" /></a> 
      </dt> 
      <dd> 
       <p> <a href="selectMallGoodsDetail.action?hid=${po.msfsmallid }">${po.msfsmallname }</a></p> 
       <p> <span>￥${po.msfpricesum }</span></p> 
       <a href="deleteMallShoppingFavoritePo.action?hid=${po.msfid }">删除</a>
       <p></p> 
      </dd> 
     </dl>
    </s:iterator>  
    </div> 
   </div> 
  </div>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>