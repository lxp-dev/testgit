<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>收货检验管理</title>
</head>
<script>
	$(document).ready(function() {
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	});
	function needAmount(){
		var total=0;
		$('input[name=needNumber]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#needTotal').text(total);
	}
	//页面内扫码，并将条码付到对应的条码框中

	function onBlurBarCode(barCodeInputObj,goodsId){
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
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		}
		
		
	}
	
	function loadBarCode(barCodeInputObj,goodsId){ 
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
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
		
	}
	
	function removeOption(item){
		$(item).parent().find('.gbc').find('option:selected').remove();
		$(item).parent().parent().find('.number')[0].value=$(item).parent().find('.gbc option').size();
		var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
	}
	
	function save(){
		if(checkForm(document.all.allocationForm)){ 
			if($("table[id=addTable] tr").length <= 2) {
				alert("未添加商品!请重新选择收货单!")
				return;
			}
			$("img").removeAttr("onclick");
			allocationForm.action = "procurementCheckUnGlassInsert.action";
			allocationForm.submit();
		}
	}
	

	
	function openGoodSingle(){
	
	    var supplierID = '';
		var categoryID_open='';	
		showPopWin("","initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRow(goodInfos[goodsI]);
		}
	}
	var status=1;
	
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) {
				goodsquantity[i].style.backgroundColor="red";
				window.close();hidePopWin();selectShow();
				return;
				}
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		<c:if test="${person.departmenttype==3}">        
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);

//		c7.style.display = "None";
		</c:if>
		
		row.className = 'row';
		row.height="28";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid +'<input type="hidden" id="goodsid" index="'+goodInfo.bgigoodsid+'" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
