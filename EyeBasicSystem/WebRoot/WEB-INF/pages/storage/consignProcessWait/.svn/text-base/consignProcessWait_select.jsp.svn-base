<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购收货管理</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> 
<!-- jquery.autocomplete end -->

<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	procurementWaitForm.action=link;
	  	procurementWaitForm.submit();
	}
	function update(cstcpoorderbillid, cstcposupplierid, cstcpoordergoodscategory){
		
		showPopWin("","initConsignProcessWaitUpdate.action?cstcpoorderbillid="+cstcpoorderbillid+"&cstcposupplierid="+cstcposupplierid+"&cstcpoordergoodscategory="+cstcpoordergoodscategory,
			screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function search(){
		document.all.submitButton.disabled="true";
		procurementWaitForm.action = "selConsignProcessWait.action";
		procurementWaitForm.submit();
	}	
	function clean(){
		document.getElementById('billid').value = "";
		document.getElementById('bspsuppliername').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('cstcpoordergoodscategory').value = "";
		document.getElementById('createPersonName').value = "";
		document.getElementById('cstcpocreateperson').value = "";
		document.getElementById('auditPersonName').value = "";
		document.getElementById('cstcpoauditperson').value = "";
	}
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		//showPopWin("","selSupplierOpen.action?categoryID_open=" + document.all.cstcpoordergoodscategory.value,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.cstcpoordergoodscategory.value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.cstcpoordergoodscategory.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('cstcposupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementWaitForm" method="post" action="">
<input type="hidden" name="cstpid">
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
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>委外收货管理</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：待委外收货的订单查询</TD>
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
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initConsignProcessReceiptSel.action';"
                      UNSELECTABLE="on">委外收货查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">待委外收货的订单查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    </TR></TBODY></TABLE></TD>
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
						   <TD width="%15" height="30" class="table_body">委外订单编号</TD>
			               <TD width="%35" class="table_none">
                            <input class="text_input200" type="text"  id="billid" name="billid" value="${billid}">
			               </TD>
			               <TD width="%15" height="30" class="table_body">单据日期</TD>
			               <TD width="%35" class="table_none">
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
			               
                        </TR>
                        <TR>
                        <TD width="%15" class="table_body">所属制造商</TD>
						   	<TD width="%35" height="30" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input200" name="bspsuppliername" value="${bspsuppliername }" readonly="readonly" />
						   	</li>
						   	<li class="horizontal_onlyRight">	
						   		<INPUT class=button_bak id=ctl00_PageBody_Button1 icon="icon-zoom" type=button value="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();">
						   		<input type="hidden" id="cstcposupplierid" name="cstcposupplierid" value="${cstcposupplierid }" />
						   	</li>
						 </TD>
						  <TD class="table_body" height="30">订单类型</TD>
                          <TD class="table_none">
						  <select name="cstcpoordergoodscategory">
						  		<option value="">请选择订单类型</option>
				  				<option value="2" ${cstcpoordergoodscategory == 2 ? 'selected="selected"' : '' }>框镜订做片</option>
				  				<option value="4" ${cstcpoordergoodscategory == 4 ? 'selected="selected"' : '' }>隐形订做片</option>
						  </select>
						  </TD>
                        </TR>   
                        <TR>
                          <TD width="%15" class="table_body" height="30">制单人</TD>
                          <TD width="%35" class="table_none">
                          <input class="text_input200" id="createPersonName" name="createPersonName" value="${createPersonName }">
                          <input type="hidden" class="text_input100" id="cstcpocreateperson" name="cstcpocreateperson" value="${cstcpocreateperson }">
                          </TD>
                          <TD width="%15" class="table_body">审核人</TD>
                          <TD width="%35" class="table_none">
                          <input class="text_input200" id="auditPersonName" name="auditPersonName" value="${auditPersonName }">
                          <input type="hidden" class="text_input100" id="cstcpoauditperson" name="cstcpoauditperson" value="${cstcpoauditperson }">
                          </TD>
                        </TR>             
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					<c:if test="${not empty(consignProcessOrderList)}"> 
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
                          <TH width="10%" height="30" scope=col>委外订单编号</TH>
						  <TH width="10%" scope=col>采购日期</TH>						
						  <TH width="12%" scope=col>制造商</TH>
						  <TH width="10%" scope=col>制单人</TH>
						  <TH width="10%" scope=col>审核人</TH>
						  <TH width="6%" scope=col>转单</TH>
						  </TR>
						<c:forEach var="i" items="${consignProcessOrderList}" varStatus="index"> 
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28">${i.cstcpoorderbillid}</TD>
                          <TD>${fn:substring(i.cstcpobilldate,0,10)}</TD>
                          <TD>${i.bspsuppliername}
                          </TD>
                          <TD>${i.createPersonName}</TD>
                          <TD>${i.auditPersonName}</TD>
                          <TD>
		                     <input type='button' icon='icon-edit' value='转委外收货单' onClick="javascript:update('${i.cstcpoorderbillid}', '${i.cstcposupplierid}', '${ i.cstcpoordergoodscategory}')">
		                  </TD>
						</TR>
						</c:forEach>						  
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