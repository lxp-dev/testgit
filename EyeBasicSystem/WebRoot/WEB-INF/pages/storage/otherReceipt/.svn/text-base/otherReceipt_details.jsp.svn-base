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
  function batPrintGoodsBarCode(){
		if(confirm("条码打印确认！")){
			var ids = document.getElementsByName("chk");
			if(ids !== undefined){
				var barCodes = document.getElementsByName("goodsInfoTempPo.pcbarcode");
				var goodsQuantitys = document.getElementsByName("goodsInfoTempPo.goodsquantity");
				var suffix;
				var flag = false;
				for(var i=0 ; i< ids.length; i++){
					if(ids[i].checked == true){
						//alert(ids[i]);
						//suffix = getObjArrSuffix("ids",ids[i]);
						//alert(suffix);
						//printBarCode(barCodes[rowNumber-1].value,goodsQuantitys[rowNumber-1].value);
						//printBarCode(barCodes[i-1].value,goodsQuantitys[i-1].value);
						//alert(barCodes[i].value);
						//setTimeout(alert(barCodes[i].value),500);
						//alert(barCodes[i].value);
						//alert(goodsQuantitys[i].value);
						try{
							printBarCode(barCodes[i].value,goodsQuantitys[i].value);
						} catch(e) {
							alert("打印失败!请检查条码打印机是否正确连接!");
							return;
						}
						
						flag = true;
					}
				}
				if(flag == false){
					alert("请钩选要打印的商品条码！");
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
		amount();
	};
	
	  // function printReport(id){
    	//var url = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	
	//	url+="storage/otherInStock/otherInStockRpt&BillID="+id+"&rs:Command=Render";
		
		//window.open (url, '查询窗口', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
    //}
</script>
<title>其他入库</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="otherReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 


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
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD width="24%" class="table_none">${inventoryPo.cstibillid}</TD>
                          <TD width="9%" class="table_body">入库类型</TD>
                          <TD width="24%" class="table_none">其他入库</TD>
						  <TD width="9%" class="table_body" height="26">单据日期</TD>
                          <TD class="table_none">${fn:substring(inventoryPo.cstibilldate,0,10)}</TD>                          
						</TR>
						<TR>
						  <TD class="table_body">制造商</TD>
						  <TD class="table_none">${inventoryPo.cstisuppliername}</TD>
                          <TD class="table_body" height="26">收入仓位</TD>
                          <TD class="table_none">${inventoryPo.cstiinstockname}</TD>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${inventoryPo.csticreatepersonname}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none" colspan="5">
                           ${inventoryPo.cstiauditpersonname}&nbsp;
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          ${inventoryPo.cstiremark}&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						   <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();"></c:if>
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
                        <TH width="6%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                     
                          <TH width="20%" height="26" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>型号</TH>
                          <TH width="10%" scope=col>计量单位</TH>
                          <TH width="10%" scope=col id=rksj>入库时间 </TH>
                           <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH width="15%" scope=col> 打印条码</TH>  </c:if>
                          <TH width="10%" scope=col>数量</TH>                            
                        </TR>
                        <TR class=table_title align=middle> 
                         <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
					  	<TH width="40%" height="26"  colSpan=7 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					  	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
					  	</c:if>
					      <c:if test="${systemParameterPo.fspbarcodetype==3}"> 
					  	<TH width="40%" height="26"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					  	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
					  	</c:if>	
				   		</TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <TR class="row" id="rowrow">
                        <TD height="26"><input id="chk" type="checkbox" value="${cstiegoodsid}" ></TD>
                        <TD height="26">${cstiegoodsid}</TD>
                        <TD>${cstiegoodsname}</TD>
                        <TD>${cstiespec}</TD>
                        <TD>${cstieunitname}</TD>
                        <Td id=rksj>${fn:substring(inventoryPo.cstibilldate,0,10)}<input type="hidden"  id="bgirksj"  readonly="readonly" name="goodsInfoTempPo.bgirksj"  value="${fn:substring(inventoryPo.cstibilldate,0,10)}" /></Td>
                        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                        <TD>${cstiebarcode}<input type="hidden" name="goodsInfoTempPo.pcbarcode" value="${cstiebarcode}"/></TD>
                        </c:if>
                        <TD>${cstiegoodsquantity}<input type="hidden" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="${cstiegoodsquantity}"/></TD>                                                                        
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