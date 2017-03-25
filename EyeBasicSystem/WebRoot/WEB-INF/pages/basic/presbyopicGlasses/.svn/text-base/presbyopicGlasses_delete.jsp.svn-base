<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老花镜维护</title>
</head>
<script>
	function del(){
		var num = ${num};
		if(num==0){
			$("img").removeAttr("onclick");
			presbyopicGlassesForm.action = "deletePresbyopicGlasses.action";
			presbyopicGlassesForm.submit();
		}else{
			alert("该商品库存数量不为0，删除失败！");
			return;
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
<style type="text/css">
<!--
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
-->
</style>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="presbyopicGlassesForm" method="post" action="">
<input type="hidden" name="hid" value="${goodsInfoPo.bgigoodsid}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}">
<input type="hidden" name="parent" id="parent" value="${parent}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 id="title1">
                      <TBODY>
                      	<TR>
						   <TD height="30">商品代码：${goodsInfoPo.bgigoodsid}</TD>
                        </TR>
                        <TR>
						   <TD height="30">商品名称：${goodsInfoPo.bgigoodsname}</TD>
                        </TR>
                        <TR>
						   <TD height="30">此条数据确认删除么?&nbsp;&nbsp;
						  
						   <img id="submitButton" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="javascript:del();">
						   </TD>
                        </TR>
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
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>