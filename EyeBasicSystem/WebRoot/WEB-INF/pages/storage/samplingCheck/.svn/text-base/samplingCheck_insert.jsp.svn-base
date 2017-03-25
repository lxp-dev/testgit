<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加工检验管理</title>

<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
</head>
<script>
	$(document).ready(function (){
		jassignmentZT();
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#cjjg1').hide();
    	$('#cjjg2').hide();
	});
	
	function jassignmentZT(){
		if($('#jpchckcokeballglassod').text()!=''&&$('#jpchckcokepostglassod').text()!=''&&$('#jpchckcokeaxesod').text()!=''){
			$('#jpchckcokeballglassod2').text((parseFloat($('#jpchckcokeballglassod').text())+parseFloat($('#jpchckcokepostglassod').text())).toFixed(2));
			$('#jpchckcokepostglassod2').text((parseFloat($('#jpchckcokepostglassod').text())-parseFloat($('#jpchckcokepostglassod').text())-parseFloat($('#jpchckcokepostglassod').text())).toFixed(2));
			$('#jpchckcokeaxesod2').text($('#jpchckcokeaxesod').text()<=90?parseFloat($('#jpchckcokeaxesod').text())+parseFloat(90):parseFloat($('#jpchckcokeaxesod').text())-parseFloat(90));
		}
			
		if($('#jpchckcokeballglassos').text()!=''&&$('#jpchckcokepostglassos').text()!=''&&$('#jpchckcokeaxesos').text()!=''){
			$('#jpchckcokeballglassos2').text((parseFloat($('#jpchckcokeballglassos').text())+parseFloat($('#jpchckcokepostglassos').text())).toFixed(2));
			$('#jpchckcokepostglassos2').text((parseFloat($('#jpchckcokepostglassos').text())-parseFloat($('#jpchckcokepostglassos').text())-parseFloat($('#jpchckcokepostglassos').text())).toFixed(2));
			$('#jpchckcokeaxesos2').text($('#jpchckcokeaxesos').text()<=90?parseFloat($('#jpchckcokeaxesos').text())+parseFloat(90):parseFloat($('#jpchckcokeaxesos').text())-parseFloat(90));
		}
		
		if(isNaN($('#jpchckcokeballglassod2').val())){
			$('#jpchckcokeballglassod2').val('');
		}
		
		if(isNaN($('#jpchckcokepostglassod2').val())){
			$('#jpchckcokepostglassod2').val('');
		}
		
		if(isNaN($('#jpchckcokeaxesod2').val())){
			$('#jpchckcokeaxesod2').val('');
		}
			
		if(isNaN($('#jpchckcokeballglassos2').val())){
			$('#jpchckcokeballglassos2').val('');
		}	
		
		if(isNaN($('#jpchckcokepostglassos2').val())){
			$('#jpchckcokepostglassos2').val('');
		}
		
		if(isNaN($('#jpchckcokeaxesos2').val())){
			$('#jpchckcokeaxesos2').val('');
		}
	}
	
	function doData(json){
		$('#jdjTable').find("input").val('');
		$('#pchckcokeballglassod').val(json.sphOD!='null'?parseFloat(json.sphOD).toFixed(2):'0.00');
		$('#pchckcokeballglassos').val(json.sphOS!='null'?parseFloat(json.sphOS).toFixed(2):'0.00');
		
		$('#pchckcokeballglassod2').val(json.sphOD!='null'?(parseFloat(json.sphOD)+parseFloat(json.cylOD)).toFixed(2):'0.00');
		$('#pchckcokeballglassos2').val(json.sphOS!='null'?(parseFloat(json.sphOS)+parseFloat(json.cylOS)).toFixed(2):'0.00');
		
		$('#pchckcokepostglassod').val(json.cylOD!='null'?parseFloat(json.cylOD).toFixed(2):'0.00');
		$('#pchckcokepostglassos').val(json.cylOS!='null'?parseFloat(json.cylOS).toFixed(2):'0.00');
		
		$('#pchckcokepostglassod2').val(json.cylOD!='null'?(parseFloat(json.cylOD)-parseFloat(json.cylOD)-parseFloat(json.cylOD)).toFixed(2):'0.00');
		$('#pchckcokepostglassos2').val(json.cylOS!='null'?(parseFloat(json.cylOS)-parseFloat(json.cylOS)-parseFloat(json.cylOS)).toFixed(2):'0.00');
		
		$('#pchckcokeaxesod').val(json.axisOD!='null'?parseFloat(json.axisOD):'0.00');
		$('#pchckcokeaxesos').val(json.axisOS!='null'?parseFloat(json.axisOS):'0.00');
		
		$('#pchckcokeaxesod2').val(json.axisOD!='null'?(parseFloat(json.axisOD)<=90?parseFloat(json.axisOD)+90:parseFloat(json.axisOD)-90):'0.00');
		$('#pchckcokeaxesos2').val(json.axisOS!='null'?(parseFloat(json.axisOS)<=90?parseFloat(json.axisOS)+90:parseFloat(json.axisOS)-90):'0.00');
		
		if(parseFloat(json.axisOD))
		
		$('#pchckcokeaddod').val(json.addOD!='null'?parseFloat(json.addOD):'0.00');
		$('#pchckcokeaddos').val(json.addOS!='null'?parseFloat(json.addOS):'0.00');
		$('#pchckcokepupildistanceod').val(json.rpd!='null'?parseFloat(json.rpd).toFixed(2):'0.00');
		$('#pchckcokepupildistanceos').val(json.lpd!='null'?parseFloat(json.lpd).toFixed(2):'0.00');
		
		if(json.prismOD1!='null'&&json.prismOD1!=null)
		{
			document.getElementById('pchckcokearriseglassod').value=parseFloat(json.prismOD1).toFixed(2);
		}
		if(json.prismOD2!='null'&&json.prismOD2!=null)
		{
			document.getElementById('pchckcokearriseglassod1').value=parseFloat(json.prismOD2).toFixed(2);
		}
		if(json.prismOS1!='null'&&json.prismOS1!=null)
		{
			document.getElementById('pchckcokestrabismusos').value=parseFloat(json.prismOS1).toFixed(2);
		}
		if(json.prismOS2!='null'&&json.prismOS2!=null)
		{
			document.getElementById('pchckcokestrabismusos1').value=parseFloat(json.prismOS2).toFixed(2);
		}
		if(json.baseOD1=='I') //根据设备水平垂直对应选择下拉列表的值。I=IN=内 O=OUT=外 D=DOWN=下 U=UP=上
		{
			document.getElementById('pchckcokebasisod').options[1].selected=true;
		}else if(json.baseOD1=='O')
		{
			document.getElementById('pchckcokebasisod').options[2].selected=true;
			
		}
		else if(json.baseOD1=='U')
		{
			document.getElementById('pchckcokebasisod').options[3].selected=true;
		}
		else if(json.baseOD1=='D')
		{
			document.getElementById('pchckcokebasisod').options[4].selected=true;
		}
		
		if(json.baseOD2=='I')
		{
			document.getElementById('pchckcokebasisod1').options[1].selected=true;
		}else if(json.baseOD2=='O')
		{
			document.getElementById('pchckcokebasisod1').options[2].selected=true;
		}
		else if(json.baseOD2=='U')
		{
			document.getElementById('pchckcokebasisod1').options[3].selected=true;
		}
		else if(json.baseOD2=='D')
		{
			document.getElementById('pchckcokebasisod1').options[4].selected=true;
		}
		
		
		if(json.baseOS1=='I')
		{
			document.getElementById('pchckcokebasisos').options[1].selected=true;
		}else if(json.baseOS1=='O')
		{
			document.getElementById('pchckcokebasisos').options[2].selected=true;
		}
		else if(json.baseOS1=='U')
		{
			document.getElementById('pchckcokebasisos').options[3].selected=true;
		}
		else if(json.baseOS1=='D')
		{
			document.getElementById('pchckcokebasisos').options[4].selected=true;
		}
		
		if(json.baseOS2=='I')
		{
			document.getElementById('pchckcokebasisos1').options[1].selected=true;
		}else if(json.baseOD2=='O')
		{
			document.getElementById('pchckcokebasisos1').options[2].selected=true;
		}
		else if(json.baseOS2=='U')
		{
			document.getElementById('pchckcokebasisos1').options[3].selected=true;
		}
		else if(json.baseOS2=='D')
		{
			document.getElementById('pchckcokebasisos1').options[4].selected=true;
		}
		
		//光心垂差,垂直向三棱镜之差
		var gxcc=0;
		if(json.baseOD2==json.baseOS2){
			gxcc=Math.abs(Subtr(json.prismOD2!='null'?json.prismOD2:'0.00',json.prismOS2!='null'?json.prismOS2:'0.00'));
		}else{
			gxcc=accAdd(json.prismOD2!='null'?json.prismOD2:'0.00',json.prismOS2!='null'?json.prismOS2:'0.00');
		}
		$('#pchckcokecentervertical').val(gxcc);
		$('#readBtn').removeAttr("disabled");
	}
	function assignmentZT(){
		if($('#pchckcokeballglassod').val()!=''&&$('#pchckcokepostglassod').val()!=''&&$('#pchckcokeaxesod').val()!=''){
			$('#pchckcokeballglassod2').val((parseFloat($('#pchckcokeballglassod').val())+parseFloat($('#pchckcokepostglassod').val())).toFixed(2));
			$('#pchckcokepostglassod2').val((parseFloat($('#pchckcokepostglassod').val())-parseFloat($('#pchckcokepostglassod').val())-parseFloat($('#pchckcokepostglassod').val())).toFixed(2));
			$('#pchckcokeaxesod2').val($('#pchckcokeaxesod').val()<=90?parseFloat($('#pchckcokeaxesod').val())+parseFloat(90):parseFloat($('#pchckcokeaxesod').val())-parseFloat(90));
		}
			
		if($('#pchckcokeballglassos').val()!=''&&$('#pchckcokepostglassos').val()!=''&&$('#pchckcokeaxesos').val()!=''){
			$('#pchckcokeballglassos2').val((parseFloat($('#pchckcokeballglassos').val())+parseFloat($('#pchckcokepostglassos').val())).toFixed(2));
			$('#pchckcokepostglassos2').val((parseFloat($('#pchckcokepostglassos').val())-parseFloat($('#pchckcokepostglassos').val())-parseFloat($('#pchckcokepostglassos').val())).toFixed(2));
			$('#pchckcokeaxesos2').val($('#pchckcokeaxesos').val()<=90?parseFloat($('#pchckcokeaxesos').val())+parseFloat(90):parseFloat($('#pchckcokeaxesos').val())-parseFloat(90));
		}
		
		if(isNaN($('#pchckcokeballglassod2').val())){
			$('#pchckcokeballglassod2').val('');
		}
		
		if(isNaN($('#pchckcokepostglassod2').val())){
			$('#pchckcokepostglassod2').val('');
		}
		
		if(isNaN($('#pchckcokeaxesod2').val())){
			$('#pchckcokeaxesod2').val('');
		}
			
		if(isNaN($('#pchckcokeballglassos2').val())){
			$('#pchckcokeballglassos2').val('');
		}	
		
		if(isNaN($('#pchckcokepostglassos2').val())){
			$('#pchckcokepostglassos2').val('');
		}
		
		if(isNaN($('#pchckcokeaxesos2').val())){
			$('#pchckcokeaxesos2').val('');
		}
	}
	
	
	function READ(){
		document.apparatus.strTest('fghfgh');
		$('#readBtn').attr("disabled","disabled");
	}
	
	function lastcopy(id){
		var istest = window.confirm("此功能只限空转时使用，其他情况慎用！");
		
		if(istest==true){
		
		$('input[name=workingCheckPo.pchckcokeballglassod]').val(${ workingCheckPo.pchckcokeballglassod});	
		$('input[name=workingCheckPo.pchckcokepostglassod]').val(${ workingCheckPo.pchckcokepostglassod});
		$('input[name=workingCheckPo.pchckcokeaxesod]').val(${ workingCheckPo.pchckcokeaxesod});
		$('input[name=workingCheckPo.pchckcokeaddod]').val(${workingCheckPo.pchckcokeaddod });
		$('input[name=workingCheckPo.pchckcokepupildistanceod]').val(${workingCheckPo.pchckcokepupildistanceod });
			
		$('input[name=workingCheckPo.pchckcokeballglassos]').val(${ workingCheckPo.pchckcokeballglassos});
		$('input[name=workingCheckPo.pchckcokepostglassos]').val(${ workingCheckPo.pchckcokepostglassos});
		$('input[name=workingCheckPo.pchckcokeaxesos]').val(${workingCheckPo.pchckcokeaxesos });
		$('input[name=workingCheckPo.pchckcokeaddos]').val(${workingCheckPo.pchckcokeaddos });
		$('input[name=workingCheckPo.pchckcokepupildistanceos]').val(${workingCheckPo.pchckcokepupildistanceos });
		assignmentZT();
		}else{
			return;
		}	
	}	
	function insert(){
		
			$("img").removeAttr("onclick");
			workingCheckInsertForm.action = "insertSamplingCheck.action";
			workingCheckInsertForm.submit();
	}		
	/*
		取绝对值
	*/
	function absSelf(temp){
		if(temp<0){
			return accAdd(0,'-'+temp);
		}else{
			return temp;
		}
	}
	function permissionMessage(){
       alert('您无此操作权限');
	}
	var sphodmis='${odMisPo.fmtodsphmistake}';
	var sphosmis='${osMisPo.fmtossphmistake}';
	var cylodmis='${odMisPo.fmtodcylmistake}';
	var cylosmis='${osMisPo.fmtoscylmistake}';
	var axesodmis='${odMisPo.fmtodaxesmistake}';
	var axesosmis='${osMisPo.fmtosaxesmistake}';
	var addodmis='${odMisPo.fmtodaddmistake}';
	var addosmis='${osMisPo.fmtosaddmistake}';
	var tjodmis='${odMisPo.fmtodtjmistake}';
	var tjosmis='${osMisPo.fmtostjmistake}';
	var odscmistake=parseFloat('${odMisPo.fmtodsphandcylmistake}');
	var osscmistake=parseFloat('${osMisPo.fmtossphandcylmistake}');
	//if(odscmistake<parseFloat(sphodmis)){
	//	sphodmis=odscmistake;
	//}
	//if(osscmistake<parseFloat(sphosmis)){
	//	sphosmis=osscmistake;
	//}
	var addod='${oDPo.ssesbaddod}'==''?'0.00':'${oDPo.ssesbaddod}';
	var addos='${oSPo.ssesbaddos}'==''?'0.00':'${oSPo.ssesbaddos}';
	var axesod='${oDPo.ssesbaxesod}'==''?'0.00':'${oDPo.ssesbaxesod}';
	var axesos='${oSPo.ssesbaxesos}'==''?'0.00':'${oSPo.ssesbaxesos}';;
	var sphod='${oDPo.ssesbballglassod}';
	var sphos='${oSPo.ssesbballglassos}';
	var cylod='${oDPo.ssesbpostglassod}';
	var cylos='${oSPo.ssesbpostglassos}';
	var tjod='${oDPo.ssesbinterhighod}';
	var tjos='${oSPo.ssesbinterhighos}';
	var tjod2='${oDPo.ssesbinterdistanceod}';
	var tjos2='${oSPo.ssesbinterdistanceos}';
	var type='${oDPo.ssesbrecipetype}';
	function check(){
		//右眼瞳距
		if(!isNaN($('#pchckcokepupildistanceod').val())){
			if(type=='1'){
				if(Math.abs(accAdd(tjod,'-'+$('#pchckcokepupildistanceod').val()))>parseFloat(tjodmis)/2||$('#pchckcokepupildistanceod').val().trim()==''){
					$('#pchckcokepupildistanceod').focus();
					$('#pchckcokepupildistanceod').attr("style","background-color: red");
				}else{
					$('#pchckcokepupildistanceod').attr("style","background-color: green");
				}
			}else if(type=='2'){
				if(Math.abs(accAdd(tjod2,'-'+$('#pchckcokepupildistanceod').val()))>parseFloat(tjodmis)||$('#pchckcokepupildistanceod').val().trim()==''){
					$('#pchckcokepupildistanceod').focus();
					$('#pchckcokepupildistanceod').attr("style","background-color: red");
				}else{
					$('#pchckcokepupildistanceod').attr("style","background-color: green");
				}
			}else if(type=='3'){
				if(Math.abs(accAdd(tjod,'-'+$('#pchckcokepupildistanceod').val()))>1||$('#pchckcokepupildistanceod').val().trim()==''){
					$('#pchckcokepupildistanceod').focus();
					$('#pchckcokepupildistanceod').attr("style","background-color: red");
				}else{
					$('#pchckcokepupildistanceod').attr("style","background-color: green");
				}
			}
		}		
		//左眼瞳距
		if(!isNaN($('#pchckcokepupildistanceos').val())){
			
			if(type=='1'){
				if(Math.abs(Subtr(tjos,$('#pchckcokepupildistanceos').val()))>parseFloat(tjosmis)/2||$('#pchckcokepupildistanceos').val().trim()==''){
					$('#pchckcokepupildistanceos').focus();
					$('#pchckcokepupildistanceos').attr("style","background-color: red");
				}else{
					$('#pchckcokepupildistanceos').attr("style","background-color: green");
				}
			}else if(type=='2'){
				if(Math.abs(accAdd(tjos2,'-'+$('#pchckcokepupildistanceos').val()))>parseFloat(tjosmis)||$('#pchckcokepupildistanceos').val().trim()==''){
					$('#pchckcokepupildistanceos').focus();
					$('#pchckcokepupildistanceos').attr("style","background-color: red");
				}else{
					$('#pchckcokepupildistanceos').attr("style","background-color: green");
				}
			}else if(type=='3'){
				if(Math.abs(accAdd(tjos,'-'+$('#pchckcokepupildistanceos').val()))>1||$('#pchckcokepupildistanceos').val().trim()==''){
					$('#pchckcokepupildistanceos').focus();
					$('#pchckcokepupildistanceos').attr("style","background-color: red");
				}else{
					$('#pchckcokepupildistanceos').attr("style","background-color: green");
				}
			}
		}else{
			$('#pchckcokepupildistanceos').focus();
			$('#pchckcokepupildistanceos').attr("style","background-color: red");
		}
		//判断垂差
		if(!isNaN($('#pchckcokecentervertical').val())&&$('#pchckcokecentervertical').val()!=''){
			if(parseFloat($('#pchckcokecentervertical').val())>parseFloat('${salesBasicPo.ssesblightvertical}'))
			{
				$('#pchckcokecentervertical').focus();
				$('#pchckcokecentervertical').attr("style","background-color: red");
			}else{
				$('#pchckcokecentervertical').attr("style","background-color: green");
			}
		}else{
			$('#pchckcokecentervertical').focus();
			$('#pchckcokecentervertical').attr("style","background-color: red");
		}
		/*
		球镜右眼
		*/
		if(!isNaN($('#pchckcokeballglassod').val())){
			if($('#pchckcokeballglassod').val().substring(0,1)==sphod.substring(0,1)||sphod.substring(0,1)=='+'){
				if(Math.abs(Subtr($('#pchckcokeballglassod').val(),sphod))>sphodmis||$('#pchckcokeballglassod').val().trim()==''){
					$('#pchckcokeballglassod').focus();
					$('#pchckcokeballglassod').attr("style","background-color: red");
				}else{
					$('#pchckcokeballglassod').attr("style","background-color: green");
				}
			}else if(sphod==0.00){
				if(Math.abs(Subtr($('#pchckcokeballglassod').val(),sphod))>sphodmis||$('#pchckcokeballglassod').val().trim()==''){
					$('#pchckcokeballglassod').focus();
					$('#pchckcokeballglassod').attr("style","background-color: red");
				}else{
					$('#pchckcokeballglassod').attr("style","background-color: green");
				}
			}else{
				$('#pchckcokeballglassod').focus();
				$('#pchckcokeballglassod').attr("style","background-color: red");
			}
		}else{
			$('#pchckcokeballglassod').focus();
			$('#pchckcokeballglassod').attr("style","background-color: red");
		}
		
		/*
		球镜右眼子午面二
		*/
		if(!isNaN($('#pchckcokeballglassod2').val())){
			if($('#pchckcokeballglassod2').val().substring(0,1)==(parseFloat(sphod)+parseFloat(cylod)+"").substring(0,1)||(parseFloat(sphod)+parseFloat(cylod))>0){
				if(Math.abs(Subtr($('#pchckcokeballglassod2').val(),(parseFloat(sphod)+parseFloat(cylod))))>odscmistake||$('#pchckcokeballglassod2').val().trim()==''){
					$('#pchckcokeballglassod2').focus();
					$('#pchckcokeballglassod2').attr("style","background-color: red");
				}else{
					$('#pchckcokeballglassod2').attr("style","background-color: green");
				}
			}else if((parseFloat(sphod)+parseFloat(cylod))==0.00){
				if(Math.abs(Subtr($('#pchckcokeballglassod2').val(),(parseFloat(sphod)+parseFloat(cylod))))>odscmistake||$('#pchckcokeballglassod2').val().trim()==''){
					$('#pchckcokeballglassod2').focus();
					$('#pchckcokeballglassod2').attr("style","background-color: red");
				}else{
					$('#pchckcokeballglassod2').attr("style","background-color: green");
				}
			}else{
				$('#pchckcokeballglassod2').focus();
				$('#pchckcokeballglassod2').attr("style","background-color: red");
			}
		}else{
			$('#pchckcokeballglassod2').focus();
			$('#pchckcokeballglassod2').attr("style","background-color: red");
		}
		/*
		球镜左眼
		*/
		if(!isNaN($('#pchckcokeballglassos').val())){
			if($('#pchckcokeballglassos').val().substring(0,1)==sphos.substring(0,1)||sphos.substring(0,1)=='+'){
				if(Math.abs(Subtr($('#pchckcokeballglassos').val(),sphos))>sphosmis||$('#pchckcokeballglassos').val().trim()==''){
					$('#pchckcokeballglassos').focus();
					$('#pchckcokeballglassos').attr("style","background-color: red");
				}else{
					$('#pchckcokeballglassos').attr("style","background-color: green");
				}
			}else if(sphos==0.00){
				if(Math.abs(Subtr($('#pchckcokeballglassos').val(),sphos))>sphosmis||$('#pchckcokeballglassos').val().trim()==''){
					$('#pchckcokeballglassos').focus();
					$('#pchckcokeballglassos').attr("style","background-color: red");
				}else{
					$('#pchckcokeballglassos').attr("style","background-color: green");
				}
			}else{
				$('#pchckcokeballglassos').focus();
				$('#pchckcokeballglassos').attr("style","background-color: red");
			}
		}else{
			$('#pchckcokeballglassos').focus();
			$('#pchckcokeballglassos').attr("style","background-color: red");
		}
		
		/*
		球镜主子午面二左眼
		*/
		if(!isNaN($('#pchckcokeballglassos2').val())){
			if($('#pchckcokeballglassos2').val().substring(0,1)==(parseFloat(sphos)+parseFloat(cylos)+"").substring(0,1)||(parseFloat(sphos)+parseFloat(cylos))>0){
				if(Math.abs(Subtr($('#pchckcokeballglassos2').val(),(parseFloat(sphos)+parseFloat(cylos))))>osscmistake||$('#pchckcokeballglassos2').val().trim()==''){
					
					$('#pchckcokeballglassos2').focus();
					$('#pchckcokeballglassos2').attr("style","background-color: red");
				}else{
					$('#pchckcokeballglassos2').attr("style","background-color: green");
				}
			}else if((parseFloat(sphos)+parseFloat(cylos))==0.00){
				if(Math.abs(Subtr($('#pchckcokeballglassos2').val(),(parseFloat(sphos)+parseFloat(cylos))))>osscmistake||$('#pchckcokeballglassos2').val().trim()==''){
					$('#pchckcokeballglassos2').focus();
					$('#pchckcokeballglassos2').attr("style","background-color: red");
				}else{
					$('#pchckcokeballglassos2').attr("style","background-color: green");
				}
			}else{
				$('#pchckcokeballglassos2').focus();
				$('#pchckcokeballglassos2').attr("style","background-color: red");
			}
		}else{
			$('#pchckcokeballglassos2').focus();
			$('#pchckcokeballglassos2').attr("style","background-color: red");
		}
		/*
		柱镜右眼sphosmis
		*/ 
		 if(!isNaN($('#pchckcokepostglassod').val())){
				if($('#pchckcokepostglassod').val().substring(0,1)==cylod.substring(0,1)||cylod.substring(0,1)=='+'){
					if(Math.abs(Subtr(cylod,$('#pchckcokepostglassod').val()))>cylodmis||$('#pchckcokepostglassod').val().trim()==''){
						$('#pchckcokepostglassod').focus();
						$('#pchckcokepostglassod').attr("style","background-color: red");
						$('#pchckcokepostglassod2').attr("style","background-color: red");
					}else{
						$('#pchckcokepostglassod').attr("style","background-color: green");
						$('#pchckcokepostglassod2').attr("style","background-color: green");
					}
				}else if(cylod==0.00){
					if(Math.abs(Subtr(cylod,$('#pchckcokepostglassod').val()))>cylodmis||$('#pchckcokepostglassod').val().trim()==''){
						$('#pchckcokepostglassod').focus();
						$('#pchckcokepostglassod').attr("style","background-color: red");
						$('#pchckcokepostglassod2').attr("style","background-color: red");
					}else{
						$('#pchckcokepostglassod').attr("style","background-color: green");
						$('#pchckcokepostglassod2').attr("style","background-color: green");
					}
				}else{
					$('#pchckcokepostglassod').focus();
					$('#pchckcokepostglassod').attr("style","background-color: red");
					$('#pchckcokepostglassod2').attr("style","background-color: red");
				}
			}else{
				$('#pchckcokepostglassod').focus();
				$('#pchckcokepostglassod').attr("style","background-color: red");
				$('#pchckcokepostglassod2').attr("style","background-color: red");
			}
		/*
		柱镜左眼
		*/
		if(!isNaN($('#pchckcokepostglassod').val())){
			if($('#pchckcokepostglassos').val().substring(0,1)==cylos.substring(0,1)||cylos.substring(0,1)=='+'){
				if(Math.abs(Subtr(cylos,$('#pchckcokepostglassos').val()))>cylosmis||$('#pchckcokepostglassos').val().trim()==''){
					$('#pchckcokepostglassos').focus();
					$('#pchckcokepostglassos').attr("style","background-color: red");
					$('#pchckcokepostglassos2').attr("style","background-color: red");
				}else{
					$('#pchckcokepostglassos').attr("style","background-color: green");
					$('#pchckcokepostglassos2').attr("style","background-color: green");
				}
			}else if(cylos==0.00){
				if(Math.abs(Subtr(cylos,$('#pchckcokepostglassos').val()))>cylosmis||$('#pchckcokepostglassos').val().trim()==''){
					$('#pchckcokepostglassos').focus();
					$('#pchckcokepostglassos').attr("style","background-color: red");
					$('#pchckcokepostglassos2').attr("style","background-color: red");
				}else{
					$('#pchckcokepostglassos').attr("style","background-color: green");
					$('#pchckcokepostglassos2').attr("style","background-color: green");
				}
			}else{
				$('#pchckcokepostglassos').focus();
				$('#pchckcokepostglassos').attr("style","background-color: red");
				$('#pchckcokepostglassos2').attr("style","background-color: red");
			}
		}else{
			$('#pchckcokepostglassod').focus();
			$('#pchckcokepostglassod').attr("style","background-color: red");
			$('#pchckcokepostglassod2').attr("style","background-color: red");
		}	
		/*
		右眼轴向
		*/
		if(cylod != '0.00'){
			if(Math.abs(accAdd(axesod,axesodmis))>180&&Math.abs($('#pchckcokeaxesod').val())<10){
					if(Math.abs(Subtr(axesod,accAdd($('#pchckcokeaxesod').val(),180)))>axesodmis||$('#pchckcokeaxesod').val().trim()==''){
						$('#pchckcokeaxesod').focus();
						$('#pchckcokeaxesod').attr("style","background-color: red");
						$('#pchckcokeaxesod2').attr("style","background-color: red");
					}else{
						$('#pchckcokeaxesod').attr("style","background-color: green");
						$('#pchckcokeaxesod2').attr("style","background-color: green");
					}
				}else{
					if(Math.abs(Subtr(axesod,$('#pchckcokeaxesod').val()))>axesodmis||$('#pchckcokeaxesod').val().trim()==''){
						$('#pchckcokeaxesod').focus();
						$('#pchckcokeaxesod').attr("style","background-color: red");
						$('#pchckcokeaxesod2').attr("style","background-color: red");
					}else{
						$('#pchckcokeaxesod').attr("style","background-color: green");
						$('#pchckcokeaxesod2').attr("style","background-color: green");
					}
				}
		}else{
			$('#pchckcokeaxesod').attr("style","background-color: green");
			$('#pchckcokeaxesod2').attr("style","background-color: green");
		}
			
		
		/*
		左眼轴向cylos
		*/
			if(cylos != '0.00'){
				if(accAdd(axesos,axesosmis)>180&&Math.abs($('#pchckcokeaxesos').val())<10){
					if(Math.abs(Subtr(axesos,accAdd($('#pchckcokeaxesos').val(),180)))>axesosmis||$('#pchckcokeaxesos').val().trim()==''){
						$('#pchckcokeaxesos').focus();
						$('#pchckcokeaxesos').attr("style","background-color: red");
						$('#pchckcokeaxesos2').attr("style","background-color: red");
					}else{
						$('#pchckcokeaxesos').attr("style","background-color: green");
						$('#pchckcokeaxesos2').attr("style","background-color: green");
					}
				}else{
					if(Math.abs(Subtr(axesos,$('#pchckcokeaxesos').val()))>axesosmis||$('#pchckcokeaxesos').val().trim()==''){
						$('#pchckcokeaxesos').focus();
						$('#pchckcokeaxesos').attr("style","background-color: red");
						$('#pchckcokeaxesos2').attr("style","background-color: red");
					}else{
						$('#pchckcokeaxesos').attr("style","background-color: green");
						$('#pchckcokeaxesos2').attr("style","background-color: green");
					}
				}
			}else{
				$('#pchckcokeaxesos').attr("style","background-color: green");
				$('#pchckcokeaxesos2').attr("style","background-color: green");
			}

		
		
		/*
		右眼下加
		*/
		if(addod!='0.00'){
			if(Math.abs(Subtr(addod,$('#pchckcokeaddod').val()))>addodmis||$('#pchckcokeaddod').val().trim()==''){
				$('#pchckcokeaddod').focus();
				$('#pchckcokeaddod').attr("style","background-color: red");
			}else{
				$('#pchckcokeaddod').attr("style","background-color: green");
			}
		}else{
			$('#pchckcokeaddod').attr("style","background-color: green");
		}
		/*
		左眼下加
		*/
		if(addos!='0.00'){		
			if(Math.abs(Subtr(addos,$('#pchckcokeaddos').val()))>addosmis||$('#pchckcokeaddos').val().trim()==''){
				$('#pchckcokeaddos').focus();
				$('#pchckcokeaddos').attr("style","background-color: red");
			}else{
				$('#pchckcokeaddos').attr("style","background-color: green");
			}
		}else{
			$('#pchckcokeaddos').attr("style","background-color: green");
		}


		var i=0;
		try{
			
			$('input[pd=pd]').each(function(){
				if($(this).attr("style")=='BACKGROUND-COLOR: green'){
					i=i+1;
				}
				
			});
		} catch(e){
			return;
		}	
		if(i=='13'){
			$('#JGN').attr("style","display: none");
			$('#JGY').attr("style","display: block");
			$('#pchckqualified').val('1');
		}else{
			$('#JGY').attr("style","display: none");
			$('#JGN').attr("style","display: block");
			$('#pchckqualified').val('0');
		}
	}
	
	function OnKeyDownEnter(obj){
		
		if(event.keyCode == 13){
			var i = obj.Enter;
			i=++i;
			$("\"[Enter="+i+"]\"").focus();
		}
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="workingCheckInsertForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="salesid" name="salesid" value="${salesBasicPo.ssesbsalesid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT:1px" background=${ctx}/img/pic/tab_bg.gif>
		</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="20%">${salesBasicPo.ssesbsalesid}</TD>
			               <TD width="8%" height="26" class="table_body">所属门店</TD>
			               <TD class="table_none" width="20%">${salesBasicPo.ssesbshopName}</TD>
						   <TD width="8%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none">${salesBasicPo.ssesbpersonName}　　【卡号：${salesBasicPo.ssesbMemberId}】</TD>
                        </TR>     
                        <TR>
                           <TD height="26" class="table_body">联系电话</TD>
			               <TD class="table_none" >${salesBasicPo.ssesbphone}</TD>
						   <TD height="26" class="table_body">加工师</TD>
			               <TD class="table_none" >
			               	${workingCheckPo.pchckprocesspersonname }
			               </TD>
			               <TD height="26" class="table_body">检验员</TD>
			               <TD class="table_none" >${workingCheckPo.pchckchecklabourname}<input type="hidden" name="workingCheckPo.pchckprocesspersonid" value="${workingCheckPo.pchckprocesspersonid}"/></TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">抽检人</TD>
			               <TD class="table_none" >
			               	${workingCheckPo.pchckpersonname}
			               </TD>
			               
                           <TD height="26" class="table_body">配送地点</TD>
			               <TD class="table_none" ${salesBasicPo.ssesbshopName== salesBasicPo.ssesbtakeshopname  ? '' : 'style="color: red;"' } colspan="3">
			               	${salesBasicPo.ssesbtakeshopname}
			               </TD>
			               <TD height="26" class="table_body" id="cjjg1">抽检结果</TD>
			               <TD class="table_none" id="cjjg2">
			               <select id="pchckqualified"  name="workingCheckPo.pchckqualified">
                             <option value="1">合格</option>
                             <option value="0">不合格</option>							 
                           </select></TD>
                        </TR> 
                        <TR>
						   
			               <TD width="9%" height="26" class="table_body">特殊加工要求</TD>
			               <TD class="table_none" colspan="5">
			               		<font color="red">
			               				<c:if test="${not empty(specialPDetailList)}">
			               					<s:iterator value="specialPDetailList">
			               						${ssesdrequirement} &nbsp;&nbsp;&nbsp;&nbsp;
			               					</s:iterator>
			               				</c:if>
			               		</font>
			               </TD>
                        </TR>               
                      </TBODY>
                    </TABLE>
					
                     
                     <table id="jdjTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col height="26">右眼(R)/左眼(L)</TH>		
						  <TH width="10%" scope=col height="26">子午面</TH>				
						  <TH width="10%" scope=col>球镜</TH>
						  <TH width="10%" scope=col>柱镜</TH>
						  <TH width="10%" scope=col>轴向</TH>
						  <TH width="15%" scope=col>斜视</TH>
						  <TH width="10%" scope=col>add</TH>
						  <TH width="10%" scope=col>瞳距</TH>
						  <TH width="15%" scope=col>商品名称</TH>
						</TR>
                        <TR class="row">
                          <TD align="center" height="26" rowspan="4">R</TD>
                          <TD height="26">主子午面一</TD>
                          <TD>${joDPo.ssesbballglassod}</TD>
                          <TD>${joDPo.ssesbpostglassod}</TD>
                          <TD>${joDPo.ssesbaxesod}</TD>
                          <TD>${joDPo.ssesbarriseglassod}&nbsp;&nbsp;&nbsp;&nbsp;${joDPo.ssesbbasisod}</TD>
                          <TD>${joDPo.ssesbaddod}</TD>
                          <c:if test="${(joDPo.ssesbrecipetype)==1}">
                          <TD>${joDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <c:if test="${(joDPo.ssesbrecipetype)==2}">
                          <TD>${joDPo.ssesbinterdistanceod}</TD>
                          </c:if>
                          <c:if test="${(joDPo.ssesbrecipetype)==3}">
                          <TD>${joDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <TD rowspan="4">${joDPo.ssesbgoodsname}</TD>
						</TR>
						<TR class="row" >
                          <TD align="center" height="26">焦度计</TD>
                          <TD id="jpchckcokeballglassod">${workingCheckPo.pchckcokeballglassod }</TD>
                          <TD id="jpchckcokepostglassod">${workingCheckPo.pchckcokepostglassod }</TD>
                          <TD id="jpchckcokeaxesod">${workingCheckPo.pchckcokeaxesod}</TD>
                          <TD rowspan="3" align="center">
                          	三棱镜：${workingCheckPo.pchckcokearriseglassod }&nbsp;&nbsp;&nbsp;&nbsp;
                          	基底：${workingCheckPo.pchckcokebasisod }
                          </TD>
                          <TD rowspan="3">${workingCheckPo.pchckcokeaddod }</TD>
                          <TD rowspan="3">${workingCheckPo.pchckcokepupildistanceod }</TD>
						</TR>
						<tr class="row" >
						  <TD height="26">主子午面二</TD>
						  <c:if test="${joDPo.ssesbballglassod+joDPo.ssesbpostglassod>0}">
						  	<TD>+<fmt:formatNumber value="${joDPo.ssesbballglassod+joDPo.ssesbpostglassod}" type="currency" pattern="0.00"/></TD>
						  </c:if>
						  <c:if test="${joDPo.ssesbballglassod+joDPo.ssesbpostglassod<0}">
						  	<TD><fmt:formatNumber value="${joDPo.ssesbballglassod+joDPo.ssesbpostglassod}" type="currency" pattern="0.00"/></TD>
						  </c:if>
						  
						  <c:if test="${joDPo.ssesbballglassod+joDPo.ssesbpostglassod==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  <c:if test="${joDPo.ssesbpostglassod=='0.00'}">
						  	<TD>${joDPo.ssesbpostglassod}</TD>
						  </c:if>
						  <c:if test="${joDPo.ssesbpostglassod!='0.00'}">
							  	<c:if test="${-joDPo.ssesbpostglassod>0}">
							  		<TD>+<fmt:formatNumber value="${-joDPo.ssesbpostglassod}" type="currency" pattern="0.00"/></TD>
							    </c:if>
							    <c:if test="${-joDPo.ssesbpostglassod<0}">
							  		<TD><fmt:formatNumber value="${-joDPo.ssesbpostglassod}" type="currency" pattern="0.00"/></TD>
							    </c:if>
						  </c:if>
						  
						  <c:if test="${empty(joDPo.ssesbaxesod)}">
						  	<TD>0</TD>
						  </c:if>
						  
						  <c:if test="${joDPo.ssesbaxesod == 0}">
						  	<TD>${joDPo.ssesbaxesod}</TD>
						  </c:if>
						  
						  <c:if test="${joDPo.ssesbaxesod > 0}">
						  		<c:if test="${joDPo.ssesbaxesod <= 90}">
						  			<TD>${joDPo.ssesbaxesod+90}</TD>
						    	</c:if>
						  
						  		<c:if test="${joDPo.ssesbaxesod>90}">
						  			<TD>${joDPo.ssesbaxesod-90}</TD>
						  		</c:if>
						  </c:if>
						  			  
						</tr>
						<tr class="row" ><!-- onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" -->
						  <TD height="26">焦度计</TD>
						  <TD id="jpchckcokeballglassod2"></TD>
                          <TD id="jpchckcokepostglassod2"></TD>
                          <TD id="jpchckcokeaxesod2"></TD>
						  					 
						</tr>
						<TR class="row" >
                          <TD align="center" height="26" rowspan="4">L</TD>
                          <TD height="26">主子午面一</TD>
                          <TD>${joSPo.ssesbballglassos}</TD>
                          <TD>${joSPo.ssesbpostglassos}</TD>
                          <TD>${joSPo.ssesbaxesos}</TD>
                          <TD>${joSPo.ssesbarriseglassos}&nbsp;&nbsp;&nbsp;&nbsp;${joSPo.ssesbbasisos}</TD>
                          <TD>${joSPo.ssesbaddos}</TD>
                          
                          <c:if test="${(joSPo.ssesbrecipetype)==1}">
                          <TD>${joSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <c:if test="${(joSPo.ssesbrecipetype)==2}">
                          <TD>${joSPo.ssesbinterdistanceos}</TD>
                          </c:if>
                          <c:if test="${(joSPo.ssesbrecipetype)==3}">
                          <TD>${joSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <TD rowspan="4">${joSPo.ssesbgoodsname}</TD>
						</TR>
						
						<TR class="row">
                          <TD align="center" height="26">焦度计</TD>
                          <TD id="jpchckcokeballglassos">${workingCheckPo.pchckcokeballglassos }</TD>
                          <TD id="jpchckcokepostglassos">${workingCheckPo.pchckcokepostglassos }</TD>
                          <TD id="jpchckcokeaxesos">${workingCheckPo.pchckcokeaxesos }</TD>
                          <TD rowspan="3">
                          	三棱镜：${workingCheckPo.pchckcokearriseglassos }&nbsp;&nbsp;&nbsp;&nbsp;
                          	基底：${workingCheckPo.pchckcokebasisos }
                          	
                          	<!-- <input class="text_input60" type="text"  id="pchckcokestrabismusos1" name="workingCheckPo.pchckcokearriseglassos1" value=""/>
                          	&nbsp;
                          	<select id="pchckcokebasisos1" name="workingCheckPo.pchckcokebasisos1">
                          		<option value=""></option>
                          		<option value="内" ${workingCheckPo.pchckcokebasisos1 != '内' ? '':'selected=selected'}>内</option>
                          		<option value="外" ${workingCheckPo.pchckcokebasisos1 != '外' ? '':'selected=selected'}>外</option>
                          		<option value="上" ${workingCheckPo.pchckcokebasisos1 != '上' ? '':'selected=selected'}>上</option>
                          		<option value="下" ${workingCheckPo.pchckcokebasisos1 != '下' ? '':'selected=selected'}>下</option> ${workingCheckPo.pchckcokebasisos=='下' ? 'selected="selected"': ''} -->
								<!-- ${workingCheckPo.pchckcokebasisos1=='下' ? 'selected="selected"': ''} 
                          		
                          	</select> -->
                          	
                          </TD>
                          
                          <TD rowspan="3">${workingCheckPo.pchckcokeaddos }</TD>
                          <TD rowspan="3">${workingCheckPo.pchckcokepupildistanceos }</TD>
						</TR>
						<tr class="row">
						  <TD height="26">主子午面二</TD>
						  <c:if test="${joSPo.ssesbballglassos+joSPo.ssesbpostglassos>0}">
						  	<TD>+<fmt:formatNumber value="${joSPo.ssesbballglassos+joSPo.ssesbpostglassos}" type="currency" pattern="0.00"/></TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbballglassos+joSPo.ssesbpostglassos<0}">
						  	<TD><fmt:formatNumber value="${joSPo.ssesbballglassos+joSPo.ssesbpostglassos}" type="currency" pattern="0.00"/></TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbballglassos+joSPo.ssesbpostglassos==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbpostglassos=='0.00'}">
						  	<TD>${joSPo.ssesbpostglassos}</TD>
						  </c:if>
						  <c:if test="${joSPo.ssesbpostglassos!='0.00'}">
							  	<c:if test="${-joSPo.ssesbpostglassos > 0}">
							  		<TD>+<fmt:formatNumber value="${-joSPo.ssesbpostglassos}" type="currency" pattern="0.00"/></TD>
							    </c:if>
							    <c:if test="${-joSPo.ssesbpostglassos < 0}">
							  		<TD><fmt:formatNumber value="${-joSPo.ssesbpostglassos}" type="currency" pattern="0.00"/></TD>
							    </c:if>
						  </c:if>
						  
						  <c:if test="${empty(joSPo.ssesbaxesos)}">
						  	<TD>0</TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbaxesos == 0}">
						  	<TD>${joSPo.ssesbaxesos}</TD>
						  </c:if>
						  
						  <c:if test="${joSPo.ssesbaxesos > 0}">
						  		<c:if test="${joSPo.ssesbaxesos<=90}">
						  			<TD>${joSPo.ssesbaxesos+90}</TD>
						    	</c:if>
						  
						  		<c:if test="${joSPo.ssesbaxesos>90}">
						  			<TD>${joSPo.ssesbaxesos-90}</TD>
						  		</c:if>
						  </c:if>				  
						</tr>
						<tr class="row">
						  <TD height="26">焦度计</TD>
						  <TD id="jpchckcokeballglassos2"></TD>
                          <TD id="jpchckcokepostglassos2"></TD>
                          <TD id="jpchckcokeaxesos2"></TD>
						</tr>		
						</TBODY>
                    </TABLE>
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="26">
						  <TH width="10%" scope=col>光心垂差</TH>						
						  <TH width="18%" scope=col>光心垂差(焦度计)</TH>
						  <TH width="18%" scope=col>光心高度</TH>
						  <TH width="18%" scope=col>色泽互差</TH>
						  <TH width="18%" scope=col>装配质量</TH>
						  <TH width="18%" scope=col>整形</TH>
						  </TR>
                        <TR class="row">
                          <TD align="center" height="26" id="oldgxcc"> ${salesBasicPo.ssesblightvertical}</TD>
                          <TD>${workingCheckPo.pchckcokecentervertical }</TD>
                          <TD>√</TD>
                          <TD>√</TD>
                          <TD>√</TD>
                          <TD>√</TD>
						</TR>				  
                      </TBODY>
                    </TABLE>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table id="jdjTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col height="26">右眼(R)/左眼(L)</TH>		
						  <TH width="10%" scope=col height="26">子午面</TH>				
						  <TH width="10%" scope=col>球镜</TH>
						  <TH width="10%" scope=col>柱镜</TH>
						  <TH width="10%" scope=col>轴向</TH>
						  <TH width="15%" scope=col>斜视</TH>
						  <TH width="10%" scope=col>add</TH>
						  <TH width="10%" scope=col>瞳距</TH>
						  <TH width="15%" scope=col>商品名称</TH>
						</TR>
                        
                        <TR class="row">
                          <TD align="center" height="26" rowspan="4">R</TD>
                          <TD height="26">主子午面一</TD>
                          <TD>${oDPo.ssesbballglassod}</TD>
                          <TD>${oDPo.ssesbpostglassod}</TD>
                          <TD>${oDPo.ssesbaxesod}</TD>
                          <TD>${oDPo.ssesbarriseglassod}&nbsp;&nbsp;&nbsp;&nbsp;${oDPo.ssesbbasisod}</TD>
                          <TD>${oDPo.ssesbaddod}</TD>
                          
                          <c:if test="${(oDPo.ssesbrecipetype)==1}">
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <c:if test="${(oDPo.ssesbrecipetype)==2}">
                          <TD>${oDPo.ssesbinterdistanceod}</TD>
                          </c:if>
                          <c:if test="${(oDPo.ssesbrecipetype)==3}">
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          </c:if>
                          
                          <TD rowspan="4">${oDPo.ssesbgoodsname}</TD>
						</TR>
						
						<TR class="row" >
                          <TD align="center" height="26">焦度计</TD>
                          <TD><input class="text_input60" pd="pd" type="text"  Enter="1" id="pchckcokeballglassod" name="workingCheckPo.pchckcokeballglassod" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()"></TD>
                          <TD><input class="text_input60" pd="pd" type="text"  Enter="2" id="pchckcokepostglassod" name="workingCheckPo.pchckcokepostglassod" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()"></TD>
                          <TD><input class="text_input60" pd="pd" type="text"  Enter="3" id="pchckcokeaxesod" name="workingCheckPo.pchckcokeaxesod" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()"></TD>
                          <TD rowspan="3">
                          	<input class="text_input60" type="text"  id="pchckcokearriseglassod" name="workingCheckPo.pchckcokearriseglassod" value="">
                          	&nbsp;
                          	<select id="pchckcokebasisod" name="workingCheckPo.pchckcokebasisod">
                          		<option value="">----请选择----</option>
                          		<option value="内" >内</option>
                          		<option value="外" >外</option>
                          		<option value="上" >上</option>
                          		<option value="下" >下</option><!-- ${workingCheckPo.pchckcokebasisod=='下' ? 'selected="selected"': ''} -->
                          		
                          	</select>
                          	<input class="text_input60" type="text"  id="pchckcokearriseglassod1" name="workingCheckPo.pchckcokearriseglassod1" value="">
                          	&nbsp;
                          	<select id="pchckcokebasisod1" name="workingCheckPo.pchckcokebasisod1">
                          		<option value="">----请选择----</option>
                          		<option value="内" >内</option>
                          		<option value="外" >外</option>
                          		<option value="上" >上</option>
                          		<option value="下" >下</option><!-- ${workingCheckPo.pchckcokebasisod1=='下' ? 'selected="selected"': ''} -->
                          		
                          	</select>
                          </TD>
                          <TD rowspan="3"><input class="text_input60" pd="pd" type="text" Enter="4" id="pchckcokeaddod" name="workingCheckPo.pchckcokeaddod" value="" onkeydown="OnKeyDownEnter(this)"></TD>
                          <TD rowspan="3"><input class="text_input60" pd="pd" type="text" Enter="5" id="pchckcokepupildistanceod" name="workingCheckPo.pchckcokepupildistanceod" value="" onkeydown="OnKeyDownEnter(this)"></TD>
						</TR>
						<tr class="row" >
						  <TD height="26">主子午面二</TD>
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod>0}">
						  	<TD>+<fmt:formatNumber value="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod}" type="currency" pattern="0.00"/></TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod<0}">
						  	<TD><fmt:formatNumber value="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod}" type="currency" pattern="0.00"/></TD>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbpostglassod=='0.00'}">
						  	<TD>${oDPo.ssesbpostglassod}</TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbpostglassod!='0.00'}">
							  	<c:if test="${-oDPo.ssesbpostglassod>0}">
							  		<TD>+<fmt:formatNumber value="${-oDPo.ssesbpostglassod}" type="currency" pattern="0.00"/></TD>
							    </c:if>
							    <c:if test="${-oDPo.ssesbpostglassod<0}">
							  		<TD><fmt:formatNumber value="${-oDPo.ssesbpostglassod}" type="currency" pattern="0.00"/></TD>
							    </c:if>
						  </c:if>
						  
						  <c:if test="${empty(oDPo.ssesbaxesod)}">
						  	<TD>0</TD>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbaxesod == 0}">
						  	<TD>${oDPo.ssesbaxesod}</TD>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbaxesod > 0}">
						  		<c:if test="${oDPo.ssesbaxesod <= 90}">
						  			<TD>${oDPo.ssesbaxesod+90}</TD>
						    	</c:if>
						  
						  		<c:if test="${oDPo.ssesbaxesod>90}">
						  			<TD>${oDPo.ssesbaxesod-90}</TD>
						  		</c:if>
						  </c:if>
						  			  
						</tr>
						<tr class="row" ><!-- onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" -->
						  <TD height="26">焦度计</TD>
						  <TD><input class="text_input60"  type="text" pd="pd"  id="pchckcokeballglassod2" name="pchckcokeballglassod2" readonly="readonly"></TD>
                          <TD><input class="text_input60"  type="text"  id="pchckcokepostglassod2" name="pchckcokepostglassod2" readonly="readonly"></TD>
                          <TD><input class="text_input60"  type="text"  id="pchckcokeaxesod2" name="pchckcokeaxesod2" readonly="readonly"></TD>
						  					 
						</tr>
						<TR class="row" >
                          <TD align="center" height="26" rowspan="4">L</TD>
                          <TD height="26">主子午面一</TD>
                          <TD>${oSPo.ssesbballglassos}</TD>
                          <TD>${oSPo.ssesbpostglassos}</TD>
                          <TD>${oSPo.ssesbaxesos}</TD>
                          <TD>${oSPo.ssesbarriseglassos}&nbsp;&nbsp;&nbsp;&nbsp;${oSPo.ssesbbasisos}</TD>
                          <TD>${oSPo.ssesbaddos}</TD>
                          
                          <c:if test="${(oSPo.ssesbrecipetype)==1}">
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <c:if test="${(oSPo.ssesbrecipetype)==2}">
                          <TD>${oSPo.ssesbinterdistanceos}</TD>
                          </c:if>
                          <c:if test="${(oSPo.ssesbrecipetype)==3}">
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <TD rowspan="4">${oSPo.ssesbgoodsname}</TD>
						</TR>
						
						<TR class="row">
                          <TD align="center" height="26">焦度计</TD>
                          <TD><input class="text_input60" pd="pd" type="text" Enter="6" id="pchckcokeballglassos" name="workingCheckPo.pchckcokeballglassos" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()"></TD>
                          <TD><input class="text_input60" pd="pd" type="text" Enter="7" id="pchckcokepostglassos" name="workingCheckPo.pchckcokepostglassos" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()"></TD>
                          <TD><input class="text_input60" pd="pd" type="text" Enter="8" id="pchckcokeaxesos" name="workingCheckPo.pchckcokeaxesos" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()"></TD>
                          <TD rowspan="3">
                          	<input class="text_input60"  type="text"  id="pchckcokestrabismusos" name="workingCheckPo.pchckcokearriseglassos" value=""/>
                          	&nbsp;
                          	<select id="pchckcokebasisos" name="workingCheckPo.pchckcokebasisos">
                          		<option value="">----请选择----</option>
                          		<option value="内" >内</option>
                          		<option value="外" >外</option>
                          		<option value="上" >上</option>
                          		<option value="下" >下</option><!-- ${workingCheckPo.pchckcokebasisos=='下' ? 'selected="selected"': ''} -->
                          		
                          	</select>
                          	
                          	<input class="text_input60" type="text"  id="pchckcokestrabismusos1" name="workingCheckPo.pchckcokearriseglassos1" value=""/>
                          	&nbsp;
                          	<select id="pchckcokebasisos1" name="workingCheckPo.pchckcokebasisos1">
                          		<option value="">----请选择----</option>
                          		<option value="内" >内</option>
                          		<option value="外" >外</option>
                          		<option value="上" >上</option>
                          		<option value="下" >下</option><!-- ${workingCheckPo.pchckcokebasisos1=='下' ? 'selected="selected"': ''} -->
                          		
                          	</select>
                          	
                          </TD>
                          
                          <TD rowspan="3"><input class="text_input60" pd="pd" Enter="9" type="text"  id="pchckcokeaddos" name="workingCheckPo.pchckcokeaddos" value="" onkeydown="OnKeyDownEnter(this)"></TD>
                          <TD rowspan="3"><input class="text_input60" pd="pd" Enter="10" type="text"  id="pchckcokepupildistanceos" name="workingCheckPo.pchckcokepupildistanceos" value="" onkeydown="OnKeyDownEnter(this)"></TD>
						</TR>
						<tr class="row">
						  <TD height="26">主子午面二</TD>
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos>0}">
						  	<TD>+<fmt:formatNumber value="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos}" type="currency" pattern="0.00"/></TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos<0}">
						  	<TD><fmt:formatNumber value="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos}" type="currency" pattern="0.00"/></TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbpostglassos=='0.00'}">
						  	<TD>${oSPo.ssesbpostglassos}</TD>
						  </c:if>
						  <c:if test="${oSPo.ssesbpostglassos!='0.00'}">
							  	<c:if test="${-oSPo.ssesbpostglassos > 0}">
							  		<TD>+<fmt:formatNumber value="${-oSPo.ssesbpostglassos}" type="currency" pattern="0.00"/></TD>
							    </c:if>
							    <c:if test="${-oSPo.ssesbpostglassos < 0}">
							  		<TD><fmt:formatNumber value="${-oSPo.ssesbpostglassos}" type="currency" pattern="0.00"/></TD>
							    </c:if>
						  </c:if>
						  
						  <c:if test="${empty(oSPo.ssesbaxesos)}">
						  	<TD>0</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbaxesos == 0}">
						  	<TD>${oSPo.ssesbaxesos}</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbaxesos > 0}">
						  		<c:if test="${oSPo.ssesbaxesos<=90}">
						  			<TD>${oSPo.ssesbaxesos+90}</TD>
						    	</c:if>
						  
						  		<c:if test="${oSPo.ssesbaxesos>90}">
						  			<TD>${oSPo.ssesbaxesos-90}</TD>
						  		</c:if>
						  </c:if>				  
						</tr>
						<tr class="row">
						  <TD height="26">焦度计</TD>
						  <TD><input class="text_input60" pd="pd" type="text"  id="pchckcokeballglassos2" name="pchckcokeballglassos2" readonly="readonly"></TD>
                          <TD><input class="text_input60"  type="text"  id="pchckcokepostglassos2" name="pchckcokepostglassos2" readonly="readonly"></TD>
                          <TD><input class="text_input60"  type="text"  id="pchckcokeaxesos2" name="pchckcokeaxesos2" readonly="readonly"></TD>
								 
						</tr>		
						
						</TBODY>
                    </TABLE>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="26">
						  <TH width="10%" scope=col>光心垂差</TH>						
						  <TH width="18%" scope=col>光心垂差(焦度计)</TH>
						  <TH width="18%" scope=col>光心高度</TH>
						  <TH width="18%" scope=col>色泽互差</TH>
						  <TH width="18%" scope=col>装配质量</TH>
						  <TH width="18%" scope=col>整形</TH>
						  </TR>
                        <TR class="row">
                          <TD align="center" height="26" id="oldgxcc"> ${salesBasicPo.ssesblightvertical}</TD>
                          <TD><input class="text_input100" type="text" pd="pd" Enter="11" id="pchckcokecentervertical" name="workingCheckPo.pchckcokecentervertical" value="" onkeydown="OnKeyDownEnter(this)"></TD>
                          <TD><input class="text_input100" type="text"  id="pchckcenterhigh" name="workingCheckPo.pchckcenterhigh" value="√"></TD>
                          <TD><input class="text_input100" type="text"  id="pchckcolor" name="workingCheckPo.pchckcolor" value="√"></TD>
                          <TD><input class="text_input100" type="text"  id="pchckquality" name="workingCheckPo.pchckquality" value="√"></TD>
                          <TD><input class="text_input100" type="text"  id="pchckshaping" name="workingCheckPo.pchckshaping" value="√"></TD>
						</TR>				  
                      </TBODY>
                    </TABLE>
                    <TABLE id="title2" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="center">
                            <div id="JGY" align="center" style="display: none;"><font style="font-size: 20px;font-weight: bold;color: green;">抽检结果：合格</font></div>
                            <div id="JGN" align="center" style="display: none;"><font style="font-size: 20px;font-weight: bold;color: red;">抽检结果：不合格</font></div>
                            <br/>
                            <c:if test="${systemParameterPo.fspwhichmachine != '3'}">
                              <img id="readBtn" src="${ctx}/img/newbtn/btn_readjdj_0.png" btn=btn title='读取焦度计' onClick="READ()">
                              &nbsp;&nbsp;
                            </c:if>  
                              <img src="${ctx}/img/newbtn/btn_check_0.png" btn=btn title="检 验" onclick="check()" >
							  &nbsp;&nbsp;
                              <img id="saveBtn" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title="保 存" onClick="javascript:insert()">
                              </div></TD></TR>
                      </TBODY>
                    </TABLE>
                 </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        	<TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
        </TR></TBODY></TABLE>

  </TBODY></TABLE></DIV>
  <c:if test="${systemParameterPo.fspwhichmachine != '3'}">
   <div id="appletDiv" >
 <applet codebase='./Apparatus/'
		code='com.pengsheng.main.Apparatus.class'
		archive='Apparatus.jar,comm.jar,log4j.jar'
		name='apparatus' width='100' height='100'> 
</applet></div>   
</c:if>
</form>
</body></html>