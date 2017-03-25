<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    </HEAD>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	/**
	 *销售结款弹窗
	 */
	function cashOpen(id,ssesborderstype){
		if('${bwcflag}' == ''){
			alert("请设置本部门出仓配置！");
			return;
		}
		var moduleID = $('input[name=moduleID]').val();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selGuitarManagementOpen.action?hid="+id+"&moduleID="+moduleID+"&ssesborderstype="+ssesborderstype,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selGuitarManagementOpen.action?hid="+id+"&moduleID="+moduleID+"&ssesborderstype="+ssesborderstype,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【银台结款】";
    }
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【顾客信息】";
	}
	
	/**
	 *聚焦
	 */
	 $(document).ready(function() {	
		 if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
				document.getElementById('smecimemberid').focus(); 
	        }
		var printflag = '${param.print}';
		if(printflag == '1'){
			DataURL="report.action?reportlet=print_salesPreSales.cpt&ssepsid=${param.salseID}&did=${person.departmentID}";
    		window.open (DataURL, '无库存销售预付定金单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
		}
	});
	
	/**
	 *查看
	 */
	function selCustomerInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
    }
    
    function deleteSalesID(salesid){
    	var moduleID = $('input[name=moduleID]').val();
    	
    	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initGuitarManagementDelete.action?salesid=" + salesid + "&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【配镜单删除】";
    }
    
    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "initInsertPreSalesCustomerS.action";
		guitarMangermentForm.submit();
	}
	
	
    function printReport(ordertype,id){
        if ($.trim('${systemParameterPo.fspsalesbillname1}') == '' || $.trim('${systemParameterPo.fspsalesbillname3}') == '' || $.trim('${systemParameterPo.fspsalesbillname5}') == ''){
            alert('请先配置配镜单样式!');
            return;
        }
        
    	var DataURL='';
    	if(ordertype=='1' || ordertype=='2'){
    		DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1}&wflag=1&salesid="+id;		
    	}else if(ordertype=='3' || ordertype=='4'){
    		DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3}&wflag=1&salesid="+id;
		}else{
			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5}&wflag=1&salesid="+id;
		}
    	window.open (DataURL, '结款单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
    }
    
    function save(){

    	if($("#ssepsremark").val().length > 200){
			alert("备注中填写的内容不能超过200字，请重新填写！");
			$("#ssepsremark").focus();
			return;
		}
		
    	if(!$("#ssepspricesum").val()){
			alert("请填写应收金额！");
			$("#ssepspricesum").focus();
			return;
		}
		
		if(!$("#ssepssalesvalue").val()){
			alert("请填写缴费金额");
			$("#ssepssalesvalue").focus();
			return;
		}
		
		if(!$("#ssepssaler").val()){
			alert("请选择销售员！");
			$("#ssepssaler").focus();
			return;
		}
		
		if(!$("#ssepsposer").val()){
			alert("请选择收银员！");
			$("#ssepsposer").focus();
			return;
		}
		
		if(!$("#ssepstakeglasstime").val()){
			alert("请选择取镜日期！");
			$("#ssepstakeglasstime").focus();
			return;
		}
    
		if(checkForm(guitarMangermentForm)){ 
			if(!confirm('请确认提交！')){
				return;
			}
		
			$("img").removeAttr("onclick");	
			guitarMangermentForm.action = 'insertPreSalesCustomerS.action';
		    guitarMangermentForm.submit();
		}
	}
	
	function clean(){
		guitarMangermentForm.reset();
	}
	
