<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    </HEAD>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function changeNum(){
		if($("#ssesbpsalsvalue").val() > 0){
		}else{
			alert("请正确填写金额！");
			$("#ssesbpsalsvalue").val("");
			$("#ssesbpsalsvalue").focus();
			return;
		}
		
		if(parseFloat($("#ssesbpsalsvalue").val()) > parseFloat('${salesBasicPo.ssesbsalesvalue }')){
			$("#ssesbpsalsvalue").val('${salesBasicPo.ssesbsalesvalue }');
		}

		$("#ssesbpsalsvalue").val(parseFloat($("#ssesbpsalsvalue").val()).toFixed(2));
	}

	function save(memberid){
		$("img").removeAttr("onclick");
		guitarMangermentForm.action = "updateSalesValue.action";
		guitarMangermentForm.submit()
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="guitarMangermentForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="15px"><td></td></tr>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
				</TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif ><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px;" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <TABLE id=ctl00_PageBody_PostButton  cellSpacing=0 cellPadding=0 width="100%" border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
							<div align="right">
							  &nbsp;
							</div>
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                <TABLE width="100%" border=0 align=center cellpadding=0 cellspacing=1>
	        	<tr>
	        	<td class="qtCenterLine">
				<TABLE width="95%" align="center" cellpadding=0 cellspacing=1 class="privateTable privateBorder" id="jktable">
                      <TBODY>
                        <TR align=middle>
                          <TD width="40%" height="26px" class="table_body" align="right">销售单号</Td>
                          <TD width="60%" align="LEFT" class="table_none">${salesBasicPo.ssesbsalesid }<input type="hidden" name="ssesbsalesid" id="ssesbsalesid" value="${salesBasicPo.ssesbsalesid }"/></Td>
                        </TR>
                        <TR align=middle>
                          <TD width="40%" height="26px" class="table_body" align="right">应收金额</Td>
                          <TD width="60%" align="LEFT" class="table_none">${salesBasicPo.ssesbsalesvalue }<input type="hidden" name="ssesbsalesvalue" id="ssesbsalesvalue" value="${salesBasicPo.ssesbsalesvalue }"/></Td>
                        </TR>
                        <TR align=middle>
                          <TD width="40%" height="26px" class="table_body" align="right">实缴金额</Td>
                          <TD width="60%" align="LEFT" class="table_none"><input class="text_input160" name="ssesbpsalsvalue" id="ssesbpsalsvalue" value="${salesBasicPo.ssesbpsalsvalue }" onblur="changeNum()"/><input type="hidden" name="yssesbpsalsvalue" id="yssesbpsalsvalue" value="${salesBasicPo.ssesbpsalsvalue }"/></Td>
                        </TR>
                      </TBODY>
                    </TABLE>
	              </tr>
	              <tr>
	              	<td colspan="2" width="100%" align="center">
	              		<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
	              	</td>
	              </tr>
	              </TABLE>
	              
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif colspan="2"><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
