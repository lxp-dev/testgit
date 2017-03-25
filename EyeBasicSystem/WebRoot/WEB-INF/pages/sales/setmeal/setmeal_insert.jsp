<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
    	$('#show1').hide();
    	$('#show2').hide();
    	$('#show3').hide();
    	$('#show4').hide();
    	$('#adjustmentPrice').removeAttr('validate');
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
	
	function save(){
		if(checkForm(setMealFrm)){
			var flag = getVerifyData();
			if (!flag){
				alert("所选商品重复!");
                return;
			}
			if ($('#ssmsmform').val() == '3'){
		         var adjustmentPrice = $('#adjustmentPrice').val();
		         var total=0;
		         $('input[name=salesGoodsArray.ssmsgspecialoffer]').each(function(){
		             total=accAdd(total,$(this).val());
		         });
		         
		         if (Number(adjustmentPrice) != Number(total) && Number(total) != 0){
		             alert("请重新填写特价金额!");
		             return;
		         }
		    }
		    if ($('#ssmsmform').val() == '1'){	
		    	if ((!$('#x1').attr('checked') && !$('#x2').attr('checked')) || (!$('#x3').attr('checked') && !$('#x4').attr('checked'))){
		            alert("请选择购买方式:任选其一或选择全部!");
		            return;
		        }
		    }
		    if ($('#ssmsmform').val() == '2'){
		        if ((!$('#x1').attr('checked') && !$('#x2').attr('checked')) ){
		            alert("请选择购买方式:任选其一或选择全部!");
		            return;
		        }
		 	    var goodscategoryIDs = document.getElementsByName("goodscategoryID").length;
		        var count = $('select[xiaofei=xiaofei]').size(); 
		        if ((accSub(goodscategoryIDs,count)!=0) && (!$('#x5').attr('checked') && !$('#x6').attr('checked'))){
		            alert("请选择购买方式:任选其一或选择全部!");
		            return;
		        }
		        if (accSub(goodscategoryIDs,count)==0){
		        	$('#x6').attr('checked','checked');
		        }
		    }
		    if ($('#ssmsmcreatedate').val() < $('#createdate').val()){
		        alert("请重新填写生效日期!");
		        $('#ssmsmcreatedate').focus();
		        return;
		    }
		    if ($('#ssmsmenddate').val() < $('#createdate').val()){
		        alert("请重新填写截止日期!");
		        $('#ssmsmenddate').focus();
		        return;
		    }
		    if($('.row').size()==0){
			    alert('请选择商品!');
			    return;
		    }
	        // 验证任选其一或符合全部是否合理
			if (validateSalesForm()){
				alert("购买方式选择有误，请重新选择!");
	            return;
			}
	        // 验证消费商品和抵扣商品不能为同类型商品
			if (validateSalesGoods()){
				alert("消费商品和抵扣商品不能为同类型商品，请重新选择!");
	            return;
			}
			if (validateData()){
	            return;
			}
	        if ($('#adjustmentPrice') != null){
	             $('#ssmsmendbgnAmount').val($('#adjustmentPrice').val());
	        }	
	        	    
			$("img").removeAttr("onclick");
			setMealFrm.action = "insertSetMeal.action";
		    setMealFrm.submit();

		}
	}


	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
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
    
    function chkAll3(){  
        var chks=document.all.chks3;
        $('input[id=chk3]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
    
    function chkAll4(){  
        var chks=document.all.chks4;
        $('input[id=chk4]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
    
     var index = 0;
     
     /**
	  *  添加一行购买商品（消费商品）
	  */	
     function addRow(){
        if ($('#ssmsmclassify').val() == ''){
            alert("请先选择套餐分类!");
            return;
        }
        var table = document.getElementById('addTablebangding');
        if ($('#ssmsmform').val() == '1'){
            index = accAdd(document.getElementById('addTablesong').rows.length - 1,accAdd(index,table.rows.length - 1));
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
								
		row.className = 'row';		
		c1.height="26";
		c1.innerHTML = '<input type="checkbox" id="chk1" name="chk1"/>';		
		
		var ssmsmclassify = $('#ssmsmclassify').val();
        if (ssmsmclassify == '1'){
                c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'
        		             +'<option value="1_0">镜架</option>'
      		                 +'<option value="2_1">配件</option>'
      		                 +'<option value="3">镜片</option>'
      		                 +'<option value="3_0">成品片</option>'
      		                 +'<option value="3_D">订做片</option>'
      	                     + '</select></li>'	
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材料分类</option>'
                      		 +'<option value="2">折射率</option>'     
      		                 +'<option value="3">光度分类</option>' 	
      		                 +'<option value="4">镜片功能</option>' 			            
      	                     +'</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="1">树脂</option>'
                      		 +'<option value="2">玻璃</option>'     
      		                 +'<option value="3">PC</option>' 			            
      	                     +'</select></li>'	      
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                             +'<s:iterator value="refractiveSetList">'
                             +'<option value="${brfname}">${brfname}</option>'
                             +'</s:iterator>'                      			            
      	                     +'</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="0">单光</option>'
                      		 +'<option value="m">多光</option>'     
      		                 +'<option value="j_1">青少年渐进</option>'
                      		 +'<option value="j_2">成人渐进</option>' 
      		                 +'<option value="k">抗疲劳</option>' 	
      		                 +'<option value="q">其他</option>' 			            
      	                     +'</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="1">白色片</option>'
                      		 +'<option value="2">变色片</option>'     
      		                 +'<option value="3">偏光片</option>'
      		                 +'<option value="4">变色偏光片</option>' 	
      		                 +'<option value="5">染色片</option>' 	
      		                 +'<option value="6">抗疲劳片</option>'
      		                 +'<option value="7">抗疲劳变色片</option>' 	
      		                 +'<option value="8">偏光抗疲劳片</option>' 			            
      	                     + '</select></li>'
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材质</option>'	            
      	                     +'</select></li>'	        	     
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                       +'<s:iterator value="frameMateriallist">'
                       +'<option value="${bfmid}">${bfmname}</option>'
                       +'</s:iterator>'
      	                     +'</select></li>'	          	                     
        }
        if (ssmsmclassify == '3'){
                        c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'
 		                     +'<option value="3">镜片</option>'
                             +'<option value="3_0">成品片</option>'
                      		 +'<option value="3_D">订做片</option>'     
      		                 +'<option value="1_0">镜架</option>'
      		                 +'<option value="2_1">配件</option>' 		            
      	                     + '</select></li>'	
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材料分类</option>'
                      		 +'<option value="2">折射率</option>'     
      		                 +'<option value="3">光度分类</option>' 	
      		                 +'<option value="4">镜片功能</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">树脂</option>'
                      		 +'<option value="2">玻璃</option>'     
      		                 +'<option value="3">PC</option>' 			            
      	                     + '</select></li>'	      
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                             +  '<s:iterator value="refractiveSetList">'
                             +  '<option value="${brfname}">${brfname}</option>'
                             +  '</s:iterator>'                      			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="0">单光</option>'
                      		 +'<option value="m">多光</option>'     
      		                 +'<option value="j_1">青少年渐进</option>'
                      		 +'<option value="j_2">成人渐进</option>' 
      		                 +'<option value="k">抗疲劳</option>' 	
      		                 +'<option value="q">其他</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">白色片</option>'
                      		 +'<option value="2">变色片</option>'     
      		                 +'<option value="3">偏光片</option>'
      		                 +'<option value="4">变色偏光片</option>' 	
      		                 +'<option value="5">染色片</option>' 	
      		                 +'<option value="6">抗疲劳片</option>'
      		                 +'<option value="7">抗疲劳变色片</option>' 
      		                 +'<option value="8">偏光抗疲劳片</option>' 		 			            
      	                     + '</select></li>'
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'
       		                 +'<option value="">----请选择----</option>'                            
                             + '<option value="1">材质</option>'	            
      	                     + '</select></li>'	        	     
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
                       +  '<s:iterator value="frameMateriallist">'
                       +  '<option value="${bfmid}">${bfmname}</option>'
                       +  '</s:iterator>'              
      	                     + '</select></li>'	            	                           	                          	                     
        }
        if (ssmsmclassify == '4'){
                 c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'1\',\'6\')">'       
                 			 +'<option value="4">隐形镜片</option>'
	                         +'<option value="4_0">隐形成品片</option>'
      		                 +'<option value="4_D">隐形订做片</option>'
      		                 +'<option value="5_0">隐形护理液</option>'
      		                  +'<option value="2_2">配件</option>'
      	                     +'</select></li>'
      	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" xf1="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'2\',\'6\')">'       
      		                 +'<option value="">----请选择----</option>'
      		                 +'<option value="1">使用类型</option>'
      		                 +'<option value="2">抛弃型分类</option>'
      	                     +'</select></li>'	         
       	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
      		                 +'<option value="1">常带型</option>'
      		                 +'<option value="2">抛弃型</option>'
      		               +'<option value="3">塑形镜</option>'
      	                     +'</select></li>'	
      	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" xf2="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'       
      		                 +'<option value="1">日抛</option>'
      		                 +'<option value="2">周抛</option>'
      		                 +'<option value="9">双周抛</option>'
      		                 +'<option value="3">月抛</option>'
      		                 +'<option value="4">季抛</option>'
      		                 +'<option value="5">半年抛</option>'
      		                 +'<option value="6">年抛</option>'
      		                 +'<option value="7">RGP</option>'      		                 
      	                     +'</select></li>'	      	                          	                          	
        }
        if (ssmsmclassify == '6'){
                c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" xiaofei=xiaofei xf0="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'6\',\'\')">'
      		                 +'<option value="6_6">太阳镜</option>'
      		                 +'<option value="6_8">老花镜</option>'
      		                 +'</select></li>'	
        }
	
        c2.innerHTML =  c2.innerHTML +'<li class="horizontal_onlyRight"><input id="goodsName'+index+'" name="salesGoodsArray.ssmsggoodsname" class="text_input120" type="text" readonly="readonly"></li><li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_0.png\');" style="cursor: hand;"></li>'
                       +'<input id="supplier'+index+'" class="text_input60" name="salesGoodsArray.ssmsgsupplier" type="hidden"><input id="brand'+index+'" class="text_input60" name="salesGoodsArray.ssmsgbrand" type="hidden"><input id="iscustomize'+index+'" name="salesGoodsArray.ssmsgiscustomize" class="text_input60" type="hidden"><input id="goods'+index+'" name="salesGoodsArray.ssmsggoodsid" class="text_input60" type="hidden">'
                       +'<input id="goodscategory2id'+index+'" name="salesGoodsArray.ssmsggoodscategory" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" name="salesGoodsArray.ssmsgbigclass" class="text_input60" type="hidden"><input id="smallClass'+index+'" name="salesGoodsArray.ssmsgsmallclass" class="text_input60" type="hidden">';
            
        c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'"></span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" type="hidden" name="salesGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'"></span><input id="maxCostPriceAmount'+index+'" class="text_input60 noneInput" type="hidden" readonly="readonly" name="salesGoodsArray.ssmsgmaxcostPrice">';
        c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgbeginAmount'+index+'" type="text" name="salesGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]" onblur="validationGoodsCostPriceMin(this,'+index+');" xf6="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgendAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]" onblur="validationGoodsCostPriceMax(this,'+index+');" xf7="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'8\',\'\')">';
		c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="goodsquantity'+index+'" type="text" name="salesGoodsArray.ssmsggoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写销售数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'填写的销售数量不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}getSetMealAmount3(this);" value="1" xf8="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'9\',\'\')">';

		c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgretailPrice'+index+'" type="text" name="salesGoodsArray.ssmsgretailPrice" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的零售价不正确！\'}]" onblur="getSetMealAmount(this)" xf9="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'10\',\'\')">';
		c7.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="specialoffer'+index+'" type="text" name="salesGoodsArray.ssmsgspecialoffer" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'0.00\';}" value="0.00" xf10="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'11\',\'12\')">';

        if ($('#ssmsmform').val() == '2'){
            c8.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensecredit'+index+'" type="text" name="salesGoodsArray.ssmsgexpensecredit" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'0.00\';}" value="0.00" xf11="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'12\',\'\')">';
        }else{
        	c8.innerHTML = '<input class="text_input60" style="width:50" type="hidden" readonly="readonly">';
         }
        c9.innerHTML = '<input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" name="salesGoodsArray.ssmsgsphul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写球镜下限有误,请重新填写！\'}]"  xf12="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'13\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgsphup" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写球镜下限有误,请重新填写！\'}]" xf13="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'14\',\'\')" onblur="checkData(this)">';
        c10.innerHTML = '<input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" name="salesGoodsArray.ssmsgcylul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写柱镜下限有误,请重新填写！\'}]"  xf14="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'15\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgcylup" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写柱镜下限有误,请重新填写！\'}]" xf15="xf'+index+'" onKeyPress="xfEnterDown('+index+',\'0\',\'\')" onblur="checkDataz(this)">';
        
		if (ssmsmclassify == '3'){
		     $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

		     $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylRemoveRead(index);
		}
		if (ssmsmclassify == '4'){
		     $('#goodscategoryID402'+index).hide();
             $('#goodscategoryID403'+index).hide();

		     $('#ligoodscategoryID402'+index).hide();
             $('#ligoodscategoryID403'+index).hide();

             sphOrcylRemoveRead(index);
		}
		if (ssmsmclassify == '1'){
		     $('#goodscategoryID301'+index).hide();
		     $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();             
             $('#goodscategoryID307'+index).hide();

		     $('#ligoodscategoryID301'+index).hide();
		     $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();             
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylAddRead(index);
		}
		
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
	  *  添加一行套餐商品（特价）
	  */	
     function addRow4(){
        if ($('#ssmsmclassify').val() == ''){
            alert("请先选择套餐分类!");
            return;
        }
        var table = document.getElementById('addTablebangding4');
		index = accAdd(index,table.rows.length - 1);
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
						
		row.className = 'row';
		c1.height="26";
		c1.innerHTML = '<input type="checkbox" id="chk4" name="chk4"/>';		
		
		var ssmsmclassify = $('#ssmsmclassify').val();
        if (ssmsmclassify == '1'){
                c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" xiaofei=xiaofei tj0="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'1\',\'6\')">'
        		             + '<option value="1_0">镜架</option>'
      		                 +'<option value="2_1">配件</option>'
      		                 +'<option value="3">镜片</option>'
      		                 +'<option value="3_0">成品片</option>'
      		                 +'<option value="3_D">订做片</option>'
      	                     + '</select></li>'	
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" tj1="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材料分类</option>'
                      		 +'<option value="2">折射率</option>'     
      		                 +'<option value="3">光度分类</option>' 	
      		                 +'<option value="4">镜片功能</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">树脂</option>'
                      		 +'<option value="2">玻璃</option>'     
      		                 +'<option value="3">PC</option>' 			            
      	                     + '</select></li>'	      
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                             +  '<s:iterator value="refractiveSetList">'
                             +  '<option value="${brfname}">${brfname}</option>'
                             +  '</s:iterator>'                      			            
      	                     + '</select></li>'	 
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="0">单光</option>'
                      		 +'<option value="m">多光</option>'     
      		                 +'<option value="j_1">青少年渐进</option>'
                      		 +'<option value="j_2">成人渐进</option>' 
      		                 +'<option value="k">抗疲劳</option>' 	
      		                 +'<option value="q">其他</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">白色片</option>'
                      		 +'<option value="2">变色片</option>'     
      		                 +'<option value="3">偏光片</option>'
      		                 +'<option value="4">变色偏光片</option>' 	
      		                 +'<option value="5">染色片</option>' 	
      		                 +'<option value="6">抗疲劳片</option>'
      		                 +'<option value="7">抗疲劳变色片</option>'
      		                 +'<option value="8">偏光抗疲劳片</option>' 		 			            
      	                     + '</select></li>'
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" tj1="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             + '<option value="1">材质</option>'	            
      	                     + '</select></li>'	        	     
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                       +  '<s:iterator value="frameMateriallist">'
                       +  '<option value="${bfmid}">${bfmname}</option>'
                       +  '</s:iterator>'              
      	                     + '</select></li>'	          	                     
        }
        if (ssmsmclassify == '3'){
                        c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" xiaofei=xiaofei tj0="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'1\',\'6\')">'
 		                     +'<option value="3">镜片</option>'
                             +'<option value="3_0">成品片</option>'
                      		 +'<option value="3_D">订做片</option>'     
      		                 +'<option value="1_0">镜架</option>'
      		                 +'<option value="2_1">配件</option>' 		            
      	                     + '</select></li>'	
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" tj1="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材料分类</option>'
                      		 +'<option value="2">折射率</option>'     
      		                 +'<option value="3">光度分类</option>' 	
      		                 +'<option value="4">镜片功能</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">树脂</option>'
                      		 +'<option value="2">玻璃</option>'     
      		                 +'<option value="3">PC</option>' 			            
      	                     + '</select></li>'	      
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                             +  '<s:iterator value="refractiveSetList">'
                             +  '<option value="${brfname}">${brfname}</option>'
                             +  '</s:iterator>'                      			            
      	                     + '</select></li>'	    
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="0">单光</option>'
                      		 +'<option value="m">多光</option>'     
      		                 +'<option value="j_1">青少年渐进</option>'
                      		 +'<option value="j_2">成人渐进</option>' 
      		                 +'<option value="k">抗疲劳</option>' 	
      		                 +'<option value="q">其他</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">白色片</option>'
                      		 +'<option value="2">变色片</option>'     
      		                 +'<option value="3">偏光片</option>'
      		                 +'<option value="4">变色偏光片</option>' 	
      		                 +'<option value="5">染色片</option>' 	
      		                 +'<option value="6">抗疲劳片</option>'
      		                 +'<option value="7">抗疲劳变色片</option>'
      		                 +'<option value="8">偏光抗疲劳片</option>' 		   			            
      	                     + '</select></li>'
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" tj1="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'2\',\'6\')">'
       		                 +'<option value="">----请选择----</option>'                            
                             + '<option value="1">材质</option>'	            
      	                     + '</select></li>'	        	     
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
                       +  '<s:iterator value="frameMateriallist">'
                       +  '<option value="${bfmid}">${bfmname}</option>'
                       +  '</s:iterator>'  	            
      	                     + '</select></li>'	            	                           	                          	                     
        }
        if (ssmsmclassify == '4'){
                 c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" xiaofei=xiaofei tj0="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'1\',\'6\')">'       
                             +'<option value="4">隐形镜片</option>'
	                         +'<option value="4_0">隐形成品片</option>'
      		                 +'<option value="4_D">隐形订做片</option>'
      		                 +'<option value="5_0">隐形护理液</option>'
      		                 +'<option value="2_2">配件</option>'
      	                     +'</select></li>'
      	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" tj1="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'2\',\'6\')">'       
      		                 +'<option value="">----请选择----</option>'
      		                 +'<option value="1">使用类型</option>'
      		                 +'<option value="2">抛弃型分类</option>'
      	                     +'</select></li>'	         
       	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'       
      		                 +'<option value="1">常带型</option>'
      		                 +'<option value="2">抛弃型</option>'
      		               +'<option value="3">塑形镜</option>'
      	                     +'</select></li>'	
      	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" tj2="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'       
      		                 +'<option value="1">日抛</option>'
      		                 +'<option value="2">周抛</option>'
      		                 +'<option value="9">双周抛</option>'
      		                 +'<option value="3">月抛</option>'
      		                 +'<option value="4">季抛</option>'
      		                 +'<option value="5">半年抛</option>'
      		                 +'<option value="6">年抛</option>'
      		                 +'<option value="7">RGP</option>'      		                 
      	                     +'</select></li>'	      	                          	                          	
        }
        if (ssmsmclassify == '6'){
                c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" xiaofei=xiaofei tj0="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'6\',\'\')">'
      		                 +'<option value="6_6">太阳镜</option>'
      		                 +'<option value="6_8">老花镜</option>'
      		                 +'</select>'	
        }
	
        c2.innerHTML =  c2.innerHTML +'<li class="horizontal_onlyRight"><input id="goodsName'+index+'" name="salesGoodsArray.ssmsggoodsname" class="text_input120" type="text" readonly="readonly"></li><li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_0.png\');" style="cursor: hand;"></li>'
                       +'<input id="supplier'+index+'" class="text_input60" name="salesGoodsArray.ssmsgsupplier" type="hidden"><input id="brand'+index+'" class="text_input60" name="salesGoodsArray.ssmsgbrand" type="hidden"><input id="iscustomize'+index+'" name="salesGoodsArray.ssmsgiscustomize" class="text_input60" type="hidden"><input id="goods'+index+'" name="salesGoodsArray.ssmsggoodsid" class="text_input60" type="hidden">'
                       +'<input id="goodscategory2id'+index+'" name="salesGoodsArray.ssmsggoodscategory" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" name="salesGoodsArray.ssmsgbigclass" class="text_input60" type="hidden"><input id="smallClass'+index+'" name="salesGoodsArray.ssmsgsmallclass" class="text_input60" type="hidden">';
            
        c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'"></span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" type="hidden" name="salesGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'"></span><input id="maxCostPriceAmount'+index+'" class="text_input60" type="hidden" readonly="readonly" name="salesGoodsArray.ssmsgmaxcostPrice">';
        c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgbeginAmount'+index+'" type="text" name="salesGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'\';}validationGoodsCostPriceMin(this,'+index+');" tj6="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" style="width:50" class="text_input60" type="text" name="salesGoodsArray.ssmsgendAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'\';}validationGoodsCostPriceMax(this,'+index+');" tj7="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'8\',\'\')">';
		c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="goodsquantity'+index+'" type="text" name="salesGoodsArray.ssmsggoodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写销售数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'填写的销售数量不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}amoumt();" value="1" tj8="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'9\',\'\')">';

		c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" name="salesGoodsArray.ssmsgsphul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写球镜下限有误,请重新填写！\'}]"  tj9="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'10\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgsphup" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写球镜下限有误,请重新填写！\'}]" tj10="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'11\',\'\')" onblur="checkData(this)">';
		c7.innerHTML = '<input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" name="salesGoodsArray.ssmsgcylul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写柱镜下限有误,请重新填写！\'}]"  tj11="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'12\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" name="salesGoodsArray.ssmsgcylup" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写柱镜下限有误,请重新填写！\'}]" tj12="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'13\',\'\')" onblur="checkDataz(this)">';

		c8.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="specialoffer2'+index+'" type="text" name="salesGoodsArray.ssmsgspecialoffer" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'0.00\';}checkCostPrice(this,'+index+');" value="0.00" tj13="tj'+index+'" onKeyPress="tjEnterDown('+index+',\'0\',\'\')">';
	
		if (ssmsmclassify == '3'){
		     $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

		     $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylRemoveRead(index);
		}
		if (ssmsmclassify == '4'){
		     $('#goodscategoryID402'+index).hide();
             $('#goodscategoryID403'+index).hide();

		     $('#ligoodscategoryID402'+index).hide();
             $('#ligoodscategoryID403'+index).hide();

             sphOrcylRemoveRead(index);
		}
		if (ssmsmclassify == '1'){
		     $('#goodscategoryID301'+index).hide();
		     $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();             
             $('#goodscategoryID307'+index).hide();

		     $('#ligoodscategoryID301'+index).hide();
		     $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();             
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylAddRead(index);
		}
     }
     
     /**
	  *  删除添加一行购买商品
	  */        
	 function del4(){
	    var chk = document.getElementsByName("chk4");
		var table = document.getElementById('addTablebangding4');
		for(i = 0; i < chk.length; i++){
			 if (chk[i].checked) {
				 var curRow = chk[i].parentNode.parentNode;		
				 table.deleteRow(curRow.rowIndex);
				 i = -1;
			 }
		}
		document.all.chks4.checked = false;
		amoumt();
	 } 
	 	 
	 /**
	  *  添加一行赠送商品(赠品)
	  */	
     function addRow2(){
        if ($('#ssmsmclassify').val() == ''){
            alert("请先选择套餐分类!");
            return;
        }     
        var table = document.getElementById('addTablesong');
		index = accAdd(document.getElementById('addTablebangding').rows.length - 1,accAdd(index,table.rows.length - 1));
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
						
		row.className = 'row';
		c1.height="26";
		c1.innerHTML = '<input type="checkbox" id="chk2" name="chk2"/>';
		
		var ssmsmclassify = $('#ssmsmclassify').val();
        if (ssmsmclassify == '1'){
                c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" zp0="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'1\',\'6\')">'
        		             + '<option value="1_0">镜架</option>'
      		                 +'<option value="2_1">配件</option>'
      		                 +'<option value="3">镜片</option>'
      		                 +'<option value="3_0">成品片</option>'
      		                 +'<option value="3_D">订做片</option>'
      	                     + '</select></li>'	
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" zp1="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材料分类</option>'
                      		 +'<option value="2">折射率</option>'     
      		                 +'<option value="3">光度分类</option>' 	
      		                 +'<option value="4">镜片功能</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">树脂</option>'
                      		 +'<option value="2">玻璃</option>'     
      		                 +'<option value="3">PC</option>' 			            
      	                     + '</select></li>'	      
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                             +  '<s:iterator value="refractiveSetList">'
                             +  '<option value="${brfname}">${brfname}</option>'
                             +  '</s:iterator>'                      			            
      	                     + '</select></li>'	    
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="0">单光</option>'
                      		 +'<option value="m">多光</option>'     
      		                 +'<option value="j_1">青少年渐进</option>'
                      		 +'<option value="j_2">成人渐进</option>' 
      		                 +'<option value="k">抗疲劳</option>' 	
      		                 +'<option value="q">其他</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">白色片</option>'
                      		 +'<option value="2">变色片</option>'     
      		                 +'<option value="3">偏光片</option>'
      		                 +'<option value="4">变色偏光片</option>' 	
      		                 +'<option value="5">染色片</option>' 	
      		                 +'<option value="6">抗疲劳片</option>'
      		                 +'<option value="7">抗疲劳变色片</option>' 
      		                 +'<option value="8">偏光抗疲劳片</option>' 		  			            
      	                     + '</select></li>'
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" zp1="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             + '<option value="1">材质</option>'	            
      	                     + '</select></li>'	        	     
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                       +  '<s:iterator value="frameMateriallist">'
                       +  '<option value="${bfmid}">${bfmname}</option>'
                       +  '</s:iterator>'  	            
      	                     + '</select></li>'	          	                     
        }
        if (ssmsmclassify == '3'){
                        c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" zp0="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'1\',\'6\')">'
                             +'<option value="3">镜片</option>'
                             +'<option value="3_0">成品片</option>'
                      		 +'<option value="3_D">订做片</option>'     
      		                 +'<option value="1_0">镜架</option>'
      		                 +'<option value="2_1">配件</option>' 		            
      	                     + '</select></li>'	
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" zp1="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材料分类</option>'
                      		 +'<option value="2">折射率</option>'     
      		                 +'<option value="3">光度分类</option>' 	
      		                 +'<option value="4">镜片功能</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">树脂</option>'
                      		 +'<option value="2">玻璃</option>'     
      		                 +'<option value="3">PC</option>' 			            
      	                     + '</select></li>'	      
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                             +  '<s:iterator value="refractiveSetList">'
                             +  '<option value="${brfname}">${brfname}</option>'
                             +  '</s:iterator>'                      			            
      	                     + '</select></li>'	  
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="0">单光</option>'
                      		 +'<option value="m">多光</option>'     
      		                 +'<option value="j_1">青少年渐进</option>'
                      		 +'<option value="j_2">成人渐进</option>' 
      		                 +'<option value="k">抗疲劳</option>' 	
      		                 +'<option value="q">其他</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">白色片</option>'
                      		 +'<option value="2">变色片</option>'     
      		                 +'<option value="3">偏光片</option>'
      		                 +'<option value="4">变色偏光片</option>' 	
      		                 +'<option value="5">染色片</option>' 	
      		                 +'<option value="6">抗疲劳片</option>'
      		                 +'<option value="7">抗疲劳变色片</option>'
      		                 +'<option value="8">偏光抗疲劳片</option>' 		   			            
      	                     + '</select></li>'
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" zp1="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'2\',\'6\')">'
       		                 +'<option value="">----请选择----</option>'                            
                             + '<option value="1">材质</option>'	            
      	                     + '</select></li>'	        	     
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
                       +  '<s:iterator value="frameMateriallist">'
                       +  '<option value="${bfmid}">${bfmname}</option>'
                       +  '</s:iterator>'              
      	                     + '</select></li>'	            	                           	                          	                     
        }
        if (ssmsmclassify == '4'){
                 c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" zp0="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'1\',\'6\')">'   
                             +'<option value="4">隐形镜片</option>'
      		                 +'<option value="4_0">隐形成品片</option>'
      		                 +'<option value="4_D">隐形订做片</option>'
      		                 +'<option value="5_0">隐形护理液</option>'
      		                  +'<option value="2_2">配件</option>'
      	                     +'</select></li>'
      	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" zp1="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'2\',\'6\')">'       
      		                 +'<option value="">----请选择----</option>'
      		                 +'<option value="1">使用类型</option>'
      		                 +'<option value="2">抛弃型分类</option>'
      	                     +'</select></li>'	         
       	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'       
      		                 +'<option value="1">常带型</option>'
      		                 +'<option value="2">抛弃型</option>'
      		               +'<option value="3">塑形镜</option>'
      	                     +'</select></li>'	
      	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" zp2="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'       
      		                 +'<option value="1">日抛</option>'
      		                 +'<option value="2">周抛</option>'
      		                 +'<option value="9">双周抛</option>'
      		                 +'<option value="3">月抛</option>'
      		                 +'<option value="4">季抛</option>'
      		                 +'<option value="5">半年抛</option>'
      		                 +'<option value="6">年抛</option>'
      		                 +'<option value="7">RGP</option>'      		                 
      	                     +'</select></li>'	      	                          	                          	
        }
        if (ssmsmclassify == '6'){
                c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" zp0="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'6\',\'\')">'
      		                 +'<option value="6_6">太阳镜</option>'
      		                 +'<option value="6_8">老花镜</option>'
      		                 +'</select>'	
        }
		
        c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight"><input id="goodsName'+index+'" name="creditGoodsArray.ssmsggoodsname" class="text_input120" type="text" readonly="readonly"></li><li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_0.png\');" style="cursor: hand;"></li>'
                       +'<input id="supplier'+index+'" class="text_input60" name="creditGoodsArray.ssmsgsupplier" type="hidden" readonly="readonly"><input id="brand'+index+'" class="text_input60" name="creditGoodsArray.ssmsgbrand" type="hidden" readonly="readonly"><input id="iscustomize'+index+'" name="creditGoodsArray.ssmsgiscustomize" class="text_input60" type="hidden" readonly="readonly"><input id="goods'+index+'" name="creditGoodsArray.ssmsggoodsid" class="text_input60" type="hidden" readonly="readonly">'
                       +'<input id="goodscategory2id'+index+'" name="creditGoodsArray.ssmsggoodscategory" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden" readonly="readonly"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden" readonly="readonly"><input id="bigClass'+index+'" name="creditGoodsArray.ssmsgbigclass" class="text_input60" type="hidden" readonly="readonly"><input id="smallClass'+index+'" name="creditGoodsArray.ssmsgsmallclass" class="text_input60" type="hidden" readonly="readonly">';
      
        c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'"></span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" type="hidden" name="creditGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'"></span><input id="maxCostPriceAmount'+index+'" class="text_input60 noneInput" type="hidden" readonly="readonly" name="creditGoodsArray.ssmsgmaxcostPrice">';
        c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgbeginAmount'+index+'" type="text" name="creditGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'\';}validationGoodsCostPriceMin(this,'+index+');" zp6="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" id="ssmsgendAmount'+index+'" style="width:50" class="text_input60" type="text" name="creditGoodsArray.ssmsgendAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'\';}validationGoodsCostPriceMax(this,'+index+');" zp7="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'8\',\'\')">';
		c5.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="goodsquantity'+index+'" name="creditGoodsArray.ssmsggoodsquantity" type="text" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写赠送数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'填写的赠送数量不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number($.trim(this.value) == \'\' ? 1 : this.value).toFixed(0);}else{this.value = \'1\';}amoumt();" value="1" zp8="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'13\',\'\')">'
		c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgretailPrice'+index+'" type="text" name="creditGoodsArray.ssmsgretailPrice" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写赠送单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'填写的赠送单价不正确！\'}]" onblur="getSetMealAmount(this)" zp13="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'9\',\'\')">';

		c7.innerHTML = '<input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" name="creditGoodsArray.ssmsgsphul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写球镜下限有误,请重新填写！\'}]"  zp9="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'10\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" name="creditGoodsArray.ssmsgsphup" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写球镜下限有误,请重新填写！\'}]" zp10="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'11\',\'\')" onblur="checkData(this)">';
		c8.innerHTML = '<input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" name="creditGoodsArray.ssmsgcylul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写柱镜下限有误,请重新填写！\'}]"  zp11="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'12\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" name="creditGoodsArray.ssmsgcylup" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写柱镜下限有误,请重新填写！\'}]" zp12="zp'+index+'" onKeyPress="zpEnterDown('+index+',\'0\',\'\')" onblur="checkDataz(this)">';
		              

		if (ssmsmclassify == '3'){
		     $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

		     $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylRemoveRead(index);
		}
		if (ssmsmclassify == '4'){
		     $('#goodscategoryID402'+index).hide();
             $('#goodscategoryID403'+index).hide();

		     $('#ligoodscategoryID402'+index).hide();
             $('#ligoodscategoryID403'+index).hide();

             sphOrcylRemoveRead(index);
		}
		if (ssmsmclassify == '1'){
		     $('#goodscategoryID301'+index).hide();
		     $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();             
             $('#goodscategoryID307'+index).hide();

		     $('#ligoodscategoryID301'+index).hide();
		     $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();             
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylAddRead(index);
		}
     }
     
     /**
	  *  删除添加一行消费抵扣商品
	  */        
	 function del2(){
	    var chk = document.getElementsByName("chk2");
		var table = document.getElementById('addTablesong');
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
	 
	 /**
	  *  添加一行消费抵扣商品
	  */	
     function addRow3(){
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
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
				
		row.className = 'row';
		c1.height="26";
		c1.innerHTML = '<input type="checkbox" id="chk3" name="chk3"/>';		
		
		var ssmsmclassify = $('#ssmsmclassify').val();
        if (ssmsmclassify == '1'){
                c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" dk0="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'1\',\'6\')">'
        		             + '<option value="1_0">镜架</option>'
      		                 +'<option value="2_1">配件</option>'
      		                 +'<option value="3">镜片</option>'
      		                 +'<option value="3_0">成品片</option>'
      		                 +'<option value="3_D">订做片</option>'
      	                     + '</select></li>'	
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材料分类</option>'
                      		 +'<option value="2">折射率</option>'     
      		                 +'<option value="3">光度分类</option>' 	
      		                 +'<option value="4">镜片功能</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">树脂</option>'
                      		 +'<option value="2">玻璃</option>'     
      		                 +'<option value="3">PC</option>' 			            
      	                     + '</select></li>'	      
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                             +  '<s:iterator value="refractiveSetList">'
                             +  '<option value="${brfname}">${brfname}</option>'
                             +  '</s:iterator>'                      			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="0">单光</option>'
                      		 +'<option value="m">多光</option>'     
      		                 +'<option value="j_1">青少年渐进</option>'
                      		 +'<option value="j_2">成人渐进</option>' 
      		                 +'<option value="k">抗疲劳</option>' 	
      		                 +'<option value="q">其他</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">白色片</option>'
                      		 +'<option value="2">变色片</option>'     
      		                 +'<option value="3">偏光片</option>'
      		                 +'<option value="4">变色偏光片</option>' 	
      		                 +'<option value="5">染色片</option>' 	
      		                 +'<option value="6">抗疲劳片</option>'
      		                 +'<option value="7">抗疲劳变色片</option>'
      		                 +'<option value="8">偏光抗疲劳片</option>' 		   			            
      	                     + '</select></li>'
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             + '<option value="1">材质</option>'	            
      	                     + '</select></li>'	        	     
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                       +  '<s:iterator value="frameMateriallist">'
                       +  '<option value="${bfmid}">${bfmname}</option>'
                       +  '</s:iterator>'             
      	                     + '</select></li>'	          	                     
        }
        if (ssmsmclassify == '3'){
                        c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change3(this,'+index+')" dk0="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'1\',\'6\')">'
                             +'<option value="3">镜片</option>'
                             +'<option value="3_0">成品片</option>'
                      		 +'<option value="3_D">订做片</option>'     
      		                 +'<option value="1_0">镜架</option>'
      		                 +'<option value="2_1">配件</option>' 		            
      	                     + '</select></li>'	
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID301'+index+'"><select clean=clean id="goodscategoryID301'+index+'" name="goodscategoryID301" onchange="change31(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
      		                 +'<option value="">----请选择----</option>'
                             +'<option value="1">材料分类</option>'
                      		 +'<option value="2">折射率</option>'     
      		                 +'<option value="3">光度分类</option>' 	
      		                 +'<option value="4">镜片功能</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID302'+index+'"><select clean=clean id="goodscategoryID302'+index+'" name="goodscategoryID302" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">树脂</option>'
                      		 +'<option value="2">玻璃</option>'     
      		                 +'<option value="3">PC</option>' 			            
      	                     + '</select></li>'	      
                       c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID303'+index+'"><select clean=clean id="goodscategoryID303'+index+'" name="goodscategoryID303" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                             +  '<s:iterator value="refractiveSetList">'
                             +  '<option value="${brfname}">${brfname}</option>'
                             +  '</s:iterator>'                      			            
      	                     + '</select></li>'	 
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID304'+index+'"><select clean=clean id="goodscategoryID304'+index+'" name="goodscategoryID304" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                             +'<option value="0">单光</option>'
                      		 +'<option value="m">多光</option>'     
      		                 +'<option value="j_1">青少年渐进</option>'
                      		 +'<option value="j_2">成人渐进</option>' 
      		                 +'<option value="k">抗疲劳</option>' 	
      		                 +'<option value="q">其他</option>' 			            
      	                     + '</select></li>'	   
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID305'+index+'"><select clean=clean id="goodscategoryID305'+index+'" name="goodscategoryID305" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                             + '<option value="1">白色片</option>'
                      		 +'<option value="2">变色片</option>'     
      		                 +'<option value="3">偏光片</option>'
      		                 +'<option value="4">变色偏光片</option>' 	
      		                 +'<option value="5">染色片</option>' 	
      		                 +'<option value="6">抗疲劳片</option>'
      		                 +'<option value="7">抗疲劳变色片</option>'
      		                 +'<option value="8">偏光抗疲劳片</option>' 		   			            
      	                     + '</select></li>'
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID306'+index+'"><select clean=clean id="goodscategoryID306'+index+'" name="goodscategoryID306" onchange="change32(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'
       		                 +'<option value="">----请选择----</option>'                            
                             + '<option value="1">材质</option>'	            
      	                     + '</select></li>'	        	     
      	               c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID307'+index+'"><select clean=clean id="goodscategoryID307'+index+'" name="goodscategoryID307" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
                       +  '<s:iterator value="frameMateriallist">'
                       +  '<option value="${bfmid}">${bfmname}</option>'
                       +  '</s:iterator>'  	            
      	                     + '</select></li>'	            	                           	                          	                     
        }
        if (ssmsmclassify == '4'){
                 c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" onchange="change4(this,'+index+')" dk0="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'1\',\'6\')">'       
                             +'<option value="4">隐形镜片</option>'
                             +'<option value="4_0">隐形成品片</option>'
      		                 +'<option value="4_D">隐形订做片</option>'
      		                 +'<option value="5_0">隐形护理液</option>'
      		                  +'<option value="2_2">配件</option>'
      	                     +'</select></li>'
      	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID401'+index+'"><select clean=clean id="goodscategoryID401'+index+'" name="goodscategoryID401" onchange="change41(this,'+index+')" dk1="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'2\',\'6\')">'       
      		                 +'<option value="">----请选择----</option>'
      		                 +'<option value="1">使用类型</option>'
      		                 +'<option value="2">抛弃型分类</option>'
      	                     +'</select></li>'	         
       	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID402'+index+'"><select clean=clean id="goodscategoryID402'+index+'" name="goodscategoryID402" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'       
      		                 +'<option value="1">常带型</option>'
      		                 +'<option value="2">抛弃型</option>'
      		               +'<option value="3">塑形镜</option>'
      	                     +'</select></li>'	
      	         c2.innerHTML = c2.innerHTML + '<li class="horizontal_onlyRight" id="ligoodscategoryID403'+index+'"><select clean=clean id="goodscategoryID403'+index+'" name="goodscategoryID403" dk2="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'       
      		                 +'<option value="1">日抛</option>'
      		                 +'<option value="2">周抛</option>'
      		                 +'<option value="9">双周抛</option>'
      		                 +'<option value="3">月抛</option>'
      		                 +'<option value="4">季抛</option>'
      		                 +'<option value="5">半年抛</option>'
      		                 +'<option value="6">年抛</option>'
      		                 +'<option value="7">RGP</option>'      		                 
      	                     +'</select></li>'	      	                          	                          	
        }
        if (ssmsmclassify == '6'){
                c2.innerHTML = '<li class="horizontal_onlyRight"><select clean=clean id="goodscategoryID'+index+'" name="goodscategoryID" dk0="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'6\',\'\')">'
      		                 +'<option value="6_6">太阳镜</option>'
      		                 +'<option value="6_8">老花镜</option>'
      		                 +'</select>'	
        }
	
        c2.innerHTML =  c2.innerHTML +'<li class="horizontal_onlyRight"><input id="goodsName'+index+'" name="creditGoodsArray.ssmsggoodsname" class="text_input120" type="text" readonly="readonly"></li><li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onclick="openGoods('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_0.png\');" style="cursor: hand;"></li>'
                       +'<input id="supplier'+index+'" class="text_input60" name="creditGoodsArray.ssmsgsupplier" type="hidden"><input id="brand'+index+'" class="text_input60" name="creditGoodsArray.ssmsgbrand" type="hidden"><input id="iscustomize'+index+'" name="creditGoodsArray.ssmsgiscustomize" class="text_input60" type="hidden"><input id="goods'+index+'" name="creditGoodsArray.ssmsggoodsid" class="text_input60" type="hidden">'
                       +'<input id="goodscategory2id'+index+'" name="creditGoodsArray.ssmsggoodscategory" class="text_input60" type="hidden"><input id="minCostPrice'+index+'" class="text_input60" type="hidden"><input id="maxCostPrice'+index+'" class="text_input60" type="hidden"><input id="bigClass'+index+'" name="creditGoodsArray.ssmsgbigclass" class="text_input60" type="hidden"><input id="smallClass'+index+'" name="creditGoodsArray.ssmsgsmallclass" class="text_input60" type="hidden">';
            
        c3.innerHTML = '<span id="spanminCostPriceAmount'+index+'"></span><input class="text_input60 noneInput" id="minCostPriceAmount'+index+'" type="hidden" name="creditGoodsArray.ssmsgmincostPrice" readonly="readonly">至<span id="spanmaxCostPriceAmount'+index+'"></span><input id="maxCostPriceAmount'+index+'" class="text_input60 noneInput" type="hidden" readonly="readonly" name="creditGoodsArray.ssmsgmaxcostPrice">';
        c4.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgbeginAmount'+index+'" type="text" name="creditGoodsArray.ssmsgbeginAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'\';}validationGoodsCostPriceMin(this,'+index+');" dk6="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'7\',\'\')">至<input maxlength="15" style="width:50" id="ssmsgendAmount'+index+'" class="text_input60" type="text" name="creditGoodsArray.ssmsgendAmount" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'\';}validationGoodsCostPriceMax(this,'+index+');" dk7="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'8\',\'\')">';
		c5.innerHTML = '1<input class="text_input60" style="width:50" maxlength="15" id="goodsquantity'+index+'" type="hidden" name="creditGoodsArray.ssmsggoodsquantity" value="1">';
		c6.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgretailPrice'+index+'" type="text" name="creditGoodsArray.ssmsgretailPrice" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'填写的零售价不正确！\'}]" onblur="getSetMealAmount(this);" dk8="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'13\',\'\')">';

		c8.innerHTML = '<input class="text_input60" style="width:50" maxlength="20" id="ssmsgsphul'+index+'" type="text" name="creditGoodsArray.ssmsgsphul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写球镜下限有误,请重新填写！\'}]"  dk9="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'10\',\'\')" onblur="checkData(this)">至<input maxlength="20" id="ssmsgsphup'+index+'" class="text_input60" style="width:50" type="text" name="creditGoodsArray.ssmsgsphup" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写球镜下限有误,请重新填写！\'}]" dk10="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'11\',\'\')" onblur="checkData(this)">';
		c9.innerHTML = '<input class="text_input60" style="width:50" maxlength="20" id="ssmsgcylul'+index+'" type="text" name="creditGoodsArray.ssmsgcylul" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写柱镜下限有误,请重新填写！\'}]"  dk11="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'12\',\'\')" onblur="checkDataz(this)">至<input maxlength="20" id="ssmsgcylup'+index+'" class="text_input60" style="width:50" type="text" name="creditGoodsArray.ssmsgcylup" validate="[{\'Type\' : Type.String,\'Formula\' : Formula.SphCylOrNull, \'Message\' : \'填写柱镜下限有误,请重新填写！\'}]" dk12="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'0\',\'\')" onblur="checkDataz(this)">';

		c7.innerHTML = '<input class="text_input60" style="width:50" maxlength="15" id="ssmsgexpensecredit'+index+'" type="text" name="creditGoodsArray.ssmsgexpensecredit" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'填写金额！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'填写的金额不正确！\'}]" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = \'0.00\';}" value="0.00" dk13="dk'+index+'" onKeyPress="dkEnterDown('+index+',\'9\',\'\')">';

		if (ssmsmclassify == '3'){
		     $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

		     $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylRemoveRead(index);
		}
		if (ssmsmclassify == '4'){
		     $('#goodscategoryID402'+index).hide();
             $('#goodscategoryID403'+index).hide();

		     $('#ligoodscategoryID402'+index).hide();
             $('#ligoodscategoryID403'+index).hide();

             sphOrcylRemoveRead(index);
		}
		if (ssmsmclassify == '1'){
		     $('#goodscategoryID301'+index).hide();
		     $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();             
             $('#goodscategoryID307'+index).hide();

		     $('#ligoodscategoryID301'+index).hide();
		     $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();             
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylAddRead(index);
		}
     }
     
     /**
	  *  删除添加一行消费抵扣商品
	  */        
	 function del3(){
	    var chk = document.getElementsByName("chk3");
		var table = document.getElementById('addTablesong2');
		for(i = 0; i < chk.length; i++){
			 if (chk[i].checked) {
				 var curRow = chk[i].parentNode.parentNode;		
				 table.deleteRow(curRow.rowIndex);
				 i = -1;
			 }
		}
		document.all.chks3.checked = false;
		amoumt();
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
	     
    /**
	 * 商品开窗
	 */ 
     function openGoods(value){
        document.getElementById("indexs").value = value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initSetMealGoodsOpenSel.action?goodscategoryID="+$('#goodscategoryID'+value).val()+getUrl(value),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSetMealGoodsOpenSel.action?goodscategoryID="+$('#goodscategoryID'+value).val()+getUrl(value),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
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

	//补零
	function addZero(obj) {
		if (obj.value.indexOf(".") == -1) {
			obj.value += ".00";
		} else if (obj.value.indexOf(".") == obj.value.length - 2) {
			obj.value += "0";
		}
	}
	
    function getUrl(index){
        
        var path = "";        
        switch($('#goodscategoryID'+index).val()){
            case '3_0': 
            case '3_D': 
                if ($('#goodscategoryID304'+index).val() == 'j_1' || $('#goodscategoryID304'+index).val() == 'j_2' ){
                    var goodscategoryID304 = (!$('#goodscategoryID304'+index).is(":hidden") ? $('#goodscategoryID304'+index).val() : ' _ ').split('_');
                    path = "&goodscategoryID301="+(!$('#goodscategoryID301'+index).is(":hidden") ? $('#goodscategoryID301'+index).val() : '')+"&goodscategoryID302="+(!$('#goodscategoryID302'+index).is(":hidden") ? $('#goodscategoryID302'+index).val() : '')+"&goodscategoryID303="+(!$('#goodscategoryID303'+index).is(":hidden") ? $('#goodscategoryID303'+index).val() : '')+"&goodscategoryID30401="+goodscategoryID304[0]+"&goodscategoryID30402="+goodscategoryID304[1]+"&goodscategoryID305="+(!$('#goodscategoryID305'+index).is(":hidden") ? $('#goodscategoryID305'+index).val() : ''); break;
                }else{
                    path = "&goodscategoryID301="+(!$('#goodscategoryID301'+index).is(":hidden") ? $('#goodscategoryID301'+index).val() : '')+"&goodscategoryID302="+(!$('#goodscategoryID302'+index).is(":hidden") ? $('#goodscategoryID302'+index).val() : '')+"&goodscategoryID303="+(!$('#goodscategoryID303'+index).is(":hidden") ? $('#goodscategoryID303'+index).val() : '')+"&goodscategoryID30401="+(!$('#goodscategoryID304'+index).is(":hidden") ? $('#goodscategoryID304'+index).val() : '')+"&goodscategoryID305="+(!$('#goodscategoryID305'+index).is(":hidden") ? $('#goodscategoryID305'+index).val() : ''); break;
                }
            case '4_0': 
            case '4_D': path = "&goodscategoryID401="+(!$('#goodscategoryID401'+index).is(":hidden") ? $('#goodscategoryID401'+index).val() : '')+"&goodscategoryID402="+(!$('#goodscategoryID402'+index).is(":hidden") ? $('#goodscategoryID402'+index).val() : '')+"&goodscategoryID403="+(!$('#goodscategoryID403'+index).is(":hidden") ? $('#goodscategoryID403'+index).val() : ''); break;         
            case '1_0': path = "&goodscategoryID306="+(!$('#goodscategoryID306'+index).is(":hidden") ? $('#goodscategoryID306'+index).val() : '')+"&goodscategoryID307="+(!$('#goodscategoryID307'+index).is(":hidden") ? $('#goodscategoryID307'+index).val() : ''); break;                             
            default:
                path = "";
        }
        path = path + '&retailbeginprice='+$('#ssmsgbeginAmount'+index).val()+ '&retailendprice='+$('#ssmsgendAmount'+index).val() + '&ssmsgsphul='+$('#ssmsgsphul'+index).val()+ '&ssmsgcylul='+$('#ssmsgcylul'+index).val()+ '&ssmsgsphup='+$('#ssmsgsphup'+index).val() + '&ssmsgcylup='+$('#ssmsgcylup'+index).val();
        return path;
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
                  
         document.getElementById("ssmsgbeginAmount"+indexs).value=json.minCostPrice;
         document.getElementById("ssmsgendAmount"+indexs).value=json.maxCostPrice;         

         $('#spanminCostPriceAmount'+indexs).text(json.minCostPriceAmount);
         $('#spanmaxCostPriceAmount'+indexs).text(json.maxCostPriceAmount);
         
         if ($('#ssmsgexpensecredit'+indexs) != null && (Number($('#ssmsgbeginAmount'+indexs).val()) < Number($('#ssmsgexpensecredit'+indexs).val()))){
             $('#ssmsgexpensecredit'+indexs).val(json.minCostPrice);
         }
         if ($('#specialoffer'+indexs) != null && (Number($('#ssmsgendAmount'+indexs).val()) < Number($('#specialoffer'+indexs).val()))){
             $('#specialoffer'+indexs).val(json.maxCostPrice);
         } 
         amoumt();
     }
     
     function changeClassif(){
        if ($('#ssmsmform').val() == '1'){
            $('#show1').show();
    	    $('#show2').show();
    	    $('#show3').hide();
    	    $('#show4').hide();
    	    $('#adjustmentPrice').removeAttr('validate');
	    }
        if ($('#ssmsmform').val() == '2'){
            $('#show1').show();
    	    $('#show2').hide();
    	    $('#show3').show();
    	    $('#show4').hide();
    	    $('#adjustmentPrice').removeAttr('validate');
	    }
        //显示是否允许累加
        $('#isyxlj').show();
	    $('#yxljxx').show();
	    $('#x15').attr('checked',true);
	    
	    if ($('#ssmsmform').val() == '3'){
            $('#show1').hide();
    	    $('#show2').hide();
    	    $('#show3').hide();
    	    $('#show4').show();
    	    $('#adjustmentPrice').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写特价金额！\'}]");

            //隐藏是否允许累加
            $('#isyxlj').hide();
    	    $('#yxljxx').hide();
    	    $('#x16').attr('checked',true);
	    }
	    
    	$('input[name=chk1]').each(function(){
			$(this).parent().parent().remove();		
		});
		$('input[name=chk2]').each(function(){
			$(this).parent().parent().remove();		
		});
		$('input[name=chk3]').each(function(){
			$(this).parent().parent().remove();		
		});
		$('input[name=chk4]').each(function(){
			$(this).parent().parent().remove();		
		});
		
		document.all.chks1.checked = false;
		document.all.chks1.checked = false;
		document.all.chks3.checked = false;
		document.all.chks4.checked = false;
		amoumt();
     }
     
     function changeClassif2(){
        if ($('#ssmsmform').val() == '1'){
		    $('input[name=chk1]').each(function(){
				$(this).parent().parent().remove();		
			});
			$('input[name=chk2]').each(function(){
				$(this).parent().parent().remove();		
			});
			document.all.chks1.checked = false;
			document.all.chks2.checked = false;
	    }
        if ($('#ssmsmform').val() == '2'){
		    $('input[name=chk1]').each(function(){
				$(this).parent().parent().remove();		
			});
			$('input[name=chk3]').each(function(){
				$(this).parent().parent().remove();		
			});
			document.all.chks1.checked = false;
			document.all.chks3.checked = false;
	    }
	    if ($('#ssmsmform').val() == '3'){
		    $('input[name=chk4]').each(function(){
				$(this).parent().parent().remove();		
			});
			document.all.chks1.checked = false;
	    }
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
         if (obj.value == '2_1'){
             $('#goodscategoryID301'+index).val('');
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID306'+index).val('');
             $('#goodscategoryID307'+index).val('');
             
             $('#goodscategoryID301'+index).hide();
             $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

             $('#ligoodscategoryID301'+index).hide();
             $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylAddRead(index);
         }
         if (obj.value == '3' || obj.value == '3_0' || obj.value == '3_D'){
             $('#goodscategoryID301'+index).val('');
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID306'+index).val('');
             $('#goodscategoryID307'+index).val('');
             
             $('#goodscategoryID301'+index).show();
             $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();
             
             $('#ligoodscategoryID301'+index).show();
             $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylRemoveRead(index);
         }
         if (obj.value == '1_0'){
             $('#goodscategoryID301'+index).val('');
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID306'+index).val('');
             $('#goodscategoryID307'+index).val('');
             
             $('#goodscategoryID301'+index).hide();
             $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();             
             $('#goodscategoryID306'+index).show();
             $('#goodscategoryID307'+index).hide();

             $('#ligoodscategoryID301'+index).hide();
             $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();             
             $('#ligoodscategoryID306'+index).show();
             $('#ligoodscategoryID307'+index).hide();

             sphOrcylAddRead(index);
         }
         clearGoods(index);
     }
     
     function change4(obj,index){
         if (obj.value == '2_2' || obj.value == '5_0'){
             $('#goodscategoryID401'+index).val('');
             $('#goodscategoryID402'+index).val('');
             $('#goodscategoryID403'+index).val('');
                      
             $('#goodscategoryID401'+index).hide();
             $('#goodscategoryID402'+index).hide();
             $('#goodscategoryID403'+index).hide();

             $('#ligoodscategoryID401'+index).hide();
             $('#ligoodscategoryID402'+index).hide();
             $('#ligoodscategoryID403'+index).hide();

             sphOrcylAddRead(index);
         }
         if (obj.value == '4' || obj.value == '4_0' || obj.value == '4_D'){
             $('#goodscategoryID401'+index).val('');
             $('#goodscategoryID402'+index).val('');
             $('#goodscategoryID403'+index).val('');  
             
             $('#goodscategoryID401'+index).show();
             $('#goodscategoryID402'+index).hide();
             $('#goodscategoryID403'+index).hide();

             $('#ligoodscategoryID401'+index).show();
             $('#ligoodscategoryID402'+index).hide();
             $('#ligoodscategoryID403'+index).hide();

             sphOrcylRemoveRead(index);
         }
         clearGoods(index);
     }
     
     function change31(obj,index){
         if (obj.value == '1'){
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID306'+index).val('');
             $('#goodscategoryID307'+index).val('');
                     
             $('#goodscategoryID301'+index).show();
             $('#goodscategoryID302'+index).show();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();   

             $('#ligoodscategoryID301'+index).show();
             $('#ligoodscategoryID302'+index).show();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();           

         }
         if (obj.value == '2'){
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID306'+index).val('');
             $('#goodscategoryID307'+index).val('');         
         
             $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).show();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

             $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).show();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();
         }
         if (obj.value == '3'){
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID306'+index).val('');
             $('#goodscategoryID307'+index).val('');
                      
             $('#goodscategoryID301'+index).show();
             $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).show();
             $('#goodscategoryID305'+index).hide();             
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

             $('#ligoodscategoryID301'+index).show();
             $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).show();
             $('#ligoodscategoryID305'+index).hide();             
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();
         }
         if (obj.value == '4'){
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID306'+index).val('');
             $('#goodscategoryID307'+index).val('');
                      
             $('#goodscategoryID301'+index).show();
             $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).show();             
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

             $('#ligoodscategoryID301'+index).show();
             $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).show();             
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();
         } 
         if (obj.value == ''){
             $('#goodscategoryID301'+index).val('');
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID306'+index).val('');
             $('#goodscategoryID307'+index).val('');
                     
             $('#goodscategoryID301'+index).show();
             $('#goodscategoryID302'+index).hide();
             $('#goodscategoryID303'+index).hide();
             $('#goodscategoryID304'+index).hide();
             $('#goodscategoryID305'+index).hide();             
             $('#goodscategoryID306'+index).hide();
             $('#goodscategoryID307'+index).hide();

             $('#ligoodscategoryID301'+index).show();
             $('#ligoodscategoryID302'+index).hide();
             $('#ligoodscategoryID303'+index).hide();
             $('#ligoodscategoryID304'+index).hide();
             $('#ligoodscategoryID305'+index).hide();             
             $('#ligoodscategoryID306'+index).hide();
             $('#ligoodscategoryID307'+index).hide();
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
                     
             $('#goodscategoryID306'+index).show();
             $('#goodscategoryID307'+index).show();

             $('#ligoodscategoryID306'+index).show();
             $('#ligoodscategoryID307'+index).show();
         }
         if (obj.value == ''){
             $('#goodscategoryID301'+index).val('');
             $('#goodscategoryID302'+index).val('');
             $('#goodscategoryID303'+index).val('');
             $('#goodscategoryID304'+index).val('');
             $('#goodscategoryID305'+index).val('');
             $('#goodscategoryID307'+index).val('');
                                
             $('#goodscategoryID306'+index).show();
             $('#goodscategoryID307'+index).hide();

             $('#ligoodscategoryID306'+index).show();
             $('#ligoodscategoryID307'+index).hide();
         }
         clearGoods(index);
     }
     
     function change41(obj,index){
         if (obj.value == '1'){
             $('#goodscategoryID402'+index).val('');
             $('#goodscategoryID403'+index).val('');
                      
             $('#goodscategoryID401'+index).show();
             $('#goodscategoryID402'+index).show();
             $('#goodscategoryID403'+index).hide();

             $('#ligoodscategoryID401'+index).show();
             $('#ligoodscategoryID402'+index).show();
             $('#ligoodscategoryID403'+index).hide();
         }
         if (obj.value == '2'){
             $('#goodscategoryID402'+index).val('');
             $('#goodscategoryID403'+index).val('');
                      
             $('#goodscategoryID401'+index).show();
             $('#goodscategoryID402'+index).hide();
             $('#goodscategoryID403'+index).show();

             $('#ligoodscategoryID401'+index).show();
             $('#ligoodscategoryID402'+index).hide();
             $('#ligoodscategoryID403'+index).show();
         }
         if (obj.value == ''){
             $('#goodscategoryID401'+index).val('');
             $('#goodscategoryID402'+index).val('');
             $('#goodscategoryID403'+index).val('');

             $('#goodscategoryID402'+index).hide();
             $('#goodscategoryID403'+index).hide();

             $('#ligoodscategoryID402'+index).hide();
             $('#ligoodscategoryID403'+index).hide();
         }
         clearGoods(index);
     }    
     
     function clearGoods(index){
		$('#goodsName'+index).val('');
		$('#supplier'+index).val('');
		$('#goodscategory2id'+index).val('');
		$('#brand'+index).val('');	   
		$('#iscustomize'+index).val('');
		$('#goods'+index).val('');
		$('#minCostPrice'+index).val('0.00');
		$('#maxCostPrice'+index).val('0.00');
		$('#bigClass'+index).val('');
		$('#smallClass'+index).val('');
		$('#minCostPriceAmount'+index).val('0.00');
		$('#maxCostPriceAmount'+index).val('0.00');      
		$('#goodsquantity'+index).val('1');                
		$('#specialoffer'+index).val('0.00');      
     }
     
    /*
     *  计算套餐价格区间
     */
     function amoumt(){
         var total = 0;
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
         $('#ssmsmsourcebgnAmount').val(parseFloat(total).toFixed(2));
         
         total = 0;
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
         $('#ssmsmsourceendAmount').val(parseFloat(total).toFixed(2));
         
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

            if (ssmsggoodsquantity1s != null && ssmsgretailPrice1s != null){
       		    for (var i = 0; i < ssmsggoodsquantity1s.length; i++){
                    if ($.trim(ssmsgretailPrice1s[i].value)==''){
                    	$('#ssmsmendbgnAmount').val('');
                    	return;
                    }
           			total = accAdd(total,accMul(ssmsggoodsquantity1s[i].value,ssmsgretailPrice1s[i].value));
                }
            }
            if (ssmsggoodsquantity2s != null && ssmsgretailPrice2s != null){
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
    	if ($('#ssmsmform').val() == '3'){
           return;
        }
    	if (isNaN(obj.value) || $.trim(obj.value) == ''){
    		obj.value = "1";
        }    	
    	var ssmsggoodsquantity1s = document.getElementsByName("salesGoodsArray.ssmsggoodsquantity");
   		var ssmsgretailPrice1s = document.getElementsByName("salesGoodsArray.ssmsgretailPrice");
   		var ssmsggoodsquantity2s = document.getElementsByName("creditGoodsArray.ssmsggoodsquantity");
   		var ssmsgretailPrice2s = document.getElementsByName("creditGoodsArray.ssmsgretailPrice");
        var total = 0;

        if (ssmsggoodsquantity1s != null && ssmsgretailPrice1s != null){
   		    for (var i = 0; i < ssmsggoodsquantity1s.length; i++){
                if ($.trim(ssmsgretailPrice1s[i].value)==''){
                	$('#ssmsmendbgnAmount').val('');
                	return;
                }
       			total = accAdd(total,accMul(ssmsggoodsquantity1s[i].value,ssmsgretailPrice1s[i].value));
            }
        }
        if (ssmsggoodsquantity2s != null && ssmsgretailPrice2s != null){
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

   function validateSalesForm(){
	   var count = 0;
       if ("undefined" != typeof $('input[name=setMealPo.ssmsmsalesflag]:checked') && $('input[name=setMealPo.ssmsmsalesflag]:checked').val() == '2'){           
    	   var ssmsggoodsids = document.getElementsByName("salesGoodsArray.ssmsggoodsid");
    	   if (ssmsggoodsids != null){
        	   count = ssmsggoodsids.length;
               var ssmsggoodsid = ssmsggoodsids[0].value;
               for (var i = 1; i < ssmsggoodsids.length; i++){
            	   if (ssmsggoodsid != ssmsggoodsids[i].value){
                       return true;
                   }
               }
           }
    	   var goodscategorys = document.getElementsByName("goodscategoryID");
    	   if (goodscategorys != null){
               var goodscategoryID = goodscategorys[0];
               for (var i = 1; i < count; i++){
            	   if (goodscategoryID.value != goodscategorys[i].value){
                       return true;
                   }
               }
           }
       }
       if ("undefined" != typeof $('input[name=setMealPo.ssmsmcreditflag]:checked') && $('input[name=setMealPo.ssmsmcreditflag]:checked').val() == '2'){
           count = 0;
           
    	   var ssmsggoodsids = document.getElementsByName("creditGoodsArray.ssmsggoodsid");
    	   if (ssmsggoodsids != null && ssmsggoodsids.length != 0){
        	   count = ssmsggoodsids.length;
        	   var ssmsggoodsid = ssmsggoodsids[0].value;
               for (var i = 1; i < ssmsggoodsids.length; i++){
            	   if (ssmsggoodsid != ssmsggoodsids[i].value){
                       return true;
                   }
               }
           }
    	   var goodscategoryIDs = document.getElementsByName("goodscategoryID");
    	   if (goodscategoryIDs != null){
               var goodscategoryID = goodscategoryIDs[goodscategoryIDs.length-count];
               for (var i = goodscategoryIDs.length-count; i < goodscategoryIDs.length; i++){
            	   if (goodscategoryID.value != goodscategoryIDs[i].value){
                       return true;
                   }
               }
           }
       }
       return false;
   }

   //验证同类型商品不能同时消费和抵扣
   function validateSalesGoods(){
	   var goodscategoryIDs = document.getElementsByName("goodscategoryID");
       var count = $('select[xiaofei=xiaofei]').size(); 

       for (var i = 0; i < count; i++){
           for (var j = count; j < goodscategoryIDs.length; j++){
               if (goodscategoryIDs[i].value == goodscategoryIDs[j].value){
            	   return true; 
               }
               if ((goodscategoryIDs[i].value.substring(0,1)) == (goodscategoryIDs[j].value)){
            	   return true; 
               }
               if ((goodscategoryIDs[i].value.substring(0,1)) == (goodscategoryIDs[j].value.substring(0,1))){
                   if (goodscategoryIDs[i].value.substring(0,1) != 6){
                	   return true;
                   }
               }                     
           }
       }
       
       return false;
   }

   //数据准确性
   function validateData(){
	   //套餐区间下限小于上限
	   var beginAmount = document.getElementsByName("salesGoodsArray.ssmsgbeginAmount");
	   var endAmount = document.getElementsByName("salesGoodsArray.ssmsgendAmount");
	   var beginAmount2 = document.getElementsByName("creditGoodsArray.ssmsgbeginAmount");
	   var endAmount2 = document.getElementsByName("creditGoodsArray.ssmsgendAmount");

	   for (var i = 0; i < beginAmount.length; i++){
           if (Number(beginAmount[i].value) > Number(endAmount[i].value)){
               alert("套餐价格区间金额有误,请重新填写!");
               beginAmount[i].focus();
               return true;
           }
	   }
	   for (var i = 0; i < beginAmount2.length; i++){
           if (Number(beginAmount2[i].value) > Number(endAmount2[i].value)){
               alert("套餐价格区间金额有误,请重新填写!");
               beginAmount2[i].focus();
               return true;
           }
	   }
       
	   //消费满不能超过套餐区间上限
	   if ($('#ssmsmform').val() == '3'){
	       return false;
	   }else{
		   var so = document.getElementsByName("salesGoodsArray.ssmsgspecialoffer");
		   for (var i = 0; i < endAmount.length; i++){
	           if (Number(so[i].value) > Number(endAmount[i].value)){
	               alert("消费满金额过大,请重新填写!");
	               so[i].focus();
	               return true;
	           }
		   }
	   }
	   //消费抵扣不能超过套餐区间下限
	   if ($('#ssmsmform').val() == '2'){
		   var ec = document.getElementsByName("salesGoodsArray.ssmsgexpensecredit");
		   for (var i = 0; i < endAmount.length; i++){
	           if (Number(ec[i].value) > Number(beginAmount[i].value)){
	               alert("消费抵扣金额过大,请重新填写!");
	               ec[i].focus();
	               return true;
	           }
		   }
	   }

	   //球镜上限大于球镜下限
	   var sul1 = document.getElementsByName("salesGoodsArray.ssmsgsphul");
	   var sup1 = document.getElementsByName("salesGoodsArray.ssmsgsphup");
	   var sul2 = document.getElementsByName("creditGoodsArray.ssmsgsphul");
	   var sup2 = document.getElementsByName("creditGoodsArray.ssmsgsphup");

       for (var i = 0; i < sul1.length; i++){
           if (sul1[i].value != null && sup1[i].value!= null && $.trim(sul1[i].value) != '' && $.trim(sup1[i].value) != '' ){
               if (Number(sul1[i].value) < Number(sup1[i].value)){
                   alert("球镜上限值应大于球镜下限值!");
                   sul1[i].focus();
                   return true;
               }
           }
       }
       for (var i = 0; i < sul2.length; i++){
           if (sul2[i].value != null && sup2[i].value!= null && $.trim(sul2[i].value) != '' && $.trim(sup2[i].value) != '' ){
               if (Number(sul2[i].value) < Number(sup2[i].value)){
                   alert("球镜上限值应大于球镜下限值!");
                   sul2[i].focus();
                   return true;
               }
           }
       }
       
	   //柱镜上限大于柱镜下限
	   var cul1 = document.getElementsByName("salesGoodsArray.ssmsgcylul");
	   var cup1 = document.getElementsByName("salesGoodsArray.ssmsgcylup");
	   var cul2 = document.getElementsByName("creditGoodsArray.ssmsgcylul");
	   var cup2 = document.getElementsByName("creditGoodsArray.ssmsgcylup");

       for (var i = 0; i < cul1.length; i++){
           if (cul1[i].value != null && cup1[i].value!= null && $.trim(cul1[i].value) != '' && $.trim(cup1[i].value) != '' ){
               if (Number(cul1[i].value) < Number(cup1[i].value)){
                   alert("柱镜上限值应大于柱镜下限值!");
                   cul1[i].focus();
                   return true;
               }
           }
       }
       for (var i = 0; i < cul2.length; i++){
           if (cul2[i].value != null && cup2[i].value!= null && $.trim(cul2[i].value) != '' && $.trim(cup2[i].value) != '' ){
               if (Number(cul2[i].value) < Number(cup2[i].value)){
                   alert("柱镜上限值应大于柱镜下限值!");
                   cul2[i].focus();
                   return true;
               }
           }
       }
       
       return false;
   }

   // 消费商品回车
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

   // 赠品回车
   function zpEnterDown(index,id,id2){
	   if(event.keyCode == 13){
           var flag = false;
	       $(':[zp'+id+'=zp'+index+']').each(function(){
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
		       $(':[zp'+id2+'=zp'+index+']').each(function(){
			       if (!$(this).is(":hidden")){
	                   $(this).focus();
	                   return false;
				   }
			   });
		   }

	   }
   }

   // 抵扣商品回车
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

   // 特价商品回车
   function tjEnterDown(index,id,id2){
	   if(event.keyCode == 13){
           var flag = false;
	       $(':[tj'+id+'=tj'+index+']').each(function(){
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
		       $(':[tj'+id2+'=tj'+index+']').each(function(){
			       if (!$(this).is(":hidden")){
	                   $(this).focus();
	                   return false;
				   }
			   });
		   }

	   }
   }

   function sphOrcylAddRead(index){
       $('#ssmsgsphul'+index).val('');
       $('#ssmsgcylul'+index).val('');
       $('#ssmsgsphup'+index).val('');
       $('#ssmsgcylup'+index).val('');
       
       $('#ssmsgsphul'+index).attr('readonly','readonly');
       $('#ssmsgcylul'+index).attr('readonly','readonly');
       $('#ssmsgsphup'+index).attr('readonly','readonly');
       $('#ssmsgcylup'+index).attr('readonly','readonly');
   }	

   function sphOrcylRemoveRead(index){
       $('#ssmsgsphul'+index).removeAttr('readonly');
       $('#ssmsgcylul'+index).removeAttr('readonly');
       $('#ssmsgsphup'+index).removeAttr('readonly');
       $('#ssmsgcylup'+index).removeAttr('readonly');
   }
   
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="setMealFrm" name="setMealFrm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="indexs" name="indexs">

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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
							<TD width="9%" height="26" class="table_body">套餐标题</TD>
			            	<TD width="24%" class="table_none">
			            	<input clean="clean" class="text_input200" id="ssmsmtitle" name="setMealPo.ssmsmtitle" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请先填写套餐标题！'}]">
			            	&nbsp;<span class="STYLE1">*</span></TD>
			            	<TD width="9%" height="26" class="table_body">套餐日期</TD>
			            	<TD width="24%" class="table_none">
			            	  ${createDate }<input type="hidden" class="text_input200" id="createdate" name="setMealPo.ssmsmcreatedate" value="${createDate}" maxlength="20" readonly="readonly">
			                </TD>
			              <TD width="9%" height="26" class="table_body">套餐形式</TD>
			              <TD width="24%" class="table_none">
			                <select clean="clean" id="ssmsmform" name="setMealPo.ssmsmform" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取套餐形式！'}]" onchange="changeClassif()">
							    <option value="">----请选择----</option>
	                            <option value="1">商品满送</option>
	                            <option value="2">商品满减</option>
	                            <option value="3">商品特价</option>
                      	    </select>&nbsp;<span class="STYLE1">*</span>
			              </TD>
			             
			            </TR>
			            <TR>
			              <TD height="26" class="table_body">生效日期</TD>
			              <TD class="table_none">
			              <input id="ssmsmcreatedate" clean="clean" 
					       name="setMealPo.ssmsmeffectivedate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssmsmenddate\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择套餐生效日期！'}]" 
					       value="${createDate }"/>&nbsp;<span class="STYLE1">*</span>
			              </TD>
           				  <TD height="26" class="table_body">截止日期</TD>
                        	<TD height="26" class="table_none" >
                        	<input id="ssmsmenddate" clean="clean"
					       name="setMealPo.ssmsmenddate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssmsmcreatedate\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择套餐截止日期！'}]" 
					       />&nbsp;<span class="STYLE1">*</span>
                        	</TD>
                        	<TD height="26" class="table_body">套餐分类</TD>
                        	<TD height="26" class="table_none" >
                        	<select clean="clean" id="ssmsmclassify" name="setMealPo.ssmsmclassify" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择套餐分类！'}]" onchange="changeClassif2()">
							    <option value="">----请选择----</option>
	                            <option value="1">镜架</option>
	                            <option value="3">镜片</option>
	                            <option value="4">隐形类</option>
	                            <option value="6">成镜类</option>
                      	    </select>&nbsp;<span class="STYLE1">*</span>
                      	  
                      	  </TD>
			            </TR>
			            <TR>
			              <TD height="26" class="table_body">套餐价格区间</TD>
			              <TD class="table_none">
                             <input type="text" readonly="readonly" class="text_input100 noneInput" id="ssmsmsourcebgnAmount" name="setMealPo.ssmsmsourcebgnAmount" value="${setMealPo.ssmsmsourcebgnAmount }"> &nbsp;至 &nbsp;<input type="text" readonly="readonly" class="text_input100 noneInput" id="ssmsmsourceendAmount" name="setMealPo.ssmsmsourceendAmount" value="${setMealPo.ssmsmsourceendAmount }">
			              </TD>
           				  <TD height="26" class="table_body">套餐金额</TD>
                          <TD height="26" class="table_none">
                        	 <input type="text" readonly="readonly" class="text_input100 noneInput" id="ssmsmendbgnAmount" name="setMealPo.ssmsmendbgnAmount" value="${setMealPo.ssmsmendbgnAmount}"> &nbsp;
                          </TD> 
                          <TD height="26" class="table_body"><span id="isyxlj">是否允许累加</span>&nbsp;</TD>
							<TD class="table_none">
							  <span id="yxljxx">
							  <input id="x15" name='setMealPo.ssmsmissum' type="radio" ${(setMealPo.ssmsmissum eq '1' || setMealPo.ssmsmissum == null) ? 'checked="checked"' : '' } value="1" >允许
	                          <input id="x16" name='setMealPo.ssmsmissum' type="radio" ${setMealPo.ssmsmissum eq '2' ? 'checked="checked"' : '' } value="2" >不允许
	                          &nbsp;<span class="STYLE1">*</span>
	                          </span>&nbsp;
                             </TD>                       	
			            </TR>	
			            <TR>                             
                            <TD height="26" class="table_body">活动门店<br>
                            <input type="checkbox" id="chks" name="chks" onclick="chkAll()">全选
                            </TD>
                        	<TD height="26" class="table_none" colspan="5">
								<table align="left" >								   
								   <c:if test="${rowCount == ''}">
								        <c:set value="8" var="rowCount" />       <!-- 行数 -->
								   </c:if>
								   <c:if test="${rowCount != ''}">
								        <c:set value="${rowCount}" var="rowCount" />       <!-- 行数 -->
								   </c:if>
								            
					              <c:set value="6" var="columnCount" />    <!-- 列数 -->
					              <c:set value="0" var="currentIndex" />   <!-- 索引变化量 -->
					                     
					              <c:forEach begin="1" end="${rowCount}" step="1" >
					              <c:set value="1" var="currentCount" />   <!-- 当前行数 -->
					              
					                <tr>               
					                  <c:forEach items="${departmentList}" var="departmentInfo" varStatus="status">
					                    <c:if test="${status.index >= currentIndex && currentCount <= columnCount }" >
						                 <td width="180" height="26" >
						                   <input type="checkbox" id=chk name='bdpdepartmentid' value="${ departmentInfo.bdpdepartmentid}">${ departmentInfo.bdpdepartmentname }
						                 </td>
					                    <c:set value="${currentCount + 1}" var="currentCount" />
					                    </c:if>
					                  </c:forEach>					                  
					                  <c:set value="${currentIndex + 6}" var="currentIndex" />					                  
					                </tr>
								  </c:forEach>
								 </table>
						  <!--		 
								 <table align="left" > 
								   <tr><td colspan="6">&nbsp;<span class="STYLE1">*</span></tr>
								 </table>	
						  -->		 	            	
                      	    </TD>
			            </TR>
			        <!--   
			            <TR>
			            	<TD height="26" class="table_body">是否允许折上折</TD>
                            <td class="table_none"> 
	                          <input id="x13" name='setMealPo.ssmsmisdiscount' type="radio" ${(setMealPo.ssmsmisdiscount eq '1' || setMealPo.ssmsmisdiscount == null) ? 'checked="checked"' : '' } value="1" >允许
	                          <input id="x14" name='setMealPo.ssmsmisdiscount' type="radio" ${setMealPo.ssmsmisdiscount eq '2' ? 'checked="checked"' : '' } value="2" >不允许
	                          &nbsp;<span class="STYLE1">*</span>
                           </td>                           
			            	<TD height="26" class="table_body">是否允许累加</TD>
							<TD class="table_none" colspan="3">
							  <input id="x15" name='setMealPo.ssmsmissum' type="radio" ${(setMealPo.ssmsmissum eq '1' || setMealPo.ssmsmissum == null) ? 'checked="checked"' : '' } value="1" >允许
	                          <input id="x16" name='setMealPo.ssmsmissum' type="radio" ${setMealPo.ssmsmissum eq '2' ? 'checked="checked"' : '' } value="2" >不允许
	                          &nbsp;<span class="STYLE1">*</span>
                             </TD>
			              </TR>
			        -->       
			              <TR>
			            	<TD height="62" class="table_body">备注</TD>
							<TD class="table_none" colspan="5">
							    <textarea clean="clean" id="ssmsmremark" name="setMealPo.ssmsmremark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [1001]}, 'Message' : '备注不能大于1000字！'}]"></textarea>
                             </TD>
			              </TR>
                    </TABLE>
                    
                <div id="shangpinmansong">    
      				<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE> 
                  
					<fieldset id="show1">
					<legend style="font-size:18px">购买商品</legend>
					<TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR valign="middle">
                        <td align="left" width="18%">
                          <img src="${ctx }/img/newbtn/btn_tjgmsp_0.png" btn=btn title="添加购买商品" onclick="addRow()">
                          <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onclick="del();" >
						</TD>
                        <td align="left" width="80%"> 
                          <input id="x1" name='setMealPo.ssmsmsalesflag' type="radio" ${setMealPo.ssmsmsalesflag eq '1' ? 'checked="checked"' : '' } value="1">任选其一
                          <input id="x2" name='setMealPo.ssmsmsalesflag' type="radio" ${setMealPo.ssmsmsalesflag eq '2' ? 'checked="checked"' : '' } value="2">符合全部
                        </td>
                      </TR>
                    </TABLE>
                    
					<TABLE id="addTablebangding" width="100%"  border=0 cellspacing=1>
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="4%" height="26" scope=col align="left">全选<input type="checkbox" id="chks1" name="chks1" onclick="chkAll1()"></TH>
                          <TH width="34%" scope=col>商品信息</TH>
                          <TH width="11%" scope=col>商品原价区间</TH>
                          <TH width="8%" scope=col>套餐价格区间</TH>
                          <TH width="5%" scope=col>销售数量</TH>
                          <TH width="5%" scope=col>活动单价</TH>
						  <TH width="4%" scope=col>消费满</TH>
						  <TH width="5%" scope=col>消费抵扣</TH>
						  <TH width="8%" scope=col>球镜区间(上\下)</TH>
						  <TH width="8%" scope=col>柱镜区间(上\下)</TH>
                         </TR>
					  </TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center>
                      <TBODY>
                        <TR>
                          <TD></TD>
                        </TR>
                      </TBODY>
                      </table>
					</fieldset>
					<br>				
 			
					<fieldset id="show2">
					<legend style="font-size:18px">赠送商品</legend>					
					<TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR valign="middle">
                        <td align="left" width="18%">
                          <img src="${ctx }/img/newbtn/btn_xfdk_0.png" btn=btn title="添加消费抵扣商品" onclick="addRow2()">
                          <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onclick="del2()">
						</TD>
                        <td align="left" width="80%"> 
                          <input id="x3" name='setMealPo.ssmsmcreditflag' type="radio" ${setMealPo.ssmsmcreditflag eq '1' ? 'checked="checked"' : '' } value="1" >任选其一
                          <input id="x4" name='setMealPo.ssmsmcreditflag' type="radio" ${setMealPo.ssmsmcreditflag eq '2' ? 'checked="checked"' : '' } value="2" >符合全部
                        </td>
                      </TR>
                    </TABLE>
					<TABLE id="addTablesong" width="100%"  border=0 align=center cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title>
						  <TH width="4%" height="26" scope=col align="left">全选<input type="checkbox" id="chks2" name="chks2" onclick="chkAll2()"></TH>
                          <TH width="34%" scope=col>商品信息</TH>
                          <TH width="13%" scope=col>商品原价区间</TH>
                          <TH width="8%" scope=col>套餐价格区间</TH>
                          <TH width="5%" scope=col>赠送数量</TH>
                          <TH width="5%" scope=col>赠送单价</TH>
						  <TH width="8%" scope=col>球镜区间(上\下)</TH>
						  <TH width="8%" scope=col>柱镜区间(上\下)</TH>                          
                         </TR>
					  </TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center>
                      <TBODY>
                        <TR>
                          <TD></TD>
                        </TR>
                      </TBODY>
                      </table>
					</fieldset>
 
					<fieldset id="show3">
					<legend style="font-size:18px">消费抵扣</legend>				
					<TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR valign="middle">
                        <td align="left" width="18%">
                          <img src="${ctx }/img/newbtn/btn_xfdk_0.png" btn=btn title="添加消费抵扣商品" onclick="addRow3()">
                          <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onclick="del3();" >
						</TD>
                        <td align="left" width="80%"> 
                          <input id="x5" name='setMealPo.ssmsmcreditflag' type="radio" ${setMealPo.ssmsmcreditflag eq '1' ? 'checked="checked"' : '' } value="1">任选其一
                          <input id="x6" name='setMealPo.ssmsmcreditflag' type="radio" ${setMealPo.ssmsmcreditflag eq '2' ? 'checked="checked"' : '' } value="2">符合全部
                        </td>
                      </TR>
                    </TABLE>
                    
					<TABLE id="addTablesong2" width="100%"  border=0 align=center cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="4%" height="26" scope=col>全选<input type="checkbox" id="chks3" name="chks3" onclick="chkAll3()"></TH>					  
                          <TH width="34%" scope=col>商品信息</TH>
                          <TH width="13%" scope=col>商品原价区间</TH>
                          <TH width="8%" scope=col>套餐价格区间</TH>
                          <TH width="5%" scope=col>销售数量</TH>
                          <TH width="5%" scope=col>活动单价</TH>
						  <TH width="5%" scope=col>消费抵扣</TH>
						  <TH width="10%" scope=col>球镜区间(上\下)</TH>
						  <TH width="10%" scope=col>柱镜区间(上\下)</TH>  
                         </TR>
					  </TBODY>
                    </TABLE>
					</fieldset>					

					<fieldset id="show4">
					<legend style="font-size:18px">特价商品</legend>	
					
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR><td align="left" width="18%">
                          <img src="${ctx }/img/newbtn/btn_tjtjsp_0.png" btn=btn title="添加特价商品" onclick="addRow4()">
                          <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onclick="del4();" >
                          <img src="${ctx }/img/newbtn/btn_jsjg_0.png" btn=btn title='计算价格' onclick="computeAmount()">
						</TD>
                      </TR>
                    </TABLE>
					<TABLE id="addTablebangding4" width="100%"  border=0 align=center cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="4%" height="26" scope=col>全选<input type="checkbox" id="chks4" name="chks4" onclick="chkAll4()"></TH>
                          <TH width="34%" scope=col>商品信息</TH>
                          <TH width="13%" scope=col>商品原价区间</TH>
                          <TH width="8%" scope=col>套餐价格区间</TH>
                          <TH width="5%" scope=col>购买数量</TH>
                          <TH width="8%" scope=col>球镜区间(上\下)</TH>
						  <TH width="8%" scope=col>柱镜区间(上\下)</TH> 
						  <TH width="5%" scope=col>特价价格</TH>
                         </TR>
				 
						 <TR class=table_title align=middle>
						  <TH height="26" colspan="7">现价合计：</TH>
                          <TH>
						  <input class="text_input60" id="adjustmentPrice" style="width: 50" name="adjustmentPrice" type="text" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = '0.00';}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写特价金额！'}]">
						  </TH>
                         </TR>
						 
					
					  </TBODY>
                    </TABLE>
					</fieldset>				

                   </DIV>
					
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
						 	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							  
                          </TD>
                        </TR>
                      </TBODY>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
  

