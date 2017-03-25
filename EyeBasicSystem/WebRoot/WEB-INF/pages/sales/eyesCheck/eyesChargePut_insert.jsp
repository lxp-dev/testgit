<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>散瞳信息查询</title>
</head>
<script>
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	mydriasisForm.action=link;
	  	mydriasisForm.submit();
	}
	
	function save(){
	
	if(checkForm(document.all.mydriasisForm)){  
        $("img").removeAttr("onclick");
		mydriasisForm.action = "updateChargePut.action";
		mydriasisForm.submit();
		}
	}
	function getCustomer(){ 
	    if(event.keyCode==13){   
		    $("img").removeAttr("onclick");  
			mydriasisForm.action = "selMydriasisForCustomer.action";
			mydriasisForm.submit();
		}
	}
	function selChargePut(){
		var feeType = document.all.feeType;
	    var obj = document.all.frcfeetypename;
		if(feeType.value == ""){
			feeType.value = obj.options[obj.selectedIndex].value;
		}
		$("img").removeAttr("onclick");
		mydriasisForm.action = "selChargePut.action";
	    mydriasisForm.submit();
	}
	
	function details(id){
		showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, 

'',null,true);
		selectHidden();
	}
	
	/*   单个汉字的宽度,根据你的字体大小自行设定   */   
  var   wordWidth   =   '14';   
  function   setWidth()   
  {   
	  obj   =   event.srcElement;   
	  obj.style.width   =   obj.value.replace(/[^\x00-\xff]/g,"**").length*wordWidth/2+5;   
  }
  /* 查询下拉列表第一个  */
  function changeValue(obj){
		var feeType = document.all.feeType;
		feeType.value = obj.options[obj.selectedIndex].value;
	}
	
	function cancelChk(){
		$("input[id='chk']").each(function (){
			this.checked = false;
		});
		document.getElementById('chks').checked = false;
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" value="${requestScope.sopmdfcustomerid}">
<input type="hidden" name="memberid" value="${requestScope.smecimemberid}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>费用提交</TD>
                    <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：费用提交</TD>
                      <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">费用提交</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>

					</TR></TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
                       <TD width="20%" height="30" class="table_body">缴费类型</TD>
			               <TD width="10%" class="table_body">
                             <select id="feeType" name="feeType" onChange="changeValue(this)">
      		                    <option value="1">缴费</option>
      		                    <option value="2">退费</option>
      	                     </select>
      	                   </TD>
      	                   <TD class="table_body">
      	                     <input icon='icon-search' type='button' value='查询' onClick="javascript:selChargePut()">
			               </TD>
                      </TR>
                      </TABLE>  
                       <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
		                      <TD><input id="button1" icon='icon-save' type='button' value='保存' onClick="save()"></TD>
							</td>
						</tr>
					</table>            
<!--                   <br/>-->
                     <c:if test="${not empty(frcmoneyList)}"> 
                     <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                      <TABLE width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">

                      <TR class=table_title align=middle>
                      <TH height="30" scope=col>取消 <input type="checkbox" id="chks" onclick="cancelChk()">
                      </th>
                      <TH width="90%" height="30" scope=col>费用金额</th>
                      </TR>
                      <s:iterator value="frcmoneyList">
                        <TR>
	                        <TD height="30" class="table_none" align="center"><input type="checkbox" name="chk" id="chk" value="${frcid }"></TD>
				            <TD class="table_none" >${frcregisteredname }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${frcmoney }</TD>
                        </TR>
                        </s:iterator>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
	                </TABLE>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
            </TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>