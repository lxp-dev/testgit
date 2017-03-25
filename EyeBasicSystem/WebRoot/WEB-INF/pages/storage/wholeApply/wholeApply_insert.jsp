<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>批发申请管理</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		needAmount();
	});
	function batchCheckQutity(thiz){
		/*if($(thiz).val()==''){
			alert("请填写商品数量");
			return;
		}
		if(confirm("是否将所有商品数量修改为"+$(thiz).val()+"?")){
			$('input[name=needNumber]').each(function(){
				$(this).val($(thiz).val());
			});
		}*/
	}
	function addtdgoods(){
		allocationForm.action = "addApplyAllocationDimension.action";
		allocationForm.submit();
	}

	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=needNumber]").index(obj)+1;
		    $("input[name=needNumber]").eq(index).focus();
		}
	}

	function needAmount(){
		var total=0;
		$('input[name=needNumber]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#needTotal').text(total);
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
	
	function save()
	{
		if(!$("#departmentID").val()){
			alert("请选择申请客户！");
			$("#departmentID").focus();
			return;
		}
		
		var table = document.getElementById('addTable');
		var index = table.rows.length-2;
		if(index == 0){
			alert('请选择商品!');
			return;
		}
		
		var isgoon='';
		var goodsQuantities = $("input[name=needNumber]");

		for(var i = 0; i < goodsQuantities.length; i++) {
			if(goodsQuantities[i].value <= 0){
				alert("请正确填写商品数量！");
				goodsQuantities[i].focus();
				goodsQuantities[i].select();
				isgoon='1';
				return;
			}
			if(isNaN(goodsQuantities[i].value)||goodsQuantities[i].value<0){
				alert("商品数量格式不正确！");
				goodsQuantities[i].focus();
				return;	
			}
			if(goodsQuantities[i].value == 0){
				alert("商品数量不能为0！");
				goodsQuantities[i].focus();
				goodsQuantities[i].select();
				isgoon='1';
				return;
			}
		}

		if(isgoon!=''){
			return;
		}
		
		if(checkForm(document.all.allocationForm)){ 
			$("img").removeAttr("onclick");
			allocationForm.action = "insertApplyWholeForApp.action";
			allocationForm.submit();
		}
	}
	
	function openGoodSingle(){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?app=app&whichretail=1&select_retail=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?app=app&whichretail=1&select_retail=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRow(goodInfos[goodsI]);
		}
		
		$("input[name='needNumber']").each(function(){
			$(this).bind("keyup",function(){
				$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
			});
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
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
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) {
				return;
			}
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" id="goodsid" class="text_input200 gbc" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" ondblclick="batchCheckQutity(this);" onkeydown="OnKeyDownEnter(this)" name="needNumber" onblur="needAmount();" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		$('#del'+index).btn().init();
    }

	/**
	 * 品种开窗
	 */
	function openBrand(){
		var goodscategoryID = $('#goodscategoryID').val();
	    var supplierID = $('#chaasupplier').val();
	    
		if(goodscategoryID.trim() == ''){
			alert("请选择批发类型！");
			$('#goodscategoryID').focus();
			return;
		}

		if(supplierID.trim() == ''){
			alert("请选择制造商！");
			$('#cstpsupplierid').focus();
			return;
		}

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】"
	}

	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		if(document.getElementById('brandID').value != json.brandID){
   			deleteROW();
        }
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
    
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		needAmount();
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
		
		needAmount();
    }
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
		var categoryID_open = document.getElementById('goodscategoryID').value;
	    if(categoryID_open==''){
	      alert('请选择商品类型');
	      return false;
	    }
	    
	    if(!categoryID_open){
			categoryID_open = '';
		}
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+categoryID_open,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+categoryID_open,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		if(document.getElementById('chaasupplier').value != json.id){
			delRows();
			document.getElementById('chaasupplier').value = json.id;
			document.getElementById('bspsuppliername').value = json.value;
			document.getElementById('brandID').value = "";
			document.getElementById('brandName').value = "";
			deleteROW();
		}
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
    	$('#' + 'cshawinstockid').load("getApplyAjaxStock.action?id="+ obj);
    }
    
   /**
	*  二维表开窗事件
	*/
	function open2D(){
		if ($('#goodscategoryID').val() != '3' && $('#goodscategoryID').val() != '4'){
	        alert("请选择镜片商品或隐形镜片商品!");
	        return;
	    }

		var chaasupplier =document.getElementById('chaasupplier').value;
	    if(chaasupplier==''){
		      alert('请选择制造商');
		      return false;
	    }

	    var brandID=document.getElementById('brandID').value;
	    var brandName=document.getElementById('brandName').value;

	    if($('#goodscategoryID').val() == '3' || $('#goodscategoryID').val() == '4'){
	    	if(brandID==''){
			    alert('请选择所属品种');
			    return false;
		    }
	    }
	   	
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsOpen_dimensional.action?cstpgoodscategory="+$('#goodscategoryID').val()+"&bspsuppliername="+EncodeUtf8($('#bspsuppliername').val())+"&cstpsupplierid="+$('#chaasupplier').val()+"&brandID_open="+brandID+"&brandName="+EncodeUtf8($('#brandName').val()),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen_dimensional.action?cstpgoodscategory="+$('#goodscategoryID').val()+"&bspsuppliername="+EncodeUtf8($('#bspsuppliername').val())+"&cstpsupplierid="+$('#chaasupplier').val()+"&brandID_open="+brandID+"&brandName="+EncodeUtf8($('#brandName').val()),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}

	function openGoodsInfoForSOUT(){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelGoodsInfoForSOUT.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelGoodsInfoForSOUT.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	// 二维开窗赋值实现方法
	function openGoodsDimensionValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
		  if(goodInfos[i].v!=''){
			addDimensionRow(goodInfos[i]);	
		  }		
		}
		needAmount();	
	}
	
	function addDimensionRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;

		// 商品id去重
		var chk=document.getElementsByName("chk");		
		for(var i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.goodsid) {
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
		
		row.className = 'row';
		row.height="28";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.goodsid + '" >';
        c2.innerHTML = goodInfo.goodsid + '<input type="hidden" id="goodsid" index="'+index+'" class="text_input200 gbc" name="goodsInfoTempPo.goodsid" value="' + goodInfo.goodsid +'" />';
        c3.innerHTML = goodInfo.goodsName;
		c4.innerHTML = goodInfo.spec;
		c5.innerHTML = '<input type="text" class="text_input60 number" ondblclick="batchCheckQutity(this);" onBlur="needAmount()" maxlength="18" onkeydown="OnKeyDownEnter(this)" name="needNumber" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
  
		$('#del'+index).btn().init();	

		$("input[name='needNumber']").each(function(){
			$(this).bind("keyup",function(){
				$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
			});
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
				}else{
					$(this).val('');
				}
			});	
		});
   }  
   
   	/**
	 *  清除表格中所有行
	 */        
	 function delRows(){
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(var i = 0; i < chk.length; i++){
			var curRow = chk[i].parentNode.parentNode;		
			table.deleteRow(curRow.rowIndex);
			i = -1;
		}
        $('#needTotal').text(0);

     }
     
     function clearSupplier(){
        document.getElementById('chaasupplier').value = "";
		document.getElementById('bspsuppliername').value = "";
     }
     
     function changeGoodsCategory(){
   		 $('#chaasupplier').val('');
   		 $('#bspsuppliername').val('');
   		 $('#brandName').val('');
   		 $('#brandID').val('');
   		 deleteROW();
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
     function clean(){
		 $('#cstpsupplierid').val('');
   		 $('#bspsuppliername').val('');
   		 $('#brandName').val('');
   		 $('#brandID').val('');
   		 $("#cshawabillid").val('');
   		 $('#goodscategoryID').val('');
   		 $('#deliveryperson').val('');
   		 $('#deliveryphone').val('');
   		$('#deliveryfax').val('');
   		$('#deliveryaddress').val('');
   		deleteROW();
	}

    function scanbarcode(){
 		var topRows = top.document.getElementById("total").rows;
 		var topCols = top.document.getElementById("btmframe").cols;
 		if(is_iPad()){
 			showPopWin("initScanGoodsID.action?moduleID="+$("#moduleID").val(),350,55,topRows,topCols,returnRefresh(true),false);
 		}else{
 			showPopWin("initScanGoodsID.action?moduleID="+$("#moduleID").val(),350,55,topRows,topCols,returnRefresh(true),false);
 		}
 		document.getElementById('popupTitle').innerHTML="【条码扫描】";
 	}

	function loadBarUpdateNumber(obj){
		var indexval = null;
		var goodidval = null;
	    var count = 0;
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if($(this).val() != '' && obj.toUpperCase() == $(this).val().toUpperCase()){
				indexval = $(this).val();
				goodidval = $(this).val();
				count = 1;
			}
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}

		$('input[value='+indexval+']').val(obj.toUpperCase());
		getinput = $('input[value='+indexval+']');	
		
		loadBarCodeUpdateNumber(getinput,goodidval);
	}

	function loadBarCodeUpdateNumber(barCodeInputObj,goodsId){ 
		if(!barCodeInputObj.size > 0){
			alert("商品代码与商品条码不符！");
			barCodeInputObj.val('');
			return;
		} 
		if(barCodeInputObj.val().length != 22){
			alert("商品条码位数不符！");
			barCodeInputObj.val('');
			return;
		}
		$(barCodeInputObj).parent().find('.gbc').val(barCodeInputObj.val().toUpperCase());
		//alert($(barCodeInputObj).parent().parent().find('.number').size())
		if($(barCodeInputObj).parent().parent().find('.number')[0].value == ''){
			$(barCodeInputObj).parent().parent().find('.number')[0].value = 0;
		}
		$(barCodeInputObj).parent().parent().find('.number')[0].value=accAdd(Number($(barCodeInputObj).parent().parent().find('.number')[0].value),1);

		needAmount();
		
	}
  	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="" />
