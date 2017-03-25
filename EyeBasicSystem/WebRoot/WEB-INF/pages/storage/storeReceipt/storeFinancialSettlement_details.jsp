<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收货财务结算</title>
</head>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<script>
    function closeWindow(){
		parent.hidePopWin();
		
    }

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

<form name="financialSettlementForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" />  

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
        <td width=auto align="right" valign="top">
               	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
					<s:param name="actionTypeID">13</s:param>
               		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
               		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&inventoryid=${inventoryPo.cstibillid}</s:param>
               		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&inventoryid=${inventoryPo.cstibillid}</s:param>
               		<s:param name="actionReportTitle">采购结算单打印</s:param>
               	</s:action>	        
          </TD>
        </TR>
       </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1" style='TABLE-LAYOUT: fixed'>
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">${inventoryPo.cstibillid}&nbsp;</TD>
			               <TD width="9%" height="26" class="table_body">订单编号</TD>
			               <TD width="24%" class="table_none">
			               	 ${inventoryPo.cstisourcebillid}&nbsp;
			               </TD>
						   <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none">
			               	 ${fn:substring(inventoryPo.cstibilldate,0,16)}&nbsp;
			               </TD>
                        </TR>
						<TR>
						   <TD height="26" class="table_body">所属制造商</TD>
			               <TD class="table_none"  >${inventoryPo.cstisuppliername}&nbsp;</TD>
			               <TD height="26" class="table_body">入库类型</TD>
			               <TD class="table_none">
			               <c:choose>
			               	<c:when test="${inventoryPo.cstibilltypeid=='1'}">
			               		采购收货
			               	</c:when>
			               	<c:when test="${inventoryPo.cstibilltypeid=='7'}">
			               		其他入库
			               	</c:when>
			               	<c:when test="${inventoryPo.cstibilltypeid=='9'}">
			               		委外收货
			               	</c:when>
			               	<c:otherwise>
			               		未知单据
			               	</c:otherwise>
			               </c:choose>&nbsp;</TD>
						   <TD height="26" class="table_body">接收仓位</TD>
			               <TD class="table_none">${inventoryPo.cstiinstockname}&nbsp;</TD>
                        </TR>                        
                        <TR>
			               <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">${inventoryPo.csticreatepersonname}&nbsp;</TD>
			               <TD height="26" class="table_body">入库审核人</TD>
			               <TD class="table_none">${inventoryPo.cstiauditpersonname}&nbsp;</TD>
			               <TD height="26" class="table_body">运单号</TD>
			               <TD class="table_none">&nbsp;${inventoryPo.deliveryID}&nbsp;</TD>
                        </TR>
                         <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5 style='word-WRAP: break-word'>${inventoryPo.cstiremark}&nbsp;</TD>
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
                        <TR class=table_title align=middle>                     
                          <TH scope=col width="15%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>
                          <TH scope=col width="10%">型号</TH>  
                           <TH scope=col width="8%">零售价</TH>                          
 						  <TH scope=col width="5%">数量</TH>	
 						  <TH scope=col width="10%">单位成本</TH>
						  <TH scope=col width="10%">成本合计</TH>
                          <TH scope=col width="5%">税率</TH>
						  <TH scope=col width="10%">含税单价</TH>                          
						  <TH scope=col width="10%">税额合计</TH>
						  <TH scope=col width="10%">价税合计</TH>				  
                        </TR>
                        <tr class=table_title align=middle> 
						  	<th width="40%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    	<th scope=col width="10%">&nbsp;</th>
					    	<th scope=col width="10%" id="nottaxrateamountTotal">&nbsp;</th>
					    	<th scope=col width="5%">&nbsp;</th>
					    	<th scope=col width="10%" >&nbsp;</th>					    	
					    	<th scope=col width="10%" id="taxamountTotal">&nbsp;</th>
					    	<th scope=col width="10%" id="costpriceamountTotal">&nbsp;</th>
				   		</tr>
				   		<s:iterator value="inventoryEntryList" status="idx">
	                        <TR class="row">
	                        <TD height="26">${cstiegoodsid}</TD>
	                        <TD>${cstiegoodsname}</TD>
	                        <TD>${cstiespec}</TD>
	                        <TD>${bgcretailPrice}</TD>
	                        <TD>${cstiegoodsquantity}<input type="hidden" value="${cstiegoodsquantity}" name="goodsInfoTempPo.goodsquantity"/></TD>                                               
	                        <TD>${cstienottaxrate}<input type="hidden" value="${cstienottaxrate}" name="goodsInfoTempPo.nottaxrate"/></TD>
	                        <TD>${cstienottaxrateamount}<input type="hidden" value="${cstienottaxrateamount}" name="goodsInfoTempPo.nottaxrateamount"/></TD>
	                        <TD>${cstietaxrate}<input type="hidden" value="${cstietaxrate}" name="goodsInfoTempPo.taxrate"/></TD>
	                        <TD>${cstiecostprice}<input type="hidden" value="${cstiecostprice}" name="goodsInfoTempPo.costprice"/></TD>	                        
	                        <TD>${cstietaxamount}<input type="hidden" value="${cstietaxamount}" name="goodsInfoTempPo.taxamount"/></TD>
	                        <TD>${cstiecostpriceamount}<input type="hidden" value="${cstiecostpriceamount}" name="goodsInfoTempPo.costpriceamount"/></TD>
	                        </TR>                                               
                        </s:iterator>
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
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<script>
	initPriceAmount();
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>