<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告维护</title>
<style type="text/css">
    img
    {
        filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);
    }
    
</style>
</head>
<script type="text/javascript">
function downupload(bnfuuid,url){
    if ($.trim(url) == ""){
        alert("文件已丢失或损坏，无法下载!");
        return;
    }
	noticeFileFrm.action="exportNoticeFile.action?bnfuuid="+bnfuuid;
	noticeFileFrm.submit();
}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="noticeFileFrm" method="post" action="" enctype="multipart/form-data">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
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
						  <TD width="8%" height="26" class="table_body">公告标题</TD>
			               <TD width="15%" class="table_none">
                            ${noticePo.bnetitle}
			               </TD>
			               <TD width="8%" height="26" class="table_body">发布日期</TD>
			               <TD width="15%" class="table_none">
			               	${noticePo.bneauditdate}
			               </TD>
			               <TD width="8%" height="26" class="table_body">发布人</TD>
			               <TD width="15%" class="table_none">
                             ${noticePo.bnepublishpersonname }
			               </TD>
                        </TR>
                        <TR>			               
			               <TD width="8%" height="26" class="table_body">附件上传</TD>
			               <TD class="table_none" colspan="7">
			               	  <table width="50%" border="0" cellpadding=1 cellspacing=1>
			               	   <s:iterator value="noticeFileList">
			               	       <tr onMouseOver="mover(this,'#cadee8')" onMouseOut=mout(this,'#e9f2f7');>
			               	           <td height="26"><a title="下载" href="javascript:downupload('${bnfuuid}','${bnfdocumenturl}')">${bnfsavefilename}</a></td>
			               	       </tr>
			               	   </s:iterator>			               	   
			               	</table>
			               </TD>
                        </TR>
                   
                        <TR>
			               <TD width="12%" height="26" class="table_body">公告内容</TD>
			               <TD width="38%" class="table_none" colspan="7">
	                           	
										${noticePo.bneaddhtml}	
							
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
