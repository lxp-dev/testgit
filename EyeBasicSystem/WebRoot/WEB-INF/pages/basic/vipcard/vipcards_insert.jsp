<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打折卡新增</title> 
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        });

        $('#ssevccardpassword').removeAttr('validate');
		$('#ssevcdowntime').removeAttr('validate');
		$('#ssevcuptime').removeAttr('validate');
		$('#ssevcusecount').removeAttr('validate');
	});

	function save(){
		if(checkForm(document.all.glassesFrameForm)){
			$("#ssevcdiscount").val(Number($("#ssevcdiscount").val()));
			if(Number($("#ssevcdiscount").val()) > 1 || Number($("#ssevcdiscount").val()) <= 0){
				alert("折扣必须在0-1之间且不为0!");
				$("#ssevcdiscount").focus();
				return;
			}
			if (Number($('#ssevcid2').val().length) != 6){
                alert('打折卡号起始值需要6位数字!');
                return;
			}
	        if ($('input[name=goodsType]:checked').size() == 0){
	        	alert('请选择商品类型!');
	        	return;
	        }
	        
		    $("img").removeAttr("onclick");
			glassesFrameForm.action = "insertVIPCards.action";
			glassesFrameForm.submit();
		}
	}
	
	function showpwdinput(){
		if($("#showpwd").attr("checked")){
			$("#divpwd1").attr("style","");
			$("#divpwd2").attr("style","display: none");
			$("#ssevccardpassword2").val('');
			$("#ssevccardpassword2").attr("disabled","");
			$('#ssevccardpassword').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写打折卡密码！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Word, \'Message\' : \'密码应为数字或字母！\'}]");
		}else{
			$("#divpwd2").attr("style","");
			$("#divpwd1").attr("style","display: none");
			$("#ssevccardpassword").val('');
			$("#ssevccardpassword").attr("disabled","disabled");
			$('#ssevccardpassword').removeAttr('validate');
		}
	}
	function showpwdinput2(){
		if($("#showpwd2").attr("checked")){
			$("#ssevcdowntime").attr("style","");
			$("#ssevcuptime").attr("style","");
			$('#ssevcdowntime').attr("validate","[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写有效期！'}]");
			$('#ssevcuptime').attr("validate","[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写有效期！'}]");
		}else{
			$("#ssevcdowntime").attr("style","display: none");
			$("#ssevcuptime").attr("style","display: none");
			$('#ssevcdowntime').val('');
			$('#ssevcuptime').val('');
			$('#ssevcdowntime').removeAttr('validate');
			$('#ssevcuptime').removeAttr('validate');
		}
	}
	function showpwdinput3(){
		if($("#showpwd3").attr("checked")){
			$("#divsycs").attr("style","");
			$("#divsycs2").attr("style","display: none");
			$("#ssevcusecount2").val('');
			$("#ssevcusecount2").attr("disabled","");
			$('#ssevcusecount').attr("validate","[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写使用次数！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '使用次数应为数字！'}]");
		}else{
			$("#divsycs2").attr("style","");
			$("#divsycs").attr("style","display: none");
			$("#ssevcusecount").val('');
			$("#ssevcusecount").attr("disabled","disabled");
			$('#ssevcusecount').removeAttr('validate');
		}
	}

	function selectAllGoodsType(){
        if ($('#goodsAllType').attr('checked') == true){
        	$('input[name=goodsType]').attr('checked','checked');
        }else{
        	$('input[name=goodsType]').removeAttr('checked');
        }
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}" >

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
						    <TD width="12%" height="26" class="table_body">打折卡号</TD>
			                <TD width="20%" class="table_none">
			                	<input class="text_input80" type="text" id="ssevcid1" style="background-color: #E0E0E0" maxlength="20" value="${cardid1}" name="ssevcid1" readonly="readonly">
                            	<input class="text_input100" type="text" id="ssevcid2" maxlength="6" value="${vipCardPo.ssevcid}" name="ssevcid2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '打折卡号起始值不能为空！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '打折卡号只允许输入数字！'}]">
                            	<label style="color:red;">&nbsp;*</label></TD>
			                </TD>
			                <TD width="12%" height="26" class="table_body">折扣</TD>
			                <TD width="20%" class="table_none" valign="middle">
                            	<input class="text_input160" type="text" id="ssevcdiscount" maxlength="5" value="${vipCardPo.ssevcdiscount}" name="vipCardPo.ssevcdiscount" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写折扣！'}]">
                            	<label style="color:red;">&nbsp;*</label>
                            </TD>
						    <TD width="13%" height="26" class="table_body"><input type="checkbox" id="showpwd2" onclick="showpwdinput2();"/>是否设置有效期</TD>
			                <TD class="table_none">
			                	<input id="ssevcdowntime"
							       name="vipCardPo.ssevcdowntime" 
							       style="display: none;"
							       type="text" class="text_input100" 
							       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssevcuptime\')}'})"
							       value="${vipCardPo.ssevcdowntime}" qing="qing" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写有效期！'}]"/> 至 
							       <input id="ssevcuptime"
							       name="vipCardPo.ssevcuptime"
							       style="display: none;" 
							       type="text" class="text_input100" 
							       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssevcdowntime\')}'})" 
							        value="${vipCardPo.ssevcuptime}" qing="qing" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写有效期！'}]"/>
							        
			               </TD>
			             </TR>
			             <TR>
						    <TD height="26" class="table_body">持卡人姓名</TD>
			                <TD class="table_none">
                            	<input class="text_input160" type="text" id="ssevccustomername" maxlength="20" value="${vipCardPo.ssevccustomername}" name="vipCardPo.ssevccustomername" validate="[{'Type' : Type.String, 'Formula' : Formula.PersonNameOrNULL, 'Message' : '请重新填写持卡人姓名！'}]">
			               	</TD>
			                <TD height="26" class="table_body">身份证</TD>
			                <TD class="table_none" valign="middle">
                            	<input class="text_input160" type="text" id="ssevcidcard" maxlength="18" value="${vipCardPo.ssevcidcard}" name="vipCardPo.ssevcidcard" validate="[{'Type' : Type.String, 'Formula' : Formula.IdentityCardORNULL, 'Message' : '请按正确的身份证格式填写！'}]"/>
                            </TD>
						    <TD width="8%" height="26" class="table_body">
						    	<input type="checkbox" id="showpwd" onclick="showpwdinput();"/>是否设置密码
						    </TD>
			                <TD class="table_none">
			                	<div id="divpwd1" style="display: none;"><input class="text_input160" type="text" id="ssevccardpassword" maxlength="10" value="${vipCardPo.ssevccardpassword}" name="vipCardPo.ssevccardpassword" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写打折卡密码！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '密码应为英文或数字！'}]"></div>
			                	<div id="divpwd2" style="display: block;"><input type="hidden" id="ssevccardpassword2" disabled="disabled" value=""></div>
			                </TD>
			             </TR>
			             <TR>
			             						    <TD  height="26" class="table_body">
						    	<input type="checkbox" id="showpwd3" onclick="showpwdinput3();"/>是否设置使用次数
						    </TD>
			                <TD class="table_none" >
			                	<div id="divsycs" style="display: none;"><input class="text_input160" type="text" id="ssevcusecount" maxlength="10" value="${vipCardPo.ssevcusecount}" name="vipCardPo.ssevcusecount" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写使用次数！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '使用次数应为数字！'}]" ></div>
			                	<div id="divsycs2" style="display: block;"><input type="hidden" id="ssevccardusecount2" disabled="disabled" value="1"></div>
			                </TD>
						    <TD height="26" class="table_body">数量</TD>
			                <TD class="table_none" colspan="3">
                            	<input class="text_input100" type="text" id="cardnumber" maxlength="5" value="${vipCardPo.ssevccustomername}" name="cardnumber" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写数量！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '数量应为正整数！'}]">
			               	<label style="color:red;">&nbsp;*</label>
			                </TD>
			             </TR>
			             
			             <TR>
						    <TD  height="26" class="table_body">
						    	商品类型
						    </TD>
			                <TD class="table_none" colspan="5">
			                    <input type="checkbox" id="goodsAllType" name="goodsAllType" onclick="selectAllGoodsType();" value="0"/>全部商品&nbsp;<br/>
			                	<input type="checkbox" id="goodsType1" name="goodsType" value="1"/>镜架&nbsp;
			                	<input type="checkbox" id="goodsType2" name="goodsType" value="2"/>配件&nbsp;
			                	<input type="checkbox" id="goodsType3" name="goodsType" value="3"/>镜片&nbsp;
			                	<input type="checkbox" id="goodsType4" name="goodsType" value="4"/>隐形&nbsp;
			                	<input type="checkbox" id="goodsType5" name="goodsType" value="5"/>护理液&nbsp;
			                	<input type="checkbox" id="goodsType6" name="goodsType" value="6"/>太阳镜&nbsp;
			                	<input type="checkbox" id="goodsType7" name="goodsType" value="7"/>耗材&nbsp;
			                	<input type="checkbox" id="goodsType8" name="goodsType" value="8"/>老花镜&nbsp;
			                	<input type="checkbox" id="goodsType9" name="goodsType" value="9"/>视光&nbsp;<label style="color:red;">&nbsp;*</label>
			                </TD>
			             </TR>
			             
                      </TBODY>
                    </TABLE>
                    <br/>
                    <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <s:iterator value="selectGoodsLevelList">
                      	<tr>
                    	  <TD height="26" class="table_body" width="8%">商品级别</TD>
			              <td align="left" class="table_none" width="23%">
				               	<input type="hidden" value="${bgluuid}" name="vipCardDetailsPo.ssevcdgoodslevels">${bglname}
                          </td>
                          <TD height="26" class="table_body" width="8%">折扣率</TD>
			              <td align="left" class="table_none">
				               	<input type="text" class="text_input100" value="" name="vipCardDetailsPo.ssevcddiscounts" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写折扣！'}]">
                          </td>
                        </tr>
                      </s:iterator>
                      </TBODY>
                    </table>
                    </c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR><td>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="document.glassesFrameForm.reset();">
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
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>