<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="setmeal_top3.jsp"%>

<style type="text/css">
#１ {
	color: #F00;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 14px;
}
#tabContent__1 div .privateBorder tbody .row td #１ {
	font-size: 18px;
}
.STYLE1 {	color: #FF0000;
	font-weight: bold;
}
.noneInput {
  background-color:transparent;
  border:0px;
  text-align: center;
}
.inInput{
  width: 50px;  
}

.readyonlyInput{
    background-color:#ACA899;
    width:100%;    
}

</style>

<script type="text/javascript">

$(document).ready(function() {
	$("img[btn=btn]").attr("style","cursor: hand");
	$("img[btn=btn]").mouseover(function () {
    	$(this).attr("src",$(this).attr("src").replace("0","1"));
	}).mouseout(function () {
		$(this).attr("src",$(this).attr("src").replace("1","0"));
	});

    $('input[type=text]').bind('blur',function(){
        $(this).val($.trim($(this).val()));
    });

});

function clean(){
	$('#setMealFrm').find("input[clean=clean]").each(function(){
		$(this).val('');
	});
	$('#setMealFrm').find("select[clean=clean]").each(function(){
		$(this).val('');
	});
	$('#setMealFrm').find("textarea[clean=clean]").each(function(){
		$(this).val('');
	});
}

/**
 * 新增时保存
 */
function save(){

	//验证是否已选择商品
    if(goodsCount()){
	    alert('请选择商品!');
	    return;
    }

    //验证整单满金额
	try{  
		if(typeof(eval(salesbillamount))=="function"){
			if (salesbillamount()){
                return;
			}
		}
	}catch(e){
	}

    if ($('input[name=setMealPo.ssmsmdetailform]').val() == '11' && $('select[youhui=youhui]').size() == 0){
	    alert('请选择优惠商品!');
	    return;
    }
    if (($('input[name=setMealPo.ssmsmdetailform]').val() == '11' || $('input[name=setMealPo.ssmsmdetailform]').val() == '12') && $('select[xiaofei=xiaofei]').size() == 0 ){
	    alert('请选择购买商品!');
	    return;
    }

	if(checkForm(setMealFrm)){		
        // 选中所有商品的属性列表
        $('select[name=goodspropertyarray]').each(function(){
			for(var i = 0; i < $(this).find("option").length; i++){
				$(this).find("option")[i].selected='selected';
				$(this).find("option")[i].click();
			}
		});

		// 验证各种金额和数量是否正确
		if (validateData()){
            return;
		}

		// 验证商品是否选择重复
		if (validateSalesGoodsProperty()){
			alert('所选商品及其属性可能重复,请重新选择!');
	        return;
		}
		if (validateCreditGoodsProperty()){
			alert('所选商品及其属性可能重复,请重新选择!');
	        return;
		}
		if (validateGoodsProperty()){
			alert('所选商品及其属性可能重复,请重新选择!');
	        return;
		}
			    
		$("img").removeAttr("onclick");
		setMealFrm.action = "insertSetMeal.action";
	    setMealFrm.submit();
	}
}

/**
 * 修改时保存
 */
function save2(){

	//验证是否已选择商品
    if(goodsCount()){
	    alert('请选择商品!');
	    return;
    }

    //验证整单满金额
	try{  
		if(typeof(eval(salesbillamount))=="function"){
			if (salesbillamount()){
                return;
			}
		}
	}catch(e){
	}

    if ($('input[name=setMealPo.ssmsmdetailform]').val() == '11' && $('select[youhui=youhui]').size() == 0){
	    alert('请选择优惠商品!');
	    return;
    }
    if (($('input[name=setMealPo.ssmsmdetailform]').val() == '11' || $('input[name=setMealPo.ssmsmdetailform]').val() == '12') && $('select[xiaofei=xiaofei]').size() == 0 ){
	    alert('请选择购买商品!');
	    return;
    }
    
	if(checkForm(setMealFrm)){
				
        // 选中所有商品的属性列表
        $('select[name=goodspropertyarray]').each(function(){
			for(var i = 0; i < $(this).find("option").length; i++){
				$(this).find("option")[i].selected='selected';
				$(this).find("option")[i].click();
			}
		});

		// 验证各种金额和数量是否正确
		if (validateData()){
            return;
		}

		// 验证商品是否选择重复
		if (validateSalesGoodsProperty()){
			alert('所选商品及其属性可能重复,请重新选择!');
	        return;
		}
		if (validateCreditGoodsProperty()){
			alert('所选商品及其属性可能重复,请重新选择!');
	        return;
		}
		if (validateGoodsProperty()){
			alert('所选商品及其属性可能重复,请重新选择!');
	        return;
		}
			    
		$("img").removeAttr("onclick");
		setMealFrm.action = "updateSetMeal.action";
	    setMealFrm.submit();
	}
}

/**
 * 验证商品是否选择重复
 */
 function validateGoodsProperty(){

    var counti = $('select[xiaofei=xiaofei]').size();
    var goodscategoryID = document.getElementsByName("goodscategoryID");
    var i_propertyArray = document.getElementsByName("salesGoodsArray.ssmspropertyvaluearray");
    var i_goodsIDArray = document.getElementsByName("salesGoodsArray.ssmsggoodsid");
    var i_brandIDArray = document.getElementsByName("salesGoodsArray.ssmsgbrand");
    var i_supplierIDArray = document.getElementsByName("salesGoodsArray.ssmsgsupplier");
    var i_beginAmount = document.getElementsByName("salesGoodsArray.ssmsgbeginAmount");
    var i_endAmount = document.getElementsByName("salesGoodsArray.ssmsgendAmount");
    var i_mincostPrice = document.getElementsByName("salesGoodsArray.ssmsgmincostPrice");
    var i_maxcostPrice = document.getElementsByName("salesGoodsArray.ssmsgmaxcostPrice");

    var countj = $('select[youhui=youhui]').size();
    var j_propertyArray = document.getElementsByName("creditGoodsArray.ssmspropertyvaluearray");
    var j_goodsIDArray = document.getElementsByName("creditGoodsArray.ssmsggoodsid");
    var j_brandIDArray = document.getElementsByName("creditGoodsArray.ssmsgbrand");
    var j_supplierIDArray = document.getElementsByName("creditGoodsArray.ssmsgsupplier");
    var j_beginAmount = document.getElementsByName("creditGoodsArray.ssmsgbeginAmount");
    var j_endAmount = document.getElementsByName("creditGoodsArray.ssmsgendAmount");
    var j_mincostPrice = document.getElementsByName("creditGoodsArray.ssmsgmincostPrice");
    var j_maxcostPrice = document.getElementsByName("creditGoodsArray.ssmsgmaxcostPrice");

    return validateGoodsPropertyRepeat(counti,countj,0,goodscategoryID,i_propertyArray,j_propertyArray,i_supplierIDArray,j_supplierIDArray,i_brandIDArray,j_brandIDArray,i_goodsIDArray,j_goodsIDArray,i_beginAmount,j_beginAmount,i_endAmount,j_endAmount,i_mincostPrice,j_mincostPrice,i_maxcostPrice,j_maxcostPrice);

}

/**
 * 验证商品是否选择重复
 */
function validateSalesGoodsProperty(){

	var salesflag = $('input[name=setMealPo.ssmsmsalesflag]:checked').val();
	var creditflag = $('input[name=setMealPo.ssmsmcreditflag]:checked').val();

    //验证购买区
    var count = $('select[xiaofei=xiaofei]').size();
    var goodscategoryID = document.getElementsByName("goodscategoryID");
    var propertyArray = document.getElementsByName("salesGoodsArray.ssmspropertyvaluearray");
    var goodsIDArray = document.getElementsByName("salesGoodsArray.ssmsggoodsid");
    var brandIDArray = document.getElementsByName("salesGoodsArray.ssmsgbrand");
    var supplierIDArray = document.getElementsByName("salesGoodsArray.ssmsgsupplier");
    var beginAmount = document.getElementsByName("salesGoodsArray.ssmsgbeginAmount");
    var endAmount = document.getElementsByName("salesGoodsArray.ssmsgendAmount");
    var mincostPrice = document.getElementsByName("salesGoodsArray.ssmsgmincostPrice");
    var maxcostPrice = document.getElementsByName("salesGoodsArray.ssmsgmaxcostPrice");

    //return validateGoodsPropertyRepeat(counti,countj,0,goodscategoryID,i_propertyArray,j_propertyArray,i_supplierIDArray,j_supplierIDArray,i_brandIDArray,j_brandIDArray,i_goodsIDArray,j_goodsIDArray,i_beginAmount,j_beginAmount,i_endAmount,j_endAmount,i_mincostPrice,j_mincostPrice,i_maxcostPrice,j_maxcostPrice);
    
    for (var i = 0; (i < count && count > 1); i++){
        for (var j = i + 1; j < count; j++){
        	if (goodscategoryID[i].value.substring(0,1) == goodscategoryID[j].value.substring(0,1)){

                var temp_a1 = beginAmount[i].value == '' ? mincostPrice[i].value : beginAmount[i].value;
                var temp_a2 = endAmount[i].value == '' ? maxcostPrice[i].value : endAmount[i].value;
                var temp_b1 = beginAmount[j].value == '' ? mincostPrice[j].value : beginAmount[j].value;
                var temp_b2 = endAmount[j].value == '' ? maxcostPrice[j].value : endAmount[j].value;
                
                if (goodscategoryID[i].value.substring(0,1) == '6'){                    
                	if ((goodscategoryID[i].value.substring(3,2) == goodscategoryID[j].value.substring(3,2)) && (goodscategoryID[i].value.substring(3,2) == '8')){   // 同为老花镜
                        //判断套餐区间
                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                            return true;
                        }
                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                            return true;
                        }
                    }
                    
                	if ((goodscategoryID[i].value.substring(3,2) == goodscategoryID[j].value.substring(3,2)) && (goodscategoryID[i].value.substring(3,2) == '6')){   // 同为太阳镜
                    	//判断太阳镜功能是否相同
                    	if ((propertyArray[i].value == propertyArray[j].value) || propertyArray[j].value == '' || propertyArray[i].value == ''){

                            //判断制造商
                            if (supplierIDArray[i].value == '' || supplierIDArray[j].value == '' ){
                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                    return true;
                                }
                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                    return true;
                                }
                            }else if (supplierIDArray[i].value == supplierIDArray[j].value){
                                //判断品种
                                if (brandIDArray[i].value == '' || brandIDArray[j].value == ''  ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (brandIDArray[i].value == brandIDArray[j].value){
                                    //商品代码
                                    if (goodsIDArray[i].value == '' || goodsIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (goodsIDArray[i].value == goodsIDArray[j].value){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }                                       
                                    }else {
                                    	if (goodsIDArray[i].value.length != goodsIDArray[j].value.length){  // 例如制造商对应品种
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }
                                    }                                    
                                }                                
                            }                            
                        }                                       		
                    }
                }else {
                    if (goodscategoryID[i].value.substring(0,1) == '3' || goodscategoryID[i].value.substring(0,1) == '4'){

                    	if ((goodscategoryID[i].value.length == 1 || goodscategoryID[j].value.length == 1) || (goodscategoryID[i].value == goodscategoryID[j].value)){
                    		//判断镜片或隐性镜片属性是否相同
                            var a = new Array(8); // 镜片6个属性,索引表示各个属性的ID,要声明8个
                            for (var k = 0; k < a.length; k++){  //初始化
                                a[k] = '';
                            }

                            var a1 = new Array();
                            if (propertyArray[i].value.indexOf(',') > 0){
                            	a1 = propertyArray[i].value.split(',');
                            }else{
                            	a1[0] = propertyArray[i].value;
                            }

                            for (var k = 0; k < a1.length; k++){
                            	if (a1[k].indexOf(';') > 0){
                                    switch(a1[k].split(';')[0]){
                                    case '1':
                                        a[1] = a1[k].split(';')[1];
                                        break;
                                    case '2':
                                    	a[2] = a1[k].split(';')[1];
                                        break;
                                    case '3':
                                    	a[3] = a1[k].split(';')[1];
                                        break;
                                    case '4':
                                    	a[4] = a1[k].split(';')[1];
                                        break;
                                    case '5':
                                    	a[5] = a1[k].split(';')[1];
                                        break;
                                    case '6':
                                    	a[6] = a1[k].split(';')[1];
                                        break;
                                    }
                                }
                            }

                            var b = new Array(8); // 镜片6个属性,索引表示各个属性的ID
                            for (var k = 0; k < a.length; k++){  //初始化
                                b[k] = '';
                            }

                            var b1 = new Array();
                            if (propertyArray[j].value.indexOf(',') > 0){
                            	b1 = propertyArray[j].value.split(',');
                            }else{
                            	b1[0] = propertyArray[j].value;
                            }

                            for (var k = 0; k < b1.length; k++){
                            	if (b1[k].indexOf(';') > 0){
                                    switch(b1[k].split(';')[0]){
                                    case '1':
                                        b[1] = b1[k].split(';')[1];
                                        break;
                                    case '2':
                                    	b[2] = b1[k].split(';')[1];
                                        break;
                                    case '3':
                                    	b[3] = b1[k].split(';')[1];
                                        break;
                                    case '4':
                                    	b[4] = b1[k].split(';')[1];
                                        break;
                                    case '5':
                                    	b[5] = b1[k].split(';')[1];
                                        break;
                                    case '6':
                                    	b[6] = b1[k].split(';')[1];
                                        break;
                                    }
                                }
                            }
                            
                            var kcount = 0;
                            var kcount5 = '';
                            for (var k = 1; k <= 7; k++){

                                if ((a[k] == b[k]) || a[k] == '' || b[k] == ''){
                                    if (k == 5){
                                    	kcount5 = 'Y';
                                    }
                                    continue;
                                }else{
                                	if (k == 5){
                                        var temp_a1 = a[k].split(':')[0];
                                        var temp_a2 = a[k].split(':')[1];
                                        var temp_b1 = b[k].split(':')[0];
                                        var temp_b2 = b[k].split(':')[1];
                                        
                                        if ((((Number(temp_a1) >= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) <= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) >= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) <= Number(temp_b2)) || temp_a2 == ''))){
                                        	kcount5 = 'Y';
                                        	continue;
                                        }
                                        if ((((Number(temp_b1) >= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) <= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) >= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) <= Number(temp_a2)) || temp_b2 == ''))){
                                        	kcount5 = 'Y';
                                        	continue;
                                        }

                                        kcount5 = 'N';
                                        
                                    }else if (k == 6){
                                        var temp_a1 = a[k].split(':')[0];
                                        var temp_a2 = a[k].split(':')[1];
                                        var temp_b1 = b[k].split(':')[0];
                                        var temp_b2 = b[k].split(':')[1];
                                        
                                        if ((((Number(temp_a1) >= Number(temp_b1)) || temp_a1 == '' || temp_b1 == '') && ((Number(temp_a2) <= Number(temp_b1)) || temp_a2 == '' || temp_b1 == '')) || (((Number(temp_a1) >= Number(temp_b2)) || temp_a1 == '' || temp_b2 == '') && ((Number(temp_a2) <= Number(temp_b2)) || temp_a2 == '' || temp_b2 == ''))){
                                            if (kcount5 == 'Y'){
                                            	return true;
                                            }
                                        	continue;
                                        }
                                        if ((((Number(temp_b1) >= Number(temp_a1)) || temp_b1 == '' || temp_a1 == '') && ((Number(temp_b2) <= Number(temp_a1)) || temp_b2 == '' || temp_a1 == '')) || (((Number(temp_b1) >= Number(temp_a2)) || temp_b1 == '' || temp_a2 == '') && ((Number(temp_b2) <= Number(temp_a2)) || temp_b2 == '' || temp_a2 == ''))){
                                            if (kcount5 == 'Y'){
                                            	return true;
                                            }
                                        	continue;
                                        }
                                        
                                    }else{
                                    	kcount = 1;
                                    	break;
                                    }
                                }
                            }

                            if (kcount == 0){
                                //判断制造商
                                if (supplierIDArray[i].value == '' || supplierIDArray[j].value == '' ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (supplierIDArray[i].value == supplierIDArray[j].value){
                                    //判断品种
                                    if (brandIDArray[i].value == '' || brandIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (brandIDArray[i].value == brandIDArray[j].value){
                                        //商品代码
                                        if (goodsIDArray[i].value == '' || goodsIDArray[j].value == ''  ){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }else if (goodsIDArray[i].value == goodsIDArray[j].value){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }                                      
                                        }else {
                                        	if (goodsIDArray[i].value.length != goodsIDArray[j].value.length){  // 例如制造商对应品种
                                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                    return true;
                                                }
                                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                    return true;
                                                }
                                            }
                                        }                                    
                                    }                                
                                }  
                            }
                                                       
                        }
                                              
                    }else{
                    	if (goodscategoryID[i].value.substring(0,1) == '1'){   // 同为镜架
                        	//判断材质是否相同
                        	if ((propertyArray[i].value == propertyArray[j].value) || propertyArray[j].value == '' || propertyArray[i].value == ''){

                                //判断制造商
                                if (supplierIDArray[i].value == '' || supplierIDArray[j].value == '' ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (supplierIDArray[i].value == supplierIDArray[j].value){
                                    //判断品种
                                    if (brandIDArray[i].value == '' || brandIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (brandIDArray[i].value == brandIDArray[j].value){
                                        //商品代码
                                        if (goodsIDArray[i].value == '' || goodsIDArray[j].value == ''  ){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }else if (goodsIDArray[i].value == goodsIDArray[j].value){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }                                      
                                        }else {
                                        	if (goodsIDArray[i].value.length != goodsIDArray[j].value.length){  // 例如制造商对应品种
                                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                    return true;
                                                }
                                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                    return true;
                                                }
                                            }
                                        }                                    
                                    }                                
                                }                            
                            }
                        }else{
                            //判断制造商
                            if (supplierIDArray[i].value == '' || supplierIDArray[j].value == '' ){
                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                    return true;
                                }
                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                    return true;
                                }
                            }else if (supplierIDArray[i].value == supplierIDArray[j].value){
                                //判断品种
                                if (brandIDArray[i].value == '' || brandIDArray[j].value == ''  ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (brandIDArray[i].value == brandIDArray[j].value){
                                    //商品代码
                                    if (goodsIDArray[i].value == '' || goodsIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (goodsIDArray[i].value == goodsIDArray[j].value){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }                                       
                                    }else {
                                    	if (goodsIDArray[i].value.length != goodsIDArray[j].value.length){  // 例如制造商对应品种
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }
                                    }                                    
                                }                                
                            }
                            
                        }
                    }
                }
                     
            }            
        }
    }

	return false;
}

