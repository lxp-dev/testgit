<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顾客分析表</title>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
</head>
<script>
function search(){
	createForm();
	var ShopCode = $('#departmentID').val();
	if(ShopCode == ''){
		ShopCode = $("#dids").val();
	}
	var beginTime = document.all.startTime2.value;
	var endTime = document.all.endTime2.value;
	var isShow = $('input[name=isShow2]:checked').val();
	var queryClassify = $('input[name=queryClassify]:checked').val();
	var departmentNames = EncodeUtf8($("#ds").val());
	if(departmentNames == ''){
		departmentNames = EncodeUtf8($("#dnames").val());
	}
	var showCompanyName = $('input[name=showCompanyName2]:checked').val();


    $('input[id=ShopCode]').get(0).value = ShopCode;
    if(departmentNames==''){
    	departmentNames='所有部门';
        }
    $('input[name=departmentNames]').get(0).value = departmentNames;
    $('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';
    $('input[id=beginTime]').get(0).value = beginTime;
    $('input[id=endTime]').get(0).value = endTime;
    $('input[name=isShow]').get(0).value = isShow;
    $('input[name=showCompanyName]').get(0).value = showCompanyName;

	if(beginTime==""){

				alert('请选择开始日期!');
				document.getElementById("startTime2").focus();
				return false;


	}
	if(endTime==""){

		alert('请选择截止日期!');
		document.getElementById("endTime2").focus();
		return false;

	}

    var reportUrl = "&ShopCode="+ShopCode+"&departmentNames="+EncodeUtf8(departmentNames)+"&beginTime="+beginTime+"&endTime="+endTime+"&isShow="+isShow+"&showCompanyName="+showCompanyName;
	var reportName = '';
	var DataURL = '';
	var formAction = '';
    switch(queryClassify){
        case '1':// 消费
            var paystatus=$('input[name=paystatus]:checked').val();
            if(paystatus =='1'){
				formAction = 'xfhy';
				reportName = 'customerAnalysis_xfhy.cpt';
				DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            }else if(paystatus =='2'){
				formAction = 'xfly';
				reportName = 'customerAnalysis_xfly.cpt';
				DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            }           
            break;	                                                                      
        case '2':// 回访
			formAction = 'xfhf';
			reportName = 'customerAnalysis_xfhf.cpt';
			DataURL="report.action?reportlet="+reportName+"&__bypagesize__=false"+reportUrl
            break;	                                                                      
        default:
	        return;
    }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
			queryReport(DataURL,formAction);
		}
		document.getElementById('popupTitle').innerHTML="【顾客分析表】";
            
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
function queryClass(){
	
	var queryClassify = $('input[name=queryClassify]:checked').val();
    if (queryClassify == '1'){        	
    	$('tr[id=salesbillstatusTab]').show();     
    }
    if (queryClassify == '2'){ 
    	$('tr[id=salesbillstatusTab]').hide();
    }
}
function clean(){
        
    goodsForm.reset();
    $('tr[id=salesbillstatusTab]').show();
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

	var ShopCode = document.createElement("input");
    ShopCode.type = "hidden";
    ShopCode.id = "ShopCode";
    ShopCode.name = "ShopCode";
    ShopCode.value = '';	  
    rptFrm.appendChild(ShopCode); 
    
    var beginTime = document.createElement("input");	     
    beginTime.type = "hidden";
    beginTime.id = "beginTime";
    beginTime.name = "beginTime";
    beginTime.value = '';	  
    rptFrm.appendChild(beginTime); 
    
    var endTime = document.createElement("input");	     
    endTime.type = "hidden";
    endTime.id = "endTime";
    endTime.name = "endTime";
    endTime.value = '';	  
    rptFrm.appendChild(endTime); 

    var departmentNames = document.createElement("input");	     
    departmentNames.type = "hidden";
    departmentNames.name = "departmentNames";
    departmentNames.value = '';	  
    rptFrm.appendChild(departmentNames); 

    var isShow = document.createElement("input");	     
    isShow.type = "hidden";
    isShow.name = "isShow";
    isShow.value = '';	  
    rptFrm.appendChild(isShow); 

    var showCompanyName = document.createElement("input");	     
    showCompanyName.type = "hidden";
    showCompanyName.name = "showCompanyName";
    showCompanyName.value = '';	  
    rptFrm.appendChild(showCompanyName);
    
    document.body.appendChild(rptFrm);
}
/**
 * 部门开窗
 */
function openDepartment(){
	
	var queryClassify = $('input[name=queryClassify]:checked').val();
	if(queryClassify == "" || queryClassify == null){
		alert('请选择查询分类!');
		return false;
	}
	  
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

	$('#departmentID').val(arrayID.join(","));
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
	    
	    if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
	});

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
<form id="goodsForm" name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="searchKey" value="${searchKey}">
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
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：顾客分析表</TD>
            <TD align=right>
                <img src="${ctx }/img/newbtn/reporthelp_0.png" btn=btn title='帮助' onclick="help();">	
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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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

                               <input type="radio" id="queryClassify" name="queryClassify" value="1" onclick="queryClass();" checked="checked"/>消费&nbsp;

                               <input type="radio" id="queryClassify" name="queryClassify" value="2" onclick="queryClass();"/>回访&nbsp;

                             
                           <label style="color:red;">&nbsp;*&nbsp;</label>                                                     
			               </TD>			             
                        </TR>
			            <TR group="type" id="salesbillstatusTab" inithide=inithide>
			               <TD class="table_body" height="26">查询分类</TD>
			               <TD class="table_none" colspan="3"> 
			               <input type="radio" name="paystatus" id ="paystatus" value="1" checked="checked"/>会员&nbsp;
			               <input type="radio" name="paystatus" id ="paystatus" value="2" />来源&nbsp;
			               </TD>
                        </TR>
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
						   <TD width="10%" height="26" class="table_body">查询部门</TD>
			               <TD class="table_none" width="40%">
			               <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
		               <c:if test="${person.departmenttype!=1}">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" type="hidden"/>
						   		<textarea class="text_input200" id="ds"  name="d" value=""  style='height:50px;' readonly="readonly" >${personInfoPo.bdpdepartmentname}</textarea>
						   		
						   		<input type="hidden" id="departmentID" value="${personInfoPo.departmentID }" />
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
						  <TD class="table_body">查询日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
			               </TD>
                        </TR>

                        
                        <TR>
			               <TD class="table_body" height="26">显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none">
                               <input clean=clean type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input clean=clean type="radio" id="showCompanyName2" name="showCompanyName2" value="0"/>否
			               </TD>
                        </TR>

                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr>
							<td height="26">
							<c:if test="${permissionPo.keya == '1'}">  
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >	
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
