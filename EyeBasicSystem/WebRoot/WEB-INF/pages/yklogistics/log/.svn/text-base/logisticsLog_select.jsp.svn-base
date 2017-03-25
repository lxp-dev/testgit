<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>日志管理</title>		
<script type="text/javascript">
   	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	voucherSelFrm.action=link;
	  	voucherSelFrm.submit();
	}
	
   /**
    *  重置
    */        
	function clean(){
	    $('#clear').find("input").each(function(){
			$(this).val('');
		});
		$('#clear').find("select").each(function(){
			$(this).val('');
		});	
	}
	
   /**
    *  根据条件查询日志
    */        
	function search(){
	    voucherSelFrm.action = "selLogisticsLog.action";
	    voucherSelFrm.submit();
	}
	
	$(document).ready(function(){    		 
		$('span[id=logBillList]').each(function(){
			$(this).attr({style:"height:30px"});
		});
	});
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5>	
<DIV>
<form method="post" id="voucherSelFrm" action="">
<input id="parentID" name="parentID" type="hidden" value="${requestScope.parentID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;日志管理</TD>
          <TD class=menubar_readme_text vAlign=bottom></TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：日志查询</TD>
          <TD class=menubar_function_text align=right>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY> 
              <tr>             
                <TD>&nbsp;</TD>
              </TR>
              </TBODY></TABLE></TD></TR>
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
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">日志查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>										
					</TR></TBODY></TABLE></TD>
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
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="clear">
                      <TBODY>                      
                        <TR height="30px">
						  <TD class="table_body">日志日期</TD>
                          <TD class="table_none">
                           <input id="sLogStartDate"
					       name="sLogStartDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'sLogEndDate\')}'})"
					       value="${sLogStartDate }" /> 至 
					       <input id="sLogEndDate"
					       name="sLogEndDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'sLogStartDate\')}'})" 
					        value="${sLogEndDate }" />
					      </TD>
                          <TD class="table_body">财务人员</TD>
                          <TD class="table_none">
                            <select id="sLogName" name="sLogName">
                                <option value="">----请选择财务人员----</option>
                              <s:iterator value="personInfoLst">
                                <option value="${id}"} ${sLogNameTemp == id ? 'selected="selected"' : '' }>${personName}</option>
	     	                  </s:iterator>                            
                            </select>
                          </TD> 
                        </TR>
                        <TR height="30px">
                          <TD class="table_body">操作目标</TD>
                          <TD class="table_none">
                            <input type="text" class="text_input200" id="sLogContent" name="sLogContent" value="${sLogContent}">
                          </TD> 
                          <TD class="table_body">单据号</TD>
                          <TD class="table_none">
                            <input type="text" class="text_input200" id="sLogBillList" name="sLogBillList" value="${sLogBillList}">
                          </TD> 
                        </TR>
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<input icon='icon-search' type='button' value='查询' onclick="search()">
							<input type='button' value='清空' icon='icon-reset' onclick="clean()">
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(logisticsLogLst)}">
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
                          <TH scope=col width="3%" height="30">选择</TH> 
                          <TH scope=col width="10%" height="30">日志时间</TH>
						  <TH scope=col width="4%">财务人员</TH>						
                          <TH scope=col width="8%">机器IP</TH>
                          <TH scope=col width="3%">状态</TH>
                          <TH scope=col width="4%">操作种类</TH>						  
						  <TH scope=col width="9%">操作目标</TH>						  
						  <TH scope=col width="18%">相关单据</TH>
                        </TR>
                      <s:iterator value="logisticsLogLst">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28"><input type="checkbox"></TD>
                          <TD height="28">${sLogDate}</TD> 
                          <TD height="28">${sLogName}</TD> 
                          <TD height="28">${sLogIP}</TD> 
                          <TD height="28">${sLogResult}</TD> 
                          <TD height="28">${sLogOpID}</TD>  
                          <TD height="28">${sLogContent}</TD>                           
                          <TD height="28">           
                          <span id="logBillList" onmousemove="this.style.height='100px'" onmouseout="this.style.height='30px'">${sLogBillList}</span>
                          </TD>                       
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
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left"></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>