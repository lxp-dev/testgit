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

.PrivateBorderYellow{
	border: 1px solid #F5E25C;
}

.salesout{
background:transparent;border:0px;
}
-->
</style>
<script type="text/javascript">
	/*
	*填写邮寄信息
	*/
	function toMailInsert(salseID ,smecimemberid ,smeciname ,smeciphone ){
		if($('#smeciname').val() != ''){
			showPopWin("","initToMailInsert.action?salseID="+salseID+"&smecimemberid="+smecimemberid+"&smeciname="+smeciname+"&smeciphone="+smeciphone,screen.width-200,screen.height-200, '',null,true);
			selectHidden();
		}else{
			alert("请选择顾客！");
		}
	}

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
	
	function toRound(){
		var frm = window.parent.frames;
		for (var i=0; i < frm.length; i++){
			if(frm(i).name=='hiddenTop'){
				frm(i).toTop();
			}
			if(frm(i).name=='centerframe'){
				frm(i).toLeft();
			}
			if(frm(i).name=='top'){
				frm(i).toReload();
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
	function details(id){
		showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
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
	
	function addGlassGoods(direction, materialType){
		
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		//球镜   sph
		//柱镜  cyl
	 	//下加 add
		//checkbox  name=materialType  右眼树脂value='shuzhi'玻璃 value='boli' 
		var sph = '';
		var cyl = '';
		var add = '';
		var syjp='';
			// 翻方子
			
	    if($('input[name$="ssesbballglassod"]')[0].value==''&&direction=='R'){
			alert('请填写右眼球镜!');
			return;
		}
		if($('input[name$="ssesbballglassos"]')[0].value==''&&direction=='L'){
			alert('请填写左眼球镜!');
			return;
		}
//		try{
//			$('tr[id=copyrow]').each(function(){
//					
//				if($(this).find('input[name=salesDetailPo.ssesdglassflags]')[0].value=='R'&&direction=='R'){
//						alert('右眼隐形镜片数量过多!');
//						throw '1';
//				}
//				if($(this).find('input[name=salesDetailPo.ssesdglassflags]')[0].value=='L'&&direction=='L'){
//						alert('左眼隐形镜片数量过多!');
//						throw '1';
//				}
//		});
//		}catch(e){
//			return;
//		}
		turnPrescription($('input[name$="ssesbballglassod"]')[0]
				, $('input[name$="ssesbpostglassod"]')[0]
				, $('input[name$="ssesbaxesod"]')[0]);
		turnPrescription($('input[name$="ssesbballglassos"]')[0]
				, $('input[name$="ssesbpostglassos"]')[0]
				, $('input[name$="ssesbaxesos"]')[0]);
				
		sph = (direction == 'R') ? $('input[name$="ssesbballglassod"]')[0] : $('input[name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? $('input[name$="ssesbpostglassod"]')[0] : $('input[name$="ssesbpostglassos"]')[0];				
		syjp = (direction == 'R') ? $('input[name=syjp]')[0] : $('input[name=syjp]')[1];
		
		showPopWin("","initConLensSel.action?sph="+sph.value+"&cyl="+cyl.value+"&glassFlag=" + direction+"&syjp="+EncodeUtf8(syjp.value),screen.width-200,screen.height-200, '', null, true);
		selectHidden();
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
	$('[name=salesBasicPo.ssesbsalerid]').val($('#ssesbsalerid').val());
	var frm = window.parent.frames;
		for (var i=0; i < frm.length; i++){
			if(frm(i).name=='hiddenTop'){
				frm(i).toTop();
			}
			if(frm(i).name=='centerframe'){
				frm(i).toLeft();
			}
			if(frm(i).name=='top'){
				frm(i).toReload();
			}
		}
		// 球镜、柱镜
		$("input[sphcyl='sphcyl']").each(function(){
		 	$(this).bind('blur',function(){
				checkData(this);
			});
		});
	
	
		
		//验证轴向
		$("input[axes='axes']").each(function(){
		 	$(this).bind('blur',function(){
				checkAxiss(this);
			});
		});
		
		//初始化页面下拉列表选中
		$('#ssesblocation').attr('value','${person.departmentID}');
		
		//订做方式。
		$('#ssesbtakeglasstype').change(function(){
			calculate($(this).val());
		});
		
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
		
		
	    //回车事件
		$(':input[yyorder]').each(function(){
				$(this).unbind("keydown");
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('yyorder');
						$(':input[yyorder='+accAdd(index,1)+']').focus();
					}
				});
			});
	});
	
	function inspection(obj){
		$('input[needChange=needChange]').each(function(){
			$(this).unbind("keydown");
		});
		var json = obj;
		$('#inspectionid').val(json.sopipinspectionid);
		$('#ssesboptid').val(json.sopipoptometrybasicid);
		$('#ssesboptometryid').val(json.sopipoptometryid);
		$('input[name=salesBasicPo\\.ssesbballglassod]')[0].value=json.sopipballglassod;
		$('input[name=salesBasicPo\\.ssesbballglassos]')[0].value=json.sopipballglassos;
		$('input[name=salesBasicPo\\.ssesbpostglassod]')[0].value=json.sopippostglassod;
		$('input[name=salesBasicPo\\.ssesbpostglassos]')[0].value=json.sopippostglassos;
		$('input[name=salesBasicPo\\.ssesbaxesod]')[0].value=json.sopipaxesod;
		$('input[name=salesBasicPo\\.ssesbaxesos]')[0].value=json.sopipaxesos;
		$('input[name=salesBasicPo\\.ssesbeyecurvatureod1]')[0].value=json.sopipeyecurvatureod1;
		$('input[name=salesBasicPo\\.ssesbeyecurvatureod2]')[0].value=json.sopipeyecurvatureod2;
		$('input[name=salesBasicPo\\.ssesbeyecurvatureos1]')[0].value=json.sopipeyecurvatureos1;
		$('input[name=salesBasicPo\\.ssesbeyecurvatureos2]')[0].value=json.sopipeyecurvatureos2;
		$('input[name=salesBasicPo\\.ssesbdiameterod]')[0].value=json.sopipdiameterod;
		$('input[name=salesBasicPo\\.ssesbdiameteros]')[0].value=json.sopipdiameteros;
		$('input[name=salesBasicPo\\.ssesbconlenvaod]')[0].value=json.sopipconlenvaod;
		$('input[name=salesBasicPo\\.ssesbconlenvaos]')[0].value=json.sopipconlenvaos;
		$('input[name=syjp]')[0].value=json.sopipcommendglasses.split(',')[0].trim();
			$('input[name=syjp]')[1].value=json.sopipcommendglasses.split(',')[1].trim();
		$('input[name=syjpnum]')[0].value=json.sopipconlenodnum;
		$('input[name=syjpnum]')[1].value=json.sopipconlenosnum;
		$('#chufang1').find('input').each(function(){
			$(this).attr('readonly','readonly');
		});		
		
		$('#jyhly').text(json.sopipcommendcardwater);
	}
	
	function clearValue(){
		$('#chufang1').find('input[name!=syjp][name!=syjpnum]').each(function(){
			$(this).removeAttr('readonly');
			$(this).val('');
		});
		
		$('input[name=syjp]').each(function(){
			$(this).val('');
		});
		$('input[name=syjpnum]').each(function(){
			$(this).val('');
		});
		
		$('input[needChange=needChange]').each(function(){
			$(this).bind("keydown",function(){
				changeFocus(this);
			});
		});
		
		$('#ssesboptid').val('');
		$('#ssesboptometryid').val('');
		$('#inspectionid').val('');
		
		$('#jyhly').text('');
	}
	/*
	添加商品
	*/
	var glassOD='';
	var glassOS='';
	var frame='';
	var bgiordercycle=0//订做周期
	function addGoods(json){
			
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
//        		alert("新增行数："+$('#copyrow+tr').size());
//                 alert(j);
        	    $('input[name=rownumber]')[j].value=j;
        	  }
        	}
