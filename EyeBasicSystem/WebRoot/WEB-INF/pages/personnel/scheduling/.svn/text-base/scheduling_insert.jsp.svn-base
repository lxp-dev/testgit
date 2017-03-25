<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排班维护</title>
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

<script type="text/javascript">

$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
    	var ddlYear = document.getElementById("year");
        var ddlMonth = document.getElementById("month");
        var opt = null;
       var curDay = new Date();
       var year = curDay.getFullYear();
       for (var i = -1; i <10; i++) 
       {
           opt = document.createElement("OPTION");
           opt.value = year + i;
           opt.innerText = (year + i) + "年";
           ddlYear.appendChild(opt);
       }
       var yy="${year }";
       var mm="${month }";
       if(yy=="")
       {
       	
       }else
       {
       ddlYear.value = yy;
       }
       for (var i = 1; i <= 12; i++) 
       {
           opt = document.createElement("OPTION");
           opt.value = i;
           opt.innerText = i + "月";
           ddlMonth.appendChild(opt);
       }
       if(mm=="")
       {
       	
       }else
       {
       ddlMonth.value = mm;
       }
        	
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
 * 人员开窗
 */
	function openPerson()
	{
		var year=$('#year').val();
		var month=$('#month').val();
		if(year=="")
		{
			alert("请选择年份!");
			$('#year').focus();
			return;
		}
		if(month=="")
		{
			alert("请选择月份!");
			$('#month').focus();
			return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initMPersonsByMonthSel.action?year="+year+"&month="+month+"&moduleID=M0301",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initMPersonsByMonthSel.action?year="+year+"&month="+month+"&moduleID=M0301",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【人员查询】";
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
	
}

/**
	 * 开窗赋值实现方法
	 */
	function openPersonValues(objValue)
	{
		var arrayID = new Array();
		var arrayName = new Array();
		var persons = eval('(' + objValue + ')');
		for(var i = 0; i < persons.length; i++){	
			arrayID[i] = persons[i].personid;
			arrayName[i] = persons[i].personName;
		}

		$('#personid').val(arrayID.join(","));
		document.getElementById('personName').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('personName').value;
		document.getElementById('tj').value = "1";	
		
	}

function ymchange()
{
	$('#personName').val("");
	$('#ds').val("");
	$('#personid').val("");
	document.getElementById('tj').value = "1";	
	personInfoForm.action = "initSchedulingDayPoInsert.action";
	personInfoForm.submit();
}

function showDiv() 
{
	if($('#personid').val()=="")
	{
		alert("请选择排班人员!");
		$('#ds').focus();
	}else
	{
		if($("input[name=ctype]:checked").val() == '1')
		{
		   $("#div1").show();
		   $("#div2").hide();
	   }else
	   {
	   		$("#div2").show();
		   $("#div1").hide();
	   }
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
		if($("input[name=ctype]:checked").size()==0)
		{
			alert("请选择排班方式!");
			return;
		}
		
        $("img").removeAttr("onclick");
		personInfoForm.action = "insertSchedulingDayPo.action";
		personInfoForm.submit();
		showLoadingBar();
	}
}   
    
</script>
</head>
  
 <body   onhelp="Showhelp();return false;" >
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="tj" id="tj" value="" /> 

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>排班管理</TD>
                    <TD class=menubar_readme_text vAlign=bottom>
          				
          </TD></TR>
        <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <tr><td height="20px">&nbsp;</td></tr>
              <TR><!--?Start-->
						</TR></TBODY></TABLE></TD>
				</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD>
              		<TABLE cellSpacing=1 cellPadding=3 width="98%" align=center border=0 class="privateBorder"> 	
                      <TBODY>
                        <TR>
                          <TD width="8%" class="table_body">排班编号</TD>
                          <TD width="25%" class="table_none"><input class="text_input200" name="schedulingDayPo.msdnumber" readonly="readonly" value="${schedulingDayPo.msdnumber }"></TD>
                          <TD class="table_body">制单人</TD>
						   <TD height="26" align="left" class="table_none">
						  ${schedulingDayPo.msdcreatepersonname }	
						  <input type="hidden" id="msdcreatepersonname" name="schedulingDayPo.msdcreatepersonname" value="${schedulingDayPo.msdcreatepersonname }"/>		  
						   </TD>
                          
                           <TD class="table_body">制单日期</TD>
                           <TD height="26" align="left" class="table_none">
                           ${schedulingDayPo.msdcreatedate }
                           <input type="hidden" id="msdcreatedate" name="schedulingDayPo.msdcreatedate" value="${schedulingDayPo.msdcreatedate }"/>
                           </TD>
                         
					      </TR>
                     
                        <TR>
                        	<TD class="table_body">年份</TD>
                          	<TD class="table_none">
                          
	                         <span id="id_year">
						   		<select name="schedulingDayPo.msdyear" id="year" onchange="ymchange()" class="text_input160" >
						   			<option value="">请选择</option>
						   		</select>
							  </span>
					   		</TD>

                            
                            <TD class="table_body">月份</TD>
                          	<TD class="table_none">
		                     <span id="id_month">
							   <select name="schedulingDayPo.msdmonth" id="month" onchange="ymchange()" class="text_input160" >
						   			<option value="">请选择</option>
					            </select>	
				           	</span>
			           </TD>
                        
                           <TD width="8%" class="table_body">人员</TD>
                          <TD width="25%" class="table_none">
                          <li class="horizontal_onlyRight">
                          	<input class="text_input300" id="personName" name="spersonPo.personNames" value="${spersonPo.personNames }" type="hidden" />
						   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 300px' readonly="readonly" >${spersonPo.personNames }</textarea>
						   		
						   		<input type="hidden" id="personid" name="spersonPo.personids" value="${spersonPo.personids }"
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择人员！'}]"/>
                          
                          </li>
						   <li class="horizontal_onlyRight">						  		
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openPerson();">
						  	</li>
                           	
					</TD>                             	
                          
                        </TR>
                        
                         <TR>
                          
                           
                          <TD class="table_body">排班方式</TD>
						   <TD height="26" align="left" class="table_none">
							   <c:set value="" var="ppid"/>
		                          <c:forEach var="pk" items="${personInfos}" >
		                          	<c:set value="${ppid}${pk.id}," var="ppid"/>
		                          	
		                          </c:forEach>  
		                          <input type="hidden" name="perid" value="${ppid }"/>    
							   	<input type="radio" name="ctype" value="1" onclick="showDiv()"/>批量设定
							   	<input type="radio" name="ctype" value="2" onclick="showDiv()"/>  按人设定					    
						    </TD>
                              <TD class="table_body"></TD>
                           <TD height="26" align="left" class="table_none">
                           
                                            
                           </TD>                     
                           <TD class="table_body">&nbsp;</TD>
                           <TD height="26" align="left" class="table_none">&nbsp;</TD>
                        </TR>
                        
                      </TBODY>
                    </TABLE>
                	<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        
					   <TR>
						  <TD align="left">&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()"></TD>
                        </TR>                     
                    </TABLE>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行添加，由于数据量较大可能需要较长时间，请耐心等候...</div>
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
                    <DIV id="div1" style="overflow:auto;height:200px;width:100%;cursor:default;display:inline;position:absolute;display:'none'">
					<table  width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class="table_title FixedTitleRow" align=middle>					 						 
						  <c:if test="${not empty dat }">
                        	<c:forEach var="daa" items="${dat}" >
                        	<TH scope=col>${month }月${daa }号</TH>
                        	</c:forEach>
                        	</c:if>
		
                        </TR>
                        
                        		<tr class="row"   style="white-space: nowrap;" mce_style="white-space: nowrap;">
                        			
                        			<c:if test="${not empty dat }">
		                        	<c:forEach var="dda" items="${dat}" >
		                        	<td>
		                        	<table>
			                        	<c:forEach var="sm" items="${shiftMaintainPos}" >  
			                        	<tr>                    					
	                        				<td nowrap >	<input type="checkbox" name="sm${dda}" value="${ sm.msmuuid}" >${sm.msmshiftName }</td>
	                        			</tr>  
	                        			</c:forEach>	
		                        	</table>	                        	
									</td>		                        	                        					                      	                       		
                        	</c:forEach>
                        </c:if>
                        </tr>
                      </TBODY>
                    </TABLE>
                    </DIV>
                    
                	<DIV id="div2" style="overflow:auto;height:500px;width:100%;cursor:default;display:inline;position:absolute;display:'none'">
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class="table_title FixedTitleRow" align=middle>					 
						  <TH class="FixedTitleColumn" height="" >人员编号</TH>
						  <TH class="FixedTitleColumn" >姓名</TH>
						  <c:if test="${not empty dat }">
                        	<c:forEach var="daa" items="${dat}" >
                        	<TH scope=col>${month }月${daa }号</TH>
                        	</c:forEach>
                        	</c:if>
		
                          <TH scope=col >删除</TH>
                        </TR>
                        <c:if test="${not empty personInfos }">
                        	<c:forEach var="po" items="${personInfos}" >
                        		<tr class="row"   style="white-space: nowrap;" mce_style="white-space: nowrap;">
                        			<td height="" class="FixedDataColumn">
                        				<input class="row"  style="border:1px;border-bottom-style:none;border-top-style:none;border-left-style:none;border-right-style:none;" id="msppersonid" name="schedulingPersonPo.msppersonid" value="${po.id }" readonly="readonly"/>
                        			</td>
                        			<td class="FixedDataColumn"> 
                        				<input class="row"  style="border:1px;border-bottom-style:none;border-top-style:none;border-left-style:none;border-right-style:none;" id="msppersonname" name="msppersonname" value="${po.personName }" readonly="readonly"/>
                        			</td>
                        			<c:if test="${not empty dat }">
		                        	<c:forEach var="dda" items="${dat}" >
		                        	<td>
		                        	<table>
			                        	<c:forEach var="sm" items="${shiftMaintainPos}" >  
			                        	<tr>                    					
	                        				<td nowrap >	<input type="checkbox" name="sm${po.id }y${dda}" value="${ sm.msmuuid}" >${sm.msmshiftName }</td>
	                        			</tr>  
	                        			</c:forEach>	
		                        	</table>	                        	
									</td>
		                        	</c:forEach>
		                        	</c:if>
                        					
                        			
                        			<td>
                        			<img src="${ctx}/img/newbtn/delete_0.png" btn=btn title='删除' onclick="deleteRow(this)" >
                        		
                        			</td>
                        		</tr>
                        	</c:forEach>
                        </c:if>
                      </TBODY>
                    </TABLE>
                    </DIV>
                    
                    
                    
                    
                  <!--?End--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
