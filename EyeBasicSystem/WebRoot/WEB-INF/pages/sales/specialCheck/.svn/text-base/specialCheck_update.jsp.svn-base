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
    function move(){ //近用回车一动
		$(':input[moveorder]').each(function(){
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('moveorder');
						$(':input[moveorder='+accAdd(index,1)+']').focus();
					}
				});
			});
	}

	function save(){
		if(checkForm(document.all.specialForm)){    
	       	$("img").removeAttr("onclick");
			specialForm.action = "updateSpecialCheck.action";
			if('${copy}'=='copy'){
				specialForm.action = "insertSpecialCheck.action";
			}
			specialCheckForm.submit();
		}
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
		$('#sophctearfilmgradeod1').attr("value","${healthCheckPo.sophctearfilmgradeod1}");
		$('#sophctearfilmgradeod2').attr("value","${healthCheckPo.sophctearfilmgradeod2}");
		$('#sophctearfilmgradeos1').attr("value","${healthCheckPo.sophctearfilmgradeos1}");
		$('#sophctearfilmgradeos2').attr("value","${healthCheckPo.sophctearfilmgradeos2}");
		move();$('input[moveorder=1]').focus();
	});

	function refractive(){
		$("img").removeAttr("onclick");
		specialCheckForm.action="refractiveTool.action?source=refractiveiou";
		specialCheckForm.submit();
	}
	function inspection(){
		if('${systemParameterPo.fspinspectionvisuelle}'=='1'){
			if('${isDoubleEyeFun}' != '1'){
				alert("在进行检查结论之前，请先进行视功能检查！");
				return;
			}
		}
		$("img").removeAttr("onclick");
		specialCheckForm.action="inspectionTool.action?source=inspectioniou";
		specialCheckForm.submit();
	}
	function doubleEyeFun(){
		$("img").removeAttr("onclick");	
		specialCheckForm.action="doubleEyeFunTool.action?source=doubleeyefuniou";
		specialCheckForm.submit();
	}

	function submitfy(cid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initChargePutInsert.action?customerID="+cid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initChargePutInsert.action?customerID="+cid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【费用提交】";
	}
    </script>
    </HEAD>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"><BODY bgColor=#ffffff topMargin=5>
    <body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }><form id="specialForm" name="specialCheckForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="optometryPo.sopoyjumpType" value="${optometryPo.sopoyjumpType}">

<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID"  value="${requestScope.optometryID}" />  
<input type="hidden" name="oldOptometryID"  value="${requestScope.oldOptometryID}" />  
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" />  

