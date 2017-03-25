<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示处方数量维护 </title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 	
	
	function insert(){
		if(checkForm(document.all.companyNameForm)){			    
       		$("img").removeAttr("onclick");     		
			companyNameForm.action = "updateSalesRecipeNumView.action";
			companyNameForm.submit();
		}
		
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="companyNameForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%">
          <img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：显示处方数量维护  </TD>
          <td align="right" width="40%" valign="bottom"></td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
          </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                       <TR class="table_title" align=middle>
                          <TD height="26" width="20%">处方编号</TD>
				          <TD width="20%">处方名称</TD>
				          <TD height="26" width="20%">销售类型</TD>
						  <TD width="20%">显示数量</TD>
					   </TR> 
			           <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			              <TD height="26">1</TD>
                          <TD>远用</TD>
                          <TD>框镜</TD>
                          <TD>
                            <input class="text_input60"  id="salesRecipeNum1"  name="salesRecipeNumViewPo.brnnum1" maxlength="5" value="${salesRecipeNumViewPo.brnnum1}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写显示数量！'}]">
                          </TD>
					   </TR> 			           
			           <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			              <TD height="26">2</TD>
                          <TD>近用</TD>
                          <TD>框镜</TD>
                          <TD>
                            <input class="text_input60"  id="salesRecipeNum2"  name="salesRecipeNumViewPo.brnnum2" maxlength="5" value="${salesRecipeNumViewPo.brnnum2}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写显示数量！'}]">
                          </TD>
					   </TR> 
			           <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			              <TD height="26">3</TD>
                          <TD>渐进</TD>
                          <TD>框镜</TD>
                          <TD>
                            <input class="text_input60"  id="salesRecipeNum3"  name="salesRecipeNumViewPo.brnnum3" maxlength="5" value="${salesRecipeNumViewPo.brnnum3}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写显示数量！'}]">
                          </TD>
					   </TR> 
			           <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			              <TD height="26">4</TD>
                          <TD>隐形</TD>
                          <TD>隐形</TD>
                          <TD>
                            <input class="text_input60"  id="salesRecipeNum4"  name="salesRecipeNumViewPo.brnnum4" maxlength="5" value="${salesRecipeNumViewPo.brnnum4}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写显示数量！'}]">
                          </TD>
					   </TR> 			           
			           <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			              <TD height="26">5</TD>
                          <TD>中用</TD>
                          <TD>框镜</TD>
                          <TD>
                            <input class="text_input60"  id="salesRecipeNum5"  name="salesRecipeNumViewPo.brnnum5" maxlength="5" value="${salesRecipeNumViewPo.brnnum5}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写显示数量！'}]">
                          </TD>
					   </TR> 
			           <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			           	  <TD height="26">6</TD>
                          <TD>角膜塑型</TD>
                          <TD>隐形</TD>
                          <TD>
                            <input class="text_input60"  id="salesRecipeNum6"  name="salesRecipeNumViewPo.brnnum6" maxlength="5" value="${salesRecipeNumViewPo.brnnum6}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写显示数量！'}]">
                          </TD>
					   </TR> 
			           <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
			           	  <TD height="26">7</TD>
                          <TD>视觉训练</TD>
                          <TD>辅料</TD>			           
                          <TD>
                            <input class="text_input60" id="salesRecipeNum7"  name="salesRecipeNumViewPo.brnnum7" maxlength="5" value="${salesRecipeNumViewPo.brnnum7}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写显示数量！'}]">
                          </TD>
					   </TR> 					   					   					   
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="insert();">
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
