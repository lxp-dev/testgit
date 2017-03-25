<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统模块维护</title>
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
		moduleSystemForm.action = "selSystemModule.action";
		moduleSystemForm.submit();
	}
	function clean(){
	}	
	
	function update(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){
			showPopWin("initSystemModuleUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSystemModuleUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【系统模块修改】";
		//showPopWin("","initNonconformingProductUpdate.action?hid="+id+"&moduleID=${moduleID}",screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){
			showPopWin("initSystemModuleInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSystemModuleInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【系统模块新增】";
	}
	function initImport(){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){
			showPopWin("initSystemModuleImport.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSystemModuleImport.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【系统模块导入】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		showPopWin("initSystemModuleDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,220,topRows,topCols,returnRefresh(true)); 
		document.getElementById('popupTitle').innerHTML="【系统模块删除】";
		//showPopWin("","initNonconformingProductDelete.action?hid="+id+"&moduleID=${moduleID}",400,220, '',null,true);
		//selectHidden();
	}	
	
	function disableModuleSystem(id){
		//showPopWin("","initSupplierDisable.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,220, '',null,true);
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		showPopWin("initSystemModuleDisable.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,220,topRows,topCols,returnRefresh(true)); 
		document.getElementById('popupTitle').innerHTML="【系统模块停用】";
	}
	
	function ableModuleSystem(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		showPopWin("initSystemModuleAble.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,220,topRows,topCols,returnRefresh(true)); 
		document.getElementById('popupTitle').innerHTML="【系统模块启用】";
	}
	
	function showMin(moduleid){
		
		moduleSystemForm.action = "selSystemModule.action?moduleid="+moduleid;
		moduleSystemForm.submit();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统设置</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：系统模块维护 </TD>
            <TD align="right">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_xtmkadd_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_xtmkadd_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_xtmkadd_0.png');" title="系统模块新增" onClick="initImport()">            	
            	</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            &nbsp;
            </TD>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
					<form name="moduleSystemForm" method="post" action="">
						<input type="hidden" name="type" id="type" value="" />
						<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
					</form>				
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <c:if test="${not empty(modulePoMaxList)}">
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                        <TH width="8%" scope=col colspan="2">操作</TH>
                         <TH width="10%" height="30" scope=col>展开/折叠</TH>
                         <TH width="10%" scope=col>模块ID</TH>
                          <TH width="30%" scope=col>模块名称</TH>
                          <TH width="10%" scope=col>顺序</TH>
                           <TH width="30%" scope=col>描述</TH>
                          
                        </TR>
                        <s:iterator value="modulePoMaxList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                         <td width="4%"><img src="${ctx }/img/newbtn/unenabled_2.png" title='不可用'>
                         </td>
                		 <TD width="4%">
		                     <img src="${ctx }/img/newbtn/edit_0.png" title='修改' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/edit_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/edit_0.png');" onClick="javascript:update('${moduleid}')">
		                  </TD>

                          <TD height="28">
                           <c:choose>
                          	<c:when test="${requestScope.moduleidpage==moduleid}">
                          		<a href="#" onClick="javascript:showMin('')"><b>折叠(${minCount})</b></a>
                          	</c:when>
                        	<c:otherwise>
		               			<a href="#" onClick="javascript:showMin('${moduleid}')"><b>展开(${minCount})</b></a>
			               	</c:otherwise>
	                       </c:choose>
                          </TD>
                          </when>
                          <TD height="26">${moduleid}</TD>
                          <TD height="26">${modulecname}</TD>
                          <TD height="26">${moduleorderlevel}</TD>
                          <TD height="26">${moduleDescribe}</TD>
                        </TR>
                        <c:if test="${requestScope.moduleidpage == moduleid}">
	                        <c:if test="${not empty(modulePoMinList)}">
	                        	<s:iterator value="modulePoMinList">
			                        <TR class="row" >
			                         <td width="4%" align="center">

									<c:if test="${moduleapplicationid==1}">
									<img src="${ctx }/img/newbtn/enabled_0.png" title='停用' btn=btn onClick="javascript:disableModuleSystem('${moduleid}')">
									</c:if>
									<c:if test="${moduleapplicationid==0}">
										<img src="${ctx }/img/newbtn/unenabled_0.png" title='启用' btn=btn onClick="javascript:ableModuleSystem('${moduleid}')">
								</c:if>

			                         </td>
			                		 <TD align="center" width="4%">
					                     <img src="${ctx }/img/newbtn/edit_0.png" title='修改' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/edit_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/edit_0.png');" onClick="javascript:update('${moduleid}')">
					                  </TD>

			                          <TD height="26">&nbsp;</TD>
			                          <TD>${moduleid}</TD>
			                         <TD height="26">${modulecname}</TD>
			                          <TD height="26">${moduleorderlevel}</TD>
			                          <TD height="26">${moduleDescribe}</TD>
			                          
			                        </TR>
			                     </s:iterator>
	                        </c:if>
	                    </c:if>
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
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>