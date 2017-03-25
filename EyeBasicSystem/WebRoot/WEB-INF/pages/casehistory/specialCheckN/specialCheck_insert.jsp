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
			specialForm.action = "insertSpecialCheckN.action";
			specialForm.submit();
		}
	}
	
	function refractive(){
			$("img").removeAttr("onclick");
			specialCheckForm.action="refractiveToolN.action?source=refractiveiou";
			specialCheckForm.submit();
	}
	
	function inspection(){
		/*
		if('${systemParameterPo.fspinspectionvisuelle}'=='1'){
			if('${isDoubleEyeFun}' != '1'){
				alert("在进行检查结论之前，请先进行视功能检查！");
				return;
			}
		}
		*/
		$("img").removeAttr("onclick");
		specialCheckForm.action="inspectionToolN.action?source=inspectioniou";
		specialCheckForm.submit();
	}
	
	function doubleEyeFun(){
		$("img").removeAttr("onclick");
		specialCheckForm.action="doubleEyeFunToolN.action?source=doubleeyefuniou";
		specialCheckForm.submit();
	}
	
	function glassHistory(){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		specialCheckForm.action="selectGlassesHistoryN.action?customerID="+'${customerInfoPo.smecicustomerid }';
		specialCheckForm.submit();
	}
	
	function cornealContactlLens(){
		$("img").removeAttr("onclick");
		specialCheckForm.action="cornealContactlLensToolN.action?source=cornealContactlLensu";
		specialCheckForm.submit();
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
		move();
		$('input[moveorder=1]').focus();
	});

	function submitfy(cid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initChargePutInsert.action?moduleID=${moduleID}&customerID="+cid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initChargePutInsert.action?moduleID=${moduleID}&customerID="+cid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【费用提交】";
	}
	
	function contactGlass(){
		specialForm.action="contactGlassToolN.action?source=contactGlassiou";
		$("img").removeAttr("onclick");
		specialForm.submit();
	}

	function fixingInterface(){
		$("img").removeAttr("onclick");
		specialForm.action="fixingInterfaceToolN.action";
		specialForm.submit();
	}
	
    </script>
    </HEAD>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"><BODY bgColor=#ffffff topMargin=5>
    <body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
    <form id="specialForm" name="specialCheckForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="optometryPo.sopoyjumpType" value="${optometryPo.sopoyjumpType}">

<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID"  value="${requestScope.optometryID}" />  
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" />  
<input type="hidden" name="oldOptometryID"  value="${oldOptometryID}" />  

