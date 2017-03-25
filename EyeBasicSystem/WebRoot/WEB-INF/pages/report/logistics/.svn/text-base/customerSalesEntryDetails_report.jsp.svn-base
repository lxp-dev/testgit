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
	function search(){
		var ShopCode = $('#departmentID').val();
		if(ShopCode == ''){
			ShopCode = $("#dids").val();
		}
		
		var BeginDate = document.getElementById("startTime").value;
		var End = document.getElementById("endTime").value;
		var allpricemin = document.getElementById("allpricemin").value;
		var allpricemax = document.getElementById("allpricemax").value;
        var salesType = $('#salesType').val();
		var title = EncodeUtf8($("#title").val());
		var goodsName = EncodeUtf8($("#goodsName").val());
		var goodsID = $("#goodsID").val();
        var goodsCategoryID = $("#goodsCategoryID").val()
        var goodsCategoryName = EncodeUtf8(getSelectText("goodsCategoryID", ""));
		var supplierID = $("#supplierID").val();
		var supplierName = EncodeUtf8($("#supplierName").val());
		var brandID = $("#brandID").val();
		var brandName = EncodeUtf8($("#brandName").val());
		var discountRate = $("#discountRate").val();
		var shopCodeName = EncodeUtf8($("#ds").val());
		if(shopCodeName == ''){
			shopCodeName = EncodeUtf8($("#dnames").val());
		}
		
		var salesID = $("#salesID").val();
		var isArrears = $("#isArrears").val();
		var isShowZZ=$("input[name=isAndShowZZ]:checked").val();
		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});

		if(BeginDate==""){
			alert('请选择日期!');
			document.getElementById("startTime").focus();
			return false;
		}
	
		if(End==""){
			alert('请选择日期!');
			document.getElementById("endTime").focus();
			return false;
		}
	
			var DataURL = "report.action?reportlet=Sales_customerSalesDetails.cpt&__bypagesize__=false&shopCode="
						+ShopCode+"&logincompanyid="+'${person.personcompanyid}'+"&begintime="+BeginDate+"&endtime="+End+"&salesType="+salesType+"&allpricemin="
						+allpricemin+"&allpricemax="+allpricemax+"&title="+title+"&goodsName="+goodsName+"&goodsID="
						+goodsID+"&goodsCategoryID="+goodsCategoryID+"&supplierID="+supplierID+"&supplierName="
						+supplierName+"&brandID="+brandID+"&brandName="+brandName+"&discountRate="+discountRate
						+"&shopCodeName="+shopCodeName+"&goodsCategoryName="+goodsCategoryName+'&isShow='
						+isShow+"&salesID="+salesID+"&isArrears="+isArrears+"&isShowZZ="+isShowZZ;
			                    
	        var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				window.open(DataURL,'','toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,width='+(screen.width)+',height='+(screen.height-100)); 
			}	
		
			document.getElementById('popupTitle').innerHTML="【日/月销售配镜单统计表】";
	}
	
	function clean(){
		goodsForm.reset();	
	}

	function openBrand(){
		var supplierID=document.getElementById('supplierID').value;
		
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	 * 开窗赋值实现方法
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
	    $("#BHZZ").hide();
	    
	    if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
    }); 
	/**
	 * 获取select标签Text
	 */
	function getSelectText(selectId, setEqualsNullValue){
		if(!selectId) {
			alert("未找到select标签");
		} else {
			var selectObj = document.getElementById(selectId);
			var userSelectedIndex = selectObj.selectedIndex;
			var selectText = selectObj.options[userSelectedIndex].text
			if(!setEqualsNullValue) {
				if(selectText == "----请选择----") {
					selectText = "";
				}
			} else {
				if(selectText == setEqualsNullValue){
					selectText == "";
				}
			}
			var endIndex = selectText.indexOf("￥");
			if(endIndex > 0) {
				selectText = selectText.substring(0, endIndex-1);
			}
			return selectText;
		}
	}
	function isShowZZ(thiz){
		if($(thiz).val()==1||$(thiz).val()==2){
			$("#BHZZ").show();
		}else{
			$("#BHZZ").hide();
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>日常业务类报表</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：日/月销售配镜单统计表</TD>
            <TD align=right>&nbsp;</TD>
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
			               <TD class="table_none" width="40%">
			               <c:if test="${person.departmenttype != 1}">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" />
							   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 300px' readonly="readonly" value=""></textarea>							   		
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
			               <TD class="table_body">收银日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
                        </TR>
                        <TR>
						   <TD width="10%" height="26" class="table_body">销售金额</TD>
			               <TD class="table_none" width="40%">
			                <input clean=clean class="text_input100" type="text"  id="allpricemin" name="allpricemin" />&nbsp;至
                            <input clean=clean class="text_input100" type="text"  id="allpricemax" name="allpricemax" />&nbsp;(元)
			               </TD>
                              <TD height="26" class="table_body">销售类型</TD>
			              		 <TD class="table_none">
	                           <select id="salesType" name="salesType" onchange="isShowZZ(this)">
	      		                 <option value="">----请选择----</option>
								 <option value="1">框镜成品</option>
								 <option value="2">框镜订制</option>
								 <option value="3">隐形成品</option>
								 <option value="4">隐形订制</option>
								 <option value="5">辅料</option>
	      	                   </select>&nbsp;&nbsp;&nbsp;&nbsp;
	      	                   <span id="BHZZ"><input type="radio"  name="isAndShowZZ" checked="checked" value="1" >包含自架自片&nbsp;<input type="radio" name="isAndShowZZ" value="0" >不包含自架自片</span>
			               </TD>
                        </TR>
                        <TR>
                          <TD width="10%" height="26" class="table_body">
                                                       套餐名称
                          </TD>
                          <TD class="table_none" width="40%">
                            <input class="text_input160" id="title" type="text" maxlength="32"/>
                          </TD>
                          <TD width="10%" height="26" class="table_body">
                                                       商品名称
                          </TD>
                          <TD class="table_none" width="40%">
                            <input class="text_input160" id="goodsName" type="text" maxlength="32"/>
                          </TD>
                        </TR>
                        <TR>
                          <TD width="10%" height="26" class="table_body">
                                                       商品代码
                          </TD>
                          <TD class="table_none" width="40%">
                            <input class="text_input160" id="goodsID" type="text" maxlength="32"/>
                          </TD>
                          <TD width="10%" height="26" class="table_body">
                                                      商品类型
                          </TD>
                          <TD class="table_none" width="40%">
                            <select id="goodsCategoryID">
                              <option value="">----请选择----</option>
                              <s:iterator value="goodsCategoryList">
                                <option value="${bgcid }">${bgcgoodscategoryname }</option>
                              </s:iterator>
                            </select>
                          </TD>
                        </TR>
                        <TR><TD width="10%" height="26" class="table_body">制造商</TD>
			               <TD width="40%" class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value=""/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD width="10%" height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none" width="40%">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>

                        </TR>
                        <TR>
                          <TD width="10%" height="26" class="table_body">
                                                       低于折扣 
                          </TD>
                          <TD class="table_none" width="40%">
                            <input class="text_input160" id="discountRate" type="text" maxlength="5"/>
                          </TD>
			               <TD class="table_body" height="26">是否显示查询条件</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </TR>
                        <TR>
                          <TD width="10%" height="26" class="table_body">
                                                       配镜单号
                          </TD>
                          <TD class="table_none" width="40%">
                            <input class="text_input160" id=salesID type="text" />
                            <%--<span style="color:red;">(请输入完整的配镜单号)</span>--%>
                          </TD>
			               <TD class="table_body" height="26">付款状态</TD>
			               <TD class="table_none" colspan="3">
			                 <select id="isArrears">
			                   <option value="">----请选择----</option>
			                   <option value="0">未欠款</option>
			                   <option value="1">欠款</option>
			                 </select>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
							</td>
						</tr>
					</table>
					<c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">															
						1.用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;途：查询某时间段内的配镜单的销售详细情况，并可按商品明细显示<br/>													
						2.查询条件：部门名称：文本域显示可选择。门店人员使用时为只读只显示本门店。<br/>														
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期：为日期段，查询最早为上一天。门店人员使用时只能按特定时间段查询<br/>														
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销售金额：销售金额的价格段<br/>	
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销售类型：5种销售类型	<br/>																		
						3.查询结果：销售副数：配镜单详细信息以及商品明细<br/>														
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
