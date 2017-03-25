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
		specialCheckForm.action="initInspectionSelectHydsy.action?dontshow="+dontshow;
		specialCheckForm.submit();
	}
	function doubleEyeFun(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		specialCheckForm.action="selectDoubleEyeFunHydsy.action?dontshow="+dontshow;
		specialCheckForm.submit();
	}
	function refractive(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		specialCheckForm.action="initRefractiveSelectHydsy.action?dontshow="+dontshow;
		specialCheckForm.submit();
	}
	
	function glassHistory(){
		specialCheckForm.action="selectGlassesHistoryHydsy.action?viewDetail=true";
		$("img").removeAttr("onclick");
		specialCheckForm.submit();
	}
	
	function cornealContactlLens(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		specialCheckForm.action="initCornealContactlLensSelectHydsy.action?dontshow="+dontshow;
		specialCheckForm.submit();
	}
	
	function contactGlass(){
		var dontshow = $('#dontshow').val();
		specialCheckForm.action="initContactGlassSelectHydsy.action?dontshow="+dontshow;
		$("img").removeAttr("onclick");
		specialCheckForm.submit();
	}
</script>
</HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"><BODY bgColor=#ffffff topMargin=5>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="specialForm" name="specialCheckForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="customerID" id="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID" id="optometryBasicID" value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID" id="optometryID" value="${requestScope.optometryID}" /> 
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
						  background=${ctx}/img/pic/tab_top_bg.gif  colspan="2">
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
												  UNSELECTABLE="on">相关检查</TD>
												  <TD width=3><IMG id=tabImgRight__0 height=22 
													src="${ctx}/img/pic/tab_active_right.gif" 
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
										  
										  <c:if test="${chuyanfuyan  == '1'}">
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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
						 <s:action name="initCustomerOptometryTitleHydsy" executeResult="true" />					
						<br>
						<fieldset>
							<legend>特殊功能检查</legend>
								<TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <TBODY>
                                    <TR class="table_body">
                                      <TD width="6%" class="Privateborder"><div align="center">&nbsp;</div></TD>
                                      <TD width="8%" class="Privateborder"><div align="center">眼轴</div></TD>
                                      <TD width="8%" class="Privateborder"><div align="center">前房深</div></TD>
                                      <TD width="8%" class="Privateborder"><div align="center">晶状体厚度</div></TD>
                                      <TD width="8%" class="Privateborder"><div align="center">玻璃体腔长度</div></TD>
                                      <TD width="8%" class="Privateborder"><div align="center">角膜直径</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">OD</TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                          ${healthCheckPo.sophceyeaxisod } 
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center" >
                                         ${healthCheckPo.sophcanteriorchamberdeepod } 
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center" >
                                         ${healthCheckPo.sophclensthicknessod } 
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                         ${healthCheckPo.sophcvitreouscavitylengthod } 
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                           ${healthCheckPo.sophccorneadiameterod } 
                                      mm</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body" >OS</TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                           ${healthCheckPo.sophceyeaxisos } 
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                           ${healthCheckPo.sophcanteriorchamberdeepos }  
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                           ${healthCheckPo.sophclensthicknessos }
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                           ${healthCheckPo.sophcvitreouscavitylengthos } 
                                        mm</div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                           ${healthCheckPo.sophccorneadiameteros } 
                                      mm</div></TD>
                                    </TR>
                                  </TBODY>
							</table>
						<br>
						<TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <TBODY>
                                    <TR class="table_body">
                                      <TD width="10%" class="Privateborder"><div align="center">&nbsp;</div></TD>
                                      <TD width="25%" class="Privateborder"><div align="center">角膜厚度</div></TD>
                                      <TD width="20%" height="25" class="Privateborder"><div align="center">角膜曲率（SK）</div></TD>
                                      <TD width="20%" height="25" class="Privateborder"><div align="center">角膜曲率（FK）</div></TD>
                                      <TD width="25%" colspan="2"  height="25" class="Privateborder"><div align="center">眼压</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">OD</TD>
                                       <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                           ${healthCheckPo.sophccornealthicknessod } 
                                      µm</div></TD>
                                      <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                         ${healthCheckPo.sophccorneacurvatureods1 } 
                                        @
  										 ${healthCheckPo.sophccorneacurvatureods2 } 
                                      </div></TD>
                                      <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                         ${healthCheckPo.sophccorneacurvatureodf1 } 
                                        @
                                         ${healthCheckPo.sophccorneacurvatureodf2 } 
                                      </div></TD>
									  <TD bgcolor="#E9F2F7" class="Privateborder" width="10%" align="center">
									  	${healthCheckPo.sopeciopod }
									  </TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder" width="15%" align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${healthCheckPo.sopeciopselod == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                      
                                      </TD>                                       
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body" >OS</TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                           ${healthCheckPo.sophccornealthicknessos } 
                                        µm</div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                         ${healthCheckPo.sophccorneacurvatureoss1 } 
                                        @
                                         ${healthCheckPo.sophccorneacurvatureoss2 } 
                                      </div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                         ${healthCheckPo.sophccorneacurvatureosf1 } 
                                        @
                                         ${healthCheckPo.sophccorneacurvatureosf2 } 
                                      </div></TD>
									  <TD bgcolor="#E9F2F7" class="Privateborder" width="10%" align="center">
									  	${healthCheckPo.sopeciopos }
									  </TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder" width="15%" align="center">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${healthCheckPo.sopeciopselos == optionParamPoTmp.fopparamid}">
		                                      	${optionParamPoTmp.fopparamname}
		                                      </c:if>	                                      	
	                                      </c:forEach>                                      
                                      </TD>                                      
                                    </TR>
                                  </TBODY>
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
                                            <TD colspan="3" class="Privateborder"><div style="float:right"></div>
                                              <div style="float:left;margin-left:5px"></div>
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
                                            <TD width="10%" class="Privateborder"><div align="center"></div></TD>
                                            <TD width="10%" class="Privateborder"><div align="center"></div></TD>
                                            <TD width="10%" class="Privateborder"><div align="center"></div></TD>
                                          </TR>
                                          <TR>
                                            <TD class="table_body" height="30">OD</TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                               ${healthCheckPo.sophctopographyskod }
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                               ${healthCheckPo.sophctopographyfkod } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                               ${healthCheckPo.sophctopographyastod } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                               ${healthCheckPo.sophctopographyeod } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                               ${healthCheckPo.sophctopographysaiod } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                               ${healthCheckPo.sophctopographysriod } 
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                               
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                               
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                               
                                            </div></TD>
                                          </TR>
                                          <TR>
                                            <TD class="table_body" height="30">OS</TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                 ${healthCheckPo.sophctopographyskos } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                 ${healthCheckPo.sophctopographyfkos } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                 ${healthCheckPo.sophctopographyastos } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                 ${healthCheckPo.sophctopographyeos } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                 ${healthCheckPo.sophctopographysaios } 
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                 ${healthCheckPo.sophctopographysrios } 
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                 
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                 
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                 
                                            </div></TD>
                                          </TR>
                                        </TBODY>
                                    </TABLE></td>
                                  </tr>
                          </table>
                            <br />
                       </fieldset> 
						<fieldset>
							<legend>角膜内皮细胞计数检查</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td><TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TBODY>
                                      <TR class="table_body" align="center">
                                        <TD width="10%" class="Privateborder">&nbsp;&nbsp;</TD>
                                        <TD height="25"class="Privateborder">&nbsp;&nbsp;细胞密度</TD>
                                        <TD width="15%" class="Privateborder">&nbsp;&nbsp;平均细胞面积</TD>
                                        <TD width="15%" class="Privateborder">&nbsp; 六边形细胞比例</TD>
										<TD width="15%" class="Privateborder">&nbsp;&nbsp;变异系数</TD>
										<TD width="15%" class="Privateborder" align="center">动态检影检查AST</TD>
                                      </TR>
                                      <TR>
                                        <TD height="30" class="table_body">OD</TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          ${healthCheckPo.sophcthicknessod }&nbsp;个/mm<sup>2</sup>
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          ${healthCheckPo.sophcareaod }&nbsp;um<sup>2</sup>
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          ${healthCheckPo.sophcscaleod }&nbsp;%
                                        </div></TD>
										 <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          ${healthCheckPo.sophcvariationod }&nbsp;%
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                           ${healthCheckPo.sophcdynamicadjustmentod } &nbsp;
                                        </div></TD>
                                      </TR>
                                      <TR>
                                        <TD height="30" class="table_body" >OS</TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                           ${healthCheckPo.sophcthicknessos } &nbsp;个/mm<sup>2</sup>
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                           ${healthCheckPo.sophcareaos } &nbsp;um<sup>2</sup>
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                           ${healthCheckPo.sophcscaleos } &nbsp;%
                                        </div></TD>
										 <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                           ${healthCheckPo.sophcvariationos } &nbsp;%
                                        </div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                           ${healthCheckPo.sophcdynamicadjustmentos } &nbsp;
                                        </div></TD>
                                      </TR>
                                    </TBODY>
                                </TABLE></td>
                              </tr>
                            </table>
							</fieldset><br />
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff  colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5>&nbsp;&nbsp;</TD></TR></TBODY></TABLE></DIV></BODY></HTML>
