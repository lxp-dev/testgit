<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>凭证管理</title>
<script type="text/javascript">
   	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	voucherDetailFrm.action=link;
	  	voucherDetailFrm.submit();
	}
	
   /**
    *  生成凭证开窗
    */
	function search(voucherID,voucherDate,bType,sType,sVoucherType,supplierName,createPerson,posting){
	   var notTaxRateAmountTotal = document.getElementsByName("notTaxRateAmountTotal");
	   if (notTaxRateAmountTotal.length == 0){
	       notTaxRateAmountTotal = "";
	   }else{
	       notTaxRateAmountTotal = document.getElementById("notTaxRateAmountTotal").innerText;
	   } 	  
	   var taxAmountTotal = document.getElementsByName("taxAmountTotal");
	   if (taxAmountTotal.length == 0){
	       taxAmountTotal = "";
	   }else{
	       taxAmountTotal = document.getElementById("taxAmountTotal").innerText;
	   } 
	   var costPriceAmountTotal = document.getElementsByName("costPriceAmountTotal");
	   if (costPriceAmountTotal.length == 0){
	       costPriceAmountTotal = "";
	   }else{
	       costPriceAmountTotal = document.getElementById("costPriceAmountTotal").innerText;
	   } 
	   var url = "?voucherID="+EncodeUtf8(voucherID)+"&voucherDate="+EncodeUtf8(voucherDate)+"&bType="+EncodeUtf8(bType)+"&sType="+EncodeUtf8(sType)
	             +"&sVoucherType="+EncodeUtf8(sVoucherType)+"&supplierName="+EncodeUtf8(supplierName)+"&createPerson="+EncodeUtf8(createPerson)
	             +"&posting="+EncodeUtf8(posting)+"&notTaxRateAmountTotal="+notTaxRateAmountTotal
	             +"&taxAmountTotal="+taxAmountTotal+"&costPriceAmountTotal="+costPriceAmountTotal;
	   showPopWin('','selVoucherTally.action'+url,screen.width-200,screen.height-200,'', null,true);
	   selectHidden(); 
	}
		
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk = document.getElementsByName("chk");
        var chks = document.all.chks;
        for (var i = 0; i < chk.length; i++){
           chk[i].checked = chks.checked;
        }
    }
    
    function closeWindow(){
        parent.hidePopWin();
        parentSelectShow();
        if (document.getElementsByName("isUpdate")[0].value == "update"){
            parent.window.document.forms(0).submit();
        }
    }
    
    $(document).ready(function(){
        var total = 0;    		 
		$('span[id=sNotTaxRateAmount]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
			total = accAdd(total,$(this).text());
		});
		$('#notTaxRateAmountTotal').text(parseFloat(total).toFixed(2));
		
		total = 0;
		$('span[id=sCostPriceAmount]').each(function(){
			$(this).text(parseFloat($(this).text()).toFixed(2));
			total = accAdd(total,$(this).text());
		});
		$('#costPriceAmountTotal').text(parseFloat(total).toFixed(2));
	});
	
	/**
	 *  增加凭证
	 */        
	 function save(){
	     var auditState = '0';
	     if (document.getElementsByName("auditState")[0].checked){
	         auditState = '1';
	     }
	     document.getElementById("submitBtn").disabled="disabled"; 
	     updateVoucherFrm.action = "updateOutStrogeVoucher.action?auditState="+auditState;
	     updateVoucherFrm.submit();	    
	 }
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form id="updateVoucherFrm" action="" method="post">
	<input type="hidden" id="isUpdate" value="${isUpdate}"/>
	<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD width="90%" class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;凭证管理</TD>       
         <TD class=menubar_readme_text vAlign=bottom>
          <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                alt="关闭页面" onClick="closeWindow();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD>
        </TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：凭证修改</TD>
          <TD class=menubar_function_text align=right>&nbsp;</TD></TR>
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
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">凭证修改</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>

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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="30px">
                          <TD width="8%" class="table_body">凭证号</TD>
                          <TD width="26%" class="table_none">${po.sLvvID}<input type="hidden" name="po.sLvvID" value="${po.sLvvID}" />                              
						  </TD>
                          <TD width="7%" class="table_body">凭证日期</TD>
                          <TD width="13%" class="table_none">${fn:substring(po.sLvvDate,0,10)}</TD>
                          <TD width="7%" class="table_body">凭证类型</TD>
                          <TD class="table_none">
                              ${po.sLvvVoucherParentTypeName}&nbsp;&nbsp;&nbsp;&nbsp;${po.sLvvVoucherTypeName}
                          </TD>
                          <TD class="table_body" >凭证人</TD>
                          <TD class="table_none" >${po.sLvvPersonName}</TD>
                          </TR>
                        <TR height="30px">
                          <TD class="table_body">部门</TD>
                          <TD class="table_none">${po.sLvvSupplierName}</TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${po.sLvvAuditPersonName}</TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none" colspan="3">${fn:substring(po.sLvvAuditDate,0,10)}</TD>
                        </TR>
                        <TR height="60px">
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=7>
                              <textarea name="po.sLvvRemark">${po.sLvvRemark}</textarea>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                          <TR>
                            <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                            <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                          </TR>
                       </TBODY>
                    </TABLE>
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="30"><input type="checkbox" onclick="chkAll()" id="chks">选择</TH>
                          <TH scope=col width="15%" height="30">单据号</TH>
                          <TH width="15%" height="30" scope=col>单据日期</TH>
                          <TH width="13%" scope=col>部门名称</TH>
                          <TH scope=col width="5%">销售成本</TH>
                          <TH scope=col width="7%">销售收入</TH>
                        </TR>
						<TR class="table_title" align=middle>
						  <TD height="28" colspan="4" align="right">合计：</TD>
                          <TD><div id="notTaxRateAmountTotal"></div></TD>                          
                          <TD><div id="costPriceAmountTotal"></div></TD>
                        </TR>
                        <s:iterator value="voucherEntryList">
                         <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28"><input id="chk" name="chk" type="checkbox"></TD>
						  <TD height="28">${sLveveBillID}<input type="hidden" name="voucherEntryTempPo.sLveveBillID" value="${sLveveBillID}" /></TD>
						  <TD height="28">${sBillDate}</TD>
						  <TD height="28">${sDepartment}</TD>
						  <TD><span id="sNotTaxRateAmount">${sNotTaxRateAmount}</span><input type="hidden" name="voucherEntryTempPo.sNotTaxRateAmount" value="${sNotTaxRateAmount}" /></TD>                          
                          <TD><span id="sCostPriceAmount">${sCostPriceAmount}</span><input type="hidden" name="voucherEntryTempPo.sCostPriceAmount" value="${sCostPriceAmount}" /></TD>
                         </TR>
                        </s:iterator>
                       </TBODY>
                      </TABLE>
                 <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                      	<TR>
						  <TD align="left">
						      <p>
						      <input type="checkbox" id="auditState" name="auditState" value="1">保存并审核
						      </p>
						  </TD>
                        </TR>
					   <TR>
						  <TD align="left">
						      <p>
						      <input id="submitBtn" icon='icon-save' type='button' value='保存' onClick="save();">
						      </p>
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>