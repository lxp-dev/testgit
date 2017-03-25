<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>报表中心</title>
</head>
<script>	
	function search(){	
	    var departmentID=document.getElementById('departmentID').value;
		var year=document.getElementById('year').value;
        var month=document.getElementById('month').value;
        
		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';		
		url+="eims_reporting/storage_collectOtherOutRpt";		
		url+="&departmentID=" + departmentID;		
		url+="&date=" + year + "-" + month;

		url+="&rs:Command=Render";		
		window.open (url, 'storage_collectOtherOutRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	}
	
	function clean(){
		document.getElementById('departmentID').value = "";
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>报表中心</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：汇总其他出库单</TD>
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
						   <TD height="26" class="table_body">领用部门</TD>
			               <TD class="table_none">
                            <select id="departmentID" name="departmentID">
                             <option value="">----请选择----</option>      		                 
				               <option value="01">和平路店</option>
				               <option value="02">眼视光部</option>
				               <option value="03">隐形中心店</option>
				               <option value="04">河东店</option>
				               <option value="05">津南店</option>
				               <option value="06">塘沽店</option>
				               <option value="07">大港店</option>
				               <option value="08">奥城店</option>
				               <option value="09">武清店</option>
				               <option value="10">中北店</option>
				               <option value="11">西康路店</option>
				               <option value="13">河北店</option>
				               <option value="14">北辰店</option>
				               <option value="15">体北店</option>
				               <option value="752">河西分店</option>
				               <option value="101">营运部</option>
				               <option value="200">加工中心</option>
				               <option value="600">管理-管理中心</option>				               
      	                   </select>
			               </TD>			            
			               <TD width="10%" height="26" class="table_body">查看年月</TD>
			               <TD class="table_none" width="40%">
                            <span class="table_none">
							   	<select id="year" name="year">      		                          
      		                        <c:forEach var="i" begin="2011" end="${currentYear}" step="1"> 
                                      <option value="${i}" ${currentYear == i ? 'selected="selected"' : ''}>${i}</option>
      		                        </c:forEach>      		                 
      	                        </select>								
						  		<select id="month" name="month">
				               <option value="01">01</option>
				               <option value="02">02</option>
				               <option value="03">03</option>
				               <option value="04">04</option>
				               <option value="05">05</option>
				               <option value="06">06</option>
				               <option value="07">07</option>
				               <option value="08">08</option>
				               <option value="09">09</option>
				               <option value="10">10</option>
				               <option value="11">11</option>
				               <option value="12">12</option>            
      	                        </select>
                            </span>
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
