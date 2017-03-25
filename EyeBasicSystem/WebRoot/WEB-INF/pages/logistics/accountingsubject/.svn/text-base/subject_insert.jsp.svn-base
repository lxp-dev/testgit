<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>科目管理</title>
<script type="text/javascript">
	 
	/**
     *  新增科目
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
       insertSubjectFrm.action = "insertSubject.action";
       insertSubjectFrm.submit();
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 

    /**
	 * 科目开窗
	 */ 
     function openSubject(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSubjectOpenTree.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSubjectOpenTree.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会计科目查询】";
     }
     
    /**
	 * 科目开窗赋值
	 */ 
     function openSubjectValue(json){
         document.getElementById("parentSubjectName").value=json.subject;
         document.getElementById("parentSubjectID").value=json.subjectID;
     }
     
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form action="" method="post" id="insertSubjectFrm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="parentID" value="${requestScope.parentID}">
<input type="hidden" name="parent" value="${requestScope.parent}">
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
                          <TD width="24%" class="table_none"><input clean="clean" class="text_input160" id="subjectID" name="subjectPo.sLssSubjectID" type="text" maxlength="20">
                         
                          </TD>
                          <TD width="9%" class="table_body">科目名称</TD>
                          <TD width="24%" class="table_none">
                             <input clean="clean" class="text_input160" id="subjectName" name="subjectPo.sLssSubjectName" type="text" maxlength="20">
                          </TD>
                          <TD width="9%" class="table_body">隶属科目</TD>
                          <TD width="24%" class="table_none">
                             <li class="horizontal_onlyRight">
                                 <input clean=clean type="text" id="parentSubjectName" name="parentSubjectName" readonly="readonly" value="${parentSubjectName}"><input clean=clean type="hidden" id="parentSubjectID" name="subjectPo.sLssParentID" value="${parentSubjectID}">
                             </li>
                             <li class="horizontal_onlyRight">
                                 <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onclick="openSubject();" >
                             </li>    
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