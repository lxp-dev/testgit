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
		inspectionForm.action="initInspectionSelect.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	function doubleEyeFun(){
		$("img").removeAttr("onclick");
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectDoubleEyeFun.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	function specialCheck(){
		$("img").removeAttr("onclick");
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectSpecialCheck.action?dontshow="+dontshow;
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
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inspectionForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" id="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID" id="optometryBasicID" value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID" id="optometryID" value="${requestScope.optometryID}" /> 
<input type="hidden" name="moduleID" value="${moduleID }"/>
<input type="hidden" id="dontshow" name="dontshow" value="${dontshow }"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
			<TR>
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
												  UNSELECTABLE="on">特殊功能检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
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
												<s:action name="initCustomerOptometryTitle"
													executeResult="true" />
												<br>
												<fieldset>
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
																			<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				PD:
																			</div>
																			</TD>
																			<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				OD
																			</div>
																			</TD>
																			<TD class="table_body" width="10%">
																				<div align="center">
																					<input jjorder="1" needChange="needChange"
																						sph="sph" name="refractivePo.soprcheckpdod" readonly="readonly" class="text_input60"
																						value="${refractivePo.soprcheckpdod}"
																						 size="4">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				OS
																			</div>
																			</TD>
																			<TD width="8%"
																				class="PrivateBorderBlue" width="10%">
																				<div align="center">
																					<input jjorder="2" needChange="needChange"
																						cyl="cyl" name="refractivePo.soprcheckpdos"
																						value="${refractivePo.soprcheckpdos}" readonly="readonly" 
																						class="text_input60" size="4">
																				</div>
																			</TD>
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
																					<input jjorder="1" needChange="needChange"
																						sph="sph" name="refractivePo.soprnakedod" readonly="readonly"
																						value="${refractivePo.soprnakedod}"
																						class="text_input60" size="4">
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
																					<input jjorder="2" needChange="needChange"
																						cyl="cyl" name="refractivePo.soprnakedos"
																						value="${refractivePo.soprnakedos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																		</tr>
																	</tbody>
																</table>
																
																<br>
																<fieldset>
																	<legend>检影验光</legend>
														
																<table width="99%" class="privateTable" border="0" cellpadding="1" cellspacing="1">
																  		
																	<tr bgcolor="#CADEE8">
																		<TD colspan="9"
																			class="PrivateBorderBlue" height="25px">
																			<c:if test="${refractivePo.soprdiffusepupil=='1'}">快速散瞳</c:if>
																			<c:if test="${refractivePo.soprdiffusepupil=='2'}">慢速散瞳</c:if>
																			<c:if test="${refractivePo.soprdiffusepupil=='3'}">显然验光</c:if>
																			<c:if test="${refractivePo.soprdiffusepupil=='4'}">复检</c:if>
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
																		<TD  class="PrivateBorderBlue">
																			<div align="center">
																				VA
																			</div>
																		</TD>
																		
																	<TBODY>
																		<tr bgcolor="#CADEE8">
																			<TD width="11%"
																				class="PrivateBorderBlue">
																				OD
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input needChange="needChange" yyorder="1"
																						sph="sph" class="text_input60" size="4" name="refractivePo.soprcheckballglassod"
																						value="${refractivePo.soprcheckballglassod}" readonly="readonly">
																				</div>
																			</TD>
																			<TD width="8%"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input needChange="needChange" yyorder="2"
																						cyl="cyl" name="refractivePo.soprcheckpostglassod"
																						class="text_input60" size="4" 
																						value="${refractivePo.soprcheckpostglassod}" readonly="readonly">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="3"
																						name="refractivePo.soprcheckaxesod" axes="axes"
																						class="text_input60" size="4"
																						value="${refractivePo.soprcheckaxesod}" readonly="readonly">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue" rowspan="2">
																				<div align="center">
																					试镜：
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="4"
																						name="refractivePo.soprtestballglassod"
																						ljxj="ljxj" class="text_input60" size="4"
																						value="${refractivePo.soprtestballglassod}" readonly="readonly">
																				</div>
																			</TD>
																			
																		
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input name="refractivePo.soprtestpostglassod"
																						readonly="readonly" tongju="tongju"
																						value="${refractivePo.soprtestpostglassod}"
																						class="text_input60" size="4" >
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="7"
																						name="refractivePo.soprtestaxesod" va="va"
																						value="${refractivePo.soprtestaxesod}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input name="refractivePo.soprtestvaod"
																						readonly="readonly" va="va"
																						value="${refractivePo.soprtestvaod}"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																		</TR>
																		<tr bgcolor="#CADEE8">
																			<TD width="11%"
																				class="PrivateBorderBlue">
																				OS
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="8" needChange="needChange"
																						sph="sph" name="refractivePo.soprcheckballglassos"
																						value="${refractivePo.soprcheckballglassos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="9"
																						name="refractivePo.soprcheckpostglassos" cyl="cyl"
																						value="${refractivePo.soprcheckpostglassos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="10" needChange="needChange"
																						axes="axes" name="refractivePo.soprcheckaxesos"
																						value="${refractivePo.soprcheckaxesos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					<input readonly="readonly"
																						name="refractivePo.soprtestballglassos" ljxj="ljxj"
																						value="${refractivePo.soprtestballglassos}" 
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="11"
																						name="refractivePo.soprtestpostglassos"
																						ljxj="ljxj"
																						value="${refractivePo.soprtestpostglassos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			
																		
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input name="refractivePo.soprtestaxesos"
																						readonly="readonly" tongju="tongju"
																						value="${refractivePo.soprtestaxesos }"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="14"
																						name="refractivePo.soprtestvaos" va="va"
																						value="${refractivePo.soprtestvaos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			
																		</TR>
																		<tr bgcolor="#CADEE8">
																		<td colspan=8></td>
																		<TD class="PrivateBorderBlue">
																				<div align="center">
																					<!-- <input type='button' value="检影" onclick=save();> -->
																				</div>
																			</TD>
																			
																		</tr>
																		</TBODY>
																</TABLE>
																</fieldset>
																
																<br>																
																<fieldset>
																	<legend>主观屈光</legend>
																<table width="99%" border=0 align=center cellpadding="1" cellspacing="1" class="privateTable" >
																	<tr bgcolor="#CADEE8">
																		<TD class="PrivateBorderBlue" height="25px" colspan="5">
																			
																		</TD>
																		<td width="25%">
																			单眼终点红/绿试验
																		</td>
																		
																		<td width="25%"> 
																			单眼前+1.00D后模糊视力
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
																		<TR bgcolor="#CADEE8">
																			<TD width="11%"	class="PrivateBorderBlue">
																				OD
																			</TD>
																			
																			
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="4"
																						name="refractivePo.soproaballglassod"
																						ljxj="ljxj" class="text_input60" size="4"
																						value="${refractivePo.soproaballglassod}" readonly="readonly">
																				</div>
																			</TD>
																			
																		
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					<input name="refractivePo.soproapostglassod"
																						readonly="readonly"
																						value="${refractivePo.soproapostglassod}"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					<input
																						name="refractivePo.soproaaxesod" va="va"
																						value="${refractivePo.soproaaxesod}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" 	class="PrivateBorderBlue">
																				<div align="center">
																					<input name="refractivePo.soproavaod"
																						readonly="readonly" va="va"
																						value="${refractivePo.soproavaod}"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																			<div align="center">
																					<select jjsgorder="6" id="sopipbasisod1j"
																						name="refractivePo.soprredgreenod" disabled="disabled">
																						<option value="" selected="selected">----请选择----
																																								</option>
																						<option value="红>绿" ${refractivePo.soprredgreenod != "红>绿" ? '' : 'selected="selected"' }>
																							红  > 绿
																						</option>
																						<option value="红=绿" ${refractivePo.soprredgreenod != "红=绿" ? '' : 'selected="selected"' }>
																							红  = 绿
																						</option>
																						<option value="红<绿" ${refractivePo.soprredgreenod != "红<绿" ? '' : 'selected="selected"' }>
																							红  < 绿
																						</option>
																					</select>
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																			<div align="center">
																					<select jjsgorder="6" id="sopipbasisod1j"
																						name="refractivePo.soproneod" disabled="disabled">
																						<option value="" selected="selected">----请选择----
																						</option>
																						<option value="0.3" ${refractivePo.soproneod != "0.3" ? '' : 'selected="selected"' }>
																							0.3
																						</option>
																						<option value="0.4" ${refractivePo.soproneod != "0.4" ? '' : 'selected="selected"' }>
																							0.4
																						</option>
																						<option value="0.5" ${refractivePo.soproneod != "0.5" ? '' : 'selected="selected"' }>
																							0.5
																						</option>
																						<option value="0.6" ${refractivePo.soproneod != "0.6" ? '' : 'selected="selected"' }>
																							0.6
																						</option>
																						<option value="0.7" ${refractivePo.soproneod != "0.7" ? '' : 'selected="selected"' }>
																							0.7
																						</option>
																						<option value="0.8" ${refractivePo.soproneod != "0.8" ? '' : 'selected="selected"' }>
																							0.8
																						</option>
																					</select>
																				</div>
																			</TD>
																		</TR>
																		<TR bgcolor="#CADEE8">
																			<TD width="11%"
																				class="PrivateBorderBlue">
																				OS
																			</TD>
																			
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					<input readonly="readonly"
																						name="refractivePo.soproaballglassos" ljxj="ljxj"
																						value="${refractivePo.soproaballglassos}"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="11"
																						name="refractivePo.soproapostglassos"
																						ljxj="ljxj"
																						value="${refractivePo.soproapostglassos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			
																		
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input name="refractivePo.soproaaxesos"
																						readonly="readonly" tongju="tongju"
																						value="${refractivePo.soproaaxesos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input yyorder="14"
																						name="refractivePo.soproavaos" va="va"
																						value="${refractivePo.soproavaos}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																			<div align="center">
																					<select jjsgorder="6" id="sopipbasisod1j"
																						name="refractivePo.soprredgreenos" disabled="disabled">
																						<option value="" selected="selected">----请选择----
																						</option>
																						<option value="红>绿" ${refractivePo.soprredgreenos != "红>绿" ? '' : 'selected="selected"' }>
																							红  > 绿
																						</option>
																						<option value="红=绿" ${refractivePo.soprredgreenos != "红=绿" ? '' : 'selected="selected"' } >
																							红  = 绿
																						</option>
																						<option value="红<绿" ${refractivePo.soprredgreenos != "红<绿" ? '' : 'selected="selected"' }>
																							红  < 绿
																						</option>
																					</select>
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																			<div align="center">
																					<select jjsgorder="6" id="sopipbasisod1j"
																						name="refractivePo.soproneos" disabled="disabled">
																						<option value="" selected="selected">----请选择----
																						</option>
																						<option value="0.3" ${refractivePo.soproneos != "0.3" ? '' : 'selected="selected"' }>
																							0.3
																						</option>
																						<option value="0.4" ${refractivePo.soproneos != "0.4" ? '' : 'selected="selected"' }>
																							0.4
																						</option>
																						<option value="0.5" ${refractivePo.soproneos != "0.5" ? '' : 'selected="selected"' }>
																							0.5
																						</option>
																						<option value="0.6" ${refractivePo.soproneos != "0.6" ? '' : 'selected="selected"' }>
																							0.6
																						</option>
																						<option value="0.7" ${refractivePo.soproneos != "0.7" ? '' : 'selected="selected"' }>
																							0.7
																						</option>
																						<option value="0.8" ${refractivePo.soproneos != "0.8" ? '' : 'selected="selected"' }>
																							0.8
																						</option>
																					</select>
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
																<legend>双眼平衡结果</legend>
																<TABLE width="99%" border=0 align=center cellPadding=1
																	cellSpacing=1 class="privateTable" id="jj"  >
																	<TR style="height: 25px">
																		
																	</TR>
																	<TR style="height: 25px">
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
																				class="PrivateBorderBlue">
																				OD
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="1" needChange="needChange"
																						sph="sph" name="refractivePo.soprdbalballglassod"
																						value="${refractivePo.soprdbalballglassod }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="2" needChange="needChange"
																						cyl="cyl" name="refractivePo.soprdbalpostglassod"
																						value="${refractivePo.soprdbalpostglassod }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="3"
																						name="refractivePo.soprdbalaxesod" axes="axes"
																						value="${refractivePo.soprdbalaxesod }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="5"
																						name="refractivePo.soprdbalarriseglassod"
																						ljxj="ljxj"
																						value="${refractivePo.soprdbalarriseglassod }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="6%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<select jjsgorder="6" id="sopipbasisod1j"
																						name="refractivePo.soprdbalbasisod" disabled="disabled">
																						<option value="">
																						----请选择----	
																						</option>
																						<option value="内" ${refractivePo.soprdbalbasisod !="内" ? '' : 'selected="selected"' }>
																							内
																						</option>
																						<option value="外" ${refractivePo.soprdbalbasisod !="外" ? '' : 'selected="selected"' }>
																							外
																						</option>
																						<option value="上" ${refractivePo.soprdbalbasisod !="上" ? '' : 'selected="selected"' }>
																							上
																						</option>
																						<option value="下" ${refractivePo.soprdbalbasisod !="下" ? '' : 'selected="selected"' }>
																							下
																						</option>
																					</select>
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="7"
																						name="refractivePo.soprdbalinterhighod"
																						tongju="tongju"
																						value="${refractivePo.soprdbalinterhighod }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="8"
																						name="refractivePo.soprdbalinterdistanceod"
																						tongju="tongju"
																						value="${refractivePo.soprdbalinterdistanceod}" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="18"
																						name="refractivePo.soprpupilheightod"
																						tongju="tongju"
																						value="${refractivePo.soprpupilheightod }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="9"
																						name="refractivePo.soprdbalvaod" va="va"
																						value="${refractivePo.soprdbalvaod }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="10"
																						name="refractivePo.sopraddod" va="va"
																						value="${refractivePo.sopraddod }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																		</TR>
																		<TR style="height: 25px">
																			<TD width="11%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				OS
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="11" needChange="needChange"
																						sph="sph" name="refractivePo.soprdbalballglassos"
																						value="${refractivePo.soprdbalballglassos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="12" needChange="needChange"
																						cyl="cyl" name="refractivePo.soprdbalpostglassos"
																						value="${refractivePo.soprdbalpostglassos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="13"
																						name="refractivePo.soprdbalaxesos" axes="axes"
																						value="${refractivePo.soprdbalaxesos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="15"
																						name="refractivePo.soprdbalarriseglassos"
																						ljxj="ljxj"
																						value="${refractivePo.soprdbalarriseglassos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<select jjsgorder="16" id="sopipbasisos1j"
																						name="refractivePo.soprdbalbasisos" disabled="disabled">
																						<option value="">
																						----请选择----	
																						</option>
																						<option value="内" ${refractivePo.soprdbalbasisos !="内" ? '' : 'selected="selected"' }>
																							内
																						</option>
																						<option value="外" ${refractivePo.soprdbalbasisos !="外" ? '' : 'selected="selected"' }>
																							外
																						</option>
																						<option value="上" ${refractivePo.soprdbalbasisos !="上" ? '' : 'selected="selected"' }>
																							上
																						</option>
																						<option value="下" ${refractivePo.soprdbalbasisos !="下" ? '' : 'selected="selected"' }>
																							下
																						</option>
																					</select>
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="17"
																						name="refractivePo.soprdbalinterhighos"
																						tongju="tongju"
																						value="${refractivePo.soprdbalinterhighos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="18"
																						name="refractivePo.soprdbalinterdistanceos"
																						tongju="tongju"
																						value="${refractivePo.soprdbalinterdistanceos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="18"
																						name="refractivePo.soprpupilheightos"
																						tongju="tongju"
																						value="${refractivePo.soprpupilheightos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="19"
																						name="refractivePo.soprdbalvaos" va="va"
																						value="${refractivePo.soprdbalvaos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input jjsgorder="20"
																						name="refractivePo.sopraddos" va="va"
																						value="${refractivePo.sopraddos }" readonly="readonly"
																						class="text_input60" size="4">
																				</div>
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
																</fieldset>
																<br/>
																<fieldset>
																<TABLE width="99%" border=0 align=center cellPadding=1
																	cellSpacing=1 class="privateTable" id="jj"  >
																	<TR style="height: 25px" align="center">
																		<TD width="99%" align="center"
																			class="PrivateBorderBlue" bgcolor="#CADEE8">
																			   <div>双眼平衡方法
																					<select jjsgorder="16" id="sopipbasisos1j"
																						name="refractivePo.soprdoublebalanceway" disabled="disabled">
																						<option value="${refractivePo.soprdoublebalanceway }" selected="selected">
																						----请选择----	
																						</option>
																						<option value="棱镜法" ${refractivePo.soprdoublebalanceway != "棱镜法" ? '' : 'selected="selected"' }>
																							棱镜法
																						</option>
																						<option value="偏振片法" ${refractivePo.soprdoublebalanceway != "偏振片法" ? '' : 'selected="selected"' }>
																							偏振片法
																						</option>
																					</select>
																				
																			
																				双眼终点红/绿试验
																					<select jjsgorder="16" id="sopipbasisos1j"
																						name="refractivePo.soprdoublebalancerg" disabled="disabled">
																						<option value="" selected="selected" >
																						----请选择----	
																						</option>
																						<option value="红>绿" ${refractivePo.soprdoublebalancerg != "红>绿" ? '' : 'selected="selected"' }>
																							红  > 绿
																						</option>
																						<option value="红=绿" ${refractivePo.soprdoublebalancerg != "红=绿" ? '' : 'selected="selected"' }>
																							红  = 绿
																						</option>
																						<option value="红<绿" ${refractivePo.soprdoublebalancerg != "红<绿" ? '' : 'selected="selected"' }>
																							红  < 绿
																						</option>
																					</select>
																				
																			
																				主导眼
																					<select jjsgorder="16" id="sopipbasisos1j"
																						name="refractivePo.soprleadingeye" disabled="disabled">
																						<option value="">----请选择----
																						</option>
																						<option value="左" ${refractivePo.soprleadingeye != "左" ? '' : 'selected="selected"' }>
																							左
																						</option>
																						<option value="右" ${refractivePo.soprleadingeye != "右" ? '' : 'selected="selected"' }>
																							右
																						</option>
																						<option value="上" ${refractivePo.soprleadingeye != "交替" ? '' : 'selected="selected"' }>
																							交替
																						</option>
																					</select>
																					
																				    &nbsp;&nbsp;&nbsp;接诊医师：${refractivePo.soprexaminedoctorname}
																				</div>
																			</td>
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