<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看屈光检查</title>
</head>
<script>	
	function inspection(){
		$("img").removeAttr("onclick");
		var dontshow = $('#dontshow').val();
		inspectionForm.action="initInspectionSelectAier.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	
	function doubleEyeFun(){
		$("img").removeAttr("onclick");
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectDoubleEyeFunAier.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	
	function specialCheck(){
		$("img").removeAttr("onclick");
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectSpecialCheckAier.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	
	function glassHistory(){
		inspectionForm.action="selectGlassesHistoryAier.action?viewDetail=true";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	//嵌入页查找按钮锁死sxh
	function searchButton(){
		var customerID = document.all.customerID.value;
		if(customerID != null){
			document.getElementById('searchbutton').disabled = 'disabled';
			document.getElementById('smecimemberid').readonly = 'readonly';
		}
	}
	$(document).ready(function(){		
		searchButton();
	});
	
	function cornealContactlLens(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		inspectionForm.action="initCornealContactlLensSelectAier.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	
	function contactGlass(){
		var dontshow = $('#dontshow').val();
		inspectionForm.action="initContactGlassSelectAier.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}

	function fixingInterface(){
		$("img").removeAttr("onclick");
		inspectionForm.action="selectFixingInterfaceAier.action";
		inspectionForm.submit();
	}
	
	function detailEyesCheck(cid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("detailEyesCheckAierForRefractiveAier.action?customerID="+cid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("detailEyesCheckAierForRefractiveAier.action?customerID="+cid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【眼部健康检查】";

	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inspectionForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" id="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID" id="optometryBasicID" value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID" id="optometryID" value="${requestScope.optometryID}" /> 
<input type="hidden" name="moduleID" value="${moduleID }"/>
<input type="hidden" id="dontshow" name="dontshow" value="${dontshow }"/>
<input type="hidden" id="chuyanfuyan" name="chuyanfuyan" value="${chuyanfuyan }"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
						<TBODY>
						<TR><!--ťStart-->
						 <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx }/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
				 					<TD>
									  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
										<TBODY>
										<TR>
					                      <TD width=3><IMG id=tabImgLeft__1 height=22 
					                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					                      <TD class=tab id=tabLabel__1                       
					                      background=${ctx}/img/pic/tab_unactive_bg.gif 
					                      onclick="glassHistory()"
					                      UNSELECTABLE="on">戴镜史</TD>
					                      <TD width=3><IMG id=tabImgRight__1 height=22 
					                        src="${ctx}/img/pic/tab_unactive_right.gif" 
					                    width=3></TD>
					                </TR>
									</TBODY>
								  </TABLE>
								  </TD>
							    <TD>
							      <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="void(0)" 
												  background=${ctx }/img/pic/tab_active_bg.gif
												  UNSELECTABLE="on">屈光检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_active_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
								</TD>
										
											<TD>
										  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
											<TBODY>
												<TR>
													<TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="doubleEyeFun()" 
												  background=${ctx }/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">双眼视功能检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="specialCheck()" 
												  background=${ctx }/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">相关检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="contactGlass()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">接触镜评估</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  
										  <TD>
										 <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
											<TBODY>
												<TR>
												<TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
													
												  <TD class=tab id=tabLabel__1 
												  onclick="inspection()" 
												  background=${ctx }/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">检查结论</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
											</TD>
											
									<c:if test="${permissionPo.keyh == '1'}">	  
										  <TD>
									 		<TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
											<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
														src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
													  onclick="fixingInterface()" 
													  background=${ctx }/img/pic/tab_unactive_bg.gif
													  UNSELECTABLE="on">验光设备接口</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
													width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
									</c:if>	
																				
										  <c:if test="${requestScope.chuyanfuyan == '1'}">
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="cornealContactlLens()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">角膜接触镜复查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  </c:if>
									</TR>
								</TBODY>
							</TABLE>
							</TD>
						</TR>
        <TR>
							<TD bgColor=#ffffff>
								<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
									<TBODY>
										<TR>
											<TD width=1 background=${ctx}/img/pic/tab_bg.gif>
												<IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1>
											</TD>
											<TD
												style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; "
												vAlign=top>
												<input type="hidden" id="customerReadonly" name="customerReadonly" value="readOnly" />
												<s:action name="initCustomerOptometryTitleN"
													executeResult="true" />
					<fieldset>
												<legend>
													主诉
												</legend>
													<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
														<tbody>
															<tr bgcolor="#CADEE8" height="26px">
																<TD class="PrivateBorderBlue" width="10%">
																<div align="center">
																	主诉
																</div>
																</TD>
																<TD class="PrivateBorderBlue">&nbsp;&nbsp;${fn:trim(refractivePo.soprcustomersay) }</TD>
															</tr>
														</tbody>
													</table>
												</fieldset>
												<br>
												<fieldset>
													<legend>
														配镜需求
													</legend>
														<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
																	<tbody>
																		<tr bgcolor="#CADEE8" height="26px">
																			<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				配镜需求
																			</div>
																			</TD>
																			<TD class="PrivateBorderBlue">&nbsp;&nbsp;
																			  <c:set value="${ fn:split(refractivePo.soprgoals, ',') }" var="str" />                                      	
									                                          <c:forEach items="${ str }" var="s">
									          									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
											                                      	<c:if test="${fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)}">
											                                      		${optionParamPoTmp.fopparamname} 
											                                      	</c:if>	                                      	
										                                      	</c:forEach> 
																			  </c:forEach>              
																			</TD>
																		</tr>
																	</tbody>
																</table>
															</fieldset>												<fieldset>
													<legend>
														屈光检查
													</legend>
													<table width="99%" class="privateTable" border="0"
														cellpadding="0" cellspacing="0">
														<tr>
															<td>
																<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
																	<tbody>
																		<tr bgcolor="#CADEE8">
															<td width="9%" height="26">
															主导眼
															</td>
															<td width="10%">
						                                       <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
							                                      <c:if test="${refractivePo.soprleadingeye == optionParamPoTmp.fopparamid}">
							                                      	${optionParamPoTmp.fopparamname}
							                                      </c:if>                                      	
						                                      </c:forEach> 															
															</td>
																			<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				裸眼视力：
																			</div>
																			</TD>
																			<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				右
																			</div>
																			</TD>
																			<TD width="8%"
																				class="PrivateBorderBlue" width="10%">
																				<div align="center">
																					 ${refractivePo.soprnakedod} 
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				左
																			</div>
																			</TD>
																			<TD width="8%"
																				class="PrivateBorderBlue" width="10%">
																				<div align="center">
																					 ${refractivePo.soprnakedos} 
																				</div>
																			</TD>
																		</tr>
																	</tbody>
																</table>
																
																<br>
																<fieldset>
																	<legend>检影验光</legend>
														
																<table width="99%" class="privateTable" border="0" cellpadding="1" cellspacing="1">
																  		
																	<tr bgcolor="#CADEE8"  height="25px">
																		<TD colspan="9"
																			class="PrivateBorderBlue" height="25px">
																			<c:if test="${refractivePo.soprdiffusepupil=='1'}">快速散瞳</c:if>
																			<c:if test="${refractivePo.soprdiffusepupil=='2'}">慢速散瞳</c:if>
																			<c:if test="${refractivePo.soprdiffusepupil=='3'}">显然验光</c:if>
																			<c:if test="${refractivePo.soprdiffusepupil=='4'}">复检</c:if>
																			<img src="${ctx }/img/newbtn/btn_eyecheckdetails_0.png" onmouseover="this.style.cursor='hand'" btn=btn title="查看眼部健康检查" onclick="detailEyesCheck('${customerInfoPo.smecicustomerid}')" >
																		</TD>
																	</TR>
																
																	<tr bgcolor="#CADEE8" height="25px">
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				&nbsp;
																			</div>
																		</TD>
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		
																		
																		<TD  class="PrivateBorderBlue">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																		
																		<TD  class="PrivateBorderBlue">
																			&nbsp;
																		</TD>
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																	<TBODY>
																		<tr bgcolor="#CADEE8"  height="25px">
																			<TD width="11%"
																				align="center">
																				OD
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprcheckballglassod}
																				</div>
																			</TD>
																			<TD width="8%"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprcheckpostglassod}
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprcheckaxesod}
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue" rowspan="2">
																				<div align="center">
																					电脑验光：
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprtestballglassod}
																				</div>
																			</TD>
																			
																		
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprtestpostglassod} 
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprtestaxesod} 
																				</div>
																			</TD>
																		</TR>
																		<tr bgcolor="#CADEE8" height="25px">
																			<TD width="11%"
																				align="center">
																				OS
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprcheckballglassos} 
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprcheckpostglassos} 
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprcheckaxesos} 
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprtestballglassos} 
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprtestpostglassos} 
																				</div>
																			</TD>
																			
																		
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprtestaxesos } 
																				</div>
																			</TD>
																		</TR>
																		</TBODY>
																</TABLE>
																</fieldset>
																<br>																
																<fieldset>
																	<legend>主观屈光</legend>
																<table width="99%" border=0 align=center cellpadding="1" cellspacing="1" class="privateTable" >
																	<tr bgcolor="#CADEE8">
																		<TD class="PrivateBorderBlue" height="25px" colspan="5">
																			&nbsp;
																		</TD>
																		<td width="25%">
																			&nbsp;
																		</td>
																		
																		<td width="25%"> 
																			&nbsp;
																		</td>
																	</TR>
																	<TR height="25px" bgcolor="#CADEE8">
																		<TD  class="PrivateBorderBlue" width="10%">
																			&nbsp;
																		</TD>
																		<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				VA
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue" width="10%">
																			&nbsp;
																		</TD>
																		<TD  class="PrivateBorderBlue" width="10%">
																			&nbsp;
																		</TD>
																		
																	<TBODY>
																		<TR bgcolor="#CADEE8" height="25px">
																			<TD width="11%"	align="center">
																				OD
																			</TD>
																			
																			
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soproaballglassod}
																				</div>
																			</TD>
																			
																		
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soproapostglassod} 
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soproaaxesod} 
																				</div>
																			</TD>
																			<TD width="8%" 	class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soproavaod} 
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																			<div align="center">
																					${refractivePo.soprredgreenod }
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																			<div align="center">
																					${refractivePo.soproneod }
																				</div>
																			</TD>
																		</TR>
																		<TR bgcolor="#CADEE8" height="25px">
																			<TD width="11%"
																				align="center">
																				OS
																			</TD>
																			
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soproaballglassos} 
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soproapostglassos} 
																				</div>
																			</TD>
																			
																		
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soproaaxesos} 
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soproavaos} 
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																			<div align="center">
																					${refractivePo.soprredgreenos }
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																			<div align="center">
																					${refractivePo.soproneos }
																				</div>
																			</TD>
																			
																		</TR>
																		<tr  bgcolor="#CADEE8">
																		<td colspan=4></td>
																		<TD class="PrivateBorderBlue">
																				<div align="center">
																					<!-- <input type='button' value="主观屈光" onclick=save();> -->
																				</div>
																			</TD>
																			<td colspan=2></td>
																		</tr>
																		</TBODY>
																</TABLE>
																</fieldset>
																<br/>
																<fieldset>
																<legend>试戴镜结果</legend>
																<TABLE width="99%" border=0 align=center cellPadding=1
																	cellSpacing=1 class="privateTable" id="jj"  >
																	<TR style="height: 25px">
																		
																	</TR>
																	<TR  height="25px">
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			&nbsp;
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																		
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				三棱镜
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				基底
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				远用瞳距(mm)
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				近用瞳距(mm)
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				瞳高(mm)
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center"> 
																				VA 
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">ADD<br> 
																				 
																			</div>
																		</TD>
																	</TR>
																	<TBODY>
																		<TR style="height: 25px">
																			<TD width="11%" bgcolor="#CADEE8"
																				align="center">
																				OD
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalballglassod } 
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalpostglassod } 
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalaxesod } 
																				</div>
																			</TD>
																			
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalarriseglassod } 
																				</div>
																			</TD>
																			<TD width="6%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
											                                       <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
												                                      <c:if test="${refractivePo.soprdbalbasisod == optionParamPoTmp.fopparamid}">
												                                      	${optionParamPoTmp.fopparamname}
												                                      </c:if>                                      	
											                                      </c:forEach> 																				
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalinterhighod } 
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalinterdistanceod} 
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprpupilheightod } 
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalvaod } 
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.sopraddod } 
																				</div>
																			</TD>
																		</TR>
																		<TR style="height: 25px">
																			<TD width="11%" bgcolor="#CADEE8"
																				align="center">
																				OS
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalballglassos } 
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalpostglassos } 
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalaxesos } 
																				</div>
																			</TD>
																			
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalarriseglassos } 
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
											                                       <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
												                                      <c:if test="${refractivePo.soprdbalbasisos == optionParamPoTmp.fopparamid}">
												                                      	${optionParamPoTmp.fopparamname}
												                                      </c:if>                                      	
											                                      </c:forEach> 																				
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalinterhighos } 
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalinterdistanceos } 
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprpupilheightos } 
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.soprdbalvaos } 
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					 ${refractivePo.sopraddos } 
																				</div>
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
																</fieldset>
																<br/>
																<fieldset>
																<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
																	<TR style="height: 25px" align="center">
																		<td class="PrivateBorderBlue" bgcolor="#CADEE8">&nbsp;</td>
																		<TD width="20%" align="center" class="PrivateBorderBlue" bgcolor="#CADEE8">双眼平衡方法:</td>
																		<td width="20%" align="center" class="PrivateBorderBlue" bgcolor="#CADEE8">
								                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
										                                      <c:if test="${refractivePo.soprdoublebalanceway == optionParamPoTmp.fopparamid}">
										                                      	${optionParamPoTmp.fopparamname}
										                                      </c:if>                                      	
									                                      </c:forEach>
																		</td>
																		<TD width="20%" align="center" class="PrivateBorderBlue" bgcolor="#CADEE8">双眼终点红/绿试验:</td>			 
																		<TD width="20%" align="center" class="PrivateBorderBlue" bgcolor="#CADEE8">
									                                       <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
										                                      <c:if test="${refractivePo.soprdoublebalancerg == optionParamPoTmp.fopparamid}">
										                                      	${optionParamPoTmp.fopparamname}
										                                      </c:if>                                      	
									                                      </c:forEach> 																		
																		</td>
																		<td class="PrivateBorderBlue" bgcolor="#CADEE8">&nbsp;</td>
																		</TD>
																	</TR>	
																</TABLE>
																</fieldset>
						
            				</td>
														</tr>
														<br/>
													</table>
												<!--?End-->
											</TD>
											<TD width=1 background=${ctx}/img/pic/tab_bg.gif>
												<IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1>
											</TD></TR></TBODY></TABLE></TD></TR>
						 <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>