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
	  	optometryBasicForm.action=link;
	  	optometryBasicForm.submit();
	}
	function details(id,sopecid){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("detailEyesCheck.action?hid="+id+"&sopecid="+sopecid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("detailEyesCheck.action?hid="+id+"&sopecid="+sopecid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【病例信息】";
	}

	//打开配镜详细信息 
	 function printDetails(optometryID,optometryBasicID,dontshow){
	 	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initRefractiveSelect.action?optometryID="+optometryID+"&customerID="+'${customerID}'+"&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&dontshow="+dontshow,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initRefractiveSelect.action?optometryID="+optometryID+"&customerID="+'${customerID}'+"&optometryBasicID="+optometryBasicID+"&moduleID="+'${moduleID}'+"&dontshow="+dontshow,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【验光信息】";
    } 
	
</script>
<!--oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;"-->
<!--JavaScript:window.location.href='initDetailsCustomerInfo.action?hid="+'${customerInfoPo.smecicustomerid }' ';-->
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="optometryBasicForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="customerID" value="${customerID }">
<input type="hidden" id="dontshow" name="dontshow" value="${dontshow }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
                      onclick="JavaScript:window.location.href='initDetailsCustomerInfo.action?hid=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">会员详细</TD>
                    </TR></TBODY></TABLE></TD>
                      <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                        <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">病历信息</TD>
                   <TD width=3><IMG id=tabImgRight__1 height=22 
                    src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectVenditionInformation.action?customerID=${customerID}&dontshow=${dontshow }' ;" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">销售信息</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                     <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectReturnVisitInformation.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">顾客回访</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" width=3></TD> 
                        
                        <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectCustomerComplainByCustomer.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">顾客投诉</TD>
                      
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>  
                        
				<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='integralExpense.action?customerID=${customerID}&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">积分记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD> 
                    
                   <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='chuZhiKaExpense.action?customerID=${customerID }&dontshow=${dontshow }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">储值卡记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD> 
                    
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
                    <c:if test="${not empty(optometryBasics)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="8%" height="30" scope=col colspan="6">顾客验光记录</TH>
                        </TR>
                        <c:forEach var="basicPo" items="${optometryBasics}" varStatus="basicIndex">
                        <TR class=table_title align=middle>
                         <input type="hidden" id="smecicustomerid" name="customerInfoPo.smecicustomerid" class="text_input100" value="${customerInfoPo.smecicustomerid }">
                          <TH height="28" colspan="3">验光号：${basicPo.sopoboptometrybasicid }</TD>
						  <TH colspan="2">初验时间&nbsp;&nbsp;${fn:substring(basicPo.sopobmedicalstarttime, 0, 10) }</td>
                          <TH width="30%">复验结束时间&nbsp;&nbsp;${fn:substring(basicPo.sopobmedicalendtime, 0, 10) }</TD>
                        </TR>
                        <c:forEach var="optometry" items="${basicPo.optometrys}" varStatus="optometryIndex">
                       	<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                       		<TD height="28"><a href="javascript:void(0);" onclick="printDetails('${optometry.sopoyoptometryid }','${ basicPo.sopoboptometrybasicid}','1')" >${optometry.sopoyoptometryid}</a></TD>
                       		<TD height="28">${optometry.sopoydepartmentname }</TD>
                       		<TD height="28">${optometry.sopoypersonname }</TD>
                       		<TD height="28">${optometry.sopoyrownumber=='1'?'初验':'复验'}</TD>
                       		<TD height="28">${fn:substring(optometry.sopoytime, 0, 10) }</TD>
                       		<TD height="28">${optometry.sopoyflag == '0' ? '非正式提交' : '正式提交' }</TD>
                       	</TR>
                        </c:forEach>
                        
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					</c:if>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
