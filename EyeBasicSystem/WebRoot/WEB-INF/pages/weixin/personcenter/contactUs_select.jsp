<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>联系我们</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
</head>

<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.call('showOptionMenu');
	}); 
	
	$(document).ready(function() {
		setFrameUrl();
	});

	function setFrameUrl(){
		var url = "http://api.map.baidu.com/marker?location=${weiXinRegisterDepartmentPo.wrdcompanyxy}&output=html&content=&title=${weiXinRegisterDepartmentPo.wrdcompanyname}&number="+Math.random();
		document.getElementById("loadMap").src = url;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<!-- 联系我们 -->
		<div class="xf_ctinner">
			<div class="lxwm">
				<ul>	
					<!-- 联系方式 -->
					<span class="lxwmbt">${weiXinDataConfigPo.wdccontactuslxfstitle}</span>
						<li class="lxwm1">
						${weiXinDataConfigPo.wdccontactuslxfscontent}
						</li>
						<!-- 联系方式结束 -->
						<!-- 来院路线 -->
						<span class="lxwmbt">${weiXinDataConfigPo.wdccontactusldlxtitle}</span>
						<li class="lxwm2">
							${weiXinDataConfigPo.wdccontactusldlxcontent}
						</li>
						<!-- 来院路线结束 -->
						<!-- 我们在哪 -->
						<li>
							<span class="lxwmbt">我们在哪：<a class="xfsx" onclick="setFrameUrl();">刷新</a></span>
						</li>
						<li class="lxwm2" style="height:500px;">
							<div>
							<iframe height="100%" width="100%" src="" frameborder="0" scrolling="no" id="loadMap" />
							</div>
						</li>
						<!-- 我们在哪结束 -->
					</ul>
				</div>
			</div>
			<!-- 个人中心结束 -->
			<%@ include file="/weixin_personcenter/bottom.jsp" %>
		</div>
</body>
</html>