/**
 * 验证商品是否选择重复
 */
function validateCreditGoodsProperty(){
	
    //验证优惠区
    var count = $('select[youhui=youhui]').size();    
    var goodscategoryID = document.getElementsByName("goodscategoryID");
    var idx = 0;
    if ($('select[xioafei=xiaofei]').size() > 0 ){
    	idx = Number(accSub(goodscategoryID.length,$('select[xioafei=xiaofei]').size())) > 1 ? accSub(accSub(goodscategoryID.length,$('select[xioafei=xiaofei]').size()),1) : accSub(goodscategoryID.length,$('select[xioafei=xiaofei]').size());
    }
    var propertyArray = document.getElementsByName("creditGoodsArray.ssmspropertyvaluearray");
    var goodsIDArray = document.getElementsByName("creditGoodsArray.ssmsggoodsid");
    var brandIDArray = document.getElementsByName("creditGoodsArray.ssmsgbrand");
    var supplierIDArray = document.getElementsByName("creditGoodsArray.ssmsgsupplier");
    var beginAmount = document.getElementsByName("creditGoodsArray.ssmsgbeginAmount");
    var endAmount = document.getElementsByName("creditGoodsArray.ssmsgendAmount");
    var mincostPrice = document.getElementsByName("creditGoodsArray.ssmsgmincostPrice");
    var maxcostPrice = document.getElementsByName("creditGoodsArray.ssmsgmaxcostPrice");

    //return validateGoodsPropertyRepeat(counti,countj,0,goodscategoryID,i_propertyArray,j_propertyArray,i_supplierIDArray,j_supplierIDArray,i_brandIDArray,j_brandIDArray,i_goodsIDArray,j_goodsIDArray,i_beginAmount,j_beginAmount,i_endAmount,j_endAmount,i_mincostPrice,j_mincostPrice,i_maxcostPrice,j_maxcostPrice);
    
    for (var i = idx; (i < count && count > 1); i++){
        for (var j = i + 1; j < count; j++){
        	if (goodscategoryID[i].value.substring(0,1) == goodscategoryID[j].value.substring(0,1)){

                var temp_a1 = beginAmount[i].value == '' ? mincostPrice[i].value : beginAmount[i].value;
                var temp_a2 = endAmount[i].value == '' ? maxcostPrice[i].value : endAmount[i].value;
                var temp_b1 = beginAmount[j].value == '' ? mincostPrice[j].value : beginAmount[j].value;
                var temp_b2 = endAmount[j].value == '' ? maxcostPrice[j].value : endAmount[j].value;
                
                if (goodscategoryID[i].value.substring(0,1) == '6'){                    
                	if ((goodscategoryID[i].value.substring(3,2) == goodscategoryID[j].value.substring(3,2)) && (goodscategoryID[i].value.substring(3,2) == '8')){   // 同为老花镜
                        //判断套餐区间
                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                            return true;
                        }
                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                            return true;
                        }
                    }
                    
                	if ((goodscategoryID[i].value.substring(3,2) == goodscategoryID[j].value.substring(3,2)) && (goodscategoryID[i].value.substring(3,2) == '6')){   // 同为太阳镜
                    	//判断太阳镜功能是否相同
                    	if ((propertyArray[i].value == propertyArray[j].value) || propertyArray[j].value == '' || propertyArray[i].value == ''){

                            //判断制造商
                            if (supplierIDArray[i].value == '' || supplierIDArray[j].value == '' ){
                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                    return true;
                                }
                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                    return true;
                                }
                            }else if (supplierIDArray[i].value == supplierIDArray[j].value){
                                //判断品种
                                if (brandIDArray[i].value == '' || brandIDArray[j].value == ''  ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (brandIDArray[i].value == brandIDArray[j].value){
                                    //商品代码
                                    if (goodsIDArray[i].value == '' || goodsIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (goodsIDArray[i].value == goodsIDArray[j].value){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }                                       
                                    }else {
                                    	if (goodsIDArray[i].value.length != goodsIDArray[j].value.length){  // 例如制造商对应品种
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }
                                    }                                    
                                }                                
                            }                            
                        }                                       		
                    }
                }else {
                    if (goodscategoryID[i].value.substring(0,1) == '3' || goodscategoryID[i].value.substring(0,1) == '4'){

                    	if ((goodscategoryID[i].value.length == 1 || goodscategoryID[j].value.length == 1) || (goodscategoryID[i].value == goodscategoryID[j].value)){
                    		//判断镜片或隐性镜片属性是否相同
                            var a = new Array(8); // 镜片6个属性,索引表示各个属性的ID,要声明8个
                            for (var k = 0; k < a.length; k++){  //初始化
                                a[k] = '';
                            }

                            var a1 = new Array();
                            if (propertyArray[i].value.indexOf(',') > 0){
                            	a1 = propertyArray[i].value.split(',');
                            }else{
                            	a1[0] = propertyArray[i].value;
                            }

                            for (var k = 0; k < a1.length; k++){
                            	if (a1[k].indexOf(';') > 0){
                                    switch(a1[k].split(';')[0]){
                                    case '1':
                                        a[1] = a1[k].split(';')[1];
                                        break;
                                    case '2':
                                    	a[2] = a1[k].split(';')[1];
                                        break;
                                    case '3':
                                    	a[3] = a1[k].split(';')[1];
                                        break;
                                    case '4':
                                    	a[4] = a1[k].split(';')[1];
                                        break;
                                    case '5':
                                    	a[5] = a1[k].split(';')[1];
                                        break;
                                    case '6':
                                    	a[6] = a1[k].split(';')[1];
                                        break;
                                    }
                                }
                            }

                            var b = new Array(8); // 镜片6个属性,索引表示各个属性的ID
                            for (var k = 0; k < a.length; k++){  //初始化
                                b[k] = '';
                            }

                            var b1 = new Array();
                            if (propertyArray[j].value.indexOf(',') > 0){
                            	b1 = propertyArray[j].value.split(',');
                            }else{
                            	b1[0] = propertyArray[j].value;
                            }

                            for (var k = 0; k < b1.length; k++){
                            	if (b1[k].indexOf(';') > 0){
                                    switch(b1[k].split(';')[0]){
                                    case '1':
                                        b[1] = b1[k].split(';')[1];
                                        break;
                                    case '2':
                                    	b[2] = b1[k].split(';')[1];
                                        break;
                                    case '3':
                                    	b[3] = b1[k].split(';')[1];
                                        break;
                                    case '4':
                                    	b[4] = b1[k].split(';')[1];
                                        break;
                                    case '5':
                                    	b[5] = b1[k].split(';')[1];
                                        break;
                                    case '6':
                                    	b[6] = b1[k].split(';')[1];
                                        break;
                                    }
                                }
                            }
                            
                            var kcount = 0;
                            var kcount5 = '';
                            for (var k = 1; k <= 7; k++){

                                if ((a[k] == b[k]) || a[k] == '' || b[k] == ''){
                                    if (k == 5){
                                    	kcount5 = 'Y';
                                    }
                                    continue;
                                }else{
                                	if (k == 5){
                                        var temp_a1 = a[k].split(':')[0];
                                        var temp_a2 = a[k].split(':')[1];
                                        var temp_b1 = b[k].split(':')[0];
                                        var temp_b2 = b[k].split(':')[1];
                                        
                                        if ((((Number(temp_a1) >= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) <= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) >= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) <= Number(temp_b2)) || temp_a2 == ''))){
                                        	kcount5 = 'Y';
                                        	continue;
                                        }
                                        if ((((Number(temp_b1) >= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) <= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) >= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) <= Number(temp_a2)) || temp_b2 == ''))){
                                        	kcount5 = 'Y';
                                        	continue;
                                        }

                                        kcount5 = 'N';
                                        
                                    }else if (k == 6){
                                        var temp_a1 = a[k].split(':')[0];
                                        var temp_a2 = a[k].split(':')[1];
                                        var temp_b1 = b[k].split(':')[0];
                                        var temp_b2 = b[k].split(':')[1];
                                        
                                        if ((((Number(temp_a1) >= Number(temp_b1)) || temp_a1 == '' || temp_b1 == '') && ((Number(temp_a2) <= Number(temp_b1)) || temp_a2 == '' || temp_b1 == '')) || (((Number(temp_a1) >= Number(temp_b2)) || temp_a1 == '' || temp_b2 == '') && ((Number(temp_a2) <= Number(temp_b2)) || temp_a2 == '' || temp_b2 == ''))){
                                            if (kcount5 == 'Y'){
                                            	return true;
                                            }
                                        	continue;
                                        }
                                        if ((((Number(temp_b1) >= Number(temp_a1)) || temp_b1 == '' || temp_a1 == '') && ((Number(temp_b2) <= Number(temp_a1)) || temp_b2 == '' || temp_a1 == '')) || (((Number(temp_b1) >= Number(temp_a2)) || temp_b1 == '' || temp_a2 == '') && ((Number(temp_b2) <= Number(temp_a2)) || temp_b2 == '' || temp_a2 == ''))){
                                            if (kcount5 == 'Y'){
                                            	return true;
                                            }
                                        	continue;
                                        }
                                        
                                    }else{
                                    	kcount = 1;
                                    	break;
                                    }
                                }
                            }

                            if (kcount == 0){
                                //判断制造商
                                if (supplierIDArray[i].value == '' || supplierIDArray[j].value == '' ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (supplierIDArray[i].value == supplierIDArray[j].value){
                                    //判断品种
                                    if (brandIDArray[i].value == '' || brandIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (brandIDArray[i].value == brandIDArray[j].value){
                                        //商品代码
                                        if (goodsIDArray[i].value == '' || goodsIDArray[j].value == ''  ){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }else if (goodsIDArray[i].value == goodsIDArray[j].value){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }                                      
                                        }else {
                                        	if (goodsIDArray[i].value.length != goodsIDArray[j].value.length){  // 例如制造商对应品种
                                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                    return true;
                                                }
                                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                    return true;
                                                }
                                            }
                                        }                                    
                                    }                                
                                }  
                            }
                                                       
                        }
                                              
                    }else{
                    	if (goodscategoryID[i].value.substring(0,1) == '1'){   // 同为镜架
                        	//判断材质是否相同
                        	if ((propertyArray[i].value == propertyArray[j].value) || propertyArray[j].value == '' || propertyArray[i].value == ''){

                                //判断制造商
                                if (supplierIDArray[i].value == '' || supplierIDArray[j].value == '' ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (supplierIDArray[i].value == supplierIDArray[j].value){
                                    //判断品种
                                    if (brandIDArray[i].value == '' || brandIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (brandIDArray[i].value == brandIDArray[j].value){
                                        //商品代码
                                        if (goodsIDArray[i].value == '' || goodsIDArray[j].value == ''  ){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }else if (goodsIDArray[i].value == goodsIDArray[j].value){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }                                      
                                        }else {
                                        	if (goodsIDArray[i].value.length != goodsIDArray[j].value.length){  // 例如制造商对应品种
                                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                    return true;
                                                }
                                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                    return true;
                                                }
                                            }
                                        }                                    
                                    }                                
                                }                            
                            }
                        }else{
                            //判断制造商
                            if (supplierIDArray[i].value == '' || supplierIDArray[j].value == '' ){
                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                    return true;
                                }
                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                    return true;
                                }
                            }else if (supplierIDArray[i].value == supplierIDArray[j].value){
                                //判断品种
                                if (brandIDArray[i].value == '' || brandIDArray[j].value == ''  ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (brandIDArray[i].value == brandIDArray[j].value){
                                    //商品代码
                                    if (goodsIDArray[i].value == '' || goodsIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (goodsIDArray[i].value == goodsIDArray[j].value){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }                                       
                                    }else {
                                    	if (goodsIDArray[i].value.length != goodsIDArray[j].value.length){  // 例如制造商对应品种
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }
                                    }                                    
                                }                                
                            }
                            
                        }
                    }
                }
                     
            }            
        }
    }
    	
	return false;
}
	
function chkAll(obj){
	if ($(obj).attr('checked')){
		document.getElementById('departmentID').value = '${allDepartmentID}';
		document.getElementById('bdpdepartmentname').value = '${allDepartmentName}';
		document.getElementById('ds').value = '${allDepartmentName}';
	}else{
		document.getElementById('departmentID').value = '';
		document.getElementById('bdpdepartmentname').value = '';
		document.getElementById('ds').value = '';
	}
}

function chkAll1(){  
    var chks=document.all.chks1;
    $('input[id=chk1]').each(function(){ 
        $(this).attr("checked",chks.checked);
    }); 
}
 
function chkAll2(){  
    var chks=document.all.chks2;
    $('input[id=chk2]').each(function(){ 
        $(this).attr("checked",chks.checked);
    }); 
}

function check1(){
  if(document.all.auditState1.checked==true) {
  	document.all.auditState.checked = true;	
  }else {
  	document.all.auditState.checked = false;	
  }
}

 function check(){
  if(document.all.auditState.checked==true){
  	document.all.auditState1.checked = true;	
  }else {
  	document.all.auditState1.checked = false;	
  }
}

function removeOption(item,index){
	if ($(item).parent().parent().find('.gbc').find('option:selected').size() == 0){
        alert('请先选取需要移除的属性!');
        return;
	}
	$(item).parent().parent().find('.gbc').find('option:selected').remove();

    var fruitval0 = "";
    var fruit1 = "";
    $(item).parent().parent().find('.gbc').find('optgroup').find('option').each(function() {
        fruitval0 += $(this).val()+',';
        fruit1 += $(this).text()+',';
    });

    $('#ssmspropertyvaluearray' + index).val(fruitval0.substring(0,fruitval0.length-1));
    $('#ssmsgoodspropertyarray' + index).val(fruit1.substring(0,fruit1.length-1));
	
	if ($(item).parent().parent().find('.gbc').find('optgroup').find('option').length == 0){    
		$(item).parent().parent().hide();

	    $('#ssmspropertyvaluearray' + index).val('');
	    $('#ssmsgoodspropertyarray' + index).val('');

	    $('table[id="hideHeight'+index+'"]').hide();
	}

	clearGoods($(item).attr('idx'));
}

