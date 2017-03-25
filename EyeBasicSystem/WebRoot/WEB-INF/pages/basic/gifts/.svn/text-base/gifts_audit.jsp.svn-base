<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赠品类修改</title>
</head>
<SCRIPT type="text/javascript">

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });
	}); 

	function save(){
		if(checkForm(giftsForm)){
			$("img").removeAttr("onclick");
			giftsForm.action = "giftsUpdate.action";
			giftsForm.submit();
		}
	}

</SCRIPT>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="giftsForm">
<input type="hidden" name="giftsPo.bgsuuid" value="${giftsPo.bgsuuid}">
<input type="hidden" name="giftsPo.bgsauditstate" value="1">
<input type="hidden" name="giftsPo.bdpisshow" value="${giftsPo.bdpisshow}">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>

                          <TD width="10%" class="table_body">赠品名称</TD>
                          <TD width="24%" class="table_none">${giftsPo.bgsgoodsname }&nbsp;
                          </TD>
                          <TD width="9%" class="table_body">商品代码</TD>
                          <TD width="24%" class="table_none">${giftsPo.bgsgoodsid }&nbsp;</TD>
                          <TD width="9%" class="table_body" height="26">赠品简称</TD>
                          <TD width="30%" class="table_none">
                             ${giftsPo.bgsviewname}<input type="checkbox" ${giftsPo.bdpisshow eq '1' ? 'checked="checked"' : '' } disabled="disabled">&nbsp;赠品简称显示在销售页面
                          </TD>
						  
                        </TR>
                         <TR>
                          <TD class="table_body" height="26">活动门店</TD>
                           <TD class="table_none" height="62" colspan="5">
							<textarea class="nottextarea" readonly="readonly">${giftsPo.bdpdepartmentname}</textarea>
							
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>

                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <img name="button1" id="button1" src="${ctx}/img/newbtn/btn_audit_0.png" btn=btn  title='审核' onclick="save();">               
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form>
</body>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>