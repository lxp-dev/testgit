<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购收货管理</title>
</head>
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->

<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	procurementWaitForm.action=link;
	  	procurementWaitForm.submit();
		showLoadingBar();
	}
	function update(cstpid, cstpsupplierid, categoryid){
		if(categoryid=='4'||categoryid=='5')
		{
			if(${systemParameterPo.fspbarcodetype}=='1'||${systemParameterPo.fspbarcodetype}=='2')
			{
				if(${systemParameterPo.fspstealtheffective}=='1'||${systemParameterPo.fspstealtheffective}=='2')
				{
					var topRows = top.document.getElementById("total").rows;
					var topCols = top.document.getElementById("btmframe").cols;
					if(is_iPad()){
						showPopWin("initProcurementWaityxUpdate.action?cstpid="+cstpid+"&cstpsupplierid="+cstpsupplierid+"&categoryID="+categoryid+"&moduleID="+'${requestScope.moduleID}',970,screen.height-200,topRows,topCols,returnRefresh(true),true);
					}else{
						showPopWin("initProcurementWaityxUpdate.action?cstpid="+cstpid+"&cstpsupplierid="+cstpsupplierid+"&categoryID="+categoryid+"&moduleID="+'${requestScope.moduleID}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
					}
					document.getElementById('popupTitle').innerHTML="【采购订单隐形收货新增】";
				}else
				{
					var topRows = top.document.getElementById("total").rows;
					var topCols = top.document.getElementById("btmframe").cols;
					if(is_iPad()){
						showPopWin("initProcurementWaitUpdate.action?cstpid="+cstpid+"&cstpsupplierid="+cstpsupplierid+"&categoryID="+categoryid+"&moduleID="+'${requestScope.moduleID}',970,screen.height-200,topRows,topCols,returnRefresh(true),true);
					}else{
						showPopWin("initProcurementWaitUpdate.action?cstpid="+cstpid+"&cstpsupplierid="+cstpsupplierid+"&categoryID="+categoryid+"&moduleID="+'${requestScope.moduleID}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
					}
					document.getElementById('popupTitle').innerHTML="【待采购订单收货新增】";
				}
			}else
			{
				var topRows = top.document.getElementById("total").rows;
				var topCols = top.document.getElementById("btmframe").cols;
				if(is_iPad()){
					showPopWin("initProcurementWaitUpdate.action?cstpid="+cstpid+"&cstpsupplierid="+cstpsupplierid+"&categoryID="+categoryid+"&moduleID="+'${requestScope.moduleID}',970,screen.height-200,topRows,topCols,returnRefresh(true),true);
				}else{
					showPopWin("initProcurementWaitUpdate.action?cstpid="+cstpid+"&cstpsupplierid="+cstpsupplierid+"&categoryID="+categoryid+"&moduleID="+'${requestScope.moduleID}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
				}
				document.getElementById('popupTitle').innerHTML="【待采购订单收货新增】";
			}
		}else
		{
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initProcurementWaitUpdate.action?cstpid="+cstpid+"&cstpsupplierid="+cstpsupplierid+"&categoryID="+categoryid+"&moduleID="+'${requestScope.moduleID}',970,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initProcurementWaitUpdate.action?cstpid="+cstpid+"&cstpsupplierid="+cstpsupplierid+"&categoryID="+categoryid+"&moduleID="+'${requestScope.moduleID}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【待采购订单收货新增】";
		}
	}
	function search(){
		$("img").removeAttr("onclick");
		procurementWaitForm.action = "selProcurementWait.action";
		procurementWaitForm.submit();
		showLoadingBar();
	}	
	function clean(){
	    document.all.billID.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.selbspsuppliername.value="";
	    document.all.selbspcategoryid.value="";
	    document.all.cstpcreateperson.value="";
	    document.all.cstpauditperson.value="";
	    document.all.goodsName.value="";
	    document.all.goodsID.value="";
	}
		/**
	 * 制造商开窗
	 */
//	function openSupplier(){
//		// 开窗条件 categoryID_open
//		showPopWin("","selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,screen.width-200,screen.height-200, '', null, true);
//		selectHidden();
//	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】"
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selcstpsupplierid').value = json.id;
		document.getElementById('selbspsuppliername').value = json.value;
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	
	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementReceiptInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementReceiptInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【采购收货新增】"
	}
	
	function insert1(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementReceiptyxInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementReceiptyxInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【隐形采购收货新增】"
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="procurementWaitForm" method="post" action="">
<input type="hidden" name="cstpid">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>采购管理</TD>
             <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：未收货采购订单</TD>
            <TD align="right" valign="bottom">&nbsp;
            <c:if test="${(permissionPo.keya==1)}">
            	 <c:if test="${systemParameterPo.fspbarcodetype==1||systemParameterPo.fspbarcodetype==2}">
            	 <c:if test="${systemParameterPo.fspstealtheffective==1||systemParameterPo.fspstealtheffective==2}">
           		 <img src="${ctx }/img/newbtn/btn_yxcgshadd_0.png" btn=btn  title="隐形采购收货新增" onClick="insert1()">
	             </c:if>
	             </c:if>
	             <img src="${ctx }/img/newbtn/btn_cgshadd_0.png" btn=btn title="采购收货新增" onClick="insert()">
	            </c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"  />
            </TD>
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
                      UNSELECTABLE="on">未收货采购订单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initProcurementReceiptSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">采购收货单查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD  style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px"  vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">订单号</TD>
			               <TD width="22%" class="table_none">
                            <input class="text_input200" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			              <TD width="9%"  class="table_body" height="26">制单人</TD>
                          <TD width="22%"  class="table_none">
                          <input type="text" class="text_input100" id="createPersonID" name="cstpcreateperson" value="${cstpcreateperson }">
                          </TD>
			               <TD width="9%" height="26" class="table_body">制单日期</TD>
			               <TD width="30%" class="table_none"><li class="horizontal_onlyRight">
                           <input id="startTime"
					       name="startTime" 
					       type="text" class="text_input80" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /></li><li class="horizontal_onlyRight">
					        <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()">
</li></TD>  
                        </TR>
                        <TR>
                          <TD  class="table_body">审核人</TD>
                          <TD class="table_none">
                          <input class="text_input100" id="auditPersonID" name="cstpauditperson" value="${cstpauditperson }">
                          </TD>
                          <TD class="table_body" height="26">采购类型</TD>
                          <TD class="table_none">
						  <select name="selbspcategoryid">
						  		<option value="">----请选择----</option>
						  		<s:iterator value="goodsCategorys">
								<option value="${bgcid}" ${selbspcategoryid == bgcid ? 'selected="selected"' : '' } >${bgcgoodscategoryname}</option>
	     	               		</s:iterator>
						  </select>
						  </TD>
                        <TD  class="table_body">制造商</TD>
						   	<TD  height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input id="selbspsuppliername" class="text_input200" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   	<input type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
						   	
						   	</li>
						   	<li class="horizontal_onlyRight">	
						   		 <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" name=ctl00$PageBody$Button1 onClick="openSupplier();">
						   </li>
						 </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">商品名称</TD>
                          <TD class="table_none">
                              <input class="text_input200" id="goodsName" name="goodsName" value="${goodsName }" maxlength="100">
                          </TD>
                          <TD height="26" class="table_body">商品代码</TD>
                          <TD class="table_none" colspan="3">
                              <input class="text_input200" id="goodsID" name="goodsID" value="${goodsID }" maxlength="100">
                          </TD>                          
                        </TR>               
                      </TBODY>
                    </TABLE>
                    <table id=title2 cellspacing="2">
                    <TBODY>
						<tr>
							<td align="left">
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
							</td>
						</tr>
						</TBODY>
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
					<c:if test="${not empty(procurementWaitList)}"> 
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
                          <c:if test="${(permissionPo.keyg==1)}">
						  <TH width="4%" scope=col>操作</TH>
						  </c:if>
                          <TH width="20%" height="26" scope=col>采购订单编号</TH>
                          <TH width="34%" scope=col>制造商</TH>
                          <TH width="7%" scope=col>制单人</TH>
						  <TH width="15%" scope=col>制单日期</TH>
						  <TH width="7%" scope=col>审核人</TH>
						  <TH width="15%" scope=col>审核日期</TH>
						</TR>
						<c:forEach var="i" items="${procurementWaitList}" varStatus="index"> 
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                         <c:if test="${(permissionPo.keyg==1)}">
                          <TD width="4%">
		                    <img src="${ctx }/img/newbtn/cgsh_0.png" btn=btn title='采购收货' onClick="javascript:update('${i.cstpid}', '${i.cstpsupplierid}', '${ i.cstpgoodscategory}')">
		                  </TD>
		                  </c:if>
                          <TD height="28">${i.cstpid}</TD>
                          <TD>${i.bspsuppliername}</TD>
                          <TD>${i.createPersonName}</TD>
                          <TD>${fn:substring(i.cstpbilldate,0,16)}</TD>
                          <TD>${i.auditPersonName}</TD>
                          <TD>${fn:substring(i.cstpauditdate,0,16)}</TD>
						</TR>
						</c:forEach>						  
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