<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排班维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	var d = new Date().getFullYear();
    	for(var i=d-1;i<d+5;i++)
    	{
    		$("#year").append("<option value='"+i+"'>"+i+"</option>"); 
    	}
    	var index_year = 0;
		var arr = document.all.year.options.length;
		for(i=0;i<arr;i++)
		{
			if(document.all.year.options[i].value == '<c:out value="${year}"/>')
			{
				document.all.year.selectedIndex = index_year;
				break;
			}
			index_year++;
		}  
	});
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	personInfoForm.action=link;
	  	personInfoForm.submit();
		showLoadingBar();
	}
	
	function search(){
		
		if($("#year").val() == ""){
			alert("请选择年份！");
			$("#year").focus();
			return;
		}

		if($("#month").val() == ""){
			alert("请选择月份！");
			$("#month").focus();
			return;
		}
		
		personInfoForm.action ="selSchedulingDays.action";
		personInfoForm.submit();
		showLoadingBar();
	}
	
	function updateState(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateSchedulingDayPoWithExamine.action?hid="+id,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateSchedulingDayPoWithExamine.action?hid="+id,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【排班审核】";
	}
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selWagePos.action?mid="+id+"&isFirst=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selWagePos.action?mid="+id+"&isFirst=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【排班更新】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSchedulingDayPoInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSchedulingDayPoInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【排班新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteSchedulingDayPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteSchedulingDayPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【排班删除】";
	}	
		
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSchedulingDayDetails.action?hid="+id+"&type=1&isFirst=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSchedulingDayDetails.action?hid="+id+"&type=1&isFirst=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【排班详细】";
	}
	function updatePer(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateSchedulingDayPo.action?hid="+id+"&type=1&isFirst=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initUpdateSchedulingDayPo.action?hid="+id+"&type=1&isFirst=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【排班修改】";
	}
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean()
	{
		$("#year").val('');
		$("#month").val('');
		$("#personNumber").val('');
		$("#personName").val('');
		$("#bdpdepartmentname").val('');
		$("#ds").val('');
		$("#departmentID").val('');
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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

		$('#departmentID').val(arrayID.join(","));
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}
function test()
{
	var departmentid = $('#departmentID').val();
	var personNumber = $('#personNumber').val();
	var personName = $('#personName').val();
	var year = $('#year').val();
	var month = $('#month').val();
	if($("#year").val() == ""){
			alert("请选择年份！");
			$("#year").focus();
			return;
		}

		if($("#month").val() == ""){
			alert("请选择月份！");
			$("#month").focus();
			return;
		}
		
	var DataURL = "report.action?reportlet=personday.cpt&__bypagesize__=false&personNumber="+personNumber+"&personName="+personName+"&year="+year+"&month="+month+"&departmentid="+departmentid;									                    
    var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;		
	if(is_iPad()){
		showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		window.open(DataURL,'','toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,width='+(screen.width)+',height='+(screen.height-100)); 
	}	

	document.getElementById('popupTitle').innerHTML="【排班明细表】";
}
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }

    function gatherScheduling(){
        var str = "";
		$("input[id=chk]").each(function (){
			if($(this).attr("checked")){
				str = str + $(this).val()+",";
			}
		});
		if(str == ""){
			alert("请选择排班单！");
			return;
		}

		if(confirm("是否汇总当月排班单？")){
			$("#bills").val(str);
			personInfoForm.action ="insertSchedulingMonthPo.action";
			personInfoForm.submit();
		}
    }
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input  id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" value="" name="bills" id="bills" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>      
          <TR>
            <td align="left" valign="bottom">
            	<c:if test="${(permissionPo.keya==1)}"> 
            		<img src="${ctx }/img/newbtn/btn_schedulingMonthsinsert_0.png" btn=btn title="排班新增" onclick="insert()"/>
            	</c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
            
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr>
         <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
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
						   <TD width="8%" height="26" class="table_body">排班人员编号</TD>
			               <TD width="24%" class="table_none">
			               	<input class="text_input160" id="personNumber" name="personNumber" value="${personNumber }" />
			               </TD>
							<TD width="8%" height="26" class="table_body">人员姓名</TD>
                          <TD width="24%" class="table_none">
							<input type="text" class="text_input160" id="personName" name="personName"  value="${personName }">
						 </TD>
						 
						   
							<TD width="8%" height="26" class="table_body">部门</TD>
			               <TD class="table_none">			               		
				                <li class="horizontal_onlyRight">
									<input class="text_input160" id="bdpdepartmentname"  name="departmentname" type="hidden"  value="${departmentname }"/>
									<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 300px' readonly="readonly" >${departmentname }</textarea>
							   		<input type="hidden" id="departmentID" name="departmentid" value="${departmentid }"/>
	                            </li>
							    <li class="horizontal_onlyRight">
							  		<img src="${ctx}/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openDepartment();">
							    </li>
							     
			               </TD>
						</TR>
						<tr>
						<TD width="8%" height="26" class="table_body">年度</TD>
			           <TD height="26" class="table_none">
			            <span id="id_year">
						   <select name="year" id="year" class="text_input160"> 
						   	<option value="">请选择</option>
						   </select>
						</span>
					   </TD>
          
					   <TD height="26" class="table_body">月份</TD>
			           <TD height="26" class="table_none" >
			           <span id="id_month">
						   <select name="month" id="month" class="text_input160"  >
					   		<option value="">请选择</option>
				             <option value="1">1</option>
				             <option value="2">2</option>
				             <option value="3">3</option>
				             <option value="4">4</option>
				             <option value="5">5</option>
				             <option value="6">6</option>
				             <option value="7">7</option>
				             <option value="8">8</option>
				             <option value="9">9</option>
				             <option value="10">10</option>
				             <option value="11">11</option>
				             <option value="12">12</option>
				            </select>	
			           </span>				
			           </TD>
			            <TD height="26" class="table_body">&nbsp;</TD>
			           <TD height="26" class="table_none" >  &nbsp;			
			           </TD>
				   </TR>
                      </TBODY>
                    </TABLE>
               		
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td width="50%" align="left">
							<c:if test="${(permissionPo.keyd==1)}">  
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >			  	
							</c:if> 
							</td>
							<td width="50%" align="right">
							<c:if test="${(permissionPo.keyb==1)}">  
								<img src="${ctx }/img/newbtn/btn_schedulingtotal_0.png" btn=btn title='汇总排班单' onclick="test();" >
							</c:if> 
							</td>
						</tr>
					</table>
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
                    
                    <c:if test="${not empty(schedulingDayPos)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>

					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>                          
                          <TH width="6%" scope=col colspan="2">操作</TH>
                          <TH  height="26" width="5%" scope=col>人员编号</TH>
                          <TH  height="26" width="5%" scope=col>姓名</TH>
                         <c:if test="${not empty schedulingDayPos }">
                        	<c:forEach var="sday" items="${schedulingDayPos}" >
                        	<TH scope=col>${sday.msdmonth}月${sday.msdschedulingdate }号 </TH>
                        	</c:forEach>
                        	</c:if>                           
                        </TR>
                        
                        <c:if test="${not empty schedulingPersonPos }">
                        	<c:forEach var="po" items="${schedulingPersonPos}" >
                        		<tr class="row"   style="white-space: nowrap;" mce_style="white-space: nowrap;">
                        		 <TD width="3%">
                        		 	
                        		 	<c:if test="${(permissionPo.keyb=='1')}">
		                          		<c:if test="${schedulingMonthPo.msmexaminestate!='1'}">
		                          			<img btn=btn src="${ctx }/img/newbtn/edit_0.png" title='修改' onClick="updatePer('${po.mspuuid }')">
		                          		</c:if>
		                          		<c:if test="${schedulingMonthPo.msmexaminestate=='1'}">
		                          			&nbsp;
		                          		</c:if>
		                          	</c:if>	
		                          	<c:if test="${(permissionPo.keyb!='1')}">
		                          		&nbsp;
		                          	</c:if>	
                        		 
                        		 
                          			
		                          </TD>
		                          <TD width="3%">
		                          
		                          <c:if test="${(permissionPo.keyc=='1')}">
	                          		<c:if test="${schedulingMonthPo.msmexaminestate!='1'}">
	                          			<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.mspuuid }')" >
	                          		</c:if>
	                          		<c:if test="${schedulingMonthPo.msmexaminestate=='1'}">
	                          			&nbsp;
	                          		</c:if>
		                          	</c:if>
		                          	<c:if test="${(permissionPo.keyc!='1')}">
		                          		&nbsp;
		                          	</c:if>

		                          </TD>
		                           
                        		
                        			<td height="30px" class="FixedDataColumn">
                        				${po.msppersonid }
                        			</td>
                        			<td class="FixedDataColumn">
                        				${po.msppersonname }
                        			</td>
                        			
                        			
				                        	
				                        	
				                       
	                        			<c:if test="${not empty schedulingDayPos }">
			                        	<c:forEach var="sday" items="${schedulingDayPos}" >
			                        		<td>		                        		
				                        	<c:if test="${not empty schedulingPersonDayPos }">
					                        	<c:forEach var="shifts" items="${schedulingPersonDayPos}" >
					                        		<c:if test="${shifts.mspdsduuid==sday.msduuid && shifts.mspdspuuid==po.mspuuid }">
					                        			${shifts.mspdshiftname }&nbsp;
					                        		</c:if>
					                        	</c:forEach>
				                        	</c:if>	
				                        	
				                        					                        		                     	
					                        		                        	
											</td>	                        				                        		                        									
			                        	</c:forEach>
			                        	</c:if>			                        	
                        			
                        			
                        		</tr>
                        	</c:forEach>
                        </c:if>
                        
                       
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
                    
<script>
     
  
	
	
 	var index_month = 0;
	var arr = document.all.month.options.length;
	for(i=0;i<arr;i++)
	{
		if(document.all.month.options[i].value == '<c:out value="${month}"/>')
		{
			document.all.month.selectedIndex = index_month;
			break;
		}
		index_month++;
	} 
	
	
  </script>   

<%@ include file="/WEB-INF/inc/message.jsp" %>


