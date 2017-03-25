<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	initPriceAmount();
	});
	
	function initPriceAmount(){
		var goodsquantityTotal=0;
    	var nottaxrateamountTotal=0;
    	var costpriceamountTotal=0;
    	var takepriceamountTotal=0;
    	var taxamountTotal=0;
    	
    	var goodsquantityArray = $("input[name=goodsInfoTempPo.goodsquantity]");
    	var nottaxrateArray = $("input[name=goodsInfoTempPo.nottaxrate]");
    	var nottaxrateamountArray = $("input[name=goodsInfoTempPo.nottaxrateamount]");
    	var taxrateArray = $("input[name=goodsInfoTempPo.taxrate]");
    	var costpriceArray = $("input[name=goodsInfoTempPo.costprice]");
    	var costpriceamountArray = $("input[name=goodsInfoTempPo.costpriceamount]");
    	var taxamountArray = $("input[name=goodsInfoTempPo.taxamount]");
    	var takepriceArray = $("input[name=goodsInfoTempPo.cstietakeprice]");
    	var takepriceamountArray = $("input[name=goodsInfoTempPo.cstietakepriceamount]");
		for(i=0;i<goodsquantityArray.length;i++){
			goodsquantityTotal = (parseFloat(goodsquantityTotal)+parseFloat(goodsquantityArray[i].value)).toFixed(0);
			nottaxrateamountTotal = (parseFloat(nottaxrateamountTotal)+parseFloat(nottaxrateamountArray[i].value)).toFixed(2);
			costpriceamountTotal =(parseFloat(costpriceamountTotal)+parseFloat(costpriceamountArray[i].value)).toFixed(2);
			if(takepriceamountArray[i]){
				takepriceamountTotal =(parseFloat(takepriceamountTotal)+parseFloat(takepriceamountArray[i].value)).toFixed(2);
			}
			taxamountTotal = (parseFloat(taxamountTotal)+parseFloat(taxamountArray[i].value)).toFixed(2);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
		var taxamountSum = document.getElementById("taxamountTotal");
		if (taxamountSum != null){
			taxamountSum.innerText=taxamountTotal;
		}
		var nottaxrateamountSum = document.getElementById("nottaxrateamountTotal");
		if (nottaxrateamountSum != null){
			nottaxrateamountSum.innerText=nottaxrateamountTotal;
		}
		var costpriceamountSum = document.getElementById("costpriceamountTotal");
		if (costpriceamountSum != null){
			costpriceamountSum.innerText=costpriceamountTotal;
		}
		var takepriceamountSum = document.getElementById("takepriceamountTotal");
		if (takepriceamountSum != null){
			takepriceamountSum.innerText=takepriceamountTotal;
		}
	} 

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
    	
    	if(type == "11"){
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
					$('#heji').attr("colSpan","3");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","2");
				}
    		}else{
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
					$('#heji').attr("colSpan","3");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('[id=xq]').hide();
					$('#heji').attr("colSpan","1");
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
              <TR><!--?Start
                    <td width=auto align="right" valign="top">
                    	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
							<s:param name="actionTypeID">8</s:param>
                    		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
                    		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&inventoryid=${inventoryPo.cstibillid}</s:param>
                    		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&inventoryid=${inventoryPo.cstibillid}</s:param>
                    		<s:param name="actionReportTitle">采购收货单打印</s:param>
                    	</s:action>  
                    	</td> -->                 
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
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
                    <c:if test="${(permissionPo.keyf ne '1')}">
					<table  id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle> 
                         <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                    
                          <TH width="14%" scope=col>商品代码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>数量</TH>     
                          <TH width="8%" scope=col id=xq>效期</TH>
                          <TH width="5%" scope=col id=xq>批号</TH>
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
                          <TH width="8%" scope=col>商品条码</TH>
                          </c:if>
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26" id="heji" colSpan=3 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
					    	<TH scope=col width="5%">&nbsp;</TH>
					    	<c:if test="${(systemParameterPo.fspbarcodetype eq '1'|| systemParameterPo.fspbarcodetype eq '2') && inventoryPo.cstigoodscategory eq '4'}">
					    	<TH scope=col width="5%">&nbsp;</TH>
					    	<TH scope=col width="5%">&nbsp;</TH>
					    	</c:if>
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
                        <TD>${cstiegoodsquantity}<input type="hidden" id="quantity" name="goodsInfoTempPo.goodsquantity" value="${cstiegoodsquantity}"/></TD>
						 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
						 <TD id=xq>${cstieguaranteeperiod}</TD>
						<TD id=xq>${cstiebatch}</TD>
                        <TD>${cstiebarcode}<input type="hidden" id="pcbarcode" name="goodsInfoTempPo.pcbarcode" value="${cstiebarcode}"/></TD>
                        
                        </c:if>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    </c:if>
                    <c:if test="${(permissionPo.keyf eq '1')}">
                    <table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR class=table_title align=middle>                     
                          <TH scope=col width="15%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>
                          <TH scope=col width="10%">型号</TH>  
                           <TH scope=col width="8%">零售价</TH>                          
 						  <TH scope=col width="5%">数量</TH>	
 						  <TH scope=col width="10%">单位成本</TH>
						  <TH scope=col width="10%">成本合计</TH>
                          <TH scope=col width="5%">税率</TH>
						  <TH scope=col width="10%">含税单价</TH>                          
						  <TH scope=col width="10%">税额合计</TH>
						  <TH scope=col width="10%">价税合计</TH>				  
                        </TR>
                        <tr class=table_title align=middle> 
						  	<th width="40%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    	<th scope=col width="10%">&nbsp;</th>
					    	<th scope=col width="10%" id="nottaxrateamountTotal">&nbsp;</th>
					    	<th scope=col width="5%">&nbsp;</th>
					    	<th scope=col width="10%" >&nbsp;</th>					    	
					    	<th scope=col width="10%" id="taxamountTotal">&nbsp;</th>
					    	<th scope=col width="10%" id="costpriceamountTotal">&nbsp;</th>
				   		</tr>
				   		<s:iterator value="inventoryEntryList" status="idx">
	                        <TR class="row">
	                        <TD height="26">${cstiegoodsid}</TD>
	                        <TD>${cstiegoodsname}</TD>
	                        <TD>${cstiespec}</TD>
	                        <TD>${bgcretailPrice}</TD>
	                        <TD>${cstiegoodsquantity}<input type="hidden" value="${cstiegoodsquantity}" name="goodsInfoTempPo.goodsquantity"/></TD>                                               
	                        <TD>${cstienottaxrate}<input type="hidden" value="${cstienottaxrate}" name="goodsInfoTempPo.nottaxrate"/></TD>
	                        <TD>${cstienottaxrateamount}<input type="hidden" value="${cstienottaxrateamount}" name="goodsInfoTempPo.nottaxrateamount"/></TD>
	                        <TD>${cstietaxrate}<input type="hidden" value="${cstietaxrate}" name="goodsInfoTempPo.taxrate"/></TD>
	                        <TD>${cstiecostprice}<input type="hidden" value="${cstiecostprice}" name="goodsInfoTempPo.costprice"/></TD>	                        
	                        <TD>${cstietaxamount}<input type="hidden" value="${cstietaxamount}" name="goodsInfoTempPo.taxamount"/></TD>
	                        <TD>${cstiecostpriceamount}<input type="hidden" value="${cstiecostpriceamount}" name="goodsInfoTempPo.costpriceamount"/></TD>
	                        </TR>                                               
                        </s:iterator>
                    </TABLE>
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