<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="setmeal_top.jsp" %>
<%@ include file="setmeal_top2.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐维护</title>
</head>
<script>

$(document).ready(function() {
	$('#ssmsmsourcebgnAmount').val('');
	$('#ssmsmsourceendAmount').val('');
	$('#ssmsmendbgnAmount').val('');
	$('input[name=setMealPo.ssmsmexpensespendup]').val('0.00');
});

function changeClassif(){
    
    $("img").removeAttr("onclick");
   if ($('#ssmsmform').val() == '2'){        	
    	return;
    }
    
   if ($('#ssmsmform').val() == '1'){
    	setMealFrm.action="fromGoodsFullReductionToBillReduction.action"; 
    }
    setMealFrm.submit();
 }

function fromBillSpecialToGoodsSpecial(){
	
    $("img").removeAttr("onclick");
	setMealFrm.action="fromBillSpecialToGoodsSpecial.action"; 
	setMealFrm.submit();
}

function salesbillamount(){

	var ssmsmexpensespendup = document.getElementsByName("setMealPo.ssmsmexpensespendup");
	var ssmsmexpensespendul = document.getElementsByName("setMealPo.ssmsmexpensespendul");

    if ($.trim(ssmsmexpensespendup[0].value) == '' && $.trim(ssmsmexpensespendul[0].value) == ''){
        alert("请填写整单消费满区间!");
        ssmsmexpensespendup[0].focus();
        return true;
    }
    if ($.trim(ssmsmexpensespendup[0].value) != '' && $.trim(ssmsmexpensespendul[0].value) != '' && Number($.trim(ssmsmexpensespendup[0].value)) > Number($.trim(ssmsmexpensespendul[0].value))){
        alert("整单消费满区间填写有误,请重新填写!");
        ssmsmexpensespendul[0].focus();
        return true;
    }

    return false;
	
}

