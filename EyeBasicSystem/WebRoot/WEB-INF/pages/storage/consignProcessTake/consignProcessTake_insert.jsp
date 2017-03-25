<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外收货管理</title>

</head>
<script>
	function trim(str){ //删除左右两端的空格
　　  	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }
	
	function batPrintGoodsBarCode(){
		var ids = $('input[barcode=barcode]').size();
		
		if(ids !=0){
			var barCodes = $('input[barcode=barcode]');
			var retailprices = $("input[id=retailprice]");
			var barCode = new Array();
			var quantity = new Array();
			var retailprice = new Array();
			for(var i=0 ; i< ids; i++){
				barCode[barCode.length] = barCodes[i].value;
				quantity[quantity.length] = 1;
				retailprice[retailprice.length] = retailprices[i].value;
			}
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
				printBarCode(barCode, quantity,'','','','',retailprice,'',printtype,'','');
			} catch(e) {
				alert("打印失败!请检查条码打印机是否正确连接!");
			}
		}
	}	
	function search(){
		$("img").removeAttr("onclick");
		consignProcessTakeFrom.action = "consignProcessTakeInsert.action";
		consignProcessTakeFrom.submit();
	}
	
	function OrdersSelect(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSalesIdSel.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSalesIdSel.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
	}
	
	function sendSelect(id){
		
	}
	
	function save(){
		if('${systemParameterPo.fspisfillindeliveryid}' == '1'){
			if(!$("#waybillid").val().trim()){
				alert("请填写运单单号！");
				$("#waybillid").focus();
				return;
			}
		}
		
		var barcode = document.getElementById('barcode').value;
		if(barcode==''){
			alert('请填写商品条码!');
			return false;
		}
		
		var cstpgoodscategory = '${consignProcessOrderDetailsPo.cstcpodbilltype }';
		<c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessOrderDetailsPo.cstcpodbilltype==4)}">
		if(cstpgoodscategory == '4' || cstpgoodscategory == '5'){
			var guaranteeperiod = document.getElementsByName("consignProcessReceiptDetailsPo.cstcpguaranteeperiods");
			for(i=0;i<guaranteeperiod.length;i++){
				
				if(guaranteeperiod[i].value==""){
					alert("请填写商品效期！");
					guaranteeperiod[i].focus();
					return;	
				}
			}
			
			var batch = document.getElementsByName("consignProcessReceiptDetailsPo.cstcpbatchs");
			
			for(i=0;i<batch.length;i++){
				if(batch[i].value==""){
					alert("请填写商品批号！");
					batch[i].focus();
					return;	
				}
			}
			
			<c:if test="${systemParameterPo.fspisregistrationnum eq '1'}">
				var registrationnum = document.getElementsByName("consignProcessReceiptDetailsPo.cstcpregistrationnums");
				
				for(i=0;i<registrationnum.length;i++){
					if(registrationnum[i].value==""){
						alert("请填写商品注册证号！");
						registrationnum[i].focus();
						return;	
					}
				}
			</c:if>
		}
		</c:if>
		
		var lengthOD = $("input[rl=R][id=numcount]").size();
		var goodsidsOD = $("input[rl=R][id=numcount]");
		var isSaveOD = 0;
		for(var i=0; i<lengthOD; i++){
			var numcount = 0;
			$("input[rl=R][id=numcount][goodsid="+goodsidsOD.eq(i).attr("goodsid")+"]").each(function (){
				numcount = accAdd(numcount,$(this).val());
			});
			
			var cstcprdnum = 0;
			$("input[rl=R][id=cstcprdnum][goodsid="+goodsidsOD.eq(i).attr("goodsid")+"]").each(function (){
				cstcprdnum = accAdd(cstcprdnum,$(this).val());
			});
			
			if(cstcprdnum != numcount){
				isSaveOD = 1;
				break;
			}
		}
		
		if(isSaveOD == 1){
			alert("右眼填写数量应等于收货数量！");
			return;
		}
		
		var lengthOS = $("input[rl=L][id=numcount]").size();
		var goodsidsOS = $("input[rl=L][id=numcount]");
		var isSaveOS = 0;
		
		for(var i=0; i<lengthOS; i++){
			var numcount = 0;
			$("input[rl=L][id=numcount][goodsid="+goodsidsOS.eq(i).attr("goodsid")+"]").each(function (){
				numcount = accAdd(numcount,$(this).val());
			});
			
			var cstcprdnum = 0;
			$("input[rl=L][id=cstcprdnum][goodsid="+goodsidsOS.eq(i).attr("goodsid")+"]").each(function (){
				cstcprdnum = accAdd(cstcprdnum,$(this).val());
			});
			
			if(cstcprdnum != numcount){
				isSaveOS = 1;
				break;
			}
		}
		
		if(isSaveOS == 1){
			alert("左眼填写数量应等于收货数量！");
			return;
		}
		
		var goodsQuantities = $("input[name=consignProcessReceiptDetailsPo.cstcprdnums]");

		for(var i = 0; i < goodsQuantities.length; i++) {
			if(goodsQuantities[i].value == 0 || goodsQuantities[i].value == ''){
				alert("商品数量为空或0！");
				goodsQuantities[i].focus();
				goodsQuantities[i].select();
				return;
			}
		}
		
		if(checkForm(document.all.consignProcessTakeFrom)){
			if(confirm("确认委外收货吗？")){
				$("img").removeAttr("onclick");
				consignProcessTakeFrom.action = "insertConsignProcessTake.action?moduleID=${requestScope.moduleID}";
				consignProcessTakeFrom.submit();
			}
		}
	}
	
	function checkbarcode(goodsid,goodsbarcode){
		if(event.keyCode==13){//
			var tmp = goodsid.replace(/\./g,  "").toUpperCase();
			var tmp1 = goodsbarcode.value.substring(0,18);
			tmp1 = tmp1.toUpperCase();
			if(tmp != tmp1){
				alert("商品不符！");
				goodsbarcode.value="";
				goodsbarcode.focus();
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
		
			event.keyCode=9;
		}
	}
	
	function checkbarcodeBlur(goodsid,goodsbarcode){
			var tmp = goodsid.replace(/\./g,  "").toUpperCase();
			var tmp1 = goodsbarcode.value.substring(0,18);
			tmp1 = tmp1.toUpperCase();
			if(tmp != tmp1){
				alert("商品不符！");
				goodsbarcode.value="";
				goodsbarcode.focus();
				return;
			}
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	/**
	 * 订单开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('cstpid').value = json.id;
		document.getElementById('salesid').value = json.value;
		consignProcessTakeFrom.action = "consignProcessTakeInsert.action";
		consignProcessTakeFrom.submit();
	}
	/**
	 * 发货单开窗赋值实现方法
	 */
	function openDeValues(json){
		var ordersid=json.id;
		var indexnum=ordersid.indexOf('-' , ordersid);
		var id=ordersid.substring(indexnum+1);
		document.getElementById('cstpid').value = id;
		document.getElementById('salesid').value = json.value;
		document.getElementById('deliveryid').value = json.deid;
		consignProcessTakeFrom.action = "consignProcessTakeInsert.action";
		consignProcessTakeFrom.submit();
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
			$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
			$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	document.onkeydown=function(event){            
	  	var e = event || window.event || arguments.callee.caller.arguments[0];
     	if(e && e.keyCode==13){  
	 	   	var salesid=document.getElementById('salesid').value;
	 	   	if(salesid==""){
				return;
	 	    }
			consignProcessTakeFrom.action = "consignProcessTakeInsert.action?salesid="+salesid;
			consignProcessTakeFrom.submit();       
     	}        
   	}; 

   	function changebarcode(obj){
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
	    
	       
	   if(Month >=10){
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
		        
  	function copyRow(obj,json){
    	addCopyRow(obj,json);
   	
		$("input[name='goodsInfoTempPo.goodsquantity']").each(function(){
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
		
		htmltr.name="tr";	        
		htmltr.className = 'row';
		htmltr.height="26";
		
		c1.innerHTML = '&nbsp;';
        c2.innerHTML = goodInfo.cstcpogoodsname;
        c3.innerHTML = goodInfo.cstcpodglassflag;
		c4.innerHTML = goodInfo.cstcpodgoodsid;
		c5.innerHTML = '<input type="text" class="text_input60" goodsid="'+goodInfo.cstcpodgoodsid+'" rl="'+goodInfo.cstcpodglassflag+'" maxlength="5" id="cstcprdnum" name="consignProcessReceiptDetailsPo.cstcprdnums"  value="" onKeyUp="value=value.replace(/[^\\d\\.]/g,\'\')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!=\'\')this.value = new Number(this.value).toFixed(0);}"/>';		
		<c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessOrderDetailsPo.cstcpodbilltype==4)}">  
		c6.innerHTML = '<input type="text" class="text_input80" maxlength="15" id="guaranteeperiod" name="consignProcessReceiptDetailsPo.cstcpguaranteeperiods" onblur="changebarcode($(this));"  value=""/>';				
		c7.innerHTML = '<input type="text" class="text_input80" maxlength="15" id="batch" name="consignProcessReceiptDetailsPo.cstcpbatchs"  value=""/>';
		c8.innerHTML = '<input type="text" class="text_input80" maxlength="50" id="registrationnum" name="consignProcessReceiptDetailsPo.cstcpregistrationnums"  value="${cstcpregistrationnum}"/>';
		</c:if>
		c9.innerHTML = '<c:if test="${systemParameterPo.fspbarcodetype==1 || systemParameterPo.fspbarcodetype==2 }">'+
					   '<input class="text_input200" barcode="barcode" id="barcode" name="consignProcessReceiptDetailsPo.cstcprdbarcodes" value="'+goodInfo.cstcpodgoodsbarcode+'" onblur="checkbarcodeBlur('+goodInfo.cstcpodgoodsbarcode+',this)" maxlength="26">'+
					   '</c:if>'+
					   '<input type="hidden" name="consignProcessReceiptDetailsPo.cstcprflags" value="'+goodInfo.cstcpodglassflag+'"/>'+
					   '<input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdgoodsids" value="'+goodInfo.cstcpodgoodsid+'"/>'+
					   '<input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdnottaxrates" value="'+goodInfo.cstcponottaxrate+'"/>'+
					   '<input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdtaxrates" value="'+goodInfo.cstcpotaxrate+'"/>'+
					   '<input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdcostprices" value="'+goodInfo.cstcpocostprice+'"/>'+
					   '<input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdorderdetailsids" value="'+goodInfo.cstcpodid+'"/>'+
					   '<input type="hidden" name="consignProcessReceiptDetailsPo.cstcpodsalesids" value="'+goodInfo.cstcpodsalesid+'"/>'+
					   '<input type="hidden" id="retailprice" name="retailprice" value="'+goodInfo.cstcpretailprice+'"/>'+
					   '<c:if test="${systemParameterPo.fspbarcodetype==3}">'+
					   '<input type="text" barcode="barcode" id="barcode" name="consignProcessReceiptDetailsPo.cstcprdbarcodes" value="'+goodInfo.cstcpodgoodsbarcode+'" maxlength="26">'+
					   '</c:if>';
		
		htmltr.appendChild(c1);
		htmltr.appendChild(c2);
		htmltr.appendChild(c3);
		htmltr.appendChild(c4);
		htmltr.appendChild(c5);
		<c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessOrderDetailsPo.cstcpodbilltype==4)}"> 
		htmltr.appendChild(c6);
		htmltr.appendChild(c7);
		htmltr.appendChild(c8);
		</c:if>
		htmltr.appendChild(c9);

		obj.parentNode.parentNode.insertBefore(htmltr);
	}   
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="consignProcessTakeFrom" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="text" style="display: none" name="dis" id="dis">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
                          <TD class="table_body" width="10%" height="26">配镜单号</TD>
                          <TD class="table_none" width="90%">
                          	<li class="horizontal_onlyRight">
                          		<input type="hidden" id="cstpid" name="billID" value="${requestScope.billID }" />
                          		<input type="hidden" id="cstcprsalesid" name="cstcprsalesid" value="${requestScope.salesid }" />
                          		<input class="text_input200" name="salesid" id="salesid" value="${requestScope.salesid }" >
                          		
                          		<input type="hidden" name="deliveryid" id="deliveryid" value="${requestScope.ordersdeliveryid }" /> 
                          	</li>
                          	<li class="horizontal_onlyRight">
                          		<img src="${ctx }/img/newbtn/pjdch_0.png" btn=btn title='配镜单查询' onClick="javascript:OrdersSelect()">
                          	</li> 
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${not empty(list)}">
							<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='收货' onclick="save();">
							 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
							<img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn  title="打印条码" id="addGodos" onClick="javascript:batPrintGoodsBarCode();">
						  	 </c:if>
						  </c:if>
						</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                 <c:if test="${not empty(list)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      	<TR>
                          <TD class="table_body" width="9%" height="26">收货单号</TD>
                          <TD class="table_none" width="24%">
                          		${requestScope.receiptid}
                          		<input type="hidden" name="id" id="id" value="${requestScope.receiptid}" /> 
                          		<input type="hidden" name="goodscategory" id="goodscategory" value="${consignProcessOrderDetailsPo.cstcpogoodscategory}" />
                          </TD>
                          <TD class="table_body" width="9%" height="26">收入仓位</TD>
                          <TD class="table_none" width="24%">
                          	<select id="instockid" name="instockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取收入仓位！'}]">
                          	        <option value="" ${'' == warehouseConfigurationPo.bwcstockid4  ? 'selected="selected"' : '' }>----请选择----</option>
								<s:iterator value="getWarehouseList">
									<option value="${bwhid}" ${bwhid!= warehouseConfigurationPo.bwcstockid4  ? '' : 'selected="selected"' }>${bwhwarehouseName}</option>
								</s:iterator>
							</select>
                          </TD>
                          <TD class="table_body" width="9%" height="26">订单编号</TD>
                          <TD class="table_none" >${consignProcessOrderDetailsPo.cstcpodorderbilld}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">制造商</TD>
                          <TD class="table_none" >
                          		${consignProcessOrderDetailsPo.cstcposuppliername}&nbsp;
                          		<input type="hidden" name="supplierid" id="supplierid" value="${consignProcessOrderDetailsPo.cstcposupplierid}" />
                          </TD>
                          <TD class="table_body" height="26">顾客姓名</TD>
                          <TD class="table_none" >${consignProcessOrderDetailsPo.cstcpodcustomername}&nbsp;</TD>
                          <TD class="table_body" height="26">联系电话</TD>
                          <TD class="table_none" >${consignProcessOrderDetailsPo.cstcpocustomertel}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">配镜单号</TD>
                          <TD class="table_none" >${consignProcessOrderDetailsPo.cstcpodglassesbillid}&nbsp;</TD>
                          <TD class="table_body" height="26">订做类型</TD>
                          <TD class="table_none" >
                          	<c:if test="${consignProcessOrderDetailsPo.cstcpodbilltype==2}">
                          		镜架订做
                          	</c:if>
                          	<c:if test="${consignProcessOrderDetailsPo.cstcpodbilltype==4}">
                          		隐形订做
                          	</c:if>&nbsp;
                          </TD>
                          <TD class="table_body" height="26">到镜日期</TD>
                          <TD class="table_none" >${fn:substring(consignProcessOrderDetailsPo.cstcpodarriveddate,0,10)}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">运单号</TD>
                          <TD class="table_none" ><input class="text_input200"  id="waybillid" name="waybillid"  maxlength="32"></TD>
                          <TD class="table_body" height="26">右眼加工要求</TD>
                          <TD class="table_none" >&nbsp;<c:if test="${not empty(list)}">${oDPo.cstcpodrequirement}</c:if>&nbsp;</TD>
                          <TD class="table_body" height="26">左眼加工要求</TD>
                          <TD class="table_none" ><c:if test="${not empty(list)}">${oSPo.cstcpodrequirement}</c:if>&nbsp;</TD>
                        </TR>
                        
                        <TR>
                          <TD class="table_body" height="26">销售门店</TD>
                          <TD class="table_none" colspan="5">${consignProcessOrderDetailsPo.cstcpdptname}&nbsp;</TD>
                        </TR>
                        
                      </TBODY>
                    </TABLE>
                    <br/>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="26" scope=col>右眼(R)/左眼(L)</TH>
                          <TH scope=col>商品名称</TH>
                          <TH width="7%" scope=col>球镜</TH>
                          <TH width="7%" scope=col>柱镜</TH>     
						  <th width="7%" scope=col>轴向</th>
                          <TH width="7%" scope=col>下加光</TH>
						  <TH width="7%" scope=col>棱镜</TH>
						  <TH width="7%" scope=col>基底</TH>
						  <TH width="8%" scope=col>订制数量</TH>
                        </TR>
                        <s:iterator value="oDPoList" status="index">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${oDPo.cstcpodglassflag}</TD>
                          <TD>${cstcpogoodsname}</TD>
                          <TD>${cstcpodballglass }</TD>
                          <TD>${cstcpodpostglass }</TD>
						  <td>${cstcpodaxes}</td>
                          <TD>${cstcpodadd}</TD>
                          <TD>${cstcpodarriseglass}</TD>
                          <TD>${cstcpodbasis}</TD>
                          <TD>${cstcpodnum}<input type="hidden" id="numcount" rl="${oDPo.cstcpodglassflag}" goodsid="${cstcpodgoodsid }" value="${cstcpodnum}"/></TD>
                        </TR>
                        </s:iterator>
                        <s:iterator value="oSPoList" status="index">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${oSPo.cstcpodglassflag}</TD>
                          <TD>${cstcpogoodsname}</TD>
                          <TD>${cstcpodballglass }</TD>
                          <TD>${cstcpodpostglass }</TD>
						  <td>${cstcpodaxes}</td>
                          <TD>${cstcpodadd}</TD>
                          <TD>${cstcpodarriseglass}</TD>
                          <TD>${cstcpodbasis}</TD>
                          <TD>${cstcpodnum}<input type="hidden" id="numcount" rl="${oSPo.cstcpodglassflag}" goodsid="${cstcpodgoodsid }" value="${cstcpodnum}"/></TD>
                        </TR>
                        </s:iterator>
                        
                        <s:iterator value="framePoList" status="index">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${cstcpodglassflag}</TD>
                          <TD>${cstcpogoodsname}</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>${cstcpodnum}</TD>
                        </TR>
                        </s:iterator>
                        
                      </TBODY>
                    </TABLE>
                   </c:if>
                   <br/>
                  <c:if test="${not empty(list)}">
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessOrderDetailsPo.cstcpodbilltype==4)}">       
                          <TH width="4%" scope=col>复制</TH>
                   		  </c:if> 
                          <TH width="25%" height="26" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>右眼(R)/左眼(L)</TH>
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="7%" scope=col>数量</TH>
                   		 <c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessOrderDetailsPo.cstcpodbilltype==4)}">       
                          <TH width="10%" scope=col>效期</TH>
                          <TH width="10%" scope=col>批号</TH>
                          <TH width="10%" scope=col>注册证号</TH>
                   		 </c:if> 
                   		 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH width="20%" scope=col>商品条码</TH>
                         </c:if>      
                        </TR>
                        <s:iterator value="list" status="index">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessOrderDetailsPo.cstcpodbilltype==4)}">        
                          <TD><img src="${ctx}/img/newbtn/addgoods_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');" btn=btn title='复制商品' 
                          		onClick="copyRow(this,
			                           {'cstcpodgoodsid':'${cstcpodgoodsid }',
			                          	'cstcpogoodsname':'${cstcpogoodsname }',
			                          	'cstcpodglassflag':'${cstcpodglassflag }',
			                          	'cstcponottaxrate':'${cstcponottaxrate }',
			                          	'cstcpotaxrate':'${cstcpotaxrate }',
			                          	'cstcpocostprice':'${cstcpocostprice }',
			                          	'cstcpodid':'${cstcpodid }',
			                          	'cstcpodsalesid':'${cstcpodsalesid }',
			                          	'cstcpretailprice':'${cstcpretailprice }',
			                          	'cstcpodgoodsbarcode':'${cstcpodgoodsbarcode }'});">
			              </TD>
                   		  </c:if> 
                          <TD height="26">${cstcpogoodsname }</TD>
                          <TD>${cstcpodglassflag }</TD>
                          <TD>${cstcpodgoodsid }</TD>
                          <TD>
                          	<input type="text" class="text_input60" rl="${cstcpodglassflag }" maxlength="5" id="cstcprdnum" goodsid="${cstcpodgoodsid }" name="consignProcessReceiptDetailsPo.cstcprdnums"  value="${cstcpodnum}" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(0);}"/>
                          </TD>
                          <input type="hidden" name="consignProcessReceiptDetailsPo.cstcprflags" value="${cstcpodglassflag}"/>
                          <input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdgoodsids" value="${cstcpodgoodsid}"/>
                          <input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdnottaxrates" value="${cstcponottaxrate}"/>
                          <input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdtaxrates" value="${cstcpotaxrate}"/>
                          <input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdcostprices" value="${cstcpocostprice}"/>
                          <input type="hidden" name="consignProcessReceiptDetailsPo.cstcprdorderdetailsids" value="${cstcpodid}"/>
                          <input type="hidden" name="consignProcessReceiptDetailsPo.cstcpodsalesids" value="${cstcpodsalesid}"/>
                          <input type="hidden" id="retailprice" name="retailprice" value="${cstcpretailprice}" />
                          <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
                          	<input type="hidden" barcode="barcode" id="barcode" name="consignProcessReceiptDetailsPo.cstcprdbarcodes" value="${cstcpodgoodsbarcode }" maxlength="26"> 
                          </c:if>
                        
                        <c:choose>
                            <c:when test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (consignProcessOrderDetailsPo.cstcpodbilltype==4)}">
                                <TD><input type="text" class="text_input80" maxlength="15" id="guaranteeperiod" name="consignProcessReceiptDetailsPo.cstcpguaranteeperiods" onblur="changebarcode($(this));"  value=""/></TD>
                                <TD><input type="text" class="text_input80" maxlength="15" id="batch" name="consignProcessReceiptDetailsPo.cstcpbatchs"  value=""/></TD>
                                <TD><input type="text" class="text_input80" maxlength="50" id="registrationnum" name="consignProcessReceiptDetailsPo.cstcpregistrationnums"  value="${cstcpregistrationnum}"/></TD>
                            </c:when>
                            <c:otherwise>
                                <input type="hidden" class="text_input80" maxlength="15" id="guaranteeperiod" name="consignProcessReceiptDetailsPo.cstcpguaranteeperiods" onblur="changebarcode($(this));"  value=""/>
                                <input type="hidden" class="text_input80" maxlength="15" id="batch" name="consignProcessReceiptDetailsPo.cstcpbatchs"  value=""/>
                                <input type="hidden" class="text_input80" maxlength="50" id="registrationnum" name="consignProcessReceiptDetailsPo.cstcpregistrationnums"  value="${cstcpregistrationnum}"/>                          
                            </c:otherwise>
                        </c:choose>  
                          
                   		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TD><input class="text_input200" barcode="barcode" id="barcode" name="consignProcessReceiptDetailsPo.cstcprdbarcodes" value="${cstcpodgoodsbarcode }" onblur="checkbarcodeBlur('${cstcpodgoodsid}',this)" maxlength="26"></TD>
                        </c:if>       
                        </TR>
                       </s:iterator>
                      </TBODY>
                    </TABLE>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
  
	
    </BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
