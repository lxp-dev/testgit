<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<script type="text/javascript">

//验证商品是否选择重复
function validateGoodsPropertyRepeat(counti,countj,idx,goodscategoryID,i_propertyArray,j_propertyArray,i_supplierIDArray,j_supplierIDArray,i_brandIDArray,j_brandIDArray,i_goodsIDArray,j_goodsIDArray,i_beginAmount,j_beginAmount,i_endAmount,j_endAmount,i_mincostPrice,j_mincostPrice,i_maxcostPrice,j_maxcostPrice){
	
    for (var i = 0; (i < counti && counti >= 1); i++){
        for (var j = idx; (j < countj && countj >= 1); j++){
        	if (goodscategoryID[i].value.substring(0,1) == goodscategoryID[counti + j].value.substring(0,1)){

                var temp_a1 = i_beginAmount[i].value == '' ? i_mincostPrice[i].value : i_beginAmount[i].value;
                var temp_a2 = i_endAmount[i].value == '' ? i_maxcostPrice[i].value : i_endAmount[i].value;
                var temp_b1 = j_beginAmount[j].value == '' ? j_mincostPrice[j].value : j_beginAmount[j].value;
                var temp_b2 = j_endAmount[j].value == '' ? j_maxcostPrice[j].value : j_endAmount[j].value;
                
                if (goodscategoryID[i].value.substring(0,1) == '6'){                    
                	if ((goodscategoryID[i].value.substring(3,2) == goodscategoryID[counti + j].value.substring(3,2)) && (goodscategoryID[i].value.substring(3,2) == '8')){   // 同为老花镜
                        //判断套餐区间
                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                            return true;
                        }
                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                            return true;
                        }
                    }
                    
                	if ((goodscategoryID[i].value.substring(3,2) == goodscategoryID[counti + j].value.substring(3,2)) && (goodscategoryID[i].value.substring(3,2) == '6')){   // 同为太阳镜
                    	//判断太阳镜功能是否相同
                    	if ((i_propertyArray[i].value == j_propertyArray[j].value) || j_propertyArray[j].value == '' || i_propertyArray[i].value == ''){

                            //判断制造商
                            if (i_supplierIDArray[i].value == '' || j_supplierIDArray[j].value == '' ){
                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                    return true;
                                }
                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                    return true;
                                }
                            }else if (i_supplierIDArray[i].value == j_supplierIDArray[j].value){
                                //判断品种
                                if (i_brandIDArray[i].value == '' || j_brandIDArray[j].value == ''  ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (i_brandIDArray[i].value == j_brandIDArray[j].value){
                                    //商品代码
                                    if (i_goodsIDArray[i].value == '' || j_goodsIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (i_goodsIDArray[i].value == j_goodsIDArray[j].value){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }                                       
                                    }else {
                                    	if (i_goodsIDArray[i].value.length != j_goodsIDArray[j].value.length){  // 例如制造商对应品种
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

                    	if ((goodscategoryID[i].value.length == 1 || goodscategoryID[counti + j].value.length == 1) || (goodscategoryID[i].value == goodscategoryID[counti + j].value)){
                    		//判断镜片或隐性镜片属性是否相同
                            var a = new Array(8); // 镜片6个属性,索引表示各个属性的ID,要声明8个
                            for (var k = 0; k < a.length; k++){  //初始化
                                a[k] = '';
                            }

                            var a1 = new Array();
                            if (i_propertyArray[i].value.indexOf(',') > 0){
                            	a1 = i_propertyArray[i].value.split(',');
                            }else{
                            	a1[0] = i_propertyArray[i].value;
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
                            if (j_propertyArray[j].value.indexOf(',') > 0){
                            	b1 = j_propertyArray[j].value.split(',');
                            }else{
                            	b1[0] = j_propertyArray[j].value;
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
                                if (i_supplierIDArray[i].value == '' || j_supplierIDArray[j].value == '' ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (i_supplierIDArray[i].value == j_supplierIDArray[j].value){
                                    //判断品种
                                    if (i_brandIDArray[i].value == '' || j_brandIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (i_brandIDArray[i].value == j_brandIDArray[j].value){
                                        //商品代码
                                        if (i_goodsIDArray[i].value == '' || j_goodsIDArray[j].value == ''  ){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }else if (i_goodsIDArray[i].value == j_goodsIDArray[j].value){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }                                      
                                        }else {
                                        	if (i_goodsIDArray[i].value.length != j_goodsIDArray[j].value.length){  // 例如制造商对应品种
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
                        	if ((i_propertyArray[i].value == j_propertyArray[j].value) || j_propertyArray[j].value == '' || i_propertyArray[i].value == ''){

                                //判断制造商
                                if (i_supplierIDArray[i].value == '' || j_supplierIDArray[j].value == '' ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (i_supplierIDArray[i].value == j_supplierIDArray[j].value){
                                    //判断品种
                                    if (i_brandIDArray[i].value == '' || j_brandIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (i_brandIDArray[i].value == j_brandIDArray[j].value){
                                        //商品代码
                                        if (i_goodsIDArray[i].value == '' || j_goodsIDArray[j].value == ''  ){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }
                                        }else if (i_goodsIDArray[i].value == j_goodsIDArray[j].value){
                                            if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                                return true;
                                            }
                                            if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                                return true;
                                            }                                      
                                        }else {
                                        	if (i_goodsIDArray[i].value.length != j_goodsIDArray[j].value.length){  // 例如制造商对应品种
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
                            if (i_supplierIDArray[i].value == '' || j_supplierIDArray[j].value == '' ){
                                if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                    return true;
                                }
                                if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                    return true;
                                }
                            }else if (i_supplierIDArray[i].value == j_supplierIDArray[j].value){
                                //判断品种
                                if (i_brandIDArray[i].value == '' || j_brandIDArray[j].value == ''  ){
                                    if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                        return true;
                                    }
                                    if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                        return true;
                                    }
                                }else if (i_brandIDArray[i].value == j_brandIDArray[j].value){
                                    //商品代码
                                    if (i_goodsIDArray[i].value == '' || j_goodsIDArray[j].value == ''  ){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }
                                    }else if (i_goodsIDArray[i].value == j_goodsIDArray[j].value){
                                        if ((((Number(temp_a1) <= Number(temp_b1)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b1)) || temp_a2 == '')) || (((Number(temp_a1) <= Number(temp_b2)) || temp_a1 == '') && ((Number(temp_a2) >= Number(temp_b2)) || temp_a2 == ''))){
                                            return true;
                                        }
                                        if ((((Number(temp_b1) <= Number(temp_a1)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a1)) || temp_b2 == '')) || (((Number(temp_b1) <= Number(temp_a2)) || temp_b1 == '') && ((Number(temp_b2) >= Number(temp_a2)) || temp_b2 == ''))){
                                            return true;
                                        }                                       
                                    }else {
                                    	if (i_goodsIDArray[i].value.length != j_goodsIDArray[j].value.length){  // 例如制造商对应品种
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

</script>