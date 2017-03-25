<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<HEAD>
<TITLE>门店销售</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${ctx}/css/sales/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript"> 
$(document).ready(function() {

	$("img[btn=btn]").attr("style","cursor: hand");
	$("img[btn=btn]").mouseover(function () {
    	$(this).attr("src",$(this).attr("src").replace("0","1"));
	}).mouseout(function () {
		$(this).attr("src",$(this).attr("src").replace("1","0"));
	});

	if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
		document.getElementById('smecimemberid').focus(); 
    }	

	var frm = window.parent.parent.frames;
	for (var i=0; i < frm.length; i++){
		if(frm[i].name=='hiddenTop'){
			frm[i].toTop();
		}
		if(frm[i].name=='centerframe'){
			frm[i].toLeft();
		}
		if(frm[i].name=='top'){
			frm[i].toReload();
		}	
	}	

	var printflag = '${param.print}';
	if(printflag == '1'){
		printflag = '';
		if('${param.pcheckoutFlag}'=='1'){
			printReport('${param.pssesborderstype}','${param.psalseID}');

	        if ($.trim('${systemParameterPo.fspsubscriptionbillname}') == ''){
	            alert('请先配置订金单样式!');
	            return;
	        }
	        
			var DataURL="report.action?reportlet=${systemParameterPo.fspsubscriptionbillname}&salesID="+'${param.psalseID}';
			window.open (DataURL, '定金单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		}else{
			printReport('${param.pssesborderstype}','${param.psalseID}');
		}
	}
	
	
});

// 会员查询开窗
function selCustomer(){
       if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
           alert('此门店已经连接HIS系统，不能查询会员!');
           return;
       }
       
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【会员查询】";
}

// 会员查询开窗回带会员卡号
function setCustomer(memberid){   
	document.getElementById('smecimemberid').value = memberid;
	frameSalesForm.action="queryShopSalesMain.action";
	frameSalesForm.submit();
}

function openMember(){
       if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2' ){
           alert('此门店已经连接HIS系统，不能新增会员!');
           return;
       }
       
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initInsertCustomerInfo.action?arg0=salseallnew&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}else{
		showPopWin("initInsertCustomerInfo.action?arg0=salseallnew&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}
	document.getElementById('popupTitle').innerHTML="【会员新增】";
}

function defineSalesTyle(obj){
    if ((obj == '5') && ('${systemParameterPo.fspdefaultmemberid}' != '') && ('${customerInfoPo2.smecicustomerid}' == '')){
		frameSalesForm.action="initAccessoriesSalesMain.action";
		frameSalesForm.submit();
        return;
    }
}

function printReport(ordertype,id){
    if ($.trim('${systemParameterPo.fspsalesbillname1}') == '' || $.trim('${systemParameterPo.fspsalesbillname3}') == '' || $.trim('${systemParameterPo.fspsalesbillname5}') == ''){
        alert('请先配置配镜单样式!');
        return;
    }
    
	var DataURL='';
	if(ordertype=='1' || ordertype=='2'){
		DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1}&wflag=1&salesid="+id;		
	}else if(ordertype=='3' || ordertype=='4'){
		DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3}&wflag=1&salesid="+id;
	}else{
		DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5}&wflag=1&salesid="+id;
	}
	window.open (DataURL, '结款单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
}
	
function selectCust(flag){
		if(flag){
				frameSalesForm.action="queryShopSalesMain.action";
				frameSalesForm.submit();
		}
	}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			frameSalesForm.action="queryShopSalesMain.action";
			frameSalesForm.submit();
		}
	}
}	
window.onload=function(){
    if('${isGO}'=='1' && $('#smecimemberid').val() == ''){
    	$('img[hisy=hisy]').trigger("click");
	}
}
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<BODY bgColor=#ffffff topMargin=5  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
			<form name="frameSalesForm" method="post">
				<input type="hidden" name="moduleID"
					value="${requestScope.moduleID}" />

				<DIV>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD>
									<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center
										border=0>
										<TBODY>
											<TR>
												<TD style="PADDING-LEFT: 2px; HEIGHT: 1px"
													background=${ctx } /img/pic/tab_bg.gif></TD>
											</TR>
											<TR>
												<TD bgColor=#ffffff>
													<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
														<TBODY>
															<TR>
																<TD width=1 background=${ctx } /img/pic/tab_bg.gif>
																	<IMG height=1 src="${ctx }/img/pic/tab_bg.gif" width=1>
																</TD>
																<TD
																	style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px"
																	vAlign=top>
																	<fieldset>
																		<legend>
																			顾客资料
																		</legend>
																		<table width="98%" border=0 align=center cellpadding=0
																			cellspacing=1 class="privateTable privateBorder">
																			<tr>
																				<td height="26" bgcolor="#cadee8">
																						<li class="horizontal">
																							<img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn hisy=hisy title='查找' >
																							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查找' onclick="selCustomer();">
																						</li>
																					<li class="horizontal">
																						卡号&nbsp;
																						<input id="smecimemberid"
																							name="customerInfoPo.smecimemberid" ${ systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' }
																							onkeypress="selectCustomer();"
																							class="text_input100" size="6">
																					</li>
																					
																					  
																					<li class="horizontal"> 
																						<img name="userName4"
																							src="${ctx }/img/newbtn/btn_customerinsert_0.png" 
																							btn=btn title="会员新增" onclick="openMember();">
																					</li>
																					 
																					<c:if test="${systemParameterPo.fspdefaultmemberid != '' }">
																						<li class="horizontal">
																							<span onclick="defineSalesTyle('1');"
																								style="cursor: hand"><input type="radio"
																									name="salestype" value="1" checked="checked">框镜</span>
																							<span onclick="defineSalesTyle('3');"
																								style="cursor: hand"><input type="radio"
																									name="salestype" value="3">隐形</span>
																							<span onclick="defineSalesTyle('5');"
																								style="cursor: hand"><input type="radio"
																									name="salestype" value="5">辅料</span>
																						</li>
																					</c:if>
																				</td>
																			</tr>
																			<tr>
																				<TD>
																					<font color="red">如已知会员卡号，输入后请使用【回车键】确认！</font>
																				</td>
																			</tr>
																		</table>

																	</fieldset>
																	<!--ݿEnd-->
																</TD>
																<TD width=1 background=${ctx } /img/pic/tab_bg.gif>
																	<IMG height=1 src="${ctx }/img/pic/tab_bg.gif" width=1>
																</TD>
															</TR>
														</TBODY>
													</TABLE>
												</TD>
											</TR>
											<TR>
												<TD background=${ctx } /img/pic/tab_bg.gif bgColor=#ffffff>
													<IMG height=1 src="${ctx }/img/pic/tab_bg.gif" width=1>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									<!--ѡ End-->
								</TD>
							</TR>
							<TR>
								<TD height=5></TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>
			</form>
		</BODY></HTML>
