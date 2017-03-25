<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代金券详细</title> 
</head>
<script>


</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}" >

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						    <TD width="8%" height="26" class="table_body">代金券号</TD>
			                <TD width="23%" class="table_none">
			                <input type="hidden" id="bccid" value="${cashCouponPo.bccid}" name="cashCouponPo.bccid">
                            ${cashCouponPo.bcccard}<input type="hidden" id="bcccard" value="${cashCouponPo.bcccard}" name="cashCouponPo.bcccard">
			               </TD>
			               <TD width="8%" height="26" class="table_body">代金券金额</TD>
			               <TD class="table_none" valign="middle" width="23%">
                            ${cashCouponPo.bccamount}
                            </TD>
			               <TD width="8%" height="26" class="table_body">有效期</TD>
			               <TD class="table_none" valign="middle" width="23%">
                            ${cashCouponPo.bccbegindate}至${cashCouponPo.bccenddate}
                            </TD>			                
			             </TR>
			             <TR>
						    <TD height="26" width="8%" class="table_body">消费类型</TD>
			                <TD class="table_none" >
                               ${cashCouponPo.bcctypename}
			                </TD>
			                <TD width="8%" height="26" class="table_body">使用限制</TD>
			                <TD width="23%" class="table_none" valign="middle" colspan="3">
                            	${cashCouponPo.bccexpense}&nbsp;元之上使用
                           
                            </TD>
			             </TR>
			             <TR>
						    <TD width="8%" height="26" class="table_body">备注</TD>
			                <TD class="table_none" colspan="5">
			                	${cashCouponPo.bccmark}&nbsp;
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