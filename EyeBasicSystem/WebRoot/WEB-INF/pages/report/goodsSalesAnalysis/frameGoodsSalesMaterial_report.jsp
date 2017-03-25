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
	});

	function search(){
		createForm();
		var formAction = '';
		if(checkForm(goodsForm)){       		
			var BeginDate = document.all.startTime2.value;
			var End = document.all.endTime2.value;
			if(BeginDate==""){
				alert('请选择开始日期!');
				document.getElementById("startTime2").focus();
				return false;
			}
			if(End==""){
				alert('请选择截止日期!');
				document.getElementById("endTime2").focus();
				return false;
			}
			
			var ShopCode=$("input[id=departmentID]").val();
	    	var reportName = "";
	    	
			$("input[name=bgnDate]").val(BeginDate);
		    $("input[name=endDate]").val(End);
		    $("input[name=shopCode]").val(ShopCode);
			formAction = 'sales_frameGoodsSalesMaterial';
			reportName = 'sales_frameGoodsSalesMaterial.cpt';
			DataURL = "report.action?reportlet="+reportName+"&__bypagesize__=false&bgnDate="+BeginDate+"&endDate="+End
						    +"&shopCode="+ShopCode;
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{

				DataURL = "report.action?reportlet=" + reportName + "&__bypagesize__=false";
				queryReport(DataURL,formAction);
			}
			document.getElementById('popupTitle').innerHTML="【镜架销售材质统计表 】";
		}
	}
	
	function createForm(){
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";
		rptFrm.method = "post";
		
		var isShow = document.createElement("input");	     
	    isShow.type = "hidden";
	    isShow.name = "isShow";
	    isShow.value = '';	  
	    rptFrm.appendChild(isShow); 
		
	    var bgnDate = document.createElement("input");	     
	    bgnDate.type = "hidden";
	    bgnDate.name = "bgnDate";
	    bgnDate.value = '';	  
	    rptFrm.appendChild(bgnDate); 

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.name = "endDate";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate);  

	    var shopCode = document.createElement("input");	     
	    shopCode.type = "hidden";
	    shopCode.name = "shopCode";
	    shopCode.value = '';	  
	    rptFrm.appendChild(shopCode);    
	    
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
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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

	$(document).ready(function() { 
		today('startTime2','endTime2');
    	$('#personTab').show();
	});
	
	function checkNumberType(thiz){
		if($(thiz).val()!=''){
			if(parseFloat($(thiz).val())>0){
				var str='+'+parseFloat($(thiz).val().replace('+','')).toFixed(2);
				$(thiz).val(str);
			}else if(parseFloat($(thiz).val())<0){
				$(thiz).val(parseFloat($(thiz).val()).toFixed(2));
			}else if(parseFloat($(thiz).val())==0){
				$(thiz).val('0.00');
			}
		}
	}
	function dayCount(y, m) {                  
	    var yy = parseInt(y, 10);            
	    var mm = parseInt(m, 10);            
	    var result = 0;            
	    if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {                
		    result = 31;            
	    }            
	    else if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {                
		    result = 30;            
	    } else if (mm == 2) {                
	        if ((yy % 4 == 0 && yy % 100 != 0) || yy % 400 == 0) {                    
		        result = 29;                
	        } else {                    
		        result = 28;                
	        }            
	    }            
	    return result;        
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="departmentcount" name="departmentcount" value="${requestScope.departmentcount}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>决策分析类报表</TD>
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：镜架销售材质统计表</TD>
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
					  	<TR >
					  	   <TD width="12%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="27%" colspan="5">
			               
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
			               <TD width="12%" height="26" class="table_body" >查询日期</TD>
			               <TD class="table_none" colspan="5" >
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
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

