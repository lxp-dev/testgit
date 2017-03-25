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
	    $('#searchtypeGoods').attr("checked",true);
	    $("tr[id=category]").show();
	    
	    if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	});

	function search(){
		var arrDetails=new Array(); 
		 arrDetails[1]="商品类别";
		 arrDetails[2]="制造商";
	     arrDetails[3]="产品品种";	 
	     arrDetails[4]="产品名称";	 
		 arrDetails[5]="营业员";
		 arrDetails[6]="收银员";
		 arrDetails[7]="配镜单";
		 arrDetails[8]="销售门店 ";
		if(checkForm(goodsForm)){       		
			var BeginDate = document.all.startTime.value;
			var End = document.all.endTime.value;
			if(BeginDate==""){
				alert('请选择开始日期!');
				document.getElementById("startTime").focus();
				return false;
			}
			if(End==""){
				alert('请选择截止日期!');
				document.getElementById("endTime").focus();
				return false;
			}
	        var searchtype = $('input[name=searchtype]:checked').val();       
			var GoodsName = $("input[id=GoodsName][sid="+searchtype+"]").val();		
			var GoodsName=$("input[id=goodsName][sid="+searchtype+"]").val();
			var GoodsCode=$("input[id=goodsCode][sid="+searchtype+"]").val();
			var supplierID = $("input[id=supplierID][sid="+searchtype+"]").val();
			var goodscategoryID = $("select[id=goodscategoryID][sid="+searchtype+"]").val();
			var ShopCode=$("input[id=departmentID]").val();
			if(ShopCode == ''){
				ShopCode = $("#dids").val();
			}
			
			var brandID=$("input[id=brandID][sid="+searchtype+"]").val();
			var salesID=$("input[id=salesID]").val();
			var departmentNames = EncodeUtf8($("#ds").val());
			if(departmentNames == ''){
				departmentNames = EncodeUtf8($("#dnames").val());
			}
			
			var querySystematics = EncodeUtf8(arrDetails[searchtype]);
			var companyid = $("#companysid").val();
			
			var isShow = "";
			$("input[id=isShow]").each(function() {
				if($(this).attr("checked") == true) {
					isShow = $(this).val();
				}
			});
			var DataURL = '';
			if(searchtype == '1'){   // 商品类别
				DataURL = "report.action?reportlet=sales_anydatesalesamount6.cpt&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID+"&shopCode="+ShopCode+"&departmentNames="+departmentNames+"&querySystematics="+querySystematics+'&isShow='+isShow;
			}else if(searchtype == '3'){ // 产品品种
				var supplierName=EncodeUtf8($("input[id=supplierName][sid="+searchtype+"]").val());
				var brandName=EncodeUtf8($('#brandName').val());
				DataURL = "report.action?reportlet=sales_anydatesalesamount5.cpt&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&bgnDate="+BeginDate+"&enddate="+End+"&goodsCategoryID="+goodscategoryID+
				"&supplierID="+supplierID+"&bandID="+brandID+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
				+"&querySystematics="+querySystematics+'&supplierName='+supplierName+'&brandName='+brandName+'&isShow='+isShow;
			}else if(searchtype == '4'){ // 产品名称
				var supplierName=EncodeUtf8($("input[id=supplierName][sid="+searchtype+"]").val());
				var brandName=EncodeUtf8($("input[id=brandName][sid="+searchtype+"]").val());
				DataURL = "report.action?reportlet=sales_anydatesalesamount4.cpt&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&bgnDate="+BeginDate+"&endDate="+End+"&goodsCategoryID="+goodscategoryID+
						  "&supplierID="+supplierID+"&bandID="+brandID+"&goodsName="+GoodsName+"&goodsID="+GoodsCode+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
							+"&querySystematics="+querySystematics+'&supplierName='+supplierName+'&brandName='+brandName+'&isShow='+isShow;
			}else if(searchtype == '5'){ // 营业员
				DataURL = "report.action?reportlet=sales_anydatesalesamount2.cpt&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&bgnDate="+BeginDate
						+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
						+"&querySystematics="+querySystematics+'&isShow='+isShow;
			}else if(searchtype == '6'){ // 收银员
				DataURL = "report.action?reportlet=sales_anydatesalesamount1.cpt&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&bgnDate="+BeginDate
						+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
						+"&querySystematics="+querySystematics+'&isShow='+isShow;
			}else if(searchtype == '8'){ // 销售门店
				DataURL = "report.action?reportlet=sales_anydatesalesamount3.cpt&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&bgnDate="+BeginDate
						+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
						+"&querySystematics="+querySystematics+'&isShow='+isShow;
			}else if(searchtype == '7'){ // 配镜单
				DataURL = "report.action?reportlet=sales_anydatesalesamount8.cpt&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&bgnDate="+BeginDate
						+"&endDate="+End+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
						+"&querySystematics="+querySystematics+"&salerid="+salesID+'&isShow='+isShow;
			}else if(searchtype == '2'){ // 制造商
				var supplierName=EncodeUtf8($("input[id=supplierName][sid="+searchtype+"]").val());
				DataURL = "report.action?reportlet=sales_anydatesalesamount7.cpt&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&bgnDate="+BeginDate
						+"&enddate="+End+"&goodsCategoryID="+goodscategoryID+"&supplierID="+supplierID
						+"&shopCode="+ShopCode+"&departmentNames="+departmentNames
						+"&querySystematics="+querySystematics+'&supplierName='+supplierName+'&isShow='+isShow;
			}else{
                return;
			}

			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				openWindowForReport(DataURL); 
			}
			document.getElementById('popupTitle').innerHTML="【任意时段产品销售金额统计表 】";
		}

	}

	function openBrand(){
		var searchtype = $("input[name=searchtype]:checked").val();
		var goodscategoryID= $('select[id=goodscategoryID][sid='+searchtype+']').val();
		var supplierID=$('input[id=supplierID][sid='+searchtype+']').val();
		
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
		$('input[id=brandID][sid='+searchtype+']').val(json.brandID);
		$('input[id=brandName][sid='+searchtype+']').val(json.brandName);
	}
	
	function clean(){
		goodsForm.reset();
		$('input[id=startTime]').val("");
		$('input[id=endTime]').val("");
		$('input[id=goodsName]').val("");
		$('input[id=supplierID]').val("");
		$('input[id=supplierName]').val("");
		$('input[id=bdpdepartmentname]').val("");
		$('input[id=departmentID]').val("");
		document.getElementById('ds').value="";
		$('select[id=searchtype]').val("");
		$('select[id=goodscategoryID]').val("");
		$('input[id=brandName]').val("");
		$('input[id=brandID]').val("");
		$('input[id=goodsCode]').val("");
		$("tr[group=type]").hide();
		$("input[id=salesID]").val("");
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var searchtype = $("input[name=searchtype]:checked").val();
		var goodscategoryID= $('select[id=goodscategoryID][sid='+searchtype+']').val();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(goodscategoryID==''){
			alert("请选择商品类别！");
			return;
		}
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
		$('input[id=supplierID][sid='+searchtype+']').val(json.id);
		$('input[id=supplierName][sid='+searchtype+']').val(json.value);
		$('input[id=brandID][sid='+searchtype+']').val('');
		$('input[id=brandName][sid='+searchtype+']').val('');
		
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var companyid = $("#companysid").val();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
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

		$('input[id=goodsName]').val("");
		$('input[id=supplierID]').val("");
		$('input[id=supplierName]').val("");
		$('select[id=goodscategoryID]').val("");
		$('input[id=brandName]').val("");
		$('input[id=brandID]').val("");
		$('input[id=goodsCode]').val("");
		$('input[id=salesID]').val("");
	}
	/**
	 * 获取select标签Text
	 */
	function getSelectText(selectId,defaultValue){
		if(!selectId) {
			alert("未找到select标签");
		} else {
			var selectObj = document.getElementById(selectId);
			var userSelectedIndex = selectObj.selectedIndex;
			var selectText = selectObj.options[userSelectedIndex].text
			if(userSelectedIndex == 0) {
					selectText = "";
			}
			return selectText;
		}
	}	
	
	function loadDepartmentids(cid) {  
		if(cid == ''){
			$("#departmentID").val('');
	   		$("#bdpdepartmentname").val('');
	   		$("#ds").val('');
	   		$("#dids").val('');
			$("#dnames").val('');
		}else{
			$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "getAjaxDepartmentForCompanyID.action",          
	   	   	    async: true, 
	   	   	    data: "companysid="+cid+"&type=1",     
	   	   	    success: function(msg){
	   	   	    	var item = msg.split("/");
	                <c:if test="${person.departmenttype!=1}">
	                	$("#departmentID").val(item[0]);
	   	   	    		$("#bdpdepartmentname").val(item[1]);
	   	   	    		$("#ds").val(item[1]);
					$("#dids").val(item[0]);
					$("#dnames").val(item[1]);
					</c:if>  
	   	   	    }
			});
		}
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="dids" name="dids" value="">
<input type="hidden" id="dnames" name="dnames" value="">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>决策分析类报表</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：任意时段产品销售金额统计表 </TD>
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
						   <TD width="10%" height="26" class="table_body">所属公司</TD>
			               <TD height="26" class="table_none" colspan="5">
			                <c:if test="${person.personcompanytype eq '2'}">
			                	${person.personcompanyname }
	                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        </c:if>
	                        
	                        <c:if test="${person.personcompanytype ne '2'}">
	                        	<c:if test="${person.departmenttype!=1}">
							   		<select clean="clean" id="companysid" name="companysid" onchange="loadDepartmentids(this.options[this.options.selectedIndex].value)" >
		                              <option value="">----请选择----</option>
		                              <s:iterator value="companyNamePos">
		                              <option value="${fcnId}" ctype="${fcnmasterorvice }" ${companysid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
		                              </s:iterator>
		                            </select>
								</c:if>  
							    <c:if test="${person.departmenttype==1}">
		                            ${person.personcompanyname }
		                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        	</c:if>
	                        </c:if>
                           </TD>
                        </TR>
					  	<TR>
					  	   <TD width="12%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="27%">
			               
			               <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
		               <c:if test="${person.departmenttype!=1}">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" type="hidden" value="${personInfoPo.bdpdepartmentname }"  />
						   		<textarea class="text_input200" id="ds"  name="ds" value=""  style='height:50px;' readonly="readonly" >${personInfoPo.bdpdepartmentname}</textarea>
						   		
						   		<input type="hidden" id="departmentID" name="departmentID" value="${personInfoPo.departmentID }" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li>
						</c:if>  
						   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
                            <input type="hidden" id="ds" value='${person.bdpdepartmentname}'/>
						   		<input id="bdpdepartmentname" type="hidden" value="${person.bdpdepartmentname}"  />
      	                   </c:if>
						  </TD>
			               <TD width="7%" height="26" class="table_body">查询日期</TD>
			               <TD class="table_none" colspan="3">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>             
                               </jsp:include>
			               </TD>
			               
                        </TR>
                        <tr>
                        	<TD width="7%" class="table_body">查询分类</TD>
			               <TD class="table_none" width="25%" colspan="5">
			               	   <%--<select id="searchtype" name="searchtype" onchange="changeSelect(this)" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择查询分类!'}]">
	      		                 <option value="">----请选择----</option>	             
					             <option value="5">营业员</option>
	      		                 <option value="6">收银员</option>
	      		                 <option value="7">配镜单</option>
	      		                 <option value="8">销售门店</option>
	      		                 <option value="1">商品类别</option>
	      		                 <option value="2">制造商</option>
	      		                 <option value="3">产品品种</option>
	      		                 <option value="4">产品名称</option>	      		                 
	      	                   </select>--%>
	      	                    <input type="radio" name="searchtype"  id ="searchtypeGoods" onclick="changeSelect(this)" value="1" />商品类别&nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" onclick="changeSelect(this)" value="2" />按制造商     &nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" onclick="changeSelect(this)" value="3" />按产品品种&nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" onclick="changeSelect(this)" value="4" />按产品名称&nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" onclick="changeSelect(this)" value="5" />按营业员     &nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" onclick="changeSelect(this)" value="6" />按收银员     &nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" onclick="changeSelect(this)" value="7" />按配镜单     &nbsp;&nbsp;
	      	                   <input type="radio" name="searchtype" onclick="changeSelect(this)" value="8" />按销售门店&nbsp;&nbsp;
			               </TD>
                        </tr>
                        <TR  group="type" id="category" style="display: none;">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
							   <select sid="1" id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
                        </TR>
                        <TR group="type" id="supplier" style="display: none;">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="2" id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none" colspan="3">
			               <li class="horizontal_onlyRight">
						   		<input sid="2" class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="2" type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
                        </TR>
                        <TR group="type" id="brand" style="display: none;">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="3" id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input sid="3" class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="3" type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input sid="3" class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input sid="3" type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                        </TR>
                        <TR group="type" id="goods" style="display: none;">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="4" id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input sid="4" class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="4" type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input sid="4" class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input sid="4" type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                        </TR>
                        <tr group="type" id="goods" style="display: none;">
                           <TD class="table_body">商品代码</TD>
			               <TD class="table_none"><input sid="4" type="text" class="text_input160" maxlength="20" id="goodsCode" name="goodsCode"/></TD>
						   <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none" colspan="3"><input sid="4" type="text" class="text_input160" maxlength="20" id="goodsName" name="goodsName"/></TD>
                        </tr>
                        <tr group="type" id="salesID" style="display: none;">
                           <TD class="table_body">配镜单号</TD>
			               <TD class="table_none" colspan="5"><input sid="4" type="text" class="text_input160" maxlength="20" id="salesID" name="salesID"/></TD>
                        </tr>
                        <TR>
			               <TD class="table_body">是否显示查询条件</TD>
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
					<table width="100%">
						<tr height="50px">
							<div class="reportHelp">

							</div>
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

