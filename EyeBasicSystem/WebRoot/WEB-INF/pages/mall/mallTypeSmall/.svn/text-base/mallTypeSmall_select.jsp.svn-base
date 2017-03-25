<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城管理</title>
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
		mallTypeSmallForm.action = "selectMallTypeSmall.action";
		mallTypeSmallForm.submit();		
		showLoadingBar();
	}
	function clean(){
	    $("[clean=clean]").val("");
	}	
	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateMallTypeSmallPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateMallTypeSmallPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品更新】";
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertMallTypeSmallPo.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertMallTypeSmallPo.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteMallTypeSmallPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteMallTypeSmallPo.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品删除】";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function able(id,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initMallTypeSmallPoAble.action?hid="+id+"&moduleID=${requestScope.moduleID}&flag="+flag+"&bwhname="+EncodeUtf8(name),400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initMallTypeSmallPoAble.action?hid="+id+"&moduleID=${requestScope.moduleID}&flag="+flag+"&bwhname="+EncodeUtf8(name),400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品启用/停用】";
	}

	function uploadPic(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initMallTypeSmallPicUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initMallTypeSmallPicUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}		
		document.getElementById('popupTitle').innerHTML="【上传滚动导航图】";
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mallTypeSmallForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>商城管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品管理</TD>
            <td align="right" valign="bottom">
            	<c:if test="${(permissionPo.keyb==1)}">
            		<img src="${ctx }/img/weixin/btn_weixin_wz_0.png" title="商品新增" btn=btn onClick="insert()">
            	</c:if>
            	<a href="selectMallGoodsList.action" target="_blank">用户Portal</a>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
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
                            </table>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						  <TD width="9%" height="26" class="table_body">商品名称</TD>
			              <TD class="table_none" width="23%"><input clean=clean class="text_input200" id="mtsname" name="mtsname" value="${requestScope.mtsname}"></TD>
                          <TD width="9%" height="26" class="table_body">商品类型</TD>
                          <TD class="table_none" width="23%">
                            <select clean=clean id="mtslargeid" name="mtslargeid">
							<option value="">----请选择----</option>
							<c:if test="${not empty(mallTypeLargeList)}">
			               	  <s:iterator value="mallTypeLargeList" var="mallTypeLargePo">
                   	           <OPTION value="${mallTypeLargePo.mtlid}" ${(mallTypeLargePo.mtlid eq mtslargeid)? ' selected':''}>${mallTypeLargePo.mtlname}</OPTION>
                   	          </s:iterator>
                   	        </c:if>
							</select>
                          </TD>
                          <TD width="9%" height="26" class="table_body">启用状态</TD>
                          <TD class="table_none">
                            <select id="mtsflag" name="mtsflag" clean=clean>
							<option value="">全部</option>
							<option value="0" ${(mtsflag eq '0')? ' selected':''}>启用</option>
							<option value="1" ${(mtsflag eq '1')? ' selected':''}>停用</option>
							</select>
                          </TD>                          
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
						<c:if test="${(permissionPo.keya==1)}">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" id="submitButton" btn=btn title='查询' onClick="javascript:search()">
	                       		<img src="${ctx }/img/newbtn/btn_empty_0.png" title="清空" btn=btn onClick="clean()">
	                        </td>
	                       </c:if>
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
                    <c:if test="${not empty(mallTypeSmallList)}">		
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="19%" scope=col colspan="4">操作</TH>
                          <TH width="20%" height="26" scope=col>商品类型</TH>
                          <TH scope=col>商品名称</TH>
                          <TH width="15%" scope=col>更新日期</TH>
                        </TR>
                        <s:iterator value="mallTypeSmallList" var="po">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                		 	<c:if test="${(permissionPo.keyc==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${po.mtsid}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyd==1)}">
                              <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${po.mtsid}')">
		                  	</c:if>
		                  </TD>
						  <TD width="3%">
							<c:if test="${(permissionPo.keyd==1)}">
								<c:choose>
									<c:when test="${po.mtsflag ne '1'}">
										<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='启用' onClick="javascript:able('${po.mtsid}','0')">
									</c:when>
									<c:otherwise>
										<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='停用' onClick="javascript:able('${po.mtsid}','1')">
									</c:otherwise>
								</c:choose>
							</c:if>
						  </TD>
		                  <TD width="10%">
		                  	<a href="#" onClick="javascript:uploadPic('${po.mtsid}')">上传商品导航图</a>
		                  </TD>		    						  
                          <TD height="26">${po.mtslargename}</TD>
                          <TD>${po.mtsname}</TD>
                          <TD>${fn:substring(po.mtsdatetime,0,16)}</TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
