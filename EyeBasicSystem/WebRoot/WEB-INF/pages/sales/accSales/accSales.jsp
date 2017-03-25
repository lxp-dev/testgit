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
	
	var param=2;//打折所舍位数 1保留至元2保留至毛
	
	function details(id){
		showPopWin("","initDetailsCustomerInfo.action?hid="+id,screen.width-200,screen.height-200, '',null,true);
		selectHidden();
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
		if($('#titlediscount').val()!=''){
			if(parseFloat($('#titlediscount').val())==1){
				$('#titlediscount').val('1.0');
			}else{
				$('#titlediscount').val('${customerInfoPo.fmmdiscount}');
			}
		}
		
		setDiscount1($('#titlediscount').val());
	})
	
	function salesout(item){
		$(item).addClass('salesout');
	}
	function salesover(item){
		$(item).removeClass('salesout');
	}
	
		
	
	
	/*
	添加商品
	*/
	var glassOD='';
	var glassOS='';
	var frame='';
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
        	    $('input[name=rownumber]')[j].value=j;
        	  }
        	}
 //       	if($('#copyrow+tr').size()==1)
 //       	{
 //       		$('input[name=rownumber]')[1].value="1"
//	      	}
//	      	if($('#copyrow+tr').size()==2)
//        	{
//        		$('input[name=rownumber]')[1].value="1";
//       			$('input[name=rownumber]')[2].value="2";
//        	}
//        	if($('#copyrow+tr').size()==3)
//        	{
//        		$('input[name=rownumber]')[1].value="1";
//      			$('input[name=rownumber]')[2].value="2";
//       			$('input[name=rownumber]')[3].value="3";
//        	}
//        	if($('#copyrow+tr').size()==4)
//        	{
//        		$('input[name=rownumber]')[1].value="1";
//       			$('input[name=rownumber]')[2].value="2";
//       			$('input[name=rownumber]')[3].value="3";
//       			$('input[name=rownumber]')[4].value="4";
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
	       	
			$('input[name=salesBasicPo.ssesbdiscountnum]')[0].value=zkje;
	        $('input[name=salesDetailPo\\.ssesddiscountnums]').get(index).value=zkje;
	        $('input[name=salesBasicPo.ssesbsalesvalue]')[0].value=ssje;
	        $('input[name=salesDetailPo\\.ssesdsalesvalues]').get(index).value=ssje;
	        if(category=='成镜'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="成镜";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="6";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(category=='镜架辅料'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="镜架辅料";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="2";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(category=='隐形辅料'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="隐形辅料";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="5";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(category=='其他商品'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="其他商品";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="7";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(category=='镜架'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="镜架";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="1";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
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
		
		//var zkje=parseData(accAdd(zhekoujinehejiTotal,'-'+ysje.replace('￥','')));
		$('#zkje').text("￥"+parseData(zhekoujinehejiTotal));
	}
 
 	function toZero(str){
		if(str.indexOf('.')==-1){
			return	"￥"+parseFloat(str.replace('￥','')).toFixed(2);
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
		
		$(item).parent().parent().parent().remove();
		
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
			if($('tr[id=copyrowCosts]').size()==1){
				alert('请选择商品!');
				return;
			}
		}
		for(var i=1;i<document.getElementsByName('salesDetailPo.ssesdnumbers').length;i++){
			if(document.getElementsByName('salesDetailPo.ssesdnumbers')[i].value==''){
				alert('请输入商品数量!');
				document.getElementsByName('salesDetailPo.ssesdnumbers')[i].focus();
				return;
			}
		}
		$('#ssesbpsalsvalue').val($('#ssje').text().replace('￥',''));
	
		if(!confirm("确认提交此销售单吗?")){
			return;
		}
		$('input[name=salesBasicPo\\.ssesbpricesum]')[0].value=$('#yjje').text().replace('￥','');
		$('input[name=salesBasicPo\\.ssesbdiscountnum]')[0].value=$('#zkje').text().replace('￥','');
		$('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value=$('#ysje').text().replace('￥','');
		if(checkForm(document.all.conSalesForm)){ 	
			$("img").removeAttr("onclick");
			//提交
			conSalesForm.action="accSalse.action";
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
		$('#ysje').text("￥"+parseData(ssjeTotal+""));
			$('#ssje').text("￥"+parseData(ssjeTotal));
			$('#sesbpsalsvalue').val(parseData(ssjeTotal));
			
		$('#zkje').text("￥"+parseData(accAdd($('#zkje').text().replace('￥',''),"-"+$(item).parent().parent().parent().find('td .zksum').val())+""));
		var yjhjTotal=0;
		$('input[name=salesDetailPo\\.ssesdpricesums]').each(function(){
			yjhjTotal=accAdd($(this).val(),yjhjTotal);
		});
		
		$('#yjje').text("￥"+parseData(accAdd(fujiafei,yjhjTotal)));
		
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
//        	{
//        		$('input[name=rownumber]')[1].value="1"
//	      	}
//	      	if($('#copyrow+tr').size()==1)
//        	{
//        		$('input[name=rownumber]')[1].value="1";
//       			$('input[name=rownumber]')[2].value="2";
//        	}
//        	if($('#copyrow+tr').size()==2)
//        	{
//        		$('input[name=rownumber]')[1].value="1";
//       			$('input[name=rownumber]')[2].value="2";
//       			$('input[name=rownumber]')[3].value="3";
//        	}
//       	if($('#copyrow+tr').size()==3)
//        	{
//        		$('input[name=rownumber]')[1].value="1";
//       			$('input[name=rownumber]')[2].value="2";
//       			$('input[name=rownumber]')[3].value="3";
//       			$('input[name=rownumber]')[4].value="4";
//        	}	
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
		//var floatnumber = 0;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			
			 //ysjinehejiTotal=parseFloat(accAdd(parseFloat($(this).val()).toFixed(1),parseFloat(ysjinehejiTotal).toFixed(1)));	
			 //if($(this).val().substring(floatnumber.indexof('.'),2))
			 //floatnumber=accAdd(parseFloat($(this).val().substring(floatnumber.indexof('.'),1),floatnumber);
			 //floatnumber=accAdd(parseFloat($(this).val()).toFixed(2),parseFloat(floatnumber).toFixed(2));
			 //alert(ysjinehejiTotal);
			 ysjinehejiTotal=accAdd($(this).val(),ysjinehejiTotal);
		});
		 if(isNaN(ysjinehejiTotal))
		 {
		   ysjinehejiTotal=0;
		 }
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
		$('#zkje').text("￥"+parseFloat(zhekoujinehejiTotal).toFixed(2));
		
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
		
		/*
			total重新赋值
		*/
		var ysjeTotal=0;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			ysjeTotal=accAdd(ysjeTotal,$(this).val());
		});
		document.getElementById('ysje').innerText="￥"+parseData(accAdd(ysjeTotal,fujiafei));
		document.getElementById('ssje').innerText="￥"+parseData(accAdd(ysjeTotal,fujiafei));
		var yjTotal=accAdd($('#yjje').text().replace('￥',''),'-'+fujiafei);
		document.getElementById('sesbpsalsvalue').innerText=parseData(accAdd(ysjeTotal,fujiafei));
		
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
		document.getElementById('sesbpsalsvalue').innerText=parseData(accAdd(ysjeTotal,fujiafei));
		
		var yjTotal=accAdd($('#yjje').text().replace('￥',''),'-'+fujiafei);
		document.getElementById('zkje').innerText="￥"+parseData(accAdd(yjTotal,'-'+ysjeTotal));
		/////////////////////////////////////////////////////////////////////////////////////////
		/*
		应收金额重新赋值
		*/
		var ysjinehejiTotal=0;
		$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
			
			 ysjinehejiTotal=accAdd($(this).val(),ysjinehejiTotal);		 
			 //alert(ysjinehejiTotal);
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
	}
	/*
	成镜
	*/
	function addFinished(){
	if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
	}
		showPopWin("","initFinishedGlassesSel.action",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	/*
	镜架辅料
	*/
	function addFrame(){
	if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		showPopWin("","initFramesAccessoriesSel.action",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	/*
	隐形辅料
	*/
	function addCon(){
	if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		showPopWin("","initContactAccessoriesSel.action",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	/*
	其他商品
	*/
	function addOther(){
	if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		showPopWin("","initWindowOtherGoodsSel.action",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	/*
	镜架
	*/
	function addJingjia(){
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		showPopWin("","initSellMirrorFrameSel.action",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	var category='';
	function setCategory(item){
		category=item;
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

</script>
<BODY bgColor=#ffffff topMargin=5  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="conSalesForm" method="post">
<input type="hidden" name="customerInfoPo.smecicustomerid" value="${customerInfoPo.smecicustomerid}"> 
<input id="ssesbrecipetype" type="hidden" name="salesBasicPo.ssesbrecipetype" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesboptid" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbarrearsvalue" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbcheckoutflag" value="" />
<input id="ssesboptid" type="hidden" name="salesBasicPo.ssesbvalueflag" value="" />
<input id="ssesboptometryid" type="hidden" name="salesBasicPo.ssesboptometryid" value="" />
<input type="hidden" name="salesBasicPo.ssesbpsalsvalue" id="ssesbpsalsvalue"/>
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
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
				<TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：辅料销售</TD>
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
												  UNSELECTABLE="on">辅料</TD>
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
								<li class="horizontal">姓名<input name="customerInfoPo.smeciname" class="text_input60" size="2" id="smeciname" value="${customerInfoPo.smeciname }" readOnly="readOnly">
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
							<legend>商品结算 </legend>
						<table width="100%" cellpadding="2" cellspacing="4" class="Privateborder">
							  <tr>
                                <td>
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
                                        
                                              	<li class="horizontal_onlyRight">实收金额：
                                              <input name="" readonly="readonly" id="sesbpsalsvalue" class="text_input" size="8"></li>
                                              &nbsp;&nbsp;&nbsp;&nbsp;<li class="horizontal_onlyRight">整单打折:<input size="8" name="salesBasicPo.ssesbdiscountrate"  class="text_input"  type="text"  onclick="discount1()" readonly="readonly"></li>
                                              &nbsp;&nbsp;&nbsp;&nbsp;<li class="horizontal_onlyRight">抹零金额：<input size="8" id="td10t" class="text_input"  type="text"  onkeydown="changeMolingAmount(this)">&nbsp;<font color="red">抹零请按回车键</font></li>
                                              &nbsp;&nbsp;&nbsp;&nbsp;<li class="horizontal_onlyRight">
	                                            <div>
		                                            <input type="button" id="toMailInsert" name="toMailInsert" value="填写邮寄信息" onclick="toMailInsert('${salseID }','${customerInfoPo.smecimemberid }','${customerInfoPo.smeciname }','${customerInfoPo.smeciphone }')">
	 											</div>
 											</li>
                                              <li class="horizontal_onlyRight"><c:forEach var="po" items="${discountShortcutKeysPolist}">
                                           		&nbsp;<input id="${po.fdkid} }" name="${po.fdkid}" type="button" value="${po.fdkkeyname}" onclick="setDiscount1('${po.fdkkeyvalues}','${person.id}','1')"/>
                                           	  </c:forEach></li>
                                              
                                              </td>
                                            	
                                            <td rowspan="2" class="Privateborder"><div align="center">
                                              <input id="saveButton" name="button" type='button' onclick="save()" value="    结  算    " icon='icon-delete-row' >
                                            </div></td>
                                       
										  </tr>
                                        </table></td>
									</tr>
								</table>								</td>
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
                                <td class="table_body">镜架</td>
                                <td colspan="3" class="table_none"><div align="right">
                                  <input name="button2232" type='button' value='选择' icon='icon-Search' onClick="addJingjia('jingjia')">
                                </div></td>
                                </tr>
							
                              <tr>
                                <td class="table_body">成镜</td>
                                <td colspan="3" class="table_none"><div align="right">
                                  <input name="button2232" type='button' value='选择' icon='icon-Search' onClick="addFinished('finished')">
                                </div></td>
                                </tr>
                              <tr>
                                <td class="table_body">镜架辅料</td>
                                <td colspan="3" class="table_none"><div align="right">
                                  <input name="button2232" type='button' value='选择' icon='icon-Search' onClick="addFrame('frame')">
                                </div></td>
                                </tr><tr>
                                <td class="table_body">隐形辅料</td>
                                <td colspan="3" class="table_none"><div align="right">
                                  <input name="button2232" type='button' value='选择' icon='icon-Search' onClick="addCon('con')">
                                </div></td>
                                </tr><tr>
                                <td class="table_body">其他商品</td>
                                <td colspan="3" class="table_none"><div align="right">
                                  <input name="button2232" type='button' value='选择' icon='icon-Search' onClick="addOther('other')">
                                </div></td>
                                </tr>
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
                                        <td width="40%" class="table_none"><span id="costs"></span><input type="hidden" name="additionalCostsPo.facname">
                                        <input type="hidden" name="additionalCDetailPo.sseadditionalid"><BR></td>
                                        <td width="40%" class="table_none"><span id="costsMoney"></span><input class="fjfy" type="hidden" name="additionalCostsPo.facamount"><BR></td>
                                        <td width="15%" class="table_none"><input type="text" size="8" class="text_input60 number" id="0" name="additionalCDetailPo.ssenumber" onblur="addCosts(this)" validate=""><BR></td>
                                        <td width="20%" class="table_none"><span id="amountMoney"></span><input class="fjfya" type="hidden" id="amountMoney" name="amountMoney"></td>
                                        <td width="20%" class="Privateborder"><div align="center">
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
                                    <td   class="Privateborder"><input style="width:100px;"  title="" name="salesDetailPo.ssesdsalesitemids" readonly="readonly" class="salesout"></td>
                                    <td  class="Privateborder"><input style="width: 100px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesdsalesitemnames" readonly="readonly" class="text_inputhidden"></td>
                                    <td   class="Privateborder"><input style="width: 40px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesdsprices" readonly="readonly" class="text_inputhidden yjje"></td>
                                    <td  class="Privateborder"><input style="width: 42px" onmouseover="salesover(this)" onmouseout="salesout(this)" title=""  name="salesDetailPo.ssesdnumbers" onblur="changeNumber(this)" class="text_inputhidden number salesout"></td>
                                    <td  class="Privateborder"><input style="width: 40px;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdpricesums" readonly="readonly" class="text_inputhidden pricesum"></td>
                                    <td  class="Privateborder"><input style="width: 40px"  title="" onmouseover="salesover(this)" onmouseout="salesout(this)"  name="salesDetailPo.ssesddiscountrates" onclick="discount2(this)" readonly="readonly" class="text_inputhidden discountrate salesout" >
                                    	<input type="hidden" class="rownumber" name="rownumber"/>
                                    </td>
                                    <td  class="Privateborder"><input  style="width: 40px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesddiscountnums" readonly="readonly" class="text_inputhidden zksum"></td>
                                    <td  class="Privateborder"><input  style="width: 40px;background:transparent;border:0px;" title=""  name="salesDetailPo.ssesdrenums" readonly="readonly" class="text_inputhidden resum"></td>
                                    <td  class="Privateborder"><input style="width: 40px;background:transparent;border:0px;"  title="" name="salesDetailPo.ssesdsalesvalues" readonly="readonly" class="text_inputhidden yssum"></td>
                                     <td  class="Privateborder"><input  style="width: 80px;" title="" onmouseover="salesover(this)" onmouseout="salesout(this)"  name="salesDetailPo.ssesdgooddescribes"  class="text_inputhidden salesout">
                                       <input type="hidden" name="salesDetailPo.ssesdcostsprives"/>
                                        <input type="hidden" name="salesDetailPo.ssesdunitprices"/>
                                      <input type="hidden" name="salesDetailPo.ssesditemids"/>
                                       <input type="hidden" name="salesDetailPo.ssesdunitprices"/>   <input type="hidden" name="salesDetailPo.iscustomizes"/><input type="hidden"  name="salesDetailPo.ssesdcommoditiesflags"/>
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
                                </tr> -->
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