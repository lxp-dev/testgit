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
<title>${companyNamePo.fcnName }</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />
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

    function insert(){
    	memeberFrm.action = "weiXinIntegralConvertView.action?openID=${openID}";
    	memeberFrm.submit();
    }
</script>
<body class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="memeberFrm" method="post" action="">
<br/><br/><br/><br/><br/>
<h2><img src="${ctx }/weixin/images/chenggong.png" width="32" height="32" />兑换成功<br />
请到${requestScope.dpo.bdpdepartmentname }领取商品！</h2>
<u onclick="insert();"><h2>继续兑换</h2></u>
</form>
</body></html>

