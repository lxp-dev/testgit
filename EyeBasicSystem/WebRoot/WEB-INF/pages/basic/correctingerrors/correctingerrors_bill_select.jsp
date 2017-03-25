<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常单据查询</title>
</head>
<script>
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initBillDifferenceDetail.action?moduleID=${requestScope.moduleID}&hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBillDifferenceDetail.action?moduleID=${requestScope.moduleID}&hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【库存明细】";
	}
		
	function search(){
	    $("img").removeAttr("onclick");
	    correctingErrorsFrm.action = "billDifferenceSel.action";
	    correctingErrorsFrm.submit();		
		showLoadingBar();
	}

	function clean(){
	    $('input[clean=clean]').each(function(){
            $(this).val('');
		});
	    $('select[clean=clean]').each(function(){
            $(this).val('');
		});
	}	

	function changeGoodsCategory(){
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodsCategoryID=document.getElementById('goodsCategoryID').value;
	    if(goodsCategoryID==''){
	      alert('请选择商品类型!');
	      return false;
	    }	
	    
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
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var goodsCategoryID=document.getElementById('goodsCategoryID').value;
	    if(goodsCategoryID==''){
	      alert('请选择商品类型!');
	      return false;
	    }
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodsCategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodsCategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
<form name="correctingErrorsFrm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="8%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统维护 </TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：库存变更记录</TD>
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
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>   
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initInventoryDifferenceSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">库存差异查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存变更记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>    
                    
                     <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initErrorsGoodsBarCodeSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">异常条码查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                   <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initGoodsTransitStorageSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">商品在途库存查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>  
                   
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
							<TD height="26" class="table_body">单据类型</TD>
							<TD class="table_none">
								<select id="inventoryType" name="inventoryType" clean=clean>
                            	<option value="" ${requestScope.inventoryType eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                            	<option value="1" ${requestScope.inventoryType eq 1 ? 'selected="selected"' : '' }>正常单据</option>
                            	<option value="2" ${requestScope.inventoryType eq 2 ? 'selected="selected"' : '' }>忽略商品库存为零的单据</option>
                            	<option value="3" ${requestScope.inventoryType eq 3 ? 'selected="selected"' : '' }>异常单据</option>
								</select>
							</TD>
							<TD height="26" class="table_body">变更单据</TD>
							<TD class="table_none">
                                <input class="text_input160" type="text" clean=clean id="changeBillID" name="changeBillID" value="${changeBillID}">
							</TD>
							<TD height="26" class="table_body">
						                     变更日期
							</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input80" clean=clean  
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime" clean=clean 
					       name="endTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /> 
					        </li>
					        <li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('startTime','endTime')"></li>
							<li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_month_0.png" btn=btn title="当月" onClick="currtMonth('startTime','endTime')"></li>								
							</TD>
			            </tr>

                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							 <img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							 <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
					<c:if test="${not empty(correctingErrorsList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="3%" height="26" scope=col>操作</TH>
                          <TH width="15%" height="26" scope=col>变更单号</TH>
                          <TH width="15%" height="26" scope=col>单据类型</TH>
                          <TH width="20%" scope=col>商品数量</TH>
                          <TH width="20%" scope=col>库存变更</TH>
						  </TR>
						<s:iterator value="correctingErrorsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%" height="26">
                              <img src="${ctx }/img/newbtn/search_0.png" title='详细' btn=btn onClick="javascript:details('${cerrchangeid}')">
                          </TD>
                          <TD>${cerrchangeid}</TD>
                          <TD>
                          <c:choose>
	                    	<c:when test="${fn:substring(cerrchangeid,0,3) == 'PIN'}">采购收货单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,4) == 'POUT'}">采购退货单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,4) == 'SOUT'}">销售出库单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,3) == 'ALL'}">调拨单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,3) == 'SCI'}">盘盈单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,3) == 'SCO'}">盘亏单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,3) == 'OTI'}">其他入库单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,3) == 'OTO'}">其他出库单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,4) == 'CPIN'}">委外收货单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,2) == 'SG'}">客户批发调货单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,2) == 'SR'}">客户批发退货单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,2) == 'DH'}">门店积分兑换单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,1) == 'X'}">配镜单</c:when>
	                    	<c:when test="${fn:substring(cerrchangeid,0,4) == 'TOUT'}">领用出库单</c:when>
	                    	
	                    	<c:when test="${cerrchangeid == 'import'}">
	                    		初始化库存
	                    	</c:when>
	                    	<c:otherwise>
	                    		&nbsp;
	                    	</c:otherwise>                    	
                          </c:choose>
                          </TD>
                          <TD>${cerrbillnum}</TD>
                          <TD>${cerrlognum}</TD>
						</TR>
						</s:iterator>
                      </TBODY>
                    </TABLE>
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