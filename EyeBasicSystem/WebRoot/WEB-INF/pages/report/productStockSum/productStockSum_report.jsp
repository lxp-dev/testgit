<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品库存统计表</title>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
</head>
<script>
function search(){

	createForm();
	var stockId = $('#departmentID').val();
	var endDate = document.all.endTime2.value;
	var isShow = $('input[name=isShow2]:checked').val();
	var queryClassify = $('input[name=queryClassify]:checked').val();
	var warsehouseName = EncodeUtf8($("#ds").val());
	var showCompanyName = $('input[name=showCompanyName2]:checked').val();
	var salesCostTemp = $('input[name=salesCost2]:checked').val();
	var salesCostSel = $('input[name=salesCostSel2]:checked').val();
	var goodsCategoryID = $("input[id=goodscategoryID2]:checked").val();
	var supplierID = $("input[id=supplierID2]").val();
	var supplierName=EncodeUtf8($("input[id=supplierName2]").val());	
	var brandID=$("input[id=brandID2]").val(); 
	var brandName=EncodeUtf8($("input[id=brandName2]").val());
	var brandNameStr=EncodeUtf8($("input[id=brandNameStr2]").val());
	var shopcol=$("input[id=shopcol2]:checked").val();
	var bgnretailamount = $("#bgnretailamount2").val();
	var endretailamount = $("#endretailamount2").val();
	var bgnretailpriceamount = $("#bgnretailpriceamount2").val();
	var endretailpriceamount = $("#endretailpriceamount2").val();
	var totalPriceType = $('input[name=totalPriceType2]:checked').val();
	
	var permission=${permissionPo.keyc};

    $('input[id=stockId]').get(0).value = stockId;
    if(warsehouseName==''){
    	warsehouseName='所有仓位';
        }

    var salesCost="";
    if(salesCostSel=='1'){
        if(salesCostTemp=='1'){
        	salesCost='1';
        }else if(salesCostTemp=='2'){
        	salesCost='2';
        }else if(salesCostTemp=='3'){
        	salesCost='3';
        }

    }else if(salesCostSel=='2'){
        if(salesCostTemp=='1'){
        	salesCost='4';
        }else if(salesCostTemp=='2'){
        	salesCost='5';
        }else if(salesCostTemp=='3'){
        	salesCost='6';
        }
    }

    $('input[name=warsehouseName]').get(0).value = warsehouseName;
    $('input[id=endDate]').get(0).value = endDate;
    $('input[name=isShow]').get(0).value = isShow;
    $('input[name=showCompanyName]').get(0).value = showCompanyName;
    $("input[name=goodsCategoryID]").val(goodsCategoryID);
    $("input[name=supplierID]").val(supplierID);
    $("input[name=supplierName]").val(supplierName);
    $("input[name=brandID]").val(brandID);
    $("input[name=brandName]").val(brandName);
    $("input[name=brandNameStr]").val(brandNameStr);
    $("input[name=salesCost]").val(salesCost);  
    $("input[name=shopcol]").val(shopcol);   
    $("input[name=permission]").val(permission); 
    $("input[name=bgnretailamount]").val(bgnretailamount);
    $("input[name=endretailamount]").val(endretailamount);
    $("input[name=bgnretailpriceamount]").val(bgnretailpriceamount);
    $("input[name=endretailpriceamount]").val(endretailpriceamount);
    $("input[name=totalPriceType]").val(totalPriceType); 
    

    var reportUrl = "&permission="+permission+"&shopcol="+shopcol+"&salesCost="+salesCost+"&stockId="+stockId+"&warsehouseName="+EncodeUtf8(warsehouseName)+"&endDate="+endDate+"&isShow="+isShow+"&showCompanyName="+showCompanyName;

	var reportName = '';
	var DataURL = '';
	var formAction = '';

    switch(queryClassify){
        case '1':// 实际库存
            
        	reportUrl=reportUrl+"&goodsCategoryID="+goodsCategoryID+"&supplierID="+supplierID+"&supplierName="+EncodeUtf8(supplierName)+"&brandID="+brandID+"&brandName="+EncodeUtf8(brandName)+"&brandNameStr="+EncodeUtf8(brandNameStr)+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount;

            var paystatus=$('input[name=paystatus]:checked').val();
            if(paystatus =='1'){//类别
                
				formAction = 'spslcblb';
				reportName = 'storage_kcsptj_slje.cpt';
				DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            }else if(paystatus =='2'){//制造商
				formAction = 'spslcbgys';
				reportName = 'storage_kcsptj_slje2.cpt';
				DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            }else if(paystatus =='3'){//品种
				formAction = 'spslcbpp';
				reportName = 'storage_kcsptj_slje3.cpt';
				DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            }          
            break;
        case '3':// 结算单据
            
        	reportUrl=reportUrl+"&goodsCategoryID="+goodsCategoryID+"&supplierID="+supplierID+"&supplierName="+EncodeUtf8(supplierName)+"&brandID="+brandID+"&brandName="+EncodeUtf8(brandName)+"&brandNameStr="+EncodeUtf8(brandNameStr)+"&bgnretailamount="+bgnretailamount+"&endretailamount="+endretailamount+"&totalPriceType="+totalPriceType;

            var paystatus=$('input[name=paystatus]:checked').val();
            if(paystatus =='1'){//类别
                
				formAction = 'spslcblb2';
				reportName = 'storage_kcsptj_bill_slje.cpt';
				DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            }else if(paystatus =='2'){//制造商
				formAction = 'spslcbgys2';
				reportName = 'storage_kcsptj_bill_slje2.cpt';
				DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            }else if(paystatus =='3'){//品种
				formAction = 'spslcbpp2';
				reportName = 'storage_kcsptj_bill_slje3.cpt';
				DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            }          
            break;	                                                                      
        case '2':// 结算方式
        	reportUrl=reportUrl+"&goodsCategoryID="+goodsCategoryID+"&supplierID="+supplierID+"&supplierName="+EncodeUtf8(supplierName)+"&brandID="+brandID+"&brandName="+EncodeUtf8(brandName)+"&brandNameStr="+EncodeUtf8(brandNameStr);
            
			formAction = 'xfhf';
			reportName = 'storage_kcsptj_jsfs.cpt';
			DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            break;	                                                                      
        default:
	        return;
    }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
			queryReport(DataURL,formAction);
		}
		document.getElementById('popupTitle').innerHTML="【商品库存统计表】";
            
}
function queryReport(DataURL,formAction){
	var rptFrm = document.getElementById('rptFrm');
	rptFrm.action = DataURL;    
	rptFrm.target = formAction;    

	if (rptFrm.attachEvent){
		rptFrm.attachEvent("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}); 		  
	}else{
		rptFrm.addEventListener("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}); 		  
	}

	if (rptFrm.fireEvent){
		rptFrm.fireEvent("onsubmit");	
	}else{
		//rptFrm.removeEventListener("onsubmit");	
	}         

    rptFrm.submit();  
  
    document.body.removeChild(rptFrm); 
}
function queryClass(){
	
	var queryClassify = $('input[name=queryClassify]:checked').val();
    if (queryClassify == '1'){        	
    	$('tr[id=salesbillstatusTab]').show(); 
    	$('tr[id=salesbillstatusTab2]').show(); 
    	$('tr[id=salesbillstatusTab3]').hide();    
    	$('tr[id=supplierTab]').hide(); 
    	$('tr[id=brandTab]').hide(); 
    	$("input[id=paystatus][type=radio][value='1']").attr('checked','checked');
    	  
    }
    if (queryClassify == '2'){ 
    	$('tr[id=salesbillstatusTab]').hide();
    	$('tr[id=salesbillstatusTab2]').hide(); 
    	$('tr[id=salesbillstatusTab3]').hide();  
    	$('tr[id=supplierTab]').show(); 
    	$('tr[id=brandTab]').hide(); 
    }
    if (queryClassify == '3'){ 
    	$('tr[id=salesbillstatusTab]').show(); 
    	$('tr[id=salesbillstatusTab2]').hide(); 
    	$('tr[id=salesbillstatusTab3]').show();  
    	$('tr[id=supplierTab]').hide(); 
    	$('tr[id=brandTab]').hide(); 
    	$("input[id=paystatus][type=radio][value='1']").attr('checked','checked');
    	  
    }
}
function clean(){
        
    goodsForm.reset();
    $('tr[id=salesbillstatusTab]').show();
    $('tr[id=salesbillstatusTab2]').show();
    $('tr[id=salesbillstatusTab3]').hide();
	$('tr[id=supplierTab]').hide(); 
	$('tr[id=brandTab]').hide(); 
	today('startTime2','endTime2');
}
function createForm(){
	
	var rptFrm = document.createElement("form"); 
	rptFrm.id = "rptFrm";  
	rptFrm.method = "post"; 

	var stockId = document.createElement("input");
	stockId.type = "hidden";
	stockId.id = "stockId";
	stockId.name = "stockId";
	stockId.value = '';	  
    rptFrm.appendChild(stockId); 

	var warsehouseName = document.createElement("input");
	warsehouseName.type = "hidden";
	warsehouseName.id = "warsehouseName";
	warsehouseName.name = "warsehouseName";
	warsehouseName.value = '';	  
    rptFrm.appendChild(warsehouseName); 
        
    var endDate = document.createElement("input");	     
    endDate.type = "hidden";
    endDate.id = "endDate";
    endDate.name = "endDate";
    endDate.value = '';	  
    rptFrm.appendChild(endDate); 

    var goodsCategoryID = document.createElement("input");	     
    goodsCategoryID.type = "hidden";
    goodsCategoryID.name = "goodsCategoryID";
    goodsCategoryID.value = '';	  
    rptFrm.appendChild(goodsCategoryID); 

    var supplierID = document.createElement("input");	     
    supplierID.type = "hidden";
    supplierID.name = "supplierID";
    supplierID.value = '';	  
    rptFrm.appendChild(supplierID); 

    var brandID = document.createElement("input");	     
    brandID.type = "hidden";
    brandID.name = "brandID";
    brandID.value = '';	  
    rptFrm.appendChild(brandID); 

    var brandName = document.createElement("input");	     
    brandName.type = "hidden";
    brandName.name = "brandName";
    brandName.value = '';	  
    rptFrm.appendChild(brandName); 

    var brandNameStr = document.createElement("input");	     
    brandNameStr.type = "hidden";
    brandNameStr.name = "brandNameStr";
    brandNameStr.value = '';	  
    rptFrm.appendChild(brandNameStr); 

    var salesCost = document.createElement("input");	     
    salesCost.type = "hidden";
    salesCost.name = "salesCost";
    salesCost.value = '';	  
    rptFrm.appendChild(salesCost); 

    var totalPriceType = document.createElement("input");	     
    totalPriceType.type = "hidden";
    totalPriceType.name = "totalPriceType";
    totalPriceType.value = '';	  
    rptFrm.appendChild(totalPriceType); 
    
    var isShow = document.createElement("input");	     
    isShow.type = "hidden";
    isShow.name = "isShow";
    isShow.value = '';	  
    rptFrm.appendChild(isShow); 

    var showCompanyName = document.createElement("input");	     
    showCompanyName.type = "hidden";
    showCompanyName.name = "showCompanyName";
    showCompanyName.value = '';	  
    rptFrm.appendChild(showCompanyName);

    var shopcol = document.createElement("input");	     
    shopcol.type = "hidden";
    shopcol.name = "shopcol";
    shopcol.value = '';	  
    rptFrm.appendChild(shopcol);

    var permission = document.createElement("input");	     
    permission.type = "hidden";
    permission.name = "permission";
    permission.value = '';	  
    rptFrm.appendChild(permission);
    
    var bgnretailamount = document.createElement("input");	     
    bgnretailamount.type = "hidden";
    bgnretailamount.name = "bgnretailamount";
    bgnretailamount.value = '';	  
    rptFrm.appendChild(bgnretailamount);
    
    var endretailamount = document.createElement("input");	     
    endretailamount.type = "hidden";
    endretailamount.name = "endretailamount";
    endretailamount.value = '';
    rptFrm.appendChild(endretailamount);

    var bgnretailpriceamount = document.createElement("input");	     
    bgnretailpriceamount.type = "hidden";
    bgnretailpriceamount.name = "bgnretailpriceamount";
    bgnretailpriceamount.value = '';	  
    rptFrm.appendChild(bgnretailpriceamount);
    
    var endretailpriceamount = document.createElement("input");	     
    endretailpriceamount.type = "hidden";
    endretailpriceamount.name = "endretailpriceamount";
    endretailpriceamount.value = '';
    rptFrm.appendChild(endretailpriceamount);
    
    document.body.appendChild(rptFrm);
}
/**
 * 部门开窗
 */
function openDepartment(){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;		
	if(is_iPad()){
		showPopWin("initWarehouseOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initWarehouseOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}		
	document.getElementById('popupTitle').innerHTML="【仓位查询】";
}

/**
 * 部门开窗赋值实现方法
 */
function openDepartmentValues(objValue){
	var arrayID = new Array();
	var arrayName = new Array();
	var departments = eval('(' + objValue + ')');
	for(var i = 0; i < departments.length; i++){	
		arrayID[i] = departments[i].bdpdepartmentid;
		arrayName[i] = departments[i].bdpdepartmentname;
	}
	
	document.getElementById('departmentID').value = arrayID.join(",");
	document.getElementById('bdpdepartmentname').value = arrayName.join(",");
	document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
}
$(document).ready(function() { 
    $("img[btn=btn]").attr("style","cursor: hand;"); 
    $("img[btn=btn]").mouseover(function () { 
    $(this).attr("src",$(this).attr("src").replace("0","1")); 
    }).mouseout(function () { 
      $(this).attr("src",$(this).attr("src").replace("1","0")); 
    });
	$('tr[id=supplierTab]').hide(); 
	$('tr[id=brandTab]').hide(); 
    $('tr[id=salesbillstatusTab3]').hide(); 
	today('startTime2','endTime2');
});
/**
 * 制造商开窗
 */
function openSupplier(){
	var searchtype = $("input[name=searchtype]:checked").val();
	var goodscategoryID= $('input[id=goodscategoryID2]:checked').val();
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
	var searchtype = $("input[name=searchtype]:checked").val();
	$('input[id=supplierID2]').val(json.id);
	$('input[id=supplierName2]').val(json.value);
	$('input[id=brandID2]').val('');
	$('input[id=brandName2]').val('');
}
function openBrand(){
	var searchtype = $("input[name=searchtype]:checked").val();
	var goodscategoryID= $('input[id=goodscategoryID2]:checked').val();
	var supplierID=$('input[id=supplierID2]').val();
	
    if(supplierID==''){
      alert('请选择所属制造商');
      return false;
    }
    var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	
	if(is_iPad()){
		showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【品种查询】";
}

/**
 * 开窗赋值实现方法
 */
function openBrandValues(json){
	var searchtype = $("input[name=searchtype]:checked").val();
	$('input[id=brandID2]').val(json.brandID);
	$('input[id=brandName2]').val(json.brandName);
}

function showterm(){
	var paystatus = $("input[name=paystatus]:checked").val(); 

    if (paystatus == '1'){        	
    	$('tr[id=salesbillstatusTab]').show();   
    	$('tr[id=supplierTab]').hide(); 
    	$('tr[id=brandTab]').hide();   
    }else if (paystatus == '2'){ 
    	$('tr[id=salesbillstatusTab]').show();
    	$('tr[id=supplierTab]').show(); 
    	$('tr[id=brandTab]').hide(); 
    }else if (paystatus == '3'){ 
    	$('tr[id=salesbillstatusTab]').show();
    	$('tr[id=supplierTab]').show(); 
    	$('tr[id=brandTab]').show(); 
    }
	
}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="goodsForm" name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="searchKey" value="${searchKey}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>日常业务类报表</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品库存统计表</TD>
            <TD align=right>
                <img src="${ctx }/img/newbtn/reporthelp_0.png" btn=btn title='帮助' onclick="help();">	
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
			               <TD class="table_body" height="26">分析角度</TD>
			               <TD class="table_none" colspan="3">

                               <input type="radio" id="queryClassify" name="queryClassify" value="1" onclick="queryClass();" checked="checked"/><a title="可查询实时数据">按实际库存&nbsp;</a>
                               <c:if test="${permissionPo.keye == '1'}">
                               <input type="radio" id="queryClassify" name="queryClassify" value="3" onclick="queryClass();" /><a title="可查询到前一天数据">按结算单据&nbsp;</a>
                               </c:if>
                               <c:if test="${permissionPo.keyf == '1'}">
                               <input type="radio" id="queryClassify" name="queryClassify" value="2" onclick="queryClass();"/><a title="可查询实时数据">按制造商结算方式&nbsp;</a>
                               </c:if>
                             
                           <label style="color:red;">&nbsp;*&nbsp;</label>                                                     
			               </TD>			             
                        </TR>
			            <TR group="type" id="salesbillstatusTab" inithide=inithide>
			               <TD class="table_body" height="26">查询分类</TD>
			               <TD class="table_none" colspan="3"> 
			               <input type="radio" name="paystatus" onclick="showterm();" id ="paystatus" value="1" checked="checked"/>商品类别&nbsp;
			               <input type="radio" name="paystatus" onclick="showterm();" id ="paystatus" value="2" />制造商&nbsp;
			               <input type="radio" name="paystatus" onclick="showterm();" id ="paystatus" value="3" />品种&nbsp;
			               </TD>
                        </TR>
                       <TR>
					  	   <TD width="10%" height="30" class="table_body">仓位名称</TD>
			               <TD width="40%" class="table_none" >
			               
			               <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
		               <c:if test="${person.departmenttype!=1}">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" type="hidden" value="${personInfoPo.bdpdepartmentname }"  />
						   		<textarea class="text_input200" id="ds"  name="ds" value=""   style='height:50px' readonly="readonly" >${personInfoPo.bdpdepartmentname}</textarea>
						   		
						   		<input type="hidden" id="departmentID" name="departmentID" value="${personInfoPo.departmentID }" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li>
						</c:if>  
						   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}"/>
      	                   </c:if>
						  </TD>
						  
						  </TD>
						  <TD width="10%" class="table_body">截止日期</TD>
			               <TD width="40%" class="table_none">
                               <jsp:include page="/commons/report_date3.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
			               	   <input type="radio" name="goodscategoryID2"  id ="goodscategoryID2" value="" checked/>全部&nbsp;&nbsp;
	      	                   <s:iterator value="goodsCategorys">
	      	                   <input type="radio" name="goodscategoryID2"  id ="goodscategoryID2" value="${bgcid}"/>${bgcgoodscategoryname}&nbsp;&nbsp;
	      	                   </s:iterator>
	      	               </TD>
                        </TR>
                        <TR group="type" id="supplierTab" inithide=inithide>

						   <TD  height="26" class="table_body">制造商</TD>
			               <TD  class="table_none" colspan="3">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName2" name="supplierName2" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID2" name="supplierID2" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               </TR>
			               <TR group="type" id="brandTab" inithide=inithide>
			               <TD  height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName2" name="brandName2" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID2" name="brandID2" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
			               
			               <TD  height="26" class="table_body">品种名称</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandNameStr2" name="brandNameStr2" value="${requestScope.brandNameStr}" maxlength="32" >
							   </li>
			               </TD>
			              
                        </TR>
                        <TR group="type" id="salesbillstatusTab2" inithide=inithide>
                           <TD height="26" class="table_body">成本查看角度</TD>
			               <TD  class="table_none" colspan="3">
			                 <input type="radio" name="salesCostSel2" value="1" checked/>基础信息成本
			                 <input type="radio" name="salesCostSel2" value="2"/>结算成本
			               </TD>
						</tr>
                        <TR group="type" id="salesbillstatusTab2" inithide=inithide>
                           <TD height="26" class="table_body">成本类型</TD>
			               <TD  class="table_none" colspan="3">
			                 <input type="radio" name="salesCost2" value="1" checked/>含税成本
			                 <input type="radio" name="salesCost2" value="2"/>不含税成本
			                 <input type="radio" name="salesCost2" value="3"/>加权平均成本
			               </TD>
						</tr>
						<TR group="type" id="salesbillstatusTab2" inithide=inithide>
                           <TD height="26" class="table_body">成本价格区间</TD>
			               <TD  class="table_none" colspan="3">
								<input class="text_input60" type="text" id="bgnretailamount2" name="bgnretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/> 至 
								<input class="text_input60" type="text" id="endretailamount2" name="endretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>

			               </TD>
						</tr>
						<TR group="type" id="salesbillstatusTab2" inithide=inithide>
                           <TD height="26" class="table_body">标准零售价区间</TD>
			               <TD  class="table_none" colspan="3">
								<input class="text_input60" type="text" id="bgnretailpriceamount2" name="bgnretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/> 至 
								<input class="text_input60" type="text" id="endretailpriceamount2" name="endretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>

			               </TD>
						</tr>
						<TR group="type" id="salesbillstatusTab3" inithide=inithide>
                           <TD height="26" class="table_body">销售成本</TD>
			               <TD  class="table_none" colspan="3">
			                 <input type="radio" name="totalPriceType2" value="2" checked/>含税成本
			                 <input type="radio" name="totalPriceType2" value="1"/>不含税成本
			               </TD>
						</tr>
                        <TR >
                           <TD class="table_body">显示仓位明细</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="shopcol2" name="shopcol2"  value="1"/>显示
                               <input type="radio" id="shopcol2" name="shopcol2" checked value=""/>不显示
			               </TD>

                        </TR>
                        <TR>
			               <TD class="table_body" height="26">显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none">
                               <input clean=clean type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input clean=clean type="radio" id="showCompanyName2" name="showCompanyName2" value="0"/>否
			               </TD>
                        </TR>

                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr>
							<td height="26">
							<c:if test="${permissionPo.keya == '1'}">  
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >	
							</c:if>						
							</td>
						</tr>
					</table>
					<br/><br/>
					<div class="reportHelp">															
						备注：<br/>													
						1.基础信息成本:当前系统中,商品信息维护中商品单价成本<br/>																						
						2.结算成本:商品入库后,做完结算单,则按结算单中的成本计算,仅入库未结算,则系统先按商品信息维护中商品单价成本计算,等待该结算单完成后,则按该结算单中成本计算<br/>															
					</div>	
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
