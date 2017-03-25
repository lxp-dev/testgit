<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品种维护</title>
</head>
<script>
	//导出会员信息
	function exportCashCoupon(){
		customerInfoForm.action="exportCustomerInfo.action";
	    customerInfoForm.submit();	
	}

    function closeFrm(){
        if ('${inputStream}' != ''){
        	parent.hidePopWin();
        }
        alert('${inputStream}' != '');
        setTimeout(closeFrm,1000);
    }
	
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="customerInfoForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<input type="hidden" name="memberid" value="${customerInfoPo.smecimemberid}">
<input type="hidden" name="name" value="${customerInfoPo.smeciname}">
<input type="hidden" name="phone" value="${customerInfoPo.smeciphone}">
<input type="hidden" name="sex" value="${customerInfoPo.smecisex}">
<input type="hidden" name="agemin" value="${customerInfoPo.smeciagemin}">
<input type="hidden" name="agemax" value="${customerInfoPo.smeciagemax}">
<input type="hidden" name="departmentid" value="${customerInfoPo.smecishopcode}">
<input type="hidden" name="startTime" value="${customerInfoPo.starttime}">
<input type="hidden" name="endTime" value="${customerInfoPo.endtime}">
<input type="hidden" name="startTime1" value="${customerInfoPo.starttimes}">

<input type="hidden" name="endTime1" value="${customerInfoPo.endtimes}">
<input type="hidden" name="integralmin" value="${customerInfoPo.integralmin}">
<input type="hidden" name="integralmax" value="${customerInfoPo.integralmax}">
<input type="hidden" name="numbermin" value="${customerInfoPo.numbermin}">
<input type="hidden" name="numbermax" value="${customerInfoPo.numbermax}">
<input type="hidden" name="pricemin" value="${customerInfoPo.pricemin}">
<input type="hidden" name="pricemax" value="${customerInfoPo.pricemax}">
<input type="hidden" name="allpricemin" value="${customerInfoPo.allpricemin}">
<input type="hidden" name="allpricemax" value="${customerInfoPo.allpricemax}">
<input type="hidden" name="selbspsuppliername" value="${customerInfoPo.selbspsuppliername}">

<input type="hidden" name="selcstpsupplierid" value="${customerInfoPo.selcstpsupplierid}">
<input type="hidden" name="brandName" value="${customerInfoPo.brandName}">
<input type="hidden" name="brandID" value="${customerInfoPo.brandID}">
<input type="hidden" name="goodsname" value="${customerInfoPo.goodsname}">
<input type="hidden" name="goodsid" value="${customerInfoPo.goodsid}">
<input type="hidden" name="technologyTypeID" value="${customerInfoPo.technologytypeid}">
<input type="hidden" name="bbdframematerialtype" value="${customerInfoPo.bbdframematerialtype}">
<input type="hidden" name="bbdmaterialclass" value="${customerInfoPo.bbdmaterialclass}">
<input type="hidden" name="bbdrefractive" value="${customerInfoPo.bbdrefractive}">
<input type="hidden" name="bbdluminosityclass" value="${customerInfoPo.bbdluminosityclass}">

<input type="hidden" name="bbdfunctionclass" value="${customerInfoPo.bbdfunctionclass}">
<input type="hidden" name="bbdusetype" value="${customerInfoPo.bbdusetype}">
<input type="hidden" name="bbdstealthclass" value="${customerInfoPo.bbdstealthclass}">
<input type="hidden" name="phoneflag" value="${customerInfoPo.phoneflag}">
<input type="hidden" name="work" value="${customerInfoPo.smeciwork}">
<input type="hidden" name="memberoRigin" value="${customerInfoPo.smecimemberorigin}">
<input type="hidden" name="cardtype" value="${customerInfoPo.smecicardtype}">
<input type="hidden" name="interestpolists" value="${customerInfoPo.smeciinterest}">

<input type="hidden" name="srStartTime" value="${customerInfoPo.srStartTime}">
<input type="hidden" name="srEndTime" value="${customerInfoPo.srEndTime}">
<input type="hidden" name="customerenable" value="${customerInfoPo.smeciflag}">
<input type="hidden" name="salestypeid" value="${customerInfoPo.salestype}">
<input type="hidden" name="persontype" value="${customerInfoPo.smecipersontype}">
<input type="hidden" name="openid" value="${customerInfoPo.smeciopenid}">

<input type="hidden" name="salsepersonname" value="${customerInfoPo.salsepersonname}">
<input type="hidden" name="huifangcishu" value="${customerInfoPo.huifangcishu}">
<input type="hidden" name="address" value="${customerInfoPo.smeciaddress}">
<input type="hidden" name="hyremark" value="${customerInfoPo.smeciremark}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="10"><td></td></tr>
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
						   <TD width="10%" height="30">此查询条件有会员共 ${count }人，确认导出会员信息吗?</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx }/img/newbtn/btn_define_0.png" btn=btn id="submitButton" title='确定' onClick="javascript:exportCashCoupon()">&nbsp;
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