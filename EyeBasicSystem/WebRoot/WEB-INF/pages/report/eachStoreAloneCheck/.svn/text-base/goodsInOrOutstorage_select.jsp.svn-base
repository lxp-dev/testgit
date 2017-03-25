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

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        }); 
        if($('#collectID').val()==''){
        	$('#trshow1').hide();
			$('#trshow2').hide();
			$('#trshow3').hide();
            $('#trshow4').hide();
            $('#trshow5').hide();
        }
	}); 
	function gl(valuz){
		if(valuz){
			return valuz;
		}else{
			return '';
		}
	}
	function search(){
		if(checkForm(goodsForm)){
			var ShopCode = $('#departmentID').val();
			var collectID = $('#collectID').val();
			var BeginDate = document.getElementById("startTime").value;
			var End = document.getElementById("endTime").value;
			var departmentName = $('#bdpdepartmentname').val();
			var goodsID =gl($("input[id=goodsID"+collectID+"]").val());
			var goodsName = gl($("input[id=goodsName"+collectID+"]").val());
			var supplierID=gl($("input[id=supplierID"+collectID+"]").val());
			var supplierName=gl($("input[id=supplierName"+collectID+"]").val());
			var brandID=gl($("input[id=brandID"+collectID+"]").val());
			var brandName=gl($("input[id=brandName"+collectID+"]").val());
			var categoryID=gl($("select[id=goodscategoryID"+collectID+"]").val());
			var isShow = "";
			$("input[id=isShow]").each(function() {
				if($(this).attr("checked") == true) {
					isShow = $(this).val();
				}
			});
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
			if(ShopCode==''){
				ShopCode='suoyou'
			}
			var DataURL ="";
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				DataURL = "report.action?reportlet=L_GoodsInOrOutStorage"+collectID+".cpt&shopCode="+ShopCode+"&bgnDate="+BeginDate+"&endDate="+End+"&goodsID="+goodsID+"&departmentName="+EncodeUtf8(departmentName)+"&goodsName="+EncodeUtf8(goodsName)+'&isShow='+isShow+"&goodsCategoryID="+categoryID+"&supplierID="+supplierID+"&brandID="+brandID; 
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				document.getElementById('popupTitle').innerHTML="【商品进销存表】";
			}else{
				DataURL = "report.action?reportlet=L_GoodsInOrOutStorage"+collectID+".cpt&__bypagesize__=false&shopCode="+ShopCode+"&bgnDate="+BeginDate+"&endDate="+End+"&goodsID="+goodsID+"&departmentName="+EncodeUtf8(departmentName)+"&goodsName="+EncodeUtf8(goodsName)+'&isShow='+isShow+"&goodsCategoryID="+categoryID+"&supplierID="+supplierID+"&brandID="+brandID; 
				openWindowForReport(DataURL); 
			}
		}		
	}
	
	function clean(){
		goodsForm.reset();	
		 if($('#collectID').val()==''){
	            $('#trshow1').hide();
	            $('#trshow2').hide();
	            $('#trshow3').hide();
	            $('#trshow4').hide();
	            $('#trshow5').hide();
	        }
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var collectID = $('#collectID').val();
		var goodscategoryID=$("select[id=goodscategoryID"+collectID+"]").val();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(!goodscategoryID){
			alert("请选择商品类别！");
			return;
		}
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
		var collectID = $('#collectID').val();
		$("input[id=supplierID"+collectID+"]").val(json.id);
		$("input[id=supplierName"+collectID+"]").val(json.value);
		
	}
	function openBrand(){
		var collectID = $('#collectID').val();
		var goodscategoryID=$("select[id=goodscategoryID"+collectID+"]").val();
		var supplierID=$("input[id=supplierID"+collectID+"]").val();
		
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
		var collectID = $('#collectID').val();
		$("input[id=brandID"+collectID+"]").val(json.brandID);
		$("input[id=brandName"+collectID+"]").val(json.brandName);
	}
	//商品id（挂起功能） begin
	function openGoods(){
		var collectID = $('#collectID').val();
		var goodscategoryID=$("select[id=goodscategoryID"+collectID+"]").val();
		var supplierID=$('input[id=supplierID]').val();
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsReportSel.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsReportSel.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openGoodsValues(json){
		$('input[id=goodsID]').val(json.goodsid);
	}
	//商品id（挂起功能） end
	
	
	function isShowTr(thiz){
		if($(thiz).val()=='1'){
			$('#trshow1').show();
			$('#trshow2').hide();
			$('#trshow3').hide();
            $('#trshow4').hide();
            $('#trshow5').hide();
		}
		if($(thiz).val()=='2'){
			$('#trshow1').hide();
			$('#trshow2').show();
			$('#trshow3').hide();
            $('#trshow4').hide();
            $('#trshow5').hide();
		}
		if($(thiz).val()=='3'){
			$('#trshow1').hide();
			$('#trshow2').hide();
			$('#trshow3').show();
            $('#trshow4').hide();
            $('#trshow5').hide();
		}
		if($(thiz).val()=='4'){
			$('#trshow1').hide();
			$('#trshow2').hide();
			$('#trshow3').hide();
            $('#trshow4').show();
            $('#trshow5').show();
		}
		if($('#collectID').val()==''){
			$('#trshow1').hide();
			$('#trshow2').hide();
			$('#trshow3').hide();
            $('#trshow4').hide();
            $('#trshow5').hide();
        }
	     for(var i=1;i<=$(thiz).val();i++){
	    	 	$("input[id=goodsID"+i+"]").val('');
				$("input[id=goodsName"+i+"]").val('');
				$("input[id=supplierID"+i+"]").val('');
				$("input[id=supplierName"+i+"]").val('');
				$("input[id=brandID"+i+"]").val('');
				$("input[id=brandName"+i+"]").val('');
				$("select[id=goodscategoryID"+i+"]").val('');
	     }
	}
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentInOrOutStorageOpen.action?isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentInOrOutStorageOpen.action?isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}

	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(json){
		document.getElementById('departmentID').value = json.id;
		document.getElementById('bdpdepartmentname').value = json.value;
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>${permissionPo.moduleName}</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品进销存表</TD>
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
                      	<TR >
						   <TD width="10%" height="26" class="table_body">部门名称</TD>
			               <TD class="table_none" width="20%">
						  		<%--<select id="departmentID" name="departmentID" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择部门！'}]">
                                       <option value="">-------------请选择-------------</option>
                                       <s:iterator value="departmentsList">
                                           <option value="${bdpdepartmentid }">${bdpdepartmentname}</option>
                                       </s:iterator>
                                 </select>--%>
                                 <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
                           <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" type="hidden" value="${personInfoPo.bdpdepartmentname }"  />
						   		<textarea class="text_input200" id="ds"  name="ds" value=""  style='height:50px;' readonly="readonly" >${personInfoPo.bdpdepartmentname}</textarea>
						   		<input type="hidden" id="departmentID" name="departmentID" value="${personInfoPo.departmentID }" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li>
			               </TD>
			               <TD class="table_body">查询日期</TD>
			               <TD class="table_none" width="36%">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
			               
			               <TD class="table_body">汇总方式</TD>
			               <TD class="table_none">
			                 <select id="collectID" name="collectID" onchange="isShowTr(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择汇总方式！'}]">
			                        <option value="">----请选择----</option>
			                        <option value="1">商品类型</option>
			                        <option value="2">制造商</option>
			                        <option value="3">商品品种</option>
			                        <option value="4">商品明细</option>
							 </select>
			               </TD>
			               
                        </TR>
                        <tr id="trshow1">
                        	<TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
							   <select sid="1" id="goodscategoryID1" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
                        </tr>
                        <tr id="trshow2">
                        	<TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="2" id="goodscategoryID2" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
	      	               <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none" colspan="3">
			               <li class="horizontal_onlyRight">
						   		<input sid="2" class="text_input160" type="text"  id="supplierName2" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="2" type="hidden" id="supplierID2" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               
                        </tr>
                        <tr id="trshow3">
                        	<TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="3" id="goodscategoryID3" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
	      	               <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input sid="3" class="text_input160" type="text"  id="supplierName3" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="3" type="hidden" id="supplierID3" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input sid="3" class="text_input160" type="text"  id="brandName3" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input sid="3" type="hidden" id="brandID3" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                        </tr>
                        <tr id="trshow4">
                        	<TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select sid="4" id="goodscategoryID4" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
	      	               <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input sid="4" class="text_input160" type="text"  id="supplierName4" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input sid="4" type="hidden" id="supplierID4" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input sid="4" class="text_input160" type="text"  id="brandName4" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input sid="4" type="hidden" id="brandID4" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                        </tr>
                        <TR id="trshow5">
                        
						   <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none"><li class="horizontal_onlyRight">
                               <input sid="4" type="text" id="goodsID4" class="text_input160" name="goodsID" maxlength="30"/>
                               </li>
                               <%--<li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openGoods();">
							   </li>--%>
			               </TD>
			               
			               <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none" colspan="3">
                               <input sid="4" type="text" id="goodsName4" class="text_input160" name="goodsName" maxlength="100"/>
			               </TD>
			               
                        </TR>
                        
                        <TR>
			               <TD class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </TR>
                        
                      </TBODY>
                    </TABLE>
            <c:if test="${permissionPo.keya eq '1'}">        
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                                <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
			</c:if>		
			<c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">												
1.查询条件：部门名称(必选)、查询日期(必选)、汇总方式、商品代码、商品名称	<br/>										
2.报表分别以商品类别、制造商、品种及商品为条件对数量、金额进行合计	<br/>												
3.查询部门：各个门店、配送部、所有部门	<br/>				
4.汇总方式：商品类别、品种、制造商、商品明细<br/>											
&nbsp;&nbsp;&nbsp;汇总方式选择商品类别时，报表根据系统中商品类别进行统计汇总<br/>								
&nbsp;&nbsp;&nbsp;汇总方式选择制造商时，报表根据系统中的所有制造商、商品类型进行统计汇总	<br/>									
&nbsp;&nbsp;&nbsp;汇总方式选择品种时，报表根据系统中的所有商品品种、制造商、商品类型进行统计汇总<br/>											
&nbsp;&nbsp;&nbsp;汇总方式选择商品时，报表根据系统中的商品进行统计（有每个商品的数据，并且根据品种合计、制造商合计、类别合计、总合计进行分组统计显示）<br/>											
5.此报表在成本计算之后查看<br/>												
6.报表中所有的金额取不含税的金额<br/>										
7.当查询门店时，报表中收入部分计算公式为：（正调拨 - 负调拨），发出部分计算公式为：（销售出库 + 盘亏 - 盘盈）<br/>												
&nbsp;&nbsp;&nbsp;当查询配送部时，报表中收入部分计算公式为：（采收收货 + 委外收货 - 采购退货），发出部分计算公式为：（销售出库 + 盘亏 - 盘盈）<br/>

					</div>														
			</c:if>		
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
