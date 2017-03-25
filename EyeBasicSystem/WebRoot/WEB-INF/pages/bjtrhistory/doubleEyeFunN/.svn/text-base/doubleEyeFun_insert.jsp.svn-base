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
			document.getElementById('sopdeaccount').readOnly = true;
			document.getElementById('sopdeaccount').disabled=true;
			document.getElementById('sopdeaccount').value ="";		
	}
	
	function none() {
			document.getElementById('sopdeaccount').readOnly = false;
			document.getElementById('sopdeaccount').disabled=false;
	}

	function save(){	
		if(document.getElementById('radio02').checked==true&&document.getElementById('radio02').value=="0"){			
			var arrayObj = new Array();　//创建一个待判断参数数组
			arrayObj = new Array("sopdecoverod","sopdecoveros","sopdesumdot","sopdefarworth","sopdefarhetelevel","sopdefarhetelevelio","sopdefarheteuprightness","sopdefarheteuprightnessud","sopdeclosehetelevel","sopdeclosehetelevelio","sopdecloseheteuprightness","sopdecloseheteuprightnessud","sopdetestbig","sopdetestbigio","sopdetestsmall","sopdetestsmallio","sopdeaca","sopdepositiveaccpra","sopdepositiveaccpraod","sopdepositiveaccpraos","sopdenegativeaccnra","sopdenegativeaccnraod","sopdenegativeaccnraos","sopdetwosidespec","sopdetwosidetest","sopdebcc","sopdefacilityou","sopdefacilityod","sopdefacilityos","sopdeaccou","sopdeaccod","sopdeaccos");　//赋值
			for (i = 0; i < arrayObj.length; i++)
		    {
		        if(document.getElementById(arrayObj[i]).value =="" )
				{
		        	document.getElementById(arrayObj[i]).focus();
					alert("请填写完整的双眼视功能检查信息！");
					return ;
				}		        
		    }			
		}else{
			if(document.getElementById('sopdeaccount').value=="")
			{
				alert("请填写未双眼视功能检查原因！");
				document.getElementById('sopdeaccount').focus();
				return ;
			}
		}
    
		if(checkForm(document.all.doubleEyeFunForm)){    
	        $("img").removeAttr("onclick");
	        $('#eyefunflag').val($('input[name=radio02]:checked').val());
			doubleEyeFunForm.action = "insertDoubleEyeFunBjtr.action";
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
	
	function refractive(){
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="refractiveToolBjtr.action?source=refractiveiou";
		doubleEyeFunForm.submit();
	}
	function contactGlass(){
		doubleEyeFunForm.action="contactGlassToolBjtr.action?source=contactGlassiou";
		$("img").removeAttr("onclick");
		doubleEyeFunForm.submit();
	}
	function inspection(){
	/*
		if('${isDoubleEyeFun}' != '1'){
			alert("在进行检查结论之前，请先进行视功能检查！");
			return;
		}
		*/
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="inspectionToolBjtr.action?source=inspectioniou";
		doubleEyeFunForm.submit();
	}
	function specialCheck(){
		$("img").removeAttr("onclick");
		doubleEyeFunForm.action="specialCheckToolBjtr.action?source=specialcheckiou";
		doubleEyeFunForm.submit();
	}
	
	function glassHistory(){
	    $("img").removeAttr("onclick");
		doubleEyeFunForm.action="selectGlassesHistoryBjtr.action?customerID="+'${customerInfoPo.smecicustomerid }';
		doubleEyeFunForm.submit();
	}
	
	function cornealContactlLens(){
		$("img").removeAttr("onclick");
		$('#eyefunflag').val($('input[name=radio02]:checked').val());
		doubleEyeFunForm.action="cornealContactlLensToolBjtr.action?source=cornealContactlLensu";
		doubleEyeFunForm.submit();
	}

	function clean(){
		document.doubleEyeFunForm.reset();
		chageOne();
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
<input type="hidden" id="eyefunflag" name="eyefunflag" value=""/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
						<TBODY>
						<TR><!--ťStart-->
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx }/img/pic/tab_top_bg.gif>
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
												  UNSELECTABLE="on">相关检查</TD>
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
							<s:action name="initCustomerOptometryTitleBjtr" executeResult="true" />	
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
											
											<select id="sopdeaccount" name="doubleEyeFunPo.sopdeaccount" readonly="readonly" disabled="disabled" myinput="myinput">
	                                          <option value="" selected></option>
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='29'}">
			                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdeaccount == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                      </c:if>	                                      	
		                                      </c:forEach>
		                                    </select>
										</td>
								</tbody>		
								</tr>
								</table>
								<br/>
								<fieldset style="border-color:#FF0000">
								<legend >必录项</legend>
								<table width="99%" 
                  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
                                    <tr>
                                      <td width="10%" height="30" class="table_body"><div align="center">交替遮盖试验</div></td>
                                      <td width="11%" class="table_none"><div align="left">
                                          <select moveorder="1" id="sopdecoverod" name="doubleEyeFunPo.sopdecoverod" mysel="mysel">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='30'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdecoverod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>&nbsp;<font color="red">*</font>
                                      </div></td>
                                      <td width="10%" height="30" class="table_body"><div align="right">遮去遮试验</div></td>
                                      <td width="11%" class="table_none"><div align="left">
                                          <select moveorder="2" id="sopdecoveros" name="doubleEyeFunPo.sopdecoveros" mysel="mysel">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='30'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdecoveros == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>&nbsp;<font color="red">*</font>
                                      </div></td>
                                      <td width="10%" height="30" class="table_none"><div align="right">集合近点：</div></td>
                                      <td width="11%" class="table_none"><div align="left">
                                          <input  moveorder="3" id="sopdesumdot" name="doubleEyeFunPo.sopdesumdot" class="text_input60" value="${doubleEyeFunPo.sopdesumdot }">&nbsp;<font color="red">*</font>
                                      </div></td>
                                      <td width="15%" height="30" class="table_none"><div align="right">WORTH 4 DOT 远:</div></td>
                                      <td width="11%" class="table_none"><div align="left">
                                          <select moveorder="4" id="sopdefarworth" name="doubleEyeFunPo.sopdefarworth" mysel="mysel">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='31'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdefarworth == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>
                                        &nbsp;<font color="red">*</font>
                                      </div></td>
									  </td>				
                                    </tr>
                                  </tbody>
                                </table>
								  <br>
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="15%" rowspan="2" class="table_body" align="center">远：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="14%" class="table_none"><div align="center">
                                        <input id="sopdefarhetelevel" moveorder="5"  name="doubleEyeFunPo.sopdefarhetelevel" class="text_input40" value="${doubleEyeFunPo.sopdefarhetelevel }">&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                        <select moveorder="6" id="sopdefarhetelevelio" name="doubleEyeFunPo.sopdefarhetelevelio">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdefarhetelevelio == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="15%" rowspan="2" class="table_body">近：隐斜</TD>
                                      <TD width="8%" class="table_none"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                          <input moveorder="9" id="sopdeclosehetelevel" name="doubleEyeFunPo.sopdeclosehetelevel" class="text_input40" value="${doubleEyeFunPo.sopdeclosehetelevel }">&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                        <select moveorder="10" id="sopdeclosehetelevelio" name="doubleEyeFunPo.sopdeclosehetelevelio">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdeclosehetelevelio == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>&nbsp;<font color="red">*</font>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="7" id="sopdefarheteuprightness"  name="doubleEyeFunPo.sopdefarheteuprightness" class="text_input40" value="${doubleEyeFunPo.sopdefarheteuprightness }">&nbsp;&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select moveorder="8" id="sopdefarheteuprightnessud" name="doubleEyeFunPo.sopdefarheteuprightnessud">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='33'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdefarheteuprightnessud == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD class="table_none"><div align="right">垂直</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="11" id="sopdecloseheteuprightness" name="doubleEyeFunPo.sopdecloseheteuprightness" class="text_input40" value="">&nbsp;&nbsp;&nbsp;
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select moveorder="12" id="sopdecloseheteuprightnessud" name="doubleEyeFunPo.sopdecloseheteuprightnessud">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='33'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdecloseheteuprightnessud == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>&nbsp;<font color="red">*</font>
                                      </div></TD>
                                    </TR>
                                    <tr>
                                    	<td height="5"></td>
                                    </tr>
                                    <TR>
                                      <TD width="15%" class="table_body" align="center">测试</TD>
                                      <TD width="8%" class="table_none"><div align="right">+1</div></TD>
                                      <TD width="10%" class="table_none"><div align="center">
                                        <input id="sopdetestbig" moveorder="13"  name="doubleEyeFunPo.sopdetestbig" class="text_input40" value="${doubleEyeFunPo.sopdetestbig }">&nbsp;<font color="red">*</font>
                                      	<select moveorder="14" id="sopdetestbigio" name="doubleEyeFunPo.sopdetestbigio">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdetestbigio == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="8%" class="table_none"><div align="right">-1</div></TD>
                                      <TD width="13%" class="table_none"><div align="center">
                                      	<input moveorder="15" id="sopdetestsmall" name="doubleEyeFunPo.sopdetestsmall" class="text_input40" value="${doubleEyeFunPo.sopdetestsmall }">&nbsp;<font color="red">*</font>
                                        <select moveorder="16" id="sopdetestsmallio" name="doubleEyeFunPo.sopdetestsmallio">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='32'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdetestsmallio == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
	                                    </select>&nbsp;<font color="red">*</font>
                                      </div></TD>
                                      <TD width="15%" class="table_none">AC/A：</TD>
                                      <TD width="8%" class="table_none" colspan="2"><input moveorder="17" id="sopdeaca" name="doubleEyeFunPo.sopdeaca" class="text_input60" value="${doubleEyeFunPo.sopdeaca }">&nbsp;<font color="red">*</font></TD>
                                    </TR>
                                    <TR class="table_body" height="30">
                                    	<TD width="13%" class="table_body"><div align="center">立体视</div></TD>
                                    	<TD width="15%" class="table_none" colspan="7">
										<INPUT type="radio" value="0" name="doubleEyeFunPo.sopdesolidwatch" checked="checked" ${doubleEyeFunPo.sopdesolidwatch !="0" ? '' : 'checked="checked"' }>
										无
										<INPUT type="radio" value="1" name="doubleEyeFunPo.sopdesolidwatch" ${doubleEyeFunPo.sopdesolidwatch !="1" ? '' : 'checked="checked"' }>
										有&nbsp;<font color="red">*</font>
									  </TD>
                                    </TR>
                                    <tr>
                                    	<td height="5"></td>
                                    </tr>
                                    <TR>
                                      	<TD class="table_body" rowspan="2" align="center">正/负相对调节</TD>
                                      	<TD class="table_none"><div align="right">PRA：&nbsp;&nbsp;OU</div></TD>
                                      	<TD class="table_none">
	                                     	<input moveorder="18" class="text_input100" qj=qj id="sopdepositiveaccpra" name="doubleEyeFunPo.sopdepositiveaccpra" value="${doubleEyeFunPo.sopdepositiveaccpra }" mysel="mysel">
	                                     	<font color="red">*</font>
									 	</TD>
									 	<TD class="table_none"><div align="right">OD</div></TD>
                                      	<TD class="table_none">
	                                     	<input moveorder="19" class="text_input100" qj=qj id="sopdepositiveaccpraod" name="doubleEyeFunPo.sopdepositiveaccpraod" value="${doubleEyeFunPo.sopdepositiveaccpraod }" mysel="mysel">
	                                     	<font color="red">*</font>
									 	</TD>
									 	<TD class="table_none"><div align="right">OS</div></TD>
                                      	<TD class="table_none" colspan="2">
	                                     	<input moveorder="20" class="text_input100" qj=qj id="sopdepositiveaccpraos" name="doubleEyeFunPo.sopdepositiveaccpraos" value="${doubleEyeFunPo.sopdepositiveaccpraos }" mysel="mysel">
	                                     	<font color="red">*</font>
									 	</TD>
									</tr>
									<TR>
                                      <TD class="table_none"><div align="right">NRA：&nbsp;&nbsp;OU</div></TD>
                                      <TD class="table_none">
                                      	<input moveorder="21" class="text_input100" qj=qj id="sopdenegativeaccnra" name="doubleEyeFunPo.sopdenegativeaccnra" value="${doubleEyeFunPo.sopdenegativeaccnra }" mysel="mysel"/>
                                      	<font color="red">*</font>
                                      </TD>
                                      <TD class="table_none"><div align="right">OD</div></TD>
                                      	<TD class="table_none">
	                                     	<input moveorder="22" class="text_input100" qj=qj id="sopdenegativeaccnraod" name="doubleEyeFunPo.sopdenegativeaccnraod" value="${doubleEyeFunPo.sopdenegativeaccnraod }" mysel="mysel">
	                                     	<font color="red">*</font>
									 	</TD>
									 	<TD class="table_none"><div align="right">OS</div></TD>
                                      	<TD class="table_none"  colspan="2">
	                                     	<input moveorder="23" class="text_input100" qj=qj id="sopdenegativeaccnraos" name="doubleEyeFunPo.sopdenegativeaccnraos" value="${doubleEyeFunPo.sopdenegativeaccnraos }" mysel="mysel">
	                                     	<font color="red">*</font>
									 	</TD>
                                    </TR>
                                    <tr>
                                    	<td height="5"></td>
                                    </tr>
                                    <TR height="26px">
                                      <TD class="table_body" align="center">调节灵敏度</TD>
                                      <TD class="table_none" colspan="7">
	                                      <div align="left">
	                                      	&nbsp;
	                                      	双面镜度数：
	                                      	<select id="sopdetwosidespec" moveorder="24" name="doubleEyeFunPo.sopdetwosidespec" mysel="mysel">
	                                          <option value="" selected></option>
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='34'}">
			                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdetwosidespec == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                      </c:if>
		                                      </c:forEach>
		                                    </select>
											&nbsp;<font color="red">*</font>
											视标：
											<select id="sopdetwosidetest" moveorder="25" name="doubleEyeFunPo.sopdetwosidetest" mysel="mysel">
	                                          <option value="" selected></option>
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='35'}">
			                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdetwosidetest == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                      </c:if>	                                      	
		                                      </c:forEach>
		                                    </select>&nbsp;<font color="red">*</font>
	                                      </div>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body" width="15%" align="center">近点检查</TD>
                                      <TD class="table_none" width="8%"><div align="right">NPC</div></TD>
                                      <TD class="table_none" width="14%"><input moveorder="26" id="validatedotNum" name="doubleEyeFunPo.sopdenpc" class="text_input100" value=""></TD>
                                      <TD class="table_none" width="13%"><div align="right">BCC</div></TD>
                                      <TD class="table_none" width="15%" colspan="4">
                                            <input moveorder="27" class="text_input100" qj=qj id="sopdebcc" name="doubleEyeFunPo.sopdebcc" value="${doubleEyeFunPo.sopdebcc }" mysel="mysel">
                                      		&nbsp;<font color="red">*</font></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body" align="center">辅辏近点</TD>
                                      <TD class="table_none"><div align="right">OU</div></TD>
                                      <TD class="table_none"><input moveorder="28" id="sopdefacilityou" name="doubleEyeFunPo.sopdefacilityou" class="text_input100" value="">&nbsp;<font color="red">*</font></TD>
                                      <TD class="table_none"><div align="right">OD</div></TD>
                                      <TD class="table_none"><input moveorder="29" id="sopdefacilityod" name="doubleEyeFunPo.sopdefacilityod" class="text_input100" value="">&nbsp;<font color="red">*</font></TD>
                                      <TD class="table_none"><div align="right">OS </div></TD>
                                      <TD class="table_none" colspan="2"><input moveorder="30" id="sopdefacilityos" name="doubleEyeFunPo.sopdefacilityos" class="text_input100" value="">&nbsp;<font color="red">*</font></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body" width="15%" align="center">调节幅度</TD>
                                      <TD class="table_none" width="8%"><div align="right">OU</div></TD>
                                      <TD class="table_none" width="14%"><input moveorder="31" id="sopdeaccou" name="doubleEyeFunPo.sopdeaccou" class="text_input100" value="">&nbsp;<font color="red">*</font></TD>
                                      <TD class="table_none" width="13%"><div align="right">OD</div></TD>
                                      <TD class="table_none" width="15%"><input moveorder="32" id="sopdeaccod" name="doubleEyeFunPo.sopdeaccod" class="text_input100" value="">&nbsp;<font color="red">*</font></TD>
                                      <TD class="table_none" width="15%"><div align="right">OS</div></TD>
                                      <TD class="table_none" colspan="2"><input moveorder="33" id="sopdeaccos" name="doubleEyeFunPo.sopdeaccos" class="text_input100" value="">&nbsp;<font color="red">*</font></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
								<br/>
								</fieldset>
								<br/>
								<fieldset style="border-color: #33FFFF">
								<legend>可选项</legend>
								<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                  	<TR>
                                      <TD class="table_body" align="center">Add</TD>
                                      <TD class="table_none"><div align="right">OD：</div></TD>
                                      <TD class="table_none">
                                      <select id="addOD" moveorder="34" name="doubleEyeFunPo.sopdeaddod" mysel="mysel">
                                         <option value="" selected></option>
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      <c:if test="${optionParamPoTmp.fopparentid=='36'}">
	                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdeaddod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
	                                      </c:if>	                                      	
                                         </c:forEach>
                                      </select>
									  </TD>
                                      <TD class="table_none"><div align="right">OS：</div></TD>
                                      <TD colspan="2" class="table_none">
										<select moveorder="35" id="addOS" name="doubleEyeFunPo.sopdeaddos" mysel="mysel">
                                         <option value="" selected></option>										
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      <c:if test="${optionParamPoTmp.fopparentid=='36'}">
	                                      	<option value="${optionParamPoTmp.fopparamid }" ${(doubleEyeFunPo.sopdeaddos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
	                                      </c:if>
                                         </c:forEach>
                                      </select>
                                      </TD>
                                      <td  class="table_none" colspan="6">
                                      	不等像视
										<INPUT  type="radio" name="doubleEyeFunPo.sopdeequalwatch" value="0" checked="checked" ${doubleEyeFunPo.sopdeequalwatch == "0" ? 'checked="checked"' : '' } onclick="javascript:chageOne();" >
										无
										<INPUT  type="radio" name="doubleEyeFunPo.sopdeequalwatch" value="1" ${doubleEyeFunPo.sopdeequalwatch == "1" ? 'checked="checked"' : '' } onclick="javascript:chageOne();">
										有
										<input moveorder="36"  id="difWatch" name="doubleEyeFunPo.sopdedifwatch" class="text_input100" value="" readonly="readonly">
									  </td>
                                    </TR>
                                    <TR>
                                      <TD colspan="8" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="11%" rowspan="2" class="table_body" align="center">远：融像</TD>
                                      <TD width="5%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="right">&nbsp;&mdash; </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="37" id="validateLevel" name="doubleEyeFunPo.sopdefaramaleveln" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="38" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelno" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="39" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelnt" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                        <input moveorder="43" id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbu" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input  moveorder="44" id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbuo" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="47" id="validatedotNum" name="doubleEyeFunPo.sopdefaramabu" class="text_input40" value="" >
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="48" id="validatedotNum" name="doubleEyeFunPo.sopdefaramabuo" class="text_input40" value="">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">&nbsp;＋</div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="40" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelp" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="41" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelpo" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                        <input moveorder="42" id="validateLevel" name="doubleEyeFunPo.sopdefaramalevelpt" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input  moveorder="45" id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbd" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="46" id="validatedotNum" name="doubleEyeFunPo.sopdefaramalbdo" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="49" id="validatedotNum" name="doubleEyeFunPo.sopdefaramabd" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input moveorder="50" id="validatedotNum" name="doubleEyeFunPo.sopdefaramabdo" class="text_input40" value="">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="8" bgcolor="#FFFFFF" class="Privateborder">&nbsp;</TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">R 注视</div></TD>
                                      <TD colspan="2" bgcolor="#FFFFFF" class="Privateborder"><div align="center">L 注视</div></TD>
                                    </TR>
                                    <TR>
                                      <TD rowspan="2" class="table_body" align="center">近：融像</TD>
                                      <TD width="5%" class="table_none" rowspan="2"><div align="right">水平</div></TD>
                                      <TD width="10%" class="table_none"><div align="right">&nbsp;&mdash; </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="51" id="validateLevel" name="doubleEyeFunPo.sopdecloseamaleveln" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="52" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelno" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="53" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelnt" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="8%" class="table_none" rowspan="2"><div align="right">垂直</div></TD>
                                      <TD width="6%" class="table_none"><div align="right">BU</div></TD>
                                      <TD width="5%" class="table_none"><div align="center">
                                          <input moveorder="57" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbu" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="58" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbuo" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="61" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabu" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="62" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabuo" class="text_input40" value="">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_none"><div align="right">&nbsp;＋ </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="54" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelp" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="55" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelpo" class="text_input40" value="">
                                      </div></TD>
                                      <TD width="6%" class="table_none"><div align="center">
                                          <input moveorder="56" id="validateLevel" name="doubleEyeFunPo.sopdecloseamalevelpt" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="right">BD</div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="59" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbd" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="60" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamalbdo" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="63" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabd" class="text_input40" value="">
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <input moveorder="64" id="validatedotNum" name="doubleEyeFunPo.sopdecloseamabdo" class="text_input40" value="">
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
							<br>
						</fieldset>	
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" name="button1"  title="保存" onClick="save()">
                              &nbsp;&nbsp;
                              <img src="${ctx}/img/newbtn/btn_reset_0.png" btn=btn title="重置" onclick="clean();">
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
</HTML>