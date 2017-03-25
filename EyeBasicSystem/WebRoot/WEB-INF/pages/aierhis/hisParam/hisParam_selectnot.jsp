<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HIS收费确认管理</title>
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

	 
	function search(){
		$("img").removeAttr("onclick");
		mydriasisForm.action = "queryHisParamNot.action";
		mydriasisForm.submit();
		showLoadingBar();
	}
	
	function winPopUp(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单详细】";
	}
	
	function submitAgainPersonScan(id,chargetype){
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
 
		if(is_iPad()){
			showPopWin("initsubmitHisParamPoAgain.action?billid="+id+"&chargetype="+chargetype+"&moduleID=${moduleID}",450,180,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initsubmitHisParamPoAgain.action?billid="+id+"&chargetype="+chargetype+"&moduleID=${moduleID}",450,180,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【提交收费】"; 
	}
	
	
	function clean(){
		document.getElementById('pbillid').value = "";
		document.getElementById('pchargetype').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
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
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>HIS收费确认管理</TD>
            <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：HIS收费确认查询</td>
            <td align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                    <c:if test="${(permissionPo.keya==1)}"> 
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='inithisParam.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">已提交查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                   </c:if>  
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">未提交查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    </TR></TBODY></TABLE></TD>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
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
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
					<TBODY>
						<TR>
							<TD width="8%" height="26" class="table_body">
								缴费单号
							</TD>
							<TD width="24%" class="table_none">
								<input class="text_input200" type="text"
									id="pbillid" name="pbillid"
									value="${requestScope.pbillid}">
							</TD>
							<TD width="9%" height="26" class="table_body">
								缴费日期
							</TD>
							<TD class="table_none" width="30%">
								<li class="horizontal_onlyRight">
									<input id="startTime" name="startTime"
										type="text" class="text_input100"
										onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
										value="${startTime }" />
									至
									<input id="endTime" name="endTime" type="text"
										class="text_input100"
										onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})"
										value="${endTime }" />
								</li>
								<li class="horizontal_onlyRight">
									<img src="${ctx }/img/newbtn/btn_today_0.png"
										btn=btn title="今天" onClick="today()">
								</li>
							</TD>
							<TD height="26" class="table_body">
								收费类型
							</TD>
							<TD class="table_none">
								<select id="pchargetype" name="pchargetype">
									<option value="">
										----请选择----
									</option>
									<option value="1" ${requestScope.pchargetype==
										'1' ? 'selected=selected':'' }>
										全款
									</option>
									<option value="2" ${requestScope.pchargetype==
										'2' ? 'selected=selected':'' }>
										定金
									</option>
								</select>
							</TD>
						</tr>
					</TBODY>
				</TABLE>
				<c:if test="${permissionPo.keyb=='1'}">
					<table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png"
									btn=btn title='查询' onclick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png"
									btn=btn title='清空' onclick="clean()">
							</td>
						</tr>
					</table>
				</c:if>	
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
					<c:if test="${not empty(salesBasicPoList)}"> 
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
							<TH width="15%" scope=col colspan="2">
								操作
							</TH>
							<TH width="15%" height="26" scope=col>
								缴费单号
							</TH>
							<TH width="10%" scope=col>
								缴费日期
							</TH>
							<TH width="10%" scope=col>
								收费类型
							</TH>
							<TH width="10%" scope=col>
								营业员
							</TH>
							<TH width="10%" scope=col>
								顾客姓名
							</TH>
							<TH width="10%" scope=col>
								顾客电话
							</TH>
							
						</TR>
						<s:iterator value="salesBasicPoList">
							<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">

								<TD width="3%">
									<img src="${ctx }/img/newbtn/search_0.png"
										btn=btn title='详细'
										onClick="winPopUp('${ssesbsalesid }')" />
								</TD>

								<TD width="3%">
									<c:if test="${permissionPo.keyb == '1' }">
										<img src="${ctx }/img/newbtn/payfee_0.png" title='再次提交' btn=btn onClick="javascript:submitAgainPersonScan('${ssesbsalesid }','${ssesbcheckoutflag }')">
									</c:if>
								</TD>

								<TD height="26">
									${ssesbsalesid }
								</TD>
								<TD>
									${fn:substring(ssesbsalesdatetime,0,16)}
								</TD>
								<TD>
									<c:choose>
										<c:when test="${ssesbcheckoutflag  == '1'}">全款</c:when>
										<c:when test="${ssesbcheckoutflag  == '2'}">定金</c:when>
										<c:otherwise>&nbsp;</c:otherwise>
									</c:choose>
								</TD>
								<TD>
									${ssesbsalerName }
								</TD>
								<TD>
									${ssesbpersonName   }
								</TD>
								<TD>
									${ssesbphone   }
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