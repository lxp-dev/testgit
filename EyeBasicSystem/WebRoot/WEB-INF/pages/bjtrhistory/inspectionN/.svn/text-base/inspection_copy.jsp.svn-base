<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>验光检查</title>
</head>
<script>	
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
	//球镜、柱镜
	var re1 = /^[\+\-]?[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	
	//视力
	var re2 = /^[0-9]{1}([.]{1}[0-9]{1,2})?$/;
	
	//棱镜、下加
	var re3 = /^[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	
	//瞳距
	var re4 = /^[0-9][0-9](\.[0-9])?$/;
	
	//直径
	var re5 = /^[0-9]*([.]{0,1}[0-9])$/;
	
	//球径柱径
	var re6 = /^-?\d+$/;
	
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
			obj.focus();
		}
		
		vaAddZero(obj);
	}
	function syjp(glassType,goodsCategoryID){ //适用镜片开窗
		
		showPopWin("","initWindowInspectionNormalOpen.action?glassType="+glassType+"&goodsCategoryID="+goodsCategoryID,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	function openGoodSingleValues(json){   //适用镜片回调赋值
		if(json.glassType=='1'){
			$('input[name=inspectionPos\\[0\\]\\.sopipcommendglasses]').val(json.brandName);
		}else if(json.glassType=='2'){
			$('input[name=inspectionPos\\[1\\]\\.sopipcommendglasses]').val(json.brandName);
		}else if(json.glassType=='3'){
			$('input[name=inspectionPos\\[2\\]\\.sopipcommendglasses]').val(json.brandName);
		}else if(json.glassType=='4'){
			$('input[name=inspectionPos\\[3\\]\\.sopipcommendglasses]')[0].value=json.brandName;
		}else if(json.glassType=='5'){
			$('input[name=inspectionPos\\[3\\]\\.sopipcommendglasses]')[1].value=json.brandName;
		}
	}
	function jyhly(){ //建议护理液开窗
		showPopWin("","initWindowInspectionOtherOpen.action?categoryID_open=5",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	function clearSyjp(glassType){
		if(glassType==3||glassType==4){
			if(glassType==3){
				$('input[name=inspectionPos\\[3\\]\\.sopipcommendglasses]')[0].value='';
			}else if(glassType==4){
				$('input[name=inspectionPos\\[3\\]\\.sopipcommendglasses]')[1].value='';
			}
		}else{
			$('input[name=inspectionPos\\['+glassType+'\\]\\.sopipcommendglasses]').val('');
		}
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
	
	//验证球镜
	function checkData(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		
		if(parseFloat(obj.value)%0.25!=0){
			alert("球径应为 0.25的倍数！");
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
	//验证柱径
	function checkDataz(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		
		if(parseFloat(obj.value)%0.25!=0){
			alert("柱径应为 0.25的倍数！");
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
				obj.value = '-' + obj.value;
			}
		}
		
		$("[cyl=cyl]").each(function (){
			if(parseFloat($(this).val()) == 0){
				$(this).parent().parent().parent().find("[axes=axes]").val("");
				$(this).parent().parent().parent().find("[axes=axes]").attr("style","background-color: red;");
				$(this).parent().parent().parent().find("[axes=axes]").attr("readonly","readonly");
			}else{
				$(this).parent().parent().parent().find("[axes=axes]").attr("style","background-color: white;");
				$(this).parent().parent().parent().find("[axes=axes]").attr("readonly","");
			}
		});
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
//按键改变数值
function changeFocus1(obj)
{
    if(event.keyCode==38){
		if(obj.value == ''){
			obj.value='0.00';
		}
		else{
			if(parseFloat(obj.value)>=0||obj.value==''){
				return;
			}else{
		    	obj.value = (parseFloat(obj.value)+0.25).toFixed(2);		
			}
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
	function cleanTable(){
		var yy = document.all.yy;
		var jy = document.all.jy;
		var jj = document.all.jj;
		var yx = document.all.yx;
		
		yy.style.display = 'none';
		jy.style.display = 'none';
		jj.style.display = 'none';
		yx.style.display = 'none';
	}
	
	function displayTable(obj){
		var yy = document.all.yy;
		var jy = document.all.jy;
		var jj = document.all.jj;
		var yx = document.all.yx;
		cleanTable();
		var ctl00_PageBody_PostButton = document.all.ctl00_PageBody_PostButton;
		var fz = document.all.fz;
		ctl00_PageBody_PostButton.style.display = '';
		fz.style.display = '';		
		
		
		var myValue = obj.value;
		//1 远用
		//2 近用
		//3 渐进/双光
		//4 隐形
		//5 远用+近用
		//6 远用+隐形
		//7 近用+隐形
		//8 渐进/双光+隐形
		//9 渐进/双光+远用
		//10 渐进/双光+近用
		//11 远用+近用+隐形
		//12 远用+近用+渐进/双光
		$(':input').each(function(){
			$(this).unbind('keydown');
		});
		
		$('input[needChange=needChange][sph=sph]').each(function(){
			$(this).bind("keydown",function(){
				changeFocus(this);
			});
		});
		$('input[needChange=needChange][cyl=cyl]').each(function(){
			$(this).bind("keydown",function(){
				changeFocus1(this);
			});
		});
		if(myValue == "1"){
			yy.style.display = '';
			yymove('jj');
		}else if(myValue == "2"){
			jy.style.display = '';
			jjmove();
		}else if(myValue == "3"){
			jj.style.display = '';
			jjsgmove();
		}else if(myValue == "4"){
			yx.style.display = '';
		}else if(myValue == "5"){
			yy.style.display = '';
			jy.style.display = '';
			yymove('jj');
			jjmove();
		}else if(myValue == "6"){
			yy.style.display = '';
			yx.style.display = '';
			yymove('jj');
		}else if(myValue == "7"){
			jy.style.display = '';
			yx.style.display = '';
			jjmove();
		}else if(myValue == "8"){
			jj.style.display = '';
			yx.style.display = '';
			jjsgmove();
		}else if(myValue == "9"){
			jj.style.display = '';
			yy.style.display = '';
			yymove('jjsg');
			jjmove();
			jjsgmove();
		}else if(myValue == "10"){
			jj.style.display = '';
			jy.style.display = '';
			
			jjmove();
			jjsgmove();
		}else if(myValue == "11"){
			yy.style.display = '';
			jy.style.display = '';
			yx.style.display = '';
			yymove('jj');
			jjmove();
		}else if(myValue == "12"){
			yy.style.display = '';
			jy.style.display = '';
			jj.style.display = '';
			yymove('jj');
			jjmove();
			jjsgmove();
		}
	}
	
	function displayTable2(myValue){
		var yy = document.all.yy;
		var jy = document.all.jy;
		var jj = document.all.jj;
		var yx = document.all.yx;
		cleanTable();
		var ctl00_PageBody_PostButton = document.all.ctl00_PageBody_PostButton;
		var fz = document.all.fz;
		ctl00_PageBody_PostButton.style.display = '';
		fz.style.display = '';		
		$(':input').each(function(){
			$(this).unbind('keydown');
		});
		$('input[needChange=needChange][sph=sph]').each(function(){
			$(this).bind("keydown",function(){
			
				changeFocus(this);
			});
		});
		$('input[needChange=needChange][cyl=cyl]').each(function(){
			$(this).bind("keydown",function(){
				changeFocus1(this);
			});
		});
		
		//1 远用
		//2 近用
		//3 渐进/双光
		//4 隐形
		//5 远用+近用
		//6 远用+隐形
		//7 近用+隐形
		//8 渐进/双光+隐形
		//9 渐进/双光+远用
		//10 渐进/双光+近用
		//11 远用+近用+隐形
		//12 远用+近用+渐进/双光
		if(myValue == "1"){
			yy.style.display = '';
			yymove('jj');
		}else if(myValue == "2"){
			jy.style.display = '';
			jjmove();
		}else if(myValue == "3"){
			jj.style.display = '';
			jjsgmove();
		}else if(myValue == "4"){
			yx.style.display = '';
		}else if(myValue == "5"){
			yy.style.display = '';
			jy.style.display = '';
			yymove('jj');
			jjmove();
		}else if(myValue == "6"){
			yy.style.display = '';
			yx.style.display = '';
			yymove('jj');
		}else if(myValue == "7"){
			jy.style.display = '';
			yx.style.display = '';
			jjmove();
		}else if(myValue == "8"){
			jj.style.display = '';
			yx.style.display = '';
			jjsgmove();
		}else if(myValue == "9"){
			jj.style.display = '';
			yy.style.display = '';
			yymove('jjsg');
			jjmove();
			jjsgmove();
		}else if(myValue == "10"){
			jj.style.display = '';
			jy.style.display = '';
			
			jjmove();
			jjsgmove();
		}else if(myValue == "11"){
			yy.style.display = '';
			jy.style.display = '';
			yx.style.display = '';
			yymove('jj');
			jjmove();
		}else if(myValue == "12"){
			yy.style.display = '';
			jy.style.display = '';
			jj.style.display = '';
			yymove('jj');
			jjmove();
			jjsgmove();
		}
	}
	function cleanTableAll(){
		var yy = document.all.yy;
		var jy = document.all.jy;
		var jj = document.all.jj;
		var yx = document.all.yx;
		
		var ctl00_PageBody_PostButton = document.all.ctl00_PageBody_PostButton;
		var fz = document.all.fz;
		
		yy.style.display = 'none';
		jy.style.display = 'none';
		jj.style.display = 'none';
		yx.style.display = 'none';
		ctl00_PageBody_PostButton.style.display = 'none';
		fz.style.display = 'none';
	}
	function save(){
		if($('#glassType').val()==''){
			alert('请选择处方类型!');
			return;
		}
			if($('#glassType').val()==1){
			if($('input[name=inspectionPos[0].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighos]').focus();
				return false;
			}
		}else if($('#glassType').val()==2){
			if($('input[name=inspectionPos[1].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceod]')[0].value==''){
				alert('右眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceos]')[0].value==''){
				alert('左眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceos]').focus();
				return false;
			}
		}else if($('#glassType').val()==3){
			if($('input[name=inspectionPos[2].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[2].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[2].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighos]').focus();
				return false;
			}
			
			if($('input[name=inspectionPos[2].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighos]').focus();
				return false;
			}
			
			if($('input[name=inspectionPos[2].sopipaddod]')[0].value==''){
				alert('右眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddos]')[0].value==''){
				alert('左眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddos]').focus();
				return false;
			}
			
			
		}else if($('#glassType').val()==4){
			if($('input[name=inspectionPos[3].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[3].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassos]').focus();
				return false;
			}
			
		}else if($('#glassType').val()==5){
			if($('input[name=inspectionPos[0].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighod]')[0].value==''){
				
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassos]')[0].value==''){
			
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceod]')[0].value==''){
				alert('右眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceos]')[0].value==''){
				alert('左眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceos]').focus();
				return false;
			}
		}else if($('#glassType').val()==6){
			if($('input[name=inspectionPos[0].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[3].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[3].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassos]').focus();
				return false;
			}
		}else if($('#glassType').val()==7){
			if($('input[name=inspectionPos[3].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[3].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceod]')[0].value==''){
				alert('右眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceos]')[0].value==''){
				alert('左眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceos]').focus();
				return false;
			}
		}else if($('#glassType').val()==8){
			if($('input[name=inspectionPos[3].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[3].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[2].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[2].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddod]')[0].value==''){
				alert('右眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddos]')[0].value==''){
				alert('左眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddos]').focus();
				return false;
			}
		}else if($('#glassType').val()==9){
			if($('input[name=inspectionPos[2].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[2].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[2].sopipballglassos]').focus();
				return false;
			}
	
			if($('input[name=inspectionPos[2].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddod]')[0].value==''){
				alert('右眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddos]')[0].value==''){
				alert('左眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddos]').focus();
				return false;
			}
		}else if($('#glassType').val()==10){
			if($('input[name=inspectionPos[2].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				return false;
			}
			if($('input[name=inspectionPos[2].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				return false;
			}
		
			if($('input[name=inspectionPos[2].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceod]')[0].value==''){
				alert('右眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceos]')[0].value==''){
				alert('左眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddod]')[0].value==''){
				alert('右眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddos]')[0].value==''){
				alert('左眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddos]').focus();
				return false;
			}
		}else if($('#glassType').val()==11){
			if($('input[name=inspectionPos[0].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighod]')[0].value==''){
				
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassos]')[0].value==''){
			
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceod]')[0].value==''){
				alert('右眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceos]')[0].value==''){
				alert('左眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[3].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[3].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[3].sopipballglassos]').focus();
				return false;
			}
		}else if($('#glassType').val()==12){
				if($('input[name=inspectionPos[0].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[0].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighod]')[0].value==''){
				
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[0].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[0].sopipinterhighos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipballglassos]')[0].value==''){
			
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[1].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceod]')[0].value==''){
				alert('右眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[1].sopipinterdistanceos]')[0].value==''){
				alert('左眼近用瞳距不能为空!');
				$('input[name=inspectionPos[1].sopipinterdistanceos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipballglassod]')[0].value==''){
				alert('右眼球镜不能为空!');
				$('input[name=inspectionPos[2].sopipballglassod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipballglassos]')[0].value==''){
				alert('左眼球镜不能为空!');
				$('input[name=inspectionPos[2].sopipballglassos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighod]')[0].value==''){
				alert('右眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipinterhighos]')[0].value==''){
				alert('左眼远用瞳距不能为空!');
				$('input[name=inspectionPos[2].sopipinterhighos]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddod]')[0].value==''){
				alert('右眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddod]').focus();
				return false;
			}
			if($('input[name=inspectionPos[2].sopipaddos]')[0].value==''){
				alert('左眼ADD不能为空!');
				$('input[name=inspectionPos[2].sopipaddos]').focus();
				return false;
			}
		}
		if(document.getElementsByName('inspectionPos[3].sopipconlenodnum')[0].value!=''){
			if(isNaN(document.getElementsByName('inspectionPos[3].sopipconlenodnum')[0].value)){
				alert('右眼隐形适用镜片数只能为数字!');
					document.getElementsByName('inspectionPos[3].sopipconlenodnum')[0].focus();
					return;
			}
		}
		if(document.getElementsByName('inspectionPos[3].sopipconlenosnum')[0].value!=''){
			if(isNaN(document.getElementsByName('inspectionPos[3].sopipconlenosnum')[0].value)){
				alert('左眼隐形适用镜片数只能为数字!');
					document.getElementsByName('inspectionPos[3].sopipconlenosnum')[0].focus();
					return;
			}
		}
		
		var sphindex=0;
		//$('input[sph=sph]').each(function(){
	//		turnPrescription(this,$('input[cyl=cyl]')[sphindex],$('input[axes=axes]')[sphindex]);
		//	sphindex++;
	//	});
			$('input[cyl=cyl]').each(function(){
			if($(this).val()==''){
				$(this).val('0.00');
			}
		});
		if(confirm('是否为正式提交(确定--正式提交,取消--非正常提交)')){
			inspectionForm.action="inspectionInsert.action?ruleFlag=1&copya=1";
		}else{
			inspectionForm.action="inspectionInsert.action?ruleFlag=0&copya=1";
		}
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	
	
	$(document).ready(function(){
		$('#glassType').attr('value','${glassType}');
		displayTable2('${glassType}');
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
		
		$("#sopipbasisod1f").attr("value","${inspectionPos[0].sopipbasisod1}");
		$('#sopipbasisos1f').attr("value","${inspectionPos[0].sopipbasisos1}");
		
		$('#sopipbasisod1n').attr("value","${inspectionPos[1].sopipbasisod1}");
		$('#sopipbasisos1n').attr("value","${inspectionPos[1].sopipbasisos1}");
		
		$('#sopipbasisod1j').attr("value","${inspectionPos[2].sopipbasisod1}");
		$('#sopipbasisod1j').attr("value","${inspectionPos[2].sopipbasisos1}");
		

		$('#sopipsuggestframef').attr("value","${inspectionPos[0].sopipsuggestframe}");
		$('#sopipsuggestframen').attr("value","${inspectionPos[1].sopipsuggestframe}");
		$('#sopipsuggestframej').attr("value","${inspectionPos[2].sopipsuggestframe}");
		
		
		$('#sopipglassmaterialf').attr("value","${inspectionPos[0].sopipglassmaterial}");
		$('#sopipglassmaterialn').attr("value","${inspectionPos[1].sopipglassmaterial}");
		$('#sopipglassmaterialj').attr("value","${inspectionPos[2].sopipglassmaterial}");
		
		$('#sopipdisposemannerf').attr("value","${inspectionPos[0].sopipdisposemanner}");
		$('#sopipdisposemannern').attr("value","${inspectionPos[1].sopipdisposemanner}");
		$('#sopipdisposemannerj').attr("value","${inspectionPos[2].sopipdisposemanner}");
		
		$('#sopipconrecipetype').attr("value","${inspectionPos[3].sopipconrecipetype}");
		
		$('#sopipsubvisitunit').attr("value","${inspectionPos[0].sopipsubvisitunit}");
		$('#sopipseccheckdate').attr("value","${inspectionPos[0].sopipseccheckdate}");
		
		inspectionCheck();
		
		var sopipcommendglasses='${inspectionPos[3].sopipcommendglasses}'.split(',');//隐形适用镜片附值
		
		for(var i=0;i<sopipcommendglasses.length;i++){
			$('input[name=inspectionPos[3].sopipcommendglasses]')[i].value=sopipcommendglasses[i].trim();
		}
	});
	function doubleEyeFun(){
		$("img").removeAttr("onclick");
		inspectionForm.action="doubleEyeFunTool.action?source=doubleeyefuncopy";
		inspectionForm.submit();
	}
	function specialCheck(){
		$("img").removeAttr("onclick");
		inspectionForm.action="specialCheckTool.action?source=specialcheckcopy";
		inspectionForm.submit();
	}
	function refractive(){
		$("img").removeAttr("onclick");
		inspectionForm.action="refractiveTool.action?source=refractivecopy";
		inspectionForm.submit();
	}
	function contactGlass(){
		
		$("img").removeAttr("onclick");
		inspectionForm.action="contactGlassToolBjtr.action?source=inspectioniou";
		inspectionForm.submit();
	}
	function glassHistory(){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		inspectionForm.action="selectGlassesHistoryBjtr.action?customerID="+'${customerInfoPo.smecicustomerid }';
		inspectionForm.submit();
	}
		/*
验证脚本
*/
function inspectionCheck(){
		$('input[cyl=cyl]').each(function(){
			$(this).bind("blur",function(){
				checkDataz(this);
				try{
					if(parseFloat($(this).val())>0){
						alert('柱镜不能为正!');
						$(this).val('');
						$(this).focus();
						throw '1';
					}
				}catch(e){
					return;	
				}
			});
		});	
		$('input[sph=sph]').each(function(){
			$(this).bind("blur",function(){checkData(this);});
			
		});	
		
		$('input[axes=axes]').each(function(){
			$(this).bind("blur",function(){
				checkAxiss(this);
			});
		});
		
		$('input[tongju=tongju]').each(function(){
			$(this).bind("blur",function(){
				checkPupilDistance(this);
			});
		});
		
		$('input[ljxj=ljxj]').each(function(){
			$(this).bind("blur",function(){
				checkLjXj(this);
			});
		});
		
		$('input[va=va]').each(function(){
			$(this).bind("blur",function(){
				checkVA(this);
			});
		});
		
		
		
}
function yymove(type){ //远用回车一动
		$(':input[yyorder]').each(function(){
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('yyorder');
						$(':input[yyorder='+accAdd(index,1)+']').focus();
						if(index==14&&type=='jj'){
							$(':input[jjorder=1]').focus();
						}
						if(index==14&&type=='jjsg'){
							$(':input[jjsgorder=1]').focus();
						}
					}
				});
			});
	}
	
	function jjmove(){ //近用回车一动
		$(':input[jjorder]').each(function(){
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('jjorder');
						$(':input[jjorder='+accAdd(index,1)+']').focus();
						if(index==16){
							$(':input[jjsgorder=1]').focus();
						}
					}
				});
			});
	}
	
	function jjsgmove(){ //渐进双光回车一动
		$(':input[jjsgorder]').each(function(){
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('jjsgorder');
						$(':input[jjsgorder='+accAdd(index,1)+']').focus();
					}
				});
			});
	}
	
	function queryInvisibilityEyeglass(glassType,goodsCategoryID){
	    //OD:球镜
	    var sopipballglassod = null;
	    //OD:柱镜
	    var sopipballglassod = null;
	    //OS:球镜
	    var sopipballglassos = null;
	    //OS:柱镜
	    var sopippostglassos = null;
	    
	    if (glassType == '4'){
	        sopipballglassod = document.getElementsByName("inspectionPos[3].sopipballglassod")[0].value;
	        sopippostglassod = document.getElementsByName("inspectionPos[3].sopippostglassod")[0].value;
	        if (sopippostglassod == ""){
	            sopippostglassod = 0;
	        }
	        showPopWin("","initWindowInspectionOtherOpen.action?categoryID_open=4&glassType="+glassType+"&goodsCategoryID="+goodsCategoryID+"&sopipballglass="+sopipballglassod+"&sopippostglass="+sopippostglassod,screen.width-200,screen.height-200, '', null, true);
	    }else if (glassType == '5'){
	        sopipballglassos = document.getElementsByName("inspectionPos[3].sopipballglassos")[0].value;
	        sopippostglassos = document.getElementsByName("inspectionPos[3].sopippostglassos")[0].value;
	        if (sopippostglassos == ""){
	            sopippostglassos = 0;
	        }	        
	       showPopWin("","initWindowInspectionOtherOpen.action?categoryID_open=4&glassType="+glassType+"&goodsCategoryID="+goodsCategoryID+"&sopipballglass="+sopipballglassos+"&sopippostglass="+sopippostglassos ,screen.width-200,screen.height-200, '', null, true);
	    }
		selectHidden();
	}
	
	function checkCylZero(){
  		$("[cyl=cyl]").each(function (){
			if(parseFloat($(this).val()) == 0){
				$(this).parent().parent().parent().find("[axes=axes]").val("");
				$(this).parent().parent().parent().find("[axes=axes]").attr("style","background-color: red;");
				$(this).parent().parent().parent().find("[axes=axes]").attr("readonly","readonly");
			}else{
				$(this).parent().parent().parent().find("[axes=axes]").attr("style","background-color: white;");
				$(this).parent().parent().parent().find("[axes=axes]").attr("readonly","");
			}
		});
  	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inspectionForm" method="post" action="">

<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID"  value="${requestScope.optometryID}" />  
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" />  
<input type="hidden" name="oldOptometryID"  value="${requestScope.oldOptometryID}" />  
<input type="hidden" name="moduleID"  value="${moduleID }"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
		<!-- ͷ˵ Start -->
		  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TBODY>
			  <TR>
				<TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光检查</TD>
				<TD class=menubar_readme_text vAlign=bottom>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();parent.window.location='initOptometryBasicSel.action?moduleID=B0801'"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
				</TD>
			  </TR>
			  <TR>
				<TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：检查结论</TD>
				<TD class=menubar_function_text align=right><TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                
                <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick='showPopWin("","initChargePutInsert.action?customerID="+"${customerInfoPo.smecicustomerid}",screen.width-200,screen.height-200, "",null,true);' 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx }/img/pic/New.gif" align=textTop 
                  border=0>&nbsp;费用提交&nbsp;</TD>
                  	<c:if test="${person.departmentID=='02adfdfweff'}">
                  	 <c:if test="${permissionPo.keyf=='1'}">
				  <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick='showPopWin("","initCardBillingNormal.action?customerID="+"${customerInfoPo.smecicustomerid}",screen.width-200,screen.height-200, "",null,true);' 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx }/img/pic/New.gif" align=textTop 
                  border=0>&nbsp;收取检查费&nbsp;</TD></c:if> <c:if test="${permissionPo.keyg=='1'}">
                    <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                onclick='showPopWin("","initCardBillingSpecial.action?customerID="+"${customerInfoPo.smecicustomerid}",screen.width-200,screen.height-200, "",null,true);' 
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx }/img/pic/New.gif" align=textTop 
                  border=0>&nbsp;特殊费用提交&nbsp;</TD></c:if>
                  </c:if>

             </TR></TBODY></TABLE></TD>
			  </TR>
			  <TR>
				<TD colSpan=2 height=5></TD>
			  </TR>
			</TBODY>
		  </TABLE>
		<!-- ͷ˵ End -->
		<!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0 onkeydown="if(event.keyCode==13)event.keyCode=9">
        <TBODY>
			<TR>
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx}/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
							  <c:if test="${(permissionPo.keya==1)}">
				 					<TD>
									  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
										<TBODY>
										<TR>
					                      <TD width=3><IMG id=tabImgLeft__1 height=22 
					                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					                      <TD class=tab id=tabLabel__1                       
					                      background=${ctx}/img/pic/tab_unactive_bg.gif 
					                      onclick="glassHistory()"
					                      UNSELECTABLE="on">戴镜史</TD>
					                      <TD width=3><IMG id=tabImgRight__1 height=22 
					                        src="${ctx}/img/pic/tab_unactive_right.gif" 
					                    width=3></TD>
					                </TR>
									</TBODY>
								  </TABLE>
								  </TD>
					            </c:if>
							  				<TD>
								 			  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
									          <TBODY>
										      <TR>
											    <TD width=3><IMG id=tabImgLeft__1 height=22 
												src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												<TD class=tab id=tabLabel__1 
												onclick="refractive();" 
												background=${ctx }/img/pic/tab_unactive_bg.gif 
												UNSELECTABLE="on">屈光检查</TD>
												<TD width=3><IMG id=tabImgRight__1 height=22 
												src="${ctx }/img/pic/tab_unactive_right.gif" 
												width=3></TD>
											  </TR>
											  </TBODY>
											  </TABLE>
										    </TD>
											<TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__0 height=22 
													src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx}/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">检查结论</TD>
												  <TD width=3><IMG id=tabImgRight__0 height=22 
													src="${ctx}/img/pic/tab_active_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
											</TD>
											<TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="doubleEyeFun()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">双眼视功能检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="specialCheck()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">特殊功能检查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												
												<TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="contactGlass()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">接触镜评估</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
									</TR>
								</TBODY>
							</TABLE>
							</TD>
						</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
						<s:action name="initCustomerOptometryTitleBjtr" executeResult="true" />									
						<br>
						<fieldset>
							<legend>双眼视功能检查</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><table width="99%" 
                  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
                                    <tr>
                                      <td height="30" bgcolor="#CADEE8">处方类型：
                                        <select id="glassType" name="inspectionPo.sopipglasstype" onChange="displayTable(this);checkCylZero();">
                                            <option value="" selected="selected">----请选择----</option>
											<option value="1">远用</option>
											<option value="2">近用</option>
											<option value="3">渐进/双光</option>
											<option value="4">隐形</option>
											<option value="5">远用+近用</option>
											<option value="6">远用+隐形</option>
											<option value="7">近用+隐形</option>
											<option value="8">渐进/双光+隐形</option>
											<option value="9">渐进/双光+远用</option>
											<option value="10">渐进/双光+近用</option>
											<option value="11">远用+近用+隐形</option>
											<option value="12">远用+近用+渐进/双光</option>
                                      </select>
                                      &nbsp;&nbsp;&nbsp;</td>
                                    </tr>
                                  </tbody>
                                </table>
								  <br>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable" id="yy">
								  <TR>
                                    <TD colspan="15" style="height:20px" class="PrivateBorderGreen" bgcolor="dfffdf"><p>框架--远用<br></p>                                    </TD>							      </TR>
								  <TR>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">&nbsp;</TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">球镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">柱镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">轴向</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">Add</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">三棱镜</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">基底</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">远用瞳距(mm)</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">近用瞳距(mm)</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">远用VA</div></TD>
								    <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">近用VA</div></TD>
							      </TR>
                                  <TBODY>
                                    <TR>
                                      <TD width="11%" bgcolor="#DFFFDF" class="PrivateBorderGreen">OD</TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input needChange="needChange" yyorder="1" sph="sph" name="inspectionPos[0].sopipballglassod" class="text_input" size="4" value="${inspectionPos[0].sopipballglassod }">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input needChange="needChange" yyorder="2" cyl="cyl" name="inspectionPos[0].sopippostglassod" class="text_input" size="4" value="${inspectionPos[0].sopippostglassod }">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="3" name="inspectionPos[0].sopipaxesod" axes="axes" class="text_input" size="4" value="${inspectionPos[0].sopipaxesod}">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input  name="inspectionPos[0].sopipaddod"  readonly="readonly" ljxj="ljxj" class="text_input" size="4" value="${inspectionPos[0].sopipaddod }">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="4" name="inspectionPos[0].sopiparriseglassod1" ljxj="ljxj" class="text_input" size="4" value="${inspectionPos[0].sopiparriseglassod1 }">
                                      </div></TD>
                                      <TD width="6%" bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <div align="center">
                                          <select yyorder="5" id="sopipbasisod1f" name="inspectionPos[0].sopipbasisod1">
                                             <option value="">----请选择----</option>
                                            <option value="内">内</option>
											<option value="外">外</option>
											<option value="上">上</option>
											<option value="下">下</option>
                                          </select>
                                        </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="6" name="inspectionPos[0].sopipinterhighod" tongju="tongju" value="${inspectionPos[0].sopipinterhighod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input name="inspectionPos[0].sopipinterdistanceod" readonly="readonly" tongju="tongju" value="${inspectionPos[0].sopipinterdistanceod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="7" name="inspectionPos[0].sopipfarvaod" va="va" value="${inspectionPos[0].sopipfarvaod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input name="inspectionPos[0].sopipclosevaod" readonly="readonly" va="va" value="${inspectionPos[0].sopipclosevaod }" class="text_input" size="4">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="11%" bgcolor="#DFFFDF" class="PrivateBorderGreen">OS</TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="8" needChange="needChange" sph="sph" name="inspectionPos[0].sopipballglassos" value="${inspectionPos[0].sopipballglassos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="9" name="inspectionPos[0].sopippostglassos" cyl="cyl" value="${inspectionPos[0].sopippostglassos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="10" needChange="needChange" axes="axes" name="inspectionPos[0].sopipaxesos" value="${inspectionPos[0].sopipaxesos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input readonly="readonly" name="inspectionPos[0].sopipaddos" ljxj="ljxj" value="${inspectionPos[0].sopipaddos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="11" name="inspectionPos[0].sopiparriseglassos1" ljxj="ljxj" value="${inspectionPos[0].sopiparriseglassos1 }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen">
                                        <div align="center">
                                          <select yyorder="12" id="sopipbasisos1f"  name="inspectionPos[0].sopipbasisos1">
                                             <option value="">----请选择----</option>
                                            <option value="内">内</option>
											<option value="外">外</option>
											<option value="上">上</option>
											<option value="下">下</option>
                                          </select>
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="13" name="inspectionPos[0].sopipinterhighos" tongju="tongju" value="${inspectionPos[0].sopipinterhighos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input name="inspectionPos[0].sopipinterdistanceos" readonly="readonly" tongju="tongju" value="${ inspectionPos[0].sopipinterdistanceos}" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input yyorder="14" name="inspectionPos[0].sopipfarvaos" va="va" value="${inspectionPos[0].sopipfarvaos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">
                                        <input name="inspectionPos[0].sopipclosevaos" readonly="readonly" va="va" value="${inspectionPos[0].sopipclosevaos }" class="text_input" size="4">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="7" bgcolor="#DFFFDF" class="PrivateBorderGreen">
									  <li class="horizontal">
									    <div align="center">适用镜片：
									      <INPUT name="inspectionPos[0].sopipcommendglasses" value="${inspectionPos[0].sopipcommendglasses }" id="cc1.commendglasses" size="12" readOnly>
									      </div>
									  </li>
                                        <li class="horizontal">
                                          <div align="center">
                                            <INPUT name="button" type="button" icon="icon-search" onclick="syjp(1,3)" value="选 择">
                                          </div>
                                        </li>
                                      <li class="horizontal">
                                        <div align="center">
                                          <INPUT name="button" type="button" icon="icon-delete" onclick="clearSyjp(0)" value="清 除">
                                        </div>
                                      </li></TD>
                                      <TD colspan="4" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="center">中距离：
                                          <INPUT type="checkbox" value="1" ${inspectionPos[0].sopipmiddledistance=='1'?'checked':''} name="inspectionPos[0].sopipmiddledistance">
                                          建议镜框：
                                          <SELECT id="sopipsuggestframef" name="inspectionPos[0].sopipsuggestframe">
                                            <OPTION value="" selected> </OPTION>
                                            <OPTION value="打孔">打孔</OPTION>
                                            <OPTION value="拉丝">拉丝</OPTION>
                                            <OPTION value="板材">板材</OPTION>
                                            <OPTION value="框高">框高</OPTION>
                                            </SELECT>
                                          <INPUT value="${inspectionPos[0].sopipframeheight }" name="inspectionPos[0].sopipframeheight" size="12">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="2" bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="right">建议镜片材质：                                      </div></TD>
                                      <TD colspan="2" bgcolor="#DFFFDF" class="PrivateBorderGreen"><SELECT id="sopipglassmaterialf" name="inspectionPos[0].sopipglassmaterial">
                                        <OPTION value="" selected>请选择建议镜片材质</OPTION>
                                        <OPTION value="老花渐进">老花渐进</OPTION>
                                        <OPTION value="青少年渐进">青少年渐进</OPTION>
                                        <OPTION value="非球面树脂">非球面树脂</OPTION>
                                        <OPTION value="抗辐射镜片">抗辐射镜片</OPTION>
                                        <OPTION value="染色镜片">染色镜片</OPTION>
                                        <OPTION value="变色镜片">变色镜片</OPTION>
                                        <OPTION value="普通树脂">普通树脂</OPTION>
                                        <OPTION value="高折玻璃">高折玻璃</OPTION>
                                        <OPTION value="玻璃片">玻璃片</OPTION>
                                        <OPTION value="树脂偏光镜片（茶/灰）">树脂偏光镜片（茶/灰）</OPTION>
                                        <OPTION value="树脂抗疲劳镜片">树脂抗疲劳镜片</OPTION>
                                        <OPTION></OPTION>
                                      </SELECT></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="right">处理方式：                                      </div></TD>
                                      <TD colspan="2" bgcolor="#DFFFDF" class="PrivateBorderGreen"><select id="sopipdisposemannerf" name="inspectionPos[0].sopipdisposemanner">
                                        <option value="" selected>----请选择----</option>
                                        <option value="足矫">足矫</option>
                                        <option value="欠矫">欠矫</option>
                                        <option value="过矫">过矫</option>
                                        <option value="附加棱镜">附加棱镜</option>
                                        <option value="调整">调整</option>
                                        <option value="平衡">平衡</option>
                                        <option value="医嘱">医嘱</option>
                                        <option value="全矫">全矫</option>
                                        <option value="患者要求减度">患者要求减度</option>
                                      </select></TD>
                                      <TD bgcolor="#DFFFDF" class="PrivateBorderGreen"><div align="right">备注：                                      </div></TD>
                                      <TD colspan="3" bgcolor="#DFFFDF" class="PrivateBorderGreen"><textarea name="inspectionPos[0].sopipdignosisre">${inspectionPos[0].sopipdignosisre }</textarea></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable" id="jy">
                                  <TR>
                                    <TD colspan="15" style="height:20px" class="PrivateBorderBlue" bgcolor="#E1EBFD"><p>框架--近用<br>
                                    </p></TD>
                                  </TR>
                                  <TR>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue">&nbsp;</TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">球镜</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">柱镜</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">轴向</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">Add</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">三棱镜</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">基底</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">远用瞳距(mm)</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">近用瞳距(mm)</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">远用VA</div></TD>
                                    <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">近用VA</div></TD>
                                  </TR>
                                  <TBODY>
                                    <TR>
                                      <TD width="11%" bgcolor="#E1EBFD" class="PrivateBorderBlue">OD</TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="1" needChange="needChange" sph="sph" name="inspectionPos[1].sopipballglassod" value="${inspectionPos[1].sopipballglassod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="2" needChange="needChange" cyl="cyl" name="inspectionPos[1].sopippostglassod" value="${inspectionPos[1].sopippostglassod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="3" name="inspectionPos[1].sopipaxesod" axes="axes" value="${inspectionPos[1].sopipaxesod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="4" needChange="needChange" onblur="if(parseFloat(this.value)<0&&this.value!=''){alert('下加光不能为负!');this.value='';this.focus()}" name="inspectionPos[1].sopipaddod" sph="sph" value="${inspectionPos[1].sopipaddod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="5" name="inspectionPos[1].sopiparriseglassod1" ljxj="ljxj" value="${inspectionPos[1].sopiparriseglassod1 }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="6%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <select jjorder="6" id="sopipbasisod1n" name="inspectionPos[1].sopipbasisod1">
                                             <option value="" selected="selected">----请选择----</option>
                                            <option value="内">内</option>
											<option value="外">外</option>
											<option value="上">上</option>
											<option value="下">下</option>
                                          </select>
                                      </div></TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input name="inspectionPos[1].sopipinterhighod" tongju="tongju" readonly="readonly" value="${inspectionPos[1].sopipinterhighod }"  class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="7" name="inspectionPos[1].sopipinterdistanceod" tongju="tongju" value="${inspectionPos[1].sopipinterdistanceod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input name="inspectionPos[1].sopipfarvaod" va="va" readonly="readonly" value="${inspectionPos[1].sopipfarvaod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="8" name="inspectionPos[1].sopipclosevaod" va="va" value="${ inspectionPos[1].sopipclosevaod}" class="text_input" size="4">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="11%" bgcolor="#E1EBFD" class="PrivateBorderBlue">OS</TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="9" needChange="needChange" sph="sph" name="inspectionPos[1].sopipballglassos" value="${inspectionPos[1].sopipballglassos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="10" needChange="needChange" cyl="cyl" name="inspectionPos[1].sopippostglassos" value="${inspectionPos[1].sopippostglassos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input  jjorder="11" name="inspectionPos[1].sopipaxesos" axes="axes" value="${inspectionPos[1].sopipaxesos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="12" needChange="needChange" onblur="if(parseFloat(this.value)<0&&this.value!=''){alert('下加光不能为负!');this.value='';this.focus()}" name="inspectionPos[1].sopipaddos" sph="sph" value="${inspectionPos[1].sopipaddos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="13" name="inspectionPos[1].sopiparriseglassos1" ljxj="ljxj" value="${inspectionPos[1].sopiparriseglassos1 }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <select jjorder="14" id="sopipbasisos1n" name="inspectionPos[1].sopipbasisos1">
                                            <option value="" selected="selected">----请选择----</option>
                                            <option value="内">内</option>
											<option value="外">外</option>
											<option value="上">上</option>
											<option value="下">下</option>
                                          </select>
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input name="inspectionPos[1].sopipinterhighos" tongju="tongju" value="${inspectionPos[1].sopipinterhighos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="15" name="inspectionPos[1].sopipinterdistanceos" tongju="tongju" value="${inspectionPos[1].sopipinterdistanceos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input name="inspectionPos[1].sopipfarvaos" va="va" value="${inspectionPos[1].sopipfarvaos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">
                                          <input jjorder="16" name="inspectionPos[1].sopipclosevaos" va="va" value="${inspectionPos[1].sopipclosevaos }" class="text_input" size="4">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="7" bgcolor="#E1EBFD" class="PrivateBorderBlue"><li class="horizontal">
                                          <div align="center">适用镜片：
                                            <INPUT name="inspectionPos[1].sopipcommendglasses"  id="cc1.commendglasses2" size="12" readOnly>
                                          </div>
                                      </li>
                                          <li class="horizontal">
                                            <div align="center">
                                              <INPUT name="button2" type="button" icon="icon-search" onclick="syjp(2,3)" value="选 择">
                                            </div>
                                          </li>
                                        <li class="horizontal">
                                            <div align="center">
                                              <INPUT name="button2" type="button" icon="icon-delete" onclick="clearSyjp(1)" value="清 除">
                                            </div>
                                      </li></TD>
                                      <TD colspan="4" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="center">中距离：
                                        <INPUT type="checkbox" value="1" ${inspectionPos[1].sopipmiddledistance=='1'?'checked':''} name="inspectionPos[1].sopipmiddledistance">
                                        建议镜框：
                                        <SELECT name="inspectionPos[1].sopipsuggestframe">
                                          <OPTION value="" selected> </OPTION>
                                          <OPTION value="打孔">打孔</OPTION>
                                          <OPTION value="拉丝">拉丝</OPTION>
                                          <OPTION value="板材">板材</OPTION>
                                          <OPTION value="框高">框高</OPTION>
                                        </SELECT>
                                        <INPUT name="inspectionPos[1].sopipframeheight" value="${inspectionPos[1].sopipframeheight }" size="12">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="2" bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="right">建议镜片材质： </div></TD>
                                      <TD colspan="2" bgcolor="#E1EBFD" class="PrivateBorderBlue"><SELECT id="sopipglassmaterialn" name="inspectionPos[1].sopipglassmaterial">
                                          <OPTION value="" selected>请选择建议镜片材质</OPTION>
                                          <OPTION value="老花渐进">老花渐进</OPTION>
                                          <OPTION value="青少年渐进">青少年渐进</OPTION>
                                          <OPTION value="非球面树脂">非球面树脂</OPTION>
                                          <OPTION value="抗辐射镜片">抗辐射镜片</OPTION>
                                          <OPTION value="染色镜片">染色镜片</OPTION>
                                          <OPTION value="变色镜片">变色镜片</OPTION>
                                          <OPTION value="普通树脂">普通树脂</OPTION>
                                          <OPTION value="高折玻璃">高折玻璃</OPTION>
                                          <OPTION value="玻璃片">玻璃片</OPTION>
                                          <OPTION value="树脂偏光镜片（茶/灰）">树脂偏光镜片（茶/灰）</OPTION>
                                          <OPTION value="树脂抗疲劳镜片">树脂抗疲劳镜片</OPTION>
                                          <OPTION></OPTION>
                                        </SELECT>                                      </TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="right">处理方式： </div></TD>
                                      <TD colspan="2" bgcolor="#E1EBFD" class="PrivateBorderBlue"><select id="sopipdisposemannern" name="inspectionPos[1].sopipdisposemanner">
                                          <option value="" selected>----请选择----</option>
                                          <option value="足矫">足矫</option>
                                          <option value="欠矫">欠矫</option>
                                          <option value="过矫">过矫</option>
                                          <option value="附加棱镜">附加棱镜</option>
                                          <option value="调整">调整</option>
                                          <option value="平衡">平衡</option>
                                          <option value="医嘱">医嘱</option>
                                          <option value="全矫">全矫</option>
                                          <option value="患者要求减度">患者要求减度</option>
                                        </select>
                                      </TD>
                                      <TD bgcolor="#E1EBFD" class="PrivateBorderBlue"><div align="right">备注： </div></TD>
                                      <TD colspan="3" bgcolor="#E1EBFD" class="PrivateBorderBlue"><textarea name="inspectionPos[1].sopipdignosisre">${inspectionPos[1].sopipdignosisre }</textarea></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable" id="jj">
                                  <TR>
                                    <TD colspan="11" style="height:20px" class="PrivateBorderYellow" bgcolor="#FBF3BD">框架--双光/渐进</TD>
                                  </TR>
                                  <TR>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow">&nbsp;</TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">球镜</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">柱镜</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">轴向</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">Add</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">三棱镜</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">基底</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">远用瞳距(mm)</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">近用瞳距(mm)</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">远用VA</div></TD>
                                    <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">近用VA</div></TD>
                                  </TR>
                                  <TBODY>
                                    <TR>
                                      <TD width="11%" bgcolor="#FBF3BD" class="PrivateBorderYellow">OD</TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="1" needChange="needChange" sph="sph" name="inspectionPos[2].sopipballglassod" value="${inspectionPos[2].sopipballglassod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="2" needChange="needChange" cyl="cyl" name="inspectionPos[2].sopippostglassod" value="${inspectionPos[2].sopippostglassod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="3" name="inspectionPos[2].sopipaxesod" axes="axes" value="${inspectionPos[2].sopipaxesod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="4" needChange="needChange" onblur="if(parseFloat(this.value)<0&&this.value!=''){alert('下加光不能为负!');this.value='';this.focus()}" name="inspectionPos[2].sopipaddod" sph="sph" value="${inspectionPos[2].sopipaddod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="5" name="inspectionPos[2].sopiparriseglassod1" ljxj="ljxj" value="${inspectionPos[2].sopiparriseglassod1 }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="6%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <select jjsgorder="6" id="sopipbasisod1j" name="inspectionPos[2].sopipbasisod1">
                                             <option value="" selected="selected">----请选择----</option>
                                            <option value="内">内</option>
											<option value="外">外</option>
											<option value="上">上</option>
											<option value="下">下</option>
                                          </select>
                                      </div></TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="7" name="inspectionPos[2].sopipinterhighod" tongju="tongju" value="${inspectionPos[2].sopipinterhighod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="8" name="inspectionPos[2].sopipinterdistanceod" tongju="tongju"  value="${inspectionPos[2].sopipinterdistanceod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="9" name="inspectionPos[2].sopipfarvaod" va="va"  value="${inspectionPos[2].sopipfarvaod }" class="text_input" size="4">
                                      </div></TD>
                                      <TD width="8%" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="10" name="inspectionPos[2].sopipclosevaod" va="va" value="${inspectionPos[2].sopipclosevaod }" class="text_input" size="4">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD width="11%" bgcolor="#FBF3BD" class="PrivateBorderYellow">OS</TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="11" needChange="needChange" sph="sph" name="inspectionPos[2].sopipballglassos" value="${inspectionPos[2].sopipballglassos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="12" needChange="needChange" cyl="cyl" name="inspectionPos[2].sopippostglassos" value="${inspectionPos[2].sopippostglassos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="13" name="inspectionPos[2].sopipaxesos" axes="axes" value="${inspectionPos[2].sopipaxesos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="14" needChange="needChange" onblur="if(parseFloat(this.value)<0&&this.value!=''){alert('下加光不能为负!');this.value='';this.focus()}"   name="inspectionPos[2].sopipaddos" sph="sph"  value="${inspectionPos[2].sopipaddos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="15" name="inspectionPos[2].sopiparriseglassos1" ljxj="ljxj" value="${inspectionPos[2].sopiparriseglassos1 }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <select jjsgorder="16" id="sopipbasisos1j" name="inspectionPos[2].sopipbasisos1">
                                            <option value="" selected="selected">----请选择----</option>
                                            <option value="内">内</option>
											<option value="外">外</option>
											<option value="上">上</option>
											<option value="下">下</option>
                                          </select>
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="17" name="inspectionPos[2].sopipinterhighos" tongju="tongju" value="${inspectionPos[2].sopipinterhighos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="18" name="inspectionPos[2].sopipinterdistanceos" tongju="tongju" value="${inspectionPos[2].sopipinterdistanceos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="19" name="inspectionPos[2].sopipfarvaos"  va="va" value="${inspectionPos[2].sopipfarvaos }" class="text_input" size="4">
                                      </div></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">
                                          <input jjsgorder="20" name="inspectionPos[2].sopipclosevaos" va="va" value="${inspectionPos[2].sopipclosevaos }" class="text_input" size="4">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="7" bgcolor="#FBF3BD" class="PrivateBorderYellow">
									  <div align="center">
									  <li class="horizontal">
                                          适用镜片：
                                            <INPUT name="inspectionPos[2].sopipcommendglasses" value="${inspectionPos[2].sopipcommendglasses }" id="cc1.commendglasses22" size="12" readOnly>
                                      </li>
                                          <li class="horizontal">
                                              <INPUT name="button23" type="button" onclick="syjp(3,3)" icon="icon-search"  value="选 择">
                                          </li>
                                        <li class="horizontal">
                                              <INPUT name="button23" type="button" onclick="clearSyjp(2)" icon="icon-delete" value="清 除">
                                      </li></div></TD>
                                      <TD colspan="4" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="center">中距离：
                                        <INPUT type="checkbox" value="1" ${inspectionPos[2].sopipmiddledistance=='1'?'checked':''} name="inspectionPos[2].sopipmiddledistance">
                                        建议镜框：
                                        <SELECT name="inspectionPos[2].sopipsuggestframe">
                                          <OPTION value="" selected> </OPTION>
                                          <OPTION value="打孔">打孔</OPTION>
                                          <OPTION value="拉丝">拉丝</OPTION>
                                          <OPTION value="板材">板材</OPTION>
                                          <OPTION value="框高">框高</OPTION>
                                        </SELECT>
                                        <INPUT name="inspectionPos[2].sopipframeheight" value="${inspectionPos[2].sopipframeheight }" size="12">
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD colspan="2" bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="right">建议镜片材质： </div></TD>
                                      <TD colspan="2" bgcolor="#FBF3BD" class="PrivateBorderYellow"><SELECT id="sopipglassmaterialj" name="inspectionPos[2].sopipglassmaterial">
                                          <OPTION value="" selected>请选择建议镜片材质</OPTION>
                                          <OPTION value="老花渐进">老花渐进</OPTION>
                                          <OPTION value="青少年渐进">青少年渐进</OPTION>
                                          <OPTION value="非球面树脂">非球面树脂</OPTION>
                                          <OPTION value="抗辐射镜片">抗辐射镜片</OPTION>
                                          <OPTION value="染色镜片">染色镜片</OPTION>
                                          <OPTION value="变色镜片">变色镜片</OPTION>
                                          <OPTION value="普通树脂">普通树脂</OPTION>
                                          <OPTION value="高折玻璃">高折玻璃</OPTION>
                                          <OPTION value="玻璃片">玻璃片</OPTION>
                                          <OPTION value="树脂偏光镜片（茶/灰）">树脂偏光镜片（茶/灰）</OPTION>
                                          <OPTION value="树脂抗疲劳镜片">树脂抗疲劳镜片</OPTION>
                                          <OPTION></OPTION>
                                        </SELECT>                                     </TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="right">处理方式： </div></TD>
                                      <TD colspan="2" bgcolor="#FBF3BD" class="PrivateBorderYellow"><select id="sopipdisposemannerj" name="inspectionPos[2].sopipdisposemanner">
                                        <option value="" selected>请选择处理方式</option>
                                        <option value="足矫">足矫</option>
                                        <option value="欠矫">欠矫</option>
                                        <option value="过矫">过矫</option>
                                        <option value="附加棱镜">附加棱镜</option>
                                        <option value="调整">调整</option>
                                        <option value="平衡">平衡</option>
                                        <option value="医嘱">医嘱</option>
                                        <option value="全矫">全矫</option>
                                        <option value="患者要求减度">患者要求减度</option>
                                      </select></TD>
                                      <TD bgcolor="#FBF3BD" class="PrivateBorderYellow"><div align="right">备注： </div></TD>
                                      <TD colspan="3" bgcolor="#FBF3BD" class="PrivateBorderYellow"><textarea name="inspectionPos[2].sopipdignosisre">${inspectionPos[2].sopipdignosisre }</textarea></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable" id="yx">
                                  <TR>
                                    <TD colspan="11" style="height:20px" class="PrivateBorderPink" bgcolor="#F8E0F0">隐形</TD>
                                  </TR>
                                  <TR>
                                    <TD width="3%" bgcolor="#F8E0F0" class="PrivateBorderPink">&nbsp;</TD>
                                    <TD width="5%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">球镜</div></TD>
                                    <TD width="5%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">柱镜</div></TD>
                                    <TD width="5%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">轴向</div></TD>
                                    <TD width="5%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">曲率1</div></TD>
                                    <TD width="5%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">曲率2</div></TD>
                                    <TD width="5%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">直径</div></TD>
                                    <TD width="6%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">隐形VA</div></TD>
                                    <TD width="44%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">隐形镜片</div></TD>
                                    <TD width="6%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">片/盒数</div></TD>
                                    <TD width="11%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">隐形处理方式</div></TD>
                                  </TR>
                                  <TR>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink">OD</TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input needChange="needChange" sph="sph" name="inspectionPos[3].sopipballglassod" value="${inspectionPos[3].sopipballglassod }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input needChange="needChange" cyl="cyl" name="inspectionPos[3].sopippostglassod" value="${inspectionPos[3].sopippostglassod }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipaxesod" axes="axes" value="${inspectionPos[3].sopipaxesod }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipeyecurvatureod1"  value="${inspectionPos[3].sopipeyecurvatureod1 }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipeyecurvatureod2" value="${inspectionPos[3].sopipeyecurvatureod2 }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipdiameterod" value="${inspectionPos[3].sopipdiameterod }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipconlenvaod" value="${inspectionPos[3].sopipconlenvaod }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <li class="horizontal"> 适用镜片：
                                          <INPUT name="inspectionPos[3].sopipcommendglasses"   id="cc1.commendglasses22" size="8" readOnly>
                                        </li>
                                      <li class="horizontal">
                                          <INPUT name="button23" type="button" onclick="queryInvisibilityEyeglass(4,4)" icon="icon-search"  value="选 择">
                                        </li>
                                      <li class="horizontal">
                                          <INPUT name="button23" type="button" onclick="clearSyjp(3)" icon="icon-delete" value="清 除">
                                        </li>
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipconlenodnum" value="${inspectionPos[3].sopipconlenodnum }" class="text_input" size="1">
                                    </div></TD>
                                    <TD rowspan="2" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <div align="center">
                                          <select id="sopipconrecipetype" name="inspectionPos[3].sopipconrecipetype">
                                            <option value="" selected="selected">请选择隐形处理方式</option>
                                            <option value="足矫">足矫</option>
											<option value="欠矫">欠矫</option>
											<option value="过矫">过矫</option>
                                          </select>
                                        </div>
                                    </div></TD>
                                  </TR>
                                  <TR>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink">OS</TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input needChange="needChange" sph="sph" name="inspectionPos[3].sopipballglassos" value="${inspectionPos[3].sopipballglassos }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input needChange="needChange" cyl="cyl" name="inspectionPos[3].sopippostglassos"  value="${inspectionPos[3].sopippostglassos }"class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipaxesos" axes="axes" value="${inspectionPos[3].sopipaxesos }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipeyecurvatureos1" value="${ inspectionPos[3].sopipeyecurvatureos1}" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipeyecurvatureos2" value="${inspectionPos[3].sopipeyecurvatureos2 }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipdiameteros" value="${inspectionPos[3].sopipdiameteros }" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipconlenvaos" value="${ inspectionPos[3].sopipconlenvaos}" class="text_input" size="2">
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <li class="horizontal"> 适用镜片：
                                          <INPUT name="inspectionPos[3].sopipcommendglasses"  id="cc1.commendglasses22" size="8" readOnly>
                                        </li>
                                      <li class="horizontal">
                                          <INPUT name="button23" type="button" onclick="queryInvisibilityEyeglass(5,4)" icon="icon-search"  value="选 择">
                                        </li>
                                      <li class="horizontal">
                                          <INPUT name="button23" type="button" icon="icon-delete" onclick="clearSyjp(4)" value="清 除">
                                        </li>
                                    </div></TD>
                                    <TD bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
                                        <input name="inspectionPos[3].sopipconlenosnum" value="${inspectionPos[3].sopipconlenosnum }" class="text_input" size="1">
                                    </div></TD>
                                  </TR>
                                  <TBODY>

                                    <TR>
                                      <TD colspan="2" bgcolor="#F8E0F0" class="PrivateBorderPink">护理液品种:</TD>
                                      <TD colspan="9" bgcolor="#F8E0F0" class="PrivateBorderPink">
                                        <div align="left">
  <textarea name="inspectionPos[3].sopipcommendcardwater" id="sopipcommendcardwater">${inspectionPos[3].sopipcommendcardwater }</textarea>
  <INPUT name="button23" type="button" icon="icon-search" onclick="jyhly()"  value="选 择">
  <INPUT name="button23" type="button" icon="icon-delete" value="清 除" onclick="clearOption()">
                                        </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						    <br>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorderBlue" id="fz">
                                  <TBODY>

                                    <TR>
                                      <TD height="30" bgcolor="#E8F8FF"><div align="center" class="PrivateBorder">复诊时间：
                                          <SELECT id="sopipseccheckdate" name="inspectionPo.sopipseccheckdate">
                                            <OPTION value=""> </OPTION>
                                            <OPTION value="1">1</OPTION>
                                            <OPTION value="2">2</OPTION>
                                            <OPTION value="3">3</OPTION>
                                            <OPTION value="4">4</OPTION>
                                            <OPTION value="5">5</OPTION>
                                            <OPTION value="6">6</OPTION>
                                            <OPTION value="7">7</OPTION>
                                            <OPTION value="8">8</OPTION>
                                            <OPTION value="9">9</OPTION>
                                            <OPTION value="10">10</OPTION>
                                            <OPTION value="11">11</OPTION>
                                            <OPTION value="12">12</OPTION>
                                          </SELECT>
                                          <SELECT id="sopipsubvisitunit" name="inspectionPo.sopipsubvisitunit">
                                            <OPTION value=""> </OPTION>
                                            <OPTION value="周">周</OPTION>
                                            <OPTION value="月">月</OPTION>
                                            <OPTION value="年">年</OPTION>
                                          </SELECT>
后 </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						</fieldset>	
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">
                              <input icon='icon-save' type='button' value="保存" onclick="save()">
                              &nbsp;&nbsp;
                              <input icon='icon-reset' type='button' value="重置" >
                              </div></TD></TR>
                      </TBODY>
                    </TABLE>		
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>