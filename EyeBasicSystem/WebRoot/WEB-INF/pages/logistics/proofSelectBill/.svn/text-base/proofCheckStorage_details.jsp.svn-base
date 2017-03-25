<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>凭证管理</title>
</head>
<script>

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	procurementReceiptForm.action=link;
	  	procurementReceiptForm.submit();
	}
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR height="26">
                          <TD width="9%" class="table_body" >单据编号</TD>
                          <TD width="24%" class="table_none">${overagelossesPo.cstibillid}</TD>
                          <TD width="9%" class="table_body">盘点单号</TD>
                          <TD width="24%" class="table_none">${overagelossesPo.cstisourcebillid }</TD>
                          <TD width="9%" class="table_body" >制单日期</TD>
                          <TD width="24%" class="table_none">${fn:substring(overagelossesPo.cstibilldate,0,10)}</TD>  
						  
                        </TR>
						<TR  height="26">						                        
                          <TD class="table_body">所属部门</TD>
						  <TD class="table_none">${overagelossesPo.cstidepartmentname}</TD>
						<c:choose>
                          	<c:when test="${overagelossesPo.cstibilltypeid==5}">
                          	<TD class="table_body" height="30">收入仓位</TD>
                          	<TD class="table_none">${overagelossesPo.cstiinstockname}</TD>
                          	</c:when>
                          	<c:when test="${overagelossesPo.cstibilltypeid==6}">
                          	<TD class="table_body" height="30">发出仓位</TD>
                          	<TD class="table_none">${overagelossesPo.cstioutstockname}</TD>
                          	</c:when>
                          </c:choose>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${overagelossesPo.csticreatepersonname}</TD>
                        </TR>
                        <TR height="26">
                          <TD class="table_body" >审核人</TD>
                          <TD class="table_none" colspan="5">
                           ${overagelossesPo.cstiauditpersonname}&nbsp;
                          </TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5>
                          ${overagelossesPo.cstiremark}
                          </TD>
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
                    <c:if test="${not empty(inventoryEntryList)}">
                    <c:set value="0" var="quantity" scope="page" />
                    <c:set value="0" var="amount" scope="page" />

					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                     
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH width="6%" scope=col>单位</TH>                          
                          <TH width="7%" scope=col>数量</TH>
                          <TH width="7%" scope=col>单位成本</TH>
                          <TH width="7%" scope=col>成本</TH>
                        </TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <TR class="row">
                        <TD height="26">${cstiegoodsid}</TD>
                        <TD>${cstiegoodsname}</TD>
                        <TD>${cstiespec}</TD>
                        <TD>${cstieunitname}</TD> 
						<TD>${cstiegoodsquantity}<c:set value="${quantity +  cstiegoodsquantity}" var="quantity" scope="page" /></TD>                      
                        <TD>${cstienottaxrate}</TD>
                        <TD>${cstienottaxrateamount}<c:set value="${amount +  cstienottaxrateamount}" var="amount" scope="page" /></TD>
                        </TR>
                        </s:iterator>
                        <TR class=table_title align=middle>
                          <TH height="26" width="10%" scope=col></TH>
                          <TH width="30%" scope=col></TH>
						  <TH width="8%"></TH>
                          <TH width="8%">合计:</TH>
                          <TH width="5%" scope=col>${quantity }</TH>
                          <TH width="5%" scope=col>&nbsp;</TH>
						  <TH width="5%" scope=col><fmt:formatNumber value="${amount }" pattern="0.00"/></TH>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
                    </c:if>
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