<input type="hidden" id="tdvs" name="tdvs" value="" />
<input type="hidden" id="ioru" name="ioru" value="i" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
                    <TABLE cellSpacing=1 cellPadding=0 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" height="26" class="table_body">申请单号</TD>
                          <TD width="24%" height="26" class="table_none"><input class="text_input160" id="cshawbillid" name="wholePo.cshawbillid" value="${wholePo.cshawbillid}" readonly="readonly"></TD>
                          <TD width="9%" height="26" class="table_body">申请客户名称</TD>
			               <TD class="table_none" width="24%">
                            <select id="departmentID" name="wholePo.cshawindepartmentid">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsPos)}">
				               	  <s:iterator value="departmentsPos">
                    	           <OPTION value="${bdpdepartmentid}" ${wholePo.cshawoutdepartmentid != bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
      	                   </TD>
                          <TD class="table_body" height="26" width="9%">制单人</TD>
                          <TD class="table_none">${person.personName }<input type="hidden" name="wholePo.cshawcreateperson" value="${person.id}"></TD>
 						</TR>
						<tr>
 						  <TD height="26" class="table_body">单据日期</TD>
                          <TD class="table_none" colspan="5">
                          <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input name="wholePo.cshawbilldate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>					       
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          <textarea id="textarea" name="wholePo.cshawremark"></textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
						  <img src="${ctx }/img/newbtn/btn_goodsadd_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
						  <!-- <img src="${ctx }/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();"> -->
						  <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
						  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
						  </td>
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
                          <TH width="10%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="20%" scope=col>商品代码</TH>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>型号</TH>
                          <TH width="20%" scope=col>需求数量</TH>                  
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="needTotal">0</TH>
					    		
				   		</TR>
				   		<c:forEach var="po" items="${goodsInfoPos}">
                        <TR class="row">
                        <TD height="26"><input id="chk" type="checkbox" value="${po.bgigoodsid}" ></TD>
                        <TD>${po.bgigoodsid}
                        <input id="goodsid" type="hidden" name="goodsInfoTempPo.goodsid" value="${po.bgigoodsid}" />
                        </TD>
                        <TD>${po.bgigoodsname}</TD>
                        <TD>${po.bgispec}</TD>
                        <TD><input type="text" ${person.departmenttype==3?'readOnly=readOnly':'' } class="text_input60" onkeydown="OnKeyDownEnter(this)" name="needNumber" onblur="needAmount()" value="${po.bgigoodsquantity}" /></TD>                                                                        
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left"><input type="checkbox" id="cshawauditstate" name="wholePo.cshawauditstate" value="1">保存并审核
                           </TD>
					   </TR>
					   <TR>
						  <TD align="left"><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onclick="save()"></TD>
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