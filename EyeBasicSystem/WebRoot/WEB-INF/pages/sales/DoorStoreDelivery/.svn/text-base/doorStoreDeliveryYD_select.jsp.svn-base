<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门店配送</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerInfoForm.action=link;
	  	customerInfoForm.submit();
	}
	/*修改事件  */
	function updateState(id){
		if(checkForm(document.all.doorStoreDeliveryForm)){
				if($('input[name=ssesbsalesid]:checked').length==0){
					alert("请选择修改配镜单号!");
					return;
				}	
		}
		if ($('#InTransitCount').val() == 0){
		    alert("此功能对应的在途点已被停用,请先启用!");
		    return;
		}
		$("img").removeAttr("onclick");
		doorStoreDeliveryForm.action = "updateDoorStoreDelivery.action";
		doorStoreDeliveryForm.submit();
	}
	
	function doorStoreDelivery_JD(){
		$("img").removeAttr("onclick");
		doorStoreDeliveryForm.action = "selectDoorStoreDelivery.action?type=2";
		doorStoreDeliveryForm.submit();
	}
	
	function doorStoreDelivery(){
		$("img").removeAttr("onclick");
		doorStoreDeliveryForm.action = "selectDoorStoreDelivery.action?type=1";
		doorStoreDeliveryForm.submit();
	}
	
	
	function search(){
		$("img").removeAttr("onclick");
		customerInfoForm.action = "selCustomerInfo.action";
		customerInfoForm.submit();
	}

	function permissionMessage(){
       alert('您无此操作权限');
	}


		/* 全选事件  */
    function check_all(obj,chk){
		 	
		var checkboxs = document.getElementsByName(chk);
		for(var i=0;i<checkboxs.length;i++){checkboxs[i].checked = obj.checked;}
	}

	
	/*判断打印按钮是否为空 */
	function printReport(id){
		if(checkForm(document.all.doorStoreDeliveryForm)){
				if($('input[name=ssesbsalesid]:checked').length==0){
					alert("请选择配镜单号!");
					return;
				}	
		}
		if ($('#InTransitCount').val() == 0){
		    alert("此功能对应的在途点已被停用,请先启用!");
		    return;
		}
		
		/* 显示Id */
		var id='';
		$('input[name=ssesbsalesid]:checked').each(function(){
			id=id+$(this).val()+"','";
		})
		id=id.substring(0, id.length-3);
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("report.action?reportlet=sales_shopCodeDistrisRpt.cpt&salesID="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("report.action?reportlet=sales_shopCodeDistrisRpt.cpt&salesID="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【门店配送单】";
	}

	function openPersonScan(id){
		if(checkForm(document.all.doorStoreDeliveryForm)){
			if($('input[name=ssesbsalesid]:checked').length==0){
				alert("请选择配镜单号!");
				return;
			}	
		}
		if ($('#InTransitCount').val() == 0){
		    alert("此功能对应的在途点已被停用,请先启用!");
		    return;
		}
		
		var salesids = ""; 
		var salestypes = "";
		$("input[name=ssesbsalesid]:checked").each(function (){
			salesids = salesids + $(this).val()+",";
			salestypes = salestypes + $("select[sid="+$(this).val()+"]").val()+",";
		});
		salesids = salesids.substring(0,salesids.length-1);
		salestypes = salestypes.substring(0,salestypes.length-1);
		$("#salesids").val(salesids);
		$("#salestypes").val(salestypes);
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initPensonScan.action",400,70,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPensonScan.action",400,70,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【员工卡扫描】";
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="doorStoreDeliveryForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="customerID" value="${requestScope.smecicustomerid }">
<input type="hidden" name="ssesborderstype" value="${salesBasicPoList[0].ssesborderstype}">
<input type="hidden" id="InTransitCount" name="InTransitCount" value="${InTransitCount}">
<input type="hidden" id="salesids" name="salesids" value="">
<input type="hidden" id="salestypes" name="salestypes" value="">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>门店配送</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：门店配送</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                      onclick="doorStoreDelivery()"
                      UNSELECTABLE="on">门店镜架成品配送</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="doorStoreDelivery_JD()"
                      UNSELECTABLE="on">门店镜架订做配送</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">门店隐形订做配送</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR>
					
					</TBODY>
				  </TABLE>
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
                           <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				<c:if test="${not empty(salesBasicPoList)}"> 
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR class=table_title align=middle>
						<TH height="30" scope=col>全选 <input type="checkbox" id="chks" onclick="check_all(this,'chk')">
                          <TH width="25%" scope=col>配镜单号</TH>
                          <TH width="15%" scope=col>顾客姓名<input type="hidden" id="ssesbcustomerid" name="ssesbcustomerid" class="text_input100" value="${customerInfoPo.smecicustomerid }"></TH>
                          <TH width="15%" scope=col>取镜门店</TH>
                          <TH width="20%" scope=col>取镜时间</TH>
                          <TH width="15%" scope=col>配镜类型</TH>
                         </TR>
		
					 <s:iterator value="salesBasicPoList">
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28"><input type="checkbox" id="chk" name="ssesbsalesid" value="${ssesbsalesid }"></TD>
                          <TD>${ssesbsalesid }</TD>
                          <TD>${ssesbpersonName }</TD>
                          <TD>${ssesbtakeshopname }</TD>
             			   <input type="hidden" name="location" value="${ssesblocation }">
                          <TD>${ssesbtakeglassdata }</TD>
                  <c:choose>
					<c:when test="${ssesborderstype == 1 }">
                          <TD>镜架成品片</TD>
                    </c:when> 
                    <c:when test="${ssesborderstype == 2 }">
                          <TD><select id="DragsType" name="ssesbdragstype" sid="${ssesbsalesid }">
												<option value="1" ${requestScope.ssesbdragstype!= "1"  ? '' : 'selected="selected"'}>委外订单</option>
												<option value="2" ${requestScope.ssesbdragstype!= "2"  ? '' : 'selected="selected"'}>委外加工</option>
 											</select></TD>
                    </c:when>      
                    <c:when test="${ssesborderstype == 4 }">
                          <TD><input id="DragsType" type="hidden" name="ssesbdragstype" sid="${ssesbsalesid }">
								委外加工
 						  </TD>
                    </c:when>      
                  </c:choose>     
                        </TR>
					  </s:iterator>	
                      </TBODY>
                    </TABLE>
                 <c:if test="${(permissionPo.keya==1)}"> 
                    <table id="title2" cellspacing="2">
					   <TR>
						   <TD height="30" valign="bottom"><img name="button" src="${ctx }/img/newbtn/btn_print_0.png" btn=btn title='打印单据' onClick="javascript:printReport('${ssesbsalesid }')" ></TD>
						   <TD valign="bottom"><img name="reset" id="submitButton" src="${ctx }/img/newbtn/btn_updatestate_0.png" btn=btn title='修改状态' onClick="openPersonScan('${ssesbsalesid }' )" ></TD>
					   </TR>
					</table>
				</c:if>
	               </c:if>
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