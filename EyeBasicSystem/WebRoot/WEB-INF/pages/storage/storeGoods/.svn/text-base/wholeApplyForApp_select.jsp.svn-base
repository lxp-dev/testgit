<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品调拨管理</title>
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
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
		if($("#title1").is(":visible")){
        	$("input:text")[0].focus();
        }
	});

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	allocationForm.action=link;
	  	allocationForm.submit();
		showLoadingBar();
	}
	function update(id){
		document.all.hid.value = id;
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initApplyAllocationForAppUpdate.action?hid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initApplyAllocationForAppUpdate.action?hid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【调拨申请信息更新】";
	}
	function search(){
		$("img").removeAttr("onclick");
		allocationForm.action = "selApplyAllocationForApp.action";
		allocationForm.submit();
		showLoadingBar();
	}	
	function details(id){
		document.all.hid.value = id;
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("allocationApplyForAppDetails.action?hid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("allocationApplyForAppDetails.action?hid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨申请信息详细】";
	}
	function insert(){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initApplyAllocationForAppInsert.action?moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initApplyAllocationForAppInsert.action?moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【调拨申请信息新增】";
	}
	function del(id){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initApplyAllocationForAppDelete.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initApplyAllocationForAppDelete.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【调拨申请信息删除】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('chaasupplier').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
		
	}
	
	 /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID=document.getElementById('goodscategoryID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,140,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	function openGoodSingle(){
	
	    var supplierID = document.getElementById('chaasupplier').value;
	    var categoryID_open=document.getElementById('goodscategoryID').value;
		showPopWin("","initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		//showPopWin("","initGoodsSingleSel.action" ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}

	function clean(){
	 	document.getElementById('billID').value = "";
		document.getElementById('departmentID').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('startTime1').value = "";
		document.getElementById('endTime1').value = "";
		document.getElementById('auditState').value = "";
		document.getElementById('createPersonName').value = "";
		document.getElementById('createPersonID').value = "";
		document.getElementById('auditPersonID').value = "";
		document.getElementById('auditPersonName').value = "";
		document.getElementById('goodsName').value = "";
		document.getElementById('remark').value = "";
		document.getElementById('goodsID').value = "";
		$("#goodscategoryID").val("");
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
	
	function today1(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime1').value = now;
		document.getElementById('endTime1').value = now;		
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
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：调拨申请管理</TD>
            <td align="right" valign="bottom">&nbsp;
             <c:if test="${permissionPo.keyb=='1'}">
            	<img src="${ctx }/img/newbtn/button_djinsert_0.png" btn=btn title="调拨申请新增" onClick="insert();">
             </c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
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
						   <TD width="9%" height="26" class="table_body">申请单号</TD>
			               <TD class="table_none" width="26%">
                            <input class="text_input160" type="text"  id="billID" name="billID" value="${requestScope.billID}" onkeyup="selectContact(this)">
			               </TD>
						   <TD width="9%" height="26" class="table_body">申请部门</TD>
			               <TD class="table_none" width="24%">
                            <select id="departmentID" name="departmentID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               <TD width="9%" height="26" class="table_body">制单人</TD>
			               <TD class="table_none">
                           <input class="text_input80" type="text"  id="createPersonName" name="createPersonName" value="${requestScope.createPersonName}">
                            <input  type="hidden"  id="createPersonID" name="createPersonID" value="${requestScope.selcreatePersonID}">
			               </TD>

                        </TR>
                    	<TR>
			               <TD height="26" class="table_body">单据日期</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight"> <input id="startTime"
					       name="startTime" 
					       type="text" class="text_input80" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /></li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li></TD>
						   <TD height="26" class="table_body">审核人</TD>
			               <TD class="table_none">
                               <input class="text_input80" type="text"  id="auditPersonName" name="auditPersonName" value="${requestScope.auditPersonName}">
                            <input type="hidden"  id="auditPersonID" name="auditPersonID" value="${requestScope.selauditPersonID}">
			               </TD>
			               <TD height="26" class="table_body">审核状态</TD>
			               <TD class="table_none">
                              <select name="auditState" id='auditState' value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
                        </TR>
                    	<TR>
						   <TD height="26" class="table_body">审核日期</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight"> <input id="startTime1"
					       name="startTime1" 
					       type="text" class="text_input80" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime1\')}'})"
					       value="${startTime1 }" /> 至 
					       <input id="endTime1"
					       name="endTime1" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime1\')}'})" 
					        value="${endTime1 }" /></li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today1()"></li>
			               </TD>
			               <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
			               	<input id="goodsName" name="goodsName" type="text" class="text_input200" value="${goodsName }" maxlength="100"/>
					       </TD>
					       <TD class="table_body">备注</TD>
                           <TD class="table_none">
                           	<input id="textarea" name="remark" class="text_input160" value="${remark}"/>
                           </TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisallocationcategory eq '1'}">
                    	<TR>
                    	   <TD height="26" class="table_body">商品类型</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
			               	<input id="goodsID" name="goodsID" type="text" class="text_input200" value="${goodsID }" maxlength="50"/>
					       </TD>
					       <TD width="9%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none"  colspan="3">
                            <select id="goodscategoryID" name="goodscategoryID">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"':'' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
                        </TR>
                        </c:if>
                        <c:if test="${systemParameterPo.fspisallocationcategory ne '1'}">
                    	<TR>
			               <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none" colspan="5">
			               	<input id="goodsID" name="goodsID" type="text" class="text_input200" value="${goodsID }" maxlength="50"/>
					       </TD>
                        </TR>
                        </c:if>
                      </TBODY>
                    </TABLE>
                    
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none" width="30%">
                           <li class="horizontal_onlyRight">   <input class="text_input100"
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
						       readonly="readonly" /></li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today()"></li>
			               </TD>
						   <TD width="9%" height="26" class="table_body">客户名称</TD>
			               <TD class="table_none">
                            <select id="customerid" name="customerid">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsPos)}">
				               	  <s:iterator value="departmentsPos">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.customerid!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
      	                   </TD>
                        </TR>
                    	<TR>
                    	   
						   <TD height="26" class="table_body">发出仓位</TD>
			               <TD class="table_none">
                            <select id="cstioutstockid" name="cstioutstockid">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(warehouseList)}">
				               	  <s:iterator value="warehouseList">
                    	           <OPTION value="${bwhid}" ${requestScope.outstockID!= bwhid  ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">审核状态</TD>
			               <TD class="table_none">
                            <select name="auditState" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
                       
						   <TD height="26" class="table_body">备注</TD>
			               <TD class="table_none"  >
                            <input clean=clean class="text_input160" type="text"  id="remark" name="remark" value="${requestScope.remark}" maxlength="20">
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
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openBrand();"></li>
						  
			               </TD>
			               <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
			               <input clean=clean id="goodsId" name="goodsId" type="text" class="text_input160" value="${goodsId }" maxlength="30"/>
					       </TD>
                        </TR>
                        </c:if> 
			            <TR>
			               <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
			               <input clean=clean id="goodsName" name="goodsName" type="text" class="text_input160" value="${goodsName }" maxlength="100"/>
					       </TD>
					       <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="createPersonName" name="createPersonName" value="${requestScope.createPersonName}">
			               </TD>
							<TD height="26" class="table_body">审核人</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input160" type="text"  id="auditPersonName" name="auditPersonName" value="${requestScope.auditPersonName}">
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyb=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
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
					  <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="8%" scope=col colspan="3">操作</TH>
                          <TH width="10%" height="26" scope=col>申请单号</TH>	
                          <TH width="10%" scope=col>商品类型</TH>					
                          <TH width="10%" scope=col>申请部门</TH>
                          <TH width="10%" scope=col>接收部门</TH>
						  <TH width="10%" scope=col>制单日期</TH>
						  <TH width="10%" scope=col>审核日期</TH>
						  <TH width="20%" scope=col>备注</TH>
						</TR>
						<s:iterator value="allocationList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="4%">
                          	<c:if test="${permissionPo.keye=='1'}">
		                     <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:details('${cshaabillid}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyc=='1'}">
			                  <c:if test="${cshaaauditstate==1 }">
	                             <img src="${ctx }/img/newbtn/edit_2.png" title='修改'>
	                          </c:if>
	                          <c:if test="${cshaaauditstate==0}">
	                             <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${cshaabillid}')">
	                          </c:if>
		                  </c:if>
		                  </TD>
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyd=='1'}">
			                  <c:if test="${departmentType ne '3'}">
				                  <c:if test="${cshaabillassociation ne 1 || cshaaoutdepartmentid ne sysDepartment }">
		                             <img src="${ctx }/img/newbtn/delete_2.png" title='删除'>
		                          </c:if>
		                          <c:if test="${cshaabillassociation eq 1 && cshaaoutdepartmentid eq sysDepartment  }">
		                             <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${cshaabillid}')">
		                          </c:if>
	                          </c:if> 
			                  <c:if test="${departmentType eq '3'}">
				                  <c:if test="${cshaabillassociation ne 1 || permissionPo.keyf ne 1}">
		                             <img src="${ctx }/img/newbtn/delete_2.png" title='删除'>
		                          </c:if>
		                          <c:if test="${cshaabillassociation eq 1 && permissionPo.keyf eq 1}">
		                             <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${cshaabillid}')">
		                          </c:if>
			                  </c:if>
                          </c:if>		                     
		                  </TD>
                          <TD height="26">${cshaabillid}</TD>
                          <TD>${goodscategoryname}</TD>
                          <TD>${cshaaindepartmentname}</TD>
                          <TD>${cshaaoutdepartmentname}</TD>
                          <TD>${fn:substring(cshaabilldate,0,16)}</TD>
                          <TD>${fn:substring(cshaaauditdate,0,16)}</TD>
                          <TD>${cshaaremark}</TD>
						</TR>
						</s:iterator>	
				   		<c:forEach var="po" items="${goodsInfoPos}">
                        <TR class="row">
                        <TD height="26"><input id="chk" type="checkbox" value="${po.bgigoodsid}" ></TD>
                        <TD>${po.bgigoodsid}
                        <input id="goodsid" type="hidden" name="goodsInfoTempPo.goodsid" value="${po.bgigoodsid}" />
                        </TD>
                        <TD>${po.bgigoodsname}</TD>
                        <TD>${po.bgispec}</TD>
                        <TD><input type="text" ${person.departmenttype==3?'readOnly=readOnly':'' } class="text_input60" onkeydown="OnKeyDownEnter(this)" name="needNumber" onblur="needAmount()" value="${po.bgigoodsquantity}" /></TD>                                                                        
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