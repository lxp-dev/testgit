<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsNotice.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsNotice.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【公告详细】";
	}
	function update(id){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateNotice.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateNotice.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【公告更新】";
	}
	function search(){
		supplierForm.action = "selNotice.action";
		supplierForm.submit();		
		showLoadingBar();
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initInsertNotice.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertNotice.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【公告新增】";

	}
	
	function del(id,name){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initDeleteNotice.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}&bnetitle="+EncodeUtf8(name),400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【公告删除】";
	}
	
	function clean(){
		document.getElementById('bnesearchtitle').value = "";
		document.getElementById('bnesearchpublishdatebegin').value = "";
		document.getElementById('bnesearchpublishdateend').value = "";
		document.getElementById('noticeTypeID').value = "";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}

	function auditNotice(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initAuditNotice.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initAuditNotice.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【公告审核】";
    }

    function able(id,name,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initEnableNotice.action?hid="+id+"&moduleID=${requestScope.moduleID}&title="+EncodeUtf8(name)+"&flag="+flag,400,140,topRows,topCols,returnRefresh(true),true);
        if (flag == '1'){
        	document.getElementById('popupTitle').innerHTML="【公告启用】";
        }else{
        	document.getElementById('popupTitle').innerHTML="【公告停用】";
        }		
    }

	function updateDpt(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateNoticeDpt.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateNoticeDpt.action?bneuuid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【修改发布部门】";
    }
