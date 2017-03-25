<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>仓库管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	procurementReceiptForm.action=link;
	  	procurementReceiptForm.submit();
		showLoadingBar();
	}

	function search(){
		$("img").removeAttr("onclick");
		procurementReceiptForm.action = "selStockSearchDtails.action";
		procurementReceiptForm.submit();
		showLoadingBar();
	}	

	function clean(){
	    document.all.goodsID.value="";
	    document.all.goodsName.value="";
	    document.all.goodscategoryID.value="";
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    document.all.brandID.value="";
	    document.all.brandName.value="";
	    document.all.warehouseID.value="";	
	     document.all.goodsBarcode.value="";
	    document.all.RetailPrice.value="";
	    document.all.sumnum.value="";
	    document.all.sumnum1.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
			/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;

		//showPopWin("","selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	 * 品种开窗
	 
	function openBrand(){
		var goodscategoryID= document.all.goodscategoryID.value;
	    var supplierID=document.getElementById('supplierID').value;

		showPopWin("","selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}*/
	
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    var goodscategoryID= document.all.goodscategoryID.value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		showPopWin("","selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}

	function amount(){
    	var goodsquantityTotal = 0;

		var goodsquantity = document.getElementsByName("sxhsumnum");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		if(document.getElementById("goodsquantityTotal")!=null){
			document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
			}

	}
	
	window.onload = function(){
		amount();
	};
	
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
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
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：库存综合查询</TD>
            <TD class=menubar_function_text align=right>
             <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD class=menubar_button id=button_0>&nbsp;</TD>

             </TR></TBODY></TABLE>
            </TD>
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
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                     <!-- --------------------------- -->
                      
                      
                      
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initStockSearchSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">库存综合查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif
                      UNSELECTABLE="on">库存详细查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                      
                      
                      
                      
                      
                      <!--    
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存综合查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                      width=3></TD>  --> 
                     </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD>
				
				</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
						   <TD width="10%" height="30" class="table_body">商品代码</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input200" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			              
						<TD width="10%" height="30" class="table_body" >商品条码</TD>
			               <TD class="table_none" width="40%" colspan="3">
                            <input class="text_input200" type="text"  id="goodsBarcode" name="goodsBarcode" value="${goodsBarcode}">
			               </TD>
                        </TR>
                        <TR>
                           <TD height="30" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID"}>
      		                 <option value="">请选择商品类别</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
					         <TD height="30" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
                        </TR>
                      
                        <TR>
                           <TD height="30" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input200" readonly="readonly" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<INPUT class=button_bak icon="icon-zoom" type=button value="选 择" onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li>
			               </TD>			               
						   <TD height="30" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <input icon="icon-zoom" type=button value="选 择" onClick="openBrand();"></li>
			               </TD>
                        </TR>
        
			               

					      <TD height="30" class="table_body">仓位</TD>
			               <TD class="table_none">
                            <select id="warehouseID" name="warehouseID">
                               <option value="">请选择仓位</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${stockID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
			                <TD height="30" class="table_body">仓储数量</TD>			            
			                <TD class="table_none">
			                	<input class="text_input100" type="text" id="sumnum" name="sumnum" value="${requestScope.sumnum}">—<input class="text_input100" type="text"  id="sumnum1" name="sumnum1" value="${requestScope.sumnum1}">
                        	</TD>
                        </TR>
                        <tr>                        	
                        	<TD height="30" class="table_body">单价</TD>			            
			                <TD class="table_none" colspan="3">
			                	<input class="text_input200" onkeypress="var k=event.keyCode; if ((k==46)||(k<=57 && k>=48)) return true;else return false" type="text"  id="RetailPrice" name="RetailPrice" value="${requestScope.RetailPrice}">
                        	</TD>
                        </tr>
                      </TBODY>
                    </table>
                    <c:if test="${permissionPo.keya=='1'}">
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					</c:if>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(goodsDetailsList)}"> 
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
                          <TH width="12%" height="30" scope=col>商品代码</TH>
                          <TH width="12%" height="30" scope=col>商品条码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>商品类别</TH>
                          <TH width="19%" scope=col>所属制造商</TH>                          
                          <TH width="10%" scope=col>零售价格</TH>
                          <TH width="10%" scope=col>仓位</TH>
                          <TH width="9%" scope=col>数量</TH>
						</TR>
						<TR class=table_title align=middle> 
						  	<TH width="40%" height="30"  colSpan=7 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>  
						<s:iterator value="goodsDetailsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="28">${sxhGoodsId}</TD>
                          <TD>${sxhGoodsBarCode}</TD>
                          <TD>${sxhGoodsName}</TD>
                          <TD>${sxhGoodsCategoryName}</TD>                          
                          <TD>${sxhSupplierName}</TD>
                          <TD>${sxhRetailPrice}</TD>
                          <TD>${sxhWarehouseName}</TD>
                          <TD>${sxhsumnum}<input type="hidden" name="sxhsumnum" value="${sxhsumnum}"/></TD>                          
						</TR>
						</s:iterator>
						<TR class=table_title align=middle> 
						  	<TH width="40%" height="30"  colSpan=7 scope=col align="right">库存合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%">${titlenum}</TH>
				   		</TR>  
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