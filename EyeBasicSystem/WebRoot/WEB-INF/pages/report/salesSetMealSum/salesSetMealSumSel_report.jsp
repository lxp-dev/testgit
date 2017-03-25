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
	    
	    if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	});
	
	function search(){	
		var ShopCode=document.all.departmentID.value;
		if(ShopCode == ''){
			ShopCode = $("#dids").val();
		}
		
		var BeginDate=document.all.startTime.value;
		var End=document.all.endTime.value;
		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});

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

		var  typeID= document.all.typeID.value;
		if(typeID==""){
			alert('请选择查看类型!');
			document.all.typeID.focus();
			return false;
		}
		var MealID = document.all.MealID.value;
		var ClassifyID = document.all.ClassifyID.value;
		var MealName=$('#MealName').val();
		var departmentName=$('#ds').val();
		if(departmentName == ''){
			departmentName = EncodeUtf8($("#dnames").val());
		}
		
		var DataURL = '';
        if(typeID=='1'){
        	DataURL = "report.action?reportlet=sales_salesSetMealSum.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentID="+ShopCode+"&beginDate="+BeginDate+"&endDate="+End+"&ClassifyID="+ClassifyID+"&MealID="+MealID+'&MealName='+EncodeUtf8(MealName)+'&departmentName='+EncodeUtf8(departmentName)+'&isShow='+isShow;
        }else{
        	DataURL = "report.action?reportlet=sales_salesSetMealSumForPerson.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentID="+ShopCode+"&beginDate="+BeginDate+"&endDate="+End+"&ClassifyID="+ClassifyID+"&MealID="+MealID+'&MealName='+EncodeUtf8(MealName)+'&departmentName='+EncodeUtf8(departmentName)+'&isShow='+isShow;
        }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}

		document.getElementById('popupTitle').innerHTML="【套餐销售活动评估分析】";
	}

	function openBrand(){
		var searchtype = $("select[id=searchtype]").val();
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
		var searchtype = $("select[id=searchtype]").val();
		$('input[id=brandID][sid='+searchtype+']').val(json.brandID);
		$('input[id=brandName][sid='+searchtype+']').val(json.brandName);
	}
	
	function clean(){
		goodsForm.reset();
		$("select[id=ClassifyID]").val("");
		$("input[id=startTime]").val("");
		$("input[id=endTime]").val("");
		$("select[id=typeID]").val("");		
		document.getElementById('bdpdepartmentname').value = "";
		document.getElementById('ds').value = "";
		document.getElementById('departmentID').value = "";

		$("input[id=MealID]").val("");
		$("input[id=MealName]").val("");
		$("textarea[id=mealds]").text("");
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var searchtype = $("select[id=searchtype]").val();
		var goodscategoryID= $('select[id=goodscategoryID][sid='+searchtype+']').val();
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
		var searchtype = $("select[id=searchtype]").val();
		$('input[id=supplierID][sid='+searchtype+']').val(json.id);
		$('input[id=supplierName][sid='+searchtype+']').val(json.value);
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
		}
		
		$("input[id=goodsName]").val("");
		$("input[id=goodsid]").val("");
		$("input[id=brandID]").val("");
		$("input[id=brandName]").val("");
		$("input[id=supplierID]").val("");
		$("input[id=supplierName]").val("");
		$("select[id=goodscategoryID]").val("");
	}
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+$("#companysid").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+$("#companysid").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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

	/**
	 * 套餐开窗
	 */
	function openSetMeal(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelSetMealReportOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelSetMealReportOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【套餐查询】";
	}
	
	/**
	 * 套餐开窗赋值实现方法
	 */
	function openSetMealValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].MealID;
			arrayName[i] = departments[i].MealName;
		}
		
		$('#MealID').val(arrayID.join(","));
		$('#MealName').val(arrayName.join(","));
		$('#mealds').val($('#MealName').val());
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
<input type="hidden" name="isShow" value="${permissionPo.keyc}">
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
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：套餐销售活动评估分析</TD>
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
						   <TD width="10%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="30%">
			               <c:if test="${person.departmenttype != 1}">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" />
							   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;' readonly="readonly" value=""></textarea>							   		
							   		<input class="text_input100" type="hidden" id="departmentID" name="departmentID" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
      	                   </c:if>
      	                   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
      	                  	<input type="hidden" id="ds" value="${person.bdpdepartmentname}" name="ds"/>
      	                   </c:if>
			               </TD>
			               <TD class="table_body" width="8%">查询日期</TD>
			               <TD class="table_none" width="23%">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
			               <TD class="table_body" width="10%">查看类型</TD>
			               <TD class="table_none" width="23%">
							   <select id="typeID" name="typeID">
	      		                 <option value="">----请选择----</option>
                                 <option value="1">按商品</option>
                                 <option value="2">按人次</option>
                                 
	      	                   </select>
			               </TD>
                        </TR>
					  	<TR>
					  	   <TD width="8%" height="26" class="table_body">套餐名称</TD>
			               <TD class="table_none" width="30%">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input160" id="MealName" name="MealName" type="text" />
							   		<input class="text_input100" type="hidden" id="MealID" name="MealID" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openSetMeal();">
							   </li>
			               </TD>
			               <TD class="table_body" width="8%">套餐分类</TD>
			               <TD class="table_none">
							   <select id="ClassifyID" name="ClassifyID">
	      		                 <option value="">----请选择----</option>
                                 <option value="1">框镜销售</option>
                                 <option value="3">隐形销售</option>
                                 <option value="5">辅料销售</option>
	      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none">
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

