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
			<TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                       <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectInTransitDetails.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">配镜单信息</TD>
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                     <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
					  onclick="JavaScript:window.location.href='initInTransitDetailsSel.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">在途信息</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>	
                    <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      onclick="JavaScript:window.location.href='selectGoodsOut.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
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
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectSalesLog.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">付款记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>     
                         </TR></TBODY></TABLE></TD>
				</TR></TBODY></TABLE>     
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
                             
		                  <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="8%" height="26" class="table_body">配镜单号</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbsalesid }
                          </TD>
                          <TD width="8%" height="26" class="table_body">配镜门店</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbshopName }
						  </TD>
						   <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbpersonName }　　【卡号：${salesBasicPo.ssesbMemberId}】
						  </TD>
                        </TR> 
                        <TR>
                         
                          <TD width="8%" height="26" class="table_body">顾客电话</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbphone }
						  </TD>
						  <TD width="8%" class="table_body">取镜门店</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbtakeshopname }
						  </TD> 
						   <TD width="8%"  height="26" class="table_body">取镜日期</TD>
							<TD width="25%" class="table_none" >${fn:substring(salesBasicPo.ssesbtakeglassdata,0,19) }
						  </TD>
                        </TR> 
                        <TR>
						  <TD width="8%" height="26" class="table_body">收银日期</TD>
                          <TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,19) }
						  </TD>
						  <TD width="8%" height="26" class="table_body">实际收银日期</TD>
                          <TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbfactposdatetime,0,19) }
						  </TD>
						   <TD width="8%"  height="26" class="table_body">退款日期</TD>
							<TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbwithdrawdate,0,19) }
						  </TD>
						  </TR>
						  
						<TR>
						   <TD width="8%"  height="26" class="table_body">实际退款日期</TD>
							<TD width="25%" class="table_none" colspan="5">${fn:substring(salesBasicPo.ssesbfactwithdrawdate,0,19) }
						  </TD>
						  </TR>
						  
                    </TABLE>
                    <BR/>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>                    
				<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder"/>
                      <TBODY>
                        <TR class=table_title align=middle>                          
						  <TH width="25%" height="26" scope=col>商品名称 </TH>						
						  <TH width="5%" scope=col>数量</TH>
						  <TH width="15%" scope=col>出库状态</TH>
						    <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
						  <TH width="25%" height="26" scope=col>商品条码</TH>
						 	</c:if>
						  <TH width="15%" scope=col>出库仓位</TH>						  
						  <TH width="20%" scope=col>出库时间</TH>						  
						  </TR>
                          <s:iterator value="goodsInfoList">
                     <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                     <c:choose>
						<c:when test="${sseitstateflag == 1 }"><c:set var="color" value="black"/></c:when> 
						<c:when test="${sseitstateflag == 2 }"><c:set var="color" value="red"/></c:when> 
						<c:when test="${sseitstateflag == 0 }"><c:set var="color" value="gray"/></c:when> 
	                  </c:choose>
			         	  <TD align="center"><font color="${color }">${ssesdsalesitemname}</font></TD>
						  <TD align="center" ><font color="${color }">${ssesdnumber} 	</font></TD>
						  <c:choose>
							<c:when test="${ssesoutstorageflag eq '1' }">
							    <TD align="center" height="26"><font color="${color }"><b><font color="red">[√] 已出库</font></b></font></TD>
								<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
								<TD align="center" height="26"><font color="${color }">${ssesditemid}</font></TD>
								</c:if>
								<TD align="center" ><font color="${color }">${ssesdstockname}</font></TD>								
								<TD align="center" ><font color="${color }">${fn:substring(ssesdupdatetime,0,19)}</font></TD>						  		
						  	</c:when>
							<c:when test="${ssesoutstorageflag eq '0'}">
								<TD align="center" height="26"><font color="${color }">[×] 未出库</font></TD>
								<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
								<TD align="center" height="26"></TD>
								</c:if>
								<TD align="center" ></TD>								
								<TD align="center" ></TD>						  									
							</c:when>
						  </c:choose>
					</TR>
                    	</s:iterator>
                     <s:iterator value="goodsInfoList">
                     <c:if test="${ssesdwithdrawflag eq '1' }">
                     <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			         	  <TD align="center"><font color="${color }">${ssesdsalesitemname}</font></TD>
						  <TD align="center" ><font color="${color }">${ssesdnumber} 	</font></TD>
						  <c:choose>
							<c:when test="${ssesinstorageflag eq '1' }">
							    <TD align="center" height="26"><font color="${color }"><b><font color="red">[√] 已入库</font></b></font></TD>
								<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}"> 
								<TD align="center" height="26"><font color="${color }">${ssesditemid}</font></TD>
								</c:if>
								<TD align="center" ><font color="${color }">${ssesdinstockname}</font></TD>								
								<TD align="center" ><font color="${color }">${fn:substring(ssesdwithdrawdate,0,19)}</font></TD>						  		
						  	</c:when>
							<c:when test="${ssesinstorageflag eq '0'}">
								<TD align="center" height="26"><font color="${color }">[×] 未入库</font></TD>
								<c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
								<TD align="center" height="26"></TD>
								</c:if>
								<TD align="center" ></TD>								
								<TD align="center" ></TD>						  									
							</c:when>
						  </c:choose>				  		
					</TR>
					</c:if>
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