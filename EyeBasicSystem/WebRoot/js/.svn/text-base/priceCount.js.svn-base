    /**
    * 改变计算方式
    **/
    function changeRadioType(obj,stateArray){    
    	var objValue=obj.value;
    	var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
    	
    	if(objValue=="autoCount"){    	
    		if(confirm('您选择了自动计算，系统会自动计算选取的商品数据。\n所有列出商品的成本合计、价税合计、税额合计会重新进行计算，您确认要自动计算么?')){
    			changeInputType(goodsquantityArray,stateArray[0][0],stateArray[0][1]); 
    			changeInputType(nottaxrateArray,stateArray[1][0],stateArray[1][1]);
	    		changeInputType(nottaxrateamountArray,stateArray[2][0],stateArray[2][1]);
	    		changeInputType(taxrateArray,stateArray[3][0],stateArray[3][1]);
	    		changeInputType(costpriceArray,stateArray[4][0],stateArray[4][1]);
	    		changeInputType(costpriceamountArray,stateArray[5][0],stateArray[5][1]);
	    		changeInputType(taxamountArray,stateArray[6][0],stateArray[6][1]); 
	    		initAutoCount();  
	    	}else{
	    		document.getElementById("autoCount").checked=false;
	    		document.getElementById("notAutoCount").checked=true;
	    		
	    	}
    	}else if(objValue=="notAutoCount"){
    			changeInputType(goodsquantityArray,stateArray[0][2],stateArray[0][3]); 
    			changeInputType(nottaxrateArray,stateArray[1][2],stateArray[1][3]); 
	    		changeInputType(nottaxrateamountArray,stateArray[2][2],stateArray[2][3]); 
	    		changeInputType(taxrateArray,stateArray[3][2],stateArray[3][3]); 
	    		changeInputType(costpriceArray,stateArray[4][2],stateArray[4][3]); 
	    		changeInputType(costpriceamountArray,stateArray[5][2],stateArray[5][3]); 
	    		changeInputType(taxamountArray,stateArray[6][2],stateArray[6][3]); 
    	}			
    }
  
    /**
    * 初始化自动计算
    **/
    function initAutoCount(stateArray){    
    	
    	var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
    	
    	changeInputType(goodsquantityArray,stateArray[0][0],stateArray[0][1]); 
		changeInputType(nottaxrateArray,stateArray[1][0],stateArray[1][1]);
   		changeInputType(nottaxrateamountArray,stateArray[2][0],stateArray[2][1]);
   		changeInputType(taxrateArray,stateArray[3][0],stateArray[3][1]);
   		changeInputType(costpriceArray,stateArray[4][0],stateArray[4][1]);
   		changeInputType(costpriceamountArray,stateArray[5][0],stateArray[5][1]);
   		changeInputType(taxamountArray,stateArray[6][0],stateArray[6][1]); 
   		initAutoCount();
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
    
    /**
    * 初始化所有自动计算
	* 参数
	*/
	function initAutoCount(){
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
		for(i=0;i<nottaxrateArray.length;i++){
			nottaxrateamountArray[i].value=parseFloat(goodsquantityArray[i].value).mul(nottaxrateArray[i].value).toFixed(2);
			costpriceamountArray[i].value=parseFloat(goodsquantityArray[i].value).mul(costpriceArray[i].value).toFixed(2);
			taxamountArray[i].value=(costpriceamountArray[i].value-nottaxrateamountArray[i].value).toFixed(2);
			
			goodsquantityTotal = (parseFloat(goodsquantityTotal)+parseFloat(goodsquantityArray[i].value)).toFixed(0);
			nottaxrateamountTotal = (parseFloat(nottaxrateamountTotal)+parseFloat(nottaxrateamountArray[i].value)).toFixed(2);
			costpriceamountTotal =(parseFloat(costpriceamountTotal)+parseFloat(costpriceamountArray[i].value)).toFixed(2);
			taxamountTotal = (parseFloat(taxamountTotal)+parseFloat(taxamountArray[i].value)).toFixed(2);
			if(takepriceamountArray[i]){
				takepriceamountTotal =(parseFloat(takepriceamountTotal)+parseFloat(takepriceamountArray[i].value)).toFixed(2);
			}
			//taxamountTotal = (parseFloat(taxamountTotal)+parseFloat(taxamountArray[i].value)).toFixed(2);
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

	/**
	*计算各列合计
	**/
	function totalCount(){
		var goodsquantityTotal=0;
    	var nottaxrateamountTotal=0;
    	var costpriceamountTotal=0;
    	var taxamountTotal=0;
    	
    	var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
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

    /**
    * 自动计算某一行
	* 参数
	*/
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
		 	
    	nottaxrateArray[indexObj].value=parseFloat(accDiv(parseFloat(costpriceArray[indexObj].value),parseFloat(accAdd(accDiv(taxrateArray[indexObj].value,100),1)))).toFixed(6);
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
    * 更改Input状态
	* 参数
	* obj         :Array对象
	* readOnlyFlag      :readOnly属性
	* eventFlag		:操作Event方式
	*/
	function changeInputType(obj,readOnlyFlag,eventFlag){
		for(i=0;i<obj.length;i++){
			obj[i].readOnly=readOnlyFlag;//设定obj的readOnly属性				
			if(readOnlyFlag){
				obj[i].style.backgroundColor="#ACA899";
			}else{
				obj[i].style.backgroundColor="FFFFFF";
			}
			var tempFunction=function(){
				autoCountOnlyOne(this);
			}
			
			if(eventFlag=="autoCountOnlyOne"){
				obj[i].onchange=tempFunction;
			}else if(eventFlag=="remove"){
				obj[i].onchange=remove;
			}else if(eventFlag=="totalCount"){
				obj[i].onchange=totalCount;
			}else if(eventFlag==""){				
			}				
		}
	}	
	
	function remove(){
	}

/**
 *获得对象数组下标，
 *@param objName为对象名称
 *@param obj为对象数组中的对象
 *@return num为数组下标
 *例：getObjArrSuffix(this.name,this) 
 */
function getObjArrSuffix(objName,obj) {
	var objsTmp = document.getElementsByName(objName);
	var num;
	for (var i = 0; i < objsTmp.length; i++) {
		if (objsTmp[i] == obj) {
			num = i;
			break;
		}
	}
	return num;
}