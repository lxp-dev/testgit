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
	    var startDate = document.getElementById('startTime').value;
	    if (startDate == null || startDate == ""){
	        alert("请选择起始时间!");
	        return;
	    }
	    var endDate = document.getElementById('endTime').value;
	    if (endDate == null || endDate == ""){
	        alert("请选择终止时间!");
	        return;
	    }
	    var typeID = document.getElementById('typeID').value;
	    var shopCode = document.getElementById('shopCode').value;
	    var goodsIDStart = document.getElementById('goodsIDStart').value;
	    var goodsIDEnd = document.getElementById('goodsIDEnd').value;
	   	var projectSet = document.getElementById('projectSet').value;
	    var isCustomize = document.getElementById('isCustomize').value; 
	    var supplierID = document.getElementById('supplierID').value; 
	    	    
		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
		url += "eims_reporting/";
		switch(typeID){
		    case '0' : url += "logistics_multilevelSalesAllRpt";       //数量金额类
		             break;     
		    case '1' : url += "logistics_multilevelSalesByNumberRpt";  //数量类 
		             break;
		    case '2' : url += "logistics_multilevelSalesByMoneyRpt";   //金额类
		}
		url += "&startDate="+startDate+"&endDate="+endDate;		
		
		if(shopCode != ""){
			url+="&shopCode="+shopCode;
		}
		
		if (typeID != '0'){
			if(isCustomize != "" || isCustomize != null){
			    url+="&isCustomize="+isCustomize;
		    }else{
		        url+="&isCustomize=NULL";
		    }
		    if(projectSet != ""){
			    url+="&type="+projectSet;
		    }
		}
		
		if(goodsIDStart != "" || goodsIDStart != null){
			url+="&goodsIDStart="+goodsIDStart;
		}else{
		    url+="&goodsIDStart=NULL";
		}
		if(goodsIDEnd != "" || goodsIDEnd != null){
			url+="&goodsIDEnd="+goodsIDEnd;
		}else{
		    url+="&goodsIDEnd=NULL";
		}
		    
	
		if(supplierID != ""){
			url+="&supplierID="+supplierID;
		}
		url+="&rs:Command=Render";
		//alert(url)
		
		switch(typeID){
		    case '0' : window.open (url, 'logistics_multilevelSalesAllRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		             break;     
		    case '1' : window.open (url, 'logistics_multilevelSalesByNumberRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		             break;
		    case '2' : window.open (url, 'logistics_multilevelSalesByMoneyRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		}
		
	 }
	
	function clean(){
		$('#title1').find("input").each(function(){
			$(this).val('');
		});
		$('#title1').find("select").each(function(){
			$(this).val('');
		});	
	}
		
	/**
	 * 制造商开窗
	*/
	function openSupplier(){
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
		
	}
	
	/**
	 * 开窗赋值实现方法
	*/
	function openSupplierValues(json){		
		$("#supplierID").val(json.id);
		$("#supplierName").val(json.value);
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
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：多级销售表</TD>
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
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
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
						   <TD width="10%" height="26" class="table_body">查看日期</TD>
			               <TD class="table_none" width="25%">
                           <input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime}" />
			               </TD>
			               <TD width="8%" height="26" class="table_body">报表类型</TD>
			               <TD class="table_none" width="15%">                            
                               <select id="typeID" name="typeID"}>
                                   <option value="1">数量类</option>
      		                       <option value="0">数量金额类</option>      		                       
      		                       <option value="2">金额类</option>
      	                       </select>
			               </TD>
			               <TD width="8%" height="26" class="table_body">门店名称</TD>
			               <TD class="table_none" width="15%">
						   	   <select id="shopCode" name="shopCode"}>
      		                       <option value="">----请选择----</option>
      		                       <s:iterator value="salesShopList">
      		                           <option value="${shopID}">${shopName}</option>
      		                       </s:iterator>
      	                       </select>	               
			               </TD>
                        </TR>
                        <TR>
                           <TD width="10%" height="26" class="table_body">商品代码取值</TD>			               
			               <TD class="table_none" width="25%" >                            
						   		<input class="text_input100" type="text" id="goodsIDStart" name="goodsIDStart" maxlength="7"> 至	
						   		<input class="text_input100" type="text" id="goodsIDEnd" name="goodsIDEnd" maxlength="7">					   			
			               </TD>
                           <TD width="8%" height="26" class="table_body">项目设置</TD>
			               <TD class="table_none">
						   	   <select id="projectSet" name="projectSet"}>      		                       
      		                       <option value="2">按商品</option>
      		                       <option value="1">按客户</option>
      		                       <option value="3">按制造商</option>
      	                       </select>	               
			               </TD>	
			               <TD width="8%" height="26" class="table_body">订做标识</TD>		               
			               <TD class="table_none">
						   	   <select id="isCustomize" name="isCustomize"}>
						   	       <option value="">----请选择----</option>						   	       
      		                       <option value="D">订做片</option>
      		                       <option value="0">成品片</option>
      	                       </select>	               
			               </TD>
                        </TR>
                        <TR>
                           <TD width="10%" height="26" class="table_body">制造商</TD>			               
			               <TD class="table_none" colspan="5">                            
                            <li class="horizontal_onlyRight">
                             <input type="text" id="supplierName" name="supplierName" class="text_input200" readonly="readonly" value="${supplierName}">
                             <input type="hidden" id="supplierID" name="supplierID" class="text_input200" readonly="readonly" value="${supplierID}">
                            </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title='选择' onclick="openSupplier();">
                            </li>				   			
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

