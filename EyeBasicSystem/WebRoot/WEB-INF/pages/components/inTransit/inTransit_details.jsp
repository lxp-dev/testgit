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

	function print(salesID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initConsignProcessOrderView.action?hid="+salesID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initConsignProcessOrderView.action?hid="+salesID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【委外订单信息】";	
	}
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("consignProcessTakeDetails.action?sid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("consignProcessTakeDetails.action?sid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【委外收货详细】";
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
                    <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">在途信息</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
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
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbsalesid }&nbsp;
                          </TD>
                          <TD width="8%" height="26" class="table_body">配镜门店</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbshopName }&nbsp;
						  </TD>
						  <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                          <TD width="25%" class="table_none">${salesBasicPo.ssesbpersonName }　　【卡号：${salesBasicPo.ssesbMemberId}】&nbsp;</TD>
                        </TR> 
                        <TR>
                          
						  
                          <TD width="8%" height="26" class="table_body">顾客电话</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbphone }&nbsp;
						  </TD>
						   <TD width="8%" class="table_body">取镜门店</TD>
							<TD width="25%" class="table_none">${salesBasicPo.ssesbtakeshopname }&nbsp;
							<TD width="8%" class="table_body" height="26">取镜日期</TD>
							<TD width="25%" class="table_none" >${fn:substring(salesBasicPo.ssesbtakeglassdata,0,19) }&nbsp;
						  </TD>    
                        </TR>
                        <tr>
						  <TD width="8%" height="26" class="table_body">收银日期</TD>
                          <TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,19) }&nbsp;
						  </TD>							
						  <TD width="8%" height="26" class="table_body">实际收银日期</TD>
                          <TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbfactposdatetime,0,19) }&nbsp;
						  </TD>
						  
							<TD width="8%" class="table_body" height="26">退款日期</TD>
							<TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbwithdrawdate,0,19) }
						  </TD>
                        </TR>
                        <TR>
						   <TD width="8%"  height="26" class="table_body">实际退款日期</TD>
						  	<c:choose>
								<c:when test="${salesBasicPo.djsbm eq ''}">
								<TD width="25%" class="table_none" colspan="5">${fn:substring(salesBasicPo.ssesbfactwithdrawdate,0,19) }&nbsp;</TD>
								</c:when>
								<c:when test="${salesBasicPo.djsbm ne ''}">
								<TD width="25%" class="table_none">${fn:substring(salesBasicPo.ssesbfactwithdrawdate,0,19) }&nbsp;</TD>
								<TD width="8%" class="table_body">单据识别码</TD>
								<TD class="table_none" colspan="3">${salesBasicPo.djsbm }&nbsp;</TD>
								</c:when>
							</c:choose>							
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
                     <table width="100%" border="0" cellpadding=0 cellspacing=0 >                           
                        <tr>
                          <c:choose>
                          	<c:when test="${not empty(rInTransitStateList)}">
                          		<td valign="top" width="50%">
                          	</c:when>
                          	<c:otherwise>
                          		<td valign="top" width="100%">
                          	</c:otherwise>
                          </c:choose>    
                            <!-- 左侧配镜TABLE -->
							<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder"/>
		                      <TBODY>
		                        <TR class=table_title align=middle>
		                          <TH scope=col width="10%" height="26">完成状态</TH>
		                          <TH scope=col width="40%" height="26">在途名称</TH>
								  <TH scope=col width="30%">操作时间</TH>	
		                          <TH scope=col width="20%">操作人员</TH>						
		                          </TR>
		                          <s:iterator value="inTransitStateList">
				                     <TR ${sseitstateflag == 2 ? 'style="background-color: #C0C0C0"' : ''}>
				                     <c:choose>
										<c:when test="${sseitstateflag == 1 }"><c:set var="color" value="black"/></c:when> 
										<c:when test="${sseitstateflag == 2 }"><c:set var="color" value="red"/></c:when> 
										<c:when test="${sseitstateflag == 0 }"><c:set var="color" value="gray"/></c:when> 
					                  </c:choose>
							                  
				                     <TD align="center" height="26">
				                     <c:choose>
										<c:when test="${sseitstateflag == 1 }"><img src="${ctx }/img/newbtn/select_0.png" title='已完成' ></c:when> 
										<c:when test="${sseitstateflag == 2 }"><img src="${ctx }/img/newbtn/select_0.png" title='当前在途' ></c:when> 
										<c:when test="${sseitstateflag == 0 }"></c:when> 
					                  </c:choose>
				                     </TD>
										  <TD align="center" height="26"><font color="${color }">${sseitintransitname }</font></TD>
										  <TD align="center" ><font color="${color }">${fn:substring(sseitdate, 0, 19) }</font></TD>
										  <TD align="center" ><font color="${color }">
										  ${sseitcreateperson }
										  <c:if test="${sseitstate eq '3'}">【门店配送人员：${mdpsName }】</c:if>
										  <c:if test="${sseitstate eq '11'}">【隐形配送人员：${yxpsName }】</c:if>
										  <c:if test="${sseitstate eq '10'}">【加工配送人员：${jgpsName }】</c:if>
										  </font></TD>
				                    </TR>
		                          </s:iterator>
		                      </TBODY>
		                    </TABLE>
					 </td>
					 <c:if test="${not empty(rInTransitStateList)}">					 
					 	<td valign="top" width="50%">
                             <!-- 右侧重订TABLE -->
                             <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                               <tbody>
								   <tr class=table_title align=middle>
	                                     <th height="26" colspan="5" scope=col>重订过程</th>
	                                   </tr>
	                               <s:iterator value="rInTransitStateList">    
	                               	   <c:if test="${sseitstate=='1'}">
	                               	   <tr class=table_title align=middle>
		                                    <th height="26" colspan="2" scope=col><div align="center">重订单号：${sseitsalesid}</div></th>
		                                    <th height="26" colspan="3" scope=col><div align="center">委外订单号：<a href="javascript:void(0);" onclick="print('${orderssalesid}')" style='color: white'>${orderssalesid}</a></div></th>
								        </tr>
									   <tr class=table_title align=middle>
		                                    <th scope=col height="26">顺序</th>
									     <th scope=col height="26">在途状态</th>
									     <th scope=col>操作时间</th>
									     <th scope=col>操作人员</th>
									      <th scope=col>备注</th>
								        </tr>
									   </c:if>									   
									   <tr >
		                                    <td align="center" height="26"><font color="black">${sseitstate}</font></td>
									     <td align="center" height="26">
											<c:choose>
												<c:when test="${sseitstate=='1'}">
													已生成重订单
												</c:when>
												<c:when test="${sseitstate=='2'}">
													重订单已收货
												</c:when>
											</c:choose>
										 </td>
									     <td align="center" ><font color="black">${sseitdate}</font></td>
									     <td align="center" ><font color="black">${sseitcreateperson}</font></td>
									     <td align="center" ><font color="black">${cstcporesalesremark}</font></td>
								        </tr>
							       </s:iterator>								   
                                  </tbody>
                              </table>
                            </td>
					 </c:if>					 
                    </tr>
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