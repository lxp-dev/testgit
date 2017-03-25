<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<title>微信菜单配置</title>
</head>
<style type="text/css">
*{padding:0; margin:0;}
.bg {
position: absolute;
z-index: -1;
top: 0;
left: 0;
right: 0;
bottom: 0;
opacity: 0.8;
}
ul, ol, li, dl {
list-style-type: none;
}
.box {
width: 100%;
display: -webkit-box;
display: -moz-box;
-webkit-box-orient: horizontal;
-moz-box-orient: horizontal;
-webkit-box-sizing: border-box;
-moz-box-sizing: border-box;
}
.box > * {
-webkit-box-flex: 1;
-moz-box-flex: 1;
}
a:link, a:visited {
color: #575757;
text-decoration: none;
}
a {
text-decoration: none;
-webkit-tap-highlight-color: rgba(0, 0, 0, 0.35);
}
a:link, a:visited {
color: #575757;
text-decoration: none;
}
a {
text-decoration: none;
-webkit-tap-highlight-color: rgba(0, 0, 0, 0.35);
}

.nav4{
	height:45px;
}
.nav4 ul{
	position:fixed;
	z-index:200;
	bottom:0;
	left:0;
	width:100%
}
.nav4 li{
	border:1px solid rgba(190,190,190,1);
	height:45px;
	border-bottom:0;
	border-right:0;
	position:relative;
	-webkit-box-shadow:inset 0 0 3px #fff;
	float:left;
	width:33.26%;
}
.nav4 li:nth-of-type(1){border-left;0;}
.nav4 li>a{
	font-size:15px;
	-webkit-box-sizing:border-box;
	box-sizing:border-box;
	/*border:1px solid #f9f8f9;*/
	-webkit-tap-highlight-color:rgba(0,0,0,0);
	border-bottom:0;
	display:block;
	line-height:45px;
	text-align:center;
	background:-webkit-gradient(linear, 0 0, 0 100%, from(#f1f1f1), to(#dcdcdc), color-stop(35% ,#ededed), color-stop(50%, #e3e3e3) );
}
.nav4 li>a:only-child span{
	background:none;
	padding-left:0;
}
.nav4 li>a.on + dl{
	display: block;
}
.nav4 li>a span{
	color: #4f4d4f;
	display: inline-block;
	padding-left: 15px;
	background: url(<%=request.getContextPath()%>/weixin/images/1.svg#2) no-repeat 4px 18px;
	-webkit-background-size: 9px auto;
	text-shadow:0px 1px 0px #ffffff;
}
/***********************/
.nav4 dl{
	display:none;
	position:absolute;
	z-index:220;
	bottom:60px;
	left:50%;
	width:100px;
	margin-left:-50px;
	background:red;
	/*min-height:100px;*/
	background:#e4e3e2;
	/*border:1px solid #afaeaf;*/
	border-radius:5px;
	-webkit-box-shadow:inset 0 0 3px #fff;
	background:url(<%=request.getContextPath()%>/weixin/images/2.svg#3) no-repeat center center;
	-webkit-background-size:100%;
	background-size:100%;
}
/*, .nav4 dl:after*/
.nav4 dl:before{
	content:"";
	display:inline-block;
	position:absolute;
	z-index:240;
	bottom:0;
	left:50%;
	/*width:0;
	height:0;
	border:8px solid red;
	border-color:#afaeaf transparent transparent transparent;
	margin-left:-8px;
	margin-bottom:-16px;*/
	width:10px;
	height:8px;
	background: url(<%=request.getContextPath()%>/weixin/images/1.svg#2) no-repeat center -55px;
	-webkit-background-size: 10px auto;
	bottom: -7px;
	margin-left: -5px;
}
/*.nav4 dl:after{
	z-index:241;
	border-color:#e4e3e2 transparent transparent transparent;
	margin-bottom:-15px;
}*/
.nav4 dl dd{
	line-height:45px;
	text-align:center;
	background:-webkit-gradient(linear, 0 0, 100% 0, from(rgba(194,194,194,0.8)), to(rgba(194,194,194,0.8)), color-stop(50%, rgba(194,194,194,0.8)));
	background-size:80% 1px;
	background-repeat:no-repeat;
	background-position: center bottom;
	/*background: url(<%=request.getContextPath()%>/weixin/images/3.svg#4) no-repeat center bottom;
	-webkit-background-size:100px 1px;*/
}
.nav4 dl dd:last-of-type{
	background:none;
}
.nav4 dl dd a{
	font-size: 15px;
	display:block;
	color:#4f4d4f;
	text-shadow:0px 1px 0px #ffffff;
	white-space: pre;
	overflow: hidden;
	text-overflow: ellipsis;
}
.nav4 .masklayer_div{
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 180;
	background: rgba(0,0,0,0);
}
.nav4 .masklayer_div.on{display: block;}
</style>
<body>
<div class="bg"><img src="<%=request.getContextPath()%>/weixin/images/home-default17.jpg" width="100%" height="100%"></div>
<div class="nav4">
	<nav>
		<div id="nav4_ul" class="nav_4">
			<ul class="box">
				<li>
					<a href="#" class=""><span>${weiXinMenuPo.wmcname1 }</span></a>
					<dl>
						<dd>
							<c:if test="${weiXinMenuPo.wmcflag11 eq '1'}">
								<c:choose>
									<c:when test="${weiXinMenuPo.wmctypeid11 eq 'system_website'}"><!-- 打开网址 -->
										<a href="#" onclick="viewLink('${weiXinMenuPo.wmccontent11}')"><span>${weiXinMenuPo.wmcname11 }</span></a>
									</c:when>	
									<c:when test="${weiXinMenuPo.wmctypeid11 eq 'system_wzlb'}"><!-- 文章列表 -->
										<a href="#" onclick="viewLink('initUserCmsContentList.action')"><span>${weiXinMenuPo.wmcname11 }</span></a>
									</c:when>
									<c:when test="${weiXinMenuPo.wmctypeid11 eq 'system_wznr'}"><!-- 文章内容 -->
										<a href="#" onclick="viewLink('initUserCmsContentDetails.action')"><span>${weiXinMenuPo.wmcname11 }</span></a>
									</c:when>																									
									<c:when test="${weiXinMenuPo.wmctypeid11 eq 'system_fjmd'}"><!-- 附近门店 -->
										<a href="#" onclick="viewLink('initWeiXinUserDepartmentsList.action')"><span>${weiXinMenuPo.wmcname11 }</span></a>
									</c:when>	
									<c:when test="${weiXinMenuPo.wmctypeid11 eq 'system_ysjs'}"><!-- 医师介绍 -->
										<a href="#" onclick="viewLink('initWeiXinPersonListView.action')"><span>${weiXinMenuPo.wmcname11 }</span></a>
									</c:when>	
									<c:when test="${weiXinMenuPo.wmctypeid11 eq 'system_mrqd'}"><!-- 每日签到 -->
										<a href="#" onclick="viewLink('initWeiXinDailyAttendance.action')"><span>${weiXinMenuPo.wmcname11 }</span></a>
									</c:when>
									<c:when test="${weiXinMenuPo.wmctypeid11 eq 'system_hyzl'}"><!-- 会员资料 -->
										<a href="#" onclick="viewLink('insertWeiXinMemberBindInfo.action')"><span>${weiXinMenuPo.wmcname11 }</span></a>
									</c:when>																																
									<c:otherwise>
										<span>${weiXinMenuPo.wmcname11 }</span>
									</c:otherwise>
								</c:choose>
							</c:if>
						</dd>
						<dd>
							<c:choose>
								<c:when test="${weiXinMenuPo.wmctypeid12 eq 'system_website'}">
									<a href="#" onclick="viewLink('${weiXinMenuPo.wmccontent12}')"><span>${weiXinMenuPo.wmcname12 }</span></a>
								</c:when>								
								<c:when test="${weiXinMenuPo.wmctypeid12 eq 'system_fjmd'}">
									<a href="#" onclick="viewLink('initWeiXinUserDepartmentsList.action')"><span>${weiXinMenuPo.wmcname12 }</span></a>
								</c:when>							
								<c:otherwise>
									<span>${weiXinMenuPo.wmcname12 }</span>
								</c:otherwise>
							</c:choose>
						</dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname13 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname14 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname15 }</span></a></dd>
					</dl>
				</li>
				<li>
					<a href="javascript:;" class=""><span>${weiXinMenuPo.wmcname2 }</span></a>
					<dl>
						<dd>
							<c:if test="${weiXinMenuPo.wmcflag21 eq '1'}">
								<c:choose>
									<c:when test="${weiXinMenuPo.wmctypeid21 eq 'system_website'}"><!-- 打开网址 -->
										<a href="#" onclick="viewLink('${weiXinMenuPo.wmccontent21}')"><span>${weiXinMenuPo.wmcname21 }</span></a>
									</c:when>	
									<c:when test="${weiXinMenuPo.wmctypeid21 eq 'system_wzlb'}"><!-- 文章列表 -->
										<a href="#" onclick="viewLink('initUserCmsContentList.action')"><span>${weiXinMenuPo.wmcname21 }</span></a>
									</c:when>
									<c:when test="${weiXinMenuPo.wmctypeid21 eq 'system_wznr'}"><!-- 文章内容 -->
										<a href="#" onclick="viewLink('initUserCmsContentDetails.action?hid=402880e64c563f94014c566d6f700007')"><span>${weiXinMenuPo.wmcname21 }</span></a>
									</c:when>																									
									<c:when test="${weiXinMenuPo.wmctypeid21 eq 'system_fjmd'}"><!-- 附近门店 -->
										<a href="#" onclick="viewLink('initWeiXinUserDepartmentsList.action')"><span>${weiXinMenuPo.wmcname21 }</span></a>
									</c:when>	
									<c:when test="${weiXinMenuPo.wmctypeid21 eq 'system_ysjs'}"><!-- 医师介绍 -->
										<a href="#" onclick="viewLink('initWeiXinPersonListView.action')"><span>${weiXinMenuPo.wmcname21 }</span></a>
									</c:when>	
									<c:when test="${weiXinMenuPo.wmctypeid21 eq 'system_mrqd'}"><!-- 每日签到 -->
										<a href="#" onclick="viewLink('initWeiXinDailyAttendance.action')"><span>${weiXinMenuPo.wmcname21 }</span></a>
									</c:when>
									<c:when test="${weiXinMenuPo.wmctypeid21 eq 'system_hyzl'}"><!-- 会员资料 -->
										<a href="#" onclick="viewLink('insertWeiXinMemberBindInfo.action')"><span>${weiXinMenuPo.wmcname21 }</span></a>
									</c:when>																																
									<c:otherwise>
										<span>${weiXinMenuPo.wmcname21 }</span>
									</c:otherwise>
								</c:choose>
							</c:if>
						</dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname22 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname23 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname24 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname25 }</span></a></dd>
					</dl>
				</li>
				<li>
					<a href="javascript:;" class="on"><span>${weiXinMenuPo.wmcname3 }</span></a>
					<dl>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname31 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname32 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname33 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname34 }</span></a></dd>
						<dd><a href="#"><span>${weiXinMenuPo.wmcname35 }</span></a></dd>
					</dl>
				</li>
			
			</ul>
		</div>
	</nav>
	
	<div id="nav4_masklayer" class="masklayer_div on"><iframe id="viewFrame" src="" width="100%" height="500" border="5"></iframe></div>
</div>
<script src="<%=request.getContextPath()%>/weixin/js/menu.js"></script>
<script type="text/javascript">
nav4.bindClick(document.getElementById("nav4_ul").querySelectorAll("li>a"), document.getElementById("nav4_masklayer"));
	function viewLink(url){
		document.getElementById("viewFrame").src=url;
	}
</script>		
																
</body>
</html>