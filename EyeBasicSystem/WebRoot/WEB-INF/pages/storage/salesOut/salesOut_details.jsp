<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>销售出库管理</title>
</head>
<script>
    $(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 

        var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
 		var goodsquantityTotal = 0;
 		for(i=0;i<goodsquantity.length;i++){
 			if(goodsquantity[i].value == '') continue;
 			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
 		} 		
 		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;

        var costpriceamount = document.getElementsByName("goodsInfoTempPo.costpriceamount");
 		var costpriceamountTotal = 0;
 		for(i=0;i<costpriceamount.length;i++){
 			if(costpriceamount[i].value == '') continue;
 			costpriceamountTotal = (parseFloat(costpriceamountTotal).add(parseFloat(costpriceamount[i].value))).toFixed(2);
 		} 		
 		$('#costpriceamountTotal').text(parseFloat(costpriceamountTotal).toFixed(2));
	});

</script>
 <script>
	// initPriceAmount();
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>

<form name="salesOutForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD align="right" colspan="3">
             <s:action name="getFittingTemplateTypeInfo" executeResult="true">
				<s:param name="actionTypeID">24</s:param>
           		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
           		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&BillID=${inventoryPo.cstibillid}</s:param>
           		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&BillID=${inventoryPo.cstibillid}</s:param>
           		<s:param name="actionReportTitle">销售出库单打印</s:param>
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">${inventoryPo.cstibillid}</TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD width="24%" class="table_none">
			               	 ${fn:substring(inventoryPo.cstibilldate,0,16)}</TD>
			               <TD width="9%" height="26" class="table_body">制单人</TD>
			               <TD width="24%" class="table_none">${inventoryPo.csticreatepersonname}</TD>
                        </TR>                        
                        <TR>
                           <TD height="26" class="table_body">销售部门</TD>
			               <TD class="table_none"> ${inventoryPo.cstidepartmentname}</TD>
			               <TD height="26" class="table_body">发出仓位</TD>
			               <TD class="table_none" colspan="3">${inventoryPo.cstioutstockname}</TD>
                        </TR>
                         <TR>
                          <TD class="table_body" height="62">备注</TD>
                          <TD class="table_none" colspan="5">
                           ${inventoryPo.cstiremark}&nbsp;
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${systemParameterPo.fspsalestype eq '0'}">
                       <br/>
                       <font color="red" style="font-family: 微软雅黑">商品信息如果为红色,则表示该商品库存不足,不能完成商品出库操作!</font>
                       <br/><br/>
                    </c:if> 
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
 						  <TH scope=col width="5%">数量</TH>	
 						  <c:if test="${permissionPo.keyf == 1}">	
 						  <TH scope=col width="8%">单位成本</TH>
						  <TH scope=col width="8%">成本合计</TH>
						  
                          <TH scope=col width="5%">税率</TH>
						  <TH scope=col width="8%">销售单价</TH>
						  <TH scope=col width="8%">销售金额</TH>					  
                         </c:if>
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH scope=col width="8%">商品条码</TH>
                          </c:if>
                        </TR>
                          <tr class=table_title align=middle> 
						  	<th width="45%" height="26"  colSpan=3 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    <c:if test="${permissionPo.keyf == 1}">	
					    	<th scope=col width="7%">&nbsp;</th>
					    	<th scope=col width="10%" id="nottaxrateamountTotal">&nbsp;</th>
					    	<th scope=col width="6%">&nbsp;</th>
					    	<th scope=col width="7%" >&nbsp;</th>
					    	<th scope=col width="10%" id="costpriceamountTotal">&nbsp;</th>
					    </c:if> 
					    <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">	
					    	<th scope=col width="7%">&nbsp;</th></c:if>
				   		</tr>
                        <s:iterator value="inventoryEntryList" status="idx">
                            <TR id="rowrow" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${systemParameterPo.fspsalestype eq '0' && cstieoutstorageflag eq '0' ? 'style="color: red"' : '' }>
	                        <TD height="26">${cstiegoodsid}</TD>
	                        <TD>${cstiegoodsname}</TD>
	                        <TD>${cstiespec}</TD>
	                        <TD>${cstiegoodsquantity}<input type="hidden" onchange="autoCountOnlyOne(this);" value="${cstiegoodsquantity}" name="goodsInfoTempPo.goodsquantity"/></TD>  
	                        <c:if test="${permissionPo.keyf == 1}">	                      
	                        <TD>${cstienottaxrate}<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="${cstienottaxrate}" /></TD>
	                        <TD>${cstienottaxrateamount}<input type="hidden" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" name="goodsInfoTempPo.nottaxrateamount" value="${cstienottaxrateamount}" onchange="autoCountOnlyOne(this);"/></TD>
	                        
	                        <TD>${cstietaxrate}<input type="hidden" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="${cstietaxrate}" /></TD>
	                        <TD>${cstiecostprice}<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="${cstiecostprice}" /></TD>
	                        <TD>${cstiecostpriceamount}<input type="hidden" readOnly="readonly" onchange="remove();" style="background-color:#ACA899;width:100%" name="goodsInfoTempPo.costpriceamount" value="${cstiecostpriceamount}" /><input type="hidden" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" style="width:100%" name="goodsInfoTempPo.taxamount" value="${cstietaxamount}" /></TD>
	                      </c:if>
	                      <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	                          <TD>${cstiebarcode }</TD>
					      </c:if>                                                                      
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>