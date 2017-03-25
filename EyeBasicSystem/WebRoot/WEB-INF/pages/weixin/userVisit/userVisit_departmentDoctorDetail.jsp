<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/weixincommons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家介绍</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
</head>
<script>
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    	WeixinJSBridge.call('hideOptionMenu');
    });

	function yuyue(){
		<c:choose>
			<c:when test="${yuyueKey eq 'false' }">
				alert("请先注册成会员，再进行预约！");
			</c:when>
			<c:otherwise>
				if($('#openID').val() ==''){
					alert("参数错误，请从菜单重新进入！");
				}else{
					location.href="initInsertWeiXinOptometryAppointmentPo.action?openID="+$('#openID').val();		
				}	
			</c:otherwise>
		</c:choose>
		
	}

	function addContent(str,str2){
		var content = $("#wdacontent").val();
		content = content.replace(str2, "");
		
		if(str=='1'){
			if($("#kuaijie1").attr('class')=='z05'){
				$("#kuaijie1").attr("class", "z04");
				$("#wdacontent").val($("#wdacontent").val()+str2);
			}else{
				$("#kuaijie1").attr("class", "z05")
				$("#wdacontent").val(content);
			}
		}else if(str=='2'){	
			if($("#kuaijie2").attr('class')=='z05'){
				$("#kuaijie2").attr("class", "z04");
				$("#wdacontent").val($("#wdacontent").val()+str2);
			}else{
				$("#kuaijie2").attr("class", "z05")
				$("#wdacontent").val(content);
			}
		}else if(str=='3'){	
			if($("#kuaijie3").attr('class')=='z05'){
				$("#kuaijie3").attr("class", "z04");
				$("#wdacontent").val($("#wdacontent").val()+str2);
			}else{
				$("#kuaijie3").attr("class", "z05")
				$("#wdacontent").val(content);
			}
		}else if(str=='4'){	
			if($("#kuaijie4").attr('class')=='z05'){
				$("#kuaijie4").attr("class", "z04");
				$("#wdacontent").val($("#wdacontent").val()+str2);
			}else{
				$("#kuaijie4").attr("class", "z05")
				$("#wdacontent").val(content);
			}
		}else if(str=='5'){	
			if($("#kuaijie5").attr('class')=='z05'){
				$("#kuaijie5").attr("class", "z04");
				$("#wdacontent").val($("#wdacontent").val()+str2);
			}else{
				$("#kuaijie5").attr("class", "z05")
				$("#wdacontent").val(content);
			}
		}

	}

	function selectManyidu(str){
		$("#wdamanyidu").val(str);
		if(str=='1'){
			$("#manyidu1").attr("class", "p11");
			$("#manyidu2").attr("class", "p2"); 
			$("#manyidu3").attr("class", "p3");
		}else if(str=='2'){			
			$("#manyidu2").attr("class", "p21");
			$("#manyidu1").attr("class", "p1");
			$("#manyidu3").attr("class", "p3");
		}else if(str=='3'){
			$("#manyidu3").attr("class", "p31");
			$("#manyidu2").attr("class", "p2");
			$("#manyidu1").attr("class", "p1");
		}
	}


	function save(){
		if(checkForm(document.all.doctorAppraisalForm)){ 			
			$("img").removeAttr("onclick");
			doctorAppraisalForm.action = "insertDoctorAppraisal.action";
			doctorAppraisalForm.submit();
		}
	}	
