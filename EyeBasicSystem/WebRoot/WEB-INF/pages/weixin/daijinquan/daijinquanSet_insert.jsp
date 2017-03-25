<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代金券配置</title>
</head>

<script>
	
	function search(){
		$("img").removeAttr("onclick");
		daijinquanForm.action = "insertWeiDaijinquanSet.action";
		daijinquanForm.submit();
	}	
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		isShowAndHide();
		$('#wcprice').bind("keyup",function(){	
			$('#wcprice').val(
				$('#wcprice').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
	});
	function isShowAndHide(){
		var sw=$("input[type=radio]:checked").val();
		if(sw==1){
			$("#CARDPRICE").show();
		}
		if(sw!=1){
			$("#CARDPRICE").hide();
		}
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="daijinquanForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD colSpan=2 height=5></TD>
         </TR>
          </TBODY>
        </TABLE>
      <!-- ͷ˵ End --><!-- ѡ Start --><br/>
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
                     <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="40%" height="26" class="table_body">微信下载代金券开关</TD>
			               <TD  class="table_none">
                            <input type="radio" name="daijinquanPo.wcflag"  value="1" checked="checked" onclick="isShowAndHide();" ${daijinquanPo.wcflag == '1' ? 'checked="checked"' : '' }>开&nbsp;&nbsp;
                             <input type="radio" name="daijinquanPo.wcflag"  value="0" onclick="isShowAndHide();" ${daijinquanPo.wcflag == '0' ? 'checked="checked"' : '' }>关&nbsp;&nbsp;
			               </TD>
			               </TR>
			               <tr id="CARDPRICE">
			               
			               <TD height="26" class="table_body">代金券金额</TD>
			                <TD class="table_none" >
                            	<input class="text_input160" maxlength="20" type="text" id="wcprice" name="daijinquanPo.wcprice" value="${daijinquanPo.wcprice }">
			                </TD>
			               
                        </TR>
                       
                      </TBODY>
                    </table>
                    <TABLE id=title2 cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                              <img id="btnSearch" src="${ctx }/img/newbtn/btn_save_0.png" btn=btn title='保存' onClick="javascript:search()">
							</TD>
                        </TR>
                      </TBODY>
                    </TABLE>               
                  </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>