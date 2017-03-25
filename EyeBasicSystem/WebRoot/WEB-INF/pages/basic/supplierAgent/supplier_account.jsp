<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商维护</title>
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

	function save(){
		if(checkForm(document.all.supplierForm)){ 
        	$("img").removeAttr("onclick");
			supplierForm.action = "insertAccount.action";
			supplierForm.submit();
		}
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD width="105">
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD width="90" align="center" class=tab id=tabLabel__1 <c:if test="${(requestScope.flag eq 1)}">onclick="JavaScript:window.location.href='supplierDetail.action?moduleID=${requestScope.moduleID}&hid=${requestScope.hid}';" </c:if>
                    <c:if test="${(requestScope.flag eq 0)}">onclick="JavaScript:window.location.href='initSupplierUpdate.action?moduleID=${requestScope.moduleID}&hid=${requestScope.hid}';" </c:if>
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">${requestScope.flag eq 1 ? '供应商详细' : '供应商修改'}</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                 </TD><TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif
                      onClick="JavaScript:window.location.href='selContract.action?moduleID=${requestScope.moduleID}&hid=${supplierPo.bspid}&flag=${requestScope.flag}' ;" 
                      UNSELECTABLE="on">供应商合同</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                    </TD>
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif
                      UNSELECTABLE="on">供应商账款</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                    </TD>
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
                      <c:if test="${requestScope.flag=='1'}">
                      	 <TR>
						   <TD width="9%" height="26" class="table_body">供应商账期</TD>
			               <TD width="19%" class="table_none">${supplierPo.bspsupplieraccountdate}
				              <c:if test="${not empty supplierPo.bspsupplieraccountdate}">
				           			   天
				              </c:if>
                            
			               </TD>
			               <TD width="9%" height="26" class="table_body">往来余额</TD>
			               <TD width="22%" class="table_none">
                            ${supplierPo.bspdealingsAmount}
			               </TD>
			               <TD width="9%" height="26" class="table_body">期初预付</TD>
			               <TD width="19%" class="table_none">                             
			             	${supplierPo.bspstartpayment }
			               </TD>
                        </TR>
                        <TR>			               
			               <TD height="26" class="table_body">期初应付</TD>
			               <TD class="table_none" colspan="5">
			                ${supplierPo.bspstartprice }
			               </TD>
						  
                        </TR>
                      </c:if>
                      <c:if test="${requestScope.flag=='0'}">
                      	 <TR>
						   <TD width="9%" height="26" class="table_body">供应商账期</TD>
			               <TD width="19%" class="table_none">
                            <select name="supplierPo.bspsupplieraccountdate">
                                <option value="30" ${supplierPo.bspsupplieraccountdate == '30' ? 'selected="selected"' : '' }>30天</option>
                                <option value="60" ${supplierPo.bspsupplieraccountdate == '60' ? 'selected="selected"' : '' }>60天</option>
                                <option value="90" ${supplierPo.bspsupplieraccountdate == '90' ? 'selected="selected"' : '' }>90天</option>
                            </select>
                            <input type="hidden" id="bspid" name="supplierPo.bspid" value="${supplierPo.bspid}">
                            <input type="hidden" id="bspsuppliername" name="supplierPo.bspsuppliername" value="${supplierPo.bspsuppliername}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">往来余额</TD>
			               <TD width="22%" class="table_none">
                             <input class="text_input200" type="text" id="bspdealingsAmount" name="supplierPo.bspdealingsAmount" value="${supplierPo.bspdealingsAmount}" readonly="readonly">
			               </TD>
			               <TD width="9%" height="26" class="table_body">期初预付</TD>
			               <TD width="19%" class="table_none">                             
			             <input class="text_input200" maxlength="10" type="text" id="bspstartpayment" name="supplierPo.bspstartpayment" value="${supplierPo.bspstartpayment }" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}"
                             validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '期初预付金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
			               </TD>
                        </TR>
                        <TR>			               
			               <TD height="26" class="table_body">期初应付</TD>
			               <TD class="table_none" colspan="5">
			                <input class="text_input200" maxlength="10" type="text" id="bspstartprice" name="supplierPo.bspstartprice" value="${supplierPo.bspstartprice }" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}"
                             validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '期初应付金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
			               </TD>
						  
                        </TR>
                      </c:if>
                       
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <c:if test="${requestScope.flag!='1'}">
	                          <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
	                        	  <!-- <img icon='icon-reload' type='reset' value='重置' >  -->
                        	  </c:if>
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
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>