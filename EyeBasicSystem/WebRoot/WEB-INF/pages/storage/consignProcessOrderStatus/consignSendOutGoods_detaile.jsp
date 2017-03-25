<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外订单管理</title>
</head>
<script>	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="brandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>委外订单管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：委外发货详细</TD>
            <TD class=menubar_function_text height=27>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>               
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">订单发货详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD class="table_body" width="10%" height="30">发货单号</TD>
                          <TD class="table_none" width="30%">
                          	${fn:substring(procurementSendPo.cstdid,5,31)}
                          </TD>
                          <TD class="table_body" width="10%">关联订单号</TD>
                          <TD class="table_none">
                          	${fn:substring(procurementSendPo.cstdpoid,5,31)}
					      </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="30">发货人</TD>
                          <TD class="table_none">
						  	${procurementSendPo.cstdcreatepersonname}
						  </TD>
						  <TD class="table_body">客户名称</TD>
						   <TD height="30" align="left" class="table_none">
						   	${procurementSendPo.cstdcustomername}
						 </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="30">发货日期</TD>
                          <TD class="table_none">
						  	${fn:substring(procurementSendPo.cstdbilldate,0,10)}
						  </TD>
						  <TD class="table_body">订单状态</TD>
						   
						 <TD height="30" align="left" class="table_none">
                          <c:if test="${procurementSendPo.cstdauditstate==0 }">
                          	正在加工
                          </c:if>
                            <c:if test="${procurementSendPo.cstdauditstate==1 }">
                          	制造商备货
                          </c:if>
                          <c:if test="${procurementSendPo.cstdauditstate==2 }">
                          	制造商发货
                          </c:if>
                          </TD>
                          
                        </TR>
                      </TBODY>
                    </TABLE>
					<c:if test="${not empty(sendEntryList)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="30" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>型号</TH>
                          <TH width="10%" scope=col>颜色</TH>
                          <TH width="10%" scope=col>球镜</TH>
						  <th width="10%" scope=col>柱镜</th>
                          <TH width="10%" scope=col>轴向</TH>
						  <TH width="8%" scope=col>下加</TH>
						  <TH width="8%" scope=col>棱镜</TH>
						  <TH width="8%" scope=col>基底</TH>
						  <TH width="8%" scope=col>订单数量</TH>
						  <TH width="8%" scope=col>发货数量</TH>
                        </TR>
                        <c:forEach var="po" items="${sendEntryList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28">${po.cstdegoodsname }</TD>
                          <TD>${po.cstdespec }</TD>
                          <TD>${po.cstdecolor }</TD>
                          <TD>${po.cstdeballglass }</TD>
						  <td>${po.cstdepostglass }</td>
                          <TD>${po.cstdeaxis }</TD>
                          <TD>${po.cstdeadd }</TD>
                          <TD>${po.cstdearriseglass }</TD>
                          <TD>${po.cstdebasis }</TD>
                          <TD>${po.cstdeordernumber }</TD>
                          <TD>${po.cstdedeliverynumber }</TD>
                        </TR>
                        </c:forEach>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
  
	
    </BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
