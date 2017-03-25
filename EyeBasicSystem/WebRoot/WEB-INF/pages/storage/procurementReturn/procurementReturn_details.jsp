<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品退货管理</title>
</head>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<script>
    $(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	
	function printBillForGoods(){
		var DataURL = "report.action?reportlet=storage_procurementReturnGoodRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&BillID="+'${inventoryPo.cstibillid}';

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}		
		document.getElementById('popupTitle').innerHTML="【门店销售业绩分析对比】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>

<form name="procurementReturnForm" method="post" action="">
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
          	 <img src="${ctx}/img/newbtn/btn_printgoods_0.png" btn=btn  title='商品退货结算单打印' onclick="printBillForGoods()"/>
             <s:action name="getFittingTemplateTypeInfo" executeResult="true">
				<s:param name="actionTypeID">26</s:param>
           		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_printbrand_0.png</s:param>
           		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&BillID=${inventoryPo.cstibillid}</s:param>
           		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&BillID=${inventoryPo.cstibillid}</s:param>
           		<s:param name="actionReportTitle">商品退货结算单打印</s:param>
             </s:action>     
          </TD>
        </TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
			               	 ${fn:substring(inventoryPo.cstibilldate,0,10)}</TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none"> ${inventoryPo.cstisuppliername}</TD>
                        </TR>                        
                        <TR>
                           <TD height="26" class="table_body">退货部门</TD>
			               <TD class="table_none"> ${inventoryPo.cstidepartmentname}</TD>
			               <TD height="26" class="table_body">发出仓位</TD>
			               <TD class="table_none">${inventoryPo.cstioutstockname}</TD>
			               <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">${inventoryPo.csticreatepersonname}</TD>
                        </TR>
                         <TR>
                          <TD class="table_body" height="26">备注</TD>
                          <TD class="table_none" colspan="5">
                           ${inventoryPo.cstiremark}&nbsp;
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
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR class=table_title align=middle>                     
                          <TH scope=col width="15%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>						
                          <TH scope=col width="10%">型号</TH>                          
 						  <TH scope=col width="5%">数量</TH>	
 						  <TH scope=col width="7%">单位成本</TH>
						  <TH scope=col width="7%">成本合计</TH>
                          <TH scope=col width="5%">税率</TH>
						  <TH scope=col width="7%">含税单价</TH>
						  <TH scope=col width="7%">税额合计</TH>	
                          <TH scope=col width="7%">价税合计</TH>
						  			  
                        </TR>
                        <tr class=table_title align=middle> 
						  	<th width="45%" height="26"  colSpan=3 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    	<th scope=col width="7%">&nbsp;</th>
					    	<th scope=col width="10%" id="nottaxrateamountTotal">&nbsp;</th>
					    	<th scope=col width="6%">&nbsp;</th>
					    	<th scope=col width="7%" >&nbsp;</th>
					    	<th scope=col width="10%" id="taxamountTotal">&nbsp;</th>
					    	<th scope=col width="10%" id="costpriceamountTotal">&nbsp;</th>
					    	
				   		</tr>
				   		<s:iterator value="inventoryEntryList" status="idx">
	                        <TR class="row">
	                        <TD height="26">${cstiegoodsid}
	                        <input type="hidden" name="goodsInfoTempPo.goodsid" value="${cstiegoodsid}" />
	                        <input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="${cstiebarcode}" />
	                        </TD>
	                        <TD>${cstiegoodsname}</TD>
	                        <TD>${cstiespec}</TD>
	                        <TD> ${cstiegoodsquantity}<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" value="${cstiegoodsquantity}" name="goodsInfoTempPo.goodsquantity" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'}]"/></TD>                                               
	                        <TD>${cstienottaxrate}<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="${cstienottaxrate}" /></TD>
	                        <TD>${cstienottaxrateamount}<input type="hidden" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" name="goodsInfoTempPo.nottaxrateamount" value="${cstienottaxrateamount}" /></TD>
	                        <TD>${cstietaxrate}<input type="hidden" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="${cstietaxrate}" /></TD>
	                        <TD>${cstiecostprice}<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="${cstiecostprice}" /></TD>
	                        <TD>${cstietaxamount}<input type="hidden" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" style="width:100%" name="goodsInfoTempPo.taxamount" value="${cstietaxamount}" /></TD> 
	                        <TD>${cstiecostpriceamount}<input type="hidden" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="${cstiecostpriceamount}" /></TD>                                                                         
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