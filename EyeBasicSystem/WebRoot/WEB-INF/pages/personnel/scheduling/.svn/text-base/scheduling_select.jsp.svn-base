<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排班维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	personInfoForm.action=link;
	  	personInfoForm.submit();
		showLoadingBar();
	}
	function search()
	{
		personInfoForm.action = "selSchedulingMonths.action";
		personInfoForm.submit();
		showLoadingBar();
	}
	function updateState(id)
	{
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initAuditSchedulingMonthPo.action?hid="+id+"&isFirst=1&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initAuditSchedulingMonthPo.action?hid="+id+"&isFirst=1&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【月排班审核】";
	}
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selWagePos.action?mid="+id+"&isFirst=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selWagePos.action?mid="+id+"&isFirst=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【月排班更新】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSchedulingDaySel.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSchedulingDaySel.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【月排班新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteSchedulingMonthPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteSchedulingMonthPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【月排班删除】";
	}	
		
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSchedulingMonthDetails.action?hid="+id+"&type=1&isFirst=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSchedulingMonthDetails.action?hid="+id+"&type=1&isFirst=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【月排班详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean()
	{
		document.all.number.value="";
		document.all.entrytime.value="";
		document.all.personName.value="";
		document.all.year.value="";
		document.all.month.value="";
		
	}
	
	
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
	}
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input  id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>      
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>人事管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：排班管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}"> 
            		<img src="${ctx }/img/newbtn/btn_schedulingMonthsinsert_0.png" btn=btn title="排班新增" onclick="insert()"/>
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
        <tr height="20">
        
         <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
		 </TD>
        
        </tr>
      
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
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
						   <TD width="8%" height="26" class="table_body">排班编号</TD>
			               <TD width="24%" class="table_none">
			               	<input class="text_input160" id="number" name="number" value="${number }" />
			               </TD>
							<TD width="8%" height="26" class="table_body">制单人</TD>
                          <TD width="24%" class="table_none">
							<input type="text" class="text_input160" name="createPerson" id="createPerson" value="${createPerson }">
						 </TD>
						 
						   
							<TD width="8%" height="26" class="table_body">审核人</TD>
                          <TD width="24%" class="table_none">
							<input type="text" class="text_input160" name="examinePerson" id="examinePerson" value="${examinePerson }">
						 </TD>
						 
						  			
				   </TR>
                      </TBODY>
                    </TABLE>
               		
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							<c:if test="${(permissionPo.keyb==1)}">  
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >			  	
							</c:if> 
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
					<c:if test="${not empty(schedulingMonthPos)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>

					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="12%" scope=col colspan="3">操作</TH>
                          <TH height="26" scope=col>编号</TH>
                          <TH width="10%" scope=col>年度</TH>
                          <TH width="10%" scope=col>月份</TH>
                          <TH width="10%" scope=col>制单人</TH>
                          <TH width="10%" scope=col>审核人</TH>
                          <TH width="7%" scope=col>审核状态</TH>
                        </TR>
                        <c:forEach var="po" items="${schedulingMonthPos}" >
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="4%">
                        	<img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="detail('${po.msmuuid }')">
                          </TD>
                          <TD width="4%">
                          	<c:if test="${(permissionPo.keyc=='1')}">
                          		<c:if test="${po.msmexaminestate!='1'}">
                          			<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.msmuuid }')" >
                          		</c:if>
                          		<c:if test="${po.msmexaminestate=='1'}">
                          			&nbsp;
                          		</c:if>
                          	</c:if>
                          	<c:if test="${(permissionPo.keyc!='1')}">
                          		&nbsp;
                          	</c:if>
                          </TD>
                           <TD width="4%">
                          	<c:if test="${(permissionPo.keyb=='1')}">
                          		<c:if test="${po.msmexaminestate!='1'}">
                          			<img src="${ctx }/img/newbtn/audit_0.png" btn=btn title='审核' onClick="updateState('${po.msmuuid }')" >
                          		</c:if>
                          		<c:if test="${po.msmexaminestate=='1'}">
                          			&nbsp;
                          		</c:if>
                          	</c:if>	
                          	<c:if test="${(permissionPo.keyb!='1')}">
                          		&nbsp;
                          	</c:if>	
                          </TD>
                          
                          
                          <TD height="26">${po.msmnumber }</TD>
                       
                          
                          <TD>${po.msmyear }</TD>
                          <TD>${po.msmmonth }</TD>
                          
                          <TD>${po.msmcreatepersonname }</TD>
                       
						  <td>${po.msmexaminepersonname }</td>
                         
                          
                          <TD>
                          	<c:if test="${po.msmexaminestate!='1' }">
                          		未审核
                          	</c:if>
                          	<c:if test="${po.msmexaminestate==1 }">
                          		已审核
                          	</c:if>
                          
                          </TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>

<%@ include file="/WEB-INF/inc/message.jsp" %>


