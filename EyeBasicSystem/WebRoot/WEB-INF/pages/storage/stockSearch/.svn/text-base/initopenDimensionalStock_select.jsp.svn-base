<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>选择商品</title>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" content="HTML,DHTML,CSS,JavaScript">
<META NAME="Description" CONTENT="">
</head>

<body style="overflow-x:hidden;"  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>二维表库存查询</TD>
            <TD class=menubar_readme_text vAlign=bottom>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：二维表库存查询</TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
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
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">二维表库存查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
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
                           <TD width="60" height="30" class="table_body">商品类别</TD>
			               <TD class="table_none">
			               <c:if test="${requestScope.goodscategoryID=='3'}">镜片</c:if>
                          	 <c:if test="${requestScope.goodscategoryID=='4'}">隐形镜片</c:if>
			               </TD>
			               <TD height="30" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			${supplierName}
			               </TD>
                        </TR>
                        <TR>			               
						   <TD height="30" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           ${requestScope.brandName}
			               </TD>

						   <TD height="30" class="table_body">仓位</TD>
			               <TD class="table_none" >
                            <select id="warehouseID" disabled="disabled" name="warehouseID">
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${warehouseID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
      	                   <div style="display:none;">
      	                   <select id="warehouseID1"  name="warehouseID1">
      		                 <s:iterator value="goodsNumberList">
				               <option value="${substringcount}">,${substringcount}</option>
	     	                 </s:iterator>
      	                   </select>
      	                   </div>
			               </TD>
                        </TR>
 
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td align="left">
							</td>
						</tr>
					</table>
					<object classid="clsid:5F019427-2649-4468-BD28-F6FBD96E1B51"  width="100%" height="600" id="axgrid" codebase="${ctx }/AxGrid.ocx#version=1,0,0,0" name="axgrid">
		<param name="RowStart" value="6"/>		<!--行起始值-->
		<param name="RowEnd" value="-10"/>		<!--行终止值-->
		<param name="RowStep" value="-0.25"/>	<!--行步长-->
		<param name="ColStart" value="0"/>		<!--列起始值-->
		<param name="ColEnd" value="-20"/>		<!--列终止值-->
		<param name="ColStep" value="-0.25"/>		<!--列步长-->
		<param name="ColPrecision" value="2"/>	<!--列表头的精度-->
		<param name="RowPrecision" value="2"/>	<!--行表头的精度-->
		<param name="InputPrecision" value="0"/><!--内容的精度。小数点后几个0-->
		<param name="ColWidth" value="50"/>		<!--列宽-->
		<param name="RowHeight" value="22"/>	<!--行高-->
		<param name="Title" value="球镜/柱镜"/>
		<param name="RowHeaderColor" value="236, 245, 251"/>	<!--行表头的颜色-->
		<param name="ColHeaderColor" value="236, 245, 251"/>	<!--列表头的颜色-->
		<param name="GridLineColor" value="140, 140, 140"/>		<!--网格线的颜色-->
		<param name="OddLineColor" value="246, 246, 246"/>		<!--奇数行的背景颜色-->
		<param name="EvenLineColor" value="255, 255, 255"/>		<!--偶数行的背景颜色-->
		<param name="SelectedColor" value="217, 234, 247"/>		<!--选择项的颜色-->
		</object>
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
</body>

<script>
	//$(document).ready(function(){
	 var contents;
		 //<s:iterator value="goodsNumberList" status="idx">
		 // contents+=${substringcount};
	//}
		// </s:iterator>
		
		contents=$("#warehouseID1").text().substring(2,$("#warehouseID1").text().length);
		
	//alert( '['+contents+']');
	//alert(${substringcount});
	var axgrid = document.getElementById( 'axgrid' );
	axgrid.content = '['+contents+']';
	//axgrid.content = '[{"x":1,"y":1,"v":25},{"x":5,"y":5,"v":35}]';
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	
</script></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
