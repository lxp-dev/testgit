<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品退货管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	brandForm.action=link;
	  	brandForm.submit();
		showLoadingBar();
	}
	function search(){
		brandForm.action = "selectOrdersStatusReturn.action";
		brandForm.submit();
		showLoadingBar();
	}	
	
	function detaile(id){
		showPopWin("","selectOrdersStatusReturnDetaile.action?hid="+id, screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
	    document.all.billID.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.auditstate.value="";
	    document.all.suppliername.value="";
	    document.all.supplierid.value="";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		//showPopWin("","selSupplierOpen.action",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
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
		document.getElementById('cstpsupplierid').value = json.id;
		document.getElementById('suppliername').value = json.value;
	}
	
	$(document).ready(function(){
		$('#cstpauditstate').attr("value","${requestScope.auditstate}");
	});
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="brandForm" method="post" action="">
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
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>商品退货管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品退货查询</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initProcurementReturnStorageSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">商品退货查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">商品退货状态查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
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
                          <TD class="table_body" width="10%" height="30">退货单号</TD>
                          <TD class="table_none" width="30%">
                          	<input class="text_input200" id="cstpid" name="billID" value="${requestScope.billID }">
                          </TD>
                          <TD class="table_body" width="10%">退货日期</TD>
                          <TD class="table_none"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${requestScope.startTime }" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${requestScope.endTime }" />
					      </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="30">退货状态</TD>
                          <TD class="table_none">
						  <select id="cstpauditstate" name="auditstate">
						  		<option value="">请选择退货状态</option>
                                <option value='1'>退货</option>
                                <option value='2'>确认退货</option>
						  </select>
						  </TD>
						  <TD class="table_body">制造商</TD>
						   	<TD height="30" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input id="cstpsuppliername" class="text_input200" name="suppliername" value="${requestScope.suppliername }" readonly="readonly" />
						   		<input type="hidden" id="cstpsupplierid" name="supplierid" value="${requestScope.supplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <INPUT class=button_bak id=ctl00_PageBody_Button1 icon="icon-zoom" type=button value="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li>
						 </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<table id="searchBar" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<input icon='icon-search' type='button' value='查询'  onclick="search();">
							<input name="reset" type='button' value='清空' icon='icon-retry' onclick="clean();" ></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->	
					<c:if test="${not empty(ordersStatusReturnList)}">
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
                        <TR class=table_title align=middle>
                          <TH width="20%" height="30" scope=col>退货单号</TH>
                          <TH width="20%" scope=col>制造商</TH>
                          <TH width="15%" scope=col>创建人</TH>
                          <TH width="15%" scope=col>退货状态</TH>
                          <TH width="20%" scope=col>退货日期</TH>
						  <TH width="10%" scope=col>详细</TH>
                        </TR>
                        <c:forEach var="po" items="${ordersStatusReturnList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28">${fn:substring(po.cstrid,5,31)}</TD>
                          <TD>${po.cstrsuppliername }</TD>
                          <TD>${po.cstrcreateoersonname}</TD>
                          <TD>
                          <c:if test="${po.cstrauditstate==0 }">
                          	退货
                          </c:if>
                          <c:if test="${po.cstrauditstate==1 }">
                          	确认退货
                          </c:if>
                          </TD>
                          <TD>${fn:substring(po.cstrauditdate,0,10)}</TD>
                          <TD>
		                     <input type='button' value='详细' onClick="javascript:detaile('${po.cstrid}')">
		                  </TD>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
  
	
    </BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
