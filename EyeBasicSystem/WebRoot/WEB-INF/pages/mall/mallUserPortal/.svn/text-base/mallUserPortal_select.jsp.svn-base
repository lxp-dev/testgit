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
    
    <link href="<%=request.getContextPath()%>/css/mall/header.css" type="text/css" rel="stylesheet"> 	
	<link href="<%=request.getContextPath()%>/css/mall/style.css" type="text/css" rel="stylesheet">    	
	<link href="<%=request.getContextPath()%>/css/mall/main.css" type="text/css" rel="stylesheet">
</head>
<style type="text/css">
	.cms_a{width:46%; float:left; margin-left:2.3%; border:1px solid #D9D9D9; background:#FFF; display:block; margin-top:2.3%;}
	.cms_title{text-overflow:ellipsis; overflow:hidden; white-space:nowrap; width:90%; font-size:12px; margin: 0 auto; padding-top:3%; color:#373737;}
	.cms_price{text-overflow:ellipsis; overflow:hidden; white-space:nowrap; width:90%; font-size:12px; margin: 0 auto; padding-top:3%;padding-bottom:3%; color:#373737;}
	.cms_saleprice{font-size:14px; color:#D60074; font-weight:bold;}
	.cms_cprice{font-size:10px; text-decoration:line-through; color:#999;padding-left:3px;}
</style>	
<SCRIPT type=text/javascript>
	$(document).ready(function(){
		$(this).scroll(function(){
			if($(document).scrollTop() >= $(".topic_menu").offset().top){
				$("#fix_menu").show();
			} else{
				$("#fix_menu").hide();
			}
		});
	});
</SCRIPT>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/common.js"></script>
<link href="<%=request.getContextPath()%>/css/mall/main.css" type="text/css" rel="stylesheet">
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<div class="autowidth" id="main">
    <div class="lay_header">
	    <a href="selectUserCenterList.action" class="func_page_tab">
	    	<i class="tab_i">
	        	<img src="<%=request.getContextPath()%>/img/mall/user.jpg">
	    	</i>
	    </a>
	    <span class="page_title">商品列表</span>
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
<div class="content" style="max-width:640px; min-width:320px;">   
<div class="go_top" style="right: 17.00318809776833px; bottom: 17.00318809776833px; display: block; ">
<a href="selectMallShoppingCartList.action"><img src="<%=request.getContextPath()%>/img/mall/gouwuche.png" style="width: 50px; "></a>
<A href="#"><IMG style="WIDTH: 50px" src="<%=request.getContextPath()%>/img/mall/totop.png"></A>
</div>
<DIV style="PADDING-BOTTOM: 0px"></DIV>
<STYLE type=text/css>.topic_menu DIV {
	BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; PADDING-BOTTOM: 6px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; DISPLAY: block; FLOAT: left; FONT-SIZE: 16px; BORDER-TOP: #ccc 1px solid; PADDING-TOP: 6px
}
.topic_menu SPAN {
	BORDER-BOTTOM: #fff 2px solid; LINE-HEIGHT: 25px; DISPLAY: inline-block; HEIGHT: 25px; COLOR: #000; CURSOR: pointer
}
#select_span SPAN {
	BORDER-BOTTOM: #f06 2px solid; LINE-HEIGHT: 25px; DISPLAY: inline-block; HEIGHT: 25px; COLOR: #f06
}
</STYLE>
<c:if test="${not empty(mallTypeSmallList)}">	
<s:iterator value="mallTypeSmallList" var="po">
<a class="cms_a" href="selectMallGoodsDetail.action?hid=${po.mtsid}"><img style="width: 100%; display: inline;" src="<%=request.getContextPath()%>${po.mtspicurl}"><div class="cms_title">${po.mtsname}</div><div class="cms_price"><span class="cms_saleprice">￥${po.mtspricenew}</span><span class="cms_cprice">￥${po.mtspriceold}</span></div></a>
</s:iterator>
</c:if>
</div>
</div>
</div>
</div>
</BODY>
</HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>