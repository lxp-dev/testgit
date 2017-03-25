<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职务维护</title>
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
		postForm.action = "selPost.action";
		postForm.submit();
	}
	function clean(){
		document.getElementById('bctpostname').value = "";
	}	
	
	function update(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){
			showPopWin("initPostUpdate.action?hid=" +id+"&moduleID="+document.all.moduleID.value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPostUpdate.action?hid=" +id+"&moduleID="+document.all.moduleID.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【职务修改】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		
		if(is_iPad()){
			showPopWin("initPostInsert.action?moduleID="+document.all.moduleID.value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPostInsert.action?moduleID="+document.all.moduleID.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【职务新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		
		if(is_iPad()){
			showPopWin("initPostDelete.action?hid="+id+"&moduleID="+document.all.moduleID.value,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPostDelete.action?hid="+id+"&moduleID="+document.all.moduleID.value,400,140,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【职务删除】";
	}	
	
	function showMin(mptid){
		postForm.action = "selPost.action?pageNo=${pagination.pageNo}&mptid="+mptid;
		postForm.submit();
	}	

	function showLoadingBar(){
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="postForm" method="post" action="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>人事维护</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：职务维护</TD>
            <td align="right" valign="bottom">
            	<c:if test="${(permissionPo.keya==1)}">
            		<img src="${ctx }/img/newbtn/btn_postinsert_0.png" btn=btn title="职务新增" onClick="insert()">
            	</c:if>
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
					
						<input type="hidden" name="type" id="type" value="" />
						<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
									
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <c:if test="${not empty(postMaxList)}">
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                         <TH width="6%" scope=col colspan="2">操作</TH>                         
                         <TH width="10%" height="26" scope=col>展开/折叠</TH>
                          <TH scope=col>职务名称</TH>
                          <TH width="10%" scope=col>类型</TH>
                         
                         
                        </TR>
                        <s:iterator value="postMaxList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                		  	<c:if test="${(permissionPo.keyb==1)}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${mptid}')">
		                  	</c:if>
		                  </TD>
		                  <TD width="3%">
		                  	<c:if test="${(permissionPo.keyc==1)}">
		                  	<c:choose>
                          	<c:when test="${minCount!='0'}">
                          	</c:when>
                        	<c:otherwise>
		               		 <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${mptid}')">
			               	</c:otherwise>
	                        </c:choose>
                            </c:if> 
		                  </TD>
                          <TD height="26">
                           <c:choose>
                          	<c:when test="${requestScope.mptidpage==mptid}">
                          		<a href="#" onClick="javascript:showMin('')">折叠(${minCount})</a>
                          	</c:when>
                        	<c:otherwise>
		               			<a href="#" onClick="javascript:showMin('${mptid}')">展开(${minCount})</a>
			               	</c:otherwise>
	                       </c:choose>
                          </TD>
                          </when>
                          <TD height="26">${mptcontent}</TD>
                          <TD><c:choose>
			                          	<c:when test="${mptdeptid=='1'}">职务</c:when>
			                          	<c:when test="${mptdeptid=='2'}">职级</c:when>
			                          </c:choose></TD>
                        </TR>
		                 <c:if test="${requestScope.mptidpage == mptid}">
	                        <c:if test="${not empty(postMinList)}">
	                        	<s:iterator value="postMinList">
			                        <TR>
			                          <TD width="4%" align="center">
					                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${mptid}')">
					                  </TD>
					                  <TD width="4%" align="center">
			                             <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${mptid}')">
					                  </TD>			                        
			                          <TD height="26">&nbsp;</TD>
			                          <TD height="26" align="center">${mptcontent}</TD>
			                          <TD align="center">
			                          <c:choose>
			                          	<c:when test="${mptdeptid=='1'}">职务</c:when>
			                          	<c:when test="${mptdeptid=='2'}">职级</c:when>
			                          </c:choose>
										</TD>

			                        </TR>
			                     </s:iterator>
	                        </c:if>
	                    </c:if>
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