function addGoodsProperty(obj,index){
	
	var controlType = $(obj).parent().find('select:not(:hidden)').find('option:selected').val();
	
    if (controlType != '5' && controlType != '6' ){ //下拉菜单

    	if ($(obj).parent().find('select:not(:hidden):eq(1)').find('option:selected').val() == ''){
            alert('请选择商品属性值!');
            return;
        }
    	var titleContent = $(obj).parent().find('select:not(:hidden):eq(0)').find('option:selected').text();
    	var titleIndex = $(obj).parent().find('select:not(:hidden):eq(0)').find('option:selected').val();
    	var content = $(obj).parent().find('select:not(:hidden):eq(1)').find('option:selected').text();
    	var opnText = titleContent + ':' + content;        	
    	var opnIndex = controlType + ';' + $(obj).parent().find('select:not(:hidden):eq(1)').find('option:selected').val();

    	var parentIndex = '';
    	$(obj).parent().parent().parent().find('select[name=goodspropertyarray]').find('optgroup').find('option').each(function(){
            parentIndex = $(this).attr('parentID');
            if (parentIndex == titleIndex){
                $(this).remove();
            }
        });

    	$('table[id=hideHeight'+index+']').show();
    	$(obj).parent().parent().parent().find('tr[hide=hide]').show();
    	$(obj).parent().parent().parent().find('select[name=goodspropertyarray]').find('optgroup').prepend("<option value='" + opnIndex + "' parentID='" + titleIndex + "'>" + opnText + "</option>");

    }else{   // 文本区间

    	if ($(obj).parent().find('input:not(:hidden):eq(0)').val() == '' && $(obj).parent().find('input:not(:hidden):eq(1)').val() == ''){
            alert('请填写商品光度!');
            return;
        }
    	if ($(obj).parent().find('input:not(:hidden):eq(0)').val() != '' && $(obj).parent().find('input:not(:hidden):eq(1)').val() != ''){

        	if (Number($(obj).parent().find('input:not(:hidden):eq(0)').val()) < Number($(obj).parent().find('input:not(:hidden):eq(1)').val())){
                alert('下限值不应超过上限值,请重新填写光度!');
                return;
            }
        }
        
    	var titleContent = $(obj).parent().find('select:not(:hidden):eq(0)').find('option:selected').text();  
    	var titleIndex = $(obj).parent().find('select:not(:hidden):eq(0)').find('option:selected').val();    	
    	var content = $(obj).parent().find('input:not(:hidden):eq(0)').val() + '至' + $(obj).parent().find('input:not(:hidden):eq(1)').val();
    	var opnText = titleContent + ':' + content;
    	var opnIndex = controlType + ';' + $(obj).parent().find('input:not(:hidden):eq(0)').val() + ':' + $(obj).parent().find('input:not(:hidden):eq(1)').val();

    	var parentIndex = '';
    	$(obj).parent().parent().parent().find('select[name=goodspropertyarray]').find('optgroup').find('option').each(function(){
            parentIndex = $(this).attr('parentID');
            if (parentIndex == titleIndex){
                $(this).remove();
            }
        });

    	$('table[id="hideHeight'+index+'"]').show();
    	$(obj).parent().parent().parent().find('tr[hide=hide]').show();
    	$(obj).parent().parent().parent().find('select[name=goodspropertyarray]').find('optgroup').prepend("<option value='" + opnIndex + "' parentID='" + controlType + "'>" + opnText + "</option>");
     }
}

function changePropertyValue(obj,index){
    var fruitval0 = "";
    $(obj).find('option').each(function() {
        fruitval0 += $(this).val()+',';
    });

    var fruit1 = "";
    $(obj).find('option').each(function() {
        fruit1 += $(this).text()+',';
    });

    $('#ssmspropertyvaluearray' + index).val(fruitval0.substring(0,fruitval0.length-1));
    $('#ssmsgoodspropertyarray' + index).val(fruit1.substring(0,fruit1.length-1));
    
}

function salesGoodsFavorableflagForm(obj){
	if (obj.value == '1'){
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgretailPrice]').removeClass('readyonlyInput');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgspecialoffer]').removeClass('readyonlyInput');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgexpensecredit]').removeClass('readyonlyInput');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgdiscountrate]').removeClass('readyonlyInput');
		
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgretailPrice]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgspecialoffer]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgexpensecredit]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgdiscountrate]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }
	if (obj.value == '2'){
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgretailPrice]').removeClass('readyonlyInput');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgspecialoffer]').removeClass('readyonlyInput');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgexpensecredit]').removeClass('readyonlyInput');
		
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgretailPrice]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgspecialoffer]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgexpensecredit]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgdiscountrate]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
    }
	if (obj.value == '3'){
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgspecialoffer]').removeClass('readyonlyInput');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgdiscountrate]').removeClass('readyonlyInput');
		
		//$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgretailPrice]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgspecialoffer]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgexpensecredit]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgdiscountrate]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }
	if (obj.value == '4'){
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgdiscountrate]').removeClass('readyonlyInput');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgexpensecredit]').removeClass('readyonlyInput');
		
		//$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgretailPrice]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgspecialoffer]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgexpensecredit]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgdiscountrate]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }

	$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgretailPrice]').val('');
	$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgspecialoffer]').val('');
	$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgexpensecredit]').val('');
	$(obj).parent().parent().find('input[name=salesGoodsArray.ssmsgdiscountrate]').val('');
	
}

function favorableForm(obj){
    
	if (obj.value == '1'){
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgretailPrice]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgspecialoffer]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgexpensecredit]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgdiscountrate]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }
	if (obj.value == '2'){
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgretailPrice]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgspecialoffer]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgexpensecredit]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgdiscountrate]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
    }
	if (obj.value == '3'){
		//$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgretailPrice]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgspecialoffer]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgexpensecredit]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgdiscountrate]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }
	if (obj.value == '4'){
		//$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgretailPrice]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgspecialoffer]').removeClass('readyonlyInput').removeAttr('readonly').removeAttr('noValidate');
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgexpensecredit]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
		$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgdiscountrate]').addClass('readyonlyInput').attr({'readonly':'readonly','noValidate':'noValidate'});
    }

	$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgretailPrice]').val('');
	$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgspecialoffer]').val('');
	$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgexpensecredit]').val('');
	$(obj).parent().parent().find('input[name=creditGoodsArray.ssmsgdiscountrate]').val('');
}


var index = 0;
 
/**
 * 添加一行购买商品
 */	
function addRow(){
    if ($('#ssmsmclassify').val() == ''){
        alert("请先选择套餐分类!");
        return;
    }
    var table = document.getElementById('addTablebangding');
    if (document.getElementById('addTablesong2') == null){
    	index = accAdd(index,table.rows.length - 1);
    }else{
    	index = accAdd(document.getElementById('addTablesong2').rows.length - 1,accAdd(index,table.rows.length - 1));
    }
    
	var row = table.insertRow(table.rows.length);
	var c1 = row.insertCell(0);
	var c2 = row.insertCell(1);
	var c3 = row.insertCell(2);
	var c4 = row.insertCell(3);
	var c5 = row.insertCell(4);
	var c6 = row.insertCell(5);
	var c7 = row.insertCell(6);
	var c8 = row.insertCell(7);
	var c9 = row.insertCell(8);
	var c10 = row.insertCell(9);
	var c11 = row.insertCell(10);
							
	row.className = 'row';		
	c1.height="26";
	c1.innerHTML = '<input type="checkbox" id="chk1" name="chk1"/>';		

	var data = '<table border=\'0\' width=\'100%\'><tr><td width=\'20%\'>'
		
	var ssmsmclassify = $('#ssmsmclassify').val();
    if (ssmsmclassify == '1'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'
    		             +'<option value="1_0">镜架</option>'
  		                 +'<option value="2_0">配件</option>'
  		                 +'<option value="3">镜片</option>'
  		                 +'<option value="3_0">成品片</option>'
  		                 +'<option value="3_D">订做片</option>'
  		                 +'<option value="6_6">太阳镜</option>'
  		                 +'<option value="6_8">老花镜</option>'  		           
  		                 +'<option value="7_0">耗材</option>'
  		                 +'<option value="9_0">视光</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  	                     + '</select></li></td><td colspan=\'3\'>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材料分类</option>'
                  		 +'<option value="2">折射率</option>'     
  		                 +'<option value="3">光度分类</option>' 	
  		                 +'<option value="4">镜片功能</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">树脂</option>'
                  		 +'<option value="2">玻璃</option>'     
  		                 +'<option value="3">PC</option>' 			            
  	                     +'</select></li>'	      
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                      +'<option value="">----请选择----</option>'
                         +'<s:iterator value="refractiveSetList">'
                         +'<option value="${brfname}">${brfname}</option>'
                         +'</s:iterator>'                      			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="0">单光</option>'
                  		 +'<option value="m">多光</option>'     
  		                 +'<option value="j_1">青少年渐进</option>'
                  		 +'<option value="j_2">成人渐进</option>' 
  		                 +'<option value="k">抗疲劳</option>' 	
  		                 +'<option value="q">其他</option>' 			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">白色片</option>'
                  		 +'<option value="2">变色片</option>'     
  		                 +'<option value="3">偏光片</option>'
  		                 +'<option value="4">变色偏光片</option>' 	
  		                 +'<option value="5">染色片</option>' 	
  		                 +'<option value="6">抗疲劳片</option>'
  		                 +'<option value="7">抗疲劳变色片</option>'
  		                 +'<option value="8">偏光抗疲劳片</option>' 		   			            
  	                     + '</select></li>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材质</option>'	            
  	                     +'</select></li>'	        	     
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	               +'<option value="">----请选择----</option>'
                   +'<s:iterator value="frameMateriallist">'
                   +'<option value="${bfmid}">${bfmname}</option>'
                   +'</s:iterator>'
  	                     +'</select></li>'

                         data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			             +'<option value="">----请选择----</option>'
			             +'<option value="2">偏光</option>'
			             +'<option value="1">遮阳</option>'	            
			             +'</select></li>'	

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID308'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID308'+index+'" name="goodscategoryID308" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkData(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID309'+index+'" name="goodscategoryID309" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                           +'</li>'	  

        	           data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID309'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID310'+index+'" name="goodscategoryID310" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID311'+index+'" name="goodscategoryID311" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                           +'</li>'	         	          	                     
    }

    if (ssmsmclassify == '3'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'       
             			 +'<option value="4">隐形镜片</option>'
                         +'<option value="4_0">隐形成品片</option>'
  		                 +'<option value="4_D">隐形订做片</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  		                 +'<option value="2_0">配件</option>'
   		                 +'<option value="6_6">太阳镜</option>'
  		                 +'<option value="6_8">老花镜</option>'
  		                 +'<option value="1_0">镜架</option>'
  		                 +'<option value="7_0">耗材</option>'
  		                 +'<option value="9_0">视光</option>'
  	                     +'</select></li></td><td colspan=\'3\'>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'       
  		                 +'<option value="">----请选择----</option>'
  		                 +'<option value="1">使用类型</option>'
  		                 +'<option value="2">抛弃型分类</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'
  	                     +'</select></li>'	         
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">常带型</option>'
  		                 +'<option value="2">抛弃型</option>'
  		               +'<option value="3">塑形镜</option>'
  	                     +'</select></li>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">日抛</option>'
  		                 +'<option value="2">周抛</option>'
  		                 +'<option value="9">双周抛</option>'
  		                 +'<option value="3">月抛</option>'
  		                 +'<option value="4">季抛</option>'
  		                 +'<option value="5">半年抛</option>'
  		                 +'<option value="6">年抛</option>'
  		                 +'<option value="7">RGP</option>'      		                 
  	                     +'</select></li>'   

  	               	   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">材质</option>'	            
                         +'</select></li>'	        	     
                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			             +'<option value="">----请选择----</option>'
			             +'<s:iterator value="frameMateriallist">'
			             +'<option value="${bfmid}">${bfmname}</option>'
			             +'</s:iterator>'
                         +'</select></li>'	
                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			             +'<option value="">----请选择----</option>'
			             +'<option value="2">偏光</option>'
			             +'<option value="1">遮阳</option>'	            
			             +'</select></li>'	
		           
      	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID408'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID408'+index+'" name="goodscategoryID408" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID409'+index+'" name="goodscategoryID409" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                       +'</li>'	  

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID409'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID410'+index+'" name="goodscategoryID410"  xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID411'+index+'" name="goodscategoryID411" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                       +'</li>'	               	         
    }
    if (ssmsmclassify == '5'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onchange="change5(this,'+index+')">'
  		                 +'<option value="6_6">太阳镜</option>'
  		                 +'<option value="6_8">老花镜</option>'
  		                 +'<option value="1_0">镜架</option>'
  		                 +'<option value="7_0">耗材</option>'
  		                 +'<option value="9_0">视光</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  		                 +'<option value="2_0">配件</option>'
  		                 +'</select></li></td><td colspan=\'3\'>'	

    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
    		                 +'<option value="">----请选择----</option>'
                           +'<option value="1">材质</option>'	            
    	                     +'</select></li>'	        	     
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
    	             +'<option value="">----请选择----</option>'
                     +'<s:iterator value="frameMateriallist">'
                     +'<option value="${bfmid}">${bfmname}</option>'
                     +'</s:iterator>'
    	                     +'</select></li>'	
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">功能</option>'	            
      	                     +'</select></li>'	        	     
      	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
   			           +'<option value="">----请选择----</option>'
   			           +'<option value="2">偏光</option>'
   			           +'<option value="1">遮阳</option>'	            
   			           +'</select></li>'	                        
    }

    data = data + '<img id="propertyImg'+index+'" src="${ctx }/img/newbtn/audit_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" btn=btn title=\"确认属性\" onclick="addGoodsProperty(this,'+index+');" style="cursor: hand;"/>'
    
    data = data +'<input id="goodsName'+index+'" name="salesGoodsArray.ssmsggoodsname" class="text_input120" type="text" readonly="readonly"><img btn=btn onclick="openGoods('+index+');" src="${ctx }/img/newbtn/audit_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" btn=btn title=\"选择商品\" style="cursor: hand;" />'
                   +'<input id="supplier'+index+'" class="text_input60" name="salesGoodsArray.ssmsgsupplier" type="hidden"><input id="brand'+index+'" class="text_input60" name="salesGoodsArray.ssmsgbrand" type="hidden"><input id="iscustomize'+index+'" name="salesGoodsArray.ssmsgiscustomize" class="text_input60" type="hidden"><input id="goods'+index+'" name="salesGoodsArray.ssmsggoodsid" class="text_input60" type="hidden">'
                   +'<input id="goodscategory2id'+index+'" name="salesGoodsArray.ssmsggoodscategory" class="text_input60" type="hidden"><input id="ssmsgoodsclass'+index+'" name="salesGoodsArray.ssmsgoodsclass" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" name="salesGoodsArray.ssmsgbigclass" class="text_input60" type="hidden"><input id="smallClass'+index+'" name="salesGoodsArray.ssmsgsmallclass" class="text_input60" type="hidden">'

    data = data + '</td></tr><tr hide=hide id="hide'+index+'"><td>&nbsp;</td><td width=\'20%\'>'
                   
                   +'<select multiple="multiple" class="text_input200 gbc" style="height:100px;width:250px" name="goodspropertyarray" id="goodspropertyarray'+index+'" onclick="changePropertyValue(this,'+index+');">'
                   +'<optgroup label="(按住ctrl键,可同时选中多项)"></optgroup></select>'     
                   +'<input type="hidden" id="ssmspropertyvaluearray'+index+'" name="salesGoodsArray.ssmspropertyvaluearray" readonly="readonly"><input type="hidden" id="ssmsgoodspropertyarray'+index+'" name="salesGoodsArray.ssmsgoodspropertyarray" readonly="readonly">'

    data = data + '</td><td width=\'20%\'><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\'删除\' onclick="removeOption(this,'+index+');" style="cursor: hand;" idx="'+index+'"/></td></tr></table>';

    c2.innerHTML = data;
    
    c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'"></span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" type="hidden" name="salesGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'"></span><input id="maxCostPriceAmount'+index+'" class="text_input60 noneInput" type="hidden" readonly="readonly" name="salesGoodsArray.ssmsgmaxcostPrice">';
    c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgbeginAmount'+index+'" type="text" name="salesGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误,请重新填写!\'}]" onblur="validationGoodsCostPriceMin(this,'+index+');" xf6="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgendAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误,请重新填写!\'}]" onblur="validationGoodsCostPriceMax(this,'+index+');" xf7="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'8\',\'\')">';
	c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="goodsquantity'+index+'" type="text" name="salesGoodsArray.ssmsggoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'商品数量填写有误,请重新填写!\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}getSetMealAmount3(this);computeUnitCost('+index+',\'3\');" value="1" xf8="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'9\',\'\')">';

	c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendup'+index+'" type="text" name="salesGoodsArray.ssmsgexpensespendup" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'消费满金额区间填写有误,请重新填写!\'}]" xf9="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'10\',\'\')" onblur="amoumtAddZero(this)">至<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendul'+index+'" type="text" name="salesGoodsArray.ssmsgexpensespendul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'消费满金额区间填写有误,请重新填写！\'}]" xf10="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'11\',\'\')" onblur="amoumtAddZero(this)">';

	data = '<table id="hideHeight'+index+'" border=\'0\' width=\'100%\' height=\'43%\'><tr><td>&nbsp;</td></tr></table><select clean=clean id="ssmsgfavorableflag'+index+'" name="salesGoodsArray.ssmsgfavorableflag" onchange="salesGoodsFavorableflagForm(this);this.blur();">'
			          +'<option value="1">原价</option>'
			          +'<option value="2">打折</option>'
			          +'<option value="3">返现</option>'
			          +'<option value="4">特价</option>'
			          +'</select>';

	c7.innerHTML = 	data;	          
	
	c8.innerHTML = '<input class="text_input60 inInput readyonlyInput" readonly="readonly" noValidate="noValidate" maxlength="10" id="ssmsgretailPrice'+index+'" type="text" name="salesGoodsArray.ssmsgretailPrice" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写套餐单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'套餐单价填写有误,请重新填写!\'}]" onblur="getSetMealAmount(this);amoumtAddZero(this);" xf11="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'12\',\'\')">';

	c9.innerHTML = '<input class="text_input60 inInput readyonlyInput" readonly="readonly" noValidate="noValidate" maxlength="10" id="specialoffer'+index+'" type="text" name="salesGoodsArray.ssmsgspecialoffer" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写特价金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'特价金额填写有误,请重新填写!\'}]" xf12="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'13\',\'\')" onblur="amoumtAddZero(this);computeUnitCost('+index+',\'1\');">';
    
    c10.innerHTML = '<input class="text_input60 inInput readyonlyInput" readonly="readonly" noValidate="noValidate" maxlength="10" id="ssmsgexpensecredit'+index+'" type="text" name="salesGoodsArray.ssmsgexpensecredit" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写优惠金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'优惠金额填写有误,请重新填写!\'}]"  xf13="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'14\',\'\')" onblur="amoumtAddZero(this);computeUnitCost('+index+',\'2\');">';

    c11.innerHTML = '<input class="text_input60 inInput readyonlyInput" readonly="readonly" noValidate="noValidate" maxlength="10" id="ssmsgdiscountrate'+index+'" type="text" name="salesGoodsArray.ssmsgdiscountrate" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写优惠折扣！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UDiscount, \'Message\' : \'优惠折扣填写有误,请重新填写!\'}]" xf14="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'15\',\'0\')">';
    
	if (ssmsmclassify == '5'){
		 $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).show();
         $('#goodscategoryID313'+index).hide();
         
         $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).show();
         $('#ligoodscategoryID311'+index).hide();
	}
	if (ssmsmclassify == '3'){
	     $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
	     $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
	     $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();        
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();
         
	     $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
	     $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();
	}
	if (ssmsmclassify == '1'){
	     $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();

	     $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();
	}

	$('#propertyImg'+index).hide();
    $('tr[id=hide'+index+']').hide();
    $('table[id="hideHeight'+index+'"]').hide();
}

