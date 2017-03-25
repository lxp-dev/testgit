<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员回访管理</title>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
</head>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="returnVisitForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="salesid" name="salesid" value="${requestScope.smecvsalesid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <!-- ?? End --><!-- ?? Start --></br>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="24%">${salesBasicPo.ssesbsalesid}</TD>
			               <TD width="8%" height="26" class="table_body">所属门店</TD>
			               <TD class="table_none" width="24%">${salesBasicPo.ssesbshopName}</TD>
						   <TD width="8%" height="26" class="table_body">会员姓名</TD>
			               <TD class="table_none">${salesBasicPo.ssesbpersonName}</TD>
                        </TR> 
                        <TR>
                           <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">${salesBasicPo.ssesbphone}</TD>
						   <TD height="26" class="table_body">配镜时间</TD>
			               <TD class="table_none">${fn:substring(salesBasicPo.ssesbsalesdatetime,0,19)}</TD>
			               <TD height="26" class="table_body">取镜时间</TD>
			               <TD class="table_none">${fn:substring(salesBasicPo.ssesbtakeglassdata,0,19)}</TD>
                        </TR> 
                        <TR>
						   <TD height="26" class="table_body">原价金额</TD>
			               <TD class="table_none"><fmt:formatNumber value='${salesBasicPo.ssesbpricesum}' pattern="0.00"/></TD>
			               <TD height="26" class="table_body">折扣金额</TD>
			               <TD class="table_none"><fmt:formatNumber value='${salesBasicPo.ssesbdiscountnum}' pattern="0.00"/></TD>
						   <TD height="26" class="table_body">应收金额</TD>
			               <TD class="table_none"><fmt:formatNumber value='${salesBasicPo.ssesbsalesvalue}' pattern="0.00"/></TD>
                        </TR>  
                        <TR>
                           <TD height="26" class="table_body">实缴金额</TD>
			               <TD class="table_none"><fmt:formatNumber value='${salesBasicPo.ssesbpsalsvalue}' pattern="0.00"/></TD>
						   <TD height="26" class="table_body">特殊加工要求</TD>
			               <TD class="table_none" colspan="3">
			               <font color="red">
			               		<c:if test="${not empty(specialPDetailList)}"> 
			               			<s:iterator value="specialPDetailList">
			               				${ssesdrequirement}&nbsp;&nbsp;&nbsp;&nbsp;
			               			</s:iterator>
			               		</c:if>
			               	</font>
			               </TD>
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
                        <TD height="26">
                          <c:if test="${(salesODPo.ssesborderstype)==1}"> 
			               	镜架成品
			               </c:if>
			               <c:if test="${(salesODPo.ssesborderstype)==2}"> 
			               	镜架订做
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==3}"> 
			               	隐形成品
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==4}"> 
			               	隐形订做
			               </c:if>
			             </TD>
                          <TD align="center">R</TD>
                          <TD>${salesODPo.ssesbballglassod}</TD>
                          <TD>${salesODPo.ssesbpostglassod}</TD>
                          <TD>${salesODPo.ssesbaxesod}</TD>
                          <TD>${salesODPo.ssesbaddod}</TD>
                          <TD>${salesODPo.ssesbarriseglassod}</TD>
                          <TD>${salesODPo.ssesbbasisod}</TD>
                          <TD>${salesODPo.ssesbprismod}</TD>
                          <TD>${salesODPo.ssesbinterhighod}</TD>
                          <TD>${salesODPo.ssesbinterdistanceod}</TD>
                          <TD>${salesODPo.ssesbfarvaod}</TD>
                          <TD>${salesODPo.ssesbclosevaod}</TD>
						</TR>
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						<TD height="26">
                          <c:if test="${(salesOSPo.ssesborderstype)==1}"> 
			              	 镜架成品
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==2}"> 
			               	镜架订做
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==3}"> 
			               	隐形成品
			               </c:if>
			               <c:if test="${(salesOSPo.ssesborderstype)==4}"> 
			               	隐形订做
			               </c:if>
			               </TD>
                          <TD align="center">L</TD>
                          <TD>${salesOSPo.ssesbballglassos}</TD>
                          <TD>${salesOSPo.ssesbpostglassos}</TD>
                          <TD>${salesOSPo.ssesbaxesos}</TD>
                          <TD>${salesOSPo.ssesbaddos}</TD>
                          <TD>${salesOSPo.ssesbarriseglassos}</TD>
                          <TD>${salesOSPo.ssesbbasisos}</TD>
                          <TD>${salesOSPo.ssesbprismos}</TD>
                          <TD>${salesOSPo.ssesbinterhighos}</TD>
                          <TD>${salesOSPo.ssesbinterdistanceos}</TD>
                          <TD>${salesOSPo.ssesbfarvaos}</TD>
                          <TD>${salesOSPo.ssesbclosevaos}</TD>
						</TR>					  
                      </TBODY>
                    </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="15%" height="26" scope=col>商品代码</TH>
						  <TH width="15%" scope=col>商品名称 </TH>						
						  <TH width="10%" scope=col>单价</TH>
						  <TH width="10%" scope=col>数量</TH>
						  <TH width="10%" scope=col>原价合计</TH>
						  <TH width="10%" scope=col>折扣率</TH>
						  <TH width="10%" scope=col>折扣金额</TH>
						  <TH width="10%" scope=col>应收金额</TH>
						  <TH width="10%" scope=col>商品描述</TH>
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
                          <TD>${ssesdsalesvalue}</TD>
                          <TD>${ssesdgooddescribe}</TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(addititonalCDetailList)}"> 
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="40%" height="26" scope=col>附加费用名称</TH>
						  <TH width="60%" scope=col>附加费用金额 </TH>						
						  </TR>
						  
						<s:iterator value="addititonalCDetailList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${ssecostsname}</TD>
                          <TD>${sseamount}</TD>
						</TR>
						</s:iterator>						  
                      </TBODY>
                    </TABLE>
                    </c:if>
                     <br/>
         <c:if test="${not empty(visitPoList)}">
                    <s:iterator value="visitPoList" >
                     <c:if test="${smecvreturntype == '2'}">
                    	<p><b>●${fn:substring(smecvfeedbackdate,0,11)}日回访信息</b></p>
                    <table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					<tr>
					<td>
                    
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                      	<TR>
                          <TD width="11%" height="30" class="table_body">会员卡号</TD>
                          <TD width="23%" class="table_none">${smecvmemberid}</TD>
                          <TD width="11%" class="table_body">姓名</TD>
                          <TD width="23%" class="table_none">${smecvcustomername}</TD>
                          <TD width="11%" class="table_body" >人群类型</TD>
						  <TD width="21%" class="table_none" >
      	                   	<c:if test="${smecvcustomertype == 1}">
                          		普通
                          	</c:if>
                          	<c:if test="${smecvcustomertype == 2}">
                          		高档
                          	</c:if>
                          	<c:if test="${smecvcustomertype == 3}">
                          		青少年渐进
                          	</c:if>
                          	<c:if test="${smecvcustomertype == 4}">
                          		成人渐进
                          	</c:if>
                          </TD>
                        </TR>   
                      	<TR>
                          <TD class="table_body" height="30">回访日期</TD>
                          <TD class="table_none">${fn:substring(smecvfeedbackdate,0,16)}</TD>
                          <TD class="table_body">回访满意度</TD>
                          <TD class="table_none">${smecvcontentment}</TD>
                          <TD class="table_body">反馈内容</TD>
                          <TD class="table_none">${smecvfeedbackcontent}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="60">解决方法</TD>
                          <TD colspan="5" class="table_none">
                          	${smecvresolvent}
                          </TD>
                        </TR>	  
                      </TBODY>
                    </TABLE>
                    </td>
                    </tr>
                    </table>
                    </c:if>                  
                    </s:iterator>
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