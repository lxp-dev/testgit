<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员高级管理</title>
</head>
<script>
	function del()
	{
		if(checkForm(document.all.postForm))
		{
			$("img").removeAttr("onclick");
			postForm.action = "insertCustomerInfoMessage.action";
			postForm.submit();
			showLoadingBar();
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
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="postForm">

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


<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table  width="100%"  border=0 align=center cellpadding=1 cellspacing=1 id="title0">
                      <TBODY>
                                          
	                        <TR>
	                          <TD height="26" class="table_body" width="20%">短信内容</TD>
	                          <TD class="table_none">                         
	                            <textarea name="content"  id="content"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '短信内容不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [200]}, 'Message' : '短信内容不能大于200字符'}]"></textarea>
	                          </TD>
	                        </TR>
                      <TR>
						   <TD width="95%" height="26" colspan="2">
						   
						   		此查询条件有手机号的会员共 ${count }人，是否确定发送短信？
						  
						  
						   </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id="title2" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx }/img/newbtn/btn_define_0.png" btn=btn id="submitButton" title='确定' onClick="javascript:del()">												                         
                          </TD>
						  </TR>
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
                	
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
