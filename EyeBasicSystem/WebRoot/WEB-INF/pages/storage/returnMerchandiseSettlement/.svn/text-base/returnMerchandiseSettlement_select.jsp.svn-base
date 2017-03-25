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
	  	returnMerchandiseSettlementForm.action=link;
	  	returnMerchandiseSettlementForm.submit();
	}
	function details(id){
		document.all.hid.value = id;
		showPopWin("","initReturnMerchandiseSettlementDetails.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}	
	function update(id){
		document.all.hid.value = id;
		showPopWin("","initReturnMerchandiseSettlementUpdate.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function search(){
		$("img").removeAttr("onclick");
		returnMerchandiseSettlementForm.action = "selReturnMerchandiseSettlement.action";
		returnMerchandiseSettlementForm.submit();
	}

	function clean(){
	    document.getElementById('billID').value = "";
		document.getElementById('sourceBillID').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('auditState').value = "";
		document.getElementById('selbspsuppliername').value = "";
		document.getElementById('instockID').value = "";
		document.getElementById('financeAuditPersonID').value = "";
		document.getElementById('financeAuditPersonName').value = "";
		document.getElementById('selcstpsupplierid').value = "";     
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		//showPopWin("","selSupplierOpen.action",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selcstpsupplierid').value = json.id;
		document.getElementById('selbspsuppliername').value = json.value;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="returnMerchandiseSettlementForm" method="post" action="">
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
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品退货结算</TD>
            <TD class=menubar_function_text align=right>
             &nbsp;
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
                      UNSELECTABLE="on">商品退货结算</TD>
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
			               <TD class="table_none" width="40%">
                            <input class="text_input200" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			                <TD width="60" height="30" class="table_body">订单编号</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="sourceBillID" name="sourceBillID" value="${requestScope.sourceBillID}">
			               </TD>
                        </TR>
                    	<TR>
			               <TD width="60" height="30" class="table_body">制造商</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input200" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <INPUT class=button_bak id=ctl00_PageBody_Button1 icon="icon-zoom" type=button value="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li>
						  </TD>
 						  <TD width="60" height="30" class="table_body">退货仓位</TD>
			              <TD class="table_none">
                            <select id="instockID" name="instockID">
                             <option value="">请选择退货仓位</option>
      		                 <s:iterator value="warehouseList">
				               <option value="${bwhid}" ${requestScope.instockID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
                        </TR>
                    	<TR>						  
			               <TD width="60" height="30" class="table_body">审核状态</TD>
			               <TD class="table_none">
                            <select name="auditState" value="${requestScope.auditState}">
                                    <option value="">请选择审核状态</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
			               <TD width="60" height="30" class="table_body">审核日期</TD>
			               <TD class="table_none">
                             <input class="text_input100"
				               id="startTime"
						       name="startTime" value="${requestScope.startTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime"
						       name="endTime" value="${requestScope.endTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
			               </TD>			               
                        </TR>
                    	<TR>
			                <TD width="60" height="30" class="table_body">财务审核人</TD>
			               <TD class="table_none" colspan="3">
	                            <input class="text_input200" type="text"  id="financeAuditPersonName" name="financeAuditPersonName" value="${requestScope.financeAuditPersonName}">
	                            <input class="text_input100" type="hidden"  id="financeAuditPersonID" name="financeAuditPersonID" value="${requestScope.financeAuditPersonID}">
			               </TD>
                        </TR>                        
                      </TBODY>
                    </TABLE>
                     <c:if test="${permissionPo.keyb=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					</c:if>
					<c:if test="${not empty(returnMerchandiseSettlementList)}"> 
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
                          <TH width="17%" height="30" scope=col>单据编号</TH>
						  <TH width="13%" scope=col>订单编号</TH>						
                          <TH width="12%" scope=col>制造商</TH>
						  <TH width="11%" scope=col>商品类型</TH>
						  <TH width="10%" scope=col>退货仓位</TH>
						  <TH width="10%" scope=col>审核状态</TH>
						  <TH width="10%" scope=col>审核人</TH>
						  <TH width="8%" scope=col>单据日期</TH>
						  <TH width="8%" scope=col>审核日期</TH>
						   <c:if test="${permissionPo.keye=='1'}">
						  <TH width="8%" scope=col>详细</TH>
						  </c:if>
						   <c:if test="${permissionPo.keyc=='1'}">
						  <TH width="8%" scope=col>修改</TH>
						  </c:if>
						  </TR>
						 <s:iterator value="returnMerchandiseSettlementList">
						 <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD height="28">${cstibillid}</TD>
	                          <TD>${cstisourcebillid}</TD>
	                          <TD>${cstisuppliername}</TD>
	                          <TD>
	                           <c:choose>
				               	<c:when test="${cstibilltypeid=='1'}">
				               		采购收货
				               	</c:when>
				               	<c:when test="${cstibilltypeid=='2'}">
				               		商品退货
				               	</c:when>
				               	<c:when test="${cstibilltypeid=='7'}">
				               		其他入库
				               	</c:when>
				               	<c:when test="${cstibilltypeid=='9'}">
				               		委外收货
				               	</c:when>
				               	<c:otherwise>
				               		未知单据
				               	</c:otherwise>
				               </c:choose>
	                          </TD>
	                          <TD>${cstiinstockname}</TD>
	                          <TD>
	                          <c:choose>
	                          	<c:when  test="${cstifinanceauditstate==1}">
	                          		已审核
	                          	</c:when>
                          		<c:otherwise>
				               		未审核
				               	</c:otherwise>
	                          </c:choose>
	                          </TD>
	                          <TD>${cstifinanceauditpersonname}</TD>
                          	  <TD>${fn:substring(cstibilldate,0,10)}</TD>
                          	  <TD>${fn:substring(cstifinanceauditdate,0,10)}</TD>
                          	   <c:if test="${permissionPo.keye=='1'}">
	                          <TD>
	                          <c:if test="${cstifinanceauditstate==0}">
	                             <input type='button' value='详细'  disabled="disabled">
	                          </c:if>
	                          <c:if test="${cstifinanceauditstate!=0}">
	                             <input type='button' value='详细' onClick="javascript:details('${cstibillid}')">
	                          </c:if>
			                  </TD>
			                  </c:if>
			                   <c:if test="${permissionPo.keyc=='1'}">
			                  <TD>
			                  <c:if test="${cstifinanceauditstate==1}">
	                             <input icon='icon-edit' type='button' value='修改' disabled="disabled">
	                          </c:if>
	                          <c:if test="${cstifinanceauditstate!=1}">
	                             <input icon='icon-edit' type='button' value='修改' onClick="javascript:update('${cstibillid}')">
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