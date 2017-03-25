<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在途查询</title>
</head>
<script>	
	
	function showMailDetails(salesID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("toMailDetails.action?hid="+salesID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("toMailDetails.action?hid="+salesID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【邮寄信息】";
	}

	$(document).ready(function() {        
        var title=0;
        $('td[id=integralCount1]').each(function(){
            if ($.trim($(this).text())){
            	title = accAdd(title,$(this).text());
            }        	
        });
        $('#ssesbintegral').text(title);
    }); 
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inTransitForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="customerID" name="customerID" value="${requestScope.smecicustomerid }">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID }">
<input type="hidden" id="salesid" name="salesid" value="${requestScope.salesid }">

<c:set value="0" var="integralCount" /> <!-- 积分总数 -->
<c:set value="0" var="rowCount" /> <!-- 行数 -->

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
                 
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
		             <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="8%" height="26" class="table_body">配镜单号</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbsalesid }&nbsp;
                          </TD>
						   <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbpersonName }&nbsp;
						  </TD>
						  <TD width="8%" height="26" class="table_body">累计积分</TD>
                          <TD class="table_none">
                          	${salesBasicPo.ssesbjfamount }
						  </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">累计时间</TD>
                          <TD class="table_none" colspan="5">${date}&nbsp;
                          </TD>						  
                        </TR>
                    </TABLE>
               
				 <c:if test="${not empty(goodsInfoList) && flag!='6' }"> 
				      <BR/>
						<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="26" scope=col>商品代码</TH>
						  <TH width="18%" scope=col>商品名称 </TH>						
						  <TH width="9%" scope=col>单价</TH>
						  <TH width="5%" scope=col>数量</TH>
						  <TH width="9%" scope=col>原价合计</TH>
						  <TH width="5%" scope=col>折扣率</TH>
						  <TH width="9%" scope=col>折扣金额</TH>
						  <TH width="8%" scope=col>抹零金额</TH>
						  <TH width="8%" scope=col>应收金额</TH>
						  <TH width="9%" scope=col>商品描述</TH>
						  </TR>
						  
						<s:iterator value="goodsInfoList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${ssesdsalesitemid}</TD>
                          <TD>${ssesdsalesitemname}</TD>
                          <TD>${ssesdsprice}</TD>
                          <TD>${ssesdnumber}</TD>
                          <TD>${ssesdpricesum}</TD>
                          <TD>${ssesddiscountrate}</TD>
                          <TD>${ssesddiscountnum}</TD>
                          <TD>${ssesdrenum}</TD>
                          <TD>${ssesdsalesvalue}</TD>
                          <TD>${ssesdgooddescribe}</TD>
						</TR>
						</s:iterator>					  
                      </TBODY>
                    </TABLE>
                    </c:if>
            <c:if test="${not empty(salesLogList) && (flag=='3' || flag=='6' || flag=='5') }">
                    <br/>
					<table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH height="26" width="10%" scope=col>编号</TH>
						  <TH width="15%" scope=col>收银人</TH>
						  <TH width="20%" scope=col>收银日期</TH>						  
						  <TH width="15%" scope=col>缴费金额(积分)</TH>
						  <TH width="20%" scope=col>结款类型</TH>
						  <TH width="20%" scope=col>付款方式</TH>						  
						</TR>
						
						<s:iterator value="salesLogList" status="idx">
				<c:if test="${(sseslconsumptionid=='2' && (flag=='3' || flag=='6' ) && (sseslpaymenttype=='1' || sseslpaymenttype=='2')) || (flag=='5' && sseslpaymenttype=='3' && sseslconsumptionid=='2') }">	
				        <c:set value="${rowCount + 1}" var="rowCount" />	
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${rowCount}</TD>                          
                          <TD>${sseslperson}</TD>
                          <TD>${ssesldatetime}</TD>
                          <TD id="integralCount1">-${sseslprice}                          
                          </TD>
                          <TD>
							<c:choose>
								<c:when test="${sseslpaymenttype=='1'}">
									全款
								</c:when>
								<c:when test="${sseslpaymenttype=='2'}">
									订金
								</c:when>
								<c:when test="${sseslpaymenttype=='3'}">
									补款
								</c:when>
								<c:when test="${sseslpaymenttype=='4'}">
									退款
								</c:when>								
							</c:choose>
						  </TD>
                          <TD>
							<c:choose>
								<c:when test="${sseslconsumptionid=='1'}">
									现金
								</c:when>
								<c:when test="${sseslconsumptionid=='2'}">
									积分
								</c:when>
								<c:when test="${sseslconsumptionid=='3'}">
									银行卡
								</c:when>
								<c:when test="${sseslconsumptionid=='4'}">
									储值卡
								</c:when>		
								<c:when test="${sseslconsumptionid=='5'}">
									找零
								</c:when>															
							</c:choose>
						  </TD>
						</TR>
					  </c:if>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>