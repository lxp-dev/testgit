<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品批发管理</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		var needTotal=0;
		$('input[name=needNumber]').each(function(){
			needTotal=accAdd(needTotal,$(this).val());
		});
		$('#needTotal').text(needTotal);
	});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="smsFlag"  value="${smsFlag }" /> 
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD align="right" colspan="3">
             <s:action name="getFittingTemplateTypeInfo" executeResult="true">
				<s:param name="actionTypeID">33</s:param>
           		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
           		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&billid=${wholePo.cshawbillid}</s:param>
           		<s:param name="actionReportingServiceRequestString"></s:param>
           		<s:param name="actionReportTitle">客户批发调货申请单打印</s:param>
             </s:action>          
          </TD>
        </TR></TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
            </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">申请单号</TD>
                          <TD width="24%" class="table_none">${wholePo.cshawbillid}<input type="hidden" id="cshawbillid" name="cshawbillid" value="${wholePo.cshawbillid}"></TD>
                          <TD width="9%" class="table_body" height="26">申请部门</TD>
                          <TD width="24%" class="table_none">
                          ${wholePo.cshawoutdepartmentname}
                          </TD>					       
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none" >${wholePo.cshawcreatepersonname}<input type="hidden" name="wholePo.cshawcreateperson" value="${person.id}"></TD>		       
                        </TR>
                        <TR>
                          <TD class="table_body">制单日期</TD>
                          <TD class="table_none" colspan="5">
                          ${fn:substring(wholePo.cshawbilldate,0,16)}
                          </TD>	
						</TR>
                        <TR>
                          <TD class="table_body"  height="26">审核人</TD>
                          <TD class="table_none" > ${wholePo.cshawauditpersonname}&nbsp;</TD>
                          <TD class="table_body"  height="26">审核日期</TD>
                          <TD class="table_none" colspan="3"> ${fn:substring(wholePo.cshawauditdate,0,16)}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          ${wholePo.cshawremark}&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                       
                          <TH width="20%" scope=col height="28">商品代码</TH>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="25%" scope=col>型号</TH>
                          <TH width="15%" scope=col>零售价格</TH>
                          <TH width="10%" scope=col>需求数量</TH>      
                                        
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>		  	
						  	<TH scope=col width="5%" id="needTotal">0</TH>					    	
				   		</TR>
                        <s:iterator value="wholeEntryList" status="idx">
                        <TR class="row" height="26px">
                        <TD>${cshawegoodsid}</TD>
                        <TD>${cshawegoodsname}</TD>
                        <TD>${cshawespec}</TD>
                        <TD>${cshawebgiretailprice}<input type="hidden" class="text_input60" name="price" value="${cshawebgiretailprice}" /></TD>
                        <TD>${cshawerequirementquantity}<input type="hidden" class="text_input60" name="needNumber" value="${cshawerequirementquantity}" /></TD>                                                                              
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
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>