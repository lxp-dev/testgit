<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>凭证管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	selectBill.action=link;
	  	selectBill.submit();
		showLoadingBar();
	}
	function search(){
	    var invoiceType = document.getElementById('invoiceType').value;
	    if (invoiceType == ''){
	        alert("请先选择发票类型!");
	        return
	    }
		selectBill.action = "selectSelectInvoice.action";
		selectBill.submit();
		showLoadingBar();
	}
	
	function billinfo(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInvoiceInfoSel.action?hid="+id+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initInvoiceInfoSel.action?hid="+id+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【发票详细】";				
	}

	function clean(){
	    document.all.billid.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.invoiceState.value="";
	    document.all.invoiceType.value="";
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
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		
	}
	
	/**
	 *  checkbox全选
	 */	

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
    
    /**
	 *  调用页面赋值
	 */
	function setValue(){
		
		var billID='';
		$('input[name=chk]:checked').each(function(){
			billID=billID+$(this).val()+',';
		});
		
		if(billID.indexOf(',') < 0){
			alert('请选择商品!');
        	return false;
		}
		
		window.parent.openGoodSingleValues(billID.substring(0,billID.length-1));

	}
	
	function permissionMessage(){
       alert('您无此操作权限');
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="selectBill" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="sVoucherType" id="sVoucherType" value="${requestScope.sVoucherType}" />
<input type="hidden" name="voucherID" id="voucherID" value="${requestScope.voucherID}" />
<input type="hidden" name="voucherDate" id="voucherDate" value="${requestScope.voucherDate}" />
<input type="hidden" name="createPerson" id="createPerson" value="${requestScope.createPerson}" />
<input type="hidden" name="remark" id="remark" value="${requestScope.remark}" />
<input type="hidden" name="billtype" id="billtype" value="${requestScope.type}" /> 
<input type="hidden" name="billstype" id="billstype" value="${requestScope.billstype}" /> 

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
					  	<TR height="26">
						   <TD width="9%" class="table_body">发票编号</TD>
			               <TD class="table_none" width="24%">
                            <input clean=clean class="text_input160" type="text" id="billid" name="billid" maxlength=21 value="${requestScope.billid}">
			               </TD>
			               <TD width="9%" class="table_body">发票日期</TD>
                           <TD class="table_none" width="30%">
                         <li class="horizontal_onlyRight">
                            <input id="startTime" clean=clean
					       	name="startTime" 
					       	type="text" class="text_input100" 
					      	onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       	value="${startTime }" /> 
					       	至 
					       	<input id="endTime" clean=clean
					       	name="endTime" 
					       	type="text" class="text_input100" 
					       	onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" />
					        
					      </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('startTime','endTime')"></li>
                            
			               </TD>
			               <TD width="9%" class="table_body">发票类型</TD>
			               <TD class="table_none" >
					           <SELECT clean=clean id="invoiceType" name="invoiceType">
					               <option value="">----请选择----</option>
					             <s:iterator value="invoiceTypeList">
                                   <option value="${sLitID}"} ${typeID == sLitID ? 'selected="selected"' : '' }>${sLitType}</option>
	     	                     </s:iterator> 
					           </SELECT>
                           </TD>
                        </TR>
                    	<TR height="26">
			               <TD class="table_body">制造商</TD>
			               <TD class="table_none">
			               ${requestScope.supplierName}
						   	<input class="text_input160" type="hidden"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   	<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
                           </TD>
                           <TD class="table_body">审核状态</TD>
			               <TD class="table_none" colspan="3">
			               	<select clean=clean id="invoiceState" name="invoiceState"> 
                               <option value="" ${invoiceState == '' ? 'selected="selected"' : '' }>----请选择----</option> 
                               <option value="0" ${invoiceState == '0' ? 'selected="selected"' : '' }>未审核</option>
                           	   <option value="1" ${invoiceState == '1' ? 'selected="selected"' : '' }>已审核</option>
                            </select>
                           </TD>
                        </TR> 
                 
                      </TBODY>
                    </TABLE> 
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
								<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="setValue();" >	
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
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="4%" scope=col>操作</TH>
						  <TH width="15%" scope=col>发票编号</TH>						
						  <TH width="15%" scope=col>发票类型</TH>
						  <TH width="25%" scope=col>制造商</TH>
						  <TH width="15%" scope=col>发票日期</TH>
						  <TH width="10%" scope=col>审核状态</TH> 
						  
						  </TR>
						<s:iterator value="selectBillList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">
                          <c:if test="${cstifinanceauditstate==1}">
                          <input type="checkbox" id="chk" name="chk" value="${cstibillid}">
                          </c:if>
                           </TD>
                                                    
                          <TD width="4%">
		                     <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:billinfo('${cstibillid}')">
		                  </TD> 
                          <TD>${cstibillid}</TD>
                          <TD>${invoiceType }</TD>
                          <TD>${cstisuppliername}</TD>
                          <TD>${fn:substring(cstibilldate,0,10)}</TD>
                          
                          <TD>
                          <c:if test="${cstifinanceauditstate==0}">
                          	未审核
                          </c:if>
                          
                          <c:if test="${cstifinanceauditstate==1}">
                          	已审核
                          </c:if>
                          
                          </TD>

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