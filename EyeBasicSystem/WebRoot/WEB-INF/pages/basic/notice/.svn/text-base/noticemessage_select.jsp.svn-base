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
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	supplierForm.action=link;
	  	supplierForm.submit();		
		showLoadingBar();
	}
	function detail(id){
		document.all.hid.value = id;
		
		//var topRows = top.document.getElementById("total").rows;
		//var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsNoticeStore.action?bneuuid="+id,970,screen.height-200,"1000","1000",returnRefresh(true),true);
		}else{
			showPopWin("initDetailsNoticeStore.action?bneuuid="+id,screen.width-100,screen.height-200,"1000","1000",returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【公告通知详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
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
													align='absmiddle' hspace='3' vspace='3'>
												公告通知
											</TD>
											<td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：公告信息</td>
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
																						<TH width="4%" scope=col>操作</TH>
																						<TH width="45%" height="26" scope=col>
																							公告标题
																						</TH>
																						<TH width="25%" scope=col>
																							发布日期
																						</TH>
																						<TH width="25%" scope=col>
																							发布人
																						</TH>
																					</TR>
																					<c:if test="${not empty(noticePos)}">
																					<s:iterator value="noticePos">
																						<TR class="row"
																							onMouseOver="mover(this,'#a2c1eb')"
																							onMouseOut=mout(this,'#cadee8');>
																							<TD>
																								<img onClick="javascript:detail('${bneuuid}')" src="${ctx }/img/newbtn/search_0.png" title='详细' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_0.png');" >
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
																								${bnepublishdate}
																							</TD>
																							<TD>
																								${bnepublishpersonname}
																							</TD>
																						</TR>
																					</s:iterator>
																					</c:if>
																				</TBODY>
																			</TABLE>
																			<!-- BEGIN 分页-->
																			<c:if test="${not empty(noticePos)}">
																			<div id="dividePage" align="center">
																				<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
																			</div>
																			</c:if>
																			<!-- END 分页 -->
																		
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
