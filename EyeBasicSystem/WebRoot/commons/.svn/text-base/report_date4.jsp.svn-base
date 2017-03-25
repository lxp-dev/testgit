<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<script>
    function currtMonth2(bgnDate,endDate){
    	document.getElementById(bgnDate).value = '${tBgnDate }';
    	document.getElementById(endDate).value = '${tEndDate}';
    	var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
    	if('${tEndDate}'>now){
    		document.getElementById(endDate).value=now;
        }
    }
</script>

<c:if test="${permissionPo.keyb eq '1'}">
	<c:if test="${systemParameterPo.fspreportdateflag eq '1'}">
	    ${tBgnDate }&nbsp;至&nbsp;${tEndDate}  	
		<input type="hidden" id="${param.fromDate}" name="${param.fromDate}" value="${tBgnDate }">
	    <input type="hidden" id="${param.toDate}" name="${param.toDate}" value="${tEndDate}">
	</c:if>
	<c:if test="${systemParameterPo.fspreportdateflag eq '2' || systemParameterPo.fspreportdateflag eq '3' }">
	  <li class="horizontal_onlyRight">
	    <input id="${param.fromDate}" bgn=bgn 
	    name="${param.fromDate}" 
	    type="text" class="text_input80" 
	    onFocus="WdatePicker({isShowClear:false,isShowToday:false,readOnly:true, minDate:'#F{$dp.$D(\'tBgnDate\')}', maxDate:'#F{$dp.$D(\'${param.toDate}\')||$dp.$D(\'tEndDate\')}'})"
	     /> 至 
	    <input id="${param.toDate}" end=end 
	    name="${param.toDate}" 
	    type="text" class="text_input80" 
	    onfocus="WdatePicker({isShowClear:false,isShowToday:false,readOnly:true, minDate:'#F{$dp.$D(\'${param.fromDate}\')||$dp.$D(\'tBgnDate\')}', maxDate:'#F{$dp.$D(\'tEndDate\')}'})" 
	     />     
	    </li>
	    
	    <input type="hidden" id="tBgnDate" name="tBgnDate" value="${tBgnDate }">
	    <input type="hidden" id="tEndDate" name="tEndDate" value="${tEndDate}">
	
	</c:if>

</c:if>

<c:if test="${permissionPo.keyb != '1'}">
	  <li class="horizontal_onlyRight">
	    <input id="${param.fromDate}"
	    name="${param.fromDate}" 
	    type="text" class="text_input80" 
	    onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'${param.toDate}\')}'})"
	    value="${startTime }" /> 至 
	    <input id="${param.toDate}"
	    name="${param.toDate}" 
	    type="text" class="text_input80" 
	    onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'${param.fromDate}\')}'})" 
	     value="${endTime}" />     
	    </li>

	    
</c:if>
