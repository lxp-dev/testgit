<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
</head>
<script>	

	$(document).ready(function() {	
		$('#memberid').focus();
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function details(id,dontshow){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id+"&dontshow="+dontshow,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id+"&dontshow="+dontshow,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【会员信息详细】";
	}
	
	function update(id){
		var moduleID = document.getElementById("moduleID").value;		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initMemberHandUpGradeUpdate.action?hid="+id+"&moduleID="+moduleID,450,155,topRows,topCols,returnRefresh(true),true);		
		document.getElementById('popupTitle').innerHTML="【会员卡升级】";
	}
	
	function search(){
		$("img").removeAttr("onclick");
		customerInfoForm.action = "memberHandUpGradeSel.action";
		customerInfoForm.submit();
		showLoadingBar();
	}

	function clean(){
	    document.getElementById('memberid').value = "";
		document.getElementById('name').value = "";
		document.getElementById('phone').value = "";
		document.getElementById('sex').value = "";
		$('#departmentid').val('');
		$('#agemin').val('');
		$('#agemax').val('');
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
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：会员卡升级</TD>
            <td align="right" valign="bottom">&nbsp;
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
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
              	<c:if test="${permissionPo.keyc eq '1' }">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initMemberUpGradeSel.action?moduleID=${requestScope.moduleID}'"
                      UNSELECTABLE="on">会员积分升级</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                </c:if>      
              	<c:if test="${permissionPo.keyd eq '1' }">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                        <TD class=tab id=tabLabel__1                     
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">会员卡升级</TD>
                        <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" width=3></TD>
                </c:if>      
              	<c:if test="${permissionPo.keye eq '1' }">
                      <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='initUpGradeRecordSel.action?moduleID=${requestScope.moduleID}'" 
                      UNSELECTABLE="on">会员升级记录</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                 </c:if>   
					</TR></TBODY></TABLE></TD>
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
						   <TD width="9%" height="26" class="table_body">会员卡号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="memberid" name="memberid" value="${requestScope.memberid}" />
			               </TD>
			               <TD width="9%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input160" type="text"  id="name" name="name" value="${requestScope.name}" />
			               </TD>
						   <TD width="9%" height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="phone" name="phone" value="${requestScope.phone}" />
			               </TD>
                        </TR>
                        <TR>
                           <TD width="60" height="26" class="table_body">顾客性别</TD>
			               <TD class="table_none">
                            <select id="sex" name="sex">
                            	<option value="">----请选择----</option>
      		                 	<option value="0" ${requestScope.sex!= "0"  ? '' : 'selected="selected"' }>男</option>
      		                 	<option value="1" ${requestScope.sex!= "1"  ? '' : 'selected="selected"' }>女</option>
      	                    </select>
			               </TD>
						   <TD width="60" height="26" class="table_body">会员年龄</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  id="agemin" name="agemin" value="${requestScope.agemin}" maxlength="3"/>&nbsp;至
                            <input class="text_input80" type="text"  id="agemax" name="agemax" value="${requestScope.agemax}" maxlength="3"/>
			               </TD>
			                <TD width="60" height="26" class="table_body">部门</TD>
			               <TD class="table_none">
                           <select id="departmentid" name="departmentID">
      		                 	<option value="">----请选择----</option>
				               	<s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	        </s:iterator>
      	                   </select>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <%--<c:if test="${permissionPo.keya=='1'}">
					</c:if>--%>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()" onkeydown="selectmember1()" >
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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
					<c:if test="${not empty(memberUpGradeList)}"> 
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
                          <TH width="8%" scope=col colspan="2">操作</TH>
                          <TH width="15%" height="26" scope=col>会员卡号</TH>
						  <TH width="10%" scope=col>会员姓名</TH>						
						  <TH width="15%" scope=col>会员积分</TH>
						  <TH width="15%" scope=col>会员类型</TH>
						  <TH width="10%" scope=col>性别</TH>
						  <TH width="10%" scope=col>年龄</TH>
						  <TH scope=col>联系电话</TH>
						  </TR>
						 <s:iterator value="memberUpGradeList">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD width="3%">
		                      	 <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:details('${smecicustomerid}','1')">
			                  </TD>			                   
			                  <TD width="3%">
	                             <img btn=btn src="${ctx }/img/newbtn/levelup_0.png" title='升级' onClick="javascript:update('${smecicustomerid}')">
			                  </TD>
	                          <TD height="26">${smecimemberid}</TD>
	                          <TD>${smeciname}</TD>
							  <td>${smeciintegral}</td>
	                          <TD>${fmmmembername}</TD>
	                          <TD>
	                          <c:if test="${smecisex==0}">
	                              	男
	                          </c:if>
	                          <c:if test="${smecisex==1}">
	                             	 女
	                          </c:if>
	                          </TD>
	                          <TD>${fmmage}</TD>
                          	  <TD>${smeciphone}</TD>
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