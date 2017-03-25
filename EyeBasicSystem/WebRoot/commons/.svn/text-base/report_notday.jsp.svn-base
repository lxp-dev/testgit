<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

   <input id="${param.fromDate}"
   name="startTime" 
   type="text" class="text_input100" 
    onFocus="WdatePicker({isShowToday:false,readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')||$dp.$D(\'tBgnDate\')}'})"/> 至 
   <input id="${param.toDate}"
   name="endTime" 
   type="text" class="text_input100" 
   onfocus="WdatePicker({isShowToday:false,readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}', maxDate:'#F{$dp.$D(\'tEndDate\')}'})"/>
    
   <input type="hidden" id="tBgnDate" name="tBgnDate" value="${tBgnDate }">
   <input type="hidden" id="tEndDate" name="tEndDate" value="${tEndDate}">

