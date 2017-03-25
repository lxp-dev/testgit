<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>接触镜评估</title>
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
	
	//按键改变数值
	function changeFocus1(obj)
	{
	    if(event.keyCode==38){
			if(obj.value == ''){
				obj.value='0.00';
			}
			else{
				if('${systemParameterPo.fspothernegative}'=='1'){
		   	    	if(parseFloat(obj.value)>=0||obj.value==''){
						return;
					}else{
				    	obj.value = (parseFloat(obj.value)+0.25).toFixed(2);		
					}
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
	
	
	//按键改变数值
	function changeFocusOther(obj,num)
	{
	    if(event.keyCode==38){
			if(obj.value == ''){
				obj.value="1.00";
			}
			else{
				if(parseFloat(obj.value) < num)
			    	obj.value = (parseFloat(obj.value)+1).toFixed(2);		
			}
		}
	    if(event.keyCode==40){
			if(obj.value == ''){
				obj.value = "1.00";
			}else{
				if(parseFloat(obj.value) != 1)
					obj.value = (parseFloat(obj.value)-1).toFixed(2);			
			}
		}
	}
	/*
	验证脚本
	*/
	function inspectionCheck(){
			$('input[cyl=cyl]').each(function(){
				$(this).bind("blur",function(){
					checkDataz(this);
					try{
						if('${systemParameterPo.fspothernegative}'=='1'){
				   	    	if(parseFloat($(this).val())>0){
								alert('柱镜不能为正!');
								$(this).val('');
								$(this).focus();
								throw '1';
							}
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
	//球镜、柱镜
	var re1 = /^[\+\-]?[0-9]{1,2}([.]{1}[0-9]{1,2})?$/;
	
	//视力
	//var re2 = /^[0-9]{1}([.]{1}[0-9]{1,2})(\+|-)?$/;
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
		}else {
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
			
		    if('${systemParameterPo.fspothernegative}'=='1'){
	   	    	if(obj.value > 0){
					obj.value = '-' + obj.value;
				}
	      	}else{
	    		if(obj.value > 0){
					obj.value = '+' + obj.value;
				}
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
	//视力补零
	function vaAddZero(obj) {
		if (obj.value.indexOf(".") == -1) {
			obj.value += ".0";
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
	function inspectionCopy(){
		location.href="inspectionCopyAier.action?chuyanfuyan="+'${chuyanfuyan}'+"&oldOptometryID="+'${oldOptometryID}'+"&customerID="+'${customerID }'+"&optometryBasicID="+'${copyBasicOptometryID}'+"&moduleID="+'${moduleID}'+"&optometryID="+'${optometryID}';
		selectHidden();
	}
	var f1;
	function yymove(type){ //远用回车一动
		$(':input[yyorder]').each(function(){
			$(this).keydown(f1=function f1(){
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
	
	var f2;
	function jjmove(){ //近用回车一动
		$(':input[jjorder]').each(function(){
				$(this).keydown(f2=function f2(){
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
	
	var f3;
	function jjsgmove(){ //渐进双光回车一动
		$(':input[jjsgorder]').each(function(){
			$(this).keydown(f3=function f3(){
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
	function displayTable1(obj){
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
			//$(this).unbind('keydown',f1);
			//$(this).unbind('keydown',f2);
			//$(this).unbind('keydown',f3);
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
	}

	function save(){

		var isSubmit = 1;	
		
		
		contactGlassForm.action="contactGlassInsertAier.action?ruleFlag=0&nw='N'";
		contactGlassForm.submit();	
		
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
	

	function inspectionOnloadNew(){
		yqjod=document.all.ballOD.value;
		yadod=document.all.sadOD.value;
		yqjos=document.all.ballOS.value;
		yados=document.all.sadOS.value;
		var myValue = document.getElementById('glassType').value;
		for(var i = 0;i<Subtr(1,allTrafficCount);i++){
			if(yadod){
				if(accAdd(parseFloat(yqjod),yadod) > 0){
					$('[name*=sopipballglassod][jy=jy]').val("+"+accAdd(parseFloat(yqjod),yadod).toFixed(2));
				}else{
					$('[name*=sopipballglassod][jy=jy]').val(accAdd(parseFloat(yqjod),yadod).toFixed(2));
				}
			}
		}
		
		for(var i = 0;i<Subtr(1,allTrafficCount);i++){
			if(yados){
				if(accAdd(parseFloat(yqjos),yados) > 0){
					$('[name*=sopipballglassos][jy=jy]').val("+"+accAdd(parseFloat(yqjos),yados).toFixed(2));
				}else{
					$('[name*=sopipballglassos][jy=jy]').val(accAdd(parseFloat(yqjos),yados).toFixed(2));
				}
			}
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
		//inspectionOnload();
		//inspectionCheck();
		//searchButton();
	});
	function doubleEyeFun(){
		contactGlassForm.action="doubleEyeFunToolAier.action?source=doubleeyefuniou";
		$("img").removeAttr("onclick");
		contactGlassForm.submit();
	}
	function syjp(glassType,goodsCategoryID,xzindex){ //适用镜片开窗
		showPopWin("","initWindowInspectionNormalOpen.action?glassType="+glassType+"&goodscategoryID="+goodsCategoryID+"&xzindex="+xzindex,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
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
			showPopWin("","initWindowInspectionOtherOpen.action?categoryID_open=4&glassType="+glassType+"&goodscategoryID="+goodsCategoryID+"&sopipballglass="+sopipballglassod+"&sopippostglass="+sopippostglassod+"&xzindex="+xzindex+"&side="+side,screen.width-200,screen.height-200, '',null,true);
			selectHidden();
	    }else if (side == '2'){
	       	sopipballglassos = $('input[name=inspectionPos['+Subtr(1,glassType)+'].sopipballglassos]')[0].value;
	        sopippostglassos = $('input[name=inspectionPos['+Subtr(1,glassType)+'].sopippostglassos]')[0].value;
	        if (sopippostglassos == ""){
	            sopippostglassos = 0;
	        }
			showPopWin("","initWindowInspectionOtherOpen.action?categoryID_open=4&glassType="+glassType+"&goodscategoryID="+goodsCategoryID+"&sopipballglass="+sopipballglassos+"&sopippostglass="+sopippostglassos+"&xzindex="+xzindex+"&side="+side,screen.width-200,screen.height-200, '',null,true);
			selectHidden();
	    }
	}
	
	function openGoodSingleValues(json){   //适用镜片回调赋值
		$('input[name=inspectionPos['+Subtr(1,json.glassType)+'].sopipcommendglasses]')[Subtr(1,json.side)].value=json.brandName;
	}
	function jyhly(){ //建议护理液开窗
		showPopWin("","initWindowInspectionStealOpen.action?categoryID_open=5",screen.width-200,screen.height-200, '',null,true);
		selectHidden();
	}
	function clearSyjp(glassType){
		$('input[name=inspectionPos['+glassType+'].sopipcommendglasses]').val('');
	}

	function clearSyjpod(glassType){
		$('input[syjpod='+glassType+']').val('');
	}

	function clearSyjpos(glassType){
		$('input[syjpos='+glassType+']').val('');
	}
	
	function specialCheck() {
		contactGlassForm.action="specialCheckToolAier.action?source=specialcheckiou";
		$("img").removeAttr("onclick");
		contactGlassForm.submit();
	}
	
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
	
	
	function refractive(){
		contactGlassForm.action="refractiveToolAier.action?source=refractiveiou";
		$("img").removeAttr("onclick");
		contactGlassForm.submit();
	}
	function inspection(){		
		$("img").removeAttr("onclick");
		contactGlassForm.action="inspectionToolAier.action?source=inspectioniou";
		contactGlassForm.submit();
	}
	
	function glassHistory(){
		if('${customerInfoPo.smecicustomerid }'==''){
			alert('请输入顾客卡号!');
			return;
		}
		contactGlassForm.action="selectGlassesHistoryAier.action?customerID="+'${customerInfoPo.smecicustomerid }';
		contactGlassForm.submit();
	}
	
  allTrafficCount=1   
  allCount=1  
  rowadd = 1;
  xzindex = 0;
  enternum = 0;
  function  displayTable()   //增加一行   
  {   
  	  var type = $("input[name=contactGlassPo.sopcgtype]:checked").val();
  	  var str = "";
      newRow=trafficeList.insertRow(trafficeList.rows.length);   
      newRow.id="tradt";   
      newRow.ln=allTrafficCount;   
         
      c1=newRow.insertCell(0);   
      c1.id="tradtRow";   
      c1.ln=allCount;   
	  var listindex = allTrafficCount;
      str=str+"<tr id="+rowadd+"tr><td>"
		+"<TABLE width='99%' border=0 align=center cellPadding=1 cellSpacing=1 class='privateTable' id='yy'>"        					
			+"<TR>"
				+"<TD colspan='12' class='Privateborder' style='height:10px' bgcolor='#FFFFFF' >"
				+"<input type='hidden' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgindex' value='a'>"
				+"<p>试戴&nbsp;&nbsp;<img align='right' onmouseover=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_1.png');\" onmouseout=\"JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_delete_0.png');\" src='${ctx }/img/newbtn/btn_delete_0.png' btn=btn title='删除' ln="+allTrafficCount+" onclick='javascript:deletechufang(1,this);'></p></TD></TR>"         						
					+"<TR><TD bgcolor='#DFFFDF' class='table_body'>&nbsp;</TD><TD bgcolor='#DFFFDF' class='table_body'><div align='center'>品种</div></TD>"
						+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>基弧</div></TD>"
						+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>屈光度</div></TD>";
						if(type == '2'){
							str=str+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>降度</div></TD>"
						}
						str=str+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>直径</div></TD>"
						+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>追加</div></TD>"
						+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>VA</div></TD>"
						+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>定位</div></TD>"
						+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>活动度 </div></TD>"
						if(type == '0'){
							str=str+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>覆盖</div></TD>"
						}else if(type == '1'){
							str=str+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>边翘</div></TD>"
						}else if(type == '2'){
							str=str+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>工作区</div></TD>"
						}
						str=str+"<TD bgcolor='#DFFFDF' class='table_body'><div align='center'>建议</div></TD></TR>"
					+"<TR><TD width='11%' bgcolor='#DFFFDF' class='table_body'>OD</TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input needChange='needChange' yyorder='1'  sph='sph' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgbrandod' onKeyPress='EnterDown(this)' value='' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgbasecurveod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input cyl' size='4'></div></TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input   axes='axes' yyorder='3' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgdiopterod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input axes' size='4'></div></TD>"
						if(type == '2'){
							str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgdegradeod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4' value=''></div></TD>"
						}
						str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgdiameterod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input' size='4' value=''></div></TD>"  							
						+"<TD bgcolor='#DFFFDF' class='table_body'>"
							+"<input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgadditionalod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4' value=''>"
							+"<input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgcylod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4' value=''>"
							+"<input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgaxeod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4' value=''>"
						+"</TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgvaod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4'></div></TD>"
						+"<TD width='6%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='5' name='contactGlassPos["+Subtr(1,listindex)+"].sopcglocationod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
							+"<option value='' selected></option>"
                          +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                           +" <c:if test='${optionParamPoTmp.fopparentid==\'38\'}'>"
                           +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                           +" </c:if>"	                                      	
                        +"</c:forEach>"
							+"</select></div></TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='6' tongju='tongju' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgactivityod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
								+"<option value='' selected></option>"
                              +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                               +" <c:if test='${optionParamPoTmp.fopparentid==\'39\'}'>"
                               +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                               +" </c:if>"	                                      	
                            +"</c:forEach>"
							+"</select></div></TD>"
						if(type == '0'){
							str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='6' tongju='tongju' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgzerodifferenceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
							+"<option value='' selected></option>"
                          +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                           +" <c:if test='${optionParamPoTmp.fopparentid==\'40\'}'>"
                           +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                           +" </c:if>"	                                      	
                        +"</c:forEach>"
                           +"</select></div></TD>";
						}else if(type == '1'){
							str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='6' tongju='tongju' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgzerodifferenceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
							+"<option value='' selected></option>"
                          +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                           +" <c:if test='${optionParamPoTmp.fopparentid==\'42\'}'>"
                           +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                           +" </c:if>"	                                      	
                        +"</c:forEach>"
                           +"</select></div></TD>";
						}else if(type == '2'){
							str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='6' tongju='tongju' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgzerodifferenceod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
							+"<option value='' selected></option>"
                          +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                           +" <c:if test='${optionParamPoTmp.fopparentid==\'43\'}'>"
                           +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                           +" </c:if>"	                                      	
                        +"</c:forEach>"
                           +"</select></div></TD>";
						}
						str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='7' va='va' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgsuggestionsod' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
						+"<option value='' selected></option>"
                      +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                       +" <c:if test='${optionParamPoTmp.fopparentid==\'41\'}'>"
                       +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                       +" </c:if>"	                                      	
                    +"</c:forEach>"
							+"</select></div></TD></TR>"    
					+"<TR><TD width='11%' bgcolor='#DFFFDF' class='table_body'>OS</TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input needChange='needChange' yyorder='1'  sph='sph' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgbrandos' onKeyPress='EnterDown(this)' value='' enter='enter"+(enternum++)+"' class='text_input' size='4'></div></TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input  needChange='needChange' yyorder='2' cyl='cyl' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgbasecurveos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input cyl' size='4'></div></TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input   axes='axes' yyorder='3' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgdiopteros' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"' class='text_input axes' size='4'></div></TD>"
						if(type == '2'){
							str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgdegradeos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4' value=''></div></TD>"
						}
						str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgdiameteros' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input' size='4' value=''></div></TD>"       							
						+"<TD bgcolor='#DFFFDF' class='table_body'>"
							+"<input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgadditionalos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4' value=''>"
							+"<input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgcylos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4' value=''>"
							+"<input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgaxeos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4' value=''>"
						+"</TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><input yyorder='4' ljxj='ljxj' value='' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgvaos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'  class='text_input60' size='4'></div></TD>"
						+"<TD width='6%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='5' name='contactGlassPos["+Subtr(1,listindex)+"].sopcglocationos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
						+"<option value='' selected></option>"
                      +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                       +" <c:if test='${optionParamPoTmp.fopparentid==\'38\'}'>"
                       +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                       +" </c:if>"	                                      	
                    +"</c:forEach>"
							+"</select></div></TD>"
						+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='6' tongju='tongju' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgactivityos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
						+"<option value='' selected></option>"
                      +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                       +" <c:if test='${optionParamPoTmp.fopparentid==\'39\'}'>"
                       +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                       +" </c:if>"	                                      	
                    +"</c:forEach>"
							+"</select></div></TD>"
						if(type == '0'){
							str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='6' tongju='tongju' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgzerodifferenceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
							+"<option value='' selected></option>"
                          +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                           +" <c:if test='${optionParamPoTmp.fopparentid==\'40\'}'>"
                           +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                           +" </c:if>"	                                      	
                        +"</c:forEach>"
                           +"</select></div></TD>";
						}else if(type == '1'){
							str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='6' tongju='tongju' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgzerodifferenceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
							+"<option value='' selected></option>"
                          +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                           +" <c:if test='${optionParamPoTmp.fopparentid==\'42\'}'>"
                           +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                           +" </c:if>"	                                      	
                        +"</c:forEach>"
                           +"</select></div></TD>";
						}else if(type == '2'){
							str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='6' tongju='tongju' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgzerodifferenceos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
							+"<option value='' selected></option>"
                          +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                           +" <c:if test='${optionParamPoTmp.fopparentid==\'43\'}'>"
                           +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                           +" </c:if>"	                                      	
                        +"</c:forEach>"
                           +"</select></div></TD>";
						}
						str=str+"<TD width='8%' bgcolor='#DFFFDF' class='table_body'><div align='center'><select yyorder='7' va='va' name='contactGlassPos["+Subtr(1,listindex)+"].sopcgsuggestionsos' onKeyPress='EnterDown(this)' enter='enter"+(enternum++)+"'>"
						+"<option value='' selected></option>"
                      +"<c:forEach var='optionParamPoTmp' items='${optionParamPolist}' >"
                       +" <c:if test='${optionParamPoTmp.fopparentid==\'41\'}'>"
                       +" 	<option value='${optionParamPoTmp.fopparamid }'}>${optionParamPoTmp.fopparamname}</option>"
                       +" </c:if>"	                                      	
                    +"</c:forEach>"
							+"</select></div></TD></TR>"  		        							
		+"</TABLE>"
         				+"</td></tr>";				
	  c1.innerHTML=str;   					
	  rowadd++;
	  xzindex++;
      allTrafficCount++;   //总计多少行   
     
  }
								

	function deletechufang(obj,listindex){ 
  		$(listindex).parent().parent().parent().parent().parent().parent().parent().remove();
		allTrafficCount--;
        contactGlassForm.trafficCount.value = allTrafficCount;   
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
		contactGlassForm.action="cornealContactlLensToolAier.action?source=cornealContactlLensu";
		contactGlassForm.submit();
	}

	function fixingInterface(){
		$("img").removeAttr("onclick");
		contactGlassForm.action="fixingInterfaceToolAier.action";
		contactGlassForm.submit();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="contactGlassForm" method="post" action="">
<input type="hidden" name="customerID" value="${requestScope.customerID}" /> 
<input type="hidden" name="optometryBasicID"  value="${requestScope.optometryBasicID}" /> 
<input type="hidden" name="optometryID"  value="${requestScope.optometryID}" />  
<input type="hidden" name="chuyanfuyan"  value="${requestScope.chuyanfuyan}" />  
<input type="hidden" name="oldOptometryID"  value="${requestScope.oldOptometryID}" />
<input type="hidden" name="oldOptometryIDFirst"  value="${requestScope.oldOptometryIDFirst}" />  
<input type="hidden" name="moduleID"  value="${moduleID }"/>
<input type="hidden" name="ballOD"  value="${refractivePo.soprdbalballglassod}"/>
<input type="hidden" name="glassOD"  value="${refractivePo.soprdbalpostglassod}"/>
<input type="hidden" name="axesOD"  value="${refractivePo.soprdbalaxesod}"/>
<input type="hidden" name="sadOD"  value="${refractivePo.sopraddod }"/>
<input type="hidden" name="ballOS"  value="${refractivePo.soprdbalballglassos}"/>
<input type="hidden" name="glassOS"  value="${refractivePo.soprdbalpostglassos}"/>
<input type="hidden" name="axesOS"  value="${refractivePo.soprdbalaxesos}"/>
<input type="hidden" name="sadOS"  value="${refractivePo.sopraddos}"/>
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
												onclick="refractive()" 
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
												  UNSELECTABLE="on">接触镜评估</TD>
												  <TD width=3><IMG  id=tabImgRight__0 height=22 
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
													src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
												  onclick="inspection()" 
												  background=${ctx }/img/pic/tab_unactive_bg.gif 
												  UNSELECTABLE="on">检查结论</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
											</TD>

								    <c:if test="${permissionPo.keyh == '1'}">	  
										  <TD>
									 		<TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
											<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__1 height=22 
														src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__1 
													  onclick="fixingInterface()" 
													  background=${ctx }/img/pic/tab_unactive_bg.gif
													  UNSELECTABLE="on">验光设备接口</TD>
												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx }/img/pic/tab_unactive_right.gif" 
													width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
									</c:if>
																	
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
							<td align="right" style="PADDING-LEFT: 2px; HEIGHT: 22px"  background=${ctx }/img/pic/tab_top_bg.gif>
							</td>
						</TR>
        <TR>
          <TD bgColor=#ffffff colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
                		<input type="hidden" id="customerReadonly" name="customerReadonly" value="readOnly" />
						<s:action name="initCustomerOptometryTitleN" executeResult="true" />		
						<br>
				<fieldset>
				<legend>接触镜评估&nbsp;<input name="contactGlassPo.sopcgtryin" type="radio" value="0" checked="checked"  />&nbsp;试戴
								<input  name="contactGlassPo.sopcgtryin" type="radio" value="1" />
								&nbsp;顾客要求不试戴</legend>
								<div align="right"><img src="${ctx}/img/newbtn/btn_zjsd_0.png" btn=btn title="增加试戴" onClick="displayTable()"></div>
								<table  width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
									 <tbody>
									<tr class="trBlue">
										<td  height="30" class="table_body" align="center" >
											<input  name="contactGlassPo.sopcgtype" type="radio" value="0" checked="checked"/>
											&nbsp;软镜
											<input  name="contactGlassPo.sopcgtype" type="radio" value="1" />
											&nbsp;RGP
											<input  name="contactGlassPo.sopcgtype" type="radio" value="2" />
											&nbsp;角膜塑形镜
										</td>	
									</tr>
									</tbody>
									</table>
									<table id=trafficeList  width="100%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable">
									<tr><td></td></tr>   
                 				</table>
                 				<input type="hidden" name=trafficCount>
											                						
							
							
						</fieldset>	
						<br />
						<fieldset>
							<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
								<tbody>
									<tr bgcolor="#CADEE8" height="26px">
										<TD class="PrivateBorderBlue" width="10%">
										<div align="center">备注</div>
										</TD>
										<TD><textarea  id="sopcgremark" name="contactGlassPo.sopcgremark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]" style="width:100%" cols="80" rows="5">${fn:trim(contactGlassPo.sopcgremark) }</textarea></TD>
									</tr>
								</tbody>
							</table>
						</fieldset>
						
						
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                                            
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
                              <img src="${ctx}/img/newbtn/btn_reset_0.png" btn=btn title="重置" onclick="document.contactGlassForm.reset();">
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