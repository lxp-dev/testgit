<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>仓库管理</title>
</head>
<script>	

	function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("sxhsumnum");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		if(document.getElementById("goodsquantityTotal")!=null){
			document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
		}

	}
	
	$(document).ready(function() { 
		amount();
	});

	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
			$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
			$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	function search(){
	    $("img").removeAttr("onclick");
	    procurementReceiptForm.action = "selStockSearchLs.action";
	    procurementReceiptForm.submit();		
		showLoadingBar();
	}

	function clean(){
	    $('input[clean=clean]').each(function(){
            $(this).val('');
		});
	    $('select[clean=clean]').each(function(){
            $(this).val('');
		});
	}	
	function details(uuid,changeid,tflag){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectStockEntry.action?hid="+ uuid +"&changeid="+changeid+"&moduleID="+'${requestScope.moduleID}&bgiwarehouseid=${requestScope.bgiwarehouseid}&tflag='+tflag,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectStockEntry.action?hid="+ uuid +"&changeid="+changeid+"&moduleID="+'${requestScope.moduleID}&bgiwarehouseid=${requestScope.bgiwarehouseid}&tflag='+tflag,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品明细】";
	}
	
	function vdetails(billid,billtype,goodstype){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(billtype == 'PIN'){
			if(is_iPad()){ 
				showPopWin("procurementReceiptDetails.action?hid="+billid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("procurementReceiptDetails.action?hid="+billid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【采购收货详细】";
			return;
		}
		
		if(billtype == 'POUT'){
			if(is_iPad()){
				showPopWin("initProcurementReturnStorageDetails.action?hid="+billid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initProcurementReturnStorageDetails.action?hid="+billid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【商品退货单详细】";
			return;
		}
		
		if(billtype == 'SOUT'){
			if(is_iPad()){
				showPopWin("initSalesOutDetails.action?hid="+billid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initSalesOutDetails.action?hid="+billid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【销售出库详细】";
			return;
		}
		
		if(billtype == 'ALL'){
			if(is_iPad()){
				showPopWin("allocationDetails.action?hid="+billid+"&moduleID="+$('#moduleID').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("allocationDetails.action?hid="+billid+"&moduleID="+$('#moduleID').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【调拨单详细】";
			return;
		}
		
		if(billtype == 'SCI' || billtype == 'SCO'){
			if(is_iPad()){
				showPopWin("initOveragelossesDetails.action?moduleID=${requestScope.moduleID}&hid="+billid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initOveragelossesDetails.action?moduleID=${requestScope.moduleID}&hid="+billid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【盘盈盘亏单详细】";
			return;
		}
		
		if(billtype == 'OTI'){
			if(is_iPad()){
				showPopWin("otherReceiptDetails.action?hid="+billid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("otherReceiptDetails.action?hid="+billid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			
			document.getElementById('popupTitle').innerHTML="【其他入库详细】";
			return;
		}
		
		if(billtype == 'OTO'){
			if(is_iPad()){
				showPopWin("returnOtherDatabaseManagementDetails.action?hid="+billid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("returnOtherDatabaseManagementDetails.action?hid="+billid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【其他出库详细】";
			return;
		}
		
		if(billtype == 'CPIN'){
			if(is_iPad()){
				showPopWin("consignProcessTakeDetails.action?hid="+billid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("consignProcessTakeDetails.action?hid="+billid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			
			document.getElementById('popupTitle').innerHTML="【委外收货详细】";
			return;
		}
		
		if(billtype == 'SG'){
			if(is_iPad()){
				showPopWin("initStoreGoodsDetails.action?hid="+billid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initStoreGoodsDetails.action?hid="+billid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【客户批发调货详细】";
			return;
		}
		
		if(billtype == 'SR'){
			if(is_iPad()){
				showPopWin("initStoreReturnGoodsDetails.action?hid="+billid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initStoreReturnGoodsDetails.action?hid="+billid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【客户批发退货详细】";
			return;
		}
		
		if(billtype == 'DH'){
			if(is_iPad()){
				showPopWin("selIntegralExchangeManagementDetail.action?hid="+billid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("selIntegralExchangeManagementDetail.action?hid="+billid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【积分兑换详细】";
			return;
		}
		
		if(billtype == 'X'){
			if(is_iPad()){
				showPopWin("selectGoodsOut.action?hid="+billid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selectGoodsOut.action?hid="+billid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【配镜单详细】";
			return;
		}
		
		if(billtype == 'TOUT'){
			if(is_iPad()){
				showPopWin("initTakeOutDetails.action?hid="+billid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initTakeOutDetails.action?hid="+billid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【领用出库详细】";
			return;
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="bgiwarehouseid" value="${requestScope.bgiwarehouseid}">
<input type="hidden" name="bgigoodsid" value="${requestScope.bgigoodsid}">
<input type="hidden" name="goodsCategoryID" value="${goodsCategoryID}">
<input type="hidden" name="supplierID" value="${supplierID}">
<input type="hidden" name="brandID" value="${brandID}">
<input type="hidden" name="sph" value="${sph}">
<input type="hidden" name="cyl" value="${cyl}">
<input type="hidden" name="isCustomize" value="${isCustomize}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD>
                       <c:if test="${bgigoodsid ne '' }">
		                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
		                    <TBODY>
		                    <TR>
	                      <TD width=3><IMG id=tabImgLeft__0 height=22 
	                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
	                      <TD class=tab id=tabLabel__0 
	                      background=${ctx}/img/pic/tab_unactive_bg.gif 
	                      onClick="JavaScript:window.location.href='selectStockGoodsinfoPo.action?moduleID=${requestScope.moduleID}&bgigoodsid=${bgigoodsid }&bgiwarehouseid=${bgiwarehouseid }' ;"
	                      UNSELECTABLE="on">商品信息</TD>
	                      <TD width=3><IMG id=tabImgRight__0 height=22 
	                        src="${ctx}/img/pic/tab_unactive_right.gif" 
	                      width=3></TD></TR></TBODY></TABLE></TD>
                       </c:if>   
                      
                      <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存流水</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                      <!--    
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存综合查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                      width=3></TD>  --> 
                     </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD class="table_body" width="9%" height="26">变更单据</TD>
                          <TD class="table_none" width="32%"><input class="text_input160" clean=clean id="billID" name="billID" value="${billID }"></TD>
                          <TD class="table_body" width="10%">变更日期</TD>
                          <TD class="table_none"> <li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" clean=clean 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 <input id="endTime"
					       name="endTime" clean=clean 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /></li>
					        <li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('startTime','endTime')">
							</li>
							<li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_month_0.png" btn=btn title="当月" onClick="currtMonth('startTime','endTime')"></li>	
					      </TD>
                        </TR>  
                      </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="javascript:search()">
                            <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()" >
						</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("loadingBar").style.display="";
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->

					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </table>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                      
                          <TH width="12%" height="26" scope=col>商品代码</TH>
                          <TH width="12%" height="26" scope=col>商品条码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH width="13%" scope=col>变更单据</TH>
                          <TH width="8%" scope=col>单据类型</TH>
                          <TH width="10%" scope=col>变更时间</TH>
                          <TH width="10%" scope=col>仓位</TH>
                          <TH width="9%" scope=col>数量</TH>
						</TR>
						<TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=7 scope=col align="right">期初数量：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%">${firstStock }&nbsp;</TH>
				   		</TR>
				   <c:if test="${not empty(goodsDetailsList)}"> 		
						<TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=7 scope=col align="right">页内合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>  
						<s:iterator value="goodsDetailsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">${sxhGoodsId}</TD>
                          <TD>${sxhGoodsBarCode}</TD>
                          <TD>${sxhGoodsName}</TD>
                          <TD>
                          <c:choose>
	                    	<c:when test="${sxhchangeid == 'import'}">
	                    		初始化库存
	                    	</c:when>
	                    	<c:otherwise>
	                    		<a href="#" onClick="javascript:details('${sxhinvisibletype}','${sxhchangeid}','${sxhsalesbillflag}')">${sxhchangeid}</a>
	                    	</c:otherwise>
                          </c:choose>
                          </TD>
                          <TD>
                          
                          <c:choose>
	                    	<c:when test="${fn:substring(sxhchangeid,0,3) == 'PIN'}">
		                    	<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,3)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
		                    	采购收货单
		                    	</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,4) == 'POUT'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,4)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		采购退货单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,4) == 'SOUT'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,4)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		销售出库单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,3) == 'ALL'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,3)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		调拨单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,3) == 'SCI'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,3)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		盘盈单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,3) == 'SCO'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,3)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		盘亏单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,3) == 'OTI'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,3)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		其他入库单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,3) == 'OTO'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,3)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		其他出库单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,4) == 'CPIN'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,4)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		委外收货单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,2) == 'SG'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,2)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		客户批发调货单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,2) == 'SR'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,2)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		客户批发退货单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,2) == 'DH'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,2)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		门店积分兑换单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,1) == 'X'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,1)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		配镜单
	                    		</a>
	                    	</c:when>
	                    	<c:when test="${fn:substring(sxhchangeid,0,4) == 'TOUT'}">
	                    		<a href="#" onClick="javascript:vdetails('${sxhchangeid}','${fn:substring(sxhchangeid,0,4)}','${fn:substring(sxhGoodsBarCode,0,1)}')">
	                    		领用出库单
	                    		</a>
	                    	</c:when>
	                    	
	                    	<c:when test="${sxhchangeid == 'import'}">
	                    		&nbsp;
	                    	</c:when>
	                    	<c:otherwise>
	                    		&nbsp;
	                    	</c:otherwise>                    	
                          </c:choose>
                          </TD>
                          <TD>${fn:substring(sxhwarehousingdate,0,16)}</TD>
                          <TD>${sxhWarehouseName}</TD>
                          <TD>${sxhsumnum}<input type="hidden" name="sxhsumnum" value="${sxhsumnum}"/></TD>                          
						</TR>
						</s:iterator>
					</c:if>	
						<TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=7 scope=col align="right">库存变更合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%">${titlenum}</TH>
				   		</TR>
				   		<TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=7 scope=col align="right">库存合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%">${titlenum+firstStock}</TH>
				   		</TR>   
                      </TBODY>
                    </table>
                   <c:if test="${not empty(goodsDetailsList)}"> 
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					
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