<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>镜架维护</title>
</head>
<script>
	var addrows=0;	
	function save(){
		var uploadlen = 0;
		$('input[name=upload]').each(function (){
			uploadlen = accAdd(uploadlen,"1");
		});
		if(uploadlen==0){
			alert("请填写上传图片路径！");
			return;
		}
		$('input[name=upload]').each(function (){
			if($(this).val()==""){
				uploadlen = "x";
				return false;
			}
		});
		if(uploadlen=="x"){
			alert("请填写上传图片路径！");
			return;
		}
		if(addrows<0||addrows==0)
		{
			alert("请添加上传图片！");
			return;
		}

	if(checkForm(document.all.glassesFrameForm)){  
	    $("img").removeAttr("onclick");
		glassesFrameForm.action = "updateGlassesFramePhotoAR.action";
		glassesFrameForm.submit();
		
		}
	}
	
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	function deleteItem(item,i){
		$(item).parent().parent().parent().remove();	
		$("img[id=i"+i+"]").parent().parent().remove();
		 addrows=addrows-1;
	}


	function addRow(){
		var table = document.getElementById('photoTable');
		var index = table.rows.length - 1;
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		c1.width="8%"
		c1.innerHTML = '<input type="file" onChange="javascript:setImagePreview(this,'+index+');" id="upload" name="upload" f="i'+index+'"/><div  align="left"> <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn name="chk" id="d'+index+'"  title="删除" onclick="deleteItem(this,'+index+')"></div>';
        c2.innerHTML = '<div id="localImag'+index+'"><IMG id="uploadimage'+index+'" height=-1 width=-1 style="diplay:none"></div>';	
        addrows=addrows+1;

    	}

	function setImagePreview(obj,d) {
        var docObj=obj;
        var uploadimage ="uploadimage"+d;
        var imgObjPreview=document.getElementById(uploadimage);
                if(docObj.files && docObj.files[0]){
                        //火狐下，直接设img属性
                        imgObjPreview.style.display = 'block';
                        imgObjPreview.style.width = '200px';
                        imgObjPreview.style.height = '125px';                 
     					 imgObjPreview.src = window.webkitURL.createObjectURL(docObj.files[0]);

                		}else{
                        //IE下，使用滤镜
                        docObj.select();
                        var imgSrc = document.selection.createRange().text;
                        var localImag ="localImag"+d;
                        var localImagId = document.getElementById(localImag);
                        //必须设置初始大小
                        try{
                        	localImagId.style.width="200px"; 
                        	localImagId.style.height="125px"; 
                        localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                        localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
                        }catch(e){
                                alert("您上传的图片格式不正确，请重新选择!");
                                return false;
                        }
                        imgObjPreview.style.display = 'none';
                        document.selection.empty();
                }
                return true;
        }


	
	var maxH = screen.height;
	var maxW = screen.width;
	function DrawImage(ImgD){
		var preW = 300;   
		var preH = 400 ;
		var image=new Image();
		image.src=ImgD.src;
		
		if(image.width > maxW || image.height > maxH){ 
			alert("图片尺寸过大，请选择" + maxW + "*" + maxH + "的图片！"); 
			return;   
			}
		   if(image.width>0 && image.height>0){    
			   flag=true;    
			 if(image.width/image.height>= preW/preH){     
				 if(image.width>preW){
				        ImgD.width=preW;     
				        ImgD.height=(image.height*preW)/image.width;     
				        }
		        else{     
			        ImgD.width=image.width;
			        ImgD.height=image.height;     
		        }     
		        ImgD.alt=image.width+"×"+image.height;     
		        }    
		        else{     
			        if(image.height>preH){       
				        ImgD.height=preH;     
				        ImgD.width=(image.width*preH)/image.height;
				        }
		       			 else{     
				        ImgD.width=image.width;
			            ImgD.height=image.height;     
		            	}     
	                ImgD.alt=image.width+"×"+image.height;    
	                }
		    }
          } 
		function checkFormat(filePath){ 
		var   i = filePath.lastIndexOf('.'); 
		var   len = filePath.length;
		var   str = filePath.substring(len,i+1); 
		var   extName = "JPG,GIF,PNG,JPEG,BMP"; 
		if(extName.indexOf(str.toUpperCase()) < 0)  {       
			alert("请选择正确的图片文件!");     
			return false;    
			}  
		
		return true; 
		} 
	function FileChange(Value){
		
		if(checkFormat(Value))
			{  
			
				flag=false; 
				document.getElementById("uploadimage").width=100;
				document.getElementById("uploadimage").height=100;
				document.getElementById("uploadimage").alt="";
				document.getElementById("uploadimage").src=Value;
				DrawImage(document.getElementById("uploadimage"));
			}
		}

	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initGlassesFramePhotoDelete.action?actionUrl=deleteGlassesFramePhoto.action&deleteID="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),false); 
		}else{ 
		showPopWin("initGlassesFramePhotoDelete.action?actionUrl=deleteGlassesFramePhoto.action&deleteID="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),false); 
		} 
		document.getElementById('popupTitle').innerHTML="【图片删除】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="uuid" id="uuid" value="" /> 

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>

<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    <c:if test="${fn:substring(goodsInfoPo.bgigoodsid,0,1) eq 1}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                       onclick="JavaScript:window.location.href='initGlassesFrameUpdate.action?moduleID=${requestScope.moduleID}&hid=${goodsInfoPo.bgigoodsid}';"
                      UNSELECTABLE="on">镜架修改</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                     <c:if test="${fn:substring(goodsInfoPo.bgigoodsid,0,1) eq 6}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                       onclick="JavaScript:window.location.href='initGlassesFinishUpdate.action?moduleID=${requestScope.moduleID}&hid=${goodsInfoPo.bgigoodsid}';"
                      UNSELECTABLE="on">太阳镜修改</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                     <c:if test="${fn:substring(goodsInfoPo.bgigoodsid,0,1) eq 8}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                       onclick="JavaScript:window.location.href='initPresbyopicGlassesUpdate.action?moduleID=${requestScope.moduleID}&hid=${goodsInfoPo.bgigoodsid}';"
                      UNSELECTABLE="on">老花镜修改</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                     UNSELECTABLE="on">图片上传</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
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
			            <table table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="photoTable">
						<tr>
							<td class="table_none" colspan="2">
							<img id="button" src="${ctx}/img/newbtn/btn_spzpadd_0.png" btn=btn  title='商品照片添加' onclick="addRow();">
							</td>
						</tr>
						 <c:if test="${not empty(photolist)}">
						 <c:forEach var="photoPo" items="${photolist}" varStatus="index">
						 <tr>
						 <td width="8%">
							<input type="hidden" onChange="javascript:setImagePreview(this,${index.index});" id="upload" name="upload" value="${ctx }/GlassesFramePhotos/${photoPo.saveFileName}" f="i${index.index}"/><div  align="left"> <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn name="chk" id="d${index.index}"  title="删除" onclick="del('${photoPo.id}')"></div>
							</td>
							<td>
								<div id="localImag${index.index}"><IMG src="${ctx }/GlassesFramePhotos/${photoPo.saveFileName}" id="uploadimage${index.index}" height="125" width="200"></div>
							</td>
						 </tr>
						 
						 </c:forEach>
						</c:if>
					  </table>
					  <table table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="photoTable1">
						<tr>
							<td class="table_none" colspan="2">
							<img id="button" src="${ctx}/img/newbtn/btn_spzpadd_0.png" btn=btn  title='商品照片添加' onclick="addRow();">
							</td>
						</tr></table>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          </TD>
                      </TBODY>
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