<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外预误期查询</title>
</head>
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />

<script>	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        }); 
        changeselect('0');
	}); 

	function search(){
		if(checkForm(delayNoticeForm)){		
			$("img").removeAttr("onclick");
			delayNoticeForm.action = "selectWillDelayWarning.action";
			delayNoticeForm.submit();
			showLoadingBar();
		}
	}	
	function insert(sid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertDelayNotice.action?moduleID=${requestScope.moduleID}&sid="+sid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertDelayNotice.action?moduleID=${requestScope.moduleID}&sid="+sid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【委外误期通知新增】";
	}
	function view(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDelayNoticeDetails.action?sid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDelayNoticeDetails.action?sid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【委外误期通知详细】";
	}
	
	function clean(){
	    $('input[name=bdwwarningdate]').val('');
	    $('input[name=bdwminwarningdate]').val('');
		$('#bdwnoticetype').val('');
		$('#bdwqshopcodeid').val('');
		$('input[name=bdwpmf]').attr('checked','');
		$('input[name=bdwwsmp]').attr('checked','');
		$('input[name=bdwfmj]').attr('checked','');
		$('input[name=bdcjmj]').attr('checked','');
		$('input[name=bdwjmj]').attr('checked','');
		$('input[name=bdwjmp]').attr('checked','');
		$("#intransit").val("");
		$("#intransittype").val("1");
		$("#intransittype2").val("1");	
		$("#intransit2").val("");	
		$("#intransittype2").hide();;	
		$("#intransit2").hide();	
		$('#salesbillid').val('');
		document.getElementById('selbspsuppliername').value = "";
		document.getElementById('selbbdsupplierid').value = "";
	}
	
	/*开窗事件*/
	function winPopUp(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInTransitDetailsSel.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initInTransitDetailsSel.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【在途详细】";
	}

	function changeselect(obj){
		var selecta = $("#intransittype");
		var selectb = $("#intransit");
		var selectc = $("#intransittype2");
		var selectd = $("#intransit2");
		if(obj == '0'){
			if(selecta.val() == '1' || selecta.val() == '4' || selecta.val() == '5'){
				selectc.hide();
				selectd.hide();
				selectd.val('');
			}else if(selecta.val() == '2' || selecta.val() == '3'){
				selectc.show();
				selectd.show();
			}
		}
	}

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bbdsupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
	}	

	//打开配镜详细信息 
	 function selectInTransitDetails(billID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+billID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+billID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单详细】";		
   }		
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="delayNoticeForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：委外预误期查询</TD>
            <td align="right" width="40%" valign="bottom">&nbsp;
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onclick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>         
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
         <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx }/img/pic/tab_bg.gif>
		  </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD class="table_body" width="10%" height="26">距取镜时间(天)</TD>
                          <TD class="table_none" width="24%"><input type="text" class="text_input100" maxlength="20" id="bdwminwarningdate" name="bdwminwarningdate" value="${bdwminwarningdate}" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '请重新填写误期天数下限,天数应为正整数!'}]" /> 至
                          <input type="text" class="text_input100" maxlength="20" id="bdwwarningdate" name="bdwwarningdate" value="${not empty(bdwwarningdate) ? bdwwarningdate : fn:trim(delayWarningPo.bdwwarningdate)}" validate="[{'Type' : Type.String,'Formula' : Formula.notNull, 'Message' : '请填写误期天数上限!'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写误期天数上限,天数应为正整数!'}]" /></TD>
                          <TD class="table_body" width="9%">通知状态</TD>
                          <TD class="table_none" width="24%">
                          	<select id="bdwnoticetype" name="bdwnoticetype">
						  		<option value="">----请选择----</option>
								<option value="0" ${bdwnoticetype == '0' ? 'selected="selected"' : '' } >未通知</option>
								<option value="1" ${bdwnoticetype == '1' ? 'selected="selected"' : '' } >已通知</option>
							</select>
					      </TD>
                          <TD width="9%" class="table_body" height="26">取镜部门</TD>
                          <TD width="24%" class="table_none">
						    <c:if test="${personInfoPo.departmenttype!=1}">
                            <select id="bdwqshopcodeid" name="bdwqshopcodeid">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${bdwqshopcodeid != bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                    </select>
      	                    </c:if>
      	                    <c:if test="${personInfoPo.departmenttype==1}">
                             (${personInfoPo.departmentID})${personInfoPo.bdpdepartmentname}<input type="hidden" name="bdwqshopcodeid" value="${personInfoPo.departmentID}" name="bdwqshopcodeid"/>
      	                    </c:if>
						  </TD>
                        </TR>
                        <TR>
                          <TD class="table_body">配镜单状态</TD>
						  <TD height="26" align="left" class="table_none">
						  <select name="intransittype" id="intransittype" onchange="changeselect('0')">
                            <option value="1" ${requestScope.intransittype == '1' ? 'selected="selected"' : '' }>=</option>
                            <option value="2" ${requestScope.intransittype == '2' ? 'selected="selected"' : '' }>>=</option>
                            <option value="3" ${requestScope.intransittype == '3' ? 'selected="selected"' : '' }>></option>
                            <option value="4" ${requestScope.intransittype == '4' ? 'selected="selected"' : '' }><=</option>
                            <option value="5" ${requestScope.intransittype == '5' ? 'selected="selected"' : '' }><</option>
                          </select>
                          <select name="intransit" id="intransit" onchange="changeselect('1')">
                            <option value="">----请选择----</option>
                            <option value="3" ${requestScope.intransit == 3 ? 'selected="selected"' : '' }>门店已配送未发料</option>
                            <option value="4" ${requestScope.intransit == 4 ? 'selected="selected"' : '' }>已做委外订单未收货</option>
                            <option value="5" ${requestScope.intransit == 5 ? 'selected="selected"' : '' }>委外订单已收货</option>
                            <option value="6" ${requestScope.intransit == 6 ? 'selected="selected"' : '' }>已发料未初检</option>
                            <option value="7" ${requestScope.intransit == 7 ? 'selected="selected"' : '' }>已初检未加工</option>
                            <option value="8" ${requestScope.intransit == 8 ? 'selected="selected"' : '' }>已加工未检验</option>
                            <option value="9" ${requestScope.intransit == 9 ? 'selected="selected"' : '' }>已检验未配送</option>
                            </select>
                            <select name="intransittype2" id="intransittype2" onchange="changeselect('3')">
                            <option value="1" ${requestScope.intransittype2 == '1' ? 'selected="selected"' : '' }><=</option>
                            <option value="2" ${requestScope.intransittype2 == '2' ? 'selected="selected"' : '' }><</option>
                            </select>
                            <select name="intransit2" id="intransit2" onchange="changeselect('4')">
                            <option value="">----请选择----</option>
                            <option value="3" ${requestScope.intransit2 == 3 ? 'selected="selected"' : '' }>门店已配送未发料</option>
                            <option value="4" ${requestScope.intransit2 == 4 ? 'selected="selected"' : '' }>已做委外订单未收货</option>
                            <option value="5" ${requestScope.intransit2 == 5 ? 'selected="selected"' : '' }>委外订单已收货</option>
                            <option value="6" ${requestScope.intransit2 == 6 ? 'selected="selected"' : '' }>已发料未初检</option>
                            <option value="7" ${requestScope.intransit2 == 7 ? 'selected="selected"' : '' }>已初检未加工</option>
                            <option value="8" ${requestScope.intransit2 == 8 ? 'selected="selected"' : '' }>已加工未检验</option>
                            <option value="9" ${requestScope.intransit2 == 9 ? 'selected="selected"' : '' }>已检验未配送</option>
                            </select>
						  </TD>
						  <TD width="8%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none" colspan="3">
						   	<li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="bbdsupplierid" name="selbbdsupplierid" value="${selbbdsupplierid }"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li></TD>
                        </TR>
                        <tr>
                          <TD class="table_body" width="10%" height="26">配镜单号</TD>
                          <TD class="table_none" width="24%" colspan="5">
                          <input type="text" class="text_input200" maxlength="20" id="salesbillid" name="salesbillid" value="${salesbillid}" /></TD>
                        </tr>
                      </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          	<c:if test="${(permissionPo.keya==1)}">
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >
							</c:if>
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
					<c:if test="${not empty(delayWarningPos)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="6%" height="26" scope=col colspan="2">操作</TH>
                          <TH width="10%" scope=col>配镜单号</TH>
                          <TH scope=col>销售门店</TH>
						  <th width="10%">取镜门店</th>
                          <TH width="15%" scope=col>配镜时间</TH>
                          <TH width="15%" scope=col>取镜时间</TH>
                          <TH width="10%" scope=col>通知状态</TH>
                          <TH width="10%" scope=col>在途状态</TH>
                        </TR>
                        <c:forEach var="po" items="${delayWarningPos}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
		                     <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:view('${po.bdwsalesid}')">
		                  </TD>
		                  
                          <TD width="3%">
                            <c:if test="${(permissionPo.keyb==1)}">
	                          	<c:if test="${po.bdwnoticeid == '' || po.bdwnoticeid == null}">
	                          		<img src="${ctx }/img/newbtn/call_0.png" btn=btn title='通知' onClick="insert('${po.bdwsalesid }')">
	                          	</c:if>
	                          	<c:if test="${po.bdwnoticeid != '' && po.bdwnoticeid != null}">
	                          		<img src="${ctx }/img/newbtn/call_2.png" btn=btn title='通知'>
	                          	</c:if>
                          	</c:if>
                          </TD>
                          <TD height="26"><a href="javascript:void(0);" onclick="selectInTransitDetails('${po.bdwsalesid }')" >${po.bdwsalesid}</a></TD>
                          <TD>${po.bdwsshopcodename }</TD>
						  <td>${po.bdwqshopcodename }</td>
                          <TD>${fn:substring(po.bdwsalesdatetime,0,16) }</TD>
                          <TD>${fn:substring(po.bdwtakedatetime,0,16) }</TD>
                          <td>
                          	<c:if test="${po.bdwnoticeid != '' && po.bdwnoticeid != null}">
                          		已通知
                          	</c:if>
                          	<c:if test="${po.bdwnoticeid == '' || po.bdwnoticeid == null}">
                          		未通知
                          	</c:if>
                          </td>
                          <td>
							<c:choose>
								<c:when test="${po.bdwinTransit == 1 }">
									 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">销售完成</a>
			                    </c:when> 
			                    <c:when test="${po.bdwinTransit == 2 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">银台结款</a>
			                    </c:when>      
			                    <c:when test="${po.bdwinTransit == 3 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">门店配送</a>
			                    </c:when>      
			                    <c:when test="${po.bdwinTransit == 4 }">
			                    	 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">委外订单</a>
			                    </c:when>
			                    <c:when test="${po.bdwinTransit == 5 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">委外收货</a>
			                    </c:when>      
			                    <c:when test="${po.bdwinTransit == 6 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">配镜发料</a>
			                    </c:when>
			                    <c:when test="${po.bdwinTransit == 7 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">加工初检</a>
			                    </c:when>        
			                    <c:when test="${po.bdwinTransit == 8 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">加工师加工</a>
			                    </c:when>      
			                    <c:when test="${po.bdwinTransit == 9 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">加工检验</a>
			                    </c:when>      
			                    <c:when test="${po.bdwinTransit == 10 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">加工配送</a>
			                    </c:when>   
			                    <c:when test="${po.bdwinTransit == 11 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">隐形配送</a>
			                    </c:when>    
			                    <c:when test="${po.bdwinTransit == 12 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">取镜处收货</a>
			                    </c:when>      
			                    <c:when test="${po.bdwinTransit == 13 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">顾客取镜</a>
			                    </c:when>      
			                    <c:when test="${po.bdwinTransit == 14 }">
			                   		 <a style= 'text-decoration : underline;cursor: hand;' onClick="winPopUp('${po.bdwsalesid }')">顾客退货</a>
			                    </c:when>      
			                  </c:choose>                           
                          </td>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
    
  
	
    </BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
