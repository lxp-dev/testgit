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
	function search(){
		var begintime = document.all.year.value;
		var endtime = document.all.month.value;
		var isShow = $('input[name=isShow2]:checked').val();
		
		if(checkForm(document.all.goodsForm)){

			if(!is_iPad()){
				createForm();
			}
			
			var year = document.getElementById("year").value;
			var month = document.getElementById("month").value;
			var salesType=$('#salesType').val();
			var queryType=$('input[name=queryType]:checked').val();
			if(salesType==''){
				alert("请选择查看类型！");
				return;
			}

			var DataURL='';
			var reportName = '';
			var formAction = '';
			
				if(salesType=='2'){	
					if(queryType=='1'){
						if(year==''){
							alert("请选择年份!");
							return;
						}
						DataURL = "report.action?reportlet=sales_operateSituationRpt_year.cpt&__bypagesize__=false&yearmatch="+ year+'&isShow='+isShow;                

						reportName = 'sales_operateSituationRpt_year.cpt';
						formAction = 'a1';
						$('#rptFrm input[name=yearmatch]').get(0).value = year;
						$('#rptFrm input[name=isShow]').get(0).value = isShow;
			        } 
					if(queryType=='2'){
						if(year==''){
							alert("请选择年份!");
							return;
						}
						if(month==''){
							alert("请选择月份!");
							return;
						}
						DataURL = "report.action?reportlet=sales_operateSituationRpt.cpt&__bypagesize__=false&yearmatch="+ year+"-"+month+'&isShow='+isShow; 

						reportName = 'sales_operateSituationRpt.cpt';
						formAction = 'a2';    
						$('#rptFrm input[name=yearmatch]').get(0).value = year+"-"+month;
						$('#rptFrm input[name=isShow]').get(0).value = isShow;           
					} 
					if(queryType=='3'){
						var BeginDate = document.getElementById("startTime").value;
						var End = document.getElementById("endTime").value;
						if(BeginDate==""){
							alert('请选择开始日期!');
							document.getElementById("startTime").focus();
							return false;
						}
						if(End==""){
							alert('请选择结束日期!');
							document.getElementById("endTime").focus();
							return false;
						}
						DataURL = "report.action?reportlet=sales_operateSituationRpt_date.cpt&__bypagesize__=false&queryBeginDate="+BeginDate+"&queryEndDate="+End+'&isShow='+isShow;

						reportName = 'sales_operateSituationRpt_date.cpt';
						formAction = 'a3';
						$('#rptFrm input[name=queryBeginDate]').get(0).value = BeginDate;
						$('#rptFrm input[name=queryEndDate]').get(0).value = End;
						$('#rptFrm input[name=isShow]').get(0).value = isShow;  
					}      
			        var topRows = top.document.getElementById("total").rows;
					var topCols = top.document.getElementById("btmframe").cols;	
					if(is_iPad()){
						showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}else{
						DataURL = "report.action?reportlet=" + reportName+"&__bypagesize__=false";
						queryReport(DataURL,formAction);
					}		
					document.getElementById('popupTitle').innerHTML="【经营情况统计表】";
				}else if(salesType=='1'){
					if(queryType=='1'){
						if(year==''){
							alert("请选择年份!");
							return;
						}
						DataURL = "report.action?reportlet=lead_ManageStream_year.cpt&__bypagesize__=false&queryYear="+$('#year').val()+'&isShow='+isShow;

						reportName = 'lead_ManageStream_year.cpt';
						formAction = 'b1';
						$('#rptFrm input[name=queryYear]').get(0).value = $('#year').val();
						$('#rptFrm input[name=isShow]').get(0).value = isShow;  
					}
					if(queryType=='2'){
						if(year==''){
							alert("请选择年份!");
							return;
						}
						if(month==''){
							alert("请选择月份!");
							return;
						}
						DataURL = "report.action?reportlet=lead_ManageStream.cpt&__bypagesize__=false&queryYear="+$('#year').val()+"&queryMonth="+$('#month').val()+'&isShow='+isShow;

						reportName = 'lead_ManageStream.cpt';
						formAction = 'b2';
						$('#rptFrm input[name=queryYear]').get(0).value = $('#year').val();
						$('#rptFrm input[name=queryMonth]').get(0).value = $('#month').val();
						$('#rptFrm input[name=isShow]').get(0).value = isShow;  
					}
					if(queryType=='3'){
						var BeginDate = document.getElementById("startTime").value;
						var End = document.getElementById("endTime").value;
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
						DataURL = "report.action?reportlet=lead_ManageStream_date.cpt&__bypagesize__=false&queryBeginDate="+BeginDate+"&queryEndDate="+End+'&isShow='+isShow;

						reportName = 'lead_ManageStream_date.cpt';
						formAction = 'b3';
						$('#rptFrm input[name=queryBeginDate]').get(0).value = BeginDate;
						$('#rptFrm input[name=queryEndDate]').get(0).value = End;
						$('#rptFrm input[name=isShow]').get(0).value = isShow;  
					}
					var topRows = top.document.getElementById("total").rows;
					var topCols = top.document.getElementById("btmframe").cols;		
					if(is_iPad()){
						showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}else{
						DataURL = "report.action?reportlet=" + reportName+"&__bypagesize__=false";
						queryReport(DataURL,formAction);
					}		
					document.getElementById('popupTitle').innerHTML="【经营流水统计表】";
				}else{}
			}
		
	}

	function createForm(){
		
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";  
		rptFrm.method = "post";    

	    var yearmatch = document.createElement("input");	     
	    yearmatch.type = "hidden";
	    yearmatch.name = "yearmatch";
	    yearmatch.value = '';	  
	    rptFrm.appendChild(yearmatch);  

	    var queryBeginDate = document.createElement("input");	     
	    queryBeginDate.type = "hidden";
	    queryBeginDate.name = "queryBeginDate";
	    queryBeginDate.value = '';	  
	    rptFrm.appendChild(queryBeginDate); 

	    var queryEndDate = document.createElement("input");	     
	    queryEndDate.type = "hidden";
	    queryEndDate.name = "queryEndDate";
	    queryEndDate.value = '';	  
	    rptFrm.appendChild(queryEndDate);  

	    var queryYear = document.createElement("input");	     
	    queryYear.type = "hidden";
	    queryYear.name = "queryYear";
	    queryYear.value = '';	  
	    rptFrm.appendChild(queryYear);  

	    var queryMonth = document.createElement("input");	     
	    queryMonth.type = "hidden";
	    queryMonth.name = "queryMonth";
	    queryMonth.value = '';	  
	    rptFrm.appendChild(queryMonth); 

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
    
	function queryReport(DataURL,formAction){
		
		var rptFrm = document.getElementById('rptFrm');
		rptFrm.action = DataURL;    
		rptFrm.target = formAction;    

		if (rptFrm.attachEvent){
			rptFrm.attachEvent("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));}); 		  
		}else{
			rptFrm.addEventListener("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));}); 		  
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
		document.getElementById("year").value = "";
		document.getElementById("month").value = "";
		$('input[id=queryType]').attr("checked",true)
	    isShowDate();
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    $('input[id=queryType]').attr("checked",true)
	    isShowDate();
    }); 
	function isShowDate(){
		var queryType=$('input[name=queryType]:checked').val();
		if(queryType=='1'){
			$('#date1').show();
			$('#date2').hide();
			$('#date3').hide();
			$('#dateSelect1').show();
			$('#dateSelect2').hide();
			$('#dateSelect3').hide();
		}
		if(queryType=='2'){
			$('#date1').hide();
			$('#date2').show();
			$('#date3').hide();
			$('#dateSelect1').show();
			$('#dateSelect2').show();
			$('#dateSelect3').hide();
		}
		if(queryType=='3'){
			$('#date1').hide();
			$('#date2').hide();
			$('#date3').show();
			$('#dateSelect1').hide();
			$('#dateSelect2').hide();
			$('#dateSelect3').show();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>决策分析类报表</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：经营情况统计表</TD>
            
			<TD align=right>&nbsp;</TD>
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
					  	<td  width="10%" height="30" class="table_body">
			              	查询方式
			              </td >
			              <td  class="table_none" width="20%" >
			              	 <%--<select id="queryType" name="queryType" onchange="isShowDate(this);">
                    	           <OPTION  value="1">年</OPTION>
                    	           <OPTION value="2">年—月</OPTION>
                    	           <OPTION value="3">年—月—日</OPTION>
      	                   </select>--%>
      	                   <input type="radio" name="queryType" id="queryType" value="1" onclick="isShowDate(this);">&nbsp;年
      	                   <input type="radio" name="queryType" value="2" onclick="isShowDate(this);">&nbsp;年月
      	                   <input type="radio" name="queryType" value="3"  onclick="isShowDate(this);">&nbsp;年月日
			              </td>
			              <td  width="10%" height="30" class="table_body">
			              	查看类型
			              </td >
			              <td  class="table_none" width="15%" >
			              	 <select id="salesType" name="salesType" >
      		                 	<option value="">----请选择----</option>
                    	           <OPTION value="1">流水统计</OPTION>
                    	           <OPTION value="2">成本毛利率统计</OPTION>
      	                   </select>
			              </td>
			               <TD width="10%" height="30" class="table_body"><span id="date1">年</span><span id="date2">年月</span><span id="date3">年月日</span></TD>
			               <TD class="table_none" width="40%" ><span id="dateSelect1">
                          		 <select id="year" name="year2" >
      		                 	<option value="">----请选择----</option>
                    	           <OPTION value="2009">2009</OPTION>
                    	           <OPTION value="2010">2010</OPTION>
                    	           <OPTION value="2011">2011</OPTION>
                    	           <OPTION value="2012">2012</OPTION>
                    	           <OPTION value="2013">2013</OPTION>
                    	           <OPTION value="2014">2014</OPTION>
                    	           <OPTION value="2015">2015</OPTION>
                    	           <OPTION value="2016">2016</OPTION>
                    	           <OPTION value="2017">2017</OPTION>
                    	           <OPTION value="2018">2018</OPTION>
                    	           <OPTION value="2019">2019</OPTION>
                    	           <OPTION value="2020">2020</OPTION>
      	                   </select>年&nbsp;&nbsp;&nbsp;&nbsp;</span>
      	                   <span id="dateSelect2"> <select id="month" name="month2" >
      		                 	<option value="">----请选择----</option>
                    	           <OPTION value="01">01</OPTION>
                    	           <OPTION value="02">02</OPTION>
                    	           <OPTION value="03">03</OPTION>
                    	           <OPTION value="04">04</OPTION>
                    	           <OPTION value="05">05</OPTION>
                    	           <OPTION value="06">06</OPTION>
                    	           <OPTION value="07">07</OPTION>
                    	           <OPTION value="08">08</OPTION>
                    	           <OPTION value="09">09</OPTION>
                    	           <OPTION value="10">10</OPTION>
                    	           <OPTION value="11">11</OPTION>
                    	           <OPTION value="12">12</OPTION>
      	                   </select>月</span>
                            <span id="dateSelect3"> 
                              <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
                            </span>
			               </TD>
			               
                        </TR>
                        <TR>
			               <TD class="table_body" height="26">显示查询条件</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
