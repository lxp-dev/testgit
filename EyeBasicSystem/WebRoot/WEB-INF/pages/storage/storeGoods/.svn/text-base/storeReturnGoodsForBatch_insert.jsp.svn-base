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
<title>客户批发调货管理</title>
</head>
<script>
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
	});

	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		amount();
	}	
		//条码批量打印
	function batPrintGoodsBarCode(){
		var flag = false;
		
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			var persons = $("input[id=person]");
			var barCodes = $("input[id=pcbarcode]");
			var goodsQuantitys = $("input[id=quantity]");
			var brandnames = $("input[id=quantity]");
			var sources = $("input[id=quantity]");
			var specs = $("input[id=quantity]");
			var colors = $("input[id=quantity]");
			var retailprices = $("input[id=retailprice]");
			var guaranteeperiods = $("input[name=goodsInfoTempPo.guaranteeperiod]");
			var batchs = $("input[name=goodsInfoTempPo.batch]");
			
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
	 * 制造商开窗
	 */
	function openSupplier(){
		var cstpgoodscategory = document.getElementById('cstpgoodscategory').value;
	    if(cstpgoodscategory == ''){
	      alert('请选择采购类型');
	      return false;
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + cstpgoodscategory,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + cstpgoodscategory,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商添加】";
	}
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		if(document.getElementById('cstisupplierid').value != json.id){
			document.getElementById('cstisupplierid').value = json.id;
			document.getElementById('cstisuppliername').value = json.value;
			$("#cstisourcebillid").val("");
			deleteROW();
		}
	}
	
	function barcodes(goodsid,goodsbarcode){
		if(goodsbarcode.value==''){
			return;
		}
		var tmp = goodsid.replace(/\./g,  "").toUpperCase();
		var tmp1 = goodsbarcode.value.substring(0,18);
		tmp1 = tmp1.toUpperCase();
		if(tmp != tmp1){
			alert("条码不符！");
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
		if(checkForm(document.all.salesOutForm)){ 
			var table = document.getElementById('addTable');
			var index = table.rows.length-1;
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
	        
	        var goodsids = document.getElementsByName('goodsInfoTempPo.goodsid');
			var goodsbarcodes = document.getElementsByName('goodsInfoTempPo.goodsbarcode');
			
			var size = goodsids.length;
			
			var submittype = 'a';
			for(var i = 0; i < size; i++){
				if(goodsids[i].value.replace(/\./g,"")!=goodsbarcodes[i].value.substring(0,18)){
					submittype = i;
					break;
				}
			}
			
			if(parseFloat(submittype) >= 0){
				goodsbarcodes[submittype].focus();
				goodsbarcodes[submittype].select();
				alert("条码不符");
				return;
			}
	        
			$("img").removeAttr("onclick");
			salesOutForm.action = "insertStoreReturnGoods.action";
			salesOutForm.submit();
		}
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

	function openOrders(){
		var goodscategory = $('#cstpgoodscategory').val();

		var supplierID=document.all.cstisupplierid.value;
		var categoryID_open='';

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
			showPopWin("initProcurementOrdersForOpenyx.action?poType="+poType+"&supplierID=" + supplierID +"&goodscategory="+goodscategory,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementOrdersForOpenyx.action?poType="+poType+"&supplierID=" + supplierID +"&goodscategory="+goodscategory,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【隐形采购订单查询】";
	}
	
	function openOrders1(){
		var goodscategory = $('#cstpgoodscategory').val();

		var supplierID=document.all.cstisupplierid.value;
		var categoryID_open='';

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
			showPopWin("initProcurementOrdersForOpensyx.action?poType="+poType+"&supplierID=" + supplierID +"&goodscategory="+goodscategory,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementOrdersForOpensyx.action?poType="+poType+"&supplierID=" + supplierID +"&goodscategory="+goodscategory,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【隐形已核销订单查询】";
	}
	
	function openInvoice(){	
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
	    
		showPopWin("","initInvoiceForOpen.action?poType="+poType+"&supplierID=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
	
	function openGoodSingle(){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?storebatch=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?storebatch=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(var i = 0; i < goodInfos.length; i++){	
			addRow(goodInfos[i]);			
		}
		initPriceAmount();
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
	var index = 0;
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

		var addtype="";
		for (var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) {
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
		<c:if test="${permissionPo.keyf == 1}">	
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c11 = row.insertCell(10);	//效期
		var c12 = row.insertCell(11);	//批号	
		var c13 = row.insertCell(12);
		</c:if>
		</c:if>

		<c:if test="${permissionPo.keyf == 0}">	
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c12 = row.insertCell(7);
		</c:if>
		</c:if>
		
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = "<img src=\"${ctx}/img/newbtn/addgoods_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');\" btn=btn title='复制商品' onClick='copyRow(this);'>"+goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.bgiretailprice" id="retailprice" value ="'+goodInfo.bgiretailprice+'"/>';
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgispec + '<input type="hidden" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';

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
					c5.innerHTML = '<input type="text" onkeyup="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="0" style="width:100%" id=quantity name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c5.innerHTML = '<input type="text" onkeyup="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="0" style="width:100%" id=quantity name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode.substring(0,24)+'A0'+'"/>';		
				</c:if>
				    c6.innerHTML = '<input type="text" class="text_input120" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
					c7.innerHTML = '<input type="text" class="text_input100" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
					c8.innerHTML = '<input type="text" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
					c9.innerHTML = '<input type="text" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=\'0.00\';}" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发单价！\'}]"/>';
					c10.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的税额合计！\'}]"/><input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
			</c:if>	
			<c:if test="${permissionPo.keyf == 0}">	
				<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
				c5.innerHTML = '<input type="text" onkeyup="value=value.replace(/[^\\d]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=0;}" class="text_input60 number" value="0" style="width:100%" id=quantity name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
				                + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'		
			   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';				
				c6.innerHTML = '<input type="text" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\');if(value){autoCountOnlyOne(this);}else{value=\'0\.00\';}" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
				c5.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="0" style="width:100%" id=quantity name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
			              		+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'		
		   						+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
				c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
				c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />'+
								'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode.substring(0,24)+'A0'+'"/>';	
				</c:if>
			</c:if>	

	    	}else{
	    	<c:if test="${permissionPo.keyf == 1}">	
	    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	 				c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" id=quantity name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
	 			</c:if>	
	 			<c:if test="${systemParameterPo.fspbarcodetype==3}">
	 				c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" id=quantity name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+		
	 								'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode.substring(0,24)+'A0'+'"/>';	
	 			</c:if>	
				c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
			    c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>';
				c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /> ';
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
				<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
						c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" id=quantity name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';			
						c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
						c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
						c5.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="0" style="width:100%" id=quantity name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" />'
					    +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
					    c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiwholesaleprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写批发价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的批发价！\'}]"/>'
					    c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>'+
						'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgipcbarcode.substring(0,24)+'A0'+'"/>';	
				</c:if>
			</c:if>

	       	}
		    	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
		    			c11.innerHTML = '<input type="text" class="text_input80" name="goodsInfoTempPo.guaranteeperiod" onblur="changebarcode('+index+',$(this));loadSimpleBatch($(this).parent().parent().find(\'#pcbarcode\').val(),$(this).parent().parent().find(\'#batch\').val(),this);" value=""/>'
		    			c12.innerHTML = '<input type="text" class="text_input80"  maxlength="15" id="batch" onblur="loadSimpleBatch($(this).parent().parent().find(\'#pcbarcode\').val(),$(this).val(),this);" name="goodsInfoTempPo.batch"  value=""/>'
		    			c13.innerHTML = '<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.goodsbarcode"  value="'+goodInfo.bgipcbarcode.substring(0,24)+'A0'+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
				$('#del'+index).btn().init();
				</c:if>
    }
    
    function setValue(billid,poID,id,name){
    	var cstibillid = $('#cstibillid').val();
		procurementReceiptForm.action="initInsertProcurementReceiptyx.action?hid="+billid+"&cstibillid="+cstibillid;
		procurementReceiptForm.submit();
    }
    
    function setValueorders(billid,poID,id,name){
    	var cstibillid = $('#cstibillid').val();
		procurementReceiptForm.action="initInsertProcurementReceiptsyx.action?hid="+billid+"&cstibillid="+cstibillid;
		procurementReceiptForm.submit();
    }
    
	function openProcurementOrdersValues(objValue,poID,id,name){
		document.all.cstisourcebillid.value=poID;
		var goodInfos = eval('(' + objValue + ')');
		for(var i = 0; i < goodInfos.length; i++){
			addRow2(goodInfos[i]);			
		}
		
		$('#cstisuppliername').val(name);
		$('#cstisupplierid').val(id);
		
		var ordertype = goodInfos[0].bgigoodsid.substring(0,1);
		$('#goodstype').val(ordertype);
		
		isshow(ordertype);
		amount();
	}
	
	function openDeliveryValues(poID, deliveryID){
		document.all.cstisourcebillid.value=poID;
		document.all.deliveryID.value=deliveryID;
		procurementReceiptForm.action="initProcurementReceiptyxInsert.action";
		procurementReceiptForm.submit();
	}
	
	$(document).ready(function(){
		isshow($('#goodstype').val());
		initPriceAmount();
	});
	
    function deleteitem(){   
        $('input[id=chk]').each(function(){ 
           	if($(this).is(":checked")){ 
           		$(this).parent().parent().remove(); 
            } 
        }); 

		document.all.chks.checked = false;
		amount();
    }
  
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chks=document.all.chks;

        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        });
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
	
    /*
	    1、镜架
	    2、镜架辅料
	    3、成品镜片
	    4、隐形镜片
	    5、隐形辅料
	    6、成镜
	    7、其他
    */
    
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
    			$('[id*=]').show();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=zx]').hide();
    			$('[id=ql]').hide();
    			$('[id=xq]').hide();
    			$('[id=zhj]').hide();
    			
    			$('#heji').attr("colSpan","6");
    		}else if(type == "2"){
    			$('[id*=]').show();
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=zx]').hide();
    			$('[id=ql]').hide();
    			$('[id=xq]').hide();
    			$('[id=zhj]').hide();
    			
    			$('#heji').attr("colSpan","5");
    		}else if(type == "3"){
    			$('[id*=]').show();
    			$('[id=ql]').hide();
    			$('[id=xq]').hide();
    			$('#heji').attr("colSpan","10");
    			
    		}else if(type == "4"){
    			$('[id=qj]').show();
    			$('[id=zj]').show();
    			$('[id=sylx]').show();
    			$('[id=pqxfl]').show();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=ql]').show();
    			$('[id=ql1]').show();
    			$('[id=zhj]').show();
    			$('#heji').attr("colSpan","13");
    			
    		}else if(type == "5"){
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=zrl]').show();
    			$('[id=crl]').show();
    			$('[id=ql]').hide();
    			$('[id=ql1]').hide();
    			$('[id=zhj]').hide();
    			$('#heji').attr("colSpan","9");
    			
    		}else if(type == "6"){
    		
    			$('[id*=]').show();
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=zx]').hide();
    			$('[id=ql]').hide();
    			$('[id=xq]').hide();
    			$('[id=zhj]').hide();
    			$('#heji').attr("colSpan","5");
    			
    		}else if(type == "7"){
    		
    			$('[id*=]').show();
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=zx]').hide();
    			$('[id=ql]').hide();
    			$('[id=xq]').hide();
    			$('[id=zhj]').hide();
    			$('#heji').attr("colSpan","5");
    			
    		}
    		
    		$('#div_goodslist').attr("style","display:");
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
     function changebarcode(index,obj){
 		if(!obj.val()){
 			return;
 		}
    	   	
    	   	if(!/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})/.test(obj.val())&&obj.val()){
 			alert("日期格式不正确！\n如：2013-04-01");
 			obj.val("");
 			obj.focus();
 			return;
    	   	}
    	 	var str =obj.val();
    		str = str.replace(/-/g,"/");
    		var date = new Date(str );
    		obj.val(ChangeDateToString(date));
    	   	if(obj.val().length==10){
 	   		var pclength = obj.val().length;
 	   		var pcvalue = obj.val();
 	   		
 	   		if(pclength < 8){
 	   			for(pclength ; pclength < 8; pclength++){
 	   				pcvalue = pcvalue + '0';
 	   			}
 	   		}else if(pclength > 8){
 	   			pcvalue=pcvalue.substring(pclength-8,pclength);
 	   		}	
 	   		
 	   		var tmvalue = $(obj).parent().parent().find("#pcbarcode").val().substring(0,18);
 	   		var xqvalue = $(obj).val().replace(/\-/g,"").substring(2);
 	   		var bcvalue = $(obj).parent().parent().find("#pcbarcode").val().substring(24,26);
 	   		$(obj).parent().parent().find("#pcbarcode").val(tmvalue+xqvalue+bcvalue);
    	   	}
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
    	}else{
      		document.all.cstiauditstate1.checked = false;	
    	}
    }

		function deleteROW(){
	   		var tablelength = $('#addTable tr').length;
	   		type = $('#cstpgoodscategory').val();
	   		
	   		if(tablelength > 2){
	 				var i = 0;
				$('#addTable tr').each(function (){
					i++;
					if(i > 2){
						$(this).remove();
					}
				});
				
	  				return true;
			}else{
				return true;
			}
		  }

  	function changeGoodsCategory(){
  		$('#cstisupplierid').val('');
  		$('#cstisuppliername').val('');
  		$('#brandName').val('');
  		$('#brandID').val('');
  		$("#cstisourcebillid").val("");
  		deleteROW();
    }
	
    function copyRow(obj){
    	$(obj).parent().parent().clone(true).appendTo($(obj).parent().parent());
    	amount();
	}

    function loadSimpleBatch(barcode,batch,obj){
   	   	if(($(obj).attr("id") == "batch"&&$(obj).parent().parent().find("#guaranteeperiod").val() != "")||($(obj).attr("id") == "guaranteeperiod"&&$(obj).parent().parent().find("#batch").val() != "")){
	   	   	$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "getAjaxSimpleBatch.action",          
	   	   	    async: true, 
	   	   	    data: "barcode="+barcode+"&batch="+batch,     
	   	   	    success: function(msg){
		   	   		var barcodestr = $(obj).parent().parent().find("#pcbarcode").val();   
		   	   		$(obj).parent().parent().find("#pcbarcode").val(barcodestr.substring(0,24)+msg);                       
	   	   	    }    
		   	});
   	   	}
    }
    
   function ChangeDateToString(DateIn){
	   var Year=0;
	   var Month= 0;
	   var Day =0;
	   var CurrentDate = "";
	 
       Year  =DateIn.getYear();
       Month =DateIn.getMonth()+1;
       Day =DateIn.getDate();
       CurrentDate =Year +"-";
	       
	   if(Month >=10)
	   {
	     CurrentDate  =CurrentDate +Month + "-";
	   }else{
	     CurrentDate =CurrentDate+"0"+Month +"-";
	   }
	   if(Day >=10){
	     CurrentDate=CurrentDate +Day;
	   }else{
	     CurrentDate =CurrentDate +"0"+Day;
	   }
	     
	   return CurrentDate;
    
   }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="salesOutForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="goodstype" name="goodstype" value="${goodstype }">
