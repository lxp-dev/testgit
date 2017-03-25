<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>不合格品单管理</title>
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
    	
		if($("#title1").is(":visible"))
        {
        	$("input:text")[0].focus();
        }
	});
	
	function details(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initNonconformingDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefres(true),false);
		}else{
			showPopWin("initNonconformingDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【不合格品单详细】";
	}	
	function update(id){
		document.all.hid.value = id;
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initNonconformingUpdate.action?hid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefres(true),true);
		}else{
			showPopWin("initNonconformingUpdate.action?hid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【不合格品单更新】";
	}
	function search(){
		document.all.submitButton.disabled="true";
		nonconformingForm.action = "selNonconforming.action";
		nonconformingForm.submit();
		showLoadingBar();
	}
	function insert(){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initNonconformingInsert.action?moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefres(true),true);
		}else{
			showPopWin("initNonconformingInsert.action?moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【不合格品单新增】";
	}
	function help(){
		
		window.open("${ctx}nonconformingHelp/nonconforming.html",'help');	
	}
	function del(id){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initNonconformingDelete.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefres(true),true);
		}else{
			showPopWin("initNonconformingDelete.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【不合格品单删除】";
	}
	
	function doit(id){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initNonconformingDo.action?hid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefres(true),true);
		}else{
			showPopWin("initNonconformingDo.action?hid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【不合格品单处理】";
	}
	function clean(){
		$("#billID").val('');
		$("#startTime").val('');
		$("#endTime").val('');
		$("#departmentid").val('');
		$("#auditState").val('');
		$("#createPersonName").val('');
		$("#cstpcreateperson").val('');
		$("#auditPersonName").val('');
		$("#cstpauditperson").val('');
		$("#supplierName").val('');
		$("#supplierID").val('');
		$("#brandName").val('');
		$("#brandID").val('');
		$("#iscustomize").val('');
		$("#cshanlinkbillID").val('');
		$("#cshaneconsignmode").val('');
		$("#auditState").val('');
		$("#responsibility").val('');
		$("#responsibilityID").val('');
		$("#consignMode").val('');
		
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		if($('#iscustomize').val()==''){alert("请选择商品类别！");return;}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+$('#iscustomize').val(),970,screen.height-200,topRows,topCols,returnRefres(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+$('#iscustomize').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		if($('#iscustomize').val()==''){alert("请选择商品类别！");return;}
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+$('#iscustomize').val()+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefres(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+$('#iscustomize').val()+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
<form name="nonconformingForm" method="post" action="">
<input type="hidden" name="hid" value="">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>不合格品管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：不合格品管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}"> 
            	<img src="${ctx }/img/newbtn/btn_nonconforminginsert_0.png" btn=btn title="不合格品单新增" onClick="insert()">
            	</c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
            
              <!-- <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="help();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/nonhelp.gif" align=textTop 
                  border=0>&nbsp;不合格品单流程帮助</TD> -->	
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
							<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="billID" name="billID" value="${requestScope.billID}">
                            <input class="text_input160" type="hidden"  id="ceshi" name="ceshi" value="2">
			               </TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight">
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
						    </li>
						    <li class="horizontal_onlyRight">
					  		  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()">
					  	    </li>
			               </TD>
						   <TD width="9%" height="26" class="table_body">审核状态</TD>
			               <TD class="table_none" >
                            <select id="auditState" name="auditState" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.auditState == "1"  ? 'selected="selected"' : '' }>已审核</option>
							  		<option value="0" ${requestScope.auditState == "0"  ? 'selected="selected"' : '' }>未审核</option>
	                          </select>
			               </TD>
                        </TR>
                    	<c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || person.departmenttype != '1'}">
                    	<TR>
			               <TD  height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();"></li>
			               </TD>
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
			               </TD>
                        </TR>
                    	</c:if>
                        <TR>
                          <TD height="26" class="table_body">申报部门</TD>
			              <TD class="table_none">
                            <select id="departmentid" name="departmentid">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			              </TD>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none">
                          <input class="text_input160" id="createPersonName" name="createPersonName" value="${createPersonName }">
                          <input type="hidden" class="text_input100" id="createPersonID" name="cstpcreateperson" value="${cstpcreateperson }">
                          </TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">
                          <input class="text_input160" id="auditPersonName" name="auditPersonName" value="${auditPersonName }">
                          <input type="hidden" class="text_input100" id="auditPersonID" name="cstpauditperson" value="${cstpauditperson }">
                          </TD>
                        </TR>
                         <TR>
			               <TD height="26" class="table_body">商品类型</TD>
			               <TD class="table_none">
                              <select id="iscustomize" name="iscustomize"> 
                                <option value="">----请选择----</option> 
                           	    <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${iscustomize == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                	 </s:iterator>
                              </select> 
			               </TD>
			               <TD height="26" class="table_body">销售单号</TD>
			               <TD class="table_none">
                              <input class="text_input160" id="cshanlinkbillID" name="cshanlinkbillID" value="${requestScope.cshanlinkbillID }">
			               </TD>
                           <TD height="26" class="table_body">不合格品类型</TD>
			               <TD class="table_none">
                               <select id="cshaneconsignmode" name="cshaneconsignmode"> 
                                <option value="" ${cshaneconsignmode == '' ? 'selected="selected"' : '' }>----请选择----</option>
                                <option value="0" ${cshaneconsignmode == '0' ? 'selected="selected"' : '' }>报残</option> 
                                <option value="1" ${cshaneconsignmode == '1' ? 'selected="selected"' : '' }>退回</option> 
                              </select> 
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">责任人</TD>
			               <TD class="table_none">
                          <input class="text_input160" id="responsibility" name="responsibility" value="${responsibility }">
                          <input type="hidden" class="text_input100" id="responsibilityID" name="responsibilityID" value="${responsibilityID }">
			               </TD>
                           <TD height="26" class="table_body">处理状态</TD>
			               <TD class="table_none" colspan="3">
                               <select id="consignMode" name="consignMode"> 
                                <option value="" ${consignMode == '' ? 'selected="selected"' : '' }>----请选择----</option>
                                <option value="0" ${consignMode == '0' ? 'selected="selected"' : '' }>未处理</option> 
                                <option value="2" ${consignMode == '2' ? 'selected="selected"' : '' }>已处理</option> 
                              </select> 
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${(permissionPo.keyb==1)}"> 
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
					<c:if test="${not empty(nonconformingList)}"> 
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
                          <TH width="12%" scope=col colspan="4">操作</TH>
                          <TH width="18%" height="26" scope=col>单据编号</TH>						  						
                          <TH scope=col>申请部门</TH>
						  <TH width="10%" scope=col>处置状态</TH>						  
						  <TH width="7%" scope=col>制单人</TH>
						  <TH width="7%" scope=col>责任人</TH>
						  <TH width="13%" scope=col>单据日期</TH>
						  <TH width="7%" scope=col>处理人</TH>
						  <TH width="13%"scope=col>处理日期</TH>
						 </TR>
						 <s:iterator value="nonconformingList">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD width="3%">
		                      	 <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:details('${cshanbillid}')">
			                  </TD>
			                  <TD width="3%">
			                  <c:if test="${(permissionPo.keyc==1)}">  
				                  <c:if test="${cshanauditstate==1||cshanauditstate==2}">
		                             <img src="${ctx }/img/newbtn/edit_2.png" title='修改' disabled="disabled">
		                          </c:if>
		                          <c:if test="${cshanauditstate==0}">
		                             <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${cshanbillid}')">
		                          </c:if>		
	                          </c:if>		                     
			                  </TD>
			                  <TD width="3%">
			                  <c:if test="${(permissionPo.keyd==1)}">
				                  <c:if test="${(cshanauditstate==1||cshanauditstate==2)&&person.departmenttype!=3}">
		                             <img src="${ctx }/img/newbtn/delete_2.png" title='删除'  disabled="disabled">
		                          </c:if>  
		                          <c:if test="${cshanauditstate==0||(person.departmenttype==3&&cshanauditstate==1&&cshanconsignperson==null&&person.departmenttype=='3')}">
		                             <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除'  onClick="javascript:del('${cshanbillid}')">
		                          </c:if>  
	                          </c:if>         
			                  </TD>
			                <td width="3%">
			               <c:if test="${(permissionPo.keye==1)}">  
			                  <c:if test="${person.departmenttype==3&&cshanauditstate==2||person.departmenttype==3&&cshanauditstate==0}">
	                             <img src="${ctx }/img/newbtn/doit_2.png" title='处理'>
	                          </c:if>
	                          <c:if test="${person.departmenttype==3&&cshanauditstate==1}">
	                             <img src="${ctx }/img/newbtn/doit_0.png" btn=btn title='处理' onClick="javascript:doit('${cshanbillid}')">
	                             </td>
	                          </c:if>
			               </c:if> 
			               </td> 
	                          <TD height="26">${cshanbillid}</TD>	                          
							  <td>${cshandepartmentname}</td>
	                          <TD>
	                          <c:if test="${cshanauditstate==1}">
	                              	已审核
	                          </c:if>
	                          <c:if test="${cshanauditstate==0}">
	                             	 未审核
	                          </c:if>
	                           <c:if test="${cshanauditstate==2}">
	                             	 已处理
	                          </c:if>
	                          </TD>
	                          <TD>
	                          ${cshancreatepersonname} 
	                          </TD>
	                          <TD>
	                          ${cshanresponsibilityperson} 
	                          </TD>
	                          <TD>${fn:substring(cshancreatedate,0,16)}</TD>
	                          <TD> ${cshanconsignpersonname }</TD>
                          	  <TD>${fn:substring(cshanconsigndate,0,16)}</TD>
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