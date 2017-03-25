<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>凭证管理</title>
</head>
<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<!-- jquery.autocomplete end -->

<script>	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	});

	function search(){
		if(checkForm(document.all.overagelossesForm)){
			overagelossesForm.action = "ykselectCheckStorageSum.action";
			overagelossesForm.submit();
			showLoadingBar();
		}
	}	
	function details(id){
		document.all.hid.value = id;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("ykinitCheckStorageSumDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("ykinitCheckStorageSumDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【单据查询】";	
	}

	function clean(){
	    document.all.billID.value="";
	    document.all.sourceBillID.value="";
	    document.all.startTime.value="";
	    document.all.endTime.value="";
	    document.all.stockID.value="";
	    document.all.auditState.value="";
	    
	    document.all.createPersonName.value="";
	    document.all.createPersonID.value="";
	    document.all.auditPersonName.value="";
	    document.all.auditPersonID.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        if(chk.length==0){
        	return false;
        }
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    /**
	 *  调用页面赋值
	 */
	function setValue(){
		var billID='';
		$('input[name=chk]:checked').each(function(){
			billID=billID+$(this).val()+',';
		});
		
		if(billID.indexOf(',') < 0){
			alert('请选择商品!');
        	return false;
		}
		
		window.parent.openGoodSingleValues(billID.substring(0,billID.length-1));
	}
	
	$(document).ready(function(){
	    document.getElementById('billid').focus(); 
    });    

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="overagelossesForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
						   <TD width="80" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="billID" name="billID" value="${requestScope.billID}">
			               </TD>
			               <TD width="80" height="26" class="table_body">盘点单号</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="sourceBillID" name="sourceBillID" value="${requestScope.sourceBillID}">
			               </TD>
                        </TR>
                    	<TR>
						   <TD width="80" height="26" class="table_body">单据类型</TD>
			               <TD class="table_none">
			               			<input type="hidden" name="checksType" value="${requestScope.billType}">
                              <select name="billType" id="billType" disabled>
                                    <option value="">----请选择----</option>
							  		<option value="5" ${requestScope.billType!= "5"  ? '' : 'selected="selected"' }>盘盈</option>
							  		<option value="6" ${requestScope.billType!= "6"  ? '' : 'selected="selected"' }>盘亏</option>
	                          </select>
			               </TD>
			               <TD width="80" height="26" class="table_body">单据日期</TD>
			               <TD class="table_none">
                         <li class="horizontal_onlyRight"> 
                           <input id="startTime"
					       	name="startTime" 
					       	type="text" class="text_input100" 
					      	onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       	value="${startTime }" /> 
					       	至 
					       	<input id="endTime"
					       	name="endTime" 
					       	type="text" class="text_input100" 
					       	onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" />
					        
					     </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('startTime','endTime')"></li>
					        
					        </TD>
                        </TR>
                    	<TR>
						   <TD width="80" height="26" class="table_body">仓位</TD>
			               <TD class="table_none">
                            <select id="stockID" name="stockID" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择仓位！'}]">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">
				                   <option value="${bwhid}" ${requestScope.stockID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
			               <TD width="80" height="26" class="table_body">审核状态</TD>
			               <TD class="table_none">
                              <select name="auditState" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none"><input type="text" class="text_input200" id="createPersonName" name="createPersonName" value="${createPersonName }" />
                          						<input type="hidden" id="createPersonID" name="createPersonID" value="${selcreatePersonID }" />
                          </TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none"><input type="text" class="text_input200" id="auditPersonName" name="auditPersonName" value="${auditPersonName }" />
                          						<input type="hidden" id="auditPersonID" name="auditPersonID" value="${selauditPersonID }" />
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="26">
							<td>
								<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
								<img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
								<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="setValue();" >	
							</td>
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
					<c:if test="${not empty(overagelossesList)}"> 
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
                          <TH width="8%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>
                          <TH width="10%" scope=col>单据编号</TH>
						  <TH width="10%" scope=col>盘点单号</TH>						
                          <TH width="8%" scope=col>单据类型</TH>
						  <TH width="10%" scope=col>单据日期</TH>
						  <TH width="9%" scope=col>收入/发出仓位</TH>
						  <TH width="9%" scope=col>审核日期</TH>
						  <TH width="8%" scope=col>审核状态</TH>
						  <TH width="10%" scope=col>制单人</TH>
						  <TH width="10%" scope=col>审核人</TH>
						  <TH width="8%" scope=col>详细</TH>
						  </TR>
						<s:iterator value="overagelossesList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><input type="checkbox" id="chk" name="chk" value="${cstibillid}"></TD>
                          <TD>${cstibillid}</TD>
                          <TD>${cstisourcebillid}</TD>
                          
                          <TD>
                          <c:if test="${cstibilltypeid==5}">盘盈</c:if>
                          <c:if test="${cstibilltypeid==6}">盘亏</c:if>
                          </TD>
                          
                          <TD>${fn:substring(cstibilldate,0,10)}</TD>
                          
                          <TD>
                          	<c:choose>
                          		<c:when test="${cstibilltypeid == 5 }">${cstiinstockname}</c:when>
                          		<c:when test="${cstibilltypeid == 6 }">${cstioutstockname}</c:when>
                          	</c:choose>
                          </TD>
                          
                          <TD>${fn:substring(cstiauditdate,0,10)}</TD>
                          
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
		                     <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:details('${cstibillid}')">
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