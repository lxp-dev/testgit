<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>期末处理</title>
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

	function search(){
	    $("img").removeAttr("onclick");
	    calresultFrm.action = "calBillSel.action";
	    calresultFrm.submit();		
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

	function detail(id,typeid){
        if (typeid == '5' || typeid == '6'){
        	detail56(id);
        	return;
        }
        if (typeid == '3'){
        	detail3(id);
        	return;
        }
        if (typeid == '8'){
        	detail8(id);
        	return;
        }
	}
	
	function detail56(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initOveragelossesDetails.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initOveragelossesDetails.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【盘盈盘亏单详细】";
	}

	function detail3(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSalesOutDetails.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSalesOutDetails.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【销售出库详细】";
	}	

	function detail8(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initOtherDatabaseSettlementDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initOtherDatabaseSettlementDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【其他出库详细】";
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="calresultFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="9%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;财务管理</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：查看成本回填单据</TD>
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
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initSwitchAmount.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">结账</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                                        
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initCalSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">成本计算</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                    	
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initMoniSelect.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">查看成本</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>

                   <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">查看成本回填单据</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
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
                    </TABLE><!-- ?? Start -->
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	   <TD width="9%" height="26" class="table_body">商品类型</TD>
			               <TD width="24%" class="table_none">
                            	<select id="goodsCategoryID" name="goodsCategoryID" onchange="changeGoodsCategory()" clean=clean>
	                            	<option value="" ${goodsCategoryID eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                                    <s:iterator value="goodsCategoryList">
                                         <option value="${bgcid }" ${goodsCategoryID eq bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
                                    </s:iterator>
								</select>
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input160" type="text" clean=clean id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
							   		<input type="hidden" id="supplierID" clean=clean name="supplierID" value="${requestScope.supplierID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
							   </li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text" clean=clean id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" clean=clean name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						  </li>
			               </TD>
                        </TR> 
                        <TR>
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text" clean=clean id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">商品名称</TD>
			               <TD width="24%" class="table_none">
                           		<input class="text_input160" type="text" clean=clean id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
			               <TD class="table_body">单据类型</TD>
			               <TD class="table_none" >
			                   <SELECT id="billType" name="billType" clean=clean>
			                       <option value="" ${billType=='' ? 'selected="selected"' : '' }>----请选择----</option>
			                       <option value="3" ${billType=='3' ? 'selected="selected"' : '' }>销售出库单</option>
			                       <option value="5" ${billType=='5' ? 'selected="selected"' : '' }>盘盈单</option>
			                       <option value="6" ${billType=='6' ? 'selected="selected"' : '' }>盘亏单</option>
			                       <option value="8" ${billType=='8' ? 'selected="selected"' : '' }>其他出库单</option>
			                   </SELECT>
			               </TD>
                        </TR>
                        <TR>
                           <TD class="table_body">单据编号</TD>
			               <TD height="26" class="table_none">
			                  <input class="text_input200" type="text"  clean=clean id="billID" name="billID" value="${billID}">
			               </TD>
			               <TD class="table_body">制单日期</TD>
			               <TD height="26" class="table_none">
			                  <li class="horizontal_onlyRight"> <input class="text_input80"
				               id="createStartTime"
						       name="createStartTime" value="${createStartTime}"
						       type="text" clean=clean 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('createEndTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input80"
						       id="createEndTime"
						       name="createEndTime" value="${createEndTime}"
						       type="text" clean=clean 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('createStartTime').value}"
						       readonly="readonly" /></li><li class="horizontal_onlyRight">
								<img src="${ctx }/img/newbtn/btn_month_0.png" btn=btn title="当月" onClick="currtMonth('createStartTime','createEndTime')">
								</li>
			               </TD>
			               <TD class="table_body">审核日期</TD>
			               <TD height="26" class="table_none">
				                <li class="horizontal_onlyRight"> <input class="text_input80"
					               id="auditStartTime" clean=clean
							       name="auditStartTime" value="${requestScope.auditStartTime}"
							       type="text" 
							       onFocus="WdatePicker({readOnly:true})"
							       MAXDATE="#F{document.getElementById('auditEndTime').value}" 
							       readonly="readonly" />
							       至
						         <input class="text_input80"
							       id="auditEndTime" clean=clean
							       name="auditEndTime" value="${auditEndTime}"
							       type="text" 
							       onFocus="WdatePicker({readOnly:true})"
							       MINDATE="#F{document.getElementById('auditStartTime').value}"
							       readonly="readonly" /></li><li class="horizontal_onlyRight">
									<img src="${ctx }/img/newbtn/btn_month_0.png" btn=btn title="当月" onClick="currtMonth('auditStartTime','auditEndTime')">
									</li>
			               </TD>
                        </TR>
                        <TR>
			               <TD class="table_body">制单人</TD>
			               <TD height="26" class="table_none">
			                  <input class="text_input100" type="text"  clean=clean id="createPersonID" name="createPersonID" value="${createPersonID}">
			               </TD>
			               <TD class="table_body">审核人</TD>
			               <TD height="26" class="table_none">
			                  <input class="text_input100" type="text"  clean=clean id="auditPersonID" name="auditPersonID" value="${auditPersonID}">
			               </TD>
			               <TD class="table_body">回填状态</TD>
			               <TD class="table_none" >
			                   <SELECT id="fillbillType" name="fillbillType" clean=clean>
			                       <option value="" ${fillbillType=='' ? 'selected="selected"' : '' }>----请选择----</option>
			                       <option value="1" ${fillbillType=='1' ? 'selected="selected"' : '' }>已回填</option>
			                       <option value="0" ${fillbillType=='0' ? 'selected="selected"' : '' }>未回填</option>			                     
			                   </SELECT>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
							 <img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                             <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >
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
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(inventoryList)}"> 
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
                        <TR class=table_title align=middle >
                          <TH width="3%" height="26" scope=col>操作</TH>
                          <TH width="15%" height="26" scope=col>单据编号</TH>
                          <TH width="8%" height="26" scope=col>单据类型</TH>
                          <TH width="15%" height="26" scope=col>相关部门/仓位</TH>
                          <TH width="8%" scope=col>制单日期</TH>
                          <TH width="7%" scope=col>制单人</TH>
                          <TH width="8%" scope=col>审核日期</TH>
                          <TH width="7%" scope=col>审核人</TH>                           
						  </TR>
						<s:iterator value="inventoryList">
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" >
                          <TD height="26"><img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${cstibillid}','${cstibilltypeid}')" ></TD>
                          <TD height="26">${cstibillid}</TD>
                          <TD>
                              <c:if test="${cstibilltypeid eq '3'}">销售出库单</c:if>
                              <c:if test="${cstibilltypeid eq '5'}">盘盈单</c:if>
                              <c:if test="${cstibilltypeid eq '6'}">盘亏单</c:if>
                              <c:if test="${cstibilltypeid eq '8'}">其他出库单</c:if>                              
                          </TD>  
		                  <TD>${cstidepartmentname }</TD>
		                  <TD>${cstibilldate}</TD>
		                  <TD>${csticreatepersonname}</TD>  
		                  <TD>${cstiauditdate }</TD>
		                  <TD>${cstiauditpersonname}</TD>
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