<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看双眼视功能检查</title>
</head>
<script>
	
function save(){
	if(checkForm(document.all.doubleEyeFunForm)){    
        $("img").removeAttr("onclick");
		doubleEyeFunForm.action = "insertDoubleEyeFun.action";
		doubleEyeFunForm.submit();
		}
	}

function select(){
		showPopWin("","selectDoubleEyeFun.action?customerID=4028806926a1fa430126a1fb59c60000&optometryBasicID=A00001&optometryID=O20100911",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	
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
	$(this).ready(function(){
		searchButton();
		$('#aca').bind('keyup',function(){
			validate.dotNum($('#aca').get(0))
		});
		
		$('#aca').bind('blur',function(){
			if($('#aca').val() != ''){
				$('#aca').val(parseFloat($('#aca').val()).toFixed(1));
				this.style.backgroundColor="";
			}
		});
		
		
		$('input[id=aadashdajdufsh]').each(function(){
		$(this).bind
		});
		
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
		
		$('#smecimemberid').attr("readOnly","readOnly");
	});
	
//阶梯法事件acaway
function checkWay(){
	if(document.getElementById('acaway').value=='梯度法'){
		document.getElementById('plusOne').disabled=false;
		document.getElementById('minusOne').disabled=false;
	}else{
		document.getElementById('plusOne').disabled=true;
		document.getElementById('minusOne').disabled=true;
		document.getElementById('plusOne').value="";
		document.getElementById('minusOne').value="";
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
	
	function specialCheck(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="selectSpecialCheck.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function refractive(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="initRefractiveSelect.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	
	function inspection(){
		var dontshow = $('#dontshow').val();
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="initInspectionSelect.action?dontshow="+dontshow;
		doubleEyeFunForm.submit();
	}
	//嵌入页查找按钮锁死sxh
	function searchButton(){
		var customerID = document.all.customerID.value;
		if(customerID != null){
			document.getElementById('searchbutton').disabled = 'disabled';
		}
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="doubleEyeFunForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" id="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID" id="optometryBasicID" value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID" id="optometryID" value="${requestScope.optometryID}" /> 
<input type="hidden" name="moduleID" value="${moduleID }"/>
<input type="hidden" id="dontshow" name="dontshow" value="${dontshow }">
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
							  <TR><!--ťStart-->
							    <TD>
							     <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
										<TBODY>
											<TR>
												<TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
													
												  <TD class=tab id=tabLabel__1 
												  onclick="refractive()" 
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
													src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="void(0)" 
												  background=${ctx }/img/pic/tab_active_bg.gif
												  UNSELECTABLE="on">双眼视功能检查</TD>
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
									</TR>
								</TBODY>
							</TABLE>
							</TD>
						</TR>
        <TR>
          <TD bgColor=#ffffff>
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
										<c:if test="${!empty doubleEyeFunPo.sopdeaccount}">
											<td height="30" class="table_body" align="center" >
												双眼视功能未检查原因：
												<c:if test="${doubleEyeFunPo.sopdeaccount == '1'}">年龄过小</c:if>
												<c:if test="${doubleEyeFunPo.sopdeaccount == '2'}">配合不好</c:if>
												<c:if test="${doubleEyeFunPo.sopdeaccount == '3'}">斜视</c:if>
												<c:if test="${doubleEyeFunPo.sopdeaccount == '4'}">弱视</c:if>
												<c:if test="${doubleEyeFunPo.sopdeaccount == '5'}">低视力</c:if>
												<c:if test="${doubleEyeFunPo.sopdeaccount == '6'}">其它</c:if>
											</td>
											</c:if>
									</tr></tbody>
									</table>
									<br>
								<table width="99%" 
                  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
                                    <tr>
                                      <td width="10%" height="30" class="table_body"><div align="right">WORTH 4 DOT 远:</div></td>
                                      <td width="11%" class="table_body"><div align="left">
<!--                                        <input id="farWorth" name="doubleEyeFunPo.sopdefarworth"  readOnly="readOnly" value="${doubleEyeFunPo.sopdefarworth }">-->
                                        <select id="farWorth" name="doubleEyeFunPo.sopdefarworth" disabled="disabled" value="${doubleEyeFunPo.sopdefarworth }">
											<option value="">----请选择----</option>
											<option value="2dots" ${doubleEyeFunPo.sopdefarworth !="2dots" ? '' : 'selected="selected"' }>2dots</option>
											<option value="3dots" ${doubleEyeFunPo.sopdefarworth !="3dots" ? '' : 'selected="selected"' }>3dots</option>
											<option value="4dots" ${doubleEyeFunPo.sopdefarworth !="4dots" ? '' : 'selected="selected"' }>4dots</option>
											<option value="5dots" ${doubleEyeFunPo.sopdefarworth !="5dots" ? '' : 'selected="selected"' }>5dots</option>
                                        </select>
                                      </div></td>
                                      <td width="7%" class="table_body"><div align="right">AC/A：</div></td>
									  <td width="9%" class="table_body">
									   <input id="aca" name="doubleEyeFunPo.sopdeaca" class="text_input60" readOnly="readOnly" value="${doubleEyeFunPo.sopdeaca }">
									  </td>
                                      <td width="7%" class="table_body"><div align="right">方法：</div></td>
                                      <td width="10%" class="table_body">
                                      <select id="acaway" name="doubleEyeFunPo.sopdeacaway" disabled="disabled" value="${doubleEyeFunPo.sopdeacaway }" >
                                        <option value="">----请选择----</option>
										<option value="梯度法" ${doubleEyeFunPo.sopdeacaway!= "梯度法"  ? '' : 'selected="selected"' }>梯度法<%-- 梯度法 --%></option>
										<option value="计算法" ${doubleEyeFunPo.sopdeacaway!= "计算法"  ? '' : 'selected="selected"' }>计算法<%-- 计算法 --%></option>
                                      </select></td>
                                      <td width="7%" class="table_body"><div align="right">+1 </div></td>
                                      <td width="15%" class="table_body">
                                      <input id="plusOne" name="doubleEyeFunPo.sopdepdway" class="text_input60" readOnly="readOnly" value="${doubleEyeFunPo.sopdepdway }">                                      
                                      <select name="doubleEyeFunPo.sopdeacaz1" disabled="disabled">
                                      	<option value="BI" ${doubleEyeFunPo.sopdeacaz1 != 'BI' ? '':'selected=selected'}>BI</option>
                                      	<option value="BO" ${doubleEyeFunPo.sopdeacaz1 != 'BO' ? '':'selected=selected'}>BO</option>
                                      </select>
                                      </td>
                                      <td width="7%" class="table_body"><div align="right">-1 </div></td>
                                      <td width="15%" class="table_body">
                                      <input id="minusOne" name="doubleEyeFunPo.sopdendway" class="text_input60" readOnly="readOnly" value="${doubleEyeFunPo.sopdendway }">                                      
                                      <select name="doubleEyeFunPo.sopdeacaf1" disabled="disabled">
                                      	<option value="BI" ${doubleEyeFunPo.sopdeacaf1 != 'BI' ? '':'selected=selected'}>BI</option>
                                      	<option value="BO" ${doubleEyeFunPo.sopdeacaf1 != 'BO' ? '':'selected=selected'}>BO</option>
                                      </select>
                                      </td>
                                    </tr>
                                  </tbody>
                                </table>
								  <br>
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
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
                                      <input id="validatedotNum"   name="doubleEyeFunPo.sopdefarhetelevel" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefarhetelevel }">
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                        <select id="farHeteLevelIO" name="doubleEyeFunPo.sopdefarhetelevelio" disabled="disabled" value="${doubleEyeFunPo.sopdefarhetelevelio }">
                                          <option value="">----请选择----</option>
										  <option value="I" ${doubleEyeFunPo.sopdefarhetelevelio!= "I"  ? '' : 'selected="selected"' }>BI</option>
										  <option value="O" ${doubleEyeFunPo.sopdefarhetelevelio!= "O"  ? '' : 'selected="selected"' }>BO</option>
                                        </select>
                                      </div></TD>
                                      <TD width="18%" class="table_none"><div align="right">融合功能 水平 ＋ </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                      <input id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelp" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefaramalevelp }">
<!--                                        <input id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelp" class="text_input40" value="">-->
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
<!--                                        <input id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelpo" class="text_input40" value="">-->
                                         <input id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelpo" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefaramalevelpo }">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
<!--                                        <input id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelpt" class="text_input40" value="">-->
                                        <input id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelpt" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefaramalevelpt }">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
<!--                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbu" class="text_input40" value="">-->
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbu" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefaramalbu }">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
<!--                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbuo" class="text_input40" value="">-->
                                         <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbuo" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefaramalbuo }">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
<!--                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramabu" class="text_input40" value="" >-->
                                         <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramabu" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefaramabu }" >
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
<!--                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramabuo" class="text_input40" value="">-->
                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramabuo" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefaramabuo }">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input id="validatedotNum"  name="doubleEyeFunPo.sopdefarheteuprightness" class="text_input40" readOnly="readOnly" value="${doubleEyeFunPo.sopdefarheteuprightness }">
                                        
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select id="farHeteUprightnessUD" name="doubleEyeFunPo.sopdefarheteuprightnessud" value="${doubleEyeFunPo.sopdefarheteuprightnessud }" disabled="disabled">
                                          <option value="">----请选择----</option>
										  <option value="U" ${doubleEyeFunPo.sopdefarheteuprightnessud!= "U"  ? '' : 'selected="selected"' }>BU<%-- 上 --%></option>
										  <option value="D" ${doubleEyeFunPo.sopdefarheteuprightnessud!= "D"  ? '' : 'selected="selected"' }>BD<%-- 下 --%></option>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="right">融合功能 水平 － </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input id="validateLevel" name="doubleEyeFunPo.sopdefaramaleveln" class="text_input40" value="${doubleEyeFunPo.sopdefaramaleveln }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelno" class="text_input40" value="${doubleEyeFunPo.sopdefaramalevelno }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelnt" class="text_input40" value="${doubleEyeFunPo.sopdefaramalevelnt }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbd" class="text_input40" value="${doubleEyeFunPo.sopdefaramalbd }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbdo" class="text_input40" value="${doubleEyeFunPo.sopdefaramalbdo }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramabd" class="text_input40" value="${doubleEyeFunPo.sopdefaramabd }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input id="validatedotNum" name="doubleEyeFunPo.sopdefaramabdo" class="text_input40" value="${doubleEyeFunPo.sopdefaramabdo }" readOnly="readOnly"> 
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
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdeclosehetelevel" class="text_input40" readonly="readonly" value="${doubleEyeFunPo.sopdeclosehetelevel }">
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                          <select id="closeHeteLevelIO" name="doubleEyeFunPo.sopdeclosehetelevelio" value="${doubleEyeFunPo.sopdeclosehetelevelio }" disabled="disabled">
                                            <option value="">----请选择----</option>
											<option value="I" ${doubleEyeFunPo.sopdeclosehetelevelio!= "I"  ? '' : 'selected="selected"' }>BI<%-- 内 --%></option>
											<option value="O" ${doubleEyeFunPo.sopdeclosehetelevelio!= "O"  ? '' : 'selected="selected"' }>BO<%-- 外 --%></option>
                                          </select>
                                      </div></TD>
                                      <TD width="18%" class="table_none"><div align="right">融合功能 水平 ＋ </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelp" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalevelp }" readOnly="readOnly">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelpo" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalevelpo }" readOnly="readOnly">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelpt" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalevelpt }" readOnly="readOnly">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbu" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalbu }" readOnly="readOnly">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbuo" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalbuo }" readOnly="readOnly">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabu" class="text_input40" value="${doubleEyeFunPo.sopdecloseamabu }" readOnly="readOnly">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabuo" class="text_input40" value="${doubleEyeFunPo.sopdecloseamabuo }" readOnly="readOnly">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseheteuprightness" class="text_input40" value="${doubleEyeFunPo.sopdecloseheteuprightness }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <select id="closeHeteUprightnessUD" name="doubleEyeFunPo.sopdecloseheteuprightnessud" value="${doubleEyeFunPo.sopdecloseheteuprightnessud }" disabled="disabled">
                                            <option value="">----请选择----</option>
											<option value="U" ${doubleEyeFunPo.sopdecloseheteuprightnessud!= "U"  ? '' : 'selected="selected"' }>BU<%-- 上 --%></option>
											<option value="D" ${doubleEyeFunPo.sopdecloseheteuprightnessud!= "D"  ? '' : 'selected="selected"' }>BD<%-- 下 --%></option>
                                          </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="right">融合功能 水平 － </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input id="validateLevel" name="doubleEyeFunPo.sopdecloseamaleveln" class="text_input40" value="${doubleEyeFunPo.sopdecloseamaleveln }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelno" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalevelno }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelnt" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalevelnt }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbd" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalbd }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbdo" class="text_input40" value="${doubleEyeFunPo.sopdecloseamalbdo }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabd" class="text_input40" value="${doubleEyeFunPo.sopdecloseamabd }" readOnly="readOnly">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabdo" class="text_input40" value="${doubleEyeFunPo.sopdecloseamabdo }" readOnly="readOnly">
                                      </div></TD>
                                    </TR>
                                    <TR class="table_body">
                                      <TD height="20" colspan="13">不等像视
<INPUT type="radio" name="wu" value="">
无
<INPUT onClick="javascript:changeStatus();" type="radio" name="you" value="">
有
<input  id="difWatch" name="doubleEyeFunPo.sopdedifwatch" class="text_input100" value="${doubleEyeFunPo.sopdedifwatch }" readonly="readonly">

立体视
<INPUT type="radio" value="0" name="doubleEyeFunPo.sopdesolidwatch" value="${doubleEyeFunPo.sopdesolidwatch }" readonly="readonly">
无
<INPUT type="radio" value="1" name="doubleEyeFunPo.sopdesolidwatch" value="${doubleEyeFunPo.sopdesolidwatch }" readonly="readonly">
有 </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td></tr>
							</table>
						<br>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="Privateborder">
                                  <TBODY>
                                  	<tr>
                                      <TD width="14%" class="table_body">近点检查</TD>
                                      <TD width="13%" class="table_none"><div align="right">NPC：                                      </div></TD>
                                      <TD width="15%" class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdenpc" class="text_input100" value="${doubleEyeFunPo.sopdenpc }" readonly="readonly">
                                      </TD>
                                      <TD width="13%" class="table_none"><div align="right">BCC：</div></TD>
                                      <TD width="15%" class="table_none">
                                      <input name="doubleEyeFunPo.sopdebcc" class="text_input100" value="${doubleEyeFunPo.sopdebcc}" disabled="disabled">
                                      </TD>
                                      <TD width="13%" class="table_none"><div align="right">辅辏近点： </div></TD>
                                      <TD width="15%" class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdefacility" class="text_input100" value="${doubleEyeFunPo.sopdefacility }" readonly="readonly">
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">调节幅度</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdeaccod" class="text_input100" value="${doubleEyeFunPo.sopdeaccod }" readonly="readonly">
                                      </TD>
                                      <TD class="table_none"><div align="right">OS： </div></TD>
                                      <TD class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdeaccos" class="text_input100" value="${doubleEyeFunPo.sopdeaccos }" readonly="readonly">
                                      </TD>
                                      <TD class="table_none"><div align="right">OU：</div></TD>
                                      <TD class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdeaccou" class="text_input100" value="${doubleEyeFunPo.sopdeaccou }" readonly="readonly">
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">正/负相对调节</TD>
                                      <TD class="table_none"><div align="right">PRA：</div></TD>
                                      <TD class="table_none">
                                     	<input id="positiveAccPRA" class="text_input100" name="doubleEyeFunPo.sopdepositiveaccpra" mysel="mysel" value="${doubleEyeFunPo.sopdepositiveaccpra }" disabled="disabled">
									 </TD>
                                      <TD class="table_none"><div align="right">NRA：</div></TD>
                                      <TD colspan="3" class="table_none">
                                      <input id="negativeAccNRA" class="text_input100" name="doubleEyeFunPo.sopdenegativeaccnra" mysel="mysel" value="${doubleEyeFunPo.sopdenegativeaccnra }" disabled="disabled">
                                      <div align="right"></div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">调节灵敏度</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdefacilityod" class="text_input100" value="${doubleEyeFunPo.sopdefacilityod }" readonly="readonly">
                                      </TD>
                                      <TD class="table_none"><div align="right">OS： </div></TD>
                                      <TD class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdefacilityos" class="text_input100" value="${doubleEyeFunPo.sopdefacilityos }" readonly="readonly">
                                      </TD>
                                      <TD class="table_none"><div align="right">OU：</div></TD>
                                      <TD class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdefacilityou" class="text_input100" value="${doubleEyeFunPo.sopdefacilityou }" readonly="readonly">
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">Add</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none">
                                      <select id="addOD" name="doubleEyeFunPo.sopdeaddod" mysel="mysel" valus="${doubleEyeFunPo.sopdeaddod }" disabled="disabled">
											<option value="">----请选择----</option>
											<option value="0" ${doubleEyeFunPo.sopdeaddod!= "0"  ? '' : 'selected="selected"' }>0</option>
											<option value="+0.25" ${doubleEyeFunPo.sopdeaddod!= "+0.25"  ? '' : 'selected="selected"' }>+0.25</option>
											<option value="+0.50" ${doubleEyeFunPo.sopdeaddod!= "+0.50"  ? '' : 'selected="selected"' }>+0.50</option>
											<option value="+0.75" ${doubleEyeFunPo.sopdeaddod!= "+0.75"  ? '' : 'selected="selected"' }>+0.75</option>
											<option value="+1.00" ${doubleEyeFunPo.sopdeaddod!= "+1.00"  ? '' : 'selected="selected"' }>+1.00</option>
											<option value="+1.25" ${doubleEyeFunPo.sopdeaddod!= "+1.25"  ? '' : 'selected="selected"' }>+1.25</option>
											<option value="+1.50" ${doubleEyeFunPo.sopdeaddod!= "+1.50"  ? '' : 'selected="selected"' }>+1.50</option>
											<option value="+1.75" ${doubleEyeFunPo.sopdeaddod!= "+1.75"  ? '' : 'selected="selected"' }>+1.75</option>
											<option value="+2.00" ${doubleEyeFunPo.sopdeaddod!= "+2.00"  ? '' : 'selected="selected"' }>+2.00</option>
											<option value="+2.25" ${doubleEyeFunPo.sopdeaddod!= "+2.25"  ? '' : 'selected="selected"' }>+2.25</option>
											<option value="+2.50" ${doubleEyeFunPo.sopdeaddod!= "+2.50"  ? '' : 'selected="selected"' }>+2.50</option>
											<option value="+2.75" ${doubleEyeFunPo.sopdeaddod!= "+2.75"  ? '' : 'selected="selected"' }>+2.75</option>
											<option value="+3.00" ${doubleEyeFunPo.sopdeaddod!= "+3.00"  ? '' : 'selected="selected"' }>+3.00</option>
											<option value="+3.50" ${doubleEyeFunPo.sopdeaddod!= "+3.50"  ? '' : 'selected="selected"' }>+3.50</option>
											<option value="+4.00" ${doubleEyeFunPo.sopdeaddod!= "+4.00"  ? '' : 'selected="selected"' }>+4.00</option>
										</select>
									  </TD>
                                      <TD class="table_none"><div align="right">OS：</div></TD>
                                      <TD colspan="3" class="table_none">
											<select id="addOS" name="doubleEyeFunPo.sopdeaddos" mysel="mysel" onkeydown="elementKeydown($('temp2'));" value="${doubleEyeFunPo.sopdeaddos }" disabled="disabled">
												<option value="">----请选择----</option>
												<option value="0" ${doubleEyeFunPo.sopdeaddos!= "0"  ? '' : 'selected="selected"' }>0</option>
												<option value="+0.25" ${doubleEyeFunPo.sopdeaddos!= "+0.25"  ? '' : 'selected="selected"' }>+0.25</option>
												<option value="+0.50" ${doubleEyeFunPo.sopdeaddos!= "+0.50"  ? '' : 'selected="selected"' }>+0.50</option>
												<option value="+0.75" ${doubleEyeFunPo.sopdeaddos!= "+0.75"  ? '' : 'selected="selected"' }>+0.75</option>
												<option value="+1.00" ${doubleEyeFunPo.sopdeaddos!= "+1.00"  ? '' : 'selected="selected"' }>+1.00</option>
												<option value="+1.25" ${doubleEyeFunPo.sopdeaddos!= "+1.25"  ? '' : 'selected="selected"' }>+1.25</option>
												<option value="+1.50" ${doubleEyeFunPo.sopdeaddos!= "+1.50"  ? '' : 'selected="selected"' }>+1.50</option>
												<option value="+1.75" ${doubleEyeFunPo.sopdeaddos!= "+1.75"  ? '' : 'selected="selected"' }>+1.75</option>
												<option value="+2.00" ${doubleEyeFunPo.sopdeaddos!= "+2.00"  ? '' : 'selected="selected"' }>+2.00</option>
												<option value="+2.25" ${doubleEyeFunPo.sopdeaddos!= "+2.25"  ? '' : 'selected="selected"' }>+2.25</option>
												<option value="+2.50" ${doubleEyeFunPo.sopdeaddos!= "+2.50"  ? '' : 'selected="selected"' }>+2.50</option>
												<option value="+2.75" ${doubleEyeFunPo.sopdeaddos!= "+2.75"  ? '' : 'selected="selected"' }>+2.75</option>
												<option value="+3.00" ${doubleEyeFunPo.sopdeaddos!= "+3.00"  ? '' : 'selected="selected"' }>+3.00</option>
												<option value="+3.50" ${doubleEyeFunPo.sopdeaddos!= "+3.50"  ? '' : 'selected="selected"' }>+3.50</option>
												<option value="+4.00" ${doubleEyeFunPo.sopdeaddos!= "+4.00"  ? '' : 'selected="selected"' }>+4.00</option>
											</select>
                                      <div align="right"></div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">工作距离</TD>
                                      <TD colspan="6" class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopdedistance" class="text_input100" value="${doubleEyeFunPo.sopdedistance }" readonly="readonly">
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">范围</TD>
                                      <TD colspan="6" class="table_none">
                                      <input id="validatedotNum" name="doubleEyeFunPo.sopderange" class="text_input100" readOnly="readOnly" value="${doubleEyeFunPo.sopderange }">
                                      	  至
                                      <input id="validatedotNum"  name="doubleEyeFunPo.sopderangeo" class="text_input100" readOnly="readOnly" value="${doubleEyeFunPo.sopderangeo }">
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">视觉功能诊断</TD>
                                      <TD class="table_none" colspan="6">&nbsp;AC/A值&nbsp;
                                      <select moveorder="44" id="" name="doubleEyeFunPo.sopdeacaz" mysel="mysel" disabled="disabled">
											<option value="">----请选择----</option>
											<option value="正常" ${doubleEyeFunPo.sopdeacaz!= "正常"  ? '' : 'selected="selected"' }>正常</option>
											<option value="超高" ${doubleEyeFunPo.sopdeacaz!= "超高"  ? '' : 'selected="selected"' }>超高</option>
											<option value="超低" ${doubleEyeFunPo.sopdeacaz!= "超低"  ? '' : 'selected="selected"' }>超低</option>
										</select> &nbsp;&nbsp;                                      
									    <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopdexieshi!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopdexieshi"  value="1">&nbsp;斜视
									    <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopderuoshi!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopderuoshi"  value="1">&nbsp;弱视
									    <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopdequguangbuzheng!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopdequguangbuzheng"  value="1">&nbsp;屈光不正
									    <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopdefeixieshixingshuangyanshiyichang!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopdefeixieshixingshuangyanshiyichang"  value="1">&nbsp;非斜视性双眼视异常
									    </TD>
                                    </TR>
                                    <TR class="table_body">
                                      <TD class="table_body">屈光矫正方案</TD>
                                      <TD class="table_none" colspan="6">
                                      <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopdekuangjiayanjing!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopdekuangjiayanjing" value="1"> 框架眼镜 
									  <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopdeyinxingyanjing!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopdeyinxingyanjing" value="1"> 隐形眼镜 &nbsp; 
									  </TD>
                                    </TR>
                                    <tr class="table_body">
                                    <td class="table_body">视觉训练</td>
                                    <td class="table_none" colspan="6">
									    <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopderuoshixunlian!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopderuoshixunlian" value="1"> 弱视训练 
									    <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopdetiaojiexunlian!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopdetiaojiexunlian" value="1"> 调节训练 
									    <input disabled="disabled" type="checkbox" ${doubleEyeFunPo.sopdefucouxunlian!= "1"  ? '' : 'checked="checked"' }  moveorder="53" name="doubleEyeFunPo.sopdefucouxunlian" value="1"> 辐辏训练  
                                    </td>
                                    </tr>
                                  </TBODY>
                                </TABLE>
                                </td>
							  </tr>
							</table>
						</fieldset>	
                  </TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>













