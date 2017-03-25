<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外订单管理</title>
</head>
<script>

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
	
		var cstpgoodscategory = document.getElementById('cstcpoordergoodscategory').value;
	    if(cstpgoodscategory == ''){
	      alert('请选择订单类型');
	      return false;
	    }
	    
	    if(cstpgoodscategory == 2){
			cstpgoodscategory = 3;
		}else{
			cstpgoodscategory = 4;
		}
	    
		//showPopWin("","selSupplierOpen.action?categoryID_open=" + cstpgoodscategory,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + cstpgoodscategory,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + cstpgoodscategory,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('cstcposupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
	}
	
	function save(){
	if(checkForm(document.all.procurementOrdersForm)){
	
		if (document.getElementById('addTable').rows.length == 2){
			alert("请选择商品！");
			return;
		}
		
		//验证商品类别和制造商是否与添加商品一样
		var goodsCategory = document.getElementById('cstcpoordergoodscategory').value;
		
		if(goodsCategory == 2){
			goodsCategory = 3;
		}else{
			goodsCategory = 4;
		}
		var supplierID = document.getElementById('cstcposupplierid').value.toUpperCase();
		var chk=document.getElementsByName("chk");
		var length = chk.length;
		
		var re = new RegExp();
		re.compile("^" + goodsCategory + "\." + supplierID);
		for(i = 0; i < length; i++){
			if(!re.test(chk[i].value.toUpperCase())){
				alert("制造商或订单类型与添加的商品不匹配！");
				return;	
			}		
		}

	    $("img").removeAttr("onclick");
		procurementOrdersForm.action = "insertConsignProcessOrders.action";
		procurementOrdersForm.submit();
		}
	}
	
	function openConsignProcessOrders(){
		var supplierID = document.getElementById('cstcposupplierid').value;
	    if(supplierID==''){
	      alert('请选择制造商');
	      return false;
	    }	
	    
	    var cstpgoodscategory = document.getElementById('cstcpoordergoodscategory').value;
	    if(cstpgoodscategory == ''){
	      alert('请选择订单类型');
	      return false;
	    }

		//showPopWin("","initSalesBasicForConsignProcessOpen.action?ordersType=" + cstpgoodscategory + "&supplierID=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initSalesBasicForConsignProcessOpen.action?ordersType=" + cstpgoodscategory + "&supplierID=" + supplierID ,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSalesBasicForConsignProcessOpen.action?ordersType=" + cstpgoodscategory + "&supplierID=" + supplierID ,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【内部配镜单查询】";
	}
	
	function openConsignProcessOrdersValues(objValue){
		var salesInfos = eval('(' + objValue + ')');
		
		for(a = 0; a < salesInfos.length; a++){
			addRow(salesInfos[a]);
		}
		
		amount();
	}

	//选择任一配镜单的外加工方式，另一片跟随变化
	function changeAll(obj,billID){
		var index=obj.selectedIndex; //序号，取当前选中选项的序号 
		var val = obj.options[index].value; 

		$('select[billID='+ billID +']').each(function(){ 
			$(this).val(val);


	    }); 
	}
	
	function addRow(salesInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
//		var chk=document.getElementsByName("chk");
//		for(i = 0; i < chk.length; i++){
//			if (chk[i].value == salesInfo.cstcpodgoodsid && chk[i].cstcpodglassflag == salesInfo.cstcpodglassflag && chk[i].glassesbillid == salesInfo.cstcpodglassesbillid) return;
//		}
		
		
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
		var c14 = row.insertCell(13);
		var c15 = row.insertCell(14);
		
		
		row.height="28";
		
		//配镜单号 取镜时间 商品名称 镜片
		//类型 数量 球镜 柱镜 轴向 下加 棱镜 基底 曲率 直径 特殊加
		//工要求 
		  c10.id="xj"; 		//下加
		  c11.id="lj";		//棱镜
		  c12.id="jd"; 		//基底
		  c13.id="ql"; 		//曲率
		  c14.id="zj"; 		//直径
			row.className = 'row';
			c1.innerHTML = '<a href="javascript:void(0);" onclick="winPopUp(\''+salesInfo.cstcpodglassesbillid+'\')" >' + salesInfo.cstcpodglassesbillid + '</a><input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodglassesbillid" value="' + salesInfo.cstcpodglassesbillid +'" />' + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodcustomerid" value="' + salesInfo.ssesbcustomerid + '" >' + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodcustomername" value="' + salesInfo.cstcpodcustomername + '" >' + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodgoodsid" value="' + salesInfo.cstcpodgoodsid + '" >' + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodordertype" value="N" ><input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodsalesid" value="'+salesInfo.cstcpodsalesid+'" >';
	        c2.innerHTML = salesInfo.cstcpodarriveddate + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodexpecteddate" value="' + salesInfo.cstcpodarriveddate +'" />';
			c3.innerHTML = salesInfo.cstcpodgoodsname + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodgoodsname" value="' + salesInfo.cstcpodgoodsname +'" />';
			if(${consignProcessOrderPo.cstcpoordergoodscategory} == '2')
			{
				if(salesInfo.cstcpoddragstype=='1'){
					c4.innerHTML = '<select billID="' + salesInfo.cstcpodglassesbillid +'" name="consignProcessOrderDetailsTemp.cstcpoddragstype" onchange="changeAll(this,\''+ salesInfo.cstcpodglassesbillid +'\');"><option selected value="1">委外订单</option><option value="2">委外加工</option></select>';
				}
				if(salesInfo.cstcpoddragstype=='2'){
					c4.innerHTML = '<select  billID="' + salesInfo.cstcpodglassesbillid +'" name="consignProcessOrderDetailsTemp.cstcpoddragstype" onchange="changeAll(this,\''+ salesInfo.cstcpodglassesbillid +'\');"><option value="1">委外订单</option><option selected value="2">委外加工</option></select>';
				}
			}
			if(${consignProcessOrderPo.cstcpoordergoodscategory} == '4')
			{
				c4.innerHTML = '委外订单<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpoddragstype" value="1">';
			}
			c5.innerHTML = salesInfo.cstcpodglassflag + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodglassflag" value="' + salesInfo.cstcpodglassflag +'" />';
			c6.innerHTML = salesInfo.cstcpodnum + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodnum" onblur="amount();" value="' + salesInfo.cstcpodnum +'" />';
			c7.innerHTML = salesInfo.cstcpodballglass + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodballglass" value="' + salesInfo.cstcpodballglass +'" />';
			c8.innerHTML = salesInfo.cstcpodpostglass + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodpostglass" value="' + salesInfo.cstcpodpostglass +'" />';
			c9.innerHTML = salesInfo.cstcpodaxes + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodaxes" value="' + salesInfo.cstcpodaxes +'" />';
			c10.innerHTML = salesInfo.cstcpodadd + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodadd" value="' + salesInfo.cstcpodadd +'" />';
			c11.innerHTML = salesInfo.cstcpodarriseglass + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodarriseglass" value="' + salesInfo.cstcpodarriseglass +'" />';
			c12.innerHTML = salesInfo.cstcpodbasis + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodbasis" value="' + salesInfo.cstcpodbasis +'" />';
			c13.innerHTML = salesInfo.cstcpodeyecurvature + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodeyecurvature" value="' + salesInfo.cstcpodeyecurvature +'" />';		
			c14.innerHTML = salesInfo.cstcpoddiameter + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpoddiameter" value="' + salesInfo.cstcpoddiameter +'" />'+'<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodinter" value="'+salesInfo.cstcpodinter+'">'+'<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodinterdistance" value="'+salesInfo.cstcpodinterdistance+'">';
			c15.innerHTML = salesInfo.cstcpodrequirement + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodrequirement" value="' + salesInfo.cstcpodrequirement +'" />'+ '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodsalesbillid" value="' + salesInfo.cstcpodsalesbillid +'" />';
		
    }
	function addRowReTable3(salesInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		var row = table.insertRow(table.rows.length);
		row.height="26";
		var chk=document.getElementsByName("biid");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == salesInfo.cstcpodglassesbillid ) return;
		}
		var c1 = row.insertCell(0);
		c1.colSpan=15;
		c1.innerHTML = salesInfo.cstcpodglassesbillid+'单据信息：'+'<input type="hidden" name="biid" id="biid" value="'+salesInfo.cstcpodglassesbillid+'">';
    }
	function addRowReTable1(salesInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		var row = table.insertRow(table.rows.length);
		row.height="28";
		row.className = 'table_title';
		row.align="center";
		if('2'=='${consignProcessOrderPo.cstcpoordergoodscategory}'){
			var c1 = row.insertCell(0);
			var c2 = row.insertCell(1);
			var c3 = row.insertCell(2);
			var c4 = row.insertCell(3);
			var c5 = row.insertCell(4);
			var c6 = row.insertCell(5);
			var c7 = row.insertCell(6);
			var c8 = row.insertCell(7);
			var c9 = row.insertCell(8);
			c1.colSpan=2;
			c2.colSpan=2;
			c7.colSpan=2;
			c8.colSpan=2;
			c1.innerHTML = '销售备注('+salesInfo.cstcpodglassesbillid+')';
			c2.innerHTML = '处方备注';
			c5.innerHTML = '中梁';
			c6.innerHTML = '对角线';
			c7.innerHTML = '框型';
			c8.innerHTML = '镜片通道';
			c3.innerHTML = '片高';
			c4.innerHTML = '片宽';
			c9.innerHTML = '直径';
		}
		if('4'=='${consignProcessOrderPo.cstcpoordergoodscategory}'){
			var c1 = row.insertCell(0);
			var c2 = row.insertCell(1);
			c1.colSpan=5;
			c2.colSpan=11;
			c1.innerHTML = '销售备注('+salesInfo.cstcpodglassesbillid+')';
			c2.innerHTML = '处方备注';
		}
    }
	function addRowReTable2(salesInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		var row = table.insertRow(table.rows.length);
		row.height="28";
		row.className = 'row';
		if('2'=='${consignProcessOrderPo.cstcpoordergoodscategory}'){
			var c1 = row.insertCell(0);
			var c2 = row.insertCell(1);
			var c3 = row.insertCell(2);
			var c4 = row.insertCell(3);
			var c5 = row.insertCell(4);
			var c6 = row.insertCell(5);
			var c7 = row.insertCell(6);
			var c8 = row.insertCell(7);
			var c9 = row.insertCell(8);
			c1.colSpan=2;
			c2.colSpan=2;
			c7.colSpan=2;
			c8.colSpan=2;
			c3.innerHTML = salesInfo.ssesbglasshige;
			c4.innerHTML = salesInfo.ssesbglasswigth;
			c5.innerHTML = salesInfo.ssesbframemiddlesize;
			c6.innerHTML = salesInfo.ssesbgiagonalline;
			c7.innerHTML = salesInfo.ssesbframeform;
			c8.innerHTML = salesInfo.ssesbgalssroad;
			c1.innerHTML = salesInfo.cstcposalesremark;
			c2.innerHTML = salesInfo.cstcpodignosisre;
			c9.innerHTML = salesInfo.ssesbframedia;
		}
		if('4'=='${consignProcessOrderPo.cstcpoordergoodscategory}'){
			var c1 = row.insertCell(0);
			var c2 = row.insertCell(1);
			c1.colSpan=5;
			c2.colSpan=11;
			c1.innerHTML = salesInfo.cstcposalesremark;
			c2.innerHTML = salesInfo.cstcpodignosisre;
		}
    }
    function deleteitem(){
    
    	// 商品id去重
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		

				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}
		
		document.all.chks.checked = false;
		
		amount();
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
    
    function init(){
   	<c:forEach var="po" items="${consignProcessOrderDetails}">
   	if(''!='${po.cstcpodgoodsid}'){
   		
	   	addRow({'cstcpodglassesbillid':'${po.cstcpodglassesbillid}',
	   			'cstcpodgoodsid':'${po.cstcpodgoodsid}','cstcposalesremark':'${po.cstcposalesremark}','cstcpodignosisre':'${po.cstcpodignosisre}',
	   			'cstcpodcustomername':'${po.cstcpodcustomername}','ssesbglasshige':'${po.ssesbglasshige}','ssesbglasswigth':'${po.ssesbglasswigth}','ssesbframemiddlesize':'${po.ssesbframemiddlesize}',
	   			'cstcpodbilltype':'${po.cstcpodbilltype}','ssesbgalssroad':'${po.ssesbgalssroad}','ssesbgiagonalline':'${po.ssesbgiagonalline}','ssesbframeform':'${po.ssesbframeform}',
	           	'cstcpodarriveddate':'${fn:substring(po.cstcpodarriveddate,0,10)}','ssesbgiagonalline':'${po.ssesbgiagonalline}',
	           	'cstcpodgoodsname':'${po.cstcpodgoodsname}',
	           	'cstcpodglassflag':'${po.cstcpodglassflag}',
	           	'cstcpodnum':'${po.cstcpodnum}',
	           	'cstcpodballglass':'${po.cstcpodballglass}',
	           	'cstcpodpostglass':'${po.cstcpodpostglass}',
	           	'cstcpodaxes':'${po.cstcpodaxes}',
	           	'cstcpodadd':'${po.cstcpodadd}',
	           	'cstcpodarriseglass':'${po.cstcpodarriseglass}',
	           	'cstcpodbasis':'${po.cstcpodbasis}',
	           	'cstcpodeyecurvature':'${po.cstcpodeyecurvature}',
	           	'cstcpoddiameter':'${po.cstcpoddiameter}',
	           	'cstcpodrequirement':'${po.cstcpodrequirement}',
	           	'ssesbcustomerid':'${po.cstcpodcustomerid}',
	           	'cstcpodordertype':'${po.cstcpodordertype}','ssesbframedia':'${po.ssesbframedia}',
	           	'cstcpodrequirement1':'${po.cstcpodrequirement1}','cstcpodinter':'${po.cstcpodinter}','cstcpodinterdistance':'${po.cstcpodinterdistance}','cstcpoddragstype':'${po.cstcpoddragstype}','cstcpodsalesbillid':'${po.cstcpodsalesbillid}','cstcpodsalesid':'${po.cstcpodsalesid}'});
   	}else{
   		
   		addRowReTable1({'cstcpodglassesbillid':'${po.cstcpodglassesbillid}',
   			'cstcpodgoodsid':'${po.cstcpodgoodsid}','cstcposalesremark':'${po.cstcposalesremark}','cstcpodignosisre':'${po.cstcpodignosisre}',
   			'cstcpodcustomername':'${po.cstcpodcustomername}','ssesbglasshige':'${po.ssesbglasshige}','ssesbglasswigth':'${po.ssesbglasswigth}','ssesbframemiddlesize':'${po.ssesbframemiddlesize}',
   			'cstcpodbilltype':'${po.cstcpodbilltype}','ssesbgalssroad':'${po.ssesbgalssroad}','ssesbgiagonalline':'${po.ssesbgiagonalline}','ssesbframeform':'${po.ssesbframeform}',
           	'cstcpodarriveddate':'${fn:substring(po.cstcpodarriveddate,0,10)}','ssesbgiagonalline':'${po.ssesbgiagonalline}',
           	'cstcpodgoodsname':'${po.cstcpodgoodsname}',
           	'cstcpodglassflag':'${po.cstcpodglassflag}',
           	'cstcpodnum':'${po.cstcpodnum}',
           	'cstcpodballglass':'${po.cstcpodballglass}',
           	'cstcpodpostglass':'${po.cstcpodpostglass}',
           	'cstcpodaxes':'${po.cstcpodaxes}',
           	'cstcpodadd':'${po.cstcpodadd}',
           	'cstcpodarriseglass':'${po.cstcpodarriseglass}',
           	'cstcpodbasis':'${po.cstcpodbasis}',
           	'cstcpodeyecurvature':'${po.cstcpodeyecurvature}',
           	'cstcpoddiameter':'${po.cstcpoddiameter}',
           	'cstcpodrequirement':'${po.cstcpodrequirement}',
           	'ssesbcustomerid':'${po.cstcpodcustomerid}',
           	'cstcpodordertype':'${po.cstcpodordertype}','ssesbframedia':'${po.ssesbframedia}',
           	'cstcpodrequirement1':'${po.cstcpodrequirement1}','cstcpodinter':'${po.cstcpodinter}','cstcpodinterdistance':'${po.cstcpodinterdistance}','cstcpoddragstype':'${po.cstcpoddragstype}','cstcpodsalesbillid':'${po.cstcpodsalesbillid}','cstcpodsalesid':'${po.cstcpodsalesid}'});
   		addRowReTable2({'cstcpodglassesbillid':'${po.cstcpodglassesbillid}',
   			'cstcpodgoodsid':'${po.cstcpodgoodsid}','cstcposalesremark':'${po.cstcposalesremark}','cstcpodignosisre':'${po.cstcpodignosisre}',
   			'cstcpodcustomername':'${po.cstcpodcustomername}','ssesbglasshige':'${po.ssesbglasshige}','ssesbglasswigth':'${po.ssesbglasswigth}','ssesbframemiddlesize':'${po.ssesbframemiddlesize}',
   			'cstcpodbilltype':'${po.cstcpodbilltype}','ssesbgalssroad':'${po.ssesbgalssroad}','ssesbgiagonalline':'${po.ssesbgiagonalline}','ssesbframeform':'${po.ssesbframeform}',
           	'cstcpodarriveddate':'${fn:substring(po.cstcpodarriveddate,0,10)}','ssesbgiagonalline':'${po.ssesbgiagonalline}',
           	'cstcpodgoodsname':'${po.cstcpodgoodsname}',
           	'cstcpodglassflag':'${po.cstcpodglassflag}',
           	'cstcpodnum':'${po.cstcpodnum}',
           	'cstcpodballglass':'${po.cstcpodballglass}',
           	'cstcpodpostglass':'${po.cstcpodpostglass}',
           	'cstcpodaxes':'${po.cstcpodaxes}',
           	'cstcpodadd':'${po.cstcpodadd}',
           	'cstcpodarriseglass':'${po.cstcpodarriseglass}',
           	'cstcpodbasis':'${po.cstcpodbasis}',
           	'cstcpodeyecurvature':'${po.cstcpodeyecurvature}',
           	'cstcpoddiameter':'${po.cstcpoddiameter}',
           	'cstcpodrequirement':'${po.cstcpodrequirement}',
           	'ssesbcustomerid':'${po.cstcpodcustomerid}',
           	'cstcpodordertype':'${po.cstcpodordertype}','ssesbframedia':'${po.ssesbframedia}',
           	'cstcpodrequirement1':'${po.cstcpodrequirement1}','cstcpodinter':'${po.cstcpodinter}','cstcpodinterdistance':'${po.cstcpodinterdistance}','cstcpoddragstype':'${po.cstcpoddragstype}','cstcpodsalesbillid':'${po.cstcpodsalesbillid}','cstcpodsalesid':'${po.cstcpodsalesid}'});
   	}
   	</c:forEach>
   	
   	amount();
   	isshow();
    }
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("consignProcessOrderDetailsTemp.cstcpodnum");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
    function openConsignProcess(){
		var supplierID = document.getElementById('cstcposupplierid').value;
	    if(supplierID==''){
	      alert('请选择制造商');
	      return false;
	    }	
	    
	    var cstpgoodscategory = document.getElementById('cstcpoordergoodscategory').value;
	    if(cstpgoodscategory == ''){
	      alert('请选择镜片型');
	      return false;
	    }
		if(cstpgoodscategory == 2){
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			
			if(is_iPad()){
				showPopWin("initGlassForConsignProcessOpen.action?ordersType=" + cstpgoodscategory + "&supplierID=" + supplierID ,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initGlassForConsignProcessOpen.action?ordersType=" + cstpgoodscategory + "&supplierID=" + supplierID ,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			
			document.getElementById('popupTitle').innerHTML="【外部配镜单查询】";
		
		}else if(cstpgoodscategory == 4){
		  
		    var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			
			if(is_iPad()){
				showPopWin("initStealthForConsignProcessOpen.action?ordersType=" + cstpgoodscategory + "&supplierID=" + supplierID ,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initStealthForConsignProcessOpen.action?ordersType=" + cstpgoodscategory + "&supplierID=" + supplierID ,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			
			document.getElementById('popupTitle').innerHTML="【外部配镜单查询】";
		}

	} 

    function isshow(){
    	
    		if(${consignProcessOrderPo.cstcpoordergoodscategory} == "2"){
    		
    			$('[id=xj]').show();
    			$('[id=lj]').show();
    			$('[id=jd]').show();
    			$('[id=ql]').hide();
    			$('[id=zj]').hide();

    		}

    		if(${consignProcessOrderPo.cstcpoordergoodscategory} == "4"){
    			$('[id=xj]').hide();
    			$('[id=lj]').hide();
    			$('[id=jd]').hide();
    			$('[id=ql]').show();
    			$('[id=zj]').show();

    		}
    }   

    $(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		
	});  

    function winPopUp(id){

        if (id.substring(0,1) != 'X'){
            alert('外部配镜单没有详细信息!');
            return;
        }
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单信息】";
	}  
	 
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onload="init();" >

<form name="procurementOrdersForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" height="26" class="table_body">单据编号</TD>
                          <TD width="24%" class="table_none">&nbsp;${consignProcessOrderPo.cstcpoorderbillid }<input class="text_input200" type="hidden" name="consignProcessOrderPo.cstcpoorderbillid" readonly="readonly" value="${consignProcessOrderPo.cstcpoorderbillid }"></TD>
                          <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">&nbsp;<jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />                      
                          <input class="text_input100" type="hidden" name="consignProcessOrderPo.cstcpobilldate" type="text" readonly="readonly" value="${consignProcessOrderPo.cstcpobilldate}" /></TD>
                           <TD width="9%" class="table_body">制造商</TD>
						   <TD height="26" align="left" class="table_none">
						   &nbsp;${consignProcessOrderPo.bspsuppliername }<input type="hidden" id="cstcposupplierid" name="consignProcessOrderPo.cstcposupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '制造商不能为空！'}]" value="${consignProcessOrderPo.cstcposupplierid }"/>
						   </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">制单人</TD>
                          <TD class="table_none">&nbsp;${person.personName }<input class="text_input100" type="hidden" name="consignProcessOrderPo.cstcpocreateperson" value="${person.id }"></TD>
                          <TD class="table_body">订单类型</TD>
                          <TD class="table_none" colspan="3">
                          	<c:choose>
                          		<c:when test="${consignProcessOrderPo.cstcpoordergoodscategory == 2 }">&nbsp;框镜订做片</c:when>
                          		<c:when test="${consignProcessOrderPo.cstcpoordergoodscategory == 4 }">&nbsp;隐形订做片</c:when>
                          	</c:choose>
                          	<input type="hidden" id="cstcpoordergoodscategory" name="consignProcessOrderPo.cstcpoordergoodscategory" value="${consignProcessOrderPo.cstcpoordergoodscategory }" />
						  </TD>
						</TR>
						<TR>
                          <TD class="table_body" height="26">收货联系人</TD>
                          <TD class="table_none">&nbsp;<input id="deliveryperson" class="text_input160" maxlength="20" type="text" name="consignProcessOrderPo.cstcpodeliveryperson" value="${consignProcessOrderPo.cstcpodeliveryperson}" validate="[{'Type' : Type.String, 'Formula' : Formula.PersonNameOrNULL, 'Message' : '请重新填写收货联系人!'}]"/></TD>
                          <TD class="table_body">收货联系电话</TD>
                          <TD class="table_none">&nbsp;<input id="deliveryphone" class="text_input160" maxlength="20" type="text" name="consignProcessOrderPo.cstcpodeliveryphone" value="${consignProcessOrderPo.cstcpodeliveryphone}" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '请重新填写收货联系电话!'}]"/></TD>
                          <TD class="table_body">收货联系传真</TD>
                          <TD class="table_none">&nbsp;<input id="deliveryfax" class="text_input160" maxlength="20" type="text" name="consignProcessOrderPo.cstcpodeliveryfax" value="${consignProcessOrderPo.cstcpodeliveryfax}" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '请重新填写收货联系传真!'}]"/></TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">收货地址</TD>
                          <TD class="table_none" colspan="5">&nbsp;<input id="deliveryaddress" class="text_input200" maxlength="100" type="text" name="consignProcessOrderPo.cstcpodeliveryaddress" value="${consignProcessOrderPo.cstcpodeliveryaddress}" style="width: 600" validate="[{'Type' : Type.String, 'Formula' : Formula.ObjectNameOrNULL, 'Message' : '请重新填写收货地址!'}]"/></TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colspan="5"><label>
                          <textarea name="consignProcessOrderPo.cstcporemark" id="textarea"
                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${consignProcessOrderPo.cstcporemark }</textarea>
                          </label></TD>
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
                        <TR class=table_title align=middle>
						  <TH scope=col width="12%" height="26">配镜单号</TH>
                          <TH scope=col width="12%">取镜时间</TH>
                          <TH scope=col width="16%">商品名称</TH>
                          <TH scope=col width="6%">委外方式</TH>
                          <TH scope=col width="5%">镜片类型</TH>
                          <TH scope=col width="5%">数量</TH>
                          <TH scope=col width="5%">球镜</TH>
                          <TH scope=col width="5%">柱镜</TH>
                          <TH scope=col width="3%">轴向</TH>
                          <TH scope=col width="3%" id=xj>下加</TH>
                          <TH scope=col width="3%" id=lj>棱镜</TH>
                          <TH scope=col width="3%" id=jd>基底</TH>
                          <TH scope=col width="4%" id=ql>曲率</TH>
                          <TH scope=col width="3%" id=zj>直径</TH>
                          <TH scope=col width="8%">加工<br/>要求</TH>
                        </TR>
                        <TR class=table_title 	align=middle> 
						  	<TH width="40%" height="26"  colSpan=5 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col  id="goodsquantityTotal">0</TH>
					    	<TH scope=col  >&nbsp;</TH>
					    	<TH scope=col  >&nbsp;</TH>
					    	<TH scope=col  >&nbsp;</TH>
					    	<TH scope=col  id=xj>&nbsp;</TH>
					    	<TH scope=col  id=lj>&nbsp;</TH>
					    	<TH scope=col  id=jd>&nbsp;</TH>
					    	<TH scope=col  id=ql>&nbsp;</TH>
					    	<TH scope=col  id=zj>&nbsp;</TH>
					    	<TH scope=col  >&nbsp;</TH>
				   		</TR>
                     
                       </TBODY>
                    </TABLE>
                    <table id="addTable1" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                      </TBODY>
                      </table>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          		<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onclick="save()">
                          	
                          	</li>
                          	<li class="horizontal_onlyRight">
                          		<input name="stateFlag" type="checkbox" value="1" value="保存并审核"> 保存并审核
                          	</li>
                          </TD>
					   </TR>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>