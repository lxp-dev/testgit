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
	});
	
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
		
		var cstpgoodscategory = document.getElementById('categoryID').value;
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
		
		
		if(goodsquantityCount==0){
	        alert('请选择商品!');
	        return false;
        }
		
		$("img").removeAttr("onclick");
		procurementReceiptForm.action = "updateProcurementWaityx.action";
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
		row.height="28";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = goodInfo.bgicolor;
		c6.innerHTML = goodInfo.bgisph;		
		c7.innerHTML = goodInfo.bgicyl;				
		c8.innerHTML = goodInfo.bgiaxis;
		c9.innerHTML = goodInfo.bgicurvature1;
		c10.innerHTML = goodInfo.bgidia;
		c11.innerHTML = '<input type="text" class="text_input40" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
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
		c11.innerHTML = '<input type="text" class="text_input40" maxlength="18" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
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
					alert(sources[i].value);
					alert(colors[i].value);
					alert(retailprices[i].value);
					alert(guaranteeperiods[i].value);
					alert(batchs[i].value);*/
				
					person[person.length] = persons.val();
					barCode[barCode.length] = barCodes[i].value;
					quantity[quantity.length] = goodsQuantitys[i].value;
					
					brandname[brandname.length] = brandnames[i].value;
					source[source.length] = sources[i].value;
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
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
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
    		if(type == "4"){
    		
    			$('[id=qj]').show();
    			$('[id=zj]').show();
    			$('[id=ql]').show();
    			$('[id=zhj]').show();
    			$('[id=sylx]').show();
    			$('[id=pqxfl]').show();
    			$('[id=zrl]').hide();
    			$('[id=crl]').hide();
    			$('[id=xq]').show();
    			$('[id=rksj').show();

    			$('#heji').attr("colSpan","15");
    			
    		}else if(type == "5"){
    		
    			
    			$('[id=qj]').hide();
    			$('[id=zj]').hide();
    			$('[id=zhj]').hide();
    			$('[id=ql]').hide();
    			$('[id=sylx]').hide();
    			$('[id=pqxfl]').hide();
    			$('[id=zrl]').show();
    			$('[id=crl]').show();
    			$('[id=xq]').show();
    			$('[id=rksj').show();
    			$('#heji').attr("colSpan","11");
    			
    		}
    		
    		$('#div_goodslist').attr("style","display:");
    	}
    }  
	
	window.onload = function(){
		isshow(${inventoryPo.cstigoodscategory});
		amount();
	};
	

	 function changebarcode(index,obj){
			if(!obj.val()){
				return;
			}
	   	   	
	   	   	if(!/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})/.test(obj.val())&&obj.val()){
				alert("日期格式不正确！\n如：2013-04-01");
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
		   		$(obj).parent().parent().find("#pcbarcode").val(tmvalue+xqvalue+bcvalue);
	   	   	}
	   	}

	   	function loadSimpleBatch(barcode,batch,obj){
	   	   	if(($(obj).attr("id") == "batch"&&$(obj).parent().parent().find("#guaranteeperiod").val() != "")||($(obj).attr("id") == "guaranteeperiod"&&$(obj).parent().parent().find("#batch").val() != "")){
		   	   	$.ajax({           
			   	 	type: "POST",          
		   	   	    url: "getAjaxSimpleBatch.action",          
		   	   	    async: true, 
		   	   	    data: "barcode="+barcode+"&batch="+batch,     
		   	   	    success: function(msg){
			   	   		var barcodestr = $(obj).parent().parent().find("#pcbarcode").val();   
			   	   		$(obj).parent().parent().find("#pcbarcode").val(barcodestr.substring(0,24)+msg);                       
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

	function copyRow(obj){
	    $(obj).parent().parent().clone(false).appendTo($(obj).parent().parent());
	    amount();
	}
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
                          <input class="text_input200" id="cstibillid" name="cstibillid" value="${inventoryPo.cstibillid}" readonly="readonly">
                          <input type="hidden" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}">
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
                          <TD class="table_none" >${person.personName}<input type="hidden" id="person" value="${person.id}"></TD>
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
						  <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');" title="删除" onClick="deleteitem();" >
                         	<img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();">
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
                          <TH width="13%" scope=col>商品代码</TH>
                          <TH width="12%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>型号</TH>
                          <TH width="5%" scope=col id=qj>球镜</TH>
                          <TH width="5%" scope=col id=zj>柱镜</TH>
                          <TH width="5%" scope=col id=ql>曲率</TH>
                          <TH width="5%" scope=col id=zhj>直径</TH>
                          <TH width="6%" scope=col id=sylx>使用类型 </TH>
                          <TH width="6%" scope=col id=pqxfl>抛弃型分类</TH> 
                          <TH width="6%" scope=col id=zrl>主容量</TH>
                          <TH width="6%" scope=col id=crl>次容量</TH> 
                          <TH width="6%" scope=col id=rksj>入库时间 </TH>
                          <TH width="5%" scope=col id=xq>效期</TH>
                          <TH width="5%" scope=col id=xq>批号</TH>
                          <TH width="5%" scope=col id=xq>注册证号</TH>
                          <TH width="8%" scope=col>商品条码</TH>
                          <TH width="5%" scope=col>数量</TH>                           
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26" id=heji colSpan="14" scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                        <c:forEach var="i" items="${procurementInventoryEntryList}" varStatus="index"> 
                        <TR class="row">
                        <TD height="26"><input id="chk" type="checkbox" value="${cstiegoodsid}" ></TD>
                        <TD><img src="${ctx}/img/newbtn/addgoods_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');" btn=btn title='复制商品' onClick='copyRow(this);'>${i.cstiegoodsid}
                        <input type="hidden" name="goodsInfoTempPo.goodsid" value="${i.cstiegoodsid}" />
                        <input type="hidden" name="goodsInfoTempPo.costprice" value="${i.cstiecostprice}" />
                        <input type="hidden" name="goodsInfoTempPo.nottaxrate" value="${i.cstienottaxrate}" />
                        <input type="hidden" name="goodsInfoTempPo.taxrate" value="${i.cstietaxrate}" />
                        <input type="hidden" id="brandname" value="${i.cstiebrandname}" />
                        <input type="hidden" id="source" value="${i.cstiesource}" />
                        <input type="hidden" id="spec" value="${i.cstiespec}" />
                        <input type="hidden" id="color" value="${i.cstiecolor}" />
                        <input type="hidden" id="retailprice" value="${i.bgiretailprice}" />
                        </TD>
                        <TD>${i.cstiegoodsname}</TD>
                        <TD>${i.cstiespec}</TD>
                        <TD id=qj>${i.cstiesph}</TD>
                        <TD id=zj>${i.cstiecyl}</TD>
                        <TD id=ql>${i.cstiecurvature1}</TD>
                        <TD id=zhj>${i.cstiedia}</TD>
                        <TD id=sylx><c:if test="${i.bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${i.bgiusetype=='2'}">抛弃型</c:if>	
		                          	<c:if test="${i.bgiusetype=='3'}">塑形镜</c:if>	 </TD>
                          <TD id=pqxfl>	<c:if test="${i.bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${i.bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${i.bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${i.bgistealthclass=='7'}"> RGP</c:if></TD> 
                          <TD id=zrl>${i.bgicapacity}</TD>
                          <TD id=crl>${i.bgicapacityentry}</TD> 
                          <Td id=rksj><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" /><input type="hidden"  id="bgirksj"  readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />" /></Td>
                         <TD id=xq><input type="text" class="text_input80" id="guaranteeperiod" name="goodsInfoTempPo.guaranteeperiod" onblur="changebarcode('',$(this));loadSimpleBatch($(this).parent().parent().find('#pcbarcode').val(),$(this).parent().parent().find('#batch').val(),this);" value="${i.cstieguaranteeperiod}"/></TD>
						<TD id=xq><input type="text" class="text_input80" maxlength="15" id="batch" onblur="loadSimpleBatch($(this).parent().parent().find('#pcbarcode').val(),$(this).val(),this);" name="goodsInfoTempPo.batch"  value="${i.cstiebatch}"/></TD>
						<TD id=xq><input type="text" class="text_input80" maxlength="26" id="registrationnum" name="goodsInfoTempPo.registrationnum"  value="${i.cstieregistrationnum}"/></TD>
                         <TD><input type="text" class="text_input200" maxlength="26" id="pcbarcode" index="${index.index }" name="goodsInfoTempPo.goodsbarcode"  value="${fn:substring(i.cstiepcbarcode,0,24)}A0" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品条码! '}]"/></TD>
                        <TD><input type="text" class="text_input40" id=quantity name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="${i.cstiegoodsquantity}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '商品数量应为整数！'}]"/></TD>                                                                        
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