<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${companyNamePo.fcnName }</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function search(){
		$("img").removeAttr("onclick");
		warehouseForm.action = "weiXinIntegralSelectSel.action";
		warehouseForm.submit();		
		showLoadingBar();
	}
	function clean(){
		$("input[clean=clean]").val('');
		$("select[clean=clean]").val('');
	}
	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
	
	function today(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	function todayGive(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTimeGive').value = now;
		document.getElementById('endTimeGive').value = now;		
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="warehouseForm" method="post" action="">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>微信管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：微信积分兑换查询</TD>
            <TD align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title="显隐查询条件" btn=btn onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR height="26px;">
			               <TD width="9%" height="26" class="table_body">兑换状态</TD>
				           <TD class="table_none"  width="22%" >
				              	 <select clean=clean name="weiXinIntegralSelectPo.wieflag" value="${weiXinIntegralSelectPo.wieflag}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${weiXinIntegralSelectPo.wieflag!= "1"  ? '' : 'selected="selected"' }>已兑换</option>
							  		<option value="0" ${weiXinIntegralSelectPo.wieflag!= "0"  ? '' : 'selected="selected"' }>未兑换</option>
	                          </select>
				             </TD>
			             	<TD width="9%" height="26" class="table_body">门店</TD>
			              	<TD class="table_none"  width="26%">
			              	<select clean=clean id="cstidepartmentid" name="weiXinIntegralSelectPo.wiedepartmentid" >
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${weiXinIntegralSelectPo.wiedepartmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			             	 </TD>
						  <TD width="9%" height="26" class="table_body">兑换时间</TD>
			              <TD class="table_none" width="23%" >
			              	<li class="horizontal_onlyRight"><input id="startTimeGive"
					       name="weiXinIntegralSelectPo.startTimeGive" 
					       type="text" class="text_input80" clean=clean  
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${weiXinIntegralSelectPo.startTimeGive }" /> 至 
					       <input id="endTimeGive" clean=clean 
					       name="weiXinIntegralSelectPo.endTimeGive" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${weiXinIntegralSelectPo.endTimeGive }" /> </li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="todayGive()"></li>
			              </TD>
						  </TR>
						  <TR height="26px;">
						  <TD width="9%" height="26" class="table_body">电话</TD>
			              <TD class="table_none" width="23%" >
			              	<input clean=clean type="text" name="weiXinIntegralSelectPo.wiephone" id="phone" value="${weiXinIntegralSelectPo.wiephone }" class="text_input120" maxlength="11"> 
			              </TD>
			               <TD width="9%" height="26" class="table_body">会员姓名</TD>
			              <TD class="table_none"  width="22%" >
			              	<input clean=clean type="text" name="weiXinIntegralSelectPo.wiecustomername" id="customername" value="${weiXinIntegralSelectPo.wiecustomername }" class="text_input120"> 
			             	</TD>
			             	<TD width="9%" height="26" class="table_body">申请时间</TD>
			              	<TD class="table_none" width="26%">
			              		<li class="horizontal_onlyRight"><input id="startTime"
					       name="weiXinIntegralSelectPo.startTime" 
					       type="text" class="text_input80" clean=clean  
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${weiXinIntegralSelectPo.startTime }" /> 至 
					       <input id="endTime" clean=clean 
					       name="weiXinIntegralSelectPo.endTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${weiXinIntegralSelectPo.endTime }" /> </li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
			             	 </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
						<c:if test="${(permissionPo.keya==1)}">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" id="submitButton" btn=btn title='查询' onClick="javascript:search()">
	                       		<img src="${ctx }/img/newbtn/btn_empty_0.png" title="清空" btn=btn onClick="clean()">
	                        </td>
	                       </c:if>
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
                    <c:if test="${not empty(weiXinIntegralSelectPoList)}">		
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="9%" scope=col >会员姓名</TH>
                          <TH width="11%" height="26" scope=col>电话</TH>
                          <TH width="11%" scope=col>兑换门店</TH>
                          <TH width="10%" scope=col>申请时间</TH>
                          <TH width="8%" scope=col>兑换状态</TH>
                          <TH width="10%" scope=col>兑换时间</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>兑换积分</TH>
                        </TR>
                        <s:iterator value="weiXinIntegralSelectPoList">
                        <TR height="26px;" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                         <TD>${ wiecustomername}</TD>
                         <TD>${ wiephone}</TD>
                         <TD>${wiedepartmentname }</TD>
                         <TD>${fn:substring(wiecreatdate, 0, 10) }</TD>
                         <TD><c:if test="${wieflag==1}">已兑换</c:if><c:if test="${wieflag!=1}">未兑换</c:if></TD>
                         <TD>${fn:substring(wieexchangedate, 0, 10) }</TD>
                         <TD>${ wiegoodname}</TD>
                         <TD>${ wieintegral}</TD>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
