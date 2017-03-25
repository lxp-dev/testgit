<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息维护</title>
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

	function changeBillTemplate(typeID,id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initBillTemplateOpen.action?moduleID=${requestScope.moduleID}&typeID="+typeID+"&id="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBillTemplateOpen.action?moduleID=${requestScope.moduleID}&typeID="+typeID+"&id="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【模版选择】";
    }

	function setShowType(typeID,showType){
		location.href="updateFittingTemplateTypeShowtype.action?typeID="+typeID+"&showType="+showType;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form name="printBillTemplateForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
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
							<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
		                      <TBODY>
			 					<c:if test="${not empty(fittingTemplateTypeList)}">
			                    <s:iterator value="fittingTemplateTypeList">
								   <TR>
			                          <TD height="26" class="table_body " align="right" width="25%">${bfttname}</TD>
			                          <TD class="table_none" width="30%">
										<li class="horizontal_onlyRight">
											<img btn=btn src="${ctx }/img/newbtn/btn_szkjxsys_0.png" onClick="changeBillTemplate('${bfttid }','${bftid }');" width="100" height="20">
										</li>
										<li class="horizontal_onlyRight">
											<c:if test="${bftfileurl ne '' }"><img src="${ctx}${bftfileurl}" width="160" height="100" width2="600" height2="400" onclick="imgclick(this)" style="cursor: hand;" title="${bftname}"></c:if>
										</li></br> 
										<b>${bftname }</b>
			                          </TD>
			                          <TD class="table_none" colspan="4">
										打开方式： 
										<input type="radio" value="1" ${bfttshowtype eq '1' ? 'checked="checked"' : ''} onclick="setShowType('${bfttid }','1')">层显示
										<input type="radio" value="2" ${bfttshowtype eq '2' ? 'checked="checked"' : ''} onclick="setShowType('${bfttid }','2')">弹窗显示       
			                          </TD>			                          
								   </TR>
								</s:iterator>
								</c:if>
		                      </TBODY>
		                    </TABLE>
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
    <TD height=5></TD></TR></TBODY></TABLE>
    </form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>