<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>

<title>销售镜架</title>
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
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		
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
		sellMirrorFrameForm.action = "selectSellMirrorFrame.action";
		sellMirrorFrameForm.submit();
	}
	
/* 选择事件 */
	function setValue(json){
		try{
			parent.setCategory('镜架');
		}catch(e){
		
		}
		parent.addGoods(json);
		parent.hidePopWin();parent.toRound();
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
	if (event.keyCode == 13) {
		if (obj.value.length== 26 || obj.value.length == 5) {
			sellMirrorFrameForm.action = "selectSellMirrorFrame.action";
			sellMirrorFrameForm.submit();
		}else {
			alert('条码位数不符!');
			obj.value='';
			obj.focus();
			return;
		}
	}
}

//自架选择事件
function changeBarCode(obj) {
	var istakeframe = $('#istakeframe').val();
	
	if(istakeframe != ''&&istakeframe=='ZZ'){
		sellMirrorFrameForm.action = "selectSellMirrorFrame.action";
			sellMirrorFrameForm.submit();
	}else{
		$('#goodsbarcode').removeAttr("style");
		$('#goodsbarcode').removeAttr("disabled");
		$('[take=take]').remove();
	}
}


$(document).ready(function(){
	var istakeframe = $('#istakeframe').val();
	if(istakeframe != ''&&istakeframe=='ZZ'){
		$('#goodsbarcode').val('');
		$('#goodsbarcode').attr("disabled","disabled");
		$('#goodsbarcode').attr("style","background-color: #E0E0E0");
	}else{
		$('#goodsbarcode').removeAttr("style");
		$('#goodsbarcode').removeAttr("disabled");
	}
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
    <TD>
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
                            <input class="text_input200" id="goodsbarcode" name="goodsbarcode"  onkeypress="scanBarCode(this)" onkeyup="this.value=this.value.replace(/[^0-9|a-z|A-Z]/g, '')" onblur="this.value=this.value.replace(/[^0-9|a-z|A-Z]/g, '')" ononafterpaste="this.value=this.value.replace(/[^0-9|a-z|A-Z]/g, '')"  style="ime-mode:disabled">
                            <font color="red">按回车查询商品</font>
			            </TD>
                   </TR>
                   </TBODY>
                </TABLE>
                <c:if test="${not empty(goodsList)}"> 
                       <table width="100%" take=take  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
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
                     
					<table take=take  width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                    <TBODY>
                        <TR class=table_title align=middle>
						  <TH scope=col width="5%" height="26">选择</TH>
                          <TH scope=col width="15%">商品代码</TH>
                          <TH scope=col width="15%">商品名称</TH>
                          <TH scope=col width="15%">商品品种</TH>
                          <TH scope=col width="15%">商品价格</TH>
                          <TH scope=col width="15%">型号</TH>
                          <TH scope=col width="10%">颜色</TH>
                          <TH scope=col width="10%">商品数量</TH>
                        </TR>
                     <s:iterator  value="goodsList">
                        <TR class="row">
						  <TD  height="26">
		                     <input icon="icon-apply" id="goodsid" name="goodsid" type='button' value='选择' onClick="setValue({'bgigoodsid':'${bgigoodsid}','bgigoodsname':'${bgigoodsname}','bgiretailprice':'${bgiretailprice }','bgigoodsbarcode':'${pcBarcode }','bgicostprice':'${bgicostprice }','bginottaxrate':'${bginottaxrate }'});" />
						  </TD>
                          <TD>${bgigoodsid }</TD>
                          <TD>${bgigoodsname }</TD>
                          <TD>${bgibrandname }</TD>
                          <TD>${bgiretailprice }</TD>
                          <TD>${bgispec }</TD>
                          <TD>${bgicolor }</TD>
                          <TD>${bgigoodsquantity }</TD>
                          </TR>
                          </s:iterator>
                    </TBODY>
               </TABLE>
					 <!-- BEGIN 分页-->
						<div take=take id="dividePage" align="center">        
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