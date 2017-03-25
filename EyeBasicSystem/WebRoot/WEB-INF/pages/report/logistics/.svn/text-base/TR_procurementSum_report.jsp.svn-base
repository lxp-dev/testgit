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
		var begintime = document.all.begintime.value;
		var endtime = document.all.endtime.value;
	
		if(begintime == "" || endtime == ""){
			alert('请选择日期');
			return false;
		}else{
				if(checkForm(document.all.goodsForm)){
					var salestype = "";
					$("input[name=salestype]:checked").each(function (){
						salestype = salestype + $(this).val()+",";
					});
					
					salestype = salestype.substring(0,salestype.length-1);
					
					var goodscategoryid="";
					$("input[name=goodscategoryid]:checked").each(function (){
						goodscategoryid = goodscategoryid + $(this).val()+",";
					});
					
					goodscategoryid = goodscategoryid.substring(0,goodscategoryid.length-1);
					
					var types = $("#types");
					
					if(!types.val()){
						alert("请选择查询分类！");
						types.focus();
						return;
					}
					
					if(!goodscategoryid){
						alert("请选择商品类别！");
						return;
					}
					
					if(!salestype){
						alert("请选择经销方式！");
						return;
					}
					
					var begindate = document.getElementById("begintime").value;
					var enddate = document.getElementById("endtime").value;
					var departmentid = document.getElementById("departmentid").value;
					var supplierid=document.getElementById("supplierID").value;
					var brandID=document.getElementById("brandID").value;
					var minprice=document.getElementById("minprice").value;
					var maxprice=document.getElementById("maxprice").value;
					
					var DataURL = "";
					if(document.getElementById("types").value=='3')
					{
						DataURL = "report.action?reportlet=treims/logistics_ProcurementSumDetailsRpt.cpt&bgnDate="+begindate+"&endDate="+enddate+
								  "&goodsCategoryID="+goodscategoryid+"&departmentID="+departmentid+"&supplierid="+supplierid+"&brandID="+brandID+"&salestype="+salestype+"&minprice="+minprice+"&maxprice="+maxprice;                      
					}else if(document.getElementById("types").value=='1'){
						DataURL = "report.action?reportlet=treims/logistics_ProcurementSumRpt.cpt&bgnDate="+begindate+"&endDate="+enddate+
								  "&goodsCategoryID="+goodscategoryid+"&departmentID="+departmentid+"&supplierid="+supplierid+"&brandID="+brandID+"&salestype="+salestype+"&minprice="+minprice+"&maxprice="+maxprice;
					}else if(document.getElementById("types").value=='2'){
						DataURL = "report.action?reportlet=treims/storage_procurementSumByBrand.cpt&bgnDate="+begindate+"&endDate="+enddate+
								  "&goodsCategoryID="+goodscategoryid+"&departmentID="+departmentid+"&supplierid="+supplierid+"&brandID="+brandID+"&salestype="+salestype+"&minprice="+minprice+"&maxprice="+maxprice;                      
					}else if(document.getElementById("types").value=='4'){
						DataURL = "report.action?reportlet=treims/storage_procurementSumByBill.cpt&bgnDate="+begindate+"&endDate="+enddate+
								  "&goodsCategoryID="+goodscategoryid+"&departmentID="+departmentid+"&supplierid="+supplierid+"&brandID="+brandID+"&salestype="+salestype+"&minprice="+minprice+"&maxprice="+maxprice;                      
					}
					
					var topRows = top.document.getElementById("total").rows;
					var topCols = top.document.getElementById("btmframe").cols;
					
					if(is_iPad()){
						showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}else{
						showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}		
					document.getElementById('popupTitle').innerHTML="【采购入库单汇总表】";
				}
			}
	}
	function clean(){
		document.getElementById("begintime").value = "";
		document.getElementById("endtime").value = "";
		document.getElementById("goodscategoryid").value = "";
		document.getElementById("departmentid").value = "";
		document.getElementById("supplierid").value = "";
		document.getElementById("brandID").value = "";
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var goodscategoryID="";
		$("input[name=goodscategoryID]:checked").each(function (){
			goodscategoryID = goodscategoryID + $(this).val()+",";
		});		
		goodscategoryID = goodscategoryID.substring(0,goodscategoryID.length-1);
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
	}
	/**
	 * 品种开窗
	 */
	
	function openBrand(){
		var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
	    var goodsCategoryID = $.trim($('#goodsCategoryID').val());

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodsCategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodsCategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
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
            <TD class=menubar_function_text height=27>目前操作功能：采购入库单汇总表</TD>
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
				</TD></TR>
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
			               <TD width="7%" height="26" class="table_body">日期</TD>
			               <TD class="table_none" width="31%">
                           <li class="horizontal_onlyRight">
                            <input class="text_input80"
				               id="begintime"
						       name="begintime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input80"
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
			               <TD  height="26" width="7%" class="table_body">部门名称</TD>
			               <TD  class="table_none" width="23">
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
                            ${person.bdpdepartmentname}<input type="hidden" name="departmentid" value="${person.departmentID}" name="departmentid"/>
      	                   </c:if>
			               </TD>
			               <td width="7%" height="26" class="table_body">
			              		查询分类
			               </td>
			               <td class="table_none">
			               <select id="types" name="types">
      		                 	<option value="">----请选择----</option>
                    	           <OPTION value="1">按制造商</OPTION>
                    	           <OPTION value="2">按品种</OPTION>
                    	           <OPTION value="3">按商品明细</OPTION>
                    	           <OPTION value="4">按单据</OPTION>
      	                   </select>
			               </td>
			               </TR>
			               <tr>
			               <TD class="table_body">商品类别</TD>
			               <TD class="table_none" width="23%">
							<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="1" checked>镜架&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="2" checked>配件&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="3" checked>镜片&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="4" checked>隐形&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="5" checked>护理液&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="6" checked>太阳镜&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="7" checked>耗材&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="8" checked>老花镜&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryid" name="goodscategoryid" value="9" checked>视光&nbsp;&nbsp;
			               </TD>
			               <td class="table_body">制造商</td>
			               <td class="table_none">
			               			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" readonly="readonly" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li></td>
						  				 <TD  height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();"></li>
			               </TD>				  				
                        </tr>
                        <tr>
			               <TD class="table_body">经销方式</TD>
			               <TD class="table_none">
							<input type="checkbox" name="salestype" value="jxfs1" checked>代销&nbsp;&nbsp;
			               	<input type="checkbox" name="salestype" value="jxfs2" checked>数期&nbsp;&nbsp;
			               	<input type="checkbox" name="salestype" value="jxfs3" checked>买断&nbsp;&nbsp;
			               </TD>
			                <td class="table_body">成本价格</td>
			               <td class="table_none" colspan="3">
				   			<input id="minprice" class="text_input80" name="minprice" value="${minprice}"/>
				   				至
				   			<input id="maxprice" class="text_input80" name="maxprice" value="${maxprice}"/>
			               </TD>				  				
                        </tr>
                      </TBODY>
                    </TABLE>

                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' id="submitButton" onClick="javascript:search()">
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onClick="clean()">
							</td>
						</tr>
					</table>
                  </DIV>
                  <h4>* 当查询分类选择【按品种】的方式查看报表时，该报表将按单据审核日期进行数据统计。</h4>
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
