<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓位维护</title>
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
		warehouseForm.action = "selWarehouse.action";
		warehouseForm.submit();		
		showLoadingBar();
	}
	function clean(){
	    warehouseForm.bwhid.value="";
	    warehouseForm.bwhdeptid.value="";
	    warehouseForm.bwhwarehouseName.value="";
	}	
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateWarehouse.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateWarehouse.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【仓位更新】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertWarehouse.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertWarehouse.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【仓位新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteWarehouse.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteWarehouse.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【仓位删除】";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function ableWarehouse(id,name,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWarehouseAble.action?bwhid="+id+"&moduleID=${requestScope.moduleID}&flag="+flag+"&bwhname="+EncodeUtf8(name),400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initWarehouseAble.action?bwhid="+id+"&moduleID=${requestScope.moduleID}&flag="+flag+"&bwhname="+EncodeUtf8(name),400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【仓位启用/停用】";
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="warehouseForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：仓位维护</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            		<img src="${ctx }/img/newbtn/btn_warehouseinsert_0.png" title="仓位新增" btn=btn onClick="insert()">
            	</c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');" />
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
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						  <TD width="8%" height="26" class="table_body">仓位代码</TD>
			              <TD width="17%" class="table_none"><input class="text_input100" id="bwhid" name="bwhid" value="${requestScope.bwhidpage}"></TD>
						  <TD width="8%" height="26" class="table_body">仓位名称</TD>
                          <TD width="17%" class="table_none"><input class="text_input160" id="bwhwarehouseName" name="bwhwarehouseName" value="${requestScope.bwhwarehouseNamepage}"></TD>
                          <TD width="8%" height="26" class="table_body">所属部门</TD>
                          <TD width="17%" class="table_none">
                            <select id="bwhdeptid" name="bwhdeptid">
							<option value="">----请选择----</option>
							<c:if test="${not empty(departmentsList)}">
			               	  <s:iterator value="departmentsList">
                   	           <OPTION value="${bdpdepartmentid}">${bdpdepartmentname}</OPTION>
                   	          </s:iterator>
                   	        </c:if>
							</select>
                          </TD>
						  <TD width="8%" height="26" class="table_body">启用状态</TD>
			              <TD width="17%" class="table_none">
                            <select id="bwhisclosed" name="bwhisclosed">
								<option value="" ${(requestScope.bwhisclosedpage eq '')? 'selected' : ''}>----请选择----</option>
								<option value="0" ${(requestScope.bwhisclosedpage eq '0')? 'selected' : ''}>启用</option>
								<option value="1" ${(requestScope.bwhisclosedpage eq '1')? 'selected' : ''}>停用</option>
							</select>						  
						  </TD>                          
                        </TR>                    
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
						<c:if test="${(permissionPo.keyb==1)}">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" id="submitButton" btn=btn title='查询' onClick="javascript:search()">
	                       		<img src="${ctx }/img/newbtn/btn_empty_0.png" title="清空" btn=btn onClick="clean()">
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
                    <c:if test="${not empty(list)}">		
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
                          <TH width="9%" scope=col colspan="3">操作</TH>
                          <TH width="10%" height="26" scope=col>仓位代码</TH>
                          <TH width="25%" scope=col>仓位名称</TH>
                          <TH scope=col>所属部门</TH>
						  <TH width="10%" scope=col>排序</TH>                          
                        </TR>
                        <s:iterator value="list">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                		 	<c:if test="${(permissionPo.keyc==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${bwhid}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyd==1)}">
                              <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${bwhid}')">
		                  	</c:if>
		                  </TD>
						  <TD width="3%">
							<c:if test="${(permissionPo.keye==1)}">
								<c:if test="${bwhisclosed==0}">
									<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='停用' onClick="javascript:ableWarehouse('${bwhid}','${bwhwarehouseName}','1')">
								</c:if>
								<c:if test="${bwhisclosed==1}">
									<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='启用' onClick="javascript:ableWarehouse('${bwhid}','${bwhwarehouseName}','0')">
								</c:if>
							</c:if>
						  </TD>
                          <TD height="26">${bwhid}</TD>
                          <TD>${bwhwarehouseName}</TD>
                          <TD>${bdpdepartmentname}</TD>
                          <TD>${bwhordernumber}</TD>
                        </TR>
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
<script>
	var index_bwhdeptid = 0;
	var arr = document.all.bwhdeptid.options.length;
	for(i=0;i<arr;i++){
		if(document.all.bwhdeptid.options.options[i].value == '<c:out value="${requestScope.bwhdeptidpage}"/>'){
			document.all.bwhdeptid.options.selectedIndex = index_bwhdeptid;
			break;
		}
		index_bwhdeptid++;
	}
</script>