//        	if($('#copyrow+tr').size()==1)
//       	{
//        		$('input[name=rownumber]')[1].value="1";
//	      	}
//	      	if($('#copyrow+tr').size()==2)
//        	{
//        		$('input[name=rownumber]')[1].value="1";
//       			$('input[name=rownumber]')[2].value="2";
//        	}
        			
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
	         
	        var ssje=parseData(Math.round(accMul(goodsdiscount,json.bgiretailprice)*10)/10);

	       	var zkje=parseData(Subtr(ssje,json.bgiretailprice));
	       	
			$('input[name=salesBasicPo\\.ssesbdiscountnum]')[0].value=zkje;
	        $('input[name=salesDetailPo\\.ssesddiscountnums]').get(index).value=zkje;
	        $('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value=ssje;
	        $('input[name=salesDetailPo\\.ssesdsalesvalues]').get(index).value=ssje;
	        if(json.glassflag=='R'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="隐形右眼镜片";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="4";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="R";
	        	  $('input[name=orderCycle]').get(index).value=json.bgiordercycle;
	        }else if(json.glassflag=='L'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="隐形左眼镜片";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="4";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="L";
	        	  $('input[name=orderCycle]').get(index).value=json.bgiordercycle;
	        }else if(json.glassflag==undefined){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="隐形辅料";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="5";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }
	        
	        $('input[name=salesDetailPo\\.iscustomizes]').get(index).value=json.bgiiscustomize;
	        $('input[name=salesDetailPo\\.ssesditemids]').get(index).value=json.bgigoodsbarcode;
	        
	        //各种金额计算
	        /*
	        	原价合计
	        */
	         $('#yjje').text("￥"+accAdd($('#yjje').text().replace('￥',''),json.bgiretailprice).toFixed(2));
	         $('input[name=salesBasicPo\\.ssesbpricesum]')[0].value= $('#yjje').text().replace('￥','');

	        /*
	        	应收金额合计
	        */
	        var ssjeTotal=0;
	       $('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
	       		ssjeTotal=accAdd($(this).val(),ssjeTotal);
	       });
	       ssjeTotal=parseData(accAdd(ssjeTotal,fujiafei));
	      
	       
	       $('#ysje').text("￥"+ssjeTotal);
	       $('#ssje').text("￥"+ssjeTotal);
	       $('#sesbpsalsvalue').val(ssjeTotal);
	       $('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value= $('#ysje').text().replace('￥','');
	       	/*
	        	折扣金额合计
	        */
	        var zkjeTotal=0;
	  
	      	zkjeTotal=parseData(accAdd($('#yjje').text().replace('￥',''),'-'+$('#ysje').text().replace('￥','')));
	      
	       $('#zkje').text("￥"+zkjeTotal);
	         $('input[name=salesBasicPo\\.ssesbdiscountnum]')[0].value= $('#ysje').text().replace('￥','');
	         
	         	/*
		应收金额重新赋值
		*/
		var ysjinehejiTotal = 0 ;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			 ysjinehejiTotal=accAdd($(this).val(),ysjinehejiTotal);
		});
		var ysjinehejiTotalCount="￥"+parseData(ysjinehejiTotal,fujiafei);
		$('#ysje').text(ysjinehejiTotalCount);
		$('#ssje').text(ysjinehejiTotalCount);
		$('#sesbpsalsvalue').val(ysjinehejiTotalCount.replace('￥',''));
		
		/*
		折扣金额重新赋值
		*/
		var zhekoujinehejiTotal = 0 ;
		$('input[name=salesDetailPo\\.ssesddiscountnums]').each(function(){
			 zhekoujinehejiTotal=accAdd($(this).val(),zhekoujinehejiTotal);
		});
		//alert(zhekoujinehejiTotal);
		//var zkje=parseData(accAdd(zhekoujinehejiTotal,'-'+ysje.replace('￥','')));
		$('#zkje').text("￥"+parseData(zhekoujinehejiTotal));
	         
			// alert(json.bgiordercycle);
	       // alert(bgiordercycle);
	       // alert(json.glassflag);
	         if(json.bgiordercycle!=''){
	         	if(json.bgiordercycle>bgiordercycle){
	         		bgiordercycle=parseInt(json.bgiordercycle);
	         		calculate(bgiordercycle);
	         	}
	         }else if(bgiordercycle==0&&json.bgiordercycle==''&&json.glassflag!=undefined){
	        	
	         		calculateHours(0);//成品片取景时间加0小时
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
		
	 	
	    $('#ssesbtakeglassdata').val(uValue+' '+vHour+':'+vMin);
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
        	
        	
        	//各种金额计算
        	/*fujiafei=accAdd(fujiafei,$('#additionalCosts').val().split(',')[1]);
	         $('#yjje').text("￥"+accAdd($('#yjje').text().replace('￥',''),$('#additionalCosts').val().split(',')[1])+".00");
	         var ysje=accAdd($('#ysje').text().replace('￥',''),$('#additionalCosts').val().split(',')[1])+"";
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
	         $('#ysje').text("￥"+ysje);
	          $('#ssje').text("￥"+ysje);
	         $('#sesbpsalsvalue').val(ysje);
	         $('input[name=salesBasicPo\\.ssesbpricesum]').val( $('#yjje').text().replace('￥',''));*/
	          /*
			应收金额
			*/
			var num=0;
			$('input[name=salesDetailPo\\.ssesdpricesums]').each(function(){
				num=accAdd($(this).val(),num);
			});
			var yjje="￥"+parseFloat(accAdd(num,fujiafei)).toFixed(2);
	         $('#yjje').text(yjje);
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
	       var ysje=accAdd(ssjeTotal,fujiafei).toFixed(2);
	         $('#ysje').text("￥"+ysje);
	         $('#ssje').text("￥"+ysje);
	         $('#sesbpsalsvalue').val(ysje);
	         $('input[name=salesBasicPo\\.ssesbpricesum]').val( $('#yjje').text().replace('￥',''));
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
	结算
	*/
	function save(){
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		if($('tr[id=copyrow]').size()==1){
			alert('请先选择商品!');
			return;
		}
		for(var i=1;i<document.getElementsByName('salesDetailPo.ssesdnumbers').length;i++){
			if(document.getElementsByName('salesDetailPo.ssesdnumbers')[i].value==''){
				alert('请输入商品数量!');
				document.getElementsByName('salesDetailPo.ssesdnumbers')[i].focus();
				return;
			}
		}
		if($('#ssesbtakeglassdata').val()==''){
			alert('请选择取镜日期!');
			return;
		}
		
		var odsyjpnum=$('input[name=syjpnum]')[0].value;
		var ossyjpnum=$('input[name=syjpnum]')[1].value;
		if(odsyjpnum!=''&&odsyjpnum!=0||ossyjpnum!=''&&ossyjpnum!=0){
			try{
				$('tr[id=copyrow]').each(function(){
					if($(this).find('input[name=salesDetailPo.ssesdglassflags]')[0].value=='R'){
						if(parseFloat(odsyjpnum)>parseFloat($(this).find('input[name=salesDetailPo.ssesdnumbers]')[0].value)){
							$(this).find('input[name=salesDetailPo.ssesdnumbers]')[0].focus();
							alert('右眼隐形镜片数量不能低于适用镜片数量!');
							throw '1';
						}
					}
					if($(this).find('input[name=salesDetailPo.ssesdglassflags]')[0].value=='L'){
						if(parseFloat(ossyjpnum)>parseFloat($(this).find('input[name=salesDetailPo.ssesdnumbers]')[0].value)){
						$(this).find('input[name=salesDetailPo.ssesdnumbers]')[0].focus();
							alert('左眼隐形数量不能低于适用镜片数量!');
							throw '1';
						}
					}
			});
			}catch(e){
				return;
			}
		}
		var count=0;
		var jyhly=$('#jyhly').text().split(';');
		var names=document.getElementsByName('salesDetailPo.ssesdsalesitemnames');
		for(var i=0;i<jyhly.length;i++){
			for(var j=0;j<names.length;j++){
				if(jyhly[i]==names[j].value){
					count++;
				}
			}
		}
		
		if(count!=jyhly.length){
			alert('请选择建议护理液!');
			return;
		}
		if(!confirm("确认提交此销售单吗?")){
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
		if(checkForm(document.all.conSalesForm)){ 
			//提交
			$("img").removeAttr("onclick");
			conSalesForm.action="conSalse.action";
			conSalesForm.submit();
		}
	}
	
	// 添加天数
	function addDaysToDate(days) {
		
	}
	
	/*
	删除商品行时清除一单一副所用的全局变量,重新计算
	*/
	function deleteVar1(item){
		
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
		$('#zkje').text("￥"+parseData(Subtr($(item).parent().parent().parent().find('td .zksum').val(),$('#zkje').text().replace('￥',''))+""));
		var yjhjTotal=0;
		$('input[name=salesDetailPo\\.ssesdpricesums]').each(function(){
			yjhjTotal=accAdd($(this).val(),yjhjTotal);
		});
		
		$('#yjje').text("￥"+parseData(accAdd(fujiafei,yjhjTotal)));
//		alert("删除行数后："+$('#copyrow+tr').size());
		for(var i=0;$('#copyrow+tr').size()>=i;i++)
       	{
       	  for(var j=0;i>=j;j++)
       	  {
       	    $('input[name=rownumber]')[j+1].value=j+1;
       	  }
       	}
		$('input[id=td10t]').val("0");
       	amount();
//		if($('#copyrow+tr').size()==0)
//       	{
//        		$('input[name=rownumber]')[1].value="1";
//	      	}
//	      	if($('#copyrow+tr').size()==1)
//        	{
//        		$('input[name=rownumber]')[1].value="1";
//       			$('input[name=rownumber]')[2].value="2";
//       	}
		
	}
	
	/*
	删除附加费重新计算f
	*/
	function deleteVar2(item){
		var fjfy='-'+$(item).parent().parent().parent().find('td .fjfya').val();
		$('#yjje').text("￥"+accAdd($('#yjje').text().replace('￥',''),fjfy)+".00");
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
		showPopWin("","initPersonDiscountSelect.action",screen.width-600,screen.height-500, '', null, true);
		selectHidden();
	}
	/*
	整单打折开窗回调
	*/
	function setDiscount1(discount,discounttype,discountperson){//2012/2/2 零折
		$('input[name=salesBasicPo\\.ssesbdiscountrate]').val(discount);
		
		
		$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
		$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折

		/*
		total重新赋值
		*/
		var yjhjTotal=0;
		$('input[name=salesDetailPo\\.ssesdpricesums]').each(function(){
			yjhjTotal=accAdd($(this).val(),yjhjTotal);
		});
		var ysje="￥"+parseData(accAdd(parseData(Math.round(eval(accMul(discount,yjhjTotal))*10)/10),fujiafei));
		$('#ysje').text(ysje);
		$('#ssje').text(ysje);
		$('#sesbpsalsvalue').val(ysje.replace('￥',''));
		var zkje=parseData(accAdd(yjhjTotal,'-'+ysje.replace('￥','')));
		$('#zkje').text("￥"+parseData(accAdd(zkje,fujiafei)));
		
		/*
		折率重新赋值 
		*/
		$('input[name=salesDetailPo\\.ssesddiscountrates]').each(function(){
			$(this).val(discount);
		});
		
		/*
		应收金额重新赋值
		*/
		
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
	
			 $(this).val(parseData(Math.round(eval( accMul($(this).parent().parent().find('.yjje').val(),$(this).parent().parent().find('.number').val()))*eval(discount)*10)/10));
			 
			//$(this).val(parseData(accMul(accMul($(this).parent().parent().find('.yjje').val(),$(this).parent().parent().find('.number').val()),discount)));
		});
		/*
		折扣金额重新赋值
		*/
		
		$('input[name=salesDetailPo\\.ssesddiscountnums]').each(function(){
			$(this).val(parseData(accMul(accMul($(this).parent().parent().find('.yjje').val(),$(this).parent().parent().find('.number').val()),accAdd('1','-'+discount))));
		});
		
		/*
		应收金额重新赋值
		*/
		var ysjinehejiTotal=0;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			  //ysjinehejiTotal=parseFloat(accAdd(parseFloat($(this).val()).toFixed(1),parseFloat(ysjinehejiTotal).toFixed(1)));
			 ysjinehejiTotal=accAdd($(this).val(),ysjinehejiTotal);
		});
		 if(isNaN(ysjinehejiTotal))
		 {
		   ysjinehejiTotal=0;
		 }
		 //alert(ysjinehejiTotal);
		var ysjinehejiTotalCount="￥"+parseData(ysjinehejiTotal,fujiafei);
		$('#ysje').text(ysjinehejiTotalCount);
		$('#ssje').text(ysjinehejiTotalCount);
		$('#sesbpsalsvalue').val(ysjinehejiTotalCount.replace('￥',''));
		
		/*
		折扣金额重新赋值
		*/
		var zhekoujinehejiTotal = 0 ;
		$('input[name=salesDetailPo\\.ssesddiscountnums]').each(function(){
			 zhekoujinehejiTotal=accAdd($(this).val(),zhekoujinehejiTotal);
		});
		 if(isNaN(zhekoujinehejiTotal))
		 {
		   zhekoujinehejiTotal=0;
		 }
		//var zkje=parseData(accAdd(zhekoujinehejiTotal,'-'+ysje.replace('￥','')));
		$('#zkje').text("￥"+parseData(zhekoujinehejiTotal));
		
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
	/*
	单品打折
	*/
	function discount2(item){

		showPopWin("","initPersonDiscountSelect.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),screen.width-600,screen.height-500, '', null, true);
		selectHidden();
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
		ysje=parseData(Math.round(eval(accMul(yjhj,discount2))*10)/10);
		
		$('tr[id=copyrow]').find(".yssum")[rownumber].value=ysje;
		/*
			折扣率重新赋值
		*/
		$('tr[id=copyrow]').find(".discountrate")[rownumber].value=discount2;
		/*
			折扣金额重新赋值
		*/
		$('tr[id=copyrow]').find(".zksum")[rownumber].value=parseData(Subtr(ysje,yjhj));
		
		//alert(Subtr(ysje,yjhj));
		/*
			total重新赋值
		*/
		var ysjeTotal=0;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			ysjeTotal=accAdd(ysjeTotal,$(this).val());
		});
		document.getElementById('ysje').innerText="￥"+parseData(accAdd(ysjeTotal,fujiafei));
		document.getElementById('ssje').innerText="￥"+parseData(accAdd(ysjeTotal,fujiafei));
		$('#sesbpsalsvalue').val(parseData(accAdd(ysjeTotal,fujiafei)));
		var yjTotal=accAdd($('#yjje').text().replace('￥',''),'-'+fujiafei);
		document.getElementById('zkje').innerText="￥"+parseData(accAdd(yjTotal,'-'+ysjeTotal));
		///////////////////////////////////////////////////////////////////////////////////////////
		/*
		应收金额重新赋值
		*/
		var ysjinehejiTotal = 0 ;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			 ysjinehejiTotal=accAdd($(this).val(),ysjinehejiTotal);
			 ysjinehejiTotal=parseFloat(ysjinehejiTotal).toFixed(1);
		});
		//alert(ysjinehejiTotal);
		var ysjinehejiTotalCount="￥"+parseData(ysjinehejiTotal,fujiafei);
		$('#ysje').text(ysjinehejiTotalCount);
		$('#ssje').text(ysjinehejiTotalCount);
		$('#sesbpsalsvalue').val(ysjinehejiTotalCount.replace('￥',''));
		
		/*
		折扣金额重新赋值
		*/
		var zhekoujinehejiTotal = 0 ;
		$('input[name=salesDetailPo\\.ssesddiscountnums]').each(function(){
			 zhekoujinehejiTotal=accAdd($(this).val(),zhekoujinehejiTotal);
			 zhekoujinehejiTotal=parseFloat(zhekoujinehejiTotal).toFixed(1);
		});	
		$('#zkje').text("￥"+parseData(zhekoujinehejiTotal));
		
		
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
	/*
		更改商品数量
	*/
	function changeNumber(item){
	
		if(isNaN($(item).val())){
			alert('数量格式不正确!');
			$(item).val('');
			$(item).focus();
			return;
		}else if(parseFloat($(item).val())<=0){
			alert('数量不能小于等于零!');
			$(item).val('');
			$(item).focus();
			return;
		}
		var rownumber=$(item).parent().parent().find(".rownumber").val();
		
		
		//明细行重新赋值
		/*
			应收金额重新赋值
		*/
		var ysje=$('tr[id=copyrow]').find(".yssum")[rownumber].value;//应收
		var yjhj=$('tr[id=copyrow]').find(".pricesum")[rownumber].value//合计
		var yjje=$('tr[id=copyrow]').find(".yjje")[rownumber].value; //单价
		
		var discountrate=$('tr[id=copyrow]').find(".discountrate")[rownumber].value;
		
		$('tr[id=copyrow]').find(".yssum")[rownumber].value=parseData(Math.round(accMul(accMul(yjje,$(item).val()),discountrate)*10)/10);
		//alert(discountrate);
		$('tr[id=copyrow]').find(".pricesum")[rownumber].value=parseData(accMul(yjje,$(item).val()));
		/*
			折扣金额重新赋值
		*/
		$('tr[id=copyrow]').find(".zksum")[rownumber].value=parseData(Subtr($('tr[id=copyrow]').find(".yssum")[rownumber].value,$('tr[id=copyrow]').find(".pricesum")[rownumber].value));
		/*
			total重新赋值
		*/
		
		var yjhjTotal=0;
		$('input[name=salesDetailPo\\.ssesdpricesums]').each(function(){
			yjhjTotal=accAdd(yjhjTotal,$(this).val());
		});
		$('#yjje').text("￥"+parseData(yjhjTotal));
		var ysjeTotal=0;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			ysjeTotal=accAdd(ysjeTotal,$(this).val());
		});
		document.getElementById('ysje').innerText="￥"+parseData(accAdd(ysjeTotal,fujiafei));
		document.getElementById('ssje').innerText="￥"+parseData(accAdd(ysjeTotal,fujiafei));
		$('#sesbpsalsvalue').val(parseData(accAdd(ysjeTotal,fujiafei)));
		var yjTotal=accAdd($('#yjje').text().replace('￥',''),'-'+fujiafei);
		document.getElementById('zkje').innerText="￥"+parseData(accAdd(yjTotal,'-'+ysjeTotal));
		
		///////////////////////////////////////////////////////////////////////////////////////////
		/*
		应收金额重新赋值
		*/
		var ysjinehejiTotal = 0 ;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			 ysjinehejiTotal=accAdd($(this).val(),ysjinehejiTotal);
		});
		var ysjinehejiTotalCount="￥"+parseData(ysjinehejiTotal,fujiafei);
		$('#ysje').text(ysjinehejiTotalCount);
		$('#ssje').text(ysjinehejiTotalCount);
		$('#sesbpsalsvalue').val(ysjinehejiTotalCount.replace('￥',''));
		
		/*
		折扣金额重新赋值
		*/
		var zhekoujinehejiTotal = 0 ;
		$('input[name=salesDetailPo\\.ssesddiscountnums]').each(function(){
			 zhekoujinehejiTotal=accAdd($(this).val(),zhekoujinehejiTotal);
		});
		//alert(zhekoujinehejiTotal);
		//var zkje=parseData(accAdd(zhekoujinehejiTotal,'-'+ysje.replace('￥','')));
		$('#zkje').text("￥"+parseData(zhekoujinehejiTotal));
	}
	function addFuliao(){
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		showPopWin("","initContactAccessoriesSel.action",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	function salesout(item){
		$(item).addClass('salesout');
	}
	function salesover(item){
		$(item).removeClass('salesout');
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
		var fcnrenumber = $('#fcnrenumber').val();
		if (parseFloat(fcnrenumber).toFixed(2) < parseFloat(obj.value)){
            alert("抹零金额应小于等于"+fcnrenumber+"!");
            $('input[name=salesBasicPo.ssesbrenums]').val('0');
            $('input[id=td10t]').val("0");
            $('span[vid=td4t]').text('￥0.00');
        }
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
</script>
<BODY bgColor=#ffffff topMargin=5  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="conSalesForm" method="post">
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
		<!-- ͷ˵ Start -->
		  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TBODY>
			  <TR>
				<TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>销售管理</TD>
				<TD class=menubar_readme_text vAlign=bottom></TD>
			  </TR>
			  <TR>
				<TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：隐形销售</TD>
				<TD class=menubar_function_text align=right>&nbsp;</TD>
			  </TR>
			  <TR>
				<TD colSpan=2 height=5></TD>
			  </TR>
			</TBODY>
		  </TABLE>
		<!-- ͷ˵ End -->
		<!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
			<TR>
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx }/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
											<TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>
												  <TD width=3><IMG id=tabImgLeft__0 height=22 
													src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
												  <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx }/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">隐形</TD>
												  <TD width=3><IMG id=tabImgRight__0 height=22 
													src="${ctx }/img/pic/tab_active_right.gif" 
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
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
						<fieldset>
							<legend>顾客资料</legend>
							<table width="98%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
							  <tr>
								<td height="30" bgcolor="#cadee8">
								<li class="horizontal">卡号&nbsp;<input id="smecimemberid" name="customerInfoPo.smecimemberid" 
																	value="${customerInfoPo.smecimemberid }" onkeyup="selectCustomer();" class="text_input100" size="6">
								</li>								
								<li class="horizontal"><input type="button" value='查找' icon='icon-search' onclick="selCustomer();" ></li>
								<li class="horizontal">姓名<input class="text_input60" size="2" id="smeciname" name="customerInfoPo.smeciname" value="${customerInfoPo.smeciname }" readOnly="readOnly">
								</li>
								<li class="horizontal">性别<input class="text_input20" size="2" value="${not empty(customerInfoPo.smecisex) ? (customerInfoPo.smecisex == '0' ? '男' : '女') : ''}" readOnly="readOnly">
								</li>
								<li class="horizontal">年龄<input class="text_input40" size="2" value="${customerInfoPo.fmmdown }" readOnly="readOnly">
								</li>
								<li class="horizontal">折扣<input class="text_input40" id="titlediscount" size="2" value="${customerInfoPo.fmmdiscount }" readOnly="readOnly">
								</li>
								<li class="horizontal">积分<input class="text_input40" size="2" value="${customerInfoPo.smeciintegral }" readOnly="readOnly">
								</li>
								<li class="horizontal">&nbsp;
								  <input name="button32" type='button' value='详情' align="left" onClick="javascript:details('${customerInfoPo.smecicustomerid }');" ${empty(customerInfoPo.smecicustomerid) ? 'disabled="disabled"': ''  }>
								</li>
								<li id="saleserDiv" class="horizontal">&nbsp; 
									<input name="button32" id='saleser'  type='button' value="更换销售员" align="left" onclick="changeSaleser()">
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
								<th width="30%" height="30" align="center" class="table_body">处方类型</th>
                                <th height="30" align="center" class="table_body">验光师</th>
                                <th height="30" align="center" class="table_body">验光时间</th>
                                <th height="30" align="center" class="table_body">选择</th> 
                              </tr>
                              
                              <c:if test="${not empty(inspectionPos)}">
                              	<c:forEach var="po" items="${inspectionPos}">
                              		<tr>
								<td width="30%" height="30" align="center" class="table_body">
									<c:choose>
										<c:when test="${po.sopipglasstype == '4' }">隐形</c:when>
									</c:choose>
								</td>
                                <td height="30" align="center" class="table_body">${po.sopipersonname }</td>
                                <td height="30" align="center" class="table_body">${fn:substring(po.sopiptime, 0, 16)}</td>
                                <td height="30" align="center" class="table_body">
                                	<input icon="icon-apply" id="" name="" type="button" value="选择" 
                                	onclick="inspection({'sopipinspectionid':'${po.sopipid }','sopipcustomerid':'${po.sopipcustomerid}',
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
								'sopipcommendcardwater':'${po.sopipcommendcardwater}'});$('#nwtype').val('1');" /></td> 
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
									<TD bgcolor="#CADEE8" width="85%" height="30" align="left" class="table_none">
									  	<li class="horizontal_onlyRight"><input icon="icon-retry" type='button' value='清空' onclick="clearValue();$('#nwtype').val('');" /></li>
								  	</TD>
							   </tr>
                     		</table>
	                        <table id="chufang1" width="98%" style="margin-bottom:3px;"  border=0 align=center cellpadding=1 cellspacing=1 class="Privateborder PrivateBorderPink" id="title2">
                             <tr>
							 	<td width="9%" height="25" bgcolor="#F8E0F0" class="PrivateBorderPink">&nbsp;</td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">球镜</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">柱镜</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">轴向</div></td>
								<td colspan="2" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">曲率</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">直径</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">隐形VA</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">适用镜片</div></td>
								<td width="10%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">片/盒数</div></td>
							 </tr>
							 <tr>
							 	<td height="25" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">OD</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="1" needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbballglassod" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="2"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbpostglassod" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="3" name="salesBasicPo.ssesbaxesod" axes="axes" class="text_input100" style="width:100%">
								</div></td>
								<td width="13%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="4" name="salesBasicPo.ssesbeyecurvatureod1"  class="text_input100" style="width:100%">
								</div></td>
								<td width="13%" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="5" name="salesBasicPo.ssesbeyecurvatureod2" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="6" name="salesBasicPo.ssesbdiameterod" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="7" name="salesBasicPo.ssesbconlenvaod" va="va" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="8" name="syjp" readonly="readonly" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="9" name="syjpnum" readonly="readonly" class="text_input100" style="width:100%">
								</div></td>
							 </tr>
							 <tr>
						 	   <td height="25" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">OS</div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="10"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbballglassos" class="text_input100" style="width:100%">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="11"  needChange="needChange" sphcyl="sphcyl" name="salesBasicPo.ssesbpostglassos" class="text_input100" style="width:100%">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="12" name="salesBasicPo.ssesbaxesos" axes="axes" class="text_input100" style="width:100%">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="13" name="salesBasicPo.ssesbeyecurvatureos1" class="text_input100" style="width:100%">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="14" name="salesBasicPo.ssesbeyecurvatureos2" class="text_input100" style="width:100%">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="15" name="salesBasicPo.ssesbdiameteros"  class="text_input100" style="width:100%">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
							     <input yyorder="16" name="salesBasicPo.ssesbconlenvaos" va="va" class="text_input100" style="width:100%">
							   </div></td>
							   <td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="17" name="syjp" readonly="readonly" class="text_input100" style="width:100%">
								</div></td>
								<td bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">
								  <input yyorder="18" name="syjpnum" readonly="readonly" class="text_input100" style="width:100%">
								</div></td>
							 </tr>
							 <tr>
							  <td height="25" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="center">建议护理液</div></td>
						 	<td colspan="9" bgcolor="#F8E0F0" class="PrivateBorderPink"><div align="left">
							     <span id="jyhly"></span>
							   </div></td>
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
	                                     <td width="10%" height="70" bgcolor="#000000"><div align="right" class="STYLE5">原价合计: </div></td>
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
								  		
                                          <td height="40" colspan="9" class="Privateborder">
                                          
                                          	<li class="horizontal_onlyRight">取镜方式：
                                            <select name="ssesbtakeglasstype" id="ssesbtakeglasstype" onchange="addDaysToDate()">
                                              <option value="0" selected="selected">正常</option>
                                              <option value="7" >订做7</option>
                                              <option value="10" >订做10</option>
                                              <option value="15" >订做15</option>
                                              <option value="25" >订做25</option>
                                            </select></li>
                                            <li class="horizontal_onlyRight">&nbsp;&nbsp;&nbsp;&nbsp;取镜日期：
                                              <input id="ssesbtakeglassdata"
					       	name="salesBasicPo.ssesbtakeglassdata" 
					       type="text" class="text_input120" 
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d'})"
					      /> </li>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <li class="horizontal_onlyRight">
	                                            <div>
		                                            <input type="button" id="toMailInsert" name="toMailInsert" value="填写邮寄信息" onclick="toMailInsert('${salseID }','${customerInfoPo.smecimemberid }','${customerInfoPo.smeciname }','${customerInfoPo.smeciphone }')">
	 											</div>
 											</li></td>
                                          
                                          <td rowspan="2" class="Privateborder"><div align="center">
                                            <input id="buttonsave" name="button" type='button' value="    结  算    " onclick="save()" icon='icon-delete-row' >
                                          </div></td>
                                      
								  </tr>
								  <tr>
								  		
                                          <td height="40" colspan="9" class="Privateborder">
                                     
                                          	取镜地点：
                                            <select id="ssesblocation" name="salesBasicPo.ssesblocation">
                                                	<s:iterator value="departmentsList" >
                                                		 <option value="${bdpdepartmentid }">${bdpdepartmentname}</option>
                                                	</s:iterator>
                                                </select>
                                            &nbsp;&nbsp;&nbsp;&nbsp;实收金额：
                                            <input name="salesBasicPo.ssesbpsalsvalue" id='sesbpsalsvalue' class="text_input" size="8">
                                           &nbsp;&nbsp;&nbsp;&nbsp;整单打折:<input size="8" name="salesBasicPo.ssesbdiscountrate"  class="text_input"  type="text"  onclick="discount1()" readonly="readonly">
                                            &nbsp;&nbsp;&nbsp;&nbsp;抹零金额：<input size="8" id="td10t" class="text_input"  type="text"  onkeydown="changeMolingAmount(this)">&nbsp;<font color="red">抹零请按回车键</font>
                                            <c:forEach var="po" items="${discountShortcutKeysPolist}">
                                           		&nbsp;<input id="${po.fdkid} }" name="${po.fdkid}" type="button" value="${po.fdkkeyname}" onclick="setDiscount1('${po.fdkkeyvalues}','${person.id}','1')"/>
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
                            <td width="29%" valign="top">
							<fieldset>
							<legend>选择商品</legend>
							<table width="98%" border="0" cellpadding="1" cellspacing="1">
                              <tr>
                                <td class="table_body">右眼</td>
                                <td colspan="3" class="table_none"><div align="right">
                                  <input name="button2232" type='button' value='选择' icon='icon-Search' onClick="addGlassGoods('R','')">
                                </div></td>
                              </tr>
                              <tr>
                                <td class="table_body">左眼</td>
                                <td colspan="3" class="table_none"><div align="right">
                                  <input name="button2233" type='button' value='选择' icon='icon-Search' onClick="addGlassGoods('L','')">
                                </div></td>
                              </tr>
                              <tr>
                                <td class="table_body">辅料</td>
                                <td colspan="3" class="table_none"><div align="right">
                                  <input name="button2234" type='button' value='选择' icon='icon-Search' onClick="addFuliao()">
                                </div></td>
                                </tr>
                               <tr>
                                <td class="table_body">附加费用</td>
                                <td colspan="2" class="table_none">
								<select id="additionalCosts" name="additionalCosts">
								  <option>----请选择----</option>
								  <s:iterator value="additionalCostsList">
								  <option value="${facid},${facamount}">${facname}</option>
								  </s:iterator>
								</select></td>
                                <td class="table_none"><input name="button22332" type='button' value='选择' icon='icon-Search' onclick="addCosts(this)"></td>
                              </tr>
                               <tr>
                             <td width="100%" valign="top" colspan="4">
                             <table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                        <tr>
                                        <td height="25" bgcolor="#CADEE8" class="Privateborder">附加费名称</td>
                                        <td height="25" bgcolor="#CADEE8" class="Privateborder">金额</td>
                                        <td height="25" bgcolor="#CADEE8" class="Privateborder">数量</td>
                                        <td height="25" bgcolor="#CADEE8" class="Privateborder">合计</td>
                                        <td height="25" bgcolor="#CADEE8" class="Privateborder">删除</td>
                                      </tr>
                                      <tr style="display:none" id="copyrowCosts">
                                        <td width="35%" class="table_none"><span id="costs"></span><input type="hidden" name="additionalCostsPo.facname">
                                        <input type="hidden" name="additionalCDetailPo.sseadditionalid"><BR></td>
                                        <td width="15%" class="table_none"><span id="costsMoney"></span><input class="fjfy" type="hidden" name="additionalCostsPo.facamount"><BR></td>
                                        <td width="15%" class="table_none"><input type="text" size="8" class="text_input60 number" id="0" name="additionalCDetailPo.ssenumber" onblur="addCosts(this)" validate=""><BR></td>
                                        <td width="20%" class="table_none"><span id="amountMoney"></span><input class="fjfya" type="hidden" id="amountMoney" name="amountMoney"></td>
                                        <td width="15%" class="Privateborder"><div align="center">
                                            <input name="button22432" type='button' value='删除' onclick="deleteItem(this);deleteVar2(this)" icon='icon-delete' >
                                        </div></td>
                                      </tr>
                                    </table></td>
                              </tr>
                            </table>
							</fieldset>
							</td>
							<td width="1%"></td>
                            <td width="70%" valign="top">
							<fieldset>
							<legend>选购商品</legend>
							<table id="goodsInfo" width="100%" height="154" border="0" cellpadding="1" cellspacing="1">
							
                              <tr>
                                <td valign="top"><table width="100%" border="0" cellpadding="1" cellspacing="1" class="Privateborder">
                                  <tr >
                                    <td width="10%" height="30" class="table_body"><div align="center">商品代码</div></td>
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
                                    <td  class="Privateborder"><input style="width: 42px;" onmouseover="salesover(this)" onmouseout="salesout(this)" title=""  name="salesDetailPo.ssesdnumbers" onblur="changeNumber(this)" class="text_inputhidden number salesout"></td>
                                    <td  class="Privateborder"><input style="width: 40px;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdpricesums" readonly="readonly" class="text_inputhidden pricesum"></td>
                                    <td  class="Privateborder"><input style="width: 40px;" onmouseover="salesover(this)" onmouseout="salesout(this)"  title=""  name="salesDetailPo.ssesddiscountrates" onclick="discount2(this)" readonly="readonly" class="text_inputhidden discountrate salesout" >
                                    	<input type="hidden" class="rownumber" name="rownumber"/>
                                    </td>
                                    <td  class="Privateborder"><input  style="width: 40px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesddiscountnums" readonly="readonly" class="text_inputhidden zksum"></td>
                                    <td  class="Privateborder"><input  style="width: 40px;background:transparent;border:0px;" title="" value="0.00" name="salesDetailPo.ssesdrenums" readonly="readonly" class="text_inputhidden resum"></td>
                                    <td  class="Privateborder"><input style="width: 40px;background:transparent;border:0px;"  title="" name="salesDetailPo.ssesdsalesvalues" readonly="readonly" class="text_inputhidden yssum"></td>
                                     <td  class="Privateborder"><input  style="width: 80px;" onmouseover="salesover(this)" onmouseout="salesout(this)" title=""  name="salesDetailPo.ssesdgooddescribes"  class="text_inputhidden salesout">
                                       <input type="hidden" name="salesDetailPo.ssesdcostsprives"/>
                                        <input type="hidden" name="salesDetailPo.ssesdunitprices"/>
                                      <input type="hidden" name="salesDetailPo.ssesditemids"/>
                                       <input type="hidden" name="salesDetailPo.ssesdunitprices"/>   <input type="hidden" name="salesDetailPo.iscustomizes"/><input type="hidden"  name="salesDetailPo.ssesdcommoditiesflags"/>
                                       <input type="hidden"  name="orderCycle"/>
                                     </td>
                                    <td width="6%" class="Privateborder"><div  align="center">
                                       <input type="hidden" class="cccc" name="salesDetailPo.ssesdglassflags"/>
                                       <input name="button224" type='button' value='删除'  icon='icon-delete' onclick="deleteItem(this);deleteVar1(this)">
                                       </div></td>
                                  </tr>
                                </table></td>
                                </tr><!--
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
	showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
	selectHidden();
}	
function selCustomer(){
	showPopWin("","initSelCustomerInfoWin.action", screen.width-200,screen.height-200, '',null,true);
	selectHidden();
}
function setCustomer(memberid){
	document.getElementById('smecimemberid').value = memberid;
	document.forms[0].submit();
}

</script>