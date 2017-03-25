<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息维护</title>
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
		departmentstForm.action = "printBillTemplateSel.action";
		departmentstForm.submit();
		showLoadingBar();
	}
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initPrintBillTemplateUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPrintBillTemplateUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【报表样式修改】";
	}
	
	function insert(){	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initPrintBillTemplateInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPrintBillTemplateInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【报表样式新增】";
		
	}

	function defaultTemplateConfig(){	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initFittingTemplateTypeSel.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initFittingTemplateTypeSel.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【默认模版配置】";		
	}
	
	function del(id,title){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initPrintBillTemplateDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}&title="+EncodeUtf8(title),400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【报表样式删除】";
	}	
	
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initPrintBillTemplateDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPrintBillTemplateDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【报表样式详细】";
		
	}
	
	function clean(){
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}

	function enbled(id,title,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initPrintBillTemplateEnable.action?hid="+id+"&moduleID=${requestScope.moduleID}&title="+EncodeUtf8(title)+"&flag="+flag,400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【报表样式" + (flag == "1" ? "启用" : "停用") + "】";
    }
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息维护</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：报表样式维护 </TD>
            <td align="right" width="40%" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_defaultTemplateConfig_0.png" btn=btn title="默认模版配置" onClick="defaultTemplateConfig()">
            	<img src="${ctx }/img/newbtn/btn_bbys_0.png" btn=btn title="报表样式新增" onClick="insert()">
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
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
                          <TD width="9%" height="26" class="table_body">模版类型</TD>
                          <TD width="24%" class="table_none">
                              <select clean="clean" id="printbilltype" name="printbilltype">
									<option value="" selected></option>
                                <c:forEach var="fittingTemplateTypePoTmp" items="${fittingTemplateTypeList}" >
                              		<option value="${fittingTemplateTypePoTmp.bfttid }" ${(printbilltype eq fittingTemplateTypePoTmp.bfttid)? 'selected=selected' :'' }>${fittingTemplateTypePoTmp.bfttname}</option>	                                      	
                               	</c:forEach>                              
                              </select>
                          </TD>
                          <TD height="26" width="15%" class="table_body">模版名称</TD>
                          <TD height="26" class="table_none">
	                          <input id="templatename" name="templatename" clean="clean" type="text" class="text_input200" value="${templatename }" />
                          </TD>
                          <TD height="26" class="table_body">启用状态</TD>
                          <TD height="26" class="table_none"><select clean="clean" id="isenabled" name="isenabled">
                            <option value="">----请选择----</option>
                            <option value="1" ${isenabled == '1' ?'selected="selected"':''}>已启用</option>
                            <option value="0" ${isenabled == '0' ?'selected="selected"':''}>已停用</option>
                          </select></TD>
                        </TR>
                        <TR>
                          <TD width="9%" height="26" class="table_body">上传日期</TD>
                          <TD width="24%" class="table_none">
	                          <input id="cstartTime" clean="clean" name="cstartTime" type="text" class="text_input100"  
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'cendTime\')}'})"
						       value="${cstartTime }" readonly="readonly"/>		       
						                  至 <input id="cendTime"
						       name="cendTime"  clean="clean"
						       type="text" class="text_input100" 
						       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'cstartTime\')}'})" 
						        value="${cendTime }" readonly="readonly"/>
                          </TD>
                          <TD height="26" class="table_body">是否为当前使用模板</TD>
                          <TD height="26" class="table_none"><select clean="clean" id="isused" name="isused">
                            <option value="">----请选择----</option>
                            <option value="1" ${isused == '1' ?'selected="selected"':''}>是</option>
                            <option value="0" ${isused == '0' ?'selected="selected"':''}>否</option>
                          </select></TD>
                          <TD height="26" class="table_body">报表服务器</TD>
                          <TD height="26" class="table_none">
							<select clean="clean" id="serverid" name="serverid">
	                            <option value="">----请选择----</option>
	                            <option value="1" ${serverid eq '1' ?'selected="selected"':''}>FineReport</option>
	                            <option value="2" ${serverid eq '2' ?'selected="selected"':''}>ReportingService</option>
                          	</select>
					      </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" ></td>
						</tr>
					</table>
			 		<br/>
			 		<label style="color:red;">若当前样式正在使用时,不能对其进行任何编辑操作!</label>  
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
                    
                    <c:if test="${not empty(fittingTemplateList)}">
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
                          <TH width="12%" scope=col colspan="4">操作</TH>
                          <TH height="26" scope=col>模版名称</TH>
                          <TH width="10%" scope=col>当前使用模板</TH>                           
                          <TH width="15%" scope=col>模版类型</TH>
                          <TH width="12%" height="26" scope=col>上传日期</TH>
                          <TH width="8%" scope=col>上传人</TH>                         
                          <TH width="15%">报表服务器</TH>
						  </TR>
					<s:iterator value="fittingTemplateList">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                              <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onclick="javascript:detail('${bftid}')">
                          </TD>
		                  <TD width="3%">
			                  <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onclick="javascript:update('${bftid}')">
		                  </TD>
		                  <TD width="3%">                              
                              	<c:if test="${(bftcurrentflag ne '1')}">
			                        <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onclick="javascript:del('${bftid}','${bfttemplatename}')">
			                  	</c:if>
			                    <c:if test="${(bftcurrentflag eq '1')}">
			                        <img src="${ctx }/img/newbtn/delete_2.png" title='删除'>
			                  	</c:if>	
		                  </TD>
	                   	  <TD width="3%">
	                   			<c:if test="${(bftcurrentflag ne '1')}">
	                    			<c:if test="${(bftflag=='0')}">
	                    				<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='已停用' onClick="enbled('${bftid}', '${bfttemplatename}','1')">
	                    			</c:if>
	                    			<c:if test="${(bftflag=='1')}">
	                    				<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='已启用' onClick="enbled('${bftid}', '${bfttemplatename}','0')" >
	                    			</c:if>
	                   			</c:if>
	                   			<c:if test="${(bftcurrentflag eq '1')}">
			                        <img src="${ctx }/img/newbtn/unenabled_2.png" title='启用/停用'>
			                  	</c:if>	
	                   	  </TD>
                          <TD height="26" align="left">${bfttemplatename}</TD>
                          <TD>
                              <c:choose>
                                  <c:when test="${bftcurrentflag eq '1'}">√</c:when>
                                  <c:otherwise>&nbsp;</c:otherwise>
                              </c:choose>
						  </TD>                          
                          <TD>
                              <c:forEach var="fittingTemplateTypePoTmp" items="${fittingTemplateTypeList}" >
                              ${(bfttype eq fittingTemplateTypePoTmp.bfttid)? fittingTemplateTypePoTmp.bfttname :'' }	                                      	
                              </c:forEach>                          
                          </TD>
                          <TD>${bftdate}</TD>
                          <TD>${bftpersonname}</TD>
                          <TD>
                          	<c:choose>
                          		<c:when test="${bftserver eq '1'}">FineReport</c:when>
                          		<c:when test="${bftserver eq '2'}">ReportingService</c:when>
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
</body></html>