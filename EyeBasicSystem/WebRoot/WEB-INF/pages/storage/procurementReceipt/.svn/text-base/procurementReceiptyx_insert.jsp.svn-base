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
    var index = 0;
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function addtdgoods(){
		deleteROWss();
		procurementReceiptForm.action = "addProcurementReceiptDimensionyx.action";
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
	//条码批量打印
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
			var guaranteeperiods = $("input[id=guaranteeperiod]");
			var batchs = $("input[id=batch]");
			
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
					/*alert(persons[0].value);
					alert(barCodes[i].value);
					alert(goodsQuantitys[i].value);
					alert(brandnames[i].value);
					alert(sources.eq(i).val());
					alert(colors[i].value);
					alert(retailprices[i].value);
					alert(guaranteeperiods[i].value);
					alert(batchs[i].value);*/
					person[person.length] = persons.val();
					barCode[barCode.length] = barCodes[i].value;
					quantity[quantity.length] = goodsQuantitys[i].value;
					
					brandname[brandname.length] = brandnames[i].value;
					source[source.length] = sources.eq(i).val();
					spec[spec.length] = specs[i].value;
					color[color.length] = colors[i].value;
					retailprice[retailprice.length] = retailprices[i].value;
					guaranteeperiod[guaranteeperiod.length] = guaranteeperiods[i].value;
					batch[batch.length] = batchs[i].value;
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
		
		if(goodsquantityCount==0){
          alert('请选择商品!');
          return false;
        }

		var cstpgoodscategory = document.getElementById('cstpgoodscategory').value;
		if(cstpgoodscategory == '4' || cstpgoodscategory == '5'){
			var guaranteeperiod = document.getElementsByName("goodsInfoTempPo.guaranteeperiod");
			for(i=0;i<guaranteeperiod.length;i++){
				
				if(guaranteeperiod[i].value==""){
					alert("请填写商品效期！");
					guaranteeperiod[i].focus();
					return;	
				}
			}
			
			var batch = document.getElementsByName("goodsInfoTempPo.batch");
			
			for(i=0;i<batch.length;i++){
				if(batch[i].value==""){
					alert("请填写商品批号！");
					batch[i].focus();
					return;	
				}
			}
			
			<c:if test="${systemParameterPo.fspisregistrationnum eq '1'}">
				var registrationnum = document.getElementsByName("goodsInfoTempPo.registrationnum");
				
				for(i=0;i<registrationnum.length;i++){
					if(registrationnum[i].value==""){
						alert("请填写商品注册证号！");
						registrationnum[i].focus();
						return;	
					}
				}
			</c:if>
		}
        
        var goodsids = document.getElementsByName('goodsInfoTempPo.goodsid');
		var goodsbarcodes = document.getElementsByName('goodsInfoTempPo.pcbarcode');
		
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
        
		//验证商品类别和制造商是否与添加商品一样
		var supplierID=document.all.cstisupplierid.value;
		var chk=document.getElementsByName("chk");
		var length = chk.length;
		
		var re = new RegExp();
		re.compile("^[1-9]\." + supplierID.toUpperCase());
		for(i = 0; i < length; i++){
			if(!re.test(chk[i].value.toUpperCase())){
				alert("制造商与添加的商品不匹配！");
				return false;
			}		
		}
		var cstiauditstate=0;
		if ($('input[name=inventoryPo.cstiauditstate]').size() > 0){
			if (document.getElementsByName("inventoryPo.cstiauditstate")[0].checked==true){
			    cstiauditstate=1;
			}
		}

			$("img").removeAttr("onclick");
			procurementReceiptForm.action = "insertProcurementReceiptyx.action?cstiauditstate="+cstiauditstate;
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
		var categoryID_open=document.getElementById('cstpgoodscategory').value;
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

		var supplierID=document.all.cstisupplierid.value;
	    if(supplierID==''){
	    	alert('请选择所属制造商');
	   		return false;
	    }

	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var moduleID=document.all.moduleID.value;
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID+"&iscustomize="+iscustomize+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID+"&iscustomize="+iscustomize+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		index = accAdd(table.rows.length - 1,index);
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
		var c1 = row.insertCell(0);		//选择
		var c2 = row.insertCell(1);		//代码		
		var c3 = row.insertCell(2);		//名称
		var c4 = row.insertCell(3);		//规格
		var c5 = row.insertCell(4);		//球镜
		var c6 = row.insertCell(5);		//柱镜
		var c7 = row.insertCell(6);		//曲率
		var c8 = row.insertCell(7);		//直径
		var c9 = row.insertCell(8);		//使用类型
		var c10 = row.insertCell(9);	//抛弃型分类
		var c11 = row.insertCell(10);	//主容量
		var c12 = row.insertCell(11);	//次容量
		var c13 = row.insertCell(12);	//效期
		var c14 = row.insertCell(13);	//批号
		var c15 = row.insertCell(14);	//注册证号
		var c16 = row.insertCell(15);	
		var c17 = row.insertCell(16);	

		c4.id="spectt";	
		c5.id="qj";
		c6.id="zj";
		c7.id="ql";
		c8.id="zhj";
		c9.id="sylx";
		c10.id="pqxfl";
		c11.id="zrl";
		c12.id="crl";
		c13.id="xq";
		c14.id="xq1";
		c15.id="xq2";
				
		row.className = 'row';
		row.height="26";

		var string5='';
		var string6='';
		
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';} 
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';} 
		else{string5='';}

		if(goodInfo.bgistealthclass=="1"){string6='日抛';}
		else if(goodInfo.bgistealthclass=="2"){string6='周抛';} 
		else if(goodInfo.bgistealthclass=="9"){string6='双周抛';}
		else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
		else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
		else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
		else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
		else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
		else if(goodInfo.bgistealthclass=="8"){string6='塑形镜';}
		else{string6='';}

        if (typeof(goodInfo.guaranteeperiod) == 'undefined'){
        	goodInfo.guaranteeperiod = '';
        }
        if (typeof(goodInfo.batch) == 'undefined'){
        	goodInfo.batch = '';
        }
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = "<img src=\"${ctx}/img/newbtn/addgoods_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');\" btn=btn title='复制商品' onClick=\"copyRow(this,{'bgigoodsid':'"+goodInfo.bgigoodsid+"','bgigoodsname':'"+goodInfo.bgigoodsname+"','bgispec':'"+goodInfo.bgispec+"','bgisph':'"+goodInfo.bgisph+"','bgicyl':'"+goodInfo.bgicyl+"','bgicurvature1':'"+goodInfo.bgicurvature1+"','bgidia':'"+goodInfo.bgidia+"','bgiusetype':'"+goodInfo.bgiusetype+"','bgistealthclass':'"+goodInfo.bgistealthclass+"','bgicapacity':'"+goodInfo.bgicapacity+"','bgibrandname':'"+goodInfo.bgibrandname+"','bgicapacityentry':'"+goodInfo.bgicapacityentry+"','bgipcbarcode':'"+goodInfo.bgipcbarcode+"','bgigoodsquantity':'','bgisource':'"+goodInfo.bgisource+"','bgiretailprice':'"+goodInfo.bgiretailprice+"','bgicostprice':'"+goodInfo.bgicostprice+"','bginottaxrate':'"+goodInfo.bginottaxrate+"','bgitaxrate':'"+goodInfo.bgitaxrate+"','bgicolor':'"+goodInfo.bgicolor+"','bgiregistrationnum':'"+goodInfo.bgiregistrationnum+"'});\">"+goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="color" value="' + goodInfo.bgicolor +'" /><input type="hidden" id="spec" value="' + goodInfo.bgispec +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="hidden" id="goodsname" value="' + goodInfo.bgigoodsname +'" /><input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgisph;		
		c6.innerHTML = goodInfo.bgicyl;				
		c7.innerHTML = goodInfo.bgicurvature1;
		c8.innerHTML = goodInfo.bgidia;
		
		c9.innerHTML = string5;
		c10.innerHTML = string6;
		c11.innerHTML = goodInfo.bgicapacity+'<input type="hidden" id="brandname" value="'+goodInfo.bgibrandname+'"/>';
		c12.innerHTML = goodInfo.bgicapacityentry;

		c13.innerHTML = '<input type="hidden" class="text_input100" maxlength="26" id="bgirksj" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="'+document.all.cstibilldate.value+'" />'+'<input type="text" class="text_input80" id="guaranteeperiod" name="goodsInfoTempPo.guaranteeperiod"  onblur="changebarcode('+index+',$(this));loadSimpleBatch('+index+',$(this).parent().parent().find(\'#pcbarcode\').val(),$(this).parent().parent().find(\'#batch\').val(),this);" value="' + goodInfo.guaranteeperiod + '"/>'
		c14.innerHTML = '<input type="text" class="text_input80" maxlength="15" id="batch" name="goodsInfoTempPo.batch"  value="' + goodInfo.batch + '" onblur="loadSimpleBatch('+index+',$(this).parent().parent().find(\'#pcbarcode\').val(),$(this).val(),this);"/>';
		c15.innerHTML = '<input type="text" class="text_input80" maxlength="26" id="registrationnum" index="'+index+'" name="goodsInfoTempPo.registrationnum"  value="'+goodInfo.bgiregistrationnum +'" />';
		
		c16.innerHTML = '<input type="text" class="text_input200" maxlength="26" id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode.substring(0,24)+'A0'+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
		c17.innerHTML = '<input type="text" class="text_input40" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
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
		procurementReceiptForm.action="initProcurementReceiptyxInsert.action";
		procurementReceiptForm.submit();
	}
	
	$(document).ready(function(){
		<s:iterator value="goodsInfoPos">
	     var json = {'bgigoodsid':'${bgigoodsid}','bgigoodsbarcode':'${bgigoodsbarcode}',
	     				'bgigoodsname':'${bgigoodsname}','bgiunitname':'${bgiunitname}','bgicostprice':'${bgicostprice}',
	     				'bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}','bginottaxrate':'${bginottaxrate}',
	     				'bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
	     				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
	     				'bgigoodsquantity':'','bgipcbarcode':'${bgigoodsbarcode }',
	     				'bgiframematerialtype':'${bgiframematerialtype }','bgiframesize':'${bgiframesize}','bgiaccessoriestype':'${bgiaccessoriestype}',
	                    'bgibelowplusluminosity':'${bgibelowplusluminosity }','bgirefractive':'${bgirefractive}','bgiismutiluminosity':'${bgiismutiluminosity}',
	                    'bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgiusetype':'${bgiusetype}','bgistealthclass':'${bgistealthclass}',
	                    'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry}','bgisuppliercolor':'${bgisuppliercolor}',
	     				'bgisource':'${bgisource}','bgiregistrationnum':'${bgiregistrationnum}'};
	    addRow2(json);                
		</s:iterator>
		
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
	                    'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry}','bgisuppliercolor':'${bgisuppliercolor}',
	     				'bgisource':'${bgisource}','bgiregistrationnum':'${bgiregistrationnum}'};
	    addRow2(json);                
		</s:iterator>		
		
		<s:iterator value="procurementOrdersEntryPos">		
	     var json = {'bgigoodsid':'${cstpegoodsid}','bgigoodsbarcode':'${bgiGoodsBarCode}','bgigoodsname':'${bgigoodsname}',
	     				'bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}','bginottaxrate':'${bginottaxrate}',
	     				'bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
	     				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
	     				'bgigoodsquantity':'${cstpeordernumber}','bgipcbarcode':'${bgiGoodsBarCode }'+'00000000',
	     				'bgiframematerialtype':'${bgiframematerialtype }','bgiframesize':'${bgiframesize}','bgiaccessoriestype':'${bgiaccessoriestype}',
	                    'bgibelowplusluminosity':'${bgibelowplusluminosity }','bgirefractive':'${bgirefractive}','bgiismutiluminosity':'${bgiismutiluminosity}',
	                    'bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgiusetype':'${bgiusetype}','bgistealthclass':'${bgistealthclass}',
	                    'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry}','bgisuppliercolor':'${bgisuppliercolor}',
	     				'bgisource':'${bgisource}','bgibrandname':'${cstpebrandname}','bgiregistrationnum':'${bgiregistrationnum}'};	     				
	    addRow2(json);                
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
		index = accAdd(table.rows.length - 1,index);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		if(goodInfo.bgigoodsid.substr(0, 1)!='4')
		{
			for(i = 0; i < chk.length; i++){
				if (chk[i].value == goodInfo.bgigoodsid) return;
			}
		}
		
		var row = table.insertRow(table.rows.length);
		row.name="tr"
		var c1 = row.insertCell(0);		//选择
		var c2 = row.insertCell(1);		//代码		
		var c3 = row.insertCell(2);		//名称
		var c4 = row.insertCell(3);		//规格
		var c5 = row.insertCell(4);		//球镜
		var c6 = row.insertCell(5);		//柱镜
		var c7 = row.insertCell(6);		//曲率
		var c8 = row.insertCell(7);		//直径
		var c9 = row.insertCell(8);		//使用类型
		var c10 = row.insertCell(9);	//抛弃型分类
		var c11 = row.insertCell(10);	//主容量
		var c12 = row.insertCell(11);	//次容量
		var c13 = row.insertCell(12);	//效期
		var c14 = row.insertCell(13);	//批号
		var c15 = row.insertCell(14);	//注册证号
		var c16 = row.insertCell(15);	//条码
		var c17 = row.insertCell(16);	//数量
		c4.id="spectt";
		c5.id="qj";
		c6.id="zj";
		c7.id="ql";
		c8.id="zhj";
		c9.id="sylx";
		c10.id="pqxfl";
		c11.id="zrl";
		c12.id="crl";
		c13.id="xq";
		c14.id="xq1";
		c15.id="xq2";
		var string6='';
		var string5='';
		
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';} 
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';} 
		else{string5='';}

		if(goodInfo.bgistealthclass=="1"){string6='日抛';}
		else if(goodInfo.bgistealthclass=="2"){string6='周抛';} 
		else if(goodInfo.bgistealthclass=="9"){string6='双周抛';}
		else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
		else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
		else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
		else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
		else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
		else if(goodInfo.bgistealthclass=="8"){string6='塑形镜';}
		else{string6='';}

        if (typeof(goodInfo.guaranteeperiod) == 'undefined'){
        	goodInfo.guaranteeperiod = '';
        }
        if (typeof(goodInfo.batch) == 'undefined'){
        	goodInfo.batch = '';
        }
        
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = "<img src=\"${ctx}/img/newbtn/addgoods_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');\" btn=btn title='复制商品' onClick=\"copyRow(this,{'bgigoodsid':'"+goodInfo.bgigoodsid+"','bgigoodsname':'"+goodInfo.bgigoodsname+"','bgispec':'"+goodInfo.bgispec+"','bgisph':'"+goodInfo.bgisph+"','bgicyl':'"+goodInfo.bgicyl+"','bgicurvature1':'"+goodInfo.bgicurvature1+"','bgidia':'"+goodInfo.bgidia+"','bgiusetype':'"+goodInfo.bgiusetype+"','bgistealthclass':'"+goodInfo.bgistealthclass+"','bgicapacity':'"+goodInfo.bgicapacity+"','bgibrandname':'"+goodInfo.bgibrandname+"','bgicapacityentry':'"+goodInfo.bgicapacityentry+"','bgipcbarcode':'"+goodInfo.bgipcbarcode+"','bgigoodsquantity':'','bgisource':'"+goodInfo.bgisource+"','bgiretailprice':'"+goodInfo.bgiretailprice+"','bgicostprice':'"+goodInfo.bgicostprice+"','bginottaxrate':'"+goodInfo.bginottaxrate+"','bgitaxrate':'"+goodInfo.bgitaxrate+"','bgicolor':'"+goodInfo.bgicolor+"','bgiregistrationnum':'"+goodInfo.bgiregistrationnum+"'});\">"+goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="color" value="' + goodInfo.bgicolor +'" /><input type="hidden" id="spec" value="' + goodInfo.bgispec +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="hidden" id="goodsname" value="' + goodInfo.bgigoodsname +'" /><input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgisph;		
		c6.innerHTML = goodInfo.bgicyl;				
		c7.innerHTML = goodInfo.bgicurvature1;
		c8.innerHTML = goodInfo.bgidia;

		c9.innerHTML = string5;
		c10.innerHTML = string6;
		
		c11.innerHTML = goodInfo.bgicapacity+'<input type="hidden" id="brandname" value="'+goodInfo.bgibrandname+'"/>';
		c12.innerHTML = goodInfo.bgicapacityentry;

		c13.innerHTML = '<input type="hidden" class="text_input100" maxlength="26" id="bgirksj" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="'+document.all.cstibilldate.value+'" />'+'<input type="text" class="text_input80" id="guaranteeperiod" name="goodsInfoTempPo.guaranteeperiod" onblur="changebarcode('+index+',$(this));loadSimpleBatch('+index+',$(this).parent().parent().find(\'#pcbarcode\').val(),$(this).parent().parent().find(\'#batch\').val(),this);" value="' + goodInfo.guaranteeperiod +'"/>'
		c14.innerHTML = '<input type="text" class="text_input80" maxlength="15" id="batch" onblur="loadSimpleBatch('+index+',$(this).parent().parent().find(\'#pcbarcode\').val(),$(this).val(),this);" name="goodsInfoTempPo.batch"  value="' + goodInfo.batch +'"/>';
		c15.innerHTML = '<input type="text" class="text_input80" maxlength="26" id="registrationnum" index="'+index+'" name="goodsInfoTempPo.registrationnum"  value="'+goodInfo.bgiregistrationnum +'" />';
		
		c16.innerHTML = '<input type="text" class="text_input200" maxlength="26"  id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode.substring(0,24)+'A0'+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';	
		c17.innerHTML = '<input type="text" class="text_input40" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
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
		if ($('#cstpgoodscategory').val() != '4'){
	        alert("请选择隐形镜片商品!");
	        return;
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
		    if ($(this).val() != '' && $(this).val() != null){
		    	goodsNumNew = goodsNumNew+$(this).val()+",";
			}else{
			    goodsNumNew = goodsNumNew+"1"+",";
			}    	
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
	    index = accAdd(table.rows.length - 1,index);
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
		var c5 = row.insertCell(4);		//球镜
		var c6 = row.insertCell(5);		//柱镜
		var c7 = row.insertCell(6);		//曲率
		var c8 = row.insertCell(7);		//直径
		var c9 = row.insertCell(8);		//使用类型
		var c10 = row.insertCell(9);	//抛弃型分类
		var c11 = row.insertCell(10);	//主容量
		var c12 = row.insertCell(11);	//次容量
		var c13 = row.insertCell(12);	
		var c14 = row.insertCell(13);	
		var c15 = row.insertCell(14);	//条码
		var c16 = row.insertCell(15);	//数量
		c4.id="spectt";
		c5.id="qj";
		c6.id="zj";
		c7.id="ql";
		c8.id="zhj";
		c9.id="sylx";
		c10.id="pqxfl";
		c11.id="zrl";
		c12.id="crl";
		c13.id="xq";
		c14.id="xq1";
		
		row.className = 'row';
		row.height="26";
		var string6='';
		var string5='';
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.goodsid + '" >';
        c2.innerHTML = "<img src=\"${ctx}/img/newbtn/addgoods_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');\" btn=btn title='复制商品' onClick=\"copyRow(this,{'bgigoodsid':'"+goodInfo.bgigoodsid+"','bgigoodsname':'"+goodInfo.bgigoodsname+"','bgispec':'"+goodInfo.bgispec+"','bgisph':'"+goodInfo.bgisph+"','bgicyl':'"+goodInfo.bgicyl+"','bgicurvature1':'"+goodInfo.bgicurvature1+"','bgidia':'"+goodInfo.bgidia+"','bgiusetype':'"+goodInfo.bgiusetype+"','bgistealthclass':'"+goodInfo.bgistealthclass+"','bgicapacity':'"+goodInfo.bgicapacity+"','bgibrandname':'"+goodInfo.bgibrandname+"','bgicapacityentry':'"+goodInfo.bgicapacityentry+"','bgipcbarcode':'"+goodInfo.bgipcbarcode+"','bgigoodsquantity':'','bgisource':'"+goodInfo.bgisource+"','bgiretailprice':'"+goodInfo.bgiretailprice+"','bgicostprice':'"+goodInfo.bgicostprice+"','bginottaxrate':'"+goodInfo.bginottaxrate+"','bgitaxrate':'"+goodInfo.bgitaxrate+"','bgicolor':'"+goodInfo.bgicolor+"','bgiregistrationnum':'"+goodInfo.bgiregistrationnum+"'});\">"+goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="color" value="' + goodInfo.bgicolor +'" /><input type="hidden" id="spec" value="' + goodInfo.bgispec +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="hidden" id="goodsname" value="' + goodInfo.bgigoodsname +'" /><input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
        c3.innerHTML = goodInfo.goodsName;
		c4.innerHTML = goodInfo.spec;
		
		c5.innerHTML = goodInfo.sph;
		c6.innerHTML = goodInfo.cyl;
		c7.innerHTML = goodInfo.curvature1;
		c8.innerHTML = goodInfo.dia;
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';} 
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';} 
		else{string5='';}
		c9.innerHTML = string5;
		if(goodInfo.bgistealthclass=="1"){string6='日抛';}
		else if(goodInfo.bgistealthclass=="2"){string6='周抛';} 
		else if(goodInfo.bgistealthclass=="9"){string6='双周抛';}
		else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
		else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
		else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
		else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
		else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
		else if(goodInfo.bgistealthclass=="8"){string6='塑形镜';}
		else{string6='';}
		c10.innerHTML = string6;
		c11.innerHTML = goodInfo.bgicapacity+'<input type="hidden" id="brandname" value="'+goodInfo.bgibrandname+'"/>';
		c12.innerHTML = goodInfo.bgicapacityentry;
		c13.innerHTML = '<input type="text" class="text_input80" id="guaranteeperiod" name="goodsInfoTempPo.guaranteeperiod" onblur="changebarcode('+index+',$(this));loadSimpleBatch('+index+',$(this).parent().parent().find(\'#pcbarcode\').val(),$(this).parent().parent().find(\'#batch\').val(),this);" value=""/>'
		c14.innerHTML = '<input type="text" class="text_input80" maxlength="15" id="batch"  onblur="changebarcode('+index+',$(this));loadSimpleBatch('+index+',$(this).parent().parent().find("#pcbarcode").val(),$(this).val(),this);" name="goodsInfoTempPo.batch"  value=""/>'
		c15.innerHTML = '<input type="text" class="text_input200" onblur="loadSimpleBatch('+index+',$(this).parent().parent().find(\'#pcbarcode\').val(),$(this).val(),this);" maxlength="26"  id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.pcbarcode.substring(0,24)+'A0'+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
		c16.innerHTML = '<input type="text" class="text_input40" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
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
    			$('[id=spec1]').hide();
    			$('[id=spec]').hide();
    			$('[id=spectt]').hide();
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
    			$('[id=spect1]').show();
    			$('[id=spec]').show();
    			$('[id=spectt]').show();
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=zrl]').show();
    			$('[id=crl]').show();
    			$('[id=ql]').hide();
    			$('[id=ql1]').hide();
    			$('[id=zhj]').hide();
    			$('#heji').attr("colSpan","10");
    			
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
			alert("日期格式不正确！\n例如：2013-04-01");
			obj.val("");
			obj.focus();
			return;
   	   	}
   	 	var str =obj.val();
   		str = str.replace(/-/g,"/");
   		var monthpart = str.split("/")[1];
   		if(monthpart == 0){
			alert("日期月份格式不正确！");
			obj.val("");
			obj.focus();
			return;
   	   	}
   		var daypart = str.split("/")[2];
   		if(daypart == 0){
			alert("日期天格式不正确！");
			obj.val("");
			obj.focus();
			return;
   	   	}
   		var date = new Date(str );
   		obj.val(ChangeDateToString(date));

		if(isNaN(obj.val().substring(0,4))){
			alert("日期格式不正确！\n例如：2013-04-01");
			obj.val("");
			obj.focus();
			return;
		}

		if(obj.val().substring(0,4) < new Date().getYear()){
			alert("日期格式不正确，失效日期不得小于当前年份！");
			obj.val("");
			obj.focus();
			return;
		}
   		
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
	   		$(obj).parent().parent().find("input[id=pcbarcode][index="+index+"]").val(tmvalue+xqvalue+bcvalue);
   	   	}
   	}

   	function loadSimpleBatch(index,barcode,batch,obj){
   	   	if(($(obj).attr("id") == "batch"&&$(obj).parent().parent().find("#guaranteeperiod").val() != "")||($(obj).attr("id") == "guaranteeperiod"&&$(obj).parent().parent().find("#batch").val() != "")){
	   	   	$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "getAjaxSimpleBatch.action",          
	   	   	    async: true, 
	   	   	    data: "barcode="+barcode+"&batch="+batch,     
	   	   	    success: function(msg){
		   	   		var barcodestr = $(obj).parent().parent().find("#pcbarcode").val();   
		   	   	$(obj).parent().parent().find("input[id=pcbarcode][index="+index+"]").val(barcodestr.substring(0,24)+msg);
	   	   	    }    
		   	});
   	   	}
    }
    
   function ChangeDateToString(DateIn){
   var Year=0;
   var Month= 0;
   var Day =0;
   var CurrentDate = "";
 
   //初始化时间
     
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
	
    function copyRow(obj,json){
    	addCopyRow(obj,json);
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

	function addCopyRow(obj,goodInfo){
	    var table = document.getElementById('addTable');
	    index = accAdd(table.rows.length - 1,index);
	    //alert(index);
		var htmltr  = document.createElement("tr");
		var c1 = document.createElement("td");
		var c2 = document.createElement("td");
		var c3 = document.createElement("td");
		var c4 = document.createElement("td");
		var c5 = document.createElement("td");
		var c6 = document.createElement("td");
		var c7 = document.createElement("td");
		var c8 = document.createElement("td");
		var c9 = document.createElement("td");
		var c10 = document.createElement("td");
		var c11 = document.createElement("td");
		var c12 = document.createElement("td");
		var c13 = document.createElement("td");
		var c14 = document.createElement("td");
		var c15 = document.createElement("td");
		var c16 = document.createElement("td");
		var c17 = document.createElement("td");
		
		htmltr.name="tr";	        
		htmltr.className = 'row';
		htmltr.height="26";		
			
		c4.id="spectt";
		c5.id="qj";
		c6.id="zj";
		c7.id="ql";
		c8.id="zhj";
		c9.id="sylx";
		c10.id="pqxfl";
		c11.id="zrl";
		c12.id="crl";
		c13.id="xq";
		c14.id="xq1";
		c15.id="xq2";

		$(c10).attr('id','pqxfl');
		var string6='';
		var string5='';
		
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';} 
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';} 
		else{string5='';}

		if(goodInfo.bgistealthclass=="1"){string6='日抛';}
		else if(goodInfo.bgistealthclass=="2"){string6='周抛';} 
		else if(goodInfo.bgistealthclass=="9"){string6='双周抛';}
		else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
		else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
		else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
		else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
		else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
		else if(goodInfo.bgistealthclass=="8"){string6='塑形镜';}
		else{string6='';}

        if (typeof(goodInfo.guaranteeperiod) == 'undefined'){
        	goodInfo.guaranteeperiod = '';
        }
        if (typeof(goodInfo.batch) == 'undefined'){
        	goodInfo.batch = '';
        }
	
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = "<img src=\"${ctx}/img/newbtn/addgoods_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');\" btn=btn title='复制商品' onClick=\"copyRow(this,{'bgigoodsid':'"+goodInfo.bgigoodsid+"','bgigoodsname':'"+goodInfo.bgigoodsname+"','bgispec':'"+goodInfo.bgispec+"','bgisph':'"+goodInfo.bgisph+"','bgicyl':'"+goodInfo.bgicyl+"','bgicurvature1':'"+goodInfo.bgicurvature1+"','bgidia':'"+goodInfo.bgidia+"','bgiusetype':'"+goodInfo.bgiusetype+"','bgistealthclass':'"+goodInfo.bgistealthclass+"','bgicapacity':'"+goodInfo.bgicapacity+"','bgibrandname':'"+goodInfo.bgibrandname+"','bgicapacityentry':'"+goodInfo.bgicapacityentry+"','bgipcbarcode':'"+goodInfo.bgipcbarcode+"','bgigoodsquantity':'','bgisource':'"+goodInfo.bgisource+"','bgiretailprice':'"+goodInfo.bgiretailprice+"','bgicostprice':'"+goodInfo.bgicostprice+"','bginottaxrate':'"+goodInfo.bginottaxrate+"','bgitaxrate':'"+goodInfo.bgitaxrate+"','bgicolor':'"+goodInfo.bgicolor+"','bgiregistrationnum':'"+goodInfo.bgiregistrationnum+"'});\">"+goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="color" value="' + goodInfo.bgicolor +'" /><input type="hidden" id="spec" value="' + goodInfo.bgispec +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" /><input type="hidden" id="goodsname" value="' + goodInfo.bgigoodsname +'" /><input type="hidden" id="source" value="' + goodInfo.bgisource +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgisph;		
		c6.innerHTML = goodInfo.bgicyl;				
		c7.innerHTML = goodInfo.bgicurvature1;
		c8.innerHTML = goodInfo.bgidia;
		c9.innerHTML = string5;
		c10.innerHTML = string6;		
		c11.innerHTML = goodInfo.bgicapacity+'<input type="hidden" id="brandname" value="'+goodInfo.bgibrandname+'"/>';
		c12.innerHTML = goodInfo.bgicapacityentry;
		c13.innerHTML = '<input type="hidden" class="text_input100" maxlength="26" id="bgirksj" index="'+index+'" readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="'+document.all.cstibilldate.value+'" />'+'<input type="text" index="'+index+'" class="text_input80" id="guaranteeperiod" name="goodsInfoTempPo.guaranteeperiod" onblur="changebarcode('+index+',$(this));loadSimpleBatch('+index+',$(this).parent().parent().find(\'#pcbarcode\').val(),$(this).parent().parent().find(\'#batch\').val(),this);" value="' + goodInfo.guaranteeperiod +'"/>'
		c14.innerHTML = '<input type="text" class="text_input80" maxlength="15" id="batch" onblur="loadSimpleBatch('+index+',$(this).parent().parent().find(\'#pcbarcode\').val(),$(this).val(),this);" name="goodsInfoTempPo.batch"  value="' + goodInfo.batch +'"/>'
		c15.innerHTML = '<input type="text" class="text_input80" maxlength="26" id="registrationnum" index="'+index+'" name="goodsInfoTempPo.registrationnum"  value="'+goodInfo.bgiregistrationnum +'" />';
		
		c16.innerHTML = '<input type="text" class="text_input200" maxlength="26"  id="pcbarcode" readonly="readonly" index="'+index+'" name="goodsInfoTempPo.pcbarcode"  value="'+goodInfo.bgipcbarcode.substring(0,24)+'A0'+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';	
		c17.innerHTML = '<input type="text" class="text_input40" maxlength="18" id="quantity" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';

		htmltr.appendChild(c1);
		htmltr.appendChild(c2);
		htmltr.appendChild(c3);
		htmltr.appendChild(c4);
		htmltr.appendChild(c5);
		htmltr.appendChild(c6);
		htmltr.appendChild(c7);
		htmltr.appendChild(c8);
		htmltr.appendChild(c9);
		htmltr.appendChild(c10);
		htmltr.appendChild(c11);
		htmltr.appendChild(c12);
		htmltr.appendChild(c13);
		htmltr.appendChild(c14);
		htmltr.appendChild(c15);
		htmltr.appendChild(c16);
		htmltr.appendChild(c17);

		obj.parentNode.parentNode.insertBefore(htmltr);
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="goodstype" name="goodstype" value="${goodstype }">
<input type="hidden" id="person" value="${person.id }"/>
<div id="simplebatch"></div>
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />
<input type="hidden" id="ioru" name="ioru" value="i" />
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
                        <TR height="26">
                          <TD width="9%" class="table_body">单据编号</TD>
                          <TD width="23%" class="table_none">${inventoryPo.cstibillid} <input type="hidden" class="text_input160" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}" readonly="readonly"></TD>
                         <TD width="9%" class="table_body">订单单号</TD>
                          <TD width="23%" class="table_none">
                          <li class="horizontal_onlyRight">
                          	<input type="text" class="text_input160" id="cstisourcebillid" name="inventoryPo.cstisourcebillid" value="${procurementOrdersEntryPos[0].cstpepurchaseorderid}" readonly="readonly">
                          </li>
                          <li class="horizontal_onlyRight">
                          <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="javascript:openOrders();">
                          </li>
                          </TD>
                          <TD class="table_body" width="9%">采购类型</TD>
                          <TD class="table_none">
	                          <select id="cstpgoodscategory" name="inventoryPo.cstigoodscategory"  onchange="changeGoodsCategory();isshow('');"><!--onchange="if(this.value == 7)  document.all.alertGoods.disabled=true; else document.all.alertGoods.disabled=false; "-->
							  		<option value="">----请选择----</option>
										<option value="4" ${inventoryPo.cstigoodscategory== 4?'selected="selected"':''} >隐形</option>
										<option value="5" ${inventoryPo.cstigoodscategory== 5?'selected="selected"':''} >护理液</option>
	                          </select>
						 	<input type="hidden" name="inventoryPo.cstibilltypeid" id="cstibilltypeid" value="1" /></TD>
                        </TR>
                        <TR>
  						   <TD height="26" class="table_body">制造商</TD>
						   <TD class="table_none">
						   <li class="horizontal_onlyRight">
						   		<input id="cstisuppliername" class="text_input160" name="inventoryPo.cstisuppliername" value="${inventoryPo.cstisuppliername == '' ? procurementOrdersEntryPos[0].bspsuppliername : inventoryPo.cstisuppliername}" readonly="readonly" />
						   		<input type="hidden" id="cstisupplierid" name="inventoryPo.cstisupplierid" value="${inventoryPo.cstisupplierid == '' ? procurementOrdersEntryPos[0].bspid : inventoryPo.cstisupplierid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openSupplier();">
						   </li>
						   </TD>
						   <TD height="26" class="table_body">收入仓位</TD>
                           <TD class="table_none" >
                            <select id="cstiinstockid" name="inventoryPo.cstiinstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收入仓位！'}]">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${bwhid!= warehouseConfigurationPo.bwcstockid3  ? '' : 'selected="selected"' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
                          <TD class="table_body">运单号</TD>
                          <TD class="table_none"><input type="text" class="text_input160" maxlength="32" id="deliveryID" name="inventoryPo.deliveryID" value="${inventoryPo.deliveryID}" >
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
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" width="60%">
						   <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" 
						  onClick="javascript:openGoodSingle();">
						  <img src="${ctx}/img/newbtn/btn_yhxddaddgoods_0.png" btn=btn title="已核销订单添加商品" 
						  onClick="javascript:openOrders1();">
					       <img src="${ctx}/img/newbtn/btn_addtwogoods_0.png" btn=btn title="二维表添加商品" id="2D"
					      onClick="javascript:open2D();"> 
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
	                          	<li class="horizontal_onlyRight">
	                          	<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save();">
	                          	</li>
	                          	<li class="horizontal_onlyRight">
	                          	<input type="checkbox" id="cstiauditstate1" onclick="check()" value="1">保存并审核
	                          	</li>
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
                          <TH width="5%" scope=col id="spec">型号</TH>
                          <TH width="5%" scope=col id=qj>球镜</TH>
                          <TH width="5%" scope=col id=zj>柱镜</TH>
                          <TH width="5%" scope=col id=ql>曲率</TH>
                          <TH width="5%" scope=col id=zhj>直径</TH>
                          <TH width="5%" scope=col id=sylx>使用类型 </TH>
                          <TH width="6%" scope=col id=pqxfl>抛弃型分类</TH> 
                          <TH width="5%" scope=col id=zrl>主容量</TH>
                          <TH width="5%" scope=col id=crl>次容量</TH> 
                          <TH width="5%" scope=col id=xq>效期</TH>
                          <TH width="5%" scope=col id=xq1>批号</TH>
                          <TH width="5%" scope=col id=xq2>注册证号</TH>
                          <TH width="8%" scope=col>商品条码</TH>
                          <TH width="5%" scope=col>数量</TH>                           
                        </TR>
                    	<TR class=table_title align=middle> 
						  	<TH width="40%" height="26" id="heji" scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>    
                 
                      </TBODY>
                    </TABLE>
                    </div>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          	<TD align="left">
                          		<li class="horizontal_onlyRight">
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save();">
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