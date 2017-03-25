<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="description" content="乐享微信">

<title>幸运大转盘抽奖</title>
<link href="${ctx }/weixin/xyzp/activity-style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
</script>
</head>

<body class="activity-lottery-winning" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="memeberFrm" method="post" action="">
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>

<div id="activityOver" style="margin-top:60px;${requestScope.expired eq 'expired' ? '' : 'display: none;' }" align="center">
  <font size="4" >${requestScope.activity }</font>
</div>
<div class="main" style="${requestScope.expired eq 'expired' ? 'display: none;' : '' }">
<script type="text/javascript">
var loadingObj = new loading(document.getElementById('loading'),{radius:20,circleLineWidth:8});   
    loadingObj.show();   
</script>
<c:if test="${weiXinLuckDrawPo.wcjsflag eq '1'}">
 <div id="outercont">
<div id="outer-cont">
<div id="outer"><img src="${ctx }/weixin/xyzp/activity-lottery-1.png" width="310px"></div>
</div>
<div id="inner-cont">
<div id="inner"><img src="${ctx }/weixin/xyzp/activity-lottery-2.png"></div>
</div>
</div>
</c:if>

<div class="content">
<div class="boxcontent boxyellow" id="result" style="display:none">
<div class="box">
<div class="title-orange"><span>恭喜您中奖了</span></div>
<div class="Detail">
            <a class="ui-link" href="http://www.weixinjia.net/mobile/showresult.html" id="opendialog" style="display: none;" data-rel="dialog"></a>
<p>您中了：<span class="red" id="prizetype">一等奖</span>，请输入手机号</p>
<!-- 
<p>你的兑奖SN码：<span class="red" id="sncode"></span></p>
<p class="red">本次兑奖码已经关联你的微信号，你可向公众号发送 兑奖 进行查询!</p>
 -->
<p>
<input type="text" class="px" id="tel" name="smeciphone" maxlength="15" validate="[{'Type' : Type.String, 'Formula' : Formula.Phone, 'Message' : '请重新输入手机号码！'}]">
                          
</p>
<p>
<input class="pxbtn" id="save-btn" name="提 交" type="button" value="提 交">
</p>
</div>
</div>
</div>
<div class="boxcontent boxyellow">
<div class="box">
<div class="title-green"><span>奖项设置：</span></div>
<div class="Detail">
<p>一等奖：${weiXinLuckDrawPo.wcjsprizesizegoods1 } 。奖品数量：${weiXinLuckDrawPo.wcjsprizesizegoodsnumber1 } </p>
<p>二等奖：${weiXinLuckDrawPo.wcjsprizesizegoods2 } 。奖品数量：${weiXinLuckDrawPo.wcjsprizesizegoodsnumber2 } </p>
<p>三等奖：${weiXinLuckDrawPo.wcjsprizesizegoods3 } 。奖品数量：${weiXinLuckDrawPo.wcjsprizesizegoodsnumber3 } </p>
</div>
</div>
</div>

<c:if test="${weiXinLuckDrawPo.wcjsflag eq '1'}">
<div class="boxcontent boxyellow">
<div class="box">
<div class="title-green">活动说明：</div>
<div class="Detail">
<p>本次活动时间：${weiXinLuckDrawPo.wcjsactivitiesstratdate}&nbsp;至 &nbsp;${weiXinLuckDrawPo.wcjsactivitiesenddate}</p>
<c:if test="${weiXinLuckDrawPo.wcjsdaynumber ne ''}"><p>本次活动每天最多抽奖${weiXinLuckDrawPo.wcjsdaynumber} 次 </p></c:if>
<c:if test="${weiXinLuckDrawPo.wcjspersonnumber ne ''}"><p>本次活动每人每天最多抽取 ${weiXinLuckDrawPo.wcjspersonnumber} 次 </p></c:if>
<c:if test="${weiXinLuckDrawPo.wcjspersonlucknumber ne ''}"><p>本次活动每人最多中奖 ${weiXinLuckDrawPo.wcjspersonlucknumber} 次 </p></c:if>
</div>
</div>
</div>
</c:if>

<c:if test="${weiXinLuckDrawPo.wcjsflag eq '0'}">
<div class="boxcontent boxyellow">
<div class="box">
<div class="title-green">活动说明：</div>
<div class="Detail">
<p>幸运抽奖活动已停止!</p>
</div>
</div>
</div>
</c:if>

<div class="boxcontent boxyellow">
<div class="box">
<div class="title-green">中奖记录：</div>
<div class="Detail">
    <table id="luckDrawTab">
     <s:iterator value="weiXinLuckDrawList">
       <tr>
           <td width="10%">${wcjwindate}</td>
           <td width="10%"><c:if test="${wcjprizesize eq '1'}">一等奖</c:if><c:if test="${wcjprizesize eq '2'}">二等奖</c:if><c:if test="${wcjprizesize eq '3'}">三等奖</c:if><c:if test="${wcjprizesize eq '4'}">四等奖</c:if><c:if test="${wcjprizesize eq '5'}">五等奖</c:if></td>
           <td width="20%">${wcjprizegoodname }</td>
           <td width="10%"><c:if test="${wcjflag eq '1'}">已领取</c:if><c:if test="${wcjflag eq '0'}">未领取</c:if></td>
       </tr>
     </s:iterator>
    </table>
</div>
</div>
</div>
</div>
</div>

