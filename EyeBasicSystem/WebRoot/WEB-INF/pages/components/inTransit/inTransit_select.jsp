<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在途状态配置</title>
<script> 
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function updateEnabled(flag,inTransitID,inTransitName){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initEnabledInTransit.action?inTransitID="+inTransitID + '&inTransitName='+EncodeUtf8(inTransitName)+"&moduleID=${requestScope.moduleID}&flag="+flag,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【在途状态启用/停用】";
	}

</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="inTransitFrm" id="inTransitFrm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD width="15%" class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统设置 </TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：在途状态点配置 </TD>
             <td align="right" width="40%" valign="bottom"></td>
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
		    <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx}/img/pic/tab_bg.gif></TD>					
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
		                      <TBODY>
		                        <TR class=table_title align=middle>
		                          <TH width="4%" scope=col>操作</TH>
		                          <TH width="15%" height="26" scope=col>编码</TH>
		                          <TH width="65%" scope=col>在途状态</TH>
		                          <TH height="26" scope=col>使用状态</TH>
		                        </TR>
						<c:if test="${permissionPo.keya==1}">		
							<s:iterator value="inTransitList">	
								<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			                      <TD>
			                      	<c:if test="${permissionPo.keyb==1}">
			                          <c:if test="${sseitflag == 0}">
				                          <c:if test="${sseitisflag == 1}">			                          
				                          	<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='启用' onclick="updateEnabled('1','${sseitstate}','${sseitintransitname}')">
				                          </c:if>
			                          </c:if>
			                          <c:if test="${sseitflag == 1}">
				                          <c:if test="${sseitisflag == 1}">			                          
				                          	<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='停用' onclick="updateEnabled('0','${sseitstate}','${sseitintransitname}')">
				                          </c:if>
			                          </c:if>
			                      	</c:if>
			                      </TD>
			                      <TD height="26">${sseitstate}</TD>
			                      <TD>${sseitintransitname}</TD>  
			                      <TD>
			                      <c:if test="${sseitisflag == 1}">
			                      	<c:if test="${sseitflag == 1}">			                          
				                      	启用
				                    </c:if>
				                    <c:if test="${sseitflag == 0}">			                          
				                      	停用
				                    </c:if>
				                  </c:if>
			                      </TD>
			                    </TR>
							</s:iterator>	
							 </c:if>	
								
		                        
	                      </TBODY>
	                    </TABLE>
 
					 
					 
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

