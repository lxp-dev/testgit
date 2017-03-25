<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>镜架维护</title>
</head>
<script type="text/javascript">
//幻灯片切换功能
var timer = null;
var offset = 5000;
var index = 0;/* 控制图片播放位置 */

//大图交替轮换
function slideImage(i){
	var targets  = target.split(",");
	var id = 'image_'+ targets[i];
		$('#'+ id).animate({opacity: 1}, 800, function(){
			//$(this).find('.word').animate({height: 'show'}, 'slow');
		}).show().siblings(':visible').find('.word').animate({height: 'hide'},'fast',function(){
			$(this).parent().animate({opacity: 0}, 800).hide();
	});
}
//bind thumb a
function hookThumb(){    
	$('#thumbs li a').bind('click', function(){
		if(timer){
			clearTimeout(timer);
		}                
		var id = this.id;            
		index = getIndex(id.substr(6));
//		rechange(index);
		slideImage(index); 
//		timer = window.setTimeout(auto, offset);  
		this.blur();            
		return false;
	});
}
//bind next/prev img
function hookBtn(){
	$('#thumbs li img').filter('#play_prev,#play_next').bind('click', function(){
		if(timer){
			clearTimeout(timer);
		}
		var indexcount=indexs-1;
		var id = this.id;
		if(id == 'play_prev'){
			index--;
			if(index < 0) index = indexcount;
		}else{
			index++;
			if(index > indexcount) index = 0;
		}
		slideImage(index);
	});
}
//得到指标
function getIndex(v){
	var targets  = target.split(",");
	for(var i=0; i < targets.length; i++){
		if(targets[i] == v)
		return i;
	}
}
function rechange(loop){
	var targets  = target.split(",");
 var id = 'thumb_'+ targets[loop];
 $('#thumbs li a.current').removeClass('current');
 $('#'+ id).addClass('current');
}
	function auto(){
		 index++;
		 if (index > indexs){
		     index = 0;
		 }
//		 rechange(index);
		 slideImage(index);
//		 timer = window.setTimeout(auto, offset);
	}
$(function(){  

	 <s:iterator value="photolist" status="idx">
		
	 if(target=="")
	 {
	 	target= "xixi-"+indexs+",";
	 	indexs = indexs +1;
	 	index = index +1;
	 }else
	 {
		 target= target+"xixi-"+indexs+",";
		 indexs = indexs +1;
		 index = index +1;
	 }
	 </s:iterator>
	 target=target.substring(0,target.length-1);
 //$('div.word').css({opacity: 0.85});
 auto();  
 hookThumb(); 
 hookBtn();
 
});

var target = ""; //["xixi-0","xixi-1","xixi-2","xixi-3","xixi-4","xixi-5","xixi-6","xixi-7"];
var indexs = 0;


</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="uuid" id="uuid" value="" /> 

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>

<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR><TD></br></TD></TR>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR> <c:if test="${fn:substring(goodsInfoPo.bgigoodsid,0,1) eq 1}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                     
                       onclick="JavaScript:window.location.href='initGlassesFrameDetails.action?moduleID=${requestScope.moduleID}&hid=${goodsInfoPo.bgigoodsid}';"
                      UNSELECTABLE="on">镜架详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    </c:if>
                    
                    <c:if test="${fn:substring(goodsInfoPo.bgigoodsid,0,1) eq 6}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                     
                       onclick="JavaScript:window.location.href='initGlassesFinishDetails.action?moduleID=${requestScope.moduleID}&hid=${goodsInfoPo.bgigoodsid}';"
                      UNSELECTABLE="on">太阳镜详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    </c:if>
                    
                       <c:if test="${fn:substring(goodsInfoPo.bgigoodsid,0,1) eq 8}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                     
                       onclick="JavaScript:window.location.href='initPresbyopicGlassesDetails.action?moduleID=${requestScope.moduleID}&hid=${goodsInfoPo.bgigoodsid}';"
                      UNSELECTABLE="on">老花镜详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    </c:if>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                     UNSELECTABLE="on">图片预览</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPricesAbout.action?moduleID=${requestScope.moduleID}&goodsid=${goodsInfoPo.bgigoodsid}&returnUrl=retail';"
                      UNSELECTABLE="on">价格走势图</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>		
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="8%" height="26" class="table_body">商品代码</TD>
			               <TD  class="table_none" colspan="5">
                            ${goodsInfoPo.bgigoodsid}<input class="text_input200" type="hidden" id="bgigoodsid" name="goodsInfoPo.bgigoodsid" value="${goodsInfoPo.bgigoodsid}">
			               </TD>
			            </TR>
			            </TABLE>
			          <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR><td align="center" width="70%">
			            <div id="featured">
			            <c:if test="${not empty(photolist)}">
						 <c:forEach var="photoPo" items="${photolist}" varStatus="indexs">
							<div class="items" id="image_xixi-${indexs.index}">
								<img width="700" height="438" src="${ctx }/GlassesFramePhotos/${photoPo.saveFileName}" />
								<div class="word"></div>
							</div >
							</c:forEach>
							</c:if>
							</td>
						<td>
						</div><!--featured end-->

						<div id="thumbs" align="center">


								<li style="list-style-type: none;"  ><img id="play_prev" style="cursor: hand;" src="${ctx}/img/newbtn/btn_prev.gif" width="20" height="13" alt="上一个" /></li>
								 <c:if test="${not empty(photolist)}">
						 <c:forEach var="photoPo" items="${photolist}" varStatus="index">
								<li style="list-style-type: none;">
									<a id="thumb_xixi-${index.index}" href="#image_xixi-${index.index}"><img width="70" height="44" src="${ctx }/GlassesFramePhotos/${photoPo.saveFileLittleName}" /></a>
								</li>
							</c:forEach>
							</c:if>
								<li style="list-style-type: none;"><img id="play_next" style="cursor: hand;" src="${ctx}/img/newbtn/btn_next.gif" width="20" height="13" alt="下一个" /></li>
						</div>
						</TD>
			            </TR>
			            </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>