function selectCust(flag){
    if(flag){
	    $("img").removeAttr("onclick");
		guitarMangermentForm.action = "initInsertPreSalesCustomerS.action";
		guitarMangermentForm.submit();
    }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(event.keyCode == 13){
		var memberId=document.getElementById('smecimemberid').value;
			if(memberId==''){
				return false;
			}
			$("img").removeAttr("onclick");
			guitarMangermentForm.action = "initInsertPreSalesCustomerS.action";
			guitarMangermentForm.submit();
	}
	 
}	
window.onload=function(){
    if('${isGO}'=='1' && $('#smecimemberid').val() == ''){
    	$('img[his=his]').trigger("click");
	}
}
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="guitarMangermentForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：无库存销售</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3" align=right><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
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
                      <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">无库存销售结款</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                  <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initSelectPreSalesCustomerS.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">无库存销售记录查询</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                     </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD>
				</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif ><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <fieldset>
						<legend>顾客资料</legend>
						<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <tr height="26">
					        <td bgcolor="#cadee8">
					          
					          <li class="horizontal">卡号&nbsp;
					                <input type="text" id="smecimemberid" name="memberid" class="text_input100" value="${customerInfoPo.smecimemberid }"
					                 onkeyup="selectCustomer();"${systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' } >
					                <input type="hidden" name="preSalesPo.ssepscustomerid" value="${customerInfoPo.smecicustomerid }">
					          </li>
					            <li class="horizontal">
					              <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
					              <img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					            </li>
							   
					          <li class="horizontal">姓名&nbsp;
					                <input class="text_input60" readOnly="readOnly" value="${customerInfoPo.smeciname }">
					          </li>
					          <li class="horizontal">性别&nbsp;
					                <input value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">年龄&nbsp;
					                <input value="${customerInfoPo.fmmage }" class="text_input40" readOnly="readOnly">
					          </li>
					          <li class="horizontal">&nbsp;
					          <c:if test="${empty(customerInfoPo.smecicustomerid)}"></c:if>
					          <c:if test="${not empty(customerInfoPo.smecicustomerid)}">
					            <img src="${ctx }/img/newbtn/btn_details_0.png" btn=btn name="button32" title='详情' onClick="javascript:details('${customerInfoPo.smecicustomerid }');" >
					          </c:if>
					          </li>
					      </tr>
					    </table>
					</fieldset>
                    <TABLE id=ctl00_PageBody_PostButton  cellSpacing=0 cellPadding=0 width="100%" border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
							<div align="right">
							  &nbsp;
							</div>
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(customerInfoPo.smecicustomerid)}"> 
                    <br/>
                    <table width="90%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateTable privateBorder">
                      <TBODY>
                        <TR>
                          <TD width="12%" height="26" scope=col class="table_body" align="center">应收金额</TD>
                          <TD width="12%" scope=col class="table_none">
							<input class="text_input100" type="text" id="ssepspricesum" name="preSalesPo.ssepspricesum" value="" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '填写的金额不正确！'}]">	
						  </TD>
                          <TD width="12%" scope=col class="table_body" align="center">缴费金额</TD>
                          <TD width="12%" scope=col class="table_none" colspan="3">
                          	<input class="text_input100" type="text" id="ssepssalesvalue" name="preSalesPo.ssepssalesvalue" value="" validate="[{'Type' : Type.String, 'Formula' : Formula.FloatORNULL, 'Message' : '填写的金额不正确！'}]">
                          </TD>
                        </TR>
                        <TR>
                          <TD width="12%" height="26" scope=col class="table_body" align="center">销售员</TD>
                          <TD width="12%" scope=col class="table_none"> 
                          	<SELECT id="ssepssaler" name="preSalesPo.ssepssaler">
                          		<option value="">----请选择----</option>
								<c:forEach var="po" items="${salers}">
									<option value="${po.id }" ${person.id != po.id ? '':'selected=selected'}>${po.personName }</option>
								</c:forEach>
							</SELECT>
                          </TD>
                          <TD width="12%" scope=col class="table_body" align="center">收银员</TD>
                          <TD width="12%" scope=col class="table_none">
                          	<SELECT id="ssepsposer" name="preSalesPo.ssepsposer">
                          		<option value="">----请选择----</option>
								<c:forEach var="po" items="${posers}">
									<option value="${po.id }" ${person.id != po.id ? '':'selected=selected'}>${po.personName }</option>
								</c:forEach>
							</SELECT>
                          </TD>
                          <TD width="12%" scope=col class="table_body" align="center">取镜日期</TD>
                          <TD width="12%" scope=col class="table_none">
                          	<input class="text_input100"
				               id="ssepstakeglasstime"
						       name="preSalesPo.ssepstakeglasstime" value=""
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,minDate:'%y-%M-%d'})"
						       readonly="readonly"/>
                          </TD>
                        </TR>
                        
                        <TR>
                          <TD width="12%" height="26" scope=col class="table_body" align="center">备注</TD>
                          <TD scope=col class="table_none" colspan="5">
							<textarea id="ssepsremark" name="preSalesPo.ssepsremark"></textarea>
						  </TD>
                        </TR>
                        
                      </TBODY>
                    </TABLE>
                        <br/>
                    <TABLE width="100%"> 
                      <TBODY>
                        <TR align="center">
                          <td>
                          	<img src="${ctx }/img/newbtn/btn_pay_0.png" name="pay" btn=btn title='缴费' onclick="save();">&nbsp;
                            <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
                          </td>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </c:if>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif colspan="2"><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
