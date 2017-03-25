<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>最新诊疗信息</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />

<script>    
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    }); 

    function getRTime(){
        var str= '${inspectionPo.sopipseccheckdate }';
        var EndTime = new Date(str.replace(/-/g,   "/"));
        var NowTime = new Date();
        var t =EndTime.getTime() - NowTime.getTime();
        /*var d=Math.floor(t/1000/60/60/24);
        t-=d*(1000*60*60*24);
        var h=Math.floor(t/1000/60/60);
        t-=h*60*60*1000;
        var m=Math.floor(t/1000/60);
        t-=m*60*1000;
        var s=Math.floor(t/1000);*/

        var d=Math.floor(t/1000/60/60/24);
        var h=Math.floor(t/1000/60/60%24);
        var m=Math.floor(t/1000/60%60);
        var s=Math.floor(t/1000%60);

        if(t<0){
        	document.getElementById("t_d").innerHTML = "复诊时间已过！";
        }else{
            document.getElementById("t_d").innerHTML = d + "天";
            document.getElementById("t_h").innerHTML = h + "时";
            document.getElementById("t_m").innerHTML = m + "分";
            document.getElementById("t_s").innerHTML = s + "秒";
        }

    }
    setInterval(getRTime,1000);

    function dianping(){
    	location.href="initInsertDoctorAppraisal.action?openID="+$('#openID').val() +"&hid="+$('#hid').val() +"&sopipid="+$('#sopipid').val(); 
    }
</script>
</head>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<input name="sopipid" id="sopipid" type="hidden" value="${inspectionPo.sopipid}" readonly="readonly"/>
<input name="hid" id="hid" type="hidden" value="${inspectionPo.sopipusername}" readonly="readonly"/>

<div class="loading"></div>
	<div class="xf_canting xf_panle">
	<c:choose>
    	<c:when test="${!empty inspectionPo.sopipcustomerid}">
<!-- 最新诊疗信息 -->
		<div class="xf_ctinner p1rm">
			<div class=" zxzl">
				<ul>
					<li>
						<span class="zxzl1 ">矫治方案：</span>
					</li>
					<li class="lxwm2">
							<c:if test="${inspectionPo.sopipglasstypes ne ''}">
							框架眼镜：
								<c:set value="${ fn:split(inspectionPo.sopipglasstypes, ',') }" var="str" />
								<c:forEach items="${ str }" var="s">
									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}">
										<c:if test="${(fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='48')}">
					                   		${optionParamPoTmp.fopparamname} 
					                   	</c:if>
									</c:forEach>
								</c:forEach>
								</br>
							</c:if>
							<c:if test="${inspectionPo.sopiptouchglass ne ''}">
								角膜接触镜：
								<c:set value="${ fn:split(inspectionPo.sopiptouchglass, ',') }" var="str" />
								<c:forEach items="${ str }" var="s">
									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}">
										<c:if test="${(fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='49')}">
					                   		${optionParamPoTmp.fopparamname} 
					                   	</c:if>
									</c:forEach>
								</c:forEach>
								</br>
							</c:if>
							<c:if test="${inspectionPo.sopiptraintypes ne ''}">
								视觉训练：
								<c:set value="${ fn:split(inspectionPo.sopiptraintypes, ',') }" var="str" />
								<c:forEach items="${ str }" var="s">
									<c:forEach var="optionParamPoTmp" items="${optionParamPolist}">
										<c:if test="${(fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)) && (optionParamPoTmp.fopparentid=='50')}">
					                   		${optionParamPoTmp.fopparamname} 
					                   	</c:if>
									</c:forEach>
								</c:forEach>
							</c:if>
					</li>
					<li>
						<span class="zxzl1 ">医生叮嘱：</span>
					</li>
					<li class="lxwm2">
							${inspectionPo.sopipdoctorsay }
					</li>					
					<li>
						<span class="zxzl2 ">主管医生/视光师：</span>
					</li>
					<li class="lxwm2">
							${inspectionPo.sopipersonname }
					</li>					
				</ul>
			</div>
			<div class="zxan">
				<c:if test="${!empty inspectionPo.sopipersonname}">
					<input class="zxanz zxzl1" type="button" value="我点评" onclick="dianping();"/>
				</c:if>
				<input class="zxanr zxzl1" type="button" value="我咨询" onclick="zixun();"/>
			</div>
			<c:if test="${!empty inspectionPo.sopipseccheckdate}">
			<p class="zxfc">
				<span>复查时间：${inspectionPo.sopipseccheckdate }</span>
				距您下次复查时间还剩：<i id="t_d"></i><i id="t_h"></i><i id="t_m"></i><i id="t_s"></i>
			</p>
			</c:if> 
		</c:when>   		
 	    <c:otherwise>
 	    <!-- 弹出ERROR1 -->
    		<div class="bg01">
		      <div class="qrdh wxtc2 yq">
		        <img src="${ctx}/weixin_personcenter/images/wx2.png" alt="" />
		        <p>暂无最新诊疗信息！</p>
		        <input class="wxyya zxzl1" type="button" value="确 定" onclick="history.go(-1);">
		      </div>
		    </div>
		    <!-- 弹出结束 -->
		</c:otherwise>
    </c:choose>
		</div>
		<!-- 最新诊疗信息结束 -->
		<%@ include file="/weixin_personcenter/bottom.jsp" %>
	</div>
</body>
</html>