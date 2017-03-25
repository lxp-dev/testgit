<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门店所属区域配置</title>
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

	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateRegionalConfiguration.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateRegionalConfiguration.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【门店所属加工区域配置】";
	}	
	function search(){
		regionalConfigurationForm.action = "selRegionalConfiguration.action";
		regionalConfigurationForm.submit();		
		showLoadingBar();
	}
	function clean(){
	    regionalConfigurationForm.bdpregid.value="";
	    regionalConfigurationForm.isConfig.value="";
	}	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="regionalConfigurationForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息维护</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：门店所属加工区域配置</TD>
            <TD align="right" valign="bottom">
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');" />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
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
                    
					<input type="hidden" name="type" id="type" value="" /> 
					<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
					
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <tbody>
                        <tr>
                          <td width="10%" height="26" class="table_body">所属区域</td>
                          <td width="20%"class="table_none">
                               <SELECT id="bdpregid" name="bdpregid"> 
                             	<OPTION value="">----请选择----</OPTION>
                             	<c:if test="${not empty(brcregList)}">
				               	  <s:iterator value="brcregList">
                    	           <OPTION value="${bdpdepartmentid}">${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
							</SELECT>
                          </td>
                          <td width="10%" class="table_body">是否配置</td>
                          <td class="table_none"><select name="isConfig">
                            <option value="">----请选择----</option>
                            <option value="yes">已配置</option>
                            <option value="no">未配置</option>
                           	</select></td>
                        </tr>
                      </tbody>
                    </table>
                    <table id="title2" cellspacing="2">
                      <tr height="10">
                        <td>
                        <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
                        <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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
					<c:if test="${not empty(list)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </table>
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="4%" scope=col>操作</TH>
                          <TH width="40%" scope=col height="26">门店名称</TH>
                          <TH scope=col>所属区域</TH>
                        </TR>
                        <s:iterator value="list">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
                          	<c:if test="${(permissionPo.keyb==1)}">
		                     <img src="${ctx }/img/newbtn/configure_0.png" btn=btn title='配置' onClick="javascript:update('${bdpdepartmentid}')">
		                  	</c:if>
		                  </TD>
                          <TD height="26">${bdpdepartmentname}</TD>
                          <TD>
                          <c:choose>
                          	<c:when test="${not empty(bdpregname)}">
                          		${bdpregname}
                          	</c:when>
                          	<c:otherwise>
                          		未配置
                          	</c:otherwise>
                          </c:choose>
                          	
                          </TD>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    <div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
<script>
	var index_bdpregid = 0;
	var arr = document.all.bdpregid.options.length;
	for(i=0;i<arr;i++){
		if(document.all.bdpregid.options.options[i].value == '<c:out value="${requestScope.bdpregid}"/>'){
			document.all.bdpregid.options.selectedIndex = index_bdpregid;
			break;
		}
		index_bdpregid++;
	}

	var index_isConfig = 0;
	var arr = document.all.isConfig.options.length;
	for(i=0;i<arr;i++){
		if(document.all.isConfig.options.options[i].value == '<c:out value="${requestScope.isConfig}"/>'){
			document.all.isConfig.options.selectedIndex = index_isConfig;
			break;
		}
		index_isConfig++;
	}
	
</script>