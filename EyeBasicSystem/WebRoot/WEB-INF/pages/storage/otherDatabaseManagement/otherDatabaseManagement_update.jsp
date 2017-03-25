<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>其它出库</title>
</head>
<script>
	function getCallAbleNum(goodsid,goodsbarcode){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("selGoodsSingleZTOpen.action?goodsID="+goodsid+"&goodscode="+goodsbarcode+"&stockid="+$('#cstioutstockid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selGoodsSingleZTOpen.action?goodsID="+goodsid+"&goodscode="+goodsbarcode+"&stockid="+$('#cstioutstockid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【商品可调用数量详细】";
	}

	function save(){
	if(checkForm(document.all.ReturnMerchandiseManagementForm)){ 
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
        
		$("img").removeAttr("onclick");
		ReturnMerchandiseManagementForm.action = "updateOtherDatabaseManagement.action";
		ReturnMerchandiseManagementForm.submit();
		}
	}



    function loadBarUpdateNumber(obj){
		var indexval = null;
		var goodidval = null;
	    var count = 0;
		$('input[name=goodsInfoTempPo.goodsbarcode]').each(function (){
			if($(this).val() != '' && obj.toUpperCase() == $(this).val().toUpperCase()){
				indexval = $(this).val();
				goodidval = $(this).val();
				count = 1;
			}
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}

		$('input[value='+indexval+']').val(obj.toUpperCase());
		getinput = $('input[value='+indexval+']');	
		
		loadBarCodeUpdateNumber(getinput,goodidval);
	}

    function loadBarCodeUpdateNumber(barCodeInputObj,goodsId){ 
		if(!barCodeInputObj.size > 0){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		} 
		if(barCodeInputObj.val().length<26)
		{
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().find('.gbc').val(barCodeInputObj.val().toUpperCase());
		if($(barCodeInputObj).parent().parent().find('.number')[0].value == ''){
			$(barCodeInputObj).parent().parent().find('.number')[0].value = 0;
		}
		$(barCodeInputObj).parent().parent().find('.number')[0].value=accAdd(Number($(barCodeInputObj).parent().parent().find('.number')[0].value),1);
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
		amount()
	}

	function openOrders(){	
		var supplierID=document.all.cstisupplierid1.value;
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
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}		
	function openGoodSingle(){

		var cstioutstockid= document.getElementById('cstioutstockid').value;
	    if(cstioutstockid==''){
	      alert('请选择发出仓位!');
	      document.getElementById('cstioutstockid').focus();
	      return false;
	    }	
	    
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsSingleSelZT.action?categoryID_open=7&stockid="+cstioutstockid ,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelZT.action?categoryID_open=7&stockid="+cstioutstockid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【商品添加】";
	}
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);			
		}
	}
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
	
	function barcode(goodsid,goodsbarcode){
		if(goodsbarcode.value==''){
			return;
		}
		
		var tmp = goodsid.replace(/\./g,  "").toUpperCase();
		var tmp1 = goodsbarcode.value.substring(0,18);
		tmp1 = tmp1.toUpperCase();

		if(goodsbarcode.value.length != 26){
			alert("条码格式有误！");
			goodsbarcode.value="";
			return;
		}
		
		if(tmp != tmp1){
			alert("商品不符！");
			goodsbarcode.value="";
			return;
		}
	}
	
    function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsbarcode) return;
		}
		
		var row = table.insertRow(table.rows.length);
		row.style.color = '';
		
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
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" index="'+index+'" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname+ '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec+ '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';
		c5.innerHTML = goodInfo.bgiunitname;
		c6.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'" );\'>' + goodInfo.cshaaemaxquantity + '</a><input type="hidden" index="'+index+'" id="cshaaemaxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c7.innerHTML = '<input type="text"  class="text_input60 number" maxlength="18" id="goodsquantity" name="goodsInfoTempPo.goodsquantity" value="" onblur="amount(this);checkNum(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			c8.innerHTML = '<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"  value="' + goodInfo.bgigoodsbarcode +'" readonly="readonly" onblur="barcode(\''+goodInfo.bgigoodsid+'\',this);this.value=this.value.toUpperCase()" maxlength="26" type="text" class="text_input200" name="goodsInfoTempPo.goodsbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c7.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" id="goodsquantity" name="goodsInfoTempPo.goodsquantity" value="" onblur="amount(this);checkNum(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/><input index="index'+index+'" value="' + goodInfo.bgigoodsbarcode +'" maxlength="26" type="hidden" name="goodsInfoTempPo.goodsbarcode" />';
		}

		amount();
		$("input[name='goodsInfoTempPo\\.goodsquantity']").each(function(){
			$(this).bind("keyup",function(){
				$(this).val();
			});	
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val();
				}else{
					$(this).val('');
				}
			});	
		});
    }

    function addRowUpdateNumber(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsbarcode) return;
		}
		
		var row = table.insertRow(table.rows.length);
		row.style.color = '';
		
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
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" index="'+index+'" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname+ '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec+ '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';
		c5.innerHTML = goodInfo.bgiunitname;
		c6.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'" );\'>' + goodInfo.cshaaemaxquantity + '</a><input type="hidden" index="'+index+'" id="cshaaemaxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c7.innerHTML = '<input type="text"  class="text_input60 number" maxlength="18" id="goodsquantity" name="goodsInfoTempPo.goodsquantity" value="" onblur="amount(this);checkNum(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			c8.innerHTML = '<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"  value="' + goodInfo.bgigoodsbarcode +'" readonly="readonly" onblur="barcode(\''+goodInfo.bgigoodsid+'\',this);this.value=this.value.toUpperCase()" maxlength="26" type="text" class="text_input200" name="goodsInfoTempPo.goodsbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c7.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" name="goodsInfoTempPo.goodsquantity" value="" onblur="amount(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/><input index="index'+index+'" value="' + goodInfo.bgigoodsbarcode +'" maxlength="26" type="hidden" name="goodsInfoTempPo.goodsbarcode" />';
		}

		amount();
    }

    
    function loadBar(obj){
		var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if(obj.toUpperCase().substring(0,18)==$(this).val().replace(/\./g,  "").toUpperCase()){
				indexval = $(this).attr("index");
				goodidval = $(this).val();
			}
			
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		loadBarCode(getinput,goodidval);
	}
	
	function loadBarCode(barCodeInputObj,goodsId){ 
		var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
		var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
		if(goodsId != barCode){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		} 
		if(barCodeInputObj.val().length<26)
		{
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();
	}
    
    function searchBar(obj){
		var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if(obj.toUpperCase().substring(0,18)==$(this).val().replace(/\./g,  "").toUpperCase()){
				indexval = $(this).attr("index");
				goodidval = $(this).val();
			}
		});
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		onBlurBarCode(getinput,goodidval);
	}
	
	function onBlurBarCode(barCodeInputObj,goodsId){
		if(event.keyCode==13){
			var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
			var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
			if(goodsId != barCode){
				alert("商品代码与商品条码不符！");
				barCodeInputObj.val('');
				return;
			} 
			
			if(barCodeInputObj.val().length<26)
			{
				alert("商品条码位数不符！");
				barCodeInputObj.val('');
				return;
			}
			
			$(barCodeInputObj).parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
			barCodeInputObj.val('');
			barCodeInputObj.focus();
			$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		}
	}
	
	function scanbarcode(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var cstisupplierid= document.getElementById('cstisupplierid1').value;
	    if(cstisupplierid==''){
	      alert('请选择领用部门!');
	      document.getElementById('cstisupplierid1').focus();
	      return false;
	    }
		var cstioutstockid= document.getElementById('cstioutstockid').value;
	    if(cstioutstockid==''){
	      alert('请选择发出仓位!');
	      document.getElementById('cstioutstockid').focus();
	      return false;
	    }
		if(is_iPad()){
			showPopWin("initScanBarcode.action?categoryid=7&outstockid="+document.getElementById('cstioutstockid').value,350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action?categoryid=7&outstockid="+document.getElementById('cstioutstockid').value,350,55,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【条码扫描】";
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
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			var c5 = row.insertCell(4);
			var c6 = row.insertCell(5);
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			var c5 = row.insertCell(4);
		}
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c5.innerHTML = '<input type="text" class="text_input40" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();checkNum(this);" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			c6.innerHTML ='<input type="text" class="text_input200" value="' + goodInfo.bgipcbarcode +'" readonly="readonly" onBlur="barcode(\''+goodInfo.bgigoodsid+'\',this);" maxlength="26" name="goodsInfoTempPo.pcbarcode" value="'+goodInfo.bgipcbarcode+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c5.innerHTML = '<input type="text" class="text_input40" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/> <input type="hidden" name="goodsInfoTempPo.pcbarcode" value="'+goodInfo.bgipcbarcode+'" />';
		}
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
		
		$("input[id=goodsquantity]").each(function(){
			goodsquantityTotal = accAdd(goodsquantityTotal,$(this).val());
		});
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
	
	window.onload = function(){
		$("input[name='goodsInfoTempPo\\.goodsquantity']").each(function(){
			$(this).bind("keyup",function(){
				$(this).val(
			//	$(this).val().replace(/[^0-9.][0-9]*/g,'')
				);
			});	
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val(
				//	$(this).val().replace(/[^0-9.][0-9]*/g,'')
					);
				}else{
					$(this).val('');
				}
			});	
		});
	};

	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		
		amount();
	});
	
	function checkNum(obj){
		var maxnum = $(obj).parent().parent().find("#cshaaemaxquantity");
		var num = $(obj);
		
		if(parseFloat(maxnum.val()) < parseFloat(num.val())){
			$(obj).parent().parent().css({color:"red"});
		}else{
			$(obj).parent().parent().css({color:""});
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="ReturnMerchandiseManagementForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="inventoryPo.cstisourcebillid" id="cstisourcebillid" value="${inventoryPo.cstisourcebillid}" /> 

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
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD width="24%" class="table_none">${inventoryPo.cstibillid}<input type="hidden" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}"></TD>
                          <TD width="9%" class="table_body">入库类型</TD>
                          <TD width="24%" class="table_none">其他出库
                          <input type="hidden" name="inventoryPo.cstibilltypeid" id="cstibilltypeid" value="${inventoryPo.cstibilltypeid}" /> 
						  </TD>
                        
						  <TD width="9%" class="table_body" height="26">单据日期</TD>
                          <TD class="table_none">
                          ${fn:substring(inventoryPo.cstibilldate,0,10)}
                          <input class="text_input200" name="inventoryPo.cstibilldate" type="hidden" value="${fn:substring(inventoryPo.cstibilldate,0,10)}"/></TD>					       
						</TR>
						<TR>
						  <TD class="table_body">领用部门</TD>
						   <TD class="table_none">
      	                   <select id="cstisupplierid1" name="inventoryPo.cstisupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '领用部门不能为空！'}]">
                                <option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${inventoryPo.cstisupplierid == bdpdepartmentid ? 'selected="selected"' : '' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
                          <TD class="table_body" height="26">发出仓位</TD>
                          <TD class="table_none" >
                            <select id="cstioutstockid" name="inventoryPo.cstioutstockid">
      		                <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">      		                
				               <option value="${bwhid}" ${inventoryPo.cstioutstockid == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >
                          	${inventoryPo.csticreatepersonname}
                          	<input type="hidden" name="inventoryPo.csticreateperson" value="${inventoryPo.csticreateperson}">
                          	<input type="hidden" name="inventoryPo.csticreatepersonname" value="${inventoryPo.csticreatepersonname}">
                          </TD>

                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          <textarea id="textarea" name="inventoryPo.cstiremark">${inventoryPo.cstiremark}</textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                           <c:if test="${systemParameterPo.fspbarcodetype==3||systemParameterPo.fspbarcodetype==2}"> 
						  <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
						  </c:if>
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
                       		</c:if>
                          <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
                          </TD>
                          <TD align="left">
	                          <c:if test="${systemParameterPo.fspsalestype eq '0'}">   
	                             <font color="red" style="font-family: 微软雅黑">商品信息如果为红色,则表示该商品库存不足,不能完成商品出库操作!</font>
	                          </c:if>   
                         </TD>
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
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="26">
						  <TH scope=col width="5%">全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
						  <TH width="15%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH width="6%" scope=col>计量单位</TH>  
                          <TH width="6%" scope=col>可用库存</TH>                         
                          <TH width="12%" scope=col>数量</TH>  
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                              <TH width="12%" scope=col>商品条码</TH>  
                           </c:if>        
                        </TR>
                        <TR class=table_title align=middle> 
                         	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  	<TH width="40%" height="26"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	</c:if>
						  	<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
						  	<TH width="40%" height="26"  colSpan=5 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	</c:if>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
					    	<TH scope=col width="5%"></TH>
				   		</TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${systemParameterPo.fspsalestype eq '0' && cstieoutstorageflag eq '0' && cstiemaxquantity2 lt 0 ? 'style="color: red"' : '' } >
                        <TD height="26"><input id="chk" type="checkbox" value="${cstiebarcode}" ></TD>
                        <TD>${cstiegoodsid}
                        <input type="hidden" name="goodsInfoTempPo.goodsid" index="${cstiegoodsid}" value="${cstiegoodsid}" />
                        <input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="${cstiebarcode}" />
                        <input type="hidden" name="goodsInfoTempPo.costprice" value="${cstiecostprice}" />
                        <input type="hidden" name="goodsInfoTempPo.nottaxrate" value="${cstienottaxrate}" />
                        <input type="hidden" name="goodsInfoTempPo.taxrate" value="${cstietaxrate}" />
                        </TD>
                        <TD>${cstiegoodsname}<input type="hidden" name="goodsInfoTempPo.goodsname" value="${cstiegoodsname}"/></TD>
                        <TD>${cstiespec}<input type="hidden" name="goodsInfoTempPo.spec" value="${cstiespec}" /></TD>
                        <TD>${cstieunitname}<input type="hidden" name="goodsInfoTempPo.unitname" value="${cstieunitname}" /></TD>
                        <TD><a href="javascript:getCallAbleNum('${cstiegoodsid}','${cstiebarcode}');">${cstiemaxquantity}</a><input type="hidden" index="${idx.index+1}" id="cshaaemaxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="${cstiemaxquantity}" /></TD>
                        
                        <TD><input type="text" class="text_input60 number" id="goodsquantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();checkNum(this);" value="${cstiegoodsquantity}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/><c:if test="${systemParameterPo.fspbarcodetype==3}"><input type="hidden"  index="index${cstiegoodsid}" name="goodsInfoTempPo.pcbarcode"  value='${cstiebarcode}' /></c:if></TD>     
                        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TD><input type="text"  index="index${cstiegoodsid}"  class="text_input200" onBlur="barcode('${cstiegoodsid}',this);" maxlength="26" name="goodsInfoTempPo.pcbarcode"  value='${cstiebarcode}' validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品条码！'}]"/></TD>                                                                    
                        </c:if>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</li>
                          	<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstiauditstate" name="inventoryPo.cstiauditstate" value="1">保存并审核
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