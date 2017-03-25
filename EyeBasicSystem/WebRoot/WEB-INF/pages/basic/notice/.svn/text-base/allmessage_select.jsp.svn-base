<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>公告维护</title>
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
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	supplierForm.action=link;
	  	supplierForm.submit();		
		showLoadingBar();
	}
	function detail(id){
		document.all.hid.value = id;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initDetailsNoticeStore.action?bneuuid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsNoticeStore.action?bneuuid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【公告通知详细】";
	}

	function moredetail(type){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selNoticeStore.action?moduleID=B0112&noticeTypeID="+type,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selNoticeStore.action?moduleID=B0112&noticeTypeID="+type,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【公告通知查询】";
	}

	function delaydetail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单详细】";
	}

	function moredelaydetail(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectWillDelayWarning.action?moduleID=S0507",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectWillDelayWarning.action?moduleID=S0507",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【预误期查询】";
	}

	function moreinvisibledetail(categoryid,invisibletype){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selStockSearchInvisible.action?moduleID=C0102&goodscategoryID="+categoryid+"&invisibletype="+invisibletype+"&viewType=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selStockSearchInvisible.action?moduleID=C0102&goodscategoryID="+categoryid+"&invisibletype="+invisibletype+"&viewType=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【隐形到期查询】";
	}
	
	function morealertdetail(goodsID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selStockAlert.action?moduleID=C0109&alerttype=4&goodsID="+goodsID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selStockAlert.action?moduleID=C0109&alerttype=4&goodsID="+goodsID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【库存预警查询】";
	}

	function moreconsignprocessorderdetail(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selUnConsignProcessOrder.action?moduleID=C0205",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selUnConsignProcessOrder.action?moduleID=C0205",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【库存预警查询】";
	}

	function allocationdetail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("allocationDetails.action?hid="+id+"&moduleID=C0104",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("allocationDetails.action?hid="+id+"&moduleID=C0104",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨单详细】";
	}

	function allocationsearch(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selAllocation.action?moduleID=C0104&consignState=0&auditState=1&departmentID="+'${person.departmentID }',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selAllocation.action?moduleID=C0104&consignState=0&auditState=1&departmentID="+'${person.departmentID }',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨单查询】";
	}

	function doit(id){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initNonconformingDo.action?hid="+id+"&moduleID=C0501",970,screen.height-200,topRows,topCols,returnRefres(true),false);
		}else{
			showPopWin("initNonconformingDo.action?hid="+id+"&moduleID=C0501",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【不合格品单处理】";
	}

	function allnotdo(){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selNonconforming.action?auditState=notdo&moduleID=C0501",970,screen.height-200,topRows,topCols,returnRefres(true),false);
		}else{
			showPopWin("selNonconforming.action?auditState=notdo&moduleID=C0501",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【不合格品单处理】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}

	var reportlet = "sales_dayMonthQTRpt.cpt";
	function openOneStoreSalesReport(ShopCode, BeginDate, End, departmentNames) {
		if("${totalType}" == 1) {
			reportlet = "sales_dayMonthQTRpt.cpt";
		} else if("${totalType}" == 2) {
			reportlet = "sales_dayMonthArrearsAppendByQTRpt.cpt";
		} else if("${totalType}" == 3) {
			reportlet = "sales_dayMonthQT2Rpt.cpt";
		}
		var DataURL = "report.action?reportlet="+reportlet+"&__bypagesize__=false&ShopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&departmentNames="+EncodeUtf8(departmentNames)+"&isShow=0";
		window.open(DataURL,'','toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=0,width='+(screen.width)+',height='+(screen.height-100));
	}

	function openMoreStoreSalesReport() {
		var salesDate = new Date();
		salesDate.setTime(new Date().getTime()-1000*60*60*24);
		salesDate = salesDate.format("yyyy-MM-dd");
		if("${totalType}" == 1) {
			reportlet = "sales_dayMonthNotTuiQTRpt.cpt";
		} else if("${totalType}" == 2) {
			reportlet = "sales_dayMonthArrearsAppendByQTRpt.cpt";
		} else if("${totalType}" == 3) {
			reportlet = "sales_dayMonthQT2Rpt.cpt";
		}
		var DataURL = "report.action?reportlet="+reportlet+"&__bypagesize__=false&ShopCode=&beginTime="+salesDate+"&endTime="+salesDate+"&isShow=0&departmentNames=";
		window.open(DataURL,'','toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=0,width='+(screen.width)+',height='+(screen.height-100));
	}

	function allocationListForApp(objValue){
		if(!objValue) {
			var dataURL ="initAllocationSel.action?moduleID=C0104";
			var moduleID = document.getElementById('moduleID').value;
			
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin(dataURL,970,screen.height-200,topRows,topCols,returnRefres(true),false);
			}else{
				showPopWin(dataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【商品调拨管理】";
			
		} else {
			var dataURL ="selApplyAllocationBills.action?moduleID=C0104&billID="+objValue+"&isShowBarcode=n";
			var moduleID = document.getElementById('moduleID').value;
			
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin(dataURL,970,screen.height-200,topRows,topCols,returnRefres(true),false);
			}else{
				showPopWin(dataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【调拨单新增】";
		}
	}

	function procurementWaitAll(){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selProcurementWait.action?moduleID=C0202",970,screen.height-200,topRows,topCols,returnRefres(true),false);
		}else{
			showPopWin("selProcurementWait.action?moduleID=C0202",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【未收货采购订单】";
	}

	function procurementWaitDetails(id){
		//document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementOrdersView.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementOrdersView.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【采购收货详细】";
	}

	function delaysReminderAll(){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectDelaysReminder.action?moduleID=S0514",970,screen.height-200,topRows,topCols,returnRefres(true),false);
		}else{
			showPopWin("selectDelaysReminder.action?moduleID=S0514",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【未通知误期提醒】";
	}


	function delaysReminderDetails(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单详细】";
	}		
</script>
	
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierForm" method="post" action="">
			<input type="hidden" name="hid">
			<input type="hidden" name="type" id="type" value="" />

			<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

			<DIV>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
					<TBODY>
						<TR>
							<TD>
								<!-- ?? Start -->
								<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center
									border=0>
									<TBODY>
										<TR>
											<TD class=menubar_title width="15%">
												<img border='0' src='${ctx}/img/pic/module.gif'
													align='absmiddle' hspace='3' vspace='3'>
												工作提醒
											</TD>
											<td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：提醒信息</td>
										</TR>
										<TR>
											<TD class=menubar_function_text colspan="3"><table></table></TD>
										</TR>
									</TBODY>
								</TABLE>
								<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center
									border=0>
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
															<TD width=1 background=${ctx}/img/pic/tab_bg.gif>
																<IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1>
															</TD>
															<TD
																style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px"
																vAlign=top>
																<DIV id=tabContent__1>
																	<DIV>
																	<table width="100%">
																	<c:forEach var="po" items="${loadlist}" varStatus="status">
																		<c:if test="${status.index%2 == 0}">
																			<tr>
																			<c:set value="${status.index }" var="oldindex"/>
																		</c:if>
																		
																		<c:if test="${status.index%2 == 0 && status.index > oldindex}">
																			</tr>
																		</c:if>
																		
																		<c:if test="${po == 'notice' }">
																			
																			<td width="50%" valign="top">
																			<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																						<TH width="45%" height="26" scope=col>
																							${noticetypeposs[status.index][0].bnetypename }公告信息【${noticecount[status.index] }】
																						</TH>
																						<TH width="25%" scope=col>
																							<div onclick="moredetail('${noticetypeposs[status.index][0].bnetypeid }')" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(noticetypeposs[status.index])}">
																					<c:forEach var="po" items="${noticetypeposs[status.index]}">
																						<TR class="row"
																							onMouseOver="mover(this,'#a2c1eb')"
																							onMouseOut=mout(this,'#cadee8');>
																							<TD height="26">
																								<c:choose>
																									<c:when test="${po.bneissticky==1}">
																										<strong style="color:red">${po.bnetitle}</strong>																							
																									</c:when>
																									<c:otherwise>
																										${po.bnetitle}
																									</c:otherwise>
																								</c:choose>
																							</TD>
																							<TD>
																								<img onClick="javascript:detail('${po.bneuuid}')" src="${ctx }/img/newbtn/search_0.png" title='详细' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_0.png');" >
																							</TD>
																						</TR>
																					</c:forEach>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'delaywarning' }">
																			<td width="50%" valign="top">
																				<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																						<TH width="45%" height="26" scope=col>
																							委外预误期【${delaywarningcount }】
																						</TH>
																						<TH width="25%" scope=col>
																							<div onclick="moredelaydetail()" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(delayWarningPos)}">
																					<c:forEach var="po" items="${delayWarningPos}">
																                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
																                          <TD height="26">${po.bdwsalesid }</TD>
																                          <TD width="4%">
																		                     <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:delaydetail('${po.bdwsalesid}')">
																		                  </TD>
																                        </TR>
																                        </c:forEach>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'invisible' }">
																			<td width="50%" valign="top">
																			<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																						<TH width="45%" height="26" scope=col>
																							隐形眼镜到期
																						</TH>
																						<TH width="25%" scope=col>
																							&nbsp;
																						</TH>
																					</TR>
																					<TR class="row"
																						onMouseOver="mover(this,'#a2c1eb')"
																						onMouseOut=mout(this,'#cadee8');>
																						<TD height="26">
																							隐形将过期商品【${yxjgqcount }】
																						</TD>
																						<TD>
																							<img onclick="moreinvisibledetail('4','3')" src="${ctx }/img/newbtn/search_0.png" title='详细' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_0.png');" >
																						</TD>
																					</TR>
																					<TR class="row"
																						onMouseOver="mover(this,'#a2c1eb')"
																						onMouseOut=mout(this,'#cadee8');>
																						<TD height="26">
																							隐形过期商品【${yxgqcount }】
																						</TD>
																						<TD>
																							<img onclick="moreinvisibledetail('4','4')" src="${ctx }/img/newbtn/search_0.png" title='详细' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_0.png');" >
																						</TD>
																					</TR>
																					<TR class="row"
																						onMouseOver="mover(this,'#a2c1eb')"
																						onMouseOut=mout(this,'#cadee8');>
																						<TD height="26">
																							护理液将过期商品【${hlyjgqcount }】
																						</TD>
																						<TD>
																							<img onclick="moreinvisibledetail('5','3')" src="${ctx }/img/newbtn/search_0.png" title='详细' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_0.png');" >
																						</TD>
																					</TR>
																					<TR class="row"
																						onMouseOver="mover(this,'#a2c1eb')"
																						onMouseOut=mout(this,'#cadee8');>
																						<TD height="26">
																							护理液过期商品【${hlygqcount }】
																						</TD>
																						<TD>
																							<img onclick="moreinvisibledetail('5','4')" src="${ctx }/img/newbtn/search_0.png" title='详细' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_0.png');" >
																						</TD>
																					</TR>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'alert' }">
																			<td width="50%" valign="top">
																			<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																						<TH width="45%" height="26" scope=col>
																							库存预警【${alertcount }】
																						</TH>
																						<TH width="25%" scope=col>
																							<div onclick="morealertdetail('')" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(alertgoodsList)}">
																					<c:forEach var="po" items="${alertgoodsList}">
																                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
																                          <TD height="26">${po.bgigoodsid }</TD>
																                          <TD width="4%">
																		                     <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:morealertdetail('${po.bgigoodsid}')">
																		                  </TD>
																                        </TR>
																                    </c:forEach>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'consignprocessorder' }">
																			<td width="50%" valign="top">
																			<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																						<TH width="45%" height="26" scope=col>
																							委外配镜单未订制【${consignprocessordercount }】
																						</TH>
																						<TH width="25%" scope=col>
																							<div onclick="moreconsignprocessorderdetail()" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(consignprocessordergoodsList)}">
																					<s:iterator value="consignprocessordergoodsList">
																						<TR class="row"
																							onMouseOver="mover(this,'#a2c1eb')"
																							onMouseOut=mout(this,'#cadee8');>
																							<TD height="26">
																								${cstcpodglassesbillid }
																							</TD>
																							<TD>
																								<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:delaydetail('${cstcpodglassesbillid }')">
																							</TD>
																						</TR>
																					</s:iterator>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'allocation' }">
																			<td width="50%" valign="top">
																				<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																						<TH width="45%" height="26" scope=col>
																							未收货调拨单【${allocationcount }】
																						</TH>
																						<TH width="25%" scope=col>
																							<div onclick="allocationsearch()" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(allocationList)}">
																					<c:forEach var="po" items="${allocationList}">
																                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
																                          <TD height="26">${po.cshaabillid }</TD>
																                          <TD width="4%">
																		                     <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:allocationdetail('${po.cshaabillid}')">
																		                  </TD>
																                        </TR>
																                        </c:forEach>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'allocationListForApp' }">
																			<td width="50%" valign="top">
																				<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=center>
																						<TH width="45%" height="26" scope=col>
																							调拨申请提醒【${allocationAppCount }】
																						</TH>
																						<TH width="25%" scope=col height="26">
																							<div onclick="allocationListForApp()" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(allocationListForApp)}">
																					  <c:forEach var="po" items="${allocationListForApp}">
																                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
																                          <TD width="45%"height="26">
																                            ${po.cshaabillid }
																                          </TD>
																                          <TD width="25%">
																                            <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="allocationListForApp('${po.cshaabillid }')">
																		                  </TD>
																                        </TR>
																                      </c:forEach>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'nonconforming' }">
																			<td width="50%" valign="top">
																			<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																						<TH width="45%" height="26" scope=col>
																							未处理不合格品单【${nonconformingcount }】
																						</TH>
																						<TH width="25%" scope=col>
																							<div onclick="allnotdo()" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(nonconformingList)}">
																					<s:iterator value="nonconformingList">
																                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
																                          <TD height="26">${cshanbillid}</TD>
																		                  <td width="3%">
																                             <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细'  onClick="javascript:doit('${cshanbillid}')">
																		                  </td> 
																                        </TR>
															                         </s:iterator>
															                         </c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'procurementWait' }">
																			<td width="50%" valign="top">
																				<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=center>
																						<TH width="45%" height="26" scope=col>
																							未收货采购订单【${procurementOrdersAppCount }】
																						</TH>
																						<TH width="25%" scope=col height="26">
																							<div onclick="procurementWaitAll()" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(procurementOrdersListForApp)}">
																					  <c:forEach var="po" items="${procurementOrdersListForApp}">
																                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
																                          <TD width="45%"height="26">
																                            ${po.cstpid }
																                          </TD>
																                          <TD width="25%">
																                          <img src="${ctx }/img/newbtn/search_0.png" title='详细'  btn=btn onClick="javascript:procurementWaitDetails('${po.cstpid}')">
																		                  </TD>
																                        </TR>
																                      </c:forEach>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																		
																		<c:if test="${po == 'delaysReminder' }">
																			<td width="50%" valign="top">
																				<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=center>
																						<TH width="45%" height="26" scope=col>
																							未通知误期提醒【${delaysReminderAppCount }】
																						</TH>
																						<TH width="25%" scope=col height="26">
																							<div onclick="delaysReminderAll()" style="cursor: hand"><u>更多</u></div>
																						</TH>
																					</TR>
																					<c:if test="${not empty(delaysReminderListForApp)}">
																					  <c:forEach var="po" items="${delaysReminderListForApp}">
																                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
																                          <TD width="45%"height="26">
																                            ${po.ssedrsalesid }
																                          </TD>
																                          <TD width="25%">
																                          <img src="${ctx }/img/newbtn/search_0.png" title='详细'  btn=btn onClick="javascript:delaysReminderDetails('${po.ssedrsalesid}')">
																		                  </TD>
																                        </TR>
																                      </c:forEach>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>																		
																																				
																		<c:if test="${po == 'storesSales' }">
																			<td width="50%" valign="top">
																				<table width="100%" border=0 align=center cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=center>
																						<TH width="45%" height="26" scope=col>
																						<c:if test="${departmenttype ne '1' }">
																							昨日销售金额排名前四销售门店
																						</c:if>
																						<c:if test="${departmenttype eq '1' }">
																							昨日销售金额
																						</c:if>
																						</TH>
																						<TH width="25%" scope=col height="26">
																						<c:if test="${departmenttype ne '1' }">
																							<div onclick="openMoreStoreSalesReport()" style="cursor: hand"><u>更多</u></div>
																						</c:if>
																						<c:if test="${departmenttype eq '1' }">
																							&nbsp;
																						</c:if>
																						</TH>
																					</TR>
																					<c:if test="${not empty(storesSalesList)}">
																					  <c:forEach var="po" items="${storesSalesList}">
																                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
																                          <TD width="45%"height="26">
																                            ${po.storesName }
																                          </TD>
																                          <TD width="25%">
																		                    <b><a href="javascript:openOneStoreSalesReport('${po.storesID }', '${po.salesDate }', '${po.salesDate }', '${po.storesName }')" style="color: black;" target="mainFrame">￥${po.salesAmount }</a></b>
																		                  </TD>
																                        </TR>
																                      </c:forEach>
																					</c:if>
																				</TBODY>
																				</TABLE>
																			</td>
																		</c:if>
																	</c:forEach>
																	</table>
																	</DIV>
																</DIV>
																<!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  </TBODY></TABLE></DIV>
</form>			
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp"%>