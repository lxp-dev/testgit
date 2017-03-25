<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>期末处理</title>
</head>
<script>

	$(document).ready(function(){
		$("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });	
	    	
	});
	
	function autoCostAccount(){

		if ('${switchAmountMonth}' == ''){
            alert('请先对当前公司初始化账期后，才能进行成本计算!');
            return;
		}
		
        if ($('#qcmonth').val() == ''){
            alert('请先导入期初成本，在进行成本计算!');
            return;
        }
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
    	showPopWin("initAutoCostAccount.action?moduleID=${moduleID}&dqmonth="+$('#dqmonth').val(),500,260,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【成本计算】";	
	}

	function autoCostAccount1(){
		
		if ('${switchAmountMonth}' == ''){
            alert('请先对当前公司初始化账期后，才能进行成本计算!');
            return;
		}
		
        if ($('#qcmonth').val() == ''){
            alert('请先导入期初成本，在进行成本计算!');
            return;
        }

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
    	showPopWin("initCostAccountNotBill.action?moduleID=${moduleID}&dqmonth="+$('#dqmonth').val(),500,260,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【计算加权平均成本】";		
	}

	function autoCostAccount2(){

		if ('${switchAmountMonth}' == ''){
            alert('请先对当前公司初始化账期后，才能进行成本计算!');
            return;
		}
		
        if ($('#qcmonth').val() == ''){
            alert('请先导入期初成本，在进行成本计算!');
            return;
        }

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
    	showPopWin("initCostAccountBill.action?moduleID=${moduleID}&dqmonth="+$('#dqmonth').val(),500,260,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【立即进行成本计算】";		
	}

</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<form method="post" name="calForm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" name="qcmonth" id="qcmonth" value="${qcAccountPeriod }">
<input type="hidden" name="dqmonth" id="dqmonth" value="${switchAmountMonth }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="9%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;财务管理</TD>
           <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：成本计算</TD>
        </TR>
        <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
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
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initSwitchAmount.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">结账</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">成本计算</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
          
           <c:if test="${permissionPo.keye == '1'}">    	          
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initMoniSelect.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">查看成本</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
           </c:if>         	
                    	 	
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
							<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>

                    <TABLE id="searchBar" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                    <c:if test="${systemParameterPo.fspcbjstype eq '2'}">  
                        <TR>
                           <TD height="26" class="table_body">所属公司</TD>				   
						   <TD class="table_none" colspan="3">${person.personcompanyname }&nbsp;</TD>
						</TR>	
					</c:if>	
						<TR>
						   <TD height="26" class="table_body" width="10%">期初账期</TD>
						   <TD class="table_none" width="40%">${qcAccountPeriod }&nbsp;</TD>
						   <TD class="table_body" width="10%">当前账期</TD>
						   <TD class="table_none"width="40%">${switchAmountMonth }&nbsp;</TD>
						</TR>                    
                      </TBODY>
                    </TABLE>
                  	
                  	<table id="title2" cellspacing="2" width="100%">
                      <TBODY>
						   <c:if test="${permissionPo.keyc == '1'}">							    
		                        <TR>
		                          <TD>
		                              <li class="horizontal_onlyRight">
		                                <img btn=btn id="btn1" src="${ctx }/img/newbtn/btn_zdcbjs_0.png" title='自动成本计算' onclick="autoCostAccount()">
		                              </li>
		                              <li class="horizontal_onlyRight">  
		                                <strong><label style="color: red">*单击此按钮后,晚间将根据所选账期的跨度，逐次进行成本计算，计算出各账期的加权平均成本!</label></strong>
		                              </li>				 
		                              </TD>
		                        </TR>
		                  </c:if>
		                  
		                  <c:if test="${permissionPo.keya == '1'}">
		                        <TR>
		                          <TD>
		                              <li class="horizontal_onlyRight">
		                                <img btn=btn id="btn1" src="${ctx }/img/newbtn/btn_jsjqpjcb_0.png" title='计算加权平均成本' onclick="autoCostAccount1()">
		                              </li>
		                              <li class="horizontal_onlyRight">  
		                                <strong><label style="color: red">*单击此按钮后,将根据所选账期的跨度，立即并逐次计算出各账期的加权平均成本，但不回填单据!</label></strong>
		                              </li>				 
		                              </TD>
		                        </TR>
		                  </c:if> 
		                       
		                  <c:if test="${permissionPo.keyb == '1'}">
		                        <TR>
		                          <TD>
		                              <li class="horizontal_onlyRight">
		                                <img btn=btn id="btn1" src="${ctx }/img/newbtn/btn_ljjxcbjs_0.png" title='立即进行成本计算' onclick="autoCostAccount2()">
		                              </li>
		                              <li class="horizontal_onlyRight">  
		                                <strong><label style="color: red">*单击此按钮后,将根据所选账期的跨度，立即并逐次进行成本计算，计算出各账期的加权平均成本!</label></strong>
		                              </li>				 
		                           </TD>
		                        </TR>
		                   </c:if>
		                   
                      </TBODY>
                    </TABLE>
	                    
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
					<c:if test="${not empty(acapList)}">
						<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
	                       <TBODY>
	                         <TR>
	                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
	                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
	                         </TR>
	                       </TBODY>
	                    </TABLE>	
					    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
		                      <TBODY>
	                           <TR class=table_title align=middle>
	                           <c:if test="${systemParameterPo.fspcbjstype eq '2'}">  
		                          <TH width="25%" height="26" scope=col>所属公司</TH>
		                       </c:if>   
		                          <TH width="15%" height="26" scope=col>账期</TH>
		                          <TH width="25%" scope=col>点击自动成本计算时间</TH>
		                          <TH width="25%" scope=col>自动成本计算结束时间</TH>
								  <th width="10%">自动计算状态</th>
		                        </TR>
		                        <s:iterator value="acapList"> 
		                        	<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                        	<c:if test="${systemParameterPo.fspcbjstype eq '2'}">  
			                          <TD height="26">${latcacompanyname}</TD>
			                        </c:if>
			                          <TD height="26">${latcapaymentday}</TD>
			                          <TD>${latcacreatedate}</TD>
			                          <TD>${latcaexecdate}</TD>
									  <td>${latcaflag eq '1' ? '计算完成' : '未计算'  }</td>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>