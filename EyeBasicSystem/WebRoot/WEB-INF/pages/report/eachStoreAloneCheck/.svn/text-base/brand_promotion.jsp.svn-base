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
		if(checkForm(goodsForm)){
			var bgnDate = $.trim($('#startTime').val());
			var endDate = $.trim($('#endTime').val());
            var shopCode = $.trim($('#departmentID').val());
            var goodsCategoryID = $.trim($('#goodsCategoryID').val());
            var supplierID = $.trim($('#supplierID').val());
            var brandID = $.trim($('#brandID').val());
			var operatorID = $.trim($('#operatorID').val());
			var extractScale = $.trim($('#extractScale').val());
			var goodsname  = $.trim($('#goodsname').val());
			var goodsname1 = $.trim($('#goodsname1').val());
			var goodsname2 = $.trim($('#goodsname2').val());
			var goodsname3 = $.trim($('#goodsname3').val());
			var goodsname4 = $.trim($('#goodsname4').val());
			if (extractScale == ''){
				extractScale = 100;
			}
			var DataURL = '';
			if (operatorID == ''){
				if($("input[id=nametypy]:checked").val() == 'in'){
					DataURL = "report.action?reportlet=treims/sales_cuxiaofei1.cpt&shopCode="+shopCode+"&bgnDate="+bgnDate+"&endDate="+endDate+"&goodsCategoryID="+goodsCategoryID+"&supplierID="+supplierID+"&brandID="+brandID+"&operatorID="+operatorID+"&extractScale="+extractScale+"&goodsname="+EncodeUtf8(goodsname)+"&goodsname1="+EncodeUtf8(goodsname1)+"&goodsname2="+EncodeUtf8(goodsname2)+"&goodsname3="+EncodeUtf8(goodsname3)+"&goodsname4="+EncodeUtf8(goodsname4);
				}else{
					DataURL = "report.action?reportlet=treims/sales_cuxiaofei11.cpt&shopCode="+shopCode+"&bgnDate="+bgnDate+"&endDate="+endDate+"&goodsCategoryID="+goodsCategoryID+"&supplierID="+supplierID+"&brandID="+brandID+"&operatorID="+operatorID+"&extractScale="+extractScale+"&goodsname="+EncodeUtf8(goodsname)+"&goodsname1="+EncodeUtf8(goodsname1)+"&goodsname2="+EncodeUtf8(goodsname2)+"&goodsname3="+EncodeUtf8(goodsname3)+"&goodsname4="+EncodeUtf8(goodsname4);
				}
			}else{
				if($("input[id=nametypy]:checked").val() == 'in'){
					DataURL = "report.action?reportlet=treims/sales_cuxiaofei2.cpt&shopCode="+shopCode+"&bgnDate="+bgnDate+"&endDate="+endDate+"&goodsCategoryID="+goodsCategoryID+"&supplierID="+supplierID+"&brandID="+brandID+"&operatorID="+operatorID+"&extractScale="+extractScale+"&goodsname="+EncodeUtf8(goodsname)+"&goodsname1="+EncodeUtf8(goodsname1)+"&goodsname2="+EncodeUtf8(goodsname2)+"&goodsname3="+EncodeUtf8(goodsname3)+"&goodsname4="+EncodeUtf8(goodsname4);
				}else{
					DataURL = "report.action?reportlet=treims/sales_cuxiaofei22.cpt&shopCode="+shopCode+"&bgnDate="+bgnDate+"&endDate="+endDate+"&goodsCategoryID="+goodsCategoryID+"&supplierID="+supplierID+"&brandID="+brandID+"&operatorID="+operatorID+"&extractScale="+extractScale+"&goodsname="+EncodeUtf8(goodsname)+"&goodsname1="+EncodeUtf8(goodsname1)+"&goodsname2="+EncodeUtf8(goodsname2)+"&goodsname3="+EncodeUtf8(goodsname3)+"&goodsname4="+EncodeUtf8(goodsname4);
				}
			}
	        window.open (DataURL,'商品促销费用表', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes'); 
		}
	}
	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var goodsCategoryID = $.trim($('#goodsCategoryID').val());
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodsCategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodsCategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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

    function changeGoodsCategory(){
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
    }

	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>北京同仁报表</TD>
            <TD align="left" width="45%">目前操作功能：商品促销费用表</TD>
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
			               <TD width="13%" height="26" class="table_body">查询日期</TD>
			               <TD class="table_none" width="40%">
                           <li class="horizontal_onlyRight">
                            <input class="text_input80" clean=clean 
				               id="startTime"
						       name="startTime"
						       type="text" 
                               onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取开始查询日期!'}]"/>
						       至
					         <input class="text_input80" clean=clean 
						       id="endTime"
						       name="endTime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取截止查询日期!'}]"/>						       
						       
						   </li>
						   <li class="horizontal_onlyRight">
					  				  <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('startTime','endTime')"></li>
						   <li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_month_0.png" title="当月" onClick="currtMonth('startTime','endTime')"></li>
						    <label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>
                           <TD width="13%" height="26" class="table_body">门店名称</TD>
			               <TD class="table_none" width="40%">
				               <c:if test="${person.departmenttype!=1}">
					               <li class="horizontal_onlyRight">
								   		<input class="text_input200" clean=clean type="text" id="bdpdepartmentname" name="bdpdepartmentname" value="${bdpdepartmentname }" readonly="readonly" />
								   		<input clean=clean  type="hidden" id="departmentID" name="departmentID" value="${departmentID }"/>
								   </li>
								   <li class="horizontal_onlyRight">
								  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openDepartment();"></li>
								</c:if>  
								<c:if test="${person.departmenttype==1}">
		                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
		      	                </c:if>
			               </TD>
                        </TR>
                        <TR>

                           <TD class="table_body"  height="26">商品类别</TD>
			               <TD class="table_none" width="23%">
                            <select id="goodsCategoryID" name="goodsCategoryID" clean=clean onchange="changeGoodsCategory();">
								<option value="">----请选择----</option>
									<s:iterator value="goodsCategorys">
										<option value="${bgcid}">${bgcgoodscategoryname}</option>
									</s:iterator>
							</select>
			               </TD>
			               <TD  height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input200" clean=clean type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}" clean=clean />
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();"></li>
			               </TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" clean=clean type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}" clean=clean/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();"></li>
			               </TD>
                        </TR>
                        <tr>
                           <TD class="table_body" width="13%" height="26" >操作人员</TD>
			               <TD class="table_none">
                            <select id="operatorID" name="operatorID" clean=clean>
								<option value="">----请选择----</option>
								<option value="1">验光师</option>
								<option value="2">营业员</option>
							</select>
			               </TD>
			               <td class="table_body">提取比例</td>
			               <td class="table_none">
				   			<input id="extractScale" class="text_input80" name="extractScale" value="${minprice}" clean=clean maxlength="3" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '请请重新填写提取比例!'}]" />&nbsp;(%)
				   		   </TD>				  				
                        </tr>
                        <td class="table_body">商品名称</td>
			               <td class="table_none" colspan="3">
			                <input type="radio" id="nametypy" name="nametypy" value="in"/>包含
				   			&nbsp;<input type="radio" id="nametypy" name="nametypy" value="notin"/>不包含<br/>
				   			<input class="text_input100" id="goodsname"  name="goodsname"  value="" clean=clean/>
				   			<input class="text_input100" id="goodsname1" name="goodsname1" value="" clean=clean/>
				   			<input class="text_input100" id="goodsname2" name="goodsname2" value="" clean=clean/>
				   			<input class="text_input100" id="goodsname3" name="goodsname3" value="" clean=clean/>
				   			<input class="text_input100" id="goodsname4" name="goodsname4" value="" clean=clean/>
				   		   </TD>
                      </TBODY>
                    </TABLE>
                <c:if test="${permissionPo.keya eq '1'}">    
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
							</td>
						</tr>
					</table>
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

