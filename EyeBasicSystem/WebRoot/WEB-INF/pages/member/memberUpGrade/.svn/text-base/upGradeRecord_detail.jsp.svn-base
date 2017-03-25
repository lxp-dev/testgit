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
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="memberUpGradeForm" method="post" action="">
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
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   	<TD width="9%" height="26" class="table_body">会员卡号</TD>
			               	<TD class="table_none" width="25%">
                               ${upgradeRecordPo.smecumemberid}&nbsp;
			               	</TD>
			               	<TD width="9%" height="26" class="table_body">会员姓名</TD>
                      		<TD class="table_none" width="25%">
                      		   ${upgradeRecordPo.smecucustomername}&nbsp;
                      		</TD>
                      		<TD width="9%" height="26" class="table_body">升级部门</TD>
                            <TD class="table_none" width="25%">
                               ${upgradeRecordPo.smecushopcodename}&nbsp;
			               	</TD>
                        </TR>
                    	<TR>
			               	<TD height="26" class="table_body">升级人员</TD>
                        	<TD class="table_none">
                                 ${upgradeRecordPo.smecupersonname}&nbsp;
                        	</TD>
                        	<TD height="26" class="table_body">升级日期</TD>
                        	<TD class="table_none">
                                 ${upgradeRecordPo.smecuupgradedate}&nbsp;
                        	</TD>
                        	<TD height="26" class="table_body">升级前会员卡类型</TD>
                        	<TD class="table_none">
                                 ${upgradeRecordPo.smecucurrentcardname}&nbsp;
                        	</TD>
                        </TR>
                        <TR>
			               	<TD height="26" class="table_body">升级前积分</TD>
                        	<TD class="table_none">
                                 ${upgradeRecordPo.smecucurrentintegral}&nbsp;
                        	</TD>
                        	<TD height="26" class="table_body">升级后会员卡类型</TD>
                        	<TD class="table_none">
                                 ${upgradeRecordPo.smeculastcardname}&nbsp;
                        	</TD>
                        	<TD height="26" class="table_body">扣除积分</TD>
                        	<TD class="table_none">
                                 ${upgradeRecordPo.smecuintegralchange}&nbsp;
                        	</TD>
                        </TR>
                        <TR>
			               	<TD height="26" class="table_body">升级后积分</TD>
                        	<TD class="table_none">
                                 ${upgradeRecordPo.smeculastintegral}&nbsp;
                        	</TD> 
                        	<TD height="26" class="table_body">升级类型</TD>
                        	<TD class="table_none" colspan="3">
                                 <c:choose>
                                     <c:when test="${upgradeRecordPo.smecuflag eq 1}">积分升级</c:when>
                                     <c:when test="${upgradeRecordPo.smecuflag eq 2}">直接升级</c:when>
                                     <c:when test="${upgradeRecordPo.smecuflag eq 3}">自动升级</c:when>
                                     <c:otherwise>&nbsp;</c:otherwise>
                                 </c:choose>
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