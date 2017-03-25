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
		assignmentZT();
		$('input').attr("readonly","readonly");
		$('select').attr("disabled","disabled");
	});
	
	function assignmentZT(){
		if($('#pchckcokeballglassod').text()!=''&&$('#pchckcokepostglassod').text()!=''&&$('#pchckcokeaxesod').text()!=''){
			$('#pchckcokeballglassod2').text((parseFloat($('#pchckcokeballglassod').text())+parseFloat($('#pchckcokepostglassod').text())).toFixed(2));
			$('#pchckcokepostglassod2').text((parseFloat($('#pchckcokepostglassod').text())-parseFloat($('#pchckcokepostglassod').text())-parseFloat($('#pchckcokepostglassod').text())).toFixed(2));
			$('#pchckcokeaxesod2').text($('#pchckcokeaxesod').text()<=90?parseFloat($('#pchckcokeaxesod').text())+parseFloat(90):parseFloat($('#pchckcokeaxesod').text())-parseFloat(90));
		}
			
		if($('#pchckcokeballglassos').text()!=''&&$('#pchckcokepostglassos').text()!=''&&$('#pchckcokeaxesos').text()!=''){
			$('#pchckcokeballglassos2').text((parseFloat($('#pchckcokeballglassos').text())+parseFloat($('#pchckcokepostglassos').text())).toFixed(2));
			$('#pchckcokepostglassos2').text((parseFloat($('#pchckcokepostglassos').text())-parseFloat($('#pchckcokepostglassos').text())-parseFloat($('#pchckcokepostglassos').text())).toFixed(2));
			$('#pchckcokeaxesos2').text($('#pchckcokeaxesos').text()<=90?parseFloat($('#pchckcokeaxesos').text())+parseFloat(90):parseFloat($('#pchckcokeaxesos').text())-parseFloat(90));
		}
				
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
		//workingCheckInsertForm.action = "getLastWorkingCheck.action?cid="+id;
		//workingCheckInsertForm.submit();
	}	
	function insert(){
		var workingPerson=document.getElementById("pchckprocesspersonid").value;
		if(workingPerson==''){
			alert('请选择加工师!');
			return false;
		}
		try{
		
		var i=0;
		$('input[pd=pd]').each(function(){
			if($(this).attr('style')=='BACKGROUND-COLOR: green'){
				i=i+1;
			}	
			if(i==13){
				$('#saveBtn').attr("disabled","disabled");
				workingCheckInsertForm.action = "insertWorkingCheck.action";
				workingCheckInsertForm.submit();
			}else if($(this).attr('style')=='BACKGROUND-COLOR: red'){
				alert('此栏位不在允差范围之内!');
				$(this).focus();
				throw '1';
			}
		});
		} catch(e){
			return;
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
<input type="hidden" id="salesid" name="salesid" value="${requestScope.ssesbsalesid}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜单信息</TD>
            <TD class=menubar_readme_text vAlign=bottom>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD>
          </TR>
      
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：配镜单信息</TD>
            <TD class=menubar_function_text align=right>
             <TABLE cellSpacing=0 cellPadding=0 border=0>
             </TABLE>
            </TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectInTransitDetails.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">配镜单信息</TD>
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                     <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
					  onclick="JavaScript:window.location.href='initInTransitDetailsSel.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">在途信息</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
					  onclick="JavaScript:window.location.href='selectGoodsOut.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">库存详细</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      onclick="JavaScript:window.location.href='selectWorkingCheckDetails.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">检验信息</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selectSalesLog.action?hid=${salesBasicPo.ssesbsalesid}';" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">付款记录</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>     
                         </TR>
                    </TBODY>
                  </TABLE>
                </TD>
			</TR></TBODY></TABLE>
		</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
						   <TD width="10%" height="30" class="table_body">配镜单号</TD>
			               <TD class="table_none" width="30%">${salesBasicPo.ssesbsalesid}</TD>
			               <TD width="10%" height="30" class="table_body">所属门店</TD>
			               <TD class="table_none" width="40%">${salesBasicPo.ssesbshopName}</TD>
                        </TR> 
                        <TR>
						   <TD width="10%" height="30" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="30%">${salesBasicPo.ssesbpersonName}　　【卡号：${salesBasicPo.ssesbMemberId}】</TD>
			               <TD width="10%" height="30" class="table_body">联系电话</TD>
			               <TD class="table_none" width="40%">${salesBasicPo.ssesbphone}</TD>
                        </TR>     
                        <TR>
						   <TD width="10%" height="30" class="table_body">加工师</TD>
			               <TD class="table_none" width="30%">
			               	${workingCheckPo.pchckprocesspersonname }
			               </TD>
			               <TD width="10%" height="30" class="table_body">检验员</TD>
			               <TD class="table_none" width="40%">${sessionScope.person.personName}</TD>
                        </TR> 
                        <TR>
						   <TD width="10%" height="30" class="table_body">配送地点</TD>
			               <TD class="table_none" width="30%" ${salesBasicPo.ssesbshopName== salesBasicPo.ssesbtakeshopname  ? '' : 'style="color: red;"' }>
			               	${salesBasicPo.ssesbtakeshopname}
			               </TD>
			               <TD width="10%" height="30" class="table_body">特殊加工要求</TD>
			               <TD class="table_none" width="40%">
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
					<table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                     <c:if test="${workingCheckPo.pchckcokeballglassod == null}">
                     <table id="jdjTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class="row" align=middle>
						  <TH width="10%" scope=col height="30"><font color="red">[×]该销售单未检验</font></TH>		
						  </TR>
						</TBODY>
					 </table>
                     </c:if>
                     <c:if test="${workingCheckPo.pchckcokeballglassod != null}">
                     <table id="jdjTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH width="10%" scope=col height="30">右眼(R)/左眼(L)</TH>		
						  <TH width="10%" scope=col height="30">子午面</TH>				
						  <TH width="10%" scope=col>球镜</TH>
						  <TH width="10%" scope=col>柱镜</TH>
						  <TH width="10%" scope=col>轴向</TH>
						  <TH width="15%" scope=col>斜视</TH>
						  <TH width="10%" scope=col>add</TH>
						  <TH width="10%" scope=col>瞳距</TH>
						  <TH width="15%" scope=col>商品名称</TH>
						  </TR>
                        
                        <TR class="row">
                          <TD align="center" height="30" rowspan="4">R</TD>
                          <TD height="30">主子午面一</TD>
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
                          <TD align="center" height="30">焦度计</TD>
                          <TD id="pchckcokeballglassod">${workingCheckPo.pchckcokeballglassod }</TD>
                          <TD id="pchckcokepostglassod">${workingCheckPo.pchckcokepostglassod }</TD>
                          <TD id="pchckcokeaxesod">${workingCheckPo.pchckcokeaxesod}</TD>
                          <TD rowspan="3" align="center">
                          	三棱镜：${workingCheckPo.pchckcokearriseglassod }&nbsp;&nbsp;&nbsp;&nbsp;
                          	基底：${workingCheckPo.pchckcokebasisod }
							<!-- ${workingCheckPo.pchckcokebasisod=='下' ? 'selected="selected"': ''} -->
                          		
                          	<!-- <input class="text_input60" type="text"  id="pchckcokearriseglassod1" name="workingCheckPo.pchckcokearriseglassod1" value="${workingCheckPo.pchckcokearriseglassod1 }">
                          	&nbsp;
                          	<select id="pchckcokebasisod1" name="workingCheckPo.pchckcokebasisod1">
                          		<option value=""></option>
                          		<option value="内" ${workingCheckPo.pchckcokebasisod1 != '内' ? '':'selected=selected'}>内</option>
                          		<option value="外" ${workingCheckPo.pchckcokebasisod1 != '外' ? '':'selected=selected'}>外</option>
                          		<option value="上" ${workingCheckPo.pchckcokebasisod1 != '上' ? '':'selected=selected'}>上</option>
                          		<option value="下" ${workingCheckPo.pchckcokebasisod1 != '下' ? '':'selected=selected'}>下</option> ${workingCheckPo.pchckcokebasisod1=='下' ? 'selected="selected"': ''} 
                          		
                          	</select> -->
                          </TD>
                          <TD rowspan="3">${workingCheckPo.pchckcokeaddod }</TD>
                          <TD rowspan="3">${workingCheckPo.pchckcokepupildistanceod }</TD>
						</TR>
						<tr class="row" >
						  <TD height="30">主子午面二</TD>
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod>0}">
						  	<TD>+${oDPo.ssesbballglassod+oDPo.ssesbpostglassod}</TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod<0}">
						  	<TD>${oDPo.ssesbballglassod+oDPo.ssesbpostglassod}</TD>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbballglassod+oDPo.ssesbpostglassod==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbpostglassod=='0.00'}">
						  	<TD>${oDPo.ssesbpostglassod}</TD>
						  </c:if>
						  <c:if test="${oDPo.ssesbpostglassod!='0.00'}">
							  	<c:if test="${-oDPo.ssesbpostglassod>0}">
							  		<TD>+${-oDPo.ssesbpostglassod}</TD>
							    </c:if>
							    <c:if test="${-oDPo.ssesbpostglassod<0}">
							  		<TD>${-oDPo.ssesbpostglassod}</TD>
							    </c:if>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbaxesod=='0.00'}">
						  	<TD>${oDPo.ssesbaxesod}</TD>
						  </c:if>
						  
						  <c:if test="${oDPo.ssesbaxesod!='0.00'}">
						  		<c:if test="${oDPo.ssesbaxesod<=90}">
						  			<TD>${oDPo.ssesbaxesod+90}</TD>
						    	</c:if>
						  
						  		<c:if test="${oDPo.ssesbaxesod>90}">
						  			<TD>${oDPo.ssesbaxesod-90}</TD>
						  		</c:if>
						  </c:if>
						  			  
						</tr>
						<tr class="row" ><!-- onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" -->
						  <TD height="30">焦度计</TD>
						  <TD id="pchckcokeballglassod2"></TD>
                          <TD id="pchckcokepostglassod2"></TD>
                          <TD id="pchckcokeaxesod2"></TD>
						  					 
						</tr>
						<TR class="row" >
                          <TD align="center" height="30" rowspan="4">L</TD>
                          <TD height="30">主子午面一</TD>
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
                          <TD align="center" height="30">焦度计</TD>
                          <TD id="pchckcokeballglassos">${workingCheckPo.pchckcokeballglassos }</TD>
                          <TD id="pchckcokepostglassos">${workingCheckPo.pchckcokepostglassos }</TD>
                          <TD id="pchckcokeaxesos">${workingCheckPo.pchckcokeaxesos }</TD>
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
						  <TD height="30">主子午面二</TD>
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos>0}">
						  	<TD>+${oSPo.ssesbballglassos+oSPo.ssesbpostglassos}</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos<0}">
						  	<TD>${oSPo.ssesbballglassos+oSPo.ssesbpostglassos}</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbballglassos+oSPo.ssesbpostglassos==0}">
						  	<TD>0.00</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbpostglassos=='0.00'}">
						  	<TD>${oSPo.ssesbpostglassos}</TD>
						  </c:if>
						  <c:if test="${oSPo.ssesbpostglassos!='0.00'}">
							  	<c:if test="${-oSPo.ssesbpostglassos>0}">
							  		<TD>+${-oSPo.ssesbpostglassos}</TD>
							    </c:if>
							    <c:if test="${-oSPo.ssesbpostglassos<0}">
							  		<TD>${-oSPo.ssesbpostglassos}</TD>
							    </c:if>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbaxesos=='0.00'}">
						  	<TD>${oSPo.ssesbaxesos}</TD>
						  </c:if>
						  
						  <c:if test="${oSPo.ssesbaxesos!='0.00'}">
						  		<c:if test="${oSPo.ssesbaxesos<=90}">
						  			<TD>${oSPo.ssesbaxesos+90}</TD>
						    	</c:if>
						  
						  		<c:if test="${oSPo.ssesbaxesos>90}">
						  			<TD>${oSPo.ssesbaxesos-90}</TD>
						  		</c:if>
						  </c:if>				  
						</tr>
						<tr class="row">
						  <TD height="30">焦度计</TD>
						  <TD id="pchckcokeballglassos2"></TD>
                          <TD id="pchckcokepostglassos2"></TD>
                          <TD id="pchckcokeaxesos2"></TD>
								 
						</tr>		
						
						</TBODY>
                    </TABLE>
                     <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="30">
						  <TH width="10%" scope=col>光心垂差</TH>						
						  <TH width="18%" scope=col>光心垂差(焦度计)</TH>
						  <TH width="18%" scope=col>光心高度</TH>
						  <TH width="18%" scope=col>色泽互差</TH>
						  <TH width="18%" scope=col>装配质量</TH>
						  <TH width="18%" scope=col>整形</TH>
						  </TR>
                        <TR class="row">
                          <TD align="center" height="30" id="oldgxcc"> ${salesBasicPo.ssesblightvertical}</TD>
                          <TD>${workingCheckPo.pchckcokecentervertical }</TD>
                          <TD>√</TD>
                          <TD>√</TD>
                          <TD>√</TD>
                          <TD>√</TD>
						</TR>				  
                      </TBODY>
                    </TABLE>
                    </c:if>
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