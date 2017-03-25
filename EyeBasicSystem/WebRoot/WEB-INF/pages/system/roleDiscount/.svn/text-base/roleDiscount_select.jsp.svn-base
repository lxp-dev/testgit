<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工打折管理</title>
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
	  	roleDiscountForm.action=link;
	  	roleDiscountForm.submit();
		showLoadingBar();
	}
	function search(){
		roleDiscountForm.action = "selRoleDiscount.action";
		roleDiscountForm.submit();
		showLoadingBar();
	}
	function update(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initRoleDiscountInsert.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initRoleDiscountInsert.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【角色折扣设置】";
	}
	function clean(){
	    document.all.role.value="";
	    $('#begPrice').val('');
	    $('#endPrice').val('');
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	function yzTSZheKou(){
		var vl=$('#begPrice').val();
		b=".";
		if(ReplaceDemo(vl)>1){
			alert("折扣输入错误！");
			$('#begPrice').focus();
			$('#begPrice').select();
			return;
		}
		if(vl>1){
			alert("折扣应小于1！");
			$('#begPrice').focus();
			$('#begPrice').select();
			return;
		}
		var indexNum=vl.indexOf(".");
		if(indexNum==0){
			vl=0+vl;
			$('#begPrice').val(vl)
		}
		
	}
	function yzTSZheKouend(){
		var vl=$('#endPrice').val();
		b=".";
		if(vl>1){
			alert("折扣应小于1！");
			$('#begPrice').focus();
			$('#begPrice').select();
			return;
		}
		if(ReplaceDemo(vl)>1||vl>1){
			alert("折扣输入错误！");
			$('#endPrice').focus();
			$('#endPrice').select();
			return;
		}
		var indexNum=vl.indexOf(".");
		if(indexNum==0){
			vl=0+vl;
			$('#endPrice').val(vl)
		}
		
	}
	 function ReplaceDemo(ss){ 
		   var r, re;   
		   var strlength = ss.length; 
		   //alert(strlength); 
		   re = /\./;        // 创建正则表达式模式。 
		   while(re.test(ss)){ 
		  ss = ss.replace(re, "");   
		   }  
		   return (strlength-ss.length); 
		}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="roleDiscountForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>营销管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：员工打折权限</TD>
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
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">角色打折查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1   
                       onclick="JavaScript:window.location.href='initPersonDiscountSel.action?moduleID=${requestScope.moduleID}';"                    
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">员工打折权限查询</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
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
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">角色</TD>
			               <TD width="40%" class="table_none">
			               <select id="role" name="role">
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="roleList">
				               <option value="${roleid}" >${rolename}</option>
	     	               </s:iterator>
      	                   </select>
			               </TD>
			               
			               <TD width="8%" height="26" class="table_body">打折折扣</TD>
			               <TD width="40%" class="table_none">
			               <input type="text" style="width: 100px;" maxlength="4" name="begPrice" onblur="yzTSZheKou();" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  id="begPrice"  value="${ begPrice}"> - <input onblur="yzTSZheKouend();" style="width: 100px;" maxlength="4" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="endPrice" type="text" name="endPrice" value="${ endPrice}">
			               </TD>
			               
                          </TR>

                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keya == 1}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
		                      <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
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
					<c:if test="${not empty(roleDiscountList)}"> 
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
                          <TH width="15%" height="26" scope=col>角色ID</TH>
                          <TH width="35%" scope=col>角色名称</TH>
                          <TH width="15%" scope=col>折扣</TH>
						</TR>
						<s:iterator value="roleDiscountList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
		                  	<c:if test="${permissionPo.keyb == 1}">
		                     <img src="${ctx }/img/newbtn/configure_0.png" btn=btn title='设置' onClick="javascript:update('${frdroleid}')">
		                  	</c:if>
		                  </TD>
                          <TD height="26">${frdroleid}</TD>
                          <TD>${frdroleName}</TD>
                          <TD>
                          <c:if test="${not empty(frddiscount)}">
                          ${frddiscount}
                          </c:if>
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
<script>

	var index_role = 0;
	var arr = document.all.role.options.length;
	for(i=0;i<arr;i++){
		if(document.all.role.options.options[i].value == '<c:out value="${requestScope.role}"/>'){
			document.all.role.options.selectedIndex = index_role;
			break;
		}
		index_role++;
	}
</script>