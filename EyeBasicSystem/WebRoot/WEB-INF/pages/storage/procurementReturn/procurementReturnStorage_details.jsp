<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script>    
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
	
</script>
<title>商品退货管理</title>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="otherReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD align="right" colspan="3">
             <s:action name="getFittingTemplateTypeInfo" executeResult="true">
				<s:param name="actionTypeID">25</s:param>
           		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
           		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&isshow=0&BillID=${inventoryPo.cstibillid}</s:param>
           		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&BillID=${inventoryPo.cstibillid}</s:param>
           		<s:param name="actionReportTitle">商品退货单打印</s:param>
             </s:action>          
          </TD>
        </TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD width="24%" class="table_none">${inventoryPo.cstibillid}</TD>
                          <TD width="9%" class="table_body">入库类型</TD>
                          <TD width="24%" class="table_none">商品退货</TD>
						  <TD width="9%" class="table_body" height="26">单据日期</TD>
                          <TD class="table_none">${fn:substring(inventoryPo.cstibilldate,0,10)}</TD>                          
						</TR>
						<TR>
						  <TD class="table_body">制造商</TD>
						  <TD class="table_none">${inventoryPo.cstisuppliername}</TD>
                          <TD class="table_body" height="26">发出仓位</TD>
                          <TD class="table_none">${inventoryPo.cstioutstockname}</TD>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${inventoryPo.csticreatepersonname}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none">
                           ${inventoryPo.cstiauditpersonname}&nbsp;
                          </TD>
                          <TD class="table_body" height="26">运单号</TD>
                          <TD class="table_none" colspan="3">
                           ${inventoryPo.deliveryID}&nbsp;
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="62">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          ${inventoryPo.cstiremark}&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
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
                          <TH width="20%" height="26" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>型号</TH>
                          <TH width="15%" scope=col>计量单位</TH>
                          <TH width="15%" scope=col>数量</TH>    
                         <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TH width="15%" scope=col>商品条码</TH>  
                          </c:if>                                             
                        </TR>
                        <TR class=table_title align=middle> 
                        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  	<TH width="40%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
						  	<TH scope=col width="5%"></TH>
						  	</c:if>
						  	<c:if test="${systemParameterPo.fspbarcodetype==3}"> 
						  	<TH width="40%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
						  	</c:if>
					    	
				   		</TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <TR id="rowrow" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${systemParameterPo.fspsalestype eq '0' && cstieoutstorageflag eq '0' ? 'style="color: red"' : '' }>  
                        <TD height="26">${cstiegoodsid}</TD>
                        <TD>${cstiegoodsname}</TD>
                        <TD>${cstiespec}</TD>
                        <TD>${cstieunitname}</TD>
                       <td>
                        ${cstiegoodsquantity}
                       <input type="hidden" value="${cstiegoodsquantity}" name="goodsInfoTempPo.goodsquantity"  onblur="amount();" value="${cstiegoodsquantity}"/>
                       </td> 
                         <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                       <TD>
                        <input id="selectGbc" name="goodsInfoTempPo.goodsbarcode" multiple="multiple" value="${cstiebarcode }" class="text_input200 gbc" />
					   </TD>	
					   </c:if>				                        

                      
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