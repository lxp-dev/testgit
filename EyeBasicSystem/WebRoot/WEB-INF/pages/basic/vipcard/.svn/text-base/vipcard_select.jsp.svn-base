<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/commons/printBarcode.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打折卡管理</title>
</head>

<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!-- jquery.autocomplete end -->
<script>
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
	    var chks=document.all.chks;
	
	    $('input[id=chk]').each(function(){ 
	        $(this).attr("checked",chks.checked);
	    });
	}
	
	function batPrintGoodsBarCode(){
		var ids = document.getElementsByName("chk");
		var barCode = new Array();
		var discount = new Array();
		var quantity = new Array();
		for(var i=0 ; i< ids.length; i++){
			if(ids[i].checked == true){
				barCode[barCode.length] = ids[i].value;
				discount[discount.length] = ids[i].discount;
				quantity[quantity.length] = "1";
			}
		}
		
		callPrintForDiscountNum(barCode,discount,quantity);
	}
	function print(barcode,discountNum){
		if(confirm("确认打印打折卡吗？")){
			var barCode = new Array();
			var discount = new Array();
			var quantity = new Array();
			
			barCode[barCode.length] = barcode;
			discount[discount.length] = discountNum;
			quantity[quantity.length] = "1";
			
			callPrintForDiscountNum(barCode,discount,quantity);
		}
	}
	
	function exportVipCard(){
		allocationForm.action = "exportVipCard.action"
		allocationForm.submit();
	}
	
	function update(bid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initUpdateVIPCard.action?ssevcidt="+bid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateVIPCard.action?ssevcidt="+bid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【打折卡修改】";
	}
	function search(){
		$("img").removeAttr("onclick");
		allocationForm.action = "selectVIPCard.action";
		allocationForm.submit();
		showLoadingBar();
	}	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertVIPCard.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertVIPCard.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【打折卡新增】";
	}

	function inserts(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertVIPCards.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertVIPCards.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【打折卡批量新增】";
	}
	
	function replace(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initReplaceVIPCard.action?ssevcidt="+id+"&moduleID=${requestScope.moduleID}",550,300,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initReplaceVIPCard.action?ssevcidt="+id+"&moduleID=${requestScope.moduleID}",550,300,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【打折卡更换】";
	}
	
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initDeleteVIPCard.action?ssevcidt="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initDeleteVIPCard.action?ssevcidt="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【打折卡删除】";
	}
	
	function clean(){
	 	$('input[qing=qing]').each(function(){
			$(this).val('');
	 	});
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
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>营销管理</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：打折卡管理</TD>
            <td align="right" width="40%" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            		<img src="${ctx }/img/newbtn/btn_vipinsert_0.png" btn=btn title="打折卡新增" onClick="insert()">
            		<img src="${ctx }/img/newbtn/btn_vipinserts_0.png" btn=btn title="打折卡批量新增" onClick="inserts()">
            	</c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
        <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE>
      <!-- ͷ˵ End --><!-- ѡ Start --><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
          </TD>
        </TR>
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                     <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="90" height="26" class="table_body">打折卡号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text" maxlength="20" id="ssevcidt" name="ssevcidt" value="${requestScope.ssevcidt}" qing="qing">
			               </TD>
			               <TD width="90" height="26" class="table_body">折扣</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text" maxlength="10" id="ssevcdiscountt" name="ssevcdiscountt" value="${requestScope.ssevcdiscountt}" qing="qing">
			               </TD>
			               <TD height="26" class="table_body">有效日期</TD>
			               <TD class="table_none" colspan="3">
                          <li class="horizontal_onlyRight">
                           <input id="ssevcdowntimet"
					       name="ssevcdowntimet" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssevcuptimet\')}'})"
					       value="${requestScope.ssevcdowntimet}" qing="qing"/> 至 
					       <input id="ssevcuptimet"
					       name="ssevcuptimet" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssevcdowntimet\')}'})" 
					        value="${requestScope.ssevcuptimet}" qing="qing"/>
					      </li>
				           <li class="horizontal_onlyRight">
                           <img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('ssevcdowntimet','ssevcuptimet')">
                           </li>
                          <li class="horizontal_onlyRight">
                            <img src="${ctx }/img/newbtn/btn_month_0.png"  btn=btn title="当月" onClick="currtMonth('ssevcdowntimet','ssevcuptimet')">
                            </li>
                            </TD>
                        </TR>
                        <TR>
						    <TD height="26" class="table_body">持卡人姓名</TD>
			                <TD class="table_none">
                            	<input class="text_input160" type="text" id="ssevccustomername" maxlength="20" value="${ssevccustomername}" name="ssevccustomername" qing=qing>
			                </TD>
			                <TD height="26" class="table_body">身份证</TD>
			                <TD class="table_none" valign="middle">
                            	<input class="text_input160" type="text" id="ssevcidcard" maxlength="18" value="${ssevcidcard}" name="ssevcidcard" qing=qing>
                            </TD>
						   <TD height="26" class="table_body">建卡日期</TD>
			               <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input id="ssevcbegindate"
					       name="ssevcbegindate"
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssevcenddate\')}'})"
					       value="${requestScope.ssevcbegindate}" qing="qing"/> 至 
					       <input id="ssevcenddate"
					       name="ssevcenddate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssevcbegindate\')}'})" 
					        value="${requestScope.ssevcenddate}" qing="qing"/>
					      </li>
				           <li class="horizontal_onlyRight">
                           <img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('ssevcbegindate','ssevcenddate')">
                           </li>
                          <li class="horizontal_onlyRight">
                            <img src="${ctx }/img/newbtn/btn_month_0.png"  btn=btn title="当月" onClick="currtMonth('ssevcbegindate','ssevcenddate')">
                            </li>
                            </TD>
                        </TR>
                       <TR>
                           <TD height="26" class="table_body">建卡人工号</TD>
			               <TD class="table_none" colspan="5">
						    <input class="text_input160" type="text" maxlength="20" id="ssevccreatpersonid" name="ssevccreatpersonid" value="${requestScope.ssevccreatpersonid}" qing="qing">
			               </TD>
						   
                        </TR>
                      </TBODY>
                    </table>
                    <TABLE id=title2 cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                        <c:if test="${(permissionPo.keyd==1)}">  
                          <TD align="left">
                              <img id="btnSearch" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
							  <img src="${ctx }/img/newbtn/btn_exportexecl_0.png" btn=btn title='导出打折卡号' onClick="exportVipCard()">
							  <img src="${ctx}/img/newbtn/btn_printbarcode_0.png" btn=btn title="打印条码" id="addGodos"
					      onClick="javascript:batPrintGoodsBarCode();">
						  </TD>
                        </c:if>
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
                    <c:if test="${not empty(vipCardPos)}">
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                        <TH width="15%" height="26" scope=col colspan="5"><input type="checkbox" id="chks" onclick="chkAll()">操作</TH>
                          <TH width="12%" height="26" scope=col>打折卡号</TH>		
                          <TH width="10%" height="26" scope=col>持卡人姓名</TH>			
						  <TH width="8%" scope=col>折扣</TH>
						  <TH width="20%" scope=col>有效期</TH>
						  <TH scope=col>建卡日期</TH>
						  <TH width="10%" scope=col>建卡人工号</TH>
						  <TH width="12%" scope=col>建卡人姓名</TH>
                        </TR>
                       <c:forEach var="po" items="${vipCardPos}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                         <TD width="3%">
		                     <input id="chk" type="checkbox" value="${po.ssevcid }" num="${po.ssevcusecount}" discount="${po.ssevcdiscount}">
			              </TD>
                        
                          <TD width="3%">
                            <c:if test="${(permissionPo.keyb==1)}"> 
                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onclick="update('${po.ssevcid }')">
                          	</c:if>
                          </TD>
                          <TD width="3%">
                            <c:if test="${(permissionPo.keye==1)}"> 
                          		<img src="${ctx }/img/newbtn/replace_0.png" btn=btn title='更换' onclick="replace('${po.ssevcid }')" >
                          	</c:if>
                          </TD>
                          <TD width="3%">
                            <c:if test="${(permissionPo.keyc==1)}"> 
                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onclick="del('${po.ssevcid }')" >
                          	</c:if>
                          </TD>
                          <TD width="3%">
		                     <img src="${ctx }/img/newbtn/print_0.png" btn=btn title='打印' onClick="print('${po.ssevcid }','${po.ssevcdiscount}')">
			              </TD>
						  <TD height="26">${po.ssevcid }</TD>
						  <TD height="26">${po.ssevccustomername }</TD>
						  <TD>${po.ssevcdiscount }</TD>
						  <TD>
						  	<c:if test="${empty po.ssevcdowntime }">
						  		无限制
						  	</c:if>
						  	
						  	<c:if test="${not empty po.ssevcdowntime }"> 
						  		${po.ssevcdowntime }&nbsp;/&nbsp;${po.ssevcuptime }
						  	</c:if>
						  </TD>
						  <TD>${fn:substring(po.ssevcdate,0,16) }</TD>
						  <TD>${po.ssevccreatpersonid }</TD>
						  <TD>${po.ssevccreatpersonname }</TD>
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
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>