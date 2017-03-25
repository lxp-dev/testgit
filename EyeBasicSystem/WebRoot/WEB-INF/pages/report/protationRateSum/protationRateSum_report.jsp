<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

	    $("tr[id=category]").show();
	    $("span[sid=1][name=isShowC]").hide();
	    $("span[sid=2][name=isShowC]").hide();
	    $("span[sid=3][name=isShowC]").hide();
	}); 
	function isShowCus(){
		   var searchtype = $('input[name=queryClassify2]:checked').val();
		   var goodsCategoryID = $("select[id=goodscategoryID2][sid="+searchtype+"]").val();
		   if(goodsCategoryID==3 || goodsCategoryID==4){
			   $("span[name=isShowC][sid="+searchtype+"]").show();
		   }else{
			   $("span[name=isShowC][sid="+searchtype+"]").hide();
		   }

		   $('input[id=supplierID2]').val('');
		   $('input[id=supplierName2]').val('');
		   $('input[id=brandID2]').val('');
		   $('input[id=brandName2]').val('');
		   
	}
	function search(){
		if(checkForm(goodsForm)){

			if(!is_iPad()){
				createForm();
			}
			
			var ShopCode = $('#departmentID').val();
			var BeginDate = document.getElementById("startTime").value;
			var End = document.getElementById("endTime").value;
			var departmentName = $('#bdpdepartmentname').val();	
			var isShow = $('input[name=isShow2]:checked').val();
			var showCompanyName = $('input[name=showCompanyName2]:checked').val();
	        var searchtype = $('input[name=queryClassify2]:checked').val();
	        var totalPriceType = $('input[name=totalPriceType]:checked').val();
	        var companyID = $('#companysid').val();
	        var ljyf=${permissionPo.keye};
	        
			if (!totalPriceType){
				totalPriceType = '';
		    }
        
			var goodsCategoryID = $("select[id=goodscategoryID2][sid="+searchtype+"]").val();
	        if(goodsCategoryID==3 || goodsCategoryID==4){
	      	  var isShowCus = $("input[name=isCustomize"+searchtype+"][sid="+searchtype+"]:checked").val();
	        }else{
	        	 var isShowCus='';
	        }
			var supplierID = $("input[id=supplierID2][sid="+searchtype+"]").val();
			if (supplierID == undefined){
				supplierID = '';
		    }
			var brandID=$("input[id=brandID2][sid="+searchtype+"]").val();
			if (brandID == undefined){
				brandID = '';
		    }
			var supplierName = $("input[id=supplierName2][sid="+searchtype+"]").val();
			if (supplierName == undefined){
				supplierName = '';
		    }
			var brandName=$("input[id=brandName2][sid="+searchtype+"]").val();
			if (brandName == undefined){
				brandName = '';
		    }
			
			if(End==""){
				alert('请选择结束日期!');
				document.getElementById("endTime").focus();
				return false;
			}

            var goodsCategoryName = ''; 
            if (goodsCategoryID != ''){
            	goodsCategoryName = $("select[id=goodscategoryID2][sid="+searchtype+"]").find("option:selected").text(); 
            }
            
			var reportName = '';
			var formAction = '';
            var reportUrl = "&departmentid="+ShopCode+"&bgnDate="+BeginDate+"&endDate="+End+"&departmentName="+EncodeUtf8(departmentName)+"&goodsCategoryID="+goodsCategoryID+"&goodsCategoryName="+goodsCategoryName
			+"&supplierID="+supplierID+"&brandID="+brandID+"&supplierName="+EncodeUtf8(supplierName)+"&brandName="+EncodeUtf8(brandName)+'&isShow='+isShow+"&bgnretailamount="+$('#bgnretailamount2').val()+"&endretailamount="+$('#endretailamount2').val()+"&showCompanyName="+showCompanyName+"&totalPriceType="+totalPriceType+"&isShowCus="+isShowCus+"&companyID="+companyID+"&ljyf="+ljyf; 
	
	        switch(searchtype){
	        case '1':
				reportName = 'L_StorageTurnoverRateForType_Bill.cpt';
				formAction = 'zzl1';
	            break;
	        case '2':
				reportName = 'L_StorageTurnoverRateForSupplier_Bill.cpt';
				formAction = 'zzl2';
	            break;
	        case '3':
				reportName = 'L_StorageTurnoverRateForBrand_Bill.cpt';
				formAction = 'zzl3';
	            break;  
	        case '4':
				reportName = 'L_StorageTurnoverRateForGoods_Bill.cpt';
				formAction = 'zzl4';
	            break; 
	        default:
		        return;
	        }
	        
	        DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
			
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;	
			if(is_iPad()){
				showPopWin(DataURL+reportUrl,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{				

				$('#rptFrm input[name=departmentid]').get(0).value = ShopCode;
				$('#rptFrm input[name=bgnDate]').get(0).value = BeginDate;
				$('#rptFrm input[name=endDate]').get(0).value = End;
				$('#rptFrm input[name=departmentName]').get(0).value = departmentName;
				$('#rptFrm input[name=isShow]').get(0).value = isShow;
				$('#rptFrm input[name=supplierID]').get(0).value = supplierID;
				$('#rptFrm input[name=brandID]').get(0).value = brandID;
				$('#rptFrm input[name=supplierName]').get(0).value = supplierName;
				$('#rptFrm input[name=brandName]').get(0).value = brandName;
				$('#rptFrm input[name=bgnretailamount]').get(0).value = $('#bgnretailamount2').val();
				$('#rptFrm input[name=endretailamount]').get(0).value = $('#endretailamount2').val();
				$('#rptFrm input[name=showCompanyName]').get(0).value = showCompanyName;
				$('#rptFrm input[name=goodsCategoryName]').get(0).value = goodsCategoryName;
				$('#rptFrm input[name=goodsCategoryID]').get(0).value = goodsCategoryID;
				$('#rptFrm input[name=isShowCus]').get(0).value = isShowCus;
				$('input[name=totalPriceType]',$("#rptFrm")).get(0).value = totalPriceType;
				$('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';
				$('#rptFrm input[name=companyID]').get(0).value = companyID;
				$('#rptFrm input[name=ljyf]').get(0).value = ljyf;
				
				queryReport(DataURL,formAction);

			}		
			document.getElementById('popupTitle').innerHTML="【商品库存周转率统计表】";
		}		
	}


	function createForm(){
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";  
		rptFrm.method = "post";
		
		var logincompanyid = document.createElement("input");	     
	    logincompanyid.type = "hidden";
	    logincompanyid.name = "logincompanyid";
	    logincompanyid.value = '';	  
	    rptFrm.appendChild(logincompanyid);

	    var goodsCategoryID = document.createElement("input");	     
	    goodsCategoryID.type = "hidden";
	    goodsCategoryID.name = "goodsCategoryID";
	    goodsCategoryID.value = '';	  
	    rptFrm.appendChild(goodsCategoryID);   

	    var goodsCategoryName = document.createElement("input");	     
	    goodsCategoryName.type = "hidden";
	    goodsCategoryName.name = "goodsCategoryName";
	    goodsCategoryName.value = '';	  
	    rptFrm.appendChild(goodsCategoryName);   

	    var companyID = document.createElement("input");	     
	    companyID.type = "hidden";
	    companyID.name = "companyID";
	    companyID.value = '';	  
	    rptFrm.appendChild(companyID);   

	    var shopCode = document.createElement("input");	     
	    shopCode.type = "hidden";
	    shopCode.name = "departmentid";
	    shopCode.value = '';	  
	    rptFrm.appendChild(shopCode);  

	    var bgnDate = document.createElement("input");	     
	    bgnDate.type = "hidden";
	    bgnDate.name = "bgnDate";
	    bgnDate.value = '';	  
	    rptFrm.appendChild(bgnDate); 

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.name = "endDate";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate);  

	    var departmentName = document.createElement("input");	     
	    departmentName.type = "hidden";
	    departmentName.name = "departmentName";
	    departmentName.value = '';	  
	    rptFrm.appendChild(departmentName);  

	    var isShow = document.createElement("input");	     
	    isShow.type = "hidden";
	    isShow.name = "isShow";
	    isShow.value = '';	  
	    rptFrm.appendChild(isShow); 

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

	    var supplierName = document.createElement("input");	     
	    supplierName.type = "hidden";
	    supplierName.name = "supplierName";
	    supplierName.value = '';	  
	    rptFrm.appendChild(supplierName);   

	    var brandName = document.createElement("input");	     
	    brandName.type = "hidden";
	    brandName.name = "brandName";
	    brandName.value = '';	  
	    rptFrm.appendChild(brandName);   
	    
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

	    var showCompanyName = document.createElement("input");	     
	    showCompanyName.type = "hidden";
	    showCompanyName.name = "showCompanyName";
	    showCompanyName.value = '';	  
	    rptFrm.appendChild(showCompanyName);   

	    var totalPriceType = document.createElement("input");	     
	    totalPriceType.type = "hidden";
	    totalPriceType.name = "totalPriceType";
	    totalPriceType.value = '';	  
	    rptFrm.appendChild(totalPriceType); 

	    var isShowCus = document.createElement("input");	     
	    isShowCus.type = "hidden";
	    isShowCus.name = "isShowCus";
	    isShowCus.value = '';	  
	    rptFrm.appendChild(isShowCus);

	    var ljyf = document.createElement("input");	     
	    ljyf.type = "hidden";
	    ljyf.name = "ljyf";
	    ljyf.value = '';	  
	    rptFrm.appendChild(ljyf);
	    
	    document.body.appendChild(rptFrm);
    }
    
	function queryReport(DataURL,formAction){
		
		var rptFrm = document.getElementById('rptFrm');
		rptFrm.action = DataURL;    
		rptFrm.target = formAction;    

		if (rptFrm.attachEvent){
			rptFrm.attachEvent("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));}); 		  
		}else{
			rptFrm.addEventListener("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));}); 		  
		}
	
		if (rptFrm.fireEvent){
			rptFrm.fireEvent("onsubmit");	
		}else{
			//rptFrm.removeEventListener("onsubmit");	
		}         

	    rptFrm.submit();  
	  
	    document.body.removeChild(rptFrm); 
    }
    
	function clean(){
		goodsForm.reset();	
		changeSelect($('input[name=queryClassify2]:checked'));
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var searchtype = $("input[name=queryClassify2]:checked").val();
		var goodscategoryID= $('select[id=goodscategoryID2][sid='+searchtype+']').val();
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
		var searchtype = $("input[name=queryClassify2]:checked").val();
		$('input[id=supplierID2][sid='+searchtype+']').val(json.id);
		$('input[id=supplierName2][sid='+searchtype+']').val(json.value);
		$('input[id=brandID2][sid='+searchtype+']').val('');
		$('input[id=brandName2][sid='+searchtype+']').val('');		
	}
	
	function openBrand(){
		var searchtype = $("input[name=queryClassify2]:checked").val();
		var goodscategoryID= $('select[id=goodscategoryID2][sid='+searchtype+']').val();
		var supplierID=$('input[id=supplierID2][sid='+searchtype+']').val();

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
		var searchtype = $("input[name=queryClassify2]:checked").val();
		$('input[id=brandID2][sid='+searchtype+']').val(json.brandID);
		$('input[id=brandName2][sid='+searchtype+']').val(json.brandName);
	}
	
	function changeSelect(obj){
		$("tr[group=type]").hide();
		if($(obj).val() == '1'){
			$("tr[id=category]").show();
		}else if($(obj).val() == '2'){
			$("tr[id=supplier]").show();
		}else if($(obj).val() == '3'){
			$("tr[id=brand]").show();
		}else if($(obj).val() == '4'){
			$("tr[id=goods]").show();
		}else if($(obj).val() == '7'){
			$("tr[id=salesID]").show();
		}

	    $("span[sid=1][name=isShowC]").hide();
	    $("span[sid=2][name=isShowC]").hide();
	    $("span[sid=3][name=isShowC]").hide();
		$('input[id=supplierID2]').val("");
		$('input[id=supplierName2]').val("");
		$('select[id=goodscategoryID2]').val("");
		$('input[id=brandName2]').val("");
		$('input[id=brandID2]').val("");
	}

	function openDepartment(){
		var companyid = $("#companysid").val();
		if(companyid == "" || companyid == null){
			alert('请选择所属公司!');
			return false;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?isclosed=0&companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?isclosed=0&companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}

	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}

		$('#departmentID').val(arrayID.join(","));
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}

	function cleanDepartment(){
		$('#departmentID').val('');
		document.getElementById('bdpdepartmentname').value = '';
		document.getElementById('ds').value = '';
    }
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>${permissionPo.moduleName}</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品库存周转率统计表</TD>
            <TD>&nbsp;</TD>
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
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE width="100%" cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                    <c:if test="${permissionPo.keya eq '1'}">      
	                    <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
	                    <TD width="80" align="center" class=tab id=tabLabel__0 background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initStorageTurnoverRate.action?moduleID=${moduleID}';">按库存查询</TD>
	                    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3></TD>
                    </c:if>
					<c:if test="${permissionPo.keyc eq '1'}">      
                        <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                        <TD width="80" align="center" class=tab id=tabLabel__0 background=${ctx}/img/pic/tab_active_bg.gif>按单据查询</TD>
					    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_active_right.gif" width=3 ></TD>
                    </c:if>

                </TD>
                <td width=auto align="right" valign="top">&nbsp;</td>
			  </TR>
			  </TBODY>
			</TABLE>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="10%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      	<TR>
						   <TD width="6%" height="26" class="table_body">查看公司</TD>
			               <TD width="38%" height="26" class="table_none">
			                <c:if test="${person.personcompanytype eq '2'}">
			                	${person.personcompanyname }
	                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
							</c:if>

							<c:if test="${person.personcompanytype ne '2'}">
								<c:if test="${person.departmenttype == '3'}">
									<select clean="clean" id="companysid" name="companysid" onchange="cleanDepartment()" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属公司！'}]">
										<option value="">----请选择----</option>
										<s:iterator value="companyNamePos">
											<option value="${fcnId}">${fcnName}</option>
										</s:iterator>
									</select><label style="color:red;">&nbsp;*&nbsp;默认查看所有公司</label>
								</c:if>
								<c:if test="${person.departmenttype != '3'}">
		                            ${person.personcompanyname }
		                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        	</c:if>
	                        </c:if>
                           </TD>
                           <TD width="6%" height="26" class="table_body">查看部门</TD>
			               <TD width="50%" class="table_none" colspan="3">
					            <c:if test="${person.departmenttype == '3' || person.departmenttype == '4' || person.departmenttype == '5'}">
					               <li class="horizontal_onlyRight">
								   		<input clean="clean" class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" value="" type="hidden" />
								   		<textarea clean="clean" class="text_input200" id="ds"  name="ds" style='height:50px;width: 200px' readonly="readonly" ></textarea>
								   		
								   		<input clean="clean" type="hidden" id="departmentID" name="departmentID" value=""/>
								   </li>
								   <li class="horizontal_onlyRight">						  		
								  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
								   </li>
								   <li class="horizontal_onlyRight">						  		
								  		<label style="color:red;">&nbsp;先选取所属公司后，才能选取查看部门</label>
								   </li>
								</c:if>
								 
								<c:if test="${person.departmenttype != '3' && person.departmenttype != '4' && person.departmenttype != '5'}">
		                            ${person.bdpdepartmentname}
		                            <input type="hidden" id="departmentID" name="departmentID" value="${person.departmentID}"/>
		                            <input type="hidden" id="bdpdepartmentname" name="bdpdepartmentname" value="${person.bdpdepartmentname}"/>
		      	                </c:if>
			               </TD>
                        </TR>
                        
                        <c:if test="${permissionPo.keyf eq '1'}"> 
                        <TR>
                           <TD class="table_body" height="26">入库成本</TD>
			               <TD class="table_none">			                      
	                           <input type="radio" id="totalPriceType" name="totalPriceType" value="1" checked="checked"/>单据中结算的不含税成本
	                           <input type="radio" id="totalPriceType" name="totalPriceType" value="2"/>单据中结算的含税成本
	                           <label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>
			               <TD class="table_body" height="26">出库成本</TD>
			               <TD class="table_none" colspan=3>			                      
	                                                                         加权平均成本（如果未进行成本计算，则默认按零统计）
	                           <label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>		               
                        </TR>
                        </c:if>
                        
                        <c:if test="${permissionPo.keyf ne '1'}">
                        <TR>
                           <TD class="table_body" height="26">查看成本</TD>
			               <TD class="table_none" colspan=5>
	                            <input type="radio" id="totalPriceType" name="totalPriceType" value="0" checked="checked"/>当前登录账户没有查看成本的权限，报表中将不显示成本，只显示数量，若需要查看成本，请先联系系统管理员配置权限
			               </TD>			               
                        </TR>
                        </c:if>
                        
                      	<TR>
			               <TD height="26" class="table_body">查看日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include><label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>			               
			               <TD class="table_body">查看级别</TD>
			               <TD class="table_none">                          
                               <input type="radio" name="queryClassify2" onclick="changeSelect(this)" value="1" checked="checked"/>商品类别&nbsp;&nbsp;
	      	                   <input type="radio" name="queryClassify2" onclick="changeSelect(this)" value="2" />制造商&nbsp;&nbsp;
	      	                   <input type="radio" name="queryClassify2" onclick="changeSelect(this)" value="3" />品种&nbsp;&nbsp;
	      	                   <label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>			               
			               <TD class="table_body">零售价</TD>
			               <TD class="table_none">
								<input class="text_input60" type="text" id="bgnretailamount2" name="bgnretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>&nbsp;至&nbsp;<input class="text_input60" type="text" id="endretailamount2" name="endretailamount2" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写销售金额！'}]"/>
								<label style="color:red;">标准零售价</label>
			               </TD>
                        </TR>

                        <TR group="type" id="category" style="display: none;">
                           <TD height="28" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
							   <select sid="1" id="goodscategoryID2" name="goodscategoryID2" onchange="isShowCus();">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>&nbsp;&nbsp;
	      	                   <span sid="1" name="isShowC">
	      	                   <input sid="1" type="radio" name="isCustomize1" value="" checked="checked">全部&nbsp;
	      	                   <input sid="1" type="radio" name="isCustomize1" value="0">成品&nbsp;
	      	                   <input sid="1" type="radio" name="isCustomize1" value="D">订制
	      	                   </span>
	      	               </TD>
                        </TR>
                        <TR group="type" id="supplier" style="display: none;">
                           <TD height="28" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="2" id="goodscategoryID2" name="goodscategoryID2" onchange="isShowCus();">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>&nbsp;&nbsp;
	      	                   <span sid="2" name="isShowC">
	      	                   <input sid="2" type="radio" name="isCustomize2" value=""  checked="checked">全部&nbsp;
	      	                   <input sid="2" type="radio" name="isCustomize2" value="0">成品&nbsp;
	      	                   <input sid="2" type="radio" name="isCustomize2" value="D">订制
	      	                   </span>
	      	               </TD>
						   <TD class="table_body">制造商</TD>
			               <TD  class="table_none" colspan="3">
			               <li class="horizontal_onlyRight">
						   		<input sid="2" class="text_input160" type="text"  id="supplierName2" name="supplierName2" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="2" type="hidden" id="supplierID2" name="supplierID2" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
                        </TR>
                        <TR group="type" id="brand" style="display: none;">
                           <TD height="28" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="3" id="goodscategoryID2" name="goodscategoryID2" onchange="isShowCus();">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>&nbsp;&nbsp;
	      	                   <span sid="3" name="isShowC">
	      	                   <input sid="3" type="radio" name="isCustomize3" value="" checked="checked">全部&nbsp;
	      	                   <input sid="3" type="radio" name="isCustomize3" value="0">成品&nbsp;
	      	                   <input sid="3" type="radio" name="isCustomize3" value="D">订制
	      	                   </span>
	      	               </TD>
						   <TD class="table_body">制造商</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input sid="3" class="text_input160" type="text"  id="supplierName2" name="supplierName2" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="3" type="hidden" id="supplierID2" name="supplierID2" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openSupplier();"></li>
			               </TD>
			               <TD class="table_body">品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input sid="3" class="text_input160" type="text"  id="brandName2" name="brandName2" value="${requestScope.brandName}" readonly="readonly">
						   		<input sid="3" type="hidden" id="brandID2" name="brandID2" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openBrand();">
							   </li>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">查看条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>显示
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>隐藏
                               <label style="color:red;">&nbsp;*&nbsp;</label>
                               <br/><label style="color:red;">&nbsp;查看的报表中显示或隐藏查询条件，此项的默认值由系统参数设定</label>
			               </TD>
                           <TD class="table_body">公司名称</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>显示
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="2"/>隐藏
                               &nbsp;&nbsp;<label style="color:red;">&nbsp;*&nbsp;查看的报表中显示或隐藏公司名称</label>
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

			<c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">												
                      如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【商品库存周转率（按单据）】这个定时任务按照单据中的填写成本重新汇总数据。<br/>
					</div>														
			</c:if>	
	
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
