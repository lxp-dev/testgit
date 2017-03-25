<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
<HEAD>
<TITLE>FrameWork</TITLE>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
.STYLE4 {color: #FF0000}
.STYLE5 {color: #FFFF00; font-weight: bold; }

.PrivateBorderBlue{
	border: 1px solid #9AaBCFA;
}

.PrivateBorderGreen{
	border: 1px solid #6BEF72;
}
.salesout{
	background:transparent;border:0px;
}
.PrivateBorderYellow{
	border: 1px solid #F5E25C;
}

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

-->
</style>

<jsp:include page="salseAll_js.jsp" flush="true" />
<BODY bgColor=#ffffff topMargin=5  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="frameSalesForm" method="post">
<input id="ssesbrecipetype" type="hidden" name="salesBasicPo.ssesbrecipetype" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesboptid" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbarrearsvalue" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbcheckoutflag" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbvalueflag" value="" />
<input id="ssesboptometryid" type="hidden" name="salesBasicPo.ssesboptometryid" value="" />
<input id="inspectionid" type="hidden" name="salesBasicPo.ssesbinspectionid" value="" />
<input type="hidden" name="customerInfoPo.smecicustomerid" value="${customerInfoPo.smecicustomerid}"/> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}"/>
<input type="hidden" id="nwtype" name="nwtype" value=""/>
<input type="hidden" id="salseID" name="salseID" value="${salseID }"/>
<input type="hidden" id="fcnrenumber" name="fcnrenumber" value="${companyNamePo.fcnrenumber }"/>
<input type="hidden" id="customerprinttype" name="customerprinttype" value="${customerprinttype }"/>
<input type="hidden" name="salesBasicPo.ssesbdiscounttype" value=""/><!-- 2012/2/2 零折 -->
<input type="hidden" name="salesBasicPo.ssesbgoodslevel" value=""/><!-- 2012/2/2 零折 -->
<input type="hidden" name="salesBasicPo.ssesbdiscountperson" value=""/><!-- 2012/2/2 零折 -->
<input type="hidden" name="logindepartmentid" value="${logindepartmentid }"/><!-- 2012/2/2 零折 -->
<input type="hidden" name="salesBasicPo.ssesbisgiveyouintegral" value="1"/>

<%--<input type="button" onclick="ceshi()"/>--%>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
	  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TBODY>
		  <TR>
			<TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>柜台销售</TD>
			<TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：门店销售</TD>
		  </TR>
		  <TR>
			<TD class=menubar_function_text colspan="3"><table></table></TD>
		  </TR>
		  <TR>
			<TD colSpan=2 height=20></TD>
		  </TR>
		</TBODY>
	  </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
		<TR>
		  <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx }/img/pic/tab_bg.gif></TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top>
						<fieldset>
							<legend>顾客资料</legend>
							<table width="98%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateTable privateBorder">
							  <tr>
								<td height="26" bgcolor="#cadee8">
								<li class="horizontal">卡号&nbsp;<input id="smecimemberid" name="customerInfoPo.smecimemberid" value="${customerInfoPo.smecimemberid }" onkeyup="selectCustomer();" class="text_input100" size="6"></li>								
								<li class="horizontal"><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查找' onclick="selCustomer();" ></li>
								<li class="horizontal"><img name="userName4" src="${ctx }/img/newbtn/btn_customerinsert_0.png" btn=btn title="会员新增" onclick="openMember()"></li>
								<li class="horizontal">姓名<input class="text_input60" size="2" value="${customerInfoPo.smeciname }" id="smeciname" name="customerInfoPo.smeciname" readOnly="readOnly"></li>
								<li class="horizontal">性别<input class="text_input20" size="2" value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" readOnly="readOnly"></li>
								<li class="horizontal">年龄<input class="text_input40" size="2" value="${customerInfoPo.fmmdown }" readOnly="readOnly"></li>
								<li class="horizontal">会员卡类型<input class="text_input80" value="${customerInfoPo.fmmmembername }" readOnly="readOnly"></li>
								<input type="hidden" id="titlediscount" size="2" value="${customerInfoPo.fmmdiscount }" readOnly="readOnly"></li>
								<li class="horizontal">积分<input class="text_input60" size="2" value="${customerInfoPo.smeciintegral }" readOnly="readOnly"></li>
								<li class="horizontal">
								<c:if test="${not empty(customerInfoPo.smecicustomerid)}">
								  <img name="button32" src="${ctx}/img/newbtn/btn_details_0.png" btn=btn title='详情' align="left" onClick="javascript:details('${customerInfoPo.smecicustomerid }');" >
								</c:if>
								</li>
								<li id="saleserDiv" class="horizontal"><img name="button32" btn=btn id='saleser' src="${ctx}/img/newbtn/btn_changesaleser_0.png" title="更换销售员" align="left" onclick="changeSaleser()">
								</li>
								<li id="saleserDiv" class="horizontal">
								    <c:if test="${systemParameterPo.fspsalerdefaultset == '1'}">
										<SELECT id="ssesbsalerid" name="ssesbsalerid" disabled="disabled" onchange="disabledSelect()">
											<c:forEach var="po" items="${personInfoPos}">
												<option value="${po.id }" ${person.id != po.id ? '':'selected=selected'}>${po.personName }</option>
											</c:forEach>
										</SELECT>								    
								    </c:if>
								    <c:if test="${systemParameterPo.fspsalerdefaultset == '2'}">
										<SELECT id="ssesbsalerid" name="ssesbsalerid" disabled="disabled" onchange="disabledSelect()" >
										    <option value="">----请选择----</option>
											<c:forEach var="po" items="${personInfoPos}">
												<option value="${po.id }">${po.personName }</option>
											</c:forEach>
										</SELECT>								    
								    </c:if>
									<input name="salesBasicPo.ssesbsalerid" type="hidden" value='' validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择销售人员！'}]"> 
								</li>
								<c:choose>
									<c:when test="${(permissionPo.keyb==1)}">
										<li class="horizontal">医生：&nbsp;
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
							</table>
						</fieldset>	
						<br>
						<div id="divopmessage">
						<fieldset>
							<legend>当前验光处方</legend>
							<table width="98%" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder" id="title2">
							  <tr>
								<th width="30%" height="26" align="center" class="table_body">处方类型</th>
                                <th align="center" class="table_body">验光师</th>
                                <th align="center" class="table_body">验光时间</th>
                                <th align="center" class="table_body">选择</th> 
                              </tr>
                              <c:if test="${not empty(inspectionPos)}">
                              	<c:forEach var="po" items="${inspectionPos}">
                              		<tr>
								<td width="30%" height="26" align="center" class="table_body">
									<c:choose>
										<c:when test="${po.sopipglasstype == '1' }">远用</c:when>
										<c:when test="${po.sopipglasstype == '2' }">近用</c:when>
										<c:when test="${po.sopipglasstype == '3' }">双光/渐进</c:when>
										<c:when test="${po.sopipglasstype == '5' }">中用</c:when>
										<c:when test="${po.sopipglasstype == '4' }">隐形</c:when>
									</c:choose>
								</td>
                                <td height="26" align="center" class="table_body">${po.sopipersonname }</td>
                                <td height="26" align="center" class="table_body">${fn:substring(po.sopiptime, 0, 16)} </td>
                                <td height="26" align="center" class="table_body">
                                	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" 
                                	onclick="selectOptometryPerson('${po.sopipersonname }','${po.sopipusername}');selGlassTime('${fn:substring(po.sopiptime, 0, 16)}');selGlassType('${po.sopipglasstype}');inspection({'sopipinspectionid':'${po.sopipid}','sopipcustomerid':'${po.sopipcustomerid}',
								'sopipoptometrybasicid':'${po.sopipoptometrybasicid}','sopipoptometryid':'${po.sopipoptometryid}','sopipersonname':'${po.sopipersonname }',
								'sopipglasstype':'${po.sopipglasstype}','sopipballglassod':'${po.sopipballglassod}',
								'sopipballglassos':'${po.sopipballglassos}','sopippostglassod':'${po.sopippostglassod}',
								'sopippostglassos':'${po.sopippostglassos}','sopipaxesod':'${po.sopipaxesod}',
								'sopipaxesos':'${po.sopipaxesos}','sopipaddod':'${po.sopipaddod}',
								'sopipaddos':'${po.sopipaddos}','sopiparriseglassod1':'${po.sopiparriseglassod1}',
								'sopiparriseglassos1':'${po.sopiparriseglassos1}','sopipbasisod1':'${po.sopipbasisod1}',
								'sopipbasisos1':'${po.sopipbasisos1}','sopipprismod':'${po.sopipprismod}',
								'sopipprismos':'${po.sopipprismos}','sopipinterhighod':'${po.sopipinterhighod}',
								'sopipinterhighos':'${po.sopipinterhighos}','sopipinterdistanceod':'${po.sopipinterdistanceod}',
								'sopipinterdistanceos':'${po.sopipinterdistanceos}','sopipfarvaod':'${po.sopipfarvaod}',
								'sopipfarvaos':'${po.sopipfarvaos}','sopipclosevaod':'${po.sopipclosevaod}',
								'sopipclosevaos':'${po.sopipclosevaos}','sopipeyecurvatureod1':'${po.sopipeyecurvatureod1}',
								'sopipeyecurvatureod2':'${po.sopipeyecurvatureod2}','sopipeyecurvatureos1':'${po.sopipeyecurvatureos1}',
								'sopipeyecurvatureos2':'${po.sopipeyecurvatureos2}','sopipdiameterod':'${po.sopipdiameterod}',
								'sopipdiameteros':'${po.sopipdiameteros}','sopipconlenvaod':'${po.sopipconlenvaod}',
								'sopipconlenvaos':'${po.sopipconlenvaos}','sopipcommendglasses':'${po.sopipcommendglasses}',
								'sopipsuggestframe':'${po.sopipsuggestframe}','sopipframeheight':'${po.sopipframeheight}',
								'sopipglassmaterial':'${po.sopipglassmaterial}','sopiprecipetype':'${po.sopiprecipetype}',
								'sopipdisposemanner':'${po.sopipdisposemanner}','sopipdignosisre':'${po.sopipdignosisre}',
								'sopipconrecipetype':'${po.sopipconrecipetype}','sopipseccheckdate':'${po.sopipseccheckdate}',
								'sopipusername':'${po.sopipusername}','sopippupilheightod':'${po.sopippupilheightod}','sopippupilheightos':'${po.sopippupilheightos}',
								'sopipflag':'${po.sopipflag}','sopipconlenosnum':'${po.sopipconlenosnum}',
								'sopipconlenodnum':'${po.sopipconlenodnum}','sopipmiddledistance':'${po.sopipmiddledistance}',
								'sopipcommendcardwater':'${po.sopipcommendcardwater}','sopipeyecurvatureod1':'${po.sopipeyecurvatureod1}',
								'sopipeyecurvatureod2':'${po.sopipeyecurvatureod2}','sopipeyecurvatureos1':'${po.sopipeyecurvatureos1}',
								'sopipeyecurvatureos2':'${po.sopipeyecurvatureos2}','sopipconlenvaod':'${po.sopipconlenvaod}',
								'sopipconlenvaos':'${po.sopipconlenvaos}','sopipdiameterod':'${po.sopipdiameterod}',
								'sopipdiameteros':'${po.sopipdiameteros}','sopipcommendglasses':'${po.sopipcommendglasses}',
								'sopipconlenodnum':'${po.sopipconlenodnum}','sopipconlenosnum':'${po.sopipconlenosnum}',
								'sopipconlenosnum':'${po.sopipconlenosnum}'},'${po.sopipglasstype}');$('#recipetype').attr('disabled', true);$('#nwtype').val('1');lockOptometryPerson();wlControl();clearGoods();$('#opdate').hide();clearTC();checkCylZero();" /></td> 
                              </tr>
                              	</c:forEach>
                              </c:if>
						  </table>
						</fieldset>	
						<br/>
						<fieldset>
						<legend>处方类型</legend>
						<table width="100%">
							<tr valign="top">
								<td width="25%">
									<table width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
										<tr height="33">
											<td class="table_none" width="25%">
												验光号
											</td>
											<td class="table_none" width="75%">
												<input type="text" id="optometryID" name="optometryID" value="${empty(customerInfoPo.smeciname) ? '':optometryID }" readonly="readonly" style="text-align:left;width:98%;border:0px;background-color:#e9f2f7;" onfocus="blur()"/>
											</td>
										</tr>
										<tr height="33">
											<td class="table_none">
												验光师
											</td>
											<td class="table_none">
												<li id="saleserDiv" class="horizontal">
													<select id="optometryPerson" name="optometryPerson" onchange="disabledOptometryPersonSelect()">
													    <option value="" selected="selected">---请选择---</option>
														<c:forEach var="opo" items="${optometryPersonInfoPos}">
															<option value="${opo.id }">${opo.personName }</option>
														</c:forEach>
													</select>
													<input type="hidden" id="optometryPersonID" name="optometryPersonID"/>
												</li>
												<li id="saleserDiv" class="horizontal">
													<img name="button32" btn=btn id="btnlock" src="${ctx}/img/newbtn/lock_0.png" title="解除/锁定" align="left"  onclick="changeOptometryPerson()">
												</li>
											</td>
										</tr>
										<tr height="33">
											<td class="table_none">
												外来处方
											</td>
											<td class="table_none">
												<li id="saleserDiv" class="horizontal">
													<input type="checkbox" id="checkboxwl" name="" onclick="isShowwfdiv(this);searchWF();checkCylZero();"/>外来处方&nbsp;
												</li>
												<li id="saleserDiv" class="horizontal">
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
										<tr height="33">
											<td class="table_none">
												验光时间
											</td>
											<td class="table_none">
					                   				<input class="text_input120"
									               id="ssetmsenddate"
											       name="salesBasicPo.ssesbopdatetime" value=""
											       type="text"
											       readonly="readonly" readonly="readonly" style="text-align:left;width:98%;border:0px;background-color:#e9f2f7;" onfocus="blur()"/>
											</td>
										</tr>
										<tr valign="middle" height="33">
											<TD class="table_none">
											   	处方类型
											</td>
											<td class="table_none">
												<li class="horizontal">
											   		<select id="recipetype" name="recipetype" onChange="selGlassType(this.value);clearGoods();checkCylZero();" >
													    <option value="0">---请选择---</option>
														<option value="1" selected="selected">远用</option>
														<option value="2">近用</option>
														<option value="3">渐进/双光</option>
														<option value="5">中用</option>
														<option value="4">隐形</option>
													</select>
											   	</li>
											  	<li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clearValue();clearOp();$('#nwtype').val('');wlLock();clearGoods();changeWF();selGlassType($('#recipetype').val());checkCylZero();" /></li>
										  	</TD>
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
												<option value="内">内</option>
												<option value="外">外</option>
												<option value="上">上</option>
												<option value="下">下</option>
		                                    </select>
		                                </span>
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="6" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterhighod" glassType="yuanyong" tongju="tongju"  class="text_input40" style="width:100%">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="7" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightod" glassType="yuanyong" tonggao="tonggao"  class="text_input40" style="width:100%" noreadonly=noreadonly>
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
												<option value="内">内</option>
												<option value="外">外</option>
												<option value="上">上</option>
												<option value="下">下</option>
		                                    </select>
		                               </span>
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
									     <input yyorder="14" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterhighos" glassType="yuanyong" tongju="tongju"  class="text_input40" style="width:100%">
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
									     <input yyorder="15" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightos" glassType="yuanyong" tonggao="tonggao"  class="text_input40" style="width:100%" noreadonly=noreadonly>
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
									 	<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
									 		备注
									 	</td>
									 	<td bgcolor="DFFFDF" class="PrivateBorderGreen" colspan="8">
									 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="yuanyong" style="height: 40px;"
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
												<option value="内">内</option>
												<option value="外">外</option>
												<option value="上">上</option>
												<option value="下">下</option>
		                                    </select>
		                                </span>
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="6" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterdistanceod" glassType="jinyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="E1EBFD" class="PrivateBorderBlue">
										  <input yyorder="7" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightod" glassType="jinyong" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%" noreadonly=noreadonly>
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
												<option value="内">内</option>
												<option value="外">外</option>
												<option value="上">上</option>
												<option value="下">下</option>
		                                    </select>
		                               </span>
									   </td>
									   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
									     <input yyorder="14" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterdistanceos" glassType="jinyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
									   </td>
									   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
									     <input yyorder="15" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightos" glassType="jinyong" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%" noreadonly=noreadonly>
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
									 	<td bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">
									 		备注
									 	</td>
									 	<td bgcolor="E1EBFD" class="PrivateBorderBlue" colspan="9">
									 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="jinyong" style="height: 40px;"
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
									   <td width="5%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">基底</td>
									   <td width="10%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">远用瞳距(mm)</td>
									   <td width="10%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">近用瞳距(mm)</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">瞳高(mm)</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">远用VA</td>
									   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">近用VA</td>
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
												<option value="内">内</option>
												<option value="外">外</option>
												<option value="上">上</option>
												<option value="下">下</option>
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
										  <input yyorder="9" onkeydown="OnKeyDownEnter(this)" id="ssesbpupilheightod" name="salesBasicPo.ssesbpupilheightod" glassType="jianjin" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%" noreadonly=noreadonly>
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
												<option value="内">内</option>
												<option value="外">外</option>
												<option value="上">上</option>
												<option value="下">下</option>
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
										  <input yyorder="20" onkeydown="OnKeyDownEnter(this)" id="ssesbpupilheightos" name="salesBasicPo.ssesbpupilheightos" glassType="jianjin" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%" noreadonly=noreadonly>
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
									   <td width="8%" bgcolor="FBF3BD" align="left" colspan="6">&nbsp;建议镜框：&nbsp;&nbsp;<a id="sopipsuggestframe" glassType="jianjin"></a><a id="sopipframeheight" glassType="jianjin"></a></td>
									 </tr>
									 <tr>
									 	<td bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">
									 		备注
									 	</td>
									 	<td bgcolor="FBF3BD" class="PrivateBorderYellow" colspan="11">
									 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="jianjin" style="height: 40px;"
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
									   <td width="11%" bgcolor="FBF3BD"class="PrivateBorderBlue" align="center">对角线(mm)</td>
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
												<option value="内">内</option>
												<option value="外">外</option>
												<option value="上">上</option>
												<option value="下">下</option>
		                                    </select>
		                                </span>
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="6" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterhighod" glassType="zhongyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
										</td>
										<td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="7" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightod" glassType="zhongyong" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%" noreadonly=noreadonly>
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
												<option value="内">内</option>
												<option value="外">外</option>
												<option value="上">上</option>
												<option value="下">下</option>
		                                    </select>
		                               </span>
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
									     <input yyorder="14" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbinterhighos" glassType="zhongyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
									   </td>
									   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
										  <input yyorder="15" onkeydown="OnKeyDownEnter(this)" name="salesBasicPo.ssesbpupilheightos" glassType="zhongyong" tonggao="tonggao" disabled="disabled" class="text_input40" style="width:100%" noreadonly=noreadonly>
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
									 <tr>
									 	<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
									 		备注
									 	</td>
									 	<td bgcolor="DFFFDF" class="PrivateBorderGreen" colspan="8">
									 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="zhongyong" style="height: 40px;"
	                       			validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
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
							 	<td bgcolor="#F8E0F0" class="PrivateBorderPink" align="center">
							 		备注
							 	</td>
							 	<td bgcolor="#F8E0F0" class="PrivateBorderPink" colspan="9">
							 		<textarea name="salesBasicPo.ssesbdignosisre" id="ssesbdignosisre" glassType="yinxing" style="height: 40px;"
	                       			validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
							 	</td>
						     </tr>
                            </table>
								</td>
							</tr>
						</table>
						</fieldset>
						</div>
						<br/>
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
                                          	取镜方式：
                                            <select name="ssesbtakeglasstype" id="ssesbtakeglasstype">
                                              <option value="0" selected="selected">正常</option>
                                              <option value="7">订做7</option>
                                              <option value="10">订做10</option>
                                              <option value="15">订做15</option>
                                              <option value="25">订做25</option>
                                            </select>
                                            &nbsp;&nbsp;&nbsp;&nbsp;取镜日期：
                                              <input id="ssesbtakeglassdata" name="salesBasicPo.ssesbtakeglassdata" type="text" class="text_input120" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d'})"/></li>
										      	&nbsp;&nbsp;&nbsp;&nbsp;
                                            <li class="horizontal_onlyRight">
	                                            <div id="showtr" style="display: none">委外方式：
		                                            <select id="DragsType" name="salesBasicPo.ssesbdragstype" disabled="disabled">
														<option value="1">委外订单</option>
														<option value="2">委外加工</option>
		 											</select>
	 											</div>
 											</li>
 											&nbsp;
                                            <li class="horizontal_onlyRight">
	                                            <div>加急状态：
		                                            <select id="DragsType1" name="salesBasicPo.ssesbworrytype">
														<option value="1">正常</option>
														<option value="2">加急</option>
		 											</select>
	 											</div>
 											</li>
 											&nbsp;&nbsp;&nbsp;
                                            <li class="horizontal_onlyRight">
	                                            <div>
		                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx }/img/newbtn/btn_addmail_0.png" btn=btn title="填写邮寄信息" onclick="toMailInsert('${salseID }','${customerInfoPo.smecimemberid }','${customerInfoPo.smeciname }','${customerInfoPo.smeciphone }')">
	 											</div>
 											</li>
 											&nbsp;&nbsp;&nbsp;
                                            <li class="horizontal_onlyRight" id="mailMsg">
	 											<div>
		                                           <font color="red">邮寄信息已填写!</font>
	 											</div>
 											</li>
					      			 </td>
                                     <td rowspan="3" class="Privateborder" colspan="2"><div id="jiesuandiv" align="center">
                                     <img id="buttonsave" name="button" src="${ctx }/img/newbtn/btn_count_0.png" btn=btn title="结算 " onclick="save()">
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
                                          	<li class="horizontal_onlyRight">取镜地点：
                                            <select id="ssesblocation" onChange="selLocation();checkFrontMoney();" disabled="disabled">
                                               	<s:iterator value="departmentsList" >
                                               		 <option value="${bdpdepartmentid }" >${bdpdepartmentname}</option>
                                               	</s:iterator>
                                            </select><input type="hidden" name="salesBasicPo.ssesblocation" value="${person.departmentID}"/>
                                            </li>
                                            <li class="horizontal_onlyRight"><img name="button32" btn=btn id="btnlock" src="${ctx}/img/newbtn/lock_0.png" title="解除/锁定" align="left"  onclick="changeTakeAddress()"></li>
                                           &nbsp;&nbsp;&nbsp;&nbsp;实收金额：<input name="salesBasicPo.ssesbpsalsvalue" id='sesbpsalsvalue' class="text_input" size="8" onblur="checkFrontMoney()">
                                           
                                           <c:if test="${customerInfoPo.smeciisfavorable == '1' }">
                                           &nbsp;&nbsp;&nbsp;&nbsp;商品打折：<input size="8" name="salesBasicPo.ssesbdiscountrate"  class="text_input"  type="text" readonly="readonly"  onclick="discount1()" >
                                           <img src="${ctx }/img/newbtn/btn_emptydiscount_0.png" btn=btn onclick="afreshdiscount();"/>
                                           </c:if>
                                           
                                           <c:if test="${customerInfoPo.smeciisfavorable == '0' }">
                                           <input size="8" name="salesBasicPo.ssesbdiscountrate"  class="text_input"  type="hidden" readonly="readonly"  value="1" >
                                           </c:if>
                                           
                                           <c:if test="${systemParameterPo.fspremove == '1' && customerInfoPo.smeciisfavorable == '1' }">
                                           &nbsp;&nbsp;&nbsp;&nbsp;</li><li class="horizontal_onlyRight">抹零金额：<input size="8" id="td10t" class="text_input"  type="text"  onblur="changeMolingAmount(this)">&nbsp;</li>
                                           </c:if>
                                           <c:if test="${(systemParameterPo.fspremove != '1') || (customerInfoPo.smeciisfavorable == '0') }">
                                           <input size="8" id="td10t" class="text_input"  type="hidden">
                                           </c:if>
                                           <!--<c:forEach var="po" items="${discountShortcutKeysPolist}">
                                           	&nbsp;<button id="${po.fdkid}" name="m${po.fdkid}" onclick="setDiscount1('${po.fdkkeyvalues}','${person.id}','1')"/>${po.fdkkeyname}</button>
                                           </c:forEach>-->
                                           <s:iterator value="departmentsList" >
                                              <input type="hidden" name="k${bdpdepartmentid }" id="k${bdpdepartmentid }" value="${bdptakeglassdate }"/>  		
                                            </s:iterator>
                                           </td>
                                          </tr>
                                      </table></td>
							</tr>
						</table>
						<br>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="25%" valign="top">
							<fieldset>
							<legend>销售类型</legend>
							<table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr height="26">
                                <td width="33%" class="table_none">
                                	<input type="radio" name="salestype" value="1" checked="checked" onclick="showSalesType(this);changeWF();">框镜销售
                                </td>
                                <td width="33%" class="table_none">
                                	<input type="radio" name="salestype" value="3" onclick="showSalesType(this);changeWF();">隐形销售
                                </td>
                                <td width="33%" class="table_none">
                                	<input type="radio" name="salestype" value="5" onclick="showSalesType(this);changeWF();">辅料销售
                                	<input type="hidden" value="1" id="salestype_input" name="salesBasicPo.ssesborderstype"/>
                                </td>
                              </tr>
                            </table>
							</fieldset>
							<c:if test="${systemParameterPo.fspbarcodetype != '3'}">
							<br/>
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
                                	套餐选择
                                </td>
                                <td class="table_none">
                                	<div id="nohavetc"><img src="${ctx }/img/newbtn/btn_tcxuanz_0.png" btn=btn title='套餐选择' onclick="querySetMealGoods()"></div>
                                </td>
                                <td class="table_none">
                                	<div><img title="套餐查看" src="${ctx }/img/newbtn/btn_usablemeal_0.png" btn=btn onclick="querySetMeal()"></div>
                                </td>
                              </tr>
                              <tr height="26">
                                <td width="25%" class="table_body">
                                	套餐名称<input type="hidden" id="ssesbsetmealid" name="salesBasicPo.ssesbsetmealid" value="${salesBasicPo.ssesbsetmealid }"/><!--套餐ID -->
                                </td>
                                <td class="table_none" id="setmealtitle" colspan="2"></td>
                              </tr>
                              <tr height="26">
                                <td width="25%" class="table_body">
                                	清空套餐
                                </td>
                                <td class="table_none" colspan="2"><img src="${ctx }/img/newbtn/btn_emptytc_0.png" btn=btn title='清空套餐' onclick="clearTC();"></td>
                              </tr>
                            </table>
							<c:if test="${systemParameterPo.fspbarcodetype == '3' || systemParameterPo.fspbarcodetype == '2'}">
							<br/>
							<table id="kj" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                <td width="22%" class="table_body">镜架</td>
                                <td colspan="4" class="table_none" align="right"><div align="right"><img name="button223" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addSalesGoods('1','F','','','','');"></div></td>
                              </tr>
                              <tr>
                                <td width="22%" class="table_body">镜片</td>
                                <td width="20%" class="table_none"><input type="radio" name="materialTypeR" value="1" checked="checked">树脂</td>
                                <td width="20%" class="table_none"><input type="radio" name="materialTypeR" value="2">玻璃</td>
                                <td width="20%" class="table_none"><input type="radio" name="materialTypeR" value="3">PC</td>
                                <td class="table_none"><img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addSalesGoods('3','R', frameSalesForm.materialTypeR.value,'','','');"></td>
                              </tr>
                              <tr>
                                <td class="table_body">镜架配件</td>
                                <td colspan="4" class="table_none"><div align="right">
                                  <img name="button2232" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addSalesGoods('2','','','1','','');">
                                </div></td>
                              </tr>
                            </table>
                            <table id="yx" style="display: none;" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                <td width="20%" class="table_body">隐形镜片</td>
                                <td colspan="4" class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addSalesGoods('4','R','','','','');"></td>
                              </tr>
                              <tr>
                                <td class="table_body">护理液</td>
                                <td colspan="4" class="table_none" align="right"><img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addSalesGoods('5','','','','','');"></td>
                              </tr>
                              <tr>
                                <td class="table_body">隐形配件</td>
                                <td colspan="4" class="table_none"><div align="right">
                                  <img name="button2232" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addSalesGoods('2','','','2','','');">
                                </div></td>
                              </tr>
                            </table>
                            <table id="pj" style="display: none;" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                <td width="20%" class="table_body">辅料</td>
                                <td colspan="4" class="table_none"><div align="right"><img name="button223" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addSalesGoods('other','','','','','');"></div></td>
                              </tr>
                            </table>
                            </c:if>
                            <br/>
                            <table id="ourframeorglass" width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">  
                              <tr>
                                <td width="50%" class="table_none" align="center"><img btn=btn title="自架" src="${ctx }/img/newbtn/btn_zj_0.png" onclick="addSalesGoods('1','','','','ZZ','');"/></td>
                                <td width="50%" class="table_none" align="center"><img btn=btn title="自片" src="${ctx }/img/newbtn/btn_zp_0.png" onclick="addSalesGoods('3','','','','ZZ','');"/></td>
                              </tr>
                            </table>
                            <br/>
                            <table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">  
                              <tr>
                                <td width="16%" class="table_body">赠品</td>
                                <td class="table_none" align="right"><img name="button2232" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openGoodSingleGiftsValues()"></td>
                              </tr>
                            </table>
                        <c:if test="${not empty(giftsList)}">  
							<br/>
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
                                <td class="table_body">附加费用</td>
                                <td colspan="3" class="table_none">
								<select id="additionalCosts" name="additionalCosts">
								  <option value="">---请选择---</option>
								  <s:iterator value="additionalCostsList">
								  <option value="${facid},${facamount}">${facname}</option>
								  </s:iterator>
								</select></td>
                                <td class="table_none"><img name="button22332" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onclick="addCosts(this)"></td>
                              </tr>
                              <tr>
                                <td class="table_body">加工要求</td>
                                <td colspan="3" class="table_none"><select name="specialRequirements" id="specialRequirements">
                                  <option>---请选择---</option>
                                 <s:iterator value="specialList">
                                  <option value="${fsrname }">${fsrname}</option>
                                  </s:iterator>
                                </select></td>
                                <td class="table_none"><img name="button22333" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onclick="addSpecial()"></td>
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
                                    <!-- <td width="10%" class="table_body" height="26"><div align="center">商品代码</div></td>  -->
                                    <td width="5%" class="table_body"><div align="center">选择<input type="checkbox" id="chks" onclick="chkAll()"/></div></td>
                                    <td width="12%" class="table_body"><div align="center">商品名称</div></td>
                                    <td width="5%"  class="table_body"><div align="center">单价</div></td>
                                    <td width="5%"  class="table_body"><div align="center">可用<br>库存</div></td>
                                    <td width="4%"  class="table_body"><div align="center">数量</div></td>
                                    <td width="6%"  class="table_body"><div align="center">原价<br>合计</div></td>
                                    <td width="5%"  class="table_body"><div align="center">折扣率</div></td>
                                    <td width="5%"  class="table_body"><div align="center"><font color="red">最大<br>折扣</font></div></td>
                                    <td width="5%"  class="table_body"><div align="center">折扣<br>金额</div></td>
                                    <td width="5%"  class="table_body"><div align="center">优惠<br>金额</div></td>
                                    <c:if test="${systemParameterPo.fspremove == '1'}">
                                    <td width="5%"  class="table_body"><div align="center">抹零<br>金额</div></td>
                                    </c:if>
                                    <td width="6%"  class="table_body"><div align="center">应收<br>金额</div></td>
                                    <td width="9%"  class="table_body"><div align="center">商品描述</div></td>
                                    <td width="4%"  class="table_body"><div align="center">删除</div></td>
                                  </tr>
                                  <tr id="copyrow" style="display:none" trsl=trsl>
                             		<td   class="Privateborder"><!-- 套餐属性区 -->
										<input type="hidden" id="goodssph"/>
										<input type="hidden" id="goodscyl"/>
										<input type="hidden" id="goodssphul"/>
										<input type="hidden" id="goodssphup"/>
										<input type="hidden" id="goodscylul"/>
										<input type="hidden" id="goodscylup"/>
										<input type="hidden" id="goodsclfl"/>
										<input type="hidden" id="goodszsl"/>
										<input type="hidden" id="goodsgndl"/>
										<input type="hidden" id="goodsjjcz"/>
										<input type="hidden" id="goodssylx"/>
										<input type="hidden" id="goodspqlx"/>
										<input type="hidden" id="goodstyjgn"/>
										<input type="hidden" id="goodsgdfl"/>
									<!-- 套餐属性区 -->
									<!-- 商品级别区 -->
                                   		<input type="hidden" id="goodslevel" name="salesDetailPo.ssesdgoodslevels"/>
                                   	<!-- 商品级别区 -->
									<div align="center" id="nohavetccheckbox"><input type="checkbox" id="chk" name="chk" goodsid="" rl=""/></div><div align="center" id="havetccheckbox" style="display: none;">套</div></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdsalesitemnames" 	readonly="readonly"   class="text_inputhidden"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdsprices"        	readonly="readonly"   class="text_inputhidden yjje"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="maxgoodsquantity"  					readonly="readonly"   maxlength="4"    class="text_inputhidden"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdnumbers"    maxlength="4"    class="text_inputhidden" onblur="if(checkmaxnumber(this)){rowamount(this);}else{formaxnumber(this);rowamount(this);}"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdpricesums"    	readonly="readonly"   class="text_inputhidden pricesum"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;"  									title=""  onmouseover="salesover(this)" onmouseout="salesout(this)" readonly="readonly" name="salesDetailPo.ssesddiscountrates" readonly="readonly" class="text_inputhidden discountrate salesout" ><input type="hidden" class="rownumber" name="rownumber"/><input type="hidden" id="ssesddiscounttypes" name="salesDetailPo.ssesddiscounttypes" class="text_inputhidden ssesddiscounttypes salesout"/><input type="hidden" id="ssesddiscountsources" name="salesDetailPo.ssesddiscountsources" class="text_inputhidden ssesddiscountsources salesout"/></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;color: red;"  title="" id="maxdiscount" name="maxdiscount" readonly="readonly" onfocus="blur()"  class="text_inputhidden"><input type="hidden" name="salesDetailPo.ssesdishavestocks"/></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesddiscountnums"   	readonly="readonly"   class="text_inputhidden zksum"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title="" value="0.00" name="salesDetailPo.ssesdfavorables"   readonly="readonly"   class="text_inputhidden yhsum"><input type="hidden" name="salesDetailPo.ssesdguaranteeperiods"/><input type="hidden" name="salesDetailPo.ssesdbatchs"/></td>
                                    <c:if test="${systemParameterPo.fspremove == '1'}">
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdrenums"         readonly="readonly"   class="text_inputhidden resum"></td>
                                    </c:if>
                                    <c:if test="${systemParameterPo.fspremove != '1'}">
                                    <td   class="Privateborder" style="display: none"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdrenums"         readonly="readonly"   class="text_inputhidden resum"></td>
                                    </c:if>
                                    <td   class="Privateborder"><input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdsalesvalues" readonly="readonly"   class="text_inputhidden yssum"></td>
                                    <td   class="Privateborder"><input  style="width: 100%;" title="" onmouseover="salesover(this)" onmouseout="salesout(this)" name="salesDetailPo.ssesdgooddescribes"  class="text_inputhidden salesout"><input type="hidden" name="salesDetailPo.ssesdcostsprives"/><input type="hidden" name="salesDetailPo.ssesdsetmealids"/><input type="hidden" name="salesDetailPo.ssesdsetmealidnos"/><input type="hidden" name="salesDetailPo.ssesditemids"/><input type="hidden" name="salesDetailPo.ssesdunitprices"/><input type="hidden" name="salesDetailPo.iscustomizes"/><input type="hidden" name="salesDetailPo.ssesdcommoditiesflags"/><input type="hidden" name="orderCycle"/></td>
                                    <td   class="Privateborder"><div  align="center"><input type="hidden" class="cccc" id="ssesdglassflags" name="salesDetailPo.ssesdglassflags"/><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' onclick="deleteItem(this);deleteVar1(this);attrdiscountandrenumopen();"><input  type="hidden" name="salesDetailPo.ssesdsalesitemids" maxdiscount=""/><input type="hidden" class="cccc" id="ssesdstockids" name="salesDetailPo.ssesdstockids"/></div>
                                   	</td>
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
									  <tr id="copyrowGifts" style="display:none" trzp=trzp>
                                        <td width="80%" class="table_none"><span id="giftsviewname"></span><input type="hidden" name="giftsPo.bgsviewname"></input>
	                                        <input type="hidden" name="giftsPo.bgsgoodstype">
	                                        <input type="hidden" name="giftsPo.bgsgoodsid">
	                                        <input type="hidden" name="giftsPo.bgsgoodsbarcode">
	                                        <input type="hidden" name="giftsPo.bgscostprice">
	                                        <input type="hidden" name="giftsPo.bgsnottaxrate"><input type="hidden" name="giftsPo.bgsstockid"><BR>
                                        </td>
                                        <td width="20%" height="26" class="table_none">
                                        <div align="center">
                                          	<img src="${ctx}/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' onclick="deleteItem(this)" >
                                        </div>
                                        </td>
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
                                      <tr style="display:none" id="copyrowCosts" trfjf=trfjf>
                                        <td class="table_none"><span id="costs"></span><input type="hidden" name="additionalCostsPo.facname">
                                        <input type="hidden" name="additionalCDetailPo.sseadditionalid"><BR></td>
                                        <td class="table_none"><span id="costsMoney"></span><input class="fjfy" type="hidden" name="additionalCostsPo.facamount"><BR></td>
                                        <td class="table_none"><input type="text" size="8" class="text_input60 number" id="0" maxlength="4" name="additionalCDetailPo.ssenumber" onblur="addCosts(this)" validate=""><BR></td>
                                        <td class="table_none"><span id="amountMoney"></span><input class="fjfya" type="hidden" id="amountMoney" name="amountMoney"></td>
                                        <td class="table_none"><div align="center">
                                            <img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' name="button22432" onclick="deleteItem(this);deleteVar2(this)">
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <!-- 加工要求 -->
                                    <td width="22%" valign="top">
                                    <table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                      <tr>
                                        <td height="26" colspan="2" bgcolor="#CADEE8" class="Privateborder">加工要求</td>
                                      </tr>
                                      <tr style="display:none" id="copyrowSpecial" trjgyq=trjgyq>
                                        <td width="75%" height="26" class="table_none"><input name="specialPDetailPo.ssesdrequirement" size="14"><BR></td>
                                        <td width="25%" class="table_none"><div align="center">
                                            <img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' name="button22432" onclick="deleteItem(this);deleteVar2(this)">
                                        </div></td>
                                      </tr>
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
			                              		<textarea rows="" cols="" id="ssesbsalesremark" name="salesBasicPo.ssesbsalesremark" style="height: 45px" onblur="if($(this).val().length > 200){alert('销售备注长度超过200字节，请进行调整！'); $(this).focus();}"></textarea>
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
						<br>
						<!--ݿEnd--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<script>
	document.getElementById('smecimemberid').focus();  	
	function selectCustomer(){
		if(document.getElementById('smecimemberid').value.trim() != ''){
			if(event.keyCode == 13){
				frameSalesForm.action="initSalesAll.action";
				frameSalesForm.submit();
			}
		}
			
	}
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员详细】";
	}		
	function selCustomer(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
	}
	
	function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		frameSalesForm.action="initSalesAll.action";
		frameSalesForm.submit();
	}
</script>