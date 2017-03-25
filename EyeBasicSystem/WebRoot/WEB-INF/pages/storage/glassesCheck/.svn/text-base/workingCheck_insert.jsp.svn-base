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
	function trim(str){ //删除左右两端的空格
　　      return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }

	$(document).ready(function() {
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () {
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () {
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });
		if('${systemParameterPo.fspupdatecheck}' == '0'){
			if('${permissionPo.keyd}' != '1') {
				$("input[sys=sys]").attr("readonly","readonly");
			}else{
				$("input[sys=sys]").attr("readonly","");
			}
		}else{
			$("input[sys=sys]").attr("readonly","");
		}
		
		var goodsvalue = 0.00;
		var goodsvalueod = parseFloat($("#glassessalesod").val());
		var goodsvalueos = parseFloat($("#glassessalesos").val());
		
		if(goodsvalueod > 0){
			goodsvalue = goodsvalue + goodsvalueod;
		}
		
		if(goodsvalueos > 0){
			goodsvalue = goodsvalue + goodsvalueos;
		}
		
		$("#pchckglassessalesvalue").val(parseFloat(goodsvalue));
		
		$('input[ck=ck]').keyup(function(){
		 	$(this).val($(this).val().replace(/[^-?\d\.]/g,''));
		}); 
		
		$('input[ck=ck]').blur(function(){
		 	if(!isNaN($(this).val())){ 
		 		if(trim($(this).val())!=''){
		 			$(this).val(new Number($(this).val()).toFixed(2));
		 		}
		 	}
		});
		
		$('input[int=int]').keyup(function(){
		 	$(this).val($(this).val().replace(/[^-?\d\.]/g,''));
		}); 
	});

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
		
		$('#pchckcokeaddod').val(json.addOD!='null'?parseFloat(json.addOD):'0.00');
		$('#pchckcokeaddos').val(json.addOS!='null'?parseFloat(json.addOS):'0.00');
		$('#pchckcokepupildistanceod').val(json.rpd!='null'?parseFloat(json.rpd).toFixed(2):'0.00');
		$('#pchckcokepupildistanceos').val(json.lpd!='null'?parseFloat(json.lpd).toFixed(2):'0.00');
		//alert(!parseFloat(json.rpd));
		if(!parseFloat(json.rpd)){
			$('#pchckcokepupildistanceod').attr("readonly","");
		}
		
		if(!parseFloat(json.lpd)){
			$('#pchckcokepupildistanceos').attr("readonly","");
		}
		
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
		
		if(json.baseOS2=='I'){
			document.getElementById('pchckcokebasisos1').options[1].selected=true;
		}else if(json.baseOD2=='O'){
			document.getElementById('pchckcokebasisos1').options[2].selected=true;
		}else if(json.baseOS2=='U'){
			document.getElementById('pchckcokebasisos1').options[3].selected=true;
		}else if(json.baseOS2=='D'){
			document.getElementById('pchckcokebasisos1').options[4].selected=true;
		}
		
		//光心垂差,垂直向三棱镜之差
		var gxcc=0;
		if(json.baseOD2==json.baseOS2){
			gxcc=Math.abs(Subtr(json.prismOD2!='null'?json.prismOD2:'0.00',json.prismOS2!='null'?json.prismOS2:'0.00'));
		}else{
			gxcc=accAdd(json.prismOD2!='null'?json.prismOD2:'0.00',json.prismOS2!='null'?json.prismOS2:'0.00');
		}
		
		if('${systemParameterPo.fspvd}' == '0'){
			$('#pchckcokecentervertical').val('');
			$('#pchckcokecentervertical').attr("readonly","");
		}else{
			$('#pchckcokecentervertical').val(gxcc);
		}
		
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
		var type = $('input:radio[name="jdjtype"]:checked').val();
		document.apparatus.strTest(type);
		$('#readBtn').attr("disabled","disabled");
	}
	/*
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
		//workingCheckInsertForm.action = "getLastWorkingCheck.action?cid="+id;
		//workingCheckInsertForm.submit();
	}	
	*/
	function insert(){
		/*if ('${systemParameterPo.fspupdatecheck}' == '1'){
			check();
		}
		var workingPerson=document.getElementById("pchckprocesspersonid").value;
		if(workingPerson==''){
			alert('请选择加工师!');
			return false;
		}
		try{
			var i=0;
			$('input[pd=pd]').each(function(){
				if($(this).attr('style').toLocaleLowerCase()=='background-color: green'){
					i=i+1;
				}	
				if(i==13){
					$("img").removeAttr("onclick");
					workingCheckInsertForm.action = "insertGlassesCheck.action";
					workingCheckInsertForm.submit();
				}else if($(this).attr('style').toLocaleLowerCase()=='background-color: red'){
					alert('此栏位不在允差范围之内!');
					$(this).focus();
					throw '1';
				}
			});
		} catch(e){
			return;
		}
		if(i == 0){
			alert("请检验镜片是否合格！");
			return;
		}*/
		if(checkForm(document.all.workingCheckInsertForm)){ 
			$("img").removeAttr("onclick");
			workingCheckInsertForm.action = "insertGlassesCheck.action";
			workingCheckInsertForm.submit();
		}
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
	var sphodmis='${odMisPo.fmtodsphmistake}'.trim();
	var sphosmis='${osMisPo.fmtossphmistake}'.trim();
	var cylodmis='${odMisPo.fmtodcylmistake}'.trim();
	var cylosmis='${osMisPo.fmtoscylmistake}'.trim();
	var axesodmis='${odMisPo.fmtodaxesmistake}'.trim();
	var axesosmis='${osMisPo.fmtosaxesmistake}'.trim();
	var addodmis='${odMisPo.fmtodaddmistake}'.trim();
	var addosmis='${osMisPo.fmtosaddmistake}'.trim();
	var tjodmis='${odMisPo.fmtodtjmistake}'.trim();
	var tjosmis='${osMisPo.fmtostjmistake}'.trim();
	var odscmistake=parseFloat('${odMisPo.fmtodsphandcylmistake}'.trim());
	var osscmistake=parseFloat('${osMisPo.fmtossphandcylmistake}'.trim());
	var addod='${oDPo.ssesbaddod}'==''?'0.00':'${oDPo.ssesbaddod}'.trim();
	var addos='${oSPo.ssesbaddos}'==''?'0.00':'${oSPo.ssesbaddos}'.trim();
	var axesod='${oDPo.ssesbaxesod}'==''?'0.00':'${oDPo.ssesbaxesod}'.trim();
	var axesos='${oSPo.ssesbaxesos}'==''?'0.00':'${oSPo.ssesbaxesos}'.trim();
	var sphod='${oDPo.ssesbballglassod}'.trim();
	var sphos='${oSPo.ssesbballglassos}'.trim();
	var cylod='${oDPo.ssesbpostglassod}'.trim();
	var cylos='${oSPo.ssesbpostglassos}'.trim();
	var tjod='${oDPo.ssesbinterhighod}'.trim();
	var tjos='${oSPo.ssesbinterhighos}'.trim();
	var tjod2='${oDPo.ssesbinterdistanceod}'.trim();
	var tjos2='${oSPo.ssesbinterdistanceos}'.trim();
	var type='${oDPo.ssesbrecipetype}'.trim();
	
	function check(){
		//右眼瞳距
		if(!isNaN($('#pchckcokepupildistanceod').val())){
			if(type=='1'||type=='5'){
				if(Math.abs(accAdd(tjod,'-'+$('#pchckcokepupildistanceod').val()))>parseFloat(tjodmis)/2||$('#pchckcokepupildistanceod').val().trim()==''){
					$('#pchckcokepupildistanceod').focus();
					$('#pchckcokepupildistanceod').attr("style","background-color: red");
				}else{
					$('#pchckcokepupildistanceod').attr("style","background-color: green");
				}
			}else if(type=='2'){
				if(Math.abs(accAdd(tjod2,'-'+$('#pchckcokepupildistanceod').val()))>parseFloat(tjodmis)/2||$('#pchckcokepupildistanceod').val().trim()==''){
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
			
			if(type=='1'||type=='5'){
				if(Math.abs(Subtr(tjos,$('#pchckcokepupildistanceos').val()))>parseFloat(tjosmis)/2||$('#pchckcokepupildistanceos').val().trim()==''){
					$('#pchckcokepupildistanceos').focus();
					$('#pchckcokepupildistanceos').attr("style","background-color: red");
				}else{
					$('#pchckcokepupildistanceos').attr("style","background-color: green");
				}
			}else if(type=='2'){
				if(Math.abs(accAdd(tjos2,'-'+$('#pchckcokepupildistanceos').val()))>parseFloat(tjosmis)/2||$('#pchckcokepupildistanceos').val().trim()==''){
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
	}
	
	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var i = obj.Enter;
			i=++i;
			$("\"[Enter="+i+"]\"").focus();
		}
	}
	
	function help(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWorkingCheckHelp.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			window.open('initWorkingCheckHelp.action?moduleID=${requestScope.moduleID}','','toolbar=0,directories=0,status=0,menubar=0,scrollbars=yes,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));
		}
		document.getElementById('popupTitle').innerHTML="【检验标准说明 】";
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="workingCheckInsertForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="salesid" name="salesid" value="${requestScope.ssesbsalesid}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><TD align=right>
                <img src="${ctx }/img/newbtn/reporthelp_0.png" btn=btn title='帮助' onclick="help();">&nbsp;
            </TD></tr>
  <TR>
    <TD><!-- ?? Start -->
              <!--<c:if test="${copylast =='1'}">
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick="lastcopy('${salesBasicPo.ssesbcustomerid}');" 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/img/sys/New.gif" align=textTop 
                  border=0>&nbsp;读取上次检验数据</TD>
                 </c:if>
                  <c:if test="${copylast =='0'}">
                <TD class=menubar_button id=button_0 ></TD>
                 </c:if>-->
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx}/img/pic/tab_bg.gif>
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
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="24" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="20%">${salesBasicPo.ssesbsalesid}</TD>
			               <TD width="9%" height="24" class="table_body">所属门店</TD>
			               <TD class="table_none" width="20%">${salesBasicPo.ssesbshopName}</TD>
						   <TD width="9%" height="24" class="table_body">顾客姓名</TD>
			               <TD class="table_none">${salesBasicPo.ssesbpersonName}【会员卡号：${salesBasicPo.ssesbMemberId}】</TD>
                        </TR>     
                        <TR>
						   <TD width="9%" height="24" class="table_body">营业员</TD>
			               <TD class="table_none" width="20%">${salesBasicPo.ssesbsalerName}</TD>
			               <TD width="9%" height="24" class="table_body">验光师</TD>
			               <TD class="table_none" width="20%" colspan="3">${salesBasicPo.ssesbyishiid}</TD>
                        </TR>  
                        <TR>
                           <TD height="24" class="table_body">联系电话</TD>
			               <TD class="table_none" >${salesBasicPo.ssesbphone}</TD>
						   <TD height="24" class="table_body">加工师</TD>
			               <TD class="table_none" >
				                ${inTransitPo.sseitcreatepersonname }
				                <input type="hidden" value="${inTransitPo.sseitcreateperson }" id="pchckprocesspersonid" name="workingCheckPo.pchckprocesspersonid"/>
			               </TD>
			               <TD height="24" class="table_body">检验员</TD>
			               <TD class="table_none" >${sessionScope.person.personName}</TD>
                        </TR> 
                        <TR>
						   <TD height="24" class="table_body">配送地点</TD>
			               <TD class="table_none" width="30%" ${salesBasicPo.ssesbshopName== salesBasicPo.ssesbtakeshopname  ? '' : 'style="color: red;"' }>
			               	${salesBasicPo.ssesbtakeshopname}
			               </TD>
			               <TD height="24" class="table_body" >特殊加工要求</TD>
			               <TD class="table_none">
			               		<font color="red">
			               				<c:if test="${not empty(specialPDetailList)}">
			               					<s:iterator value="specialPDetailList">
			               						${ssesdrequirement}&nbsp;&nbsp;&nbsp;&nbsp;
			               					</s:iterator>
			               				</c:if>
			               		</font>&nbsp;
			               </TD>
			               <TD height="24" class="table_body">邮寄</TD>
			               <TD class="table_none" >
								<c:if test="${salesBasicPo.isMail ne ''}"><font color="blue">是</font></c:if>
						   </TD>			               
                        </TR>   
                      </TBODY>
                    </TABLE>
					<table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                     
                     <table id="jdjTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col height="24">右眼(R)/左眼(L)</TH>		
						  <TH width="8%" scope=col>球镜</TH>
						  <TH width="8%" scope=col>柱镜</TH>
						  <TH width="8%" scope=col>轴向</TH>
						  <TH width="8%" scope=col>ADD</TH>
						  <TH width="8%" scope=col>瞳距</TH>
						  <TH width="8%" scope=col>远用VA</TH>
						  <TH width="8%" scope=col>近用VA</TH>
						  <TH scope=col>商品名称</TH>
						  <TH scope=col width="9%">商品原价<input type="hidden" id="pchckglassessalesvalue" name="workingCheckPo.pchckglassessalesvalue"/></TH>
						</TR>
                        
                        <TR class="row">
                          <TD align="center" height="24">R</TD>
                          <TD>${oDPo.ssesbballglassod}</TD>
                          <TD>${oDPo.ssesbpostglassod}</TD>
                          <TD>${empty(oDPo.ssesbaxesod) ? '0' : oDPo.ssesbaxesod}</TD>
                          <TD>${oDPo.ssesbaddod}</TD>
                          
                          <c:if test="${(oDPo.ssesbrecipetype)=='1'}">
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <c:if test="${(oDPo.ssesbrecipetype)=='2'}">
                          <TD>${oDPo.ssesbinterdistanceod}</TD>
                          </c:if>
                          <c:if test="${(oDPo.ssesbrecipetype)=='3'}">
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <c:if test="${(oDPo.ssesbrecipetype)=='5'}">
                          <TD>${oDPo.ssesbinterhighod}</TD>
                          </c:if>
                          <TD>${oDPo.ssesbfarvaod}</TD>
                          <TD>${oDPo.ssesbclosevaod}</TD>
                          <TD>${oDPo.ssesbgoodsname}</TD>
                          <TD>${oDPo.ssesbgoodsvalue}<input type="hidden" id="glassessalesod" value="${oDPo.ssesbgoodsvalue}"/></TD>
						</TR>
						<TR class="row" >
                          <TD align="center" height="24">L</TD>
                          <TD>${oSPo.ssesbballglassos}</TD>
                          <TD>${oSPo.ssesbpostglassos}</TD>
                          <TD>${empty(oSPo.ssesbaxesos) ? '0' : oSPo.ssesbaxesos}</TD>
                          <TD>${oSPo.ssesbaddos}</TD>
                          
                          <c:if test="${(oSPo.ssesbrecipetype)=='1'}">
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <c:if test="${(oSPo.ssesbrecipetype)=='2'}">
                          <TD>${oSPo.ssesbinterdistanceos}</TD>
                          </c:if>
                          <c:if test="${(oSPo.ssesbrecipetype)=='3'}">
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <c:if test="${(oSPo.ssesbrecipetype)=='5'}">
                          <TD>${oSPo.ssesbinterhighos}</TD>
                          </c:if>
                          <TD>${oSPo.ssesbfarvaos}</TD>
                          <TD>${oSPo.ssesbclosevaos}</TD>
                          <TD>${oSPo.ssesbgoodsname}</TD>
                          <TD>${oSPo.ssesbgoodsvalue}<input type="hidden" id="glassessalesos" value="${oSPo.ssesbgoodsvalue}"/></TD>
						</TR>
						
						<tr class="row">
							<TD height="24">镜架</TD>
							<TD colspan="8">${fPo.ssesbgoodsname}</TD>
							<TD>${fPo.ssesbgoodsvalue}</TD>
						</tr>
						</TBODY>
                    </TABLE>
                    <table id="jdjTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col height="24">右眼(R)/左眼(L)</TH>		
						  <TH width="8%" scope=col>球镜</TH>
						  <TH width="8%" scope=col>柱镜</TH>
						  <TH width="8%" scope=col>轴向</TH>
						  <TH width="8%" scope=col>ADD</TH>
						  <TH width="8%" scope=col>瞳距</TH>
						  <TH width="8%" scope=col>远用VA</TH>
						  <TH width="8%" scope=col>近用VA</TH>
						</TR>
                        <TR class="row">
                          <TD align="center" height="24">R</TD>
                          <TD><input class="text_input60" pd="pd" type="text" ck=ck sys=sys Enter="1" id="pchckcokeballglassod" name="workingCheckPo.pchckcokeballglassod" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()" maxlength="10"></TD>
                          <TD><input class="text_input60" pd="pd" type="text" ck=ck sys=sys Enter="2" id="pchckcokepostglassod" name="workingCheckPo.pchckcokepostglassod" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()" maxlength="10"></TD>
                          <TD><input class="text_input60" pd="pd" type="text" sys=sys int=int Enter="3" id="pchckcokeaxesod" name="workingCheckPo.pchckcokeaxesod" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()" maxlength="10"></TD>
                          <TD><input class="text_input60" pd="pd" sys=sys type="text" ck=ck Enter="4" id="pchckcokeaddod" name="workingCheckPo.pchckcokeaddod" value="" onkeydown="OnKeyDownEnter(this)" maxlength="10"></TD>
                          <TD><input class="text_input60" pd="pd" sys=sys type="text" int=int Enter="5" id="pchckcokepupildistanceod" name="workingCheckPo.pchckcokepupildistanceod" value="" onkeydown="OnKeyDownEnter(this)" maxlength="10"></TD>
                          <TD><input class="text_input60" pd="pd" sys=sys type="text" ck=ck Enter="6" id="pchckfarvaod" name="workingCheckPo.pchckfarvaod" value="" onkeydown="OnKeyDownEnter(this)" maxlength="10"></TD>
                          <TD><input class="text_input60" pd="pd" sys=sys type="text" ck=ck Enter="7" id="pchckclosevaod" name="workingCheckPo.pchckclosevaod" value="" onkeydown="OnKeyDownEnter(this)" maxlength="10"></TD>
						</TR>
						<TR class="row" >
                          <TD align="center" height="24">L</TD>
                          <TD><input class="text_input60" pd="pd" type="text" ck=ck sys=sys Enter="8" id="pchckcokeballglassos" name="workingCheckPo.pchckcokeballglassos" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()" maxlength="10"></TD>
                          <TD><input class="text_input60" pd="pd" type="text" ck=ck sys=sys Enter="9" id="pchckcokepostglassos" name="workingCheckPo.pchckcokepostglassos" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()" maxlength="10" ></TD>
                          <TD><input class="text_input60" pd="pd" type="text" int=int sys=sys Enter="10" id="pchckcokeaxesos" name="workingCheckPo.pchckcokeaxesos" value="" onkeydown="OnKeyDownEnter(this)" onblur="assignmentZT()" maxlength="10"></TD>
                          <TD><input class="text_input60" sys=sys pd="pd" ck=ck Enter="11" type="text"  id="pchckcokeaddos" name="workingCheckPo.pchckcokeaddos" value="" onkeydown="OnKeyDownEnter(this)" maxlength="10"></TD>
                          <TD><input class="text_input60" sys=sys pd="pd" int=int Enter="12" type="text"  id="pchckcokepupildistanceos" name="workingCheckPo.pchckcokepupildistanceos" value="" onkeydown="OnKeyDownEnter(this)" maxlength="10"></TD>
						  <TD><input class="text_input60" pd="pd" sys=sys ck=ck type="text" Enter="13" id="pchckfarvaos" name="workingCheckPo.pchckfarvaos" value="" onkeydown="OnKeyDownEnter(this)" maxlength="10"></TD>
                          <TD><input class="text_input60" pd="pd" sys=sys ck=ck type="text" Enter="14" id="pchckclosevaos" name="workingCheckPo.pchckclosevaos" value="" onkeydown="OnKeyDownEnter(this)" maxlength="10"></TD>
						</TR>
						</TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                          <TR>
						   <TD height="24" class="table_body" width="10%">备注</TD>
			               <TD class="table_none">
			               	<textarea id="remark" name="remark" style="height: 40px;" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
			               </TD>
                        </TR>                           
                      </TBODY>
                    </TABLE>
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="24">
						  <TH width="18%" scope=col>水平互差</TH>
						  <TH width="18%" scope=col>垂直互差</TH>
						  <TH width="18%" scope=col>轴位偏差</TH>
						  <TH width="18%" scope=col>是否合格</TH>
						  <TH width="18%" scope=col>等级</TH>
						  </TR>
                        <TR class="row">
                          <TD><input class="text_input100" type="text" sys=sys id="pchckshuiping" ck=ck name="workingCheckPo.pchckshuiping" value="" maxlength="10"></TD>
                          <TD><input class="text_input100" type="text" sys=sys id="pchckchuizhi" ck=ck name="workingCheckPo.pchckchuizhi" value="" maxlength="10"></TD>
                          <TD><input class="text_input100" type="text" sys=sys id="pchckzhouwei" ck=ck name="workingCheckPo.pchckzhouwei" value="" maxlength="10"></TD>
                          <TD>
                          	<select	id="pchckhege" name="workingCheckPo.pchckhege">
                          		<option value="1">&nbsp;&nbsp;&nbsp;合格&nbsp;</option>
                          		<option value="0">&nbsp;&nbsp;&nbsp;不合格&nbsp;</option>
                          	</select>
                          </TD>
                          <TD>
                          	<select	id="pchckdengji" name="workingCheckPo.pchckdengji">
                          		<option value="A">&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;</option>
                          		<option value="B">&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;</option>
                          		<option value="C">&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;</option>
                          	</select>
                          </TD>
						</TR>				  
                      </TBODY>
                    </TABLE>
                   <TABLE id="title2" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR height="24">
                          <TD align="center">
	                      	<img id="saveBtn" src="${ctx }/img/newbtn/btn_save_0.png" btn=btn title="保 存" onClick="javascript:insert()">
                          </TD>
                        </TR>
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
     

</form>
</body></html>