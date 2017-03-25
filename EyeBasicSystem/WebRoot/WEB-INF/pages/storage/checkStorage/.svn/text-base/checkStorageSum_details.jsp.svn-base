<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盘点管理</title>
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
	  	checkStorageForm.action=link;
	  	checkStorageForm.submit();
	}
	
    function storageykSel(id,stockid){
    	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCheckStorageykSel.action?hid="+id+"&stockid="+stockid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCheckStorageykSel.action?hid="+id+"&stockid="+stockid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【盘盈盘亏查询】";
    }
    function storagefxSel(id,stockid){
        var checkStoragefxCount=document.all.checkStoragefxCount.value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
        if(checkStoragefxCount=='0'){
			if(is_iPad()){
				showPopWin("initCheckStoragefxInsert.action?hid="+id+"&stockid="+stockid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initCheckStoragefxInsert.action?hid="+id+"&stockid="+stockid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
        }else{
            if(is_iPad()){
				showPopWin("checkStoragefxSel.action?hid="+id+"&stockid="+stockid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("checkStoragefxSel.action?hid="+id+"&stockid="+stockid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
        }
    	document.getElementById('popupTitle').innerHTML="【赢亏分析】";
    }
    
function showLoadingBar()
{
}
						
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="checkStorageForm" method="post" action="" >
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="checkStoragefxCount" name="checkStoragefxCount" value="${requestScope.checkStoragefxCount}"> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD align="right" colspan="3">
          	<img src="${ctx }/img/newbtn/btn_sciscoselect_0.png" btn=btn title="盘盈盘亏查询" onClick="storageykSel('${checkStoragePo.cshcsbillid }','${checkStoragePo.cshcsstockid }');">
          	<img src="${ctx }/img/newbtn/btn_scoanalyse_0.png" btn=btn title="盈亏分析表" onClick="storagefxSel('${checkStoragePo.cshcsbillid }','${checkStoragePo.cshcsstockid }');">
            <s:action name="getFittingTemplateTypeInfo" executeResult="true">
	            <s:param name="actionTypeID">17</s:param>
	            <s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
	            <s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&billId=${checkStoragePo.cshcsbillid}</s:param>
	            <s:param name="actionReportingServiceRequestString"></s:param>
	            <s:param name="actionReportTitle">盘点单打印</s:param>
            </s:action>  
          </TD>
        </TR>
       </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body" height="26">单据编号</TD>
                          <TD width="24%" class="table_none">&nbsp;${checkStoragePo.cshcsbillid }</TD>
                          <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">&nbsp;${fn:substring(checkStoragePo.cshcscheckdate,0,16)}</TD>
                          <TD width="9%" class="table_body">盘点单名称</TD>
						  <TD height="26" align="left" class="table_none">&nbsp;${checkStoragePo.cshcscheckname }</TD>
      	                </TR>
                        <TR> 
                          <TD class="table_body">盘点仓位</TD>
						  <TD height="26" align="left" class="table_none">&nbsp;${checkStoragePo.cshcsstockname }</TD>
                          <TD class="table_body" height="26">盘点人</TD> 
                          <TD class="table_none">&nbsp;${checkStoragePo.cshcscheckstockpersonname }</TD>
                          <TD class="table_body" height="26">盘点类型</TD> 
                          <TD class="table_none">
     	                	<c:choose>
     	                		<c:when test="${checkStoragePo.cshccategoryname eq '' || checkStoragePo.cshccategoryname eq null}">
     	                		&nbsp;不限定商品类别
								</c:when>
								<c:otherwise>
								&nbsp;${checkStoragePo.cshccategoryname}
								</c:otherwise>
							</c:choose>                          
                          </TD>                          
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${not empty(checkStorageEntrys)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH height="26" width="10%" scope=col>商品代码</TH>
                          <TH  width="20%" scope=col>商品条码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
						  <TH width="8%">规格型号</TH>
                          <TH width="5%">单位</TH>
                          <TH width="6%" scope=col>帐存数量</TH>
                          <TH width="6%" scope=col>实盘数量</TH>
						  <TH width="6%" scope=col>盈余数量</TH>
                        </TR>
                        <c:set value="0" var="booknumber" scope="page" />
                        <c:set value="0" var="checknumber" scope="page" />
                        <c:set value="0" var="surplusnumber" scope="page" />
                        
                        <c:forEach var="po" items="${checkStorageEntrys}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26">${po.cshcsegoodsid }</TD>
                          <TD height="26">${po.cshcsebarcode }</TD>
						  <td>${po.cshcsegoodsname }</td>
                          <TD>${po.cshcsespec }</TD>
						  <td>${po.cshcseunitname }</td>
                          <TD>${po.cshcsebooknumber }<c:set value="${booknumber +  po.cshcsebooknumber}" var="booknumber" scope="page" /></TD>
                          <TD>${po.cshcsechecknumber }<c:set value="${checknumber +  po.cshcsechecknumber}" var="checknumber" scope="page" /></TD>
                          <TD><font color="${po.cshcsesurplusnumber == '0' ? '' : 'red'}">${po.cshcsesurplusnumber }</font><c:set value="${surplusnumber +  po.cshcsesurplusnumber}" var="surplusnumber" scope="page" /></TD>
                        </TR>
                        </c:forEach>
                        <TR class=table_title align=middle>
                          <TH height="26" width="10%" scope=col></TH>
                          <TH width="20%" scope=col></TH>
                          <TH width="20%" scope=col></TH>
						  <TH width="8%"></TH>
                          <TH width="8%">合计:</TH>
                          <TH width="5%" scope=col>${booknumber }</TH>
                          <TH width="5%" scope=col>${checknumber }</TH>
						  <TH width="5%" scope=col>${surplusnumber }</TH>
                        </TR>
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
