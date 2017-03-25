<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css">
</style>
<script type="text/javascript">
	
	function details(id){
		showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function diffPriceOpen(salesid){
	    var customerID=document.getElementById('customerID').value;
		showPopWin("","diffPriceOpen.action?salesID="+salesid+"&customerID="+customerID,screen.width-100,screen.height-100, '',null,true);
		selectHidden();
	}
	function select(salesid){
		showPopWin("","diffPriceSel.action?salesID="+salesid,screen.width-100,screen.height-100, '',null,true);
		selectHidden();
	}	
	
	
	
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form methed="post" name="arrearsForm">
<input type="hidden" id="customerID" name="customerID" value="${customerInfoPo.smecicustomerid }"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD class=menubar_readme_text vAlign=bottom></TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：退差价管理</TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif><TABLE cellSpacing=0 cellPadding=0 border=0>
            <TBODY>
              <TR>
                <!--ťStart-->
                <TD><TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD width=3><IMG id=tabImgLeft__0 height=22 
													src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx}/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">退差价管理</TD>
                        <TD width=3><IMG id=tabImgRight__0 height=22 
													src="${ctx}/img/pic/tab_active_right.gif" 
												width=3></TD>
                      </TR>
                    </TBODY>
                </TABLE></TD>
                
               
              </TR>
            </TBODY>
          </TABLE></TD></TR>
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
				  <fieldset>
						<legend>顾客资料</legend>
                        <table width="98%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                          <tr>
                            <td bgcolor="#cadee8"><li class="horizontal">卡号&nbsp;
                                    <input name="customerInfoPo.smecimemberid" id="smecimemberid" value="${customerInfoPo.smecimemberid }" onkeyup="selectCustomer();" class="text_input100" size="6">
                              </li>
                                <li class="horizontal">
                                  <input name="button22" type='button' value='查找' onclick="selCustomer()" icon='icon-search' >
                                </li>
                              <li class="horizontal">销售单号&nbsp;
                                  <input id="salesid" name="salesid" class="text_input160" onkeyup="selectSales();">
                              </li>
                              <li class="horizontal">姓名&nbsp;
                                  <input  class="text_input60" size="2" value="${customerInfoPo.smeciname }" readOnly="readOnly">
                              </li>
                              <li class="horizontal">性别&nbsp;
                                  <input class="text_input40" size="2" value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" readOnly="readOnly">
                              </li>
                              <li class="horizontal">年龄&nbsp;
                                    <input  class="text_input40" size="2" value="${customerInfoPo.fmmdown }" readOnly="readOnly">
                                </li>
                              <li class="horizontal">&nbsp;
                                <input name="button32" type='button' value='详情' align="left" onClick="details('${customerInfoPo.smecicustomerid }')">
                              </li>
                            </tr>
                        </table>
				  </fieldset>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
							<div align="right">
							  &nbsp;
</div></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(diffPriceList)}">
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="11%" height="30" scope=col>销售单号</TH>
                          <TH width="11%" scope=col>顾客姓名</TH>
                            <TH width="11%" scope=col>销售日期</TH>
                          <TH width="11%" scope=col>原价合计</TH>
                           
                          <TH width="11%" scope=col>折扣金额</TH>
                            <TH width="11%" scope=col>应收金额</TH>
                           <TH width="11%" scope=col>查看</TH>
                          <TH width="11%" scope=col>缴费</TH>
                          
                          </TR>
                          <s:iterator value="diffPriceList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28">${ssesbsalesid }</TD>
                          <TD>${ssesbpersonName }</TD>
                          <TD>${fn:substring(ssesbsalesdatetime,0,10)}</TD>
                            <TD>${ ssesbpricesum}</TD>
                              
                                <TD>${ ssesbdiscountnum}</TD>
                                  <TD>${ssesbsalesvalue }</TD>
                                    <TD><input name="button32234" type='button' value='查看' align="left" onClick="select('${ssesbsalesid}')"></TD>
                                    
                                 
                          <TD><input name="button3223" icon="icon-add-row" type='button' value='缴费' align="left" onClick="diffPriceOpen('${ssesbsalesid}')"></TD>
                          		
                          
                          </TR>
                      </s:iterator>
                      </TBODY>
                    </TABLE>
                    </c:if>
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
    </form></BODY>
</HTML>
    <script>
document.getElementById('smecimemberid').focus();  

function selectCustomer(){
	if(document.getElementById('smecimemberid').value.trim() != '')
		if(event.keyCode == 13)
			document.forms[0].action="initDiffPrice.action";
			document.forms[0].submit();
}

function selectSales(){
	if(document.getElementById('salesid').value.trim() != '')
		if(event.keyCode == 13)
			document.forms[0].action="initDiffPrice.action";
			document.forms[0].submit();
}

function details(id){
	showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
	selectHidden();
}	
function selCustomer(){
	showPopWin("","initSelCustomerInfoWin.action", screen.width-200,screen.height-200, '',null,true);
	selectHidden();
}
function setCustomer(memberid){
	document.getElementById('smecimemberid').value = memberid;
	document.forms[0].submit();
}

</script>