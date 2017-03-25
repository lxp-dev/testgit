<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script type='text/javascript' src='${ctx }/js/module/autoLoadSupplier.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<title>发票管理</title>
</head>
<script>
    var isAuto = 1;
    function updateAuto(obj){
       isAuto = obj;
        if(obj==0){
       $(':input').removeAttr("readonly");
       $(':input').removeAttr("style");}
       if(obj==1){
        $('input[name=invoiceEntryPo.lieienottaxrateamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});
		$('input[name=invoiceEntryPo.lieietaxamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});	
		$('input[name=invoiceEntryPo.lieiecostpriceamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});

       }
    }
    	
	function deleteItem(){
	    if($('.row').size()==0){
			alert('请选择要删除的单据!');
			return;
		}
		$('input[name=chk]:checked').each(function(){
			$(this).parent().parent().remove();		
		});
		document.all.chks.checked = false;
		amount();
	}
	
	function deleteItems(){
		$('input[name=chk]').each(function(){
			$(this).parent().parent().remove();		
		});
		document.all.chks.checked = false;
		amount();
	}
	
	function amount(){
		for(var i=1;i<=2;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=accAdd(total,$(this).find("input").val());
				}else{
					total=accAdd(total,$(this).text());
				}
			});
			$('#td'+i+'t').text(total);
		}
		for(i=3;i<=5;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=parseFloat(accAdd(total,$(this).find("input").val())).toFixed(2);
				}else{
					total=parseFloat(accAdd(total,$(this).text())).toFixed(2);
				}
			});
			$('#td'+i+'t').text(parseFloat(total).toFixed(2));
		}
	}

	/**
	 * 输入核销数量
	 */
	function shuliangCal(obj){		
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		var chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		var weihexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiegoodsquantity]').attr("value");	
		if(parseFloat(hexiaoshuliang)>parseFloat(weihexiaoshuliang) || parseFloat(hexiaoshuliang)<=0 || hexiaoshuliang == '' || hexiaoshuliang == null){
			alert('核销数量输入有误!');
			$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').val(weihexiaoshuliang);
			$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').focus();
			return;
		}
				
		if (isAuto == 0){
		    return;
		}
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));
			
		//反填含税单价
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));	
		if($(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').attr("value")=="NaN")
		{
			$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val()="0.000000";
		}
		if($(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value")=="NaN")
		{
			$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val()="0.00";
		}
		amount();
			
	}
		
	/**
	 * 输入成本合计
	 */
	function chengbenCal(obj){
		var hanshuidanjia=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value");
		var chengbenheji = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		var hexiaoshuliang = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		if (chengbenheji == '' || chengbenheji == null){
		    alert("成本合计数据有误!");
		    obj.focus();
		    var danweichengben = $(obj).parent().parent().find('span[id=lieienottaxrate]').text();//attr("value")
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accMul(danweichengben,hexiaoshuliang)).toFixed(2));
		    return;	
		}		
		var cstietaxrate = $(obj).parent().parent().find('input[name=cstietaxrate]').attr("value");	
		if(cstietaxrate=="NaN")
		{
		  cstietaxrate=0.17;
		}	
		
		if (isAuto == 0){
		    return;
		}
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));
		
		//反填税额合计
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,eval(cstietaxrate*0.01))).toFixed(2));
		//反填价税合计
		var shuieheji = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val();			
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accAdd(chengbenheji,shuieheji)).toFixed(2));
			
		//反填含税单价
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		
		amount();
	}
			
	/**
	 * 输入税额合计
	 */
	function shuieCal(obj){		
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		var cstietaxrate=$(obj).parent().parent().find('input[name=cstietaxrate]').attr("value");
		if(cstietaxrate=="NaN")
		{
		  cstietaxrate=0.17;
		}	
		var chengbenheji = "0";
		var shuieheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').attr("value");
		if(shuieheji == '' || shuieheji == null){
		    alert("税额合计数据有误!");
		    obj.focus();
		    chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");		    
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,cstietaxrate*0.01)).toFixed(2));
		    return;
		}		
		
		if (isAuto == 0){
		    return;
		}
		
		//反填成本合计	
		chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accDiv(shuieheji,parseFloat(cstietaxrate*0.01))).toFixed(2));	
	
		//反填单位成本		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));		
						
		//反填价税合计					
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accAdd(chengbenheji,shuieheji)).toFixed(2));
		//alert(parseFloat(accAdd(chengbenheji,shuieheji)).toFixed(2));
			
		//反填含税单价
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		amount();
	}
				
	/**
	 * 输入单位成本
	 */
	function danweiCal(obj){	
		//var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		var hanshuidanjia=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value");
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		var cstietaxrate=$(obj).parent().parent().find('input[name=cstietaxrate]').attr("value");	
		var danweichengben=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').attr("value");
		//var hanshuidanjia=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value");
		if(cstietaxrate=="NaN")
		{
		  cstietaxrate=0.17;
		}	
		if(danweichengben == '' || danweichengben == null){
		    alert("单位成本数据有误!");
		    obj.focus();
		    //var danweichengben = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').attr("value");	    
		    //$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accMul(hexiaoshuliang,hanshuidanjia)).toFixed(2));
		    return;
		}	
		
		if (isAuto == 0){
		    return;
		}
		
		//反填成本合计		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accMul(danweichengben,hexiaoshuliang)).toFixed(2));		
		 var chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		
		//反填含税单价		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accMul(danweichengben,1+parseFloat(cstietaxrate*0.01))).toFixed(2));			
		
		//价税合计
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accMul(hanshuidanjia,hexiaoshuliang).toFixed(2)));
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value"); 

	    //反填税额合计
		//$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,parseFloat(cstietaxrate*0.01))).toFixed(2));
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accSub(jiashuiheji,chengbenheji)).toFixed(2));
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));	
		amount();
	}
					
	/**
	 * 输入含税单价
	 */
	function hanshuiCal(obj){		
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");	
		var hanshuidanjia=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value");
		var cstietaxrate=$(obj).parent().parent().find('input[name=cstietaxrate]').attr("value");
	    var danweichengben=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').attr("value");
	    if(hanshuidanjia == '' || hanshuidanjia == null){
		    alert("含税单价数据有误!");
		    obj.focus();		
		    jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");    
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		    return;
		}	
	    	
	    if (isAuto == 0){
		    return;
		}
		
		//反填价税合计
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accMul(hexiaoshuliang,hanshuidanjia)).toFixed(2));
		//alert(parseFloat(accMul(hexiaoshuliang,hanshuidanjia)).toFixed(2));
		jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value"); 
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(hanshuidanjia,1+parseFloat(cstietaxrate*0.01))).toFixed(6));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(hanshuidanjia,1+parseFloat(cstietaxrate*0.01))).toFixed(6));	
		
		//反填成本合计		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accMul(danweichengben,hexiaoshuliang)).toFixed(2));	
			
	    //反填税额合计
	    var chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accSub(jiashuiheji,chengbenheji)).toFixed(2));
		
		amount();	
	}
	
	function save(){
		if($('.row').size()==0){
			alert('请选择单据!');
			return;
		}
		if($('#invoiceStartDate').val()==''){
			alert('请核销日期!');
			return;
		}
		
		$("img").removeAttr("onclick");
	    var auditState = document.getElementsByName("auditState");
	    if (auditState != null  && auditState.length != 0 ){
		    if (!auditState[0].checked){
	            invoiceForm.action = "ykinvoiceInsert.action?auditState=0";
	        }else{
	            invoiceForm.action = "ykinvoiceInsert.action?auditState=1";
	        }
	    }else{
	        invoiceForm.action = "ykinvoiceInsert.action?auditState=0";
	    }

		invoiceForm.submit();
	}
	
	function toFixAndNan(obj){
		obj.value=obj.value.replace(/[^0-9.][0-9]*/g,'');
	}
    function toFixAndNum(obj){
		obj.value=obj.value.replace(/[^0-9][0-9]*/g,'');
	}
	
	function toFix(obj){
		if(obj.value != ''){
			obj.value=parseFloat(obj.value).toFixed(2);
		}
	}
	
	//向下事件含税单价
	function hanshuiDown(thisnum){
		var x=0;
			$('td[id=td1]').each(function(){
					x=++x;
			});
		if(event.keyCode == 40){

			var i = thisnum.id.substr(14);
			i=++i;
			if(i>=x){
			}else{
			document.getElementById("lieiecostprice"+i).focus();
			document.getElementById("lieiecostprice"+i).select();
			}	
		}
	}
	//向下事件核销数量
	function chengbenDown(thisnum){
		var x=0;
			$('td[id=td1]').each(function(){
					x=++x;
			});
		if(event.keyCode == 40){

			var i = thisnum.id.substr(8);
			i=++i;
			if(i>=x){
			}else{
			document.getElementById("chengben"+i).focus();
			document.getElementById("chengben"+i).select();	
			}
		}
	}
		//向下事件单位成本
	function danweiDown(thisnum){
		var x=0;
			$('td[id=td1]').each(function(){
					x=++x;
			});
			

		if(event.keyCode == 40){
			
			var i = thisnum.id.substr(6);
			
			i=++i;
			if(i>=x){
			}else{
			document.getElementById("danwei"+i).focus();
			document.getElementById("danwei"+i).select();
			}
				
		}
	}
	//向下事件税额合计
	function jiashuiDown(thisnum){

		if(event.keyCode == 40){

			var i = thisnum.id.substr(7);
			i=++i;
			document.getElementById("jiashui"+i).focus();
			document.getElementById("jiashui"+i).select();	
		}
	}
	//向下事件价税合计
	function hexiaoDown(thisnum){

		if(event.keyCode == 40){

			var i = thisnum.id.substr(6);
			i=++i;
			document.getElementById("hexiao"+i).focus();
			document.getElementById("hexiao"+i).select();	
		}
	}

	$(document).ready(function(){
		 <s:iterator value="inventoryEntryList" status="idx">
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
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
		var c12 = row.insertCell(11);
		var c13 = row.insertCell(12);		
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == '${cstieid}')  return;
		}
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input name="chk" type="checkbox" value="${cstieid}"><input type="hidden" name="invoiceEntryPo.lieieid" value="${cstieid}" /><input name="invoiceEntryPo.cstiebilltypeid" type="hidden" value="${cstiebilltypeid}">';
        c2.innerHTML = '${cstiebillid}'+ '<input type="hidden" name="invoiceEntryPo.lieiebillid" value="${cstiebillid}" />';
        c3.innerHTML = '${cstiegoodsid}'+ '<input type="hidden" name="invoiceEntryPo.lieiegoodsid" value="${cstiegoodsid}" />';
		c4.innerHTML = '${cstiegoodsname}'+ '<input type="hidden" name="invoiceEntryPo.lieiegoodsname" value="${cstiegoodsname}" />';
		c5.innerHTML = '${cstiespec}'+ '<input type="hidden" name="invoiceEntryPo.lieiespec" value="${cstiespec}" />';
		c6.innerHTML = '${cstiegoodsquantity}'+ '<input type="hidden" name="invoiceEntryPo.lieiegoodsquantity" value="${cstiegoodsquantity}" />';
		c6.id="td1";
		c7.id="td2";		
		c9.id="td3";
		c12.id="td4";
		c13.id="td5";
		c7.innerHTML = '<input onkeyup="toFixAndNum(this);hexiaoDown(this);" onblur="shuliangCal(this);" type="text" name="invoiceEntryPo.lieiecheckgoodsquantity" value="${cstiecheckgoodsquantity}" id="hexiao${idx.index}" class="text_input60" >';	
		c8.innerHTML = '<input type="text" onblur="danweiCal(this);" value="${cstienottaxrate}" name="invoiceEntryPo.lieienottaxrate" id="danwei${idx.index}" class="text_input60" onkeyup="toFixAndNan(this);danweiDown(this);"/>';	
		
		c9.innerHTML =  '<input readonly="readonly" onkeyup="toFixAndNan(this);amount();" style="background-color:#ACA899" type="text" name="invoiceEntryPo.lieienottaxrateamount" value="${cstienottaxrateamount}" id="chengben${idx.index}" class="text_input60">';		
		//c10.innerHTML = '${cstietaxrate}'+'<input type="hidden" value="${cstietaxrate}" name="cstietaxrate"/><input type="hidden" value="${cstietaxrate}" name="invoiceEntryPo.lieietaxrate"/>';	
		c10.innerHTML = '<input type="text" value="${cstietaxrate}" name="cstietaxrate" class="text_input60"/><input type="hidden" value="${cstietaxrate}" name="invoiceEntryPo.lieietaxrate"/>';	
		c11.innerHTML = '<input onblur="hanshuiCal(this);toFix(this)" type="text" value="${cstiecostprice}" name="invoiceEntryPo.lieiecostprice" onkeyup="toFixAndNan(this);hanshuiDown(this);" id="lieiecostprice${idx.index}" class="text_input60" />';
		
		c12.innerHTML = '<input readonly="readonly" onkeyup="toFixAndNan(this);amount();" style="background-color:#ACA899" type="text" value="${cstietaxamount}" name="invoiceEntryPo.lieietaxamount" class="text_input60" id="shuie${idx.index}" />';
		c13.innerHTML = '<input readonly="readonly" onkeyup="toFixAndNan(this);amount();" style="background-color:#ACA899" type="text" name="invoiceEntryPo.lieiecostpriceamount" value="${cstiecostpriceamount}"  id="jiashui${idx.index}" class="text_input60" >';
		
		
		$('#del' + index).btn().init();
		 </s:iterator>
		 
		 amount();
		 
		$('span[id=lieienottaxrate]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(6));
		});		
		$('input[name=invoiceEntryPo.lieienottaxrate]').each(function(){
			$(this).val(parseFloat($(this).val()).toFixed(6));
		});
		$('input[name=invoiceEntryPo.lieienottaxrateamount]').each(function(){
			$(this).val(parseFloat($(this).val()).toFixed(2));
		});
		$('#td3t').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});
		$("#btn1").checked = true;
		
		$(document).keydown(function(event){
            if(event.keyCode==118){ //F7
			    if (isAuto == 1){ //自动
			        $("#btn1").checked = false;
			        $("#btn0").checked = true;
			        isAuto = 0;
			    }else{
			        $("#btn0").checked = false;
			        $("#btn1").checked = true;
			        isAuto = 1;
			    }
		    }
        });
	});	

	function openGoodSingleValues(objValue,startDate,endDate){
		
		document.getElementById('billStringID').value = objValue;
		
		invoiceForm.action="ykselBills.action?billID="+objValue+"&invoiceType="+$("#invoiceType").val()+"&billStringID="+document.getElementById('billStringID').value+"&invoiceStartDate="+startDate+"&invoiceEndDate="+endDate+"&moduleID=${moduleID}";
		invoiceForm.submit();
	}
	
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("ykselSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("ykselSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		$("#supplierID").val(json.id);
		$("#supplierName").val(json.value);
		deleteItems();
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
	 *  选择单据开窗 
	 */
    function openSelectBill(){
		var billStringID = document.getElementById('billStringID').value;
    
        if($("#invoiceType").val()==''){
			alert('请选择发票类型!');
			return;
		}
    	if($("#supplierID").val()==''){
    		alert('请先选择制造商!');
    		return;
    	}
    	
    	var billID = '';		
		$('input[name=chk]').each(function(){
			if(billID.indexOf($(this).val()) == -1){
				billID=billID+$(this).val()+',';
			}
		});	
			
		var typeid = document.getElementsByName('invoiceEntryPo.lieiebillid')[0];
		if (typeid == null){
		    typeid = 1;
		}else{
		    if (typeid.value.substring(0,3)=="PIN" || typeid.value.substring(0,3)=="CPI"){
		        typeid = 1;
		    }else{
		        typeid = 2;
		    }
		}

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("ykinitSelectBillSel.action?invoiceStartDate="+$('#invoiceStartDate').val()+"&invoiceEndDate="+$('#invoiceEndDate').val()+"&typeid="+typeid+"&supplierID="+document.getElementById('supplierID').value+"&billID="+billID+"&supplierName="+EncodeUtf8(document.getElementById('supplierName').value)+"&billStringID="+billStringID+"&invoiceType="+$("#invoiceType").val()+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("ykinitSelectBillSel.action?invoiceStartDate="+$('#invoiceStartDate').val()+"&invoiceEndDate="+$('#invoiceEndDate').val()+"&typeid="+typeid+"&supplierID="+document.getElementById('supplierID').value+"&billID="+billID+"&supplierName="+EncodeUtf8(document.getElementById('supplierName').value)+"&billStringID="+billStringID+"&invoiceType="+$("#invoiceType").val()+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【单据查询】";
    }

	$(document).ready(function() { 
		   $("img[btn=btn]").attr("style","cursor: hand;"); 
		   $("img[btn=btn]").mouseover(function () { 
		   $(this).attr("src",$(this).attr("src").replace("0","1")); 
		   }).mouseout(function () { 
		     $(this).attr("src",$(this).attr("src").replace("1","0")); 
		   }); 
	}); 
    
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }><form name="invoiceForm" method="post">
<input type="hidden" id="billStringID" name="billStringID" value="${requestScope.billStringID}" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                          <TD width="8%" class="table_body">发票号</TD>
                          <TD width="20%" class="table_none">${invoiceID }<input type="hidden" name="invoiceID" value="${invoiceID}"/></TD>
                          <TD width="7%" class="table_body">单据日期</TD>
                          <TD width="20%" class="table_none">
                          
                          <input id="invoiceStartDate"
					       name="invoicePo.liidate"
					       type="text" class="text_input140" 
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'invoiceEndDate\')}'})"
					       value="${invoiceStartDate }" />                         
                          <input type="hidden" id="invoiceEndDate"  value="${invoiceEndDate }"/>
                          </TD>
                         <TD height="30" class="table_body">制造商名称</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" readonly="readonly" class="text_input200" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } ></li>
						   	</TD>
                          </TR>
                        <TR height="30px">
                          <TD class="table_body" >部门</TD>
                          <TD class="table_none" >${person.bdpdepartmentname}<input type="hidden" name="invoicePo.liidepartmentid" value="${ person.departmentID}"/></TD>
                          <TD class="table_body" >制作人</TD>
                          <TD class="table_none" >${person.personName }<input type="hidden" name="invoicePo.liicreatepersonid" value="${person.id}"/></TD>
                          <TD class="table_body">发票类型</TD>
                          <TD class="table_none" colspan="7"> 
					           <SELECT id="invoiceType" name="invoiceType" onchange="deleteItems();">
					               <option value="">----请选择----</option>
					             <s:iterator value="invoiceTypeList">
                                   <option value="${sLitID}"} ${typeID == sLitID ? 'selected="selected"' : '' }>${sLitType}</option>
	     	                     </s:iterator> 
					           </SELECT>
					       </TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6>
                            <label>
                              <textarea name="remark" id="remark">${remark}</textarea>
                            </label>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left"><img btn=btn src="${ctx }/img/newbtn/btn_xzdj_0.png" title="选择单据" 
						  onClick="javascript:openSelectBill()">
                            <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onclick="deleteItem()"></TD>
                          <TD align="right">
                            <input name="radbtn" type="radio" value="1" onClick="updateAuto(1);" checked="checked">自动计算&nbsp;&nbsp;&nbsp;&nbsp;
                            <input name="radbtn" type="radio" value="0" onclick="updateAuto(0);">手工计算
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
                        <TR height="20px" class=table_title align=middle >
                           <TH scope=col width="5%" height="26"><input onclick="chkAll()" id="chks" type="checkbox">选择</TH>
                          <TH scope=col width="11%" height="26">单据号</TH>
                          <TH width="12%" height="26" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH scope=col width="6%">规格</TH>
                          <TH scope=col width="4%">数量</TH>
                          <TH scope=col width="5%">核销数量</TH>
                          <TH scope=col width="7%">单位成本</TH>
						  <TH scope=col width="8%">成本合计</TH>
                          <TH scope=col width="6%">税率(%)</TH>
						  <TH scope=col width="8%">含税单价</TH>
                          <TH scope=col width="8%">税额合计</TH>
						  <TH scope=col width="12%">价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div align="center" id="td1t"></div></TD>
                          <TD><div align="center" id="td2t"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD><div align="center" id="td3t"></div></TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD><div align="center" id="td4t"></div></TD>
                          <TD><div align="center" id="td5t"></div></TD>
                          </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
						  <TD align="left">
						      <p>
						      <input type="checkbox" id="auditState" name="auditState" value="1">保存并审核
						      </p>
						  </TD>
                        </TR>
					   <TR>
						  <TD align="left"><img btn=btn id="saveBtn" name="saveBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()"></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>