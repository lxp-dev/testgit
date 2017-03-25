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
	    <span class="page_title">购物车</span>
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
    <div class="autowidth" id="main">
        <form action="#" method="POST" name="check">
        <div class="grey_bg">
            <!--商品列表-->
                <div class="supplier">
					<s:iterator value="mallShoppingCartList" var="po">
						<div class="single_goods">
                            <a href="selectMallGoodsDetail.action?hid=${po.mscsmallid }" class="single_goods_img">
                                <img src="<%=request.getContextPath()%>${po.mscsmallpicurl }"></a>
                            <div class="single_goods_info">
                                <a href="selectMallGoodsDetail.action?hid=${po.mscsmallid }" class="single_goods_name">${po.mscsmallname }</a>
                                <span class="single_goods_cs">
                                	<c:if test="${not empty po.msccolor}">颜色：${po.msccolor }</c:if>&nbsp;
                                	<c:if test="${not empty po.mscspec}">型号：${po.mscspec }</c:if>
                                </span>
                                <span class="single_goods_price">￥${po.mscpricesum }</span>
                                <!-- <span class="single_goods_num">
                                    <p>
                                        <input type="text" size="2" name="590138" value="1" style="border-bottom:1px solid #ED006A; border-left:1px solid #ED006A; border-top:1px solid #ED006A; border-right:1px solid #ED006A; margin-right:10px">&nbsp;&nbsp;<input style="BORDER-BOTTOM: 0px; BORDER-LEFT: 0px; PADDING-LEFT: 6px; WIDTH: 47px; BACKGROUND: url(<%=request.getContextPath()%>/img/mall/bg_btn1.png) no-repeat; HEIGHT: 20px; COLOR: #fff; BORDER-TOP: 0px; BORDER-RIGHT: 0px;CURSOR: hand" type="submit" value="更改">
                                    </p>
                                </span>-->
                                <a href="deleteMallShoppingCartPo.action?hid=${po.mscid }" class="del_goods_button">
                                    <img src="<%=request.getContextPath()%>/img/mall/delet_box.jpg" width="17"></a>
                            </div>
                        </div>
                    </s:iterator>        
                    <!-- <div class="policy_subtotal"><span class="postage_policy">赠送积分总计： <span class="mbs_red">0</span></span><span class="postage_subtotal">商品小计：<span class="mbs_red">￥105.00</span></span></div> -->
                </div>
                <!--supplier-->
            <!--TODO  赠品-->
            <a href="selectMallGoodsList.action" class="shop_ctn">
                <div class="shop_ctn_white mbs_red">继续购物&gt;</div>
            </a>
                <div class="goods_total_balance"><span class="goods_total">商品合计：<span class="mbs_red">￥${priceSum}</span></span>
                <a href="insertMallShoppingOrderPo.action" class="go_balance">去结算 </a>
                </div>
        </div>
        <!--grey_bg-->
</form>  
</div>
</div>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>