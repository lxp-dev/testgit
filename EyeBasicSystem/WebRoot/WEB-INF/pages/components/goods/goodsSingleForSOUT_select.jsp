<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
</head>
<script>
	function ismendretail(){
		var isshow = $("#select_retail").val();
		if(isshow == '1'){
			$("#div_retail").show();
		}else{
			$("#div_retail").hide();
			$("#bgiretailbeginprice").val("");
			$("#bgiretailendprice").val("");
		}
	}
	
	function search(){
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();

		if(startTime == ''){
			alert("请选择开始日期！");
			return;
		}

		if(endTime == ''){
			alert("请选择截止日期！");
			return;
		}
		
		$("img").removeAttr("onclick");
		goodsForm.action = "selGoodsInfoForSOUT.action";
		goodsForm.submit();
		showLoadingBar();
	}

	function searchcategory(){
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();

		if(startTime == ''){
			alert("请选择开始日期！");
			return;
		}

		if(endTime == ''){
			alert("请选择截止日期！");
			return;
		}
		
		$("img").removeAttr("onclick");
		goodsForm.action = "initGoodsSingleForSOUTCategory.action?&whichretail=1&select_retail=1"+"&indptid=" + $('#indptid').val();
		goodsForm.submit();
	}
	
	function clean(){
		clean1();
	    <c:if test="${empty(supplierID_open) }">
	    $("#supplierID").val('');
	    $("#supplierName").val('');
	    </c:if>
	    <c:if test="${empty(categoryID_open) }">
	    document.all.goodscategoryID.value="";
	    </c:if>
	    category1();
	}	

	function clean1(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });		
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
		
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
		var goodscategoryID= document.all.goodscategoryID.value;
	    var supplierID=document.getElementById('supplierID').value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
			
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
	/**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext="";
        $("input[id=chk]",window.parent.document).each(function(){
			chktext=chktext+","+$(this).val();
		});

        $("input[id=chk]").each(function(){
	        if(chktext.indexOf($(this).attr("goodsid"))>=0){
	            $(this).attr("checked","checked");
	        }

	        //条码匹配 
	        if(chktext.indexOf($(this).attr("goodsid").replace(".","").replace(".","").replace(".","").replace(".",""))>=0){
	            $(this).attr("checked","checked");
	        }
		});
    }
	/**
	 *  调用单个页面赋值添加
	 */
    function setSingleValue(obj){

        if ('${categoryID_open}' != ''){
        	if (validateGoodscategory(obj)){
                return;
            }
        }
        
        var objValue="["+obj.value+"]";
        if(obj.checked==true){
           if(window.parent.$("#bgiwhichretail").val()){
        	    var goodInfos = eval('(' + objValue + ')');
				if(window.parent.$("#bgiwhichretail").val() != goodInfos[0].bgiwhichretail){
					alert("请选择同一种零售价格商品！");
					obj.checked = false;
					return;
				}
           }
           window.parent.openGoodSingleValues(objValue);
        }else if(obj.checked==false){
           window.parent.openGoodSingleDeleteValues(objValue);
        }
    }

    function validateGoodscategory(obj){
        
    	if(('${goodscategoryID}'=='3' || '${goodscategoryID}'=='4')||('${categoryID_open}'=='3' || '${categoryID_open}'=='4')){
            if($("#goodsCategorys").val()==''||$("#supplierID").val()==''){
            	alert("镜片和隐形镜片商品，请选择商品类别、制造商进行查询后，便可对相应商品进行添加！");
    			$(obj).attr("checked","");
    			return true;
            }
        }

        if(('${goodscategoryID}'!='3' && '${goodscategoryID}'!='4')||('${categoryID_open}'!='3' && '${categoryID_open}'!='4')){
        	if($("#goodscategoryID").val()==''||$("#supplierID").val()==''){
				alert("非镜片和隐形镜片商品，请选择商品类别、制造商进行查询后，便可对相应商品进行添加！");
				$(obj).attr("checked","");
			    return true;
        	}
        }

        if(('${goodscategoryID}'=='3' || '${goodscategoryID}'=='4')||('${categoryID_open}'=='3' || '${categoryID_open}'=='4')){
            if((window.parent.$("#cstpgoodscategory").val()!=''&&'${goodscategoryID}' != '' && '${goodscategoryID}' != window.parent.$("#cstpgoodscategory").val())||(window.parent.$("#cstpgoodscategory").val()!=''&&'${categoryID_open}' != '' && '${categoryID_open}' != window.parent.$("#cstpgoodscategory").val())){
				alert("请选择相同商品类别的商品！");
				$(obj).attr("checked","");
				return true;
            }

            if((window.parent.$("#cstpsupplierid").val()!=''&&'${supplierID}' != '' && '${supplierID}' != window.parent.$("#cstpsupplierid").val())||(window.parent.$("#cstpsupplierid").val()!=''&&'${supplierID_open}' != '' && '${supplierID_open}' != window.parent.$("#cstpsupplierid").val())){
				alert("请选择相同制造商的商品！");
				$(obj).attr("checked","");
				return true;
            }
        }

        if(('${goodscategoryID}'!='3' && '${goodscategoryID}'!='4')||('${categoryID_open}'!='3' && '${categoryID_open}'!='4')){
        	if((window.parent.$("#cstpgoodscategory").val()!=''&&'${goodscategoryID}' != '' && '${goodscategoryID}' != window.parent.$("#cstpgoodscategory").val())||(window.parent.$("#cstpgoodscategory").val()!=''&&'${categoryID_open}' != '' && '${categoryID_open}' != window.parent.$("#cstpgoodscategory").val())){
				alert("请选择相同商品类别的商品！");
				$(obj).attr("checked","");
				return true;
            }

            if((window.parent.$("#cstpsupplierid").val()!=''&&'${supplierID}' != '' && '${supplierID}' != window.parent.$("#cstpsupplierid").val())||(window.parent.$("#cstpsupplierid").val()!=''&&'${supplierID_open}' != '' && '${supplierID_open}' != window.parent.$("#cstpsupplierid").val())){
				alert("请选择相同制造商的商品！");
				$(obj).attr("checked","");
				return true;
            }
        }

        return false;
        
    }

    
	/**
	 *  调用页面赋值删除
	 */
	function setDelValue(){ 	         
        var objValue="";
        var count=0;

        $("input[id=chk]").each(function(){
         	if($(this).attr("checked")==false){
           	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;  
	         }  
		});
        
         if(count==0){
          alert('请选择商品!');
          return false;
        }
        objValue="["+objValue+"]";
        window.parent.openGoodSingleDeleteValues(objValue);
        
	}		
	/**
	 *  调用页面赋值
	 */
	function setValue(){ 	         
        var objValue="";
        var count=0;
        $("input[id=chk]").each(function(){
         	if($(this).attr("checked")==true){
           	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;    
		     }
		});
        if(count==0){
        	alert('请选择商品!');
        	return false;
        }
        objValue="["+objValue+"]";

        if(window.parent.$("#bgiwhichretail").val()){
    	    var goodInfos = eval('(' + objValue + ')');
        }
        
        window.parent.openGoodSingleValues(objValue);
	}
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
		if(('${goodsCategorys}'=='3' || '${goodsCategorys}'=='4')||('${categoryID_open}'=='3' || '${categoryID_open}'=='4')){
            if($("#goodsCategorys").val()==''||$("#supplierID").val()==''){
            	alert("镜片和隐形镜片商品，请选择商品类别、制造商进行查询后，便可对相应商品进行添加！");
    			$("#chks").attr("checked","");
    			return;
            }
        }

        if(('${goodsCategorys}'!='3' && '${goodsCategorys}'!='4')||('${categoryID_open}'!='3' && '${categoryID_open}'!='4')){
        	if($("#goodsCategorys").val()==''||$("#supplierID").val()==''){
				alert("非镜片和隐形镜片商品，请选择商品类别、制造商进行查询后，便可对相应商品进行添加！");
				$("#chks").attr("checked","");
				return;
        	}
        }

        if(('${goodscategoryID}'=='3' || '${goodscategoryID}'=='4')||('${categoryID_open}'=='3' || '${categoryID_open}'=='4')){
            if((window.parent.$("#cstpgoodscategory").val()!=''&&'${goodscategoryID}' != '' && '${goodscategoryID}' != window.parent.$("#cstpgoodscategory").val())||(window.parent.$("#cstpgoodscategory").val()!=''&&'${categoryID_open}' != '' && '${categoryID_open}' != window.parent.$("#cstpgoodscategory").val())){
				alert("请选择相同商品类别的商品！");
				$("#chks").attr("checked","");
				return;
            }

            if((window.parent.$("#cstpsupplierid").val()!=''&&'${supplierID}' != '' && '${supplierID}' != window.parent.$("#cstpsupplierid").val())||(window.parent.$("#cstpsupplierid").val()!=''&&'${supplierID_open}' != '' && '${supplierID_open}' != window.parent.$("#cstpsupplierid").val())){
				alert("请选择相同制造商的商品！");
				$("#chks").attr("checked","");
				return;
            }
        }

        if(('${goodscategoryID}'!='3' && '${goodscategoryID}'!='4')||('${categoryID_open}'!='3' && '${categoryID_open}'!='4')){
        	if((window.parent.$("#cstpgoodscategory").val()!=''&&'${goodscategoryID}' != '' && '${goodscategoryID}' != window.parent.$("#cstpgoodscategory").val())||(window.parent.$("#cstpgoodscategory").val()!=''&&'${categoryID_open}' != '' && '${categoryID_open}' != window.parent.$("#cstpgoodscategory").val())){
				alert("请选择相同商品类别的商品！");
				$("#chks").attr("checked","");
				return;
            }

            if((window.parent.$("#cstpsupplierid").val()!=''&&'${supplierID}' != '' && '${supplierID}' != window.parent.$("#cstpsupplierid").val())||(window.parent.$("#cstpsupplierid").val()!=''&&'${supplierID_open}' != '' && '${supplierID_open}' != window.parent.$("#cstpsupplierid").val())){
				alert("请选择相同制造商的商品！");
				$("#chks").attr("checked","");
				return;
            }
        }
		
        var chks=document.all.chks;
        if(window.parent.$("#bgiwhichretail").val()){
	        if(window.parent.$("#bgiwhichretail").val() != '${whichretail}'){
				alert("请选择同一种零售价格商品！");
				$('input[id=chks]').attr("checked","");
				return;
			}
        }
		
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
        if(chks.checked){
          setValue();
        }else{
          setDelValue();
        }
        
    }
	function selectContact(obj){
		var act = document.activeElement.id;
		
		if(act == "pageNos"&&event.keyCode==13){
			document.getElementById(act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
	}
	$(document).ready(function (){
		var isshow = '${select_retail }';
		if(isshow == '1'){
			$("#div_retail").show();
		}else{
			$("#div_retail").hide();
			$("#bgiretailbeginprice").val("");
			$("#bgiretailendprice").val("");
		}
		
		setCheckValue();
		var category = '${categoryID_open}';
		if(category=="")
		{
			var category = document.getElementById('categoryID').value;
		}
		if(category == ''){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		
		if(category == '1' ){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '2' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").show();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '3' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").show();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '4' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").show();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '5' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").show();
		}
		if(category == '6' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").show();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '7' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '8' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").show();
			$("tr[id=yxhly]").hide();
		}
		if(category == '9' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
	});

	function category1()
	{
		var category = document.getElementById('goodscategoryID').value;
		if(category == ''){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		
		if(category == '1' ){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '2' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").show();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '3' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").show();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '4' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").show();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '5' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").show();
		}
		if(category == '6' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").show();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '7' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '8' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").show();
			$("tr[id=yxhly]").hide();
		}
		if(category == '9' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
	}

	function category()
	{
		clean1();
		var category = document.getElementById('goodscategoryID').value;
		if(category == ''){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		
		if(category == '1' ){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '2' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").show();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '3' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").show();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '4' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").show();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '5' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").show();
		}
		if(category == '6' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").show();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '7' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '8' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").show();
			$("tr[id=yxhly]").hide();
		}
		if(category == '9' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
	}

	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		var startTime = '${startTime}';
		var endTime = '${endTime}';
		var goodscategoryID = '${goodscategoryID}';
		var supplierID = '${supplierID}';
		var brandID = '${brandID}';

		if('${categoryID_open}' != ''){
			goodscategoryID='${categoryID_open}';
		}
		if('${supplierID_open}' != ''){
			supplierID='${supplierID_open}';
		}
		if('${brandID_open}' != ''){
			brandID='${brandID_open}';
		}
		var departmentID=$("#departmentID").val();
   		$('#supplierID').load("initGoodsSingleForSOUTSupplier.action?startTime="+ startTime+"&endTime="+endTime+"&goodscategoryID="+goodscategoryID+"&supplierID="+supplierID+"&brandID="+brandID+"&departmentID="+departmentID);
   		$('#brandID').load("initGoodsSingleForSOUTBrand.action?startTime="+ startTime+"&endTime="+endTime+"&goodscategoryID="+goodscategoryID+"&supplierID="+supplierID+"&brandID="+brandID+"&departmentID="+departmentID);
   	});
	
	function showSubMenu(id,obj){  
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		var goodscategoryID = $("#goodscategoryID").val();
		var supplierID = $("#supplierID").val();
		var brandID = $("#brandID").val();
		var departmentID=$("#departmentID").val();
		
    	if(obj==""){
    		$('#' + id).load("initGoodsSingleForSOUTSupplier.action?startTime="+ startTime+"&endTime="+endTime+"&goodscategoryID="+goodscategoryID+"&supplierID="+supplierID+"&brandID="+brandID+"&departmentID="+departmentID);
    	}else{
    		$('#' + id).load("initGoodsSingleForSOUTBrand.action?startTime="+ startTime+"&endTime="+endTime+"&goodscategoryID="+goodscategoryID+"&supplierID="+supplierID+"&brandID="+brandID+"&departmentID="+departmentID);
    	}
    }

    function selectBrand(){
    	var supplierID = $("#supplierID").val();
		var brandID = $("#brandID").val();
    	if(supplierID == ''){
			alert("请选择制造商！");
			$("#brandID").val('');
			return;
        } 
    }

    /**
	 * 部门开窗
	 */
	function openDepartment(){
		var companyid = '';
		if ('${person.personcompanytype}' == '2'){
			companyid = '${person.personcompanyid}';
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0&companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="app" value="${app}">
<input type="hidden" id='categoryID_open' name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" id='categoryID' name="categoryID" value="${goodscategoryID}" />
<input type="hidden" id='supplierID_open' name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" id='brandID_open' name="brandID_open" value="${brandID_open }" />
<input type="hidden" id='isShowBarcode' name="isShowBarcode" value="${isShowBarcode }" />
<input type="hidden" id='outstockid' name="outstockid" value="${outstockid }" />
<input type="hidden" id="isrefresh" value="1" />
<input type="hidden" id='indptid' name="indptid" value="${indptid }" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	<br/></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
		  </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	   <TD height="26" width="9%" class="table_body">销售日期</TD>
			               <TD class="table_none" width="23%">
                           <li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" />
					        </li>
			                </TD>
			                <TD width="9%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="23%">
				               <li class="horizontal_onlyRight">
							   		<input id="bdpdepartmentname" name="bdpdepartmentname" type="hidden" value="${bdpdepartmentname }"/>
							   		<textarea class="text_input160" id="ds"  name="ds" style='height:50px;width: 200px' readonly="readonly" value="">${bdpdepartmentname }</textarea>							   		
							   		<input type="hidden" id="departmentID" name="departmentID" value="${departmentID }"/>
							   </li>
							   <li class="horizontal_onlyRight">						  		
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
							   </li>
			               </TD>
			               <TD height="26" class="table_body" colspan="2">
					        <img src="${ctx }/img/newbtn/btn_loadterm_0.png" btn=btn title='加载查询条件' onclick="searchcategory();"/>
			               </TD>
			            </tr>
			            <c:if test="${not empty(goodsCategorys)}">
                        <TR>
                         <TD width="9%" height="26" class="table_body">商品类别</TD>
			               <TD width="20%" class="table_none">
			               
                            <select id="goodscategoryID" name="goodscategoryID" onchange="showSubMenu('supplierID','');" ${not empty(categoryID_open) ? 'disabled="disabled"' : '' }>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" <c:if test="${not empty goodscategoryID}"> ${goodscategoryID == bgcid ? 'selected="selected"' : '' }</c:if><c:if test="${empty goodscategoryID}">${categoryID_open == bgcid ? 'selected="selected"' : '' }</c:if>>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                    </select>
			               </TD>
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
					  				<select id="supplierID" name="supplierID" onchange="showSubMenu('brandID','1');" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }>
		      		                 <option value="">----请选择制造商----</option>
		      	                    </select>
						   	</TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
						   		<select id="brandID" name="brandID" onchange="selectBrand();" ${not empty(brandID_open) ? 'disabled="disabled"' : 'clean=clean' }>
		      		                 <option value="">----请选择品种----</option>
		      	                </select>
			              </TD>
                        </TR>
                        
		                <tr>	
		                   <TD width="8%" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input160" clean=clean type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}" onkeyup="selectContact(this)">
			               </TD>	
		                   <c:if test="${departmenttype == '1'}">     
						   <TD height="26" class="table_body">零售价</TD>
			               <TD class="table_none">
			               <input class="text_input100" type="text" clean=clean id="bgiretailbeginprice" name="bgiretailbeginprice" value="${requestScope.bgiretailbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"> ~ <input class="text_input100" type="text" clean=clean id="bgiretailendprice" name="bgiretailendprice" value="${requestScope.bgiretailendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"></TD>
                           <input id="whichretail" name="whichretail" type="hidden" value="${whichretail}">
                           </TD>
                           </c:if>
                           <c:if test="${departmenttype != '1'}">     
						   <TD  height="26" class="table_body"><select id="whichretail" name="whichretail">
	                            <c:if test="${systemParameterPo.fspretailprice=='1' }">
									<option value="1" ${whichretail == '1' ? 'selected':'' }>标准零售价格</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricea=='1' }">
									<option value="2" ${whichretail == '2' ? 'selected':'' }>零售价格2</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceb=='1' }">
									<option value="3" ${whichretail == '3' ? 'selected':'' }>零售价格3</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricec=='1' }">
									<option value="4" ${whichretail == '4' ? 'selected':'' }>零售价格4</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriced=='1' }">
									<option value="5" ${whichretail == '5' ? 'selected':'' }>零售价格5</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricee=='1' }">
									<option value="6" ${whichretail == '6' ? 'selected':'' }>零售价格6</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricef=='1' }">
									<option value="7" ${whichretail == '7' ? 'selected':'' }>零售价格7</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceg=='1' }">
									<option value="8" ${whichretail == '8' ? 'selected':'' }>零售价格8</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceh=='1' }">
									<option value="9" ${whichretail == '9' ? 'selected':'' }>零售价格9</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricei=='1' }">
									<option value="10" ${whichretail == '10' ? 'selected':'' }>零售价格10</option>
								</c:if>
	                      	  </select></TD>
			               <TD  class="table_none">
			               <select id="select_retail" name="select_retail" onclick="ismendretail()">
			               	<option value="1" ${select_retail == '1' ? 'selected':'' }>已设置零售价</option>
			               	<option value="0" ${select_retail == '0' ? 'selected':'' }>未设置零售价</option>
			               </select>
			               <div id="div_retail"><input class="text_input100" type="text" clean=clean id="bgiretailbeginprice" name="bgiretailbeginprice" value="${requestScope.bgiretailbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"> ~ <input class="text_input100" type="text" clean=clean id="bgiretailendprice" name="bgiretailendprice" value="${requestScope.bgiretailendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"></div>
			               </TD>
                           </c:if>
                           <TD width="9%" height="26" class="table_body">型号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" clean=clean type="text" id="bgispecs" name="bgispecs" value="${requestScope.bgispecs}">
			               </TD>
                        </TR>
                        </c:if>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(goodsCategorys)}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					</c:if>
					<c:if test="${empty(goodsCategorys) && not empty(startTime)}">
                    <table id="title2" cellspacing="2" width="30%">
						<tr height="10">
							<td align="right">
								<br/>
								<font color="red" style="border-bottom: thick">当前时间段内没有销售信息！</font>
							</td>
						</tr>
					</table>
					</c:if>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(goodsList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
					<!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <c:choose>
                          	<c:when test="${goodscategoryID == '1' }">
                          	<TH scope=col width="15%">商品代码</TH>
	                          <TH scope=col width="20%">商品名称</TH>
	                          <TH scope=col width="10%">型号</TH>
	                          <TH scope=col width="6%">单位</TH>
	                          <TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  	   </TH>
	                           <TH scope=col width="10%">厂家色号 </TH>
	                           <TH scope=col width="10%">镜架材质 </TH>
	                           <TH scope=col width="10%">镜架尺寸</TH> 
						  	   <th width="10%">销售数量</th>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '2' }">
                          		<TH scope=col width="15%">商品代码</TH>
	                         	<TH scope=col width="18%">商品名称</TH>
	                         	<TH scope=col width="10%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  		</TH>
	                           	<TH scope=col width="15%">配件型 </TH>
						  		<th width="10%">销售数量</th>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '3'}">
                          		<TH scope=col width="15%">商品代码</TH>
	                          	<TH scope=col width="18%">商品名称</TH>
	                          	<TH scope=col width="3%">单位</TH>
	                          	<TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  </TH>
	                          	<TH scope=col width="6%">球镜</TH>
	                           	<TH scope=col width="6%">柱镜 </TH>
	                           	<TH scope=col width="6%">下加光 </TH>
	                           	<TH scope=col width="6%">折射率</TH> 
	                           	<TH scope=col width="6%">光度分类 </TH>
	                           	<TH scope=col width="6%">材料分类</TH> 
	                           	<TH scope=col width="5%">渐进片分类</TH> 
                          		<TH scope=col width="5%">镜片功能</TH> 
						  		<th width="10%">销售数量</th>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '4'}">
                          		<TH scope=col width="15%">商品代码</TH>
	                          	<TH scope=col width="18%">商品名称</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
	                          	
	                          	<TH scope=col width="6%">球镜</TH>
	                           	<TH scope=col width="6%">柱镜 </TH>
	                           	<TH scope=col width="6%">曲率 </TH>
	                           	<TH scope=col width="6%">直径</TH> 
	                           	<TH scope=col width="6%">使用类型 </TH>
	                           	<TH scope=col width="6%">抛弃型分类</TH> 
						  		<th width="10%">销售数量</th>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '5' }">
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="10%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  </TH>
	                           	<TH scope=col width="15%">主容量 </TH>
	                           	<TH scope=col width="15%">次容量 </TH>
						  		<th width="10%">销售数量</th>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '6' }">
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="10%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  </TH>
                          		
	                           	<TH scope=col width="15%">厂家色号 </TH>
	                           	<TH scope=col width="15%">镜架尺寸 </TH>
						  		<th width="10%">销售数量</th>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '8' }">
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="15%">型号 </TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  </TH>
	                          
                          		<TH scope=col width="10%">老花镜度数</TH>
	                           	
	                           	<TH scope=col width="10%">镜架尺寸 </TH>  
	                           	<TH scope=col width="10%">厂家色号 </TH>  
						        <th width="10%">销售数量</th>                      		
                          	</c:when>
                          	<c:when test="${goodscategoryID == '9' }">
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="20%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  	</TH>
						  	<th width="10%">销售数量</th>
                          		
                          	</c:when>
                          	<c:otherwise>
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="10%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  </TH>
						  <th width="10%">销售数量</th>
                          	</c:otherwise>
						 </c:choose>                                                                                   
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                          <input type="checkbox" onClick="setSingleValue(this);" id="chk" goodsid="${bgigoodsid}"
                           value="{'bgigoodsid':'${bgigoodsid}','bgigoodsbarcode':'${bgigoodsbarcode}','bgigoodsname':'${bgigoodsname}','bgiunitname':'${bgiunitname}','bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}',
                           'bginottaxrate':'${bginottaxrate}','bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}','bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}','bgibrandname':'${bgibrandname}',
                           'bgipcbarcode':'${bgipcbarcode }','bgisuppliername':'${bgisuppliername }','bgisupplierid':'${bgisupplierid }','bgibrandid':'${bgibrandid }',
                           'bgiframematerialtype':'${bgiframematerialtype }','bgiframesize':'${bgiframesize}','bgiaccessoriestype':'${bgiaccessoriestype}','goodsquantity':'${bgigoodsquantity }',
                           'bgibelowplusluminosity':'${bgibelowplusluminosity }','bgirefractive':'${bgirefractive}','bgiismutiluminosity':'${bgiismutiluminosity}',
                           'bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgiusetype':'${bgiusetype}','bgistealthclass':'${bgistealthclass}','bgigoodscategoryid':'${bgigoodscategoryid }',
                           'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry }','bgisuppliercolor':'${bgisuppliercolor}','bgiframematerialtypename':'${bgiframematerialtypename}',
                           'bgisource':'${bgisource }','bgiwholesaleprice':'${bgiwholesaleprice }','bgiwhichretail':'${bgiwhichretail }','cshaaemaxquantity':'${((fn:substring(bgigoodsid,0,1) eq '4' || fn:substring(bgigoodsid,0,1) eq '5') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2')) ? '' : (bgistockquantity + bgiintransitgoodsnum) }','requirequantity':'${bgigoodsquantity }','isShowBarcode':'${isShowBarcode }'}">
                          </TD>
                           <c:choose>
                          	<c:when test="${goodscategoryID == '1' }">
	                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                         	 <TD >${bgispec}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
	                           <TD scope=col >${bgisuppliercolor} </TD>
	                           <TD scope=col >${bgiframematerialtypename}</TD>
	                           <TD scope=col >${bgiframesize}</TD> 
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '2' }">
                          	 	<TD>${bgigoodsid}</TD>
	                         	<TD>${bgigoodsname}</TD>
	                         	<TD scope=col >${bgispec} </TD>
	                          	<TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiaccessoriestype=='1'}">框镜</c:if>
		                          	<c:if test="${bgiaccessoriestype=='2'}">隐形</c:if>
	                           </TD>
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '3'}">
                          		 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	 <TD>${bgiretailprice}</TD>
                          		 <TD scope=col >
                          		<c:choose>
                          			<c:when test="${not empty bgisph}">${bgisph}</c:when>
		                          	<c:otherwise>${bgisphul} <c:if test="${not empty bgisphul}">/</c:if>${bgisphup }</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicyl}">${bgicyl}</c:when>
		                          	<c:otherwise>${bgicylul} <c:if test="${not empty bgisphul}">/</c:if>${bgicylup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgibelowplusluminosity}">${bgibelowplusluminosity}</c:when>
		                          	<c:otherwise>${bgibelowplusluminosityul} <c:if test="${not empty bgibelowplusluminosityul}">/</c:if>${bgibelowplusluminosityup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >${bgirefractive} </TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiismutiluminosity=='M'}"> 多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}"> 单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}"> 其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}"> 抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}"> 渐近</c:if>
	                           </TD>
	                           <TD scope=col>
		                          	<c:if test="${bgieyeglassmaterialtype=='1'}"> 树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}"> 玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}"> PC</c:if>		                          	
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgigradualclass=='1'}">青少年渐进</c:if>
		                          	<c:if test="${bgigradualclass=='2'}"> 成人渐进</c:if>	                          	
	                           </TD>
	                           
	                           <TD scope=col >
		                          	<c:if test="${bgifunctionclass=='1'}">白色片</c:if>
		                          	<c:if test="${bgifunctionclass=='2'}">变色片</c:if>	 
		                          	<c:if test="${bgifunctionclass=='3'}">偏光片</c:if>
		                          	<c:if test="${bgifunctionclass=='4'}"> 变色偏光片</c:if>	
		                          	<c:if test="${bgifunctionclass=='5'}">染色片</c:if>
		                          	<c:if test="${bgifunctionclass=='6'}"> 抗疲劳片</c:if>
		                          	<c:if test="${bgifunctionclass=='7'}"> 抗疲劳变色片</c:if>
		                          	<c:if test="${bgifunctionclass=='8'}"> 偏光抗疲劳片</c:if>	                         	
	                           </TD>
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '4'}">
                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
                          		<TD scope=col >
                          		<c:choose>
                          			<c:when test="${not empty bgisph}">${bgisph}</c:when>
		                          	<c:otherwise>${bgisphul} <c:if test="${not empty bgisphul}">/</c:if>${bgisphup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicyl}">${bgicyl}</c:when>
		                          	<c:otherwise>${bgicylul} <c:if test="${not empty bgisphul}">/</c:if>${bgicylup}</c:otherwise>
	                          	</c:choose> 
	                          	</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicurvature1}">${bgicurvature1}</c:when>
		                          	<c:otherwise>${bgicurvature1ul} <c:if test="${not empty bgicurvature1ul}">/</c:if>${bgicurvature1up}</c:otherwise>
	                          	</c:choose> 
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgidia}">${bgidia}</c:when>
		                          	<c:otherwise>${bgidiaul} <c:if test="${not empty bgidiaul}">/</c:if>${bgidiaup}</c:otherwise>
	                          	</c:choose> 
                          		</TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${bgiusetype=='2'}">抛弃型</c:if>
		                          	<c:if test="${bgiusetype=='3'}">塑形镜</c:if>		  		                          	
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${bgistealthclass=='7'}"> RGP</c:if>
		                          	<c:if test="${bgistealthclass=='8'}"> 塑形镜</c:if>	                         	
	                           </TD>
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          
                          	<c:when test="${goodscategoryID == '5' }">
                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
                          		<TD scope=col >${bgicapacity} </TD>
                          		<TD scope=col >${bgicapacityentry} </TD>
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '6' }">
                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
                          		<TD scope=col >${bgisuppliercolor} </TD>
                          		<TD scope=col >${bgiframesize} </TD>
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '8' }">
                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
                          		<TD scope=col >${bgisph} </TD>
                          		<TD scope=col >${bgiframesize} </TD>
                          		<TD scope=col >${bgisuppliercolor} </TD>
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '9' }">
                          	 	<TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '7' }">
                          	 	<TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                         	 	<TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
                           		<td>${bgigoodsquantity }</td>
                          	</c:when>
                          	  <c:otherwise>
                         		 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgigoodsname}</TD>
	                         	 <TD scope=col >${bgispec}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgiretailprice}</TD>
                           		<td>${bgigoodsquantity }</td>
                          </c:otherwise>
						 </c:choose>
                          </TR>
						</s:iterator>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