/**
 * 添加优惠商品
 */
function addRow2(){
    if ($('#ssmsmclassify').val() == ''){
        alert("请先选择套餐分类!");
        return;
    }
    var table = document.getElementById('addTablesong2');
    index = accAdd(document.getElementById('addTablebangding').rows.length - 1,accAdd(index,table.rows.length - 1));
	var row = table.insertRow(table.rows.length);
	var c1 = row.insertCell(0);
	var c2 = row.insertCell(1);
	var c3 = row.insertCell(2);
	var c4 = row.insertCell(3);
	var c5 = row.insertCell(4);
	//var c6 = row.insertCell(5);
	var c7 = row.insertCell(5);
	var c8 = row.insertCell(6);
	var c9 = row.insertCell(7);
	var c10 = row.insertCell(8);
	var c11 = row.insertCell(9);
							
	row.className = 'row';		
	c1.height="26";
	c1.innerHTML = '<input type="checkbox" id="chk2" name="chk2"/>';		

	var data = '<table border=\'0\' width=\'100%\'><tr><td width=\'20%\'>'
		
	var ssmsmclassify = $('#ssmsmclassify').val();
    if (ssmsmclassify == '1'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" dk0="dk'+index+'" youhui=youhui onKeyPress="dkEnterDown('+index+',\'1\',\'6\')">'
    		             +'<option value="1_0">镜架</option>'
    		             +'<option value="2_0">配件</option>'
  		                 +'<option value="3">镜片</option>'
  		                 +'<option value="3_0">成品片</option>'
  		                 +'<option value="3_D">订做片</option>'
  		                 +'<option value="6_6">太阳镜</option>'
  		                 +'<option value="6_8">老花镜</option>'  		           
  		                 +'<option value="7_0">耗材</option>'
  		                 +'<option value="9_0">视光</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  	                     + '</select></li></td><td colspan=\'3\'>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材料分类</option>'
                  		 +'<option value="2">折射率</option>'     
  		                 +'<option value="3">光度分类</option>' 	
  		                 +'<option value="4">镜片功能</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">树脂</option>'
                  		 +'<option value="2">玻璃</option>'     
  		                 +'<option value="3">PC</option>' 			            
  	                     +'</select></li>'	      
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	                      +'<option value="">----请选择----</option>'
                         +'<s:iterator value="refractiveSetList">'
                         +'<option value="${brfname}">${brfname}</option>'
                         +'</s:iterator>'                      			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="0">单光</option>'
                  		 +'<option value="m">多光</option>'     
  		                 +'<option value="j_1">青少年渐进</option>'
                  		 +'<option value="j_2">成人渐进</option>' 
  		                 +'<option value="k">抗疲劳</option>' 	
  		                 +'<option value="q">其他</option>' 			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">白色片</option>'
                  		 +'<option value="2">变色片</option>'     
  		                 +'<option value="3">偏光片</option>'
  		                 +'<option value="4">变色偏光片</option>' 	
  		                 +'<option value="5">染色片</option>' 	
  		                 +'<option value="6">抗疲劳片</option>'
  		                 +'<option value="7">抗疲劳变色片</option>' 
  		                 +'<option value="8">偏光抗疲劳片</option>' 		  			            
  	                     + '</select></li>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材质</option>'	            
  	                     +'</select></li>'	        	     
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
  	               +'<option value="">----请选择----</option>'
                   +'<s:iterator value="frameMateriallist">'
                   +'<option value="${bfmid}">${bfmname}</option>'
                   +'</s:iterator>'
  	                     +'</select></li>'

                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			             +'<option value="">----请选择----</option>'
			             +'<option value="2">偏光</option>'
			             +'<option value="1">遮阳</option>'	            
			             +'</select></li>'	
			             
    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID308'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID308'+index+'" name="goodscategoryID308" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'14\',\'\')" onblur="checkData(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID309'+index+'" name="goodscategoryID309" dk14="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                           +'</li>'	  

        	           data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID309'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID310'+index+'" name="goodscategoryID310"  dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'14\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID311'+index+'" name="goodscategoryID311" dk14="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                           +'</li>'	         	          	                     
    }

    if (ssmsmclassify == '3'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" youhui=youhui dk0="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'1\',\'6\')">'       
             			 +'<option value="4">隐形镜片</option>'
                         +'<option value="4_0">隐形成品片</option>'
  		                 +'<option value="4_D">隐形订做片</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  		                 +'<option value="2_0">配件</option>'
   		                 +'<option value="6_6">太阳镜</option>'
   		                 +'<option value="6_8">老花镜</option>'
   		                 +'<option value="1_0">镜架</option>'
   		                 +'<option value="7_0">耗材</option>'
   		                 +'<option value="9_0">视光</option>'
  	                     +'</select></li></td><td colspan=\'3\'>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'       
  		                 +'<option value="">----请选择----</option>'
  		                 +'<option value="1">使用类型</option>'
  		                 +'<option value="2">抛弃型分类</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'
  	                     +'</select></li>'	         
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">常带型</option>'
  		                 +'<option value="2">抛弃型</option>'
  		               +'<option value="3">塑形镜</option>'
  	                     +'</select></li>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">日抛</option>'
  		                 +'<option value="2">周抛</option>'
  		                 +'<option value="9">双周抛</option>'
  		                 +'<option value="3">月抛</option>'
  		                 +'<option value="4">季抛</option>'
  		                 +'<option value="5">半年抛</option>'
  		                 +'<option value="6">年抛</option>'
  		                 +'<option value="7">RGP</option>'      		                 
  	                     +'</select></li>'   

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  	                     +'<option value="">----请选择----</option>'
                           +'<option value="1">材质</option>'	            
                           +'</select></li>'	        	     
                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  			             +'<option value="">----请选择----</option>'
  			             +'<s:iterator value="frameMateriallist">'
  			             +'<option value="${bfmid}">${bfmname}</option>'
  			             +'</s:iterator>'
                           +'</select></li>'	
                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                           +'<option value="1">功能</option>'	            
  	                     +'</select></li>'	        	     
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  			             +'<option value="">----请选择----</option>'
  			             +'<option value="2">偏光</option>'
  			             +'<option value="1">遮阳</option>'	            
  			             +'</select></li>'	
  			             
      	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID408'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID408'+index+'" name="goodscategoryID408" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'14\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID409'+index+'" name="goodscategoryID409" dk14="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                       +'</li>'	  

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID409'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID410'+index+'" name="goodscategoryID410"  dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'14\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID411'+index+'" name="goodscategoryID411" dk14="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                       +'</li>'	               	         
    }
    if (ssmsmclassify == '5'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" dk0="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')" onchange="change5(this,'+index+')" youhui=youhui>'
  		                 +'<option value="6_6">太阳镜</option>'
  		                 +'<option value="6_8">老花镜</option>'
  		                 +'<option value="1_0">镜架</option>'
  		                 +'<option value="7_0">耗材</option>'
  		                 +'<option value="9_0">视光</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  		                 +'<option value="2_0">配件</option>'
  		                 +'</select></li></td><td colspan=\'3\'>'	

    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
    		                 +'<option value="">----请选择----</option>'
                           +'<option value="1">材质</option>'	            
    	                     +'</select></li>'	        	     
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
    	             +'<option value="">----请选择----</option>'
                     +'<s:iterator value="frameMateriallist">'
                     +'<option value="${bfmid}">${bfmname}</option>'
                     +'</s:iterator>'
    	             +'</select></li>'	

    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
   		                 +'<option value="">----请选择----</option>'
                          +'<option value="1">功能</option>'	            
   	                     +'</select></li>'	        	     
   	    data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
			           +'<option value="">----请选择----</option>'
			           +'<option value="2">偏光</option>'
			           +'<option value="1">遮阳</option>'	            
			           +'</select></li>'	                         
    }

    data = data + '<img id="propertyImg'+index+'" src="${ctx }/img/newbtn/audit_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" btn=btn title=\"选择\" onclick="addGoodsProperty(this,'+index+');" style="cursor: hand;"/>'
    
    data = data +'<input id="goodsName'+index+'" name="creditGoodsArray.ssmsggoodsname" class="text_input120" type="text" readonly="readonly"><img src="${ctx }/img/newbtn/audit_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" style="cursor: hand;">'
                   +'<input id="supplier'+index+'" class="text_input60" name="creditGoodsArray.ssmsgsupplier" type="hidden"><input id="brand'+index+'" class="text_input60" name="creditGoodsArray.ssmsgbrand" type="hidden"><input id="iscustomize'+index+'" name="creditGoodsArray.ssmsgiscustomize" class="text_input60" type="hidden"><input id="goods'+index+'" name="creditGoodsArray.ssmsggoodsid" class="text_input60" type="hidden">'
                   +'<input id="goodscategory2id'+index+'" name="creditGoodsArray.ssmsggoodscategory" class="text_input60" type="hidden"><input id="ssmsgoodsclass'+index+'" name="creditGoodsArray.ssmsgoodsclass" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" name="creditGoodsArray.ssmsgbigclass" class="text_input60" type="hidden"><input id="smallClass'+index+'" name="creditGoodsArray.ssmsgsmallclass" class="text_input60" type="hidden">'

    data = data + '</td></tr><tr hide=hide id="hide'+index+'"><td>&nbsp;</td><td width=\'20%\'>'
                   
                   +'<select multiple="multiple" class="text_input200 gbc" style="height:100px;width:250px" name="goodspropertyarray" id="goodspropertyarray'+index+'" onclick="changePropertyValue(this,'+index+');">'
                   +'<optgroup label="(按住ctrl键,可同时选中多项)"></optgroup></select>'     
                   +'<input type="hidden" id="ssmspropertyvaluearray'+index+'" name="creditGoodsArray.ssmspropertyvaluearray" readonly="readonly"><input type="hidden" id="ssmsgoodspropertyarray'+index+'" name="creditGoodsArray.ssmsgoodspropertyarray" readonly="readonly">'

    data = data + '</td><td width=\'20%\'><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\'删除\' onclick="removeOption(this,'+index+');" style="cursor: hand;"/></td></tr></table>';

    c2.innerHTML = data;
    
    c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'"></span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" type="hidden" name="creditGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'"></span><input id="maxCostPriceAmount'+index+'" class="text_input60 noneInput" type="hidden" readonly="readonly" name="creditGoodsArray.ssmsgmaxcostPrice">';
    c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgbeginAmount'+index+'" type="text" name="creditGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误,请重新填写!\'}]" onblur="validationGoodsCostPriceMin(this,'+index+');" dk6="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" class="text_input60" style="width:50" type="text" name="creditGoodsArray.ssmsgendAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误,请重新填写!\'}]" onblur="validationGoodsCostPriceMax(this,'+index+');" dk7="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'8\',\'\')">';
	c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="goodsquantity'+index+'" type="text" name="creditGoodsArray.ssmsggoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'商品数量填写有误,请重新填写!\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}getSetMealAmount3(this);computeUnitCost('+index+',\'3\');" value="1" dk8="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'9\',\'\')">';

	//c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendup'+index+'" type="text" name="creditGoodsArray.ssmsgexpensespendup" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'\';}" xf10="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'11\',\'12\')">至<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendul'+index+'" type="text" name="creditGoodsArray.ssmsgexpensespendul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'\';}" xf10="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'11\',\'12\')">';

    c7.innerHTML = '<table id="hideHeight'+index+'" border=\'0\' width=\'100%\' height=\'43%\'><tr><td>&nbsp;</td></tr></table><select clean=clean id="ssmsgfavorableflag'+index+'" name="creditGoodsArray.ssmsgfavorableflag" onchange="favorableForm(this);this.blur();" >'
			          +'<option value="1">原价</option>'
			          +'<option value="2">打折</option>'
			          +'<option value="3">返现</option>'
			          +'<option value="4">特价</option>'
			          +'</select>';
	
	c8.innerHTML = '<input class="text_input60 inInput readyonlyInput" readonly="readonly" noValidate="noValidate" maxlength="10" id="ssmsgretailPrice'+index+'" type="text" name="creditGoodsArray.ssmsgretailPrice" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写套餐单价!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'套餐单价填写有误,请重新填写!\'}]" onblur="getSetMealAmount(this);" onblur="amoumtAddZero(this);" dk9="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'10\',\'\')">';
	c9.innerHTML = '<input class="text_input60 inInput readyonlyInput" readonly="readonly" noValidate="noValidate" maxlength="10" id="specialoffer'+index+'" type="text" name="creditGoodsArray.ssmsgspecialoffer" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写特价金额!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'特价金额填写有误,请重新填写!\'}]" dk10="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'11\',\'12\')" onblur="amoumtAddZero(this);computeUnitCost('+index+',\'1\');">';
    
    c10.innerHTML = '<input class="text_input60 inInput readyonlyInput" readonly="readonly" noValidate="noValidate" maxlength="10" id="ssmsgexpensecredit'+index+'" type="text" name="creditGoodsArray.ssmsgexpensecredit" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写优惠金额!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'优惠金额填写有误,请重新填写!\'}]"  dk11="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'12\',\'\')" onblur="amoumtAddZero(this);computeUnitCost('+index+',\'2\');">';

    c11.innerHTML = '<input class="text_input60 inInput readyonlyInput" readonly="readonly" noValidate="noValidate" maxlength="10" id="ssmsgdiscountrate'+index+'" type="text" name="creditGoodsArray.ssmsgdiscountrate" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写优惠折扣!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UDiscount, \'Message\' : \'优惠折扣填写有误,请重新填写!\'}]" dk12="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'13\',\'0\')">';
    
	if (ssmsmclassify == '5'){
		 $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).show();
         $('#goodscategoryID313'+index).hide();
         
         $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).show();
         $('#ligoodscategoryID311'+index).hide();
	}
	if (ssmsmclassify == '3'){
	     $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
	     $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
	     $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();        
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();
         
	     $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
	     $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();
	}
	if (ssmsmclassify == '1'){
	     $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();

	     $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();
	}

	$('#propertyImg'+index).hide();
	$('tr[id=hide'+index+']').hide();
	$('table[id="hideHeight'+index+'"]').hide();
 }

