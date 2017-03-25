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
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});

		<s:iterator value="preDepPoList">
			$("#ds").val($("#ds").val() + "${departmentName },");
			$("#bdpdepartmentname").val($("#bdpdepartmentname").val() + "${departmentName },");
			$("#departmentID").val($("#departmentID").val() + "${prePlanDepId },");
		</s:iterator>
		
		if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	});
	function setPrePlan() {
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var url = "initSelPrePlan.action?prePlanPo.Overdue=0&moduleID="+$("#moduleID").val();
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【门店计划销售设置】";
	}
	function search(){
		var depIds = "";
		var depNames = "";
		var planName = $("#planName").val();
		var planId = $("#planId").val();
		var minScale = $("#minScale").val();
		var maxScale = $("#maxScale").val();

		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});
		depIds = $("#departmentID").val();
		if(depIds == ''){
			depIds = $("#dids").val();
		}
		
		depNames = $("#bdpdepartmentname").val();
		if(depNames == ''){
			depNames = EncodeUtf8($("#dnames").val());
		}
		
		if(!depIds) {
			alert("请选择销售门店!");
			return;
		} else {
			depNames = EncodeUtf8(depNames.substring(0, depNames.length-1));
		}

		var myData = "&logincompanyid="+'${person.personcompanyid}'+"&depIds=" + depIds + "&depNames=" + depNames + "&planName=" 
						+ planName + "&planId=" + planId + "&minScale=" + minScale 
						+ "&maxScale=" + maxScale +'&isShow=' + isShow;
		
		var DataURL = "report.action?reportlet=sales_preSalesRpt.cpt" + myData; 
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}		
		document.getElementById('popupTitle').innerHTML="【门店计划销售完成额度统计表】"; 
	}
	function clean(){
		goodsForm.reset();
		$("input[clean=clean]").each(function() {
			if($(this).attr("type") == "checkbox") {
				$(this).attr("checked", false);
				$(this).parent().attr("style", "color:black");
				$(this).attr("disabled", "");
			} else {
				$(this).val("");
			}
		});
		$("select[clean=clean]").each(function() {
			$(this).val("");
		});
	}

	function checkDp() {
		$("input[id=departmentIds]").each(function() {
			if($(this).attr("disabled") == "") {
				$(this).attr("checked", $("input[id=all]").attr("checked"));
			}
		})
	}

	function openPrePlan() {
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selPrePlanOpenForRpt.action",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selPrePlanOpenForRpt.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【计划销售表名称查询】";
	}
	function setPrePlanIdAndName(id, name) {
		$("#planName").val(name);
		$("#planId").val(id);
		goodsForm.action = 'initPreSales.action';
		goodsForm.submit();
	}

	function setCheckDp(departmentId) {
		$("input[id=departmentIds]").each(function() {
			if($(this).val() == departmentId) {
				$(this).attr("checked", "checked");
				$(this).parent().attr("style", "color:red");
			} 
			if($(this).attr("checked") != true){
				$(this).attr("disabled", "disabled");
			} else {
				$(this).attr("disabled", "");
			}
		})
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>门店类报表</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：门店计划销售完成额度统计表</TD>
            <td align="right" valign="bottom">
            	<%--<c:if test="${(permissionPo.keyb==1)}">--%>
            		<img src="${ctx }/img/newbtn/btn_setplan_0.png" btn=btn title="门店计划销售设置" onClick="setPrePlan()">
            	<%--</c:if>--%>
            </td>
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
				               <li class="horizontal_onlyRight">
							   		<input class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" />
							   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 240px' readonly="readonly" value=""></textarea>							   		
							   		<input class="text_input100" type="hidden" id="departmentID" name="departmentID" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
      	                   <%--<c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID" />
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}"/>
      	                   </c:if>--%>
			               </TD>
			               <TD width="10%" class="table_body">完成计划百分比</TD>
			               <TD class="table_none"  width="40%" colspan="3">
                            <input class="text_input80" clean=clean id="minScale" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')"
                             />
						       至
					         <input class="text_input80" clean=clean id="maxScale" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')"
					         />
					         <font color="red">只能输入整数</font>
			               </TD>
                        </TR>
                        <TR height="26">
                        <TD width="10%" class="table_body">计划名称</TD>
			               <TD class="table_none" width="25%">
	                          <li class="horizontal_onlyRight">
	                            <input type="text" clean=clean class="text_input160" id="planName" name="prePlanPo.planName" value="${requestScope.prePlanPo.planName }" readonly="readonly" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计划销售名称不能为空!'}]"/>
	                          </li>
	                            <input type="hidden" clean=clean id="planId" name="prePlanPo.planId" value="${requestScope.prePlanPo.planId }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计划销售名称不能为空!'}]"/>
	                          </li>
	                            &nbsp;&nbsp;&nbsp;&nbsp;
	                          <li class="horizontal_onlyRight">
	                          <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onclick="openPrePlan()" >
	                          </li>
			               </TD>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" >
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
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
        <TD background="${ctx }/img/pic/tab_bg.gif" bgColor="#ffffff"><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
