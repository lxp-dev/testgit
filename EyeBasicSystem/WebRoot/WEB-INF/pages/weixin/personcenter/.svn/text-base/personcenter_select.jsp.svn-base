<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

    function personInfo(){
        location.href="initWeiXinMemberInfoDetail.action?openID="+$('#openID').val();
    }

    function myCaseHistory(){
        location.href="initMyCaseHistorySel.action?openID="+$('#openID').val();
    }

    function msgCenter(){
        location.href="initMsgCenterSel.action?openID="+$('#openID').val();
    } 

    function integralMall(){
        location.href="initIntegralMallSel.action?openID="+$('#openID').val();
    } 

    function indexPage(){
    	location.href="initPersonCenterSel.action?openID="+$('#openID').val(); 
    } 

    function href_inviteFriend(){
    	location.href="initWeiXinInviteFriend.action?openID="+$('#openID').val();  
    }    

	function chuzhikaLoglink(str){
		if(str!=''){
			location.href="initWeixinCzkSel.action?openID="+$('#openID').val() +"&czkID="+str;  	
		}else{
			changeDiv('0');
		}
	} 

	function changeDiv(str){
		if(str == '1'){
			$("#noChuzhiDiv").css('display','none'); 
			$("#homeDiv").css('display','block'); 
		}else{
			$("#noChuzhiDiv").css('display','block'); 
			$("#homeDiv").css('display','none'); 
		}
	}
</script>
</head>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
	<div class="xf_canting xf_panle">
		<!-- 弹出ERROR1 -->
    		<div id="noChuzhiDiv" class="bg01" style="display: none;">
		      <div class="qrdh wxtc2">
		      <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
		        <p style="text-align: left;padding: 15px;">福币：获取福卡资格>邀请好友成功></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;累积福币。</br>
		        	特权：等值提现。</br>
		        	详见：最新活动-<s:property value="getText('jifen.jifen')"/>攻略。
		        <input class="wxyya zxzl1" type="button" value="确 定" onclick="changeDiv('1');">
		      </div>
		    </div>
		    <!-- 弹出结束 -->
		<div id="homeDiv" class="xf_ctinner">
			<div class="xf_ctdt">
				<c:choose>
					<c:when test="${weiXinDataConfigPo.wdcpersoncenterpicurl ne ''}">
						<img src="${ctx}/${weiXinDataConfigPo.wdcpersoncenterpicurl}" alt="">
					</c:when>
					<c:otherwise>
						<img src="${ctx}/weixin_personcenter/default_images/company.png" alt="">
					</c:otherwise>
				</c:choose>	
				<i class="xf_ctlogo">
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
				</i></div>
			<em class="xf_ctmz">${customerInfoPo.smeciname}&nbsp;|&nbsp;<a href="#" onclick="link('${weiXinDataConfigPo.wdclxhx}')">${(customerInfoPo.smeciconsumptionprice eq '0.00') ? '蓝星会员' : '红星会员'}</a>&nbsp;|&nbsp;
			<c:choose>
				<c:when test="${jifenorchuzhi eq '1'}">
					<a href="#" onclick="chuzhikaLoglink('${customerInfoPo.smeciname}')">${weiXinDataConfigPo.wdcintroductionchuzhi}：${(empty chuzhikaPo.cstczkid) ? '0.00':chuzhikaPo.cstczkjine}</a>
				</c:when>
				<c:otherwise>
					<a href="#">${weiXinDataConfigPo.wdcintroductionchuzhi}：${(empty customerInfoPo.smeciintegral) ? '0.00':customerInfoPo.smeciintegral}</a>
				</c:otherwise>
			</c:choose>
			</em>
			<div class="xf_ctxx">
				<ul>
					<li><a href="#" onclick="personInfo();"><img src="${ctx}/weixin_personcenter/images/ico_dc.png" alt=""><span>我的资料</span></a></li>
					<c:if test="${sessionScope.mycasehistoryisshow ne '1'}">
						<li><a href="#" onclick="myCaseHistory();"><img src="${ctx}/weixin_personcenter/images/ico_yysj.png" alt=""><span>我的病历</span></a></li>
					</c:if>
					<li><a href="#" onclick="msgCenter();">
						<img src="${ctx}/weixin_personcenter/images/ico_xx.png" alt=""><span>消息中心</span>
						<c:if test="${count ne '0'}">
							<i>${count}</i>
						</c:if>
					</a></li>
					<li><a href="#" onclick="integralMall();"><img src="${ctx}/weixin_personcenter/images/ico_wd.png" alt=""><span>我的${weiXinDataConfigPo.wdcintroductionjifen}</span></a></li>
					<li><a href="#" onclick="href_inviteFriend();"><img src="${ctx}/weixin_personcenter/images/ico_yqhy.png" alt=""><span>邀请好友</span></a></li>
				</ul>
			</div>
		</div>
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>