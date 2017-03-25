<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<HEAD>
<TITLE>门店销售</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${ctx}/css/sales/style.css" type="text/css" rel="stylesheet">
<style type="text/css">
<!--
.giftShortcut_mouseover{
    background:url(${ctx }/img/newbtn/btn_giftbtnbg_0.png) no-repeat;
    width:90px;
    height:22px;
    line-height:22px; 
}
.giftShortcut_mouseout{
    background:url(${ctx }/img/newbtn/btn_giftbtnbg_1.png) no-repeat;
    width:90px;
    height:22px;
    line-height:22px;
}

.discountKeysShortcut_mouseover{
    background:url(${ctx }/img/newbtn/btn_keybtnbg_0.png) no-repeat;
    width:40px;
    height:22px;
    line-height:22px; 
    text-align:center;
}
.discountKeysShortcut_mouseout{
    background:url(${ctx }/img/newbtn/btn_keybtnbg_1.png) no-repeat;
    width:40px;
    height:22px;
    line-height:22px;
    text-align:center;
}

-->
</style>
<jsp:include page="shopsales_js.jsp" flush="true" />
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<BODY bgColor=#ffffff topMargin=5  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="frameSalesForm" method="post">
<input id="ssesbrecipetype" type="hidden" name="salesBasicPo.ssesbrecipetype" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesboptid" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbarrearsvalue" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbcheckoutflag" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbvalueflag" value="" />
<input id="ssesboptometryid" type="hidden" name="salesBasicPo.ssesboptometryid" value="" />
<input id="inspectionid" type="hidden" name="salesBasicPo.ssesbinspectionid" value="" />
<input type="hidden" id="smecicustomerid" name="customerInfoPo.smecicustomerid" value="${customerInfoPo.smecicustomerid}"/> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}"/>
<input type="hidden" id="nwtype" name="nwtype" value=""/>
<input type="hidden" id="fcnrenumber" name="fcnrenumber" value="${companyNamePo.fcnrenumber }"/>
<input type="hidden" id="customerprinttype" name="customerprinttype" value="${customerprinttype }"/>
<input type="hidden" name="salesBasicPo.ssesbdiscounttype" value=""/>
<input type="hidden" name="salesBasicPo.ssesbgoodslevel" value=""/>
<input type="hidden" name="salesBasicPo.ssesbdiscountperson" value=""/>
<input type="hidden" name="logindepartmentid" value="${logindepartmentid }"/>
<input type="hidden" name="salesBasicPo.ssesbisgiveyouintegral" value="1"/>
<input type="hidden" id="stealthflag" name="stealthflag" value="${stealthflag}">
<input type="hidden" id="smecigoodscategoryid" name="smecigoodscategoryid" value="${customerInfoPo.smecigoodscategoryid}"/>

<input type="hidden" id="ssetmmemberid" name="toMailPo.ssetmmemberid" value="${customerInfoPo.smecimemberid }"/> 
<input type="hidden" id="ssetmcustomername" name="toMailPo.ssetmcustomername" value="${customerInfoPo.smeciname }"/> 
<input type="hidden" id="ssetmcustomerphone" name="toMailPo.ssetmcustomerphone" value="${customerInfoPo.smeciphone }"/> 
<input type="hidden" id="ssetmareacode" name="toMailPo.ssetmareacode" value=""/> 
<input type="hidden" id="ssetmlinkman" name="toMailPo.ssetmlinkman" value="${customerInfoPo.smeciname }"/> 
<input type="hidden" id="ssetmtomaillistid" name="toMailPo.ssetmtomaillistid" value=""/>
<input type="hidden" id="ssetmmaiiladdress" name="toMailPo.ssetmmaiiladdress" value=""/>

<input type="hidden" id="ssetmprovinces" name="toMailPo.ssetmprovinces" value=""/>
<input type="hidden" id="ssetmcity" name="toMailPo.ssetmcity" value=""/>
<input type="hidden" id="ssetmdistrict" name="toMailPo.ssetmdistrict" value=""/>
<input type="hidden" id="ssetmstreet" name="toMailPo.ssetmstreet" value=""/>
<input type="hidden" id="ssetmissupport" name="toMailPo.ssetmissupport" value=""/>
<input type="hidden" id="ssetmsupportvalue" name="toMailPo.ssetmsupportvalue" value=""/>