<input type="hidden" id="customerReadonly" value="${moduleID }"/>
<input type="hidden" name="healthCheckPo.sophcchecker" value="${createPerson }"/>
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
							  <TR>
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
						 <s:action name="initCustomerOptometryTitleN" executeResult="true" />		
						<br>
						<fieldset>
							<legend>特殊功能检查</legend>
								<TABLE width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
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
                                          <input moveorder="1" name="healthCheckPo.sophceyeaxisod" value="${healthCheckPo.sophceyeaxisod }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入眼轴！'}]">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center" >
                                        <input moveorder="2" name="healthCheckPo.sophcanteriorchamberdeepod" value="${healthCheckPo.sophcanteriorchamberdeepod }" class="text_input60">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center" >
                                        <input moveorder="3" name="healthCheckPo.sophclensthicknessod" value="${healthCheckPo.sophclensthicknessod }" class="text_input60">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input moveorder="4" name="healthCheckPo.sophcvitreouscavitylengthod" value="${healthCheckPo.sophcvitreouscavitylengthod }" class="text_input60">
                                      mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                          <input moveorder="5" name="healthCheckPo.sophccorneadiameterod" value="${healthCheckPo.sophccorneadiameterod }" class="text_input60" >
                                      mm</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body" >OS</TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="6" name="healthCheckPo.sophceyeaxisos" value="${healthCheckPo.sophceyeaxisos }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入眼轴！'}]">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="7" name="healthCheckPo.sophcanteriorchamberdeepos" value="${healthCheckPo.sophcanteriorchamberdeepos }" class="text_input60">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="8" name="healthCheckPo.sophclensthicknessos" value="${healthCheckPo.sophclensthicknessos }" class="text_input60">
                                        mm</div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="9" name="healthCheckPo.sophcvitreouscavitylengthos" value="${healthCheckPo.sophcvitreouscavitylengthos }" class="text_input60">
                                        mm</div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                          <input moveorder="10" name="healthCheckPo.sophccorneadiameteros" value="${healthCheckPo.sophccorneadiameteros }" class="text_input60" >
                                      mm</div></TD>
                                    </TR>
                                  </TBODY>
							</table>
						<br>
								<TABLE width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <TBODY>
                                    <TR class="table_body">
                                      <TD width="6%" class="Privateborder"><div align="center">&nbsp;</div></TD>
                                      <TD width="8%" class="Privateborder"><div align="center">角膜厚度</div></TD>
                                      <TD width="20%" height="25" class="Privateborder"><div align="center">角膜曲率（SK）</div></TD>
                                      <TD width="20%" height="25" class="Privateborder"><div align="center">角膜曲率（FK）</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">OD</TD>
                                       <TD bgcolor="#E9F2F7" class="Privateborder">
                                        <div align="center">
                                          <input moveorder="11" name="healthCheckPo.sophccornealthicknessod" value="${healthCheckPo.sophccornealthicknessod }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜厚度！'}]">
                                      µm</div></TD>
                                      <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                        <input moveorder="12" name="healthCheckPo.sophccorneacurvatureods1" value="${healthCheckPo.sophccorneacurvatureods1 }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜曲率（SK）！'}]">
                                        @
  										<input moveorder="13" name="healthCheckPo.sophccorneacurvatureods2" value="${healthCheckPo.sophccorneacurvatureods2 }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜曲率（SK）！'}]">
                                      </div></TD>
                                      <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                        <input moveorder="14" name="healthCheckPo.sophccorneacurvatureodf1" value="${healthCheckPo.sophccorneacurvatureodf1 }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜曲率（FK）！'}]">
                                        @
                                        <input moveorder="15" name="healthCheckPo.sophccorneacurvatureodf2" value="${healthCheckPo.sophccorneacurvatureodf2 }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜曲率（FK）！'}]">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body" >OS</TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="16" name="healthCheckPo.sophccornealthicknessos" value="${healthCheckPo.sophccornealthicknessos }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜厚度！'}]">
                                        µm</div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input moveorder="17" name="healthCheckPo.sophccorneacurvatureoss1" value="${healthCheckPo.sophccorneacurvatureoss1 }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜曲率（SK）！'}]">
                                        @
                                        <input moveorder="18" name="healthCheckPo.sophccorneacurvatureoss2" value="${healthCheckPo.sophccorneacurvatureoss2 }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜曲率（SK）！'}]">
                                      </div></TD>
                                      <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                        <input moveorder="19" name="healthCheckPo.sophccorneacurvatureosf1" value="${healthCheckPo.sophccorneacurvatureosf1 }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜曲率（FK）！'}]">
                                        @
                                        <input moveorder="20" name="healthCheckPo.sophccorneacurvatureosf2" value="${healthCheckPo.sophccorneacurvatureosf2 }" class="text_input60" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入角膜曲率（FK）！'}]">
                                      </div></TD>
                                    </TR>
                                  </TBODY>
							</table>
						<br />
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
                                            <TD width="10%" class="Privateborder"><div align="center">分级</div></TD>
                                            <TD width="10%" class="Privateborder"><div align="center">schirme5</div></TD>
                                            <TD width="10%" class="Privateborder"><div align="center">BUT</div></TD>
                                          </TR>
                                          <TR>
                                            <TD class="table_body">OD</TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                               <input moveorder="21" name="healthCheckPo.sophctopographyskod" class="text_input80" value="${healthCheckPo.sophctopographyskod }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入SK！'}]">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="22" name="healthCheckPo.sophctopographyfkod" class="text_input80" value="${healthCheckPo.sophctopographyfkod }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入FK！'}]">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="23" name="healthCheckPo.sophctopographyastod" class="text_input80" value="${healthCheckPo.sophctopographyastod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="24" name="healthCheckPo.sophctopographyeod" class="text_input80" value="${healthCheckPo.sophctopographyeod }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="25" name="healthCheckPo.sophctopographysaiod" class="text_input80" value="${healthCheckPo.sophctopographysaiod }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入SAI！'}]">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                              <input moveorder="26" name="healthCheckPo.sophctopographysriod" class="text_input80" value="${healthCheckPo.sophctopographysriod }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入SRI！'}]">
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                              <select moveorder="27" id="sophctearfilmgradeod1" name="healthCheckPo.sophctearfilmgradeod1" value="${healthCheckPo.sophctearfilmgradeod1 }" >
	                                          <option value="" selected></option>
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='37'}">
			                                      	<option value="${optionParamPoTmp.fopparamid }" ${(healthCheckPo.sophctearfilmgradeod1 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                      </c:if>	                                      	
		                                      </c:forEach>
		                                    </select>
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                              <input moveorder="28" name="healthCheckPo.sophcschirme5od" class="text_input60" value="${healthCheckPo.sophcschirme5od }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入schirme5！'}]">mm
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                              <input moveorder="29" name="healthCheckPo.sophcbu7od" class="text_input60" value="${healthCheckPo.sophcbu7od }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入BUT！'}]">s
                                            </div></TD>
                                          </TR>
                                          <TR>
                                            <TD class="table_body" >OS</TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="30" name="healthCheckPo.sophctopographyskos" class="text_input80" value="${healthCheckPo.sophctopographyskos }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入SK！'}]">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="31" name="healthCheckPo.sophctopographyfkos" class="text_input80" value="${healthCheckPo.sophctopographyfkos }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入FK！'}]">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="32" name="healthCheckPo.sophctopographyastos" class="text_input80" value="${healthCheckPo.sophctopographyastos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="33" name="healthCheckPo.sophctopographyeos" class="text_input80" value="${healthCheckPo.sophctopographyeos }">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="34" name="healthCheckPo.sophctopographysaios" class="text_input80" value="${healthCheckPo.sophctopographysaios }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入SAI！'}]">
                                            </div></TD>
                                            <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                                <input moveorder="35" name="healthCheckPo.sophctopographysrios" class="text_input80" value="${healthCheckPo.sophctopographysrios }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入SRI！'}]">
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                             <select moveorder="36" id="sophctearfilmgradeos1" name="healthCheckPo.sophctearfilmgradeos1" value="${healthCheckPo.sophctearfilmgradeos1 }" >
	                                          <option value="" selected></option>
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='37'}">
			                                      	<option value="${optionParamPoTmp.fopparamid }" ${(healthCheckPo.sophctearfilmgradeos1 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                      </c:if>	                                      	
		                                      </c:forEach>
		                                    </select>
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                <input moveorder="37" name="healthCheckPo.sophcschirme5os" class="text_input60" value="${healthCheckPo.sophcschirme5os }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入schirme5！'}]">mm
                                            </div></TD>
                                            <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                                <input moveorder="38" name="healthCheckPo.sophcbu7os" class="text_input60" value="${healthCheckPo.sophcbu7os }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入BUT！'}]">s
                                            </div></TD>
                                          </TR>
                                        </TBODY>
                                    </TABLE></td>
                                  </tr>
                          </table>
                        </fieldset>
                        <br/>
						<fieldset>
							<legend>角膜内皮细胞计数检查</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td><TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TBODY>
                                      <TR class="table_body" align="center">
                                        <TD width="10%" class="Privateborder">&nbsp;&nbsp;</TD>
                                        <TD width="15%" height="25"class="Privateborder">&nbsp;&nbsp;细胞密度</TD>
                                        <TD width="15%" class="Privateborder">&nbsp;&nbsp;平均细胞面积</TD>
                                        <TD width="15%" class="Privateborder">&nbsp; 六边形细胞比例</TD>
										<TD width="15%" class="Privateborder">&nbsp;&nbsp;变异系数</TD>
										<TD width="15%" class="Privateborder">&nbsp;&nbsp;动态检影检查AST</TD>
                                      </TR>
                                      <TR>
                                        <TD height="30" class="table_body">OD</TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="39" name="healthCheckPo.sophcthicknessod" class="text_input100" value="${healthCheckPo.sophcthicknessod }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入细胞密度！'}]">&nbsp;个/mm<sup>2</sup>
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="40" name="healthCheckPo.sophcareaod" value="${healthCheckPo.sophcareaod }" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入平均细胞面积！'}]">&nbsp;um<sup>2</sup>
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="41" name="healthCheckPo.sophcscaleod" value="${healthCheckPo.sophcscaleod }" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入六边形细胞比例！'}]">&nbsp;%
                                        </div></TD>
										 <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="42" name="healthCheckPo.sophcvariationod" value="${healthCheckPo.sophcvariationod }" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入变异系数！'}]">&nbsp;%
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="43" name="healthCheckPo.sophcdynamicadjustmentod" class="text_input100" value="${healthCheckPo.sophcdynamicadjustmentod }" >
                                        </div></TD>
                                      </TR>
                                      <TR>
                                        <TD height="30" class="table_body" >OS</TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="44" name="healthCheckPo.sophcthicknessos" class="text_input100" value="${healthCheckPo.sophcthicknessos }" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入细胞密度！'}]">&nbsp;个/mm<sup>2</sup>
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="45" name="healthCheckPo.sophcareaos" value="${healthCheckPo.sophcareaos }" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入平均细胞面积！'}]">&nbsp;um<sup>2</sup>
                                        </div></TD>
                                        <TD class="Privateborder" bgcolor="#E9F2F7"><div align="center">
                                          <input moveorder="46" name="healthCheckPo.sophcscaleos" value="${healthCheckPo.sophcscaleos }" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入六边形细胞比例！'}]">&nbsp;%
                                        </div></TD>
										 <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="47" name="healthCheckPo.sophcvariationos" value="${healthCheckPo.sophcvariationos }" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请输入变异系数！'}]">&nbsp;%
                                        </div></TD>
                                        <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                          <input moveorder="48" name="healthCheckPo.sophcdynamicadjustmentos" class="text_input100" value="${healthCheckPo.sophcdynamicadjustmentos }">
                                        </div></TD>
                                      </TR>
                                    </TBODY>
                                </TABLE></td>
                              </tr>
                            </table>
							</fieldset><br />
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
    <TD height=5><br></TD></TR></TBODY></TABLE></DIV></BODY></HTML>