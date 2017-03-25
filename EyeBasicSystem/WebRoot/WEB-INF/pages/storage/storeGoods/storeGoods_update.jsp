<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户批发调货管理</title>
</head>
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<script>
	function autoCountOnlyOne(obj){
		var goodsquantityTotal=0;
    	var nottaxrateamountTotal=0;
    	var costpriceamountTotal=0;
    	var taxamountTotal=0;
    	var indexObj=getObjArrSuffix(obj.name,obj);

    	var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
    	var takepriceArray = $("input[name=goodsInfoTempPo.cstietakeprice]");
    	var takepriceamountArray = $("input[name=goodsInfoTempPo.cstietakepriceamount]");
		 	
    	//nottaxrateArray[indexObj].value=parseFloat(accDiv(parseFloat(costpriceArray[indexObj].value),parseFloat(accAdd(accDiv(taxrateArray[indexObj].value,100),1)))).toFixed(6);
 	    nottaxrateamountArray[indexObj].value=parseFloat(goodsquantityArray[indexObj].value).mul(nottaxrateArray[indexObj].value).toFixed(2);
		costpriceamountArray[indexObj].value=parseFloat(goodsquantityArray[indexObj].value).mul(costpriceArray[indexObj].value).toFixed(2);
		taxamountArray[indexObj].value=(costpriceamountArray[indexObj].value-nottaxrateamountArray[indexObj].value).toFixed(2);
		if(takepriceamountArray[indexObj]){
			takepriceamountArray[indexObj].value=parseFloat(goodsquantityArray[indexObj].value).mul(takepriceArray[indexObj].value).toFixed(2);
			takepriceArray[indexObj].value = parseFloat(takepriceArray[indexObj].value).toFixed(2);
		}
		
		
		for(i=0;i<nottaxrateArray.length;i++){			
			goodsquantityTotal = (parseFloat(goodsquantityTotal)+parseFloat(goodsquantityArray[i].value)).toFixed(0);
			nottaxrateamountTotal = (parseFloat(nottaxrateamountTotal)+parseFloat(nottaxrateamountArray[i].value)).toFixed(2);
			costpriceamountTotal =(parseFloat(costpriceamountTotal)+parseFloat(costpriceamountArray[i].value)).toFixed(2);
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
		initPriceAmount();
	}
	
	/**
    * 初始化合计值
	* 参数
	*/
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

function autoCountJMD(obj){
	var goodsquantityTotal=0;
	var nottaxrateamountTotal=0;
	var costpriceamountTotal=0;
	var taxamountTotal=0;
	var indexObj=getObjArrSuffix(obj.name,obj);

	var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
	 	
	nottaxrateamountArray[indexObj].value=parseFloat(goodsquantityArray[indexObj].value).mul(nottaxrateArray[indexObj].value).toFixed(2);
	costpriceamountArray[indexObj].value=parseFloat(goodsquantityArray[indexObj].value).mul(costpriceArray[indexObj].value).toFixed(2);
	taxamountArray[indexObj].value=(costpriceamountArray[indexObj].value-nottaxrateamountArray[indexObj].value).toFixed(2);
	
	for(i=0;i<nottaxrateArray.length;i++){			
		goodsquantityTotal = (parseFloat(goodsquantityTotal)+parseFloat(goodsquantityArray[i].value)).toFixed(0);
		nottaxrateamountTotal = (parseFloat(nottaxrateamountTotal)+parseFloat(nottaxrateamountArray[i].value)).toFixed(2);
		costpriceamountTotal =(parseFloat(costpriceamountTotal)+parseFloat(costpriceamountArray[i].value)).toFixed(2);
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
}
	
$(document).ready(function() { 
	$("img[btn=btn]").attr("style","cursor: hand"); 
	$("img[btn=btn]").mouseover(function () { 
	$(this).attr("src",$(this).attr("src").replace("0","1")); 
	}).mouseout(function () { 
	$(this).attr("src",$(this).attr("src").replace("1","0")); 
	}); 
	autoCountAll();
	var total=0;
	$('input[name=goodsInfoTempPo.costpriceamount]').each(function(){
		total=accAdd(total,$(this).val());
	});
	$('#costpriceamountTotal').text(parseFloat(total).toFixed(2));
	autoCountAll();
});
function batchCheckQutity(thiz){
	if($(thiz).val()==''){
		alert("请填写商品数量");
		return;
	}
	if(confirm("是否将所有商品数量修改为"+$(thiz).val()+"?")){
		$('input[name=goodsInfoTempPo.goodsquantity]').each(function(){
			$(this).val($(thiz).val());
		});
	}
}
	function save(){
	if(checkForm(document.all.salesOutForm)){ 
		var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		if(index==0){
		  alert('请选择商品!');
		}

		if($("#textarea").val().length > 300) {
			alert("备注长度超过系统规定长度!");
			$("#textarea").select();
			return;
		}
		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		var goodsquantityCount=0;
		for(i=0;i<goodsquantityArray.length;i++){
			if(goodsquantityArray[i].value=="0"){
				alert("商品数量不能为0！");
				goodsquantityArray[i].focus();
				return;	
			}
			if(isNaN(goodsquantityArray[i].value)||goodsquantityArray[i].value<0){
				alert("商品数量只能为数字！");
				goodsquantityArray[i].focus();
				return;	
			}
			 var flag = 0;
			 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
			$('select[id=selectGbc]').each(function()
			{	   
			    if ($(this).find("option").length==0){
			        flag = 1;
			        alert("请填写商品条码!");
			        return false;
			    }
			});
			</c:if>
			if (flag == 1){
			    return;
			}
			goodsquantityCount++;
		}
		if(goodsquantityCount==0){
          alert('请选择商品!');
          return false;
        }
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
			var numberflag = 0;
			var checkbarcode = 0;
			$('select[id=selectGbc]').each(function(){
				for(j=0;j<$(this).find("option").length;j++){
					$(this).find("option")[j].selected='selected';
				}

				if($(this).find("option").length != Math.abs($(this).parent().parent().find(".number").val())){
					numberflag = numberflag + 1;
					alert("商品数量与条码不匹配！");
					return false;
				}

				if($(this).find("option").length == 0){
					checkbarcode = checkbarcode + 1;
				}
			});

			$("[id=selectGbc]").each(function (){
				if($(this).val() == ''){
					checkbarcode = checkbarcode + 1;
				}
			});

			if (numberflag == 1){
			    return;
			}

			if(checkbarcode != 0){
				alert("请扫描条码！");
				return;
			}
		</c:if>

		
		$("img").removeAttr("onclick");
		salesOutForm.action = "updateStoreGoods.action";
		salesOutForm.submit();
		}
		
	}
	function openGoodSingle(){
		var supplierID = '';
		var categoryID_open='';	
		var stockid = $("#cstioutstockid").val();

		if(!stockid){
			alert("请选择发出仓位！");
			$("#cstioutstockid").focus();
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelZT.action?jm=jm&categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID + "&stockid="+stockid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelZT.action?jm=jm&categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID + "&stockid="+stockid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
			addRowUpdateNumber(goodInfos[i]);
		}
		initPriceAmount();
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
		initPriceAmount();
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
    
    /**
	*	设定价格调试各Input元素的变化属性；
	*	goodsquantityStateArray 	：商品数量数组；
	*	nottaxrateStateArray		：单位成本数组；
	*	nottaxrateamountStateArray 	：成本合计数组；
	*	taxrateStateArray 			：税率数组；
	*	costpriceStateArray 		：含税单价数组；
	*	costpriceamountStateArray 	：价税合计数组；		
	*	taxamountStateArray 		：税额合计数组；			
	*	例子：goodsquantityStateArray =new Array(arg0,arg1,arg2,arg3);
	*	arg0：当自动计算时，是否只读；true表示只读；false表示非只读；
	*	arg1：当自动计算时，是否对onchange方法进行方法转换；"add"表示添加方法；"remove"表示移除方法；""空表示不进行操作；
	*	arg2：当手动计算时，是否只读；true表示只读；false表示非只读；
	*	arg3：当手动计算时，是否对onchange方法进行方法转换；"add"表示添加方法；"remove"表示移除方法；""空表示不进行操作；
	**/
	function getInputState(){	
		var goodsquantityStateArray =new Array(false,"autoCountJMD",false,"totalCount");
		var nottaxrateStateArray =new Array(true,"",false,"totalCount");
		var nottaxrateamountStateArray =new Array(true,"",false,"totalCount");
		var taxrateStateArray =new Array(false,"autoCountJMD",false,"totalCount");
		var costpriceStateArray =new Array(false,"autoCountJMD",false,"totalCount");
		var costpriceamountStateArray =new Array(true,"",false,"totalCount");
		var taxamountStateArray =new Array(true,"",false,"totalCount");
		var stateArray=new Array(goodsquantityStateArray,nottaxrateStateArray,nottaxrateamountStateArray,taxrateStateArray,costpriceStateArray,costpriceamountStateArray,taxamountStateArray);
		return stateArray;
	}  
	
		function barcode(goodsid,goodsbarcode){
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
	var index = 0;
	
	function addRow(goodInfo,stateArray){		
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

		var addtype="";
		for (var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsbarcode) {
				addtype="1";
				return;
			}
		}
		
		
		// 添加商品到列表 begin
    	var readonlyFlg=document.getElementById("autoCount");

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
	<c:if test="${permissionPo.keyf == 1}">	
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
		var c13 = row.insertCell(11);
		</c:if>
	</c:if>
	<c:if test="${permissionPo.keyf == 0}">	
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c13 = row.insertCell(8);
		c13.align="left";
		</c:if>
	</c:if>
		
		row.className = 'row';
		row.height="26";
		
		// 添加商品到列表 end	
   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec + '<input type="hidden" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';
		c5.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'" );\'>' + goodInfo.cshaaemaxquantity+'</a><input type="hidden" id="bgispec" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';

		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");

    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
    	
    	if(readonlyFlg.checked){
    	<c:if test="${permissionPo.keyf == 1}">	
    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
    			if(goodInfo.bgigoodsquantity > 0){
    				c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" ondblclick="batchCheckQutity(this);" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
    			}else{
    				c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
	    		}  			
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
				if(goodInfo.bgigoodsquantity > 0){
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" ondblclick="batchCheckQutity(this);" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';		
				}else{
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
					'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';		
				}
			</c:if>
			    c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c8.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
				c9.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发单价！\'}]"/>';
				c11.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的税额合计！\'}]"/><input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
		</c:if>	
		<c:if test="${permissionPo.keyf == 0}">	
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
			c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
			                + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'		
		   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';				
			c7.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
			c8.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
			c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
		              		+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'		
	   						+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
			c7.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
			c8.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />'+
							'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';	
			</c:if>
		</c:if>	

    	}else{
    	<c:if test="${permissionPo.keyf == 1}">	
    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
 			</c:if>	
 			<c:if test="${systemParameterPo.fspbarcodetype==3}">
 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+		
 								'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';	
 			</c:if>	
			c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
			c8.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
		    c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
			c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
			c11.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /> ';
		</c:if>
		<c:if test="${permissionPo.keyf == 0}">	
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'
					+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
					c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
					c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'
				    +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
				    c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
				    c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>'+
					'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';	
			</c:if>
		</c:if>

       	}
    	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
   			c13.innerHTML= '<input id="selectGbc" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'"></select>'+
			'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
			$('#del'+index).btn().init();
		</c:if>
		initAutoCount();
    }
    
    
     //子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		amount();
		$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
			if('${permissionPo.keyg}'!='1'){
				$(this).attr("readonly","readonly");
			}
		});
	}
	
	function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
		
         	if($(this).val()== goodInfo.bgigoodsbarcode){
			   $(this).parent().parent().remove();
			   	
           }
		});

		initAutoCount();

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
			showPopWin("initScanBarcode.action?jm=jm&outstockid="+$("#cstioutstockid").val(),350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action?jm=jm&outstockid="+$("#cstioutstockid").val(),350,55,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【条码扫描】";
	}
    
    function loadBar(obj)
    {
    	var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsbarcode]').each(function (){
			if(obj.toUpperCase()==$(this).val().toUpperCase()){
				indexval = $(this).val();
				goodidval = $(this).val();
			}
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		$('input[value='+indexval+']').val(obj);
		var getinput = $('input[value='+indexval+']');
		loadBarCodeUpdateNumber(getinput,goodidval);
	}
    function loadBarCode(barCodeInputObj,goodsId){
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
		$(barCodeInputObj).parent().parent().find('.number')[0].value=parseFloat($(barCodeInputObj).parent().parent().find('.number')[0].value) + 1;
		autoCountJMD($(barCodeInputObj).parent().parent().find('.number')[0]);
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
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
    function removeOption(item){
		$(item).parent().find('.gbc').find('option:selected').remove();
		$(item).parent().parent().find('.number')[0].value=$(item).parent().find('.gbc option').size();
		autoCountJMD($(item).parent().parent().find('.number')[0]);		
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
			autoCountJMD($(barCodeInputObj).parent().parent().find('.number')[0]);
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		}
	} 
    
   /**
	*  二维表开窗事件
	*/
	function open2D(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsOpen_dimensional.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen_dimensional.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		initAutoCount();	
	}
	
     
     $(document).ready(function(){
         //initAutoCount();
     });

     function loadBarUpdateNumber(obj)
     {
    	 var indexval = null;
 		var goodidval = null;
 		$('input[name=goodsInfoTempPo.goodsbarcode]').each(function (){
 			if(obj.toUpperCase()==$(this).val().toUpperCase()){
 				indexval = $(this).val();
 				goodidval = $(this).val();
 			}
 		});
 		if(indexval==null){
 			alert("该商品条码没有匹配的商品！");
 			return;
 		}
 		$('input[value='+indexval+']').val(obj);
 		var getinput = $('input[value='+indexval+']');
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
		$(barCodeInputObj).parent().parent().find('.number')[0].value=parseFloat($(barCodeInputObj).parent().parent().find('.number')[0].value) + 1;
		autoCountJMD($(barCodeInputObj).parent().parent().find('.number')[0]);
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
 	}

 	/**
	 * 开窗赋值实现方法
	 */
	function openValues3(objValue){
		salesOutForm.action="selStoreStockGoodsForBrandUpdate.action?brandid="+objValue+"&outstockid="+$("#cstioutstockid").val();
		salesOutForm.submit();
	}
	function openGoodAllocation(){
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

	$(document).ready(function(){
		<s:iterator value="inventoryEntryList">
	    var json = {'bgigoodsid':'${cstiegoodsid}','bgigoodsbarcode':'${cstiebarcode}',
	    				'bgigoodsname':'${cstiegoodsname}','bgiunitname':'${cstieunitname}','bgicostprice':'${cstiecostprice}',
	    				'bgiretailprice':'${bgiretailprice}','bgitaxrate':'${cstietaxrate}','bginottaxrate':'${cstienottaxrate}',
	    				'bgispec':'${cstiespec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}','bgiwholesaleprice':'${empty(cstiewholesaleprice) ? cstiecostprice:cstiewholesaleprice }',
	    				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}','cstieoutstockid':'${cstieoutstockid}','cshaaemaxquantity':'${cstiemaxquantity}',
	    				'bgigoodsquantity':'${cstiegoodsquantity}','bgipcbarcode':'${cstiebarcode }','cstiesupplierName':'${cstiesupplierName }','cstiesupplierID':'${cstiesupplierID }','bgiwholesalepriceamount':'${cstiecostpriceamount}','bginottaxrateamount':'${cstienottaxrateamount}'};
			 addRowUpdateNumber(json);
	
		 $("#cstisuppliername").val(json.cstiesupplierName);
		 $("#cstisupplierid").val(json.cstiesupplierID);
		 $("#cstioutstockid option[value="+json.cstieoutstockid+']').attr("selected","selected");
		</s:iterator>  
		//autoCountAll();
		totalCount();
	});

	function addRowUpdateNumber(goodInfo,stateArray){		
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

		var addtype="";
		for (var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsbarcode) {
				addtype="1";
				return;
			}
		}
		
		
		// 添加商品到列表 begin
    	var readonlyFlg=document.getElementById("autoCount");

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
	<c:if test="${permissionPo.keyf == 1}">	
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
		var c13 = row.insertCell(11);
		</c:if>
	</c:if>
	<c:if test="${permissionPo.keyf == 0}">	
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c13 = row.insertCell(8);
		c13.align="left";
		</c:if>
	</c:if>
		
		row.className = 'row';
		row.height="26";
		
		// 添加商品到列表 end	
   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec + '<input type="hidden" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';
		c5.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'" );\'>' + goodInfo.cshaaemaxquantity+'</a><input type="hidden" id="bgispec" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';

		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
    	
    	if(readonlyFlg.checked){
    	<c:if test="${permissionPo.keyf == 1}">	
    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
    			if(goodInfo.bgigoodsquantity > 0){
    				c6.innerHTML = '<input type="text" ondblclick="batchCheckQutity(this);" maxlength="10" onKeyUp="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
    			}else{
    				c6.innerHTML = '<input type="text" ondblclick="batchCheckQutity(this);" maxlength="10" onKeyUp="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
	    		}  			
			</c:if>
			
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
				if(goodInfo.bgigoodsquantity > 0){
					alert(goodInfo.bgigoodsquantity);
					c6.innerHTML = '<input type="text" ondblclick="batchCheckQutity(this);"  maxlength="10" onKeyUp="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';		
				}else{
					c6.innerHTML = '<input type="text" ondblclick="batchCheckQutity(this);"  maxlength="10" onKeyUp="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
					'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';		
				}
			</c:if>
			    c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c8.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.bginottaxrateamount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
				c9.innerHTML = '<input type="text" style="width:100%"  onblur="if(value==\'\'){value=0;}else{value=parseFloat(value.replace(/[^\\d\\.]/g,\'\')).toFixed()};if(value){autoCountOnlyOne(this);}else{value=0;}" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c10.innerHTML = '<input type="text" style="width:100%" onblur="if(value==\'\'){value=\'0.00\';}else{value=parseFloat(value.replace(/[^\\d\\.]/g,\'\')).toFixed(2)};if(value){autoCountOnlyOne(this);}else{value=0;}" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发单价！\'}]"/>';
				c11.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="' + goodInfo.bgiwholesalepriceamount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的税额合计！\'}]"/><input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
		</c:if>	
		<c:if test="${permissionPo.keyf == 0}">	
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
			c6.innerHTML = '<input type="text" ondblclick="batchCheckQutity(this);" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
			                + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.bginottaxrateamount + '" />'		
		   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';				
			c7.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
			c8.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="' + goodInfo.bgiwholesalepriceamount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
			c6.innerHTML = '<input type="text" ondblclick="batchCheckQutity(this);" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
		              		+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.bginottaxrateamount + '" />'		
	   						+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
			c7.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
			c8.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="' + goodInfo.bgiwholesalepriceamount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />'+
							'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';	
			</c:if>
		</c:if>	

    	}else{
    	<c:if test="${permissionPo.keyf == 1}">	
    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
 			</c:if>	
 			<c:if test="${systemParameterPo.fspbarcodetype==3}">
 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+		
 								'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';	
 			</c:if>	
			c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
			c8.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.bginottaxrateamount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
		    c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
			c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
			c11.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="' + goodInfo.bgiwholesalepriceamount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /> ';
		</c:if>
		<c:if test="${permissionPo.keyf == 0}">	
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.bginottaxrateamount + '" />'
					+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
					c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
					c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="' + goodInfo.bgiwholesalepriceamount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" ondblclick="batchCheckQutity(this);" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.bginottaxrateamount + '" />'
				    +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
				    c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
				    c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="' + goodInfo.bgiwholesalepriceamount + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>'+
					'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode+'"/>';	
			</c:if>
		</c:if>

       	}
    	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
   			c13.innerHTML= '<input id="selectGbc" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'"></select>'+
			'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
			$('#del'+index).btn().init();
		</c:if>
		//initAutoCount();
		$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
			if('${permissionPo.keyg}'!='1'){
				$(this).attr("readonly","readonly");
			}
		});
    }
    
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

	/**
     * 自动计算
 	* 参数
 	*/
 	function autoCountAll(){
     	var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
     	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
     	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
     	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
     	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
     	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
     	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
     	var takepriceArray = $("input[name=goodsInfoTempPo.cstietakeprice]");
     	var takepriceamountArray = $("input[name=goodsInfoTempPo.cstietakepriceamount]");
 		for(var i=0; i<goodsquantityArray.length; i++){
	      	//nottaxrateArray[i].value=parseFloat(accDiv(parseFloat(costpriceArray[i].value),parseFloat(accAdd(accDiv(taxrateArray[i].value,100),1)))).toFixed(6);
	   	    nottaxrateamountArray[i].value=parseFloat(goodsquantityArray[i].value).mul(nottaxrateArray[i].value).toFixed(2);
	  		costpriceamountArray[i].value=parseFloat(goodsquantityArray[i].value).mul(costpriceArray[i].value).toFixed(2);
	  		taxamountArray[i].value=(costpriceamountArray[i].value-nottaxrateamountArray[i].value).toFixed(2);
	  		if(takepriceamountArray[i]){
	  			takepriceamountArray[i].value=parseFloat(goodsquantityArray[i].value).mul(takepriceArray[i].value).toFixed(2);
	  			takepriceArray[i].value = parseFloat(takepriceArray[i].value).toFixed(2);
	  		}
 		}
 	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="salesOutForm" method="post" action="">
<input type="hidden" name="type" id="type" value="update" />  
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="cstisourcebillid" id="cstisourcebillid" value="${inventoryPo.cstisourcebillid}" /> 

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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      
                      
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">
                            ${inventoryPo.cstibillid}<input type="hidden" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}">
			               </TD>
			                <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">${inventoryPo.csticreatepersonname}</TD>
			               
			               <TD width="9%" height="26" class="table_body">客户名称</TD>
			               <TD class="table_none">                             			               	
      	                   ${inventoryPo.cstisuppliername}
			               </TD>
                        </TR>                        
                        <TR>
			               <TD height="26" class="table_body">发出仓位</TD>
			               <TD class="table_none">                            
                          	${inventoryPo.cstioutstockname}<input type="hidden" id="cstioutstockid" name="inventoryPo.cstioutstockid" value="${inventoryPo.cstioutstockid}">
			               </TD>
			               <TD height="26" class="table_body">联系人</TD>
			               <TD class="table_none" >
			               ${inventoryPo.dpPerson}
			                </TD>
			                <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none"> ${inventoryPo.dpPhone}</TD>
                        </TR>
                        <TR height="26">
                          <TD class="table_body">制单日期</TD>
                          <TD class="table_none" colSpan=5>
                           ${fn:substring(inventoryPo.cstibilldate,0,10)}
                          </TD>
                        </TR>
                         <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5>
                           
                             <textarea id="textarea" name="inventoryPo.cstiremark">${inventoryPo.cstiremark}</textarea>
                          </TD>
                        </TR>
                      </TBODY>
                      
                      
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <td width="20%">
	                          <input name="radiobutton" id="autoCount" type="radio" value="autoCount" checked="checked" onClick="changeRadioType(this,getInputState())"/>自动计算
	  				  		  <input type="radio" id="notAutoCount" name="radiobutton" value="notAutoCount" onClick="changeRadioType(this,getInputState())"/>手动计算
	  				  	  </td>
                          <TD align="left" width="50%">
						 <c:if test="${systemParameterPo.fspbarcodetype==3||systemParameterPo.fspbarcodetype==2}">    
						  <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" 
						  onClick="javascript:openGoodSingle();">

					      </c:if>
					      <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					       <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
					       </c:if>
                          <img id="del" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="deleteitem();">
                         </TD>
                         <TD align="left">
	                          <c:if test="${systemParameterPo.fspsalestype eq '0'}">   
	                             <font color="red" style="font-family: 微软雅黑">商品信息如果为红色,则表示该商品库存不足,不能完成商品调货操作!</font>
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
                        <TR class=table_title align=middle>                     
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" name="chks" onclick="chkAll()"></TH>
                          <TH scope=col width="15%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>						
                          <TH scope=col width="10%">型号</TH>  
                          <TH scope=col width="5%">可用库存</TH>	                        
 						  <TH scope=col width="5%">数量</TH>	
 						<c:if test="${permissionPo.keyf == 1}">
 						  <TH scope=col width="7%">单位成本</TH>
						  <TH scope=col width="7%">成本合计</TH>
						
                          <TH scope=col width="5%">税率</TH>
                        </c:if>  
                          <TH scope=col width="7%">批发单价</TH>
                          <TH scope=col width="7%">批发金额</TH>
						<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  <TH scope=col width="10%">商品条码</TH>	
					    </c:if>					  
                        </TR>
                        <tr class=table_title align=middle> 
						  	<th width="45%" height="26"  colSpan=5 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    <c:if test="${permissionPo.keyf == 1}">	
					    	<th scope=col width="7%">&nbsp;</th>
					    	<th scope=col width="10%" id="nottaxrateamountTotal">&nbsp;</th>
					   
					    	<th scope=col width="6%">&nbsp;</th>
					    	<th scope=col width="7%" >&nbsp;</th>
					    	<th scope=col width="10%" id="costpriceamountTotal">&nbsp;</th>
					    </c:if> 
					    <c:if test="${permissionPo.keyf != 1}">
					    	<th scope=col width="6%">&nbsp;</th>
					    	<th scope=col width="7%" id="costpriceamountTotal">&nbsp;</th>
					     </c:if>	
					    	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					    	<th scope=col width="7%">&nbsp;</th></c:if>
				   		</tr>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          		<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
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
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<script>
	initPriceAmount();
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>