<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>含税单价调价管理</title>
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

	function save(){
	if(checkForm(document.all.adjustmentPriceForm)){ 
		$("img").removeAttr("onclick");
		adjustmentPriceForm.action = "adjustmentPriceUpdate.action";
		adjustmentPriceForm.submit();
		}
	}

	function adjustmentPrice_open(){
		var supplierID='';
		var categoryID_open='';	
		showPopWin("","initMoreAdjustmentPriceOpen.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	function openGoodSingle(){
		var supplierID='';
		var categoryID_open='';	
		showPopWin("","initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRow(goodInfos[goodsI]);
		}
		
	
	}
	
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) return;
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" id="goodsid" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname+ '<input type="hidden" id="goodsname" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgibrandname+ '<input type="hidden" id="goodsname" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" />';;
		c5.innerHTML = goodInfo.bgicostprice+ '<input type="hidden" id="retailprice" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" />';
		c6.innerHTML = '<input  type="text" name="goodsInfoTempPo.adprice" value="" class="text_input60" >';
		
		
		
		
		$('#del' + index).btn().init();

    }
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(a=0;a<goodsquantity.length;a++){
			if(goodsquantity[a].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[a].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}

    function deleteitem(){
    
    	
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}
		document.all.chks.checked = false;
		amount();
    }
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID='';

		//showPopWin("","selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
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
		document.getElementById('cstisupplierid').value = json.id;
		document.getElementById('cstisuppliername').value = json.value;
		
	}
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    function showSubMenu(obj) {  
    	$('#' + 'cshaainstockid').load("getAjaxStock.action?id="+ obj);
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="adjustmentPriceForm" method="post" action="">
<input type="hidden" name="bid" value="${bid}"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE width="100%" cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              		<TR><!--?Start-->
                    <td width=auto align="right" valign="top">
		             <s:action name="getFittingTemplateTypeInfo" executeResult="true">
						<s:param name="actionTypeID">30</s:param>
		           		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
		           		<s:param name="actionFinereportRequestString">&billid=${adcostPricePo.cpracbillid}</s:param>
		           		<s:param name="actionReportingServiceRequestString"></s:param>
		           		<s:param name="actionReportTitle">商品含税成本调价单打印</s:param>
		             </s:action>                        
                    </td>
                  	</TR>
			  </TBODY></TABLE></TD>
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26">
                          <TD width="10%" class="table_body">单据编号</TD>
                          <TD width="23%" class="table_none">${adcostPricePo.cpracbillid }</TD> <TD width="10%" class="table_body">生效日期</TD>
                          <TD width="23%" class="table_none">${fn:substring(adcostPricePo.cpraceffectivedate,0,16) }&nbsp;</TD>
                        </TR>
                        <TR height="26">
             <TD width="10%" class="table_body">制单人</TD>
                          <TD width="24%" class="table_none">${adcostPricePo.cpraccreatepersonname }</TD>
                         <TD width="10%" class="table_body">制单日期</TD>
                          <TD width="23%" class="table_none">${fn:substring(adcostPricePo.cpraccreatedate,0,16) }</td>
                          
                        </TR>
                        <TR>
                          <TD class="table_body" height="60">备注</TD>
                          <TD class="table_none" colSpan=6>${adcostPricePo.cpracremark }&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table  id="addTable" width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">
                      <TBODY>
                      
                        <TR class=table_title align=middle>          
                          <TH width="20%" height="30" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>品种</TH>
                          <TH width="10%" scope=col>型号</TH>
                          <TH width="10%" scope=col>现成本价格</TH>
                          <TH width="10%" scope=col>调整价格</TH>
                          </TR>
                        <c:forEach var="adcostPriceEntry" items="${adcostPriceEntryList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						
                          <TD height="26">${adcostPriceEntry.cpracegoodsid }<input name="goodsInfoTempPo.goodsid" value="${adcostPriceEntry.cpracegoodsid }" type="hidden"/></TD>
						  <TD>${adcostPriceEntry.cpracegoodsname }<input name="goodsInfoTempPo.goodsname" value="${adcostPriceEntry.cpracegoodsname }" type="hidden"/></TD>
                          <TD>${adcostPriceEntry.cpracebrandname }<input name="goodsInfoTempPo.goodsbarcode" value="${adcostPriceEntry.cpracebbdbrandname }" type="hidden"/></TD>
                          <TD>${adcostPriceEntry.cpracespec }</TD>
                          <TD>${adcostPriceEntry.cpracecostprice}<input name="goodsInfoTempPo.costprice" value="${adcostPriceEntry.cpracecostprice}" type="hidden"/></TD>
                          <TD>${adcostPriceEntry.cpraceadprice }</TD>
                       
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                  
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>