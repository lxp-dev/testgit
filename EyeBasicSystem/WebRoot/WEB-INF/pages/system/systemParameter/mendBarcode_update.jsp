<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/printBarcode.jsp" %>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-store, must-revalidate"> 
<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT"> 
<META HTTP-EQUIV="expires" CONTENT="0"> 

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="<%=request.getContextPath()%>/js/jquery/jQueryRotate.2.2.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>条码样式设置</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    	$(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      	$(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });
	    
	    if($("#ctype").val() == '1'){	
	    	$("#cname").text("   镜架类");
	    }else if($("#ctype").val() == '2'){
	    	$("#cname").text("   配件类");
	    }else if($("#ctype").val() == '3'){
	    	$("#cname").text("   镜片类");
	    }else if($("#ctype").val() == '4'){
	    	$("#cname").text("   隐形镜片类");
	    }else if($("#ctype").val() == '5'){
	    	$("#cname").text("   护理液类");
	    }else if($("#ctype").val() == '6'){
	    	$("#cname").text("   太阳镜类");
	    }else if($("#ctype").val() == '7'){
	    	$("#cname").text("   耗材类");
	    }else if($("#ctype").val() == '8'){
	    	$("#cname").text("   老花镜类");
	    }else if($("#ctype").val() == '9'){
	    	$("#cname").text("   视光类");
	    }
	    
        $("div[id=QR]").css({"left": accMul('${barcodepo1[0].fspx }',0.5), "top": accMul('${barcodepo1[0].fspy }',0.5)});
	    if('${barcodepo1[0].fspisprint }' == '1'){
		}else{
			$("div[id=QR]").hide();
		}
		
		$("div[id=tiaoma1]").css({"left": accMul('${barcodepo1[1].fspx }',0.5)+8, "top": accMul('${barcodepo1[1].fspy }',0.5)+4});
		if('${barcodepo1[1].fspisprint }' == '1'){
		}else{
			$("div[id=tiaoma1]").hide();
		}
		
		$("div[id=tiaoma2]").css({"left": accMul('${barcodepo1[2].fspx }',0.5)+8, "top": accMul('${barcodepo1[2].fspy }',0.5)+4});
		if('${barcodepo1[2].fspisprint }' == '1'){
		}else{
			$("div[id=tiaoma2]").hide();
		}
		
		$("div[id=pinming1]").css({"left": accMul('${barcodepo1[3].fspx }',0.5), "top": accMul('${barcodepo1[3].fspy }',0.5)});
		$("div[id=pinming2]").css({"left": accMul('${barcodepo1[3].fspx }',0.5), "top": accMul('${barcodepo1[3].fspy }',0.5)});
		if('${barcodepo1[3].fspisprint }' == '1'){
			if('${barcodepo1[3].fspishowbarcodename}' == '0'){
				$("div[id=pinming1]").hide();
			}else{
				$("div[id=pinming2]").hide();
			}
		}else{
			$("div[id=pinming1]").hide();
			$("div[id=pinming2]").hide();
		}
		
		$("div[id=chandi1]").css({"left": accMul('${barcodepo1[4].fspx }',0.5), "top": accMul('${barcodepo1[4].fspy }',0.5)});
		$("div[id=chandi2]").css({"left": accMul('${barcodepo1[4].fspx }',0.5), "top": accMul('${barcodepo1[4].fspy }',0.5)});
		if('${barcodepo1[4].fspisprint }' == '1'){	
			if('${barcodepo1[4].fspishowbarcodename}' == '0'){
				$("div[id=chandi1]").hide();
			}else{
				$("div[id=chandi2]").hide();
			}
		}else{
			$("div[id=chandi1]").hide();
			$("div[id=chandi2]").hide();
		}
		
		$("div[id=xinghao1]").css({"left": accMul('${barcodepo1[5].fspx }',0.5), "top": accMul('${barcodepo1[5].fspy }',0.5)});
		$("div[id=xinghao2]").css({"left": accMul('${barcodepo1[5].fspx }',0.5), "top": accMul('${barcodepo1[5].fspy }',0.5)});
		if('${barcodepo1[5].fspisprint }' == '1'){
			if('${barcodepo1[5].fspishowbarcodename}' == '0'){
				$("div[id=xinghao1]").hide();
			}else{
				$("div[id=xinghao2]").hide();
			}
		}else{
			$("div[id=xinghao1]").hide();
			$("div[id=xinghao2]").hide();
		}
		
		$("div[id=sehao1]").css({"left": accMul('${barcodepo1[6].fspx }',0.5), "top": accMul('${barcodepo1[6].fspy }',0.5)});
		$("div[id=sehao2]").css({"left": accMul('${barcodepo1[6].fspx }',0.5), "top": accMul('${barcodepo1[6].fspy }',0.5)});
		if('${barcodepo1[6].fspisprint }' == '1'){	
			if('${barcodepo1[6].fspishowbarcodename}' == '0'){
				$("div[id=sehao1]").hide();
			}else{
				$("div[id=sehao2]").hide();
			}
		}else{
			$("div[id=sehao1]").hide();
			$("div[id=sehao2]").hide();
		}
		
		$("div[id=shoujia1]").css({"left": accMul('${barcodepo1[7].fspx }',0.5), "top": accMul('${barcodepo1[7].fspy }',0.5)});
		$("div[id=shoujia2]").css({"left": accMul('${barcodepo1[7].fspx }',0.5), "top": accMul('${barcodepo1[7].fspy }',0.5)});
		if('${barcodepo1[7].fspisprint }' == '1'){
			if('${barcodepo1[7].fspishowbarcodename}' == '0'){
				$("div[id=shoujia1]").hide();
			}else{
				$("div[id=shoujia2]").hide();
			}
		}else{
			$("div[id=shoujia1]").hide();
			$("div[id=shoujia2]").hide();
		}
		
		$("div[id=wujia1]").css({"left": accMul('${barcodepo1[8].fspx }',0.5), "top": accMul('${barcodepo1[8].fspy }',0.5)});
		$("div[id=wujia2]").css({"left": accMul('${barcodepo1[8].fspx }',0.5), "top": accMul('${barcodepo1[8].fspy }',0.5)});
		if('${barcodepo1[8].fspisprint }' == '1'){
			if('${barcodepo1[8].fspishowbarcodename}' == '0'){
				$("div[id=wujia1]").hide();
			}else{
				$("div[id=wujia2]").hide();
			}
		}else{
			$("div[id=wujia1]").hide();
			$("div[id=wujia2]").hide();
		}
		
		$("div[id=zidingyi1]").css({"left": accMul('${barcodepo1[9].fspx }',0.5), "top": accMul('${barcodepo1[9].fspy }',0.5)});
		if('${barcodepo1[9].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi1]").hide();
		}
		
		$("div[id=zidingyi2]").css({"left": accMul('${barcodepo1[10].fspx }',0.5), "top": accMul('${barcodepo1[10].fspy }',0.5)});
		if('${barcodepo1[10].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi2]").hide();
		}
		
		$("div[id=zidingyi3]").css({"left": accMul('${barcodepo1[11].fspx }',0.5), "top": accMul('${barcodepo1[11].fspy }',0.5)});
		if('${barcodepo1[11].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi3]").hide();
		}
		
		$("div[id=zidingyi4]").css({"left": accMul('${barcodepo1[12].fspx }',0.5), "top": accMul('${barcodepo1[12].fspy }',0.5)});
		if('${barcodepo1[12].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi4]").hide();
		}
		
		$("div[id=zidingyi5]").css({"left": accMul('${barcodepo1[13].fspx }',0.5), "top": accMul('${barcodepo1[13].fspy }',0.5)});
		if('${barcodepo1[13].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi5]").hide();
		}
		
		$("div[id=zidingyi6]").css({"left": accMul('${barcodepo1[14].fspx }',0.5), "top": accMul('${barcodepo1[14].fspy }',0.5)});
		if('${barcodepo1[14].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi6]").hide();
		}
		
		$("div[id=zidingyi7]").css({"left": accMul('${barcodepo1[15].fspx }',0.5), "top": accMul('${barcodepo1[15].fspy }',0.5)});
		if('${barcodepo1[15].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi7]").hide();
		}
		
		$("div[id=zidingyi8]").css({"left": accMul('${barcodepo1[16].fspx }',0.5), "top": accMul('${barcodepo1[16].fspy }',0.5)});
		if('${barcodepo1[16].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi8]").hide();
		}
		
		$("div[id=zidingyi9]").css({"left": accMul('${barcodepo1[17].fspx }',0.5), "top": accMul('${barcodepo1[17].fspy }',0.5)});
		if('${barcodepo1[17].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi9]").hide();
		}
		
		$("div[id=zidingyi10]").css({"left": accMul('${barcodepo1[18].fspx }',0.5), "top": accMul('${barcodepo1[18].fspy }',0.5)});
		if('${barcodepo1[18].fspisprint }' == '1'){
		}else{
			$("div[id=zidingyi10]").hide();
		}
		
		$("div[id=xiaoqi1]").css({"left": accMul('${barcodepo1[19].fspx }',0.5), "top": accMul('${barcodepo1[19].fspy }',0.5)});
		$("div[id=xiaoqi2]").css({"left": accMul('${barcodepo1[19].fspx }',0.5), "top": accMul('${barcodepo1[19].fspy }',0.5)});
		if('${barcodepo1[19].fspisprint }' == '1'){
			if('${barcodepo1[19].fspishowbarcodename}' == '0'){
				$("div[id=xiaoqi1]").hide();
			}else{
				$("div[id=xiaoqi2]").hide();
			}
		}else{
			$("div[id=xiaoqi1]").hide();
			$("div[id=xiaoqi2]").hide();
		}
		
		$("div[id=pici1]").css({"left": accMul('${barcodepo1[20].fspx }',0.5), "top": accMul('${barcodepo1[20].fspy }',0.5)});
		$("div[id=pici2]").css({"left": accMul('${barcodepo1[20].fspx }',0.5), "top": accMul('${barcodepo1[20].fspy }',0.5)});
		if('${barcodepo1[19].fspisprint }' == '1'){
			if('${barcodepo1[20].fspishowbarcodename}' == '0'){
				$("div[id=pici1]").hide();
			}else{
				$("div[id=pici2]").hide();
			}
		}else{
			$("div[id=pici1]").hide();
			$("div[id=pici2]").hide();
		}
		
		var barcodeindex=0
        <c:forEach var="po" items="${barcodepo1}" >
        	var img = new Image();
        	var img1 = new Image();
			img.src =$("img[showdiv="+barcodeindex+"]").eq(0).attr("src") ;
			img1.src =$("img[showdiv="+barcodeindex+"]").eq(1).attr("src") ;
			var w = img.width;
			var w1 = img1.width;
			$("#imgwidth"+barcodeindex).val(w);
			$("#imgwidth"+barcodeindex+"a").val(w1);
         	if('${po.fspnrib}' == 'R'){
         		$("img[showdiv="+barcodeindex+"]").rotate(90); 
         		$("div[showdiv="+barcodeindex+"]").animate({left:accAdd('${po.fspx}'/2,-w/2)},50);
	       		$("div[showdiv="+barcodeindex+"]").animate({top: accAdd('${po.fspy}'/2, w/2)},50);
         	}else if('${po.fspnrib}' == 'I'){
         		$("img[showdiv="+barcodeindex+"]").rotate(180); 
         	}else if('${po.fspnrib}' == 'B'){
         		$("img[showdiv="+barcodeindex+"]").rotate(270); 
         		$("div[showdiv="+barcodeindex+"]").animate({left:accAdd('${po.fspx}'/2,-w/2)},50);
	       		$("div[showdiv="+barcodeindex+"]").animate({top: accAdd('${po.fspy}'/2, w/2)},50);
         	}else{
         		$("div[showdiv="+barcodeindex+"]").animate({left:accAdd('${po.fspx}'/2,0)},50);
	       		$("div[showdiv="+barcodeindex+"]").animate({top: accAdd('${po.fspy}'/2,0)},50);
         	}
         	barcodeindex = barcodeindex + 1;
        </c:forEach> 
		
        $('select[name=systemParameterPo.fspnribs]').change(function(){
			var jd = 0;
			var id = $(this).attr("z");
			
			if($(this).val() == 'R'){
	       		jd = 90;
	       		$("div[showdiv="+id+"]").animate({left:accAdd($("[x="+id+"]").val()/2,0)},50);
	       		$("div[showdiv="+id+"]").animate({top:accAdd($("[y="+id+"]").val()/2,0)},50);
	       		
	       		if($("select[s="+id+"]").val() == "0"){
	       			$("div[showdiv="+id+"]").animate({left:accAdd($("[x="+id+"]").val()/2,-$("#imgwidth"+id+"a").val()/2)},50);
		       		$("div[showdiv="+id+"]").animate({top:accAdd($("[y="+id+"]").val()/2,$("#imgwidth"+id+"a").val()/2)},50);
	       		}else{
		            $("div[showdiv="+id+"]").animate({left:accAdd($("[x="+id+"]").val()/2,-$("#imgwidth"+id).val()/2)},50);
		       		$("div[showdiv="+id+"]").animate({top:accAdd($("[y="+id+"]").val()/2,$("#imgwidth"+id).val()/2)},50);
	       		}
	       	}else if($(this).val() == 'I'){
	       		jd = 180;
	       		$("div[showdiv="+id+"]").animate({left:accAdd($("[x="+id+"]").val()/2,0)},50);
	       		$("div[showdiv="+id+"]").animate({top:accAdd($("[y="+id+"]").val()/2,0)},50);
	       	}else if($(this).val() == 'B'){
	       		jd = 270;
	       		$("div[showdiv="+id+"]").animate({left:accAdd($("[x="+id+"]").val()/2,0)},50);
	       		$("div[showdiv="+id+"]").animate({ top:accAdd($("[y="+id+"]").val()/2,0)},50);
	       		
	       		if($("select[s="+id+"]").val() == "0"){
	       			$("div[showdiv="+id+"]").animate({left:accAdd($("[x="+id+"]").val()/2,-$("#imgwidth"+id+"a").val()/2)},50);
		       		$("div[showdiv="+id+"]").animate({top:accAdd($("[y="+id+"]").val()/2,$("#imgwidth"+id+"a").val()/2)},50);
	       		}else{
		            $("div[showdiv="+id+"]").animate({left:accAdd($("[x="+id+"]").val()/2,-$("#imgwidth"+id).val()/2)},50);
		       		$("div[showdiv="+id+"]").animate({top:accAdd($("[y="+id+"]").val()/2,$("#imgwidth"+id).val()/2)},50);
	       		}
	       	}else{
	       		$("div[showdiv="+id+"]").animate({left:accAdd($("[x="+id+"]").val()/2,0)},50);
	       		$("div[showdiv="+id+"]").animate({top:accAdd($("[y="+id+"]").val()/2,0)},50);
	       	}
	       	
	       	if($(this).attr("z") == "1"){
	       		$("#tiaomaimg1").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "2"){
	       		$("#tiaomaimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "3"){
	       		$("#pinmingimg1").rotate({animateTo:parseInt(jd)});
	       		$("#pinmingimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "4"){
	       		$("#chandiimg1").rotate({animateTo:parseInt(jd)});
	       		$("#chandiimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "5"){
	       		$("#xinghaoimg1").rotate({animateTo:parseInt(jd)});
	       		$("#xinghaoimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "6"){
	       		$("#sehaoimg1").rotate({animateTo:parseInt(jd)});
	       		$("#sehaoimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "7"){
	       		$("#shoujiaimg1").rotate({animateTo:parseInt(jd)});
	       		$("#shoujiaimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "8"){
	       		$("#wujiaimg1").rotate({animateTo:parseInt(jd)});
	       		$("#wujiaimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "9"){
	       		$("#zidingyiimg1").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "10"){
	       		$("#zidingyiimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "11"){
	       		$("#zidingyiimg3").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "12"){
	       		$("#zidingyiimg4").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "13"){
	       		$("#zidingyiimg5").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "14"){
	       		$("#zidingyiimg6").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "15"){
	       		$("#zidingyiimg7").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "16"){
	       		$("#zidingyiimg8").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "17"){
	       		$("#zidingyiimg9").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "18"){
	       		$("#zidingyiimg10").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "19"){
	       		$("#xiaoqiimg1").rotate({animateTo:parseInt(jd)});
	       		$("#xiaoqiimg2").rotate({animateTo:parseInt(jd)});
	       	}else if($(this).attr("z") == "20"){
	       		$("#piciimg1").rotate({animateTo:parseInt(jd)});
	       		$("#piciimg2").rotate({animateTo:parseInt(jd)});
	       	}
		});
	});
	
	function isshowdiv(obj){
		var index = $(obj).val();
		$("div[a=a]").hide();
		$("input[bl=bl]").attr("disabled","disabled");
		$("div[id=type"+index+"]").show();
		$("input[bl=bl][group="+index+"]").attr("disabled","");
	}

	function save(){
		if(checkForm(companyNameForm)){
			$("img").removeAttr("onclick");
			companyNameForm.action = "mendBarcode.action?number="+Math.random();
			companyNameForm.submit();
		}
	}

	function batPrintGoodsBarCode(){
		var barCode = new Array();
		var quantity = new Array();
		var brandname = new Array();
		var source = new Array();
		var spec = new Array();
		var color = new Array();
		var retailprice = new Array();
		var person = new Array();
		var guaranteeperiod = new Array();
		var batch = new Array();
		
		person[person.length] = "030";
		
		barCode[barCode.length] = $("#ctype").val()+'2345678901234567890ABCDEF';
		
		quantity[quantity.length] = $("input[id=fsprowprintnum]").val();
		brandname[brandname.length] = "范思哲镜架";
		source[source.length] = "中国";
		spec[spec.length] = "A001";
		color[color.length] = "9001";
		retailprice[retailprice.length] = "8888.88";

		guaranteeperiod[guaranteeperiod.length] = "2016-01-01";
		batch[batch.length] = "PC112455CB";
			
		var printtype = {"1":$("#fsptype").val()
						 ,"2":$("#fsptype").val()
						 ,"3":$("#fsptype").val()
						 ,"4":$("#fsptype").val()
						 ,"5":$("#fsptype").val()
						 ,"6":$("#fsptype").val()
						 ,"7":$("#fsptype").val()
						 ,"8":$("#fsptype").val()
						 ,"9":$("#fsptype").val()};

		//try {
			printBarCode(barCode,quantity,brandname,source,spec,color,retailprice,person,printtype,guaranteeperiod,batch);
		/*} catch(e) {
			alert("打印失败!请检查条码打印机是否正确连接!");
			return;
		}*/
	}

	function inputForABS(obj){
		if(!$(obj).val()){
			return;
		}
		if($(obj).val().search("^-?\\d+$")!=0){
			alert("请输入整数！");
			$(obj).focus();
			$(obj).select();
		}else{
			$(obj).val(Math.abs($(obj).val()));
			
			if($(obj).attr("x")){
				Xmoving($(obj).attr("x"),obj);
			}
			
			if($(obj).attr("y")){
				Ymoving($(obj).attr("y"),obj);
			}
		}
	}
	
	function checkIsPrint(obj){
		if($(obj).attr("checked")){
			$("input[r="+$(obj).attr("r")+"]").val("1");
			
			if($("select[s="+$(obj).attr("r")+"]").val()){
				$("div[showdiv="+$(obj).attr("r")+"][showid="+$("select[s="+$(obj).attr("r")+"]").val()+"]").show();
			}else{
				$("div[showdiv="+$(obj).attr("r")+"]").show();
			}
		}else{
			if($("select[s="+$(obj).attr("r")+"]").val()){
				$("div[showdiv="+$(obj).attr("r")+"][showid="+$("select[s="+$(obj).attr("r")+"]").val()+"]").hide();
			}else{
				$("div[showdiv="+$(obj).attr("r")+"]").hide();
			}
			$("input[r="+$(obj).attr("r")+"]").val("0");
		}
	}
	var zindex = 0;
	function isShow(id,obj){
		zindex = zindex + 1;
		var sid = $(obj).attr("s");
		if($(obj).val() == '0'){
			$('div[id='+id+'1]').hide();
			$('div[id='+id+'2]').show();
			
			$("div[showdiv="+sid+"]").animate({left:accAdd($("[x="+sid+"]").val()/2,0)},50);
	       	$("div[showdiv="+sid+"]").animate({top:accAdd($("[y="+sid+"]").val()/2,0)},50);
			
			if($("select[z="+sid+"]").val() == 'R'){
	       		$("div[showdiv="+sid+"]").animate({left:accAdd($("[x="+sid+"]").val()/2,-$("#imgwidth"+sid+"a").val()/2)},50);
	       		$("div[showdiv="+sid+"]").animate({top:accAdd($("[y="+sid+"]").val()/2,$("#imgwidth"+sid+"a").val()/2)},50);
	       	}else if($("select[z="+sid+"]").val() == 'I'){
	       		$("div[showdiv="+sid+"]").animate({left:accAdd($("[x="+sid+"]").val()/2,-$("#imgwidth"+sid+"a").val())},50);
	       		$("div[showdiv="+sid+"]").animate({top:accAdd($("[y="+sid+"]").val()/2,0)},50);
	       	}else if($("select[z="+sid+"]").val() == 'B'){
	       		$("div[showdiv="+sid+"]").animate({left:accAdd($("[x="+sid+"]").val()/2,-$("#imgwidth"+sid+"a").val()/2)},50);
	       		$("div[showdiv="+sid+"]").animate({top:accAdd($("[y="+sid+"]").val()/2,-$("#imgwidth"+sid+"a").val()/2)},50);
	       	}
	       	$('div[id='+id+'2]').attr("z-index",zindex);
		}else{
			$('div[id='+id+'1]').show();
			$('div[id='+id+'2]').hide();
			
			if($("select[z="+sid+"]").val() == 'R'){
	            $("div[showdiv="+sid+"]").animate({left:accAdd($("[x="+sid+"]").val()/2,-$("#imgwidth"+sid).val()/2)},50);
	       		$("div[showdiv="+sid+"]").animate({top:accAdd($("[y="+sid+"]").val()/2,$("#imgwidth"+sid).val()/2)},50);
	       	}else if($("select[z="+sid+"]").val() == 'I'){
	       		$("div[showdiv="+sid+"]").animate({left:accAdd($("[x="+sid+"]").val()/2,-$("#imgwidth"+sid).val())},50);
	       		$("div[showdiv="+sid+"]").animate({top:accAdd($("[y="+sid+"]").val()/2,0)},50);
	       	}else if($("select[z="+sid+"]").val() == 'B'){
	       		$("div[showdiv="+sid+"]").animate({left:accAdd($("[x="+sid+"]").val()/2,-$("#imgwidth"+sid).val()/2)},50);
	       		$("div[showdiv="+sid+"]").animate({top:accAdd($("[y="+sid+"]").val()/2,-$("#imgwidth"+sid).val()/2)},50);
	       	}
	        $('div[id='+id+'1]').attr("z-index",zindex);
		}
		
	}
	
	function isRotate(id,obj){
	}
	
	function Xmoving(id,obj){
		if($("select[z="+id+"]").val() == 'R'){
			$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id).val()/2)},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2, $("#imgwidth"+id).val()/2)},50);
       		
       		$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id+"a").val()/2)},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2, $("#imgwidth"+id+"a").val()/2)},50);
		}else if($("select[z="+id+"]").val() == 'I'){
			$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id).val())},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2, 0)},50);
       		
       		$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id+"a").val())},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2, 0)},50);
		}else if($("select[z="+id+"]").val() == 'B'){
			$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id).val()/2)},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2,-$("#imgwidth"+id).val()/2)},50);
       		
       		$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id+"a").val()/2)},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2,-$("#imgwidth"+id+"a").val()/2)},50);
		}else{
			$("div[showdiv="+id+"]").animate({left:$("input[x="+id+"]").val()/2},50);
		}
	}
	
	function Ymoving(id,obj){
		if($("[z="+id+"]").val() == 'R'){
			$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id).val()/2)},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2, $("#imgwidth"+id).val()/2)},50);
       		
       		$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id+"a").val()/2)},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2, $("#imgwidth"+id+"a").val()/2)},50);
		}else if($("[z="+id+"]").val() == 'I'){
			$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id).val())},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2, 0)},50);
       		
       		$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id+"a").val())},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2, 0)},50);
		}else if($("[z="+id+"]").val() == 'B'){
			$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id).val()/2)},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2,-$("#imgwidth"+id).val()/2)},50);
       		
       		$("div[showdiv="+id+"]").animate({left:accAdd($("input[x="+id+"]").val()/2,-$("#imgwidth"+id+"a").val()/2)},50);
       		$("div[showdiv="+id+"]").animate({top: accAdd($("input[y="+id+"]").val()/2,-$("#imgwidth"+id+"a").val()/2)},50);
		}else{
			$("div[showdiv="+id+"]").animate({top: $("input[y="+id+"]").val()/2},50);
		}
	}
