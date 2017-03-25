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
		var BeginDate=document.all.startTime.value;
		var End=document.all.endTime.value;
		if(BeginDate=="" || End==""){
			alert('请选择日期!');
			return false;
		};
		
		var start = BeginDate.split("-");
        var end = End.split("-");
        if(start[0]*1>end[0]*1)
        { 
            alert('起始时间不能大于结束时间！');
            return false;
        }
        if(start[0]*1==end[0]*1 && (start[1]*1>end[1]*1))
        {
            alert('起始时间不能大于结束时间！');
            return false;
        }
        if(start[0]*1==end[0]*1 && (start[1]*1==end[1]*1) && (start[2]*1>end[2]*1))
        {
            alert('起始时间不能大于结束时间！');
            return false;
        }

        var searchtype = $("#searchtype").val();

		if(searchtype == ''){
			alert("请选择查询分类！");
			return;
		}
		var GoodsName = $("input[id=GoodsName][sid="+searchtype+"]").val();
		
		var GoodsName=$("input[id=goodsName][sid="+searchtype+"]").val();
		var GoodsCode=$("input[id=goodsCode][sid="+searchtype+"]").val();
		var supplierID = $("input[id=supplierID][sid="+searchtype+"]").val();
		var goodscategoryID = $("select[id=goodscategoryID][sid="+searchtype+"]").val();
		var ShopCode=$("input[id=departmentID]").val();
		var brandID=$("input[id=brandID][sid="+searchtype+"]").val();

		var DataURL = '';
		if(searchtype == '1'){
			DataURL = "report.action?reportlet=sales_salesSameDateContrast.cpt&begindate="+BeginDate+"&enddate="+End+"&categoryid="+goodscategoryID+"&shopcode="+ShopCode;
		}else if(searchtype == '2'){
			DataURL = "report.action?reportlet=sales_salesSameDateContrastBySupplier.cpt&begindate="+BeginDate+"&enddate="+End+"&categoryid="+goodscategoryID+
					  "&supplierid="+supplierID+"&shopcode="+ShopCode;
		}else if(searchtype == '3'){
			DataURL = "report.action?reportlet=sales_salesSameDateContrastByBrand.cpt&begindate="+BeginDate+"&enddate="+End+"&categoryid="+goodscategoryID+
					  "&supplierid="+supplierID+"&brandid="+brandID+"&shopcode="+ShopCode;
		}else if(searchtype == '4'){
			DataURL = "report.action?reportlet=sales_salesSameDateContrastByGoods.cpt&begindate="+BeginDate+"&enddate="+End+"&categoryid="+goodscategoryID+
					  "&supplierid="+supplierID+"&brandid="+brandID+"&goodsname="+GoodsName+"&goodsid="+GoodsCode+"&shopcode="+ShopCode;
		}

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品销售同期对比分析表】";
	}

	function openBrand(){
		var searchtype = $("select[id=searchtype]").val();
		var goodscategoryID= $('select[id=goodscategoryID][sid='+searchtype+']').val();
		var supplierID=$('input[id=supplierID][sid='+searchtype+']').val();
		
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		var searchtype = $("select[id=searchtype]").val();
		$('input[id=brandID][sid='+searchtype+']').val(json.brandID);
		$('input[id=brandName][sid='+searchtype+']').val(json.brandName);
	}
	
	function clean(){
		$('input[id=startTime]').val("");
		$('input[id=endTime]').val("");
		$('input[id=goodsName]').val("");
		$('input[id=supplierID]').val("");
		$('input[id=supplierName]').val("");
		$('input[id=bdpdepartmentname]').val("");
		$('input[id=departmentID]').val("");
		$('input[id=ds]').val("");
		$('select[id=searchtype]').val("");
		$('select[id=goodscategoryID]').val("");
		$('input[id=brandName]').val("");
		$('input[id=brandID]').val("");
		$('input[id=goodsCode]').val("");
		$("tr[group=type]").hide();
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var searchtype = $("select[id=searchtype]").val();
		var goodscategoryID= $('select[id=goodscategoryID][sid='+searchtype+']').val();
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
		var searchtype = $("select[id=searchtype]").val();
		$('input[id=supplierID][sid='+searchtype+']').val(json.id);
		$('input[id=supplierName][sid='+searchtype+']').val(json.value);
		
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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

	function changeSelect(obj){
		$("tr[group=type]").hide();
		if($(obj).val() == '1'){
			$("tr[id=category]").show();
		}else if($(obj).val() == '2'){
			$("tr[id=supplier]").show();
		}else if($(obj).val() == '3'){
			$("tr[id=brand]").show();
		}else if($(obj).val() == '4'){
			$("tr[id=goods]").show();
		}

		$('input[id=goodsName]').val("");
		$('input[id=supplierID]').val("");
		$('input[id=supplierName]').val("");
		$('input[id=bdpdepartmentname]').val("");
		$('input[id=ds]').val("");
		$('select[id=goodscategoryID]').val("");
		$('input[id=brandName]').val("");
		$('input[id=brandID]').val("");
		$('input[id=goodsCode]').val("");
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>物流类报表</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品销售同期对比分析表</TD>
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
					  	   <TD width="8%" height="30" class="table_body">销售门店</TD>
			               <TD class="table_none" width="27%">
			               
			               <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
		               <c:if test="${person.departmenttype!=1}">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" type="hidden" value="${personInfoPo.bdpdepartmentname }"  />
						   		<textarea class="text_input240" id="ds"  name="ds" value=""   style='height:50px' readonly="readonly" >${personInfoPo.bdpdepartmentname}</textarea>
						   		
						   		<input type="hidden" id="departmentID" name="departmentID" value="${personInfoPo.departmentID }" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li>
						</c:if>  
						   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
      	                   </c:if>
						  </TD>
			               <TD width="7%" height="26" class="table_body">查询日期</TD>
			               <TD class="table_none" width="24%">
                           <li class="horizontal_onlyRight">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
						       
						   </li>
						   <!-- <li class="horizontal_onlyRight">
					  				  <INPUT class=button_bak icon="icon-zoom" type=button value="今天" onClick="today('startTime','endTime')"></li>
						   <li class="horizontal_onlyRight">
                            <INPUT class=button_bak icon="icon-zoom" type=button value="当月" onClick="currtMonth('startTime','endTime')"></li>
			                -->
			               </TD>
			               <TD width="7%" class="table_body">查询分类</TD>
			               <TD class="table_none" width="15%">
			               	   <select id="searchtype" name="searchtype" onchange="changeSelect(this)">
	      		                 <option value="">----请选择----</option>
					             <option value="1">按商品类别</option>
					             <option value="2">按制造商</option>
					             <option value="3">按品种</option>
					             <option value="4">按商品明细</option>
	      	                   </select>
			               </TD>
                        </TR>
                        <TR group="type" id="category" style="display: none;">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
							   <select sid="1" id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
                        </TR>
                        <TR group="type" id="supplier" style="display: none;">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="2" id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none" colspan="3">
			               <li class="horizontal_onlyRight">
						   		<input sid="2" class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="2" type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
                        </TR>
                        <TR group="type" id="brand" style="display: none;">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="3" id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input sid="3" class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="3" type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input sid="3" class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input sid="3" type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                        </TR>
                        <TR group="type" id="goods" style="display: none;">
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="4" id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input sid="4" class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="4" type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input sid="4" class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input sid="4" type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                        </TR>
                        <tr group="type" id="goods" style="display: none;">
                           <TD class="table_body">商品代码</TD>
			               <TD class="table_none"><input sid="4" type="text" class="text_input160" maxlength="20" id="goodsCode" name="goodsCode"/></TD>
						   <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none" colspan="3"><input sid="4" type="text" class="text_input160" maxlength="20" id="goodsName" name="goodsName"/></TD>
                        </tr>
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
					<table width="100%">
						<tr height="50px">
							<div class="reportHelp">
								1.用&nbsp;&nbsp;&nbsp;途：根据查询条件对门店的上年、本年的销售商品及增减情况和增减比率进行统计。<br/>
								2.查询条件：部门名称（文本域显示可选择）、日期（时间段  左文本框为日期下限、有文本框为日期上限）<br/>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								查询分类（可通过此查询条件对查询内容进行分类）、商品类别（按类别查询商品，如镜架、镜片等）、制造商（指定查询内容制造商）<br/>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								品种（指定查询内容品种）、商品代码（可根据代码段进行模糊查询）、商品名称（可根据名称段进行模糊查询）
								</div>
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

