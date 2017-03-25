<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它出库结算</title>
</head>
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<script>
	
	function save(){
	if(checkForm(document.all.returnMerchandiseSettlementForm)){ 
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
			        if (accAdd(parseFloat(nottaxrateamount[i].value).toFixed(2),parseFloat(taxamount[i].value).toFixed(2)) != Number(costpriceamount[i].value)){
			            alert("成本合计、税额合计或价税合计填写有误!");
			            nottaxrateamount[i].focus();
			            return;
			        }
			    }
			}
			
		$("img").removeAttr("onclick");
		returnMerchandiseSettlementForm.action = "updateReturnMerchandiseSettlements.action";
		returnMerchandiseSettlementForm.submit();
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
		var goodsquantityStateArray =new Array(true,"remove",false,"totalCount");
		var nottaxrateStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var nottaxrateamountStateArray =new Array(true,"remove",false,"totalCount");
		var taxrateStateArray =new Array(true,"remove",false,"totalCount");
		var costpriceStateArray =new Array(false,"autoCountOnlyOne",false,"totalCount");
		var costpriceamountStateArray =new Array(true,"remove",false,"totalCount");
		var taxamountStateArray =new Array(true,"remove",false,"totalCount");
		var stateArray=new Array(goodsquantityStateArray,nottaxrateStateArray,nottaxrateamountStateArray,taxrateStateArray,costpriceStateArray,costpriceamountStateArray,taxamountStateArray);
		return stateArray;
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
<form name="returnMerchandiseSettlementForm" method="post" action="">
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
			               <TD class="table_none" width="24%">&nbsp;${inventoryPo.cstibillid}<input type="hidden" id="cstibillid" name="inventoryPo.cstibillid" value="${inventoryPo.cstibillid}"></TD>
			               <TD width="9%" height="26" class="table_body">订单编号</TD>
			               <TD width="24%" class="table_none">
			               	&nbsp;${inventoryPo.cstisourcebillid}
			               </TD>
						   <TD width="11%" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none">
			               	 &nbsp;${fn:substring(inventoryPo.cstibilldate,0,10)}
			               </TD>
			            <tr>
			               <TD height="26" class="table_body">出库类型</TD>
			               <TD class="table_none">&nbsp;
			               <c:choose>
			               	<c:when test="${inventoryPo.cstibilltypeid=='8'}">
			               		其他出库
			               	</c:when>
			               	<c:otherwise>
			               		未知单据
			               	</c:otherwise>
			               </c:choose></TD>
						   <TD height="26" class="table_body">发出仓位</TD>
			               <TD class="table_none">&nbsp;${inventoryPo.cstioutstockname}</TD>
                       
			               <TD height="26" class="table_body">制单人</TD>
			               <TD class="table_none">&nbsp;${inventoryPo.csticreatepersonname}</TD>
			            </TR>                        
                        <TR>
			               <TD height="26" class="table_body">入库审核人</TD>
			               <TD class="table_none">&nbsp;${inventoryPo.cstiauditpersonname}</TD>
                      
			               <TD height="26" class="table_body">财务结算审核人</TD>
			               <TD class="table_none">&nbsp;${person.personName}<input class="text_input100" type="hidden" name="inventoryPo.cstifinanceauditperson" value="${person.id}"></TD>
			               <TD height="26" class="table_body">财务结算审核日期</TD>
			               <TD class="table_none">&nbsp;<jsp:useBean id="now" class="java.util.Date" />
                          <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />
                          <input name="inventoryPo.cstifinanceauditdate" type="hidden" value="<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />"/></TD>
			            </TR>
                         <TR>
                          <TD class="table_body" height="26">备注</TD>
                          <TD class="table_none" colSpan=5 height="26">&nbsp;${inventoryPo.cstiremark}</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <td width="100%" align="left">
	                          <input name="radiobutton" id="autoCount" type="radio" value="autoCount" checked="checked" onClick="changeRadioType(this,getInputState())"/>自动计算
	  				  		  <input type="radio" id="notAutoCount" name="radiobutton" value="notAutoCount" onClick="changeRadioType(this,getInputState())"/>手动计算
	  				  	  </td>
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
                          <TH scope=col width="15%" height="26">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>
                          <TH scope=col width="10%">型号</TH>                          
 						  <TH scope=col width="5%">数量</TH>	
 						  <TH scope=col width="10%">单位成本</TH>
						  <TH scope=col width="10%">成本合计</TH>
                          <TH scope=col width="5%">税率</TH>
						  <TH scope=col width="10%">含税单价</TH>
						    <TH scope=col width="10%">税额合计</TH>	
                          <TH scope=col width="10%">价税合计</TH>
											  
                        </TR>
                        <tr class=table_title align=middle> 
						  	<th width="40%" height="26"  colSpan=3 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</th>
					    	<th scope=col width="5%" id="goodsquantityTotal">&nbsp;</th>
					    	<th scope=col width="10%">&nbsp;</th>
					    	<th scope=col width="10%" id="nottaxrateamountTotal">&nbsp;</th>
					    	<th scope=col width="5%">&nbsp;</th>
					    	<th scope=col width="10%" >&nbsp;</th>
					    	<th scope=col width="10%" id="taxamountTotal">&nbsp;</th>
					    	<th scope=col width="10%" id="costpriceamountTotal">&nbsp;</th>
					    	
				   		</tr>
				   		<s:iterator value="inventoryEntryList" status="idx">
	                        <TR class="row">
	                        <TD height="26">${cstiegoodsid}
	                        <input type="hidden" name="goodsInfoTempPo.id" value="${cstieid}" />
	                        </TD>
	                        <TD>${cstiegoodsname}</TD>
	                        <TD>${cstiespec}</TD>
	                        <TD>${cstiegoodsquantity}<input type="hidden" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" style="width:100%" value="${cstiegoodsquantity}" name="goodsInfoTempPo.goodsquantity" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写正确的商品数量！'}]"/></TD>                                               
	                        <TD><input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.nottaxrate" value="${cstienottaxrate}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写单位成本！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的单位成本！'}]"/></TD>
	                        <TD><input type="text" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" name="goodsInfoTempPo.nottaxrateamount" value="${cstienottaxrateamount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写成本合计！'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '请填写正确的成本合计！'}]"/></TD>
	                        <TD><input type="text" style="background-color:#ACA899" readOnly="readonly" onchange="remove();" style="width:100%" name="goodsInfoTempPo.taxrate" value="${cstietaxrate}" /></TD>
	                        <TD><input type="text" onchange="autoCountOnlyOne(this);" style="width:100%" name="goodsInfoTempPo.costprice" value="${cstiecostprice}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写含税单价！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请填写正确的含税单价！'}]"/></TD>
	                        <TD><input type="text" readOnly="readonly" onchange="remove();" style="background-color:#ACA899" style="width:100%" name="goodsInfoTempPo.taxamount" value="${cstietaxamount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写税额合计！'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '请填写正确的税额合计！'}]"/></TD> 
	                        <TD><input type="text" style="background-color:#ACA899" style="width:100%" name="goodsInfoTempPo.costpriceamount" value="${cstiecostpriceamount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写价税合计！'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '请填写正确的价税合计！'}]"/></TD>
	                                                                                                   
	                        </TR>
                        </s:iterator>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">
                          		<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</li>
                          	<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstifinanceauditstate" name="inventoryPo.cstifinanceauditstate" value="1">保存并审核
                          	</li>
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
	initAutoCount(getInputState());
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>