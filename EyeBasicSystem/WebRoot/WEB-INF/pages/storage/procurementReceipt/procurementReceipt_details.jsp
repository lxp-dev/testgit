<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$("input[name=checkedBrandid]").each(function(){
        	if($(this).val()=='${bid}'){
            	$(this).attr("checked",true);
        	}
        });

	});

	//条码批量打印
	function batPrintGoodsBarCode(){
		var flag = false;
		
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			var persons = $("input[id=person]");
			var barCodes = $("input[id=pcbarcode]");
			var goodsQuantitys = $("input[id=quantity]");
			var brandnames = $("input[id=brandname]");
			var sources = $("input[id=source]");
			var specs = $("input[id=spec]");
			var colors = $("input[id=color]");
			var retailprices = $("input[id=retailprice]");
			var guaranteeperiods = $("input[id=guaranteeperiod]");
			var batchs = $("input[id=batch]");
			
			var suffix;
			var barCount = 0;
			
			var barCode = new Array();
			var quantity = new Array();
			var brandname = new Array();
			var source = new Array();
			var spec = new Array();
			var color = new Array();
			var retailprice = new Array();
			var person = new Array();
			var guaranteeperiod = new Array();
			var batch = new Array();
			
			for(var i=0 ; i< barCodes.length; i++){
				if(ids[i].checked == true){
					person[person.length] = persons.val();
					barCode[barCode.length] = barCodes[i].value;
					quantity[quantity.length] = goodsQuantitys[i].value;
					
					brandname[brandname.length] = brandnames[i].value;
					source[source.length] = sources[i].value;
					spec[spec.length] = specs[i].value;
					color[color.length] = colors[i].value;
					retailprice[retailprice.length] = retailprices[i].value;
					guaranteeperiod[guaranteeperiod.length] = guaranteeperiods[i].value;
					batch[batch.length] = batchs[i].value;
					/*alert(persons[0].value);
					alert(barCodes[i].value);
					alert(goodsQuantitys[i].value);
					alert(brandnames[i].value);
					alert(sources[i].value);
					alert(colors[i].value);
					alert(retailprices[i].value);
					alert(guaranteeperiods[i].value);
					alert(batchs[i].value);*/
					flag = true;
				}
			}

			if(flag == false){
				alert("请钩选要打印的商品条码！");
			}else{
				var printtype = {"1":"${systemParameterPo.fspframebarcodetype}"
					 ,"2":"${systemParameterPo.fsppartsbarcodetype}"
					 ,"3":"${systemParameterPo.fspglassbarcodetype}"
					 ,"4":"${systemParameterPo.fspstealthbarcodetype}"
					 ,"5":"${systemParameterPo.fspsolutionbarcodetype}"
					 ,"6":"${systemParameterPo.fspsunglassesbarcodetype}"
					 ,"7":"${systemParameterPo.fspconsumebarcodetype}"
					 ,"8":"${systemParameterPo.fspoldglassesbarcodetype}"
					 ,"9":"${systemParameterPo.fspmetropiabarcodetype}"};
				try {
					printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,guaranteeperiod,batch);
				} catch(e) {
					alert("打印失败!请检查条码打印机是否正确连接!");
					return;
				}
			}
		}
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
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
	window.onload = function(){
		var cstpgoodscategory = $('#cstpgoodscategory').val();
		isshow(cstpgoodscategory);
		amount();
	}

	function isshow(ordertype){
    	if(ordertype==""){
    		type = $('#cstpgoodscategory').val();
    	}else{
    		type = ordertype;
    		$('#cstpgoodscategory').val(ordertype);
    	}
    	
    	if(type == ""){
    		$('#div_goodslist').attr("style","display: none;");
    	}else{
    		if(type == "1"){
    			$('[id=spec]').show();
    			$('[id=specs]').show();
    			$('[id=ys]').show();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').show();
    			$('[id=kjcc]').show();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=xq]').hide();
    			$('[id=rksj').show();
    			
											    			
   			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","9");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","8");
				}
    		}else if(type == "2"){
    			$('[id=spec]').show();
    			$('[id=specs]').show();
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').show();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=xq]').hide();
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","7");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","6");
				}
    		}else if(type == "3"){
    			$('[id=spec]').hide();
    			$('[id=specs]').hide();
    			$('[id=ys]').hide();
    			$('[id=qj]').show();
    			$('[id=zj]').show();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').show();
    			$('[id=zsl]').show();
    			$('[id=gdfl]').show();
    			$('[id=clfl]').show();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();	
    			$('[id=xq]').hide();
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","11");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","10");
				}
    			
    		}else if(type == "4"){
    			$('[id=spec]').hide();
    			$('[id=specs]').hide();
    			$('[id=ys]').hide();
    			$('[id=qj]').show();
    			$('[id=zj]').show();
    			$('[id=ql]').show();
    			$('[id=zhj]').show();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').show();
    			$('[id=pqxfl]').show();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
    				$('[id=xq]').show();
					$('#heji').attr("colSpan","14");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('[id=xq]').hide();
					$('#heji').attr("colSpan","10");
				}
    			
    		}else if(type == "5"){
    			$('[id=spec]').show();
    			$('[id=specs]').show();
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').show();
    			$('[id=crl]').show();
    			$('[id=rksj').show();
    			
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
    				$('[id=xq]').show();
					$('#heji').attr("colSpan","11");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('[id=xq]').hide();
					$('#heji').attr("colSpan","7");
				}
    			
    		}else if(type == "6"){
    			$('[id=spec]').show();
    			$('[id=specs]').show();
    			$('[id=ys]').show();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').show();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=xq]').hide();
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","8");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","7");
				}
    			
    		}else if(type == "8"){
    			$('[id=spec]').show();
    			$('[id=specs]').show();
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').show();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').show();
    			$('[id=cjsh]').show();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=xq]').hide();
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","9");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","8");
				}
    			
    		}else if(type == "7"){
    			$('[id=spec]').show();
    			$('[id=specs]').show();
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=xq]').hide();
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","6");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","5");
				}
    			
    		}else if(type == "9"){
    			$('[id=spec]').show();
    			$('[id=specs]').show();
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=xq]').hide();
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","6");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","5");
				}
    			
    		}

    		$('#div_goodslist').attr("style","display:");
    	}
    }  
	function checkIsShowTable(){
		var ishowValue=$("input[name=isShowProcurementOrders]:checked").val();
		if(ishowValue=='1'){
			procurementReceiptForm.action = "procurementReceiptDetails.action?hid=${inventoryPo.cstibillid}&checkedtype=1";
			procurementReceiptForm.submit();
		}
		if(ishowValue=='2'){
			$('#addTable').attr("style","display: block;");
			$('#addTable1').attr("style","display: none;");
			$("table[isShowPrintBarcode=isShowPrintBarcode]").show();
		}
	}
    function save(){
    	$("img").removeAttr("onclick");
		procurementReceiptForm.action = "insertProcurementReceiptDeliveryid.action?";
		procurementReceiptForm.submit();
    }

    function queryCheckBrandGoodsInformation(){
        var bid=$("input[name=checkedBrandid]:checked").val();
        procurementReceiptForm.action = "procurementReceiptDetails.action?hid=${inventoryPo.cstibillid}&checkedBrandid="+bid+"&checkedtype=1";
		procurementReceiptForm.submit();
    }
    
    function selectWhichretail(){
		procurementReceiptForm.action = "procurementReceiptDetails.action";
		procurementReceiptForm.submit();
	}
