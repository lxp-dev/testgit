<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css">
<!--
.STYLE4 {color: #FF0000}
.STYLE5 {color: #FFFF00; font-weight: bold; }

.PrivateBorderBlue{
	border: 1px solid #9ABCFA;
}

.PrivateBorderGreen{
	border: 1px solid #6BEF72;
}
.salesout{
background:transparent;border:0px;
}
.PrivateBorderYellow{
	border: 1px solid #F5E25C;
}
-->
</style>
<script type="text/javascript"><!--

	function showSaleserName(saleser){
		var saler="当前销售人员:"+saleser+",更换销售人员";
		$('#saleser').remove();
		$('#saleserDiv').html( '<input name="button32" id="saleser"  type="button" value="当前销售人员:'+saleser+',更换销售人员" align="left" onclick="changeSaleser()">');
		$('#saleser').btn().init();
	}
	
	function changeSaleser(){
		$('#ssesbsalerid').attr("disabled","");
	}
	
	function disabledSelect(){
		$('#ssesbsalerid').attr("disabled","disabled");
		$('[name=salesBasicPo.ssesbsalerid]').val($('#ssesbsalerid').val());
	}
	
	//按键改变数值
	function changeFocus(obj)
	{
		
	    if(event.keyCode==38){
			if(obj.value == ''){
				obj.value=0.25;
			}
			else{
			    obj.value = (parseFloat(obj.value)+0.25).toFixed(2);		
			}
		}
	    if(event.keyCode==40){
			if(obj.value == ''){
				obj.value = -0.25;
			}else{
				obj.value = (parseFloat(obj.value)-0.25).toFixed(2);			
			}
		}
	}
	
	
	/*function details(id){
		showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}*/
	
	/*
	*填写邮寄信息
	*/
	function toMailInsert(salseID ,smecimemberid ,smeciname ,smeciphone ){
		if($('#smeciname').val() != ''){
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initToMailInsert.action?salseID="+salseID+"&smecimemberid="+smecimemberid+"&smeciname="+smeciname+"&smeciphone="+smeciphone,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initToMailInsert.action?salseID="+salseID+"&smecimemberid="+smecimemberid+"&smeciname="+smeciname+"&smeciphone="+smeciphone,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【邮寄信息】";
		}else{
			alert("请选择顾客！");
		}
	}
	
	/*
 * 现有日期加上天数
 */
	function   DateAdd(strInterval,   NumDay,   dtDate)   {   
	  var   dtTmp   =   new   Date(dtDate);   
	  if   (isNaN(dtTmp))   dtTmp   =   new   Date();   
	  switch   (strInterval)   {   
	   case   "s":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   (1000   *   parseInt(NumDay))); 
	     break;  
	   case   "n":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   (60000   *   parseInt(NumDay))); 
	     break;  
	   case   "h":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   (3600000   *   parseInt(NumDay)));
	     break;
	   case   "d":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   (86400000   *   parseInt(NumDay)));
	     break;
	   case   "w":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   ((86400000   *   7)   *   parseInt(NumDay))); 
	     break;
	   case   "m":
	     dtTmp  =   new   Date(dtTmp.getFullYear(),   (dtTmp.getMonth())+parseInt(NumDay),   dtTmp.getDate(),   dtTmp.getHours(),   dtTmp.getMinutes(),   dtTmp.getSeconds());
	     break;   
	   case   "y":
	     dtTmp  =   new   Date(dtTmp.getFullYear()+parseInt(NumDay),   dtTmp.getMonth(),   dtTmp.getDate(),   dtTmp.getHours(),   dtTmp.getMinutes(),   dtTmp.getSeconds());
	     break;
	  }
	  var mStr=new String(dtTmp.getMonth()+1);
	  var dStr=new String(dtTmp.getDate());
	  if (mStr.length==1){
	   mStr="0"+mStr;
	  }
	  if (dStr.length==1){
	   dStr="0"+dStr;
	  }
	  return dtTmp.getFullYear()+"-"+mStr+"-"+dStr;
	}   
	
	
	function   DateAcc(strInterval,   NumDay,   dtDate)   {   
	  var   dtTmp   =   new   Date(dtDate);   
	  if   (isNaN(dtTmp))   dtTmp   =   new   Date();   
	  switch   (strInterval)   {   
	   case   "s":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   (1000   *   parseInt(NumDay))); 
	     break;  
	   case   "n":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   (60000   *   parseInt(NumDay))); 
	     break;  
	   case   "h":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   (3600000   *   parseInt(NumDay)));
	     break;
	   case   "d":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   -   (86400000   *   parseInt(NumDay)));
	     break;
	   case   "w":
	     dtTmp  =   new   Date(Date.parse(dtTmp)   +   ((86400000   *   7)   *   parseInt(NumDay))); 
	     break;
	   case   "m":
	     dtTmp  =   new   Date(dtTmp.getFullYear(),   (dtTmp.getMonth())+parseInt(NumDay),   dtTmp.getDate(),   dtTmp.getHours(),   dtTmp.getMinutes(),   dtTmp.getSeconds());
	     break;   
	   case   "y":
	     //alert(dtTmp.getFullYear());
	     dtTmp  =   new   Date(dtTmp.getFullYear()+parseInt(NumDay),   dtTmp.getMonth(),   dtTmp.getDate(),   dtTmp.getHours(),   dtTmp.getMinutes(),   dtTmp.getSeconds());
	     //alert(dtTmp);
	     break;
	  }
	  var mStr=new String(dtTmp.getMonth()+1);
	  var dStr=new String(dtTmp.getDate());
	  if (mStr.length==1){
	   mStr="0"+mStr;
	  }
	  if (dStr.length==1){
	   dStr="0"+dStr;
	  }
	  return dtTmp.getFullYear()+"-"+mStr+"-"+dStr;
	}   
	
	
			
	function calculate(day)
	{
		var d = new Date()
		var vYear = d.getFullYear()
		var vMon = d.getMonth() + 1
		var vDay = d.getDate()
		var vHour=d.getHours();
		var vMin=d.getMinutes();
		if(vMon<10){
			vMon='0'+vMon;
		}
		if(vDay<10){
			vDay='0'+vDay;
		}
		if(vHour<10){
			vHour='0'+vHour;
		}
		if(vMin<10){
			vMin='0'+vMin;
		}
		 uValue=vYear+'-'+vMon+'-'+vDay;
		 uValue=uValue.replace("-","/").replace("-","/");

	 	if(day=='0'){
	 		day=3;
	 	}
	    $('#ssesbtakeglassdata').val(DateAdd('d',day,uValue)+' '+vHour+':'+vMin);
	}
	
	
	
	function selGlassType(type){
		$('#recipetype').val(type);
		$('input[needChange=needChange]').each(function(){
			$(this).unbind("keydown");
			$(this).bind("keydown",function(){
				changeFocus(this);
			});
		});
		
			$(':input[yyorder]').each(function(){
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('yyorder');
						$(':input[yyorder='+accAdd(index,1)+']').focus();
					}
				});
		});
		$('#ssesbrecipetype').val(type);
		// 远用
		if(type == '1'){
			$('#yuanyong').show('fast');// 远用
			$("[glassType='yuanyong']").removeAttr("disabled");
			$("[glassType][glassType!='yuanyong']").each(function(){
				if(this.glassType != null) {
					this.disabled = true;
					this.value = '';
				}
			});
			
			$('#jinyong').hide('fast');//  近用
			
			$('#jianjin').hide('fast');//  双光渐进
			$('#zhongyong').hide('fast');//中用
		}else if(type == '2'){//近用
			$('#yuanyong').hide('fast');// 远用
			$('#jinyong').show('fast');//  近用
			$("[glassType='jinyong']").removeAttr("disabled");
			$("[glassType][glassType!='jinyong']").each(function(){
				if(this.glassType != null) {
					this.disabled = true;
					this.value = '';
				}
			});
			
			$('#jianjin').hide('fast');//  双光渐进
			$('#zhongyong').hide('fast');//中用
		}else if(type == '3'){//双光/渐进
			$('#yuanyong').hide('fast');// 远用
			$('#jinyong').hide('fast');//  近用
			
			$('#jianjin').show('fast');//  双光渐进
			$("[glassType='jianjin']").removeAttr("disabled");
			$("[glassType][glassType!='jianjin']").each(function(){
				if(this.glassType != null) {
					this.disabled = true;
					this.value = '';
				}
			});
			$('#zhongyong').hide('fast');//中用
		}else if(type == '5'){//中用
			$('#yuanyong').hide('fast');// 远用
			$('#jinyong').hide('fast');//  近用
			$('#zhongyong').show('fast');//中用
			$('#jianjin').hide('fast');//  双光渐进
			$("[glassType='zhongyong']").removeAttr("disabled");
			$("[glassType][glassType!='zhongyong']").each(function(){
				if(this.glassType != null) {
					this.disabled = true;
					this.value = '';
				}
			});
		
		}else {
			$('#yuanyong').hide('fast');// 远用
			$('#jinyong').hide('fast');//  近用
			$('#jianjin').hide('fast');//  双光渐进
			
			$("input[glassType]").each(function(){
				if(this.glassType != null) this.disabled = true;
			});
			
			$("select[glassType]").each(function(){
				if(this.glassType != null) this.disabled = true;
			});	
		}
	}
	
	// 翻方子
	function turnPrescription(sph, cyl, axis){
		sph.value = sph.value.replace('+', '');
		cyl.value = cyl.value.replace('+', '');
		
		if(cyl.value > 0){
			sph.value = (new Number(sph.value) + new Number(cyl.value)).toFixed(2);
			
			cyl.value = -cyl.value;
			
			if(!isNaN(axis.value) && axis.value > 90){
				axis.value = (new Number(axis.value) - 90).toFixed(0);
			}else if(!isNaN(axis.value) && axis.value <= 90){
				axis.value = (new Number(axis.value) + 90).toFixed(0);
			}else {
				axis.value = 0;
			}
		}
		checkData(sph);
		checkData(cyl);
		checkAxiss(axis);
	}
	
	function clearValue(){
		$('#ssesbrecipetype').val('');
		
		$("span[id='ssesbbasis']").unbind();
		
		document.getElementById('recipetype').selectedIndex = 0;
		document.getElementById('recipetype').disabled = false;
		
		var inputObj = $("[glassType]");
		inputObj.attr('disabled', true);
		inputObj.removeAttr('readOnly');
		inputObj.val('');
		
		$('#yuanyong').hide('fast');// 远用
			
		$('#jinyong').hide('fast');//  近用
		
		$('#jianjin').hide('fast');//  双光渐进
		
		
		$('#ssesboptid').val('');
		$('#ssesboptometryid').val('');
		$('#inspectionid').val('');
	}
	
	function selGlassTime(Datetime)
	{
	    var day = new Date();
        var Year = 0;
        var Month = 0;
        var Day = 0;
        var CurrentDate = "";
        //初始化时间 
        Year = day.getFullYear(); //ie火狐下都可以 
        Month = day.getMonth() + 1;
        Day = day.getDate();
        CurrentDate += Year + "-";
        if (Month >= 10) {
            CurrentDate += Month + "-";
        }
        else {
            CurrentDate += "0" + Month + "-";
        }
        if (Day >= 10) {
            CurrentDate += Day;
        }
        else {
            CurrentDate += "0" + Day;
        }
         CurrentDate;
		if(Datetime!=CurrentDate){
		   alert("您选择的处方非当日处方!");
		}
	}
	
	function addGlassGoods(direction, materialType){
		
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		if(glassOD=='R'&&direction=='R'){
			alert('右眼镜片数量过多!');
			return;
		}
		if(glassOS=='L'&&direction=='L'){
			alert('左眼镜片数量过多!');
			return;
		}
		if($('#recipetype').val()=='0'&&$('#recipetype').attr('disabled')==false)
		{
			alert('请选择处方类型!');
			return;
		}
		//球镜   sph
		//柱镜  cyl
	 	//下加 add
		//checkbox  name=materialType  右眼树脂value='shuzhi'玻璃 value='boli' 
		var sph = '';
		var cyl = '';
		var add = '';
		var materialType = (direction == 'R') ? $('input[name=materialTypeR]:checked').val() : $('input[name=materialTypeL]:checked').val();
		var recipeType = $('#ssesbrecipetype').val();
		if(recipeType == 1){ //远用
			// 翻方子
			
			if($('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				return;
			}
			if($('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				return;
			}
			if($('input[glassType="yuanyong"][name$="ssesbinterhighod"]')[0].value==''){
				alert('请填写右眼远用瞳距!');
				return;
			}
			if($('input[glassType="yuanyong"][name$="ssesbinterhighos"]')[0].value==''){
				alert('请填写左眼远用瞳距!');
				return;
			}
			
			turnPrescription($('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="yuanyong"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="yuanyong"][name$="ssesbaxesos"]')[0]);
				
			sph = (direction == 'R') ? 
				$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0] : $('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0];
			cyl = (direction == 'R') ? 
				$('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0] : $('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0];
			
			
			
		}else if(recipeType == 2){ //近用
			// 翻方子
			if($('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				return;
			}
			if($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				return;
			}
			if($('input[glassType="jinyong"][name$="ssesbinterdistanceod"]')[0].value==''){
				alert('请填写右眼近用瞳距!');
				return;
			}
			if($('input[glassType="jinyong"][name$="ssesbinterdistanceos"]')[0].value==''){
				alert('请填写左眼近用瞳距!');
				return;
			}
			
			turnPrescription($('input[glassType="jinyong"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="jinyong"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="jinyong"][name$="ssesbaxesos"]')[0]);
				
			sph = (direction == 'R') ? 
				$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0] : $('input[glassType="jinyong"][name$="ssesbballglassos"]')[0];
			cyl = (direction == 'R') ? 
				$('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0] : $('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0];
			add = (direction == 'R') ? 
				$('input[glassType="jinyong"][name$="ssesbaddod"]')[0] : $('input[glassType="jinyong"][name$="ssesbaddos"]')[0];
			
				
		}else if(recipeType == 3){ //渐进/双光
			if($('input[glassType="jianjin"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				return;
			}
			if($('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				return;
			}
			
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighod"]')[0].value=='')){
				alert('请填写右眼瞳距!');
				return;
			}
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighos"]')[0].value=='')){
				alert('请填写左眼瞳距!');
				return;
			}
			
			// 翻方子	
			turnPrescription($('input[glassType="jianjin"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="jianjin"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="jianjin"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="jianjin"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="jianjin"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="jianjin"][name$="ssesbaxesos"]')[0]);
				
			sph = (direction == 'R') ? 
				$('input[glassType="jianjin"][name$="ssesbballglassod"]')[0] : $('input[glassType="jianjin"][name$="ssesbballglassos"]')[0];
			cyl = (direction == 'R') ? 
				$('input[glassType="jianjin"][name$="ssesbpostglassod"]')[0] : $('input[glassType="jianjin"][name$="ssesbpostglassos"]')[0];
			add = (direction == 'R') ? 
				$('input[glassType="jianjin"][name$="ssesbaddod"]')[0] : $('input[glassType="jianjin"][name$="ssesbaddos"]')[0];
		}else if(recipeType == 5){ //中用
			// 翻方子
			
			if($('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				return;
			}
			if($('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				return;
			}
			if($('input[glassType="zhongyong"][name$="ssesbinterhighod"]')[0].value==''){
				alert('请填写右眼远用瞳距!');
				return;
			}
			if($('input[glassType="zhongyong"][name$="ssesbinterhighos"]')[0].value==''){
				alert('请填写左眼远用瞳距!');
				return;
			}
			
			turnPrescription($('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="zhongyong"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="zhongyong"][name$="ssesbaxesos"]')[0]);
				
			sph = (direction == 'R') ? 
				$('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0] : $('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0];
			cyl = (direction == 'R') ? 
				$('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0] : $('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0];
			
			
			
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSellLensSel.action?sph="+sph.value+"&cyl="+cyl.value+"&add="+ ((add != '') ? add.value : '') +"&glassFlag=" + direction+"&materialType="+materialType+"&recipeType="+recipeType,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSellLensSel.action?sph="+sph.value+"&cyl="+cyl.value+"&add="+ ((add != '') ? add.value : '') +"&glassFlag=" + direction+"&materialType="+materialType+"&recipeType="+recipeType,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【镜片查询】";
	}
	function toRound(){
		var frm = window.parent.frames;
		for (var i=0; i < frm.length; i++){
			if(frm[i].name=='hiddenTop'){
				frm[i].toTop();
			}
			if(frm[i].name=='centerframe'){
				frm[i].toLeft();
			}
			if(frm[i].name=='top'){
				frm[i].toReload();
			}
		}
	}
	//球镜、柱镜
	var re1 = /^[\+\-]?[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	
	//视力
	var re2 = /^[0-9]{1}([.]{1}[0-9]{1})?$/;
	
	//棱镜、下加
	var re3 = /^[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	
	//瞳距
	var re4 = /^[0-9][0-9](\.[0-9])?$/;
	
	//直径
	var re5 = /^[0-9]*([.]{0,1}[0-9])$/;
	
	var orderCycle = '0'; //委外加工周期
	
	//验证棱镜、下加
	function checkLjXj(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re3.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			addZero(obj);
		}
	}
	
	//验证瞳距
	function checkPupilDistance(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re4.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		}
		
		vaAddZero(obj);
	}
	
	//验证视力
	function checkVA(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		if (!(re2.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			vaAddZero(obj);
		}
	}
	
	//验证球镜、柱镜
	function checkData(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		
		if(parseFloat(obj.value)%0.25!=0){
			alert("球径、柱径、ADD应为 0.25的倍数！");
			obj.select();
			return;
		}
		
		if (!(re1.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			obj.value = obj.value.replace("+", "");
			addZero(obj);
			if(obj.value > 0){
				obj.value = '+' + obj.value;
			}
		}
	}
	
	//验证轴向
	function checkAxiss(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}

		if (isNaN(obj.value)) {
			
			alert("输入错误！");
			obj.select();
			return;
		}
		
		var axis = parseInt(obj.value);
		
		if (axis > 180){
			obj.value = axis - 180;
		}else if (axis < 0 ){
			obj.value = axis + 180;
		}
	}
	
	//补零
	function addZero(obj) {
		if (obj.value.indexOf(".") == -1) {
			obj.value += ".00";
		} else if (obj.value.indexOf(".") == obj.value.length - 2) {
			obj.value += "0";
		}
	}
	
	//视力补零
	function vaAddZero(obj) {
		if (obj.value.indexOf(".") == -1) {
			obj.value += ".0";
		}
	}
	
	$(document).ready(function(){
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	
		$('[name=salesBasicPo.ssesbsalerid]').val($('#ssesbsalerid').val());
		var frm = window.parent.frames;
		for (var i=0; i < frm.length; i++){
			if(frm[i].name=='hiddenTop'){
				frm[i].toTop();
			}
			if(frm[i].name=='centerframe'){
				frm[i].toLeft();
			}
			if(frm[i].name=='top'){
				frm[i].toReload();
			}	
		}
		
		
		// 球镜、柱镜
		$("input[sphcyl='sphcyl']").each(function(){
		 	$(this).bind('blur',function(){
				checkData(this);
			});
		});
	
		//验证棱镜、下加
		$("input[ljxj='ljxj']").each(function(){
		 	$(this).bind('blur',function(){
				checkLjXj(this);
			});
		}); 
		
		//验证轴向
		$("input[axes='axes']").each(function(){
		 	$(this).bind('blur',function(){
				checkAxiss(this);
			});
		});
		
		//验证瞳距
		$("input[tongju='tongju']").each(function(){
		 	$(this).bind('blur',function(){
				checkPupilDistance(this);
			});
		});
		
		
		//初始化页面下拉列表选中
		$('#ssesblocation').attr('value','${person.departmentID}');
		
		//订做方式。
		$('#ssesbtakeglasstype').change(function(){
			calculate($(this).val());
		});
		
		//赠品匹配
		<s:iterator value='giftsList' status="index">
		if('${bgsgoodstype}'=='0'){
			$('#jh').click(function(){
				addGifts({'bgsgoodsid':'${bgsgoodsid}','bgsgoodsbarcode':'${bgsgoodsbarcode}','bgsgoodsname':'${bgsgoodsname}','bgsviewname':'${bgsviewname}','bgsgoodstype':'${bgsgoodstype}','bgscostprice':'${bgscostprice}','bgsnottaxrate':'${bgsnottaxrate}'})
			});
		}
		if('${bgsgoodstype}'=='1'){
			$('#jb').click(function(){
				addGifts({'bgsgoodsid':'${bgsgoodsid}','bgsgoodsbarcode':'${bgsgoodsbarcode}','bgsgoodsname':'${bgsgoodsname}','bgsviewname':'${bgsviewname}','bgsgoodstype':'${bgsgoodstype}','bgscostprice':'${bgscostprice}','bgsnottaxrate':'${bgsnottaxrate}'})
			});
		}
		if('${bgsgoodstype}'=='2'){
			$('#ysl').click(function(){
				addGifts({'bgsgoodsid':'${bgsgoodsid}','bgsgoodsbarcode':'${bgsgoodsbarcode}','bgsgoodsname':'${bgsgoodsname}','bgsviewname':'${bgsviewname}','bgsgoodstype':'${bgsgoodstype}','bgscostprice':'${bgscostprice}','bgsnottaxrate':'${bgsnottaxrate}'})
			});
		}
		if('${bgsgoodstype}'=='3'){
			$('#gjjb').click(function(){
				addGifts({'bgsgoodsid':'${bgsgoodsid}','bgsgoodsbarcode':'${bgsgoodsbarcode}','bgsgoodsname':'${bgsgoodsname}','bgsviewname':'${bgsviewname}','bgsgoodstype':'${bgsgoodstype}','bgscostprice':'${bgscostprice}','bgsnottaxrate':'${bgsnottaxrate}'})
			});
		}
		</s:iterator>
		
		
		//实收金额
		$('#sesbpsalsvalue').keyup(function(){
			if(isNaN($(this).val())){
				$(this).val('');
			}
			if($(this).val()==''){
				$('#ssje').text("￥0.00")
			}else{
				$('#ssje').text("￥"+parseData($(this).val()));
			}
		});
		
		$('#sesbpsalsvalue').blur(function(){
			if(!isNaN($(this).val())){
				if($(this).val()==''){
					$('#ssje').text('￥0.00');
					$(this).val('0.00');
				}else{
					$(this).val(parseData($(this).val()));
				}
			}else{
				$(this).val('');
			}
			
			if(accAdd($(this).val(),'-'+$('#ysje').text().replace('￥',''))>0){
				alert('实收金额不能大于应收金额!');
				$(this).val($('#ysje').text().replace('￥',''));
				$('#ssje').text('￥'+$(this).val());
				$(this).focus();
				return;
			}
			
		});
		
		$('input[needChange=needChange]').each(function(){
			$(this).bind("keydown",function(){
				changeFocus(this);
			});
		});
		
		if($('#titlediscount').val()!=''){
			if(parseFloat($('#titlediscount').val())==1){
				$('#titlediscount').val('1.0');
			}else{
				$('#titlediscount').val('${customerInfoPo.fmmdiscount}');
			}
		}
		
		setDiscount1($('#titlediscount').val());
		
		
	});
	
	function inspection(obj, type){
	
		$('input[needChange=needChange]').each(function(){
			$(this).unbind("keydown");
		});
		var json = obj;
		$('#ssesboptid').val(json.sopipoptometrybasicid);
		$('#ssesboptometryid').val(json.sopipoptometryid);
		$('#inspectionid').val(json.sopipinspectionid);
		var ssesbbasis = $("span[id='ssesbbasis']");
		ssesbbasis.unbind();
		ssesbbasis.bind("mouseover", function(){this.setCapture();});
		ssesbbasis.bind("mouseout", function(){this.releaseCapture();});
					
		// 远用
		if(type == '1'){
			$("[glassType='yuanyong']").each(function(){
				this.readOnly = true;
				if("salesBasicPo.ssesbballglassod" == this.name){ //球镜
					this.value = json.sopipballglassod;
				}else if("salesBasicPo.ssesbballglassos" == this.name){ //球镜
					this.value = json.sopipballglassos;
				}else if("salesBasicPo.ssesbpostglassod" == this.name){ //柱镜
					this.value = json.sopippostglassod;
				}else if("salesBasicPo.ssesbpostglassos" == this.name){ //柱镜
					this.value = json.sopippostglassos;
				}else if("salesBasicPo.ssesbaxesod" == this.name){ //轴向
					this.value = json.sopipaxesod;
				}else if("salesBasicPo.ssesbaxesos" == this.name){ //轴向
					this.value = json.sopipaxesos;
				}else if("salesBasicPo.ssesbarriseglassod" == this.name){ //棱镜
					this.value = json.sopiparriseglassod1;
				}else if("salesBasicPo.ssesbarriseglassos" == this.name){ //棱镜
					this.value = json.sopiparriseglassos1;
				}else if("salesBasicPo.ssesbbasisod" == this.name){ //基底
					this.value = json.sopipbasisod1;
				}else if("salesBasicPo.ssesbbasisos" == this.name){ //基底
					this.value = json.sopipbasisos1;
				}else if("salesBasicPo.ssesbinterhighod" == this.name){ //远用瞳距
					this.value = json.sopipinterhighod;
				}else if("salesBasicPo.ssesbinterhighos" == this.name){ //远用瞳距
					this.value = json.sopipinterhighos;
				}else if("salesBasicPo.ssesbfarvaod" == this.name){ //远用VA
					this.value = json.sopipfarvaod;
				}else if("salesBasicPo.ssesbfarvaos" == this.name){ //远用VA
					this.value = json.sopipfarvaos;
				}
			});
		}else if (type == '2'){
			$("[glassType='jinyong']").each(function(){
				this.readOnly = true;
				if("salesBasicPo.ssesbballglassod" == this.name){ //球镜
					this.value = json.sopipballglassod;
				}else if("salesBasicPo.ssesbballglassos" == this.name){ //球镜
					this.value = json.sopipballglassos;
				}else if("salesBasicPo.ssesbpostglassod" == this.name){ //柱镜
					this.value = json.sopippostglassod;
				}else if("salesBasicPo.ssesbpostglassos" == this.name){ //柱镜
					this.value = json.sopippostglassos;
				}else if("salesBasicPo.ssesbaxesod" == this.name){ //轴向
					this.value = json.sopipaxesod;
				}else if("salesBasicPo.ssesbaxesos" == this.name){ //轴向
					this.value = json.sopipaxesos;
				}else if("salesBasicPo.ssesbaddod" == this.name){ //ADD
					this.value = json.sopipaddod;
				}else if("salesBasicPo.ssesbaddos" == this.name){ //ADD
					this.value = json.sopipaddos;
				}else if("salesBasicPo.ssesbarriseglassod" == this.name){ //棱镜
					this.value = json.sopiparriseglassod1;
				}else if("salesBasicPo.ssesbarriseglassos" == this.name){ //棱镜
					this.value = json.sopiparriseglassos1;
				}else if("salesBasicPo.ssesbbasisod" == this.name){ //基底
					this.value = json.sopipbasisod1;
				}else if("salesBasicPo.ssesbbasisos" == this.name){ //基底
					this.value = json.sopipbasisos1;
				}else if("salesBasicPo.ssesbinterdistanceod" == this.name){ //近用瞳距
					this.value = json.sopipinterdistanceod;
				}else if("salesBasicPo.ssesbinterdistanceos" == this.name){ //远用瞳距
					this.value = json.sopipinterdistanceos;
				}else if("salesBasicPo.ssesbfarvaod" == this.name){ //远用VA
					this.value = json.sopipfarvaod;
				}else if("salesBasicPo.ssesbfarvaos" == this.name){ //远用VA
					this.value = json.sopipfarvaos;
				}else if("salesBasicPo.ssesbclosevaod" == this.name){ //近用VA
					this.value = json.sopipclosevaod;
				}else if("salesBasicPo.ssesbclosevaos" == this.name){ //近用VA
					this.value = json.sopipclosevaos;
				}
			});
		}else if (type == '3'){
			$("[glassType='jianjin']").each(function(){
				this.readOnly = true;
				if("salesBasicPo.ssesbballglassod" == this.name){ //球镜
					this.value = json.sopipballglassod;
				}else if("salesBasicPo.ssesbballglassos" == this.name){ //球镜
					this.value = json.sopipballglassos;
				}else if("salesBasicPo.ssesbpostglassod" == this.name){ //柱镜
					this.value = json.sopippostglassod;
				}else if("salesBasicPo.ssesbpostglassos" == this.name){ //柱镜
					this.value = json.sopippostglassos;
				}else if("salesBasicPo.ssesbaxesod" == this.name){ //轴向
					this.value = json.sopipaxesod;
				}else if("salesBasicPo.ssesbaxesos" == this.name){ //轴向
					this.value = json.sopipaxesos;
				}else if("salesBasicPo.ssesbaddod" == this.name){ //ADD
					this.value = json.sopipaddod;
				}else if("salesBasicPo.ssesbaddos" == this.name){ //ADD
					this.value = json.sopipaddos;
				}else if("salesBasicPo.ssesbarriseglassod" == this.name){ //棱镜
					this.value = json.sopiparriseglassod1;
				}else if("salesBasicPo.ssesbarriseglassos" == this.name){ //棱镜
					this.value = json.sopiparriseglassos1;
				}else if("salesBasicPo.ssesbbasisod" == this.name){ //基底
					this.value = json.sopipbasisod1;
				}else if("salesBasicPo.ssesbbasisos" == this.name){ //基底
					this.value = json.sopipbasisos1;
				}else if("salesBasicPo.ssesbinterhighod" == this.name){ //远用瞳距
					this.value = json.sopipinterhighod;
				}else if("salesBasicPo.ssesbinterhighos" == this.name){ //远用瞳距
					this.value = json.sopipinterhighos;
				}else if("salesBasicPo.ssesbinterdistanceod" == this.name){ //近用瞳距
					this.value = json.sopipinterdistanceod;
				}else if("salesBasicPo.ssesbinterdistanceos" == this.name){ //远用瞳距
					this.value = json.sopipinterdistanceos;
				}else if("salesBasicPo.ssesbfarvaod" == this.name){ //远用VA
					this.value = json.sopipfarvaod;
				}else if("salesBasicPo.ssesbfarvaos" == this.name){ //远用VA
					this.value = json.sopipfarvaos;
				}else if("salesBasicPo.ssesbclosevaod" == this.name){ //近用VA
					this.value = json.sopipclosevaod;
				}else if("salesBasicPo.ssesbclosevaos" == this.name){ //近用VA
					this.value = json.sopipclosevaos;
				}
			});
		}else if (type == '5'){
			$("[glassType='zhongyong']").each(function(){
				this.readOnly = true;
				if("salesBasicPo.ssesbballglassod" == this.name){ //球镜
					this.value = json.sopipballglassod;
				}else if("salesBasicPo.ssesbballglassos" == this.name){ //球镜
					this.value = json.sopipballglassos;
				}else if("salesBasicPo.ssesbpostglassod" == this.name){ //柱镜
					this.value = json.sopippostglassod;
				}else if("salesBasicPo.ssesbpostglassos" == this.name){ //柱镜
					this.value = json.sopippostglassos;
				}else if("salesBasicPo.ssesbaxesod" == this.name){ //轴向
					this.value = json.sopipaxesod;
				}else if("salesBasicPo.ssesbaxesos" == this.name){ //轴向
					this.value = json.sopipaxesos;
				}else if("salesBasicPo.ssesbaddod" == this.name){ //ADD
					this.value = json.sopipaddod;
				}else if("salesBasicPo.ssesbaddos" == this.name){ //ADD
					this.value = json.sopipaddos;
				}else if("salesBasicPo.ssesbarriseglassod" == this.name){ //棱镜
					this.value = json.sopiparriseglassod1;
				}else if("salesBasicPo.ssesbarriseglassos" == this.name){ //棱镜
					this.value = json.sopiparriseglassos1;
				}else if("salesBasicPo.ssesbbasisod" == this.name){ //基底
					this.value = json.sopipbasisod1;
				}else if("salesBasicPo.ssesbbasisos" == this.name){ //基底
					this.value = json.sopipbasisos1;
				}else if("salesBasicPo.ssesbinterhighod" == this.name){ //远用瞳距
					this.value = json.sopipinterhighod;
				}else if("salesBasicPo.ssesbinterhighos" == this.name){ //远用瞳距
					this.value = json.sopipinterhighos;
				}else if("salesBasicPo.ssesbinterdistanceod" == this.name){ //近用瞳距
					this.value = json.sopipinterdistanceod;
				}else if("salesBasicPo.ssesbinterdistanceos" == this.name){ //远用瞳距
					this.value = json.sopipinterdistanceos;
				}else if("salesBasicPo.ssesbfarvaod" == this.name){ //远用VA
					this.value = json.sopipfarvaod;
				}else if("salesBasicPo.ssesbfarvaos" == this.name){ //远用VA
					this.value = json.sopipfarvaos;
				}else if("salesBasicPo.ssesbclosevaod" == this.name){ //近用VA
					this.value = json.sopipclosevaod;
				}else if("salesBasicPo.ssesbclosevaos" == this.name){ //近用VA
					this.value = json.sopipclosevaos;
				}
			});
		}
	}
	function salesout(item){
		$(item).addClass('salesout');
	}
	function salesover(item){
		$(item).removeClass('salesout');
	}
	
	function toZero(str){
		if(str.indexOf('.')==-1){
			return	"￥"+parseFloat(str.replace('￥','')).toFixed(2);
		}
	}
	
	/*
	镜架辅料
	*/
	function addFrame(){
	if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initFramesAccessoriesSel.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initFramesAccessoriesSel.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【镜架辅料查询】";
	}
	var category='';
	function setCategory(item){
		category=item;
	}
	/*
	添加商品
	*/
	var glassOD='';
	var glassOS='';
	var frame='';
	var bgiordercycle=0//订做周期
	function addGoods(json){
		if(json.iscustomize=='D'){
			var obj = document.getElementById("showtr");
			obj.style.display = "Block";
			$('#DragsType').show();
		}	
			
			//限制一单一副。
			// alert(json.glassflag);
			if(json.glassflag!=undefined){
				if(json.glassflag=='R'){
					glassOD="R";
					
				}else{
					glassOS="L";
				}
			}else{
				if(category=='镜架辅料')
				{
					
				}else
				{
					frame="F";
				}
				
			}
			//克隆行
			$("#copyrow").show();
        	$("#copyrow").clone(true).appendTo($("#copyrow"));
        	$("#copyrow").hide();
        	
        	
        	//取goods行索引
        	var index=$('#copyrow+tr').size()+1;
        
        	//赋值
        	$('input[name=rownumber]')[index].value=index;
        	
        	for(var i=1;$('#copyrow+tr').size()>=i;i++)
        	{
        	  for(var j=1;i>=j;j++)
        	  {
        	    $('input[name=rownumber]')[j].value=j;
        	  }
        	}
        	
	        $('input[name=salesDetailPo\\.ssesdsalesitemids]').get(index).value=json.bgigoodsid;
	        $('input[name=salesDetailPo\\.ssesdsalesitemids]').get(index).title=json.bgigoodsid;
	        $('input[name=salesDetailPo\\.ssesdsalesitemnames]').get(index).value=json.bgigoodsname;
	        $('input[name=salesDetailPo\\.ssesdsalesitemnames]').get(index).title=json.bgigoodsname;
	        $('input[name=salesDetailPo\\.ssesdsprices]').get(index).value=json.bgiretailprice;
	        $('input[name=salesDetailPo\\.ssesdnumbers]').get(index).value="1";
	        $('input[name=salesDetailPo\\.ssesdpricesums]').get(index).value=json.bgiretailprice;
	        $('input[name=salesDetailPo\\.ssesdcostsprives]').get(index).value=json.bgicostprice;
	        $('input[name=salesDetailPo\\.ssesdunitprices]').get(index).value=json.bginottaxrate;
	        var goodsdiscount;
	        if($('input[name=salesBasicPo\\.ssesbdiscountrate]')[0].value!=''){
	       		 $('input[name=salesDetailPo\\.ssesddiscountrates]').get(index).value=$('input[name=salesBasicPo\\.ssesbdiscountrate]')[0].value;
	       		 goodsdiscount=$('input[name=salesBasicPo\\.ssesbdiscountrate]')[0].value;
	        }else{
	        	$('input[name=salesDetailPo\\.ssesddiscountrates]').get(index).value="1.0";
	        	goodsdiscount="1.0";
	        }
	        var ssje=parseData(accMul(goodsdiscount,json.bgiretailprice));
	       	if(param==1){
				if(ssje.indexOf('.')!=-1){
					ssje=ssje.substring(0,ssje.indexOf('.'));
				}
				ssje=ssje+".00";
			}else if(param==2){
				if(ssje.indexOf('.')!=-1){
					ssje=ssje.substring(0,ssje.indexOf('.')+2);
					ssje=ssje+"0";
				}else {
					ssje=ssje+".00";
				}
			}
	       	var zkje=accAdd(json.bgiretailprice,"-"+ssje)+"";
	       	if(param==1){
				if(zkje.indexOf('.')!=-1){
					zkje=zkje.substring(0,zkje.indexOf('.'));
				}
				zkje=zkje+".00";
			}else if(param==2){
				if(zkje.indexOf('.')!=-1){
					zkje=zkje.substring(0,zkje.indexOf('.')+2);
					zkje=zkje+"0";
				}else {
					zkje=zkje+".00";
				}
			}
			$('input[name=salesBasicPo.ssesbdiscountnum]')[0].value=zkje;
	        $('input[name=salesDetailPo\\.ssesddiscountnums]').get(index).value=zkje;
	        $('input[name=salesBasicPo.ssesbsalesvalue]')[0].value=ssje;
	        $('input[name=salesDetailPo\\.ssesdsalesvalues]').get(index).value=ssje;
	        
	        if(json.glassflag=='R'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="右眼镜片";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="3";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="R";
	        	  $('input[name=orderCycle]').get(index).value=json.bgiordercycle;
	        	 
	        }else if(json.glassflag=='L'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="左眼镜片";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="3";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="L";
	        	   $('input[name=orderCycle]').get(index).value=json.bgiordercycle;
	        }else if(json.glassflag==undefined){
	       		 if(category=='镜架辅料')
		        {
		        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="镜架辅料";
		        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="2";
		        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
		        }else{
		        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="镜架";
		        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="1";
		        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="F";
	       		}
	        }
	        
	        $('input[name=salesDetailPo\\.iscustomizes]').get(index).value=json.iscustomize;
	        $('input[name=salesDetailPo\\.ssesditemids]').get(index).value=json.bgigoodsbarcode;
	        
	        //各种金额计算
	        /*
	        	原价合计
	        */
	         $('#yjje').text("￥"+accAdd($('#yjje').text().replace('￥',''),json.bgiretailprice));
	       	 $('#yjje').text(toZero($('#yjje').text()));
	         $('input[name=salesBasicPo\\.ssesbpricesum]')[0].value= $('#yjje').text().replace('￥','');

	        /*
	        	应收金额合计
	        */
	        var ssjeTotal=0;
	       $('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
	       		ssjeTotal=accAdd($(this).val(),ssjeTotal);
	       });
	       ssjeTotal=accAdd(ssjeTotal,fujiafei);
	       ssjeTotal=ssjeTotal+"";
	       if(param==1){
				if(ssjeTotal.indexOf('.')!=-1){
					ssjeTotal=ssjeTotal.substring(0,ssjeTotal.indexOf('.'));
				}
				ssjeTotal=ssjeTotal+".00";
			}else if(param==2){
				
				if(ssjeTotal.indexOf('.')!=-1){
					ssjeTotal=ssjeTotal.substring(0,ssjeTotal.indexOf('.')+2);
					ssjeTotal=ssjeTotal+"0";
				}else {
					ssjeTotal=ssjeTotal+".00";
				}
			}
	       $('#ysje').text("￥"+ssjeTotal);
	       $('#ssje').text("￥"+ssjeTotal);
	       $('#sesbpsalsvalue').val(ssjeTotal);
	       $('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value= $('#ysje').text().replace('￥','');
	       	/*
	        	折扣金额合计
	        */
	        var zkjeTotal=0;
	      	zkjeTotal= accAdd($('#yjje').text().replace('￥',''),'-'+$('#ysje').text().replace('￥',''));
	      	zkjeTotal=zkjeTotal+"";
	       	if(param==1){
				if(zkjeTotal.indexOf('.')!=-1){
					zkjeTotal=zkjeTotal.substring(0,zkjeTotal.indexOf('.'));
				}
				zkjeTotal=zkjeTotal+".00";
			}else if(param==2){
				if(zkjeTotal.indexOf('.')!=-1){
					zkjeTotal=zkjeTotal.substring(0,zkjeTotal.indexOf('.')+2);
					zkjeTotal=zkjeTotal+"0";
				}else {
					zkjeTotal=zkjeTotal+".00";
				}
			}
	       $('#zkje').text("￥"+zkjeTotal);

	         $('input[name=salesBasicPo\\.ssesbdiscountnum]')[0].value= $('#ysje').text().replace('￥','');
	        
	         if(json.bgiordercycle!=''){
	         	if(json.bgiordercycle>bgiordercycle){
	         		bgiordercycle=parseInt(json.bgiordercycle);
	         		calculate(bgiordercycle);
	         	}
	         }else if(bgiordercycle==0&&json.bgiordercycle==''&&json.glassflag!=undefined){
	         		calculateHours(${companyNamePo.fcntakeglassdata});//成品片取景时间加2小时
	         }
	}
	
	function calculateHours(hours){
	
		var d = new Date();
		var vYear = d.getFullYear();
		var vMon = d.getMonth() + 1;
		var vDay = d.getDate();
		
		var vHour=d.getHours()+hours;
		var vMin=d.getMinutes();
		if(vMon<10){
			vMon='0'+vMon;
		}
		if(vDay<10){
			vDay='0'+vDay;
		}
		if(vHour.toString().length==1){
			vHour='0'+vHour;
		}
		if(vMin<10){
			vMin='0'+vMin;
		}
		 uValue=vYear+'-'+vMon+'-'+vDay;
		
	 	//alert(uValue);
	 	
	    $('#ssesbtakeglassdata').val(uValue+' '+vHour+':'+vMin);
	}
	/*
	添加赠品
	*/
	function addGifts(json){
		if('${customerInfoPo.smecimemberid }'==''){
				alert('请先输入会员卡号!');
				return;
		}
		$("#copyrowGifts").show();
        	$("#copyrowGifts").clone(true).removeAttr("id=copyrowGifts").appendTo($("#copyrowGifts"));
        	$("#copyrowGifts").hide();
        	var index=$('#copyrowGifts+tr').size()+1;
        	
        	$('input[name=giftsPo\\.bgsviewname]').get(index).value=json.bgsviewname;
        	$('input[name=giftsPo\\.bgsgoodstype]').get(index).value=json.bgsgoodstype;
        	$('input[name=giftsPo\\.bgsgoodsid]').get(index).value=json.bgsgoodsid;
        	$('input[name=giftsPo\\.bgsgoodsbarcode]').get(index).value=json.bgsgoodsbarcode;
        	$('input[name=giftsPo\\.bgscostprice]').get(index).value=json.bgscostprice;
        	$('input[name=giftsPo\\.bgsnottaxrate]').get(index).value=json.bgsnottaxrate;
        	$('span[id=giftsviewname]').get(index).innerText=json.bgsviewname;
        	
        	
	}	 
	/*
	添加加工要求
	*/
	function addSpecial(){
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		if($('#specialRequirements')[0].selectedIndex==0){
			alert('请选择加工要求!');
			return;
		}
		$("#copyrowSpecial").show();
        	$("#copyrowSpecial").clone(true).removeAttr("id=copyrowSpecial").appendTo($("#copyrowSpecial"));
        	$("#copyrowSpecial").hide();
        	var index=$('#copyrowSpecial+tr').size()+1;
        	$('input[name=specialPDetailPo\\.ssesdrequirement]').get(index).value=$('#specialRequirements :selected').text();	
	}	
	
	/*
	添加特殊加工要求
	*/
	function addSpecial1(){
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		if($('#specialRequirements1')[0].selectedIndex==0){
			alert('请选择特殊加工要求!');
			return;
		}
		$("#copyrowSpecial1").show();
        	$("#copyrowSpecial1").clone(true).removeAttr("id=copyrowSpecial1").appendTo($("#copyrowSpecial1"));
        	$("#copyrowSpecial1").hide();
        	var index=$('#copyrowSpecial1+tr').size()+1;
        	
        	
        	if($('#specialType1 :selected').val()=='R'||$('#specialType1 :selected').val()=='L')
        	{
        	 	$('input[name=prodtypename]').get(index).value=$('#specialType1 :selected').text();	
        		$('input[name=salesSpecialPo\\.prodlocal]').get(index).value=$('#specialRequirements1 :selected').text();	
        		$('input[name=salesSpecialPo\\.ssessalesspecialid]').get(index).value=$('#specialRequirements1 :selected').val();
				$('input[name=salesSpecialPo\\.ssesssalestype]').get(index).value=$('#specialType1 :selected').val();
        	}else
        	{
        	    $('input[name=prodtypename]').get(index).value=$('#specialType1 :selected').text();	
        		$('input[name=salesSpecialPo\\.prodlocal]').get(index).value=$('#specialRequirements1 :selected').text();	
        		$('input[name=salesSpecialPo\\.ssessalesspecialid]').get(index).value=$('#specialRequirements1 :selected').val();
				$('input[name=salesSpecialPo\\.ssesssalestype]').get(index).value=$('#specialType1 :selected').val();
				$('input[name=salesSpecialPo\\.ssesssalesvalue]').get(index).disabled=false;
        	}
				
	}
	
	/*
	添加附加费
	*/
	var fujiafei=0;//附加费全局变量
	function addCosts(obj){
			if('${customerInfoPo.smecimemberid }'==''){
				alert('请先输入会员卡号!');
				return;
			}
			if($('#additionalCosts')[0].selectedIndex==0)
			{
				alert('请选择附加费用!');
				return;
			}
			
        	
        	
        	//各种金额计算
        	if(parseFloat(obj.value)>0){
        		//fujiafei=accAdd(fujiafei,$('#additionalCosts').val().split(',')[1]*parseFloat(obj.value));
        		$('span[id=amountMoney]').get(obj.id).innerText="￥"+accMul($('#additionalCosts').val().split(',')[1],parseFloat(obj.value)).toFixed(2);
        		$('input[id=amountMoney]').get(obj.id).value=accMul($('#additionalCosts').val().split(',')[1],parseFloat(obj.value)).toFixed(2);
        		var famount = 0;
        		$('input[id=amountMoney]').each(function (){
        			famount = accAdd(famount, $(this).val());
        		});
        		fujiafei = famount;
        	}else{
        		$("#copyrowCosts").show();
	        	$("#copyrowCosts").clone(true).removeAttr("id=copyrowCosts").appendTo($("#copyrowCosts"));
	        	$("#copyrowCosts").hide();
	        	var index=$('#copyrowCosts+tr').size()+1;
	        	$('input[name=additionalCDetailPo\\.sseadditionalid]').get(index).value=$('#additionalCosts').val().split(',')[0];
	        	$('input[name=additionalCostsPo\\.facname]').get(index).value=$('#additionalCosts').val().split(',')[0];	
	        	$('input[name=additionalCostsPo\\.facamount]').get(index).value=$('#additionalCosts').val().split(',')[1];	
	        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写附加费数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '附加费数量应为整数！'}]";
	        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).value="1";
	        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).id=index;
	        	$('span[id=costs]').get(index).innerText=$('#additionalCosts :selected').text();	
	        	$('span[id=costsMoney]').get(index).innerText="￥"+$('#additionalCosts').val().split(',')[1];	
	        	$('span[id=amountMoney]').get(index).innerText="￥"+$('#additionalCosts').val().split(',')[1];
	        	$('input[id=amountMoney]').get(index).value=$('#additionalCosts').val().split(',')[1];
        		fujiafei=accAdd(fujiafei,$('#additionalCosts').val().split(',')[1]);
        	}
        	 /*
			应收金额
			*/
			var num=0;
			$('input[name=salesDetailPo\\.ssesdpricesums]').each(function(){
				num=accAdd($(this).val(),num);
			});
			var yjje="￥"+accAdd(num,fujiafei);
	         $('#yjje').text(toZero(yjje));
	         var ysje=accAdd($('#ysje').text().replace('￥',''),fujiafei)+"";
	         	if(param==1){
				if(ysje.indexOf('.')!=-1){
					ysje=ysje.substring(0,ysje.indexOf('.'));
				}
				ysje=ysje+".00";
			}else if(param==2){
				if(ysje.indexOf('.')!=-1){
					ysje=ysje.substring(0,ysje.indexOf('.')+2);
					ysje=ysje+"0";
				}else {
					ysje=ysje+".00";
				}
			}
			 /*
			实收金额
			*/
        	 var ssjeTotal=0;
	       $('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
	       		ssjeTotal=accAdd($(this).val(),ssjeTotal);
	       });
	       var ysje=accAdd(ssjeTotal,fujiafei);
	         $('#ysje').text("￥"+ysje.toFixed(2));
	         $('#ssje').text("￥"+ysje.toFixed(2));
	         $('#sesbpsalsvalue').val(ysje);
	         $('input[name=salesBasicPo\\.ssesbpricesum]').val( $('#yjje').text().replace('￥',''));
	}	
	/*
	镜架销售开窗
	*/
	function addFrameGoods(){
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		if(frame=='F'){
			alert('镜架数量过多!');
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSellMirrorFrameSel.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSellMirrorFrameSel.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【镜架查询】";
	}
	function   PlusDay(asDate,aiDay){ 
      var   loDate   =   new   Date(Date.parse(asDate.replace(/\-/g,   '/ '))+3600*1000*24*aiDay); 
      var month=loDate.getMonth()+1;
      var day=loDate.getDate();
      if(month<10){
      	month='0'+month;
      }
      if(day<10){
      	day='0'+day;
      }
      return   loDate.getYear()   +   "-"   +   month  +   "-"   + day  ; 
	} 
	
	/*
	删除行
	*/
	function deleteItem(item){
		var cycle=0;
		$('input[name=orderCycle]').each(function(){
			if($(this).val()!=''){
				if(parseFloat($(this).val())>parseFloat(cycle)){
					cycle=$(this).val();
				}
			}
		});
		if(cycle!=0&&cycle==$(item).parent().parent().parent().find('input[name=orderCycle]').val()){
			var d = new Date();
			var vHour=d.getHours();
			var vMin=d.getMinutes();
	
			if(vHour.toString().length==1){
				vHour='0'+vHour;
			}
			if(vMin<10){
				vMin='0'+vMin;
			}
			$('#ssesbtakeglassdata').val(PlusDay($('#ssesbtakeglassdata').val(),parseFloat('-'+cycle))+' '+vHour+':'+vMin);
		}
		bgiordercycle=0;
		
		
		$(item).parent().parent().parent().remove();		
			//委外周期删除
		
		var cycle1=0;
		$('input[name=orderCycle]').each(function(){
			if($(this).val()!=''){
				if(parseFloat($(this).val())>parseFloat(cycle1)){
					cycle1=$(this).val();
				}
			}
		});
		if(cycle1!=''&&cycle1!=0){
			calculate(cycle1);
		}
		
		var istrue = '';

		$('input[name=salesDetailPo\\.iscustomizes]').each(function (){
			if($(this).val()=='D'){
				istrue = '1';
			}	
		});
		if(istrue!='1'){
			var obj = document.getElementById("showtr");
			obj.style.display = "None";
			$('#DragsType').attr("disabled","disabled");
		}
	}
	
	/*
	结算
	*/
	function save(){
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		//alert(glassOD+","+glassOS+","+frame);
	  	if(glassOD=='')
		{
			alert('本系统只限一单一副,请再次选择商品!');
			return;
		}
		 if(glassOS=='')
		{
			alert('本系统只限一单一副,请再次选择商品!');
			return;
		}
		if(frame=='')
		{
			alert('本系统只限一单一副,请再次选择商品!');
			return;
		}
		if($('#ssesbtakeglassdata').val()==''){
			alert('请选择取镜日期!');
			return;
		}
		try{
			if($('#recipetype').val()=='1'){
				$('#yuanyong').find('input[tongju=tongju]').each(function(){
					if($(this).val()==''){
						alert('瞳距不能为空!');
						$(this).focus();
						throw '1';
					}
				});
			}
			if($('#recipetype').val()=='2'){
				$('#jinyong').find('input[tongju=tongju]').each(function(){
					if($(this).val()==''){
						alert('瞳距不能为空!');
						$(this).focus();
						throw '1';
					}
				});
			}
			if($('#recipetype').val()=='3'){
				//$('#jianjin').find('input[tongju=tongju]').each(function(){
					//if($(this).val()==''){
						//alert('瞳距不能为空!');
						//$(this).focus();
						//throw '1';
					//}
				//});
				var odytongju = document.getElementById('ssesbinterhighod').value;
				var odjtongju = document.getElementById('ssesbinterdistanceod').value;
				var osytongju = document.getElementById('ssesbinterhighos').value;
				var osjtongju = document.getElementById('ssesbinterdistanceos').value;
				
				if((odytongju==''&&osjtongju=='')||(odjtongju==''&&osytongju=='')
						||(odytongju==''&&odjtongju=='')||(osjtongju==''&&osytongju=='')){
					alert('瞳距不能为空!');
					throw '1';
				}
				
				
			}
			
			
		}catch(e){
			return;
		}
		
		if(!confirm("您确认取镜地点为："+$("#ssesblocation option:selected").text()+"吗?")){
			return;
		}
		if(!confirm("您确认提交此销售单吗?")){
			return;
		}
		$('input[name=salesBasicPo\\.ssesbpricesum]')[0].value=$('#yjje').text().replace('￥','');
		$('input[name=salesBasicPo\\.ssesbdiscountnum]')[0].value=$('#zkje').text().replace('￥','');
		$('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value=$('#ysje').text().replace('￥','');
		
		if(accAdd($('input[name=salesBasicPo\\.ssesbpsalsvalue]')[0].value,'-'+$('#ysje').text().replace('￥',''))!=0){
			$('input[name=salesBasicPo\\.ssesbcheckoutflag]')[0].value="1";
			$('input[name=salesBasicPo\\.ssesbarrearsvalue]')[0].value=accAdd($('#ysje').text().replace('￥',''),'-'+$('input[name=salesBasicPo\\.ssesbpsalsvalue]')[0].value);
		}else{
			$('input[name=salesBasicPo\\.ssesbcheckoutflag]')[0].value="0";
			$('input[name=salesBasicPo\\.ssesbarrearsvalue]')[0].value="0.00";
		}
		
		//提交
		var goodsid;
		$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function(){
			if($(this).val().substring(0,1)=='3'){
				goodsid+=$(this).val().substring(0,9)
				//alert(goodsid);
			}
		})
		
		//判断
//		alert(goodsid.substring(11,13));
//		alert(goodsid.substring(20,22));
		if(goodsid.substring(11,13)==goodsid.substring(20,22))
		{
			
		}else
		{
			if(goodsid.substring(11,13)=='ZZ'||goodsid.substring(20,22)=='ZZ')
			{
			  
			}else{
				alert("请选择一个制造商的镜片商品！");
				return;
			}
		}
		
		if(checkForm(document.all.frameSalesForm)){ 
			var recipetype = $('#recipetype').val();
			$("img").removeAttr("onclick");
			frameSalesForm.action="frameSalse.action?recipetype="+recipetype;
			frameSalesForm.submit();
		}
	}
	
	/*
	删除商品行时清除一单一副所用的全局变量,重新计算
	*/
	function deleteVar1(item){
		var param=$(item).parent().find("input.cccc").get(0).value;
		if(param=='F')
		{
			frame='';
		}
		if(param=='R')
		{
			glassOD='';
		}
		if(param=='L')
		{
			glassOS='';
		}

	 	$('input[name=salesBasicPo\\.ssesbdiscountnum]')[0].value=accAdd($('input[name=salesBasicPo\\.ssesbdiscountnum]')[0].value,'-'+$(item).parent().parent().parent().find('td .zksum').val());
		$('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value=accAdd($('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value,'-'+$(item).parent().parent().parent().find('td .yssum').val());
		
		var ssjeTotal=0;
	       $('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
	       		ssjeTotal=accAdd($(this).val(),ssjeTotal);
	       });
	       ssjeTotal=accAdd(ssjeTotal,fujiafei);
	      
		$('#ysje').text("￥"+parseData(ssjeTotal));
		$('#ssje').text("￥"+parseData(ssjeTotal));
		$('#sesbpsalsvalue').val(parseData(ssjeTotal));
		
		$('#zkje').text("￥"+parseData(accAdd($('#zkje').text().replace('￥',''),"-"+$(item).parent().parent().parent().find('td .zksum').val())+""));
		$('input[name=salesBasicPo\\.ssesbpricesum]')[0].value= $('#yjje').text().replace('￥','');
		
		$('#yjje').text("￥"+accAdd($('#yjje').text().replace('￥',''),'-'+$(item).parent().parent().parent().find('td .yjje').val()));
		$('#yjje').text(toZero($('#yjje').text()));
		
		for(var i=0;$('#copyrow+tr').size()>=i;i++)
       	{
       	  for(var j=0;i>=j;j++)
       	  {
       	    $('input[name=rownumber]')[j].value=j;
       	  }
       	}
       	
       	$('input[id=td10t]').val("0");
       	amount();
	}
	
	/*
	删除附加费重新计算
	*/
	function deleteVar2(item){
		var fjfy='-'+$(item).parent().parent().parent().find('td .fjfya').val();
		$('#yjje').text("￥"+accAdd($('#yjje').text().replace('￥',''),fjfy));
		$('#yjje').text(toZero($('#yjje').text()));
		 $('input[name=salesBasicPo\\.ssesbpricesum]').val( $('#yjje').text().replace('￥',''));
		 fujiafei=accAdd(fujiafei,fjfy);
		 fjfy=accAdd($('#ysje').text().replace('￥',''),fjfy)+"";
		 if(param==1){
				if(fjfy.indexOf('.')!=-1){
					fjfy=fjfy.substring(0,fjfy.indexOf('.'));
				}
				fjfy=fjfy+".00";
		}else if(param==2){
				if(fjfy.indexOf('.')!=-1){
					fjfy=fjfy.substring(0,fjfy.indexOf('.')+2);
					fjfy=fjfy+"0";
				}else {
					fjfy=fjfy+".00";
				}
		}
		
		$('#ysje').text("￥"+fjfy);
		$('#ssje').text("￥"+fjfy);
		$('#sesbpsalsvalue').val(fjfy);
		$('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value="￥"+fjfy;
	}
	
	function parseData(arg0){
		arg0=arg0.toString();
		 if(param==1){
				if(arg0.indexOf('.')!=-1){
					arg0=arg0.substring(0,arg0.indexOf('.'));
				}
				arg0=arg0+".00";
		}else if(param==2){
				if(arg0.indexOf('.')!=-1){
					arg0=arg0.substring(0,arg0.indexOf('.')+2);
					arg0=arg0+"0";
				}else {
					arg0=arg0+".00";
				}
		}
		return arg0;
	}
	/*
	整单打折 
	*/
	var param=2;//所舍位数 1保留至元2保留至毛
	/*
	打折开窗
	*/
	function discount1(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initPersonDiscountSelect.action",700,500,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPersonDiscountSelect.action",800,600,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【整单打折】";
	}
	/*
	整单打折开窗回调
	*/
	

	function setDiscount1(discount,discounttype,discountperson){//2012/2/2 零折
		$('input[name=salesBasicPo\\.ssesbdiscountrate]').val(discount);
		
		
		$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
		$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折

		/*
		应收金额
		*/
		var num=0;
		$('input[name=salesDetailPo\\.ssesdpricesums]').each(function(){
			num=accAdd($(this).val(),num);
		});
		var yjje="￥"+accAdd(parseData(accMul(discount,num)),fujiafei);
		
		if(param==1){
			if(yjje.indexOf('.')!=-1){
				yjje=yjje.substring(0,yjje.indexOf('.'));
			}
			yjje=yjje+".00";
		}else if(param==2){
			if(yjje.indexOf('.')!=-1){
				yjje=yjje.substring(0,yjje.indexOf('.')+2);
				yjje=yjje+"0";
				
			}else {
				yjje=yjje+".00";
			}
			
		}
		var ysindex=0;
		var ystotal=0.00;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			try{
				var aqcount=$('input[name=salesDetailPo\\.ssesdpricesums]')[ysindex].value;
				var aqcount1=Math.round(eval(aqcount)*eval(discount)*10)/10;
				//var ysje=parseData(accMul(discount,$('input[name=salesDetailPo\\.ssesdpricesums]')[ysindex].value));
				 var ysje =parseData(aqcount1);
				ystotal=Math.round((eval(ystotal)+eval(ysje))*10)/10;
				$(this).val(ysje);
			}catch(e){
			}
			finally{
				ysindex++;
			}
		});
		ystotal="￥"+accAdd(ystotal,fujiafei);
		if(param==1){
			if(ystotal.indexOf('.')!=-1){
				ystotal=ystotal.substring(0,ystotal.indexOf('.'));
			}
			ystotal=ystotal+".00";
		}else if(param==2){
			if(ystotal.indexOf('.')!=-1){
				ystotal=ystotal.substring(0,ystotal.indexOf('.')+2);
				ystotal=ystotal+"0";
				
			}else {
				ystotal=ystotal+".00";
			}
			
		}
		
		$('#ysje').text(ystotal);
		$('#ssje').text(ystotal);
		$('#sesbpsalsvalue').val(ystotal.replace('￥',''));
		
		var zkje=parseData(accAdd(num,'-'+ystotal.replace('￥','')));
		$('#zkje').text("￥"+parseData(accAdd(zkje,fujiafei)));
		$('input[name=salesDetailPo\\.ssesddiscountrates]').each(function(){
			$(this).val(discount);
		});
		
		
		
		$('input[name=salesDetailPo\\.ssesdsalesvalues]')[0].value="";
		var zkindex=0;
		$('input[name=salesDetailPo\\.ssesddiscountnums]').each(function(){
		
		try{
			
			//var zkje=parseData(accMul(accAdd('1','-'+discount),$('input[name=salesDetailPo\\.ssesdpricesums]')[zkindex].value));
			var zkje=parseData(Math.round(accMul(Subtr(discount,'1'),$('input[name=salesDetailPo\\.ssesdpricesums]')[zkindex].value)*10)/10);
			$(this).val(zkje);
		}catch(e){
		
		}
		finally{
			zkindex++;
		}
		});
		
		var obj = document.getElementById("td10t");
		obj.value="0.00";

		if (obj.value>=0){
			
		}else{
			alert("请填写正确金额格式！");
			return false;
		}
		var count = 0;
		$('input[name=salesDetailPo.ssesdsalesitemids]').each(function (){
			count=count+1;
		});
		if(count>1){
			$('span[vid=td4t]').text("￥"+parseFloat(obj.value).toFixed(2));
    		$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
        	changeSalesValue(obj);
        	amount();
        }
	}
	function parseData2(arg0){
		arg0=arg0.toString();
		if(arg0.indexOf('.')!=-1){
			arg0=arg0.replace(/^(\d+\.\d{2})\d*$/,"$1")   
		}else if(arg0.indexOf('.')==-1){
			arg0=arg0+".00";
		}
		return arg0;
	}
	
	function showSubMenuasd() {  
		var specialType1 = $('#specialType1').val();
		alert(specialType1);
    	$('#specialRequirements1').load("getAjaxSpecial.action?specialType1="+ specialType1);
    }
	
	/*
	单品打折
	*/
	function discount2(item){	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initPersonDiscountSelect.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),700,600,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPersonDiscountSelect.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),800,700,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【单品打折】";
	}
	
	function setDiscount2(discount2,rownumber,discounttype,discountperson){//2012/2/2 零折
		//明细行重新赋值
		/*
			应收金额重新赋值
		*/
		$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
		$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折
		
		var ysje=$('tr[id=copyrow]').find(".yssum")[rownumber].value;
		var yjhj=$('tr[id=copyrow]').find(".pricesum")[rownumber].value;
		
		var aqcount=Math.round(eval(yjhj)*eval(discount2)*10)/10;
		var ysje =parseData(aqcount);
		
		$('tr[id=copyrow]').find(".yssum")[rownumber].value=ysje;
		/*
			折扣率重新赋值
		*/
		$('tr[id=copyrow]').find(".discountrate")[rownumber].value=discount2;
		/*
			折扣金额重新赋值
		*/
		$('tr[id=copyrow]').find(".zksum")[rownumber].value=parseData(accAdd(yjhj,'-'+ysje));
		
		/*
			total重新赋值
		*/
		var ysjeTotal=0;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			ysjeTotal=accAdd(ysjeTotal,$(this).val());
		});
		//alert(ysjeTotal);	
		document.getElementById('ysje').innerText="￥"+parseData(accAdd(ysjeTotal,fujiafei));
		document.getElementById('ssje').innerText="￥"+parseData(accAdd(ysjeTotal,fujiafei));
		$('#sesbpsalsvalue').val(document.getElementById('ssje').innerText.replace('￥',''));
		var yjTotal=accAdd($('#yjje').text().replace('￥',''),'-'+fujiafei);
		document.getElementById('zkje').innerText="￥"+parseData(accAdd(yjTotal,'-'+ysjeTotal));
		
		var obj = document.getElementById("td10t");
		obj.value="0.00";

		if (obj.value>=0){
			
		}else{
			alert("请填写正确金额格式！");
			return false;
		}
		var count = 0;
		$('input[name=salesDetailPo.ssesdsalesitemids]').each(function (){
			count=count+1;
		});
		if(count>1){
			$('span[vid=td4t]').text("￥"+parseFloat(obj.value).toFixed(2));
    		$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
        	changeSalesValue(obj);
        	amount();
        }
	}
	
	//对金额进行列的合计
	function amount(){
		for(var i=1;i<=3;i++){
			var total=0;
			$('input[id=td'+i+']').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('input[vid=td'+i+'t]').val(parseFloat(total).toFixed(2));
		}
		var ysje = 0;
		$('input[name=salesDetailPo.ssesdsalesvalues]').each(function (){
			ysje = accAdd($(this).val(),ysje);
		});
		
		var famount = 0;
		$('input[name=amountMoney]').each(function (){
			famount = accAdd($(this).val(),famount);
		});
		fujiafei = famount;
		
		//$('#gainIntegral').val(accMul($('input[vid=td3t]').text(),$('#integral').val()));
	    $('input[name=salesBasicPo.ssesbdiscountnum]').val($('input[vid=td2t]').text());	    
	    $('input[name=salesBasicPo.ssesbsalesvalue]').val(ysje.toFixed(2));
	    $('span[vid=td3t]').text("￥"+accAdd(parseFloat(ysje).toFixed(2),fujiafei).toFixed(2));
	    $('span[vid=td5t]').text("￥"+accAdd(parseFloat(ysje).toFixed(2),fujiafei).toFixed(2));
	    $('span[vid=td4t]').text("￥"+parseFloat($('input[id=td10t]').val()).toFixed(2));
	    var mlsum = 0;
	    $('input[name=salesDetailPo.ssesdrenums]').each(function (){
	    	mlsum = accAdd($(this).val(),mlsum);
	    });
	    $('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(mlsum).toFixed(2));
	    $('#salseValue').val(parseFloat($('input[name=salesBasicPo.ssesbsalesvalue]').val()).toFixed(2));
	    $('#sesbpsalsvalue').val(document.getElementById('ssje').innerText.replace('￥',''));
	    $('#td10t').val(parseFloat(mlsum).toFixed(2));
	    $('span[vid=td4t]').text("￥"+parseFloat(mlsum).toFixed(2));
	}
	
	//改变抹零金额
	function changeMolingAmount(obj){
	    if (event.keyCode == 13){
	    	if (obj.value>=0){
			
			}else{
				alert("请填写正确金额格式！");
				return false;
			}
			
	    	
	    	$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
	        changeSalesValue(obj);
	        amount();
	    }
	}
	
	//填写抹零金额后,修改商品的应收金额
	function changeSalesValue(obj){
       	var fcnrenumber = $('#fcnrenumber').val();
		if (parseFloat(fcnrenumber).toFixed(2) < parseFloat(obj.value)){
            alert("抹零金额应小于等于"+fcnrenumber+"!");
            $('input[name=salesBasicPo.ssesbrenums]').val('0');
            $('input[id=td10t]').val("0");
            $('span[vid=td4t]').text('￥0.00');
        }
	    var count = 0;
	    var total = 0;
	    var sSsesdSalesValues = document.getElementsByName('salesDetailPo.ssesdsalesvalues');  
	    var jkValues=document.getElementsByName('salesDetailPo.ssesddiscountnums');       
		var yjValues=document.getElementsByName('salesDetailPo.ssesdpricesums');
		var mlValues=document.getElementsByName('salesDetailPo.ssesdrenums');
		
		for (var i = 0; i < accAdd(sSsesdSalesValues.length,'0'); i++){
            mlValues[i].value="0.00";
        }

        for (var i = 1; i < accAdd(sSsesdSalesValues.length,'0'); i++){
            if (parseFloat(Subtr(parseFloat(jkValues[i].value),parseFloat(yjValues[i].value))).toFixed(2) >= parseFloat(obj.value)){
                count = 1;
                sSsesdSalesValues[i].value = parseFloat(Subtr(parseFloat(obj.value),Subtr(parseFloat(jkValues[i].value),parseFloat(yjValues[i].value)))).toFixed(2);
                mlValues[i].value=parseFloat(obj.value).toFixed(2);
                obj.value = '0.00';
            }else{
            	sSsesdSalesValues[i].value = '0.00';
            	mlValues[i].value = parseFloat(Subtr(parseFloat(jkValues[i].value),parseFloat(yjValues[i].value)));
            	obj.value = parseFloat(Subtr(Subtr(parseFloat(jkValues[i].value),parseFloat(yjValues[i].value)),parseFloat(obj.value))).toFixed(2);
            }
        }
        
        if (sSsesdSalesValues.length != 0){
        	
            if (count == 0 && obj.value != ''){
                alert("抹零金额过大!");
                $('input[name=salesBasicPo.ssesbrenums]').val('0');
                $('input[id=td10t]').val("0");
                $('span[vid=td4t]').text('￥0.00');
            }
            
            
        }	
	}
--></script>
<script type="text/javascript" language="javascript" src="${ctx}/js/calenderJS.js"></script>
<BODY bgColor=#ffffff topMargin=5  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="frameSalesForm" method="post">
<input id="ssesbrecipetype" type="hidden" name="salesBasicPo.ssesbrecipetype" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesboptid" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbarrearsvalue" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbcheckoutflag" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbvalueflag" value="" />
<input id="ssesboptometryid" type="hidden" name="salesBasicPo.ssesboptometryid" value="" />
<input id="inspectionid" type="hidden" name="salesBasicPo.ssesbinspectionid" value="" />
<input type="hidden" name="customerInfoPo.smecicustomerid" value="${customerInfoPo.smecicustomerid}"> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="nwtype" name="nwtype" value="">
<input type="hidden" id="salseID" name="salseID" value="${salseID }">
<input type="hidden" id="fcnrenumber" name="fcnrenumber" value="${companyNamePo.fcnrenumber }">

<input type="hidden" name="salesBasicPo.ssesbdiscounttype" value=""><!-- 2012/2/2 零折 -->
<input type="hidden" name="salesBasicPo.ssesbdiscountperson" value=""><!-- 2012/2/2 零折 -->


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
	  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TBODY>
		  <TR>
			<TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>销售管理</TD>
			<TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：框镜销售</TD>
		  </TR>
		  <TR>
			<TD class=menubar_function_text colspan="3"><table></table></TD>
		  </TR>
		  <TR>
			<TD colSpan=2 height=20></TD>
		  </TR>
		</TBODY>
	  </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
		<TR>
		  <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
		  background=${ctx }/img/pic/tab_bg.gif>
			</TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top>
						<fieldset>
							<legend>顾客资料</legend>
							<table width="98%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateTable privateBorder">
							  <tr>
								<td height="26" bgcolor="#cadee8">
								<li class="horizontal">卡号&nbsp;<input id="smecimemberid" name="customerInfoPo.smecimemberid" 
																	value="${customerInfoPo.smecimemberid }" onkeyup="selectCustomer();" class="text_input100" size="6">
								</li>								
								<li class="horizontal"><img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查找' onclick="selCustomer();" ></li>
								<li class="horizontal">姓名<input class="text_input60" size="2" value="${customerInfoPo.smeciname }" id="smeciname" name="customerInfoPo.smeciname" readOnly="readOnly">
								</li>
								<li class="horizontal">性别<input class="text_input20" size="2" value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" readOnly="readOnly">
								</li>
								<li class="horizontal">年龄<input class="text_input40" size="2" value="${customerInfoPo.fmmdown }" readOnly="readOnly">
								</li>
								<li class="horizontal">折扣<input class="text_input40" id="titlediscount" size="2" value="${customerInfoPo.fmmdiscount }" readOnly="readOnly">
								</li>
								<li class="horizontal">积分<input class="text_input40" size="2" value="${customerInfoPo.smeciintegral }" readOnly="readOnly">
								</li>
								<li class="horizontal">
								<c:if test="${empty(customerInfoPo.smecicustomerid)}">
								</c:if>
								<c:if test="${not empty(customerInfoPo.smecicustomerid)}">
								  <img name="button32" src="${ctx}/img/newbtn/btn_details_0.png" btn=btn title='详情' align="left" onClick="javascript:details('${customerInfoPo.smecicustomerid }');" >
								</c:if>
								</li>
								<li id="saleserDiv" class="horizontal"><img name="button32" btn=btn id='saleser' src="${ctx}/img/newbtn/btn_changesaleser_0.png" title="更换销售员" align="left" onclick="changeSaleser()">
								</li>
								
								<li id="saleserDiv" class="horizontal">
									<SELECT id="ssesbsalerid" name="ssesbsalerid" disabled="disabled" onchange="disabledSelect()">
										<c:forEach var="po" items="${personInfoPos}">
											<option value="${po.id }" ${person.id != po.id ? '':'selected=selected'}>${po.personName }</option>
										</c:forEach>
									</SELECT>
									<input name="salesBasicPo.ssesbsalerid" type="hidden" value=''> 
								</li>
								
							  </tr>
							</table>
						</fieldset>	
						<br>
						<fieldset>
							<legend>当前验光处方</legend>
							<table width="98%" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder" id="title2">
							  <tr>
								<th width="30%" height="26" align="center" class="table_body">处方类型</th>
                                <th align="center" class="table_body">验光师</th>
                                <th align="center" class="table_body">验光时间</th>
                                <th align="center" class="table_body">选择</th> 
                              </tr>
                              
                              <c:if test="${not empty(inspectionPos)}">
                              	<c:forEach var="po" items="${inspectionPos}">
                              		<tr>
								<td width="30%" height="26" align="center" class="table_body">
									<c:choose>
										<c:when test="${po.sopipglasstype == '1' }">远用</c:when>
										<c:when test="${po.sopipglasstype == '2' }">近用</c:when>
										<c:when test="${po.sopipglasstype == '3' }">双光/渐进</c:when>
										<c:when test="${po.sopipglasstype == '5' }">中用</c:when>
										<c:when test="${po.sopipglasstype == '4' }">隐形</c:when>
									</c:choose>
								</td>
                                <td height="26" align="center" class="table_body">${po.sopipersonname }</td>
                                <td height="26" align="center" class="table_body">${fn:substring(po.sopiptime, 0, 16)} </td>
                                <td height="26" align="center" class="table_body">
                                	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" 
                                	onclick="selGlassTime('${fn:substring(po.sopiptime, 0, 10)}');selGlassType('${po.sopipglasstype}');inspection({'sopipinspectionid':'${po.sopipid}','sopipcustomerid':'${po.sopipcustomerid}',
								'sopipoptometrybasicid':'${po.sopipoptometrybasicid}','sopipoptometryid':'${po.sopipoptometryid}',
								'sopipglasstype':'${po.sopipglasstype}','sopipballglassod':'${po.sopipballglassod}',
								'sopipballglassos':'${po.sopipballglassos}','sopippostglassod':'${po.sopippostglassod}',
								'sopippostglassos':'${po.sopippostglassos}','sopipaxesod':'${po.sopipaxesod}',
								'sopipaxesos':'${po.sopipaxesos}','sopipaddod':'${po.sopipaddod}',
								'sopipaddos':'${po.sopipaddos}','sopiparriseglassod1':'${po.sopiparriseglassod1}',
								'sopiparriseglassos1':'${po.sopiparriseglassos1}','sopipbasisod1':'${po.sopipbasisod1}',
								'sopipbasisos1':'${po.sopipbasisos1}','sopipprismod':'${po.sopipprismod}',
								'sopipprismos':'${po.sopipprismos}','sopipinterhighod':'${po.sopipinterhighod}',
								'sopipinterhighos':'${po.sopipinterhighos}','sopipinterdistanceod':'${po.sopipinterdistanceod}',
								'sopipinterdistanceos':'${po.sopipinterdistanceos}','sopipfarvaod':'${po.sopipfarvaod}',
								'sopipfarvaos':'${po.sopipfarvaos}','sopipclosevaod':'${po.sopipclosevaod}',
								'sopipclosevaos':'${po.sopipclosevaos}','sopipeyecurvatureod1':'${po.sopipeyecurvatureod1}',
								'sopipeyecurvatureod2':'${po.sopipeyecurvatureod2}','sopipeyecurvatureos1':'${po.sopipeyecurvatureos1}',
								'sopipeyecurvatureos2':'${po.sopipeyecurvatureos2}','sopipdiameterod':'${po.sopipdiameterod}',
								'sopipdiameteros':'${po.sopipdiameteros}','sopipconlenvaod':'${po.sopipconlenvaod}',
								'sopipconlenvaos':'${po.sopipconlenvaos}','sopipcommendglasses':'${po.sopipcommendglasses}',
								'sopipsuggestframe':'${po.sopipsuggestframe}','sopipframeheight':'${po.sopipframeheight}',
								'sopipglassmaterial':'${po.sopipglassmaterial}','sopiprecipetype':'${po.sopiprecipetype}',
								'sopipdisposemanner':'${po.sopipdisposemanner}','sopipdignosisre':'${po.sopipdignosisre}',
								'sopipconrecipetype':'${po.sopipconrecipetype}','sopipseccheckdate':'${po.sopipseccheckdate}',
								'sopipsubvisitunit':'${po.sopipsubvisitunit}','sopipusername':'${po.sopipusername}',
								'sopipflag':'${po.sopipflag}','sopipconlenosnum':'${po.sopipconlenosnum}',
								'sopipconlenodnum':'${po.sopipconlenodnum}','sopipmiddledistance':'${po.sopipmiddledistance}',
								'sopipcommendcardwater':'${po.sopipcommendcardwater}'}, '${po.sopipglasstype}');$('#recipetype').attr('disabled', true);$('#nwtype').val('1');" /></td> 
                              </tr>
                              	</c:forEach>
                              </c:if>
						  </table>
						</fieldset>	
						<br/>
						<fieldset>
							<legend>处方类型</legend>
							<table width="98%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
								<tr valign="middle">
									<TD bgcolor="#CADEE8" width="85%" height="26" align="left" class="table_none">
									   	<li class="horizontal_onlyRight">处方类型： 
									   		<select id="recipetype" name="recipetype" onChange="selGlassType(this.value);" >
											    <option value="0" selected="selected">----请选择----</option>
												<option value="1">远用</option>
												<option value="2">近用</option>
												<option value="3">渐进/双光</option>
												<option value="5">中用</option>
											</select>
									   	</li>
									  	<li class="horizontal_onlyRight"><img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clearValue();$('#nwtype').val('');" /></li>
								  	</TD>
							   </tr>
                     		</table>
                            <br/>
	                        <table id="yuanyong" style="display: none;" width="98%" id="chufang1" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder PrivateBorderGreen" id="title2">
                             <tr>
							 	<td width="8%" height="25" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">框架--远用</td>
							   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">球镜</td>
							   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">柱镜</td>
							   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">轴向</td>
							   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">三棱镜</td>
							   <td width="5%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">基底</td>
							   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">远用瞳距(mm)</td>
							   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">远用VA</td>
							 </tr>
							 <tr>
							 	<td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">OD</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input needChange="needChange" yyorder="1" name="salesBasicPo.ssesbballglassod" glassType="yuanyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input needChange="needChange" yyorder="2" name="salesBasicPo.ssesbpostglassod" glassType="yuanyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input name="salesBasicPo.ssesbaxesod" yyorder="3" glassType="yuanyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input name="salesBasicPo.ssesbarriseglassod" yyorder="4" glassType="yuanyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
								<span id="ssesbbasis" >
									<select name="salesBasicPo.ssesbbasisod" yyorder="5" glassType="yuanyong" disabled="disabled">
										<option value="" selected="selected">----请选择----</option>
										<option value="内">内</option>
										<option value="外">外</option>
										<option value="上">上</option>
										<option value="下">下</option>
                                    </select>
                                </span>
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="6" name="salesBasicPo.ssesbinterhighod" glassType="yuanyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="7" name="salesBasicPo.ssesbfarvaod" glassType="yuanyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
								</td>
							 </tr>
							 <tr>
						 	   <td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen"><div align="center">OS</div></td>
							   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="8" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="yuanyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="9" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="yuanyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="10" name="salesBasicPo.ssesbaxesos" glassType="yuanyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="11" name="salesBasicPo.ssesbarriseglassos" glassType="yuanyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
							   <td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
							   <span id="ssesbbasis" >
							     <select yyorder="12" name="salesBasicPo.ssesbbasisos" glassType="yuanyong" disabled="disabled">
										<option value="" selected="selected">----请选择----</option>
										<option value="内">内</option>
										<option value="外">外</option>
										<option value="上">上</option>
										<option value="下">下</option>
                                    </select>
                               </span>
							   </td>
							   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
							     <input yyorder="13" name="salesBasicPo.ssesbinterhighos" glassType="yuanyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
							   </td>
							   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
							     <input yyorder="14" name="salesBasicPo.ssesbfarvaos" glassType="yuanyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
							   </td>
							 </tr>
                          </table>
                          
                          
                          <table id="jinyong" style="display: none;" width="98%" id="chufang1" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder PrivateBorderBlue" id="title2">
                             <tr>
							 	<td width="8%" height="26" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">框架--近用</td>
							   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">球镜</td>
							   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">柱镜</td>
							   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">轴向</td>
							   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">Add</td>
							   <td width="8%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">三棱镜</td>
							   <td width="5%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">基底</td>
							   <td width="11%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">近用瞳距(mm)</td>
							   <td width="11%" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">近用VA</td>
							 </tr>
							 <tr>
							 	<td height="26" bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">OD</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="15" needChange="needChange" name="salesBasicPo.ssesbballglassod" glassType="jinyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="16" needChange="needChange" name="salesBasicPo.ssesbpostglassod" glassType="jinyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="17" name="salesBasicPo.ssesbaxesod" glassType="jinyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="18" needChange="needChange" name="salesBasicPo.ssesbaddod" onblur="if(parseFloat(this.value)<0){alert('下加光不能为负!');this.focus()}" glassType="jinyong" sphcyl="sphcyl"  disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="19" name="salesBasicPo.ssesbarriseglassod" glassType="jinyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">
								<span id="ssesbbasis" >
									<select yyorder="20" name="salesBasicPo.ssesbbasisod" glassType="jinyong" disabled="disabled">
										<option value="" selected="selected">----请选择----</option>
										<option value="内">内</option>
										<option value="外">外</option>
										<option value="上">上</option>
										<option value="下">下</option>
                                    </select>
                                </span>
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="21" name="salesBasicPo.ssesbinterdistanceod" glassType="jinyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="22" name="salesBasicPo.ssesbclosevaod" glassType="jinyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
								</td>
							 </tr>
							 <tr>
						 	   <td height="26" bgcolor="E1EBFD" class="PrivateBorderBlue"><div align="center">OS</div></td>
							   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="23" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="jinyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="24" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="jinyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="25" name="salesBasicPo.ssesbaxesos" glassType="jinyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="26" needChange="needChange" name="salesBasicPo.ssesbaddos" onblur="if(parseFloat(this.value)<0){alert('下加光不能为负!');this.focus()}" glassType="jinyong" sphcyl="sphcyl"  disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="E1EBFD" class="PrivateBorderBlue">
								  <input yyorder="27" name="salesBasicPo.ssesbarriseglassos" glassType="jinyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
							   <td bgcolor="E1EBFD" class="PrivateBorderBlue" align="center">
							   <span id="ssesbbasis" >
							     <select yyorder="28" name="salesBasicPo.ssesbbasisos" glassType="jinyong" disabled="disabled">
										<option value="" selected="selected">----请选择----</option>
										<option value="内">内</option>
										<option value="外">外</option>
										<option value="上">上</option>
										<option value="下">下</option>
                                    </select>
                               </span>
							   </td>
							   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
							     <input yyorder="29" name="salesBasicPo.ssesbinterdistanceos" glassType="jinyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
							   </td>
							   <td bgcolor="E1EBFD" class="PrivateBorderBlue">
							     <input yyorder="30" name="salesBasicPo.ssesbclosevaos" glassType="jinyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
							   </td>
							 </tr>
                          </table>
                          <table id="jianjin" style="display: none;" width="98%" id="chufang1" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder PrivateBorderYellow" id="title2">
                             <tr>
							 	<td width="8%" height="25" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">框架--双光/渐进</td>
							   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">球镜</td>
							   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">柱镜</td>
							   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">轴向</td>
							   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">Add</td>
							   <td width="8%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">三棱镜</td>
							   <td width="5%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">基底</td>
							   <td width="11%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">远用瞳距(mm)</td>
							   <td width="11%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">近用瞳距(mm)</td>
							   <td width="11%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">远用VA</td>
							   <td width="11%" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">近用VA</td>
							 </tr>
							 <tr>
							 	<td height="26" bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">OD</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="31" needChange="needChange" name="salesBasicPo.ssesbballglassod" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="32" needChange="needChange" name="salesBasicPo.ssesbpostglassod" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="33" name="salesBasicPo.ssesbaxesod" glassType="jianjin" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="34" needChange="needChange" name="salesBasicPo.ssesbaddod" onblur="if(parseFloat(this.value)<0){alert('下加光不能为负!');this.focus()}" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="35"  name="salesBasicPo.ssesbarriseglassod" glassType="jianjin" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">
								<span id="ssesbbasis" >
									<select yyorder="36" name="salesBasicPo.ssesbbasisod" glassType="jianjin" disabled="disabled">
										<option value="" selected="selected">----请选择----</option>
										<option value="内">内</option>
										<option value="外">外</option>
										<option value="上">上</option>
										<option value="下">下</option>
                                    </select>
                                </span>
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="37" id="ssesbinterhighod" name="salesBasicPo.ssesbinterhighod" glassType="jianjin" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="38" id="ssesbinterdistanceod" name="salesBasicPo.ssesbinterdistanceod" glassType="jianjin" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="39" name="salesBasicPo.ssesbclosevaod" glassType="jianjin" va="va" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="40" name="salesBasicPo.ssesbfarvaod" glassType="jianjin" va="va" disabled="disabled" class="text_input40" style="width:100%">
								</td>
							 </tr>
							 <tr>
						 	   <td height="26" bgcolor="FBF3BD" class="PrivateBorderYellow"><div align="center">OS</div></td>
							   <td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="41" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="42" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="43" name="salesBasicPo.ssesbaxesos" glassType="jianjin" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="44" needChange="needChange" name="salesBasicPo.ssesbaddos" onblur="if(parseFloat(this.value)<0){alert('下加光不能为负!');this.focus()}" glassType="jianjin" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="45" name="salesBasicPo.ssesbarriseglassos" glassType="jianjin" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
							   <td bgcolor="FBF3BD" class="PrivateBorderYellow" align="center">
							   <span id="ssesbbasis" >
							     <select yyorder="46" name="salesBasicPo.ssesbbasisos" glassType="jianjin" disabled="disabled">
										<option value="" selected="selected">----请选择----</option>
										<option value="内">内</option>
										<option value="外">外</option>
										<option value="上">上</option>
										<option value="下">下</option>
                                    </select>
                               </span>
							   </td>
							   <td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="47" id="ssesbinterhighos" name="salesBasicPo.ssesbinterhighos" glassType="jianjin" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="48" id="ssesbinterdistanceos" name="salesBasicPo.ssesbinterdistanceos" glassType="jianjin" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="49" name="salesBasicPo.ssesbclosevaos" glassType="jianjin" va="va" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="FBF3BD" class="PrivateBorderYellow">
								  <input yyorder="50" name="salesBasicPo.ssesbfarvaos" glassType="jianjin" va="va" disabled="disabled" class="text_input40" style="width:100%">
								</td>
							 </tr>
                          </table>
                          
                          <table id="zhongyong" style="display: none;" width="98%" id="chufang1" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder PrivateBorderGreen" id="title2">
                             <tr>
							 	<td width="8%" height="25" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">框架--中用</td>
							   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">球镜</td>
							   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">柱镜</td>
							   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">轴向</td>
							   <td width="8%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">三棱镜</td>
							   <td width="5%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">基底</td>
							   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">中用瞳距(mm)</td>
							   <td width="11%" bgcolor="dfffdf" class="PrivateBorderGreen" align="center">中用VA</td>
							 </tr>
							 <tr>
							 	<td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">OD</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input needChange="needChange" yyorder="1" name="salesBasicPo.ssesbballglassod" glassType="zhongyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input needChange="needChange" yyorder="2" name="salesBasicPo.ssesbpostglassod" glassType="zhongyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input name="salesBasicPo.ssesbaxesod" yyorder="3" glassType="zhongyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input name="salesBasicPo.ssesbarriseglassod" yyorder="4" glassType="zhongyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
								<span id="ssesbbasis" >
									<select name="salesBasicPo.ssesbbasisod" yyorder="5" glassType="zhongyong" disabled="disabled">
										<option value="" selected="selected">----请选择----</option>
										<option value="内">内</option>
										<option value="外">外</option>
										<option value="上">上</option>
										<option value="下">下</option>
                                    </select>
                                </span>
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="6" name="salesBasicPo.ssesbinterhighod" glassType="zhongyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="7" name="salesBasicPo.ssesbfarvaod" glassType="zhongyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
								</td>
							 </tr>
							 <tr>
						 	   <td height="26" bgcolor="DFFFDF" class="PrivateBorderGreen"><div align="center">OS</div></td>
							   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="8" needChange="needChange" name="salesBasicPo.ssesbballglassos" glassType="zhongyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="9" needChange="needChange" name="salesBasicPo.ssesbpostglassos" glassType="zhongyong" sphcyl="sphcyl" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="10" name="salesBasicPo.ssesbaxesos" glassType="zhongyong" axes="axes" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
								<td bgcolor="DFFFDF" class="PrivateBorderGreen">
								  <input yyorder="11" name="salesBasicPo.ssesbarriseglassos" glassType="zhongyong" ljxj="ljxj" disabled="disabled" class="text_input40" style="width:100%" align="center">
								</td>
							   <td bgcolor="DFFFDF" class="PrivateBorderGreen" align="center">
							   <span id="ssesbbasis" >
							     <select yyorder="12" name="salesBasicPo.ssesbbasisos" glassType="zhongyong" disabled="disabled">
										<option value="" selected="selected">----请选择----</option>
										<option value="内">内</option>
										<option value="外">外</option>
										<option value="上">上</option>
										<option value="下">下</option>
                                    </select>
                               </span>
							   </td>
							   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
							     <input yyorder="13" name="salesBasicPo.ssesbinterhighos" glassType="zhongyong" tongju="tongju" disabled="disabled" class="text_input40" style="width:100%">
							   </td>
							   <td bgcolor="DFFFDF" class="PrivateBorderGreen">
							     <input yyorder="14" name="salesBasicPo.ssesbfarvaos" glassType="zhongyong" va="va" disabled="disabled" class="text_input40" style="width:100%">
							   </td>
							 </tr>
                          </table>
                        </fieldset>
						<br/>
						<fieldset>
							<legend>商品结算 </legend>
						<table width="100%" cellpadding="2" cellspacing="4" class="Privateborder">
							<tr>
								<td><table width="100%" height="100" border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                          <td width="10%" height="50" bgcolor="#000000"><div align="right" class="STYLE5">原价合计: </div></td>
                                          <td width="10%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="yjje"  vid="td1t">￥0.00</span><input value="" name=salesBasicPo.ssesbpricesum type="hidden"></strong></div></td>
                                          <td width="10%" bgcolor="#000000"><div align="right" class="STYLE5">折扣金额: </div></td>
                                          <td width="10%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="zkje"  vid="td2t">￥0.00</span><input value="" name=salesBasicPo.ssesbdiscountnum type="hidden"></strong></div></td>
                                          <td width="12%" bgcolor="#000000"><div align="right" class="STYLE5" >抹零金额: </div></td>
                                          <td width="10%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="mljes" vid="td4t">￥0.00</span><input value="0.00" name=salesBasicPo.ssesbrenums type="hidden"></strong></div></td> 
                                          <td width="10%" bgcolor="#000000"><div align="right" class="STYLE5">应收金额: </div></td>
                                          <td width="10%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="ysje"  vid="td3t">￥0.00</span><input value="" name=salesBasicPo.ssesbsalesvalue type="hidden"></strong></div></td>
                                          <td width="10%" bgcolor="#000000"><div align="right" class="STYLE5">实收金额:  </div></td>
                                          <td width="10%" bgcolor="#000000"><div align="left"><strong><span class="STYLE4" id="ssje"  vid="td5t">￥0.00</span></strong></div></td>
                                        </tr>
								  <tr>
								  		
                                          <td height="30" colspan="9" class="Privateborder">
                                         	<li class="horizontal_onlyRight">
                                          	取镜方式：
                                            <select name="ssesbtakeglasstype" id="ssesbtakeglasstype">
                                              <option value="0" selected="selected">正常</option>
                                              <option value="7">订做7</option>
                                              <option value="10">订做10</option>
                                              <option value="15">订做15</option>
                                              <option value="25">订做25</option>
                                            </select>
                                            &nbsp;&nbsp;&nbsp;&nbsp;取镜日期：
                                              <input id="ssesbtakeglassdata"
					       	name="salesBasicPo.ssesbtakeglassdata" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d'})"
					      /> </li>
					     
					      	&nbsp;&nbsp;&nbsp;&nbsp;
                                            <li class="horizontal_onlyRight">
	                                            <div id="showtr" style="display: none">委外方式：
		                                            <select id="DragsType" name="salesBasicPo.ssesbdragstype" disabled="disabled">
														<option value="1">委外订单</option>
														<option value="2">委外加工</option>
		 											</select>
	 											</div>
 											</li>
 											&nbsp;&nbsp;&nbsp;&nbsp;
                                            <li class="horizontal_onlyRight">
	                                            <div>
		                                            <img src="${ctx }/img/newbtn/btn_addmail_0.png" btn=btn title="填写邮寄信息" onclick="toMailInsert('${salseID }','${customerInfoPo.smecimemberid }','${customerInfoPo.smeciname }','${customerInfoPo.smeciphone }')">
	 											</div>
 											</li>
					      	</td>
					      	
                                     <td rowspan="3" class="Privateborder"><div align="center">
                                     <img id="buttonsave" name="button" src="${ctx }/img/newbtn/btn_count_0.png" btn=btn title="结算 " onclick="save()">
                                     </div>    
                                  	</td> 
								  </tr>
								  <tr>
                                          <td height="30" colspan="9" class="Privateborder">
                                          	取镜地点：
                                            <select id="ssesblocation" name="salesBasicPo.ssesblocation">
                                                	<s:iterator value="departmentsList" >
                                                		 <option value="${bdpdepartmentid }"  >${bdpdepartmentname}</option>
                                                	</s:iterator>
                                                </select>
                                            &nbsp;&nbsp;&nbsp;&nbsp;实收金额：
                                            <input name="salesBasicPo.ssesbpsalsvalue" id='sesbpsalsvalue' class="text_input" size="8">
                                           &nbsp;&nbsp;&nbsp;&nbsp;整单打折:<input size="8" name="salesBasicPo.ssesbdiscountrate"  class="text_input"  type="text" readonly="readonly"  onclick="discount1()" >
                                           &nbsp;&nbsp;&nbsp;&nbsp;抹零金额：<input size="8" id="td10t" class="text_input"  type="text"  onkeydown="changeMolingAmount(this)">&nbsp;<font color="red">抹零请按回车键</font>
                                           <c:forEach var="po" items="${discountShortcutKeysPolist}">
                                           	&nbsp;<button id="${po.fdkid} }" name="${po.fdkid}" onclick="setDiscount1('${po.fdkkeyvalues}','${person.id}','1')"/>${po.fdkkeyname}</button>
                                           </c:forEach>
                                            </td>
                                          </tr>
                                      </table></td>
							</tr>
						</table>
						<fieldset>
						<br>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="25%" valign="top">
							<fieldset>
							<legend>选择商品</legend>
							<table width="99%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                              <tr>
                                <td width="20%" class="table_body">镜架</td>
                                <td colspan="4" class="table_none"><div align="right"><img name="button223" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addFrameGoods()"></div></td>
                                </tr>
                              <tr>
                                <td class="table_body">右眼</td>
                                <td width="25%" class="table_none"><input type="radio" name="materialTypeR" value="1" checked="checked">树脂</td>
                                <td width="25%" class="table_none"><input type="radio" name="materialTypeR" value="0">玻璃</td>
                                 <td width="25%" class="table_none"><input type="radio" name="materialTypeR" value="2">PC</td>
                                <td width="14%" class="table_none"><img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addGlassGoods('R', frameSalesForm.materialTypeR.value)"></td>
                              </tr>
                              <tr>
                                <td class="table_body">左眼</td>
                                <td class="table_none"><input type="radio" name="materialTypeL" value="1" checked="checked">树脂</td>
                                <td class="table_none"><input type="radio" name="materialTypeL" value="0">玻璃</td>
                                 <td  class="table_none"><input type="radio" name="materialTypeL" value="2">PC</td>
                                <td class="table_none"><img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="javascript:addGlassGoods('L', frameSalesForm.materialTypeL.value);"></td>
                              </tr>
                               <tr>
                                <td class="table_body">镜架辅料</td>
                                <td colspan="4" class="table_none"><div align="right">
                                  <img name="button2232" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="addFrame('frame')">
                                </div></td>
                                </tr>
                              <tr>
                                <td class="table_body">附加费用</td>
                                <td colspan="3" class="table_none">
								<select id="additionalCosts" name="additionalCosts">
								  <option>----请选择----</option>
								  <s:iterator value="additionalCostsList">
								  <option value="${facid},${facamount}">${facname}</option>
								  </s:iterator>
								</select></td>
                                <td class="table_none"><img name="button22332" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onclick="addCosts(this)"></td>
                              </tr>
                              <!--
                              <tr>
                                <td class="table_body">促销打折活动</td>
                                <td colspan="2" class="table_none">
								<select id="a1">
								  <option>请选择打折促销活动</option>
								</select></td>
                                <td class="table_none"><input name="button22332" type='button' value='选择' icon='icon-Search' ></td>
                              </tr>  -->
                              <tr>
                                <td class="table_body">加工要求</td>
                                <td colspan="3" class="table_none"><select name="specialRequirements" id="specialRequirements">
                                  <option>----请选择----</option>
                                 <s:iterator value="specialList">
                                  <option value="${fsrname }">${fsrname}</option>
                                  </s:iterator>
                                </select></td>
                                <td class="table_none"><img name="button22333" src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onclick="addSpecial()"></td>
                              </tr>
                              <tr class="table_none">
                                <td colspan="2" class="Privateborder">
                                    <div align="left">
                                      &nbsp;&nbsp;
                                      <img id="jh" src="${ctx }/img/newbtn/btn_framebox_0.png" btn=btn title='镜盒'>
                                    </div></td>
                           
                                <td colspan="3" class="Privateborder">
                                    <div align="left">
                                      &nbsp;&nbsp;
                                      <img id="jb" name="button223332" src="${ctx }/img/newbtn/btn_framecloth_0.png" btn=btn title='镜布'>
                                    </div></td>
                             
                                  </tr>
                            </table>
							</fieldset>
							</td>
							<td width="1%"></td>
                            <td width="75%" valign="top">
							<fieldset>
							<legend>选购商品</legend>
							<table id="goodsInfo" width="100%" height="74" border="0" cellpadding="1" cellspacing="1">
                              <tr>
                                <td valign="top"><table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                  <tr >
                                    <td width="10%" height="26" class="table_body"><div align="center">商品代码</div></td>
                                    <td width="15%" class="table_body"><div align="center">商品名称</div></td>
                                    <td width="8%" class="table_body"><div align="center">单价</div></td>
                                    <td width="7%" class="table_body"><div align="center">数量</div></td>
                                    <td width="7%" class="table_body"><div align="center">原价<br>合计</div></td>
                                    <td width="5%" class="table_body"><div align="center">折扣率</div></td>
                                    <td width="7%" class="table_body"><div align="center">折扣<br>金额</div></td>
                                    <td width="7%" class="table_body"><div align="center">抹零<br>金额</div></td>
                                    <td width="7%" class="table_body"><div align="center">应收<br>金额</div></td>
                                    <td width="10%" class="table_body"><div align="center">商品描述</div></td>
                                    <td width="6%" class="table_body"><div align="center">删除</div></td>
                                  </tr>
                                <tr id="copyrow" style="display:none">
                                    <td   class="Privateborder"><input style="width:100px;background:transparent;border:0px;" " title="" name="salesDetailPo.ssesdsalesitemids" readonly="readonly"></td>
                                    <td  class="Privateborder"><input style="width: 100px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesdsalesitemnames" readonly="readonly" class="text_inputhidden"></td>
                                    <td   class="Privateborder"><input style="width: 40px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesdsprices" readonly="readonly" class="text_inputhidden yjje"></td>
                                    <td  class="Privateborder"><input style="width: 42px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesdnumbers" readonly="readonly" class="text_inputhidden"></td>
                                    <td  class="Privateborder"><input style="width: 40px;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdpricesums" readonly="readonly" class="text_inputhidden pricesum"></td>
                                    <td  class="Privateborder"><input style="width: 40px;"  title="" onmouseover="salesover(this)" onmouseout="salesout(this)" readonly="readonly" name="salesDetailPo.ssesddiscountrates" onclick="discount2(this)" readonly="readonly" class="text_inputhidden discountrate salesout" >
                                    	<input type="hidden" class="rownumber" name="rownumber"/>
                                    </td>
                                    <td  class="Privateborder"><input  style="width: 40px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesddiscountnums" readonly="readonly" class="text_inputhidden zksum"></td>
                                    <td  class="Privateborder"><input  style="width: 40px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesdrenums" readonly="readonly" class="text_inputhidden resum"></td>
                                    <td  class="Privateborder"><input style="width: 40px;background:transparent;border:0px;"  title="" name="salesDetailPo.ssesdsalesvalues" readonly="readonly" class="text_inputhidden yssum"></td>
                                     <td  class="Privateborder"><input  style="width: 80px;" title="" onmouseover="salesover(this)" onmouseout="salesout(this)" name="salesDetailPo.ssesdgooddescribes"  class="text_inputhidden salesout">
                                       <input type="hidden" name="salesDetailPo.ssesdcostsprives"/>
                                       <input type="hidden" name="salesDetailPo.ssesditemids"/>
                                       <input type="hidden" name="salesDetailPo.ssesdunitprices"/>   <input type="hidden" name="salesDetailPo.iscustomizes"/><input type="hidden"  name="salesDetailPo.ssesdcommoditiesflags"/>
                                       <input type="hidden" name="orderCycle"/>
                                     </td>
                                    <td width="6%" class="Privateborder"><div  align="center">
                                       <input type="hidden" class="cccc" name="salesDetailPo.ssesdglassflags"/>
                                       <img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr

