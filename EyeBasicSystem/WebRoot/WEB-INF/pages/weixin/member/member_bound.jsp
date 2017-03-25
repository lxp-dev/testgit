<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<script>
/*-------------------------------------------*/  
var InterValObj; //timer变量，控制时间  
var count = 60; //间隔函数，1秒执行  
var curCount;//当前剩余秒数  
var code = ""; //验证码  
var codeLength = 6;//验证码长度  
function sendMessage() {  
    curCount = count;  
    var phone=$("#memberPhone").val();//手机号码  
    if(phone != ""&&phone != "手机号"){  
        //产生验证码  
        for (var i = 0; i < codeLength; i++) {  
            code += parseInt(Math.random() * 9).toString();  
        }  
        //设置button效果，开始计时  
        //$("#btnSendCode").removeAttr("onclick");  
        $("#btnSendCode").css('display','none');
        $("#btnSendCodeDiv").val("&nbsp;&nbsp;&nbsp;&nbsp;请在" + curCount + "秒内输入验证码");  
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次  
    
    	$.post("sendMsgAjax.action", { phone: phone, code: code});//向后台发送处理数据  
    	$("#checkCode").val(code);

    }else{  
        alert("手机号码不能为空！");  
    }  
}  

//timer处理函数  
function SetRemainTime() {  
    if (curCount == 1) {                  
        window.clearInterval(InterValObj);//停止计时器  
        //$("#btnSendCode").attr("onclick","sendMessage();");//启用按钮  
        $("#btnSendCode").css('display','block'); //启用按钮  
        document.getElementById("btnSendCodeDiv").innerHTML="";
                
        code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
    }  
    else {  
        curCount--;  
        document.getElementById("btnSendCodeDiv").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + curCount + "秒后可重新获取！";  
    }  
}  

    function insert(){
    	if(checkForm(memeberFrm)){ 	
        	var xieyi = document.getElementById('xieyi');
        	if (!validate()){
        		$('#input1').focus();
                return;
            }
        	if(!xieyi.checked){
    			alert("您认可协议么？");
    			return;
    		}
        	memeberFrm.action = "insertWeiXinMemberBindInfo.action?toUserName="+$('#toUserName').val()+"&openID="+$('#openID').val()+"&memberPhone="+$('#memberPhone').val();
    		memeberFrm.submit();
        }
    }

    var twoCode ; //在全局 定义验证码
    function createCode(){ 
    	twoCode = "";
	    var codeLength = 4;//验证码的长度
	    var checkCode = document.getElementById("checkCode");
	    var checkCodeInput = document.getElementById("input1");
	    checkCode.value = "";
	    var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
	    for(var i=0;i<codeLength;i++) {
	       var charIndex = Math.floor(Math.random()*32);
	       twoCode +=selectChar[charIndex];
	    }
	    if(twoCode.length != codeLength){
	       createCode();
	    }
	    checkCode.value = twoCode;
	    checkCodeInput.value = twoCode;
    }
    
    function validate () {
	    var inputCode = document.getElementById("input1").value.toUpperCase();
	    if(inputCode.length <=0) {
	       alert("请输入验证码！");
	       return false;
	    }
	    else if(inputCode != $("#checkCode").val() ){
	       alert("验证码输入错误！");
	       //createCode();
	       return false;
	    }
	    else {
	       return true;
	    }
    }

	$(document).ready(function() {
		//createCode();
	});

    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

    function agreement(){ 
    	location.href="initWeiXinMemberAgreementSel.action?tjrPhone="+$('#tjrPhone').val()+"&toUserName="+$('#toUserName').val()+"&input1="+ $('#input1').val() +"&checkCode="+ $('#checkCode').val() +"&memberPhone="+ $('#memberPhone').val() +"&openID="+$('#openID').val();             
    } 
</script>
</head>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } class="zc_bg">
<form name="memeberFrm" method="post" action="">
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<input name="toUserName" id="toUserName" type="hidden" value="${toUserName}" readonly="readonly"/>
  <div class="xf_canting xf_panle">
  	<img class="ts1" src="${ctx}/weixin_personcenter/images/1.png">
    <div class="login_bg">
      <ul>
        <li class="register_t">
         <input name="memberPhone" type="text" placeholder="手机号" value="${memberPhone}" id="memberPhone"  validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '手机号不正确！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Expansion' : {Type : Expansion.EQLength, Params : [11]}, 'Message' : '手机号长度应该为11个字符！'}]"/>
         <div class="ter_yz">
           <input id="input1" name="textfield2" type="text" size="8" placeholder="验证码" value="${input1}" />
           <input type="hidden" id="checkCode" value="${checkCode}" readonly="readonly"/>
            <c:choose>
            	<c:when test="${registertype eq '1'}">
            		<a class="ter_hq" href="#" id="btnSendCode" onclick="sendMessage()">获取</a>
            	</c:when>
            	<c:when test="${registertype eq '2'}">
            		<a class="ter_hq" href="#" id="btnSendCode" onclick="createCode()">获取</a>
            	</c:when>            	
            </c:choose>
         </div>
         <input name=tjrPhone type="text" placeholder="推荐人手机号" value="${tjrPhone}" id="tjrPhone" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '手机号应为数字！'}]"/>
         <span id="btnSendCodeDiv"></<span>
       </li>
       <li class="register_xy">
         <label class="checkbox"><input id="xieyi" type="checkbox" /></label><span>&nbsp;&nbsp;我已阅读并同意 <a href="#" onclick="agreement();">《用户服务协议》</a></span>
       </li>
       <li class="login_message">
        <input class="login_fen" type="button" value="立即注册" onclick="insert();"/>  
      </li>
    </ul>
  </div>  
  <!-- 注册结束 -->
</div>
</form>
</body>
</html>