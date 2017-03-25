<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制造商合同管理</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
<!-- jquery.autocomplete end -->
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	personDiscountForm.action=link;
	  	personDiscountForm.submit();
		showLoadingBar();
	}
	function update(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initContractUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initContractUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【合同更新】";
	}
	function search(){
		personDiscountForm.action = "selPersonDiscount.action";
		personDiscountForm.submit();
		showLoadingBar();
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initContractInsert.action?moduleID=${requestScope.moduleID}&hid=${hid }",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initContractInsert.action?moduleID=${requestScope.moduleID}&hid=${hid }",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【合同新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initContractDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initContractDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【合同删除】";
	}
	
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("contractDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("contractDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【合同详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function mentSupplierPerson(){
		if('${supplierPo.bspsupplierpersonid }'){ 
			window.location.href='initPersonInfoUpdateSupplier.action?moduleID=B0105&hid=${hid }&flag=0';
		}else{
			window.location.href='initPersonInfoInsertSupplier.action?moduleID=B0105&hid=${hid }&flag=0';
		}
	}
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personDiscountForm" method="post" action="">
<input type="hidden" name="hid" value="${hid }">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="supplierID" id="supplierID" value="${supplierID }" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0 width="100%">
              <TBODY>
              <TR align="left"><!--?Start-->
				<TD width="110px">
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="90" align="center" class=tab id=tabLabel__1 <c:if test="${(requestScope.flag eq 1)}">onclick="JavaScript:window.location.href='supplierDetail.action?moduleID=${requestScope.moduleID}&hid=${requestScope.hid}';" </c:if>
                    <c:if test="${(requestScope.flag eq 0)}">onclick="JavaScript:window.location.href='initSupplierUpdate.action?moduleID=${requestScope.moduleID}&hid=${requestScope.hid}';" </c:if>
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">${requestScope.flag eq 1 ? '制造商详细' : '制造商修改'}</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                 </TD>
                 
                  <TD width="110px">
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif
                      onClick="mentSupplierPerson();" 
                      UNSELECTABLE="on">制造商维护人</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                    </TD>
                 
                 <TD width="105px">
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD width="90" align="center" class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">制造商合同</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                  </TD>
                  <TD width="110px">
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif
                      onClick="JavaScript:window.location.href='selAccount.action?moduleID=${requestScope.moduleID}&hid=${requestScope.hid}&flag=${requestScope.flag}' ;" 
                      UNSELECTABLE="on">制造商账款</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                    </TD>
                  <TD width="auto" align="right">
                	<c:if test="${requestScope.flag!='1'}">
                		<img src="${ctx }/img/newbtn/btn_contractinsert_0.png" title="合同新增" btn=btn onclick="insert();"/>
                	</c:if>&nbsp;
                  </TD>
				</TR></TBODY></TABLE>
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
																			<table width="100%" border=0 align=center
																				cellpadding=0 cellspacing=0 class="privateTable">
																				<TBODY>
																					<TR>
																						<TD width="5%">
																							<div>
																								<img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20">
																							</div>
																						</TD>
																						<TD width="95%"
																							background="${ctx}/img/pic/msgbg.png">&nbsp;
																					  </TD>
																					</TR>
																				</TBODY>
																			</TABLE>
																			<c:if test="${not empty(contractList)}">
																			<table width="100%" border=0 align=center
																				cellpadding=1 cellspacing=1 class="privateBorder">
																				<TBODY>
																					<TR class=table_title align=middle>
																					<c:if test="${requestScope.flag=='1'}">	
																						<TH width="12%" scope=col >操作</TH>	
																					</c:if>
																					<c:if test="${requestScope.flag=='0'}">	
																						<TH width="12%" scope=col colspan="3">操作</TH>
																					</c:if>	
																						
																						<TH width="20%" height="30" scope=col>合同标题</TH>
																						<TH width="35%" scope=col>合同内容</TH>
																						<TH width="15%" scope=col>合同时间</TH>
																					</TR>
																					<s:iterator value="contractList">
																						<TR class="row"
																							onMouseOver="mover(this,'#a2c1eb')"
																							onMouseOut=mout(this,'#cadee8');>
																							<TD>
																								<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:detail('${bctid}')">
																							</TD>	
																							<c:if test="${requestScope.flag!='1'}">																					
																								<TD>
																									
																										<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${bctid}')">
																								
																								</TD>
																								<TD>
																							
																										<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${bctid}')">
	
																								</TD>
																							</c:if>
																							<TD height="26">${bctcontracttitle}</TD>
																							<TD>${bctcontractcontent}</TD>
																							<TD>${fn:substring(bctcontractstartdate,0,10)}~${fn:substring(bctcontractenddate,0,10)}</TD>
																						</TR>
																					</s:iterator>
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
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR>
            </TBODY></TABLE><!--?? End--></TD></TR>
            
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
