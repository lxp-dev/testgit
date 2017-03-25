<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品负调拨管理</title>
</head>
<script>
	function receiveAllocation(){
		$('#recTD').hide();
		allocationForm.action = "reReceiveAllocation.action";
		allocationForm.submit();
		
	}
    function printReport(id){
		var url = "<%=getServletContext().getInitParameter("rptUrl")%>eims_reporting/storage_reallocationRpt&billid="+id+"&rs:Command=Render";
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="查询窗口";
    }
	window.onload = function(){
    		var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
			
			var needTotal=0;
			$('input[name=needNumber]').each(function(){
				needTotal=accAdd(needTotal,$(this).val());
			});
			$('#needTotal').text(needTotal);
    };
    
    function returnAudit(){
    	allocationForm.action = "reReturnAudit.action";
    	allocationForm.submit();
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="smsFlag"  value="${smsFlag }" /> 
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

			<div style="width:100px;height:12px;left:expression(document.body.clientWidth-scrollWidth);top:expression(scrollHeight+15+document.body.scrollTop-this.offsetHeight);position:absolute">
			<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                         <c:if test="${smsFlag!='1'}">
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();parent.window.document.forms(0).submit();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                  </c:if>
                   <c:if test="${smsFlag=='1'}">
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:window.close();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                  </c:if>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </div>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>商品负调拨管理</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品负调拨详细</td>
        </TR>
        <TR>
          <TD class=menubar_function_text colspan="3">
          	<c:if test="${allocationPo.cshaaconsignstate==0 && allocationPo.cshaaauditstate==1 &&person.departmenttype==3}">
          		<input icon="icon-add-row" type="button" value="确认收货" onClick="receiveAllocation();">
          	</c:if>
          	    <input icon="icon-add-row" type="button" value="打印单据" onClick="printReport('${allocationPo.cshaabillid}');">
          </TD>
        </TR>
       </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">商品负调拨详细</TD>
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
                    <TABLE class="privateBorder" cellSpacing=1 cellPadding=0 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">负调拨单号</TD>
                          <TD width="24%" class="table_none">${allocationPo.cshaabillid}<input type="hidden" id="cshaabillid" name="cshaabillid" value="${allocationPo.cshaabillid}"></TD>
                          <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">
                          ${fn:substring(allocationPo.cshaabilldate,0,10)}
                          </TD>					       
						  <TD width="9%" class="table_body" height="26">申请部门</TD>
                          <TD class="table_none">
                          ${allocationPo.cshaaoutdepartmentname}
                          </TD>					       
						</TR>
						<TR>
						  <TD class="table_body" height="26">发出仓位</TD>
						  <TD class="table_none">
                          ${allocationPo.cshaaoutstockname}
                          </TD>
                          <TD class="table_body" height="26">接收仓位</TD>
                          <TD class="table_none" >
                              <select id="cshaainstockid" name="allocationPo.cshaainstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '接收仓位不能为空！'}]">
                             	<s:iterator value="inwarehouselist">cshaainstockid
                               <option value="${bwhid}" ${allocationPo.cshaainstockid != bwhid ? '' : 'selected="selected"' }>${bwhwarehouseName}</option>
                               </s:iterator>
      	                   </select>
                          </TD>
                          <TD class="table_body">制单人</TD>
                          <TD class="table_none" >${allocationPo.cshaacreatepersonname}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none" >
                              ${allocationPo.cshaaauditpersonname}&nbsp;
                          </TD>
                          <TD class="table_body">收货人</TD>
                          <TD class="table_none" colspan="3">${allocationPo.cshaaconsigneename}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="60">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          ${allocationPo.cshaaremark}&nbsp;
                          </label></TD>
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
					<table id="addTable" width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>                       
                          <TH width="20%" scope=col height="28">商品代码</TH>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>型号</TH>
                          <TH width="10%" scope=col>负调拨数量</TH>                         
                          <TH width="20%" scope=col>商品条码</TH>                      
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=3 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
					    	<TH scope=col width="10%" >&nbsp;</TH>
				   		</TR>
                        <s:iterator value="allocationEntryList" status="idx">
                        <TR class="row">
                        <TD height="26">${cshaaegoodsid}</TD>
                        <TD>${cshaaegoodsname}</TD>
                        <TD>${cshaaespec}</TD>                                                                  
                        <TD>${cshaaeallocationquantity}<input type="hidden" class="text_input60" name="goodsInfoTempPo.goodsquantity" value="${cshaaeallocationquantity}" /></TD>
                        <TD> <select id="selectGbc" name="goodsInfoTempPo.goodsbarcode" multiple="multiple" class="text_input200 gbc" style="height:40px;" onmousemove="this.style.height='100px'" onmouseout="this.style.height='30px'" />
                     <s:iterator value="allocationBarcodeLists">
                    	 <c:if test="${cshabgoodsid eq cshaaegoodsid}">
                        <option value="${ cshabgoodsbarcode}">${ cshabgoodsbarcode }</option>
                        </c:if>
                        </s:iterator>
                        </select><br/>
					</TD>  
                        </TR>
                        </s:iterator>
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