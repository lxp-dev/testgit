<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旧镜检查</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		document.getElementById('smecimemberid').focus();  
	});

	function doData(json){
		$('#jdjTable').find("input").val('');
		$('#sophiballod').val(json.sphOD!='null'?parseFloat(json.sphOD).toFixed(2):'0.00');
		$('#sophiballos').val(json.sphOS!='null'?parseFloat(json.sphOS).toFixed(2):'0.00');
		
		$('#sophipostod').val(json.cylOD!='null'?parseFloat(json.cylOD).toFixed(2):'0.00');
		$('#sophipostos').val(json.cylOS!='null'?parseFloat(json.cylOS).toFixed(2):'0.00');
		
		$('#sophiaxesod').val(json.axisOD!='null'?parseFloat(json.axisOD):'0.00');
		$('#sophiaxesos').val(json.axisOS!='null'?parseFloat(json.axisOS):'0.00');
		
		if(parseFloat(json.axisOD))
		
		$('#sophiaddod').val(json.addOD!='null'?parseFloat(json.addOD):'0.00');
		$('#sophiaddos').val(json.addOS!='null'?parseFloat(json.addOS):'0.00');
		$('#sophiinterhighod').val(json.rpd!='null'?parseFloat(json.rpd).toFixed(2):'0.00');
		$('#sophiinterhighos').val(json.lpd!='null'?parseFloat(json.lpd).toFixed(2):'0.00');
		
		if(json.prismOD1!='null'&&json.prismOD1!=null)
		{
			document.getElementById('sophiarriseod').value=parseFloat(json.prismOD1).toFixed(2);
		}
		if(json.prismOS1!='null'&&json.prismOS1!=null)
		{
			document.getElementById('sophiarriseos').value=parseFloat(json.prismOS1).toFixed(2);
		}
		if(json.baseOD1=='I') //根据设备水平垂直对应选择下拉列表的值。I=IN=内 O=OUT=外 D=DOWN=下 U=UP=上
		{
			document.getElementById('sophibasisod').options[1].selected=true;
		}else if(json.baseOD1=='O')
		{
			document.getElementById('sophibasisod').options[2].selected=true;
			
		}
		else if(json.baseOD1=='U')
		{
			document.getElementById('sophibasisod').options[3].selected=true;
		}
		else if(json.baseOD1=='D')
		{
			document.getElementById('sophibasisod').options[4].selected=true;
		}
		
		
		if(json.baseOS1=='I')
		{
			document.getElementById('sophibasisos').options[1].selected=true;
		}else if(json.baseOS1=='O')
		{
			document.getElementById('sophibasisos').options[2].selected=true;
		}
		else if(json.baseOS1=='U')
		{
			document.getElementById('sophibasisos').options[3].selected=true;
		}
		else if(json.baseOS1=='D')
		{
			document.getElementById('sophibasisos').options[4].selected=true;
		}
		$('#readBtn').removeAttr("disabled");
		
	}	
	
	function READ(){
		var type = $('input:radio[name="jdjtype"]:checked').val();
		document.apparatus.strTest(type);
		$('#readBtn').attr("disabled","disabled");
	}
	/**
	 *聚焦
	 */
	function save(){
		if($('[name=customerID]').val()==''){
			alert("请选择顾客！");
			return false;
		}
		if($('input[name=hisInfoPo.sophiballod]').val()==''){
				alert('右眼球镜不能为空!');
				$('input[name=hisInfoPo.sophiballod]').focus();
				return false;
			}
			if($('input[name=hisInfoPo.sophiballos]').val()==''){
				alert('左眼球镜不能为空!');
				$('input[name=hisInfoPo.sophiballos]').focus();
				return false;
			}
			if($('input[name=hisInfoPo.sophipostod]').val()==''){
				$('input[name=hisInfoPo.sophipostod]').val('0.00');
			}
			if($('input[name=hisInfoPo.sophipostos]').val()==''){
				$('input[name=hisInfoPo.sophipostos]').val('0.00');
			}
			if($('[name=hisInfoPo.sophiaxesod]').val()==''){
				$('[name=hisInfoPo.sophiaxesod]').val('0');
			}
			if($('[name=hisInfoPo.sophiaxesos]').val()==''){
				$('[name=hisInfoPo.sophiaxesos]').val('0');
			}
			if($('[name=hisInfoPo.sophiarriseod]').val()!=''){
				if($('[name=hisInfoPo.sophibasisod]').val()==''){
					alert('右眼基底不能为空!');
					return false;
				}
			}
			if($('[name=hisInfoPo.sophiarriseos]').val()!=''){
				if($('[name=hisInfoPo.sophibasisos]').val()==''){
					alert('左眼基底不能为空!');
					return false;
				}
			}
			
			if($('[name=hisInfoPo.sophibasisod]').val()!=''){
				if($('[name=hisInfoPo.sophiarriseod]').val()==''){
					alert('右眼三棱镜不能为空!');
					return false;
				}
			}
			if($('[name=hisInfoPo.sophibasisos]').val()!=''){
				if($('[name=hisInfoPo.sophiarriseos]').val()==''){
					alert('左眼三棱镜不能为空!');
					return false;
				}
			}
			
			
		$("img").removeAttr("onclick");
		printPrescriptionForm.action="oldGlassCheckInsert.action";
		printPrescriptionForm.submit();
	}

	/**
	 *查看
	 */
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
	
	
  
	/**
	 *详情
	 */
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
	
	function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		document.forms[0].submit();
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
	
	//球径柱径
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
		
		if ((!(re1.test(obj.value)))) {
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
	}
	//轴向
	function checkzx(obj) {
		if (obj.value == null || obj.value == '') {
			return ;
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
		
		if ((!(re1.test(obj.value)))) {
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
	
	$(document).ready(function(){		
		inspectionCheck();
	});
	
	
	/**
	 *回车事件
	 */
function selectCust(flag){
    if(flag){
	    $("img").removeAttr("onclick");
		printPrescriptionForm.action = "initOldGlassCheckInsert.action";
		printPrescriptionForm.submit();
    }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			printPrescriptionForm.action = "initOldGlassCheckInsert.action";
			$("img").removeAttr("onclick");
			printPrescriptionForm.submit();
		}
	}
}
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="printPrescriptionForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" value="${customerInfoPo.smecicustomerid}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：旧镜检查</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
					</TBODY></TABLE>
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
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                  
                  <fieldset>
						<legend>顾客资料</legend>
						<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <tr>
					        <td bgcolor="#cadee8">
					        
					          <li class="horizontal">卡号&nbsp;
					                <input type="text" id="smecimemberid" name="customerInfoPo.smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid }" 
					                onkeyup="selectCustomer();" ${ person.bdplinkhisflag == '1' ? 'readonly=readonly':'' }>
					               <input type="hidden" id="smecicustomerid" name="smecicustomerid" class="text_input100" value="${customerInfoPo.smecicustomerid }">
					          </li>
					            <li class="horizontal">
					              <img src="${ctx }/img/newbtn/btn_hybq_0.png" btn=btn his=his title='查找' >
					              <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn name="button22" title='查找'  onclick="selCustomer();" >
					            </li>
					          <li class="horizontal">姓名&nbsp;
					                <input class="text_input60" readOnly="readOnly" value="${customerInfoPo.smeciname }">
					          </li>
					          <li class="horizontal">性别&nbsp;
					                <input value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">年龄&nbsp;
					                <input value="${customerInfoPo.fmmdown }" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">&nbsp;
					          	<c:if test="${empty(customerInfoPo.smeciname) }">
					          	</c:if>
					          	<c:if test="${not empty(customerInfoPo.smeciname) }">
					          		<img src="${ctx }/img/newbtn/btn_details_0.png" btn=btn name="button32" title='详细' onClick="javascript:details('${customerInfoPo.smecicustomerid }');">
					          	</c:if>
					          </li>
					      </tr>
					    </table>
					</fieldset>
                  <br>
                   <fieldset>
                    <legend>旧镜信息</legend>
                      <table width="100%">
                      <TBODY>
                      <tr height="26">
                        <TD width="13%" bgcolor="#DFFFDF" class="PrivateBorderGreen">&nbsp;</TD>
                        <TD width="13%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">球镜</div></TD>
                        <TD width="13%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">柱镜</div></TD>
                        <TD width="13%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">轴向</div></TD>
                        <TD width="12%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">Add</div></TD>
                        <TD width="12%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">三棱镜</div></TD>
                        <TD width="12%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">基底</div></TD>
                        <TD width="12%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">瞳距(mm)</div></TD>
                      </TR>
                        <TR height="26">
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">OD</TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiballod" name="hisInfoPo.sophiballod" qj=qj class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophipostod" name="hisInfoPo.sophipostod" zj=zj class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiaxesod" name="hisInfoPo.sophiaxesod" zx=zx class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiaddod" name="hisInfoPo.sophiaddod" sph=sph class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiarriseod" name="hisInfoPo.sophiarriseod" ljxj=ljxj class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <select id="sophibasisod" name="hisInfoPo.sophibasisod">
                                <option value="">----请选择----</option>
                                <option value="内">内</option>
                                <option value="外">外</option>
                                <option value="上">上</option>
                                <option value="下">下</option>
                              </select>
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiinterhighod" name="hisInfoPo.sophiinterhighod" tongju=tongju value="" class="text_input" size="4">
                          </div></TD>
                        </TR>
                        <TR height="26">
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">OS</TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiballos" name="hisInfoPo.sophiballos" qj=qj class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophipostos" name="hisInfoPo.sophipostos" zj=zj class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiaxesos" name="hisInfoPo.sophiaxesos" zx=zx class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiaddos" name="hisInfoPo.sophiaddos" sph=sph class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiarriseos" name="hisInfoPo.sophiarriseos" ljxj=ljxj class="text_input" size="4" value="">
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <select id="sophibasisos" name="hisInfoPo.sophibasisos">
                                <option value="">----请选择----</option>
                                <option value="内">内</option>
                                <option value="外">外</option>
                                <option value="上">上</option>
                                <option value="下">下</option>
                              </select>
                          </div></TD>
                          <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                              <input id="sophiinterhighos" name="hisInfoPo.sophiinterhighos" tongju=tongju value="" class="text_input" size="4">
                          </div></TD>
                        </TR>
                        </TBODY>
                       </table>
                      </fieldset>
                  <TABLE id="title2" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR height="30">
                          <td width="35%"></td>
                          <TD align="center">
                            <div align="center">
                            <c:if test="${systemParameterPo.fspwhichmachine != '3'}">
                            <li class="horizontal_onlyRight">
                              <input id="jdjtype" name="jdjtype" type='radio' value='0' ${systemParameterPo.fspwhichmachine == '1' ? 'checked':'' } checked>
                              NIDEK
                              &nbsp;&nbsp;
                              <input id="jdjtype" name="jdjtype" type='radio' value='1' ${systemParameterPo.fspwhichmachine == '2' ? 'checked':'' }>
                              TOPCON
                              &nbsp;&nbsp;
                            </li>
                            </c:if>
                            <li class="horizontal_onlyRight">
                            <c:if test="${systemParameterPo.fspwhichmachine != '3'}">
                              <img src="${ctx }/img/newbtn/btn_readjdj_0.png" btn=btn id="readBtn" name="button" title='读取焦度计' onClick="READ()">
                              &nbsp;&nbsp;
                              </c:if>
                              <img src="${ctx }/img/newbtn/btn_save_0.png" btn=btn id="button1" title="保 存" onClick="javascript:save()">
                            </li>  
                              </div></TD></TR>
                      </TBODY>
                    </TABLE>

                  
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
<c:if test="${systemParameterPo.fspwhichmachine != '3'}">
 <div id="appletDiv" >
	<applet codebase='./Apparatus/'
			code='com.pengsheng.main.Apparatus.class'
			archive='Apparatus.jar,comm.jar,log4j.jar,plugin.jar'
			name='apparatus' width='100' height='100'> 
	</applet>
</div> 
</c:if>
<!--     <form id="report" name="report" action="" method="post" target="_blank">-->
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>