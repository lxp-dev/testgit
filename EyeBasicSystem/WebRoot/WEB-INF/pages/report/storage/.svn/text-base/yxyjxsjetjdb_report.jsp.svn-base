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
		if(ShopCode == ''){
			ShopCode = $("#dids").val();
		}
		
		var area = $('#salesArea').val();
		var BeginDate = document.getElementById("startTime").value;
		var End = document.getElementById("endTime").value;
		var typeID = document.getElementById("typeID").value;
		var year = document.getElementById("year").value;
		var BeginDate2 ;
		var End2 ;
        var typeSelID = document.getElementById("typeSelID").value;

        var departmentNames = EncodeUtf8(document.getElementById("ds").value);
        if(departmentNames == ''){
			departmentNames = EncodeUtf8($("#dnames").val());
		}
        
        var querySystemstaticsName = EncodeUtf8(getSelectText("typeSelID"));
        var analysisCategory = EncodeUtf8(getSelectText("typeID"));
        var contrastYear = EncodeUtf8(getSelectText("year"));
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
		if(typeSelID==""){
			alert('请选择查看类型!');
			document.getElementById("typeSelID").focus();
			return false;
		}
		if(typeID==""){
			alert('请选择统计分析类别!');
			document.getElementById("typeID").focus();
			return false;
		}

		if(year==""){
			alert('请选择对比年份!');
			document.getElementById("year").focus();
			return false;
		}
		if(year=="1"){
			BeginDate2=BeginDate.substring(0,4)-1;
			BeginDate2=BeginDate2+BeginDate.substring(4);
			End2=End.substring(0,4)-1;
			End2=End2+End.substring(4);
		}else if(year=="2"){
			BeginDate2=BeginDate.substring(0,4)-2;
			BeginDate2=BeginDate2+BeginDate.substring(4);
			End2=End.substring(0,4)-2;
			End2=End2+End.substring(4);
		}else{
			BeginDate2=BeginDate;
			End2=End;
		}
		
		var DataURL;
		if(typeSelID=='1'){
			if(typeID=='1'){
				DataURL= "report.action?reportlet=sales_yxyjxsjetjdbRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode
						+"&bgnDate="+BeginDate+"&endDate="+End+"&bgnDate2="+BeginDate2+"&endDate2="+End2
						+"&reportID=${moduleID}"+"&departmentNames="+departmentNames
						+"&querySystemstaticsName="+querySystemstaticsName+"&analysisCategory="+analysisCategory
						+"&contrastYear="+contrastYear+'&isShow='+isShow;
			}else if(typeID=='2'){
				DataURL= "report.action?reportlet=sales_yxyjxsjetjdbRpt2.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode
						+"&bgnDate="+BeginDate+"&endDate="+End+"&bgnDate2="+BeginDate2+"&endDate2="+End2
						+"&reportID=${moduleID}"+"&departmentNames="+departmentNames
						+"&querySystemstaticsName="+querySystemstaticsName+"&analysisCategory="+analysisCategory
						+"&contrastYear="+contrastYear+'&isShow='+isShow;
			}if(typeID=='3'){
				DataURL= "report.action?reportlet=sales_yxyjxsjetjdbRpt3.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode
						+"&bgnDate="+BeginDate+"&endDate="+End+"&bgnDate2="+BeginDate2+"&endDate2="+End2
						+"&reportID=${moduleID}"+"&departmentNames="+departmentNames
						+"&querySystemstaticsName="+querySystemstaticsName+"&analysisCategory="+analysisCategory
						+"&contrastYear="+contrastYear+'&isShow='+isShow;
			}
			document.getElementById('popupTitle').innerHTML="【隐形眼镜销售及同期销售金额对比分析】";
		}else{
			if(typeID=='1'){
				DataURL= "report.action?reportlet=sales_yxyjxssltjdbRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode
						+"&bgnDate="+BeginDate+"&endDate="+End+"&bgnDate2="+BeginDate2+"&endDate2="+End2
						+"&reportID=${moduleID}"+"&departmentNames="+departmentNames
						+"&querySystemstaticsName="+querySystemstaticsName+"&analysisCategory="+analysisCategory
						+"&contrastYear="+contrastYear+'&isShow='+isShow;
			}else if(typeID=='2'){
				DataURL= "report.action?reportlet=sales_yxyjxssltjdbRpt2.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode
						+"&bgnDate="+BeginDate+"&endDate="+End+"&bgnDate2="+BeginDate2+"&endDate2="+End2
						+"&reportID=${moduleID}"+"&departmentNames="+departmentNames
						+"&querySystemstaticsName="+querySystemstaticsName+"&analysisCategory="+analysisCategory
						+"&contrastYear="+contrastYear+'&isShow='+isShow;
			}if(typeID=='3'){
				DataURL= "report.action?reportlet=sales_yxyjxssltjdbRpt3.cpt&logincompanyid="+'${person.personcompanyid}'+"&departmentsID="+ShopCode
						+"&bgnDate="+BeginDate+"&endDate="+End+"&bgnDate2="+BeginDate2+"&endDate2="+End2
						+"&reportID=${moduleID}"+"&departmentNames="+departmentNames
						+"&querySystemstaticsName="+querySystemstaticsName+"&analysisCategory="+analysisCategory
						+"&contrastYear="+contrastYear+'&isShow='+isShow;
			}
			document.getElementById('popupTitle').innerHTML="【隐形眼镜销售及同期销售数量对比分析】";				
		}

 
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}		

		
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
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：隐形眼镜销售及同期数量及金额统计对比分析</TD>
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
			               <TD class="table_none" width="23%">
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
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}"/>
      	                   </c:if>
			               </TD>
			               <TD class="table_body" width="10%">查询日期</TD>
			               <TD class="table_none" width="23%">
                               <jsp:include page="/commons/report_date2.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
			               <TD class="table_body" width="10%">查询类型</TD>
			               <TD class="table_none">
							   <select id="typeSelID" name="typeSelID">
	      		                 <option value="">----请选择----</option>
	      		                 <option value="1">按金额</option>		      		                 
					               <option value="2">按数量</option>		     	                 
	     	                 
	      	                   </select>
			               </TD>			               
                        </TR>   
                        <TR>
						   <TD width="10%" height="26" class="table_body">统计分析类别</TD>
			               <TD class="table_none" width="23%">
							   <select id="typeID" name="typeID">
	      		                 <option value="">----请选择----</option>	      		                 
					               <option value="1">按使用分类</option>		     	                 
					               <option value="2">按抛弃分类</option>		     	                 
					               <option value="3">按品种</option>
	      	                   </select>
 
			               </TD>
			               <TD class="table_body">对比年份</TD>
			               <TD class="table_none" colspan="3">
							   <select id="year" name="year">
	      		                 <option value="">----请选择----</option>
	      		                   <option value="0">本年</option>      		                 
					               <option value="1">上一年</option>		     	                 
					               <option value="2">上二年</option>		     	                 
	      	                   </select>
			               </TD>			               
                        </TR>                      
                        
                        <TR>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" colspan="5">
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
1.查询日期(必选),但不包含今天。<br/>
2.根据选择的年份和月份，进行所有门店的汇总，并统计销售商品的月内毛利统计。
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
