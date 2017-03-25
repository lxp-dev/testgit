<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物资再利用</title>
</head>
<script>	
	
	
	function save(){
		if(checkForm(goodsImgLeaveMsgFrm)){
			var FileExt;
			var AllImgExt = ".jpg|.jpeg|.gif|.bmp|.png|"	// 全部图片格式类型 		
       		var flag = false;
       		$('input[name=upload]').each(function(){
           		var bbdlogo = $(this).val();
           		if(bbdlogo != "" && bbdlogo != null){ 
       		        FileExt = bbdlogo.substr(bbdlogo.lastIndexOf(".")).toLowerCase();       		
			        if(AllImgExt.indexOf(FileExt+"|") == -1){ // 如果不是图片文件，则提示
				        alert("该文件类型不允许上传,请上传 " + AllImgExt + " 类型的文件\n当前文件类型为" + FileExt);
				        flag = true;
				        return false;
			        }
       		    }
            });       		
       		if (flag){
       		    return;
       		}
       		
       		$("img").removeAttr("onclick");
			goodsImgLeaveMsgFrm.action = "insertGoodsImgLeaveMsg.action";
			goodsImgLeaveMsgFrm.submit();
		}
	}
	 var logoPath = '';
	    var backgroundPath = '';
	    function getPath(obj){
	 		if(obj){
	 	    	if (window.navigator.userAgent.indexOf("MSIE") >= 1){ 
	 	        	obj.select(); 
	 	            return document.selection.createRange().text;	               
	 	        }
	 	        else if(window.navigator.userAgent.indexOf("Firefox") >= 1){	               
	 	        	if(obj.files){ 	                           
	 	            	return obj.files.item(0).getAsDataURL();
	 	            }
	 	        	return obj.value;
	            	}else if(window.navigator.userAgent.indexOf("Chrome") >= 0){
	                 return window.webkitURL.createObjectURL(obj.files[0]);
	             }
	            	
	 	    	return obj.value;
	 		}
	 	}
	    function CheckExt(obj,flag){	    
	 		if(obj.value == ""){
	 			return false;
	 		}
	 		obj.value = getPath(obj);
	 	}

	    var FileExt,ErrMsg; // 全局变量图片相关属性
		var ImgObj = new Image(); 	// 建立一个图像对象
		ImgObj.onerror = function(){ErrMsg = '\n图片格式不正确或者图片已损坏!';}	
		
		var AllImgExt = ".jpg|.jpeg|.gif|.bmp|.png|";	// 全部图片格式类型
		var AllowExt = ".jpg|.jpeg|.gif|.bmp|.png|"; 	// 允许上传的文件类型 &#320;为无限制每个扩展名后边要加一个"|" 小写字母表示
				
		function CheckExt(obj){
			if(obj.value == ""){
				return false;
			}
			FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();
			if(AllImgExt.indexOf(FileExt+"|") == -1){ 
				alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);
				return false;
			}
			obj.value = getPath(obj);
		}

		$(document).ready(function() {
			$("img[btn=btn]").attr("style","cursor: hand");
			$("img[btn=btn]").mouseover(function () {
		    	$(this).attr("src",$(this).attr("src").replace("0","1"));
			}).mouseout(function () {
				$(this).attr("src",$(this).attr("src").replace("1","0"));
			});
		});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsImgLeaveMsgFrm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
		  </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>     
                      	<TR>
						  <TD width="10%" height="30" class="table_body">商品名称</TD>
                          <TD width="90%" class="table_none">
                          	<input class="text_input240" id="goodsName" name="goodsImgLeaveMsgPo.cmrlmGoodsName" value="" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品名称！'}]">
						  </TD>
						</TR>                   
						<TR>
						  <TD width="10%" height="30" class="table_body">内容简介</TD>
                          <TD width="90%" class="table_none">
                          	<textarea id="goodsContent" name="goodsImgLeaveMsgPo.cmrlmGoodsContent" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [1000]}, 'Message' : '内容简介不能过多!'}]"></textarea>
						  </TD>
						</TR>
						
						<TR>
					   <TD height="30" width="10%" class="table_body">选择图片</TD>
				           <TD height="30" width="90%" class="table_none" >
				           		<input width="800px;" type='file' id='file' name='upload' onchange="CheckExt(this);">
						   </TD>
						</TR>

                      </TBODY>
                    </TABLE>
					
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
							  
                          </TD>
                        </TR>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
