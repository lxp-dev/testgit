<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它入库结算</title>
</head>
<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!-- jquery.autocomplete end -->
<script>	

	function details(id){
		///document.all.hid.value = id;
		//showPopWin("","initOtherReceiptSettlementDetails.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initOtherReceiptSettlementDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initOtherReceiptSettlementDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【其他入库财务结算详细】";
	}	
	function update(id){
		//document.all.hid.value = id;
		//showPopWin("","initOtherReceiptSettlementUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initOtherReceiptSettlementUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initOtherReceiptSettlementUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【其他入库财务结算更新】";
	}
	function search(){
		$("img").removeAttr("onclick");
		otherReceiptSettlementForm.action = "selOtherReceiptSettlement.action";
		otherReceiptSettlementForm.submit();
		showLoadingBar();
	}

	function clean(){
	    document.all.selbillID.value="";
	    document.all.sourceBillID.value="";
	    document.all.selbspsuppliername.value="";
	    document.all.selcstpsupplierid.value="";
	    //document.all.cstiinstockid.value="";
	    document.all.instockID.value="";
	    document.all.auditState.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	   // document.all.billType.value="";	
	    document.all.financeAuditPersonName.value="";	    
	    document.all.financeAuditPersonID.value="";	
	    document.getElementById('goodsName').value = "";    
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
	          
$(document).ready(function() { 
$("img[btn=btn]").attr("style","cursor: hand"); 
$("img[btn=btn]").mouseover(function () { 
$(this).attr("src",$(this).attr("src").replace("0","1")); 
}).mouseout(function () { 
$(this).attr("src",$(this).attr("src").replace("1","0")); 
}); 
});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="otherReceiptSettlementForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="billID" value="${requestScope.billID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>采购管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：其他入库结算</TD>
            <TD align="right" vAlign=bottom>&nbsp;
            <img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"  />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="20%">
                            <input class="text_input160" type="text"  id="billID" name="selbillID" value="${selbillID}">
			               </TD>
			                <TD height="26" class="table_body">结算人</TD>
			               <TD class="table_none">
	                            <input class="text_input160" type="hidden"  id="financeAuditPersonName" name="financeAuditPersonName" value="${requestScope.financeAuditPersonName}">
	                            <input type="text"  id="financeAuditPersonID" name="financeAuditPersonID" value="${requestScope.financeAuditPersonID}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight">
						   		<input id="selbspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						 <img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" name=ctl00$PageBody$Button1 btn=btn onClick="openSupplier();">
						  </li>
						  </TD>
                        </TR>
                    	<TR>
                    	   <TD height="26" class="table_body">收入仓位</TD>
			               <TD class="table_none">
                            <select id="instockID" name="instockID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="warehouseList">
				               <option value="${bwhid}" ${requestScope.instockID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>						  
			               <TD height="26" class="table_body">审核状态</TD>
			               <TD class="table_none">
                            <select name="auditState" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
			               <TD height="26" class="table_body">审核日期</TD>
			               <TD class="table_none">
                             <li class="horizontal_onlyRight"> <input class="text_input100"
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
						       readonly="readonly" /></li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today()"></li>
			               </TD>			               
                        </TR>
			               <TD height="26" class="table_body">商品名称</TD>
                          <TD class="table_none" colspan="5">
                              <input class="text_input200" id="goodsName" name="goodsName" value="${goodsName}" maxlength="100">
                          </TD>  
                        </TR>   
                                             
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keya=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">

								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">	
							</td>
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
					<c:if test="${not empty(consignProcessSettlementList) }"> 
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
                        <TH width="6%" height="26" scope=col colspan="2">操作</TH>
                          <TH width="13%" scope=col>单据编号</TH>		
                          <TH width="18%" scope=col>制造商</TH>
						  <TH width="8%" scope=col>收货类型</TH>
						  <TH width="10%" scope=col>收入仓位</TH>
						  <TH width="6%" scope=col>审核状态</TH>
						  <TH width="6%" scope=col>审核人</TH>
						  <TH width="12%" scope=col>单据日期</TH>
						  <TH width="12%" scope=col>审核日期</TH>
						  </TR>
						 <s:iterator value="consignProcessSettlementList">
						 <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						   <TD width="3%">
	                          <c:if test="${(permissionPo.keyc==1)}">
	                          	<c:if test="${cstifinanceauditstate == 1}">
			                     <img src="${ctx }/img/newbtn/search_0.png" title='详细' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/search_0.png');"  onClick="javascript:details('${cstibillid}')">
			                    </c:if>
			                    <c:if test="${cstifinanceauditstate != 1}">
			                    <img src="${ctx }/img/newbtn/search_2.png" title='详细'>
			                     </c:if>
			                  </c:if>
			                   </TD>
			                 <TD width="3%">
			                  <c:if test="${(permissionPo.keyb==1)}">
	                          
	                          	<c:if test="${cstifinanceauditstate != 1}">
	                          		<img src="${ctx }/img/newbtn/edit_0.png" title='修改' onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/edit_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/edit_0.png');" onClick="javascript:update('${cstibillid}')">
	                          	</c:if>
	                          	<c:if test="${cstifinanceauditstate == 1}">
	                          		<img src="${ctx }/img/newbtn/edit_2.png" title='修改'>
	                          	</c:if>
	                          </c:if>
	                          </TD>
	                          <TD height="26">${cstibillid}</TD>
	                          <TD>${cstisuppliername}</TD>
	                          <TD>
	                           <c:choose>
				               	<c:when test="${cstibilltypeid=='1'}">
				               		采购收货
				               	</c:when>
				               	<c:when test="${cstibilltypeid=='7'}">
				               		其他入库
				               	</c:when>
				               	<c:when test="${cstibilltypeid=='9'}">
				               		委外收货
				               	</c:when>
				               	<c:otherwise>
				               		未知单据
				               	</c:otherwise>
				               </c:choose>
	                          </TD>
	                          <TD>${cstiinstockname}</TD>
	                          <TD>
	                          <c:choose>
	                          	<c:when  test="${cstifinanceauditstate==1}">
	                          		已审核
	                          	</c:when>
                          		<c:otherwise>
				               		未审核
				               	</c:otherwise>
	                          </c:choose>
	                          </TD>
	                          <TD>${cstifinanceauditpersonname}</TD>
                          	  <TD>${fn:substring(cstibilldate,0,16)}</TD>
                          	  <TD>${fn:substring(cstifinanceauditdate,0,16)}</TD>

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