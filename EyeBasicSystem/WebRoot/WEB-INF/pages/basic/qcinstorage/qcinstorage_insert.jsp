<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>

<title>新增非效期商品期初库存</title>
</head>
<script>
//-----------向下复制数量-------------------------
var indexBasic=1;
function goodsquantityAdd(obj){
	var table = document.getElementById('addTable');
	var index = table.rows.length-1;

	if(confirm("是否向下复制数量?")){
		for(var i=parseInt(obj.id.substring(13,obj.id.length));i<parseInt(indexBasic);i++){
			if(document.getElementById('goodsquantity'+i)){
				document.getElementById('goodsquantity'+i).value = obj.value;
			}
		}
		 return true;
	}else{
		return false;
	} 			
}
//-----------向下复制数量-------------------------
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		
		<c:if test="${not empty(goodsInfoPos)}">
			$("#div_goodslist").show();
		</c:if>
		
		isshow('${cstpgoodscategory}');
		
		amount();
	});

	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=goodsInfoTempPo.goodsquantity]").index(obj)+1;
		    $("input[name=goodsInfoTempPo.goodsquantity]").eq(index).focus();
		}
	}

	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		amount();
	}	
	
   /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID=document.getElementById('cstpgoodscategory').value;
		  if(goodscategoryID == ''){
	      alert('请选择入库类型！');
	      return false;
	    }
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}

	function save(){
		if(checkForm(document.all.procurementReceiptForm)){ 

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
			
			var cstpgoodscategory = $('#cstpgoodscategory').val();
			
			if(goodsquantityCount==0){
	          alert('请选择商品!');
	          return false;
	        }
	        
	        var goodsids = document.getElementsByName('goodsInfoTempPo.goodsid');
			var goodsbarcodes = document.getElementsByName('goodsInfoTempPo.pcbarcode');
			
			var size = goodsids.length;
			
			var submittype = 'a';
			for(var i = 0; i < size; i++){
				if(goodsids[i].value.replace(/\./g,"").toUpperCase()!=goodsbarcodes[i].value.substring(0,18).toUpperCase()){
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
			procurementReceiptForm.action = "insertQcInStorage.action";
			procurementReceiptForm.submit();
		}
	}
	
	function openGoodSingle(){
		var categoryID_open=document.getElementById('cstpgoodscategory').value;
	    if(categoryID_open == ''){
		    alert('请选择入库类型!');
		    return false;
		}
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var moduleID=document.all.moduleID.value;
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&moduleID="+moduleID+"&supplierID_open="+$('#cstisupplierid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&moduleID="+moduleID+"&supplierID_open="+$('#cstisupplierid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(var i = 0; i < goodInfos.length; i++){	
			addRow(goodInfos[i]);			
		}
		var ordertype = goodInfos[0].bgigoodsid.substring(0,1);
		$('#goodstype').val(ordertype);
		isshow(ordertype);
		amount();

		$("input[name='goodsInfoTempPo\\.goodsquantity']").each(function(){
			$(this).bind("keyup",function(){
				$(this).val(
				$(this).val().replace(/[^0-9.][0-9]*/g,'')
				);
			});	
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val(
					$(this).val().replace(/[^0-9.][0-9]*/g,'')
					);
				}else{
					$(this).val('');
				}
			});	
		});
	}

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
		var issubmit = '0';
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.bgigoodsid){
				issubmit='1';
            }
		});
		if(issubmit == '1'){
	        return;
	    }
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);		//色号
		var c6 = row.insertCell(5);		//球径
		var c7 = row.insertCell(6);		//柱径
		var c8 = row.insertCell(7);		//下加光
		var c9 = row.insertCell(8);		//折射率
		var c10 = row.insertCell(9);	//光度分类
		var c11 = row.insertCell(10);	//材料分类
		var c12 = row.insertCell(11);	//曲率
		var c13 = row.insertCell(12);	//直径
		var c14 = row.insertCell(13);	//框架材质
		var c15 = row.insertCell(14);	//框架尺寸
		var c16 = row.insertCell(15);	//配件型
		var c17 = row.insertCell(16);	//使用类型 
		var c18 = row.insertCell(17);	//抛弃型分类
		var c19 = row.insertCell(18);	//老花镜度数
		var c20 = row.insertCell(19);	//厂家色号 
		var c21 = row.insertCell(20);	//主容量
		var c22 = row.insertCell(21);	//次容量

		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			var c23 = row.insertCell(22);
			var c24 = row.insertCell(23);
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			var c23 = row.insertCell(22);
		}
		
		
		  c5.id="ys";		//色号
		  c6.id="qj";		//球径
		  c7.id="zj"; 		//柱径
		  c8.id="xjg"; 		//下加光
		  c9.id="zsl"; 		//折射率
		  c10.id="gdfl"; 		//光度分类
		  c11.id="clfl";		//材料分类
		  c12.id="ql"; 		//曲率
		  c13.id="zhj"; 		//直径
		  c14.id="kjcz"; 		//框架材质
		  c15.id="kjcc"; 		//框架尺寸
		  c16.id="pjlx"; 		//配件型
		  c17.id="sylx"; 		//使用类型 
		  c18.id="pqxfl";		//抛弃型分类
		  c19.id="lhjds";		//老花镜度数
		  c20.id="cjsh"; 		//厂家色号 
		  c21.id="zrl"; 		//主容量
		  c22.id="crl"; 		//次容量
	

		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="color" value="' + goodInfo.bgicolor +'" /><input type="hidden" id="spec" value="' + goodInfo.bgispec +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="hidden" id="goodsname" value="' + goodInfo.bgigoodsname +'" /><input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
        c3.innerHTML = goodInfo.bgigoodsname+ '<input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" />';
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgicolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgibelowplusluminosity;
		c9.innerHTML = goodInfo.bgirefractive;
		var string1='';
		var string2='';
		var string3='';
		var string4='';
		var string5='';
		var string6='';
		 if(goodInfo.bgiismutiluminosity=="M"){string1='多光';}
		else if(goodInfo.bgiismutiluminosity=="0"){string1='单光';}
		else if(goodInfo.bgiismutiluminosity=="Q"){string1='其它';}
		else if(goodInfo.bgiismutiluminosity=="K"){string1='抗疲劳';}
		else if(goodInfo.bgiismutiluminosity=="J"){string1='渐近';}
		else {string1='';}
		 c10.innerHTML =string1;
		if(goodInfo.bgieyeglassmaterialtype=="1"){string2='树脂';}
			else if(goodInfo.bgieyeglassmaterialtype=="2"){string2='玻璃';}
			else if(goodInfo.bgieyeglassmaterialtype=="3"){string2='PC';}
			else{string2='';}
		c11.innerHTML = string2;
		
		c12.innerHTML = goodInfo.bgicurvature1;
		c13.innerHTML = goodInfo.bgidia;
		c14.innerHTML = goodInfo.bgiframematerialtypename;
		c15.innerHTML = goodInfo.bgiframesize;
		if(goodInfo.bgiaccessoriestype=="1"){string4='框镜';}
		else if(goodInfo.bgiaccessoriestype=="2"){string4='隐形';}
		else{string4='';}
		c16.innerHTML = string4;
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';}
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';}
		else{string5='';}
		 c17.innerHTML = string5;
		if(goodInfo.bgistealthclass=="1"){'日抛';}
						else if(goodInfo.bgistealthclass=="2"){string6='周抛';} 
						else if(goodInfo.bgistealthclass=="9"){string6='双周抛';}
						else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
						else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
						else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
						else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
						else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
						else{string6='';}
		c18.innerHTML = string6;
		c19.innerHTML = goodInfo.bgisph;
		c20.innerHTML = goodInfo.bgisuppliercolor;
		c21.innerHTML = goodInfo.bgicapacity;
		c22.innerHTML = goodInfo.bgicapacityentry;

		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c23.innerHTML = '<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" id="pcbarcode" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode.toUpperCase()+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			c24.innerHTML = '<input type="text" class="text_input40"  id="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)"  onkeydown="OnKeyDownEnter(this)" maxlength="18" pid="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value=""  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			indexBasic++;
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c23.innerHTML = '<input type="hidden" id="pcbarcode" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" index="'+index+'" name="goodsInfoTempPo.pcbarcode" index="'+index+'" value="'+goodInfo.bgipcbarcode.toUpperCase()+'"><input type="text" class="text_input40" maxlength="18" pid="quantity" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}
    }
   
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
	 * 制造商开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('cstisupplierid').value = json.id;
		document.getElementById('cstisuppliername').value = json.value;		
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
	
    /**
	*  二维表开窗事件
	*/
	function open2D(){
		if ('${systemParameterPo.fspstealtheffective}'==1||'${systemParameterPo.fspstealtheffective}'=='2'){
			if ($('#cstpgoodscategory').val() != '3'){
		        alert("请选择镜片商品!");
		        return;
		    }
	    }else{
	    	if ($('#cstpgoodscategory').val() != '3'){
		    	if($('#cstpgoodscategory').val() != '4'){
			        alert("请选择镜片或隐形镜片商品!");
			        return;
		    	}
		    }
	    }

		var chaasupplier =document.getElementById('cstisupplierid').value;
	    if(chaasupplier==''){
		    alert('请选择制造商');
		    return false;
	    }
	    var goodsIdNew='';
	    var goodsNumNew='';
	    $("input[name=goodsInfoTempPo.goodsid]").each(function(){
	    	goodsIdNew=goodsIdNew+$(this).val()+",";
		});
	    $("input[name=goodsInfoTempPo.goodsquantity]").each(function(){
	    	goodsNumNew=goodsNumNew+$(this).val()+",";
		});
	    $('#tdgoodsids').val(goodsIdNew);
	    $('#tdvs').val(goodsNumNew);

	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory="+$('#cstpgoodscategory').val()+"&bspsuppliername="+EncodeUtf8($('#cstisuppliername').val())+"&cstpsupplierid="+$('#cstisupplierid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory="+$('#cstpgoodscategory').val()+"&bspsuppliername="+EncodeUtf8($('#cstisuppliername').val())+"&cstpsupplierid="+$('#cstisupplierid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【按二维表添加商品】";
	}
	
	// 二维开窗赋值实现方法
	function openGoodsDimensionValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
		  if(goodInfos[i].v!=''){
			addDimensionRow(goodInfos[i]);	
		  }		
		}
		var ordertype = goodInfos[0].goodsid.substring(0,1);
		$('#goodstype').val(ordertype);
		isshow($('#goodstype').val());
		amount();	
	}
	
	function addDimensionRow(goodInfo){    		
		var table = document.getElementById('addTable');
		var index = 0;
		if(indexBasic==1){
			index = table.rows.length - 1;
		}
		else{
			index = indexBasic;
		}
		// 商品id去重
		var chk=document.getElementsByName("chk");
		if(goodInfo.goodsid.substr(0, 1)!='4')
		{
			for(i = 0; i < chk.length; i++){
				if (chk[i].value == goodInfo.goodsid) return;
			}
		}
		
		var row = table.insertRow(table.rows.length);

		var c1 = row.insertCell(0);		//选择
		var c2 = row.insertCell(1);		//代码		
		var c3 = row.insertCell(2);		//名称
		var c4 = row.insertCell(3);		//规格
		var c5 = row.insertCell(4);		//色号
		var c6 = row.insertCell(5);		//球径
		var c7 = row.insertCell(6);		//柱径
		var c8 = row.insertCell(7);		//下加光
		var c9 = row.insertCell(8);		//折射率
		var c10 = row.insertCell(9);	//光度分类
		var c11 = row.insertCell(10);	//材料分类
		var c12 = row.insertCell(11);	//曲率
		var c13 = row.insertCell(12);	//直径
		var c14 = row.insertCell(13);	//框架材质
		var c15 = row.insertCell(14);	//框架尺寸
		var c16 = row.insertCell(15);	//配件型
		var c17 = row.insertCell(16);	//使用类型 
		var c18 = row.insertCell(17);	//抛弃型分类
		var c19 = row.insertCell(18);	//老花镜度数
		var c20 = row.insertCell(19);	//厂家色号 
		var c21 = row.insertCell(20);	//主容量
		var c22 = row.insertCell(21);	//次容量

		if('${systemParameterPo.fspbarcodetype}'=='1'||'${systemParameterPo.fspbarcodetype}'=='2')
		{
			var c23 = row.insertCell(22);
			var c24 = row.insertCell(23);
		}
		if('${systemParameterPo.fspbarcodetype}'=='3')
		{
			var c23 = row.insertCell(22);
		}

		  c5.id="ys";		//色号
		  c6.id="qj";		//球径
		  c7.id="zj"; 		//柱径
		  c8.id="xjg"; 		//下加光
		  c9.id="zsl"; 		//折射率
		  c10.id="gdfl"; 		//光度分类
		  c11.id="clfl";		//材料分类
		  c12.id="ql"; 			//曲率
		  c13.id="zhj"; 		//直径
		  c14.id="kjcz"; 		//框架材质
		  c15.id="kjcc"; 		//框架尺寸
		  c16.id="pjlx"; 		//配件型
		  c17.id="sylx"; 		//使用类型 
		  c18.id="pqxfl";		//抛弃型分类
		  c19.id="lhjds";		//老花镜度数
		  c20.id="cjsh"; 		//厂家色号 
		  c21.id="zrl"; 		//主容量
		  c22.id="crl"; 		//次容量
		
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.goodsid + '" >';
        c2.innerHTML = goodInfo.goodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.goodsid +'" /><input type="hidden" id="color" value="' + goodInfo.coler +'" /><input type="hidden" id="spec" value="' + goodInfo.spec +'" /><input type="hidden" id="retailprice" value="' + goodInfo.retailPrice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" /><input type="hidden" id="goodsname" value="' + goodInfo.goodsName +'" />';
        c3.innerHTML = goodInfo.goodsName;
		c4.innerHTML = goodInfo.spec;
		c5.innerHTML = goodInfo.coler;
		c6.innerHTML = goodInfo.sph;		
		c7.innerHTML = goodInfo.cyl;				
		c8.innerHTML = '0.00';
		c9.innerHTML = '';
		var string1='';
		var string2='';
		var string3='';
		var string4='';
		var string5='';
		var string6='';
		 if(goodInfo.bgiismutiluminosity=="M"){string1='多光';}
		else if(goodInfo.bgiismutiluminosity=="0"){string1='单光';}
		else if(goodInfo.bgiismutiluminosity=="Q"){string1='其它';}
		else if(goodInfo.bgiismutiluminosity=="K"){string1='抗疲劳';}
		else if(goodInfo.bgiismutiluminosity=="J"){string1='渐近';}
		else {string1='';}
		 c10.innerHTML =string1;
		if(goodInfo.bgieyeglassmaterialtype=="1"){string2='树脂';}
			else if(goodInfo.bgieyeglassmaterialtype=="2"){string2='玻璃';}
			else if(goodInfo.bgieyeglassmaterialtype=="3"){string2='PC';}
			else{string2='';}
		c11.innerHTML = string2;
		
		c12.innerHTML = goodInfo.bgicurvature1;
		c13.innerHTML = goodInfo.bgidia;
		c14.innerHTML = goodInfo.bgiframematerialtypename;
		c15.innerHTML = goodInfo.bgiframesize;
		if(goodInfo.bgiaccessoriestype=="1"){string4='框镜';}
		else if(goodInfo.bgiaccessoriestype=="2"){string4='隐形';}
		else{string4='';}
		c16.innerHTML = string4;
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';} 
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';} 
		else{string5='';}
		 c17.innerHTML = string5;
		if(goodInfo.bgistealthclass=="1"){'日抛';}
		else if(goodInfo.bgistealthclass=="2"){string6='周抛';} 
		else if(goodInfo.bgistealthclass=="9"){string6='双周抛';}
		else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
		else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
		else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
		else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
		else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
		else{string6='';}
		c18.innerHTML = string6;
		c19.innerHTML = goodInfo.bgisph;
		c20.innerHTML = goodInfo.bgisuppliercolor;
		c21.innerHTML = goodInfo.bgicapacity;
		c22.innerHTML = goodInfo.bgicapacityentry;
        if('${systemParameterPo.fspbarcodetype}'=='1'||'${systemParameterPo.fspbarcodetype}'=='2')
		{
			c23.innerHTML =  '<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.goodsid+'\',this)" maxlength="26"  id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.pcbarcode.toUpperCase()+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			c24.innerHTML = '<input type="text" class="text_input40" id="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" onkeydown="OnKeyDownEnter(this)" maxlength="18" pid="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			indexBasic++;
		
		}
		if('${systemParameterPo.fspbarcodetype}'=='3')
		{
			c23.innerHTML = '<input type="hidden" id="pcbarcode" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" index="'+index+'" name="goodsInfoTempPo.pcbarcode" index="'+index+'" value="'+goodInfo.bgipcbarcode.toUpperCase()+'"><input type="text" class="text_input40" maxlength="18" pid="quantity" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}
		
		
		$("input[name='goodsInfoTempPo\\.goodsquantity']").each(function(){
			$(this).bind("keyup",function(){
				if(event.keyCode != 13){
					$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
				}
			});	
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val(
					$(this).val().replace(/[^0-9.][0-9]*/g,'')
					);
				}else{
					$(this).val('');
				}
			});	
		});

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
    		
    			$('[id=ys]').show();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').show();
    			$('[id=kjcc]').show();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
						    			
   			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","8");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","7");
				}
    		}else if(type == "2"){
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').show();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","6");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","5");
				}
    		}else if(type == "3"){
    			$('[id=ys]').hide();
    			$('[id=qj]').show();
    			$('[id=zj]').show();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').show();
    			$('[id=zsl]').show();
    			$('[id=gdfl]').show();
    			$('[id=clfl]').show();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();

    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","11");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","10");
				}
    			
    		}else if(type == "4"){
    		
    			$('[id=ys]').hide();
    			$('[id=qj]').show();
    			$('[id=zj]').show();
    			$('[id=ql]').show();
    			$('[id=zhj]').show();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').show();
    			$('[id=pqxfl]').show();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();

    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","11");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","10");
				}
    			
    		}else if(type == "5"){
    		
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').show();
    			$('[id=crl]').show();

    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","7");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","6");
				}
    			
    		}else if(type == "6"){
    		
    			$('[id=ys]').show();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').show();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();

    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","7");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","6");
				}
    			
    		}else if(type == "8"){
    		
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').show();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').show();
    			$('[id=cjsh]').show();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();

    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","8");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","7");
				}
    			
    		}else if(type == "7"){
    		
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();

    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","5");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","4");
				}
    			
    		}else if(type == "9"){
    		
    			$('[id=ys]').hide();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=ql]').hide();
    			$('[id=zhj]').hide();
    			$('[id=xjg]').hide();
    			$('[id=zsl]').hide();
    			$('[id=gdfl]').hide();
    			$('[id=clfl]').hide();
    			$('[id=kjcz]').hide();
    			$('[id=kjcc]').hide();
    			$('[id=pjlx]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=lhjds]').hide();
    			$('[id=cjsh]').hide();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();

    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","5");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","4");
				}
    			
    		}

    		$('#div_goodslist').attr("style","display:");
    	}
    }  
    
    function deleteROW(id){
   		var tablelength = $('#addTable tr').length;
   		type = $('#cstpgoodscategory').val();
   		
   		if(tablelength > 2){
   			if(confirm('更改 入库类型 或 制造商 会清空现有商品信息，是否进行更改？')){
   				if(id=="1"){
   					var i = 0;
	    		
					$('#addTable tr').each(function (){
						i++;
						if(i > 2){
							$(this).remove();
						}
					});
					
					$('#div_goodslist').attr("style","display: none;");

					$('#cstisuppliername').val('');
					$('#cstisupplierid').val('');

					amount();
   				}
	    		
	    		if(id=="2"){

	    			var i = 0;
	    		
					$('#addTable tr').each(function (){
						i++;
						if(i > 2){
							$(this).remove();
						}
					});
					
					$('#div_goodslist').attr("style","display: none;");
					amount();
	    			openSupplier();
	    		}
			}else{
				if(id=="1"){
					$('#cstpgoodscategory').val($('#goodstype').val());
					isshow($('#goodstype').val());
				}
				
			}
			
			
		}else if(id=="2"){
			openSupplier();
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

    function deleteROWss(){
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
 	 
     function clean(){
		 $('#cstisupplierid').val('');
		 $('#cstisuppliername').val('');		 
		 $('#companyID').val('');
   		 $('#cstpgoodscategory').val('');
		 $('#dptID').val('');
   		 $('#warehouseID').val('');
         $("#dptID option[value!='']").remove();
         $("#warehouseID option[value!='']").remove();
   		
   		deleteROWss();
   		amount();
	 }

     function showSubMenu(cid) {        
         $('#dptID').load("getAjaxDepartmentMenuForCompanyID.action?id="+ cid);
         $('#warehouseID').load("getAjaxStock.action?id=");
         $('#dptName').val("");
         $('#warehouseName').val("");
     }

     function showSubMenu2(cid) {        
     	$('#warehouseID').load("getAjaxStock.action?id="+ cid);
     	$('#warehouseName').val("");
     }
     
    function addtdgoods(){
		procurementReceiptForm.action = "addQcInStorageDimension.action";
		procurementReceiptForm.submit();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value=""/>
<input type="hidden" id="tdvs" name="tdvs" value="" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="goodstype" name="goodstype" value="${goodstype }">
<input type="hidden" id="ioru" name="ioru" value="i">
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
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=0 width="100%" align=center 
                  border=0>
                      <TBODY>
    				  	<TR>
						   <TD height="26" width="8%" class="table_body">所属公司</TD>
			               <TD class="table_none">
						   		<select id="companyID" clean="clean" name="companyID" onchange="showSubMenu(this.options[this.options.selectedIndex].value,'')" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取所属公司！'}]">
	                              <option value="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" ${fcnId == companyID ? 'selected="selected"' : ''}>${fcnName}</option>
	                              </s:iterator>
	                            </select><label style="color:red;">&nbsp;*</label>
                           </TD>
                           
                           <TD width="8%" class="table_body">所属部门</TD>
			               <TD class="table_none">			   
							   	<select id="dptID" clean="clean" name="dptID" onchange="showSubMenu2(this.options[this.options.selectedIndex].value,'');$('#dptName').val($(this).find('option:selected').text());"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取所属部门！'}]">
	                              <option value="">----请选择----</option>
	                              <c:if test="${not empty(dptID) }">
	                              	<option value="${dptID }" selected="selected">${dptName }</option>
	                              </c:if>
	                            </select>
	                            <input type="hidden" id="dptName" clean="clean" name="dptName" value="${dptName }"/>
	                            <label style="color:red;">&nbsp;*&nbsp;选取所属公司后，才会显示所属部门</label>
						   </TD>
						   
						   <TD width="8%" class="table_body">入库仓位</TD>
			               <TD class="table_none">			   
							   	<select id="warehouseID" clean="clean" name="warehouseID" onchange="$('#warehouseName').val($(this).find('option:selected').text());"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取所属仓位！'}]">
	                              <option value="">----请选择----</option>
	                              <c:if test="${not empty(warehouseID) }">
	                              	<option value="${warehouseID }" selected="selected">${warehouseName }</option>
	                              </c:if>
	                            </select>
	                            <input type="hidden" id="warehouseName" clean="clean" name="warehouseName" value="${warehouseName }"/>
	                            <label style="color:red;">&nbsp;*&nbsp;选取所属部门后，才会显示入库仓位</label>
						   </TD>
                        </TR>
                        
                        <TR height="26">
                          <TD class="table_body" width="9%">入库类型</TD>
                          <TD class="table_none">
	                          <select id="cstpgoodscategory" name="cstpgoodscategory"  onchange="deleteROW('1');isshow('');">
							  		<option value="">----请选择----</option>
							  		<option value="1" ${cstpgoodscategory eq '1' ? '"selected=selected"' : '' }>镜架</option>
									<option value="2" ${cstpgoodscategory eq '2' ? '"selected=selected"' : '' }>配件</option>
									<option value="3" ${cstpgoodscategory eq '3' ? '"selected=selected"' : '' }>镜片</option>
	     	               		<c:if test="${systemParameterPo.fspstealtheffective==0}"> 
									<option value="4" ${cstpgoodscategory eq '4' ? '"selected=selected"' : '' }>隐形</option>
									<option value="5" ${cstpgoodscategory eq '5' ? '"selected=selected"' : '' }>护理液</option>
	     	               		</c:if>
									<option value="6" ${cstpgoodscategory eq '6' ? '"selected=selected"' : '' }>太阳镜</option>
									<option value="8" ${cstpgoodscategory eq '8' ? '"selected=selected"' : '' }>老花镜</option>
									<option value="7" ${cstpgoodscategory eq '7' ? '"selected=selected"' : '' }>耗材</option>
									<option value="9" ${cstpgoodscategory eq '9' ? '"selected=selected"' : '' }>视光</option>							  		
	                          </select><label style="color:red;">&nbsp;*</label>						 	
						 </TD>
						 <TD height="26" class="table_body">制造商</TD>
						 <TD class="table_none" colspan="3">
						   <li class="horizontal_onlyRight">
						   		<input id="cstisuppliername" class="text_input160" name="cstisuppliername" value="${cstisuppliername }" readonly="readonly" />
						   		<input type="hidden" id="cstisupplierid" name="cstisupplierid" value="${cstisupplierid }" readonly="readonly"/>
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="deleteROW('2');">
						   </li>						   
						 </TD>
						   
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" width="60%">
                             <li class="horizontal_onlyRight">
						       <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
					           <img src="${ctx}/img/newbtn/btn_addtwogoods_0.png" btn=btn title="二维表添加商品" id="2D" onClick="javascript:open2D();">
					         </li>
					         <li class="horizontal_onlyRight">
						       <label style="color:red;">&nbsp;通过二维表添加商品时，入库类型只能选取镜片，并且要选取制造商!</label>
						     </li>
					      </TD>
					      <TD  align="right" width="40%">
					      <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">&nbsp;
					      <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
                         </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <div id="div_goodslist" style="display: none;">
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
	                          	<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();">
                           	</TD>
                          <td align="right"><font color="red" size="2"><b>*除通过二维表新增的商品外，双击商品数量可向下复制</b></font></td>                              	
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
                          <TH width="6%" scope=col>型号</TH>
                          <TH width="6%" scope=col id=ys>色号</TH>
                          <TH width="6%" scope=col id=qj>球镜</TH>
                          <TH width="6%" scope=col id=zj>柱镜</TH>
                          <TH width="6%" scope=col id=xjg>下加光</TH>
                          <TH width="6%" scope=col id=zsl>折射率</TH>
                          <TH width="6%" scope=col id=gdfl>光度分类</TH>
                          <TH width="6%" scope=col id=clfl>材料分类</TH>
                          <TH width="6%" scope=col id=ql>曲率</TH>
                          <TH width="6%" scope=col id=zhj>直径</TH> 
                          <TH width="6%" scope=col id=kjcz>框架材质</TH>
                          <TH width="6%" scope=col id=kjcc>框架尺寸</TH>
                          <TH width="6%" scope=col id=pjlx>配件型 </TH>
                          <TH width="6%" scope=col id=sylx>使用类型  </TH>
                          <TH width="6%" scope=col id=pqxfl>抛弃型分类  </TH>
                          <TH width="6%" scope=col id=lhjds>老花镜度数 </TH>
                          <TH width="6%" scope=col id=cjsh>厂家色号 </TH>
                          <TH width="6%" scope=col id=zrl>主容量 </TH>
                          <TH width="6%" scope=col id=crl>次容量 </TH>
                        
                         <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH width="9%" scope=col>商品条码</TH>
                          </c:if>
                          <TH width="6%" scope=col>数量</TH>                           
                        </TR>
                    	<TR class=table_title align=middle> 
						  	<TH width="40%" height="26" id="heji" colSpan=18 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%"  id="goodsquantityTotal">0</TH>
				   		</TR> 
				   		<c:forEach var="po" items="${goodsInfoPos}">  
				   		<tr class="row">
							<td>
								<input id="chk" type="checkbox" value="${po.bgigoodsid}" >
							</td>
					        <td>
					        	${po.bgigoodsid }
					        	<input type="hidden" name="goodsInfoTempPo.goodsid" value="${po.bgigoodsid }" />
					        	<input type="hidden" id="color" value="${po.bgicolor }" />
					        	<input type="hidden" id="spec" value="${po.bgispec }" />
					        	<input type="hidden" id="retailprice" value="${po.bgiretailprice }" />
					        	<input type="hidden" name="goodsInfoTempPo.costprice" value="${po.bgicostprice }" />
					        	<input type="hidden" name="goodsInfoTempPo.nottaxrate" value="${po.bginottaxrate }" />
					        	<input type="hidden" name="goodsInfoTempPo.taxrate" value="${po.bgitaxrate }" />
					        	<input type="hidden" id="goodsname" value="${po.bgigoodsname }" />
					        	<input type="hidden" id="source" value="${po.bgisource }" />
					        </td>
					        <td>
					        	${po.bgigoodsname }
					        	<input type="hidden" id="brandname" value="${po.bgibrandname }" />
					        </td>
							<td>${po.bgispec }</td>
							<td id="ys">${po.bgicolor }</td>
							<td id="qj">${po.bgisph }</td>	
							<td id="zj">${po.bgicyl }</td>				
							<td id="xjg">${po.bgibelowplusluminosity }</td>
							<td id="zsl">${po.bgirefractive }</td>
							<td id="gdfl">
								${po.bgiismutiluminosity }
							</td>
							<td id="clfl">
								${po.bgiismutiluminosity }
							</td>
							<td id="ql">${po.bgicurvature1 }</td>
							<td id="zhj">${po.bgidia }</td>
							<td id="kjcz">${po.bgiframematerialtypename }</td>
							<td id="kjcc">${po.bgiframesize }</td>
							<td id="pjlx">
								${po.bgiaccessoriestype eq '1' ? '框镜':'' }
								${po.bgiaccessoriestype eq '2' ? '隐形':'' }
							</td>
							<td id="sylx">
								${po.bgiusetype eq '1' ? '常带型':'' }
								${po.bgiusetype eq '2' ? '抛弃型':'' }
								${po.bgiusetype eq '3' ? '塑形镜':'' }
							</td>
							<td id="pqxfl">
								${po.bgiusetype eq '1' ? '日抛':'' }
								${po.bgiusetype eq '2' ? '周抛':'' }
								${po.bgiusetype eq '9' ? '双周抛':'' }
								${po.bgiusetype eq '3' ? '月抛':'' }
								${po.bgiusetype eq '4' ? '季抛':'' }
								${po.bgiusetype eq '5' ? '半年抛':'' }
								${po.bgiusetype eq '6' ? '年抛':'' }
								${po.bgiusetype eq '7' ? 'RGP':'' }
							</td>
							<td id="lhjds"> ${po.bgisph }</td>
							<td id="cjsh">${po.bgisuppliercolor }</td>
							<td id="zrl">${po.bgicapacity }</td>
							<td id="crl">${po.bgicapacityentry }</td>
					
							<c:if test="${systemParameterPo.fspbarcodetype eq '1'|| systemParameterPo.fspbarcodetype eq '2' }">
								<td><input type="text" class="text_input200" onBlur="barcodes('${po.bgigoodsid }',this)" maxlength="26" id="pcbarcode" readonly="readonly" name="goodsInfoTempPo.pcbarcode"  value="${po.bgipcbarcode }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品条码！'}]"/></td>
								<td><input type="text" class="text_input40"  id="goodsquantity" ondblclick="goodsquantityAdd(this)"  onkeydown="OnKeyDownEnter(this)" maxlength="18" pid="quantity" name="goodsInfoTempPo.goodsquantity" value=${po.bgigoodsquantity } onblur="amount();" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/></td>
							</c:if>
							<c:if test="${systemParameterPo.fspbarcodetype eq '3' }">
								<td>
									<input type="hidden" id="pcbarcode" onBlur="barcodes('${po.bgigoodsidc }',this)" index="'+index+'" name="goodsInfoTempPo.pcbarcode" value="${po.bgipcbarcode }">
									<input type="text" class="text_input40" maxlength="18" pid="quantity" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/>
								</td>
							</c:if>
                        </tr> 
                        </c:forEach>              
                      </TBODY>
                    </TABLE>
                    </div>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();">
                           	</TD>
					    </TR>
					   
					    <TR>
                          <td height="26">
                              <label style="color:red;"><b>在隐形使用效期的情况下，此功能页面用来新增带批号或不带批号的镜架、配件、镜片、太阳镜、耗材、老花镜、视光类商品的库存！</b></label>
                          </td>
                        </TR>
                        
                        <TR>
                          <td height="26">
                              <label style="color:red;"><b>在隐形不使用效期的情况下，此功能页面用来新增带批号或不带批号的镜架、配件、镜片、太阳镜、耗材、老花镜、视光类商品的库存以及不带效期和批号的隐形、护理液类商品的库存！</b></label>
                          </td>
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