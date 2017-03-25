<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>收款单管理</title>		
<script type="text/javascript">
	
   /**
    *  新增收款单
    */ 
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initReceiptMentBillInsert.action?&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initReceiptMentBillInsert.action?&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【收款单新增】";
	}
	
   /**
    *  初始化修改收款单
    */ 
	function update(billID){ 
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initReceiptMentBillUpdate.action?receiptMentBillID="+billID+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initReceiptMentBillUpdate.action?receiptMentBillID="+billID+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【收款单修改】";
	}
	
   /**
    *  初始化删除收款单
    */ 
	function del(billID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initReceiptMentBillDelete.action?receiptMentBillID="+billID+"&moduleID=${moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【收款单删除】";
		
	}
	
   /**
    *  查询收款单详细信息
    */ 
	function detail(billID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selReceiptMentBillDetail.action?receiptMentBillID="+billID+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selReceiptMentBillDetail.action?receiptMentBillID="+billID+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【收款单详细】";
	}

   /**
    *  重置
    */        
	function clean(){
	    $('#clear').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#clear').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
   /**
    *  根据条件查询相关收款单
    */        
	function search(){
		receiptMentBillSelFrm.action = "selReceiptMentBill.action";
		receiptMentBillSelFrm.submit();
		showLoadingBar();
	}
	
	function unAuditPayMentBill(billID){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initUnAuditReceiptMentBill.action?receiptMentBillID="+billID+"&moduleID=${moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【收款单反审核】";
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
            alert("请先选取需要审核的收款单!");
            return;
        }		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initAuditReceiptMentBill.action?moduleID="+document.getElementById('moduleID').value+"&receiptMentBillID="+objValue,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【收款单审核】";
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
            alert("请先选取需要反审核的收款单!");
            return;
        }		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initUnAuditPayMentBill.action?receiptMentBillID="+objValue+"&moduleID=${moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【收款单反审核】";
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
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form method="post" id="receiptMentBillSelFrm" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 id="clear">
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;收款管理</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：收款单查询</TD>
            <td align="right" width="40%" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            		<img btn=btn src="${ctx }/img/newbtn/btn_shoukuandanxinzeng_0.png" title='收款单新增' onClick="insert()" >
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26px">
                          <TD width="9%" class="table_body">收款单号</TD>
                          <TD width="28%" class="table_none"><input clean=clean class="text_input160" id="receiptMentBillID" name="receiptMentBillID" type="text" value="${receiptMentBillID}" maxlength="30"></TD>
                          <TD width="9%" class="table_body">客户名称</TD>
                          <TD class="table_none" width="28%">
                           <select clean=clean id="franchiseeID" name="franchiseeID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsPos)}">
	                             	<c:forEach var="dp" items="${departmentsPos}">
	                             		  <OPTION value="${dp.bdpdepartmentid}" ${franchiseeID!= dp.bdpdepartmentid  ? '' : 'selected="selected"' } >${dp.bdpdepartmentname} </OPTION>	                             		
	                             	</c:forEach>               	  
                    	        </c:if>
      	                   </select>
                          </TD>
                          <TD width="9%" class="table_body" >审核状态</TD>
                           <TD class="table_none" width="24%">
						   <select clean=clean name="auditStatue">
                            <option value="">----请选择----</option>
                            <option value='0' ${auditStatue == '0' ? 'selected="selected"' : '' }>未审核</option>
                            <option value='1' ${auditStatue == '1' ? 'selected="selected"' : '' }>已审核</option>
                          </select>						   
                          </TD>
                        </TR>
                        <TR height="26px">
						  <TD class="table_body">制单日期</TD>
                          <TD class="table_none">
                         <li class="horizontal_onlyRight">
                           <input clean=clean id="billStartTime"
					       name="billStartTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'billEndTime\')}'})"
					       value="${billStartTime }" /> 至 
					       <input clean=clean id="billEndTime"
					       name="billEndTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'billStartTime\')}'})" 
					        value="${billEndTime }" />
					        
					     </li><li class="horizontal_onlyRight">
                             <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('billStartTime','billEndTime')" >
                            </li>
					        
					      </TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input clean=clean id="auditStartTime"
					       name="auditStartTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'auditEndTime\')}'})"
					       value="${auditStartTime }" /> 至 
					       <input clean=clean id="auditEndTime"
					       name="auditEndTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'auditStartTime\')}'})" 
					        value="${auditEndTime }" />
					        
					      </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('auditStartTime','auditEndTime')" >
                            </li>
					        
					         </TD>    
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none">
                            <input clean=clean type="text" class="text_input160" id="createPersonID" name="createPersonID" value="${createPersonID}">
                          </TD> 
                        </TR>                    
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${permissionPo.keyd == '1'}">
							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >			
							<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >							
						  </c:if>	
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
                    <c:if test="${not empty(receiptMentBillList)}">
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
                          <TD width="5%"><input onclick="chkAll()" id="chks" type="checkbox">选择</TD>
                          <TH scope=col width="12%" colspan="4">操作</TH>
                          <TH scope=col width="15%" height="26">收款单号</TH>
                          <TH scope=col width="10%">客户名称</TH>
						  <TH scope=col width="12%">制单日期</TH>						
                          <TH scope=col width="8%">制单人</TH>
                          <TH scope=col width="12%">审核日期</TH>						  
						  <TH scope=col width="8%">审核人</TH>
						  <TH scope=col width="8%">已收款金额</TH>                         
                        </TR>
                      <s:iterator value="receiptMentBillList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input id="chk" name="chk" type="checkbox" value="${sLrbrbID }"></TD>
                         <c:if test="${sLrbrbAuditStatue=='1'}">                          
                          <TD width="3%">
                          <c:if test="${permissionPo.keye == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLrbrbID}')" >
		                   </c:if>
		                  </TD>
		                  <TD width="3%">
		                   <c:if test="${permissionPo.keyc == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/edit_2.png" title='修改'>
		                   </c:if>
		                  </TD>
                          <TD width="3%">
                          <c:if test="${permissionPo.keyb == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/delete_2.png" title='删除'>
		                  </c:if>
		                  </TD>
		                  <TD width="3%">
		                  <c:if test="${permissionPo.keyh == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/unaudit_0.png" title='反审核' onClick="javascript:unAuditPayMentBill('${sLrbrbID}')">
		                  </c:if>
		                  </TD>                  
		                  </c:if>		                  
		                  <c:if test="${sLrbrbAuditStatue=='0'}">		                  
                          <TD width="3%">
                          <c:if test="${permissionPo.keye == '1'}">
                              <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLrbrbID}')" >
		                  </c:if>
		                  </TD>
		                  <TD width="3%">
		                   <c:if test="${permissionPo.keyc == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/edit_0.png" title='修改' onClick="javascript:update('${sLrbrbID}')" >  
		                   </c:if>
		                  </TD>
		                  <TD width="3%">
		                   <c:if test="${permissionPo.keyb == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/delete_0.png" title='删除' onClick="javascript:del('${sLrbrbID}')">
		                   </c:if>
		                  </TD>
		                  <TD width="3%">
		                   <c:if test="${permissionPo.keyh == '1'}">
                             <img src="${ctx }/img/newbtn/unaudit_2.png" title='反审核'>
		                   </c:if>
		                  </TD>
		                  </c:if>
                          <TD>${sLrbrbID}</TD>
                          <TD>${sLrbrbFranchiseeName}</TD>
                          <TD>${sLrbrbDate}</TD>
                          <TD>${sLrbrbCreatePersonName}</TD>    
                          <TD>${sLrbrbAuditDate}</TD>
                          <TD>${sLrbrbAuditPersonName}</TD>
                          <TD>${sLrbrbCurrentReceiptMentAmount}</TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>