/**
 * 整单特价添加商品
 */	
function addRow3(){
    if ($('#ssmsmclassify').val() == ''){
        alert("请先选择套餐分类!");
        return;
    }
    var table = document.getElementById('addTablebangding');
    if (document.getElementById('addTablesong2') == null){
    	index = accAdd(index,table.rows.length - 1);
    }else{
    	index = accAdd(document.getElementById('addTablesong2').rows.length - 1,accAdd(index,table.rows.length - 1));
    }
    
	var row = table.insertRow(table.rows.length);
	var c1 = row.insertCell(0);
	var c2 = row.insertCell(1);
	var c3 = row.insertCell(2);
	var c4 = row.insertCell(3);
	var c5 = row.insertCell(4);
	var c6 = row.insertCell(5);
							
	row.className = 'row';		
	c1.height="26";
	c1.innerHTML = '<input type="checkbox" id="chk1" name="chk1"/>';		

	var data = '<table border=\'0\' width=\'100%\'><tr><td width=\'20%\'>'
		
	var ssmsmclassify = $('#ssmsmclassify').val();
    if (ssmsmclassify == '1'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'
    		             +'<option value="1_0">镜架</option>'
    		             +'<option value="2_0">配件</option>'
  		                 +'<option value="3">镜片</option>'
  		                 +'<option value="3_0">成品片</option>'
  		                 +'<option value="3_D">订做片</option>'
  		                 +'<option value="6_6">太阳镜</option>'
  		                 +'<option value="6_8">老花镜</option>'  		           
  		                 +'<option value="7_0">耗材</option>'
  		                 +'<option value="9_0">视光</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  	                     + '</select></li></td><td colspan=\'3\'>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材料分类</option>'
                  		 +'<option value="2">折射率</option>'     
  		                 +'<option value="3">光度分类</option>' 	
  		                 +'<option value="4">镜片功能</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">树脂</option>'
                  		 +'<option value="2">玻璃</option>'     
  		                 +'<option value="3">PC</option>' 			            
  	                     +'</select></li>'	      
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                      +'<option value="">----请选择----</option>'
                         +'<s:iterator value="refractiveSetList">'
                         +'<option value="${brfname}">${brfname}</option>'
                         +'</s:iterator>'                      			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="0">单光</option>'
                  		 +'<option value="m">多光</option>'     
  		                 +'<option value="j_1">青少年渐进</option>'
                  		 +'<option value="j_2">成人渐进</option>' 
  		                 +'<option value="k">抗疲劳</option>' 	
  		                 +'<option value="q">其他</option>' 			            
  	                     +'</select></li>'	   
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	                     +'<option value="">----请选择----</option>'
                         +'<option value="1">白色片</option>'
                  		 +'<option value="2">变色片</option>'     
  		                 +'<option value="3">偏光片</option>'
  		                 +'<option value="4">变色偏光片</option>' 	
  		                 +'<option value="5">染色片</option>' 	
  		                 +'<option value="6">抗疲劳片</option>' 
  		                 +'<option value="7">抗疲劳变色片</option>'
  		                 +'<option value="8">偏光抗疲劳片</option>' 		  			            
  	                     + '</select></li>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">材质</option>'	            
  	                     +'</select></li>'	        	     
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  	               +'<option value="">----请选择----</option>'
                   +'<s:iterator value="frameMateriallist">'
                   +'<option value="${bfmid}">${bfmname}</option>'
                   +'</s:iterator>'
  	                     +'</select></li>'

                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
		                 +'<option value="">----请选择----</option>'
                         +'<option value="1">功能</option>'	            
	                     +'</select></li>'	        	     
	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
			             +'<option value="">----请选择----</option>'
			             +'<option value="2">偏光</option>'
			             +'<option value="1">遮阳</option>'	            
			             +'</select></li>'	
			               	                     
    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID308'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID308'+index+'" name="goodscategoryID308" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkData(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID309'+index+'" name="goodscategoryID309" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                           +'</li>'	  

        	           data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID309'+index+'"><input class="text_input60" style="width:50" maxlength="20" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID310'+index+'" name="goodscategoryID310" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID311'+index+'" name="goodscategoryID311" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                           +'</li>'	         	          	                     
    }

    if (ssmsmclassify == '3'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'       
             			 +'<option value="4">隐形镜片</option>'
                         +'<option value="4_0">隐形成品片</option>'
  		                 +'<option value="4_D">隐形订做片</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  		                 +'<option value="2_0">配件</option>'
   		                 +'<option value="6_6">太阳镜</option>'
   		                 +'<option value="6_8">老花镜</option>'
   		                 +'<option value="1_0">镜架</option>'
   		                 +'<option value="7_0">耗材</option>'
   		                 +'<option value="9_0">视光</option>'		                  
  	                     +'</select></li></td><td colspan=\'3\'>'
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'       
  		                 +'<option value="">----请选择----</option>'
  		                 +'<option value="1">使用类型</option>'
  		                 +'<option value="2">抛弃型分类</option>'
  		                 +'<option value="5">球镜区间</option>'
  		                 +'<option value="6">柱镜区间</option>'
  	                     +'</select></li>'	         
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">常带型</option>'
  		                 +'<option value="2">抛弃型</option>'
  		               +'<option value="3">塑形镜</option>'
  	                     +'</select></li>'	
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
  	                     +'<option value="">----请选择----</option>'
		                 +'<option value="1">日抛</option>'
  		                 +'<option value="2">周抛</option>'
  		                 +'<option value="9">双周抛</option>'
  		                 +'<option value="3">月抛</option>'
  		                 +'<option value="4">季抛</option>'
  		                 +'<option value="5">半年抛</option>'
  		                 +'<option value="6">年抛</option>'
  		                 +'<option value="7">RGP</option>'      		                 
  	                     +'</select></li>'   

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  	                     +'<option value="">----请选择----</option>'
                           +'<option value="1">材质</option>'	            
                           +'</select></li>'	        	     
                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  			             +'<option value="">----请选择----</option>'
  			             +'<s:iterator value="frameMateriallist">'
  			             +'<option value="${bfmid}">${bfmname}</option>'
  			             +'</s:iterator>'
                           +'</select></li>'	
                       data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
  		                 +'<option value="">----请选择----</option>'
                           +'<option value="1">功能</option>'	            
  	                     +'</select></li>'	        	     
  	                   data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
  			             +'<option value="">----请选择----</option>'
  			             +'<option value="2">偏光</option>'
  			             +'<option value="1">遮阳</option>'	            
  			             +'</select></li>'	
  			             
      	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID408'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID408'+index+'" name="goodscategoryID408" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" onblur="checkData(this)" clean=clean id="goodscategoryID409'+index+'" name="goodscategoryID409" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                       +'</li>'	  

    	               data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID409'+index+'"><input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID410'+index+'" name="goodscategoryID410"  xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'61\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'光度填写有误,请重新填写！\'}]" clean=clean id="goodscategoryID411'+index+'" name="goodscategoryID411" xf61="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onblur="checkDataz(this)">'
                       +'</li>'	               	         
    }
    if (ssmsmclassify == '5'){
    	data = data + '<li class="horizontal_onlyRight"><select style="width:100%" clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')" onchange="change5(this,'+index+')">'
  		                 +'<option value="6_6">太阳镜</option>'
  		                 +'<option value="6_8">老花镜</option>'
  		                 +'<option value="1_0">镜架</option>'
  		                 +'<option value="7_0">耗材</option>'
  		                 +'<option value="9_0">视光</option>'
  		                 +'<option value="5_0">隐形护理液</option>'
  		                 +'<option value="2_0">配件</option>'
  		                 +'</select></li></td><td colspan=\'3\'>'	

    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
    		                 +'<option value="">----请选择----</option>'
                           +'<option value="1">材质</option>'	            
    	                     +'</select></li>'	        	     
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
    	             +'<option value="">----请选择----</option>'
                     +'<s:iterator value="frameMateriallist">'
                     +'<option value="${bfmid}">${bfmname}</option>'
                     +'</s:iterator>'
    	                     +'</select></li>'	
    	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID310'+index+'"><select clean=clean id="goodscategoryID312'+index+'" name="goodscategoryID312" onchange="change51(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">功能</option>'	            
      	                     +'</select></li>'	        	     
      	data = data + '<li class="horizontal_onlyRight" id="ligoodscategoryID311'+index+'"><select clean=clean id="goodscategoryID313'+index+'" name="goodscategoryID313" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
   			           +'<option value="">----请选择----</option>'
   			           +'<option value="2">偏光</option>'
   			           +'<option value="1">遮阳</option>'	            
   			           +'</select></li>'	                        
    }

    data = data + '<img id="propertyImg'+index+'" src="${ctx }/img/newbtn/audit_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" btn=btn title=\"选择\" onclick="addGoodsProperty(this,'+index+');" style="cursor: hand;"/>'
    
    data = data +'<input id="goodsName'+index+'" name="salesGoodsArray.ssmsggoodsname" class="text_input120" type="text" readonly="readonly"><img src="${ctx }/img/newbtn/audit_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/audit_0.png\');" style="cursor: hand;">'
                   +'<input id="supplier'+index+'" class="text_input60" name="salesGoodsArray.ssmsgsupplier" type="hidden"><input id="brand'+index+'" class="text_input60" name="salesGoodsArray.ssmsgbrand" type="hidden"><input id="iscustomize'+index+'" name="salesGoodsArray.ssmsgiscustomize" class="text_input60" type="hidden"><input id="goods'+index+'" name="salesGoodsArray.ssmsggoodsid" class="text_input60" type="hidden">'
                   +'<input id="goodscategory2id'+index+'" name="salesGoodsArray.ssmsggoodscategory" class="text_input60" type="hidden"><input id="ssmsgoodsclass'+index+'" name="salesGoodsArray.ssmsgoodsclass" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" name="salesGoodsArray.ssmsgbigclass" class="text_input60" type="hidden"><input id="smallClass'+index+'" name="salesGoodsArray.ssmsgsmallclass" class="text_input60" type="hidden">'

    data = data + '</td></tr><tr hide=hide id="hide'+index+'"><td>&nbsp;</td><td width=\'20%\'>'
                   
                   +'<select multiple="multiple" class="text_input200 gbc" style="height:100px;width:250px" name="goodspropertyarray" id="goodspropertyarray'+index+'" onclick="changePropertyValue(this,'+index+');">'
                   +'<optgroup label="(按住ctrl键,可同时选中多项)"></optgroup></select>'     
                   +'<input type="hidden" id="ssmspropertyvaluearray'+index+'" name="salesGoodsArray.ssmspropertyvaluearray" readonly="readonly"><input type="hidden" id="ssmsgoodspropertyarray'+index+'" name="salesGoodsArray.ssmsgoodspropertyarray" readonly="readonly">'

    data = data + '</td><td width=\'20%\'><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\'删除\' onclick="removeOption(this,'+index+');" style="cursor: hand;" idx="'+index+'"/></td></tr></table>';

    c2.innerHTML = data;
    
    c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'"></span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" type="hidden" name="salesGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'"></span><input id="maxCostPriceAmount'+index+'" class="text_input60 noneInput" type="hidden" readonly="readonly" name="salesGoodsArray.ssmsgmaxcostPrice">';
    c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgbeginAmount'+index+'" type="text" name="salesGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误,请重新填写!\'}]" onblur="validationGoodsCostPriceMin(this,'+index+');" xf6="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgendAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'套餐价格区间填写有误,请重新填写!\'}]" onblur="validationGoodsCostPriceMax(this,'+index+');" xf7="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'8\',\'\')">';
	c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="goodsquantity'+index+'" type="text" name="salesGoodsArray.ssmsggoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'商品数量填写有误,请重新填写!\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}getSetMealAmount3(this);" value="1" xf8="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'9\',\'\')">';

	c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendup'+index+'" type="text" name="salesGoodsArray.ssmsgexpensespendup" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'消费满金额区间填写有误,请重新填写!\'}]" xf9="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'10\',\'\')" onblur="amoumtAddZero(this)">至<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensespendul'+index+'" type="text" name="salesGoodsArray.ssmsgexpensespendul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.UFloatORNULL, \'Message\' : \'消费满金额区间填写有误,请重新填写!\'}]" xf10="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'11\',\'\')" onblur="amoumtAddZero(this)">';
	
	if (ssmsmclassify == '5'){
		 $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).show();
         $('#goodscategoryID313'+index).hide();
         
         $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).show();
         $('#ligoodscategoryID311'+index).hide();
	}
	if (ssmsmclassify == '3'){
	     $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
	     $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
	     $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();        
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();
         
	     $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
	     $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();
	}
	if (ssmsmclassify == '1'){
	     $('#goodscategoryID301'+index).hide();
	     $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();

	     $('#ligoodscategoryID301'+index).hide();
	     $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();
	}

	$('#propertyImg'+index).hide();
    $('tr[id=hide'+index+']').hide();
 }

 /**
  *  删除添加一行购买商品
  */        
 function del(){
    var chk = document.getElementsByName("chk1");
	var table = document.getElementById('addTablebangding');
	for(i = 0; i < chk.length; i++){
		 if (chk[i].checked) {
			 var curRow = chk[i].parentNode.parentNode;		
			 table.deleteRow(curRow.rowIndex);
			 i = -1;
		 }
	}
	document.all.chks1.checked = false;
	amoumt();
 } 

 /**
  *  删除添加一行优惠商品
  */  
 function del2(){
	    var chk = document.getElementsByName("chk2");
		var table = document.getElementById('addTablesong2');
		for(i = 0; i < chk.length; i++){
			 if (chk[i].checked) {
				 var curRow = chk[i].parentNode.parentNode;		
				 table.deleteRow(curRow.rowIndex);
				 i = -1;
			 }
		}
		document.all.chks2.checked = false;
		amoumt();
 } 

/*
 * 金额保留两位小数
 */
function amoumtAddZero(obj){
    obj.value = $.trim(obj.value);
    if (!isNaN(obj.value) && obj.value != ''){
   	    obj.value = parseFloat(obj.value).toFixed(2);
    }else{
   	    obj.value = '';
    }
}

/*
 *  确认商品接个区间的下限值范围
 */
function validationGoodsCostPriceMin(obj,index){
	 obj.value = $.trim(obj.value);
     if (!isNaN(obj.value) && obj.value != ''){
    	 obj.value = parseFloat(obj.value).toFixed(2);
     }else{
    	 obj.value = '';
     }
     amoumt();
 }
 
/*
 *  确认商品接个区间的上限值范围
 */
 function validationGoodsCostPriceMax(obj,index){
	 obj.value = $.trim(obj.value);
     if (!isNaN(obj.value) && obj.value != ''){
    	 obj.value = parseFloat(obj.value).toFixed(2);
     }else{
    	 obj.value = '';
     }
     amoumt();
 }

