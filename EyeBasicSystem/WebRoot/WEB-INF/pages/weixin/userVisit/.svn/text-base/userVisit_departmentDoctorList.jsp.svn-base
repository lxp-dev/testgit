<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家团队</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
</head>
<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

	function details(hid){
		location.href="initUserDepartmentDoctorDetail.action?hid="+ hid +"&openID="+$('#openID').val();		
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<!-- 专家团队 -->
		<div class="xf_ctinner ">
			<span class="h3bg "></span>
			<c:if test="${!empty po1.wdpersonid && po1.wdpersonid ne ''}">
			<!--栏目1 -->
			<div class="zjtd pt1">
				<ul onclick="details('${po1.wdpersonid}')">
					<li>
						<c:choose>
							<c:when test="${po1.wdpicurl ne ''}">
								<img src="${ctx }${po1.wdpicurl}" alt=""/>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${po1.wdsex eq '1'}">
										<img src="${ctx}/weixin_personcenter/default_images/sex1.png" alt="" />
									</c:when>
									<c:when test="${po1.wdsex eq '2'}">
										<img src="${ctx}/weixin_personcenter/default_images/sex2.png" alt="" />
									</c:when>
								</c:choose>								
							</c:otherwise>
						</c:choose>						
					</li>
					<li class="zjnr">
						<span><b>${po1.wdname}</b><i>${po1.wdzhicheng}</i></span>
						<span><var>好评率<a>
						<c:choose>
                       		<c:when test="${po1.wdhaopinglv eq '-1'}">
                       			暂无评价
                       		</c:when>
                       		<c:otherwise>
                       			${po1.wdhaopinglv}%
                       		</c:otherwise>
                       	</c:choose>
						</a></var></span>
						<span class="zjtd1">
							<p>
							<c:choose> 
							    <c:when test="${fn:length(po1.wdcontent) > 35}"> 
							     <c:out value="${fn:substring(po1.wdcontent, 0, 35)}..." /> 
							    </c:when> 
							    <c:otherwise> 
							     <c:out value="${po1.wdcontent}" /> 
							    </c:otherwise>
						    </c:choose>
					    	</p> 
						</span>
						<input class="wxyya zxzl1" type="button" value="查看详情" onclick="">
					</li>
				</ul>
			</div>
			<!--栏目1结束 -->
			</c:if>
			<!--栏目2 -->
			<div class="zjzt">
				<c:forEach var="po" items="${po2List}" varStatus="status">
				<div class="zjtc1" onclick="details('${po.wdpersonid}')">
					<ul>
						<li>
						<c:choose>
							<c:when test="${po.wdpicurl ne ''}">
								<img src="${ctx }${po.wdpicurl}" alt=""/>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${po.wdsex eq '1'}">
										<img src="${ctx}/weixin_personcenter/default_images/sex1.png" alt="" />
									</c:when>
									<c:when test="${po.wdsex eq '2'}">
										<img src="${ctx}/weixin_personcenter/default_images/sex2.png" alt="" />
									</c:when>
								</c:choose>	
							</c:otherwise>
						</c:choose>
						</li>
						<li><span><b>${po.wdname}</b></span></li>
						<li><span><i>${(po.wdzhicheng ne '')? po.wdzhicheng:'&nbsp;'}</i></span></li>
						<li><var>【好评率  <a>
						<c:choose>
                       		<c:when test="${po.wdhaopinglv eq '-1'}">
                       			暂无评价
                       		</c:when>
                       		<c:otherwise>
                       			${po.wdhaopinglv}%
                       		</c:otherwise>
                       	</c:choose>
						</a>】</var></li>
						<li><input class="zxzl1 zjtc2 " type="button" value="查看详情">
						</li>
					</ul>
				</div>
				</c:forEach>
			</div>
			<!--栏目2结束 -->
		</div>
		<!-- 专家团队结束 -->
	</div>
	
</body></html>