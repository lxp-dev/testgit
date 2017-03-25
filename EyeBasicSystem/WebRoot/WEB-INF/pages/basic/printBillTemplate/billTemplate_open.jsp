<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息维护</title>
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

	function setBillTemplate(id,typeid){
		location.href="updateFittingTemplateType.action?moduleID=${requestScope.moduleID}&typeID="+typeid+"&id="+id;
	}

	function imgclick(src){
		var id = src.src;
		var width = $(src).attr("width2");
		var height = $(src).attr("height2");
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,600,300,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,900,500,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【模版预览--鼠标滚轮可以对图片进行放大和缩小】";
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form name="printBillTemplateForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="bftlogo" name="fittingTemplatePo.bftlogo">
<input type="hidden" id="bftfileurl" name="fittingTemplatePo.bftfileurl">

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
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
                        <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                        <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                      </TR>
                    </TBODY>
                  </TABLE>
             <table align="center" >   
		     <c:if test="${rowCount == ''}">
		        <c:set value="5" var="rowCount" />       <!-- 行数 -->
		     </c:if>
		     <c:if test="${rowCount != ''}">
		        <c:set value="${rowCount}" var="rowCount" />       <!-- 行数 -->
		     </c:if>
            
             <c:set value="4" var="columnCount" />    <!-- 列数 -->
             <c:set value="0" var="currentIndex" />   <!-- 索引变化量 -->
                     
              <c:forEach begin="1" end="${rowCount}" step="1" >
              <c:set value="1" var="currentCount" />   <!-- 当前行数 -->
                <tr style="padding-left: 90px;" >               
                  <c:forEach items="${fittingTemplateList}" var="fittingTemplateInfo" varStatus="status">
                    <c:if test="${status.index >= currentIndex && currentCount <= columnCount }" >
                   		<td width="220">
                        	<img src="${ctx}${fittingTemplateInfo.bftfileurl}" width="200" height="120" onclick="imgclick(this)" width2="600" height2="450" style="cursor: hand;">
                        	<input type="radio" name="bftid" value="${fittingTemplateInfo.bftid}" ${requestScope.id eq fittingTemplateInfo.bftid ? 'checked="checked"' : '' } onclick="setBillTemplate('${fittingTemplateInfo.bftid}','${fittingTemplateInfo.bfttype }')">
                        	<c:choose>
                        		<c:when test="${requestScope.id eq fittingTemplateInfo.bftid}"><b><font color="red">${fittingTemplateInfo.bfttemplatename}</font></b></c:when>
                        		<c:otherwise>${fittingTemplateInfo.bfttemplatename}</c:otherwise>
                        	</c:choose>&nbsp;                        	
                   		</td>
                    <c:set value="${currentCount + 1}" var="currentCount" />
                    </c:if>
                  </c:forEach>      
                  <c:set value="${currentIndex + 4}" var="currentIndex" />  
                </tr>
                <tr><td height="10">&nbsp;</td></tr>
               </c:forEach>       
            </table>
            
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
    <TD height=5></TD></TR></TBODY></TABLE>
    </form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>