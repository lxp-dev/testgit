<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务建议</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
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
			
			
			$("img").removeAttr("onclick");
			customerComplainForm.action = "userInsertCustomerComplain.action";
			customerComplainForm.submit();
		}
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
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="customerComplainForm" method="post" action="">
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<input name="toUserName" id="toUserName" type="hidden" value="${toUserName}" readonly="readonly"/>
<input type="hidden" name="customerComplainPo.smecccustomermemberid" value="${customerComplainPo.smecccustomermemberid }"/>
<input type="hidden" name="customerComplainPo.smeccintendhandledate" value="${fn:substring(customerComplainPo.smeccintendhandledate,0,10) }"/>
<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<span class="h3bg "></span>
		<!-- 微信预约 -->
		<div class="xf_ctinner">
			<div class="wxyy">
				<ul>
					<li class="wxt3">
						<i>投诉类型</i>
						<select id="rr" name="customerComplainPo.smecccomplaintype" onchange="hid(this)">
							<option value="1">配镜单投诉</option>
							<option value="2">其他投诉</option>
						</select>
					</li>
					<li class="wxt3">
						<i>投诉内容</i>
						<select id="smecccomplaintype" name="customerComplainPo.smecccomplaintype" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择投诉内容！'}]">
							<option value="">---请选择---</option>
							<c:if test="${not empty(complaintsTypeList)}">
								<s:iterator value="complaintsTypeList">
									<OPTION value="${bctid}" ${customerComplainPo.smecccomplaintype != bctid  ? '' : 'selected="selected"' } >${bctname}</OPTION>
								</s:iterator>
							</c:if>
						</select>
					</li>
					<li id="hidetr" class="wxt3">
						<i>配镜单号</i>
    					<select id="smecclinksalesid" name="customerComplainPo.smecclinksalesid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择配镜单！'}]">
				    		<option value="">---请选择---</option>
							<c:if test="${not empty(salesBasicList)}">
								<s:iterator value="salesBasicList">
									<OPTION value="${ssesbsalesid}">${ssesbsalesid}</OPTION>
								</s:iterator>
							</c:if>
						</select>
					</li>
					<li>
						<textarea rows="3" cols="36" placeholder="请描述投诉原因" name="customerComplainPo.smecccomplaincontent" id="smecccomplaincontent" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '建议内容不能大于100字！'}]">${weiXinOptometryAppointmentPo.woacontent}</textarea>
					</li>					
					<input class="wxyya zxzl1" type="button" value="确 定" onclick="save()" style="color:#fff;"/>
					</ul>
				</div>
			</div>
			<!-- 服务建议结束 -->
		</div>	
	</form>
</body>
</html>