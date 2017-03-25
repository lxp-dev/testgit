<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
<title>报表中心</title>
</head>
<script>
$(document).ready(function() { 
    $("img[btn=btn]").attr("style","cursor: hand;"); 
    $("img[btn=btn]").mouseover(function () { 
    $(this).attr("src",$(this).attr("src").replace("0","1")); 
    }).mouseout(function () { 
      $(this).attr("src",$(this).attr("src").replace("1","0")); 
    }); 
}); 
	function search(){
		var ShopCode=document.all.bwhid.value;
		var BeginDate=document.all.startTime.value;
		var End=document.all.endTime.value;
		var GoodscategoryID=document.all.goodscategoryID.value;
		var SupplierID=document.all.supplierID.value;
		var BrandID=document.all.brandID.value;
		var GoodsID=document.all.goodsID.value;
		var Goodsname=document.all.goodsname.value;
		<c:if test="${person.departmenttype==1||person.departmenttype==2}">
		var warsehouseName = EncodeUtf8($('#bwhidh').val());
		</c:if>

        <c:if test="${person.departmenttype!=1&&person.departmenttype!=2}">
		var warsehouseName = EncodeUtf8(getSelectText("bwhid"));
        </c:if>
		var statisticsName = EncodeUtf8(getSelectText("selecttype"));
		var goodsCategoryName = EncodeUtf8(getSelectText("goodscategoryID"));
		var supplierName = EncodeUtf8(document.getElementById("supplierName").value);
		var brandName = EncodeUtf8(document.getElementById("brandName").value); 

		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});
		if(ShopCode=="" ){
			alert('请选择仓位!');
			document.all.bwhid.focus();
			return false;
		}
		if(BeginDate==""){
			alert('请选择日期!');
			document.all.startTime.focus();
			return false;
		}
		if(End==""){
			alert('请选择日期!');
			document.all.endTime.focus();
			return false;
		}
		if($("select[id=selecttype]").val() == ''){
			alert("请选择统计类型！");
			return;
		}
		if($("select[id=selecttype]").val() == '1'){
			var DataURL = "report.action?reportlet=storage_allocationSumRpt.cpt&departmentid="+ShopCode
					+"&bgnDate="+BeginDate
					+"&goodsname="+EncodeUtf8(document.getElementById('goodsname').value)
					+"&endDate="+End+"&warsehouseName="+warsehouseName
					+"&statisticsName="+statisticsName+'&isShow='+isShow;
		}else{
			var DataURL = "report.action?reportlet=storage_allocationDistrisRpt.cpt&billDateStart="+BeginDate
					+"&billDateEnd="+End+"&departmentId="+ShopCode+"&goodsCategoryID="+GoodscategoryID
					+"&supplierID="+SupplierID+"&brandID="+BrandID+"&goodsName="+EncodeUtf8(Goodsname)
					+"&goodsID="+EncodeUtf8(GoodsID)+"&endDate="+End+"&warsehouseName="+warsehouseName
					+"&statisticsName="+statisticsName+"&brandName="+brandName
					+"&supplierName="+supplierName+"&goodsCategoryName="+goodsCategoryName+'&isShow='+isShow; 
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}
		if($("select[id=selecttype]").val() == '1'){
			document.getElementById('popupTitle').innerHTML="【调拨汇总表】";
		}else{
			document.getElementById('popupTitle').innerHTML="【调拨明细表】";
		}
		
	}
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
		var goodscategoryID= document.all.goodscategoryID.value;
		
		var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【品种查询】";					
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}

	
	function clean(){
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('goodsname').value = "";
		var mm=document.getElementById('kha').value;
		if(mm!=1 && mm!=2)
		{
			document.getElementById('bwhid').value = "";
		}
	}
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}

	function ishow(obj){
		if($(obj).val() == '1'){
			$("tr[searchtype=2]").hide();
			$("select[searchtype=2]").val('');
			$("input[searchtype=2]").val('');
		}else{
			$("tr[searchtype=2]").show();
			$("select[searchtype=2]").val('');
			$("input[searchtype=2]").val('');
		}
	}
	/**
	 * 获取select标签Text
	 */
	function getSelectText(selectId){
		if(!selectId) {
			alert("未找到select标签");
		} else {
			var selectObj = document.getElementById(selectId);
			var userSelectedIndex = selectObj.selectedIndex;
			var selectText = selectObj.options[userSelectedIndex].text
			if(userSelectedIndex == 0) {
				selectText = "";
			}
			var endIndex = selectText.indexOf("￥");
			if(endIndex > 0) {
				selectText = selectText.substring(0, endIndex-1);
			}
			return selectText;
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>日常业务类报表</TD>           
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：调拨统计表</TD>
            <TD>&nbsp;</TD>
          </TR>
          <TR>
          	<TD class=menubar_function_text colspan="3">
          	<table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
		  </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">仓位名称</TD>
			               <TD class="table_none" width="20%">
			               <input type="hidden" name="kha" id="kha" value="${person.departmenttype }"/>
                            <c:if test="${person.departmenttype!=1&&person.departmenttype!=2}">
                            <select id="bwhid" name="bwhid">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(warehouseList)}">
				               	  <s:iterator value="warehouseList">
                    	           <OPTION value="${bwhid}">${bwhwarehouseName}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
      	                   </c:if>
      	                     <c:if test="${person.departmenttype==1||person.departmenttype==2}">
                            ${warehouseList[0].bwhwarehouseName}<input type="hidden" name="bwhid" value="${warehouseList[0].bwhid}" name="bwhid"/>
                            <input type="hidden" id="bwhidh" value="${warehouseList[0].bwhwarehouseName}"/>
      	                   </c:if>
			               </TD>
			               <TD width="8%" height="26" class="table_body">收货日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
			               <TD height="26" class="table_body">统计类型</TD>
			               <TD class="table_none">
                               <select id="selecttype" name="selecttype" onchange="ishow(this);">
	      		                 <option value="">---请选择---</option>
					             <option value="1">汇总</option>
					             <option value="2">明细</option>
	      	                   </select>
			               </TD>
                        </TR>
                        	
                        <TR searchtype="2" style="display: none;">
					  	<TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" width="20%">
							   <select id="goodscategoryID" name="goodscategoryID" searchtype="2">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
			               <TD height="26" class="table_body">制造商</TD>
						            <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" searchtype="2" class="text_input160" readonly="readonly" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" searchtype="2" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();" ></li>
			               </TD>
			               <TD width="8%" height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
							   		<input class="text_input160" type="text" searchtype="2" id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
							   		<input type="hidden" id="brandID" searchtype="2" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
			               </TD>			               
					  	</TR>
					  	<TR>
						   <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none"><input type="text" class="text_input160" searchtype="2" maxlength="20" id="goodsname" name="goodsname"/></TD>
						   <TD class="table_body">商品代码</TD>
			               <TD class="table_none" colspan="3"><input class="text_input160" searchtype="2" type="text" maxlength="30" id="goodsID" name="goodsID"/></TD>
                        </TR>
                        <TR>
			               <TD class="table_body" height="26">是否显示查询条件</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
