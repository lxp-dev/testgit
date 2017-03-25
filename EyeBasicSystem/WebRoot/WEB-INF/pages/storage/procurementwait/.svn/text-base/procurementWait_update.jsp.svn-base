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
			//alert(barCodes.length);
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
					//alert(persons[0].value);
					//alert(barCodes[i].value);
					//alert(goodsQuantitys[i].value);
					//alert(brandnames[i].value);
					//alert(sources[i].value);
					//alert(specs[i].value);
					//alert(colors[i].value);
					//alert(retailprices[i].value);
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
				//try {
					printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,'','');
				///} catch(e) {
				//	alert("打印失败,请检查条码打印机是否正确连接!");
				//}
			}
		}
	}	
	
	function save(){
		if('${systemParameterPo.fspisfillindeliveryid}' == '1'){
			if(!$("#deliveryID").val().trim()){
				alert("请填写运单单号！");
				$("#deliveryID").focus();
				return;
			}
		}
		
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
		
		if(goodsquantityCount==0){
          alert('请选择商品!');
          return false;
        }
        
		$("img").removeAttr("onclick");
		procurementReceiptForm.action = "updateProcurementWait.action";
		procurementReceiptForm.submit();
		}
	}
		
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);			
		}
	}
	
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) return;
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
		var c11 = row.insertCell(10);
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" id=pcbarcode value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgicolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgiaxis;
		c9.innerHTML = goodInfo.bgicurvature1;
		c10.innerHTML = goodInfo.bgidia;
		c11.innerHTML = '<input type="hidden" id="retailprice" name="retailprice" value="'+goodInfo.bgiretailprice+'" /><input type="text" class="text_input40" onkeydown="OnKeyDownEnter(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
    }
	function openProcurementOrdersValues(objValue,poID){
		
		document.all.cstisourcebillid.value=poID;
		
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
			addRow2(goodInfos[i]);			
		}	
	
	}
	
	function addRow2(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) return;
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
		var c11 = row.insertCell(10);
		row.className = 'row';
		row.height="28";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgicolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgiaxis;
		c9.innerHTML = goodInfo.bgicurvature1;
		c10.innerHTML = goodInfo.bgidia;
		c11.innerHTML = '<input type="text" class="text_input40" onkeydown="OnKeyDownEnter(this)" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
    }        
    
    function deleteitem(){
    
    	
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

	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=goodsInfoTempPo.goodsquantity]").index(obj)+1;
		    $("input[name=goodsInfoTempPo.goodsquantity]").eq(index).focus();
		}
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
    			$('[id=xq]').hide();
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
    			$('[id=xq]').hide();
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
    			$('[id=xq]').hide();
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
    				$('[id=xq]').show();
					$('#heji').attr("colSpan","12");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('[id=xq]').hide();
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
    				$('[id=xq]').show();
					$('#heji').attr("colSpan","8");
				}
				if(${systemParameterPo.fspbarcodetype}=='3')
				{
					$('[id=xq]').hide();
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
    			$('[id=xq]').hide();
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
    			$('[id=xq]').hide();
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
    			$('[id=xq]').hide();
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
    			$('[id=xq]').hide();
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
	
    $(document).ready(function() {
		isshow(${inventoryPo.cstigoodscategory});
		amount();
		$("input[id=pcbarcode]").each(function (){
			$(this).val($(this).val().toUpperCase());
		});
    });
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="cstpsupplierid" id="cstpsupplierid" value="${requestScope.cstpsupplierid}" />
<input type="hidden" name="inventoryPo.cstigoodscategory" id="categoryID" value="${inventoryPo.cstigoodscategory}" /> 
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
            </TD></TR>
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
                          <TD width="9%" class="table_body" height="30">采购收货编号</TD>
                          <TD width="23%" class="table_none">
                          <input class="text_input200" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}" readonly="readonly">
                         
                          </TD>
                          <TD width="9%" class="table_body">订单号</TD>
                          <TD width="23%" class="table_none">
                          <input class="text_input200" id="tisourcebillid" name="tisourcebillid" value="${inventoryPo.cstisourcebillid}" readonly="readonly">
                          <input type="hidden" name="inventoryPo.cstisourcebillid" id="cstisourcebillid" value="${inventoryPo.cstisourcebillid}" /> 
						  </TD>
						  <TD class="table_body" width="9%">制造商</TD>
                          	<TD class="table_none" width="23%"> 
                          		${supplierPo.bspsuppliername}
						   		<input type="hidden" id="cstisupplierid" name="inventoryPo.cstisupplierid" value="${supplierPo.bspid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						  </TD>
                        </TR>
                        <TR>						       
                                <TD  class="table_body">入库类型</TD>
                          		<TD  class="table_none">采购收货<input type="hidden" name="inventoryPo.cstibilltypeid" id="cstibilltypeid" value="1" />
                          		<input type="hidden" name="cstibilltypeid" id="cstibilltypeid" value="${inventoryPo.cstibilltypeid}" /> 
						  		</TD>
						  		 <TD class="table_body" height="30">收入仓位</TD>
                          <TD class="table_none" colSpan=3>
                            <select id="cstiinstockid" name="inventoryPo.cstiinstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取收入仓位！'}]">
                               <option value="" ${warehouseConfigurationPo.bwcstockid3 == '' ? 'selected="selected"' : '' }>----请选择----</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${warehouseConfigurationPo.bwcstockid3 == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
						</TR>
						<TR>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${person.personName}</TD>
  							<TD  class="table_body" height="30">单据日期</TD>
                          <TD  class="table_none">
                          <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input id="cstibilldate" name="inventoryPo.cstibilldate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/>
                          </TD>	
                          <TD class="table_body">运单号</TD>
                          <TD class="table_none">
                          	<input type="text" class="text_input160" maxlength="32" id="deliveryID" name="inventoryPo.deliveryID" value="${inventoryPo.deliveryID}" >
                          </TD>	
                          
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
                          <TD align="left">

						  <img src="${ctx }/img/newbtn/btn_delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');" title="删除" onClick="deleteitem();" >
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
					       <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();">
					      </c:if>
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
                        <TR class=table_title align=middle>
                          <TH width="8%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
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
						  	<TH width="40%" height="26" id=heji colSpan=11 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                        <c:forEach var="i" items="${procurementInventoryEntryList}" varStatus="index"> 
                        <TR class="row">
                        <TD height="26"><input id="chk" name="chk" type="checkbox" value="${cstiegoodsid}"></TD>
                        <TD>${i.cstiegoodsid}
	                        <input type="hidden" name="goodsInfoTempPo.goodsid" value="${i.cstiegoodsid}"/>
	                        <input type="hidden" name="goodsInfoTempPo.costprice" value="${i.cstiecostprice}"/>
	                        <input type="hidden" name="goodsInfoTempPo.nottaxrate" value="${i.cstienottaxrate}"/>
	                        <input type="hidden" name="goodsInfoTempPo.taxrate" value="${i.cstietaxrate}"/>
	                        <input type="hidden" id="retailprice" name="retailprice" value="${i.bgiretailprice}"/>
	                        <input type="hidden" id="brandname" name="brandname" value="${i.cstiebrandname }"/>
	                        <input type="hidden" id=source name="cstiesource" value="${i.cstiesource }"/>
	                        <input type="hidden" id=spec name="cstiespec" value="${i.cstiespec }"/>
	                        <input type="hidden" id=color name="cstiecolor" value="${i.cstiecolor }"/>
	                        <input type="hidden" id=person name="person" value="${person.id}"/>
                        </TD>
                        <TD>${i.cstiegoodsname}</TD>
                        <TD>${i.cstiespec}</TD>
                         <td  id=ys>${i.cstiecolor}</td>
                          <td  id=qj>${i.cstiesph}</td>
                          <td  id=zj>${i.cstiecyl}</td>
                          <td  id=xjg>${i.bgibelowplusluminosity}</td>
                          <td  id=zsl>${i.bgirefractive}</td>
                          <td  id=gdfl> <c:if test="${i.bgiismutiluminosity=='M'}">  多光</c:if>
		                          	<c:if test="${i.bgiismutiluminosity=='0'}"> 单光</c:if>
		                          	<c:if test="${i.bgiismutiluminosity=='Q'}"> 其它</c:if>
		                          	<c:if test="${i.bgiismutiluminosity=='K'}"> 抗疲劳</c:if>
		                          	<c:if test="${i.bgiismutiluminosity=='J'}"> 渐近</c:if>
                          </td>
                          <td id=clfl>	<c:if test="${i.bgieyeglassmaterialtype=='1'}"> 树脂</c:if>
		                          	<c:if test="${i.bgieyeglassmaterialtype=='2'}"> 玻璃</c:if>
		                          	<c:if test="${i.bgieyeglassmaterialtype=='3'}"> PC</c:if>		</td>
                          <td id=ql>${i.cstiecurvature1}</td>
                          <td id=zhj>${i.cstiedia}</td> 
                          <td id=kjcz>${i.bgiframematerialtypename}</td>
                          <td id=kjcc>${i.bgiframesize}</td>
                          <td id=pjlx> 	<c:if test="${i.bgiaccessoriestype=='1'}"> 框镜</c:if>
		                          	<c:if test="${i.bgiaccessoriestype=='2'}"> 隐形</c:if></td>
                          <td id=sylx><c:if test="${i.bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${i.bgiusetype=='2'}">抛弃型</c:if>
		                          	<c:if test="${i.bgiusetype=='3'}">塑形镜</c:if> </td>
                          <td id=pqxfl>	<c:if test="${i.bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${i.bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${i.bgistealthclass=='7'}"> RGP</c:if>	   
		                          	</td>
                          <td id=lhjds>${i.cstiesph}</Td>
                          <td id=cjsh>${i.bgisuppliercolor} </Td>
                          <td id=zrl>${i.bgicapacity}  </Td>
                          <Td id=crl>${i.bgicapacityentry} </Td>
                           <Td id=rksj><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" /><input type="hidden"  id="bgirksj"  readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />" /></Td>
                        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
                         <TD><input type="text" class="text_input200" readonly="readonly" maxlength="26" name="goodsInfoTempPo.goodsbarcode" id=pcbarcode value="${i.cstiepcbarcode}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品条码! '}]"/></TD>
                        </c:if>
                        <TD><c:if test="${systemParameterPo.fspbarcodetype==3}"><input type="hidden" name="goodsInfoTempPo.goodsbarcode" id=pcbarcode value="${i.cstiepcbarcode}"></c:if><input id=quantity onkeydown="OnKeyDownEnter(this)" type="text" class="text_input40" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="${i.cstiegoodsquantity}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/></TD>                                                                        
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                    <c:if test="${(permissionPo.keyk==1)}">
                        <TR>
                          <TD align="left"><input type="checkbox" id="cstiauditstate" name="inventoryPo.cstiauditstate" value="1" >保存并审核
                           </TD>
					   </TR>
					</c:if>
					   <TR>
						  <TD align="left">
						  <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" title='保存' onclick="save();">	
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