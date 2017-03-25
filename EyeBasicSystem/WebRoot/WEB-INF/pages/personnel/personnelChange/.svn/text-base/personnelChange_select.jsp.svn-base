<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事变动维护</title>
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
	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	personInfoForm.action=link;
	  	personInfoForm.submit();
		showLoadingBar();
	}
	function search()
	{
		personInfoForm.action = "selPersonChanges.action";
		personInfoForm.submit();
		showLoadingBar();
	}
	

	

		
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initPersonnelChangeDetail.action?selId="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPersonnelChangeDetail.action?selId="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【人事变动详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean()
	{
		document.all.selId.value="";
		document.all.selPersonName.value="";
		document.all.bdpdepartmentname.value="";
		document.all.departmentID.value="";
		document.all.changeType.value="";	
		document.all.postid.value="";	
	
	}
	

	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDepartmentOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDepartmentOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			
			arrayName[i] = departments[i].bdpdepartmentname;
		}
		document.getElementById('departmentID').value = arrayID.join(",");
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
	}
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personInfoForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input  id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>      
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>人事管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：人事变动</TD>
            <td align="right" valign="bottom">
            	&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20">
        
         <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            
				</TD>
        
        </tr>
      
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
						   <TD width="8%" height="26" class="table_body">ID号</TD>
			               <TD width="24%" class="table_none"><input class="text_input100" id="selId" name="selId" value="${selId }" /></TD>
					
						   <TD width="8%" height="26" class="table_body">员工姓名</TD>
                          <TD width="24%" class="table_none"><input class="text_input100" name="selPersonName" id="selPersonName" value="${selPersonName }"></TD>
                      
                       <TD height="26" class="table_body">所属部门</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">                         
							<input class="text_input200" id="bdpdepartmentname" name="selDepartmentName" readonly="readonly" value="${selDepartmentName}"/>
						   		<input type="hidden" id="departmentID" name="selDepartmentID" value="${selDepartmentID}"/>
                          </li>
						   <li class="horizontal_onlyRight">
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" onClick="openDepartment();">
						   </li>
						  </TD>
						
                     </TR>
									
					<TR>
						<TD height="26" class="table_body">变动类型</TD>
			           	<TD height="26" class="table_none">
			           		 <select name="changeType" id="changeType" class="text_input100">
					  		<option value="">----请选择----</option>
					  		<option value="1" ${changeType == 1 ? 'selected="selected"' : '' }>部门变动</option>
					  		<option value="2" ${changeType == 2 ? 'selected="selected"' : '' }>职务变动</option>
					  		<option value="3" ${changeType == 3 ? 'selected="selected"' : '' }>在职离职变动</option>						
						</select>
						</TD>
							
						<TD width="8%" height="26" class="table_body">员工职务</TD>
			           <TD height="26" class="table_none">
					   <select name="postid" id="postid" class="text_input100">
					  		<option value="">----请选择----</option>
					  		<c:forEach var="po" items="${postPos}">
					  		<option value="${po.mptid }" ${postid != po.mptid ? '' : 'selected="selected"' }>${po.mptcontent }</option>
					  		</c:forEach>							
						</select>
						
						</TD>
					
					
                         <TD class="table_body">&nbsp;</TD>
			           <TD class="table_none">&nbsp;</TD>
							
				   </TR>
                      </TBODY>
                    </TABLE>
               		
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >		
									  	
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->		
					<c:if test="${not empty(personnelChangePos)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>

					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="addTable">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="4%" scope=col >操作</TH>
                          <TH width="6%" height="26" scope=col>ID号</TH>
                          <TH width="8%" scope=col>员工姓名</TH>
                          <TH width="12%" scope=col>变动时间</TH>
						  <th width="48%">所属部门</th>
						  <th width="12%">职务</th>
                          <TH width="10%" scope=col>变动类型</TH>
                        </TR>
                        <c:forEach var="po" items="${ personnelChangePos }" >
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
                          	
                          		<img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="detail('${po.mpcuuid }')">
                        
                          </TD>
                          
                          <TD height="26">${po.mpcpersonid}</TD>
                          <TD>${po.mpcpersonname }</TD>
                          <td>${fn:substring(po.mpcchangedate,0,16)} </td>
						  <td>${po.mpcdepartmentname }</td>
						  <td>${po.mpcpostname }</td>
                          <TD>${po.mpcchangetype }</TD>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
