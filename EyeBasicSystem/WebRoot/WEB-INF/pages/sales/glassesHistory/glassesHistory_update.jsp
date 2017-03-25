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
			glassesHistoryForm.action = "updateGlassesHistory.action";
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
});
	
	
	function optometry(){
		glassesHistoryForm.action="initOptometryBasicSel.action";
		glassesHistoryForm.submit();
	}
	
	function clean(){
		document.glassesHistoryForm.reset();
	}
</script>

</HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"><BODY bgColor=#ffffff topMargin=5>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="glassesHistoryForm" name="glassesHistoryForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" name="sophifcustomerid" id="sophifcustomerid" value="${requestScope.customerID}" />  
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
		<!-- ͷ˵ Start -->
		  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TBODY>
			  
			  <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：戴镜史</TD>
            <td align="right" valign="bottom">
            	
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
			  
			  
			</TBODY>
		  </TABLE>
		<!-- ͷ˵ End -->
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
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="optometry()"
                      UNSELECTABLE="on">客户验光</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
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
							
						  <s:action name="initCustomerOptometryTitle" executeResult="true" />	
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
									  <select id="sophifglassestype" name="sophifglassestype">
									  	<option value="">----请选择----</option>
									  	<option value="无" ${hisInfoPo.sophifglassestype == '无' ? 'selected=selected':''}>无</option>
										<option value="框架" ${hisInfoPo.sophifglassestype == '框架' ? 'selected=selected':''}>框架</option>
										<option value="隐形眼镜" ${hisInfoPo.sophifglassestype == '隐形眼镜' ? 'selected=selected':''}>隐形眼镜</option>
									  </select></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">镜片材质</TD>
                                      <TD width="15%" class="table_none">
                                      <select id="sophifglassesm" name="sophifglassesm">
                                        <option value="">----请选择----</option>
                                        <option value="老花渐进" ${hisInfoPo.sophifglassesm == '老花渐进' ? 'selected=selected':''}>老花渐进</option>
										<option value="青少年渐进" ${hisInfoPo.sophifglassesm == '青少年渐进' ? 'selected=selected':''}>青少年渐进</option>
										<option value="非球面树脂" ${hisInfoPo.sophifglassesm == '非球面树脂' ? 'selected=selected':''}>非球面树脂</option>
										<option value="抗幅射镜片" ${hisInfoPo.sophifglassesm == '抗幅射镜片' ? 'selected=selected':''}>抗幅射镜片</option>
										<option value="染色镜片" ${hisInfoPo.sophifglassesm == '染色镜片' ? 'selected=selected':''}>染色镜片</option>
										<option value="变色镜片" ${hisInfoPo.sophifglassesm == '变色镜片' ? 'selected=selected':''}>变色镜片</option>
										<option value="普通树脂" ${hisInfoPo.sophifglassesm == '普通树脂' ? 'selected=selected':''}>普通树脂</option>
										<option value="高折玻璃" ${hisInfoPo.sophifglassesm == '高折玻璃' ? 'selected=selected':''}>高折玻璃</option>
										<option value="玻璃片" ${hisInfoPo.sophifglassesm == '玻璃片' ? 'selected=selected':''}>玻璃片</option>
										<option value="树脂偏光镜片（茶/灰）" ${hisInfoPo.sophifglassesm == '树脂偏光镜片（茶/灰）' ? 'selected=selected':''}>树脂偏光镜片（茶/灰）</option>
										<option value="树脂抗疲劳镜片" ${hisInfoPo.sophifglassesm == '树脂抗疲劳镜片' ? 'selected=selected':''}>树脂抗疲劳镜片</option>
										<option value="双光片" ${hisInfoPo.sophifglassesm == '双光片' ? 'selected=selected':''}>双光片</option>
                                      </select></TD>
                                      <TD width="10%" class="table_body">镜片型</TD>
                                      <TD width="15%" class="table_none">
                                      <select id="sophifglasseskind" name="sophifglasseskind">
                                        <option value="">----请选择----</option>
                                        <option value="老花渐进" ${hisInfoPo.sophifglasseskind == '老花渐进' ? 'selected=selected':''}>老花渐进</option>
										<option value="青少年渐进" ${hisInfoPo.sophifglasseskind == '青少年渐进' ? 'selected=selected':''}>青少年渐进</option>
										<option value="远用框架" ${hisInfoPo.sophifglasseskind == '远用框架' ? 'selected=selected':''}>远用框架</option>
										<option value="近用框架" ${hisInfoPo.sophifglasseskind == '近用框架' ? 'selected=selected':''}>近用框架</option>
										<option value="双光框架" ${hisInfoPo.sophifglasseskind == '双光框架' ? 'selected=selected':''}>双光框架</option> 
                                      </select></TD>
                                      <TD width="10%" class="table_body">镜片颜色</TD>
                                      <TD width="15%" class="table_none">
                                      <select id="sophifglassesc" name="sophifglassesc">
                                        <option value="">----请选择----</option>
                                        <option value="变茶" ${hisInfoPo.sophifglassesc == '变茶' ? 'selected=selected':''}>变茶</option>
										<option value="变灰" ${hisInfoPo.sophifglassesc == '变灰' ? 'selected=selected':''}>变灰</option>
										<option value="染色" ${hisInfoPo.sophifglassesc == '变灰' ? 'selected=selected':''}>染色</option>
										<option value="树脂偏光镜片（茶/灰）" ${hisInfoPo.sophifglassesc == '树脂偏光镜片（茶/灰）' ? 'selected=selected':''}>树脂偏光镜片（茶/灰）</option>
										<option value="树脂抗疲劳镜片" ${hisInfoPo.sophifglassesc == '树脂抗疲劳镜片' ? 'selected=selected':''}>树脂抗疲劳镜片</option>
                                      </select></TD>
                                      <TD width="10%" class="table_body">戴镜年限</TD>
                                      <TD width="15%" class="table_none"><input id="sophifglassesage" name="sophifglassesage" class="text_input" size="4" value="${hisInfoPo.sophifglassesage}">年</TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">隐形材质</TD>
                                      <TD class="table_none">
                                      <select id="sophifcontactlensm" name="sophifcontactlensm">
                                        <option value="">----请选择----</option>
                                        <option value="透气性硬性接触镜" ${hisInfoPo.sophifcontactlensm == '透气性硬性接触镜' ? 'selected=selected':''}>透气性硬性接触镜</option>
										<option value="硅弹镜软镜" ${hisInfoPo.sophifcontactlensm == '硅弹镜软镜' ? 'selected=selected':''}>硅弹镜软镜</option>	
										<option value="水凝胶软镜" ${hisInfoPo.sophifcontactlensm == '水凝胶软镜' ? 'selected=selected':''}>水凝胶软镜</option>
										<option value="硅水凝胶软镜" ${hisInfoPo.sophifcontactlensm == '硅水凝胶软镜' ? 'selected=selected':''}>硅水凝胶软镜</option>
                                      </select></TD>
                                      <TD class="table_body">隐形产品</TD>
                                      <TD class="table_none">
                                      <select id="sophifcontactlensbrand" name="sophifcontactlensbrand" value="${hisInfoPo.sophifglassestype}">
                                        <option value="">----请选择----</option>
                                        <option value="强生" ${hisInfoPo.sophifcontactlensbrand == '强生' ? 'selected=selected':''}>强生</option>
										<option value="视康" ${hisInfoPo.sophifcontactlensbrand == '视康' ? 'selected=selected':''}>视康</option>
										<option value="卫康" ${hisInfoPo.sophifcontactlensbrand == '卫康' ? 'selected=selected':''}>卫康</option>
										<option value="博士伦" ${hisInfoPo.sophifcontactlensbrand == '博士伦' ? 'selected=selected':''}>博士伦</option>
										<option value="海昌" ${hisInfoPo.sophifcontactlensbrand == '海昌' ? 'selected=selected':''}>海昌</option>		
										<option value="富士伦" ${hisInfoPo.sophifcontactlensbrand == '富士伦' ? 'selected=selected':''}>富士伦</option>	
										<option value="菲士康" ${hisInfoPo.sophifcontactlensbrand == '菲士康' ? 'selected=selected':''}>菲士康</option>	
										<option value="艾爵" ${hisInfoPo.sophifcontactlensbrand == '艾爵' ? 'selected=selected':''}>艾爵</option>	
										<option value="晶视佳" ${hisInfoPo.sophifcontactlensbrand == '晶视佳' ? 'selected=selected':''}>晶视佳</option>
                                      </select></TD>
                                      <TD class="table_body">镜片颜色</TD>
                                      <TD class="table_none">
                                      <select id="sophifcontactlensc" name="sophifcontactlensc">
                                        <option value="">----请选择----</option>
                                        <option value="彩色" ${hisInfoPo.sophifcontactlensc == '强生' ? 'selected=selected':''}>彩色</option>
										<option value="无色" ${hisInfoPo.sophifcontactlensc == '无色' ? 'selected=selected':''}>无色</option>
										<option value="淡蓝色" ${hisInfoPo.sophifcontactlensc == '淡蓝色' ? 'selected=selected':''}>淡蓝色</option>
										<option value="淡绿色" ${hisInfoPo.sophifcontactlensc == '淡绿色' ? 'selected=selected':''}>淡绿色</option>
										<option value="黑色" ${hisInfoPo.sophifcontactlensc == '黑色' ? 'selected=selected':''}>黑色</option>
										<option value="棕色" ${hisInfoPo.sophifcontactlensc == '棕色' ? 'selected=selected':''}>棕色</option>
                                      </select></TD>
                                      <TD class="table_body">戴镜年限</TD>
                                      <TD class="table_none"><input id="sophifcontactlensage" name="sophifcontactlensage" class="text_input" size="4" value="${hisInfoPo.sophifcontactlensage}">年</TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						<br>
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
						<fieldset>		
								  <legend>旧镜信息</legend>
									<table width="100%">
									<tr height="30">
									<TD bgcolor="#DFFFDF" class="PrivateBorderGreen">&nbsp;</TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">球镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">柱镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">轴向</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">Add</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">三棱镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">基底</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">瞳距(mm)</div></TD>
								   
							      </TR>
                                    <tr height="30">
                                      <TD width="11%" bgcolor="#DFFFDF" class="PrivateBorderGreen">OD</TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiballod }<input type="hidden" name="sophiballod" id="sophiballod" value="${hisInfoPo.sophiballod }"/>
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophipostod }<input type="hidden" name="sophipostod" id="sophipostod" value="${hisInfoPo.sophipostod }"/>
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiaxesod }<input type="hidden" name="sophiaxesod" id="sophiaxesod" value="${hisInfoPo.sophiaxesod }"/>
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiaddod }<input type="hidden" name="sophiaddod" id="sophiaddod" value="${hisInfoPo.sophiaddod }"/>
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiarriseod }<input type="hidden" name="sophiarriseod" id="sophiarriseod" value="${hisInfoPo.sophiarriseod }"/>
                                      </div></TD>
                                      <TD width="6%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <div align="center">
                                         ${hisInfoPo.sophibasisod }<input type="hidden" name="sophibasisod" id="sophibasisod" value="${hisInfoPo.sophibasisod }"/>
                                        </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiinterhighod }<input type="hidden" name="sophiinterhighod" id="sophiinterhighod" value="${hisInfoPo.sophiinterhighod }"/>
                                      </div></TD>
                                 
                                    </TR>
                                    <tr height="30">
                                      <TD width="11%" bgcolor="#DFFFDF" class="PrivateBorderGreen">OS</TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiballos }<input type="hidden" name="sophiballos" id="sophiballos" value="${hisInfoPo.sophiballos }"/>
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophipostos }<input type="hidden" name="sophipostos" id="sophipostos" value="${hisInfoPo.sophipostos }"/>
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiaxesos }<input type="hidden" name="sophiaxesos" id="sophiaxesos" value="${hisInfoPo.sophiaxesos }"/>
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiaddos }<input type="hidden" name="sophiaddos" id="sophiaddos" value="${hisInfoPo.sophiaddos }"/>
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiarriseos }<input type="hidden" name="sophiarriseos" id="sophiarriseos" value="${hisInfoPo.sophiarriseos }"/>
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <div align="center">
                                         ${hisInfoPo.sophibasisos }<input type="hidden" name="sophibasisos" id="sophibasisos" value="${hisInfoPo.sophibasisos}"/>
                                        </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        ${hisInfoPo.sophiinterhighos }<input type="hidden" name="sophiinterhighos" id="sophiinterhighos" value="${hisInfoPo.sophiinterhighos }"/>
                                      </div></TD>
                                    
                                    </tr>
							</table>                        
							</fieldset>	
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn name="button1" id="button1" title="保存" onClick="save()">
                              &nbsp;&nbsp;
                              <img src="${ctx}/img/newbtn/btn_empty_0.png" btn=btn onclick="clean()" title="清空" >
                              </div></TD></TR>
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
