<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司维护</title>
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
		companyNameForm.action = "companyNameSel.action";
		companyNameForm.submit();
		showLoadingBar();
	}
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateCompanyName.action?cid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateCompanyName.action?cid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【公司修改】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertCompanyName.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertCompanyName.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【公司新增】";
		
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initDeleteCompanyName.action?fcnID="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【公司删除】";
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		$('#companyNameForm').find("[clean=clean]").each(function(){
			$(this).val('');
		});
	}
	
	function setCompanyAgent(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateCompanyAgent.action?cid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateCompanyAgent.action?cid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【公司供应商配置】";
	}
	
	function download(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initDownloadRegion.action?cid="+id+"&moduleID=${requestScope.moduleID}",450,260,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【公司设置信息下载】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="companyNameForm" name="companyNameForm" method="post" action="">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统设置 </TD>
            <TD align="left" width="30%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：公司维护</TD>
            <td align="right" width="55%" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keyb==1 && person.personcompanytype == '1')}">
            		<img src="${ctx }/img/newbtn/btn_companyinsert_0.png" btn=btn title="公司新增" onClick="insert()">
            	</c:if>
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
                          <TD width="10%" class="table_body">公司名称</TD>
                          <TD class="table_none"><input clean="clean" class="text_input200" id="companyname" name="companyname" value="${companyname}" maxlength="50"/></TD>
                          <TD class="table_body" width="10%">所属区域</TD>
                          <TD class="table_none">
                           	<select id="rid" name="rid" clean="clean">
                            	<option value="">----请选择----</option>
                            	<s:iterator value="regionPos">
                            		<option ${rid eq fcnjrid ? 'selected="selected"' : '' } value="${fcnjrid }">${fcnjrname }</option>
                            	</s:iterator>
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
                    
                    <c:if test="${not empty(companyNamePos)}">
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
                          <TH scope=col>公司名称</TH>
                          <TH width="9%" scope=col>所属区域</TH>
                          <TH width="9%" height="26" scope=col>公司类型</TH>
                          <TH width="10%" scope=col>公司电话</TH>
                          <TH width="9%" scope=col>法人</TH>
                          <TH width="10%" scope=col>手机号码</TH>
						</TR>
					<s:iterator value="companyNamePos">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyc==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${fcnId}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
                          	<c:if test="${(permissionPo.keyf==1)}">
                          		<img src="${ctx }/img/newbtn/configure_0.png" btn=btn title='设置' onClick="setCompanyAgent('${fcnId }')">
                          	</c:if>  
                          </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyd==1) && (fcnmasterorvice != '1')}">
			                  	<c:if test="${person.personcompanytype == '1'}">
	                            	<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${fcnId}')">
			                  	</c:if>
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keye==1) && (fcnmasterorvice != '1')}">
                            	<img src="${ctx }/img/newbtn/download_0.png" btn=btn title='下载' onClick="javascript:download('${fcnId}')">
		                  	</c:if>
		                  </TD>
                          <TD>${fcnName}</TD>
                          <TD>${fcnjrname}</TD>
                          <TD height="26">${fcnmasterorvice == '1' ? '总公司':'分公司'}</TD>
                          <TD>${fcnPhone}</TD>
                          <TD>${fcnlegalperson}</TD>
                          <TD>${fcnlegalpersonphone}</TD>
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