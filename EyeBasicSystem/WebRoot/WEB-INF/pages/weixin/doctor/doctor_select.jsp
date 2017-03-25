<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家管理</title>
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

	function search(){
		$("img").removeAttr("onclick");
		doctorForm.action = "selectWeiXinDoctor.action";
		doctorForm.submit();
		showLoadingBar();
	}
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateWeiXinDoctorPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateWeiXinDoctorPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【专家信息修改】";
	}

	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertWeiXinDoctorPo.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertWeiXinDoctorPo.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【专家信息新增】";
	}

	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteWeiXinDoctorPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteWeiXinDoctorPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【专家信息删除】";
	}	
	
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteWeiXinDoctorPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteWeiXinDoctorPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【专家信息详细】";
		
	}
	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		$('#doctorForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#doctorForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="doctorForm" name="doctorForm" method="post" action="">
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
            <TD align="left" ><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：专家管理</TD>            
            <td align="right" valign="bottom">&nbsp;
              <c:if test="${(permissionPo.keyb==1)}">  
              <img src="${ctx }/img/newbtn/btn_addyanguangshi_0.png" title="专家新增" btn=btn onClick="insert()">
              </c:if>
              <img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');" />
            </td>            
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
                          <TD width="10%" height="26" class="table_body">验光师编号</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input200" id="personid" name="personid" value="${personid}" maxlength="50"/></TD>
                          
                          <TD width="10%" height="26" class="table_body">验光师姓名</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input200" id="personname" name="personname" value="${personname}" maxlength="50"/></TD>
                          
                          <TD width="10%" height="26" class="table_body">简介职务</TD>
                          <TD width="23%" class="table_none">
                            <input clean="clean" class="text_input200" id="zhiwu" name="zhiwu" value="${zhiwu}" maxlength="50"/>
                          </TD>
                        </TR>
                        <TR>
                          <TD width="10%" height="26" class="table_body">简介职称</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input200" id="zhicheng" name="zhicheng" value="${zhicheng}" maxlength="50"/></TD>
                          
                          <TD width="10%" height="26" class="table_body">所属网点</TD>
                          <TD width="23%" class="table_none">
							<select name="wangdianid" clean="clean">
								<option value="" selected></option>
								<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
									<c:if test="${optionParamPoTmp.fopparentid=='weixin_wangdian'}">
										<option value="${optionParamPoTmp.fopparamid }" ${(optionParamPoTmp.fopparamid eq wangdianid) ? ' selected':'' }>${optionParamPoTmp.fopparamname}</option>
									</c:if>	                                      	
								</c:forEach> 
							</select>				
						  </TD>
                          
                          <TD width="10%" height="26" class="table_body">所属诊疗项目</TD>
                          <TD width="23%" class="table_none">
                            	<select name="zhenliaoid" clean="clean">
								<option value="" selected></option>
								<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
									<c:if test="${optionParamPoTmp.fopparentid=='weixin_zhenliao'}">
										<option value="${optionParamPoTmp.fopparamid }" ${(optionParamPoTmp.fopparamid eq zhenliaoid) ? ' selected':'' }>${optionParamPoTmp.fopparamname}</option>
									</c:if>	                                      	
								</c:forEach> 
							</select>
                          </TD>
                        </TR>                        
                      </TBODY>
                    </TABLE>
               		<c:if test="${(permissionPo.keya==1)}">  
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
                    
                    <c:if test="${not empty(weiXinDoctorList)}">
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
                          <TH width="6%" scope=col colspan="2">操作</TH>
                          <TH width="10%" height="26" scope=col>编号</TH>
                          <TH width="10%" scope=col>姓名</TH>
                          <TH width="10%" scope=col>好评率</TH>
                          <TH width="15%" scope=col>职务</TH>
                          <TH width="15%" scope=col>职称</TH>
                          <TH width="20%" scope=col>出诊时间</TH>
                          <TH scope=col>列表首位</TH>
						  </TR>
					<s:iterator value="weiXinDoctorList" var="po">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyc==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${wdid}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyd==1)}">
		                     <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${wdid}')">
		                  	</c:if>
		                  </TD>
		                 
                          <TD height="26">${wdpersonid}</TD>
                          <TD>${wdname}</TD>
                          <TD>
                          	<c:choose>
                          		<c:when test="${wdhaopinglv eq '-1'}">
                          			暂无评价
                          		</c:when>
                          		<c:otherwise>
                          			${wdhaopinglv}%
                          		</c:otherwise>
                          	</c:choose>                          	
                          </TD>
                          <TD>${wdzhiwu}</TD>
						  <TD>${wdzhicheng }</TD>                          
                          <TD>
                          	<c:choose>
									<c:when test="${!empty wdworkday}">
										<c:set value="${ fn:split(wdworkday, ',') }" var="workdays" />
										<c:forEach items="${ workdays }" var="name" varStatus="status">
											<c:if test="${status.index ne '0'}">
											、
											</c:if>
											<c:choose>
												<c:when test="${name eq '1'}">
													周一
												</c:when>
												<c:when test="${name eq '2'}">
													周二
												</c:when>
												<c:when test="${name eq '3'}">
													周三
												</c:when>
												<c:when test="${name eq '4'}">
													周四
												</c:when>
												<c:when test="${name eq '5'}">
													周五
												</c:when>
												<c:when test="${name eq '6'}">
													周六
												</c:when>
												<c:when test="${name eq '0'}">
													周日
												</c:when>																																																																								
											</c:choose>
										</c:forEach>
									</c:when>
									<c:otherwise>
										暂无出诊时间
									</c:otherwise>
								</c:choose>
                          </TD>
                          <TD>${(wdfirstshow eq '1') ? '√':''}</TD>
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