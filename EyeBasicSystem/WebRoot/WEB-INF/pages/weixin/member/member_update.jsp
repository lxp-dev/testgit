<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>我的资料</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
		<meta content="yes" name="apple-mobile-web-app-capable" />
		<meta content="black" name="apple-mobile-web-app-status-bar-style" />
		<meta content="telephone=no" name="format-detection" />
<style class="cp-pen-styles">
.button {
  display: block;
  
  width: 70px;    /*按钮宽度*/
  height: 30px;    /*按钮高度*/
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
      -ms-transform: translate(-50%, -50%);
          transform: translate(-50%, -50%);
  background: #4aaf6b;
  border-radius: 36px;
  
  cursor: pointer;
  
}
.button span {
  position: absolute;
  display: block;
}
.button span:first-of-type {
  z-index: 100;
  top: 2px;   /*开关按钮距离顶部距离*/
  right: 3px;  /*开关按钮距离右侧距离*/
  width: 30px;  /*开关按钮宽度*/
  height: 26px;  /*开关按钮高度*/
  background:#fff;
  

  border-radius: 36px;
  -webkit-transition: right 400ms cubic-bezier(1, 0, 0, 1);
          transition: right 400ms cubic-bezier(1, 0, 0, 1);
}
.button span:nth-last-of-type(-n+2) {
  z-index: 10;
  top: 2px;  /*ONOFF背景距离顶部距离*/
  width: 40px;  /*ONOFF背景宽度*/
  height: 26px;  /*ONOFF背景高度*/
  border-radius: 36px;
  -webkit-transition: opacity 800ms ease 100ms;
          transition: opacity 800ms ease 100ms;
}
.button span:nth-last-of-type(-n+2):after {
  position: absolute;
  top: 8px;    /*ONOFF文字距离顶部距离*/
  line-height: 1;
  font-family: "Open Sans";
  font-weight: 800;
  font-size: 12px;  /*ONOFF文字大小*/
  color: #fff;
  
}
.button span:nth-of-type(2) {
  left: 4px;
 
  background:#4aaf6b;
  
  
}
.button span:nth-of-type(2):after {
  content: "男";
  right:16px;
  	
}
.button span:last-of-type {
  right: 4px;
  background: #4aaf6b;
    
  opacity: 0.2;
}
.button span:last-of-type:after {
  content: "女";
  right: 9px;	
}
.button input[type="checkbox"] {
  display: none;
}
.button input[type="checkbox"]:checked ~ span:first-of-type {
  right: 37px;    /*开关按钮按下后距离右侧距离*/
  
}
.button input[type="checkbox"]:checked ~ span:nth-of-type(2) {
  opacity: 0.2;
}
.button input[type="checkbox"]:checked ~ span:last-of-type {
  opacity: 1;
}
.right{
	position:absolute;
	float:right;
	right:40px;
	top:22.9rem;
}
</style>
<script language="javascript" src="${ctx }/js/zone.js"></script>
<script>
    function insert(){
    	var checkbox = document.getElementById('check1');
    	
    	if(checkbox.checked){
    		$("#sex").val("1");
    	}else{
    		$("#sex").val("0");
    	}
    	
    	if(checkForm(memeberFrm)){
			var sel_year = document.getElementById('sel_year');
			var sel_month = document.getElementById('sel_month');
			var sel_day = document.getElementById('sel_day');

    		if(isNaN(sel_year.value) || sel_year.value=='0'){
				alert('生日格式有误!');
				sel_year.focus();
				return;
    		}
    	
    		if(isNaN(sel_month.value) || sel_month.value=='0'){
				alert('生日格式有误!');
				sel_month.focus();
				return;
    		}
    		if(isNaN(sel_day.value) || sel_day.value=='0'){
				alert('生日格式有误!');
				sel_day.focus();
				return;
    		}
				
    		memeberFrm.action = "updateWeiXinMemberBindInfo.action";
    		memeberFrm.submit();
        }
    }
    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

</script>
</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="memeberFrm" method="post" action="">
<input name="openID" id="openID" type="hidden" value="${openID}"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<!-- 我的资料 -->
		<div class="xf_ctinner">
			<div class="zltx">
				<c:choose>
					<c:when test="${customerInfoPo.memberPicPath ne ''}">
						<c:choose>
							<c:when test="${fn:indexOf(customerInfoPo.memberPicPath, 'http://') ne ''}">
								<img src="${customerInfoPo.memberPicPath}" alt="">
							</c:when>
							<c:otherwise>
								<img src="${ctx}/${customerInfoPo.memberPicPath}" alt="">
							</c:otherwise>								
						</c:choose>
					</c:when>
					<c:otherwise>
						<img src="${ctx}/weixin_personcenter/default_images/person.png" alt="">
					</c:otherwise>
				</c:choose>	
			</div>
		</div>
		<div class="wxyy">
			<ul>

				<li>
					<i>姓名</i>
					<input class="wxt1" yyorder="1" type="text" placeholder="请输入您的姓名" id="smeciname" name="customerInfoPo.smeciname" maxlength="20" value="${customerInfoPo.smeciname}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入您的姓名！'}]"/>
			        <input type="hidden"  id="smecicustomerid" name="customerInfoPo.smecicustomerid" value="${customerInfoPo.smecicustomerid}" />
				</li>
				<li>
					<i>会员等级</i>
					<input class="wxt1" type="text" value="${(customerInfoPo.smeciconsumptionprice eq '0.00') ? '蓝星会员' : '红星会员'}" readonly="readonly">

				</li>
				<li class="yb1">
					<i>生日</i>
					<select id="sel_year" name="birthYear" rel="${year }"></select>
			        <select id="sel_month" name="birthMonth" rel="${month }"></select>
			        <select id="sel_day" name="birthday" rel="${day }"></select>
				</li>
				<li class="wxt3">
					<i>性别</i><input type="hidden" name="customerInfoPo.smecisex" id="sex" value="${customerInfoPo.smecisex}" />
					<!-- <a style="color:#fff;" class="ys ys1" onclick="changeSex();" id='sexpic'>${customerInfoPo.smecisex eq '1' ? '女':'男'}</a>-->
				</li>
				<div class="right">
					<label class="button">
	                    <input id="check1" type="checkbox" ${(customerInfoPo.smecisex eq '1') ? 'checked=checked':'' }}>
	                    <span></span>
	                    <span></span>
	                    <span></span>
                    </label>
                </div> 	 
				<li>
				<i>地址</i>
					<textarea id="smeciaddress" name="customerInfoPo.smeciaddress" rows="3" cols="30" maxlength="50">${customerInfoPo.smeciaddress}</textarea>
				</li>
					<input class="zlan" type="button" style="color: #fff;" onclick="insert();" value=" 保 存 ">
			</ul>
		</div>
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</form>
<script src="<%=request.getContextPath()%>/weixin_personcenter/js/birthday.js" type="text/javascript" charset="utf-8"></script>
<script>  
$(function () {
	$.ms_DatePicker({
            YearSelector: ".sel_year",
            MonthSelector: ".sel_month",
            DaySelector: ".sel_day"
    });
	$.ms_DatePicker();
}); 
</script> 
</body>
</html>