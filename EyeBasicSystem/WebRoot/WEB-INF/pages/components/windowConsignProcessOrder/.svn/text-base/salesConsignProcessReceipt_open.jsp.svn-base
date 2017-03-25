<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择配镜单</title>
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

	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action = "selSalesConsignProcessReceiptOpen.action";
		goodsForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('salesID').value = "";
		document.getElementById('deptID').value = "";
		document.getElementById('ssesbsalesdatestarttime').value = "";
		document.getElementById('ssesbsalesdateendtime').value = "";
		document.getElementById('ssesbtakeglassstartdata').value = "";
		document.getElementById('ssesbtakeglassenddata').value = "";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	/**
	 *  调用页面赋值
	 */
	function setSalesValue(salesID,deptID){
	    window.parent.openSalesForConsignProcessValues(salesID,deptID);
		parent.hidePopWin();
	}
	function printDetails(salesID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+salesID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+salesID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【配镜单详细】";	
	}


</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="25%">
                            <input class="text_input160" type="text"  id="salesID" name="salesID" value="${requestScope.salesID}" >
                            <input type="hidden"  id="ordersType" name="ordersType" value="${requestScope.ordersType}">			               
			               </TD>
			               <TD width="8%" height="26" class="table_body">所属部门</TD>
			               <TD class="table_none" width="25%">
                            <select id="deptID" name="deptID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="deptList">
				               <option value="${bdpdepartmentid}" ${requestScope.deptID == bdpdepartmentid ? 'selected="selected"' : '' }>${bdpdepartmentname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
			               <TD width="8%" height="26" class="table_body">配镜时间</TD>
			               <TD class="table_none">
                           <input id="ssesbsalesdatestarttime"
					       name="ssesbsalesdatestarttime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssesbsalesdateendtime\')}'})"
					       value="${ssesbsalesdatestarttime}" /> 至 
					       <input id="ssesbsalesdateendtime"
					       name="ssesbsalesdateendtime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssesbsalesdatestarttime\')}'})" 
					        value="${ssesbsalesdateendtime}" /></TD>	
                        </TR>
                        <TR>
					       <TD width="60" height="26" class="table_body">取镜时间</TD>
			               <TD class="table_none" colspan="5">
                            <input id="ssesbtakeglassstartdata"
					       name="ssesbtakeglassstartdata" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssesbtakeglassenddata\')}'})"
					       value="${ssesbtakeglassstartdata}" /> 至 
					       <input id="ssesbtakeglassenddata"
					       name="ssesbtakeglassenddata" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssesbtakeglassstartdata\')}'})" 
					        value="${ssesbtakeglassenddata}" />			               
			               </TD>		               
                        </TR>
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(salesList)}"> 
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
                        <TH width="3%" scope=col>操作</TH>                                             
                          <TH width="9%" scope=col height="26">配镜单号</TH>
                          <TH width="5%" scope=col>顾客姓名</TH>
                          <TH width="7%" scope=col>顾客电话</TH>
                          <TH width="6%" scope=col>配镜时间</TH>   
                          <TH width="6%" scope=col>应收金额</TH>                                                                                                                          
                          
						  </TR>
						<s:iterator value="salesList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')"> 
                        <TD width="3%">
                         <img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择' onClick="setSalesValue('${ssesbsalesid}','${ssesbshopcode}');">
                          </TD>                      
                          <TD height="26"><a href="javascript:void(0);" onclick="printDetails('${ssesbsalesid}')" >${ssesbsalesid}</a></TD>
                          <TD>${ssesbpersonName}</TD>
                          <TD>${ssesbphone}</TD>
                          <TD>${fn:substring(ssesbposdatetime,0,10)}</TD>
                          <TD>${ssesbsalesvalue}</TD>
                          
                      
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
