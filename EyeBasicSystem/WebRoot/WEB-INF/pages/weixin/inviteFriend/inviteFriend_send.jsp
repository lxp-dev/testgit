<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>好友信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

    function inviteFriend(){
        location.href="initWeiXinMemberInfoDetail.action?openID="+$('#openID').val();
    }    

    function insert(){
    	if(checkForm(inviteFriendFrm)){ 	
        	var xieyi = document.getElementById('xieyi');
        	if(!xieyi.checked){
    			alert("您认可协议么？");
    			return;
    		}
        	inviteFriendFrm.action = "sendWeiXinInviteFriend.action?openID="+$('#openID').val();
        	inviteFriendFrm.submit();
        }
    }
</script>
</head>
<body class="zc_bg" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inviteFriendFrm" method="post" action="">
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

	<div class="xf_canting xf_panle ">
    <!-- 好友信息 -->
    <div class="login_bg">
      <ul>
        <li class="register_t">
         <input name="weixinInviteFriendLogPo.wifltouserphone" type="text" placeholder="被推荐人手机号" value="${weixinInviteFriendLogPo.wifltouserphone}" id="wifltouserphone"  validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '手机号格式不正确！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Expansion' : {Type : Expansion.EQLength, Params : [11]}, 'Message' : '手机号长度应该为11个字符！'}]"/>
         <div class="ter_yz">
           <input type="text" placeholder="被推荐人姓名" id="wifltousername" name="weixinInviteFriendLogPo.wifltousername" maxlength="20" value="${weixinInviteFriendLogPo.wifltousername}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入被推荐人姓名！'}]"/>
         </div>
       </li>
       <li class="register_xy">
         <label class="checkbox"><input id="xieyi" type="checkbox" /></label>
         	我已阅读并同意遵守 <a href="">《隐私权政策》</a>
       </li>
       <li class="login_message">
        <input class="login_fen" type="button" value="确 定" onclick="insert();"/>  
      </li>
    </ul>
  </div>  
  <!-- 好友信息结束 -->
  <%@ include file="/weixin_personcenter/bottom.jsp" %>
</div>
</form>
</body>
</html>