<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

	function save(){
		if(checkForm(mallTypeSmallPicForm)){
			$("img").removeAttr("onclick");
			mallTypeSmallPicForm.action = "updateMallTypeSmallPic.action";
			mallTypeSmallPicForm.submit();
		}
	}
</script>
<%@ include file="/commons/uploadFile.jsp" %>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mallTypeSmallPicForm" method="post" action="">
<input type="hidden" name="hid" value="${hid}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<div id="removeuuid"></div>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            </TD>					
			  </TR>
        <TR>
          <TD bgColor=#ffffff><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
            <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
                            <TD width="5%" height="26" class="table_body">商品名称</TD>
                            <TD width="95%" class="table_none">
                              ${mallTypeSmallPo.mtsname }
                              <input type="hidden" id="mtsid" name="mallTypeSmallPo.mtsid" value="${mallTypeSmallPo.mtsid}"/>
                              <input type="hidden" class="text_input400" name="mallTypeSmallPo.mtspicurls" id="mtspicurls" value="${mallTypeSmallPo.mtspicurls}" readonly="readonly"/>
                            	<input type="button" onclick="startLoad('/upload/mall','100','mtspicurls','mtspicurlsDiv','300','200','insert')" value="图片上传"/>
                            	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" onclick="save();" title='保存'>
                            </TD>
                          </TR>
                          <TR>
                            <TD width="10%" height="26" class="table_body">导航图片</TD>
                            <TD width="23%" class="table_none" colspan="5">
                            <div id="mtspicurlsDiv">
                              <s:iterator value="mallTypeSmallPicList" var="mallTypeSmallPicPo">
                                <p><img src="${ctx}${mallTypeSmallPicPo.mtsppicUrl}" width="300" height="200" title='点击查看大图' onclick="imgclick(this)" width2="600" height2="400" style="cursor: hand;" border="0"/><a style='cursor:hand' onclick=deleteServerFile(this,"${mallTypeSmallPicPo.mtsppicUrl}","mtspicurls");>删除</a></p>
                              </s:iterator>
                            </div>
                            </TD>
                          </TR>
                      </TABLE>
                      <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TBODY>
                          <TR>
                            <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" onclick="save();" title='保存'></TD>
                          </TR>
                        </TBODY>
                      </TABLE>
                    </DIV>
                </DIV>
                    <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
              </TR>
            </TBODY>
          </TABLE></TD>
        </TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>