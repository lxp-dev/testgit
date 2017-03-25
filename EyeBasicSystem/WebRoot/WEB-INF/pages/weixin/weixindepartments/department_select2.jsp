<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门维护</title>
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
	function enbled(id,name,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initSeeDepartment.action?hid="+id+"&name="+EncodeUtf8(name)+"&flag="+flag+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【部门可见/不可见】";
	}

	function enbled2(id,name,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initOptometryAppointmentDepartment.action?hid="+id+"&name="+EncodeUtf8(name)+"&flag="+flag+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【部门可预约/不可预约】";
	}
	
	function search(){
		$("img").removeAttr("onclick");
		departmentstForm.action = "WeidepartmentSel.action";
		departmentstForm.submit();
		showLoadingBar();
	}
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initWeiDepartmentsUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initWeiDepartmentsUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【部门修改】";
	}

	function uploadPic(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initWeiDepartmentPicUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initWeiDepartmentPicUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【上传门店实景图】";
	}
		
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWeiDepartmentDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initWeiDepartmentDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【部门详细】";
		
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>微信管理 </TD>
            <TD align="left" ><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：附近门店管理</TD>
            <TD align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title="显隐查询条件" btn=btn onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
					      <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
					      <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
					      </TR>
					    </TBODY>
					  </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="10%" height="26" class="table_body">部门编号</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input200" id="departmentID" name="departmentID" value="${departmentID}" maxlength="50"/></TD>
                          
                          <TD width="10%" height="26" class="table_body">部门名称</TD>
                          <TD width="23%" class="table_none" colspan="3"><input clean="clean" class="text_input200" id="departmentName" name="departmentName" value="${departmentName}" maxlength="50"/></TD>
                        </TR>
                         <TR>
                          <TD width="10%" height="26" class="table_body">门店列表是否可见</TD>
                          <TD width="23%" class="table_none">
                          	<select clean="clean" name="issee">
	                          	<option value=""></option>
	                          	<option value="0" ${(issee eq '0') ? ' selected':'' }>可见</option>
	                          	<option value="1" ${(issee eq '1') ? ' selected':'' }>不可见</option>
                          	</select> 
                          </TD>                          
                          <TD width="10%" height="26" class="table_body">是否可预约</TD>
                          <TD width="23%" class="table_none" colspan="3">
                          	<select clean="clean" name="isoptometryappointment">
	                          	<option value=""></option>
	                          	<option value="0" ${(isoptometryappointment eq '0') ? ' selected':'' }>可预约</option>
	                          	<option value="1" ${(isoptometryappointment eq '1') ? ' selected':'' }>不可预约</option>
                          	</select> 
						  </TD>
                        </TR>                      
                      </TBODY>
                    </TABLE>
               		<c:if test="${(permissionPo.keyd==1)}">  
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
                    
                    <c:if test="${not empty(departmentList)}">
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
                          <TH width="19%" scope=col colspan="4">操作</TH>
                          <TH width="5%" height="26" scope=col>编号</TH>
                          <TH width="20%" scope=col>部门名称</TH>
                          <TH width="15%" scope=col>电话</TH>
                          <TH scope=col>地址</TH>
                          <TH scope=col width="10%">微信是否可见</TH>
						  </TR>
					<s:iterator value="departmentList">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyc==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${bdpdepartmentid}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyc==1)}">
		                  		   <c:if test="${bdpissee eq 1}">
	                    				<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='可见' onClick="enbled('${bdpdepartmentid}','${bdpdepartmentname}','1')" >
	                    			</c:if>
	                    			<c:if test="${bdpissee eq 0 ||bdpissee eq null}">
	                    				<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='不可见' onClick="enbled('${bdpdepartmentid}','${bdpdepartmentname}','0')" >
	                    	       </c:if>		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyc==1)}">
		                  		   <c:if test="${bdpisoptometryappointment eq '1'}">
	                    				<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='可预约' onClick="enbled2('${bdpdepartmentid}','${bdpdepartmentname}','1')" >
	                    			</c:if>
	                    			<c:if test="${bdpisoptometryappointment eq '0'}">
	                    				<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='不可预约' onClick="enbled2('${bdpdepartmentid}','${bdpdepartmentname}','0')" >
	                    	       </c:if>		                  	</c:if>
		                  </TD>		                  
		                  <TD width="10%">
		                  	<a href="#" onClick="javascript:uploadPic('${bdpdepartmentid}')">上传实景图</a>
		                  </TD>		                 
                          <TD height="26">${bdpdepartmentid}</TD>
                          <TD>${bdpdepartmentname}</TD>
                          <TD>${bdpphone }</TD>
                          <TD>${bdpaddress}</TD>
                          <TD>${(bdpissee eq 0 ||bdpissee eq null) ? "可见" : "不可见" }</TD>
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