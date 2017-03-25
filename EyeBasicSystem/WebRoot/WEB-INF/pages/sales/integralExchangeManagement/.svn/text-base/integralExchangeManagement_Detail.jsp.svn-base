<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script type="text/javascript" src="${ctx}/js/printBarCode.js" ></script>

<title>积分兑换详细</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="otherReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 


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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">兑换积分单号</TD>
                          <TD width="24%" class="table_none">${integralExchangePo.filuuid}</TD>
                          <TD width="9%" class="table_body">会员卡号</TD>
                          <TD width="24%" class="table_none">${integralExchangePo.filmemberid}</TD>
						  <TD width="9%" class="table_body" height="26">会员姓名</TD>
                          <TD class="table_none">${integralExchangePo.filcustomername}</TD>                          
						</TR>
						<TR>
						  <TD class="table_body">兑换积分数</TD>
						  <TD class="table_none">${integralExchangePo.filintegralnumber}</TD>
                          <TD class="table_body" height="26">兑换人</TD>
                          <TD class="table_none">${integralExchangePo.filpersonname}</TD>
                          <TD class="table_body">兑换时间</TD>
                          <TD class="table_none" >${fn:substring(integralExchangePo.fildatetime,0,16)}</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle> 
                       	 <TH width="20%" height="26" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>兑换积分</TH>
                          <TH width="20%" scope=col>兑换数量</TH>                     
                        </TR>
                        
                        <s:iterator value="integralExchangeEntryList" status="idx">
						  <c:choose>
                          	<c:when test="${goodsID==filegoodsid}">
	                    		<TR id="rowrow" class="row" style="background-color: red">
	                    	</c:when>
	                    	<c:otherwise>
	                    		<TR id="rowrow" class="row">
	                    	</c:otherwise>
                          </c:choose>                
                        <TD height="26">${filegoodsid}</TD>
                        <TD>${filegoodsname}</TD>
                        <TD>${fileintegralCount}</TD>
                        <TD>${filegoodsnumber}</TD>
                     </TR>
                        </s:iterator>
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