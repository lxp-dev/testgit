<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>其他付款单管理</title>		
<script type="text/javascript">
   	
   	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	payMentBillSelFrm.action=link;
	  	payMentBillSelFrm.submit();
		showLoadingBar();
	}
	
   /**
    *  新增付款单
    */ 
	function insert(){	       

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initPayMentBillOtherInsert.action?&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPayMentBillOtherInsert.action?&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【其他付款单新增】";
	}
	
   /**
    *  初始化修改付款单
    */ 
	function update(billID){	       
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initPayMentBillOtherUpdate.action?payMentBillID="+billID+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPayMentBillOtherUpdate.action?payMentBillID="+billID+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【其他付款单修改】";
	}
	
   /**
    *  初始化删除付款单
    */ 
	function del(billID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initPayMentBillOtherDelete.action?payMentBillID="+billID+"&moduleID=${moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【其他付款单删除】";
	}
	
   /**
    *  查询付款单详细信息
    */ 
	function detail(billID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selPayMentBillOtherDetail.action?payMentBillID="+billID+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selPayMentBillOtherDetail.action?payMentBillID="+billID+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【其他付款单详细】";
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
    *  根据条件查询相关付款单
    */        
	function search(){
	    payMentBillSelFrm.action = "selPayMentBillOther.action";
	    payMentBillSelFrm.submit();
		showLoadingBar();
	}
	
	function unAuditPayMentBill(billID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initAuditUnPayMentBillOther.action?payMentBillID="+billID+"&moduleID=${moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【其他付款单反审核】";
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
<form method="post" id="payMentBillSelFrm" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 id="clear" >
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="18%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;其他付款单管理</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：其他付款单查询</TD>
          <TD align="right" width="45%" valign="bottom">&nbsp;
          <c:if test="${permissionPo.keya == '1'}">          
                <img btn=btn src="${ctx }/img/newbtn/btn_qtfkdxz_0.png" title='其他付款单新增' onClick="insert()">
          </c:if>
          <img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
          </TD>
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
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1" >
                      <TBODY>
                        <TR height="26px">
                          <TD width="9%" class="table_body">其他付款单号</TD>
                          <TD width="30%" class="table_none"><input clean=clean class="text_input160" id="payMentBillID" name="payMentBillID" type="text" value="${payMentBillID}" maxlength="30"></TD>
                          <TD width="9%" class="table_body">制造商</TD>
                          <TD class="table_none" width="30%">
                          <li class="horizontal_onlyRight">
                            <input clean=clean type="text" id="supplierName" name="supplierName" class="text_input160" readonly="readonly" value="${supplierName}">
                            <input clean=clean type="hidden" id="supplierID" name="supplierID" class="text_input160" readonly="readonly" value="${supplierID}">
                          </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onclick="openSupplier();">
                            </li>
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
						  <TD class="table_body">付款单日期</TD>
                          <TD class="table_none">
                         <li class="horizontal_onlyRight">
                           <input id="billStartTime" clean=clean
					       name="billStartTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'billEndTime\')}'})"
					       value="${billStartTime }" /> 至 
					       <input id="billEndTime" clean=clean
					       name="billEndTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'billStartTime\')}'})" 
					        value="${billEndTime }" />
					        
					     </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('billStartTime','billEndTime')"></li>
					        
					      </TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input id="auditStartTime" clean=clean
					       name="auditStartTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'auditEndTime\')}'})"
					       value="${auditStartTime }" /> 至 
					       <input id="auditEndTime" clean=clean
					       name="auditEndTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'auditStartTime\')}'})" 
					        value="${auditEndTime }" />
					        
					      </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('auditStartTime','auditEndTime')"></li>
					        
					         </TD>    
                          <TD class="table_body">制作人</TD>
                          <TD class="table_none">
                            <input clean=clean type="text" class="text_input160" id="createPersonID" name="createPersonID" value="${createPersonID}">
                          </TD> 
                        </TR>  
                        <TR height="26px">
                          <TD class="table_body">部门名称</TD>
                          <TD class="table_none" colspan="5">
                          	   <select clean=clean id="departmentID" name="departmentID" >      		                       
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${departmentID == bdpdepartmentid ? 'selected="selected"' : ''}>${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
      	                       </select>
                          
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
                    <c:if test="${not empty(payMentBillList)}">
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
                          <TH scope=col width="16%" colspan="4">操作</TH>
                          <TH scope=col width="15%" height="26">其他付款单号</TH>
                          <TH scope=col width="16%">制造商</TH>
						  <TH scope=col width="9%">制单日期</TH>						
                          <TH scope=col width="10%">制单人</TH>
                          <TH scope=col width="9%">审核日期</TH>						  
						  <TH scope=col width="8%">审核人</TH>
						  <TH scope=col width="8%">金额(含税)</TH>
                        </TR>
                      <s:iterator value="payMentBillList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        <c:if test="${sLpbpbAuditStatue=='1'}">
                          <TD width="4%">
                           <c:if test="${permissionPo.keye == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLpbpbID}')">
                              </c:if>
		                  </TD>
		                  <TD width="4%">
		                   <c:if test="${permissionPo.keyc == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/edit_2.png" title='修改'>
                              </c:if>
		                  </TD>
                          <TD width="4%">
                           <c:if test="${permissionPo.keyb == '1'}">                             
                                  <img btn=btn src="${ctx }/img/newbtn/delete_2.png" title='删除'>
                              </c:if>
		                  </TD>
		                  <TD width="4%">
		                   <c:if test="${permissionPo.keyh == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/unaudit_0.png" title='反审核' onClick="javascript:unAuditPayMentBill('${sLpbpbID}')">
                              </c:if>
		                  </TD>
		                  </c:if>		                  
		                  <c:if test="${sLpbpbAuditStatue=='0'}">
                          <TD width="4%">
                           <c:if test="${permissionPo.keye == '1'}">
                              <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLpbpbID}')">
                               </c:if>
		                  </TD>
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyc == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/edit_0.png" title='修改' onClick="javascript:update('${sLpbpbID}')">
                              </c:if>
		                  </TD>
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyb == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/delete_0.png" title='删除' onClick="javascript:del('${sLpbpbID}')">
                              </c:if>
		                  </TD>
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyh == '1'}">
                            <img src="${ctx }/img/newbtn/unaudit_2.png" title='反审核'>
                              </c:if>
		                  </TD>
		                  </c:if>
                          <TD height="26">${sLpbpbID}</TD>
                          <TD>${sLpbpbSupplierName}</TD>
                          <TD>${fn:substring(sLpbpbDate,0,10)}</TD>
                          <TD>${sLpbpbCreatePersonName}</TD>    
                          <TD>${fn:substring(sLpbpbAuditDate,0,10)}</TD>
                          <TD>${sLpbpbAuditPersonName}</TD>
                          <TD>${sLpbpbPayMentAmount}</TD>

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