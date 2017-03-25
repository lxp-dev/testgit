<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/zone.js"></script>
<title>掰轨参数设置</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;");
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

	    initCompanyAdminLoginShowMenu();
    }); 
	function initCompanyAdminLoginShowMenu() {
        var showCompanyAdminMenu = $("#companyAdmin").val();
        if(showCompanyAdminMenu == null) {
        	showCompanyAdminMenu='';
        }
        if(showCompanyAdminMenu == "companyAdmin") {
            $("tr[customerAdmin=customerAdmin]").each(function() {
                $(this).hide();
            });
        	$("tr[companyAdmin=companyAdmin]").each(function() {
            	$(this).show();
        	});
        } else {
        	$("tr[companyAdmin=companyAdmin]").each(function() {
            	$(this).hide();
        	});
            $("tr[customerAdmin=customerAdmin]").each(function() {
                $(this).show();
            });
            
        }
    }
    function save(){
			$("img").removeAttr("onclick");
			companyNameForm.action = "insertExternalAccountParameter.action?";
			companyNameForm.submit();
    }

    function cleanDepartment(){
    	document.getElementById('departmentID').value = '';
    	document.getElementById('ds').value = '';
    	document.getElementById('bdpdepartmentname').value = '';
    }

    function openDepartment(){
    	var topRows = top.document.getElementById("total").rows;
    	var topCols = top.document.getElementById("btmframe").cols;
    	if(is_iPad()){
    		showPopWin("queryCustomerSalesTypeOpen.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
    	}else{
    		showPopWin("queryCustomerSalesTypeOpen.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
    	}
    	
    	document.getElementById('popupTitle').innerHTML="【顾客结款类型查询】";
    }

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
    	document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
    }
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="companyNameForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="externalAccountParameterPo.feaid" value="${externalAccountParameterPo.feaid}">
<input type="hidden" id="companyAdmin" name="companyAdmin" value="<%=request.getParameter("companyAdmin") %>">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>掰轨参数设置</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：掰轨参数设置 </td>
          </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
	      </TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
            </TD>
					
					</TR>
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
                                  <TD width="5%""><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY> 
			                         <TR valign="middle" companyAdmin=companyAdmin>
			                        	<TD height="26" width="15%" class="table_body" align="right">正式系统的访问地址</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<input  type="text" class="text_input200" name="externalAccountParameterPo.feaaccessaddress" value="${externalAccountParameterPo.feaaccessaddress }"></TD>
			                        </TR>  
			                         <TR valign="middle" companyAdmin=companyAdmin>
			                        	<TD height="26" class="table_body" align="right">外帐系统的访问地址</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<input  type="text" class="text_input200" name="externalAccountParameterPo.feaexternaladdress" value="${externalAccountParameterPo.feaexternaladdress }"></TD>
			                        </TR>  
			                         <TR valign="middle" companyAdmin=companyAdmin>
			                        	<TD height="26" class="table_body" align="right">跨库链接名称</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<input  type="text" class="text_input200" name="externalAccountParameterPo.feaaccessname" value="${externalAccountParameterPo.feaaccessname }"></TD>
			                        </TR>  
			                         <TR valign="middle" companyAdmin=companyAdmin>
			                        	<TD height="26" class="table_body" align="right">外帐数据库名称</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<input  type="text" class="text_input200" name="externalAccountParameterPo.feaexternalname" value="${externalAccountParameterPo.feaexternalname }"></TD>
			                        </TR>  
			                         <TR valign="middle" customerAdmin=customerAdmin>
			                        	<TD height="26" width="15%" class="table_body" align="right">采购收货单制单人员</TD>
			                        	<TD class="table_none"  colspan="5">
			                        		<select id="cstidepartmentid" name="externalAccountParameterPo.feaprocreateid">
				      		                 	<option value="">----请选择----</option>
				                             	<c:if test="${not empty(PersonInfoList)}">
								               	  <s:iterator value="PersonInfoList">
				                    	           <OPTION value="${id}" ${externalAccountParameterPo.feaprocreateid!= id  ? '' : 'selected="selected"' } >(${id}) ${personName}</OPTION>
				                    	          </s:iterator>
				                    	        </c:if>
				      	                   </select>
			                        	</TD>
			                        </TR>  
			                          <TR valign="middle" customerAdmin=customerAdmin>
			                        	<TD  height="26" class="table_body" align="right">采购收货单审核人员</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<select id="cstidepartmentid" name="externalAccountParameterPo.feaproaduiteid">
				      		                 	<option value="">----请选择----</option>
				                             	<c:if test="${not empty(PersonInfoList)}">
								               	  <s:iterator value="PersonInfoList">
				                    	           <OPTION value="${id}" ${externalAccountParameterPo.feaproaduiteid!= id  ? '' : 'selected="selected"' } >(${id}) ${personName}</OPTION>
				                    	          </s:iterator>
				                    	        </c:if>
				      	                   </select>
			                        	</TD>
			                        </TR>  
			                         <TR valign="middle" customerAdmin=customerAdmin>
			                        	<TD height="26" class="table_body" align="right">采购退货单制单部门</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<select id="cstidepartmentid" name="externalAccountParameterPo.feadepartmentsid">
				      		                 	<option value="">----请选择----</option>
				                             	<c:if test="${not empty(departmentsList)}">
								               	  <s:iterator value="departmentsList">
				                    	           <OPTION value="${bdpdepartmentid}" ${externalAccountParameterPo.feadepartmentsid!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid}) ${bdpdepartmentname}</OPTION>
				                    	          </s:iterator>
				                    	        </c:if>
				      	                   </select>
			                        	</TD>
			                        </TR>  
			                         <TR valign="middle" customerAdmin=customerAdmin>
			                        	<TD height="26" class="table_body" align="right">采购退货单制单人员</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<select id="cstidepartmentid" name="externalAccountParameterPo.feaproreturncreateid">
				      		                 	<option value="">----请选择----</option>
				                             	<c:if test="${not empty(PersonInfoList)}">
								               	  <s:iterator value="PersonInfoList">
				                    	           <OPTION value="${id}" ${externalAccountParameterPo.feaproreturncreateid!= id  ? '' : 'selected="selected"' } >(${id}) ${personName}</OPTION>
				                    	          </s:iterator>
				                    	        </c:if>
				      	                   </select>
			                        	</TD>
			                        </TR>  
			                         <TR valign="middle" customerAdmin=customerAdmin>
			                        	<TD height="26" class="table_body" align="right">采购退货单审核人员</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<select id="cstidepartmentid" name="externalAccountParameterPo.feaproreturnaduiteid">
				      		                 	<option value="">----请选择----</option>
				                             	<c:if test="${not empty(PersonInfoList)}">
								               	  <s:iterator value="PersonInfoList">
				                    	           <OPTION value="${id}" ${externalAccountParameterPo.feaproreturnaduiteid!= id  ? '' : 'selected="selected"' } >(${id}) ${personName}</OPTION>
				                    	          </s:iterator>
				                    	        </c:if>
				      	                   </select>
			                        	</TD>
			                        </TR>  
			                         <TR valign="middle" customerAdmin=customerAdmin>
			                        	<TD height="26" class="table_body" align="right">顾客结款类型设置</TD>
			                        	<TD class="table_none" colspan="5">
			      	                   
				      	            <li class="horizontal_onlyRight">
				      	                <input clean=clean class="text_input300" id="bdpdepartmentname" name="externalAccountParameterPo.feanocashmothename" value="${externalAccountParameterPo.feanocashmothename }" type="hidden" />
									    <textarea clean=clean id="ds"  name="ds" readonly="readonly" style="width:300" value="${externalAccountParameterPo.feanocashmothename}">${externalAccountParameterPo.feanocashmothename }</textarea>
									    <input clean=clean class="text_input100" type="hidden" id="departmentID" name="externalAccountParameterPo.feanocashmothe" value="${externalAccountParameterPo.feanocashmothe }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取结款类型！'}]"/>
									    
									</li>
									<li class="horizontal_onlyRight">						  		
										<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
									    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="cleanDepartment();" >
								    </li>
								    
			                        	</TD>
			                        </TR> 
			                         <TR valign="middle" customerAdmin=customerAdmin>
			                        	<TD height="26" class="table_body" align="right">商品销售成本设置</TD>
			                        	<TD class="table_none" colspan="5">
			                        		<input type="radio" name="externalAccountParameterPo.feacastset" checked="checked" ${externalAccountParameterPo.feacastset!= 1  ? '' : 'checked="checked"' } value="1" > 按正式系统销售成本 &nbsp;&nbsp;
			                        		<input type="radio" name="externalAccountParameterPo.feacastset" ${externalAccountParameterPo.feacastset!= 2  ? '' : 'checked="checked"' } value="2" > 按零售价的比例 &nbsp;&nbsp;
			                        	</TD>
			                        </TR>  
			                               					   
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY>

    </html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
