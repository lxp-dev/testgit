<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>储值卡充值</title> 
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
		$("#cstczkchongzhijine").focus();
	});

	function save(){
		if(checkForm(document.all.chuzhikaForm)){  

			if($("input[name='chuzhikaLogPo.smeasaddorsub']:checked").val() == '2'){
				var jine= parseFloat($("#smeasyintegral").val()).toFixed(2);
				var cjine= parseFloat($("#smeascintegral").val()).toFixed(2);
			
				if(cjine-jine>0){
					alert("提现金额不能大于余额！");
					return;
				}else{
					document.getElementById('smeascintegral').value=Number(cjine*-1).toFixed(2)+"";
				}
			}

			if(document.getElementById('smeascintegral').value=="0.00" || document.getElementById('smeascintegral').value=="0"){
				alert("请输入正确的金额！");
				return;
			}
			
		    $("img").removeAttr("onclick");
			chuzhikaForm.action = "chuzhikaUpdate.action";
			chuzhikaForm.submit();
		}
	}

	function onchangeJine(){

		var shifu = $("#smeasshifu");
		var zengsong = $("#smeaszengsong");
		var jine = $("#smeascintegral");
		
		if(Number(shifu.val()) >= 0){
		}else{
			alert("请正确填写实付金额！");
			shifu.val('0.00');
			shifu.focus();
			return;
		}
		if(Number(zengsong.val()) >= 0){
		}else{
			alert("请正确填写赠送金额！");
			zengsong.val("0.00");
			zengsong.focus();
			return;
		}
			
		if(shifu.val() == ""){
			shifu.val('0.00');
		}
		shifu.val(Number(shifu.val()).toFixed(2));

		if(zengsong.val() == ""){
			zengsong.val('0.00');
		}		
		zengsong.val(Number(zengsong.val()).toFixed(2));
		jine.val(Number(Number(shifu.val())+Number(zengsong.val())).toFixed(2));
	
	}

	function isShowAndHide(str){
		document.getElementById('smeasshifu').value = "0.00";
		document.getElementById('smeaszengsong').value = "0.00";
		document.getElementById('smeascintegral').value = "0.00";
		if(str == '1'){
			$("#shifu").show();
			$("#zengsong").show();
			$('#smeascintegral').attr("readonly","readonly");
			$("#chongzhiTitle")[0].innerHTML = "充值金额(￥)";
		}
		if(str == '2'){
			$("#shifu").hide();
			$("#zengsong").hide();
			$('#smeascintegral').removeAttr("readonly");
			$("#chongzhiTitle")[0].innerHTML = "提现金额(￥)";
		}
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="chuzhikaForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}" >

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
						<TR>			               
			               <TD class="table_body">操作类型</TD>
			               <TD class="table_body" valign="middle">
                           	<input type="radio" id="chongzhiType" name="chuzhikaLogPo.smeasaddorsub" value="1" checked="checked" onclick="isShowAndHide('1');"/>充值
                           	<input type="radio" id="chongzhiType" name="chuzhikaLogPo.smeasaddorsub" value="2" onclick="isShowAndHide('2');"/>提现
                           	<label style="color:red;">&nbsp;充值和提现,以下金额都输入正值</label>
						   </TD>
			            </TR>                      
                      	<TR>
                      	   <TD width="30%" height="30" class="table_body">储值卡号</TD>
			               <TD class="table_body">
                            ${chuzhikaPo.cstczkcardid}&nbsp;<input type="hidden" id="cstczkid"  maxlength="16"  value="${chuzhikaPo.cstczkid}" name="chuzhikaLogPo.smeaschuzhikaid">
			               </TD>
						</TR>
						<TR>			               
			               <TD class="table_body">余额(￥)</TD>
			               <TD class="table_body" valign="middle">
                           ${chuzhikaPo.cstczkjine}&nbsp;<input type="hidden" id="smeasyintegral" value="${chuzhikaPo.cstczkjine}" name="chuzhikaLogPo.smeasyintegral"></TD>
			            </TR>
						<TR id="shifu">
			               <TD class="table_body">实付金额(￥)</TD>
			               <TD class="table_body" valign="middle">
                           <input class="text_input160" type="text" id="smeasshifu" maxlength="10" onchange="onchangeJine();" value="0.00" name="chuzhikaLogPo.smeasshifu" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写实付金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写实付金额！'}]"></TD>
			            </TR>
						<TR id="zengsong">
			               <TD class="table_body">赠送金额(￥)</TD>
			               <TD class="table_body" valign="middle">
                           <input class="text_input160" type="text" id="smeaszengsong" maxlength="10"  onchange="onchangeJine();" value="0.00" name="chuzhikaLogPo.smeaszengsong" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写赠送金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写赠送金额！'}]"></TD>
			            </TR>			            			            
						<TR>
			               <TD class="table_body"><div id="chongzhiTitle">充值金额(￥)</div></TD>
			               <TD class="table_body" valign="middle">
                           <input class="text_input160" type="text" id="smeascintegral" maxlength="10" value="0.00" name="chuzhikaLogPo.smeascintegral" value="0.00" readonly="readonly" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写金额！'}]"></TD>
			            </TR>			            
			            <TR>
			               <TD class="table_body"><div id="chongzhiTitle">备注</div></TD>
			               <TD class="table_body" valign="middle">
                           <textarea id="smeasremark" name="chuzhikaLogPo.smeasremark" validate="[{'Type' : Type.String, 'Expansion' : {Type : Expansion.ThanLength, Params : [0]}, 'Message' : '备注必填！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [200]}, 'Message' : '备注不能大于200字符'}]"></textarea>
                           </TD>
			            </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
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