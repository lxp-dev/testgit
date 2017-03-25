<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章列表</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function link(type){
		userVisitForm.action = "initUserCmsContentList.action?type=" + type;
		userVisitForm.submit();
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle ">
		<!-- 最新活动 -->
		<div class="xq ">
			<div class="zxzt">
				<!-- 最新活动栏目1 -->
				<s:iterator value="weiXinCmsTypeList">
				<div class="zxbg" onclick="link('${wcmstid}')">
					<a class="zxyb" href=""><img src="${ctx}/weixin_personcenter/images/zxhd2.png"  alt="" /></a>
					<a class="zxjs">
						<span>
						<c:choose> 
						    <c:when test="${fn:length(wcmstname) > 10}"> 
						     <c:out value="${fn:substring(wcmstname, 0, 8)}..." /> 
						    </c:when> 
						    <c:otherwise> 
						     <c:out value="${wcmstname}" /> 
						    </c:otherwise>
					    </c:choose>
					    </span>
						<b>	2016-02-28 </b>
					</a>
				</div>
				</s:iterator>
			</div>
		</div>
	</div>
	
	<c:if test="${openID ne ''}" >
	<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</c:if>	
<DIV>
</BODY></HTML>