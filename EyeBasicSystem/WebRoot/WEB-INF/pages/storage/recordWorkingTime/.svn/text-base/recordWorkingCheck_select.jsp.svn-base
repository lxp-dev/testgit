<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加工检验管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	recordWorkingTimeForm.action=link;
	  	recordWorkingTimeForm.submit();
		showLoadingBar();
	}
	function search(){
		$("img").removeAttr("onclick");
		recordWorkingTimeForm.action = "selectRecordWorkingCheck.action";
		recordWorkingTimeForm.submit();
		showLoadingBar();
	}	

	function clean(){
	    document.all.shopsalesid.value="";
	    document.all.shoppersonName.value="";
	    document.all.salesshopcode.value="";
	    document.all.takeshopcode.value="";
	    document.all.ssesbsalesdatestarttime.value="";
	    document.all.ssesbsalesdateendtime.value="";
	    document.all.ssesbtakeglassstartdata.value="";
	    document.all.ssesbtakeglassenddata.value="";
	    document.all.remark.value="";
	}	
	
	function details(ssesbsalesid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("detailsRecordWorkingCheck.action?ssesbsalesid="+ssesbsalesid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("detailsRecordWorkingCheck.action?ssesbsalesid="+ssesbsalesid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【初检记录详细】";
	}
	function allrecordWorkingTime(ssesbsalesid){
		if ($('#InTransitCount').val() == 0){
		    alert("此功能对应的在途点已被停用,请先启用!");
		    return;
		}
		if(checkForm(document.all.recordWorkingTimeForm)){
				if($('input[name=ssesbsalesid]:checked').length==0){
					alert("请选择配镜单号!");
					return;
				}	
		}
		
		if(confirm('是否执行批量记录加工时间操作！')){
			var id='';
			$('input[name=ssesbsalesid]:checked').each(function(){
				id=id+$(this).val()+",";
			})
			
			id=id.substring(0, id.length-1);
			$('#allrecordWorking').attr("disabled","disabled");
			recordWorkingTimeForm.action = "initInsertRecordWorkingTime.action?ssesbsalesid="+id;
			recordWorkingTimeForm.submit();
		}else{
			return;
		}		
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}

	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
	function check_all(obj,chk){
		 	
		var checkboxs = document.getElementsByName(chk);
		for(var i=0;i<checkboxs.length;i++){checkboxs[i].checked = obj.checked;}
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
		
		document.getElementById('ssesbtakeglassstartdata').value = now;
		document.getElementById('ssesbtakeglassenddata').value = now;		
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    document.getElementById('shopsalesid').focus();  
    }); 
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="recordWorkingTimeForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="InTransitCount" name="InTransitCount" value="${InTransitCount}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>加工检验管理</TD>
            <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：初检记录查询</td>
            <td align="right" valign="bottom">
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_isshowsearch_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_isshowsearch_0.png');" title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
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
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initRecordWorkingTimeSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">初检查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">初检记录查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
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
			               <TD class="table_none" width="18%">
                            <input class="text_input160" type="text"  id="shopsalesid" name="shopsalesid" value="${requestScope.shopsalesid}" onkeyup="selectContact(this)">
			               </TD>
			               <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                            <TD class="table_none" width="30%">
			               <input class="text_input160" type="text"  id="shoppersonName" name="shoppersonName" value="${requestScope.shoppersonName}" onkeyup="selectContact(this)">
                           </TD>
						   <TD width="8%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none">
                            <select id="salesshopcode" name="salesshopcode">
                             <option value="">----请选择----</option>
      		                 <c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.salesshopcode!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">取镜门店</TD>
                            <TD class="table_none">
                           <select id="takeshopcode" name="takeshopcode">
                             <option value="">----请选择----</option>
      		                 <c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.takeshopcode!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
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
			               <TD height="26" class="table_body">取镜日期</TD>
                           <TD class="table_none">
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
			  				  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn  title="今天" onClick="today2()"></li>
                           </TD>
                        </TR>  
                        <TR>
                        	<TD height="26" class="table_body">备注</TD>
                            <TD class="table_none" colspan="5">
                            	<input type="text" class="text_input240" name="remark" id="remark" value="${remark }">
                            </TD>
                        </TR>                       
                      </TBODY>
                    </TABLE>
                  	<c:if test="${(permissionPo.keya==1)}">  
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td width="25%">
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn  title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn  title="清空" onClick="clean()">
							</td>
						</tr>
						<tr><td></td></tr>
						<!-- 
						<tr>
							<td width="10%">
								<input id="allrecordWorking" type='button' value='批量记录加工时间' onClick="javascript:allrecordWorkingTime()">
							</td>
						</tr>
						 -->
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
					<c:if test="${not empty(recordWorkingTimeList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <!-- <th width="5%">全选<input type="checkbox" id="chks" onclick="check_all(this,'chk')"> </th> -->
                          <TH width="4%" scope=col>操作</TH>
                          <TH width="20%" height="26" scope=col>配镜单号</TH>
						  <TH width="10%" scope=col>顾客姓名</TH>						
						  <TH width="10%" scope=col>销售门店</TH>
						  <TH width="10%" scope=col>取镜门店</TH>
						  <TH width="15%" scope=col>销售日期</TH>
						  <TH width="15%" scope=col>取镜日期</TH>
						  </TR>
						<s:iterator value="recordWorkingTimeList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <!-- <th width="5%"><input type="checkbox" id="chk" name="ssesbsalesid" value="${ssesbsalesid }"> </th>-->
                          <TD>
                          	<c:if test="${(permissionPo.keyb==1)}">
		                     	<img src="${ctx }/img/newbtn/search_0.png" btn=btn  id="${ssesbsalesid}"  title='详细' onClick="javascript:details('${ssesbsalesid}')">
		                  	</c:if> 
		                  </TD>
                          <TD height="26">${ssesbsalesid}</TD>
                          <TD>${ssesbpersonName}</TD>
                          <TD>${ssesbshopName}</TD>
                          <TD>${ssesbtakeshopname}</TD>
                          <TD>${fn:substring(ssesbsalesdatetime,0,16)}</TD>
                          <TD>${fn:substring(ssesbtakeglassdata,0,16)}</TD>
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
<!--<%@ include file="/WEB-INF/inc/message.jsp" %>-->