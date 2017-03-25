<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品负调拨管理</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!-- jquery.autocomplete end -->
<script>
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	allocationForm.action=link;
	  	allocationForm.submit();
		showLoadingBar();
	}
	function update(id){
		//var moduleID = document.getElementById('moduleID').value;
		//document.all.hid.value = id;
		//showPopWin("","initReAllocationUpdate.action?hid="+id+"&moduleID="+moduleID,screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		
		document.all.hid.value = id;
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initReAllocationUpdate.action?hid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initReAllocationUpdate.action?hid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【负调拨单更新】";
	}
	function search(){
		document.all.submitButton.disabled="true";
		allocationForm.action = "selReAllocation.action";
		allocationForm.submit();
		showLoadingBar();
	}	
	function details(id){
		//var moduleID = document.getElementById('moduleID').value;
		//document.all.hid.value = id;
		//showPopWin("","reAllocationDetails.action?hid="+id+"&moduleID="+moduleID,screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		document.all.hid.value = id;
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("reAllocationDetails.action?hid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("reAllocationDetails.action?hid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【负调拨单详细】";
	}
	function insert(){
		//var moduleID = document.getElementById('moduleID').value;
		//showPopWin("","initReAllocationInsert.action?moduleID="+moduleID,screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		var moduleID = $('inout[name=moduleID]').val();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initReAllocationInsert.action?moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initReAllocationInsert.action?moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【负调拨单新增】";
	}
	function del(id){
		//var moduleID = document.getElementById('moduleID').value;
		//showPopWin("","initReAllocationDelete.action?hid="+id+"&moduleID="+moduleID,400,220, '',null,true);
		//selectHidden();
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initReAllocationDelete.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initReAllocationDelete.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【负调拨单删除】";
	}

	function clean(){
	 	document.getElementById('billID').value = "";
		document.getElementById('departmentID').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('auditState').value = "";
		document.getElementById('consignState').value = "";
		document.getElementById('createPersonName').value = "";
		document.getElementById('createPersonID').value = "";
		document.getElementById('auditPersonName').value = "";
		document.getElementById('auditPersonID').value = "";
		document.getElementById('consigneePersonName').value = "";
		document.getElementById('consigneePersonID').value = "";
	   
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function selectContact(obj){
		var act = document.activeElement.id;
		
		if(act == "pageNos"&&event.keyCode==13){
			document.getElementById(act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
	}
	
	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
	
	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="allocationForm" method="post" action="">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>商品负调拨管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品负调拨查询</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<input icon="icon-add-row" type="button" value="商品负调拨新增" onClick="insert()">
				<input type="button" icon="icon-hide-inherited" value="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
						   <TD width="9%" height="26" class="table_body">负调拨单号</TD>
			               <TD class="table_none" width="22%">
                            <input class="text_input160" type="text"  id="billID" name="billID" value="${requestScope.billID}" onkeyup="selectContact(this)">
			               </TD>
						   <TD width="9%" height="26" class="table_body">申请部门</TD>
			               <TD class="table_none" width="23%">
                            <select id="departmentID" name="departmentID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">  <input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /> </li><li class="horizontal_onlyRight">
<INPUT class=button_bak icon="icon-zoom" type=button value="今天" onClick="today()"></li></TD>
                        </TR>
                    	<TR>
                    	   <TD height="26" class="table_body">审核状态</TD>
			               <TD class="table_none">
                              <select name="auditState" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
						   <TD height="26" class="table_body">收货确认</TD>
			               <TD class="table_none">
                              <select name="consignState" value="${requestScope.consignState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.consignState!= "1"  ? '' : 'selected="selected"' }>已收货</option>
							  		<option value="0" ${requestScope.consignState!= "0"  ? '' : 'selected="selected"' }>未收货</option>
	                          </select>
			               </TD>
						   <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="createPersonName" name="createPersonName" value="${requestScope.createPersonName}">
                            <input  type="hidden"  id="createPersonID" name="createPersonID" value="${requestScope.selcreatePersonID}">
			               </TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">收货人</TD>
			               <TD class="table_none">
                               <input class="text_input160" type="text"  id="consigneePersonName" name="consigneePersonName" value="${requestScope.consigneePersonName}">
                            <input  type="hidden"  id="consigneePersonID" name="consigneePersonID" value="${requestScope.selconsigneePersonID}">
			               </TD>
						   <TD height="26" class="table_body">审核人</TD>
			               <TD class="table_none" colspan="3">
                             <input class="text_input160" type="text"  id="auditPersonName" name="auditPersonName" value="${requestScope.auditPersonName}">
                            <input type="hidden"  id="auditPersonID" name="auditPersonID" value="${requestScope.selauditPersonID}">
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
					<c:if test="${not empty(allocationList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="26" scope=col>负调拨单号</TH>
						  <TH width="10%" scope=col>申请部门</TH>						
                          <TH width="10%" scope=col>制单人</TH>
						  <TH width="10%" scope=col>制单日期</TH>
						  <TH width="10%" scope=col>审核人</TH>
						  <TH width="10%" scope=col>审核时间</TH>
						  <TH width="10%" scope=col>收货人</TH>
						  <TH width="10%" scope=col>收货时间</TH>
						   <c:if test="${permissionPo.keye=='1'}">
						  <TH width="7%" scope=col>详细</TH>
						  </c:if>
						   <c:if test="${permissionPo.keyc=='1'}">
						  <TH width="7%" scope=col>修改</TH>
						  </c:if>
						   <c:if test="${permissionPo.keyd=='1'}">
						  <TH width="6%" scope=col>删除</TH>
						  </c:if>
						  </TR>
						<s:iterator value="allocationList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${cshaabillid}</TD>
                          <TD>${cshaaoutdepartmentname}</TD>
                          <TD>${cshaacreatepersonname}</TD>
                          <TD>${fn:substring(cshaabilldate,0,10)}</TD>
                          <TD>${cshaaauditpersonname}</TD>
                          <TD>${fn:substring(cshaaauditdate,0,10)}</TD>
                          <TD>${cshaaconsigneename}</TD>
                          <TD>${fn:substring(cshaaconsigndate,0,10)}</TD>
                           <c:if test="${permissionPo.keye=='1'}">
                          <TD>
		                     <input type='button' value='详细' onClick="javascript:details('${cshaabillid}')">
		                  </TD>
		                  </c:if>
		                   <c:if test="${permissionPo.keyc=='1'}">
		                  <TD>
		                  <c:if test="${cshaaauditstate==1 }">
                             <input icon='icon-edit' type='button' value='修改' disabled="disabled">
                          </c:if>
                          <c:if test="${cshaaauditstate==0}">
                             <input icon='icon-edit' type='button' value='修改' onClick="javascript:update('${cshaabillid}')">
                          </c:if>
		                     
		                  </TD>
		                  </c:if>
		                   <c:if test="${permissionPo.keyd=='1'}">
		                  <TD>
		                  <c:if test="${cshaaauditstate==1}">
                             <input icon='icon-delete' type='button' value='删除'  disabled="disabled">
                          </c:if>
                          <c:if test="${cshaaauditstate==0}">
                             <input icon='icon-delete' type='button' value='删除' onClick="javascript:del('${cshaabillid}')">
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