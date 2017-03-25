<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" language="javascript" src="${ctx}/js/calenderJS.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style type="text/css">
             body{margin:0 ;padding:20px 40px;line-height:180%;}
             img{border:none;}
             ul,li{margin:0 ;padding:0;}
             li{list-style:none;display:inline; border:1px solid #999;float:left; margin-right:10px;}
             /*tooltip*/
             #tooltip{position:absolute;border:1px solid #CCC;display:none;color:#FFF; padding:2px; background:#333;}
          </style>
<script type="text/javascript">

$(document).ready(function() {
	$("img[btn=btn]").attr("style","cursor: hand");
	$("img[btn=btn]").mouseover(function () {
    	$(this).attr("src",$(this).attr("src").replace("0","1"));
	}).mouseout(function () {
		$(this).attr("src",$(this).attr("src").replace("1","0"));
	});

	toRound();
});

function search(){
	frameSalesForm.action = "initPictureShowSel.action";
	frameSalesForm.submit();
	showLoadingBar();
}

function selectGoodsPic(obj){
	if(event.keyCode==13){
	    if ($.trim(obj.value) == ''){
            alert('请输入商品代码!');
            obj.focus();
            return;
		}
    	search();
    }	
}

function toRound(){
	var frm = window.parent.frames;
	for (var i=0; i < frm.length; i++){
		if(frm[i].name=='hiddenTop'){
			frm[i].toTop();
		}
		if(frm[i].name=='centerframe'){
			frm[i].toLeft();
		}
	}
}
function clean(){
	$('#frameSalesForm').find("input[clean=clean]").each(function(){
		$(this).val('');
	});
	$('#frameSalesForm').find("select[clean=clean]").each(function(){
		$(this).val('');
	});
}

function show(goodsid){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	
	if(is_iPad()){
		showPopWin("selPictureShow.action?moduleID=${requestScope.moduleID}&goodsid="+goodsid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("selPictureShow.action?moduleID=${requestScope.moduleID}&goodsid="+goodsid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【商品图库查询】";

}

$(function(){
        var x = 10;
        var y = 20;
$("a.tooltip").mouseover(function(e){
this.myTitle = this.title;
  this.title = "";
var imgTitle = this.myTitle?""+ this.myTitle : "";
var tooltip = "<div id='tooltip'>"+imgTitle+"</br><\/div>"; //创建 div 元素
 $("body").append(tooltip);        //把它追加到文档中
 $("#tooltip").css({
           "top": (e.pageY+y) + "px",
           "left":  (e.pageX+x)  + "px"
   }).fadeIn(600);          //设置x坐标和y坐标，并且显示
}).mouseout(function(){
 this.title = this.myTitle;
 $("#tooltip").remove();         //移除
}).mousemove(function(e){
  $("#tooltip").css({
        "top": (e.pageY+y) + "px",
        "left":  (e.pageX+x)  + "px"
 });
});
})

function clean(){
    $('#bgigoodscategoryid').val('');
    $('#goodsID').val('');
}

</script>
<BODY bgColor=#ffffff  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="frameSalesForm" method="post" enctype="multipart/form-data">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV align="center">
           <table width="100%" border=0 align="center" cellpadding=0 cellspacing=0 class="privateBorder" id="title1">
             <TBODY>
               <TR >
               <td>
	             <table border=0 width="100%" id="title2">
		             <TBODY>
			               <TR>
			                 <TD height="26" class="table_none">商品类别
			                 	<select clean="clean" id="bgigoodscategoryid" name="bgigoodscategoryid">
			                	<option value="">----请选择----</option>
			          			<option value="1" ${bgigoodscategoryid == '1' ? 'selected="selected"' : '' }>镜架</option>
			          	   		<option value="6" ${bgigoodscategoryid == '6' ? 'selected="selected"' : '' }>太阳镜</option>
			          	   		<option value="8" ${bgigoodscategoryid == '8' ? 'selected="selected"' : '' }>老花镜</option>
			                 	</select>
			                 	&nbsp;&nbsp;&nbsp;&nbsp;商品代码
			                	 <input clean="clean" class="text_input160" id="goodsID" name="goodsID" value="${goodsID}" maxlength="50" onkeydown="selectGoodsPic(this);"/>
			                	 &nbsp;&nbsp;&nbsp;&nbsp;
			                	 <img align="top" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
			                	 <img align="top" src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >
			                </TD>
						</tr>
					</table>
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                 </td>
               </TR>
            <c:if test="${not empty(photoslist)}">   
	           <tr align="center">
	           	<td >
		         <table width="100%" border=0 >
		         <TBODY>
		          <tr>
		          <td align="center">
		            <table align="left" border=0 class="privateBorder" width="100%">
					<tr>
					 <c:forEach var="yy" items="${photoslist}" varStatus="sta">
						<td align="left" width="17%" border=1 class="privateBorder" height=94 width=150>
					 		<div id="thumbs">
							<a class="tooltip" title="商品代码：${yy.bgigoodsid}<br>商品名称：${yy.bgigoodsname}<br>品种名称：${yy.bgibrandname}<br>产地：${yy.bgisource}<br>型号：${yy.bgispec}<br>颜色：${yy.bgicolor}<br>零售价：${yy.bgiretailprice}" id="${ctx }/GlassesFramePhotos/${yy.saveFileLittleName}" href="javascript:show('${yy.bgigoodsid}')">
							<img height=106 width=170 src="${ctx }/GlassesFramePhotos/${yy.saveFileLittleName}">
							</a>
							</div>${yy.bgigoodsid}</br>${yy.bgigoodsname}
					 	</td>
					 		<c:if test="${0==(sta.index+1)%5}">
				 			</tr>
				 			<tr>
		 					</c:if>
						 </c:forEach>  	
				  </td></tr>
				 </table>
				</tr>
				</TBODY>
				 </table>
				 <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Paginationphoto.jsp" />
						</div>
					<!-- END 分页 -->
				 </td> 
				 </tr> 
			</c:if>	
				 </TBODY>
             </TABLE>
                  </DIV>
</form>
</body></html>