<!--一口价状态（参与脚本）-->
<input type="hidden" id="isOnePrice" value="0"/>
<input type="hidden" id="qoneprice" value=""/>
<input type="hidden" id="isqoneprice" value=""/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
 		<TR>
		  <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx }/img/pic/tab_bg.gif></TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
          <c:if test="${person.departmenttype eq '1'}">
          <input type="hidden" id="ssesbshopcode" name="salesBasicPo.ssesbshopcode" value="${person.departmentID }"/>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top>
						<fieldset>
							<legend>顾客资料&nbsp;&nbsp;&nbsp;&nbsp;【<font color="red">可直接输入会员卡号并按【回车键】确认！</font>】</legend>
							<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateTable privateBorder">
							  <tr>
								<td height="26" bgcolor="#cadee8">
								
								<li class="horizontal"> 
								    <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn hisy=hisy title='查找' >
									<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查找' onclick="selCustomer();" >
								</li>
								<li class="horizontal">卡号&nbsp;
									<input id="smecimemberid" name="customerInfoPo.smecimemberid" value="${customerInfoPo.smecimemberid }" onkeydown="selectCustomer();" 
									class="text_input100" size="6" ${ systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' }></li>								
								<li class="horizontal">
									<img name="userName4" src="${ctx }/img/newbtn/btn_customerinsert_0.png" btn=btn title="会员新增" onclick="openMember()"></li>
								<li class="horizontal">
                                	<span onclick="defineSalesTyle('1');" style="cursor: hand"><input type="radio" name="salestype" value="1" checked="checked" >框镜</span>
                                	<span onclick="defineSalesTyle('3');" style="cursor: hand"><input type="radio" name="salestype" value="3">隐形</span>
                                	<span onclick="defineSalesTyle('5');" style="cursor: hand"><input type="radio" name="salestype" value="5">辅料</span>
                                	<input type="hidden" value="1" id="salestype_input" name="salesBasicPo.ssesborderstype"/>
                                </li>
                                <li id="saleserDiv" class="horizontal"><img name="button32" btn=btn id='saleser' src="${ctx}/img/newbtn/btn_changesaleser_0.png" title="更换销售员" align="left" onclick="setSalerPersonList('${tid}','${logindepartmentid}');changeSaleser();resetOnePrice();">
								</li>
								<li id="saleserDiv" class="horizontal">
								    <c:if test="${systemParameterPo.fspsalerdefaultset == '1'}">
										<SELECT id="ssesbsalerid" name="ssesbsalerid" disabled="disabled" onchange="disabledSelect();resetOnePrice();">
                                            <option value="${loginPersonInfoPo.id }" 
                                            <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                                            	<c:forEach var="po" items="${loginPersonInfoPo.personDiscountDetailsPos }">
													${po.fpddgoodslevel }="${po.fpdddiscount }"
												</c:forEach>
                                            </c:if>
                                            <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
                                            	discount="${loginPersonInfoPo.personDiscount }"
                                            </c:if>
                                            selected="selected">${loginPersonInfoPo.personName }</option>
										</SELECT>								    
								    </c:if>
								    <c:if test="${systemParameterPo.fspsalerdefaultset == '2'}">
										<SELECT id="ssesbsalerid" name="ssesbsalerid" disabled="disabled" onchange="disabledSelect();resetOnePrice();" >
										    <option value="">----请选择----</option>
										</SELECT>								    
								    </c:if>
									<input name="salesBasicPo.ssesbsalerid" type="hidden" value='' validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择销售人员！'}]"> 
								</li>
								<c:choose>
									<c:when test="${(permissionPo.keyb==1)}">
										<li class="horizontal">医生：
											<SELECT id="ssesbyishiid" name="salesBasicPo.ssesbyishiid" >
											    <option value="">----请选择----</option>
												<c:forEach var="yishipo" items="${yishiPersonInfoPos}">
													<option value="${yishipo.id }">${yishipo.personName }</option>
												</c:forEach>
											</SELECT>
										</li>
									</c:when>
									<c:otherwise>
										<input type="hidden" id="ssesbyishiid" name="salesBasicPo.ssesbyishiid" value="" />
									</c:otherwise>
								</c:choose>
								</td>
							  </tr>
							  <tr>
								<td height="26" bgcolor="#cadee8">
								<li class="horizontal">顾客姓名:<input class="text_input60" size="2" value="${customerInfoPo.smeciname }" id="smeciname" name="customerInfoPo.smeciname" readOnly="readOnly"></li>
								<li class="horizontal">性别:<input class="text_input20" size="2" id="smecisex" value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" readOnly="readOnly"></li>
								<li class="horizontal">年龄:<input class="text_input20" id="fmmage" value="${customerInfoPo.fmmage }" readOnly="readOnly"></li>
								<li class="horizontal">会员卡类型:<input class="text_input80" id="smecimembername" value="${customerInfoPo.fmmmembername }" readOnly="readOnly"></li>
								<input type="hidden" id="titlediscount" size="2" value="${customerInfoPo.fmmdiscount }" readOnly="readOnly"></li>
								<li class="horizontal">积分:<input class="text_input60" size="2" id="smeciintegral" value="${customerInfoPo.smeciintegral }" readOnly="readOnly"></li>
								<li class="horizontal">
								<c:if test="${not empty(customerInfoPo.smecicustomerid)}">
								  <img name="button32" src="${ctx}/img/newbtn/btn_details_0.png" btn=btn title='详情' align="left" onClick="javascript:details('${customerInfoPo.smecicustomerid }');" >
								</c:if>
								<c:if test="${not empty(customerInfoPo2.smecicustomerid) && empty(customerInfoPo.smecicustomerid)}">
								  <img name="button32" src="${ctx}/img/newbtn/btn_details_0.png" btn=btn title='详情' align="left" onClick="javascript:details('${customerInfoPo2.smecicustomerid }');" >
								</c:if>
								</li>
								</td>
							  </tr>
							</table>
						</fieldset>						
					    <div id="divopmessage">
						<fieldset>
						<legend>处方类型</legend>
						<table width="100%">
							<tr valign="top">
								<td width="30%">
									<table width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
										<tr height="25" align="center">
											<td class="table_title" colspan="3">
											    <input type="radio" name="yiyanguang" ${systemParameterPo.fspdefaultrecipetype == '1' ? 'checked="checked"' : ''} value="1" onclick="changeCheckConclusion('1')">&nbsp;提交处方&nbsp;&nbsp;&nbsp;&nbsp;
											    <input type="radio" name="yiyanguang" ${systemParameterPo.fspdefaultrecipetype == '2' ? 'checked="checked"' : ''} value="2" onclick="changeCheckConclusion('2')">&nbsp;手填处方
											</td>
										</tr>
										<tr height="155" optometry=optometry>
										    <td colspan="3">
										        <iframe id="salesRecipelFrame" name="salesRecipelFrame" src="" width="100%" height="155" frameborder="0" marginheight="0" marginwidth="0" border="0" style="margin-top:-2;margin-left:0;padding：0;padding-top: 0" allowtransparency="yes"></iframe>										
									        </td>
									    </tr>
									    <tr height="25" notoptometry=notoptometry>
											<td class="table_none" width="25%">
												验光号
											</td>
											<td class="table_none" width="76%" colspan="2">
												<input type="text" id="optometryID" name="optometryID" value="${empty(customerInfoPo.smeciname) ? '':optometryID }" readonly="readonly" style="text-align:left;width:98%;border:0px;background-color:#e9f2f7;" onfocus="blur()"/>
											</td>
										</tr>
										<tr height="25" notoptometry=notoptometry>
											<td class="table_none">
												验光师
											</td>
											<td class="table_none" colspan="2">
												<li id="saleserDiv" class="horizontal_onlyRight">
													<select id="optometryPerson" name="optometryPerson" onchange="disabledOptometryPersonSelect()">
													    <option value="" selected="selected">---请选择---</option>
														<c:forEach var="opo" items="${optometryPersonInfoPos}">
															<option value="${opo.id }">${opo.personName }</option>
														</c:forEach>
													</select>
													<input type="hidden" id="optometryPersonID" name="optometryPersonID"/>
												</li>
												<li id="saleserDiv" class="horizontal_onlyRight">
													<img name="button32" btn=btn id="btnlock" src="${ctx}/img/newbtn/lock_0.png" title="解除/锁定" align="left"  onclick="changeOptometryPerson()">
												</li>
											</td>
										</tr>
										<tr height="25" notoptometry=notoptometry>
											<td class="table_none">
												外来处方
											</td>
											<td class="table_none" colspan="2">
												<li id="saleserDiv" class="horizontal_onlyRight">
													<input type="checkbox" id="checkboxwl" name="" onclick="isShowwfdiv(this);searchWF();checkCylZero();"/>&nbsp;&nbsp;&nbsp;&nbsp;外来处方&nbsp;&nbsp;
												</li>
												<li id="saleserDiv" class="horizontal_onlyRight">
													<div id="wfdiv" style="display: none;">
													<select id="selectwf" name="salesBasicPo.ssesbopsource" onchange="">
													    <option value="" selected="selected">---请选择---</option>
														<c:forEach var="fpo" items="${foreignRecipelPos}">
															<option value="${fpo.bfrid }">${fpo.bfrname }</option>
														</c:forEach>
													</select>
													</div>
												</li>
											</td>
										</tr>
										<tr height="25" notoptometry=notoptometry>
											<td class="table_none"> 
												验光时间
											</td>
											<td class="table_none" colspan="2">
					                   				<input class="text_input120"
									               id="ssetmsenddate"
											       name="salesBasicPo.ssesbopdatetime" value=""
											       type="text"
											       readonly="readonly" readonly="readonly" style="text-align:left;width:98%;border:0px;background-color:#e9f2f7;" onfocus="blur()"/>
											</td>
										</tr>
										<tr valign="middle" height="25" notoptometry=notoptometry>
											<TD class="table_none">
											   	处方类型
											</td>
											<td class="table_none" colspan="2">
												<li class="horizontal_onlyRight">
											   		<select id="recipetype" name="recipetype" onChange="selGlassType(this.value);clearGoods();checkCylZero();" >
														<option value="1" selected="selected">远用</option>
														<option value="2">近用</option>
														<option value="3">渐进/双光</option>
														<option value="5">中用</option>
														<option value="4">隐形</option>
														<option value="6">角膜塑形</option>
														<!-- <option value="7">视觉训练</option>  -->
												    </select>
											   	</li>
											  	<li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clearValue();clearOp();$('#nwtype').val('');wlLock();clearGoods();changeWF();selGlassType($('#recipetype').val());checkCylZero();" /></li>
										  	</TD>
									   </tr>
									   <tr valign="middle" height="25" notoptometry=notoptometry>
											<TD class="table_none" colspan="3">
											   	<font color="red">会员使用外来处方或者未通过验光正式提交处方时使用！</font>
											</td>
									   </tr>
		                     		</table>
								</td>
								<td width="75%">
			                        <table id="yuanyong" width="98%" id="chufang1" style="margin-bottom:3px;"  border=0 align=center cellpadding=0 cellspacing=1 class="Privateborder PrivateBorderGreen" id="title2">
		                             <tr>
									   <td width="8%" height="26" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">远用</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">球镜</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">柱镜</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">轴向</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">三棱镜</td>
									   <td width="5%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">基底</td>
									   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">远用瞳距(mm)</td>
									   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">瞳高(mm)</td>
									   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">远用VA</td>
									 </tr>
									 <tr>
									 	<td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">OD</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input needChange="needChange" yyorder="1" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbballglassod" glassType="yuanyong" sphcyl="sphcyl" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input needChange="needChange" yyorder="2" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpostglassod" glassType="yuanyong" sphcyl="sphcyl" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input name="salesBasicPo.ssesbaxesod" yyorder="3" onkeydown="OnKeyDownEnter(this)" glassType="yuanyong" axes="axes"  class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input name="salesBasicPo.ssesbarriseglassod" yyorder="4" onkeydown="OnKeyDownEnter(this)" glassType="yuanyong" ljxj="ljxj"  class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
										<span id="ssesbbasis" >
											<select name="salesBasicPo.ssesbbasisod" yyorder="5" onkeydown="OnKeyDownEnter(this)" glassType="yuanyong" >
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                                </span>
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="6" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterhighod" glassType="yuanyong" tongju="tongju"  class="text_input40" style="width:100%">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="7" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightod" glassType="yuanyong" tonggao="tonggao"  class="text_input40" style="width:100%">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="8" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbfarvaod" glassType="yuanyong" va="va"  class="text_input40" style="width:100%">
										</td>
									 </tr>
									 <tr>
								 	   <td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen"><div align="center">OS</div></td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="9" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="yuanyong" sphcyl="sphcyl"  class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="10" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="yuanyong" sphcyl="sphcyl"  class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="11" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbaxesos" glassType="yuanyong" axes="axes"  class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="12" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbarriseglassos" glassType="yuanyong" ljxj="ljxj"  class="text_input40" style="width:100%" align="center">
										</td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
									   <span id="ssesbbasis" >
									     <select yyorder="13" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbbasisos" glassType="yuanyong" >
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                               </span>
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
									     <input yyorder="14" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterhighos" glassType="yuanyong" tongju="tongju"  class="text_input40" style="width:100%">
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
									     <input yyorder="15" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightos" glassType="yuanyong" tonggao="tonggao"  class="text_input40" style="width:100%" >
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
									     <input yyorder="16" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbfarvaos" glassType="yuanyong" va="va"  class="text_input40" style="width:100%">
									   </td>
									 </tr>
									 <tr>
									   <td width="8%" height="26" bgcolor="dfffdf" class="PrivateBorderGreen" align="left" colspan="3">&nbsp;建议镜片材质:&nbsp;&nbsp;<a id="sopipglassmaterial" glassType="yuanyong"></a></td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="left"  colspan="3">&nbsp;处理方式：&nbsp;&nbsp;<a id="sopipdisposemanner" glassType="yuanyong"></a></td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="left" colspan="3">&nbsp;建议镜框：&nbsp;&nbsp;<a id="sopipsuggestframe" glassType="yuanyong"></a><a id="sopipframeheight" glassType="yuanyong"></a></td>
									 </tr>
									 <tr>
									 	<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center" height="26">
									 		备注
									 	</td>
									 	<td bgcolor="DFFFDF" class="PrivateBorderGreen" colspan="8">
									 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="yuanyong" style="height: 20px;"
	                       			validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
									 	</td>
									 </tr>
									 <tr>
									   <td width="8%" height="26" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">&nbsp;</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">旧瞳距(mm)</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">片高(mm)</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">片宽(mm)</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">中梁(mm)</td>
									   <td width="5%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">镜片通道(mm)</td>
									   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">对角线(mm)</td>									   
									   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">框型</td>
									   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">直径(mm)</td>
									 </tr>
									 <tr>
									 	<td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">手动填写</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input needChange="needChange" yyorder="17" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesboldeyesize" glassType="yuanyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input needChange="needChange" yyorder="18" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbglasshige" glassType="yuanyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input name="salesBasicPo.ssesbglasswigth" yyorder="19" onkeydown="OnKeyDownEnter(this)" glassType="yuanyong" class="text_input40" noreadonly=noreadonly valuetype=number maxlength="5" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input name="salesBasicPo.ssesbframemiddlesize" yyorder="20" onkeydown="OnKeyDownEnter(this)" glassType="yuanyong" class="text_input40" noreadonly=noreadonly valuetype=number maxlength="5" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
											<input name="salesBasicPo.ssesbgalssroad" yyorder="21" onkeydown="OnKeyDownEnter(this)" glassType="yuanyong" class="text_input40" noreadonly=noreadonly valuetype=number maxlength="5" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="22" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbdiagonalline" glassType="yuanyong" class="text_input40" noreadonly=noreadonly valuetype=number maxlength="5" style="width:100%">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="left">
										  <input yyorder="23" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbframeform" glassType="yuanyong" class="text_input40" noreadonly=noreadonly maxlength="10" style="width:100%">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="left">
										  <input yyorder="24" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbframedia" glassType="yuanyong" class="text_input40" noreadonly=noreadonly valuetype=number maxlength="5" style="width:100%">
										</td>
									 </tr>
		                          </table>
		                          <table id="jinyong" style="display: none;" width="98%" id="chufang1" style="margin-bottom:3px;"  border=0 align=center cellpadding=0 cellspacing=1 class="Privateborder PrivateBorderBlue" id="title2">
		                             <tr>
									 	<td width="8%" height="26" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">近用</td>
									   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">球镜</td>
									   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">柱镜</td>
									   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">轴向</td>
									   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">三棱镜</td>
									   <td width="5%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">基底</td>
									   <td width="11%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">近用瞳距(mm)</td>
									   <td width="11%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">瞳高(mm)</td>
									   <td width="11%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">近用VA</td>
									 </tr>
									 <tr>
									 	<td height="26" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">OD</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="1" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbballglassod" glassType="jinyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="2" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbpostglassod" glassType="jinyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="3" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbaxesod" glassType="jinyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
										  <input type="hidden" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbaddod" onblur="if(parseFloat(this.value)<0){alert('下加光不能为负!');this.focus()}" glassType="jinyong" sphcyl="sphcyl"  disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="4" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbarriseglassod" glassType="jinyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">
										<span id="ssesbbasis" >
											<select yyorder="5" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbbasisod" glassType="jinyong" disabled="disabled">
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                                </span>
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="6" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterdistanceod" glassType="jinyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="7" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightod" glassType="jinyong" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="8" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbclosevaod" glassType="jinyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
									 </tr>
									 <tr>
								 	   <td height="26" bgcolor="E1EBFD" class="PrivateBorderBlue"><div align="center">OS</div></td>
									   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="9" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="jinyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="10" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="jinyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="11" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbaxesos" glassType="jinyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
										  <input type="hidden" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbaddos" onblur="if(parseFloat(this.value)<0){alert('下加光不能为负!');this.focus()}" glassType="jinyong" sphcyl="sphcyl"  disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="12" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbarriseglassos" glassType="jinyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
									   <td bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">
									   <span id="ssesbbasis" >
									     <select yyorder="13" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbbasisos" glassType="jinyong" disabled="disabled">
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                               </span>
									   </td>
									   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
									     <input yyorder="14" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterdistanceos" glassType="jinyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
									   </td>
									   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
									     <input yyorder="15" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightos" glassType="jinyong" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%">
									   </td>
									   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
									     <input yyorder="16" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbclosevaos" glassType="jinyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
									   </td>
									 </tr>
									 <tr>
									   <td width="8%" height="26" bgcolor="E1EBFD" align="left" colspan="3">&nbsp;建议镜片材质:&nbsp;&nbsp;<a id="sopipglassmaterial" glassType="jinyong"></a></td>
									   <td width="8%" bgcolor="E1EBFD" align="left"  colspan="3">&nbsp;处理方式：&nbsp;&nbsp;<a id="sopipdisposemanner" glassType="jinyong"></a></td>
									   <td width="8%" bgcolor="E1EBFD" align="left" colspan="3">&nbsp;建议镜框：&nbsp;&nbsp;<a id="sopipsuggestframe" glassType="jinyong"></a><a id="sopipframeheight" glassType="jinyong"></a></td>
									 </tr>
									 <tr>
									 	<td bgcolor="E1EBFD" class="PrivateBorderBlue" align="center" height="26">
									 		备注
									 	</td>
									 	<td bgcolor="E1EBFD" class="PrivateBorderBlue" colspan="9">
									 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="jinyong" style="height: 20px;"
	                       			validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
									 	</td>
									 </tr>
									 <tr>
									   <td width="8%" height="26" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">&nbsp;</td>
									   <td width="8%" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">旧瞳距(mm)</td>
									   <td width="8%" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">片高(mm)</td>
									   <td width="8%" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">片宽(mm)</td>
									   <td width="8%" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">中梁(mm)</td>
									   <td width="5%" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">镜片通道(mm)</td>
									   <td width="11%" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">对角线(mm)</td>
									   <td width="11%" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">框型</td>
									   <td width="11%" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">直径(mm)</td>
									 </tr>
									 <tr>
									 	<td height="26" bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">手动填写</td>
										<td bgcolor="E1EBFD"class="PrivateBorderBlue">
										  <input needChange="needChange" yyorder="17" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesboldeyesize" glassType="jinyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD"class="PrivateBorderBlue">
										  <input needChange="needChange" yyorder="18" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbglasshige" glassType="jinyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD"class="PrivateBorderBlue">
										  <input name="salesBasicPo.ssesbglasswigth" yyorder="19" onkeydown="OnKeyDownEnter(this)" glassType="jinyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD"class="PrivateBorderBlue">
										  <input name="salesBasicPo.ssesbframemiddlesize" yyorder="20" onkeydown="OnKeyDownEnter(this)" glassType="jinyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">
											<input name="salesBasicPo.ssesbgalssroad" yyorder="21" onkeydown="OnKeyDownEnter(this)" glassType="jinyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="E1EBFD"class="PrivateBorderBlue">
										  <input yyorder="22" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbdiagonalline" glassType="jinyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">
										  <input yyorder="23" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbframeform" glassType="jinyong" noreadonly=noreadonly maxlength="10" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="E1EBFD"class="PrivateBorderBlue" align="center">
										  <input yyorder="24" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbframedia" glassType="jinyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%">
										</td>										
									 </tr>
		                          </table>
		                          <table id="jianjin" style="display: none;" width="98%" id="chufang1" style="margin-bottom:3px;"  border=0 align=center cellpadding=0 cellspacing=1 class="Privateborder PrivateBorderYellow" id="title2">
		                             <tr>
									   <td width="9%" height="25" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">双光/渐进</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">球镜</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">柱镜</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">轴向</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">Add</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">三棱镜</td>
									   <td width="3%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">基底</td>
									   <td width="10%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">远用瞳距(mm)</td>
									   <td width="10%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">近用瞳距(mm)</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">瞳高(mm)</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">远用VA</td>
									   <td width="10%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">近用VA</td>
									 </tr>
									 <tr>
									 	<td height="26" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">OD</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="1" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbballglassod" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="2" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbpostglassod" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="3" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbaxesod" glassType="jianjin" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="4" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbaddod" onblur="if(parseFloat(this.value)<0){alert('下加光不能为负!');this.focus()}" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="5" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbarriseglassod" glassType="jianjin" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">
										<span id="ssesbbasis" >
											<select yyorder="6" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbbasisod" glassType="jianjin" disabled="disabled">
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                                </span>
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="7" onkeydown="OnKeyDownEnter(this)" id="ssesbinterhighod" name="salesBasicPo.ssesbinterhighod" glassType="jianjin" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="8" onkeydown="OnKeyDownEnter(this)" id="ssesbinterdistanceod" name="salesBasicPo.ssesbinterdistanceod" glassType="jianjin" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="9" onkeydown="OnKeyDownEnter(this)" id="ssesbpupilheightod" name="salesBasicPo.ssesbpupilheightod" glassType="jianjin" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="11" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbfarvaod" glassType="jianjin" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="10" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbclosevaod" glassType="jianjin" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
									 </tr>
									 <tr>
								 	    <td height="26" bgcolor="FBF3BD" class="PrivateBorderYellow"><div align="center">OS</div></td>
									    <td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="12" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="13" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="14" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbaxesos" glassType="jianjin" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="15" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbaddos" onblur="if(parseFloat(this.value)<0){alert('下加光不能为负!');this.focus()}" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="16" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbarriseglassos" glassType="jianjin" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
									   <td bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">
									   <span id="ssesbbasis" >
									     <select yyorder="17" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbbasisos" glassType="jianjin" disabled="disabled">
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                               </span>
									   </td>
									   <td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="18" onkeydown="OnKeyDownEnter(this)" id="ssesbinterhighos" name="salesBasicPo.ssesbinterhighos" glassType="jianjin" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="19" onkeydown="OnKeyDownEnter(this)" id="ssesbinterdistanceos" name="salesBasicPo.ssesbinterdistanceos" glassType="jianjin" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="20" onkeydown="OnKeyDownEnter(this)" id="ssesbpupilheightos" name="salesBasicPo.ssesbpupilheightos" glassType="jianjin" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="22" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbfarvaos" glassType="jianjin" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderYellow">
										  <input yyorder="21" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbclosevaos" glassType="jianjin" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
									 </tr>
									 <tr>
									   <td width="8%" height="26" bgcolor="FBF3BD" align="left" colspan="3">&nbsp;建议镜片材质:&nbsp;&nbsp;<a id="sopipglassmaterial" glassType="jianjin"></a></td>
									   <td width="8%" bgcolor="FBF3BD" align="left"  colspan="3">&nbsp;处理方式：&nbsp;&nbsp;<a id="sopipdisposemanner" glassType="jianjin"></a></td>
									   <td bgcolor="FBF3BD" align="left" colspan="6">&nbsp;建议镜框：&nbsp;&nbsp;<a id="sopipsuggestframe" glassType="jianjin"></a><a id="sopipframeheight" glassType="jianjin"></a></td>
									 </tr>
									 <tr>
									 	<td bgcolor="FBF3BD" class="PrivateBorderYellow" align="center" height="26">
									 		备注
									 	</td>
									 	<td bgcolor="FBF3BD" class="PrivateBorderYellow" colspan="11">
									 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="jianjin" style="height: 20px;"
	                       			validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
									 	</td>
									 </tr>
									 <tr>
									   <td width="8%" height="26" bgcolor="FBF3BD" class="PrivateBorderBlue" align="center">&nbsp;</td>
									   <td width="8%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">旧瞳距(mm)</td>
									   <td width="8%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">片高(mm)</td>
									   <td width="8%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">片宽(mm)</td>
									   <td width="8%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">中梁(mm)</td>
									   <td width="5%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">镜片通道(mm)</td>
									   <td width="5%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">对角线(mm)</td>
									   <td width="11%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">框型</td>
									   <td width="11%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">直径(mm)</td>
									   <td width="11%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center" colspan="4">&nbsp;</td>
									 </tr>
									 <tr>
									 	<td height="26" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">手动填写</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue">
										  <input needChange="needChange" yyorder="23" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesboldeyesize" glassType="jianjin" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue">
										  <input needChange="needChange" yyorder="24" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbglasshige" glassType="jianjin" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue">
										  <input name="salesBasicPo.ssesbglasswigth" yyorder="25" onkeydown="OnKeyDownEnter(this)" glassType="jianjin" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue">
										  <input name="salesBasicPo.ssesbframemiddlesize" yyorder="26" onkeydown="OnKeyDownEnter(this)" glassType="jianjin" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">
											<input name="salesBasicPo.ssesbgalssroad" yyorder="27" onkeydown="OnKeyDownEnter(this)" glassType="jianjin" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue">
										  <input yyorder="28" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbdiagonalline" glassType="jianjin" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue" align="center" >
										  <input yyorder="29" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbframeform" glassType="jianjin" noreadonly=noreadonly maxlength="10" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">
										  <input yyorder="30" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbframedia" glassType="jianjin" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="FBF3BD"class="PrivateBorderBlue" align="center" colspan="4">&nbsp;</td>										
									 </tr>
		                          </table>
		                          
		                          <table id="zhongyong" style="display: none;" width="98%" id="chufang1" style="margin-bottom:3px;"  border=0 align=center cellpadding=0 cellspacing=1 class="Privateborder PrivateBorderGreen" id="title2">
		                             <tr>
									 	<td width="8%" height="25" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">中用</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">球镜</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">柱镜</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">轴向</td>
									   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">三棱镜</td>
									   <td width="5%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">基底</td>
									   <td width="10%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">中用瞳距(mm)</td>
									   <td width="10%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">瞳高(mm)</td>
									   <td width="10%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">中用VA</td>
									 </tr>
									 <tr>
									 	<td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">OD</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input needChange="needChange" yyorder="1" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbballglassod" glassType="zhongyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input needChange="needChange" yyorder="2" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpostglassod" glassType="zhongyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input name="salesBasicPo.ssesbaxesod" yyorder="3" onkeydown="OnKeyDownEnter(this)" glassType="zhongyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input name="salesBasicPo.ssesbarriseglassod" yyorder="4" onkeydown="OnKeyDownEnter(this)" glassType="zhongyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
										<span id="ssesbbasis" >
											<select name="salesBasicPo.ssesbbasisod" yyorder="5" onkeydown="OnKeyDownEnter(this)" glassType="zhongyong" disabled="disabled">
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                                </span>
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="6" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterhighod" glassType="zhongyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="7" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightod" glassType="zhongyong" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="8" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbfarvaod" glassType="zhongyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
									 </tr>
									 <tr>
								 	   <td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen"><div align="center">OS</div></td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="9" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="zhongyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="10" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="zhongyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="11" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbaxesos" glassType="zhongyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="12" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbarriseglassos" glassType="zhongyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
									   <span id="ssesbbasis" >
									     	<select yyorder="13" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbbasisos" glassType="zhongyong" disabled="disabled">
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                               </span>
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
									     <input yyorder="14" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterhighos" glassType="zhongyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="15" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightos" glassType="zhongyong" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%">
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
									     <input yyorder="16" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbfarvaos" glassType="zhongyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
									   </td>
									 </tr>
									 <tr>
									   <td width="8%" height="26" bgcolor="DFFFDF" align="left" colspan="3">&nbsp;建议镜片材质:&nbsp;&nbsp;<a id="sopipglassmaterial" glassType="zhongyong"></a></td>
									   <td width="8%" bgcolor="DFFFDF" align="left"  colspan="3">&nbsp;处理方式：&nbsp;&nbsp;<a id="sopipdisposemanner" glassType="zhongyong"></a></td>
									   <td width="8%" bgcolor="DFFFDF" align="left" colspan="6">&nbsp;建议镜框：&nbsp;&nbsp;<a id="sopipsuggestframe" glassType="zhongyong"></a><a id="sopipframeheight" glassType="zhongyong"></a></td>
									 </tr>
									 <tr>
									 	<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center" height="26">
									 		备注
									 	</td>
									 	<td bgcolor="DFFFDF" class="PrivateBorderGreen" colspan="8">
									 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="zhongyong" style="height: 20px;"
	                       			validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
									 	</td>
									 </tr>
									 <tr>
									   <td width="8%"  height="26" bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">&nbsp;</td>
									   <td width="8%"  bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">旧瞳距(mm)</td>
									   <td width="8%"  bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">片高(mm)</td>
									   <td width="8%"  bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">片宽(mm)</td>
									   <td width="8%"  bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">中梁(mm)</td>
									   <td width="5%"  bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">镜片通道(mm)</td>
									   <td width="11%" bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">对角线(mm)</td>
									   <td width="11%" bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">框型</td>
									   <td width="11%" bgcolor="DFFFDF" class="PrivateBorderBlue" align="center">直径(mm)</td>
									 </tr>
									 <tr>
									 	<td height="26" bgcolor="dfffdf" class="PrivateBorderBlue" align="center">手动填写</td>
										<td bgcolor="dfffdf" class="PrivateBorderBlue">
										  <input needChange="needChange" yyorder="17" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesboldeyesize" glassType="zhongyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderBlue">
										  <input needChange="needChange" yyorder="18" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbglasshige" glassType="zhongyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderBlue">
										  <input name="salesBasicPo.ssesbglasswigth" yyorder="19" onkeydown="OnKeyDownEnter(this)" glassType="zhongyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf"class="PrivateBorderBlue">
										  <input name="salesBasicPo.ssesbframemiddlesize" yyorder="20" onkeydown="OnKeyDownEnter(this)" glassType="zhongyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderBlue" align="center">
											<input name="salesBasicPo.ssesbgalssroad" yyorder="21" onkeydown="OnKeyDownEnter(this)" glassType="zhongyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%" align="center">
										</td> 
										<td bgcolor="dfffdf" class="PrivateBorderBlue">
										  <input yyorder="22" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbdiagonalline" glassType="zhongyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderBlue" align="center">
										  <input yyorder="23" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbframeform" glassType="zhongyong" noreadonly=noreadonly maxlength="10" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderBlue" align="center">
										  <input yyorder="24" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbframedia" glassType="zhongyong" noreadonly=noreadonly valuetype=number maxlength="5" class="text_input40" style="width:100%">
										</td>										
									 </tr>
		                          </table>
		                          
		                    <table id="yinxing" style="display: none;" width="98%" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder PrivateBorderPink" id="title2">
                             <tr>
							 	<td width="9%" height="23" bgcolor="#F8E0F0" class="PrivateBorderPink">&nbsp;</td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">球镜</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">柱镜</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">轴向</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">曲率</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">直径</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">隐形VA</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">适用镜片</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">片/盒数</div></td>
							 </tr>
							 <tr>
							 	<td height="23" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">OD</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="1" needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbballglassod" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="2"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbpostglassod" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="3" name="salesBasicPo.ssesbaxesod" axes="axes" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
								<td width="13%" bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="4" name="salesBasicPo.ssesbeyecurvatureod1" glassType="yinxing" class="text_input100" style="width:100%">
								  <input type="hidden" name="salesBasicPo.ssesbeyecurvatureod2" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="5" name="salesBasicPo.ssesbdiameterod" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="6" name="salesBasicPo.ssesbconlenvaod" va="va" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="7" name="syjp" readonly="readonly" glassType="yinxing" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="8" name="syjpnum" readonly="readonly" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
							 </tr>
							 <tr>
						 	   <td height="23" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">OS</div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink">
							     <input yyorder="9"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbballglassos" glassType="yinxing" class="text_input100" style="width:100%">
							   </td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink">
							     <input yyorder="10"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbpostglassos" glassType="yinxing" class="text_input100" style="width:100%">
							   </td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink">
							     <input yyorder="11" name="salesBasicPo.ssesbaxesos" axes="axes" glassType="yinxing" class="text_input100" style="width:100%">
							   </td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink">
							     <input yyorder="12" name="salesBasicPo.ssesbeyecurvatureos1" glassType="yinxing" class="text_input100" style="width:100%">
							     <input type="hidden" name="salesBasicPo.ssesbeyecurvatureos2" glassType="yinxing" class="text_input100" style="width:100%">
							   </td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink">
							     <input yyorder="13" name="salesBasicPo.ssesbdiameteros" glassType="yinxing" class="text_input100" style="width:100%">
							   </td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink">
							     <input yyorder="14" name="salesBasicPo.ssesbconlenvaos" va="va" glassType="yinxing" class="text_input100" style="width:100%">
							   </td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="15" name="syjp" readonly="readonly" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink">
								  <input yyorder="16" name="syjpnum" readonly="readonly" glassType="yinxing" class="text_input100" style="width:100%">
								</td>
							 </tr>
							 <tr>
							  <td height="23" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">建议护理液</div></td>
						 	  <td colspan="9" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="left">
							     <span id="jyhly" glassType="yinxing"></span>
							   </div></td>
							 </tr>
							 <tr>
							 	<td bgcolor="#F8E0F0" class="PrivateBorderPink" align="center" height="26">
							 		备注
							 	</td>
							 	<td bgcolor="#F8E0F0" class="PrivateBorderPink" colspan="9">
							 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="yinxing" style="height: 20px;"
	                       			validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
							 	</td>
						     </tr>
                            </table>
                             <table id="suxing" width="98%" style="display: none;" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder PrivateBorderPink" id="title2">                            
                             <tr>
							 	<td width="4%" height="25" bgcolor="#F8E0F0" class="PrivateBorderPink">&nbsp;</td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">球镜</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">柱镜</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">轴向</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">平K</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">陡K</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">e值</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">角膜直径</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">试戴片K</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">K1</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">K2</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">光度</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">降度</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">直径</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">适用镜片</div></td>
								<td width="4%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">片/盒数</div></td>
							 </tr>
							 <tr>
							 	<td height="25" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">OD</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="1" glassType=suxing needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbballglassod" class="text_input60" >
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="2" glassType=suxing needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbpostglassod" class="text_input60" >
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="3" glassType=suxing name="salesBasicPo.ssesbaxesod" axes="axes" class="text_input60" >
								</div></td>
								
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="4" glassType=suxing name="sopipupkod" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="5" glassType=suxing name="sopipdownkod" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="6" glassType=suxing name="sopipeod" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="7" glassType=suxing name="sopipcornealdiameterod" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="8" glassType=suxing name="sopipk0od" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="9" glassType=suxing name="sopipk1od" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="10" glassType=suxing name="sopipk2od" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="11" glassType=suxing name="sopipupcod" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="12" glassType=suxing name="sopipdowncod" class="text_input60" >
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="13" glassType=suxing name="salesBasicPo.ssesbdiameterod" class="text_input60" >
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="14" glassType=suxing name="syjp" readonly="readonly" class="text_input60" >
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="15" glassType=suxing name="syjpnum" readonly="readonly" class="text_input60" >
								</div></td>
							 </tr>
							 <tr>
						 	   <td height="25" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">OS</div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="16" glassType=suxing needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbballglassos" class="text_input60" >
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="17" glassType=suxing needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbpostglassos" class="text_input60" >
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="18" glassType=suxing name="salesBasicPo.ssesbaxesos" axes="axes" class="text_input60" >
							   </div></td>
							   <td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="19" glassType=suxing name="sopipupkos" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="20" glassType=suxing name="sopipdownkos" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="21" glassType=suxing name="sopipeos" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="22" glassType=suxing name="sopipcornealdiameteros" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="23" glassType=suxing name="sopipk0os" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="24" glassType=suxing name="sopipk1os" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="25" glassType=suxing name="sopipk2os" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="26" glassType=suxing name="sopipupcos" class="text_input60" >
								</div></td>
								<td  bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="27" glassType=suxing name="sopipdowncos" class="text_input60" >
								</div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="28" glassType=suxing name="salesBasicPo.ssesbdiameteros"  class="text_input60" >
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="29" glassType=suxing name="syjp" readonly="readonly" class="text_input60" >
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="30" glassType=suxing name="syjpnum" readonly="readonly" class="text_input60" >
								</div></td>
							 </tr>
                            </table>
                            <table id="shijuexunlian" width="98%" style="display: none;" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder PrivateBorderPink" id="title2">
										<TR>
			  								<TD height="26px" colspan='14' class='PrivateBorderGreen' bgcolor='dfffdf'><p>视觉训练&nbsp;&nbsp;&nbsp; 
			  								</TD>
		  								</TR>
		  								<TR>
		  								<TD height="26px"  bgcolor='#DFFFDF' class='PrivateBorderGreen'>&nbsp;</TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>球镜</div></TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>轴向</div></TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>基底</div></TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用瞳距(mm)</div></TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用瞳距(mm)</div></TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD>
		  								<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用VA</div></TD>
		  								</TR>
									 <tr>
									 	<td height="26" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">OD</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="1" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbballglassod" glassType="shijuexunlian" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="2" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbpostglassod" glassType="shijuexunlian" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="3" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbaxesod" glassType="shijuexunlian" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="5" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbarriseglassod" glassType="shijuexunlian" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen" align="center">
										<span id="ssesbbasis" >
											<select yyorder="6" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbbasisod" glassType="shijuexunlian" disabled="disabled">
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                                </span>
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="7" onkeydown="OnKeyDownEnter(this)" id="ssesbinterhighod" name="salesBasicPo.ssesbinterhighod" glassType="shijuexunlian" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="8" onkeydown="OnKeyDownEnter(this)" id="ssesbinterdistanceod" name="salesBasicPo.ssesbinterdistanceod" glassType="shijuexunlian" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="11" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbfarvaod" glassType="shijuexunlian" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="10" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbclosevaod" glassType="shijuexunlian" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
									 </tr>
									 <tr>
								 	    <td height="26" bgcolor="dfffdf" class="PrivateBorderGreen"><div align="center">OS</div></td>
									    <td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="12" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="shijuexunlian" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderGreen">
										  <input yyorder="13" onkeydown="OnKeyDownEnter(this)" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="shijuexunlian" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="FBF3BD" class="PrivateBorderGreen">
										  <input yyorder="14" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbaxesos" glassType="shijuexunlian" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="16" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbarriseglassos" glassType="shijuexunlian" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
										</td>
									   <td bgcolor="dfffdf" class="PrivateBorderGreen" align="center">
									   <span id="ssesbbasis" >
									     <select yyorder="17" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbbasisos" glassType="shijuexunlian" disabled="disabled">
												<option value="" selected="selected">---请选择---</option>
												<s:iterator value="optionParamPolist">
												    <c:if test="${fopparentid == '24'}">
												       <option value="${fopparamid}">${fopparamname}</option>
												    </c:if>
												</s:iterator>
		                                    </select>
		                               </span>
									   </td>
									   <td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="18" onkeydown="OnKeyDownEnter(this)" id="ssesbinterhighos" name="salesBasicPo.ssesbinterhighos" glassType="shijuexunlian" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="19" onkeydown="OnKeyDownEnter(this)" id="ssesbinterdistanceos" name="salesBasicPo.ssesbinterdistanceos" glassType="shijuexunlian" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="22" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbfarvaos" glassType="shijuexunlian" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="dfffdf" class="PrivateBorderGreen">
										  <input yyorder="21" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbclosevaos" glassType="shijuexunlian" va="va" disabled="disabled" class="text_input40" style="width:100%">
										</td>
									 </tr>
									 <tr>
									   <td width="8%" height="26" bgcolor="DFFFDF" align="left" colspan="6">&nbsp;家庭训练:&nbsp;&nbsp;<a id="sopipfamilytrain" glassType="shijuexunlian"></a></td>
									   <td width="8%" bgcolor="DFFFDF" align="left"  colspan="6">&nbsp;训练室训练：&nbsp;&nbsp;<a id="sopiptrainroom" glassType="shijuexunlian"></a></td>									   
									 </tr>
									 
		  					</TABLE>
								</td>
							</tr>
						</table>
						</fieldset>
						</div>
						<div id="divopmessage2">
						<fieldset>
							<legend>商品结算 </legend>
						<table width="100%" cellpadding="2" cellspacing="4" class="Privateborder">
							<tr>
								<td><table width="100%" height="100" border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                          <td width="7%" height="60" bgcolor="#000000"><div align="right" class="STYLE5">原价合计: </div></td>
                                          <td width="9%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="yjje"  vid="td1t">￥0.00</span><input value="0.00" name=salesBasicPo.ssesbpricesum type="hidden"></strong></div></td>
                                          <td width="7%" bgcolor="#000000"><div align="right" class="STYLE5">折扣金额: </div></td>
                                          <td width="9%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="zkje"  vid="td2t">￥0.00</span><input value="" name=salesBasicPo.ssesbdiscountnum type="hidden"></strong></div></td>
                                          <td width="7%" bgcolor="#000000"><div align="right" class="STYLE5">优惠金额: </div></td>
                                          <td width="9%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="yhje"  vid="td6t">￥0.00</span><input value="0.00" name=salesBasicPo.ssesbfavorableamount type="hidden"></strong></div></td>
                                          <c:if test="${systemParameterPo.fspremove == '1'}">
                                          <td width="7%" bgcolor="#000000"><div align="right" class="STYLE5" >抹零金额: </div></td>
                                          <td width="9%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="mljes" vid="td4t">￥0.00</span><input value="0.00" name=salesBasicPo.ssesbrenums type="hidden"></strong></div></td> 
                                          </c:if>
                                          <c:if test="${systemParameterPo.fspremove != '1'}">
                                          <td width="7%" bgcolor="#000000" style="display: none"><div align="right" class="STYLE5" >抹零金额: </div></td>
                                          <td width="9%" bgcolor="#000000" style="display: none"><div align="left"><strong><span class="STYLE4" id="mljes" vid="td4t">￥0.00</span><input value="0.00" name=salesBasicPo.ssesbrenums type="hidden"></strong></div></td> 
                                          </c:if>
                                          <td width="7%" bgcolor="#000000"><div align="right" class="STYLE5">应收金额: </div></td>
                                          <td width="9%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="ysje"  vid="td3t">￥0.00</span><input value="" name=salesBasicPo.ssesbsalesvalue type="hidden"></strong></div></td>
                                          <td width="7%" bgcolor="#000000"><div align="right" class="STYLE5">实收金额:  </div></td>
                                          <td width="9%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="ssje"  vid="td5t">￥0.00</span></strong></div></td>
                                        </tr>
								        <tr>
								        <c:if test="${systemParameterPo.fspremove == '1'}">
                                          <td height="30" colspan="10" class="Privateborder">
                                        </c:if>
                                        <c:if test="${systemParameterPo.fspremove != '1'}">
                                          <td height="30" colspan="8" class="Privateborder">
                                        </c:if>
                                         	<li class="horizontal_onlyRight">
                                          	&nbsp;&nbsp;取镜方式：
                                            <select name="ssesbtakeglasstype" id="ssesbtakeglasstype">
                                              <option value="0" selected="selected">正常</option>
                                              <option value="7">订做7</option>
                                              <option value="10">订做10</option>
                                              <option value="15">订做15</option>
                                              <option value="25">订做25</option>
                                            </select>
                                            &nbsp;&nbsp;取镜日期：
                                              <input id="ssesbtakeglassdata" name="salesBasicPo.ssesbtakeglassdata" type="text" class="text_input120" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'${dqqjsj }'})"/></li>
                                            <li class="horizontal_onlyRight"> 
										    &nbsp;&nbsp;取镜地点：
                                            <select id="ssesblocation" onChange="selLocation();checkFrontMoney();" disabled="disabled">
                                                <option takeglassdate="${departmentsPo.bdptakeglassdate }" value="${departmentsPo.bdpdepartmentid }" >${departmentsPo.bdpdepartmentname}</option>
                                            </select>
                                            <input type="hidden" name="salesBasicPo.ssesblocation" value="${person.departmentID}"/>
                                            </li>
                                            <li class="horizontal_onlyRight"><img name="button32" btn=btn id="btnlock" src="${ctx}/img/newbtn/lock_0.png" title="解除/锁定" align="left"  onclick="setTakeGlassShopCodeList('${logindepartmentid}');changeTakeAddress()"></li>
										    </li>
                                            <li class="horizontal_onlyRight">
	                                            <div id="showtr" style="display: none">&nbsp;&nbsp;委外方式：
		                                            <select id="DragsType" name="salesBasicPo.ssesbdragstype" disabled="disabled">
														<option value="1">委外订单</option>
														<option value="2">委外加工</option>
		 											</select>
	 											</div>
 											</li>
                                            <li class="horizontal_onlyRight">
	                                            <div>&nbsp;&nbsp;加急状态：
		                                            <select id="DragsType1" name="salesBasicPo.ssesbworrytype">
														<option value="1">正常</option>
														<option value="2">加急</option>
		 											</select>
	 											</div>
 											</li>
                                            <li class="horizontal_onlyRight">
	                                            <div>
		                                            &nbsp;&nbsp;<img src="${ctx }/img/newbtn/btn_addmail_0.png" btn=btn title="填写邮寄信息" onclick="toMailInsert()">
	 											</div>
 											</li>
                                            <li class="horizontal_onlyRight">
	 											<div>
		                                           <font color="red" id="mailMsg"></font>
	 											</div>
 											</li>
 											<c:if test="${systemParameterPo.fspdjsbm == '1'}">
 											<li class="horizontal_onlyRight" >
	 											<div>&nbsp;&nbsp;单据识别码:
		                                           <input maxlength="30" name="salesBasicPo.djsbm" id="djsbm" class="text_input"  type="text" >
	 											</div>
 											</li>
 											</c:if>
					      			 </td>
                                     <td rowspan="3" class="Privateborder" colspan="2"><div id="jiesuandiv" align="center">
                                     <img id="buttonsave" name="button" src="${ctx }/img/newbtn/btn_count2_0.png" btn=btn title="结算 " onclick="save()">
                                     </div>    
                                  	</td>
								  </tr>
								  <tr>
                                        <c:if test="${systemParameterPo.fspremove == '1'}">
                                          <td height="30" colspan="10" class="Privateborder">
                                        </c:if>
                                        <c:if test="${systemParameterPo.fspremove != '1'}">
                                          <td height="30" colspan="8" class="Privateborder">
                                        </c:if>
                                          	<li class="horizontal_onlyRight">
                                           	&nbsp;实收金额：<input name="salesBasicPo.ssesbpsalsvalue" id='sesbpsalsvalue' class="text_input" size="8" onblur="checkFrontMoney()">
                                           <c:if test="${customerInfoPo.smeciisfavorable == '1' || customerInfoPo2.smeciisfavorable == '1'  }">
                                           &nbsp;<li class="horizontal_onlyRight">商品打折：<input size="8" name="salesBasicPo.ssesbdiscountrate"  class="text_input"  type="text" readonly="readonly"  onclick="if(checkDiscount()){discount1();}else{};" ></li>
                                           <li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_hy_0.png" btn=btn title='还原折扣' onclick="if (goodsCount()) { afreshdiscount();}"/></li>
                                           </c:if>
                                           <c:if test="${customerInfoPo.smeciisfavorable == '0' }">
                                           <input size="8" name="salesBasicPo.ssesbdiscountrate"  class="text_input"  type="hidden" readonly="readonly"  value="1" >
                                           </c:if>
                                           &nbsp;&nbsp;&nbsp;&nbsp;</li>
                                           <li class="horizontal_onlyRight">
                                           		<!-- 底价：<input size="8" id="downprice" class="text_input" readonly="readonly" type="text" value="0.00"> -->
                                           		一口价：<input size="8" id="oneprice" class="text_input" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="" type="text" onblur="onePrice(this);">&nbsp;
                                           	</li>
                                           	<li class="horizontal_onlyRight">
                                           		<img src="${ctx }/img/newbtn/btn_qianpi_0.png" btn=btn title='签批' onclick="QOnePrice()"/>
                                           		<img src="${ctx }/img/newbtn/btn_hy_0.png" btn=btn title='还原一口价' onclick="resetOnePrice()"/>
                                           	</li>
                                           <c:if test="${systemParameterPo.fspremove == '1' && (customerInfoPo.smeciisfavorable == '1' || customerInfoPo2.smeciisfavorable == '1') }">
                                           <li class="horizontal_onlyRight">抹零金额：<input size="8" id="td10t" class="text_input"  type="text" onblur="if (checkDiscount()) { changeMolingAmount(this);}">&nbsp;</li>
                                           </c:if>
                                           <c:if test="${(systemParameterPo.fspremove != '1') || (customerInfoPo.smeciisfavorable == '0' && customerInfoPo2.smeciisfavorable != '1') }">
                                           <input size="8" id="td10t" class="text_input"  type="hidden">
                                           </c:if>
                                           <li class="horizontal_onlyRight">
                                           <c:forEach var="po" items="${discountShortcutKeysPolist}">
                                           	&nbsp;<span btn=btn class="discountKeysShortcut_mouseover autocut" id="${po.fdkid}" name="m${po.fdkid}" onclick="if (goodsCount()&&checkDiscount()) { setDiscount1('${po.fdkkeyvalues}','${person.id}','1');} " title="${po.fdkkeyname}">${po.fdkkeyname}</span>
                                           </c:forEach>
                                           </li>
                                           </td>
                                          </tr>
                                      </table></td>
							</tr>
						</table>
						<br>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="25%" valign="top">
							<c:if test="${systemParameterPo.fspbarcodetype != '3'}">
							<table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr height="26">
                                <td width="25%" class="table_body">
                                	条码扫描
                                </td>
                                <td class="table_none">
                                	<input type="text" class="text_input200" id="inputscanbarcode" onkeypress="scanGoods(this)" maxlength="26">
                                </td>
                              </tr>
                            </table>
							</c:if>
							<br/>
							<table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr height="26">
                                <td width="25%" class="table_body">
                                	套餐
                                </td>
                                <td class="table_none">
                                	<img src="${ctx }/img/newbtn/btn_tcxuanz_0.png" btn=btn title='套餐选择' onclick="querySetMealGoods()">
                                </td>
                                <td class="table_none">
                                	<img title="套餐查看" src="${ctx }/img/newbtn/btn_usablemeal_0.png" btn=btn onclick="querySetMeal()">
                                </td>
                                <td class="table_none">
                                	<img src="${ctx }/img/newbtn/btn_hy_0.png" btn=btn title='还原套餐' onclick="clearTC();">
                                </td>
                              </tr>
                              <tr height="26" setsealname=setsealname>
                                <td width="25%" class="table_body">
                                	套餐名称<input type="hidden" id="ssesbsetmealid" name="salesBasicPo.ssesbsetmealid" value="${salesBasicPo.ssesbsetmealid }"/><!--套餐ID -->
                                </td>
                                <td class="table_none" id="setmealtitle" colspan="3"></td>
                                <input type="hidden" id="ssesbsetmealtitle" name="salesBasicPo.ssesbsetmealtitle" value=""/>
                              </tr>
                            </table>
							<c:if test="${systemParameterPo.fspbarcodetype == '3' || systemParameterPo.fspbarcodetype == '2'}">
							<br/>
							<table id="kj" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                <td width="32%" class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_jj_0.png" btn=btn title='镜架' onClick="javascript:addSalesGoods('1','F','','','','','');"></td>
                                <td width="36%" class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_jp_0.png" btn=btn title='镜片' onClick="javascript:addSalesGoods('3','R','','','','','');"></td>
                                <td width="33%" class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_jjpj_0.png" btn=btn title='镜架配件' onClick="javascript:addSalesGoods('2','','','1','','','');"></td>
                              </tr> 
                            </table>                           
                            <table id="yx" style="display: none;" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                <td width="26%" class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_yx_0.png" btn=btn title='隐形' onClick="javascript:addSalesGoods('4','R','','','','','');"></td>
                                <td width="37%" class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_hly_0.png" btn=btn title='护理液' onClick="javascript:addSalesGoods('5','','','','','','');"></td>
                                <td width="33%" class="table_none" align="right">
                                  <img name="button2232" src="${ctx }/img/newbtn/btn_yxpj_0.png" btn=btn title='隐形配件' onClick="javascript:addSalesGoods('2','','','2','','','');">
                                </td>
                              </tr>
                            </table>
                            <table id="kjandfl" style="display: none;" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_tyj_0.png" btn=btn title='太阳镜' onClick="javascript:addSalesGoods('6','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_hc_0.png" btn=btn title='耗材' onClick="javascript:addSalesGoods('7','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_lhj_0.png" btn=btn title='老花镜' onClick="javascript:addSalesGoods('8','','','','','','1');"></td>
                              </tr>
                              <tr>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_hly_0.png" btn=btn title='护理液' onClick="javascript:addSalesGoods('5','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_yxpj_0.png" btn=btn title='隐形配件' onClick="javascript:addSalesGoods('2','','','2','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_sg_0.png" btn=btn title='视光' onClick="javascript:addSalesGoods('9','','','','','','1');"></td>
                              </tr>                         
                            </table>                            
                            <table id="yxandfl" style="display: none;" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_jj_0.png" btn=btn title='镜架' onClick="javascript:addSalesGoods('1','F','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_jjpj_0.png" btn=btn title='镜架配件' onClick="javascript:addSalesGoods('2','','','1','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_tyj_0.png" btn=btn title='太阳镜' onClick="javascript:addSalesGoods('6','','','','','','1');"></td>
                              </tr>
                              <tr>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_hc_0.png" btn=btn title='耗材' onClick="javascript:addSalesGoods('7','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_lhj_0.png" btn=btn title='老花镜' onClick="javascript:addSalesGoods('8','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_sg_0.png" btn=btn title='视光' onClick="javascript:addSalesGoods('9','','','','','','1');"></td>
                              </tr>                          
                            </table>                            
                            <table id="pj" style="display: none;" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_jj_0.png" btn=btn title='镜架' onClick="javascript:addSalesGoods('1','F','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_pj_0.png" btn=btn title='配件' onClick="javascript:addSalesGoods('2','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_jp_0.png" btn=btn title='镜片' onClick="javascript:addSalesGoods('3','R', '','','','','1');"></td>                             
                              </tr>
                              <tr>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_yx_0.png" btn=btn title='隐形' onClick="javascript:addSalesGoods('4','R','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_hly_0.png" btn=btn title='护理液' onClick="javascript:addSalesGoods('5','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_tyj_0.png" btn=btn title='太阳镜' onClick="javascript:addSalesGoods('6','','','','','','1');"></td>
                              </tr> 
                              <tr>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_hc_0.png" btn=btn title='耗材' onClick="javascript:addSalesGoods('7','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_lhj_0.png" btn=btn title='老花镜' onClick="javascript:addSalesGoods('8','','','','','','1');"></td>
                                  <td class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_sg_0.png" btn=btn title='视光' onClick="javascript:addSalesGoods('9','','','','','','1');"></td>
                              </tr>                             
                            </table>                            
                            </c:if>
                            <br/>
                            <table id="ourframeorglass" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">  
                              <tr>
                                <td width="50%" class="table_none" align="center" height="26"><img btn=btn title="自架" src="${ctx }/img/newbtn/btn_zj_0.png" onclick="addSalesGoods('1','','','','ZZ','','');"/></td>
                                <td width="50%" class="table_none" align="center"><img btn=btn title="自片" src="${ctx }/img/newbtn/btn_zp_0.png" onclick="addSalesGoods('3','','','','ZZ','','');"/></td>
                              </tr>
                            </table>
                            <table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">  
                              <tr>
                                <td width="50%" class="table_none" align="center">
                                    <img src="${ctx }/img/newbtn/btn_zengpin_0.png" btn=btn title='赠品' onClick="openGoodSingleGiftsValues()">
                                </td>
                                <td width="50%" class="table_none" align="center">&nbsp;</td>
                              </tr>
                            </table>
                        <c:if test="${not empty(giftsList)}">  
							<fieldset>
							<legend>赠品快捷键</legend>
                            <table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">  
                            
                           	   <c:if test="${rowCount == ''}">
							        <c:set value="8" var="rowCount" />       <!-- 总行数 -->
							   </c:if>
							   <c:if test="${rowCount != ''}">
							        <c:set value="${rowCount}" var="rowCount" />       <!-- 总行数 -->
							   </c:if>								            
				               <c:set value="2" var="columnCount" />    <!-- 总列数 -->
				               <c:set value="0" var="currentIndex" />   <!-- 索引变化量 -->
                            
                              <c:forEach begin="1" end="${rowCount}" step="1" >
					           <c:set value="1" var="currentCount" />   <!-- 当前列数 -->
					           <c:set value="0" var="currTdCount" />   <!-- 当前tr内td数 -->
                               <tr>
                                <s:iterator value="giftsList" status="giftIndex">
                                  <c:if test="${giftIndex.index >= currentIndex && currentCount <= columnCount }" >
	                                <td width="50%" class="table_none" align="center" height="26">
	                                  <div btn=btn class="giftShortcut_mouseover autocut" onclick="addGiftByShortcut('${giftIndex.index}');" title="${bgsviewname}">${bgsviewname}</div>
	                                  <input type="hidden" id="giftShortcut${giftIndex.index}" value="{'bgsgoodsid':'${bgsgoodsid}','bgsgoodsbarcode':'${bgsgoodsbarcode}','bgsgoodsname':'${bgsgoodsname}','bgscostprice':'${bgscostprice}',
	                                      'bgsnottaxrate':'${bgsnottaxrate}','bgsgoodstype':'','bgsviewname':'${bgsgoodsname}','bgiwarehouseid':'${bdpwarehouseid}'}" />
	                                </td>
	                                <c:set value="${currTdCount + 1}" var="currTdCount" />
	                                <c:set value="${currentCount + 1}" var="currentCount" />
	                              </c:if>
                                </s:iterator>
                                <c:set value="${currentIndex + 2}" var="currentIndex" />
                                <c:if test="${currTdCount < 2}">
                                    <td width="50%" class="table_none" align="center">&nbsp;</td>
                                </c:if>
                              </tr>
                              </c:forEach>
                            </table>
							</fieldset>
							
						</c:if>	
                            <br/>
                            <table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">  
                              <tr>
                                <td width="25%" class="table_body">附加费用</td>
                                <td class="table_none">
									<select id="additionalCosts" name="additionalCosts" onchange="addCosts(this)">
									  <option value="">---请选择---</option>
									  <s:iterator value="additionalCostsList">
									  <option value="${facid},${facamount}">${facname}</option>
									  </s:iterator>
									</select>
								</td>                                                
                              </tr>
                              <tr>                                            
                                <td width="25%" class="table_body">加工要求</td>
                                <td class="table_none">
	                                <select name="specialRequirements" id="specialRequirements" onchange="addSpecial(this)">
	                                  <option>---请选择---</option>
	                                 <s:iterator value="specialList">
	                                  <option value="${fsrname }">${fsrname}</option>
	                                  </s:iterator>
	                                </select>
                                </td>
                              </tr>
                            </table>
							</td>
							<td width="1%"></td>
                            <td width="75%" valign="top">
							<fieldset>
							<legend>选购商品</legend>
							<table id="goodsInfo" width="100%" height="74" border="0" cellpadding="1" cellspacing="1">
                              <tr>
                                <td valign="top">
                                <table id="goodstable" width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                  <tr>
                                    <td width="5%" class="table_body"><div align="center">选择<input type="checkbox" id="chks" onclick="chkAll()"/></div></td>
                                    <td width="12%" class="table_body"><div align="center">商品名称</div></td>
                                    <td width="5%"  class="table_body"><div align="center">单价</div></td>
                                    <td width="5%"  class="table_body"><div align="center">可用<br>库存</div></td>
                                    <td width="4%"  class="table_body"><div align="center">数量</div></td>
                                    <td width="6%"  class="table_body"><div align="center">原价<br>合计</div></td>
                                    <td width="5%"  class="table_body"><div align="center">折扣率</div></td>
                                 <c:if test="${systemParameterPo.fspisshowdiscount3detail == '1'}">   
                                    <td width="5%"  class="table_body"><div align="center"><font color="red">最大<br>折扣</font></div></td>
                                 </c:if>
                                    <td width="5%"  class="table_body"><div align="center">折扣<br>金额</div></td>
                                    <td width="5%"  class="table_body"><div align="center">优惠<br>金额</div></td>
                                 <c:if test="${systemParameterPo.fspremove == '1'}">
                                    <td width="5%"  class="table_body"><div align="center">抹零<br>金额</div></td>
                                 </c:if>
                                    <td width="6%"  class="table_body"><div align="center">应收<br>金额</div></td>
                                    <td width="9%"  class="table_body"><div align="center">商品描述</div></td>
                                    <td width="4%"  class="table_body"><div align="center">删除</div></td>
                                  </tr>  
                                </table>
                                </td>
                              </tr>
                              <tr>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="2">
                                  <tr>
                                    <td valign="top" width="15%"><table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder" id="zptable">
                                      <tr>
                                        <td height="26" colspan="2" class="table_body">赠品</td>
                                      </tr>
                                    </table></td>
                                    <td width="22%" valign="top">
                                    <table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder" id="fjftable">
                                      <tr>
                                        <td width="35%" height="26" bgcolor="#CADEE8" class="Privateborder">附加费名称</td>
                                        <td width="15%" bgcolor="#CADEE8" class="Privateborder">金额</td>
                                        <td width="10%" bgcolor="#CADEE8" class="Privateborder">数量</td>
                                        <td width="20%" bgcolor="#CADEE8" class="Privateborder">合计</td>
                                        <td width="15%" bgcolor="#CADEE8" class="Privateborder">删除</td>
                                      </tr>
                                    </table></td>
                                    <!-- 加工要求 -->
                                    <td width="22%" valign="top">
                                    <table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder" id="requirementTab">
                                      <tbody>
                                      <tr>
                                        <td height="26" colspan="2" bgcolor="#CADEE8" class="Privateborder">加工要求</td>
                                      </tr>
                                      </tbody>
                                    </table>
                                    </td>
                                  </tr>
                                </table>
                                </td>
                              </tr>
                              <tr>
                              	<td>
                              		<table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              			<tr>
                              				<td height="26" colspan="2" bgcolor="#CADEE8" class="table_body">
			                              		销售备注
			                              	</td>
			                              	<td width="90%" class="table_none">
			                              		<textarea rows="" cols="" id="ssesbsalesremark" name="salesBasicPo.ssesbsalesremark" style="height: 20px" onblur="if($(this).val().length > 200){alert('销售备注长度超过200字节，请进行调整！'); $(this).focus();}"></textarea>
			                              	</td>
                              			</tr>
                              		</table>
                              	</td>
                              </tr>
                            </table>
							</fieldset>							
						   </td>
                          </tr>
                        </table>
                        </div>
						<br>
						<!--ݿEnd--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE>
				</c:if>
				<c:if test="${person.departmenttype ne '1'}">
					<font color="red">当前登录部门类型不是门店类型，无法进行销售！</font>
				</c:if>
</TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
