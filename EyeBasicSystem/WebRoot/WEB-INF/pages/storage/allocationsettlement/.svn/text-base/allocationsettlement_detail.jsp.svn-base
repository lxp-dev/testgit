<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品调拨管理</title>
</head>
<script>
   
    $(document).ready(function(){
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
   		var total=0;
		$('input[name=xqs]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#xqsTotal').text(total);

   		total=0;
		$('input[name=dbs]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#dbsTotal').text(total);

   		total=0;
		$('input[name=cbhj]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#cbhjTotal').text(parseFloat(total).toFixed(2));

   		total=0;
		$('input[name=jshj]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#jshjTotal').text(parseFloat(total).toFixed(2));

   		total=0;
		$('input[name=pfhj]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#pfhjTotal').text(parseFloat(total).toFixed(2));

    });

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
             </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff colspan="3">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif ><IMG height=1 
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
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0 class="privateBorder" style='TABLE-LAYOUT: fixed'>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">调拨单号</TD>
                          <TD width="24%" class="table_none">${allocationPo.cshaabillid}&nbsp;</TD>
                          <TD width="9%" class="table_body" height="26">关联单号</TD>
                          <TD width="24%" class="table_none">${allocationPo.cshaabillassociation}&nbsp;</TD>
                          <TD width="9%" class="table_body" height="26">调出部门</TD>
                          <TD class="table_none">${allocationPo.cshaaoutdepartmentname}&nbsp;</TD>	  			       
						</TR>
                        <TR>
                          <TD class="table_body" height="26">调出仓位</TD>
						  <TD class="table_none"> ${allocationPo.cshaaoutstockname}&nbsp;</TD>
                          <TD class="table_body" height="26">调入部门</TD>
						  <TD class="table_none"> ${allocationPo.cshaaindepartmentname}&nbsp;</TD>
                          <TD class="table_body" height="26">调入仓位</TD>
                          <TD class="table_none" >${allocationPo.cshaainstockname}&nbsp;</TD>             
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none" >${allocationPo.cshaacreatepersonname}&nbsp;</TD>
                          <TD class="table_body" height="26">单据日期</TD>
                          <TD class="table_none">${fn:substring(allocationPo.cshaabilldate,0,16)}&nbsp;</TD>	
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none" > ${allocationPo.cshaaauditpersonname}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">审核日期</TD>
                          <TD class="table_none" > ${fn:substring(allocationPo.cshaaauditdate,0,16)}&nbsp;</TD>
                          <TD class="table_body" height="26">收货人</TD>
                          <TD class="table_none">${allocationPo.cshaaconsigneename}&nbsp; </TD>
                          <TD class="table_body">收货日期</TD>
                          <TD class="table_none">${fn:substring(allocationPo.cshaaconsigndate,0,16)}&nbsp;</TD>
                        </TR>
                        
                        <TR>
                          <TD class="table_body" height="26">结算人</TD>
                          <TD class="table_none">${allocationPo.cshaafinanceauditpersonname}&nbsp; </TD>
                          <TD class="table_body">结算日期</TD>
                          <TD class="table_none" colspan="3">${fn:substring(allocationPo.cshaafinanceauditdate,0,16)}&nbsp;</TD>
                        </TR>
                        
                          <c:if test="${systemParameterPo.fspisallocationcategory eq '1'}">
                          <TR>
                          <TD width="9%" height="26" class="table_body">商品类别</TD>
                          <TD width="24%" height="26" class="table_none" colspan="5">
                              ${allocationPo.goodscategoryname }
                          </TD>
                          </TR>
                          </c:if>	
                        <TR>
                          <TD class="table_body" width="9%">备注</TD>
                          <TD class="table_none" colSpan=5 style='word-WRAP: break-word'><label>
                             ${allocationPo.cshaaremark}&nbsp;
                             </label>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>

					<table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
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
                          <TH width="10%" scope=col height="28">商品代码</TH>
                          <TH width="18%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH width="5%" scope=col>需求数</TH>
                          <TH width="5%" scope=col>调拨数</TH> 
                          
                          <c:if test="${allocationPo.cshaaamounttype eq '1'}">
                              <TH width="8%" scope=col>含税单价</TH>
                              <TH width="8%" scope=col>价税合计</TH> 
                          </c:if>
                          <c:if test="${allocationPo.cshaaamounttype eq '2'}">
                              <TH width="8%" scope=col>单位成本</TH>
                              <TH width="8%" scope=col>成本合计</TH> 
                          </c:if>
                          <c:if test="${allocationPo.cshaaamounttype eq '3'}">
                              <TH width="8%" scope=col>批发单价</TH>
                              <TH width="8%" scope=col>批发合计</TH> 
                          </c:if>
                          
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">  
                              <TH width="20%" scope=col>商品条码</TH>
                          </c:if>     
                                        
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH height="26" colSpan=3 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col id="xqsTotal">0</TH>
					    	<TH scope=col id="dbsTotal">0</TH>
					   
					   <c:if test="${allocationPo.cshaaamounttype eq '2'}">    	
					    	<TH scope=col></TH>
					    	<TH scope=col id="cbhjTotal">0</TH>
					   </c:if> 	
					   
					   <c:if test="${allocationPo.cshaaamounttype eq '1'}">   	
					    	<TH scope=col></TH>
					    	<TH scope=col id="jshjTotal">0</TH>
					   </c:if>
					    	
					   <c:if test="${allocationPo.cshaaamounttype eq '3'}">     	
					    	<TH scope=col></TH>
					    	<TH scope=col id="pfhjTotal">0</TH>
					   </c:if> 	
					   
					    	<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
					    	  <TH scope=col>&nbsp;</TH>
					    	</c:if>
				   		</TR>
                        <s:iterator value="allocationEntryList" status="idx">
                        <TR id="rowrow" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">  
                        <TD height="26">${cshaaegoodsid}</TD>
                        <TD>${cshaaegoodsname}</TD>
                        <TD>${cshaaespec}</TD>
                        <TD>${cshaaerequirementquantity}<input type="hidden" name="xqs" value="${cshaaerequirementquantity}" /></TD>
                        <TD>${cshaaeallocationquantity}<input type="hidden" name="dbs" value="${cshaaeallocationquantity}" /></TD>                      
                    
                    <c:if test="${allocationPo.cshaaamounttype eq '2'}">   
                        <TD>${cshaaenottaxrate}</TD>
                        <TD>${cshaaenottaxrateamount}<input type="hidden" name="cbhj" value="${cshaaenottaxrateamount}" /></TD>
                        </c:if>
                        
                    <c:if test="${allocationPo.cshaaamounttype eq '1'}">    
                        <TD>${cshaaecostprice}</TD>
                        <TD>${cshaaecostpriceamount}<input type="hidden" name="jshj" value="${cshaaecostpriceamount}" /></TD>
                    </c:if>
                    
                    <c:if test="${allocationPo.cshaaamounttype eq '3'}">    
                        <TD>${cshaaewholesaleprice}</TD>                        
                        <TD>${cshaaewholesalepriceamount}<input type="hidden" name="pfhj" value="${cshaaewholesalepriceamount}" /></TD>
                    </c:if>  
                       
                        <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                          <TD>${cshaaegoodsBarCode }
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
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="3"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR>
                    <tr><td></td></tr>    
                    <TR>         
                    <TD class=menubar_readme_text vAlign=bottom>
          </TD></TR>
            </TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>