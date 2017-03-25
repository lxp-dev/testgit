<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计量单位维护</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
    	var typeID = "${requestScope.typeID}";
    	if(typeID == "") {
        	typeID = "1";
    	}
    	setAllChecked();
	});
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertSalesArea.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertSalesArea.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【价格区间新增】";
	}
	
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteSalesArea.action?uuid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteSalesArea.action?uuid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【价格区间删除】";
	}	

	function checkAll() {
		$("input[id=chk]").each(function() {
			$(this).attr("checked", $("#chks").attr("checked"));
		});
	}
	
	function initBatchDel() {
		var ids = "";
		$("input[id=chk]").each(function() {
			if($(this).attr("checked") == true) {
				ids = ids + $(this).val() + ",";
			}
		});
		if(!ids) {
			alert("请选择要删除的价格区间!");
			return;
		} else {
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initBatchDeleteSalesArea.action?moduleID=${requestScope.moduleID}&hid="+ids,400,140,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initBatchDeleteSalesArea.action?moduleID=${requestScope.moduleID}&hid="+ids,400,140,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【价格区间批量删除】";
		}
		
	}

	function seachArea() {
		$("img").removeAttr("onclick");
		unitForm.action="selectSalesArea.action";
		unitForm.submit();
	}
	
	function setDisabled(typeId) {
		if(typeId == 1) {
			$("input[id=saleTypeID]").attr("disabled", true);
			$("input[id=categoryID]").attr("disabled", false);
			$("input[id=saleTypeID]").attr("checked", false);
			$("tr[id=salesTr]").attr("style", "display:none");
			$("tr[id=goodsTr]").attr("style", "");
		} else {
			$("input[id=categoryID]").attr("disabled", true);
			$("input[id=saleTypeID]").attr("disabled", false);
			$("input[id=categoryID]").attr("checked", false);
			$("tr[id=goodsTr]").attr("style", "display:none");
			$("tr[id=salesTr]").attr("style", "");
		}
	}
	
	function setAllChecked() {
		var salesLength = $("input[chk=chkSales]").length;
		var goodsLength = $("input[chk=chkGoods]").length;
		$("input[chk=chkSales]").each(function() {
			if($(this).attr("checked")  == true) {
				salesLength = salesLength - 1;
			}
		});
		$("input[chk=chkGoods]").each(function() {
			if($(this).attr("checked") == true) {
				goodsLength = goodsLength - 1;
			}
		});
		if(salesLength == 0) {
			$("#chksSales").attr("checked", true);
		}
		if(goodsLength == 0) {
			$("#chksGoods").attr("checked", true);
		}
	}
	
	function checkAllSales() {
		$("input[chk=chkSales]").attr("checked", $("#chksSales").attr("checked"));
		//seachArea();
	}
	
	function checkAllGoods() {
		$("input[chk=chkGoods]").attr("checked", $("#chksGoods").attr("checked"));
		//seachArea();
	}

	function clean() {
		$("input[clean=clean]").attr("checked", false);
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="unitForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息维护</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：价格区间维护</TD>
            <td align="right" valign="bottom">
            	&nbsp;<img src="${ctx }/img/newbtn/btn_salesareainsert_0.png" btn=btn title="价格区间新增" onClick="insert()">
            </td>
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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                   <table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                      </TBODY>
                    </table>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                       <%--<TR>
						   <TD width="10%" height="26" class="table_body">价格区间类型</TD>
			               <TD width="90%" class="table_none" colspan="5">
			                 <select id="type" name="typeID" onchange="setDisabled(this.selectedIndex+1)">
			                 	<option ${requestScope.typeID eq 1 ? 'selected="selected"' : "" } value="1">商品类型</option>
			                 	<option ${requestScope.typeID eq 2 ? 'selected="selected"' : "" } value="2">销售类型</option>
			                 </select>
			               </TD>
                       </TR>--%>
                       <TR id="salesTr">
						   <TD width="10%" height="26" class="table_body">销售类别</TD>
			               <TD width="90%" class="table_none" colspan="5">
                             <TABLE>
                               <TR>
                                 <TD><input type="checkbox" clean=clean id="chksSales" name="chksSales" onclick="checkAllSales()"/>全选</TD>
                               </TR>
                               <TR>
                                 <TD>
                                   <input type="checkbox" clean=clean chk="chkSales" <s:iterator id="sales" value="#request.salesTypeID">${sales eq 1 ? 'checked="checked"' : '' }</s:iterator> id="saleTypeID" name="salesTypeID" value="1"/>框镜成品
                                 </TD>
                                 <TD>
                                   <input type="checkbox" clean=clean chk="chkSales" id="saleTypeID" name="salesTypeID" value="2" <s:iterator id="sales" value="#request.salesTypeID">${sales eq 2 ? 'checked="checked"' : '' }</s:iterator>/>框镜订制
                                 </TD>
                                 <TD>
                                   <input type="checkbox" clean=clean chk="chkSales" id="saleTypeID" name="salesTypeID" value="3" <s:iterator id="sales" value="#request.salesTypeID">${sales eq 3 ? 'checked="checked"' : '' }</s:iterator>/>隐形成品
                                 </TD>
                                 <TD>
                                   <input type="checkbox" clean=clean chk="chkSales" id="saleTypeID" name="salesTypeID" value="4" <s:iterator id="sales" value="#request.salesTypeID">${sales eq 4 ? 'checked="checked"' : '' }</s:iterator>/>隐形订制
                                 </TD>
                                 <TD>
                                   <input type="checkbox" clean=clean chk="chkSales" id="saleTypeID" name="salesTypeID" value="5" <s:iterator id="sales" value="#request.salesTypeID">${sales eq 5 ? 'checked="checked"' : '' }</s:iterator>/>辅料
                                 </TD>
                               </TR>
                               <%--<TR>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="1" onclick="seachArea()" ${requestScope.salesTypeID eq 1 ? 'checked="checked"' : "" }/>框镜成品
                                 </TD>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="2" onclick="seachArea()" ${requestScope.salesTypeID eq 2 ? 'checked="checked"' : "" }/>框镜订制
                                 </TD>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="3" onclick="seachArea()" ${requestScope.salesTypeID eq 3 ? 'checked="checked"' : "" }/>隐形成品
                                 </TD>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="4" onclick="seachArea()" ${requestScope.salesTypeID eq 4 ? 'checked="checked"' : "" }/>隐形订制
                                 </TD>
                                 <TD>
                                   <input type="radio" id="saleTypeID" name="salesTypeID" value="5" onclick="seachArea()" ${requestScope.salesTypeID eq 5 ? 'checked="checked"' : "" }/>辅料
                                 </TD>
                               </TR>--%>
                             </TABLE>
			               </TD>
                        </TR>
                       <TR id="goodsTr">
						   <TD width="10%" height="26" class="table_body">商品类别</TD>
			               <TD width="90%" class="table_none" colspan="5">
                             <TABLE>
                               <TR>
                                 <TD colspan="9">
                                   <input type="checkbox" id="chksGoods" name="chksGoods" clean=clean onclick="checkAllGoods()"/>全选
                                 </TD>
                               </TR>
                               <TR>
                                 <s:iterator value="goodsCategoryList">
                                   <TD>
                                     <input clean=clean type="checkbox" chk="chkGoods" id="categoryID" <s:iterator value="#request.goodsCategoryID" id="category">${category eq bgcid ? 'checked="checked"' : '' }</s:iterator> name="goodsCategoryID" value="${bgcid }"/>${bgcgoodscategoryname }
                                   </TD>
                                 </s:iterator>
                               </TR>
                             </TABLE>
			               </TD>
                        </TR>
                    </table>
                    <table>
                      <TR>
                        <TD width="95%" align="left">
							 <img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="seachArea()">
							 <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()"></TD>
                        <TD width="5%"><img src="${ctx }/img/newbtn/btn_plsc_0.png" btn=btn title='批量删除' onClick="initBatchDel()"></TD>
                      </TR>
                    </table>
				   <c:if test="${not empty(salesAreaPos)}">
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="6%" scope=col height="26">全选<input type="checkbox" id="chks" onclick="checkAll()"/></TH>
                          <TH width="4%" scope=col height="26">操作</TH>
                          <TH width="72%" scope=col>价格区间</TH>
                          <TH width="20%" scope=col>类别名称</TH>
                        </TR>
                        <s:iterator value="salesAreaPos">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk" name="delID" value="${rrcsaid}"/></TD>
                          <TD>
                       		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${rrcsaid}')">
                          </TD>
                          <TD height="26">${rrcsapricemin}--${rrcsapricemax}</TD>
                          <TD height="26">${salesTypeName }${goodsCategoryName }</TD>
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
width=1></TD></TR></TBODY></TABLE>

</TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>