<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>外帐处理</title>
</head>
<script>

	$(document).ready(function(){
		$("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });		
	});
	
	function autoCostAccount(){
        if ('${fquartzSwitchPo.fqswzhzstd}' == '2'){
            alert('当前系统是外帐系统，暂不能使用该功能!');
            return;
        }
		
	    if(confirm('是否确定传递配镜单?')){
	    	if(checkForm(calForm)){
		        calForm.action="insertSalesGutiarFlysheet.action?moduleID=${moduleID}";
		        calForm.submit();
		        showLoadingBar();
		    }
	    }
	}

	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
	}
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<form method="post" name="calForm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="9%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;财务管理</TD>
           <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：传递配镜单</TD>
        </TR>
        <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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

                    <TABLE id="searchBar" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                           <TD width="9%" height="26" class="table_body">传递日期</TD>
			               <TD class="table_none">
	                            <li class="horizontal_onlyRight">
		                           <input id="startTime"
							       name="startTime" 
							       type="text" class="text_input80" clean=clean  
							       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择起始日期！'}]"/> 至 
							       
							       <input id="endTime" clean=clean 
							       name="endTime" 
							       type="text" class="text_input80" 
							       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择截止日期！'}]"/> 
						       </li>
						       <li class="horizontal_onlyRight">
								   <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('startTime','endTime')">
							   </li>
						   </TD>
						</TR>
                        <TR>
                          <TD align="left" colspan="2">

                              <p>
                              <li class="horizontal_onlyRight">
                                <img btn=btn id="btn1" src="${ctx }/img/newbtn/btn_cdpjd_0.png" title='传递配镜单' onclick="autoCostAccount()">
                              </li>
                              <li class="horizontal_onlyRight">  
                                <strong><label style="color: red">*提示:单击此按钮后,将所选日期内结款、补齐、退款的配镜单向掰轨系统传递!</label></strong>
                              </li>				 
                              </p>
                                                           
                              </TD></TR>
                      </TBODY>
                    </TABLE>
                    <!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>