<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打折卡更换</title> 
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function checkCard(){
		var cardid = $('#ssevcidt').val();
		var newpassword = $('#ssevccardnewpassword').val();
		if(event.keyCode == 13){
			if(checkForm(document.all.vipCardForm)){  
				vipCardForm.action = "initReplaceVIPCard.action?ssevcidt="+cardid+"&ssevccardnewpassword="+cardid+"&moduleID=${requestScope.moduleID}";
				vipCardForm.submit();
			}
		}
	}
	
	function save(){
		var cardid = $('#ssevcidt').val();
		var password = $('#ssevccardpassword').val();
		var newcardid = $('#ssevcnewid').val();
		var newpassword = $('#ssevccardnewpassword').val();
		
		if(newcardid == ''){
			alert("请填写新卡号！");
			$('#ssevcnewid').focus();
			return;
		}
		if($("#showpwd").attr("checked")){
			if(newpassword == ''){
				alert("请填写新密码！");
				$('#ssevccardnewpassword').focus();
				return;
			}
		}
		
		if(checkForm(document.all.vipCardForm)){  
			vipCardForm.action = "replaceVIPCard.action?ssevcidt="+cardid+"&ssevccardpassword="+password+"&ssevcnewid="+newcardid+"&ssevccardnewpassword="+newpassword+"&moduleID=${requestScope.moduleID}";
			vipCardForm.submit();
		}
	}
	
	function showpwdtr(){
		if($("#showpwd").attr("checked")){
			$("#trpwd").attr("style","");
		}else{
			$("#trpwd").attr("style","display: none");
		}
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="vipCardForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" >
<input type="hidden" name="pwd" id="pwd" value="${requestScope.pwd}" >

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
						    <TD width="15%" height="26" class="table_body">原卡号</TD>
			                <TD class="table_none" colspan="4">
                            	${ssevcidt}<input type="hidden" id="ssevcidt" value="${ssevcidt}" name="ssevcidt">
			                </TD>
			             </TR>
			             <c:if test="${vipCardPo.ssevccustomername != '' && vipCardPo.ssevccustomername != null}">
			             <TR height="26">
						    <TD width="15%" class="table_body">会员姓名</TD>
						    <td width="30%" class="table_none">${vipCardPo.ssevccustomername}</td>
						    <TD width="15%" class="table_body">身份证</TD>
						    <td class="table_none">${vipCardPo.ssevcidcard}</td>
			             </TR>
			             </c:if>
			             
			             <c:if test="${pwd == '1'}">
				             <TR height="26">
							    <TD width="15%" class="table_body">密码</TD>
							    <td class="table_none" colspan="4">
							    <c:if test="${login != '1'}">
							    	<input class="text_input160" type="password" id="ssevccardpassword" maxlength="20" onkeydown="checkCard();" value="${ssevccardpassword}" name="ssevccardpassword"><font style="color: red;">*点击回车确认密码是否正确！</font>
							    </c:if>
							    <c:if test="${login == '1'}">
							    	${vipCardPo.ssevccardpassword}<font style="color: red;">&nbsp;&nbsp;√&nbsp;&nbsp;密码正确！</font><input type="hidden" id="ssevccardpassword" value="${ssevccardpassword}" name="ssevccardpassword">
							    </c:if>
							    </td>
				             </TR>
			             </c:if>
			             
			             <c:if test="${pwd == '0'}">
			             	<input type="hidden" id="ssevccardpassword" value="" name="ssevccardpassword">
			             </c:if>
			             <c:if test="${login == '1'||pwd == '0'}">
			             <TR height="26">
			             	<TD width="15%" class="table_body">新卡号</TD>
						    <td class="table_none" colspan="4">
						    	<input class="text_input160" id="ssevcnewid" maxlength="20" value="${ssevcnewid}" name="ssevcnewid" validate="[{'Type' : Type.String, 'Formula' : Formula.NO_CNORNULL, 'Message' : '新卡号不包含中文！'}]">
						    	<input type="checkbox" id="showpwd" onclick="showpwdtr();"/>是否填写密码
						    </td>
			             </TR>
			             <TR height="26"  id="trpwd" style="display: none">
						    <TD width="15%" class="table_body">新密码</TD>
						    <td class="table_none" colspan="4">
						    	<input class="text_input160" type="password" id="ssevccardnewpassword" maxlength="20" value="${ssevccardnewpassword}" name="ssevccardnewpassword">
						    </td>
			             </TR>
			             </c:if>
                      </TBODY>
                    </TABLE>
                    <c:if test="${login == '1'||pwd == '0'}">
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR><td>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
                    </c:if>
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