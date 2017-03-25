<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>眼视光信息管理系统EIMS 登录页面</title>
</head>
<script>

$(document).ready(function(){
	if('${errorFlag}'=='0' || '${systemParameterPo.fsplogonform}' == '2' || '${systemParameterPo.fsplogonform}' == '4'){
		$('input[name=personlogin]')[0].checked='checked';
				$('#cardLogin').show();
 				$('#userLogin').hide();
 				$('#titleImg').show();
 				$('#titleImg1').hide();
 				document.all.cardID.focus();
	}else{
		$('input[name=personlogin]')[1].checked='checked';
			$('#cardLogin').hide();
 				$('#userLogin').show();
 				$('#titleImg').hide();
 				$('#titleImg1').show();
 				document.all.userID.focus();
	}
 			
	 $('input[name=personlogin]').each(function(){
 		$(this).click(function(){
 			if($('input[name=personlogin]')[0].checked){
 				$('#cardLogin').show();
 				$('#userLogin').hide();
 				$('#titleImg').show();
 				$('#titleImg1').hide();
 				document.all.cardID.focus();
 			}else{
 				$('#cardLogin').hide();
 				$('#userLogin').show();
 				$('#titleImg').hide();
 				$('#titleImg1').show();
 				document.all.userID.focus();
 			}
 		});
 	});

    if ('${systemParameterPo.fsplogonform}' == '3' || '${systemParameterPo.fsplogonform}' == '4'){
    	$('#loginTab').hide();
    }else{
    	$('#loginTab').show();
    }
});

function loginProduct(){
	var radios=document.getElementsByName("personlogin");
	for(var i=0;i<radios.length;i++){
		if(radios[0].checked==true && event.keyCode==13){
			if(document.all.cardID.value==""){
				alert("请扫描员工卡!");
				document.all.cardID.focus();
				return false;
			}else{
				eyesoftForm.action = "loginSearch.action";
				eyesoftForm.submit();
			}
		}else if(radios[1].checked==true){
			if(document.all.userID.value==""){
				alert("请输入工号!");
				document.all.userID.focus();
				return false;
			}else if(document.all.userPassword.value==""){
				alert("请输入密码!");
				document.all.userPassword.focus();
				return false;
			}else{
				eyesoftForm.action = "loginSearch.action";
				eyesoftForm.submit();
			}
		}
	}
}

function clickFlySheet(){

	if ('${fquartzSwitchPo.fqscdpjd}' == '1'){
		var targeturl='';
		var flag = '';
		if ('${fquartzSwitchPo.fqswzhzstd}' == '1' && '${externalAccountParameterPo.feaexternaladdress}' != ''){
			targeturl='${externalAccountParameterPo.feaexternaladdress}';
			flag = '1';
		}else if ('${fquartzSwitchPo.fqswzhzstd}' == '2' && '${externalAccountParameterPo.feaaccessaddress}' != ''){
			targeturl='${externalAccountParameterPo.feaaccessaddress}';
			flag = '1';
		}else{
			flag = '';
		}

		if (flag == ''){
            return;
		}
		
		newwin=window.open("","",'scrollbars');
		newwin.moveTo(0,0);
		newwin.resizeTo(screen.width,screen.height);
		newwin.location=targeturl;
		window.opener=null;
		window.open("","_self"); 
		newwin.focus(); 
		window.close();	
    }

}
</script>

     <script event="OnObjectReady(objObject,objAsyncContext)" for="foo"> 
     	
         if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true) { 
             if(objObject.MACAddress != null && objObject.MACAddress != "undefined" && objObject.DNSServerSearchOrder!=null) 
                 MACAddr = objObject.MACAddress; 
             if(objObject.IPEnabled && objObject.IPAddress(0) != null && objObject.IPAddress(0) != "undefined" && objObject.DNSServerSearchOrder!=null) 
                 IPAddr = objObject.IPAddress(0); 
             if(objObject.DNSHostName != null && objObject.DNSHostName != "undefined") 
                 sDNSName = objObject.DNSHostName; 
         } 
     </script>

     <script type="text/javascript">
         var MACAddr ; 
         var IPAddr ; 
         var DomainAddr; 
         var sDNSName; 
         function init() {
         	setTimeout('getMac()', 300);
         }
         
         $(document).ready(function(){
	     	if('${systemParameterPo.fspischeckmac}' == '1'){
	             var service = locator.ConnectServer(); 
	             service.Security_.ImpersonationLevel=3; 
	             service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration'); 
        	 }
		 });
 
         function getMac() {
         	var mac = unescape(MACAddr)
         	if('${systemParameterPo.fspischeckmac}' == '1'){
         		<c:forEach var="po" items="${cpos}" varStatus="idxStatus">
					if(mac == '${po.fcnmac}'){
						$("#fcnName").text('${po.fcnName}');
					}
				</c:forEach>
         	}else{
         		$("#fcnName").text('${cpo.fcnName}');
         	}
         	$("#txtMac").val(mac);
         }
     </script>
     
