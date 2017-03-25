<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购订单管理</title>
</head>
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
<!-- jquery.autocomplete end -->

<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function search(){
		$("img").removeAttr("onclick");
		brandForm.action = "selProcurementOrders.action";
		brandForm.submit();
		showLoadingBar();
	}	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initProcurementOrdersUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementOrdersUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【采购订单修改】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementOrdersInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initProcurementOrdersInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【采购订单新增】";
	}
	function del(id, supplierID){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initProcurementOrdersDelete.action?hid="+id+"&bbdsupplierid="+supplierID+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initProcurementOrdersDelete.action?hid="+id+"&bbdsupplierid="+supplierID+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【采购订单删除】";
	}
	function view(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initProcurementOrdersView.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initProcurementOrdersView.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【采购订单详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
	    document.all.billID.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.auditState.value="";
	    document.all.createPersonID.value="";
	    document.all.auditPersonID.value="";
	    document.all.selbspcategoryid.value="";
	    document.all.selcstpsupplierid.value="";
	    document.all.selbspsuppliername.value="";
	    document.all.remark.value=""; 
	    $("#goodsname").val("");
	}
	
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
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selcstpsupplierid').value = json.id;
		document.getElementById('selbspsuppliername').value = json.value;
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>采购管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：采购订单管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            		<img src="${ctx }/img/newbtn/btn_cgddadd_0.png" btn=btn title="采购订单新增" onClick="insert()">
            	</c:if>
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
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <c:if test="${systemParameterPo.fspisshowsupplierandbrand eq '1'}">
        <TR><TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
          <!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='selProcurementOrdersForApp.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">未生成采购订单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">已生成采购订单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
		</c:if>
		<c:if test="${systemParameterPo.fspisshowsupplierandbrand ne '1'}">
        <TR><TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
				&nbsp;
				</TD></TR>
		</c:if>
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
                          <TD class="table_body" width="9%" height="26">订单单号</TD>
                          <TD class="table_none" width="24%"><input class="text_input160" maxlength="20" id="cstpid" name="billID" value="${billID }"></TD>
                          <TD class="table_body" width="9%">制单日期</TD>
                          <TD class="table_none" width="30%"><li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" />
					        </li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
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
						  
                        </TR>
                        <TR>
                          <TD class="table_body">制造商</TD>
						  <TD height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input suppliername=suppliername id="selbspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }"/>
						   		<input supplierid=supplierid type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li>
						  </TD>
						  <TD class="table_body" height="26">商品名称</TD>
                          <TD class="table_none"><input type="text" class="text_input160" maxlength="10" id="goodsname" name="goodsname" value="${goodsname }" />
                          </TD>
                          <TD class="table_body table_body_NoWidth" height="26">审核状态</TD>
                          <TD class="table_none table_none_NoWidth">
                          <select name="auditState" >
                            <option value="" selected>----请选择----</option>
                            <option value='1' ${auditState == 1 ? 'selected="selected"' : '' }>已审核</option>
                            <option value='0' ${auditState == 0 ? 'selected="selected"' : '' }>未审核</option>
                          </select>
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none"><input type="text" class="text_input160" maxlength="10" id="createPersonID" name="createPersonID" value="${createPersonID }" />
                          </TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">
                          	<input type="text" class="text_input160" maxlength="10" id="auditPersonID" name="auditPersonID" value="${auditPersonID }" />
                          </TD>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none"><label>
                          <input id="text" class="text_input200" name="remark" value="${remark}"/>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          	<c:if test="${(permissionPo.keyb==1)}">
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >
							</c:if>
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
					<c:if test="${not empty(orders)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="9%" height="26" scope=col colspan="3">操作</TH>
                          <TH width="10%" scope=col>订单单号</TH> 
                          <TH width="8%" scope=col>商品类别</TH>                        
						  <th width="20%">制造商</th>
						  <TH width="7%" scope=col>制单人</TH>
						  <TH width="13%" scope=col>制单日期</TH>
						  <TH width="7%" scope=col>审核人</TH>
						  <TH width="13%" scope=col>审核日期</TH>
						  <TH scope=col>备注</TH>
                        </TR>
                        <c:forEach var="po" items="${orders}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                          <c:if test="${(permissionPo.keye==1)}">
		                     <img src="${ctx }/img/newbtn/search_0.png" title='详细' btn=btn onClick="javascript:view('${po.cstpid}')">
		                  </c:if>
		                   </TD>
		                   <TD width="3%">
                          <c:choose>
	                          <c:when test="${permissionPo.keyc==1&&po.cstpauditstate != 1}">
	                          	<img src="${ctx }/img/newbtn/edit_0.png" title='修改' btn=btn onClick="update('${po.cstpid }')">
	                          </c:when>
	                          <c:when test="${permissionPo.keyf==1&&po.cstpflag ==0}">
	                          	<img src="${ctx }/img/newbtn/edit_0.png" title='修改' btn=btn onClick="update('${po.cstpid }')">
	                          </c:when>
	                          <c:otherwise>
	                          	<img src="${ctx }/img/newbtn/edit_2.png" title='修改'>
	                          </c:otherwise>                          
                          </c:choose>
                          </TD>
                          <TD width="3%">
                          <c:if test="${(permissionPo.keyd==1)}">
                          	<c:if test="${po.cstpauditstate != 1}">
                          		<img src="${ctx }/img/newbtn/delete_0.png" title='删除' btn=btn onClick="del('${po.cstpid }')" >
                          	</c:if>
                          	<c:if test="${po.cstpauditstate == 1}">
                          		<img src="${ctx }/img/newbtn/delete_2.png" title='删除'>
                          	</c:if>
                          </c:if>
                          </TD>
                          <TD height="26">${po.cstpid }</TD>
                          <td>${po.bgcgoodscategoryname }</td> 
                          <td>${po.bspsuppliername }</td>   
                          <TD>${po.createPersonName }</TD>                       		
                          <TD>${fn:substring(po.cstpbilldate,0,16)}</TD>
                          <TD>${po.auditPersonName }</TD>
                          <TD>${fn:substring(po.cstpauditdate,0,16)}</TD>
                          <TD title="${po.cstpremark}"><div class="autocut50">${po.cstpremark}</div></TD>
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
