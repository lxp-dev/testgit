<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事考勤</title>
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
 	glassesFrameForm.action=link;
 	glassesFrameForm.submit();
}
	function search(){
		glassesFrameForm.action = "selJBTiao.action";
		glassesFrameForm.submit();
		showLoadingBar();		
	}
	function clean(){
		glassesFrameForm.personid.value="";
		glassesFrameForm.personnames.value="";
		glassesFrameForm.departmentid.value="";
		glassesFrameForm.begindate.value="";
		glassesFrameForm.enddate.value="";
		glassesFrameForm.jbtype.value="";
	}	
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initJBTiaoUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initJBTiaoUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【加班更新】";
	}
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initJBTiaoDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initJBTiaoDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【加班详细】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initJBTiaoInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initJBTiaoInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【加班新增】";		
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initJBTiaoDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initJBTiaoDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【加班删除】";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="hid" value="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>      
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>加班管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：加班查询</TD>
            <td align="right" valign="bottom">
            	<c:if test="${(permissionPo.keya==1)}"> 
            		<img src="${ctx }/img/newbtn/btn_jiaban_0.png " btn=btn title="加班新增" onclick="insert()"/>
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
         <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx }/img/pic/tab_top_bg.gif></TD>        
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
						   <TD width="10%" height="30" class="table_body">ID号</TD>
			               <TD width="23%" class="table_none"><input class="text_input100" name="personid" value="${personid}" /></TD>
					
						   <TD width="10%" height="30" class="table_body">员工姓名</TD>
                          <TD width="23%" class="table_none"><input class="text_input100" name="personnames" value="${personnames }"></TD>
                      
                          <TD width="10%" height="30" class="table_body">所属部门</TD>
                          <TD width="23%" class="table_none">
						  	<select name="departmentid">
						  		<option value="">请选择所属部门</option>
						  		<c:forEach var="po" items="${departments}">
						  		<option value="${po.bdpdepartmentid }" ${departmentid != po.bdpdepartmentid ? '' : 'selected="selected"' }>${po.bdpdepartmentname }</option>
						  		</c:forEach>							
							</select></TD>
                        </TR>
                        <TR>
						   <TD width="10%" height="30" class="table_body">加班时间</TD>
			               <TD colspan="3" class="table_none">
			               <input id="begindate"
					       name="begindate" clean="clean" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'enddate\')}'})"
					       value="${begindate}" /> 
					                  至 
					       <input id="enddate" clean="clean" 
					       name="enddate" 
					       type="text" class="text_input120" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'begindate\')}'})" 
					        value="${enddate}" /> 
			               </TD>
						   <TD width="10%" height="30" class="table_body">加班类型</TD>
                           <TD width="23%" class="table_none">
                          	<select name="jbtype">
						  		<option value="">请选择加班类型</option>
						  		<c:forEach var="po" items="${jbtiaoTypeList}">
						  		<option value="${po.bjbid}" ${jbtype != po.bjbid ? '' : 'selected="selected"' }>${po.bjbname}</option>
						  		</c:forEach>							
							</select>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
               <c:if test="${(permissionPo.keyb==1)}">  
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" ></td>
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
			 		
					<c:if test="${not empty(jbtiaoList)}">
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
                          <TH width="12%" scope=col colspan="3">操作</TH>                        
                          <TH width="10%" height="30" scope=col>ID号</TH>
                          <TH width="10%" scope=col>员工姓名</TH>
						  <th width="20%">所属部门</th>
                          <TH width="10%" scope=col>加班类型</TH>
                          <TH width="30%" scope=col>加班时间</TH> 
                          <TH width="8%" scope=col>加班小时数</TH> 
                        </TR>
                        <c:forEach var="po" items="${jbtiaoList}" >
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="4%">
                          	<c:if test="${(permissionPo.keye==1)}"> 
                          		<img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="detail('${po.id }')">
                        	</c:if> 
                          </TD>
                          <TD width="4%">
                          	<c:if test="${(permissionPo.keyc==1)}">
                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${po.id }')">
                          	</c:if>		
                          </TD>                          
                          <TD width="4%">
                          	<c:if test="${(permissionPo.keyd==1)}">
                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.id }')" >
                          	</c:if>	
                          </TD>                         
                          <TD height="28">${po.pinfoid}</TD>
                          <TD>${po.personname}</TD>
						  <td>${po.departmentname }</td>
                          <TD>${po.jbtypename}</TD>
                          <TD>${po.jbsbtime}至${po.jbxbtime}</TD>
                          <TD>${po.jbtime}</TD>    
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
    </form>
    </BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
