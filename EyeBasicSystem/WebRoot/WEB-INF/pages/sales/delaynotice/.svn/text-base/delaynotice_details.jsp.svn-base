<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜单维护</title>
</head>
<script>	
</script>
<body>
<form name="delayNoticeForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="S1101">
<input type="hidden" name="customerID" value="">

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
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top>
                <DIV id=tabContent__1>
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
                          <TD width="8%" height="26" class="table_body">配镜单号</TD>
                          <TD width="24%" class="table_none">
                          	${delayNoticePo.smednsalesid }
                          </TD>
                          <TD width="8%"  class="table_body">顾客姓名</TD>
                          <TD width="24%" class="table_none">
                          	${delayNoticePo.smedncustomername }
                          </TD>
                          <TD width="8%" class="table_body">销售门店</TD>
                          <TD class="table_none">
                          	${delayNoticePo.smednsshopcodename }
                          </TD>
                        </TR> 
                        <TR>
                          <TD height="26" class="table_body">配镜时间</TD>
                          <TD class="table_none">
                            ${fn:substring(delayNoticePo.smednsalesdatetime,0,16) }
                          </TD>
                          <TD height="26" class="table_body">取镜门店</TD>
                          <TD class="table_none">
                          	${delayNoticePo.smednqshopcodename }
                          </TD>
                          <TD height="26" class="table_body">取镜时间</TD>
                          <TD class="table_none">
                            ${fn:substring(delayNoticePo.smedntakedatetime,0,16) }
                          </TD>
                        </TR>
                        
                        <TR>
                          <TD height="26" class="table_body">通知人</TD>
                          <TD class="table_none" colspan="5">
                            ${person.personName }
                          </TD>
                        </TR>
                        
                        <TR>
                          <TD height="26" class="table_body">反馈内容</TD>
                          <TD class="table_none" colspan="5" height="62">
                            ${delayNoticePo.smednmessage }&nbsp;
                          </TD>
                        </TR>
                        
                        </TBODY>
                    </TABLE>
                  </DIV>
                  </TD>
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
