<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导入物流期初商品金额</title>
</head>
<script>	
    function importGoods(){
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
        
        if ($('#file').val() == ''){
            alert("请选择需要上传的文档!");
            return;
        }
        if (!CheckExt(document.getElementById('file'))){
            return;
        }

    	var type = '1';
        if ('${systemParameterPo.fspcbjstype}' == '2' ){
            type = $('input[name=dctype]:checked').val();
        }

        if (confirm('确认导入期初吗？')){
        	$("img").removeAttr("onclick");
            importGoodsFrm.action = "importAmountFile.action?dtype="+type+"&sjtype="+$('input[name=sjtype]:checked').val();
            importGoodsFrm.submit(); 
            showLoadingBar();
        }
    }
    
    function getPath(obj){
		if(obj){
	    	if (window.navigator.userAgent.indexOf("MSIE") >= 1){ 
	        	obj.select();      
	            return document.selection.createRange().text;	               
	        }
	        else if(window.navigator.userAgent.indexOf("Firefox") >= 1){
	        	if(obj.files){ 	                           
	            	return obj.files.item(0).getAsDataURL();
	            }
	        	return obj.value;
           	}
	    	return obj.value;
		}
	}

	var AllImgExt = ".xlsx";
	var FileExt;
	function CheckExt(obj){
		if(obj.value == ""){
			return false;
		}
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();		
		if(AllImgExt.indexOf(FileExt) != -1){
	        obj.value = getPath(obj);
            return true;

		}else{
			alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);
			return false;
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
<form id="importGoodsFrm" name="importGoodsFrm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
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
					  		<TD width="14%" height="26" class="table_body">导入方式</TD>
					  		<TD height="26" class="table_none" colspan="3">
					  		    <c:if test="${systemParameterPo.fspcbjstype eq '1'}">&nbsp;导入所有公司下的期初库存和期初成本&nbsp;</c:if>
					  		    <c:if test="${systemParameterPo.fspcbjstype eq '2'}">
					  		        <input type="radio" id="dctype2" name="dctype" value="2" onclick="showCompany('2');" checked="checked">&nbsp;选取一个所属公司后，导入该公司下的期初库存和期初成本&nbsp;
					  		        <input type="radio" id="dctype3" name="dctype" value="3" onclick="showCompany('3');">&nbsp;选取一个所属部门后，导入该部门下的期初库存和期初成本&nbsp;
					  		    </c:if>					  		    
					  		</TD>
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">成本类型</TD>
					  		<TD height="26" class="table_none" colspan="3">
					  		    <c:if test="${fquartzSwitchPo.fqscbjs eq '1'}">&nbsp;不含税成本&nbsp;</c:if>
					  		    <c:if test="${fquartzSwitchPo.fqscbjs eq '2'}">&nbsp;含税成本&nbsp;</c:if>					  		    
					  		</TD>
                        </TR>
                        
                        <TR>
					  		<TD width="14%" height="26" class="table_body">数据形式</TD>
					  		<TD height="26" class="table_none" colspan="3">
					  		    <input type="radio" id="sjtype1" name="sjtype" value="1" checked="checked">&nbsp;继续导入&nbsp;<label style="color:red;">(保留当前所属部门下的期初库存和期初成本，再导入新期初库存和期初成本)</label>
					  		    <input type="radio" id="sjtype2" name="sjtype" value="2" >&nbsp;重新导入&nbsp;<label style="color:red;">(删除当前所属部门下的所有期初库存和期初成本，再导入新期初库存和期初成本)</label>
					  		</TD>
                        </TR>
                        
                        <TR company="hiddencompany">
						   <TD width="14%" height="26" class="table_body">所属公司</TD>
			               <TD width="30%" height="26" class="table_none">
						   		<select id="companyID" name="companyID" onchange="showSubMenu(this.options[this.options.selectedIndex].value)" >
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
						   <TD width="14%" height="26" class="table_body">所属公司</TD>
			               <TD class="table_none" colspan="3">
						   		<select id="companyID2" name="companyID2" onchange="showSubMenu2(this.options[this.options.selectedIndex])">
	                              <option value="" qcdate="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" qcdate="${fcnqcdate}">${fcnName}</option>
	                              </s:iterator>
	                            </select><label style="color:red;">&nbsp;*&nbsp;</label>
                           </TD>
				   
                        </TR>
                        
                        <tr>
                        	<TD width="14%" height="26" class="table_body">文档路径</TD>
			               	<TD class="table_none" colspan="3">
			               	<input type="file" name="upload" id="file" style="width: 600" onchange="CheckExt(this)"><label style="color:red;">&nbsp;*&nbsp;文件格式为 .xlsx </label>
			               	</TD>
                        </tr>   
                        
                        <TR>
                           <TD width="14%" height="26" class="table_body">期初日期</TD>
						   <TD class="table_none" colspan="3">
						      <span id="qcdate">${bgnDate }</span>
						      <input id="bgnDate" name="bgnDate" type="hidden" class="text_input80" value="${bgnDate }"/>
						   </TD>
						</TR>
						
						<TR>
						   <TD height="26" colspan="4">
						       <label style="color:red;"><b>当前导入期初的模板为Excel 2007。</b></label>
						   </TD>
						</TR>
						                   
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							  <td>					  
							  <img btn=btn src="${ctx }/img/newbtn/btn_drspje_0.png" title='导入商品金额' onclick="importGoods();" >	
							  </td>
						  
						</tr>
					</table>
				<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
				<table id="loadingBar" width="100%" STYLE="display:none">
				  <tr><td height="10">&nbsp;</td></tr>
				  <tr>                         
				    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
				    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在导入数据，由于数据量较大可能需要较长时间，请耐心等候...</div>
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
				  <c:if test="${not empty(ealpList)}">
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
                          <TH scope=col width="10%" height="26">导出日期</TH>
                          <TH scope=col width="8%">导出方式</TH>
						  <TH scope=col width="8%">导出人</TH>  
						  <TH scope=col width="10%">期初日期</TH>
                          <TH scope=col width="20%">所属公司</TH>
						  <TH scope=col width="15%">所属部门</TH> 
                        </TR>
                      <s:iterator value="ealpList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                      
		                  <TD height="26">${lealdate}</TD>
                          <TD>
                              <c:if test="${lealform eq '1'}">按所有公司</c:if>
                              <c:if test="${lealform eq '2'}">按公司</c:if>
                              <c:if test="${lealform eq '3'}">按部门</c:if>
                          </TD>
                          <TD>${lealpersonname}</TD>  
                          <TD>${lealinitdate}</TD>  
                          <TD>${lealcompanyname}</TD>  
                          <TD>${lealdepartmentname}</TD>                           
						</TR>
					  </s:iterator>
                      </TBODY>
                    </TABLE>
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
