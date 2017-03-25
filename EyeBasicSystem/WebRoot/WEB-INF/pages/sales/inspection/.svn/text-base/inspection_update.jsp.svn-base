<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script type='text/javascript' src='${ctx }/js/module/autocomplete1.js'></script>
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
	var re2 = /^[0-9]{1}([.]{1}[0-9]{1,2})(\+|-)?$/;
	
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
	
	//验证视力
	function checkVA(obj) {
		if (obj.value == null || obj.value == '') {
			return;
		}
		/*if (!(re2.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
		} else {
			vaAddZero(obj);
		}*/
	}
	function syjp(glassType,goodscategoryID){ //适用镜片开窗
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWindowInspectionNormalOpen.action?glassType="+glassType+"&goodscategoryID="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWindowInspectionNormalOpen.action?glassType="+glassType+"&goodscategoryID="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【适用镜片查询】";
	}
	function openGoodSingleValues(json){   //适用镜片回调赋值
		$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopipcommendglasses]')[Subtr(1,json.side)].value=json.brandName;
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
	//回车事件
	function EnterDown(thisnum){
		if(event.keyCode == 13){
			var i = thisnum.enter.substr(5);
			i=++i;
			$("\"[enter=enter"+i+"]\"").focus();
			$("\"[enter=enter"+i+"]\"").select();//选中
		}
	}
	function clearSyjp(obj){
		$(obj).parent().parent().parent().find("input[id=sopipcommendglasses]").val('');
	}

	function clearSyjpod(glassType){
		$('input[syjpod='+glassType+']').val('');
	}

	function clearSyjpos(glassType){
		$('input[syjpos='+glassType+']').val('');
	}
	//验证球镜
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
	//验证柱径
	function checkDataz(obj) {
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
	//轴向
	var rez = /^-?\d+$/;
	
	//验证轴向
	function checkAxiss(obj) {
		var axis = parseInt(obj.value).toFixed(0);
		if (obj.value == null || obj.value == '') {
			return;
		}
		
		if (!(rez.test(obj.value))) {
			alert("请输入正确格式！");
			obj.select();
			return;
		} 

		if (isNaN(obj.value)||axis>360||axis<-180) {
			alert("输入错误！");
			obj.select();
			return;
		}
		
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
		/*var yy = document.all.yy;
		var jy = document.all.jy;
		var jj = document.all.jj;
		var yx = document.all.yx;
		
		yy.style.display = 'none';
		jy.style.display = 'none';
		jj.style.display = 'none';
		yx.style.display = 'none';*/
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
	}
	function cleanTableAll(){
	}
	function save(){
		var isSubmit = 1;
		var sopiparriseglassod1 = new Array();
	
		$('[name*=.sopiparriseglassod1]').each(function (i){
			sopiparriseglassod1[i] = $(this).val();
		});
		
		$('[name*=.sopipbasisod1]').each(function (i){
			if($(this).val()==''&&sopiparriseglassod1[i]!=''){
				alert('双眼平衡结果右眼基底不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
			
		if(isSubmit == 0){
			return false;
		}
		
		var sopiparriseglassos1 = new Array();
	
		$('[name*=.sopiparriseglassod1]').each(function (i){
			sopiparriseglassos1[i] = $(this).val();
		});
		
		
		$('[name*=.sopipbasisos1]').each(function (i){
			if($(this).val()==''&&sopiparriseglassos1[i]!=''){
				alert('双眼平衡结果左眼基底不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		var sopipbasisod1 = new Array();
	
		$('[name*=.sopipbasisod1]').each(function (i){
			sopipbasisod1[i] = $(this).val();
		});
		
		
		$('[name*=.sopiparriseglassod1]').each(function (i){
			if($(this).val()==''&&sopipbasisod1[i]!=''){
				alert('双眼平衡结果右眼三棱镜不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		var sopipbasisos1 = new Array();
	
		$('[name*=.sopipbasisos1]').each(function (i){
			sopipbasisos1[i] = $(this).val();
		});
		
		
		$('[name*=.sopiparriseglassos1]').each(function (i){
			if($(this).val()==''&&sopipbasisos1[i]!=''){
				alert('双眼平衡结果左眼三棱镜不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		$('[name*=.sopipballglassod]').each(function (){
			if($(this).val()==''){
				alert('右眼球镜不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		$('[name*=.sopipballglassos]').each(function (){
			if($(this).val()==''){
				alert('左眼球镜不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		var axeindex = 0;
		var axetype = '';
		$("[axes=axes]").each(function (){
			if(parseFloat($(this).parent().parent().parent().find('[cyl=cyl]').eq(0).val()) != 0 && $(this).parent().parent().parent().find('[cyl=cyl]').eq(0).val()){
				if(!$(this).val()){
					axetype = '1';
					return false;
				}
			}
			axeindex = axeindex + 1;
		});
		
		if(axetype == '1'){
			alert("请填写轴向！");
			$("[axes=axes]").eq(axeindex).focus();
			return;
		}
		
		$('[name*=.sopipinterhighod]').each(function (){
			if($(this).val()==''){
				alert('右眼远用瞳距不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		$('[name*=.sopipinterhighos]').each(function (){
			if($(this).val()==''){
				alert('左眼远用瞳距不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		$('[name*=.sopipinterdistanceod]').each(function (){
			if($(this).val()==''){
				alert('右眼近用瞳距不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		$('[name*=.sopipinterdistanceos]').each(function (){
			if($(this).val()==''){
				alert('左眼近用瞳距不能为空!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		$('[name*=.sopipconlenodnum]').each(function (){
			if(isNaN($(this).val())){
				alert('右眼隐形适用镜片数只能为数字!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		$('[name*=.sopipconlenosnum]').each(function (){
			if(isNaN($(this).val())){
				alert('左眼隐形适用镜片数只能为数字!');
				$(this).focus();
				isSubmit = 0;
				return false;
			}
		});
		
		if(isSubmit == 0){
			return false;
		}
		
		$('input[cyl=cyl]').each(function(){
			if($(this).val()==''){
				$(this).val('0.00');
			}
		});
		
		if(isSubmit == 0){
			return false;
		}else{
			inspectionForm.action="inspectionUpdate.action?ruleFlag=0&nw='N' ";
			$("img").removeAttr("onclick");
			inspectionForm.submit();
		}
	}
	
	//嵌入页查找按钮锁死sxh
	function searchButton(){
		var customerID = document.all.customerID.value;
		if(customerID != null){
			document.getElementById('searchbutton').disabled = 'disabled';
		}
	}
	$(document).ready(function(){
		//页面所有下拉列表默认选中
		searchButton();
		$('#glassType').attr('value','${glassType}');
		displayTable2('${glassType}');
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
		
		displayTable('');
		checkCylZero();
	});
	function refractive(){
		inspectionForm.action="refractiveTool.action?source=refractiveiou";//refractiveTool.action?source=refractiveiou
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	function doubleEyeFun(){
		inspectionForm.action="doubleEyeFunTool.action?source=doubleeyefuniou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	function specialCheck(){
		inspectionForm.action="specialCheckTool.action?source=specialcheckiou";
		if('$(oldOptometryID)'!=''){
			inspectionForm.action="specialCheckTool.action?source=specialcheckcopy";
		}
		$("img").removeAttr("onclick");
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
	/*
	建议护理液
	*/
	function addOption(json){
		if(json.glassType!=''){
			$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopipcommendglasses]')[0].value=json.goodsName;
		}else{
			$('#sopipcommendcardwater').html(($('#sopipcommendcardwater').text()+';'+json.goodsName).substring(0,1)==';'?($('#sopipcommendcardwater').text()+';'+json.goodsName).substring(1):($('#sopipcommendcardwater').text()+';'+json.goodsName));
		}		
	}
	function clearOption(){
		$('#sopipcommendcardwater').text('');
	}
	function jyhly(){ //建议护理液开窗
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWindowInspectionStealOpen.action?categoryID_open=5",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWindowInspectionStealOpen.action?categoryID_open=5",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【护理液查询】";
	}
	function queryInvisibilityEyeglass(side,glassType,goodsCategoryID,xzindex){
	    //OD:球镜
	    var sopipballglassod = null;
	    //OD:柱镜
	    var sopipballglassod = null;
	    //OS:球镜
	    var sopipballglassos = null;
	    //OS:柱镜
	    var sopippostglassos = null;
	  
		if (side == '1'){
	        sopipballglassod = $('input[name=inspectionPos['+Subtr(1,glassType)+'].sopipballglassod]')[0].value;
	        sopippostglassod = $('input[name=inspectionPos['+Subtr(1,glassType)+'].sopippostglassod]')[0].value;
	        if (sopippostglassod == ""){
	            sopippostglassod = 0;
	        }
	        
	        var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initWindowInspectionOtherOpen.action?categoryID_open=4&glassType="+glassType+"&goodscategoryID="+goodsCategoryID+"&sopipballglass="+sopipballglassod+"&sopippostglass="+sopippostglassod+"&xzindex="+xzindex+"&side="+side,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initWindowInspectionOtherOpen.action?categoryID_open=4&glassType="+glassType+"&goodscategoryID="+goodsCategoryID+"&sopipballglass="+sopipballglassod+"&sopippostglass="+sopippostglassod+"&xzindex="+xzindex+"&side="+side,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【隐形适用镜片查询】";
	    }else if (side == '2'){
	       	sopipballglassos = $('input[name=inspectionPos['+Subtr(1,glassType)+'].sopipballglassos]')[0].value;
	        sopippostglassos = $('input[name=inspectionPos['+Subtr(1,glassType)+'].sopippostglassos]')[0].value;
	        if (sopippostglassos == ""){
	            sopippostglassos = 0;
	        }
	        
	        var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initWindowInspectionOtherOpen.action?categoryID_open=4&glassType="+glassType+"&goodscategoryID="+goodsCategoryID+"&sopipballglass="+sopipballglassos+"&sopippostglass="+sopippostglassos+"&xzindex="+xzindex+"&side="+side,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initWindowInspectionOtherOpen.action?categoryID_open=4&glassType="+glassType+"&goodscategoryID="+goodsCategoryID+"&sopipballglass="+sopipballglassos+"&sopippostglass="+sopippostglassos+"&xzindex="+xzindex+"&side="+side,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【隐形适用镜片查询】";
	    }
	}
	
	function refractive(){
		inspectionForm.action="refractiveTool.action?source=refractiveiou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
  
  //远用球径，柱径，轴向赋值
	var yqjod;
	var yzjod;
	var yzxod;
	var yadod;
	var yqjos;
	var yzjos;
	var yzxos;
	var yados;
	function inspectionOnload(){
		yqjod=document.all.ballOD.value;
		yzjod=document.all.glassOD.value;
		yzxod=document.all.axesOD.value;
		yadod=document.all.sadOD.value;
		yqjos=document.all.ballOS.value;
		yzjos=document.all.glassOS.value;
		yzxos=document.all.axesOS.value;
		yados=document.all.sadOS.value;
		//alert(allTrafficCount);
		for(var i = 0;i<Subtr(1,allTrafficCount);i++){
			if(yzjod!=""&&yzjod!=null){
				if(yzjod>0){
				 	if(yqjod.substring(0,1)=='+'){
				   		yqjod=yqjod.substring(1);
					}
				 	if(yzjod.substring(0,1)=='+'){
				  		yzjod=yzjod.substring(1);
				 	}
				 	yqjod=parseFloat(yqjod)+parseFloat(yzjod);
					if((yqjod)>0){
						yqjod="+"+yqjod;
						yzjod="-"+yzjod;
						
						
						$('[name*=sopipballglassod]').val(addZeroC(yqjod));
						$('[name*=sopippostglassod]').val(addZeroC(yzjod));
						
						if(yadod != '' && yadod != null){
							if(addZeroC(parseFloat(yqjod)+parseFloat(yadod)) > 0){
								$('[name*=sopipballglassod][jy=jy]').val("+"+addZeroC(parseFloat(yqjod)+parseFloat(yadod)));
							}else{
								$('[name*=sopipballglassod][jy=jy]').val(addZeroC(parseFloat(yqjod)+parseFloat(yadod)));
							}
						}
					}else if(yqjod==0){
						yzjod="-"+yzjod;
						$('[name*=sopipballglassod]').val(addZeroC(yqjod));
						$('[name*=sopippostglassod]').val(addZeroC(yzjod));
						if(yadod != '' && yadod != null){
							if(addZeroC(parseFloat(yqjod)+parseFloat(yadod)) > 0){
								$('[name*=sopipballglassod][jy=jy]').val("+"+addZeroC(parseFloat(yqjod)+parseFloat(yadod)));
							}else{
								$('[name*=sopipballglassod][jy=jy]').val(addZeroC(parseFloat(yqjod)+parseFloat(yadod)));
							}
						}
					}else if(yqjod<0){
						yzjod="-"+yzjod;
						$('[name*=sopipballglassod]').val(addZeroC(yqjod));
						$('[name*=sopippostglassod]').val(addZeroC(yzjod));
						if(yadod != '' && yadod != null){
							if(addZeroC(parseFloat(yqjod)+parseFloat(yadod)) > 0){
								$('[name*=sopipballglassod][jy=jy]').val("+"+addZeroC(parseFloat(yqjod)+parseFloat(yadod)));
							}else{
								$('[name*=sopipballglassod][jy=jy]').val(addZeroC(parseFloat(yqjod)+parseFloat(yadod)));
							}
						}
					}
					if(parseInt(yzxod)>90){
						$('[name*=sopipaxesod]').val(parseInt(yzxod)-90);
						yzxod = parseInt(yzxod)-90;
					}else if(parseInt(yzxod)<=90){
						$('[name*=sopipaxesod]').val(parseInt(yzxod)+90);
						yzxod = parseInt(yzxod)+90;
					}
				}else if(yzjod<=0){
					$('[name*=sopipballglassod]').val(addZeroC(yqjod));
					$('[name*=sopippostglassod]').val(addZeroC(yzjod));
					
					if(addZeroC(parseFloat(yqjod)+parseFloat(yadod)) > 0){
						if(yadod != '' && yadod != null){
							$('[name*=sopipballglassod][jy=jy]').val("+"+addZeroC(parseFloat(yqjod)+parseFloat(yadod)));
						}
					}else{
						if(yadod != '' && yadod != null){
							$('[name*=sopipballglassod][jy=jy]').val(addZeroC(parseFloat(yqjod)+parseFloat(yadod)));
						}
					}
					
					
					$('[name*=sopipaxesod]').val(yzxod);
		
				}
			
				if(yzjos>0){
					 if(yqjos.substring(0,1)=='+'){
					  	yqjos=yqjos.substring(1);
					 }
				
					if(yzjos.substring(0,1)=='+'){
					   yzjos=yzjos.substring(1);
					}
				 
					yqjos=parseFloat(yqjos)+parseFloat(yzjos);
					if(yqjos>0){
						yqjos="+"+yqjos;
						yzjos="-"+yzjos;
						$('[name*=sopipballglassos]').val(addZeroC(yqjos));
						$('[name*=sopippostglassos]').val(addZeroC(yzjos));
						if(yados != '' && yados != null){
							if(addZeroC(parseFloat(yqjos)+parseFloat(yados)) > 0){
								$('[name*=sopipballglassos][jy=jy]').val("+"+addZeroC(parseFloat(yqjos)+parseFloat(yados)));
							}else{
								$('[name*=sopipballglassos][jy=jy]').val(addZeroC(parseFloat(yqjos)+parseFloat(yados)));
							}
						}
					}else if(yqjos==0){
						yzjos="-"+yzjos;
						$('[name*=sopipballglassos]').val(addZeroC(yqjos));
						$('[name*=sopippostglassos]').val(addZeroC(yzjos));		
						if(yados != '' && yados != null){
							if(addZeroC(parseFloat(yqjos)+parseFloat(yados)) > 0){
								$('[name*=sopipballglassos][jy=jy]').val("+"+addZeroC(parseFloat(yqjos)+parseFloat(yados)));
							}else{
								$('[name*=sopipballglassos][jy=jy]').val(addZeroC(parseFloat(yqjos)+parseFloat(yados)));
							}
						}	
					}else if(yqjos<0){
						yzjos="-"+yzjos;
						$('[name*=sopipballglassos]').val(addZeroC(yqjos));
						$('[name*=sopippostglassos]').val(addZeroC(yzjos));
						if(yados != '' && yados != null){
							if(addZeroC(parseFloat(yqjos)+parseFloat(yados)) > 0){
								$('[name*=sopipballglassos][jy=jy]').val("+"+addZeroC(parseFloat(yqjos)+parseFloat(yados)));
							}else{
								$('[name*=sopipballglassos][jy=jy]').val(addZeroC(parseFloat(yqjos)+parseFloat(yados)));
							}
						}
					}
					if(parseInt(yzxos)>90){
						$('[name*=sopipaxesos]').val(parseInt(yzxos)-parseInt(90));
						yzxos = parseInt(yzxos)-90;
					}else if(parseInt(yzxos)<=90){
						$('[name*=sopipaxesos]').val(parseInt(yzxos)+parseInt(90));
						yzxos = parseInt(yzxos)+90;
					}
				}else if(yzjos<=0){
					
					$('[name*=sopipballglassos]').val(addZeroC(yqjos));
					$('[name*=sopippostglassos]').val(addZeroC(yzjos));
					
					if(addZeroC(parseFloat(yqjos)+parseFloat(yados))>0){
						if(yados != '' && yados != null){
							$('[name*=sopipballglassos][jy=jy]').val("+"+addZeroC(parseFloat(yqjos)+parseFloat(yados)));
						}
					}else{
						if(yados != '' && yados != null){
							$('[name*=sopipballglassos][jy=jy]').val(addZeroC(parseFloat(yqjos)+parseFloat(yados)));
						}
					}
					
					$('[name*=sopipaxesos]').val(yzxos);
				}
			}
		}
	}
  
	//传值补零
	function addZeroC(obj) {
	obj=obj+"";
		if (obj.indexOf(".") == -1) {
			obj += ".00";
		} else if (obj.indexOf(".") == obj.length - 2) {
			obj += "0";
		}
		return obj;
	}
  allTrafficCount=1   
  allCount=1  
  var xzindex = 0;
  rowadd = 1;
  enternum = 0;
  function   displayTable(addnew)   //增加一行   
  {   
 	  var myValue = document.getElementById('glassType').value;
      newRow=trafficeList.insertRow(trafficeList.rows.length);   
      newRow.id="tradt";   
      newRow.ln=allTrafficCount;   
         
      c1=newRow.insertCell(0);
      c1.id="tradtRow";
      c1.ln=allCount;
	  var listindex = allTrafficCount;
	  if(addnew=="n"){
	  	  if(myValue == "1"){
         	c1.innerHTML="<tr id="+rowadd+"tr><td><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='1'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='dfffdf'><p>框架--远用&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD>	</TR><TR><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
         									+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用瞳距(mm)</div></TD>"
         									+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
         									+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='1'  sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' class='text_input' size='4' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' class='text_input cyl' size='4' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input   axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' class='text_input axes' size='4' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' value='${refractivePo.soprdbalarriseglassod }' class='text_input' size='4' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'></div></TD><TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${refractivePo.soprdbalbasisod != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${refractivePo.soprdbalbasisod != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${refractivePo.soprdbalbasisod != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${refractivePo.soprdbalbasisod != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
         									+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' value='${refractivePo.soprdbalinterhighod }' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value='' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'></div></TD>"
         									+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' value='${refractivePo.soprpupilheightod }' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4' value='' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'></div></TD>"
         									+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='7' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' class='text_input' size='4' value='${refractivePo.soprdbalvaod }' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'></div></TD></TR><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input ljxj='ljxj' yyorder='11' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${refractivePo.soprdbalbasisos != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${refractivePo.soprdbalbasisos != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${refractivePo.soprdbalbasisos != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${refractivePo.soprdbalbasisos != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
         									+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighos }'></div></TD>"
         									+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightos }'></div></TD>"
         									+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='14' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' class='text_input' size='4' value='${refractivePo.soprdbalvaos }' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'></div></TD></TR><TR><TD colspan='5' bgcolor='#DFFFDF' class='PrivateBorderGreen'></TD><TD colspan='5' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance'>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔'>打孔</OPTION><OPTION value='拉丝'>拉丝</OPTION><OPTION value='板材'>板材</OPTION><OPTION value='框高'>框高</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '' :'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '' :'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂'>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '' :'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '' :'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '' :'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂' ${po.sopipglassmaterial != '普通树脂' ? '' :'selected=selected'}>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '' :'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '' :'selected=selected'}>玻璃片</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '' :'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>处理方式： </div></TD><TD  bgcolor='#DFFFDF' class='PrivateBorderGreen'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫'>足矫</option><option value='欠矫'>欠矫</option><option value='过矫'>过矫</option><option value='附加棱镜'>附加棱镜</option><option value='调整'>调整</option><option value='平衡'>平衡</option><option value='医嘱'>医嘱</option><option value='全矫'>全矫</option><option value='患者要求减度'>患者要求减度</option></select></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>备注:</div></TD><TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR></TBODY></TABLE></td></tr>"
		     					
		  }if(myValue == "2"){
			  
			c1.innerHTML="<tr id="+rowadd+"tr><td><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='2'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jy'><TR><TD colspan='9' style='height:20px' class='PrivateBorderBlue' bgcolor='#E1EBFD'><p>框架--近用&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>&nbsp;</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>球镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>柱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>轴向</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>三棱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>基底</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OD</TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' jy=jy onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='3' axes='axes' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassod }'></div></TD><TD width='6%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><select jjorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${refractivePo.soprdbalbasisod != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${refractivePo.soprdbalbasisod != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${refractivePo.soprdbalbasisod != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${refractivePo.soprdbalbasisod != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterdistanceod }'></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightod }'></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='8' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD></TR><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OS</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='9' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' jy=jy onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='10' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='11' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='13' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassos }'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><select jjorder='14' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${refractivePo.soprdbalbasisos != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${refractivePo.soprdbalbasisos != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${refractivePo.soprdbalbasisos != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${refractivePo.soprdbalbasisos != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterdistanceos }'></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightos }'></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='16' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' class='text_input' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' size='4' value='${refractivePo.soprdbalvaos }'></div></TD></TR><TR><TD colspan='5' bgcolor='#E1EBFD' class='PrivateBorderBlue'></TD><TD colspan='4' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance'>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔'>打孔</OPTION><OPTION value='拉丝'>拉丝</OPTION><OPTION value='板材'>板材</OPTION><OPTION value='框高'>框高</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12'></div></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>建议镜片材质:</div></TD><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进'>老花渐进</OPTION><OPTION value='青少年渐进'>青少年渐进</OPTION><OPTION value='非球面树脂'>非球面树脂</OPTION><OPTION value='抗辐射镜片'>抗辐射镜片</OPTION><OPTION value='染色镜片'>染色镜片</OPTION><OPTION value='变色镜片'>变色镜片</OPTION><OPTION value='普通树脂'>普通树脂</OPTION><OPTION value='高折玻璃'>高折玻璃</OPTION><OPTION value='玻璃片'>玻璃片</OPTION><OPTION value='树脂偏光镜片（茶/灰）'>树脂偏光镜片（茶/灰）</OPTION><OPTION value='树脂抗疲劳镜片'>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>处理方式： </div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫'>足矫</option><option value='欠矫'>欠矫</option><option value='过矫'>过矫</option><option value='附加棱镜'>附加棱镜</option><option value='调整'>调整</option><option value='平衡'>平衡</option><option value='医嘱'>医嘱</option><option value='全矫'>全矫</option><option value='患者要求减度'>患者要求减度</option></select></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>备注： </div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'  colspan=3><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR></TBODY></TABLE></td></tr>";
			
		  }if(myValue == "3"){
			  
			c1.innerHTML="<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='3'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jj'><TR><TD colspan='12' style='height:20px' class='PrivateBorderYellow' bgcolor='#FBF3BD'>框架--双光/渐进&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'></TD></TR><TR><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'>&nbsp;</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>球镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>柱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>轴向</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>Add</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>三棱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>基底</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用VA</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OD</TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD> <TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='4'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassod }'></div></TD><TD width='6%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><select jjsgorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${refractivePo.soprdbalbasisod != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${refractivePo.soprdbalbasisod != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${refractivePo.soprdbalbasisod != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${refractivePo.soprdbalbasisod != '下' ? '' : 'selected=selected' }>下</option></select></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighod }'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterdistanceod }'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightod }'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='9' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='10' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD></TR><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OS</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='11' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='12' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='13' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='14'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='15' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassos }'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><select jjsgorder='16' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${refractivePo.soprdbalbasisos != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${refractivePo.soprdbalbasisos != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${refractivePo.soprdbalbasisos != '上' ? '' : 'selected=selected' }>上</option><option value='下'  ${refractivePo.soprdbalbasisos != '下' ? '' : 'selected=selected' }>下</option></select></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='17' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighos }'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterdistanceos }'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightos }'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='19' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaos }'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='20' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaos }'></div></TD></TR><TR><TD colspan='7' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'></div></TD><TD colspan='5' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance'>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔'>打孔</OPTION><OPTION value='拉丝'>拉丝</OPTION><OPTION value='板材'>板材</OPTION><OPTION value='框高'>框高</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>建议镜片材质： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进'>老花渐进</OPTION><OPTION value='青少年渐进'>青少年渐进</OPTION><OPTION value='非球面树脂'>非球面树脂</OPTION><OPTION value='抗辐射镜片'>抗辐射镜片</OPTION><OPTION value='染色镜片'>染色镜片</OPTION><OPTION value='变色镜片'>变色镜片</OPTION><OPTION value='普通树脂'>普通树脂</OPTION><OPTION value='高折玻璃'>高折玻璃</OPTION><OPTION value='玻璃片'>玻璃片</OPTION><OPTION value='树脂偏光镜片（茶/灰）'>树脂偏光镜片（茶/灰）</OPTION><OPTION value='树脂抗疲劳镜片'>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫'>足矫</option><option value='欠矫'>欠矫</option><option value='过矫'>过矫</option><option value='附加棱镜'>附加棱镜</option><option value='调整'>调整</option><option value='平衡'>平衡</option><option value='医嘱'>医嘱</option><option value='全矫'>全矫</option><option value='患者要求减度'>患者要求减度</option></select></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>备注： </div></TD><TD colspan='4' bgcolor='#FBF3BD' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR></TBODY></TABLE></TD></TR></TABLE></td></tr>";
			
		  }if(myValue == "4"){
			  
			c1.innerHTML="<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='4'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR><TD colspan='11' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>隐形&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(2,this);'></TD></TR><TR><TD width='3%' bgcolor='#F8E0F0' class='PrivateBorderPink'>&nbsp;</TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率1</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率2</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形VA</div></TD><TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>片/盒数</div></TD><TD width='11%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形处理方式</div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' sph='sph' id='sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' cyl='cyl' id='sopippostglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input  name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod2' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${refractivePo.soprdbalvaod }' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='' syjpod='"+allTrafficCount+"' id='sopipcommendglasses' size='8' readOnly></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" name='xzbutton' id='xzbutton' onClick='queryInvisibilityEyeglass(1,"+allTrafficCount+",4,"+xzindex+")' title='选 择'></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearSyjpod("+allTrafficCount+")' title='清 空'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenodnum' value='' class='text_input' size='1'></div></TD><TD rowspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><div align='center'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipconrecipetype'><option value='' selected='selected'>----请选择----</option><option value='足矫'>足矫</option><option value='欠矫'>欠矫</option><option value='过矫'>过矫</option></select></div></div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' sph='sph' id='sopipballglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' cyl='cyl' id='sopippostglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos2' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${refractivePo.soprdbalvaos }' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' id='sopipcommendglasses' size='8' readOnly syjpos='"+allTrafficCount+"'></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" name='xzbutton' id='xzbutton' onClick='queryInvisibilityEyeglass(2,"+allTrafficCount+",4,"+(xzindex+1)+")' title='选 择'></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearSyjpos("+allTrafficCount+")' title='清 空'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenosnum' class='text_input' size='1'></div></TD></TR><TBODY><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'>护理液品种:</TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'><textarea readonly='readonly'  id='sopipcommendcardwater' name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendcardwater'></textarea><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" onClick='jyhly()' title='选 择'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearOption()' title='清 空'></div></TD></TR><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'>备注： </div></TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR></TBODY></TABLE></td></tr></table></TD></TR></TABLE></td></tr>"
			
		  }if(myValue == "5"){
			  
			c1.innerHTML="<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='5'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='zy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='00bbff'><p>框架--中用&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD>	</TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='1' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input   axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassod }'></div></TD><TD width='6%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${refractivePo.soprdbalbasisod != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${refractivePo.soprdbalbasisod != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${refractivePo.soprdbalbasisod != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${refractivePo.soprdbalbasisod != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighod }'></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightod }'></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='7' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddlevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD></TR><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassos }'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${refractivePo.soprdbalbasisos != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${refractivePo.soprdbalbasisos != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${refractivePo.soprdbalbasisos != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${refractivePo.soprdbalbasisos != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighos }'></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightos }'></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddlevaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaos }'></div></TD></TR><TR><TD colspan='6' bgcolor='#00bbff' class='PrivateBorderGreen'></TD><TD colspan='4' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance'>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔'>打孔</OPTION><OPTION value='拉丝'>拉丝</OPTION><OPTION value='板材'>板材</OPTION><OPTION value='框高'>框高</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12'></div></TD></TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进'>老花渐进</OPTION><OPTION value='青少年渐进'>青少年渐进</OPTION><OPTION value='非球面树脂'>非球面树脂</OPTION><OPTION value='抗辐射镜片'>抗辐射镜片</OPTION><OPTION value='染色镜片'>染色镜片</OPTION><OPTION value='变色镜片'>变色镜片</OPTION><OPTION value='普通树脂'>普通树脂</OPTION><OPTION value='高折玻璃'>高折玻璃</OPTION><OPTION value='玻璃片'>玻璃片</OPTION><OPTION value='树脂抗疲劳镜片'>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>处理方式： </div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫'>足矫</option><option value='欠矫'>欠矫</option><option value='过矫'>过矫</option><option value='附加棱镜'>附加棱镜</option><option value='调整'>调整</option><option value='平衡'>平衡</option><option value='医嘱'>医嘱</option><option value='全矫'>全矫</option><option value='患者要求减度'>患者要求减度</option></select></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='left'>备注:</div></TD><TD colspan='3' bgcolor='#00bbff' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR></TBODY></TABLE></td></tr>"
			
		  }
		  if(myValue == "4"){
		  	xzindex = xzindex+2;
		  }else{
			xzindex = xzindex+1;
		  }
		  allTrafficCount++;
		  rowadd++;
	  }else{
		  <c:forEach var="po" items="${inspectionPos}" varStatus="idxStatus">
		  listindex = allTrafficCount;
		  if("${po.sopipglasstype }" == "1"){
		  
	        c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='dfffdf'><p>框架--远用<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='1'/>&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD>	</TR><TR><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用瞳距(mm)</div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='1'  sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value="+"${po.sopipballglassod}"+"></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='"+"${po.sopippostglassod}"+"' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input   axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='"+"${po.sopipaxesod}"+"' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='"+"${po.sopiparriseglassod1}"+"' class='text_input' size='4' value=''></div></TD><TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisod1  != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisod1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisod1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisod1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
	        								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' value='${po.sopipinterhighod}' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD>"
	        								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' value='${po.sopippupilheightod}' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD>"
	        								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='7' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaod  }'></div></TD></TR><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipballglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippostglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos }' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopiparriseglassos1 }' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisos1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisos1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisos1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisos1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighos }'></div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='14' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaos  }'></div></TD></TR><TR><TD colspan='5' bgcolor='#DFFFDF' class='PrivateBorderGreen'></TD><TD colspan='4' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔' ${po.sopipsuggestframe != '打孔' ? '':'selected=selected'}>打孔</OPTION><OPTION value='拉丝' ${po.sopipsuggestframe != '拉丝' ? '':'selected=selected'}>拉丝</OPTION><OPTION value='板材' ${po.sopipsuggestframe != '板材' ? '':'selected=selected'}>板材</OPTION><OPTION value='框高' ${po.sopipsuggestframe != '框高' ? '':'selected=selected'}>框高</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '' :'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '' :'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂' ${po.sopipglassmaterial != '非球面树脂' ? '' :'selected=selected'}>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '' :'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '' :'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '' :'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂' ${po.sopipglassmaterial != '普通树脂' ? '' :'selected=selected'}>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '' :'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '' :'selected=selected'}>玻璃片</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '' :'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>处理方式： </div></TD><TD colspan=2 bgcolor='#DFFFDF' class='PrivateBorderGreen'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫' ${po.sopipdisposemanner != '足矫' ? '' :'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipdisposemanner != '欠矫' ? '' :'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipdisposemanner != '过矫' ? '' :'selected=selected'}>过矫</option><option value='附加棱镜' ${po.sopipdisposemanner != '附加棱镜' ? '' :'selected=selected'}>附加棱镜</option><option value='调整' ${po.sopipdisposemanner != '调整' ? '' :'selected=selected'}>调整</option><option value='平衡' ${po.sopipdisposemanner != '平衡' ? '' :'selected=selected'}>平衡</option><option value='医嘱' ${po.sopipdisposemanner != '医嘱' ? '' :'selected=selected'}>医嘱</option><option value='全矫' ${po.sopipdisposemanner != '全矫' ? '' :'selected=selected'}>全矫</option><option value='患者要求减度' ${po.sopipdisposemanner != '患者要求减度' ? '' :'selected=selected'}>患者要求减度</option></select></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>备注:</div></TD><TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr>"
		     allTrafficCount++;					
		  }if("${po.sopipglasstype }" == "2"){
			  
			c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jy'><TR><TD colspan='9' style='height:20px' class='PrivateBorderBlue' bgcolor='#E1EBFD'><p>框架--近用<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='2'/>&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>&nbsp;</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>球镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>柱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>轴向</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>三棱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>基底</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OD</TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' jy=jy onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassod }' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassod }' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopiparriseglassod1 }'></div></TD><TD width='6%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><select jjorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisod1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisod1  != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisod1  != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisod1  != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterdistanceod }'></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightod }'></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='8' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipclosevaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OS</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='9' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' jy=jy onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='10' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='11' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='13' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopiparriseglassos1 }'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><select jjorder='14' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisos1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisos1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisos1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisos1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterdistanceos }'></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='16' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipclosevaos }'></div></TD></TR><TR><TD colspan='5' bgcolor='#E1EBFD' class='PrivateBorderBlue'></TD><TD colspan='4' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value=''>----请选择----</OPTION><OPTION value='打孔' ${po.sopipsuggestframe != '打孔' ? '':'selected=selected'}>打孔</OPTION><OPTION value='拉丝' ${po.sopipsuggestframe != '拉丝' ? '':'selected=selected'}>拉丝</OPTION><OPTION value='板材' ${po.sopipsuggestframe != '板材' ? '':'selected=selected'}>板材</OPTION><OPTION value='框高' ${po.sopipsuggestframe != '框高' ? '':'selected=selected'}>框高</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>建议镜片材质:</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '' :'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '' :'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂' ${po.sopipglassmaterial != '非球面树脂' ? '' :'selected=selected'}>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '' :'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '' :'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '' :'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂'>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '' :'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '' :'selected=selected'}>玻璃片</OPTION><OPTION value='树脂偏光镜片（茶/灰）' ${po.sopipglassmaterial != '树脂偏光镜片（茶/灰）' ? '' :'selected=selected'}>树脂偏光镜片（茶/灰）</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '' :'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫' ${po.sopipdisposemanner != '足矫' ? '' :'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipdisposemanner != '欠矫' ? '' :'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipdisposemanner != '过矫' ? '' :'selected=selected'}>过矫</option><option value='附加棱镜' ${po.sopipdisposemanner != '附加棱镜' ? '' :'selected=selected'}>附加棱镜</option><option value='调整' ${po.sopipdisposemanner != '调整' ? '' :'selected=selected'}>调整</option><option value='平衡' ${po.sopipdisposemanner != '平衡' ? '' :'selected=selected'}>平衡</option><option value='医嘱' ${po.sopipdisposemanner != '医嘱' ? '' :'selected=selected'}>医嘱</option><option value='全矫' ${po.sopipdisposemanner != '全矫' ? '' :'selected=selected'}>全矫</option><option value='患者要求减度' ${po.sopipdisposemanner != '患者要求减度' ? '' :'selected=selected'}>患者要求减度</option></select></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>备注： </div></TD><TD colspan='3' bgcolor='#E1EBFD' class='PrivateBorderBlue'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr>";
			allTrafficCount++;
		  }if("${po.sopipglasstype }" == "3"){
			  
			c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jj'><TR><TD colspan='12' style='height:20px' class='PrivateBorderYellow' bgcolor='#FBF3BD'>框架--双光/渐进<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='3'/>&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'></TD></TR><TR><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'>&nbsp;</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>球镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>柱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>轴向</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>Add</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>三棱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>基底</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用VA</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OD</TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod'onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesod}' class='text_input' size='4'></div></TD> <TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='4'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaddod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopiparriseglassod1 }'></div></TD><TD width='6%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><select jjsgorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisod1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisod1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisod1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisod1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighod}'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterdistanceod}'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightod}'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='9' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaod}'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='10' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipclosevaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OS</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='11' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='12' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='13' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='14'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaddos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='15' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopiparriseglassos1}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><select jjsgorder='16' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisos1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisos1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisos1 != '上' ? '' : 'selected=selected' }>上</option><option value='下'  ${po.sopipbasisos1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='17' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighos}'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterdistanceos}'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightos}'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='19' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaos}'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='20' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipclosevaos}'></div></TD></TR><TR><TD colspan='7' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'></div></TD><TD colspan='5' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔' ${po.sopipsuggestframe != '打孔' ? '':'selected=selected'}>打孔</OPTION><OPTION value='拉丝' ${po.sopipsuggestframe != '拉丝' ? '':'selected=selected'}>拉丝</OPTION><OPTION value='板材' ${po.sopipsuggestframe != '板材' ? '':'selected=selected'}>板材</OPTION><OPTION value='框高' ${po.sopipsuggestframe != '框高' ? '':'selected=selected'}>框高</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12' value='${po.sopipframeheight}'></div></TD></TR><TR><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>建议镜片材质： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '' :'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '' :'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂' ${po.sopipglassmaterial != '非球面树脂' ? '' :'selected=selected'}>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '' :'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '' :'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '' :'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂' ${po.sopipglassmaterial != '普通树脂' ? '' :'selected=selected'}>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '' :'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '' :'selected=selected'}>玻璃片</OPTION><OPTION value='树脂偏光镜片（茶/灰）' ${po.sopipglassmaterial != '树脂偏光镜片（茶/灰）' ? '' :'selected=selected'}>树脂偏光镜片（茶/灰）</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '' :'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫' ${po.sopipdisposemanner != '足矫' ? '' :'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipdisposemanner != '欠矫' ? '' :'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipdisposemanner != '过矫' ? '' :'selected=selected'}>过矫</option><option value='附加棱镜' ${po.sopipdisposemanner != '附加棱镜' ? '' :'selected=selected'}>附加棱镜</option><option value='调整' ${po.sopipdisposemanner != '调整' ? '' :'selected=selected'}>调整</option><option value='平衡' ${po.sopipdisposemanner != '平衡' ? '' :'selected=selected'}>平衡</option><option value='医嘱' ${po.sopipdisposemanner != '医嘱' ? '' :'selected=selected'}>医嘱</option><option value='全矫' ${po.sopipdisposemanner != '全矫' ? '' :'selected=selected'}>全矫</option><option value='患者要求减度'  ${po.sopipdisposemanner != '患者要求减度' ? '' :'selected=selected'}>患者要求减度</option></select></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>备注： </div></TD><TD colspan='4' bgcolor='#FBF3BD' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></table></tr></td></td></tr>";
			allTrafficCount++;
		  }if("${po.sopipglasstype }" == "4"){
			  
			c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR><TD colspan='11' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>隐形<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='4'/>&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(2,this);'></TD></TR><TR><TD width='3%' bgcolor='#F8E0F0' class='PrivateBorderPink'>&nbsp;</TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率1</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率2</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形VA</div></TD><TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>片/盒数</div></TD><TD width='11%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形处理方式</div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' sph='sph' id='sopipballglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassod}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' cyl='cyl' id='sopippostglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassod}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesod}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input  name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipeyecurvatureod1}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod2' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipeyecurvatureod2}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipdiameterod}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipconlenvaod}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='${fn:split(po.sopipcommendglasses,',')[0]}' syjpod='"+allTrafficCount+"' id='sopipcommendglasses' size='8' readOnly></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" name='xzbutton' id='xzbutton' onClick='queryInvisibilityEyeglass(1,"+allTrafficCount+",4,"+xzindex+")' title='选 择'></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearSyjpod("+allTrafficCount+")' title='清 空'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenodnum' value='${po.sopipconlenodnum}' class='text_input' size='1'></div></TD><TD rowspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><div align='center'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipconrecipetype'><option value='' selected='selected'>----请选择----</option><option value='足矫' ${po.sopipconrecipetype != '足矫' ? '':'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipconrecipetype != '欠矫' ? '':'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipconrecipetype != '过矫' ? '':'selected=selected'}>过矫</option></select></div></div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' sph='sph' id='sopipballglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassos}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' cyl='cyl' id='sopippostglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassos}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipeyecurvatureos1}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos2' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipeyecurvatureos2}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipdiameteros}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipconlenvaos}' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglasses' value='${fn:replace(fn:split(po.sopipcommendglasses,',')[1],' ','')}' id='sopipcommendglasses' size='8' readOnly syjpos='"+allTrafficCount+"'></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" name='xzbutton' id='xzbutton' onClick='queryInvisibilityEyeglass(2,"+allTrafficCount+",4,"+(xzindex+1)+")' title='选 择'></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearSyjpos("+allTrafficCount+")' title='清 空'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenosnum' value='${po.sopipconlenosnum}' class='text_input' size='1'></div></TD></TR><TBODY><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'>护理液品种:</TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'><textarea readonly='readonly'  id='sopipcommendcardwater' name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendcardwater'>${po.sopipcommendcardwater}</textarea><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" onClick='jyhly()' title='选 择'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearOption()' title='清 空'></div></TD></TR><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'>备注： </div></TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr></table></td></tr></table></td></tr>"
			allTrafficCount++;
		  }if("${po.sopipglasstype }" == "5"){
			  
			c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='zy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='00bbff'><p>框架--中用<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='5'/>&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD>	</TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='1' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassod}' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input   axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesod}' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopiparriseglassod1}' class='text_input' size='4'></div></TD><TD width='6%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value=''>----请选择----</option><option value='内' ${po.sopipbasisod1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisod1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisod1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisod1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighod }'></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightod }'></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='7' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopiparriseglassos1 }'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'><option value='' selected='selected'>----请选择----</option><option value='内' ${po.sopipbasisos1 != '内' ? '' : 'selected=selected' }>内</option><option value='外' ${po.sopipbasisos1 != '外' ? '' : 'selected=selected' }>外</option><option value='上' ${po.sopipbasisos1 != '上' ? '' : 'selected=selected' }>上</option><option value='下' ${po.sopipbasisos1 != '下' ? '' : 'selected=selected' }>下</option></select></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighos }'></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos ' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaos }'></div></TD></TR><TR><TD colspan='6' bgcolor='#00bbff' class='PrivateBorderGreen'></TD><TD colspan='4' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'><OPTION value='' selected>----请选择----</OPTION><OPTION value='打孔' ${po.sopipsuggestframe != '打孔' ? '':'selected=selected'}>打孔</OPTION><OPTION value='拉丝' ${po.sopipsuggestframe != '拉丝' ? '':'selected=selected'}>拉丝</OPTION><OPTION value='板材' ${po.sopipsuggestframe != '板材' ? '':'selected=selected'}>板材</OPTION><OPTION value='框高' ${po.sopipsuggestframe != '框高' ? '':'selected=selected'}>框高</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'><OPTION value='' selected>----请选择----</OPTION><OPTION value='老花渐进' ${po.sopipglassmaterial != '老花渐进' ? '':'selected=selected'}>老花渐进</OPTION><OPTION value='青少年渐进' ${po.sopipglassmaterial != '青少年渐进' ? '':'selected=selected'}>青少年渐进</OPTION><OPTION value='非球面树脂' ${po.sopipglassmaterial != '非球面树脂' ? '':'selected=selected'}>非球面树脂</OPTION><OPTION value='抗辐射镜片' ${po.sopipglassmaterial != '抗辐射镜片' ? '':'selected=selected'}>抗辐射镜片</OPTION><OPTION value='染色镜片' ${po.sopipglassmaterial != '染色镜片' ? '':'selected=selected'}>染色镜片</OPTION><OPTION value='变色镜片' ${po.sopipglassmaterial != '变色镜片' ? '':'selected=selected'}>变色镜片</OPTION><OPTION value='普通树脂' ${po.sopipglassmaterial != '普通树脂' ? '':'selected=selected'}>普通树脂</OPTION><OPTION value='高折玻璃' ${po.sopipglassmaterial != '高折玻璃' ? '':'selected=selected'}>高折玻璃</OPTION><OPTION value='玻璃片' ${po.sopipglassmaterial != '玻璃片' ? '':'selected=selected'}>玻璃片</OPTION><OPTION value='树脂抗疲劳镜片' ${po.sopipglassmaterial != '树脂抗疲劳镜片' ? '':'selected=selected'}>树脂抗疲劳镜片</OPTION><OPTION></OPTION></SELECT></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>处理方式： </div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option><option value='足矫' ${po.sopipdisposemanner != '足矫' ? '':'selected=selected'}>足矫</option><option value='欠矫' ${po.sopipdisposemanner != '欠矫' ? '':'selected=selected'}>欠矫</option><option value='过矫' ${po.sopipdisposemanner != '过矫' ? '':'selected=selected'}>过矫</option><option value='附加棱镜' ${po.sopipdisposemanner != '附加棱镜' ? '':'selected=selected'}>附加棱镜</option><option value='调整' ${po.sopipdisposemanner != '调整' ? '':'selected=selected'}>调整</option><option value='平衡'>平衡</option><option value='医嘱' ${po.sopipdisposemanner != '医嘱' ? '':'selected=selected'}>医嘱</option><option value='全矫' ${po.sopipdisposemanner != '全矫' ? '':'selected=selected'}>全矫</option><option value='患者要求减度' ${po.sopipdisposemanner != '患者要求减度' ? '':'selected=selected'}>患者要求减度</option></select></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='left'>备注:</div></TD><TD colspan='3' bgcolor='#00bbff' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr>"
			allTrafficCount++;
		  }
		  if("${po.sopipglasstype }" == "4"){
		  	xzindex = xzindex+2;
		  }else{
		  	xzindex = xzindex+1;
		  }
		  
		  rowadd++;
		  </c:forEach>
	  }
         //总计多少行   
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
      inspectionForm.trafficCount.value   =   allTrafficCount;
      if('${systemParameterPo.fspothernegative}'=='1'){   
   	  	inspectionOnload();
      }
   	  inspectionCheck();
  }
  
  function deletechufang(obj,listindex){ 
  		$(listindex).parent().parent().parent().parent().parent().parent().parent().remove();
		allTrafficCount--;
        inspectionForm.trafficCount.value = allTrafficCount;   
        if(obj=='1'){
        	xzindex--;
        }else{
        	xzindex= xzindex-2;
        }
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

<input type="hidden" name="ballOD"  value="${refractivePo.soprdbalballglassod}"/>
<input type="hidden" name="glassOD"  value="${refractivePo.soprdbalpostglassod}"/>
<input type="hidden" name="axesOD"  value="${refractivePo.soprdbalaxesod}"/>
<input type="hidden" name="sadOD"  value="${refractivePo.sopraddod }"/>
<input type="hidden" name="ballOS"  value="${refractivePo.soprdbalballglassos}"/>
<input type="hidden" name="glassOS"  value="${refractivePo.soprdbalpostglassos}"/>
<input type="hidden" name="axesOS"  value="${refractivePo.soprdbalaxesos}"/>
<input type="hidden" name="sadOS"  value="${refractivePo.sopraddos}"/>
<input type="hidden" name="inspectionPo.sopiptime"  value="${inspectionPos[0].sopiptime}"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0 onkeydown="if(event.keyCode==13)event.keyCode=9">
        <TBODY>
			<TR>
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx}/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
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
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
									</TR>
								</TBODY>
							</TABLE>
							</TD>
							<td align="right" style="PADDING-LEFT: 2px; HEIGHT: 22px"  background=${ctx }/img/pic/tab_top_bg.gif>
				            </td>
						</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 onkeydown="if(event.keyCode==13)event.keyCode=9">
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
						<s:action name="initCustomerOptometryTitle" executeResult="true" />									
						<br>
						
						<fieldset>
							<legend>双眼视功能检查</legend>
				<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
								<tr>
								<td><table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
                                    <tr>
                                      <td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">处方类型：
                                       <select id="glassType">
                                            <option value="" selected="selected">----请选择----</option>
											<option value="1">远用</option>
											<option value="2">近用</option>
											<option value="3">渐进/双光</option>
											<option value="4">隐形</option>
											<option value="5">中用</option>
                                      </select></li>
									  <li class="horizontal">
									  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="displayTable('n');checkCylZero();">
									  </li>
									  </td>
                                    </tr>
                                  </tbody>
                                </table> 
								</td>
								</tr>
								<tr>
								<td>
								<table id=trafficeList  width="100%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable">
									<tr><td></td></tr>   
                 				</table>
                 				<input type="hidden" name=trafficCount>
                 				</td>
                 				</tr>
							</table>
						    <br>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td colspan="2"><TABLE width="100%" 
                  border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorderBlue" id="fz">
                                  <TBODY>

                                    <TR>
                                      <TD height="30" bgcolor="#E8F8FF"><div align="center" class="PrivateBorder">复诊时间：
                                          <input id="sopipseccheckdate" name="inspectionPo.sopipseccheckdate" onFocus="WdatePicker({readOnly:true})" class="text_input120" value="${inspectionPos[0].sopipseccheckdate }">
                                          <!-- <SELECT id="sopipseccheckdate" name="inspectionPo.sopipseccheckdate">
                                            <OPTION value="">----请选择----</OPTION>
                                            <OPTION value="1" ${inspectionPos[0].sopipseccheckdate != '1' ? '':'selected=selected'}>1</OPTION>
                                            <OPTION value="2" ${inspectionPos[0].sopipseccheckdate != '2' ? '':'selected=selected'}>2</OPTION>
                                            <OPTION value="3" ${inspectionPos[0].sopipseccheckdate != '3' ? '':'selected=selected'}>3</OPTION>
                                            <OPTION value="4" ${inspectionPos[0].sopipseccheckdate != '4' ? '':'selected=selected'}>4</OPTION>
                                            <OPTION value="5" ${inspectionPos[0].sopipseccheckdate != '5' ? '':'selected=selected'}>5</OPTION>
                                            <OPTION value="6" ${inspectionPos[0].sopipseccheckdate != '6' ? '':'selected=selected'}>6</OPTION>
                                            <OPTION value="7" ${inspectionPos[0].sopipseccheckdate != '7' ? '':'selected=selected'}>7</OPTION>
                                            <OPTION value="8" ${inspectionPos[0].sopipseccheckdate != '8' ? '':'selected=selected'}>8</OPTION>
                                            <OPTION value="9" ${inspectionPos[0].sopipseccheckdate != '9' ? '':'selected=selected'}>9</OPTION>
                                            <OPTION value="10" ${inspectionPos[0].sopipseccheckdate != '10' ? '':'selected=selected'}>10</OPTION>
                                            <OPTION value="11" ${inspectionPos[0].sopipseccheckdate != '11' ? '':'selected=selected'}>11</OPTION>
                                            <OPTION value="12" ${inspectionPos[0].sopipseccheckdate != '12' ? '':'selected=selected'}>12</OPTION>
                                          </SELECT>
                                          <SELECT id="sopipsubvisitunit" name="inspectionPo.sopipsubvisitunit">
                                            <OPTION value="">----请选择----</OPTION>
                                            <OPTION value="周" ${inspectionPos[0].sopipsubvisitunit != '周' ? '':'selected=selected'}>周</OPTION>
                                            <OPTION value="月" ${inspectionPos[0].sopipsubvisitunit != '月' ? '':'selected=selected'}>月</OPTION>
                                            <OPTION value="年" ${inspectionPos[0].sopipsubvisitunit != '年' ? '':'selected=selected'}>年</OPTION>
                                          </SELECT>后  -->
                                          
                                        &nbsp;&nbsp;&nbsp;推荐医师
										<input type="text" id="soprexaminedoctorName" name="inspectionPo.sopipexaminedoctorname" value="${inspectionPos[0].sopipexaminedoctorname}">
										<input type="hidden" id="soprexaminedoctorID" name="inspectionPo.sopipexaminedoctor" value="${inspectionPos[0].sopipexaminedoctor}">
										                                        
                                          </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							  <!--  
							   <c:if test="${first==1}" >                      
			                        <TR>
			                          <TD height="26" class="table_body" width="20%">短信内容</TD>
			                          <TD class="table_none" >                         
			                            <textarea name="content" readonly="readonly" id="content" >${content }</textarea>
			                          </TD>
			                        </TR>
		                        </c:if>
		                        -->
		                        <input type="hidden" name="content" id="content" value="${content}">
							</table>
						</fieldset>	
						
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                      <!--  
                      <c:if test="${first==1}" >  
                       <TR>
                        
                          <TD align="left">
                            <div align="left">
                            
								<c:choose>
									<c:when test="${second==1}">
										<input type=checkbox id="isSend" name="isSend" value="1" checked="checked" >发送短信 &nbsp;&nbsp;
									</c:when>
									<c:otherwise>
										<input type=checkbox id="isSend" name="isSend" value="1" >发送短信 &nbsp;&nbsp;
									</c:otherwise>
								</c:choose>
								
							
                              </div></TD>
                              </TR>
                         </c:if>
                         -->
                         <c:if test="${first==1}" >   
                            
								<c:choose>
									<c:when test="${second==1}">
										<input type="hidden" id="isSend" name="isSend" value="1" >
										
									</c:when>
									<c:otherwise>
										<input type="hidden" id="isSend" name="isSend" value="0" >
									</c:otherwise>
								</c:choose>
                         </c:if>  
                         
                        <TR>
                          <TD align="left">
                            <div align="left">
                            
                              <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" name="button1"  title="保存" onClick="save()">
                              &nbsp;&nbsp;
                              <img src="${ctx}/img/newbtn/btn_reset_0.png" btn=btn title="重置" onclick="document.inspectionForm.reset();">
                              </div></TD></TR>
                      </TBODY>
                    </TABLE>		
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff colspan="2"><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>