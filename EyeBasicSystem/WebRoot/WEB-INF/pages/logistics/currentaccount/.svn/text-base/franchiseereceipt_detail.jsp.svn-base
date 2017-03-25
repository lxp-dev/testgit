<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>往来账查询</title>
<script type="text/javascript">
	
	/**
	 *  自动计算相关数据
	 */	       
	 function amount(){
		$('#bgnAmount').text(parseFloat($('#bgnAmount').text()).toFixed(2));
		$('#endAmount').text(parseFloat($('#endAmount').text()).toFixed(2));
	}
	
	$(document).ready(function(){    		 
         amount();
	});
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form id="voucherDetailFrm" action="" method="post">
	<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                          <TD width="9%" class="table_body" height="26">客户编号</TD>
                          <TD width="24%" class="table_none">${franchiseeID}
                          <input type="hidden" id="franchiseeID" name="franchiseeID" value="${franchiseeID}" />
                          <input type="hidden" id="startDate" name="startDate" value="${startDate}" />
                          <input type="hidden" id="endDate" name="endDate" value="${endDate}" />
						  </TD>
                          <TD width="9%" class="table_body">客户名称</TD>
                          <TD width="24%" class="table_none">${franchiseeName}</TD>
                          <TD width="9%" class="table_body">查询日期</TD>
                          <TD width="24%" class="table_none" colspan="3">${startDate} -- ${endDate}</TD>
                        </TR>

                      </TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                          <TR>
                            <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20"></div></TD>
                            <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                          </TR>
                       </TBODY>
                    </TABLE>
              
              		<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26">选择</TH>
                          <TH width="10%" scope=col>单据日期</TH>
						  <TH scope=col width="18%">单据编号</TH>					
                          <TH scope=col width="8%">单据类型</TH>  
                          <TH width="10%" scope=col>单据金额</TH>
                          <TH scope=col width="10%">回款金额</TH>                        
 						  <TH scope=col width="10%">应收余额</TH>	
                        </TR>
                        <tr class=table_title align=middle> 
						  	<th height="26"  colSpan=6 scope=col align="right">期初金额：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="10%" id="bgnAmount">${inventoryPo.csticostpriceamount }</th>
           				</tr>
                        <s:iterator value="inventoryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk"></TD>                        
                          <TD>${cstibilldate}</TD>
                          <TD>${cstibillid}</TD>
			              <TD>${cstibilltypeid}</TD>
			              <TD>${csticostpriceamount}</TD>
			              <TD>${payMentAmount}</TD>
			              <TD>${notPayMentAmount}</TD>                        
                         </TR>
                        </s:iterator>
                        <tr class=table_title align=middle> 
						  	<th height="26" colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="10%" id="endAmount">${inventoryPo.notPayMentAmount }</th>
           				</tr>
                      </TBODY>
                    </TABLE>

                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>