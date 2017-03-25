<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>验光检查</title>
</head>
<script>	
	function chee(){
		if($('input[id=sopclhealthtype]:checked').val() != '0'){
			$('#sopclhealth').attr("disabled",true);
		}else{
			$('#sopclhealth').attr("disabled",false);
		}
	}

	//嵌入页查找按钮锁死sxh
	function searchButton(){
		var customerID = document.all.customerID.value;
		if(customerID != null){
			document.getElementById('searchbutton').disabled = 'disabled';
		}
	}
	$(document).ready(function(){
		//inspectionOnload();
		//inspectionCheck();
		//searchButton();
	});
	
	function glassHistory(){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		inspectionForm.action="selectGlassesHistoryHydsy.action?customerID="+'${customerInfoPo.smecicustomerid }';
		inspectionForm.submit();
	}
	
	function contactGlass(){
		var dontshow = $('#dontshow').val();
		inspectionForm.action="initContactGlassSelectHydsy.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function refractive(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		inspectionForm.action="initRefractiveSelectHydsy.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	function inspection(){
		$("img").removeAttr("onclick");
		var dontshow = $('#dontshow').val();
		inspectionForm.action="initInspectionSelectHydsy.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	function specialCheck(){
		$("img").removeAttr("onclick");
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectSpecialCheckHydsy.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
	
	function doubleEyeFun(){
		$("img").removeAttr("onclick");
		var dontshow = $('#dontshow').val();
		inspectionForm.action="selectDoubleEyeFunHydsy.action?dontshow="+dontshow;
		inspectionForm.submit();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inspectionForm" method="post" action="">
<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID"  value="${requestScope.optometryID}" />  
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" />  
<input type="hidden" name="oldOptometryID"  value="${requestScope.oldOptometryID}" />
<input type="hidden" name="oldOptometryIDFirst"  value="${requestScope.oldOptometryIDFirst}" />  
<input type="hidden" name="moduleID"  value="${moduleID }"/>
<input type="hidden" name="ballOD"  value="${refractivePo.soprdbalballglassod}"/>
<input type="hidden" name="glassOD"  value="${refractivePo.soprdbalpostglassod}"/>
<input type="hidden" name="axesOD"  value="${refractivePo.soprdbalaxesod}"/>
<input type="hidden" name="sadOD"  value="${refractivePo.sopraddod }"/>
<input type="hidden" name="ballOS"  value="${refractivePo.soprdbalballglassos}"/>
<input type="hidden" name="glassOS"  value="${refractivePo.soprdbalpostglassos}"/>
<input type="hidden" name="axesOS"  value="${refractivePo.soprdbalaxesos}"/>
<input type="hidden" name="sadOS"  value="${refractivePo.sopraddos}"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
						<TBODY>
						<TR><!--ťStart-->	
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx}/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
										  	<c:if test="${(permissionPo.keya==1)}">
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
								            </c:if>
							  				 <TD>
								 			  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
									          <TBODY>
										      <TR>
											    <TD width=3><IMG id=tabImgLeft__1 height=22 
												src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												<TD class=tab id=tabLabel__1 
												onclick="refractive();" 
												background=${ctx }/img/pic/tab_unactive_bg.gif 
												UNSELECTABLE="on">屈光检查</TD>
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
												  onclick="doubleEyeFun()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">双眼视功能检查</TD>
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
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="specialCheck()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">相关检查</TD>
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
										  
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__0 height=22 
													src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx}/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">角膜接触镜复查</TD>
												  <TD width=3><IMG id=tabImgRight__0 height=22 
													src="${ctx}/img/pic/tab_active_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
											</TD>
									</TR>
								</TBODY>
							</TABLE>
							</TD>
							<td align="right" style="PADDING-LEFT: 2px; HEIGHT: 22px"  background=${ctx }/img/pic/tab_top_bg.gif>&nbsp;
				            </td>
						</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
                		<input type="hidden" id="customerReadonly" name="customerReadonly" value="readOnly" />
						<s:action name="initCustomerOptometryTitleHydsy" executeResult="true" />		
														
						<br>
						<fieldset>
				<legend>
					主诉
				</legend>
					<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
						<tbody>
							<tr bgcolor="#CADEE8" height="60px">
								<TD class="PrivateBorderBlue" width="10%">
								<div align="center">主诉</div>
								</TD>
								<TD>
									${fn:trim(cornealContactlLensPo.sopclsay) }
								</TD>
							</tr>
						</tbody>
					</table>
				</fieldset>
				<br/>
				<fieldset>
				<legend>视力检查</legend>
		 					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>			
							<table  width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TR height="26px">
                                      <TD class="table_body" align="center">裸眼</TD>
                                      <TD class="table_body" align="center">OD</TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopclluoyanod }&nbsp;
                                      </div></TD>
                                      <TD class="table_body" align="center">OS</TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopclluoyanos }&nbsp;
                                      </div></TD>
                                      <TD class="table_body" align="center">矫正</TD>
                                      <TD class="table_body" align="center">OD</TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                      ${cornealContactlLensPo.sopcljiaozhengod }&nbsp;
                                      </div></TD>
                                      <TD class="table_body" align="center">OS</TD>
                                 	  <TD width="10%"  class="table_none"><div align="center">
                                         ${cornealContactlLensPo.sopcljiaozhengos }&nbsp;
                                      </div></TD>
                                    </TR>
							</table>
							</td>
							</tr>
							</table>
							     
							</fieldset>
							<br/>
				<fieldset>
	<legend>角膜接触镜</legend>
	
									<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>			
							<table  width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
									<tr height="26">
									<TD class="table_body" >&nbsp;</TD>
								    <TD class="table_body" ><div align="center">戴镜视力</div></TD>
								    <TD class="table_body" ><div align="center">追加</div></TD>
								    <TD class="table_body" ><div align="center">追加视力</div></TD>
								    <TD class="table_body" ><div align="center">定位</div></TD>
								    <TD class="table_body" ><div align="center">活动度</div></TD>
								    <TD class="table_body" ><div align="center">摘镜视力</div></TD>
								    <TD class="table_body" ><div align="center">追加</div></TD>
								    <TD class="table_body" ><div align="center">追加视力</div></TD>
							      </TR>
                                    <TR height="25">
                                      <TD class="table_body" >OD</TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopcltakevaod }&nbsp;
                                      </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopcltakeaddod }&nbsp;
                                      </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopcltakeaddvaod }&nbsp;
                                      </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${cornealContactlLensPo.sopclwhereod == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;
                                      </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${cornealContactlLensPo.sopclmoveod == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;                                       
                                      </div></TD>
                                      <TD width="10%"  class="table_none">
                                        ${cornealContactlLensPo.sopcldetakevaod }&nbsp;
                                        </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                      	${cornealContactlLensPo.sopcldetakeaddod }&nbsp;
                                      </div></TD>
                                 	  <TD width="10%"  class="table_none"><div align="center">
                                         ${cornealContactlLensPo.sopcldetakeaddvaod }&nbsp;
                                      </div></TD>
                                    </TR>
                                    <TR height="25">
                                      <TD class="table_body" >OS</TD>
                                      <TD class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopcltakevaos }&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopcltakeaddos }&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopcltakeaddvaos }&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                           <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${cornealContactlLensPo.sopclwhereos == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>  &nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                           <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${cornealContactlLensPo.sopclmoveos == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopcldetakevaos }&nbsp;
                                        </div></TD>
                                      <TD  class="table_none"><div align="center">
                                      	${cornealContactlLensPo.sopcldetakeaddos }&nbsp;
                                      </div></TD>
                                 	  <TD  class="table_none"><div align="center">
                                         ${cornealContactlLensPo.sopcldetakeaddvaos }&nbsp;
                                      </div></TD>
                                    </TR>
							</table>
							</td>
							</tr>
							</table>
							     
							</fieldset>
								<br />
							<fieldset>
								<legend>眼部健康检查</legend>
	
									<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>			
							<table  width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
									<tr height="26px">
									<TD class="table_body" >&nbsp;</TD>
								    <TD class="table_body" ><div align="center">角膜</div></TD>
								    <TD class="table_body" ><div align="center">结膜</div></TD>
								    <TD class="table_body" ><div align="center">其他</div></TD>
								    <TD class="table_body" ><div align="center">备注</div></TD>
							      </TR>
                                    <TR height="26">
                                      <TD class="table_body" >OD</TD>
                                      <TD width="20%"  class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='4'}">
		                                      	${(cornealContactlLensPo.sopcleyemod == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                      /
                                       	${cornealContactlLensPo.sopcleyemtextod }&nbsp;
                                      </div></TD>  
                                      <TD width="20%"  class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='3'}">
		                                      	${(cornealContactlLensPo.sopcleyejmod == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname:'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                      /
                                       ${cornealContactlLensPo.sopcleyejmtextod }&nbsp;
                                       </div></TD> 
                                      <TD width="20%"  class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopclotherod }&nbsp;
                                      </div></TD>
									    <TD width="20%" class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopclremarkod }&nbsp;
                                      </div></TD>
                                    </TR>
                                    <TR height="26">
                                      <TD class="table_body" >OS</TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='4'}">
		                                      	${(cornealContactlLensPo.sopcleyemos == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname:'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                      /
                                       ${cornealContactlLensPo.sopcleyemtextos }&nbsp;
                                      </div></TD>  
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='3'}">
		                                      	${(cornealContactlLensPo.sopcleyejmos == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname:'' }
		                                      </c:if>
	                                      </c:forEach> 
	                                      /
                                      ${cornealContactlLensPo.sopcleyejmtextos }&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopclotheros }&nbsp;
                                      </div></TD>
									    <TD  class="table_none"><div align="center">
                                        ${cornealContactlLensPo.sopclremarkos }&nbsp;
                                      </div></TD>
                                    </TR>
							</table>
							</td>
							</tr>
							</table>
							</fieldset>
						   	<br/>
							<fieldset>
							<legend>镜片检查</legend>
		 					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>			
									<table  width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TR>
                                      <TD class="table_body" width="10%" align="center">镜片检查</TD>
                                      <TD width="90%" class="table_none" height="26px"><div align="left">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='66'}">
		                                      	${(cornealContactlLensPo.sopclcheckglass == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>
	                                      </c:forEach>
                                      </div></TD>
                                    </TR>
                                    <TR height="60px">
                                    	<TD class="table_body" width="10%" align="center">描述</TD>
                                    	<TD class="table_none" width="90%" align="left">
                                    		${fn:trim(cornealContactlLensPo.sopclcheckglasstext) }&nbsp; 
                                    	</TD>
                                    </TR>
									</table>
							</td>
							</tr>
							</table>
							</fieldset>
							<br/>
							<fieldset>
							<legend>其它检查</legend>
		 					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>			
									<table  width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TR height="60px">
                                    	<TD class="table_body" width="10%" align="center">其它检查</TD>
                                    	<TD class="table_none" width="90%" align="left">
                                    		${fn:trim(cornealContactlLensPo.sopclotherchecktext) }&nbsp;
                                    	</TD>
                                    </TR>
									</table>
								 </td>
							   </tr>
							</table>
							</fieldset>
							<br/>
							<fieldset>
							<legend>处置</legend>
		 					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>			
									<table  width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TR height="60px">
                                    	<TD class="table_body" width="10%" align="center">处置</TD>
                                    	<TD class="table_none" width="90%" align="center">
                                    		${fn:trim(cornealContactlLensPo.sopcldotext) }&nbsp;
                                    	</TD>
                                    </TR>
									</table>
								 </td>
							   </tr>
							</table>
							</fieldset>
						   <br>
                           <fieldset>
							<legend>复诊建议</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorderBlue" id="fz">
                               <TBODY>

                                    <TR>
                                      
									  <TD height="30" class="table_none"><div align="center">
   										<input name="cornealContactlLensPo.sopclhealthtype" disabled="disabled" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '0' ? 'checked="checked"':'' } type="radio" value="0" onClick="chee();" checked="checked"  />&nbsp;正常&nbsp;
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${cornealContactlLensPo.sopclhealth == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>
												<input  name="cornealContactlLensPo.sopclhealthtype" disabled="disabled" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '1' ? 'checked="checked"':'' } onClick="chee();" type="radio" value="1" />
												&nbsp;停戴
												<c:if test="${cornealContactlLensPo.sopclhealthtype eq '1'}">
													${cornealContactlLensPo.sopclstoptakeday }天
												</c:if>
												&nbsp;&nbsp;&nbsp;
												<input  name="cornealContactlLensPo.sopclhealthtype" disabled="disabled" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '2' ? 'checked="checked"':'' } onClick="chee();" type="radio" value="2" />
												&nbsp;更换镜片
</div></TD>
                                    </TR>
                                    <TR align="center">
		                                      <TD height="26" class="table_none">复诊时间：
		                                          ${fn:substring(cornealContactlLensPo.sopclcheckagaindate,0,16) }
		                                      </TD>
                                    		</TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
	</fieldset>	
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>