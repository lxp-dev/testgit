<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>发票管理</title>
</head>
<script>
	$(document).ready(function(){
		for(var i=1;i<=3;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				total=accAdd(total,$(this).text());
			});
			$('#td'+i+'t').text(total.toFixed(2));
		}	
	});
    
    function printInvoice(){  
        var statue = 0;
        if ($('#liiauditstatue').val()==0){
            if ($('#liiBillType').val()==2){
                statue = 1;
            }
        }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInvoicePrint.action?invoiceID="+$('#invoiceID').val()+"&statue="+statue+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initInvoicePrint.action?invoiceID="+$('#invoiceID').val()+"&statue="+statue+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【打印发票】";	
    }

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form id="invoiceDetailFrm" method="post" action="">
<input type="hidden" id="liiauditstatue" value="${invoicePo.liiauditstatue}">
<input type="hidden" id="liiBillType" value="${invoicePo.liiBillType}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0 align="right">
              <TBODY>
              <TR><!--ťStart-->
                    <td width=60% align="right" >
                        <!--  <img btn=btn src="${ctx}/img/newbtn/btn_print_0.png"  title="打印单据" onClick="printInvoice()" />-->
                    </td>
			  </TR>
			 
			  </TBODY></TABLE>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26px">
                          <TD width="9%" class="table_body">发票号</TD>
                          <TD width="24%" class="table_none">${invoicePo.liiid}<input type="hidden" id="invoiceID" value="${invoicePo.liiid}"></TD>
                         <TD class="table_body" width="9%">制造商</TD>
			             <TD class="table_none" width="30%">
							   ${invoicePo.liisuppliername}
						 </TD>
						 <TD width="9%" class="table_body">制单日期</TD>
                          <TD width="24%" class="table_none">
                           ${fn:substring(invoicePo.liidate,0,10)}
                          </TD>

                        </TR>
                        <TR height="26px">
                          <TD class="table_body" >制单部门</TD>
                          <TD class="table_none" >${invoicePo.liidepartmentname }</TD>
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none" >${invoicePo.liicreatepersonname}</TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${invoicePo.liiauditpersonName}&nbsp;</TD>
                        </TR>
                        <TR height="26px">
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">${fn:substring(invoicePo.liiauditdate,0,10)}&nbsp;</TD>
                          <TD class="table_body">发票类型</TD>
                          <TD class="table_none" colspan="3">${invoicePo.liitypeName}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="62" >备注</TD>
                          <TD class="table_none" colSpan=8><label>
                         ${invoicePo.liiremark }&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                   <TABLE id="title2" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left" colspan="2">
                             <font color="red">发票审核后,退货单成本合计、税额合计、价税合计变为负值!</font>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="26">
                          <TH scope=col width="9%" >来票号</TH> 
						  <TH scope=col width="8%">成本合计</TH>
                          <TH scope=col width="8%">税额合计</TH>
						  <TH scope=col width="8%">价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle height="26">
						  <TD align="right">合计：</TD>   
                          <TD><div align="center" id="td1t"></div></TD>
                          <TD><div align="center" id="td2t"></div></TD>
                          <TD><div align="center" id="td3t"></div></TD>
                        </TR>
                        <s:iterator value="invoiceEntryList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" height="26">	
						  <TD height="26">${lieiebillid }</TD>
                          <TD id="td1">${lieienottaxrateamount }</TD>
						  <TD id="td2">${lieietaxamount }</TD>
                          <TD id="td3">${lieiecostpriceamount}</TD>
                        </TR>
                        </s:iterator>
                        <TR class="table_title" align=middle height="26" >
						  <TD align="right">总合计：</TD>
                          <TD>${invoiceEntryPo.lieienottaxrateamount }</TD>
                          <TD>${invoiceEntryPo.lieietaxamount }</TD>
                          <TD>${invoiceEntryPo.lieiecostpriceamount}</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                       
                      </TBODY>
                    </TABLE>
                    <div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
					</div>
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
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>