//球镜、柱镜
var re1 = /^[\+\-]?[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;

//验证球镜
function checkData(obj) {
	if (obj.value == null || obj.value == '') {
		return;
	}
	if(parseFloat(obj.value)%0.25!=0){
		alert("球镜、柱镜应为 0.25的倍数！");
		obj.select();
		return;
	}
	if (!(re1.test(obj.value))) {
		alert("请输入正确格式！");
		obj.select();
	}else {
		obj.value = obj.value.replace("+", "");
		addZero(obj);
		if(obj.value > 0){
			obj.value = '+' + obj.value;
		}
	}
}
//验证柱径
function checkDataz(obj) {
	if (obj.value == null || obj.value == '') {
		return;
	}
	
	if(parseFloat(obj.value)%0.25!=0){
		alert("球镜、柱镜应为 0.25的倍数！");
		obj.select();
		return;
	}
	
	if (!(re1.test(obj.value))) {
		alert("请输入正确格式！");
		obj.select();
	} else {
		obj.value = obj.value.replace("+", "");
		addZero(obj);
		if(obj.value > 0){
			obj.value = '-' + obj.value;
		}
	}
}

//光度补零
function addZero(obj) {
	if (obj.value.indexOf(".") == -1) {
		obj.value += ".00";
	} else if (obj.value.indexOf(".") == obj.value.length - 2) {
		obj.value += "0";
	}
}


/**
 * 商品开窗
 */ 
function openGoods(value){
    document.getElementById("indexs").value = value;
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initSetMealGoodsOpenSel.action?goodscategoryID="+$('#goodscategoryID'+value).val()+ "&pertyvaluearray=" + getUrl(value),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initSetMealGoodsOpenSel.action?goodscategoryID="+$('#goodscategoryID'+value).val()+ "&pertyvaluearray=" + getUrl(value),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【商品查询】";
}

function getUrl(index){

	for(var i = 0; i < $('#goodspropertyarray'+index).find("option").length; i++){
		$('#goodspropertyarray'+index).find("option")[i].click();
	}
	
    return $('#ssmspropertyvaluearray'+index).val();
}
 
/**
 * 商品开窗赋值
 */ 
 function openGoodsValue(json){
     var indexs= document.getElementById("indexs").value;
     document.getElementById("goodsName"+indexs).value=json.goodsName;
     document.getElementById("supplier"+indexs).value=json.supplier;
     document.getElementById("brand"+indexs).value=json.brand;
     document.getElementById("iscustomize"+indexs).value=json.iscustomize;
     document.getElementById("goods"+indexs).value=json.goods;
     document.getElementById("minCostPrice"+indexs).value=json.minCostPrice;
     document.getElementById("maxCostPrice"+indexs).value=json.maxCostPrice;
     document.getElementById("bigClass"+indexs).value=json.bigClass;
     document.getElementById("smallClass"+indexs).value=json.smallClass;
     document.getElementById("goodscategory2id"+indexs).value=json.goodscategoryid;
     document.getElementById("minCostPriceAmount"+indexs).value=json.minCostPriceAmount;
     document.getElementById("maxCostPriceAmount"+indexs).value=json.maxCostPriceAmount;
     document.getElementById("goodsquantity"+indexs).value=json.goodsquantity;              
     //document.getElementById("ssmsgbeginAmount"+indexs).value=json.minCostPrice;
     //document.getElementById("ssmsgendAmount"+indexs).value=json.maxCostPrice;
     document.getElementById("ssmsgoodsclass"+indexs).value=json.goodsclass;
     document.getElementById("spanminCostPriceAmount"+indexs).innerHTML=json.minCostPriceAmount;
     document.getElementById("spanmaxCostPriceAmount"+indexs).innerHTML=json.maxCostPriceAmount;        

     amoumt();
 }
 
 function changeClassif2(){
    $('input[name=chk1]').each(function(){
		$(this).parent().parent().remove();		
	});
	$('input[name=chk2]').each(function(){
		$(this).parent().parent().remove();		
	});
	document.all.chks1.checked = false;
	$('#chks2').attr('checked',false);
    amoumt();
 }
 
 function checkCostPrice(obj,index){
 	 if ($('#ssmsmform').val() == '3'){
         return;
     }
     var max = $('#ssmsgendAmount'+index).val();
     if (Number(obj.value) > Number(max)){
         obj.value = max;
     }
 }
 
 function computeAmount(){
     var adjustmentPrice = $('#adjustmentPrice').val();
     if (adjustmentPrice == '' || adjustmentPrice == '0.00'){
         computeSpecialOffer();
         return;
     }
     var total=0;
     $('input[name=salesGoodsArray.ssmsgmaxcostPrice]').each(function(){
         total=accAdd(total,$(this).val());
     });

     var count = $('input[name=salesGoodsArray.ssmsgmaxcostPrice]').size();
     var total2=0;
     for (var i = 0; i < count-1; i++){
         if (total == 0 || isNaN($('input[name=salesGoodsArray.ssmsgmaxcostPrice]').get(i).value)){
             $('input[name=salesGoodsArray.ssmsgspecialoffer]').get(i).value = parseFloat(0.00).toFixed(2);
         }else{
             $('input[name=salesGoodsArray.ssmsgspecialoffer]').get(i).value = parseFloat(accMul(accDiv($('input[name=salesGoodsArray.ssmsgmaxcostPrice]').get(i).value,total),adjustmentPrice)).toFixed(2);
         }
         total2=accAdd(total2,$('input[name=salesGoodsArray.ssmsgspecialoffer]').get(i).value);
     }
     if (count > 0){
    	 $('input[name=salesGoodsArray.ssmsgspecialoffer]').get(count-1).value = parseFloat(accSub(adjustmentPrice,total2)).toFixed(2);
     }         
     
     if ($('#adjustmentPrice') != null){
         $('#ssmsmendbgnAmount').val($('#adjustmentPrice').val());
     }
 }
 
 function computeSpecialOffer(){
     var total=0;
     $('input[name=salesGoodsArray.ssmsgspecialoffer]').each(function(){
         total=accAdd(total,$(this).val());
     });
     $('#adjustmentPrice').val(parseFloat(total).toFixed(2));
     $('#ssmsmendbgnAmount').val($('#adjustmentPrice').val());
 }
 
 function change3(obj,index){

	 change3_son2(obj,index);
	 change3_son(obj,index);
	 
     $(obj).parent().parent().parent().parent().find('tr[hide=hide]').find('select').find('option').remove();
     $(obj).parent().parent().parent().parent().find('tr[hide=hide]').hide();
     $('#ssmspropertyvaluearray' + index).val('');
     $('#ssmsgoodspropertyarray' + index).val('');
     
     clearGoods(index);
 }

 function change3_son(obj,index){
     if (obj.value == '2_0'){
         $('#goodscategoryID301'+index).val('');
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');
         $('#goodscategoryID312'+index).val('');
         $('#goodscategoryID313'+index).val('');
         
         $('#goodscategoryID301'+index).hide();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();

         $('#ligoodscategoryID301'+index).hide();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();

         $('#propertyImg'+index).hide();
         
     }
     if (obj.value == '3' || obj.value == '3_0' || obj.value == '3_D'){
         $('#goodscategoryID301'+index).val('');
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');
         $('#goodscategoryID312'+index).val('');
         $('#goodscategoryID313'+index).val('');
         
         $('#goodscategoryID301'+index).show();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();
         
         $('#ligoodscategoryID301'+index).show();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();

         $('#propertyImg'+index).hide();
     }
     if (obj.value == '1_0'){
         $('#goodscategoryID301'+index).val('');
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');
         $('#goodscategoryID312'+index).val('');
         $('#goodscategoryID313'+index).val('');
         
         $('#goodscategoryID301'+index).hide();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID306'+index).show();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID313'+index).hide();

         $('#ligoodscategoryID301'+index).hide();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID306'+index).show();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).hide();
         $('#ligoodscategoryID311'+index).hide();

         $('#propertyImg'+index).hide();
     }

     if (obj.value == '6_6'){
         $('#goodscategoryID301'+index).val('');
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');
         $('#goodscategoryID312'+index).val('');
         $('#goodscategoryID313'+index).val('');
         
         $('#goodscategoryID301'+index).hide();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();
         $('#goodscategoryID312'+index).show();
         $('#goodscategoryID313'+index).hide();

         $('#ligoodscategoryID301'+index).hide();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();
         $('#ligoodscategoryID310'+index).show();
         $('#ligoodscategoryID311'+index).hide();

         $('#propertyImg'+index).hide();
     }  

     if (obj.value == '5_0' || obj.value == '6_8' || obj.value == '7_0' || obj.value == '9_0'){
    	 change3_son2(obj,index);
     }
     
 }

 function change3_son2(obj,index){
     $('#goodscategoryID301'+index).val('');
     $('#goodscategoryID302'+index).val('');
     $('#goodscategoryID303'+index).val('');
     $('#goodscategoryID304'+index).val('');
     $('#goodscategoryID305'+index).val('');
     $('#goodscategoryID306'+index).val('');
     $('#goodscategoryID307'+index).val('');
     $('#goodscategoryID308'+index).val('');
     $('#goodscategoryID309'+index).val('');
     $('#goodscategoryID310'+index).val('');
     $('#goodscategoryID311'+index).val('');
     $('#goodscategoryID312'+index).val('');
     $('#goodscategoryID313'+index).val('');
     
     $('#goodscategoryID301'+index).hide();
     $('#goodscategoryID302'+index).hide();
     $('#goodscategoryID303'+index).hide();
     $('#goodscategoryID304'+index).hide();
     $('#goodscategoryID305'+index).hide();
     $('#goodscategoryID306'+index).hide();
     $('#goodscategoryID307'+index).hide();
     $('#goodscategoryID308'+index).hide();
     $('#goodscategoryID309'+index).hide();
     $('#goodscategoryID310'+index).hide();
     $('#goodscategoryID311'+index).hide();
     $('#goodscategoryID312'+index).hide();
     $('#goodscategoryID313'+index).hide();

     $('#ligoodscategoryID301'+index).hide();
     $('#ligoodscategoryID302'+index).hide();
     $('#ligoodscategoryID303'+index).hide();
     $('#ligoodscategoryID304'+index).hide();
     $('#ligoodscategoryID305'+index).hide();
     $('#ligoodscategoryID306'+index).hide();
     $('#ligoodscategoryID307'+index).hide();
     $('#ligoodscategoryID308'+index).hide();
     $('#ligoodscategoryID309'+index).hide();
     $('#ligoodscategoryID310'+index).hide();
     $('#ligoodscategoryID311'+index).hide();

     $('#propertyImg'+index).hide();
 }
 
 function change4(obj,index){

	 if (obj.value == '4_0' || obj.value == '4_D' || obj.value == '4' || obj.value == '5_0' || obj.value == '2_0'){
	     change5_son2(obj,index);
	 }
	 
	 change4_son(obj,index);

	 if (obj.value == '2_0' || obj.value == '6_6' || obj.value == '1_0' || obj.value == '6_8' || obj.value == '7_0' || obj.value == '9_0'){
	     change4_son2(obj,index);
	     change5_son(obj,index);
	 }
     
     $(obj).parent().parent().parent().parent().find('tr[hide=hide]').find('select').find('option').remove();
     $(obj).parent().parent().parent().parent().find('tr[hide=hide]').hide();
     $('#ssmspropertyvaluearray' + index).val('');
     $('#ssmsgoodspropertyarray' + index).val('');
     
     clearGoods(index);
 }

 function change4_son(obj,index){
	 
     if (obj.value == '2_0' || obj.value == '5_0'){
         $('#goodscategoryID401'+index).val('');
         $('#goodscategoryID402'+index).val('');
         $('#goodscategoryID403'+index).val('');
         $('#goodscategoryID408'+index).val('');
         $('#goodscategoryID409'+index).val('');
         $('#goodscategoryID410'+index).val('');
         $('#goodscategoryID411'+index).val('');
                  
         $('#goodscategoryID401'+index).hide();
         $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
         $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
         $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();

         $('#ligoodscategoryID401'+index).hide();
         $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
         $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();

         $('#propertyImg'+index).hide();
         
     }
     
     if (obj.value == '4' || obj.value == '4_0' || obj.value == '4_D'){
         $('#goodscategoryID401'+index).val('');
         $('#goodscategoryID402'+index).val('');
         $('#goodscategoryID403'+index).val('');  
         $('#goodscategoryID408'+index).val('');
         $('#goodscategoryID409'+index).val('');
         $('#goodscategoryID410'+index).val('');
         $('#goodscategoryID411'+index).val('');
         
         $('#goodscategoryID401'+index).show();
         $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
         $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
         $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();

         $('#ligoodscategoryID401'+index).show();
         $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
         $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();

         $('#propertyImg'+index).hide();
     }

     if (obj.value == '6_6'){
    	 change4_son2(obj,index);
     }

     if (obj.value == '1_0'){
    	 change4_son2(obj,index);

    	 $('#goodscategoryID312'+index).hide();
         $('#goodscategoryID306'+index).show();
         	 
    	 $('#ligoodscategoryID310'+index).hide();
    	 $('#ligoodscategoryID306'+index).show();
     }

     if (obj.value == '6_8' || obj.value == '7_0' || obj.value == '9_0'){
    	 change4_son2(obj,index);

    	 $('#goodscategoryID312'+index).hide();         	 
    	 $('#ligoodscategoryID310'+index).hide();
     }
     
 }

 function change4_son2(obj,index){
	 
     $('#goodscategoryID401'+index).val('');
     $('#goodscategoryID402'+index).val('');
     $('#goodscategoryID403'+index).val('');
     $('#goodscategoryID408'+index).val('');
     $('#goodscategoryID409'+index).val('');
     $('#goodscategoryID410'+index).val('');
     $('#goodscategoryID411'+index).val('');
              
     $('#goodscategoryID401'+index).hide();
     $('#goodscategoryID402'+index).hide();
     $('#goodscategoryID403'+index).hide();
     $('#goodscategoryID408'+index).hide();
     $('#goodscategoryID409'+index).hide();
     $('#goodscategoryID410'+index).hide();
     $('#goodscategoryID411'+index).hide();

     $('#ligoodscategoryID401'+index).hide();
     $('#ligoodscategoryID402'+index).hide();
     $('#ligoodscategoryID403'+index).hide();
     $('#ligoodscategoryID408'+index).hide();
     $('#ligoodscategoryID409'+index).hide();

	 $('#goodscategoryID301'+index).hide();
     $('#goodscategoryID302'+index).hide();
     $('#goodscategoryID303'+index).hide();
     $('#goodscategoryID304'+index).hide();
     $('#goodscategoryID305'+index).hide();
     $('#goodscategoryID306'+index).hide();
     $('#goodscategoryID307'+index).hide();
     $('#goodscategoryID308'+index).hide();
     $('#goodscategoryID309'+index).hide();
     $('#goodscategoryID310'+index).hide();
     $('#goodscategoryID311'+index).hide();
     $('#goodscategoryID312'+index).show();
     $('#goodscategoryID313'+index).hide();
     
     $('#ligoodscategoryID301'+index).hide();
     $('#ligoodscategoryID302'+index).hide();
     $('#ligoodscategoryID303'+index).hide();
     $('#ligoodscategoryID304'+index).hide();
     $('#ligoodscategoryID305'+index).hide();
     $('#ligoodscategoryID306'+index).hide();
     $('#ligoodscategoryID307'+index).hide();
     $('#ligoodscategoryID308'+index).hide();
     $('#ligoodscategoryID309'+index).hide();
     $('#ligoodscategoryID310'+index).show();
     $('#ligoodscategoryID311'+index).hide();

     $('#propertyImg'+index).hide();
 }
 
 function change31(obj,index){
	 
	 $('#propertyImg'+index).show();
	 
     if (obj.value == '1'){
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');
         
         $('#goodscategoryID301'+index).show();
         $('#goodscategoryID302'+index).show();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide(); 
         $('#goodscategoryID308'+index).hide(); 
         $('#goodscategoryID309'+index).hide(); 
         $('#goodscategoryID310'+index).hide(); 
         $('#goodscategoryID311'+index).hide(); 

         $('#ligoodscategoryID301'+index).show();
         $('#ligoodscategoryID302'+index).show();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();              

     }
     if (obj.value == '2'){
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');         
     
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).show();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide(); 
         $('#goodscategoryID309'+index).hide(); 
         $('#goodscategoryID310'+index).hide(); 
         $('#goodscategoryID311'+index).hide(); 

         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).show();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide(); 
     }
     if (obj.value == '3'){
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');  
                  
         $('#goodscategoryID301'+index).show();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).show();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide(); 
         $('#goodscategoryID309'+index).hide(); 
         $('#goodscategoryID310'+index).hide(); 
         $('#goodscategoryID311'+index).hide(); 

         $('#ligoodscategoryID301'+index).show();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).show();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide(); 
     }
     if (obj.value == '4'){
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');  
                  
         $('#goodscategoryID301'+index).show();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).show();             
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide(); 
         $('#goodscategoryID309'+index).hide(); 
         $('#goodscategoryID310'+index).hide(); 
         $('#goodscategoryID311'+index).hide(); 

         $('#ligoodscategoryID301'+index).show();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).show();             
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide(); 
     } 
     if (obj.value == ''){
         $('#goodscategoryID301'+index).val('');
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');  
                 
         $('#goodscategoryID301'+index).show();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide(); 
         $('#goodscategoryID309'+index).hide(); 
         $('#goodscategoryID310'+index).hide(); 
         $('#goodscategoryID311'+index).hide(); 

         $('#ligoodscategoryID301'+index).show();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide(); 

         $('#propertyImg'+index).hide();
     }
     if (obj.value == '5'){
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');  
                  
         $('#goodscategoryID301'+index).show();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).show(); 
         $('#goodscategoryID309'+index).show(); 
         $('#goodscategoryID310'+index).hide(); 
         $('#goodscategoryID311'+index).hide(); 

         $('#ligoodscategoryID301'+index).show();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).show();
         $('#ligoodscategoryID309'+index).hide(); 
     } 
     if (obj.value == '6'){
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID306'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');  
                  
         $('#goodscategoryID301'+index).show();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();             
         $('#goodscategoryID306'+index).hide();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide(); 
         $('#goodscategoryID309'+index).hide(); 
         $('#goodscategoryID310'+index).show(); 
         $('#goodscategoryID311'+index).show(); 

         $('#ligoodscategoryID301'+index).show();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();             
         $('#ligoodscategoryID306'+index).hide();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).show(); 
     } 
     
     clearGoods(index);         
 }
 
