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
    	$('tr[id=salesbillstatusTab]').show(); 
    	$('tr[id=salesbillstatusTab2]').hide();
    	
    	if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	});

	function search(){

		if(checkForm(goodsForm)){
			if(!is_iPad()){
				createForm();
			}

			var minScale = $("#minScale2").val();
			var maxScale = $("#maxScale2").val();
			var isShow = $('input[name=isShow2]:checked').val();		
			var depIds = $("#departmentID").val();
			if(depIds == ''){
				depIds = $("#dids").val();
			}
			
			var depNames = $("#ds").val();
			if(depNames == ''){
				depNames = EncodeUtf8($("#dnames").val());
			}
			
			var showCompanyName = $('input[name=showCompanyName2]:checked').val();
			var BeginDate = document.all.startTime2.value;
			var End = document.all.endTime2.value;
			var collectForm = $('input[name=collectForm2]:checked').val();
			var personID = $("#personID2").val();
			var personName = $("#personName2").val();
			var collecttype = $("#collecttype2").val();
			var isclose = $("#isclose").val();

			if (depNames == ''){
				depNames = '所有门店';
		    }	
			if(BeginDate==""){
				alert('请选择起始查询日期!');
				document.all.startTime2.focus();
				return false;
			}
			if(End==""){
				alert('请选择截止查询日期!');
				document.all.endTime2.focus();
				return false;
			}
			
			var reportName = '';
			var formAction = '';

			var queryClassify=$('input[name=queryClassify]:checked').val();
			
		    switch(queryClassify){
	        case '1':// 按销售门店
			
			if(collectForm == '1'){
				reportName = 'storage_xaywjdb.cpt';
				formAction = 'pm';
				
				DataURL = "report.action?reportlet=storage_xaywjdb.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&shopCode="+depIds+"&bgndate="+BeginDate+"&enddate="+End+"&minScale="+minScale+"&ShopCodeName="+EncodeUtf8(depNames)+'&isShow='+isShow+"&maxScale="+maxScale+"&showCompanyName="+showCompanyName+"&collecttype="+collecttype; 
			}else{
				reportName = 'storage_xaywjdb2.cpt';
				formAction = 'pm2';
				
				DataURL = "report.action?reportlet=storage_xaywjdb2.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&shopCode="+depIds+"&bgndate="+BeginDate+"&enddate="+End+"&minScale="+minScale+"&ShopCodeName="+EncodeUtf8(depNames)+'&isShow='+isShow+"&maxScale="+maxScale+"&showCompanyName="+showCompanyName+"&collecttype="+collecttype;  
			}
                break;
            
	        case '2':// 销售人员
				reportName = 'storage_ryxaywjdb.cpt';
				formAction = 'pm3';
				DataURL = "report.action?reportlet=storage_ryxaywjdb.cpt&__bypagesize__=false&logincompanyid="+'${person.personcompanyid}'+"&shopCode="+depIds+"&bgndate="+BeginDate+"&enddate="+End+"&minScale="+minScale+"&ShopCodeName="+EncodeUtf8(depNames)+'&isShow='+isShow+"&maxScale="+maxScale+"&showCompanyName="+showCompanyName+"&collecttype="+collecttype+"&personID="+personID+"&personName="+EncodeUtf8(personName); 
				

                break;
	        default:
		        return;
        }   
	        
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				DataURL = "report.action?reportlet=" + reportName+"&__bypagesize__=false"; 
				$('#rptFrm input[name=shopCode]').get(0).value = depIds;
				$('#rptFrm input[name=bgndate]').get(0).value = BeginDate;
				$('#rptFrm input[name=endDate]').get(0).value = End;
				$('#rptFrm input[name=minScale]').get(0).value = minScale;
				$('#rptFrm input[name=ShopCodeName]').get(0).value = depNames;
				$('#rptFrm input[name=isShow]').get(0).value = isShow;
				$('#rptFrm input[name=maxScale]').get(0).value = maxScale;
				$('#rptFrm input[name=showCompanyName]').get(0).value = showCompanyName;
				$('#rptFrm input[name=personID]').get(0).value = personID;
				$('#rptFrm input[name=personName]').get(0).value = personName;
				$('#rptFrm input[name=collecttype]').get(0).value = collecttype;
				$('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';
				$('#rptFrm input[name=isClose]').get(0).value = isclose;
				
				queryReport(DataURL,formAction);
			}		
			document.getElementById('popupTitle').innerHTML="【业绩进度表】"; 
			
		}

	}


	function createForm(){
		
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";  
		rptFrm.method = "post";    

	    var shopCode = document.createElement("input");	     
	    shopCode.type = "hidden";
	    shopCode.name = "shopCode";
	    shopCode.value = '';	  
	    rptFrm.appendChild(shopCode);  

	    var bgndate = document.createElement("input");	     
	    bgndate.type = "hidden";
	    bgndate.name = "bgndate";
	    bgndate.value = '';	  
	    rptFrm.appendChild(bgndate); 

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.name = "endDate";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate);
	    
	    var logincompanyid = document.createElement("input");	     
	    logincompanyid.type = "hidden";
	    logincompanyid.name = "logincompanyid";
	    logincompanyid.value = '';	  
	    rptFrm.appendChild(logincompanyid);  

	    var minScale = document.createElement("input");	     
	    minScale.type = "hidden";
	    minScale.name = "minScale";
	    minScale.value = '';	  
	    rptFrm.appendChild(minScale); 

	    var maxScale = document.createElement("input");	     
	    maxScale.type = "hidden";
	    maxScale.name = "maxScale";
	    maxScale.value = '';	  
	    rptFrm.appendChild(maxScale);    
	    
	    var showCompanyName = document.createElement("input");	     
	    showCompanyName.type = "hidden";
	    showCompanyName.name = "showCompanyName";
	    showCompanyName.value = '';	  
	    rptFrm.appendChild(showCompanyName);    

	    var ShopCodeName = document.createElement("input");	     
	    ShopCodeName.type = "hidden";
	    ShopCodeName.name = "ShopCodeName";
	    ShopCodeName.value = '';	  
	    rptFrm.appendChild(ShopCodeName); 

	    var isShow = document.createElement("input");	     
	    isShow.type = "hidden";
	    isShow.name = "isShow";
	    isShow.value = '';	  
	    rptFrm.appendChild(isShow);
	     
	    var collecttype = document.createElement("input");	     
	    collecttype.type = "hidden";
	    collecttype.name = "collecttype";
	    collecttype.value = '';	  
	    rptFrm.appendChild(collecttype); 

	    var personID = document.createElement("input");	     
	    personID.type = "hidden";
	    personID.name = "personID";
	    personID.value = '';	  
	    rptFrm.appendChild(personID);

	    var personName = document.createElement("input");	     
	    personName.type = "hidden";
	    personName.name = "personName";
	    personName.value = '';	  
	    rptFrm.appendChild(personName); 
	    
	    var isClose = document.createElement("input");	     
	    isClose.type = "hidden";
	    isClose.name = "isClose";
	    isClose.value = '';	  
	    rptFrm.appendChild(isClose);

	    document.body.appendChild(rptFrm);
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
    
	function clean(){
		goodsForm.reset();
		$("input[clean=clean]").each(function() {
			if($(this).attr("type") == "checkbox") {
				$(this).attr("checked", false);
			} else {
				$(this).val("");
			}
		});
		$("select[clean=clean]").each(function() {
			$(this).val("");
		});
    	$('tr[id=salesbillstatusTab]').show(); 
    	$('tr[id=salesbillstatusTab2]').hide();
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

	function setPreShopSalesPlan() {
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var url = "initPreShopSalesSel.action?moduleID="+$("#moduleID").val();
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【门店计划销售金额设置】";
	}

	function setPrePersonSalesPlan() {
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var url = "initPrePersonSalesSel.action?moduleID="+$("#moduleID").val();
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【员工计划销售金额设置】";
	}
	function queryClass(){
		
		var queryClassify = $('input[name=queryClassify]:checked').val();
	    if (queryClassify == '1'){        	
	    	$('tr[id=salesbillstatusTab]').show(); 
	    	$('tr[id=salesbillstatusTab2]').hide();     	  
	    }
	    if (queryClassify == '2'){ 
	    	$('tr[id=salesbillstatusTab]').hide(); 
	    	$('tr[id=salesbillstatusTab2]').show();   
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>门店类报表</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：业绩进度表</TD>
            <td align="right" valign="bottom">&nbsp;
            <c:if test="${permissionPo.keyc == '1'}">
                <img src="${ctx }/img/newbtn/btn_setplan_0.png" btn=btn title="门店计划销售设置" onClick="setPreShopSalesPlan()">
            </c:if>
            <c:if test="${permissionPo.keyc == '1'}">
                <img src="${ctx }/img/newbtn/btn_setpersonplan_0.png" btn=btn title="员工计划销售设置" onClick="setPrePersonSalesPlan()">
            </c:if>
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

                               <input type="radio" id="queryClassify" name="queryClassify" value="1" onclick="queryClass();" checked="checked"/>按销售门店&nbsp;
                               <input type="radio" id="queryClassify" name="queryClassify" value="2" onclick="queryClass();" />按销售人员&nbsp;
                               <input type="hidden" name="collecttype2" id="collecttype2" value="${systemParameterPo.fspiscountperfrom}">
                             
                           <label style="color:red;">&nbsp;*&nbsp;</label>                                                     
			               </TD>			             
                        </TR>
                        <TR>
						   <TD width="10%" height="26" class="table_body">所属公司</TD>
			               <TD height="26" class="table_none">
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
                           <TD width="10%" height="26" class="table_body">部门类型</TD>
			               <TD height="26" class="table_none">
						   		<select clean="clean" id="isclose" name="isclose">
	                              <option value="">----请选择----</option>
	                              <option value="0">启用</option>
	                              <option value="1">停用</option>
	                            </select>
                           </TD>
                        </TR>
					  	<TR>
					  	 <TD width="10%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="40%">
			               <c:if test="${person.departmenttype!=1}">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" />
							   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 240px' readonly="readonly" value=""></textarea>							   		
							   		<input class="text_input100" type="hidden" id="departmentID" name="departmentID2" value=""/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
						   </c:if>
      	                   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID2" />
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}"/>
      	                   </c:if>
			               </TD>
			               <TD width="10%" height="26" class="table_body">查询日期</TD>
			               <TD class="table_none" width="40%">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
			               </TD>
			            </TR>
                        <TR id="salesbillstatusTab2">
			               <TD width="10%" height="26" class="table_body">员工编号</TD>
			               <TD width="20%" class="table_none"><input class="text_input100" clean=clean id="personID2" name="personID2" value="${personID}" /></TD>
					
						   <TD width="10%" height="26" class="table_body">员工姓名</TD>
                          <TD width="20%" class="table_none"><input class="text_input100" clean=clean id="personName2" name="personName2" value="${personName}"></TD>
			               </TR>
                        <TR height="26"  id="salesbillstatusTab">
                           <TD width="10%" class="table_body">汇总方式</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="collectForm2" name="collectForm2" checked="checked" value="1"/>按门店
                               <input type="radio" id="collectForm2" name="collectForm2" value="2"/>按日期
			               </TD>
                       </TR>
                       <TR>
			               <TD class="table_body">完成百分比</TD>
			               <TD class="table_none" colspan="3">
                            <input class="text_input80" clean=clean id="minScale2" type="text" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写完成百分比！'}]"/>
						       至
					         <input class="text_input80" clean=clean id="maxScale2" type="text" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写完成百分比！'}]"/>
			               </TD>
			            </TR>
                        <TR height="26">
			               <TD height="26" class="table_body">显示查询条件</TD>
			               <TD class="table_none" >
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none">
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="2"/>否
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							 <c:if test="${permissionPo.keya == '1'}">
							 	<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							 </c:if>
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
