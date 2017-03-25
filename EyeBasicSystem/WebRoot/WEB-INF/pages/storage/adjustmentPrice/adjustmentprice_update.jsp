<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品调价管理</title>
</head>
<script>	
	function save(){
	if(checkForm(document.all.adjustmentPriceForm)){ 
	if($('#adjustmentPriceWay').val() == '1' && $('#effecticeTime').val()==''){
			alert('请先填写生效日期!');
			return;
		}
		if($('input[name=chk]').length==0){
			alert('请先选择商品!');
			return;
		}
		var adflag=false;
		$('input[id=adprice]').each(function(){
			if($(this).val()==''){
				alert('请先填写调整价格!');
				adflag=true;
				return false;
				
			}
		})
		if(adflag){
			return;
		}
		$("img").removeAttr("onclick");
		adjustmentPriceForm.action = "adjustmentPriceUpdate.action";
		adjustmentPriceForm.submit();
		}
	}

	function adjustmentPrice_open(){
		var supplierID='';
		var categoryID_open='';	
		 var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initMoreAdjustmentPriceOpen.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID ,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initMoreAdjustmentPriceOpen.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID ,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【批量选择商品】";
	}
	function openGoodSingle(){
		var supplierID='';
		var categoryID_open='';	
		 var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?categoryID_open=" + categoryID_open + "&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?categoryID_open=" + categoryID_open + "&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【商品添加】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRow(goodInfos[goodsI]);
		}
	}

	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
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
    }
	
	function toFixAndNan(obj){
		obj.value=obj.value.replace(/[^0-9.][0-9]*/g,'');
	}
	function toFix(obj){
		if(obj.value!=''){
			obj.value=parseFloat(obj.value).toFixed(2);
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
		
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input name="chk" id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" id="goodsid" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname+ '<input type="hidden" id="goodsname" name="goodsInfoTempPo.goodsname" value="' + goodInfo.bgigoodsname +'" />';
		c4.innerHTML = goodInfo.bgibrandname+ '<input type="hidden" id="goodsname" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" />';
		c5.innerHTML = goodInfo.bgispec+ '<input type="hidden" id="goodsname" name="goodsInfoTempPo.spec" value="' + goodInfo.bgispec +'" />';;
		c6.innerHTML = goodInfo.bgiretailprice+ '<input type="hidden" id="retailprice" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgiretailprice +'" />';
		c7.innerHTML = '<input  type="text" name="goodsInfoTempPo.adprice" value="" id="adprice" class="text_input60" onkeyup="toFixAndNan(this)" onblur="toFix(this)">';
		
		$("#bgiwhichretail").val(goodInfo.bgiwhichretail);
		$("#td_whichretail").text("零售价格"+goodInfo.bgiwhichretail);
		
		$('#del' + index).btn().init();

    }
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(a=0;a<goodsquantity.length;a++){
			if(goodsquantity[a].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[a].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
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
		if($("[id=addTable]>tbody").children("tr").length == 1){
			$("#bgiwhichretail").val("");
			$("#td_whichretail").text(" ");
		}
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
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    function showSubMenu(obj) {  
    	$('#' + 'cshaainstockid').load("getAjaxStock.action?id="+ obj);
    }
    
    function setAdjustmentPrice(){
        var price=document.getElementById('adjustmentPrice').value;
        if (isNaN(price)){
            alert("请输入正确的价格!");
            return;
        } 
        if(price==''){
        	alert("请输入价格!");
            return;
        }
        var adjustmentPrice=Math.round(parseFloat(price)*Math.pow(10,2))/Math.pow(10,2);
        var count = document.getElementsByName('goodsInfoTempPo.adprice').length;        
        for ( var i = 0; i < count; i++ ){
            document.getElementsByName('goodsInfoTempPo.adprice')[i].value=adjustmentPrice;
       }
    }
    
   /**
	*  二维表开窗事件
	*/
	function open2D(){
		var goodsIdNew='';
	    var goodsNumNew='';
	    $("input[name=goodsInfoTempPo.goodsid]").each(function(){
	    	goodsIdNew=goodsIdNew+$(this).val().toUpperCase()+",";
		});
	    $("input[name=goodsInfoTempPo.adprice]").each(function(){
	    	goodsNumNew=goodsNumNew+$(this).val().toUpperCase()+",";
		});
		$('#tdgoodsids').val(goodsIdNew);
		$('#tdvs').val(goodsNumNew);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initAdjustPriceGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&retailType=AdjustmentPrice",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initAdjustPriceGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&retailType=AdjustmentPrice",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【二维表添加商品】";
	}
	
	$(document).ready(function(){
		<s:iterator value="goodsInfoPos">
	    var json = {'goodsid':'${bgigoodsid}','goodsName':'${bgigoodsname}','brandName':'${bgibrandname}','spec':'${bgispec}',
		    		'retailPrice':'${bgiretailprice}','v':'${bgiretailpricenow}','goodsbarcode':'${bgigoodsbarcode}','bgiwhichretail':'${bgiwhichretail}'};
	    addDimensionRow(json)
	              
		</s:iterator>
	});
	function addtdgoods(){
		adjustmentPriceForm.action = "addAdjustmentPrice.action";
		adjustmentPriceForm.submit();
	}
	function addDimensionRow(goodInfo){
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
		
		row.className = 'row';
		row.height="26";
		
		c1.innerHTML = '<input  name="chk" type="checkbox" value="' + goodInfo.goodsid + '" >';
        c2.innerHTML = goodInfo.goodsid + '<input type="hidden" id="goodsid" name="goodsInfoTempPo.goodsid" value="' + goodInfo.goodsid +'" />';
        c3.innerHTML = goodInfo.goodsName+ '<input type="hidden" id="goodsname" name="goodsInfoTempPo.goodsname" value="' + goodInfo.goodsName +'" />';
		c4.innerHTML = goodInfo.brandName+ '<input type="hidden" id="goodsname" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.goodsbarcode +'" />';
		c5.innerHTML = goodInfo.spec;
		c6.innerHTML = goodInfo.retailPrice+ '<input type="hidden" id="retailprice" name="goodsInfoTempPo.costprice" value="' + goodInfo.retailPrice +'" />';
		c7.innerHTML = '<input  type="text" id="adprice" name="goodsInfoTempPo.adprice" value="'+goodInfo.v+'" onkeyup="toFixAndNan(this)" class="text_input60" onblur="toFix(this)" >';	
		
		$('#del' + index).btn().init();
		$("#bgiwhichretail").val(goodInfo.bgiwhichretail);
		$("#td_whichretail").text("零售价格"+goodInfo.bgiwhichretail);
    } 
    
    function isshow(){	
	    var obj = document.getElementById("showtr");
	    var fixedTime = document.getElementById("fixedTime");
	    var realTime = document.getElementById("realTime");
	    if(fixedTime.checked){
	    	$('tr[id=showtr]').show();
		    $('#adjustmentPriceWay').val('1');  //石英调价
	    }else if(realTime.checked){
	    	$('tr[id=showtr]').hide();
		    $('#adjustmentPriceWay').val('0');  //实时调价
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
	 /**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID = $('#cstpsupplierid').val();
	    
	
		if(supplierID.trim() == ''){
			alert("请选择制造商！");
			$('#cstpsupplierid').focus();
			return;
		}

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】"
	}

	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商添加】";
	}
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		if(document.getElementById('cstpsupplierid').value != json.id){
			document.getElementById('cstpsupplierid').value = json.id;
			document.getElementById('bspsuppliername').value = json.value;
			document.getElementById('brandID').value = "";
			document.getElementById('brandName').value = "";
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="adjustmentPriceForm" method="post" action="">
<input type="hidden" name="bid" value="${bid}"/>
<input type="hidden" name="justType" value="update">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />
<input type="hidden" id="whichretails" name="whichretails" value="" />
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
					</TR></TBODY></TABLE></TD>
					
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="10%" class="table_body">单据编号</TD>
                          <TD width="23%" class="table_none"><input class="text_input160" id="cshaabillid" name="adjustmentPricePo.cprapbillid" value="${adjustmentPricePo.cprapbillid }" readonly="readonly"></TD>
                          <TD width="10%" class="table_body">制单日期</TD>
                          <TD width="23%" class="table_none">
                         ${adjustmentPricePo.cprapcreatedate}
                          <TD width="9%" class="table_body">制单人</TD>
                          <TD class="table_none">${adjustmentPricePo.cprapcreatepersonname }</TD>
                        </TR>
                        <TR>
                          <TD width="10%" class="table_body">调价方式</TD>
					
					      <TD width="24%" class="table_none">
					        <input type="hidden" id="adjustmentPriceWay" name="adjustmentPricePo.cprapflag" value="${adjustmentPricePo.cprapflag }">
                          	实时调价&nbsp;<input type="radio" id="realTime" name="radioBtn" onClick="isshow()" ${adjustmentPricePo.cprapflag == '0' ? 'checked="checked"' : ''} >&nbsp;&nbsp;&nbsp;
                                                                          按生效日期调价&nbsp;<input type="radio" id="fixedTime" name="radioBtn" onClick="isshow()" ${adjustmentPricePo.cprapflag == '1' ? 'checked="checked"' : ''}>
                          </TD>
                          <TD width="10%" class="table_body">零售价格种类</TD>
					      <TD width="24%" class="table_none" id="td_whichretail" colspan="3">
					          <c:if test="${adjustmentPricePo.cprapwhichprice eq '1'}">
					                                  标准零售价
					          </c:if>
					          <c:if test="${adjustmentPricePo.cprapwhichprice ne '1'}">
					                                  零售价格${adjustmentPricePo.cprapwhichprice }
					          </c:if>
                            	
                          </TD>
                          <input type="hidden" id="bgiwhichretail" name="adjustmentPricePo.cprapwhichprice" value="${adjustmentPricePo.cprapwhichprice }" />
                        </TR>
                        <TR id="showtr" ${adjustmentPricePo.cprapflag == '0' ? 'style="display: none"' : ''}>
                          <TD width="9%" class="table_body">生效日期</TD>
                          <TD width="41%" class="table_none" colSpan=6>
                           <input id="effecticeTime"
					       name="adjustmentPricePo.cprapeffectivedate" 
					       value="${adjustmentPricePo.cprapeffectivedate }"
					       type="text" class="text_input200" 
					     onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd',minDate:'${effectiveTime}'})" /></TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><textarea  name="adjustmentPricePo.cprapremark" id="textarea2">${adjustmentPricePo.cprapremark }</textarea></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR>
                        <TD align="left">
							<img name="button22" src="${ctx}/img/newbtn/btn_addgoods_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_addgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_addgoods_0.png');" title="单品添加商品" 
						  onClick="javascript:openGoodSingle();">
                            <img src="${ctx}/img/newbtn/btn_addtwogoods_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_addtwogoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_addtwogoods_0.png');" title="二维表添加商品" id="2D"
					      onClick="javascript:open2D();"> 
							   <img id="del" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();">
							
							</TD>
                      </TR>
                      <TBODY>
                      </TBODY>
                    </TABLE>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table  id="addTable" width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">
                      <TBODY>
                      
                        <TR class=table_title align=middle>
                         <TH width="7%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="20%" height="26" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>品种</TH>
                          <TH width="10%" scope=col>型号</TH>
                          <TH width="10%" scope=col>现销售价格</TH>
                          <TH width="10%" scope=col>调整价格</TH>
                          </TR>
                        <c:forEach var="adjustmentPriceEntry" items="${adjustmentPriceEntryList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD height="26"><input id="chk" name="chk" type="checkbox" value="${adjustmentPriceEntry.cprapegoodsid }" ></TD>
                          <TD>${adjustmentPriceEntry.cprapegoodsid }<input name="goodsInfoTempPo.goodsid" value="${adjustmentPriceEntry.cprapegoodsid }" type="hidden"/></TD>
						  <TD>${adjustmentPriceEntry.cprapegoodsname }<input name="goodsInfoTempPo.goodsname" value="${adjustmentPriceEntry.cprapegoodsname }" type="hidden"/></TD>
                          <TD>${adjustmentPriceEntry.cprapebbdbrandname }<input name="goodsInfoTempPo.goodsbarcode" value="${adjustmentPriceEntry.cprapegoodsbarcode}" type="hidden"/></TD>
                           <TD>${adjustmentPriceEntry.cprapebbdspec }</TD>
                          <TD>${adjustmentPriceEntry.cprapecostprice}<input name="goodsInfoTempPo.costprice" value="${adjustmentPriceEntry.cprapecostprice}" type="hidden"/></TD>
                          <TD><input id='adprice'  type="text" name="goodsInfoTempPo.adprice" value="${adjustmentPriceEntry.cprapeadprice }" class="text_input60" onkeyup="toFixAndNan(this)" onblur="toFix(this)"></TD>
                       
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" valign="bottom">
                             <li class="horizontal_onlyRight">
                              <input class="text_input100" name="adjustmentPrice" id="adjustmentPrice" type="text" maxlength="20">&nbsp;
                             </li>
                             <li class="horizontal_onlyRight">
                              <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="setAdjustmentPrice();" >
                              </li>
                          </TD>
                        </TR>
                        <TR>
                          <TD align="left" valign="bottom">
                          <li class="horizontal_onlyRight">
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          </li>
                          <li class="horizontal_onlyRight">
                          <input name="saveAndAudit" type="checkbox" value="保存并审核">
                            保存并审核
                          </li>
                            </TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>