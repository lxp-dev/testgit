<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/selectTransferValue.js" type="text/javascript" charset="utf-8"></script>
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
	  	registeredCategoryForm.action=link;
	  	registeredCategoryForm.submit();
		showLoadingBar();
	}
	
	function update(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateRegisteredCategory.action?hid="+id+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateRegisteredCategory.action?hid="+id+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【挂号类别更新】";
	}
	
	function del(id,flag){
		if(flag == "1"){
			alert("启用状态下无法删除");
		}else{
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initDeleteRegisteredCategory.action?hid="+id+"&moduleID=${moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
			}else{
				showPopWin("initDeleteRegisteredCategory.action?hid="+id+"&moduleID=${moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
			}
			document.getElementById('popupTitle').innerHTML="【挂号类别删除】";
		}
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertRegisteredCategory.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertRegisteredCategory.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【挂号类别新增】";
	}
	
	function manager(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initRegisteredCategoryManager.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initRegisteredCategoryManager.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【挂号类别启用/停用】";
	}
	
	function search(){
		registeredCategoryForm.action = "searchRegisteredCategory.action";
		registeredCategoryForm.submit();
		showLoadingBar();
	}
	
	function clean(){
		document.getElementById("frcregisteredname").value="";
		
		var frcregisteredname = document.all.frcregisteredname;
		frcregisteredname.value = "";
	
		var frcregisteredtype = document.all.frcregisteredtype;
		frcregisteredtype.selectedIndex = 0;
		
        var frcfeetype = document.all.frcfeetype
        frcfeetype.selectedIndex = 0;
        
        var frcflag = document.all.frcflag
        frcflag.selectedIndex = 0;
	}
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="registeredCategoryForm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息维护</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：挂号类别维护</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${permissionPo.keya == 1}">
            		<img src="${ctx }/img/newbtn/btn_registeredtypeinsert_0.png" btn=btn title="挂号类别新增" onclick="insert();"/>
            		<IMG src="${ctx }/img/newbtn/btn_registeredqiting_0.png" btn=btn onClick="manager();" title="挂号类别管理启用/停用" >
            	</c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"/>
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
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
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="11%" height="26" class="table_body">检查项名称</TD>
			               <TD width="24%" class="table_none">
			               	<input class="text_input100" id="frcregisteredname" name="frcregisteredname" value="${frcregisteredname}" maxlength="30">
			               </TD>
						   <TD width="8%" class="table_body">挂号类型</TD>
                           <TD width="20%" class="table_none">
						  	<select id="frcregisteredtype" name="frcregisteredtype">
								<option value="">----请选择----</option>
								<option value="1">检查费</option>
								<option value="2">西药费</option>
							</select>
						   </TD>
						   <TD  width="8%"  height="26" class="table_body">收费类型</TD>
                           <TD class="table_none">
						  	<select id="frcfeetype" name="frcfeetype">
								<option value="">----请选择----</option>
								<option value="1">收费</option>
								<option value="2">退费</option>
						    </select>
						  </TD>
                        </TR>
                        <TR>
						  <TD height="26" class="table_body">使用状态</TD>
                          <TD class="table_none" colspan="5">
						  	<select id="frcflag" name="frcflag">
								<option value="">----请选择----</option>
								<option value="1">启用</option>
								<option value="0">停用</option>
							</select>
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyb == 1}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							  <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="search()">
							  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
							</td>
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
                    <c:if test="${not empty(list)}">
	                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
	                      <TBODY>
	                        <TR>
	                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
	                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
	                        </TR>
	                      </TBODY>
	                    </TABLE>
						<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
	                      <TBODY>
	                        <TR class=table_title align=middle>
	                          <TH width="8%" scope=col colspan="2">操作</TH>
	                          <TH width="12%" height="26" >编号</TH>
	                          <TH>检查项名称</TH>
							  <th width="12%" >金额</th>
							  <TH width="13%" >挂号类型</TH>
							  <th width="13%" >收费类型</th>
							  <th width="13%" >统计类型</th>
							  <th width="12%" >使用状态</th>
	                        </TR>
	                        <c:forEach items="${list}" var="item" varStatus="lineNum"> 
	                        	<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                          <TD width="4%">
								  	<c:if test="${permissionPo.keyb == 1}">
								  		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${item.frcid }')">
								  	</c:if>		
								  </TD>
		                          <TD width="4%">
		                          	<c:if test="${permissionPo.keyc == 1}">
		                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${item.frcid }','${item.frcflag}')">
		                          	</c:if>
		                          </TD>
		                          <TD height="26">${item.frcid }</TD>
		                          <TD>${item.frcregisteredname }</TD>
								  <TD>${item.frcmoney }</TD>
								  <TD>
									  <c:if test="${item.frcregisteredtype == 1}">
									  	检查费
									  </c:if>
									  
									  <c:if test="${item.frcregisteredtype == 2}">
									    西药费
									  </c:if>
								  </TD>
								  <TD>
								  	  <c:if test="${item.frcfeetype == 1}">
									  	收费
									  </c:if>
									  
									  <c:if test="${item.frcfeetype == 2}">
									    退费
									  </c:if>
								  </TD>
								  <TD>
								  	  <c:if test="${empty(item.frcamounttype)}">
									  	&nbsp;
									  </c:if>
									  
									  <c:if test="${item.frcamounttype eq '1'}">
									    	验光师
									  </c:if>
								  </TD>
								  <TD>
								   	  <c:if test="${item.frcflag == 0}">
									  	停用
									  </c:if>
									  
									  <c:if test="${item.frcflag == 1}">
									    启用
									  </c:if>
								  </TD>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></BODY></HTML>
<script>
	
	//挂号类型
	<c:if test="${not empty(registeredCategoryPo.frcregisteredtype)}">
		defaultSelValue(document.all.frcregisteredtype,'${registeredCategoryPo.frcregisteredtype}');
	</c:if>
	
	//收费类型
	<c:if test="${not empty(registeredCategoryPo.frcfeetype)}">
		defaultSelValue(document.all.frcfeetype,'${registeredCategoryPo.frcfeetype}');
	</c:if>
	
	//使用状态
	<c:if test="${not empty(registeredCategoryPo.frcflag)}">
		defaultSelValue(document.all.frcflag,'${registeredCategoryPo.frcflag}');
	</c:if>
	
</script>
