<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>

<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () 
		{
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});
		   	
	});
	
	function pswdUpdate(){
		if(document.getElementsByName('oldPswd')[0].value==''){
			alert('旧密码不能为空!');
			document.getElementsByName('oldPswd')[0].focus();
			return;
		}
		if(document.getElementsByName('newPswd')[0].value==''){
			alert('新密码不能为空!');
			document.getElementsByName('newPswd')[0].focus();
			return;
		}
		if(document.getElementsByName('newPswd')[0].value!=document.getElementsByName('newPswdAg')[0].value){
			alert('两次密码输入不一致!');
			document.getElementsByName('newPswd')[0].value='';
			document.getElementsByName('newPswdAg')[0].value='';
			document.getElementsByName('newPswd')[0].focus();
			return;
		}
		
		arrearsForm.action='pswdUpdate.action';
		arrearsForm.submit();
	}
	function checkOld(obj){
		if('${person.password}'!=obj.value&&obj.value!=''){
			alert('原密码不正确!');
			obj.value='';
			obj.focus();
			return;
		}
	}
	window.onload=function(){
		document.getElementsByName('oldPswd')[0].focus();
		
		if('${pswdUpdate}'=='1'){
			window.close();
		}
	};
	
	
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="arrearsForm" method="post" action="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>修改密码</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=1 colspan="2">&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=1></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif>&nbsp;</TD></TR>
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
					<table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="50%" height="30" align="right" class="table_body">用户名</TD>
			               <TD class="table_none" width="50%">
                         <input type="hidden" name="salesID"/><span id="ssesbsalesid">${person.id}</span>
			               </TD>
                        </TR>
                        <TR>
						   <TD width="50%" height="30" align="right" class="table_body">原密码</TD>
			               <TD class="table_none" width="50%">
                           <input name="oldPswd" type="password" maxlength="10" class="text_input100" onblur="checkOld(this)"/>
			               </TD>
                        </TR>
                        <TR>
						   <TD width="50%" height="30" align="right" class="table_body">新密码</TD>
			               <TD class="table_none" width="50%">
                           <input name="newPswd" type="password" class="text_input100" maxlength="10"/>
			               </TD>
                        </TR>
                        <TR>
						   <TD width="50%" height="30" align="right" class="table_body">请再次输入新密码</TD>
			               <TD class="table_none" width="50%">
                            <input name="newPswdAg" maxlength="10" class="text_input100" type="password"/>
			               </TD>
                        </TR>
                        <TR>
                        <TD width="100%" height="40" colspan="2" align="center" >
							<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="pswdUpdate()">
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