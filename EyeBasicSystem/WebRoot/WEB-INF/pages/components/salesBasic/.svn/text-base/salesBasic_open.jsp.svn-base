<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	salesBasicForm.action=link;
	  	salesBasicForm.submit();
		showLoadingBar();
	}

	 /*光标聚焦*/
	window.onload=function(){
		document.getElementById('salesid').focus();  
	}

	/**
	 *回车事件
	 */
	function selKeyDown(){
		var keyCode = event.keyCode?event.keyCode:event.which?event.which:event.charCode;
		if(keyCode == 13){
			search();
		}	
    }
    
	/*查询*/
	function search(){
		$("img").removeAttr("onclick");
		salesBasicForm.action = "selectSalesBasic.action";
		salesBasicForm.submit();
		showLoadingBar();
	}
	
	/*传参*/
	function setValue(json){
		parent.addGoods(json);
		//window.parent.setCustomer();
		parent.hidePopWin();
	}	

	function permissionMessage(){
       alert('您无此操作权限');
	}	
	
	function selectCustomer(ssesbsalesid ,ssesbshopcode, ssesbshopName ,ssesbcustomerid ,ssesbtakeglassdata){
		window.parent.setCustomer(ssesbsalesid ,ssesbshopcode, ssesbshopName ,ssesbcustomerid, ssesbtakeglassdata);
		parent.hidePopWin();
	}

	function clean(){
		document.getElementById('salesid').value = "";
		document.getElementById('customerName').value = "";
		document.getElementById('shopcode').value = "";
		document.getElementById('takeglassstartdata').value = "";
		document.getElementById('takeglassenddata').value = "";
		
	}		
	
</script>
<!-- ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }-->
<body   ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="salesBasicForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="poType" value="${requestScope.poType }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	<br/></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
			 </TD></TR>
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
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="salesid" name="salesid" value="${requestScope.salesid}" onkeydown="selKeyDown();">			               
			               </TD>
			               <TD width="8%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="24%">${requestScope.supplierName}
                            <input  type="text" id="customerName" name="customerName" value="${requestScope.customerName}" />
                            <input  type="hidden" id="customerid" name="customerid" value="${requestScope.ssesbcustomerid}" />
			               </TD>
			               <TD width="8%" height="26" class="table_body">所属门店</TD>
			               <TD class="table_none">
                            <select id="shopcode" name="shopcode">
                             <option value="">请选择所属门店</option>
      		                 <s:iterator value="deptList">
				               <option value="${bdpdepartmentid}" ${requestScope.shopcode == bdpdepartmentid ? 'selected="selected"' : '' }>${requestScope.bdpdepartmentname }</option>
	     	                 </s:iterator>
      	                   </select>		               
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">取镜时间</TD>
			               <TD class="table_none" colspan="5">
							<input class="text_input100"
				               id="takeglassstartdata"
						       name="takeglassstartdata" value="${requestScope.ssesbtakeglassstartdata }"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="takeglassenddata"
						       name="takeglassenddata" value="${requestScope.ssesbtakeglassenddata}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly" />
					        </TD>			               
                        </TR>
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx 

}/img/newbtn/btn_search_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_search_0.png');" title="查询" onClick="javascript:search()" >
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx 

}/img/newbtn/btn_empty_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');" title="清空" onClick="clean()" >
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
					<c:if test="${not empty(salesBasicList)}"> 
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
                        <TR class=table_title align=middle height="26">
                          <TH width="5%" scope=col>操作</TH>
                          <TH width="25%" scope=col height="26">配镜单号</TH>
                          <TH width="20%" scope=col>顾客姓名</TH>
                          <TH width="25%" scope=col>所属部门</TH>
                          <TH width="25%" scope=col>取镜时间</TH>
						  </TR>
						<s:iterator value="salesBasicList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" height="26">                         
                          <TD>
                             <img src="${ctx }/img/newbtn/select_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/select_1.png');" 

onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/select_0.png');" title='选择' onClick="javascript:selectCustomer('${ssesbsalesid }','${ssesbshopcode }','${ssesbshopName }','${ssesbcustomerid }','${fn:substring(ssesbtakeglassdata,0,10)}')">
                          </TD> 
                          <TD>${ssesbsalesid}</TD>
                          <TD>${ssesbpersonName }</TD> 
                          <TD>${ssesbshopName}</TD>
                          <TD>${fn:substring(ssesbtakeglassdata,0,10)}</TD>  
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
