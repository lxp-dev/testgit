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

		if(document.getElementById("billType").value==""){
			alert('请选择单据类型!');
			return false;
		};
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
		if(document.getElementById("linkType").value==""){
			alert('请选择链接查看类型!');
			return false;
		};
		var supplierID = document.getElementById("supplierID").value;
		var goodscategoryID = document.getElementById("goodscategoryID").value;
		var ShopCode=document.getElementById("departmentID").value;
		var brandID=document.getElementById("brandID").value;
		var billType=document.getElementById("billType").value;
        var permission=document.getElementById("permission").value;
        var linkType=document.getElementById("linkType").value;
        var brandName=$('#brandName').val();
		var storeName=$('#ds').val();
		var supplierName=$('#supplierName').val();
        var isCustomize='';
        if(goodscategoryID=='3'||goodscategoryID=='4'){
        	isCustomize=document.getElementById("isCustomize").value; 
        }
		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});
		//alert(permission);
		if(permission=='1'){
			if(linkType=='0'){
				var DataURL = "report.action?reportlet=storage_stroageBrandNumOrPrice.cpt&__bypagesize__=false&begindate="+BeginDate+"&enddate="+End+"&categoryid="+goodscategoryID+"&stockid="+ShopCode+"&supplierid="+supplierID+"&brandid="+brandID+
				  "&billType="+billType+"&isCustomize="+isCustomize+"&brandName="+EncodeUtf8(brandName)+"&storeName="+EncodeUtf8(storeName)+"&supplierName="+EncodeUtf8(supplierName)+'&isShow='+isShow;
			}else if(linkType=='1'){
				var DataURL = "report.action?reportlet=storage_stroageBrandNumOrPrice2.cpt&__bypagesize__=false&begindate="+BeginDate+"&enddate="+End+"&categoryid="+goodscategoryID+"&stockid="+ShopCode+"&supplierid="+supplierID+"&brandid="+brandID+
				  "&billType="+billType+"&isCustomize="+isCustomize+"&brandName="+EncodeUtf8(brandName)+"&storeName="+EncodeUtf8(storeName)+"&supplierName="+EncodeUtf8(supplierName)+'&isShow='+isShow;
			}
		document.getElementById('popupTitle').innerHTML="【产品出入库数量及金额统计】";
		}else{
			if(linkType=='0'){
		        var DataURL = "report.action?reportlet=storage_stroageBrandNum.cpt&__bypagesize__=false&begindate="+BeginDate+"&enddate="+End+"&categoryid="+goodscategoryID+"&stockid="+ShopCode+"&supplierid="+supplierID+"&brandid="+brandID+
			          "&billType="+billType+"&isCustomize="+isCustomize+"&brandName="+EncodeUtf8(brandName)+"&storeName="+EncodeUtf8(storeName)+"&supplierName="+EncodeUtf8(supplierName)+'&isShow='+isShow;
			}else if(linkType=='1'){
				var DataURL = "report.action?reportlet=storage_stroageBrandNum2.cpt&__bypagesize__=false&begindate="+BeginDate+"&enddate="+End+"&categoryid="+goodscategoryID+"&stockid="+ShopCode+"&supplierid="+supplierID+"&brandid="+brandID+
		          "&billType="+billType+"&isCustomize="+isCustomize+"&brandName="+EncodeUtf8(brandName)+"&storeName="+EncodeUtf8(storeName)+"&supplierName="+EncodeUtf8(supplierName)+'&isShow='+isShow;
		    }
		document.getElementById('popupTitle').innerHTML="【产品出入库数量统计】";
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			openWindowForReport(DataURL); 
		}

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
	
	function clean(){
		goodsForm.reset();
        if(document.getElementById("goodscategoryID").value=='3'||document.getElementById("goodscategoryID").value=='4'){
           document.getElementById("isCustomize").value=''; 
        }
		$("tr[id=jp]").hide();
		document.getElementById('billType').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById("supplierID").value = "";
		document.getElementById("supplierName").value = "";
		
		$("input[type=checkbox]").attr("checked",""),
		document.getElementById("bdpdepartmentname").value = "";
		document.getElementById("ds").value = "";
		document.getElementById("departmentID").value = "";
		document.getElementById("goodscategoryID").value = "";
		document.getElementById("brandName").value = "";
		document.getElementById("brandID").value = "";
		document.getElementById("linkType").value = "";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodscategoryID= $('select[id=goodscategoryID]').val();
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
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" id="permission" name="permission" value="${permissionPo.keyc}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>日常业务类报表</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：产品出入库数量及金额统计</TD>
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20"></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	   <TD width="10%" height="30" class="table_body">仓位名称</TD>
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
                            <input type="hidden" id="ds" value="${person.bdpdepartmentname}" name="departmentName"/>
      	                   </c:if>
						  </TD>
						   <TD width="10%" height="26" class="table_body">单据类型</TD>
			               <TD width="23%" class="table_none">
							   <select id="billType" name="billType">
							   	 <option value="">----请选择----</option>
	      		                 <option value="pin">采购收货单</option>
	      		                 <option value="cpi">委外收货单</option>
	      		                 <option value="pou">退货单</option>
	      		                 <option value="SCI">盘盈单</option>
	      		                 <option value="SCO">盘亏单</option>
	      		                 <option value="all">调拨单</option>
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
                        <TR>
                           <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select id="goodscategoryID" name="goodscategoryID" onchange="showterm();">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD  height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
                        </TR>
                       <tr >
                        	<TD height="26" class="table_body">链接查看方式选择</TD>
			                <TD class="table_none">
                            	<select id="linkType" name="linkType"}>
      		                 		<option value="">----请选择----</option>
      		                 		<option value="0">按产品明细优先查看</option>
      		                 		<option value="1">按单据优先查看</option>        		                 		
      	                   		</select>
			                </TD>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" colspan="3">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </tr>
                        <tr id="jp">
                        	<TD height="26" class="table_body">镜片分类</TD>
			                <TD class="table_none" colspan="5">
                            	<select id="isCustomize" name="isCustomize"}>
      		                 		<option value="">----请选择----</option>
      		                 		<option value="0">成品片</option>
      		                 		<option value="D">订做片</option>      		                 		
      	                   		</select>
			                </TD>
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