<input type="hidden" id="person" value="${person.id }"/>
<input type="hidden" id="havebatch" name="havebatch" value="1"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
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
			               <TD class="table_none">${person.personName }<input class="text_input100" type="hidden" name="inventoryPo.csticreateperson" value="${person.id }"></TD>
			               
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
                          <TD align="left" width="60%">
						   <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" 
						  onClick="javascript:openGoodSingle();">
						  <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();">
					      </TD>
					      <TD  align="right" width="40%">
					      <img src="${ctx }/img/newbtn/btn_delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');" title="删除" onClick="deleteitem();" >
                         </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <div id="div_goodslist" style="display: none;">
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
	                          	<li class="horizontal_onlyRight">
	                          	<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" title='保存' onclick="save();">
	                          	</li>
	                          	<c:if test="${(permissionPo.keyi==1)}">
	                          	<li class="horizontal_onlyRight">
	                          	<input type="checkbox" id="cstiauditstate1" onclick="check()" value="1">保存并审核
	                          	</li>
	                          	</c:if>
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
                          <TH width="12%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>型号</TH>
                          <TH width="5%" scope=col>数量</TH>
                          <c:if test="${permissionPo.keyf == 1}">
                          <TH width="5%" scope=col>单位成本</TH>
                          <TH width="5%" scope=col>成本合计</TH>
                          <TH width="5%" scope=col>税率</TH>
                          </c:if>
                          <TH width="5%" scope=col>批发单价</TH>
                          <TH width="5%" scope=col>批发金额</TH>
                          <TH width="5%" scope=col>效期</TH>
                          <TH width="5%" scope=col>批号</TH>
                          <TH width="8%" scope=col>商品条码</TH>
                                                     
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
					    	<th scope=col width="6%">&nbsp;</th>
					    	<th scope=col width="6%">&nbsp;</th>
				   		</tr>                        
                      </TBODY>
                    </TABLE>
                    </div>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
                          		<li class="horizontal_onlyRight">
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" title='保存' onclick="save();">
                          		</li>
                          		<c:if test="${(permissionPo.keyi==1)}">
                          		<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstiauditstate" onclick="check1()" name="inventoryPo.cstiauditstate" value="1">保存并审核
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