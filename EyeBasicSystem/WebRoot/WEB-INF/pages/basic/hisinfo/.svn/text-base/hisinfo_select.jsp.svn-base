<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProjectManage</title>
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
			showPopWin("initHisInfoUpdate.action?hisID="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initHisInfoUpdate.action?hisID="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【医院HIS系统修改】";
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initHisInfoInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initHisInfoInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【医院HIS系统新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initHisInfoDetele.action?hisID="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initHisInfoDetele.action?hisID="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【医院HIS系统删除】";
	}

	function search(){
		$("img").removeAttr("onclick");
		hisInfoFrm.action = "selectHisInfo.action";
		hisInfoFrm.submit();
		showLoadingBar();
	}

	function clean(){
		$('#hisInfoFrm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="hisInfoFrm" name="roleFrm" method="post" action="">
	<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<input type="hidden" name="dengji" value="2">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- 头部菜单 Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%">
          	<IMG hspace=3 src="${ctx }/img/pic/module.gif" align=absMiddle vspace=3 border=0>基础信息
          </TD>
          <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：医院HIS系统维护</TD>
          <td align="right" valign="bottom">&nbsp;
          	<c:if test="${(permissionPo.keya == 1)}">
          		<img src="${ctx }/img/newbtn/btn_yyhisxtxz_0.png" btn=btn title="医院HIS系统新增" onclick="insert();"/>
          	</c:if>
          	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
          </td>
        </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
        </TR>
       </TR></TBODY></TABLE><!-- 头部菜单 End --><!-- 选项卡 Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/sys/tab_bg.gif>
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
                          <TD width="10%" height="26" class="table_body">医院HIS系统名称</TD>
                          <TD width="23%" class="table_none"><input clean="clean" class="text_input160" id="hisname" name="hisname" value="${hisname}"/></TD>
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
					
				<c:if test="${(permissionPo.keyd==1) && not empty(hisInfoList) }">	
                   <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                    <TR class=table_title align=middle>                      
                      <TH width="8%" scope=col colspan="2">操作</TH>
                      <TH height="26" scope=col>医院HIS系统名称</TH>
                      <TH scope=col>访问路径</TH>
                    </TR>
	                   <c:forEach items="${hisInfoList}" var="item" varStatus="lineNum">
	                       <tr class=row style="HEIGHT: 26px" align=middle>
	                          <TD width="4%">
	                          	<c:if test="${(permissionPo.keyc==1)}">
                                    <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${item.bhid }')" >
	                          	</c:if>
	                          </TD>
	                          <TD width="4%">
	                          	<c:if test="${(permissionPo.keyb==1)}">
                                    <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${item.bhid }')" >
	                          	</c:if>
	                          </TD>   
	                          <TD height="26">${item.bhhisname}</TD>
	                          <TD>${item.bhhisurl} </TD>
	                       </tr>
	                   </c:forEach>

                      </TBODY>
                    </table>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>