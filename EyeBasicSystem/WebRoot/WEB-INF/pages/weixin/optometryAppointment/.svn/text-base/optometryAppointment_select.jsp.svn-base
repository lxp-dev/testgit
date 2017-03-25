<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约管理</title>
</head>
<script>
	var timer;
	var x=${systemParameterPo.fspallocationatuotime};
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});
		timer=setInterval('search()','${systemParameterPo.fspallocationatuotime}'*1000);//执行
	});
	
	function countSecond( )
	{
	  x = x-1
	　 document.optometryAppointmentAppointment.displayBox.value=x;
	　setTimeout("countSecond()", 1000);
	}

	function search(){
		$("img").removeAttr("onclick");
		optometryAppointmentAppointment.action = "selectWeiXinOptometryAppointment.action";
		optometryAppointmentAppointment.submit();
		showLoadingBar();
	}
	
	function update(id){
		clearTimeout(timer);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initUpdateWeiXinOptometryAppointmentPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initUpdateWeiXinOptometryAppointmentPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【预约信息修改】";
	}

	function del(id){
		clearTimeout(timer);
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteWeiXinOptometryAppointmentPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteWeiXinOptometryAppointmentPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【预约信息删除】";
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		$('#optometryAppointmentAppointment').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#optometryAppointmentAppointment').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="optometryAppointmentAppointment" name="optometryAppointmentAppointment" method="post" action="">
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
            <TD align="left" ><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：预约管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;距离自动刷新还剩<input type="text" class="text_input10" name="displayBox" value="" readonly="readonly" size=3 >秒</TD>            
            <td align="right" valign="bottom">&nbsp;
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
                          <TD width="10%" height="26" class="table_body">预约网点</TD>
                          <TD width="23%" class="table_none">
                            <select name="wangdianid">
								<option value="" selected></option>
								<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
									<c:if test="${optionParamPoTmp.fopparentid=='weixin_wangdian'}">
										<option value="${optionParamPoTmp.fopparamid }" ${(optionParamPoTmp.fopparamid eq wangdianid) ? ' selected':'' }>${optionParamPoTmp.fopparamname}</option>
									</c:if>	                                      	
								</c:forEach> 
							</select>						  
						  </TD>                       
                          <TD width="10%" height="26" class="table_body">预约人姓名</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input200" id="name" name="name" value="${name}" maxlength="50"/></TD>
                          
                          <TD width="10%" height="26" class="table_body">电话</TD>
                          <TD width="23%" class="table_none">
                            <input clean="clean" class="text_input200" id="mobilephone" name="mobilephone" value="${mobilephone}" maxlength="50"/>
                          </TD>
                        </TR>
						<TR>
                          <TD width="10%" height="26" class="table_body">是否确认</TD>
                          <TD width="23%" class="table_none">
                            <select clean=clean id="isconfirm" name="isconfirm">
							<option value=""></option>
							<option value="0" ${(isconfirm eq '0') ? ' selected':'' }>处理中</option>
							<option value="1" ${(isconfirm eq '1') ? ' selected':'' }>预约成功</option>
							<option value="2" ${(isconfirm eq '2') ? ' selected':'' }>预约失败</option>
							</select>						  
						  </TD>
						  <TD width="9%" height="26" class="table_body">申请时间</TD>
			              <TD class="table_none" width="26%" colspan="3">
			              		<li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input80" clean=clean  
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 
					       <input id="endTime" clean=clean 
					       name="endTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" /> </li><li class="horizontal_onlyRight">	</li>
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
                    
                    <c:if test="${not empty(weiXinOptometryAppointmentList)}">
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
                        <TR class=table_title align=middle height="30">
                          <TH width="6%" scope=col colspan="2">操作</TH>
                          <TH width="8%" scope=col>预约人姓名</TH>
						  <TH width="8%" scope=col>预约时间</TH>
						  <TH width="12%" scope=col>预约手机</TH>                          
                          <TH scope=col>预约网点</TH>
                          <TH width="25%" scope=col>预约内容</TH>
                          <TH width="8%" scope=col>是否确认</TH>
						  </TR>
						<s:iterator value="weiXinOptometryAppointmentList" var="po">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyc==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${woaid}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyd==1)}">
		                     <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${woaid}')">
		                  	</c:if>
		                  </TD>
		                 
                          <TD height="26">${woaname}</TD>
                          <TD>${fn:substring(woadatetime,0,11)}</TD>
                          <TD>${woamobilephone }</TD>
                          <TD>${woawangdian}</TD>
                          <TD>${woacontent}</TD>
                          <TD>
                          	<c:choose>
                          		<c:when test="${woaisconfirm eq '0'}">
                          			处理中
                          		</c:when>
                          		<c:when test="${woaisconfirm eq '1'}">
                          			预约成功
                          		</c:when>                          		
                          		<c:when test="${woaisconfirm eq '2'}">
                          			预约失败
                          		</c:when>
                          		<c:otherwise>
                          			异常数据
                          		</c:otherwise>
                          	</c:choose>
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
    <script>
	countSecond();
	</script>
</body></html>