<input type="hidden" id="customerReadonly" value="${moduleID }"/>
<input type="hidden" name="healthCheckPo.sophcchecker" value="${healthCheckPo.sophcchecker }"/>
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
												  <TD width=3><IMG id=tabImgLeft__1 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
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
							<td align="right" style="PADDING-LEFT: 2px; HEIGHT: 22px"  background=${ctx }/img/pic/tab_top_bg.gif>
				              <IMG onclick="submitfy('${customerInfoPo.smecicustomerid}')" src="${ctx }/img/newbtn/btn_submitcost_0.png" btn=btn title="费用提交">
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
						  <s:action name="initCustomerOptometryTitle" executeResult="true" />		
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
                                        <input moveorder="1"  name="healthCheckPo.sophccorneacurvatureods1" class="text_input80" value="${healthCheckPo.sophccorneacurvatureods1 }">
                                        @
  										<input moveorder="2" name="healthCheckPo.sophccorneacurvatureods2" class="text_input80" value="${healthCheckPo.sophccorneacurvatureods2 }">
                                      </div></TD>
                                      <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                        <input moveorder="3" name="healthCheckPo.sophccorneacurvatureodf1" class="text_input80" value="${healthCheckPo.sophccorneacurvatureodf1 }">
                                        @
                                        <input moveorder="4" name="healthCheckPo.sophccorneacurvatureodf2" class="text_input80"  value="${healthCheckPo.sophccorneacurvatureodf2 }">
                                      </div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder">
                                        
                                        <div align="center">
                                          <input moveorder="9" name="healthCheckPo.sophceyeaxisod" class="text_input80" value="${healthCheckPo.sophceyeaxisod }">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center" >
                                        <input moveorder="10" name="healthCheckPo.sophcanteriorchamberdeepod" class="text_input80" value="${healthCheckPo.sophcanteriorchamberdeepod }">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center" >
                                        <input moveorder="11" name="healthCheckPo.sophclensthicknessod" class="text_input80" value="${healthCheckPo.sophclensthicknessod }">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input moveorder="12" name="healthCheckPo.sophcvitreouscavitylengthod" class="text_input80" value="${healthCheckPo.sophcvitreouscavitylengthod }">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                          <input moveorder="13" name="healthCheckPo.sophccornealthicknessod" class="text_input80" value="${healthCheckPo.sophccornealthicknessod }" >
                                      µm</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body" >OS</TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input moveorder="5" name="healthCheckPo.sophccorneacurvatureoss1" class="text_input80" value="${healthCheckPo.sophccorneacurvatureoss1 }">
                                        @
                                        <input moveorder="6" name="healthCheckPo.sophccorneacurvatureoss2" class="text_input80" value="${healthCheckPo.sophccorneacurvatureoss2 }">
                                      </div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input moveorder="7" name="healthCheckPo.sophccorneacurvatureosf1" class="text_input80" value="${healthCheckPo.sophccorneacurvatureosf1 }">
                                        @
                                        <input moveorder="8" name="healthCheckPo.sophccorneacurvatureosf2" class="text_input80" value="${healthCheckPo.sophccorneacurvatureosf2 }" >
                                      </div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="14" name="healthCheckPo.sophceyeaxisos" class="text_input80" value="${healthCheckPo.sophceyeaxisos }">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="15" name="healthCheckPo.sophcanteriorchamberdeepos" class="text_input80" value="${healthCheckPo.sophcanteriorchamberdeepos }">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input  moveorder="16" name="healthCheckPo.sophclensthicknessos" class="text_input80" value="${healthCheckPo.sophclensthicknessos }">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="17" name="healthCheckPo.sophcvitreouscavitylengthos" class="text_input80" value="${healthCheckPo.sophcvitreouscavitylengthos }">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="18" name="healthCheckPo.sophccornealthicknessos" class="text_input80" value="${healthCheckPo.sophccornealthicknessos }" >
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
                                               <input moveorder="20" name="healthCheckPo.sophctopographyskod" class="text_input80" value="${healthCheckPo.sophctopographyskod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="19" name="healthCheckPo.sophctopographyfkod" class="text_input80" value="${healthCheckPo.sophctopographyfkod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="21" name="healthCheckPo.sophctopographyastod" class="text_input80" value="${healthCheckPo.sophctopographyastod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="22" name="healthCheckPo.sophctopographyeod" class="text_input80" value="${healthCheckPo.sophctopographyeod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="23" name="healthCheckPo.sophctopographysaiod" class="text_input80" value="${healthCheckPo.sophctopographysaiod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="24" name="healthCheckPo.sophctopographysriod" class="text_input80" value="${healthCheckPo.sophctopographysriod }" >
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                              <select moveorder="31" id="sophctearfilmgradeod1" name="healthCheckPo.sophctearfilmgradeod1" value="${healthCheckPo.sophctearfilmgradeod1 }" >
                                                <option value="">----请选择----</option>
                                                  <option value="Ⅱ">Ⅱ</option>
		     									 <option value="Ⅲ">Ⅲ</option>
		     								     <option value="Ⅳ">Ⅳ</option>
		      									 <option value="Ⅴ">Ⅴ</option>
                                              </select>
                                              <select moveorder="32" id="sophctearfilmgradeod2" name="healthCheckPo.sophctearfilmgradeod2" value="${healthCheckPo.sophctearfilmgradeod2 }" >
                                                <option value="">----请选择----</option>
                                                  <option value="+">+</option>
		      										<option value="-">-</option>
                                              </select>
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                              <input moveorder="33" name="healthCheckPo.sophctearfilmod" class="text_input60" value="${healthCheckPo.sophctearfilmod }" >
                                            </div></TD>
                                          </TR>
                                          <TR>
                                            <TD class="table_body" >OS</TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="26" name="healthCheckPo.sophctopographyskos" class="text_input80" value="${healthCheckPo.sophctopographyskos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="25" name="healthCheckPo.sophctopographyfkos" class="text_input80" value="${healthCheckPo.sophctopographyfkos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="27" name="healthCheckPo.sophctopographyastos" class="text_input80" value="${healthCheckPo.sophctopographyastos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="28" name="healthCheckPo.sophctopographyeos" class="text_input80" value="${healthCheckPo.sophctopographyeos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="29" name="healthCheckPo.sophctopographysaios" class="text_input80" value="${healthCheckPo.sophctopographysaios }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="30" name="healthCheckPo.sophctopographysrios" class="text_input80" value="${healthCheckPo.sophctopographysrios }" >
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                <select moveorder="34" id="sophctearfilmgradeos1" name="healthCheckPo.sophctearfilmgradeos1" value="${healthCheckPo.sophctearfilmgradeos1 }" >
                                                  <option value="">----请选择----</option>
                                                  <option value="Ⅱ">Ⅱ</option>
		     									 <option value="Ⅲ">Ⅲ</option>
		     								     <option value="Ⅳ">Ⅳ</option>
		      									 <option value="Ⅴ">Ⅴ</option>
                                                </select>
                                                <select moveorder="35" id="sophctearfilmgradeos2" name="healthCheckPo.sophctearfilmgradeos2" value="${healthCheckPo.sophctearfilmgradeos2 }" >
                                                  <option value="">----请选择----</option>
                                                  <option value="+">+</option>
		      										<option value="-">-</option>
                                                </select>
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                <input moveorder="36" name="healthCheckPo.sophctearfilmos" class="text_input60" value="${healthCheckPo.sophctearfilmos }" >
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
                                          <input moveorder="37" name="healthCheckPo.sophccontrastsensitivityod" class="text_input100" value="${healthCheckPo.sophccontrastsensitivityod }" >
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="38" name="healthCheckPo.sophcaberrationod" class="text_input100" value="${healthCheckPo.sophcaberrationod }" >
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="39" name="healthCheckPo.sophcdynamicadjustmentod" class="text_input100" value="${healthCheckPo.sophcdynamicadjustmentod }" >
                                        </div></TD>
                                      </TR>
                                      <TR>
                                        <TD height="30" class="table_body" >OS</TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="40" name="healthCheckPo.sophccontrastsensitivityos" class="text_input100" value="${healthCheckPo.sophccontrastsensitivityos }" >
                                        </div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="41" name="healthCheckPo.sophcaberrationos" class="text_input100" value="${healthCheckPo.sophcaberrationos }" >
                                        </div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="42" name="healthCheckPo.sophcdynamicadjustmentos" class="text_input100" value="${healthCheckPo.sophcdynamicadjustmentos }">
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
                          <TD align="left">
                            <div align="left">
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" name="button1"  title="保存" onClick="save()">
                              &nbsp;&nbsp;
                              <img src="${ctx}/img/newbtn/btn_reset_0.png" btn=btn title="重置" onclick="document.specialCheckForm.reset();">
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
    <TD height=5>&nbsp;&nbsp;</TD></TR></TBODY></TABLE></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
