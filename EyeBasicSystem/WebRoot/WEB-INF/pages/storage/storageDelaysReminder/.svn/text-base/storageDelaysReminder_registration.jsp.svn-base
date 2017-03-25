<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	consignProcessReceiptForm.action=link;
	  	consignProcessReceiptForm.submit();
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	/*接收信息*/
	function addGoods(json){
		//document.getElementById('ssesbsalesid').value = json.ssesbsalesid;
		//document.getElementById('ssesbtakeglassdata').value = json.ssesbtakeglassdata;
		//document.getElementById('ssesbshopcode').value = json.ssesbshopcode; 
	}
	
	/*查询*/
	function selCustomer(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSalesBasicSel.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSalesBasicSel.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
		
    }
    
    
    /*订单查询*/
	function selCustomer1(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initOrderDelaysRemindert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initOrderDelaysRemindert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
		
    }
    
    
	 /*光标聚焦*/
	window.onload=function(){
		document.getElementById('salesid').focus();  
	}

	/**
	 *回车事件
	 */
	function selectCustomer(){
		var keyCode = event.keyCode?event.keyCode:event.which?event.which:event.charCode;
		if(keyCode == 13){
			storageDelaysReminderRegistrationForm.action = "selectSalesBasicODOS.action";
			storageDelaysReminderRegistrationForm.submit();
		}	
    }
    
    /*传值*/
	//function setCustomer(ssesbsalesid ,ssesbshopcode, ssesbshopName, ssesbcustomerid, ssesbtakeglassdata ){
	function setCustomer(ssesbsalesid ,ssesbtakeglassdata ){
		document.getElementById('salesid').value = ssesbsalesid;
		//document.getElementById('shopcode').value = ssesbshopcode;
		//document.getElementById('shopName').value = ssesbshopName;
		//document.getElementById('customerid').value = ssesbcustomerid;
		//document.getElementById('mirrorcheckdate').value = ssesbtakeglassdata;
		storageDelaysReminderRegistrationForm.action = "selectSalesBasicODOS.action";
		storageDelaysReminderRegistrationForm.submit();
	}
	
     /*保存*/
     function save(){
     	if(checkForm(storageDelaysReminderRegistrationForm)){
			$("img").removeAttr("onclick");
			storageDelaysReminderRegistrationForm.action = "insertDelaysReminder.action";
			storageDelaysReminderRegistrationForm.submit();
		}
	}

			
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="storageDelaysReminderRegistrationForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" value="${salesBasicPo.ssesbcustomerid }">
<input type="hidden" name="moduleID" value="${requestScope.moduleID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
		  </TD>
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
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                      <TABLE width="100%" id="title1" border=0 align=center cellPadding=0 cellSpacing=1 class="Privateborder">
                      <TR>
                        <TD width="9%" class="table_body " height="26">配镜单号</TD>
                        <TD width="24%" class="table_none ">
                        <li class="horizontal_onlyRight">
                        	<input id="salesid" name="salesid" class="text_input160" value="${salesBasicPo.ssesbsalesid }" onkeydown="selectCustomer();">
                        </li><li class="horizontal_onlyRight">
                          	<img src="${ctx }/img/newbtn/btn_search_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx 

}/img/newbtn/btn_search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_search_0.png');" title='查询' onclick="selCustomer();">
                          	
                        </li></TD>
						<TD width="9%" class="table_body ">所属门店</TD>
                        <TD width="24%" class="table_none ">&nbsp;${salesBasicPo.ssesbshopName }
                        	<input id="shopName" name="shopName" type="hidden" class="text_input100" value="${salesBasicPo.ssesbshopName }" readonly="readonly"></TD>
                        	<input id="shopcode" name="shopcode" type="hidden" class="text_input100" value="${salesBasicPo.ssesbshopcode }" readonly="readonly"></TD>
                      	<TD width="9%" class="table_body" height="26" >原取镜时间</TD>
                        <TD class="table_none">&nbsp;${fn:substring(salesBasicPo.ssesbtakeglassdata, 0, 19) }
                        	<input id="mirrorcheckdate" type="hidden" name=mirrorcheckdate class="text_input100" 
                        		value="${fn:substring(salesBasicPo.ssesbtakeglassdata, 0, 19) }" readonly="readonly"></TD>
                      </TR>
                    </TABLE>
                    <BR/>
				<c:if test="${not empty(salesODPo)}"> 
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
						  <TH width="12%" scope=col>右眼(R)/左眼(L)</TH>						
						  <TH width="8%" scope=col>球镜Sph</TH>
						  <TH width="8%" scope=col>柱镜Cyl</TH>
						  <TH width="8%" scope=col>轴向Axis</TH>
						  <TH width="7%" scope=col>add</TH>
						  <TH width="7%" scope=col>三棱镜</TH>
						  <TH width="7%" scope=col>基底</TH>
						  <TH width="7%" scope=col>棱镜</TH>
						  <TH width="7%" scope=col>远用瞳距PD</TH>
						  <TH width="7%" scope=col>近用瞳距PD</TH>
						  <TH width="7%" scope=col>远用VA</TH>
						  <TH width="7%" scope=col>近用VA</TH>
						  <TH height="26" width="10%" scope=col>镜片种类</TH>
						  </TR>
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD align="center" height="26">R</TD>
                          <TD height="26">${salesODPo.ssesbpostglassod}</TD>
                          <TD>${salesODPo.ssesbpostglassod}</TD>
                          <TD>${salesODPo.ssesbaxesod}</TD>
                          <TD>${salesODPo.ssesbaddod}</TD>
                          <TD>${salesODPo.ssesbarriseglassod}</TD>
                          <TD>${salesODPo.ssesbbasisod}</TD>
                          <TD>${salesODPo.ssesbprismod}</TD>
                          <TD>${salesODPo.ssesbinterhighod}</TD>
                          <TD>${salesODPo.ssesbinterdistanceod}</TD>
                          <TD>${salesODPo.ssesbfarvaod}</TD>
                          <TD>${salesODPo.ssesbclosevaod}</TD>
			              <TD height="26"><c:if test="${(salesODPo.ssesborderstype)==1}">镜架成品</c:if><c:if test="${(salesODPo.ssesborderstype)==2}">镜架订做</c:if>
			              <c:if test="${(salesOSPo.ssesborderstype)==3}">隐形订做</c:if><c:if test="${(salesOSPo.ssesborderstype)==4}">隐形订做</c:if>
			              </TD>
						</TR>
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD align="center" height="26">L</TD>
                          <TD>${salesOSPo.ssesbballglassos}</TD>
                          <TD>${salesOSPo.ssesbpostglassos}</TD>
                          <TD>${salesOSPo.ssesbaxesos}</TD>
                          <TD>${salesOSPo.ssesbaddos}</TD>
                          <TD>${salesOSPo.ssesbarriseglassos}</TD>
                          <TD>${salesOSPo.ssesbbasisos}</TD>
                          <TD>${salesOSPo.ssesbprismos}</TD>
                          <TD>${salesOSPo.ssesbinterhighos}</TD>
                          <TD>${salesOSPo.ssesbinterdistanceos}</TD>
                          <TD>${salesOSPo.ssesbfarvaos}</TD>
                          <TD>${salesOSPo.ssesbclosevaos}</TD>
                          <TD height="26"><c:if test="${(salesOSPo.ssesborderstype)==1}">镜架成品</c:if><c:if test="${(salesOSPo.ssesborderstype)==2}">镜架订做</c:if>
                          <c:if test="${(salesOSPo.ssesborderstype)==3}">隐形订做</c:if><c:if test="${(salesOSPo.ssesborderstype)==4}">隐形订做</c:if>
                          </TD>
						</TR>					  
                      </TBODY>
                    </TABLE>
                    </br>
				<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						 <TD width="12%" height="26" class="table_body">预计取镜日期</TD>
                           <TD class="table_none">
                             <input class="text_input100"
				               id="expectedcheckdate"
						       name="expectedcheckdate" value="${requestScope.expectedcheckdate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('expectedcheckdate').value}" 
						       validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写预计取镜日期！'}]"
						       readonly="readonly" />
			               </TD>
                        </TR>
                        <TR>
                          <TD class="table_body">误期原因</TD>
                           <TD class="table_none"><textarea name="causesdelays" id="causesdelays" value="${requestScope.causesdelays }"
                           		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写误期原因！'}]" ></textarea></TD>
						  </TR>
                        </TBODY>
                    </TABLE>
                     <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
					   <TR>
						  <TD align="left"><img src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" 

onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" id="submitButton" title='保存' onClick="save()">
						  </TD>
                        </TR>                     
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
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>