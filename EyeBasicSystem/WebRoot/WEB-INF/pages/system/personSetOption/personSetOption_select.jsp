<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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

	function save(){
		if(checkForm(personSetOptionForm)){
			$("img").removeAttr("onclick");
			personSetOptionForm.action = "updatePersonSetOption.action";
			personSetOptionForm.submit();
		}
	}
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="personSetOptionForm">
<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
<input type="hidden" value="${personSetOptionPo.fpsopersonid }" name="personSetOptionPo.fpsopersonid" id="fpsopersonid" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
    <br/>
    
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD height="30">
						   		<input type="checkbox" ${personSetOptionPo.fpsohidetop != '1' ? '':'checked=checked'} name="personSetOptionPo.fpsohidetop" value="1" id="fpsohidetop">
						   		<label style="color:red;">&nbsp;*&nbsp;登陆后隐藏上方导航栏</label>
						   	</TD>
			            </TR>
                        <TR>
						   <TD height="30">
						   		&nbsp;&nbsp;&nbsp;●&nbsp;&nbsp;提醒信息	|
						   		<c:set value="${ fn:split(personSetOptionPo.fpsoreminderwindowid, ',') }" var="str" />   
							    <c:forEach var="reminderWindowPoTmp" items="${departmentTypeAndRoleReminderwindowList}" > 
							   		<c:set value="" var="checkStr" />
							   		<c:forEach items="${ str }" var="s">
							   			<c:if test="${fn:trim(s) == fn:trim(reminderWindowPoTmp.frwsid)}">
							   				<c:set value="checked=checked" var="checkStr" />
							   			</c:if>									          											
										</c:forEach> 																			   		 
				   					<input name="reminderwindowids" type="checkbox" ${checkStr}  value="${reminderWindowPoTmp.frwsid }">${reminderWindowPoTmp.frwsname}                                    	
	                            </c:forEach> 
						   	</TD>
			            </TR>
                        <TR>
						   <TD height="30">
						   		<input type="checkbox" ${personSetOptionPo.fpsodivframetype eq '0' ? '':'checked=checked'} name="personSetOptionPo.fpsodivframetype" value="1" id="fpsodivframetype">
						   		<label style="color:red;">&nbsp;*&nbsp;点击左侧菜单，重新刷新已经打开的窗口</label>
						   </TD>
			            </TR>			            			            
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">	
						 	<!-- <input icon='icon-reload' type='button' value='清空' onClick="clean()"> -->
							  
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
    </BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>