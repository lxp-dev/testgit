<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它出库管理</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> 
<!-- jquery.autocomplete end -->

<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	salesOutForm.action=link;
	  	salesOutForm.submit();
	}
	function details(id){
		document.all.hid.value = id;
		showPopWin("","initOtherOutDetails.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}	
	function update(id){
		document.all.hid.value = id;
		showPopWin("","initOtherOutUpdate.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function search(){
		$("img").removeAttr("onclick");
		salesOutForm.action = "selOtherOut.action";
		salesOutForm.submit();
	}
	function insert(){
		showPopWin("","initOtherOutInsert.action",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function del(id){
		showPopWin("","initOtherOutDelete.action?hid="+id,400,250, '',null,true);
		selectHidden();
	}

	function clean(){
	    document.all.billID.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.cstidepartmentid.value="";
	    document.all.cstioutstockid.value="";
	    document.all.auditState.value="";
	    document.all.createPersonName.value="";
	    document.all.cstpcreateperson.value="";
	    document.all.auditPersonName.value="";
	    document.all.cstpauditperson.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
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
		document.getElementById('selcstpsupplierid').value = json.id;
		document.getElementById('selbspsuppliername').value = json.value;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="salesOutForm" method="post" action="">
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
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>其它出库管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：其它出库查询</TD>
            <TD class=menubar_function_text align=right>
             <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="insert();" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/New.gif" align=textTop 
                  border=0>&nbsp;其它出库新增</TD>
             </TR></TBODY></TABLE>
            </TD>
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
                      UNSELECTABLE="on">其它出库查询</TD>
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
						   <TD width="10%" height="30" class="table_body">单据编号</TD>
			               <TD class="table_none" width="30%">
                            <input class="text_input200" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			               <TD width="10%" height="30" class="table_body">单据日期</TD>
			               <TD class="table_none">
                             <input class="text_input100"
				               id="startTime"
						       name="startTime" value="${requestScope.startTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime"
						       name="endTime" value="${requestScope.endTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
			               </TD>
                        </TR>
                    	<TR>
			               <TD width="60" height="30" class="table_body">部门</TD>
			               <TD class="table_none">
                            <select id="cstidepartmentid" name="cstidepartmentid">
      		                 	<option value="">请选择部门</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               						   <TD width="60" height="30" class="table_body">仓位</TD>
			               <TD class="table_none">
                            <select id="cstioutstockid" name="cstioutstockid">
      		                 	<option value="">请选择发出仓位</option>
                             	<c:if test="${not empty(warehouseList)}">
				               	  <s:iterator value="warehouseList">
                    	           <OPTION value="${bwhid}" ${requestScope.outstockID!= bwhid  ? '' : 'selected="selected"' } >${bwhwarehouseName}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
                        </TR>
                    	<TR>

			               <TD width="60" height="30" class="table_body">审核状态</TD>
			               <TD class="table_none" colspan="3">
                            <select name="auditState" value="${requestScope.auditState}">
                                    <option value="">请选择审核状态</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
                        </TR>
                         <TR>
                          <TD width="%15" class="table_body" height="30">制单人</TD>
                          <TD width="%35" class="table_none">
                          <input class="text_input200" id="createPersonName" name="createPersonName" value="${createPersonName }">
                          <input type="hidden" class="text_input100" id="createPersonID" name="cstpcreateperson" value="${cstpcreateperson }">
                          </TD>
                          <TD width="%15" class="table_body">审核人</TD>
                          <TD width="%35" class="table_none">
                          <input class="text_input200" id="auditPersonName" name="auditPersonName" value="${auditPersonName }">
                          <input type="hidden" class="text_input100" id="auditPersonID" name="cstpauditperson" value="${cstpauditperson }">
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					<c:if test="${not empty(otherOutList)}"> 
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
                          <TH width="17%" height="30" scope=col>单据编号</TH>
						  <TH width="10%" scope=col>单据日期</TH>						
                          <TH width="15%" scope=col>部门</TH>
						  <TH width="15%" scope=col>仓位</TH>
						  <TH width="5%" scope=col>审核状态</TH>
						  <TH width="5%" scope=col>制单人</TH>
						  <TH width="5%" scope=col>审核人</TH>
						  <TH width="5%" scope=col>详细</TH>
						  <TH width="5%" scope=col>修改</TH>
						  <TH width="5%" scope=col>删除</TH>
						  </TR>
						 <s:iterator value="otherOutList">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD height="28">${cstibillid}</TD>
	                          <TD>${fn:substring(cstibilldate,0,10)}</TD>
							  <td>${cstidepartmentname}</td>
	                          <TD>${cstioutstockname}</TD>
	                          <TD>
	                          <c:if test="${cstiauditstate==1}">
	                              	已审核
	                          </c:if>
	                          <c:if test="${cstiauditstate==0}">
	                             	 未审核
	                          </c:if>
	                          </TD>
	                          <TD>${csticreatepersonname}</TD>
                          	  <TD>${cstiauditpersonname}</TD>
	                          <TD>
		                      	 <input type='button' value='详细' onClick="javascript:details('${cstibillid}')">
			                  </TD>
			                  <TD>
			                  <c:if test="${cstiauditstate==1}">
	                             <input icon='icon-edit' type='button' value='修改' disabled="disabled">
	                          </c:if>
	                          <c:if test="${cstiauditstate==0}">
	                             <input icon='icon-edit' type='button' value='修改' onClick="javascript:update('${cstibillid}')">
	                          </c:if>			                     
			                  </TD>
			                  <TD>
			                  <c:if test="${cstiauditstate==1}">
	                             <input icon='icon-delete' type='button' value='删除'  disabled="disabled">
	                          </c:if>
	                          <c:if test="${cstiauditstate==0}">
	                             <input icon='icon-delete' type='button' value='删除' onClick="javascript:del('${cstibillid}')">
	                          </c:if>		                     
			                  </TD>
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