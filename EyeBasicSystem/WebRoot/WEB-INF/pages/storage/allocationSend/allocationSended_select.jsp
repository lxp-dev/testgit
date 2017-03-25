<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜管理</title>
</head>
<script>	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
	}
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
	
	function search(){
		$("img").removeAttr("onclick");
		doorStoreDeliveryForm.action = "selectAllocationSended.action";
		doorStoreDeliveryForm.submit();
		showLoadingBar();
	}

	function doorStoreDelivery_JD(){
		$("img").removeAttr("onclick");

		var url = "initSelectAllocationSend.action?moduleID="+$('#moduleID').val();
		doorStoreDeliveryForm.action = url;
		doorStoreDeliveryForm.submit();
	}
	
	function detail(id){
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectAllocationSendedDetail.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectAllocationSendedDetail.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【配送单详细】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="doorStoreDeliveryForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：调拨配送</TD>
            <Td align="right" valign="bottom">&nbsp;
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </Td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="doorStoreDelivery_JD()"
                      UNSELECTABLE="on">未配送调拨单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD> 
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">已配送调拨单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR>
					</TBODY>
				  </TABLE>
				</TD></TR>
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
						   <TD width="8%" height="26" class="table_body">配送单号</TD>
			               <TD class="table_none" width="24%">
                            <input clean=clean class="text_input160" type="text"  id="deliveryBillID" name="deliveryBillID" value="${requestScope.deliveryBillID}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">配送日期</TD>
                           <TD width="31%" class="table_none">
                           <li class="horizontal_onlyRight">
                           <input id="deliveryStartDate" clean=clean 
					       name="deliveryStartDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'deliveryEndDate\')}'})"
					       value="${requestScope.deliveryStartDate}" /> 至 
					       <input id="deliveryEndDate" clean=clean 
					       name="deliveryEndDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'deliveryStartDate\')}'})" 
					        value="${requestScope.deliveryEndDate}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('deliveryStartDate','deliveryEndDate')"></li>
			               </TD>
                      	   <TD width="8%" height="26" class="table_body">配送人工号</TD>
			               <TD class="table_none">
			               <input clean=clean class="text_input160" type="text"  id="deliveryPerson" name="deliveryPerson" value="${requestScope.deliveryPerson}">
                           </TD>
                        </TR>
                    	<TR>
                    	   <TD height="26" class="table_body">发出部门</TD>
                    	   <TD height="26" class="table_none">
                    	   	${person.bdpdepartmentname }<input type="hidden" clean=clean id="outdepartment" name="outdepartment" value="${person.departmentID }">
                    	   </TD>
                    	   <TD class="table_body">调拨单号</TD>
			               <TD class="table_none" colspan="3">
                            <input clean=clean class="text_input160" type="text"  id="deliverySalesBillID" name="deliverySalesBillID" value="${requestScope.deliverySalesBillID}">
			               </TD>
                        </TR>                          
                      </TBODY>
                    </TABLE>
                   <c:if test="${(permissionPo.keya==1)}">  
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					</c:if>
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
                  <c:if test="${not empty(distributionList)}"> 
                           <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR class=table_title align=middle>
						  <TH width="4%" height="26" scope=col>操作</TH>
						  <TH width="25%" scope=col>配送单号</TH>
                          <TH width="15%" scope=col>配送时间</TH>
                          <TH width="20%" scope=col>配送人</TH>
                         </TR>
		
					 <s:iterator value="distributionList">
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="4%" height="26"><img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sdndnid}')" ></TD>
                          <TD>${sdndnid}</TD>
                          <TD>${fn:substring(sdndncreatedate,0,16) }</TD>             			   
                          <TD>${sdndnPerson }</TD>                
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