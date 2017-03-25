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
	var salesType=$('#salesType').val();
		if(begintime == "" || endtime == ""){
			alert('请选择年月！');
			return false;
		}else{
			if(checkForm(document.all.goodsForm)){
			
			var year = document.getElementById("year").value;
			var month = document.getElementById("month").value;
				if(salesType=='2'){	
					var DataURL = "report.action?reportlet=treims/sales_operateSituationRpt.cpt&__bypagesize__=false&yearmatch="+ year+"-"+month;                      
			        window.open (DataURL,'经营情况统计表', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes'); 
				}else{
					var DataURL = "report.action?reportlet=treims/lead_ManageStream.cpt&__bypagesize__=false&queryYear="+year+"&queryMonth="+month;                      
			        window.open (DataURL,'经营流水报表', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes'); 
				}
			}
		}
	}
	function clean(){
		document.getElementById("year").value = "";
		document.getElementById("month").value = "";
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 

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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>北京同仁报表</TD>
            <TD align="left" width="45%">目前操作功能：经营情况统计表</TD>
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
			               <TD width="10%" height="30" class="table_body">年月</TD>
			               <TD class="table_none" width="15%">
                          		 <select id="year" name="year" >
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
      	                   </select>年&nbsp;&nbsp;&nbsp;&nbsp;
      	                    <select id="month" name="month" >
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
      	                   </select>月
                            
			               </TD>
			              <td  width="10%" height="30" class="table_body">
			              	查看类型
			              </td >
			              <td  class="table_none" colspan="3">
			              	 <select id="salesType" name="salesType" >
      		                 	<option value="">----请选择----</option>
                    	           <OPTION value="1">流水统计</OPTION>
                    	           <OPTION value="2">成本毛利率统计</OPTION>
      	                   </select>
			              </td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >
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
