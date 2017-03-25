<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库管理</title>
<style>
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.FixedTitleRow
{
    position: relative; 
    top: expression(this.offsetParent.scrollTop); 
    z-index: 10;
    background-color: #CC6666;
}

.FixedTitleColumn
{
    position: relative; 
    left: expression(this.parentElement.offsetParent.scrollLeft);
}

.FixedDataColumn
{
    position: relative;
    left: expression(this.parentElement.offsetParent.parentElement.scrollLeft);
    background-color: #7898a8;
}	
</style>
</head>
<script>
	var i = 800;
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});	

	    //$('#tablelist').attr('width',i);
	    document.getElementById("tablelist").style.width = i;
	   	
	});

	function showStockDetails(bgigoodsid,bgiwarehouseid){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectStockGoodsinfoPo.action?bgigoodsid="+bgigoodsid+"&bgiwarehouseid=" + bgiwarehouseid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectStockGoodsinfoPo.action?bgigoodsid="+bgigoodsid+"&bgiwarehouseid=" + bgiwarehouseid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品详细】";
	}

	function showBrandDetails(bgibrandsid,bgiwarehouseid,bgiretailprice){
		var bgispecjj='${bgispecjj}';              //型号
    	var bgicolorjj='${bgicolorjj}';            //色号
    	var bgiframesizejj='${bgiframesizejj}';         //尺寸 
    	var bgieyeglassmaterialtypejp='${bgieyeglassmaterialtypejp}'; //镜片材料分类
    	var bgirefractivejp='${bgirefractivejp}'; //镜片折射率
    	var bgiismutiluminosityjp='${bgiismutiluminosityjp}'; //镜片光度分类
    	var minSphjp='${minSphjp}'; //镜片球镜范围
    	var maxSphjp='${maxSphjp}'; //镜片球镜范围
    	var minCyljp='${minCyljp}'; //镜片柱镜范围
    	var maxCyljp='${maxCyljp}'; //镜片柱镜范围
    	var bgiusetypeyj='${bgiusetypeyj}'; //隐形使用类型
    	var bgistealthclassyj='${bgistealthclassyj}'; //抛弃型分类
    	var minSphyj='${minSphyj}'; //隐形球镜范围
    	var maxSphyj='${maxSphyj}'; //隐形球镜范围
    	var minCylyj='${minCylyj}'; //隐形柱镜范围
    	var maxCylyj='${maxCylyj}'; //隐形柱镜范围
    	var isClosed = '${isUse}' ; //商品状态
    	var bgitechnologytypeid = '${bgitechnologytypeid}' ; //工艺类型
    	var bgiframematerialtype = '${bgiframematerialtype}' ; //镜架材质

	    var url = "&bgispecjj="+bgispecjj+"&bgicolorjj="+bgicolorjj+"&bgiframesizejj="+bgiframesizejj+"&bgieyeglassmaterialtypejp="+bgieyeglassmaterialtypejp+
	    		  "&bgirefractivejp="+bgirefractivejp+"&bgiismutiluminosityjp="+bgiismutiluminosityjp+"&minSphjp="+minSphjp+"&maxSphjp="+maxSphjp+
	    		  "&minCyljp="+minCyljp+"&maxCyljp="+maxCyljp+"&bgiusetypeyj="+bgiusetypeyj+"&bgistealthclassyj="+bgistealthclassyj+
	    		  "&minSphyj="+minSphyj+"&maxSphyj="+maxSphyj+"&minCylyj="+minCylyj+"&maxCylyj="+maxCylyj+"&isClosed="+isClosed+"&bgitechnologytypeid="+bgitechnologytypeid+"&bgiframematerialtype="+bgiframematerialtype;

	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selStockSearch.action?moduleID=${requestScope.moduleID}&searchKey=openwindow&radio_type=goods&price_group=yes&usingWarehouse=0&warehouseStatus=1&bgiretailbeginprice="+bgiretailprice+"&bgiretailendprice="+bgiretailprice+"&whichretail=1"+"&goodsID="+bgibrandsid+"&warehouseID=" + bgiwarehouseid+url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selStockSearch.action?moduleID=${requestScope.moduleID}&searchKey=openwindow&radio_type=goods&price_group=yes&usingWarehouse=0&warehouseStatus=1&bgiretailbeginprice="+bgiretailprice+"&bgiretailendprice="+bgiretailprice+"&whichretail=1"+"&goodsID="+bgibrandsid+"&warehouseID=" + bgiwarehouseid+url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品详细】";
	}
	
</script>
<body style=""  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="departmenttype" name="departmenttype" value="${departmenttype}">
<input type="hidden" id="departmentID" name="departmentID" value="${departmentID}">

