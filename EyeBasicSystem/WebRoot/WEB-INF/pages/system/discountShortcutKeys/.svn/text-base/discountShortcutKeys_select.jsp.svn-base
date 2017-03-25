<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/commons/printBarcode.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工打折券维护</title>
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
	  	additionalCostsForm.action=link;
	  	additionalCostsForm.submit();
	}
	
	function update(id){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateDiscountShortcutKeys.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateDiscountShortcutKeys.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工打折券更新】";
	}
	
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDeleteDiscountShortcutKeys.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteDiscountShortcutKeys.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工打折券删除】";
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertDiscountShortcutKeys.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertDiscountShortcutKeys.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工打折券新增】";
	}
	
	function enable(id,enable){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateDiscountShortcutKeysEnable.action?hid="+id+"&enable="+enable+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateDiscountShortcutKeysEnable.action?hid="+id+"&enable="+enable+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工打折券启用/停用】";
	}
	
	function isshow(id,ishow){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initUpdateDiscountShortcutKeysIsShow.action?hid="+id+"&ishow="+ishow+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initUpdateDiscountShortcutKeysIsShow.action?hid="+id+"&ishow="+ishow+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【员工打折券页面显示/隐藏】";
	}

	function print(barcode,discountNum){
		if(confirm("确认打印打折券吗？")){
			PrintDiscountNum(barcode,discountNum);
		}
	}
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="additionalCostsForm">
<input type="hidden" name="hid">
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
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>营销管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：员工打折券</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya == 1)}">
            		<img src="${ctx }/img/newbtn/btn_discountkeyinsert_0.png" btn=btn title="员工打折券新增" onclick="insert();"/>
            	</c:if>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
		                      <TBODY>
	                           <TR class=table_title align=middle>
	                              <TH width="12%" scope=col colspan="4">操作</TH>
	                              <TH width="25%" height="26" scope=col>打折券</TH>
		                          <TH height="26" scope=col>打折券名称</TH>
								  <th width="10%">折扣</th>	
								  <th width="10%">启用停用</th>							 
								  <th width="15%">销售页面是否显示快捷键</th>
		                        </TR>
		                        <c:if test="${not empty(discountShortcutKeysPolist)}">
		                        <c:forEach items="${discountShortcutKeysPolist}" var="item" varStatus="lineNum"> 
		                        	<TR height="26" class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			                          <TD width="3%">
			                          	<c:if test="${(permissionPo.keyc == 1)}">
			                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${item.fdkid }')">
			                          	</c:if>
			                          </TD>
		                          	<c:if test="${(item.fdkenable == 1)}">
		                          		<TD width="3%">
		                          			<c:if test="${(permissionPo.keye == 1)}">
		                          				<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='停用' onClick="enable('${item.fdkid }','0')">
		                          			</c:if>		
		                          		</TD>
		                          	</c:if>
		                          	
		                          	<c:if test="${(item.fdkenable == 0)}">
		                          		<TD width="3%">
		                          			<c:if test="${(permissionPo.keye == 1)}">
		                          				<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='启用' onClick="enable('${item.fdkid }','1')">
		                          			</c:if>		
		                          		</TD>
		                          	</c:if>		                          	
		                          	  <TD width="3%">
			                          	<c:if test="${(permissionPo.keyd == 1)}">
			                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${item.fdkid }')">
			                          	</c:if>
			                          </TD>
			                          <TD width="3%">
		                          		<img src="${ctx }/img/newbtn/print_0.png" btn=btn title='打印' onClick="print('${item.fdkdiscountcode }','${item.fdkkeyvalues }')">
			                          </TD>
		                          	  <TD>${item.fdkdiscountcode }</TD>
			                          <TD>${item.fdkkeyname }</TD>
									  <td>${item.fdkkeyvalues }</td>
									  <td>
										<c:choose>
											<c:when test="${item.fdkenable eq '1'}" >启用</c:when>
								  			<c:when test="${item.fdkenable ne '1'}" >停用</c:when>
										</c:choose>
									  </td>
									  <td>
										<c:choose>
											<c:when test="${item.fdkisshow eq '1'}" ><a href="#"  onClick="isshow('${item.fdkid }','1')">启用</a></c:when>
								  			<c:when test="${item.fdkisshow ne '1'}" ><a href="#"  onClick="isshow('${item.fdkid }','0')">停用</a></c:when>
										</c:choose>									  	
									  </td>									  
			                        </TR>
		                        </c:forEach>
		                        </c:if>
	                      </TBODY>
	                    </TABLE>
	                    <c:if test="${not empty(list)}">
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
    </BODY>
</html>