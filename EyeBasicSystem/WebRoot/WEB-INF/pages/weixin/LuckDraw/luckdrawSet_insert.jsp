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
	

	function search(){
		$("img").removeAttr("onclick");
		allocationForm.action = "updateWeiXinLuckDrawSet1.action";
		allocationForm.submit();
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
		isShowAndHide();
	});
	function isShowAndHide(){
		var sw=$("input[type=radio]:checked").val();
		if(sw==1){
			$("tr[id=CARDPRICE]").show();
		}
		if(sw!=1){
			$("tr[id=CARDPRICE]").hide();
		}
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
						   <TD height="26" width="12%" class="table_body">幸运抽奖开关</TD>
			               <TD  class="table_none" colspan="5"  width="24%;">
                            <input type="radio" name="weiXinLuckDrawPo.wcjsflag"  value="1" checked="checked" onclick="isShowAndHide();" ${weiXinLuckDrawPo.wcjsflag == '1' ? 'checked="checked"' : '' }>开&nbsp;&nbsp;
                             <input type="radio" name="weiXinLuckDrawPo.wcjsflag"  value="0" onclick="isShowAndHide();" ${weiXinLuckDrawPo.wcjsflag == '0' ? 'checked="checked"' : '' }>关&nbsp;&nbsp;
			               </TD>
			               </TR>
			                <tr id="CARDPRICE">
			               
			               <TD height="26" width="12%" class="table_body">活动时间</TD>
			                <TD class="table_none" colspan="5" width="24%;">
			                	 <li class="horizontal_onlyRight">
	                           <input id="wcjsactivitiesstratdate"
						       name="weiXinLuckDrawPo.wcjsactivitiesstratdate"
						       type="text" class="text_input100" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'wcjsactivitiesenddate\')}'})"
						       value="${fn:substring(weiXinLuckDrawPo.wcjsactivitiesstratdate,0,11)}" qing="qing"/> 至 
						       <input id="wcjsactivitiesenddate"
						       name="weiXinLuckDrawPo.wcjsactivitiesenddate" 
						       type="text" class="text_input100" 
						       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'wcjsactivitiesstratdate\')}'})" 
						        value="${fn:substring(weiXinLuckDrawPo.wcjsactivitiesenddate,0,11)}" qing="qing"/>
						      </li>
					           <li class="horizontal_onlyRight">
	                           <img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('wcjsactivitiesstratdate','wcjsactivitiesenddate')">
	                           </li>
			                </TD>
			                </tr>
			               <tr id="CARDPRICE">
			               
			               <TD height="26" width="12%" class="table_body">每天最多抽奖次数</TD>
			                <TD class="table_none" colspan="5" width="24%;">
                            	<input class="text_input160" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" name="weiXinLuckDrawPo.wcjsdaynumber" value="${weiXinLuckDrawPo.wcjsdaynumber }">
			                </TD>
			                </tr>
			                <tr id="CARDPRICE">
			                  <TD height="26" width="12%" class="table_body">每人每天最多抽取次数</TD>
			                <TD class="table_none" colspan="5" width="24%;">
                            	<input class="text_input160"  type="text" name="weiXinLuckDrawPo.wcjspersonnumber"  onkeyup="value=value.replace(/[^\d]/g,'')" value="${weiXinLuckDrawPo.wcjspersonnumber }" checked="checked"  >
			                </TD>
			                </tr>
			                <tr id="CARDPRICE">
			                 <TD height="26" width="12%" class="table_body">每人最多中奖次数</TD>
			                <TD class="table_none" colspan="5" width="24%;">
                            	<input class="text_input160" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" name="weiXinLuckDrawPo.wcjspersonlucknumber" value="${weiXinLuckDrawPo.wcjspersonlucknumber }">
			                </TD>
                        </TR>
                        <tr id="CARDPRICE">
			                 <TD height="26" width="12%" class="table_body">一等奖奖品</TD>
			                <TD class="table_none" width="24%;">
                            	<input class="text_input240" maxlength="20" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoods1" value="${weiXinLuckDrawPo.wcjsprizesizegoods1 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">一等奖奖品数量</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoodsnumber1" value="${weiXinLuckDrawPo.wcjsprizesizegoodsnumber1 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">一等奖抽中概率</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d\.]/g,'')" type="text" name="weiXinLuckDrawPo.wcjsprizesizeprobability1" value="${weiXinLuckDrawPo.wcjsprizesizeprobability1 }">
			                %</TD>
                        </TR>
                        <tr id="CARDPRICE">
			                 <TD height="26" width="12%" class="table_body">二等奖奖品</TD>
			                <TD class="table_none" width="24%;">
                            	<input class="text_input240" maxlength="20" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoods2" value="${weiXinLuckDrawPo.wcjsprizesizegoods2 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">二等奖奖品数量</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoodsnumber2" value="${weiXinLuckDrawPo.wcjsprizesizegoodsnumber2 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">二等奖抽中概率</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d\.]/g,'')"  type="text" name="weiXinLuckDrawPo.wcjsprizesizeprobability2" value="${weiXinLuckDrawPo.wcjsprizesizeprobability2 }">
			                %</TD>
                        </TR>
                        <tr id="CARDPRICE">
			                 <TD height="26" width="12%" class="table_body">三等奖奖品</TD>
			                <TD class="table_none" width="24%;">
                            	<input class="text_input240" maxlength="20" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoods3" value="${weiXinLuckDrawPo.wcjsprizesizegoods3 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">三等奖奖品数量</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoodsnumber3" value="${weiXinLuckDrawPo.wcjsprizesizegoodsnumber3 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">三等奖抽中概率</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d\.]/g,'')"  type="text" name="weiXinLuckDrawPo.wcjsprizesizeprobability3" value="${weiXinLuckDrawPo.wcjsprizesizeprobability3 }">
			                %</TD>
                        </TR>
                        <!-- 
                         <tr id="CARDPRICE">
			                 <TD height="26" width="12%" class="table_body">四等奖奖品</TD>
			                <TD class="table_none" width="24%;">
                            	<input class="text_input240" maxlength="20" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoods4" value="${weiXinLuckDrawPo.wcjsprizesizegoods4 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">四等奖奖品数量</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoodsnumber4" value="${weiXinLuckDrawPo.wcjsprizesizegoodsnumber4 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">四等奖抽中概率</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d\.]/g,'')"  type="text" name="weiXinLuckDrawPo.wcjsprizesizeprobability4" value="${weiXinLuckDrawPo.wcjsprizesizeprobability4 }">
			                %</TD>
                        </TR>
                        <tr id="CARDPRICE">
			                 <TD height="26" width="12%" class="table_body">五等奖奖品</TD>
			                <TD class="table_none" width="24%;">
                            	<input class="text_input240" maxlength="20" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoods5" value="${weiXinLuckDrawPo.wcjsprizesizegoods5 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">五等奖奖品数量</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" name="weiXinLuckDrawPo.wcjsprizesizegoodsnumber5" value="${weiXinLuckDrawPo.wcjsprizesizegoodsnumber5 }">
			                </TD>
			                <TD height="26" width="10%" class="table_body">五等奖抽中概率</TD>
			                <TD class="table_none" >
                            	<input class="text_input80" maxlength="20" onkeyup="value=value.replace(/[^\d\.]/g,'')"  type="text" name="weiXinLuckDrawPo.wcjsprizesizeprobability5" value="${weiXinLuckDrawPo.wcjsprizesizeprobability5 }">
			               % </TD>
                        </TR>
                         -->
                      </TBODY>
                    </table>
                    <TABLE id=title2 cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                              <img id="btnSearch" src="${ctx }/img/newbtn/btn_save_0.png" btn=btn title='查询' onClick="javascript:search()">
							</TD>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>