</script>
	<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
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
													align='absmiddle' hspace='3' vspace='3'>基础信息												
											</TD>
											<td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：公告管理</td>
											<TD vAlign=bottom align="right">&nbsp;
												<c:if test="${(permissionPo.keya==1)}">
								            	<img src="${ctx }/img/newbtn/btn_noticeinsert_0.png" btn=btn title="公告新增" onClick="insert()">
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
								</TABLE>
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
																		<table width="100%" id="title0" border=0 align=center
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
																		</TABLE>
																		<table width="100%" border=0 align=center
																			cellpadding=1 cellspacing=1 class="privateBorder"
																			id="title1">
																			<TBODY>
																				<TR>
																					<TD width="9%" height="26" class="table_body">
																						公告标题
																					</TD>
																					<TD width="24%" class="table_none">
																						<input class="text_input160" type="text"
																							id="bnesearchtitle" name="bnesearchtitle"
																							value="${requestScope.bnesearchtitle}" maxlength="30" onkeyup="selectContact(this)">
																					</TD>
																					<TD width="9%" height="26" class="table_body">
																						创建日期
																					</TD>
																					<TD width="24%" class="table_none">
																						<input id="bnesearchpublishdatebegin"
																					       name="bnesearchpublishdatebegin" 
																					       type="text" class="text_input100" 
																					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'bnesearchpublishdateend\')}'})"
																					       value="${requestScope.bnesearchpublishdatebegin }" /> 至 
																					       <input id="bnesearchpublishdateend"
																					       name="bnesearchpublishdateend" 
																					       type="text" class="text_input100" 
																					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'bnesearchpublishdatebegin\')}'})" 
																					        value="${requestScope.bnesearchpublishdateend }" />

																					</TD>
						   <TD width="9%" height="26" class="table_body">公告类型</TD>
			               <TD class="table_none">
                             <select id="noticeTypeID" name="noticeTypeID">
                                 <option value="">----请选择----</option>
                                 <s:iterator value="noticeTypeList">
                                     <option value="${bnetypeid }" ${noticeTypeID eq bnetypeid ? 'selected="selected"' : '' }>${bnetypename}</option>
                                 </s:iterator>
                             </select>
			               </TD>
																					
																				</TR>
																				
																			</TBODY>
																		</TABLE>
																		<table id="title2" cellspacing="2">
																			<tr height="10">
																			
																			<c:if test="${(permissionPo.keyd==1)}">
																				<td>
																					<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询'	 onClick="javascript:search()">
																					<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
																		<c:if test="${not empty(noticePos)}">
																			<table width="100%" border=0 align=center
																				cellpadding=0 cellspacing=0 class="privateTable">
																				<TBODY>
																					<TR>
																						<TD width="5%">
																							<div>
																								<img src="${ctx}/img/pic/queryInfo.gif"
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
																						<TH scope=col colspan="6" width="18%">操作</TH>
																						<TH height="26" scope=col>
																							公告标题
																						</TH>
																						<TH width="8%" scope=col>
																							公告类型
																						</TH>
																						<TH width="8%" scope=col>
																							发布人
																						</TH>
																						<TH width="12%" scope=col>
																							创建日期
																						</TH>
																						<TH width="12%" scope=col>
																							发布日期
																						</TH>
																					</TR>
																					<s:iterator value="noticePos">
																						<TR class="row"
																							onMouseOver="mover(this,'#a2c1eb')"
																							onMouseOut=mout(this,'#cadee8');>
																							<TD width="3%" height="26">
																								<c:if test="${(permissionPo.keye==1)}">
																									<img onClick="javascript:detail('${bneuuid}')" src="${ctx }/img/newbtn/search_0.png" title='详细' btn=btn>
																								</c:if>
																							</TD>
																							<TD  width="3%">
																								<c:if test="${(permissionPo.keyb==1)}">
																								    <c:if test="${(bneauditstate==0)}">
																									    <img onClick="javascript:update('${bneuuid}')" src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改'>
																									</c:if>
																									<c:if test="${(bneauditstate==1)}">
																									    <img src="${ctx }/img/newbtn/edit_2.png" btn=btn title='修改'>
																									</c:if>
																								</c:if>
																							</TD>
																							<TD  width="3%">
																								<img onClick="javascript:del('${bneuuid}','${bnetitle}')" src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除'>
																								<!--
																								<c:if test="${(permissionPo.keyc==1)}">
																									<c:if test="${(bnecount==0)}">
																									    <img onClick="javascript:del('${bneuuid}','${bnetitle}')" src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除'>
																									</c:if>
																									<c:if test="${(bnecount!=0)}">
																									    <img src="${ctx }/img/newbtn/delete_2.png" btn=btn title='删除'>
																									</c:if>
																									
																								</c:if>
																								-->
																							</TD>
																							<TD  width="3%">
																								<c:if test="${(permissionPo.keyg==1)}">
																									<c:if test="${(bneauditstate==0)}">
																									    <img onClick="javascript:auditNotice('${bneuuid}')" src="${ctx }/img/newbtn/audit_0.png" btn=btn title='审核'>
																									</c:if>
																									<c:if test="${(bneauditstate==1)}">
																									    <img src="${ctx }/img/newbtn/audit_2.png" btn=btn title='审核'>
																									</c:if>																									
																								</c:if>
																							</TD>
									 <td width="3%" align="center">
						               <c:if test="${(permissionPo.keyi==1 && bneauditstate == 1 )}">
											<c:if test="${bneflag==0}">
											   <img src="${ctx }/img/newbtn/unenabled_0.png" title='启用' btn=btn onclick="able('${bneuuid}','${bnetitle}','1')">
											</c:if>
											<c:if test="${bneflag==1}">
											   <img src="${ctx }/img/newbtn/enabled_0.png" title='停用' btn=btn onclick="able('${bneuuid}','${bnetitle}','0')">
											</c:if>
										</c:if>
						             </td>
						  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyh==1)}">
                               <img src="${ctx }/img/newbtn/replace_0.png" title='修改部门' btn=btn onclick="javascript:updateDpt('${bneuuid}')">
		                  	</c:if>
		                  </TD>
																							<TD height="26">
																							<c:choose>
																								<c:when test="${bneissticky==1}">
																									<strong style="color:red">${bnetitle}</strong>																							
																								</c:when>
																								<c:otherwise>
																									${bnetitle}
																								</c:otherwise>
																							</c:choose>
																							
																								
																							</TD>
																							<TD>
																								${bnetypename}
																							</TD>																								
																							<TD>
																								${bnepublishpersonname}
																							</TD>																							
																							<TD>
																								${bnepublishdate}
																							</TD>
																							<TD>
																								${bneauditdate}
																							</TD>
																						</TR>
																					</s:iterator>
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
  </TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp"%>
