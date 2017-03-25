<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
<title>报表中心</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 
	
	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action = "initReportQuartzDataDetail.action";
		goodsForm.submit();
		showLoadingBar();
	}
	
	function clean(){
		document.getElementById('bgnDate').value = "";
		document.getElementById('endDate').value = "";
		document.getElementById('quartzID').value = "";
		document.getElementById('passsecond').value = "";		
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	<br/></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
						   <TD width="8%" height="26" class="table_body">定时任务</TD>
			               <TD class="table_none" width="20%">
	                            <select id="quartzID" name="quartzID">
	      		                 	<option value="">----请选择----</option>
					               	  <s:iterator value="moduleList">
	                    	           <OPTION value="${reportID}" ${quartzID == reportID ? 'selected="selected"' : '' }>${reportName}</OPTION>
	                    	          </s:iterator>
	      	                     </select>
			               </TD>
			               <TD width="8%" height="26" class="table_body">查看日期</TD>
			               <TD class="table_none">
	                            <li class="horizontal_onlyRight"><input id="bgnDate"
						            name="bgnDate" 
						            type="text" class="text_input80" clean=clean  
						            onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'maxlastdate\')}', maxDate:'#F{$dp.$D(\'endDate\')}'})"
						            value="${bgnDate }" /> 至 
						       <input id="endDate" clean=clean 
						            name="endDate" 
						            type="text" class="text_input80" 
						            onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'bgnDate\') || $dp.$D(\'maxlastdate\')}'})"
						            value="${endDate }" /> </li><li class="horizontal_onlyRight">
								<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('bgnDate','endDate')"></li>
								<input type="hidden" value="${maxlastdate}" name="maxlastdate" id="maxlastdate">
							</TD>
					       <TD width="8%" height="26" class="table_body">执行状态</TD>
			               <TD class="table_none" width="20%">
	                            <select id="quartzFlag" name="quartzFlag">
	                                <option value="1" ${quartzFlag == '1' ? 'selected="selected"' : '' }>未执行</option>	      		                 	
	      		                 	<option value="2" ${quartzFlag == '2' ? 'selected="selected"' : '' }>已执行</option>
	      		                 	<option value="4" ${quartzFlag == '4' ? 'selected="selected"' : '' }>全部任务</option>
	      	                     </select>
			               </TD>
                        </TR>                        	
					  	<TR>
			               <TD width="8%" height="26" class="table_body">执行时间超过</TD>
			               <TD class="table_none" colspan="5">
								<input type="text" class="text_input60" value="${passsecond}" name="passsecond" id="passsecond" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请填写整数！'}]">&nbsp;&nbsp;秒
							</TD>
                        </TR>   
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
							</td>
						</tr>
					</table>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
			    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
				<c:if test="${not empty(quartzLogList)}"> 
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
                          <TH width="4%" scope=col>数据处理日期</TH>
                          <TH width="10%" height="26" scope=col>定时任务名称</TH> 
                          <TH width="6%" scope=col>定时时间</TH>                         
						  <TH width="12%" scope=col>执行时间</TH>
						  </TR>
						<s:iterator value="quartzLogList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${sysqllrdate}</TD>
                          <TD>${sysqllrquartzname}</TD>
                          <TD>${sysqllquartztime}</TD>
                          <TD>${fn:substring(sysqllrbgndate,0,19)}&nbsp;至&nbsp;${fn:substring(sysqllrenddate,0,19)}</TD>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
