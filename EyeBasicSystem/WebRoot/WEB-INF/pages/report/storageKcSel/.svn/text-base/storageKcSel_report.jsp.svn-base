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
        var typeID=document.getElementById("typeID").value;

		if(typeID==""){
			alert('请查看类型!');
			return false;
		};
        
        
		var supplierID = document.getElementById("supplierID").value;
		var goodscategoryID = document.getElementById("goodscategoryID").value;
		var ShopCode=document.getElementById("departmentID").value;
		var brandID=document.getElementById("brandID").value;
        var permission=document.getElementById("permission").value;
        var typeID=document.getElementById("typeID").value;
        //Add by ZK 获取 品种名称 查询值 begin
        var brandNameStr = EncodeUtf8(document.getElementById("brandNameStr").value);
        var warsehouseName = EncodeUtf8(document.getElementById("ds").value);
        var viewTypeName = EncodeUtf8(getSelectText("typeID"));
        var goodsCategoryName = EncodeUtf8(getSelectText("goodscategoryID"));
        var supplierName = EncodeUtf8(document.getElementById("supplierName").value);
        var brandName = EncodeUtf8(document.getElementById("brandName").value);
        //Add by ZK 获取 品种名称 查询值 end
        
		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});
        var DataURL="";
		  if(typeID=='1'){
			  DataURL = "report.action?reportlet=storage_kccpsljetj.cpt&__bypagesize__=false&goodsCategoryID="+goodscategoryID
			  		+"&stockId="+ShopCode+"&supplierID="+supplierID+"&goodsID="+brandID+"&permission="+permission
			  		+"&brandNameStr="+brandNameStr+"&warsehouseName="+warsehouseName+"&viewTypeName="+viewTypeName
			        +"&goodsCategoryName="+goodsCategoryName+"&supplierName="+supplierName+"&brandName="+brandName+'&isShow='+isShow;
			  document.getElementById('popupTitle').innerHTML="【库存产品数量成本统计】";
		  }else if(typeID=='2') {
			  DataURL = "report.action?reportlet=storage_kccpsljetjpp.cpt&__bypagesize__=false&goodsCategoryID="+goodscategoryID
			  		+"&stockId="+ShopCode+"&supplierID="+supplierID+"&goodsID="+brandID
			  		+"&permission="+permission+"&brandNameStr="+brandNameStr+"&warsehouseName="+warsehouseName
			  		+"&viewTypeName="+viewTypeName+"&goodsCategoryName="+goodsCategoryName
			  		+"&supplierName="+supplierName+"&brandName="+brandName+'&isShow='+isShow;			   
			  document.getElementById('popupTitle').innerHTML="【库存产品数量成本统计】";
		  }else{
			  DataURL = "report.action?reportlet=storage_kccpsljetjtype.cpt&__bypagesize__=false&goodsCategoryID="+goodscategoryID
		  		+"&stockId="+ShopCode+"&supplierID="+supplierID+"&goodsID="+brandID
		  		+"&permission="+permission+"&brandNameStr="+brandNameStr+"&warsehouseName="+warsehouseName
		  		+"&viewTypeName="+viewTypeName+"&goodsCategoryName="+goodsCategoryName
		  		+"&supplierName="+supplierName+"&brandName="+brandName+'&isShow='+isShow;			   
		     document.getElementById('popupTitle').innerHTML="【库存产品数量成本统计】";
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
		document.getElementById("supplierID").value = "";
		document.getElementById("supplierName").value = "";
		document.getElementById("typeID").value = "";

		$("input[type=checkbox]").attr("checked",""),
		document.getElementById("bdpdepartmentname").value = "";
		document.getElementById("ds").value = "";
		document.getElementById("departmentID").value = "";
		document.getElementById("goodscategoryID").value = "";
		document.getElementById("brandName").value = "";
		document.getElementById("brandID").value = "";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodscategoryID= document.all.goodscategoryID.value;
		
	    if(goodscategoryID==''){
	      alert('请选择商品类别');
	      return false;
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
	function getSelectText(selectId, setEqualsNullValue){
		if(!selectId) {
			alert("未找到select标签");
		} else {
			var selectObj = document.getElementById(selectId);
			var userSelectedIndex = selectObj.selectedIndex;
			var selectText = selectObj.options[userSelectedIndex].text
			if(!setEqualsNullValue) {
				if(selectText == "----请选择----") {
					selectText = "";
				}
			} else {
				if(selectText == setEqualsNullValue){
					selectText == "";
				}
			}
			var endIndex = selectText.indexOf("￥");
			if(endIndex > 0) {
				selectText = selectText.substring(0, endIndex-1);
			}
			return selectText;
		}
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="permission" name="permission" value="${permissionPo.keyb}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>日常业务类报表</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：库存产品数量成本统计表</TD>
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
						   <TD width="8%" height="26" class="table_body">查看类型</TD>
			               <TD class="table_none" >
							   <select id="typeID" name="typeID">
	      		                 <option value="">----请选择----</option>
	      		                   <option value="3">按商品类型</option>
					               <option value="1">按品种</option>
					               <option value="2">按制造商</option>
					               
	      	                   </select>
			               </TD>
			                                          <TD height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
							   <select id="goodscategoryID" name="goodscategoryID">
	      		                 <option value="">----请选择----</option>
	      		                 <s:iterator value="goodsCategorys">
					               <option value="${bgcid}">${bgcgoodscategoryname}</option>
		     	                 </s:iterator>
	      	                   </select>
	      	               </TD>
                        </TR>
                        <TR>

						   <TD width="8%" height="26" class="table_body">制造商</TD>
			               <TD width="24%" class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD width="8%" height="26" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  	<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openBrand();">
							   </li>
			               </TD>
			               <!-- Add by ZK 添加 品种名称 查询(手动输入) begin -->
			               <TD width="8%" height="26" class="table_body">品种名称</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandNameStr" name="brandNameStr" value="${requestScope.brandNameStr}" maxlength="32" >
							   </li>
			               </TD>
			               <!-- Add by ZK 添加 品种名称 查询(手动输入) end -->
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
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

