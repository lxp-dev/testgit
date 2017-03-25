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

	/**
	 * 价格区间维护开窗
	 */
	function salesAreaSet(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectSalesArea.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectSalesArea.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【价格区间维护】";
	}

	function search(){
		var ShopCode = $('#departmentID').val();
		if(ShopCode == ''){
			ShopCode = $("#dids").val();
		}
		
		var area = $('#salesArea').val();
		var BeginDate = document.getElementById("startTime").value;
		var End = document.getElementById("endTime").value;
        var salesType =  $('input[name=salrsType]:checked').val();
		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});

        if($('#ds2').val()==""){
        	alert('请选择价格区间!');
			return false;
        }
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
		var ShopCodeName=$('#ds').val();
		if(ShopCodeName == ''){
			ShopCodeName = EncodeUtf8($("#dnames").val());
		}
		
		var DataURL = "report.action?reportlet=sales_xsqjfxrqRpt.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode+"&bgnDate="+BeginDate+"&endDate="+End+"&priceArea="+$('#ds2').val()+"&salesType="+salesType+"&reportID=${moduleID}"+"&ShopCodeName="+EncodeUtf8(ShopCodeName)+'&isShow='+isShow; 
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}		
		document.getElementById('popupTitle').innerHTML="【销售区间分析表(日期)】";
		
	}
	function clean(){
		goodsForm.reset();	
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
	
	/**
	 * 价格区间开窗
	 */
	function openAmount(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var salesTypeID = $('input[name=salrsType]:checked').val();
		if(!salesTypeID) {
			alert("请选择销售类型!");
			return;
		}
		if(is_iPad()){
			showPopWin("salesAreaOpen.action?reportID=${moduleID}&salesTypeID="+salesTypeID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("salesAreaOpen.action?reportID=${moduleID}&salesTypeID="+salesTypeID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【价格区间查询】";
	}
	
	/**
	 * 价格区间开窗赋值实现方法
	 */
	function openAmountValues(objValue){
		var arrayID = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].areaid;
		}
		
		document.getElementById('salesArea').value = arrayID.join(",");
		document.getElementById('ds2').value = arrayID.join(",");
	}

	function cleanSalesArea(){
        $('#ds2').val('');
        $('#salesArea').val('');
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
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>${permissionPo.moduleName}</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：销售区间分析表（按日期）</TD>
            <TD align="right" width="40%" valign="bottom">&nbsp;
            	<%--<img btn=btn src="${ctx }/img/newbtn/btn_salesareaset_0.png" title='价格区间维护' onclick="salesAreaSet();" >--%>
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
      	                  <input type="hidden" id="ds" value="${person.bdpdepartmentname}" name="ds"/>
      	                   </c:if>
			               </TD>
			               <TD width="10%" height="26" class="table_body">价格区间</TD>
			               <TD class="table_none" width="40%">
				               <li class="horizontal_onlyRight">
							   		<textarea class="text_input200" id="ds2"  name="ds2" style='height:50px;width: 300px' readonly="readonly" value=""></textarea>							   		
							   		<input class="text_input100" type="hidden" id="salesArea" name="salesArea" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openAmount();">
							   </li>
			               </TD>
			              </TR>
			              <TR>
			              <TD height="26" class="table_body">销售类型</TD>
			               <TD class="table_none">
	                           <%--<select id="salesType" name="salesType">
	      		                 <option value="">----请选择----</option>
								 <option value="1">框镜成品</option>
								 <option value="2">框镜订制</option>
								 <option value="3">隐形成品</option>
								 <option value="4">隐形订制</option>
								 <option value="5">辅料</option>
	      	                   </select>--%>
	      	                   <input type="radio" name="salrsType" checked value="1" onclick="cleanSalesArea();">框镜成品&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType" value="2" onclick="cleanSalesArea();">框镜订制&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType" value="3" onclick="cleanSalesArea();">隐形成品&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType" value="4" onclick="cleanSalesArea();">隐形订制&nbsp;&nbsp;
	      	                   <input type="radio" name="salrsType" value="5" onclick="cleanSalesArea();">辅料&nbsp;&nbsp;
			               </TD>
			               <TD class="table_body">查询日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date2.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>			               
                        </TR>   
                        <TR>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </TR>                     
                        
                      </TBODY>
                    </TABLE>
            <c:if test="${permissionPo.keya eq '1'}">        
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                                <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
			</c:if>		
			<c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">
						1.用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;途：统计某个门店一段日期内，各价格区间段配镜单的数量和金额。<br/>													
						2.查询条件：部门名称：文本域显示可选择。门店人员使用时为只读只显示本门店。<br/>														
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期：为日期段，查询最早为上一天。门店人员使用时只能按特定时间段查询<br/>														
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格区间：文本域选择	<br/>													
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销售类型：5种销售类型	<br/>	
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
