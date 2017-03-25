<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>客户批发退货管理</title>
</head>

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

	//条码批量打印
	function batPrintGoodsBarCode(){
		var flag = false;
		
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			var persons = $("input[id=person]");
			var barCodes = $("input[id=pcbarcode]");
			var goodsQuantitys = $("input[name=goodsInfoTempPo.goodsquantity]");
			var brandnames = $("input[id=brandname]");
			var sources = $("input[id=source]");
			var specs = $("input[id=spec]");
			var colors = $("input[id=color]");
			var retailprices = $("input[id=retailprice]");
			
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
					/*alert(persons[0].value);
					alert(barCodes[i].value);
					alert(goodsQuantitys[i].value);
					alert(brandnames[i].value);
					alert(sources[i].value);
					alert(colors[i].value);
					alert(retailprices[i].value);*/
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
				try{
					printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,'','');
				} catch(e) {
					alert("打印失败!请检查条码打印机是否正确连接!");
					return;
				}
			}
		}
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

	function save(){
	if(checkForm(document.all.salesOutForm)){ 
		var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		if(index==0){
		  alert('请选择商品!');
		}

		//判断条码是否输入正确
		var pcbarcodeArray = document.getElementsByName("goodsInfoTempPo.goodsbarcode");
		for(i=0;i<pcbarcodeArray.length;i++){

			if(pcbarcodeChange(pcbarcodeArray[i])==false){
				return;
			}
		}
		
		//验证商品类别和制造商是否与添加商品一样
		var chk=document.getElementsByName("chk");
		var length = chk.length;
		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		var goodsquantityCount=0;
		for(i=0;i<goodsquantityArray.length;i++)
		{
			if(goodsquantityArray[i].value=="0"){
				alert("商品数量不能为0！");
				goodsquantityArray[i].focus();
				return;	
			}
			if(isNaN(goodsquantityArray[i].value)||goodsquantityArray[i].value<0){
				alert("商品数量格式不正确！");
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
		salesOutForm.action = "insertStoreReturnGoods.action";
		salesOutForm.submit();
		}
		
	}
	function openGoodSingle(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSel2.action?jm=jm",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel2.action?jm=jm",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	
	function fuzhi(obj)
	{		
		if(obj.value!="")
		{
			var tem=document.getElementById(obj.value).value;
			var mm=tem.split(",");
			if(mm.length>0)
			{
				$("td[id=mm1]").text(mm[0]);
				$("td[id=mm2]").text(mm[1]);
			}else
			{
				$("td[id=mm1]").text("");
				$("td[id=mm2]").text("");
			}
		}else
		{
			$("td[id=mm1]").text("");
			$("td[id=mm2]").text("");
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
    }
    
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
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

		function copyRow(obj){
	    	$(obj).parent().parent().clone(true).appendTo($(obj).parent().parent().parent());
	    	$(obj).parent().parent().find('input[name=goodsInfoTempPo.goodsquantity]')[0].value="";
	   		$(obj).parent().parent().find('input[id=pcbarcode]')[0].value=$(obj).parent().parent().find('input[id=pcbarcode]')[0].value.substring(0,18).toUpperCase();
		}

		//手动修改商品条码后，验证商品列表中，是否已经添加了该条码的商品。
		function pcbarcodeChange(obj){
			var ybc = $(obj).parent().find("#bc").val().substring(0,18).toUpperCase();
			var bc = $(obj).val().substring(0,18).toUpperCase();

			if(ybc != bc){
				alert("条码与商品不符!");
				$(obj).select();
				return false;
			}
			
			if($(obj).val().length != 26){
				alert("条码位数不正确!");
				$(obj).select();
				return false;
			}

			if($("input[id=pcbarcode][value="+obj.value+"]").size()>1){		
				alert("该条码已经选择过，请核对！");
				$(obj).select();
				return false;
			}	
		}		
		
		function addRow(goodInfo,stateArray){		
			var table = document.getElementById('addTable');
			index = accAdd(index,table.rows.length - 1);
			// 商品id去重
			var chk=document.getElementsByName("chk");
			var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

			var addtype="";
			for(var i = 0; i < chk.length; i++){
				if (chk[i].value == goodInfo.bgigoodsbarcode){
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
		<c:if test="${permissionPo.keyf == 1}">	
			var c8 = row.insertCell(7);
			var c9 = row.insertCell(8);
			var c10 = row.insertCell(9);
			var c12 = row.insertCell(10);
		</c:if>
		<c:if test="${permissionPo.keyf == 0}">	
			var c12 = row.insertCell(7);
			c12.align="left";
		</c:if>
			
			row.className = 'row';
			row.height="26";
			
			// 添加商品到列表 end	
	   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >'+'<input type="hidden" id="color" value="' + goodInfo.bgicolor +'" />';
	        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
	        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />'+'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />';
			c4.innerHTML = goodInfo.bgispec + '<input type="hidden" id="spec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" /><input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />'+'<input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';  
		
			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");	    	
	    	if(readonlyFlg.checked){
	    	<c:if test="${permissionPo.keyf == 1}">	

	    			if(goodInfo.bgigoodsquantity > 0){
	    				c5.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
	    			}else{
	    				c5.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
		    		}  			
				    c6.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
					c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
					c8.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
					c9.innerHTML = '<input type="text" onblur="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发单价！\'}]"/>';
					c10.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的税额合计！\'}]"/><input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
			</c:if>	
			<c:if test="${permissionPo.keyf == 0}">	
				c5.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
				                + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'		
			   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';				
				c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
			</c:if>	

	    	}else{
	    	<c:if test="${permissionPo.keyf == 1}">	
	 			c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
			    c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c9.innerHTML = '<input type="text" onblur="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
				c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /> ';
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
						c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						c6.innerHTML = '<input type="text" onblur="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
						c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
			</c:if>

	       	}
    		var bc = goodInfo.bgigoodsid.replace(/\./g,  "").toUpperCase();
   			c12.innerHTML= '<input  id="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" class="text_input200 gbc" value ="'+goodInfo.bgipcbarcode+'"><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';

			totalCount();
			$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
				if('${permissionPo.keyg}'!='1'){
					$(this).attr("readonly","readonly");
				}
			});
	    }

		function addRowUpdateNumber(goodInfo,stateArray){		
			var table = document.getElementById('addTable');
			index = accAdd(index,table.rows.length - 1);
			// 商品id去重
			var chk=document.getElementsByName("chk");
			var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

			var addtype="";
			for(var i = 0; i < chk.length; i++){
				if (chk[i].value == goodInfo.bgigoodsbarcode){
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
		<c:if test="${permissionPo.keyf == 1}">	
			var c8 = row.insertCell(7);
			var c9 = row.insertCell(8);
			var c10 = row.insertCell(9); 
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
			var c12 = row.insertCell(10);
			</c:if>
		</c:if>
		<c:if test="${permissionPo.keyf == 0}">	
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
			var c12 = row.insertCell(7);
			c12.align="left";
		</c:if>
		</c:if>
			
			row.className = 'row';
			row.height="26";
			
			// 添加商品到列表 end	
	   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >'+'<input type="hidden" id="color" value="' + goodInfo.bgicolor +'" />';
	   		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	        c2.innerHTML = "<img src=\"${ctx}/img/newbtn/addgoods_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');\" btn=btn title='复制商品' onClick='copyRow(this);'>"+goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />'+'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />';
            </c:if>
            <c:if test="${systemParameterPo.fspbarcodetype==3}">
            c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />'+'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />';
            </c:if>
	        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />'+'<input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
			c4.innerHTML = goodInfo.bgispec + '<input type="hidden" id="spec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" /><input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />';
		
			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
    		var bc = goodInfo.bgigoodsid.replace(/\./g,  "").toUpperCase();	    	
	    	if(readonlyFlg.checked){
	    	<c:if test="${permissionPo.keyf == 1}">	
	    			if(goodInfo.bgigoodsquantity > 0){
	    				c5.innerHTML = '<input type="text" onKeyUp="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
	    			}else{
	    				c5.innerHTML = '<input type="text" onKeyUp="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
		    		} 
		    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 			
				    c6.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
					c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
					c8.innerHTML = '<input type="text" onKeyUp="value=value.replace(/[^\\d\\.]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
					c9.innerHTML = '<input type="text" onKeyUp="value=value.replace(/[^\\d\\.]/g,\'\');" onblur="if(value){value=parseFloat(value).toFixed(2);autoCountOnlyOne(this);}else{value=\'0.00\';}" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发单价！\'}]"/>';
					c10.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的税额合计！\'}]"/><input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
					</c:if>
			        <c:if test="${systemParameterPo.fspbarcodetype==3}">
				    c6.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
					c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
					c8.innerHTML = '<input type="text" onKeyUp="value=value.replace(/[^\\d\\.]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
					c9.innerHTML = '<input type="text" onKeyUp="value=value.replace(/[^\\d\\.]/g,\'\');" style="width:100%" onblur="if(value){value=parseFloat(value).toFixed(2);autoCountOnlyOne(this);}else{value=\'0.00\';}" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发单价！\'}]"/>';
					c10.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的税额合计！\'}]"/><input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />'+'<input type="hidden"  id="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'"><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';
					</c:if>
			</c:if>	
			<c:if test="${permissionPo.keyf == 0}">	
					    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 			
				c5.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
				                + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'		
			   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';				
				c6.innerHTML = '<input type="text" onblur="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
								</c:if>
			        <c:if test="${systemParameterPo.fspbarcodetype==3}">
				c5.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodInfo.bgigoodsquantity+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
				                + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'		
			   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';				
				c6.innerHTML = '<input type="text" onblur="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />'+'<input type="hidden"  id="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'"><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';            
								</c:if>
			</c:if>	

	    	}else{
	    	<c:if test="${permissionPo.keyf == 1}">	
	    	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	 			c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
			    c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c9.innerHTML = '<input type="text" onblur="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
				c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /> ';
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
				c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
			    c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c9.innerHTML = '<input type="text" onblur="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
				c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /> '+'<input type="hidden"  id="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'"><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';            
			</c:if>
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
						c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
						c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
						c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						c6.innerHTML = '<input type="text" onblur="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
						c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>'+'<input type="hidden"  id="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'"><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';
			</c:if>
			</c:if>

	       	}


   			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
   			c12.innerHTML= '<input  id="pcbarcode" name="goodsInfoTempPo.goodsbarcode"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'"><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';
            </c:if>


	    	// 初始化添加的每行商品信息的Input标签readonly属性以及onchange方法 end
			totalCount();
			$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
				if('${permissionPo.keyg}'!='1'){
					$(this).attr("readonly","readonly");
				}
			});
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
    function scanbarcode(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initScanBarcode.action?jm=jm",350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action?jm=jm",350,55,topRows,topCols,returnRefresh(true),false);
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
    
    function onBlurBarCode(barCodeInputObj,goodsId)
    {
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
	
	/**
	 * 开窗赋值实现方法
	 */
	function openValues3(objValue){
		salesOutForm.action="selStoreStockGoodsForBrandInsert.action?brandid="+objValue+"&outstockid="+$("#cstioutstockid").val();
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
		//StatusID：0代表负调拨
		var StatusID='${StatusID}';
			/*<s:iterator value="inventoryEntryList">
		     var json = {'bgigoodsid':'${cstiegoodsid}','bgigoodsbarcode':'${cstiebarcode}',
		     				'bgigoodsname':'${cstiegoodsname}','bgiunitname':'${cstieunitname}','bgiwholesaleprice':'${cstiecostprice}',
		     				'bgiretailprice':'${bgiretailprice}','bgitaxrate':'${cstietaxrate}','bginottaxrate':'${cstienottaxrate}',
		     				'bgispec':'${cstiespec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
		     				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
		     				'bgigoodsquantity':'${cstiegoodsquantity}','cstienottaxrateamount':'${cstienottaxrateamount }'};
		     if(StatusID=='0')	
		     {
		     	addRowX(json); 
		     }				        
			</s:iterator> */

			<s:iterator value="inventoryEntryList">
		     var json = {'bgigoodsid':'${cstiegoodsid}','bgigoodsbarcode':'${cstiebarcode}',
		     				'bgigoodsname':'${cstiegoodsname}','bgiunitname':'${cstieunitname}','bgicostprice':'${cstiecostprice}',
		     				'bgiretailprice':'${bgiretailprice}','bgitaxrate':'${cstietaxrate}','bginottaxrate':'${cstienottaxrate}',
		     				'bgispec':'${cstiespec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}','bgiwholesaleprice':'${cstiewholesaleprice}',
		     				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}','cstieoutstockid':'${cstieoutstockid}',
		     				'bgigoodsquantity':'${cstiegoodsquantity}','bgipcbarcode':'${cstiebarcode }','cstiesupplierName':'${cstiesupplierName }','cstiesupplierID':'${cstiesupplierID }'};
		     if(StatusID=='0')	
		     {
				 addRowUpdateNumber(json);

				 $("#cstisuppliername").val(json.cstiesupplierName);
				 $("#cstisupplierid").val(json.cstiesupplierID);
				 $("#cstioutstockid option[value="+json.cstieoutstockid+']').attr("selected","selected");
		     }				
			</s:iterator>  
			if(StatusID=='0'){
				autoCountAll();
			}
			totalCount();
			
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
		
		function addRowX(goodInfo,stateArray){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重 begin
		var chk=document.getElementsByName("chk");
		
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
	<c:if test="${permissionPo.keyf == 1}">		
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c12 = row.insertCell(10);
	</c:if>
	<c:if test="${permissionPo.keyf == 0}">	
		var c12 = row.insertCell(7);
	</c:if>
	
		row.className = 'row';
		row.height="26";
		

		// 添加商品到列表 end	
	   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
	        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
	        c3.innerHTML = goodInfo.bgigoodsname;
			c4.innerHTML = goodInfo.bgispec;
		
			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
	    	
	    	if(readonlyFlg.checked){
	    	<c:if test="${permissionPo.keyf == 1}">	
				c5.innerHTML = '<input type="text" onchange="autoCountJMD(this);"  style="width:100%" name="goodsInfoTempPo.goodsquantity" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
			    c6.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.cstienottaxrateamount +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
				
				c8.innerHTML = '<input type="text" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c9.innerHTML = '<input type="text" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
				c10.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
			
			</c:if>	
			<c:if test="${permissionPo.keyf == 0}">	
				c5.innerHTML = '<input type="text" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.goodsquantity" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
				               + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.cstienottaxrateamount +'" />'		
			   				+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';				
   				c6.innerHTML = '<input type="hidden" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
   				c7.innerHTML = '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
			
			
			</c:if>	

	    	}else{
	    	<c:if test="${permissionPo.keyf == 1}">	
	 			c5.innerHTML = '<input type="text" onchange="totalCount();"  style="width:100%" name="goodsInfoTempPo.goodsquantity" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="' + goodInfo.cstienottaxrateamount +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
			    c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
				c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
        	
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
				c5.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.goodsquantity" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'
						    +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';		
			    c6.innerHTML = '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]" />';
			    c7.innerHTML = '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
        	
			
			</c:if>

        	}
	    	c12.innerHTML='<input type="text" value="'+goodInfo.bgigoodsbarcode+'" onBlur="barcode(\''+goodInfo.bgigoodsid+'\',this)" class="text_input100" maxlength="26" name="goodsInfoTempPo.pcbarcode"  />';
    	// 初始化添加的每行商品信息的Input标签readonly属性以及onchange方法 end
    }
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	function addDimensionRow(goodInfo){
		var table = document.getElementById('addTable');
	    index = accAdd(index,table.rows.length - 1);

	    var chk=document.getElementsByName("chk");
	  	var readonlyFlg=document.getElementById("autoCount");
	
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
	<c:if test="${permissionPo.keyf == 1}">		
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);	
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
			var c12 = row.insertCell(10);
		</c:if>
	</c:if>
	<c:if test="${permissionPo.keyf == 0}">	
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
			var c6 = row.insertCell(5);
			var c7 = row.insertCell(6);
			var c8 = row.insertCell(7);
		</c:if>
	</c:if>
		
		row.className = 'row';
		row.height="26";	

	  	c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.goodsid + '" >'+'<input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
	    c2.innerHTML = goodInfo.goodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.goodsid +'" />'+'<input type="hidden" id="color" value="' + goodInfo.bgicolor +'" />';
	    c3.innerHTML = goodInfo.goodsName+'<input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />'+ '<input type="hidden" id="spec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';
	    c4.innerHTML = goodInfo.spec+'<input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" />';
	
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
			 if(goodInfo.pcbarcode.substring(0,1)=='4' || goodInfo.pcbarcode.substring(0,1)=='5'){
				 c5.innerHTML = '<input type="text" onchange="autoCountJMD(this);" class="text_input60 number" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
			 }else{
				 c5.innerHTML = '<input type="text" onchange="autoCountJMD(this);" class="text_input60 number" value="' + goodInfo.v +'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
		     }
					 
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c5.innerHTML = '<input type="text" onchange="autoCountJMD(this);" class="text_input60 number" value="' + goodInfo.v +'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+		
						'<input  type="hidden" id="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.pcbarcode+'"/>';		
			</c:if>		
			c6.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
			c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
		 	c8.innerHTML = '<input type="text" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
			c9.innerHTML = '<input type="text" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
			c10.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
	   	
		 </c:if>
		 	
		 <c:if test="${permissionPo.keyf == 0}">
			 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
				c5.innerHTML = '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" /><input type="text" onchange="autoCountJMD(this);" value="' + goodInfo.v +'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" />'
					    + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" />';		
			    c6.innerHTML = '<input type="text" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
			    c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
			 </c:if>
			 <c:if test="${systemParameterPo.fspbarcodetype==3}">
				c5.innerHTML = '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" /><input type="text" onchange="autoCountJMD(this);" value="' + goodInfo.v +'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" />'
			    		+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" />';		
	    		c6.innerHTML = '<input type="text" onchange="autoCountJMD(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
	    		c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
	    		c8.innerHTML = '<input  type="text" id="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.pcbarcode+'"/>';	

			</c:if>
		 </c:if>	
	
	   	}else{
		   <c:if test="${permissionPo.keyf == 1}">	
		  	 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
		  		c5.innerHTML = '<input type="text" class="text_input60 number" onchange="totalCount();" value="' + goodInfo.v +'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">
			 c5.innerHTML = '<input type="text" class="text_input60 number" onchange="totalCount();" value="' + goodInfo.v +'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+	
					'<input  type="hidden" id="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.pcbarcode+'"/>';		
			</c:if>		
		   	c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
			c7.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
		  	c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
			c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
			c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
		
		  </c:if>
		  <c:if test="${permissionPo.keyf == 0}">
		  	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">	
			c5.innerHTML = '<input type="hidden" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" /><input type="text" onchange="totalCount();" value="' + goodInfo.v +'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" />'
			+ '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" />';				
			c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
			c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
			</c:if>
			<c:if test="${systemParameterPo.fspbarcodetype==3}">	
			c5.innerHTML = '<input type="hidden" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" /><input type="text" onchange="totalCount();" value="' + goodInfo.v +'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" />'
			+ '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" />'				
			c6.innerHTML = '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
			c7.innerHTML = '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>'+
			'<input  type="hidden" id="pcbarcode" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.pcbarcode+'"/>';	
			</c:if>
		  </c:if>		

		}
	   	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">	
	   	if('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2'){	
   			c12.innerHTML= '<input id="pcbarcode" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value ="'+goodInfo.pcbarcode+'">'+
			'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
			$('#del'+index).btn().init();
	   	}else{
	   		c12.innerHTML= '<input id="pcbarcode" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value ="'+goodInfo.pcbarcode+'">'+
			'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
			$('#del'+index).btn().init();
		}
		</c:if>
    }   
     $(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

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
	      	nottaxrateArray[i].value=parseFloat(accDiv(parseFloat(costpriceArray[i].value),parseFloat(accAdd(accDiv(taxrateArray[i].value,100),1)))).toFixed(6);
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
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="cstisourcebillid" id="cstisourcebillid" value="${cstisourcebillid}" /> 


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
                          <c:forEach var="dp" items="${departmentsPos}">
	                           <input type="hidden" id="${dp.bdpdepartmentid}" name="mm${dp.bdpdepartmentid}" value="${dp.bdpperson},${dp.bdpphone}">  		 	                             		
	                        </c:forEach>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input200"  type="text" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}" readonly="readonly">
			               </TD>
			                <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">${person.personName }<input class="text_input100" id="person" type="hidden" name="inventoryPo.csticreateperson" value="${person.id }"></TD>
			               
			               <TD width="9%" height="26" class="table_body">客户名称</TD>
			               <TD class="table_none">                             
			               	<select  name="inventoryPo.cstisupplierid" onchange="fuzhi(this)" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '客户名称不能为空！'}]">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsPos)}">
	                             	<c:forEach var="dp" items="${departmentsPos}">
	                             		  <OPTION  value="${dp.bdpdepartmentid}" ${inventoryPo.cstisupplierid!= dp.bdpdepartmentid  ? '' : 'selected="selected"' } >${dp.bdpdepartmentname} </OPTION>
	                             		
	                             	</c:forEach>
	                             				               	  
                    	        </c:if>
      	                   </select>
      	                   
      	                   
			               </TD>
                        </TR>                        
                        <TR>
			               <TD height="26" class="table_body">入库仓位</TD>
			               <TD class="table_none">                            
                          	<select id="cstioutstockid" name="inventoryPo.cstioutstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '入库仓位不能为空！'}]">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(warehouseList)}">
				               	  <s:iterator value="warehouseList">
                    	           <OPTION value="${bwhid}" ${warehouseConfigurationPo.bwcstockid10!= bwhid  ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">联系人</TD>
			               <TD class="table_none" id="mm1">&nbsp;</TD>
			               <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none" id="mm2">&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">制单日期</TD>
                          <TD class="table_none" colSpan=5>
                            <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input name="inventoryPo.cstibilldate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/>
                          </TD>
                        </TR>
                         <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5>
                            <textarea name="inventoryPo.cstiremark" id="cstiremark" ></textarea>
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
                          <TD align="left" width="80%">
                          	<img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
                       <c:if test="${systemParameterPo.fspbarcodetype != 1 && systemParameterPo.fspbarcodetype != 2 }">    
						   <img src="${ctx}/img/newbtn/btn_addtwogoods_0.png" btn=btn title="二维表添加商品" id="2D"
					      onClick="javascript:open2D();"> 
					   </c:if>
					   <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">   
						   <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
					  	  
					   	  <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();"> 
					       </c:if>
                          <img id="del" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="deleteitem();"></TD>
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
                          <TH scope=col width="7%">型号</TH>                          
 						  <TH scope=col width="5%">数量</TH>	
 						<c:if test="${permissionPo.keyf == 1}">
 						  <TH scope=col width="7%">单位成本</TH>
						  <TH scope=col width="7%">成本合计</TH>
						
                          <TH scope=col width="6%">税率</TH>
						</c:if>  	
						  <TH scope=col width="7%">批发单价</TH>
						  <TH scope=col width="7%">批发金额</TH>	
						  <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	  
                          <TH scope=col width="10%">商品条码</TH>
                          </c:if>
                        </TR>
						<tr class=table_title align=middle> 
						  	<th width="45%" height="26" colSpan="4" scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    <c:if test="${permissionPo.keyf == 1}">
					    	<th scope=col width="7%">&nbsp;</th>
					    	<th scope=col width="7%" id="nottaxrateamountTotal">&nbsp;</th>
					   
					    	<th scope=col width="6%">&nbsp;</th>
					    	<th scope=col width="7%" >&nbsp;</th>
					    	<th scope=col width="7%" id="costpriceamountTotal">&nbsp;</th>
					     </c:if>
					     <c:if test="${permissionPo.keyf != 1}">
					    	<th scope=col width="6%">&nbsp;</th>
					    	<th scope=col width="7%" id="costpriceamountTotal">&nbsp;</th>
					     </c:if>
					     	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
					    	<th scope=col width="10%" >&nbsp;</th>
					    	</c:if>
				   		</tr>
				   	</TABLE>
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          	</li>
                          	<c:if test="${(permissionPo.keyi==1)}">
                          	<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstifinanceauditstate" name="inventoryPo.cstiauditstate" value="1">保存并审核
                          	</li>
                          	</c:if>
                          </TD>
					   </TR>
					   <TR>
						  <TD align="left">
						  <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
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