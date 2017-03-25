<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

</head>
<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	//WeixinJSBridge.call('hideOptionMenu');
    });

	function integralGoodsDetail(goodsID){
		location.href="initIntegralGoodsDetailSel.action?openID="+$('#openID').val() + "&goodsID="+goodsID;
	}

	function changeNum(key){
		
		var vl = "1";
		if(key == '-'){
			vl = parseInt($('#countNum').val()) - 1;
			if(vl < 1){
				vl = "1";
			}
			$('#countNum').val(vl);
		}else{
			vl = parseInt($('#countNum').val()) + 1;
			if(vl > "${integralPo.firpersonnum}"){
				alert("此商品允许您最多还能兑换${integralPo.firpersonnum}个！");
				vl = "${integralPo.firpersonnum}";
			}
			$('#countNum').val(vl);
		}
		
		$('#sumIntegral').val($('#countNum').val()*'${goodsInfoPo.bgiIntegralCount }');

		document.getElementById("i_sum").innerHTML = $('#sumIntegral').val();
	}

	function save(){
		if(checkForm(integralFrm)){	

			if(parseInt($('#countNum').val())<=0){
				alert("请确认兑换数量！");
				return;
			}

			vl = parseInt($('#countNum').val()) + 1;
			if( parseInt($('#countNum').val()) > "${integralPo.firpersonnum}"){
				alert("此商品允许您最多还能兑换${integralPo.firpersonnum}个！");
				return;
			}
			
			if(parseFloat($('#sumIntegral').val())>"${customerInfoPo.smeciintegral}"){
				divShow();
				return;
			}else{
				$('#xintegral').val("${customerInfoPo.smeciintegral}" - parseFloat($('#sumIntegral').val()));
			}


			if(confirm("${weiXinDataConfigPo.wdcalertjifenduihuanconfirm}"))
			 {
				$("img").removeAttr("onclick");
				integralFrm.action = "updateIntegralGoods.action";
			    integralFrm.submit();
			 }
		}
	}


	function divShow(){
		$("#tanchuang").css('display','block'); 
		$("#bodyDiv").css('display','none'); 
	}
	
	function divHide(){
		$("#tanchuang").css('display','none'); 
		$("#bodyDiv").css('display','block'); 
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="integralFrm" method="post" action="">
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<input name="yintegral" id="yintegral" type="hidden" value="${customerInfoPo.smeciintegral}" readonly="readonly"/>
<input name="cintegral" id="sumIntegral" type="hidden" value="${goodsInfoPo.bgiIntegralCount }" readonly="readonly"/>
<input name="xintegral" id="xintegral" type="hidden" value="" readonly="readonly"/>
<input name="goodsID" id="goodsID" type="hidden" value="${goodsInfoPo.bgigoodsid}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle lv_bg">
		<!-- 商品详情 -->
		<div class="xq" id="bodyDiv">
			<!-- 爱币背景 -->
			<div class="xqtop">
				<b>我的${weiXinDataConfigPo.wdcintroductionjifen}：<i>${customerInfoPo.smeciintegral }</i></b>
				<span>兑换后将消耗相应的${weiXinDataConfigPo.wdcintroductionjifen}</span>
			</div>
			<!-- 商品需本人手持 -->
			<img src="${ctx}/weixin_personcenter/images/sp2.png"  alt="" />
			<!-- 商品基本信息 -->
			<div class="xqnr">
				<h1>商品基本信息</h1>
				<p>
				<c:choose>
					<c:when test="${integralPo.firpicurl ne ''}">
						<img src="${ctx}${integralPo.firpicurl}" alt="" />	
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>	
				<c:choose>
					<c:when test="${integralPo.fircontent ne ''}">
							${integralPo.fircontent}
					</c:when>
					<c:otherwise>
						暂无商品基本信息......
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:otherwise>
				</c:choose>
				</p>
				<!-- 兑换数量 -->
				<div class="xqnran">
					<input class="dhsl" type="button" value=" 兑换数量"/>  
					<div class="xqjj">
						<img onclick="changeNum('-');" src="${ctx}/weixin_personcenter/images/sp5.png" onclick="changeNum('-');" alt="" />
						<input type="text" readonly="readonly" id="countNum" name="goodsnumber" value="1"/>
						<img onclick="changeNum('+');" src="${ctx}/weixin_personcenter/images/sp6.png" onclick="changeNum('+');" alt="" />
					</div>
				</div>

				<!-- 兑换门店 -->
				<div class="xqnran">
					<input class="dhsl" type="button" value=" 兑换门店"/>  
					<select id="sleBG" class="xqxl" name="wiedepartmentid">
				    	<c:forEach var="po" items="${departmentPoList}" varStatus="poIndex">
				    		<OPTION value="${po.bdpdepartmentid}">${po.bdpdepartmentname}</OPTION>
				    	</c:forEach>
			    	</select>
				</div>
				<!-- 兑换门店结束 -->
			</div>
			<!-- 商品基本信息结束 -->
			<!-- 商品详情底部背景 -->
			<div class="sp4bg"></div>
			<!-- 商品详情底部背景结束 -->
			<!-- 提示 -->
			<div class="xqts">
			<span>需花费您<i id="i_sum">${goodsInfoPo.bgiIntegralCount }</i>${weiXinDataConfigPo.wdcintroductionjifen} </span>
			<input class="" type="button" value=" 确认 " onclick="save();"/>  
			</div>
			<!-- 提示结束 -->
		</div>
		
		<!-- 商品详情结束 -->
		
		<!-- 弹出ERROR1 -->
   		<div id="tanchuang" style="display: none;" class="bg01">
	      <div class="qrdh wxtc2 yq">
	        <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
	        <p>您的${weiXinDataConfigPo.wdcintroductionjifen}不足,不能完成兑换！</p>
	        <input class="wxyya zxzl1" type="button" value="确 定" onclick="divHide();">
	      </div>
	    </div>
	    <!-- 弹出结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</script>
</html>