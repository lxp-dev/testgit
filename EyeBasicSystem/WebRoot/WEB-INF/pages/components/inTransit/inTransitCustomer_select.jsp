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
      <!-- ?? End --><!-- ?? Start -->
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
					<TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">配镜单信息</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
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
                          <TD width="20%" class="table_none">${salesBasicPo.ssesbsalesid }&nbsp;
                          </TD>
                          <TD width="8%" height="26" class="table_body">配镜门店</TD>
                          <TD width="20%" class="table_none">${salesBasicPo.ssesbshopName }&nbsp;
						  </TD>
                          <TD height="26" class="table_body">配镜类型</TD>
                          <TD class="table_none">
                          	<c:choose>
                          		<c:when test="${salesBasicPo.ssesborderstype=='1'}">框镜成品</c:when>
                          		<c:when test="${salesBasicPo.ssesborderstype=='2'}">框镜订做</c:when>
                          		<c:when test="${salesBasicPo.ssesborderstype=='3'}">隐形成品</c:when>
                          		<c:when test="${salesBasicPo.ssesborderstype=='4'}">隐形订做</c:when>
                          		<c:when test="${salesBasicPo.ssesborderstype=='5'}">辅料</c:when>
                          		<c:otherwise>&nbsp;</c:otherwise>
                          	</c:choose>
                          </TD>
                        </TR> 
                                                
                        <TR>
                          <TD class="table_body">取镜门店</TD>
							<TD class="table_none">${salesBasicPo.ssesbtakeshopname }
						  </TD>    
						   <TD class="table_body">取镜日期</TD>
							<TD class="table_none">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,19) }&nbsp;
						  </TD>			
						  <TD height="26" class="table_body">邮寄状态</TD>
                          <TD class="table_none">
                          	<c:choose>
                          		<c:when test="${salesBasicPo.isMail=='1'}"><a href="#" onClick="showMailDetails('${salesBasicPo.ssesbsalesid}');">已邮寄</a></c:when>
                          		<c:when test="${salesBasicPo.isMail=='0'}"><a href="#" onClick="showMailDetails('${salesBasicPo.ssesbsalesid}');">未邮寄</a></c:when>
                          		<c:otherwise>&nbsp;</c:otherwise>
                          	</c:choose>
                          </TD>			  
                        </TR> 
                        
                        <TR>      
                          <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                          <TD width="30%" class="table_none">${salesBasicPo.ssesbpersonName }&nbsp;
						  </TD>                   
                          <TD height="26" class="table_body">顾客电话</TD>
						 <TD class="table_none">${salesBasicPo.ssesbphone }&nbsp;
						  </TD>
						  <TD height="26" class="table_body">顾客卡号</TD>
                          <TD class="table_none">${salesBasicPo.ssesbMemberId}&nbsp;
						  </TD>

						 </tr>  
						 						  
                        <TR> 
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
												欠费：${fn:substring(salesBasicPo.ssesbarrearsvalue,0,6)  }
											</c:when>
										</c:choose>
									</c:when>
								</c:choose>
	   					    </TD>
	   					    
                          <TD height="26" class="table_body">收银日期</TD>
                          <TD class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,19) }&nbsp;
						  </TD>
						  
						  <TD height="26" class="table_body">实际收银日期</TD>
                          <TD class="table_none">${fn:substring(salesBasicPo.ssesbfactposdatetime,0,19) }&nbsp;
						  </TD>						  

                        </TR>
                        
                        <TR> 
                          <TD height="26" class="table_body">原价合计</TD>
                          <TD class="table_none">${salesBasicPo.ssesbpricesum}&nbsp;
						  </TD>
                          <TD height="26" class="table_body">折扣金额</TD>
							<TD class="table_none">${salesBasicPo.ssesbdiscountnum}&nbsp;
						  </TD>
						    <TD height="26" class="table_body">抹零金额</TD>
                          <TD class="table_none">${salesBasicPo.ssesbrenums}&nbsp;
						  </TD>
                        </TR>
                        
                        <TR> 
                          <TD height="26" class="table_body">应收金额</TD>
                          <TD class="table_none">${salesBasicPo.ssesbsalesvalue}&nbsp;
						  </TD>
						  <TD height="26" class="table_body">实缴金额</TD>
							<TD class="table_none" colspan="3">${salesBasicPo.ssesbpsalsvalue}&nbsp;
						  </TD>
                        </TR>
                        
                        <TR> 
                          <TD height="26" class="table_body">退款状态</TD>
                          <TD class="table_none">
                            <c:choose>
                          		<c:when test="${salesBasicPo.ssesbwithdrawflag=='1'}"><font color="red">已退款</font></c:when>
                          		<c:otherwise>未退款</c:otherwise>
                          	</c:choose>&nbsp;
						  </TD>
						  <TD height="26" class="table_body">退款时间</TD>
                          <TD class="table_none">
                          	${fn:substring(salesBasicPo.ssesbwithdrawdate,0,19) }&nbsp;
						  </TD>
						  <TD height="26" class="table_body">实际退款时间</TD>
                          <TD class="table_none">
                          	${fn:substring(salesBasicPo.ssesbfactwithdrawdate,0,19) }&nbsp;
						  </TD>
                        </TR>
                        
                        <c:if test="${salesBasicPo.djsbm ne ''}"> 
                        <TR> 
                          <TD height="26" class="table_body">单据识别码</TD>
                          <TD class="table_none" colspan="5" >${salesBasicPo.djsbm }&nbsp;</TD>
                        </TR>
                        </c:if> 
                        
                        <c:if test="${salesBasicPo.ssesborderstype=='1' || salesBasicPo.ssesborderstype=='2'}"> 
                        <TR> 
                          <TD height="26" class="table_body">加工部门</TD>
                          <TD class="table_none" colspan="5" >${salesBasicPo.ssesbprocessdepartmentname}&nbsp;</TD>
                        </TR>
                        </c:if>                      
                        
                      <c:if test="${not empty(specialPDetailList)}"> 
                        <TR> 
                          <TD height="26" class="table_body">特殊加工要求</TD>
                          <TD class="table_none" colspan="5" >
                          <font color="red" >
							<s:iterator value="specialPDetailList">
                              ${ssesdrequirement}&nbsp;&nbsp;&nbsp;&nbsp;
						    </s:iterator>	
						  </font>
						  </TD>
                        </TR>
                        </c:if>   
                        
                        <tr>
                          <TD height="26" class="table_body">营业员</TD>
                          <TD class="table_none">${salesBasicPo.ssesbsalerid }&nbsp;</TD>
						  <TD  height="26" class="table_body">套餐主题</TD>
                          <TD class="table_none">
                          	${salesBasicPo.ssesbsetmealtitle }&nbsp;
						  </TD>
						  <TD  height="26" class="table_body"><c:if test="${salesBasicPo.ssesbcheckoutflag==0}">累计积分</c:if>&nbsp;</TD>
                          <TD class="table_none">
                          <c:if test="${salesBasicPo.ssesbcheckoutflag==0}">
                          	${salesBasicPo.ssesbjfamount }
                          	</c:if>&nbsp;
						  </TD>
                        </tr>

                    <c:if test="${salesBasicPo.ssesborderstype ne '5'}">    
                        <tr>
                          <TD height="62" class="table_body">处方备注</TD>
                          <TD class="table_none" colspan="5">
                          	${salesBasicPo.ssesbdignosisre }&nbsp;
						  </TD>
                        </tr>
                   </c:if>     
                        <tr>
                          <TD height="62" class="table_body">销售备注</TD>
                          <TD class="table_none"  colspan="5">
                          	${salesBasicPo.ssesbsalesremark }&nbsp;
						  </TD>						
                        </tr>
                    </TABLE>
                   <BR/>
						<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;${salesBasicPo.ssesbballglassod}</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col>右眼(R)/左眼(L)</TH>						
						  <TH width="8%" scope=col>球镜</TH>
						  <TH width="8%" scope=col>柱镜</TH>
						  <TH width="8%" scope=col>轴向</TH>
						  <c:if test="${salesBasicPo.ssesbrecipetype == '3'}">
						  <TH width="7%" scope=col>add</TH>
						  </c:if>
						  <c:if test="${salesBasicPo.ssesbrecipetype != '4'}">
						  <TH width="7%" scope=col>三棱镜</TH>
						  <TH width="7%" scope=col>基底</TH>
						  <TH width="7%" scope=col>棱镜</TH>
						  </c:if>
						  <c:if test="${salesBasicPo.ssesbrecipetype == '1' || salesBasicPo.ssesbrecipetype == '3'}">
						  <TH width="7%" scope=col>远用瞳距</TH>
						  </c:if>
						  <c:if test="${salesBasicPo.ssesbrecipetype == '5'}">
						  <TH width="7%" scope=col>中用瞳距</TH>
						  </c:if>
						  <c:if test="${salesBasicPo.ssesbrecipetype == '2' || salesBasicPo.ssesbrecipetype == '3'}">
						  <TH width="7%" scope=col>近用瞳距</TH>
						  </c:if>
						  <c:if test="${salesBasicPo.ssesbrecipetype == '1'}">
						  <TH width="7%" scope=col>远用VA</TH>
						  </c:if>
						  <c:if test="${salesBasicPo.ssesbrecipetype == '5'}">
						  <TH width="7%" scope=col>中用VA</TH>
						  </c:if>
						  <c:if test="${salesBasicPo.ssesbrecipetype == '2'}">
						  <TH width="7%" scope=col>近用VA</TH>
						  </c:if>
						  <TH height="26" width="10%" scope=col>镜片种类</TH>
						  </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD align="center" height="26">R</TD>
                          <TD height="26">${salesODPo.ssesbballglassod}</TD>
                          <TD height="26">${salesODPo.ssesbpostglassod}</TD>
                          <TD height="26">${salesODPo.ssesbaxesod}</TD>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '3'}">
                          <TD height="26">${salesODPo.ssesbaddod}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype != '4'}">
                          <TD height="26">${salesODPo.ssesbarriseglassod}</TD>
                          <TD height="26">
                	          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
                                   <c:if test="${(optionParamPoTmp.fopparentid=='24') && (optionParamPoTmp.fopparamid == salesODPo.ssesbbasisod)}">
                               	       ${optionParamPoTmp.fopparamname}
                                   </c:if>	                                      	
                              </c:forEach>
                          </TD>
                          <TD height="26">${salesODPo.ssesbprismod}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '1' || salesBasicPo.ssesbrecipetype == '3' || salesBasicPo.ssesbrecipetype == '5'}">
                          <TD height="26">${salesODPo.ssesbinterhighod}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '2' || salesBasicPo.ssesbrecipetype == '3'}">
                          <TD height="26">${salesODPo.ssesbinterdistanceod}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '1' || salesBasicPo.ssesbrecipetype == '5'}">
                          <TD height="26">${salesODPo.ssesbfarvaod}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '2'}">
                          <TD height="26">${salesODPo.ssesbclosevaod}</TD>
                          </c:if>
                          <TD height="26">
                          <c:if test="${((salesODPo.ssesborderstype)==1 && (salesODPo.ssesbdragstype)=='0') || ((salesODPo.ssesborderstype)==2 && (salesODPo.ssesbdragstype)=='0') }"> 
			               	框镜成品
			               </c:if>
			               <c:if test="${(salesODPo.ssesborderstype)==2 && (salesODPo.ssesbdragstype)=='D' }"> 
			               	框镜订做
			               </c:if>
			               <c:if test="${((salesODPo.ssesborderstype)==3 && (salesODPo.ssesbdragstype)=='0') || ((salesODPo.ssesborderstype)==4 && (salesODPo.ssesbdragstype)=='0') }"> 
			               	隐形成品
			               </c:if>
			               <c:if test="${(salesODPo.ssesborderstype)==4 && (salesODPo.ssesbdragstype)=='D' }"> 
			               	隐形订做
			               </c:if>
			               </TD>
						</TR>
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD align="center" height="26">L</TD>
                          <TD height="26">${salesOSPo.ssesbballglassos}</TD>
                          <TD height="26">${salesOSPo.ssesbpostglassos}</TD>
                          <TD height="26">${salesOSPo.ssesbaxesos}</TD>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '3'}">
                          <TD height="26">${salesOSPo.ssesbaddos}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype != '4'}">
                          <TD height="26">${salesOSPo.ssesbarriseglassos}</TD>
                          <TD height="26">
                              <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
                                   <c:if test="${(optionParamPoTmp.fopparentid=='24') && (optionParamPoTmp.fopparamid == salesOSPo.ssesbbasisos)}">
                               	       ${optionParamPoTmp.fopparamname}
                                   </c:if>	                                      	
                              </c:forEach>
                          </TD>
                          <TD height="26">${salesOSPo.ssesbprismos}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '1'  || salesBasicPo.ssesbrecipetype == '3' || salesBasicPo.ssesbrecipetype == '5'}">
                          <TD height="26">${salesOSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '2' || salesBasicPo.ssesbrecipetype == '3'}">
                          <TD height="26">${salesOSPo.ssesbinterdistanceos}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '1' || salesBasicPo.ssesbrecipetype == '5'}">
                          <TD height="26">${salesOSPo.ssesbfarvaos}</TD>
                          </c:if>
                          <c:if test="${salesBasicPo.ssesbrecipetype == '2'}">
                          <TD height="26">${salesOSPo.ssesbclosevaos}</TD>
                          </c:if>
                          <TD height="26">
                          <c:if test="${((salesOSPo.ssesborderstype)==1 && (salesOSPo.ssesbdragstype)=='0') || ((salesOSPo.ssesborderstype)==2 && (salesOSPo.ssesbdragstype)=='0') }"> 
			               	框镜成品
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==2 && (salesOSPo.ssesbdragstype)=='D' }"> 
			               	框镜订做
			               </c:if>
			               <c:if test="${((salesOSPo.ssesborderstype)==3 && (salesOSPo.ssesbdragstype)=='0') || ((salesOSPo.ssesborderstype)==4 && (salesOSPo.ssesbdragstype)=='0') }"> 
			               	隐形成品
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==4 && (salesOSPo.ssesbdragstype)=='D' }"> 
			               	隐形订做
			               </c:if>
                          </TD>
						</TR>					  
                      </TBODY>
                    </TABLE>
				<br/>
				<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR height="26" class=table_title align=middle>
						  <TH width="8%" scope=col>旧瞳距</TH>
						  <TH width="8%" scope=col>片高</TH>
						  <TH width="8%" scope=col>片宽</TH>
						  <TH width="7%" scope=col>中梁</TH>
						  <TH width="7%" scope=col>镜片通道</TH>
						  <TH width="7%" scope=col>对角线</TH>
						  <TH width="7%" scope=col>框型</TH>
						</TR>
                        <TR height="26" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${salesBasicPo.ssesboldeyesize}</TD>
                          <TD height="26">${salesBasicPo.ssesbglasshige}</TD>
                          <TD height="26">${salesBasicPo.ssesbglasswigth}</TD>
                          <TD height="26">${salesBasicPo.ssesbframemiddlesize}</TD>
                          <TD height="26">${salesBasicPo.ssesbgalssroad}</TD>
                          <TD height="26">${salesBasicPo.ssesbdiagonalline}</TD>
                          <TD height="26">${salesBasicPo.ssesbframeform}</TD>
						</TR>
                      </TBODY>
                    </TABLE>
				<br/>
				 <c:if test="${not empty(goodsInfoList[0].ssesdsalesitemid)}"> 
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="26" scope=col>商品代码</TH>
						  <TH width="18%" scope=col>商品名称 </TH>	
						<c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (salesBasicPo.ssesborderstype == '3' || salesBasicPo.ssesborderstype == '4')}">  
						  <TH width="9%" scope=col>效期</TH>
						  <TH width="9%" scope=col>批号</TH>
						  <TH width="9%" scope=col>注册证号</TH>
						</c:if>  					
						  <TH width="6%" scope=col>单价</TH>
						  <TH width="4%" scope=col>数量</TH>
						  <TH width="6%" scope=col>原价合计</TH>
						  <TH width="4%" scope=col>折扣率</TH>
						  <TH width="6%" scope=col>折扣金额</TH>
						  <TH width="6%" scope=col>抹零金额</TH>
						  <TH width="6%" scope=col>应收金额</TH>
						  <TH width="9%" scope=col>商品描述</TH>
						  </TR>
						<s:iterator value="goodsInfoList">
						  <c:choose>
                          	<c:when test="${goodsID==ssesdsalesitemid}">
	                    		<TR id="rowrow" class="row" style="background-color: red">
	                    	</c:when>
	                    	<c:otherwise>
	                    		<TR id="rowrow" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                    	</c:otherwise>
                          </c:choose> 
                          <TD height="26">${ssesdsalesitemid}</TD>
                          <TD>${ssesdsalesitemname}</TD>
                        <c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2') && (salesBasicPo.ssesborderstype == '3' || salesBasicPo.ssesborderstype == '4')}">  
						  <TD>${ssesdguaranteeperiod}</TD>
						  <TD>${ssesdbatch}</TD>
						  <TD>${ssesdregistrationnum}</TD>
						</c:if>
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
                    <br/>
                    <c:if test="${not empty(addititonalCDetailList)}"> 
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="25%" height="26" scope=col>附加费用名称</TH>
						  <TH width="25%" scope=col>附加费用金额 </TH>	
						  <TH width="25%" scope=col>数量 </TH>	
						  <TH width="25%" scope=col>附加费合计 </TH>					
						  </TR>
						<s:iterator value="addititonalCDetailList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${ssecostsname}</TD>
                          <TD>${sseamount}</TD>
                          <TD>${ssenumber}</TD>
                          <TD><fmt:formatNumber value="${ssesum}" type="currency" pattern="0.00"/></TD>
						</TR>
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