<DIV id="list_div" style="overflow:auto;height:99%;width:100%;cursor:default;display:inline;position:absolute;">
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
								
					  <table id="tablelist" border=0 align="left" cellpadding=1 cellspacing=1 style="overflow:auto;" width="100%">
                      <TBODY>
                        <TR align=middle height="26" class="table_title FixedTitleRow">   
                          <TH width="190" class="FixedTitleColumn">${queryAngle eq '2' ? '品种代码' : '商品代码'}</TH>
                          <c:if test="${systemParameterPo.fspselectstocktype == '1'}">
                          <TH width="200" class="FixedTitleColumn">${queryAngle eq '2' ? '品种名称' : '商品名称'}</TH>
                          <TH width="100">商品类别</TH>
                          <TH width="200">制造商</TH>
                          </c:if>
                          <TH width="100">数量小计</TH>
                          <c:if test="${systemParameterPo.fspselectstocktype == '2'}">
                          <TH width="500">商品详细</TH>
                          </c:if>                      
                          <s:iterator value="stockSearchWarehousePos">
                          <TH align="center" width="<c:out value="${fn:length(warehousename)*15}" />">${warehousename}</TH>
                          <script>
							i = accAdd(i,${fn:length(warehousename)*15});
                          </script> 
                          </s:iterator>
						</TR>
				   		<c:forEach var="listw" items="${stockSearchWarehousePoList}" varStatus="status">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')"  style="white-space: nowrap;" mce_style="white-space: nowrap;">

                          <TD height="26" class="FixedDataColumn">
	                          <c:if test="${queryAngle eq '2'}">
	                             <U style="cursor: hand;" onclick="showBrandDetails('${listw['goodsid']}','${bgiwarehouseid }','${listw['retailPrice']}')">${listw['goodsid']}</U>
	                          </c:if>
	                          <c:if test="${queryAngle eq '1'}">
	                             <U style="cursor: hand;" onclick="showStockDetails('${listw['goodsid']}','${bgiwarehouseid }')">${listw['goodsid']}</U>
	                          </c:if>
                          </TD>
                                              
                          <c:if test="${systemParameterPo.fspselectstocktype == '1'}">
                          <td class="FixedDataColumn">${listw['goodsname']}</td>
                          <td>${listw['categoryname']}</td>
                          <td>${listw['suppliername']}</td>
                          </c:if>
                          <c:set var="quantitysum" value="0"></c:set>
                          <s:iterator value="stockSearchWarehousePos">
							<c:set var="quantitysum" value="${quantitysum + listw[warehouseid]}"></c:set>
                          </s:iterator>
                          <TD align="center"><font color="red">${quantitysum}</font></TD>
                          <c:if test="${systemParameterPo.fspselectstocktype == '2'}">
                          <TD align="left">
                            ${listw['categoryname']}&nbsp;
                            ${listw['suppliername']}&nbsp;
                          	${listw['goodsname']}&nbsp;
                          	${listw['goodsname']}&nbsp;
                          	<c:if test="${listw['categoryid'] == '1' || listw['categoryid'] == '6' || listw['categoryid'] == '8'}">
	                          	型号：${listw['spec']}&nbsp;
	                          	颜色：${listw['color']}&nbsp;
	                          	尺寸：${listw['framesize']}
                          	</c:if>
                          	<c:if test="${listw['categoryid'] == '3' || listw['categoryid'] == '4'}">
                          		DS:${listw['sph']}&nbsp;
                          		DC:${listw['cyl']}&nbsp;
                          	</c:if>
                          </TD>
                          </c:if>
   
                          <s:iterator value="stockSearchWarehousePos">
                          <TD>
                          	<c:if test="${empty(listw[warehouseid])}">
                          		&nbsp;<input type="hidden" id="goodsquantity" name="goodsquantity" value="0"/>
                          	</c:if>
                          	<c:if test="${not empty(listw[warehouseid])}">
                          		${listw[warehouseid]}<input type="hidden" id="goodsquantity" name="goodsquantity" value="${listw[warehouseid]}"/>
                          	</c:if>
                          </TD>
                          </s:iterator>
              
						</TR>
						</c:forEach>
						<TR class=table_title align=middle>
							<TH height="26" scope=col class="FixedDataColumn">库存总合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>	
					    	<TH scope=col class="FixedDataColumn">${sum}</TH>
							<c:if test="${systemParameterPo.fspselectstocktype == '1'}">
							<TH colSpan="${fn:length(stockSearchWarehousePos)+3}" scope=col align="right">&nbsp;</TH>
							</c:if>
							<c:if test="${systemParameterPo.fspselectstocktype == '2'}">
						  	<TH height="26"  colSpan="${fn:length(stockSearchWarehousePos)}" scope=col align="right">库存总合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	</c:if>					    	
				   		</TR>  
                      </TBODY>
                    </table>
                    <c:if test="${not empty(stockSearchWarehousePoList)}"> 
                       <!-- BEGIN 分页-->
						<div id="dividePage" align="center" style="clear: both;">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					  <!-- END 分页 -->  					
	               </c:if>
	               </DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>