</script>
<body class="bg_color" ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="doctorAppraisalForm" name="doctorAppraisalForm" method="post" action="">
<input name="openID" id="openID" type="hidden" value="${openID}" readonly="readonly"/>
<input name="weiXinDoctorAppraisalPo.wdainspectionid" id="wdainspectionid" type="hidden" value="${inspectionPo.sopipid}" readonly="readonly"/>
<input name="weiXinDoctorAppraisalPo.wdacustomerid" id="wdacustomerid" type="hidden" value="${customerid}" readonly="readonly"/>
<input name="weiXinDoctorAppraisalPo.wdadoctorid" id="wdadoctorid" type="hidden" value="${weiXinDoctorPo.wdpersonid}" readonly="readonly"/>

	<div class="xf_canting xf_panle">
		<!-- 专家介绍 -->
		<div class="xf_ctinner ">
			<span class="h3bg "></span>
			<!--栏目1 -->
			<div class="zjjs pt1">
				<ul>
					<li>
						<c:choose>
							<c:when test="${weiXinDoctorPo.wdpicurl ne ''}">
								<img src="${ctx }${weiXinDoctorPo.wdpicurl}" alt=""/>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${weiXinDoctorPo.wdsex eq '1'}">
										<img src="${ctx}/weixin_personcenter/default_images/sex1.png" alt="" />
									</c:when>
									<c:when test="${weiXinDoctorPo.wdsex eq '2'}">
										<img src="${ctx}/weixin_personcenter/default_images/sex2.png" alt="" />
									</c:when>
								</c:choose>							
							</c:otherwise>
						</c:choose>						
					</li>
					<li class="zjjs2">
						<span><i>${weiXinDoctorPo.wdname}</i>&nbsp;<b>${weiXinDoctorPo.wdzhicheng}</b></span>
						<span>${weiXinDoctorPo.wdzhiwu}</span>
						<span><var>好评率：<a>
						<c:choose>
                       		<c:when test="${weiXinDoctorPo.wdhaopinglv eq '-1'}">
                       			暂无评价
                       		</c:when>
                       		<c:otherwise>
                       			${weiXinDoctorPo.wdhaopinglv}%
                       		</c:otherwise>
                       	</c:choose>
						</a></var></span>
						<input class="zjjsa " type="button" value="我要预约" onclick="yuyue()">
						
					</li>
					<li>
						<p>${weiXinDoctorPo.wdcontent}
							<b>
								<c:choose>
									<c:when test="${!empty weiXinDoctorPo.wdworkday}">
										出诊时间：<font color="red" size="3">
										<c:set value="${ fn:split(weiXinDoctorPo.wdworkday, ',') }" var="workdays" />
										<c:forEach items="${ workdays }" var="name" varStatus="status">
											<c:if test="${status.index ne '0'}">
											、
											</c:if>
											<c:choose>
												<c:when test="${name eq '1'}">
													周一
												</c:when>
												<c:when test="${name eq '2'}">
													周二
												</c:when>
												<c:when test="${name eq '3'}">
													周三
												</c:when>
												<c:when test="${name eq '4'}">
													周四
												</c:when>
												<c:when test="${name eq '5'}">
													周五
												</c:when>
												<c:when test="${name eq '6'}">
													周六
												</c:when>
												<c:when test="${name eq '0'}">
													周日
												</c:when>																																																																								
											</c:choose>
										</c:forEach>
									</c:when>
									<c:otherwise>
										暂无出诊时间
									</c:otherwise>
								</c:choose>
								</font>
							</b>
						</p>
					</li>
					<c:choose>
					<c:when test="${pingjiaType eq '2'}">
						<c:if test="${!empty inspectionPo.sopipid}">
						<li class="zjjs3">
							<a id="manyidu3" class="p3" onclick="selectManyidu('3')">非常满意</a>
							<a id="manyidu2" class="p2" onclick="selectManyidu('2')">满意</a>
							<a id="manyidu1" class="p1" onclick="selectManyidu('1')">不满意</a>
					    	<input name="weiXinDoctorAppraisalPo.wdamanyidu" id="wdamanyidu" type="hidden" value="" readonly="readonly"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择满意度！'}]"/> 
						</li>
						<li class="zjjs3">
							<i class="z05" id="kuaijie1" onclick="addContent('1',' 态度很好 ');">态度很好</i>
							<i class="z05" id="kuaijie2" onclick="addContent('2',' 很敬业 ');">很敬业</i>
							<i class="z05" id="kuaijie3" onclick="addContent('3',' 非常清楚 ');">非常清楚</i></br>
							<i class="z05" id="kuaijie4" onclick="addContent('4',' 非常专业认真 ');">非常专业认真</i>
							<i class="z05" id="kuaijie5" onclick="addContent('5',' 意见很有帮助 ');">意见很有帮助</i>
						</li>
						<li class="zjjs4">
							<textarea rows="4" cols="42" placeholder="输入您的留言" id="wdacontent" name="weiXinDoctorAppraisalPo.wdacontent" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [201]}, 'Message' : '评价内容不能大于200字！'}]">${weiXinDoctorAppraisalPo.wdacontent}</textarea>
							<input class="zjjs5" type="button" value="发表评价" onclick="save()">
						</li>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${isOK eq 0}">
								<c:if test="${!empty inspectionPo.sopipid}">
								<li class="zjjs3">
									<a id="manyidu3" class="p3" onclick="selectManyidu('3')">非常满意</a>
									<a id="manyidu2" class="p2" onclick="selectManyidu('2')">满意</a>
									<a id="manyidu1" class="p1" onclick="selectManyidu('1')">不满意</a>
							    	<input name="weiXinDoctorAppraisalPo.wdamanyidu" id="wdamanyidu" type="hidden" value="" readonly="readonly"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择满意度！'}]"/> 
								</li>
								<li class="zjjs3">
									<i class="z05" id="kuaijie1" onclick="addContent('1',' 态度很好 ');">态度很好</i>
									<i class="z05" id="kuaijie2" onclick="addContent('2',' 很敬业 ');">很敬业</i>
									<i class="z05" id="kuaijie3" onclick="addContent('3',' 非常清楚 ');">非常清楚</i></br>
									<i class="z05" id="kuaijie4" onclick="addContent('4',' 非常专业认真 ');">非常专业认真</i>
									<i class="z05" id="kuaijie5" onclick="addContent('5',' 意见很有帮助 ');">意见很有帮助</i>
								</li>
								<li class="zjjs4">
									<textarea rows="4" cols="42" placeholder="输入您的留言" id="wdacontent" name="weiXinDoctorAppraisalPo.wdacontent" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [201]}, 'Message' : '评价内容不能大于200字！'}]">${weiXinDoctorAppraisalPo.wdacontent}</textarea>
									<input class="zjjs5" type="button" value="发表评价" onclick="save()">
								</li>
								</c:if>
							</c:when>
						  	<c:otherwise>
						  		<c:if test="${!empty inspectionPo.sopipid}">
								<li>
									<p></br>您已经对本次检查做出过评价！</p>
								</li>
								</c:if>
						  	</c:otherwise>						
						</c:choose>
					</c:otherwise>
				  </c:choose>					
					<li class="zjjs7" >
						历史评价（${appraisalCount }）
					</li>
					<c:forEach var="po" items="${weiXinDoctorAppraisalPoList}" varStatus="poIndex">
					<li class="zjjs6">
						<span>
							<img src="${ctx}/weixin/images/doctors/persondefault.png" alt="" />
							
							<i class="zjjs3">
							${po.wdacustomername}
							</i>
						</span>
						<p>						
						${po.wdacontent }
						</p>
						<a>${fn:substring(po.wdacreatetime,0,16)}</a>
					</li>
					</c:forEach>
					</ul>
				</div>
				<!--栏目1结束 -->

			</div>
			<!-- 专家介绍结束 -->
		</div>
</form>
</body></html>