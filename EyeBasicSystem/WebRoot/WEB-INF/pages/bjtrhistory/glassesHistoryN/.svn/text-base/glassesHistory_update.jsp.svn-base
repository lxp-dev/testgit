<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
	<TITLE>戴镜史</TITLE>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
 
.horizontal{
    float:left;
    list-style:none;
	margin:5px;
}

.privateTable{
	margin:3px;
}
-->
    </style>
    
<script type="text/javascript">
	function save(){
		if(checkForm(document.all.glassesHistoryForm)){    
        	$("img").removeAttr("onclick");
			glassesHistoryForm.action = "updateGlassesHistoryBjtr.action";
			glassesHistoryForm.submit();
		}
	}

	
	$(document).ready(function(){
		$('#sophifglassestype').attr("value","${hisInfoPo.sophifglassestype}");
		$('#sophifglassesm').attr("value","${hisInfoPo.sophifglassesm}");
		$('#sophifglasseskind').attr("value","${hisInfoPo.sophifglasseskind}");
		$('#sophifglassesc').attr("value","${hisInfoPo.sophifglassesc}");
		$('#sophifcontactlensm').attr("value","${hisInfoPo.sophifcontactlensm}");
		$('#sophifcontactlensbrand').attr("value","${hisInfoPo.sophifcontactlensbrand}");
		$('#sophifcontactlensc').attr("value","${hisInfoPo.sophifcontactlensc}");
		$('#sophifeyeillhis1').attr("value","${hisInfoPo.sophifeyeillhis1}");
		$('#sophifeyeillhis2').attr("value","${hisInfoPo.sophifeyeillhis2}");
		$('#sophifeyeillhis3').attr("value","${hisInfoPo.sophifeyeillhis3}");
		$('#sophifinherithis').attr("value","${hisInfoPo.sophifinherithis}");
		$('#sophifsensitivehis').attr("value","${hisInfoPo.sophifsensitivehis}");
		
		if('${hisInfoPo.sophifglassestype }' == '框架'){
			$("td[yx=yx]").hide();
			$("td[kj=kj]").show();
		}else if('${hisInfoPo.sophifglassestype }' == '隐形眼镜'){
			$("td[yx=yx]").show();
			$("td[kj=kj]").hide();
		}else if('${hisInfoPo.sophifglassestype }' == '无'){
			$("td[kj=kj]").show();
			$("td[yx=yx]").hide();
		}
	});

	function selectGlasstype(obj){
		if($(obj).val() == '框架'){
			$("td[yx=yx]").hide();
			$("td[kj=kj]").show();
		}else if($(obj).val() == '隐形眼镜'){
			$("td[yx=yx]").show();
			$("td[kj=kj]").hide();
		}else if($(obj).val() == '无'){
			$("td[kj=kj]").show();
			$("td[yx=yx]").hide();
		}
	}
	
	function optometry(){
		glassesHistoryForm.action="initOptometryBasicSelBjtr.action";
		glassesHistoryForm.submit();
	}
	
	function refractive(){
		if('${optometryPo.sopoyflag}' != '1'){
			$("img").removeAttr("onclick");
			glassesHistoryForm.action="refractiveToolBjtr.action?source=refractiveiou";
			glassesHistoryForm.submit();
		}else{
			var dontshow = $('#dontshow').val();
			$("img").removeAttr("onclick");
			glassesHistoryForm.action="initRefractiveSelectBjtr.action?dontshow="+dontshow;
			glassesHistoryForm.submit();
		}
	}
	function inspection(){
	/*
		if('${isDoubleEyeFun}' != '1'){
			alert("在进行检查结论之前，请先进行视功能检查！");
			return;
		}
		*/

		if('${optometryPo.sopoyflag}' != '1'){
			$("img").removeAttr("onclick");
			glassesHistoryForm.action="inspectionToolBjtr.action?source=inspectioniou";
			glassesHistoryForm.submit();
		}else{
			$("img").removeAttr("onclick");
			var dontshow = $('#dontshow').val();
			glassesHistoryForm.action="initInspectionSelectBjtr.action?dontshow="+dontshow;
			glassesHistoryForm.submit();
		}
	}
	function specialCheck(){
		if('${optometryPo.sopoyflag}' != '1'){
			$("img").removeAttr("onclick");
			glassesHistoryForm.action="specialCheckToolBjtr.action?source=specialcheckiou";
			glassesHistoryForm.submit();
		}else{
			$("img").removeAttr("onclick");
			var dontshow = $('#dontshow').val();
			glassesHistoryForm.action="selectSpecialCheckBjtr.action?dontshow="+dontshow;
			glassesHistoryForm.submit();
		}
	}
	
	function doubleEyeFun(){
		if('${optometryPo.sopoyflag}' != '1'){
			$("img").removeAttr("onclick");
			glassesHistoryForm.action="doubleEyeFunToolBjtr.action?source=doubleeyefuncopy";
			glassesHistoryForm.submit();
		}else{
			$("img").removeAttr("onclick");
			var dontshow = $('#dontshow').val();
			glassesHistoryForm.action="selectDoubleEyeFunBjtr.action?dontshow="+dontshow;
			glassesHistoryForm.submit();
		}
	}
	
	
	function clean(){
		document.glassesHistoryForm.reset();
	}
	
	function cornealContactlLens(){
		if('${optometryPo.sopoyflag}' != '1'){
			$("img").removeAttr("onclick");
			glassesHistoryForm.action="cornealContactlLensToolBjtr.action?source=cornealContactlLensu";
			glassesHistoryForm.submit();	
		}else{
			var dontshow = $('#dontshow').val();
			$("img").removeAttr("onclick");
			glassesHistoryForm.action="initCornealContactlLensSelectBjtr.action?dontshow="+dontshow;
			glassesHistoryForm.submit();
		}
	}
	
	function contactGlass(){
		if('${optometryPo.sopoyflag}' != '1'){
			glassesHistoryForm.action="contactGlassToolBjtr.action?source=contactGlassiou";
			$("img").removeAttr("onclick");
			glassesHistoryForm.submit();
		}else{
			var dontshow = $('#dontshow').val();
			glassesHistoryForm.action="initContactGlassSelectBjtr.action?dontshow="+dontshow;
			$("img").removeAttr("onclick");
			glassesHistoryForm.submit();
		}
		
	}
