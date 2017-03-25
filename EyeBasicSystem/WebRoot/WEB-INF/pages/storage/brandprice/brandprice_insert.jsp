<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>品种调价管理</title>
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
		$('input[id=updateretailprice]').each(function(){
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
		adjustmentPriceForm.action = "brandPriceInsert.action";
		adjustmentPriceForm.submit();
		}
	}
	
	function toFixAndNan(obj){
		obj.value=obj.value.replace(/[^0-9.][0-9]*/g,'');
	}
	
	function toFix(obj){
		if(obj.value!=''){
			obj.value=parseFloat(obj.value).toFixed(2);
		}
	}
	
	function moreAdjustmentPrice_open(){
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
			showPopWin("initBrandPriceSel.action?whichretail=1&select_retail=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initBrandPriceSel.action?whichretail=1&select_retail=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种添加】";
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
			
         	if($(this).val()== goodInfo.goodsid){
			   $(this).parent().parent().remove();	
           }
		});
    }
	
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.goodsid) return;
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.goodsid + '" >';
        c2.innerHTML = goodInfo.brands + '<input type="hidden" id="brandid" name="brandTempPo.brandid" value="' + goodInfo.bbdid +'" />'+ '<input type="hidden" id="categoryid" name="brandTempPo.categoryid" value="' + goodInfo.bspcategoryid +'" />';
        c3.innerHTML = goodInfo.bbdbrandname+ '<input type="hidden" id="goodsname" name="brandTempPo.brandname" value="' + goodInfo.bbdbrandname +'" />';
		c4.innerHTML = goodInfo.bspsuppliername+ '<input type="hidden" id="suppliername" name="brandTempPo.suppliername" value="' + goodInfo.bspsuppliername +'" />'+ '<input type="hidden" id="supplierid" name="brandTempPo.supplierid" value="' + goodInfo.bbdsupplierid +'" />';
		c5.innerHTML = goodInfo.bbdretailprice+ '<input type="hidden" id="retailprice" name="brandTempPo.retailprice" value="' + goodInfo.bbdretailprice +'" />';
		c6.innerHTML = '<input  type="text" id="updateretailprice" name="brandTempPo.updateretailprice" value="" onkeyup="toFixAndNan(this)" class="text_input60" onblur="toFix(this)" >';	
		
		$('#del' + index).btn().init();
		$("#bgiwhichretail").val(goodInfo.bbdwhichretail);
		$("#td_whichretail").text("零售价格"+goodInfo.bbdwhichretail);
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
        var adjustmentPrice=Math.round(parseFloat(price)*Math.pow(10,2))/Math.pow(10,2);
        var count = document.getElementsByName('goodsInfoTempPo.adprice').length;        
        for ( var i = 0; i < count; i++ ){
            document.getElementsByName('goodsInfoTempPo.adprice')[i].value=adjustmentPrice;
       }
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="adjustmentPriceForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />


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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body">单据编号</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" id="cshaabillid" name="adjustmentPricePo.cprapbillid" value="${adjustmentPricePo.cprapbillid }" readonly="readonly"></TD>
                          <TD width="9%" class="table_body">制单日期</TD>
                          <TD width="24%" class="table_none">
                          <jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" /></TD>
                          <TD width="10%" class="table_body">制单人</TD>
                          <TD class="table_none">${person.personName }</TD>
                         <input name="adjustmentPricePo.cprapcreatedate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/>
                        </TR>
                        <TR>
                          <TD width="10%" class="table_body">调价方式</TD>
					      <TD width="24%" class="table_none">
					        <input type="hidden" id="adjustmentPriceWay" name="adjustmentPricePo.cprapflag" value="0">
                          	实时调价&nbsp;<input type="radio" id="realTime" name="radioBtn" onClick="isshow()" checked="checked" >&nbsp;&nbsp;&nbsp;
                                                                          按生效日期调价&nbsp;<input type="radio" id="fixedTime" name="radioBtn" onClick="isshow()" >
                          </TD>
                          <TD width="10%" class="table_body">零售价格种类</TD>
					      <TD width="24%" class="table_none" id="td_whichretail" colspan="3">
                            &nbsp;
                          </TD>
                          <input type="hidden" id="bgiwhichretail" name="adjustmentPricePo.cprapwhichprice" value="" />
                        </TR>
                        <TR id="showtr" style="display: none">
                          <TD class="table_body">生效日期</TD>
                          <TD class="table_none" colSpan=6>
                           <input id="effecticeTime"
					       name="adjustmentPricePo.cprapeffectivedate" 
					       type="text" class="text_input200"  
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd',minDate:'${effectiveTime}'})" value="" />
					       </TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><textarea name="adjustmentPricePo.cprapremark" id="textarea2"></textarea></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TR>
                        <TD align="left">
                          <img name="button22" btn=btn src="${ctx}/img/newbtn/btn_ppaddgoods_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_ppaddgoods_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_ppaddgoods_0.png');" title="添加品种" 
						  onClick="javascript:openGoodSingle();"> 
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
                         <TH width="7%" height="30" scope=col>全选<input type="checkbox"  id="chks" onclick="chkAll()"></TH>                        
                          	<TH scope=col width="10%">品种代码</TH>
	                          <TH scope=col width="20%">品种名称</TH>
	                          <TH scope=col width="20%">所属制造商</TH>
                          <TH width="10%" scope=col>现销售价格</TH>
                          <TH width="10%" scope=col>调整价格</TH>
                          </TR>
                        
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" valign="bottom">
                          	<li class="horizontal_onlyRight">
                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</li>
                          	<li class="horizontal_onlyRight">
                          		<input name="saveAndAudit" type="checkbox" value="保存并审核">保存并审核
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