<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>盘盈盘亏新增</title>
</head>
<script>
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('cstpsupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
	}
  	function amount1(){
		var total=0;
		$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#goodsquantityTotal').text(total);
  	}

	//手动修改商品条码后，验证商品列表中，是否已经添加了该条码的商品。
	function pcbarcodeChange(obj){
		var ybc = $(obj).parent().find("#bc").val().substring(0,18).toUpperCase();
		var bc = $(obj).val().substring(0,18).toUpperCase();
		if(ybc != bc){
			alert("条码与商品不符!");
			$(obj).select();
			return false;
		}
		
		if($(obj).val().length != 26){
			alert("条码位数不正确!");
			$(obj).select();
			return false;
		}

		//判断该条码是否仅有一条数据
		if($("input[id=pcbarcode][value="+obj.value+"]").size()>1){		
			alert("该条码已经选择过，请核对！");
			$(obj).select();
			return false;
		}	
	}
	
	function save(){
		if(checkForm(document.all.procurementOrdersForm)){
			if (document.getElementById('addTable').rows.length == 1){
				alert("请选择商品！");
				return;
			}

			//判断条码是否输入正确
			var pcbarcodeArray = document.getElementsByName("goodsInfoTempPo.pcbarcode");
			for(i=0;i<pcbarcodeArray.length;i++){
				if(pcbarcodeChange(pcbarcodeArray[i])==false){
					return;
				}
			}
			
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
			procurementOrdersForm.action = "insertOveragelosses.action";
			procurementOrdersForm.submit();
		}
	}
	
	function openGoodSingle(){
		
		var categoryID_open = $("#goodscategoryID").val();
		<c:if test="${systemParameterPo.fspcheckstorageflag eq '1'}">
		if(categoryID_open == ""){
			alert("请选择盘点类别！");
			$("#goodscategoryID").focus();
			$("#goodscategoryID").select();
			return;
		}
		</c:if>	

	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?whichretail=1&select_retail=1&isshowstealth=1&categoryID_open="+categoryID_open,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?whichretail=1&select_retail=1&isshowstealth=1&categoryID_open="+categoryID_open,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【商品添加】";
	}
	//子页面添加单行	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);
			
		}
	}
	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		amount1();
	}
     function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.bgigoodsid){
			   $(this).parent().parent().remove();	
           }
		});
		
		amount1();
    }		
	
	function addRow(goodInfo){

		$("#goodscategoryname").text($("#goodscategoryID").find("option[value="+$("#goodscategoryID").val()+"]").text());
		$("#goodscategoryID").hide();
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
				
		// 商品id去重
		var issubmit = '0';
		$("input[id=pcbarcode]").each(function(){
         	if($(this).val()== goodInfo.bgigoodsbarcode){
					issubmit='1';
           }
		});
		
		if(issubmit == '1'){
	        return;
	    }
		if(goodInfo.goodsquantity<="0")
		{
			return;
		}

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c3 = row.insertCell(2);
		</c:if>
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		
		row.className = 'row';
		row.height="28";
		var bc = goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase();
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" />';
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		c2.innerHTML = "<img src=\"${ctx}/img/newbtn/addgoods_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');\" btn=btn title='复制商品' onClick='copyRow(this);amount1();'>"+goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
		</c:if>
        <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'+'<input type="hidden" class="text_input200" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgigoodsbarcode+'"/><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';        
		</c:if>		
        //if (('${systemParameterPo.fspbarcodetype}' == 1 || '${systemParameterPo.fspbarcodetype}' == 2 ) && '${systemParameterPo.fspstealtheffective}' != 0 && (goodInfo.bgigoodsid.substring(0,1) == '4' || goodInfo.bgigoodsid.substring(0,1) == '5')){
        //    c3.innerHTML = '<input type="text" class="text_input200" onblur="checkbarcode(this);" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgipcbarcode+'"/><input type="text" id="bc" value="'+goodInfo.bgipcbarcode+'"/>';
        // }else if ('${systemParameterPo.fspbarcodetype}' == 3){
        //    c2.innerHTML = c2.innerHTML + '<input type="hidden" class="text_input200" onblur="checkbarcode(this);" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgigoodsbarcode+'" readonly="readonly"/><input type="text" id="bc" value="'+goodInfo.bgipcbarcode+'"/>';
        // }else{
        //    c3.innerHTML = '<input type="text" class="text_input200" onblur="checkbarcode(this);" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgigoodsbarcode+'" readonly="readonly"/><input type="text" id="bc" value="'+goodInfo.bgipcbarcode+'"/>';
        //}
			

		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		c3.innerHTML = '<input type="text" class="text_input200" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgigoodsbarcode+'"/><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';
		</c:if>                
		c4.innerHTML = goodInfo.bgigoodsname+'<input type="hidden" name="goodsInfoTempPo.goodsname" value="'+goodInfo.bgigoodsname+'"/>';
		c5.innerHTML = goodInfo.bgispec+'<input type="hidden" name="goodsInfoTempPo.spec" value="'+goodInfo.bgispec+'"/>';
		c6.innerHTML = '<input type="text" class="text_input80"  name="goodsInfoTempPo.goodsquantity" onblur="amount1();"  value="' + ((goodInfo.goodsquantity != "" && goodInfo.goodsquantity != null) ?  goodInfo.goodsquantity : "") + '" maxlength="18" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'}, {\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写商品数量！\'}]"/>';

		amount1();
	}
	
	function addRowUpdateNumber(goodInfo){


		$("#goodscategoryname").text($("#goodscategoryID").find("option[value="+$("#goodscategoryID").val()+"]").text());
		$("#goodscategoryID").hide();
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
				
		// 商品id去重
		var issubmit = '0';
		$("input[id=pcbarcode]").each(function(){
         	if($(this).val()== goodInfo.bgigoodsbarcode){
					issubmit='1';
           }
		});
		
		if(issubmit == '1'){
	        return;
	    }
		if(goodInfo.goodsquantity<="0")
		{
			return;
		}

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		var c3 = row.insertCell(2);
		</c:if>
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		
		row.className = 'row';
		row.height="28";
		var bc = goodInfo.bgigoodsbarcode.substring(0,18).toUpperCase();
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" />';
		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		c2.innerHTML = "<img src=\"${ctx}/img/newbtn/addgoods_0.png\" onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/addgoods_0.png');\" btn=btn title='复制商品' onClick='copyRow(this);amount1();'>"+goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />';
		</c:if>
        <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" id="retailprice" value="' + goodInfo.bgiretailprice +'" /><input type="hidden" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" /><input type="hidden" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" /><input type="hidden" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" />'+'<input type="hidden" class="text_input200" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgigoodsbarcode+'"/><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';        
		</c:if>		
        //if (('${systemParameterPo.fspbarcodetype}' == 1 || '${systemParameterPo.fspbarcodetype}' == 2 ) && '${systemParameterPo.fspstealtheffective}' != 0 && (goodInfo.bgigoodsid.substring(0,1) == '4' || goodInfo.bgigoodsid.substring(0,1) == '5')){
        //    c3.innerHTML = '<input type="text" class="text_input200" onblur="checkbarcode(this);" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgipcbarcode+'"/><input type="text" id="bc" value="'+goodInfo.bgipcbarcode+'"/>';
        // }else if ('${systemParameterPo.fspbarcodetype}' == 3){
        //    c2.innerHTML = c2.innerHTML + '<input type="hidden" class="text_input200" onblur="checkbarcode(this);" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgigoodsbarcode+'" readonly="readonly"/><input type="text" id="bc" value="'+goodInfo.bgipcbarcode+'"/>';
        // }else{
        //    c3.innerHTML = '<input type="text" class="text_input200" onblur="checkbarcode(this);" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgigoodsbarcode+'" readonly="readonly"/><input type="text" id="bc" value="'+goodInfo.bgipcbarcode+'"/>';
        //}
			

		<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
		c3.innerHTML = '<input type="text" class="text_input200" maxlength="26" id="pcbarcode"  name="goodsInfoTempPo.pcbarcode" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品条码！\'}]" value="'+goodInfo.bgigoodsbarcode+'"/><input readonly="readonly" type="hidden" id="bc" value="'+bc+'"/>';
		</c:if>                
		c4.innerHTML = goodInfo.bgigoodsname+'<input type="hidden" name="goodsInfoTempPo.goodsname" value="'+goodInfo.bgigoodsname+'"/>';
		c5.innerHTML = goodInfo.bgispec+'<input type="hidden" name="goodsInfoTempPo.spec" value="'+goodInfo.bgispec+'"/>';
		c6.innerHTML = '<input type="text" class="text_input80"  name="goodsInfoTempPo.goodsquantity" onblur="amount1();"  value="' + ((goodInfo.goodsquantity != "" && goodInfo.goodsquantity != null) ?  goodInfo.goodsquantity : "") + '" maxlength="18" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'}, {\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写商品数量！\'}]"/>';

		amount1();
	}
	
	function loadBar(obj){
		$("[value="+obj+"]").parent().parent().find('input[name=goodsInfoTempPo.goodsquantity]').eq(0).val(accAdd(Number($("[value="+obj+"]").parent().parent().find('input[name=goodsInfoTempPo.goodsquantity]')[0].value),1));
		amount1();
	}
	
	function loadBarUpdateNumber(obj){
		$("[value="+obj+"]").parent().parent().find('input[name=goodsInfoTempPo.goodsquantity]').eq(0).val(accAdd(Number($("[value="+obj+"]").parent().parent().find('input[name=goodsInfoTempPo.goodsquantity]')[0].value),1));
		amount1();
	}

	function checkbarcode(obj){
		if($(obj).val()){
			var ybc = $(obj).parent().find("#bc").val().substring(0,18).toUpperCase();
			var bc = $(obj).val().substring(0,18).toUpperCase();
			if(ybc != bc){
				alert("条码与商品不符!");
				$(obj).select();
				return;
			}
			
			if($(obj).val().length != 26){
				alert("条码位数不足!");
				$(obj).select();
				return;
			}
		}
	}
    
    function deleteitem(){
        $('input[id=chk]').each(function(){ 
           if($(this).is(":checked")){ 
             $(this).parent().parent().remove(); 
           } 
        }); 
        amount1();
		document.all.chks.checked = false;
		if($("table[id=addTable]").find("tr").size() == 2){
			$("#goodscategoryname").text("");
			$("#goodscategoryID").show();
		}
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
      }else
      {
      	document.all.cstiauditstate1.checked = false;	
      }
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

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function copyRow(obj){
    	$(obj).parent().parent().clone(true).appendTo($(obj).parent().parent().parent());
	}
	
	$(document).ready(function(){
		<s:iterator value="inventoryEntryList">
			if('${cstiegoodsid}'!='' && '${cstiegoodsid}'!=null){
			     var json = {'bgigoodsid':'${cstiegoodsid}','bgigoodsbarcode':'${cstiepcbarcode}',
			     				'bgigoodsname':'${cstiegoodsname}','bgipcbarcode':'${cstiepcbarcode}',
			     				'bgispec':'${cstiespec}','bgicostprice':'${cstiecostprice}','bginottaxrate':'${cstienottaxrate}',
			     				'bgitaxrate':'${cstietaxrate}',
			     				'goodsquantity':'${cstiegoodsquantity}'};
		    	  addRow(json);
			}
		</s:iterator>
	});
	
	function scanbarcode(){
		if(!$("#cshcsstockid").val()){
			alert("请选择盘点仓位！");
			$("#cshcsstockid").focus();
			$("#cshcsstockid").select();
			return;
		}
		
		var categoryID_open = $("#goodscategoryID").val();
		
		if('${systemParameterPo.fspisallocationcategory}' == '1'){
			if(categoryID_open == ""){
				alert("请选择盘点类别！");
				$("#goodscategoryID").focus();
				$("#goodscategoryID").select();
				return;
			}
		}
		
		if(!categoryID_open){
			categoryID_open = '';
		}
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initScanBarcode.action?outstockid="+$("#cshaaoutstockid").val(),350,55,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initScanBarcode.action?outstockid="+$("#cshaaoutstockid").val(),350,55,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【条码扫描】";
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementOrdersForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="isrefresh" value="1" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" id="allocation" value="allocation" /> 

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
                    <TABLE cellSpacing=1 cellPadding=0 width="100%" align=center align=center cellpadding=1 cellspacing=1 class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                           <TD width="9%" class="table_body">盘点仓位</TD>
                            <TD width="24%" class="table_none">
                         <select id="cshcsstockid" name="inventoryPo.cstiinstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入盘点仓位！'}]">
                          <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">
      		                   	<option value="${bwhid}" ${inventoryPo.cstiinstockid eq bwhid || inventoryPo.cstioutstockid eq bwhid ? 'selected="selected"':'' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
                          <TD width="9%" class="table_body" height="26">盘盈盘亏</TD>
                          <TD class="table_none" width="24%">
	                        <select name="inventoryPo.cstibilltypeid" id="cstibilltypeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入盘盈盘亏！'}]">
                            <option value="">----请选择----</option>
                            <option value="5" ${inventoryPo.cstibilltypeid eq '5' ? 'selected="selected"':'' }>盘盈</option>
                            <option value="6" ${inventoryPo.cstibilltypeid eq '6' ? 'selected="selected"':'' }>盘亏</option>
                            </select>
						  </TD>
 						  <TD class="table_body" height="26" width="9%">制单人</TD>
                          <TD class="table_none">${person.personName }<input class="text_input100" type="hidden" name="inventoryPo.csticreateperson" value="${person.id }"></TD>
                        </TR>
                        <TR>
                          <TD class="table_body">单据日期</TD>
                          <TD class="table_none">&nbsp;<jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input class="text_input100" type="hidden"
					       name="inventoryPo.cstibilldate" type="text" readonly="readonly" 
					       		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择单据日期！'}]"
					       		value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>
					      <TD width="9%" height="26" class="table_body">盘点类型</TD>
			               <TD class="table_none" colspan="3">
     	                	<c:choose>
     	                		<c:when test="${systemParameterPo.fspcheckstorageflag eq '1'}">
								<select id="goodscategoryID" name="inventoryPo.cstigoodscategory">
      		                 		<option value="">----请选择----</option>
      		                 		<s:iterator value="goodsCategorys">
				              			<option value="${bgcid}" ${inventoryPo.cstigoodscategory == bgcid ? 'selected="selected"':'' }>${bgcgoodscategoryname}</option>
	     	                 		</s:iterator>
      	                   		</select>
								</c:when>
								<c:otherwise>
									<input type="hidden" value="" id="goodscategoryID" name="inventoryPo.cstigoodscategory" />不限定商品类别	
								</c:otherwise>
							</c:choose>			               
			                <div id="goodscategoryname"></div>
			               </TD>
						 </TR>
						 <tr>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colspan="5"><label>
                          <textarea name="inventoryPo.cstiremark" id="textarea"
                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]"></textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" width="60%">
							  <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_addgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_addgoods_0.png');" title="单品添加商品" 
							  onClick="javascript:openGoodSingle();">
							  <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
							  <img src="${ctx}/img/newbtn/btn_scanbarcode_0.png" btn=btn title="条码扫描" onClick="javascript:scanbarcode();">
							  </c:if>
						  </td>
						  <td width="40%" align="right">
					      	<img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');" title="删除" onClick="deleteitem();" >
					      </td>
                        </TR>
                      </TBODY>
                    </TABLE>
                     <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          <li class="horizontal_onlyRight"><img id="savebtn1" btn=btn src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" title='保存' onclick="save()"></li>
                          <c:if test="${(permissionPo.keyc==1)}"><li class="horizontal_onlyRight"><input type="checkbox" id="cstiauditstate1" onclick="check()">保存并审核</li></c:if>
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
						  <TH scope=col width="5%">全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
						  <TH scope=col width="20%" height="26">商品代码</TH>
						   <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  <TH scope=col width="20%" height="26">商品条码</TH>
						  </c:if>
						  <TH scope=col width="20%">商品名称</TH>
                          <TH scope=col width="15%">型号</TH>
                          <TH scope=col width="15%">数量</TH>
                        </TR>
                        <TR class=table_title align=middle>
                          <TH height="26"  scope=col></TH>
                          <TH  scope=col></TH>
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  <TH ></TH>
						  </c:if>
						  <TH scope=col>&nbsp;</TH>
                          <TH >合计:</TH>
                          <TH scope=col id="goodsquantityTotal">0</TH>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          <li class="horizontal_onlyRight"><img id="savebtn" btn=btn src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" title='保存' onclick="save();"></li>
                          	<c:if test="${(permissionPo.keyc==1)}">
                          		<li class="horizontal_onlyRight"><input type="checkbox" id="cstiauditstate" name="inventoryPo.cstiauditstate" onclick="check1()" value="1">保存并审核</li>
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