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

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        }); 
	}); 

	function search(){
		if(checkForm(goodsForm)){
			var categoryid = $('#goodsCategoryID').val();
			var brandid = $('#brandID').val();
			var supplierid = $('#supplierID').val();
			var goodsTypeName = getSelectText();
			var brandName = $('#brandName').val();
			var supplierName = $('#supplierName').val();
			var isShow = "";
			$("input[id=isShow]").each(function() {
				if($(this).attr("checked") == true) {
					isShow = $(this).val();
				}
			});
			
			var DataURL = "report.action?reportlet=L_StorageEstimateSalesGrossProfitRateByGoods.cpt&categoryid="+categoryid+"&brandid="+brandid+"&supplierid="+supplierid+"&goodsTypeName="+EncodeUtf8(goodsTypeName)+"&brandName="+EncodeUtf8(brandName)+"&supplierName="+EncodeUtf8(supplierName)+'&isShow='+isShow; 
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				openWindowForReport(DataURL); 
			}
			document.getElementById('popupTitle').innerHTML="【存货产品预期销售毛利率统计表】";
		}		
	}
	
	function clean(){
		goodsForm.reset();	
	}

	/**
	 * 清空制造商和品种
	 */
	function changeGoodsCategory(){
		document.getElementById('supplierID').value = "";
		document.getElementById('supplierName').value = "";
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var goodsCategoryID = document.getElementById('goodsCategoryID').value;
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
		var goodsCategoryID = document.getElementById('goodsCategoryID').value;
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

	/**
	 * 获取select标签的text
	 */
	 function getSelectText(){

		var sel_obj = document.getElementById("goodsCategoryID");

		var index = sel_obj.selectedIndex;
		var selectText = sel_obj.options[index].text;
		if(selectText == '----请选择----') {
			selectText = '';
		} else {
			var startIndex = selectText.indexOf(")") + 1;
			selectText = selectText.substring(startIndex, selectText.length);
		}
		return selectText;

	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>${permissionPo.moduleName}</TD>
            
            <TD width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：存货产品预期销售毛利率统计表</TD>
            <TD>&nbsp;</TD>
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
			               <TD class="table_body">商品类别</TD>
			               <TD class="table_none">
			                 <select id="goodsCategoryID" name="goodsCategoryID" onchange="changeGoodsCategory()">
			                        <option value="">----请选择----</option>
                                <s:iterator value="goodsCategoryList">
								    <option value="${bgcid}">(${bgcid})${bgcgoodscategoryname}</option>
								</s:iterator>
							 </select>
			               </TD>
						   <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight">
						   		<input type="text" id="supplierName" class="text_input160" name="supplierName" readonly="readonly" />
						   		<input type="hidden" id="supplierID" name="supplierID"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						        <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openSupplier();">
						    </li>
			               </TD>
			               
			               <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" >
                              <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" />
						      </li>
						      <li class="horizontal_onlyRight">
						        <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						      </li>
			               </TD>
			               
                        </TR>
                        
                        <TR>
			               <TD height="26" class="table_body">是否显示查询条件</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" id="isShow" name="isShow" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow" name="isShow" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
                        </TR>
                        
                      </TBODY>
                    </TABLE>
            <c:if test="${permissionPo.keya eq '1'}">        
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                                <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
			</c:if>		
			<c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp">	
1.采购成本是从采购收货单结算中得到<br/>
2.基础成本是基础信息中商品的成本价格<br/>											
3.查询条件：销售门店（必选）、查询日期（必选）、商品类别、制造商、商品品种<br/>																		
4.根据选择的日期、门店，对制造商下每个品种的销售情况进行统计，并且每个制造商的品种按照销售数量进行排序
					</div>														
			</c:if>		
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
