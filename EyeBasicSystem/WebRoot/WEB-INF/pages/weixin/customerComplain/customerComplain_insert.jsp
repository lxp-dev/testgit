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

	function save(){
		if(checkForm(document.all.customerComplainForm)){ 
			if($('#smecccomplaintype').val()==''){
				alert("请选择建议类型！");
				$('#smecccomplaintype').focus();
				return;
			}
			
			if($('#smecccomplaincontent').val()==''){
				alert("请填写建议内容！");
				$('#smecccomplaincontent').focus();
				return;
			}
			
			if($("input[id=rr]:checked").val() == '1'){
				if($('#smecclinksalesid').val()==''){
					alert("请填写配镜单号！");
					$('#smecclinksalesid').focus();
					return;
				}
			}
			
			$("img").removeAttr("onclick");
			customerComplainForm.action = "insertCustomerComplainWX.action";
			customerComplainForm.submit();
		}
	}
 
	function clean(){
	    document.customerComplainForm.reset(); 
	    $('#showtr1').hide();
	}	
	
	function permissionMessage(){
        alert('您无此操作权限');
	}
 
	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
	
	function today(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('taday1').value = now;	
	}
	
	function show(){
		if($('#handletype').attr('checked')){
			$('#showtr1').show();
		}else{
			$('#showtr1').hide();
		}
	}
	
	function setCustomer2(cname,cphone,memberid,ssetmlinksalesid){
		$('#customername').val(cname);
		$('#phone').val(cphone);
		$('#smecccustomermemberid').val(memberid);
		$('#ssetmlinksalesid').val(ssetmlinksalesid);				
	}
	
	function hid(obj){
		if($(obj).val() == '1'){
			$("#hidetr").show();
			$("#smecclinksalesid").removeAttr('noValidate');
		}else{
			$("#hidetr").hide();
			$("#smecclinksalesid").val("");
			$("#smecclinksalesid").attr({'noValidate':'noValidate'});			
		}
	}
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    	WeixinJSBridge.call('hideToolbar');
    });
</script>
<body class="bg_color">
<form name="customerComplainForm" id="customerComplainForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }">
<input type="hidden" name="customerComplainPo.smeccuuid" value="${smeccuuid }"/>
<input type="hidden" name="customerComplainPo.smecccustomermemberid" value="${customerComplainPo.smecccustomermemberid }"/>
<input type="hidden" name="customerComplainPo.smeccintendhandledate" value="${fn:substring(customerComplainPo.smeccintendhandledate,0,10) }"/>
<div class="title">服务建议</div>
<table  border="0" cellpadding="5" cellspacing="5" class="fenjing_tab">
  <tr>
    <td class="neirong_shuru" colspan="2"><label for="select4"></label>
    	<input type="radio" id="rr" name="1" value="1" checked="checked" onclick="hid(this)"/>&nbsp;&nbsp;配镜单投诉
    	<input type="radio" id="rr" name="1" value="2" onclick="hid(this)"/>&nbsp;&nbsp;其他投诉
    </td>
  </tr>
  <tr>
    <td class="neirong_name" width="30%">类型：</td>
    <td class="neirong_shuru" align="center"><label for="select4"></label>
    	<select id="smecccomplaintype" name="customerComplainPo.smecccomplaintype">
      		                 	<option value="">---请选择---</option>
                             	<c:if test="${not empty(complaintsTypeList)}">
				               	  <s:iterator value="complaintsTypeList">
                    	           <OPTION value="${bctid}" ${customerComplainPo.smecccomplaintype != bctid  ? '' : 'selected="selected"' } >${bctname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                    </select>
    </td>
  </tr>
  <tr id="hidetr">
    <td class="neirong_name">配镜单号：</td>
    <td class="neirong_shuru" align="center"><label for="select4"></label>
    	
    	<select id="smecclinksalesid" name="customerComplainPo.smecclinksalesid">
      		                 	<option value="">---请选择---</option>
                             	<c:if test="${not empty(salesBasicList)}">
				               	  <s:iterator value="salesBasicList">
                    	           <OPTION value="${ssesbsalesid}">${ssesbsalesid}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                    </select>
    </td>
  </tr>
  <tr>
    <td class="neirong_name">内容：</td>
    <TD class="neirong_shuru" width="200px">
      <textarea name="customerComplainPo.smecccomplaincontent" id="smecccomplaincontent" 
    	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '建议内容不能大于100字！'}]">${customerComplainPo.smecccomplaincontent }</textarea>
    </TD>
  </tr>
</table>
<br />
<table border="0" cellpadding="0" cellspacing="0" class="butt">
  <tr onclick="save()">
    <td class="butt2_left">&nbsp;</td>
    <td class="butt_midd">提交投诉</td>
    <td class="butt2_right">&nbsp;</td>
  </tr>
</table>
</DIV>
</form>
</body></html>
