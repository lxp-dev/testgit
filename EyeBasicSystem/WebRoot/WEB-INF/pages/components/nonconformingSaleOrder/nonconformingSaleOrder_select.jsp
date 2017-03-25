<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择采购订单</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
	function search(){
		if(checkForm(document.all.goodsForm)){ 
			 $("img").removeAttr("onclick");
			goodsForm.action = "selectWindowNonformingSaleOrder.action";
			goodsForm.submit();
			showLoadingBar();
		}
	}
	function clean(){
		document.getElementById('poID').value = "";
		document.getElementById('ssesbshopcode').value = "";
		document.getElementById('saleStartTime').value = "";
		document.getElementById('saleEndTime').value = "";
		document.getElementById('takeStartTime').value = "";
		document.getElementById('takeEndTime').value = "";
		document.getElementById('customerphone').value = "";
		document.getElementById('memberid').value = "";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}	

	/**
	 *  调用页面赋值
	 */
	function setValue(poID){ 	         
		window.parent.openPoValues(poID);
		parent.hidePopWin();       
	}
function poIDfocus(){
		document.all.poID.focus();
		//document.all.customerID.value;
	}
$(document).ready(function(){
	if('${ssesbshopcode}'==''){
		$('#ssesbshopcode').attr("value","${person.departmentID}");
	}
	
	poIDfocus();
});
function selectContact(obj){
	if(event.keyCode==13){
		search();
	}
}
$(document).ready(function() { 
	$("img[btn=btn]").attr("style","cursor: hand"); 
	$("img[btn=btn]").mouseover(function () { 
	$(this).attr("src",$(this).attr("src").replace("0","1")); 
	}).mouseout(function () { 
	$(this).attr("src",$(this).attr("src").replace("1","0")); 
	}); 
});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="poType" value="${requestScope.poType }" />
<input type="hidden" name="cshandepartmentid" value="${requestScope.cshandepartmentid }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          
          <TR>
            <TD  colspan="3">
            	<br/> </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
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
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD class="table_body" width="9%" height="26">配镜单号</TD>
                          <TD class="table_none" width="24%"><input class="text_input160" id="poID" name="poID" value="${requestScope.poID}"></TD>
                          <TD width="9%" class="table_body">申报部门</TD>
						  <TD width="24%" height="26" align="left" class="table_none">
						   	<select id="ssesbshopcode" name="salesBasicPo.ssesbshopcode">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentList)}">
				               	  <s:iterator value="departmentList">
                    	           <OPTION value="${bdpdepartmentid}" ${ssesbshopcode eq bdpdepartmentid ? 'selected':''}>${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
      	                   		</c:if>
      	                   </select>
						 </TD>
						 <TD width="9%" class="table_body">销售日期</TD>
                         <TD class="table_none">
					       <input class="text_input100"
				               id="saleStartTime"
						       name="saleStartTime" value="${requestScope.saleStartTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" /> 
					       	至  
					        <input class="text_input100"
						       id="saleEndTime"
						       name="saleEndTime" value="${requestScope.saleEndTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
					        </TD>
                        </TR>		
						<TR> 					 
					      	<TD class="table_body" width="10%">取镜日期</TD>
                          	<TD class="table_none">
						       <input class="text_input100"
					               id="takeStartTime"
							       name="takeStartTime" value="${requestScope.takeStartTime}"
							       type="text" 
							       onFocus="WdatePicker({readOnly:true})"
							       MAXDATE="#F{document.getElementById('endTime').value}" 
							       readonly="readonly" /> 
						     	  至 
						        <input class="text_input100"
							       id="takeEndTime"
							       name="takeEndTime" value="${requestScope.takeEndTime}"
							       type="text" 
							       onFocus="WdatePicker({readOnly:true})"
							       MINDATE="#F{document.getElementById('startTime').value}"
							       readonly="readonly" />
					        </TD>
						   <TD width="9%" height="26" class="table_body">顾客电话</TD>
			               <TD class="table_none">
			               <input class="text_input100" type="text" id="customerphone" name="customerphone" value="${customerphone}"  >
						  </TD>
						   <TD width="9%" height="26" class="table_body">顾客卡号</TD>
			               <TD class="table_none">
			               <input class="text_input100" type="text" id="memberid" name="memberid" value="${memberid}">
						  </TD>					        
                        </TR>
                      </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()"></TD>
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
					<c:if test="${not empty(getSalesOrderList)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                        <TH width="10%" scope=col>操作</TH>
                          <TH width="30%" height="26" scope=col>配镜单号</TH>
                          <TH width="10%" scope=col>销售日期</TH>
                          <TH width="10%" scope=col>取镜日期</TH>
						  <th width="10%">销售门店</th>
                          <TH width="10%" scope=col>销售人员</TH>
                          <TH width="10%" scope=col>销售金额</TH>
                          <TH width="10%" scope=col>顾客姓名</TH>
						  
                        </TR>
                        <c:forEach var="i" items="${getSalesOrderList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                         <TD>
		                      <img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择' onClick="javascript:setValue('${i.ssesbsalesid}')">
		                  </TD>
                          <TD height="26">${i.ssesbsalesid }</TD>
                          <TD>${fn:substring(i.ssesbsalesdatetime,0,10)}</TD>
                          <TD>${fn:substring(i.ssesbtakeglassdata,0,10)}</TD>
						  <td>${i.ssesbshopName }</td>
                          <TD>${i.ssesbsalerName }</TD>
                          <TD>${i.ssesbsalesvalue }</TD>
                          <TD>${i.ssesbpersonName }</TD>
                         
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
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
