<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜发料管理</title>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
</head>
<script>	
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="spectaclesMaterialsForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="salesid" name="salesid" value="${requestScope.ssesbsalesid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px；" 
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="24%">${salesBasicPo.ssesbsalesid}</TD>
			               <TD width="9%" height="26" class="table_body">所属门店</TD>
			               <TD class="table_none" width="24%">${salesBasicPo.ssesbshopName}</TD>
			               <TD width="9%" height="26" class="table_body">配镜类型</TD>
			               <c:if test="${(salesBasicPo.ssesborderstype)==1}"> 
			               <TD class="table_none">镜架成品</TD>
			               </c:if>
			               <c:if test="${(salesBasicPo.ssesborderstype)==2}"> 
			               <TD class="table_none" >镜架订做</TD>
			               </c:if>
                        </TR> 
                        <TR>
			               <TD height="26" class="table_body">配镜日期</TD>
			               <TD class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,16)}</TD>
						   <TD height="26" class="table_body">取镜日期</TD>
			               <TD class="table_none">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,16)}</TD>
			               <TD height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none">${salesBasicPo.ssesbpersonName}</TD>
                        </TR> 
                        <TR>
						   <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">${salesBasicPo.ssesbphone}</TD>
			               <TD height="26" class="table_body">发料人</TD>
			               <TD class="table_none">${sessionScope.person.personName}</TD>
						   <TD height="26" class="table_body">发料时间</TD>
			               <TD class="table_none">
			               		${fn:substring(salesBasicPo.ssesbmaterialsdate,0,16)}
                           </TD>
                        </TR>                   
                      </TBODY>
                    </TABLE>
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
                          <TH height="26" width="10%" scope=col>镜片种类</TH>
						  <TH width="10%" scope=col>右眼(R)/左眼(L)</TH>						
						  <TH width="8%" scope=col>球镜</TH>
						  <TH width="8%" scope=col>柱镜</TH>
						  <TH width="8%" scope=col>轴向</TH>
						  <TH width="7%" scope=col>add</TH>
						  <TH width="7%" scope=col>三棱镜</TH>
						  <TH width="7%" scope=col>基底</TH>
						  <TH width="7%" scope=col>棱镜</TH>
						  <TH width="7%" scope=col>远用瞳距</TH>
						  <TH width="7%" scope=col>近用瞳距</TH>
						  <TH width="7%" scope=col>远用VA</TH>
						  <TH width="7%" scope=col>近用VA</TH>
						  </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <c:if test="${(oDPo.ssesborderstype)==1}"> 
			               <TD height="26">镜架成品</TD>
			               </c:if>
			               <c:if test="${(oDPo.ssesborderstype)==2}"> 
			               <TD height="26">镜架订做</TD>
			               </c:if>
                          <TD align="center">R</TD>
                          <TD>${oDPo.ssesbballglassod}</TD>
                          <TD>${oDPo.ssesbpostglassod}</TD>
                          <TD>${oDPo.ssesbaxesod}</TD>
                          <TD>${oDPo.ssesbaddod}</TD>
                          <TD>${oDPo.ssesbarriseglassod}</TD>
                          <TD>${oDPo.ssesbbasisod}</TD>
                          <TD>${oDPo.ssesbprismod}</TD>
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          <TD>${oDPo.ssesbinterdistanceod}</TD>
                          <TD>${oDPo.ssesbfarvaod}</TD>
                          <TD>${oDPo.ssesbclosevaod}</TD>
						</TR>
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <c:if test="${(oSPo.ssesborderstype)==1}"> 
			               <TD height="26">镜架成品</TD>
			               </c:if>
			               <c:if test="${(oSPo.ssesborderstype)==2}"> 
			               <TD height="26">镜架订做</TD>
			               </c:if>
                          <TD align="center">L</TD>
                          <TD>${oSPo.ssesbballglassos}</TD>
                          <TD>${oSPo.ssesbpostglassos}</TD>
                          <TD>${oSPo.ssesbaxesos}</TD>
                          <TD>${oSPo.ssesbaddos}</TD>
                          <TD>${oSPo.ssesbarriseglassos}</TD>
                          <TD>${oSPo.ssesbbasisos}</TD>
                          <TD>${oSPo.ssesbprismos}</TD>
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          <TD>${oSPo.ssesbinterdistanceos}</TD>
                          <TD>${oSPo.ssesbfarvaos}</TD>
                          <TD>${oSPo.ssesbclosevaos}</TD>
						</TR>					  
                      </TBODY>
                    </TABLE>

					  <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="20%" height="26" scope=col>商品代码</TH>
						  <TH width="15%" scope=col>商品名称 </TH>						
						  <TH width="15%" scope=col>右眼(R)/左眼(L)</TH>
						  <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
						  <TH width="20%" scope=col>商品条码</TH></c:if>
						  <TH width="20%" scope=col>发出仓位</TH>
						  </TR>
						  
						<s:iterator value="goodsInfoList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26" id="goodsid">${ssesdsalesitemid}</TD>
                          <TD>${ssesdsalesitemname}</TD>
                          <TD>${ssesdglassflag}</TD>
                          <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
                          <TD>${ssesditemid}</TD>
                          </c:if>
                          <TD>${ssesdstockname}</TD>
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
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>