<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行维护</title>
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
	  	mpostForm.action=link;
	  	mpostForm.submit();
	}
	
	function update(id)
	{
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateBankPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateBankPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【顾客非现金结款类型修改】";
	}
	
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		
		if(is_iPad()){
			showPopWin("initDeleteBankPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteBankPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【顾客非现金结款类型删除】";
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){
			showPopWin("initInsertBankPo.action?hid=" +id+"&moduleID="+document.all.moduleID.value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
            showPopWin("initInsertBankPo.action?hid=" + document.all.hid.value+"&moduleID="+document.all.moduleID.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true)); 
		}

		document.getElementById('popupTitle').innerHTML="【顾客非现金结款类型新增】";
	}
	
	function showLoadingBar(){
	}
	
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="mpostForm">
<input type="hidden" name="hid" id="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息维护</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：顾客非现金结款类型维护</TD>
            <td align="right" width="40%" valign="bottom">
            &nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            	<img src="${ctx }/img/newbtn/btn_brankCardinsert_0.png" btn=btn title="顾客非现金结款类型维护" onClick="insert()">        	
            	</c:if>
            </td>
     
          </TR>
           <TR>
	            <TD class=menubar_function_text colspan="3">
	            	<table></table>
	            </TD>
	          </TR>
	        <TR>
	          <TD colSpan=2 height=10></TD>
         </TR>
          
        </TBODY>
      </TABLE>
      
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="10"><td></td></tr>
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
		                          <TH width="16%" height="26" scope=col>类型编号</TH>
		                          <TH width="22%" scope=col>类型名称</TH>
		                          <TH width="22%" scope=col>所属类型</TH>
		                          <!-- <TH width="22%" scope=col>参与业绩统计</TH> -->
		                        </TR>
		                        <c:if test="${not empty(BankPos)}">
		                        <c:forEach items="${bankPos}" var="item" varStatus="lineNum"> 
		                        	<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			                          <TD width="4%"><c:if test="${(permissionPo.keyb==1)}"><img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${item.bbuuid}')"></c:if></TD>
			                          <TD width="4%"><c:if test="${(permissionPo.keyc==1)}"><img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${item.bbuuid}')"></c:if></TD>
			                          <TD height="26">${item.bbnumber}</TD>
			                          <TD>${item.bbname}</TD>
			                          <TD>
			                              <c:if test="${item.bbtype eq '1'}">储值卡</c:if>
			                              <c:if test="${item.bbtype eq '2'}">银行卡</c:if>
			                              <c:if test="${item.bbtype eq '3'}">积分</c:if>
			                              <c:if test="${item.bbtype eq '4'}">代金券</c:if>
			                              <c:if test="${item.bbtype eq '5'}">支付宝</c:if>
			                              <c:if test="${item.bbtype eq '6'}">储蓄</c:if>
			                              <c:if test="${item.bbtype eq '7'}">结算卡</c:if>
			                              <c:if test="${item.bbtype eq '8'}">现金</c:if>
			                              <c:if test="${item.bbtype eq '9'}">其他</c:if>	&nbsp;		                          
			                          </TD>
			                       <!--    <TD><c:if test="${item.bbstatistics eq '1'}">参与</c:if><c:if test="${item.bbstatistics ne '1'}">未参与</c:if>&nbsp;</TD> -->
			                        </TR>
		                        </c:forEach>
		                        </c:if>
	                      </TBODY>
	                    </TABLE>
	                    <c:if test="${not empty(bankPos)}">
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