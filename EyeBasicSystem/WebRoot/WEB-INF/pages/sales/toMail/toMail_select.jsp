<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css"> 
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邮寄管理</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
if($("#title1").is(":visible"))
        {
        	$("input:text")[0].focus();
        }
	});

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	toMailForm.action=link;
	  	toMailForm.submit();
	}
	 function details(hid){
	 	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("toMailDetails.action?ssetmuuid="+hid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("toMailDetails.action?ssetmuuid="+hid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【邮寄信息详细】";
	}
	function update(ssetmuuid){
		var moduleID = document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initToMailUpdate.action?ssetmuuid="+ssetmuuid+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initToMailUpdate.action?ssetmuuid="+ssetmuuid+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【邮寄信息更新】";
	}
	function search(){
		$("img").removeAttr("onclick");
		toMailForm.action = "toMailSel.action";
		toMailForm.submit();
		showLoadingBar();
	}
	
	function selectmember1(){
		if(event.keyCode==13){
			$("img").removeAttr("onclick");
			customerInfoForm.action = "selCustomerInfo.action";
			customerInfoForm.submit();
		}
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initToMailInsert.action?moduleID="+$('#moduleID').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initToMailInsert.action?moduleID="+$('#moduleID').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【邮寄信息新增】";
	}
	function del(ssetmuuid,ssetmmemberid){
		var moduleID = document.getElementById('moduleID').value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initToMailDelete.action?ssetmuuid="+ssetmuuid+"&moduleID="+moduleID+"&ssetmmemberid="+ssetmmemberid,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initToMailDelete.action?ssetmuuid="+ssetmuuid+"&moduleID="+moduleID+"&ssetmmemberid="+ssetmmemberid,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【邮寄信息删除】";
	}
 
	function clean(){
	    $('#ssetmlinksalesid').val('');
	    $('#ssetmmemberid').val('');
	    $('#ssetmcustomername').val('');
	    $('#ssetmcustomerphone').val('');
	    $('#ssetmmailid').val('');
	    $('#ssetmbegintime').val('');
	    $('#ssetmendtims').val('');
	    $('#ssetmmaiilaudit').val('');
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
 
    
	
	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
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
		
		document.getElementById('ssetmbegintime').value = now;
		document.getElementById('ssetmendtims').value = now;		
	}
</script>
<body>
<form name="toMailForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${moduleID }">
 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：邮寄管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            	<img src="${ctx }/img/newbtn/btn_addmail_0.png" btn=btn title="邮寄新增" onclick="insert();"/>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            	</c:if>
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
          <TR>
            <TD colSpan=2 height=20></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	  <TD width="8%" height="26" class="table_body">配镜单号</TD>
					  	  <TD class="table_none" width="23%">
					  	    <input class="text_input200" type="text"  id="ssetmlinksalesid" name="ssetmlinksalesid" value="${ssetmlinksalesid }"/>
					  	    </TD>
					  	  <TD width="8%" height="26" class="table_body">会员卡号</TD>
					  	  <TD class="table_none" width="23%">
					  	    <input class="text_input200" type="text"  id="ssetmmemberid" name="ssetmmemberid" value="${ssetmmemberid }"/>
					  	    </TD>
                    	  <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                    	  <TD class="table_none"><input class="text_input200" type="text"  id="ssetmcustomername" name="ssetmcustomername" value="${ssetmcustomername }"/></TD>
                  	  </TR>
                      <TR>
                      	  <TD height="26" class="table_body">顾客电话</TD>
                    	  <TD class="table_none"><input class="text_input200" type="text"  id="ssetmcustomerphone" name="ssetmcustomerphone" value="${ssetmcustomerphone }"/></TD>
                    	  <TD height="26" class="table_body">快递单号</TD>
                    	  <TD class="table_none"><input class="text_input200" type="text"  id="ssetmmailid" name="ssetmmailid" value="${ssetmmailid }"/></TD>
                    	  <TD height="26" class="table_body">邮寄日期</TD>
						  <TD class="table_none">
						  <li class="horizontal_onlyRight">
						  <input id="ssetmbegintime"
					       name="ssetmbegintime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssetmendtims\')}'})"
					       value="${ssetmbegintime }" />
						       至
  						  <input id="ssetmendtims"
					       name="ssetmendtims" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssetmbegintime\')}'})" 
					        value="${ssetmendtims }" />
					       </li>
					       <li class="horizontal_onlyRight">
					  				  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
					       
					       </TD>
                  	  </TR>
                  	  
                  	  <TR>
                    	  <TD height="26" class="table_body">邮寄状态</TD>
                    	  <TD class="table_none" colspan="5">
                    	  <select id="ssetmmaiilaudit" name="ssetmmaiilaudit">
                    	  	<option value="">----请选择----</option>
                    	  	<option value="1" ${ssetmmaiilaudit != '1' ? '':'selected=selected' }>已邮寄</option>
                    	  	<option value="0" ${ssetmmaiilaudit != '0' ? '':'selected=selected' }>未邮寄</option>
                    	  </select>
                    	  </TD>
                  	  </TR>
                      </TBODY>
                    </TABLE>
                     
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							 <c:if test="${(permissionPo.keyd==1)}">
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onclick="search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onclick="clean()">
								</c:if>
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
					<c:if test="${toMailPos != null}">
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
 					  
					  <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="9%" scope=col colspan="3">操作</TH>
                          <TH width="7%" height="26" scope=col>会员卡号</TH>
                          <TH width="7%" scope=col>顾客姓名</TH>
                          <TH width="7%" scope=col>联系人</TH>
						  <TH scope=col>配镜单号</TH>
						  <TH width="8%" scope=col>联系电话</TH>
						  <TH width="7%" scope=col>录入人</TH>
						  <TH width="14%" scope=col>录入日期</TH>
						  <TH width="7%" scope=col>邮寄人</TH>
						  <TH width="14%" scope=col>邮寄日期</TH>
						  </TR>
						 <c:forEach var="po" items="${toMailPos}">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD width="3%">
	                          <c:if test="${(permissionPo.keye==1)}">
		                      	 <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:details('${po.ssetmuuid}')">
		                      	 </c:if>	
		                      </TD>
			                  <TD width="3%">
			                   <c:if test="${(permissionPo.keyc==1)}">
			                  <c:if test="${po.ssetmmaiilaudit == '1'}">
	                             <img src="${ctx }/img/newbtn/edit_2.png" btn=btn title='修改'/></TD>
			                  </c:if>
			                  <c:if test="${po.ssetmmaiilaudit != '1'}">
	                             <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${po.ssetmuuid }')">			                  </TD>
			                  </c:if> 
			                  </c:if> 
			                  
			                  <TD width="3%">
			                  <c:if test="${(permissionPo.keyb==1)}">
			                  <c:if test="${po.ssetmmaiilaudit != '1'}">
	                             <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${po.ssetmuuid }','${po.ssetmmemberid }')">		
	                          </c:if>
	                          <c:if test="${po.ssetmmaiilaudit == '1'}">
	                             <img src="${ctx }/img/newbtn/delete_2.png" btn=btn title='删除'/> </TD>
			                  </c:if>
			                  </c:if>
	                          </TD>
	                          <TD height="26">${po.ssetmmemberid }</TD>
	                          <TD>${po.ssetmcustomername }</TD>
	                          <TD>${po.ssetmlinkman }</TD>
	                          <td>${po.ssetmlinksalesid }</td>
	                          <TD>${po.ssetmcustomerphone }</TD>
	                          <TD>${po.ssetmcreatepensonname }</TD>
	                          <TD>${fn:substring(po.ssetmcreatedate,0,16) }</TD>
	                          <TD>${po.ssetmsendpensonname }</TD>
	                          <TD>${fn:substring(po.ssetmsenddate,0,16) }</TD>
	                        </TR>
                         </c:forEach>
                      </TBODY>
                    </TABLE>
                      <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               
                  </DIV>
                  </c:if>
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

