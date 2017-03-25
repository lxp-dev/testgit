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
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	venditionInformationForm.action=link;
	  	venditionInformationForm.submit();
	}
	function details(id,sopecid){
		document.all.hid.value = id;
		showPopWin("","detailEyesCheckAier.action?hid="+id+"&sopecid="+sopecid,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	/*销售单详细*/
	function winPopUp(id){
 		document.all.hid.value = id;
 		
 		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【销售单详细】";
    }
    
    function showLoadingBar()
    {

	}
</script>
<!--oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;"-->
<!--JavaScript:window.location.href='initDetailsCustomerInfo.action?hid="+'${customerID }' ';-->
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
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">销售信息</TD>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" width=3></TD>
                        
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
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='integralExpense.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">积分记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" width=3></TD> 
                        
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
				  <c:if test="${not empty(salesBasicList)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                   
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <TR class=table_title align=middle>
                      	 <TH width="10%" scope=col height="28" style="color:black;">销售单号</TH>
                      	 <TH width="10%" scope=col height="28" style="color:black;">销售门店</TH>
                      	 <TH width="10%" scope=col height="28" style="color:black;">验光单号</Th>
                      	 <TH width="10%" scope=col height="28" style="color:black;">销售类型</Th>
                      	 <TH width="10%" scope=col height="28" style="color:black;">处方类型</Th>
                      	 <TH width="10%" scope=col height="28" style="color:black;">销售人员</TH>
                      	 <TH width="10%" scope=col height="28" style="color:black;">原价合计</TH>
                      	 <TH width="10%" scope=col height="28" style="color:black;">折扣金额</TH>
                      	 <TH width="10%" scope=col height="28" style="color:black;">应收金额</TH>
                      	 <TH width="10%" scope=col height="28" style="color:black;">退货状态</TH>
                      </tr>
                       <c:forEach var="basicPo" items="${salesBasicList}" varStatus="basicIndex">
                       
                        <TR class="row" align=middle>
                          <td width="10%"  height="28" ><div onclick="javascript:winPopUp('${basicPo.ssesbsalesid}')" style="cursor:hand"><u>${basicPo.ssesbsalesid }</u></div></td>
                          <td width="10%"  height="28" >${basicPo.ssesbshopcode }</td>
                          <td width="10%"  height="28" >${basicPo.ssesboptometryid }</td>
                          <td width="10%"  height="28" >
                           <c:choose>
								<c:when test="${basicPo.ssesborderstype == 1 }">
			                         	框镜成品
			                    </c:when> 
			                    <c:when test="${basicPo.ssesborderstype == 2 }">
			                     	框镜订做
			                    </c:when>      
			                     <c:when test="${basicPo.ssesborderstype == 3 }">
			                       	   隐形成品
			                    </c:when>     
			                    <c:when test="${basicPo.ssesborderstype == 4 }">
			                       	   隐形订做
			                    </c:when>      
			              </c:choose>   
			              </td>
                          <td width="10%"  height="28" >
                         <c:choose>
								<c:when test="${basicPo.ssesbsalestype == 1 }">
			                                                                内方
			                    </c:when> 
			                    <c:when test="${basicPo.ssesbsalestype == 2 }">
			                     	 外方
			                    </c:when>      
			                    <c:when test="${basicPo.ssesbsalestype == 3 }">
			                       	  辅料
			                    </c:when>      
			              </c:choose> 
                          </td>
                          
                          <td width="10%"  height="28" >${basicPo.ssesbsalerid }</td>
                          <td width="10%"  height="28" ><fmt:formatNumber value="${basicPo.ssesbpricesum }" pattern="0.00"/></td>
                          <td width="10%"  height="28" ><fmt:formatNumber value="${basicPo.ssesbdiscountnum }" pattern="0.00"/></td>
                          <td width="10%"  height="28" ><fmt:formatNumber value="${basicPo.ssesbsalesvalue }" pattern="0.00"/></td>
                          <c:if test="${basicPo.ssesbwithdrawflag=='已退货' }">
                          <td width="10%"  height="28" style="color: red;">${basicPo.ssesbwithdrawflag }</td>
                          </c:if>
                          <c:if test="${basicPo.ssesbwithdrawflag=='未退货' }">
                          <td width="10%"  height="28">${basicPo.ssesbwithdrawflag }</td>
                          </c:if>
                        </TR>
                        <!--<c:forEach var="salesDetail" items="${basicPo.salesDetails }" varStatus="salesDetailIndex">
                       	<TR  align=middle class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28" >商品名称:${salesDetail.ssesdsalesitemname }</TD>
                          <TD height="28" colspan="2" >商品单价:${salesDetail.ssesdsprice }</TD>
                          <TD height="28" >数量:${salesDetail.ssesdnumber }</TD>
                          <TD height="28" >原价合计:${salesDetail.ssesdpricesum }</TH>
                          <TD height="28" >折扣率:${salesDetail.ssesddiscountrate }</TD>
                          <TD height="28" >折扣金额:${salesDetail.ssesddiscountnum }</TD>
                          <TD height="28" colspan="2" >应收金额:${salesDetail.ssesdsalesvalue }</TD>
                        </TR>
                        </c:forEach>-->
                        
					</c:forEach>
                      </TBODY>
                    </TABLE>
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
