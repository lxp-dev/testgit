<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>条码打印</title>
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
	
	function batPrintGoodsBarCode(){
		if(checkPrintPrices()) {
			if(checkPrintNumber()) {
				if(confirm("条码打印确认！")){
					var barCodes = $("input[name=retailprice]");
					var goodsQuantitys = $("input[name=quantity]");
					for(var i=0; i<barCodes.length; i++){
						try {
							PrintJQ(barCodes[i].value, goodsQuantitys[i].value);
						} catch(e) {
							alert("打印失败!请检查条码打印机是否已正确连接!");
						}
					}
				}
			}
		}
	}

	function checkPrintPrices() {
        var reg_price = /^([1-9]{1,1}\d{0,10})\.\d{2,2}--([1-9]{1,1}\d{0,10})\.\d{2,2}$/;
        var flag = true;
        $("input[id=retailprice]").each(function() {
        	var thisVal = $(this).val();
            if(reg_price.exec(thisVal) == null) {
                alert("零售价范围格式不正确!正确格式为: 12.00--45.00");
                $(this).select();
                flag = false;
            } else {
                var prices = thisVal.split("--");
                if(parseFloat(prices[0]) > parseFloat(prices[1])) {
                    alert("价格顺序填写有误!请按从小到大的顺序填写!");
                    $(this).select();
                    flag = false;
                }
            }
        });
        return flag;
	}

    function checkPrintNumber() {
        var flag = true;
        $("input[id=quantity]").each(function() {
            if(isNaN($(this).val()) || $(this).val() <= 0) {
                alert("请填写正确的打印数量!");
                flag = false;
                $(this).select();
                return flag;
            }
        });
        return flag;
    }
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelPrintBrandOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelPrintBrandOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=$("input[id=chk]");
        var chks=$("#chks");
        var ischeck = chks.attr("checked");
        chk.each(function (){
        	$(this).attr("checked",ischeck);
        });
    }
    
	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var brandPos = eval('(' + objValue + ')');
		
		for(var i = 0; i < brandPos.length; i++){
			deleterow(brandPos[i]);
		}
	}
	
	function openGoodSingleValues(objValue){
		var brandPos = eval('(' + objValue + ')');
		for(var i = 0; i < brandPos.length; i++){	
			addRow(brandPos[i]);
		}
	}
	
    function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.bbdid){
			   $(this).parent().parent().remove();	
           }
		});
    }
    
	
	function addRow(brandPo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == brandPo.bbdid) return;
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
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + brandPo.bbdid + '" />';
        c2.innerHTML = brandPo.bbdid + '<input type="hidden" name="brandID" value="' + brandPo.bbdid +'" />';
        c3.innerHTML = brandPo.bbdbrandname + '<input type="hidden" id="brandName" name="brandName" value="' + brandPo.bbdbrandname +'" />';
		c4.innerHTML = brandPo.bgcgoodscategoryname + '<input type="hidden" id="bgcgoodscategoryname" name="bgcgoodscategoryname" value="' + brandPo.bgcgoodscategoryname +'" />';
		c5.innerHTML = '<input type="text" class="text_input200" id="retailprice" name="retailprice" value="' + brandPo.bbdminretailPrice+"--"+brandPo.bbdmaxretailPrice +'" maxlength="18"/>';
		c6.innerHTML = '<input type="text" class="text_input60" maxlength="5" name="quantity" id="quantity" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写打印数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'打印数量应为整数！\'}]" onkeyup="value=value.replace(/[^\\d]/g, \'\')" />';
    }
    
    function deleteitem(){
    	// 商品id去重
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
		
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="printJQForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：价签打印</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                    <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPrintBarcode.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">条码打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                    <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif
                      onclick="JavaScript:window.location.href='initPrintBrandBarcode.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">品种打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">价签打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                    <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPrintJQcqjy.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">商品标价签打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
                 	<table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="addGodos" src="${ctx}/img/newbtn/btn_addbrand_0.png" btn=btn title="添加品种"  onClick="javascript:openBrand();">
								<img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos" onClick="javascript:batPrintGoodsBarCode();">
								<img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
							</td>
						</tr>
					</table>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
                    
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="8%" height="30">全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="15%" scope=col>品种代码</TH>
						  <TH width="25%" scope=col>品种</TH>						
                          <TH width="25%" scope=col>制造商</TH>
						  <TH width="20%" scope=col>零售价范围</TH>
						  <TH scope=col>打印数量</TH>
						</TR>
                      </TBODY>
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