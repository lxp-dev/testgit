<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>财务管理</title>
</head>
<script>
function billdetail(billid){
	var DataUrl = '';
	if (billid.indexOf('PIN') >= 0 ){
	  DataUrl = 'initFinancialSettlementDetails.action?hid='+billid;
	}
	if (billid.indexOf('CPIN') >= 0 ){
	  DataUrl = 'initConsignProcessSettlementDetails.action?hid='+billid;
	}
	if (billid.indexOf('POUT') >= 0 ){
	  DataUrl = 'initProcurementReturnDetails.action?hid='+billid;
	}
	if (billid.indexOf('PB') >= 0 ){
	  DataUrl = 'payMentBillDetailByReport.action?hid='+billid;
	}

	var topRows = top.document.getElementById("total").rows; 
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){		
    	showPopWin(DataUrl,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{			
    	showPopWin(DataUrl,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【单据明细】";
}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="reportFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>

<iframe id="reportFrame" src="report.action?reportlet=logistics_supplierduizhangdanRpt.cpt&__bypagesize__=false&supplierID=${supplierID}&bgnDate=${bgnDate}&endDate=${endDate }&logincompanyid=${person.personcompanyid }" width="100%" height="100%">
</iframe>

</DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>