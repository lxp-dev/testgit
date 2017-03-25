<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代金券管理</title>
</head>

<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!-- jquery.autocomplete end -->
<script>
	function trim(str){ //删除左右两端的空格
	    return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});
	
		var bcctype = '${requestScope.cardtype}'.split(',');
	
		for(var i=0; i<bcctype.length; i++){
			$('#bcctype'+bcctype[i].trim()).attr("checked","checked");
		}
	});	
	
	function update(bid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initCashCouponUpdate.action?bid="+bid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCashCouponUpdate.action?bid="+bid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【代金券修改】";
	}
	function search(){
    	var amount1=document.all.amount1.value;
    	if (amount1 != '' && amount1 != null){
    	    var str = amount1.replace(/[^\.]/g,'');
    	    if (str.length > 1){
    	        alert("代金券金额格式不正确!");
    	        $('#amount1').val('');
    	        return;
    	   }
    	}
    	var amount2=document.all.amount2.value;
    	if (amount2 != '' && amount2 != null){
    	    var str = amount2.replace(/[^\.]/g,'');
    	    if (str.length > 1){
    	        alert("代金券金额格式不正确!");
    	        $('#amount2').val('');
    	        return;
    	   }
    	}

		$("img").removeAttr("onclick");
		allocationForm.action = "selCashCoupon.action";
		allocationForm.submit();
		showLoadingBar();
	}	

	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCashCouponInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCashCouponInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【代金券新增】";
	}

	function inserts(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCashCouponInserts.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCashCouponInserts.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【代金券批量新增】";
	}
	
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initCashCouponDelete.action?bid="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initCashCouponDelete.action?bid="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【代金券删除】";
	}
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCashCouponDetails.action?bid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCashCouponDetails.action?bid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【代金券详细】";
	}
	
	function clean(){
		allocationForm.reset();
	 	$('input[qing=qing]').each(function(){
				$(this).val('');
		});
	 	
	 	$('select[id=useflag]').val('');
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

	function shanchu(){
        if ($('input[id=chk]:checked').size() == 0){
            alert('请选取待删除数据!');
            return;
        }

        var cardID = '';
        $('input[id=chk]:checked').each(function(){ 
        	cardID = cardID + $(this).val() + ',';
        }); 
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initCashCouponDeleteBatch.action?moduleID=${requestScope.moduleID}&hid="+cardID,400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【批量删除】";
	}

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
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
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：代金券管理</TD>
            <td align="right" width="40%" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            		<img src="${ctx }/img/newbtn/btn_djqinsert_0.png" btn=btn title="代金券新增" onClick="insert()">
            		<img src="${ctx }/img/newbtn/btn_djqinserts_0.png" btn=btn title="代金券批量新增" onClick="inserts()">
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
          <TD colSpan=2 height=5></TD>
         </TR>
          </TBODY>
        </TABLE>
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
						   <TD width="11%" height="26" class="table_body">代金券号</TD>
			               <TD width="20%" class="table_none">
                            <input class="text_input160" type="text" maxlength="20" id="card" name="card" value="${requestScope.card}" qing="qing">
			               </TD>
			               <TD width="11%" height="26" class="table_body">代金券金额</TD>
			               <TD width="20%" class="table_none">
                            <input class="text_input60" type="text" maxlength="20" id="amount1" name="amount1" value="${requestScope.amount1}" qing="qing" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}">
                            至
                            <input class="text_input60" type="text" maxlength="20" id="amount2" name="amount2" value="${requestScope.amount2}" qing="qing" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}">
			               </TD>
						   <TD width="11%" height="26" class="table_body">有效期</TD>
			               <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input id="cardbegindate"
					       name="cardbegindate"
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'cardenddate\')}'})"
					       value="${requestScope.cardbegindate}" qing="qing"/> 至 
					       <input id="cardenddate"
					       name="cardenddate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'cardbegindate\')}'})" 
					        value="${requestScope.cardenddate}" qing="qing"/>
			               </TD>
			               </TR>
			                                       <TR>
						    <TD height="26" class="table_body">代金券使用状态</TD>
			                <TD class="table_none">
                             <select id="useflag"  name="useflag">
                                 <option value="" ${requestScope.useflag == '' ? 'selected="selected"' : '' }>----请选择----</option>
                                 <option value="1" ${requestScope.useflag == '1' ? 'selected="selected"' : '' }>使用</option>
                                 <option value="0" ${requestScope.useflag == '0' ? 'selected="selected"' : '' }>未使用</option>
                             </select>
			                </TD>

						    <TD height="26" class="table_body">消费类型</TD>
			                <TD class="table_none" colspan="3">
                            <input type="checkbox" value="1" id="bcctype1" name="cardtype" >框镜
                            <input type="checkbox" value="2" id="bcctype2" name="cardtype" >隐形
							<input type="checkbox" value="3" id="bcctype3" name="cardtype" >辅料
							<input type="checkbox" value="4" id="bcctype4" name="cardtype" >挂号
							<input type="checkbox" value="5" id="bcctype5" name="cardtype" >维修费
			                </TD>			                
                        </TR>
                        <TR>
						   <TD width="11%" height="26" class="table_body">使用顾客</TD>
			               <TD width="20%" class="table_none">
                            <input class="text_input120" type="text" maxlength="20" id="usecustomer" name="usecustomer" value="${requestScope.usecustomer}" qing="qing">
			               </TD>
			               <TD width="11%" height="26" class="table_body">使用日期</TD>
			               <TD width="20%" class="table_none" colspan="3">
                            <input id="usedate1"
					       name="usedate1"
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'cardenddate\')}'})"
					       value="${requestScope.usedate1}" qing="qing"/> 至 
					       <input id="usedate2"
					       name="usedate2" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'cardbegindate\')}'})" 
					        value="${requestScope.usedate2}" qing="qing"/>
			               </TD>
			               </TR>
                      </TBODY>
                    </table>
                    <TABLE id=title2 cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                        <c:if test="${(permissionPo.keyb==1)}">  
                          <TD align="left">
                              <img id="btnSearch" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
							   <c:if test="${permissionPo.keyd==1}">
								 <img btn=btn  src="${ctx }/img/newbtn/btn_plsc_0.png" title="批量删除" onClick="javascript:shanchu()">
							   </c:if>								
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
                    <c:if test="${not empty(cashCouponList)}">
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
                          <TH width="3%" scope=col><input type="checkbox" id="chks" name="chks" onclick="chkAll()"></TH>
                          <TH width="9%" height="26" scope=col colspan="3">操作</TH>
                          <TH width="15%" height="26" scope=col>代金券号</TH>
                          <TH width="10%" height="26" scope=col>代金券金额</TH>					
						  <TH scope=col>有效期</TH>
						  <TH width="10%" scope=col>消费类型</TH>
						  <TH width="10%" scope=col>使用顾客</TH>
						  <TH width="13%" scope=col>使用日期</TH>

                        </TR>
                       <c:forEach var="cashCouponPo" items="${cashCouponList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        <TD>
                        	<c:if test="${(permissionPo.keyd==1) && empty(cashCouponPo.bccusedate)}">
			                 <input type="checkbox" id="chk" name="chk" value="${cashCouponPo.bcccard}">
			                </c:if>
			            </TD>
                        <TD width="3%">
                            <c:if test="${(permissionPo.keye==1)}">
                          	    <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onclick="details('${cashCouponPo.bccid}')">
                          	</c:if>
                        </TD>

                        <TD width="3%">
                            <c:if test="${(permissionPo.keyc==1)}"> 
                              <c:if test="${empty(cashCouponPo.bccusedate)}">
                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onclick="update('${cashCouponPo.bccid}')" >
                          	  </c:if>
                          	</c:if>
                        </TD>
                        <TD width="3%">
                            <c:if test="${(permissionPo.keyd==1) && empty(cashCouponPo.bccusedate)}">
                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onclick="del('${cashCouponPo.bccid}')" >
                          	</c:if>
                          </TD>
						  <TD height="26">${cashCouponPo.bcccard}</TD>
						  <TD>${cashCouponPo.bccamount}</TD>
						  <TD>${cashCouponPo.bccbegindate}~${cashCouponPo.bccenddate}</TD>
						  <TD>${cashCouponPo.bcctype}</TD>
						  <TD>${cashCouponPo.bcccustomer}</TD>
						  <TD>${cashCouponPo.bccusedate}</TD>
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