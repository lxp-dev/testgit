<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外误期管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	delaysManagementForm.action=link;
	  	delaysManagementForm.submit();
		showLoadingBar();
	}
	/*查询*/
	function search(){
		delaysManagementForm.action = "selectOrderDelaysRemindert.action";
		delaysManagementForm.submit();
		showLoadingBar();
	}
	
		/*选择事件*/
	function setCustomer(ssesbsalesid ,ssesbtakeglassdata ){
		window.parent.setCustomer(ssesbsalesid ,ssesbtakeglassdata );
		parent.hidePopWin();
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}	


	function clean(){
		document.getElementById('salesid').value = "";
		document.getElementById('customerName').value = "";
		document.getElementById('shopcode').value = "";
		document.getElementById('takeglassstartdata').value = "";
		document.getElementById('takeglassenddata').value = "";
		
	}		
	
</script>
<!-- ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }-->
<body   ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="delaysManagementForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="poType" value="${requestScope.poType }" />


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>误期管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：选择配镜单</TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">选择配镜单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="60" height="30" class="table_body">销售单号</TD>
			               <TD class="table_none" width="40%">
                            <input class="text_input200" type="text"  id="salesid" name="salesid" value="${requestScope.salesid}">			               
			               </TD>
			               <TD width="10%" height="30" class="table_body">原取镜时间</TD>
			               <TD class="table_none" width="40%">
			               <input class="text_input100"
				               id="startTime"
						       name="startTime" value="${requestScope.startTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime"
						       name="endTime" value="${requestScope.endTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
                            
			               </TD>
			               
                        </TR>
                        <TR>
						   <TD width="60" height="30" class="table_body">所属客户</TD>
			               <TD class="table_none" width="40%" colspan="4">
<!--                            <select id="shopcode" name="shopcode">-->
<!--                             <option value="">请选择所属门店</option>-->
<!--      		                 <s:iterator value="deptList">-->
<!--				               <option value="${bdpdepartmentid}" ${requestScope.shopcode == bdpdepartmentid ? 'selected="selected"' : '' }>${requestScope.bdpdepartmentname }</option>-->
<!--	     	                 </s:iterator>-->
<!--      	                   </select>		               -->
  							<input class="text_input200" type="text"  id="customerName" name="customerName" value="${requestScope.customerName}">
  							<input type="hidden"  id="customer" name="customer" value="${requestScope.customer}">				               
			               </TD>
                        </TR>
                      </TBODY>
                    </table>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton"  icon='icon-search' type='button' value='查询' onClick="javascript:search()" >
							    <input icon='icon-retry' name="reset" type='button' value='重置'  onClick="clean()" >
							</td>
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
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(orderList)}"> 
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
                          <TH width="10%" scope=col height="30">配镜单号</TH>
                          <TH width="7%" scope=col>所属客户</TH>
                          <TH width="5%" scope=col>取镜时间</TH>
                          <TH width="5%" scope=col>选择</TH>
						  </TR>
						<s:iterator value="orderList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD>${ssedrsalesid}</TD>
                          <TD>${ssedrcustomerName }</TD>
                          <TD>${fn:substring(ssedrmirrorcheckdate,0,10)}</TD>  
                          <TD>
                             <input icon='icon-apply' type='button' value='选择' onClick="setCustomer('${ssedrsalesid }','${fn:substring(ssedrmirrorcheckdate,0,10)}' );">
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
