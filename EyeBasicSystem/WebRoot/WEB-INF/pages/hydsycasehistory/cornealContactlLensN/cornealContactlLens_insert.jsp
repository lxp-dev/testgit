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
	function trim(str){ //删除左右两端的空格
　　 	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }

	function chee(){
		if($('input[id=sopclhealthtype]:checked').val() != '0'){
			$('#sopclhealth').attr("disabled",true);
		}else{
			$('#sopclhealth').attr("disabled",false);
		}
		
		if($('input[id=sopclhealthtype]:checked').val() != '1'){
			$("a[id=sopclstoptakeday]").hide();
			$("input[id=sopclstoptakeday]").val("");
		}else{
			$("a[id=sopclstoptakeday]").show();
		}
	}

	function save(){
		if(checkForm(document.all.inspectionForm)){
			inspectionForm.action="cornealContactlLensInsertHydsy.action";
			$("img").removeAttr("onclick");
			inspectionForm.submit();
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
		$("a[id=sopclstoptakeday]").hide();
	});
	function doubleEyeFun(){
		inspectionForm.action="doubleEyeFunToolHydsy.action?source=doubleeyefuniou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
  	function specialCheck() {
		inspectionForm.action="specialCheckToolHydsy.action?source=specialcheckiou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function refractive(){
		inspectionForm.action="refractiveToolHydsy.action?source=refractiveiou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	function glassHistory(){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		inspectionForm.action="selectGlassesHistoryHydsy.action?customerID="+'${customerInfoPo.smecicustomerid }';
		inspectionForm.submit();
	}
	
	function inspection(){
		/* if('${isDoubleEyeFun}' != '1'){
			alert("在进行检查结论之前，请先进行视功能检查！");
			return;
		} */
		$("img").removeAttr("onclick");
		inspectionForm.action="inspectionToolHydsy.action?source=inspectioniou";
		inspectionForm.submit();
	}
	
	function contactGlass(){
		inspectionForm.action="contactGlassToolHydsy.action?source=contactGlassiou";
		$("img").removeAttr("onclick");
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
							<tr bgcolor="#CADEE8" height="26px">
								<TD class="PrivateBorderBlue" width="10%">
								<div align="center">主诉</div>
								</TD>
								<TD>
									<textarea  id="sopclsay" name="cornealContactlLensPo.sopclsay" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '主诉不能大于100字！'}]" style="width:100%;height: 40px" cols="60" rows="5">${fn:trim(cornealContactlLensPo.sopclsay) }</textarea>
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
                                    <TR>
                                      <TD class="table_body" align="center">裸眼</TD>
                                      <TD class="table_body" align="center">OD</TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclluoyanod" class="text_input" size="5" maxlength="5" value="${cornealContactlLensPo.sopclluoyanod }">
                                      </div></TD>
                                      <TD class="table_body" align="center">OS</TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclluoyanos" class="text_input" size="5" maxlength="5" value="${cornealContactlLensPo.sopclluoyanos }">
                                      </div></TD>
                                      <TD class="table_body" align="center">矫正</TD>
                                      <TD class="table_body" align="center">OD</TD>
                                      <TD width="10%"  class="table_none"><div align="center">
                                      <input name="cornealContactlLensPo.sopcljiaozhengod" maxlength="5" value="${cornealContactlLensPo.sopcljiaozhengod }" class="text_input" size="5">
                                      </div></TD>
                                      <TD class="table_body" align="center">OS</TD>
                                 	  <TD width="10%"  class="table_none"><div align="center">
                                         <input name="cornealContactlLensPo.sopcljiaozhengos" maxlength="5" value="${cornealContactlLensPo.sopcljiaozhengos }" class="text_input" size="5">
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
									<tr height="26px">
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
									<tr height="26px">
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
                                       <input name="cornealContactlLensPo.sopcleyemtextod" class="text_input" size="10" maxlength="10" value="${cornealContactlLensPo.sopcleyemtextod }">
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
                                       <input name="cornealContactlLensPo.sopcleyejmtextod" class="text_input" size="10" maxlength="10" value="${cornealContactlLensPo.sopcleyejmtextod }">
                                      </div></TD>
                                      <TD width="20%"  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclotherod" class="text_input" size="20" value="${cornealContactlLensPo.sopclotherod }">
                                      </div></TD>
									    <TD width="20%" class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclremarkod" value="${cornealContactlLensPo.sopclremarkod }" class="text_input" size="20">
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
                                       <input name="cornealContactlLensPo.sopcleyemtextos" class="text_input" size="10" maxlength="10" value="${cornealContactlLensPo.sopcleyemtextos }">
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
                                      <input name="cornealContactlLensPo.sopcleyejmtextos" class="text_input" size="10" maxlength="10" value="${cornealContactlLensPo.sopcleyejmtextos }">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclotheros" class="text_input" size="20" value="${cornealContactlLensPo.sopclotheros }">
                                      </div></TD>
									    <TD  class="table_none"><div align="center">
                                        <input name="cornealContactlLensPo.sopclremarkos" value="${cornealContactlLensPo.sopclremarkos }" class="text_input" size="20">
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
                                      <TD width="90%" class="table_none"><div align="left">
                                      	<select id="sopclcheckglass"  name="cornealContactlLensPo.sopclcheckglass">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='66'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopclcheckglass == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>
	                                      </c:forEach>
                                      	</select>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                    	<TD class="table_body" width="10%" align="center">描述</TD>
                                    	<TD class="table_none" width="90%" align="center">
                                    		<textarea  id="sopclsay" name="cornealContactlLensPo.sopclcheckglasstext" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '描述不能大于100字！'}]" style="width:100%;height: 40px" cols="60" rows="5">${fn:trim(cornealContactlLensPo.sopclcheckglasstext) }</textarea>
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
                                    <TR>
                                    	<TD class="table_body" width="10%" align="center">其它检查</TD>
                                    	<TD class="table_none" width="90%" align="center">
                                    		<textarea  id="sopclsay" name="cornealContactlLensPo.sopclotherchecktext" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '其它检查不能大于100字！'}]" style="width:100%;height: 40px" cols="60" rows="5">${fn:trim(cornealContactlLensPo.sopclotherchecktext) }</textarea>
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
                                    <TR>
                                    	<TD class="table_body" width="10%" align="center">处置</TD>
                                    	<TD class="table_none" width="90%" align="center">
                                    		<textarea  id="sopclsay" name="cornealContactlLensPo.sopcldotext" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '处置不能大于100字！'}]" style="width:100%;height: 40px" cols="60" rows="5">${fn:trim(cornealContactlLensPo.sopcldotext) }</textarea>
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
								<td>
									<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorderBlue" id="fz">
		                               <TBODY>
		                                    <TR>
											<TD height="30" class="table_none">
											<div align="center">
		   										<input name="cornealContactlLensPo.sopclhealthtype" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '0' ? 'checked="checked"':'' } type="radio" value="0" onClick="chee();" checked="checked"  />&nbsp;继续佩戴&nbsp;
											    <select id="sopclhealth"  name="cornealContactlLensPo.sopclhealth">
		                                          <option value="" selected></option>
		                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
				                                      <c:if test="${optionParamPoTmp.fopparentid=='59'}">
				                                      	<option value="${optionParamPoTmp.fopparamid }" ${(cornealContactlLensPo.sopclhealth == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
				                                      </c:if>	                                      	
			                                      </c:forEach>
		                                        </select>
		                                        
												<input name="cornealContactlLensPo.sopclhealthtype" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '1' ? 'checked="checked"':'' } onClick="chee();" type="radio" value="1" />
												&nbsp;停戴
												<a id="sopclstoptakeday"><input name="cornealContactlLensPo.sopclstoptakeday" id="sopclstoptakeday" value="${cornealContactlLensPo.sopclstoptakeday }" class="text_input60" size="3" maxlength="3" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value);}" onKeyUp="value=value.replace(/[^\d\.]/g,'')">天&nbsp;&nbsp;</a>
												<input  name="cornealContactlLensPo.sopclhealthtype" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '2' ? 'checked="checked"':'' } onClick="chee();" type="radio" value="2" />
												&nbsp;更换镜片
												<input  name="cornealContactlLensPo.sopclhealthtype" id="sopclhealthtype" ${cornealContactlLensPo.sopclhealthtype == '3' ? 'checked="checked"':'' } onClick="chee();" type="radio" value="3" />
												&nbsp;框镜眼镜
											</div>
											</TD>
		                                    </TR>
		                                    <TR align="center">
		                                      <TD height="26" class="table_none">复诊时间：
		                                          <input id="sopipseccheckdate" name="cornealContactlLensPo.sopclcheckagaindate" value="${cornealContactlLensPo.sopclcheckagaindate }" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm'})" class="text_input120">
		                                      </TD>
                                    		</TR>
		                                  </TBODY>
                                	</TABLE>
                                </td>
							  </tr>
							</table>
	</fieldset>	
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="center">
                            <div align="center">
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" name="button1"  title="保存" onClick="save()">
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