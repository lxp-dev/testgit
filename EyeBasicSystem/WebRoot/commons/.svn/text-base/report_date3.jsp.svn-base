<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<script>
    function currtMonth2(bgnDate,endDate){
    	document.getElementById(bgnDate).value = '${tBgnDate }';
    	document.getElementById(endDate).value = '${tEndDate}';
    }
</script>


	  <li class="horizontal_onlyRight">
	    <input id="${param.fromDate}"
	    name="${param.fromDate}" 
	    type="hidden" class="text_input80" 
	    onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'${param.toDate}\')}'})"
	    value="${startTime }" />  
	    <input id="${param.toDate}"
	    name="${param.toDate}" 
	    type="text" class="text_input120" 
	    onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'${param.toDate}\')}'})"
	     value="${endTime}" />     
	    </li>



