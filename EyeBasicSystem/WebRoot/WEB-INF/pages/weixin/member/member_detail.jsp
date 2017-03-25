<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的资料</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>
    function insert(){ 
    	location.href="initWeiXinMemberBindInfoUpdate.action?openID="+$('#openID').val();     
    }
    
	function update(){
		if(confirm("确定要解除绑定吗？"))
		 {
			location.href="updateClearOpenId.action?openID="+$('#openID').val();
		 }
	}

	function link(type){
		location.href="initUserCmsContentDetails.action?hid=" + type;
	}
	
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });
</script>
</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<!-- 我的资料 -->
		<div class="xf_ctinner">
			<div class="zltx">
				<c:choose>
					<c:when test="${customerInfoPo.memberPicPath ne ''}">
						<c:choose>
							<c:when test="${fn:indexOf(customerInfoPo.memberPicPath, 'http://') ne ''}">
								<img src="${customerInfoPo.memberPicPath}" alt="">
							</c:when>
							<c:otherwise>
								<img src="${ctx}/${customerInfoPo.memberPicPath}" alt="">
							</c:otherwise>								
						</c:choose>
					</c:when>
					<c:otherwise>
						<img src="${ctx}/weixin_personcenter/default_images/person.png" alt="">
					</c:otherwise>
				</c:choose>				
			</div>
			<div class="zlxx">
				<ul>
					<li class="ht">
						<span>姓名</span><p>${customerInfoPo.smeciname }</p>
					</li>
					<li class="ht">
						<span>会员等级</span>
						<p><a href="#" onclick="link('${lxhxID}')">${(customerInfoPo.smeciconsumptionprice eq '0.00') ? '蓝星会员' : '红星会员'}</a></p>
					</li>
					<li class="ht">
						<span>生日</span>
						<p>${customerInfoPo.smecibirthday}</p>
					</li>
					<li class="ht">
						<span>年龄</span>
						<p>${customerInfoPo.fmmage }</p>
					</li>					
					<li class="ht">
						<span>性别</span> 
						<p>
							<c:if test="${customerInfoPo.smecisex eq '0' }">男 </c:if>
            				<c:if test="${customerInfoPo.smecisex eq '1' }">女</c:if>
           				</p>
					</li>
					<li class="ht">
						<span>电话</span> 
						<p>
							${customerInfoPo.smeciphone }
						</p>
					</li>					
					<li class="ht">
						<span>地区</span> 
						<p>
							${customerInfoPo.smecizone }
						</p>
					</li>										
					<li class="ht">
						<span>地址</span>
						<textarea class="ht3" id="smeciaddress" name="customerInfoPo.smeciaddress" rows="3" cols="30" readonly="readonly">${customerInfoPo.smeciaddress}</textarea> 
					</li>
					<li class="ht">
						<span>推荐人手机</span> 
						<p>
							${customerInfoPo.smecitjrphone }
						</p>
					</li>					
					<li class="pt1">
						<input class="zlan" type="button" onclick="insert();" value=" 修 改 ">
					</li>
					<li>
						<input class="zlan" type="button" onclick="update();" value=" 解除绑定 ">
					</li>
				</ul>
			</div>
		</div>
		<!-- 我的病历结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>