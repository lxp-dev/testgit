<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<script>
    function currtMonth2(bgnDate,endDate){
    	document.getElementById(bgnDate).value = '${tBgnDate }';
    	document.getElementById(endDate).value = '${tEndDate}';
    }
</script>

<c:if test="${permissionPo.keyb eq '1'}">
	<c:if test="${systemParameterPo.fspreportdateflag eq '1'}">
	    ${tBgnDate }&nbsp;至&nbsp;${tEndDate}  	
		<input type="hidden" id="${param.fromDate}" name="startTime" value="${tBgnDate }">
	    <input type="hidden" id="${param.toDate}" name="endTime" value="${tEndDate}">
	</c:if>
	<c:if test="${systemParameterPo.fspreportdateflag eq '2' || systemParameterPo.fspreportdateflag eq '3' }">
	  <li class="horizontal_onlyRight">
	    <input id="${param.fromDate}" bgn=bgn 
	    name="startTime" 
	    type="text" class="text_input100" 
	    onFocus="WdatePicker({isShowClear:false,isShowToday:false,readOnly:true, minDate:'#F{$dp.$D(\'tBgnDate\')}', maxDate:'#F{$dp.$D(\'endTime\')}'})"
	    value="${tBgnDate }" /> 至 
	    <input id="${param.toDate}" end=end 
	    name="endTime" 
	    type="text" class="text_input100" 
	    onfocus="WdatePicker({isShowClear:false,isShowToday:false,readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}', maxDate:'#F{$dp.$D(\'tEndDate\')}'})" 
	     value="${tEndDate}" />     
	    </li>
	    
	    <input type="hidden" id="tBgnDate" name="tBgnDate" value="${tBgnDate }">
	    <input type="hidden" id="tEndDate" name="tEndDate" value="${tEndDate}">
	
	</c:if>
	<c:if test="${systemParameterPo.fspreportdateflag eq '3'}">
	    <li class="horizontal_onlyRight">
	       <img btn=btn src="${ctx }/img/newbtn/btn_mrrq_0.png" title="默认日期" onClick="currtMonth2('${param.fromDate}','${param.toDate}')">
	    </li>
	</c:if>	
	<c:if test="${systemParameterPo.fspreportdateflag eq '2'}">
	    <li class="horizontal_onlyRight">
	       <img btn=btn src="${ctx }/img/newbtn/btn_mrrq_0.png" title="默认日期" onClick="currtMonth2('${param.fromDate}','${param.toDate}')">
	    </li>
	</c:if>	
</c:if>

<c:if test="${permissionPo.keyb != '1'}">
	  <li class="horizontal_onlyRight">
	    <input id="${param.fromDate}"
	    name="startTime" 
	    type="text" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取查询起始日期!'}]" noValidate="noValidate" 
	    onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
	    value="${startTime }" /> 至 
	    <input id="${param.toDate}"
	    name="endTime" 
	    type="text" class="text_input100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取查询截止日期!'}]" noValidate="noValidate" 
	    onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
	     value="${endTime}" />     
	    </li>

	    <li class="horizontal_onlyRight">
	       <img btn=btn src="${ctx }/img/newbtn/btn_mrrq_0.png" title="默认日期" onClick="currtMonth2('${param.fromDate}','${param.toDate}')">
	    </li>
	    
</c:if>
