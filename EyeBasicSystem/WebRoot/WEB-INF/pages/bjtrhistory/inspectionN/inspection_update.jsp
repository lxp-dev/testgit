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
		/*var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWindowInspectionNormalOpen.action?glassType="+glassType+"&goodscategoryID="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWindowInspectionNormalOpen.action?glassType="+glassType+"&goodscategoryID="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【适用镜片查询】";*/
		
		showPopWin("","initWindowInspectionNormalOpen.action?glassType="+glassType+"&goodscategoryID="+goodscategoryID,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function openGoodSingleValues(json){   //适用镜片回调赋值
		if (json.side == '1'){
			$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopipcommendglassesod]')[0].value=json.brandName;
		}else{
			$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopipcommendglassesos]')[0].value=json.brandName;
		}		
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

		//alert($('[name*=.sopipballglassod]').length);
		if($('[name*=.sopipballglassod]').length!=0){
			if(isSubmit == 0){
				return false;
			}else{
				inspectionForm.action="inspectionUpdateBjtr.action?ruleFlag=0&nw='N' ";
				$("img").removeAttr("onclick");
				inspectionForm.submit();
			}
		}else{
			alert("请选择处方！ ");
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
		
		var sopipestimate = '${inspectionPos[0].sopipestimate}'.split(',');
		for(var i=0; i<sopipestimate.length; i++){
			$('[name=inspectionPo.sopipestimate][value='+sopipestimate[i].trim()+']').attr("checked","checked");
		}
		
		var sopipglasstypes = '${inspectionPos[0].sopipglasstypes}'.split(',');
		for(var i=0; i<sopipglasstypes.length; i++){
			$('[name=inspectionPo.sopipglasstypes][value='+sopipglasstypes[i].trim()+']').attr("checked","checked");
		}
		
		var sopiptouchglass = '${inspectionPos[0].sopiptouchglass}'.split(',');
		for(var i=0; i<sopiptouchglass.length; i++){
			$('[name=inspectionPo.sopiptouchglass][value='+sopiptouchglass[i].trim()+']').attr("checked","checked");
		}
		
		var sopiptraintypes = '${inspectionPos[0].sopiptraintypes}'.split(',');
		for(var i=0; i<sopiptraintypes.length; i++){
			$('[name=inspectionPo.sopiptraintypes][value='+sopiptraintypes[i].trim()+']').attr("checked","checked");
		}
	});
	function refractive(){
		inspectionForm.action="refractiveToolBjtr.action?source=refractiveiou";//refractiveTool.action?source=refractiveiou
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	function doubleEyeFun(){
		inspectionForm.action="doubleEyeFunToolBjtr.action?source=doubleeyefuniou";
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}
	function specialCheck(){
		inspectionForm.action="specialCheckToolBjtr.action?source=specialcheckiou";
		if('$(oldOptometryID)'!=''){
			inspectionForm.action="specialCheckToolBjtr.action?source=specialcheckcopy";
		}
		$("img").removeAttr("onclick");
		inspectionForm.submit();
	}

	function contactGlass(){
		inspectionForm.action="contactGlassToolBjtr.action?source=contactGlassiou";
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
		if (json.goodsCategoryID == '9'){
			if (json.setwhich == 'sopipfamily'){
				$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopipfamilytrain]')[0].value=json.goodsName;
			}else{
				$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopiptrainroom]')[0].value=json.goodsName;
			}			
		}else{
			if(json.glassType!=''){
				$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopipcommendglasses]')[0].value=json.goodsName;
			}else{
				$('#sopipcommendcardwater').html(($('#sopipcommendcardwater').text()+';'+json.goodsName).substring(0,1)==';'?($('#sopipcommendcardwater').text()+';'+json.goodsName).substring(1):($('#sopipcommendcardwater').text()+';'+json.goodsName));
			}
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
	
	function refractive(){
		inspectionForm.action="refractiveToolBjtr.action?source=refractiveiou";
		$("img").removeAttr("onclick");
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
		
		var myValue = document.getElementById('glassType').value;
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
		         c1.innerHTML="<tr id="+rowadd+"tr><td>"
		         				+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yy'>"
		         					+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='1'/>"
		         					+"<TR>"
		         						+"<TD colspan='9' style='height:20px' class='PrivateBorderGreen' bgcolor='dfffdf'>"
		         							+"<p>框架--远用&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'></p></TD></TR>"
		         							+"<TR><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
		         								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用瞳距(mm)</div></TD>"
		         								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
		         								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD></TR>"
		         							+"<TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='1'  sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' value='${refractivePo.soprdbalballglassod}' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' value='${refractivePo.soprdbalpostglassod}' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input   axes='axes' yyorder='3' value='${refractivePo.soprdbalaxesod}' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='4' ljxj='ljxj' value='${refractivePo.soprdbalarriseglassod}' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input' size='4' value=''></div></TD><TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
		         									+"<div align='center'><select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
		         									+"<option value='' selected></option>"
		                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
				                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
				                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
				                                     +" </c:if>"	                                      	
			                                         +"</c:forEach>"
		         									+"</select></div></TD>"
		         								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' value='${refractivePo.soprdbalinterhighod }' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4'></div></TD>"
		         								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' value='${refractivePo.soprpupilheightod }' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' class='text_input' size='4'></div></TD>"
		         								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='7' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD></TR>"
		         							+"<TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' value='${refractivePo.soprdbalballglassos}' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='9' cyl='cyl' value='${refractivePo.soprdbalpostglassos}' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${refractivePo.soprdbalaxesos}' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
		         									+"<div align='center'><select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
		         									+"<option value='' selected></option>"
		                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
				                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
				                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
				                                     +" </c:if>"	                                      	
			                                         +"</c:forEach>"
		         									+"</select></div></TD>"
		         								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${refractivePo.soprdbalinterhighos }'></div></TD>"
		         								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' class='text_input' size='4' value='${refractivePo.soprpupilheightos }'></div></TD>"
		         								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='14' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaos }'></div></TD></TR><TR><TD colspan='4' bgcolor='#DFFFDF' class='PrivateBorderGreen'></TD><TD colspan='5' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance'>建议镜框：<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
		         									+"<option value='' selected></option>"
		                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
				                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'52\'}'>"
				                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
				                                     +" </c:if>"	                                      	
			                                         +"</c:forEach>"
		         									+"</SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12'></div></TD></TR><TR><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
		         									+"<option value='' selected></option>"
		                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
				                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'53\'}'>"
				                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
				                                     +" </c:if>"	                                      	
			                                         +"</c:forEach>"
			                                         
		         									+"</SELECT></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>处理方式： </div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
		         									+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'>"
		         									+"<option value='' selected></option>"
		                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
				                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'54\'}'>"
				                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
				                                     +" </c:if>"	                                      	
			                                         +"</c:forEach>"
		         									+"</select></TD><TD colspan='2' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>备注:</div></TD><TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea>"
		         						+"</TD>"
		         					+"</TR>"
		         				+"</TABLE>"
		         				+"</td></tr>";					
			     					
			  }if(myValue == "2"){
				  
				c1.innerHTML="<tr id="+rowadd+"tr ><td><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jy'><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='2'/><TR><TD colspan='9' style='height:20px' class='PrivateBorderBlue' bgcolor='#E1EBFD'><p>框架--近用&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn  title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>&nbsp;</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>球镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>柱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>轴向</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>三棱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>基底</div></TD>"
												+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用瞳距(mm)</div></TD>"
												+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>瞳高(mm)</div></TD>"
												+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OD</TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${refractivePo.soprdbalballglassod}' jy=jy onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='2' needChange='needChange' value='${refractivePo.soprdbalpostglassod}' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='3' axes='axes' value='${refractivePo.soprdbalaxesod}' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassod }'></div></TD><TD width='6%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>"
												+"<select jjorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
												+"</select></div></TD>"
												+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterdistanceod }'></div></TD>"																
												+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightod }'></div></TD>"
												+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='8' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD></TR><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OS</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input value='${refractivePo.soprdbalballglassos}' jjorder='9' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' jy=jy onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='10' needChange='needChange' value='${refractivePo.soprdbalpostglassos}' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='11' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' value='${refractivePo.soprdbalaxesos}' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='13' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassos }'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>"
												+"<select jjorder='14' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
												+"</select></div></TD>"
												+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterdistanceos }'></div></TD>"
												+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightos }'></div></TD>"
												+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='16' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaos }'></div></TD></TR><TR><TD colspan='4' bgcolor='#E1EBFD' class='PrivateBorderBlue'></TD><TD colspan='5' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance'>建议镜框："
												+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'52\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
												+"</SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12'></div></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>建议镜片材质:</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>"
												+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'53\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
												+"</SELECT></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'>"
												+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'54\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
												+"</select></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>备注：</div></TD><TD colspan='3' bgcolor='#E1EBFD' class='PrivateBorderBlue'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR></TBODY></TABLE></td></tr>";
				
			  }if(myValue == "3"){
					c1.innerHTML="<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='3'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jj'><TR><TD colspan='12' style='height:20px' class='PrivateBorderYellow' bgcolor='#FBF3BD'>框架--双光/渐进&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn  title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'></TD></TR><TR><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'>&nbsp;</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>球镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>柱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>轴向</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>Add</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>三棱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>基底</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用瞳距(mm)</div></TD>"
					+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用瞳距(mm)</div></TD>"
					+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>瞳高(mm)</div></TD>"
					+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用VA</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OD</TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='1' needChange='needChange' sph='sph' value='${refractivePo.soprdbalballglassod}' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='2' needChange='needChange' value='${refractivePo.soprdbalpostglassod}' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='3' axes='axes' value='${refractivePo.soprdbalaxesod}' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD> <TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='4'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddod' value='${refractivePo.sopraddod}'  onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassod }'></div></TD><TD width='6%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>"
					+"<div align='center'><select jjsgorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
						+"<option value='' selected></option>"
		                +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                 +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                 +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
		                 +" </c:if>"	                                      	
		                 +"</c:forEach>"
					+"</select></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighod }'></div></TD>"
					+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterdistanceod }'></div></TD>"
					+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightod }'></div></TD>"
					+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='9' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='10' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD></TR><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OS</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='11' value='${refractivePo.soprdbalballglassos}' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='12' needChange='needChange' value='${refractivePo.soprdbalpostglassos}' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='13' axes='axes' value='${refractivePo.soprdbalaxesos}' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='14'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddos' value='${refractivePo.sopraddos}' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='15' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassos }'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'>"
					+"<div align='center'><select jjsgorder='16' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
						+"<option value='' selected></option>"
		           		 +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		             		+" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		             		+" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
		             		+" </c:if>"	                                      	
		             	+"</c:forEach>"
					+"</select></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='17' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighos }'></div></TD>"
					+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterdistanceos }'></div></TD>"
					+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightos }'></div></TD>"
					+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='19' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaos }'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='20' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaos }'></div></TD></TR><TR><TD colspan='7' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'></div></TD><TD colspan='5' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance'>建议镜框："
					+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
						+"<option value='' selected></option>"
			      		 +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			        		+" <c:if test='${optionParamPoTmp.fopparentid==\'52\'}'>"
			        		+" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
			        		+" </c:if>"	                                      	
			        	+"</c:forEach>"
					+"</SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>建议镜片材质： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'>"
					+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
						+"<option value='' selected></option>"
			     		 	+"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			       			+" <c:if test='${optionParamPoTmp.fopparentid==\'53\'}'>"
			       			+" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
			       			+"</c:if>"	                                      	
			       		+"</c:forEach>"
					+"</SELECT></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'>"
					+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'>"
					+"<option value='' selected></option>"
			 		 	+"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
				   			+" <c:if test='${optionParamPoTmp.fopparentid==\'54\'}'>"
				   			+" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
				   			+"</c:if>"	                                      	
			   			+"</c:forEach>"
					+"</select></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>备注： </div></TD><TD colspan='4' bgcolor='#FBF3BD' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR></TBODY></td></tr></table></TABLE>"
		+"</td></tr>";  				  
				
			  }if(myValue == "4"){
				  
				c1.innerHTML="<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='4'/><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR><TD colspan='11' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>隐形&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn  title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(2,this);'></TD></TR><TR><TD width='3%' bgcolor='#F8E0F0' class='PrivateBorderPink'>&nbsp;</TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率1</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率2</div></TD><TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形VA</div></TD><TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD><TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>片/盒数</div></TD><TD width='11%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形处理方式</div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' value='' sph='sph' id='sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' value='' cyl='cyl' id='sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input axes='axes' value='' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input  name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod2' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesod' value='' syjpod='"+allTrafficCount+"' id='sopipcommendglassesod' size='8' readOnly></li><li class='horizontal'><img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='queryInvisibilityEyeglass(1,"+allTrafficCount+",4,"+xzindex+")' title='选择'></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearSyjpod("+allTrafficCount+")' value='清空'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenodnum' value='' class='text_input' size='1'></div></TD><TD rowspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><div align='center'>"
				+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipconrecipetype'>"
					+"<option value='' selected></option>"
		            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		             +" <c:if test='${optionParamPoTmp.fopparentid==\'55\'}'>"
		             +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
		             +" </c:if>"	                                      	
		             +"</c:forEach>"
				+"</select></div></div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' sph='sph' id='sopipballglassos' value='' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input needChange='needChange' value='' cyl='cyl' id='sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input axes='axes' value='' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos2' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='' class='text_input' size='2'></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片：<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesos' id='sopipcommendglassesos' size='8' readOnly syjpos='"+allTrafficCount+"'></li><li class='horizontal'><img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='queryInvisibilityEyeglass(2,"+allTrafficCount+",4,"+(xzindex+1)+")' title='选择'></li><li class='horizontal'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearSyjpos("+allTrafficCount+")' title='清空'></li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenosnum' class='text_input' size='1'></div></TD></TR><TBODY><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'>护理液品种:</TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'><textarea readonly='readonly'  id='sopipcommendcardwater' name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendcardwater'></textarea><img src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='jyhly("+xzindex+")' title='选择'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearOption()' title='清空'></div></TD></TR></TBODY></TABLE></td></tr></table></td></tr></table></td></tr>";
				
			  }if(myValue == "5"){
				  
				c1.innerHTML="<tr id="+rowadd+"tr><td><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='5'/>"
												+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='zy'>"
												+"<TR>"
												+"<TD colspan='15' style='height:20px' class='PrivateBorderGreen' bgcolor='00bbff'><p>框架--中用&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn  title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD>	</TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
												+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用瞳距(mm)</div></TD>"
												+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
												+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='1' value='${refractivePo.soprdbalballglassod}' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input  needChange='needChange' yyorder='2' value='${refractivePo.soprdbalpostglassod}' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input  value='${refractivePo.soprdbalaxesod}'  axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassod }'></div></TD><TD width='6%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>"
												+"<select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
		                                         +"</select></div></TD>"
												+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighod }'></div></TD>"
												+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightod }'></div></TD>"
												+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='7' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaod }'></div></TD></TR><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='8' value='${refractivePo.soprdbalballglassos}' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' value='${refractivePo.soprdbalpostglassos}' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input value='${refractivePo.soprdbalaxesos}' axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalarriseglassos }'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>"
												+"<select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
												+"</select></div></TD>"
												+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalinterhighos }'></div></TD>"
												+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprpupilheightos }'></div></TD>"
												+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${refractivePo.soprdbalvaos }'></div></TD></TR><TR><TD colspan='4' bgcolor='#00bbff' class='PrivateBorderGreen'></TD><TD colspan='5' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance'>建议镜框："
												+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'52\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
		                                         +"</SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12'></div></TD></TR><TR><TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'>"
												+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'53\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
												+"</SELECT></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'>"
												+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'54\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
												+"</select></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='left'>备注:</div></TD><TD colspan='3' bgcolor='#00bbff' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR>"
												+"</TABLE>"
												+"</td></tr>";
				
			  }
			  
			  if(myValue == "6"){
				  c1.innerHTML="<tr id="+rowadd+"tr><td><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='6'/>"
				  								+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR>"
				  								+"<TD id='yxs' colspan='17' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>"
				  								+"<p>角膜塑形镜&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn  title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'></p></TD></TR>"
				  								+"<tr>"
				  								+"<td rowspan='2'  width='5%' su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'></td>"
				  								+"<td bgcolor='#F8E0F0' class='PrivateBorderPink' style='height:20px' colspan='7'><div align='center'>屈光处方及角膜参数</div></td>"
				  								+"<td su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink' align='center'>试戴片</td>"
				  								+"<td bgcolor='#F8E0F0' class='PrivateBorderPink' colspan='5'><div align='center'>订片参数</div></td>"
				  								+"<td su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'></td></tr><TR>"
				  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD>"
				  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD>"
				  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD>"
				  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>平K</div></TD>"
				  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>陡K</div></TD>"
				  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>e值</div></TD>"
				  								+"<TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>角膜直径</div></TD>"
				  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K</div></TD>"
				  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K1</div></TD>"
				  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K2</div></TD>"
				  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>光度</div></TD>"
				  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>降度</div></TD>"
				  								+"<TD su=lxd width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></td>"
				  								+"<TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD>"
				  								+"</TR><TR>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input needChange='needChange' sph='sph' id='sopipballglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter1'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input needChange='needChange' cyl='cyl' id='sopippostglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter2'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter6'></div></TD>"
				  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupkod' value='${po.sopipupkod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdownkod' value='${po.sopipdownkod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeod' value='${po.sopipeod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipcornealdiameterod' value='${po.sopipcornealdiameterod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk0od' value='${po.sopipk0od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk1od' value='${po.sopipk1od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk2od' value='${po.sopipk2od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupcod' value='${po.sopipupcod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdowncod' value='${po.sopipdowncod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' value='${po.sopipdiameterod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片："
				  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesod' value='${po.sopipcommendglassesod}' id='cc1.commendglasses22' size='8' readOnly syjpod='"+allTrafficCount+"'></li><li class='horizontal'>"
				  								+"<img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='queryInvisibilityEyeglass(1,"+allTrafficCount+",4,"+xzindex+")' title='选 择'></li><li class='horizontal'>"
				  								+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearSyjpod("+allTrafficCount+")' value='清 空'></li></div></TD>"
				  								+"</TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input needChange='needChange' sph='sph' id='sopipballglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter8'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input needChange='needChange' cyl='cyl' id='sopippostglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter9'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter10'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupkos' value='${po.sopipupkos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter11'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdownkos' value='${po.sopipdownkos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter12'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeos' value='${po.sopipeos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter13'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipcornealdiameteros' value='${po.sopipcornealdiameteros}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter14'></div></TD>"
				  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk0os' value='${po.sopipk0os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk1os' value='${po.sopipk1os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk2os' value='${po.sopipk2os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupcos' value='${po.sopipupcos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdowncos' value='${po.sopipdowncos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
				  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' value='${po.sopipdiameteros}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
				  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片："
				  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesos' value='${po.sopipcommendglassesos}' id='cc1.commendglasses22' size='8' readOnly syjpos='"+allTrafficCount+"'></li><li class='horizontal'>"
				  								+"<img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='queryInvisibilityEyeglass(2,"+allTrafficCount+",4,"+xzindex+")' title='选择'></li><li class='horizontal'>"
				  								+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearSyjpos("+allTrafficCount+")' value='清空'></li></div></TD>"
				  								+"</TR>"
				  								+"</TABLE></td></tr></table></td></tr>";
			  		allTrafficCount++;	
			  }
			  
			  if(myValue == "7"){
				  c1.innerHTML="<tr id="+rowadd+"tr><td><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='7'/>"
				  								+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yy'><TR>"
				  								+"<TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='dfffdf'><p>视觉训练&nbsp;&nbsp;&nbsp;"
				  								+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn  title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD>	</TR><TR>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>球镜</div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>轴向</div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用瞳距(mm)</div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用瞳距(mm)</div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用VA</div></TD>"
				  								+"</TR><TBODY><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD>"
				  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input needChange='needChange' yyorder='1' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD>"
				  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input cyl' size='4'></div></TD>"
				  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input axes' size='4'></div></TD>"
				  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"                         
				  								+"<input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' value='${refractivePo.soprdbalarriseglassod}' class='text_input' size='4'></div></TD>"
				  								+"<TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"	
				  								+"</select></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value='${refractivePo.soprdbalinterhighod}'></div></TD>"
				  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' value='${refractivePo.soprpupilheightod}' class='text_input' size='4'></div></TD>"
				  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input yyorder='7' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' value='${refractivePo.soprdbalvaod}' class='text_input' size='4'></div></TD>"
				  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' value='${refractivePo.soprdbalvaod}' class='text_input' size='4'></div></TD>"
				  								+"</TR><TR>"
				  								+"<TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' value='${refractivePo.soprdbalarriseglassos}' class='text_input' size='4'></div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'>"
		     									+"<option value='' selected></option>"
		                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
			                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
			                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
			                                     +" </c:if>"	                                      	
		                                         +"</c:forEach>"
				  								+"</select></div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${refractivePo.soprdbalinterhighos}'></div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' value='${refractivePo.soprpupilheightos}' class='text_input' size='4'></div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input yyorder='14' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' class='text_input' size='4' value='${refractivePo.soprdbalvaos}'></div></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
				  								+"<input va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' class='text_input' size='4' value='${refractivePo.soprdbalvaos}'></div></TD></TR><TR>"
				  								+"<TD colspan='6' bgcolor='#DFFFDF' class='PrivateBorderGreen'><li class='horizontal'><div align='center'>家庭训练："
				  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipfamilytrain' id='cc1.commendglasses' size='12' readOnly ></div></li><li class='horizontal'>"
				  								+"<div align='center'><img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='xlopen("+allTrafficCount+","+xzindex+");' title='选择'></div></li><li class='horizontal'>"
				  								+"<div align='center'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearxl("+allTrafficCount+")' title='清空'></div></li><li class='horizontal'><div align='center'>训练室训练："
				  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopiptrainroom' id='cc1.commendglasses' size='12' readOnly ></div></li><li class='horizontal'>"
				  								+"<div align='center'><img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='xlsopen("+allTrafficCount+","+xzindex+");' title='选择'></div></li><li class='horizontal'>"
				  								+"<div align='center'><img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearxls("+allTrafficCount+")' title='清空'></div></li></TD>"
				  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><div align='right'>备注:</div></TD>"
				  								+"<TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
				  								+"<textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'></textarea></TD></TR></TBODY></TABLE></td></tr>";
			  		allTrafficCount++;	
		  }
		  if(myValue == "4" || myValue == "6"){
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
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='1'  sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value="+"${po.sopipballglassod}"+"></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='"+"${po.sopippostglassod}"+"' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input   axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='"+"${po.sopipaxesod}"+"' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='"+"${po.sopiparriseglassod1}"+"' class='text_input' size='4' value=''></div></TD><TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
	        								+"<div align='center'><select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"
	        								+"</select></div></TD>"
	        								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' value='${po.sopipinterhighod}' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD>"
	        								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' value='${po.sopippupilheightod}' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD>"
	        								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='7' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaod  }'></div></TD></TR><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipballglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippostglassos }'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos }' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopiparriseglassos1 }' class='text_input' size='4'></div></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
	        								+"<div align='center'><select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"	        								
	        								+"</select></div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighos }'></div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
	        								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><input yyorder='14' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaos  }'></div></TD></TR><TR><TD colspan='5' bgcolor='#DFFFDF' class='PrivateBorderGreen'></TD><TD colspan='4' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框："
	        								+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
         									+"<option value='' selected></option>"
                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'52\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipsuggestframe == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"	        								
	        								+"</OPTION></SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
	        								+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
         									+"<option value='' selected></option>"
                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'53\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipglassmaterial == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"	        								
	        								+"</SELECT></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>处理方式： </div></TD><TD colspan=2 bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
	        								+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'>"
         									+"<option value='' selected></option>"
                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'54\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipdisposemanner == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"	        								
	        								+"</select></TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='right'>备注:</div></TD><TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr>";
		     allTrafficCount++;					
		  }
		  
		  if("${po.sopipglasstype }" == "2"){
			  
			c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jy'><TR><TD colspan='9' style='height:20px' class='PrivateBorderBlue' bgcolor='#E1EBFD'><p>框架--近用<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='2'/>&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>&nbsp;</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>球镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>柱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>轴向</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>三棱镜</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>基底</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OD</TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' jy=jy onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassod }' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassod }' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopiparriseglassod1 }'></div></TD><TD width='6%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>"
											+"<div align='center'><select jjorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"
											+"</select></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterdistanceod }'></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightod }'></div></TD>"
											+"<TD width='8%' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='8' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipclosevaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#E1EBFD' class='PrivateBorderBlue'>OS</TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='9' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' jy=jy onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='10' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='11' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos }' class='text_input' size='4'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='13' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopiparriseglassos1 }'></div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>"
											+"<div align='center'><select jjorder='14' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"
											+"</select></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterdistanceos }'></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='15' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
											+"<TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'><input jjorder='16' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipclosevaos }'></div></TD></TR><TR><TD colspan='5' bgcolor='#E1EBFD' class='PrivateBorderBlue'></TD><TD colspan='4' bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框："
											+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
         									+"<option value='' selected></option>"
                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'52\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipsuggestframe == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>建议镜片材质:</div></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'>"
											+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
         									+"<option value='' selected></option>"
                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'53\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipglassmaterial == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</SELECT></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#E1EBFD' class='PrivateBorderBlue'><select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'><option value='' selected>----请选择----</option>"

                                            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'54\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipdisposemanner == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"	

											+"</select></TD><TD bgcolor='#E1EBFD' class='PrivateBorderBlue'><div align='right'>备注： </div></TD><TD colspan='3' bgcolor='#E1EBFD' class='PrivateBorderBlue'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr>";
			allTrafficCount++;
		  }
		  
		  if("${po.sopipglasstype }" == "3"){
			  
			c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='jj'><TR><TD colspan='12' style='height:20px' class='PrivateBorderYellow' bgcolor='#FBF3BD'>框架--双光/渐进<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='3'/>&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'></TD></TR><TR><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'>&nbsp;</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>球镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>柱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>轴向</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>Add</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>三棱镜</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>基底</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>远用VA</div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>近用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OD</TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='1' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='2' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod'onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='3' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesod}' class='text_input' size='4'></div></TD> <TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='4'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaddod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='5' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopiparriseglassod1 }'></div></TD><TD width='6%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>"
											+"<div align='center'><select jjsgorder='6' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"
											+"</select></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='7' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighod}'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterdistanceod}'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='8' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightod}'></div></TD>"
											+"<TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='9' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaod}'></div></TD><TD width='8%' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='10' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipclosevaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#FBF3BD' class='PrivateBorderYellow'>OS</TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='11' needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='12' needChange='needChange' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='13' axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='14'  needChange='needChange' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipaddos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaddos}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='15' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopiparriseglassos1}' class='text_input' size='4'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'>"
											+"<div align='center'><select jjsgorder='16' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"
											+"</select></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='17' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighos}'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterdistanceos}'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='18' tongju='tongju'  name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightos}'></div></TD>"
											+"<TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='19' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaos}'></div></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'><input jjsgorder='20' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipclosevaos}'></div></TD></TR><TR><TD colspan='7' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'></div></TD><TD colspan='5' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框："
											+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'52\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipsuggestframe == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"
											+"</SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' size='12' value='${po.sopipframeheight}'></div></TD></TR><TR><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>建议镜片材质： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'>"
											+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'53\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipglassmaterial == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</SELECT></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>处理方式： </div></TD><TD colspan='2' bgcolor='#FBF3BD' class='PrivateBorderYellow'>"
											+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'54\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipdisposemanner == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</select></TD><TD bgcolor='#FBF3BD' class='PrivateBorderYellow'><div align='right'>备注： </div></TD><TD colspan='4' bgcolor='#FBF3BD' class='PrivateBorderYellow'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></table></tr></td></td></tr>";
			allTrafficCount++;
		  }if("${po.sopipglasstype }" == "4"){
			  
			c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td>"
											+"<table width='100%'><tr width='100%'><td width='100%'>"
											+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR>"
											+"<TD colspan='11' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>隐形"
											+"<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='4'/>"
											+"&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(2,this);'></TD></TR>"
											+"<TR><TD width='3%' bgcolor='#F8E0F0' class='PrivateBorderPink'>&nbsp;</TD>"
											+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD>"
											+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD>"
											+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD>"
											+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率1</div></TD>"
											+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>曲率2</div></TD>"
											+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></TD>"
											+"<TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形VA</div></TD>"
											+"<TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD>"
											+"<TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>片/盒数</div></TD>"
											+"<TD width='11%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形处理方式</div></TD>"
											+"</TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>"
											+"<div align='center'>"
											+"<input needChange='needChange' sph='sph' id='sopipballglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassod}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input needChange='needChange' cyl='cyl' id='sopippostglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassod}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesod}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input  name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipeyecurvatureod1}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureod2' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipeyecurvatureod2}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipdiameterod}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipconlenvaod}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<li class='horizontal'>适用镜片："
											+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesod' value='${po.sopipcommendglassesod}' syjpod='"+allTrafficCount+"' id='sopipcommendglassesod' size='8' readOnly>"
											+"</li><li class='horizontal'>"
											+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" name='xzbutton' id='xzbutton' onClick='queryInvisibilityEyeglass(1,"+allTrafficCount+",4,"+xzindex+")' title='选 择'>"
											+"</li><li class='horizontal'>"
											+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearSyjpod("+allTrafficCount+")' title='清 空'>"
											+"</li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenodnum' value='${po.sopipconlenodnum}' class='text_input' size='1'>"
											+"</div></TD><TD rowspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><div align='center'>"
											+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipconrecipetype'>"
											+"<option value='' selected></option>"
								            +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
								             +" <c:if test='${optionParamPoTmp.fopparentid==\'55\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipconrecipetype == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"								             
								             +" </c:if>"	                                      	
								             +"</c:forEach>"
											+"</select></div></div></TD></TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD>"
											+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input needChange='needChange' sph='sph' id='sopipballglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassos}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input needChange='needChange' cyl='cyl' id='sopippostglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassos}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipeyecurvatureos1}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeyecurvatureos2' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipeyecurvatureos2}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipdiameteros}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipconlenvaos}' class='text_input' size='2'>"
											+"</div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片："
											+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesos' value='${po.sopipcommendglassesos}' id='sopipcommendglassesos' size='8' readOnly syjpos='"+allTrafficCount+"'>"
											+"</li><li class='horizontal'>"
											+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" name='xzbutton' id='xzbutton' onClick='queryInvisibilityEyeglass(2,"+allTrafficCount+",4,"+(xzindex+1)+")' title='选 择'>"
											+"</li><li class='horizontal'>"
											+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearSyjpos("+allTrafficCount+")' title='清 空'>"
											+"</li></div></TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
											+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipconlenosnum' value='${po.sopipconlenosnum}' class='text_input' size='1'>"
											+"</div></TD></TR><TBODY><TR><TD colspan='2' bgcolor='#F8E0F0' class='PrivateBorderPink'>"
											+"护理液品种:</TD><TD colspan='9' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='left'>"
											+"<textarea readonly='readonly'  id='sopipcommendcardwater' name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendcardwater'>${po.sopipcommendcardwater}</textarea>"
											+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" src='${ctx }/img/newbtn/btn_change_0.png' btn=btn style=\"cursor: hand\" onClick='jyhly()' title='选 择'>"
											+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn style=\"cursor: hand\" name='button23' onClick='clearOption()' title='清 空'>"
											+"</div></TD></TR></TBODY></TABLE></td></tr></table></td></tr></table></td></tr>";
			allTrafficCount++;
		  }
		  
		  if("${po.sopipglasstype }" == "5"){
			  
			c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><table width='100%'><tr width='100%'><td width='100%'><TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='zy'><TR><TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='00bbff'><p>框架--中用<input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='5'/>&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\"  onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" style=\"cursor: hand\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD>	</TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>球镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>轴向</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用瞳距(mm)</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>瞳高(mm)</div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中用VA</div></TD></TR><TBODY><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OD</TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='1' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassod}' class='text_input cyl' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input   axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesod}' class='text_input axes' size='4'></div></TD><TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopiparriseglassod1}' class='text_input' size='4'></div></TD><TD width='6%' bgcolor='#00bbff' class='PrivateBorderGreen'>"
											+"<div align='center'><select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</select></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighod }'></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightod }'></div></TD>"
											+"<TD width='8%' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='7' va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaod}'></div></TD></TR><TR><TD width='11%' bgcolor='#00bbff' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopiparriseglassos1 }'></div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'>"
											+"<div align='center'><select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</select></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipinterhighos }'></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopippupilheightos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopippupilheightos }'></div></TD>"
											+"<TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'><input va='va' maxlength='20' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos ' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input' size='4' value='${po.sopipfarvaos }'></div></TD></TR><TR><TD colspan='6' bgcolor='#00bbff' class='PrivateBorderGreen'></TD><TD colspan='4' bgcolor='#00bbff' class='PrivateBorderGreen'><div align='center'>中距离：<INPUT type='checkbox' value='1' name='inspectionPos["+Subtr(1,listindex)+"].sopipmiddledistance' ${po.sopipmiddledistance != '1' ? '':'checked=checked'}>建议镜框："
											+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipsuggestframe'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'52\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipsuggestframe == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</SELECT><INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipframeheight' value='${po.sopipframeheight}' size='12'></div></TD></TR><TR><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>建议镜片材质:<TD colspan='2' bgcolor='#00bbff' class='PrivateBorderGreen'>"
											+"<SELECT name='inspectionPos["+Subtr(1,listindex)+"].sopipglassmaterial'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'53\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipglassmaterial == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</SELECT></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='right'>处理方式： </div></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'>"
											+"<select name='inspectionPos["+Subtr(1,listindex)+"].sopipdisposemanner'>"
	     									+"<option value='' selected></option>"
	                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
		                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'54\'}'>"
		                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${(po.sopipdisposemanner == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>"		                                     
		                                     +" </c:if>"	                                      	
	                                         +"</c:forEach>"											
											+"</select></TD><TD bgcolor='#00bbff' class='PrivateBorderGreen'><div align='left'>备注:</div></TD><TD colspan='3' bgcolor='#00bbff' class='PrivateBorderGreen'><textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr>";
			allTrafficCount++;
		  }
		  if("${po.sopipglasstype }" == "6"){
		  c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='6'/>"
		  								+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yx'><TR>"
		  								+"<TD id='yxs' colspan='17' style='height:20px' class='PrivateBorderPink' bgcolor='#F8E0F0'>"
		  								+"<p>角膜塑形镜&nbsp;&nbsp;&nbsp;<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn  title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'></p></TD></TR>"
		  								+"<tr>"
		  								+"<td rowspan='2'  width='5%' su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'></td>"
		  								+"<td bgcolor='#F8E0F0' class='PrivateBorderPink' style='height:20px' colspan='7'><div align='center'>屈光处方及角膜参数</div></td>"
		  								+"<td su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink' align='center'>试戴片</td>"
		  								+"<td bgcolor='#F8E0F0' class='PrivateBorderPink' colspan='5'><div align='center'>订片参数</div></td>"
		  								+"<td su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'></td></tr><TR>"
		  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>球镜</div></TD>"
		  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>柱镜</div></TD>"
		  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>轴向</div></TD>"
		  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>平K</div></TD>"
		  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>陡K</div></TD>"
		  								+"<TD width='5%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>e值</div></TD>"
		  								+"<TD width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>角膜直径</div></TD>"
		  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K</div></TD>"
		  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K1</div></TD>"
		  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>K2</div></TD>"
		  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>光度</div></TD>"
		  								+"<TD su=eae width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>降度</div></TD>"
		  								+"<TD su=lxd width='6%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>直径</div></td>"
		  								+"<TD width='44%' bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>隐形镜片</div></TD>"
		  								+"</TR><TR>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OD</TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input needChange='needChange' sph='sph' id='sopipballglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter1'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input needChange='needChange' cyl='cyl' id='sopippostglassod' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter2'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter6'></div></TD>"
		  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupkod' value='${po.sopipupkod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdownkod' value='${po.sopipdownkod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=lxd bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeod' value='${po.sopipeod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipcornealdiameterod' value='${po.sopipcornealdiameterod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk0od' value='${po.sopipk0od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk1od' value='${po.sopipk1od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk2od' value='${po.sopipk2od}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=ht bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupcod' value='${po.sopipupcod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdowncod' value='${po.sopipdowncod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameterod' value='${po.sopipdiameterod}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片："
		  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesod' value='${po.sopipcommendglassesod}' id='cc1.commendglasses22' size='8' readOnly syjpod='"+allTrafficCount+"'></li><li class='horizontal'>"
		  								+"<img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='queryInvisibilityEyeglass(1,"+allTrafficCount+",4,"+xzindex+")' title='选择'>"
		  								+"</li><li class='horizontal'>"
		  								+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearSyjpod("+allTrafficCount+")' title='清空'>"
		  								+"</li></div></TD>"
		  								+"</TR><TR><TD bgcolor='#F8E0F0' class='PrivateBorderPink'>OS</TD><TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input needChange='needChange' sph='sph' id='sopipballglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter8'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input needChange='needChange' cyl='cyl' id='sopippostglassos' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter9'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input axes='axes' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter10'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupkos' value='${po.sopipupkos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter11'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdownkos' value='${po.sopipdownkos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter12'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipeos' value='${po.sopipeos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter13'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipcornealdiameteros' value='${po.sopipcornealdiameteros}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter14'></div></TD>"
		  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk0os' value='${po.sopipk0os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk1os' value='${po.sopipk1os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipk2os' value='${po.sopipk2os}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipupcos' value='${po.sopipupcos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=eae bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdowncos' value='${po.sopipdowncos}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD su=rb bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'>"
		  								+"<input name='inspectionPos["+Subtr(1,listindex)+"].sopipdiameteros' value='${po.sopipdiameteros}' class='text_input' size='2' onKeyPress='EnterDown(this)' enter='enter7'></div></TD>"
		  								+"<TD bgcolor='#F8E0F0' class='PrivateBorderPink'><div align='center'><li class='horizontal'>适用镜片："
		  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipcommendglassesos' value='${po.sopipcommendglassesos}' id='cc1.commendglasses22' size='8' readOnly syjpos='"+allTrafficCount+"'></li><li class='horizontal'>"
		  								+"<img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='queryInvisibilityEyeglass(2,"+allTrafficCount+",4,"+xzindex+")' title='选择'>"
		  								+"</li><li class='horizontal'>"
		  								+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearSyjpos("+allTrafficCount+")' value='清空'>"
		  								+"</li></div></TD>"
		  								+"</TR></TBODY></TABLE></td></tr></table></td></tr>";

		  		allTrafficCount++;						
	  		}
	  		
	  		if("${po.sopipglasstype }" == "7"){
		  c1.innerHTML=c1.innerHTML+"<tr id="+rowadd+"tr><td><input type='hidden' name='inspectionPos["+Subtr(1,listindex)+"].sopipglasstype' value='7'/>"
		  								+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yy'><TR>"
		  								+"<TD colspan='14' style='height:20px' class='PrivateBorderGreen' bgcolor='dfffdf'><p>视觉训练&nbsp;&nbsp;&nbsp;"
		  								+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn  title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'><br></p></TD>	</TR><TR>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'>&nbsp;</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>球镜</div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>柱镜</div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>轴向</div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>三棱镜</div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>基底</div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用瞳距(mm)</div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用瞳距(mm)</div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>远用VA</div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>近用VA</div></TD>"
		  								+"</TR><TBODY><TR><TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OD</TD>"
		  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input needChange='needChange' yyorder='1' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassod' value='${po.sopipballglassod}' class='text_input' size='4'></div></TD>"
		  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input  needChange='needChange' yyorder='2' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassod' value='${po.sopippostglassod}' class='text_input cyl' size='4'></div></TD>"
		  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input axes='axes' yyorder='3' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesod' value='${po.sopipaxesod}' class='text_input axes' size='4'></div></TD>"
		  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input yyorder='4' ljxj='ljxj' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassod1' value='${po.sopiparriseglassod1}' class='text_input' size='4'></div></TD>"
		  								+"<TD width='6%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<select yyorder='5' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisod1'>"
     									+"<option value='' selected></option>"
                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
	                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
	                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisod1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
	                                     +" </c:if>"	                                      	
                                         +"</c:forEach>"
		  								+"</select></div></TD><TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input yyorder='6' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighod' class='text_input' size='4' value='${po.sopipinterhighod}'></div></TD>"
		  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceod' value='${po.sopipinterdistanceod}' class='text_input' size='4'></div></TD>"
		  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input yyorder='7' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaod' value='${po.sopipfarvaod}' class='text_input' size='4'></div></TD>"
		  								+"<TD width='8%' bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaod' value='${po.sopipclosevaod}' class='text_input' size='4'></div></TD>"
		  								+"</TR><TR>"
		  								+"<TD width='11%' bgcolor='#DFFFDF' class='PrivateBorderGreen'>OS</TD><TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input needChange='needChange' yyorder='8' sph='sph' name='inspectionPos["+Subtr(1,listindex)+"].sopipballglassos' value='${po.sopipballglassos}' class='text_input' size='4'></div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input needChange='needChange' yyorder='9' cyl='cyl' name='inspectionPos["+Subtr(1,listindex)+"].sopippostglassos' value='${po.sopippostglassos}' class='text_input' size='4'></div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input axes='axes' yyorder='10' name='inspectionPos["+Subtr(1,listindex)+"].sopipaxesos' value='${po.sopipaxesos}' class='text_input' size='4'></div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input ljxj='ljxj' yyorder='11' name='inspectionPos["+Subtr(1,listindex)+"].sopiparriseglassos1' value='${po.sopiparriseglassos1}' class='text_input' size='4'></div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<select yyorder='12' name='inspectionPos["+Subtr(1,listindex)+"].sopipbasisos1'>"
     									+"<option value='' selected></option>"
                                        +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
	                                     +" <c:if test='${optionParamPoTmp.fopparentid==\'24\'}'>"
	                                     +" 	<option value='${optionParamPoTmp.fopparamid }' ${po.sopipbasisos1 == optionParamPoTmp.fopparamid ? 'selected=selected' : '' }>${optionParamPoTmp.fopparamname}</option>"
	                                     +" </c:if>"	                                      	
                                         +"</c:forEach>"		  								
		  								+"</select></div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input yyorder='13' tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterhighos' class='text_input' size='4' value='${po.sopipinterhighos}'></div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input tongju='tongju' name='inspectionPos["+Subtr(1,listindex)+"].sopipinterdistanceos' value='${po.sopipinterdistanceos}' class='text_input' size='4'></div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input yyorder='14' va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipfarvaos' class='text_input' size='4' value='${po.sopipfarvaos}'></div></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'>"
		  								+"<input va='va' name='inspectionPos["+Subtr(1,listindex)+"].sopipclosevaos' class='text_input' size='4' value='${po.sopipclosevaos}'></div></TD></TR><TR>"
		  								+"<TD colspan='6' bgcolor='#DFFFDF' class='PrivateBorderGreen'><li class='horizontal'><div align='center'>家庭训练："
		  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopipfamilytrain' id='cc1.commendglasses' size='12' readOnly value='${po.sopipfamilytrain}'></div></li><li class='horizontal'>"
		  								+"<div align='center'>"
		  								+"<img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='xlopen("+allTrafficCount+","+xzindex+");' title='选择'>"
		  								+"</div></li><li class='horizontal'>"
		  								+"<div align='center'>"
		  								+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearxl("+allTrafficCount+")' title='清空'></div></li>"
		  								+"<li class='horizontal'><div align='center'>训练室训练："
		  								+"<INPUT name='inspectionPos["+Subtr(1,listindex)+"].sopiptrainroom' id='sopiptrainroom' size='12' readOnly value='${po.sopiptrainroom}'>"
		  								+"</div></li><li class='horizontal'>"
		  								+"<div align='center'>"
		  								+"<img name='xzbutton' id='xzbutton' src='${ctx }/img/newbtn/btn_change_0.png' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_change_0.png');\" btn=btn onClick='xlsopen("+allTrafficCount+","+xzindex+");' title='选择'>"
		  								+"</div></li><li class='horizontal'>"
		  								+"<div align='center'>"
		  								+"<img onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_empty_0.png');\" src='${ctx }/img/newbtn/btn_empty_0.png' btn=btn  name='button23' onClick='clearxls("+allTrafficCount+")' title='清空'>"
		  								+"</div></li></TD>"
		  								+"<TD bgcolor='#DFFFDF' class='PrivateBorderGreen'><div align='center'><div align='right'>备注:</div></TD>"
		  								+"<TD colspan='3' bgcolor='#DFFFDF' class='PrivateBorderGreen'>"
		  								+"<textarea name='inspectionPos["+Subtr(1,listindex)+"].sopipdignosisre'>${po.sopipdignosisre}</textarea></TD></TR></TBODY></TABLE></td></tr>";
		  		allTrafficCount++;	
		  }
		  if("${po.sopipglasstype }" == "4" || "${po.sopipglasstype }" == "6"){
		  	xzindex = xzindex+2;
		  }else{
		  	xzindex = xzindex+1;
		  }		  
		  rowadd++;
		  allTrafficCount++;
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
  	  inspectionOnload();
  	  inspectionCheck();
  	}
  
  	function deletechufang(obj,listindex){ 
  		//$(listindex).parent().parent().parent().parent().parent().parent().parent().remove();
  		$(listindex).parent().parent().parent().parent().parent().remove();
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
  
  	function cornealContactlLens(){
		$("img").removeAttr("onclick");
		inspectionForm.action="cornealContactlLensToolBjtr.action?source=cornealContactlLensu";
		inspectionForm.submit();
	}
	
	function xlopen(glassType,xzindex){
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWindowInspectionStealOpen.action?setwhich=sopipfamily&categoryID_open=9&glassType="+glassType+"&xzindex="+xzindex,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWindowInspectionStealOpen.action?setwhich=sopipfamily&categoryID_open=9&glassType="+glassType+"&xzindex="+xzindex,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【视光查询】";
	}
	function clearxl(glassType){
		$('input[name=inspectionPos['+Subtr(1,glassType)+'].sopipfamilytrain]').val('');
	}
	function setxl(json){
		$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopipfamilytrain]').val(json.goodsName);
	}
	
	function xlsopen(glassType,xzindex){
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWindowInspectionStealOpen.action?setwhich=sopiptrainroom&categoryID_open=9&glassType="+glassType+"&xzindex="+xzindex,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initWindowInspectionStealOpen.action?setwhich=sopiptrainroom&categoryID_open=9&glassType="+glassType+"&xzindex="+xzindex,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【视光查询】";
	}
	function clearxls(glassType){
		$('input[name=inspectionPos['+Subtr(1,glassType)+'].sopiptrainroom]').val('');
	}
	function setxls(json){
		$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopiptrainroom]').val(json.goodsName);
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
	    }
	    document.getElementById('popupTitle').innerHTML="【隐形适用镜片查询】";
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
<input type="hidden" name="inspectionPo.sopipusername"  value="${inspectionPos[0].sopipusername}"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
						<TBODY>
						<TR><!--ťStart-->	
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
												  UNSELECTABLE="on">相关检查</TD>
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
										  
										  		<c:if test="${requestScope.chuyanfuyan == '1'}">
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
													src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="cornealContactlLens()" 
												  background=${ctx}/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">角膜接触镜复查</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  </c:if>
												
												
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
						<s:action name="initCustomerOptometryTitleBjtr" executeResult="true" />									
						<br>
                        	<fieldset>
							<legend>眼睛健康评估</legend>
                            							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><table width="99%" 
                  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
									<tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">屈光不正：近视眼
									    <SELECT id="sopipneareye" name="inspectionPo.sopipneareye" style=" width:120;">
                                         <option value="" selected></option>
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      <c:if test="${optionParamPoTmp.fopparentid=='44'}">
	                                      	<option value="${optionParamPoTmp.fopparamid }" ${(inspectionPos[0].sopipneareye == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
	                                      </c:if>	                                      	
	                                     </c:forEach>
	                                    </select>
									  &nbsp;
									 远视眼：
									 <SELECT id="sopipseccheckdate" name="inspectionPo.sopipfareye" style=" width:120;">
	                                          <option value="" selected></option>
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='45'}">
			                                      	<option value="${optionParamPoTmp.fopparamid }" ${(inspectionPos[0].sopipfareye == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                      </c:if>	                                      	
		                                      </c:forEach>
		                                    </select>
									  &nbsp;
									 散光：
									  <SELECT id="sopipastigmia" name="inspectionPo.sopipastigmia" style=" width:120;">
	                                          <option value="" selected></option>
	                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                      <c:if test="${optionParamPoTmp.fopparentid=='46'}">
			                                      	<option value="${optionParamPoTmp.fopparamid }" ${(inspectionPos[0].sopipastigmia == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                      </c:if>	                                      	
		                                      </c:forEach>
		                                    </select>
									  &nbsp;</li>
									</td>
								  </tr>
                                  							  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
									 双眼视功能评估：
									 <c:set value="${ fn:split(inspectionPo.sopipestimate, ',') }" var="str" />   
								     <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" > 
							   			<c:if test="${optionParamPoTmp.fopparentid=='47'}">
								   		<c:set value="" var="checkStr" />
								   		<c:forEach items="${ str }" var="s">
								   			<c:if test="${fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)}">
								   				<c:set value="checked=checked" var="checkStr" />
								   			</c:if>									          											
  										</c:forEach> 																			   		 
								   		<input name="inspectionPo.sopipestimate" type="checkbox" ${checkStr}  value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}
                                     	</c:if>	                                      	
                                     </c:forEach> 
									 &nbsp;</li>
									</td>
								  </tr>
                                  </tbody>
                                  </table>
								</td>
								</tr>
								</table>
								</fieldset>
								<br>
                        						<fieldset>
							<legend>建议矫正方案</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><table width="99%" 
                  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                  <tbody>
								  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
									框架眼镜：
									 <c:set value="${ fn:split(inspectionPo.sopipglasstypes, ',') }" var="str" />   
								     <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" > 
							   			<c:if test="${optionParamPoTmp.fopparentid=='48'}">
								   		<c:set value="" var="checkStr" />
								   		<c:forEach items="${ str }" var="s">
								   			<c:if test="${fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)}">
								   				<c:set value="checked=checked" var="checkStr" />
								   			</c:if>									          											
  										</c:forEach> 																			   		 
								   		<input name="inspectionPo.sopipglasstypes" type="checkbox" ${checkStr}  value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}
                                     	</c:if>	                                      	
                                     </c:forEach>  									
									</td>
								  </tr>
								  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
									 	角膜接触镜：
									 <c:set value="${ fn:split(inspectionPo.sopiptouchglass, ',') }" var="str" />   
								     <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" > 
							   			<c:if test="${optionParamPoTmp.fopparentid=='49'}">
								   		<c:set value="" var="checkStr" />
								   		<c:forEach items="${ str }" var="s">
								   			<c:if test="${fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)}">
								   				<c:set value="checked=checked" var="checkStr" />
								   			</c:if>									          											
  										</c:forEach> 																			   		 
								   		<input name="inspectionPo.sopiptouchglass" type="checkbox" ${checkStr}  value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}
                                     	</c:if>	                                      	
                                     </c:forEach> 									 	
									</td>
								  </tr>
								  								  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom"><li class="horizontal">
 										视觉训练：
									 <c:set value="${ fn:split(inspectionPo.sopiptraintypes, ',') }" var="str" />   
								     <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" > 
							   			<c:if test="${optionParamPoTmp.fopparentid=='50'}">
								   		<c:set value="" var="checkStr" />
								   		<c:forEach items="${ str }" var="s">
								   			<c:if test="${fn:trim(s) == fn:trim(optionParamPoTmp.fopparamid)}">
								   				<c:set value="checked=checked" var="checkStr" />
								   			</c:if>									          											
  										</c:forEach> 																			   		 
								   		<input name="inspectionPo.sopiptraintypes" type="checkbox" ${checkStr}  value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}
                                     	</c:if>	                                      	
                                     </c:forEach> 	 										
                                     </td>
								  </tr>
									</tbody>

                                </table>
								</td>
								</tr>
								</table>
								</fieldset>										
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
											<option value="6">角膜塑形</option>
											<option value="7">视觉训练</option>
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

                                    <TR align="center">
                                    <TD height="30" bgcolor="#E8F8FF"><div align="right" class="PrivateBorder">
                                      	戴镜方式：
									  <SELECT id="sopiptaketype" name="inspectionPo.sopiptaketype" style=" width:120;">
	                                       <option value="" selected></option>
	                                       <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                     <c:if test="${optionParamPoTmp.fopparentid=='56'}">
		                                     	<option value="${optionParamPoTmp.fopparamid }" ${(inspectionPos[0].sopiptaketype == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                     </c:if>	                                      	
	                                       </c:forEach>
	                                    </select>
                                    </div>
                                    </TD>
                                      <TD height="30" bgcolor="#E8F8FF"><div align="left" class="PrivateBorder">复诊时间：
                                          <input id="sopipseccheckdate" name="inspectionPo.sopipseccheckdate" value="${inspectionPos[0].sopipseccheckdate }" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm'})" class="text_input120">
                                          </div>
                                      </TD>
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