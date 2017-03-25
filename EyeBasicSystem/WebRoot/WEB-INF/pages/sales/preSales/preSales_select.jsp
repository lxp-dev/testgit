<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门店计划销售设置</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
<!-- jquery.autocomplete end -->

<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	procurementReturnForm.action=link;
	  	procurementReturnForm.submit();
		showLoadingBar();
	}
	function details(id){
		//document.all.hid.value = id;
		//showPopWin("","initProcurementReturnDetails.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementReturnDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementReturnDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【退货财务结算详细】";
	}	
	function update(id){
		//document.all.hid.value = id;
		//showPopWin("","initProcurementReturnUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementReturnUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementReturnUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【退货财务结算更新】";
	}
	function search(){
		$("img").removeAttr("onclick");
		procurementReturnForm.action = "selSetPreSales.action";
		procurementReturnForm.submit();
		showLoadingBar();
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initInsertSetPreSales.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【门店计划销售设置新增】";
	}
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initUpdateSetPreSales.action?preSalesPo.preSalesId="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【门店计划销售设置修改】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteSetPreSales.action?preSalesPo.preSalesId="+id+"&moduleID=${requestScope.moduleID}",400,200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteSetPreSales.action?preSalesPo.preSalesId="+id+"&moduleID=${requestScope.moduleID}",400,200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【门店计划销售设置删除】";
	}	

	function clean(){
	    document.all.billID.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.selbspsuppliername.value="";
	    document.all.selcstpsupplierid.value="";
	    document.all.cstioutstockid.value="";
	    document.all.auditState.value="";
	    document.all.createPersonName.value="";
	    document.all.csticreateperson.value="";
	    document.all.auditPersonName.value="";
	    document.all.cstiauditperson.value="";
	    document.all.cstidepartmentid.value="";
	    document.all.selbspcategoryid.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
//		showPopWin("","selSupplierOpen.action",screen.width-200,screen.height-200, '', null, true);
//		selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}

	/**
	 * 开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}	

	/**
	* 制造商开窗
	*/
	function openSupplier(){
		var goodscategoryID= '';
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	* 开窗赋值实现方法
	*/
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	* 品种开窗
	*/
	function openBrand(){
		var supplierID=document.getElementById('supplierID').value;
		var goodscategoryID= '';
		if(supplierID==''){
		  alert('请选择所属制造商');
		  return false;
		}	
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	function checkAll() {
		$("input[id=chk]").each(function() {
			$(this).attr("checked", $("#chks").attr("checked"));
		})
	}
	//批量修改
	function batchUpdate() {
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		var ids = "";
		$("input[id=chk]").each(function() {
			if($(this).attr("checked") == true) {
				ids = ids + $(this).val() + ",";
			}
		});
		if(is_iPad()){
			showPopWin("initBatchUpdatePreSales.action?ids="+ids,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initBatchUpdatePreSales.action?ids="+ids,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【门店计划销售设置批量修改】";
	}
	//批量删除
	function batchDel() {
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		var ids = "";
		$("input[id=chk]").each(function() {
			if($(this).attr("checked") == true) {
				ids = ids + $(this).val() + ",";
			}
		});
		if(is_iPad()){
			showPopWin("initBatchDeletePreSales.action?ids="+ids,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBatchDeletePreSales.action?ids="+ids,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【门店计划销售设置批量删除】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReturnForm" method="post" action="">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>门店计划销售设置管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：门店计划销售设置</TD>
            <TD class=menubar_readme_text vAlign=bottom>
			<img src="${ctx }/img/newbtn/btn_spthadd_0.png" btn=btn title="商品退货新增" onClick="insert()">            
            &nbsp;
            <%--<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"  />--%>
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table></TD>
          </TR>
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
			               <TD width="8%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="30%">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input300" id="bdpdepartmentname" name="preSalesPo.departmentName" value="${preSalesPo.departmentName }" type="hidden" />
							   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 240px' readonly="readonly" >${preSalesPo.departmentName }</textarea>							   		
							   		<input class="text_input100" type="hidden" id="departmentID" name="preSalesPo.departmentId" value="${preSalesPo.departmentId }"/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
      	                   <%--<c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}"/>
      	                   </c:if>--%>
			               </TD>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" readonly="readonly" name="preSalesPo.supplierName" value="${preSalesPo.supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="preSalesPo.supplierId" value="${preSalesPo.supplierId }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();"></li>
			               </TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="preSalesPo.brandName" value="${preSalesPo.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="preSalesPo.brandId" value="${preSalesPo.brandId}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						   	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
			               </TD>
                        </TR>
                    	<TR>
                    	   <TD height="26" class="table_body">计划销售数</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" name="preSalesPo.minPreSalesNum" value="${preSalesPo.minPreSalesNum }"/>
                            &nbsp;&nbsp;至&nbsp;&nbsp;
                            <input class="text_input80" type="text" name="preSalesPo.maxPreSalesNum" value="${preSalesPo.maxPreSalesNum }"/>
                            <%--完成计划百分比<input class="text_input80" type="text" name="minScale"/>%
                            &nbsp;&nbsp;至&nbsp;&nbsp;
                            <input class="text_input80" type="text" name="maxScale"/>%--%>
			               </TD>
						   <TD height="26" class="table_body"></TD>
			               <TD class="table_none">
			               </TD>
			               <TD height="26" class="table_body"></TD>
			               <TD class="table_none">
                            <%--实际销售数<input class="text_input160" type="text" name="realSales"/>--%>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
								<img src="${ctx }/img/newbtn/btn_plxg_0.png" btn=btn title='批量修改' onClick="batchUpdate()">
								<img src="${ctx }/img/newbtn/btn_plsc_0.png" btn=btn title='批量删除' onClick="batchDel()">
							</td>
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
					<c:if test="${not empty(preSalesPoList)}"> 
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
                          <TH width="2%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="checkAll()"/></TH>
						  <TH width="13%" scope=col>门店名称</TH>						
                          <TH width="17%" scope=col>制造商名称</TH>
						  <TH width="13%" scope=col>品种名称</TH>
						  <TH width="12%" scope=col>计划销售日期</TH>
						  <TH width="6%" scope=col>计划销售数</TH>
                          <TH width="6%" height="26" scope=col colspan="2">操作</TH>
					   </TR>
						 <s:iterator value="preSalesPoList">
	                        <TR class="row" height="26" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD><input type="checkbox" id="chk" value="${preSalesId }"/></TD>
	                          <TD>${departmentName }</TD>
	                          <TD>${supplierName }</TD>
	                          <TD>${brandName }</TD>
	                          <TD>${startDate } &nbsp;至&nbsp; ${endDate }</TD>
	                          <TD>${salesQuantity }</TD>
	                          <TD><img btn=btn src="${ctx }/img/newbtn/edit_0.png" title='修改' onclick="update('${preSalesId }')"></TD>
	                          <TD><img btn=btn src="${ctx }/img/newbtn/delete_0.png" title='删除' onclick="del('${preSalesId }')"></TD>
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
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>