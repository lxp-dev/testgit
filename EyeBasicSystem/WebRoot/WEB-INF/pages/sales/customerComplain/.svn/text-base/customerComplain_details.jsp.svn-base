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
		if(checkForm($("#customerComplainForm"))){ 
			/*if($('#ssetmlinksalesid').val()==''){
				alert("请选择对应销售单！");
				return;
			}
		
			if($('#ssetmcustomername').val()==''){
				alert("会员姓名不能为空！");
				$('#ssetmcustomername').focus();
				return;
			}
			
			if($('#ssetmcustomerphone').val()==''){
				alert("会员联系电话不能为空！");
				$('#ssetmcustomerphone').focus();
				return;
			}
			
			if($('#ssetmmaiiladdress').val()==''){
				alert("邮寄地址不能为空！");
				$('#ssetmmaiiladdress').focus();
				return;
			}
	
			if($('#ssetmmaiilaudit').is(":checked")){
				if($('#ssetmmailcompanyname').val()==''){
					alert("快递公司名称不能为空！");
					$('#ssetmmailcompanyname').focus();
					return;
				}
				
				if($('#ssetmmailid').val()==''){
					alert("快递单号不能为空！");
					$('#ssetmmailid').focus();
					return;
				}
				
				if($('#ssetmsenddate').val()==''){
					alert("邮寄时间不能为空！");
					$('#ssetmsenddate').focus();
					return;
				}
				
			}*/
			customerComplainForm.action = "handleCustomerComplain.action";
			customerComplainForm.submit();
		}
	}
 
	function clean(){
	    document.getElementById('ssetmmailid').value = "";
		document.getElementById('ssetmmemberid').value = "";
		document.getElementById('ssetmcustomername').value = "";
		document.getElementById('ssetmcustomerphone').value = "";
		document.getElementById('ssetmmailcompanyname').value = "";
		document.getElementById('ssetmsenddate').value = "";
		document.getElementById('ssetmlinksalesid').value = "";
		document.getElementById('ssetmmaiiladdress').value = "";
		$('#ssetmmaiilaudit').attr('checked','');
	}	
	function permissionMessage(){
        alert('您无此操作权限');
	}
 
    /**
	 *聚焦
	 */
	window.onload=function(){
		
	}
	
	function setCustomer(memberid ,cname, cphone){
		$('#customername').val(cname);
		$('#phone').val(cphone);
		$('#smecccustomermemberid').val(memberid);
	}
	
	function getTadayDate(){
		var myDate = new Date();
		myDate.getFullYear();    //获取完整的年份(4位,1970-????)
		myDate.getMonth();       //获取当前月份(0-11,0代表1月)
		myDate.getDate();        //获取当前日(1-31)
		myDate.getHours();       //获取当前小时数(0-23)
		myDate.getMinutes();     //获取当前分钟数(0-59)
		
		var dateString='';
		dateString=myDate.getFullYear();
		
		if(myDate.getMonth()<10){
			dateString=dateString+'-0'+(myDate.getMonth()+1);
		}else{
			dateString=dateString+'-'+(myDate.getMonth()+1);
		}
		
		if(myDate.getDate()<10){
			dateString=dateString+'-0'+myDate.getDate();
		}else{
			dateString=dateString+'-'+myDate.getDate();
		}
		
		if(myDate.getHours()<10){
			dateString=dateString+' 0'+myDate.getHours();
		}else{
			dateString=dateString+' '+myDate.getHours();
		}
		
		if(myDate.getMinutes()<10){
			dateString=dateString+':0'+myDate.getMinutes();
		}else{
			dateString=dateString+':'+myDate.getMinutes();
		}
		
		$('#taday1').val(dateString);
	}
	
	function getTadayDate1(){
		var myDate = new Date();
		myDate.getFullYear();    //获取完整的年份(4位,1970-????)
		myDate.getMonth();       //获取当前月份(0-11,0代表1月)
		myDate.getDate();        //获取当前日(1-31)
		myDate.getHours();       //获取当前小时数(0-23)
		myDate.getMinutes();     //获取当前分钟数(0-59)
		
		var dateString='';
		dateString=myDate.getFullYear();
		
		if(myDate.getMonth()<10){
			dateString=dateString+'-0'+(myDate.getMonth()+1);
		}else{
			dateString=dateString+'-'+(myDate.getMonth()+1);
		}
		
		if(myDate.getDate()<10){
			dateString=dateString+'-0'+myDate.getDate();
		}else{
			dateString=dateString+'-'+myDate.getDate();
		}
		
		if(myDate.getHours()<10){
			dateString=dateString+' 0'+myDate.getHours();
		}else{
			dateString=dateString+' '+myDate.getHours();
		}
		
		if(myDate.getMinutes()<10){
			dateString=dateString+':0'+myDate.getMinutes();
		}else{
			dateString=dateString+':'+myDate.getMinutes();
		}
		
		$('#taday2').val(dateString);
	}
	
	function show(){
		if($('#handletype').attr('checked')){
			$('#showtr1').show();
		}else{
			$('#showtr1').hide();
		}
	}
	
	function selCustomerInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
    }
