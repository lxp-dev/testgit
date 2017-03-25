<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML><HEAD><TITLE>菜单</TITLE>
<STYLE type=text/css>.ttl {
	CURSOR: pointer; COLOR: #ffffff; PADDING-TOP: 4px
}
A:active {
	COLOR: #000000; TEXT-DECORATION: none
}
A:hover {
	COLOR: #000000; TEXT-DECORATION: none
}
A:link {
	COLOR: #000000; TEXT-DECORATION: none
}
A:visited {
	COLOR: #000000; TEXT-DECORATION: none
}
TD {
	FONT-SIZE: 12px; FONT-FAMILY: "Verdana", "Arial", "细明体", "sans-serif"
}
.table_body {
	CURSOR: pointer; HEIGHT: 18px; BACKGROUND-COLOR: #edf1f8
}
.table_none {
	CURSOR: pointer; HEIGHT: 18px; BACKGROUND-COLOR: #ffffff
}
</STYLE>

<SCRIPT language=javascript>
	function showHide(obj){
	 var oStyle = document.getElementById(obj).style;
	 oStyle.display == "none" ? oStyle.display = "block" : oStyle.display = "none";
	}
</SCRIPT>
<SCRIPT language=javascript>
    var NowClickName="";
    
        function NowShow(TopMenuName,Url)
    {
        document.getElementById(TopMenuName).className  = "table_body";
        if (NowClickName!="" &&NowClickName!=TopMenuName)
            document.getElementById(NowClickName).className  = "table_none"; 
        NowClickName = TopMenuName;
        //var o=window.open(url); 
       window.parent.frames["mainFrame"].location=Url;
       //parment.mainFrame.src=Url;
    }
    
    function TDOverOROut(iname)
    {
        if (NowClickName!=iname)
        {

            document.getElementById(iname).className = "table_none";

        }
    }
        function TDOverORIn(iname)
    {
        if (NowClickName != iname)
        {
            document.getElementById(iname).className = "table_body";
        }
    }
</SCRIPT>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY bgColor=#9aadcd leftMargin=0 topMargin=0><BR>
<c:if test="${not empty(requestScope.sysModuleList)}">
	<c:forEach items="${requestScope.sysModuleList}" var="item" varStatus="lineNum">
	<c:if test="${item.moduleParentID=='0'}">
<TABLE cellSpacing=0 cellPadding=0 width=159 align=center border=0>
  <TBODY>
  <TR>
    <TD width=23><IMG height=25 src="${ctx}/img/sys/box_topleft.gif" width=23></TD>
    <TD class=ttl onClick="JavaScript:showHide('M_${item.moduleID}');" width=129 
    background=${ctx}/img/sys/box_topbg.gif>${item.moduleCname} </TD>
    <TD width=7><IMG height=25 src="${ctx}/img/sys/box_topright.gif" 
  width=7></TD></TR></TBODY></TABLE>
  
  <TABLE id=M_${item.moduleID} style="DISPLAY: none" cellSpacing=0 cellPadding=0 width=159 
align=center border=0>
  <TBODY>
  <TR>
  	<input type="hidden" id="lefttag" value="0"/>
    <TD width=159 background=box_bg.gif colSpan=3 height=0px>
      <TABLE cellSpacing=1 cellPadding=2 width=157 border=0>
        <TBODY>
        <c:forEach items="${item.moduleLowers}" var="itemLittle" varStatus="lineNumLittle">
        <c:if test="${itemLittle.moduleParentID==item.moduleID}">
        <TR>
          <TD class=table_none onMouseMove="javascript:TDOverORIn('M_${itemLittle.moduleID}');" 
          id=M_${itemLittle.moduleID} 
          onmouseout="javascript:TDOverOROut('M_${itemLittle.moduleID}');"><IMG height=7 hspace=5 
            src="${ctx}/img/sys/arrow.gif" width=5 align=bottom> <a href="${itemLittle.moduleDirectory}?moduleID=${itemLittle.moduleID }" target="mainFrame">${itemLittle.moduleCname}</a> </TD></TR>
            </c:if>
        </c:forEach>
        </TBODY></TABLE></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=159 align=center border=0>
  <TBODY>
  <TR>
    <TD colSpan=3><IMG height=10 src="${ctx}/img/sys/box_bottom.gif" 
  width=159></TD></TR></TBODY></TABLE>
  </c:if>
  </c:forEach>
  </c:if></BODY></HTML>
