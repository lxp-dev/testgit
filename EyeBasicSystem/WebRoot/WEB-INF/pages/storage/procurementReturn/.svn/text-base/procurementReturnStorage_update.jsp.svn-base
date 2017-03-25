<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品退货</title>
</head>
<script>
//-----------向下复制数量-------------------------
var indexBasic=1;
function goodsquantityAdd(obj){
	var table = document.getElementById('addTable');
	var index = table.rows.length-1;
	var id = obj.getAttribute('goodsquantity');
	indexBasic = $("#addTable tr").length;
	if(confirm("是否向下复制数量?")){
		for(var i=parseInt(id.substring(13,id.length));i<parseInt(indexBasic);i++){
			if($('input[goodsquantity=goodsquantity'+i+']')){
				$('input[goodsquantity=goodsquantity'+i+']').val(obj.value);
			}
		}
		 return true;
	}else{
		return false;
	} 			
}
//-----------向下复制数量-------------------------

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
	
	
	//子页面删除单行
	function openGoodSingleDeleteValues1(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow1(goodInfos[i]);
			
		}
		
		amount();
	}
	
	function deleterow1(goodInfo){
		// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
	     	if($(this).val()== goodInfo.bgigoodsbarcode){
			   $(this).parent().parent().remove();	
	       }
		});
		
		amount();
	} 

	$(document).ready(function(){
		//StatusID：0代表负调拨
		var StatusID='${StatusID}';
		if(StatusID!=null)
		{
			$('[name=goodsInfoTempPo.goodsquantity]').each(function (){
				amount(this);
			});
		}
		amount();
	});

	function searchsBar(obj){
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

	function checkNumber(obj){
		if($(obj).val()>0){
		}else{
			$(obj).val('');
		}
	}
	function addRowUpdateNumber(goodInfo){
		   
		var table = document.getElementById('addTable');
		var index = 0;
		if(indexBasic==1){
			index = table.rows.length - 1;
		}
		else{
			index = indexBasic;
		}

        if (goodInfo.bgigoodsbarcode.length == 18){
        	goodInfo.bgigoodsbarcode = goodInfo.bgigoodsbarcode + '00000000';
        }
        
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsbarcode");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value != '' && chk[i].value.toUpperCase() == goodInfo.bgigoodsbarcode.toUpperCase()){
				return;
			}
			if (chk[i].value == '' && chk[i].getAttribute('goodsID').toUpperCase() == goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase()){
				return;
			}
		}
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
		</c:if>

		var requirequantity = '';
		if(typeof(goodInfo.requirequantity) != "undefined"){
			requirequantity = goodInfo.requirequantity;
		}

		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '"><input type="hidden" id="maxquantity" value="' + (parseFloat(goodInfo.bgigoodsquantitys)+parseFloat(goodInfo.bgiintransitgoodsnum))  +'" />';
        c2.innerHTML = goodInfo.bgigoodsid.toUpperCase() + '<input type="hidden" id="goodsid" index="'+goodInfo.bgigoodsid+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid.toUpperCase() +'" />';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" id="bgigoodsname" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec + '<input type="hidden" id="bgispec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />'; 
		c5.innerHTML = goodInfo.bgiunitname; 
		c6.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid.toUpperCase()+'","'+goodInfo.bgigoodsbarcode.toUpperCase()+'");\'><span name="maxquantitySpan">'+ goodInfo.cshaaemaxquantity+'</span></a><input type="hidden" id="maxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';
		var htmlStr = '';
		var goodsnumber = '';

		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 

		if(goodsnumber == '' && goodInfo.bgigoodsquantity != 0 && typeof(goodInfo.bgigoodsquantity) != "undefined"){
			goodsnumber = goodInfo.bgigoodsquantity;
		}
		
		
		if(goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5'){
			c7.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="" onblur="amount(this);blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
		}else{
			c7.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodsnumber+'" onblur="amount(this);blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
		}
		</c:if>
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
			c7.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" id="quantity" maxlength="18" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="" onblur="amountnull(this);blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>'+
							'<input type="hidden" id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value="'+goodInfo.bgigoodsbarcode+'"/>'+
							'<input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'+
							'<input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" />'+
							'<input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />';
		</c:if>
		indexBasic++;
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
		if(htmlStr == ''){
			htmlStr = '<input id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value="'+goodInfo.bgigoodsbarcode.toUpperCase()+'" goodsID="'+goodInfo.bgigoodsid.toUpperCase().replace(/\./g,'')+'">'; 			
		}
		htmlStr =  htmlStr+
					   	'<input type="hidden" id="spec" value="' + goodInfo.bgispec +'" />'+
					   	'<input type="hidden" id="color" value="' + goodInfo.bgicolor +'" />'+
					   	'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />'+
					   	'<input type="hidden" id="person" value="' + '${person.id}' +'" />'+
					   	'<input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />'+
					   	'<input type="hidden" id="source" value="' + goodInfo.bgisource +'" />'+

						'<input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'+
						'<input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" />'+
						'<input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />';
					   	
					   	if(goodInfo.guaranteeperiod && goodInfo.batch){
						   	c8.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="' + goodInfo.guaranteeperiod +'" />'+
						   	'<input type="hidden" id="batch" value="' + goodInfo.batch +'" />';
					   	}else{
					   		c8.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="" />'+
						   	'<input type="hidden" id="batch" value="" />';
					   	}
					   	
		c8.align="left";
		</c:if>
		status=status+1;
    }

	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=goodsInfoTempPo.goodsquantity]").index(obj)+1;
		    $("input[name=goodsInfoTempPo.goodsquantity]").eq(index).focus();
		}
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
			alert("商品位数不符！");
			goodsbarcode.value="";
			return;
		}
		if(goodsbarcode.value.length>26)
		{
			alert("商品位数不符！");
			goodsbarcode.value="";
			return;
		}
	}
	
	function save(){
		if(checkForm(document.all.otherReceiptForm)){ 
			if('${systemParameterPo.fspisfillindeliveryid}' == '1'){
				if(!$("#deliveryID").val().trim()){
					alert("请填写运单单号！");
					$("#deliveryID").focus();
					return;
				}
			}
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
			
			var barCodeArray = document.getElementsByName("goodsInfoTempPo.pcbarcode");
			for(j=0;j<barCodeArray.length;j++){
				if(barCodeArray[j].value ==""){
					alert("商品条码不能为空！");
					barCodeArray[j].focus();
					return;	
				}
			}
			
			if(goodsquantityCount==0){
	          alert('请选择商品!');
	          return false;
	        }
	        
			//验证商品类别和制造商是否与添加商品一样
			var supplierID=document.all.cstisupplierid.value;
			var chk=document.getElementsByName("chk");
			var length = chk.length;
			
			var re = new RegExp();
			re.compile("^[1-9]" + supplierID.toUpperCase());
			for(i = 0; i < length; i++){
				if(!re.test(chk[i].value.toUpperCase())){
					alert("制造商与添加的商品不匹配！");
					return;	
				}		
			}
			
			$('select[id=selectGbc]').each(function(){		
			    for(i=0;i<$(this).find("option").length;i++){
				    $(this).find("option")[i].selected='selected';
			    }
		    });
			
			var flag = 0;
			$('select[id=selectGbc]').each(function(){		   
			    if ($(this).find("option").length==0){
			        flag = 1;
			        alert("请填写商品条码!");
			        return false;
			    }
			});
			if (flag == 1){
			    return;
			}
	
			$('input[id=selectGbc]').each(function(){
				for(i=0;i<$(this).length;i++){
					$(this).val($(this).val().toUpperCase());				
				}
			});
	
			var strMessage = "";
	        $("input[name=goodsInfoTempPo.goodsquantity]").each(function (){
	        	if(parseFloat($(this).val())>parseFloat($(this).parent().parent().find("#maxquantity").val())){
	        		strMessage = strMessage+$(this).parent().parent().find("input[name=goodsInfoTempPo.goodsid]").val()+"\n";
				}
	        });
	        
	        if('${systemParameterPo.fspsalestype }' == '1'){
	            if(strMessage != ""){
	            	strMessage = "以下商品中存在商品数量大于可用库存数，是否确认提交？"
	            	if(confirm(strMessage)){
	            	}else{
						return;
	               	}
	            }
		 	}else{
		 		if(strMessage != ""){
	            	strMessage = "以下商品中存在商品数量大于可用库存数，会产生负库存！"
	            	alert(strMessage);
	            }
			}
			
			$("img").removeAttr("onclick");
			otherReceiptForm.action = "updateProcurementReturnStorage.action";
			otherReceiptForm.submit();
		}
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
		showPopWin("","initProcurementOrdersOpen.action?poType="+poType+"&supplierID=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}		
	
	function openGoodSingle(){
		var supplierID=document.all.cstisupplierid.value;
		var categoryID_open='';
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	

	    var stockid = $("#cstioutstockid").val();

	    if(!stockid){
			alert("请选择发出仓位！");
			$("#cstioutstockid").focus();
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var moduleID=document.all.moduleID.value;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelZT.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID + "&stockid="+stockid+"&isshowstealth=1"+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelZT.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID + "&stockid="+stockid+"&isshowstealth=1"+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(i = 0; i < goodInfos.length; i++){
			addRowUpdateNumber(goodInfos[i]);
		}

		amount();
		$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
			if('${permissionPo.keyf}'!='1'){
				$(this).attr("readonly","readonly");
			}
			$(this).bind("keyup",function(){
				$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
			});
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
				}else{
					$(this).val('');
				}
			});
		});

	    $("input[name=goodsInfoTempPo.goodsquantity]").each(function (){
			if(parseFloat($(this).val()) > parseFloat($(this).parent().parent().find("input[name=goodsInfoTempPo.cshaaemaxquantity]").val()) || $(this).val()==''){
				//$(this).parent().parent().attr("style","color: red;");
			}
		});
		
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
		//alert($(barCodeInputObj).parent().parent().find('.number').size())
		if($(barCodeInputObj).parent().parent().find('.number')[0].value == ''){
			$(barCodeInputObj).parent().parent().find('.number')[0].value = 0;
		}
		$(barCodeInputObj).parent().parent().find('.number')[0].value=accAdd(Number($(barCodeInputObj).parent().parent().find('.number')[0].value),1);
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
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
			if($(barCodeInputObj).parent().parent().find('.number')[0].value == ''){
				$(barCodeInputObj).parent().parent().find('.number')[0].value = 0;
			}
			$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){			   
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
			document.getElementById('scancode').value="";
		}
	}
	
	function removeOption(item){
		$(item).parent().find('.gbc').find('option:selected').remove();
		$(item).parent().parent().find('.number')[0].value=$(item).parent().find('.gbc option').size();
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
	}
	
	//扫描商品条码事件
	function scanBarCode(obj) {
		if (event.keyCode == 13) {
			if (obj.value === ''||obj.value.length<26) {
				alert('条码位数不符!');
				obj.value='';
				obj.focus();
				return;
			}else {
				searchBar(obj.value);
				obj.focus();
			}
		}
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
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		onBlurBarCode1(getinput,goodidval);
		document.getElementById('scancode').value="";
		
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
         	if($(this).val()== goodInfo.bgigoodsbarcode){
			   $(this).parent().parent().remove();	
           }
		});
		
		amount();
    } 
	
	var index = 0;
	function addRow(goodInfo){
		  
		var table = document.getElementById('addTable');
		var index = 0;
		if(indexBasic==1){
			index = table.rows.length - 1;
		}
		else{
			index = indexBasic;
		}
		
		// 商品id去重
		var chk=document.getElementsByName("goodsInfoTempPo.goodsbarcode");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value != '' && chk[i].value.toUpperCase() == goodInfo.bgigoodsbarcode.toUpperCase()){
				if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
					getMaxQuantity(chk[i],goodInfo);
				}
				
				return;
			}		
			if (chk[i].value == '' && chk[i].getAttribute('goodsID').toUpperCase() == goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase()){
				if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
					getMaxQuantity(chk[i],goodInfo);
				}
				return;
			}
			
		}

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
		</c:if>

		var requirequantity = '';
		if(typeof(goodInfo.requirequantity) != "undefined"){
			requirequantity = goodInfo.requirequantity;
		}

		if((goodInfo.bgigoodsid.substring(0,1)=='4' || goodInfo.bgigoodsid.substring(0,1)=='5') && ('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2')){
            requirequantity = getRequirequantity(goodInfo.bgigoodsbarcode);
		}
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '"><input type="hidden" id="maxquantity" value="' + accAdd(Number(goodInfo.bgigoodsquantitys),Number(goodInfo.bgiintransitgoodsnum))  +'" />';
        c2.innerHTML = goodInfo.bgigoodsid.toUpperCase() + '<input type="hidden" id="goodsid" index="'+goodInfo.bgigoodsid+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid.toUpperCase() +'" />';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" id="bgigoodsname" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec + '<input type="hidden" id="bgispec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />'; 
		c5.innerHTML = goodInfo.bgiunitname; 
		c6.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'",'+index+');\'><span name="maxquantitySpan">'+ goodInfo.cshaaemaxquantity + '</span></a><input type="hidden" id="maxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';
					  
		var htmlStr = '';
		var goodsnumber = '';
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 

		if(goodsnumber == '' && goodInfo.bgigoodsquantity != 0 && typeof(goodInfo.bgigoodsquantity) != "undefined"){
			goodsnumber = goodInfo.bgigoodsquantity;
		}		

		if(goodInfo.bgigoodsid.substring(0,1)=='2'||goodInfo.bgigoodsid.substring(0,1)=='5'||goodInfo.bgigoodsid.substring(0,1)=='7'||goodInfo.bgigoodsid.substring(0,1)=='9'){
			c7.innerHTML = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodsnumber+'" onblur="amount(this);blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
		}else{
			c7.innerHTML = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" value="'+goodsnumber+'" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="" onblur="amount(this);compareQuantity(this);blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
		}
		</c:if>
		<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
			c7.innerHTML = '<input type="text" class="text_input60 number" id="quantity" style="text-align:center;" goodsquantity="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="" onblur="amountnull(this);blackToRed(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>'+
							'<input type="hidden" id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value="'+goodInfo.bgigoodsbarcode+'"/>'+
							'<input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'+
							'<input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" />'+
							'<input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />';
		</c:if>
		indexBasic++;
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
		if(htmlStr == ''){
			htmlStr = '<input id="selectGbc'+index+'" pid="pcbarcode" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value="'+goodInfo.bgigoodsbarcode+'" goodsID="'+goodInfo.bgigoodsid.replace(/\./g,'')+'">'; 
		}
		htmlStr =  htmlStr+
					   	'<input type="hidden" id="spec" value="' + goodInfo.bgispec +'" />'+
					   	'<input type="hidden" id="color" value="' + goodInfo.bgicolor +'" />'+
					   	'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />'+
					   	'<input type="hidden" id="person" value="' + '${person.id}' +'" />'+
					   	'<input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />'+
					   	'<input type="hidden" id="source" value="' + goodInfo.bgisource +'" />'+

						'<input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'+
						'<input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" />'+
						'<input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />';
						
					   	if(goodInfo.guaranteeperiod && goodInfo.batch){
						   	c8.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="' + goodInfo.guaranteeperiod +'" />'+
						   	'<input type="hidden" id="batch" value="' + goodInfo.batch +'" />';
					   	}else{
					   		c8.innerHTML = htmlStr + '<input type="hidden" id="guaranteeperiod" value="" />'+
						   	'<input type="hidden" id="batch" value="" />';
					   	}
		c8.align="left";
		</c:if>
		status=status+1;	
    }

    function getMaxQuantity(obj,goodInfo){
    	$(obj).parent().parent().find('input[name=goodsInfoTempPo.cshaaemaxquantity]')[0].value = goodInfo.cshaaemaxquantity;
    	$(obj).parent().parent().find('span[name=maxquantitySpan]')[0].innerHTML = goodInfo.cshaaemaxquantity;
    	$(obj).parent().parent().find('#guaranteeperiod').val(goodInfo.guaranteeperiod);
    	$(obj).parent().parent().find('#batch').val(goodInfo.batch);
    }
    
	function openProcurementOrdersValues(objValue,poID){
		
		document.all.cstisourcebillid.value=poID;
		
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
			if('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2'){	
				if(goodInfos[i].bgigoodsid.substring(0,1) == '4' || goodInfos[i].bgigoodsid.substring(0,1) == '5'){
					addRow2(goodInfos[i]);
				}else{
					addRowUpdateNumber(goodInfos[i]);
				}	
			}else{
				addRowUpdateNumber(goodInfos[i]);
			}
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
		redToBlack(getinput);
	}
	
	function addRow2(goodInfo){
			var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			//if (chk[i].value == goodInfo.bgigoodsid) return;
		}
		alert(goodInfo.bgigoodsid);
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgiunitname;
		c7.innerHTML = '<input type="text" class="text_input40" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" onblur="checkNumber(this);amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
		c6.innerHTML ='<input type="text" class="text_input200" onBlur="barcode(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode+'" />';
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
			if(goodsquantity[i].value == ''){
				goodsquantityTotal = parseFloat(goodsquantityTotal).add(0).toFixed(0);
			}else{
				goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
			}
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
	
	window.onload = function(){
		amount();
	};
	
   /**
	*  二维表开窗事件
	*/
	function open2D(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsOpen_dimensional.action?bspsuppliername="+EncodeUtf8($('#cstisuppliername').val())+"&cstpsupplierid="+$('#cstisupplierid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen_dimensional.action?bspsuppliername="+EncodeUtf8($('#cstisuppliername').val())+"&cstpsupplierid="+$('#cstisupplierid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【二维表查询】";
	}
	
	// 二维开窗赋值实现方法
	function openGoodsDimensionValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
		  if(goodInfos[i].v!=''){
			addDimensionRow(goodInfos[i]);	
		  }		
		}
		amount();	
	}
	
	function addDimensionRow(goodInfo){
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");	
		
		for (var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) {
				$('input[index=index'+indexval+']').val(obj);
				var getinput = $('input[index=index'+indexval+']')
				loadBarCode(getinput,goodInfo.bgigoodsid);
				return;
			}
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		if('${systemParameterPo.fspbarcodetype}'=='1'||'${systemParameterPo.fspbarcodetype}'=='2')
		{
			var c6 = row.insertCell(5);
			var c7 = row.insertCell(6);
		}
		if('${systemParameterPo.fspbarcodetype}'=='3')
		{
			var c6 = row.insertCell(5);
		}
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.goodsid + '" >';
        c2.innerHTML = goodInfo.goodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.goodsid +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" />';
        c3.innerHTML = goodInfo.goodsName;
		c4.innerHTML = goodInfo.spec;
		c5.innerHTML = goodInfo.unit;
		if('${systemParameterPo.fspbarcodetype}'=='1'||'${systemParameterPo.fspbarcodetype}'=='2')
		{
		c6.innerHTML = '<input type="text" readOnly="readOnly" class="text_input60 number" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodInfo.v+'" onblur="checkNumber(this);amount(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';
		c7.innerHTML = '<select id="selectGbc" name="goodsInfoTempPo.goodsbarcode"  multiple="multiple" class="text_input200 gbc" style="height:40px" onmousemove="this.style.height=\'100px\';" '+ ' onmouseout="this.style.height=\'30px\';"></select>'+
					'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.goodsid+'\');"/>'+
					'<img src="${ctx }/img/newbtn/btn_delete_0.png"   onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_delete_0.png\');" onclick="removeOption(this)">';	

		}
		if('${systemParameterPo.fspbarcodetype}'=='3')
		{
			c6.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)" value="'+goodInfo.v+'" onblur="checkNumber(this);amount(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
			'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.pcbarcode+'"/>';
		}
	}   
	
	function loadBar(obj){
		var indexval = null;
		var goodidval = null;
		var count = 0;
		$('input[name=goodsInfoTempPo.goodsbarcode]').each(function (){
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
			$('input[name=goodsInfoTempPo.goodsbarcode][goodsID='+indexval+']').val(obj.toUpperCase());
			getinput = $('input[name=goodsInfoTempPo.goodsbarcode][goodsID='+indexval+']');
		}

		loadBarCodeUpdateNumber(getinput,goodidval);		
		redToBlack(getinput);
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
		$(barCodeInputObj).parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
		barCodeInputObj.val('');
		barCodeInputObj.focus();
		if($(barCodeInputObj).parent().parent().find('.number')[0].value == ''){
			$(barCodeInputObj).parent().parent().find('.number')[0].value = 0;
		}
		$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){			   
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
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
		if(!$("#cstioutstockid").val()){
			alert("请选择发出仓位！");
			$("#cstioutstockid").focus();
			$("#cstioutstockid").select();
			return;
		}
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initScanBarcode.action?outstockid="+$("#cstioutstockid").val(),350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action?outstockid="+$("#cstioutstockid").val(),350,55,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【条码扫描】";
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () {
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		});
	});

	function openGoodBrand(){
		if($("#cstioutstockid").val() == ''){
			alert("请选择退货仓位！");
			$("#cstioutstockid").focus();
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelBrandForReturn.action?supplierID_open="+$("#cstisupplierid").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelBrandForReturn.action?supplierID_open="+$("#cstisupplierid").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}

	/**
	 * 开窗赋值实现方法
	 */
	function openValues3(objValue){
		otherReceiptForm.action="selStockGoodsForBrandUpdate.action?brandid="+objValue+"&outstockid="+$("#cstioutstockid").val();
		otherReceiptForm.submit();
	}

	function openInvisible(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initOpenInvisible.action?supplierID_open=" + '${inventoryPo.cstisupplierid}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initOpenInvisible.action?supplierID_open=" + '${inventoryPo.cstisupplierid}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【隐形商品效期查询】";
	}


	function redToBlack(obj){
		if(Number(obj.parent().parent().find("input[name=goodsInfoTempPo.goodsquantity]").val()) <= Number(obj.parent().parent().find("input[name=goodsInfoTempPo.cshaaemaxquantity]").val()) && obj.val()!=''){
			obj.parent().parent().attr("style","color: black;");
		}else{
			obj.parent().parent().attr("style","color: red;");
		}
	}

	function blackToRed(obj){
		if(Number($(obj).val()) > Number($(obj).parent().parent().find("input[name=goodsInfoTempPo.cshaaemaxquantity]").val()) || $(obj).val() == '' ){
			$(obj).parent().parent().attr("style","color: red;");
		}else{
			$(obj).parent().parent().attr("style","color: black;");
	    }
	}

    function getRequirequantity(barcode){

    }

 	function openGoodAllocation(flag){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initAllocationGoods.action?allflag="+flag+"&supplierID_open="+$("#cstisupplierid").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initAllocationGoods.action?allflag="+flag+"&supplierID_open="+$("#cstisupplierid").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨单查询】";
 	}

	/**
	 * 按负调拨单添加商品开窗赋值实现方法
	 */
	function openValues21(objValue,isShowBarcode){
		otherReceiptForm.action="reQueryGoodsAllocationBillsUpdate.action?billID="+objValue+"&isShowBarcode="+isShowBarcode;
		otherReceiptForm.submit();
	}
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="otherReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="cstisourcebillid" id="cstisourcebillid" value="${cstisourcebillid}" /> 

<input type="hidden" name="inventoryPo.cstisourcebillid" id="cstisourcebillid" value="${inventoryPo.cstisourcebillid}" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />


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
                    <TABLE cellSpacing=1 cellPadding=0 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR height="26">
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD width="24%" class="table_none">${inventoryPo.cstibillid}<input type="hidden" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}"></TD>
                          <TD width="9%" class="table_body">入库类型</TD>
                          <TD width="24%" class="table_none">采购退货                        
                          <input type="hidden" name="inventoryPo.cstibilltypeid" id="cstibilltypeid" value="${inventoryPo.cstibilltypeid}" /> 
						  </TD>
						  <TD width="9%" class="table_body" height="26">单据日期</TD>
                          <TD class="table_none">
                          ${fn:substring(inventoryPo.cstibilldate,0,10)}
                          <input class="text_input200" name="inventoryPo.cstibilldate" type="hidden" value="${fn:substring(inventoryPo.cstibilldate,0,10)}"/></TD>					       
						</TR>
						<TR height="26">
						  <TD class="table_body">制造商</TD>
						   <TD class="table_none">
                                ${inventoryPo.cstisuppliername}
                                <input type="hidden" id="cstisuppliername" name="inventoryPo.cstisuppliername" value="${inventoryPo.cstisuppliername}"/>
						   		<input type="hidden" id="cstisupplierid" name="inventoryPo.cstisupplierid" value="${inventoryPo.cstisupplierid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   		</TD>
                          <TD class="table_body" height="26">发出仓位</TD>
                          <TD class="table_none" >
                            <select id="cstioutstockid" name="inventoryPo.cstioutstockid">
      		                 <s:iterator value="warehouseList">
				               <option value="${bwhid}" ${inventoryPo.cstioutstockid == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${inventoryPo.csticreatepersonname}<input type="hidden" name="inventoryPo.csticreateperson" value="${inventoryPo.csticreateperson}"><input type="hidden" name="inventoryPo.csticreatepersonname" value="${inventoryPo.csticreatepersonname}"></TD>
                        </TR>
                        <TR height="26">
						  <TD class="table_body">运单号</TD>
						  <TD class="table_none" colspan="5">
						   		<input type="text" class="text_input160" maxlength="32" name="inventoryPo.deliveryID" id="deliveryID" value="${inventoryPo.deliveryID }" />
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
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${systemParameterPo.fspbarcodetype==3||systemParameterPo.fspbarcodetype==2}">
						  <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" 
						  onClick="javascript:openGoodSingle();">
						  </c:if>
						  <c:if test="${permissionPo.keyf == 1}">
						  <img src="${ctx}/img/newbtn/btn_addgoodsforbrand_0.png" btn=btn title="按品种库存添加商品" 
						  onClick="javascript:openGoodBrand();">
						  </c:if>
						  
	 					  <c:if test="${permissionPo.keyk == '1'}">
	 						  <img src="${ctx }/img/newbtn/btn_ReALLadd_0.png" btn=btn title="按负调拨单添加商品" onclick="openGoodAllocation('2');">
	 					  </c:if>
	 					  
					      <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
					      <c:if test="${systemParameterPo.fspstealtheffective != 0}">  
					      <img src="${ctx}/img/newbtn/btn_ayxxqcxaddgoods_0.png" btn=btn title="按隐形效期查询添加商品" onClick="javascript:openInvisible();">
					      </c:if>
					      <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
					      </c:if>
						  <img id="del1" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();"/>
                         </TD>                     
                         <TD align="left">
	                          <c:if test="${systemParameterPo.fspsalestype eq '0'}">   
	                             <font color="red" style="font-family: 微软雅黑">商品信息如果为红色,则表示该商品库存不足,不能完成商品退货操作!</font>
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
                        <TR class=table_title align=middle>
                          <TH width="7%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="16%" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>型号</TH>
                          <TH width="15%" scope=col>计量单位</TH>  
                          <TH scope=col width="7%">可用库存</TH>                          
                          <TH width="7%" scope=col>数量</TH>
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH width="15%" scope=col>商品条码</TH>
                          </c:if>
                        </TR>
                        <TR class=table_title align=middle> 
                        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  	<TH width="40%" height="26"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
						  	<TH scope=col width="5%" >&nbsp;</TH>
						  	</c:if>
						  	<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
						  	<TH width="40%" height="26"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
						  	</c:if>
				   		</TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${systemParameterPo.fspsalestype eq '0' && cstieoutstorageflag eq '0' && cstiemaxquantity2 lt 0 ? 'style="color: red"' : '' } >
                        <TD height="26">
                        <input id="chk" type="checkbox" value="${cstiebarcode}" >
                        </TD>
                        <TD>${cstiegoodsid}
                        <input type="hidden" index="${idx.index+1}"  name="goodsInfoTempPo.goodsid" value="${cstiegoodsid}" />                       
                        <!-- <input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="${cstiebarcode}" /> -->
                        <input type="hidden" name="goodsInfoTempPo.costprice" value="${cstiecostprice} " />
                        <input type="hidden" name="goodsInfoTempPo.nottaxrate" value="${cstienottaxrate} " />
                        <input type="hidden" name="goodsInfoTempPo.taxrate" value="${cstietaxrate} " />
                        </TD>
                        <TD>${cstiegoodsname}<input type="hidden" name="goodsInfoTempPo.goodsname" value="${cstiegoodsname}"/></TD>
                        <TD>${cstiespec}<input type="hidden" name="goodsInfoTempPo.spec" value="${cstiespec}" /></TD>
                        <TD>${cstieunitname}<input type="hidden" name="goodsInfoTempPo.unitname" value="${cstieunitname}" /></TD>
                        <TD><a href="javascript:getCallAbleNum('${cstiegoodsid}','${cstiebarcode}');"><span name="maxquantitySpan">${cstiemaxquantity}</span></a><input type="hidden" id="maxquantity" name="goodsInfoTempPo.cshaaemaxquantity" value="${cstiemaxquantity}" /></TD>
                       <td>
                       <c:if test="${systemParameterPo.fspbarcodetype==3}">
                        <input type="hidden" id="selectGbc" name="goodsInfoTempPo.goodsbarcode" value="<s:iterator value="allocationBarcodeLists"><c:if test="${cshabgoodsid eq cstiegoodsid}">${ cshabgoodsbarcode }</c:if></s:iterator>" />
                        <input type="text" class="text_input60 number" value="${cstiegoodsquantity}" name="goodsInfoTempPo.goodsquantity" goodsquantity="goodsquantity${idx.index+1 }" ondblclick="goodsquantityAdd(this)" onkeydown="OnKeyDownEnter(this)"  onblur="checkNumber(this);amount(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写正确的商品数量！'}]"/>
                       </c:if>
                       <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
	                     <c:if test="${systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2'}">
	                       <c:if test="${fn:substring(cstiegoodsid,0,1)!='4' && fn:substring(cstiegoodsid,0,1)!='5'}">
	                      	   <input  type="text" class="text_input60 number" style="text-align:center;" value="${cstiegoodsquantity}" goodsquantity="goodsquantity${idx.index+1 }" ondblclick="goodsquantityAdd(this)" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)"  onblur="checkNumber(this);amount(this);blackToRed(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写正确的商品数量！'}]"/>
	                       </c:if>
	                       <c:if test="${fn:substring(cstiegoodsid,0,1) eq '4' || fn:substring(cstiegoodsid,0,1) eq '5'}">
	                      	   <input  type="text" class="text_input60 number" style="text-align:center;" value="${cstiegoodsquantity}" goodsquantity="goodsquantity${idx.index+1 }" ondblclick="goodsquantityAdd(this)" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)"  onblur="checkNumber(this);amount(this);blackToRed(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写正确的商品数量！'}]" />
	                       </c:if>
	                     </c:if>
	                     <c:if test="${systemParameterPo.fspstealtheffective != '1' && systemParameterPo.fspstealtheffective != '2'}">
	                       	<input  type="text" class="text_input60 number" style="text-align:center;" value="${cstiegoodsquantity}" goodsquantity="goodsquantity${idx.index+1 }" ondblclick="goodsquantityAdd(this)" name="goodsInfoTempPo.goodsquantity" onkeydown="OnKeyDownEnter(this)"  onblur="checkNumber(this);amount(this);blackToRed(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写正确的商品数量！'}]"/>
	                     </c:if>
                       </c:if>
                      </td>
                       <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
                        <TD>
                        <c:if test="${systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2'}">
                   			<input id="selectGbc" name="goodsInfoTempPo.goodsbarcode" multiple="multiple" class="text_input200 gbc" value="${cstiebarcode }" readonly="readonly"  />
                   			<input index="index${idx.index+1}" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),'${cstiegoodsid}');"/>
						</c:if>
						<c:if test="${systemParameterPo.fspstealtheffective != '1' && systemParameterPo.fspstealtheffective != '2'}">
                   			<input id="selectGbc" name="goodsInfoTempPo.goodsbarcode" multiple="multiple" class="text_input200 gbc" value="${cstiebarcode }"  />
                   			<input index="index${idx.index+1}" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),'${cstiegoodsid}');"/>
						</c:if>
					    </TD>
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
                          	<c:if test="${(permissionPo.keyg==1)}">
                          	<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstiauditstate" name="inventoryPo.cstiauditstate" value="1">保存并审核
                          	</li>
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