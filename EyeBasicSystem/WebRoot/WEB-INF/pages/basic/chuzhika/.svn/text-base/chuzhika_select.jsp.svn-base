<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>储值卡管理</title>
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
	function exportChuzhiCard(){
		allocationForm.action = "exportChuzhiCard.action";
		allocationForm.submit();
	}
	
	function selectCustomer(){
	if(document.getElementById('smecimemberid').value.trim() != '')
		if(event.keyCode == 13)
			document.forms[0].submit();
	}
	
	function update(bid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initChuzhikaUpdate2.action?bid="+bid+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initChuzhikaUpdate2.action?bid="+bid+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【储值卡修改】";
	}
	function update3(bid,isShowHide){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initChuzhikaUpdate3.action?bid="+bid+"&moduleID=${requestScope.moduleID}&isShowHide="+isShowHide,400,140, topRows,topCols,returnRefresh(true),true); 
		}else{
			showPopWin("initChuzhikaUpdate3.action?bid="+bid+"&moduleID=${requestScope.moduleID}&isShowHide="+isShowHide,400,140, topRows,topCols,returnRefresh(true),true); 
		}
		
		document.getElementById('popupTitle').innerHTML="【储值卡启用/停用】";
	}
	function search(){
		$("img").removeAttr("onclick");
		allocationForm.action = "chuzhikaSel.action";
		allocationForm.submit();
		showLoadingBar();
	}	
	function details(bid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initAdjustmentPriceDetails.action?bid="+bid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initAdjustmentPriceDetails.action?bid="+bid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【储值卡详细】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initChuzhikaInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initChuzhikaInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【储值卡新增】";
	}

	function inserts(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initChuzhikaInserts.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initChuzhikaInserts.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【储值卡批量新增】";
	}
	
	function replace(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initReplaceChuzhika.action?chuzhikaid="+id+"&moduleID=${requestScope.moduleID}",550,300,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initReplaceChuzhika.action?chuzhikaid="+id+"&moduleID=${requestScope.moduleID}",550,300,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【储值卡更换】";
	}
	
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initChuzhikaDel.action?id="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initChuzhikaDel.action?id="+id+"&moduleID=${requestScope.moduleID}",400,140, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【储值卡删除】";
	}
	
	function chongzhi(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initChuzhikaUpdate.action?id="+id+"&moduleID=${requestScope.moduleID}",500,320,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initChuzhikaUpdate.action?id="+id+"&moduleID=${requestScope.moduleID}",500,320,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【储值卡充值】";
	}
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initChuzhikaDetails.action?id="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initChuzhikaDetails.action?id="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【储值卡详细】";
	}
	
	function clean(){
	 	$('#[qing=qing]').each(function(){
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

	function shanchu(){
        if ($('input[id=chk]:checked').size() == 0){
            alert('请选取待删除的储值卡!');
            return;
        }

        var cardID = '';
        $('input[id=chk]:checked').each(function(){ 
        	cardID = cardID + $(this).val() + ',';
        }); 
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initChuzhikaDeleteBatch.action?moduleID=${requestScope.moduleID}&hid="+cardID,400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【批量删除】";
	}

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }	

	function selCustomer(type){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action?type="+type,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action?type="+type,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
	}

    function setCustomer1(memberid,name,cphone,cintegral,customerid){
		document.getElementById('cstczkcustomerid1').value = customerid;
		document.getElementById('cstczkcustomername1').value = name;
	}

    function plqyty(id){
        if ($('input[id=chk2]:checked').size() == 0){
            alert('请选取待启用\停用的储值卡!');
            return;
        }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initChuzhikaEnable.action?moduleID=${moduleID}&id="+id,400,140,topRows,topCols,returnRefresh(true),false);
		document.getElementById('popupTitle').innerHTML="【批量启用\停用】";
    }

	function chkAll2(){  
        var chks=document.all.chks2;
        $('input[id=chk2]').each(function(){ 
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
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：储值卡管理</TD>
            <td align="right" width="40%" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            		<img src="${ctx }/img/newbtn/btn_czkinsert_0.png" btn=btn title="储值卡新增" onClick="insert()">
            		<img src="${ctx }/img/newbtn/btn_czkinserts_0.png" btn=btn title="储值卡批量新增" onClick="inserts()">
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
						   <TD width="8%" height="26" class="table_body">储值卡号</TD>
			               <TD width="20%" class="table_none">
                            <input class="text_input160" type="text" maxlength="20" id="cstczkcardid" name="cstczkcardid" value="${requestScope.cstczkcardid}" qing="qing">
			               </TD>
			               <TD width="8%" class="table_body">建卡人工号</TD>
			               <TD width="20%" class="table_none">
                            <input class="text_input160" type="text" maxlength="20" id="jiankarenid" name="jiankarenid" value="${requestScope.jiankarenid}" qing="qing">
			               </TD>
						   <TD width="8%" class="table_body">建卡人姓名</TD>
			               <TD class="table_none">
						    <input class="text_input160" type="text" maxlength="20" id="jiankarenxingming" name="jiankarenxingming" value="${requestScope.jiankarenxingming}" qing="qing">
			               </TD>
                        </TR>
                        <TR>
						    <TD height="26" class="table_body">绑定会员姓名</TD>
			                <TD class="table_none">
                            	<input class="text_input160" maxlength="20" type="text" id="cstczkcustomername" maxlength="20" value="${cstczkcustomername}" name="cstczkcustomername" qing=qing>
			                </TD>
			                <TD class="table_body">绑定会员</TD>
			                <TD class="table_none" valign="middle">
                            	<li class="horizontal_onlyRight">
									<input qing="qing" class="text_input160" type="hidden" yyorder="12" id="cstczkcustomerid1" maxlength="20" name="cstczkcustomerid" value="${cstczkcustomerid }">
									<input qing="qing" class="text_input60" readOnly="readOnly" id="cstczkcustomername1" name="cstczkcustomername1" value="${cstczkcustomername1 }">
								</li>
								<li class="horizontal_onlyRight"><img id="submitButton" btn=btn src="${ctx}/img/newbtn/btn_search_0.png" title='查询' onClick="selCustomer('1');"></li>	
                            </TD>
						   <TD class="table_body">发放门店</TD>
			               <TD class="table_none">
	                          <select id="cstczkshopcode" name="cstczkshopcode" qing="qing">
	      		                 	<option value="">-----请选择----</option>
	      		                 	<c:forEach var="po" items="${departmentsList}" >
	      		                 		<OPTION value="${po.bdpdepartmentid}" ${(cstczkshopcode eq po.bdpdepartmentid) ? ' selected':''}>${po.bdpdepartmentname}</OPTION>                                     	
									</c:forEach> 
      	                   		</select>
                            </TD>
                        </TR>
						<TR>
			               <TD height="26" class="table_body">身份证</TD>
			               <TD class="table_none" valign="middle">
                            	<input class="text_input160" type="text" maxlength="18" id="cstczkidcard" maxlength="18" value="${cstczkidcard}" name="cstczkidcard" qing=qing>
                           </TD>
						   <TD class="table_body">建卡日期</TD>
			               <TD class="table_none" colspan="3">
                          <li class="horizontal_onlyRight">
                           <input id="jiankaStartDate"
					       name="jiankaStartDate"
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'jiankaEndDate\')}'})"
					       value="${requestScope.jiankaStartDate}" qing="qing"/> 至 
					       <input id="jiankaEndDate"
					       name="jiankaEndDate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'jiankaStartDate\')}'})" 
					        value="${requestScope.jiankaEndDate}" qing="qing"/>
					      </li>
				           <li class="horizontal_onlyRight">
                           <img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('jiankaStartDate','jiankaEndDate')">
                           </li>
                          <li class="horizontal_onlyRight">
                            <img src="${ctx }/img/newbtn/btn_month_0.png"  btn=btn title="当月" onClick="currtMonth('jiankaStartDate','jiankaEndDate')">
                            </li>
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
							  <img src="${ctx }/img/newbtn/btn_exportexecl_0.png" btn=btn title='导出储值卡号' onClick="exportChuzhiCard()">
							   <c:if test="${permissionPo.keyc==1}">
								   <img btn=btn  src="${ctx }/img/newbtn/btn_plsc_0.png" title="批量删除" onClick="javascript:shanchu()">
							   </c:if>		
							   <c:if test="${(permissionPo.keyf==1)}">
							       <img btn=btn  src="${ctx }/img/newbtn/btn_plqy_0.png" title="批量启用" onClick="javascript:plqyty('0')">
							       <img btn=btn  src="${ctx }/img/newbtn/btn_plty_0.png" title="批量停用" onClick="javascript:plqyty('1')">
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
                    <c:if test="${not empty(chuzhikaPos)}">
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
                          <TH width="6%" scope=col>批量删除<input type="checkbox" id="chks" name="chks" onclick="chkAll()"></TH>
                          <TH width="8%" scope=col>批量启用停用<input type="checkbox" id="chks2" name="chks2" onclick="chkAll2()"></TH>                        
                          <TH width="15%" height="30" scope=col colspan="5">操作</TH>
                          <TH width="12%" scope=col>储值卡号</TH>
                          <TH width="8%" scope=col>绑定会员</TH>					
						  <TH width="10%" scope=col>储值金额</TH>
						  <TH width="10%" scope=col>建卡人工号</TH>
						  <TH width="10%" scope=col>建卡人姓名</TH>
						  <TH scope=col>建卡日期</TH>

                        </TR>
                       <c:forEach var="chuzhikaPo" items="${chuzhikaPos}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        <TD>
                        	<c:if test="${(permissionPo.keyc==1) && (chuzhikaPo.cstczkisdelete==1)}">
			                 	<input type="checkbox" id="chk" name="chk" value="${chuzhikaPo.cstczkid}">
			                </c:if>
			            </TD>       
			            <TD>
                        	<c:if test="${(permissionPo.keyf==1)}">
			                 	<input type="checkbox" id="chk2" name="chk2" value="${chuzhikaPo.cstczkid}">
			                </c:if>
			            </TD>                 
                        <TD width="3%">
                          	<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onclick="details('${chuzhikaPo.cstczkid }')">
                        </TD>
                        <TD width="3%">
                            <c:if test="${(permissionPo.keyb==1)}"> 
                          		<img src="${ctx }/img/newbtn/cz_0.png" btn=btn title='充值' onclick="chongzhi('${chuzhikaPo.cstczkid }')">
                          	</c:if>
                        </TD>
                        <TD width="3%">
                            <c:if test="${(permissionPo.keye==1)}"> 
                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onclick="update('${chuzhikaPo.cstczkid }')" >
                          	</c:if>
                        </TD>
                         <TD width="3%">
                           <c:if test="${(permissionPo.keyf==1)}"> 
	                            <c:if test="${(chuzhikaPo.cstshowandhie==0)}">
	                          		<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='停用' onclick="update3('${chuzhikaPo.cstczkid }','1')" >
	                          	</c:if>
	                          	<c:if test="${(chuzhikaPo.cstshowandhie==1)}">
	                          		<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='启用' onclick="update3('${chuzhikaPo.cstczkid }','0')" >
	                          	</c:if>
                          </c:if>
                        </TD>
                        <TD width="3%">
                            <c:if test="${(permissionPo.keyc==1) && (chuzhikaPo.cstczkisdelete==1)}">
                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onclick="del('${chuzhikaPo.cstczkid }')" >
                          	</c:if>
                          </TD>                        
						  <TD height="26">${chuzhikaPo.cstczkcardid }</TD>
						  <TD>${chuzhikaPo.cstczkcustomername }</TD>
						  <TD>${chuzhikaPo.cstczkjine }</TD>
						  <TD>${chuzhikaPo.cstczkcreatepersonid }</TD>
						  <TD>${chuzhikaPo.cstczkcreatepersonname }</TD>
						  <TD>${fn:substring(chuzhikaPo.cstczkcreatedate,0,16) }</TD>
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