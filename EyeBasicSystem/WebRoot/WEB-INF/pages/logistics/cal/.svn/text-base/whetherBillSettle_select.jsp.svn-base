<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>查询单据管理</title>
</head>
<script>

	function search(){
	    selBillWhetherSettleAccountsFrm.action="selBillWhetherSettleAccounts.action";
	    selBillWhetherSettleAccountsFrm.submit();
		showLoadingBar();
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
<form method="post" name="selBillWhetherSettleAccountsFrm">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="14%"> <img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;单据管理</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：查询未结账单据</TD>
          <td align="right" width="40%" valign="bottom">&nbsp;
				<img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
         </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR></TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
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
                        <TR height="26">
                          <TD align="center" class="table_body" width="3%">年月</TD>
                          <TD align="left" class="table_none" width="10%">
                                <select id="year" name="year">      		                          
      		                        <c:forEach var="i" begin="2011" end="${currentYear}" step="1"> 
                                      <option value="${i}" ${currentYear == i ? 'selected="selected"' : ''}>${i}</option>
      		                        </c:forEach>      		                 
      	                        </select>								
						  		<select id="month" name="month">
                                   <option value="01" ${currentMonth == '01' ? 'selected="selected"' : ''}>01</option>
                                   <option value="02" ${currentMonth == '02' ? 'selected="selected"' : ''}>02</option>
                                   <option value="03" ${currentMonth == '03' ? 'selected="selected"' : ''}>03</option>
                                   <option value="04" ${currentMonth == '04' ? 'selected="selected"' : ''}>04</option>
                                   <option value="05" ${currentMonth == '05' ? 'selected="selected"' : ''}>05</option>
                                   <option value="06" ${currentMonth == '06' ? 'selected="selected"' : ''}>06</option>
                                   <option value="07" ${currentMonth == '07' ? 'selected="selected"' : ''}>07</option>
                                   <option value="08" ${currentMonth == '08' ? 'selected="selected"' : ''}>08</option>
                                   <option value="09" ${currentMonth == '09' ? 'selected="selected"' : ''}>09</option>
                                   <option value="10" ${currentMonth == '10' ? 'selected="selected"' : ''}>10</option>
                                   <option value="11" ${currentMonth == '11' ? 'selected="selected"' : ''}>11</option>
                                   <option value="12" ${currentMonth == '12' ? 'selected="selected"' : ''}>12</option>          
      	                        </select>
                            </TD>
                          <TD align="center" class="table_body" width="3%">类型</TD>
						  <TD align="left" class="table_none" width="10%">
                              	<select id="billType" name="billType">
                              	   <option value="fkd" ${billType == 'fkd' ? 'selected="selected"' : ''}>付款单</option>
                                   <option value="fp" ${billType == 'fp' ? 'selected="selected"' : ''}>发票</option>
                                   <option value="ch" ${billType == 'ch' ? 'selected="selected"' : ''}>冲回</option>
                                   <option value="zg" ${billType == 'zg' ? 'selected="selected"' : ''}>暂估</option>
                                   <option value="py" ${billType == 'py' ? 'selected="selected"' : ''}>盘盈</option>
                                   <option value="pk" ${billType == 'pk' ? 'selected="selected"' : ''}>盘亏</option>
                                   <option value="xscb" ${billType == 'xscb' ? 'selected="selected"' : ''}>销售成本</option>
                                   <option value="xssr" ${billType == 'xssr' ? 'selected="selected"' : ''}>销售收入</option>
                                   <option value="qtck" ${billType == 'qtck' ? 'selected="selected"' : ''}>其他出库</option>
                                   <option value="qtrk" ${billType == 'qtrk' ? 'selected="selected"' : ''}>其他入库</option>    
      	                        </select>
                          </TD>
						  
						  </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
                      <TBODY>
                        <TR height="26px">
                          <TD align="left">
							<img btn=btn id="btn1" src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
						  </TD>
                        </TR>
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
                    <c:if test="${not empty(inventoryEntryList)}">
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
                          <TD width="3%" height="26" >选择</TD>
                          <TH width="13%" scope=col>单据编号</TH>
                          <TH width="8%" scope=col>单据日期</TH>						
                          <TH scope=col width="18%">制造商\部门</TH>
						  <TH scope=col width="5%">数量</TH>
						  <TH width="5%" scope=col>成本合计</TH>
						  <TH scope=col width="5%">税额合计</TH>
						  <TH width="5%" scope=col>价税合计</TH>
                        </TR>
                        <s:iterator value="inventoryEntryList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" id="invoiceRow">
						  <TD height="26"><input type="checkbox"></TD>
						  <TD>${cstiebillid }</TD>
                          <TD>${fn:substring(cstiewarehousingdate,0,10) }</TD>
						  <TD>${cstiesupplierID }</TD>
						  <TD>${cstiegoodsquantity}</TD>
						  <TD>${cstienottaxrateamount}</TD>						  
                          <TD>${cstietaxamount}</TD>
                          <TD>${cstiecostpriceamount}</TD>
                        </TR>
                      </s:iterator>
                      </TBODY>
                    </TABLE>
                    <div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
					</div>
                    </c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>