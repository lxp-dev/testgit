<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品退货管理</title>
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
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementReturnStorageDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementReturnStorageDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品退货单详细】";
	}	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementReturnStorageUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementReturnStorageUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品退货单更新】";
	}
	function search(){
		$("img").removeAttr("onclick");
		procurementReturnForm.action = "selProcurementReturnStorage.action";
		procurementReturnForm.submit();
		showLoadingBar();
	}
	function insert(){
		//showPopWin("","initProcurementReturnStorageInsert.action?moduleID=${requestScope.moduleID}",screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementReturnStorageInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementReturnStorageInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品退货单新增】"
	}
	function del(id){
		//showPopWin("","initProcurementReturnDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,220, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementReturnDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",500,150,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementReturnDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",500,150,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品退货单删除】"
	}

	function clean(){
	    document.all.billID.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.bspsuppliername.value="";
	    document.all.selcstpsupplierid.value="";
	    document.all.cstioutstockid.value="";
	    document.all.auditState.value="";
	    document.all.createPersonName.value="";
	    document.all.csticreateperson.value="";
	    document.all.auditPersonName.value="";
	    document.all.cstiauditperson.value="";
	    document.all.cstidepartmentid.value="";
	    document.all.remark.value="";
		document.getElementById('selbspcategoryid').value = "";  
		document.all.goodsName.value="";
		document.all.goodsID.value="";
		$("#deliveryid").val("");
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】"
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>退货管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品退货管理</TD>
            <TD align="right" vAlign=bottom>&nbsp;
            <c:if test="${(permissionPo.keya==1)}">
            	<img src="${ctx }/img/newbtn/btn_spthadd_0.png" btn=btn title="商品退货新增" onClick="insert()">
           </c:if>
            <img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"  />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="5">
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
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">运单单号</TD>
			               <TD width="21%" class="table_none">
                            <input class="text_input160" type="text"  id="deliveryid" name="deliveryid" value="${requestScope.deliveryid}">
			               </TD>
			               <TD width="9%" class="table_body" height="26">制单人</TD>
                          <TD class="table_none">
                          <input type="hidden" class="text_input160" id="createPersonName" name="createPersonName" value="${createPersonName }">
                          <input type="text" class="text_input100" id="createPersonID" name="csticreateperson" value="${csticreateperson }">
                          </TD>
                        </TR>
                    	<TR>
                    	   <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" btn=btn name=ctl00$PageBody$Button1 onClick="openSupplier();"></li>
                    	   <TD height="26" class="table_body">退货部门</TD>
			               <TD class="table_none">
                            <select id="cstidepartmentid" name="cstidepartmentid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '退货部门不能为空！'}]">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
						   <TD height="26" class="table_body">发出仓位</TD>
			               <TD class="table_none">
                            <select id="cstioutstockid" name="cstioutstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '发出仓位不能为空！'}]">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(warehouseList)}">
				               	  <s:iterator value="warehouseList">
                    	           <OPTION value="${bwhid}" ${requestScope.outstockID!= bwhid  ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
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
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none" >
                          <input type="hidden" class="text_input160" id="auditPersonName" name="auditPersonName" value="${auditPersonName }">
                          <input type="text" class="text_input100" id="auditPersonID" name="cstiauditperson" value="${cstiauditperson }">
                          </TD>
                          <TD height="26" class="table_body">商品类别</TD>
                          <TD class="table_none">
						  <select name="selbspcategoryid">
						  		<option value="">----请选择----</option>
						  		<s:iterator value="goodsCategorys">
								<option value="${bgcid}" ${selbspcategoryid == bgcid ? 'selected="selected"' : '' } >${bgcgoodscategoryname}</option>
	     	               		</s:iterator>
						  </select>
                          </TD>
                        </TR>
                        <TR>
			              <TD height="26" class="table_body">商品名称</TD>
                          <TD class="table_none" >
                              <input class="text_input200" id="goodsName" name="goodsName" value="${goodsName}" maxlength="100">
                          </TD>  
			              <TD height="26" class="table_body">商品代码</TD>
                          <TD class="table_none">
                              <input class="text_input200" id="goodsID" name="goodsID" value="${goodsID}" maxlength="100">
                          </TD>
                          <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight">  <input class="text_input100"
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
						       readonly="readonly" />  </li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today()"></li>
			               </TD>                        
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5 ><label>
                          <input type="text" class="text_input200"  id="textarea" name="remark" value="${remark}">
                          </label></TD>
                        </TR> 
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							<c:if test="${(permissionPo.keyb==1)}">
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
							</c:if>
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
					<c:if test="${not empty(procurementReturnList)}"> 
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
                         <TH width="9%" height="26" scope=col colspan="3">操作</TH>
                          <TH width="13%" height="26" scope=col>单据编号</TH>
                          <TH width="13%" height="26" scope=col>运单单号</TH>
						  <TH width="13%" scope=col>单据日期</TH>						
                          <TH width="10%" scope=col>退货部门</TH>
						  <TH width="10%" scope=col>发出仓位</TH>
						  <TH width="8%" scope=col>审核状态</TH>
						  <TH width="6%" scope=col>制单人</TH>
						  <TH width="6%" scope=col>审核人</TH>
						  <TH scope=col>备注</TH>
						  </TR>
						 <s:iterator value="procurementReturnList">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                         <TD width="3%">
	                          <c:if test="${(permissionPo.keye==1)}">
			                     <img src="${ctx }/img/newbtn/search_0.png" title='详细' btn=btn onClick="javascript:details('${cstibillid}')">
			                  </c:if>
			                   </TD>
			                   <TD width="3%">
			                  <c:if test="${(permissionPo.keyc==1)}">
	                          
	                          	<c:if test="${cstiauditstate != 1}">
	                          		<img src="${ctx }/img/newbtn/edit_0.png" title='修改' btn=btn onClick="javascript:update('${cstibillid}')">
	                          	</c:if>
	                          	<c:if test="${cstiauditstate == 1}">
	                          		<img src="${ctx }/img/newbtn/edit_2.png" title='修改'>
	                          	</c:if>
	                          </c:if>
	                          </TD>
	                          <TD width="3%">
	                          <c:if test="${(permissionPo.keyd==1)}">
	                          	<c:if test="${cstiauditstate != 1}">
	                          		<img src="${ctx }/img/newbtn/delete_0.png" title='删除' btn=btn onClick="javascript:del('${cstibillid}')" >
	                          	</c:if>
	                          	<c:if test="${cstiauditstate == 1}">
	                          		<img src="${ctx }/img/newbtn/delete_2.png" title='删除'>
	                          	</c:if>
	                          </c:if>
                          </TD>
	                          <TD height="26">${cstibillid}</TD>
	                          <TD>${deliveryID}</TD>
	                          <TD>${fn:substring(cstibilldate,0,16)}</TD>
							  <td>${cstidepartmentname}</td>
	                          <TD>${cstioutstockname}</TD>
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
                           	  <TD title="${cstiremark}"><div class="autocut50">${cstiremark}</div></TD>                        	
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