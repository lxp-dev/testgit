<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城管理</title>
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
		$("input[clean=clean]").val("");
	}
	
	function save(){
		if(checkForm(document.all.mallBrandForm)){	
			$("img").removeAttr("onclick");   
			mallBrandForm.action = "updateMallBrandPo.action";
			mallBrandForm.submit();
		}
	}
</script>
<%@ include file="/commons/uploadFile.jsp" %>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="mallBrandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
						 <TD class="table_body" width="10%" height="26" >商品品种名称</TD>
			             <TD class="table_none" colspan="5">
			               <input class="text_input400" id="mbname" name="mallBrandPo.mbname" maxlength="50" value="${mallBrandPo.mbname }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品品种名称不能为空！'}]">
			               <input type="hidden" name="mallBrandPo.mbid" value="${mallBrandPo.mbid }" />
			               <label style="color:red;">&nbsp;*&nbsp;</label>
						 </TD>
						</TR>
						<TR>
						  <TD class="table_body" height="26">商品品种图</TD>
						  <td class="table_none">
                            <input type="hidden" class="text_input300" name="mallBrandPo.mbpicurl" id="mbpicurl" value="${mallBrandPo.mbpicurl2}" readonly="readonly"/>
                            <input type="button" onclick="startLoad('/upload/mall','1','mbpicurl','mbpicurlDiv','320','160','update')" value="图片上传"/>
                            <label style="color:red;">(图片大小建议为640*320。)&nbsp;</label>
                          </td>
                        </TR> 
                        <TR>
						  <TD class="table_body" height="26">图片预览</TD>
						  <td class="table_none">
                            <div id="mbpicurlDiv">
				               	<c:if test="${mallBrandPo.mbpicurl ne ''}" >
				               		<p><img src="${ctx}${mallBrandPo.mbpicurl}" width="320" height="160" border="0" title='点击查看大图' width2="640" height2="320" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${mallBrandPo.mbpicurl}","mbpicurl");>删除</a></p>
				               	</c:if>
			               	</div>                            
                          </td>
                        </TR>						
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
                        	  <!--<img src="${ctx}/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">-->
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