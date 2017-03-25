<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css"> 
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>积分赠送管理</title>
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
</script>
<body>
<form name="customerComplainForm" id="customerComplainForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${moduleID }">

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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
                          <TD width="8%" height="26" class="table_body">会员卡号</TD>
					  	  <TD width="24%" class="table_none">
					  	  <li class="horizontal_onlyRight">
					  	  	${integralAddandSubPo.smeasmemberid }
					  	  </TD>
					  	  <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                    	  <TD width="24%" class="table_none">${integralAddandSubPo.smeascustomername }</TD>
                    	  <TD width="8%" height="26" class="table_body">顾客电话</TD>
                    	  <TD class="table_none">${integralAddandSubPo.smeascustomerphone }</TD>
					  	</TR>
                    	<TR>
                    	  <TD width="8%" height="26" class="table_body">赠送前积分</TD>
                    	  <TD class="table_none">
                    	  	${integralAddandSubPo.smeasyintegral }
                    	  </TD>
			              <TD height="26" class="table_body">赠送积分</TD>
                    	  <TD class="table_none">
                    	  	${integralAddandSubPo.smeascintegral }
                    	  </TD>
                    	  <TD height="26" class="table_body">赠送后积分</TD>
                    	  <TD class="table_none">
                    	  	${integralAddandSubPo.smeasxintegral }
                    	  </TD>
                    	</TR>
                    	<TR>
                    	  <TD width="8%" height="26" class="table_body">操作人</TD>
                    	  <TD class="table_none">
                    	  	${integralAddandSubPo.smeasdopersonname}
                    	  </TD>
			              <TD height="26" class="table_body">操作时间</TD>
                    	  <TD class="table_none" colspan="3">
                    	  	${fn:substring(integralAddandSubPo.smeasdodate,0,16)}
                    	  </TD>
                        </TR>
                    	<TR>
                          <TD height="26" class="table_body">备注</TD>
                          <TD class="table_none" colspan="5" height="60">
                            ${integralAddandSubPo.smeasremark }&nbsp;
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

