<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调拨配送</title>
</head>
<script>	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });
        $('input[name=shoporderstype]').attr("checked","");
	}
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    $("select[ids=ids]").hide();

	    <c:forEach var="shoporderstype" items="${shoporderstypes}">
			$("input[name=shoporderstype]").each(function (){
				if($(this).val() == '${shoporderstype}'){
					$(this).attr("checked","checked");
				}
			});
	    </c:forEach> 
	    
	    if('${starttime }' == '' && '${endtime}' == ''){
	    	today('starttime','endtime');
	    }
    }); 
	
	function search(){
		$("img").removeAttr("onclick");
		doorStoreDeliveryForm.action = "selectAllocationSend.action";
		doorStoreDeliveryForm.submit();
		showLoadingBar();
	}

	function doorStoreDelivery_JD(){
		$("img").removeAttr("onclick");
		doorStoreDeliveryForm.action = "initSelectAllocationSended.action?type=4&moduleID="+$('#moduleID').val();
		doorStoreDeliveryForm.submit();
	}

	/* 全选事件  */
    function check_all(){
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
	}

    function setReportEvent(reportFileName,reportServer,showtype){
		switch(reportServer)
		{
		case "1":
		  fineReportEvent(reportFileName,showtype);
		  break;
		case "2":
		  reportingServiceEvent(reportFileName,showtype);
		  break;
		default:
		  alert("单据配置异常！");
		}        
    }
    
    function fineReportEvent(){
		if(checkForm(document.all.doorStoreDeliveryForm)){
			if($('input[name=ssesbsalesid]:checked').length==0){
				alert("请选择调拨单号!");
				return;
			}	
		}
		/* 显示Id */
		var id='';
		$('input[name=ssesbsalesid]:checked').each(function(){
			id=id+$(this).val()+"','";
		})
		id=id.substring(0, id.length-3);

		var DataURL = "report.action?reportlet=sales_allocationsendRpt.cpt&salesID="+ id + "&__bypagesize__=false";
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【调拨配送单】";
	}

    function reportingServiceEvent(reportFileName,showtype){
		if(checkForm(document.all.doorStoreDeliveryForm)){
			if($('input[name=ssesbsalesid]:checked').length==0){
				alert("请选择调拨单号!");
				return;
			}
		}
		
		/* 显示Id */
		var id='';
		$('input[name=ssesbsalesid]:checked').each(function(){
			id=id+$(this).val()+"','";
		})
		id=id.substring(0, id.length-3);

		var DataURL = '<%= getServletContext().getInitParameter("rptUrl")%>';
		DataURL+="eims_reporting/sales_allocationsendRpt.cpt&salesID="+id+"&rs:Command=Render";
		
		switch(showtype)
		{
		case "1":
		    var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			
			document.getElementById('popupTitle').innerHTML="【门店配送单】";
		  break;
		case "2":
			window.open (DataURL, '查询窗口', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		  break;
		default:
		  alert("单据配置异常！");
		}
	}

	function openPersonScan(id){
		if(checkForm(document.all.doorStoreDeliveryForm)){
			if($('input[name=ssesbsalesid]:checked').length==0){
				alert("请选择调拨单号!");
				return;
			}
		}
		var salesids = ""; 
		$("input[name=ssesbsalesid]:checked").each(function (){
			salesids = salesids + $(this).val()+",";			
		});
		
		salesids = salesids.substring(0,salesids.length-1);
		$("#salesids").val(salesids);
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initAllocationSendPensonScan.action?moduleID=${moduleID}",400,70,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initAllocationSendPensonScan.action?moduleID=${moduleID}",400,70,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【员工卡扫描】";
	}

	//将改变后的委外方式赋值到chk里面的dragstype属性
	function changeDragstype(obj){
		$(obj).parent().parent().find("#chk").attr("dragstype",obj.value);
	}
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("allocationDetails.action?hid="+id+"&moduleID="+$('#moduleID').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("allocationDetails.action?hid="+id+"&moduleID="+$('#moduleID').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【调拨单详细】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="doorStoreDeliveryForm" method="post" action="">
<input type="hidden" id="hid" name="hid">
<input type="hidden" id="type" id="type" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="customerID" name="customerID" value="${requestScope.smecicustomerid }">
<input type="hidden" id="ssesborderstype" name="ssesborderstype" value="${salesBasicPoList[0].ssesborderstype}">
<input type="hidden" id="InTransitCount" name="InTransitCount" value="${InTransitCount}">
<input type="hidden" id="salesids" name="salesids" value="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：调拨配送</TD>
            <td align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
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
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">未配送调拨单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="doorStoreDelivery_JD()"
                      UNSELECTABLE="on">已配送调拨单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>                    
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="10%" height="26" class="table_body">调拨单号</TD>
			               <TD class="table_none" width="20%">
                            <input clean=clean class="text_input160" type="text"  id="allocationid" name="allocationid" value="${allocationid }">
			               </TD>
			               <TD width="10%" height="26" class="table_body">审核人工号</TD>
	                      	<TD class="table_none" width="20%">
	                      		<input clean=clean class="text_input160" type="text"  id="auditpersonid" name="auditpersonid" value="${auditpersonid }">
	                      	</TD>
	                      	<TD height="26" width="10%" class="table_body">审核日期</TD>
                           <TD class="table_none">
                           <li class="horizontal_onlyRight">
                           <input id="starttime" clean=clean 
					       name="starttime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endtime\')}'})"
					       value="${starttime }" /> 至 
					       <input id="endtime" clean=clean 
					       name="endtime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'starttime\')}'})" 
					        value="${endtime}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('starttime','endtime')"></li>
			               </TD>	
                        </TR>
                    	<TR>
                    	   <TD height="26" class="table_body">发出部门</TD>
                    	   <TD height="26" class="table_none">
                    	   	${person.bdpdepartmentname }<input type="hidden" id="outdepartment" name="outdepartment" value="${person.departmentID }">
                    	   </TD>
                    	   <TD height="26" class="table_body">接收部门</TD>
			               <TD class="table_none" colspan="3">
			               	<select clean=clean id="indepartment" name="indepartment">
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="departmentsList">
                   	           		<OPTION value="${bdpdepartmentid}" ${indepartment != bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
      	                    </select>
                           </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                   <c:if test="${(permissionPo.keya==1)}">  
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td width="50%" align="left">
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						   <TD width="50%" align="right" valign="bottom">
						   <c:if test="${(permissionPo.keyb==1)}">
						   <img name="button" src="${ctx }/img/newbtn/btn_print_0.png" btn=btn title='打印单据' onClick="fineReportEvent()" >
						   <img id="submitButton" src="${ctx }/img/newbtn/btn_allocationsend_0.png" btn=btn title='调拨配送' onClick="openPersonScan('${ssesbsalesid }' )" >
						   </c:if>
						   </TD>
				    	</tr>
				    </table>
				    </c:if>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;">
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
                  <c:if test="${not empty(allocationPos)}"> 
                           <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR class=table_title align=middle>
						<TH height="26" scope=col>全选 <input type="checkbox" id="chks" name="chks" onclick="check_all()">
                          <TH width="25%" scope=col>调拨单号</TH>
                          <TH width="15%" scope=col>发出部门</TH>
                          <TH width="15%" scope=col>接收部门</TH>
                          <TH width="20%" scope=col>调拨日期</TH>
                          <TH width="15%" scope=col>审核人</TH>
                         </TR>
		
					 <s:iterator value="allocationPos">
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk" name="ssesbsalesid" value="${cshaabillid  }"></TD>
                          <TD><a href="#" onclick="javascript:details('${cshaabillid}')" style="cursor:hand">${cshaabillid}</a></TD>
                          <TD>${cshaaoutdepartmentname }</TD>
                          <TD>${cshaaindepartmentname }</TD>
                          <TD>${cshaaauditdate }</TD>
                          <TD>${cshaaauditpersonname }</TD>
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