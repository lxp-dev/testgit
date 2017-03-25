<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>领用出库管理</title>
</head>
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<script>
	function getCallAbleNum(goodsid,goodsbarcode){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("selGoodsSingleZTOpen.action?goodsID="+goodsid+"&goodscode="+goodsbarcode+"&stockid="+$('#cstioutstockid').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selGoodsSingleZTOpen.action?goodsID="+goodsid+"&goodscode="+goodsbarcode+"&stockid="+$('#cstioutstockid').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【商品可调用数量详细】";
	}

	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	$(document).ready(function(){
		//StatusID：0代表负调拨
		var StatusID='${StatusID}';
		<s:iterator value="inventoryEntryList">
	    	var json = {'bgigoodsid':'${cstiegoodsid}','bgigoodsbarcode':'${cstiebarcode}',
	     				'bgigoodsname':'${cstiegoodsname}','bgiunitname':'${cstieunitname}','bgicostprice':'${cstiecostprice}',
	     				'bgiretailprice':'${bgiretailprice}','bgitaxrate':'${cstietaxrate}','bginottaxrate':'${cstienottaxrate}',
	     				'bgispec':'${cstiespec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
	     				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
	     				'bgigoodsquantity':'${cstiegoodsquantity}','cstienottaxrateamount':'${cstienottaxrateamount }','bgiretailpriceamount':'${cstietakepriceamount}',
	     				'bgiretailprice':'${cstietakeprice}','cshaaemaxquantity':'${cstiemaxquantity}'};
	    	addRowUpdateNumber(json);
		</s:iterator>   
		initPriceAmount();
		$("#cstidepartmentid2").hide();
		$("#cstidepartmentid2").attr("disabled","disabled");
	});
	
	function save(){
	if(checkForm(document.all.salesOutForm)){ 
		var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		if(index==0){
		  alert('请选择商品!');
		}
		
		var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		var goodsquantityCount=0;
		for(i=0;i<goodsquantityArray.length;i++){
			if(goodsquantityArray[i].value=="0"){
				alert("商品数量不能为0！");
				goodsquantityArray[i].focus();
				return;	
			}
			if(isNaN(goodsquantityArray[i].value)){
				alert("商品数量只能为数字！");
				goodsquantityArray[i].focus();
				return;	
			}
			 var flag = 0;
			$('select[id=selectGbc]').each(function()
			{	   
			    if ($(this).find("option").length==0){
			        flag = 1;
			        alert("请填写商品条码!");
			        return false;
			    }
			});
			
			if (flag == 1){
			    return;
			}
			goodsquantityCount++;
		}
		if(goodsquantityCount==0){
          alert('请选择商品!');
          return false;
        }

		var numberflag = 0;
        $('select[id=selectGbc]').each(function(){
			for(var j=0;j<$(this).find("option").length;j++){
				$(this).find("option")[j].selected='selected';
			}
			if($(this).find("option").length != Math.abs($(this).parent().parent().parent().find(".number").val())){
				numberflag = numberflag + 1;
				alert("商品数量与条码不匹配！");
				return false;
			}
		});
        if (numberflag == 1){
		    return;
		}
		$("img").removeAttr("onclick");
		salesOutForm.action = "updateTakeOut.action";
		salesOutForm.submit();
		}
		
	}
	
	function openGoodSingle(){
	    var supplierID = '';
		var categoryID_open='';	
		var stockid = $("#cstioutstockid").val();

		if(!stockid){
			alert("请选择发出仓位！");
			$("#cstioutstockid").focus();
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSelZT.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID + "&stockid="+stockid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSelZT.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID + "&stockid="+stockid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRowUpdateNumber(goodInfos[goodsI]);
		}
		initPriceAmount();
	}
    
   function deleteitem(){
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		var count=0;
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
				count++;   
			}			
		}
		if(count==0){
          alert('请选择商品!');
          return false;
        }
		document.all.chks.checked = false;
		initPriceAmount();
    }
    
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】"
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
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    /**
	*	设定价格调试各Input元素的变化属性；
	*	goodsquantityStateArray 	：商品数量数组；
	*	nottaxrateStateArray		：单位成本数组；
	*	nottaxrateamountStateArray 	：成本合计数组；
	*	taxrateStateArray 			：税率数组；
	*	costpriceStateArray 		：含税单价数组；
	*	costpriceamountStateArray 	：价税合计数组；		
	*	taxamountStateArray 		：税额合计数组；			
	*	例子：goodsquantityStateArray =new Array(arg0,arg1,arg2,arg3);
	*	arg0：当自动计算时，是否只读；true表示只读；false表示非只读；
	*	arg1：当自动计算时，是否对onchange方法进行方法转换；"add"表示添加方法；"remove"表示移除方法；""空表示不进行操作；
	*	arg2：当手动计算时，是否只读；true表示只读；false表示非只读；
	*	arg3：当手动计算时，是否对onchange方法进行方法转换；"add"表示添加方法；"remove"表示移除方法；""空表示不进行操作；
	**/
	function getInputState(){	
		var goodsquantityStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var nottaxrateStateArray =new Array(true,"",false,"totalCount");
		var nottaxrateamountStateArray =new Array(true,"",false,"totalCount");
		var taxrateStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var costpriceStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var costpriceamountStateArray =new Array(true,"",false,"totalCount");
		var taxamountStateArray =new Array(true,"",false,"totalCount");
		var stateArray=new Array(goodsquantityStateArray,nottaxrateStateArray,nottaxrateamountStateArray,taxrateStateArray,costpriceStateArray,costpriceamountStateArray,taxamountStateArray);
		return stateArray;
	}  
	
	function barcode(goodsid,goodsbarcode){
		if(goodsbarcode.value==''){
			return;
		}
		var tmp = goodsid.replace(/\./g,  "").toUpperCase();
		var tmp1 = goodsbarcode.value.substring(0,18);
		tmp1 = tmp1.toUpperCase();
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
	var index = 0;
	function addRow(goodInfo,stateArray){		
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

		var addtype="";

		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsbarcode){
				addtype="1";
				return;
			}
		}
		
		// 添加商品到列表 begin
    	var readonlyFlg=document.getElementById("autoCount");

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
	<c:if test="${permissionPo.keyf == 1}">	
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);	
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
		var c13 = row.insertCell(11);
		</c:if>
	</c:if>
	<c:if test="${permissionPo.keyf == 0}">	
		var c10 = row.insertCell(6);
		var c11 = row.insertCell(7);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c13 = row.insertCell(8);
		</c:if>
	</c:if>
	
		row.className = 'row';
		row.height="26";
		
		// 添加商品到列表 end	
	   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >';
	        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
	        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
			c4.innerHTML = goodInfo.bgispec+'<input type="hidden" id="bgispec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';
			c5.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'" );\'>' + goodInfo.cshaaemaxquantity+'</a><input type="hidden" id="bgispec" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';

			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");

			var goodsnumber="0";
			var nottaxrateamount = "0.00";
			if(goodInfo.bgigoodsquantity){
				goodsnumber=goodInfo.bgigoodsquantity;
				 
			}
			if(goodInfo.cstienottaxrateamount){
				nottaxrateamount=goodInfo.cstienottaxrateamount;
				 
			}
			
	    	if(readonlyFlg.checked){
	    	<c:if test="${permissionPo.keyf == 1}">	
	    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';		
				</c:if>
				    c7.innerHTML = '<input type="text" class="text_input80" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
					c8.innerHTML = '<input type="text" class="text_input60" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
					c9.innerHTML = '<input type="text" class="text_input60" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
					c10.innerHTML = '<input type="text" class="text_input60" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
					if(goodInfo.bgiretailpriceamount){
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}else{
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
					<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
					               + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'		
				   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
									+ '<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
									+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
					</c:if>
					<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
				              		+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'		
			   						+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
									+ '<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
									+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
					</c:if>
					c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
					if(goodInfo.bgiretailpriceamount){
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}else{
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}
			</c:if>	

	    	}else{
	    	<c:if test="${permissionPo.keyf == 1}">	
	    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
	 			</c:if>	
	 			<c:if test="${systemParameterPo.fspbarcodetype==3}">
	 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+		
	 								'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
	 			</c:if>	
				c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c8.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
			    c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
				if(goodInfo.bgiretailpriceamount){
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}else{
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
				<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
						c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'
						 +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
						+ '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
						c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'
					    +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
						+ '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>'+
						'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
				</c:if>
				c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
				if(goodInfo.bgiretailpriceamount){
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}else{
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}
			</c:if>

        	}
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	   			c13.innerHTML= '<input id="selectGbc" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'">'+
				'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
				$('#del'+index).btn().init();
			</c:if>
			$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
				if('${permissionPo.keyg}'!='1'){
					$(this).attr("readonly","readonly");
				}
			});
    }

	function addRowUpdateNumber(goodInfo,stateArray){		
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

		var addtype="";

		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsbarcode){
				addtype="1";
				return;
			}
		}
		
		// 添加商品到列表 begin
    	var readonlyFlg=document.getElementById("autoCount");

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
	<c:if test="${permissionPo.keyf == 1}">	
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);	
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
		var c13 = row.insertCell(11);
		</c:if>
	</c:if>
	<c:if test="${permissionPo.keyf == 0}">	
		var c10 = row.insertCell(6);
		var c11 = row.insertCell(7);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c13 = row.insertCell(8);
		</c:if>
	</c:if>
	
		row.className = 'row';
		row.height="26";
		
		// 添加商品到列表 end	
	   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >';
	        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
	        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
			c4.innerHTML = goodInfo.bgispec+'<input type="hidden" id="bgispec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';
			c5.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'" );\'>' + goodInfo.cshaaemaxquantity+'</a><input type="hidden" id="bgispec" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';

			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");

			var goodsnumber="0";
			var nottaxrateamount = "0.00";
			if(goodInfo.bgigoodsquantity){
				goodsnumber=goodInfo.bgigoodsquantity;
				 
			}
			if(goodInfo.cstienottaxrateamount){
				nottaxrateamount=goodInfo.cstienottaxrateamount;
				 
			}
			
	    	if(readonlyFlg.checked){
	    	<c:if test="${permissionPo.keyf == 1}">	
	    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';		
				</c:if>
				    c7.innerHTML = '<input type="text" class="text_input80" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
					c8.innerHTML = '<input type="text" class="text_input60" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
					c9.innerHTML = '<input type="text" class="text_input60" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
					c10.innerHTML = '<input type="text" class="text_input60" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
					if(goodInfo.bgiretailpriceamount){
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}else{
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
					<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
					               + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'		
				   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
									+ '<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
									+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
					</c:if>
					<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
				              		+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'		
			   						+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
									+ '<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
									+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
					</c:if>
					c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
					if(goodInfo.bgiretailpriceamount){
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}else{
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}
			</c:if>	

	    	}else{
	    	<c:if test="${permissionPo.keyf == 1}">	
	    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
	 			</c:if>	
	 			<c:if test="${systemParameterPo.fspbarcodetype==3}">
	 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+		
	 								'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
	 			</c:if>	
				c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c8.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
			    c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
				if(goodInfo.bgiretailpriceamount){
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}else{
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
				<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
						c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'
						 +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
						+ '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
						c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'
					    +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
						+ '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>'+
						'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
				</c:if>
				c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
				if(goodInfo.bgiretailpriceamount){
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}else{
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}
			</c:if>

        	}
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	   			c13.innerHTML= '<input id="selectGbc" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'">'+
				'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
				$('#del'+index).btn().init();
			</c:if>
			$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
				if('${permissionPo.keyg}'!='1'){
					$(this).attr("readonly","readonly");
				}
			});
    }
    
     //子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		amount();
	}
	
	function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.bgigoodsbarcode){
			   $(this).parent().parent().remove();
			   	
            }
		});

		amount();
		initPriceAmount();
    }
     
    function scanbarcode(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initScanBarcode.action",350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action",350,55,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【条码扫描】";
	}
    
    function loadBar(obj)
    {
    	var indexval = null;
		var goodidval = null;
		
		$('input[name=goodsInfoTempPo.goodsbarcode]').each(function (){
			if(obj.toUpperCase()==$(this).val().toUpperCase()){
				indexval = $(this).val();
				goodidval = $(this).val();
			}
		});

		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		
		$('input[value='+indexval+']').val(obj);
		var getinput = $('input[value='+indexval+']');
		loadBarCodeUpdateNumber(getinput,goodidval);
	}

    function loadBarUpdateNumber(obj)
    {
    	var indexval = null;
		var goodidval = null;
		
		$('input[name=goodsInfoTempPo.goodsbarcode]').each(function (){
			if(obj.toUpperCase()==$(this).val().toUpperCase()){
				indexval = $(this).val();
				goodidval = $(this).val();
			}
		});

		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		
		$('input[value='+indexval+']').val(obj);
		var getinput = $('input[value='+indexval+']');
		loadBarCodeUpdateNumber(getinput,goodidval);
	}
	
    function loadBarCode(barCodeInputObj,goodsId){
		$(barCodeInputObj).parent().parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
		$(barCodeInputObj).parent().parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().parent().find('.gbc option').size();
		autoCountOnlyOne($(barCodeInputObj).parent().parent().parent().find('.number')[0]);
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){			   
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
	}

    function loadBarCodeUpdateNumber(barCodeInputObj,goodsId){
		if(!barCodeInputObj.size > 0){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		}
		if(barCodeInputObj.val().length<26)
		{
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().find('.gbc').val(barCodeInputObj.val().toUpperCase());
		$(barCodeInputObj).parent().parent().find('.number')[0].value=parseFloat($(barCodeInputObj).parent().parent().find('.number')[0].value) + 1;
		autoCountOnlyOne($(barCodeInputObj).parent().parent().find('.number')[0]);
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
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
    function removeOption(item){
		$(item).parent().parent().find('.gbc').find('option:selected').remove();
		$(item).parent().parent().parent().find('.number')[0].value=$(item).parent().parent().find('.gbc option').size();
		autoCountOnlyOne($(item).parent().parent().parent().find('.number')[0]);		
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
	}
    
    function onBlurBarCode(barCodeInputObj,goodsId)
    {
		if(event.keyCode==13){
			var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
			var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
			if(goodsId != barCode){
				alert("商品代码与商品条码不符！");
				barCodeInputObj.val('');
				return;
			} 
			
			if(barCodeInputObj.val().length<26)
			{
				alert("商品条码位数不符！");
				barCodeInputObj.val('');
				return;
			}
			
			$(barCodeInputObj).parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
			barCodeInputObj.val('');
			barCodeInputObj.focus();
			
			$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();
			autoCountOnlyOne($(barCodeInputObj).parent().parent().find('.number')[0]);			
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		}
	}
    
   /**
	*  二维表开窗事件
	*/
	function open2D(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsOpen_dimensional.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen_dimensional.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【二维表查询】";
	}
	
	// 二维开窗赋值实现方法
	function openGoodsDimensionValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
		  if(goodInfos[i].v!=''){
			addDimensionRow(goodInfos[i]);	
		  }		
		}
		initAutoCount();	
	}
	function addDimensionRow(goodInfo){
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");		

		var addtype="";

		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsbarcode){
				addtype="1";
				return;
			}
		}
		
		// 添加商品到列表 begin
    	var readonlyFlg=document.getElementById("autoCount");

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
	<c:if test="${permissionPo.keyf == 1}">	
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);	
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 	
		var c13 = row.insertCell(11);
		</c:if>
	</c:if>
	<c:if test="${permissionPo.keyf == 0}">	
		var c10 = row.insertCell(6);
		var c11 = row.insertCell(7);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c13 = row.insertCell(8);
		</c:if>
	</c:if>
	
		row.className = 'row';
		row.height="26";
		
		// 添加商品到列表 end	
	   		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsbarcode + '" >';
	        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
	        c3.innerHTML = goodInfo.bgigoodsname + '<input type="hidden" index="'+index+'" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
			c4.innerHTML = goodInfo.bgispec+'<input type="hidden" id="bgispec" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';
			c5.innerHTML = '<a href=\'javascript:getCallAbleNum("'+goodInfo.bgigoodsid+'","'+goodInfo.bgigoodsbarcode+'" );\'>' + goodInfo.cshaaemaxquantity+'</a><input type="hidden" id="bgispec" name="goodsInfoTempPo.cshaaemaxquantity" value="' + goodInfo.cshaaemaxquantity +'" />';
			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");

			var goodsnumber="0";
			var nottaxrateamount = "0.00";
			if(goodInfo.bgigoodsquantity){
				goodsnumber=goodInfo.bgigoodsquantity;
				 
			}
			if(goodInfo.cstienottaxrateamount){
				nottaxrateamount=goodInfo.cstienottaxrateamount;
				 
			}

	    	if(readonlyFlg.checked){
	    	<c:if test="${permissionPo.keyf == 1}">	
	    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';		
				</c:if>
				    c7.innerHTML = '<input type="text" class="text_input80" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
					c8.innerHTML = '<input type="text" class="text_input60" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
					c9.innerHTML = '<input type="text" class="text_input60" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
					c10.innerHTML = '<input type="text" class="text_input60" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
					if(goodInfo.bgiretailpriceamount){
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}else{
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
					<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
					               + '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'		
				   					+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
									+ '<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
									+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />';
					</c:if>
					<c:if test="${systemParameterPo.fspbarcodetype==3}">
					c6.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" />'
				              		+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'		
			   						+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'				
									+ '<input type="hidden" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
									+ '<input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/> <input type="hidden" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" />'+
									'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
					</c:if>
					c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
					if(goodInfo.bgiretailpriceamount){
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}else{
						c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
					}
			</c:if>	

	    	}else{
	    	<c:if test="${permissionPo.keyf == 1}">	
	    		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
	 			</c:if>	
	 			<c:if test="${systemParameterPo.fspbarcodetype==3}">
	 				c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/>'+		
	 								'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
	 			</c:if>	
				c7.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c8.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
			    c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
				if(goodInfo.bgiretailpriceamount){
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}else{
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}
			</c:if>
			<c:if test="${permissionPo.keyf == 0}">	
				<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
						c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'
						 +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
						+ '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>';
				</c:if>
				<c:if test="${systemParameterPo.fspbarcodetype==3}">
						c6.innerHTML = '<input type="text" onchange="totalCount();" class="text_input60 number" value="'+goodsnumber+'" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的商品数量！\'}]"/><input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="'+nottaxrateamount+'" />'
					    +'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'			
						+'<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>'
						+ '<input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的价税合计！\'}]"/><input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00"/>'+
						'<input id="selectGbc" type="hidden" name="goodsInfoTempPo.goodsbarcode" value ="'+goodInfo.bgigoodsbarcode+'"/>';	
				</c:if>
				c10.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.cstietakeprice" value="' + goodInfo.bgiretailprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的领用单价！\'}]"/><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'"/>';
				if(goodInfo.bgiretailpriceamount){
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="'+goodInfo.bgiretailpriceamount+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}else{
					c11.innerHTML = '<input type="text" readonly="readonly" style="background-color:#ACA899" name="goodsInfoTempPo.cstietakepriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写领用金额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Float, \'Message\' : \'请填写正确的领用金额合计！\'}]"/> <input type="hidden" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" /><input type="hidden" name="goodsInfoTempPo.costpriceamount" value="0.00"/>';
				}
			</c:if>

        	}
			<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
	   			c13.innerHTML= '<input id="selectGbc" name="goodsInfoTempPo.goodsbarcode" readonly="readonly" multiple="multiple" class="text_input200 gbc" value ="'+goodInfo.bgigoodsbarcode+'">'+
				'<input index="index'+index+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="hidden" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/>';
				$('#del'+index).btn().init();
			</c:if>
    } 
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="salesOutForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" />  
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="cstisourcebillid" id="cstisourcebillid" value="${inventoryPo.cstisourcebillid}" /> 

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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">${inventoryPo.cstibillid}<input type="hidden" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}"></TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD width="24%" class="table_none">
			               	 ${fn:substring(inventoryPo.cstibilldate,0,10)}
			               </TD>
			               <TD width="9%" height="26" class="table_body">领用类型</TD>
			               <TD class="table_none">${inventoryPo.cstitaketype=='1'?'部门领用':'客户领用'}
						   		<input type="hidden"  name="inventoryPo.cstisupplierid" value="${inventoryPo.cstisupplierid}"/></TD>
                        </TR>                        
                        <TR>
                           <TD height="26" class="table_body">${inventoryPo.cstitaketype=='1'?'领用部门':'领用客户'}</TD>
			               <TD class="table_none"> ${inventoryPo.cstidepartmentname}</TD>
			               <TD height="26" class="table_body">发出仓位</TD>
			               <TD class="table_none">${inventoryPo.cstioutstockname}<input type="hidden" id="cstioutstockid" name="inventoryPo.cstioutstockid" value="${inventoryPo.cstioutstockid}"></TD>
			               <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">${inventoryPo.csticreatepersonname}</TD>
                        </TR>
                         <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          <textarea id="textarea" name="inventoryPo.cstiremark">${inventoryPo.cstiremark}</textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <td width="20%">
	                          <input name="radiobutton" id="autoCount" type="radio" value="autoCount" checked="checked" onClick="changeRadioType(this,getInputState())"/>自动计算
	  				  		  <input type="radio" id="notAutoCount" name="radiobutton" value="notAutoCount" onClick="changeRadioType(this,getInputState())"/>手动计算
	  				  	  </td>
                          <TD align="left" width="50%">
                          <c:if test="${systemParameterPo.fspbarcodetype==2||systemParameterPo.fspbarcodetype==3}">
						  <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
						   <!-- 
						   <img src="${ctx}/img/newbtn/btn_addtwogoods_0.png" btn=btn title="二维表添加商品" id="2D" onClick="javascript:open2D();"> 
						   -->
						  </c:if> 
					       <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
					       <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
					       </c:if>
                          <img id="del" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="deleteitem();">
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
                        <TR class=table_title align=middle>                     
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH scope=col width="15%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>						
                          <TH scope=col width="10%">型号</TH>  
                          <TH scope=col width="5%">库存数量</TH>                        
 						  <TH scope=col width="5%">数量</TH>	
 						<c:if test="${permissionPo.keyf == 1}">
 						  <TH scope=col width="7%">单位成本</TH>
						  <TH scope=col width="7%">成本合计</TH>
						
                          <TH scope=col width="5%">税率</TH>
                        </c:if>  
                          <TH scope=col width="7%">领用单价</TH>
                          <TH scope=col width="7%">领用金额</TH>
						 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  <TH scope=col width="10%">商品条码</TH>	
						  </c:if>					  
                        </TR>
                        <tr class=table_title align=middle> 
						  	<th width="45%" height="26"  colSpan=5 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    <c:if test="${permissionPo.keyf == 1}">	
					    	<th scope=col width="7%">&nbsp;</th>
					    	<th scope=col width="10%" id="nottaxrateamountTotal">&nbsp;</th>
					   
					    	<th scope=col width="6%">&nbsp;</th>
					    </c:if> 	
					        <th scope=col width="7%" >&nbsp;</th>
					    	<th scope=col width="10%" id="takepriceamountTotal">&nbsp;</th>
					    	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
					    	<th scope=col width="7%">&nbsp;</th> </c:if>
				   		</tr>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          		<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</li>
                          	<c:if test="${(permissionPo.keyh==1)}">
                          	<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstiauditstate" name="inventoryPo.cstiauditstate" value="1">保存并审核
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
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<script>
	initPriceAmount();
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>