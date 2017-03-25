<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增双眼视功能检查</title>
</head>
<script>
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
	
	function move1(){ //近用回车一动
		$(':input[moveorder1]').each(function(){
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('moveorder1');
						$(':input[moveorder1='+accAdd(index,1)+']').focus();
						if(index==5){
							$('input[moveorder=1]').focus();
						}	
					}
				});
			});
	}
	
function block() {
		document.getElementById('txtAccount').readOnly = true;
		document.getElementById('txtAccount').disabled=true;
		document.getElementById('txtAccount').value ="";		
}
function none() {
		document.getElementById('txtAccount').readOnly = false;
		document.getElementById('txtAccount').disabled=false;
}

function save(){	
	if(document.getElementById('radio02').checked==true&&document.getElementById('radio02').value=="0")
	{	
		if(document.getElementsByName('doubleEyeFunPo.sopdefarworth')[0].value =="" )
		{
			document.getElementsByName('doubleEyeFunPo.sopdefarworth')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
		
		if(document.getElementsByName('doubleEyeFunPo.sopdeaca')[0].value =="" )
		{
			document.getElementsByName('doubleEyeFunPo.sopdeaca')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
		
		if(document.getElementsByName('doubleEyeFunPo.sopdeacaway')[0].value =="" )
		{
			document.getElementsByName('doubleEyeFunPo.sopdeacaway')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
		
		if(document.getElementsByName('doubleEyeFunPo.sopdeacaway')[0].value =="梯度法" )
		{
			if(document.getElementsByName('doubleEyeFunPo.sopdepdway')[0].value =="" )
			{
				document.getElementsByName('doubleEyeFunPo.sopdepdway')[0].focus();
				alert("请填写完整的双眼视功能检查信息！");
				return ;
			}
		
		    if(document.getElementsByName('doubleEyeFunPo.sopdendway')[0].value =="" )
			{
				document.getElementsByName('doubleEyeFunPo.sopdendway')[0].focus();
				alert("请填写完整的双眼视功能检查信息！");
				return;
			}
		}
		
			
		
		if(document.getElementsByName('doubleEyeFunPo.sopdefarhetelevel')[0].value =="" )
		{
			document.getElementsByName('doubleEyeFunPo.sopdefarhetelevel')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
		
		if(document.getElementsByName('doubleEyeFunPo.sopdefarhetelevelio')[0].value =="" )
		{
			
			if(document.getElementsByName('doubleEyeFunPo.sopdefarhetelevel')[0].value =="0.00"){
			
			}else{
				document.getElementsByName('doubleEyeFunPo.sopdefarhetelevelio')[0].focus();
				alert("请填写完整的双眼视功能检查信息！");
				return ;
			}
			
		}
		
		if(document.getElementsByName('doubleEyeFunPo.sopdeclosehetelevel')[0].value =="" )
		{
			document.getElementsByName('doubleEyeFunPo.sopdeclosehetelevel')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
		
		if(document.getElementsByName('doubleEyeFunPo.sopdeclosehetelevelio')[0].value =="" )
		{	
			if(document.getElementsByName('doubleEyeFunPo.sopdeclosehetelevel')[0].value=="0.00"){
				
			}
			else{
				document.getElementsByName('doubleEyeFunPo.sopdeclosehetelevelio')[0].focus();
				alert("请填写完整的双眼视功能检查信息！");
				return ;
			}
		}
		
		var mySel = document.getElementsByName('doubleEyeFunPo.sopdesolidwatch');
		
		var type = 0;
		
		for(var i=0;i<mySel.length;i++) 
		{ 
			var me=mySel[i].value; 
			if(mySel[i].checked) 
			{ 
				type = type + 1;
			} 
		} 

		if(type > 0){
		}else{
		
			document.getElementsByName('doubleEyeFunPo.sopdesolidwatch')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
		
		
		if(document.getElementsByName('doubleEyeFunPo.sopdebcc')[0].value =="" )
		{
			document.getElementsByName('doubleEyeFunPo.sopdebcc')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
		
		if(document.getElementsByName('doubleEyeFunPo.sopdepositiveaccpra')[0].value =="" )
		{
			document.getElementsByName('doubleEyeFunPo.sopdepositiveaccpra')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
		
		if(document.getElementsByName('doubleEyeFunPo.sopdenegativeaccnra')[0].value =="" )
		{
			document.getElementsByName('doubleEyeFunPo.sopdenegativeaccnra')[0].focus();
			alert("请填写完整的双眼视功能检查信息！");
			return ;
		}
	
	}
	else
	{
		if(document.getElementById('txtAccount').value=="")
		{
			alert("请填写未双眼视功能检查原因！");
			document.getElementById('txtAccount').focus();
			return ;
		}
	}
	
    
	if(checkForm(document.all.doubleEyeFunForm)){    
        $("img").removeAttr("onclick");
        $('#eyefunflag').val($('input[name=radio02]:checked').val());
		doubleEyeFunForm.action = "insertDoubleEyeFun.action";
		doubleEyeFunForm.submit();
		}
	}

	var validate={
		num : function(obj){	
			var	valueO = obj.value;
			obj.value = obj.value.replace(/^[^1-9][0-9]*/g,'');
		},
		dotNum : function(obj){
			obj.value = obj.value.replace(/[^0-9.][0-9]*/g,'');
		}, 
		bcc : function(obj){
			obj.value = obj.value.replace(/[^-0-9.][0-9]*/g,'');
		},
		level : function(obj){
			if(/^[\+\-]/.test(obj.value)){
				obj.value = obj.value.substring(0,1) + obj.value.replace(/[^0-9]/g,'');
			}else{
				obj.value = obj.value.replace(/[^0-9]/g,'');
			}
			//obj.value = obj.value.replace(/^[^\+-]|[^\d]*$/,'');
		}
	};
	//嵌入页查找按钮锁死sxh
	function searchButton(){
		var customerID = document.all.customerID.value;
		if(customerID != null){
			document.getElementById('searchbutton').disabled = 'disabled';
		}
	}
	$(document).ready(function(){
		searchButton();
		//$('#farWorth').focus();
		$('#aca').bind('keyup',function(){
			validate.dotNum($('#aca').get(0))
		});
		
		$('#aca').bind('blur',function(){
			if($('#aca').val() != ''){
				$('#aca').val(parseFloat($('#aca').val()).toFixed(1));
				this.style.backgroundColor="";
			}
		});
		
		
		$('input[id=validatedotNum]').each(function(){
			($(this).get(0)).maxLength='7';
			$(this).bind('keyup',function(){
				validate.dotNum($(this).get(0));
			});
			
		});
		
		$('input[id=validatedotNum]').each(function(){
			$(this).bind('blur',function(){
			if($(this).val()!=''){
					$(this).val(parseFloat($(this).val()).toFixed(2));
					}
			});
		});
		
		
		$('input[id=validateLevel]').each(function(){
			($(this).get(0)).maxLength='7';
			$(this).bind('keyup',function(){
				validate.dotNum($(this).get(0));
			});
		});
		
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
		
		move();move1();
		
		$('#smecimemberid').attr("readOnly","readOnly");
		
		$('input[qj=qj]').each(function(){
			$(this).bind("blur",function(){
				checkqj(this);
			});
		});
	});
	
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
		
		if ((!(re1.test(obj.value)))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			$(obj).val(parseFloat($(obj).val()).toFixed(2));
		}
	}
	
	//阶梯法事件acaway
	function checkWay(){
		if(document.getElementById('acaway').value=='梯度法'){
			$('input[toway=toway]').each(function(){
				$(this).removeAttr("readonly");
			});
		}else{
			$('input[toway=toway]').each(function(){
				$(this).val('');
				$(this).attr("readonly","readonly");
				
			});
		}
	}

function chageOne(){
	if(document.getElementById('difWatch').readOnly){
		document.getElementById('difWatch').readOnly=false;
		
	}else{
		document.getElementById('difWatch').readOnly=true;
		document.getElementById('difWatch').value="";
	}
}
	
	function refractive(){
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="refractiveTool.action?source=refractiveiou";
		doubleEyeFunForm.submit();
	}
	function inspection(){
		if('${systemParameterPo.fspinspectionvisuelle}'=='1'){
			if('${isDoubleEyeFun}' != '1'){
				alert("在进行检查结论之前，请先进行视功能检查！");
				return;
			}
		}
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="inspectionTool.action?source=inspectioniou";
		doubleEyeFunForm.submit();
	}
	function specialCheck(){
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="specialCheckTool.action?source=specialcheckiou";
		doubleEyeFunForm.submit();
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
<form name="doubleEyeFunForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID"  value="${requestScope.optometryID}" />  
<input type="hidden" name="oldOptometryID"  value="${requestScope.oldOptometryID}" />  
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" />  
<input type="hidden" name="moduleID" value="${moduleID }"/>
<input type="hidden" id="customerReadonly" value="${moduleID }"/>
<input type="hidden" id="eyefunflag" name="eyefunflag" value=""/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
			<TR>
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx }/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR>
							  <td>
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
								</td>
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
												  <TD width=3><IMG id=tabImgLeft__0 height=22 
													src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx }/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">双眼视功能检查</TD>
												  <TD width=3><IMG id=tabImgRight__0 height=22 
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
												  onclick="specialCheck();" 
												  background=${ctx }/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">特殊功能检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
							<s:action name="initCustomerOptometryTitle" executeResult="true" />	
						<br>
						<fieldset>
							<legend>双眼视功能检查</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td>
								<table  width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
									 <tbody>
									<tr class="trBlue">
											<td  height="30" class="table_body" align="center" >
												双眼视功能检查:
												是<input id="radio02" name="radio02" type="radio" value="0" checked="checked"  onclick="block()"/>&nbsp;
												否<input id="radio02" name="radio02" type="radio" value="1" onclick="none()"/>
												&nbsp;原因：&nbsp;
												
												<select id="txtAccount" name="doubleEyeFunPo.sopdeaccount" readonly="readonly" disabled="disabled" myinput="myinput">
													<option value="">----请选择----</option>
													<option value="1">年龄过小</option>
													<option value="2">配合不好</option>
													<option value="3">斜视</option>
													<option value="4">弱视</option>
													<option value="5">低视力</option>
													<option value="6">其它</option>
												</select>
											</td>
									</tbody>		
									</tr>
									</table>
									<br />						
								 
								<table width="99%" 
                  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
                                    <tr>
                                      <td width="10%" height="30" class="table_body"><div align="right">WORTH 4 DOT 远:</div></td>
                                      <td width="11%" class="table_body"><div align="left">
                                          <select moveorder1="1" id="farWorth" name="doubleEyeFunPo.sopdefarworth" mysel="mysel">
											<option value="">----请选择----</option>
											<option value="2dots">2dots</option>
											<option value="3dots">3dots</option>
											<option value="4dots">4dots</option>
											<option value="5dots">5dots</option>
                                        </select>&nbsp;<font color="red">*</font>
                                      </div></td>
                                      <td width="7%" class="table_body"><div align="right">AC/A：</div></td>
									  <td width="10%" class="table_body">
									    <input moveorder1="2" id="aca" name="doubleEyeFunPo.sopdeaca" class="text_input60" >&nbsp;<font color="red">*</font>
									  </td>
                                      <td width="7%" class="table_body"><div align="right">方法：</div></td>
                                      <td width="9%" class="table_body">
                                      <select moveorder1="3" id="acaway" name="doubleEyeFunPo.sopdeacaway"  onChange="checkWay()">
                                        <option value="">----请选择----</option>
										<option value="梯度法">梯度法<%-- 梯度法 --%></option>
										<option value="计算法">计算法<%-- 计算法 --%></option>
                                      </select>&nbsp;<font color="red">*</font></td>
                                      <td width="7%" class="table_body"><div align="right">+1 </div></td>
                                      <td width="15%" class="table_body">
                                      <input toway="toway" readonly="readonly" moveorder1="4" id="plusOne" name="doubleEyeFunPo.sopdepdway" class="text_input60" value=""> 
                                      <select name="doubleEyeFunPo.sopdeacaz1">
                                      	<option value="BI">BI</option>
                                      	<option value="BO">BO</option>
                                      </select>&nbsp;<font color="red">*</font>                                     
                                      </td>
                                      <td width="7%" class="table_body"><div align="right">-1 </div></td>
                                      <td width="15%" class="table_body">
                                      <input toway="toway" readonly="readonly"  moveorder1="5" id="minusOne" name="doubleEyeFunPo.sopdendway" class="text_input60" value="">                                      
                                      <select name="doubleEyeFunPo.sopdeacaf1">
                                      	<option value="BI">BI</option>
                                      	<option value="BO">BO</option>
                                      </select>&nbsp;<font color="red">*</font>
                                      </td>
                                    </tr>
                                  </tbody>
                                </table>
								  <br>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
								  <TR>
                                    <TD height="20" colspan="13" class="table_body">双眼测试</TD>
							      </TR>
                                  <TBODY>
                                    <TR>
                                      <TD colspan="9" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="11%" rowspan="2" class="table_body">远：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                        <input id="validatedotNum" moveorder="1"  name="doubleEyeFunPo.sopdefarhetelevel" class="text_input40" value="">&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                        <select moveorder="2" id="farHeteLevelIO" name="doubleEyeFunPo.sopdefarhetelevelio">
                                          <option value="">----请选择----</option>
										  <option value="I">BI</option>
										  <option value="O">BO</option>
                                        </select>&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="18%" class="table_none"><div align="right">融合功能 水平 ＋ </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="5" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelp" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="6" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelpo" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="7" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelpt" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                        <input moveorder="11" id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbu" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input  moveorder="12" id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbuo" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="13" id="validatedotNum" name="doubleEyeFunPo.sopdefaramabu" class="text_input40" value="" >
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="14" id="validatedotNum" name="doubleEyeFunPo.sopdefaramabuo" class="text_input40" value="">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="3" id="validatedotNum"  name="doubleEyeFunPo.sopdefarheteuprightness" class="text_input40" value="">&nbsp;&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select moveorder="4" id="farHeteUprightnessUD"name="doubleEyeFunPo.sopdefarheteuprightnessud">
                                          <option value="">----请选择----</option>
										  <option value="U">BU<%-- 上 --%></option>
										  <option value="D">BD<%-- 下 --%></option>
                                        </select>&nbsp;&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="right">融合功能 水平 － </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="8" id="validateLevel" name="doubleEyeFunPo.sopdefaramaleveln" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="9" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelno" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="10" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelnt" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input  moveorder="15" id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbd" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="16" id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbdo" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="17" id="validatedotNum" name="doubleEyeFunPo.sopdefaramabd" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="18" id="validatedotNum" name="doubleEyeFunPo.sopdefaramabdo" class="text_input40" value="">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="9" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD rowspan="2" class="table_body">近：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                          <input moveorder="19" id="validatedotNum" name="doubleEyeFunPo.sopdeclosehetelevel" class="text_input40" value="">&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                          <select moveorder="20" id="closeHeteLevelIO" name="doubleEyeFunPo.sopdeclosehetelevelio">
                                            <option value="">----请选择----</option>
											<option value="I">BI<%-- 内 --%></option>
											<option value="O">BO<%-- 外 --%></option>
                                          </select>&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="18%" class="table_none"><div align="right">融合功能 水平 ＋ </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="23" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelp" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="24" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelpo" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="25" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelpt" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                          <input moveorder="29" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbu" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="30" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbuo" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="31" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabu" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="32" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabuo" class="text_input40" value="">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="21" id="validatedotNum" name="doubleEyeFunPo.sopdecloseheteuprightness" class="text_input40" value="">&nbsp;&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <select moveorder="22" id="closeHeteUprightnessUD" name="doubleEyeFunPo.sopdecloseheteuprightnessud">
                                            <option value="">----请选择----</option>
											<option value="U">BU<%-- 上 --%></option>
											<option value="D">BD<%-- 下 --%></option>
                                          </select>&nbsp;&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="right">融合功能 水平 － </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="26" id="validateLevel" name="doubleEyeFunPo.sopdecloseamaleveln" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="27" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelno" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="28" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelnt" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="33" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbd" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="34" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbdo" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="35" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabd" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="36" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabdo" class="text_input40" value="">
                                      </div></TD>
                                    </TR>
                                    <TR class="table_body" height="30">
                                      <TD height="20" colspan="13">不等像视
										<INPUT  type="radio" name="yw" value="0" onclick="javascript:chageOne();" >
										无
										<INPUT  type="radio" name="yw" value="1" onclick="javascript:chageOne();">
										有
										<input moveorder="37"  id="difWatch" name="doubleEyeFunPo.sopdedifwatch" class="text_input100" value="" readonly="readonly">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										立体视
										<INPUT type="radio" value="0" name="doubleEyeFunPo.sopdesolidwatch">
										无
										<INPUT type="radio" value="1" name="doubleEyeFunPo.sopdesolidwatch">
										有&nbsp;<font color="red">*</font>
									  </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td></tr>
							</table>
						<br>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="Privateborder">
                                  <TBODY>
                                      <TD width="14%" class="table_body">近点检查</TD>
                                      <TD width="13%" class="table_none"><div align="right">NPC：                                      </div></TD>
                                      <TD width="15%" class="table_none"><input moveorder="38" id="validatedotNum" name="doubleEyeFunPo.sopdenpc" class="text_input100" value=""></TD>
                                      <TD width="13%" class="table_none"><div align="right">BCC：</div></TD>
                                      <TD width="15%" class="table_none">
                                      <input moveorder="39" class="text_input100" qj=qj name="doubleEyeFunPo.sopdebcc">&nbsp;<font color="red">*</font>
                                      </TD>
                                      <TD width="13%" class="table_none"><div align="right">辅辏近点： </div></TD>
                                      <TD width="15%" class="table_none"><input moveorder="40" id="validatedotNum" name="doubleEyeFunPo.sopdefacility" class="text_input100" value=""></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">调节幅度</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none"><input moveorder="41" id="validatedotNum" name="doubleEyeFunPo.sopdeaccod" class="text_input100" value=""></TD>
                                      <TD class="table_none"><div align="right">OS： </div></TD>
                                      <TD class="table_none"><input moveorder="42" id="validatedotNum" name="doubleEyeFunPo.sopdeaccos" class="text_input100" value=""></TD>
                                      <TD class="table_none"><div align="right">OU：</div></TD>
                                      <TD class="table_none"><input moveorder="43" id="validatedotNum" name="doubleEyeFunPo.sopdeaccou" class="text_input100" value=""></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">正/负相对调节</TD>
                                      <TD class="table_none"><div align="right">PRA：</div></TD>
                                      <TD class="table_none">
                                     	<input moveorder="44" class="text_input100" qj=qj id="positiveAccPRA" name="doubleEyeFunPo.sopdepositiveaccpra" mysel="mysel">
                                     	<font color="red">*</font>
									 </TD>
                                      <TD class="table_none"><div align="right">NRA：</div></TD>
                                      <TD colspan="3" class="table_none">
                                      	<input moveorder="45" class="text_input100" qj=qj id="negativeAccNRA" name="doubleEyeFunPo.sopdenegativeaccnra" mysel="mysel"/>
                                      	<font color="red">*</font></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">调节灵敏度</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none"><input moveorder="46" id="validatedotNum" name="doubleEyeFunPo.sopdefacilityod" class="text_input100" value=""></TD>
                                      <TD class="table_none"><div align="right">OS： </div></TD>
                                      <TD class="table_none"><input moveorder="47" id="validatedotNum" name="doubleEyeFunPo.sopdefacilityos" class="text_input100" value=""></TD>
                                      <TD class="table_none"><div align="right">OU：</div></TD>
                                      <TD class="table_none"><input moveorder="48" id="validatedotNum" name="doubleEyeFunPo. sopdefacilityou" class="text_input100" value=""></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">Add</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none">
                                      <select id="addOD" moveorder="49" name="doubleEyeFunPo.sopdeaddod" mysel="mysel">
											<option value="">----请选择----</option>
											<option value="0">0</option>
											<option value="+0.25">+0.25</option>
											<option value="+0.50">+0.50</option>
											<option value="+0.75">+0.75</option>
											<option value="+1.00">+1.00</option>
											<option value="+1.25">+1.25</option>
											<option value="+1.50">+1.50</option>
											<option value="+1.75">+1.75</option>
											<option value="+2.00">+2.00</option>
											<option value="+2.25">+2.25</option>
											<option value="+2.50">+2.50</option>
											<option value="+2.75">+2.75</option>
											<option value="+3.00">+3.00</option>
											<option value="+3.50">+3.50</option>
											<option value="+4.00">+4.00</option>
										</select>
									  </TD>
                                      <TD class="table_none"><div align="right">OS：</div></TD>
                                      <TD colspan="3" class="table_none">
											<select moveorder="50" id="addOS" name="doubleEyeFunPo.sopdeaddos" mysel="mysel">
												<option value="">----请选择----</option>
												<option value="0">0</option>
												<option value="+0.25">+0.25</option>
												<option value="+0.50">+0.50</option>
												<option value="+0.75">+0.75</option>
												<option value="+1.00">+1.00</option>
												<option value="+1.25">+1.25</option>
												<option value="+1.50">+1.50</option>
												<option value="+1.75">+1.75</option>
												<option value="+2.00">+2.00</option>
												<option value="+2.25">+2.25</option>
												<option value="+2.50">+2.50</option>
												<option value="+2.75">+2.75</option>
												<option value="+3.00">+3.00</option>
												<option value="+3.50">+3.50</option>
												<option value="+4.00">+4.00</option>
											</select>
                                      <div align="right"></div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">工作距离</TD>
                                      <TD colspan="6"  class="table_none"><input moveorder="51" id="validatedotNum" name="doubleEyeFunPo.sopdedistance" class="text_input100" value=""></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">范围</TD>
                                      <TD colspan="6"  class="table_none"><input moveorder="52" id="validatedotNum" name="doubleEyeFunPo.sopderange" class="text_input100" value="">
                                       	 至
                                      <input id="validatedotNum"  moveorder="53" name="doubleEyeFunPo.sopderangeo" class="text_input100" value=""></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">视觉功能诊断</TD>
                                      <TD class="table_none" colspan="6">&nbsp;AC/A值&nbsp;
                                      <select moveorder="44" id="" name="doubleEyeFunPo.sopdeacaz" mysel="mysel">
											<option value="">----请选择----</option>
											<option value="正常" ${doubleEyeFunPo.sopdeacaz!= "正常"  ? '' : 'selected="selected"' }>正常</option>
											<option value="超高" ${doubleEyeFunPo.sopdeacaz!= "超高"  ? '' : 'selected="selected"' }>超高</option>
											<option value="超低" ${doubleEyeFunPo.sopdeacaz!= "超低"  ? '' : 'selected="selected"' }>超低</option>
										</select> &nbsp;&nbsp;                                      
									    <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopdexieshi"  value="1">&nbsp;斜视
									    <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopderuoshi"  value="1">&nbsp;弱视
									    <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopdequguangbuzheng"  value="1">&nbsp;屈光不正
									    <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopdefeixieshixingshuangyanshiyichang"  value="1">&nbsp;非斜视性双眼视异常
									    </TD>
                                    </TR>
                                    <TR class="table_body">
                                      <TD class="table_body">屈光矫正方案</TD>
                                      <TD class="table_none" colspan="6">
                                      <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopdekuangjiayanjing" value="1"> 框架眼镜 
									  <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopdeyinxingyanjing" value="1"> 隐形眼镜 &nbsp; 
									  </TD>
                                    </TR>
                                    <tr class="table_body">
                                    <td class="table_body">视觉训练</td>
                                    <td class="table_none" colspan="6">
									    <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopderuoshixunlian" value="1"> 弱视训练 
									    <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopdetiaojiexunlian" value="1"> 调节训练 
									    <input type="checkbox" id=""  moveorder="53" name="doubleEyeFunPo.sopdefucouxunlian" value="1"> 辐辏训练  
                                    </td>
                                    </tr>
                                    
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
                              <img src="${ctx}/img/newbtn/btn_reset_0.png" btn=btn title="重置" onclick="document.doubleEyeFunForm.reset();">
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY>
    <script type="text/javascript">
    </script>
    
    </HTML>













