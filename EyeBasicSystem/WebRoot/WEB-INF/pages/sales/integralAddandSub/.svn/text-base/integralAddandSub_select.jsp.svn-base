<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>积分赠送管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerInfoForm.action=link;
	  	customerInfoForm.submit();
		showLoadingBar();
	}
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	 function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initSelectIntegralAddandSubDetails.action?smeasuuid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSelectIntegralAddandSubDetails.action?smeasuuid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【积分赠送详细】";
	}
	function search(){
		$("img").removeAttr("onclick");
		customerInfoForm.action = "selectIntegralAddandSub.action";
		customerInfoForm.submit();
		showLoadingBar();
	}
	
	function selectmember1(){
		if(event.keyCode==13){
			search();
		}
	}
	
	function insert(){
		var moduleID =document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initInsertIntegralAddandSub.action?moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertIntegralAddandSub.action?moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【积分赠送新增】";
	}

	function clean(){
		$("#smeasmemberid").val('');
		$("#smeascustomername").val('');
		$("#smeascustomerphone").val('');
		$("#smeasdopersonname").val('');
		$("#complaintype").val('');
		$("#handlepersonname").val('');
		$("#handlestate").val('');
		$("#registerpersonname").val('');
		$("#startTime1").val('');
		$("#endTime1").val('');
		$("#smeasissendmessage").val('');
		$("#smeasaddorsub").val('');
		$("#smeassalesbillt").val('');
		
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}

    /**
	 *聚焦
	 */
	$(document).ready(function (){
		document.getElementById('smeasmemberid').focus();  
	});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="customerInfoForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input id="moduleID" type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：积分赠送</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            	<img src="${ctx}/img/newbtn/btn_integraladdandsub_0.png" btn=btn title="积分赠送新增" onClick="insert()">
            	</c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="10%" height="26" class="table_body">会员卡号</TD>
			               <TD class="table_none" width="19%">
                            <input class="text_input160" type="text" maxlength="50" id="smeasmemberid" name="smeasmemberidt" value="${smeasmemberidt}"/>
			               </TD>
			               <TD width="8%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="19%">
                             <input class="text_input160" type="text" maxlength="20" id="smeascustomername" name="smeascustomernamet" value="${smeascustomernamet}"/>
			               </TD>
						   <TD width="8%" height="26" class="table_body">联系电话</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text" maxlength="20" id="smeascustomerphone" name="smeascustomerphonet" value="${smeascustomerphonet}"/>
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">操作人姓名</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text" maxlength="35" id="smeasdopersonname" name="smeasdopersonnamet" value="${smeasdopersonnamet}"/>
			               </TD>
						   <TD height="26" class="table_body">操作时间</TD>
			               <TD class="table_none" colspan="3">
                            <li class="horizontal_onlyRight"><input class="text_input100"
				               id="startTime1"
						       name="smeasdobegindatet" value="${smeasdobegindatet}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'endTime1\')}'})"
						       MAXDATE="#F{document.getElementById('endTime1').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime1"
						       name="smeasdoenddatet" value="${smeasdoenddatet}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'startTime1\')}'})"
						       MINDATE="#F{document.getElementById('startTime1').value}"
						       readonly="readonly" /></li>
						     <li class="horizontal_onlyRight">
                           		<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today('startTime1','endTime1')">
                           	 </li>
                          	 <li class="horizontal_onlyRight">
                            	<img src="${ctx }/img/newbtn/btn_month_0.png"  btn=btn title="当月" onClick="currtMonth('startTime1','endTime1')">
                             </li>
			               </TD>
                        </TR>
                  <c:if test="${systemParameterPo.fspshortmessage == '1'}">	      
                        <TR>
                           <TD height="26" class="table_body">短信发送状态</TD>
			               <TD class="table_none" colspan="5">
				               <select id="smeasissendmessage" name="smeasissendmessaget">
	      		                 	<option value="">----请选择----</option>
	                    	        <OPTION value="1" ${smeasissendmessaget != '1'  ? '' : 'selected="selected"' } >已发送</OPTION>
	                    	        <OPTION value="0" ${smeasissendmessaget != '0'  ? '' : 'selected="selected"' } >未发送</OPTION>
	      	                   </select>
			               </TD>
                        </TR>
                  </c:if>      
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyb=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()" onkeydown="selectmember1()" >
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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
					<c:if test="${not empty(integralAddandSubPos)}"> 
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
                          <TH width="8%" scope=col  height="26">操作</TH>
						  <TH width="12%" scope=col>会员卡号</TH>						
						  <TH width="8%" scope=col>会员姓名</TH>
						  <!-- <TH width="11%" scope=col>联系电话</TH> -->
						  <TH width="9%" scope=col>赠送前积分</TH>
						  <TH width="9%" scope=col>赠送积分</TH>
						  <TH width="9%" scope=col>赠送后积分</TH>
						  <TH width="8%" scope=col>操作人</TH>						  
						  <TH width="15%" scope=col>操作时间</TH>
					<c:if test="${systemParameterPo.fspshortmessage == '1'}">	  
						  <TH scope=col>短信状态</TH>
					</c:if>	  
						  </TR>
						 <s:iterator value="integralAddandSubPos">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD width="8%">
		                          <c:if test="${permissionPo.keyc=='1'}">
			                      	 <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:details('${smeasuuid}')">
				                  </c:if>
			                  </TD>
			                 <!--   <TD width="4%">
				                  <c:if test="${permissionPo.keyd=='1' && systemParameterPo.fspshortmessage == '1'}">
	                           		 <img btn=btn src="${ctx }/img/newbtn/sendmessage_0.png" title='发送短信' onClick="javascript:sendmessage('${smeasuuid}')">
				                  </c:if>
			                  </TD>-->
	                          <TD height="26">${smeasmemberid}</TD>
	                          <TD>${smeascustomername}</TD>
	                          <!-- <TD>${smeascustomerphone}</TD>-->
							  <td>${smeasyintegral}</td>
	                          <TD>${smeascintegral}</TD>
	                          <TD>${smeasxintegral}</TD>
	                          <TD>${smeasdopersonname}</TD>
	                          <TD>${fn:substring(smeasdodate,0,16)}</TD>
	                      <c:if test="${systemParameterPo.fspshortmessage == '1'}">	     
                          	  <TD>
                          	  	<c:if test="${smeasissendmessage == '0'}">
                          	  		未发送
                          	  	</c:if>
                          	  	<c:if test="${smeasissendmessage == '1'}">
                          	  		已发送
                          	  	</c:if>
                          	  </TD>
                          </c:if>	  
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