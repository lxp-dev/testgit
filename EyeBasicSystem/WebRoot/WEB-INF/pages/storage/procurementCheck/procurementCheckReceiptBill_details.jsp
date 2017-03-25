<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>

<script>

   	//条码批量打印
	function batPrintGoodsBarCode(){
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			if(ids !== undefined){
				var barCodes = document.getElementsByName("goodsInfoTempPo.pcbarcode");
				var goodsQuantitys = document.getElementsByName("goodsInfoTempPo.goodsquantity");
				var suffix;
				var flag = false;
				
				var barCount = 0;
				var barCode = new Array();
				var quantity = new Array();
				for(var i=0 ; i< ids.length; i++){
					if(ids[i].checked == true){
						//alert(ids[i]);
						//suffix =  ("ids",ids[i]);
						//alert(suffix);
						//printBarCode(barCodes[rowNumber-1].value,goodsQuantitys[rowNumber-1].value);
						//printBarCode(barCodes[i-1].value,goodsQuantitys[i-1].value);
						//alert(barCodes[i].value);
						//setTimeout(alert(barCodes[i].value),500);
						//alert(barCodes[i].value);
						//alert(goodsQuantitys[i].value);
						
						barCode[barCode.length] = barCodes[i].value;
						quantity[quantity.length] = goodsQuantitys[i].value;
					
						//printBarCode(barCodes[i].value,goodsQuantitys[i].value);
						
						flag = true;
					}
				}
				if(flag == false){
					alert("请钩选要打印的商品条码！");
				}else{
					try{
						printBarCode(barCode, quantity);
					} catch(e) {
						alert("打印失败!请检查条码打印机是否正确连接!");
						return;
					}
				}
			}
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
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
	window.onload = function(){
		var cstpgoodscategory = $('#cstpgoodscategory').val();
		isshow(cstpgoodscategory);
		amount();
	}

   // function printReport(id){
    //	var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	
		//url+="storage/stockReceive/stockReceiveRpt&inventoryid="+id+"&rs:Command=Render";
		
		//window.open (url, '查询窗口', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
   // }
   
   
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
    		if(type == "1"){
    		
    			$('[group*=]').show();
    			$('[group=qj]').hide();
    			$('[group=zj]').hide();
    			$('[group=zx]').hide();
    			$('[group=ql]').hide();
    			$('[group=xq]').hide();
    			$('[group=zhj]').hide();
    			$('#heji').attr("colSpan","6");
    			
    		}else if(type == "2"){
    		
    			$('[group*=]').show();
    			$('[group=ys]').hide();
    			$('[group=qj]').hide();
    			$('[group=zj]').hide();
    			$('[group=zx]').hide();
    			$('[group=ql]').hide();
    			$('[group=xq]').hide();
    			$('[group=zhj]').hide();
    			$('#heji').attr("colSpan","5");
    			
    		}else if(type == "3"){
    		
    			$('[group*=]').show();
    			$('[group=ql]').hide();
    			$('[group=xq]').hide();
    			$('#heji').attr("colSpan","10");
    			
    		}else if(type == "4"){
    		
    			$('[group*=]').show();
    			$('#heji').attr("colSpan","13");
    			
    		}else if(type == "5"){
    		
    			$('[group*=]').show();
    			$('[group=ys]').hide();
    			$('[group=qj]').hide();
    			$('[group=zj]').hide();
    			$('[group=zx]').hide();
    			$('[group=ql]').hide();
    			
    			$('[group=zhj]').hide();
    			$('#heji').attr("colSpan","7");
    			
    		}else if(type == "6"){
    		
    			$('[group*=]').show();
    			$('[group=ys]').hide();
    			$('[group=qj]').hide();
    			$('[group=zj]').hide();
    			$('[group=zx]').hide();
    			$('[group=ql]').hide();
    			$('[group=xq]').hide();
    			$('[group=zhj]').hide();
    			$('#heji').attr("colSpan","5");
    			
    		}else if(type == "7"){
    		
    			$('[group*=]').show();
    			$('[group=ys]').hide();
    			$('[group=qj]').hide();
    			$('[group=zj]').hide();
    			$('[group=zx]').hide();
    			$('[group=ql]').hide();
    			$('[group=xq]').hide();
    			$('[group=zhj]').hide();
    			$('#heji').attr("colSpan","5");
    			
    		}
    		
    		$('#div_goodslist').attr("style","display:");
    	}
    } 
    
