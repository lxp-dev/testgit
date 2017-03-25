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
		showPopWin("","detailEyesCheck.action?hid="+id+"&sopecid="+sopecid,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
</script>
<!--oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;"-->
<!--JavaScript:window.location.href='initDetailsCustomerInfo.action?hid="+'${customerID }' ';-->
<body   ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="venditionInformationForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="customerID" value="${customerID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY> 
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员管理</TD>
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
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：销售信息</TD>
            <TD class=menubar_function_text align=right>
             <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
             </TR></TBODY></TABLE>
            </TD>
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
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                   
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initDetailsCustomerInfo.action?hid=${customerID }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">会员详细</TD>
                      	<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectOptometryInformation.action?customerID=${customerID }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">病历信息</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD> 
                      	<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectVenditionInformation.action?customerID=${customerID }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">销售信息</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD> 
                     <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">刷卡记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
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
                  <%--
                  <input type="hidden" name="readOnly" value="readOnly" /> --%>
<!--                  <s:action name="initCustomerOptometryTitleN" executeResult="true" />-->
				 <c:if test="${not empty(rechargeRecordPoList)}"> 
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
                          <TH width="15%" height="30" scope=col>刷卡计费类型</TH>
						  <TH width="15%" scope=col>检查充值卡号</TH>
						  <TH width="10%" scope=col>顾客名称</TH>
						  <TH width="10%" scope=col>门店名称</TH>
						  <TH width="10%" scope=col>操作人</TH>
						  <TH width="15%" scope=col>操作时间</TH>
						  <TH width="10%" scope=col>金额</TH>

						  </TR>
						 <s:iterator value="rechargeRecordPoList">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                           <TD height="28">
	                          <c:if test="${sserrflag==1}">充值</c:if>
	                          <c:if test="${sserrflag==2}">验光检查</c:if>
	                          <c:if test="${sserrflag==3}">销售</c:if>
	                          <c:if test="${sserrflag==4}"> 清零退费</c:if>
	                          <c:if test="${sserrflag==5}">工本费</c:if>
	                          </TD>
	                          <TD>${sserrcardid}</TD>
	                          <TD>${sserrcustomeridname}</TD>
							  <td>${sserrshopcodename}</td>
	                          <TD>${sserrcreatepersonname}</TD>
	                          <TD>${fn:substring(sserrdate,0,16)}</TD>
                          	  <TD>${sserramount}</TD>
	                        </TR>
                         </s:iterator>	
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
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