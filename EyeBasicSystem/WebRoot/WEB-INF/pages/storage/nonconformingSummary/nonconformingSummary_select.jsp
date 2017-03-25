<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>不合格品单管理</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" /> 
<!-- jquery.autocomplete end -->

<script>	
	function search(){
		document.all.submitButton.disabled="true";
		nonconformingForm.action = "selNonconformingSummary.action";
		nonconformingForm.submit();
	}
	
	function clean(){
	    document.all.cshanstartTime.value="";
	    document.all.cshanendTime.value="";
	}	
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    function summaryNonconforming(){
    	var chk=document.getElementsByName("chk");
        for(var i=0;i<chk.length;i++){
           if(chk[i].checked){
           		break;
           	}
           	if ( i + 1 == chk.length){
           		alert('请选择不合格品单！');
           		return ;
           	}
        }
        
        document.all.summaryButton.disabled="true";
		nonconformingForm.action = "summaryNonconforming.action";
		nonconformingForm.submit();
    }

</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="nonconformingForm" method="post" action="">
<input type="hidden" name="hid">
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
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>不合格品单管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：不合格品单汇总</TD>
            <TD class=menubar_function_text align=right>
            &nbsp;</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--ťStart-->
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initNonconformingSel.action?moduleID=${requestScope.moduleID}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">不合格品单查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                  <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">不合格品单汇总</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					</TR>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="14%" class="table_body">单据日期</TD>
                          <TD class="table_none"><input
                          	id="cshanstartTime"
					       name="cshanstartTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'cshanendTime\')}'})" 
					       readonly="readonly" value="${cshanstartTime }" />
                            至
                            <input
                           id="cshanendTime"
					       name="cshanendTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'cshanstartTime\')}'})" 
					       readonly="readonly" value="${cshanendTime }" /></TD>
                          </TR>
                       
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left" height="30">
							<input icon='icon-search' id="submitButton" name="submitButton" type='button' onclick="search();" value='查询' >
							<input name="reset" type='button' value='重置' icon='icon-reset' onclick="clean()" ></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(nonconformingList)}">
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
					  <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                          </TABLE>
							<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                              <TH scope=col width="5%" height="30"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="20%" height="30">不合格品单号</TH>
						  <TH scope=col width="12%">申请部门</TH>						
                          <TH scope=col width="10%">审核状态</TH>
						  <TH scope=col width="10%">制单人</TH>
						  <TH scope=col width="11%">制单日期</TH>
						  </TR>
						<c:forEach items="${nonconformingList }" var="nonconforming" >
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28"><input type="checkbox" id="chk" name="cshanbillid" value="${nonconforming.cshanbillid }" ></TD>
						  <TD height="28">${nonconforming.cshanbillid }</TD>
						  <TD>${nonconforming.cshandepartmentname }</TD>
                          <TD>已审核</TD>
						  <TD>${nonconforming.cshancreatepersonname }</TD>
                          <TD>${fn:substring(nonconforming.cshancreatedate, 0, 10) }</TD>
                          </TR>
                          </c:forEach>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left"><input icon='icon-save' id="summaryButton" name="summaryButton" type='button' value='汇总' onclick="summaryNonconforming()" /></TD>
                        </TR>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
    <%@ include file="/WEB-INF/inc/message.jsp" %>