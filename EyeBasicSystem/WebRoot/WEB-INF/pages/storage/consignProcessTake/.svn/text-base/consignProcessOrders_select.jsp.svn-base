<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择委外配镜单</title>
</head>
<script>	
	
	function search(){
		if(checkForm(supplierOpenForm)){  
			$("img").removeAttr("onclick");
			supplierOpenForm.action = "selectSalesId.action";
			supplierOpenForm.submit();
			showLoadingBar();
		}
	}
	
	function clean(){
		document.getElementById('billid').value = "";
		document.getElementById('selsupplierid').value = "";
		document.getElementById('selsuppliername').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
	    document.getElementById('billtype').value = "";
	    document.getElementById('glassid').value = "";
	    document.getElementById('brandID').value = "";
	    document.getElementById('brandName').value = "";
	    document.getElementById('qjv').value = "";
	    document.getElementById('zjv').value = "";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function setValue(id, value){	
		var json = {'id' : id, 'value' :　value};
		window.parent.openSupplierValues(json);
		
		parent.hidePopWin();

	}
	
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('selsupplierid').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }			
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种添加】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
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
		
		document.getElementById('popupTitle').innerHTML="【制造商添加】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selsupplierid').value = json.id;
		document.getElementById('selsuppliername').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	
	$(document).ready(function(){
	$('#billtype').attr("value","${requestScope.billtype}");
});

$(document).ready(function() { 
$("img[btn=btn]").attr("style","cursor: hand"); 
$("img[btn=btn]").mouseover(function () { 
$(this).attr("src",$(this).attr("src").replace("0","1")); 
}).mouseout(function () { 
$(this).attr("src",$(this).attr("src").replace("1","0")); 
}); 
});

function checkNumberType(thiz){
	if($(thiz).val()!=''){
		if(parseFloat($(thiz).val())>0){
			var str='+'+parseFloat($(thiz).val().replace('+','')).toFixed(2);
			$(thiz).val(str);
		}else if(parseFloat($(thiz).val())<0){
			$(thiz).val(parseFloat($(thiz).val()).toFixed(2));
		}else if(parseFloat($(thiz).val())==0){
			$(thiz).val('0.00');
		}
	}
}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierOpenForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
    <br/>
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
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <TR>
						   <TD width="9%" height="26" class="table_body">配镜单号</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text"  id="glassid" name="glassid" value="${requestScope.glassid}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">订单编号</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text"  id="billid" name="billid" value="${requestScope.billid}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input160" name="selsuppliername" value="${requestScope.selsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="selsupplierid" name="selsupplierid" value="${requestScope.selsupplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();">
						  	</li>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" name=ctl00$PageBody$Button1 onClick="openBrand();">
						   </li>
						   </TD>
			               <TD height="26" class="table_body">到镜日期</TD>
			               <TD class="table_none">
                            <input id="startTime"
					      		name="startTime" 
					       		type="text" class="text_input100" 
					       		onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       		value="${requestScope.startTime }" /> 至 <input id="endTime"
					       		name="endTime" 
					       		type="text" class="text_input100" 
					       		onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        	value="${requestScope.endTime }" />
			               </TD>
			               <TD height="26" class="table_body">订单类型</TD>
			               <TD class="table_none">
                            <select id="billtype" name="billtype">
      		                 <option value="">----请选择----</option>
				               	<option value="N">内部订单</option>
				               	<option value="W">外部订单</option>
      	                   </select>
			               </TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">球镜</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="qjv" name="qjv" value="${requestScope.qjv}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写球镜度数！'}]">
			               </TD>
			               <TD height="26" class="table_body">柱镜</TD>
			               <TD class="table_none" colspan="3">
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="zjv" name="zjv" value="${requestScope.zjv}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写柱镜度数！'}]">
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
							  <img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(salesidList)}"> 
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
                       	   <TH width="10%" scope=col>操作</TH>
                          <TH width="20%" height="26" scope=col>订单编号</TH>
                          <TH width="20%" scope=col>配镜单号</TH>
                          <TH width="10%" scope=col>订单类型</TH>
                          <TH width="25%" scope=col>制造商</TH>
                          <TH width="15%" scope=col>客户名称</TH>
						  </TR>
						<s:iterator value="salesidList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        <TD>
		                    <img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择' onClick="setValue('${cstcpodorderbilld}', '${cstcpodglassesbillid}');">
		                  </TD>
                          <TD height="26">${cstcpodorderbilld}</TD>
                          <TD>${cstcpodglassesbillid}</TD>
                          <TD>
                          <c:if test="${cstcpodordertype=='N'}">
                        	  内部订单
                          </c:if>
                          <c:if test="${cstcpodordertype=='W'}">
                          	 外部订单
                          </c:if>
                          </TD>
                          <TD>${cstcposuppliername}</TD>
                          <TD>${cstcpodcustomername}</TD>
		                  
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