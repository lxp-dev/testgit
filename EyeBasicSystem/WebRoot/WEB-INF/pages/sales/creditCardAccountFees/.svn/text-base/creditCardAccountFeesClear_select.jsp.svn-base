<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银台管理</title>
</head>
<script>	
    /**
	 *聚焦
	 */
	window.onload=function(){
		document.getElementById('sseccardid').focus();  
	}
    /**
	 *回车事件
	 */
	function selectCustomer(){
		if(document.getElementById('sseccardid').value.trim() != ''){
			if(event.keyCode == 13)
				document.forms[0].submit();
	    }
	    $("img").removeAttr("onclick");
		creditCardAccountFeesForm.action = "selCreditCardAccountFeesClear.action";
    }
    
    /*会员卡清零*/
    function cleared(){
    	if(checkForm(document.all.creditCardAccountFeesForm)){
	    	//if(document.getElementById('sseccardid').value==''){
	    	//	alert('请输入检查充值卡号 ？');
	    	//	return;
	    	//}
	    	if(confirm("原卡内金额为${cardPo.ssecamount }元，是否清零 ？"))
			{
				  $("img").removeAttr("onclick");
				  creditCardAccountFeesForm.action = "creditCardAccountFeesClear.action";
			      creditCardAccountFeesForm.submit();
			}
		}
    }
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="creditCardAccountFeesForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台管理</TD>
            <TD class=menubar_readme_text vAlign=bottom></TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：检查充值卡清零</TD>
           <TD class=menubar_function_text align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--ťStart--> <c:if test="${permissionPo.keya=='1'}">
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      onclick="JavaScript:window.location.href='initCardAndRechargeRecordNew.action?moduleID=${ requestScope.moduleID}&customerID=${customerInfoPo.smecicustomerid }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">新建检查充值卡</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD></c:if> <c:if test="${permissionPo.keyb=='1'}">
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      onclick="JavaScript:window.location.href='initCreditCardAccountFeesSel.action?moduleID=${ requestScope.moduleID}&customerID=${customerInfoPo.smecicustomerid }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">检查充值卡充值</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD></c:if> <c:if test="${permissionPo.keyc=='1'}">
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">检查充值卡清零</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD></c:if> <c:if test="${permissionPo.keyd=='1'}">
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      onclick="JavaScript:window.location.href='initCreditCardAccountFeesRechargeUpCaed.action?moduleID=${ requestScope.moduleID}&customerID=${customerInfoPo.smecicustomerid }';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">检查充值卡补卡</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD></c:if>
					</TR></TBODY></TABLE></TD>
					
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
                    <TABLE width="100%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="Privateborder">
                      <TBODY>
                        <TR>
                          <TD width="12%" class="table_body " height="30" align="right">检查充值卡号</TD>
                          <TD width="22%" class="table_none ">
					               <input type="text" id="sseccardid" name="cardPo.sseccardid" class="text_input100" 
					                	value="${cardPo.sseccardid }" ${empty (readOnly) ? 'onkeyup="selectCustomer();" ' : 'readOnly="readOnly"'  }
					                	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入检查充值卡号！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '检查充值卡号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [12]}, 'Message' : '检查充值卡号不能超过11位！'}]" >
					               <input type="hidden" id="sseccustomerid" name="sseccustomerid" class="text_input100" value="${cardPo.sseccustomerid }">
					   </TR>
                        <TR>
                          <TD class="table_body " height="30" align="right">顾客姓名</TD>
                          <TD class="table_none ">${cardPo.ssecname }</TD>
                        </TR>
                        <TR>
                          <TD class="table_body " height="30" align="right">卡内金额</TD>
                          <TD class="table_none ">${cardPo.ssecamount }</TD>
                          <input type="hidden" id="ssecamount" name="ssecamount" class="text_input100" value="${cardPo.ssecamount }">
                        </TR>
 
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">
                            <input icon='icon-save' type='button' value='清零' onClick="cleared()">
                              &nbsp;&nbsp;</div></TD></TR>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
