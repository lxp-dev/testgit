<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色权限</title>
</head>
<script>
function exportexcel(){
	rolePermissionForm.action = "exportFileExcel.action";
	rolePermissionForm.submit();
}
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	

	function save(){
		if(checkForm(document.all.rolePermissionForm)){
			$("img").removeAttr("onclick");
			rolePermissionForm.action = "rolePermissionSet.action";
			rolePermissionForm.submit();
			showLoadingBar();
		}
	}
	
	function checkAll(moduleID){
		var checkObj = document.getElementById(moduleID + 'All');
		
		for(i = 0; i < rolePermissionForm.elements.length; i++){
		
			var obj = rolePermissionForm.elements[i];
			if(obj.type == 'checkbox' && obj.id == moduleID){
				obj.checked = checkObj.checked; 
			}
		}
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function changePermission(obj){
       
        var flag = obj.checked;
 
        <s:iterator value='roleTemplateList' status='idx'>           
            if (obj.value == '${templateID}'){                
                if (flag){
                    $('input[module=${roleModuleID}${rolePageValue}]').each(function(){
			            $(this).removeAttr("disabled");
			            $(this).attr('checked','true');
		            });
                }else{
                    $('input[module=${roleModuleID}${rolePageValue}]').each(function(){			            
			            $(this).removeAttr("checked");
			            $(this).attr('disabled','disabled');
		            });
                }
            }        
        </s:iterator>
        
	}
	
	// 权限部分"展开/合起"
	function changeCheckbox(obj){
	    if(!obj.checked){
		   $("tr[name=displayID_"+obj.value+"]").each(function(){
		       $(this).show();
		   });	        
	    }else{
	       $("tr[name=displayID_"+obj.value+"]").each(function(){
		       $(this).hide();
		   });
	    }
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<FORM name="rolePermissionForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}"> 
<s:token></s:token>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- 头部菜单 Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/sys/tab_bg.gif>
          </TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 
                  background=${ctx}/img/sys/tab_bg.gif><IMG 
                  height=1 src="${ctx}/img/sys/tab_bg.gif" 
                  width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><INPUT id=FrameWork_YOYO_LzppccSelectIndex 
                  type=hidden value=0 name=FrameWork_YOYO_LzppccSelectIndex><!--内容框Start-->
                  <DIV id=tabContent__0 style="DISPLAY: ">
                   <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                  <DIV id=rightsTable >

     <!-----------------------------------------------------------------------------------------------------------------------------------------------> 
   <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center border=0 id="title2">
       <TBODY>	
        <c:forEach items="${rootModules}" var="item" varStatus="lineNum">	                   
          <TR class=table_title>
               <TD colSpan=9 height="26">
                  <table width="100%">
                     <tr class=table_title>
                         <td width="80%"><input type="checkbox" name="modulecname" id="modulecname_${lineNum.index }" value="${item.moduleid}" onclick="changeCheckbox(this)">${item.modulecname}</td>
                         <td align="right" ><input type="checkbox" clean=clean id="${item.moduleid}All" onClick="checkAll('${item.moduleid}');"/>全选&nbsp;&nbsp;</td>
                     </tr>
                  </table>
               </TD>
          </TR>
          <TR name="displayID_${item.moduleid}" class=table_body align=middle>
               <TD align=left width="25%" height="26">栏目名称</TD>
               <TD align=left colSpan=8 height="26">权限名称</TD>
          </TR>
                      
     <c:if test="${not empty(item.childModules)}">
		<c:forEach items="${item.childModules}" var="itemChild" varStatus="lineNumChild">
			          
           <TR name="displayID_${item.moduleid}" class=table_none align=middle>
               <TD align=left height="26">${itemChild.modulecname}</TD>
               <TD align=left colSpan=8>
                  <TABLE id=ctl00_PageBody_Module_Main_ctl00_Module_Sub_ctl00_PermissionList 
                        style="WIDTH: 100%" cellSpacing=3 cellPadding=1 border=0>
                     <TBODY>
                        <TR>
                          <TD>					
							<c:choose>
                             	<c:when test="${not empty(itemChild.lstRolePermissionPo)}">
									<c:forEach items="${itemChild.lstRolePermissionPo}" var="itemRolePermission" varStatus="lineNumRolePermission">
									   <c:if test="${not empty(itemRolePermission.lstPermissionPo)}">
									     <c:forEach items="${itemRolePermission.lstPermissionPo}" var="itemPermission" varStatus="lineNumPermission">
											 
											<input type="hidden" name="moduleParents[${lineNum.index }].moduleLowers[${lineNumChild.index }].rolePermissions[${lineNumRolePermission.index }].tmpLstPermission[${lineNumPermission.index }].moduleID" value="${itemChild.moduleid}" />
											<input type="hidden" name="moduleParents[${lineNum.index }].moduleLowers[${lineNumChild.index }].rolePermissions[${lineNumRolePermission.index }].tmpLstPermission[${lineNumPermission.index }].pageValue" value="${itemPermission.pageValue }" />
											<input type="checkbox" clean=clean id='${item.moduleid}' name="moduleParents[${lineNum.index }].moduleLowers[${lineNumChild.index }].rolePermissions[${lineNumRolePermission.index }].tmpLstPermission[${lineNumPermission.index }].pageKey" value="1" ${(itemPermission.pageKey=='1') ? 'checked="checked"' : '' }/>&nbsp;${itemPermission.pageName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									       
									     </c:forEach>
									   </c:if>
									</c:forEach>
								</c:when>
								<c:otherwise>									
								</c:otherwise>
                             </c:choose>	
								
                          </TD>
                        </TR>
                     </TBODY>
                  </TABLE>
               </TD>
           </TR>
      
        </c:forEach>
      </c:if>
           </c:forEach>
    <c:if test="${not empty(rootModules)}">       
		<tr>
			<td colspan="9" align="left">
				<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
				<img btn=btn src="${ctx }/img/newbtn/btn_exportexecl_0.png" id="exportexecl" title='导出EXCEL' onclick="exportexcel()" >
		    </td>
		</tr>
    </c:if>  
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
							gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
							document.getElementById("loadingBar").style.display="";
						}
					</script>                            
				    </td>
				</tr>
				</table>                      
	<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->          
 <!--------------------------------------------------------------------------------------------------------------------------------->

</DIV></DIV><!--内容框End--></TD>
                <TD width=1 
                  background=${ctx}/img/sys/tab_bg.gif><IMG 
                  height=1 src="${ctx}/img/sys/tab_bg.gif" 
                  width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background="${ctx}/img/sys/tab_bg.gif" bgColor="#ffffff">
          	<IMG height=1 src="${ctx}/img/sys/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--选项卡 End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></FORM></DIV></body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>