</script>
<title>采购收货管理</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="cstpgoodscategory" id="cstpgoodscategory" value="${fn:substring(inventoryEntryList[0].cstiebarcode,0,1) }"> 
<input type="hidden" id="person" value="${person.id }"/>
<input type="hidden" id="hid" value="${inventoryPo.cstibillid}"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px;" 
          background=${ctx}/img/pic/tab_top_bg.gif>
          <TABLE width="100%" cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                    <c:if test="${statusPo.cshastatusapplybillid != null}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD width="95" class=tab id=tabLabel__1 onclick="JavaScript:window.location.href='allocationApplyDetails.action?hid=${statusPo.cshastatusapplybillid}';"                    
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">调拨申请单详细</TD>
                        <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                    <c:if test="${statusPo.cshastatusorderid != null}">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="95" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initProcurementOrdersView.action?hid=${statusPo.cshastatusorderid}'"
                      UNSELECTABLE="on">采购订单详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
					</c:if>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD width="95" class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">采购收货单详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    <c:if test="${statusPo.cshastatusbillid != null}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD width="95" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='allocationDetails.action?hid=${statusPo.cshastatusbillid}';"
                      UNSELECTABLE="on">商品调拨单详细</TD>
					    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                    </c:if>  
                    </TD>
                    <TD align="right" background=${ctx}/img/pic/tab_top_bg.gif>
                    	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
							<s:param name="actionTypeID">81</s:param>
                    		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_printgoods_0.png</s:param>
                    		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&inventoryid=${inventoryPo.cstibillid}</s:param>
                    		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&inventoryid=${inventoryPo.cstibillid}</s:param>
                    		<s:param name="actionReportTitle">采购收货单(按商品)打印</s:param>
                    	</s:action>
                    </TD>
                    <td width="5%" align="right" background=${ctx}/img/pic/tab_top_bg.gif>
                    	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
							<s:param name="actionTypeID">8</s:param>
                    		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_printbrand_0.png</s:param>
                    		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&inventoryid=${inventoryPo.cstibillid}</s:param>
                    		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&inventoryid=${inventoryPo.cstibillid}</s:param>
                    		<s:param name="actionReportTitle">采购收货单(按品种)打印</s:param>
                    	</s:action>
					</TR>
					</TBODY></TABLE>
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
					<table width="100%" id="title0"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center  border=0 class="privateBorder" style='TABLE-LAYOUT: fixed'>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD width="24%" class="table_none">&nbsp;${inventoryPo.cstibillid}<input type="hidden" name="hid" id="hid" value="${inventoryPo.cstibillid}"></TD>
                          <TD width="9%" class="table_body" height="26">订单单号</TD>
                          <TD width="24%" class="table_none">&nbsp;${inventoryPo.cstisourcebillid}</TD> 
                          <TD width="9%" class="table_body" height="26">商品类型</TD>
                          <TD class="table_none">&nbsp;${inventoryPo.cstigoodscategoryname }</TD>    
						</TR>
						<TR>
						  <TD class="table_body">制造商</TD>
						  <TD class="table_none">&nbsp;${inventoryPo.cstisuppliername}</TD>    
						  <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none" >&nbsp;${inventoryPo.csticreatepersonname}</TD>                  
						  <TD class="table_body" height="26">制单日期</TD>
                          <TD class="table_none">&nbsp;${fn:substring(inventoryPo.cstibilldate,0,16)}</TD> 
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none">&nbsp;${inventoryPo.cstiauditpersonname}
                          </TD>
                          <TD class="table_body" height="26">审核日期</TD>
                          <TD class="table_none">&nbsp;${fn:substring(inventoryPo.cstiauditdate,0,16)}
                          </TD>
                          <TD class="table_body" height="26">收入仓位</TD>
                          <TD class="table_none">&nbsp;${inventoryPo.cstiinstockname}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">运单号</TD>
                          <TD class="table_none" colspan="5">
                       	   <c:if test="${inventoryPo.cstifinanceauditstate==1}">
                        	  &nbsp;${inventoryPo.deliveryID }
                          </c:if>
                           <c:if test="${inventoryPo.cstifinanceauditstate!=1}">
                        	 <input class="text_input200" type="text" name="inventoryPo.cstideliveryid" maxlength="32" value="${inventoryPo.deliveryID }"/>
                          </c:if>
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5 style='word-WRAP: break-word'><label>
                          ${inventoryPo.cstiremark}&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<TABLE isShowPrintBarcode=isShowPrintBarcode id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          	  <li class="horizontal_onlyRight">
                          	  <select id="cstiwhichretail" name="inventoryPo.cstiwhichretail" onchange="selectWhichretail()">
	                            <c:if test="${systemParameterPo.fspretailprice=='1' }">
									<option value="1" ${whichretail == '1' ? 'selected':'' }>标准零售价格</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricea=='1' }">
									<option value="2" ${whichretail == '2' ? 'selected':'' }>零售价格2</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceb=='1' }">
									<option value="3" ${whichretail == '3' ? 'selected':'' }>零售价格3</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricec=='1' }">
									<option value="4" ${whichretail == '4' ? 'selected':'' }>零售价格4</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriced=='1' }">
									<option value="5" ${whichretail == '5' ? 'selected':'' }>零售价格5</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricee=='1' }">
									<option value="6" ${whichretail == '6' ? 'selected':'' }>零售价格6</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricef=='1' }">
									<option value="7" ${whichretail == '7' ? 'selected':'' }>零售价格7</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceg=='1' }">
									<option value="8" ${whichretail == '8' ? 'selected':'' }>零售价格8</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceh=='1' }">
									<option value="9" ${whichretail == '9' ? 'selected':'' }>零售价格9</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricei=='1' }">
									<option value="10" ${whichretail == '10' ? 'selected':'' }>零售价格10</option>
								</c:if>
	                      	  </select> 
	                      	  </li>
	                          <c:if test="${inventoryPo.cstiauditstate==1 }"> 
	                          <li class="horizontal_onlyRight">
	                          <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
						      onClick="javascript:batPrintGoodsBarCode();">
						      </li>
						      </c:if>
						  </c:if>
                         </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                     <div id="showProcurementOrders" align="left">
                    	<input type="radio"  name="isShowProcurementOrders" value="1" onclick="checkIsShowTable();" ${systemParameterPo.fspshowdwandtable != '1' ? '':'checked' }>二维模式显示单据&nbsp;
                    	<input type="radio" name="isShowProcurementOrders" value="2" onclick="checkIsShowTable();" ${systemParameterPo.fspshowdwandtable != '2' ? '':'checked' }>表单模式显示单据
                    </div>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table  id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" style="display: none;">
                      <TBODY>
                        <TR class=table_title align=middle> 
                         <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                    
                          <TH width="14%" scope=col>商品代码</TH>
                         
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col id=spec>型号</TH>
                         <TH width="6%" scope=col id=ys>色号</TH>
                          <TH width="6%" scope=col id=qj>球镜</TH>
                          <TH width="6%" scope=col id=zj>柱镜</TH>
                          <TH width="6%" scope=col id=xjg>下加光</TH>
                          <TH width="6%" scope=col id=zsl>折射率</TH>
                          <TH width="6%" scope=col id=gdfl>光度分类</TH>
                          <TH width="6%" scope=col id=clfl>材料分类</TH>
                          <TH width="6%" scope=col id=ql>曲率</TH>
                          <TH width="6%" scope=col id=zhj>直径</TH> 
                          <TH width="6%" scope=col id=kjcz>框架材质</TH>
                          <TH width="6%" scope=col id=kjcc>框架尺寸</TH>
                          <TH width="6%" scope=col id=pjlx>配件型 </TH>
                          <TH width="6%" scope=col id=sylx>使用类型  </TH>
                          <TH width="6%" scope=col id=pqxfl>抛弃型分类  </TH>
                          <TH width="6%" scope=col id=lhjds>老花镜度数 </TH>
                          <TH width="6%" scope=col id=cjsh>厂家色号 </TH>
                          <TH width="6%" scope=col id=zrl>主容量 </TH>
                          <TH width="6%" scope=col id=crl>次容量 </TH>
                          <TH width="8%" scope=col id=xq>效期</TH>
                          <TH width="5%" scope=col id=xq>批号</TH>
                          <TH width="5%" scope=col id=xq>注册证号</TH>
                          <TH width="6%" scope=col id=rksj>入库时间 </TH>
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
                          <TH width="8%" scope=col>商品条码</TH></c:if>
                          <TH width="5%" scope=col>数量</TH>                           
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26" id="heji" colSpan=12 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <c:choose>
                          	<c:when test="${goodsID==cstiegoodsid}">
	                    		<TR id="rowrow" class="row" style="background-color: red">
	                    	</c:when>
	                    	<c:otherwise>
	                    		<TR id="rowrow" class="row">
	                    	</c:otherwise>
                          </c:choose>                        
                        <TD height="28"><input id="chk" name="chk" type="checkbox" value="${cstiegoodsid}" ></TD>
                        <TD height="28">${cstiegoodsid}
                        <input type="hidden" id="goodsname" value="${cstiegoodsname}" />
                        <input type="hidden" id="source" value="${cstiesource}" />
                        <input type="hidden" id="spec" value="${cstiespec}" />
                        <input type="hidden" id="color" value="${cstiecolor}" />
                        <input type="hidden" id="retailprice" value="${cstieretailprice}" />
                        <input type="hidden" id="brandname" value="${cstiebrandname}" />
                        <input type="hidden" id="guaranteeperiod" value="${cstieguaranteeperiod}" />
                        <input type="hidden" id="batch" value="${cstiebatch}" />
                        </TD>
                       
                        <TD >${cstiegoodsname}</TD>
                        <TD id=specs>${cstiespec}</TD>
                         <td  id=ys>${cstiecolor}</td>
                          <td  id=qj>${cstiesph}</td>
                          <td  id=zj>${cstiecyl}</td>
                          <td  id=xjg>${bgibelowplusluminosity}</td>
                          <td  id=zsl>${bgirefractive}</td>
                          <td  id=gdfl> <c:if test="${bgiismutiluminosity=='M'}">  多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}"> 单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}"> 其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}"> 抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}"> 渐近</c:if>
                          </td>
                          <td id=clfl>	<c:if test="${bgieyeglassmaterialtype=='1'}"> 树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}"> 玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}"> PC</c:if>		</td>
                          <td id=ql>${cstiecurvature1}</td>
                          <td id=zhj>${cstiedia}</td> 
                          <td id=kjcz>${bgiframematerialtypename}</td>
                          <td id=kjcc>${bgiframesize}</td>
                          <td id=pjlx> 	<c:if test="${bgiaccessoriestype=='1'}"> 框镜</c:if>
		                          	<c:if test="${bgiaccessoriestype=='2'}"> 隐形</c:if></td>
                          <td id=sylx><c:if test="${bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${bgiusetype=='2'}">抛弃型</c:if>
		                          		<c:if test="${bgiusetype=='3'}">塑形镜</c:if> </td>
                          <td id=pqxfl>	<c:if test="${bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${bgistealthclass=='7'}"> RGP</c:if>
		                          	<c:if test="${bgistealthclass=='8'}"> 塑形镜</c:if>	   
		                          	</td>
                          <td id=lhjds>${cstiesph}</Td>
                          <td id=cjsh>${bgisuppliercolor} </Td>
                          <td id=zrl>${bgicapacity}  </Td>
                          <Td id=crl>${bgicapacityentry}  </Td>
                        <TD id=xq>${cstieguaranteeperiod}</TD>
						<TD id=xq>${cstiebatch}</TD>
						<TD id=xq>${cstieregistrationnum}</TD>
						<Td id=rksj>${fn:substring(inventoryPo.cstibilldate,0,10)}<input type="hidden"  id="bgirksj"  readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="${fn:substring(inventoryPo.cstibilldate,0,10)}" /></Td>
						 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
                        <TD>${cstiebarcode}<input type="hidden" id="pcbarcode" name="goodsInfoTempPo.pcbarcode" value="${cstiebarcode}"/></TD>
                        </c:if>
                        <TD>${cstiegoodsquantity}<input type="hidden" id="quantity" name="goodsInfoTempPo.goodsquantity" value="${cstiegoodsquantity}"/></TD>                                                                        
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
 					<table height="400px;"  id="addTable1" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" style="display: none;">
                      <TBODY>
                      	<TR>
	                      	  <td height="8" id="checkB">
		                      	<s:iterator value="goodsList" status="idx">
				                      	<input type="radio"   name="checkedBrandid" value="${bgibrandid }" onclick="queryCheckBrandGoodsInformation();"> ${bgibrandname }&nbsp;&nbsp;&nbsp;&nbsp;
			                      </s:iterator>
		                      </td>
		                </TR>
                      <TR class=table_title align=middle>
	                      <td height="auto" style="overflow: auto" vAlign=top>
	                      	<DIV id="pf" >
	                   		   	<iframe  id="reportFrame" src="report.action?reportlet=storage_procurementOrdersRpt3.cpt&poID=${inventoryPo.cstibillid }&brandid=${bid}" width="100%" height="100%"></iframe>
	                      	</DIV>
	                      </td>
                      </TR>
                      </TBODY>
                    </table>
                  </DIV>
                  <c:if test="${inventoryPo.cstifinanceauditstate!=1}">
                   <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
                          		<li class="horizontal_onlyRight">                          		 
                          		    <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();">                          		
                          		</li>
                           	</TD>
					   </TR>
                    </TABLE>
                    </c:if>
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
</body>
<script type="text/javascript">
var cstpgoodscategory = $('#cstpgoodscategory').val();
isshow(cstpgoodscategory);
amount();
if($('#cstpgoodscategory').val()!=3&&$('#cstpgoodscategory').val()!=4){
	$("#showProcurementOrders").hide();
	$('#addTable').attr("style","display: block;");
	$('#addTable1').attr("style","display: none;");
}else{
	if(${iscustomizeSandH}==1){
		$("#showProcurementOrders").hide();
		$('#addTable').attr("style","display: block;");
		$('#addTable1').attr("style","display: none;");
	}else{
		var ishowValue=$("input[name=isShowProcurementOrders]:checked").val();
		if(ishowValue=='1'){
			$('#addTable').attr("style","display: none;");
			$('#addTable1').attr("style","display: block;");
			$("table[isShowPrintBarcode=isShowPrintBarcode]").hide();
		}
		if(ishowValue=='2'){
			$('#addTable').attr("style","display: block;");
			$('#addTable1').attr("style","display: none;");
			$("table[isShowPrintBarcode=isShowPrintBarcode]").show();
		}
	}
}
</script>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>