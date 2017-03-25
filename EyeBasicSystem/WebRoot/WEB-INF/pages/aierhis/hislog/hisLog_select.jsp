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
<title>HIS接口日志管理</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!-- jquery.autocomplete end -->
<script>
 

$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	allocationForm.action=link;
	  	allocationForm.submit();
		showLoadingBar();
	}
	
	function search(){
		$("img").removeAttr("onclick");
		allocationForm.action = "queryHisLog.action";
		allocationForm.submit();
		showLoadingBar();
	}	
	
	

	function clean(){
		
	 	$('#hislogdepatmentname').val("");
	 	$('#startTime').val("");
	 	$('#endTime').val("");
	 	$('#hislogdepatmentid').val("");	   
	 	$('#hislogip').val("");
	 	$('#hislogpersonname').val("");
	 	$('#hislogpersonid').val("");
	 	$('#hislogmodulename').val("");
	 	$('#hislogmoduleid').val("");
	 	$('#hisloginterfacename').val("");
	 	$('#hisloginterfaceid').val("");
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
	
	function winPopUp(id,billid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initHisLogDetails.action?billid="+billid+"&hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initHisLogDetails.action?billid="+billid+"&hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【HISLog详细】";
	}
	
	function winPopUp2(id){
	 
		 if(id.substring(0,1) == 'X'){
	    	 
				var topRows = top.document.getElementById("total").rows;
				var topCols = top.document.getElementById("btmframe").cols;
				if(is_iPad()){
					showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
				document.getElementById('popupTitle').innerHTML="【配镜单详细】";
		    }else if(id.substring(0,1) == 'R'){
		    
				var topRows = top.document.getElementById("total").rows;
				var topCols = top.document.getElementById("btmframe").cols;
				if(is_iPad()){
					showPopWin("selectRegisteredDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("selectRegisteredDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
				document.getElementById('popupTitle').innerHTML="【验光费用详细】";
		    }
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
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="departmenttype" value="${departmenttype}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="20%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>HIS日志管理</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：HIS日志查询</TD>
            <td align="right" width="35%" valign="bottom">&nbsp;
            	
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png"  btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE><br/>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	<TD height="26" class="table_body">调用人工号</TD>
			               <TD class="table_none" >
                            <input  class="text_input160" type="text" id="hislogpersonid" name="hislogpersonid" value="${requestScope.phislogpersonid}">
			               </TD>
						   <TD width="9%" height="26" class="table_body">调用日期</TD>
			               <TD class="table_none" width="30%">
                            <li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input80" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /> </li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_today_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_today_0.png');" title="今天" onClick="today()">
</li></TD>
                           <TD width="8%" height="26" class="table_body">IP地址</TD>
			               <TD class="table_none">
						   	<input class="text_input160" type="text"  id="hislogip" name="hislogip" value="${requestScope.phislogip}"  onkeyup="selectContact(this)">
			               </TD>	
                        </TR> 
                        <TR>
                           	<TD width="9%" height="26" class="table_body">调用部门</TD>
			               <TD class="table_none" width="20%">
			                <select id="hislogdepatmentid" name="hislogdepatmentid">
     		                 	<option value="">----请选择----</option>
			               	  <s:iterator value="departmentsList">
                   	           <OPTION value="${bdpdepartmentid}" ${requestScope.bdpdepartmentid != phislogdepatmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                   	          </s:iterator>
                   	        </select>
                           </TD>
                           <TD height="26" class="table_body">所属模块</TD>
			               <TD class="table_none">
			                <select name="hislogmoduleid" id="hislogmoduleid">
	                          <option value="">----请选择----</option>
	                          <s:iterator value="moduleList">
	                              <option value="${moduleid}" ${moduleid == phislogmoduleid ? 'selected="selected"' : '' }>(${moduleid})${modulecname}</option>
	                          </s:iterator>
	                        </select>
			               </TD>
			              <TD height="26" class="table_body">接口名称</TD>
                          <TD class="table_none">
                          
                           <select name="hisloginterfaceid" id="hisloginterfaceid">
	                          <option value="">----请选择----</option>
	                          <s:iterator value="hisLogList">
	                              <option value="${hisloginterfaceid}" ${hisloginterfaceid == phisloginterfaceid ? 'selected="selected"' : '' }>(${hisloginterfaceid})${hisloginterfacename}</option>
	                          </s:iterator>
	                        </select>
                          </TD> 			               
                        </TR>                      
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keya=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()" >
							</td>
						</tr>
					</table>
					</c:if>
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
					<c:if test="${not empty(hisLogPoList)}"> 
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
                         <TH width="3%" scope=col>操作</TH>
                         <TH width="13%" scope=col>相关单号</TH>
                          <TH width="13%" scope=col>调用部门</TH>
						  <TH width="13%" scope=col>调用人员</TH>
						  <TH width="13%" scope=col>调用日期</TH>						
                          <TH width="13%" scope=col>IP地址</TH>
						  <TH width="13%" scope=col>所属模块</TH>
						  <TH width="20%" scope=col>接口名称</TH>
						  </TR>
						<s:iterator value="hisLogPoList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                         <TD>
                         <c:if test="${permissionPo.keya=='1'}">
		                      <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="winPopUp('${hislogid}','${hislogbillid}')"/>
		                  </c:if>
                         </TD>
                          <TD height="26"><a onMouseOver="mover(this,'#3EBADC')" onMouseOut="mout(this,'#cadee8')"onClick="winPopUp2('${hislogbillid}')" style="cursor: hand">${hislogbillid}</a></TD>
                          <TD>${hislogdepatmentname}</TD>
                          <TD>${hislogpersonname}</TD>                          
                          <TD>${fn:substring(hislogdate,0,16)}</TD>
                          <TD>${hislogip}</TD>
                          <TD>${hislogmodulename}</TD>
                          <TD>${hisloginterfacename}</TD>
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