<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>不合格品现象维护</title>
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
	

	function search(){
		vouchertempletForm.action = "initVoucherTempletSel.action";
		vouchertempletForm.submit();
	}

	function insert(id,name){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		
		if(is_iPad()){
			showPopWin("initVoucherTempletInsert.action?moduleID="+document.all.moduleID.value+"&voucherTempletID="+id+"&voucherTempletName="+EncodeUtf8(name),970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initVoucherTempletInsert.action?moduleID="+document.all.moduleID.value+"&voucherTempletID="+id+"&voucherTempletName="+EncodeUtf8(name),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【凭证模板新增】";
	}
	
	function showMin(fnpid){
		
		vouchertempletForm.action = "initVoucherTempletSel.action?fnpid="+fnpid;
		vouchertempletForm.submit();
	}	

	function showLoadingBar(){
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="vouchertempletForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>帐套管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：凭证模板维护</TD>
            <td align="right" valign="bottom">&nbsp;</td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
									
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                         <TH width="3%" scope=col>操作</TH>                         
                         <TH width="10%" height="26" scope=col>展开/折叠</TH>
                          <TH scope=col>凭证类型</TH>
                        </TR>
                        <s:iterator value="voucherTopIDList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="4%">&nbsp;</TD>
                          <TD height="26">
                           <c:choose>
                          	<c:when test="${requestScope.fnpidpage==sLvtvtId}">
                          		<a href="#" onClick="javascript:showMin('')">折叠(${sLvtvtMinCount})</a>
                          	</c:when>
                        	<c:otherwise>
		               			<a href="#" onClick="javascript:showMin('${sLvtvtId}')">展开(${sLvtvtMinCount})</a>
			               	</c:otherwise>
	                       </c:choose>
                          </TD>
                          </when>
                          <TD height="26">${sLvtvtTypeName}</TD>
                        </TR>
		                 <c:if test="${requestScope.fnpidpage == sLvtvtId}">
	                        <c:if test="${not empty(voucherSubsetIDList)}">
	                        	<s:iterator value="voucherSubsetIDList">
			                        <TR>
			                          <TD width="4%" align="center">
					                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:insert('${sLvtvtId}','${sLvtvtTypeName}')">
					                  </TD>                      
			                          <TD height="26">&nbsp;</TD>
			                          <TD height="26" align="center">${sLvtvtTypeName}</TD>
			                        </TR>
			                     </s:iterator>
	                        </c:if>
	                    </c:if>
                        </s:iterator>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>