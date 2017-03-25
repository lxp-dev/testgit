<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>其他入库</title>
</head>
<script>
//子页面删除单行
function openGoodSingleDeleteValues(objValue){
	var goodInfos = eval('(' + objValue + ')');
	
	for(var i = 0; i < goodInfos.length; i++){
		deleterow(goodInfos[i]);
		
	}
	
	amount();
}
function deleterow(goodInfo){
	// 商品id去重
	var table = document.getElementById('addTable');
	
	$("input[id=chk]").each(function(){
     	if($(this).val()== goodInfo.bgigoodsid){
		   $(this).parent().parent().remove();	
       }
	});
	
	amount();
} 
	//条码批量打印
	function batPrintGoodsBarCode(){
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			if(ids !== undefined){
				var barCodes = document.getElementsByName("goodsInfoTempPo.pcbarcode");
				var goodsQuantitys = document.getElementsByName("goodsInfoTempPo.goodsquantity");
				var suffix;
				var flag = false;
				for(var i=0 ; i< ids.length; i++){
					if(ids[i].checked == true){
						//alert(ids[i]);
						//suffix = getObjArrSuffix("ids",ids[i]);
						//alert(suffix);
						//printBarCode(barCodes[rowNumber-1].value,goodsQuantitys[rowNumber-1].value);
						//printBarCode(barCodes[i-1].value,goodsQuantitys[i-1].value);
						//alert(barCodes[i].value);
						//setTimeout(alert(barCodes[i].value),500);
						//alert(barCodes[i].value);
						//alert(goodsQuantitys[i].value);
						try{
							printBarCode(barCodes[i].value,goodsQuantitys[i].value);
						} catch(e) {
							alert("打印失败!请检查条码打印机是否正确连接!");
							return;
						}
						
						flag = true;
					}
				}
				if(flag == false){
					alert("请钩选要打印的商品条码！");
				}
			}
		}
	}	

	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=goodsInfoTempPo.goodsquantity]").index(obj)+1;
		    $("input[name=goodsInfoTempPo.goodsquantity]").eq(index).focus();
		}
	}
	
	function barcodes(goodsid,goodsbarcode){
		if(goodsbarcode.value==''){
			return;
		}
		var tmp = goodsid.replace(/\./g,  "").toUpperCase();
		var tmp1 = goodsbarcode.value.substring(0,18);
		tmp1 = tmp1.toUpperCase();
		//alert(tmp1);
		if(tmp != tmp1){
			alert("商品不符！");
			goodsbarcode.value="";
			return;
		}
	}
	function save(){
	if(checkForm(document.all.otherReceiptForm)){ 
		var table = document.getElementById('addTable');
		
		//判断商品数量是否为空
		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		var goodsquantityCount=0;
		for(i=0;i<goodsquantityArray.length;i++){
			if(goodsquantityArray[i].value=="0"){
				alert("商品数量不能为0！");
				goodsquantityArray[i].focus();
				return;	
			}
			goodsquantityCount++;
		}
		if(goodsquantityCount==0){
          alert('请选择商品!');
          return false;
        }

		var pcbarcodeArray = document.getElementsByName("goodsInfoTempPo.pcbarcode");
		if (pcbarcodeArray != null){
			for(var j = 0; j < pcbarcodeArray.length; j++){
				if(pcbarcodeArray[j].value.length != 26){
					alert("商品条码有误，请重新扫描！");
					pcbarcodeArray[j].focus();
					return;	
				}
			}
		}	
        
		//验证商品类别和制造商是否与添加商品一样
		var supplierID=document.all.cstisupplierid.value;
		var chk=document.getElementsByName("chk");
		var length = chk.length;
		
		var re = new RegExp();
		re.compile("^[1-9]\." + supplierID);
		for(i = 0; i < length; i++){
			if(!re.test(chk[i].value.toUpperCase())){
				alert("制造商与添加的商品不匹配！");
		        return false;
			}		
		}
		var cstiauditstate=0;
		if (document.getElementsByName("inventoryPo.cstiauditstate")[0].checked==true){
		    cstiauditstate=1;
		}
		$("img").removeAttr("onclick");
		otherReceiptForm.action = "insertOtherReceipt.action?cstiauditstate="+cstiauditstate;
		otherReceiptForm.submit();
		}
	}
	
	function openGoodSingle(){
		var supplierID=document.all.cstisupplierid.value;
		var categoryID_open='7';
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?categoryID_open=" + categoryID_open + "&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?categoryID_open=" + categoryID_open + "&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【商品添加】";
	}
	
	function openOrders(){	
		var supplierID=document.all.cstisupplierid.value;
		var categoryID_open='';
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }
	    var billID=document.all.cstibillid.value;
	    var billType=billID.substring(0,3);
	    var poType='';
	    if(billType=='PIN'){
	       poType='P'
	    }else if(billType=='OTI'){
	       poType='Q'
	    }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementOrdersOpen.action?poType="+poType+"&supplierID=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementOrdersOpen.action?poType="+poType+"&supplierID=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【按采购订单添加商品】";
		
		
	}
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);			
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
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			var c7 = row.insertCell(6);
			var c8 = row.insertCell(7);
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			var c7 = row.insertCell(6);
		}
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgiunitname;
		c6.innerHTML = document.all.cstibilldate.value+'<input type="hidden" class="text_input100" maxlength="26" id="bgirksj" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="'+document.all.cstibilldate.value+'" />';
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c8.innerHTML = '<input type="text" class="text_input40" maxlength="18" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity"  onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			c7.innerHTML ='<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" name="goodsInfoTempPo.pcbarcode" value="'+goodInfo.bgipcbarcode+'" />';
	    
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c7.innerHTML = '<input type="text" class="text_input40" maxlength="18" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/><input type="hidden" name="goodsInfoTempPo.pcbarcode" value="' + goodInfo.bgipcbarcode +'" />';
		}
	}
	function openProcurementOrdersValues(objValue,poID){
		
		document.all.cstisourcebillid.value=poID;
		
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			addRow2(goodInfos[i]);
			
		}
		
	
	}
	
	function addRow2(goodInfo){
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
//		var c6 = row.insertCell(5);
//		var c7 = row.insertCell(6);
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			var c6 = row.insertCell(5);
			var c7 = row.insertCell(6);
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			var c6 = row.insertCell(5);
		}
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgiunitname;
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c7.innerHTML = '<input type="text" class="text_input40" maxlength="18" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			c6.innerHTML ='<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode+'" />';
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c6.innerHTML = '<input type="text" class="text_input40" maxlength="18" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/><input type="hidden" name="goodsInfoTempPo.pcbarcode" value="' + goodInfo.bgipcbarcode +'" />';	
		}
		amount();
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
    
    function check()
    {
      if(document.all.cstiauditstate1.checked==true)
      {
      	document.all.cstiauditstate.checked = true;	
      }else
      {
      	document.all.cstiauditstate.checked = false;	
      }
    }
    
     function check1()
    {
      if(document.all.cstiauditstate.checked==true)
      {
      	document.all.cstiauditstate1.checked = true;	
      }else
      {
      	document.all.cstiauditstate1.checked = false;	
      }
    }
    
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID='7';

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
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
	$(document).ready(function() { 
$("img[btn=btn]").attr("style","cursor: hand"); 
$("img[btn=btn]").mouseover(function () { 
$(this).attr("src",$(this).attr("src").replace("0","1")); 
}).mouseout(function () { 
$(this).attr("src",$(this).attr("src").replace("1","0")); 
}); 
});
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="otherReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="inventoryPo.cstisourcebillid" id="cstisourcebillid" value="${inventoryPo.cstisourcebillid}" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body">单据编号</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" id="cstibillid"  name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}" readonly="readonly"></TD>
                          <TD width="9%" class="table_body">入库类型</TD>
                          <TD width="24%" class="table_none">其它入库<input type="hidden" name="inventoryPo.cstibilltypeid" id="cstibilltypeid" value="7" /> 
						  </TD>
						  <TD width="9%" class="table_body">单据日期</TD>
                          <TD class="table_none">
                          <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input id="cstibilldate" name="inventoryPo.cstibilldate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>					       
						</TR>
						<TR>
						  <TD class="table_body">制造商</TD>
						   <TD class="table_none">
						   <li class="horizontal_onlyRight">
						   		<input id="cstisuppliername" class="text_input160" name="inventoryPo.cstisuppliername" value="${inventoryPo.cstisuppliername}" readonly="readonly" />
						   		<input type="hidden" id="cstisupplierid" name="inventoryPo.cstisupplierid" value="${inventoryPo.cstisupplierid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier()"> 
						  </li></TD>
                          <TD class="table_body">收入仓位</TD>
                          <TD class="table_none" >
                            <select id="cstiinstockid" name="inventoryPo.cstiinstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取收入仓位！'}]">
                               <option value="" ${'' == warehouseConfigurationPo.bwcstockid5 ? 'selected="selected"' : '' }>----请选择----</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${bwhid!= warehouseConfigurationPo.bwcstockid5 ? '' : 'selected="selected"' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${person.personName }<input type="hidden" name="inventoryPo.csticreateperson" value="${person.id}"></TD>

                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          <textarea id="textarea" name="inventoryPo.cstiremark"></textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
						 <!--  <img src="${ctx}/img/newbtn/btn_acgddaddgoods_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_acgddaddgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_acgddaddgoods_0.png');" title="按采购订单添加商品" 
						  onClick="javascript:openOrders();"> -->
						  <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品"  onClick="javascript:openGoodSingle();">
						  <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
						   <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn  title="打印条码" id="addGodos" onClick="javascript:batPrintGoodsBarCode();">
						   </c:if>  
						  <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          		<img id="button11" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</li>
                          	<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstiauditstate1" onclick="check()" >保存并审核
                          	</li>
                          </TD>
					   </TR>
                    </TABLE>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>型号</TH>
                          <TH width="10%" scope=col>计量单位</TH>
                          <TH width="10%" scope=col id=rksj>入库时间 </TH>
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH width="15%" scope=col>商品条码</TH> </c:if>         
                          <TH width="10%" scope=col>数量</TH>    
                                                   
                        </TR>
                        <TR class=table_title align=middle> 
                         <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  	<TH width="40%" height="26"  colSpan=7 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	</c:if>
						  	  <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
						  	<TH width="40%" height="26"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	</c:if>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          	
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</li>
                          	<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstiauditstate" name="inventoryPo.cstiauditstate" value="1" onclick="check1()">保存并审核
                          	</li>
                          </TD>
					   </TR>
                    </TABLE>
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