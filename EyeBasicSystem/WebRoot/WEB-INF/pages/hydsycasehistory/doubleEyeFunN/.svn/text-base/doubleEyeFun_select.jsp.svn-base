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
		//obj.value = obj.value.replace(/^[^\+-]|[^\d]*$/,'');
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
		doubleEyeFunForm.action="selectSpecialCheckHydsy.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function refractive(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="initRefractiveSelectHydsy.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function inspection(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="initInspectionSelectHydsy.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function glassHistory(){
		doubleEyeFunForm.action="selectGlassesHistoryHydsy.action?viewDetail=true";
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
		doubleEyeFunForm.action="initCornealContactlLensSelectHydsy.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function contactGlass(){
		var dontshow = $('#dontshow').val();
		doubleEyeFunForm.action="initContactGlassSelectHydsy.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
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
						<s:action name="initCustomerOptometryTitleHydsy" executeResult="true" />		
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
										<c:if test="${doubleEyeFunPo.sopdeinspecteyefun eq '0'}">
											双眼视功能检查:
											是<input id="radio02" disabled="disabled" name="radio02" type="radio" value="0" checked="checked"  onclick="block()"/>&nbsp;
											否<input id="radio02" disabled="disabled" name="radio02" type="radio" value="1" onclick="none()"/>
										</c:if>
										<c:if test="${doubleEyeFunPo.sopdeinspecteyefun ne '0'}">
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
								<table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
                                    <tr>
                                      <td width="10%" height="30" class="table_body" align="center">交替遮盖试验</td>
                                      <td width="11%" class="table_none">
                                      <div align="left">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdecoverod == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                      
                                      </div>
                                      </td>
                                      <td width="10%" height="30" class="table_body"><div align="right">遮去遮试验</div></td>
                                      <td width="11%" class="table_none">
                                      <div align="left">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdecoveros == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                       
                                      </div>
                                      </td>
                                      <td width="10%" height="30" class="table_none"><div align="right">集合近点：</div></td>
                                      <td width="11%" class="table_none">
                                      <div align="left">
                                          ${doubleEyeFunPo.sopdesumdot }
                                      </div></td>
                                      <td width="15%" height="30" class="table_none"><div align="right">WORTH 4 DOT 远:</div></td>
                                      <td width="11%" class="table_none">
                                      <div align="left">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdefarworth == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                        
                                      </div>
                                      </td>
									  </td>
                                    </tr>
                                  </tbody>
                                </table>
								  <br>
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="15%" rowspan="2" class="table_body" align="center">远：隐斜</TD>
                                      <TD width="8%" class="table_none" height="25"><div align="right">水平</div></TD>
                                      <TD width="14%" class="table_none">
                                      <div align="center">
                                        ${doubleEyeFunPo.sopdefarhetelevel }
                                      </div></TD>
                                      <TD width="13%" class="table_none">
                                      <div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdefarhetelevelio == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                      
                                      </div>
                                      </TD>
                                      <TD width="15%" rowspan="2" class="table_body" align="center">近：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                          ${doubleEyeFunPo.sopdeclosehetelevel }
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdeclosehetelevelio == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                        
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none" height="25"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefarheteuprightness }&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdefarheteuprightnessud == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                         
                                        &nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                          ${doubleEyeFunPo.sopdecloseheteuprightness }
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdecloseheteuprightnessud == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                      
                                          &nbsp;&nbsp;
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="15%" height="25" class="table_body" align="center">测试</TD>
                                      <TD width="8%" class="table_none"><div align="right">+1</div></TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                        	${doubleEyeFunPo.sopdetestbig }:
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdetestbigio == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                        	
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="right">-1</div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
	                                      	${doubleEyeFunPo.sopdetestsmall }:
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdetestsmallio == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach> 	                                      	
                                      </div></TD>
                                      <TD width="15%" class="table_none">AC/A：</TD>
                                      <TD width="8%" class="table_none" colspan="2">${doubleEyeFunPo.sopdeaca }</TD>
                                    </TR>
                               
                                    <TR class="table_body" height="30">
                                    	<TD width="13%" rowspan="2" class="table_body"><div align="center">BCC：</div></TD>
                                    	<TD class="table_none"><div align="right">&nbsp;&nbsp;OU</div></TD>
                                    	<TD width="5%" class="table_none">
                                    	   ${doubleEyeFunPo.sopdebccou}&nbsp;
									    </TD>
									    
									    <TD class="table_none"><div align="right">&nbsp;&nbsp;OD</div></TD>
                                    	<TD width="5%" class="table_none">
                                    	   ${doubleEyeFunPo.sopdebccod }&nbsp;
									    </TD>
									    
									    <TD class="table_none"><div align="right">&nbsp;&nbsp;OS</div></TD>
                                    	<TD width="5%" class="table_none" colspan="2">
                                    	   ${doubleEyeFunPo.sopdebccos}&nbsp;
									    </TD>									  
                                    </TR>
                                    <TR class="table_body" height="30">
						              <TD class="table_none"><div align="right">&nbsp;&nbsp;立体视</div></TD>
                                    	<TD width="15%" class="table_none" colspan="7">
										<INPUT type="radio" disabled="disabled" value="0" name="doubleEyeFunPo.sopdesolidwatch" checked="checked" ${doubleEyeFunPo.sopdesolidwatch !="0" ? '' : 'checked="checked"' }>
										无
										<INPUT type="radio" disabled="disabled" value="1" name="doubleEyeFunPo.sopdesolidwatch" ${doubleEyeFunPo.sopdesolidwatch !="1" ? '' : 'checked="checked"' }>
										有&nbsp;<font color="red">*</font>
									  </TD>								  
                                    </TR>
                                    
                                    <tr>
                                    	<td height="5"></td>
                                    </tr>
                                    <TR>
                                      	<TD class="table_body" rowspan="2" align="center">正/负相对调节</TD>
                                      	<TD class="table_none"><div align="right">PRA：&nbsp;&nbsp;OU</div></TD>
                                      	<TD class="table_none">
	                                     	${doubleEyeFunPo.sopdepositiveaccpra } 
									 	</TD>
									 	<TD class="table_none"><div align="right">OD</div></TD>
                                      	<TD class="table_none">
	                                     	${doubleEyeFunPo.sopdepositiveaccpraod }
									 	</TD>
									 	<TD class="table_none"><div align="right">OS</div></TD>
                                      	<TD class="table_none" colspan="2">
	                                     	${doubleEyeFunPo.sopdepositiveaccpraos } 
									 	</TD>
									</tr>
									<TR>
                                      <TD class="table_none"><div align="right">NRA：&nbsp;&nbsp;OU</div></TD>
                                      <TD class="table_none">
                                      	${doubleEyeFunPo.sopdenegativeaccnra }
                                      </TD>
                                      <TD class="table_none"><div align="right">OD</div></TD>
                                      	<TD class="table_none">
	                                     	${doubleEyeFunPo.sopdenegativeaccnraod } 
									 	</TD>
									 	<TD class="table_none"><div align="right">OS</div></TD>
                                      	<TD class="table_none"  colspan="2">
	                                     	${doubleEyeFunPo.sopdenegativeaccnraos }
									 	</TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
								
								</fieldset>
								<br />						
								<fieldset style="border-color: #33FFFF">
								<legend >可选项</legend>
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                  	<TR>
                                      <TD class="table_body" align="center">Add</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdeaddod == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>	                                      
									  </TD>
                                      <TD class="table_none"><div align="right">OS：</div></TD>
                                      <TD colspan="2" class="table_none">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${doubleEyeFunPo.sopdeaddos == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                      
                                      <div align="right"></div></TD>
                                      <td  class="table_none" colspan="6">
                                      	不等像视
										<INPUT  type="radio" disabled="disabled" name="doubleEyeFunPo.sopdeequalwatch" value="0" checked="checked" ${doubleEyeFunPo.sopdeequalwatch !="0" ? '' : 'checked="checked"' } onclick="javascript:chageOne();" >
										无
										<INPUT  type="radio" disabled="disabled" name="doubleEyeFunPo.sopdeequalwatch" value="1" ${doubleEyeFunPo.sopdeequalwatch !="1" ? '' : 'checked="checked"' } onclick="javascript:chageOne();">
										有
										<input moveorder="37" disabled="disabled" id="sopdedifwatch" name="doubleEyeFunPo.sopdedifwatch" class="text_input100" value="${doubleEyeFunPo.sopdedifwatch }" readonly="readonly">
									  </td>
                                    </TR>
                                    <TR>
                                      <TD colspan="8" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="11%" rowspan="2" class="table_body" align="center">远：融像</TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none" height="25"><div align="right">－ </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramaleveln }
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramalevelno }
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramalevelnt }
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramalbu }
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramalbuo }
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramabu }
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        ${doubleEyeFunPo.sopdefaramabuo }
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none" height="25"><div align="right">＋ </div></TD>
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
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none" height="25"><div align="right">－ </div></TD>
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
                                      <TD width="6%" class="table_none"><div align="center">
                                          ${doubleEyeFunPo.sopdecloseamabuo }
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none" height="25"><div align="right">＋ </div></TD>
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
							<br>
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