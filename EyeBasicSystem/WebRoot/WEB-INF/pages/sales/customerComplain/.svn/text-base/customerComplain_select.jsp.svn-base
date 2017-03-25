<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员投诉管理</title>
</head>
<script>	
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#memberid').focus();
	});
	
	 function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initCustomerComplainDetails.action?smechcustomercomplainid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCustomerComplainDetails.action?smechcustomercomplainid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【会员投诉详细】";
	}
	function update(id){
		var moduleID = document.getElementById("moduleID").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initHandleCustomerComplain.action?smechcustomercomplainid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initHandleCustomerComplain.action?smechcustomercomplainid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员投诉处理】";
	}
	function search(){
		$("img").removeAttr("onclick");
		customerInfoForm.action = "selectCustomerComplain.action";
		customerInfoForm.submit();
		showLoadingBar();
	}
	
	function selectmember1(){
		if(event.keyCode==13){
			search();
		}
	}
	
	function insert(){
		var moduleID =document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initInsertCustomerComplain.action?moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertCustomerComplain.action?moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【会员投诉新增】";
	}

	function clean(){
		$("#complainid").val('');
		$("#memberId").val('');
		$("#customername").val('');
		$("#phone").val('');
		$("#complaintype").val('');
		$("#handlepersonname").val('');
		$("#handlestate").val('');
		$("#registerpersonname").val('');
		$("#startTime1").val('');
		$("#startTime2").val('');
		$("#startTime3").val('');
		$("#endTime1").val('');
		$("#endTime2").val('');
		$("#endTime3").val('');
		$("#linkSalesID").val('');
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}

	function del(id){
		var moduleID =document.getElementById('moduleID').value;		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initDeleteCustomerComplain.action?moduleID="+moduleID+"&hid="+id,450,140,topRows,topCols,returnRefresh(true),true);		
		document.getElementById('popupTitle').innerHTML="【会员投诉删除】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="customerInfoForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：会员投诉管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            	<img src="${ctx}/img/newbtn/btn_complaininsert_0.png" btn=btn title="会员投诉新增" onClick="insert()">
            	</c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">会员卡号</TD>
			               <TD class="table_none" width="19%">
                            <input class="text_input160" type="text" maxlength="20" id="memberId" name="memberId" value="${memberId}" tj=tj/>
			               </TD>
			               <TD width="8%" height="26" class="table_body">会员姓名</TD>
			               <TD class="table_none" width="19%">
                             <input class="text_input160" type="text" maxlength="20" id="customername" name="customername" value="${customername}"/>
			               </TD>
						   <TD width="8%" height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text" maxlength="20" id="phone" name="phone" value="${phone}"/>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">投诉单号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text" maxlength="35" id="complainid" name="complainid" value="${complainid}"/>
			               </TD>
						   <TD height="26" class="table_body">投诉类型</TD>
			               <TD class="table_none">
				               <select id="complaintype" name="complaintype">
	      		                 	<option value="">----请选择----</option>
	                             	<c:if test="${not empty(complaintsTypeList)}">
					               	  <s:iterator value="complaintsTypeList">
	                    	           <OPTION value="${bctid}" ${complaintype != bctid  ? '' : 'selected="selected"' } >${bctname}</OPTION>
	                    	          </s:iterator>
	                    	        </c:if>
	      	                   </select>
			               </TD>
						   <TD height="26" class="table_body">投诉时间</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight"><input class="text_input100"
				               id="startTime1"
						       name="complainbegindate" value="${complainbegindate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'endTime1\')}'})"
						       MAXDATE="#F{document.getElementById('endTime1').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime1"
						       name="complainenddate" value="${complainenddate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'startTime1\')}'})"
						       MINDATE="#F{document.getElementById('startTime1').value}"
						       readonly="readonly" /></li>
						     <li class="horizontal_onlyRight">
                           		<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('startTime1','endTime1')">
                           	 </li>
                          	 <li class="horizontal_onlyRight">
                            	<img src="${ctx }/img/newbtn/btn_month_0.png"  btn=btn title="当月" onClick="currtMonth('startTime1','endTime1')">
                             </li>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">处理人</TD>
			               <TD class="table_none">
                             <input class="text_input160" type="text" maxlength="20" id="handlepersonname" name="handlepersonname" value="${handlepersonname}"/>
			               </TD>
                           <TD height="26" class="table_body">处理状态</TD>
			               <TD class="table_none">
			               	<select id="handlestate" name="handlestate">
                            	<option value="">----请选择----</option>
      		                 	<option value="0" ${handlestate != "0"  ? '' : 'selected="selected"' }>未处理</option>
      		                 	<option value="1" ${handlestate != "1"  ? '' : 'selected="selected"' }>处理中</option>
      		                 	<option value="2" ${handlestate != "2"  ? '' : 'selected="selected"' }>已处理</option>
      	                    </select>
			               </TD>
						   <TD height="26" class="table_body">预处理时间</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight"><input class="text_input100"
				               id="startTime2"
						       name="intendhandlebegindate" value="${intendhandlebegindate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'endTime2\')}'})"
						       MAXDATE="#F{document.getElementById('endTime2').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime2"
						       name="intendhandleenddate" value="${intendhandleenddate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'startTime2\')}'})"
						       MINDATE="#F{document.getElementById('startTime2').value}"
						       readonly="readonly" /></li>
						     <li class="horizontal_onlyRight">
                           		<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('startTime2','endTime2')">
                           	 </li>
                          	 <li class="horizontal_onlyRight">
                            	<img src="${ctx }/img/newbtn/btn_month_0.png"  btn=btn title="当月" onClick="currtMonth('startTime2','endTime2')">
                             </li>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">配镜单</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text" maxlength="50" id="linkSalesID" name="linkSalesID" value="${linkSalesID}"/>
			               </TD>
                           <TD height="26" class="table_body">记录人</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text" maxlength="20" id="registerpersonname" name="registerpersonname" value="${registerpersonname}"/>
			               </TD>
                           <TD height="26" class="table_body">处理时间</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight">
                              <input class="text_input100"
				               id="startTime3"
						       name="handlebegindate" value="${handlebegindate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'endTime3\')}'})"
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime3"
						       name="handleenddate" value="${handleenddate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'startTime3\')}'})"
						       readonly="readonly" /></li>
						     <li class="horizontal_onlyRight">
                           		<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('startTime3','endTime3')">
                           	 </li>
                          	 <li class="horizontal_onlyRight">
                            	<img src="${ctx }/img/newbtn/btn_month_0.png"  btn=btn title="当月" onClick="currtMonth('startTime3','endTime3')">
                             </li>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyc=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()" onkeydown="selectmember1()" >
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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
					<c:if test="${not empty(customerComplainPos)}"> 
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
                          <TH width="9%" scope=col colspan="3">操作</TH>
                          <TH width="15%" height="26" scope=col>投诉单号</TH>
						  <TH width="10%" scope=col>会员卡号</TH>						
						  <TH width="7%" scope=col>会员姓名</TH>
						  <TH width="10%" scope=col>投诉类型</TH>
						  <TH width="14%" scope=col>投诉时间</TH>
						  <TH width="14%" scope=col>预处理时间</TH>
						  <TH width="14%" scope=col>处理时间</TH>
						  <TH scope=col>处理状态</TH>
						  </TR>
						 <s:iterator value="customerComplainPos">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD width="3%">
		                      	 <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:details('${smeccuuid}','1')">
			                  </TD>
			                  <TD width="3%">
			                  	<c:if test="${permissionPo.keyb=='1'}">
			                  		<c:if test="${smecchandlestate != '2'}">	
	                             		<img btn=btn src="${ctx }/img/newbtn/doit_0.png" title='处理' onClick="javascript:update('${smeccuuid}')">
			                  		</c:if>
			                  		<c:if test="${smecchandlestate == '2'}">
			                  			<img src="${ctx }/img/newbtn/doit_2.png"  title='处理'>
			                  		</c:if>
			                  	</c:if>
			                  </TD>
			                  <TD width="3%">
			                  	<c:if test="${permissionPo.keyd=='1'}">
			                  		<c:if test="${smecchandlestate == ''}">	
	                             		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${smeccuuid}')">
			                  		</c:if>
			                  		<c:if test="${smecchandlestate == '1' || smecchandlestate == '2'}">
			                  			<img src="${ctx }/img/newbtn/delete_2.png"  title='删除'>
			                  		</c:if>
			                  	</c:if>
			                  </TD>
			                  <TD height="26">${smeccuuid}</TD>
	                          <TD height="26">${smecccustomermemberid}</TD>
	                          <TD>${smecccustomername}</TD>
							  <td>
							  	<s:iterator value="complaintsTypeList">
				               	  	<c:if test="${smecccomplaintype == bctid}">
                    	           		${bctname}
                    	          	</c:if>
                    	        </s:iterator>
							  </td>
	                          <TD>${fn:substring(smeccregisterdate,0,16)}</TD>
	                          <TD>${fn:substring(smeccintendhandledate,0,16)}</TD>
	                          <TD>${fn:substring(smeccnewhandledate,0,16)}</TD>
                          	  <TD>
                          	  	<c:if test="${smecchandlestate == ''}">
                          	  		未处理
                          	  	</c:if>
                          	  	<c:if test="${smecchandlestate == '1'}">
                          	  		处理中
                          	  	</c:if>
                          	  	<c:if test="${smecchandlestate == '2'}">
                          	  		已处理
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