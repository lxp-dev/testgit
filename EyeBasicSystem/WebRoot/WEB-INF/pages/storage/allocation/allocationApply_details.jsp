<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品调拨管理</title>
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

	function receiveAllocation(){
		$('#recTD').hide();
		allocationForm.action = "receiveAllocation.action";
		allocationForm.submit();
		
	}
    function printReport(id){		
		var DataURL = "report.action?reportlet=storage_ApplyallocationRpt.cpt&billid="+id;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【调拨申请单】";
    }
    $(document).ready(function() {
    		var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
			
			var needTotal=0;
			$('input[name=needNumber]').each(function(){
				needTotal=accAdd(needTotal,$(this).val());
			});
			$('#needTotal').text(needTotal);
			
			var priceTotal=0;
			$('input[name=price]').each(function(){
				priceTotal=accAdd(priceTotal,$(this).val());
			});
			$('#retailprice').text(priceTotal);
    });
    
    function returnAudit(){
    	allocationForm.action = "returnAudit.action";
    	allocationForm.submit();
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="smsFlag"  value="${smsFlag }" /> 
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">调拨申请单详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    <c:if test="${statusPo.cshastatusorderid != null}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initProcurementOrdersView.action?hid=${statusPo.cshastatusorderid}';"
                      UNSELECTABLE="on">采购订单详细</TD>
					    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                    </c:if>
					<c:if test="${statusPo.cshastatusreceiptid != null}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='procurementReceiptDetails.action?hid=${statusPo.cshastatusreceiptid}';"
                      UNSELECTABLE="on">采购收货单详细</TD>
					    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                    </c:if>
                    <c:if test="${statusPo.cshastatusbillid != null}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='allocationDetails.action?hid=${statusPo.cshastatusbillid}';"
                      UNSELECTABLE="on">商品调拨单详细</TD>
					    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                    </c:if> 
                    </TD>
					</TR></TBODY></TABLE></TD>
						<TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif align="right">
							<s:action name="getFittingTemplateTypeInfo" executeResult="true">
								<s:param name="actionTypeID">14</s:param>
	                    		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
	                    		<s:param name="actionFinereportRequestString">&billid=${allocationPo.cshaabillid}</s:param>
	                    		<s:param name="actionReportingServiceRequestString"></s:param>
	                    		<s:param name="actionReportTitle">调拨申请单打印</s:param>
	                    	</s:action>
			            </TD>
					</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">申请单号</TD>
                          <TD width="24%" class="table_none">${allocationPo.cshaabillid}<input type="hidden" id="cshaabillid" name="cshaabillid" value="${allocationPo.cshaabillid}"></TD>
                          <TD width="9%" class="table_body" height="26">申请部门</TD>
                          <TD width="24%" class="table_none">
                          ${allocationPo.cshaaoutdepartmentname}
                          </TD>					       
						  <TD class="table_body" width="9%" height="26">商品类型</TD>
                          <TD class="table_none">${allocationPo.goodscategoryname}&nbsp;</TD>			       
						</TR>
                        <TR>
                          <TD class="table_body">制造商</TD>
						  <TD height="26" align="left" class="table_none" >
						   		${allocationPo.chaasuppliername}
						   		<input type="hidden" id="chaasupplier" name="allocationPo.chaasupplier" value="${allocationPo.chaasupplier}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '制造商不能为空！'}]"/>
                          </TD>
                          <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		${requestScope.brandName}
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
			              </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none" >${allocationPo.cshaacreatepersonname}<input type="hidden" name="allocationPo.cshaacreateperson" value="${person.id}"></TD>		       
                          <TD class="table_body">制单日期</TD>
                          <TD class="table_none" colspan="3">
                          ${fn:substring(allocationPo.cshaabilldate,0,16)}
                          </TD>	
						</TR>
                        <TR>
                          <TD class="table_body"  height="26">审核人</TD>
                          <TD class="table_none" > ${allocationPo.cshaaauditpersonname}&nbsp;</TD>
                          <TD class="table_body"  height="26">审核日期</TD>
                          <TD class="table_none" colspan="3"> ${fn:substring(allocationPo.cshaaauditdate,0,16)}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          ${allocationPo.cshaaremark}&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                       
                          <TH width="20%" scope=col height="28">商品代码</TH>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="25%" scope=col>型号</TH>
                          <TH width="15%" scope=col>零售价格</TH>
                          <TH width="10%" scope=col>需求数量</TH>      
                                        
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	<!--<TH scope=col width="5%" id="retailprice">0</TH>-->
						  	
						  	<TH scope=col width="5%" id="needTotal">0</TH>
					    	
				   		</TR>
                        <s:iterator value="allocationEntryList" status="idx">
                        <TR class="row">
                        <TD height="26">${cshaaegoodsid}</TD>
                        <TD>${cshaaegoodsname}</TD>
                        <TD>${cshaaespec}</TD>
                        <TD>${cshaaebgiretailprice}<input type="hidden" class="text_input60" name="price" value="${cshaaebgiretailprice}" /></TD>
                        <TD>${cshaaerequirementquantity}<input type="hidden" class="text_input60" name="needNumber" value="${cshaaerequirementquantity}" /></TD>                                                                        
                       
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>