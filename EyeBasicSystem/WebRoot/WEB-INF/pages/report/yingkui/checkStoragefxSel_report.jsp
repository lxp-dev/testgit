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

		var isShowC = "";
		$("input[id=isShowC]").each(function() {
			if($(this).attr("checked") == true) {
				isShowC = $(this).val();
			}
		});
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
        
		var billID = document.getElementById('billID').value;
		var goodscategoryID = document.getElementById('goodscategoryID').value;
		var stockID = document.getElementById('departmentID').value;
		var isShow=document.getElementById('isShow').value;

		var warsehouseNames = EncodeUtf8(document.getElementById("ds").value);
		var goodsCategoryName = EncodeUtf8(getSelectText("goodscategoryID"));
		
		var DataURL = '';

		DataURL = "report.action?reportlet=storage_checkStoragefxSel.cpt&__bypagesize__=false&stockID="+stockID+"&begindate="+BeginDate+"&enddate="+End+"&goodscategoryID="+goodscategoryID+"&billID="+billID+"&isShow="+isShow+"&warsehouseNames="+warsehouseNames+"&goodsCategoryName="+goodsCategoryName+"&isShowC="+isShowC;

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}

		document.getElementById('popupTitle').innerHTML="【盈亏分析表】";
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
		goodsForm.reset();
		$("input[id=goodsName]").val("");
		$("input[id=goodsid]").val("");
		$("input[id=brandID]").val("");
		$("input[id=brandName]").val("");
		$("input[id=supplierID]").val("");
		$("input[id=supplierName]").val("");
		$("select[id=goodscategoryID]").val("");
		$("input[id=startTime]").val("");
		$("input[id=endTime]").val("");
		$("select[id=searchtype]").val("");
		$("tr[group=type]").hide();
		document.getElementById('bdpdepartmentname').value = "";
		document.getElementById('ds').value = "";
		document.getElementById('departmentID').value = "";
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
		
		$("input[id=goodsName]").val("");
		$("input[id=goodsid]").val("");
		$("input[id=brandID]").val("");
		$("input[id=brandName]").val("");
		$("input[id=supplierID]").val("");
		$("input[id=supplierName]").val("");
		$("select[id=goodscategoryID]").val("");
	}
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initWarehouseOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWarehouseOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【仓位查询】";
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
	/**
	 * 获取select标签Text
	 */
	function getSelectText(selectId){
		if(!selectId) {
			alert("未找到select标签");
		} else {
			var selectObj = document.getElementById(selectId);
			var userSelectedIndex = selectObj.selectedIndex;
			var selectText = selectObj.options[userSelectedIndex].text
			if(userSelectedIndex == 0) {
				selectText = "";
			}
			return selectText;
		}
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" id="isShow" name="isShow" value="${permissionPo.keyc}">
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
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：盈亏分析表</TD>
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
					  	<TR>
					  	   <TD width="10%" height="30" class="table_body">仓位名称</TD>
			               <TD class="table_none" >
			               
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
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}"/>
      	                   </c:if>
						  </TD>
			               <TD class="table_body">查询日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
			               <TD class="table_body" width="8%">商品类别</TD>
			               <TD class="table_none">
							   <select id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategoryList">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
			               </TD>
                        </TR>
					  	<TR>
					  	   <TD width="10%" height="30" class="table_body">盘点单号</TD>
			               <TD class="table_none">
                             <input class="text_input200" type="text" id="billID" name="billID" value="${billID}" />
			               </TD>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="isShowC" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShowC" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
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

