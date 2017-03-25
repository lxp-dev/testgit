<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
<title>门店实景图</title>
<style type="text/css">  
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体"; text-align:left}
#n{margin:10px auto; width:920px; border:1px solid #CCC;font-size:12px; line-height:30px;}
#n a{ padding:0 4px; color:#333}

/* flexslider */
.flexslider{ position:relative;height:400px;overflow:hidden;background:url(<%=request.getContextPath()%>/img/weixin/loading.gif) 50% no-repeat;}
.slides{position:relative;z-index:1;}
.slides li{height:400px;}
.slides li a{ display:block; width:100%; height:100%; text-align:left; text-indent:-9999px}
.flex-control-nav{position:absolute;bottom:10px;z-index:2; left:10%;text-align:center;}
.flex-control-nav li{display:inline-block;width:14px; float:left;height:14px;margin:0 5px;*display:inline;zoom:1;}
.flex-control-nav a{display:inline-block;width:14px;height:14px;line-height:40px;overflow:hidden;background:url(<%=request.getContextPath()%>/img/weixin/dot.png) right 0 no-repeat;cursor:pointer;}
.flex-control-nav .flex-active{background-position:0 0;}

.flex-direction-nav{position:absolute;z-index:3; left:0;width:100%;top:45%;}
.flex-direction-nav li a{display:block;width:50px;height:50px;overflow:hidden;cursor:pointer;position:absolute;}
.flex-direction-nav li a.flex-prev{left:20px;background:url(<%=request.getContextPath()%>/img/weixin/prev.png) center center no-repeat;}
.flex-direction-nav li a.flex-next{right:20px;background:url(<%=request.getContextPath()%>/img/weixin/next.png) center center no-repeat;}

.keBody{background:url(<%=request.getContextPath()%>/img/weixin/bodyBg.jpg) repeat #333;}
.keTitle{height:60px; line-height:60px; font-size:30px; font-family:'微软雅黑'; color:#FFF; text-align:center; background:url(<%=request.getContextPath()%>/img/weixin/bodyBg3.jpg) repeat-x bottom left; font-weight:normal}
.wraper{height:100%; margin:0 auto;  position:relative;background:url(<%=request.getContextPath()%>/img/weixin/bg.jpg) repeat;}

</style> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/weixin/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/weixin/jquery.flexslider-min.js"></script>
<script>
$(function(){
	$('.flexslider').flexslider({
		directionNav: true,
		pauseOnAction: false
	});
});
</script>
</head>
<body class="keBody">
<h1 class="keTitle">${departmentsPo.bdpdepartmentname }</h1>
<!-- 以上html代码与特效无关 代码begin -->
<div class="wraper">
  <header id="scroll_pic_view" class="scroll_pic_view" style="overflow: hidden; ">
<div class="flexslider">
	<ul class="slides">
	  <s:iterator value="weiXinDepartmentPicList" var="weiXinDepartmentPicPo" status="currIndex">
        <li style="background:url(<%=request.getContextPath()%>${weiXinDepartmentPicPo.picUrl}) center 0 no-repeat;">
        <a target="_blank" href="<%=request.getContextPath()%>${weiXinDepartmentPicPo.picUrl}">Image</a>
        </li>
      </s:iterator>
	</ul>
</div>
  </header>
</div>
<!-- 代码end -->
</body>
</html>