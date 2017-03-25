<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发票管理</title>
</head>
<script>
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	invoiceForm.action=link;
	  	invoiceForm.submit();
		showLoadingBar();
	}
	
	function clean(){	 
		$('#clear').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#clear').find("select[clean=clean]").each(function(){
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
		$("#supplierID").val(json.id);
		$("#supplierName").val(json.value);
		
	}
	
	function search(){
		invoiceForm.action = "invoiceQueryOpen.action";
		invoiceForm.submit();
		showLoadingBar();
	}	
	function detail(bid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInvoiceDetail.action?invoiceID="+bid+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInvoiceDetail.action?invoiceID="+bid+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【发票详细】";
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
    
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<form action="" name="invoiceForm" method="post">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="invoiceAuditDate" name="invoiceAuditDate" value="${invoiceAuditDate}"/>
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
            <TABLE id="clear" cellSpacing=0 cellPadding=0 width="100%" border=0>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26px">
                          <TD width="9%" class="table_body">发票单号</TD>
                          <TD width="24%" class="table_none"><input clean=clean class="text_input160" value="${invoiceID }" name="invoiceID"></TD>
                          <TD width="9%" class="table_body">制造商</TD>
			               <TD width="30%" class="table_none" >
						   			<li class="horizontal_onlyRight">
							   			<input clean=clean id="supplierName" readonly="readonly" class="text_input160" name="supplierName" value="${supplierName}" />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" readonly="readonly"/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();" >	
						  				</li>
						   	</TD>
						  <TD width="9%" class="table_body" >审核状态</TD>
                           <TD width="24%" class="table_none" >
						   <select clean=clean id="invoiceAuditStatue" name="invoiceAuditStatue">
                            <option value="" selected>----请选择----</option>
                            <option value='1' ${invoiceAuditStatue=='1'?'selected=selected':'' }>已审核</option>
                            <option value='0' ${invoiceAuditStatue=='0'?'selected=selected':'' }>未审核</option>
                          </select>	</TD>	
                        </TR>
                        <TR height="26px">
                          <TD class="table_body">发票类型</TD>
                          <TD class="table_none"> 
					           <SELECT clean=clean id="invoiceType" name="invoiceType">
					               <option value="">----请选择----</option>
					             <s:iterator value="invoiceTypeList">
                                   <option value="${sLitID}"} ${invoiceTypeID == sLitID ? 'selected="selected"' : '' }>${sLitType}</option>
	     	                     </s:iterator> 
					           </SELECT>
					       </TD>  
					      <TD class="table_body">发票日期</TD>
                          <TD class="table_none" >
                          <li class="horizontal_onlyRight">
                            <input id="invoiceStartDate" clean=clean
					       name="invoiceStartDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'invoiceEndDate\')}'})"
					       value="${invoiceStartDate}" /> 至 
					       <input id="invoiceEndDate" clean=clean
					       name="invoiceEndDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'invoiceStartDate\')}'})" 
					        value="${invoiceEndDate}" />
					        
					      </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('invoiceStartDate','invoiceEndDate')"></li>
                            
					        </TD>   
					      <TD class="table_body">制作人编号</TD>
                          <TD class="table_none"><input clean=clean type="text" class="text_input160"  id="invoiceCreatePersonID" name="invoiceCreatePersonID" value="${invoiceCreatePersonID}"/></TD>       
                        </TR>
                        <TR height="26px">
                          <TD class="table_body">是否付款</TD>
                          <TD class="table_none"> 
					           <SELECT clean=clean id="isPaymentFlag" name="isPaymentFlag">
					               <option value="" ${isPaymentFlag == '' ? 'selected="selected"' : '' }>----请选择----</option>
                                   <option value="1" ${isPaymentFlag == '1' ? 'selected="selected"' : '' }>已付款</option>
                                   <option value="0" ${isPaymentFlag == '0' ? 'selected="selected"' : '' }>未付款</option>
					           </SELECT>
					       </TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none" colspan="4"> 
                          <li class="horizontal_onlyRight">
                           <input id="invoiceStartAuditDate" clean=clean
					       name="invoiceStartAuditDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'invoiceEndAuditDate\')}'})"
					       value="${invoiceStartAuditDate}" /> 至 
					       <input id="invoiceEndAuditDate"
					       name="invoiceEndAuditDate"  clean=clean
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'invoiceStartAuditDate\')}'})" 
					        value="${invoiceEndAuditDate}" />
					        
					      </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('invoiceStartAuditDate','invoiceEndAuditDate')"></li>
                                                 
					        
					        </TD>  
						  </TR>
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR height="30px">
                          <TD align="left">							
							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >			
                            <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
						  </TD>						  		  
                        </TR>
                      </TBODY>
                    </TABLE>
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
                    <c:if test="${not empty(invoiceList)}">
					        <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TD width="3%" height="26">选择</TD>
                          <TH scope=col width="4%">操作</TH>
                          <TH width="13%" scope=col>发票号</TH>						
                          <TH scope=col width="15%">制造商</TH>
						  <TH scope=col width="8%">发票日期</TH>
						  <TH scope=col width="5%">制作人</TH>
						  <TH scope=col width="8%">成本合计</TH>
						  <TH width="8%" scope=col>税额合计</TH>
						  <TH scope=col width="8%">价税合计</TH>
						  <TH scope=col width="8%">已付款(含税)</TH>
						 
						                    
                        </TR>
                        <TR class=table_title align=middle>
                          <TD height="26" colspan="6" align="right" style="padding-right: 10PX">合计:</TD>
						  <TH>${invoiceEntryPo.lieienottaxrateamount }</TH>
						  <TH>${invoiceEntryPo.lieietaxamount }</TH>
						  <TH>${invoiceEntryPo.lieiecostpriceamount }</TH>
						  <TH>${invoiceEntryPo.lieiepaymentamount }</TH>
                          
						</TR>  
                        <s:iterator value="invoiceList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" id="invoiceRow">
						  <TD height="26"><input type="checkbox"></TD>
						  <TD><img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="detail('${liiid}')"></TD>		
						  <TD>${liiid }</TD>
                          <TD>${liidepartmentname }</TD>
						  <TD>${fn:substring(liidate,0,10) }</TD>
						  <TD>${liicreatepersonname}</TD>
                          <TD>${liinottaxrateamount }</TD>
                          <TD>${liitaxamount }</TD>
                          <TD>${liicostpriceamount }</TD>
                          <TD>${liiispaymentamount }</TD>
                                          
                        </TR>
                      </s:iterator>
                      </TBODY>
                    </TABLE>
                    <div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
					</div>
                    </c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left"></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>