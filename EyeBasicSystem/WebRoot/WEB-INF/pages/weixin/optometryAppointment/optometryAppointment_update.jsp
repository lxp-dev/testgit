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
<title>预约管理</title>
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

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerInfoForm.action=link;
	  	customerInfoForm.submit();
	}

	function save(){
		if(checkForm(document.all.optometryAppointmentForm)){ 		
			optometryAppointmentForm.action = "updateWeiXinOptometryAppointmentPo.action";
			optometryAppointmentForm.submit();
		}
	}
</script>
<body>
<form name="optometryAppointmentForm" id="optometryAppointmentForm" method="post" action="">
<input type="hidden" name="weiXinOptometryAppointmentPo.woaid" value="${weiXinOptometryAppointmentPo.woaid}">
<input type="hidden" name="weiXinOptometryAppointmentPo.woaaccount" value="${weiXinOptometryAppointmentPo.woaaccount}">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }">

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
					      <TD width="30%" height="30" align="right" class="table_body">联系人&nbsp;&nbsp;</TD>
					      <TD align="left" class="table_none">${weiXinOptometryAppointmentPo.woaname}</TD>
				      	</TR> 
					    <TR>
					      <TD width="30%" height="30" align="right" class="table_body">联系手机&nbsp;&nbsp;</TD>
					      <TD align="left" class="table_none">${weiXinOptometryAppointmentPo.woamobilephone}</TD>
				      	</TR>  
					    <TR>
					      <TD width="30%" height="30" align="right" class="table_body">网点预约&nbsp;&nbsp;</TD>
					      <TD align="left" class="table_none">
							<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
								<c:if test="${optionParamPoTmp.fopparentid=='weixin_diyu' && (optionParamPoTmp.fopparamid==weiXinOptometryAppointmentPo.woadiyu)}">
									${optionParamPoTmp.fopparamname}
								</c:if>	                                      	
							</c:forEach>
						  </TD>
				      	</TR>
					    <TR>
					      <TD width="30%" height="30" align="right" class="table_body">&nbsp;</TD>
					      <TD align="left" class="table_none">
							<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
								<c:if test="${optionParamPoTmp.fopparentid=='weixin_wangdian' && (optionParamPoTmp.fopparamid==weiXinOptometryAppointmentPo.woawangdian)}">
									${optionParamPoTmp.fopparamname}
								</c:if>	                                      	
							</c:forEach>	
						  </TD>
				      	</TR> 
					    <TR>
					      <TD width="30%" height="30" align="right" class="table_body">诊疗项目&nbsp;&nbsp;</TD>
					      <TD align="left" class="table_none">
							<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
								<c:if test="${(optionParamPoTmp.fopparentid=='weixin_zhenliao') && (optionParamPoTmp.fopparamid==weiXinOptometryAppointmentPo.woazhenliao)}">
									${optionParamPoTmp.fopparamname}
								</c:if>	                                      	
							</c:forEach>	      
						  </TD>
				      	</TR>
					    <TR>
					      <TD width="30%" height="30" align="right" class="table_body">预约专家&nbsp;&nbsp;</TD>
					      <TD align="left" class="table_none">
							${weiXinOptometryAppointmentPo.woadoctorname}	      
						  </TD>
				      	</TR>				      	
					    <TR>
					      <TD width="30%" height="30" align="right" class="table_body">预约日期&nbsp;&nbsp;</TD>
					      <TD align="left" class="table_none">
							${fn:substring(weiXinOptometryAppointmentPo.woadatetime, 0, 10) }
							<c:if test="${!empty weiXinOptometryAppointmentPo.woahour}">${weiXinOptometryAppointmentPo.woahour}点</c:if><c:if test="${!empty weiXinOptometryAppointmentPo.woaminute}">${weiXinOptometryAppointmentPo.woaminute}分</c:if>
						  </TD>
				      	</TR> 
					    <TR>
					      <TD width="30%" height="30" align="right" class="table_body">预约需求&nbsp;&nbsp;</TD>
					      <TD align="left" class="table_none">${weiXinOptometryAppointmentPo.woacontent}</TD>
				      	</TR>					  	                   						  
                        <TR>
                          <TD height="26" align="right" class="table_body">预约回复</TD>
                          <TD class="table_none" height="60">
                            <textarea rows="3" style="width:50%" id="woaconfirmcontent" name="weiXinOptometryAppointmentPo.woaconfirmcontent" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [201]}, 'Message' : '确认结果不能大于200字！'}]">${weiXinOptometryAppointmentPo.woaconfirmcontent}</textarea>
                          </TD>
                        </TR>
                        <TR>
                          <TD height="26" align="right" class="table_body">预约状态</TD>
                          <TD class="table_none" height="60">
                           	<select name="weiXinOptometryAppointmentPo.woaisconfirm">
                           		<option value="0" ${(weiXinOptometryAppointmentPo.woaisconfirm == '0')? 'selected="selected"':''}>处理中</option>
                           		<option value="1" ${(weiXinOptometryAppointmentPo.woaisconfirm == '1')? 'selected="selected"':''}>预约成功</option>
                           		<option value="2" ${(weiXinOptometryAppointmentPo.woaisconfirm == '2')? 'selected="selected"':''}>预约失败</option>
                           	</select>
                          </TD>
                        </TR>                        
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()" >
							</td>
						</tr>
					</table>
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