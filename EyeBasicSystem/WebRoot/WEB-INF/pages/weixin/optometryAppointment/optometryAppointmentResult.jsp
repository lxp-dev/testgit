<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的预约</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideToolbar');
		WeixinJSBridge.call('hideOptionMenu');
    });
</script>
</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<c:set value="0" var="num1"></c:set>  

	<div class="xf_canting xf_panle">
		<!-- 我的预约 -->
		<div class="xf_ctinner">
			<!-- 栏目1 -->
			<div class="fctx">
			<c:forEach var="po" items="${weiXinOptometryAppointmentList}" varStatus="poIndex">
				<c:set value="${num1 + 1}" var="num1" />
				<div class=" wdyy" >
					<span class="wd1 tar">预约日期：${fn:substring(po.woadatetime, 0, 10) }&nbsp;&nbsp;<c:if test="${!empty po.woahour}">${po.woahour}点</c:if><c:if test="${!empty po.woaminute}">${po.woaminute}分</c:if></span>
					<ul class="">
						<li>
							<span>预&nbsp;约 &nbsp;人&nbsp;：</span>
							<i>${po.woaname }</i>
						</li>
						<li>
							<span>网点预约：</span>
							<i>${po.woawangdian }</i>
						</li>                
						<li>           
							<span>诊疗项目：</span>
							<i>${po.woazhenliao }</i>
						</li>
						<li>           
							<span>预约专家：</span>
							<i>${po.woadoctorname }</i>
						</li>
						<div class="yyhf  ">
							<span class="fl">预约状态：</span> 
							<div class="yyzt ">
								<c:choose>
							  		<c:when test="${po.woaisconfirm eq '0'}">
							  			<a class="yy1">预约确认中</a>
							  		</c:when>
							  		<c:when test="${po.woaisconfirm eq '1'}">
							  			<a class="yy2">预约成功</a>
							  		</c:when>                          		
							  		<c:when test="${po.woaisconfirm eq '2'}">
							  			<a class="yy3">预约失败</a>
							  		</c:when>
							  	</c:choose> 
							</div>
						</div>
						<c:if test="${!empty po.woaconfirmcontent}">
						<div class="yyhf">
							<span>预约回复：</span> 
							<i>${po.woaconfirmcontent}</i>
						</div>
						</c:if>
					</ul>
				</div>
				</c:forEach>
			</div>
			<c:if test="${num1 == 0}">
			<!-- 弹出ERROR1 -->
    		<div class="bg01">
		      <div class="qrdh wxtc2 yq">
		        <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
		        <p>暂无预约记录！</p>
		        <input class="wxyya zxzl1" type="button" value="确 定" onclick="history.go(-1);">
		      </div>
		    </div>
		    <!-- 弹出结束 -->
		</c:if>
		</div>
		<!-- 我的预约结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>