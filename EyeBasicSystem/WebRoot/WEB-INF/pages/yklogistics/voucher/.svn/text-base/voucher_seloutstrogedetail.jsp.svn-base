<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>凭证管理</title>
<script type="text/javascript">
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 
	
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
	   openPopWindow('ykselVoucherTally.action'+url,"记账凭证");
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

	function openPopWindow(url,msg){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【"+msg+"】";	
	}
</script>
	</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
	<form id="voucherDetailFrm" action="" method="post">
	<input type="hidden" id="isUpdate" value="${isUpdate}"/>
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
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
                          <TD width="26%" class="table_none">
                            <li class="horizontal_onlyRight">
                              ${po.sLvvID}
                            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_jzpzxz_0.png" title='记账凭证新增' 
						         onClick="search('${po.sLvvID}','${fn:substring(po.sLvvDate,0,10)}','${po.sLvvVoucherParentTypeName}','${po.sLvvVoucherTypeName}','${po.sLvvVoucherTypeID}','${po.sLvvSupplierName}','${createPerson}','${po.sLvvPosting}');">
                            </li>
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
                          <TD class="table_none" colSpan=7>${po.sLvvRemark}</TD>
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
                          </TD>
                         </TR>
                        </s:iterator>
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