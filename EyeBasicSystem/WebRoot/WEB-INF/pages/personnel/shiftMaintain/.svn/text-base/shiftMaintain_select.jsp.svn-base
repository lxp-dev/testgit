<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班次维护</title>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	
	
	function update(id)
	{
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateShiftMaintainPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateShiftMaintainPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【班次修改】";
	}
	
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		
		if(is_iPad()){
			showPopWin("initDeleteShiftMaintainPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteShiftMaintainPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【班次删除】";
	}
	
	function insert(){
		//showPopWin("","initInsertTeachnologyType.action?moduleID=${moduleID }",screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){
			showPopWin("initInsertShiftMaintainPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
            showPopWin("initInsertShiftMaintainPo.action?hid=" + document.all.hid.value+"&moduleID="+document.all.moduleID.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true)); 
		}

		document.getElementById('popupTitle').innerHTML="【班次新增】";
	}
	
	function showLoadingBar()
	{								
	}
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="mpostForm">
<input type="hidden" name="hid" id="hid">

<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>人事维护</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：班次维护</TD>
            <td align="right" valign="bottom">
            	<c:if test="${(permissionPo.keya==1)}">
            	&nbsp;
            	<img src="${ctx }/img/newbtn/btn_shiftmaintaininsert_0.png " btn=btn title="班次新增" onClick="insert()">            	
     				
            	</c:if>
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
				</TD></TR>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
		                      <TBODY>
		                        <TR class=table_title align=middle>
		                          <TH width="8%" scope=col colspan="2">操作</TH>
		                          <TH width="16%" height="26" scope=col>班次编号</TH>
		                          <TH width="25%" scope=col>班次名称</TH>
		                          <TH width="16%" scope=col>时长</TH>
		                          <TH width="25%" scope=col>工作时间</TH>
		                        </TR>
		                        <c:if test="${not empty(shiftMaintainPos)}">
		                        <c:forEach items="${shiftMaintainPos}" var="item" varStatus="lineNum"> 
		                        	<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			                          <TD width="4%"><c:if test="${(permissionPo.keyb==1)}"><img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${item.msmuuid}')"></c:if></TD>
			                          <TD width="4%"><c:if test="${(permissionPo.keyc==1)}"><img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${item.msmuuid}')"></c:if></TD>
			                          <TD height="26">${item.msmshiftNumber}</TD>
			                          <TD>${item.msmshiftName}</TD>
			                          <TD>${item.msmworkLong}</TD>
			                          <TD>${item.msmworkBegin}-${item.msmworkEnd}</TD>
			                        </TR>
		                        </c:forEach>
		                        </c:if>
	                      </TBODY>
	                    </TABLE>
	                    <c:if test="${not empty(shiftMaintainPos)}">
                     <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					 <!-- END 分页 -->
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
    </BODY>
</html>