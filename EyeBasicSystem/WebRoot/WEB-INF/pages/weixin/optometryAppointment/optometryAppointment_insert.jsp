<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信预约</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
</head>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function save(){
		//sweetAlert("Oops...", "Something went wrong!", "error");
		if(checkForm(document.all.optometryAppointmentForm)){ 	
			$("img").removeAttr("onclick");
			optometryAppointmentForm.action = "insertWeiXinOptometryAppointmentPo.action";
			optometryAppointmentForm.submit();
		}
	}	

	function getDoctor(){
		 $('#woadoctorid').load("getAjaxDoctor.action?wangdian="+ $('#woawangdian').val() +"&zhenliao=" + $('#woazhenliao').val());
		 document.getElementById("yyid").innerHTML='<i>预约日期</i><input class="wxt1" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择预约日期！\'}]"  onFocus="WdatePicker()" placeholder="请选择日期" id="woadatetime" readonly="readonly" name="weiXinOptometryAppointmentPo.woadatetime" type="text" />';
	}

	function getWorkday(){
		document.getElementById("yyid").innerHTML='<i>预约日期</i><input class="wxt1" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择预约日期！\'}]" placeholder="请选择日期" id="woadatetime" readonly="readonly" name="weiXinOptometryAppointmentPo.woadatetime" type="text" onFocus="WdatePicker()"/>';
		if($('#woadoctorid').val() !=''){
			 $('#yyid').load("getAjaxWorkday.action?doctorid="+ $('#woadoctorid').val(),function(responseText){
				 getWorkResult(responseText);
				});  
		}
	}

	String.prototype.replaceAll = function(s1,s2){
		　　return this.replace(new RegExp(s1,"gm"),s2);
		　　}

	function getWorkResult(str){

		var s=str.replaceAll(",",""); 
		var s1="0123456";
		var s2="";

		for(var i = 0 ; i < s.length ; i++) {
			s1=s1.replace(s[i],"");
		}

		for(var i = 0 ; i < s1.length ; i++) {
			s2=s2 + s1[i];
			if(i!=s1.length-1){
				s2=s2 + ",";
			}
		}
		if(s2 ==""){
			document.getElementById("yyid").innerHTML='<i>预约日期</i><input class="wxt1" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择预约日期！\'}]" placeholder="请选择日期" id="woadatetime" readonly="readonly" name="weiXinOptometryAppointmentPo.woadatetime" type="text" onFocus="WdatePicker()"/>';
		}else{
			document.getElementById("yyid").innerHTML='<i>预约日期</i><input class="wxt1" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选择预约日期！\'}]" placeholder="请选择日期" id="woadatetime" readonly="readonly" name="weiXinOptometryAppointmentPo.woadatetime" type="text" onFocus="WdatePicker({disabledDays:['+ s2 +']})"/>';
		}
	}
</script> 
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="optometryAppointmentForm" method="post" action="">
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<input name="toUserName" id="toUserName" type="hidden" value="${toUserName}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<span class="h3bg "></span>
		<!-- 微信预约 -->
		<div class="xf_ctinner">
			<div class="wxyy">
				<ul>
					<li>
					<span style="color:#fff;">${weiXinCmsContentPo.wcmsctitle }</span>
					${weiXinCmsContentPo.wcmsccontent}
					</li>
					<li>
						<i>联系人</i>
						<input class="wxt1" type="text" placeholder="请输入您的姓名" id="woaname" name="weiXinOptometryAppointmentPo.woaname" maxlength="20" value="${weiXinOptometryAppointmentPo.woaname}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写联系人姓名！'}]"/>
					</li>
					<li>
						<i>联系手机</i>
						<input class="wxt1" type="text" placeholder="请输入您的联系手机" id="woamobilephone" name="weiXinOptometryAppointmentPo.woamobilephone" value="${weiXinOptometryAppointmentPo.woamobilephone}"  maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写联系手机 ！'},{'Type' : Type.String, 'Formula' : Formula.TelPhoneOrNull, 'Message' : '手机号格式不正确！'}]"/>
					</li>
					<li class="wxt2">
						<i>网点预约</i>
						<select name="weiXinOptometryAppointmentPo.woadiyu" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择预约网点！'}]">
							<option value="" selected></option>
							<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
								<c:if test="${optionParamPoTmp.fopparentid=='weixin_diyu'}">
									<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
								</c:if>	                                      	
							</c:forEach> 
						</select>
						<select id="woawangdian" name="weiXinOptometryAppointmentPo.woawangdian" onchange="getDoctor()" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择预约网点！'}]">
							<option value="" selected></option>
							<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
								<c:if test="${optionParamPoTmp.fopparentid=='weixin_wangdian'}">
									<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
								</c:if>	                                      	
							</c:forEach> 
						</select>
					</li>
					<li class="wxt3">
						<i>诊疗项目</i>
						<select id="woazhenliao" name="weiXinOptometryAppointmentPo.woazhenliao" onchange="getDoctor()" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择诊疗项目！'}]">
							<option value="" selected></option>
							<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
								<c:if test="${optionParamPoTmp.fopparentid=='weixin_zhenliao'}">
									<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
								</c:if>	                                      	
							</c:forEach> 
						</select>
					</li>
					<li class="wxt3">
						<i>坐诊专家</i>
						<select id="woadoctorid" name="weiXinOptometryAppointmentPo.woadoctorid" onchange="getWorkday()" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择专家！'}]">
							<option value="" selected></option> 
						</select>
					</li>		
					<li id="yyid">
						<i>预约日期</i>
						<input class="wxt1" placeholder="请选择日期" id="woadatetime" readonly="readonly" name="weiXinOptometryAppointmentPo.woadatetime" type="text" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写预约日期！'}]"/>
					</li>
						<li class="wxt4">
						<i>预约时间</i>
						<select name="weiXinOptometryAppointmentPo.woahour">
							<option value="09" selected>09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
						</select>
						点
						<select name="weiXinOptometryAppointmentPo.woaminute">
							<option value="00" selected>00</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<c:forEach var="i" begin= "10" step="1" end= "59"> 
								<option value="${i }">${i }</option>
							</c:forEach>
						</select>
						分
					</li>
					<li>
					<textarea rows="3" cols="36" placeholder="请输入备注信息" id="woacontent" name="weiXinOptometryAppointmentPo.woacontent" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [201]}, 'Message' : '预约需求不能大于200字！'}]">${weiXinOptometryAppointmentPo.woacontent}</textarea>
						
					</li>
					<input class="wxyya zxzl1" type="button" value="确 定" onclick="save()" style="color:#fff;"/>
					</ul>
				</div>
			</div>
			<!-- 微信预约结束 -->
		</div>	
	</form>
</body></html>