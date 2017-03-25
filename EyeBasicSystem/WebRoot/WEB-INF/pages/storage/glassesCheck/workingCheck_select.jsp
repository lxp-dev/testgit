<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜评级</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

    	try{
    		document.getElementById('shopsalesid').focus();
		}catch(e){
			
		}
	    
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
		$("img").removeAttr("onClick");
		workingCheckForm.action = "selectGlassesCheck.action";
		workingCheckForm.submit();
		showLoadingBar();
	}	
	
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}

	function clean(){
	    document.all.shopsalesid.value="";
	    document.all.ssesbsalesdatestarttime.value="";
	    document.all.ssesbsalesdateendtime.value="";
	    document.all.shoppersonName.value="";
	    document.all.ssesbtakeglassstartdata.value="";
	    document.all.ssesbtakeglassenddata.value="";
	    document.all.ssesbsupplierid.value="";
	    document.all.worrytype.value="";
        document.getElementById('maker').value = "";
        document.getElementById('shoppersonPhone').value = "";
	}	
	
	function workingCheck(ssesbsalesid){
		$("input[name=hid]").val(ssesbsalesid);
		var moduleID = $('#moduleID').val();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGlassesCheckIns.action?ssesbsalesid="+ssesbsalesid+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGlassesCheckIns.action?ssesbsalesid="+ssesbsalesid+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【配镜评级新增】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
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
		
		var now = new Date().format("yyyy-MM-dd 00:00");  //设置你想要的格式
		var now1 = new Date().format("yyyy-MM-dd 23:59");  //设置你想要的格式
		
		document.getElementById('ssesbsalesdatestarttime').value = now;
		document.getElementById('ssesbsalesdateendtime').value = now1;
	}
	
	function today2(){
		var now = new Date().format("yyyy-MM-dd 00:00");  //设置你想要的格式
		var now1 = new Date().format("yyyy-MM-dd 23:59");  //设置你想要的格式
		
		document.getElementById('ssesbtakeglassstartdata').value = now;
		document.getElementById('ssesbtakeglassenddata').value = now1;		
	}

	/*开窗事件*/
	function winPopUp(id){
		document.all.hid.value = id;
		
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="workingCheckForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="InTransitCount" name="InTransitCount" value="${InTransitCount}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜评级管理</TD>
            <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：配镜评级查询</td>
            <td align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
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
                      UNSELECTABLE="on">配镜评级查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                         <c:if test="${(permissionPo.keyb==1)}">  
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initGlassesCheckedSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">已配镜评级查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></c:if>
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
			               <TD class="table_none" width="19%">
                            <input class="text_input160" type="text"  id="shopsalesid" name="shopsalesid" value="${shopsalesid}"   onkeyup="selectContact(this)">
			               </TD>
			               <TD width="8%" height="26" class="table_body">配镜日期</TD>
                           <TD width="35%" class="table_none" >
                           <li class="horizontal_onlyRight">
                           <input id="ssesbsalesdatestarttime" class="text_input120"
					       name="ssesbsalesdatestarttime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm', maxDate:'#F{$dp.$D(\'ssesbsalesdateendtime\')}'})"
					       value="${requestScope.ssesbsalesdatestarttime}" /> 至 
					       <input id="ssesbsalesdateendtime" class="text_input120"
					       name="ssesbsalesdateendtime" 
					       type="text" class="text_input100" 
					       onfocus="new WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm', minDate:'#F{$dp.$D(\'ssesbsalesdatestarttime\')}'})" 
					        value="${requestScope.ssesbsalesdateendtime}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today1()">
					  	   </li>
			               </TD>
                           <TD height="26" class="table_body">取镜门店</TD>
			               <td class="table_none">
			               <c:if test="${person.departmenttype eq '1'}">
	                          ${person.bdpdepartmentname}<input type="hidden" name="ssesbsupplierid" id="ssesbsupplierid" value="${person.departmentID}">
	                       </c:if>
			               <c:if test="${person.departmenttype ne '1'}">
	                          <select name="ssesbsupplierid" id="ssesbsupplierid">
	                              <option value="">----请选择----</option>
	                              <s:iterator value="departmentsList">
	                               <option value="${bdpdepartmentid }" ${requestScope.ssesbsupplierid == bdpdepartmentid ? 'selected="selected"' : '' }>${bdpdepartmentname }</option>
	                              </s:iterator>
	                          </select>
	                       </c:if>
	                       </td>
                        </TR>  
                        <TR>
		                   <TD height="26" class="table_body">加急状态</TD>
			               <TD class="table_none">
                            <select id="worrytype" name="worrytype">
                             	<option value="">----请选择----</option>
                   	            <OPTION value="1" ${requestScope.worrytype!= '1'  ? '' : 'selected="selected"' } >正常</OPTION>
                   	            <OPTION value="2" ${requestScope.worrytype!= '2'  ? '' : 'selected="selected"' } >加急</OPTION>
      	                   </select><b><font color="red">*数据呈红色</font></b>
			               </TD>
                           <TD height="26" class="table_body">取镜时间</TD>
                            <TD class="table_none">
                           <li class="horizontal_onlyRight">
                           <input id="ssesbtakeglassstartdata" class="text_input120"
					       name="ssesbtakeglassstartdata" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm', maxDate:'#F{$dp.$D(\'ssesbtakeglassenddata\')}'})"
					       value="${requestScope.ssesbtakeglassstartdata}" /> 至 
					       <input id="ssesbtakeglassenddata" class="text_input120"
					       name="ssesbtakeglassenddata" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm', minDate:'#F{$dp.$D(\'ssesbtakeglassstartdata\')}'})" 
					        value="${requestScope.ssesbtakeglassenddata}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today2()">
					  	   </li>
			               </TD>
			               <TD width="9%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none" >
			               <input class="text_input160" type="text"  id="shoppersonName" name="shoppersonName" value="${requestScope.shoppersonName}"  onkeyup="selectContact(this)">
                           </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">顾客电话</TD>
			               <TD class="table_none">
                              <input class="text_input160" type="text" id="shoppersonPhone" name="shoppersonPhone" value="${requestScope.shoppersonPhone}" onkeyup="selectContact(this)"/>
			               </TD>
			               <TD height="26" class="table_body">加工师姓名</TD>
			               <TD class="table_none" colspan="3">
                              <input class="text_input160" type="text" id="maker" name="maker" value="${maker}" onkeyup="selectContact(this)"/>
			               </TD>

                        </TR>
                      </TBODY>
                    </TABLE>
                   	<c:if test="${(permissionPo.keya==1)}">  
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onClick="javascript:search()">
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
					<c:if test="${not empty(workingCheckList)}"> 
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
                          <TH width="25%" height="26" scope=col>配镜单号</TH>
						  <TH width="10%" scope=col>顾客姓名</TH>						
						  <TH width="15%" scope=col>配镜日期</TH>
						  <TH width="15%" scope=col>取镜日期</TH>
						  <TH width="10%" scope=col>加工师</TH>
						  <TH width="15%" scope=col>加工日期</TH>
						  </TR>
						<s:iterator value="workingCheckList">
                        <TR ${ssesbworrytype != '2' ? '':'style="color: red;font:bold;"'} class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
                          	<c:if test="${(permissionPo.keyb==1)}"> 
		                     <img src="${ctx }/img/newbtn/check_0.png" btn=btn title='检验' onClick="javascript:workingCheck('${ssesbsalesid}')">
		                  	</c:if>
		                  </TD>
                          <TD height="26"><U style="cursor: hand;" onclick="winPopUp('${ssesbsalesid}')">${ssesbsalesid}</U></TD>
                          <TD>${ssesbpersonName}</TD>
                          <TD>${fn:substring(ssesbsalesdatetime,0,16)}</TD>
                          <TD>${fn:substring(ssesbtakeglassdata,0,16)}</TD>
                          <TD>${ssesbmaterialsperson}</TD>
                          <TD>${fn:substring(ssesbmaterialsdate,0,16)}</TD>
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