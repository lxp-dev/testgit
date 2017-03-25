<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看双眼视功能检查</title>
</head>
<script>
	
function save(){
	if(checkForm(document.all.doubleEyeFunForm)){    
        $("img").removeAttr("onclick");
		doubleEyeFunForm.action = "insertDoubleEyeFun.action";
		doubleEyeFunForm.submit();
		}
	}

function select(){
	showPopWin("","selectDoubleEyeFun.action?customerID=4028806926a1fa430126a1fb59c60000&optometryBasicID=A00001&optometryID=O20100911",screen.width-200,screen.height-200, '',null,true);
	selectHidden();
}

var validate={
	num : function(obj){	
		var	valueO = obj.value;
		obj.value = obj.value.replace(/^[^1-9][0-9]*/g,'');
	},
	dotNum : function(obj){
		obj.value = obj.value.replace(/[^0-9.][0-9]*/g,'');
	}, 
	bcc : function(obj){
		obj.value = obj.value.replace(/[^-0-9.][0-9]*/g,'');
	},
	level : function(obj){
		if(/^[\+\-]/.test(obj.value)){
			obj.value = obj.value.substring(0,1) + obj.value.replace(/[^0-9]/g,'');
		}else{
			obj.value = obj.value.replace(/[^0-9]/g,'');
		}
	}
};
	$(this).ready(function(){
		searchButton();
		$('#aca').bind('keyup',function(){
			validate.dotNum($('#aca').get(0))
		});
		
		$('#aca').bind('blur',function(){
			if($('#aca').val() != ''){
				$('#aca').val(parseFloat($('#aca').val()).toFixed(1));
				this.style.backgroundColor="";
			}
		});
		
		
		$('input[id=aadashdajdufsh]').each(function(){
		$(this).bind
		});
		
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
		
		$('#smecimemberid').attr("readOnly","readOnly");
	});
	
//阶梯法事件acaway
function checkWay(){
	if(document.getElementById('acaway').value=='梯度法'){
		document.getElementById('plusOne').disabled=false;
		document.getElementById('minusOne').disabled=false;
	}else{
		document.getElementById('plusOne').disabled=true;
		document.getElementById('minusOne').disabled=true;
		document.getElementById('plusOne').value="";
		document.getElementById('minusOne').value="";
	}
}