('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' onclick="deleteItem(this);deleteVar1(this)">
                                       </div>
                                    </td>
                                  </tr>
                                </table></td>
                                </tr>
                              <tr>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="2">
                                  <tr>
                                    <td valign="top" width="15%"><table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                      <tr>
                                        <td height="26" colspan="2" class="table_body">赠品</td>
                                        </tr>
									  <tr id="copyrowGifts" style="display:none">
                                        <td width="80%" class="table_none"><span  id="giftsviewname"></span><input type="hidden" name="giftsPo.bgsviewname"></input>
                                        <input type="hidden" name="giftsPo.bgsgoodstype">
                                        <input type="hidden" name="giftsPo.bgsgoodsid">
                                        <input type="hidden" name="giftsPo.bgsgoodsbarcode">
                                        <input type="hidden" name="giftsPo.bgscostprice">
                                        <input type="hidden" name="giftsPo.bgsnottaxrate">
                                        <BR></td>
                                        <td width="20%" height="26" class="table_none"><div align="center">
                                          <img src="${ctx}/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr

('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' onclick="deleteItem(this)" >
                                        </div></td>
                                      </tr>
                             
                                    </table></td>
                                    <td width="22%" valign="top"><table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                      <tr>
                                        <td width="35%" height="26" bgcolor="#CADEE8" class="Privateborder">附加费名称</td>
                                        <td width="15%" bgcolor="#CADEE8" class="Privateborder">金额</td>
                                        <td width="10%" bgcolor="#CADEE8" class="Privateborder">数量</td>
                                        <td width="20%" bgcolor="#CADEE8" class="Privateborder">合计</td>
                                        <td width="15%" bgcolor="#CADEE8" class="Privateborder">删除</td>
                                      </tr>
                                      <tr style="display:none" id="copyrowCosts">
                                        <td class="table_none"><span id="costs"></span><input type="hidden" name="additionalCostsPo.facname">
                                        <input type="hidden" name="additionalCDetailPo.sseadditionalid"><BR></td>
                                        <td class="table_none"><span id="costsMoney"></span><input class="fjfy" type="hidden" name="additionalCostsPo.facamount"><BR></td>
                                        <td class="table_none"><input type="text" size="8" class="text_input60 number" id="0" name="additionalCDetailPo.ssenumber" onblur="addCosts(this)" validate=""><BR></td>
                                        <td class="table_none"><span id="amountMoney"></span><input class="fjfya" type="hidden" id="amountMoney" name="amountMoney"></td>
                                        <td class="table_none"><div align="center">
                                            <img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr

('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' name="button22432" onclick="deleteItem(this);deleteVar2(this)">
                                        </div></td>
                                      </tr>
                                    </table></td>
                                    <!-- 加工要求 -->
                                    <td width="22%" valign="top">
                                    <table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                      <tr>
                                        <td height="26" colspan="2" bgcolor="#CADEE8" class="Privateborder">加工要求</td>
                                      </tr>
                                      <tr style="display:none" id="copyrowSpecial">
                                        <td width="75%" height="26" class="table_none"><input name="specialPDetailPo.ssesdrequirement" size="14"><BR></td>
                                        <td width="25%" class="table_none"><div align="center">
                                            <img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_1.png');" onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/delete_0.png');" btn=btn title='删除' name="button22432" onclick="deleteItem(this)">
                                        </div></td>
                                      </tr>
                                    </table>
                                    </td>
                                    <!-- 特殊加工要求 
                                    <td width="34%" valign="top">
                                    <table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                      <tr>
                                        <td height="25" colspan="4" bgcolor="#CADEE8" class="Privateborder">特殊加工要求</td>
                                      </tr>
                                      <tr style="display:none" id="copyrowSpecial1">
                                        <td width="80%" class="table_none"><input name="prodtypename" size="2" readonly="readonly"><input name="salesSpecialPo.ssesssalestype" size="2" type="hidden"><BR></td>
                                        <td width="80%" class="table_none"><input name="salesSpecialPo.prodlocal" readonly="readonly" size="8"><input name="salesSpecialPo.ssessalesspecialid" type="hidden" ><BR></td>
                                        <td width="80%" class="table_none"><input name="salesSpecialPo.ssesssalesvalue" readonly="readonly" size="8" ><BR></td>
                                        <td width="20%" class="Privateborder"><div align="center">
                                            <input name="button22432" type='button' value='删除' onclick="deleteItem(this)" icon='icon-delete' >
                                        </div></td>
                                      </tr>
                                    </table>
                                    </td> -->
                                  </tr>
                                </table></td>
                              </tr>
                              <!-- 
                              <tr>
                                <td><table width="100%" style="margin-bottom:5px;" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                  <tr>
                                    <td height="25" colspan="2" class="table_body">促销打折活动</td>
                                  </tr>
                                  <tr>
                                    <td width="80%" height="24" class="Privateborder">活动名称<BR></td>
                                    <td width="20%" rowspan="2" class="Privateborder"><div align="center">
                                          <input name="button224322" type='button' value='删除' icon='icon-delete' >
                                                                        </div></td>
                                  </tr>
                                  <tr>
                                    <td height="35" class="Privateborder">活动内容#################################</td>
                                    </tr>

                                </table></td>
                                </tr>  -->
                            </table>
							</fieldset>
							
							</td>
                          </tr>
                        </table>
						<br>
						<!--ݿEnd--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
    <script>

document.getElementById('smecimemberid').focus();  

function selectCustomer(){
	if(document.getElementById('smecimemberid').value.trim() != '')
		if(event.keyCode == 13)
			document.forms[0].submit();
}

function details(id){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【会员详细】";
}	
function selCustomer(){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	document.getElementById('popupTitle').innerHTML="【会员查询】";
}
function setCustomer(memberid){
	document.getElementById('smecimemberid').value = memberid;
	document.forms[0].submit();
}

</script>