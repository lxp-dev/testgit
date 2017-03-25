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
	function batPrintGoodsBarCode(){
		if($('#goodsBarcode').val()==''||$('#quantity').val()==''||$('#quantity').val()=='0'||isNaN($('#quantity').val())){
			alert('请输入条码和数量,数量只能为非0数字!');return;
		}else{
			if(confirm("条码打印确认！")){
					var barCodes = document.getElementsByName("goodsBarcode");
					var goodsQuantitys = document.getElementsByName("quantity");
					var suffix;
					var flag = false;
					
					var barCount = 0;
					var barCode = new Array();
					var quantity = new Array();
					for(var i=0 ; i< barCodes.length; i++){
						//alert(suffix);
						//printBarCode(barCodes[rowNumber-1].value,goodsQuantitys[rowNumber-1].value);
						//printBarCode(barCodes[i-1].value,goodsQuantitys[i-1].value);
						//alert(barCodes[i].value);
						//setTimeout(alert(barCodes[i].value),500);
						barCode[barCode.length] = barCodes[i].value;
						quantity[quantity.length] = goodsQuantitys[i].value;
						//printBarCode(barCodes[i].value,goodsQuantitys[i].value);
						
						//alert("1");
					}
					try{
						printBarCode(barCode, quantity);
					} catch(e) {
						alert("打印失败!请检查条码打印机是否正确连接!");
						return;
					}
							
			}
		}
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="workingCheckForm" method="post" action="">
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
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：条码打印</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
            <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
	     	</TD>
          </TR>
        </TBODY>
      </TABLE>
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
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                       onclick="JavaScript:window.location.href='initPrintsBarcode.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">单条打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
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
							<input id="addGodos" icon='icon-edit' type='button' value="打印条码"  onClick="javascript:batPrintGoodsBarCode();">
								
							</td>
						</tr>
					</table>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="10%" height="30" class="table_body">商品条码</TD>
			               <TD class="table_none" width="30%">
                            <input class="text_input200" type="text"  id="goodsBarcode" name="goodsBarcode" value="">
			               </TD>
			               <TD width="10%" height="30" class="table_body">打印数量</TD>
                            <TD class="table_none">
			               <input class="text_input200" type="text"  id="quantity" name="quantity" value="">
                           </TD>
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