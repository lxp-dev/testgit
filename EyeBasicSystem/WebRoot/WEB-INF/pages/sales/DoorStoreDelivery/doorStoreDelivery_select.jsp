<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门店配送</title>
</head>
<script>	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('1');
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
    }); 
	
	function search(){
		$("img").removeAttr("onclick");
		doorStoreDeliveryForm.action = "queryDoorStoreDelivery.action";
		doorStoreDeliveryForm.submit();
		showLoadingBar();
	}

	function doorStoreDelivery_JD(){
		$("img").removeAttr("onclick");
		doorStoreDeliveryForm.action = "initSelectedDoorStoreDelivery.action?type=1&moduleID="+$('#moduleID').val();
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
    
    function fineReportEvent(reportFileName,showtype){
		if ($('#InTransitCount').val() == 0){
		    alert("此功能对应的在途点已被停用,请先启用!");
		    return;
		}
		if(checkForm(document.all.doorStoreDeliveryForm)){
			if($('input[name=ssesbsalesid]:checked').length==0){
				alert("请选择配镜单号!");
				return;
			}	
		}
		/* 显示Id */
		var id='';
		$('input[name=ssesbsalesid]:checked').each(function(){
			id=id+$(this).val()+"','";
		})
		id=id.substring(0, id.length-3);

		var DataURL = "report.action?reportlet=" + reportFileName + "&logincompanyid="+'${person.personcompanyid}'+"&salesID="+ id + "&__bypagesize__=false";
		
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

    function reportingServiceEvent(reportFileName,showtype){
		if ($('#InTransitCount').val() == 0){
		    alert("此功能对应的在途点已被停用,请先启用!");
		    return;
		}
		if(checkForm(document.all.doorStoreDeliveryForm)){
				if($('input[name=ssesbsalesid]:checked').length==0){
					alert("请选择配镜单号!");
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
		DataURL+="eims_reporting/"+ reportFileName +"&logincompanyid="+'${person.personcompanyid}'+"&salesID="+id+"&rs:Command=Render";
		
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
		if ($('#InTransitCount').val() == 0){
		    alert("此功能对应的在途点已被停用,请先启用!");
		    return;
		}
		if(checkForm(document.all.doorStoreDeliveryForm)){
			if($('input[name=ssesbsalesid]:checked').length==0){
				alert("请选择配镜单号!");
				return;
			}
		}
		var salesids = ""; 
		var salestypes = "";
		$("input[name=ssesbsalesid]:checked").each(function (){
			salesids = salesids + $(this).val()+",";			
           	salestypes = salestypes + $(this).attr("dragstype")+",";
		});
		
		salesids = salesids.substring(0,salesids.length-1);
		salestypes = salestypes.substring(0,salestypes.length-1);
		$("#salesids").val(salesids);
		$("#salestypes").val(salestypes);
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initPensonScan.action?moduleID=${moduleID}",400,70,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPensonScan.action?moduleID=${moduleID}",400,70,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【员工卡扫描】";
	}

	//将改变后的委外方式赋值到chk里面的dragstype属性
	function changeDragstype(obj){
		$(obj).parent().parent().find("#chk").attr("dragstype",obj.value);
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
<input type="hidden" id="salestypes" name="salestypes" value="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：门店配送</TD>
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
                      UNSELECTABLE="on">未配送配镜单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="doorStoreDelivery_JD()"
                      UNSELECTABLE="on">已配送配镜单</TD>
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
						   <TD width="6%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="26%">
                            <input clean=clean class="text_input160" type="text"  id="shopsalesid" name="shopsalesid" value="${requestScope.shopsalesid}">
			               </TD>
			               <TD width="6%" height="26" class="table_body">会员卡号</TD>
	                      	<TD class="table_none" width="20%">
	                      		<input clean=clean class="text_input160" type="text"  id="memberId" name="memberId" value="${requestScope.memberId}">
	                      	</TD>
	                      	<TD height="26" class="table_body">配镜日期</TD>
                           <TD class="table_none">
                           <li class="horizontal_onlyRight">
                           <input id="ssesbsalesdatestarttime" clean=clean 
					       name="ssesbsalesdatestarttime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssesbsalesdateendtime\')}'})"
					       value="${requestScope.ssesbsalesdatestarttime}" /> 至 
					       <input id="ssesbsalesdateendtime" clean=clean 
					       name="ssesbsalesdateendtime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssesbsalesdatestarttime\')}'})" 
					        value="${requestScope.ssesbsalesdateendtime}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('ssesbsalesdatestarttime','ssesbsalesdateendtime')"></li>
			               </TD>	
                        </TR>
                    	<TR>
                    	   <TD height="26" class="table_body">配送类型</TD>
                    	   <TD height="26" class="table_none">
                    	   	   <input type="checkbox" id="shoporderstypea" name="shoporderstype" value="1"/>框镜成品&nbsp;
                    	   	   <input type="checkbox" id="shoporderstypeb" name="shoporderstype" value="2"/>框镜订制&nbsp;
                    	   	   <input type="checkbox" id="shoporderstyped" name="shoporderstype" value="4"/>隐形订制
                    	   </TD>
                    	   <TD width="6%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="26%">
			               <input clean=clean class="text_input160" type="text"  id="shoppersonName" name="shoppersonName" value="${requestScope.shoppersonName}">
                           </TD>
			            <TD height="26" class="table_body">取镜日期</TD>
                           <TD class="table_none">
                           <li class="horizontal_onlyRight">
                           <input id="startDate" clean=clean 
					       name="startDate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endDate\')}'})"
					       value="${requestScope.startDate}" /> 至 
					       <input id="endDate" clean=clean 
					       name="endDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startDate\')}'})" 
					        value="${requestScope.endDate}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('startDate','endDate')"></li>
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
						   <TD width="50%" align="right" valign="bottom"><img name="button" src="${ctx }/img/newbtn/btn_print_0.png" btn=btn title='打印单据' onClick="setReportEvent('${fittingTemplateTypePo.bftfilename}','${fittingTemplateTypePo.bftserver}','${fittingTemplateTypePo.bfttshowtype}')" >
						   <img id="submitButton" src="${ctx }/img/newbtn/btn_storesend_0.png" btn=btn title='门店配送' onClick="openPersonScan('${ssesbsalesid }' )" >
						   </TD>
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
                  <c:if test="${not empty(salesBasicPoList)}"> 
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
                          <TH width="25%" scope=col>配镜单号</TH>
                          <TH width="15%" scope=col>顾客姓名<input type="hidden" id="ssesbcustomerid" name="ssesbcustomerid" class="text_input100" value="${customerInfoPo.smecicustomerid }"></TH>
                          <TH width="15%" scope=col>取镜门店</TH>
                          <TH width="20%" scope=col>取镜时间</TH>
                          <TH width="15%" scope=col>配镜类型</TH>
                         </TR>
		
					 <s:iterator value="salesBasicPoList">
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk" name="ssesbsalesid" salestype="${ssesborderstype}" dragstype="${ssesbdragstype}" value="${ssesbsalesid  }"></TD>
                          <TD>${ssesbsalesid }</TD>
                          <TD>${ssesbpersonName }</TD>
                          <TD>${ssesbtakeshopname }</TD>
             			   <input type="hidden" name="location" value="${ssesblocation }">
                          <TD>${ssesbtakeglassdata }</TD>
                  <c:choose>
					<c:when test="${ssesborderstype == 1 }">
                          <TD>镜架成品片<input type="hidden" id="ssesbdragstype" name="ssesbdragstype" value="${ssesbdragstype}"></TD>
                    </c:when>
                    <c:when test="${ssesborderstype == 2 }">
                          <TD>
                          	<select id="ssesbdragstype" name="ssesbdragstype"  onchange="javascript:changeDragstype(this);">
								<option value="1" ${requestScope.ssesbdragstype!= "1"  ? '' : 'selected="selected"'}>委外订单</option>
								<option value="2" ${requestScope.ssesbdragstype!= "2"  ? '' : 'selected="selected"'}>委外加工</option>
							</select>
						  </TD>
                    </c:when>      
                    <c:when test="${ssesborderstype == 4 }">
                          <TD>隐形订制片<input type="hidden" id="ssesbdragstype" name="ssesbdragstype" value="${ssesbdragstype}">
						  </TD>
                    </c:when>      
                  </c:choose>     
                        </TR>
					  </s:iterator>	
                      </TBODY>
                    </TABLE>
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