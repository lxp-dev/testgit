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

	function save(){
		inspectionForm.action="cornealContactlLensInsertAier.action";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
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
	function doubleEyeFun(){
		inspectionForm.action="doubleEyeFunToolAier.action?source=doubleeyefuniou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
  	function specialCheck() {
		inspectionForm.action="specialCheckToolAier.action?source=specialcheckiou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function refractive(){
		inspectionForm.action="refractiveToolAier.action?source=refractiveiou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function glassHistory(){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		inspectionForm.action="selectGlassesHistoryAier.action?customerID="+'${customerInfoPo.smecicustomerid }';
		inspectionForm.submit();
	}
	
	function inspection(){
		$("img").removeAttr("onclick");
		inspectionForm.action="inspectionToolAier.action?source=inspectioniou";
		inspectionForm.submit();
	}
	
	function contactGlass(){
		inspectionForm.action="contactGlassToolAier.action?source=contactGlassiou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}

	function fixingInterface(){
		$("img").removeAttr("onclick");
		inspectionForm.action="selectFixingInterfaceAier.action";
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
						<s:action name="initCustomerOptometryTitleN" executeResult="true" />		
														
						<br>
						
				  
				<fieldset>
	<legend>角膜接触镜</legend>
	
									<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>			
							<table  width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
									<tr >
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
                                    <TR>
                                      <TD class="table_body" >OD</TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopcltakevaod" class="text_input" size="4" value="${cornealContactlLensPo.sopcltakevaod }">
                                      </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopcltakeaddod" class="text_input" size="4" value="${cornealContactlLensPo.sopcltakeaddod }">
                                      </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopcltakeaddvaod" class="text_input" size="4" value="${cornealContactlLensPo.sopcltakeaddvaod }">
                                      </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        <select id="sopclwhereod"  name="cornealContactlLensPo.sopclwhereod">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='38'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopclwhereod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        <select id="sopclmoveod"  name="cornealContactlLensPo.sopclmoveod">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='39'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopclmoveod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>                                         
                                        </select>
                                      </div></TD>
                                      <TD width="10%"  class="table_none">
                                        <div align="center">
                                         <input name="cornealContactlLensPo.sopcldetakevaod" value="${cornealContactlLensPo.sopcldetakevaod }" class="text_input" size="4">
                                        </div></TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                      <input name="cornealContactlLensPo.sopcldetakeaddod" value="${cornealContactlLensPo.sopcldetakeaddod }" class="text_input" size="4">
                                      </div></TD>
                                 	  <TD width="10%"  class="table_none"><div align="center">
                                         <input name="cornealContactlLensPo.sopcldetakeaddvaod" value="${cornealContactlLensPo.sopcldetakeaddvaod }" class="text_input" size="4">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body" >OS</TD>
                                      <TD class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopcltakevaos" class="text_input" size="4" value="${cornealContactlLensPo.sopcltakevaos }">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopcltakeaddos" class="text_input" size="4" value="${cornealContactlLensPo.sopcltakeaddos }">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopcltakeaddvaos" class="text_input" size="4" value="${cornealContactlLensPo.sopcltakeaddvaos }">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select id="sopclwhereos"  name="cornealContactlLensPo.sopclwhereos">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='38'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopclwhereos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                         <select id="sopclmoveos"  name="cornealContactlLensPo.sopclmoveos">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='39'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopclmoveos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                         </select>
                                      </div></TD>
                                      <TD class="table_none">
                                        <div align="center">
                                         <input name="cornealContactlLensPo.sopcldetakevaos" value="${cornealContactlLensPo.sopcldetakevaos }" class="text_input" size="4">
                                        </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <input name="cornealContactlLensPo.sopcldetakeaddos" value="${cornealContactlLensPo.sopcldetakeaddos }" class="text_input" size="4">
                                      </div></TD>
                                 	  <TD class="table_none"><div align="center">
                                         <input name="cornealContactlLensPo.sopcldetakeaddvaos" value="${cornealContactlLensPo.sopcldetakeaddvaos }" class="text_input" size="4">
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
									<tr >
									<TD class="table_body" >&nbsp;</TD>
								    <TD class="table_body" ><div align="center">角膜</div></TD>
								    <TD class="table_body" ><div align="center">结膜</div></TD>
								    <TD class="table_body" ><div align="center">其他</div></TD>
								    <TD class="table_body" ><div align="center">备注</div></TD>
							      </TR>
                                    <TR>
                                      <TD class="table_body" >OD</TD>
                                      <TD width="20%"  class="table_none"><div align="center">
                                       <select id="sopcleyemod"  name="cornealContactlLensPo.sopcleyemod">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='4'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopcleyemod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                       </select>
                                      </div></TD>
                                      <TD width="20%"  class="table_none"><div align="center">
                                       <select id="sopcleyejmod"  name="cornealContactlLensPo.sopcleyejmod">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='3'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopcleyejmod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                       </select>
                                      </div></TD>
                                      <TD width="20%"  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclotherod" class="text_input" maxlength="16" value="${cornealContactlLensPo.sopclotherod }">
                                      </div></TD>
									    <TD width="20%" class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclremarkod" value="${cornealContactlLensPo.sopclremarkod }" class="text_input" maxlength="16">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body" >OS</TD>
                                      <TD class="table_none"><div align="center">
                                       <select id="sopcleyemos"  name="cornealContactlLensPo.sopcleyemos">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='4'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopcleyemos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                       </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                       <select id="sopcleyejmos"  name="cornealContactlLensPo.sopcleyejmos">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='3'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopcleyejmos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                      </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclotheros" class="text_input" maxlength="16" value="${cornealContactlLensPo.sopclotheros }">
                                      </div></TD>
									    <TD  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclremarkos" value="${cornealContactlLensPo.sopclremarkos }" class="text_input" maxlength="16">
                                      </div></TD>
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
   										<input name="cornealContactlLensPo.sopclhealthtype" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '0' ? 'checked="checked"':'' } type="radio" value="0" onClick="chee();" checked="checked"  />&nbsp;正常&nbsp;
									   <select id="sopclhealth"  name="cornealContactlLensPo.sopclhealth">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='59'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopclhealth == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                       </select>
												<input  name="cornealContactlLensPo.sopclhealthtype" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '1' ? 'checked="checked"':'' } onClick="chee();" type="radio" value="1" />
												&nbsp;停戴
												<input  name="cornealContactlLensPo.sopclhealthtype" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '1' ? 'checked="checked"':'' } onClick="chee();" type="radio" value="2" />
												&nbsp;更换镜片
</div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
	</fieldset>	
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="center">
                            <div align="center">
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" name="button1"  title="保存" onClick="save()">
<%--                              &nbsp;&nbsp;--%>
<%--                              <img src="${ctx}/img/newbtn/btn_reset_0.png" btn=btn title="重置" onclick="document.inspectionForm.reset();">--%>
                              </div></TD></TR>
                      </TBODY>
                    </TABLE>		
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