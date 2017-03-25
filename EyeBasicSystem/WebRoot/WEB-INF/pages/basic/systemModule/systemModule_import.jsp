<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统模块维护</title>
</head>
<script>	
	function save(){

        if ($('#file').val() == ''){
            alert("请选择需要上传的文档!");
            return;
        }
        if (!CheckExt(document.getElementById('file'))){
            return;
        }
        if (confirm("确认导入模块权限信息? " )){
        	moduleSystemForm.action = "importSystemModule.action";
        	moduleSystemForm.submit();
            
            showLoadingBar();
        }

	}
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
           	}
	    	return obj.value;
		}
	}	
	var AllImgExt = ".xls";
	var FileExt;
	function CheckExt(obj){
		if(obj.value == ""){
			return false;
		}
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();		
		if(AllImgExt.indexOf(FileExt) != -1){
	        obj.value = getPath(obj);
            return true;

		}else{
			alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);
			return false;
		}		
	}	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="moduleSystemForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
          <br/>
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
                        <tr>
                        	<TD width="20%" height="26" class="table_body">文档路径</TD>
			               	<TD width="80%" class="table_none">
			               	<input type="file" name="upload" id="file" style="width: 600" ><label style="color:red;">&nbsp;*&nbsp;文件格式为 .xls </label>
			               	</TD>
                        </tr>
                      </TBODY>
                    </TABLE>
 		
					<TABLE id="searchBar" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><input icon='icon-save' id="submitButton" type='button' value='保存' onclick="save();" >
                        	<input icon='icon-reload' type="reset" value='清除' >
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
				<table id="loadingBar" width="100%" STYLE="display:none">
				  <tr><td height="10">&nbsp;</td></tr>
				  <tr>                         
				    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
				    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
					<script>
						function showLoadingBar(){
							document.getElementById("searchBar").style.display="none";
							document.getElementById("loadingBar").style.display="";
						}
					</script>                            
				    </td>
				</tr>
				</table>                      
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>