function favorableBillForm(obj){
    
	if (obj.value == '22'){
		$('input[name=setMealPo.ssmsmsalesbillamount]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$('input[name=setMealPo.ssmsmdiscountrate]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$('input[name=setMealPo.ssmsmexpenseamount]:eq(0)').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
    }
	if (obj.value == '23'){
		$('input[name=setMealPo.ssmsmsalesbillamount]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$('input[name=setMealPo.ssmsmdiscountrate]:eq(0)').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$('input[name=setMealPo.ssmsmexpenseamount]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }
	if (obj.value == '24'){
		$('input[name=setMealPo.ssmsmsalesbillamount]:eq(0)').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$('input[name=setMealPo.ssmsmdiscountrate]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$('input[name=setMealPo.ssmsmexpenseamount]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }	
	if (obj.value == ''){
		$('input[name=setMealPo.ssmsmsalesbillamount]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$('input[name=setMealPo.ssmsmdiscountrate]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$('input[name=setMealPo.ssmsmexpenseamount]:eq(0)').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }
    
	$('input[name=setMealPo.ssmsmsalesbillamount]:eq(0)').val('');
	$('input[name=setMealPo.ssmsmexpenseamount]:eq(0)').val('');
	$('input[name=setMealPo.ssmsmdiscountrate]:eq(0)').val('');
}

function goodsCount(){
	return false;
}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="setMealFrm" name="setMealFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="indexs" name="indexs">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
          </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
							<TD width="9%" height="26" class="table_body">套餐标题</TD>
			            	<TD width="30%" class="table_none">
			            	<input clean="clean" class="text_input200" id="ssmsmtitle" name="setMealPo.ssmsmtitle" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请先填写套餐标题！'}]" value="${setMealPo.ssmsmtitle }">
			            	&nbsp;<span class="STYLE1">*&nbsp;(内容不超过50字)</span></TD>
			            	<TD width="9%" height="26" class="table_body">套餐日期</TD>
			            	<TD width="30%" class="table_none">
			            	  ${createDate }<input type="hidden" class="text_input200" id="createdate" name="setMealPo.ssmsmcreatedate" value="${createDate}" maxlength="20" readonly="readonly">
			                </TD>
			              <TD width="9%" height="26" class="table_body">套餐形式</TD>
			              <TD width="30%" class="table_none">
                 	    
                      	    <input id="x151" name='x151form' type="radio" ${(setMealPo.ssmsmform eq '1' || empty(setMealPo.ssmsmform) || setMealPo.ssmsmform eq '') ? 'checked="checked"' : '' } value="1" onclick="javascript:$('#ssmsmform').val('1');changeClassif();">多种优惠方式
                            <input id="x161" name='x151form' type="radio" ${setMealPo.ssmsmform eq '2' ? 'checked="checked"' : '' } value="2" onclick="javascript:$('#ssmsmform').val('2');changeClassif();">单一优惠方式
                            &nbsp;<span class="STYLE1">*</span>
                            <input type="hidden" id="ssmsmform" name="setMealPo.ssmsmform" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取套餐形式！'}]" value="${(setMealPo.ssmsmform eq '1' || empty(setMealPo.ssmsmform) || setMealPo.ssmsmform eq '') ? '1' : '2' }">
			              </TD>
			             
			            </TR>
			            <TR>
			              <TD height="26" class="table_body">生效日期</TD>
			              <TD class="table_none">
			              <input id="ssmsmcreatedate" clean="clean" 
					       name="setMealPo.ssmsmeffectivedate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'createdate\')}',maxDate:'#F{$dp.$D(\'ssmsmenddate\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择套餐生效日期！'}]" 
					       value="${setMealPo.ssmsmeffectivedate }"/>&nbsp;<span class="STYLE1">*</span>
			              </TD>
           				  <TD height="26" class="table_body">截止日期</TD>
                        	<TD height="26" class="table_none" >
                        	<input id="ssmsmenddate" clean="clean"
					       name="setMealPo.ssmsmenddate" 
					       type="text" class="text_input100" value="${setMealPo.ssmsmenddate}" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssmsmcreatedate\') || $dp.$D(\'createdate\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择套餐截止日期！'}]" 
					       />&nbsp;<span class="STYLE1">*</span>
                        	</TD>
                        	<TD height="26" class="table_body">套餐分类</TD>
                        	<TD height="26" class="table_none" >
                        	<select clean="clean" id="ssmsmclassify" name="setMealPo.ssmsmclassify" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择套餐分类！'}]" onchange="changeClassif2()">
							    <option value="" ${setMealPo.ssmsmclassify eq '' ? 'selected="selected"' : '' }>----请选择----</option>
				                <option value="1" ${setMealPo.ssmsmclassify eq '1' ? 'selected="selected"' : '' }>框镜销售</option>
				                <option value="3" ${setMealPo.ssmsmclassify eq '3' ? 'selected="selected"' : '' }>隐形销售</option>
				                <option value="5" ${setMealPo.ssmsmclassify eq '5' ? 'selected="selected"' : '' }>辅料销售</option>
                      	    </select>&nbsp;<span class="STYLE1">*</span>                      	  
                      	  </TD>
			            </TR>
			            <TR>
			              <TD height="26" class="table_body">套餐价格区间</TD>
			              <TD class="table_none">
                             <input type="text" readonly="readonly" class="text_input120 noneInput" id="ssmsmsourcebgnAmount" name="setMealPo.ssmsmsourcebgnAmount" value="${setMealPo.ssmsmsourcebgnAmount }">至<input type="text" readonly="readonly" class="text_input120 noneInput" id="ssmsmsourceendAmount" name="setMealPo.ssmsmsourceendAmount" value="${setMealPo.ssmsmsourceendAmount }">
			              </TD>
           				  <TD height="26" class="table_body">套餐金额</TD>
                          <TD height="26" class="table_none">
                        	 <input type="text" readonly="readonly" class="text_input100 noneInput" id="ssmsmendbgnAmount" name="setMealPo.ssmsmendbgnAmount" value="${setMealPo.ssmsmendbgnAmount}">
                          </TD> 
                          <TD height="26" class="table_body"><span id="isyxjf">允许累计积分</span>&nbsp;</TD>
							<TD class="table_none">
							  <span id="yxljjj">
                                 <input id="x150" name='setMealPo.ssmsmintegralsum' type="radio" ${(setMealPo.ssmsmintegralsum eq '1' || empty(setMealPo.ssmsmintegralsum) || setMealPo.ssmsmintegralsum eq '') ? 'checked="checked"' : '' } value="1" >允许
                                 <input id="x160" name='setMealPo.ssmsmintegralsum' type="radio" ${setMealPo.ssmsmintegralsum eq '2' ? 'checked="checked"' : '' } value="2" >不允许
                                 &nbsp;<span class="STYLE1">*</span>
	                          </span>&nbsp;
                             </TD>                       	
			            </TR>
			            <TR>
                          <TD height="26" class="table_body"><span id="isyxlj">允许累加</span>&nbsp;</TD>
						  <TD class="table_none">
							  <span id="yxljxx">
							  <input id="x15" name='setMealPo.ssmsmissum' type="radio" ${(setMealPo.ssmsmissum eq '1' || empty(setMealPo.ssmsmissum) || setMealPo.ssmsmissum eq '') ? 'checked="checked"' : '' } value="1" >允许
	                          <input id="x16" name='setMealPo.ssmsmissum' type="radio" ${setMealPo.ssmsmissum eq '0' ? 'checked="checked"' : '' } value="0" >不允许
	                          &nbsp;<span class="STYLE1">*</span>
	                          </span>&nbsp;
                          </TD>  
                          <TD height="26" class="table_body">折上折</TD>
						  <TD class="table_none" colspan="3">
							  <input name='setMealPo.ssmsmisdiscount' type="radio" value="1" >允许
	                          <input name='setMealPo.ssmsmisdiscount' type="radio" checked value="0" >不允许
                          </TD>                      	
			            </TR>	
				        <TR>                             
				                 <TD height="26" class="table_body">活动门店<br/>
				                 <input type="checkbox" id="chks" name="chks" onclick="chkAll(this)">所有门店
				                 </TD>
				             	<TD height="26" class="table_none" colspan="5">
									<li class="horizontal_onlyRight">
									    <input clean=clean class="text_input300" id="bdpdepartmentname" name="setMealPo.ssmsmshopcodename" value="${setMealPo.ssmsmshopcodename }" type="hidden" />
									    <textarea clean=clean id="ds"  name="ds" readonly="readonly" style="width:1000" value="${setMealPo.ssmsmshopcodename}">${setMealPo.ssmsmshopcodename }</textarea>&nbsp;<span class="STYLE1">*</span>
									    <input clean=clean class="text_input100" type="hidden" id="departmentID" name="setMealPo.ssmsmshopcode" value="${setMealPo.ssmsmshopcode }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取活动部门！'}]"/>
									    
									</li>
									<li class="horizontal_onlyRight">						  		
										<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
									    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="cleanDepartment();" >
								    </li>  	 	            	
				               </TD>
				        </TR>
			              <TR>
			            	<TD height="62" class="table_body">备注</TD>
							<TD class="table_none" colspan="5">
							    <textarea clean="clean" id="ssmsmremark" style="width:1000" name="setMealPo.ssmsmremark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [1001]}, 'Message' : '备注不能大于1000字！'}]">${setMealPo.ssmsmremark }</textarea>&nbsp;<span class="STYLE1">(内容不超过1000字)</span>
                             </TD>
			              </TR>
                    </TABLE>
				    <br/>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><input type="checkbox" id="auditState" value="1" onclick="check()">保存并审核</TD>
                        </TR>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
						 	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							  
                          </TD>
                        </TR>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
 <DIV>                    
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
                   <!-- 
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:fromBillSpecialToGoodsSpecial();" 
                      UNSELECTABLE="on">商品优惠</TD>
                      
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                 --> 
                </TR></TBODY></TABLE></TD>
                    
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                        
					<TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">单一优惠</TD>
                      
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                   
                         </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                
                <div id="shangpinmansong">    
      				<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0>
                      <TBODY>
                        <TR align=middle>
                          <TD height="26" class="table_body" width="9%">整单满</TD>
                          <TD align="left" class="table_none" width="20%"><input type="text" class="text_input100" maxlength="10" name="setMealPo.ssmsmexpensespendup" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写的整单金额！'}]" onblur="amoumtAddZero(this)">&nbsp;至&nbsp;<input type="text" class="text_input100" maxlength="10" name="setMealPo.ssmsmexpensespendul" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写的整单金额！'}]" onblur="amoumtAddZero(this)"></TD>
                          <td align="left" class="table_none" width="15%">
                                                                        优惠方式：<select name="setMealPo.ssmsmdetailform" onchange="favorableBillForm(this);this.blur();" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择优惠方式！'}]">
                                  <option value="">----请选择----</option>
                                  <option value="23">打折</option>
                                  <option value="22">返现</option>
                                  <option value="24">特价</option>
                              </select>
                          </td>
                          <td align="left" class="table_none" width="6%">
                              <input type="text" class="text_input60 inInput readyonlyInput" style="width: 50" maxlength="10" name="setMealPo.ssmsmdiscountrate" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写整单折扣！'},{'Type' : Type.String, 'Formula' : Formula.UDiscount, 'Message' : '请重新填写的整单折扣！'}]" readonly="readonly" noValidate="noValidate">
                          </td>
                          <td align="left" class="table_none" width="6%">
                              <input type="text" class="text_input60 inInput readyonlyInput" style="width: 50" maxlength="10" name="setMealPo.ssmsmexpenseamount" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写整单优惠金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请重新填写的整单优惠金额！'}]" readonly="readonly" noValidate="noValidate" onblur="amoumtAddZero(this)">
                          </td>
                          <td align="left" class="table_none" width="6%">
                              <input type="text" class="text_input60 inInput readyonlyInput" style="width: 50" maxlength="10" name="setMealPo.ssmsmsalesbillamount" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写整单特价金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请重新填写的整单特价金额！'}]" readonly="readonly" noValidate="noValidate" onblur="amoumtAddZero(this)">
                          </td>
                          <td align="left" class="table_none" width="40%">&nbsp;</td>
                        </TR>
                      </TBODY>
                    </TABLE>  
                    <br/>
					<fieldset id="show1">
					<legend style="font-size:18px">购买商品</legend>
					<TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR valign="middle">
                        <td align="left" width="28%">
                          <img src="${ctx }/img/newbtn/btn_tjgmsp_0.png" btn=btn title="添加购买商品" onclick="addRow3()">
                          <img src="${ctx }/img/newbtn/btn_pltjgmsp_0.png" btn=btn title="批量添加购买商品" onclick="addGoodsBatch('3')">
                          <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onclick="del();" >
						</TD>
                        <td align="left" width="80%">购买方式 :&nbsp; 
                          <input id="x1" name='setMealPo.ssmsmsalesflag' type="radio" ${setMealPo.ssmsmsalesflag eq '1' ? 'checked="checked"' : '' } value="1">任选其一
                          <input id="x2" name='setMealPo.ssmsmsalesflag' type="radio" ${(setMealPo.ssmsmsalesflag eq '2' || setMealPo.ssmsmsalesflag eq '' || empty(setMealPo.ssmsmsalesflag)) ? 'checked="checked"' : '' } value="2">符合全部
                        </td>
                      </TR>
                    </TABLE>
                    
					<TABLE id="addTablebangding" width="100%"  border=0 cellspacing=1>
                      <TBODY>
                        <TR class=table_title align="center" valign="middle">
						  <TH width="4%" height="26" scope=col align="left">全选<input type="checkbox" id="chks1" name="chks1" onclick="chkAll1()"></TH>
						  <TH width="39%" scope=col>商品信息</TH>
                          <TH width="9%" scope=col>商品原价区间</TH>
                          <TH width="9%" scope=col>套餐价格区间</TH>
                          <TH width="5%" scope=col>销售数量</TH>
                          <TH width="9%" scope=col>消费满</TH> 
                         </TR>
					  </TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center>
                      <TBODY>
                        <TR>
                          <TD></TD>
                        </TR>
                      </TBODY>
                      </table>
					</fieldset>	

                   </DIV>
                	
                	<br/>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><input type="checkbox" id="auditState1" name="setMealPo.ssmsmauditstate" value="1" onclick="check1()">保存并审核</TD>
                        </TR>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
						 	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							  
                          </TD>
                        </TR>
                      </TBODY>
                      
              </TABLE>   
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV> 
    
    </form></BODY></html>