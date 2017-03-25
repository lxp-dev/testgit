<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择调拨商品</title>
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
});
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
	
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("allocationDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("allocationDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【调拨单详细】";
	}
	
	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action = "selAllocationGoods.action";
		goodsForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('billID').value = "";
		document.getElementById('departmentID').value = "";
		document.getElementById('auditPersonName').value = "";
		document.getElementById('auditPersonID').value = "";
		document.getElementById('startTime1').value = "";
		document.getElementById('endTime1').value = "";
		
//	    document.all.supplierID.value="";
//	    document.all.supplierName.value="";
//	    document.all.goodscategoryID.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
	}
	function update(id,isShowBarcode){
        window.parent.openValues21(id,isShowBarcode);
        parent.hidePopWin();
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
		
		document.getElementById('startTime1').value = now;
		document.getElementById('endTime1').value = now;		
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" id="dptID" name="dptID" value="${dptID}">
<input type="hidden" id='categoryID_open' name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="allflag" value="${allflag}">
<input type="hidden" id='supplierID_open' name="supplierID_open" value="${supplierID_open }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
     
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                     <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">调拨单号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input200" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
						   <TD width="9%" height="26" class="table_body">调入部门</TD>
			               <TD class="table_none" width="24%">
                            <select id="departmentID" name="departmentID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               <TD width="9%" height="26" class="table_body">审核人</TD>
			               <TD class="table_none">
                               <input class="text_input200" type="text"  id="auditPersonName" name="auditPersonName" value="${requestScope.auditPersonName}">
                            <input type="hidden"  id="auditPersonID" name="auditPersonID" value="${requestScope.selauditPersonID}">
			               </TD>
                        </TR>
                        <!-- <TR>
						   <TD width="10%" class="table_body">商品类型</TD>
			               <TD class="table_none">
                               <select id="goodscategoryID" name="goodscategoryID" >
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
							<TD width="10%" class="table_body">制造商</TD>
			               <TD class="table_none" width="40%">
                            <li class="horizontal_onlyRight">
						   	<input id="bspsuppliername" class="text_input200" name="supplierName" value="${supplierName}"  readonly="readonly" />
						   	<input type="hidden" id="chaasupplier" name="supplierID" value="${supplierID}" />
						   	
						   </li>
						   <li class="horizontal_onlyRight">
						   <INPUT class=button_bak id=ctl00_PageBody_Button1 icon="icon-zoom" type=button value="选 择" name='ctl00$PageBody$Button1' onClick="openSupplier();"/>
						   </li>
			               </TD>
                        </TR> --> 
                    	
                    	<TR>
						  <TD class="table_body">审核日期</TD>
                          <TD class="table_none" colspan="5"><li class="horizontal_onlyRight"> <input id="startTime1"
					       name="startTime1" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime1\')}'})"
					       value="${startTime1 }" /> 至 <input id="endTime1"
					       name="endTime1" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime1\')}'})" 
					        value="${endTime1 }" /> </li><li class="horizontal_onlyRight">
<INPUT class=button_bak icon="icon-zoom" type=button value="今天" onClick="today()"></li></TD>
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
					<!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					 <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                       <TR class=table_title align=middle>
                          <TH width="6%" scope=col colspan="2">操作</TH>
                          <TH width="20%" height="26" scope=col>调拨单号</TH>
                          <TH width="10%" height="26" scope=col>商品类别</TH>
                          <TH width="10%" scope=col>调入部门</TH>
						  <TH width="19%" scope=col>制单日期</TH>
						  <TH width="19%" scope=col>审核日期</TH>
						  <TH scope=col>备注</TH>
						</TR>
						<s:iterator value="allocationList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                  <TD width="3%">
                             <img src="${ctx }/img/newbtn/select_0.png" title='选择' btn=btn onclick="javascript:update('${cshaabillid}','${isShowBarcode}')"></TD>
                          <TD width="3%">
		                     <img src="${ctx }/img/newbtn/search_0.png" title='详细' btn=btn onclick="javascript:details('${cshaabillid}')">
		                  </TD>
                          <TD height="26">${cshaabillid}</TD>
                          <TD height="26">${goodscategoryname}</TD>
                          <TD>${cshaaindepartmentname}</TD>
                          <TD>${fn:substring(cshaabilldate,0,10)}</TD>
                          <TD>${fn:substring(cshaaauditdate,0,10)}</TD>
                          <TD>${cshaaremark}</TD>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
