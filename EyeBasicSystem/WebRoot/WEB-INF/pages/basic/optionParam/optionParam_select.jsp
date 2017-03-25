<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下拉值维护</title>
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
		$("img").removeAttr("onclick");
		optionParamForm.action = "selOptionParam.action";
		optionParamForm.submit();
		showLoadingBar();
	}
	
	function clean(){
		document.getElementById('opModule').value = "";
		document.getElementById('opname').value = "";
	}	
	
	function update(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){
			showPopWin("initOptionParamUpdate.action?fopparamid=" +id+"&moduleID="+document.all.moduleID.value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initOptionParamUpdate.action?fopparamid=" +id+"&moduleID="+document.all.moduleID.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【下拉值修改】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		
		if(is_iPad()){
			showPopWin("initOptionParamInsert.action?moduleID="+document.all.moduleID.value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initOptionParamInsert.action?moduleID="+document.all.moduleID.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【下拉值新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		
		if(is_iPad()){
			showPopWin("initOptionParamDelete.action?hid="+id+"&moduleID="+document.all.moduleID.value,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initOptionParamDelete.action?hid="+id+"&moduleID="+document.all.moduleID.value,400,140,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【下拉值删除】";
	}	
	
	function showMin(fopparamid){
		
		optionParamForm.action = "selOptionParam.action?pageNo=${pagination.pageNo}&fopparamid="+fopparamid;
		optionParamForm.submit();
	}	

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="optionParamForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息维护</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：下拉值维护</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            		<img src="${ctx }/img/newbtn/btn_addxlsj_0.png" btn=btn title="下拉值新增" onClick="insert()">
            	</c:if>
            </td>
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
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </table>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD height="26" class="table_body">所属模块</TD>
                          <TD class="table_none">&nbsp;
                                <select name="opModule" id="opModule">
		                          <option value="">----请选择----</option>
		                          <s:iterator value="moduleList">
		                              <option value="${moduleid}" ${opModule == moduleid ? 'selected="selected"' : '' }>(${moduleid})${modulecname}</option>
		                          </s:iterator>
		                        </select>
                          </TD>
                          <TD width="8%" height="26" class="table_body">主值名称</TD>
                          <TD class="table_none"><input class="text_input200" id="opname" name="opname" value="${opname}"></TD>
                        </TR>   
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="10">						
						<c:if test="${(permissionPo.keyd==1)}"> 
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
	                       		<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
	                        </td>
	                    </c:if>	                       
						</tr>
					</table>	
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(optionParamMaxList)}">								
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
                         <TH width="6%" scope=col colspan="2">操作</TH>                         
                         <TH width="10%" height="26" scope=col>展开/折叠</TH>
                         <TH  width="15%" scope=col>下拉值编号</TH>
                         <TH  width="15%" scope=col>所属模块</TH>
                         <TH scope=col>下拉值名称</TH>
                        </TR>
                        <s:iterator value="optionParamMaxList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                		  	<c:if test="${(permissionPo.keyb==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${fopparamid}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyc==1)}">
		                  	<c:choose>
                          	<c:when test="${minCount!='0'}">
                          	</c:when>
                        	<c:otherwise>
		               		 <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${fopparamid}')">
			               	</c:otherwise>
	                        </c:choose>
                            </c:if> 
		                  </TD>
                          <TD height="26">
                           <c:choose>
                          	<c:when test="${requestScope.fopparamidpage==fopparamid}">
                          		<a href="#" onClick="javascript:showMin('')">折叠(${minCount})</a>
                          	</c:when>
                        	<c:otherwise>
		               			<a href="#" onClick="javascript:showMin('${fopparamid}')">展开(${minCount})</a>
			               	</c:otherwise>
	                       </c:choose>
                          </TD>
                          </when>
                          <TD height="26">${fopparamid}</TD>
                          <TD height="26">${fopmodulename}</TD>
                          <TD height="26">${fopparamname}</TD>
                        </TR>
		                 <c:if test="${requestScope.fopparamidpage == fopparamid}">
	                        <c:if test="${not empty(optionParamMinList)}">
	                        	<s:iterator value="optionParamMinList">
			                        <TR>
			                          <TD width="4%" align="center">
					                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${fopparamid}')">
					                  </TD>
					                  <TD width="4%" align="center">
			                             <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${fopparamid}')">
					                  </TD>
			                          <TD height="26">&nbsp;</TD>
			                          <TD height="26">${fopparamid}</TD>
			                          <TD height="26">&nbsp;</TD>			                          
			                          <TD height="26" align="center">${fopparamname}</TD>
			                          <TD align="center">${foptype}</TD>

			                        </TR>
			                     </s:iterator>
	                        </c:if>
	                    </c:if>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>