<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script type='text/javascript' src='${ctx }/js/module/autoLoadSupplier.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<title>单据查询</title>
</head>
<script>   	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	});
	
	function search(){
		selectBill.action = "ykselBill.action";
		selectBill.submit();
		showLoadingBar();
	}
	
	function billinfo(id){
	   document.all.hid.value = id;
	   var topRows = top.document.getElementById("total").rows;
	   var topCols = top.document.getElementById("btmframe").cols;		
	   if(is_iPad()){
		   showPopWin("ykinitBillInfoSel.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	   }else{
	       showPopWin("ykinitBillInfoSel.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	   }		
	   document.getElementById('popupTitle').innerHTML="【发票、冲回详细】";
	}

	function clean(){
	    $('#clear').find("input").each(function(){
			$(this).val('');
		});
		$('#clear').find("select").each(function(){
			$(this).val('');
		});	
	}	
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("ykselSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("ykselSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;		
	}
	
	function toFixAndNan(obj){
		obj.value=obj.value.replace('，',',');
	}
	
	function printBill(billID){
	    var bgnDate = $('#bgnDate').val();
	    if (bgnDate == "" || bgnDate == null){
		    alert("请选择冲回起始时间!");
		    return;
		}
		var endDate = $('#endDate').val();
		if (endDate == "" || endDate == null){
		    alert("请选择冲回终止时间!");
		    return;
		}
		 
	    var printStatus = $('#printStatus').val();
        var url = '<%= getServletContext().getInitParameter("rptUrl")%>';        
        switch(printStatus){
            case '1':
                url+="eims_reporting/logistics_BillByTypeRpt&billID="+billID+"&bgnDate="+bgnDate+"&endDate="+endDate+"&rs:Command=Render";
		        window.open (url, 'BillByTypeRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');		
                break;
            case '2':
                url+="eims_reporting/logistics_BillBySupplierRpt&billID="+billID+"&bgnDate="+bgnDate+"&endDate="+endDate+"&rs:Command=Render";
		        window.open (url, 'BillBySupplierRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');		
                break;
            case '3':
                url+="eims_reporting/logistics_BillByBrandRpt&billID="+billID+"&bgnDate="+bgnDate+"&endDate="+endDate+"&rs:Command=Render";
		        window.open (url, 'BillByBrandRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');		
                break;           
        }
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="selectBill" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="billID" value="${requestScope.billID}">

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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 id="clear">
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
						   <TD width="10%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="20%">
                            <input class="text_input200" type="text" id="billid" name="billid" value="${requestScope.billid}" onkeyup="toFixAndNan(this)">
			               </TD>
			               <TD width="10%" height="26" class="table_body">单据日期</TD>
                           <TD class="table_none" width="30%">						       
						 <li class="horizontal_onlyRight">
						  <input id="begintime"
					       name="begintime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endtime\')}'})"
					       value="${begintime }" readonly="readonly"/> 至 
					       <input id="endtime"
					       name="endtime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'begintime\')}'})" 
					        value="${endtime}" readonly="readonly"/>
					        
					       </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('begintime','endtime')"></li>
			               </TD>
			               <TD width="10%" height="26" class="table_body">商品代码</TD>
			               <TD class="table_none" colspan="3">
			               	<input class="text_input200" type="text" id="goodsID" name="goodsID" value="${requestScope.goodsID}">
                           </TD>
                        </TR>
                    	<TR>
                           <TD width="10%" height="26" class="table_body">核销状态</TD>
			               <TD class="table_none">			               
			               	<select id="invoiceState" name="invoiceState"> 
                               <option value="" ${invoiceState == '' ? 'selected="selected"' : '' }>----请选择----</option> 
                               <option value="0" ${invoiceState == '0' ? 'selected="selected"' : '' }>未核销</option>
                           	   <option value="1" ${invoiceState == '1' ? 'selected="selected"' : '' }>部分核销</option>
                           	   <option value="2" ${invoiceState == '2' ? 'selected="selected"' : '' }>完全核销</option>
                           	   <option value="3" ${invoiceState == '3' ? 'selected="selected"' : '' }>非完全核销</option>
                            </select>
                           </TD>
                    	   <TD width="10%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none" >
						   		<li class="horizontal_onlyRight">
							   		<input id="supplierName" class="text_input200" name="supplierName" value="${supplierName}" readonly="readonly"/>
							   		<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }"/>
								</li>
						   		<li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openSupplier();"></li>
						   	</TD>
						   <TD width="10%" height="30" class="table_body">凭证编号</TD>
						   <TD class="table_none" >
						   		<input id="voucherID" class="text_input200" name="voucherID" value="${voucherID}"/>
						   </TD>
                        </TR> 
                        <tr>
                           <TD width="10%" height="26" class="table_body">打印级别</TD>
						   <TD class="table_none">
						   		<select id="printStatus" name="printStatus">                                
							  		<option value="1" selected="selected">商品类别</option>
							  		<option value="2">制造商</option>
							  		<option value="3">品种</option>
                                </select> 
						   </TD>
						   <TD width="10%" height="26" class="table_body">冲回日期</TD>
                           <TD class="table_none" width="30%">						       
						<li class="horizontal_onlyRight">
						  <input id="bgnDate"
					       name="bgnDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endDate\')}'})"
					       value="${bgnDate }" readonly="readonly"/> 至 
					       <input id="endDate"
					       name="endDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'bgnDate\')}'})" 
					        value="${endDate}" readonly="readonly"/>
					        
					      </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('bgnDate','endDate')"></li>
					        
			               </TD>
						   <TD width="10%" height="26" class="table_body">凭证标识</TD>
						   <TD class="table_none">
						   		<select id="voucherStatus" name="voucherStatus">  
						   		    <option value="" ${voucherStatus == '' ? 'selected="selected"' : '' }>----请选择----</option>                              
							  		<option value="0" ${voucherStatus == '0' ? 'selected="selected"' : '' }>未做凭证</option>
							  		<option value="1" ${voucherStatus == '1' ? 'selected="selected"' : '' }>已做凭证</option>
                                </select> 
						   </TD>
                        </tr>                    
                      </TBODY>
                    </TABLE> 
                    <table id="searchBar" cellspacing="2">
						<tr height="26">
							<td>
							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                            <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
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
					<c:if test="${not empty(selectBillList)}">
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
                          <TR height="26" class=table_title align=middle>
						  <TH width="15%" scope=col>单据编号</TH>						
						  <TH width="8%" scope=col>单据类型</TH>
						  <TH width="20%" scope=col>制造商</TH>
						  <TH width="8%" scope=col>单据日期</TH>
						  <TH width="5%" scope=col>核销状态</TH> 
						  <TH width="18%" scope=col>凭证编号</TH>
						  <TH width="6%" scope=col>详细</TH>
						  <TH width="6%" scope=col>打印</TH>
						  </TR>
						<s:iterator value="selectBillList">						
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${cstibillid}</TD>                          
                          <TD>
                          <c:choose>
                            <c:when test="${cstibilltypeid=='1'}">采购收货单</c:when>
                            <c:when test="${cstibilltypeid=='2'}">采购退货单</c:when>
                            <c:when test="${cstibilltypeid=='9'}">委外收货单</c:when>
                          </c:choose>
                          </TD>                          
                          <TD>${cstisuppliername}</TD>
                          <TD>${fn:substring(cstibilldate,0,10)}</TD>                          
                          <TD>
                          <c:choose>
                            <c:when test="${cstiinvoicestate==0}">未核销</c:when>
                            <c:when test="${cstiinvoicestate==2}">完全核销</c:when>
                            <c:otherwise>部分核销</c:otherwise>
                          </c:choose>
                          </TD>  
                           <TD>${voucher }</TD>                         
                          <TD>
		                     <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:billinfo('${cstibillid}')">
		                  </TD>
		                   <TD>
		                     <img btn=btn src="${ctx }/img/newbtn/print_0.png" title='打印' onClick="javascript:printBill('${cstibillid}')">
		                  </TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
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