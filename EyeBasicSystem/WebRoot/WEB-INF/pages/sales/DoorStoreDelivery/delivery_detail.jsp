<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>配送单查询</title>
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
	
    function printReport(){
		var id='';
		$('input[pjdh=pjdh]').each(function(){
			id=id+$(this).val()+"','";
		})
		id=id.substring(0, id.length-3);		
    	var url="report.action?reportlet=sales_shopCodeDistrisRpt.cpt&salesID="+id;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【配送单】";		
    }

	function winPopUpS(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单详细】";
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>

<form name="procurementOrdersForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20">
            <td width=auto align="right" valign="top">
            	<!-- <img src="${ctx}/img/newbtn/btn_print_0.png" btn=btn title="打印单据" onclick="printReport();">  -->
            </td>
        </tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD>          
        </TR> 
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
					<table width="100%" id="title0"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder" border=0>
                      <TBODY>
                        <TR>
                          <TD height="26" width="9%" class="table_body">配送单号</TD>
                          <TD width="24%" class="table_none">${distributionPo.sdndnid }&nbsp;</TD>
                          <TD width="9%" class="table_body">配送时间</TD>
                          <TD width="24%" class="table_none">${fn:substring(distributionPo.sdndncreatedate,0,16) }&nbsp;</TD>
                          <TD width="9%" class="table_body">配送人</TD>
                          <TD width="24%" class="table_none">
                          ${distributionPo.sdndnPerson }&nbsp;
                          </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body"><c:if test="${distributionPo.sdndntype=='1'}">配送</c:if><c:if test="${distributionPo.sdndntype!='1'}">取镜</c:if>门店</TD>
                          <TD class="table_none">
                          ${distributionPo.sdndnshopcode}&nbsp;
                          </TD>
                          <TD height="26" class="table_body">制单人</TD>
                          <TD class="table_none" colSpan=3>
                          ${distributionPo.sdndnlogonpersonname}&nbsp;
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
						  <TH scope=col width="17%" height="26">配镜单号</TH>
						  <TH scope=col width="7%">顾客姓名</TH>
                          <TH scope=col width="7%">取镜门店</TH>
                          <TH width="10%" scope=col>取镜时间</TH>
                          <TH width="6%" scope=col>配镜类型</TH>                       
                        </TR>
                       <s:iterator value="distributionEntryList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><a href="#" onclick="javascript:winPopUpS('${sdndesalesid}')" style="cursor:hand">${sdndesalesid}</a><input type="hidden" value="${sdndesalesid}" pjdh=pjdh /></TD>
                          <TD>${sdndemembername}</TD>
                          <TD>${sdndeshopcode }</TD>
                          <TD>${fn:substring(sdndetakeDate,0,16) }</TD>             			   
                          <TD>
                              <c:choose>
                                  <c:when test="${sdndeorderstype=='1' }">框镜成品</c:when>
                                  <c:when test="${sdndeorderstype=='2' }">框镜订制</c:when>
                                  <c:when test="${sdndeorderstype=='4' }">隐形订制</c:when>
                                  <c:otherwise>&nbsp;</c:otherwise>
                              </c:choose>
                          </TD>                
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
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>