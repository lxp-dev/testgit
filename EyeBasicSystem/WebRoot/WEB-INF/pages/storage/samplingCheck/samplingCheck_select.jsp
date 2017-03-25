<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>抽检管理</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	workingCheckForm.action=link;
	  	workingCheckForm.submit();
		showLoadingBar();
	}
	function selectContact(obj){
		var act = document.activeElement.id; 
		
		if(act == "pageNos"){
			$('#'+act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
	}
	function search(){
		$("img").removeAttr("onclick");
		workingCheckForm.action = "selectSamplingCheck.action";
		workingCheckForm.submit();
		showLoadingBar();
	}	


	function samplingCheck(hid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertSamplingCheck.action?moduleID=${moduleID}&hid="+hid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertSamplingCheck.action?moduleID=${moduleID}&hid="+hid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【抽检新增】";
	}

	function clean(){
	    document.all.shopsalesid.value="";
	    document.all.shoppersonName.value="";
	    document.all.pchckprocesspersonid.value="";
	    document.all.pchckchecklabourid.value="";
	    document.all.shopcode.value="";
	    document.all.ssesbsalesdatestarttime.value="";
	    document.all.ssesbsalesdateendtime.value="";
	    document.all.pchckstartcheckdate.value="";
	    document.all.pchckendcheckdate.value="";
	    document.all.ssesbtakeglassstartdata.value="";
	    document.all.ssesbtakeglassenddata.value="";
	    document.all.djsbm.value="";
	}	
	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	window.onload=function(){
		document.getElementById('shopsalesid').focus();  
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
 
	function today1(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('ssesbsalesdatestarttime').value = now;
		document.getElementById('ssesbsalesdateendtime').value = now;		
	}
	
	function today2(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('pchckstartcheckdate').value = now;
		document.getElementById('pchckendcheckdate').value = now;		
	}
	
	function today3(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('ssesbtakeglassstartdata').value = now;
		document.getElementById('ssesbtakeglassenddata').value = now;		
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="workingCheckForm" method="post" action="">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>加工检验管理</TD>
            <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：抽检查询</td>
            <td align="right" valign="bottom">
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx 

}/img/newbtn/btn_isshowsearch_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx 

}/img/newbtn/btn_isshowsearch_0.png');" title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
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
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">抽检查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    <c:if test="${(permissionPo.keya==1)}"> 
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initSelectSampledCheck.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">已抽检记录查询</TD>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="20%">
                            <input class="text_input160" type="text"  id="shopsalesid" name="shopsalesid" value="${requestScope.shopsalesid}">
			               </TD>
						   <TD width="8%" height="26" class="table_body">加工师</TD>
			               <TD class="table_none" width="20%">
                            <select id="pchckprocesspersonid" name="pchckprocesspersonid">
                             	<option value="">----请选择----</option>
      		                 	<c:if test="${not empty(workingCheckpersonList)}">
				               	 	 <s:iterator value="workingCheckpersonList">
                    	           	<OPTION value="${id}" ${requestScope.pchckprocesspersonid!= id  ? '' : 'selected="selected"' } >${personName}</OPTION>
                    	         	 </s:iterator>
                    	        	</c:if>
      	                   	</select>
			               </TD>
			               <TD width="8%" height="26" class="table_body">检验日期</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight">
                           <input id="pchckstartcheckdate"
					       name="pchckstartcheckdate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'pchckendcheckdate\')}'})"
					       value="${requestScope.pchckstartcheckdate}" /> 至 
					       <input id="pchckendcheckdate"
					       name="pchckendcheckdate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'pchckstartcheckdate\')}'})" 
					        value="${requestScope.pchckendcheckdate}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  				  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today2()"></li>
					       
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">检验师</TD>
                           <TD class="table_none">
                           <select id="pchckchecklabourid" name="pchckchecklabourid">
                             	<option value="">----请选择----</option>
      		                 	<c:if test="${not empty(workingCheckpersonList)}">
				               	 	 <s:iterator value="workingCheckpersonList">
                    	           	<OPTION value="${id}" ${requestScope.pchckchecklabourid!= id  ? '' : 'selected="selected"' } >${personName}</OPTION>
                    	         	 </s:iterator>
                    	        	</c:if>
      	                   	</select>
			               </TD>
						   <TD height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" >
                            <select id="shopcode" name="shopcode">
                             <option value="">----请选择----</option>
      		                 <c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.shopcode!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">销售日期</TD>
                           <TD class="table_none">
                           
						   <li class="horizontal_onlyRight">
			               <input id="ssesbsalesdatestarttime"
					       name="ssesbsalesdatestarttime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssesbsalesdateendtime\')}'})"
					       value="${requestScope.ssesbsalesdatestarttime}" /> 至 
					       <input id="ssesbsalesdateendtime"
					       name="ssesbsalesdateendtime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssesbsalesdatestarttime\')}'})" 
					        value="${requestScope.ssesbsalesdateendtime}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  				  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today1()"></li>
					       
                           </TD>
                        </TR>
                    	<TR>
                    	   <TD height="26" class="table_body">顾客姓名</TD>
                            <TD class="table_none">
			               <input class="text_input160" type="text"  id="shoppersonName" name="shoppersonName" value="${requestScope.shoppersonName}">
                           </TD>
                           <TD height="26" class="table_body">取镜日期</TD>
			               <TD class="table_none" colspan="3">
			               <li class="horizontal_onlyRight">
                           <input id="ssesbtakeglassstartdata"
					       name="ssesbtakeglassstartdata" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssesbtakeglassenddata\')}'})"
					       value="${requestScope.ssesbtakeglassstartdata}" /> 至 
					       <input id="ssesbtakeglassenddata"
					       name="ssesbtakeglassenddata" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssesbtakeglassstartdata\')}'})" 
					        value="${requestScope.ssesbtakeglassenddata}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today3()"></li>
			               </TD>
                        </TR>  
                        <c:if test="${systemParameterPo.fspdjsbm == '1'}">
                        <TR>
			               <TD height="26" class="table_body">单据识别码</TD>
			               <TD class="table_none" colspan="5">
                              <input class="text_input160" type="text" id="djsbm" name="djsbm" value="${requestScope.djsbm}" onkeyup="selectContact(this)"/>
			               </TD>

                        </TR> 
                        </c:if>                       
                      </TBODY>
                    </TABLE>
                  	<c:if test="${(permissionPo.keya==1)}"> 
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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
					<c:if test="${not empty(printWorkingCheckList)}"> 
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
                          <TH width="4%" scope=col>操作</TH>
                          <TH width="20%" height="26" scope=col>配镜单号</TH>
						  <TH width="10%" scope=col>顾客姓名</TH>						
						  <TH width="10%" scope=col>加工师</TH>
						  <TH width="10%" scope=col>检验师</TH>
						  <TH width="15%" scope=col>检验日期</TH>
						  <TH width="15%" scope=col>取镜日期</TH>
						  </TR>
						<s:iterator value="printWorkingCheckList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
                          	<c:if test="${(permissionPo.keyb==1)}"> 
		                     <img src="${ctx }/img/newbtn/check_0.png" btn=btn title='抽检' onClick="javascript:samplingCheck('${pchcksalesid}')">
		                  	</c:if>
		                  </TD>
                          <TD height="26">${pchcksalesid}</TD>
                          <TD>${pchckcustomername}</TD>
                          <TD>${pchckprocesspersonname}</TD>
                          <TD>${pchckchecklabourname}</TD>
                          <TD>${fn:substring(pchckcheckdate,0,16)}</TD>
                          <TD>${fn:substring(pchcktakeglasstime,0,16)}</TD>
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