</script>
<body>
<form name="customerComplainForm" id="customerComplainForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }">
<input type="hidden" name="customerComplainPo.smechcustomercomplainid" value="${customerComplainPo.smeccuuid }">

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
                          <TD width="8%" height="26" class="table_body">投诉单号</TD>
					  	  <TD width="20%" class="table_none">
					  	  	${customerComplainPo.smeccuuid }
					  	  </TD>
					  	  <TD height="26" class="table_body">投诉类型</TD>
                    	  <TD class="table_none">
                             	<c:if test="${not empty(complaintsTypeList)}">
				               	  <s:iterator value="complaintsTypeList">
				               	  	<c:if test="${customerComplainPo.smecccomplaintype == bctid}">
                    	           		${bctname}
                    	          	</c:if>
                    	          </s:iterator>
                    	        </c:if>
                    	  </TD>
                    	  <TD height="26" class="table_body">投诉日期</TD>
                    	  <TD class="table_none">
                    	  	${fn:substring(customerComplainPo.smeccregisterdate,0,16) }
                    	  </TD>
					  	</TR>
					  	<TR>
                          <TD width="8%" height="26" class="table_body">会员卡号</TD>
					  	  <TD width="20%" class="table_none">
					  	  	${customerComplainPo.smecccustomermemberid }
					  	  </TD>
					  	  <TD width="8%" height="26" class="table_body">会员姓名</TD>
                    	  <TD width="20%" class="table_none">${customerComplainPo.smecccustomername }</TD>
                    	  <TD width="8%" height="26" class="table_body">会员电话</TD>
                    	  <TD class="table_none">${customerComplainPo.smecccustomerphone }</TD>
					  	</TR>
                    	<TR>
                    	  <TD height="26" class="table_body">配镜单</TD>
                    	  <TD class="table_none">
                    	  	${customerComplainPo.smecclinksalesid }
			              </TD>			              
                    	  <TD height="26" class="table_body">记录人</TD>
                    	  <TD class="table_none">
                    	  	${customerComplainPo.smeccregisterpersonname }
			              </TD>
			              <TD height="26" class="table_body">预计处理日期</TD>
                    	  <TD class="table_none">
                    	  	${customerComplainPo.smeccintendhandledate }
                    	  </TD>
                    	</TR>					  
                        <TR>
                          <TD height="26" class="table_body">投诉内容</TD>
                          <TD class="table_none" colspan="5" height="60">
                            ${customerComplainPo.smecccomplaincontent }
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    
                    <s:iterator value="customerComplainPos">
                    	<br/>
                    	<table border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" cellspacing="2" width="100%">
	                       <TBODY>
	                        <TR>
	                    	  <TD width="8%" height="26" class="table_body">处理状态</TD>
	                    	  <TD width="20%" class="table_none">
	                    	  	<c:if test="${smechhandlestate == '1' }">
	                    	  		处理中
	                    	  	</c:if>
	                    	  	<c:if test="${smechhandlestate == '2' }">
	                    	  		已处理
	                    	  	</c:if>
	                    	  </TD>
	                    	  <TD width="8%" height="26" class="table_body">处理人</TD>
	                    	  <TD class="table_none">
	                    	  	${smechhandlepersonname }
	                    	  </TD>
	                    	  <TD width="8%" height="26" class="table_body">处理时间</TD>
	                    	  <TD class="table_none">
	                    	  	${fn:substring(smechhandledate,0,16) }
	                    	  </TD>
	                    	</TR>
	                    	<TR>
	                          <TD height="26" class="table_body">处理结果</TD>
	                          <TD class="table_none" colspan="5" height="60">
	                            ${smechhandlecontent }
	                          </TD>
	                        </TR>
	                       </TBODY>
	                    </table>
                    </s:iterator>
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

