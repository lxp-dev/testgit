<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验光</title>
</head>
<script>	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 

	function winPopUp2(id,integraltype,flag,date){
		var DataUrl = "";
		var des = "";
		if (integraltype=='积分赠送'){
			DataUrl = "initSelectIntegralAddandSubDetails.action?smeasuuid="+id;
			des = "【积分赠送明细】";
		}else if (integraltype=='积分兑换'){
			DataUrl = "selIntegralExchangeManagementDetail.action?hid="+id;
			des = "【积分兑换明细】";
		}else if (integraltype=='会员升级'){
			DataUrl = "upGradeRecordDetail.action?hid="+id;
			des = "【会员升级明细】";
		}else{
			DataUrl = "selectInTransitDetails2.action?hid="+id+"&flag="+flag+"&date="+date;
			des = "【消费累计明细】";
	    }
		
 		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(DataUrl,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataUrl,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML=des;
    }

	function winPopUp(id){
		var DataUrl = "selectInTransitDetails.action?hid="+id;
 		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(DataUrl,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataUrl,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单信息】";
    }
    
    function showLoadingBar(){
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="venditionInformationForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="customerID" value="${customerID }">
<input type="hidden" id="dontshow" name="dontshow" value="${dontshow }">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY> 
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initDetailsCustomerInfo.action?hid=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">会员详细</TD>
                      	<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectOptometryInformation.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">病历信息</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD> 
                     <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif  
                      onclick="JavaScript:window.location.href='selectVenditionInformation.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      UNSELECTABLE="on">销售信息</TD>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" width=3></TD>
                        
                          <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectReturnVisitInformation.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">顾客回访</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" width=3></TD> 
                        <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectCustomerComplainByCustomer.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">顾客投诉</TD>
                      
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>  
					
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1                      
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">积分记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>  
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='chuZhiKaExpense.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">储值卡记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD> 
                    <TD>
                    	</TR></TBODY></TABLE></TD>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
              
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <TR class=table_title align=middle>
                      	 <TH width="4%" scope=col height="26" >操作</TH>
                      	 <TH width="10%" scope=col>会员卡号</TH>
                      	 <TH width="7%" scope=col>顾客姓名</TH>
                      	 <TH width="10%" scope=col>配镜(兑换)单号</Th>
                      	 <TH width="10%" scope=col>积分时间</Th>
                      	 <TH width="10%" scope=col>积分类型</Th>
                      	 <TH width="10%" scope=col>发生积分</TH>
                      	 <TH width="10%" scope=col>积分剩余</TH>
                      	 <TH width="10%" scope=col>副卡消费</TH>
                      </tr>
                      <s:iterator value="salesBasicList"> 
                        <TR class="row" align=middle  ${integraltype eq '清除积分' ? 'style="background-color: red;"':'onMouseOver="mover(this,\'#a2c1eb\')" onMouseOut="mout(this,\'#cadee8\')"'}>                          
                          <td height="26" width="4%">
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:winPopUp2('${ssesbsalesid}','${integraltype}','${ssesbcheckoutflag}','${integraldate}')" >
                          </td>
                          <td>${ssesbMemberId}</td>
                          <td>${ssesbpersonName }</td>
                          <td><c:if test="${integraltype=='消费累计'}"><div onclick="javascript:winPopUp('${ssesbsalesid}')" style="cursor:hand"><u>${ssesbsalesid}</u></div></c:if>
                          <c:if test="${integraltype=='积分兑换'}">${ssesbsalesid}</c:if>
                          </td>
                          <td>${integraldate}</td>
                          <td>
                          <c:choose>
                              <c:when test="${integraltype=='消费累计' && ssesbcheckoutflag == '3'}">结款</c:when>
                              <c:when test="${integraltype=='消费累计' && ssesbcheckoutflag == '4'}">退款</c:when>
                              <c:when test="${integraltype=='消费累计' && ssesbcheckoutflag == '5'}">补齐欠款</c:when>
                              <c:when test="${integraltype=='消费累计' && ssesbcheckoutflag == '6'}">订金</c:when>
                              <c:when test="${integraltype=='清除积分'}">清除积分</c:when>
                              <c:when test="${integraltype=='积分兑换'}">积分兑换</c:when>
                              <c:when test="${integraltype=='积分赠送'}">积分赠送</c:when>
                              <c:when test="${integraltype=='会员升级'}">会员升级</c:when>
                              <c:otherwise></c:otherwise>
                          </c:choose>
                          </td>
                          <td>${inintrgral}</td>
                          <td>${nowintegral}</td>
                          <td>${ssesbfcustomername}</td>
                        </TR>                     
					</s:iterator>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(salesBasicList)}">
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
				   </c:if>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
