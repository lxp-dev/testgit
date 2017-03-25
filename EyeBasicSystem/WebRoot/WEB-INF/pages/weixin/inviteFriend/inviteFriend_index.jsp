<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邀请好友</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<script>    

	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.call('showOptionMenu');
	}); 

    function inviteFriend(){
        location.href="initWeiXinInviteFriendConfirm.action?openID="+$('#openID').val();
    }    
</script>
</head>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

	<div class="loading"></div>
	<div class="xf_canting xf_panle  ">
		<!-- 邀请好友 -->
		<div class="yhy">
				<c:choose>
						<c:when test="${customerInfoPo.memberPicPath ne ''}">
							<c:choose>
								<c:when test="${fn:indexOf(customerInfoPo.memberPicPath, 'http://') ne ''}">
									<img src="${customerInfoPo.memberPicPath}?1=1" alt="">
								</c:when>
								<c:otherwise>
									<img src="${ctx}/${customerInfoPo.memberPicPath}?1=1" alt="">
								</c:otherwise>								
							</c:choose>
						</c:when>
						<c:otherwise>
							<img src="${ctx}/weixin_personcenter/default_images/person.png" alt="">
						</c:otherwise>
					</c:choose>
			<p>
				邀请好友<br>
				就诊成功，双方均享有积分
			</p>
		</div>
		<div class="thya"></div>
		<div class="thya3">
			<input class="zxanr zxzl1" type="button" value="我要推荐好友" onclick="inviteFriend();"/>
		</div>

		<!-- 邀请好友结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>