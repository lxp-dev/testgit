<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附加费用维护</title>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function save(){
	if(checkForm(additionalCostsForm)){		
		if(isNaN($("#facamount").val())){
			alert("附加费金额应为整数！");
			$("#facamount").focus();
			$("#facamount").select();
			return;
		}
		
		if($("#facamount").val() == 0){
			alert("附加费金额不应等于0！");
			$("#facamount").focus();
			$("#facamount").select();
			return;
		}
	
		$("img").removeAttr("onclick");		
		additionalCostsForm.action = "updateAdditionalCosts.action";
		additionalCostsForm.submit();
		}
	}

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		
	}
	function reload() {
		additionalCostsForm.reset();
	}
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="additionalCostsForm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="8%" height="26" class="table_body">编码</TD>
			               <TD width="20%" class="table_none">${additionalCostsPo.facid }<input type="hidden" class="text_input100" name="additionalCostsPo.facid" id="facid" value="${additionalCostsPo.facid }" maxlength="5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '编码不能为空！'}]"></TD>
						
                          
						  <TD width="8%" height="26" class="table_body">附加费用名称</TD>
                          <TD width="20%" class="table_none"><input class="text_input200" name="additionalCostsPo.facname" id="facname" value="${additionalCostsPo.facname}"  maxlength="16" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '附加费用名称不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
			            
                          
						  <TD width="11%" height="26" class="table_body">附加费用金额</TD>
                          <TD class="table_none" valign="middle">
                          <li class="horizontal_onlyRight">
                          <input class="text_input100" name="additionalCostsPo.facamount" id="facamount" value="${additionalCostsPo.facamount }" maxlength="10" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '附加费用金额不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			              </li>
                          <li class="horizontal_onlyRight">
                          <label style="color:red;">&nbsp;金额精确到分</label>
                          </li>
                           </TD>
			            </TR>
			            <TR>
						   <TD width="8%" height="30" class="table_body">所属制造商</TD>
			               <TD class="table_none" colspan="5">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input160" type="text"  id="supplierName" name="additionalCostsPo.facsuppliername" value="${additionalCostsPo.facsuppliername}" readonly="readonly">
							   		<input type="hidden" id="supplierID" name="additionalCostsPo.facsupplierid" value="${additionalCostsPo.facsupplierid}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
							   </li>
			               </TD>
			            </TR>
			            
			            <c:if test="${systemParameterPo.fsphisflag == '2'}">
	                      <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
								   <li class="horizontal_onlyRight">
								     <select id="facpayfeeid" name="additionalCostsPo.facpayfeeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收费项目！'}]">
	                                   <option value="">---请选择---</option>
	                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
			                               <option value="${optionParamPoTmp.fopparamid }" ${(additionalCostsPo.facpayfeeid == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                              </c:if>	                                      	
		                               </c:forEach> 
	                            	 </select>
		                           </li>
		                           <label style="color:red;">&nbsp;*</label>
		      	             </TD>                
	                      </TR>
                       </c:if>
                       
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
                          <img src="${ctx}/img/newbtn/btn_return_0.png" btn=btn title='还原' onclick="reload()">
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
    </BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>