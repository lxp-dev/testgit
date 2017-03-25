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
		var ShopCode = document.getElementById('departmentid').value;
		if(ShopCode==""){
			alert('请选择门店!');
			return false;
		}
	
		var BeginDate=document.all.startTime.value;
		var End=document.all.endTime.value;
		if(BeginDate=="" || End==""){
			alert('请选择日期!');
			return false;
		}
		
		if(BeginDate>End){
			alert('日期填写有误!');
			return false;
		}
		var ShopAssistant=document.all.shopAssistant.value;
		var Cashier=document.all.cashier.value;
		var Goodsname=document.all.goodsname.value;
		var OptID=document.all.optID.value;
		
		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
		url+="eims_reporting/sales_salseBasicFrameQTRpt&shopCode="+ShopCode+"&bgnDate="+BeginDate+"&endDate="+End;
		//+"&SalerID="+ShopAssistant+"&PoserID="+Cashier+"&goodsName="+Goodsname+"&YgPerson="+OptID+"&rs:Command=Render";		
	
		if(ShopAssistant != null && ShopAssistant != "") {
			url+="&SalerID="+ShopAssistant;
		}
		if(Cashier != "" && Cashier != null){
			url+="&PoserID="+Cashier;
		}
		if(Goodsname != "" && Goodsname != null){
			url+="&goodsName="+EncodeUtf8(Goodsname);
		}
		if(OptID != "" && OptID != null){
			url+="&YgPerson="+OptID;
		}
		url+="&rs:Command=Render";	
		window.open (url, 'salseBasicFrameQTRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		
	}
	function clean(){	
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('shopCode').value = "";
		document.getElementById('shopAssistant').value = "";
		document.getElementById('cashier').value = "";
		document.getElementById('goodsname').value = "";
		document.getElementById('optID').value = "";		
	}

	$(document).ready(function() {
		$("input[type=radio]").eq(0).attr("checked","checked");
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
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：框镜销售明细报表(眼视光部试用) </TD>
            <TD align=right></TD>
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
						   <TD width="13%" height="30" class="table_body">门店名称</TD>
			               <TD class="table_none" width="40%">
			                   <c:if test="${person.departmenttype!=1}">
                            <select id="departmentid" name="departmentID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
      	                   </c:if>
      	                     <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentid" value="${person.departmentID}" name="departmentid"/>
      	                   </c:if>
		                          
<!--                            <input class="text_input200" type="text" id="departmentname" name="departmentname" readonly="readonly" value="${departmentsPo.bdpdepartmentname}">-->
<!--                            <input type="hidden" id="departmentid" name="departmentid" value="${departmentsPo.bdpdepartmentid}">-->
			               </TD>
			               <TD width="13%" height="30" class="table_body">日期</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input100"
				               id="startTime"
						       name="startTime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime"
						       name="endTime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
			               </TD>
                        </TR>
					  	<TR>
						   <TD width="13%" height="30" class="table_body">营业员(工号)</TD>
			               			<TD class="table_none" width="40%"><input type="text" maxlength="20" id="shopAssistant" name="shopAssistant"/></TD>
			               <TD width="13%" height="30" class="table_body">收银员(工号)</TD>
						            <TD class="table_none" width="40%"><input type="text" maxlength="20" id="cashier" name="cashier"/></TD>
                        </TR>
					  	<TR>
						   <TD width="13%" height="30" class="table_body">商品名称</TD>
			               			<TD class="table_none" width="40%"><input type="text" maxlength="20" id="goodsname" name="goodsname"/></TD>
						   <TD width="13%" height="30" class="table_body">验光师(工号)</TD>
			               			<TD class="table_none" width="40%"><input type="text" maxlength="20" id="optID" name="optID"/></TD>
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

