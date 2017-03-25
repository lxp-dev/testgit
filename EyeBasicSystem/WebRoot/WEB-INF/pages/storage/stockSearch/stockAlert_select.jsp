<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库管理</title>
</head>
<script>	

	function search(){
		$("img").removeAttr("onclick");
		procurementReceiptForm.action = "selStockAlert.action";
		procurementReceiptForm.submit();
		showLoadingBar();
	}	

	function clean(){
		$("#supplierID").val('');
		$("#supplierName").val('');
		$("#brandID").val('');
		$("#brandName").val('');
		document.all.goodsName.value="";
	    document.all.goodscategoryID.value="";
	    document.all.warehouseID.value="";	
	    document.all.goodsID.value="";
	    $("#alerttype").val('');
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
			/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;
		if(goodscategoryID==''){
			alert("请选择商品类别！");
			return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】"
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
		var goodscategoryID= document.all.goodscategoryID.value;
	    var supplierID=document.getElementById('supplierID').value;
	    if(goodscategoryID==''){
			alert("请选择商品类别！");
			return;
		}
		if(supplierID==''){
			alert("请选择制造商！");
			return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】"
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
		
	/**
	 * 品种开窗
	 */
	function openVariety(){
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
	    var brandID=document.getElementById('brandID').value;
	    if(brandID==''){
	      alert('请选择所属品种');
	      return false;
	    }		
		var goodscategoryID= document.all.goodscategoryID.value;
		showPopWin("","selVarietyOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value + "&brandID_open=" + document.getElementById('brandID').value ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openVarietyValues(json){
		document.getElementById('varietyID').value = json.varietyID;
		document.getElementById('varietyName').value = json.varietyName;
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：库存量预警查询</TD>
             <TD align="right" vAlign=bottom>&nbsp;
           		<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"  />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存预警查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || person.departmenttype != '1'}">    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initStockAlert2DSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">库存预警查询(二维)</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                </c:if>    	
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
                           <TD width="9%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID"}>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
                        </TR>
                        <TR>	
                           <TD height="26" class="table_body">仓位</TD>
			               <TD class="table_none" ${systemParameterPo.fspisshowsupplierandbrand == '1' || person.departmenttype != '1' ? '':'colspan="5"'}>
                            <select id="warehouseID" name="warehouseID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${warehouseID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
			               <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || person.departmenttype != '1'}">
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } readonly="readonly"/>
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
						  			</li>
			               </TD>		               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						  </li>
			               </TD>
			               </c:if>
                        </TR>
                        <TR>	
                           <TD height="26" class="table_body">预警状态</TD>
			               <TD class="table_none" colspan="5">
                           <select id="alerttype" name="alerttype">
                             <option value="">----请选择----</option>
                             <option value="4" ${alerttype == '4' ? 'selected="selected"' : '' }>小于等于红色预警</option>
			                 <option value="3" ${alerttype == '3' ? 'selected="selected"' : '' }>大于红色预警并小于等于库存量下限</option>
			                 <option value="2" ${alerttype == '2' ? 'selected="selected"' : '' }>大于库存量下限并小于等于库存量上限</option>
			                 <option value="1" ${alerttype == '1' ? 'selected="selected"' : '' }>大于库存量上限</option>
      	                   </select>
			               </TD>
                        </TR>
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							  <c:if test="${permissionPo.keya == '1'}">
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
							  </c:if>	
							</td>
						</tr>
					</table>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->	
					<c:if test="${not empty(goodsList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </table>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                      
                          <TH width="12%" height="26" scope=col>商品代码</TH>
                          <TH scope=col>商品名称</TH>
                          <TH width="5%" scope=col>商品类别</TH>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || person.departmenttype != '1'}">
                          <TH width="12%" scope=col>所属制造商</TH>  
                          </c:if>                        
                          <TH width="7%" scope=col>零售价格</TH>
                          <TH width="4%" scope=col>数量</TH>
                          <TH width="15%" scope=col>仓位</TH>
                          <c:if test="${permissionPo.keyb == '1'}">
                          <TH width="5%" scope=col>在途数量</TH>
                          </c:if>
                          <TH width="5%" scope=col>库存上限</TH>
                          <TH width="5%" scope=col>库存下限</TH>
                          <TH width="5%" scope=col>红色预警</TH>
                          <TH width="5%" scope=col>采购数量</TH> 
						  </TR>
						<c:forEach var="po" items="${goodsList}">
		                <c:if test="${po.alerttype eq '4' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: red;">   
                        </c:if>
						<c:if test="${po.alerttype eq '3' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: #9F0050;">   
                        </c:if>
                        <c:if test="${po.alerttype eq '2' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">   
                        </c:if>
                        <c:if test="${po.alerttype eq '1' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: blue;">   
                        </c:if>
                          <TD height="26">${po.bgigoodsid}</TD>
                          <TD>${po.bgigoodsname}</TD>
                          <TD>${po.bgigoodscategoryname}</TD>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || person.departmenttype != '1'}">
                          <TD>${po.bgisuppliername}</TD>
                          </c:if>                     
                          <TD>${po.bgiretailprice}</TD>
                          <TD>${po.bgigoodsquantity}</TD>  
                          <TD>${po.bgiwarehousename}</TD>
                          <c:if test="${permissionPo.keyb == '1'}">
                          <TD>${po.zaitu}</TD>
                          </c:if>
                          <TD>${po.bgistorageupperlimit}</TD>
                          <TD>${po.bgistoragelowerlimit}</TD>
                          <TD>${po.bgistorageredlimit}</TD>
                          <c:if test="${permissionPo.keyb == '1'}">
                          <TD>${po.bgistorageupperlimit-po.bgigoodsquantity-po.zaitu}</TD>
                          </c:if>
                          <c:if test="${permissionPo.keyb != '1'}">
                          <TD>${po.bgistorageupperlimit-po.bgigoodsquantity}</TD>
                          </c:if>
						</TR>
						</c:forEach>
                      </TBODY>
                    </table>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
