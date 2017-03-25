<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>复查提醒</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });   

    function count_down(o,showKey){

        var www_qsyz_net=/^[\d]{4}-[\d]{1,2}-[\d]{1,2}( [\d]{1,2}:[\d]{1,2}(:[\d]{1,2})?)?$/ig,str='',conn,s;
       // if(!o.match(www_qsyz_net)){
       //         alert('参数格式为2012-01-01[ 01:01[:01]].\r其中[]内的内容可省略');
       //         return false;
       // }
        var sec=(new Date(o.replace(/-/ig,'/')).getTime() - new Date().getTime())/1000;
        if(sec > 0){
                conn='复查时间还剩：';
        }else{
                conn='复查时间已过！';
                //sec*=-1;
        }
        s={'天':sec/24/3600,'小时':sec/3600%24,'分':sec/60%60,'秒':sec%60};
        for(i in s){
                if(Math.floor(s[i])>0 ) str += Math.floor(s[i]) + i;
        }
        if(Math.floor(sec)==0){ str='0秒'; }
        document.getElementById(showKey).innerHTML = conn +'<i>' + str + '</i>';
        setTimeout(function(){count_down(o,showKey)},1000);
	}

    function getTimeStart(){
        <c:forEach var="po1" items="${list1}" varStatus="poIndex">
    		<c:forEach var="po11" items="${list11}" varStatus="poIndex">
    			<c:if test="${(po1.smecicustomerid eq po11.sopipcustomerid)&&(po11.sopipcustomerid ne '')}">
    				count_down("${po11.sopipseccheckdate}","show${po11.sopipcustomerid}");
    			</c:if>
    		</c:forEach>
    	</c:forEach> 
        <c:forEach var="po2" items="${list2}" varStatus="poIndex">
    		<c:forEach var="po22" items="${list22}" varStatus="poIndex">
    			<c:if test="${(po2.smecicustomerid eq po22.sopipcustomerid)&&(po22.sopipcustomerid ne '')}">
    				count_down("${po22.sopipseccheckdate}","show${po22.sopipcustomerid}");
    			</c:if>
    		</c:forEach>   
    	</c:forEach> 	
    }

    setInterval(getTimeStart,1000);
</script>

</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<c:set value="0" var="num1"></c:set>  
<div class="loading"></div>
	<div class="xf_canting xf_panle">
		<!-- 复查提醒 -->
		<div class="xf_ctinner">
			<div class="fctx">
				<ul>
				<c:forEach var="po1" items="${list1}" varStatus="poIndex">
					<c:forEach var="po11" items="${list11}" varStatus="poIndex">
					<c:if test="${(po1.smecicustomerid eq po11.sopipcustomerid)&&(po11.sopipcustomerid ne '')}">
					<li>
						<img class="ico_tx1" src="${ctx}/weixin_personcenter/images/ico_tx1.png" alt="">
						<span class="fcwz">
							<b>${po1.smeciname }</b>
							<span style="color: red;">复查时间：${po11.sopipseccheckdate }</span>
							<span style="color: red;" id="show${po11.sopipcustomerid}">&nbsp;</span>
						</span>
					</li>
					 <c:set value="${num1 + 1}" var="num1" />
					</c:if>
					</c:forEach>
				</c:forEach>
				<c:forEach var="po2" items="${list2}" varStatus="poIndex">
					<c:forEach var="po22" items="${list22}" varStatus="poIndex">
					<c:if test="${(po2.smecicustomerid eq po22.sopipcustomerid)&&(po22.sopipcustomerid ne '')}">
					<li>
						<img  class="ico_tx1" src="${ctx}/weixin_personcenter/images/ico_tx1.png" alt="">
						<span class="fcwz">
							<b>${po2.smeciname }</b>
							<span style="color: red;">复查时间：${po22.sopipseccheckdate }</span>
							<span style="color: red;" id="show${po22.sopipcustomerid}">&nbsp;</span>
						</span>
					</li>
					<c:set value="${num1 + 1}" var="num1" />
					</c:if>
					</c:forEach>
				</c:forEach>				
				</ul>
			</div>
		<c:if test="${num1 == 0}">
			<!-- 弹出ERROR1 -->
    		<div class="bg01">
		      <div class="qrdh wxtc2 yq">
		        <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
		        <p>暂无复查记录！</p>
		        <input class="wxyya zxzl1" type="button" value="确 定" onclick="history.go(-1);">
		      </div>
		    </div>
		    <!-- 弹出结束 -->
		</c:if>
		</div>
		<!-- 复查提醒结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>