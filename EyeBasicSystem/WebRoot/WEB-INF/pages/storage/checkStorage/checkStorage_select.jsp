<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盘点管理</title>
</head>
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />

<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
		if($("#title1").is(":visible"))
        {
        	$("input:text")[0].focus();
        }
	});
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	checkStorageForm.action=link;
	  	checkStorageForm.submit();
		showLoadingBar();
	}
	function search(){
		$("img").removeAttr("onclick");
		checkStorageForm.action = "selInsertCheckStorageSum.action";
		checkStorageForm.submit();
		showLoadingBar();
	}
	function view(id,stockid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCheckStorageSumView.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCheckStorageSumView.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【盘点单详细】";
	}
	function insert(){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertCheckStorageSel.action?moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertCheckStorageSel.action?moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【盘点单新增】";
	}
		
	function audit(id,stockid,goodscategoryID){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCheckStorageSumAudit.action?kid="+stockid+"&hid="+ id+"&moduleID="+moduleID+"&goodscategoryID="+goodscategoryID,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCheckStorageSumAudit.action?kid="+stockid+"&hid="+ id+"&moduleID="+moduleID+"&goodscategoryID="+goodscategoryID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【盘点单审核】";
	}
		
	function buildSCI(id,stockid){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initbuildSCI.action?hid="+id+"&kid="+stockid+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initbuildSCI.action?hid="+id+"&kid="+stockid+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【生成盘盈单】";
	}
		
	function buildSCO(id,stockid){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initbuildSCO.action?hid="+id+"&kid="+stockid+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initbuildSCO.action?hid="+id+"&kid="+stockid+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【生成盘亏单】";
	}
	
	function del(id){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCheckStorageSumDelete.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCheckStorageSumDelete.action?hid="+id+"&moduleID="+moduleID,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【盘点单删除】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		document.getElementById('billID').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('auditState').value = "";
		document.getElementById('auditPersonName').value = "";
		document.getElementById('auditPersonID').value = "";
		document.getElementById('createPersonName').value = "";
		document.getElementById('createPersonID').value = "";
		document.getElementById('stockid').value = "";
		$("#goodscategoryID").val("");
	}
	function selectContact(obj){
		var act = document.activeElement.id;
		
		if(act == "pageNos"&&event.keyCode==13){
			document.getElementById(act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
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
	
	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="checkStorageForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：盘点管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${permissionPo.keya=='1' && warehousesize > 0}">
            		<img src="${ctx }/img/newbtn/btn_checkstockinsert_0.png" btn=btn title="盘点新增" onClick="insert()">
            	</c:if>
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
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
		  </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
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
                          <TD class="table_body" width="10%" height="26">单据编号</TD>
                          <TD class="table_none" width="20%"><input class="text_input160" id="billID" name="billID" value="${billID }" onkeyup="selectContact(this)"></TD>
                          <TD class="table_body" width="10%">单据日期</TD>
                          <TD class="table_none"><li class="horizontal_onlyRight">  <input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /></li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li></TD>
						  <TD class="table_body" height="26" width="10%">制单人</TD>
                          <TD class="table_none"><input type="text" class="text_input160" id="createPersonName" name="createPersonName" value="${createPersonName }" onkeyup="selectContact(this)"/>
                          						<input type="hidden" id="createPersonID" name="createPersonID" value="${selcreatePersonID }" />
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">盘点仓位</TD>
                          <TD class="table_none">
                          <c:if test="${departmenttype == '1'}">
                          	${warehouselist[0].bwhwarehouseName}
                          	<input type="hidden" id="stockid" name="stockid" value="${warehouselist[0].bwhid }" />
                          </c:if>
                          <c:if test="${departmenttype != '1'}">
						  		<select id="stockid" name="stockid" >	
							   	 <option value="">----请选择----</option>
	      		                 <s:iterator value="warehouselist">
					               <option value="${bwhid}" ${stockid == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
		     	                 </s:iterator>
	      	                  </select>
	      	              </c:if>
						  </TD>
                          <TD class="table_body table_body_NoWidth" height="26">审核状态</TD>
                          <TD class="table_none table_none_NoWidth">
                          <select name="auditState" >
                            <option value="" selected>----请选择----</option>
                            <option value='1' ${auditState == 1 ? 'selected="selected"' : '' }>是</option>
                            <option value='0' ${auditState == 0 ? 'selected="selected"' : '' }>否</option>
                          </select></TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none"><input type="text" class="text_input160" id="auditPersonName" name="auditPersonName" value="${auditPersonName }" />
                          						<input type="hidden" id="auditPersonID" name="auditPersonID" value="${selauditPersonID }" />
                          </TD>
                        </TR>
                        <tr>
      	                	<td class="table_body">盘点类型</td>
      	                	<td class="table_none" colspan="5">
      	                	<select id="goodscategoryID" name="goodscategoryID">
      		                 <option value="">----请选择----</option>
      		                  <option value="no" ${goodscategoryID == 'no' ? 'selected="selected"' : '' }>不限定类型</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select></td>
      	                </tr>
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyb=='1'}">
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" ></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
					<c:if test="${not empty(checkStorages)}">
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
                          <TH width="9%" scope=col colspan="3">操作</TH>
                          <TH width="10%" scope=col>盘盈单</TH>
                          <TH width="10%" scope=col>盘亏单</TH>
                          <TH width="15%" height="26" scope=col>盘点单编号</TH>
                          <TH scope=col>盘点单名称</TH>
                          <TH scope=col>盘点类型</TH>
						  <TH width="12%">盘点日期</TH>
                          <TH width="12%">盘点仓位</TH>
                          <TH width="6%" scope=col>盘点人</TH>
                        </TR>
                        <c:forEach var="po" items="${checkStorages}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
		                     <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:view('${po.cshcsbillid}')">
		                  </TD>
                          <TD width="3%">
                          	<c:if test="${po.cshcsauditstate == 1}">
                          		<img src="${ctx }/img/newbtn/audit_2.png" title='审核'/>
                          	</c:if>
                          	<c:if test="${po.cshcsauditstate != 1}">
                          		<img src="${ctx }/img/newbtn/audit_0.png" btn=btn title='审核' onClick="audit('${po.cshcsbillid }','${po.cshcsstockid }','${po.cshccategoryid }')">
                          	</c:if>
                          </TD>
                          <TD width="3%">                          	
                          	<c:if test="${(person.departmenttype != 3) && (person.departmentID != po.cshcsdepartmentid)}">
                          		<img src="${ctx }/img/newbtn/delete_2.png" title='删除'>
                          	</c:if>
                          	<c:if test="${(person.departmenttype == 3) || (person.departmentID == po.cshcsdepartmentid)}">
                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.cshcsbillid }')" >
                          	</c:if>
                          	
                          </TD>
                          <TD>
                          	<c:choose>
                          		<c:when test="${po.cshcsauditstate == 1 && po.cshcsoverage == 0 }" >
                          		<img src="${ctx }/img/newbtn/btn_sciadd_0.png" btn=btn title='生成盘盈单' onClick="javascript:buildSCI('${po.cshcsbillid}','${po.cshcsstockid}')">
                          		</c:when>
                          		<c:when test="${po.cshcsauditstate == 1 && po.cshcsoverage == 1 }" >无盘盈</c:when>
                          		<c:when test="${po.cshcsauditstate == 1 && po.cshcsoverage == 2 }" >已生成盘盈单</c:when>
                          	</c:choose>
		                  </TD>
		                  <TD>
                          	<c:choose>
                          		<c:when test="${po.cshcsauditstate == 1 && po.cshcslosses == 0 }" >
                          		<img src="${ctx }/img/newbtn/btn_scoadd_0.png" btn=btn title='生成盘亏单' onClick="javascript:buildSCO('${po.cshcsbillid}','${po.cshcsstockid }')">
                          		</c:when>
                          		<c:when test="${po.cshcsauditstate == 1 && po.cshcslosses == 1 }" >无盘亏</c:when>
                          		<c:when test="${po.cshcsauditstate == 1 && po.cshcslosses == 2 }" >已生成盘亏单</c:when>
                          	</c:choose>
		                  </TD>
                          <TD height="26">${po.cshcsbillid }</TD>
						  <td>${po.cshcscheckname }</td>
						  <td>${po.cshccategoryname }</td>
                          <TD>${fn:substring(po.cshcscheckdate,0,16)}</TD>
						  <td>${po.cshcsstockname }</td>
                          <TD>${po.cshcscheckstockpersonname }</TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
