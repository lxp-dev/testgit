<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>仓库管理</title>
</head>
<script>
function showStockDetails(warehouseID,sph,cyl){
    var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("selStockSearchLs.action?moduleID=${moduleID}&goodsCategoryID=${goodsCategoryID}&supplierID=${supplierID}&brandID=${brandID}&bgiwarehouseid="+warehouseID+"&sph=" + sph+"&cyl=" + cyl + "&isCustomize=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("selStockSearchLs.action?moduleID=${moduleID}&goodsCategoryID=${goodsCategoryID}&supplierID=${supplierID}&brandID=${brandID}&bgiwarehouseid="+warehouseID+"&sph=" + sph+"&cyl=" + cyl + "&isCustomize=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【库存变更记录】";
}
function showSalseDetails(warehouseID,sph,cyl){
    var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("selSalseSearchLs.action?moduleID=${moduleID}&goodsCategoryID=${goodsCategoryID}&supplierID=${supplierID}&brandID=${brandID}&bgiwarehouseid="+warehouseID+"&sph=" + sph+"&cyl=" + cyl + "&isCustomize=0&enddate=${enddate}&startdate=${startdate}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("selSalseSearchLs.action?moduleID=${moduleID}&goodsCategoryID=${goodsCategoryID}&supplierID=${supplierID}&brandID=${brandID}&bgiwarehouseid="+warehouseID+"&sph=" + sph+"&cyl=" + cyl + "&isCustomize=0&enddate=${enddate}&startdate=${startdate}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【销售变更记录】";
}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="reportFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>

<c:if test="${queryType ==1}">
<iframe id="reportFrame" src="report.action?reportlet=storage_luminosityerweiqueryRpt.cpt&__bypagesize__=false&goodsCategoryID=${goodsCategoryID}&supplierID=${supplierID}&brandID=${brandID}&warehouseID=${warehouseID}&makeinvoiceflags=${makeinvoiceflags}&makeinvoiceflag=${makeinvoiceflag}&selecttype=${selecttype}" width="100%" height="100%">
</iframe>
</c:if>
<c:if test="${queryType ==2}">
<iframe id="reportFrame" src="report.action?reportlet=storage_luminosityerweiqueryRpt1.cpt&__bypagesize__=false&goodsCategoryID=${goodsCategoryID}&supplierID=${supplierID}&brandID=${brandID}&warehouseID=${warehouseID}&makeinvoiceflags=${makeinvoiceflags}&makeinvoiceflag=${makeinvoiceflag}&enddate=${enddate}&startdate=${startdate}&selecttype=${selecttype}" width="100%" height="100%">
</iframe>
</c:if>
<c:if test="${queryType ==3}">
<iframe id="reportFrame" src="report.action?reportlet=storage_luminosityerweiqueryRpt5.cpt&__bypagesize__=false&goodsCategoryID=${goodsCategoryID}&supplierID=${supplierID}&brandID=${brandID}&warehouseID=${warehouseID}&makeinvoiceflags=${makeinvoiceflags}&makeinvoiceflag=${makeinvoiceflag}&enddate=${enddate}&startdate=${startdate}&selecttype=${selecttype}" width="100%" height="100%">
</iframe>
</c:if>
</DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>