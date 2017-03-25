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
<style type="text/css">
	.blockwidth{
	width:auto;
	min-width:320px;
	max-width:640px;
	}
	.inf_one,.inf_three{
	width:auto;
	}
	.inf_one h1{
	line-height:28px;
	}
	.inf_one ul li{
	font-size:22px;
	}
	.inf_one ul{
	height:30px;
	}
	.inf_one h4 {
	    line-height: 20px;
	}
	.inf_one ul li:first-child{
	width:auto;
	}
	.inf_one ul li:nth-child(2){
	width:auto;
	padding-left:10px;
	font-size:14px;
	color:#6A6A6A;
	}
	.content div:first-child{
	display:none;
	}
	.homeFouce div:first-child{
	display:block;
	}
	.shopAnimate{
	display:none;
	}
	.inf_two .color .spanColor{
	display:block;
	}
	.inf_one .pj {
	    border-bottom: 1px dotted #acacac;
	    border-top: 1px dotted #acacac;
	    margin: 10px 0 0;
	    padding: 8px 0;
	}
	.inf_two{
	padding-top:10px;
	}
	.inf_one h4:nth-child(4):before{
	content:"";
	}
	.inf_two .color p.sel{background:url(<%=request.getContextPath()%>/img/mall/color_bg.jpg) no-repeat bottom right;border:solid 1px #E60065;}
	.inf_two .size p.sel{background:url(<%=request.getContextPath()%>/img/mall/color_bg.jpg) no-repeat bottom right;border:solid 1px #E60065;}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/jquery-1.7.1.min.js"></script>	

<link href="<%=request.getContextPath()%>/css/mall/header.css" type="text/css" rel="stylesheet"> 	
<link href="<%=request.getContextPath()%>/css/mall/style.css" type="text/css" rel="stylesheet">    	
<link href="<%=request.getContextPath()%>/css/mall/main.css" type="text/css" rel="stylesheet">
<script>	
	function ChooseThisSize($this,str) {
	    $(".size p").removeAttr("class");
	    $($this).attr("class", "sel");
	    document.getElementById("mscspec").value=str;
	}

	function ChooseThisColor($this,str) {
	    $(".color p").removeAttr("class");
	    $($this).attr("class", "sel");
	    document.getElementById("msccolor").value=str;
	}
	
	function save(){
		if("${mallTypeSmallPo.mtscolor}"!="" && document.getElementById("msccolor").value==""){
			alert("请选择颜色！");
		}else if("${mallTypeSmallPo.mtsspec}"!="" && document.getElementById("mscspec").value==""){
			alert("请选择型号！");
		}else{
			$("img").removeAttr("onclick");   
			goodsDetailForm.action = "insertMallShoppingCartPo.action";
			goodsDetailForm.submit();
		}
	}
</script>
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
    <form name="goodsDetailForm" method="post" action="">
    <div class="blockwidth" id="main">
    <div class="content">
        <div style="padding: 0px 10px 0px;text-overflow:ellipsis;"><a href="#">首页</a> &gt; ${mallTypeSmallPo.mtsname}</div>
        <!--滚动效果-->
        <div class="homeFouce" id="homeFouce" style="height: 355.55555555555554px; ">
            <div class="homeList" style="height: 355.55555555555554px; left: 0px; ">
                <ul class="homeImg" style="height: 355.55555555555554px; margin-left: 142.22222222222223px; width: 724px; left: -360px; ">
                <s:iterator value="mallTypeSmallPicList" var="mallTypeSmallPicPo">
                	<li style="left: 0px; "><img src="<%=request.getContextPath()%>${mallTypeSmallPicPo.mtsppicUrl}" width="125" height="125" style="width: 355.55555555555554px; height: 355.55555555555554px; "></li>
                </s:iterator>
                </ul>
                <div class="leftmask" style="height: 355.55555555555554px; width: 142.22222222222223px; display: block; ">
                </div>
                <div class="rightmask" style="height: 355.55555555555554px; width: 142.22222222222223px; display: none; ">
                </div>
            </div>
        </div>
        <!--产品信息-->
        <div class="inf_one">
            <h1 style="">${mallTypeSmallPo.mtsname}
            <input type="hidden" id="mscsmallid" name="mallShoppingCartPo.mscsmallid" value="${mallTypeSmallPo.mtsid }"/>
            <input type="hidden" id="mscopenid" name="mallShoppingCartPo.mscopenid" value="${openID }"/>
            <input type="hidden" id="mscpricesum" name="mallShoppingCartPo.mscpricesum" value="${mallTypeSmallPo.mtspricenew }"/>
            <input type="hidden" id="msccount" name="mallShoppingCartPo.msccount" value="1"/>
            <input type="text" id="mscspec" name="mallShoppingCartPo.mscspec" value=""/>
            <input type="text" id="msccolor" name="mallShoppingCartPo.msccolor" value=""/>
            </h1>
            <ul>
                <!--售价-->
                <li style="color: #e50065">￥${mallTypeSmallPo.mtspricenew}</li>
                <!--原价-->
                <li><del>￥${mallTypeSmallPo.mtspriceold}</del></li>
            </ul>
			<a href="#"><h4>专区：${mallTypeSmallPo.mtsareaname}</h4></a>
			<a href="#"><h4>品种：${mallTypeSmallPo.mtsbrandname}</h4></a>
            <h4><h4>库存数：${mallTypeSmallPo.mtsstockcount}&nbsp;&nbsp;已销售：${mallTypeSmallPo.mtssalecount}</h4>
            <p class="pj">
                <!-- <span>用户评分：
                <img src="<%=request.getContextPath()%>/img/mall/xing.png" width="14" height="15" align="absmiddle" border="0">
                </span> | 
                <a href="#">-->
                    查看0人评论</a>
            </p>
        </div>
				<div class="inf_two">
				<c:if test="${mallTypeSmallPo.mtscolor ne ''}">
                <ul class="color">
                    <div class="spanColor" forsize="k" stylecode="437314403">
                    	<ul class="ul_1"><li class="tit">颜色：</li>
		                    <li class="txt">
		                    	<c:set value="${ fn:split(mallTypeSmallPo.mtscolor,',')}" var="colors" />
								<c:forEach items="${ colors }" var="color">
									<p title="${color }" onclick="ChooseThisColor(this,'${color}');"><span>${color }</span></p>
								</c:forEach>
		                    </li>
               			</ul>
               		</div>
                </ul>
                </c:if>
                <!--型号-->
                <c:if test="${mallTypeSmallPo.mtsspec ne ''}">
                <ul class="size">
                    <li class="txt">型号：<font class="red" id="txtSizek"></font></li>
                    	<c:set value="${ fn:split(mallTypeSmallPo.mtsspec,',')}" var="specs" />
						<c:forEach items="${ specs }" var="spec">
							<p onClick="ChooseThisSize(this,'${spec}')">${spec }</p>
						</c:forEach>
                    </li>
                </ul>
                </c:if>
                <p class="add">
                   <span><a href="insertMallShoppingFavoritePo.action?hid=${mallTypeSmallPo.mtsid}"><img src="<%=request.getContextPath()%>/img/mall/sc.jpg" width="34"></a></span>
                   <img src="<%=request.getContextPath()%>/img/mall/tj.png" onclick="save();" style="CURSOR: hand">
                </p>
      	</div>
        <div class="inf_three">
            <ul class="inf_nav">
                <a href="selectMallGoodsDetailContent.action?hid=${mallTypeSmallPo.mtsid}"  style="cursor:hand">
                    <li>图文详情<img src="<%=request.getContextPath()%>/img/mall/more.jpg" width="9">
                    </li>
                </a>
            </ul>
        </div>
    </div>
    <!--购物车动画-->

	<script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/img_reset.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/tbmtouch.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mall/Item.js"></script>
    </div>
    </form>
</BODY>
</HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>