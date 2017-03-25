<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定位帮助</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />
</head>
<script>
//document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	//WeixinJSBridge.call('hideOptionMenu');
   // });
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
</script>
<body class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<style> 
		 .place{ padding:10px;} 
          .place p{ color:#333; font-size:16px;}      
			
			
         </style>
    <div class="title">如何发送地理位置</div>
         <div class="place">
         <p>步骤一：点击红圈中的键盘图标。 </p><br>
         
         <center><img width="80%" src="${ctx }/weixin/images/help1.jpg" alt="天津鹏升科技"></center><br><br>
         
         <p>步骤二：点击红圈中的“＋”按钮。 </p><br>
             <center> <img width="80%" src="${ctx }/weixin/images/help2.jpg" alt="天津鹏升科技"> </center><br><br>
         <p>步骤三：点击红圈中的位置图标，就会搜索到您的当前位置。</p><br>
         <center> <img width="80%" src="${ctx }/weixin/images/help3.jpg" alt="天津鹏升科技"> </center><br><br>
         <p>步骤四：点击红圈中的发送按钮就可进行附近门店的查询。 </p><br>
             <center> <img width="80%" src="${ctx }/weixin/images/help4.jpg" alt="天津鹏升科技"> </center><br><br>
    </div>
</body></html>