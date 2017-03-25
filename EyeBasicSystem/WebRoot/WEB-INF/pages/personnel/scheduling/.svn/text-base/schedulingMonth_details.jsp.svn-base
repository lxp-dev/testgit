<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.FixedTitleRow
{
    position: relative; 
    top: expression(this.offsetParent.scrollTop); 
    z-index: 10;
    background-color: #CC6666;
}

.FixedTitleColumn
{
    position: relative; 
    left: expression(this.parentElement.offsetParent.scrollLeft);
}

.FixedDataColumn
{
    position: relative;
    left: expression(this.parentElement.offsetParent.parentElement.scrollLeft);
}	
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排班详细</title>
<script type="text/javascript">

$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});    	
    	
	});


/**
 * 部门开窗
 */
function openDepartment(){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initDepartmentOpen.action?mm=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initDepartmentOpen.action?mm=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	document.getElementById('tj').value = "1";	
	personInfoForm.action="initSchedulingDayPoInsert.action";
	personInfoForm.submit();
}
function fillDate() 
{
    var departmentID = document.getElementById("departmentID");  
    if(departmentID.value!="")
    {   
	    document.getElementById('tj').value = "1";	
		personInfoForm.action="initSchedulingDayPoInsert.action";
		personInfoForm.submit();
	}
}

function deleteRow(obj) 
{        
     $(obj).parent().parent().remove();
}
function save()
{
	if(checkForm(document.all.personInfoForm))
	{    
        $("img").removeAttr("onclick");
		personInfoForm.action = "insertSchedulingDayPo.action";
		personInfoForm.submit();
	}
}   
    
</script>
</head>
  
 <body   onhelp="Showhelp();return false;" >
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="tj" id="tj" value="" /> 

                          
    			<DIV style="overflow:auto;height:100%;width:100%;cursor:default;display:inline;position:absolute;">  
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="100%" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>      
                    
                     
                     
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 style="overflow:auto;" class="privateBorder">
					
                      <TBODY>
                        <TR class="table_title FixedTitleRow" align=middle>						 
						  <TH height="30px" class="FixedTitleColumn">人员编号</TH>
						  <TH class="FixedTitleColumn">姓名</TH>
						  <c:if test="${not empty schedulingDayPos }">
                        	<c:forEach var="sday" items="${schedulingDayPos}" >
                        	<TH scope=col nowrap="nowrap">${sday.msdmonth}月${sday.msdschedulingdate }号  &nbsp;</TH>
                        	</c:forEach>
                        	</c:if>
		
                        </TR>
                        <c:if test="${not empty schedulingPersonPos }">
                        	<c:forEach var="po" items="${schedulingPersonPos}" >
                        		<tr class="row"   style="white-space: nowrap;" mce_style="white-space: nowrap;">
                        			<td height="30px" class="FixedDataColumn">
                        				<input class="row"  style="border:1px;border-bottom-style:none;border-top-style:none;border-left-style:none;border-right-style:none;" id="msppersonid" name="schedulingPersonPo.msppersonid" value="${po.msppersonid }" readonly="readonly"/>
                        			</td>
                        			<td class="FixedDataColumn">
                        				<input class="row"  style="border:1px;border-bottom-style:none;border-top-style:none;border-left-style:none;border-right-style:none;" id="msppersonname" name="msppersonname" value="${po.msppersonname }" readonly="readonly"/>
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
                    </DIV>              
                  
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
