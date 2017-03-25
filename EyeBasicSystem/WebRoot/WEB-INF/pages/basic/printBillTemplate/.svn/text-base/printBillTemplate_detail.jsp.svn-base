<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息维护</title>
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

	function clean(){
		printBillTemplateForm.reset();
	}
	
	function save(){
	    if(checkForm(printBillTemplateForm)){	  
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
       		  
		    $('#submitButton').removeAttr("onclick"); 
		    printBillTemplateForm.action = "printBillTemplateInsert.action";
		    //printBillTemplateForm.submit();
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
		
	var ImgObj = new Image(); 	// 建立一个图像对象
	var AllImgExt = ".jpg|.jpeg|.gif|.bmp|.png|";	// 全部图片格式类型
	var FileObj,ImgFileSize,ImgWidth,ImgHeight,FileExt,ErrMsg,FileMsg,IsImg; // 全局变量图片相关属性
	// 以下为限制变量
	var AllowExt = ".jpg|.jpeg|.gif|.bmp|.png|"; 	// 允许上传的文件类型 &#320;为无限制每个扩展名后边要加一个"|" 小写字母表示
	
	var AllowImgFileSize = 30; 	// 允许上传图片文件的大小 0为无限制 单位：KB
	var AllowImgWidth = 800; 		// 允许上传的图片的宽度 &#385;为无限制　单位：px(像素)
	var AllowImgHeight = 800; 	// 允许上传的图片的高度 &#441;为无限制　单位：px(像素)
	
	ImgObj.onerror = function(){ErrMsg = '\n图片格式不正确或者图片已损坏!';}	
	function CheckExt(obj,flag){	    
	    ErrMsg = "";
		FileMsg = "";
		IsImg = false;
		if(obj.value == ""){
			return false;
		}
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();		
		if(AllImgExt.indexOf(FileExt+"|") == -1){ 
			alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);
			return false;
		}
		obj.value = getPath(obj);
		if (flag == 'l'){
			$('#bftlogo').val(flag);
	    }else{
			$('#bftfileurl').val(flag);
		}
	}
		
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form name="printBillTemplateForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="bftlogo" name="fittingTemplatePo.bftlogo">
<input type="hidden" id="bftfileurl" name="fittingTemplatePo.bftfileurl">

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                         <TR>
						   <TD width="9%" height="26" class="table_body">报表样式类型 </TD>
			               <TD class="table_none" width="20%">
                                <c:forEach var="fittingTemplateTypePoTmp" items="${fittingTemplateTypeList}" >
                              		${(fittingTemplatePo.bfttype eq fittingTemplateTypePoTmp.bfttid)? fittingTemplateTypePoTmp.bfttname :'' }                                      	
                               	</c:forEach>
			              </TD>		
						   <TD width="9%" height="26" class="table_body">报表样式名称 </TD>
			               <TD class="table_none">
                              ${fittingTemplatePo.bfttemplatename }
			              </TD>		
			              <TD width="9%" height="26" class="table_body">报表服务器</TD>
			              <TD class="table_none" width="20%">
			              	<c:choose>
			              		<c:when test="${fittingTemplatePo.bftserver eq '1'}">FineReport</c:when>
			              		<c:when test="${fittingTemplatePo.bftserver eq '2'}">ReportingService</c:when>
			              	</c:choose>
			              </TD>				              
                        </TR>                        
                        <TR>
						   <TD height="26" class="table_body">报表文件名称 </TD>
			               <TD class="table_none" colspan="5">
                               ${fittingTemplatePo.bftfilename }
			              </TD>			              
                        </TR>
                        <TR>
						   <TD width="5%" height="26" class="table_body">报表样式图 </TD>
			               <TD class="table_none" width="10%" colspan="5">
                               <img src="${ctx}${fittingTemplatePo.bftfileurl}">
			              </TD>			              
                        </TR>               
                        <TR>
						   <TD width="5%" height="62" class="table_body">报表样式说明</TD>
			               <TD class="table_none" width="50%" colspan="5">
			                  ${fittingTemplatePo.bftremark}&nbsp;
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
    <TD height=5></TD></TR></TBODY></TABLE>
    </form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>