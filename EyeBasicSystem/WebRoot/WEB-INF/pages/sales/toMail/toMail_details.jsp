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
<title>邮寄管理</title>
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
			
			if($('#ssetmmailid').val()==''){
				alert("快递单号不能为空！");
				$('#ssetmmailid').focus();
				return;
			}

		
		$("img").removeAttr("onclick");
		toMailForm.action = "toMailDetailsUpdate.action";
		toMailForm.submit();
	}
 
	function clean(){
		toMailForm.reset();
	}	
	function permissionMessage(){
        alert('您无此操作权限');
	}
	
	function setCustomer(ssetmlinksalesid ,ssetmcustomername, ssetmcustomerphone ,ssetmmemberid){
		$('#ssetmlinksalesid').val(ssetmlinksalesid);
		$('#ssetmcustomername').val(ssetmcustomername);
		$('#ssetmcustomerphone').val(ssetmcustomerphone);
		$('#ssetmmemberid').val(ssetmmemberid);
		
	}
	
	function show(){
		if($('#ssetmmaiilaudit').attr('checked')){
			$('#showtr1').attr('style','');
			$('#showtr2').attr('style','');
		}else{
			$('#showtr1').attr('style','display:none');
			$('#showtr2').attr('style','display:none');
		}
	}
</script>
<body>
<form name="toMailForm" method="post" action="">
<input type="hidden" name="toMailPo.ssetmuuid" value="${toMailPo.ssetmuuid }">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
		   <TD colspan="3" align="right">
		   <c:if test="${toMailPo.ssetmmaiilaudit == '1'}">
               	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
					<s:param name="actionTypeID">10</s:param>
               		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
               		<s:param name="actionFinereportRequestString">&ssetmuuid=${toMailPo.ssetmuuid}</s:param>
               		<s:param name="actionReportingServiceRequestString"></s:param>
               		<s:param name="actionReportTitle">邮寄单打印</s:param>             		
               	</s:action>		   
           </c:if>
           <c:if test="${toMailPo.ssetmmaiilaudit != '1'}">
          	&nbsp;
           </c:if>
          </TD>
        </TR>
       </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
                          <TD width="8%" height="26" class="table_body">配镜单号</TD>
					  	  <TD width="20%" class="table_none">${toMailPo.ssetmlinksalesid }
					  	  </TD>
					  	  <TD width="8%" height="26" class="table_body">会员卡号</TD>
					  	  <TD width="20%" class="table_none">${toMailPo.ssetmmemberid }</TD>
                    	  <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                    	  <TD class="table_none">${toMailPo.ssetmcustomername }</TD>
                  	  </TR>
                      <TR id="showtr1">
                          <TD width="8%" height="26" class="table_body">联系人</TD>
                    	  <TD class="table_none">${toMailPo.ssetmlinkman}</TD> 
                    	  <TD height="26" class="table_body">顾客区号</TD>
                    	  <TD class="table_none" >${toMailPo.ssetmareacode }</TD> 
                          <TD height="26" class="table_body">顾客电话</TD>
                    	  <TD class="table_none" >${toMailPo.ssetmcustomerphone }</TD>
                      </TR>
                      <TR id="showtr1">
                    	  <TD width="8%" height="26" class="table_body">邮寄单</TD>
                    	  <TD class="table_none" colspan="5">${toMailPo.ssetmtomaillistname}</TD>
                  	  </TR>
                    	<TR id="showtr2">
                 	      <TD height="26" class="table_body">快递公司</TD>
                    	  <TD class="table_none">${toMailPo.ssetmmailcompanyname}&nbsp;</TD>
                    	  <TD height="26" class="table_body">快递单号</TD>
                    	  <TD class="table_none"><input id="ssetmmailid" name="toMailPo.ssetmmailid" type="text" class="text_input160" value="${toMailPo.ssetmmailid }" maxlength="30"/>&nbsp;</TD>
                    	  <TD height="26" class="table_body">邮寄时间</TD>
                    	  <TD class="table_none" >
                   				${toMailPo.ssetmsenddate}&nbsp;
			               </TD>
 
                    	</TR>	
                        <TR>
                    	  <TD height="26" class="table_body">地址</TD>
                          <TD class="table_none" colspan="6" height="26">
                          	${toMailPo.ssetmprovinces }
                          	&nbsp;&nbsp;省&nbsp;&nbsp;
                          	${toMailPo.ssetmcity }
                          	&nbsp;&nbsp;市&nbsp;&nbsp;
                          	${toMailPo.ssetmdistrict }
                          	&nbsp;&nbsp;区（县）&nbsp;&nbsp;
                          	${toMailPo.ssetmstreet }
                            &nbsp;&nbsp;路（街）&nbsp;&nbsp;
                            ${toMailPo.ssetmmaiiladdress}
                          </TD>
                        </TR>					  
                        <c:if test="${toMailPo.ssetmissupport == '1'}">
                        <TR>
                    	  <TD height="26" class="table_body">保价</TD>
                    	  <TD class="table_none" colspan="5">
                    	    ${toMailPo.ssetmsupportvalue }&nbsp;元
                    	  </TD>
                  	    </TR>
                  	    </c:if>	
                      </TBODY>
                    </TABLE>
					 
                    <table id="title2" cellspacing="2">

						<tr height="10">
							<td>
								<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()" >
								<img src="${ctx }/img/newbtn/btn_reset_0.png" btn=btn title='重置'  onClick="clean()" >
							</td>
						</tr>
					</table>
                    
                        <!-- BEGIN 分页-->
                     
<!-- END 分页 -->
	               
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

