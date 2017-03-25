<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>凭证管理</title>
</head>
<script>	
	$(document).ready(function(){
		$('span[id=nottaxrateamount]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});	
		amount();
		$('div[id=taxAmountTotal]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});	
		$('div[id=costPriceAmountTotal]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});	
		$('div[id=notTaxRateAmountTotal]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
		});	
	})
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
    	
	function amount(){
		var total=0;
		//数量
		$('span[id=goodsquantity]').each(function(){
			total = accAdd(total,$(this).text());
		});
		$('div[id=goodsquantityTotal]').text(total);
		total = 0;
		//核销数量
		$('span[id=checkgoodsquantity]').each(function(){
			total = accAdd(total,$(this).text());
		});
		$('div[id=checkgoodsquantityTotal]').text(total);
		total = 0;
		//暂估数量
		$('span[id=provisionalnum]').each(function(){
			total = accAdd(total,$(this).text());
		});
		$('div[id=provisionalnumTotal]').text(total);
		total = 0;
		//成本合计
		$('span[id=nottaxrateamount]').each(function(){
			total = accAdd(total,$(this).text());
		});
		$('div[id=notTaxRateAmountTotal]').text(total);
		total = 0;
		//税额合计
		$('span[id=taxamount]').each(function(){
			total = accAdd(total,$(this).text());
		});
		$('div[id=taxAmountTotal]').text(total);
		total = 0;
		//价税合计
		$('span[id=costpriceamount]').each(function(){
			total = accAdd(total,$(this).text());
		});
		$('div[id=costPriceAmountTotal]').text(total);
		total = 0;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="brandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD class="table_body" width="9%" height="26">单据编号</TD>
                          <TD class="table_none" width="24%">
                          	${inventoryPo.cstibillid}
                          </TD>
                          <TD class="table_body" width="9%">单据日期</TD>
                          <TD class="table_none" width="24%">
                          	${fn:substring(inventoryPo.cstibilldate,0,10)}
					      </TD>
					      <TD width="9%" class="table_body">单据类型</TD>
						  <TD width="24%" class="table_none">冲回</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">制造商</TD>
                          <TD class="table_none">${inventoryPo.cstisuppliername}</TD>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none">${inventoryPo.csticreateperson}</TD>
						  <TD class="table_body">审核人</TD>
                          <TD class="table_none">${inventoryPo.cstiauditperson}</TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body" >备注</TD>
                          <TD class="table_none" colspan="5">
                          	${inventoryPo.cstiremark}
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<c:if test="${not empty(proofInEntryList)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="14%" height="26" scope=col>单据编号</TH>
                          <TH width="16%" scope=col>商品代码</TH>
                          <TH width="16%" scope=col>商品名称</TH>
                          <!--<TH width="7%" scope=col>型号</TH>  -->
                          <TH width="5%" scope=col>球镜</TH>
						  <th width="5%" scope=col>柱镜</th>
                          <TH width="5%" scope=col>颜色</TH>
						  <TH width="5%" scope=col>数量</TH>
						  <TH width="6%" scope=col>核销数量</TH>
						  <TH width="6%" scope=col>暂估数量</TH>
						  <TH width="8%" scope=col>成本合计</TH>
						  <TH width="8%" scope=col>税额合计</TH>
						  <TH width="8%" scope=col>价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26">合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>                          
                          <TD><div id="goodsquantityTotal"></div></TD>
                          <TD><div id="checkgoodsquantityTotal"></div></TD>
                          <TD><div id="provisionalnumTotal"></div></TD>                   
                          <TD><div id="notTaxRateAmountTotal"></div></TD>
                          <TD><div id="taxAmountTotal"></div></TD>
                          <TD><div id="costPriceAmountTotal"></div></TD>
                        </TR>
                        <s:iterator value="proofInEntryList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${cstiebillid}</TD>
                          <TD>${cstiegoodsid }</TD>
                          <TD>${cstiegoodsname }</TD>
                          <!-- <TD>${cstiespec }</TD> -->
                          <TD>${cstiesph }</TD>
						  <td>${cstiecyl }</td>
                          <TD>${cstiecolor }</TD>
                          <TD><span id="goodsquantity">${cstiegoodsquantity }</span></TD>
                          <TD><span id="checkgoodsquantity">${cstiecheckgoodsquantity }</span></TD>
                          <TD><span id="provisionalnum">${cstieprovisionalnum }</span></TD>
                          <TD><span id="nottaxrateamount">${cstienottaxrateamount }</span></TD>
                          <TD><span id="taxamount">${cstietaxamount }</span></TD>
                          <TD><span id="costpriceamount">${cstiecostpriceamount }</span></TD>                       
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    </c:if>
                  </DIV>
                </DIV>                  
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
  
	
    </form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
