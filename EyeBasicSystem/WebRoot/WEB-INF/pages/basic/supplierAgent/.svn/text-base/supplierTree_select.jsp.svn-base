<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>制造商维护</title>
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
			showPopWin("supplierDetail.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("supplierDetail.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商详细】";
	}
	function update(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initSupplierUpdate.action?hid="+id+"&parent="+parent+"&goodsTree="+goodsTree+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSupplierUpdate.action?hid="+id+"&parent="+parent+"&goodsTree="+goodsTree+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【制造商更新】";
	}
	function search(){
		supplierForm.action = "selSupplier.action";
		supplierForm.submit();		
		showLoadingBar();
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initSupplierInsert.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",970,screen.height-200, topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSupplierInsert.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200, topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【制造商新增】";
		
	}
	//批量导入Excel
	function innserExcel()
	{
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSupplierExcel.action",600,400, topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSupplierExcel.action",700,500, topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【导入Excel信息】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;

		if(is_iPad()){
			showPopWin("initSupplierDelete.action?hid="+id+"&parent="+parent+"&goodsTree="+goodsTree+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSupplierDelete.action?hid="+id+"&parent="+parent+"&goodsTree="+goodsTree+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【制造商删除】";
	}
	function disableSupplier(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSupplierDisable.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSupplierDisable.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【制造商停用】";
	}
	function ableSupplier(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSupplierAble.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSupplierAble.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【制造商启用】";
	}
	function clean(){
		document.getElementById('supplierID').value = "";
		document.getElementById('supplierName').value = "";
		document.getElementById('goodsCategoryID').value = "";
		document.getElementById('isClosed').value = "";
		document.getElementById('bspdistributionmethods').value = "";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
	function detailBrand(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("brandDetail.action?hid="+id + '&bbdsupplierid=' + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("brandDetail.action?hid="+id + '&bbdsupplierid=' + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种详细】";
	}
	function updateBrand(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initBrandUpdate.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandUpdate.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种更新】";
	}
	
	function insertBrand(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initBrandInsert.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种新增】";
	}

	function delBrand(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;

		if(is_iPad()){
			showPopWin("initBrandDelete.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid="+ supplierID+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandDelete.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种删除】";
	}	
	function enbledBrand(id, supplierID, flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initBrandEnbled.action?hid="+id + '&bbdsupplierid=' + supplierID+"&moduleID=${requestScope.moduleID}" + '&flag=' + flag,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandEnbled.action?hid="+id + '&bbdsupplierid=' + supplierID+"&moduleID=${requestScope.moduleID}" + '&flag=' + flag,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种启用/停用】";
	}
</script>
	<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
		<form name="supplierForm" method="post" action="">
			<input type="hidden" name="hid">
			<input type="hidden" name="type" id="type" value="" />
			<input type="hidden" name="cateid" id="cateid" value="${cateid }" />
			<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" />
			<input type="hidden" name="parent" id="parent" value="${parent}" />
			<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
			
			<DIV>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
					<TBODY>
						<TR>
							<TD>
								<!-- ?? Start -->
								<%--<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center
									border=0>
									<TBODY>
										<TR>
											<TD class=menubar_title width="15%">
												<img border='0' src='${ctx}/img/pic/module.gif'
													align='absmiddle' hspace='3' vspace='3'>基础信息
											</TD>
											<td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：制造商维护</td>
											<TD align="right" valign="bottom">
												<c:if test="${(permissionPo.keya==1)}">
								            		<img src="${ctx }/img/newbtn/btn_supplierinsert_0.png" btn=btn title="制造商新增" onClick="insert()">
								            	</c:if>
												<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
											</TD>
										</TR>
										<TR>
											<TD class=menubar_function_text colspan="3">
												<table></table>
											</TD>
										</TR>
									</TBODY>
								</TABLE>--%>
								<!-- ?? End -->
								<!-- ?? Start -->
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
																		<%--<table width="100%" id="title0" border=0 align=center
																			cellpadding=0 cellspacing=0 class="privateTable">
																			<TBODY>
																				<TR>
																					<TD width="5%">
																						<div>
																							<img src="${ctx}/img/pic/queryCondition.gif"
																								width="86" height="20">
																						</div>
																					</TD>
																					<TD width="95%"
																						background="${ctx}/img/pic/msgbg.png">
																						&nbsp;
																					</TD>
																				</TR>
																			</TBODY>
																		</TABLE>--%>
																		<%--<table width="100%" border=0 align=center
																			cellpadding=1 cellspacing=1 class="privateBorder"
																			id="title1">
																			<TBODY>
																				<TR>
																					<TD width="9%" height="26" class="table_body">
																						制造商代码
																					</TD>
																					<TD width="24%" class="table_none">
																						<input class="text_input100" type="text"
																							id="supplierID" name="supplierID"
																							value="${requestScope.supplierID}" maxlength="2" onkeyup="selectContact(this)">
																					</TD>
																					<TD width="9%" height="26" class="table_body">
																						制造商简称
																					</TD>
																					<TD width="24%" class="table_none">
																						<input class="text_input160" type="text"
																							id="supplierName" name="supplierName"
																							value="${requestScope.supplierName}" onkeyup="selectContact(this)">
																					</TD>
																					<TD width="9%" height="26" class="table_body">
																						商品类别
																					</TD>
																					<TD class="table_none">
																						<select id="goodsCategoryID" name="goodsCategoryID">
																							<option value="">----请选择----</option>
																							<s:iterator value="goodsCategoryList">
																								<option value="${bgcid}" ${bgcid ==goodsCategoryID ? 'selected="selected"' : '' }>
																									${bgcgoodscategoryname}
																								</option>
																							</s:iterator>
																						</select>
																					</TD>
																				</TR>
																				<TR>
																				    <TD height="26" class="table_body">排序方式</TD>
														                          	<TD class="table_none"><select id="bsporderby" name="bsporderby">
														                            	<option value="">----请选择----</option>
														                            	<option value="1" ${bsporderby eq 1 ? 'selected="selected"' : '' }>制造商代码</option>
														                            	<option value="2" ${bsporderby eq 2 ? 'selected="selected"' : '' }>制造商简称</option>
														                          	</select></TD>
																					<TD height="26" class="table_body">
																						启用状态
																					</TD>
																					<TD class="table_none" colspan="3">
																						<select id="isClosed" name="isClosed">
														                            	<option value="">----请选择----</option>
														                            	<option value="1" ${requestScope.isClosed eq 1 ? 'selected="selected"' : '' }>启用</option>
														                            	<option value="0" ${requestScope.isClosed eq 0 ? 'selected="selected"' : '' }>停用</option>
																						</select>
																					</TD>
																				</TR>
																			</TBODY>
																		</TABLE>
																		<table id="title2" cellspacing="2">
																			<tr height="10">
																			
																			<c:if test="${(permissionPo.keyd==1)}">
																				<td>
																					<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询'
																						onClick="javascript:search()">
																					<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空"
																						onClick="clean()">
																				</td>
																			</c:if>
																				
																			</tr>
																		</table>
																		<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
				<table id="loadingBar" width="100%" STYLE="display:none">
				  <tr><td height="10">&nbsp;</td></tr>
				  <tr>                         
				    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
				    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
					<script>
						function showLoadingBar(){
							gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
							document.getElementById("loadingBar").style.display="";
						}
					</script>                            
				    </td>
				</tr>
				</table>                      
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->--%>
																		<c:if test="${not empty(supplierList)}">
																			<table width="100%" border=0 align=center
																				cellpadding=0 cellspacing=0 class="privateTable">
																				<TBODY>
																					<TR>
																						<TD width="5%">
																							<div>
																								<img src="${ctx}/img/pic/supplierInfo.gif"
																									width="86" height="20">
																							</div>
																						</TD>
																						<TD width="95%"
																							background="${ctx}/img/pic/msgbg.png">
																							&nbsp;
																						</TD>
																					</TR>
																				</TBODY>
																			</TABLE>
																			<table width="100%" border=0 align=center
																				cellpadding=1 cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																					    <TH width="12%" scope=col colspan="4">操作</TH>
																						<TH width="5%" height="26" scope=col>
																							代码
																						</TH>
																						<TH width="20%" scope=col>
																							制造商简称
																						</TH>
																						<TH width="7%" scope=col>
																							联系人
																						</TH>
																						<TH width="12%" scope=col>
																							电话
																						</TH>
																						<TH width="12%" scope=col>
																							传真
																						</TH>
																						<TH scope=col>
																							地址
																						</TH>
																					</TR>
																					<s:iterator value="supplierList">
																						<TR class="row"
																							onMouseOver="mover(this,'#a2c1eb')"
																							onMouseOut=mout(this,'#cadee8');>		
																							<TD width="3%">
																								<c:if test="${(permissionPo.keyg==1)}">
																									<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:detail('${bspid}')">
																								</c:if>
																							</TD>
																							<TD width="3%">
																								<c:if test="${(permissionPo.keyb==1)}">
																									<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${bspid}')">
																								</c:if>
																							</TD>
																							<TD width="3%">
																								<c:if test="${(permissionPo.keyc==1)}">
																									<img src="${ctx }/img/newbtn/delete_0.png" btn=btn  title='删除' onClick="javascript:del('${bspid}')">
																								</c:if>
																							</TD>
																							<TD width="3%">
																								<c:if test="${(permissionPo.keye==1)}">
																									<c:if test="${bspflag==1}">
																										<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn  title='停用' onClick="javascript:disableSupplier('${bspid}')">
																									</c:if>
																									<c:if test="${bspflag==0}">
																										<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn  title='启用' onClick="javascript:ableSupplier('${bspid}')">
																									</c:if>
																								</c:if>		
																							</TD>
																							<TD height="26">
																								${bspid}
																							</TD>
																							<TD>
																								${bspsuppliername}
																							</TD>
																							<TD>
																								${bspcontactperson}
																							</TD>
																							<TD>
																								${bspcontactphone}
																							</TD>
																							<TD>
																								${bspfax}
																							</TD>
																							<TD>
																								${bspaddress}
																							</TD>
																						</TR>
																					</s:iterator>
																				</TBODY>
																			</TABLE>
																			<c:if test="${not empty(supplierList)}">
																			<table width="100%" border=0 align=center
																				cellpadding=0 cellspacing=0 class="privateTable">
																				<TBODY>
																					<TR>
																						<TD width="5%">
																							<div>
																								<img src="${ctx}/img/pic/brandInfo.gif"
																									width="86" height="20">
																							</div>
																						</TD>
																						<TD width="95%"
																							background="${ctx}/img/pic/msgbg.png">
																							&nbsp;
																						</TD>
																					</TR>
																					
																				</TBODY>
																			</TABLE>
																			<table width="100%" border=0 align=center
																				cellpadding=1 cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																					    <TH width="12%" scope=col colspan="4">操作</TH>
																						<TH width="5%" height="26" scope=col>
																							代码
																						</TH>
																						<TH width="20%" scope=col>
																							品种名称
																						</TH>
																						<TH width="8%" scope=col>
																							商品类别
																						</TH>
																						<TH scope=col>
																							制造商简称
																						</TH>
																					</TR>
																					<s:iterator value="brands">
																						<TR class="row"
																							onMouseOver="mover(this,'#a2c1eb')"
																							onMouseOut=mout(this,'#cadee8');>		
																							<TD width="3%">
																									<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:detailBrand('${bbdid}','${bbdsupplierid}')">
																							</TD>
																							<TD width="3%">
																									<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:updateBrand('${bbdid}','${bbdsupplierid}')">
																							</TD>
																							<TD width="3%">
																									<img src="${ctx }/img/newbtn/delete_0.png" btn=btn  title='删除' onClick="javascript:delBrand('${bbdid}','${bbdsupplierid}')">
																							</TD>
																							<TD width="3%">
																									<c:if test="${bbdsalesstatue==1}">
																										<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn  title='停用' onClick="enbledBrand('${bbdid}','${bbdsupplierid}','0')">
																									</c:if>
																									<c:if test="${bbdsalesstatue==0}">
																										<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn  title='启用' onClick="enbledBrand('${bbdid}','${bbdsupplierid}','1')">
																									</c:if>
																							</TD>
																							<TD height="26">
																								${bbdid}
																							</TD>
																							<TD>
																								${bbdbrandname}
																							</TD>
																							<TD>
																								${bgcgoodscategoryname}
																							</TD>
																							<TD>
																								${bspsuppliername}
																							</TD>
																						</TR>
																					</s:iterator>
																					</TBODY>
																					</table>
																			<!-- BEGIN 分页-->
																			<div id="dividePage" align="center">
																				<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
																			</div>
																			</c:if>
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
<%@ include file="/WEB-INF/inc/message.jsp"%>
