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
	function search(){		
		var BeginDate=document.all.startTime.value;
		var End=document.all.endTime.value;
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
        
		var ShopCode=document.all.shopCode.value;		
		var GoodsName=document.all.goodsName.value;
		var GoodsCode=document.all.goodsCode.value;
		var supplierID = document.getElementById("supplierID").value;
		var categoryID = '';
		$("input[name=categoryID]:checked").each(function (){
			categoryID = categoryID + $(this).val()+",";
		});		
		categoryID = categoryID.substring(0,categoryID.length-1);

		var distributionMethods = "";
		$("input[name=distributionMethods]:checked").each(function (){
			distributionMethods = distributionMethods + $(this).val()+",";
		});
		
		distributionMethods = distributionMethods.substring(0,distributionMethods.length-1);
		
		var minprice = document.getElementById("minprice").value;
		var maxprice = document.getElementById("maxprice").value;
		var minquantity = document.getElementById("minquantity").value;
		var maxquantity = document.getElementById("maxquantity").value;
		
		
		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
		url+="eims_reporting/storage_salesOfTreasurySumRpt&beginTime="+BeginDate+"&endTime="+End+"&categoryID="+categoryID+"&distributionMethods="+distributionMethods+"&minprice="+minprice+"&maxprice="+maxprice+"&minquantity="+minquantity+"&maxquantity="+maxquantity;
		
		if (ShopCode != ""){
		    url+="&shopcode=" + ShopCode;
		}
		if (GoodsName != ""){
		    url+="&goodsName=" + encodeURI(GoodsName);
		}
		if (GoodsCode != ""){
		    url+="&goodsid=" + GoodsCode;
		}
		if (supplierID != ""){
		    url+="&supplierID=" + supplierID;
		}
		
		url+="&rs:Command=Render";
        window.open (url,'salesOfTreasurySumRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		
	}
	function clean(){
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('shopCode').value = "";
		document.getElementById('goodsName').value = "";
		document.getElementById('goodsCode').value = "";
		document.getElementById("supplierID").value = "";
		document.getElementById("supplierName").value = "";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
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
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>报表中心</TD>
            <TD class=menubar_readme_text vAlign=bottom>
				&nbsp;
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27>目前操作功能：销售汇总表</TD>
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
                      UNSELECTABLE="on">销售汇总表</TD>
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
			               <TD width="13%" height="30" class="table_body">日期</TD>
			               <TD class="table_none" width="40%">
                           <li class="horizontal_onlyRight">
                            <input class="text_input80"
				               id="startTime"
						       name="startTime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input80"
						       id="endTime"
						       name="endTime"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
						       
						   </li>
						   <li class="horizontal_onlyRight">
					  				  <INPUT class=button_bak icon="icon-zoom" type=button value="今天" onClick="today('startTime','endTime')"></li>
						   <li class="horizontal_onlyRight">
                            <INPUT class=button_bak icon="icon-zoom" type=button value="当月" onClick="currtMonth('startTime','endTime')"></li>
						       
			               </TD>
			                <TD width="13%" height="30" class="table_body">销售部门名称</TD>
			               <TD class="table_none" width="40%">
			                   <select id="shopCode" name="shopCode">
	      		                 	<option value="">----请选择----</option>
	                             	<c:if test="${not empty(departmentsList)}">
					               	  <s:iterator value="departmentsList">
	                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
	      	                   </select>
			               </TD>
                        </TR>
					  	<TR>
						   <TD width="13%" height="30" class="table_body">商品名称</TD>
			               			<TD class="table_none" width="40%"><input type="text" class="text_input160" maxlength="20" id="goodsName" name="goodsName"/></TD>
						   <TD width="13%" height="30" class="table_body">商品代码(到品种)</TD>
			               			<TD class="table_none" width="40%"><input type="text" class="text_input160" maxlength="20" id="goodsCode" name="goodsCode"/></TD>
                        </TR>
                        <TR>
                           <TD class="table_body">商品类别</TD>
			               <TD class="table_none" width="23%">				
							<input type="checkbox" id="categoryID" name="categoryID" value="1" checked>镜架类&nbsp;&nbsp;
			               	<input type="checkbox" id="categoryID" name="categoryID" value="2" checked>配镜类&nbsp;&nbsp;
			               	<input type="checkbox" id="categoryID" name="categoryID" value="3" checked>镜片类&nbsp;&nbsp;
			               	<input type="checkbox" id="categoryID" name="categoryID" value="4" checked>隐形镜片类&nbsp;&nbsp;
			               	<input type="checkbox" id="categoryID" name="categoryID" value="5" checked>护理液类&nbsp;&nbsp;
			               	<input type="checkbox" id="categoryID" name="categoryID" value="6" checked>成镜类&nbsp;&nbsp;
			               	<input type="checkbox" id="categoryID" name="categoryID" value="7" checked>耗材类&nbsp;&nbsp;	
			               	<input type="checkbox" id="categoryID" name="categoryID" value="8" checked>老花镜类&nbsp;&nbsp;	
			               	<input type="checkbox" id="categoryID" name="categoryID" value="9" checked>视光类&nbsp;&nbsp;	               	
			               </TD>
						   <TD width="13%" height="30" class="table_body">制造商名称</TD>
			               <TD  class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <input icon="icon-zoom" type=button value="选 择" onClick="openSupplier();"></li>
			               </TD>
                        </TR>
                        <tr>
			               <TD class="table_body">经销方式</TD>
			               <TD class="table_none">
			               	<input type="checkbox" name="distributionMethods" value="jxfs1" checked>代销&nbsp;&nbsp;
			               	<input type="checkbox" name="distributionMethods" value="jxfs2" checked>数期&nbsp;&nbsp;
			               	<input type="checkbox" name="distributionMethods" value="jxfs3" checked>买断&nbsp;&nbsp;

			               </TD>
			                <td class="table_body">零售价格</td>
			               <td class="table_none" colspan="3">
				   			<input id="minprice" class="text_input80" name="minprice" value="${minprice}"/>
				   				至
				   			<input id="maxprice" class="text_input80" name="maxprice" value="${maxprice}"/>
			               </TD>				  				
                        </tr>
                        <tr>
			                <td class="table_body">销售数量</td>
			               <td class="table_none" colspan="3">
				   			<input id="minprice" class="text_input80" name="minquantity" value="${minquantity}"/>
				   				至
				   			<input id="maxprice" class="text_input80" name="maxquantity" value="${maxquantity}"/>
			               </TD>				  				
                        </tr>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
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

