<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${companyNamePo.fcnName }</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx }/weixin/css/index.css" rel="stylesheet" type="text/css" />
</head>
<script>
	//document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	//WeixinJSBridge.call('hideOptionMenu');
    //});
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function details(id){
		departmentsForm.action = "initUserDepartmentDoctor.action?id="+id;
		departmentsForm.submit();
	}
	
	function selectView(id){
		departmentsForm.action = "initUserDepartmentPics.action?hid="+id;
		departmentsForm.submit();
	}
	
	function link(){
		if('${locationx}'){
			location.href="http://api.map.baidu.com/direction?origin="+'${locationx }'+","+'${locationy }'+"&destination="+'${departmentsPo.bdplocationx}'+","+'${departmentsPo.bdplocationy}'+"&mode=driving&region=guangzhou&output=html&src=yourCompanyName";
		}else{			
			location.href="http://api.map.baidu.com/marker?location="+'${departmentsPo.bdplocationx}'+","+'${departmentsPo.bdplocationy}'+"&output=html&content="+'${departmentsPo.bdpaddress }'+"&title="+'${departmentsPo.bdpdepartmentname}';
		}
	}
</script>
<body class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="departmentsForm" name="departmentsForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<div class="title">门店信息</div>
<table width="100%" border="0" cellpadding="5" cellspacing="5" class="fenjing_tab">
  <tr>
    <td bgcolor="#FFFFFF" class="font_fendian"><span class="font_fendian_tit">地址:</span><span class="font_txt">${departmentsPo.bdpaddress}</span></td>
  </tr>
  <tr>
    <td bgcolor="#FFFFFF" class="font_fendian"><span class="font_fendian_tit">电话:</span><span class="font_txt"><a href="tel:${departmentsPo.bdpphone}">${departmentsPo.bdpphone}</a></span></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="butt">
  <tr onclick="link('${departmentsPo.bdpdepartmentid }')">
    <td class="butt2_left">&nbsp;</td>
    <td class="butt_midd" style="cursor: hand;">查看地图</td>
    <td class="butt2_right">&nbsp;</td>
  </tr>
</table>
<br/>
<table border="0" cellpadding="0" cellspacing="0" class="butt">
  <tr onclick="selectView('${departmentsPo.bdpdepartmentid }')">
    <td class="butt2_left">&nbsp;</td>
    <td class="butt_midd" style="cursor: hand;">门店实景图</td>
    <td class="butt2_right">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
</form>
</body></html>