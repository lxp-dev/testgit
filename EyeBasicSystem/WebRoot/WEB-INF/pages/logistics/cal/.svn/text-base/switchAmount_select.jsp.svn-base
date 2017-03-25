<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>开关账管理</title>
</head>
<script>	
	
	function save(jzflag){

		if ('${switchAmountMonth}' == ''){
            alert('请先对当前公司初始化账期后，才能进行结账或反结账!');
            return;
		}
		
		if (jzflag == 'g' && '${zxcount}' == '0'){
            alert('请先对当前账期进行成本计算后，才能结转至下个月!');
            return;
		}

		var msg = '确认结账?';
		if (jzflag == 'k'){
			msg = '确认反结账?';
		}

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
    	showPopWin("initSwitchAmountInsert.action?moduleID=${moduleID}&jz="+jzflag+"&dqmonth=${switchAmountMonth}",500,260,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【" + msg + "】";	
	}
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    
    }); 
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<form method="post" name="switchAmountFrm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" value="${switchAmountMonth }" name="switchAmountMonth">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="8%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;财务管理</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：结账</TD></TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR></TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
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
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">结账</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    	                                        
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initCalSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">成本计算</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
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

                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
						    
					<c:if test="${systemParameterPo.fspcbjstype eq '2'}">  
                        <TR>
                           <TD height="26" class="table_body" width="10%">所属公司</TD>				   
						   <TD class="table_none" width="90%">${person.personcompanyname }&nbsp;</TD>
						</TR>	
					</c:if>	
						<TR>
						   <TD height="26" class="table_body">当前账期</TD>
						   <TD class="table_none">${switchAmountMonth }&nbsp;</TD>				    
						</TR>
						    
                      </TBODY>
                    </TABLE>
                    
                  	<table id="title2" cellspacing="2" width="100%">
                      <TBODY>					    
		                  <TR>
		                      <TD>
		                          <li class="horizontal_onlyRight">  
                                      <img btn=btn id="btn1" src="${ctx }/img/newbtn/btn_qrjz_0.png" title='确认结账' onClick="save('g')" >		
                                  </li>
		                          <li class="horizontal_onlyRight">  
		                              <strong><label style="color: red">*只有当前账期内进行过成本计算后，才能进行结账!</label></strong>
		                          </li>		 
		                      </TD>
		                  </TR>

		                  <TR>
		                      <TD>
		                      	  <li class="horizontal_onlyRight">
                                      <img btn=btn id="btn1" src="${ctx }/img/newbtn/btn_qrfjz_0.png" title='确认反结账' onClick="save('k')" >
                                  </li>
		                          <li class="horizontal_onlyRight">  
		                              <strong><label style="color: red">*确认反结账后,将当前账期调整为前一个月份!</label></strong>
		                          </li>		 
		                      </TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>