</script>
<title>采购收货管理</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="cstpgoodscategory" id="cstpgoodscategory" value="${fn:substring(inventoryEntryList[0].cstiebarcode,0,1) }"> 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                
                      
                    
                    <c:if test="${statusPo.cshastatusapplybillid != null}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__1 onclick="JavaScript:window.location.href='allocationApplyDetails.action?hid=${statusPo.cshastatusapplybillid}';"                    
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">调拨申请单详细</TD>
                        <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                    <c:if test="${statusPo.cshastatusorderid != null}">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initProcurementOrdersView.action?hid=${statusPo.cshastatusorderid}'"
                      UNSELECTABLE="on">采购订单详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
					</c:if>
					<TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">采购收货单详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD> 
                    <c:if test="${statusPo.cshastatusbillid != null}">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='allocationDetails.action?hid=${statusPo.cshastatusbillid}'"
                      UNSELECTABLE="on">商品调拨单详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
					</c:if>
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
                          <TD width="10%" class="table_body" height="30">单据编号</TD>
                          <TD width="40%" class="table_none">&nbsp;${inventoryPo.cstibillid}</TD>
                          <TD width="10%" class="table_body" height="30">订单单号</TD>
                          <TD width="40%" class="table_none">&nbsp;${inventoryPo.cstisourcebillid}</TD>
                        </TR>
                        <TR>  
                          <TD width="10%" class="table_body" height="30">商品类型</TD>
                          <TD width="40%" class="table_none">&nbsp;${inventoryPo.cstigoodscategoryname }</TD>    
                          <TD width="10%" class="table_body">制造商</TD>
						  <TD width="40%" class="table_none">&nbsp;${inventoryPo.cstisuppliername}</TD>                       
						</TR>
						<TR>
						  <TD class="table_body" height="30">制单人</TD>
                          <TD class="table_none" >&nbsp;${inventoryPo.csticreatepersonname}</TD>                  
						  <TD width="10%" class="table_body" height="30">制单日期</TD>
                          <TD width="40%" class="table_none">&nbsp;${fn:substring(inventoryPo.cstibilldate,0,10)}</TD> 
						  
                          
                          
                        </TR>
                        <TR>
                          
                          <TD class="table_body" height="30">审核人</TD>
                          <TD class="table_none">&nbsp;${inventoryPo.cstiauditpersonname}
                          </TD>
                          <TD class="table_body" height="30">审核日期</TD>
                          <TD class="table_none">&nbsp;${fn:substring(inventoryPo.cstiauditdate,0,10)}
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="30">收入仓位</TD>
                          <TD class="table_none">&nbsp;${inventoryPo.cstiinstockname}</TD>
                          <TD class="table_body" height="30">运单号</TD>
                          <TD class="table_none" >&nbsp;${inventoryPo.deliveryID }</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="30">备注</TD>
                          <TD class="table_none" colSpan=3><label>
                          ${inventoryPo.cstiremark}&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
						  <input id="addGodos" icon='icon-edit' type='button' value="打印条码"  onClick="javascript:batPrintGoodsBarCode();">
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
                         <TH width="5%" height="30" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                    
                          <TH width="14%" scope=col>商品代码</TH>
                         
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>型号</TH>
                          <TH width="4%" scope=col group=ys>颜色</TH>
                          <TH width="4%" scope=col group=qj>球镜</TH>
                          <TH width="4%" scope=col group=zj>柱镜</TH>
                          <TH width="4%" scope=col group=zx>轴向</TH>
                          <TH width="4%" scope=col group=ql>曲率</TH>
                          <TH width="4%" scope=col group=zhj>直径</TH> 
                          <TH width="8%" scope=col group=xq>效期</TH>
                          <TH width="5%" scope=col group=xq>批号</TH>
                          <TH width="8%" scope=col>商品条码</TH>
                          <TH width="5%" scope=col>数量</TH>                           
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="30" id="heji" colSpan=11 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <TR id="rowrow" class="row">
                        <TD height="28"><input id="chk" type="checkbox" value="${cstiegoodsid}" ></TD>
                        <TD height="28">${cstiegoodsid}</TD>
                       
                        <TD >${cstiegoodsname}</TD>
                        <TD>${cstiespec}</TD>
                        <TD group=ys>${cstiecolor}</TD>                        
                        <TD group=qj>${cstiesph}</TD>
                        <TD group=zj>${cstiecyl}</TD>
                        <TD group=zx>${cstieaxis}</TD>
                        <TD group=ql>${cstiecurvature1}</TD>
                        <TD group=zhj>${cstiedia}</TD>
                        <TD group=xq>${cstieguaranteeperiod}</TD>
						<TD group=xq>${cstiebatch}</TD>
                        <TD>${cstiebarcode}<input type="hidden" name="goodsInfoTempPo.pcbarcode" value="${cstiebarcode}"/></TD>
                        <TD>${cstiegoodsquantity}<input type="hidden" name="goodsInfoTempPo.goodsquantity" value="${cstiegoodsquantity}"/></TD>                                                                        
                        </TR>
                        </s:iterator>
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