<script src="${ctx }/weixin/xyzp/jquery.js" type="text/javascript"></script> 
<script type="text/javascript">
var prize;
$(function() {
    window.requestAnimFrame = (function() {
        return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
        function(callback) {
            window.setTimeout(callback, 1000 / 60);
        }
    })();
    var totalDeg = 360 * 3 + 0;
    var steps = [];
    var lostDeg = [36, 66, 96, 156, 186, 216, 276, 306, 336];
    var prizeDeg = [6, 126, 246];
    var sncode;
    var count = 0;
    var now = 0;
    var a = 0.01;
    var outter, inner, timer, running = false;
    var prizecount = 0;   // 每人最多中奖次数
    function countSteps() {
        var t = Math.sqrt(2 * totalDeg / a);
        var v = a * t;
        for (var i = 0; i < t; i++) {
            steps.push((2 * v * i - a * i * i) / 2)
        }
        steps.push(totalDeg)
    }
    function step() {
        outter.style.webkitTransform = 'rotate(' + steps[now++] + 'deg)';
        outter.style.MozTransform = 'rotate(' + steps[now++] + 'deg)';
        if (now < steps.length) {
            requestAnimFrame(step)
        } else {
            running = false;
            setTimeout(function() {
                if (prize != null && prize != '' && prize != '4') {
                	//prize = 1;                 // 默认中一等奖
                    $("#sncode").text(sncode);
                    var type = "";
                    if (prize == 1) {
                        type = "一等奖"
                    } else if (prize == 2) {
                        type = "二等奖"
                    } else if (prize == 3) {
                        type = "三等奖"
                    }
                    $("#prizetype").text(type);
                    $("#result").slideToggle(500);
                    $("#outercont").slideUp(500);
                    prizecount = prizecount + 1;
                } else {
                    alert("谢谢您的参与，下次再接再厉！");
                }
            },
            200)
        }
    }
    function start(deg) {
        deg = deg || lostDeg[parseInt(lostDeg.length * Math.random())];
        running = true;
        clearInterval(timer);
        totalDeg = 360 * 5 + deg;
        steps = [];
        now = 0;
        countSteps();
        requestAnimFrame(step)
    }
    window.start = start;
    outter = document.getElementById('outer');
    inner = document.getElementById('inner');
    i = 10;
    $("#inner").click(function() {
        if (running) return;
        if (count >= Number('${weiXinLuckDrawPo.wcjspersonnumber}')) {
            alert("您已经抽了" + '${weiXinLuckDrawPo.wcjspersonnumber}' + "次奖。");
            return;
        }
        if (prizecount >= Number('{weiXinLuckDrawPo.wcjspersonlucknumber}')) {
            alert("亲，你不能再参加本次活动了喔！下次再来吧~");
            return;
        }
        $.ajax({
            url: "insertWeiXinLuckDrawLog.action?openID=${openID}",
            dataType: "json",
            data: {
                token: "o7MB9ji5fQRsE0ZoVAMU7SlnRyMI",
                ac: "activityuser",
                tid: "5",
                t: Math.random()
            },
            beforeSend: function() {
                running = true;
                timer = setInterval(function() {
                    i += 5;
                    outter.style.webkitTransform = 'rotate(' + i + 'deg)';
                    outter.style.MozTransform = 'rotate(' + i + 'deg)';
                },
                1)
            },
            success: function(data) {
                //alert(data.error)
                if (data.error == "invalid") {
                	alert("您的抽奖次数已经超过" + '${weiXinLuckDrawPo.wcjspersonnumber}' + "次。");
                    count = Number('${weiXinLuckDrawPo.wcjspersonnumber}');
                    clearInterval(timer);
                    return
                }
                if (data.error == "invalid2") {
                	alert("今日抽奖次数已经超过" + '${weiXinLuckDrawPo.wcjsdaynumber}' + "次。");
                    count = Number('${weiXinLuckDrawPo.wcjspersonnumber}');
                    clearInterval(timer);
                    return
                }
                if (data.error == "getsn") {
                	alert("您的中奖次数已经超过" + '${weiXinLuckDrawPo.wcjspersonlucknumber}' + "次。");
                    count = Number('${weiXinLuckDrawPo.wcjspersonnumber}');
                    clearInterval(timer);
                    return
                }
                if (data.success) {
                    prize = data.prizetype;
                    sncode = data.sn;
                    start(prizeDeg[data.prizetype - 1]);
                } else {
                    prize = null;
                    prizecount = 0;
                    start()
                }
                running = false;
                count++
            },
            error: function() {
                prize = null;
                start();
                running = false;
                count++
            },
            timeout: 4000
        })
    })
});
$("#save-btn").bind("click",
function() {
    var btn = $(this);
    var tel = $("#tel").val();
    if (tel == '') {
        alert("请输入手机号码");
        return
    }
    var regu = /^[1][0-9]{10}$/;
    var re = new RegExp(regu);
    if (!re.test(tel)) {
        alert("请输入正确手机号码");
        return
    }
    var submitData = {
        tid: 5,
        code: $("#sncode").text(),
        tel: tel,
        action: "setTel"
    };

    $.post('insertWeiXinLuckDraw.action?openID=${openID}&memberPhone='+$('#tel').val()+'&prize='+prize,
	    function(data) {
	        alert("提交成功，谢谢您的参与!");
	        $("#prizetype").text("");
	        $("#tel").val("");
	        $("#result").slideToggle(0);
	        $("#outercont").slideToggle(500);
	        $("#luckDrawTab").html(data);
	        return;
	    },
	    "text");
   
});

document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideOptionMenu');
});

</script>

</form>
</body></html>