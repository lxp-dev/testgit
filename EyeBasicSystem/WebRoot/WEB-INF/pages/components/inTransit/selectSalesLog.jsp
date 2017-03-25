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
<title>配镜管理</title>
</head>
<script>	

	function showMailDetails(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("toMailDetails.action?hid="+salesID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("toMailDetails.action?hid="+salesID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【邮寄信息】";		
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inTransitForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="customerID" name="customerID" value="${requestScope.smecicustomerid }">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID }">
<input type="hidden" id="salesid" name="salesid" value="${requestScope.salesid }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
			<TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
					<TD width=3><IMG id=tabImgLeft__1 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectInTransitDetails.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif UNSELECTABLE="on">配镜单信息</TD>
                     <TD width=3><IMG id=tabImgRight__1 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3></TD>
                     <TD width=3><IMG id=tabImgLeft__1 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                     
					<TD class=tab id=tabLabel__1 
					  onclick="JavaScript:window.location.href='initInTransitDetailsSel.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">在途信息</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
					  onclick="JavaScript:window.location.href='selectGoodsOut.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">库存详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    <c:if test="${salesBasicPo.ssesborderstype == 1 ||salesBasicPo.ssesborderstype == 2}">
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectWorkingCheckDetails.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">检验信息</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                    <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">付款记录</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>                         
                         </TR>
                    </TBODY>
                  </TABLE> 
		 </TD>
					</TR></TBODY></TABLE>
			</TD></TR>
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
                             
		                  <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="9%" height="26" class="table_body">配镜单号</TD>
                          <TD width="24%" class="table_none">${salesBasicPo.ssesbsalesid }&nbsp;
                          </TD>
                          <TD width="9%" height="26" class="table_body">配镜门店</TD>
                          <TD width="24%" class="table_none">${salesBasicPo.ssesbshopName }&nbsp;
						  </TD>
                          <TD width="9%" height="26" class="table_body">顾客姓名</TD>
                          <TD class="table_none">${salesBasicPo.ssesbpersonName }&nbsp;</TD>
						 </tr>
						 <TR> 
						  <TD height="26" class="table_body">顾客电话</TD>
						  <TD class="table_none">${salesBasicPo.ssesbphone }&nbsp;
						  </TD>
                          <TD height="26" class="table_body">顾客卡号</TD>
                          <TD class="table_none">${salesBasicPo.ssesbMemberId}&nbsp;
						  </TD>
						  <TD class="table_body">付款状态</TD>
						  <TD class="table_none">
								<c:choose>
									<c:when test="${salesBasicPo.ssesbvalueflag=='0'}">
										未收费
									</c:when>
									<c:when test="${salesBasicPo.ssesbvalueflag=='1'}">
										<c:choose>
											<c:when test="${salesBasicPo.ssesbcheckoutflag=='0'}">
												已收全款
											</c:when>
											<c:when test="${salesBasicPo.ssesbcheckoutflag=='1'}">
												欠费：${salesBasicPo.ssesbarrearsvalue}
											</c:when>
										</c:choose>
									</c:when>
								</c:choose>&nbsp;
	   					    </TD>
                        </TR>   						  
                        </TR> 
                        <TR> 
                          <TD height="26" class="table_body">收银日期</TD>
                          <TD class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,19) }&nbsp;
						  </TD>
						  <TD height="26" class="table_body">实际收银日期</TD>
                          <TD class="table_none">${fn:substring(salesBasicPo.ssesbfactposdatetime,0,19) }&nbsp;
						  </TD>
						  <TD width="8%" class="table_body">取镜门店</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbtakeshopname }
						  </TD>

                        </TR>
                        <TR> 
                          <TD class="table_body">取镜日期</TD>
							<TD class="table_none">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,19) }&nbsp;
						  </TD>
                          <TD height="26" class="table_body">原价合计</TD>
                          <TD class="table_none">${salesBasicPo.ssesbpricesum}&nbsp;
						  </TD>
						  <TD height="26" class="table_body">折扣金额</TD>
							<TD class="table_none">${salesBasicPo.ssesbdiscountnum}&nbsp;
						  </TD>

                        </TR>
                        <TR> 
                          <TD height="26" class="table_body">抹零金额</TD>
                          <TD class="table_none">${salesBasicPo.ssesbrenums}&nbsp;
						  </TD>
                          <TD height="26" class="table_body">应收金额</TD>
                          <TD class="table_none">${salesBasicPo.ssesbsalesvalue}&nbsp;
						  </TD>
						  <TD height="26" class="table_body">实缴金额</TD>
							<TD class="table_none">${salesBasicPo.ssesbpsalsvalue}&nbsp;
						  </TD>

                        </TR>
                        <TR>
                          <TD height="26" class="table_body">邮寄状态</TD>
                          <TD class="table_none">
                          	<c:choose>
                          		<c:when test="${salesBasicPo.isMail=='1'}"><a href="#" onClick="showMailDetails('${salesBasicPo.ssesbsalesid}');">已邮寄</a></c:when>
                          		<c:otherwise>未邮寄</c:otherwise>
                          	</c:choose>&nbsp;
                          </TD>
                          <TD height="26" class="table_body">特殊加工要求</TD>
                          <TD class="table_none"  colspan="3">
                          <font color="red" >
							<s:iterator value="specialPDetailList">
                              ${ssesdrequirement}&nbsp;&nbsp;&nbsp;&nbsp;
						    </s:iterator>	
						  </font>&nbsp;
						  </TD>
                        </TR>                        
                        <TR>
						  <TD width="8%"  height="26" class="table_body">退款日期</TD>
						  <TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbwithdrawdate,0,19) }
						  </TD>
						  <TD width="8%"  height="26" class="table_body">实际退款日期</TD>
						  <TD width="25%" class="table_none" colspan="3">${fn:substring(salesBasicPo.ssesbfactwithdrawdate,0,19) }
						  </TD>
                        </TR>
                        
                    </TABLE>
                    <BR/>
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
                          <TH height="26" width="10%" scope=col>付款笔数</TH>
						  <TH width="15%" scope=col>收银人</TH>
						  <TH width="15%" scope=col>收银日期</TH>
						  <TH width="15%" scope=col>实际收银日期</TH>						  
						  <TH width="15%" scope=col>缴费金额</TH>
						  <TH width="20%" scope=col>结款类型</TH>
						  <TH width="20%" scope=col>付款方式</TH>						  
						</TR>
						<s:iterator value="salesLogList">
                        <TR class="row" ${sseslpaymenttype=='4' ? 'style="color:red;"':'' } onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">第${sseslorderby}笔</TD>                          
                          <TD>${sseslperson}</TD>
                          <TD>${ssesldatetime}</TD>
                          <TD>${sseslfactdatetime}</TD>
                          <TD>
                          <c:choose>
								<c:when test="${sseslconsumptionid=='2'}">
									${sseslintegralprice}
								</c:when>
								<c:otherwise>
								${sseslprice}
								</c:otherwise>
														
							</c:choose>
                          
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
								<c:when test="${sseslpaymenttype=='5'}">
									无配镜单退款
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
									银行卡   【${bbname }】
								</c:when>
								<c:when test="${sseslconsumptionid=='4'}">
									储值卡
								</c:when>		
								<c:when test="${sseslconsumptionid=='5'}">
									找零
								</c:when>	
								<c:when test="${sseslconsumptionid=='6'}">
									其他   【${bbname }】
								</c:when>		
								<c:when test="${sseslconsumptionid=='7'}">
									代金券
								</c:when>														
							</c:choose>
						  </TD>
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
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>