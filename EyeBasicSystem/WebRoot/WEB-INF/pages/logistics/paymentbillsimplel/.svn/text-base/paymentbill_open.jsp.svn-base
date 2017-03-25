<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>付款单管理</title>		
<script type="text/javascript">
   	
   	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	payMentBillSelFrm.action=link;
	  	payMentBillSelFrm.submit();
		showLoadingBar();
	}
	
   /**
    *  查询付款单详细信息
    */ 
	function detail(billID){
		showPopWin("","selPayMentBillSimpleDetail.action?payMentBillID="+billID+"&moduleID=${moduleID}",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	
   /**
    *  重置
    */        
	function clean(){
	    $('input[clean=clean]').each(function(){
			$(this).val('');
		});
	}
	
   /**
    *  根据条件查询相关付款单
    */        
	function search(){
	    payMentBillSelFrm.action = "selAdvancePayMentBillOpen.action";
	    payMentBillSelFrm.submit();
		showLoadingBar();
	}
	
    function setValue(){
		var chk = document.getElementsByName("chk");
        var objValue = "";
        var count = 0;
        for(var i = 0;i<chk.length;i++){
        	if(chk[i].checked == true){
	       		if(objValue == ""){
		           	objValue = chk[i].value;
		        }else{
		           	objValue = objValue + "," + chk[i].value;
		        }  
	        	count++;          
        	}
        }
        
        if(count == 0){
        	alert('请选择商品!');
          	return false;
        }
        
        objValue = "[" + objValue + "]";
       	window.parent.openGoodSingleValues(objValue);
       	alert('您选择的信息已添加到列表中！');
    }
   
    /**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form method="post" id="payMentBillSelFrm" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;付款单管理</TD>
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
                    </TABLE></TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：付款单查询</TD>
          <TD class=menubar_function_text align=right>&nbsp;
          </TD></TR>
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
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initVoucherSel.action';" 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">付款单查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>										
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
							<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="clear">
                      <TBODY>
                        <TR height="30px">
                          <TD width="8%" class="table_body">付款单号</TD>
                          <TD width="26%" class="table_none"><input clean="clean" class="text_input200" id="payMentBillID" name="payMentBillID" type="text" value="${payMentBillID}" maxlength="30"></TD>
                          <TD width="10%" class="table_body">制造商</TD>
                          <TD class="table_none" width="30%">
                            ${supplierName}
                            <input type="hidden" id="supplierName" name="supplierName" class="text_input200" readonly="readonly" value="${supplierName}">
                            <input type="hidden" id="supplierID" name="supplierID" class="text_input200" readonly="readonly" value="${supplierID}">

                          </TD>
                        </TR>
                        <TR height="30px">
						  <TD class="table_body">付款单日期</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input id="billStartTime"
					       name="billStartTime" clean="clean" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'billEndTime\')}'})"
					       value="${billStartTime }" /> 至 
					       <input id="billEndTime"
					       name="billEndTime" clean="clean" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'billStartTime\')}'})" 
					        value="${billEndTime }" />
					        
					      </li><li class="horizontal_onlyRight">
                            <INPUT class=button_bak icon="icon-zoom" type=button value="今天" onClick="today('billStartTime','billEndTime')"></li>
                           <li class="horizontal_onlyRight">
                            <INPUT class=button_bak icon="icon-zoom" type=button value="当月" onClick="currtMonth('billStartTime','billEndTime')"></li> 
					      </TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                           <input id="auditStartTime"
					       name="auditStartTime" clean="clean" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'auditEndTime\')}'})"
					       value="${auditStartTime }" /> 至 
					       <input id="auditEndTime"
					       name="auditEndTime" clean="clean" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'auditStartTime\')}'})" 
					        value="${auditEndTime }" />  
					      </li><li class="horizontal_onlyRight">
                            <INPUT class=button_bak icon="icon-zoom" type=button value="今天" onClick="today('auditStartTime','auditEndTime')"></li>
                          <li class="horizontal_onlyRight">
                            <INPUT class=button_bak icon="icon-zoom" type=button value="当月" onClick="currtMonth('auditStartTime','auditEndTime')"></li>      
                           </TD>
                        </TR>                    
                        </TBODY>
                    </TABLE>
					<table id="searchBar" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<input icon='icon-search' type='button' value='查询' onclick="search()">
							<input type='button' value='清空' icon='icon-reset' onclick="clean()">
							<input icon='icon-edit' id="searchBtn" type='button' value="选择" onClick="setValue()">
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
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                    <c:if test="${not empty(payMentBillList)}">
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
                          <TH scope=col width="5%" height="30"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="15%" height="30">付款单号</TH>
						  <TH scope=col width="16%">付款单日期</TH>						
                          <TH scope=col width="10%">制单人</TH>
						  <TH scope=col width="8%">预付金额</TH>
						  <TH scope=col width="8%">已退金额</TH>
						  <TH scope=col width="8%">未退金额</TH>
                          <TH scope=col width="5%">详细</TH>
                        </TR>
                      <s:iterator value="payMentBillList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="28">
						       <input type="checkbox" id="chk" name="chk" value="{'payMentBillID':'${sLpbpbID}','payedMentDate':'${fn:substring(sLpbpbDate,0,10)}','payedMentAmount':'${sLpbpbDiscountAmount}','costPriceAmount':'${sLpbpbCostPriceAmount}','notPayedMentAmount':'${sLpbpbPayMentAmount}','payMentBillType':'预付款单'}" />
						  </TD>
                          <TD height="28">${sLpbpbID}</TD>
                          <TD>${fn:substring(sLpbpbDate,0,10)}</TD>
                          <TD>${sLpbpbCreatePersonName}</TD>
                          <TD>${sLpbpbCostPriceAmount}</TD>
                          <TD>${sLpbpbDiscountAmount}</TD>
                          <TD>${sLpbpbPayMentAmount}</TD>
                          <TD>
                             <input type='button' value='详细' onClick="javascript:detail('${sLpbpbID}')">
		                  </TD>
						</TR>
					  </s:iterator>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					</c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
					   <TR>
						  <TD align="left"></TD>
                        </TR>
                      </TBODY>
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
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>