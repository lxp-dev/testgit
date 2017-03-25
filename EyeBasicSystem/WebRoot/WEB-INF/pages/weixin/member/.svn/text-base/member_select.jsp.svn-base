<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册成功</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>
/*-------------------------------------------*/  
var InterValObj; //timer变量，控制时间  
var count = 10; //间隔函数，1秒执行  
var curCount;//当前剩余秒数  

	function sendMessage() {  
		curCount = count;  
		$("#autoHref").val("系统将会在" + curCount + "秒后自动跳转至会员中心...");  
	    InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一
	}  

	//timer处理函数  
	function SetRemainTime() {  
	    if (curCount == 0) {                  
	        window.clearInterval(InterValObj);//停止计时器  
	        location.href="oauth2Servlet?openID="+$('#openID').val();       
	    }  
	    else {  
	        curCount--;  
	        document.getElementById("autoHref").innerHTML="系统将会在" + curCount + "秒后自动跳转至会员中心...";  
	    }  
	}  

    function insert(){   
    	location.href="initWeiXinMemberBindInfoUpdate.action?openID="+$('#openID').val();      
    }

    function inPersonCenter(){        
    	//location.href="initPersonCenterSel.action?openID="+$('#openID').val();   
    	location.href="oauth2Servlet?openID="+$('#openID').val();       
    }
    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });
</script>

</head>

<body onload="sendMessage();" class="zc_bg" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="xf_canting xf_panle ">
    <!-- 注册成功 -->
    <div class="zccg">
      <img src="${ctx}/weixin_personcenter/images/zc1.png"  alt="" />
      <p>
        <b>恭喜您，注册成功啦！</b>
        <i>${weiXinDataConfigPo.wdcalertregistersuccess}</i>
        <span id="autoHref"></span>
      </p>
      <span class="zcan">
        <a class="zc2" href="#" onclick="insert();">完善个人资料</a>     
        <a class="zc3" href="#" onclick="inPersonCenter();">返回个人中心</a>
      </span>
    </div>
    <!-- 注册成功结束 -->
    <%@ include file="/weixin_personcenter/bottom.jsp" %>
  </div>
 </body>
</html>