</script>
<body>
<form name="companyNameForm" method="post" action="">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
<input type="hidden" name="systemParameterPo.fsptype" id="ctype" value="${ctype }"/>
<input type="hidden" id="imgwidth0" value=""/>
<input type="hidden" id="imgwidth1" value=""/>
<input type="hidden" id="imgwidth2" value=""/>
<input type="hidden" id="imgwidth3" value=""/>
<input type="hidden" id="imgwidth3a" value=""/>
<input type="hidden" id="imgwidth4" value=""/>
<input type="hidden" id="imgwidth4a" value=""/>
<input type="hidden" id="imgwidth5" value=""/>
<input type="hidden" id="imgwidth5a" value=""/>
<input type="hidden" id="imgwidth6" value=""/>
<input type="hidden" id="imgwidth6a" value=""/>
<input type="hidden" id="imgwidth7" value=""/>
<input type="hidden" id="imgwidth7a" value=""/>
<input type="hidden" id="imgwidth8" value=""/>
<input type="hidden" id="imgwidth8a" value=""/>
<input type="hidden" id="imgwidth9" value=""/>
<input type="hidden" id="imgwidth10" value=""/>
<input type="hidden" id="imgwidth11" value=""/>
<input type="hidden" id="imgwidth12" value=""/>
<input type="hidden" id="imgwidth13" value=""/>
<input type="hidden" id="imgwidth14" value=""/>
<input type="hidden" id="imgwidth15" value=""/>
<input type="hidden" id="imgwidth16" value=""/>
<input type="hidden" id="imgwidth17" value=""/>
<input type="hidden" id="imgwidth18" value=""/>
<input type="hidden" id="imgwidth19" value=""/>
<input type="hidden" id="imgwidth19a" value=""/>
<input type="hidden" id="imgwidth20" value=""/>
<input type="hidden" id="imgwidth20a" value=""/>
<TBODY>
  <tr height="20px"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
          </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD width="100%" 
                vAlign=top 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px"><DIV id=tabContent__1>
                  <DIV>
                    <br/>
                    <TABLE width="100%" cellSpacing=1 cellPadding=3 align=center border=0 class="privateBorder">
                      <TBODY>
                      	 <TR height="30">
                          <TD class="table_body" colspan="8">
                          <div id="cname"></div>
                          </TD>
                         </TR>
                         <TR>
                          <TD class="table_body" align="right">
                          	二维码设置
                          	<input bl=bl group="1" r=0 type="checkbox" id="isprints" ${barcodepo1[0].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=0 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[0].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="1">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=0 onblur="inputForABS(this)" group="1" class="text_input40" type="text"  id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[0].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=0 onblur="inputForABS(this)" group="1" class="text_input40" type="text"  id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[0].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text"  id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[0].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none"><input bl=bl name="systemParameterPo.fspnribs" group="1" value="N" type="hidden">
							  <input type="hidden" bl=bl value="0" group="1" id="fspishowbarcodenames" name="systemParameterPo.fspishowbarcodenames">
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						  <TD class="table_none" align="center">显示属性名称</TD>
						  <TD class="table_none" rowspan="8" colspan="2">
						  	<div style="position:relative;background-color: white;width: 400;height: 300;">
						  		<div id=QR showdiv=0 id="QR" style="position:absolute;left:60;top:25;">
						  			<img showdiv=0 style="width: auto;height: auto;" src="${ctx}/img/example/qr.png"/>
						  		</div>
						  		<div showdiv=1 id="tiaoma1" style="position:absolute;left:50;top:120;">
						  			<img showdiv=1 id=tiaomaimg1 style="width: auto;height: auto;" src="${ctx}/img/example/tiaoma1.png"/>
						  		</div>
						  		<div showdiv=2 id="tiaoma2" style="position:absolute;left:50;top:140;">
						  			<img showdiv=2 id=tiaomaimg2 style="width: auto;height: auto;" src="${ctx}/img/example/tiaoma2.png"/>
						  		</div>
						  		<div showdiv=3 showid="1" id="pinming1" style="position:absolute;left:0px;top:0;">
						  			<img showdiv=3 id=pinmingimg1 style="width: auto;height: auto;" src="${ctx}/img/example/pinming1.png"/>
						  		</div>
						  		<div showdiv=3 showid="0" id="pinming2" style="position:absolute;left:0px;top:0;">
						  			<img showdiv=3 id=pinmingimg2 style="width: auto;height: auto;" src="${ctx}/img/example/pinming2.png"/>
						  		</div>
						  		<div showdiv=4 showid="1" id="chandi1" style="position:absolute;left:0;top:0;">
						  			<img showdiv=4 id=chandiimg1 style="width: auto;height: auto;" src="${ctx}/img/example/chandi1.png"/>
						  		</div>
						  		<div showdiv=4 showid="0" id="chandi2" style="position:absolute;left:0;top:0;">
						  			<img showdiv=4 id=chandiimg2 style="width: auto;height: auto;" src="${ctx}/img/example/chandi2.png"/>
						  		</div>
						  		<div showdiv=5 showid="1" id="xinghao1" style="position:absolute;left:0;top:0;">
						  			<img showdiv=5 id=xinghaoimg1 style="width: auto;height: auto;" src="${ctx}/img/example/xinghao1.png"/>
						  		</div>
						  		<div showdiv=5 showid="0" id="xinghao2" style="position:absolute;left:0;top:0;">
						  			<img showdiv=5 id=xinghaoimg2 style="width: auto;height: auto;" src="${ctx}/img/example/xinghao2.png"/>
						  		</div>
						  		<div showdiv=6 showid="1" id="sehao1" style="position:absolute;left:0;top:0;">
						  			<img showdiv=6 id=sehaoimg1 style="width: auto;height: auto;" src="${ctx}/img/example/sehao1.png"/>
						  		</div>
						  		<div showdiv=6 showid="0" id="sehao2" style="position:absolute;left:0;top:0;">
						  			<img showdiv=6 id=sehaoimg2 style="width: auto;height: auto;" src="${ctx}/img/example/sehao2.png"/>
						  		</div>
						  		<div showdiv=7 showid="1" id="shoujia1" style="position:absolute;left:0;top:0;">
						  			<img showdiv=7 id=shoujiaimg1 style="width: auto;height: auto;" src="${ctx}/img/example/shoujia1.png"/>
						  		</div>
						  		<div showdiv=7 showid="0" id="shoujia2" style="position:absolute;left:0;top:0;">
						  			<img showdiv=7 id=shoujiaimg2 style="width: auto;height: auto;" src="${ctx}/img/example/shoujia2.png"/>
						  		</div>
						  		<div showdiv=8 showid="1" id="wujia1" style="position:absolute;left:0;top:0;">
						  			<img showdiv=8 id=wujiaimg1 style="width: auto;height: auto;" src="${ctx}/img/example/wujia1.png"/>
						  		</div>
						  		<div showdiv=8 showid="0" id="wujia2" style="position:absolute;left:0;top:0;">
						  			<img showdiv=8 id=wujiaimg2 style="width: auto;height: auto;" src="${ctx}/img/example/wujia2.png"/>
						  		</div>
						  		<div showdiv=9 id="zidingyi1" style="position:absolute;left:0;top:0;">
						  			<img showdiv=9  id=zidingyiimg1 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi1.png"/>
						  		</div>
						  		<div showdiv=10 id="zidingyi2" style="position:absolute;left:0;top:0;">
						  			<img showdiv=10 id=zidingyiimg2 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi2.png"/>
						  		</div>
						  		<div showdiv=11 id="zidingyi3" style="position:absolute;left:0;top:0;">
						  			<img showdiv=11 id=zidingyiimg3 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi3.png"/>
						  		</div>
						  		<div showdiv=12 id="zidingyi4" style="position:absolute;left:0;top:0;">
						  			<img showdiv=12 id=zidingyiimg4 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi4.png"/>
						  		</div>
						  		<div showdiv=13 id="zidingyi5" style="position:absolute;left:0;top:0;">
						  			<img showdiv=13 id=zidingyiimg5 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi5.png"/>
						  		</div>
						  		<div showdiv=14 id="zidingyi6" style="position:absolute;left:0;top:0;">
						  			<img showdiv=14 id=zidingyiimg6 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi6.png"/>
						  		</div>
						  		<div showdiv=15 id="zidingyi7" style="position:absolute;left:0;top:0;">
						  			<img showdiv=15 id=zidingyiimg7 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi7.png"/>
						  		</div>
						  		<div showdiv=16 id="zidingyi8" style="position:absolute;left:0;top:0;">
						  			<img showdiv=16 id=zidingyiimg8 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi8.png"/>
						  		</div>
						  		<div showdiv=17 id="zidingyi9" style="position:absolute;left:0;top:0;">
						  			<img showdiv=17 id=zidingyiimg9 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi9.png"/>
						  		</div>
						  		<div showdiv=18 id="zidingyi10" style="position:absolute;left:0;top:0;">
						  			<img showdiv=18 id=zidingyiimg10 style="width: auto;height: auto;" src="${ctx}/img/example/zidingyi10.png"/>
						  		</div>
						  		<div showdiv=19 showid="1" id="xiaoqi1" style="position:absolute;left:0;top:0;">
						  			<img showdiv=19 id=xiaoqiimg1 style="width: auto;height: auto;" src="${ctx}/img/example/xiaoqi1.png"/>
						  		</div>
						  		<div showdiv=19 showid="0" id="xiaoqi2" style="position:absolute;left:0;top:0;">
						  			<img showdiv=19 id=xiaoqiimg2 style="width: auto;height: auto;" src="${ctx}/img/example/xiaoqi2.png"/>
						  		</div>
						  		
						  		<div showdiv=20 showid="1" id="pici1" style="position:absolute;left:0;top:0;">
						  			<img showdiv=20 id=piciimg1 style="width: auto;height: auto;" src="${ctx}/img/example/pici1.png"/>
						  		</div>
						  		<div showdiv=20 showid="0" id="pici2" style="position:absolute;left:0;top:0;">
						  			<img showdiv=20 id=piciimg2 style="width: auto;height: auto;" src="${ctx}/img/example/pici2.png"/>
						  		</div>
						  	</div>
						  	
						  	<img src="${ctx}/img/newbtn/btn_printexamplebarcode_0.png" btn=btn id="printexamplebarcode" title='打印测试条码' onclick="batPrintGoodsBarCode();"></TD> 
                         </TR>
                         
                         <TR>   
                          <TD class="table_body" align="right">
                          	条码第一行
                          	<input bl=bl group="1" r=1 type="checkbox" id="isprints" ${barcodepo1[1].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=1 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[1].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="2">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=1 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[1].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=1 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[1].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[1].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=1 bl=bl name="systemParameterPo.fspnribs" group="1">
							  	<option value="N"  ${barcodepo1[1].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[1].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[1].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[1].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">&nbsp;
						  	  <input type="hidden" bl=bl value="0" group="1" id="fspishowbarcodenames" name="systemParameterPo.fspishowbarcodenames">
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"       name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>
                         
                         <TR>   
                          <TD class="table_body" align="right">
                          	条码第二行
                          	<input bl=bl group="1" r=2 type="checkbox" id="isprints" ${barcodepo1[2].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=2 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[2].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="3">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=2 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[2].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=2 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[2].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[2].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=2 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('2',this)">
							  	<option value="N"  ${barcodepo1[2].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[2].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[2].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[2].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">&nbsp;
						  	  <input type="hidden" bl=bl value="0" group="1" id="fspishowbarcodenames" name="systemParameterPo.fspishowbarcodenames">  
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>

						 <TR>   
                          <TD class="table_body" align="right">
                          	品种设置
                          	<input bl=bl group="1" r=3 type="checkbox" id="isprints" ${barcodepo1[3].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl printgroup="pinming" group="1" r=3 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[3].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="4">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=3 onblur="inputForABS(this)" printgroup="pinming" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[3].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=3 onblur="inputForABS(this)" printgroup="pinming" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[3].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[3].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=3 bl=bl name="systemParameterPo.fspnribs" printgroup="pinming" group="1" onchange="isRotate('3',this)">
							  	<option value="N"  ${barcodepo1[3].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[3].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[3].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[3].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	<select bl=bl s=3 name="systemParameterPo.fspishowbarcodenames" printgroup="pinming" group="1" onchange="isShow('pinming',this)">
							  	<option value="0"  ${barcodepo1[3].fspishowbarcodename == '0' ? 'selected="selected"':'' }>隐藏</option>
							  	<option value="1"  ${barcodepo1[3].fspishowbarcodename == '1' ? 'selected="selected"':'' }>显示</option>
							</select>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>

						 <TR>
                          <TD class="table_body" align="right">
                          	产地设置
                          	<input bl=bl group="1" r=4 type="checkbox" id="isprints" ${barcodepo1[4].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl printgroup="chandi" group="1" r=4 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[4].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="5">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=4 onblur="inputForABS(this)" printgroup="chandi" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[4].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=4 onblur="inputForABS(this)" printgroup="chandi" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[4].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[4].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=4 bl=bl name="systemParameterPo.fspnribs" printgroup="chandi" group="1" onchange="isRotate('4',this)">
							  	<option value="N"  ${barcodepo1[4].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[4].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[4].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[4].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	<select bl=bl s=4 name="systemParameterPo.fspishowbarcodenames" printgroup="chandi" group="1" onchange="isShow('chandi',this)">
							  	<option value="0"  ${barcodepo1[4].fspishowbarcodename == '0' ? 'selected="selected"':'' }>隐藏</option>
							  	<option value="1"  ${barcodepo1[4].fspishowbarcodename == '1' ? 'selected="selected"':'' }>显示</option>
							</select>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>

						 <TR>   
                          <TD class="table_body" align="right">
                          	型号设置
                          	<input bl=bl group="1" r=5 type="checkbox" id="isprints" ${barcodepo1[5].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl printgroup="xinghao" group="1" r=5 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[5].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="6">
                          </TD>
						  <TD class="table_none">X轴坐标<input bl=bl x=5 onblur="inputForABS(this)" printgroup="xinghao" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[5].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=5 onblur="inputForABS(this)" printgroup="xinghao" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[5].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[5].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=5 bl=bl name="systemParameterPo.fspnribs" printgroup="xinghao" group="1" onchange="isRotate('5',this)">
							  	<option value="N"  ${barcodepo1[5].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[5].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[5].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[5].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	<select bl=bl s=5 name="systemParameterPo.fspishowbarcodenames" printgroup="xinghao" group="1" onchange="isShow('xinghao',this)">
							  	<option value="0"  ${barcodepo1[5].fspishowbarcodename == '0' ? 'selected="selected"':'' }>隐藏</option>
							  	<option value="1"  ${barcodepo1[5].fspishowbarcodename == '1' ? 'selected="selected"':'' }>显示</option>
							</select>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>

						 <TR>   
                          <TD class="table_body" align="right">
                          	色号设置
                          	<input bl=bl group="1" r=6 type="checkbox" id="isprints" ${barcodepo1[6].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl printgroup="sehao" group="1" r=6 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[6].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden" id="fsprows" name="systemParameterPo.fsprows" value="7">
                          </TD>
						  <TD class="table_none">X轴坐标<input bl=bl x=6 onblur="inputForABS(this)" printgroup="sehao" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[6].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=6 onblur="inputForABS(this)" printgroup="sehao" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[6].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[6].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=6 bl=bl name="systemParameterPo.fspnribs" printgroup="sehao" group="1" onchange="isRotate('6',this)">
							  	<option value="N"  ${barcodepo1[6].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[6].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[6].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[6].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	<select bl=bl s=6 name="systemParameterPo.fspishowbarcodenames" printgroup="sehao" group="1" onchange="isShow('sehao',this)">
							  	<option value="0"  ${barcodepo1[6].fspishowbarcodename == '0' ? 'selected="selected"':'' }>隐藏</option>
							  	<option value="1"  ${barcodepo1[6].fspishowbarcodename == '1' ? 'selected="selected"':'' }>显示</option>
							</select>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>

						 <TR>   
                          <TD class="table_body" align="right">
                          	零售价设置
                          	<input bl=bl group="1" r=7 type="checkbox" id="isprints" ${barcodepo1[7].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl printgroup="shoujia" group="1" r=7 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[7].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden" id="fsprows" name="systemParameterPo.fsprows" value="8">
                          </TD>
						  <TD class="table_none">X轴坐标<input bl=bl x=7 onblur="inputForABS(this)" printgroup="shoujia" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[7].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=7 onblur="inputForABS(this)" printgroup="shoujia" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[7].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[7].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=7 bl=bl name="systemParameterPo.fspnribs" printgroup="shoujia" group="1" onchange="isRotate('7',this)">
							  	<option value="N"  ${barcodepo1[7].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[7].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[7].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[7].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	<select bl=bl s=7 name="systemParameterPo.fspishowbarcodenames" printgroup="shoujia" group="1" onchange="isShow('shoujia',this)">
							  	<option value="0"  ${barcodepo1[7].fspishowbarcodename == '0' ? 'selected="selected"':'' }>隐藏</option>
							  	<option value="1"  ${barcodepo1[7].fspishowbarcodename == '1' ? 'selected="selected"':'' }>显示</option>
							</select>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>

						 <TR>   
                          <TD class="table_body" align="right">
                          	物价员设置
                          	<input bl=bl group="1" r=8 type="checkbox" id="isprints" ${barcodepo1[8].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl printgroup="wujia" group="1" r=8 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[8].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden" id="fsprows" name="systemParameterPo.fsprows" value="9">
                          </TD>
						  <TD class="table_none">X轴坐标<input bl=bl x=8 onblur="inputForABS(this)" printgroup="wujia" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[8].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=8 onblur="inputForABS(this)" printgroup="wujia" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[8].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[8].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=8 bl=bl name="systemParameterPo.fspnribs" printgroup="wujia" group="1" onchange="isRotate('8',this)">
							  	<option value="N"  ${barcodepo1[8].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[8].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[8].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[8].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none" colspan="3">
						  	<select bl=bl s=8 name="systemParameterPo.fspishowbarcodenames" printgroup="wujia" group="1" onchange="isShow('wujia',this)">
							  	<option value="0"  ${barcodepo1[8].fspishowbarcodename == '0' ? 'selected="selected"':'' }>隐藏</option>
							  	<option value="1"  ${barcodepo1[8].fspishowbarcodename == '1' ? 'selected="selected"':'' }>显示</option>
							</select>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>
                         
                         <c:if test="${ctype eq '4' || ctype eq '5'}">
                         <TR>   
                          <TD class="table_body" align="right">
                          	效期设置
                          	<input bl=bl group="1" r=19 type="checkbox" id="isprints" ${barcodepo1[19].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl printgroup="xiaoqi" group="1" r=19 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[19].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden" id="fsprows" name="systemParameterPo.fsprows" value="20">
                          </TD>
						  <TD class="table_none">X轴坐标<input bl=bl x=19 onblur="inputForABS(this)" printgroup="xiaoqi" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[19].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=19 onblur="inputForABS(this)" printgroup="xiaoqi" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[19].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[19].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=19 bl=bl name="systemParameterPo.fspnribs" printgroup="xiaoqi" group="1" onchange="isRotate('19',this)">
							  	<option value="N"  ${barcodepo1[19].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[19].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[19].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[19].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none" colspan="3">
						  	<select bl=bl s=19 name="systemParameterPo.fspishowbarcodenames" printgroup="xiaoqi" group="1" onchange="isShow('xiaoqi',this)">
							  	<option value="0"  ${barcodepo1[19].fspishowbarcodename == '0' ? 'selected="selected"':'' }>隐藏</option>
							  	<option value="1"  ${barcodepo1[19].fspishowbarcodename == '1' ? 'selected="selected"':'' }>显示</option>
							</select>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>
                         
                         <TR>   
                          <TD class="table_body" align="right">
                          	批号设置
                          	<input bl=bl group="1" r=20 type="checkbox" id="isprints" ${barcodepo1[20].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl printgroup="pici" group="1" r=20 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[20].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden" id="fsprows" name="systemParameterPo.fsprows" value="21">
                          </TD>
						  <TD class="table_none">X轴坐标<input bl=bl x=20 onblur="inputForABS(this)" printgroup="pici" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[20].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=20 onblur="inputForABS(this)" printgroup="pici" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[20].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[20].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=20 bl=bl name="systemParameterPo.fspnribs" printgroup="pici" group="1" onchange="isRotate('20',this)">
							  	<option value="N"  ${barcodepo1[20].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[20].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[20].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[20].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none" colspan="3">
						  	<select bl=bl s=20 name="systemParameterPo.fspishowbarcodenames" printgroup="pici" group="1" onchange="isShow('pici',this)">
							  	<option value="0"  ${barcodepo1[20].fspishowbarcodename == '0' ? 'selected="selected"':'' }>隐藏</option>
							  	<option value="1"  ${barcodepo1[20].fspishowbarcodename == '1' ? 'selected="selected"':'' }>显示</option>
							</select>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
                         </TR>
                         </c:if>
                         
                         <TR>   
						  <TD class="table_none" colspan="8">&nbsp;</TD>
                         </TR>
                         
                         <TR>   
                          <TD class="table_body" align="right">
                          	自定义1设置
                          	<input bl=bl group="1" r=9 type="checkbox" id="isprints" ${barcodepo1[9].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=9 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[9].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="10">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=9 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[9].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=9 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[9].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[9].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=9 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('9',this)">
							  	<option value="N"  ${barcodepo1[9].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[9].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[9].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[9].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	<input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks1" name="systemParameterPo.fspyouthinks1" value="${barcodepo1[9].fspyouthink1 }" maxlength="40"/>
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义2设置
                          	<input bl=bl group="1" r=10 type="checkbox" id="isprints" ${barcodepo1[10].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=10 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[10].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="11">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=10 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[10].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=10 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[10].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[10].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=10 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('10',this)">
							  	<option value="N"  ${barcodepo1[10].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[10].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[10].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[10].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks2" name="systemParameterPo.fspyouthinks2" value="${barcodepo1[10].fspyouthink2 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义3设置
                          	<input bl=bl group="1" r=11 type="checkbox" id="isprints" ${barcodepo1[11].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=11 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[11].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="12">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=11 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[11].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=11 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[11].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[11].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=11 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('11',this)">
							  	<option value="N"  ${barcodepo1[11].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[11].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[11].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[11].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks3" name="systemParameterPo.fspyouthinks3" value="${barcodepo1[11].fspyouthink3 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义4设置
                          	<input bl=bl group="1" r=12 type="checkbox" id="isprints" ${barcodepo1[12].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=12 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[12].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="13">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=12 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[12].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=12 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[12].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[12].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=12 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('12',this)">
							  	<option value="N"  ${barcodepo1[12].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[12].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[12].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[12].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks4" name="systemParameterPo.fspyouthinks4" value="${barcodepo1[12].fspyouthink4 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义5设置
                          	<input bl=bl group="1" r=13 type="checkbox" id="isprints" ${barcodepo1[13].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=13 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[13].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="14">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=13 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[13].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=13 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[13].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[13].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=13 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('13',this)">
							  	<option value="N"  ${barcodepo1[13].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[13].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[13].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[13].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks5" name="systemParameterPo.fspyouthinks5" value="${barcodepo1[13].fspyouthink5 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义6设置
                          	<input bl=bl group="1" r=14 type="checkbox" id="isprints" ${barcodepo1[14].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=14 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[14].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="15">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=14 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[14].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=14 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[14].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[14].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=14 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('14',this)">
							  	<option value="N"  ${barcodepo1[14].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[14].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[14].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[14].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks6" name="systemParameterPo.fspyouthinks6" value="${barcodepo1[14].fspyouthink6 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义7设置
                          	<input bl=bl group="1" r=15 type="checkbox" id="isprints" ${barcodepo1[15].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=15 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[15].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="16">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=15 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[15].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=15 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[15].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[15].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=15 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('15',this)">
							  	<option value="N"  ${barcodepo1[15].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[15].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[15].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[15].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks7" name="systemParameterPo.fspyouthinks7" value="${barcodepo1[15].fspyouthink7 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义8设置
                          	<input bl=bl group="1" r=16 type="checkbox" id="isprints" ${barcodepo1[16].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=16 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[16].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="17">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=16 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[16].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=16 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[16].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[16].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=16 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('16',this)">
							  	<option value="N"  ${barcodepo1[16].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[16].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[16].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[16].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks8" name="systemParameterPo.fspyouthinks8" value="${barcodepo1[16].fspyouthink8 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"        name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义9设置
                          	<input bl=bl group="1" r=17 type="checkbox" id="isprints" ${barcodepo1[17].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=17 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[17].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="18">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=17 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[17].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=17 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[17].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[17].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=17 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('17',this)">
							  	<option value="N"  ${barcodepo1[17].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[17].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[17].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[17].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks9" name="systemParameterPo.fspyouthinks9" value="${barcodepo1[17].fspyouthink9 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks10"       name="systemParameterPo.fspyouthinks10" />
						  </TD>
						 </TR>
						 
						 <TR>   
                          <TD class="table_body" align="right">
                          	自定义10设置
                          	<input bl=bl group="1" r=18 type="checkbox" id="isprints" ${barcodepo1[18].fspisprint != '1' ? '':'checked'} value="1" onclick="checkIsPrint(this);">
                          	<input bl=bl group="1" r=18 type="hidden" id="fspisprints" name="systemParameterPo.fspisprints" value="${barcodepo1[18].fspisprint ne '1' ? '0' : '1' }">
                          	<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="hidden"  id="fsprows" name="systemParameterPo.fsprows" value="19">
                          </TD>
                          <TD class="table_none">X轴坐标<input bl=bl x=18 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspxs" name="systemParameterPo.fspxs" value="${barcodepo1[18].fspx }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">Y轴坐标<input bl=bl y=18 onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspys" name="systemParameterPo.fspys" value="${barcodepo1[18].fspy }" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印字体大小<input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text" id="fspsizes" name="systemParameterPo.fspsizes" value="${barcodepo1[18].fspsize }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_none">打印方向<select z=17 bl=bl name="systemParameterPo.fspnribs" group="1" onchange="isRotate('18',this)">
							  	<option value="N"  ${barcodepo1[18].fspnrib != 'N' ? '':'selected="selected"' }>正常</option>
							  	<option value="R"  ${barcodepo1[18].fspnrib != 'R' ? '':'selected="selected"' }>向左翻转90度</option>
								<option value="I"  ${barcodepo1[18].fspnrib != 'I' ? '':'selected="selected"' }>向左翻转180度</option>
								<option value="B"  ${barcodepo1[18].fspnrib != 'B' ? '':'selected="selected"' }>向左翻转270度</option>
							  </select>
						  </TD>
						  <TD class="table_none">
						  	自定义内容
						  	<input bl=bl group="1" type="hidden" name="systemParameterPo.fspishowbarcodenames" group="1" value="0">&nbsp;
						  </TD>
						  <TD class="table_none" colspan="2">
						  	  <input bl=bl group="1" class="text_input240" type="text" id="fspyouthinks10" name="systemParameterPo.fspyouthinks10" value="${barcodepo1[18].fspyouthink10 }" maxlength="40"/>
						  	  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks1"        name="systemParameterPo.fspyouthinks1" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks2"        name="systemParameterPo.fspyouthinks2" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks3"        name="systemParameterPo.fspyouthinks3" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks4"        name="systemParameterPo.fspyouthinks4" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks5"        name="systemParameterPo.fspyouthinks5" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks6"        name="systemParameterPo.fspyouthinks6" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks7"        name="systemParameterPo.fspyouthinks7" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks8"        name="systemParameterPo.fspyouthinks8" />
							  <input type="hidden" bl=bl value=""  group="1" id="fspyouthinks9"        name="systemParameterPo.fspyouthinks9" />
						  </TD>
						 </TR>
						 
						 <TR>
                          <TD class="table_body">每行打印个数</TD>
						  <TD class="table_none"><input class="text_input40" bl=bl onblur="inputForABS(this)" group="1" type="text" id="fsprowprintnum" name="systemParameterPo.fsprowprintnum" value="${barcodepo1[0].fsprowprintnum }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_body">打印间距</TD>
                          <TD class="table_none"><input bl=bl onblur="inputForABS(this)" group="1" class="text_input40" type="text"  id="fsprowprintspan" name="systemParameterPo.fsprowprintspan" value="${barcodepo1[0].fsprowprintspan }" maxlength="3" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '请填写整数！'}]"></TD>
                          <TD class="table_body">传输端口</TD>
                          <TD class="table_none"><input bl=bl group="1" class="text_input60" type="text" id="fspport" name="systemParameterPo.fspport" value="${barcodepo1[0].fspport }" maxlength="7"></TD>
                          <TD class="table_body" width="7%">字体</TD>
                          <TD class="table_none" colspan="2">
                          	<select id="fspfont" name="systemParameterPo.fspfont">
                          		<option value="AX" ${barcodepo1[0].fspfont == 'AX' ? 'selected="selected"':'' }>AX(105SL)</option>
                          		<option value="A0" ${barcodepo1[0].fspfont == 'A0' ? 'selected="selected"':'' }>A0(GX430t)</option>
                          	</select>
                          </TD>
                         </TR>
                      </TBODY>
                    </TABLE>
					
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                     
					   <TR>
						  <TD align="left"><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();"></TD>
                        </TR>                     
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                     
					   <TR>
						  <TD align="left"><font color="red">
						  X轴：用来控制打印区域的左右方向调整，一般以0为起点，数字越大越靠右。（只能输入正整数）</br></br>
						  Y轴：用来控制打印区域的上下方向调整，一般以0为起点，数字越大越靠下。（只能输入正整数）</br></br>
						     字体大小：用来控制打印区域内打印的大小，数字越大打印字符或二维码就越大。（只能输入正整数）</br></br>
						     每行打印个数：用来控制每行可以打印多少个此类条码签。（只能输入正整数）</br></br>
						     每行打印个数：用来控制每个打印条码签的间距，每隔多少坐标再打印一个。（只能输入正整数）</font>
						  </TD>
                        </TR>                     
                    </TABLE>
                  </DIV>
                </DIV>
                </TD>
                <TD width=24 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
              </TR></TBODY></TABLE></TD></TR>
              <tr>
              <TD width=24 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
              </tr>
    </TBODY></TABLE></TD></TR></TBODY></TABLE></DIV>
</form>
  </body>
</html>
