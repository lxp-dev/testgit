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
		var ShopCode = $('#departmentID').val();
		var BeginDate = document.getElementById("startTime").value;
		var End = document.getElementById("endTime").value;
        var salesType = $('#salesType').val();
        var goodsForm = $('input:radio[name=customAmountForm]:checked').val();
        var departmentNames = EncodeUtf8(document.getElementById("ds").value);
        var salesTypeText = EncodeUtf8(getSelectText("salesType", ""));
        var customAmountText = EncodeUtf8(getRadioText("customAmountForm"));
		
		if(ShopCode == ''){
			ShopCode = $("#dids").val()
		}

		if(departmentNames == ''){
			departmentNames = $("#dnames").val()
		}
		
		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		})	
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
		if(salesType==""){
			if (goodsForm == '1'){
				var DataURL = "report.action?reportlet=sales_dayMonthQTRpt.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&ShopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&departmentNames="+departmentNames+"&salesTypeText="+salesTypeText+"&customAmountText="+customAmountText+"&isShow="+isShow;
			}
			if (goodsForm == '2'){
				var DataURL = "report.action?reportlet=sales_dayMonthArrearsAppendByQTRpt.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&ShopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&departmentNames="+departmentNames+"&salesTypeText="+salesTypeText+"&customAmountText="+customAmountText+"&isShow="+isShow;
			}
			if (goodsForm == '3'){
				var DataURL = "report.action?reportlet=sales_dayMonthQT2Rpt.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&ShopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&departmentNames="+departmentNames+"&salesTypeText="+salesTypeText+"&customAmountText="+customAmountText+"&isShow="+isShow;
			}
		}
		if(salesType=="1"){			
			if (goodsForm == '1'){
				var DataURL = "report.action?reportlet=sales_dayMonthNotTuiQTRpt.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&ShopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&departmentNames="+departmentNames+"&salesTypeText="+salesTypeText+"&customAmountText="+customAmountText+"&isShow="+isShow;
			}
			if (goodsForm == '2'){
				var DataURL = "report.action?reportlet=sales_dayMonthNotTuiQTByArrearsRpt.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&ShopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&departmentNames="+departmentNames+"&salesTypeText="+salesTypeText+"&customAmountText="+customAmountText+"&isShow="+isShow;
			}
			if (goodsForm == '3'){
				var DataURL = "report.action?reportlet=sales_dayMonthNotTuiQT2Rpt.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&ShopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&departmentNames="+departmentNames+"&salesTypeText="+salesTypeText+"&customAmountText="+customAmountText+"&isShow="+isShow;
			}		
		}
		if(salesType=="2"){
			var DataURL = "report.action?reportlet=sales_dayMonthTuiQTRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&ShopCode="+ShopCode+"&beginTime="+BeginDate+"&endTime="+End+"&departmentNames="+departmentNames+"&salesTypeText="+salesTypeText+"&customAmountText="+customAmountText+"&isShow="+isShow; 		
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{

			openWindowForReport(DataURL); 
		}		
		document.getElementById('popupTitle').innerHTML="【日/月销售商品统计表】";
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
			return selectText;
		}
	}
	/**
	 * 获取select标签Text
	 */
	function getRadioText(radioName){
		var radios = document.getElementsByName(radioName);
		var checkedText = "";
		for( var checkedIndex = 0; checkedIndex < radios.length; checkedIndex++ ) {
			if( radios[checkedIndex].checked == true ) {
				checkedText = radios[checkedIndex].getAttribute("text");
				break;
			}
		}
		return checkedText;
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
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：日月销售商品统计表 </TD>
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
						   <TD width="7%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="22%">
			               <c:if test="${person.departmenttype != 1}">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" />
							   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 240px' readonly="readonly" value=""></textarea>							   		
							   		<input class="text_input100" type="hidden" id="departmentID" name="departmentID" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
      	                   </c:if>
      	                   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID" />
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}"/>
      	                   </c:if>
			               </TD>
			               <TD class="table_body" width="5%">查询日期</TD>
			               <TD class="table_none" width="26%">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
			              <TD width="6%" height="26" class="table_body">配镜单状态</TD>
			               <TD class="table_none" width="8%">
			               <select id="salesType" name="salesType">
	      		                 <option value="">----请选择----</option>
								 <option ${salesType eq '1' ? 'selected="selected"' : '' } value="1">销售</option>
								 <option ${salesType eq '2' ? 'selected="selected"' : '' } value="2">退款</option>
	      	                   </select>
			              </TD>
			               
                        </TR>
                        <TR>
                           <TD height="78" class="table_body">订金统计方式</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" name="customAmountForm" id="customAmount1" value="1" ${systemParameterPo.fspcustomamount eq '1' ? "checked" : "" } text="订金按应收金额计入结款日收入,商品金额计入结款日收入">订金按应收金额计入结款日收入,商品金额计入结款日收入<br/>
                               <input type="radio" name="customAmountForm" id="customAmount2" value="2" ${systemParameterPo.fspcustomamount eq '2' ? "checked" : "" } text="订金按应收金额计入补齐日收入,商品金额计入补齐日收入">订金按应收金额计入补齐日收入,商品金额计入补齐日收入<br/>
                               <input type="radio" name="customAmountForm" id="customAmount3" value="3" ${systemParameterPo.fspcustomamount eq '3' ? "checked" : "" } text="订金结款日收入,补齐金额计入补齐日收入,商品金额计入结款日收入">订金结款日收入,补齐金额计入补齐日收入,商品金额计入结款日收入<br/>
			               </TD>
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
					<c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">															
						1.用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;途：统计门店在某时间内的商品销售情况，并按商品类别进行分组显示<br/>													
						2.查询条件：部门名称：文本域显示可选择。门店人员使用时为只读只显示本门店<br/>														
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期：为日期段，门店人员使用时只能按特定时间段查询<br/>														
												
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;配镜单状态：全部、销售、退货	<br/>														
														
						3.查询结果：商品所有明细<br/>														
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报表下方对整个门店9种类别商品、辅料、附加费用进行数量和金的汇总，并生成总合计	<br/>	
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
