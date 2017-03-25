<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程培训维护</title>
</head>
<script>	
	
	
	function save(){
		if(checkForm(personInfoForm)){
			
			$("img").removeAttr("onclick");
			personInfoForm.action = "updateTrainingCourses.action";
			personInfoForm.submit();
		}
	}
	
	    function CheckExt(obj,flag){	    
	 		if(obj.value == ""){
	 			return false;
	 		}
	 		obj.value = getPath(obj);
	 	}

	    function openPerson(){
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin("selectPersonList.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selectPersonList.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}		
			document.getElementById('popupTitle').innerHTML="【人员查询】";
		}
		
		function openRole(){
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin("selectRoleList.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selectRoleList.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}		
			document.getElementById('popupTitle').innerHTML="【角色查询】";
		}

		$(document).ready(function() {
			$("img[btn=btn]").attr("style","cursor: hand");
			$("img[btn=btn]").mouseover(function () {
		    	$(this).attr("src",$(this).attr("src").replace("0","1"));
			}).mouseout(function () {
				$(this).attr("src",$(this).attr("src").replace("1","0"));
			});
		});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="hid" value="${hid}">
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="10%" height="30" class="table_body">课程说明</TD>
			               <TD width="90%" class="table_none" colspan="5">
			               <input class="text_input240" id="kjbcoursesname" name="kjbcoursesname" value="${trainingCoursesPo.kjbcoursesname }"  ></TD>
                        </TR>
                        
						<TR>
						   <TD width="10%" height="30" class="table_body">主讲人</TD>
			               <TD width="90%" class="table_none">
			               <input class="text_input100" id="kjbspeechpersonname" name="kjbspeechpersonname" value="${trainingCoursesPo.kjbspeechpersonname }" maxlength="20"></TD>
                        </TR>
                        
                        
						<TR>
						  <TD width="10%" height="30" class="table_body">内容简介</TD>
                          <TD width="90%" class="table_none">
                          	<textarea id="kjbcoursescontent" name="kjbcoursescontent" >${trainingCoursesPo.kjbcoursescontent }</textarea>
						  </TD>
						</TR>
						<TR> 
					   <TD height="30" width="10%" class="table_body">选择人员</TD>
				           <TD height="30" width="90%" class="table_none" >
				           		<li class="horizontal_onlyRight">
								<input type="hidden" name="perID" id="perID" value="${perID }">
								<input type="text" class="text_input240" name="perNAME" id="perNAME" readonly="readonly"  value="${perNAME }">
								</li>
								 <li class="horizontal_onlyRight">
							  <img src="${ctx}/img/newbtn/btn_change_0.png" btn=btn id="submitButton" title='选择' onClick="openPerson();"></li>
						   </TD>
						</TR>
							<TR>
					   <TD height="30" width="10%" class="table_body">选择角色</TD>
				           <TD height="30" width="90%" class="table_none" >
				           		<li class="horizontal_onlyRight">
								<input type="hidden" name="rolID" id="rolID" value="${rolID }">
								<input type="text" class="text_input240" name="rolNAME" id="rolNAME" readonly="readonly"  value="${rolNAME }">
								</li>
								 <li class="horizontal_onlyRight">
							  <img src="${ctx}/img/newbtn/btn_change_0.png" btn=btn id="submitButton" title='选择' onClick="openRole();"></li>
						   </TD>
						</TR>
                      </TBODY>
                    </TABLE>
					
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
							  
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
