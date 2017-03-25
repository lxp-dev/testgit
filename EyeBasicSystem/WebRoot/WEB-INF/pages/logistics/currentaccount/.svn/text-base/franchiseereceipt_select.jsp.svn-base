<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>往来账管理</title>		
<script type="text/javascript">
	
   /**
    *  查询往来账详细信息
    */ 
	function detail(franchiseeID,franchiseeName){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("franchiseeCurrentAccountDetail.action?franchiseeID="+franchiseeID+"&moduleID=${moduleID}&startDate="+$('#startDate').val()+"&endDate="+$('#endDate').val()+"&franchiseeName="+EncodeUtf8(franchiseeName),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("franchiseeCurrentAccountDetail.action?franchiseeID="+franchiseeID+"&moduleID=${moduleID}&startDate="+$('#startDate').val()+"&endDate="+$('#endDate').val()+"&franchiseeName="+EncodeUtf8(franchiseeName),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【往来账详细】";
	}

   /**
    *  查询往来账详细信息
    */ 
	function printReport(id,name){
		var BeginDate = $('#startDate').val();
		var End = $('#endDate').val();
		if (End == ''){
            alert("请选取截止日期!");
            return
		}
		var DataURL = "report.action?reportlet=logistics_jmlduizhangdanRpt.cpt&departmentID="+id+"&bgnDate="+BeginDate+"&endDate="+End+"&departmentName="+EncodeUtf8(name); 
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【客户批发往来明细表】";
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
    *  根据条件查询制造商往来账
    */        
	function search(){
	    if ($('#endDate').val()== ''){
	        alert("请先选择截止日期!");
	        return;
	    }
	    payMentBillSelFrm.action = "franchiseeCurrentAccountSel.action";
	    payMentBillSelFrm.submit();
		showLoadingBar();
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
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 id="clear">
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;收款管理</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：应收款往来账查询</TD>
          <TD align="right" width="45%" valign="bottom">&nbsp;
          <img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
          </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR></TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
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
                          <TD width="9%" class="table_body">客户名称</TD>
                          <TD class="table_none" width="30%">
                           <select clean=clean id="franchiseeID" name="franchiseeID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsPos)}">
	                             	<c:forEach var="dp" items="${departmentsPos}">
	                             		  <OPTION value="${dp.bdpdepartmentid}" ${franchiseeID!= dp.bdpdepartmentid  ? '' : 'selected="selected"' } >${dp.bdpdepartmentname} </OPTION>	                             		
	                             	</c:forEach>               	  
                    	        </c:if>
      	                   </select>
                          </TD>
						  <TD width="9%" class="table_body">查询日期</TD>
                          <TD width="30%" class="table_none">
                         <li class="horizontal_onlyRight">
                           <input id="startDate" clean=clean
					       name="startDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endDate\')}'})"
					       value="${startDate }" /> 至 
					       <input id="endDate" clean=clean
					       name="endDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startDate\')}'})" 
					        value="${endDate }" />
					        
					     </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('startDate','endDate')"></li>
					     <li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_month_0.png" title="当月" onClick="currtMonth('startDate','endDate')"></li>   
					      </TD>
                        </TR>                       
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${permissionPo.keya == '1'}">							
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
                    <c:if test="${not empty(departmentsList)}">
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
                          <TH scope=col width="4%">操作</TH>
                          <TH scope=col width="6%" height="26">客户编号</TH>
                          <TH scope=col width="30%">客户名称</TH>
						  <TH scope=col width="8%">联系人</TH>						
                          <TH scope=col width="10%">联系方式</TH>
                          <TH scope=col width="9%">应收金额</TH>	
                        </TR>
                        <TR class=table_title >
                          <TH scope=col height="26" colspan="5" align=right style="padding-right: 60px">合计:</TH>
                          <TH scope=col align="center">${amountSum}</TH>	
                        </TR>
                      <s:iterator value="departmentsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD  width="4%">
                          <c:if test="${permissionPo.keyb == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:printReport('${bdpdepartmentid}','${bdpdepartmentname}')">
                              </c:if>
		                  </TD>
                          <TD height="26">${bdpdepartmentid}</TD>
                          <TD>${bdpdepartmentname}</TD>
                          <TD>${bdpperson}</TD>
                          <TD>${bdpphone}</TD>
                          <TD>${bdpcontactamount}</TD>
                          		                 
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