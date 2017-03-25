<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>储值卡管理</title>
</head>

<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!-- jquery.autocomplete end -->
<script>
	function exportChuzhiCard(){
		allocationForm.action = "exportChuzhiCard.action";
		allocationForm.submit();
	}
	
	function selectCustomer(){
	if(document.getElementById('smecimemberid').value.trim() != '')
		if(event.keyCode == 13)
			document.forms[0].submit();
	}
	

	function search(){
		$("img").removeAttr("onclick");
		allocationForm.action = "weiLuckDrawSetSel.action";
		allocationForm.submit();
		showLoadingBar();
	}	
	
	
	function clean(){
	 	$('input[qing=qing]').each(function(){
				$(this).val('');
		});
	   
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	function insert(){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWeiXinLuckDrawSetUpdate1.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initWeiXinLuckDrawSetUpdate1.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【幸运抽奖设置】";
	}
	function details(uuid){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWeiXinLuckDrawSetUpdate.action?hid="+ uuid ,400,140,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWeiXinLuckDrawSetUpdate.action?hid="+ uuid ,400,140,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【兑换确认】";
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>微信管理</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：幸运抽奖</TD>
            <td align="right" width="40%" valign="bottom">&nbsp;
            <c:if test="${(permissionPo.keyb==1)}">
				<img src="${ctx }/img/newbtn/btn_configure_0.png" title='配置' btn=btn  onclick="JavaScript:insert();" />
			</c:if>
            </td>
          </TR>
        <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        <TR>
          <TD colSpan=2 height=5></TD>
         </TR>
          </TBODY>
        </TABLE>
      <!-- ͷ˵ End --><!-- ѡ Start --><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                     <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">会员卡号</TD>
			               <TD width="28%" class="table_none">
                            <input class="text_input160" type="text" maxlength="20" id="wcjmemberid" name="weiXinLuckDrawPo.wcjmemberid" value="${weiXinLuckDrawPo.wcjmemberid}" qing="qing">
			               </TD>
			               <TD height="26" class="table_body">会员姓名</TD>
			                <TD class="table_none">
                            	<input class="text_input160" maxlength="20" type="text" id="wcjmembername" maxlength="20" value="${weiXinLuckDrawPo.wcjmembername}" name="weiXinLuckDrawPo.wcjmembername" qing=qing>
			                </TD>
				              <TD height="26" class="table_body">会员电话</TD>
				                <TD class="table_none">
	                            	<input class="text_input160" maxlength="20" type="text" id="wcjphone" maxlength="20" value="${weiXinLuckDrawPo.wcjphone}" name="weiXinLuckDrawPo.wcjphone" qing=qing>
				                </TD>
                        </TR>
                       	<TR>
	                       	 <TD height="26" class="table_body">中奖时间</TD>
				               <TD class="table_none">
	                          <li class="horizontal_onlyRight">
	                           <input id="wcjwinstratdate"
						       name="weiXinLuckDrawPo.wcjwinstratdate"
						       type="text" class="text_input100" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'wcjwinenddate\')}'})"
						       value="${weiXinLuckDrawPo.wcjwinstratdate}" qing="qing"/> 至 
						       <input id="wcjwinenddate"
						       name="weiXinLuckDrawPo.wcjwinenddate" 
						       type="text" class="text_input100" 
						       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'wcjwinstratdate\')}'})" 
						        value="${weiXinLuckDrawPo.wcjwinenddate}" qing="qing"/>
						      </li>
					           <li class="horizontal_onlyRight">
	                           <img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('wcjwinstratdate','wcjwinenddate')">
	                           </li>
	                            </TD>
	                             <TD height="26" class="table_body">领奖时间</TD>
				               <TD class="table_none">
	                          <li class="horizontal_onlyRight">
	                           <input id="wcjgivegoodsstratdate"
						       name="weiXinLuckDrawPo.wcjgivegoodsstratdate"
						       type="text" class="text_input100" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'wcjgivegoodsenddate\')}'})"
						       value="${weiXinLuckDrawPo.wcjgivegoodsstratdate}" qing="qing"/> 至 
						       <input id="wcjgivegoodsenddate"
						       name="weiXinLuckDrawPo.wcjgivegoodsenddate" 
						       type="text" class="text_input100" 
						       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'wcjgivegoodsstratdate\')}'})" 
						        value="${weiXinLuckDrawPo.wcjgivegoodsenddate}" qing="qing"/>
						      </li>
					           <li class="horizontal_onlyRight">
	                           <img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('wcjgivegoodsstratdate','wcjgivegoodsenddate')">
	                           </li>
	                            </TD>
	                            <TD height="26" class="table_body">发放人</TD>
				                <TD class="table_none">
	                            	<input class="text_input160" maxlength="20" type="text" id="wcjpersonname" maxlength="20" value="${weiXinLuckDrawPo.wcjpersonname}" name="weiXinLuckDrawPo.wcjpersonname" qing=qing>
				                </TD>
                       	</TR>
                      </TBODY>
                    </table>
                    <TABLE id=title2 cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                        <c:if test="${(permissionPo.keya==1)}">  
                          <TD align="left">
                              <img id="btnSearch" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
							</TD>
                        </c:if>
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
                    <c:if test="${not empty(weiXinLuckDrawPoList)}">
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
						  <TH width="4%" scope=col>操作</TH>
                          <TH width="8%" height="26" scope=col>会员卡号</TH>					
						  <TH width="6%" scope=col>会员姓名</TH>
						  <TH width="10%" scope=col>会员电话</TH>
						  <TH width="8%" scope=col>门店</TH>
						  <TH width="6%" scope=col>兑换状态</TH>
						  <TH width="18%" scope=col>活动时间</TH>
						  <TH width="8%" scope=col>抽奖时间</TH>
						  <TH width="8%" scope=col>领取时间</TH>
						  <TH width="6%" scope=col>中奖等级</TH>
						  <TH width="22%" scope=col>奖品名称</TH>
                        </TR>
                       <c:forEach var="weiXinLuckDrawPo" items="${weiXinLuckDrawPoList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD><c:if test="${weiXinLuckDrawPo.wcjflag!=1}"><img src="${ctx }/img/newbtn/audit_0.png" title='领取' btn=btn onClick="javascript:details('${weiXinLuckDrawPo.wcjid}')" /></c:if><c:if test="${weiXinLuckDrawPo.wcjflag==1}"><img src="${ctx }/img/newbtn/audit_2.png" title='已领取'  /></c:if></TD>
						  <TD height="26">${weiXinLuckDrawPo.wcjmemberid }</TD>
						  <TD>${weiXinLuckDrawPo.wcjmembername }</TD>
						  <TD>${weiXinLuckDrawPo.wcjmemberphone }</TD>
						  <TD>${weiXinLuckDrawPo.wcjshopname }</TD>
						  <TD><c:if test="${weiXinLuckDrawPo.wcjflag==1 }">已领取</c:if><c:if test="${weiXinLuckDrawPo.wcjflag!=1 }">未领取</c:if></TD>
						  <TD>${fn:substring(weiXinLuckDrawPo.wcjactivitiesstratdate,0,11) } 至 ${fn:substring(weiXinLuckDrawPo.wcjactivitiesenddate,0,11)  }</TD>
						  <TD>${fn:substring(weiXinLuckDrawPo.wcjwindate,0,11)  }</TD>
						  <TD>${fn:substring(weiXinLuckDrawPo.wcjgivegoodsdate,0,11)  }</TD>
						  <TD>
						  	<c:if test="${weiXinLuckDrawPo.wcjprizesize=='1'}">一等奖</c:if>
						  	<c:if test="${weiXinLuckDrawPo.wcjprizesize=='2'}">二等奖</c:if>
						  	<c:if test="${weiXinLuckDrawPo.wcjprizesize=='3'}">三等奖</c:if>
						  	<c:if test="${weiXinLuckDrawPo.wcjprizesize=='4'}">四等奖</c:if>
						  	<c:if test="${weiXinLuckDrawPo.wcjprizesize=='5'}">五等奖</c:if>
						  </TD>
						  <TD>${weiXinLuckDrawPo.wcjprizegoodname }</TD>
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
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>