function change32(obj,index){
	
     if (obj.value == '1'){
         $('#goodscategoryID301'+index).val('');
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');

         $('#goodscategoryID301'+index).hide();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).show();
         $('#goodscategoryID307'+index).show();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();

         $('#ligoodscategoryID301'+index).hide();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).show();
         $('#ligoodscategoryID307'+index).show();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();

         $('#propertyImg'+index).show();
     }
     if (obj.value == ''){
         $('#goodscategoryID301'+index).val('');
         $('#goodscategoryID302'+index).val('');
         $('#goodscategoryID303'+index).val('');
         $('#goodscategoryID304'+index).val('');
         $('#goodscategoryID305'+index).val('');
         $('#goodscategoryID307'+index).val('');
         $('#goodscategoryID308'+index).val('');
         $('#goodscategoryID309'+index).val('');
         $('#goodscategoryID310'+index).val('');
         $('#goodscategoryID311'+index).val('');
                            
         $('#goodscategoryID301'+index).hide();
         $('#goodscategoryID302'+index).hide();
         $('#goodscategoryID303'+index).hide();
         $('#goodscategoryID304'+index).hide();
         $('#goodscategoryID305'+index).hide();
         $('#goodscategoryID306'+index).show();
         $('#goodscategoryID307'+index).hide();
         $('#goodscategoryID308'+index).hide();
         $('#goodscategoryID309'+index).hide();
         $('#goodscategoryID310'+index).hide();
         $('#goodscategoryID311'+index).hide();

         $('#ligoodscategoryID301'+index).hide();
         $('#ligoodscategoryID302'+index).hide();
         $('#ligoodscategoryID303'+index).hide();
         $('#ligoodscategoryID304'+index).hide();
         $('#ligoodscategoryID305'+index).hide();
         $('#ligoodscategoryID306'+index).show();
         $('#ligoodscategoryID307'+index).hide();
         $('#ligoodscategoryID308'+index).hide();
         $('#ligoodscategoryID309'+index).hide();

         $('#propertyImg'+index).hide();
     }
     clearGoods(index);
 }
 
 function change41(obj,index){
     if (obj.value == '1'){
         $('#goodscategoryID402'+index).val('');
         $('#goodscategoryID403'+index).val('');
         $('#goodscategoryID408'+index).val('');
         $('#goodscategoryID409'+index).val('');
         $('#goodscategoryID410'+index).val('');
         $('#goodscategoryID411'+index).val('');
                  
         $('#goodscategoryID401'+index).show();
         $('#goodscategoryID402'+index).show();
         $('#goodscategoryID403'+index).hide();
         $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
         $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();

         $('#ligoodscategoryID401'+index).show();
         $('#ligoodscategoryID402'+index).show();
         $('#ligoodscategoryID403'+index).hide();
         $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();

         $('#propertyImg'+index).show();
     }
     if (obj.value == '2'){
         $('#goodscategoryID402'+index).val('');
         $('#goodscategoryID403'+index).val('');
         $('#goodscategoryID408'+index).val('');
         $('#goodscategoryID409'+index).val('');
         $('#goodscategoryID410'+index).val('');
         $('#goodscategoryID411'+index).val('');
                  
         $('#goodscategoryID401'+index).show();
         $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).show();
         $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
         $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();

         $('#ligoodscategoryID401'+index).show();
         $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).show();
         $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();

         $('#propertyImg'+index).show();
     }
     if (obj.value == ''){
         $('#goodscategoryID401'+index).val('');
         $('#goodscategoryID402'+index).val('');
         $('#goodscategoryID403'+index).val('');
         $('#goodscategoryID408'+index).val('');
         $('#goodscategoryID409'+index).val('');
         $('#goodscategoryID410'+index).val('');
         $('#goodscategoryID411'+index).val('');

         $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
         $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
         $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();

         $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
         $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).hide();

         $('#propertyImg'+index).hide();
     }
     if (obj.value == '5'){
         $('#goodscategoryID402'+index).val('');
         $('#goodscategoryID403'+index).val('');
         $('#goodscategoryID408'+index).val('');
         $('#goodscategoryID409'+index).val('');
         $('#goodscategoryID410'+index).val('');
         $('#goodscategoryID411'+index).val('');

         $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
         $('#goodscategoryID408'+index).show();
         $('#goodscategoryID409'+index).show();
         $('#goodscategoryID410'+index).hide();
         $('#goodscategoryID411'+index).hide();

         $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
         $('#ligoodscategoryID408'+index).show();
         $('#ligoodscategoryID409'+index).hide();

         $('#propertyImg'+index).show();
     }
     if (obj.value == '6'){
         $('#goodscategoryID402'+index).val('');
         $('#goodscategoryID403'+index).val('');
         $('#goodscategoryID408'+index).val('');
         $('#goodscategoryID409'+index).val('');
         $('#goodscategoryID410'+index).val('');
         $('#goodscategoryID411'+index).val('');

         $('#goodscategoryID402'+index).hide();
         $('#goodscategoryID403'+index).hide();
         $('#goodscategoryID408'+index).hide();
         $('#goodscategoryID409'+index).hide();
         $('#goodscategoryID410'+index).show();
         $('#goodscategoryID411'+index).show();

         $('#ligoodscategoryID402'+index).hide();
         $('#ligoodscategoryID403'+index).hide();
         $('#ligoodscategoryID408'+index).hide();
         $('#ligoodscategoryID409'+index).show();

         $('#propertyImg'+index).show();
     }
     clearGoods(index);
 }

function change5(obj,index){

	 change5_son(obj,index);
	
     $(obj).parent().parent().parent().parent().find('tr[hide=hide]').find('select').find('option').remove();
     $(obj).parent().parent().parent().parent().find('tr[hide=hide]').hide();
     $('#ssmspropertyvaluearray' + index).val('');
     $('#ssmsgoodspropertyarray' + index).val('');
     
     clearGoods(index);    
}

function change5_son(obj,index){
	
    if (obj.value == '6_6'){
        $('#goodscategoryID306'+index).val('');
        $('#goodscategoryID307'+index).val('');
        $('#goodscategoryID312'+index).val('');
        $('#goodscategoryID313'+index).val('');
                 
        $('#goodscategoryID306'+index).hide();
        $('#goodscategoryID307'+index).hide();
        $('#goodscategoryID312'+index).show();
        $('#goodscategoryID313'+index).hide();

        $('#ligoodscategoryID306'+index).hide();
        $('#ligoodscategoryID307'+index).hide();
        $('#ligoodscategoryID312'+index).show();
        $('#ligoodscategoryID313'+index).hide();

        $('#propertyImg'+index).hide();
        
    }
    
    if (obj.value == '1_0'){
        $('#goodscategoryID306'+index).val('');
        $('#goodscategoryID307'+index).val('');
        $('#goodscategoryID312'+index).val('');
        $('#goodscategoryID313'+index).val('');
                 
        $('#goodscategoryID306'+index).show();
        $('#goodscategoryID307'+index).hide();
        $('#goodscategoryID312'+index).hide();
        $('#goodscategoryID313'+index).hide();

        $('#ligoodscategoryID306'+index).show();
        $('#ligoodscategoryID307'+index).hide();
        $('#ligoodscategoryID312'+index).hide();
        $('#ligoodscategoryID313'+index).hide();

        $('#propertyImg'+index).hide();
    }

    if (obj.value != '1_0' && obj.value != '6_6'){
        $('#goodscategoryID306'+index).val('');
        $('#goodscategoryID307'+index).val('');
        $('#goodscategoryID312'+index).val('');
        $('#goodscategoryID313'+index).val('');
                 
        $('#goodscategoryID306'+index).hide();
        $('#goodscategoryID307'+index).hide();
        $('#goodscategoryID312'+index).hide();
        $('#goodscategoryID313'+index).hide();

        $('#ligoodscategoryID306'+index).hide();
        $('#ligoodscategoryID307'+index).hide();
        $('#ligoodscategoryID312'+index).hide();
        $('#ligoodscategoryID313'+index).hide();

        $('#propertyImg'+index).hide();
    }
    
}

function change5_son2(obj,index){
	
    $('#goodscategoryID402'+index).hide();
    $('#goodscategoryID403'+index).hide();
    $('#goodscategoryID408'+index).hide();
    $('#goodscategoryID409'+index).hide();
    $('#goodscategoryID410'+index).hide();
    $('#goodscategoryID411'+index).hide();
    $('#goodscategoryID306'+index).hide();
    $('#goodscategoryID307'+index).hide();        
    $('#goodscategoryID312'+index).hide();
    $('#goodscategoryID313'+index).hide();
    
    $('#ligoodscategoryID402'+index).hide();
    $('#ligoodscategoryID403'+index).hide();
    $('#ligoodscategoryID408'+index).hide();
    $('#ligoodscategoryID409'+index).hide();
    $('#ligoodscategoryID306'+index).hide();
    $('#ligoodscategoryID307'+index).hide();
    $('#ligoodscategoryID310'+index).hide();
    $('#ligoodscategoryID311'+index).hide();
}

function change51(obj,index){
	
    if (obj.value == '1'){
        $('#goodscategoryID313'+index).val('');
        $('#goodscategoryID313'+index).show();

        $('#ligoodscategoryID311'+index).show();

        $('#propertyImg'+index).show();        
    }
    
    if (obj.value == ''){
    	$('#goodscategoryID312'+index).val('');
        $('#goodscategoryID313'+index).val('');
        
        $('#goodscategoryID311'+index).hide();
        $('#ligoodscategoryID311'+index).hide();

        $('#propertyImg'+index).hide();        
    }
    
    clearGoods(index);
}

/**
 * 清空商品开窗后带回的数据
 */
function clearGoods(index){
	$('#goodsName'+index).val('');
	$('#supplier'+index).val('');
	$('#goodscategory2id'+index).val('');
	$('#brand'+index).val('');	   
	$('#iscustomize'+index).val('');
	$('#goods'+index).val('');
	$('#minCostPrice'+index).val('');
	$('#maxCostPrice'+index).val('');
	$('#bigClass'+index).val('');
	$('#smallClass'+index).val('');
	$('#minCostPriceAmount'+index).val('');
	$('#maxCostPriceAmount'+index).val('');      
	//$('#goodsquantity'+index).val('1');                
	//$('#specialoffer'+index).val('');
	$('#ssmsgoodsclass'+index).val('');
	//$('#ssmsgbeginAmount'+index).val('');
	//$('#ssmsgendAmount'+index).val('');
	$('#spanminCostPriceAmount'+index).text('');
	$('#spanmaxCostPriceAmount'+index).text('');
 }
 
/*
 *  计算套餐价格区间
 */
 function amoumt(){
     var total = '';
     var tempTotal = 0;
     var beginAmount = document.getElementsByName("salesGoodsArray.ssmsgbeginAmount");
     var beginquantity = document.getElementsByName("salesGoodsArray.ssmsggoodsquantity");
     for (var i = 0 ; i < beginAmount.length ; i++){
         tempTotal = accMul(beginAmount[i].value,beginquantity[i].value);
    	 total = accAdd(total,tempTotal);
     }
     beginAmount = document.getElementsByName("creditGoodsArray.ssmsgbeginAmount");
     beginquantity = document.getElementsByName("creditGoodsArray.ssmsggoodsquantity");
     for (var i = 0 ; i < beginAmount.length ; i++){
         tempTotal = accMul(beginAmount[i].value,beginquantity[i].value);
    	 total = accAdd(total,tempTotal);
     }     
     $('#ssmsmsourcebgnAmount').val(total == '' ? '' : parseFloat(total).toFixed(2));
     
     total = '';
     tempTotal = 0;
     var endAmount = document.getElementsByName("salesGoodsArray.ssmsgendAmount");
     var endquantity = document.getElementsByName("salesGoodsArray.ssmsggoodsquantity");
     for (var i = 0 ; i < endAmount.length ; i++){
         tempTotal = accMul(endAmount[i].value,endquantity[i].value);
    	 total = accAdd(total,tempTotal);
     }
     endAmount = document.getElementsByName("creditGoodsArray.ssmsgendAmount");
     endquantity = document.getElementsByName("creditGoodsArray.ssmsggoodsquantity");
     for (var i = 0 ; i < endAmount.length ; i++){
         tempTotal = accMul(endAmount[i].value,endquantity[i].value);
    	 total = accAdd(total,tempTotal);
     }
     $('#ssmsmsourceendAmount').val(total == '' ? '' : parseFloat(total).toFixed(2));
     
     if ($('#adjustmentPrice') != null){
         $('#ssmsmendbgnAmount').val($('#adjustmentPrice').val());
     }

 }

/*
* 保存时验证是否重复
*/
function getVerifyData(){
	var goodscategoryIDs = document.getElementsByName("goodscategoryID");
	var ssmsggoodsid1s = document.getElementsByName("salesGoodsArray.ssmsggoodsid");
	var ssmsggoodsid2s = document.getElementsByName("creditGoodsArray.ssmsggoodsid");		
	var count1 = ssmsggoodsid1s.length;
	var count2 = ssmsggoodsid2s.length;
    var goodscategoryID301s = document.getElementsByName("goodscategoryID301");
    var goodscategoryID302s = document.getElementsByName("goodscategoryID302");
    var goodscategoryID303s = document.getElementsByName("goodscategoryID303");
    var goodscategoryID304s = document.getElementsByName("goodscategoryID304");
    var goodscategoryID305s = document.getElementsByName("goodscategoryID305");
    var goodscategoryID306s = document.getElementsByName("goodscategoryID306");
    var goodscategoryID307s = document.getElementsByName("goodscategoryID307");
    var goodscategoryID401s = document.getElementsByName("goodscategoryID401");
    var goodscategoryID402s = document.getElementsByName("goodscategoryID402");
    var goodscategoryID403s = document.getElementsByName("goodscategoryID403");
    
    var t2 = new Array();
    var i = 0;
	for (i = 0; i < count1; i++ ){
		t2[i] = ssmsggoodsid1s[i].value;
	}
	for (var j = 0; j < count2; j++ ){
		t2[i+j] = ssmsggoodsid2s[j].value;
	}

	for (var i = 0; i < goodscategoryIDs.length; i++ ){
		for (var j = i+1; j < goodscategoryIDs.length; j++ ){
            if (goodscategoryIDs[i].value == goodscategoryIDs[j].value){
                if (goodscategoryIDs[i].value.substring(0,1) == '1' && (goodscategoryID306s[i].value == goodscategoryID306s[j].value)  && (goodscategoryID307s[i].value == goodscategoryID307s[j].value) && (t2[i] == t2[j])){
                    return false;
                }	                
                if (goodscategoryIDs[i].value.substring(0,1) == '3' && (goodscategoryID301s[i].value == goodscategoryID301s[j].value) && (goodscategoryID302s[i].value == goodscategoryID302s[j].value) && (goodscategoryID303s[i].value == goodscategoryID303s[j].value) && (goodscategoryID304s[i].value == goodscategoryID304s[j].value) && (goodscategoryID305s[i].value == goodscategoryID305s[j].value) && (t2[i] == t2[j])){
                    return false;
                }
                if (goodscategoryIDs[i].value.substring(0,1) == '4' && (goodscategoryID401s[i].value == goodscategoryID401s[j].value) && (goodscategoryID402s[i].value == goodscategoryID402s[j].value) && (goodscategoryID403s[i].value == goodscategoryID403s[j].value) && (t2[i] == t2[j])){
                    return false;
                }
                if ((goodscategoryIDs[i].value.substring(0,1) == '2' || goodscategoryIDs[i].value.substring(0,1) == '6') && (t2[i] == t2[j])){
                    return false;
                }
            }
		}
	}
    return true;
}

