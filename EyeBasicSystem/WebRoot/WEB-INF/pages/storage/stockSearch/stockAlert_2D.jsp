<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
<title>库存预警查询(二维)</title>
</head>

<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

	});

	function search(){
		if ($('#supplierID').val() == ''){
		    alert('请选择制造商!');
		    return;
		}
		if ($('#brandID').val() == ''){
		    alert('请选择商品品种!');
		    return;
		}
		if ($('#warehouseID').val() == ''){
		    alert('请选择仓位!');
		    return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var DataURL = "selStockAlert2D.action?goodsCategoryID="+$('#categoryID').val()+"&supplierID="+$('#supplierID').val()+"&brandID="+$('#brandID').val()+"&warehouseID="+$('#warehouseID').val();	
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}	
		document.getElementById('popupTitle').innerHTML="【库存预警查询(二维)】";
	}

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
        var goodscategoryID=document.getElementById('categoryID').value;
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
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
		var goodscategoryID=document.getElementById('categoryID').value;
	    var supplierID=document.getElementById('supplierID').value;
        if (supplierID == ''){
            alert("请选择制造商!");
            return;
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
    
    function changeCategory(obj){
        $('#goodsCategoryID').val(obj.value);
        document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('supplierID').value = "";
		document.getElementById('supplierName').value = "";
    }
    
    function changeWarehouse(val){
	    if (val=='0'){
            $("select[name=warehouseID] option").each(function(){
                if($(this).val() != ''){
                    $(this).remove();
                }
            });
          <s:iterator value="warehouselist">
				<c:if test="${bwhisclosed == '0'}">
				    $("select[name=warehouseID]").append($("<option value='${bwhid}' ${warehouseID == bwhid ? 'selected=selected' : '' }>${bwhwarehouseName}</option>"));
				</c:if>
	      </s:iterator>

          $('#usingWarehouse').val('0');

	    }else if (val=='1'){
            $("select[name=warehouseID] option").each(function(){
                if($(this).val() != ''){
                    $(this).remove();
                }
            });
          <s:iterator value="warehouselist">
				<c:if test="${bwhisclosed == '1'}">
				    $("select[name=warehouseID]").append($("<option value='${bwhid}' ${warehouseID == bwhid ? 'selected=selected' : '' }>${bwhwarehouseName}</option>"));
				</c:if>
	      </s:iterator>
	      
	       $('#usingWarehouse').val('1');
	    }
	}
</script>
<script>

</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：库存量预警查询</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                        
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initStockAlertSel.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">库存预警查询</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
            
                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif                      
                      UNSELECTABLE="on">库存预警查询(二维)</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>            
         
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
                           <TD width="60" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="categoryID" onchange="changeCategory(this)">
                                <option value="3" ${goodsCategoryID == '3' ? 'selected="selected"' : '' }>框镜成品镜片</option>
                                <option value="4" ${goodsCategoryID == '4' ? 'selected="selected"' : '' }>隐形成品镜片</option>
                            </select>
                            <label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input200" name="supplierName" value="${supplierName}" readonly="readonly"/>
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" />
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn  title="选 择" onclick="openSupplier()"></li>
						  				<label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onclick="openBrand();"></li>
						  <label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>
                        </TR>
                        <TR>			               
						   <TD height="26" class="table_body">仓位名称</TD>
			               <TD class="table_none" colspan="5">
                           <input type="hidden" id="usingWarehouse" name="usingWarehouse" value="${usingWarehouse}">
      	                   <input type="radio" name="radioBtn"  onclick="changeWarehouse('0')" ${usingWarehouse == '0' ? 'checked' : '' }>启用仓
      	                   <input type="radio" name="radioBtn" onclick="changeWarehouse('1')" ${usingWarehouse == '1' ? 'checked' : '' }>停用仓
			               
			               <select id="warehouseID" name="warehouseID">
                               <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">
				               <c:if test="${bwhisclosed == usingWarehouse}">
				                   <option value="${bwhid}" ${warehouseID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
				               </c:if>
	     	                 </s:iterator>
      	                   </select>
      	                   <label style="color:red;">&nbsp;*&nbsp;</label> 
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td align="left">
							   <c:if test="${permissionPo.keya == '1'}">
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitBtn" title='查询' onclick="search();">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="goodsForm.reset();">
							   </c:if>	
							</td>
						</tr>
					</table>
                  </DIV>
                </DIV>
                
                <div class="reportHelp">
                                          二维表中单元格背景颜色说明：</br>
                1.红色：【小于等于红色预警】</br>
                2.紫色：【大于红色预警并小于等于库存量下限】</br>
                3.白色：【大于库存量下限并小于等于库存量上限】</br>
                4.蓝色：【大于库存量上限】</br>
                5.灰色：未设置库存预警</br>
                6.单元格数据格式：(库存数)|(库存上限)|(库存下限)|(库存预警线)</br>
                </div>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR>
    	    </TBODY></TABLE></DIV>
</form>
</body>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
