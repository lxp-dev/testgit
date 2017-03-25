<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>

<title>采购收货管理</title>
</head>
<script>
	//-----------向下复制数量-------------------------
	var indexBasic=1;
	function goodsquantityAdd(obj){
		//alert(indexID.substring(13,indexID.length));
		
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
		$("input[id=pcbarcode]").each(function (){
			$(this).val($(this).val().toUpperCase());
		});
	});

	function addtdgoods(){
		deleteROWss();
		procurementReceiptForm.action = "addProcurementReceiptDimension.action";
		procurementReceiptForm.submit();
	}

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
		//条码批量打印
	function batPrintGoodsBarCode(){
		var flag = false;
		
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			var persons = $("input[id=person]");
			var barCodes = $("input[id=pcbarcode]");
			var goodsQuantitys = $("input[pid=quantity]");
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
					flag = true;
				}
			}

			if(flag == false){
				alert("请勾选要打印的商品条码！");
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
					 
				//alert("条码："+barCode);
				//alert("数量："+quantity);
				//alert("品种："+brandname);
				//alert("产地："+source);
				//alert("规格："+spec);
				//alert("色号："+color);
				//alert("零售价："+retailprice);
				//alert("定价员："+person);
				//alert("打印样式："+printtype);
				//alert("效期："+guaranteeperiod);
				//alert("批号："+batch);
					 
				try {
					printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,'','');
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
	    var goodscategoryID=document.getElementById('cstpgoodscategory').value;
		  if(goodscategoryID == ''){
	      alert('请选择采购类型！');
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
		if(checkForm(document.all.procurementReceiptForm)){ 
			if('${systemParameterPo.fspisfillindeliveryid}' == '1'){
				if(!$("#deliveryID").val().trim()){
					alert("请填写运单单号！");
					$("#deliveryID").focus();
					return;
				}
			}
		
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
			procurementReceiptForm.action = "insertStoreReceipt.action?cstiauditstate=0";
			procurementReceiptForm.submit();
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
			showPopWin("initProcurementOrdersForOpen.action?poType="+poType+"&supplierID=" + supplierID +"&goodscategory="+goodscategory,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementOrdersForOpen.action?poType="+poType+"&supplierID=" + supplierID +"&goodscategory="+goodscategory,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【采购订单查询】";
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
			showPopWin("initProcurementOrdersForOpens.action?poType="+poType+"&supplierID=" + supplierID +"&goodscategory="+goodscategory,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementOrdersForOpens.action?poType="+poType+"&supplierID=" + supplierID +"&goodscategory="+goodscategory,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【已核销订单查询】";
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
		var supplierID=document.all.cstisupplierid.value;
		var categoryID_open=document.getElementById('cstpgoodscategory').value;
		var cstibillid=document.getElementById('cstibillid').value;
	    
	    var iscustomize="";  
	    if(categoryID_open == ''){
	      alert('请选择采购类型');
	      return false;
	    }else
	    {
	    	if(categoryID_open=='3'||categoryID_open=='4')
	    	{
	    		iscustomize="0";
		    }
		}
	    if(supplierID==''){
		      alert('请选择所属制造商');
		      return false;
		    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var moduleID=document.all.moduleID.value;
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID+"&iscustomize="+iscustomize+"&cstibillid="+cstibillid+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID+"&iscustomize="+iscustomize+"&cstibillid="+cstibillid+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var c23 = row.insertCell(22);	//入库时间
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			var c24 = row.insertCell(23);
			var c25 = row.insertCell(24);
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			var c24 = row.insertCell(23);
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
		  c23.id="rksj"; 		//入库时间
		

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
		c23.innerHTML = document.all.cstibilldate.value+'<input type="hidden" class="text_input100" maxlength="26" id="bgirksj" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="'+document.all.cstibilldate.value+'" />';
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c24.innerHTML = '<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" id="pcbarcode" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode.toUpperCase()+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			c25.innerHTML = '<input type="text" class="text_input40"  id="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)"  onkeydown="OnKeyDownEnter(this)" maxlength="18" pid="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value=""  ${empty(inventoryPo.deliveryID) ? '' : 'readonly="readonly"' } validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			indexBasic++;
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c24.innerHTML = '<input type="hidden" id="pcbarcode" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" index="'+index+'" name="goodsInfoTempPo.pcbarcode" index="'+index+'" value="'+goodInfo.bgipcbarcode.toUpperCase()+'"><input type="text" class="text_input40" maxlength="18" pid="quantity" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" ${empty(inventoryPo.deliveryID) ? '' : 'readonly="readonly"' } validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}
    }
    
    function setValue(billid,poID,id,name){
    	var cstibillid = $('#cstibillid').val();
		procurementReceiptForm.action="initInsertProcurementReceipt.action?hid="+billid+"&cstibillid="+cstibillid;
		procurementReceiptForm.submit();
    }
    
    function setValueorders(billid,poID,id,name){
    	var cstibillid = $('#cstibillid').val();
    	//alert(cstibillid);
		procurementReceiptForm.action="initInsertProcurementReceipts.action?hid="+billid+"&cstibillid="+cstibillid;
		procurementReceiptForm.submit();
    }
    
	function openProcurementOrdersValues(objValue,poID,id,name){
		document.all.cstisourcebillid.value=poID;
		var goodInfos = eval('(' + objValue + ')');
		//document.all.deliveryID.value=poID;
		for(var i = 0; i < goodInfos.length; i++){
			addRow2(goodInfos[i]);			
		}
		
		$('#cstisuppliername').val(name);
		$('#cstisupplierid').val(id);
		
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
	
	function openDeliveryValues(poID, deliveryID){
		document.all.cstisourcebillid.value=poID;
		document.all.deliveryID.value=deliveryID;
		procurementReceiptForm.action="initProcurementReceiptInsert.action";
		procurementReceiptForm.submit();
	}
	
	$(document).ready(function(){
		<s:iterator value="goodsList">
	     var json = {'bgigoodsid':'${bgigoodsid}','bgigoodsbarcode':'${bgigoodsbarcode}',
	     				'bgigoodsname':'${bgigoodsname}','bgiunitname':'${bgiunitname}','bgicostprice':'${bgicostprice}',
	     				'bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}','bginottaxrate':'${bginottaxrate}',
	     				'bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
	     				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
	     				'bgigoodsquantity':'${bgigoodsquantity}','bgipcbarcode':'${bgipcbarcode }',
	    				'bgiframematerialtype':'${bgiframematerialtype }','bgiframesize':'${bgiframesize}','bgiaccessoriestype':'${bgiaccessoriestype}',
	                    'bgibelowplusluminosity':'${bgibelowplusluminosity }','bgirefractive':'${bgirefractive}','bgiismutiluminosity':'${bgiismutiluminosity}',
	                    'bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgiusetype':'${bgiusetype}','bgistealthclass':'${bgistealthclass}',
	                    'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry}','bgisuppliercolor':'${bgisuppliercolor}','bgiframematerialtypename':'${bgiframematerialtypename}',
	     				'bgisource':'${bgisource}'};
	     				
	    addRow2(json)                
		</s:iterator>
		
		
		<s:iterator value="procurementOrdersEntryPos">
		
	     var json = {'bgigoodsid':'${cstpegoodsid}','bgigoodsbarcode':'${bgiGoodsBarCode}','bgigoodsname':'${bgigoodsname}',
	     				'bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}','bginottaxrate':'${bginottaxrate}',
	     				'bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
	     				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
	     				'bgigoodsquantity':'${cstpeordernumber}','bgipcbarcode':'${bgiGoodsBarCode }',
	     				'bgiframematerialtype':'${bgiframematerialtype }','bgiframesize':'${bgiframesize}','bgiaccessoriestype':'${bgiaccessoriestype}',
	                    'bgibelowplusluminosity':'${bgibelowplusluminosity }','bgirefractive':'${bgirefractive}','bgiismutiluminosity':'${bgiismutiluminosity}',
	                    'bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgiusetype':'${bgiusetype}','bgistealthclass':'${bgistealthclass}',
	                    'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry}','bgisuppliercolor':'${bgisuppliercolor}','bgiframematerialtypename':'${bgiframematerialtypename}',
	     				'bgisource':'${bgisource}','bgibrandname':'${cstpebrandname}'};
	     				
	    addRow2(json)                
		</s:iterator>
		isshow($('#goodstype').val());
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
	});
	
	function addRow2(goodInfo){	
		
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
		if(goodInfo.bgigoodsid.substr(0, 1)!='4')
		{
			for(i = 0; i < chk.length; i++){
				if (chk[i].value == goodInfo.bgigoodsid) return;
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
		var c23 = row.insertCell(22);	//入库时间
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			var c24 = row.insertCell(23);
			var c25 = row.insertCell(24);
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			var c24 = row.insertCell(23);
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
		  c23.id="rksj"; 		//入库时间
			
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
		c23.innerHTML = document.all.cstibilldate.value+'<input type="hidden" class="text_input100" maxlength="26" id="bgirksj" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="'+document.all.cstibilldate.value+'" />';
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c25.innerHTML = '<input type="text" class="text_input40" id="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" maxlength="18" onkeydown="OnKeyDownEnter(this)" pid="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" ${empty(inventoryPo.deliveryID) ? '' : 'readonly="readonly"' } value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			c24.innerHTML = '<input type="text" class="text_input200"  onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26"  id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode.toUpperCase()+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			indexBasic++;
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c24.innerHTML = '<input type="hidden" id="pcbarcode" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" index="'+index+'" name="goodsInfoTempPo.pcbarcode" index="'+index+'" value="'+goodInfo.bgipcbarcode.toUpperCase()+'"><input type="text" onkeydown="OnKeyDownEnter(this)" class="text_input40" maxlength="18" pid="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" ${empty(inventoryPo.deliveryID) ? '' : 'readonly="readonly"' } value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
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
	 * 开窗赋值实现方法
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
		var c23 = row.insertCell(22);	//入库时间

		if('${systemParameterPo.fspbarcodetype}'=='1'||'${systemParameterPo.fspbarcodetype}'=='2')
		{
			var c24 = row.insertCell(22);
			var c25 = row.insertCell(23);
		}
		if('${systemParameterPo.fspbarcodetype}'=='3')
		{
			var c24 = row.insertCell(22);
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
		  c23.id="rksj"; 		//入库时间

		
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
		c23.innerHTML = document.all.cstibilldate.value+'<input type="hidden" class="text_input100" maxlength="26" id="bgirksj" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="'+document.all.cstibilldate.value+'" />';
		if('${systemParameterPo.fspbarcodetype}'=='1'||'${systemParameterPo.fspbarcodetype}'=='2')
		{
			c24.innerHTML =  '<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.goodsid+'\',this)" maxlength="26"  id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.pcbarcode.toUpperCase()+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			c25.innerHTML = '<input type="text" class="text_input40" id="goodsquantity'+ index +'" ondblclick="goodsquantityAdd(this)" onkeydown="OnKeyDownEnter(this)" maxlength="18" pid="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			indexBasic++;
		
		}
		if('${systemParameterPo.fspbarcodetype}'=='3')
		{
			c24.innerHTML = '<input type="hidden" id="pcbarcode" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" index="'+index+'" name="goodsInfoTempPo.pcbarcode" index="'+index+'" value="'+goodInfo.bgipcbarcode.toUpperCase()+'"><input type="text" class="text_input40" maxlength="18" pid="quantity" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
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
    			$('[id=rksj').show();

						    			
   			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","9");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","8");
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
    			$('[id=rksj').show();
    			
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","7");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","6");
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
    			$('[id=rksj').show();	

    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","12");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","11");
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
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","12");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","11");
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
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","8");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","7");
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
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","8");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","7");
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
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","9");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","8");
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
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","6");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","5");
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
    			$('[id=rksj').show();
    			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
				{
					$('#heji').attr("colSpan","6");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('#heji').attr("colSpan","5");
				}
    			
    		}

    		$('#div_goodslist').attr("style","display:");
    	}
    }  
    
    function deleteROW(id){
   		var tablelength = $('#addTable tr').length;
   		type = $('#cstpgoodscategory').val();
   		
   		if(tablelength > 2){
   			if(confirm('更改 采购类型 或 制造商 会清空现有商品信息，是否进行更改？')){
   				if(id=="1"){
   					var i = 0;
	    		
					$('#addTable tr').each(function (){
						i++;
						if(i > 2){
							$(this).remove();
						}
					});
					
					$('#div_goodslist').attr("style","display: none;");
					
					$('#cstisourcebillid').val('');
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
   	function changebarcode(index,obj){
   		var pclength = obj.val().length;
   		var pcvalue = obj.val();
   		
   		if(pclength < 8){
   			for(pclength ; pclength < 8; pclength++){
   				pcvalue = pcvalue + '0';
   			}
   		}else if(pclength > 8){
   			pcvalue=pcvalue.substring(pclength-8,pclength);
   		}	
   		var tmvalue = $('input[index='+index+']').val().substring(0,18);
   		
   		$('input[index='+index+']').val(tmvalue+pcvalue);
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
      }else
      {
      	document.all.cstiauditstate1.checked = false;	
      }
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
		 $('#cstpsupplierid').val('');$('#textarea').val('');
		 $('#deliveryID').val('');
		 $('#textarea').val('');
		 $('#cstisuppliername').val('');
		 $('#cstisupplierid').val('');
   		 $('#cstiinstockid').val('');
   		 $("#cstisourcebillid").val('');
   		 $('#cstpgoodscategory').val('');
   		$('#deliveryaddress').val('');
   		deleteROWss();
   		amount();
	}
	
	function importFile(){
		if ($("#file").val() == ""){
            alert("请选择需要上传的文档!");
            return;
        }
	
		procurementReceiptForm.action = "importStoreFrameManyExcel.action";
		procurementReceiptForm.submit();
	}
	
	var AllImgExt = ".xls";
	var FileExt = "";
	function CheckExt(obj){
		if(obj.value == ""){
			return false;
		}
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();		
		if(AllImgExt.indexOf(FileExt) != -1){
	        obj.value = getPath(obj);
            return true;

		}else{
			alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);

			return false;
		}
	}
	
	function getPath(obj){
		if(obj){
	    	if (window.navigator.userAgent.indexOf("MSIE") >= 1){ 
	        	obj.select();      
	            return document.selection.createRange().text;	               
	        }
	        else if(window.navigator.userAgent.indexOf("Firefox") >= 1){	               
	        	if(obj.files){ 	                           
	            	return obj.files.item(0).getAsDataURL();
	            }
	        	return obj.value;
           	}
	    	return obj.value;
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="goodstype" name="goodstype" value="${goodstype }">
<input type="hidden" id="person" value="${person.id }"/>
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />
<input type="hidden" id="ioru" name="ioru" value="i" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD>
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
                        <TR height="26">
                          <TD width="9%" class="table_body">单据编号</TD>
                          <TD width="23%" class="table_none" >${inventoryPo.cstibillid} <input type="hidden" class="text_input160" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}" readonly="readonly"></TD>
                          	<input type="hidden" class="text_input160" id="cstisourcebillid" name="inventoryPo.cstisourcebillid" value="${procurementOrdersEntryPos[0].cstpepurchaseorderid}" readonly="readonly">
	                        <input type="hidden" id="cstpgoodscategory" name="inventoryPo.cstigoodscategory" value="">
						 	<input type="hidden" name="inventoryPo.cstibilltypeid" id="cstibilltypeid" value="1" /></TD>
					   		<input type="hidden" id="cstisupplierid" name="inventoryPo.cstisupplierid" value="${inventoryPo.cstisupplierid == '' ? procurementOrdersEntryPos[0].bspid : inventoryPo.cstisupplierid}">
						  </TD>
						  <TD class="table_body">收入仓位</TD>
                          <TD class="table_none" >
                            <select id="cstiinstockid" name="inventoryPo.cstiinstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收入仓位！'}]">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${bwhid!= warehouseConfigurationPo.bwcstockid3  ? '' : 'selected="selected"' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
                          <TD class="table_body">运单号</TD>
                          <TD class="table_none">
                          	<input type="text" class="text_input160" maxlength="32" id="deliveryID" name="inventoryPo.deliveryID" value="${inventoryPo.deliveryID}" >
                          </TD>						
						  </TR>
                        <TR>
                          <TD height="26" class="table_body">制单人</TD>
                          <TD class="table_none" >${person.personName }<input type="hidden" name="inventoryPo.csticreateperson" value="${person.id}"></TD>
                          <TD class="table_body">单据日期</TD>
                          <TD class="table_none" colspan="3">
                          <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input id="cstibilldate" name="inventoryPo.cstibilldate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>					       
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5 ><label>
                          <textarea id="textarea" name="inventoryPo.cstiremark"></textarea>
                          </label></TD>
                        </TR>
                    <tr>
                       	<TD width="9%" height="26" class="table_body">文档路径</TD>
		               	<TD class="table_none" colspan="5">
		               	<input type="file" name="upload" id="file" style="width: 600" onchange="CheckExt(this)"><label style="color:red;">&nbsp;*&nbsp;文件格式为 .xls </label>
		               	<img id="button1" src="${ctx}/img/newbtn/btn_import2_0.png" btn=btn  tltle='导入' onclick="importFile();">
		               	</TD>
                    </tr>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
	                          	<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" title='保存' onclick="save();">
                           	</TD>
                           	<TD  align="right" width="40%">
					      <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">&nbsp;
					      <img src="${ctx }/img/newbtn/btn_delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');" title="删除" onClick="deleteitem();" >
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
                          <TH width="6%" scope=col>数量</TH>
                          <TH width="9%" scope=col>商品条码</TH>
                        </TR>
                    	<TR class=table_title align=middle> 
						  	<TH width="40%" height="26" id="heji" colSpan=3 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%"  id="goodsquantityTotal">0</TH>
					    	<TH scope=col width="5%">&nbsp;</TH>
				   		</TR>  
				   		<c:forEach var="po" items="${goodsInfoPos}">
				   		<TR class="row">
                        <TD height="28"><input id="chk" type="checkbox" value="${po.bgigoodsid}" ></TD>
                        <TD>${po.bgigoodsid}
                        <input type="hidden" name="goodsInfoTempPo.goodsid" value="${po.bgigoodsid}" />
                        <input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="${po.bgigoodsbarcode}" />
                        <input type="hidden" name="goodsInfoTempPo.costprice" value="${po.bgicostprice}" />
                        <input type="hidden" name="goodsInfoTempPo.nottaxrate" value="${po.bginottaxrate}" />
                        <input type="hidden" name="goodsInfoTempPo.taxrate" value="${po.bgitaxrate}" />
                        <input type="hidden" id="goodsname" value="${po.bgigoodsname}" />
                        <input type="hidden" id="source" value="${po.bgisource}" />
                        <input type="hidden" id="spec" value="${po.bgispec }" />
                        <input type="hidden" id="color" value="${po.bgicolor}" />
                        <input type="hidden" id="retailprice" value="${po.bgiretailprice}" />
                        <input type="hidden" id="registrationnum" name="goodsInfoTempPo.registrationnum"  value=""/>
                        </TD>
                        <TD>${po.bgigoodsname}</TD>
                        <TD><input type="text" class="text_input40" pid="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="${po.bgigoodsquantity}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/></TD>
                        <td><input type="text" class="text_input200" onBlur="barcodes('${po.bgigoodsid}',this)" maxlength="26" name="goodsInfoTempPo.pcbarcode" id="pcbarcode" readonly="readonly" index="${idx.index }" value='${po.bgigoodsbarcode}' /></td>
                        </TR>
				   		</c:forEach>                    
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
                          		<li class="horizontal_onlyRight">
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" title='保存' onclick="save();">
                          		</li>
                          		<c:if test="${(permissionPo.keyk==1)}">
                          		<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstiauditstate" onclick="check1()" name="inventoryPo.cstiauditstate" value="1">保存并审核
                          		</li>
                          		</c:if>
                           	</TD>
					   </TR>
                    </TABLE>
                  </DIV>
                </DIV>
                </TD>
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