</script>

</HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"><BODY bgColor=#ffffff topMargin=5>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="glassesHistoryForm" name="glassesHistoryForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="" id="" value="${optometryPo.sopoyflag}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" /> 
<input type="hidden" name="sophifcustomerid" id="sophifcustomerid" value="${requestScope.customerID}" /> 
<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="dontshow" id="dontshow" value="${dontshow}" /> 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
		<!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
      <TBODY>
       <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      
                      UNSELECTABLE="on">戴镜史</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
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
                    
                    </TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>	 
							
						  <s:action name="initCustomerOptometryTitleBjtr" executeResult="true" />	
						<br>
						<fieldset>
							<legend>既往戴镜史</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <TBODY>
                                    <TR>
                                      <TD width="12%" height="30" class="table_body">原配镜类型</TD>
                                      <TD colspan="7" class="table_none">
									  <select id="sophifglassestype" name="sophifglassestype" onchange="selectGlasstype(this);">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='17'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophifglassestype == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>									  
									  </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">镜片材质</TD>
                                      <TD width="15%" class="table_none">
                                      <select id="sophifglassesm" name="sophifglassesm">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='18'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophifglassesm == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                      <TD width="10%" class="table_body">镜片类型</TD>
                                      <TD width="15%" class="table_none">
                                      <select id="sophifglasseskind" name="sophifglasseskind">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='19'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophifglasseskind == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                      <TD width="10%" class="table_body">镜片颜色</TD>
                                      <TD width="15%" class="table_none">
                                      <select id="sophifglassesc" name="sophifglassesc">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='20'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophifglassesc == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                      <TD width="10%" class="table_body">戴镜年限</TD>
                                      <TD width="15%" class="table_none"><input id="sophifglassesage" name="sophifglassesage" class="text_input" size="4" value="${hisInfoPo.sophifglassesage}">年</TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">隐形材质</TD>
                                      <TD class="table_none">
                                      <select id="sophifcontactlensm" name="sophifcontactlensm">
                                          <option value="" selected></option>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='21'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophifcontactlensm == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                      <TD class="table_body">隐形产品</TD>
                                      <TD class="table_none">
                                      	<select id="sophifcontactlensbrand" name="sophifcontactlensbrand" value="${hisInfoPo.sophifglassestype}">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='22'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophifcontactlensbrand == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>
	                                  </TD>
                                      <TD class="table_body">镜片颜色</TD>
                                      <TD class="table_none">
                                      	<select id="sophifcontactlensc" name="sophifcontactlensc">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='23'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophifcontactlensc == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>
	                                  </TD>
                                      <TD class="table_body">戴镜年限</TD>
                                      <TD class="table_none"><input id="sophifcontactlensage" name="sophifcontactlensage" class="text_input" size="4" value="${hisInfoPo.sophifcontactlensage}">年</TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						<br>
						<!-- 
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorder">
                                  <TBODY>
 
                                    <TR>
                                      <TD width="20%" height="30" class="table_body">眼病史</TD>
                                      <TD width="80%" class="table_none">1、
                                        <select id="sophifeyeillhis1" name="sophifeyeillhis1">
                                        <option value="">----请选择----</option>
                                        <option value="正常" ${hisInfoPo.sophifeyeillhis1 == '正常' ? 'selected=selected':''}>正常</option>
                                        <option value="斜视" ${hisInfoPo.sophifeyeillhis1 == '斜视' ? 'selected=selected':''}>斜视</option>
										<option value="弱视" ${hisInfoPo.sophifeyeillhis1 == '弱视' ? 'selected=selected':''}>弱视</option>
										<option value="糖网" ${hisInfoPo.sophifeyeillhis1 == '糖网' ? 'selected=selected':''}>糖网</option>
										<option value="网脱" ${hisInfoPo.sophifeyeillhis1 == '网脱' ? 'selected=selected':''}>网脱</option>
										<option value="白内障" ${hisInfoPo.sophifeyeillhis1 == '白内障' ? 'selected=selected':''}>白内障</option>
										<option value="青光眼" ${hisInfoPo.sophifeyeillhis1 == '青光眼' ? 'selected=selected':''}>青光眼</option>
										<option value="黄斑疾病" ${hisInfoPo.sophifeyeillhis1 == '黄斑疾病' ? 'selected=selected':''}>黄斑疾病</option>
										<option value="干眼" ${hisInfoPo.sophifeyeillhis1 == '干眼' ? 'selected=selected':''}>干眼</option>
										<option value="玻璃体病" ${hisInfoPo.sophifeyeillhis1 == '玻璃体病' ? 'selected=selected':''}>玻璃体病</option>
										<option value="翳状胬肉" ${hisInfoPo.sophifeyeillhis1 == '翳状胬肉' ? 'selected=selected':''}>翳状胬肉</option>
										<option value="角膜炎" ${hisInfoPo.sophifeyeillhis1 == '角膜炎' ? 'selected=selected':''}>角膜炎</option>
										<option value="结膜炎" ${hisInfoPo.sophifeyeillhis1 == '结膜炎' ? 'selected=selected':''}>结膜炎</option>
										<option value="虹膜炎" ${hisInfoPo.sophifeyeillhis1 == '虹膜炎' ? 'selected=selected':''}>虹膜炎</option>
										<option value="圆锥角膜" ${hisInfoPo.sophifeyeillhis1 == '圆锥角膜' ? 'selected=selected':''}>圆锥角膜</option>
										<option value="其它" ${hisInfoPo.sophifeyeillhis1 == '其它' ? 'selected=selected':''}>其它</option>
                                        </select>
                                      &nbsp;&nbsp;2、
                                      <select id="sophifeyeillhis2" name="sophifeyeillhis2">
                                        <option value="">----请选择----</option>
                                        <option value="正常" ${hisInfoPo.sophifeyeillhis2 == '正常' ? 'selected=selected':''}>正常</option>
                                        <option value="斜视" ${hisInfoPo.sophifeyeillhis2 == '斜视' ? 'selected=selected':''}>斜视</option>
										<option value="弱视" ${hisInfoPo.sophifeyeillhis2 == '弱视' ? 'selected=selected':''}>弱视</option>
										<option value="糖网" ${hisInfoPo.sophifeyeillhis2 == '糖网' ? 'selected=selected':''}>糖网</option>
										<option value="网脱" ${hisInfoPo.sophifeyeillhis2 == '网脱' ? 'selected=selected':''}>网脱</option>
										<option value="白内障" ${hisInfoPo.sophifeyeillhis2 == '白内障' ? 'selected=selected':''}>白内障</option>
										<option value="青光眼" ${hisInfoPo.sophifeyeillhis2 == '青光眼' ? 'selected=selected':''}>青光眼</option>
										<option value="黄斑疾病" ${hisInfoPo.sophifeyeillhis2 == '黄斑疾病' ? 'selected=selected':''}>黄斑疾病</option>
										<option value="干眼" ${hisInfoPo.sophifeyeillhis2 == '干眼' ? 'selected=selected':''}>干眼</option>
										<option value="玻璃体病" ${hisInfoPo.sophifeyeillhis2 == '玻璃体病' ? 'selected=selected':''}>玻璃体病</option>
										<option value="翳状胬肉" ${hisInfoPo.sophifeyeillhis2 == '翳状胬肉' ? 'selected=selected':''}>翳状胬肉</option>
										<option value="角膜炎" ${hisInfoPo.sophifeyeillhis2 == '角膜炎' ? 'selected=selected':''}>角膜炎</option>
										<option value="结膜炎" ${hisInfoPo.sophifeyeillhis2 == '结膜炎' ? 'selected=selected':''}>结膜炎</option>
										<option value="虹膜炎" ${hisInfoPo.sophifeyeillhis2 == '虹膜炎' ? 'selected=selected':''}>虹膜炎</option>
										<option value="圆锥角膜" ${hisInfoPo.sophifeyeillhis2 == '圆锥角膜' ? 'selected=selected':''}>圆锥角膜</option>
										<option value="其它" ${hisInfoPo.sophifeyeillhis2 == '其它' ? 'selected=selected':''}>其它</option>
                                      </select>
                                      &nbsp;&nbsp;3、
                                      <select id="sophifeyeillhis3" name="sophifeyeillhis3">
                                        <option value="">----请选择----</option>
                                        <option value="正常" ${hisInfoPo.sophifeyeillhis3 == '正常' ? 'selected=selected':''}>正常</option>
                                        <option value="斜视" ${hisInfoPo.sophifeyeillhis3 == '斜视' ? 'selected=selected':''}>斜视</option>
										<option value="弱视" ${hisInfoPo.sophifeyeillhis3 == '弱视' ? 'selected=selected':''}>弱视</option>
										<option value="糖网" ${hisInfoPo.sophifeyeillhis3 == '糖网' ? 'selected=selected':''}>糖网</option>
										<option value="网脱" ${hisInfoPo.sophifeyeillhis3 == '网脱' ? 'selected=selected':''}>网脱</option>
										<option value="白内障" ${hisInfoPo.sophifeyeillhis3 == '白内障' ? 'selected=selected':''}>白内障</option>
										<option value="青光眼" ${hisInfoPo.sophifeyeillhis3 == '青光眼' ? 'selected=selected':''}>青光眼</option>
										<option value="黄斑疾病" ${hisInfoPo.sophifeyeillhis3 == '黄斑疾病' ? 'selected=selected':''}>黄斑疾病</option>
										<option value="干眼" ${hisInfoPo.sophifeyeillhis3 == '干眼' ? 'selected=selected':''}>干眼</option>
										<option value="玻璃体病" ${hisInfoPo.sophifeyeillhis3 == '玻璃体病' ? 'selected=selected':''}>玻璃体病</option>
										<option value="翳状胬肉" ${hisInfoPo.sophifeyeillhis3 == '翳状胬肉' ? 'selected=selected':''}>翳状胬肉</option>
										<option value="角膜炎" ${hisInfoPo.sophifeyeillhis3 == '角膜炎' ? 'selected=selected':''}>角膜炎</option>
										<option value="结膜炎" ${hisInfoPo.sophifeyeillhis3 == '结膜炎' ? 'selected=selected':''}>结膜炎</option>
										<option value="虹膜炎" ${hisInfoPo.sophifeyeillhis3 == '虹膜炎' ? 'selected=selected':''}>虹膜炎</option>
										<option value="圆锥角膜" ${hisInfoPo.sophifeyeillhis3 == '圆锥角膜' ? 'selected=selected':''}>圆锥角膜</option>	
										<option value="其它" ${hisInfoPo.sophifeyeillhis3 == '其它' ? 'selected=selected':''}>其它</option>
                                      </select></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">遗传史</TD>
                                      <TD class="table_none">
                                      <select id="sophifinherithis" name="sophifinherithis">
                                        <option value="">----请选择----</option>
                                        <option value="正常" ${hisInfoPo.sophifinherithis == '正常' ? 'selected=selected':''}>正常</option>
                                        <option value="高度近视" ${hisInfoPo.sophifinherithis == '高度近视' ? 'selected=selected':''}>高度近视</option>
										<option value="高度远视" ${hisInfoPo.sophifinherithis == '高度远视' ? 'selected=selected':''}>高度远视</option>
										<option value="先天性白内障" ${hisInfoPo.sophifinherithis == '先天性白内障' ? 'selected=selected':''}>先天性白内障</option>
										<option value="视网膜色素变性" ${hisInfoPo.sophifinherithis == '视网膜色素变性' ? 'selected=selected':''}>视网膜色素变性</option>
										<option value="青光眼" ${hisInfoPo.sophifinherithis == '青光眼' ? 'selected=selected':''}>青光眼</option>
										<option value="色盲/色弱" ${hisInfoPo.sophifinherithis == '色盲/色弱' ? 'selected=selected':''}>色盲/色弱</option>
                                      </select></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">过敏史</TD>
                                      <TD class="table_none">
                                      <select id="sophifsensitivehis" name="sophifsensitivehis">
                                        <option value="">----请选择----</option>
                                        <option value="正常" ${hisInfoPo.sophifsensitivehis == '正常' ? 'selected=selected':''}>正常</option>
                                        <option value="食物" ${hisInfoPo.sophifsensitivehis == '食物' ? 'selected=selected':''}>食物</option>
										<option value="药物" ${hisInfoPo.sophifsensitivehis == '药物' ? 'selected=selected':''}>药物</option>
                                      </select></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						</fieldset>
						<br/>
						 -->
						<fieldset>		
								  <legend>旧镜信息</legend>
									<table width="100%">
									<tr height="30">
									<TD bgcolor="#DFFFDF" class="PrivateBorderGreen">&nbsp;</TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">球镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">柱镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">轴向</div></TD>
								    <TD bgcolor="#DFFFDF" yx=yx class="PrivateBorderGreen"><div align="center">曲率</div></TD>
								    <TD bgcolor="#DFFFDF" yx=yx class="PrivateBorderGreen"><div align="center">直径</div></TD>
								    <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen"><div align="center">Add</div></TD>
								    <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen"><div align="center">三棱镜</div></TD>
								    <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen"><div align="center">基底</div></TD>
								    <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen"><div align="center">瞳距(mm)</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">VA</div></TD>
							      </TR>
                                    <tr height="30"  align="center">
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">OD</TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiballod" id="sophiballod" value="${hisInfoPo.sophiballod }"/>
                                      </TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophipostod" id="sophipostod" value="${hisInfoPo.sophipostod }"/>
                                      </TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiaxesod" id="sophiaxesod" value="${hisInfoPo.sophiaxesod }"/>
                                      </TD>
                                      <TD width="8%" yx=yx bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiycamberod" id="sophiycamberod" value="${hisInfoPo.sophiycamberod }"/>
                                      </TD>
                                      <TD width="8%" yx=yx bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiydiameterod" id="sophiydiameterod" value="${hisInfoPo.sophiydiameterod }"/>
                                      </TD>
                                      <TD width="8%" kj=kj bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiaddod" id="sophiaddod" value="${hisInfoPo.sophiaddod }"/>
                                      </TD>
                                      <TD width="8%" kj=kj bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiarriseod" id="sophiarriseod" value="${hisInfoPo.sophiarriseod }"/>
                                      </TD>
                                      <TD width="6%" kj=kj bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                      	<select name="sophibasisod" id="sophibasisod">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='24'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophibasisod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>
	                                  </TD>
                                      <TD width="8%" kj=kj bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiinterhighod" id="sophiinterhighod" value="${hisInfoPo.sophiinterhighod }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophivaod" id="sophivaod" value="${hisInfoPo.sophivaod }"/>
                                      </TD>
                                    </TR>
                                    <tr height="30"  align="center">
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">OS</TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiballos" id="sophiballos" value="${hisInfoPo.sophiballos }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophipostos" id="sophipostos" value="${hisInfoPo.sophipostos }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiaxesos" id="sophiaxesos" value="${hisInfoPo.sophiaxesos }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" yx=yx class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiycamberos" id="sophiycamberos" value="${hisInfoPo.sophiycamberos }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" yx=yx class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiydiameteros" id="sophiydiameteros" value="${hisInfoPo.sophiydiameteros }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiaddos" id="sophiaddos" value="${hisInfoPo.sophiaddos }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiarriseos" id="sophiarriseos" value="${hisInfoPo.sophiarriseos }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen">
                                   		<select name="sophibasisos" id="sophibasisos">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='24'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophibasisos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>
	                                  </TD>
                                      <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiinterhighos" id="sophiinterhighos" value="${hisInfoPo.sophiinterhighos }"/>
                                      </TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophivaos" id="sophivaos" value="${hisInfoPo.sophivaos }"/>
                                      </TD>
                                    </tr>
							</table>                        
							</fieldset>	
							
							<br/>
							<fieldset>		
							<legend>追加度数</legend>
							<table width="100%" align="center">
							<tr height="26px">
							<TD bgcolor="#DFFFDF" class="PrivateBorderGreen">&nbsp;</TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">球镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">柱镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">轴向</div></TD>
								    <TD bgcolor="#DFFFDF" yx=yx class="PrivateBorderGreen"><div align="center">曲率</div></TD>
								    <TD bgcolor="#DFFFDF" yx=yx class="PrivateBorderGreen"><div align="center">直径</div></TD>
								    <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen"><div align="center">Add</div></TD>
								    <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen"><div align="center">三棱镜</div></TD>
								    <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen"><div align="center">基底</div></TD>
								    <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen"><div align="center">瞳距(mm)</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">VA</div></TD>
							      </TR>
                                  <TBODY>
                                    <tr height="30" align="center">
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">OD</TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiballoda" id="sophiballoda" value="${hisInfoPo.sophiballoda }"/>
                                      </TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophipostoda" id="sophipostoda" value="${hisInfoPo.sophipostoda }"/>
                                      </TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiaxesoda" id="sophiaxesoda" value="${hisInfoPo.sophiaxesoda }"/>
                                      </TD>
                                      <TD width="8%" yx=yx bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiycamberoda" id="sophiycamberoda" value="${hisInfoPo.sophiycamberoda }"/>
                                      </TD>
                                      <TD width="8%" yx=yx bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiydiameteroda" id="sophiydiameteroda" value="${hisInfoPo.sophiydiameteroda }"/>
                                      </TD>
                                      <TD width="8%" kj=kj bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiaddoda" id="sophiaddoda" value="${hisInfoPo.sophiaddoda }"/>
                                      </TD>
                                      <TD width="8%" kj=kj bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiarriseoda" id="sophiarriseoda" value="${hisInfoPo.sophiarriseoda }"/>
                                      </TD>
                                      <TD width="6%" kj=kj bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                      	<select name="sophibasisoda" id="sophibasisoda">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='24'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophibasisoda == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>
	                                  </TD>
                                      <TD width="8%" kj=kj bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiinterhighoda" id="sophiinterhighoda" value="${hisInfoPo.sophiinterhighoda }"/>
                                      </TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophivaoda" id="sophivaoda" value="${hisInfoPo.sophivaoda }"/>
                                      </TD>
                                    </TR>
                                    <tr height="30"  align="center">
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen">OS</TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiballosa" id="sophiballosa" value="${hisInfoPo.sophiballosa }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophipostosa" id="sophipostosa" value="${hisInfoPo.sophipostosa }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiaxesosa" id="sophiaxesosa" value="${hisInfoPo.sophiaxesosa }"/>
                                      </TD>
                                      <TD yx=yx bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiycamberosa" id="sophiycamberosa" value="${hisInfoPo.sophiycamberosa }"/>
                                      </TD>
                                      <TD yx=yx bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" class="text_input80" name="sophiydiameterosa" id="sophiydiameterosa" value="${hisInfoPo.sophiydiameterosa }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiaddosa" id="sophiaddosa" value="${hisInfoPo.sophiaddosa }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiarriseosa" id="sophiarriseosa" value="${hisInfoPo.sophiarriseosa }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen">
                                      	<select name="sophibasisosa" id="sophibasisosa">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='24'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(hisInfoPo.sophibasisosa == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>
	                                  </TD>
                                      <TD bgcolor="#DFFFDF" kj=kj class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophiinterhighosa" id="sophiinterhighosa" value="${hisInfoPo.sophiinterhighosa }"/>
                                      </TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <input type="text" class="text_input80" name="sophivaosa" id="sophivaosa" value="${hisInfoPo.sophivaosa }"/>
                                      </TD>
                                    </tr>
						</table>                        
						</fieldset>
						<br/>	
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">
                            <c:if test="${viewDetail!='true'}">
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn name="button1" id="button1" title="保存" onClick="save()">
                              &nbsp;&nbsp;
                              <img src="${ctx}/img/newbtn/btn_empty_0.png" btn=btn onclick="clean()" title="清空" >
                            </c:if>
                              </div>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>		
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR> 
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
