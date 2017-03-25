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

	function update(bid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInvoiceByBillUpdate.action?invoiceID="+bid+"&moduleID="+document.getElementById('moduleID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInvoiceByBillUpdate.action?invoiceID="+bid+"&moduleID="+document.getElementById('moduleID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【发票修改】";
	}
	
	function search(){
		invoiceForm.action = "selInvoiceByBill.action";
		invoiceForm.submit();
		showLoadingBar();
	}	
	function detail(bid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;			
		if(is_iPad()){
			showPopWin("initInvoiceByBillDetail.action?invoiceID="+bid+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInvoiceByBillDetail.action?invoiceID="+bid+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【发票详细】";
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInvoiceByBillInsert.action?moduleID="+document.getElementById('moduleID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInvoiceByBillInsert.action?moduleID="+document.getElementById('moduleID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【发票新增】";
	}
	function del(bid){	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initInvoiceByBillDelete.action?invoiceID="+bid+"&moduleID="+document.getElementById('moduleID').value,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【发票删除】";
	}
	
	function allAudit(){
        var month = $('#invoiceAuditDate').val();        
        var msg = '';        
        if (month == ''){
            msg = '确定审核本期全部发票吗!';
        }else{
            msg = '确定审核全部 '+month+' 月份发票!';
        }
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initAllAuditOrUnAuditInvoice.action?auditStatue=q&moduleID="+document.getElementById('moduleID').value+"&msg="+EncodeUtf8(msg),450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【发票审核】";
	}	
	function allUnAudit(){
        var month = $('#invoiceAuditDate').val(); 
        var msg = '';        
        if (month == ''){
            msg = '确定反审核本期全部发票吗!';
        }else{
            msg = '确定反审核全部 '+month+' 月份发票!';
        }  
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initAllAuditOrUnAuditInvoice.action?auditStatue=f&moduleID="+document.getElementById('moduleID').value+"&msg="+EncodeUtf8(msg),450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【发票反审核】";
	}
	
	function unAudit(invoiceID){	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initAllAuditOrUnAuditInvoice.action?auditStatue=f&moduleID="+document.getElementById('moduleID').value+"&invoiceID="+invoiceID,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【发票反审核】";
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
    
	function partAudit(){
		var chk = document.getElementsByName("chk");
        var objValue = '';
        for(var i = 0;i<chk.length;i++){
        	if(chk[i].checked == true){
	       		if(objValue == ""){
		           	objValue = chk[i].value;
		        }else{
		           	objValue = objValue + "," + chk[i].value;
		        }          
        	}
        }
        if (objValue == ''){
            alert("请先选取需要审核的发票!");
            return;
        }
	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initPartAuditOrUnAuditInvoice.action?auditStatue=q&moduleID="+document.getElementById('moduleID').value+"&invoiceID="+objValue,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【发票审核】";
	}
	
	function partUnAudit(){
		var chk = document.getElementsByName("chk");
        var objValue = '';
        for(var i = 0;i<chk.length;i++){
        	if(chk[i].checked == true){
	       		if(objValue == ""){
		           	objValue = chk[i].value;
		        }else{
		           	objValue = objValue + "," + chk[i].value;
		        }          
        	}
        }
        if (objValue == ''){
            alert("请先选取需要反审核的发票!");
            return;
        }
        		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initPartAuditOrUnAuditInvoice.action?auditStatue=f&moduleID="+document.getElementById('moduleID').value+"&invoiceID="+objValue,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【发票反审核】";
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
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="invoiceAuditDate" name="invoiceAuditDate" value="${invoiceAuditDate}"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;发票管理</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：发票查询</TD>
            <td align="right" width="40%" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keye==1)}">
            		<img btn=btn src="${ctx }/img/newbtn/btn_fpxz_0.png" title='发票新增' onClick="insert()" >
            	</c:if>
				<img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
        </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
      </TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
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
                          <TD width="24%" class="table_none"><input clean=clean class="text_input160" value="${invoiceID }" name="invoiceID" ></TD>
                          <TD width="9%" class="table_body">制造商</TD>
			               <TD class="table_none" width="30%">
						   			<li class="horizontal_onlyRight">
							   			<input clean=clean id="supplierName" readonly="readonly" class="text_input160" name="supplierName" value="${supplierName}" />
							   			<input clean=clean type="hidden" id="supplierID" name="supplierID" value="${supplierID }" readonly="readonly" />
									</li>
						   			<li class="horizontal_onlyRight">
						  			    <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();" >	
						  			</li>
						   	</TD>
						  <TD width="9%" class="table_body" >审核状态</TD>
                           <TD class="table_none" width="24%" >
						   <select clean=clean id="invoiceAuditStatue" name="invoiceAuditStatue">
                            <option value="" selected>----请选择----</option>
                            <option value='1' ${invoiceAuditStatue=='1'?'selected=selected':'' }>已审核</option>
                            <option value='0' ${invoiceAuditStatue=='0'?'selected=selected':'' }>未审核</option>
                          </select>	</TD>	
                        </TR>
                        <TR height="26px">
                          <TD class="table_body">发票类型</TD>
                          <TD class="table_none"> 
					           <SELECT clean=clean id="invoiceType" name="invoiceType" >
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
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('invoiceStartDate','invoiceEndDate')" >
                            </li>
                            
					        </TD>   
					      <TD class="table_body">制作人工号</TD>
                          <TD class="table_none"><input clean=clean class="text_input160" type="text" id="invoiceCreatePersonID" name="invoiceCreatePersonID" value="${invoiceCreatePersonID}" /></TD>       
                        </TR>
                        <TR height="26px">
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none" colspan="7"> 
                          <li class="horizontal_onlyRight">
                           <input id="invoiceStartAuditDate" clean=clean 
					       name="invoiceStartAuditDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'invoiceEndAuditDate\')}'})"
					       value="${invoiceStartAuditDate}" /> 至 
					       <input id="invoiceEndAuditDate" clean=clean 
					       name="invoiceEndAuditDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'invoiceStartAuditDate\')}'})" 
					        value="${invoiceEndAuditDate}" />
					        
					      </li><li class="horizontal_onlyRight">            
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('invoiceStartAuditDate','invoiceEndAuditDate')" > </li>                   
					        
					        </TD>  
						  </TR>
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR height="26px">
                          <TD align="left">
							<c:if test="${permissionPo.keyd=='1'}">
							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
							</c:if>
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
                        <TR class=table_title align=middle height="26" >
                          <TD width="5%"><li class="horizontal_onlyRight"><input onclick="chkAll()" id="chks" type="checkbox"></li><li class="horizontal_onlyRight">选择</li></TD>
                          <TH scope=col width="16%" colspan="4">操作</TH>
                          <TH width="13%" height="26" scope=col>发票号</TH>						
                          <TH scope=col width="15%">制造商</TH>
						  <TH scope=col width="8%">发票日期</TH>
						  <TH scope=col width="5%">制作人</TH>
						  <TH scope=col width="8%">成本合计</TH>
						  <TH width="8%" scope=col>税额合计</TH>
						  <TH scope=col width="8%">价税合计</TH>
                      
                        </TR>
                        <TR class=table_title align=middle height="26" >
                          <TD colspan="9" align="right" style="padding-right: 10PX">合计:</TD>
						  <TH>${invoiceEntryPo.lieienottaxrateamount }</TH>
						  <TH>${invoiceEntryPo.lieietaxamount }</TH>
						  <TH>${invoiceEntryPo.lieiecostpriceamount }</TH>

						</TR>  
                        <s:iterator value="invoiceList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" id="invoiceRow" height="26">
						  <TD ><input id=chk name="chk" type="checkbox" value="${liiid }"></TD>						  
                          <TD width="4%">
                          <c:if test="${permissionPo.keya=='1'}">
                          <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${liiid}')" >
                          </c:if>  
                          </TD>
		                  <TD  width="4%">
		                  <c:if test="${permissionPo.keyc=='1'}">
		                    <c:if test="${liiauditstatue != 1}">
		                        <img btn=btn src="${ctx }/img/newbtn/edit_0.png" title='修改' onClick="update('${liiid}')" >                          		
                          	</c:if>
                          	<c:if test="${liiauditstatue == 1}">
                          		<img btn=btn src="${ctx }/img/newbtn/edit_2.png" title='修改'>
                          	</c:if>
                          </c:if>	
		                  </TD>
		                  <TD  width="4%">
		                  <c:if test="${permissionPo.keyb=='1'}">
		                    <c:if test="${liiauditstatue != 1}">
                          		<img btn=btn src="${ctx }/img/newbtn/delete_0.png" title='删除' onClick="del('${liiid}')">
                          	</c:if>
                          	<c:if test="${liiauditstatue == 1}">
                          		<img btn=btn src="${ctx }/img/newbtn/delete_2.png" title='删除'>
                          	</c:if>
                          	 </c:if>
		                  </TD>
		                  <TD  width="4%">
		                  <c:if test="${permissionPo.keyk=='1'}">
		                  	<c:if test="${liiauditstatue != 0}">
                          		<img btn=btn src="${ctx }/img/newbtn/unaudit_0.png" title='反审核' onClick="unAudit('${liiid}')">
                          	</c:if>
                          	<c:if test="${liiauditstatue == 0}">
                          		<img src="${ctx }/img/newbtn/unaudit_2.png" title='反审核'>
                          	</c:if>
                          	</c:if>
		                  </TD>
                          
						  <TD>${liiid }</TD>
                          <TD>${liidepartmentname }</TD>
						  <TD>${fn:substring(liidate,0,10) }</TD>
						  <TD>${liicreatepersonname}</TD>
                          <TD>${liinottaxrateamount }</TD>
                          <TD>${liitaxamount }</TD>
                          <TD>${liicostpriceamount }</TD>
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