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
<title>发票冲回数据查询</title>
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
		selectBill.action = "ykselInvoiceAndReversal.action";
		selectBill.submit();
		showLoadingBar();
	}
	
	function billinfo(id){
	   document.all.hid.value = id;
	   var url = '';
	   if (id.substring(0,1)=='I'){
	        url = 'ykinitInvoiceDetail.action?invoiceID='+id;
	   }else if (id.substring(0,1)=='R'){
	       url = 'ykselReversalDetail.action?reversalID='+id;
	   }
	   
	   var topRows = top.document.getElementById("total").rows;
	   var topCols = top.document.getElementById("btmframe").cols;		
	   if(is_iPad()){
		   showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	   }else{
	       showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	   }		
	   document.getElementById('popupTitle').innerHTML="【发票、冲回详细】";
	}

	function clean(){
	    $('#title1').find("input").each(function(){
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

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="selectBill" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
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
			               <TD class="table_none" width="30%">
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
                    	   <TD width="10%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none" >
						   		<li class="horizontal_onlyRight">
							   		<input id="supplierName" class="text_input200" name="supplierName" value="${supplierName}" readonly="readonly"/>
							   		<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }"/>
								</li>
						   		<li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openSupplier();"></li>
						   	</TD>
						   <TD width="10%" height="26" class="table_body">凭证编号</TD>
						   <TD class="table_none" colspan="10">
						   		<input id="voucherID" class="text_input200" name="voucherID" value="${voucherID}"/>
						   </TD>
                        </TR>                   
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
						  <TH width="18%" scope=col>凭证编号</TH>
						  <TH width="6%" scope=col>详细</TH>
						  </TR>
						<s:iterator value="selectBillList">						
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${cstibillid}</TD>                          
                          <TD>${cstibilltypeid}</TD>                          
                          <TD>${cstisuppliername}</TD>
                          <TD>${fn:substring(cstibilldate,0,10)}</TD>
                          <TD>${voucher}</TD>                         
                          <TD>
		                     <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:billinfo('${cstibillid}')">
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