<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/orderItem.js" ></script>
<script type="text/javascript" src="${ctx}/js/priceCount.js" ></script>
<title>不合格品单管理</title>
</head>
<Script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
 	
 </Script>   
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="nonconformingForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD colspan="3" align="right">
               	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
					<s:param name="actionTypeID">9</s:param>
               		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
               		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&billID=${nonconformingPo.cshanbillid}</s:param>
               		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&billID=${nonconformingPo.cshanbillid}</s:param>
               		<s:param name="actionReportTitle">不合格品单</s:param>
               	</s:action>          
		  </TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
			               <TD class="table_none" width="24%">${nonconformingPo.cshanbillid}&nbsp;</TD>
			               <TD width="9%" height="26" class="table_body">单据日期</TD>
			               <TD width="24%" class="table_none">${fn:substring(nonconformingPo.cshancreatedate,0,16)}&nbsp;</TD>
			               <TD width="9%" height="26" class="table_body">申报部门</TD>
			               <TD class="table_none">${nonconformingPo.cshandepartmentname}&nbsp;</TD>
                        </TR>                        
                         <TR>
                           <!-- <TD height="26" class="table_body">关联单号</TD>
			               <TD class="table_none">${nonconformingPo.cshanlinkbillID}&nbsp;</TD> -->
			               <td height="26" class="table_body">申报仓位</td>
                           <td class="table_none">${nonconformingPo.cshanoutstockname }</td>
			               <TD height="26" class="table_body">责任人</TD>
			               <TD class="table_none">${nonconformingPo.cshanresponsibilityperson}&nbsp;</TD>
			               <TD height="26" class="table_body">审核人</TD>
			               <TD class="table_none">${nonconformingPo.cshanauditpersonname}&nbsp;</TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">审核日期</TD>
			               <TD class="table_none">${fn:substring(nonconformingPo.cshanauditdate,0,10)}&nbsp;</TD>
			               <TD height="26" class="table_body">审核状态</TD>
			               <TD class="table_none">
			               	  <c:if test="${nonconformingPo.cshanauditstate==1}">
	                              	已审核
	                          </c:if>
	                          <c:if test="${nonconformingPo.cshanauditstate==0}">
	                             	 未审核
	                          </c:if>
	                           <c:if test="${nonconformingPo.cshanauditstate==2}">
	                             	已处理
	                          </c:if>&nbsp;
			               </TD>
						   <TD height="26" class="table_body">审核日期</TD>
			               <TD class="table_none">${fn:substring(nonconformingPo.cshanauditdate,0,10)}&nbsp;</TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">关联单号</TD>
			               <TD class="table_none" colspan="5">${nonconformingPo.cshanlinkbillID}&nbsp;</TD>
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
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" style='TABLE-LAYOUT: fixed'>
                        <TR class=table_title align=middle>                 
                          <TH scope=col height="26" width="16%">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>				
                          <TH scope=col width="15%" colSpan=2>不合格品原因</TH>                          
 						  <TH scope=col width="20%">备注</TH>
 						  <TH scope=col width="10%">数量</TH>
 						  <TH scope=col width="10%">
 						  		<c:if test="${nonconformingPo.cshanwhichretail == '1' || empty(nonconformingPo.cshanwhichretail)}">
 						  			标准零售价
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='2' }">
									零售价1
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='3' }">
									零售价2
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='4' }">
									零售价3
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='5' }">
									零售价4
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='6' }">
									零售价5
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='7' }">
									零售价6
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='8' }">
									零售价7
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='9' }">
									零售价8
								</c:if>
								<c:if test="${nonconformingPo.cshanwhichretail=='10' }">
									零售价9
								</c:if>
 						  </TH>
 						  	 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
 						   <TH scope=col width="20%">商品条码</TH>
 						   </c:if>
 						     <TH scope=col width="10%">处理方式</TH>		
                        </TR>
                        <c:set var="quantitysum" value="0"></c:set>
                          <s:iterator value="nonconformingEntryList">
							<c:set var="quantitysum" value="${quantitysum + cshanegoodsquantity}"></c:set>
                          </s:iterator>
                        <TR class=table_title align=middle>
						  	<TH height="26" colSpan=5 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col id="goodsquantityTotal">${quantitysum}</TH>
					    	<TH scope=col colSpan=2>&nbsp;</TH>
				   		</TR>                        
                       <s:iterator value="nonconformingEntryList" status="idx">
                        <TR class="row">
                        <TD>${cshanegoodsid}</TD>
                        <TD>${cshanegoodsname}</TD>
                        <TD>${cshanereasons1name}</TD>
                        <TD>${cshanereasons2name}</TD>                        
                        <TD style='word-WRAP: break-word'>
                            <textarea style="border: 0;background:transparent;" readonly="readonly">${cshaneremark}</textarea>                            
                        </TD>
                        <TD>${cshanegoodsquantity}</TD>  
                        <TD>${cshaneretailprice}</TD>  
                         <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
                         <TD>${cshanebarcode}</TD>
                         </c:if>
                         <TD><c:if test="${cshaneconsignmode=='1'}">退回</c:if>
                         <c:if test="${cshaneconsignmode=='0'}">报残</c:if></TD>
                        </TR>
                       </s:iterator>
				   	</TABLE>

				   	<c:if test="${nonconformingPo.cshanlinkbillID!=null}">
				   	<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/jianchajielun.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
				   	<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR class=table_title align=middle>     
                          <TH scope=col width="10%" height="26">左眼(L)/右眼(R)</TH>                
                          <TH scope=col width="12%">球镜</TH>
						  <TH scope=col width="12%">柱镜</TH>
						  <TH scope=col width="12%">轴向</TH>					
                          <TH scope=col width="12%">Add</TH>                          
 						  <TH scope=col width="12%">远用瞳距</TH>	
 						   <TH scope=col width="12%">近用瞳距</TH>	
                        </TR>
                        <TR class="row">
                        	<td height="26">L</td>
                        	<td>${salesBasicPo.ssesbballglassos }</td>
                        	<td>${salesBasicPo.ssesbpostglassos }</td>
                        	<td>${salesBasicPo.ssesbaxesos }</td>
                        	<td>${salesBasicPo.ssesbaddos }</td>
                        	<td>${salesBasicPo.ssesbinterhighos }</td>
                        	<td>${salesBasicPo.ssesbinterdistanceos }</td>
                        </TR>
                        <TR class="row">
                        	<td height="28">R</td>
                        	<td>${salesBasicPo.ssesbballglassod }</td>
                        	<td>${salesBasicPo.ssesbpostglassod }</td>
                        	<td>${salesBasicPo.ssesbaxesod }</td>
                        	<td>${salesBasicPo.ssesbaddod }</td>
                        	<td>${salesBasicPo.ssesbinterhighod }</td>
                        	<td>${salesBasicPo.ssesbinterdistanceod }</td>
                        </TR>
				   	</TABLE>
                  	</c:if> 
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