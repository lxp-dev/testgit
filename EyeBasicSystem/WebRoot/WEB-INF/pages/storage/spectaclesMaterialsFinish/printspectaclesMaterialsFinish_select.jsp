<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜发料管理</title>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
</head>
<script>	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	});

	function print(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectPrintSpectaclesMaterialsBillRpt.action?moduleID=${moduleID}&bill="+id+"&printPerson=${printPerson}"+"&printflag=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectPrintSpectaclesMaterialsBillRpt.action?moduleID=${moduleID}&bill="+id+"&printPerson=${printPerson}"+"&printflag=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}	
		document.getElementById('popupTitle').innerHTML="【打印发料单】";
	}
	
	function search(){
		$("img").removeAttr("onclick");	
		spectaclesMaterialsFinishForm.action = "selectPrintSpectaclesMaterialsBillFinish.action";
		spectaclesMaterialsFinishForm.submit();
		showLoadingBar();
	}	

	function clean(){
	    document.all.salesid.value="";
	    document.all.salesStartTime.value="";
	    document.all.salesEndTime.value="";
	    document.all.personName.value="";
	    document.all.orderstype.value="";
	    document.all.shopcode.value="";
	    document.all.brandID.value="";
	    document.all.brandName.value="";
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    document.all.worrytype.value="";
	    document.all.printSerialNumber.value="";
	}	

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}

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

	function chkAll1(){  
	    var chks=document.all.chks;
	    $('input[id=chk]').each(function(){ 
	        $(this).attr("checked",chks.checked);
	    }); 
	}
	
	function getSalesBillID(){
        var count = 0;
        var bill = '';
	    $('input[id=chk]').each(function(){
	        if ($(this).attr('checked')){
                bill = $(this).val() + "," + bill;
                count = accAdd(count,1);
		    }
	    }); 

	    if (count == 0){
            alert('请先选择配镜单!');
            return;
		}

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectPrintSpectaclesMaterialsBillRpt.action?moduleID=${moduleID}&bill="+bill+"&printPerson=${printPerson}"+"&printflag=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectPrintSpectaclesMaterialsBillRpt.action?moduleID=${moduleID}&bill="+bill+"&printPerson=${printPerson}"+"&printflag=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}	
		document.getElementById('popupTitle').innerHTML="【打印发料单】";
    }
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="spectaclesMaterialsFinishForm" method="post" action="">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：打印发料单 </TD>
            <td align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_isshowsearch_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_isshowsearch_0.png');" title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text align="right" colspan="3" valign="bottom">
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
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPrintSpectaclesMaterialsBillSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">发料单未打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">发料单已打印</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
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
							<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="23%">
                            <input class="text_input160" type="text"  id="salesid" name="salesid" value="${requestScope.salesid}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">配镜日期</TD>
			               <TD class="table_none" width="29%">
                           <li class="horizontal_onlyRight">  <input id="salesStartTime"
					       name="salesStartTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'salesEndTime\')}'})"
					       value="${salesStartTime }" /> 至 
					       <input id="salesEndTime"
					       name="salesEndTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'salesStartTime\')}'})" 
					        value="${salesEndTime }" /> </li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('salesStartTime','salesEndTime')"</li>
			               </TD>
			               <TD width="8%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none">
                           <input class="text_input160" type="text"  id="personName" name="personName" value="${requestScope.personName}">
                           </TD>
                        </TR>
                    	<TR>
                    	   
						   <TD height="26" class="table_body">配镜类型</TD>
			               <TD class="table_none">
                              <select id="orderstype" name="orderstype" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.orderstype!= "1"  ? '' : 'selected="selected"' }>镜架成品</option>
							  		<option value="2" ${requestScope.orderstype!= "2"  ? '' : 'selected="selected"' }>镜架订做</option>
	                          </select>
			               </TD>
			               <TD height="26" class="table_body">加工中心</TD>
			               <TD class="table_none">
                            <select id="shopcode" name="shopcode">
                             <option value="">----请选择----</option>
      		                 <c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.shopcode!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			              <TD height="26" class="table_body">加急状态</TD>
                          <TD class="table_none">
                          <select name="worrytype" id="worrytype"  >
                            <option value="">----请选择----</option>
                            <option value="1" ${requestScope.worrytype == '1' ? 'selected="selected"' : '' }>正常</option>
                            <option value="2" ${requestScope.worrytype == '2' ? 'selected="selected"' : '' }>加急</option>                           
                            </select><b><font color="red">*数据呈红色</font></b>
			               </TD>
                        </TR>
                        
                        <TR>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
						   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择"  onClick="openSupplier();"></li>
			               </TD>
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onClick="openBrand();"></li>
			               </TD>
			               <TD width="8%" height="26" class="table_body">流水号</TD>
			               <TD class="table_none">
                           <input class="text_input160" type="text"  id="printSerialNumber" name="printSerialNumber" value="${requestScope.printSerialNumber}">
                           </TD>
                           
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">排序方式</TD>
			               <TD class="table_none" colspan="5">
			                   <input type="radio" name="printorderby" value="1" ${(printorderby eq '1' || printorderby eq '') ? 'checked="checked"' : '' }>按配镜日期&nbsp;&nbsp;
			                   <input type="radio" name="printorderby" value="2" ${printorderby eq '2' ? 'checked="checked"' : '' }>按门店名称&nbsp;&nbsp;
			               </TD>
			            </TR>                     
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">						
						<tr height="26">						
							<td width="100%">
							  <c:if test="${(permissionPo.keya==1)}">
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							  </c:if>
							</td>
						<c:if test="${(permissionPo.keyb==1)}">
							<td align="right">
								<img btn=btn src="${ctx }/img/newbtn/btn_plprint_0.png" title="批量打印" onClick="getSalesBillID();">
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
					<c:if test="${not empty(spectaclesMaterialsFinishList)}"> 
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
                          <TH width="8%" scope=col colspan="2">全选<input type="checkbox" id="chks" name="chks" onclick="chkAll1()"></TH>
                          <TH width="10%" height="26" scope=col>配镜单号</TH>
                          <TH width="10%" height="26" scope=col>流水号</TH>
                          <TH width="8%" scope=col>顾客姓名</TH>
						  <TH width="10%" scope=col>所属门店</TH>						
						  <TH width="7%" scope=col>配镜类型</TH>
						  <TH width="12%" scope=col>配镜日期</TH>
						  <TH width="12%" scope=col>取镜日期</TH>
						  <TH width="8%" scope=col>发料人</TH>
						  <TH width="12%" scope=col>发料时间</TH>
						</TR>
						<s:iterator value="spectaclesMaterialsFinishList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" ${ssesbworrytype == '2' ? 'style="color: red;font:bold"' : '' }>
                          <TD width="4%">
                             <input type="checkbox" id="chk" name="chk" value="${ssesbsalesid}">
                          </TD>
                          <TD width="4%">
                             <c:if test="${(permissionPo.keyb==1)}">
                                <img src="${ctx }/img/newbtn/print_0.png" title='打印' btn=btn onClick="javascript:print('${ssesbsalesid}')">
                             </c:if>
                          </TD>
                          <TD height="26"><U style="cursor: hand;" onclick="winPopUp('${ssesbsalesid}')">${ssesbsalesid}</U></TD>
                          <TD height="26">${ssesbprintserialnumber}</TD>
                          <TD>${ssesbpersonName}</TD>
                          <TD>${ssesbshopName}</TD>
                          <c:if test="${ssesborderstype==1}">
                          <TD>镜架成品</TD>
                          </c:if>
                          <c:if test="${ssesborderstype==2}"> 
                          <TD>镜架订做</TD>
                          </c:if>
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