<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它出库管理</title>
</head>
<script>
    function printReport(id){
		
		var url = "<%=getServletContext().getInitParameter("rptUrl")%>storage/salesOut/salesOut&billID="+id+"&rs:Command=Render";
		//window.open (url, '查询窗口', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
    	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="查询窗口";
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>

<form name="salesOutForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>其它出库管理</TD>
                    <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：其它出库详细</TD>
                      <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button>
             <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="printReport('${inventoryPo.cstibillid}');" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/New.gif" align=textTop 
                  border=0>&nbsp;打印单据</TD>
             </TR></TBODY></TABLE>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                      UNSELECTABLE="on">其它出库详细</TD>
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
                        <TR>
						   <TD width="60" height="30" class="table_body">单据编号</TD>
			               <TD class="table_none" width="40%">${inventoryPo.cstibillid}</TD>
			               <TD width="60" height="30" class="table_body">单据日期</TD>
			               <TD class="table_none">
			               	 ${fn:substring(inventoryPo.cstibilldate,0,10)}</TD>
                        </TR>
						<TR>
						   <TD width="60" height="30" class="table_body">退货部门</TD>
			               <TD class="table_none"> ${inventoryPo.cstidepartmentid}</TD>
			               <TD width="60" height="30" class="table_body">发出仓位</TD>
			               <TD class="table_none">${inventoryPo.cstioutstockname}</TD>
                        </TR>                        
                        <TR>

			               <TD width="60" height="30" class="table_body">制单人</TD>
			               <TD class="table_none" colspan="3">${inventoryPo.csticreatepersonname}</TD>
                        </TR>
                         <TR>
                          <TD class="table_body" height="30">备注</TD>
                          <TD class="table_none" colspan="3">
                           ${inventoryPo.cstiremark}&nbsp;
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
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR class=table_title align=middle>                     
                          <TH scope=col width="15%" height="30">商品代码</TH>
						  <TH scope=col width="15%">商品名称</TH>						
                          <TH scope=col width="10%">型号</TH>                          
 						  <TH scope=col width="5%">数量</TH>	
 						  <TH scope=col width="8%">单位成本</TH>
						  <TH scope=col width="8%">成本合计</TH>
                          <TH scope=col width="5%">税率</TH>
						  <TH scope=col width="8%">含税单价</TH>
						  <TH scope=col width="8%">价税合计</TH>					  
                          <TH scope=col width="8%">税额合计</TH>
                        </TR>
                        <s:iterator value="inventoryEntryList" status="idx">
	                        <TR class="row">
	                        <TD height="28">${cstiegoodsid}</TD>
	                        <TD>${cstiegoodsname}</TD>
	                        <TD>${cstiespec}</TD>
	                        <TD>${cstiegoodsquantity}</TD>                        
	                        <TD>${cstienottaxrate}</TD>
	                        <TD>${cstienottaxrateamount}</TD>
	                        <TD>${cstietaxrate}</TD>
	                        <TD>${cstiecostprice}</TD>
	                        <TD>${cstiecostpriceamount}</TD>
	                        <TD>${cstietaxamount}</TD>                                                                        
	                        </TR>
                        </s:iterator>
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