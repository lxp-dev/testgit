<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
			document.getElementById('smecimemberid').focus(); 
        }
		
		//系统参数设置中，是否补款后打印配镜单
		 if (${printSalesbill eq '1'}){
			setReportEvent('${salesid}','${orderType}','0','1');
		 } 
	});

	/**
	 * 配镜单打印主程序入口
	 * @id	配镜单号；
	 * @billType	配镜单销售类型；1：框架成品；2：框架定制；3:隐形成品；4：隐形定制；5：辅料；
	 * @dingjinFlag	是否欠款；1：欠款；
	 * @wflag	打印类型；1：销售；-1：退款；（为''空时，表示1)
	 */
	function setReportEvent(id,billType,dingjinFlag,wflag){	
		var DataURL='';

		//2、打印配镜单
    	if(billType=='1' || billType=='2'){
    		if (wflag == '' || wflag=='1'){
    			if ($.trim('${systemParameterPo.fspsalesbillname1}') == ''){
    	            alert('请先配置框架配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver1}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver1}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname1}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        }
	        }else if(wflag=='-1'){
	        	if ($.trim('${systemParameterPo.fspsalesbillname1tui}') == ''){
		            alert('请先配置框架退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver1tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver1tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname1tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        }
	        }   			
    	}else if(billType=='3' || billType=='4'){
    		if (wflag == '' || wflag=='1'){
        		if ($.trim('${systemParameterPo.fspsalesbillname3}') == ''){
    	            alert('请先配置隐形配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver3}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver3}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname3}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        }
	        }else if(wflag=='-1'){
	    		if ($.trim('${systemParameterPo.fspsalesbillname3tui}') == ''){
		            alert('请先配置隐形退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver3tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver3tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname3tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        }
	        } 
	    }else if(billType=='5'){
    		if (wflag == '' || wflag=='1'){
        		if ($.trim('${systemParameterPo.fspsalesbillname5}') == ''){
    	            alert('请先配置辅料配镜单样式!');
    	            return;
    	        }else{
    	    		if($.trim('${systemParameterPo.fspsalesbillserver5}') =="1"){
    	    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
    	    		}else if($.trim('${systemParameterPo.fspsalesbillserver5}') =="2"){
    	    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
    	    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname5}&salesID="+id+"&rs:Command=Render";	
    	    		}
    	        } 
	        }else if(wflag=='-1'){
	    		if ($.trim('${systemParameterPo.fspsalesbillname5tui}') == ''){
		            alert('请先配置辅料退款配镜单样式!');
		            return;
		        }else{
		    		if($.trim('${systemParameterPo.fspsalesbillserver5tui}') =="1"){
		    			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5tui}&__bypagesize__=false&wflag="+ wflag +"&salesid="+id;
		    		}else if($.trim('${systemParameterPo.fspsalesbillserver5tui}') =="2"){
		    			DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname5tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        } 
	        }		    		    
		}else{
			alert("单据类型异常！");
			return;
		}
	    window.open (DataURL, '结款单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');

	    //3、天津眼科弹出的第二个报表
	    if(wflag=='1' || wflag == ''){
	    	printGSL('${departmentID}',id,dingjinFlag); 
	    }else if(wflag=='-1'){
	    	printGSL_TH('${departmentID}',id);
	    }	      
	}
	
	function pay2(json,ssesbsalesid,flag){
	   
        if ('${systemParameterPo.fsphisflag}' == '2' && '${person.bdplinkhisflag}' == '1' && flag == '0'){
        	alert('此单收费项目HIS系统中未收费，不能补齐!');
            return;
        }
        
		var moduleID = document.getElementById("moduleID").value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initArrearsOpen.action?arg0="+json+"&moduleID="+moduleID+"&ssesbsalesid="+ssesbsalesid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initArrearsOpen.action?arg0="+json+"&moduleID="+moduleID+"&ssesbsalesid="+ssesbsalesid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【补齐欠款】";
	}

	function winPopUp(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
	}

	function cashOpen2(id){ 
		var moduleID = $('input[name=moduleID]').val();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initArrearNotChargeInfoToHisInsert.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【提交收费项目】";
    }
	
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<BODY bgColor=#ffffff topMargin=5   ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form methed="post" name="arrearsForm">
<input id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="customerID" value="${customerInfoPo.smecicustomerid }"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：欠款管理</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
				  <fieldset>
						<legend>顾客资料</legend>
                        <table width="98%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                          <tr>
                            <td bgcolor="#cadee8">
                              <li class="horizontal">卡号&nbsp;
                                    <input name="customerInfoPo.smecimemberid" id="smecimemberid" value="${customerInfoPo.smecimemberid }" 
                                    onkeydown="selectCustomer();" class="text_input100" size="6" ${systemParameterPo.fsphisflag == '2'&& person.bdplinkhisflag == '1' ? 'readonly=readonly':'' }>
                              </li>
                                <li class="horizontal">
                                  <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
                                  <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn name="button22" title='查找' onclick="selCustomer()">
                                </li>
                                
                              <li class="horizontal">销售单号&nbsp;
                                  <input name="salesID" class="text_input160" onkeyup="judgekey();">
                              </li>
                              <li class="horizontal">姓名&nbsp;
                                  <input  class="text_input60" size="2" value="${customerInfoPo.smeciname }" readOnly="readOnly">
                              </li>
                              <li class="horizontal">性别&nbsp;
                                  <input class="text_input40" size="2" value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" readOnly="readOnly">
                              </li>
                              <li class="horizontal">年龄&nbsp;
                                    <input  class="text_input40" size="2" value="${customerInfoPo.fmmage }" readOnly="readOnly">
                                </li>
                              <li class="horizontal">&nbsp;
                              <c:if test="${empty(customerInfoPo.smeciname) }">
                              </c:if>
                              <c:if test="${not empty(customerInfoPo.smeciname) }">
                                <img src="${ctx }/img/newbtn/btn_details_0.png" btn=btn name="button32" title='详情' onClick="details('${customerInfoPo.smecicustomerid}')">
                              </c:if>
                              </li>
                            </tr>
                        </table>
				  </fieldset>
				  <br/>
                    <c:if test="${not empty(arrearsList)}">
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                           <c:choose>
                              <c:when test="${permissionPo.keyc==1 && systemParameterPo.fsphisflag==2 && person.bdplinkhisflag==1}">
                                  <TH width="9%" scope=col colspan="3">操作</TH>
                              </c:when>
                              <c:otherwise>
                                  <TH width="6%" scope=col colspan="2">操作</TH>
                              </c:otherwise>
                           </c:choose>                          
                           
                           <TH height="26" scope=col>销售单号</TH>
                           <TH width="11%" scope=col>顾客姓名</TH>
                           <TH width="11%" scope=col>销售日期</TH>
                           <TH width="11%" scope=col>原价合计</TH>
                           <TH width="11%" scope=col>应收金额</TH>
                           <TH width="11%" scope=col>折扣金额</TH>
                           <TH width="11%" scope=col>实缴金额</TH>
                           <TH width="11%" scope=col>欠款金额</TH>
                          </TR>
                          <s:iterator value="arrearsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" align="center">
                          <TD height="26" width="3%">
                            <img src="${ctx }/img/newbtn/search_0.png" name="button32234" title='详情' btn=btn onClick="winPopUp('${ssesbsalesid}')">
                          </TD>
                          
                          <c:if test="${permissionPo.keyc==1 && systemParameterPo.fsphisflag==2 && person.bdplinkhisflag==1}">
	                          <TD width="3%">
	                              <c:if test="${ssesbnothisflag == 0}">
	                                  <img src="${ctx }/img/newbtn/payfee_0.png" name="pay" btn=btn title='提交待收费信息' onclick="cashOpen2('${ssesbsalesid}')">
	                              </c:if>
	                          </TD>
                          </c:if>
                                                                                                                                   
                          <TD width="3%"><img src="${ctx }/img/newbtn/pay_0.png" btn=btn title='缴费' onClick=pay2("'ssesbsalesid':'${ssesbsalesid}','ssesbpersonName':'"+EncodeUtf8("${ssesbpersonName}")+"','ssesbsalesdatetime':'${fn:substring(ssesbsalesdatetime,0,10)}','ssesbpricesum':'${ssesbpricesum}','ssesbsalesvalue':'${ssesbsalesvalue}','ssesbdiscountnum':'${ssesbdiscountnum}','ssesbpsalsvalue':'${ssesbpsalsvalue}','ssesbarrearsvalue':'${ssesbarrearsvalue}','ssesbjfamount':'${ssesbjfamount}','ssesborderstype':'${ssesborderstype}'",'${ssesbsalesid }','${ssesbhispayflag}') ></TD>
                          <TD height="26">${ssesbsalesid }</TD>
                          <TD>${ssesbpersonName }</TD>
                          <TD>${fn:substring(ssesbsalesdatetime,0,10)}</TD>
                          <TD>${ssesbpricesum}</TD>
                          <TD>${ssesbsalesvalue }</TD>
                          <TD>${ssesbdiscountnum}</TD>
                          <TD>${ssesbpsalsvalue }</TD>
                          <TD><font color="red">${ssesbarrearsvalue }</font></TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
    </form></BODY>
</HTML>
<script>  
	
function selectCust(flag){
	if(flag){
		document.forms[0].action="initArrears.action";
		document.forms[0].submit();
	}
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			document.forms[0].action="initArrears.action";
			document.forms[0].submit();
		}
	}
}	

function judgekey(){
	if(document.getElementById('smecimemberid').value.trim() != '' || document.getElementById('salesID').value.trim() != ''){
		if(event.keyCode == 13){
			document.forms[0].action="initArrears.action";
			document.forms[0].submit();
		}
	}

}
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员详细】";
	}
	
	function selCustomer(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
	}
	
	function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		document.forms[0].action="initArrears.action";
		document.forms[0].submit();
	}

</script>