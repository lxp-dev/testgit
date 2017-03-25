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
	    var goodscategoryID= document.all.goodscategoryID.value;
	    
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
	
	function search(){
		var BeginDate=document.all.startTime.value;
		var End=document.all.endTime.value;
		if(BeginDate==""){
			alert('请选择日期!');
			document.all.startTime.focus();
			return false;
		}
		if(End==""){
			alert('请选择日期!');
			document.all.endTime.focus();
			return false;
		}
		var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
		url+="eims_reporting/storage_salesAnalysis";
		if(document.getElementById('brandID').value!=''){
			url+="&brandID="+document.getElementById('brandID').value;
		}
		if(document.getElementById('supplierID').value!=''){
			url+="&supplierID="+document.getElementById('supplierID').value;
		}
		if(document.getElementById('goodsName').value!=''){
			url+="&goodsName="+document.getElementById('goodsName').value;
		}
		if(document.getElementById('goodsID').value!=''){
			url+="&goodsID="+document.getElementById('goodsID').value;
		}
		if(document.getElementById('spec').value!=''){
			url+="&Spec="+document.getElementById('spec').value;
		}
		if(document.getElementById('goodscategoryID').value!=''){
			url+="&goodsCategoryID="+document.getElementById('goodscategoryID').value;
		}
		url+="&beginTime="+BeginDate;
		url+="&endTime="+End;
		url+="&rs:Command=Render";
		window.open (url, 'salesAnalysis', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		
	}

	$(document).ready(function() { 
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>报表中心</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：销售透视分析表</TD>
            <TD align=right>&nbsp;</TD>
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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
						   <TD width="60" height="30" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD width="60" height="30" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>

                        </TR>
                        <TR>
                           <TD width="60" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}">${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input200" name="supplierName" value="" readonly="readonly"/>
							   			<input type="hidden" id="supplierID" name="supplierID" value="" />
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title='选择' onClick="openSupplier();"></li>						  				
						   	</TD>
                        </TR>
                        <TR>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" >
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value=""/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title='选择' onClick="openBrand();"></li>
			               </TD>
			              <TD width="10%" height="30" class="table_body">规格</TD>
			               <TD class="table_none" width="40%">
                            <input type="text" id="spec" >
			               </TD>
                        </TR>
                        
                        	<TR>
						   
			               <TD width="10%" height="26" class="table_body">查看日期</TD>
			               <TD class="table_none" width="40%" colspan="3">
                            <input class="text_input100"
				               id="startTime"
						       name="startTime" value="${requestScope.startTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime"
						       name="endTime" value="${requestScope.endTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
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

