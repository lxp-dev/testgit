<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>眼部检查管理</title>
</head>
<script>
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员信息】";	
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="yjCheckForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }" /> 
<input type="hidden" name="customerID" value="${customerInfoPo.smecicustomerid }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif></TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" vAlign=top>
                <DIV id=tabContent__1>
                  <DIV>
				  <fieldset>
					<legend>【顾客资料】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td align="center">
						  <table width="99%" class="Privateborder privateTable" border="0" cellpadding="1" cellspacing="1">
							  <tr>
								<td class="table_body">
								 <li class="horizontal">  顾客卡号：${yjCheckPo.sopyjcustomerMemberId}&nbsp;&nbsp;</li>
								 <li class="horizontal">  姓名：${yjCheckPo.sopyjcustomername}&nbsp;&nbsp; </li>
								 <li class="horizontal">  性别：
								 	<c:choose>
								 		<c:when test="${yjCheckPo.sopyjcustomersex eq '0'}">男</c:when>
								 		<c:otherwise>男</c:otherwise>
								 	</c:choose>&nbsp;&nbsp;
	                             </li>
								 <li class="horizontal"> <input name="button32" type='button' value='详情' align="left" onClick="javascript:details('${yjCheckPo.sopyjcustomerid}')">
								 </li>							
								</td>
							  </tr>
						  </table>
						</td>
					  </tr>
				  </table>
				</fieldset>		
				<fieldset>
					<legend>【眼位检查】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center border=0>
                          <TBODY>
                            <TR>
                              <TD width="10%" class="table_body" align="center">代偿头位</TD>
                              <TD colspan="4" class="table_none">头向：
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj001' && yjCheckPo.sopyjdctwtouxiang == optionParamPoTmp.fopparamid}">
		                               ${optionParamPoTmp.fopparamname}
		                              </c:if>	                                      	
	                               </c:forEach>&nbsp;&nbsp;&nbsp;&nbsp;肩倾：
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj002' && yjCheckPo.sopyjdctwjianqing == optionParamPoTmp.fopparamid}">
		                               ${optionParamPoTmp.fopparamname}
		                              </c:if>	                                      	
	                               </c:forEach>&nbsp;&nbsp;&nbsp;&nbsp;歪头试验：
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj003' && yjCheckPo.sopyjdctwwaitoushiyan == optionParamPoTmp.fopparamid}">
		                               ${optionParamPoTmp.fopparamname}
		                              </c:if>	                                      	
	                               </c:forEach>&nbsp;侧 
                              	(+)
                              </TD>
                            </TR>
                            <TR>
                              <TD width="10%" rowspan="2" class="table_body" align="center">角膜映光</TD>
                              <TD width="40%" colspan="2" class="table_none">裸眼：
                                ${yjCheckPo.sopyjjmygluoyan}                                   
                              </TD>
                              <TD width="10%" class="table_body" align="center">控制正位</td>
                              <TD width="40%" class="table_none">
                              	<c:choose>
							 		<c:when test="${yjCheckPo.sopyjjmygkongzhizhengwei eq 'y'}">能</c:when>
							 		<c:when test="${yjCheckPo.sopyjjmygkongzhizhengwei eq 'n'}">否</c:when>
							 	</c:choose>
                              </TD>
                            </TR>
                            <TR>
                              <TD width="40%" colspan="2" class="table_none">戴镜：
                                ${yjCheckPo.sopyjjmygdaijing}                                        
                              </TD>
                              <TD width="10%" class="table_body" align="center">主视眼</td>
                              <TD width="40%" class="table_none">
                              	<c:choose>
							 		<c:when test="${yjCheckPo.sopyjjmygzhudaoyan eq 'y'}">右</c:when>
							 		<c:when test="${yjCheckPo.sopyjjmygzhudaoyan eq 'z'}">左</c:when>
							 	</c:choose>
                              </TD>
                            </TR>   
							<TR>
                              <TD width="10%" rowspan="5" class="table_body" align="center">三棱镜&nbsp;&nbsp;&nbsp;&nbsp;</br>
                                <c:choose>
							 		<c:when test="${yjCheckPo.sopyjslj eq '1'}">中和</c:when>
							 		<c:when test="${yjCheckPo.sopyjslj eq '2'}">遮盖</c:when>
							 		<c:when test="${yjCheckPo.sopyjslj eq '3'}">Maddox</c:when>
							 	</c:choose>
                              </TD>
                              <TD width="40%" colspan="2" align="center" class="table_body" height="30">5m</TD>
                              <TD colspan="2" align="center" class="table_body">33cm</td>
                            </TR>
                            <TR>
                              <TD width="5%" rowspan="2" align="center" class="table_body">OD</TD>
                              <TD width="35%" class="table_none">裸眼:&nbsp;&nbsp;
                              	${yjCheckPo.sopyjslj5modluoyan}&nbsp;&nbsp;
                              	${yjCheckPo.sljlyqselectod}
                              </TD>
                              <TD colspan="2" class="table_none">
                                ${yjCheckPo.sopyjslj3modluoyan}&nbsp;&nbsp;
                              	${yjCheckPo.sljlyhselectod}
                              </td>
                            </TR> 
                            <TR>
                              <TD width="35%" class="table_none">戴镜:&nbsp;&nbsp;
                              	${yjCheckPo.sopyjslj5moddaijing}&nbsp;&nbsp;
							  	${yjCheckPo.sljdjqselectod}
							  </TD>
                              <TD colspan="2" class="table_none">
                                ${yjCheckPo.sopyjslj3moddaijing}&nbsp;&nbsp;
                              	${yjCheckPo.sljdjhselectod}
                              </td>
                            </TR>
							<TR>
                              <TD width="5%" rowspan="2" align="center" class="table_body">OS</TD>
                              <TD width="35%" class="table_none">裸眼:&nbsp;&nbsp;
                              	${yjCheckPo.sopyjslj5mosluoyan}&nbsp;&nbsp;
							  	${yjCheckPo.sljlyqselectos}
							  </TD>
                              <TD colspan="2" class="table_none">
                                ${yjCheckPo.sopyjslj3mosluoyan}&nbsp;&nbsp;
                              	${yjCheckPo.sljlyhselectos}
                              </td>
                            </TR>
							<TR>
                              <TD width="35%" class="table_none">戴镜:&nbsp;&nbsp;
                              	${yjCheckPo.sopyjslj5mosdaijing}&nbsp;&nbsp;
                              	${yjCheckPo.sljdjqselectos}
                              </TD>
                              <TD colspan="2" class="table_none">
                                ${yjCheckPo.sopyjslj3mosdaijing}&nbsp;&nbsp;
                              	${yjCheckPo.sljdjhselectos}
                              </td>
                           	</TR>
                          </TBODY>
                        </TABLE>
                        </td>
					  </tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>【眼球运动】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<table class="privateBorder privateTable" cellspacing=1 cellpadding=3 width="99%" align=center border=0>
						  <tbody>
						    <tr>
						      <td width="5%" align="center" class="table_body">双眼</td>
						      <td colspan="4" align="left" class="table_none">
						        ${yjCheckPo.sopyjsljyqydshuangyan}
						      </td>
						    </tr>
						    <tr>
						      <td width="5%" align="center" class="table_body">单眼</td>
						      <td colspan="4" align="left" class="table_none">
						        ${yjCheckPo.sopyjsljyqyddanyan}
						      </td>
						    </tr>
						  </tbody>
						</table>
						</td>
					  </tr>
					</table>
				</fieldset>					
				<fieldset>
					<legend>【同视机检查】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<table class="privateBorder privateTable" cellspacing=1 cellpadding=3 width="99%" align=center border=0>
						  <tbody>
						    <tr>
						      <td width="5%" rowspan="2" align="center" class="table_body">Ⅰ级</td>
						      <td width="5%" rowspan="2" align="center" class="table_body">自觉</br></br>斜角</td>
						      <td width="30%" class="table_none">裸眼：
						      	${yjCheckPo.sopyjtsj1zjxjluoyan}  
							  </td>
						      <td width="5%" rowspan="2" align="center" class="table_body">他觉</br></br>斜角</td>
						      <td class="table_none">裸眼：
						        ${yjCheckPo.sopyjtsj1tjxjluoyan}
						      </td>
						    </tr>
						    <tr>
						      <td class="table_none">戴镜：
						        ${yjCheckPo.sopyjslj1zjxjdaijing}
						      </td>
						      <td class="table_none">戴镜：
						        ${yjCheckPo.sopyjslj1tjxjdaijing}
						      </td>
						    </tr>
						    <tr>
						      <td width="5%" align="center" class="table_body">Ⅱ级</td>
						      <td colspan="4" align="left" class="table_none">&nbsp;&nbsp;融合点：
						        ${yjCheckPo.sopyjtsj2ronghedian}
						        &nbsp;&nbsp;&nbsp;&nbsp;融合范围：
						        ${yjCheckPo.sopyjslj2ronghefanwei}
						      </td>
						    </tr>
						    <tr>
						      <td width="5%" align="center" class="table_body">Ⅲ级</td>
						      <td colspan="2" align="left" class="table_none">&nbsp;&nbsp;立体视：
						        <c:choose>
							 		<c:when test="${yjCheckPo.sopyjtsj3litishi eq 'y'}">有</c:when>
							 		<c:when test="${yjCheckPo.sopyjtsj3litishi eq 'w'}">无</c:when>
							 	</c:choose>
						      </td>
						      <td align="left" class="table_none" colspan="2">Titmus立体视：
					          	${yjCheckPo.sopyjslj3titmuslitishi}
					          </td>
						    </tr>
						  </tbody>
						</table>
						</td>
					  </tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>【同视机9方位】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td><TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center border=0>
					      <TBODY>
					        <TR>
					          <TD width="5%" align="center" class="table_body">L</TD>
					          <TD width="900" height="300" align="center" class="table_none"><TABLE class="privateBorder privateTable" cellSpacing=0 cellPadding=0 width="100%" align=center border=0 background="${ctx}/img/pic/jingzitu.png">
					            <tr>
					              <td width="300" height="100" align="center" style="border-top:2px #fff  solid;">
                                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjazfradio" id="sopyjtsjazfradio" value="0" ${yjCheckPo.sopyjtsjazfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjazfradio" id="sopyjtsjazfradio" value="1" ${yjCheckPo.sopyjtsjazfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjazfinput" name="yjCheckPo.sopyjtsjazfinput" value = "${yjCheckPo.sopyjtsjazfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjarlradio" id="sopyjtsjarlradio" value="0" ${yjCheckPo.sopyjtsjarlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjarlradio" id="sopyjtsjarlradio" value="1" ${yjCheckPo.sopyjtsjarlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjarlinput" name="yjCheckPo.sopyjtsjarlinput" value = "${yjCheckPo.sopyjtsjarlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjaexradio" id="sopyjtsjaexradio" value="0" ${yjCheckPo.sopyjtsjaexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjaexradio" id="sopyjtsjaexradio" value="1" ${yjCheckPo.sopyjtsjaexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjaexinput" name="yjCheckPo.sopyjtsjaexinput" value = "${yjCheckPo.sopyjtsjaexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table></td>
					              <td width="300" align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjbzfradio" id="sopyjtsjbzfradio" value="0" ${yjCheckPo.sopyjtsjbzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjbzfradio" id="sopyjtsjbzfradio" value="1" ${yjCheckPo.sopyjtsjbzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjbzfinput" name="yjCheckPo.sopyjtsjbzfinput" value = "${yjCheckPo.sopyjtsjbzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjbrlradio" id="sopyjtsjbrlradio" value="0" ${yjCheckPo.sopyjtsjbrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjbrlradio" id="sopyjtsjbrlradio" value="1" ${yjCheckPo.sopyjtsjbrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjbrlinput" name="yjCheckPo.sopyjtsjbrlinput" value = "${yjCheckPo.sopyjtsjbrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjbexradio" id="sopyjtsjbexradio" value="0" ${yjCheckPo.sopyjtsjbexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjbexradio" id="sopyjtsjbexradio" value="1" ${yjCheckPo.sopyjtsjbexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjbexinput" name="yjCheckPo.sopyjtsjbexinput" value = "${yjCheckPo.sopyjtsjbexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
								  </td>
					              <td width="300" align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjczfradio" id="sopyjtsjczfradio" value="0" ${yjCheckPo.sopyjtsjczfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjczfradio" id="sopyjtsjczfradio" value="1" ${yjCheckPo.sopyjtsjczfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjczfinput" name="yjCheckPo.sopyjtsjczfinput" value = "${yjCheckPo.sopyjtsjczfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjcrlradio" id="sopyjtsjcrlradio" value="0" ${yjCheckPo.sopyjtsjcrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjcrlradio" id="sopyjtsjcrlradio" value="1" ${yjCheckPo.sopyjtsjcrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjcrlinput" name="yjCheckPo.sopyjtsjcrlinput" value = "${yjCheckPo.sopyjtsjcrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjcexradio" id="sopyjtsjcexradio" value="0" ${yjCheckPo.sopyjtsjcexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjcexradio" id="sopyjtsjcexradio" value="1" ${yjCheckPo.sopyjtsjcexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjcexinput" name="yjCheckPo.sopyjtsjcexinput" value = "${yjCheckPo.sopyjtsjcexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
				                </tr>
					            <tr>
					              <td height="100" align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjdzfradio" id="sopyjtsjdzfradio" value="0" ${yjCheckPo.sopyjtsjdzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjdzfradio" id="sopyjtsjdzfradio" value="1" ${yjCheckPo.sopyjtsjdzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjdzfinput" name="yjCheckPo.sopyjtsjdzfinput" value = "${yjCheckPo.sopyjtsjdzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjdrlradio" id="sopyjtsjdrlradio" value="0" ${yjCheckPo.sopyjtsjdrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjdrlradio" id="sopyjtsjdrlradio" value="1" ${yjCheckPo.sopyjtsjdrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjdrlinput" name="yjCheckPo.sopyjtsjdrlinput" value = "${yjCheckPo.sopyjtsjdrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjdexradio" id="sopyjtsjdexradio" value="0" ${yjCheckPo.sopyjtsjdexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjdexradio" id="sopyjtsjdexradio" value="1" ${yjCheckPo.sopyjtsjdexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjdexinput" name="yjCheckPo.sopyjtsjdexinput" value = "${yjCheckPo.sopyjtsjdexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
					              <td align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjezfradio" id="sopyjtsjezfradio" value="0" ${yjCheckPo.sopyjtsjezfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjezfradio" id="sopyjtsjezfradio" value="1" ${yjCheckPo.sopyjtsjezfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjezfinput" name="yjCheckPo.sopyjtsjezfinput" value = "${yjCheckPo.sopyjtsjezfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjerlradio" id="sopyjtsjerlradio" value="0" ${yjCheckPo.sopyjtsjerlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjerlradio" id="sopyjtsjerlradio" value="1" ${yjCheckPo.sopyjtsjerlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjerlinput" name="yjCheckPo.sopyjtsjerlinput" value = "${yjCheckPo.sopyjtsjerlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjeexradio" id="sopyjtsjeexradio" value="0" ${yjCheckPo.sopyjtsjeexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjeexradio" id="sopyjtsjeexradio" value="1" ${yjCheckPo.sopyjtsjeexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjeexinput" name="yjCheckPo.sopyjtsjeexinput" value = "${yjCheckPo.sopyjtsjeexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
					              <td align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjfzfradio" id="sopyjtsjfzfradio" value="0" ${yjCheckPo.sopyjtsjfzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjfzfradio" id="sopyjtsjfzfradio" value="1" ${yjCheckPo.sopyjtsjfzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjfzfinput" name="yjCheckPo.sopyjtsjfzfinput" value = "${yjCheckPo.sopyjtsjfzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjfrlradio" id="sopyjtsjfrlradio" value="0" ${yjCheckPo.sopyjtsjfrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjfrlradio" id="sopyjtsjfrlradio" value="1" ${yjCheckPo.sopyjtsjfrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjfrlinput" name="yjCheckPo.sopyjtsjfrlinput" value = "${yjCheckPo.sopyjtsjfrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjfexradio" id="sopyjtsjfexradio" value="0" ${yjCheckPo.sopyjtsjfexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjfexradio" id="sopyjtsjfexradio" value="1" ${yjCheckPo.sopyjtsjfexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjfexinput" name="yjCheckPo.sopyjtsjfexinput" value = "${yjCheckPo.sopyjtsjfexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
				                </tr>
					            <tr>
					              <td height="100" align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjgzfradio" id="sopyjtsjgzfradio" value="0" ${yjCheckPo.sopyjtsjgzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjgzfradio" id="sopyjtsjgzfradio" value="1" ${yjCheckPo.sopyjtsjgzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjgzfinput" name="yjCheckPo.sopyjtsjgzfinput" value = "${yjCheckPo.sopyjtsjgzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjgrlradio" id="sopyjtsjgrlradio" value="0" ${yjCheckPo.sopyjtsjgrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjgrlradio" id="sopyjtsjgrlradio" value="1" ${yjCheckPo.sopyjtsjgrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjgrlinput" name="yjCheckPo.sopyjtsjgrlinput" value = "${yjCheckPo.sopyjtsjgrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjgexradio" id="sopyjtsjgexradio" value="0" ${yjCheckPo.sopyjtsjgexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjgexradio" id="sopyjtsjgexradio" value="1" ${yjCheckPo.sopyjtsjgexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjgexinput" name="yjCheckPo.sopyjtsjgexinput" value = "${yjCheckPo.sopyjtsjgexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
					              <td align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjhzfradio" id="sopyjtsjhzfradio" value="0" ${yjCheckPo.sopyjtsjhzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjhzfradio" id="sopyjtsjhzfradio" value="1" ${yjCheckPo.sopyjtsjhzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjhzfinput" name="yjCheckPo.sopyjtsjhzfinput" value = "${yjCheckPo.sopyjtsjhzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjhrlradio" id="sopyjtsjhrlradio" value="0" ${yjCheckPo.sopyjtsjhrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjhrlradio" id="sopyjtsjhrlradio" value="1" ${yjCheckPo.sopyjtsjhrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjhrlinput" name="yjCheckPo.sopyjtsjhrlinput" value = "${yjCheckPo.sopyjtsjhrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjhexradio" id="sopyjtsjhexradio" value="0" ${yjCheckPo.sopyjtsjhexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjhexradio" id="sopyjtsjhexradio" value="1" ${yjCheckPo.sopyjtsjhexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjhexinput" name="yjCheckPo.sopyjtsjhexinput" value = "${yjCheckPo.sopyjtsjhexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
					              <td align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjizfradio" id="sopyjtsjizfradio" value="0" ${yjCheckPo.sopyjtsjizfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjizfradio" id="sopyjtsjizfradio" value="1" ${yjCheckPo.sopyjtsjizfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjizfinput" name="yjCheckPo.sopyjtsjizfinput" value = "${yjCheckPo.sopyjtsjizfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjirlradio" id="sopyjtsjirlradio" value="0" ${yjCheckPo.sopyjtsjirlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjirlradio" id="sopyjtsjirlradio" value="1" ${yjCheckPo.sopyjtsjirlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjirlinput" name="yjCheckPo.sopyjtsjirlinput" value = "${yjCheckPo.sopyjtsjirlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjiexradio" id="sopyjtsjiexradio" value="0" ${yjCheckPo.sopyjtsjiexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjiexradio" id="sopyjtsjiexradio" value="1" ${yjCheckPo.sopyjtsjiexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjiexinput" name="yjCheckPo.sopyjtsjiexinput" value = "${yjCheckPo.sopyjtsjiexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
				                </tr>
				              </TABLE></TD>
                              <TD width="5%" align="center" class="table_body">R</TD>
                              <TD align="center" class="table_body">&nbsp;</TD>
				            </TR>
					        <TR>
					          <TD align="left" class="table_none" colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						      	<input type="radio" name="yjCheckPo.sopyjtsjreflefradio" id="sopyjtsjreflefradio" value="0" ${yjCheckPo.sopyjtsjreflefradio eq '0' ? 'checked="checked"' : ''}>REF
								<input type="radio" name="yjCheckPo.sopyjtsjreflefradio" id="sopyjtsjreflefradio" value="1" ${yjCheckPo.sopyjtsjreflefradio eq '1' ? 'checked="checked"' : ''}>LEF		
							  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  	<input type="radio" name="yjCheckPo.sopyjtsjccscradio" id="sopyjtsjccscradio" value="0" ${yjCheckPo.sopyjtsjccscradio eq '0' ? 'checked="checked"' : ''}><span style="line-height:1;border-top:solid 1px #000;">CC</span>
								<input type="radio" name="yjCheckPo.sopyjtsjccscradio" id="sopyjtsjccscradio" value="1" ${yjCheckPo.sopyjtsjccscradio eq '1' ? 'checked="checked"' : ''}><span style="line-height:1;border-top:solid 1px #000;">SC</span>		
							  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  	<input type="radio" name="yjCheckPo.sopyjtsj1050radio" id="sopyjtsj1050radio" value="0" ${yjCheckPo.sopyjtsj1050radio eq '0' ? 'checked="checked"' : ''}>10片
								<input type="radio" name="yjCheckPo.sopyjtsj1050radio" id="sopyjtsj1050radio" value="1" ${yjCheckPo.sopyjtsj1050radio eq '1' ? 'checked="checked"' : ''}>50片		
							  </TD>
				            </TR>				            
				          </TBODY>
					      </TABLE></td>
				      </tr>
				  </table>
				</fieldset>	
				<fieldset>
					<legend>【复像检查】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center border=0>
                          <TBODY>  
                            <TR>
                              <TD class="table_none">
                              ${fn:trim(yjCheckPo.sopyjfxjc) }
                              </TD>
                            </TR>                            
                          </TBODY>
                        </TABLE>
                        </td>
					  </tr>
					</table>
				</fieldset>	
				<fieldset>
					<legend>【特殊检查】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center border=0>
                          <TBODY>
                            <TR>
                              <TD align="left" class="table_none">&nbsp;
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj004' && yjCheckPo.sopyjtsjcselect == optionParamPoTmp.fopparamid}">
		                               ${optionParamPoTmp.fopparamname}：
		                              </c:if>	                                      	
	                               </c:forEach> 
                                ${yjCheckPo.sopyjtsjcinput}
							  </TD>
                            </TR>  
                          </TBODY>
                        </TABLE>
                        </td>
					  </tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>【调节灵敏度】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<table class="privateBorder privateTable" cellspacing=1 cellpadding=3 width="99%" align=center border=0>
						  <tbody>
						    <tr>
						      <td align="left" class="table_none">&nbsp;双面镜度数：
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj005' && yjCheckPo.sopyjtjlmdshuangmianjingdushu == optionParamPoTmp.fopparamid}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(yjCheckPo.sopyjtjlmdshuangmianjingdushu == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                                &nbsp;&nbsp;&nbsp;&nbsp;视标：
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj006' && yjCheckPo.sopyjtjlmdshibiao == optionParamPoTmp.fopparamid}">
		                               ${optionParamPoTmp.fopparamname}
		                              </c:if>	                                      	
	                               </c:forEach> 
							  </td>
					        </tr>
						    <tr>
						      <td align="left" class="table_none">&nbsp;
	                              OU：${yjCheckPo.sopyjtjlmdou}&nbsp;&nbsp;&nbsp;&nbsp;
	                              OD：${yjCheckPo.sopyjtjlmdod}&nbsp;&nbsp;&nbsp;&nbsp;
	                              OS：${yjCheckPo.sopyjtjlmdos}&nbsp;&nbsp;&nbsp;&nbsp;
                              </td>
					        </tr>
						  </tbody>
						</table>
						</td>
					  </tr>
					</table>
				</fieldset>																			
                </DIV>
              </DIV>
                  <!--?End--></TD>
              <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
             </TR>
           	</TBODY>
      		</TABLE>
         </TD>
        </TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>