<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>收支类型管理</title>		
<script type="text/javascript">
   	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	subjectSelFrm.action=link;
	  	subjectSelFrm.submit();
		showLoadingBar();
	}
	
   /**
    *  新增收支类型
    */ 
	function insert(){	       
		showPopWin("","initInorOutComeTypeInsert.action?moduleID=${moduleID}",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	
   /**
    *  初始化修改收支类型
    */ 
	function update(typeID){	       
		showPopWin("","initInorOutComeTypeUpdate.action?typeID="+typeID+"&moduleID=${moduleID}",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	
   /**
    *  初始化删除收支类型
    */ 
	function del(hid,typeID,typeName){
	    showPopWin("","initInorOutComeTypeDelete.action?hid="+hid+"&typeID="+typeID+"&typeName="+EncodeUtf8(typeName)+"&moduleID=${moduleID}" ,400,250, '',null,true);
		selectHidden();
	}
	
   /**
    *  重置
    */        
	function clean(){
	    $('input[clean=clean]').each(function(){
			$(this).val('');
		});
	}
	
   /**
    *  根据条件查询相关收支类型
    */        
	function search(){
	    subjectSelFrm.action = "inorOutComeTypeSel.action";
	    subjectSelFrm.submit();
		showLoadingBar();
	 }

   /**
    *  收支类型批量导入
    */        
	function batchInsert(){
		//showPopWin("","initBatchInsertSubject.action?moduleID=${moduleID}" ,screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
	 }
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form method="post" id="subjectSelFrm" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;收支类型管理</TD>
          <TD class=menubar_readme_text vAlign=bottom></TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：收支类型查询</TD>
          <TD class=menubar_function_text align=right>          
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
              <!-- 
              <c:if test="${permissionPo.keye=='1'}"> 
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onClick="batchInsert();" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/pic/New.gif" align=textTop 
                  border=0>&nbsp;科目批量新增
                </TD>
               </c:if> 
              -->
               <c:if test="${permissionPo.keya=='1'}"> 
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onClick="insert();" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/pic/New.gif" align=textTop 
                  border=0>&nbsp;收支类型新增
                </TD>
               </c:if> 
              </TR>
              </TBODY></TABLE>
           </TD>
         </TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--ťStart-->                
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initVoucherSel.action';" 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">收支类型查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>										
					</TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="clear">
                      <TBODY>
                        <TR height="30px">
                          <TD width="8%" class="table_body">收支类型代码</TD>
                          <TD width="30%" class="table_none"><input clean="clean" class="text_input200" id="inOrOutComeTypeID" name="inOrOutComeTypeID" type="text" value="${inOrOutComeTypeID}" ></TD>
                          <TD width="10%" class="table_body">收支类型名称</TD>
                          <TD class="table_none" width="30%" colspan="5">
                             <input clean="clean" class="text_input200" id="inOrOutComeTypeName" name="inOrOutComeTypeName" type="text" value="${inOrOutComeTypeName}" >
                          </TD>
                        </TR>
                       
                        </TBODY>
                    </TABLE>
					<table id="searchBar" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${permissionPo.keyd=='1'}">
							<input icon='icon-search' type='button' value='查询' onclick="search()">
							<input type='button' value='清空' icon='icon-reset' onclick="clean()">
						  </c:if>	
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                    <c:if test="${not empty(inOrOutComeTypeList)}">
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
                          <TH scope=col width="15%" height="30">收支类型代码</TH>
						  <TH scope=col width="16%">收支类型名称</TH>                         
						  <TH scope=col width="4%">修改</TH>
						  <TH scope=col width="4%">删除</TH>
                        </TR>
                      <s:iterator value="inOrOutComeTypeList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28">${sLioioTypeID}</TD>
                          <TD>${sLioioTypeName}</TD>                        
                          <c:if test="${sLioioIsDelete=='0'}">
		                 <c:if test="${permissionPo.keyc=='1'}"> 
		                  <TD  width="4%">
                             <input icon='icon-edit' type='button' value='修改' disabled="disabled">
		                  </TD>
		                 </c:if>
		                 <c:if test="${permissionPo.keyb=='1'}">  
                          <TD  width="4%">
                             <input icon='icon-delete' type='button' value='删除' disabled="disabled">
		                  </TD>
		                  </c:if>
		                  </c:if>		                  
		                  <c:if test="${sLioioIsDelete=='1'}">
		                  <c:if test="${permissionPo.keyc=='1'}"> 
		                  <TD  width="4%">
                             <input icon='icon-edit' type='button' value='修改' onClick="javascript:update('${sLioioID}')">
		                  </TD>
		                  </c:if> 
		                  <c:if test="${permissionPo.keyb=='1'}">
		                  <TD  width="4%">
                             <input icon='icon-delete' type='button' value='删除' onClick="javascript:del('${sLioioID}','${sLioioTypeID}','${sLioioTypeName}')">
		                  </TD>
		                  </c:if> 
		                  </c:if>
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
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left"></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>