function chageOne(){
	if(document.getElementById('difWatch').readOnly){
		document.getElementById('difWatch').readOnly=false;
		
	}else{
		document.getElementById('difWatch').readOnly=true;
		document.getElementById('difWatch').value="";
	}
}
	
	function specialCheck(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="selectSpecialCheckAier.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function refractive(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="initRefractiveSelectAier.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function inspection(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="initInspectionSelectAier.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function glassHistory(){
		doubleEyeFunForm.action="selectGlassesHistoryAier.action?viewDetail=true";
		$("img").removeAttr("onclick");
		doubleEyeFunForm.submit();
	}
	
	//嵌入页查找按钮锁死sxh
	function searchButton(){
		var customerID = document.all.customerID.value;
		if(customerID != null){
			document.getElementById('searchbutton').disabled = 'disabled';
		}
	}
	
	function cornealContactlLens(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="initCornealContactlLensSelectAier.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function contactGlass(){
		var dontshow = $('#dontshow').val();
		doubleEyeFunForm.action="initContactGlassSelectAier.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		doubleEyeFunForm.submit();
	}

	function fixingInterface(){
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="selectFixingInterfaceAier.action";
		doubleEyeFunForm.submit();
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="doubleEyeFunForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" id="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID" id="optometryBasicID" value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID" id="optometryID" value="${requestScope.optometryID}" /> 
<input type="hidden" name="moduleID" value="${moduleID }"/>
<input type="hidden" id="dontshow" name="dontshow" value="${dontshow }">
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
						  background=${ctx }/img/pic/tab_top_bg.gif colspan="2">
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
													src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
													
												  <TD class=tab id=tabLabel__1 
												  onclick="refractive()" 
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
													src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="void(0)" 
												  background=${ctx }/img/pic/tab_active_bg.gif
												  UNSELECTABLE="on">双眼视功能检查</TD>
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
          <TD bgColor=#ffffff  colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
						<s:action name="initCustomerOptometryTitleN" executeResult="true" />		
						<br>
						<fieldset>
							<legend>双眼视功能检查</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>
								<table  width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
								 <tbody>
								<tr class="trBlue">
										<td  height="30" class="table_body" align="center" >
										<c:if test="${doubleEyeFunPo.sopdeinspecteyefun == '0'}">
											双眼视功能检查:
											是<input id="radio02" disabled="disabled" name="radio02" type="radio" value="0" checked="checked"  onclick="block()"/>&nbsp;
											否<input id="radio02" disabled="disabled" name="radio02" type="radio" value="1" onclick="none()"/>
										</c:if>
										<c:if test="${doubleEyeFunPo.sopdeinspecteyefun == '1'}">
											双眼视功能检查:
											是<input id="radio02" disabled="disabled" name="radio02" type="radio" value="0"  onclick="block()"/>&nbsp;
											否<input id="radio02" disabled="disabled" name="radio02" type="radio" value="1" checked="checked" onclick="none()"/>
										</c:if>
											&nbsp;原因：&nbsp;
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${doubleEyeFunPo.sopdeaccount == optionParamPoTmp.fopparamid}">
			                                      	${optionParamPoTmp.fopparamname}
			                                      </c:if>	                                      	
		                                      </c:forEach>											
										</td>
								</tbody>		
								</tr>
								</table>
								<br/>
								<fieldset style="border-color:#FF0000">
								<legend >必录项</legend>
                                <c:if test="${doubleEyeFunMendPo.bdmfarhetelevel eq '1' || doubleEyeFunMendPo.bdmclosehetelevel eq '1' || doubleEyeFunMendPo.bdmfarheteuprightness eq '1' || doubleEyeFunMendPo.bdmcloseheteuprightness eq '1' }">
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="15%" rowspan="2" class="table_body" align="center">远：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="14%" class="table_none" height="26"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfarhetelevel ne '1' }">
                                        ${doubleEyeFunPo.sopdefarhetelevel }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfarhetelevel eq '1' }">
                                        ${doubleEyeFunPo.sopdefarhetelevel }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfarhetelevel ne '1' }">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdefarhetelevelio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                  &nbsp;
	                                  </c:if>
	                                  <c:if test="${doubleEyeFunMendPo.bdmfarhetelevel eq '1' }">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdefarhetelevelio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                  &nbsp;<font color="red">*</font>
	                                  </c:if>
                                      </div></TD>
                                      <TD width="15%" rowspan="2" class="table_body">近：隐斜</TD>
                                      <TD width="8%" class="table_none" height="26"><div align="right">水平</div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmclosehetelevel ne '1' }">  
                                          ${doubleEyeFunPo.sopdeclosehetelevel }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmclosehetelevel eq '1' }">
                                          ${doubleEyeFunPo.sopdeclosehetelevel }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmclosehetelevel ne '1' }">
                                      
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdeclosehetelevelio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
	                                  </c:if>
	                                  <c:if test="${doubleEyeFunMendPo.bdmclosehetelevel eq '1' }">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdeclosehetelevelio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;<font color="red">*</font>
	                                  </c:if>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none" height="26"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfarheteuprightness ne '1' }">
                                         ${doubleEyeFunPo.sopdefarheteuprightness }&nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfarheteuprightness eq '1' }">
                                         ${doubleEyeFunPo.sopdefarheteuprightness }
                                         &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfarheteuprightness ne '1' }">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='33'}">
		                                      	${(doubleEyeFunPo.sopdefarheteuprightnessud == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
	                                  </c:if>
	                                  <c:if test="${doubleEyeFunMendPo.bdmfarheteuprightness eq '1' }">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='33'}">
		                                      	${(doubleEyeFunPo.sopdefarheteuprightnessud == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;<font color="red">*</font>
	                                  </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseheteuprightness ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseheteuprightness }&nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseheteuprightness eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseheteuprightness }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseheteuprightness ne '1' }">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='33'}">
		                                      	${(doubleEyeFunPo.sopdecloseheteuprightnessud == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
	                                  </c:if>
	                                  <c:if test="${doubleEyeFunMendPo.bdmcloseheteuprightness eq '1' }">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}">
		                                      <c:if test="${optionParamPoTmp.fopparentid=='33'}">
		                                      	${(doubleEyeFunPo.sopdecloseheteuprightnessud == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;<font color="red">*</font>
	                                  </c:if>
                                      </div></TD>
                                    </TR>
                                    </TBODY>
                                    </TABLE>
                                    </c:if>
                                <c:if test="${doubleEyeFunMendPo.bdmtestbig eq '1' || doubleEyeFunMendPo.bdmtestsmall eq '1' || doubleEyeFunMendPo.bdmaca eq '1' }">
                                 <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="15%" class="table_body" height="26" align="center">测试</TD>
                                      <TD width="8%" class="table_none"><div align="right">+1</div></TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmtestbig ne '1' }">
                                        ${doubleEyeFunPo.sopdetestbig }
                                        &nbsp;
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdetestbigio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
	                                  </c:if>
	                                  <c:if test="${doubleEyeFunMendPo.bdmtestbig eq '1' }">
                                        ${doubleEyeFunPo.sopdetestbig }
                                        &nbsp;<font color="red">*</font>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdetestbigio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;<font color="red">*</font>
	                                  </c:if>
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="right">-1</div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmtestbig ne '1' }">
                                      	${doubleEyeFunPo.sopdetestsmall }
                                      	&nbsp;
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdetestsmallio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
	                                  </c:if>
	                                  <c:if test="${doubleEyeFunMendPo.bdmtestbig eq '1' }">
                                      	${doubleEyeFunPo.sopdetestsmall }
                                      	&nbsp;<font color="red">*</font>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdetestsmallio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;<font color="red">*</font>
	                                  </c:if>
                                      </div></TD>
                                      <TD width="15%" class="table_none">AC/A：</TD>
                                      <TD class="table_none" colspan="2">
                                      <c:if test="${doubleEyeFunMendPo.bdmaca ne '1' }">
                                      	${doubleEyeFunPo.sopdeaca }&nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmaca eq '1' }">
                                      	${doubleEyeFunPo.sopdeaca }
                                      	&nbsp;<font color="red">*</font>
                                      </c:if>
                                      </TD>
                                    </TR>
                                    </TBODY>
                                    </TABLE>
                                  </c:if>
                                  <c:if test="${doubleEyeFunMendPo.bdmbcc eq '1' }">
                                  <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR class="table_body" height="30">
                                    	<TD width="15%" class="table_body"><div align="center">BCC：</div></TD>
                                    	<TD class="table_none" colspan="7">
                                    	<c:if test="${doubleEyeFunMendPo.bdmbcc ne '1' }">
                                    	${doubleEyeFunPo.sopdebcc }
										&nbsp;
										</c:if>
										<c:if test="${doubleEyeFunMendPo.bdmbcc eq '1' }">
                                    	${doubleEyeFunPo.sopdebcc }
                                    	&nbsp;<font color="red">*</font>
										</c:if>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										立体视
										<INPUT type="radio" disabled="disabled" value="0" name="doubleEyeFunPo.sopdesolidwatch" checked="checked" ${doubleEyeFunPo.sopdesolidwatch !="0" ? '' : 'checked="checked"' }>
										无
										<INPUT type="radio" disabled="disabled" value="1" name="doubleEyeFunPo.sopdesolidwatch" ${doubleEyeFunPo.sopdesolidwatch !="1" ? '' : 'checked="checked"' }>
										有&nbsp;<font color="red">*</font>
									  </TD>
                                    </TR>
                                    </TBODY>
                                  </TABLE>
                                </c:if>
                                <c:if test="${doubleEyeFunMendPo.bdmpositiveaccpra eq '1' || doubleEyeFunMendPo.bdmpositiveaccpraodos eq '1' || doubleEyeFunMendPo.bdmnegativeaccnra eq '1' || doubleEyeFunMendPo.bdmnegativeaccnraodos eq '1' }">
                                  <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      	<TD width="15%" class="table_body" rowspan="2" align="center">正/负相对调节</TD>
                                      	<TD class="table_none" height="26"><div align="right">PRA：&nbsp;&nbsp;OU</div></TD>
                                      	<TD class="table_none">
                                      	<c:if test="${doubleEyeFunMendPo.bdmpositiveaccpra ne '1' }">
	                                     	${doubleEyeFunPo.sopdepositiveaccpra }
	                                    	&nbsp;
	                                    </c:if>
	                                    <c:if test="${doubleEyeFunMendPo.bdmpositiveaccpra eq '1' }">
	                                     	${doubleEyeFunPo.sopdepositiveaccpra }
	                                     	&nbsp;<font color="red">*</font>
	                                    </c:if>
									 	</TD>
									 	<TD class="table_none"><div align="right">OD</div></TD>
                                      	<TD class="table_none">
                                      	<c:if test="${doubleEyeFunMendPo.bdmpositiveaccpraodos ne '1' }">
	                                     	${doubleEyeFunPo.sopdepositiveaccpraod }
									 		&nbsp;
									 	</c:if>
									 	<c:if test="${doubleEyeFunMendPo.bdmpositiveaccpraodos eq '1' }">
	                                     	${doubleEyeFunPo.sopdepositiveaccpraod }
									 		&nbsp;<font color="red">*</font>
									 	</c:if>
									 	</TD>
									 	<TD class="table_none"><div align="right">OS</div></TD>
                                      	<TD class="table_none" colspan="2">
                                      	<c:if test="${doubleEyeFunMendPo.bdmpositiveaccpraodos ne '1' }">
	                                     	${doubleEyeFunPo.sopdepositiveaccpraos }
									 		&nbsp;
									 	</c:if>
									 	<c:if test="${doubleEyeFunMendPo.bdmpositiveaccpraodos eq '1' }">
	                                     	${doubleEyeFunPo.sopdepositiveaccpraos }
									 		&nbsp;<font color="red">*</font>
									 	</c:if>
									 	</TD>
									</tr>
									<TR>
                                      <TD class="table_none"><div align="right">NRA：&nbsp;&nbsp;OU</div></TD>
                                      <TD class="table_none" height="26">
                                      <c:if test="${doubleEyeFunMendPo.bdmnegativeaccnra ne '1' }">
                                      	${doubleEyeFunPo.sopdenegativeaccnra }
                                      	&nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmnegativeaccnra eq '1' }">
                                      	${doubleEyeFunPo.sopdenegativeaccnra }
                                      	&nbsp;<font color="red">*</font>
                                      </c:if>
                                      </TD>
                                      <TD class="table_none"><div align="right">OD</div></TD>
                                      	<TD class="table_none">
                                      	<c:if test="${doubleEyeFunMendPo.bdmnegativeaccnraodos ne '1' }">
	                                     	${doubleEyeFunPo.sopdenegativeaccnraod }
									 		&nbsp;
									 	</c:if>
									 	<c:if test="${doubleEyeFunMendPo.bdmnegativeaccnraodos eq '1' }">
	                                     	${doubleEyeFunPo.sopdenegativeaccnraod }
									 		&nbsp;<font color="red">*</font>
									 	</c:if>
									 	</TD>
									 	<TD class="table_none"><div align="right">OS</div></TD>
                                      	<TD class="table_none"  colspan="2">
                                      	<c:if test="${doubleEyeFunMendPo.bdmnegativeaccnraodos ne '1' }">
	                                     	${doubleEyeFunPo.sopdenegativeaccnraos }
									 		&nbsp;
									 	</c:if>
									 	<c:if test="${doubleEyeFunMendPo.bdmnegativeaccnraodos eq '1' }">
	                                     	${doubleEyeFunPo.sopdenegativeaccnraos }
									 		&nbsp;<font color="red">*</font>
									 	</c:if>
									 	</TD>
                                    </TR>
                                    </TBODY>
                                    </TABLE>
                                  </c:if>
                                <c:if test="${doubleEyeFunMendPo.bdmaddodos eq '1' }">
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                  	<TR>
                                      <TD width="15%" class="table_body" align="center">AMP</TD>
                                      <TD class="table_none"><div align="right">OU：</div></TD>
                                      <TD class="table_none">
                                      	  ${doubleEyeFunPo.sopdeaddou }
									  </TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none">
                                      	  ${doubleEyeFunPo.sopdeaddod }
									  </TD>
                                      <TD class="table_none"><div align="right">OS：</div></TD>
                                      <TD colspan="2" class="table_none">
										  ${doubleEyeFunPo.sopdeaddos }
                                      </TD>
                                      <td  class="table_none" colspan="6">
                                      	不等像视
										<INPUT  type="radio" disabled="disabled" name="doubleEyeFunPo.sopdeequalwatch" value="0" checked="checked" ${doubleEyeFunPo.sopdeequalwatch == "0" ? 'checked="checked"' : '' } onclick="javascript:chageOne();" >
										无
										<INPUT  type="radio" disabled="disabled" name="doubleEyeFunPo.sopdeequalwatch" value="1" ${doubleEyeFunPo.sopdeequalwatch == "1" ? 'checked="checked"' : '' } onclick="javascript:chageOne();">
										有
										${doubleEyeFunPo.sopdedifwatch }
									  </td>
                                    </TR>
                                    </TBODY>
                                    </TABLE>
                                  </c:if>
                                  <c:if test="${doubleEyeFunMendPo.bdmcloseamaleveln eq '1' || doubleEyeFunMendPo.bdmcloseamalbu eq '1' || doubleEyeFunMendPo.bdmcloseamabu eq '1' || doubleEyeFunMendPo.bdmcloseamalevelp eq '1' || doubleEyeFunMendPo.bdmcloseamalbd eq '1' || doubleEyeFunMendPo.bdmcloseamabd eq '1' }">
                                  <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD colspan="8" bgcolor="#FFFFFF" class="Privateborder" height="26">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="15%" rowspan="2" class="table_body" height="26" align="center">远：融像</TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none" height="26"><div align="right">&nbsp;&mdash; </div></TD>
                                      <TD width="7%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramaleveln ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramaleveln }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramaleveln eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramaleveln }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="7%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramaleveln ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelno }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramaleveln eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelno }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="7%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramaleveln ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelnt }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramaleveln eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelnt }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="8%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalbu ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalbu }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalbu eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalbu }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalbu ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalbuo }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalbu eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalbuo }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramabu ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramabu }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramabu eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramabu }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramabu ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramabuo }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramabu eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramabuo }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">&nbsp;＋</div></TD>
                                      <TD width="6%" class="table_none" height="26"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalevelp ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelp }
                                      	&nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalevelp eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelp }
                                      	&nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalevelp ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelpo }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalevelp eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelpo }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalevelp ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelpt }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalevelp eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalevelpt }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalbd ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalbd }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalbd eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalbd }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalbd ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramalbdo }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramalbd eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramalbdo }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramabd ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramabd }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramabd eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramabd }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramabd ne '1' }">
                                        ${doubleEyeFunPo.sopdefaramabdo }
                                        &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmfaramabd eq '1' }">
                                        ${doubleEyeFunPo.sopdefaramabdo }
                                        &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="8" bgcolor="#FFFFFF" height="26" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD rowspan="2" class="table_body" height="26" align="center">近：融像</TD>
                                      <TD width="5%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="right">&nbsp;&mdash; </div></TD>
                                      <TD class="table_none" height="26"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamaleveln ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamaleveln }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamaleveln eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamaleveln }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamaleveln ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelno }
                                      	  &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamaleveln eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelno }
                                      	  &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamaleveln ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelnt }
                                      	  &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamaleveln eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelnt }
                                      	  &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none" height="26"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalbu ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalbu }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalbu eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalbu }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalbu ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalbuo }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalbu eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalbuo }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamabu ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamabu }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamabu eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamabu }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamabu ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamabuo }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamabu eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamabuo }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">&nbsp;＋ </div></TD>
                                      <TD width="6%" class="table_none" height="26"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalevelp ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelp }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalevelp eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelp }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalevelp ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelpo }
                                      	  &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalevelp eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelpo }
                                      	  &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalevelp ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelpt }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalevelp eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalevelpt }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalbd ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalbd }
                                      	  &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalbd eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalbd }
                                      	  &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalbd ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalbdo }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamalbd eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamalbdo }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamabd ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamabd }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamabd eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamabd }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamabd ne '1' }">
                                          ${doubleEyeFunPo.sopdecloseamabdo }
                                          &nbsp;
                                      </c:if>
                                      <c:if test="${doubleEyeFunMendPo.bdmcloseamabd eq '1' }">
                                          ${doubleEyeFunPo.sopdecloseamabdo }
                                          &nbsp;<font color="red">*</font>
                                      </c:if>
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
                                </c:if>
								</fieldset>
								<br />						
								<fieldset style="border-color: #33FFFF">
								<legend >可选项</legend>
								<table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
                                    <tr>
                                      <td width="15%" height="30" class="table_body" align="center">
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='63'}">
			                                      	${(doubleEyeFunPo.sopdecoverflag == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
			                                      </c:if>	                                      	
		                                      </c:forEach>
                                      </td>
                                      <td width="10%" height="30" class="table_body"><div align="center">交替遮盖试验</div></td>
                                      <td width="11%" class="table_none"><div align="left">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='30'}">
		                                      	${(doubleEyeFunPo.sopdecoverod == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                      </div></td>
                                      <td width="10%" height="30" class="table_body"><div align="right">遮去遮试验</div></td>
                                      <td width="11%" class="table_none"><div align="left">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='30'}">
		                                      	${(doubleEyeFunPo.sopdecoveros == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>
	                                      </c:forEach>
                                      </div></td>
                                      <td width="10%" height="30" class="table_none"><div align="right">集合近点：</div></td>
                                      <td width="11%" class="table_none"><div align="left">
                                          ${doubleEyeFunPo.sopdesumdot }&nbsp;
                                      </div></td>
                                      <td width="15%" height="30" class="table_none"><div align="right">WORTH 4 DOT 远:</div></td>
                                      <td width="11%" class="table_none"><div align="left">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='31'}">
		                                      	${(doubleEyeFunPo.sopdefarworth == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        &nbsp;
                                      </div></td>
									  </td>				
                                    </tr>
                                  </tbody>
                                </table>
                                <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR height="26px">
                                      <TD width="15%" class="table_body" rowspan="2" align="center">
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='64'}">
			                                      	${(doubleEyeFunPo.sopdefacilityflag == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
			                                      </c:if>	                                      	
		                                      </c:forEach>
                                      </td>
                                      <TD class="table_body" rowspan="2" align="center">调节灵敏度</TD>
                                      <TD class="table_none" colspan="7">
	                                      <div align="left">
	                                      	&nbsp;
	                                      	双面镜度数：
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='34'}">
			                                      	${(doubleEyeFunPo.sopdetwosidespec == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
			                                      </c:if>	                                      	
		                                      </c:forEach>
											&nbsp;
											视标：
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='35'}">
			                                      	${(doubleEyeFunPo.sopdetwosidetest == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
			                                      </c:if>	                                      	
		                                      </c:forEach>
		                                    &nbsp;
	                                      </div>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none" height="26"><div align="right">OU</div></TD>
                                      <TD class="table_none">${doubleEyeFunPo.sopdefacilityou }</TD>
                                      <TD class="table_none"><div align="right">OD</div></TD>
                                      <TD class="table_none">${doubleEyeFunPo.sopdefacilityod }</TD>
                                      <TD class="table_none"><div align="right">OS </div></TD>
                                      <TD class="table_none">${doubleEyeFunPo.sopdefacilityos }</TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
								<c:if test="${doubleEyeFunMendPo.bdmfarhetelevel ne '1' && doubleEyeFunMendPo.bdmclosehetelevel ne '1' && doubleEyeFunMendPo.bdmfarheteuprightness ne '1' && doubleEyeFunMendPo.bdmcloseheteuprightness ne '1' }">
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="15%" rowspan="2" class="table_body" align="center">远：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="14%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefarhetelevel }&nbsp;
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdefarhetelevelio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
                                      </div></TD>
                                      <TD width="15%" rowspan="2" class="table_body">近：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${doubleEyeFunPo.sopdeclosehetelevel }&nbsp;
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdeclosehetelevelio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="9" id="sopdefarheteuprightness"  name="doubleEyeFunPo.sopdefarheteuprightness" class="text_input40" value="${doubleEyeFunPo.sopdefarheteuprightness }">&nbsp;&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='33'}">
		                                      	${(doubleEyeFunPo.sopdefarheteuprightnessud == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${doubleEyeFunPo.sopdecloseheteuprightness }&nbsp;&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='33'}">
		                                      	${(doubleEyeFunPo.sopdecloseheteuprightnessud == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
                                      </div></TD>
                                    </TR>
                                    </TBODY>
                                    </TABLE>
                                    </c:if>
                                    <c:if test="${doubleEyeFunMendPo.bdmtestbig ne '1' && doubleEyeFunMendPo.bdmtestsmall ne '1' && doubleEyeFunMendPo.bdmaca ne '1' }">
                                 <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="15%" class="table_body" align="center">测试</TD>
                                      <TD width="8%" class="table_none"><div align="right">+1</div></TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdetestbig }&nbsp;
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdetestbigio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="right">-1</div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                      	${doubleEyeFunPo.sopdetestsmall }&nbsp;
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	${(doubleEyeFunPo.sopdetestsmallio == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    &nbsp;
                                      </div></TD>
                                      <TD width="15%" class="table_none">AC/A：</TD>
                                      <TD class="table_none" colspan="2">${doubleEyeFunPo.sopdeaca }&nbsp;</TD>
                                    </TR>
                                    </TBODY>
                                    </TABLE>
                                  </c:if>
                                  <c:if test="${doubleEyeFunMendPo.bdmbcc ne '1' }">
                                  <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR class="table_body" height="30">
                                    	<TD width="15%" class="table_body"><div align="center">BCC：</div></TD>
                                    	<TD class="table_none" colspan="7">
                                    	${doubleEyeFunPo.sopdebcc }&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										立体视
										<INPUT type="radio" disabled="disabled" value="0" name="doubleEyeFunPo.sopdesolidwatch" checked="checked" ${doubleEyeFunPo.sopdesolidwatch !="0" ? '' : 'checked="checked"' }>
										无
										<INPUT type="radio" disabled="disabled" value="1" name="doubleEyeFunPo.sopdesolidwatch" ${doubleEyeFunPo.sopdesolidwatch !="1" ? '' : 'checked="checked"' }>
										有&nbsp;
									  </TD>
                                    </TR>
                                    </TBODY>
                                  </TABLE>
                                  </c:if>
                                  <c:if test="${doubleEyeFunMendPo.bdmpositiveaccpra ne '1' && doubleEyeFunMendPo.bdmpositiveaccpraodos ne '1' && doubleEyeFunMendPo.bdmnegativeaccnra ne '1' && doubleEyeFunMendPo.bdmnegativeaccnraodos ne '1' }">
                                  <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      	<TD width="15%" class="table_body" rowspan="2" align="center">正/负相对调节</TD>
                                      	<TD class="table_none"><div align="right">PRA：&nbsp;&nbsp;OU</div></TD>
                                      	<TD class="table_none">
	                                     	${doubleEyeFunPo.sopdepositiveaccpra }
	                                     	&nbsp;
									 	</TD>
									 	<TD class="table_none"><div align="right">OD</div></TD>
                                      	<TD class="table_none">
	                                     	${doubleEyeFunPo.sopdepositiveaccpraod }
	                                     	&nbsp;
									 	</TD>
									 	<TD class="table_none"><div align="right">OS</div></TD>
                                      	<TD class="table_none" colspan="2">
	                                     	${doubleEyeFunPo.sopdepositiveaccpraos }
											&nbsp;
									 	</TD>
									</tr>
									<TR>
                                      <TD class="table_none"><div align="right">NRA：&nbsp;&nbsp;OU</div></TD>
                                      <TD class="table_none">
	                                      	${doubleEyeFunPo.sopdenegativeaccnra }
	                                      	&nbsp;
                                      </TD>
                                      <TD class="table_none"><div align="right">OD</div></TD>
                                      	<TD class="table_none">
	                                     	${doubleEyeFunPo.sopdenegativeaccnraod }
									 		&nbsp;
									 	</TD>
									 	<TD class="table_none"><div align="right">OS</div></TD>
                                      	<TD class="table_none"  colspan="2">
	                                     	${doubleEyeFunPo.sopdenegativeaccnraos }
									 		&nbsp;
									 	</TD>
                                    </TR>
                                    </TBODY>
                                    </TABLE>
                                  </c:if>
                                  <c:if test="${doubleEyeFunMendPo.bdmaddodos ne '1' }">
								  <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                  	<TR>
                                      <TD width="15%" class="table_body" align="center">Add</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none">
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      <c:if test="${optionParamPoTmp.fopparentid=='36'}">
	                                      	${(doubleEyeFunPo.sopdeaddod == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
	                                      </c:if>	                                      	
                                         </c:forEach>
									  </TD>
                                      <TD class="table_none"><div align="right">OS：</div></TD>
                                      <TD colspan="2" class="table_none">
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      <c:if test="${optionParamPoTmp.fopparentid=='36'}">
	                                      	${(doubleEyeFunPo.sopdeaddos == optionParamPoTmp.fopparamid)? optionParamPoTmp.fopparamname :'' }
	                                      </c:if>	                                      	
                                         </c:forEach>
                                      </TD>
                                      <td  class="table_none" colspan="6">
                                      	不等像视
										<INPUT disabled="disabled" type="radio" name="doubleEyeFunPo.sopdeequalwatch" value="0" checked="checked" ${doubleEyeFunPo.sopdeequalwatch == "0" ? 'checked="checked"' : '' } onclick="javascript:chageOne();" >
										无
										<INPUT disabled="disabled" type="radio" name="doubleEyeFunPo.sopdeequalwatch" value="1" ${doubleEyeFunPo.sopdeequalwatch == "1" ? 'checked="checked"' : '' } onclick="javascript:chageOne();">
										有
										${doubleEyeFunPo.sopdedifwatch }
									  </td>
                                    </TR>
                                    </TBODY>
                                    </TABLE>
                                  </c:if>
                                  <c:if test="${doubleEyeFunMendPo.bdmcloseamaleveln ne '1' && doubleEyeFunMendPo.bdmcloseamalbu ne '1' && doubleEyeFunMendPo.bdmcloseamabu ne '1' && doubleEyeFunMendPo.bdmcloseamalevelp ne '1' && doubleEyeFunMendPo.bdmcloseamalbd ne '1' && doubleEyeFunMendPo.bdmcloseamabd ne '1' }">
                                  <TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD colspan="8" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="15%" rowspan="2" class="table_body" align="center">远：融像</TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="right">&nbsp;&mdash; </div></TD>
                                      <TD width="7%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramaleveln }
                                      </div></TD>
                                      <TD width="7%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramalevelno }
                                      </div></TD>
                                      <TD width="7%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramalevelnt }
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="8%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramalbu }
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramalbuo }
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramabu } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramabuo } 
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">&nbsp;＋</div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                         ${doubleEyeFunPo.sopdefaramalevelp } 
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                         ${doubleEyeFunPo.sopdefaramalevelpo } 
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                         ${doubleEyeFunPo.sopdefaramalevelpt } 
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                         ${doubleEyeFunPo.sopdefaramalbd } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                         ${doubleEyeFunPo.sopdefaramalbdo } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                         ${doubleEyeFunPo.sopdefaramabd } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                         ${doubleEyeFunPo.sopdefaramabdo } 
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="8" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD rowspan="2" class="table_body" align="center">近：融像</TD>
                                      <TD width="5%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="right">&nbsp;&mdash; </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${doubleEyeFunPo.sopdecloseamaleveln } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${doubleEyeFunPo.sopdecloseamalevelno } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamalevelnt } 
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamalbu } 
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamalbuo } 
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamabu } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamabuo } 
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">&nbsp;＋ </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamalevelp } 
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamalevelpo } 
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamalevelpt } 
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamalbd } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamalbdo } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamabd } 
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                           ${doubleEyeFunPo.sopdecloseamabdo } 
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
                                </c:if>
						</fieldset>	
                  </TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>