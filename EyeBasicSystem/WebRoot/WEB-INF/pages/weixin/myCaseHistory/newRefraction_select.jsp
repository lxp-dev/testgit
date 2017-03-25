<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>最新屈光信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    }); 
</script>
</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<c:choose>
    	<c:when test="${empty refractivePo.soprdbalballglassod}">
    		<!-- 弹出ERROR1 -->
    		<div class="bg01">
		      <div class="qrdh wxtc2 yq">
		        <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
		        <p>暂无检查记录！</p>
		        <input class="wxyya zxzl1" type="button" value="确 定" onclick="history.go(-1);">
		      </div>
		    </div>
		    <!-- 弹出结束 -->
    	</c:when>
 	    <c:otherwise>
   		   <!-- 最新屈光信息 -->
		<div class="pt1 zt_h"></div>
		<div class="xf_ctinner p1rm">
			<span class="qgbt">
				<i>左 眼</i>
				<i>右 眼</i>
			</span>
			<div class="qgnr">
				<ul>
					<li>	
						<i>
							球 镜
						</i>
						<span>
							${refractivePo.soprdbalballglassod}
						</span>
						<span>
							${refractivePo.soprdbalballglassos}
						</span>
					</li>
					<li>	
						<i>
							柱 镜
						</i>
						<span>
							${refractivePo.soprdbalpostglassod}
						</span>
						<span>
							${refractivePo.soprdbalpostglassos}
						</span>
					</li>
					<li>	
						<i>
							轴向
						</i>
						<span>
							${refractivePo.soprdbalaxesod}
						</span>
						<span>
							${refractivePo.soprdbalaxesos}
						</span>
					</li>
					<li>	
						<i>
							矫正视力
						</i>
						<span>
							${refractivePo.soprdbalvaod}
						</span>
						<span>
							${refractivePo.soprdbalvaos}
						</span>
					</li>					
				</ul>
			</div>
    	</c:otherwise>
    </c:choose>
		</div>
		<!-- 最新屈光信息结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>