<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jquery制作左右按钮控制焦点图片满屏滚动</title>
<meta name="description" content="" />
</head>
<body>
<script type="text/javascript" src="${ctx}/js/slide.js"></script>
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{background:#000;font:12px/180% Arial, Helvetica, sans-serif , "宋体";}
/* foucs */
#foucs{height:100%;overflow:hidden;position:relative;}
#foucs div.main{top:50px;display:none;cursor:pointer}
#foucs .element{top:50px;display:none;position:absolute;}
#foucs .navi{display:block;width:80px;height:80px;line-height:99em;overflow:hidden;background:url(img/arrow-btn.png) no-repeat;top:250px;}
#foucs .left{left:0;background-position:0 0;}
#foucs .left:hover{background-position:0 -80px;}
#foucs .right{right:0;background-position:-80px 0;}
#foucs .right:hover{background-position:-80px -80px;}
</style>
<div id="foucs">
 <c:forEach var="photoPo" items="${photolist}" varStatus="index">
	<div class="element pict"><img src="${ctx }/GlassesFramePhotos/${photoPo.saveFileName}" width="800" height="500" alt="" /></div>
	</c:forEach>
	<a href="javascript:void(0);" class="element navi left">向左</a>
	<a href="javascript:void(0);" class="element navi right">向右</a>	
</div>
</body>
</html>