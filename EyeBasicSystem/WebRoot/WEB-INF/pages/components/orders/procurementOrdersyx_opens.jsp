<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择采购订单</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
	function search(){
		if(checkForm(document.all.goodsForm)){
			$("img").removeAttr("onclick");  
			goodsForm.action = "selProcurementOrdersForOpensyx.action";
			goodsForm.submit();
			showLoadingBar();
		}
	}
	function clean(){
		document.getElementById('poID').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('supplierName').value = "";
		document.getElementById('supplierID').value = "";
		document.getElementById('category').value = "";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}	

	/**
	 *  调用页面赋值
	 */
	function setValueorders(poID,id,name,type){ 	
		window.parent.setValueorders(poID,id,name,type);
		parent.hidePopWin();       
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
		
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="poType" value="${requestScope.poType }" />

<div style="width:100px;height:12px;left:expression(document.body.clientWidth-scrollWidth);top:expression(scrollHeight+15+document.body.scrollTop-this.offsetHeight);position:absolute">
			<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD ></TD>
                        </TR>
                      </TBODY>
                    </TABLE></div>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
    <br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
                          <TD class="table_body" width="10%" height="30">单据编号</TD>
                          <TD class="table_none" width="40%"><input class="text_input200" id="poID" name="poID" value="${poID}"></TD>
                          <TD width="10%" class="table_body">所属制造商</TD>
						   	<TD width="40%" height="30" align="left" class="table_none">
						   		<li class="horizontal_onlyRight">
						   		&nbsp;<input id="supplierName" class="text_input200" name="supplierName" value="${supplierName }" readonly="readonly" />
						   		<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }"/>
						   </li>
						   <input type="hidden" name="updatepage" value="${updatepage}"/>
						   <c:if test="${updatepage != 'u'}">
						   		
							   <li class="horizontal_onlyRight">
							   	<img src="${ctx }/img/newbtn/btn_change_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');" title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();">
							   </li>
						   </c:if>
						   <c:if test="${updatepage == 'u'}">
						   		
							   <li class="horizontal_onlyRight">
							   	<INPUT icon="icon-zoom" type=button value="选 择" disabled="disabled">
							   </li>
						   </c:if>
						 </TD>
                        </TR>							 
						<TR> 					 
                          <TD class="table_body" width="10%">单据日期</TD>
                          <TD class="table_none"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /></TD>
					      <TD class="table_body" width="10%">采购类型</TD>
                          <TD class="table_none">
                          <c:if test="${categoryID == ''}">
	                          <select id="category" name="category">
						  		<option value="">----请选择----</option>
								<option value="4" ${category== '4' ? 'selected="selected"':''} >隐形</option>
								<option value="5" ${category== '5' ? 'selected="selected"':''} >护理液</option>
	                          </select>
                          </c:if>
                          
                          <c:if test="${categoryID != ''}">
                          	  <input type="hidden" name="categoryID" value="${categoryID}"/>
	                          <select id="category" name="category" disabled="disabled">
						  		<option value="">----请选择----</option>
								<option value="4" ${categoryID== '4' ? 'selected="selected"':''} >隐形</option>
								<option value="5" ${categoryID== '5' ? 'selected="selected"':''} >护理液</option>
	                          </select>
                          </c:if>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img src="${ctx }/img/newbtn/btn_search_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_search_0.png');"  title='查询' onclick="javascript:search()">
<img src="${ctx }/img/newbtn/btn_empty_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');" title='清空' onclick="clean()" >
</TD>
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(procurementOrdersList)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                        <TH width="4%" scope=col>操作</TH>
                          <TH width="14%" height="30" scope=col>单据编号</TH>
                          <th width="10%">采购类别</th>
						  <th width="20%">制造商</th>
                          <TH width="10%" scope=col>制单人</TH>
                          <TH width="10%" scope=col>审核人</TH>
                          <TH width="10%" scope=col>采购日期</TH>
                        </TR>
                        <c:forEach var="po" items="${procurementOrdersList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                         <TD>
		                    <img src="${ctx }/img/newbtn/select_0.png" title='选择' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/select_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/select_0.png');"onClick="javascript:setValueorders('${po.cstpid}','${po.cstpsupplierid }','${po.bspsuppliername }','${ updatepage}')">
		                  </TD>
                          <TD height="28">${po.cstpid }</TD>
                          <TD height="28">${po.bgcgoodscategoryname}</TD>
						  <td>${po.bspsuppliername }</td>
                          <TD>${po.createPersonName }</TD>
                          <TD>${po.auditPersonName }</TD>
                          <TD>${fn:substring(po.cstpbilldate,0,10)}</TD>
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
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