<body onload="init();" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<!-- get Local Mac -->
<object id="locator" classid="CLSID:76A64158-CB41-11D1-8B02-00600806D9B6" VIEWASTEXT style="display: none;"></object> 
<object id="foo" classid="CLSID:75718C9A-F029-11d1-A1AC-00C04FB6C223" style="display: none;"></object> 
<!-- get Local Mac -->
</br></br>
<form name="eyesoftForm" method="post" action="" onsubmit="return login();">
<input type="hidden" id="flag" name="flag" value="${requestScope.errorFlag}"/>
<INPUT value=Eims type=hidden name=productCode>
<input type="hidden" name="txtMac" id="txtMac" />
<table id="__01" align="center" width="800" height="576" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="4" background="${ctx}/img/newbg/br_0221.png" width="800" height="276" align="right" valign="top">
		     <span id="fcnName" style="font-family: 微软雅黑;font-size: 50;color: black;font: bold;padding-right: 60;" >${cpo.fcnName}</span>
		</td>
	</tr>
	<tr>
		<td rowspan="3" width="58"  background="${ctx}/img/newbg/br_02.png" width="58" height="212"></td>
		<td background="${ctx}/img/newbg/br_03.png" width="108" height="92">
		<c:if test="${errorFlag=='0'}">
          		<img style="border: 0px" style="display:block" id="titleImg" src="${ctx}/img/login/loginTitle.png"  width="108" height="90"  title="">
          		</c:if>
          		<c:if test="${errorFlag=='1'||empty(errorFlag)}">
          		<img style="border: 0px" style="display:none" id="titleImg" src="${ctx}/img/login/loginTitle.png"  width="108" height="90"  title="">
          		</c:if>
          		
          		<c:if test="${errorFlag=='0'}">
          		<img style="border: 0px" style="display:none" id="titleImg1" src="${ctx}/img/login/loginTitle1.png"  width="108" height="90"  title=""> 
          		</c:if>
          		<c:if test="${errorFlag=='1'||empty(errorFlag)}">
          		<img style="border: 0px" style="display:block" id="titleImg1" src="${ctx}/img/login/loginTitle1.png" width="108" height="90"  title=""> 
          		</c:if>
		
			</td>
		<td background="${ctx}/img/newbg/br_04.png" width="151" height="92">
		<table id="loginTab" >		
			<tr><td><input type="radio" value="0"  name="personlogin"><font style="font-size: 16px;"  face="黑体">员工卡登陆</font></td></tr>
			<tr><td><input type="radio" checked="checked" value="1"  name="personlogin"><font style="font-size: 16px" face="黑体">用户名登陆</font></td></tr>
		</table>
			</td>
		<td background="${ctx}/img/newbg/br_05.png" width="483" height="212" rowspan="3">
			</td>
	</tr>
	<tr>
		<td colspan="2" width="259" height="90" background="${ctx}/img/newbg/br_06.png">
		<c:if test="${errorFlag=='0'}">
		<table style='display: none' id="userLogin">
		</c:if>
		<c:if test="${errorFlag=='1'||empty(errorFlag)}">
		<table style='display: block' id="userLogin">
		</c:if>
		<tr>
		<td width="10px"></td>
		<td><font style="font-size: 16px" face="黑体">用户名</font></td>
		<td>							
		<INPUT style="WIDTH: 110px" onFocus="this.value=''" 
		title="请输入用户名" onkeydown="if(event.keyCode==13)document.getElementById('userPassword').focus();" name="userID" id="userID"/></td>
		<td align="center"></td>
		</tr>
		<tr>
		<td></td>
		<td><font style="font-size: 16px"  face="黑体">密　码</font></td>
		<td>
        <INPUT style="width: 110px" onFocus="this.value=''" title=请输入登录密码 
		type=password name="userPassword" onkeydown="if(event.keyCode==13)loginProduct()" id="userPassword" maxlength="20">
        </td>
		<td ><img src="${ctx}/img/login/loginBtn.png" width="49px" style="cursor: hand;" title="" onclick="loginProduct();"></td>
		</tr>
		</table>
		<c:if test="${errorFlag=='1'||empty(errorFlag)}">
		<table style='display: none' id="cardLogin">
		</c:if>
		<c:if test="${errorFlag=='0'}">
		<table style='display: block' id="cardLogin">
		</c:if>
		<tr>
		<td width="10px"></td>
		<td><font style="font-size: 16px" face="黑体">卡号</font></td>
		<td>
		<INPUT type="text" height="25px" style="width: 130px" style="WIDTH: 200px" 
		title="请输入员工卡号" name="cardID" id="cardID" onkeydown="if(event.keyCode==13)loginProduct()" maxlength="20"/>
		</td>
		<td align="center"></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
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
			<img src="${ctx}/img/newbg/br_08.png" width="800" height="88" title="" onclick="clickFlySheet();"></td>
	</tr>
</table>
<!-- End ImageReady Slices -->
</form>
</body></HTML>
<s:if test="hasActionMessages()">
	<s:iterator value="actionMessages">    
	    <script language="JavaScript">    
	    	alert("<s:property escape="false"/>");
	    </script>    
	</s:iterator>    
</s:if>  
<s:if test="hasActionErrors()">    
	<s:iterator value="actionErrors">    
		<script language="JavaScript">    
			alert("<s:property escape="false"/>");
		</script>    
	</s:iterator>    
</s:if>