<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退货管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	returnMerchandiseManagementForm.action=link;
	  	returnMerchandiseManagementForm.submit();
		showLoadingBar();
	}
	function update(id){
		document.all.hid.value = id;
		showPopWin("","initReturnMerchandiseManagementUpdate.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function search(){
		$("img").removeAttr("onclick");
		returnMerchandiseManagementForm.action = "selReturnMerchandiseManagement.action";
		returnMerchandiseManagementForm.submit();
		showLoadingBar();
	}	
	function details(id){
		document.all.hid.value = id;
		showPopWin("","returnMerchandiseManagementDetails.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function insert(){
		showPopWin("","initReturnMerchandiseManagementInsert.action",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	
	function insertOther(){
		showPopWin("","initOtherReceiptInsert.action",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function del(id){
		showPopWin("","initReturnMerchandiseManagementDelete.action?hid="+id,400,250, '',null,true);
		selectHidden();
	}

	function clean(){
	    document.all.billID.value="";
	    document.all.sourceBillID.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.instockID.value="";
	    document.all.auditState.value="";
	    document.all.createPersonName.value="";
	    document.all.createPersonID.value="";
	    document.all.auditPersonName.value="";
	    document.all.auditPersonID.value="";
	    document.all.auditStartDate.value="";
	    document.all.auditEndDate.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<!--oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;"-->
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="returnMerchandiseManagementForm" method="post" action="">
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
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>退货管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品退货查询</TD>
            <TD class=menubar_function_text align=right>
             <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
               <c:if test="${permissionPo.keya=='1'}">
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="insert();" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/New.gif" align=textTop 
                  border=0>&nbsp;商品退货新增</TD>
                  </c:if>
             </TR></TBODY></TABLE>
            </TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">商品退货查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="60" height="30" class="table_body">单据编号</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			               <TD width="60" height="30" class="table_body">关联订单号</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="sourceBillID" name="sourceBillID" value="${requestScope.sourceBillID}">
			               </TD>
                        </TR>
                    	<TR>
                    	   <TD width="10%" height="30" class="table_body">单据日期</TD>
			               <TD class="table_none" width="26%">
                           <input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /></TD>
						   <TD width="10%" height="30" class="table_body">审核状态</TD>
			               <TD class="table_none">
                              <select name="auditState" value="${requestScope.auditState}">
                                    <option value="">请选择审核状态</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
                        </TR>
                        <TR>
						   <TD width="60" height="30" class="table_body">制单人</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="createPersonName" name="createPersonName" value="${requestScope.createPersonName}">
                            <input  type="hidden"  id="createPersonID" name="createPersonID" value="${requestScope.createPersonID}">
			               </TD>
			               <TD width="60" height="30" class="table_body">审核人</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="auditPersonName" name="auditPersonName" value="${requestScope.auditPersonName}">
                            <input type="hidden"  id="auditPersonID" name="auditPersonID" value="${requestScope.auditPersonID}">
			               </TD>
                        </TR>
                    	<TR>
						   <TD width="60" height="30" class="table_body">退货仓位</TD>
			               <TD class="table_none">
                            <select id="instockID" name="instockID">
                             <option value="">请选择退货仓位</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${requestScope.instockID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
			                <TD width="60" height="30" class="table_body">审核日期</TD>
			               <TD class="table_none">
                           <input id="auditStartDate"
					       name="auditStartDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'auditEndDate\')}'})"
					       value="${auditStartDate }" /> 至 
					       <input id="auditEndDate"
					       name="auditEndDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'auditStartDate\')}'})" 
					        value="${auditEndDate }" /></TD>
                        </TR>
                                                 
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyb=='1'}">
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
							</td>
						</tr>
					</table></c:if>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->	
					<c:if test="${not empty(returnMerchandiseManagementList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="30" scope=col>单据编号</TH>
						  <TH width="10%" scope=col>关联订单号</TH>						
						  <TH width="12%" scope=col>退货仓位</TH>
						  <TH width="10%" scope=col>单据日期</TH>
						  <TH width="10%" scope=col>入库日期</TH>
						  <TH width="9%" scope=col>审核状态</TH>
						  <TH width="10%" scope=col>制单人</TH>
						  <TH width="10%" scope=col>审核人</TH>
						   <c:if test="${permissionPo.keye=='1'}">
						  <TH width="6%" scope=col>详细</TH>
						  </c:if>
						   <c:if test="${permissionPo.keyc=='1'}">
						  <TH width="6%" scope=col>修改</TH>
						  </c:if>
						   <c:if test="${permissionPo.keyd=='1'}">
						  <TH width="6%" scope=col>删除</TH>
						  </c:if>
						  </TR>
						<s:iterator value="returnMerchandiseManagementList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28">${cstibillid}</TD>
                          <TD>${cstisourcebillid}</TD>
                          <TD>${cstiinstockname }</TD>
                          <TD>${fn:substring(cstibilldate,0,10)}</TD>
                          <TD>${fn:substring(cstiauditdate,0,10)}</TD>
                          <TD>
                          <c:if test="${cstiauditstate==1}">
                              已审核
                          </c:if>
                          <c:if test="${cstiauditstate==0}">
                              未审核
                          </c:if>
                          </TD>
                          <TD>${csticreatepersonname}</TD>
                          <TD>${cstiauditpersonname}</TD>
                           <c:if test="${permissionPo.keye=='1'}">
                          <TD>
		                     <input type='button' value='详细' onClick="javascript:details('${cstibillid}')">
		                  </TD>
		                  </c:if>
		                   <c:if test="${permissionPo.keyc=='1'}">
		                  <TD>
		                  <c:if test="${cstiauditstate==1}">
                             <input icon='icon-edit' type='button' value='修改' disabled="disabled">
                          </c:if>
                          <c:if test="${cstiauditstate==0}">
                             <input icon='icon-edit' type='button' value='修改' onClick="javascript:update('${cstibillid}')">
                          </c:if>
		                     
		                  </TD>
		                  </c:if>
		                   <c:if test="${permissionPo.keyd=='1'}">
		                  <TD>
		                  <c:if test="${cstiauditstate==1}">
                             <input icon='icon-delete' type='button' value='删除'  disabled="disabled">
                          </c:if>
                          <c:if test="${cstiauditstate==0}">
                             <input icon='icon-delete' type='button' value='删除' onClick="javascript:del('${cstibillid}')">
                          </c:if>		                     
		                  </TD>
		                  </c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>