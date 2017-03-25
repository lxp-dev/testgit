<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
</head>
<script>	

	function search(){
		 if(checkForm(document.all.smsSetForm)){
			$("img").removeAttr("onclick");
			smsSetForm.action = "updateSmsSet.action";
			smsSetForm.submit();
		}
	}
	function permissionMessage(){
       alert('您无此操作权限');
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="smsSetForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：短信维护</TD>
            <TD class=menubar_function_text align=right>
             <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
             </TR></TBODY></TABLE>
            </TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--ťStart-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      onclick="JavaScript:void(0);"
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">短信维护</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
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
                                  <TD width="6%"><div align="left"><strong>生日提醒</strong></div></TD>
                                  <TD width="94%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                     <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="15%" height="30" class="table_body">生日提醒功能</TD>
                          <TD width="35%" class="table_none">
                          <input type="checkbox" id="birthdayflag" name="birthdayflag" value="1" ${smsSetPo.fssbirthdayflag!= "1"  ? '' : 'checked="checked"' }>启动</TD>
                          <input type="hidden" id="id" name="id" value="${smsSetPo.fssid }"/>
                          <TD width="15%" class="table_body">提醒时间</TD>
                          <TD width="35%" class="table_none">
                          	顾客生日<input id="birthdaydate" name="birthdaydate" class="text_input60" value="${smsSetPo.fssbirthdaydate }" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '天应为整数！'}]">
                          	天后<input id="birthdaytime" name="birthdaytime" class="text_input60" value="${smsSetPo.fssbirthdaytime }" validate="[{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '小时应为数字！'}]">点                 提醒</TD>
                        </TR>
                        <TR>
						  <TD class="table_body">短信内容</TD>
                          <TD class="table_none" colspan="3"><textarea id="birthdaycontent" name="birthdaycontent" value="${smsSetPo.fssbirthdaycontent }"  >${smsSetPo.fssbirthdaycontent }</textarea></TD>                       
                        </TR>
                        </TBODY>
                    </TABLE>
   							  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="6%"><div align="left"><strong>到镜提醒</strong></div></TD>
                                  <TD width="94%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                     <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="15%" height="30" class="table_body">到镜提醒功能</TD>
                          <TD width="35%" class="table_none" colspan="3">
                          <input type="checkbox" id="remindflag" name="remindflag" value="1" ${smsSetPo.fssremindflag!= "1"  ? '' : 'checked="checked"' }>启动</TD>
                        </TR>
                        <TR>
						   <TD class="table_body">短信内容</TD>
                           <TD class="table_none" colspan="3"><textarea id="remindcontent" name="remindcontent" value="${smsSetPo.fssremindcontent }" >${smsSetPo.fssremindcontent }</textarea></TD>
                        </TR>
 
                        </TBODY>
                    </TABLE>
  					<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="6%"><div align="left"><strong>误期提醒</strong></div></TD>
                                  <TD width="94%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                     <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="15%" height="30" class="table_body">误期提醒功能</TD>
                          <TD width="35%" class="table_none" colspan="3">
                          <input type="checkbox" id="delaysflag" name="delaysflag" value="1" ${smsSetPo.fssdelaysflag!= "1"  ? '' : 'checked="checked"' }>启动</TD>
                        </TR>
                        <TR>
						  <TD class="table_body">短信内容</TD>
                          <TD class="table_none" colspan="3"><textarea id="delayscontent" name="delayscontent" value="${smsSetPo.fssdelayscontent }" >${smsSetPo.fssdelayscontent }</textarea></TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                      <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="6%"><div align="left"><strong>顾客回访</strong></div></TD>
                                  <TD width="94%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="15%" height="30" class="table_body">顾客回访功能</TD>
                          <TD width="35%" class="table_none">
                          <input type="checkbox" id="visitflag" name="visitflag" value="1" ${smsSetPo.fssvisitflag!= "1"  ? '' : 'checked="checked"' }>启动</TD>
                          <TD width="15%" class="table_body">提醒时间</TD>
                          <TD width="35%" class="table_none">顾客取镜
                            <input id="visitdate" name="visitdate" class="text_input60" value="${smsSetPo.fssvisitdate }" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '天应为整数！'}]"> 天后
                            <input id="visittime" name="visittime" class="text_input60" value="${smsSetPo.fssvisittime }" validate="[{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '小时应为数字！'}]">点             提醒</TD>
                        </TR>
                        <TR>
						  <TD class="table_body">短信内容</TD>
                          <TD class="table_none" colspan="3"><textarea id="visitcontent" name="visitcontent" value="${smsSetPo.fssvisitcontent }">${smsSetPo.fssvisitcontent }</textarea></TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                   <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-save' type='button' value='保存' onClick="search()"/>
							</td>
						</tr>
					</table>
                    </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src=" /img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>

