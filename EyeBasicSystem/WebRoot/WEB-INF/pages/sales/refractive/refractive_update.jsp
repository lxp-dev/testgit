<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script language="javascript" src="${ctx}/js/orderItem.js"></script>
		<script type='text/javascript' src='${ctx }/js/module/autocomplete1.js'></script>
		<title>屈光检查</title>
	</head>
	<script>
	function save(){
			if($('input[name=refractivePo.soprdbalballglassod]').val()==''){
				alert('双眼平衡结果右眼球镜不能为空!');
				$('input[name=refractivePo.soprdbalballglassod]').focus();
				return false;
			}
			if($('input[name=refractivePo.soprdbalballglassos]').val()==''){
				alert('双眼平衡结果左眼球镜不能为空!');
				$('input[name=refractivePo.soprdbalballglassos]').focus();
				return false;
			}
			if($('input[name=refractivePo.soprdbalpostglassod]').val()==''){
				$('input[name=refractivePo.soprdbalpostglassod]').val('0.00');
			}else if(parseFloat($('input[name=refractivePo.soprdbalpostglassod]').val()) != 0){
				if($('input[name=refractivePo.soprdbalaxesod]').val() == ''){
					alert("请填写右眼轴向!");
					$('input[name=refractivePo.soprdbalaxesod]').focus();
					return '';
				}
			}
			
			if($('input[name=refractivePo.soprdbalpostglassos]').val()==''){
				$('input[name=refractivePo.soprdbalpostglassos]').val('0.00');
			}else if(parseFloat($('input[name=refractivePo.soprdbalpostglassos]').val()) != 0){
				if($('input[name=refractivePo.soprdbalaxesos]').val() == ''){
					alert("请填写左眼轴向!");
					$('input[name=refractivePo.soprdbalaxesos]').focus();
					return '';
				}
			}
			if($('[name=refractivePo.soprdbalaxesod]').val()==''){
				$('[name=refractivePo.soprdbalaxesod]').val('');
			}
			if($('[name=refractivePo.soprdbalaxesos]').val()==''){
				$('[name=refractivePo.soprdbalaxesos]').val('');
			}
			if($('input[name=refractivePo.soprdbalarriseglassod]').val()!=''){
				if($('[name=refractivePo.soprdbalbasisod]').val()==''){
					alert('双眼平衡结果右眼基底不能为空!');
					return false;
				}
			}
			if($('input[name=refractivePo.soprdbalarriseglassos]').val()!=''){
				if($('[name=refractivePo.soprdbalbasisos]').val()==''){
					alert('双眼平衡结果左眼基底不能为空!');
					return false;
				}
			}
			
			
			if($('[name=refractivePo.soprdbalbasisod]').val()!=''){
				if($('[name=refractivePo.soprdbalarriseglassod]').val()==''){
					alert('双眼平衡结果右眼三棱镜不能为空!');
					return false;
				}
			}
			if($('[name=refractivePo.soprdbalbasisos]').val()!=''){
				if($('[name=refractivePo.soprdbalarriseglassos]').val()==''){
					alert('双眼平衡结果左眼三棱镜不能为空!');
					return false;
				}
			}
		$("img").removeAttr("onclick");
		refractiveForm.action="refractiveUpdate.action";
		refractiveForm.submit();
	}
	
	function inspection(){
		if('${systemParameterPo.fspinspectionvisuelle}'=='1'){
			if('${isDoubleEyeFun}' != '1'){
				alert("在进行检查结论之前，请先进行视功能检查！");
				return;
			}
		}
		$("img").removeAttr("onclick");
		refractiveForm.action="inspectionTool.action?source=inspectioniou";
		refractiveForm.submit();
	}
	function doubleEyeFun(){
		$("img").removeAttr("onclick");
		refractiveForm.action="doubleEyeFunTool.action?source=doubleeyefuniou";
		refractiveForm.submit();
	}
	function specialCheck(){
		$("img").removeAttr("onclick");
		refractiveForm.action="specialCheckTool.action?source=specialcheckiou";
		refractiveForm.submit();
	}
