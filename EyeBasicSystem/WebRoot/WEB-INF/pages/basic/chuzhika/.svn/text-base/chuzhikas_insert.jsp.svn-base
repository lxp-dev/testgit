<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>储值卡新增</title> 
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

        $('#cstczkcardpassword').removeAttr('validate');
	});

	function save(){
		if($("#cstczkid2").val() > 9999999000){
			alert("动态号段不得大于9999999000！");
			$("#cstczkid2").focus();
			return;
		}
	
		if(checkForm(document.all.chuzhikaForm)){
		    $("img").removeAttr("onclick");
			chuzhikaForm.action = "chuzhikaInserts.action";
			chuzhikaForm.submit();
			showLoadingBar();
		}
	}
	
	function showpwdinput(){
		if($("#showpwd").attr("checked")){
			$("#divpwd1").attr("style","");
			$("#cstczkcardpassword").attr("disabled","");
			$('#cstczkcardpassword').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写储值卡密码！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Word, \'Message\' : \'密码应为数字或字母！\'}]");
		}else{
			$("#divpwd1").attr("style","display: none");
			$("#cstczkcardpassword").attr("disabled","disabled");
			$("#cstczkcardpassword").val('');
			$('#cstczkcardpassword').removeAttr('validate');
		}
	}

	function onchangeJine(){

		var shifu = $("#cstczkshifujine");
		var zengsong = $("#cstczkzengsongjine");
		var jine = $("#cstczkjine");
		
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
						    <TD width="8%" height="30" class="table_body">储值卡号</TD>
			                <TD width="25%" class="table_none">
                            	<input class="text_input80" type="text" id="cstczkid1"  maxlength="6" value="${cstczkid1 }" name="cstczkid1" >&nbsp;固定号段
                            	<input class="text_input100" type="text" id="cstczkid2" maxlength="10" value="${cstczkid2 }" name="cstczkid2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '储值卡号起始值不能为空！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '储值卡号应为数字！'}]" onblur="this.value=$.trim(this.value);">&nbsp;动态号段
			                	<label style="color:red;">&nbsp;*</label>
			               	</TD>
			              	<TD width="8%" class="table_body">发放部门</TD>
			               	<TD class="table_none"  valign="middle" colspan="3">
	                            <select id="cstczkshopcode" name="chuzhikaPo.cstczkshopcode">
	      		                 	<option value="">-----请选择----</option>
	      		                 	<c:forEach var="po" items="${departmentsList}" >
	      		                 		<OPTION value="${po.bdpdepartmentid}">${po.bdpdepartmentname}</OPTION>                                     	
									</c:forEach> 
      	                   		</select>
	                            <label style="color:red;">&nbsp;记录此储值卡发放的部门</label>			               	
                            </TD>
			             </TR>
			             <TR>
			               	<TD height="30" class="table_body">实付金额</TD>
			               	<TD class="table_none" width="15%" valign="middle">
	                            <input class="text_input100" type="text" id="cstczkshifujine" onchange="onchangeJine();" maxlength="10" value="0.00" name="chuzhikaPo.cstczkshifujine" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写储值卡面额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的面额！'}]">
                            </TD>
						    <TD class="table_body">
							   	赠送金额
						    </TD>
			                <TD class="table_none">
			                	<input class="text_input100" type="text" id="cstczkzengsongjine" maxlength="10" onchange="onchangeJine();" value="0.00" name="chuzhikaPo.cstczkzengsongjine" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写储值卡面额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的面额！'}]">		                
			                </TD>	
						    <TD class="table_body">
							   	储值金额
						    </TD>
			                <TD class="table_none">
			                	<input class="text_input100" type="text" id="cstczkjine" maxlength="10" value="0.00" readonly="readonly" name="chuzhikaPo.cstczkjine" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写储值卡面额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的面额！'}]">
			                	<label style="color:red;">&nbsp;*储值金额=实付金额+赠送金额</label>		                
			                </TD>			                		                
			             </TR>
			             <TR>
						    <TD class="table_body">新增数量</TD>
			                <TD class="table_none">
                            	<input class="text_input100" type="text" maxlength="3" name="cardnumber" value="1" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写批量新增的数量！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请填写正确的新增数量！'}]">
			               	<label style="color:red;">&nbsp;*</label>
			                </TD>
						    <TD class="table_body">
							    <input type="checkbox" id="showpwd" onclick="showpwdinput();"/>是否设置密码
						    </TD>
			                <TD class="table_none" colspan="3">
			                	<div id="divpwd1" style="display: none;"><input class="text_input120" type="text" id="cstczkcardpassword" maxlength="10" value="${chuzhikaPo.cstczkcardpassword}" name="chuzhikaPo.cstczkcardpassword" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写储值卡密码！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '密码应为英文或数字！'}]"></div>
			                </TD>
			             </TR>
			             <TR>
						    <TD height="62" class="table_body">备注</TD>
			                <TD class="table_none" colspan="5">
			                	<textarea id="cstczkremark" name="chuzhikaPo.cstczkremark" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [200]}, 'Message' : '备注不能大于200字符'}]"></textarea>
			               </TD>
			             </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR><td>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
                     <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行新增，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->               	                	
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