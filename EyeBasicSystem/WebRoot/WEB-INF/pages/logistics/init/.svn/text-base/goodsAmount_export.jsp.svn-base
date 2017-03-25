<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导出物流期初商品信息</title>
</head>
<script>	
    function exportGoods(){

    	var type = '1';
        if ('${systemParameterPo.fspcbjstype}' == '2' ){
            type = $('input[name=dctype]:checked').val();
        }

        if ($('input[name=dctype]:checked').val() == '2' && $('#companyID2').val() == ''){
            alert('请选取所属公司!');
            return;
        }

        if ($('input[name=dctype]:checked').val() == '3'){
            if ($('#companyID').val() == ''){
                alert('请选取所属公司!');
                return;
            }

            if ($('#departmentID').val() == ''){
                alert('请选取所属部门!');
                return;
            }
        }
        
        if ($('#bgnDate').val() == ''){
            alert('所选公司或部门未设置期初日期!');
            return;
        }

        if ($('#bgnDate').val().length > 16){
            alert('所选公司或部门设置的期初日期异常，要符合年-月-日的格式，需要重新设置!');
            return;
        }
        
    	if (confirm('确认导出期初吗？')){
            exportGoodsFrm.action = "exportAmountFile.action?type=" + type;
            exportGoodsFrm.submit();
        }
    }
    
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 

	    showCompany('${systemParameterPo.fspcbjstype}');
    }); 

    function showSubMenu(cid) {         
    	$('#departmentID').load("getAjaxDepartmentMenuForCompanyID.action?id="+ cid);		
    }

    function showCompany(id){

        $('#companyID').val(''); 
        $('#departmentID').val(''); 
        $('#companyID2').val(''); 
    	$('#qcdate').text('');
    	$('#bgnDate').val('');	
        
        if (id == '1'){
            $('tr[company=hiddencompany]').hide();
            $('tr[company=hiddencompany2]').hide();
        }

        if (id == '2'){
            $('tr[company=hiddencompany]').hide();
            $('tr[company=hiddencompany2]').show();
        }

        if (id == '3'){
            $('tr[company=hiddencompany]').show();
            $('tr[company=hiddencompany2]').hide();
        }
    }

    function showSubMenu2(obj) {
        var objval = obj.getAttribute('qcdate');         
    	$('#qcdate').text(objval);
    	$('#bgnDate').val(objval);			
    }
    
</script>
<body onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"> 
<form id="exportGoodsFrm" name="exportGoodsFrm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  		<TD width="14%" height="26" class="table_body">导出方式</TD>
					  		<TD height="26" class="table_none" colspan="3">
					  			<c:if test="${systemParameterPo.fspcbjstype eq '1'}">&nbsp;导出所有公司下的期初库存&nbsp;</c:if>
					  		    <c:if test="${systemParameterPo.fspcbjstype eq '2'}">
					  		        <input type="radio" id="dctype2" name="dctype" value="2" onclick="showCompany('2');" checked="checked">&nbsp;选取一个所属公司后，导出该公司下的期初库存&nbsp;
					  		        <input type="radio" id="dctype3" name="dctype" value="3" onclick="showCompany('3');">&nbsp;选取一个所属部门后，导出该部门下的期初库存&nbsp;
					  		    </c:if>
					  		</TD>
                        </TR>
                        
                        <TR>
                           <TD height="26" class="table_body">成本类型</TD>
						   <TD class="table_none" colspan="3">
					  		    <c:if test="${fquartzSwitchPo.fqscbjs eq '1'}">&nbsp;不含税成本&nbsp;</c:if>
					  		    <c:if test="${fquartzSwitchPo.fqscbjs eq '2'}">&nbsp;含税成本&nbsp;</c:if>
						   </TD>
						</TR>
                        
                        <TR company="hiddencompany">
						   <TD width="14%" height="26" class="table_body">所属公司</TD>
			               <TD width="30%" height="26" class="table_none">
						   		<select id="companyID" name="companyID" onchange="showSubMenu(this.options[this.options.selectedIndex].value)">
	                              <option value="" qcdate="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" qcdate="${fcnqcdate}">${fcnName}</option>
	                              </s:iterator>
	                            </select><label style="color:red;">&nbsp;*&nbsp;</label>
                           </TD>
                           
                           <TD width="14%" height="26" class="table_body">所属部门</TD>
			               <TD class="table_none">			   
							   	<select id="departmentID" name="departmentID" onchange="showSubMenu2(this.options[this.options.selectedIndex])">
	                              <option value="" qcdate="">----请选择----</option>
	                            </select><label style="color:red;">&nbsp;*&nbsp;选取所属公司后，才会显示所属部门</label>
						   </TD>
						   
                        </TR>
                        
                        <TR company="hiddencompany2">
						   <TD height="26" class="table_body">所属公司</TD>
			               <TD class="table_none" colspan="3">
						   		<select id="companyID2" name="companyID2" onchange="showSubMenu2(this.options[this.options.selectedIndex])">
	                              <option value="" qcdate="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" qcdate="${fcnqcdate}">${fcnName}</option>
	                              </s:iterator>
	                            </select><label style="color:red;">&nbsp;*&nbsp;</label>
                           </TD>

                        </TR> 
                        
                        <TR>
                           <TD height="26" class="table_body">期初日期</TD>
						   <TD class="table_none" colspan="3">
						      <span id="qcdate">${bgnDate }</span>
						      <input id="bgnDate" name="bgnDate" type="hidden" class="text_input80" value="${bgnDate }"/>
						   </TD>
						</TR>  
						
						<TR>
						   <TD height="26" colspan="2">
						       <label style="color:red;"><b>使用Excel 2007为模板，将以小于期初日期的库存作为期初库存数导出！</b></label>
						   </TD>
						</TR>
						
						<TR>
						   <TD height="26" colspan="2">
						       <label style="color:red;"><b>各公司及部门的期初日期由后台统一进行设置！</b></label>
						   </TD>
						</TR>						                     
                    
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="26">
							  <td>
							    <img btn=btn src="${ctx }/img/newbtn/btn_dcsp_0.png" title='导出商品' onclick="exportGoods();" >
							  </td>	  
						</tr>
					</table>
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
				<table id="loadingBar" width="100%" STYLE="display:none">
				  <tr><td height="10">&nbsp;</td></tr>
				  <tr>                         
				    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
				    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在导出数据，由于数据量较大可能需要较长时间，请耐心等候...</div>
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