//散瞳 检影按键 
	function mydriasis() {
		$('input[name=refractivePo.soprdbalballglassod]').val($('input[name=refractivePo.soprtestballglassod]').val());
		$('input[name=refractivePo.soprdbalballglassos]').val($('input[name=refractivePo.soprtestballglassos]').val());
		$('input[name=refractivePo.soprdbalpostglassod]').val($('input[name=refractivePo.soprtestpostglassod]').val());
		$('input[name=refractivePo.soprdbalpostglassos]').val($('input[name=refractivePo.soprtestpostglassos]').val());
		$('input[name=refractivePo.soprdbalaxesod]').val($('input[name=refractivePo.soprtestaxesod]').val());	
		$('input[name=refractivePo.soprdbalaxesos]').val($('input[name=refractivePo.soprtestaxesos]').val());
		$('input[name=refractivePo.soprdbalvaod]').val($('input[name=refractivePo.soprtestvaod]').val());
		$('input[name=refractivePo.soprdbalvaos]').val($('input[name=refractivePo.soprtestvaos]').val());
		$('input[name=refractivePo.soproaballglassod]').val($('input[name=refractivePo.soprtestballglassod]').val())
		$('input[name=refractivePo.soproaballglassos]').val($('input[name=refractivePo.soprtestballglassos]').val())
		$('input[name=refractivePo.soproapostglassod]').val($('input[name=refractivePo.soprtestpostglassod]').val())
		$('input[name=refractivePo.soproapostglassos]').val($('input[name=refractivePo.soprtestpostglassos]').val())
		$('input[name=refractivePo.soproaaxesod]').val($('input[name=refractivePo.soprtestaxesod]').val())
		$('input[name=refractivePo.soproaaxesos]').val($('input[name=refractivePo.soprtestaxesos]').val())
		$('input[name=refractivePo.soproavaod]').val($('input[name=refractivePo.soprtestvaod]').val())
		$('input[name=refractivePo.soproavaos]').val($('input[name=refractivePo.soprtestvaos]').val())
		
		$("[zj=zj]").each(function (){
			if(parseFloat($(this).val()) == 0){
				$(this).parent().parent().parent().find("[zx=zx]").val("");
				$(this).parent().parent().parent().find("[zx=zx]").attr("style","background-color: red;");
				$(this).parent().parent().parent().find("[zx=zx]").attr("readonly","readonly");
			}else{
				$(this).parent().parent().parent().find("[zx=zx]").attr("style","background-color: white;");
				$(this).parent().parent().parent().find("[zx=zx]").attr("readonly","");
			}
		});
	}
	
	//客户屈光按键
	function kgqg() {
		$('input[name=refractivePo.soprdbalballglassod]').val($('input[name=refractivePo.soproaballglassod]').val());
		$('input[name=refractivePo.soprdbalballglassos]').val($('input[name=refractivePo.soproaballglassos]').val());
		$('input[name=refractivePo.soprdbalpostglassod]').val($('input[name=refractivePo.soproapostglassod]').val());
		$('input[name=refractivePo.soprdbalpostglassos]').val($('input[name=refractivePo.soproapostglassos]').val());
		$('input[name=refractivePo.soprdbalaxesod]').val($('input[name=refractivePo.soproaaxesod]').val());	
		$('input[name=refractivePo.soprdbalaxesos]').val($('input[name=refractivePo.soproaaxesos]').val());
		$('input[name=refractivePo.soprdbalvaod]').val($('input[name=refractivePo.soproavaod]').val());
		$('input[name=refractivePo.soprdbalvaos]').val($('input[name=refractivePo.soproavaos]').val());
		
		$("[zj=zj]").each(function (){
			if(parseFloat($(this).val()) == 0){
				$(this).parent().parent().parent().find("[zx=zx]").val("");
				$(this).parent().parent().parent().find("[zx=zx]").attr("style","background-color: red;");
				$(this).parent().parent().parent().find("[zx=zx]").attr("readonly","readonly");
			}else{
				$(this).parent().parent().parent().find("[zx=zx]").attr("style","background-color: white;");
				$(this).parent().parent().parent().find("[zx=zx]").attr("readonly","");
			}
		});
	}
	
	/*
验证脚本
*/
function inspectionCheck(){
		$('input[qj=qj]').each(function(){
			$(this).bind("blur",function(){
				checkqj(this);
			});
		});	
			
		$('input[zj=zj]').each(function(){
			$(this).bind("blur",function(){
				checkzj(this);
			});
		});	
		$('input[zx=zx]').each(function(){
			$(this).bind("blur",function(){
				checkzx(this);
			});
		});
		$('input[sph=sph]').each(function(){
			$(this).bind("blur",function(){checkData(this);});
		});	
		
		$('input[va=va]').each(function(){
			$(this).bind("blur",function(){
				checkVA(this);
			});
		});
		$('input[ljxj=ljxj]').each(function(){
			$(this).bind("blur",function(){
				checkLjXj(this);
			});
		});
		$('input[tongju=tongju]').each(function(){
			$(this).bind("blur",function(){
				checkPupilDistance(this);
			});
		});
}
	//补零
	function addZero(obj) {
		if (obj.value.indexOf(".") == -1) {
			obj.value += ".00";
		} else if (obj.value.indexOf(".") == obj.value.length - 2) {
			obj.value += "0";
		}
	}
	//球镜、柱镜
	var re1 = /^[\+\-]?[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	//轴向
	var rez = /^-?\d+$/;
	//视力
	var re2 = /^[0-9]{1}([.]{1}[0-9]{1,2})(\+|-)?$/;
	
	//棱镜、下加
	var re3 = /^[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	
	//瞳距
	var re4 = /^[0-9][0-9](\.[0-9])?$/;
	
	//直径
	var re5 = /^[0-9]*([.]{0,1}[0-9])$/;
	
	var re6 = /^-?\d+$/;
	//验证球镜
	function checkqj(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		
		if(parseFloat(obj.value)%0.25!=0){
			alert("球径应为 0.25的倍数！");
			obj.select();
			return;
		}
		
		if ((!(re1.test(obj.value)))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
				if(obj.value.substr(0,1)=='-'){
					addZero(obj);
				}else if(obj.value.substr(0,1)=='+'){
					addZero(obj);
				}else{
					if(obj.value=='0'){
					addZero(obj);
				}else{
					obj.value = '+'+obj.value;
					addZero(obj);
				}
				}
			
		}
	}
	//验证柱镜
	function checkzj(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		
		if(parseFloat(obj.value)%0.25!=0){
			alert("柱径应为 0.25的倍数！");
			obj.select();
			return;
		}
		
		if (!(re1.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			if(obj.value.substr(0,1)=='+'){
				addZero(obj);
			}else if(obj.value.substr(0,1)=='-'){
				addZero(obj);
			}else{
				if(obj.value=='0'){
					addZero(obj);
				}else{
					obj.value = '+'+obj.value;
					addZero(obj);
				}
			}
		}
		
		$("[zj=zj]").each(function (){
			if(parseFloat($(this).val()) == 0){
				$(this).parent().parent().parent().find("[zx=zx]").val("");
				$(this).parent().parent().parent().find("[zx=zx]").attr("style","background-color: red;");
				$(this).parent().parent().parent().find("[zx=zx]").attr("readonly","readonly");
			}else{
				$(this).parent().parent().parent().find("[zx=zx]").attr("style","background-color: white;");
				$(this).parent().parent().parent().find("[zx=zx]").attr("readonly","");
			}
		});
	}
	//轴向
	function checkzx(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(rez.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
			return;
		} 
		if(!((obj.value>=0)&&(180>=obj.value))){
				alert("轴向在0-180之间！");
				obj.select();
				return;
		}
	}
	
	//验证ADD
	function checkData(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		
		if(parseFloat(obj.value)%0.25!=0){
			alert("ADD应为 0.25的倍数！");
			obj.select();
			return;
		}
		
		if (!(re1.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			addZero(obj);
		}
	}
	//验证视力
	function checkVA(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re2.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			vaAddZero(obj);
		}
	}
	
	//验证棱镜、下加
	function checkLjXj(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re3.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			addZero(obj);
		}
	}
	
	//验证瞳距
	function checkPupilDistance(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re4.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		}
		vaAddZero(obj);
	}
	
	//视力补零
	function vaAddZero(obj) {
		if (obj.value.indexOf(".") == -1) {
			obj.value += ".0";
		}
	}
	//按键加值
	function changeFocus(obj)
	{
	
    if(event.keyCode==38){
		if(obj.value == ''){
			obj.value=0.25;
		}
		else{
		    obj.value = (parseFloat(obj.value)+0.25).toFixed(2);		
		}
	}
    if(event.keyCode==40){
		if(obj.value == ''){
			obj.value = -0.25;
		}else{
			obj.value = (parseFloat(obj.value)-0.25).toFixed(2);			
		}
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
		inspectionCheck();
		searchButton();
		checkCylZero();
	});
	
	function checkCylZero(){
  		$("[zj=zj]").each(function (){
			if(parseFloat($(this).val()) == 0){
				$(this).parent().parent().parent().find("[zx=zx]").val("");
				$(this).parent().parent().parent().find("[zx=zx]").attr("style","background-color: red;");
				$(this).parent().parent().parent().find("[zx=zx]").attr("readonly","readonly");
			}else{
				$(this).parent().parent().parent().find("[zx=zx]").attr("style","background-color: white;");
				$(this).parent().parent().parent().find("[zx=zx]").attr("readonly","");
			}
		});
  	}
	
	//回车事件
	function EnterDown(thisnum){
		if(event.keyCode == 13 || event.srcElement.type   == 'input '){
			var i = thisnum.id.substr(5);
			i = ++i;
			$("\"[id=enter"+i+"]\"").focus();
			$("\"[id=enter"+i+"]\"").select();//选中
		}
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="refractiveForm" method="post" action="">
<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID"  value="${requestScope.optometryID}" />  
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" />  
<input type="hidden" name="oldOptometryID"  value="${requestScope.oldOptometryID}" />
<input type="hidden" name="oldOptometryIDFirst"  value="${requestScope.oldOptometryIDFirst}" />  
<input type="hidden" name="moduleID"  value="${moduleID }"/>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<tbody>
				<tr>
					<td>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD style="PADDING-LEFT: 2px; HEIGHT: 22px"  background=${ctx }/img/pic/tab_top_bg.gif>
										<TABLE cellSpacing=0 cellPadding=0 border=0>
							 				<TBODY>
							 					<tr>
													<!--ťStart-->
													<TD>
													  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
														<TBODY>
														<TR>
														  <TD width=3><IMG id=tabImgLeft__0 height=22 
															src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
														  <TD class=tab id=tabLabel__0 
														  onclick="JavaScript:void(0);"
														  background=${ctx}/img/pic/tab_active_bg.gif 
														  UNSELECTABLE="on">屈光检查</TD>
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
														<TD>
												 			<TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
																<TBODY>
																<TR>
																  <TD width=3><IMG id=tabImgLeft__1 height=22 
																	src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
																  <TD class=tab id=tabLabel__1 
																  onclick="doubleEyeFun()" 
																  background=${ctx }/img/pic/tab_unactive_bg.gif
																  UNSELECTABLE="on">双眼视功能检查</TD>
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
																src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
															  <TD class=tab id=tabLabel__1 
															  onclick="specialCheck()" 
															  background=${ctx }/img/pic/tab_unactive_bg.gif 
															  UNSELECTABLE="on">特殊功能检查</TD>
															  <TD width=3><IMG id=tabImgRight__1 height=22 
																src="${ctx }/img/pic/tab_unactive_right.gif" 
															width=3></TD>
															</TR>
															</TBODY>
														  </TABLE>
													  </TD>
													</tr>
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
														<TD width=1 background=${ctx}/img/pic/tab_bg.gif>
															<IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1>
														</TD>
														<TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; "
															vAlign=top>
															<input type="hidden" id="customerReadonly" name="customerReadonly" value="readOnly" />
															<s:action name="initCustomerOptometryTitle"
																executeResult="true" />
															<br>
															<fieldset>
																<legend>
																	屈光检查
																</legend>
																<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
																	<tr>
																		<td>
																			<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
																				<tbody>
																					<tr bgcolor="#CADEE8">
																						<TD class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								PD:
																							</div>
																						</TD>
																						<TD class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								OD
																							</div>
																						</TD>
																						<TD class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								<input type="text" jjorder="1" needChange="needChange" 
																									tongju="tongju" name="refractivePo.soprcheckpdod"
																									value="${refractivePo.soprcheckpdod }"
																									class="text_input" size="4" id="enter1"
																									onkeypress="EnterDown(this)">
																							</div>
																						</TD>
																						<TD class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								OS
																							</div>
																						</TD>
																						<TD width="8%" class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								<input type="text" jjorder="2" needChange="needChange"
																									tongju="tongju" name="refractivePo.soprcheckpdos"
																									value="${refractivePo.soprcheckpdos }"
																									class="text_input" size="4" id="enter2"
																									onkeypress="EnterDown(this)">
																							</div>
																						</TD>
																						<TD class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								裸眼视力：
																							</div>
																						</TD>
																						<TD class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								右
																							</div>
																						</TD>
																						<TD width="8%" class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								<input type="text" jjorder="1" needChange="needChange"
																									va="va" name="refractivePo.soprnakedod"
																									value="${refractivePo.soprnakedod }"
																									class="text_input" size="4" id="enter3"
																									onkeypress="EnterDown(this)">
																							</div>
																						</TD>
																						<TD class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								左
																							</div>
																						</TD>
																						<TD width="8%" class="PrivateBorderBlue" width="10%">
																							<div align="center">
																								<input type="text" jjorder="2" needChange="needChange"
																									va="va" name="refractivePo.soprnakedos"
																									value="${refractivePo.soprnakedos }"
																									class="text_input" size="4" id="enter4"
																									onkeypress="EnterDown(this)">
																							</div>
																						</TD>
																					</tr>
																				</tbody>
																			</table>
																		</td>
																	</tr>
																</table>																
															</fieldset>
															<br>
															<fieldset>
																<legend>检影验光</legend>													
																<table width="99%" class="privateTable" border="0" cellpadding="1" cellspacing="1">
																  		
																	<tr bgcolor="#CADEE8">
																		<TD colspan="9"
																			class="PrivateBorderBlue" height="25px">
																			<c:if test="${refractivePo.soprdiffusepupil == '4'}">
																				<input type="hidden" name="refractivePo.soprdiffusepupil" value="4"/>复检
																			</c:if>
																			<c:if test="${refractivePo.soprdiffusepupil != '4'}">
																				<input  type="radio" checked="checked" id="pupil" ${refractivePo.soprdiffusepupil != '1' ? '' : 'checked=checked' } name="refractivePo.soprdiffusepupil" value="1">快速散瞳
																				<input  type="radio" id="pupil" ${refractivePo.soprdiffusepupil != '2' ? '' : 'checked=checked' } name="refractivePo.soprdiffusepupil" value="2">慢速散瞳
																				<input  type="radio" id="pupil" ${refractivePo.soprdiffusepupil != '3' ? '' : 'checked=checked' } name="refractivePo.soprdiffusepupil" value="3">显然验光
																			</c:if>
																		</TD>
																	</tr>
																	<tr bgcolor="#CADEE8" height="25px">
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				&nbsp;
																			</div>
																		</TD>
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		
																		
																		<TD  class="PrivateBorderBlue">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																		
																		<TD  class="PrivateBorderBlue">
																			&nbsp;
																		</TD>
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD class="PrivateBorderBlue">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue">
																			<div align="center">
																				VA
																			</div>
																		</TD>
																	</tr>
																	<TBODY>
																		<tr bgcolor="#CADEE8">
																			<TD width="11%"
																				class="PrivateBorderBlue">
																				OD
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" needChange="needChange" yyorder="1" qj="qj" class="text_input" size="4" name="refractivePo.soprcheckballglassod"
																						onkeydown="changeFocus(this)"
																						value="${refractivePo.soprcheckballglassod }"
																						id="enter5" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" needChange="needChange" yyorder="2"
																						zj="zj" name="refractivePo.soprcheckpostglassod"
																						class="text_input" size="4" onkeydown="changeFocus(this)"
																						value="${refractivePo.soprcheckpostglassod }"
																						id="enter6" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="3"
																						name="refractivePo.soprcheckaxesod" zx="zx"
																						class="text_input" size="4"
																						value="${ refractivePo.soprcheckaxesod}"
																						id="enter7" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue" rowspan="2">
																				<div align="center">
																					试镜：
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="4"
																						name="refractivePo.soprtestballglassod"
																						qj="qj" class="text_input" size="4"
																						onkeydown="changeFocus(this)"
																						value="${refractivePo.soprtestballglassod }"
																						id="enter11" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			
																		
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" zj="zj" name="refractivePo.soprtestpostglassod" 
																					value="${refractivePo.soprtestpostglassod }" class="text_input" size="4"
																					onkeydown="changeFocus(this)"
																					id="enter12" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="7" zx="zx"
																						name="refractivePo.soprtestaxesod"
																						value="${refractivePo.soprtestaxesod }"
																						class="text_input" size="4"
																						id="enter13" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" name="refractivePo.soprtestvaod"	value="${refractivePo.soprtestvaod }"
																						va="va" class="text_input" size="4" id="enter14" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																		</TR>
																		<tr bgcolor="#CADEE8">
																			<TD width="11%"
																				class="PrivateBorderBlue">
																				OS
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="8" needChange="needChange"
																						qj="qj" name="refractivePo.soprcheckballglassos"
																						value="${refractivePo.soprcheckballglassos }"
																						onkeydown="changeFocus(this)"
																						class="text_input" size="4" id="enter8" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="9"
																						name="refractivePo.soprcheckpostglassos" zj="zj"
																						value="${refractivePo.soprcheckpostglassos }"
																						onkeydown="changeFocus(this)"
																						class="text_input" size="4"
																						id="enter9" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="10" needChange="needChange"
																						zx="zx" name="refractivePo.soprcheckaxesos"
																						value="${refractivePo.soprcheckaxesos }"
																						class="text_input" size="4"
																						id="enter10" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" name="refractivePo.soprtestballglassos" value="${refractivePo.soprtestballglassos }"
																					qj="qj"	class="text_input" size="4" onkeydown="changeFocus(this)"
																					id="enter15" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="11"
																						name="refractivePo.soprtestpostglassos"
																						zj="zj" onkeydown="changeFocus(this)"
																						value="${refractivePo.soprtestpostglassos }"
																						class="text_input" size="4"
																						id="enter16" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input zx="zx" type="text" name="refractivePo.soprtestaxesos" value="${refractivePo.soprtestaxesos }" 
																					class="text_input" size="4" id="enter17" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="14"
																						va="va"
																						name="refractivePo.soprtestvaos"
																						value="${refractivePo.soprtestvaos }"
																						class="text_input" size="4" id="enter18" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																		</TR>
																		<tr bgcolor="#CADEE8">
																		<td colspan=8></td>
																		<TD class="PrivateBorderBlue">
																				<div align="center">
																					<img src="${ctx }/img/newbtn/btn_skiascopy_0.png" btn=btn title="检影" onclick="mydriasis()">
																				</div>
																			</TD>
																			
																		</tr>
																	</TBODY>
																</table>
															</fieldset>
															<br>																
															<fieldset>
																<legend>主观屈光</legend>
																<table width="99%" border=0 align=center cellpadding="1" cellspacing="1" class="privateTable" >
																	<tr bgcolor="#CADEE8">
																		<TD class="PrivateBorderBlue" height="25px" colspan="5">
																			
																		</TD>
																		<td width="25%">
																			单眼终点红/绿试验
																		</td>
																		
																		<td width="25%"> 
																			单眼前+1.00D后模糊视力
																		</td>
																	</TR>
																	<TR height="25px" bgcolor="#CADEE8">
																		<TD  class="PrivateBorderBlue" width="10%">
																			&nbsp;
																		</TD>
																		<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue" width="10%">
																			<div align="center">
																				VA
																			</div>
																		</TD>
																		<TD  class="PrivateBorderBlue" width="10%">
																			&nbsp;
																		</TD>
																		<TD  class="PrivateBorderBlue" width="10%">
																			&nbsp;
																		</TD>
																	</TR>
																	<TBODY>
																		<TR bgcolor="#CADEE8">
																			<TD width="11%"	class="PrivateBorderBlue">
																				OD
																			</TD>
																			
																			
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="4"
																						name="refractivePo.soproaballglassod"
																						qj="qj" class="text_input" size="4"
																						onkeydown="changeFocus(this)"
																						value="${refractivePo.soproaballglassod}"
																						id="enter19" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			
																		
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" name="refractivePo.soproapostglassod"
																						zj="zj" onkeydown="changeFocus(this)"
																						value="${refractivePo.soproapostglassod }"
																						class="text_input" size="4" id="enter20" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="7"
																						name="refractivePo.soproaaxesod" zx="zx"
																						value="${refractivePo.soproaaxesod }"
																						class="text_input" size="4" id="enter21" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" 	class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" name="refractivePo.soproavaod" value="${refractivePo.soproavaod }" class="text_input" size="4"
																					va="va" id="enter22" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																			<div align="center">
																					<select jjsgorder="6"
																						name="refractivePo.soprredgreenod" id="enter27" onkeypress="EnterDown(this)" >
																						<option value="" selected="selected">
																						----请选择----																		</option>
																						<option value="红>绿" ${refractivePo.soprredgreenod != "红>绿" ? '' : 'selected="selected"' }>
																							红  > 绿
																						</option>
																						<option value="红=绿" ${refractivePo.soprredgreenod != "红=绿" ? '' : 'selected="selected"' }>
																							红  = 绿
																						</option>
																						<option value="红<绿" ${refractivePo.soprredgreenod != "红<绿" ? '' : 'selected="selected"' }>
																							红  < 绿
																						</option>
																					</select>
																				</div>
																			</TD>
																			<TD width="8%" class="PrivateBorderBlue">
																			<div align="center">
																					<select jjsgorder="6"
																						name="refractivePo.soproneod" id="enter29" onkeypress="EnterDown(this)">
																						<option value="" selected="selected">----请选择----
																						</option>
																						<option value="0.3" ${refractivePo.soproneod != "0.3" ? '' : 'selected="selected"' }>
																							0.3
																						</option>
																						<option value="0.4" ${refractivePo.soproneod != "0.4" ? '' : 'selected="selected"' }>
																							0.4
																						</option>
																						<option value="0.5" ${refractivePo.soproneod != "0.5" ? '' : 'selected="selected"' }>
																							0.5
																						</option>
																						<option value="0.6" ${refractivePo.soproneod != "0.6" ? '' : 'selected="selected"' }>
																							0.6
																						</option>
																						<option value="0.7" ${refractivePo.soproneod != "0.7" ? '' : 'selected="selected"' }>
																							0.7
																						</option>
																						<option value="0.8" ${refractivePo.soproneod != "0.8" ? '' : 'selected="selected"' }>
																							0.8
																						</option>
																					</select>
																				</div>
																			</TD>
																		</TR>
																		<TR bgcolor="#CADEE8">
																			<TD width="11%"
																				class="PrivateBorderBlue">
																				OS
																			</TD>
																			
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" name="refractivePo.soproaballglassos" qj="qj"
																						value="${refractivePo.soproaballglassos }"
																						onkeydown="changeFocus(this)"
																						class="text_input" size="4" id="enter23" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD  class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="11"
																						zj="zj" onkeydown="changeFocus(this)"
																						name="refractivePo.soproapostglassos"
																						value="${refractivePo.soproapostglassos}"
																						class="text_input" size="4" id="enter24" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			
																		
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" name="refractivePo.soproaaxesos" value="${refractivePo.soproaaxesos }" 
																					 zx="zx" class="text_input" size="4" id="enter25" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" yyorder="14"
																						name="refractivePo.soproavaos" va="va"
																						value="${refractivePo.soproavaos }"
																						class="text_input" size="4" id="enter26" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																			<div align="center">
																					<select jjsgorder="6"
																						name="refractivePo.soprredgreenos" id="enter28" onkeypress="EnterDown(this)">
																						<option value="" selected="selected">----请选择----
																						</option>
																						<option value="红>绿" ${refractivePo.soprredgreenos != "红>绿" ? '' : 'selected="selected"' }>
																							红  > 绿
																						</option>
																						<option value="红=绿" ${refractivePo.soprredgreenos != "红=绿" ? '' : 'selected="selected"' } >
																							红  = 绿
																						</option>
																						<option value="红<绿" ${refractivePo.soprredgreenos != "红<绿" ? '' : 'selected="selected"' }>
																							红  < 绿
																						</option>
																					</select>
																				</div>
																			</TD>
																			<TD width="8%" 
																				class="PrivateBorderBlue">
																			<div align="center">
																					<select jjsgorder="6"
																						name="refractivePo.soproneos" id="enter30" onkeypress="EnterDown(this)">
																						<option value="" selected="selected">----请选择----
																						</option>
																						<option value="0.3" ${refractivePo.soproneos != "0.3" ? '' : 'selected="selected"' }>
																							0.3
																						</option>
																						<option value="0.4" ${refractivePo.soproneos != "0.4" ? '' : 'selected="selected"' }>
																							0.4
																						</option>
																						<option value="0.5" ${refractivePo.soproneos != "0.5" ? '' : 'selected="selected"' }>
																							0.5
																						</option>
																						<option value="0.6" ${refractivePo.soproneos != "0.6" ? '' : 'selected="selected"' }>
																							0.6
																						</option>
																						<option value="0.7" ${refractivePo.soproneos != "0.7" ? '' : 'selected="selected"' }>
																							0.7
																						</option>
																						<option value="0.8" ${refractivePo.soproneos != "0.8" ? '' : 'selected="selected"' }>
																							0.8
																						</option>
																					</select>
																				</div>
																			</TD>
																		</TR>
																		<tr  bgcolor="#CADEE8">																		
																			<TD colspan=7 class="PrivateBorderBlue">
																					<div align="center">
																						<img src="${ctx }/img/newbtn/btn_refraction_0.png" btn=btn title="主观屈光" onclick="kgqg()"; >
																					</div>
																			</TD>																			
																		</tr>
																	</TBODY>
																</table>
															</fieldset>
															<br/>
																<fieldset>
																<legend>双眼平衡结果</legend>
																<TABLE width="99%" border=0 align=center cellPadding=1
																	cellSpacing=1 class="privateTable" id="jj"  >
																	<TR style="height: 25px">
																		
																	</TR>
																	<TR style="height: 25px">
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			&nbsp;
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				球镜
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				柱镜
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				轴向
																			</div>
																		</TD>
																		
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				三棱镜
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				基底
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				远用瞳距(mm)
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				近用瞳距(mm)
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">
																				瞳高
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center"> 
																				VA 
																			</div>
																		</TD>
																		<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																			<div align="center">Add<br> 
																				 
																			</div>
																		</TD>
																	</TR>
																	<TBODY>
																		<TR style="height: 25px">
																			<TD width="11%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				OD
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="1" needChange="needChange"
																						qj="qj" name="refractivePo.soprdbalballglassod"
																						value="${refractivePo.soprdbalballglassod }"
																						class="text_input" size="4" onkeydown="changeFocus(this)"
																						id="enter31" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="2" needChange="needChange"
																						zj="zj" name="refractivePo.soprdbalpostglassod"
																						value="${refractivePo.soprdbalpostglassod }"
																						class="text_input" size="4" onkeypress="EnterDown(this)"
																						id="enter32" onkeydown="changeFocus(this)">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="3"
																						name="refractivePo.soprdbalaxesod" zx="zx"
																						value="${refractivePo.soprdbalaxesod }"
																						class="text_input" size="4"
																						id="enter33" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="5"
																						name="refractivePo.soprdbalarriseglassod"
																						ljxj="ljxj"
																						value="${refractivePo.soprdbalarriseglassod }"
																						class="text_input" size="4" id="enter34" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="6%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<select jjsgorder="6"
																						name="refractivePo.soprdbalbasisod" id="enter35" onkeypress="EnterDown(this)">
																						<option value="" selected="selected">
																						----请选择----	
																						</option>
																						<option value="内" ${refractivePo.soprdbalbasisod != "内" ? '' : 'selected="selected"' }>
																							内
																						</option>
																						<option value="外" ${refractivePo.soprdbalbasisod != "外" ? '' : 'selected="selected"' }>
																							外
																						</option>
																						<option value="上" ${refractivePo.soprdbalbasisod != "上" ? '' : 'selected="selected"' }>
																							上
																						</option>
																						<option value="下" ${refractivePo.soprdbalbasisod != "下" ? '' : 'selected="selected"' }>
																							下
																						</option>
																					</select>
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="7"
																						name="refractivePo.soprdbalinterhighod"
																						tongju="tongju"
																						value="${refractivePo.soprdbalinterhighod }"
																						class="text_input" size="4" id="enter36" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="8"
																						name="refractivePo.soprdbalinterdistanceod"
																						tongju="tongju"
																						value="${refractivePo.soprdbalinterdistanceod}"
																						class="text_input" size="4" id="enter37" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="8"
																						name="refractivePo.soprpupilheightod"
																						tongju="tongju"
																						value="${refractivePo.soprpupilheightod}"
																						class="text_input" size="4" id="enter38" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="9"
																						name="refractivePo.soprdbalvaod" va='va' maxlength='20'
																						value="${refractivePo.soprdbalvaod }"
																						class="text_input" size="4" id="enter39"
																						onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="10"
																						name="refractivePo.sopraddod" sph="sph"
																						value="${refractivePo.sopraddod }" onkeydown="changeFocus(this)"
																						class="text_input" size="4" id="enter40" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																		</TR>
																		<TR style="height: 25px">
																			<TD width="11%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				OS
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="11" needChange="needChange"
																						qj="qj" name="refractivePo.soprdbalballglassos"
																						value="${refractivePo.soprdbalballglassos }"
																						class="text_input" size="4" onkeydown="changeFocus(this)"
																						id="enter41" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="12" needChange="needChange"
																						zj="zj" name="refractivePo.soprdbalpostglassos"
																						value="${refractivePo.soprdbalpostglassos }"
																						class="text_input" size="4" onkeydown="changeFocus(this)"
																						id="enter42" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="13"
																						name="refractivePo.soprdbalaxesos" zx="zx"
																						value="${refractivePo.soprdbalaxesos }"
																						class="text_input" size="4" id="enter43"
																						onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="15"
																						name="refractivePo.soprdbalarriseglassos"
																						ljxj="ljxj"
																						value="${refractivePo.soprdbalarriseglassos }"
																						class="text_input" size="4" id="enter44" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<select jjsgorder="16"
																						name="refractivePo.soprdbalbasisos" id="enter45" onkeypress="EnterDown(this)">
																						<option value="" selected="selected">
																						----请选择----	
																						</option>
																						<option value="内" ${refractivePo.soprdbalbasisos != "内" ? '' : 'selected="selected"' }>
																							内
																						</option>
																						<option value="外" ${refractivePo.soprdbalbasisos != "外" ? '' : 'selected="selected"' }>
																							外
																						</option>
																						<option value="上" ${refractivePo.soprdbalbasisos != "上" ? '' : 'selected="selected"' }>
																							上
																						</option>
																						<option value="下" ${refractivePo.soprdbalbasisos != "下" ? '' : 'selected="selected"' }>
																							下
																						</option>
																					</select>
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="17"
																						name="refractivePo.soprdbalinterhighos"
																						tongju="tongju"
																						value="${refractivePo.soprdbalinterhighos }"
																						class="text_input" size="4" id="enter46" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="18"
																						name="refractivePo.soprdbalinterdistanceos"
																						tongju="tongju"
																						value="${refractivePo.soprdbalinterdistanceos }"
																						class="text_input" size="4" id="enter47" onkeypress="EnterDown(this)"> 
																				</div>
																			</TD>
																			<TD width="8%" bgcolor="#CADEE8"
																				class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="8"
																						name="refractivePo.soprpupilheightos"
																						tongju="tongju"
																						value="${refractivePo.soprpupilheightos}"
																						class="text_input" size="4" id="enter48" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="19"
																						name="refractivePo.soprdbalvaos" va='va' maxlength='20'
																						value="${refractivePo.soprdbalvaos }"
																						class="text_input" size="4" id="enter49" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																			<TD bgcolor="#CADEE8" class="PrivateBorderBlue">
																				<div align="center">
																					<input type="text" jjsgorder="20"
																						name="refractivePo.sopraddos" sph="sph"
																						value="${refractivePo.sopraddos }" onkeydown="changeFocus(this)"
																						class="text_input" size="4" id="enter50" onkeypress="EnterDown(this)">
																				</div>
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
																</fieldset>
																<br/>
																<fieldset>
																<TABLE width="99%" border=0 align=center cellPadding=1
																	cellSpacing=1 class="privateTable" id="jj"  >
																	<TR style="height: 25px" align="center">
																		<TD width="99%" align="center"
																			class="PrivateBorderBlue" bgcolor="#CADEE8">
																			   <div>双眼平衡方法
																					<select jjsgorder="16"
																						name="refractivePo.soprdoublebalanceway" id="enter49" onkeypress="EnterDown(this)">
																						<option value="" selected="selected">
																						----请选择----	
																						</option>
																						<option value="棱镜法" ${refractivePo.soprdoublebalanceway != "棱镜法" ? '' : 'selected="selected"' }>
																							棱镜法
																						</option>
																						<option value="偏振片法" ${refractivePo.soprdoublebalanceway != "偏振片法" ? '' : 'selected="selected"' }>
																							偏振片法
																						</option>
																					</select>
																				
																			
																				双眼终点红/绿试验
																					<select jjsgorder="16"
																						name="refractivePo.soprdoublebalancerg" id="enter50" onkeypress="EnterDown(this)">
																						<option value="" selected="selected" >
																						----请选择----	
																						</option>
																						<option value="红>绿" ${refractivePo.soprdoublebalancerg != "红>绿" ? '' : 'selected="selected"' }>
																							红  > 绿
																						</option>
																						<option value="红=绿" ${refractivePo.soprdoublebalancerg != "红=绿" ? '' : 'selected="selected"' }>
																							红  = 绿
																						</option>
																						<option value="红<绿" ${refractivePo.soprdoublebalancerg != "红<绿" ? '' : 'selected="selected"' }>
																							红  < 绿
																						</option>
																					</select>
																				
																			
																				主导眼
																					<select jjsgorder="16" name="refractivePo.soprleadingeye" id="enter51" onkeypress="EnterDown(this)">
																						<option value="" selected="selected">
																						----请选择----	
																						</option>
																						<option value="左" ${refractivePo.soprleadingeye != "左" ? '' : 'selected="selected"' }>
																							左
																						</option>
																						<option value="右" ${refractivePo.soprleadingeye != "右" ? '' : 'selected="selected"' }>
																							右
																						</option>
																						<option value="交替" ${refractivePo.soprleadingeye != "交替" ? '' : 'selected="selected"' }>
																							交替
																						</option>
																						
																					</select>
																					
																				    &nbsp;&nbsp;&nbsp;接诊医师
																					<input type="text" id="soprexaminedoctorName" name="refractivePo.soprexaminedoctorname" value="${refractivePo.soprexaminedoctorname}">
																					<input type="hidden" id="soprexaminedoctorID" name="refractivePo.soprexaminedoctor" value="${refractivePo.soprexaminedoctor}">
																				</div>
																			</td>
																	</TR>
																</TABLE>
															</fieldset>
															<TABLE id=ctl00_PageBody_PostButton cellSpacing=1
																cellPadding=3 width="100%" align=center border=0>
																<TBODY>
																	<TR>
																		<TD align="center">
																			<div align="center">
																				<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" name="button1"  title="保存" onClick="save()">
													                              &nbsp;&nbsp;
													                              <img src="${ctx}/img/newbtn/btn_reset_0.png" btn=btn title="重置" onclick="document.refractiveForm.reset();">
																			</div>
																		</TD>
																	</TR>
																</TBODY>
															</TABLE>
														</TD>
													</TR>
												</tbody>
											</TABLE>
										
											
											<!--ݿEnd-->
										</td>
										<TD width=1 background=${ctx}/img/pic/tab_bg.gif>
												<IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1>
										</TD>
											
									</TR>	</tbody></TABLE></td></tr>											
								<!--ťEnd-->
								<TR>
									<TD width=1 background=${ctx}/img/pic/tab_bg.gif>
									</TD>
								</TR>
			</tbody></TABLE>					
	</form>
</body>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>