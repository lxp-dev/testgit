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
	    $('#ishow').attr("checked",true);
	    $('#suQuery').hide();
	    $('#suQuery1').hide();
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
		var chacktype=$('input[name=queryType]:checked').val();
		var goodscategoryID = document.getElementById("goodscategoryID").value;
		var shopCode=document.getElementById("departmentID").value;
		var shopCodeName=$("#ds").val();
		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});
		if(chacktype==1){
		var DataURL = "report.action?reportlet=sales_anydatesalescostprice.cpt&beginDate="+BeginDate+"&enddate="+End+"&goodsCategoryID="+goodscategoryID+"&shopCode="+shopCode+"&shopCodeName="+EncodeUtf8(shopCodeName)+"&supplierID="+$('#supplierID').val()+"&supplierName="+EncodeUtf8($('#supplierName').val())+"&brandID="+$('#brandID').val()+"&brandName="+EncodeUtf8($('#brandName').val())+"&goodsID="+$('#goodsCode').val()+"&goodsName="+EncodeUtf8($('#goodsName').val())+'&isShow='+isShow;
		}
		if(chacktype==2){
			var DataURL = "report.action?reportlet=sales_anydatesalescostpricesupplier.cpt&beginDate="+BeginDate+"&enddate="+End+"&goodsCategoryID="+goodscategoryID+"&shopCode="+shopCode+"&shopCodeName="+EncodeUtf8(shopCodeName)+"&supplierID="+$('#supplierID').val()+"&supplierName="+EncodeUtf8($('#supplierName').val())+"&brandID="+$('#brandID').val()+"&brandName="+EncodeUtf8($('#brandName').val())+"&goodsID="+$('#goodsCode').val()+"&goodsName="+EncodeUtf8($('#goodsName').val())+'&isShow='+isShow;
		}
		if(chacktype==3){
			var DataURL = "report.action?reportlet=sales_anydatesalescostpricebrand.cpt&beginDate="+BeginDate+"&enddate="+End+"&goodsCategoryID="+goodscategoryID+"&shopCode="+shopCode+"&shopCodeName="+EncodeUtf8(shopCodeName)+"&supplierID="+$('#supplierID').val()+"&supplierName="+EncodeUtf8($('#supplierName').val())+"&brandID="+$('#brandID').val()+"&brandName="+EncodeUtf8($('#brandName').val())+"&goodsID="+$('#goodsCode').val()+"&goodsName="+EncodeUtf8($('#goodsName').val())+'&isShow='+isShow;
		}
		if(chacktype==4){
			var DataURL = "report.action?reportlet=sales_anydatesalescostpricegoods.cpt&beginDate="+BeginDate+"&enddate="+End+"&goodsCategoryID="+goodscategoryID+"&shopCode="+shopCode+"&shopCodeName="+EncodeUtf8(shopCodeName)+"&supplierID="+$('#supplierID').val()+"&supplierName="+EncodeUtf8($('#supplierName').val())+"&brandID="+$('#brandID').val()+"&brandName="+EncodeUtf8($('#brandName').val())+"&goodsID="+$('#goodsCode').val()+"&goodsName="+EncodeUtf8($('#goodsName').val())+'&isShow='+isShow;
		}
		document.getElementById('popupTitle').innerHTML="【任意时段产品销售成本统计】";

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}

	}

	
	
	function clean(){
		goodsForm.reset();
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		$("input[type=checkbox]").attr("checked",""),
		document.getElementById("bdpdepartmentname").value = "";
		document.getElementById("ds").value = "";
		document.getElementById("departmentID").value = "";
		document.getElementById("goodscategoryID").value = "";
		$('#supplierName').val('');
		$('#goodsCode').val('');
		$('#goodsName').val('');
		$('#supplierID').val('');
		$('#brandName').val('');
		$('#brandID').val('');
	}
	
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	function showterm(){
		var category = $("select[id=goodscategoryID]").val();
		if(category == '' || category == '2' || category == '5' || category == '7' || category == '8'|| category == '9'){
			$("tr[id=jp]").hide();
			$("#isCustomize").val('');

		}else if(category == '3' || category == '4'){
			$("tr[id=jp]").show();
		}

	}
	$(document).ready(function(){
		$("tr[id=jp]").hide();
		$("#isCustomize").val('');
	});	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){

		var goodscategoryID= document.all.goodscategoryID.value;
		
	    if(goodscategoryID==''){
	      alert('请选择商品类别');
	      return false;
	    }
	    
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
		
	}
	function openBrand(){
		var goodscategoryID= document.all.goodscategoryID.value;
		var supplierID=document.getElementById('supplierID').value;
		
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	function showQuery(thiz){
		if($(thiz).val()=='1'){
			$('#suQuery').hide();
			$('#suQuery1').hide();
			$('#supplierName').val('');
			$('#goodsCode').val('');
			$('#goodsName').val('');
			$('#supplierID').val('');
			$('#brandName').val('');
			$('#brandID').val('');
			$('#goodscategoryID').val('');
		}
		if($(thiz).val()=='2'){
			$('#suQuery').show();
			$('#sut').hide();
			$('#sud').hide();
			$('#sus1t').hide();
			$('#sus1d').hide();
			$('#sus2t').hide();
			$('#sus2d').hide();
			$('#supplierName').val('');
			$('#goodsCode').val('');
			$('#goodsName').val('');
			$('#supplierID').val('');
			$('#brandName').val('');
			$('#brandID').val('');
			$('#goodscategoryID').val('');
		}
		if($(thiz).val()=='3'){
			$('#suQuery').show();
			$('#sut').show();
			$('#sud').show();
			$('#sus1t').hide();
			$('#sus1d').hide();
			$('#sus2t').hide();
			$('#sus2d').hide();
			$('#supplierName').val('');
			$('#goodsCode').val('');
			$('#goodsName').val('');
			$('#supplierID').val('');
			$('#brandName').val('');
			$('#brandID').val('');
			$('#goodscategoryID').val('');
		}
		if($(thiz).val()=='4'){
			$('#suQuery').show();
			$('#suQuery1').show();

			$('#sut').show();
			$('#sud').show();
			$('#sus1t').show();
			$('#sus1d').show();
			$('#sus2t').show();
			$('#sus2d').show();
			$('#supplierName').val('');
			$('#goodsCode').val('');
			$('#goodsName').val('');
			$('#supplierID').val('');
			$('#brandName').val('');
			$('#brandID').val('');
			$('#goodscategoryID').val('');
		}
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="permission" value="${permissionPo.keyc}">
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
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：任意时段产品销售成本统计</TD>
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
					  	   <TD width="10%" height="30" class="table_body">销售门店</TD>
			               <TD class="table_none" width="23%">
			               
			               <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
		               <c:if test="${person.departmenttype!=1}">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" type="hidden" value="${personInfoPo.bdpdepartmentname }"  />
						   		<textarea class="text_input200" id="ds"  name="ds" value=""   style='height:50px' readonly="readonly" >${personInfoPo.bdpdepartmentname}</textarea>
						   		
						   		<input type="hidden" id="departmentID" name="departmentID" value="${personInfoPo.departmentID }" />
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" name=ctl00$PageBody$Button1 onClick="openDepartment();"></li>
						</c:if>  
						   <c:if test="${person.departmenttype==1}">
                            ${person.bdpdepartmentname}<input type="hidden" id="departmentID" value="${person.departmentID}" name="departmentID"/>
                            <input type="hidden" id="ds" name="ds" value="${person.bdpdepartmentname}">
      	                   </c:if>
						  </TD>
						   <TD width="10%" height="26" class="table_body">商品类别</TD>
			               <TD width="23%" class="table_none">
							   <select id="goodscategoryID" name="goodscategoryID" onchange="showterm();">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
			               </TD>
			               <TD class="table_body" width="10%" >查询日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
                        </TR>
                        <tr>
                        	 <TD width="8%" height="26" class="table_body">查询方式</TD>
			               <TD width="24%" class="table_none" colspan="5">&nbsp;
			               	<input type="radio" name="queryType" id="ishow" onclick="showQuery(this);"  value="1">商品类别&nbsp;&nbsp;
			               	<input type="radio" name="queryType" onclick="showQuery(this);"  value="2">制造商&nbsp;&nbsp;
			               	<input type="radio" name="queryType" onclick="showQuery(this);"  value="3">品种&nbsp;&nbsp;
			               	<input type="radio" name="queryType" onclick="showQuery(this);"  value="4">商品&nbsp;&nbsp;
			               </TD>
                        </tr>
                        	
                        <TR id="suQuery">
						   <TD width="8%" height="26" class="table_body">制造商</TD>
			               <TD width="24%" class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			                <TD width="8%" height="26" class="table_body"><span id="sut">商品品种</span>&nbsp;</TD>
			               	<TD class="table_none" ><span id="sud">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li></span>&nbsp;
			               </TD>
			               <TD class="table_body"><span id="sus1t" align="center">商品代码</span>&nbsp;</TD>
			               <TD class="table_none"><span id="sus1d" align="center"><input sid="4" type="text" class="text_input160" maxlength="20" id="goodsCode" name="goodsCode"/></span>&nbsp;</TD>
			               </TR>
			               <TR id="suQuery1" >
			               	<TD height="26"  class="table_body"><span id="sus2t" >商品名称</span>&nbsp;</TD>
			               <TD class="table_none" colspan="5"><span id="sus2d"><input sid="4" type="text" class="text_input160" maxlength="20" id="goodsName" name="goodsName"/></span>&nbsp;</TD>
			               </TR>
                        <TR>
			               <TD class="table_body" height="26">是否显示查询条件</TD>
			               <TD class="table_none" colspan="5">
                               &nbsp;&nbsp;<input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
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

