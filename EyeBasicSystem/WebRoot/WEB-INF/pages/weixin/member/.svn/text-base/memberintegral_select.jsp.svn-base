<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${companyNamePo.fcnName }</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />

<script>
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });
</script>

</head>

<body class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<div class="title">积分查询</div>

<form name="memeberFrm" method="post" action="">
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
                      UNSELECTABLE="on">我的积分</TD>
                      
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                    
                    
                    
                    </TD>
                     <TD>
                     <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                  <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initWeiXinMemberIntegralSelLog.action?openID=${openID}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">积分流水</TD>
                      
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                      </TR></TBODY></TABLE></TD>
                    </TR></TBODY></TABLE>
<div class="jifen_left">
<span class="jifen_txt">当前积分为:${customerInfoPo.smeciintegral }<span class="font_txt">您已兑换的商品如下:</span>
</div>
<table width="100%" border="0" cellspacing="2" cellpadding="0">
  <tr>
    <th class="jifen_tit" bgcolor="#FFFFFF" height="26">兑换时间</th>
    <th class="jifen_tit" bgcolor="#FFFFFF">兑换商品</th>
    <th class="jifen_tit" bgcolor="#FFFFFF">状态</th>
  </tr>
  <s:iterator value="weiXinIntegralSelectList">
	  <tr>
	    <td align="center" bgcolor="#FFFFFF" height="26">${wiecreatdate }</td>
	    <td align="center" bgcolor="#FFFFFF">${wiegoodname }</td>
	    <td align="center" bgcolor="#FFFFFF"><c:if test="${wieflag eq '1' }">已领取</c:if><c:if test="${wieflag eq '0' }">未领取</c:if></td>
	  </tr>
  </s:iterator>
	 <c:if test="${not empty(weiXinIntegralSelectList)}">
		<div id="dividePage" align="center">        
			<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
		</div>
	 </c:if>	
</table>
<p>&nbsp;</p>
    </form>
</body>
</html>

