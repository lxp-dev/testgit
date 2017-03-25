<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/zone.js"></script>
<title>系统参数设定</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;");
	    $("img[btn=btn]").mouseover(function () { 
	    	$(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	    	$(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        });
        $('input[name=showsupplier]').each(function(){
            if($(this).val()=='${systemParameterPo.fspshowsupplier}'){
            	$(this).attr("checked",true);
            }
        });
        if($('input[name=systemParameterPo.fsppjbillsetup]:checked').val()==0||$('input[name=systemParameterPo.fsppjbillsetup]:checked').val()==''){
            $('#pjdRes').hide();
        }
        
        var fspstealtheffective = $("input[id=fspstealtheffective]:checked").val();
        
        if( (fspstealtheffective == 1 || fspstealtheffective == 2) && $("#companyAdmin").val() == "companyAdmin" ) {
            $('#showPrintStealth').show();
        } else {
            $('#showPrintStealth').hide();
        }
    }); 

    function initCompanyAdminLoginShowMenu() {
        var showCompanyAdminMenu = $("#companyAdmin").val();
        if(showCompanyAdminMenu == "companyAdmin") {
            $("tr[customerAdmin=customerAdmin]").each(function() {
                $(this).hide();
            });
        	$("tr[companyAdmin=companyAdmin]").each(function() {
            	$(this).show();
        	});
        	$("tr[companyAdmin=companyAdmin_customerAdmin]").each(function() {
            	$(this).show();
        	});
			$('tr[id=trremovezero]').hide();
        } else {
        	$("tr[companyAdmin=companyAdmin]").each(function() {
            	$(this).hide();
        	});
            $("tr[customerAdmin=customerAdmin]").each(function() {
            	if($(this).attr("aaa")){
            		alert($(this).attr("aaa"));
            	}
                $(this).show();
            });
            if($("input[id=fspremove]:checked").val() == '0') {
    			$('tr[id=trremovezero]').hide();
            } else {
    			$('tr[id=trremovezero]').show();
            }

    		//初始化页面时,显示/隐藏 销售页面打折窗口是否显示折扣率的 TR
    		if($("input[id=fspalldiscount3]:checked").val()=='3'){
    				$('tr[id=isShowDiscount3Detail]').show();
    		}else{
    				$('tr[id=isShowDiscount3Detail]').hide();
    		}
        }
    	changeAddressType('${systemParameterPo.fspaddresstype}');
    	isshowtextphone('${systemParameterPo.fspshortmessage}');
    }
    
	var s = '';
	var opt0 = ["省份","地级市","市、县级市、县"];
	
	$(document).ready(function() { 
		for(var i=1; i < 11; i++){
			if($("input[id=r"+i+"]").attr("checked")){
				$("div[id=r"+i+"]").show();
				$("div[id=r"+accAdd(i,1)+"]").show();
			}
		}
		var sizenum = 1;
        <c:forEach var="po" items="${departmentsPos}">
    	if('${po.bdpwhichretail }'){
        	$("div[id=r"+'${po.bdpwhichretail }'+"]").show();
        	if('${po.bdpwhichretail }'==1){
			$("div[id=r"+'${po.bdpwhichretail }'+"]").text("标准零售价(已被使用)");
        	}else{
        		for(var i=2; i<=parseFloat('${po.bdpwhichretail }'); i++){
        			$("input[type=checkbox][id=r"+i+"]").attr("nochange","nochange");
        		}
        		$("div[id=r"+'${po.bdpwhichretail }'+"]").text("零售价"+'${po.bdpwhichretail }'+"(已被使用)");
        	}
			if(parseFloat('${po.bdpwhichretail }') > sizenum){
				sizenum = parseFloat('${po.bdpwhichretail }');
			}
			$("input[id=disabled"+'${po.bdpwhichretail }'+"]").attr("disabled","");
        }
		</c:forEach>
		
        $("div[id=r"+accAdd(sizenum,1)+"]").show();
        
		s = new Array();
		s[0] = document.getElementById("zone1");
		s[1] = document.getElementById("zone2");
		s[2] = document.getElementById("zone3");
		
		for(i=0;i<s.length-1;i++){
			s[i].onchange=new Function("change("+(i+1)+")");
		}
		
		change(0);
		document.getElementById("zone1").selectedIndex = 26;
		change(1);
		document.getElementById("zone3").selectedIndex = 2;
		//区域赋值 Begin	
		
		var zones="${systemParameterPo.fspcustomeraddress}".split(",");	
			
		if(zones.length>0){
			var options = "";
			for(j=0;j<zones.length;j++){
			
			if(j==0){
				var zone1 = zones[0].trim();
				options = document.getElementById("zone1").options;
				for(i = 0;i < options.length;i++){				
					if(options[i].value.trim() == zone1){
						document.getElementById("zone1").selectedIndex = i;
						change(1);
						break;
					}
				}
			}
					
			if(j==1){
				var zone2 = zones[1].trim();
				options = document.getElementById("zone2").options;
				
				for(i = 0;i < options.length;i++){	
					if(options[i].value.trim() == zone2){
						document.getElementById("zone2").selectedIndex = i;
						change(2);
						break;
					}
				}
			}
			
			if(j==2){
				var zone3 = zones[2].trim();
				options = document.getElementById("zone3").options;
				for(i = 0;i < options.length;i++){				
					if(options[i].value.trim() == zone3){
						document.getElementById("zone3").selectedIndex = i;
						change(3);
						break;
					}
				}
			}
		}
		}
	//区域赋值 End		
		var fspcjjs="${systemParameterPo.fspcjj}".split(",");
		for(var i=0; i<fspcjjs.length; i++){
			$("input[id=fspcjj"+fspcjjs[i].trim()+"]").attr("checked","checked");
		}

		var fspcpjs="${systemParameterPo.fspcpj}".split(",");
		for(var i=0; i<fspcpjs.length; i++){
			$("input[id=fspcpj"+fspcpjs[i].trim()+"]").attr("checked","checked");
		}

		var fspcjps="${systemParameterPo.fspcjp}".split(",");
		for(var i=0; i<fspcjps.length; i++){
			$("input[id=fspcjp"+fspcjps[i].trim()+"]").attr("checked","checked");
		}

		var fspcyxjps="${systemParameterPo.fspcyxjp}".split(",");
		for(var i=0; i<fspcyxjps.length; i++){
			$("input[id=fspcyxjp"+fspcyxjps[i].trim()+"]").attr("checked","checked");
		}

		var fspchlys="${systemParameterPo.fspchly}".split(",");
		for(var i=0; i<fspchlys.length; i++){
			$("input[id=fspchly"+fspchlys[i].trim()+"]").attr("checked","checked");
		}

		var fspctyjs="${systemParameterPo.fspctyj}".split(",");
		for(var i=0; i<fspctyjs.length; i++){
			$("input[id=fspctyj"+fspctyjs[i].trim()+"]").attr("checked","checked");
		}

		var fspchcs="${systemParameterPo.fspchc}".split(",");
		for(var i=0; i<fspchcs.length; i++){
			$("input[id=fspchc"+fspchcs[i].trim()+"]").attr("checked","checked");
		}

		var fspclhs="${systemParameterPo.fspclh}".split(",");
		for(var i=0; i<fspclhs.length; i++){
			$("input[id=fspclh"+fspclhs[i].trim()+"]").attr("checked","checked");
		}

		var fspcsgs="${systemParameterPo.fspcsg}".split(",");
		for(var i=0; i<fspcsgs.length; i++){
			$("input[id=fspcsg"+fspcsgs[i].trim()+"]").attr("checked","checked");
		}
		
		var fspdjsbmfortypes="${systemParameterPo.fspdjsbmfortype}".split(",");
		for(var i=0; i<fspdjsbmfortypes.length; i++){
			$("input[id=fspdjsbmfortype"+fspdjsbmfortypes[i].trim()+"]").attr("checked","checked");
		}
	});		
	
	function save(){
		var remove = '';
		$('#fspremove').each(function (){
			if($(this).is(":checked")&&$(this).val()=='1'){ 
				remove = '1';
			}
		});
		if($('input[name=showsupplier]:checked').val()==undefined && $("#companyAdmin").val() != "companyAdmin" ){
				alert("请设置商品目录树是否显示制造商级！");
				return;
		}
		if($('#input[id=billsetup2]').attr("checked")){
			$('input[name=systemParameterPo.fsppjbillsetuptime]').atter("validate","");
		}
		//获取库存综合查询必选查询条件 begin
		var showCompanyAdminMenu = $("#companyAdmin").val();
		var KCquery='';
		if(!$('#stockqueryconditions4').attr("checked")){
			$('input[name=fspstockqueryconditions]:checked').each(function(){
					KCquery=KCquery+$(this).val()+',';
				//alert(KCquery)
			});
			
			 if (KCquery.lastIndexOf(',') > -1) {
				 KCquery = KCquery.substring(0, KCquery.lastIndexOf(','));
		      }
			 if(showCompanyAdminMenu == "companyAdmin") {
				 if($('#fspsharestockmessage').attr('checked')){
					 if(KCquery==''){
						 alert("在库存共享设置下,请选择库存查询条件！");
						 return;
					 }
				 }
			 }
		}else{
			KCquery=$('#stockqueryconditions4').val();
		}
		//获取库存综合查询必选查询条件 end
		var removenumber = $('#fspremovenumber').val();
		if(remove == '1' && $("#companyAdmin").val() != "companyAdmin"){
			if(removenumber == ''){
				alert("请填写抹零金额！");
				return;
			}else{
				if($("#fspremovenumber").val() > 0 || $("#fspremovenumber").val() == ''){
					
				}else{
					alert("金额输入有误！");
					$("#fspremovenumber").select();
					return;
				}
			}
		}

		if($("input[name=systemParameterPo.fspallocationatuotime]").val() > 0 && $("#companyAdmin").val() != "companyAdmin"){
		}else if($("#companyAdmin").val() != "companyAdmin"){
			alert("配镜发料（自动刷新）时间 格式有误！");
			$("input[name=systemParameterPo.fspallocationatuotime]").select();
			return;
		}

		if($("input[name=systemParameterPo.fspallocationatuotime]").val() < 30 && $("#companyAdmin").val() != "companyAdmin"){
			alert("配镜发料（自动刷新）时间应大于30秒!");
			$("input[name=systemParameterPo.fspallocationatuotime]").select();
			return;
		}
		
		if($("input[id=billsetup1][value=1]").attr("checked")){
			if($("#fsppjbillsetuptime").val() < 30){
				alert("配镜单查询（自动刷新）时间应大于30秒!");
				$("#fsppjbillsetuptime").select();
				return;
			}
		}

        if ('${systemParameterPo.fspreportdateflag}' == '3'){
            if (Number($('#fspreportLastMonth').val()) > Number($('#fspreportMonth').val())){
                alert('月份间隔选择有误,请重新选择!');
                $('#fspreportLastMonth').focus();
                return;
            }
        }
        
		if($('input[name=systemParameterPo.fsppjbillsetup]:checked').val()==1){
			if($('input[name=systemParameterPo.fsppjbillsetuptim]').val()==''){
				alert("请填写配镜单自动刷新时间!");
				return;
			}
		}
		
		if($("#fspreportMonth").val() == $("#fspreportLastMonth").val()) {
			if(parseFloat($("#fspreportbgndate").val()) > parseFloat($("#fspreportenddate").val())) {
				alert("起始日期不能大于结束日期!");
				$("#fspreportbgndate").select();
				return;
			}
		}
        if($("input[id=fspiscountperfrom1]:checked").val() == '1' && $("input[id=fspcollecttype1]:checked").val() == undefined){
        	alert("是否纳入实际收入选择现金时,付款方式中现金必选!");
        	return;
        }
        if($("input[id=fspiscountperfrom2]:checked").val() == '2' && $("input[id=fspcollecttype2]:checked").val() == undefined){
        	alert("是否纳入实际收入选择银行卡时,付款方式中银行卡必选!");
        	return;
        }
        if($("input[id=fspiscountperfrom3]:checked").val() == '3' && $("input[id=fspcollecttype3]:checked").val() == undefined){
        	alert("是否纳入实际收入选择积分消费时,付款方式中积分消费必选!");
        	return;
        }
        if($("input[id=fspiscountperfrom4]:checked").val() == '4' && $("input[id=fspcollecttype4]:checked").val() == undefined){
        	alert("是否纳入实际收入选择储值卡时,付款方式中储值卡必选!");
        	return;
        }
        if($("input[id=fspiscountperfrom7]:checked").val() == '7' && $("input[id=fspcollecttype7]:checked").val() == undefined){
        	alert("是否纳入实际收入选择代金券时,付款方式中代金券必选!");
        	return;
        }
        if($("input[id=fspiscountperfrom6]:checked").val() == '6' && $("input[id=fspcollecttype6]:checked").val() == undefined){
        	alert("是否纳入实际收入选择其他时,付款方式中其他必选!");
        	return;
        }

        if (($("input[name=systemParameterPo.fspissalesmessageshareforvandv]:checked").val() == '0' || $("input[name=systemParameterPo.fspissalesmessageshareformandv]:checked").val() == '0') && $('#fspdefaultmemberid').val() != ''){
        	alert("在公司之间会员不共享的情况下，不能为辅料销售设置默认会员卡，请先清除已设置的默认会员卡!");
        	return;
        }
		
		if(checkForm(companyNameForm)){
			$("img").removeAttr("onclick");
			companyNameForm.action = "insertSystemParameter.action?KCquery="+KCquery+"&showsupplier="+$('input[name=showsupplier]:checked').val();
			companyNameForm.submit();
		}
	}
	
	$(document).ready(function (){
		if('${systemParameterPo.fspstockqueryconditions}'!=''){
			var KCqueryconditions = '${systemParameterPo.fspstockqueryconditions}'.split(',');
			for(var i=0; i<KCqueryconditions.length; i++){
				$('#stockqueryconditions'+KCqueryconditions[i].trim()).attr("checked","checked");
			}
		}
		showKC();
		var salestype = '${systemParameterPo.fspcollecttype}'.split(',');
		for(var i=0; i<salestype.length; i++){
			$('#fspcollecttype'+salestype[i].trim()).attr("checked","checked");
		}
		var countperfrom = '${systemParameterPo.fspiscountperfrom}'.split(',');
		for(var i=0; i<countperfrom.length; i++){
			$('#fspiscountperfrom'+countperfrom[i].trim()).attr("checked","checked");
		}
		
		var accessorysalestype = '${systemParameterPo.fspaccessorysalestype}'.split(',');
		for(var i=0; i<accessorysalestype.length; i++){
			$('#fspaccessorysalestype'+accessorysalestype[i].trim()).attr("checked","checked");
		}
		
		var alldiscount = '${systemParameterPo.fspalldiscount}'.split(',');

		var optionnum = 0;
		for(var i=0; i<alldiscount.length; i++){
			$('#fspalldiscount'+alldiscount[i].trim()).attr("checked","checked");
			var options = "";
			if(alldiscount[i].trim() == '1'){
				options = options + "<option value="+alldiscount[i].trim()+">默认:打折卡打折</option>";
				optionnum = optionnum + 1;

			}else if(alldiscount[i].trim() == '3'){
				options = options + "<option value="+alldiscount[i].trim()+">默认:员工打折</option>";
				optionnum = optionnum + 1;
			}
			$('select[id=fspdefaultdiscounttype]').append(options);
		}
		$('select[id=fspdefaultdiscounttype]').children().each(function(){
		    if($(this).val() == '${systemParameterPo.fspdefaultdiscounttype}'){
		    	$(this).attr("selected","selected");
			}
		});

		if(optionnum == 0){
			$('select[id=fspdefaultdiscounttype]').hide();
		}else{
			$('select[id=fspdefaultdiscounttype]').show();
		}
		if('${systemParameterPo.fspremove}' == '0' || '${systemParameterPo.fspremove}' == ''){
			$('tr[id=trremovezero]').show();
		}else{
			$('tr[id=trremovezero]').hide();
		}
		
		if('${systemParameterPo.fspbarcodetype}' == '3'){
			$('tr[id=tryxxq]').hide();
			$('tr[id=ishowbarcodetype1]').hide();
			$('tr[id=ishowbarcodetype2]').hide();
			$('tr[id=pjfltmsz]').hide();
		}else{
			$('tr[id=tryxxq]').show();
			$('tr[id=ishowbarcodetype1]').show();
			$('tr[id=ishowbarcodetype2]').show();
			$('tr[id=pjfltmsz]').show();			
		}
		
		var stype = '${systemParameterPo.fspshortmessage}';
		if(stype == '0'){
			$('input[id=fspbirthday][value=0]').attr("checked","checked");
			$('input[id=fspbirthdaycallday]').val('');
			$('input[id=fspbirthdaycallhour]').val('');
			$('tr[id=birthday]').hide();
			$('#birthdaydiv').hide();
		}else{
			$('tr[id=birthday]').show();
		}
		
		var btype = '${systemParameterPo.fspbirthday}';
		if(btype == '0'){
			$('input[id=fspbirthdaycallday]').val('');
			$('input[id=fspbirthdaycallhour]').val('');
			$('#birthdaydiv').hide();
		}else{
			$('#birthdaydiv').show();
		}
		
		if('${systemParameterPo.fsprtx}' == '1' && $("#companyAdmin").val() == "companyAdmin"){
			$("tr[id=trrtx]").show();
		}else{
			$("tr[id=trrtx]").hide();
		}

		initCompanyAdminLoginShowMenu();
		disab();
    	var salestype = "${systemParameterPo.fspsalestype}";
		if(salestype == '0'){
			$("tr[id=glassischecknumber]").show();
			$("tr[id=salesquerygoodsstroage]").hide();
		}else{
			$("tr[id=glassischecknumber]").hide();
			$("tr[id=salesquerygoodsstroage]").show();
		}
		
		if('${systemParameterPo.fspdjsbm }' == '2'){
        	$("tr[id=djsbmfortype]").hide();
        }
	});
	
	function isremovezero(obj){
		var type = $(obj).val();
		
		if(type == '1' && $("#companyAdmin").val() != "companyAdmin"){
			$('tr[id=trremovezero]').show();
			$('#fspremovenumber').val('${systemParameterPo.fspremovenumber }');
		}else{
			
			$('#fspremovenumber').val('');
			$('tr[id=trremovezero]').hide();
		}
	}
	
	function barcodetype(obj){
		var btype = $(obj).val();
		if(btype == '3'){
			$('input[id=fspstealtheffective][value=0]').attr("checked","checked");
			$('input[id=fspeffectivealert][value=0]').attr("checked","checked");
			$('input[id=fspoutmaterialsflag][value=0]').attr("checked","checked");
			
			$('tr[id=tryxxqtx]').hide();
			$('tr[id=tryxxq]').hide();
			$('tr[id=pjfltmsz]').hide();
			$('tr[id=showPrintStealth]').hide();
		}else{
			$('tr[id=tryxxqtx]').show();
			$('tr[id=tryxxq]').show();
			$('tr[id=pjfltmsz]').show();

			if ('${systemParameterPo.fspstealtheffective}' != '0'){
				$('tr[id=showPrintStealth]').show();
		    }
		}
	}
	
	function shortMessagetype(obj){
		var stype = $(obj).val();
		if(stype == '0'){
			$('input[id=fspbirthday][value=0]').attr("checked","checked");
			$('input[id=fspbirthdaycallday]').val('');
			$('input[id=fspbirthdaycallhour]').val('');
			$('tr[id=birthday]').hide();
			$('#birthdaydiv').hide();
		}else{
			$('tr[id=birthday]').show();
		}
	}
	
	function birthday(obj){
		var btype = $(obj).val();
		if(btype == '0'){
			$('input[id=fspbirthdaycallday]').val('');
			$('input[id=fspbirthdaycallhour]').val('');
			$('#birthdaydiv').hide();
		}else{
			$('#birthdaydiv').show();
		}
	}
	
	function addZero(obj){
		if($(obj).val() >= 0 || $(obj).val() <= 0){
			$(obj).val(parseFloat($(obj).val()).toFixed(2));
		}else{
			
		}
	}
	
	function imgclick(src){
		var id = src.src;
		var width = $(src).attr("width2");
		var height = $(src).attr("height2");
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,600,300,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("lookimage.action?id="+EncodeUtf8(id)+"&width="+width+"&height="+height,900,500,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【打印样式预览】";
	}
	
	function isShowRTX(obj){
		if($(obj).val() == '0' || $("#companyAdmin").val() != "companyAdmin"){
			$("tr[id=trrtx]").hide();
			$("#fspserverip").val("");
			$("#fspeimsip").val("");
		}else{
			$("tr[id=trrtx]").show();
		}
	}

	function changeAddressType(typeid){
		if(typeid == '0'){
			$("tr[id=tradress3]").show();
			$("tr[id=tradress5]").hide();
		}else{
			$("tr[id=tradress3]").hide();
			$("tr[id=tradress5]").show();
		}
	}
	
	function addDiscountSelect(obj,name){
		var isfine = 0;
		var optionnum = 0;
		$('select[id=fspdefaultdiscounttype]').children().each(function(){
	      if($(this).val() == $(obj).val()){
	      	if($(obj).attr("checked")){
	      		isfine = isfine + 1;
		    }else{
				$('select[id=fspdefaultdiscounttype] > option[value='+$(obj).val()+']').remove();
				isfine = isfine + 1;
				optionnum = optionnum - 1;
			}
	      }
	      optionnum = optionnum + 1;
		});
		var options = "";
		if(isfine == 0){
			options = options + "<option value="+$(obj).val()+">"+"默认:"+name+"</option>";
			$('select[id=fspdefaultdiscounttype]').append(options);
			optionnum = optionnum + 1;
		}
		if(optionnum == 0){
			$('select[id=fspdefaultdiscounttype]').hide();
		}else{
			$('select[id=fspdefaultdiscounttype]').show();
		}

		//显示/隐藏 销售页面打折窗口是否显示折扣率的 TR
		if($(obj).val()=='3'){
			if($(obj).attr("checked")){
				$('tr[id=isShowDiscount3Detail]').show();
			}else{
				$('tr[id=isShowDiscount3Detail]').hide();
			}
		}		
	}

	function updateReportDate(value){
        if (value == '3'){
            $('#fspreportMonth').removeAttr('disabled').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请选取日期间隔！\'}]").val('');
            $('#fspreportbgndate').removeAttr('disabled').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写日期！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请重新填写日期！\'}]").val('');
            $('#fspreportenddate').removeAttr('disabled').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写日期！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'请重新填写日期！\'}]").val('');   
        }else{
            $('#fspreportMonth').removeAttr('validate').attr('disabled','disabled').val('');
            $('#fspreportbgndate').removeAttr('validate').attr('disabled','disabled').val('');
            $('#fspreportenddate').removeAttr('validate').attr('disabled','disabled').val('');          
        }
	}

    function addZero(obj){
        if ($.trim(obj.value) == ''){
        	obj.value = '';
        	return;
        }
        if (Number($.trim(obj.value)) > 31){
        	alert('该日期已超过31日,请重新选取查询日期!');
        	return;
        }
        if (obj.value.length == 1 && (Number($.trim(obj.value)) > 0 || Number($.trim(obj.value)) < 10)){
        	obj.value = '0' + obj.value;
        }
    }

	function mendtype(ctype,barcodetype){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initMendBarcode.action?ctype="+ctype+"&barcodetype="+barcodetype,600,300,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initMendBarcode.action?ctype="+ctype+"&barcodetype="+barcodetype,900,500,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【条码样式设置】";
	}

	function changeBillTemplate(flag,type,hid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initPrintBillTemplateOpen.action?moduleID=${requestScope.moduleID}&flag="+flag+"&type="+type+"&hid="+hid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPrintBillTemplateOpen.action?moduleID=${requestScope.moduleID}&flag="+flag+"&type="+type+"&hid="+hid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【报表样式查询】";
	}

	function changeBillTemplateValues(id,value,flag,type){
		if (flag == '1'){
			$('#fspsalesbillstyle'+type).val(id);
	        $('#fspsalesbillstyleurl'+type).attr('src',value);
		}
		if (flag == '2'){
			$('#fspsubscriptionbillstyle').val(id);
	        $('#fspsubscriptionbillstyleurl').attr('src',value);
		}
		if (flag == '3'){
			$('#fspregisterbillstyle').val(id);
	        $('#fspregisterbillstyleurl').attr('src',value);
		}

	}

	function showKC(){
		if($("#fspsharestockmessage").attr("checked") && $("#customerAdmin").val() != "customerAdmin"){
			$('#KCqueryConditions').show();
		}else{
			$('#KCqueryConditions').hide();
		}
	}
	function disab(){
		if($("#stockqueryconditions4").attr("checked")){
			$("#stockqueryconditions1").attr("disabled","disabled");	
			$("#stockqueryconditions2").attr("disabled","disabled");
			$("#stockqueryconditions3").attr("disabled","disabled");
		}else{
			$("#stockqueryconditions1").attr("disabled","");	
			$("#stockqueryconditions2").attr("disabled","");
			$("#stockqueryconditions3").attr("disabled","");
			if($("#stockqueryconditions1").attr("checked")||$("#stockqueryconditions2").attr("checked")||$("#stockqueryconditions3").attr("checked")){
			$("#stockqueryconditions4").attr("disabled","disabled");
			}
			if(!$("#stockqueryconditions1").attr("checked")&&!$("#stockqueryconditions2").attr("checked")&&!$("#stockqueryconditions3").attr("checked")){
				$("#stockqueryconditions4").attr("disabled","");
			}
		}
	}
	function ishowpjbillsetuptime(){
		 if($('input[name=systemParameterPo.fsppjbillsetup]:checked').val()==0){
	            $('#pjdRes').hide();
	        }
		 if($('input[name=systemParameterPo.fsppjbillsetup]:checked').val()==1){
	            $('#pjdRes').show();
	        }
	}
	
	function checksalestype(obj){
		var type = $(obj).val();
		if(type == '0'){
			$("tr[id=glassischecknumber]").show();
			$("input[name=systemParameterPo.fspglassischecknumber][value=0]").attr("checked","checked");

			$("tr[id=salesquerygoodsstroage]").hide();
			$("input[name=systemParameterPo.fspquerygoodsstorage][value=1]").attr("checked","checked");
		}else{
			$("tr[id=glassischecknumber]").hide();
			$("tr[id=salesquerygoodsstroage]").show();
		}
	}

	//会员地区5级方法
    function getAreaAjaxData(level,pid) {  
    	switch(level)
    	{
    	case "2":
      	  $('#t2').load("getAjaxArea.action?level="+ level +"&pid="+ pid);
      	  $('#t3').empty();
      	  $('#t4').empty();
      	  $('#t5').empty();
      	  showHide();
    	  break;
    	case "3":
      	  $('#t3').load("getAjaxArea.action?level="+ level +"&pid="+ pid);
      	  $('#t4').empty();
      	  $('#t5').empty();      	  
      	  showHide();
      	  break;
    	case "4":
      	  $('#t4').load("getAjaxArea.action?level="+ level +"&pid="+ pid);
      	  $('#t5').empty();      	  
      	  showHide();    	  
      	  break;    
    	case "5":
       	  $('#t5').load("getAjaxArea.action?level="+ level +"&pid="+ pid);
      	  showHide();      	  
       	  break;       	    	  
    	}
    }	

	//会员地区5级方法	
    function showHide(){
    	  $('#t1').hide().show(); 
    	  $('#t2').hide().show(); 
    	  $('#t3').hide().show();  
      	  $('#t4').hide().show();  
      	  $('#t5').hide().show();       	  
    }	

    function changeMemberCard(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
    }

	function setCustomer(memberid){
		document.getElementById('fspdefaultmemberid').value = memberid;
	}

	function cleanMemberCard(){
		document.getElementById('fspdefaultmemberid').value = '';
    }
    
    function isshowtextphone(type){
    	if(type == "2"){
    		$("#textphone").show();
    	}else{
    		$("#textphone").hide();
    		$("#fsptextphone").val("");
    	}
    }
    
    function ishidedjsbm(obj){
		var type = $(obj).val();
		
		if(type == '1'){
			$('tr[id=djsbmfortype]').show();
		}else{
			$("input[name=systemParameterPo.fspdjsbmfortype]").attr("checked","");
			$('tr[id=djsbmfortype]').hide();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="companyNameForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="companyAdmin" name="companyAdmin" value="<%=request.getParameter("companyAdmin") %>">
<input type="hidden" disabled="disabled" id="disabled1" name="systemParameterPo.fspretailprice" value="1">
<input type="hidden" disabled="disabled" id="disabled2" name="systemParameterPo.fspretailpricea" value="1">
<input type="hidden" disabled="disabled" id="disabled3" name="systemParameterPo.fspretailpriceb" value="1">
<input type="hidden" disabled="disabled" id="disabled4" name="systemParameterPo.fspretailpricec" value="1">
<input type="hidden" disabled="disabled" id="disabled5" name="systemParameterPo.fspretailpriced" value="1">
<input type="hidden" disabled="disabled" id="disabled6" name="systemParameterPo.fspretailpricee" value="1">
<input type="hidden" disabled="disabled" id="disabled7" name="systemParameterPo.fspretailpricef" value="1">
<input type="hidden" disabled="disabled" id="disabled8" name="systemParameterPo.fspretailpriceg" value="1">
<input type="hidden" disabled="disabled" id="disabled9" name="systemParameterPo.fspretailpriceh" value="1">
<input type="hidden" disabled="disabled" id="disabled10" name="systemParameterPo.fspretailpricei" value="1">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>系统设置</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：系统参数设定 </td>
          </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
	      </TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%""><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
			           <TR companyAdmin="companyAdmin">
                          <TD height="26" width="20%" class="table_body " align="right">条码管理</TD>
                          <TD width="80%" class="table_none " colspan="5">
                            <input type="radio" checked id="fspbarcodetype" name="systemParameterPo.fspbarcodetype" onclick="barcodetype(this);" value="1" ${systemParameterPo.fspbarcodetype != '1' ? '':'checked' }>
                          		采用条码管理方式：商品出库仅使用扫描条码方式选择商品</br>
                            <input type="radio" id="fspbarcodetype" name="systemParameterPo.fspbarcodetype" onclick="barcodetype(this);" value="2" ${systemParameterPo.fspbarcodetype != '2' ? '':'checked' }>
                            	采用条码管理方式：商品出库使用扫描条码、手动添加商品方式选择商品</br>                       
                            <input type="radio" id="fspbarcodetype" name="systemParameterPo.fspbarcodetype" onclick="barcodetype(this);" value="3" ${systemParameterPo.fspbarcodetype != '3' ? '':'checked' }>
								采用非条码管理方式:商品出库仅使用手动添加商品方式选择商品</br>
							 <br/><font style="color: red;">(此项用于采购收货，委外收货，其他出入库，退货，销售出库，调拨，销售，盘点，发料，库存综合查询，不合格品等功能模块中条码显示功能，使用条码后选择的几种方式。)</span>
						  </TD>
					   </TR>
					   
					   <TR valign="middle" id="ishowbarcodetype1" customerAdmin="customerAdmin">
                          <TD width="20%" height="26" class="table_none" align="right">镜架条码样式</TD>
                          <TD width="20%" class="table_none">
                            <img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('1','${systemParameterPo.fspframebarcodetype }')"/>
                            <input type="hidden" id="fspframebarcodetype" name="systemParameterPo.fspframebarcodetype" value="${systemParameterPo.fspframebarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
                          <TD width="13%" height="26" class="table_none" align="right">配件条码样式</TD>
                          <TD width="20%" class="table_none">
                            <img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('2','${systemParameterPo.fsppartsbarcodetype }')"/>
                            <input type="hidden" id="fsppartsbarcodetype" name="systemParameterPo.fsppartsbarcodetype" value="${systemParameterPo.fsppartsbarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
                          <TD width="13%" height="26" class="table_none" align="right">镜片条码样式</TD>
                          <TD class="table_none"> 
                            <img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('3','${systemParameterPo.fspglassbarcodetype }')"/>
                            <input type="hidden" id="fspglassbarcodetype" name="systemParameterPo.fspglassbarcodetype" value="${systemParameterPo.fspglassbarcodetype }">
						  </TD>
					   </TR>

					   <TR valign="middle" id="ishowbarcodetype1" customerAdmin="customerAdmin">
                          <TD height="26" class="table_none" align="right">隐形镜片条码样式</TD>
                          <TD class="table_none">
                            <img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('4','${systemParameterPo.fspstealthbarcodetype }')"/>
                            <input type="hidden" id="fspstealthbarcodetype" name="systemParameterPo.fspstealthbarcodetype" value="${systemParameterPo.fspstealthbarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
                          <TD height="26" class="table_none" align="right">护理液类条码样式</TD>
                          <TD class="table_none">
                            <img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('5','${systemParameterPo.fspsolutionbarcodetype }')"/>
                            <input type="hidden" id="fspsolutionbarcodetype" name="systemParameterPo.fspsolutionbarcodetype" value="${systemParameterPo.fspsolutionbarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
                          <TD height="26" class="table_none" align="right">太阳镜条码样式</TD>
                          <TD class="table_none">
                            <img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('6','${systemParameterPo.fspsunglassesbarcodetype }')"/>
                            <input type="hidden" id="fspsunglassesbarcodetype" name="systemParameterPo.fspsunglassesbarcodetype" value="${systemParameterPo.fspsunglassesbarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
					   </TR>
					   
					   <TR valign="middle" id="ishowbarcodetype1" customerAdmin="customerAdmin">
                          <TD height="26" class="table_none" align="right">耗材条码样式</TD>
                          <TD class="table_none">
                            <img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('7','${systemParameterPo.fspconsumebarcodetype }')"/>
                            <input type="hidden" id="fspconsumebarcodetype" name="systemParameterPo.fspconsumebarcodetype" value="${systemParameterPo.fspconsumebarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
                          <TD height="26" class="table_none" align="right">老花镜条码样式</TD>
                          <TD class="table_none">
                            <img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('8','${systemParameterPo.fspoldglassesbarcodetype }')"/>
                            <input type="hidden" id="fspoldglassesbarcodetype" name="systemParameterPo.fspoldglassesbarcodetype" value="${systemParameterPo.fspoldglassesbarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
                          <TD height="26" class="table_none" align="right">视光条码样式</TD>
                          <TD class="table_none">
                          	<img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('9','${systemParameterPo.fspmetropiabarcodetype }')"/>
                            <input type="hidden" id="fspmetropiabarcodetype" name="systemParameterPo.fspmetropiabarcodetype" value="${systemParameterPo.fspmetropiabarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
					   </TR>
					   
					   <TR valign="middle" id="ishowbarcodetype1" customerAdmin="customerAdmin">
                          <TD height="26" class="table_none" align="right">品种条码样式</TD>
                          <TD class="table_none">
                          	<img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('10','${systemParameterPo.fspbrandbarcodetype }')"/>
                            <input type="hidden" id="fspbrandbarcodetype" name="systemParameterPo.fspbrandbarcodetype" value="${systemParameterPo.fspbrandbarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
                          <TD height="26" class="table_none" align="right">价签样式</TD>
                          <TD class="table_none">
                          	<img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('11','${systemParameterPo.fspjqbarcodetype }')"/>
                            <input type="hidden" id="fspjqbarcodetype" name="systemParameterPo.fspjqbarcodetype" value="${systemParameterPo.fspjqbarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
                          <TD height="26" class="table_none" align="right">打折码样式</TD>
                          <TD class="table_none">
                          	<img src="${ctx}/img/newbtn/configure_0.png" btn=btn onclick="mendtype('12','${systemParameterPo.fspdiscountbarcodetype }')"/>
                            <input type="hidden" id="fspdiscountbarcodetype" name="systemParameterPo.fspdiscountbarcodetype" value="${systemParameterPo.fspdiscountbarcodetype }">
                            <br/><font style="color: red;"></font>
						  </TD>
					   </TR>
					   
					   <TR id="tryxxq" companyAdmin="companyAdmin">
                          <TD height="26" class="table_none " align="right">隐形效期</TD>
                          <TD class="table_none "  colspan="5">
                          	<input type="radio" value="1" checked id="fspstealtheffective" name="systemParameterPo.fspstealtheffective" ${systemParameterPo.fspstealtheffective != '1' ? '':'checked' } onclick="javascript:$('#showPrintStealth').show();">
								使用隐形效期,不允许过期商品销售<br/>
  							<input type="radio" value="2" id="fspstealtheffective" name="systemParameterPo.fspstealtheffective" ${systemParameterPo.fspstealtheffective != '2' ? '':'checked' } onclick="javascript:$('#showPrintStealth').show();">
  								使用隐形效期,允许过期商品销售<br/>
  							<input type="radio" value="0" id="fspstealtheffective" name="systemParameterPo.fspstealtheffective" ${systemParameterPo.fspstealtheffective != '0' ? '':'checked' } onclick="javascript:$('#showPrintStealth').hide();">
  								不使用隐形效期
  							<br/><font color="red">(此项用于采购收货，销售效期提醒、隐形效期查询等功能中设置是否使用隐形效期。)</font>
  						  </TD>
					   </TR> 
					   <TR id="pjfltmsz">
                          <TD height="26" class="table_none " align="right">配镜发料条码设置</TD>
                          <TD class="table_none "  colspan="5">
                          	<input type="radio" value="1" id="fspoutmaterialsflag" ${systemParameterPo.fspoutmaterialsflag eq '1' ? 'checked' : '' } name="systemParameterPo.fspoutmaterialsflag" >
								是&nbsp;&nbsp;&nbsp;&nbsp;
  							<input type="radio" value="0" id="fspoutmaterialsflag" ${systemParameterPo.fspoutmaterialsflag eq '0' ? 'checked' : '' } name="systemParameterPo.fspoutmaterialsflag" >
  								否
  							<br/><font color="red">(此项用于镜片发料时,镜片是否自动扫码。)</font>
  						  </TD>
					   </TR>
					   <TR id="pd_1">
                          <TD height="26" class="table_none " align="right">盘点是否限定类型</TD>
                          <TD class="table_none "  colspan="5">
                          	<input type="radio" value="1" id="fspcheckstorageflag" ${systemParameterPo.fspcheckstorageflag eq '1' ? 'checked' : '' } name="systemParameterPo.fspcheckstorageflag" >
								是&nbsp;&nbsp;&nbsp;&nbsp;
  							<input type="radio" value="0" id="fspcheckstorageflag" ${systemParameterPo.fspcheckstorageflag ne '1' ? 'checked' : '' } name="systemParameterPo.fspcheckstorageflag" >
  								否
  							<br/><font color="red">(此项用于制作盘点单、盘盈盘亏单时，是否需要选择商品类型。)</font>
  						  </TD>
					   </TR>					   
			           <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">打折后保留小数位</TD>
                          <TD class="table_none"  colspan="5">
                              <input type="radio" value="1" checked name="systemParameterPo.fspretained" ${systemParameterPo.fspretained != '1' ? '':'checked' }>
                           		 元
                              <input type="radio" value="2" name="systemParameterPo.fspretained" ${systemParameterPo.fspretained != '2' ? '':'checked' }>
                              	角
                              <input type="radio" value="3" name="systemParameterPo.fspretained" ${systemParameterPo.fspretained != '3' ? '':'checked' }> 
                              	分
                              <br/><font color="red">(此项用于在门店商品销售时，对每条商品的应收金额四舍五入或取整后保留到元、角、分。)</font>
						   </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">辅料销售是否受销售类型限制</TD>
                          <TD class="table_none"  colspan="5">
                              <input type="radio" value="1" name="systemParameterPo.fspcheckaccessories" ${systemParameterPo.fspcheckaccessories != '1' ? '':'checked' }>
                           		受限
                              <input type="radio" value="0" name="systemParameterPo.fspcheckaccessories" ${systemParameterPo.fspcheckaccessories != '0' ? '':'checked' }>
                              	不受限
                              <br/><font color="red">(受限:只有辅料销售才能对辅料进行销售;不受限:任何销售类型都可以对辅料进行销售。)</font>
						   </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">销售金额计算方式</TD>
                          <TD class="table_none"  colspan="5">
                              <input type="radio" value="1" name="systemParameterPo.fspsalescounttype" ${systemParameterPo.fspsalescounttype != '1' ? '':'checked' }>
                           		四舍五入
                              <input type="radio" value="2" name="systemParameterPo.fspsalescounttype" ${systemParameterPo.fspsalescounttype != '2' ? '':'checked' }>
                              	取整
                              <br/><font color="red">(四舍五入:对折扣金额及优惠金额进行四舍五入操作（如：3.66变为3.70）;取整:对折扣金额及优惠金额进行取整操作（如：3.66变为3.60）。)</font>
						   </TD>
					   </TR>
			           <TR customerAdmin="customerAdmin">
			             <TD height="26" class="table_body" align="right">允许抹零</TD>
			             <TD class="table_none"  colspan="5">
						 <input type="radio" value="1" checked id="fspremove" name="systemParameterPo.fspremove" ${systemParameterPo.fspremove != '1' ? '':'checked' } onclick="isremovezero(this)">是
			             <input type="radio" value="0" id="fspremove" name="systemParameterPo.fspremove" ${systemParameterPo.fspremove != '0' ? '':'checked' } onclick="isremovezero(this)">否
						 </TD>
			           </TR>
					   <TR id="trremovezero" >
                          <TD height="26" class="table_none" align="right">抹零金额上限</TD>
                          <TD class="table_none"  colspan="5">
                             <input class="text_input100" maxlength="13" type="text" id="fspremovenumber" name="systemParameterPo.fspremovenumber" value="${systemParameterPo.fspremovenumber }"/>
                                                                                  元
                             <br/><font color="red">(此项用于在销售功能中，允许销售抹零的情况下设置的抹零上限，指定销售中抹零的金额不能超过此值。 )</font>
                          </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
			             <TD height="26" class="table_body" align="right">隐形销售选择当前处方镜片商品后，是否可销售其他处方镜片</TD>
			             <TD class="table_none"  colspan="5">
						 <input type="radio" value="1" checked id="fspsalesstealthother" name="systemParameterPo.fspsalesstealthother" ${systemParameterPo.fspsalesstealthother != '1' ? '':'checked' }/>是
			             <input type="radio" value="0" id="fspsalesstealthother" name="systemParameterPo.fspsalesstealthother" ${systemParameterPo.fspsalesstealthother != '0' ? '':'checked' }/>否
						 </TD>
			           </TR>
					   <TR customerAdmin="customerAdmin">
					     <TD height="26" class="table_body" align="right">打折方式</TD>
					     <TD class="table_none" colspan="5">
					       	<input type="checkbox" value="1" id="fspalldiscount1" name="systemParameterPo.fspalldiscount" onclick="addDiscountSelect(this,'打折卡打折')">
					       	             打折卡打折 
					       	
					       	<input type="checkbox" value="3" id="fspalldiscount3" name="systemParameterPo.fspalldiscount" onclick="addDiscountSelect(this,'员工打折')">
					       	             员工打折
					       	<select id="fspdefaultdiscounttype" name="systemParameterPo.fspdefaultdiscounttype">
					       	</select>
					       	<br/><font color="red">(此项用于设置在销售功能中主要使用的打折方式。)</font>
					     </TD>
					   </TR>
					   <TR id="isShowDiscount3Detail">
					     <TD height="26" class="table_body" align="right">销售页面打折窗口是否显示折扣率</TD>
					     <TD class="table_none" colspan="5">
					       	<input type="radio" value="1" id="fspisshowdiscount3detail" ${systemParameterPo.fspisshowdiscount3detail eq '1' ? 'checked' : '' } name="systemParameterPo.fspisshowdiscount3detail" >
								是&nbsp;&nbsp;&nbsp;&nbsp;
  							<input type="radio" value="0" id="fspisshowdiscount3detail" ${systemParameterPo.fspisshowdiscount3detail eq '0' ? 'checked' : '' } name="systemParameterPo.fspisshowdiscount3detail" >
  								否
					       	<br/><font color="red">(此项用于设置销售页面中，员工打折权限输入后，是否显示出折扣率。)</font>
					     </TD>
					   </TR>					   
					   <TR customerAdmin="customerAdmin">
                           <TD height="26" class="table_body " align="right">付款方式</TD>
                           <TD class="table_none " colspan="5">
						   	<input type="checkbox" value="1" id="fspcollecttype1" name="systemParameterPo.fspcollecttype">
						   	             现金
                            <input type="checkbox" value="3" id="fspcollecttype3" name="systemParameterPo.fspcollecttype">
                                                                                       银行卡
							<input type="checkbox" value="2" id="fspcollecttype2" name="systemParameterPo.fspcollecttype">
							             积分消费
							<input type="checkbox" value="4" id="fspcollecttype4" name="systemParameterPo.fspcollecttype">
							             储值卡
							<input type="checkbox" value="7" id="fspcollecttype7" name="systemParameterPo.fspcollecttype">
							             代金券
							<input type="checkbox" value="6" id="fspcollecttype6" name="systemParameterPo.fspcollecttype">
							             其他
							<br/><font color="red">(此项用于结款管理、欠款管理等功能中主要使用哪种方式进行付款。)</font>
						   </TD>
                       </TR>
					   <TR customerAdmin="customerAdmin">
                           <TD height="26" class="table_body " align="right">结款时现金栏设定</TD>
                           <TD class="table_none " colspan="5">
						   	<input type="checkbox" value="1" id="fspxianjindefault" name="systemParameterPo.fspxianjindefault" ${(systemParameterPo.fspxianjindefault eq '1') ? 'checked':''}>
						   	            默认显示待收款金额
							<br/><font color="red">(此项用于结款管理、欠款管理、中心挂号等功能中是否现金栏默认显示总代收款金额。)</font>
						   </TD>
                       </TR>                       
                       <TR customerAdmin="customerAdmin">
                           <TD height="26" class="table_body " align="right">是否纳入实际收入</TD>
                           <TD class="table_none " colspan="5">
						   	<input type="checkbox" value="1" id="fspiscountperfrom1" name="systemParameterPo.fspiscountperfrom">
						   	             现金
                            <input type="checkbox" value="3" id="fspiscountperfrom3" name="systemParameterPo.fspiscountperfrom">
                                                                                       银行卡
							<input type="checkbox" value="2" id="fspiscountperfrom2" name="systemParameterPo.fspiscountperfrom">
							             积分消费
							<input type="checkbox" value="4" id="fspiscountperfrom4" name="systemParameterPo.fspiscountperfrom">
							             储值卡
							<input type="checkbox" value="7" id="fspiscountperfrom7" name="systemParameterPo.fspiscountperfrom">
							             代金券
							<input type="checkbox" value="6" id="fspiscountperfrom6" name="systemParameterPo.fspiscountperfrom">
							             其他
							<br/><font color="red">(此项用于报表中哪种结算方式是否纳入实际收入。)</font>
						   </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin">
			             <TD height="26" class="table_body" align="right">是否启用商品级别</TD>
			             <TD class="table_none"  colspan="5">
						 <input type="radio" value="1" checked id="fspisusegoodslevel" name="systemParameterPo.fspisusegoodslevel" ${systemParameterPo.fspisusegoodslevel != '1' ? '':'checked' }/>启用
			             <input type="radio" value="0" id="fspisusegoodslevel" name="systemParameterPo.fspisusegoodslevel" ${systemParameterPo.fspisusegoodslevel != '0' ? '':'checked' }/>关闭
			             <br/><font color="red">(此项用于设置门店销售时是否按商品级别进行打折，不同的商品级别设定的折扣不同。)</font>
						 </TD>
			           </TR>
					   <TR companyAdmin="companyAdmin">
						 	 <TD height="26" class="table_body" align="right">负库存</TD>
						     <TD class="table_none" colspan="5">
						     	<input type="radio" value="1" checked name="systemParameterPo.fspsalestype" ${systemParameterPo.fspsalestype != '1' ? '':'checked' } onclick="checksalestype(this)">
						       		允许
						       	<input type="radio" value="0" name="systemParameterPo.fspsalestype" ${systemParameterPo.fspsalestype != '0' ? '':'checked' } onclick="checksalestype(this)">
						       		不允许 
						       	<br/><font color="red">(此项用于在前台销售、商品调拨、销售出库、采购退货、客户批发调货、其他出库等功能中设置商品库存不足时系统是否允许进行商品出库操作。)</font>
						     </TD>
					   </TR>
					   
					   <TR companyAdmin="companyAdmin" id="salesquerygoodsstroage">
                         <TD height="26" class="table_none " align="right">门店销售模块选取商品时库存设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspquerygoodsstorage" ${systemParameterPo.fspquerygoodsstorage == '1' ? 'checked':'' }>
						       		忽略库存
						     	<input type="radio" value="2" name="systemParameterPo.fspquerygoodsstorage" ${systemParameterPo.fspquerygoodsstorage == '2' ? 'checked':'' }>
						       		查看库存
						       	<br/><font color="red">(此项用于设置门店销售模块选取商品时是否需要查看库存。)</font>
                         </TD>
                       </TR>
                       
					   <TR companyAdmin="companyAdmin" id="glassischecknumber">
						 	 <TD height="26" class="table_none" align="right">成品镜片负库存</TD>
						     <TD class="table_none" colspan="5">
						     	<input type="radio" value="1" checked name="systemParameterPo.fspglassischecknumber" ${systemParameterPo.fspglassischecknumber != '1' ? '':'checked' }>
						       		允许
						       	<input type="radio" value="0" name="systemParameterPo.fspglassischecknumber" ${systemParameterPo.fspglassischecknumber != '0' ? '':'checked' }>
						       		不允许 
						       	<br/><font color="red">(此项用于在前台销售功能中设置 成品镜片商品库存不足时系统是否允许进行商品销售操作。)</font>
						     </TD>
					   </TR>
					   <TR companyAdmin="companyAdmin">
                          	<TD height="26" class="table_body " align="right">在途库存设置</TD>
                          	<TD class="table_none " colspan="5">
	                            <input type="radio" name="systemParameterPo.fspintransitstorageflag" ${systemParameterPo.fspintransitstorageflag eq '1' ? 'checked="checked"' : '' } id="fspintransitstorageflag" value="1" />启用
	                            <input type="radio" name="systemParameterPo.fspintransitstorageflag" ${systemParameterPo.fspintransitstorageflag eq '0' ? 'checked="checked"' : '' } id="fspintransitstorageflag" value="0" />停用
	                            <br/><font color="red">(此项设置将会涉及到门店销售、调拨、采购退货、销售出库 等模块在途库存的启停用，启用后将重新创建在途库存，停用后，在途库存全部清空。)</font> 
                       		</TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body " align="right">店店调拨</TD>
                          <TD class="table_none " colspan="5">
						  	<input type="radio" value="1" checked name="systemParameterPo.fspshoptoshop" ${systemParameterPo.fspshoptoshop != '1' ? '':'checked' }>
						  		允许
                            <input type="radio" value="0" name="systemParameterPo.fspshoptoshop" ${systemParameterPo.fspshoptoshop != '0' ? '':'checked' }>
                            	不允许
                            <br/><font color="red">(此项用于调拨功能，是否允许门店与门店直接进行调拨。)</font>
						  </TD>
					   </TR>
					   <TR companyAdmin="companyAdmin">
                          <TD height="26" class="table_body " align="right">调拨是否自动收货</TD>
                          <TD class="table_none " colspan="5">
						  	<input type="radio" value="1" checked 	name="systemParameterPo.fspallocationautoreceipt" ${systemParameterPo.fspallocationautoreceipt != '1' ? '':'checked' }>
						  		是
                            <input type="radio" value="0" 			name="systemParameterPo.fspallocationautoreceipt" ${systemParameterPo.fspallocationautoreceipt != '0' ? '':'checked' }>
                            	否
                            <br/><font color="red">(此项用于调拨功能，调拨审核是否直接变更库存。)</font>
						  </TD>
					   </TR>
					   <TR companyAdmin="companyAdmin">
                          <TD height="26" class="table_body " align="right">仓储是否可以自主调用门店库存</TD>
                          <TD class="table_none " colspan="5">
						  	<input type="radio" value="1" checked 	name="systemParameterPo.fspallocationstoragetype" ${systemParameterPo.fspallocationstoragetype != '1' ? '':'checked' }>
						  		是
                            <input type="radio" value="0" 			name="systemParameterPo.fspallocationstoragetype" ${systemParameterPo.fspallocationstoragetype != '0' ? '':'checked' }>
                            	否
                            <br/><font color="red">(此项用于调拨功能，库房类型部门可以将门店类型部门的货品自主进行调配。)</font>
						  </TD>
					   </TR>
						 <TR customerAdmin="customerAdmin">
					     <TD height="26" class="table_body" align="right">查询页显示</TD>
					     <TD class="table_none" colspan="5">
					     	<input type="radio" value="1" checked name="systemParameterPo.fspshowchange" ${systemParameterPo.fspshowchange != '1' ? '':'checked' }>
					      		 仅显示查询条件
					       	<input type="radio" value="2" name="systemParameterPo.fspshowchange" ${systemParameterPo.fspshowchange != '2' ? '':'checked' }>
					       		显示查询条件和查询信息
					       	<input type="radio" value="3" name="systemParameterPo.fspshowchange" ${systemParameterPo.fspshowchange != '3' ? '':'checked' }>
					       		隐藏查询条件，显示查询信息
					       	<br/><font color="red">(此项用于在所有查询页面中设置默认查询页信息呈现效果。)</font>
					     </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">查询后显示</TD>
                          <TD class="table_none" colspan="5">
						  	<input type="radio" value="1" checked name="systemParameterPo.fspselectovershowchange" ${systemParameterPo.fspselectovershowchange != '1' ? '':'checked' }>
						  		是
                            <input type="radio" value="0" name="systemParameterPo.fspselectovershowchange" ${systemParameterPo.fspselectovershowchange != '0' ? '':'checked' }>
                            	否
                            <br/><font color="red">(此项用于在所有查询页面中设置查询后是否显示查询条件。)</font>
						  </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">门店查看制造商及品种</TD>
                          <TD class="table_none" colspan="5">
						  	<input type="radio" value="1" checked name="systemParameterPo.fspisshowsupplierandbrand" ${systemParameterPo.fspisshowsupplierandbrand != '1' ? '':'checked' }>
						  		允许
                            <input type="radio" value="0" name="systemParameterPo.fspisshowsupplierandbrand" ${systemParameterPo.fspisshowsupplierandbrand != '0' ? '':'checked' }>
                            	不允许
                            <br/><font color="red">(在页面查询条件及查询信息中隐藏制造商及品种信息。) </font>
						  </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body " align="right">1积分兑换现金</TD>
                          <TD class="table_none " colspan="5">
                            <input class="text_input160" maxlength="13" type="text" name="systemParameterPo.fspexchangeintegral" value="${systemParameterPo.fspexchangeintegral }" 
                             validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写1积分兑换的金额！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '填写的金额不正确！'}]" 
                             onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(2);}else{this.value = '0.00';}" /> 
                            <br/><font color="red">(会员可使用1积分可以兑换的商品价值。)</font>
                          </TD>
					   </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">会员地区级别</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="0" onclick="changeAddressType('0')" name="systemParameterPo.fspaddresstype" ${systemParameterPo.fspaddresstype ne '1' ? 'checked':'' }>
                           		3级
                           	<input type="radio" value="1" onclick="changeAddressType('1')" name="systemParameterPo.fspaddresstype" ${systemParameterPo.fspaddresstype eq '1' ? 'checked':'' }>
                           		5级
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>	
					   <TR companyAdmin="companyAdmin" id="tradress3">
                          <TD height="26" class="table_body " align="right">会员默认地区（3级）</TD>
                          <TD class="table_none " colspan="5"><select id="zone1" yyorder="8"  name="systemParameterPo.fspcustomeraddress" 
                          validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '地区不能为空！'}]">
                          </select>
                            <select id="zone2" yyorder="9" name="systemParameterPo.fspcustomeraddress">
                            </select>
                            <select id="zone3" yyorder="10" name="systemParameterPo.fspcustomeraddress">
                            </select>
                            <br/><font color="red">(主要用于会员管理功能，将会员的地址默认进行显示。)</font>
                          </TD>
					   </TR>
					   <TR companyAdmin="companyAdmin" id="tradress5">
                          <TD height="26" class="table_body " align="right">会员默认地区（5级）</TD>
                          <TD class="table_none " colspan="5">
                        	  <select id="t1" name="systemParameterPo.fsparea1" onchange="getAreaAjaxData('2',this.options[this.options.selectedIndex].value)">
	                          	 <option value="">---请选择---</option>
	                             <s:iterator value="area1List">
	                                 <option value="${faid}" ${(faid eq systemParameterPo.fsparea1)? 'selected':''}>${faname}</option>
	                             </s:iterator>
	                          </select>
	                          <select id="t2" name="systemParameterPo.fsparea2" onchange="getAreaAjaxData('3',this.options[this.options.selectedIndex].value)">
	                          	<option value="">---请选择---</option>
	                          	 <s:iterator value="area2List">
	                                 <option value="${faid}" ${(faid eq systemParameterPo.fsparea2)? 'selected':''}>${faname}</option>
	                             </s:iterator>	
	                          </select>
	                          <select id="t3" name="systemParameterPo.fsparea3" onchange="getAreaAjaxData('4',this.options[this.options.selectedIndex].value)">
	                          	<option value="">---请选择---</option>
	                          	 <s:iterator value="area3List">
	                                 <option value="${faid}" ${(faid eq systemParameterPo.fsparea3)? 'selected':''}>${faname}</option>
	                             </s:iterator>	
	                          </select>
	                          <select id="t4" name="systemParameterPo.fsparea4" onchange="getAreaAjaxData('5',this.options[this.options.selectedIndex].value)">
	                          	<option value="">---请选择---</option>
	                          	 <s:iterator value="area4List">
	                                 <option value="${faid}" ${(faid eq systemParameterPo.fsparea4)? 'selected':''}>${faname}</option>
	                             </s:iterator>	
	                          </select>
	                          <select id="t5" name="systemParameterPo.fsparea5">
	                          	<option value="">---请选择---</option>
	                          	 <s:iterator value="area5List">
	                                 <option value="${faid}" ${(faid eq systemParameterPo.fsparea5)? 'selected':''}>${faname}</option>
	                             </s:iterator>	
	                          </select> 
                            <br/><font color="red">(主要用于会员管理功能，将会员的地址默认进行显示。)</font>
                          </TD>
					   </TR>					   
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body " align="right">当前页显示信息数</TD>
                          <TD class="table_none " colspan="5">
                              <select name="systemParameterPo.fsppageno">
							  	<option value="10"  ${systemParameterPo.fsppageno != '10' ? '':'selected="selected"' }>10</option>
							  	<option value="15"  ${systemParameterPo.fsppageno != '15' ? '':'selected="selected"' }>15</option>
								<option value="20"  ${systemParameterPo.fsppageno != '20' ? '':'selected="selected"' }>20</option>
								<option value="30"  ${systemParameterPo.fsppageno != '30' ? '':'selected="selected"' }>30</option>
								<option value="50"  ${systemParameterPo.fsppageno != '50' ? '':'selected="selected"' }>50</option>
								<option value="100" ${systemParameterPo.fsppageno != '100' ? '':'selected="selected"' }>100</option>
								<option value="200" ${systemParameterPo.fsppageno != '200' ? '':'selected="selected"' }>200</option>
							  </select>
							  <br/><font color="red">(此项用于所有查询页面中查询结果所显示的条数。)</font>
						  </TD>
					   </TR>
						<TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">手动修改检验信息</TD>
                          <TD class="table_none" colspan="5">
						  	<input type="radio" value="1" checked name="systemParameterPo.fspupdatecheck" ${systemParameterPo.fspupdatecheck != '1' ? '':'checked' }>
						  		允许
                            <input type="radio" value="0" name="systemParameterPo.fspupdatecheck" ${systemParameterPo.fspupdatecheck != '0' ? '':'checked' }>
                            	不允许
                            <br/><font color="red">(此项用于检验页面读取焦度计的值后，是否允许手动修改检验信息。)</font>
						  </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">手动填写验光处方</TD>
                          <TD class="table_none" colspan="5">
						  	<input type="radio" value="1" checked name="systemParameterPo.fspupdateinspection" ${systemParameterPo.fspupdateinspection != '1' ? '':'checked' }>
						  		允许
                            <input type="radio" value="0" name="systemParameterPo.fspupdateinspection" ${systemParameterPo.fspupdateinspection != '0' ? '':'checked' }>
                            	不允许
                            <br/><font color="red">(此项用于在销售时不选择处方类型或外方时，可手动填写处方信息。)</font>
						  </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">验光师选择样式</TD>
                          <TD class="table_none" colspan="5">
						  	<input type="radio" value="1" checked name="systemParameterPo.fspselectoptometrist" ${systemParameterPo.fspselectoptometrist != '1' ? '':'checked' }>
						  		只读
                            <input type="radio" value="2" name="systemParameterPo.fspselectoptometrist" ${systemParameterPo.fspselectoptometrist != '2' ? '':'checked' }>
                            	可更改（如果当前登录人是验光师，默认选择当前验光师。）
                            <input type="radio" value="3" name="systemParameterPo.fspselectoptometrist" ${systemParameterPo.fspselectoptometrist != '3' ? '':'checked' }>
                            	可更改（没有默认选择。）
                            <br/><font color="red">(此项用于视光检查对于验光师是否可以修改进行设置。)</font>
						  </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">光心垂差检验方式</TD>
                          <TD class="table_none" colspan="5">
						  	<input type="radio" value="1" checked name="systemParameterPo.fspvd" ${systemParameterPo.fspvd != '1' ? '':'checked' }>
						  		将光心垂差允差转换成棱镜度后与斜视上下方向之间的棱镜度进行对比<br/>
                            <input type="radio" value="0" name="systemParameterPo.fspvd" ${systemParameterPo.fspvd != '0' ? '':'checked' }>
                            	光心垂差按国标允差以毫米单位进行比较（此项设置需要手动量取垂差值，焦度计不予取值）
                            <br/><font color="red">(此项用于设置加工检验时光心垂差的检验方式。)</font>
						  </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">老花镜销售是否绑定处方</TD>
                          <TD class="table_none" colspan="5">
						  	<input type="radio" value="1" checked name="systemParameterPo.fspoldglasssalestype" ${systemParameterPo.fspoldglasssalestype != '1' ? '':'checked' }>
						  		绑定
                            <input type="radio" value="0" name="systemParameterPo.fspoldglasssalestype" ${systemParameterPo.fspoldglasssalestype != '0' ? '':'checked' }>
                            	不绑定
                            <br/><font color="red">(此项用于在销售时老花镜销售是否绑定处方。)</font>
						  </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">设置更改结款类型限制时间</TD>
                          <TD class="table_none" colspan="5">
						  	<input class="text_input60" maxlength="5" type="text" value="${systemParameterPo.fspupdateguitartype }" name="systemParameterPo.fspupdateguitartype" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '更改销售类型限制日期应为整数！'}]">&nbsp;天内
                            <br/><font color="red">(此项用于设置更改结款类型限制日期,结款日期距当前日期X天内的销售单可以进行修改。)</font>
						  </TD>
					   </TR>
					   <TR companyAdmin="companyAdmin">
					     <TD height="26" class="table_body" align="right">收银台积分更改方式</TD>
					     <TD class="table_none" colspan="5">
					     	<input type="radio" value="1" checked id="fspupdatecredittype" name="systemParameterPo.fspupdatecredittype" ${systemParameterPo.fspupdatecredittype != '1' ? '':'checked' }>
					       		整单积分更改方式
					       	<input type="radio" value="2" id="fspupdatecredittype" name="systemParameterPo.fspupdatecredittype" ${systemParameterPo.fspupdatecredittype != '2' ? '':'checked' }>
					       		商品明细积分更改方式
					       	<br/><font color="red">(1、整单积分更改方式：对整单的积分合计值进行更改；2、商品明细积分更改方式：可对每个商品的积分累计值进行更改。)</font>
						 </TD>
					   </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body" align="right">积分结款最小积分限制</TD>
                          <TD class="table_none" colspan="5">
						  	<input class="text_input60" maxlength="5" type="text" value="${systemParameterPo.fspminintegral }" name="systemParameterPo.fspminintegral" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '积分结款最小积分限制应为整数！'}]">&nbsp;
                            <br/><font color="red">此项用于银台结款，当顾客历次销售总金额小于此项限制时无法使用积分结款（包含本次）。</font>
						  </TD>
					   </TR>
					   <TR companyAdmin="companyAdmin">
					     <TD height="26" class="table_body" align="right">短信功能</TD>
					     <TD class="table_none" colspan="5">
                            <input type="radio" value="0" id="fspshortmessage" name="systemParameterPo.fspshortmessage" ${systemParameterPo.fspshortmessage == '0' ? 'checked':'' } onclick="shortMessagetype(this);isshowtextphone($(this).val())">
					       		关闭
					        <br/><input type="radio" value="1" id="fspshortmessage" name="systemParameterPo.fspshortmessage" ${systemParameterPo.fspshortmessage == '1' ? 'checked':'' } onclick="shortMessagetype(this);isshowtextphone($(this).val())">
					       		正式使用
					       	<br/><input type="radio" value="2" id="fspshortmessage" name="systemParameterPo.fspshortmessage" ${systemParameterPo.fspshortmessage == '2' ? 'checked':'' } onclick="shortMessagetype(this);isshowtextphone($(this).val())">
					       		测试使用
					       	<br/><font color="red">(此项用于会员管理功能中设置是否开启短信功能。)</font>
						 </TD>
					   </TR>
					   <TR companyAdmin="companyAdmin" id="textphone">
                         <TD height="26" class="table_none" align="right">测试手机号</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="text" maxlength="200" size="120" value="${systemParameterPo.fsptextphone}" id="fsptextphone" name="systemParameterPo.fsptextphone">
                         	<br/><font color="red">(填写测试手机号码，可填写多个（以英文逗号","进行号码与号码之间进行分割）。)
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_none" align="right">SMS账户</TD>
                         <TD class="table_none" colspan="5">
                         	帐号&nbsp;<input type="text" maxlength="20" value="${systemParameterPo.fspshortmessagename}" id="fspshortmessagename" name="systemParameterPo.fspshortmessagename" >
							密码：&nbsp;<input type="text" maxlength="50" size="50" value="${systemParameterPo.fspshortmessagepw}" id="fspshortmessagepw" name="systemParameterPo.fspshortmessagepw" ></font>
                         </TD>
                       </TR>					   
 
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">隐形成品和辅料在途设置</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="1" checked name="systemParameterPo.fspsalesintransit" ${systemParameterPo.fspsalesintransit == '1' ? 'checked':'' }>
                           		银台结款后至顾客取镜
                           	<input type="radio" value="2" name="systemParameterPo.fspsalesintransit" ${systemParameterPo.fspsalesintransit == '2' ? 'checked':'' }>
                           		银台结款后至取镜处待取镜
                           	<br/><font color="red">(此项用于设置结款后隐形成品镜片和辅料商品的在途信息。)</font>
                         </TD>
                       </TR>
                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">公司之间共享会员设置</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="radio" value="1" checked name="systemParameterPo.fspissalesmessageshareforvandv" ${systemParameterPo.fspissalesmessageshareforvandv != '1' ? '':'checked' }>
                          		 共享
                            <input type="radio" value="0"         name="systemParameterPo.fspissalesmessageshareforvandv" ${systemParameterPo.fspissalesmessageshareforvandv != '0' ? '':'checked' }>
                           		不共享
                           	<br/><font color="red">(此项用于设置公司之间是否共享会员。)</font>
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">公司内部共享会员设置</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="radio" value="1" checked name="systemParameterPo.fspissalesmessageshareformandv" ${systemParameterPo.fspissalesmessageshareformandv != '1' ? '':'checked' }>
                          		 共享
                            <input type="radio" value="0"         name="systemParameterPo.fspissalesmessageshareformandv" ${systemParameterPo.fspissalesmessageshareformandv != '0' ? '':'checked' }>
                           		不共享
                           	<br/><font color="red">(此项用于设置公司内部是否共享会员。)</font>
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">分公司内部共享配镜单设置</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="radio" value="1" checked name="systemParameterPo.fspissalesbillshareformandv" ${systemParameterPo.fspissalesbillshareformandv != '1' ? '':'checked' }>
                          		 共享
                            <input type="radio" value="0" name="systemParameterPo.fspissalesbillshareformandv" ${systemParameterPo.fspissalesbillshareformandv != '0' ? '':'checked' }>
                           		不共享
                           	<br/><font color="red">(此项用于设置分公司内部是否共享配镜单。)</font>
                         </TD>
                       </TR>

                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">公司内部共享库存设置</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="radio" value="1" checked id="fspsharestockmessage" onclick="showKC();" name="systemParameterPo.fspsharestockmessage" ${systemParameterPo.fspsharestockmessage != '1' ? '':'checked' }>
                          		 共享
                            <input type="radio" value="0" onclick="showKC();" name="systemParameterPo.fspsharestockmessage" ${systemParameterPo.fspsharestockmessage != '0' ? '':'checked' }>
                           		不共享
                           	<br/><font color="red">(此项用于设置公司内部库存商品是否共享。)</font>
                         </TD>
                       </TR>
                       <TR id="KCqueryConditions" companyAdmin="companyAdmin" >
                         <TD height="26" class="table_body" align="right">公司内部共享库存查询条件</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="checkbox" value="1" id="stockqueryconditions1" name="fspstockqueryconditions" onclick="disab();">
                          		 商品代码
                            <input type="checkbox" value="2" id="stockqueryconditions2" name="fspstockqueryconditions" onclick="disab();" >
                           		商品条码
                           	<input type="checkbox" value="3" id="stockqueryconditions3" name="fspstockqueryconditions" onclick="disab();" >
                           		商品名称
                           	<input type="checkbox" value="4" id="stockqueryconditions4" name="fspstockqueryconditions" onclick="disab();" >
                           		不受控
                            <br/><font color="red">(此项用于商品库存查询功能中设置库存必选查询条件限制。)</font>
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body" align="right">调拨绑定商品类别</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="radio" value="1" id="fspisallocationcategory" name="systemParameterPo.fspisallocationcategory" ${systemParameterPo.fspisallocationcategory != '1' ? '':'checked' }>
                          		 绑定
                            <input type="radio" value="0" id="fspisallocationcategory" name="systemParameterPo.fspisallocationcategory" ${systemParameterPo.fspisallocationcategory != '0' ? '':'checked' } ${systemParameterPo.fspisallocationcategory eq '' ? 'checked':'' }>
                           		不绑定
                           	<br/><font color="red">(此项用于调拨申请管理、商品调拨管理制单时绑定商品类别。)</font>
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body" align="right">调拨申请绑定制造商</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="radio" value="1" id="fspisallocationsupplier" name="systemParameterPo.fspisallocationsupplier" ${systemParameterPo.fspisallocationsupplier != '1' ? '':'checked' }>
                          		 绑定
                            <input type="radio" value="0" id="fspisallocationsupplier" name="systemParameterPo.fspisallocationsupplier" ${systemParameterPo.fspisallocationsupplier != '0' ? '':'checked' } ${systemParameterPo.fspisallocationsupplier eq '' ? 'checked':'' }>
                           		不绑定
                           	<br/><font color="red">(此项用于调拨申请管理制单时绑定制造商。)</font>
                         </TD>
                       </TR>                       
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body" align="right">运单单号是否必填</TD>
                         <TD class="table_none" colspan="5">
                         	<input type="radio" value="1" id="fspisfillindeliveryid" name="systemParameterPo.fspisfillindeliveryid" ${systemParameterPo.fspisfillindeliveryid != '1' ? '':'checked' }>
                          		 必填
                            <input type="radio" value="0" id="fspisfillindeliveryid" name="systemParameterPo.fspisfillindeliveryid" ${systemParameterPo.fspisfillindeliveryid != '0' ? '':'checked' } ${systemParameterPo.fspisfillindeliveryid eq '' ? 'checked':'' }>
                           		不必填
                           	<br/><font color="red">(此项用于采购收货管理、委外收货管理制单时判定运单单号是否为必填。)</font>
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body" align="right">零售价设置</TD>
                         <TD class="table_none" colspan="5">
                         	<div id="r1">
                         	<input type="checkbox" value="1" id="r1" name="systemParameterPo.fspretailprice"  ${systemParameterPo.fspretailprice != '1' ? '':'checked' }>
                          		 标准零售价&nbsp;
                          	</div>
                          	<div id="r2">
                          	<input type="checkbox" value="1" id="r2" name="systemParameterPo.fspretailpricea" ${systemParameterPo.fspretailpricea != '1' ? '':'checked' }>
                          		 零售价2&nbsp;
                          	</div>
                          	<div id="r3">
                          	<input type="checkbox" value="1" id="r3" name="systemParameterPo.fspretailpriceb" ${systemParameterPo.fspretailpriceb != '1' ? '':'checked' }>
                          		 零售价3&nbsp;
                          	</div>
                          	<div id="r4">
                          	<input type="checkbox" value="1" id="r4" name="systemParameterPo.fspretailpricec" ${systemParameterPo.fspretailpricec != '1' ? '':'checked' }>
                          		 零售价4&nbsp;
                          	</div>
                          	<div id="r5">
                          	<input type="checkbox" value="1" id="r5" name="systemParameterPo.fspretailpriced" ${systemParameterPo.fspretailpriced != '1' ? '':'checked' }>
                          		 零售价5&nbsp;
                          	</div>
                          	<div id="r6">
                          	<input type="checkbox" value="1" id="r6" name="systemParameterPo.fspretailpricee" ${systemParameterPo.fspretailpricee != '1' ? '':'checked' }>
                          		 零售价6&nbsp;
                          	</div>
                          	<div id="r7">
                          	<input type="checkbox" value="1" id="r7" name="systemParameterPo.fspretailpricef" ${systemParameterPo.fspretailpricef != '1' ? '':'checked' }>
                          		 零售价7&nbsp;
                          	</div>
                          	<div id="r8">
                          	<input type="checkbox" value="1" id="r8" name="systemParameterPo.fspretailpriceg" ${systemParameterPo.fspretailpriceg != '1' ? '':'checked' }>
                          		 零售价8&nbsp;
                          	</div>
                          	<div id="r9">
                          	<input type="checkbox" value="1" id="r9" name="systemParameterPo.fspretailpriceh" ${systemParameterPo.fspretailpriceh != '1' ? '':'checked' }>
                          		 零售价9&nbsp;
                          	</div>
                          	<div id="r10">
                          	<input type="checkbox" value="1" id="r10" name="systemParameterPo.fspretailpricei" ${systemParameterPo.fspretailpricei != '1' ? '':'checked' }>
                          		 零售价10
                          	</div>
                           	<br/><font color="red">(此项用于设置系统中可使用几种零售价。)</font>
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">即时通讯（RTX）</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="1" onclick="isShowRTX(this)" name="systemParameterPo.fsprtx" ${systemParameterPo.fsprtx != '1' ? '':'checked' }>
                           		启用
                           	<input type="radio" value="0" onclick="isShowRTX(this)" name="systemParameterPo.fsprtx" ${systemParameterPo.fsprtx != '0' ? '':'checked' }>
                           		关闭
                           	<br/><font color="red"></font>
                         </TD>
                       </TR> 
                       <TR id="trrtx">
                         <TD height="26" class="table_none" align="right">服务器IP</TD>
                         <TD class="table_none" colspan="5">
                         	即时通讯（RTX）服务器设定(IP)&nbsp;<input type="text" maxlength="20" value="${systemParameterPo.fspserverip}" id="fspserverip" name="systemParameterPo.fspserverip" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         	<!-- EIMS 服务器设定(IP)&nbsp;<input type="text" maxlength="20" value="${systemParameterPo.fspeimsip}" id="fspeimsip" name="systemParameterPo.fspeimsip"> -->
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin_companyAdmin">
                         <TD height="26" class="table_body " align="right">是否验证登录客户机的Mac地址</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="1" name="systemParameterPo.fspischeckmac" ${systemParameterPo.fspischeckmac != '1' ? '':'checked' }>
                           		验证
                           	<input type="radio" value="0" name="systemParameterPo.fspischeckmac" ${systemParameterPo.fspischeckmac != '0' ? '':'checked' }>
                           		不验证
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">配送发料自动刷新时间设置</TD>
                         <TD class="table_none " colspan="5">
                         	<input class="text_input60" maxlength="2" type="text" name="systemParameterPo.fspallocationatuotime" value="${systemParameterPo.fspallocationatuotime }" validate="[{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '自动刷新时间应为整数！'}]">&nbsp;秒
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">配镜单查询自动刷新设置</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="1" onclick="ishowpjbillsetuptime(this);" id="billsetup1" name="systemParameterPo.fsppjbillsetup" ${systemParameterPo.fsppjbillsetup != '1' ? '':'checked' }>
                           		设置
                           	<input type="radio" value="0" onclick="ishowpjbillsetuptime(this);" id="billsetup2" name="systemParameterPo.fsppjbillsetup" ${systemParameterPo.fsppjbillsetup != '0' ? '':'checked' }>
                           		不设置
                         	<span id="pjdRes"><input id="fsppjbillsetuptime" class="text_input60" maxlength="2" type="text" name="systemParameterPo.fsppjbillsetuptime" value="${systemParameterPo.fsppjbillsetuptime }" >&nbsp;秒</span>
                         <%--<font color="red">*</font>--%>
                         </TD>
                       </TR>
                        <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">商品目录树是否显示制造商级</TD>
                         <TD class="table_none " colspan="5">
                         	<input maxlength="1" type="radio" name="showsupplier" value="1" >显示&nbsp;
                         	<input maxlength="2" type="radio" name="showsupplier"  value="0" >不显示&nbsp;
                         <br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">会员新增后是否显示报表</TD>
                         <TD class="table_none " colspan="5">
                         	<input maxlength="1" type="radio" name="systemParameterPo.fspshowcustomertable" value="1" ${systemParameterPo.fspshowcustomertable != '1' ? '':'checked' }>显示&nbsp;
                         	<input maxlength="2" type="radio" name="systemParameterPo.fspshowcustomertable"  value="0" ${systemParameterPo.fspshowcustomertable != '0' ? '':'checked' }>不显示&nbsp;
                         <br/><font color="red"></font>
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">会员卡位数</TD>
                         <TD class="table_none " colspan="5">
                         	<input id="fspcustomercardlen" name="systemParameterPo.fspcustomercardlen" type="text" class="text_input80" value="${systemParameterPo.fspcustomercardlen }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写会员卡位数！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写会员卡位数！'}]" maxlength="20"/>
                            <br/><font color="red">(此项用于设置会员卡位数，默认为零，表示不限制位数。)</font>
                         </TD>
                       </TR>
                        <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">商品基础信息是否使用正散处理</TD>
                         <TD class="table_none " colspan="5">
                         	<input maxlength="1" type="radio" name="systemParameterPo.fspnegative" value="1"  ${systemParameterPo.fspnegative != '1' ? '':'checked' }>使用&nbsp;
                         	<input maxlength="0" type="radio" name="systemParameterPo.fspnegative"  value="0"  ${systemParameterPo.fspnegative != '0' ? '':'checked' }>不使用&nbsp;
                         <br/><font color="red"></font>
                         </TD>
                         </TR>
                         <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">功能模块是否使用正散处理</TD>
                         <TD class="table_none " colspan="5">
                         	<input maxlength="1" type="radio" name="systemParameterPo.fspothernegative" value="1"  ${systemParameterPo.fspothernegative != '1' ? '':'checked' }>使用&nbsp;
                         	<input maxlength="0" type="radio" name="systemParameterPo.fspothernegative"  value="0"  ${systemParameterPo.fspothernegative != '0' ? '':'checked' }>不使用&nbsp;
                         <br/><font color="red"></font>
                         </TD>
                         </TR>
                         <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">是否使用双眼视功能检查</TD>
                         <TD class="table_none " colspan="5">
                         	<input maxlength="1" type="radio" name="systemParameterPo.fspinspectionvisuelle" value="1"  ${systemParameterPo.fspinspectionvisuelle != '1' ? '':'checked' }>使用&nbsp;
                         	<input maxlength="0" type="radio" name="systemParameterPo.fspinspectionvisuelle"  value="0"  ${systemParameterPo.fspinspectionvisuelle != '0' ? '':'checked' }>不使用&nbsp;
                         <br/><font color="red"></font>
                         </TD>
                       </TR>
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">镜架商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspcjjB_GI_Spec" name="systemParameterPo.fspcjj">型号
                         	+<input type="checkbox" value="B_GI_Color" id="fspcjjB_GI_Color" name="systemParameterPo.fspcjj">颜色
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcjjB_GI_RetailPrice" name="systemParameterPo.fspcjj">标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">配件商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspcpjB_GI_Spec" name="systemParameterPo.fspcpj">型号
                         	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcpjB_GI_RetailPrice" name="systemParameterPo.fspcpj">标准零售价
                            <br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">镜片商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Sph" id="fspcjpB_GI_Sph" name="systemParameterPo.fspcjp" }>球镜
                         	+<input type="checkbox" value="B_GI_Cyl" id="fspcjpB_GI_Cyl" name="systemParameterPo.fspcjp" }>柱镜
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcjpB_GI_RetailPrice" name="systemParameterPo.fspcjp" }>标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">隐形镜片商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Sph" id="fspcyxjpB_GI_Sph" name="systemParameterPo.fspcyxjp" >球镜
                         	+<input type="checkbox" value="B_GI_Cyl" id="fspcyxjpB_GI_Cyl" name="systemParameterPo.fspcyxjp" >柱镜
                         	+<input type="checkbox" value="B_GI_Color" id="fspcyxjpB_GI_Color" name="systemParameterPo.fspcyxjp">颜色
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcyxjpB_GI_RetailPrice" name="systemParameterPo.fspcyxjp" >标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">护理液类商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspchlyB_GI_Spec" name="systemParameterPo.fspchly" >型号
                         	+<input type="checkbox" value="B_GI_RetailPrice" id="fspchlyB_GI_RetailPrice" name="systemParameterPo.fspchly" >标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">太阳镜商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspctyjB_GI_Spec" name="systemParameterPo.fspctyj" >型号
                         	+<input type="checkbox" value="B_GI_Color" id="fspctyjB_GI_Color" name="systemParameterPo.fspctyj" >颜色
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspctyjB_GI_RetailPrice" name="systemParameterPo.fspctyj" >标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">耗材商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspchcB_GI_Spec" name="systemParameterPo.fspchc" >型号
                         	+<input type="checkbox" value="B_GI_RetailPrice" id="fspchcB_GI_RetailPrice" name="systemParameterPo.fspchc" >标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">老花镜商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Sph" id="fspclhB_GI_Sph" name="systemParameterPo.fspclh" >球镜
                         	+<input type="checkbox" value="B_GI_Spec" id="fspclhB_GI_Spec" name="systemParameterPo.fspclh" >型号
                           	+<input type="checkbox" value="B_GI_RetailPrice" id="fspclhB_GI_RetailPrice" name="systemParameterPo.fspclh" >标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR style="display:none;">
                         <TD height="26" class="table_body " align="right">视光商品名称显示样式</TD>
                         <TD class="table_none " colspan="5">
                         	品种名称
                         	+<input type="checkbox" value="B_GI_Spec" id="fspcsgB_GI_Spec" name="systemParameterPo.fspcsg">型号
                         	+<input type="checkbox" value="B_GI_RetailPrice" id="fspcsgB_GI_RetailPrice" name="systemParameterPo.fspcsg">标准零售价
                           	<br/><font color="red"></font>
                         </TD>
                       </TR>
                       
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">默认焦度计</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="1" name="systemParameterPo.fspwhichmachine" ${systemParameterPo.fspwhichmachine != '1' ? '':'checked' }>
                           		NIDEK<br/>
                           	<input type="radio" value="2" name="systemParameterPo.fspwhichmachine" ${systemParameterPo.fspwhichmachine != '2' ? '':'checked' }>
                           		TOPCON
                           	<br/>
                           	<input type="radio" value="3" name="systemParameterPo.fspwhichmachine" ${systemParameterPo.fspwhichmachine != '3' ? '':'checked' }>
                           		不连接焦度计
                           	<br/>
                         </TD>
                       </TR>
                       
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">采购收货详细页商品显示方式</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="1" name="systemParameterPo.fspshowdwandtable" ${systemParameterPo.fspshowdwandtable != '1' ? '':'checked' }>
                           		二维表显示商品<br/>
                           	<input type="radio" value="2" name="systemParameterPo.fspshowdwandtable" ${systemParameterPo.fspshowdwandtable != '2' ? '':'checked' }>
                           		表单显示商品
                           	<br/><font color="red">(此项用于设置在采购收货单详细页面商品信息的呈现形式。)</font>
                         </TD>
                       </TR>
                       
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">初验操作设置</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="1" name="systemParameterPo.fspfirstchecktype" ${systemParameterPo.fspfirstchecktype != '1' ? '':'checked' }>
                           		初验数据不录入系统。<br/>
                           	<input type="radio" value="2" name="systemParameterPo.fspfirstchecktype" ${systemParameterPo.fspfirstchecktype != '2' ? '':'checked' }>
                           		连接焦度计、需对各项检验指标录入系统。
                           	<br/>
                         </TD>
                       </TR>
 					   <TR customerAdmin="customerAdmin">
						 <TD height="26" class="table_body" align="right">设置登陆方式</TD>
						     <TD class="table_none" colspan="5">
						     	<input type="radio" value="1" checked name="systemParameterPo.fsplogonform" ${systemParameterPo.fsplogonform != '1' ? '':'checked' }>
						       		用户名、密码和员工卡登陆方式，默认使用用户名、密码登陆<br/>
						       	<input type="radio" value="2" name="systemParameterPo.fsplogonform" ${systemParameterPo.fsplogonform != '2' ? '':'checked' }>
						       		用户名、密码和员工卡登陆方式，默认使用员工卡登陆<br/>
						       	<input type="radio" value="3" name="systemParameterPo.fsplogonform" ${systemParameterPo.fsplogonform != '3' ? '':'checked' }>
						       		仅能使用用户名、密码登陆<br/>
						       	<input type="radio" value="4" name="systemParameterPo.fsplogonform" ${systemParameterPo.fsplogonform != '4' ? '':'checked' }>
						       		仅能使用员工卡登陆								       		
						       	<br/><font color="red">(此项用于设置在登录软件时登陆方式。)</font>
						     </TD>
					   </TR>
                        <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">显示报表使用说明</TD>
                         <TD class="table_none " colspan="5">
                         	<input type="radio" value="1" name="systemParameterPo.fspreporthelpshow" ${systemParameterPo.fspreporthelpshow != '1' ? '':'checked' }>
                           		显示
                           	<input type="radio" value="0" name="systemParameterPo.fspreporthelpshow" ${systemParameterPo.fspreporthelpshow != '0' ? '':'checked' }>
                           		不显示
                           	<br/><font color="red">(此项用于在报表中是否呈现报表的使用说明及相关介绍。)</font>
                         </TD>
                       </TR>
					   <TR customerAdmin="customerAdmin">
                          <TD height="26" class="table_body " align="right">报表默认显隐查询条件</TD>
                          <TD class="table_none " colspan="5">
						    <input type="radio" id="fspshowrptcondition" name="systemParameterPo.fspshowrptcondition" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" } />是&nbsp;&nbsp;
						    <input type="radio" id="fspshowrptcondition" name="systemParameterPo.fspshowrptcondition" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" } />否</br>
						    <span style="color:red">(此项用于默认报表查询页面是否显隐查询条件，可在报表查询更改，但不会更改这项设置。)</span>
                          </TD>
					   </TR>
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">报表默认查询日期的间隔</TD>
                         <TD class="table_none" colspan="5">
                                <table align="left" border="0" cellspacing=0 cellpadding=0>
                                    <tr>
                                       <td valign="middle" align="left">
                                            <input type="hidden" value="3" name="systemParameterPo.fspreportdateflag" >
			                           		<li class="horizontal_onlyRight">
				                           		<select id="fspreportMonth" name="systemParameterPo.fspreportMonth" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取日期间隔！'}]" ${systemParameterPo.fspreportdateflag eq '3' ? '':'disabled="disabled"' }>
				                           		    <option value="" ${systemParameterPo.fspreportMonth eq '' ? 'selected="selected"':'' }>----请选择----</option>
												    <option value="0" ${systemParameterPo.fspreportMonth eq '0' ? 'selected="selected"':'' }>本月</option>
												    <option value="1" ${systemParameterPo.fspreportMonth eq '1' ? 'selected="selected"':'' }>上月</option>
													<option value="2" ${systemParameterPo.fspreportMonth eq '2' ? 'selected="selected"':'' }>前月</option>
												</select>
											</li>
											<li class="horizontal_onlyRight">
											    <input class="text_input60" maxlength="2" type="text" id="fspreportbgndate" name="systemParameterPo.fspreportbgndate" value="${systemParameterPo.fspreportbgndate}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写日期！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写日期！'}]" ${systemParameterPo.fspreportdateflag eq '3' ? '':'disabled="disabled"' } onblur="addZero(this);">&nbsp;日&nbsp;至
											</li>                     
                                       </td>
                                       <td>
                                       		<li class="horizontal_onlyRight">
				                           		<select id="fspreportLastMonth" name="systemParameterPo.fspreportLastMonth" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取日期间隔！'}]" ${systemParameterPo.fspreportdateflag eq '3' ? '':'disabled="disabled"' }>
				                           		    <option value="" ${systemParameterPo.fspreportLastMonth eq '' ? 'selected="selected"':'' }>----请选择----</option>
												    <option value="0" ${systemParameterPo.fspreportLastMonth eq '0' ? 'selected="selected"':'' }>本月</option>
												    <option value="1" ${systemParameterPo.fspreportLastMonth eq '1' ? 'selected="selected"':'' }>上月</option>
													<option value="2" ${systemParameterPo.fspreportLastMonth eq '2' ? 'selected="selected"':'' }>前月</option>
												</select>
											</li>
											<li class="horizontal_onlyRight">
                                                <input class="text_input60" maxlength="2" type="text" id="fspreportenddate" name="systemParameterPo.fspreportenddate" value="${systemParameterPo.fspreportenddate}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写日期！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '请重新填写日期！'}]" ${systemParameterPo.fspreportdateflag eq '3' ? '':'disabled="disabled"' } onblur="addZero(this);">&nbsp;日 
                                            </li>                                         
                                       </td>
                                    </tr>
                                    <tr><td colspan="2"><font color="red">(此项用于在以日期段为查询条件的报表中对日期的最长间隔进行限制。)</font></td></tr>
                                </table>
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">创建采购发票方式</TD>
                         <TD class="table_none " colspan="5">
						     	<input type="radio" value="1" checked name="systemParameterPo.fspinvoicetype" ${systemParameterPo.fspinvoicetype != '1' ? '':'checked' }>
						       		根据销售发票创建采购发票
						       	<input type="radio" value="2" name="systemParameterPo.fspinvoicetype" ${systemParameterPo.fspinvoicetype != '2' ? '':'checked' }>
						       		根据业务单据创建采购发票 
						       	<input type="radio" value="3" name="systemParameterPo.fspinvoicetype" ${systemParameterPo.fspinvoicetype != '3' ? '':'checked' }>
						       		根据商品创建采购发票 
						       	<br/><font color="red">(此项用于设置系统创建采购发票的方式。)</font>
                         </TD>
                       </TR>
                      <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">创建付款单方式</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fsppaymenttype" ${systemParameterPo.fsppaymenttype != '1' ? '':'checked' }>
						       		根据业务单据创建付款单
						       	<input type="radio" value="2" name="systemParameterPo.fsppaymenttype" ${systemParameterPo.fsppaymenttype != '2' ? '':'checked' }>
						       		根据采购发票创建付款单
						        <br/><font color="red">(此项用于设置系统创建付款单的方式。)</font>
                         </TD>
                       </TR> 
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">系统正式使用日期</TD>
                         <TD class="table_none " colspan="5">
                         	<input id="onlineDate" name="systemParameterPo.fspsystemonlinedate" type="text" class="text_input80" onFocus="WdatePicker({readOnly:true})" value="${systemParameterPo.fspsystemonlinedate }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写正式使用系统日期！'}]"/>
                         <br/><font color="red">(此项用于设置系统正式使用的开始日期。)</font>
                         </TD>
                       </TR>                                                               
                       <TR companyAdmin="companyAdmin">
                          <TD height="26" class="table_body " align="right">批发价格设置</TD>
                          <TD class="table_none " colspan="5">
                            <input type="radio" name="systemParameterPo.fspwholesalepriceset" ${systemParameterPo.fspwholesalepriceset eq '0' ? 'checked="checked"' : '' } id="fspwholesalepriceset" value="0" />启用
                            <input type="radio" name="systemParameterPo.fspwholesalepriceset" ${systemParameterPo.fspwholesalepriceset eq '1' ? 'checked="checked"' : '' } id="fspwholesalepriceset" value="1" />停用
                            <br/><font color="red">(此项设置将会涉及到基础信息中的批发价格录入、批发价格调价管理、 客户批发调货管理 、客户批发退货管理 等功能模块的启停用。)</font> 
                          </TD>
					   </TR>
                       <TR companyAdmin="customerAdmin">
                         <TD height="26" class="table_body" align="right">补齐欠款时是否打印配镜单</TD>
                         <TD class="table_none " colspan="5">
                            <input type="radio" name="systemParameterPo.fspprintsalesbillatbukuanflag" ${systemParameterPo.fspprintsalesbillatbukuanflag ne '1' ? 'checked="checked"' : '' } id="fspprintsalesbillatbukuanflag" value="0" />不打印
                            <input type="radio" name="systemParameterPo.fspprintsalesbillatbukuanflag" ${systemParameterPo.fspprintsalesbillatbukuanflag eq '1' ? 'checked="checked"' : '' } id="fspprintsalesbillatbukuanflag" value="1" />打印
                            <br/><font color="red">(此项用于收银员在进行补款操作时，是否同时打印配镜单，配镜单以全款体现。)</font> 
                         </TD>
                       </TR>					   
					   <TR companyAdmin="customerAdmin">
                          <TD height="26" class="table_body " align="right">身份证设置</TD>
                          <TD class="table_none " colspan="5">
                            <input type="radio" name="systemParameterPo.fspidentitycard" ${systemParameterPo.fspidentitycard eq '1' ? 'checked="checked"' : '' } id="fspidentitycard" value="1" />必填
                            <input type="radio" name="systemParameterPo.fspidentitycard" ${systemParameterPo.fspidentitycard eq '2' ? 'checked="checked"' : '' } id="fspidentitycard" value="2" />非必填
                            <br/><font color="red">(此项设置将会涉及到会员信息中身份证一项是否必选填写。)</font> 
                          </TD>
					   </TR>
					   <TR companyAdmin="customerAdmin">
                          <TD height="26" class="table_body " align="right">订金统计方式设置</TD>
                          <TD class="table_none " colspan="5">
                            <input type="radio" name="systemParameterPo.fspcustomamount" ${systemParameterPo.fspcustomamount eq '1' ? 'checked="checked"' : '' } id="fspcustomamount" value="1" />订金按应收金额计入结款日收入,商品金额计入结款日收入<br/>
                            <input type="radio" name="systemParameterPo.fspcustomamount" ${systemParameterPo.fspcustomamount eq '2' ? 'checked="checked"' : '' } id="fspcustomamount" value="2" />订金按应收金额计入补齐日收入,商品金额计入补齐日收入<br/>
                            <input type="radio" name="systemParameterPo.fspcustomamount" ${systemParameterPo.fspcustomamount eq '3' ? 'checked="checked"' : '' } id="fspcustomamount" value="3" />订金结款日收入,补齐金额计入补齐日收入,商品金额计入结款日收入
                            <br/><font color="red">(此项设置将会涉及报表中默认的订金统计方式。)</font> 
                          </TD>
					   </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">门店退款关联投诉</TD>
                         <TD class="table_none " colspan="5">
						     	<input type="radio" value="1" checked name="systemParameterPo.fsprefundcomplainflag" ${systemParameterPo.fsprefundcomplainflag == '1' ? 'checked':'' }>
						       		关联
						       	<input type="radio" value="0" name="systemParameterPo.fsprefundcomplainflag" ${systemParameterPo.fsprefundcomplainflag == '0' ? 'checked':'' }>
						       		不关联
						       	<br/><font color="red">(此项用于设置门店退款时是否关联顾客投诉。)</font>
                         </TD>
                       </TR>

                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">会员投诉绑定配镜单设置</TD>
                         <TD class="table_none " colspan="5">
						     	<input type="radio" value="1" checked name="systemParameterPo.fspcomplainbandbill" ${systemParameterPo.fspcomplainbandbill == '1' ? 'checked':'' }>
						       		绑定
						       	<input type="radio" value="0" name="systemParameterPo.fspcomplainbandbill" ${systemParameterPo.fspcomplainbandbill == '0' ? 'checked':'' }>
						       		不绑定
						       	<br/><font color="red">(此项用于设置会员投诉时是否需要提供配镜单。)</font>
                         </TD>
                       </TR>   
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">门店配送-退款配置</TD>
                         <TD class="table_none " colspan="5">
						     	<input type="radio" value="1" checked name="systemParameterPo.fspshopdistributionrefund" ${systemParameterPo.fspshopdistributionrefund == '1' ? 'checked':'' }>
						       		能退款
						       	<input type="radio" value="0" name="systemParameterPo.fspshopdistributionrefund" ${systemParameterPo.fspshopdistributionrefund == '0' ? 'checked':'' }>
						       		不能退款
						       	<br/><font color="red">(此项用于设置门店配送时的配镜单是否能够退款。)</font>
                         </TD>
                       </TR>
                 
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">框镜配镜单配镜发料设置</TD>
                         <TD class="table_none " colspan="5">
						     	<input type="radio" value="1" checked name="systemParameterPo.fspautospectaclesmaterials" ${systemParameterPo.fspautospectaclesmaterials == '1' ? 'checked':'' }>
						       		配镜单能在任一部门进行发料操作。
						       	<br/><input type="radio" value="2" name="systemParameterPo.fspautospectaclesmaterials" ${systemParameterPo.fspautospectaclesmaterials == '2' ? 'checked':'' }>
						       		框镜订制类型的配镜单只能在销售门店仓位配置中的订制片的出仓仓位的所属部门进行发料操作。<br/>
						       		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;框镜成品类型的配镜单只能在销售门店仓位配置中的成品片的出仓仓位的所属部门进行发料操作。
						       	<br/><font color="red">(此项用于设置配镜单发料是按出仓仓位发料还是统一发料。)</font>
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">双自片配镜单在途设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="3" checked name="systemParameterPo.fspzzautospectaclesmaterials" ${systemParameterPo.fspzzautospectaclesmaterials == '3' ? 'checked':'' }>
						       		手工发料：配镜单结款后，按正常流程依次进行门店配送和配镜发料操作。
						     	<br/><input type="radio" value="1" name="systemParameterPo.fspzzautospectaclesmaterials" ${systemParameterPo.fspzzautospectaclesmaterials == '1' ? 'checked':'' }>
						       		自动发料：若启用门店配送功能，配镜单门店配送后，在途设置为配镜发料；若停用门店配送功能，配镜单结款后，在途设置为配镜发料。
						       	<br/><input type="radio" value="2" name="systemParameterPo.fspzzautospectaclesmaterials" ${systemParameterPo.fspzzautospectaclesmaterials == '2' ? 'checked':'' }>
						       		直接取镜：配镜单结款时，若交付全款，在途设置为顾客取镜；若交付订金，在途设置为取镜处收货。
						       	<br/><font color="red">(此项用于设置双自片的配镜单在银台结款后的在途。)</font>
                         </TD>
                       </TR>  
                       <TR companyAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">设置默认销售人员</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspsalerdefaultset" ${systemParameterPo.fspsalerdefaultset == '1' ? 'checked':'' }>
						       		门店销售时默认以当前登录人员做为此单的销售人员。
						     	<br/><input type="radio" value="2" name="systemParameterPo.fspsalerdefaultset" ${systemParameterPo.fspsalerdefaultset == '2' ? 'checked':'' }>
						       		门店销售时需要手工选取此单的销售人员。
						       	<br/><font color="red">(此项用于设置门店销售模块是否设置默认销售人员。)</font>
                         </TD>
                       </TR> 
                       <TR customerAdmin="customerAdmin" >
                         <TD height="26" class="table_body " align="right">使用单据识别码</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" onclick="ishidedjsbm(this)" checked name="systemParameterPo.fspdjsbm" ${systemParameterPo.fspdjsbm == '1' ? 'checked':'' }>
						       		使用
						     	<input type="radio" value="2" onclick="ishidedjsbm(this)" name="systemParameterPo.fspdjsbm" ${systemParameterPo.fspdjsbm == '2' ? 'checked':'' }>
						       		不使用。
						       	<br/><font color="red">(此项用于配镜流程是否使用单据识别码查询。)</font>
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin" id="djsbmfortype">
                         <TD height="26" class="table_none " align="right">单据识别码绑定销售类型</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="checkbox" value="1" id="fspdjsbmfortype1" name="systemParameterPo.fspdjsbmfortype" ${systemParameterPo.fspdjsbmfortype == '1' ? 'checked':'' }>
						       		框镜销售&nbsp;&nbsp;
						     	<input type="checkbox" value="2" id="fspdjsbmfortype2" name="systemParameterPo.fspdjsbmfortype" ${systemParameterPo.fspdjsbmfortype == '2' ? 'checked':'' }>
						     		隐形销售&nbsp;&nbsp;
						     	<input type="checkbox" value="3" id="fspdjsbmfortype3" name="systemParameterPo.fspdjsbmfortype" ${systemParameterPo.fspdjsbmfortype == '3' ? 'checked':'' }>
						       		辅料销售&nbsp;&nbsp;
						       	<br/><font color="red">(此项用于前台销售模块，判断哪一个销售类型必须填写单据识别码。)</font>
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">HIS系统连接</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="0" checked name="systemParameterPo.fsphisflag" ${systemParameterPo.fsphisflag == '0' ? 'checked':'' }>
						       		未连接。
						     	<br/><input type="radio" value="1" name="systemParameterPo.fsphisflag" ${systemParameterPo.fsphisflag == '1' ? 'checked':'' }>
						       		连接云南昆明红会医院HIS系统。
						       	<br/><input type="radio" value="2" name="systemParameterPo.fsphisflag" ${systemParameterPo.fsphisflag == '2' ? 'checked':'' }>
						       		连接医院HIS系统标准接口。
						       	<br/><font color="red">(此项用于设置系统是否与HIS软件连接。)</font>
                         </TD>
                       </TR> 
                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body " align="right">会记账期设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspaccountperiod" ${systemParameterPo.fspaccountperiod == '1' ? 'checked':'' }>
						       		以会计账期所表示的月份，该月的1日至最后一日。
						     	<br/><input type="radio" value="2" name="systemParameterPo.fspaccountperiod" ${systemParameterPo.fspaccountperiod == '2' ? 'checked':'' }>
						       		以会计账期所表示的月份，上月的26日至该月的25日。
						       	<br/><input type="radio" value="3" name="systemParameterPo.fspaccountperiod" ${systemParameterPo.fspaccountperiod == '3' ? 'checked':'' }>
						       		以会计账期所表示的月份，该月的25日至下月的26日。
						       	<br/><font color="red">(此项用于设置会计账期的日期区间。)</font>
                         </TD>
                       </TR> 
                       
  					   <TR companyAdmin="companyAdmin">
                           <TD height="26" class="table_body " align="right">辅料销售可以销售的商品类型</TD>
                           <TD class="table_none " colspan="5">
						   	<input type="checkbox" value="1" id="fspaccessorysalestype1" name="systemParameterPo.fspaccessorysalestype">
						   	           镜架
                            <input type="checkbox" value="2" id="fspaccessorysalestype2" name="systemParameterPo.fspaccessorysalestype">
                                                                                      配件
							<input type="checkbox" value="3" id="fspaccessorysalestype3" name="systemParameterPo.fspaccessorysalestype">
							           镜片(可以不选取处方)
							<input type="checkbox" value="4" id="fspaccessorysalestype4" name="systemParameterPo.fspaccessorysalestype">
							           隐形(可以不选取处方)
							<input type="checkbox" value="5" id="fspaccessorysalestype5" name="systemParameterPo.fspaccessorysalestype">
							           护理液
							<input type="checkbox" value="6" id="fspaccessorysalestype6" name="systemParameterPo.fspaccessorysalestype">
							           太阳镜
							<input type="checkbox" value="7" id="fspaccessorysalestype7" name="systemParameterPo.fspaccessorysalestype">
							           耗材     
							<input type="checkbox" value="8" id="fspaccessorysalestype8" name="systemParameterPo.fspaccessorysalestype">
							           老花镜
							<input type="checkbox" value="9" id="fspaccessorysalestype9" name="systemParameterPo.fspaccessorysalestype">
							           视光
							<br/><font color="red">(此项用于设置会员在门店消费时，可以通过辅料销售购买哪些类型的商品。)</font>
						   </TD>
                       </TR>
                                            
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">门店销售模块取镜时间设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspdefgetglassestime" ${systemParameterPo.fspdefgetglassestime == '1' ? 'checked':'' }>
						       		手动填写
						     	<input type="radio" value="2" name="systemParameterPo.fspdefgetglassestime" ${systemParameterPo.fspdefgetglassestime == '2' ? 'checked':'' }>
						       		自动计算
						       	<br/><font color="red">(此项用于设置门店销售模块取镜时间是否存在默认时间。)</font>
                         </TD>
                       </TR>
                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">成品片和订制片能否一起销售</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspglassessalescustom" ${systemParameterPo.fspglassessalescustom == '1' ? 'checked':'' }>
						       		可以销售
						     	<input type="radio" value="2" name="systemParameterPo.fspglassessalescustom" ${systemParameterPo.fspglassessalescustom == '2' ? 'checked':'' }>
						       		不能销售
						       	<br/><font color="red">(此项用于设置框镜销售时成品片和订制片能否一起销售。)</font>
                         </TD>
                       </TR>

                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">门店销售时默认处方方式</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspdefaultrecipetype" ${systemParameterPo.fspdefaultrecipetype == '1' ? 'checked':'' }>
						       		提交处方
						     	<input type="radio" value="2" name="systemParameterPo.fspdefaultrecipetype" ${systemParameterPo.fspdefaultrecipetype == '2' ? 'checked':'' }>
						       		手填处方
						       	<br/><font color="red">(此项用于设置门店销售时默认的处方方式是提交处方还是手填处方。)</font>
                         </TD>
                       </TR>   
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">门店销售后打印病历设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspprintmedicalhistory" ${systemParameterPo.fspprintmedicalhistory == '1' ? 'checked':'' }>
						       		不打印病历
						     	<input type="radio" value="2" name="systemParameterPo.fspprintmedicalhistory" ${systemParameterPo.fspprintmedicalhistory == '2' ? 'checked':'' }>
						       		打印病历
						       	<br/><font color="red">(此项用于设置门店销售后是否打印病历。)</font>
                         </TD>
                       </TR>  
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">制造商信息传递设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspsupplierinsertxzd" ${systemParameterPo.fspsupplierinsertxzd == '1' ? 'checked':'' }>
						       		不传递
						     	<input type="radio" value="2" name="systemParameterPo.fspsupplierinsertxzd" ${systemParameterPo.fspsupplierinsertxzd == '2' ? 'checked':'' }>
						       		传递
						       	<br/><font color="red">(此项用于设置新增的制造商信息是否传递至新中大财务软件。)</font>
                         </TD>
                       </TR>  
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body" align="right">辅料销售默认会员卡设置</TD>
                         <TD class="table_none " colspan="5">
                             <li class="horizontal_onlyRight">
                         		<input type="text" class="text_input200" value="${systemParameterPo.fspdefaultmemberid}" id="fspdefaultmemberid" name="systemParameterPo.fspdefaultmemberid" readonly="readonly">
                         	 </li>
                         	 <li class="horizontal_onlyRight">
                                <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选取默认的会员卡" onClick="changeMemberCard();">
                                <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="cleanMemberCard()">
                             </li>
                         </TD>
                       </TR>                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">不合格品调拨设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspnongallocation" ${systemParameterPo.fspnongallocation == '1' ? 'checked':'' }>
						       		自动收货：调拨单自动审核且收货。
						     	<br/><input type="radio" value="2" name="systemParameterPo.fspnongallocation" ${systemParameterPo.fspnongallocation == '2' ? 'checked':'' }>
						       		手工收货：调拨单需要手工审核、手工收货。
						       	<br/><font color="red">(此项用于设置由不合格品单产生的调拨单是否自动审核且收货。)</font>
                         </TD>
                       </TR>                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">加工难度系数设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspprocessdifficulty" ${systemParameterPo.fspprocessdifficulty == '1' ? 'checked':'' }>
						       		不使用加工难度系数
						     	<br/><input type="radio" value="2" name="systemParameterPo.fspprocessdifficulty" ${systemParameterPo.fspprocessdifficulty == '2' ? 'checked':'' }>
						       		使用天津眼科加工难度系数
						       	<br/><font color="red">(此项用于设置加工难度系数。)</font>
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">考勤系统设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspkqsystem" ${systemParameterPo.fspkqsystem == '1' ? 'checked':'' }>
						       		不使用
						     	<input type="radio" value="2" name="systemParameterPo.fspkqsystem" ${systemParameterPo.fspkqsystem == '2' ? 'checked':'' }>
						       		使用
						       	<br/><font color="red">(此项用于设置维护部门信息时是否维护考勤系统的部门ID。)</font>
                         </TD>
                       </TR>
                       <TR customerAdmin="customerAdmin">
                         <TD height="26" class="table_body " align="right">帮助视频IP端口配置</TD>
                         <TD class="table_none" colspan="5">
                         	<input class="text_input200" maxlength="50" type="text" name="systemParameterPo.fspipurl" value="${systemParameterPo.fspipurl }">
                         <br/><font color="red">(此项用于配置帮助视频的ip和端口。格式：http://192.168.0.1:6666)</font>
                         </TD>
                       </TR>                        
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">打印包装袋设置(程序未控制)</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspprintbzdflag" ${systemParameterPo.fspprintbzdflag == '1' ? 'checked':'' }>
						       		不加入销售流程
						     	<br/><input type="radio" value="2" name="systemParameterPo.fspprintbzdflag" ${systemParameterPo.fspprintbzdflag == '2' ? 'checked':'' }>
						       		加入销售流程
						       	<br/><font color="red">(此项用于设置打印包装袋功能是否并入销售流程。)</font>
                         </TD>
                       </TR>                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">隐形配送设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspyxpsflag" ${systemParameterPo.fspyxpsflag == '1' ? 'checked':'' }>
						       		隐形配送时每张配镜单创建一张自动调拨单且自动收货。
						     	<br/><input type="radio" value="2" name="systemParameterPo.fspyxpsflag" ${systemParameterPo.fspyxpsflag == '2' ? 'checked':'' }>
						       		隐形配送时每张配送单创建一张自动调拨单且手工收货。(不属于自动调拨)
						       	<br/><font color="red">(此项用于设置隐形配送后自动调拨单的创建方式及收货方式。)</font>
                         </TD>
                       </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">自动调拨设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspautoallocationflag" ${systemParameterPo.fspautoallocationflag == '1' ? 'checked':'' }>
						       		使用自动调拨
						     	<br/><input type="radio" value="0" name="systemParameterPo.fspautoallocationflag" ${systemParameterPo.fspautoallocationflag == '0' ? 'checked':'' }>
						       		不使用自动调拨
						       	<br/><font color="red">(此项用于设置结款、配镜发料、顾客取镜、积分兑换等功能是否创建自动调拨单。)</font>
                         </TD>
                       </TR> 
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">拆分销售数据设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspsplitsalesdataflag" ${systemParameterPo.fspsplitsalesdataflag == '1' ? 'checked':'' }>
						       		拆分
						     	<input type="radio" value="0" name="systemParameterPo.fspsplitsalesdataflag" ${systemParameterPo.fspsplitsalesdataflag == '0' ? 'checked':'' }>
						       		不拆分
						       	<br/><font color="red">(此项用于设置销售数据是否拆分。)</font>
                         </TD>
                       </TR>  
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">会员验光信息样式设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="text" name="systemParameterPo.fspoptometrydetailstype" value="${systemParameterPo.fspoptometrydetailstype }"><font color="red">(如为空默认为基础版本样式; 【1、基础版本样式：initRefractiveSelectN  2、北京同仁样式：initRefractiveSelectBjtr  3、哈尔滨四院样式：initRefractiveSelectHydsy】)</font>
                         </TD>
                       </TR>

                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">隐形注册证号设置</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspisregistrationnum" ${systemParameterPo.fspisregistrationnum == '1' ? 'checked':'' }>
						       		必填
						     	<input type="radio" value="0" name="systemParameterPo.fspisregistrationnum" ${systemParameterPo.fspisregistrationnum == '0' ? 'checked':'' }>
						       		不必填
						       	<br/><font color="red">(此项用于设置隐形和护理液的注册证号是否必填。)</font>
                         </TD>
                       </TR>

					   <TR companyAdmin="companyAdmin">
                          <TD height="26" class="table_body " align="right">邮寄单保价金额计算方式</TD>
                          <TD class="table_none " colspan="5">
						    <input type="radio" id="fspisbaojiaflag" name="systemParameterPo.fspisbaojiaflag" value="1" ${systemParameterPo.fspisbaojiaflag eq 1 ? "checked" : "" } />手工填写&nbsp;&nbsp;
						    </br><input type="radio" id="fspisbaojiaflag" name="systemParameterPo.fspisbaojiaflag" value="2" ${systemParameterPo.fspisbaojiaflag eq 2 ? "checked" : "" } />自动计算（天津眼科专用，3000元以上进行保价，且保价金额为应收金额的50%）
						    </br><span style="color:red">(此项用于设置邮寄单中保价金额的计算方式。)</span>
                          </TD>
					   </TR>
					   
					   <TR companyAdmin="companyAdmin">
                          <TD height="26" class="table_body " align="right">成本计算的计算方式</TD>
                          <TD class="table_none " colspan="5">
						    <input type="radio" name="systemParameterPo.fspcbjstype" value="1" ${systemParameterPo.fspcbjstype eq 1 ? "checked" : "" } />按所有公司计算&nbsp;&nbsp;
						    </br><input type="radio" name="systemParameterPo.fspcbjstype" value="2" ${systemParameterPo.fspcbjstype eq 2 ? "checked" : "" } />按公司计算
						    </br><span style="color:red">(此项用于设置成本计算的计算方式。)</span>
                          </TD>
					   </TR>
					   
					   <TR companyAdmin="companyAdmin">
                          <TD height="26" class="table_body " align="right">成本计算后重新转时英</TD>
                          <TD class="table_none " colspan="5">
						    <input type="radio" name="systemParameterPo.fspcbjsscxzsy" value="1" ${systemParameterPo.fspcbjsscxzsy eq 1 ? "checked" : "" } />不重新执行&nbsp;&nbsp;
						    </br><input type="radio" name="systemParameterPo.fspcbjsscxzsy" value="2" ${systemParameterPo.fspcbjsscxzsy eq 2 ? "checked" : "" } />重新执行
						    </br><span style="color:red">(此项用于设置成本计算后是否重新转日销售商品明细和商品周转率表的时英。)</span>
                          </TD>
					   </TR>
					   
					   <TR companyAdmin="companyAdmin">
                          <TD height="26" class="table_body " align="right">门店日结账时间</TD>
                          <TD class="table_none " colspan="5">
						    <select name="hhcheckout">
						       <option value="00" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '00' ? 'selected="selected"' : '' }>00</option>
						       <option value="01" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '01' ? 'selected="selected"' : '' }>01</option>
						       <option value="02" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '02' ? 'selected="selected"' : '' }>02</option>
						       <option value="03" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '03' ? 'selected="selected"' : '' }>03</option>
						       <option value="04" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '04' ? 'selected="selected"' : '' }>04</option>
						       <option value="05" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '05' ? 'selected="selected"' : '' }>05</option>
						       <option value="06" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '06' ? 'selected="selected"' : '' }>06</option>						       
						       <option value="07" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '07' ? 'selected="selected"' : '' }>07</option>
						       <option value="08" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '08' ? 'selected="selected"' : '' }>08</option>
						       <option value="09" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '09' ? 'selected="selected"' : '' }>09</option>
						       <option value="10" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '10' ? 'selected="selected"' : '' }>10</option>						       
						       <option value="11" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '11' ? 'selected="selected"' : '' }>11</option>
						       <option value="12" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '12' ? 'selected="selected"' : '' }>12</option>
						       <option value="13" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '13' ? 'selected="selected"' : '' }>13</option>
						       <option value="14" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '14' ? 'selected="selected"' : '' }>14</option>
						       <option value="15" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '15' ? 'selected="selected"' : '' }>15</option>
						       <option value="16" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '16' ? 'selected="selected"' : '' }>16</option>						       
						       <option value="17" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '17' ? 'selected="selected"' : '' }>17</option>
						       <option value="18" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '18' ? 'selected="selected"' : '' }>18</option>
						       <option value="19" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '19' ? 'selected="selected"' : '' }>19</option>
						       <option value="20" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '20' ? 'selected="selected"' : '' }>20</option>						       
						       <option value="21" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '21' ? 'selected="selected"' : '' }>21</option>
						       <option value="22" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '22' ? 'selected="selected"' : '' }>22</option>
						       <option value="23" ${fn:substring(systemParameterPo.fspdaycheckout,0,2) eq '23' ? 'selected="selected"' : '' }>23</option>
						    </select>&nbsp;&nbsp;:&nbsp;&nbsp;
						    <select name="mmcheckout">
						       <option value="00" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '00' ? 'selected="selected"' : '' }>00</option>
						       <option value="01" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '01' ? 'selected="selected"' : '' }>01</option>
						       <option value="02" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '02' ? 'selected="selected"' : '' }>02</option>
						       <option value="03" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '03' ? 'selected="selected"' : '' }>03</option>
						       <option value="04" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '04' ? 'selected="selected"' : '' }>04</option>
						       <option value="05" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '05' ? 'selected="selected"' : '' }>05</option>
						       <option value="06" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '06' ? 'selected="selected"' : '' }>06</option>						       
						       <option value="07" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '07' ? 'selected="selected"' : '' }>07</option>
						       <option value="08" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '08' ? 'selected="selected"' : '' }>08</option>
						       <option value="09" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '09' ? 'selected="selected"' : '' }>09</option>
						       <option value="10" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '10' ? 'selected="selected"' : '' }>10</option>						       
						       <option value="11" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '11' ? 'selected="selected"' : '' }>11</option>
						       <option value="12" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '12' ? 'selected="selected"' : '' }>12</option>
						       <option value="13" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '13' ? 'selected="selected"' : '' }>13</option>
						       <option value="14" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '14' ? 'selected="selected"' : '' }>14</option>
						       <option value="15" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '15' ? 'selected="selected"' : '' }>15</option>
						       <option value="16" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '16' ? 'selected="selected"' : '' }>16</option>						       
						       <option value="17" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '17' ? 'selected="selected"' : '' }>17</option>
						       <option value="18" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '18' ? 'selected="selected"' : '' }>18</option>
						       <option value="19" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '19' ? 'selected="selected"' : '' }>19</option>
						       <option value="20" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '20' ? 'selected="selected"' : '' }>20</option>						       
						       <option value="21" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '21' ? 'selected="selected"' : '' }>21</option>
						       <option value="22" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '22' ? 'selected="selected"' : '' }>22</option>
						       <option value="23" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '23' ? 'selected="selected"' : '' }>23</option>						       
						       <option value="24" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '24' ? 'selected="selected"' : '' }>24</option>
						       <option value="25" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '25' ? 'selected="selected"' : '' }>25</option>
						       <option value="26" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '26' ? 'selected="selected"' : '' }>26</option>						       
						       <option value="27" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '27' ? 'selected="selected"' : '' }>27</option>
						       <option value="28" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '28' ? 'selected="selected"' : '' }>28</option>
						       <option value="29" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '29' ? 'selected="selected"' : '' }>29</option>
						       <option value="30" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '30' ? 'selected="selected"' : '' }>30</option>						       
						       <option value="31" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '31' ? 'selected="selected"' : '' }>31</option>
						       <option value="32" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '32' ? 'selected="selected"' : '' }>32</option>
						       <option value="33" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '33' ? 'selected="selected"' : '' }>33</option>
						       <option value="34" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '34' ? 'selected="selected"' : '' }>34</option>
						       <option value="35" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '35' ? 'selected="selected"' : '' }>35</option>
						       <option value="36" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '36' ? 'selected="selected"' : '' }>36</option>						       
						       <option value="37" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '37' ? 'selected="selected"' : '' }>37</option>
						       <option value="38" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '38' ? 'selected="selected"' : '' }>38</option>
						       <option value="39" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '39' ? 'selected="selected"' : '' }>39</option>
						       <option value="40" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '40' ? 'selected="selected"' : '' }>40</option>						       
						       <option value="41" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '41' ? 'selected="selected"' : '' }>41</option>
						       <option value="42" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '42' ? 'selected="selected"' : '' }>42</option>
						       <option value="43" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '43' ? 'selected="selected"' : '' }>43</option>
						       <option value="44" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '44' ? 'selected="selected"' : '' }>44</option>
						       <option value="45" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '45' ? 'selected="selected"' : '' }>45</option>
						       <option value="46" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '46' ? 'selected="selected"' : '' }>46</option>						       
						       <option value="47" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '47' ? 'selected="selected"' : '' }>47</option>
						       <option value="48" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '48' ? 'selected="selected"' : '' }>48</option>
						       <option value="49" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '49' ? 'selected="selected"' : '' }>49</option>
						       <option value="50" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '50' ? 'selected="selected"' : '' }>50</option>						       
						       <option value="51" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '51' ? 'selected="selected"' : '' }>51</option>
						       <option value="52" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '52' ? 'selected="selected"' : '' }>52</option>
						       <option value="53" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '53' ? 'selected="selected"' : '' }>53</option>						       
						       <option value="54" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '54' ? 'selected="selected"' : '' }>54</option>
						       <option value="55" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '55' ? 'selected="selected"' : '' }>55</option>
						       <option value="56" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '56' ? 'selected="selected"' : '' }>56</option>						       
						       <option value="57" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '57' ? 'selected="selected"' : '' }>57</option>
						       <option value="58" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '58' ? 'selected="selected"' : '' }>58</option>
						       <option value="59" ${fn:substring(systemParameterPo.fspdaycheckout,3,5) eq '59' ? 'selected="selected"' : '' }>59</option>						       						    
						    </select>&nbsp;&nbsp; 
						    <span style="color:red">(此项用于设置门店日结账时间。)</span>
                          </TD>
					   </TR>
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">新增制造商是否同步供应商与公司的绑定关系</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspsyncompanysupplier" ${systemParameterPo.fspsyncompanysupplier == '1' ? 'checked':'' }>
						       		同步
						     	<input type="radio" value="0" name="systemParameterPo.fspsyncompanysupplier" ${systemParameterPo.fspsyncompanysupplier == '0' ? 'checked':'' }>
						       		不同步
						       	<br/><font color="red">(此项用于爱尔集团定制。)</font>
                         </TD>
                       </TR>
                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">期初库存导入完成</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspqckcfinish" ${systemParameterPo.fspqckcfinish == '1' ? 'checked':'' }>
						       		已完成
						     	<input type="radio" value="0" name="systemParameterPo.fspqckcfinish" ${systemParameterPo.fspqckcfinish == '0' ? 'checked':'' }>
						       		未完成
						       	<br/><font color="red">(此项用于设置系统期初库存导入是否已经完成。)</font>
                         </TD>
                       </TR>
                       <TR companyAdmin="customerAdmin">
                         <TD height="26" class="table_body" align="right">鼠标右键点击浏览器是否出现URL地址</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fsprightshowurl" ${systemParameterPo.fsprightshowurl == '1' ? 'checked':'' }>
						       		不显示
						     	<input type="radio" value="0" name="systemParameterPo.fsprightshowurl" ${systemParameterPo.fsprightshowurl == '0' ? 'checked':'' }>
						       		显示
                         </TD>
                       </TR>                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">期初成本导入完成</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fspqccbfinish" ${systemParameterPo.fspqccbfinish == '1' ? 'checked':'' }>
						       		已完成
						     	<input type="radio" value="0" name="systemParameterPo.fspqccbfinish" ${systemParameterPo.fspqccbfinish == '0' ? 'checked':'' }>
						       		未完成
						       	<br/><font color="red">(此项用于设置系统期初成本导入是否已经完成。)</font>
                         </TD>
                       </TR>                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">领用出库单和批发单据参与成本计算</TD>
                         <TD class="table_none " colspan="5">
                         		<input type="radio" value="1" checked name="systemParameterPo.fsplyandpfbycbjs" ${systemParameterPo.fsplyandpfbycbjs == '1' ? 'checked':'' }>
						       		已参与成本计算
						     	<input type="radio" value="0" name="systemParameterPo.fsplyandpfbycbjs" ${systemParameterPo.fsplyandpfbycbjs == '0' ? 'checked':'' }>
						       		未参与成本计算
						       	<br/><font color="red">(此项用于设置领用出库单和批发单据是否参与成本计算。)</font>
                         </TD>
                       </TR>
                       
                       <TR companyAdmin="companyAdmin">
                         <TD height="26" class="table_body" align="right">系统Sleep日期</TD>
                         <TD class="table_none " colspan="5">
                         		<input id="sleeptartTime" clean="clean" name="systemParameterPo.fspsleepstarttime" type="text" class="text_input100"  
						       onFocus="WdatePicker({readOnly:true})"
						       value="${systemParameterPo.fspsleepstarttime }" readonly="readonly"/>	
                         </TD>
                       </TR>                      				                                                                                                                                                                                                                                                                                                                                                					   
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY>
    <script>
       
    function initCompanyAdminLoginShow() {
        $("tr[customerAdmin=customerAdmin]").hide();
        $("tr[companyAdmin=companyAdmin]").hide();
    }
    
   	initCompanyAdminLoginShow();
   	initCompanyAdminLoginShowMenu();
    </script>
    </html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
