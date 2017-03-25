<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品退货管理</title>
</head>
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<script>
	$(document).ready(function(){
		$("input[name=goodsInfoTempPo.goodsquantity]").each(function(){
			autoCountOnlyOne(this);
		});
	});
	
	function save(){
	if(checkForm(document.all.procurementReturnForm)){ 
		var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		if(index==0){
		  alert('请选择商品!');
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
				return;	
			}		
		}
		
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
        
        	var nottaxrate = document.getElementsByName("goodsInfoTempPo.nottaxrate");
			var costprice = document.getElementsByName("goodsInfoTempPo.costprice");			
			var nottaxrateamount = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
			var taxamount = document.getElementsByName("goodsInfoTempPo.taxamount");
			var costpriceamount = document.getElementsByName("goodsInfoTempPo.costpriceamount");
			
			if (nottaxrate.length > 0){
			    for ( var i = 0 ; i < nottaxrate.length; i++){
			        if (Number(costprice[i].value) < Number(nottaxrate[i].value)){
			            alert("含税单价不能低于单位成本!");
			            nottaxrate[i].focus();
			            return;
			        }
			        if (accAdd(parseFloat(nottaxrateamount[i].value).toFixed(2),parseFloat(taxamount[i].value).toFixed(2)) != parseFloat(costpriceamount[i].value).toFixed(2)){
			            alert("成本合计、税额合计或价税合计填写有误!");
			            nottaxrateamount[i].focus();
			            return;
			        }
			    }
			}
		
		$("img").removeAttr("onclick");
		procurementReturnForm.action = "updateProcurementReturn.action";
		procurementReturnForm.submit();
		}
		
	}
		function openGoodSingle(){
		var supplierID= document.getElementById('cstisupplierid').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		//showPopWin("","initGoodsSingleSel.action?supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?supplierID_open=" + supplierID ,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGoodsSingleSel.action?supplierID_open=" + supplierID ,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品添加】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);			
		}
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
		//showPopWin("","selSupplierOpen.action",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
		
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
	
	function addRow(goodInfo,stateArray){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重 begin
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) return;
		}
		// 商品id去重 end
		
		// 添加商品到列表 begin
    	var readonlyFlg=document.getElementById("autoCount");

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
		

		// 添加商品到列表 end	
	   		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
	        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" /><input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="' + goodInfo.bgigoodsbarcode +'" />';
	        c3.innerHTML = goodInfo.bgigoodsname;
			c4.innerHTML = goodInfo.bgispec;
		
			var goodsquantityArray = document.getElementsByName("goodsInfoTempPo.goodsquantity");
	    	var nottaxrateArray = document.getElementsByName("goodsInfoTempPo.nottaxrate");
	    	var nottaxrateamountArray = document.getElementsByName("goodsInfoTempPo.nottaxrateamount");
	    	var taxrateArray = document.getElementsByName("goodsInfoTempPo.taxrate");
	    	var costpriceArray = document.getElementsByName("goodsInfoTempPo.costprice");
	    	var costpriceamountArray = document.getElementsByName("goodsInfoTempPo.costpriceamount");
	    	var taxamountArray = document.getElementsByName("goodsInfoTempPo.taxamount");
	    	
	    	if(readonlyFlg.checked){    
				c5.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				c6.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
				c8.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c9.innerHTML = '<input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
				c11.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的价税合计！\'}]"/>';
				c10.innerHTML = '<input type="text" onchange="remove();" style="background-color:#ACA899" readOnly="readonly" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的税额合计！\'}]"/>';	
	    	}else{
	 			c5.innerHTML = '<input type="text" onchange="totalCount();" value="0" style="width:100%" name="goodsInfoTempPo.goodsquantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的商品数量！\'}]"/>';		
				c6.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="' + goodInfo.bginottaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写单位成本！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的单位成本！\'}]"/>';
				c7.innerHTML = '<input type="text" onchange="totalCount();" name="goodsInfoTempPo.nottaxrateamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写成本合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的成本合计！\'}]"/>';		
				c8.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxrate" value="' + goodInfo.bgitaxrate +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税率！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请填写正确的税率！\'}]"/>';				
				c9.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costprice" value="' + goodInfo.bgicostprice +'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写含税单价！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的含税单价！\'}]"/>';
				c11.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写价税合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的价税合计！\'}]"/>';
				c10.innerHTML = '<input type="text" onchange="totalCount();" style="width:100%" name="goodsInfoTempPo.taxamount" value="0.00" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写税额合计！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的税额合计！\'}]"/>';	
	
	    	}
    	// 初始化添加的每行商品信息的Input标签readonly属性以及onchange方法 end
    }
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});	
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReturnForm" method="post" action="">
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="24%">${inventoryPo.cstibillid}<input type="hidden" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}"></TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD width="24%" class="table_none">
			               	 ${fn:substring(inventoryPo.cstibilldate,0,10)}
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">${inventoryPo.cstisuppliername}
						   		<input type="hidden" id="cstisupplierid" name="inventoryPo.cstisupplierid" value="${inventoryPo.cstisupplierid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/></TD>
                        </TR>                        
                        <TR>
                           <TD height="26" class="table_body">退货部门</TD>
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
                          <TD align="left" width="80%">
						   <!-- <img src="${ctx}/img/newbtn/btn_addgoods_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_addgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_addgoods_0.png');" title="单品添加商品" 
						  onClick="javascript:openGoodSingle();"> -->
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
 						  <TH scope=col width="5%">数量</TH>	
 						  <TH scope=col width="7%">单位成本</TH>
						  <TH scope=col width="7%">成本合计</TH>
                          <TH scope=col width="5%">税率</TH>
						  <TH scope=col width="7%">含税单价</TH>
						  <TH scope=col width="7%">税额合计</TH>	
                          <TH scope=col width="7%">价税合计</TH>
						 			  
                        </TR>
                        <tr class=table_title align=middle> 
						  	<th width="45%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    	<th scope=col width="7%">&nbsp;</th>
					    	<th scope=col width="10%" id="nottaxrateamountTotal">&nbsp;</th>
					    	<th scope=col width="6%">&nbsp;</th>
					    	<th scope=col width="7%" >&nbsp;</th>
					    	<th scope=col width="10%" id="taxamountTotal">&nbsp;</th>
					    	<th scope=col width="10%" id="costpriceamountTotal">&nbsp;</th>
					    	
				   		</tr>
				   		<s:iterator value="inventoryEntryList" status="idx">
	                        <TR class="row">
	                        <TD height="26"><input id="chk" type="checkbox" value="${cstiegoodsid}" ></TD>
	                        <TD>${cstiegoodsid}
	                        <input type="hidden" name="goodsInfoTempPo.goodsid" value="${cstiegoodsid}" />
	                        <input type="hidden" name="goodsInfoTempPo.goodsbarcode" value="${cstiebarcode}" />
	                        </TD>
	                        <TD>${cstiegoodsname}</TD>
	                        <TD>${cstiespec}</TD>
	                        <TD>${cstiegoodsquantity}<input type="hidden" onKeyUp="value=value.replace(/[^\d]/g,'');if(value){autoCountOnlyOne(this);}else{value=0;}" style="width:100%" value="${cstiegoodsquantity}" name="goodsInfoTempPo.goodsquantity" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请填写正确的商品数量！'}]" readonly="readonly"/></TD>                                               
	                        <TD><input type="text" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" name="goodsInfoTempPo.nottaxrate" value="${cstienottaxrate}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写单位成本！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的单位成本！'}]"/></TD>
	                        <TD><input type="text" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" name="goodsInfoTempPo.nottaxrateamount" value="${cstienottaxrateamount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写成本合计！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的成本合计！'}]"/></TD>
	                        <TD><input type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'');if(value){autoCountOnlyOne(this);}else{value=0;}" style="width:100%" name="goodsInfoTempPo.taxrate" value="${cstietaxrate}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写税率！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请填写正确的税率！'}]"/></TD>
	                        <TD><input type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'');if(value){autoCountOnlyOne(this);}else{value='0.00';}" style="width:100%" name="goodsInfoTempPo.costprice" value="${cstiecostprice}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写含税单价！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的含税单价！'}]"/></TD>
	                        <TD><input type="text" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" style="width:100%" name="goodsInfoTempPo.taxamount" value="${cstietaxamount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写税额合计！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的税额合计！'}]"/></TD> 
	                        <TD><input type="text" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="${cstiecostpriceamount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写价税合计！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的价税合计！'}]"/></TD>
	                                                                                                   
	                        </TR>
                        </s:iterator>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          		<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</li>
                          	<c:if test="${(permissionPo.keyd==1)}">
                          	<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstifinanceauditstate" name="inventoryPo.cstifinanceauditstate" value="1">保存并审核
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