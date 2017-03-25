<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐管理</title>
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

	function search(){
		departmentstForm.action = "setMealSalesAllSel.action";
		departmentstForm.submit();
		showLoadingBar();
	}
	
	function detail(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSetmealDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initSetmealDetail.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【套餐详细】";
		
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		$('#departmentstForm').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#departmentstForm').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentstForm" name="departmentstForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
					  </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="9%" height="26" class="table_body">套餐标题</TD>
                          <TD width="24%" class="table_none"><input clean="clean" class="text_input200" id="setMealTitle" name="setMealTitle" value="${setMealTitle}" maxlength="100"/></TD>
                          <TD width="9%" height="26" class="table_body">套餐日期</TD>
                          <TD width="24%" class="table_none">
                          <input id="cstartTime" clean="clean" 
					       name="cstartTime"
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'cendTime\')}'})"
					       value="${cstartTime }" /> 至 <input id="cendTime"
					       name="cendTime"  clean="clean"
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'cstartTime\')}'})" 
					        value="${cendTime }" />
                          </TD>
                          <TD height="26" class="table_body">套餐分类</TD>
                          <TD height="26" class="table_none">
                          <select clean="clean" id="setMealClassif" name="setMealClassif">
                            <option value="">----请选择----</option>
                            <option value="1" ${setMealClassif == '1' ?'selected="selected"':''}>框镜销售</option>
                            <option value="3" ${setMealClassif == '3' ?'selected="selected"':''}>隐形销售</option>
                            <option value="5" ${setMealClassif == '5' ?'selected="selected"':''}>辅料销售</option>
                          </select></TD>
                        </TR>
                        <tr>
                          <TD height="26" class="table_body">失效状态</TD>
                          <TD height="26" class="table_none" colspan="5">
	                           <select clean="clean" id="isenabled" name="isenabled">
	                            <option value="" >----请选择----</option>
	                            <option value="1" ${isenabled == '1' ?'selected="selected"':''}>未失效</option>
	                            <option value="0" ${isenabled == '0' ?'selected="selected"':''}>已失效</option>
	                           </select>
                          </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" ></td>
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
                    
                    <c:if test="${not empty(setMealList)}">
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
                          <TH width="3%" scope=col>操作</TH>
                          <TH width="30%" height="26" scope=col>套餐标题</TH>
                          <TH width="8%" scope=col>套餐分类</TH>
                          <TH width="8%" scope=col>折上折</TH>
                          <TH width="10%" scope=col>套餐日期</TH>
                          <TH width="10%" scope=col>生效日期</TH>
                          <TH width="10%" scope=col>截止日期</TH>
                          <TH width="8%" scope=col>失效状态</TH>
						  </TR>
					<s:iterator value="setMealList">	
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                              <img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onclick="javascript:detail('${ssmsmid}')">
                          </TD>
                          <TD height="26">${ssmsmtitle}</TD>
                          <TD>
                              <c:choose>
                                  <c:when test="${ssmsmclassify eq '1'}">框镜销售</c:when>
                                  <c:when test="${ssmsmclassify eq '3'}">隐形销售</c:when>
                                  <c:when test="${ssmsmclassify eq '5'}">辅料销售</c:when>
                              </c:choose>
                          </TD>
                          <TD>${ssmsmisdiscount == '0' ? '不允许':'允许'}</TD>
                          <TD>${ssmsmcreatedate}</TD>
                          <TD>${ssmsmeffectivedate}</TD>
                          <TD>${ssmsmenddate}</TD>
                          <TD>
                              <c:choose>
                                  <c:when test="${ssmsmisenabled eq '1'}">未失效</c:when>
                                  <c:when test="${ssmsmisenabled eq '0'}">已失效</c:when>
                              </c:choose>
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