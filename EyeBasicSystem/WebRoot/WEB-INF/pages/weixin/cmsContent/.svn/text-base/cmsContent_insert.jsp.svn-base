<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章新增</title>
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
	
	function save(){
		if(checkForm(document.all.cmsForm)){	
			$("img").removeAttr("onclick");   
			cmsForm.action = "insertWeiXinCmsContentPo.action?departmentID=${departmentID}";
			cmsForm.submit();
		}
	}

</script>
<%@ include file="/commons/uploadFile.jsp" %>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="cmsForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
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
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>   
                        <TR>
						 <TD class="table_body" width="10%" height="26">文章类型</TD>
			             <TD class="table_none">
						  	<select id="wsctype" name="weiXinCmsContentPo.wcmsctypeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '文章类型不能为空！'}]">
						  		<option value="">----请选择----</option>
						  		<s:iterator value="weiXinCmsTypeList">
								<option value="${wcmstid}">${wcmstname}</option>
	     	               		</s:iterator>
							</select>
							<label style="color:red;">&nbsp;*&nbsp;</label>
						 </TD>
						</TR>    
                        <TR>
						  <TD class="table_body" height="26">文章标题</TD>
                          <TD class="table_none"><input class="text_input400" id="wcmsctitle" name="weiXinCmsContentPo.wcmsctitle" value="${weiXinCmsContentPo.wcmsctitle }" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '文章标题不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [201]}, 'Message' : '文章标题不能大于100字！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
                        </TR> 
                        <TR>
						  <TD class="table_body" height="26">文章描述</TD>
                          <TD class="table_none"><input class="text_input400" id="wcmscdescription" name="weiXinCmsContentPo.wcmscdescription" value="${weiXinCmsContentPo.wcmscdescription }" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [201]}, 'Message' : '文章描述不能大于100字！'}]"></TD>
                        </TR>                         
                        <TR>
						  <TD class="table_body" height="26">标题图片</TD>
						  <td class="table_none">
                            <input type="text" class="text_input300" name="weiXinCmsContentPo.wcmscpicurl" id="wcmscpicurl" value="${weiXinCmsContentPo.wcmscpicurl2}" readonly="readonly"/>
                            <input type="button" onclick="startLoad('/upload/weixin','1','wcmscpicurl','wcmscpicurlDiv','320','160','update')" value="图片上传"/>
                            <label style="color:red;">(如果作为第一条图文的图片大小建议为640*320，用于其他图文的图片大小建议为80*80。)&nbsp;</label>
                            &nbsp;<input id="picisshow" name="picisshow" type="checkbox" value="1" ${(weiXinCmsContentPo.wcmscpicisshow eq '1' ? 'checked=checked':'')}>&nbsp;内容体是否显示
                          </td>
                        </TR> 
                        <TR>
						  <TD class="table_body" height="26">图片预览</TD>
						  <td class="table_none">
                            <div id="wcmscpicurlDiv"/>
                          </td>
                        </TR>                                                  
                        <TR>
		               	 <TD height="50" class="table_body">文章内容</TD>
			              <TD class="table_none">
		               		<FCK:editor   instanceName="content" height="300px" width="100%">
								<jsp:attribute name="value">
									${weiXinCmsContentPo.wcmsccontent}
								</jsp:attribute>
							</FCK:editor>
                          </TD>
                        </TR>  
                        <TR>
                          <TD>
                          	<li class="horizontal_onlyRight"><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()"></li>
                          	<li class="horizontal_onlyRight"><input id="stateFlag" name="stateFlag" type="checkbox" value="1"></li>发布
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