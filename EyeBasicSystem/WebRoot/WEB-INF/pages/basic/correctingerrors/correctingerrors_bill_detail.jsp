<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>系统设置</title>
</head>
<script>	

	function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("sxhsumnum");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		if(document.getElementById("goodsquantityTotal")!=null){
			document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
		}
	}


	function amount2(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("sxhsumnum2");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		if(document.getElementById("goodsquantity2Total")!=null){
			document.getElementById("goodsquantity2Total").innerText=goodsquantityTotal;
		}
	}
	
	$(document).ready(function() { 
		amount();
		amount2();
	});

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
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="bgiwarehouseid" value="${requestScope.bgiwarehouseid}">
<input type="hidden" name="bgigoodsid" value="${requestScope.bgigoodsid}">

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
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
				     <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </table>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                      
                          <TH width="12%" height="26" scope=col>商品代码</TH>
                          <TH width="12%" height="26" scope=col>商品条码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH width="13%" scope=col>变更单据</TH>
                          <TH width="10%" scope=col>变更时间</TH>
                          <TH width="10%" scope=col>仓位</TH>
                          <TH width="9%" scope=col>商品明细数量</TH>
                          <TH width="9%" scope=col>库存变更数量</TH>
						</TR>
						<TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantity2Total">0</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>  
						<s:iterator value="inventoryEntryList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">${cstiegoodsid}</TD>
                          <TD>${cstiebarcode}</TD>
                          <TD>${cstiegoodsname}</TD>
                          <TD>
                          <c:choose>
	                    	<c:when test="${cstiebillid == 'import'}">
	                    		初始化库存
	                    	</c:when>
	                    	<c:otherwise>
	                    		${cstiebillid}
	                    	</c:otherwise>
                          </c:choose>
                          </TD>
                          <TD>${fn:substring(cstiewarehousingdate,0,16)}</TD>
                          <TD>${cstieinstockid}</TD>                          
                          <TD>${cstieprovisionalnum}<input type="hidden" name="sxhsumnum2" value="${cstieprovisionalnum}"/></TD>
                          <TD>${cstiegoodsquantity}<input type="hidden" name="sxhsumnum" value="${cstiegoodsquantity}"/></TD>                            
						</TR>
						</s:iterator>
                      </TBODY>
                    </table>
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