//		c5.innerHTML = '<input type="text" class="text_input60" onBlur="needAmount()" maxlength="18" name="needNumber" value="' + goodInfo.bgigoodsquantity + '"  validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		
		//c6.innerHTML = '<itype="text" class="text_input200" id="goodsBarCode"  name="goodsInfoTempPo.goodsbarcode" value="" onBlur="onBlurBarCode(this,\''+goodInfo.bgigoodsid+'\');"  onkeydown="innerScanBarCode(this,\''+goodInfo.bgigoodsid+'\');" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]"/>';
		
	//	<c:if test="${person.departmenttype==3}">      
		if(goodInfo.bgigoodsid.substring(0,1)=='2'||goodInfo.bgigoodsid.substring(0,1)=='5'||goodInfo.bgigoodsid.substring(0,1)=='7'){
			c5.innerHTML = '<input type="text"  class="text_input60 number" maxlength="18" name="goodsInfoTempPo.goodsquantity" value="" onblur="amount(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}     else{
		c5.innerHTML = '<input type="text" readOnly="readOnly" class="text_input60 number" maxlength="18" name="goodsInfoTempPo.goodsquantity" value="0" onblur="amount(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}
		c6.innerHTML = '<select id="selectGbc" name="goodsInfoTempPo.goodsbarcode"  multiple="multiple" class="text_input200 gbc" style="height:40px" onmousemove="this.style.height=\'100px\';" '+ ' onmouseout="this.style.height=\'30px\';"></select><br/>'+
					'<input index="index'+goodInfo.bgigoodsid+'" onkeyup="this.value=this.value.toUpperCase()"   onblur="this.value=this.value.toUpperCase()" maxlength="26" type="text" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/><br/>'+
					'<input id="del'+status+'" icon="icon-delete" type="button" value="删除"  onclick="removeOption(this);" />';
					$('#del'+status).btn().init();
					status=status+1;
	//	</c:if>

    }
    
    //页面内扫码，并将条码付到对应的条码框中
	
    
  	function ordergoodsquantityamount(item){
  		var ordergoodsquantityamount = 0;
		$('input[name=procurementCheckPo.cstpoeordergoodsquantity]').each(function (){
			ordergoodsquantityamount = parseFloat(ordergoodsquantityamount) + parseFloat($(this).val());
		});
		$('#goodsquantityTotal1').text(ordergoodsquantityamount);
  	}
  	
  	function amount1(item){
  		//订购数量合计
  		var ordergoodsquantityamount = 0;
		$('input[name=procurementCheckEntryPo.cstpoeordergoodsquantitys]').each(function (){
			ordergoodsquantityamount = parseFloat(ordergoodsquantityamount) + parseFloat($(this).val());
		});
		$('#goodsquantityTotal1').text(ordergoodsquantityamount);
		$('#cstpoeordergoodsquantity').val(ordergoodsquantityamount);
		
		//实收数量合计
		var goodsquantityamount = 0;
		$('input[name=procurementCheckEntryPo.cstpoegoodsquantitys]').each(function (){
			goodsquantityamount = parseFloat(goodsquantityamount) + parseFloat($(this).val());
		});
		$('#goodsquantityTotal2').text(goodsquantityamount);
		$('#cstpoegoodsquantity').val(goodsquantityamount);
	}
  	
  	
  	function amount(item){		
		//合格数量合计
		var hgamount = 0;
		$('input[name=hg]').each(function (){
			hgamount = parseFloat(hgamount) + parseFloat($(this).val());
		});
		$('#goodsquantityTotal3').text(hgamount);
		
		//不合格数量合计
		var unqualifiedquantityamount = 0;
		$('input[name=procurementCheckEntryPo.cstpoeunqualifiedquantitys]').each(function (){
			unqualifiedquantityamount = parseFloat(unqualifiedquantityamount) + parseFloat($(this).val());
		});
		$('#goodsquantityTotal4').text(unqualifiedquantityamount);
  	}
  	
  	function check(obj,type){
  		var index = obj.attr("id").substring(0,1);
  		//判断数量为空时处理
  		if(obj.val() == '' || obj.val() == null){
  			obj.val('0');
  		}
  		
  		//判断收货数量是否大于订货数量
  		if(type == '1'){
	  		if(parseFloat($('#'+index+'cstpoeunqualifiedquantity').val())+ parseFloat($('#'+index+'hg').val()) > parseFloat(obj.val())){
	  			alert("收货数量过小!");
	  			obj.val('0');
	  			parseFloat($('#'+index+'cstpoeunqualifiedquantity').val('0'));
	  			parseFloat($('#'+index+'hg').val('0'));
	  			obj.focus();
	  		}
  		}
  		
  		//判断不合格数量是否大于收货数量
  		if(type == '2'){
	  		if(parseFloat($('#'+index+'cstpoegoodsquantity').val()) < parseFloat(obj.val())){
	  			alert("不合格数量不能大于收货数量!");
	  			obj.val('0');
	  			obj.focus();
	  		}
  		}
  		
  		//格式判断
  		
	}
  	
  	function rowamount(obj){
  		var index = obj.attr("id").substring(0,1);						//索引
  		var dhnumber = $('#'+index+'cstpoeordergoodsquantity').val();		//订货数量
  		var shnumber = $('#'+index+'cstpoegoodsquantity').val();		//收货数量
  		var bhgnumber = $('#'+index+'cstpoeunqualifiedquantity').val();	//不合格数量
  		
  		
  		//计算不合格商品数量
  		$('#'+index+'hg').val(parseFloat(shnumber)-parseFloat(bhgnumber));
  		
  		//计算符合率
  		if(dhnumber != '0' && dhnumber != null){
  			$('#'+index+'cstpoecoincidencerate').val(((parseFloat(shnumber)/parseFloat(dhnumber))*100).toFixed(2)+'%');
  		}else{
  			$('#'+index+'cstpoecoincidencerate').val('100.00%');
  		}
  		
  		
  		
  		//计算不合格率
  		$('#'+index+'cstpoeunqualifiedrate').val((((parseFloat(bhgnumber))/parseFloat(shnumber))*100).toFixed(2)+'%');
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
		amount1();
    }
    
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID='';

		//showPopWin("","selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
			
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
		document.getElementById('chaasupplier').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
		
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
    	$('#cshaainstockid').load("getAjaxStock.action?id="+ obj);
    }
    
    //扫描商品条码事件
	function scanBarCode(obj) {
		if (event.keyCode == 13) {
			if (obj.value === ''||obj.value.length<26) {
				alert('条码位数不符!');
				obj.value='';
				obj.focus();
				return;
			}else {
				searchBar(obj.value);
				obj.value='';
				obj.focus();
			}
		}
	}
	
	function searchBar(obj){
		var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if(obj.toUpperCase().substring(0,18)==$(this).val().replace(/\./g,  "").toUpperCase()){
				indexval = $(this).attr("index");
				goodidval = $(this).val();
			}
			
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		onBlurBarCode(getinput,goodidval);
		
	}
	
	function loadBar(obj){
		var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if(obj.toUpperCase().substring(0,18)==$(this).val().replace(/\./g,  "").toUpperCase()){
				indexval = $(this).attr("index");
				goodidval = $(this).val();
			}
			
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		loadBarCode(getinput,goodidval);
		
	}
	
	
	/**
	 * 开窗赋值实现方法
	 */
	function openValues1(objValue){
		document.getElementById('cshaabillassociation').value=objValue;
		allocationForm.action="selApplyAllocationBills.action?billID="+objValue;
		allocationForm.submit();
		
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openValues2(objValue,chaasupplier,bspsuppliername,did){
		allocationForm.action="procurementCheckUnReceiptBillChange.action?billID="+objValue+"&did="+did;
		allocationForm.submit();
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openValues3(objValue){
		document.getElementById('cshaabillassociation').value=objValue;
		allocationForm.action="selReAllocationBills.action?billID="+objValue;
		allocationForm.submit();
	}
	
	
	
	
		$(document).ready(function(){
		//StatusID：0代表申请调拨，1代表采购收货
		var StatusID='${StatusID}';
//		alert(StatusID);
			<s:iterator value="procurementCheckPos">
		     var json = {'goodsid':'${cstpoegoodsid}',
		     				'goodsname':'${cstpoegoodsname}',
		     				'dnumber':'${cstpoeordergoodsquantity}','rnumber':'${cstpoegoodsquantity}','bc':'${cstpoebluminosity}'
		     			};
		     addRow1(json);          
			</s:iterator>
			
			
			
			amount();
			amount1()
		});
		
		function addRow1(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) {
//				goodsquantity[i].style.backgroundColor="red";
//				window.close();hidePopWin();selectShow();
				return;
				}
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
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.goodsid+'<input type="hidden" id="'+index+'cstpoegoodsid" name="procurementCheckEntryPo.cstpoegoodsids"  value="' + goodInfo.goodsid +'" />';
        c3.innerHTML = goodInfo.goodsname;
        c4.innerHTML = goodInfo.dnumber+'<input type="hidden" class="text_input60 number" id="'+index+'cstpoeordergoodsquantity" readonly="readonly" name="procurementCheckEntryPo.cstpoeordergoodsquantitys" value="' + goodInfo.dnumber +'" onblur="amount(this);"/>';
		c5.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" id="'+index+'cstpoegoodsquantity" name="procurementCheckEntryPo.cstpoegoodsquantitys" value="' + goodInfo.rnumber +'" onblur="check($(this),1);rowamount($(this));amount(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		c6.innerHTML = '<input type="text" class="text_input60 number" style="background-color: #E1E3E6;" readonly="readonly" id="'+index+'cstpoecoincidencerate" name="procurementCheckEntryPo.cstpoecoincidencerates" value="100.00%"/>';	
		
		c7.innerHTML = '<select id="'+index+'cstpoepack" name="procurementCheckEntryPo.cstpoepacks"><option value="1">√</option><option value="0">×</option></select>';
		c8.innerHTML = '<select id="'+index+'cstpoeapp" name="procurementCheckEntryPo.cstpoeapps"><option value="1">√</option><option value="0">×</option></select>';
		c9.innerHTML = '<input type="text" class="text_input60 number" id="'+index+'hg" style="background-color: #E1E3E6;" readonly="readonly" name="hg" value="' + goodInfo.rnumber +'" onblur="amount(this);"/>';
		c10.innerHTML = '<input type="text" class="text_input60 number" id="'+index+'cstpoeunqualifiedquantity" name="procurementCheckEntryPo.cstpoeunqualifiedquantitys" onblur="check($(this),2);rowamount($(this));amount(this);" value="0"/>';
		c11.innerHTML = '<input type="text" class="text_input60 number" style="background-color: #E1E3E6;" readonly="readonly" id="'+index+'cstpoeunqualifiedrate" name="procurementCheckEntryPo.cstpoeunqualifiedrates" value="0.00%"/>';
    }
	
	function openGoodSingleAll(){
		var supplierID = "";
	    var cstpgoodscategory = '';
		showPopWin("","initGoodsSingleSelAlls.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
		function openGoodReceipt(type){
		var supplierID = "";
	    var cstpgoodscategory = '';
		//showPopWin("","initProcurementCheckReceiptBillSelect.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID + "&type=" + type,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementCheckReceiptBillSelect.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID + "&type=" + type,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementCheckReceiptBillSelect.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID + "&type=" + type,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【按收货单添加商品】";
	}
	
	function openGoodAllocation(){
		var supplierID ="";
	    var cstpgoodscategory = '';
		showPopWin("","initGoodsAllocation.action?categoryID_open=" + cstpgoodscategory + "&supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	
	function isInputBarCode(arg){
		if(arg=="1"){
			document.getElementById('scancode').style.display="block";
		}else{
			document.getElementById('scancode').style.display="none";
		}
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="StatusID" name="StatusID" value="${StatusID}">
<input type="hidden" id="cstpoebilltype" name="procurementCheckPo.cstpoebilltype" value="0">



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
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0  align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">检验单号</TD>
                          <TD width="24%" class="table_none">&nbsp;${billID}<input class="text_input200" type="hidden"  id="cstpoebillid" name="procurementCheckPo.cstpoebillid" value="${billID}" readonly="readonly"></TD>
                          <TD class="table_body" height="26" width="9%">制单人</TD>
                          <TD class="table_none" width="24%">&nbsp;${person.personName }<input type="hidden" name="procurementCheckPo.cstpoechecker" value="${person.id}"></TD>
                         <TD class="table_body" width="9%" height="26">单据日期</TD>
                         <TD  class="table_none" >&nbsp;<jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                         </TD>
                        </TR>
                        
                        <TR>
                         <TD class="table_body" height="26">制造商</TD>
                         <TD  class="table_none" >&nbsp;${procurementCheckPos[0].cstpoesuppliername }
                          <input type="hidden" name="procurementCheckPo.cstpoesupplierid" value="${procurementCheckPos[0].cstpoesupplierid }">
                         </TD>
                         <TD class="table_body" height="26">收入仓位</TD>
                         <TD  class="table_none" >&nbsp;${procurementCheckPos[0].cstpoeinstockname }
                          <input type="hidden" name="procurementCheckPo.cstpoeinstockid" value="${procurementCheckPos[0].cstpoeinstockid }">
                         </TD>
                         <TD class="table_body" height="26">收货单号</TD>
                         <TD  class="table_none" >&nbsp;${procurementCheckPos[0].cstpoebillsource }
                          <input type="hidden" name="procurementCheckPo.cstpoebillsource" value="${procurementCheckPos[0].cstpoebillsource }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '收货单号不能为空！'}]">
                         </TD>					       
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" width="60%">
						   <img btn=btn src="${ctx }/img/newbtn/btn_ashdtjsp_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_ashdtjsp_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_ashdtjsp_0.png');" title="按收货单添加商品" onClick="javascript:openGoodReceipt('');">				  
						   <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');" title="删除" onClick="deleteitem();" >
						  
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
                        <TR class=table_title align=middle height="26">  
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                    
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>订货数量</TH>   
                          <TH width="5%" scope=col>收货数量</TH>                
                          <TH width="8%" scope=col>符合率</TH>
                          <TH width="5%" scope=col>外包装</TH> 
                          <TH width="5%" scope=col>标识</TH>
                          <TH width="5%" scope=col>合格数量</TH> 
                          <TH width="6%" scope=col>不合格数量</TH>
                          <TH width="5%" scope=col>不合格率</TH>                   
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH height="26"  colSpan=3 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH> 
					    	<TH scope=col id="goodsquantityTotal1">0</TH><input type="hidden" id="cstpoeordergoodsquantity" name="procurementCheckPo.cstpoeordergoodsquantity" value="0"/>
					    	<TH scope=col id="goodsquantityTotal2">0</TH><input type="hidden" id="cstpoegoodsquantity" name="procurementCheckPo.cstpoegoodsquantity" value="0"/>   
					    	<TH scope=col colspan="3">&nbsp;</TH>
					    	<TH scope=col id="goodsquantityTotal3">0</TH>
					    	<TH scope=col id="goodsquantityTotal4">0</TH>
					    	<TH scope=col>&nbsp;</TH>
				   		</TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
					   <TR>
						  <TD align="left">
						  <img btn=btn id="button1" src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" title='保存' onclick="save();">
                          		
						  </TD>
                        </TR>                     
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR>

</TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR>
        <tr><td></td></tr>    
            
            </TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>