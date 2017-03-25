<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>不合格品单管理</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		amount();
	});

	function openOrders(){	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWindowNonformingOrderSel.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWindowNonformingOrderSel.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
	}	
	
	function save(){
		if(checkForm(document.all.nonconformingForm)){ 
			var table = document.getElementById('addTable');
			var index = table.rows.length-1;
			
			var goodsquantityArray = document.getElementsByName("nonconformingEntryArrayPo.cshanegoodsid");
			var goodsquantityCount=0;
			for(i=0;i<goodsquantityArray.length;i++){
				goodsquantityCount++;
			}
			if(goodsquantityArray==null||goodsquantityArray.length==0){
	          alert('请选择商品!');
	          return false;
	        }
	         
			$("img").removeAttr("onclick");
			nonconformingForm.action = "insertNonconformingTR.action";
			nonconformingForm.submit();
		}
		
	}
    
    function openGoodSingle(){
		var stockid = $("#cshanoutstockid").val();
		if(stockid == ''){
			alert("请选择申报仓位！");
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelZT.action?stockid="+stockid+"&isshowstealth=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelZT.action?stockid="+stockid+"&isshowstealth=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
  //子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);	
		}
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
	
 	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);			
		}
	}	   
   function deleteitem(){
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		var count=0;
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
				count++; 
			}
			  
		}
		if(count==0){
          alert('请选择商品!');
          return false;
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

	function addRowUpdateNumber(goodInfo,stateArray){
		var bsalesid = document.getElementById('bsalesid');
    		if(bsalesid!=""&&bsalesid!=null){
    			title1.deleteRow(title1.rows.length-1);
    		}
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
        
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("nonconformingEntryArrayPo.cshanebarcode");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value != '' && chk[i].value.toUpperCase() == goodInfo.bgigoodsbarcode.toUpperCase()){
				return;
			}
			if (chk[i].value == '' && chk[i].getAttribute('goodsID').toUpperCase() == goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase()){
				return;
			}
		}
		
    	var readonlyFlg=document.getElementById("autoCount");
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		</c:if>
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
		var c8 = row.insertCell(7);
		</c:if>
		row.className = 'row';
		row.height="26";
		
		if(goodInfo.bgigoodsbarcode.length < 26)
		{
			goodInfo.bgigoodsbarcode = goodInfo.bgigoodsbarcode+"00000000";
		}
		// 添加商品到列表 end	
   		c1.innerHTML = '<input  id="chk" name="chk" type="checkbox" goodsID="'+goodInfo.bgigoodsid.replace(/\./g,'')+'" value="' + goodInfo.bgigoodsbarcode + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsname" value="' + goodInfo.bgigoodsname +'" /><input type="hidden" name="nonconformingEntryArrayPo.cshanesalesdetailid" value="' + goodInfo.bsdetailsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
        var c4String='';
        
        var c5String='';
        var tmpString=goodInfo.bgigoodsbarcode;
        
		c4String = '<select  name="nonconformingEntryArrayPo.cshanereasons1" id="d' + table.rows.length +'" onchange="showSubMenu(this.id,this.options[this.options.selectedIndex].value)" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择所属原因！\'}]"><option value="">请选择所属原因</option>';
 		<c:if test="${not empty(nonconformingProductMaxList)}">
    	  <s:iterator value="nonconformingProductMaxList">
           c4String = c4String + '<OPTION value="${fnpid}">${fnpcontent}</OPTION>';
          </s:iterator>
          c4String = c4String + '</select>';
        </c:if>
        c4.innerHTML = c4String;
        c5String = c5String +  '<select id="id' + table.rows.length +'" name="nonconformingEntryArrayPo.cshanereasons2" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择所属现象！\'}]"><option value="">请选择所属现象(0)</option>';
        c5String = c5String + '</select>'; 
        c5.innerHTML = c5String;
           
		c6.innerHTML = '<input type="text" style="width:100%" name="nonconformingEntryArrayPo.cshaneremark" />';
		c7.innerHTML = '<input type="text" class="text_input60 number" name="nonconformingEntryArrayPo.cshanesgoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.ZINT, \'Message\' : \'请重新填写数量！\'}]" maxlength="10" onBlur="amount();"/>';
		
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
			c8.innerHTML = '<input type="text" class="text_input200 gbc" goodsID="'+goodInfo.bgigoodsid.replace(/\./g,'')+'" readonly="readonly" value="'+goodInfo.bgigoodsbarcode+'" onBlur="barcode(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" name="nonconformingEntryArrayPo.cshanebarcode"   validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			c9.innerHTML = '<select id="cshaneconsignmode" name="nonconformingEntryArrayPo.cshaneconsignmode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'处置方式不能为空！\'}]"><option value="0" selected  >报残</option><option value="1">退回</option></select>';
		</c:if>
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
			c8.innerHTML = '<select id="cshaneconsignmode" name="nonconformingEntryArrayPo.cshaneconsignmode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'处置方式不能为空！\'}]"><option value="0" selected  >报残</option><option value="1">退回</option></select>'+
			'<input type="hidden" value="'+goodInfo.bgigoodsbarcode+'"  name="nonconformingEntryArrayPo.cshanebarcode" />';	
		</c:if>
	}
  
	function addRow(goodInfo){
		var bsalesid = document.getElementById('bsalesid');
    		if(bsalesid!=""&&bsalesid!=null){
    			title1.deleteRow(title1.rows.length-1);
    		}
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;

		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("nonconformingEntryArrayPo.cshanebarcode");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value != '' && chk[i].value.toUpperCase() == goodInfo.bgigoodsbarcode.toUpperCase()){
				return;
			}
			if (chk[i].value == '' && chk[i].getAttribute('goodsID').toUpperCase() == goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase()){
				return;
			}
		}
		
    	var readonlyFlg=document.getElementById("autoCount");
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		</c:if>
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
		var c8 = row.insertCell(7);
		</c:if>
		row.className = 'row';
		row.height="26";

   		c1.innerHTML = '<input  id="chk" name="chk" type="checkbox" goodsID="'+goodInfo.bgigoodsid.replace(/\./g,'')+'" value="' + goodInfo.bgigoodsbarcode + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsname" value="' + goodInfo.bgigoodsname +'" /><input type="hidden" name="nonconformingEntryArrayPo.cshanesalesdetailid" value="' + goodInfo.bsdetailsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
        var c4String='';
        
        var c5String='';
        var tmpString=goodInfo.bgigoodsbarcode;
        
		c4String = '<select  name="nonconformingEntryArrayPo.cshanereasons1" id="d' + table.rows.length +'" onchange="showSubMenu(this.id,this.options[this.options.selectedIndex].value)" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择所属原因！\'}]"><option value="">请选择所属原因</option>';
 		<c:if test="${not empty(nonconformingProductMaxList)}">
    	  <s:iterator value="nonconformingProductMaxList">
           c4String = c4String + '<OPTION value="${fnpid}">${fnpcontent}</OPTION>';
          </s:iterator>
          c4String = c4String + '</select>';
        </c:if>
        c4.innerHTML = c4String;
        c5String = c5String +  '<select id="id' + table.rows.length +'" name="nonconformingEntryArrayPo.cshanereasons2" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择所属现象！\'}]"><option value="">请选择所属现象(0)</option>';
        c5String = c5String + '</select>'; 
        c5.innerHTML = c5String;
           
		c6.innerHTML = '<input type="text" style="width:100%" name="nonconformingEntryArrayPo.cshaneremark" />';
		c7.innerHTML = '<input type="text" class="text_input60 number" name="nonconformingEntryArrayPo.cshanesgoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.ZINT, \'Message\' : \'请重新填写数量！\'}]" maxlength="10" onBlur="amount();"/>';
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
			c8.innerHTML = '<input type="text" class="text_input200 gbc" readonly="readonly" value="' + goodInfo.bgigoodsbarcode + '" goodsID="'+goodInfo.bgigoodsid.replace(/\./g,'')+'" onBlur="barcode(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" name="nonconformingEntryArrayPo.cshanebarcode"   validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			c9.innerHTML = '<select id="cshaneconsignmode" name="nonconformingEntryArrayPo.cshaneconsignmode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'处置方式不能为空！\'}]"><option value="0" selected  >报残</option><option value="1">退回</option></select>';
		</c:if>
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
			c8.innerHTML = '<select id="cshaneconsignmode" name="nonconformingEntryArrayPo.cshaneconsignmode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'处置方式不能为空！\'}]"><option value="0" selected  >报残</option><option value="1">退回</option></select>'+
			'<input type="hidden" value="'+goodInfo.bgigoodsbarcode+'"  name="nonconformingEntryArrayPo.cshanebarcode" />';	
		</c:if>
	}

    function addRow1(goodInfo,stateArray){
    	var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("nonconformingEntryArrayPo.cshanebarcode");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value != '' && chk[i].value.toUpperCase() == goodInfo.bgigoodsbarcode.toUpperCase()){
				return;
			}
			if (chk[i].value == '' && chk[i].getAttribute('goodsID').toUpperCase() == goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase()){
				return;
			}
		}
		
    	var readonlyFlg=document.getElementById("autoCount");
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
			var c8 = row.insertCell(7);
			var c9 = row.insertCell(8);
		 </c:if>
		 <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
		 	var c8 = row.insertCell(7);
		 </c:if>
		row.className = 'row';
		row.height="26";

		// 添加商品到列表 end	
   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" goodsID="'+goodInfo.bgigoodsid.replace(/\./g,'')+'" value="' + goodInfo.bgigoodsbarcode + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsname" value="' + goodInfo.bgigoodsname +'" /><input type="hidden" name="nonconformingEntryArrayPo.cshanesalesdetailid" value="' + goodInfo.bsdetailsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
        var c4String='';
        var c5String='';
        var tmpString=goodInfo.bgigoodsbarcode;
		c4String = '<select  name="nonconformingEntryArrayPo.cshanereasons1" id="d' + table.rows.length +'" onchange="showSubMenu(this.id,this.options[this.options.selectedIndex].value)" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择所属原因！\'}]"><option value="">请选择所属原因</option>';
 		<c:if test="${not empty(nonconformingProductMaxList)}">
    	  <s:iterator value="nonconformingProductMaxList">
           c4String = c4String + '<OPTION value="${fnpid}">${fnpcontent}</OPTION>';
          </s:iterator>
          c4String = c4String + '</select>';
        </c:if>
        c4.innerHTML = c4String;
        
        c5String = c5String +  '<select id="id' + table.rows.length +'" name="nonconformingEntryArrayPo.cshanereasons2" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择所属现象！\'}]"><option value="">请选择所属现象(0)</option>';
        c5String = c5String + '</select>'; 
        c5.innerHTML = c5String;
           
		c6.innerHTML = '<input type="text" style="width:100%" name="nonconformingEntryArrayPo.cshaneremark"/>';
		c7.innerHTML = '<input type="text" value="'+goodInfo.bgigoodsNum+'" class="text_input60 number" name="nonconformingEntryArrayPo.cshanesgoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.ZINT, \'Message\' : \'请重新填写数量！\'}]" maxlength="10" onBlur="amount();"/>';
		
		 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
			c8.innerHTML = '<input type="text" class="text_input200 gbc" goodsID="'+goodInfo.bgigoodsid.replace(/\./g,'')+'" value="'+goodInfo.bgigoodsbarcode+'" onBlur="barcode(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" name="nonconformingEntryArrayPo.cshanebarcode"   validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" readonly="readonly"/>';
			c9.innerHTML = '<select id="cshaneconsignmode" name="nonconformingEntryArrayPo.cshaneconsignmode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'处置方式不能为空！\'}]"><option value="0" selected  >报残</option><option value="1">退回</option></select>';				
		</c:if>
		 <c:if test="${systemParameterPo.fspbarcodetype==3}">
		 	c8.innerHTML = '<select id="cshaneconsignmode" name="nonconformingEntryArrayPo.cshaneconsignmode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'处置方式不能为空！\'}]"><option value="0" selected  >报残</option><option value="1">退回</option></select>'+
		 	'<input type="hidden" value="'+goodInfo.bgigoodsbarcode+'"  name="nonconformingEntryArrayPo.cshanebarcode" />';				
		 </c:if>
	}

	function loadBar(obj){
		var indexval = null;
		var goodidval = null;
		var count = 0;
		$('input[name=nonconformingEntryArrayPo.cshanebarcode]').each(function (){
			if($(this).val() != '' && obj.toUpperCase() == $(this).val().toUpperCase()){
				indexval = $(this).val();
				goodidval = $(this).val();
				count = 1;
			}
			if($(this).val() == '' && $(this).attr('goodsID').toUpperCase().substring(0,18) == obj.toUpperCase().substring(0,18)){
				indexval = $(this).attr('goodsID');
				goodidval = $(this).attr('goodsID');
				count = 0;
			}
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		var getinput = null;
		if (count == 1){
			$('input[value='+indexval+']').val(obj.toUpperCase());
			getinput = $('input[value='+indexval+']');			
		}else{
			$('input[name=nonconformingEntryArrayPo.cshanebarcode][goodsID='+indexval+']').val(obj.toUpperCase());
			getinput = $('input[name=nonconformingEntryArrayPo.cshanebarcode][goodsID='+indexval+']');
		}

		loadBarCodeUpdateNumber(getinput,goodidval);		
	}

	function loadBarUpdateNumber(obj){
		var indexval = null;
		var goodidval = null;
	    var count = 0;
		$('input[name=nonconformingEntryArrayPo.cshanebarcode]').each(function (){
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

		amount();
	}

	function amount(){
		var total=0;
		$('input[name=nonconformingEntryArrayPo\\.cshanesgoodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
    }
	
	function barcode(goodsid,goodsbarcode){
		if(goodsbarcode.value==''){
			return;
		}
		var tmp = goodsid.replace(/\./g,  "").toUpperCase();
		var tmp1 = goodsbarcode.value.substring(0,18);
		tmp1 = tmp1.toUpperCase();
		if(tmp != tmp1){
			alert("商品不符！");
			goodsbarcode.value="";
			return;
		}
		if(goodsbarcode.value.length<26)
		{
			alert("商品位数不符,应为26位！");
			goodsbarcode.value="";
			return;
		}
		if(goodsbarcode.value.length>26)
		{
			alert("商品位数不符,应为26位！");
			goodsbarcode.value="";
			return;
		}
	}
	
    function showSubMenu(goodsid,obj){  
		var mm="i"+goodsid;
    	if(obj==""){
    		$('#' + mm).load("getAjaxDate.action?id="+ mm);
    	}else{  
    		$('#' + mm).load("getAjaxDate.action?id="+ mm +"&fnpid="+obj);
    	}
    }
    
    function showSubMenu1(goodsid,obj) {  
    	if(obj==""){
    		$('#' + goodsid).load("getAjaxDate.action?id="+ goodsid);
    	}else{  
    		$('#' + goodsid).load("getAjaxDate.action?id="+ goodsid +"&fnpid="+obj);
    	}
    }
    
   //按配镜单选择 
   
   function openGoodSingleValues1(objValue){
//   		deleteRows();
		var goodInfos = eval('(' + objValue + ')');
		addid(goodInfos[0]);
		for(var i = 0; i < goodInfos.length; i++){
			addRow1(goodInfos[i]);			
		}
		amount();
	}
    function addid(goodInfo,stateArray){
    		//var currRowIndex=event.srcElement.parentNode.parentNode.rowIndex;//获取当前索引
			//document.all.Table1.deleteRow(currRowIndex);//执行删除
    		var title1 = document.getElementById('title1');
    		var bsalesid = document.getElementById('bsalesid');
    		if(bsalesid!=""&&bsalesid!=null){
    			title1.deleteRow(title1.rows.length-1);
    		}
    		var row1 = title1.insertRow(title1.rows.length);
	    	var tablec1=row1.insertCell(0);
	    	var tablec2=row1.insertCell(1);
	    	tablec1.innerHTML='关联单据';
	    	tablec2.innerHTML=goodInfo.bsalesid+'<input id="bsalesid" name="bsalesid" type="hidden" value="' + goodInfo.bsalesid + '" >';
	    	tablec1.className = 'table_body';
			tablec1.height="28";
			tablec2.className="table_none";
			tablec2.colSpan=5;
    }
    function deleteRows(){
    	var table = document.getElementById('addTable');
		if(table.rows.length>1){
			var count = table.rows.length;
    		for(var i=1;i<count;i++){
				table.deleteRow(1);
			}
    	}
    }
    
    function scanbarcode(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initScanBarcode.action",350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action",350,55,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【条码扫描】";
	}

    function isshowdiv(obj){
		if($(obj).attr("checked")){
			$("#isdb").show();
			$("#cshanisallocation").attr("checked","checked");
		}else{
			$("#isdb").hide();
			$("#cshanisallocation").attr("checked","");
		}
    }
</script>


<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="nonconformingForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1" class="table_body">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">单据编号TR</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160"  type="text" id="cshanbillid" name="nonconformingPo.cshanbillid" value="${nonconformingPo.cshanbillid}" readonly="readonly">
			               </TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none" width="24%">
			               	 <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input name="nonconformingPo.cshancreatedate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>
			               <TD width="9%" height="26" class="table_body">申报部门</TD>
			               <TD class="table_none">${person.bdpdepartmentname }
			               </TD>
						</TR>
                        <TR>
                           <td height="26" class="table_body">申报仓位</td>
                           <td class="table_none">
                           	<select id="cshanoutstockid" name="nonconformingPo.cshanoutstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择申报仓位！'}]">
						    <option value="">----请选择----</option>
      		                 <s:iterator value="warehousePos">
      		                   	<option value="${bwhid}" ${nonconformingPo.cshanoutstockid == bwhid ? 'selected="selected"':'' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                    </select>
                           </td>
                           <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">${person.personName }<input class="text_input100" type="hidden" name="nonconformingPo.cshancreateperson" value="${person.id }"></TD>
			               <TD height="26" class="table_body">责任人</TD>
			               <TD class="table_none">
			               <select id="cshanresponsibility" name="nonconformingPo.cshanresponsibility" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择责任人！'}]">
							<option value="">----请选择----</option>
							<c:if test="${not empty(responsibilityList)}">
			               	  <s:iterator value="responsibilityList">
                   	           <OPTION value="${id}" ${nonconformingPo.cshanresponsibility == id ? 'selected="selected"':'' }>${personName}</OPTION>
                   	          </s:iterator>
                   	        </c:if>
							</select>
			               </TD>
						   
                        </TR>  
                                           
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <img src="${ctx }/img/newbtn/btn_salesorder_0.png" btn=btn title="按配镜单添加商品" 
						  onClick="javascript:openOrders();">
						  <img src="${ctx }/img/newbtn/btn_goodsadd_0.png" btn=btn title="商品添加" 
						  onClick="javascript:openGoodSingle();">
						   <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						   <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
						   </c:if>
                          <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" ></TD>
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
                        <TR class=table_title align=middle>                     
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH scope=col width="15%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>						
                          <TH scope=col width="18%" colSpan=2>不合格品原因</TH>                          
 						  <TH scope=col width="15%">备注</TH>
 						  <TH scope=col width="4%">数量</TH>
 						  <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">	
 						  <TH scope=col width="20%">商品条码</TH></c:if>
 						  <TH scope=col width="7%">处理</TH>	
                        </TR>
                        <TR class=table_title align=middle>                     
                          <TH height="26" colspan="6" align="right">合计：</TH>
 						  <TH scope=col width="7%" id="goodsquantityTotal">0</TH>
 						  <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">	
 						  <TH></TH>
 						  </c:if>
 						  <TH></TH>	
                        </TR>
                        <s:iterator value="nonconformingEntryList" status="idx">
                        <TR class="row">
                        <TD height="28"><input id="chk" type="checkbox" goodsID="${fn:substring(cshanebarcode,0,18)}" value="${cshanebarcode}" ></TD>
                        <TD height="28">${cshanegoodsid}<input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsid" value="${cshanegoodsid}" /></TD>
                        <TD>${cshanegoodsname}<input type="hidden" name="nonconformingEntryArrayPo.cshanegoodsname" value="${cshanegoodsname}" /></TD>
                        <TD>
						<select name="nonconformingEntryArrayPo.cshanereasons1" onchange="showSubMenu1('${cshanebarcode}',this.options[this.options.selectedIndex].value)" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属原因！'}]">
						<option value="">请选择所属原因</option>
				 		<c:if test="${not empty(nonconformingProductMaxList)}">
				    	  <s:iterator value="nonconformingProductMaxList">
				           <OPTION value="${fnpid}" ${cshanereasons1== fnpid ? 'selected="selected"' : '' } >${fnpcontent}</OPTION>
				          </s:iterator>				         
				        </c:if>
				        </select>
						</TD>
                        <TD>
						<select id="${cshanebarcode}" name="nonconformingEntryArrayPo.cshanereasons2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属现象！'}]">
				           <option value="">请选择所属现象</option>
				           <s:iterator value="nonconformingProductMinList">
				               <c:if test="${cshanereasons1 == fnpparented}">
				                   <OPTION value="${fnpid}" ${cshanereasons2 == fnpid ? 'selected="selected"' : '' }>${fnpcontent}</OPTION>
				               </c:if>
				           </s:iterator>				           
				        </select>
						</TD>                        
                        <TD><input type="text" style="width:100%" name="nonconformingEntryArrayPo.cshaneremark" value="${cshaneremark}"/><input type="hidden" name="nonconformingEntryArrayPo.cshanesalesdetailid" value="${cshanesalesdetailid }"/>
                         </TD>
                         
                         <TD>
                            <input type="text" class="text_input60 number" name="nonconformingEntryArrayPo.cshanesgoodsquantity" value="${cshanegoodsquantity}" validate="[{'Type' : Type.String, 'Formula' : Formula.ZINT, 'Message' : '请重新填写数量！'}]" maxlength="10" onBlur="amount();"/>
                         </TD>
                         
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                         <td><input type="text" class="text_input200 gbc" onBlur="barcode('${cshanegoodsid }',this)" maxlength="26" name="nonconformingEntryArrayPo.cshanebarcode"  value="${cshanebarcode }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品条码！'}]" readonly="readonly"/>
                         	 </td>
                         	 </c:if>
                         <td>
                         	<select id="cshaneconsignmode" name="nonconformingEntryArrayPo.cshaneconsignmode" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '处置方式不能为空！'}]">
      		                 	<option value="0" ${cshaneconsignmode == '0' ? 'selected="selected"' : '' }>报残</option>
      		                 	<option value="1" ${cshaneconsignmode == '1' ? 'selected="selected"' : '' }>退回</option>
      	                 	</select>
      	                  <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
      	                  <input type="hidden"  name="nonconformingEntryArrayPo.cshanebarcode"  value="${cshanebarcode }" />
      	                  </c:if>
                         </td>
                        </TR>
                       </s:iterator>
				   	</TABLE>
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                    	 <TR>
                          <TD align="left">
	                          <li class="horizontal_onlyRight">
							 	 <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
							  </li>
	                          <li class="horizontal_onlyRight">
	                         	 <input type="checkbox" onclick="isshowdiv(this)" id="cshanauditstate" name="nonconformingPo.cshanauditstate" value="1">保存并审核
	                          </li>
	                          &nbsp;&nbsp;&nbsp;&nbsp;
	                          <c:if test="${systemParameterPo.fspnongallocation == '2'}">
		                          <c:if test="${departmenttype != '2'}">
		                          <li class="horizontal_onlyRight">
		                         	 <div id="isdb" style="display: none;"><input type="checkbox" id="cshanisallocation" name="nonconformingPo.cshanisallocation" value="1">生成调拨单据</div>
		                          </li>
		                          </c:if>	                          
	                          </c:if>
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