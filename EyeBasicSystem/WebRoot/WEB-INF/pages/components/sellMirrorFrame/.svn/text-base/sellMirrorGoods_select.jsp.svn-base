<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>

<title>扫码商品</title>
</head>
<script>
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
    	var objOne = document.all[perPage_Select];
		document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
		sellMirrorFrameForm.action=link;
		sellMirrorFrameForm.submit();
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier()
	{
		//showPopWin("","selSupplierOpen.action?categoryID_open=1",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
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
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		//showPopWin("","selBrandOpen.action?categoryID_open=1&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open=1&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=1&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	 * 查看事件 
	 */
	function search(){
		$("img").removeAttr("onclick");
		sellMirrorFrameForm.action = "selectSellMirrorGoods.action";
		sellMirrorFrameForm.submit();
	}
	
/* 选择事件 */
	function setValue(json){
		window.parent.addRow(json);
		parent.hidePopWin();
	}
	
	/**
	 * 清空事件 
	 */
	function clean(){
		document.getElementById('goodsbarcode').value = "";
		document.getElementById('goodsname').value = "";
		document.getElementById('supplierName').value = "";
		document.getElementById('supplierID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('brandID').value = "";
	}

//扫描商品条码事件
function scanBarCode(obj) {
//
	if (event.keyCode == 13) {
		if (obj.value === ''||obj.value.length<26) {
			alert('条码位数不符!');
			obj.value='';
			obj.focus();
			return;
		}else {
			sellMirrorFrameForm.action = "selectSellMirrorGoods.action";
			sellMirrorFrameForm.submit();
		}
	}
}


$(document).ready(function(){
	$('#goodsbarcode').focus();
});
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="sellMirrorFrameForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="text" style="display: none"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>扫码选择商品</TD>
                    <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();parent.toRound();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：扫码选择商品</TD>
                      <TD class=menubar_function_text align=right>
                   <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                      </TR>
                    </TBODY>
                </TABLE>
			</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">扫码选择商品</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
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
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>          
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                    <TBODY>
               
                   <TR>
                      	<TD width="%15" height="30" class="table_body">商品条码</TD>
                      	<TD width="%35" class="table_none" colspan="3" >
                            <input class="text_input200" id="goodsbarcode" name="goodsbarcode" maxlength="26" onkeypress="scanBarCode(this)" onkeyup="this.value=this.value.replace(/[^0-9|a-z|A-Z]/g, '')" onblur="this.value=this.value.replace(/[^0-9|a-z|A-Z]/g, '')" ononafterpaste="this.value=this.value.replace(/[^0-9|a-z|A-Z]/g, '')"  style="ime-mode:disabled">
                            <font color="red">按回车查询商品</font>
			               </TD>
                      </TR>
                         </TBODY>
                </TABLE>
                <c:if test="${not empty(goodsList)}"> 
                       <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                     
                     <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
                     
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                    <TBODY>
                        <TR class=table_title align=middle>
						  <TH scope=col width="5%" height="30">选择</TH>
                          <TH scope=col width="15%">商品代码</TH>
                          <TH scope=col width="15%">商品名称</TH>
                          <TH scope=col width="15%">商品品种</TH>
                          <TH scope=col width="15%">商品价格</TH>
                          <TH scope=col width="15%">型号</TH>
                          <TH scope=col width="10%">颜色</TH>
                        </TR>
                     <s:iterator  value="goodsList">
                        <TR class="row">
						  <TD  height="28">
		                     <input icon="icon-apply" id="goodsid" name="goodsid" type='button' value='选择' onClick="setValue({'bgigoodsid':'${bgigoodsid}','bgigoodsname':'${bgigoodsname}','bgispec':'${bgispec}'});" />
						  </TD>
                          <TD>${bgigoodsid }</TD>
                          <TD>${bgigoodsname }</TD>
                          <TD>${bgibrandname }</TD>
                          <TD>${bgiretailprice }</TD>
                          <TD>${bgispec }</TD>
                          <TD>${bgicolor }</TD>
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