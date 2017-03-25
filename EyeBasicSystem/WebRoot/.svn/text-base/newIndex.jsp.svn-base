<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>集成化信息管理平台EyeSoft 登录页面</title>
</head>
<script>
$(document).ready(function(){
	 $('input[name=wanglei]').each(function(){
 		$(this).click(function(){
 			if($('input[name=wanglei]')[0].checked){
 				$('#cardLogin').show();
 				$('#userLogin').hide();
 				$('#titleImg').show();
 				$('#titleImg1').hide();
 			}else{
 				$('#cardLogin').hide();
 				$('#userLogin').show();
 				$('#titleImg').hide();
 				$('#titleImg1').show();
 			}
 		});
 	});
});

</script>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<!-- ImageReady Slices (封面-切1.psd) -->
<table id="__01" align="center" width="800" height="576" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="4" background="${ctx}/img/newbg/br_01.png" width="800" height="276">
		</td>
	</tr>
	<tr>
		<td rowspan="3" width="58"  background="${ctx}/img/newbg/br_02.png" width="58" height="212"></td>
		<td background="${ctx}/img/newbg/br_03.png" width="108" height="92">
          		<img style="border: 0px" id="titleImg" src="${ctx}/img/login/loginTitle.png" height="90"  title="">
		<img style="border: 0px;display: none" id="titleImg1" src="${ctx}/img/login/loginTitle1.png" height="90"  title=""> 
			</td>
		<td background="${ctx}/img/newbg/br_04.png" width="151" height="92">
		<table  >
			<tr><td><input type="radio" checked="checked" name="wanglei"><font style="font-size: 16px;"  face="黑体">员工卡登陆</font></td></tr>
			<tr><td><input type="radio" name="wanglei"><font style="font-size: 16px" face="黑体">用户名登陆</font></td></tr>
		</table>
			</td>
		<td rowspan="3">
			<img src="${ctx}/img/newbg/br_05.png" width="483" height="212" title=""></td>
	</tr>
	<tr>
		<td colspan="2" width="259" height="90" background="${ctx}/img/newbg/br_06.png">
		<table style="display: none" id="userLogin">
		<tr>
		<td width="10px"></td>
		<td><font style="font-size: 16px" face="黑体">用户名</font></td>
		<td><input type="text" style="width: 110px"/></td>
		<td align="center"></td>
		</tr>
		<tr>
		<td></td>
		<td><font style="font-size: 16px"  face="黑体">密　码</font></td>
		<td><input type="text" style="height: 26px;width: 110px"/></td>
		<td ><img src="${ctx}/img/login/loginBtn.png" width="49px"  title=""></td>
		</tr>
		</table>
		<table id="cardLogin">
		<tr>
		<td width="10px"></td>
		<td><font style="font-size: 16px" face="黑体">卡号</font></td>
		<td><input type="text" height="25px" style="width: 130px"/></td>
		<td align="center"></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td ><img src="${ctx}/img/login/loginBtn.png" width="49px" height="20px" title=""></td>
		</tr>
		</table>
			</td>
	</tr>
	<tr>
		<td colspan="2">
			<img src="${ctx}/img/newbg/br_07.png" width="259" height="30" title=""></td>
	</tr>
	<tr>
		<td colspan="4">
			<img src="${ctx}/img/newbg/br_08.png" width="800" height="88" title=""></td>
	</tr>
</table>
<!-- End ImageReady Slices -->
</body></HTML>
