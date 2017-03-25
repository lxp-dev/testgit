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
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
		var goodscategoryID="";
		$("input[name=goodscategoryID]:checked").each(function (){
			goodscategoryID = goodscategoryID + $(this).val()+",";
		});		
		goodscategoryID = goodscategoryID.substring(0,goodscategoryID.length-1);

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
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
		
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
		var goodscategoryID="";
		$("input[name=goodscategoryID]:checked").each(function (){
			goodscategoryID = goodscategoryID + $(this).val()+",";
		});		
		goodscategoryID = goodscategoryID.substring(0,goodscategoryID.length-1);
	    var supplierID=document.getElementById('supplierID').value;

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value ,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var salestypes = "";
		$("input[name=salestypes]:checked").each(function (){
			salestypes = salestypes + $(this).val()+",";
		});
		
		salestypes = salestypes.substring(0,salestypes.length-1);
		
		var GoodscategoryID="";
		$("input[name=goodscategoryID]:checked").each(function (){
			GoodscategoryID = GoodscategoryID + $(this).val()+",";
		});
		
		GoodscategoryID = GoodscategoryID.substring(0,GoodscategoryID.length-1);
		var DepartmentId=document.all.bwhid.value;
		var BillDateStart=document.all.billDateStart.value;
		var BillDateEnd=document.all.billDateEnd.value;
		if(BillDateStart=="" || BillDateEnd==""){
			alert('请选择日期!');
			return false;
		};
		
		if(!GoodscategoryID){
			alert("请选择商品类别！");
			return;
		}
		
		if(!salestypes){
			alert("请选择经销方式！");
			return;
		}
		var SupplierID=document.all.supplierID.value;
		var BrandID=document.all.brandID.value;
		var GoodsID=document.all.goodsID.value;
		var Goodsname=document.all.goodsname.value;
		var exportflag=document.all.exportflag.value;

		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
		url+="eims_reporting/storage_allocationDistrisRpt&billDateStart="+BillDateStart+"&billDateEnd="+BillDateEnd+"&departmentId="+DepartmentId+"&goodsCategoryID="+GoodscategoryID+"&supplierID="+SupplierID+"&brandID="+BrandID+"&goodsName="+EncodeUtf8(Goodsname)+"&goodsID="+EncodeUtf8(GoodsID)+"&salestypes="+salestypes+"&exportflag="+exportflag+"&rs:Command=Render";
		window.open (url,'allocationDistrisRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	}
	
	function clean(){
		document.getElementById('billDateStart').value = "";
		document.getElementById('billDateEnd').value = "";
		document.getElementById('bwhid').value = "";
		document.getElementById('goodscategoryID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('brandID').value = "";
		document.getElementById('supplierName').value = "";
		document.getElementById('SupplierID').value = "";
		document.getElementById('goodsID').value = "";
		document.getElementById('goodsname').value = "";
	}

	$(document).ready(function() {
		$("input[type=radio]").eq(0).attr("checked","checked");
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>北京同仁报表</TD>
            <TD align="left" width="45%">目前操作功能：调拨明细表</TD>
            <TD align=right></TD>
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
          background=${ctx }/img/pic/tab_bg.gif>
				</TD></TR>
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
			               <TD width="13%" height="30" class="table_body">日期</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input100"
				               id="billDateStart"
						       name="billDateStart"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('billDateEnd').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="billDateEnd"
						       name="billDateEnd"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('billDateStart').value}"
						       readonly="readonly" />
			               </TD>
			               <TD width="13%" height="30" class="table_body">经销方式</TD>
			               <TD class="table_none" width="40%">
			               	<input type="checkbox" name="salestypes" value="jxfs1" checked>代销&nbsp;&nbsp;
			               	<input type="checkbox" name="salestypes" value="jxfs2" checked>数期&nbsp;&nbsp;
			               	<input type="checkbox" name="salestypes" value="jxfs3" checked>买断&nbsp;&nbsp;
			               </TD>
                        </TR>
                        <TR>
					  	<TD width="13%" height="30" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="3">
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="1" checked>镜架&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="2" checked>配件&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="3" checked>镜片&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="4" checked>隐形&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="5" checked>护理液&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="6" checked>太阳镜&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="7" checked>耗材&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="8" checked>老花镜&nbsp;&nbsp;
			               	<input type="checkbox" id="goodscategoryID" name="goodscategoryID" value="9" checked>视光&nbsp;&nbsp;
	      	               </TD>
					  	</TR>
					  	<TR>
					  	    <TD width="13%" height="30" class="table_body">制造商</TD>
						            <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input200" readonly="readonly" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li>
			                </TD>
						    <TD width="13%" height="30" class="table_body">商品品种</TD>
			               	<TD class="table_none">
	                           <li class="horizontal_onlyRight">
							   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
							   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();"></li>
			               </TD>
						</TR>
                        <TR>
                           <TD width="13%" height="30" class="table_body">商品代码</TD>
			               <TD class="table_none" width="40%"><input type="text" maxlength="30" id="goodsID" name="goodsID"/></TD>
						   <TD width="13%" height="30" class="table_body">商品名称</TD>
			               <TD class="table_none" width="40%"><input type="text" maxlength="20" id="goodsname" name="goodsname"/></TD>
                        </TR>
                        <TR>
						   <TD width="13%" height="30" class="table_body">仓位名称</TD>
			               <TD class="table_none" width="40%">
      	                   <c:if test="${person.departmenttype!=1&&person.departmenttype!=2}">
                            <select id="bwhid" name="bwhid">
      		                 	<option value="">请选择部门名称</option>
                             	<c:if test="${not empty(warehouseList)}">
				               	  <s:iterator value="warehouseList">
                    	           <OPTION value="${bwhid}">${bwhwarehouseName}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
      	                   </c:if>
      	                   <c:if test="${person.departmenttype==1||person.departmenttype==2}">
                            ${warehouseList[0].bwhwarehouseName}<input type="hidden" name="bwhid" value="${warehouseList[0].bwhid}" name="bwhid"/>
      	                   </c:if>
			               </TD>
			               
			               <TD width="13%" height="30" class="table_body">是否统计调出</TD>
			               <TD class="table_none" width="40%">
	                            <select id="exportflag" name="exportflag">
	      		                 	<option value="1">是</option>
	                             	<option value="2">否</option>
	      	                    </select>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' id="submitButton" onClick="javascript:search()">
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onClick="clean()">
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

