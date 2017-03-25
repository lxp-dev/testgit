<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>科目管理</title>
<script type="text/javascript">
	 
	/**
     *  修改科目
     */        
	function save(){	  
	   var subjectID = document.getElementById('subjectID').value.trim();
	   if (subjectID == "" || subjectID == null){
	        alert("科目代码不能为空!");
	        return;
	   }	     
	   var subjectName = document.getElementById('subjectName').value.trim();
	   if (subjectName == "" || subjectName == null){
	        alert("科目名称不能为空!");
	        return;
	   }
	   $("img").removeAttr("onclick");
       updateSubjectFrm.action = "updateSubject.action";
       updateSubjectFrm.submit();

	}
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form action="" method="post" id="updateSubjectFrm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="parentID" value="${requestScope.parentID}">
<input type="hidden" name="parent" id="parent" value="${parent}" >
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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26px">
                          <TD width="9%" class="table_body">科目代码</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" id="subjectID" name="subjectPo.sLssSubjectID" type="text" value="${subjectPo.sLssSubjectID}" maxlength="20">
                          <input class="text_input200" name="subjectPo.sLssID" type="hidden" value="${subjectPo.sLssID}" maxlength="50">
                          </TD>
                          <TD width="9%" class="table_body">科目名称</TD>
                          <TD class="table_none" width="24%">
                             <input clean="clean" class="text_input160" id="subjectName" name="subjectPo.sLssSubjectName" type="text" value="${subjectPo.sLssSubjectName}" maxlength="20">
                          </TD>
                          <TD width="9%" class="table_body">隶属科目</TD>
                          <TD width="24%" class="table_none">
                             ${subjectPo.sLssParentID}
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left">	
						    <img btn=btn id="submitBtn" name="submitBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()">
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>