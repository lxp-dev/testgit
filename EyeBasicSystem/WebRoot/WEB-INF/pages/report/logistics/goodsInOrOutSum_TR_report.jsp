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
		$("input[type=radio]").eq(0).attr("checked","checked");
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    	$(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      	$(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });
    });

	function search(){
	    if ($('#typeID').val() == ''){
	        alert("请选择汇总类型!");
	        $('#typeID').focus();
	        return;
	    }

		var salestypes = "";
		$("input[name=salestypes]:checked").each(function (){
			salestypes = salestypes + $(this).val()+",";
		});
		salestypes = salestypes.substring(0,salestypes.length-1);
		
	    var begintime = document.all.begintime.value;
	    var endtime = document.all.endtime.value;
		if(begintime == "" || endtime == ""){
			alert('请选择日期');
			return false;
		}else{
			var begindate = document.getElementById("begintime").value;
			var enddate = document.getElementById("endtime").value;
			var departmentid = document.getElementById("departmentid").value;
			var DataURL = null;
			
			if ($('#typeID').val() == '1'){
			    DataURL = "report.action?reportlet=treims/L_GoodsInOrOutStorageSumRpt.cpt&departmentID="+departmentid+"&begDate="+begintime+"&endDate="+endtime+"&salestype="+salestypes;                         
			}else{
			    DataURL = "report.action?reportlet=treims/L_GoodsInOrOutStorageSumBySupplierRpt.cpt&departmentID="+departmentid+"&begDate="+begintime+"&endDate="+endtime+"&salestype="+salestypes;                         
			}
		    
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【商品收发汇总表】";
		}
	}
	function clean(){
		document.getElementById("begintime").value = "";
		document.getElementById("endtime").value = "";
		document.getElementById("departmentid").value = "";
		document.getElementById("salestype").value="";
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
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>报表中心</TD>
            <TD class=menubar_readme_text vAlign=bottom>
				&nbsp;
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27>目前操作功能：商品收发汇总表 </TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD></TD>
			  </TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 11px" 
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
			               <TD width="10%" height="30" class="table_body">日期</TD>
			               <TD class="table_none" width="40%">
                           <li class="horizontal_onlyRight">
                            <input class="text_input100"
				               id="begintime"
						       name="begintime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endtime"
						       name="endtime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
						       
						   </li>
						   <li class="horizontal_onlyRight">
					  		<img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('begintime','endtime')"></li>
						   <li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_month_0.png" title="当月" onClick="currtMonth('begintime','endtime')"></li>
                            
			               </TD>
			               <TD  height="30" class="table_body">部门名称</TD>
			               <TD  class="table_none" colspan="3">
			                <c:if test="${person.departmenttype!=1}">
                            <select id="departmentid" name="departmentID" >
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
							</c:if>
						   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" name="departmentid" value="${person.departmentID}" name="departmentid"/>
      	                   </c:if>
			               </TD>
                        </TR>
                        <TR>
			               <TD  height="30" class="table_body">汇总类型</TD>
			               <TD  class="table_none">
                            <select id="typeID" name="typeID" >
      		                 	<option value="">----请选择----</option>
                                <option value="1">商品类型</option>
                                <option value="2">制造商</option>
      	                   </select>							
			               </TD>
			               <TD class="table_body">经销方式</TD>
			               <TD class="table_none">						
							<input type="checkbox" name="salestypes" value="jxfs1" >代销&nbsp;&nbsp;
			               	<input type="checkbox" name="salestypes" value="jxfs2" >数期&nbsp;&nbsp;
			               	<input type="checkbox" name="salestypes" value="jxfs3" >买断&nbsp;&nbsp;			               	
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onClick="javascript:search()">
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onClick="clean()">
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
