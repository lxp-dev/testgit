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
		procurementReceiptForm.action = "addProcurementReceiptDimension.action";
		procurementReceiptForm.submit();
	}

	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
		}
		
		amount();
	}	
	function batPrintGoodsBarCode(){
		var flag = false;
		
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			var persons = $("input[id=person]");
			var barCodes = $("input[id=pcbarcode]");
			var goodsQuantitys = $("input[id=quantity]");
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
	
	function barcodes(goodsid,goodsbarcode){
		if(goodsbarcode.value==''){
			return;
		}
		var tmp = goodsid.replace(/\./g,  "").toUpperCase();
		var tmp1 = goodsbarcode.value.substring(0,18);
		tmp1 = tmp1.toUpperCase();
		//alert(tmp1);
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
		
		//var cstpgoodscategory = $('#cstigoodscategory').val();
		
		
		if(goodsquantityCount==0){
          alert('请选择商品!');
          return false;
        }
        
		//验证商品类别和制造商是否与添加商品一样
		var supplierID=document.all.cstisupplierid.value;
		var chk=document.getElementsByName("chk");
		var length = chk.length;
		
		var re = new RegExp();
		re.compile("^[1-9]\." + supplierID.toUpperCase());
		for(i = 0; i < length; i++){
			if(!re.test(chk[i].value.toUpperCase())){
				alert("制造商与添加的商品不匹配！");
				return;	
			}		
		}
		var cstiauditstate=0;
		if ($("#cstiauditstate").checked==true){
		    cstiauditstate=1;
		}	
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var goodsids = document.getElementsByName('goodsInfoTempPo.goodsid');
		var goodsbarcodes = document.getElementsByName('goodsInfoTempPo.pcbarcode');
		
		var size = goodsids.length;
		var submittype = 'a';
		for(var i = 0; i < size; i++){
			if(goodsids[i].value.replace(/\./g,"").toUpperCase()!=goodsbarcodes[i].value.substring(0,18)){
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
		</c:if>	
		$("img").removeAttr("onclick");
		procurementReceiptForm.action = "updateProcurementReceipt.action?cstiauditstate="+cstiauditstate;
		procurementReceiptForm.submit();
		}
	}

	function openOrders(){	
		var supplierID=document.all.cstisupplierid.value;
		var supplierName=$('#supplierName').val();
		var categoryID_open='';
		var category = $('#cstigoodscategory').val();
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
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initProcurementOrdersForOpen.action?poType="+poType+"&updatepage=u&supplierID="+supplierID+"&supplierName="+supplierName+"&category="+category,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementOrdersForOpen.action?poType="+poType+"&updatepage=u&supplierID="+supplierID+"&supplierName="+supplierName+"&category="+category,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【采购订单查询】";
	}		
	function openGoodSingle(){
		var supplierID=document.all.cstisupplierid.value;
		var categoryID_open=$('#cstigoodscategory').val();
		var cstibillid=document.getElementById('cstibillid').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
	    var iscustomize=""; 
	    if(categoryID_open=='3'||categoryID_open=='4')
    	{
    		iscustomize="0";
	    }
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var moduleID=document.all.moduleID.value;
		
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open="+supplierID+"&iscustomize="+iscustomize+"&moduleID="+moduleID+"&cstibillid="+cstibillid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open="+supplierID+"&iscustomize="+iscustomize+"&moduleID="+moduleID+"&cstibillid="+cstibillid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	}
	
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
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
						else if(goodInfo.bgistealthclass=="8"){string6='塑形镜';}
						else{string6='';}
		c18.innerHTML = string6;
		c19.innerHTML = goodInfo.bgisph;
		c20.innerHTML = goodInfo.bgisuppliercolor;
		c21.innerHTML = goodInfo.bgicapacity;
		c22.innerHTML = goodInfo.bgicapacityentry;
		c23.innerHTML = document.all.cstibilldate.value+'<input type="hidden" class="text_input100" maxlength="26" id="bgirksj" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="'+document.all.cstibilldate.value+'" /><input type="hidden" class="text_input100" maxlength="26" index="'+index+'" readonly="readonly" id="registrationnum" name="goodsInfoTempPo.registrationnum" value="" />';
		
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c24.innerHTML = '<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode.toUpperCase()+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			c25.innerHTML = '<input type="text" onkeydown="OnKeyDownEnter(this)" class="text_input40" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c24.innerHTML = '<input type="hidden" id="pcbarcode"  index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode.toUpperCase()+'"><input type="text" class="text_input40" onkeydown="OnKeyDownEnter(this)" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}
    }
	function openProcurementOrdersValues(objValue,poID){
		
		document.all.cstisourcebillid.value=poID;
		
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			addRow2(goodInfos[i]);			
		}	
		var ordertype = goodInfos[0].bgigoodsid.substring(0,1);
		$('#goodstype').val(ordertype);
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
	}
	
	function addRow2(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
//			if (chk[i].value == goodInfo.bgigoodsid) return;
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
	if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			var c11 = row.insertCell(10);
			var c12 = row.insertCell(11);
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			var c11 = row.insertCell(10);
		}
		
		c5.id="ys";
		c6.id="qj";
		c7.id="zj";
		c8.id="zx";
		c9.id="ql";
		c10.id="zhj";
		
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="text" id="color" value="' + goodInfo.bgicolor +'" /><input type="text" id="spec" value="' + goodInfo.bgispec +'" /><input type="text" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="text" id="goodsname" value="' + goodInfo.bgigoodsname +'" /><input type="text" id="source" value="' + goodInfo.bgisource +'" />';
       
        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" id="brandname" value="' + goodInfo.bgibrandname +'" /><input type="hidden" class="text_input100" maxlength="26" index="'+index+'" readonly="readonly" id="registrationnum" name="goodsInfoTempPo.registrationnum" value="" />';
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgicolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgiaxis;
		c9.innerHTML = goodInfo.bgicurvature1;
		c10.innerHTML = goodInfo.bgidia;
		if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
		{
			c11.innerHTML = '<input type="text" class="text_input200" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" maxlength="26" name="goodsInfoTempPo.pcbarcode" id="pcbarcode" readonly="readonly" index="'+index+'" value="'+goodInfo.bgipcbarcode.toUpperCase()+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
			c12.innerHTML = '<input type="text" class="text_input40" onkeydown="OnKeyDownEnter(this)" id="quantity" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
			
		}
		if(${systemParameterPo.fspbarcodetype}=='3')
		{
			c11.innerHTML = '<input type="hidden" id="pcbarcode"  index="'+index+'" name="goodsInfoTempPo.pcbarcode" value="'+goodInfo.bgipcbarcode.toUpperCase()+'"><input type="text" class="text_input40" onkeydown="OnKeyDownEnter(this)" id="quantity" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}
		
		isshow($('#cstigoodscategory').val());
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
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID='';
		
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
	
	$(document).ready(function(){
		isshow('${fn:substring(inventoryEntryList[0].cstiegoodsid,0,1) == '' ? fn:substring(goodsInfoPos[0].bgigoodsid,0,1):fn:substring(inventoryEntryList[0].cstiegoodsid,0,1)}');
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
	
	/**
	*  二维表开窗事件
	*/
	function open2D(){
		if ($('#cstigoodscategory').val() != '3' && $('#cstigoodscategory').val() != '4'){
	        alert("请选择镜片或隐形镜片商品!");
	        return;
	    }
	    
		var chaasupplier =document.getElementById('cstisupplierid').value;
	    if(chaasupplier==''){
		    alert('请选择制造商');
		    return false;
	    }
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
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
		if(is_iPad()){
			showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory="+'${fn:substring(inventoryEntryList[0].cstiegoodsid,0,1) == '' ? fn:substring(goodsInfoPos[0].bgigoodsid,0,1):fn:substring(inventoryEntryList[0].cstiegoodsid,0,1)}'+"&bspsuppliername="+EncodeUtf8($('#cstisuppliername').val())+"&cstpsupplierid="+$('#cstisupplierid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory="+'${fn:substring(inventoryEntryList[0].cstiegoodsid,0,1) == '' ? fn:substring(goodsInfoPos[0].bgigoodsid,0,1):fn:substring(inventoryEntryList[0].cstiegoodsid,0,1)}'+"&bspsuppliername="+EncodeUtf8($('#cstisuppliername').val())+"&cstpsupplierid="+$('#cstisupplierid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var index = table.rows.length - 1;
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
        c2.innerHTML = goodInfo.goodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.goodsid +'" /><input type="hidden" id="color" value="' + goodInfo.coler +'" /><input type="hidden" id="spec" value="' + goodInfo.spec +'" /><input type="hidden" id="retailprice" value="' + goodInfo.retailPrice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.costPrice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.notTaxRate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.taxRate +'" /><input type="hidden" id="goodsname" value="' + goodInfo.goodsName +'" /><input type="hidden" class="text_input100" maxlength="26" index="'+index+'" readonly="readonly" id="registrationnum" name="goodsInfoTempPo.registrationnum" value="" />';
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
			c24.innerHTML = '<input type="text" class="text_input40" onkeydown="OnKeyDownEnter(this)" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		
		}
		if('${systemParameterPo.fspbarcodetype}'=='3')
		{
			c23.innerHTML = '<input type="hidden" id="pcbarcode" onBlur="barcodes(\''+goodInfo.bgigoodsid+'\',this)" index="'+index+'" name="goodsInfoTempPo.pcbarcode" index="'+index+'" value="'+goodInfo.bgipcbarcode.toUpperCase()+'"><input type="text" class="text_input40" maxlength="18" id="quantity" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
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
        
    function setValue(billid,id,name,type){
    	var cstibillid = $('#cstibillid').val();
		procurementReceiptForm.action="initInsertProcurementReceipt.action?hid="+billid+"&type="+type+"&cstibillid="+cstibillid;
		procurementReceiptForm.submit();
    }
    
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

    function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=goodsInfoTempPo.goodsquantity]").index(obj)+1;
		    $("input[name=goodsInfoTempPo.goodsquantity]").eq(index).focus();
		}
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
      if($("#cstiauditstate1").attr("checked"))
      {
      	$("#cstiauditstate").attr("checked","checked");	
      }else
      {
      	$("#cstiauditstate").attr("checked","");	
      }
    }
    
     function check1()
    {
      if($("#cstiauditstate").attr("checked"))
      {
      	$("#cstiauditstate1").attr("checked","checked");	
      }else
      {
      	$("#cstiauditstate1").attr("checked","");	
      }
    }
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="goodstype" name="goodstype" value="${goodstype }">
<input type="hidden" id="person" value="${person.id }"/>
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />
<input type="hidden" id="ioru" name="ioru" value="u" />
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
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>
                          <TD height="27" width="9%" class="table_body" height="27">单据编号</TD>
                          <TD width="23%" class="table_none">${inventoryPo.cstibillid}<input type="hidden" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}"></TD>
                         
                          <TD height="27" width="9%" class="table_body" height="27">订单单号</TD>
                          <TD width="23%" class="table_none">${inventoryPo.cstisourcebillid}&nbsp;<input type="hidden" name="inventoryPo.cstisourcebillid" id="cstisourcebillid" value="${inventoryPo.cstisourcebillid}" /></TD>
                          <TD height="27" width="9%" class="table_body">入库类型</TD>
                          <TD class="table_none">${inventoryPo.cstigoodscategoryname}
                          <input type="hidden" name="inventoryPo.cstibilltypeid" id="cstibilltypeid" value="${inventoryPo.cstibilltypeid}" /> 
                          <input type="hidden" id="cstigoodscategory" value="${fn:substring(inventoryEntryList[0].cstiegoodsid,0,1) == '' ? fn:substring(goodsInfoPos[0].bgigoodsid,0,1):fn:substring(inventoryEntryList[0].cstiegoodsid,0,1)}" /> 
						  </TD>
                        </TR>
                        <TR>  
                          
						  <TD height="27" class="table_body">制造商</TD>
						   <TD class="table_none">
                                ${inventoryPo.cstisuppliername}
                                <input type="hidden" id="cstisuppliername" value="${inventoryPo.cstisuppliername}"/>
						   		<input type="hidden" id="cstisupplierid" name="inventoryPo.cstisupplierid" value="${inventoryPo.cstisupplierid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   </TD>
						   <TD class="table_body" height="27">收入仓位</TD>
                           <TD class="table_none" >
                            <select id="cstiinstockid" name="inventoryPo.cstiinstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收入仓位！'}]">
      		                   <option value="">请选择收入仓位</option>
      		                  <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${inventoryPo.cstiinstockid == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                  </s:iterator>
      	                    </select>
                           </TD>
                          <TD width="9%" class="table_body">运单号</TD>
                          <TD class="table_none"><input type="text" class="text_input160" maxlength="32" name="inventoryPo.deliveryID" id="deliveryID" value="${inventoryPo.deliveryID }" /></TD>
                          
						 </TR>
						<TR>
                          <TD height="27" class="table_body" >制单人</TD>
                          <TD class="table_none" >${inventoryPo.csticreatepersonname}<input type="hidden" name="inventoryPo.csticreateperson" value="${inventoryPo.csticreateperson}"></TD>
 						  <TD class="table_body" height="27">单据日期</TD>
                          <TD class="table_none" colspan="3">
                          ${fn:substring(inventoryPo.cstibilldate,0,10)}
                          <input id="cstibilldate" class="text_input200" name="inventoryPo.cstibilldate" type="hidden" value="${fn:substring(inventoryPo.cstibilldate,0,10)}"/></TD>
                        </TR>
                        <TR>
                          <TD height="27" class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          <textarea id="textarea" name="inventoryPo.cstiremark">${inventoryPo.cstiremark}</textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" width="60%">
						   <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" 
						  onClick="javascript:openGoodSingle();">
						  <!--  <img src="${ctx}/img/newbtn/btn_acgddgoods_0.png" btn=btn title="按采购订单添加商品" 
						  onClick="javascript:openOrders();">-->
					       <img src="${ctx}/img/newbtn/btn_addtwogoods_0.png" btn=btn title="二维表添加商品" id="2D"
					      onClick="javascript:open2D();">
					        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
					       <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();">
					      </c:if>
					     </TD>
					     <TD align="right" width="40%">
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
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();">
                          		</li>
                          		<c:if test="${(permissionPo.keyk==1)}">
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
                          <TH width="8%" height="27" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="14%" scope=col>商品代码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
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
                          <TH width="6%" scope=col id=rksj>入库时间 </TH>
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH width="9%" scope=col>商品条码</TH>
                          </c:if>
                          <TH width="6%" scope=col>数量</TH>                           
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="27" id="heji" colSpan=12 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <TR class="row">
                        <TD height="28"><input id="chk" type="checkbox" value="${cstiegoodsid}" ></TD>
                        <TD>${cstiegoodsid}
                        <input type="hidden" name="goodsInfoTempPo.goodsid" value="${cstiegoodsid}" />
                        <input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="${fncstiebarcode}" />
                        <input type="hidden" name="goodsInfoTempPo.costprice" value="${cstiecostprice}" />
                        <input type="hidden" name="goodsInfoTempPo.nottaxrate" value="${cstienottaxrate}" />
                        <input type="hidden" name="goodsInfoTempPo.taxrate" value="${cstietaxrate}" />
                        <input type="hidden" id="goodsname" value="${cstiegoodsname}" />
                        <input type="hidden" id="source" value="${cstiesource}" />
                        <input type="hidden" id="spec" value="${cstiespec}" />
                        <input type="hidden" id="color" value="${cstiecolor}" />
                        <input type="hidden" id="retailprice" value="${cstieretailprice}" />
                        <input type="hidden" id="brandname" value="${cstiebrandname}" />
                        <input type="hidden" id="registrationnum" name="goodsInfoTempPo.registrationnum"  value=""/>
                        </TD>
                        <TD>${cstiegoodsname}</TD>
                        <TD>${cstiespec}</TD>
                      	  <td  id=ys>${cstiecolor}</td>
                          <td  id=qj>${cstiesph}</td>
                          <td  id=zj>${cstiecyl}</td>
                          <td  id=xjg>${bgibelowplusluminosity}</td>
                          <td  id=zsl>${bgirefractive}</td>
                          <td  id=gdfl> <c:if test="${bgiismutiluminosity=='M'}">  多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}"> 单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}"> 其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}"> 抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}"> 渐近</c:if>
                          </td>
                          <td id=clfl>	<c:if test="${bgieyeglassmaterialtype=='1'}"> 树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}"> 玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}"> PC</c:if>		</td>
                          <td id=ql>${cstiecurvature1}</td>
                          <td id=zhj>${cstiedia}</td> 
                          <td id=kjcz>${bgiframematerialtypename}
	                          </td>
                          <td id=kjcc>${bgiframesize}</td>
                          <td id=pjlx> 	<c:if test="${bgiaccessoriestype=='1'}"> 框镜</c:if>
		                          	<c:if test="${bgiaccessoriestype=='2'}"> 隐形</c:if></td>
                          <td id=sylx><c:if test="${bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${bgiusetype=='2'}">抛弃型</c:if> 
		                          	<c:if test="${bgiusetype=='3'}">塑形镜</c:if></td>
                          <td id=pqxfl>	<c:if test="${bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${bgistealthclass=='7'}"> RGP</c:if>	   
		                          	</td>
                          <td id=lhjds>${cstiesph}</Td>
                          <td id=cjsh>${bgisuppliercolor} </Td>
                          <td id=zrl>${bgicapacity}  </Td>
                          <Td id=crl>${bgicapacityentry}  </Td>
                          <Td id=rksj>${fn:substring(inventoryPo.cstibilldate,0,10)}<input type="hidden"  id="bgirksj"  readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="${fn:substring(inventoryPo.cstibilldate,0,10)}" /></Td>
                         <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                       <td><input type="text" class="text_input200" onBlur="barcodes('${cstiegoodsid}',this)" maxlength="26" name="goodsInfoTempPo.pcbarcode" id="pcbarcode" readonly="readonly" index="${idx.index }" value='${cstiebarcode}' /></td>
                       </c:if>
                        <TD><input type="text" class="text_input40" id="quantity" onkeydown="OnKeyDownEnter(this)" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="${cstiegoodsquantity}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/>
                        <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
                        <input type="hidden" name="goodsInfoTempPo.pcbarcode" id="pcbarcode" index="${idx.index }" value='${cstiebarcode}' />
                        </c:if>
                        </TD>                                                                        
                        </TR>
                        </s:iterator>
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
                        <TD>${po.bgispec }</TD>
                                               
                        <TD group=qj>${po.bgisph }</TD>
                        <TD group=zj>${po.bgicyl }</TD>
                        <td  id=xjg>${po.bgibelowplusluminosity}</td>
                          <td  id=zsl>${po.bgirefractive}</td>
                          <td  id=gdfl>${po.bgiismutiluminosity}
                          </td>
                          <td id=clfl>${po.bgieyeglassmaterialtype}
                          <td id=kjcz>${po.bgiframematerialtypename}
	                          </td>
	                      <td id=ql>${po.bgicurvature1}</td>
                          <td id=zhj>${po.bgidia}</td> 
                          <td id=kjcc>${po.bgiframesize}</td>
                          <td id=pjlx> 	<c:if test="${po.bgiaccessoriestype=='1'}"> 框镜</c:if>
		                          	<c:if test="${po.bgiaccessoriestype=='2'}"> 隐形</c:if></td>
                          <td id=sylx><c:if test="${po.bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${po.bgiusetype=='2'}">抛弃型</c:if> </td>
                          <td id=pqxfl>	<c:if test="${po.bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${po.bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${po.bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${po.bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${po.bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${po.bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${po.bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${po.bgistealthclass=='7'}"> RGP</c:if>	   
		                          	</td>
                          <td id=lhjds>${po.bgisph}</Td>
                          <td id=cjsh>${po.bgisuppliercolor} </Td>
                          <td id=zrl>${po.bgicapacity}  </Td>
                          <Td id=crl>${po.bgicapacityentry}  </Td>
                          <Td id=rksj>${fn:substring(inventoryPo.cstibilldate,0,10)}<input type="hidden"  id="bgirksj"  readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="${fn:substring(inventoryPo.cstibilldate,0,10)}" /></Td>
                        <td><input type="text" class="text_input200" onBlur="barcodes('${po.bgigoodsid}',this)" maxlength="26" name="goodsInfoTempPo.pcbarcode" id="pcbarcode" readonly="readonly" index="${idx.index }" value='${po.bgigoodsbarcode}' /></td>
                        <TD><input type="text" class="text_input40" id="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="${po.bgigoodsquantity }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/></TD>                                                                        
                        </TR>
				   		</c:forEach>   
                      </TBODY>
                    </TABLE>
                    </div>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
                          		<li class="horizontal_onlyRight">
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
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