// 根据活动单价计算套餐合计
function getSetMealAmount(obj){
	if ($('#ssmsmform').val() == '3'){
       return;
    }
	if ($.trim(obj.value) == ''){
		obj.value = $.trim(obj.value);
		$('#ssmsmendbgnAmount').val('');
        return;
    }
    if (!isNaN(obj.value)){
    	obj.value = $.trim(obj.value);
   	    obj.value = new Number(obj.value).toFixed(2);
    	var ssmsggoodsquantity1s = document.getElementsByName("salesGoodsArray.ssmsggoodsquantity");
   		var ssmsgretailPrice1s = document.getElementsByName("salesGoodsArray.ssmsgretailPrice");
   		var ssmsggoodsquantity2s = document.getElementsByName("creditGoodsArray.ssmsggoodsquantity");
   		var ssmsgretailPrice2s = document.getElementsByName("creditGoodsArray.ssmsgretailPrice");
        var total = 0;

        if (ssmsggoodsquantity1s.length != 0 && ssmsgretailPrice1s.length != 0){
   		    for (var i = 0; i < ssmsggoodsquantity1s.length; i++){
                if ($.trim(ssmsgretailPrice1s[i].value)==''){
                	$('#ssmsmendbgnAmount').val('');
                	return;
                }
       			total = accAdd(total,accMul(ssmsggoodsquantity1s[i].value,ssmsgretailPrice1s[i].value));
            }
        }
        if (ssmsggoodsquantity2s.length != 0 && ssmsgretailPrice2s.length != 0){
   		    for (var i = 0; i < ssmsggoodsquantity2s.length; i++){
                if ($.trim(ssmsgretailPrice2s[i].value)==''){
                	$('#ssmsmendbgnAmount').val('');
                	return;
                }
   			    total = accAdd(total,accMul(ssmsggoodsquantity2s[i].value,ssmsgretailPrice2s[i].value));
            }
        }

        $('#ssmsmendbgnAmount').val(parseFloat(total).toFixed(2));
    }else{
    	obj.value = '';
    	$('#ssmsmendbgnAmount').val('');
    }
}

// 根据数量计算套餐合计
function getSetMealAmount3(obj){	
    amoumt();
	if (isNaN(obj.value) || $.trim(obj.value) == ''){
		obj.value = "1";
    }    	
	var ssmsggoodsquantity1s = document.getElementsByName("salesGoodsArray.ssmsggoodsquantity");
	var ssmsgretailPrice1s = document.getElementsByName("salesGoodsArray.ssmsgretailPrice");
	var ssmsggoodsquantity2s = document.getElementsByName("creditGoodsArray.ssmsggoodsquantity");
	var ssmsgretailPrice2s = document.getElementsByName("creditGoodsArray.ssmsgretailPrice");
    var total = 0;

    if (ssmsggoodsquantity1s.length != 0 && ssmsgretailPrice1s.length != 0){
		    for (var i = 0; i < ssmsggoodsquantity1s.length; i++){
            if ($.trim(ssmsgretailPrice1s[i].value)==''){
            	$('#ssmsmendbgnAmount').val('');
            	return;
            }
   			total = accAdd(total,accMul(ssmsggoodsquantity1s[i].value,ssmsgretailPrice1s[i].value));
        }
    }
    if (ssmsggoodsquantity2s.length != 0 && ssmsgretailPrice2s.length != 0){
		    for (var i = 0; i < ssmsggoodsquantity2s.length; i++){
            if ($.trim(ssmsgretailPrice2s[i].value)==''){
            	$('#ssmsmendbgnAmount').val('');
            	return;
            }
			    total = accAdd(total,accMul(ssmsggoodsquantity2s[i].value,ssmsgretailPrice2s[i].value));
        }
    }

    $('#ssmsmendbgnAmount').val(parseFloat(total).toFixed(2));        
}    

//数据准确性
function validateData(){
	
   //套餐区间下限小于上限
   var beginAmount = document.getElementsByName("salesGoodsArray.ssmsgbeginAmount");
   var endAmount = document.getElementsByName("salesGoodsArray.ssmsgendAmount");
   var beginAmount2 = document.getElementsByName("creditGoodsArray.ssmsgbeginAmount");
   var endAmount2 = document.getElementsByName("creditGoodsArray.ssmsgendAmount");

   if (beginAmount.length > 0 ){
	   for (var i = 0; i < beginAmount.length; i++){
	       if (Number(beginAmount[i].value) > Number(endAmount[i].value)){
	           alert("套餐价格区间金额有误,请重新填写!");
	           beginAmount[i].focus();
	           return true;
	       }
	   }
   }

   if (beginAmount2.length > 0 ){
	   for (var i = 0; i < beginAmount2.length; i++){
	       if (Number(beginAmount2[i].value) > Number(endAmount2[i].value)){
	           alert("套餐价格区间金额有误,请重新填写!");
	           beginAmount2[i].focus();
	           return true;
	       }
	   }
   }

   //套餐价格区间要包含在商品原价区间内
   var sbeginAmount = document.getElementsByName("salesGoodsArray.ssmsgmincostPrice");
   var sendAmount = document.getElementsByName("salesGoodsArray.ssmsgmaxcostPrice");
   var sbeginAmount2 = document.getElementsByName("creditGoodsArray.ssmsgmincostPrice");
   var sendAmount2 = document.getElementsByName("creditGoodsArray.ssmsgmaxcostPrice");

   if (sbeginAmount.length > 0 ){
	   for (var i = 0; i < sbeginAmount.length; i++){
	       if ((Number(beginAmount[i].value) < Number(sbeginAmount[i].value)) && beginAmount[i].value != '' && sbeginAmount[i].value != ''){
	           alert("套餐价格区间金额有误,请重新填写!");
	           beginAmount[i].focus();
	           return true;
	       }
	       if ((Number(endAmount[i].value) > Number(sendAmount[i].value)) && endAmount[i].value != '' && sendAmount[i].value != ''){
	           alert("套餐价格区间金额有误,请重新填写!");
	           endAmount[i].focus();
	           return true;
	       }
	   }
   }

   if (sbeginAmount2.length > 0 ){
	   for (var i = 0; i < sbeginAmount2.length; i++){
	       if ((Number(beginAmount2[i].value) < Number(sbeginAmount2[i].value)) && beginAmount2[i].value != '' && sbeginAmount2[i].value != ''){
	           alert("套餐价格区间金额有误,请重新填写!");
	           beginAmount2[i].focus();
	           return true;
	       }
	       if ((Number(endAmount2[i].value) > Number(sendAmount2[i].value)) && endAmount2[i].value != '' && sendAmount2[i].value != ''){
	           alert("套餐价格区间金额有误,请重新填写!");
	           endAmount2[i].focus();
	           return true;
	       }
	   }
   }
   
   //消费满区间下限小于上限
   var beginAmount3 = document.getElementsByName("salesGoodsArray.ssmsgexpensespendup");
   var endAmount3 = document.getElementsByName("salesGoodsArray.ssmsgexpensespendul");

   if (beginAmount3.length > 0 ){
	   for (var i = 0; i < beginAmount3.length; i++){
	       if ($.trim(beginAmount3[i].value) != '' && $.trim(endAmount3[i].value) != '' && Number(beginAmount3[i].value) > Number(endAmount3[i].value)){
	           alert("商品消费满区间金额有误,请重新填写!");
	           beginAmount3[i].focus();
	           return true;
	       }
	   }
   }
   
  /*
   var c_retailPrice2 = document.getElementsByName("creditGoodsArray.ssmsgretailPrice");
   var s_retailPrice2 = document.getElementsByName("salesGoodsArray.ssmsgretailPrice");
   var s_goodsquantity = document.getElementsByName("salesGoodsArray.ssmsggoodsquantity");
   var c_goodsquantity = document.getElementsByName("creditGoodsArray.ssmsggoodsquantity");
   var c_specialoffer = document.getElementsByName("creditGoodsArray.ssmsgspecialoffer");
   var s_specialoffer = document.getElementsByName("salesGoodsArray.ssmsgspecialoffer");
   var c_expensecredit = document.getElementsByName("creditGoodsArray.ssmsgexpensecredit");
   var s_expensecredit = document.getElementsByName("salesGoodsArray.ssmsgexpensecredit");
   var c_favorableflag = document.getElementsByName("creditGoodsArray.ssmsgfavorableflag");
   var s_favorableflag = document.getElementsByName("salesGoodsArray.ssmsgfavorableflag");

   //特价(优惠)的商品：套餐单价 * 数量 = 特价(优惠)金额
   if (c_retailPrice2.length > 0 ){
	   for (var i = 0; i < c_retailPrice2.length; i++){
	       if ($.trim(c_retailPrice2[i].value) != '' && c_favorableflag[i].value == '4' && (accMul(Number(c_retailPrice2[i].value),Number(c_goodsquantity[i].value)) != Number(c_specialoffer[i].value))){
	           alert("商品特价金额填写有误,请重新填写!");
	           c_specialoffer[i].focus();
	           return true;
	       }
	       if ($.trim(c_retailPrice2[i].value) != '' && c_favorableflag[i].value == '3' && (accMul(Number(c_retailPrice2[i].value),Number(c_goodsquantity[i].value)) != Number(c_expensecredit[i].value))){
	           alert("商品优惠金额填写有误,请重新填写!");
	           c_expensecredit[i].focus();
	           return true;
	       }
	   }
   }

   //特价(优惠)的商品：套餐单价 * 数量 = 特价(优惠)金额
   if (s_retailPrice2.length > 0 ){
	   for (var i = 0; i < s_retailPrice2.length; i++){
	       if ($.trim(s_retailPrice2[i].value) != '' && s_favorableflag[i].value == '4' && (accMul(Number(s_retailPrice2[i].value),Number(s_goodsquantity[i].value)) != Number(s_specialoffer[i].value))){
	           alert("商品特价金额填写有误,请重新填写!");
	           s_specialoffer[i].focus();
	           return true;
	       }
	       if ($.trim(s_retailPrice2[i].value) != '' && s_favorableflag[i].value == '3' && (accMul(Number(s_retailPrice2[i].value),Number(s_goodsquantity[i].value)) != Number(s_expensecredit[i].value))){
	           alert("商品优惠金额填写有误,请重新填写!");
	           s_expensecredit[i].focus();
	           return true;
	       }
	   }
   }
   */

   //允许累加时,必须要填写消费满区间
   if ($('input[name=setMealPo.ssmsmissum]:checked').val() == '1'){

	   var expensespendup = document.getElementsByName("salesGoodsArray.ssmsgexpensespendup");
	   var expensespendul = document.getElementsByName("salesGoodsArray.ssmsgexpensespendul");

	   for (var i = 0; i < expensespendup.length; i++){
           if ($.trim(expensespendup[i].value) == '' && $.trim(expensespendul[i].value) == '' ){
               alert("套餐在允许累加时,需要为抵扣商品设定消费满区间!");
               expensespendup[i].focus();
               return true;
           }
	   }
   }
   
   //套餐单价不能超过套餐价格上限和商品原价上限
   
   return false;
}

// 购买区商品按回车,自动转到下一个输入框内
function xfEnterDown(index,id,id2){
   if(event.keyCode == 13){
       var flag = false;
       $(':[xf'+id+'=xf'+index+']').each(function(){
	       if (!$(this).is(":hidden")){
               $(this).focus();
               flag = true;
               return false;
		   }
	   });
	   if (flag){
           return;
	   }
	   if (id2 != ''){
	       $(':[xf'+id2+'=xf'+index+']').each(function(){
		       if (!$(this).is(":hidden")){
                   $(this).focus();
                   return false;
			   }
		   });
	   }

   }
}

// 优惠区商品按回车,自动转到下一个输入框内
function dkEnterDown(index,id,id2){
   if(event.keyCode == 13){
       var flag = false;
       $(':[dk'+id+'=dk'+index+']').each(function(){
	       if (!$(this).is(":hidden")){
               $(this).focus();
               flag = true;
               return false;
		   }
	   });
	   if (flag){
           return;
	   }
	   if (id2 != ''){
	       $(':[dk'+id2+'=dk'+index+']').each(function(){
		       if (!$(this).is(":hidden")){
                   $(this).focus();
                   return false;
			   }
		   });
	   }

   }
}

/**
 * 活动门店开窗
 */
function openDepartment(){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	
	document.getElementById('popupTitle').innerHTML="【活动门店查询】";
}

/**
 * 活动门店开窗赋值实现方法
 */
function openDepartmentValues(objValue){
	var arrayID = new Array();
	var arrayName = new Array();
	var departments = eval('(' + objValue + ')');
	for(var i = 0; i < departments.length; i++){	
		arrayID[i] = departments[i].bdpdepartmentid;
		arrayName[i] = departments[i].bdpdepartmentname;
	}
	
	document.getElementById('departmentID').value = arrayID.join(",");
	document.getElementById('bdpdepartmentname').value = arrayName.join(",");
	document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
}

/**
 * 清空活动部门
 */
function cleanDepartment(){
	document.getElementById('departmentID').value = '';
	document.getElementById('bdpdepartmentname').value = '';
	document.getElementById('ds').value = '';
	$('#chks').attr('checked',false);
}

function computeUnitCost(index,flag){
	if (flag == '1'){   //  1.特价     2. 优惠    3.数量
		if ($('#specialoffer'+index).attr('readonly') == false){
			$('#ssmsgretailPrice'+index).val(parseFloat(accDiv($('#specialoffer'+index).val(),$('#goodsquantity'+index).val())).toFixed(2));
	    }		
	}else if (flag == '2'){
		if ($('#ssmsgexpensecredit'+index).attr('readonly') == false){
			$('#ssmsgretailPrice'+index).val(parseFloat(accDiv($('#ssmsgexpensecredit'+index).val(),$('#goodsquantity'+index).val())).toFixed(2));
	    }		
	}else if (flag == '3'){		
        if ($('#ssmsgfavorableflag'+index).find('option:selected').val() == '4'){
        	$('#ssmsgretailPrice'+index).val(parseFloat(accDiv($('#specialoffer'+index).val(),$('#goodsquantity'+index).val())).toFixed(2));
        }else if ($('#ssmsgfavorableflag'+index).find('option:selected').val() == '3'){
        	$('#ssmsgretailPrice'+index).val(parseFloat(accDiv($('#ssmsgexpensecredit'+index).val(),$('#goodsquantity'+index).val())).toFixed(2));
        }
	}else{
	}	
}

function addGoodsBatch(flag){
    if ($('#ssmsmclassify').val() == ''){
        alert("请先选择套餐分类!");
        return;
    }
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initSetMealGoodsOpenSel.action?goodsflag="+flag+"&salestype="+$('#ssmsmclassify').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initSetMealGoodsOpenSel.action?goodsflag="+flag+"&salestype="+$('#ssmsmclassify').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【商品查询】";
}

</script>