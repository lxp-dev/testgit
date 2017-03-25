<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
	
 
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
 
    var tt=function   enterkey()   
	 {   
	  	if(event.keyCode==13   &&   event.srcElement.type!="submit")   
	        event.keyCode=9;   
	 }   
	function addfunction()
	{
  //var controls = document.all["refractiveCheck"].elements;
		$(":text").each(
			function(){
				$(this).bind("keydown",tt);
			}
		);
		
	}
	function clearfunction(obj)
	{
		$(obj).focus(function(){$(this).unbind('keydown')});
		
	}

function elementKeydown(obj){
	if(event.keyCode==13)
		document.getElementsByName(obj)[0].focus();
}
window.onload=addfunction;
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
	$('#sophctearfilmgradeod1').attr("value","${healthCheckPo.sophctearfilmgradeod1}");
	$('#sophctearfilmgradeod2').attr("value","${healthCheckPo.sophctearfilmgradeod2}");
	$('#sophctearfilmgradeos1').attr("value","${healthCheckPo.sophctearfilmgradeos1}");
	$('#sophctearfilmgradeos2').attr("value","${healthCheckPo.sophctearfilmgradeos2}");
	$('#smecimemberid').attr("readOnly","readOnly");
});

function inspection(){
	var dontshow = $('#dontshow').val();
	$("img").removeAttr("onclick");
	specialCheckForm.action="initInspectionSelect.action?dontshow="+dontshow;
	specialCheckForm.submit();
}
function doubleEyeFun(){
	var dontshow = $('#dontshow').val();
	$("img").removeAttr("onclick");
	specialCheckForm.action="selectDoubleEyeFun.action?dontshow="+dontshow;
	specialCheckForm.submit();
}
function refractive(){
	var dontshow = $('#dontshow').val();
	$("img").removeAttr("onclick");
	specialCheckForm.action="initRefractiveSelect.action?dontshow="+dontshow;
	specialCheckForm.submit();
}
</script>
</HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"><BODY bgColor=#ffffff topMargin=5>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }><form id="specialForm" name="specialCheckForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="customerID" id="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID" id="optometryBasicID" value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID" id="optometryID" value="${requestScope.optometryID}" /> 
<input type="hidden" id="dontshow" name="dontshow" value="${dontshow }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
			<TR>
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx}/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
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
												  onclick="inspection()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">检查结论</TD>
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
												  onclick="doubleEyeFun();" 
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
												  <TD width=3><IMG id=tabImgLeft__0 height=22 
													src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx}/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">特殊功能检查</TD>
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
						</TR>
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
						 <s:action name="initCustomerOptometryTitle" executeResult="true" />					
						<br />		 		
						<br>
						<fieldset>
							<legend>特殊功能检查</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <TBODY>
                                    <TR class="table_body">
                                      <TD height="25" colspan="3" class="Privateborder"><div style="float:left;margin-left:5px">角膜曲率</div>
                                      <div style="float:right"></div></TD>
                                      <TD colspan="5" class="Privateborder"><div style="float:right"></div>
                                      <div style="float:left;margin-left:5px">A超检查</div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="3%" height="25" class="Privateborder">&nbsp;</TD>
                                      <TD width="17%" height="25" class="Privateborder"><div align="center">S</div></TD>
                                      <TD width="17%" height="25" class="Privateborder"><div align="center">F</div></TD>
                                      <TD width="13%" class="Privateborder"><div align="center">眼轴</div></TD>
                                      <TD width="13%" class="Privateborder"><div align="center">前房深</div></TD>
                                      <TD width="13%" class="Privateborder"><div align="center">晶状体厚度</div></TD>
                                      <TD width="13%" class="Privateborder"><div align="center">玻璃体腔长度</div></TD>
                                      <TD width="13%" class="Privateborder"><div align="center">角膜厚度</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">OD</TD>
                                      <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                        <input  name="healthCheckPo.sophccorneacurvatureods1" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccorneacurvatureods1 }">
                                        @
  										<input name="healthCheckPo.sophccorneacurvatureods2" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccorneacurvatureods2 }">
                                      </div></TD>
                                      <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                        <input name="healthCheckPo.sophccorneacurvatureodf1" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccorneacurvatureodf1 }">
                                        @
                                        <input name="healthCheckPo.sophccorneacurvatureodf2" class="text_input80" readOnly="readOnly" onkeydown="elementKeydown('healthCheckPo.sophccorneacurvatureoss1')" onfocus="clearfunction(this)" id="toFocus" value="${healthCheckPo.sophccorneacurvatureodf2 }">
                                      </div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder">
                                        
                                        <div align="center">
                                          <input name="healthCheckPo.sophceyeaxisod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophceyeaxisod }">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center" >
                                        <input name="healthCheckPo.sophcanteriorchamberdeepod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophcanteriorchamberdeepod }">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center" >
                                        <input name="healthCheckPo.sophclensthicknessod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophclensthicknessod }">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input name="healthCheckPo.sophcvitreouscavitylengthod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophcvitreouscavitylengthod }">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                          <input name="healthCheckPo.sophccornealthicknessod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccornealthicknessod }" onkeydown="elementKeydown('healthCheckPo.sophceyeaxisos')" onfocus="clearfunction(this)" id="toFocus">
                                      µm</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body" >OS</TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input name="healthCheckPo.sophccorneacurvatureoss1" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccorneacurvatureoss1 }">
                                        @
                                        <input name="healthCheckPo.sophccorneacurvatureoss2" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccorneacurvatureoss2 }">
                                      </div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input name="healthCheckPo.sophccorneacurvatureosf1" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccorneacurvatureosf1 }">
                                        @
                                        <input name="healthCheckPo.sophccorneacurvatureosf2" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccorneacurvatureosf2 }" onkeydown="elementKeydown('healthCheckPo.sophceyeaxisod')" onfocus="clearfunction(this)" id="toFocus">
                                      </div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input name="healthCheckPo.sophceyeaxisos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophceyeaxisos }">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input name="healthCheckPo.sophcanteriorchamberdeepos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophcanteriorchamberdeepos }">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input name="healthCheckPo.sophclensthicknessos" class="text_input40" readOnly="readOnly" value="${healthCheckPo.sophclensthicknessos }">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input name="healthCheckPo.sophcvitreouscavitylengthos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophcvitreouscavitylengthos }">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input name="healthCheckPo.sophccornealthicknessos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophccornealthicknessos }" onkeydown="elementKeydown('healthCheckPo.sophctopographyfkod')" onfocus="clearfunction(this)" id="toFocus">
                                        µm</div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						<br>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td><TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                        <TBODY>
                                          <TR class="table_body">
                                            <TD height="25" colspan="7" class="Privateborder"><div style="float:right"></div>
                                              <div style="float:left;margin-left:5px">角膜地形图</div>
                                            </TD>
                                            <TD colspan="2" class="Privateborder"><div style="float:right"></div>
                                              <div style="float:left;margin-left:5px">泪膜检测</div>
                                            </TD>
                                          </TR>
                                          <TR>
                                            <TD width="4%" height="25" class="Privateborder">&nbsp;</TD>
                                            <TD width="8%" height="25" class="Privateborder"><div align="center">SK</div></TD>
                                            <TD width="8%" height="25" class="Privateborder"><div align="center">FK</div></TD>
                                            <TD width="8%" height="25" class="Privateborder"><div align="center">AST</div></TD>
                                            <TD width="8%" height="25" class="Privateborder"><div align="center">E值</div></TD>
                                            <TD width="8%" height="25" class="Privateborder"><div align="center">SAI</div></TD>
                                            <TD width="8%" height="25" class="Privateborder"><div align="center">SRI</div></TD>
                                            <TD width="31%" class="Privateborder"><div align="center">分级</div></TD>
                                            <TD width="17%" class="Privateborder">&nbsp;</TD>
                                          </TR>
                                          <TR>
                                            <TD class="table_body">OD</TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input name="healthCheckPo.sophctopographyskod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographyskod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input name="healthCheckPo.sophctopographyfkod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographyfkod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input name="healthCheckPo.sophctopographyastod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographyastod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input name="healthCheckPo.sophctopographyeod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographyeod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input name="healthCheckPo.sophctopographysaiod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographysaiod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input name="healthCheckPo.sophctopographysriod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographysriod }" onkeydown="elementKeydown('healthCheckPo.sophctopographyfkos')" onfocus="clearfunction(this)" id="toFocus">
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                              <select id="sophctearfilmgradeod1" name="healthCheckPo.sophctearfilmgradeod1" disabled value="${healthCheckPo.sophctearfilmgradeod1 }" onkeydown="elementKeydown('healthCheckPo.sophctearfilmgradeod2')" onfocus="clearfunction(this)" id="toFocus">
                                                <option value="">----请选择----</option>
                                                  <option value="Ⅱ">Ⅱ</option>
		     									 <option value="Ⅲ">Ⅲ</option>
		     								     <option value="Ⅳ">Ⅳ</option>
		      									 <option value="Ⅴ">Ⅴ</option>
                                              </select>
                                              <select id="sophctearfilmgradeod2" name="healthCheckPo.sophctearfilmgradeod2" disabled value="${healthCheckPo.sophctearfilmgradeod2 }" onkeydown="elementKeydown('healthCheckPo.sophctearfilmod')" onfocus="clearfunction(this)" id="toFocus">
                                                <option value="">----请选择----</option>
                                                  <option value="+">+</option>
		      										<option value="-">-</option>
                                              </select>
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                              <input name="healthCheckPo.sophctearfilmod" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctearfilmod }" onkeydown="elementKeydown('healthCheckPo.sophctearfilmgradeos1')" onfocus="clearfunction(this)" id="toFocus">
                                            </div></TD>
                                          </TR>
                                          <TR>
                                            <TD class="table_body" >OS</TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input name="healthCheckPo.sophctopographyskos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographyskos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                            	<input name="healthCheckPo.sophctopographyfkos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographyfkos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input name="healthCheckPo.sophctopographyastos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographyastos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input name="healthCheckPo.sophctopographyeos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographyeos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input name="healthCheckPo.sophctopographysaios" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographysaios }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input name="healthCheckPo.sophctopographysrios" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctopographysrios }" onkeydown="elementKeydown('healthCheckPo.sophctearfilmgradeod1')" onfocus="clearfunction(this)" id="toFocus">
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                <select id="sophctearfilmgradeos1" name="healthCheckPo.sophctearfilmgradeos1" disabled value="${healthCheckPo.sophctearfilmgradeos1 }" onkeydown="elementKeydown('healthCheckPo.sophctearfilmgradeos2')" onfocus="clearfunction(this)" id="toFocus">
                                                  <option value="">----请选择----</option>
                                                  <option value="Ⅱ">Ⅱ</option>
		     									 <option value="Ⅲ">Ⅲ</option>
		     								     <option value="Ⅳ">Ⅳ</option>
		      									 <option value="Ⅴ">Ⅴ</option>
                                                </select>
                                                <select id="sophctearfilmgradeos2" name="healthCheckPo.sophctearfilmgradeos2" disabled value="${healthCheckPo.sophctearfilmgradeos2 }"  onkeydown="elementKeydown('healthCheckPo.sophctearfilmos')" onfocus="clearfunction(this)" id="toFocus">
                                                  <option value="">----请选择----</option>
                                                  <option value="+">+</option>
		      										<option value="-">-</option>
                                                </select>
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                <input name="healthCheckPo.sophctearfilmos" class="text_input80" readOnly="readOnly" value="${healthCheckPo.sophctearfilmos }" onkeydown="elementKeydown('healthCheckPo.sophccontrastsensitivityod')" onfocus="clearfunction(this)" id="toFocus">
                                            </div></TD>
                                          </TR>
                                        </TBODY>
                                    </TABLE></td>
                                  </tr>
                          </table>
						    <br>
						    <table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td><TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TBODY>
                                      <TR class="table_body">
                                        <TD height="25" colspan="2" class="Privateborder"><div style="float:left;margin-left:5px">对比敏感度检查</div>
                                        <div style="float:right"></div></TD>
                                        <TD width="32%" class="Privateborder">&nbsp;&nbsp;像差检查</TD>
                                        <TD width="32%" class="Privateborder">&nbsp;&nbsp;动态调节检查</TD>
                                      </TR>
                                      <TR>
                                        <TD width="4%" height="25" class="Privateborder">&nbsp;</TD>
                                        <TD width="32%" height="25" class="Privateborder"><div align="center">FK</div></TD>
                                        <TD bgcolor="#FFFFFF" class="Privateborder"><div align="center">SK</div></TD>
                                        <TD bgcolor="#FFFFFF" class="Privateborder"><div align="center">AST</div></TD>
                                      </TR>
                                      <TR>
                                        <TD height="30" class="table_body">OD</TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input name="healthCheckPo.sophccontrastsensitivityod" class="text_input100" readOnly="readOnly" value="${healthCheckPo.sophccontrastsensitivityod }" onkeydown="elementKeydown('healthCheckPo.sophccontrastsensitivityos')" onfocus="clearfunction(this)" id="toFocus">
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input name="healthCheckPo.sophcaberrationod" class="text_input100" readOnly="readOnly" value="${healthCheckPo.sophcaberrationod }" onkeydown="elementKeydown('healthCheckPo.sophcaberrationos')" onfocus="clearfunction(this)" id="toFocus">
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input name="healthCheckPo.sophcdynamicadjustmentod" class="text_input100" readOnly="readOnly" value="${healthCheckPo.sophcdynamicadjustmentod }" onkeydown="elementKeydown('healthCheckPo.sophcdynamicadjustmentos')" onfocus="clearfunction(this)" id="toFocus">
                                        </div></TD>
                                      </TR>
                                      <TR>
                                        <TD height="30" class="table_body" >OS</TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input name="healthCheckPo.sophccontrastsensitivityos" class="text_input100" readOnly="readOnly" value="${healthCheckPo.sophccontrastsensitivityos }" onkeydown="elementKeydown('healthCheckPo.sophcaberrationod')" onfocus="clearfunction(this)" id="toFocus">
                                        </div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input name="healthCheckPo.sophcaberrationos" class="text_input100" readOnly="readOnly" value="${healthCheckPo.sophcaberrationos }" onkeydown="elementKeydown('healthCheckPo.sophcdynamicadjustmentod')" onfocus="clearfunction(this)" id="toFocus">
                                        </div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input name="healthCheckPo.sophcdynamicadjustmentos" class="text_input100" readOnly="readOnly" value="${healthCheckPo.sophcdynamicadjustmentos }">
                                        </div></TD>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5>&nbsp;&nbsp;</TD></TR></TBODY></TABLE></DIV></BODY></HTML>
