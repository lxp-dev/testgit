<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>短信记录管理</title>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerForm.action=link;
	  	customerForm.submit();		
		showLoadingBar();
	}
	function search(){
		$("img").removeAttr("onclick");
		smsRecordForm.action = "selectSmsRecord.action";
		smsRecordForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('fsrreceiptpersont').value = "";
		document.getElementById('fsrreceipttelt').value = "";
		document.getElementById('fsrbegindate').value = "";
		document.getElementById('fsrenddate').value = "";
		document.getElementById('fsrsendpersont').value = "";
		document.getElementById('fsrsendpersonnamet').value = "";
		document.getElementById('fsrsendflagt').value = "";
		document.getElementById('fsrsendtypet').value = "";
	}

	function sendMessage(){
		
		var DataUrl = "&fsrreceiptpersont="+$('#fsrreceiptpersont').val() + "&fsrreceipttelt="+$('#fsrreceipttelt').val()
					 +"&fsrbegindate="+$('#fsrbegindate').val() + "&fsrenddate="+$('#fsrenddate').val()
					 +"&fsrsendpersont="+$('#fsrsendpersont').val() + "&fsrsendpersonnamet="+$('#fsrsendpersonnamet').val()
					 +"&fsrsendflagt="+$('#fsrsendflagt').val() + "&fsrsendtypet="+$('#fsrsendtypet').val();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selReSendMessage.action?moduleID=${moduleID}" + DataUrl,550,300,topRows,topCols,returnRefresh(false),false);
		}else{
			showPopWin("selReSendMessage.action?moduleID=${moduleID}" + DataUrl,550,300,topRows,topCols,returnRefresh(false),false);
		}
		document.getElementById('popupTitle').innerHTML="【发送短信】";
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="smsRecordForm" method="post" action="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统设置</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：短信记录&nbsp;
			  <c:choose>
	              <c:when test="${smsCount==''}">
	              	[错误：接口访问过快]
	              </c:when>
				  <c:when test="${smsCount=='短信接口参数未配置'}">
	              	[短信接口参数未配置]
	              </c:when>
				  <c:when test="${smsCount=='短信接口参数配置错误'}">
	              	[短信接口参数配置错误]
	              </c:when>	              
	              <c:otherwise>				              	
	              	[可用剩余短信：${smsCount}条]
	              </c:otherwise>
              </c:choose>
             </TD>	
            <td align="right" valign="bottom">&nbsp;
            	<img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </table>
					<input type="hidden" name="hid">
					<input type="hidden" name="type" id="type" value="" /> 
					<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
                          <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                          <TD width="19%" class="table_none"><input class="text_input160" maxlength="30" id="fsrreceiptpersont" name="fsrreceiptpersont" value="${requestScope.fsrreceiptpersont}"></TD>
                          <TD width="8%" height="26" class="table_body">电话</TD>
                          <TD width="19%" class="table_none"><input class="text_input160" maxlength="20" id="fsrreceipttelt" name="fsrreceipttelt" value="${requestScope.fsrreceipttelt}"></TD>
                          <TD width="8%" height="26" class="table_body">发送日期</TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                          <input class="text_input100"
				               id="fsrbegindate"
						       name="fsrbegindate" value="${requestScope.fsrbegindate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('fsrenddate').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="fsrenddate"
						       name="fsrenddate" value="${requestScope.fsrenddate}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('fsrbegindate').value}"
						       readonly="readonly" />
						       
						 </li><li class="horizontal_onlyRight">
                            <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('fsrbegindate','fsrenddate')"></li>
                          <li class="horizontal_onlyRight">
                            <img src="${ctx }/img/newbtn/btn_month_0.png" btn=btn title="当月" onClick="currtMonth('fsrbegindate','fsrenddate')"></li>    
						 </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">发送人工号</TD>
                          <TD class="table_none"><input class="text_input120" maxlength="10" id="fsrsendpersont" name="fsrsendpersont" value="${requestScope.fsrsendpersont}"></TD>
                          <TD height="26" class="table_body">发送人姓名</TD>
                          <TD class="table_none"><input class="text_input160" maxlength="30" id="fsrsendpersonnamet" name="fsrsendpersonnamet" value="${requestScope.fsrsendpersonnamet}"></TD>
                          <TD height="26" class="table_body">发送状态</TD>
                          <TD class="table_none">
                          <select name="fsrsendflagt" id="fsrsendflagt">
					  		<option value="">----请选择----</option>
					  		<option value="0" ${fsrsendflagt == 0 ? 'selected="selected"' : '' }>暂未发送</option>
					  		<option value="1" ${fsrsendflagt == 1 ? 'selected="selected"' : '' }>发送成功</option>
					  		<option value="2" ${fsrsendflagt == 2 ? 'selected="selected"' : '' }>发送失败</option>					  							
						  </select>
							</TD>
                        </TR>   
                        <TR>
						<TD height="26" class="table_body">短信类型</TD>
                          <TD class="table_none" colspan="5">
                          <select name="fsrsendtypet" id="fsrsendtypet">
					  		<option value="" ${fsrsendtypet == '' ? 'selected="selected"' : '' }>----请选择----</option>					  		
					  		<s:iterator value="noteTypeList">
					  		    <option value="${bnttypeid }" ${fsrsendtypet == bnttypeid ? 'selected="selected"' : '' }>${bnttypename }</option>
					  		</s:iterator>					  					  							
						  </select>
							</TD>
                        </TR>  
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="10">
						
						
							<td>
								<c:if test="${(permissionPo.keyd==1)}">
									<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
	                       			<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
	                       		</c:if>
	                       		<img src="${ctx }/img/newbtn/btn_sendmessage_0.png" btn=btn title='发送短信' onclick="sendMessage()">
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
					<c:if test="${not empty(smsRecordPos)}">		
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" scope=col>顾客姓名</TH>
                          <TH width="15%" scope=col>电话</TH>
                          <th width="10%" scope=col>创建日期</th>
                          <TH width="15%" scope=col>短信类型</TH>
						  <th width="10%" scope=col>发送人姓名</th>
						  <th width="10%" scope=col>发送日期</th>
						  <TH width="10%" scope=col>发送状态</TH>
                          <TH height="26" scope=col>发送内容</TH>
                        </TR>
                        <s:iterator value="smsRecordPos">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${fsrreceiptperson}</TD>
                          <TD>${fsrreceipttel}</TD>
                          <TD>${fn:substring(fsrcreatedate,0,16) }</TD> 
                          <TD>${fsrsendtypename}</TD>
                          <TD>${fsrsendpersonname}</TD>
                          <TD>${fn:substring(fsrsenddate,0,16) }</TD> 
                          <TD>
                          	<c:choose>
                          		<c:when test="${fsrsendflag eq ''}">
                          			暂未发送
                          		</c:when>
                          		<c:when test="${fn:substring(fsrsendflag,0,1) == '0'}">
                          			发送成功
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-1'}">
                          			签权失败
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-2'}">
                          			未检索到被叫号码
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-3'}">
                          			被叫号码过多
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-4'}">
                          			内容未签名
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-5'}">
                          			内容过长
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-6'}">
                          			余额不足
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-7'}">
                          			暂停发送
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-8'}">
                          			保留
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-9'}">
                          			定时发送时间格式错误
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-10'}">
                          			下发内容为空
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-11'}">
                          			账户无效
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-12'}">
                          			Ip 地址非法
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-13'}">
                          			操作频率快
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-14'}">
                          			操作失败
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-15'}">
                          			拓展码无效
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-16'}">
                          			取消定时,seqid 错误
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-17'}">
                          			未开通报告
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-18'}">
                          			暂留
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-19'}">
                          			未开通上行
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-20'}">
                          			暂留
                          		</c:when>
                          		<c:when test="${fsrsendflag eq '-21'}">
                          			包含屏蔽词
                          		</c:when>
                          	</c:choose>             	
                          </TD>
                          <TD>${fsrsendcontext}</TD>               
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>