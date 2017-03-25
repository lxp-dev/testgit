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
$(document).ready(function() { 
    $("img[btn=btn]").attr("style","cursor: hand;"); 
    $("img[btn=btn]").mouseover(function () { 
    $(this).attr("src",$(this).attr("src").replace("0","1")); 
    }).mouseout(function () { 
      $(this).attr("src",$(this).attr("src").replace("1","0")); 
    }); 
}); 
	function search(){
		var begintime = document.all.startTime.value;
		var endtime = document.all.endTime.value;
		var dotype = $("select[id=dotype]").val();
		var reasons1 = $("select[id=reasons1]").val();
		var reasons2 = $("select[id=reasons2]").val();

		var isShow = "";
		$("input[id=isShow]").each(function() {
			if($(this).attr("checked") == true) {
				isShow = $(this).val();
			}
		});
		var supplierName = EncodeUtf8(document.getElementById("supplierName").value);
		var goodsCategoryName = EncodeUtf8(getSelectText("goodscategoryid"));
		var nonconformingCauseName = EncodeUtf8(getSelectText("reasons1"));
		var nonconformingPhenomenon = EncodeUtf8(getSelectText("reasons2"));
		var disposalMethods = EncodeUtf8(getSelectText("dotype"));
		
		if(begintime == "" || endtime == ""){
			alert('请选择日期');
			return false;
		}else{
			if(checkForm(document.all.goodsForm)){
				var begindate = document.getElementById("startTime").value;
				var enddate = document.getElementById("endTime").value;
				var goodsquantityid = document.getElementById("goodscategoryid").value;
				var supplierid = document.getElementById("supplierID").value;
	
				var DataURL = "report.action?reportlet=storage_NonconformingSumAnalysis.cpt&begindate="+begindate
						+"&enddate="+enddate+"&categoryID="+goodsquantityid
						+"&supplierid="+supplierid+"&dotype="+dotype+"&reasonsa="+reasons1
						+"&reasonsb="+reasons2+"&supplierName="+supplierName+"&goodsCategoryName="+goodsCategoryName
						+"&nonconformingCauseName="+nonconformingCauseName+"&nonconformingPhenomenon="+nonconformingPhenomenon
						+"&disposalMethods="+disposalMethods+'&isShow='+isShow;                      
				var topRows = top.document.getElementById("total").rows;
				var topCols = top.document.getElementById("btmframe").cols;
				
				if(is_iPad()){
					showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					openWindowForReport(DataURL); 
				}
			}
		}
	}
	function clean(){
		goodsForm.reset();
		document.getElementById("startTime").value = "";
		document.getElementById("endTime").value = "";
		document.getElementById("goodscategoryid").value = "";
		document.getElementById("supplierID").value = "";
		document.getElementById("supplierName").value = "";
		document.getElementById("reasons1").value = "";
		document.getElementById("reasons2").value = "";
		document.getElementById("dotype").value = "";
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
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		showPopWin("","selBrandOpen.action?supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
	
	function showSubMenu(goodsid,obj) {  
    	if(obj==""){
    		$('#reasons2').load("getAjaxDate.action?id="+ goodsid);
    	}else{
    		$('#reasons2').load("getAjaxDate.action?id="+ goodsid +"&fnpid="+obj);
    	}
    }
	/**
	 * 获取select标签Text
	 */
	function getSelectText(selectId){
		if(!selectId) {
			alert("未找到select标签");
		} else {
			var selectObj = document.getElementById(selectId);
			var userSelectedIndex = selectObj.selectedIndex;
			var selectText = selectObj.options[userSelectedIndex].text
			if(userSelectedIndex == 0) {
				selectText = "";
			}
			var endIndex = selectText.indexOf("￥");
			if(endIndex > 0) {
				selectText = selectText.substring(0, endIndex-1);
			}
			return selectText;
		}
	}
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>日常业务类报表</TD>
            <TD align="left">
				<%@ include file="/commons/helpMovie.jsp" %>目前操作功能：不合格品分析表(报残、退回)
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text align=right colspan="5">&nbsp;</TD>
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
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
		  </TD>
		</TR>
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
			               <TD class="table_body">查询日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime"/> 
                                    <jsp:param name="toDate" value="endTime"/>                               
                               </jsp:include>
			               </TD>
			               <TD  height="26" class="table_body" width="9%">制造商</TD>
			               <TD  class="table_none" width="26%">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();"></li>
			               </TD>
			               <TD width="10%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryid" name="goodscategoryid">
								<option value="">---请选择---</option>
									<s:iterator value="goodsCategoryList">
										<option value="${bgcid}">${bgcgoodscategoryname}</option>
									</s:iterator>
							</select>
			               </TD>
                        </TR>
                        <TR>
                           <TD  height="26" class="table_body">不合格品原因</TD>
			               <TD  class="table_none">
				               <select id="reasons1" name="reasons1" dengji="id" onchange="showSubMenu(this.dengji,this.options[this.options.selectedIndex].value)"><option value="">请选择所属原因</option>';
	    	  						<s:iterator value="nonconformingProductMaxList">
	           							<OPTION value="${fnpid}">${fnpcontent}</OPTION>
	          						</s:iterator>
	          				   </select>
			               </TD>
			               <TD  height="26" class="table_body">不合格品现象</TD>
			               <TD  class="table_none">
			               	<select id="reasons2" name="reasons2">
			               		<option value="">请选择所属现象(0)</option>
        					</select>
			               </TD>
			               <TD  height="26" class="table_body">处置方式</TD>
			               <TD  class="table_none">
			               	<select id="dotype" name="dotype">
								<option value="">---请选择---</option>
								<option value="0">报残</option>
								<option value="1">退回</option>
							</select>
			               </TD>
                        </TR>
                        <TR>
			               <TD class="table_body" height="26">是否显示查询条件</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
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
