<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盘盈盘亏管理</title>
</head>
<script>
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	procurementReceiptForm.action=link;
	  	procurementReceiptForm.submit();
	}
	function printReport(id){
    	var DataURL = '';

		<c:choose>
           	<c:when test="${overagelossesPo.cstibilltypeid==5}">
		        DataURL="report.action?reportlet=storage_checkSurPlusRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&billId="+id+"&isshow=${permissionPo.keyf}";
			</c:when>
           	<c:when test="${overagelossesPo.cstibilltypeid==6}">
				DataURL="report.action?reportlet=storage_checkSurDefRpt.cpt&logincompanyid="+'${person.personcompanyid}'+"&billId="+id+"&isshow=${permissionPo.keyf}";
			</c:when>
        </c:choose>

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}

		<c:choose>
	       	<c:when test="${overagelossesPo.cstibilltypeid==5}">
	       		document.getElementById('popupTitle').innerHTML="【盘盈单】";
			</c:when>
	       	<c:when test="${overagelossesPo.cstibilltypeid==6}">
	       		document.getElementById('popupTitle').innerHTML="【盘亏单】";
			</c:when>
        </c:choose>
       
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
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD align="right" colspan="3">
            <s:action name="getFittingTemplateTypeInfo" executeResult="true">
	            <s:param name="actionTypeID">18</s:param>
	            <s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
	            <s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&billId=${overagelossesPo.cstibillid}&isshow=${permissionPo.keyf}</s:param>
	            <s:param name="actionReportingServiceRequestString"></s:param>
				<c:choose>
			       	<c:when test="${overagelossesPo.cstibilltypeid==5}">
			       		<s:param name="actionReportTitle">盘盈单打印</s:param>
					</c:when>
			       	<c:when test="${overagelossesPo.cstibilltypeid==6}">
			       		<s:param name="actionReportTitle">盘亏单打印</s:param>
					</c:when>
		        </c:choose>	            
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
                    <TABLE class="privateBorder" cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD class="table_none" width="23%">${overagelossesPo.cstibillid}</TD>
                          <TD width="9%" class="table_body">盘点单号</TD>
                          <TD class="table_none" width="23%">${overagelossesPo.cstisourcebillid }&nbsp;
						  </TD>
						     <td width="9%" class="table_body" height="26">单据类型</td>
						     <td class="table_none" width="23%">&nbsp;
						    <c:choose>
                          	<c:when test="${overagelossesPo.cstibilltypeid==5}">盘盈</c:when>
                          	<c:when test="${overagelossesPo.cstibilltypeid==6}">盘亏</c:when>
                          	</c:choose>
						  </td>                     
						</TR>
						<TR>
							<TD class="table_body">所属部门</TD>
						    <TD class="table_none">${overagelossesPo.cstidepartmentname}</TD>
                          <c:choose>
                          	<c:when test="${overagelossesPo.cstibilltypeid==5}">
                          	<TD class="table_body" height="26">收入仓位</TD>
                          	<TD class="table_none">${overagelossesPo.cstiinstockname}</TD>
                          	</c:when>
                          	<c:when test="${overagelossesPo.cstibilltypeid==6}">
                          	<TD class="table_body" height="26">发出仓位</TD>
                          	<TD class="table_none">${overagelossesPo.cstioutstockname}</TD>
                          	</c:when>
                          </c:choose>
                            <TD class="table_body">盘点类型</TD>&nbsp;
						    <TD class="table_none">&nbsp;
     	                	<c:choose>
     	                		<c:when test="${overagelossesPo.cstigoodscategoryname eq '' || overagelossesPo.cstigoodscategoryname eq null}">
     	                		不限定商品类别
								</c:when>
								<c:otherwise>
								${overagelossesPo.cstigoodscategoryname}
								</c:otherwise>
							</c:choose>						    
						    </TD>
                        </TR>
                        <TR>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${overagelossesPo.csticreatepersonname}</TD>
                          <TD width="9%" class="table_body" height="26">单据日期</TD>
                          <TD class="table_none" colspan="3">${fn:substring(overagelossesPo.cstibilldate,0,16)}</TD> 
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none">
                           ${overagelossesPo.cstiauditpersonname}&nbsp;
                          </TD>
                          <TD width="9%" class="table_body" height="26">审核日期</TD>
                          <TD class="table_none" colspan="3">${fn:substring(overagelossesPo.cstiauditdate,0,16)}</TD> 
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          ${overagelossesPo.cstiremark}&nbsp;
                          </label></TD>
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
                    <c:if test="${not empty(inventoryEntryList)}">
                    <c:set value="0" var="quantity" scope="page" />
                    <c:set value="0" var="amount" scope="page" />

					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                     
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH width="6%" scope=col>单位</TH>                          
                          <TH width="7%" scope=col>数量</TH>
                      <c:if test="${permissionPo.keyf==1 }">	          
                          <TH width="7%" scope=col>单位成本</TH>
                          <TH width="7%" scope=col>成本合计</TH>
                     </c:if>     
                        </TR>
                        <s:iterator value="inventoryEntryList" status="idx">
                        <c:choose>
                          	<c:when test="${goodsID==cstiegoodsid}">
	                    		<TR id="rowrow" class="row" style="background-color: red">
	                    	</c:when>
	                    	<c:otherwise>
	                    		<TR id="rowrow" class="row">
	                    	</c:otherwise>
                          </c:choose> 
                        <TD height="26">${cstiegoodsid}</TD>
                        <TD>${cstiegoodsname}</TD>
                        <TD>${cstiespec}</TD>
                        <TD>${cstieunitname}</TD> 
						<TD>${cstiegoodsquantity}<c:set value="${quantity +  cstiegoodsquantity}" var="quantity" scope="page" /></TD>     
					<c:if test="${permissionPo.keyf==1 }">	                 
                        <TD>${cstienottaxrate}</TD>
                        <TD>${cstienottaxrateamount}<c:set value="${amount +  cstienottaxrateamount}" var="amount" scope="page" /></TD>
                    </c:if>
                        </TR>
                        </s:iterator>
                        <TR class=table_title align=middle>
                          <TH height="26" width="10%" scope=col></TH>
                          <TH width="30%" scope=col></TH>
						  <TH width="8%"></TH>
                          <TH width="8%">合计:</TH>
                          <TH width="5%" scope=col>${quantity }</TH>
                   <c:if test="${permissionPo.keyf==1 }">	             
                          <TH width="5%" scope=col>&nbsp;</TH>
						  <TH width="5%" scope=col><fmt:formatNumber value="${amount }" pattern="0.00"/></TH>
				   </c:if>		  
                        </TR>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
					<div id="dividePage" align="center">        
						<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
					</div>
					<!-- END 分页 -->
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
<%@ include file="/WEB-INF/inc/message.jsp" %>