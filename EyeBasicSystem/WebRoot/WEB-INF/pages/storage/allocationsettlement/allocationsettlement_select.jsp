<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品调拨管理</title>
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

	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initAllocationSettlementInsert.action?hid="+id+"&moduleID="+$('#moduleID').val()+"&allactionflag="+$('#allactionflag').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initAllocationSettlementInsert.action?hid="+id+"&moduleID="+$('#moduleID').val()+"&allactionflag="+$('#allactionflag').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【调拨结算单更新】";
	}
	function search(){
		$("img").removeAttr("onclick");
		allocationForm.action = "selAllocationSettlement.action";
		allocationForm.submit();
		showLoadingBar();
	}	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initAllocationSettlementDetail.action?hid="+id+"&moduleID="+$('#moduleID').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initAllocationSettlementDetail.action?hid="+id+"&moduleID="+$('#moduleID').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨结算单详细】";
	}

	function clean(){
		$('input[clean=clean]').each(function(){
            $(this).val('');
        });
		$('select[clean=clean]').each(function(){
            $(this).val('');
        });
	    document.all.remark.value=""; 
	    $('#autoAllocationFlag').val('1');
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
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
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
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="allocationForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="departmenttype" name="departmenttype" value="${departmenttype}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品调拨结算管理</TD>
            <td align="right" valign="bottom">&nbsp;
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="6%" height="26" class="table_body">调拨单号</TD>
			               <TD class="table_none" width="25%">
                            <input clean=clean class="text_input160" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			                <TD width="9%" height="26" class="table_body">发出部门</TD>
			               <TD class="table_none" width="22%">
                            <select clean=clean id="departmentIDout" name="departmentIDout">
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="indepartmentsList1">
                    	           <OPTION value="${bdpdepartmentid}" ${departmentIDout!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
      	                    </select>
			               </TD>
						   <TD width="9%" height="26" class="table_body">接收部门</TD>
			               <TD class="table_none" width="22%">
	                            <select clean=clean id="departmentID" name="departmentID">
	      		                 	<option value="">----请选择----</option>	                             	
					               	<s:iterator value="departmentsList">
	                    	           <OPTION value="${bdpdepartmentid}" ${departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
	                    	        </s:iterator>
	      	                    </select>
			               </TD>
                        </TR>
                    	<TR>
                    	 <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input80" clean=clean  
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime" clean=clean 
					       name="endTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /> </li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li></TD>
							
                    	   <TD height="26" class="table_body">结算状态</TD>
			               <TD class="table_none" colspan="3">
                              <select clean=clean name="auditState" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已结算</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未结算</option>
	                          </select>
			               </TD>
                        </TR>
                        
                        <TR>
                          <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text" id="createPersonID" name="createPersonID" value="${requestScope.selcreatePersonID}">
			               </TD>
						   <TD height="26" class="table_body">收货人</TD>
			               <TD class="table_none">
                            <input  clean=clean class="text_input160" type="text"  id="consigneePersonID" name="consigneePersonID" value="${requestScope.selconsigneePersonID}">
			               </TD>
							<TD height="26" class="table_body">审核人</TD>
			               <TD class="table_none">
                            <input clean=clean type="text" class="text_input160" id="auditPersonID" name="auditPersonID" value="${requestScope.selauditPersonID}">
			               </TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || person.departmenttype != '1'}">
                        <TR>
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input clean=clean id="supplierName" class="text_input160" readonly="readonly" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input clean=clean type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li>
			               </TD>
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openBrand();"></li>
						  
			               </TD>
			            </TR>
			            </c:if>
                        
                        <TR>
                          <c:if test="${systemParameterPo.fspisallocationcategory eq '1'}">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
			                <div id="goodscategoryname"></div>
                            <select id="goodscategoryID" name="goodscategoryID" clean=clean>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"':'' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>	
                          <TD height="26" class="table_body">商品代码</TD>
                          <TD class="table_none">
                              <input class="text_input200" id="goodsID" name="goodsID" value="${goodsID}" maxlength="100" clean=clean>
                          </TD>   
                           <TD width="6%" height="26" class="table_body">调拨类型</TD>
			               <TD class="table_none" width="25%">
                              <select clean=clean name="autoAllocationFlag" id="autoAllocationFlag">
                                    <option value="1" ${requestScope.autoAllocationFlag == '1'  ? 'selected="selected"' : '' }>正常调拨</option> 
                                    <option value="2" ${requestScope.autoAllocationFlag == '2'  ? 'selected="selected"' : '' }>全部调拨</option>                                                                       							  		
							  		<option value="0" ${requestScope.autoAllocationFlag == '0'  ? 'selected="selected"' : '' }>自动调拨</option>
	                          </select>
			               </TD>
			              </c:if>
			              <c:if test="${systemParameterPo.fspisallocationcategory ne '1'}">
                          <TD height="26" class="table_body">商品代码</TD>
                          <TD class="table_none">
                              <input class="text_input200" id="goodsID" name="goodsID" value="${goodsID}" maxlength="100" clean=clean>
                          </TD>   
                           <TD width="6%" height="26" class="table_body">调拨类型</TD>
			               <TD class="table_none" width="25%" colspan="3">
                              <select clean=clean name="autoAllocationFlag" id="autoAllocationFlag">
                                    <option value="1" ${requestScope.autoAllocationFlag == '1'  ? 'selected="selected"' : '' }>正常调拨</option> 
                                    <option value="2" ${requestScope.autoAllocationFlag == '2'  ? 'selected="selected"' : '' }>全部调拨</option>                                                                       							  		
							  		<option value="0" ${requestScope.autoAllocationFlag == '0'  ? 'selected="selected"' : '' }>自动调拨</option>
	                          </select>
			               </TD>
			              </c:if>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
			               <input clean=clean id="goodsName" name="goodsName" type="text" class="text_input200" value="${goodsName }" maxlength="100"/>
					       </TD>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none"><label>
                          <input class="text_input160" id="remark" name="remark" value="${remark}"/>
                          </label></TD>
     
                          <TD height="26" class="table_body">关联单号</TD>
                          <TD class="table_none">
                              <input class="text_input200" id="statusBillID" name="statusBillID" value="${statusBillID}" maxlength="100" clean=clean>
                          </TD>
		               
                        </TR>                            
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyb=='1'}">
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td width="30%" align="left">
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="9%" scope=col colspan="2">操作</TH>
                          <TH width="16%" height="26" scope=col>调拨单号</TH>
                          <c:if test="${systemParameterPo.fspisallocationcategory eq '1'}">
                          <TH width="6%" scope=col>商品类别</TH>
                          </c:if>
                          <TH width="9%" scope=col>发出部门</TH>
						  <TH width="9%" scope=col>接收部门</TH>				
                          <TH width="4%" scope=col>制单人</TH>
						  <TH width="10%" scope=col>制单日期</TH>
						  <TH width="4%" scope=col>审核人</TH>
						  <TH width="10%" scope=col>审核时间</TH>
						  <TH width="4%" scope=col>收货人</TH>
						  <TH width="10%" scope=col>收货时间</TH>
						  <TH scope=col>备注</TH>
						  </TR>
						<s:iterator value="allocationList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                          	<c:if test="${permissionPo.keyc=='1'}">
                          	    <c:if test="${person.departmenttype == '3'}">
		                            <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:details('${cshaabillid}')">
		                        </c:if>
		                        <c:if test="${person.departmenttype != '3'}">
		                            <img src="${ctx }/img/newbtn/search_2.png" title='详细'>
		                        </c:if>
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  <c:if test="${permissionPo.keya=='1'}">
				              <c:if test="${cshaaauditstate==1 || cshaaoutdepartmentid != departmentIDFlag || person.departmenttype != '3'}">
		                          <img src="${ctx }/img/newbtn/edit_2.png" title='修改'>
		                      </c:if>
		                      <c:if test="${cshaaauditstate==0 && cshaaoutdepartmentid==departmentIDFlag && person.departmenttype == '3'}">
		                          <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${cshaabillid}')">
		                      </c:if>
		                  </c:if>  
		                  </TD>
	                  
                          <TD height="26">${cshaabillid}</TD>
                          <c:if test="${systemParameterPo.fspisallocationcategory eq '1'}">
                          <TD>${goodscategoryname}</TD>
                          </c:if>                           
                          <TD>${cshaaoutdepartmentname}</TD>
                          <TD>${cshaaindepartmentname}</TD>
                          <TD>${cshaacreatepersonname}</TD>
                          <TD>${fn:substring(cshaabilldate,0,16)}</TD>
                          <TD>${cshaaauditpersonname}</TD>
                          <TD>${fn:substring(cshaaauditdate,0,16)}</TD>
                          <TD>${cshaaconsigneename}</TD>
                          <TD>${fn:substring(cshaaconsigndate,0,16)}</TD>
                          <TD title="${cshaaremark}"><div class="autocut50">${cshaaremark}</div></TD>
                          
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