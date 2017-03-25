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
<title>银台</title>
</head>
<script>	
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
	});
	
	/**
	 *回车事件
	 */
	function selectCustomerInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
   	}
  
	/**
	 *详情
	 */
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员详细】";
	}	
	
	function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		putOptometryForm.action = "selectPutOptometry.action";
		putOptometryForm.submit()
	}

	/**
	 * 配镜单打印主程序入口
	 * @id	配镜单号；
	 * @billType	配镜单销售类型；1：框架成品；2：框架定制；3:隐形成品；4：隐形定制；5：辅料；
	 * @dingjinFlag	是否欠款；1：欠款；
	 * @wflag	打印类型；1：销售；-1：退款；（为''空时，表示1)
	 */
	function setReportEvent(id,billType,dingjinFlag,wflag){	
		var DataURL='';
		
		//1、打印定金单
		if(dingjinFlag=='1'){//需要进行订金单打印
	    	if ($.trim('${systemParameterPo.fspsubscriptionbillname}') == ''){//没有配置订金单样式
	            alert('请先配置订金单样式!');
	            return;
	        }else{
				if($.trim('${systemParameterPo.fspsubscriptionbillserver}') =="1"){
					DataURL="report.action?reportlet=${systemParameterPo.fspsubscriptionbillname}&__bypagesize__=false&salesid="+id;
				}else if($.trim('${systemParameterPo.fspsubscriptionbillserver}') =="2"){
	    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
	    			DataURL+="eims_reporting/${systemParameterPo.fspsubscriptionbillname}&salesID="+id+"&rs:Command=Render";	
	    		}
				window.open (DataURL, '订金单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	        }				
		}

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
    	    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
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
		    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
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
    	    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
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
		    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
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
    	    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
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
		    			DataURL = '<%= getServletContext().getInitParameter("pjdUrl")%>';
		    			DataURL+="eims_reporting/${systemParameterPo.fspsalesbillname5tui}&salesID="+id+"&rs:Command=Render";	
		    		}
		        } 
	        }		    		    
		}else{
			alert("单据类型异常！");
			return;
		}
	    window.open (DataURL, '配镜单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	      
	}
    
    
	/**
	 *回车事件
	 */
	
   
function selectCust(flag){
    if(flag){
		$("img").removeAttr("onclick");
		putOptometryForm.action = "selectPutOptometry.action";
		putOptometryForm.submit();
    }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			var memberId=document.getElementById('smecimemberid').value;
				var salesId=document.getElementById('fmmsalesid').value;
				if(memberId=='' && salesId==''){
					return false;
				}
				$("img").removeAttr("onclick");
				putOptometryForm.action = "selectPutOptometry.action";
				putOptometryForm.submit();
		}
	}
}	
function judgekey(){
	if(document.getElementById('smecimemberid').value.trim() != '' || document.getElementById('fmmsalesid').value.trim() != null){
		if(event.keyCode == 13){
			$("img").removeAttr("onclick");
			putOptometryForm.action = "selectPutOptometry.action";
			putOptometryForm.submit();
		}
	}

}
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="putOptometryForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：打印配镜单</TD>
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
                      <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initGuitarManagement.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">结款管理</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    
                      <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">打印配镜单</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                 
                     </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" vAlign=top><DIV id=tabContent__1>
                  <DIV>
                  
                  <fieldset>
						<legend>顾客资料</legend>
						<TABLE width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
					      <tr>
					        <td bgcolor="#cadee8">
					         
					          <li class="horizontal">卡号&nbsp;
					                <input type="text" id="smecimemberid" name="smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid }" 
					                onkeyup="selectCustomer();"${ systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' } >
					                	<input type="hidden" id="smecicustomerid" name="smecicustomerid" 
					                	value="${customerInfoPo.smecicustomerid }">
					          </li>
					          
					            <li class="horizontal">
					              <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
					              <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn name="button22" title='查询' onclick="selectCustomerInfo();" >
					            </li>
					            <li class="horizontal">配镜单号&nbsp;
					                <input id="fmmsalesid" name="fmmsalesid" class="text_input160" onkeyup="judgekey();">
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
					           <c:if test="${empty(customerInfoPo.smecicustomerid)}">
					           </c:if>
					           <c:if test="${not empty(customerInfoPo.smecicustomerid)}">
					           	<img src="${ctx }/img/newbtn/btn_details_0.png" btn=btn name="button32" title='详细' onClick="javascript:details('${customerInfoPo.smecicustomerid }');">
					           </c:if>
					          </li>
					      </tr>
					    </table>
					</fieldset>
                  <br>
                   <c:if test="${not empty(putOptometryOrderList)}"> 
                   <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE width="100%" border=0 cellSpacing=1 class="Privateborder" id="ctl00_PageBody_GridView1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="16%" scope=col colspan="2">操作</TH>
                          <TH width="15%" height="26" scope=col>配镜单号</TH>
                          <TH width="10%" scope=col>原价合计</TH>
                          <TH width="10%" scope=col>应收金额</TH>
                          <TH width="10%" scope=col>欠费金额</TH>
                          <TH width="10%" scope=col>销售人员</TH>
                          <TH width="10%" scope=col>收银人员</TH>
                        </TR>
                        <s:iterator  value="putOptometryOrderList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="8%">
                            <img src="${ctx }/img/newbtn/btn_printp_0.png" btn=btn id="ssesbsalesid" name="ssesbsalesid" title='打印配镜单' onClick="setReportEvent('${ssesbsalesid }','${ ssesborderstype}','${ssesbcheckoutflag }','1')">
                          </TD>
                          <TD width="8%">
                            <c:if test="${ssesbwithdrawflag == '1'}">
                            <img src="${ctx }/img/newbtn/btn_printt_0.png" btn=btn id="ssesbsalesid" name="ssesbsalesid" title='补打退款单' onClick="setReportEvent('${ssesbsalesid }','${ ssesborderstype}','${ssesbcheckoutflag }','-1')">
                            </c:if>
                          </TD>
                          <TD>${ssesbsalesid }</TD>
                          <TD><fmt:formatNumber value='${ssesbpricesum }' pattern="0.00"/></TD>
                          <TD><fmt:formatNumber value='${ssesbsalesvalue }' pattern="0.00"/></TD>
                          <c:if test="${(ssesbcheckoutflag)==1}">
                          <TD><font color="red" ><fmt:formatNumber value='${ssesbarrearsvalue }' pattern="0.00"/></font></TD>
                          </c:if>
                          <c:if test="${(ssesbcheckoutflag)==0}">
                          <TD>&nbsp;</TD>
                          </c:if>
                          <TD>${ssesbsalerName }</TD>
                          <TD>${ssesbposName }</TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>