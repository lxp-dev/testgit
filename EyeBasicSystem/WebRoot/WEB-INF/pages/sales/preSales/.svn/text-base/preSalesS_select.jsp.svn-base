<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>眼部检查管理</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
		if($("#title1").is(":visible")){
        	$("input:text")[0].focus();
        }
	});

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	mydriasisForm.action=link;
	  	mydriasisForm.submit();
		showLoadingBar();
	}
	function details(id,sopmdid){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("detailMydriasis.action?hid="+id+"&sopmdid="+sopmdid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("detailMydriasis.action?hid="+id+"&sopmdid="+sopmdid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【散瞳检查详细】";
	}
	function search(){
		$("img").removeAttr("onclick");
		mydriasisForm.action = "selectPreSalesCustomerS.action";
		mydriasisForm.submit();
		showLoadingBar();
	}
	function insert(){
		var moduleID=document.all.moduleID.value
		showPopWin("","initMydriasisInsert.action?moduleID="+moduleID,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	
	
	function clean(){
		$("[clean=clean]").val('');	
	}	
	
	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
	
	function today(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('ssepsbgntime').value = now;
		document.getElementById('ssepsendtime').value = now;		
	}
	
	function today1(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('ssepsbgntakeglasstime').value = now;
		document.getElementById('ssepsendtakeglasstime').value = now;		
	}
	
	/**
	 *聚焦
	 */
	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function printReport(id){
   		DataURL="report.action?reportlet=print_salesPreSales.cpt&ssepsid="+id+"&did="+'${person.departmentID}';
   				
    	window.open (DataURL, '无库存销售预付定金单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" value="${requestScope.sopmdfcustomerid}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能： 无库存销售记录查询</TD>
            <td align="right" valign="bottom">
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><Table></Table></TD>
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
                      <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initInsertPreSalesS.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">无库存销售结款</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                 
                  <TD>
                    <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">无库存销售记录查询</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                    </TD>
                     </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD>
				</TR>
                    </TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">销售单号</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text" clean=clean id="ssepsid" name="ssepsid" value="${ssepsid}">
			               </TD>
			               <TD width="8%" class="table_body">流水号</TD>
			               <TD width="20%" class="table_none">
                            <input class="text_input160" type="text" clean=clean id="ssepsserialnumber" name="ssepsserialnumber" value="${ssepsserialnumber}">
			               </TD>
			               <TD width="8%" class="table_body">收银日期</TD>
							<TD class="table_none">
                            <li class="horizontal_onlyRight"><input class="text_input100"
				               id="ssepsbgntime" clean=clean
						       name="ssepsbgntime" value="${ssepsbgntime}"
						       type="text"
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('ssepsendtime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="ssepsendtime" clean=clean
						       name="ssepsendtime" value="${ssepsendtime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('ssepsbgntime').value}"
						       readonly="readonly" /></li><li class="horizontal_onlyRight">
					  				  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
			               </TD>
                        </TR>
                        <TR>
						   <TD width="8%" height="26" class="table_body">顾客卡号</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text" clean=clean id="ssepsmemberid" name="ssepsmemberid" value="${ssepsmemberid}">
			               </TD>
			               <TD width="8%" class="table_body">顾客姓名</TD>
			               <TD width="20%" class="table_none">
                            <input class="text_input160" type="text" clean=clean id="ssepscustomername" name="ssepscustomername" value="${ssepscustomername}">
			               </TD>
			               <TD width="8%" class="table_body">销售门店</TD>
						   <TD class="table_none">
      		                 	<select id="ssepsshopcode" name="ssepsshopcode" clean=clean>
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${ssepsshopcode!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </select>
			               </TD>
                        </TR>
                        <TR>
						   <TD width="8%" height="26" class="table_body">营业员姓名</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text" clean=clean id="ssepssalername" name="ssepssalername" value="${ssepssalername}">
			               </TD>
			               <TD width="8%" class="table_body">收银员姓名</TD>
			               <TD width="20%" class="table_none">
                            <input class="text_input160" type="text" clean=clean id="ssepsposername" name="ssepsposername" value="${ssepsposername}">
			               </TD>
			               <TD width="8%" class="table_body">取镜日期</TD>
							<TD class="table_none">
                            <li class="horizontal_onlyRight"><input class="text_input100"
				               id="ssepsbgntakeglasstime" clean=clean
						       name="ssepsbgntakeglasstime" value="${ssepsbgntakeglasstime}"
						       type="text"
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('ssepsendtakeglasstime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="ssepsendtakeglasstime" clean=clean
						       name="ssepsendtakeglasstime" value="${ssepsendtakeglasstime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('ssepsbgntakeglasstime').value}"
						       readonly="readonly" /></li><li class="horizontal_onlyRight">
					  				  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today1()"></li>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
		                      	<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							 	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							  </td>
						</tr>
					</table>
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
					<c:if test="${not empty(preSalesPoList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="4%" scope=col>操作</TH>
                          <TH width="14%" height="30" scope=col>销售单号</TH>
                          <TH width="10%" scope=col>流水号</TH>
                          <TH width="10%" scope=col>门店名称</TH>
                          <TH width="10%" scope=col>原价金额</TH>
                          <TH width="10%" scope=col>缴费金额</TH>
                          <TH width="8%" scope=col>营业员</TH>
                          <TH width="8%" scope=col>收银员</TH>
                          <TH width="14%" scope=col>收银时间</TH> 
                           <TH width="10%" scope=col>取镜日期</TH> 
						  </TR>
						<c:forEach var="po" items="${preSalesPoList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
		                     <img src="${ctx }/img/newbtn/print_0.png" btn=btn title='打印' onClick="javascript:printReport('${po.ssepsid}')">
		                  </TD>
                          <TD height="26">${po.ssepsid}</TD>
                          <TD>${po.ssepsserialnumber}</TD>
                          <TD>${po.ssepsshopcodename}</TD>
                          <TD>${po.ssepspricesum}</TD>
                          <TD>${po.ssepssalesvalue}</TD>
                          <TD>${po.ssepssalername}</TD>
                          <TD>${po.ssepsposername}</TD>
                          <TD>${fn:substring(po.ssepsdate,0,16)}</TD>
                          <TD>${fn:substring(po.ssepstakeglasstime,0,10)}</TD>
						</TR>
						</c:forEach>
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
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