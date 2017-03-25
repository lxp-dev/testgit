<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<script language="javascript">
/*
 * 进入销售页面的时候，初始化页面
 */
$(document).ready(function() {
	$("img[btn=btn]").attr("style","cursor: hand");
	$("img[btn=btn]").mouseover(function () {
    	$(this).attr("src",$(this).attr("src").replace("0","1"));
	}).mouseout(function () {
		$(this).attr("src",$(this).attr("src").replace("1","0"));
	});

    $("div[btn=btn]").attr("style","cursor: hand;"); 
    $("div[btn=btn]").mouseover(function () { 
    	$(this).removeClass('giftShortcut_mouseover');
    	$(this).addClass('giftShortcut_mouseout');
    }).mouseout(function () { 
    	$(this).removeClass('giftShortcut_mouseout');
    	$(this).addClass('giftShortcut_mouseover');
    }); 

    $("span[btn=btn]").mouseover(function () { 
    	$(this).removeClass('discountKeysShortcut_mouseover');
    	$(this).addClass('discountKeysShortcut_mouseout');
    }).mouseout(function () { 
    	$(this).removeClass('discountKeysShortcut_mouseout');
    	$(this).addClass('discountKeysShortcut_mouseover');
    }); 
    
    changeWF();

    if ('${systemParameterPo.fspshowcustomertable}' == '1'){
	    printcustomer('${customerInfoPo.smecicustomerid }');
	}
    
    changeCheckConclusion('${systemParameterPo.fspdefaultrecipetype}');

    setSalesRecipelFrame('1');    

	var printflag = '${param.print}';
	if(printflag == '1'){
		printflag = '';
		if('${param.pcheckoutFlag}'=='1'){
			printReport('${param.pssesborderstype}','${param.psalseID}');

	        if ($.trim('${systemParameterPo.fspsubscriptionbillname}') == ''){
	            alert('请先配置订金单样式!');
	            return;
	        }
	        
			var DataURL="report.action?reportlet=${systemParameterPo.fspsubscriptionbillname}&salesID="+'${param.psalseID}';
			window.open (DataURL, '定金单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
		}else{
			printReport('${param.pssesborderstype}','${param.psalseID}');
		}
	}

	$('tr[setsealname=setsealname]').hide();
	
	if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
		document.getElementById('smecimemberid').focus(); 
    }

	if('${arg0}'=='salseallnew'){
		$('#smecimemberid').val('${regMemberID}');
		if(document.getElementById('smecimemberid').value.trim() != ''){
			frameSalesForm.action="queryShopSalesMain.action";
			frameSalesForm.submit();
		}
	}

	$('input[name=salesBasicPo\\.ssesbsalerid]').val($('#ssesbsalerid').val());
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
	
	$("input[noreadonly=noreadonly][valuetype=number]").each(function(){  // 手动填写
	 	$(this).bind('blur',function(){
			isNumberType(this);
		});
	});
	
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
	if ('${systemParameterPo.fspdefgetglassestime}' === '2'){
		$('#ssesbtakeglasstype').change(function(){
			calculate($(this).val());
		});
	}

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
	setDiscount1("1.00","","","","");
	selLocation();
	selGlassType("1");
	getTadayDate();
	
    if ('${returnAccessoriesUrl}' == '1'){
    	defineSalesTyle('5');
    }

    if (('${customerInfoPo.smecicustomerid}' == '') && ('${customerInfoPo2.smecicustomerid}' == '')){
        $('#divopmessage').hide();
        $('#divopmessage2').hide();
    }
	
});

/*
 * 隐形销售修改数量时变成可直接更改的状态
 */
function changeSalesNumber(obj){
    if ($("input[name=salestype]:checked").val() == '3'){
        obj.select();
    }
}

function printcustomer(customerid){
	if('${customerprinttype}'&&'${begin}'){
		if (${reportTypeSwitch} == '2'){
			var url = '<%= getServletContext().getInitParameter("pjdUrl")%>';
			url+="eims_reporting/sales_customerRepRpt&memberID="+$('#smecimemberid').val()+"&rs:Command=Render";
			window.open(url, 'customerRepRpt', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	    }else{
			var DataURL='';
	   		DataURL="report.action?reportlet=sales_hydy.cpt&customerID="+customerid;
	    	window.open (DataURL, '会员卡打印', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
		}
	}
}

/*
 * 通过单击销售类型周边的区域也可以选取销售类型
 */
function defineSalesTyle(obj){

    if ((obj == '5') && ('${systemParameterPo.fspdefaultmemberid}' != '') && ('${customerInfoPo2.smecicustomerid}' == '')){
		frameSalesForm.action="initAccessoriesSalesMain.action";
		frameSalesForm.submit();
        return;
    }

    if ((obj == '1' || obj == '3') && ('${customerInfoPo.smecicustomerid}' == '')){
        $('#divopmessage').hide();
        $('#divopmessage2').hide();

		$('#smecimemberid').val('');
		$('#smeciname').val('');
		$('#smecisex').val('');
		$('#smeciage').val('');
		$('#smecimembername').val('');
		$('#titlediscount').val('');
		$('#smeciintegral').val('');
		$('#smecicustomerid').val('');
		$('#smecigoodscategoryid').val('');	
		
        return;
    }else{
        if (('${customerInfoPo.smecicustomerid}' == '') && ('${customerInfoPo2.smecicustomerid}' == '')){
            $('#divopmessage').hide();
            $('#divopmessage2').hide();

    		$('#smecimemberid').val('');
    		$('#smeciname').val('');
    		$('#smecisex').val('');
    		$('#smeciage').val('');
    		$('#smecimembername').val('');
    		$('#titlediscount').val('');
    		$('#smeciintegral').val('');
    		$('#smecicustomerid').val('');
    		$('#smecigoodscategoryid').val('');	
    		
            return;
        }
    }

    $('#divopmessage').show();
    $('#divopmessage2').show();
	
	$('input[name=salestype][value='+obj+']').attr('checked', true);
	showSalesType($('input[name=salestype][value='+obj+']'));
	changeWF();  

	if (obj == '5' && ($('#smecimemberid').val() == '' || '${customerInfoPo.smecicustomerid}' == '' || '${customerInfoPo.smecimemberid}' == '' )){
		$('#smecimemberid').val('${customerInfoPo2.smecimemberid}');
		$('#smeciname').val('${customerInfoPo2.smeciname}');
		$('#smecisex').val('${customerInfoPo2.smecisex}' == '0' ? '男' : '女');
		$('#smeciage').val('${customerInfoPo2.fmmdown}');
		$('#smecimembername').val('${customerInfoPo2.fmmmembername}');
		$('#titlediscount').val('${customerInfoPo2.fmmdiscount}');
		$('#smeciintegral').val('${customerInfoPo2.smeciintegral}');
		$('#smecicustomerid').val('${customerInfoPo2.smecicustomerid}');
		$('#smecigoodscategoryid').val('${customerInfoPo2.smecigoodscategoryid}');
    }

	if ((obj == '1' || obj == '3') && ($('#smecimemberid').val() == '' || '${customerInfoPo.smecicustomerid}' == '' || '${customerInfoPo.smecimemberid}' == '' )){
		$('#smecimemberid').val('');
		$('#smeciname').val('');
		$('#smecisex').val('');
		$('#smeciage').val('');
		$('#smecimembername').val('');
		$('#titlediscount').val('');
		$('#smeciintegral').val('');
		$('#smecicustomerid').val('');
		$('#smecigoodscategoryid').val('');	
    }
}

/*
 * 单击检查结论是否提交的单选按钮
 */
function changeCheckConclusion(obj){
	if (obj == '1'){
		$('tr[notoptometry=notoptometry]').hide();
		$('tr[optometry=optometry]').show();
	}	
	if (obj == '2'){
		$('tr[notoptometry=notoptometry]').show();
		$('tr[optometry=optometry]').hide();
	}
}

/*
 * 验光处方次数小于4或无验光处方时，iframe不显示滚动条，否则显示滚动条
 */
function setSalesRecipelFrame(obj){
    $('#salesRecipelFrame').attr('src', 'initShopSalesRecipel.action?customerid=${customerInfoPo.smecicustomerid}');
    //window.parent.salesRecipelFrame.showLoadingBar();
}

function changeWF() { 
	var recipetype = $("#recipetype").val();
	if('${systemParameterPo.fspupdateinspection}' == '0'){   // 在销售时不选择处方类型或外方时，可手动填写处方信息
		if($("#checkboxwl").attr("checked")){
			if(recipetype == '1'){
				$("[glassType=yuanyong]").attr("readonly","");
			}else if(recipetype == '2'){
				$("[glassType=jinyong]").attr("readonly","");
			}else if(recipetype == '3'){
				$("[glassType=jianjin]").attr("readonly","");
			}else if(recipetype == '4'){
				$("[glassType=yinxing]").attr("readonly","");
			}else if(recipetype == '5'){
				$("[glassType=zhongyong]").attr("readonly","");
			}else if(recipetype == '6'){
				$("[glassType=suxing]").attr("readonly","");
			}else if(recipetype == '7'){
				$("[glassType=shijuexunlian]").attr("readonly","");
			}
		}else{
			if(recipetype == '1'){
				$("[glassType=yuanyong]").attr("readonly","readonly");
			}else if(recipetype == '2'){
				$("[glassType=jinyong]").attr("readonly","readonly");
			}else if(recipetype == '3'){
				$("[glassType=jianjin]").attr("readonly","readonly");
			}else if(recipetype == '4'){
				$("[glassType=yinxing]").attr("readonly","readonly");
			}else if(recipetype == '5'){
				$("[glassType=zhongyong]").attr("readonly","readonly");
			}else if(recipetype == '6'){
				$("[glassType=suxing]").attr("readonly","readonly");
			}else if(recipetype == '5'){
				$("[glassType=shijuexunlian]").attr("readonly","readonly");
			}
		}
	}
}

function getAjaxCustomerDiscount(goodsid,maxdiscount){
   	$.ajax({           
   	 	type: "POST",          
   	    url: "getAjaxCustomerDiscountNew.action",          
   	    async: true, 
   	    data: "categoryid="+goodsid.substring(0,1)+"&supplierid="+goodsid.substring(2,4)+"&brandid="+goodsid.substring(5,7)+"&goodsid="+goodsid+"&iscustomize=&cardtype="+'${customerInfoPo.smecicardtype}'+"&shopcode=${logindepartmentid}",     
   	    success: function(msg){
	        var titlediscounttmp = msg;
	        if (titlediscounttmp==null || $.trim(titlediscounttmp)=='' || isNaN(titlediscounttmp)){
	            titlediscounttmp="1.0";
	 	    }
	 	    if (Number(titlediscounttmp) < Number(maxdiscount)){
	 	    	titlediscounttmp=maxdiscount;        
		 	} 
	    	$('input[name=salesDetailPo\\.ssesdsalesitemids][value='+goodsid+']').parent().parent().parent().find("#chk").attr("checked","checked");
    		setDiscount1(titlediscounttmp,'1','','','');
    		$('input[name=salesDetailPo\\.ssesdsalesitemids][value='+goodsid+']').parent().parent().parent().find("#chk").attr("checked","");
   	    }    
   	});
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

function calculate(day)
{
	var d = new Date(Date.parse('${dqqjsj2}'));
	var vYear = d.getFullYear();
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
 	
	if ('${systemParameterPo.fspdefgetglassestime}' === '2'){
		$('#ssesbtakeglassdata').val(DateAdd('d',day,uValue)+' '+vHour+':'+vMin);
    }

}

function searchWF(){
	var nameval = "";
	$("input[name=salesDetailPo.ssesdsalesitemnames]").each(function (){
		nameval = nameval + $(this).val();
	});
	
	if(nameval){
		if($("#checkboxwl").attr("checked")){
			$("#checkboxwl").attr("checked","");
		}else{
			$("#checkboxwl").attr("checked","checked");
		}
		alert("选择商品后,不能切换外方！");
	}else{
		
		changeWF();
	}
}

function openMember(){
    if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
        alert('此门店已经连接HIS系统，不能新增会员!');
        return;
    }
    
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("initInsertCustomerInfo.action?arg0=salseallnew&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}else{
		showPopWin("initInsertCustomerInfo.action?arg0=salseallnew&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
	}
	document.getElementById('popupTitle').innerHTML="【会员新增】";
}

function changeSaleser(){
	if(!isCustomerExist()){
		$('#ssesbsalerid').attr("disabled","");
	}	
}

function disabledSelect(){
	$('#ssesbsalerid').attr("disabled","disabled");
	$('input[name=salesBasicPo\\.ssesbsalerid]').val($('#ssesbsalerid').val());
}

function changeOptometryPerson(){
	if ($('#optometryPerson').attr("disabled") == true){
		$('#optometryPerson').attr("disabled","");
	}else{
		$('#optometryPerson').attr("disabled","disabled");
    }	
}

function disabledOptometryPersonSelect(){
	$('#optometryPerson').attr("disabled","disabled");
	$('#optometryPersonID').val($('#optometryPerson').val());
}

//按键改变数值   球镜、柱镜、旧瞳距、片高
function changeFocus(obj){
    if(event.keyCode==38){   // UP ARROW键(↑)
		if(obj.value == ''){
			obj.value=0.25;
		}
		else{
		    obj.value = (parseFloat(obj.value)+0.25).toFixed(2);		
		}
	}
    if(event.keyCode==40){    // DOWN ARROW键(↓)
		if(obj.value == ''){
			obj.value = -0.25;
		}else{
			obj.value = (parseFloat(obj.value)-0.25).toFixed(2);			
		}
	}
}

//按键改变数值
function isNumberType(obj)
{
    if(isNaN($(obj).val())){
    	alert("请输入正确格式！");
    	$(obj).focus();
    	$(obj).select();
	}else{
		if($(obj).val()){
			$(obj).val(parseFloat($(obj).val()).toFixed(1));
		}
	}
}

/*
*填写邮寄信息
*/
function toMailInsert(smecimemberid ,smeciname ,smeciphone ){
	if($('#smeciname').val() != ''){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initMailInfoInsert.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initMailInfoInsert.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【邮寄信息】";
	}else{
		alert("请先输入会员卡号！");
	}
}

/*
*邮寄信息赋值
*/
function setMailInfo(smecimemberid ,smeciname ,smeciphone ){

}

function selLocation(){	
	var isd = 0;
	if($("input[id=salestype]:checked").val() != '2' && $("input[id=salestype]:checked").val() != '4'){
		$("input[name=salesDetailPo\\.ssesdsalesitemids]").each(function (){
			if($(this).val().substring(8,9) == 'D'){
				isd = isd + 1;
			}
		});

		if(isd == 0){
			var mm = $("#ssesblocation").find("option:selected").attr('takeglassdate');
			calculateHours(mm);
		}
		$("input[name=salesBasicPo.ssesblocation]").val($('#ssesblocation').val());
		$('#ssesblocation').attr("disabled","disabled");
	}
}

function selGlassType(type){
	var checkaccessories = '${systemParameterPo.fspcheckaccessories }';
	if(type==4){
		$('input[name=salestype][value=3]').attr("checked","checked");
		$("table[id=kj]").hide();
		$("table[id=yx]").show();
		$("table[id=yxandfl]").hide();
		$("table[id=kjandfl]").hide();
		$("table[id=pj]").hide();
		if(checkaccessories == '1'){
			$("table[id=yxandfl]").hide();
		}else{
			$("table[id=yxandfl]").show();
		}
		$("#ourframeorglass").hide();
	}else if(type==2||type==1){
		if($('input[name=salestype]:checked').val() == '1'){
			$('input[name=salestype][value=1]').attr("checked","checked");
			$("table[id=kj]").show();
			$("table[id=yx]").hide();
			$("table[id=yxandfl]").hide();
			$("table[id=kjandfl]").hide();
			$("table[id=pj]").hide();			
			if(checkaccessories == '1'){
				$("table[id=kjandfl]").hide();
			}else{
				$("table[id=kjandfl]").show();
			}
			$("#ourframeorglass").show();
		}else if($('input[name=salestype]:checked').val() == '5'){
			$('input[name=salestype][value=5]').attr("checked","checked");
			$("table[id=kj]").hide();
			$("table[id=yx]").hide();
			$("table[id=pj]").show();			
		}else{
			$('input[name=salestype][value=1]').attr("checked","checked");
			$("table[id=kj]").show();
			$("table[id=yx]").hide();
			$("table[id=yxandfl]").hide();
			$("table[id=kjandfl]").hide();
			$("table[id=pj]").hide();	
			if(checkaccessories == '1'){
				$("table[id=kjandfl]").hide();
			}else{
				$("table[id=kjandfl]").show();
			}
			$("#ourframeorglass").show();
		}
	}else if(type == '6'){
		$('input[name=salestype][value=3]').attr("checked","checked");
		$("table[id=kj]").hide();
		$("table[id=yx]").show();
		$("table[id=yxandfl]").hide();
		$("table[id=kjandfl]").hide();
		$("table[id=pj]").hide();

		if(checkaccessories == '1'){
			$("table[id=yxandfl]").hide();
		}else{
			$("table[id=yxandfl]").show();
		}
		$("#ourframeorglass").hide();
		
	}else if(type == '7'){
		$('input[name=salestype][value=5]').attr("checked","checked");
		$("table[id=kj]").hide();
		$("table[id=yx]").hide();
		$("table[id=yxandfl]").hide();
		$("table[id=kjandfl]").hide();
		$("table[id=pj]").show();
		$("#ourframeorglass").hide();
		
	}else{
		$('input[name=salestype][value=1]').attr("checked","checked");
		$("table[id=kj]").show();
		$("table[id=yx]").hide();
		$("table[id=yxandfl]").hide();
		$("table[id=kjandfl]").hide();
		$("table[id=pj]").hide();	
		if(checkaccessories == '1'){
			$("table[id=kjandfl]").hide();
		}else{
			$("table[id=kjandfl]").show();
		}
		$("#ourframeorglass").show();
	}
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
		$('#yuanyong').show();// 远用
		$("[glassType='yuanyong']").removeAttr("disabled");
		$("[glassType][glassType!='yuanyong']").each(function(){
			if(this.glassType != null) {
				this.disabled = true;
				this.value = '';
			}
		});
		
		$('#jinyong').hide();//  近用
		$('#yinxing').hide();	//隐形
		$('#jianjin').hide();//  双光渐进
		$('#zhongyong').hide();//中用
		$('#shijuexunlian').hide();	//视觉训练
		$('#suxing').hide();	//塑形
		$("input[id=salestype_input]").val('1');
		$('input[name=salestype][value=1]').attr("checked","checked");
	}else if(type == '2'){//近用
		if($('input[name=salestype]:checked').val() != '5'){
			$('#yuanyong').hide();// 远用
			$('#jinyong').show();//  近用
			$('#yinxing').hide();	//隐形
			$("[glassType='jinyong']").removeAttr("disabled");
			$("[glassType][glassType!='jinyong']").each(function(){
				if(this.glassType != null){
					this.disabled = true;
					this.value = '';
				}
			});
			
			$('#jianjin').hide();//  双光渐进
			$('#zhongyong').hide();//中用
			$('#shijuexunlian').hide();	//视觉训练
			$('#suxing').hide();	//塑形
			$("input[id=salestype_input]").val('1');
		}else{
			$('#yuanyong').hide();// 远用
			$('#jinyong').show();//  近用
			$('#yinxing').hide();	//隐形
			$("[glassType='jinyong']").removeAttr("disabled");
			$("[glassType][glassType!='jinyong']").each(function(){
				if(this.glassType != null) {
					this.disabled = true;
					this.value = '';
				}
			});
			
			$('#jianjin').hide();//  双光渐进
			$('#zhongyong').hide();//中用
			$('#shijuexunlian').hide();	//视觉训练
			$('#suxing').hide();	//塑形
			$("input[id=salestype_input]").val('5');
		}
	}else if(type == '3'){//双光/渐进
		$('#yuanyong').hide();// 远用
		$('#jinyong').hide();//  近用
		$('#yinxing').hide();	//隐形
		$('#jianjin').show();//  双光渐进
		$("[glassType='jianjin']").removeAttr("disabled");
		$("[glassType][glassType!='jianjin']").each(function(){
			if(this.glassType != null) {
				this.disabled = true;
				this.value = '';
			}
		});
		$('#zhongyong').hide();	//中用
		$('#shijuexunlian').hide();	//视觉训练
		$('#suxing').hide();	//塑形
		$("input[id=salestype_input]").val('1');
	}else if(type == '5'){		//中用
		$('#yuanyong').hide();	//远用
		$('#jinyong').hide();	//近用
		$('#zhongyong').show();	//中用
		$('#jianjin').hide();	//双光渐进
		$('#yinxing').hide();	//隐形
		$('#shijuexunlian').hide();	//视觉训练
		$('#suxing').hide();	//塑形
		$("[glassType='zhongyong']").removeAttr("disabled");
		$("[glassType][glassType!='zhongyong']").each(function(){
			if(this.glassType != null) {
				this.disabled = true;
				this.value = '';
			}
		});
		$("input[id=salestype_input]").val('1');
	}else if(type == '4'){		//隐形
		$('#yuanyong').hide();	//远用
		$('#jinyong').hide();	//近用
		$('#yinxing').show();	//隐形
		$('#zhongyong').hide();	//中用
		$('#jianjin').hide();	//双光渐进
		$('#shijuexunlian').hide();	//视觉训练
		$('#suxing').hide();	//塑形
		$("[glassType='yinxing']").removeAttr("disabled");
		$("input[name=syjp]").attr("readonly","readonly");
		$("input[name=syjpnum]").attr("readonly","readonly");
		$("[glassType][glassType!='yinxing']").each(function(){
			if(this.glassType != null) {
				this.disabled = true;
				this.value = '';
			}
		});
		$("input[id=salestype_input]").val('3');
	}else if(type == '6'){		//塑形
		$('#yuanyong').hide();	//远用
		$('#jinyong').hide();	//近用
		$('#yinxing').hide();	//隐形
		$('#zhongyong').hide();	//中用
		$('#jianjin').hide();	//双光渐进
		$('#shijuexunlian').hide();	//视觉训练
		$('#suxing').show();	//塑形
		$("[glassType='suxing']").removeAttr("disabled");
		$("input[name=syjp]").attr("readonly","readonly");
		$("input[name=syjpnum]").attr("readonly","readonly");
		$("[glassType][glassType!='suxing']").each(function(){
			if(this.glassType != null) {
				this.disabled = true;
				this.value = '';
			}
		});
		$("input[id=salestype_input]").val('3');
	}else if(type == '7'){		//视觉训练
		$('#yuanyong').hide();	//远用
		$('#jinyong').hide();	//近用
		$('#yinxing').hide();	//隐形
		$('#zhongyong').hide();	//中用
		$('#jianjin').hide();	//双光渐进
		$('#shijuexunlian').show();	//视觉训练
		$('#suxing').hide();	//塑形

		$("[glassType][glassType!='shijuexunlian']").each(function(){
			if(this.glassType != null) {
				this.disabled = true;
				this.value = '';
			}
		});
		$("input[id=salestype_input]").val('5');
	} else {
		$('#yuanyong').hide();	// 远用
		$('#jinyong').hide();	// 近用
		$('#jianjin').hide();	// 双光渐进
		$('#zhongyong').hide();	// 中用
		$('#yinxing').hide();	// 隐形
		$('#shijuexunlian').hide();	//视觉训练
		$('#suxing').hide();	//塑形
		$("[glassType][glassType='yuanyong']").each(function(){
			this.disabled = true;
			this.value = '';
		});
		$("[glassType][glassType='jinyong']").each(function(){
			this.disabled = true;
			this.value = '';
		});
		$("[glassType][glassType='jianjin']").each(function(){
			this.disabled = true;
			this.value = '';
		});
		$("[glassType][glassType='yinxing']").each(function(){
			this.disabled = true;
			this.value = '';
		});
		$("[glassType][glassType='zhongyong']").each(function(){
			this.disabled = true;
			this.value = '';
		});
		$("[glassType][glassType='suxing']").each(function(){
			this.disabled = true;
			this.value = '';
		});
		
		$("input[id=salestype_input]").val('');
	}
	if('${systemParameterPo.fspupdateinspection}' == '0'){
		if($("#checkboxwl").attr("checked")){
			$("[glassType]").each(function(){
				$(this).attr("readonly","");
			});
		}else{
			$("[glassType][noreadonly!=noreadonly]").each(function(){
				$(this).attr("readonly","readonly");
			});
		}
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
	
	document.getElementById('recipetype').disabled = false;
	
	var inputObj = $("[glassType]");
	inputObj.attr('disabled', '');
	inputObj.removeAttr('readOnly');
	inputObj.val('');
	
	for(var i=1; i<=72; i++){
		$("[yyorder="+i+"]").val('');
	}
	$('#ssesboptid').val('');
	$('#ssesboptometryid').val('');
	$('#inspectionid').val('');
	$("td[id=setmealtitle]").text("");
	$("input[id=ssesbsetmealid]").val("");
	$("#nohavetc").show();
	$("#havetc").hide();
}

function selGlassTime(Datetime){
    var day = new Date(Date.parse('${dqqjsj2}'));
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
	if(Datetime.substring(0,10)!=CurrentDate){
	   alert("您选择的处方非当日处方!");
	}
	$("#optometryID").val('${inspectionPos[0].sopipoptometryid }');
	$('#ssetmsenddate').val(Datetime);
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
		alert("球镜、柱镜、ADD应为 0.25的倍数！");
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
	
	checkCylZero();
}

function checkCylZero(){
	$("[name=salesBasicPo.ssesbpostglassos]").each(function (){
		if(parseFloat($(this).val()) == 0){
			if($(this).parent().parent().find("[axes=axes]")){
				$(this).parent().parent().find("[axes=axes]").val("");
				$(this).parent().parent().find("[axes=axes]").attr("style","background-color: red;width:100%;");
				$(this).parent().parent().find("[axes=axes]").attr("readonly","readonly");
			}else{
				$(this).parent().parent().parent().find("[axes=axes]").val("");
				$(this).parent().parent().parent().find("[axes=axes]").attr("style","background-color: red;width:100%;");
				$(this).parent().parent().parent().find("[axes=axes]").attr("readonly","readonly");
			}
		}else{
			if($(this).parent().parent().find("[axes=axes]")){
				$(this).parent().parent().find("[axes=axes]").attr("style","background-color: white;width:100%;");
				$(this).parent().parent().find("[axes=axes]").attr("readonly","");
			}else{
				$(this).parent().parent().parent().find("[axes=axes]").attr("style","background-color: white;width:100%;");
				$(this).parent().parent().parent().find("[axes=axes]").attr("readonly","");
			}
		}
	});
	
	$("[name=salesBasicPo.ssesbpostglassod]").each(function (){
		if(parseFloat($(this).val()) == 0){
			if($(this).parent().parent().find("[axes=axes]")){
				$(this).parent().parent().find("[axes=axes]").val("");
				$(this).parent().parent().find("[axes=axes]").attr("style","background-color: red;width:100%;");
				$(this).parent().parent().find("[axes=axes]").attr("readonly","readonly");
			}else{
				$(this).parent().parent().parent().find("[axes=axes]").val("");
				$(this).parent().parent().parent().find("[axes=axes]").attr("style","background-color: red;width:100%;");
				$(this).parent().parent().parent().find("[axes=axes]").attr("readonly","readonly");
			}
		}else{
			if($(this).parent().parent().find("[axes=axes]")){
				$(this).parent().parent().find("[axes=axes]").attr("style","background-color: white;width:100%;");
				$(this).parent().parent().find("[axes=axes]").attr("readonly","");
			}else{
				$(this).parent().parent().parent().find("[axes=axes]").attr("style","background-color: white;width:100%;");
				$(this).parent().parent().parent().find("[axes=axes]").attr("readonly","");
			}
		}
	});
}
//验证轴向
function checkAxiss(obj) {
	var axis = parseInt(obj.value);
	if (obj.value == null || obj.value == '') {
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
	
	obj.value = parseFloat(obj.value).toFixed(0);
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
		$("[glassType='yuanyong'][noreadonly!=noreadonly]").each(function(){
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
			}else if("salesBasicPo.ssesbdignosisre" == this.name){ //远用VA
				this.value = json.sopipdignosisre;
			}else if("salesBasicPo.ssesbpupilheightod" == this.name){ //瞳高
				this.value = json.sopippupilheightod;
			}else if("salesBasicPo.ssesbpupilheightos" == this.name){ //瞳高
				this.value = json.sopippupilheightos;
			}else if("sopipglassmaterial" == $(this).attr("id")){   // 建议镜片材质
		        $(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '53' && '${fopparamid}' == json.sopipglassmaterial){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>   
				
			}else if("sopipdisposemanner" == $(this).attr("id")){    // 处理方式
				$(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '54' && '${fopparamid}' == json.sopipdisposemanner){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>   
				
			}else if("sopipsuggestframe" == $(this).attr("id")){    // 建议镜框
				$(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '52' && '${fopparamid}' == json.sopipsuggestframe){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>                	              
			}else if("sopipframeheight" == $(this).attr("id")){ 
				$(this).text(json.sopipframeheight);
			}
		});
		$("[glassType='yuanyong'][noreadonly=noreadonly]").each(function(){
			this.readOnly = false;
		});
		
		if($('input[glassType=yuanyong][name=salesBasicPo.ssesbinterdistanceod]').val() == ''){
			$('input[glassType=yuanyong][name=salesBasicPo.ssesbinterdistanceod]').attr("readOnly","");
		}
		
		if($('input[glassType=yuanyong][name=salesBasicPo.ssesbinterdistanceos]').val() == ''){
			$('input[glassType=yuanyong][name=salesBasicPo.ssesbinterdistanceos]').attr("readOnly","");
		}
		
		if($('input[glassType=yuanyong][name=salesBasicPo.ssesbinterhighod]').val() == ''){
			$('input[glassType=yuanyong][name=salesBasicPo.ssesbinterhighod]').attr("readOnly","");
		}
		
		if($('input[glassType=yuanyong][name=salesBasicPo.ssesbinterhighos]').val() == ''){
			$('input[glassType=yuanyong][name=salesBasicPo.ssesbinterhighos]').attr("readOnly","");
		}
	}else if (type == '2'){
		$("[glassType='jinyong'][noreadonly!=noreadonly]").each(function(){
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
			}else if("salesBasicPo.ssesbdignosisre" == this.name){ //远用VA
				this.value = json.sopipdignosisre;
			}else if("salesBasicPo.ssesbpupilheightod" == this.name){ //瞳高
				this.value = json.sopippupilheightod;
			}else if("salesBasicPo.ssesbpupilheightos" == this.name){ //瞳高
				this.value = json.sopippupilheightos;
			}else if("sopipglassmaterial" == $(this).attr("id")){   // 建议镜片材质
		        $(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '53' && '${fopparamid}' == json.sopipglassmaterial){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>   
				
			}else if("sopipdisposemanner" == $(this).attr("id")){    // 处理方式
				$(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '54' && '${fopparamid}' == json.sopipdisposemanner){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>   
				
			}else if("sopipsuggestframe" == $(this).attr("id")){    // 建议镜框
				$(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '52' && '${fopparamid}' == json.sopipsuggestframe){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>       
			}else if("sopipframeheight" == $(this).attr("id")){ 
				$(this).text(json.sopipframeheight);
			}
		});
		
		$("[glassType='jinyong'][noreadonly=noreadonly]").each(function(){
			this.readOnly = false;
		});
		
		if($('input[glassType=jinyong][name=salesBasicPo.ssesbinterdistanceod]').val() == ''){
			$('input[glassType=jinyong][name=salesBasicPo.ssesbinterdistanceod]').attr("readOnly","");
		}
		
		if($('input[glassType=jinyong][name=salesBasicPo.ssesbinterdistanceos]').val() == ''){
			$('input[glassType=jinyong][name=salesBasicPo.ssesbinterdistanceos]').attr("readOnly","");
		}
		
		if($('input[glassType=jinyong][name=salesBasicPo.ssesbinterhighod]').val() == ''){
			$('input[glassType=jinyong][name=salesBasicPo.ssesbinterhighod]').attr("readOnly","");
		}
		
		if($('input[glassType=jinyong][name=salesBasicPo.ssesbinterhighos]').val() == ''){
			$('input[glassType=jinyong][name=salesBasicPo.ssesbinterhighos]').attr("readOnly","");
		}
	}else if (type == '3'){
		$("[glassType='jianjin'][noreadonly!=noreadonly]").each(function(){
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
			}else if("salesBasicPo.ssesbdignosisre" == this.name){ //远用VA
				this.value = json.sopipdignosisre;
			}else if("salesBasicPo.ssesbpupilheightod" == this.name){ //瞳高
				this.value = json.sopippupilheightod;
			}else if("salesBasicPo.ssesbpupilheightos" == this.name){ //瞳高
				this.value = json.sopippupilheightos;
			}else if("sopipglassmaterial" == $(this).attr("id")){   // 建议镜片材质
		        $(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '53' && '${fopparamid}' == json.sopipglassmaterial){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>   
				
			}else if("sopipdisposemanner" == $(this).attr("id")){    // 处理方式
				$(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '54' && '${fopparamid}' == json.sopipdisposemanner){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>   
				
			}else if("sopipsuggestframe" == $(this).attr("id")){    // 建议镜框
				$(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '52' && '${fopparamid}' == json.sopipsuggestframe){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>       
			}else if("sopipframeheight" == $(this).attr("id")){ 
				$(this).text(json.sopipframeheight);
			}
		});
		$("[glassType='jianjin'][noreadonly=noreadonly]").each(function(){
			this.readOnly = false;
		});
		
		if($('input[glassType=jianjin][name=salesBasicPo.ssesbinterdistanceod]').val() == ''){
			$('input[glassType=jianjin][name=salesBasicPo.ssesbinterdistanceod]').attr("readOnly","");
		}
		
		if($('input[glassType=jianjin][name=salesBasicPo.ssesbinterdistanceos]').val() == ''){
			$('input[glassType=jianjin][name=salesBasicPo.ssesbinterdistanceos]').attr("readOnly","");
		}
		
		if($('input[glassType=jianjin][name=salesBasicPo.ssesbinterhighod]').val() == ''){
			$('input[glassType=jianjin][name=salesBasicPo.ssesbinterhighod]').attr("readOnly","");
		}
		
		if($('input[glassType=jianjin][name=salesBasicPo.ssesbinterhighos]').val() == ''){
			$('input[glassType=jianjin][name=salesBasicPo.ssesbinterhighos]').attr("readOnly","");
		}
	}else if (type == '5'){
		$("[glassType='zhongyong'][noreadonly!=noreadonly]").each(function(){
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
			}else if("salesBasicPo.ssesbdignosisre" == this.name){ //远用VA
				this.value = json.sopipdignosisre;
			}else if("salesBasicPo.ssesbpupilheightod" == this.name){ //瞳高
				this.value = json.sopippupilheightod;
			}else if("salesBasicPo.ssesbpupilheightos" == this.name){ //瞳高
				this.value = json.sopippupilheightos;
			}else if("sopipglassmaterial" == $(this).attr("id")){   // 建议镜片材质
		        $(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '53' && '${fopparamid}' == json.sopipglassmaterial){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>   
				
			}else if("sopipdisposemanner" == $(this).attr("id")){    // 处理方式
				$(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '54' && '${fopparamid}' == json.sopipdisposemanner){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>   
				
			}else if("sopipsuggestframe" == $(this).attr("id")){    // 建议镜框
				$(this).text('');
				<s:iterator value="optionParamPolist">
                if ('${fopparentid}' == '52' && '${fopparamid}' == json.sopipsuggestframe){
             	   $(this).text('${fopparamname}');
                }
				</s:iterator>       
			}else if("sopipframeheight" == $(this).attr("id")){ 
				$(this).text(json.sopipframeheight);
			}
		});
		$("[glassType='zhongyong'][noreadonly=noreadonly]").each(function(){
			this.readOnly = false;
		});
		
		if($('input[glassType=zhongyong][name=salesBasicPo.ssesbinterdistanceod]').val() == ''){
			$('input[glassType=zhongyong][name=salesBasicPo.ssesbinterdistanceod]').attr("readOnly","");
		}
		
		if($('input[glassType=zhongyong][name=salesBasicPo.ssesbinterdistanceos]').val() == ''){
			$('input[glassType=zhongyong][name=salesBasicPo.ssesbinterdistanceos]').attr("readOnly","");
		}
		
		if($('input[glassType=zhongyong][name=salesBasicPo.ssesbinterhighod]').val() == ''){
			$('input[glassType=zhongyong][name=salesBasicPo.ssesbinterhighod]').attr("readOnly","");
		}
		
		if($('input[glassType=zhongyong][name=salesBasicPo.ssesbinterhighos]').val() == ''){
			$('input[glassType=zhongyong][name=salesBasicPo.ssesbinterhighos]').attr("readOnly","");
		}
	}else if (type == '4'){
		$("[glassType=yinxing]").each(function(){
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
			}else if("salesBasicPo.ssesbeyecurvatureod1" == this.name){ //右眼曲率1
				this.value = json.sopipeyecurvatureod1;
			}else if("salesBasicPo.ssesbeyecurvatureod2" == this.name){ //右眼曲率2
				this.value = json.sopipeyecurvatureod2;
			}else if("salesBasicPo.ssesbeyecurvatureos1" == this.name){ //左眼曲率1
				this.value = json.sopipeyecurvatureos1;
			}else if("salesBasicPo.ssesbeyecurvatureos2" == this.name){ //左眼曲率2
				this.value = json.sopipeyecurvatureos2;
			}else if("salesBasicPo.ssesbdiameterod" == this.name){ //右眼直径
				this.value = json.sopipdiameterod;
			}else if("salesBasicPo.ssesbdiameteros" == this.name){ //左眼直径
				this.value = json.sopipdiameteros;
			}else if("salesBasicPo.ssesbconlenvaod" == this.name){ //右眼VA
				this.value = json.sopipconlenvaod;
			}else if("salesBasicPo.ssesbconlenvaos" == this.name){ //左眼VA
				this.value = json.sopipconlenvaos;
			}else if("salesBasicPo.ssesbdignosisre" == this.name){ //远用VA
				this.value = json.sopipdignosisre;
			}

			$('input[glassType=yinxing][name=syjp]')[0].value = json.sopipcommendglassesod.trim();  //右眼适用镜片
			$('input[glassType=yinxing][name=syjp]')[1].value = json.sopipcommendglassesos.trim();  //左眼适用镜片
			
			$('input[glassType=yinxing][name=syjpnum]')[0].value=json.sopipconlenodnum;  //右眼适用镜片盒数
			$('input[glassType=yinxing][name=syjpnum]')[1].value=json.sopipconlenosnum;  //左眼适用镜片盒数
			
			$('#jyhly').text(json.sopipcommendcardwater);
		});
	}else if (type == '6'){
		$("[glassType='suxing']").each(function(){
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
			}else if("sopipupkod" == this.name){ //平K
				this.value = json.sopipupkod;
			}else if("sopipupkos" == this.name){ //平K
				this.value = json.sopipupkos;
			}else if("sopipdownkod" == this.name){ //陡K
				this.value = json.sopipdownkod;
			}else if("sopipdownkos" == this.name){ //陡K
				this.value = json.sopipdownkos;
			}else if("sopipeod" == this.name){ //e值
				this.value = json.sopipeod;
			}else if("sopipeos" == this.name){ //e值
				this.value = json.sopipeos;
			}else if("sopipcornealdiameterod" == this.name){ //角膜直径
				this.value = json.sopipcornealdiameterod;
			}else if("sopipcornealdiameteros" == this.name){ //角膜直径
				this.value = json.sopipcornealdiameteros;
			}else if("sopipk0od" == this.name){ //试戴片K
				this.value = json.sopipk0od;
			}else if("sopipk0os" == this.name){ //试戴片K
				this.value = json.sopipk0os;
			}else if("sopipk1od" == this.name){ //K1
				this.value = json.sopipk1od;
			}else if("sopipk1os" == this.name){ //K1
				this.value = json.sopipk1os;
			}else if("sopipk2od" == this.name){ //K2
				this.value = json.sopipk2od;
			}else if("sopipk2os" == this.name){ //K2
				this.value = json.sopipk2os;
			}else if("sopipupcod" == this.name){ //光度
				this.value = json.sopipupcod;
			}else if("sopipupcos" == this.name){ //光度
				this.value = json.sopipupcos;
			}else if("sopipdowncod" == this.name){ //降度
				this.value = json.sopipdowncod;
			}else if("sopipdowncos" == this.name){ //降度
				this.value = json.sopipdowncos;
			}else if("salesBasicPo.ssesbdiameterod" == this.name){ //直径
				this.value = json.sopipdiameterod;
			}else if("salesBasicPo.ssesbdiameteros" == this.name){ //直径
				this.value = json.sopipdiameteros;
			}

			$('input[glassType=suxing][name=syjp]')[0].value = json.sopipcommendglassesod.trim();  //右眼适用镜片
			$('input[glassType=suxing][name=syjp]')[1].value = json.sopipcommendglassesos.trim();  //左眼适用镜片

			$('input[glassType=suxing][name=syjpnum]')[0].value=json.sopipconlenodnum;  //右眼适用镜片盒数
			$('input[glassType=suxing][name=syjpnum]')[1].value=json.sopipconlenosnum;  //左眼适用镜片盒数
		});
		
	}else if (type == '7'){
		$("[glassType='shijuexunlian'][noreadonly!=noreadonly]").each(function(){
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
			}else if("salesBasicPo.ssesbdignosisre" == this.name){ //远用VA
				this.value = json.sopipdignosisre;
			}else if("sopipfamilytrain" == $(this).attr("id")){ //家庭训练
				$(this).text(json.sopipfamilytrain);
			}else if("sopiptrainroom" == $(this).attr("id")){   //训练室训练
				$(this).text(json.sopiptrainroom);
			}

		});
		$("[glassType='shijuexunlian'][noreadonly=noreadonly]").each(function(){
			this.readOnly = false;
		});
		
		if($('input[glassType=shijuexunlian][name=salesBasicPo.ssesbinterdistanceod]').val() == ''){
			$('input[glassType=shijuexunlian][name=salesBasicPo.ssesbinterdistanceod]').attr("readOnly","");
		}
		
		if($('input[glassType=shijuexunlian][name=salesBasicPo.ssesbinterdistanceos]').val() == ''){
			$('input[glassType=shijuexunlian][name=salesBasicPo.ssesbinterdistanceos]').attr("readOnly","");
		}
		
		if($('input[glassType=shijuexunlian][name=salesBasicPo.ssesbinterhighod]').val() == ''){
			$('input[glassType=shijuexunlian][name=salesBasicPo.ssesbinterhighod]').attr("readOnly","");
		}
		
		if($('input[glassType=shijuexunlian][name=salesBasicPo.ssesbinterhighos]').val() == ''){
			$('input[glassType=shijuexunlian][name=salesBasicPo.ssesbinterhighos]').attr("readOnly","");
		}
	}
	
	$("[tonggao='tonggao']").each(function(){//瞳高在销售界面 不论是验光师提交的处方，还是外来手填的处方，都可以修改。
		this.readOnly = false;
	});
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
var goodsIndex = 0;
var trindex=0;
	function addGoods(json){
		if(json.iscustomize=='D'){
			var obj = document.getElementById("showtr");
			obj.style.display = "Block";
			calculateDays(json.bgiordercycle);
			$('#DragsType').show();
			$('#DragsType').attr("disabled","");
			
		}	
		//限制一单一副。
		if(json.glassflag!=undefined&&json.glassflag!=''){
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
		var table = document.getElementById('goodstable');
        goodsIndex = accAdd(goodsIndex,table.rows.length - 1);
        
    	var row = table.insertRow();
    	
    	var c1 = document.createElement("td");
    	var c2 = document.createElement("td");
    	var c3 = document.createElement("td");
    	var c4 = document.createElement("td");
    	var c5 = document.createElement("td");
    	var c6 = document.createElement("td");
    	var c7 = document.createElement("td");
    	
    	if ('${systemParameterPo.fspisshowdiscount3detail}' == '1'){
        	var c8 = document.createElement("td");
        	var c9 = document.createElement("td");
        	var c10 = document.createElement("td");
        	if ('${systemParameterPo.fspremove}' == '1'){
            	var c11 = document.createElement("td");
            	var c12 = document.createElement("td");
            	var c13 = document.createElement("td");
            	var c14 = document.createElement("td");
            }else{
            	var c12 = document.createElement("td");
            	var c13 = document.createElement("td");
            	var c14 = document.createElement("td");	
            }
        }else{
        	var c9 = document.createElement("td");
        	var c10 = document.createElement("td");
        	if ('${systemParameterPo.fspremove}' == '1'){
            	var c11 = document.createElement("td");
            	var c12 = document.createElement("td");
            	var c13 = document.createElement("td");
            	var c14 = document.createElement("td");	
            }else{
            	var c12 = document.createElement("td");
            	var c13 = document.createElement("td");
            	var c14 = document.createElement("td");
            }
        }
   	
    	row.setAttribute("trsl","trsl");
    	row.setAttribute('id','copyrow');		
    	c1.height='26';
    	c1.innerHTML = 
			'<input type="hidden" id="goodssph"/>'+
			'<input type="hidden" id="goodscyl"/>'+
			'<input type="hidden" id="goodssphul"/>'+
			'<input type="hidden" id="goodssphup"/>'+
			'<input type="hidden" id="goodscylul"/>'+
			'<input type="hidden" id="goodscylup"/>'+
			'<input type="hidden" id="goodsclfl"/>'+
			'<input type="hidden" id="goodszsl"/>'+
			'<input type="hidden" id="goodsgndl"/>'+
			'<input type="hidden" id="goodsjjcz"/>'+
			'<input type="hidden" id="goodssylx"/>'+
			'<input type="hidden" id="goodspqlx"/>'+
			'<input type="hidden" id="goodstyjgn"/>'+
			'<input type="hidden" id="goodsgdfl"/>'+
			'<input type="hidden" id="vipcard" name="salesDetailPo.ssesdvipcards"/>'+
       		'<input type="hidden" id="goodslevel" name="salesDetailPo.ssesdgoodslevels"/>'+
		'<div align="center" id="nohavetccheckbox"><input type="checkbox" id="chk" name="chk" goodsid="" rl=""/><input type="hidden" id="maxfavorable" value="0"/></div><div align="center" id="havetccheckbox" style="display: none;">套</div>';
		row.appendChild(c1);
		
		c2.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdsalesitemnames" 	readonly="readonly"   class="text_inputhidden">';
		row.appendChild(c2);
		
		c3.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdsprices"        	readonly="readonly"   class="text_inputhidden yjje">';
		row.appendChild(c3);
		
		c4.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="maxgoodsquantity"  					readonly="readonly"   maxlength="4"    class="text_inputhidden">';
		row.appendChild(c4);
		
		c5.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdnumbers" goodsid="'+json.bgigoodsid+'" rl="'+json.glassflag+'"  maxlength="4"    class="text_inputhidden" onblur="if(checkmaxnumber(this)){isrowamount(this);}else{formaxnumber(this);isrowamount(this);};resetOnePrice1();" onFocus="changeSalesNumber(this);">';
		row.appendChild(c5);
		
		c6.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdpricesums"    	readonly="readonly"   class="text_inputhidden pricesum">';
		row.appendChild(c6);
		
		c7.innerHTML = '<input  style="width: 100%;"  									title=""  onmouseover="salesover(this)" onmouseout="salesout(this)" readonly="readonly" name="salesDetailPo.ssesddiscountrates" readonly="readonly" class="text_inputhidden discountrate salesout" ><input type="hidden" class="rownumber" name="rownumber"/><input type="hidden" id="ssesddiscounttypes" name="salesDetailPo.ssesddiscounttypes" class="text_inputhidden ssesddiscounttypes salesout"/><input type="hidden" id="ssesddiscountsources" name="salesDetailPo.ssesddiscountsources" class="text_inputhidden ssesddiscountsources salesout"/>';
		row.appendChild(c7);
		
		if ('${systemParameterPo.fspisshowdiscount3detail}' == '1'){
			c8.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;color: red;"  title="" id="maxdiscount" name="maxdiscount" readonly="readonly" onfocus="blur()"  class="text_inputhidden"><input type="hidden" name="salesDetailPo.ssesdishavestocks"/>';
	        row.appendChild(c8);
	        
	        c9.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesddiscountnums"   	readonly="readonly"   class="text_inputhidden zksum">';
			row.appendChild(c9);
		
		}else{
			c9.innerHTML = '<input type="hidden" id="maxdiscount" name="maxdiscount" readonly="readonly"><input type="hidden" name="salesDetailPo.ssesdishavestocks"/>'
	                       + '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesddiscountnums"   	readonly="readonly"   class="text_inputhidden zksum">';
	    	row.appendChild(c9);
	    }

		var date = '<input  style="width: 100%;background:transparent;border:0px;"  title="" value="0.00" id="favorable" name="salesDetailPo.ssesdfavorables"   readonly="readonly"   class="text_inputhidden yhsum"><input type="hidden" name="salesDetailPo.ssesdguaranteeperiods"/><input type="hidden" name="salesDetailPo.ssesdbatchs"/>';

        if ('${systemParameterPo.fspremove}' == '1'){
        	c10.innerHTML = date;
            c11.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdrenums"         readonly="readonly"   class="text_inputhidden resum">';
        	row.appendChild(c10);
        	row.appendChild(c11);
        }else{
        	c10.innerHTML = date + '<input type="hidden" style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdrenums"         readonly="readonly"   class="text_inputhidden resum">';
        	row.appendChild(c10);
        }
        
        c12.innerHTML = '<input  style="width: 100%;background:transparent;border:0px;"  title=""  name="salesDetailPo.ssesdsalesvalues" readonly="readonly"   class="text_inputhidden yssum">';
        c13.innerHTML = '<input  style="width: 100%;" title="" onmouseover="salesover(this)" onmouseout="salesout(this)" name="salesDetailPo.ssesdgooddescribes"  class="text_inputhidden salesout"><input type="hidden" name="salesDetailPo.ssesdcostsprives"/><input type="hidden" name="salesDetailPo.ssesdsetmealids"/><input type="hidden" name="salesDetailPo.ssesdsetmealidnos"/><input type="hidden" name="salesDetailPo.ssesditemids"/><input type="hidden" name="salesDetailPo.ssesdunitprices"/><input type="hidden" name="salesDetailPo.iscustomizes"/><input type="hidden" name="salesDetailPo.ssesdcommoditiesflags"/><input type="hidden" name="orderCycle"/>';
        c14.innerHTML = '<div  align="center"><input type="hidden" class="cccc" id="ssesdglassflags" name="salesDetailPo.ssesdglassflags"/><img src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\"删除\" onclick="deleteItem(this);deleteVar1(this);attrdiscountandrenumopen();unClockinspection();"><input  type="hidden" name="salesDetailPo.ssesdsalesitemids" rl="'+json.glassflag+'" maxdiscount=""/><input type="hidden" class="cccc" id="ssesdstockids" name="salesDetailPo.ssesdstockids"/></div>';
		row.appendChild(c12);
		row.appendChild(c13);
		row.appendChild(c14);
		
		var index = $('#copyrow+tr').size();
    	
    	$('input[name=rownumber]')[index].value=index;
    	
    	for(var i = 0; $('#copyrow+tr').size() >= i; i++){
    	  for(var j = 0; i >= j; j++){
    	    $('input[name=rownumber]')[j].value=j;
    	  }
    	}
    	$('input[name=chk]').eq(index).attr("trindex",trindex);
        $('input[name=salesDetailPo\\.ssesdsalesitemids]').get(index).value=json.bgigoodsid;
        $('input[name=salesDetailPo\\.ssesdsalesitemids]').get(index).title=json.bgigoodsid;
        $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(index).attr("trindex",trindex);
        
        $('input[name=salesDetailPo\\.ssesdsalesitemnames]').get(index).value=json.bgigoodsname;
        $('input[name=salesDetailPo\\.ssesdsalesitemnames]').get(index).title=json.bgigoodsname;
        $('input[name=salesDetailPo\\.ssesdsalesitemnames]').eq(index).attr("trindex",trindex);
        
        $('input[name=salesDetailPo\\.ssesdsprices]').get(index).value=json.bgiretailprice;
        $('input[name=salesDetailPo\\.ssesdsprices]').eq(index).attr("trindex",trindex);
        
        $('input[name=salesDetailPo\\.ssesdrenums]').get(index).value="0.00";
        $('input[name=salesDetailPo\\.ssesdrenums]').eq(index).attr("trindex",trindex);
        
        $('input[name=salesDetailPo\\.ssesdnumbers]').get(index).value="1";
        $('input[name=salesDetailPo\\.ssesdnumbers]').eq(index).attr("trindex",trindex);
        if( (json.glassflag=='R' || json.glassflag=='L' || json.glassflag=='') && $("input[name=salestype]:checked").val() == '1'){
        	$('input[name=salesDetailPo\\.ssesdnumbers]').eq(index).attr("readonly","readonly");
	    }
        $('input[name=salesDetailPo\\.ssesdnumbers]').eq(index).attr("maxgoodsquantity",json.maxgoodsquantity);
        
        $('input[name=salesDetailPo\\.ssesdpricesums]').get(index).value=json.bgiretailprice;
        $('input[name=salesDetailPo\\.ssesdpricesums]').eq(index).attr("trindex",trindex);
        
        $('input[name=salesDetailPo\\.ssesdcostsprives]').get(index).value=json.bgicostprice;
        $('input[name=salesDetailPo\\.ssesdcostsprives]').eq(index).attr("trindex",trindex);
        
        $('input[name=salesDetailPo\\.ssesdunitprices]').get(index).value=json.bginottaxrate;
        $('input[name=salesDetailPo\\.ssesdunitprices]').eq(index).attr("trindex",trindex);

        $('input[name=salesDetailPo\\.ssesdstockids]').get(index).value=json.bgiwarehouseid;
        $('input[name=salesDetailPo\\.ssesdstockids]').eq(index).attr("trindex",trindex);
        
        $('input[name=maxgoodsquantity]').get(index).value=json.maxgoodsquantity;
        $('input[name=maxgoodsquantity]').eq(index).attr("trindex",trindex);

        $('input[name=salesDetailPo.ssesdfavorables]').get(index).value='0.00';
        $('input[name=salesDetailPo.ssesdfavorables]').eq(index).attr("trindex",trindex);

		if(json.bgigoodscategoryid == '3'){
			$('input[name=salesDetailPo.ssesdishavestocks]').get(index).value = json.bgiishavestock;
	        $('input[name=salesDetailPo.ssesdishavestocks]').eq(index).attr("trindex",trindex);
		}
		
		if(json.guaranteeperiod){
        	$('input[name=salesDetailPo.ssesdguaranteeperiods]').get(index).value=(json.guaranteeperiod == '无效期' ? '' : json.guaranteeperiod);
		}else{
			$('input[name=salesDetailPo.ssesdguaranteeperiods]').get(index).value='';
		}
        $('input[name=salesDetailPo.ssesdguaranteeperiods]').eq(index).attr("trindex",trindex);

        if(json.batch){
        	$('input[name=salesDetailPo.ssesdbatchs]').get(index).value=(json.batch == '无批号' ? '' : json.batch);
		}else{
			$('input[name=salesDetailPo.ssesdbatchs]').get(index).value='';
		}
        $('input[name=salesDetailPo.ssesdbatchs]').eq(index).attr("trindex",trindex);
 		
        var goodsdiscount;    
        var titlediscounttmp ="1.0";
        
        if (parseFloat(json.bgidefaultdiscount) >= 0){
 	    	titlediscounttmp=json.bgidefaultdiscount;        
	 	}
	 	//alert(parseFloat(json.customerdiscount));
        if (parseFloat(titlediscounttmp) > parseFloat(json.customerdiscount)){
 	    	titlediscounttmp = json.customerdiscount;        
	 	}
	 	
 	    if (parseFloat(titlediscounttmp) < parseFloat(json.maxdiscount)){
 	    	titlediscounttmp=json.maxdiscount;        
	 	} 
    	$('input[name=salesDetailPo\\.ssesddiscountrates]').get(index).value=titlediscounttmp;
    	$('input[name=salesDetailPo\\.ssesddiscountrates]').eq(index).attr("trindex",trindex);
    	goodsdiscount=titlediscounttmp;
        
    	$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(index).attr("maxdiscount",json.maxdiscount);

        var ssje=getSumasd(accMul(goodsdiscount,json.bgiretailprice));
       	var zkje=parseFloat(accSub(json.bgiretailprice,ssje)).toFixed(2);
		$('input[name=salesBasicPo.ssesbdiscountnum]')[0].value=zkje;
        $('input[name=salesDetailPo\\.ssesddiscountnums]').get(index).value=getSumasd(zkje);
        $('input[name=salesDetailPo\\.ssesddiscountnums]').eq(index).attr("trindex",trindex);
        
        $('input[name=salesBasicPo.ssesbsalesvalue]')[0].value=ssje;
        $('input[name=salesDetailPo.ssesdsalesvalues]').get(index).value=ssje;
        $('input[name=salesDetailPo.ssesdsalesvalues]').eq(index).attr("trindex",trindex);

        /*套餐属性区 */
        $('input[id=goodssph]').get(index).value=json.bgisph;
        $('input[id=goodssph]').eq(index).attr("trindex",trindex);
		$('input[id=goodscyl]').get(index).value=json.bgicyl;
        $('input[id=goodscyl]').eq(index).attr("trindex",trindex);
		$('input[id=goodssphul]').get(index).value=json.bgisphul;
        $('input[id=goodssphul]').eq(index).attr("trindex",trindex);
		$('input[id=goodssphup]').get(index).value=json.bgisphup;
        $('input[id=goodssphup]').eq(index).attr("trindex",trindex);
		$('input[id=goodscylul]').get(index).value=json.bgicylul;
        $('input[id=goodscylul]').eq(index).attr("trindex",trindex);
		$('input[id=goodscylup]').get(index).value=json.bgicylup;
        $('input[id=goodscylup]').eq(index).attr("trindex",trindex);
		$('input[id=goodsclfl]').get(index).value=json.bgieyeglassmaterialtype;
        $('input[id=goodsclfl]').eq(index).attr("trindex",trindex);
		$('input[id=goodszsl]').get(index).value=json.bgirefractive;
        $('input[id=goodszsl]').eq(index).attr("trindex",trindex);
		$('input[id=goodsgndl]').get(index).value=json.bgifunctionclass;
        $('input[id=goodsgndl]').eq(index).attr("trindex",trindex);
		$('input[id=goodsjjcz]').get(index).value=json.bgiframematerialtype;
        $('input[id=goodsjjcz]').eq(index).attr("trindex",trindex);  
		$('input[id=goodssylx]').get(index).value=json.bgiusetype;
        $('input[id=goodssylx]').eq(index).attr("trindex",trindex);  
		$('input[id=goodspqlx]').get(index).value=json.bgistealthclass;
        $('input[id=goodspqlx]').eq(index).attr("trindex",trindex); 
		$('input[id=goodstyjgn]').get(index).value=json.bgisungglassesfun;
        $('input[id=goodstyjgn]').eq(index).attr("trindex",trindex); 
		$('input[id=goodsgdfl]').get(index).value=json.bgiismutiluminosity;
        $('input[id=goodsgdfl]').eq(index).attr("trindex",trindex); 
		/*套餐属性区 */
		
		/*商品级别区 */
        $('input[id=goodslevel]').get(index).value=json.bgidefaultdiscountvalue;
        $('input[id=goodslevel]').eq(index).attr("trindex",trindex);
		/*商品级别区*/
        
        if(json.bgigoodscategoryid =='4' && json.glassflag=='R'){
        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="隐形右眼镜片";
        	$('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="4";
        	$('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="R";
        	$('input[name=orderCycle]').get(index).value=json.bgiordercycle;
        }else if(json.bgigoodscategoryid=='4' && json.glassflag=='L'){
        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="隐形左眼镜片";
        	$('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="4";
        	$('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="L";
        	$('input[name=orderCycle]').get(index).value=json.bgiordercycle;
        }else if(json.bgigoodscategoryid=='3' && json.glassflag=='R'){
        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="右眼镜片";
        	$('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="3";
        	$('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="R";
        	$('input[name=orderCycle]').get(index).value=json.bgiordercycle;
        }else if(json.bgigoodscategoryid=='3' && json.glassflag=='L'){
        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="左眼镜片";
        	$('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="3";
        	$('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="L";
        	$('input[name=orderCycle]').get(index).value=json.bgiordercycle;
        }else if(json.bgigoodscategoryid=='1' && json.glassflag==''){
        	 $('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="镜架";
        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="1";
        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="F";
        }else if(json.glassflag=='A'){
        	if(json.bgigoodscategoryid=='6' && category=='太阳镜'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="太阳镜";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="6";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(json.bgigoodscategoryid=='8' && category=='老花镜'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="老花镜";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="8";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(json.bgigoodscategoryid=='9' && category=='视光商品'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="视光商品";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="9";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(json.bgigoodscategoryid=='2' && category=='辅料'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="配件";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="2";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(json.bgigoodscategoryid=='5' && category=='护理液'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="护理液";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="5";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }else if(json.bgigoodscategoryid=='7'){
	        	$('input[name=salesDetailPo\\.ssesdgooddescribes]').get(index).value="耗材";
	        	 $('input[name=salesDetailPo\\.ssesdcommoditiesflags]').get(index).value="7";
	        	 $('input[name=salesDetailPo\\.ssesdglassflags]').get(index).value="";
	        }
	    }
        
        $('input[name=salesDetailPo\\.iscustomizes]').get(index).value=json.iscustomize;
        $('input[name=salesDetailPo\\.iscustomizes]').eq(index).attr("trindex",trindex);     

        $('input[name=salesDetailPo\\.ssesditemids]').get(index).value=json.bgigoodsbarcode;
		
     $('input[name=salesDetailPo\\.ssesditemids]').eq(index).attr("maxgoodsquantity",json.maxgoodsquantity);
     if(json.bgiordercycle!=''){
     	if(json.bgiordercycle>bgiordercycle){
     		bgiordercycle=parseInt(json.bgiordercycle);
     		calculate(bgiordercycle);
     	}
     }else if(bgiordercycle==0&&json.bgiordercycle==''&&json.glassflag!=undefined){
			calculateHours(${departmentsPo.bdptakeglassdate});//成品片取镜时间加小时
     }

    $('input[id=chks]').attr("checked","");
 	$('input[id=chk]').attr("checked","");
 	
    attrdiscountandrenumopen();
    totalamount();
    
    var supplierids="";
    $('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		if($(this).val().substring(2,4)){
			supplierids = supplierids + $(this).val().substring(2,4)+",";
		}
    });    
    showAjaxAdditionalCosts(supplierids);
        
    clockinspection();
    
    $('input[name=maxdiscount]').eq(index).attr("trindex",trindex);
    trindex = accAdd(trindex,1);
	$('input[name=salesDetailPo\\.ssesdsalesitemids][value='+json.bgigoodsid+']').parent().parent().parent().find("#chk").attr("checked","checked");
	setDiscount1(titlediscounttmp,'','','','',json.bgigoodsid,'');
	$('input[name=salesDetailPo\\.ssesdsalesitemids][value='+json.bgigoodsid+']').parent().parent().parent().find("#chk").attr("checked","");
	
	$("#oneprice").val('');
}

/**
* 时间对象的格式化
*/
Date.prototype.format = function(format)
{
	/*
	* format="yyyy-MM-dd hh:mm:ss";
	*/
	var o = {
	"M+" : this.getMonth() + 1,
	"d+" : this.getDate(),
	"h+" : this.getHours(),
	"m+" : this.getMinutes(),
	"s+" : this.getSeconds(),
	"q+" : Math.floor((this.getMonth() + 3) / 3),
	"S" : this.getMilliseconds()
	}
	
	if (/(y+)/.test(format))
	{
	format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
	- RegExp.$1.length));
	}
	
	for (var k in o)
	{
	if (new RegExp("(" + k + ")").test(format))
	{
	format = format.replace(RegExp.$1, RegExp.$1.length == 1
	? o[k]
	: ("00" + o[k]).substr(("" + o[k]).length));
	}
	}
	return format;
}

function calculateDays(days){
	if(days > 0){
	}else{
		alert("该商品未正确设置订制片默认取镜时间！");
		return;
	}
	var d = new Date(Date.parse('${dqqjsj2}')+parseInt(1000*60*60*24*days));
	var vYear = d.getFullYear();
	var vMon = d.getMonth() + 1;
	var vDay = d.getDate();		
	var vHour=d.getHours();		
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

	if ('${systemParameterPo.fspdefgetglassestime}' === '2'){
		$('#ssesbtakeglassdata').val(uValue+' '+vHour+':'+vMin);
    }
    
}

function calculateHours(hours){
	if(hours > 0){
	}else{
		alert("该部门未设置成品片默认取镜时间！");
		return;
	}
	var d = new Date(Date.parse('${dqqjsj2}')+parseInt(1000*60*60*hours));
	var vYear = d.getFullYear();
	var vMon = d.getMonth() + 1;
	var vDay = d.getDate();		
	var vHour=d.getHours();		
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

	if ('${systemParameterPo.fspdefgetglassestime}' === '2'){
	    $('#ssesbtakeglassdata').val(uValue+' '+vHour+':'+vMin);
	}
	
}

/**
 * 页面赠品快捷键添加赠品
 */
function addGiftByShortcut(index){
    var objValue="["+$('#giftShortcut' + index).val()+"]";
    addGifts(objValue);
}

/*
添加赠品
*/
var giftIndex = 0;
function addGifts(jsonparam){
	var jsonparam = eval('(' + jsonparam + ')');
	if (isCustomerExist()){
        return;
	}

	for (var i = 0; i < jsonparam.length; i++){
		json = jsonparam[i];
	    var table = document.getElementById('zptable');
	    giftIndex = accAdd(giftIndex,table.rows.length - 1);
	    
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);

		row.className = 'table_none';
		row.setAttribute("trzp","trzp");
		c1.height='26';
		c1.width = '80%';
		c2.width = '20%';
		
		c1.innerHTML = '<span id="giftsviewname">'+json.bgsviewname+'</span>'+
	                   '<input type="hidden" name="giftsPo.bgsviewname" value="'+json.bgsviewname+'">' + 
	                   '<input type="hidden" name="giftsPo.bgsgoodstype" value="'+json.bgsgoodstype+'">' + 
	                   '<input type="hidden" name="giftsPo.bgsgoodsid" value="'+json.bgsgoodsid+'">' + 
	                   '<input type="hidden" name="giftsPo.bgsgoodsbarcode" value="'+json.bgsgoodsbarcode+'">' + 
	                   '<input type="hidden" name="giftsPo.bgscostprice" value="'+json.bgscostprice+'">' + 
	                   '<input type="hidden" name="giftsPo.bgsnottaxrate" value="'+json.bgsnottaxrate+'">'+
	                   '<input type="hidden" name="giftsPo.bgsstockid" value="'+json.bgiwarehouseid+'">';		
		c2.innerHTML = '<div align="center"><img id="zptable'+giftIndex+'" src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\"删除\" onclick="deleteItem(this);" style="cursor: hand;"/></div>';
	}
}

/*
添加加工要求
*/
var specialIndex = 0;
function addSpecial(){
	if (isCustomerExist()){
		return;
	}
	if($('#specialRequirements')[0].selectedIndex==0){
		alert('请选择加工要求!');
		return;
	}

    var table = document.getElementById('requirementTab');
    specialIndex = accAdd(specialIndex,table.rows.length - 1);
    
	var row = table.insertRow(table.rows.length);
	var c1 = row.insertCell(0);
	var c2 = row.insertCell(1);

	row.className = 'table_none';
	row.setAttribute("trjgyq","trjgyq");		
	c1.height='26';
	c1.width = '75%';
	c2.width = '25%';
	
	c1.innerHTML = '<input name="specialPDetailPo.ssesdrequirement" size="14" value="' + $('#specialRequirements :selected').text() +'">';	
	c2.innerHTML = '<div align="center"><img id="requirementTab'+specialIndex+'" src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\"删除\" onclick="deleteItem(this);deleteVar2(this);" style="cursor: hand;"/></div>';
}	

/*
添加附加费
*/
var fujiafei=0;//附加费全局变量
var fujiafeiIndex = 0;
function addCosts(obj){
	if (isCustomerExist()){
		return;
	}
	if(!$('select[id=additionalCosts]').val()&&!$(obj).val()){
		alert('请选择附加费!');
		return;
	}

	var ishave = "";
	$('input[name=additionalCDetailPo\\.sseadditionalid]').each(function (){
		if($("#additionalCosts").val().trim().split(",")[0] == $(this).val().trim()){
			ishave = '1';
		}
	});
	if(ishave == '1'){
		alert("当前附加费已选择！");
		return;
	}

    var table = document.getElementById('fjftable');
    fujiafeiIndex = accAdd(fujiafeiIndex,table.rows.length - 1);
    
	var row = table.insertRow(table.rows.length);
	var c1 = row.insertCell(0);
	var c2 = row.insertCell(1);
	var c3 = row.insertCell(2);
	var c4 = row.insertCell(3);
	var c5 = row.insertCell(4);

	row.className = 'table_none';
	row.setAttribute("trfjf","trfjf");		
	c1.height='26';
	
	c1.innerHTML = '<span id="costs">' + $('#additionalCosts :selected').text() + '</span><input type="hidden" name="additionalCDetailPo.ssecostsname" value="' + $('#additionalCosts :selected').text() + '"><input type="hidden" name="additionalCDetailPo.sseadditionalid" value="' + $('#additionalCosts').val().split(',')[0] + '">';
	c2.innerHTML = '<span id="costsMoney">' + "￥"+$('#additionalCosts').val().split(',')[1] + '</span><input class="fjfy" type="hidden" name="additionalCDetailPo.sseamount" value="' + $('#additionalCosts').val().split(',')[1] + '">';
	c3.innerHTML = '<input type="text" size="8" class="text_input60 number" id="' + $('#additionalCosts').val().split(',')[0] + '" maxlength="4" name="additionalCDetailPo.ssenumber" onblur="addCosts2(this)" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写附加费数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UINT, \'Message\' : \'附加费数量应为正整数！\'}]" value="1">';
	c4.innerHTML = '<span id="amountMoney">' + "￥"+$('#additionalCosts').val().split(',')[1] + '</span><input class="fjfya" type="hidden" id="amountMoney" name="amountMoney" value="'+$('#additionalCosts').val().split(',')[1]+'">';
	c5.innerHTML = '<div align="center"><img id="fjftable'+fujiafeiIndex+'" src="${ctx }/img/newbtn/delete_0.png" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/delete_0.png\');" btn=btn title=\"删除\" onclick="deleteItem(this);deleteVar2(this);" style="cursor: hand;"/></div>';
	
	fujiafei=accAdd(fujiafei,$('#additionalCosts').val().split(',')[1]);
	
	//showOnePriceNum();
	
	totalamount();
	$("#oneprice").val('');
}
/*
修改附加费数量后对其进行正确性验证
*/
function addCosts2(obj){
	if (isNaN(obj.value)){
		alert("附加费数量格式有误！");
		obj.focus();
		obj.select();
		return;
	}

	if((/^(\+|-)?\d+$/.test( obj.value ))&& obj.value > 0){  
	    $(obj).parent().parent().find('span[id=amountMoney]').text("￥"+accMul($(obj).parent().parent().find('input[name=additionalCDetailPo.sseamount]').val(),parseFloat(obj.value)).toFixed(2));
		$(obj).parent().parent().find('input[id=amountMoney]').val(accMul($(obj).parent().parent().find('input[name=additionalCDetailPo.sseamount]').val(),parseFloat(obj.value)).toFixed(2));
   		var famount = 0;
   		$('input[id=amountMoney]').each(function (){
   			famount = accAdd(famount, $(this).val());
   		});
   		fujiafei = famount;
    }else{
		alert("附加费数量有误！");
		obj.focus();
		obj.select();
    }
    
    //showOnePriceNum();
	totalamount();
	$("#oneprice").val('');
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
function deleteItem(item,flag){	
	var cycle=0;
	$('input[name=orderCycle]').each(function(){
		if($(this).val()!=''){
			if(parseFloat($(this).val())>parseFloat(cycle)){
				cycle=$(this).val();
			}
		}
	});
	if(cycle!=0&&cycle==$(item).parent().parent().parent().find('input[name=orderCycle]').val()){
		var d = new Date(Date.parse('${dqqjsj2}'));
		var vHour=d.getHours();
		var vMin=d.getMinutes();

		if(vHour.toString().length==1){
			vHour='0'+vHour;
		}
		if(vMin<10){
			vMin='0'+vMin;
		}

		if ('${systemParameterPo.fspdefgetglassestime}' === '2'){
			$('#ssesbtakeglassdata').val(PlusDay($('#ssesbtakeglassdata').val(),parseFloat('-'+cycle))+' '+vHour+':'+vMin);
		}
	}
	bgiordercycle=0;

	if (flag == '1'){
		$(item).parent().parent().remove();		
	}else{
		$(item).parent().parent().parent().remove();
	}
	
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

	var supplierids="";
    $('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		if($(this).val().substring(2,4)){
			supplierids = supplierids + $(this).val().substring(2,4)+",";
		}
    });
}

/*
结算
*/
function save(){

	if($('#smecicustomerid').val()==''){
		alert('请先输入会员卡号!');
		return;
	}

	if($("#goodstable tr").length > 1 || $("#fjftable tr").length > 1 || $("#zptable tr").length > 1){
	}else{
		alert("请选择相应商品或费用！");
		return;
	}

	var smecigoodscategoryid = $('#smecigoodscategoryid').val();
	var accessorysalestype = "${systemParameterPo.fspaccessorysalestype }";
	var goodsarray = document.getElementsByName('salesDetailPo.ssesdsalesitemids');	
    var yxcount = 0;
    var hlycount = 0;	
    for (var i = 0; i < goodsarray.length; i++){
		if(smecigoodscategoryid.indexOf(goodsarray[i].value.substring(0,1)) < 0){
			alert("当前会员卡不能购买以下商品:"+goodsarray[i].value);
			return;
		}

		if ($("input[name=salestype]:checked").val() == '5'){
  			if(accessorysalestype.indexOf(goodsarray[i].value.substring(0,1)) < 0){
				alert("辅料销售不能销售以下商品:"+goodsarray[i].value);
				return;
			}
        }

        if ($('#stealthflag').val() == '0'){
            if (goodsarray[i].value.substring(0,1) == '5'){
            	hlycount = '1';
            }
            if (goodsarray[i].value.substring(0,1) == '4'){
            	yxcount = '1';
            }
        }
    }

    if (yxcount == '1' && hlycount == '1'){
        alert('隐形和护理液不能同单销售!');
        return;
    }   

	if($('#ssesbtakeglassdata').val()==''){
		alert('请选择取镜日期!');
		$('#ssesbtakeglassdata').focus();
		return;
	}


	try{
		if($("input[name=salestype]:checked").val() != '5'){
			if($('#recipetype').val()=='1'){
				if($('#yuanyong').find('input[name=salesBasicPo.ssesbballglassod]').val() == ''){
					alert("右眼球镜不能为空！");
					$('#yuanyong').find('input[name=salesBasicPo.ssesbballglassod]').focus();
					return;
				}
				if($('#yuanyong').find('input[name=salesBasicPo.ssesbballglassos]').val() == ''){
					alert("左眼球镜不能为空！");
					$('#yuanyong').find('input[name=salesBasicPo.ssesbballglassos]').focus();
					return;
				}
				if($('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0].value==''){
					$('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0].value='0.00';
				}
				if($('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0].value==''){
					$('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0].value='0.00';
				}
				$('#yuanyong').find('input[tongju=tongju]').each(function(){
					if($(this).val()==''){
						alert('瞳距不能为空!');
						$(this).focus();
						throw '1';
					}
				});
			}
			if($('#recipetype').val()=='2'){
				if($('#jinyong').find('input[name=salesBasicPo.ssesbballglassod]').val() == ''){
					alert("右眼球镜不能为空！");
					$('#jinyong').find('input[name=salesBasicPo.ssesbballglassod]').focus();
					return;
				}
				if($('#jinyong').find('input[name=salesBasicPo.ssesbballglassos]').val() == ''){
					alert("左眼球镜不能为空！");
					$('#jinyong').find('input[name=salesBasicPo.ssesbballglassos]').focus();
					return;
				}
				if($('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value==''){
					$('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value='0.00';
				}
				if($('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value==''){
					$('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value='0.00';
				}
				$('#jinyong').find('input[tongju=tongju]').each(function(){
					if($(this).val()==''){
						alert('瞳距不能为空!');
						$(this).focus();
						throw '1';
					}
				});
			}
			if($('#recipetype').val()=='3'){
				var odytongju = document.getElementById('ssesbinterhighod').value;
				var odjtongju = document.getElementById('ssesbinterdistanceod').value;
				var osytongju = document.getElementById('ssesbinterhighos').value;
				var osjtongju = document.getElementById('ssesbinterdistanceos').value;

				if($('#jianjin').find('input[name=salesBasicPo.ssesbballglassod]').val() == ''){
					alert("右眼球镜不能为空！");
					$('#jianjin').find('input[name=salesBasicPo.ssesbballglassod]').focus();
					return;
				}
				if($('#jianjin').find('input[name=salesBasicPo.ssesbballglassos]').val() == ''){
					alert("左眼球镜不能为空！");
					$('#jianjin').find('input[name=salesBasicPo.ssesbballglassos]').focus();
					return;
				}
				if($('input[glassType="jianjin"][name$="ssesbpostglassod"]')[0].value==''){
					$('input[glassType="jianjin"][name$="ssesbpostglassod"]')[0].value='0.00';
				}
				if($('input[glassType="jianjin"][name$="ssesbpostglassos"]')[0].value==''){
					$('input[glassType="jianjin"][name$="ssesbpostglassos"]')[0].value='0.00';
				}
				if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighod"]')[0].value=='')){
					alert('请填写右眼瞳距!');
					$('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].focus();
					return '';
				}
				if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value!='')&&($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')){
					alert('请填写左眼近用瞳距!');
					$('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].focus();
					return '';
				}
				if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value!='')){
					alert('请填写右眼近用瞳距!');
					$('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].focus();
					return '';
				}
				
				if(($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighos"]')[0].value=='')){
					alert('请填写左眼瞳距!');
					$('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].focus();
					return '';
				}

				if(($('input[glassType=jianjin][name$=ssesbinterhighod]')[0].value!='')&&($('input[glassType=jianjin][name$=ssesbinterhighos]')[0].value=='')){
					alert('请填写左眼远用瞳距!');
					$('input[glassType=jianjin][name$=ssesbinterhighos]')[0].focus();
					return '';
				}

				if(($('input[glassType=jianjin][name$=ssesbinterhighod]')[0].value=='')&&($('input[glassType=jianjin][name$=ssesbinterhighos]')[0].value!='')){
					alert('请填写右眼远用瞳距!');
					$('input[glassType=jianjin][name$=ssesbinterhighod]')[0].focus();
					return '';
				}
			}


			if($('#recipetype').val()=='5'){
				if($('#zhongyong').find('input[name=salesBasicPo.ssesbballglassod]').val() == ''){
					alert("右眼球镜不能为空！");
					$('#zhongyong').find('input[name=salesBasicPo.ssesbballglassod]').focus();
					return;
				}
				if($('#zhongyong').find('input[name=salesBasicPo.ssesbballglassos]').val() == ''){
					alert("左眼球镜不能为空！");
					$('#zhongyong').find('input[name=salesBasicPo.ssesbballglassos]').focus();
					return;
				}
				if($('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0].value==''){
					$('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0].value='';
				}
				if($('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0].value==''){
					$('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0].value='';
				}
				
				$('#zhongyong').find('input[tongju=tongju]').each(function(){
					if($(this).val()==''){
						alert('瞳距不能为空!');
						$(this).focus();
						throw '1';
					}
				});
			}

			if($('#recipetype').val()=='4'){
				if($('#yinxing').find('input[name=salesBasicPo.ssesbballglassod]').val() == ''){
					alert("右眼球镜不能为空！");
					$('#yinxing').find('input[name=salesBasicPo.ssesbballglassod]').focus();
					return;
				}
				if($('#yinxing').find('input[name=salesBasicPo.ssesbballglassos]').val() == ''){
					alert("左眼球镜不能为空！");
					$('#yinxing').find('input[name=salesBasicPo.ssesbballglassos]').focus();
					return;
				}
				if($('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0].value==''){
					$('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0].value='0.00';
				}
				if($('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0].value==''){
					$('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0].value='0.00';
				}
			}

			if($('#recipetype').val()=='6'){
				if($('#suxing').find('input[name=salesBasicPo.ssesbballglassod]').val() == ''){
					alert("右眼球镜不能为空！");
					$('#suxing').find('input[name=salesBasicPo.ssesbballglassod]').focus();
					return;
				}
				if($('#suxing').find('input[name=salesBasicPo.ssesbballglassos]').val() == ''){
					alert("左眼球镜不能为空！");
					$('#suxing').find('input[name=salesBasicPo.ssesbballglassos]').focus();
					return;
				}
				if($('input[glassType="suxing"][name$="ssesbpostglassod"]')[0].value==''){
					$('input[glassType="suxing"][name$="ssesbpostglassod"]')[0].value='0.00';
				}
				if($('input[glassType="suxing"][name$="ssesbpostglassos"]')[0].value==''){
					$('input[glassType="suxing"][name$="ssesbpostglassos"]')[0].value='0.00';
				}
			}
		}
	}catch(e){
		return;
	}

	//判断
	//提交
	var goodsid;

	$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function(){
		if($(this).val().substring(0,1)=='3'){
			goodsid+=$(this).val().substring(0,9);
		}
	});
	
	var glassnum = 0;
	var framenum = 0;
	var tyjnum = 0;
	var lhjnum = 0;
	if($("input[name=salestype]:checked").val() == '1' || $("input[name=salestype]:checked").val() == '2'){
		$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function(){
			if($(this).val().substring(0,1) == '1'){
				framenum = framenum + 1;
			}
			if($(this).val().substring(0,1) == '3'){
				glassnum = glassnum + 1;
			}
			if($(this).val().substring(0,1) == '6'){
				tyjnum = tyjnum + 1;
			}
			if($(this).val().substring(0,1) == '8'){
				lhjnum = lhjnum + 1;
			}
		});	

		if(framenum < 1){
			if (tyjnum == 0 && lhjnum == 0){
				alert("镜架、太阳镜、老花镜数量不足（框镜销售至少包含 镜架*1 镜片*2）！");
				return;
			}
		}
		
		if(glassnum < 2){
			alert("镜片数量不足（框镜销售至少包含 镜架*1 镜片*2）！");
			return;
		}
	}
	
	if(typeof(goodsid) !=  "undefined"){
		if($("input[name=salestype]:checked").val() != '5'){
			var iscustomizestype = '';
			var iscustomizestype2 = '';
			var zziscustomizestype = '';
			$("input[name=salesDetailPo.iscustomizes]").each(function (){
				if($(this).val() == 'D'){
					iscustomizestype = 'D';
				}
				if($(this).val() == '0'){
					iscustomizestype2 = '0';
				}
			});

			$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function(){
				if($(this).val().substring(0,4) == '3.ZZ'){
					zziscustomizestype = '1';
				}
			});	

            if ('${systemParameterPo.fspglassessalescustom}' == '2'){    // 成品片和订制片不能一起销售
				if(iscustomizestype == 'D' && iscustomizestype2 == '0' && zziscustomizestype == ''){
					alert("成品片和订制片不能一起销售,请重新选择镜片商品！");
					return;
				}
            }

			if(iscustomizestype == 'D'){
				if(goodsid.substring(11,13)==goodsid.substring(20,22))
				{}else{
					if(goodsid.substring(11,13)=='ZZ'||goodsid.substring(20,22)=='ZZ')
					{
					}else{
						alert("订制片销售请选择同一制造商的镜片商品！");
						return;
					}
				}
			}
            			
		}
	}
	if($("input[name=salestype]:checked").val() != '5'){
		if($('select[name=optometryPerson]').val() == ''){
			alert("请选择验光师！");
			return;
		}
		
		if($("input[id=ssetmsenddate]").val() == ''){
			alert("请选择验光时间！");
			return;
		}
	}

	<c:if test="${systemParameterPo.fspdjsbm == '1'}">//如果系统设置参数为使用识别码
		<c:if test="${fn:contains(systemParameterPo.fspdjsbmfortype,'1')}">
			if($('#djsbm').val()=='' && $('input[name=salestype]:checked').val()=='1'){//只有框镜才需要输入识别码
				alert('请先绑定单据识别码!');
				$('#djsbm').focus();
				return;
			}
		</c:if>
		<c:if test="${fn:contains(systemParameterPo.fspdjsbmfortype,'2')}">
			if($('#djsbm').val()=='' && $('input[name=salestype]:checked').val()=='3'){//只有隐形才需要输入识别码
				alert('请先绑定单据识别码!');
				$('#djsbm').focus();
				return;
			}
		</c:if>
		<c:if test="${fn:contains(systemParameterPo.fspdjsbmfortype,'3')}">
			if($('#djsbm').val()=='' && $('input[name=salestype]:checked').val()=='5'){//只有辅料才需要输入识别码
				alert('请先绑定单据识别码!');
				$('#djsbm').focus();
				return;
			}
		</c:if>
	</c:if>
	
	if(!confirm("您确认取镜地点为："+$("#ssesblocation option:selected").text()+"吗?")){
		return;
	}
	if(!confirm("您确认提交此销售单吗?")){
		return;
	}
	$('input[name=salesBasicPo\\.ssesbpricesum]')[0].value=$('#yjje').text().replace('￥','');
	$('input[name=salesBasicPo\\.ssesbdiscountnum]')[0].value=$('#zkje').text().replace('￥','');
	$('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value=$('#ysje').text().replace('￥','');
	
	if(accSub($('input[name=salesBasicPo\\.ssesbpsalsvalue]')[0].value,$('#ysje').text().replace('￥',''))!=0){
		$('input[name=salesBasicPo\\.ssesbcheckoutflag]')[0].value="1";
		$('input[name=salesBasicPo\\.ssesbarrearsvalue]')[0].value=accSub($('#ysje').text().replace('￥',''),$('input[name=salesBasicPo\\.ssesbpsalsvalue]')[0].value);
	}else{
		$('input[name=salesBasicPo\\.ssesbcheckoutflag]')[0].value="0";
		$('input[name=salesBasicPo\\.ssesbarrearsvalue]')[0].value="0.00";
	}
	
	if(parseFloat($('input[name=salesBasicPo\\.ssesbpsalsvalue]')[0].value) < 0){
		alert("应收金额不得小于0！");
		return;
	}

	//-------销售备注中如果出现单引号，委外订单无法显示，替换半角单引号为全角单引号
	var str=$('#ssesbsalesremark').val(); 
	str=str.replace(/\'/g,"’");//替换半角单引号为全角单引号
	$('#ssesbsalesremark').val(str); 
	//-------销售备注中如果出现单引号，委外订单无法显示，替换半角单引号为全角单引号

	
	// 计算保价金额
	if('${systemParameterPo.fspisbaojiaflag}' == '2'){
		if (accSub($('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value,'3000') >= 0 ){
	        $('#ssetmissupport').val('1');
	        $('#ssetmsupportvalue').val(accDiv($('input[name=salesBasicPo\\.ssesbsalesvalue]')[0].value,2));
		}
	}
	
	if(checkForm(document.all.frameSalesForm)){ 
		$('#ssesbsetmealtitle').val($('#setmealtitle').text());
		var recipetype = $('#recipetype').val();
		$("img").removeAttr("onclick");
		gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
		frameSalesForm.action="insertShopSalesMain.action?recipetype="+recipetype;
		frameSalesForm.submit();
	}
}

/*
删除商品行时清除一单一副所用的全局变量,重新计算
*/
function deleteVar1(item){
	var param=$(item).parent().find("input.cccc").get(0).value;
	if($(item).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val()){
		$("input[name=salesDetailPo.ssesdfavorables]").each(function (){
			$(this).val('0.00');
		});
		$("input[id=chk]").attr("disabled","");
		$("input[name=salesDetailPo.ssesdcommoditiesflags]").each(function (){
			if($(this).val() != '1' && $(this).val() != '3' && $("input[name=salestype]:checked").val() != '1'){
				$("input[name=salesDetailPo.ssesdnumbers]").attr("readonly","");
			}
		});
		
		$("td[id=setmealtitle]").text("");
		$("input[id=ssesbsetmealid]").val("");
		$("input[name=salesBasicPo.ssesbisgiveyouintegral]").val("1");
		$("[id=molingdiv]").show();
		$("#nohavetc").show();
		$("#havetc").hide();
		$("div[id=nohavetccheckbox]").show();
		$("div[id=havetccheckbox]").hide();
	}
	
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

	if($("input[name=salesDetailPo.ssesddiscountrates]").length > 1){
	}else{
		$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function(){
			if($(this).val()){
				getAjaxCustomerDiscount($(this).val(), $(this).parent().parent().find("#maxdiscount").val());
			}
		});
	}
	
	//一口价添加
 	var oneprice = $("#oneprice").val();
	var pricesum = $("input[name=salesBasicPo.ssesbpricesum]").val();
	if(oneprice != pricesum){
		$("input[id=td10t]").val("0.00");
		$("input[name=salesDetailPo.ssesdrenums]").val("0.00");
		$('input[name=salesDetailPo.ssesdfavorables]').val("0.00");
	}
	
	totalamount();
	//showOnePriceNum();
	$("#oneprice").val('');
}

/*
删除附加费重新计算
*/
function deleteVar2(item){
	//showOnePriceNum();
	totalamount();
	$("#oneprice").val('');
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

	var goodsid;

	$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function(){
		goodsid+=$(this).val().substring(0,9);
	})
	if(goodsid ==  "undefined"){
		alert("请选择商品！");
		return;
	}

	var checkcount = 0;
	$("input[id=chk]").each(function (){
		if($(this).attr("checked")){
			checkcount = checkcount + 1;
		}
	});

	if($("input[id=chks]").attr("checked")){
		if(checkcount == 0){
			alert("请选择商品！");
			return;
		}
	}else{
		if(checkcount == 0){
			alert("请选择商品！");
			return;
		}
	}
	if('${systemParameterPo.fspisusegoodslevel}' == '1'){
		var isdiscount = "";
		var firstcheckstr = "";
		$("input[id=chk]:checked").each(function (){
			if($(this).parent().parent().find("#goodslevel").val()){
				if(firstcheckstr == ""){
					firstcheckstr = $(this).parent().parent().find("#goodslevel").val();
				}
				
				if($(this).parent().parent().find("#goodslevel").val() != firstcheckstr && $(this).parent().parent().find("#goodslevel").val() != "" && firstcheckstr != ""){
					isdiscount = '1';
				}
			}
		});
		
		if(isdiscount == '1'){
			alert("请选择同一级别的商品进行打折！");
			return;
		}
	}
	
	if('${systemParameterPo.fspdefaultdiscounttype}' == '3' && '${sysyg}' != ''){
		if(is_iPad()){
			showPopWin("initPersonDiscountSelect.action?firstcheckstr="+firstcheckstr,600,400,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPersonDiscountSelect.action?firstcheckstr="+firstcheckstr,600,400,topRows,topCols,returnRefresh(true),false);
		}
	}else if('${systemParameterPo.fspdefaultdiscounttype}' == '1' && '${sysvip}' != ''){
		if(is_iPad()){
			showPopWin("initPersonDiscountCardSelect.action?firstcheckstr="+firstcheckstr,600,400,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPersonDiscountCardSelect.action?firstcheckstr="+firstcheckstr,600,400,topRows,topCols,returnRefresh(true),false);
		}
	}else if('${systemParameterPo.fspdefaultdiscounttype}' == '2' && '${sysdzm}' != ''){
		if(is_iPad()){
			showPopWin("initSelectDiscountCard.action?firstcheckstr="+firstcheckstr,600,400,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelectDiscountCard.action?firstcheckstr="+firstcheckstr,600,400,topRows,topCols,returnRefresh(true),false);
		}
	}else{
		alert("系统未配置打折方式！");
		return;
	}
	
	document.getElementById('popupTitle').innerHTML="【商品打折】";
}

/*
整单打折开窗回调
*/
function setDiscount1(discount,discounttype,discountperson,ddiscounttype,ddiscountsource,goodsid,firstcheckstr,goodsType){
	if(!discount != '' || discount == 0){
		$('input[name=salesBasicPo\\.ssesbdiscountrate]').val(discount);
	}
	if(discounttype != ''){
		if(parseFloat(discounttype) > parseFloat($('input[name=salesBasicPo\\.ssesbdiscounttype]').val()) || $('input[name=salesBasicPo\\.ssesbdiscounttype]').val() == ''){
			$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);
		}
	}
	if(firstcheckstr != ''){
		$('input[name=salesBasicPo\\.ssesbgoodslevel]').val(firstcheckstr);
	}
	if(discountperson != ''){
		$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);
	}

    if (typeof(goodsType) == "undefined" || goodsType == null){
    	goodsType = "";
    }
	
	for(var i = 0; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
		if(goodsType != "" && goodsType.indexOf($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(0,1)) < 0){
			continue;
		}
		
		if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).parent().parent().parent().find("#chk").attr("checked")){
            if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val() != ''){		
            	if($('input[name=salesDetailPo.ssesdpricesums]').eq(i).attr("taocan") == 'taocan'){
        		    var ssje=getSumasd(accMul(discount,accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val())));
                    var zkje=parseFloat(accSub(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje),$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val())).toFixed(2);
                    $('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(zkje).toFixed(3));
                    $('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
                    $('input[name=salesDetailPo.ssesddiscounttypes]').eq(i).val("3");
        		}else{
		            if(discounttype != '2'){
			            
			            var maxdiscount = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).attr("maxdiscount");
						if(maxdiscount!='' && Number(maxdiscount) > Number(discount)){							
							$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(maxdiscount).toFixed(2));
							var ssje=accMul(maxdiscount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
	       	                var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
							$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(zkje).toFixed(3));
						}else{
							$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
							var ssje=accMul(parseFloat(discount),$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());						
	       	                var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
							$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(zkje).toFixed(3));
						}
						$('input[name=salesDetailPo.ssesddiscounttypes]').eq(i).val("1");

						$('input[name=salesDetailPo.ssesdvipcards]').eq(i).val(ddiscountsource);

						
		            }else{
		            				            
		            	$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
						var ssje=accMul(discount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
	       	            var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
						$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(zkje).toFixed(3));
						$('input[name=salesDetailPo.ssesddiscounttypes]').eq(i).val("2");
			        }
        		}
				$('input[name=salesDetailPo.ssesddiscountsources]').eq(i).val(discountperson);
            }
            if(maxdiscount > 0){
	        	$('input[name=maxdiscount]').eq(i).val(parseFloat(maxdiscount).toFixed(2));
		    }
		}											
	}

	//抹零金额清空
	var obj = document.getElementById("td10t");
	if (obj != null){
		obj.value="0.00";

		if (obj.value>=0){
			
		}else{
			alert("请填写正确金额格式！");
			return false;
		}
    }

	var count = 0;
	$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		count = count + 1;
	});

	if(count > 0){
		$('span[vid=td4t]').text("￥"+parseFloat(obj.value).toFixed(2));
		$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
    	changeSalesValue(obj);
    }

	totalamount();

}

function setDiscountHY(discount,discounttype,discountperson,ddiscounttype,ddiscountsource,goodsid){//2012/2/2 零折
	if(!discount != '' || discount == 0){
		$('input[name=salesBasicPo\\.ssesbdiscountrate]').val(discount);
	}
	if(discounttype != ''){
		$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
	}
	if(discountperson != ''){
		$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折
	}
	//折扣率赋值
	for(var i = 0; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
		if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val() == goodsid){
            if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val() != ''){		
            	if($('input[name=salesDetailPo.ssesdpricesums]').eq(i).attr("taocan") == 'taocan'){
        		    var ssje=getSumasd(accMul(discount,$('input[name=salesDetailPo.ssesdsalesvalues]').eq(i).val()));
                    var zkje=parseFloat(accSub(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje),$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val())).toFixed(2);
                    $('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val("0.000");
                    $('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val("1.00");
        		}else{
		            if(discounttype != '2'){
			            var maxdiscount = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).attr("maxdiscount");
						if(maxdiscount!='' && Number(maxdiscount) > Number(discount)){							
							$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(maxdiscount).toFixed(2));
							var ssje=accMul(maxdiscount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
	       	                var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
							$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(zkje).toFixed(3));
						}else{
							$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
							var ssje=accMul(parseFloat(discount),$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
	       	                var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
							$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(zkje).toFixed(3));
						}
		            }else{
		            	$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
						var ssje=accMul(discount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
	       	            var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
						$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(zkje).toFixed(3));
			        }
        		}
        		rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(i));
            }
            if(maxdiscount > 0){
	        	$('input[name=maxdiscount]').eq(i).val(parseFloat(maxdiscount).toFixed(2));
		    }
		}											
	}
	
	if(ddiscounttype != ''){
		$('input[name=salesDetailPo\\.ssesddiscounttypes]').each(function(){
			$(this).val(ddiscounttype);
		});
	}
	if(ddiscountsource != ''){
		$('input[name=salesDetailPo\\.ssesddiscountsources]').each(function(){
			$(this).val(ddiscountsource);
		});
	}

	//抹零金额清空
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
    }
	totalamount();
}

/*
整单打折开窗回调
*/
function setDiscountAllTC(discount,discounttype,discountperson,ddiscounttype,ddiscountsource){//2012/2/2 零折
	if(discount != ''){
		$('input[name=salesBasicPo\\.ssesbdiscountrate]').val("1.00");
	}
	if(discounttype != ''){
		$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
	}
	if(discountperson != ''){
		$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折
	}
	//折扣率赋值
	for(var i = 0; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
       	$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
		var ssje=accMul(discount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
 	    var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
		$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(getSumasd(zkje));
	}
    									
	if(ddiscounttype != ''){
		$('input[name=salesDetailPo\\.ssesddiscounttypes]').each(function(){
			$(this).val(ddiscounttype);
		});
	}
	if(ddiscountsource != ''){
		$('input[name=salesDetailPo\\.ssesddiscountsources]').each(function(){
			$(this).val(ddiscountsource);
		});
	}

	//抹零金额清空
	var obj = document.getElementById("td10t");
	obj.value="0.00";

	if (obj.value>=0){
		
	}else{
		alert("请填写正确金额格式！");
		return false;
	}
	var count = 0;
	$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		count=count+1;
	});
	if(count>1){
		$('span[vid=td4t]').text("￥"+parseFloat(obj.value).toFixed(2));
		$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
    	changeSalesValue(obj);
    }
	totalamount();
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
	$('#specialRequirements1').load("getAjaxSpecial.action?specialType1="+ specialType1);
}

function showAjaxAdditionalCosts(supplierids) {  
	$('#additionalCosts').load("getAjaxAdditionalCosts.action?supplierids="+ supplierids);
}

/*
单品打折
*/
function discount2(item){
	if($(item).parent().parent().find("#chk").attr("disabled")){
		return;
	}
	
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;

	if('${systemParameterPo.fspdefaultdiscounttype}' == '3' && '${sysyg}' != ''){
		if(is_iPad()){
			showPopWin("initPersonDiscountSelect.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),600,400,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPersonDiscountSelect.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),600,400,topRows,topCols,returnRefresh(true),false);
		}
	}else if('${systemParameterPo.fspdefaultdiscounttype}' == '1' && '${sysvip}' != ''){
		if(is_iPad()){
			showPopWin("initPersonDiscountCardSelect.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),600,400,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPersonDiscountCardSelect.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),600,400,topRows,topCols,returnRefresh(true),false);
		}
	}else if('${systemParameterPo.fspdefaultdiscounttype}' == '2' && '${sysdzm}' != ''){
		if(is_iPad()){
			showPopWin("initSelectDiscountCard.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),600,400,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelectDiscountCard.action?arg0=1&rownumber="+$(item).parent().find(".rownumber").val(),600,400,topRows,topCols,returnRefresh(true),false);
		}
	}else{
		alert("系统未配置打折方式！");
		return;
	}
	document.getElementById('popupTitle').innerHTML="【单品打折】";
}

function setDiscount2(discount2,rownumber,discounttype,discountperson,ddiscounttype,ddiscountsource,firstcheckstr){//2012/2/2 零折
	//明细行重新赋值
	/*
		应收金额重新赋值
	*/
	if(discounttype != ''){
		$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
	}
	if(firstcheckstr != ''){
		$('input[name=salesBasicPo\\.ssesbgoodslevel]').val(firstcheckstr);//2012/2/2 零折
	}
	if(discountperson != ''){
		$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折
	}
	//折扣率赋值
	if($('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).attr("taocan") == 'taocan'){
	    var ssje=getSumasd(accMul(discount2,$('input[name=salesDetailPo.ssesdsalesvalues]').eq(rownumber).val()));
        var zkje=parseFloat(accSub(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val(),ssje),$('input[name=salesDetailPo.ssesdfavorables]').eq(rownumber).val())).toFixed(2);
        $('input[name=salesDetailPo.ssesddiscountnums]').eq(rownumber).val(parseFloat(discount2).toFixed(2));
        $('input[name=salesDetailPo.ssesddiscountrates]').eq(rownumber).val(parseFloat(discount2).toFixed(2));
	}else{
		if(discounttype != '2'){
			var maxdiscount = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(rownumber).attr("maxdiscount");
			if(parseFloat(maxdiscount) > parseFloat(discount2)){							
				$('input[name=salesDetailPo.ssesddiscountrates]').eq(rownumber).val(parseFloat(maxdiscount).toFixed(2));
  			    var ssje=getSumasd(accMul(maxdiscount,$('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val()));
	            var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val(),ssje)).toFixed(2);
				$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(discount2).toFixed(2));	
			}else{
				$('input[name=salesDetailPo.ssesddiscountrates]').eq(rownumber).val(parseFloat(discount2).toFixed(2));						
  			    var ssje=getSumasd(accMul(discount2,$('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val()));
	            var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val(),ssje)).toFixed(2);
				$('input[name=salesDetailPo.ssesddiscountnums]').eq(rownumber).val(parseFloat(discount2).toFixed(2));						
			}	
	    }else{
			$('input[name=salesDetailPo.ssesddiscountrates]').eq(rownumber).val(parseFloat(discount2).toFixed(2));						
			var ssje=getSumasd(accMul(discount2,$('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val()));
	        var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val(),ssje)).toFixed(2);						
			$('input[name=salesDetailPo.ssesddiscountnums]').eq(rownumber).val(parseFloat(discount2).toFixed(2));
        }
		if(maxdiscount > 0){
        	$('input[name=maxdiscount]').eq(rownumber).val(parseFloat(maxdiscount).toFixed(2));
	    }
	}
	//rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(rownumber));
	
	var ysje=$('tr[id=copyrow]').find(".yssum")[rownumber].value;
	var yjhj=$('tr[id=copyrow]').find(".pricesum")[rownumber].value;
	
	var aqcount=Math.round(eval(yjhj)*eval(discount2)*100)/100;
	var ysje =parseData(aqcount);
	
	$('tr[id=copyrow]').find(".yssum")[rownumber].value=getSumasd(ysje);
	/*
		折扣率重新赋值
	*/
	/*$('tr[id=copyrow]').find(".discountrate")[rownumber].value=discount2;*/

	if(ddiscounttype != ''){
		$('tr[id=copyrow]').find(".ssesddiscounttypes")[rownumber].value=ddiscounttype;
	}
	if(ddiscountsource != ''){
		$('tr[id=copyrow]').find(".ssesddiscountsources")[rownumber].value=ddiscountsource;
	}
	
	/*
		折扣金额重新赋值
	*/
	//$('tr[id=copyrow]').find(".zksum")[rownumber].value=accAdd(yjhj,'-'+ysje);
	
	/*
		total重新赋值
	*/
	var ysjeTotal=0;
	$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
		ysjeTotal=accAdd(ysjeTotal,$(this).val());
	});
	
	var obj = document.getElementById("td10t");
	obj.value="0.00";

	if (obj.value>=0){
		
	}else{
		alert("请填写正确金额格式！");
		return false;
	}
	var count = 0;
	$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		count=count+1;
	});
	if(count>0){
		$('span[vid=td4t]').text("￥"+parseFloat(obj.value).toFixed(2));
		$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
    	changeSalesValue(obj);
    }
	totalamount();
}


function setDiscountTC(discount2,rownumber,discounttype,discountperson,ddiscounttype,ddiscountsource){//2012/2/2 零折
	//明细行重新赋值
	/*
		应收金额重新赋值
	*/
	if(discounttype != ''){
		$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
	}
	if(discountperson != ''){
		$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折
	}
	//折扣率赋值
	var maxdiscount = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(rownumber).attr("maxdiscount");
	$('input[name=salesDetailPo.ssesddiscountrates]').eq(rownumber).val(parseFloat(discount2).toFixed(2));						
	var ssje=getSumasd(accMul(discount2,$('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val()));
    var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(rownumber).val(),ssje)).toFixed(2);	
    					
	$('input[name=salesDetailPo.ssesddiscountnums]').eq(rownumber).val(getSumasd(zkje));
	if(maxdiscount > 0){
    	$('input[name=maxdiscount]').eq(rownumber).val(parseFloat(maxdiscount).toFixed(2));
    }

	rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(rownumber));
	
	var ysje=$('tr[id=copyrow]').find(".yssum")[rownumber].value;
	var yjhj=$('tr[id=copyrow]').find(".pricesum")[rownumber].value;
	
	var aqcount=Math.round(eval(yjhj)*eval(discount2)*100)/100;
	var ysje =parseData(aqcount);
	
	$('tr[id=copyrow]').find(".yssum")[rownumber].value=getSumasd(ysje);
	/*
		折扣率重新赋值
	*/
	/*$('tr[id=copyrow]').find(".discountrate")[rownumber].value=discount2;*/

	if(ddiscounttype != ''){
		$('tr[id=copyrow]').find(".ssesddiscounttypes")[rownumber].value=ddiscounttype;
	}
	if(ddiscountsource != ''){
		$('tr[id=copyrow]').find(".ssesddiscountsources")[rownumber].value=ddiscountsource;
	}
	
	/*
		折扣金额重新赋值
	*/
	//$('tr[id=copyrow]').find(".zksum")[rownumber].value=accAdd(yjhj,'-'+ysje);
	
	/*
		total重新赋值
	*/
	var ysjeTotal=0;
	$('input[name=salesDetailPo\\.ssesdsalesvalues]').each(function(){
		ysjeTotal=accAdd(ysjeTotal,$(this).val());
	});
	
	var obj = document.getElementById("td10t");
	obj.value="0.00";

	if (obj.value>=0){
		
	}else{
		alert("请填写正确金额格式！");
		return false;
	}
	var count = 0;
	$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		count=count+1;
	});
	if(count>0){
		$('span[vid=td4t]').text("￥"+parseFloat(obj.value).toFixed(2));
		$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
    	changeSalesValue(obj);
    }
	totalamount();
}

//改变抹零金额
function changeMolingAmount(obj){
	if (!isNaN($(obj).val()) && Number($(obj).val()) >=0 && $.trim($(obj).val()) != ''){
		$(obj).val(getSumasd($(obj).val()));
	}else{
		$(obj).val(getSumasd('0.00'));
		$(obj).select();
		$(obj).focus();
		alert("请填写正确金额格式！");
		return false;
	}
	
	if(parseFloat($(obj).val()) > parseFloat('${systemParameterPo.fspremovenumber}')){
		$(obj).val(getSumasd('0.00'));
		$(obj).select();
		$(obj).focus();
		alert("抹零金额超出最大设定金额！");
		return;
    }
	
	$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
    changeSalesValue(obj);
    totalamount();
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
    var yhValues=document.getElementsByName('salesDetailPo.ssesdfavorables'); 
    var jkValues=document.getElementsByName('salesDetailPo.ssesddiscountnums');       
	var yjValues=document.getElementsByName('salesDetailPo.ssesdpricesums');
	var mlValues=document.getElementsByName('salesDetailPo.ssesdrenums');
	
	for (var i = 0; i < accAdd(sSsesdSalesValues.length,'0'); i++){
        mlValues[i].value="0.00";
    }

    for (var i = 0; i < accAdd(sSsesdSalesValues.length,'0'); i++){
	    if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val() != ''){
	        if (parseFloat(Subtr(parseFloat(jkValues[i].value),parseFloat(yjValues[i].value))).toFixed(2) >= parseFloat(obj.value)){
	            count = 1;
	            sSsesdSalesValues[i].value = getSumasd(accSub(accSub(accSub(yjValues[i].value,jkValues[i].value),obj.value),yhValues[i].value));
	            mlValues[i].value=parseFloat(obj.value).toFixed(2);
	            obj.value = '0.00';
	        }else{
	        	sSsesdSalesValues[i].value = '0.00';
	        	mlValues[i].value = parseFloat(Subtr(parseFloat(jkValues[i].value),parseFloat(yjValues[i].value))).toFixed(2);
	        	obj.value = parseFloat(Subtr(Subtr(parseFloat(jkValues[i].value),parseFloat(yjValues[i].value)),parseFloat(obj.value))).toFixed(2);
	        }
	    }
    }
    
}

function getTadayDate(){
	var myDate = new Date(Date.parse('${dqqjsj2}'));
	myDate.getFullYear();    //获取完整的年份(4位,1970-????)
	myDate.getMonth();       //获取当前月份(0-11,0代表1月)
	myDate.getDate();        //获取当前日(1-31)
	myDate.getHours();       //获取当前小时数(0-23)
	myDate.getMinutes();     //获取当前分钟数(0-59)
	
	var dateString='';
	dateString=myDate.getFullYear();

	if((myDate.getMonth()+1)<10){
		dateString=dateString+'-0'+(myDate.getMonth()+1);
	}else{
		dateString=dateString+'-'+(myDate.getMonth()+1);
	}
	
	if(myDate.getDate()<10){
		dateString=dateString+'-0'+myDate.getDate();
	}else{
		dateString=dateString+'-'+myDate.getDate();
	}
	
	if(myDate.getHours()<10){
		dateString=dateString+' 0'+myDate.getHours();
	}else{
		dateString=dateString+' '+myDate.getHours();
	}
	
	if(myDate.getMinutes()<10){
		dateString=dateString+':0'+myDate.getMinutes();
	}else{
		dateString=dateString+':'+myDate.getMinutes();
	}
	
	$('#ssetmsenddate').val(dateString);
}

function isShowwfdiv(obj){
	var nameval = "";
	$("input[name=salesDetailPo.ssesdsalesitemnames]").each(function (){
		nameval = nameval + $(this).val();
	});
	
	if(nameval){
		return;
	}
	
	if($(obj).attr("checked")){
		$("#wfdiv").show();
		$('select[id=optometryPerson]').children().each(function(){
	      if($(this).val() == 'wbygs'){
	      	$(this).attr("selected", true);
	      	$('#optometryPersonID').val($(this).val());
	      }
	    });
	    $("#btnlock").hide();
	    $('select[id=optometryPerson]').attr("disabled","disabled");
	    clearValue();$('#nwtype').val('');
	}else{
	    $('select[id=optometryPerson]').children().each(function(){
	      if($(this).val() == ''){
	      	$(this).attr("selected", true);
	      	$('#optometryPersonID').val($(this).val());
	      }
	    });
	    $("#btnlock").show();
		$("#wfdiv").hide();
		$('select[id=optometryPerson]').attr("disabled","");
		clearValue();$('#nwtype').val('');
	}
	selGlassType($("#recipetype").val());
}

//锁定验光人员下拉
function lockOptometryPerson(){
	$('select[id=optometryPerson]').attr("disabled","disabled");
	$('#btnlock').hide();
}

//选择验光人员下拉
function selectOptometryPerson(name,id){
	var isfine = 0;
	$('select[id=optometryPerson]').children().each(function(){
      if($(this).val() == id){
      	$(this).attr("selected", true);
      	$('#optometryPersonID').val($(this).val());
      	isfine = isfine + 1;
      }
	});
	var options = "";
	if(isfine == 0){
		options = options+ "<option value="+id+">"+name+"</option>"
		$('select[id=optometryPerson]').append(options);
		setTimeout(function() { //此行解决IE6中使用jquery 无法设置selected属性。未指明的错误 
			$('select[id=optometryPerson]').children().each(function(){
				if($(this).val() == id){
					$(this).attr("selected", true);
				}
			});
		}, 1);//此行解决IE6中使用jquery 无法设置selected属性。未指明的错误
	}
}

//非外来处方控制
function wlControl(){
	$("#checkboxwl").attr("checked","");
	$("#wfdiv").hide();
	$("#selectwf").val('');
}

//控制验光下拉锁按钮
function wlLock(){
	if(!$("#checkboxwl").attr("checked")){
		$("#btnlock").show();
	}
	$("#opdate").show();
}

//回车轨迹
function OnKeyDownEnter(obj){
	if(event.keyCode == 13){
		var i = obj.yyorder;
		i=++i;
		$("\"[yyorder="+i+"]\"").focus();
	}
}

//加载销售类型
function showSalesType(obj){
    $('input[name=salestype]').each(function(){
        $(this).removeAttr("checked");
    });
    $(obj).attr("checked","checked");
	
	var tablesize = $("tr[trsl=trsl]").length;
	var salestype_input = $("input[id=salestype_input]").val();
	var isop = 0;

	$("input[name=salesBasicPo.ssesbballglassod]").each(function (){
		if($(this).val() != ''){
			isop = isop +1;
		}
	});

	$("input[name=salesBasicPo.ssesbballglassos]").each(function (){
		if($(this).val() != ''){
			isop = isop +1;
		}
	});

	$("input[name=salesBasicPo.ssesbpostglassod]").each(function (){
		if($(this).val() != ''){
			isop = isop +1;
		}
	});

	$("input[name=salesBasicPo.ssesbpostglassos]").each(function (){
		if($(this).val() != ''){
			isop = isop +1;
		}
	});

	$("input[name=salesBasicPo.ssesbinterhighod]").each(function (){
		if($(this).val() != ''){
			isop = isop +1;
		}
	});

	$("input[name=salesBasicPo.ssesbinterhighos]").each(function (){
		if($(this).val() != ''){
			isop = isop +1;
		}
	});

	$("input[name=salesBasicPo.ssesbpupilheightod]").each(function (){
		if($(this).val() != ''){
			isop = isop +1;
		}
	});

	$("input[name=salesBasicPo.ssesbpupilheightos]").each(function (){
		if($(this).val() != ''){
			isop = isop +1;
		}
	});
	
    if(parseFloat($('input[name=salesBasicPo.ssesbpricesum]').val()) > 0 || tablesize > 1 || isop > 0){
    	if(confirm("更改处方类型会清空其他类型销售信息，是否进行类型切换 ？")){
			if($(obj).val() == '1' || $(obj).val() == '2'){
				$("table[id=kj]").show();
				$("table[id=yx]").hide();
				$("table[id=pj]").hide();
				$("table[id=kjandfl]").hide();
				$("table[id=yxandfl]").hide();
				$("input[id=salestype_input]").val($(obj).val());
				clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();
				$("div[id=divopmessage]").show();
				$("#ourframeorglass").show();
				selGlassType("1");
			}else if($(obj).val() == '3' || $(obj).val() == '4'){
				$("table[id=kj]").hide();
				$("table[id=yx]").show();
				$("table[id=pj]").hide();
				$("table[id=kjandfl]").hide();
				$("table[id=yxandfl]").hide();				
				$("input[id=salestype_input]").val($(obj).val());
				$("div[id=divopmessage]").show();
				$("#ourframeorglass").hide();
				clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();
				selGlassType("4");
			}else if($(obj).val() == '5'){
				$("table[id=kj]").hide();
				$("table[id=yx]").hide();
				$("table[id=pj]").show();
				$("table[id=kjandfl]").hide();
				$("table[id=yxandfl]").hide();	
				$("input[id=salestype_input]").val($(obj).val());
				clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();
				if('${systemParameterPo.fspoldglasssalestype}'!='1'){
					$("div[id=divopmessage]").hide();
				}
				$("#ourframeorglass").hide();
				$("#showtr").attr("style","display: none");
				$('#DragsType').hide();
				selGlassType("2");
			}
			$("td[id=setmealtitle]").text("");
			$("input[id=ssesbsetmealid]").val("");
			$("#nohavetc").show();
			$("#havetc").hide();
    	}else{
    		$("input[name=salestype][value="+salestype_input+"]").attr("checked","checked");
	    }
    }else{
        if($(obj).val() == '1'){
			$("table[id=kj]").show();
			$("table[id=yx]").hide();
			$("table[id=pj]").hide();
			$("table[id=kjandfl]").hide();
			$("table[id=yxandfl]").hide();	
			$("div[id=divopmessage]").show();
			$("#ourframeorglass").show();
			$("input[id=salestype_input]").val($(obj).val());
			clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();clearGoods();
			selGlassType("1");
		}else if($(obj).val() == '3'){
			$("table[id=kj]").hide();
			$("table[id=yx]").show();
			$("table[id=pj]").hide();
			$("table[id=kjandfl]").hide();
			$("table[id=yxandfl]").hide();	
			$("div[id=divopmessage]").show();
			$("#ourframeorglass").hide();
			$("input[id=salestype_input]").val($(obj).val());
			clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();clearGoods();
			selGlassType("4");
		}else if($(obj).val() == '5'){
			$("table[id=kj]").hide();
			$("table[id=yx]").hide();
			$("table[id=pj]").show();
			$("table[id=kjandfl]").hide();
			$("table[id=yxandfl]").hide();	
			if('${systemParameterPo.fspoldglasssalestype}'=='0'){
				$("div[id=divopmessage]").hide();
			}
			$("#ourframeorglass").hide();
			$("input[id=salestype_input]").val($(obj).val());
			clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();clearGoods();
			selGlassType("2");
		}
    }
}

	
/*
*  商品选择开窗
*
*  参数： goodscategory  商品类别
*        direction      左右眼描述
*        materialType   镜片种类
*        accessoryType  配件型        1：镜架辅料      2：隐形辅料
*        oneselfframe   自架                  ZZ：是                  空串：否
*        iscustomize    定制标志       0：成品                 D：定制                         ZZ：自片
*/	
function addSalesGoods(goodscategory,direction, materialType,accessoryType,oneselfframe,iscustomize,flflag){				
	if($('#smecicustomerid').val()==''){
		alert('请先输入会员卡号!');
		return;
	}
		
	//销售类型
	var salestype = $("input[name=salestype]:checked").val(); 
    if (salestype == '5'){
    	var accessorysalestype = "${systemParameterPo.fspaccessorysalestype}";
		if(accessorysalestype.indexOf(goodscategory) < 0){
		    alert("辅料销售不能销售该类型商品!");
			return;
		}
    }

    if ($('#stealthflag').val() == '0'){
    	var goodsarray = document.getElementsByName('salesDetailPo.ssesdsalesitemids');	
        var yxcount = 0;
        var hlycount = 0;	
        for (var i = 0; i < goodsarray.length; i++){
            if (goodsarray[i].value.substring(0,1) == '5'){
            	hlycount = '1';
            }
            if (goodsarray[i].value.substring(0,1) == '4'){
            	yxcount = '1';
            }
        }

        if ((goodscategory == '5' && yxcount == '1') || (goodscategory == '4' && hlycount == '1')){
            alert('隐形和护理液不能同单销售!');
            return;
        } 
    }
		
	var path = "";
	path = getGlassOptometryDate(direction,materialType);
    if(path == ''){
        return;
    }

	$("input[id=inputscanbarcode]").val('');

    path = getGlassOptometryDate("R","");
    path = path+getGlassOptometryDate("L","");
    if (path == ''){
        return;
    }
    
    var isemptyoptometry = "";
    if('${systemParameterPo.fspsalesstealthother}' == '1'){
		$("input[name=salesDetailPo.ssesditemids]").each(function (){
			if($(this).val().substring(0,1) == '4'){
				isemptyoptometry = "1";
			}
		});
	}

	if(isemptyoptometry == '1'){
		path = "";
	}

	if ((goodscategory == '3' || goodscategory == '4') && iscustomize != 'ZZ'){
		if ($('input[name=salestype]:checked').val() == '2' || $('input[name=salestype]:checked').val() == '4'){
		    iscustomize='D';
		}
		if ($('input[name=salestype]:checked').val() == '1' || $('input[name=salestype]:checked').val() == '3' || $('input[name=salestype]:checked').val() == '5'){
		    iscustomize='0';
		}
	}

	var other = '';
	if(flflag == '1'){
		other = '1';
	}

	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2') && (goodscategory=="4" || goodscategory=="5")){
		if(is_iPad()){
			showPopWin("selectSellMirrorFrameBatchNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1&customertype="+'${customerInfoPo.smecicardtype}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectSellMirrorFrameBatchNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1&customertype="+'${customerInfoPo.smecicardtype}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	}else{
		if(is_iPad()){
			showPopWin("selectSellMirrorFrameAllNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1&customertype="+'${customerInfoPo.smecicardtype}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectSellMirrorFrameAllNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1&customertype="+'${customerInfoPo.smecicardtype}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	}
	
	document.getElementById('popupTitle').innerHTML="【商品查询】";
}	



function getGlassOptometryDate(direction, materialType){
	if($('#recipetype').val()=='0'&&$('#recipetype').attr('disabled')==false){		
		alert('请选择处方类型!');
		return '';
	}

	var sph = '';
	var cyl = '';
	var add = '';
	var recipeType = $('#recipetype').val();
	
	if(recipeType == 1){ //远用
		// 翻方子
		if($("#salestype_input").val() != '5'){
			if($('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].focus();
				return '';
			}
			if($('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0].value==''){
				$('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0].value='0.00';
			}else if(parseFloat($('input[glassType="yuanyong"][name$="ssesbpostglassod"]').eq(0).val()) != 0){
				if($('input[glassType="yuanyong"][name$="ssesbaxesod"]')[0].value==''){
					alert("请填写右眼轴向!");
					$('input[glassType="yuanyong"][name$="ssesbaxesod"]')[0].focus();
					return '';
				}
			}
			if($('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0].value==''){
				$('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0].value='0.00';
			}else if(parseFloat($('input[glassType="yuanyong"][name$="ssesbpostglassos"]').eq(0).val()) != 0){
				if($('input[glassType="yuanyong"][name$="ssesbaxesos"]')[0].value==''){
					alert("请填写左眼轴向!");
					$('input[glassType="yuanyong"][name$="ssesbaxesos"]')[0].focus();
					return '';
				}
			}
			if($('input[glassType="yuanyong"][name$="ssesbinterhighod"]')[0].value==''){
				alert('请填写右眼远用瞳距!');
				$('input[glassType="yuanyong"][name$="ssesbinterhighod"]')[0].focus();
				return '';
			}
			if($('input[glassType="yuanyong"][name$="ssesbinterhighos"]')[0].value==''){
				alert('请填写左眼远用瞳距!');
				$('input[glassType="yuanyong"][name$="ssesbinterhighos"]')[0].focus();
				return '';
			}
		}
		if('${systemParameterPo.fspothernegative}'=='1'){
			turnPrescription($('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="yuanyong"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="yuanyong"][name$="ssesbaxesos"]')[0]);
		}
		sph = (direction == 'R') ? 
			$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0] : $('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? 
			$('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0] : $('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0];
	}else if(recipeType == 2){ //近用
		// 翻方子
		if($("#salestype_input").val() != '5'){
			if($('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].focus();
				return '';
			}
			if($('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value==''){
				$('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value='0.00';
			}else if(parseFloat($('input[glassType="jinyong"][name$="ssesbpostglassod"]').eq(0).val()) != 0){
				if($('input[glassType="jinyong"][name$="ssesbaxesod"]')[0].value==''){
					alert("请填写右眼轴向!");
					$('input[glassType="jinyong"][name$="ssesbaxesod"]')[0].focus();
					return '';
				}
			}
			if($('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value==''){
				$('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value='0.00';
			}else if(parseFloat($('input[glassType="jinyong"][name$="ssesbpostglassos"]').eq(0).val()) != 0){
				if($('input[glassType="jinyong"][name$="ssesbaxesos"]')[0].value==''){
					alert("请填写左眼轴向!");
					$('input[glassType="jinyong"][name$="ssesbaxesos"]')[0].focus();
					return '';
				}
			}
			if($('input[glassType="jinyong"][name$="ssesbinterdistanceod"]')[0].value==''){
				alert('请填写右眼近用瞳距!');
				$('input[glassType="jinyong"][name$="ssesbinterdistanceod"]')[0].focus();
				return '';
			}
			if($('input[glassType="jinyong"][name$="ssesbinterdistanceos"]')[0].value==''){
				alert('请填写左眼近用瞳距!');
				$('input[glassType="jinyong"][name$="ssesbinterdistanceos"]')[0].focus();
				return '';
			}
		}
		if('${systemParameterPo.fspothernegative}'=='1'){
			turnPrescription($('input[glassType="jinyong"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="jinyong"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="jinyong"][name$="ssesbaxesos"]')[0]);
		}
		sph = (direction == 'R') ? 
			$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0] : $('input[glassType="jinyong"][name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? 
			$('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0] : $('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0];
		add = (direction == 'R') ? 
			$('input[glassType="jinyong"][name$="ssesbaddod"]')[0] : $('input[glassType="jinyong"][name$="ssesbaddos"]')[0];
		
			
	}else if(recipeType == 3){ //渐进/双光
		if($("#salestype_input").val() != '5'){
			if($('input[glassType="jianjin"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				$('input[glassType="jianjin"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].focus();
				return '';
			}
			if($('input[glassType="jianjin"][name$="ssesbpostglassod"]')[0].value==''){
				$('input[glassType="jianjin"][name$="ssesbpostglassod"]')[0].value='0.00';
			}else if(parseFloat($('input[glassType="jianjin"][name$="ssesbpostglassod"]').eq(0).val()) != 0){
				if($('input[glassType="jianjin"][name$="ssesbaxesod"]')[0].value==''){
					alert("请填写右眼轴向!");
					$('input[glassType="jianjin"][name$="ssesbaxesod"]')[0].focus();
					return '';
				}
			}
			if($('input[glassType="jianjin"][name$="ssesbpostglassos"]')[0].value==''){
				$('input[glassType="jianjin"][name$="ssesbpostglassos"]')[0].value='0.00';
			}else if(parseFloat($('input[glassType="jianjin"][name$="ssesbpostglassos"]').eq(0).val()) != 0){
				if($('input[glassType="jianjin"][name$="ssesbaxesos"]')[0].value==''){
					alert("请填写左眼轴向!");
					$('input[glassType="jianjin"][name$="ssesbaxesos"]')[0].focus();
					return '';
				}
			}
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighod"]')[0].value=='')){
				alert('请填写右眼瞳距!');
				$('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].focus();
				return '';
			}
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value!='')&&($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')){
				alert('请填写左眼近用瞳距!');
				$('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].focus();
				return '';
			}
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value!='')){
				alert('请填写右眼近用瞳距!');
				$('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].focus();
				return '';
			}
			
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighos"]')[0].value=='')){
				alert('请填写左眼瞳距!');
				$('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].focus();
				return '';
			}

			if(($('input[glassType=jianjin][name$=ssesbinterhighod]')[0].value!='')&&($('input[glassType=jianjin][name$=ssesbinterhighos]')[0].value=='')){
				alert('请填写左眼远用瞳距!');
				$('input[glassType=jianjin][name$=ssesbinterhighos]')[0].focus();
				return '';
			}

			if(($('input[glassType=jianjin][name$=ssesbinterhighod]')[0].value=='')&&($('input[glassType=jianjin][name$=ssesbinterhighos]')[0].value!='')){
				alert('请填写右眼远用瞳距!');
				$('input[glassType=jianjin][name$=ssesbinterhighod]')[0].focus();
				return '';
			}
		}
		
		// 翻方子	
		if('${systemParameterPo.fspothernegative}'=='1'){
			turnPrescription($('input[glassType="jianjin"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="jianjin"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="jianjin"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="jianjin"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="jianjin"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="jianjin"][name$="ssesbaxesos"]')[0]);
		}
			
		sph = (direction == 'R') ? 
			$('input[glassType="jianjin"][name$="ssesbballglassod"]')[0] : $('input[glassType="jianjin"][name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? 
			$('input[glassType="jianjin"][name$="ssesbpostglassod"]')[0] : $('input[glassType="jianjin"][name$="ssesbpostglassos"]')[0];
		add = (direction == 'R') ? 
			$('input[glassType="jianjin"][name$="ssesbaddod"]')[0] : $('input[glassType="jianjin"][name$="ssesbaddos"]')[0];
	}else if(recipeType == 5){ //中用
		// 翻方子
		if($("#salestype_input").val() != '5'){
			if($('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				$('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].focus();
				return '';
			}
			if($('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0].value==''){
				$('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0].value='0.00';
			}else if(parseFloat($('input[glassType="zhongyong"][name$="ssesbpostglassod"]').eq(0).val()) != 0){
				if($('input[glassType="zhongyong"][name$="ssesbaxesod"]')[0].value==''){
					alert("请填写右眼轴向!");
					$('input[glassType="zhongyong"][name$="ssesbaxesod"]')[0].focus();
					return '';
				}
			}
			if($('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0].value==''){
				$('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0].value='0.00';
			}else if(parseFloat($('input[glassType="zhongyong"][name$="ssesbpostglassos"]').eq(0).val()) != 0){
				if($('input[glassType="zhongyong"][name$="ssesbaxesos"]')[0].value==''){
					alert("请填写左眼轴向!");
					$('input[glassType="zhongyong"][name$="ssesbaxesos"]')[0].focus();
					return '';
				}
			}
			if($('input[glassType="zhongyong"][name$="ssesbinterhighod"]')[0].value==''){
				alert('请填写右眼远用瞳距!');
				$('input[glassType="zhongyong"][name$="ssesbinterhighod"]')[0].focus();
				return '';
			}
			if($('input[glassType="zhongyong"][name$="ssesbinterhighos"]')[0].value==''){
				alert('请填写左眼远用瞳距!');
				$('input[glassType="zhongyong"][name$="ssesbinterhighos"]')[0].focus();
				return '';
			}
		}
		if('${systemParameterPo.fspothernegative}'=='1'){
			turnPrescription($('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="zhongyong"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="zhongyong"][name$="ssesbaxesos"]')[0]);
		}
		sph = (direction == 'R') ? 
			$('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0] : $('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? 
			$('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0] : $('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0];
	}else if(recipeType == 4){ //远用
		// 翻方子
		if($("#salestype_input").val() != '5'){
			if($('input[glassType="yinxing"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				$('input[glassType="yinxing"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="yinxing"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="yinxing"][name$="ssesbballglassos"]')[0].focus();
				return '';
			}
		}
		if($('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0].value==''){
			$('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0].value='0.00';
		}else if(parseFloat($('input[glassType="yinxing"][name$="ssesbpostglassod"]').eq(0).val()) != 0){
			if($('input[glassType="yinxing"][name$="ssesbaxesod"]')[0].value==''){
				alert("请填写右眼轴向!");
				$('input[glassType="yinxing"][name$="ssesbaxesod"]')[0].focus();
				return '';
			}
		}
		if($('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0].value==''){
			$('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0].value='0.00';
		}else if(parseFloat($('input[glassType="yinxing"][name$="ssesbpostglassos"]').eq(0).val()) != 0){
			if($('input[glassType="yinxing"][name$="ssesbaxesos"]')[0].value==''){
				alert("请填写左眼轴向!");
				$('input[glassType="yinxing"][name$="ssesbaxesos"]')[0].focus();
				return '';
			}
		}
		if('${systemParameterPo.fspothernegative}'=='1'){
			turnPrescription($('input[glassType="yinxing"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="yinxing"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="yinxing"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="yinxing"][name$="ssesbaxesos"]')[0]);
		}
		sph = (direction == 'R') ? 
			$('input[glassType="yinxing"][name$="ssesbballglassod"]')[0] : $('input[glassType="yinxing"][name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? 
			$('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0] : $('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0];
	}else if(recipeType == '6'){ //塑形
		// 翻方子
		if($("#salestype_input").val() != '5'){
			if($('input[glassType="suxing"][name$="ssesbballglassod"]')[0].value==''){
				alert('请填写右眼球镜!');
				$('input[glassType="suxing"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="suxing"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="suxing"][name$="ssesbballglassos"]')[0].focus();
				return '';
			}
		}
		if($('input[glassType="suxing"][name$="ssesbpostglassod"]')[0].value==''){
			$('input[glassType="suxing"][name$="ssesbpostglassod"]')[0].value='0.00';
		}else if(parseFloat($('input[glassType="suxing"][name$="ssesbpostglassod"]').eq(0).val()) != 0){
			if($('input[glassType="suxing"][name$="ssesbaxesod"]')[0].value==''){
				alert("请填写右眼轴向!");
				$('input[glassType="suxing"][name$="ssesbaxesod"]')[0].focus();
				return '';
			}
		}
		if($('input[glassType="suxing"][name$="ssesbpostglassos"]')[0].value==''){
			$('input[glassType="suxing"][name$="ssesbpostglassos"]')[0].value='0.00';
		}else if(parseFloat($('input[glassType="suxing"][name$="ssesbpostglassos"]').eq(0).val()) != 0){
			if($('input[glassType="suxing"][name$="ssesbaxesos"]')[0].value==''){
				alert("请填写左眼轴向!");
				$('input[glassType="suxing"][name$="ssesbaxesos"]')[0].focus();
				return '';
			}
		}
		if('${systemParameterPo.fspothernegative}'=='1'){
			turnPrescription($('input[glassType="suxing"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="suxing"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="suxing"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="suxing"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="suxing"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="suxing"][name$="ssesbaxesos"]')[0]);
		}
		sph = (direction == 'R') ? 
			$('input[glassType="suxing"][name$="ssesbballglassod"]')[0] : $('input[glassType="suxing"][name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? 
			$('input[glassType="suxing"][name$="ssesbpostglassod"]')[0] : $('input[glassType="suxing"][name$="ssesbpostglassos"]')[0];
	}

	return "&sph="+sph.value+"&cyl="+cyl.value+"&add="+ ((add != '') ? add.value : '') +"&glassFlag=" + direction+"&materialType="+materialType+"&recipeType="+recipeType+"&unionsphcyl="+Math.abs(accAdd(sph.value,(cyl.value == '' ? 0 : cyl.value)));
}

/*
*   扫描商品开窗
*/
function scanGoods(obj)
{  
    if (event.keyCode==13){
    	if($('#smecicustomerid').val()==''){
			alert('请先输入会员卡号!');
			return;
		}
		//销售类型
		var temp=$("input[name=salestype]:checked").val();  // 销售类型	
		var mm=obj.value.substring(0,1);
	    if (temp == '5'){
	    	var accessorysalestype = "${systemParameterPo.fspaccessorysalestype}";
			if(accessorysalestype.indexOf(mm) < 0){
			    alert("辅料销售不能销售该类型商品!");
				return;
			}
	    }

	    if ($('#stealthflag').val() == '0'){
	    	var goodsarray = document.getElementsByName('salesDetailPo.ssesdsalesitemids');	
	        var yxcount = 0;
	        var hlycount = 0;	
	        for (var i = 0; i < goodsarray.length; i++){
	            if (goodsarray[i].value.substring(0,1) == '5'){
	            	hlycount = '1';
	            }
	            if (goodsarray[i].value.substring(0,1) == '4'){
	            	yxcount = '1';
	            }
	        }

	        if ((mm == '5' && yxcount == '1') || (mm == '4' && hlycount == '1')){
	            alert('隐形和护理液不能同单销售!');
	            return;
	        } 
	    }
	    
	    var checkaccessories = '${systemParameterPo.fspcheckaccessories }';
		var goodscategory="";
	    var iscustomize="";                
        
        if (mm != '1' && mm != '2' && mm != '3' && mm != '4' && mm != '5' && mm != '6' && mm != '7' && mm != '8' && mm != '9'){
        	alert("请扫描正确的商品条码!");
        	return;
        }
        
        if(temp=='1')
        {
	        if(checkaccessories != '1'){
	        	if(mm=='4')
	        	{
	        		alert("请扫描非隐形商品!");
	        		return;
	        	}else{
	        		if(mm==3){
	        			goodscategory="3";
	        			iscustomize="0";
	        			
		        		if(obj.value.trim().length != '5'){
							alert("镜片商品需要扫描5位品种码!");
							return;
				 	    }
	        		}else{
	        			goodscategory=mm;
                          
		        		if(obj.value.trim().length != '26' && obj.value.trim().length != '5'){
							alert("此类商品需要扫描26位商品条码或5位品种码!");
							return;
				 	    }

		        	}
	        	}
	        }else{
	        	if(mm!='1' && mm!='2' && mm!='3')
	        	{
	        		alert("请扫描镜架、镜片或配件商品!");
	        		return;
	        	}else{
	        		if(mm==1)
	        		{
	        			goodscategory="1";

	        			if(obj.value.trim().length != '26' && obj.value.trim().length != '5'){
							alert("镜架商品需要扫描全部商品条码!");
							return;
				 	    }

	        		}
	        		if(mm==2)
	        		{
	        			goodscategory="2";
	        			if(obj.value.trim().length != '26' && obj.value.trim().length != '5'){
							alert("配件商品需要扫描全部商品条码!");
							return;
				 	    }

	        		}
	        		if(mm==3)
	        		{
	        			goodscategory="3";
	        			iscustomize="0";

		        		if(obj.value.trim().length != '5'){
							alert("镜片商品需要扫描5位品种码!");
							return;
				 	    }
	        		}
	        	}
		    }

	        if(obj.value.substring(1,3)=='ZZ'||obj.value.substring(1,3)=='zz'||obj.value.substring(1,3)=='Zz'||obj.value.substring(1,3)=='zZ'){
				alert("不能扫描自架或自片商品！");
				return;
	        }
        }
        
        if(temp=='3')
        {
        	if(checkaccessories != '1'){
        		if(mm=='3'){
	        		alert("请扫描非镜片商品!");
	        		return;
	        	}else{
	        		if(mm==4){
	        			goodscategory="4";
	        			iscustomize="0";

		        		if(obj.value.trim().length != 5 && obj.value.trim().length != 26){
							alert("隐形商品需要扫描26位商品条码或5位品种码!");
							return;
				 	    }
	        		}else{
	        			goodscategory=mm;
                 
	        			if(obj.value.trim().length != '26' && obj.value.trim().length != '5'){
							alert("此类商品需要扫描26位商品条码或5位品种码!");
							return;
				 	    }
		        	}
	        	}
        	}else{
        		if(mm!='4' && mm!='5' && mm!='2'){
	        		alert("请扫描护理液、隐形或配件商品!");
	        		return;
	        	}else{
	        		if(mm==4)
	        		{
	        			goodscategory="4";
	        			iscustomize="0";

		        		if(obj.value.trim().length != 5 && obj.value.trim().length != 26){
							alert("隐形商品扫描26位商品条码或5位品种码!");
							return;
				 	    }
	        		}
	        		if(mm==5)
	        		{
	        			goodscategory="5";

	        			if(obj.value.trim().length != '26' && obj.value.trim().length != '5'){
							alert("护理液商品扫描26位商品条码或5位品种码!");
							return;
				 	    }
	        		}
	        		if(mm==2)
	        		{
	        			goodscategory="2";

	        			if(obj.value.trim().length != '26' && obj.value.trim().length != '5'){
							alert("配件商品需要扫描26位商品条码或5位品种码!");
							return;
				 	    }
	        		}
	        	}
	        }
        }

        if(temp=='5')
        {
            var msg = '';
    		if(mm==1)
    		{
    			goodscategory="1";
    			msg = "镜架商品需要扫描26位商品条码或5位品种码!";
    		}
    		if(mm==2)
    		{
    			goodscategory="2";
    			msg = "配件商品需要扫描26位商品条码或5位品种码!";
    		}
    		if(mm==3)
    		{
    			goodscategory="3";
    			msg = "镜片商品需要扫描26位商品条码或5位品种码!";
    		}
    		if(mm==4)
    		{
    			goodscategory="4";
    			msg = "隐形商品需要扫描26位商品条码或5位品种码!";
    		}
    		if(mm==5)
    		{
    			goodscategory="5";
    			msg = "护理液商品需要扫描26位商品条码或5位品种码!";
    		}
    		if(mm==6)
    		{
    			goodscategory="6";
    			msg = "太阳镜商品需要扫描26位商品条码或5位品种码!";
    		}

    		if('${systemParameterPo.fspoldglasssalestype}'=='1'){
        		if(mm==8)
        		{
        			goodscategory="8";
        			msg = "老花镜商品需要扫描26位商品条码或5位品种码!";

        			if($('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value==''&&$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value==''){
        				alert('请填写右眼球镜!');
        				return;
        			}
        			
        			if($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value==''&&$('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value==''){
        				alert('请填写左眼球镜!');
        				return;
        			}
        			
        			if(($('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value != $('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value)||($('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value != $('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value)){
        				alert("右眼球镜与左眼球镜不等！");
        				return;
        			}
        			
        			if($('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value==''){
        				$('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value='0.00';
        			}

        			if($('input[glassType="jinyong"][name$="ssesbpostglassod"]')[0].value != 0 || $('input[glassType="yuanyong"][name$="ssesbpostglassod"]')[0].value != 0){
        				alert("右眼柱镜应等于0.00！");
        				return;
        			}
        			
        			if($('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value!=''){
        				$('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value='0.00';
        			}

        			if($('input[glassType="jinyong"][name$="ssesbpostglassos"]')[0].value != 0 || $('input[glassType="yuanyong"][name$="ssesbpostglassos"]')[0].value != 0){
        				alert("左眼柱镜应等于0.00！");
        				return;
        			}
        		}
    		}
    		if(mm==7){
    			goodscategory="7";
    			msg = "耗材商品需要扫描26位商品条码或5位品种码!";
    		}
    		if(mm==9)
    		{
    			goodscategory="9";
    			msg = "视光商品需要扫描26位商品条码或5位品种码!";
    		}
    		
    		if(obj.value.trim().length != '26' && obj.value.trim().length != '5'){
				alert(msg);
				return;
	 	    }
        }
						
		var framesize = 0;
		var odsize = 0;
		var ossize = 0;
		$("input[id=ssesdglassflags]").each(function (){
			if($(this).val() == 'F'){
				framesize = framesize + 1;
			}else if($(this).val() == 'R'){
				odsize = odsize + 1;
			}else if($(this).val() == 'L'){
				ossize = odsize + 1;
			}
		});
		
		var path = "";
		var direction = "";
		if(odsize == 0 && (goodscategory == '3' || goodscategory == '4')){
			direction = "R";
		}else if(ossize == 0 && (goodscategory == '3' || goodscategory == '4')){
			direction = "L";
		}
		
		
		    path = getGlassOptometryDate("R","");
		    if (path == ''){
		        return;
		    }
		    path = path+getGlassOptometryDate("L","");
		    if (path == ''){
		        return;
		    }
		
        if (obj.value.substring(0,1) == '3'){
        	if (obj.value.trim().length != '5'){
                alert("商品条码输入有误!");
                return;
            }
        }else if (obj.value.substring(0,1) == '4'){
        	if (obj.value.trim().length < 5 || obj.value.trim().length > '26'){
                alert("商品条码输入有误!");
                return;
            }
        }else{
        	if (obj.value.trim().length != obj.getAttribute("maxlength") && obj.value.trim().length != '5'){
                alert("商品条码输入有误!");
                return;
            }	
        }

        var isemptyoptometry = "";
        
	    if('${systemParameterPo.fspsalesstealthother}' == '1'){
			$("input[name=salesDetailPo.ssesditemids]").each(function (){
				if($(this).val().substring(0,1) == '4'){
					isemptyoptometry = "1";
				}
			});
		}
		if(isemptyoptometry == '1'){
			path = "";
		}
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2'){
			if(obj.value.substring(0,1) == '4' || obj.value.substring(0,1) == '5'){
				if(is_iPad()){
					showPopWin("scanGoodsSelAllBatchNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("scanGoodsSelAllBatchNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
			}else{
				if(is_iPad()){
					showPopWin("scanGoodsSelAllNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}'+"&ordertype="+temp,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("scanGoodsSelAllNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}'+"&ordertype="+temp,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
			}
		}else{
			if(is_iPad()){
				showPopWin("scanGoodsSelAllNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}'+"&ordertype="+temp,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("scanGoodsSelAllNew.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}'+"&ordertype="+temp,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
		$("#inputscanbarcode").val('');
    }
}

/*
 *   套餐开窗
 */
function querySetMealGoods(){
	if($('#smecicustomerid').val()==''){
		alert('请先输入会员卡号!');
		return;
	}
    if('${customerInfoPo.smeciisfavorable }'=='0'){
		alert('当前会员卡不能参与套餐优惠活动!');
		return;
	}
	
	var count = 0;
	$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		count=count+1;
	});
	if (count < 1){
		alert('请先选取商品!');
		return;          
	}
	
	var hidstr = "";
	
	for(var i = 0; i < $("input[name=salesDetailPo\\.ssesdsalesitemids]").size(); i++){
		if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).parent().parent().parent().find("#chk").attr("checked")){
			hidstr = hidstr + $("input[name=salesDetailPo\\.ssesdsalesitemids]").eq(i).val()+"-"+$("input[name=salesDetailPo.ssesdnumbers]").eq(i).val()+",";
		}
	}
	if(hidstr == ""){
		alert("请选择商品！");
		return;
	}
	hidstr = hidstr.substring(0,hidstr.length-1);
	
	var yjTotal = 0;
	$('input[name=salesDetailPo.ssesdpricesums]').each(function (){
		//if($(this).parent().parent().find("#chk").attr("checked")){
			yjTotal = accAdd(yjTotal,$(this).val());
		//}
	});

	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;		
	if(is_iPad()){
		showPopWin("querySetMealGoodsOpen.action?hid=" + hidstr+"&goodsamount="+yjTotal+"&salestype="+$("input[name=salesBasicPo.ssesborderstype]").val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("querySetMealGoodsOpen.action?hid=" + hidstr+"&goodsamount="+yjTotal+"&salestype="+$("input[name=salesBasicPo.ssesborderstype]").val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}		
	document.getElementById('popupTitle').innerHTML="【套餐查询】";
}

/*
 *   套餐查看
 */
function querySetMeal(){
	
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;		
	if(is_iPad()){
		showPopWin("setMealSalesAllSel.action?setMealClassif="+$("#salestype_input").val()+"&isenabled=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("setMealSalesAllSel.action?setMealClassif="+$("#salestype_input").val()+"&isenabled=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}		
	document.getElementById('popupTitle').innerHTML="【可用套餐查看】";
}

/*
*   套餐开窗赋值
*	id				套餐主键
*	title			套餐标题
*	flag			套餐形式    1.多种优惠  2.单一优惠
*	retailprice		活动单价
*	creditprice		抵扣金额
*	discountrate	折扣率
*	activemoney		活动金额
*	favorableflag	优惠方式   1.原价   2.折扣    3.抵扣   4.限价
*	detailid		套餐具体形式   11.商品满减 12.整单满减   21.商品特价  22.整单特价返现  23.整单特价打折  24.整单特价限价
*	isintegralsum	是否累计积分   1.累计   2.不累计
*	goodsClass      商品级次 1.商品类型 2.制造商 3.品种 4.商品代码 
*/
function tctj(index,goodsinfo){
	$('tr[setsealname=setsealname]').show();
	if(goodsinfo.goodsClass == "1"){
		//alert(goodsinfo.goodsID.toLocaleUpperCase() +"=="+ $('input[name=salesDetailPo.ssesdsalesitemids]').eq(index).val().substring(0,1).toLocaleUpperCase());
		if(goodsinfo.goodsID.toLocaleUpperCase() == $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(index).val().substring(0,1).toLocaleUpperCase()){
			if(goodsinfo.isCustomize.trim() == ""||(goodsinfo.isCustomize.trim() != "" && goodsinfo.isCustomize==$('input[name=salesDetailPo.iscustomizes]').eq(index).val())){
			}else{
				return false;
			}
			//alert("1");
			if(goodsinfo.beginAmount.trim() == "" ||(goodsinfo.beginAmount.trim() != "" && parseFloat(goodsinfo.beginAmount)<=parseFloat($('input[name=salesDetailPo.ssesdsprices]').eq(index).val()))){
			}else{
				return false;
			}
			//alert(goodsinfo.endAmount.trim() +"== 空 ||("+goodsinfo.endAmount.trim()+" != 空 && "+goodsinfo.endAmount+">="+$('input[name=salesDetailPo.ssesdsprices]').eq(index).val());
			if(goodsinfo.endAmount.trim() == "" ||(goodsinfo.endAmount.trim() != "" && parseFloat(goodsinfo.endAmount) >= parseFloat($('input[name=salesDetailPo.ssesdsprices]').eq(index).val()))){
			}else{
				return false;
			}
			//alert("3");
			if(goodsinfo.sphul.trim() == "" ||((goodsinfo.sphul.trim() != "" && parseFloat(goodsinfo.sphul)<=parseFloat($('input[name=goodssphul]').eq(index).val()))||(goodsinfo.sphul.trim() != "" && parseFloat(goodsinfo.sphul)<=parseFloat($('input[name=goodssph]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("4");
			if(goodsinfo.sphup.trim() == "" ||((goodsinfo.sphup.trim() != "" && parseFloat(goodsinfo.sphup)>=parseFloat($('input[name=goodssphup]').eq(index).val()))||(goodsinfo.sphup.trim() != "" && parseFloat(goodsinfo.sphup)>=parseFloat($('input[name=goodssph]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("5");
			if(goodsinfo.cylul.trim() == "" ||((goodsinfo.cylul.trim() != "" && parseFloat(goodsinfo.cylul)<=parseFloat($('input[name=goodscylul]').eq(index).val()))||(goodsinfo.cylul.trim() != "" && parseFloat(goodsinfo.cylul)<=parseFloat($('input[name=goodscyl]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("6");
			if(goodsinfo.cylup.trim() == "" ||((goodsinfo.cylup.trim() != "" && parseFloat(goodsinfo.cylup)>=parseFloat($('input[name=goodscylup]').eq(index).val()))||(goodsinfo.cylup.trim() != "" && parseFloat(goodsinfo.cylup)>=parseFloat($('input[name=goodscyl]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("7");
			if(goodsinfo.clfl.trim() == ""||(goodsinfo.clfl.trim() != "" && goodsinfo.clfl==$('input[name=goodsclfl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("8");
			if(goodsinfo.zsl.trim() == ""||(goodsinfo.zsl.trim() != "" && goodsinfo.zsl==$('input[name=goodszsl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("9");
			if(goodsinfo.gndl.trim() == ""||(goodsinfo.gndl.trim() != "" && goodsinfo.gndl==$('input[name=goodsgndl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("10");
			if(goodsinfo.jjcz.trim() == ""||(goodsinfo.jjcz.trim() != "" && goodsinfo.jjcz==$('input[name=goodsjjcz]').eq(index).val())){
			}else{
				return false;
			}
			//alert("11");
			if(goodsinfo.sylx.trim() == ""||(goodsinfo.sylx.trim() != "" && goodsinfo.sylx==$('input[name=goodssylx]').eq(index).val())){
			}else{
				return false;
			}
			//alert("12");
			if(goodsinfo.pqlx.trim() == ""||(goodsinfo.pqlx.trim() != "" && goodsinfo.pqlx==$('input[name=goodspqlx]').eq(index).val())){
			}else{
				return false;
			}
			//alert("13");
			if(goodsinfo.tyjgn.trim() == ""||(goodsinfo.tyjgn.trim() != "" && goodsinfo.tyjgn==$('input[name=goodstyjgn]').eq(index).val())){
			}else{
				return false;
			}
			//alert("14");
			if(goodsinfo.gdfl.trim() == ""||(goodsinfo.gdfl.trim() != "" && goodsinfo.gdfl==$('input[name=goodsgdfl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("15");
			return true;
		}
	}
	if(goodsinfo.goodsClass == "2"){
		if(goodsinfo.goodsID.toLocaleUpperCase() == $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(index).val().substring(0,4).toLocaleUpperCase()){
			if(goodsinfo.isCustomize.trim() == ""||(goodsinfo.isCustomize.trim() != "" && goodsinfo.isCustomize==$('input[name=salesDetailPo.iscustomizes]').eq(index).val())){
			}else{
				return false;
			}
			//alert("1");
			if(goodsinfo.beginAmount.trim() == "" ||(goodsinfo.beginAmount.trim() != "" && parseFloat(goodsinfo.beginAmount)<=parseFloat($('input[name=salesDetailPo.ssesdsprices]').eq(index).val()))){
			}else{
				return false;
			}
			//alert(goodsinfo.endAmount.trim() +"== 空 ||("+goodsinfo.endAmount.trim()+" != 空 && "+goodsinfo.endAmount+">="+$('input[name=salesDetailPo.ssesdsprices]').eq(index).val());
			if(goodsinfo.endAmount.trim() == "" ||(goodsinfo.endAmount.trim() != "" && parseFloat(goodsinfo.endAmount) >= parseFloat($('input[name=salesDetailPo.ssesdsprices]').eq(index).val()))){
			}else{
				return false;
			}
			//alert("3");
			if(goodsinfo.sphul.trim() == "" ||((goodsinfo.sphul.trim() != "" && parseFloat(goodsinfo.sphul)<=parseFloat($('input[name=goodssphul]').eq(index).val()))||(goodsinfo.sphul.trim() != "" && parseFloat(goodsinfo.sphul)<=parseFloat($('input[name=goodssph]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("4");
			if(goodsinfo.sphup.trim() == "" ||((goodsinfo.sphup.trim() != "" && parseFloat(goodsinfo.sphup)>=parseFloat($('input[name=goodssphup]').eq(index).val()))||(goodsinfo.sphup.trim() != "" && parseFloat(goodsinfo.sphup)>=parseFloat($('input[name=goodssph]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("5");
			if(goodsinfo.cylul.trim() == "" ||((goodsinfo.cylul.trim() != "" && parseFloat(goodsinfo.cylul)<=parseFloat($('input[name=goodscylul]').eq(index).val()))||(goodsinfo.cylul.trim() != "" && parseFloat(goodsinfo.cylul)<=parseFloat($('input[name=goodscyl]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("6");
			if(goodsinfo.cylup.trim() == "" ||((goodsinfo.cylup.trim() != "" && parseFloat(goodsinfo.cylup)>=parseFloat($('input[name=goodscylup]').eq(index).val()))||(goodsinfo.cylup.trim() != "" && parseFloat(goodsinfo.cylup)>=parseFloat($('input[name=goodscyl]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("7");
			if(goodsinfo.clfl.trim() == ""||(goodsinfo.clfl.trim() != "" && goodsinfo.clfl==$('input[name=goodsclfl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("8");
			if(goodsinfo.zsl.trim() == ""||(goodsinfo.zsl.trim() != "" && goodsinfo.zsl==$('input[name=goodszsl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("9");
			if(goodsinfo.gndl.trim() == ""||(goodsinfo.gndl.trim() != "" && goodsinfo.gndl==$('input[name=goodsgndl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("10");
			if(goodsinfo.jjcz.trim() == ""||(goodsinfo.jjcz.trim() != "" && goodsinfo.jjcz==$('input[name=goodsjjcz]').eq(index).val())){
			}else{
				return false;
			}
			//alert("11");
			if(goodsinfo.sylx.trim() == ""||(goodsinfo.sylx.trim() != "" && goodsinfo.sylx==$('input[name=goodssylx]').eq(index).val())){
			}else{
				return false;
			}
			//alert("12");
			if(goodsinfo.pqlx.trim() == ""||(goodsinfo.pqlx.trim() != "" && goodsinfo.pqlx==$('input[name=goodspqlx]').eq(index).val())){
			}else{
				return false;
			}
			//alert("13");
			if(goodsinfo.tyjgn.trim() == ""||(goodsinfo.tyjgn.trim() != "" && goodsinfo.tyjgn==$('input[name=goodstyjgn]').eq(index).val())){
			}else{
				return false;
			}
			//alert("14");
			if(goodsinfo.gdfl.trim() == ""||(goodsinfo.gdfl.trim() != "" && goodsinfo.gdfl==$('input[name=goodsgdfl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("15");
			return true;
		}
	}
	if(goodsinfo.goodsClass == "3"){
		if(goodsinfo.goodsID.toLocaleUpperCase() == $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(index).val().substring(0,7).toLocaleUpperCase()){
			if(goodsinfo.isCustomize.trim() == ""||(goodsinfo.isCustomize.trim() != "" && goodsinfo.isCustomize==$('input[name=salesDetailPo.iscustomizes]').eq(index).val())){
			}else{
				return false;
			}
			//alert("1");
			if(goodsinfo.beginAmount.trim() == "" ||(goodsinfo.beginAmount.trim() != "" && parseFloat(goodsinfo.beginAmount)<=parseFloat($('input[name=salesDetailPo.ssesdsprices]').eq(index).val()))){
			}else{
				return false;
			}
			//alert(goodsinfo.endAmount.trim() +"== 空 ||("+goodsinfo.endAmount.trim()+" != 空 && "+goodsinfo.endAmount+">="+$('input[name=salesDetailPo.ssesdsprices]').eq(index).val());
			if(goodsinfo.endAmount.trim() == "" ||(goodsinfo.endAmount.trim() != "" && parseFloat(goodsinfo.endAmount) >= parseFloat($('input[name=salesDetailPo.ssesdsprices]').eq(index).val()))){
			}else{
				return false;
			}
			//alert("3");
			if(goodsinfo.sphul.trim() == "" ||((goodsinfo.sphul.trim() != "" && parseFloat(goodsinfo.sphul)<=parseFloat($('input[name=goodssphul]').eq(index).val()))||(goodsinfo.sphul.trim() != "" && parseFloat(goodsinfo.sphul)<=parseFloat($('input[name=goodssph]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("4");
			if(goodsinfo.sphup.trim() == "" ||((goodsinfo.sphup.trim() != "" && parseFloat(goodsinfo.sphup)>=parseFloat($('input[name=goodssphup]').eq(index).val()))||(goodsinfo.sphup.trim() != "" && parseFloat(goodsinfo.sphup)>=parseFloat($('input[name=goodssph]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("5");
			if(goodsinfo.cylul.trim() == "" ||((goodsinfo.cylul.trim() != "" && parseFloat(goodsinfo.cylul)<=parseFloat($('input[name=goodscylul]').eq(index).val()))||(goodsinfo.cylul.trim() != "" && parseFloat(goodsinfo.cylul)<=parseFloat($('input[name=goodscyl]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("6");
			if(goodsinfo.cylup.trim() == "" ||((goodsinfo.cylup.trim() != "" && parseFloat(goodsinfo.cylup)>=parseFloat($('input[name=goodscylup]').eq(index).val()))||(goodsinfo.cylup.trim() != "" && parseFloat(goodsinfo.cylup)>=parseFloat($('input[name=goodscyl]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("7");
			if(goodsinfo.clfl.trim() == ""||(goodsinfo.clfl.trim() != "" && goodsinfo.clfl==$('input[name=goodsclfl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("8");
			if(goodsinfo.zsl.trim() == ""||(goodsinfo.zsl.trim() != "" && goodsinfo.zsl==$('input[name=goodszsl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("9");
			if(goodsinfo.gndl.trim() == ""||(goodsinfo.gndl.trim() != "" && goodsinfo.gndl==$('input[name=goodsgndl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("10");
			if(goodsinfo.jjcz.trim() == ""||(goodsinfo.jjcz.trim() != "" && goodsinfo.jjcz==$('input[name=goodsjjcz]').eq(index).val())){
			}else{
				return false;
			}
			//alert("11");
			if(goodsinfo.sylx.trim() == ""||(goodsinfo.sylx.trim() != "" && goodsinfo.sylx==$('input[name=goodssylx]').eq(index).val())){
			}else{
				return false;
			}
			//alert("12");
			if(goodsinfo.pqlx.trim() == ""||(goodsinfo.pqlx.trim() != "" && goodsinfo.pqlx==$('input[name=goodspqlx]').eq(index).val())){
			}else{
				return false;
			}
			//alert("13");
			if(goodsinfo.tyjgn.trim() == ""||(goodsinfo.tyjgn.trim() != "" && goodsinfo.tyjgn==$('input[name=goodstyjgn]').eq(index).val())){
			}else{
				return false;
			}
			//alert("14");
			if(goodsinfo.gdfl.trim() == ""||(goodsinfo.gdfl.trim() != "" && goodsinfo.gdfl==$('input[name=goodsgdfl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("15");
			return true;
		}
	}
	if(goodsinfo.goodsClass == "4"){
		if(goodsinfo.goodsID.toLocaleUpperCase() == $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(index).val().toLocaleUpperCase()){
			if(goodsinfo.isCustomize.trim() == ""||(goodsinfo.isCustomize.trim() != "" && goodsinfo.isCustomize==$('input[name=salesDetailPo.iscustomizes]').eq(index).val())){
			}else{
				return false;
			}
			//alert("1");
			if(goodsinfo.beginAmount.trim() == "" ||(goodsinfo.beginAmount.trim() != "" && parseFloat(goodsinfo.beginAmount)<=parseFloat($('input[name=salesDetailPo.ssesdsprices]').eq(index).val()))){
			}else{
				return false;
			}
			//alert(goodsinfo.endAmount.trim() +"== 空 ||("+goodsinfo.endAmount.trim()+" != 空 && "+goodsinfo.endAmount+">="+$('input[name=salesDetailPo.ssesdsprices]').eq(index).val());
			if(goodsinfo.endAmount.trim() == "" ||(goodsinfo.endAmount.trim() != "" && parseFloat(goodsinfo.endAmount) >= parseFloat($('input[name=salesDetailPo.ssesdsprices]').eq(index).val()))){
			}else{
				return false;
			}
			//alert("3");
			if(goodsinfo.sphul.trim() == "" ||((goodsinfo.sphul.trim() != "" && parseFloat(goodsinfo.sphul)<=parseFloat($('input[name=goodssphul]').eq(index).val()))||(goodsinfo.sphul.trim() != "" && parseFloat(goodsinfo.sphul)<=parseFloat($('input[name=goodssph]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("4");
			if(goodsinfo.sphup.trim() == "" ||((goodsinfo.sphup.trim() != "" && parseFloat(goodsinfo.sphup)>=parseFloat($('input[name=goodssphup]').eq(index).val()))||(goodsinfo.sphup.trim() != "" && parseFloat(goodsinfo.sphup)>=parseFloat($('input[name=goodssph]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("5");
			if(goodsinfo.cylul.trim() == "" ||((goodsinfo.cylul.trim() != "" && parseFloat(goodsinfo.cylul)<=parseFloat($('input[name=goodscylul]').eq(index).val()))||(goodsinfo.cylul.trim() != "" && parseFloat(goodsinfo.cylul)<=parseFloat($('input[name=goodscyl]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("6");
			if(goodsinfo.cylup.trim() == "" ||((goodsinfo.cylup.trim() != "" && parseFloat(goodsinfo.cylup)>=parseFloat($('input[name=goodscylup]').eq(index).val()))||(goodsinfo.cylup.trim() != "" && parseFloat(goodsinfo.cylup)>=parseFloat($('input[name=goodscyl]').eq(index).val())))){
			}else{
				return false;
			}
			//alert("7");
			if(goodsinfo.clfl.trim() == ""||(goodsinfo.clfl.trim() != "" && goodsinfo.clfl==$('input[name=goodsclfl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("8");
			if(goodsinfo.zsl.trim() == ""||(goodsinfo.zsl.trim() != "" && goodsinfo.zsl==$('input[name=goodszsl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("9");
			if(goodsinfo.gndl.trim() == ""||(goodsinfo.gndl.trim() != "" && goodsinfo.gndl==$('input[name=goodsgndl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("10");
			if(goodsinfo.jjcz.trim() == ""||(goodsinfo.jjcz.trim() != "" && goodsinfo.jjcz==$('input[name=goodsjjcz]').eq(index).val())){
			}else{
				return false;
			}
			//alert("11");
			if(goodsinfo.sylx.trim() == ""||(goodsinfo.sylx.trim() != "" && goodsinfo.sylx==$('input[name=goodssylx]').eq(index).val())){
			}else{
				return false;
			}
			//alert("12");
			if(goodsinfo.pqlx.trim() == ""||(goodsinfo.pqlx.trim() != "" && goodsinfo.pqlx==$('input[name=goodspqlx]').eq(index).val())){
			}else{
				return false;
			}
			//alert("13");
			if(goodsinfo.tyjgn.trim() == ""||(goodsinfo.tyjgn.trim() != "" && goodsinfo.tyjgn==$('input[name=goodstyjgn]').eq(index).val())){
			}else{
				return false;
			}
			//alert("14");
			if(goodsinfo.gdfl.trim() == ""||(goodsinfo.gdfl.trim() != "" && goodsinfo.gdfl==$('input[name=goodsgdfl]').eq(index).val())){
			}else{
				return false;
			}
			//alert("15");
			return true;
		}
	}
	return false;
}

function ceshi(){
	alert(tctj("1","1.01.01",1));
}

function openGoodSingleValues(objValue){
    alert("使用套餐后会将套餐商品按原价进行优惠！");
    
	setDiscount1('1.00','','','','');
	//抹零金额清空
	var obj = document.getElementById("td10t");
	obj.value="0.00";
	
	if (obj.value>=0){
	}else{
		alert("请填写正确金额格式！");
		return false;
	}
	var count = 0;
	$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		count=count+1;
	});
	if(count>0){
		$('span[vid=td4t]').text("￥"+parseFloat(obj.value).toFixed(2));
		$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
    	changeSalesValue(obj);
    }
	resetOnePrice1();
	var goodInfos = eval('(' + objValue + ')');
	$("input[name=salesBasicPo.ssesbisgiveyouintegral]").val(goodInfos[0].isintegralsum);
	var yhTotal = 0;
	var forcount = 0;
	var checknumber = 0;
	var bargainTotal = 0;
	$("input[id=chk]").each(function (){
		if($(this).attr("checked")){
			checknumber = checknumber + 1;
		}
	});
	if($("input[id=chks]").attr("checked")){
		checknumber = checknumber - 1;
	}
	var yjTotal = 0;
	$('input[name=salesDetailPo.ssesdpricesums]').each(function (){
		if($(this).parent().parent().find("#chk").attr("checked")){
			yjTotal = accAdd(yjTotal,$(this).val());
		}
	});
	if(!$('#ssesbsetmealid').val()){
		$('#ssesbsetmealid').val(goodInfos[0].id);
	}else{
		$('#ssesbsetmealid').val($('#ssesbsetmealid').val()+","+goodInfos[0].id);
	}
	
	if($('#setmealtitle').text() == ''){
		$('#setmealtitle').text(goodInfos[0].title);
	}else{
		$('#setmealtitle').text($('#setmealtitle').text()+","+goodInfos[0].title);	
	}

	var mealcount = $('input[name=salesBasicPo.ssesbsetmealid]').val().split(",").length;
	var givenumber = 0;
	
	for(var i = 0; i < goodInfos.length; i++){
		var copyrow = "";
		if(goodInfos[i].detailid == '23'){
			for(var j=0;j<$('input[name=salesDetailPo\\.ssesdsalesitemids]').size();j++){
				if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).val() != ''){
					$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(accMul(accAdd(1,-goodInfos[i].discountrate),$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2));
					if(goodInfos[i].isdiscount!='1'){
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
					}
					rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
					$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
					$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
					$('input[name=salesDetailPo.ssesdnumbers]').eq(j).attr("readonly","readonly");
					$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
				}
			}
			
		}else if(goodInfos[i].detailid == '22'){
			var creditPrice = goodInfos[i].creditPrice;
			for(var j=0;j<$('input[name=salesDetailPo\\.ssesdsalesitemids]').size();j++){
				if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
					givenumber = creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val();
					if(creditPrice%$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() == 0 && parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) > creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() && $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() > 1 && givenumber > 0){
						copyrow = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().clone( );
			        	copyrow.find("input").attr("trindex",trindex);
						copyrow.find("input[name=salesDetailPo.ssesdnumbers]").val(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val());
						copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
						copyrow.find("input[name=salesDetailPo.ssesdfavorables]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
						copyrow.find("input[name=salesDetailPo.ssesdsalesvalues]").val("0.00");
						copyrow.find("div[id=nohavetccheckbox]").hide();
						copyrow.find("div[id=havetccheckbox]").show();
						copyrow.find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
						copyrow.find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
						$('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(accAdd($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(),-givenumber));
						rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						creditPrice = 0;
						copyrow.find("input[name=salesDetailPo.ssesdpricesums]").attr("taocan","taocan");
					}else{
						if(creditPrice != '' && creditPrice != null && creditPrice > 0){
							if(parseFloat(creditPrice) > parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ){
								$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2));
								creditPrice = accAdd(creditPrice,-$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val());
							}else{
								$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat(creditPrice).toFixed(2));
								creditPrice = 0;
							}
						}
						rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
					}
					if(goodInfos[i].isdiscount!='1'){
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
					}
					$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
					$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
					$('input[name=salesDetailPo.ssesdnumbers]').eq(j).attr("readonly","readonly");
				}
			}
		}else if(goodInfos[i].detailid == '24'){ 
			var creditPrice = 0;
			if(goodInfos[i].activemoney&&goodInfos[i].favorableflag == '4'){
				creditPrice = accAdd(yjTotal,-goodInfos[i].activemoney);
			}else if(goodInfos[i].creditPrice&&goodInfos[i].creditPrice > 0){
				creditPrice = goodInfos[i].creditPrice;
			}
			for(var j=0;j<$('input[name=salesDetailPo\\.ssesdsalesitemids]').size();j++){
				if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
					givenumber = creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val();
					if(creditPrice%$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() == 0 && parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) > creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() && $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() > 1 && givenumber > 0){
						copyrow = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().clone(true);
			        	copyrow.find("input").attr("trindex",trindex);
						copyrow.find("input[name=salesDetailPo.ssesdnumbers]").val(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val());
						copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
						copyrow.find("input[name=salesDetailPo.ssesdfavorables]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
						copyrow.find("input[name=salesDetailPo.ssesdsalesvalues]").val("0.00");
						copyrow.find("div[id=nohavetccheckbox]").hide();
						copyrow.find("div[id=havetccheckbox]").show();
						copyrow.find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
						copyrow.find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
						$('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(accAdd($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(),-givenumber));
						rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						copyrow.find("input[name=salesDetailPo.ssesdpricesums]").attr("taocan","taocan");
						creditPrice = 0;
					}else{
						if(creditPrice > parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ){
							$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2));
							creditPrice = accAdd(creditPrice,-$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val());
						}else{
							$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat(creditPrice).toFixed(2));
							creditPrice = 0;
						}
						rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
					}
					if(goodInfos[i].isdiscount!='1'){
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
						$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
					}
					$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
					$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
					$('input[name=salesDetailPo.ssesdnumbers]').eq(j).attr("readonly","readonly");
				}
			}
		}else{
			if(goodInfos[i].favorableflag == '1'){
				for(var j=0;j<$('input[name=salesDetailPo\\.ssesdsalesitemids]').size();j++){
					if(tctj(j,goodInfos[i])){
						if(goodInfos[i].isdiscount!='1'){
							$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
							$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
							$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
						}
					}
					$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
					$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
					$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
					$('input[name=salesDetailPo.ssesdnumbers]').eq(j).attr("readonly","readonly");
				}
			}else if(goodInfos[i].favorableflag == '2'){
				for(var j=0;j<$('input[name=salesDetailPo\\.ssesdsalesitemids]').size();j++){
					if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
						if(tctj(j,goodInfos[i])){
							$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat( accMul(accAdd(1,-goodInfos[i].discountrate),$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ).toFixed(2));
							rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
							if(goodInfos[i].isdiscount!='1'){
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
							}
						}
						rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
						$('input[name=salesDetailPo.ssesdnumbers]').eq(j).attr("readonly","readonly");
						$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
					}
				}
			}else if(goodInfos[i].favorableflag == '3'){
				var creditPrice = goodInfos[i].creditPrice;
				for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
					if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
						if(creditPrice != '' && creditPrice != null && creditPrice > 0){
							if(tctj(j,goodInfos[i])){
								givenumber = creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val();
                                if(creditPrice%$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() == 0 && parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) > creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() && $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() > 1 && givenumber > 0){
									copyrow = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().clone(true);
						        	copyrow.find("input").attr("trindex",trindex);
									copyrow.find("input[name=salesDetailPo.ssesdnumbers]").val(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val());
									copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
									copyrow.find("input[name=salesDetailPo.ssesdfavorables]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
									copyrow.find("input[name=salesDetailPo.ssesdsalesvalues]").val("0.00");
									copyrow.find("div[id=nohavetccheckbox]").hide();
									copyrow.find("div[id=havetccheckbox]").show();
									copyrow.find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
									copyrow.find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
									$('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(accAdd($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(),-givenumber));
									rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
									copyrow.find("input[name=salesDetailPo.ssesdpricesums]").attr("taocan","taocan");
									creditPrice = 0;
								}else{
									if( parseFloat(creditPrice) > parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ){
										$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val( parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2) );
										creditPrice = accAdd(creditPrice,-$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val());
									}else{
										$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val( parseFloat(creditPrice).toFixed(2) );
										creditPrice = 0;
									}
								}
							}
						}
						rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
						if(goodInfos[i].isdiscount!='1'){
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
						}
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
						$('input[name=salesDetailPo.ssesdnumbers]').eq(j).attr("readonly","readonly");
					}
				}
			}else if(goodInfos[i].favorableflag == '4'){
				var dyjTotal = 0;
				for(var k=0;k<$('input[name=salesDetailPo.ssesdsalesitemids]').size();k++){
					if(tctj(k,goodInfos[i])){
						if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(k).val() != '' && $("[id=chk]").eq(k).attr("checked")){
							dyjTotal = accAdd(dyjTotal,$("input[name=salesDetailPo.ssesdpricesums]").eq(k).val());
						}
					}
				}
				
				var creditPrice = accAdd(dyjTotal,-goodInfos[i].activemoney);
				for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
					if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $("[id=chk]").eq(j).attr("checked")){
						if(tctj(j,goodInfos[i])){
							givenumber = creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val();
							if(creditPrice%$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() == 0 && parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) > creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() && $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() > 1 && givenumber > 0){
								copyrow = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().clone(true);
					        	copyrow.find("chk").attr("disabled","disabled");
					        	copyrow.find("input").attr("trindex",trindex);
								copyrow.find("input[name=salesDetailPo.ssesdnumbers]").val(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val());
								copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
								copyrow.find("input[name=salesDetailPo.ssesdfavorables]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
								copyrow.find("input[name=salesDetailPo.ssesdsalesvalues]").val("0.00");
								if(goodInfos[i].isdiscount!='1'){
									copyrow.find("div[id=nohavetccheckbox]").hide();
									copyrow.find("div[id=havetccheckbox]").show();
									copyrow.find("input[name=salesDetailPo.ssesdpricesums]").attr("taocan","taocan");
									copyrow.find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
									copyrow.find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
								}else{
									copyrow.find("input[name=salesDetailPo.ssesdpricesums]").attr("taocan","taocan");
								}
								
								$('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(accAdd($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(),-givenumber));
								creditPrice = 0;
								rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
							}else{
								if(creditPrice > parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ){
									$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2));
									creditPrice = accAdd(creditPrice,-$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val());
								}else{
									$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat(creditPrice).toFixed(2));
									creditPrice = 0;
								}
								rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
								$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
							}
							
							if(goodInfos[i].isdiscount!='1'){
								$("div[id=nohavetccheckbox]").eq(j).hide();
								$("div[id=havetccheckbox]").eq(j).show();
								$("[id=chk]").eq(j).attr("disabled","disabled");
							}
							$("input[name=salesDetailPo.ssesdsetmealids]").eq(j).val(goodInfos[i].id);
							$("input[name=salesDetailPo.ssesdsetmealidnos]").eq(j).val(mealcount);
							$('input[name=salesDetailPo.ssesdnumbers]').eq(j).attr("readonly","readonly");
						}
					}
				}
				
			}
		}
		
		if(copyrow){
			copyrow.find("input[name=salesDetailPo.ssesdnumbers]").attr("readonly","readonly");
			copyrow.appendTo($("#goodstable")); 
			trindex = accAdd(trindex,1);
		}
	}
	
	$('input[id=chks]').attr("checked","");
 	$('input[id=chk]').attr("checked","");
    totalamount();
    attrdiscountandrenumclose();
	$("[id=molingdiv]").hide();
}

function getSumasd(mm){		
	var nn="";
	if('${systemParameterPo.fspsalescounttype}' == '1'){
		if('${retain}'=='1')
		{
			nn=parseFloat(mm).toFixed(0)+'.00';
		}
		if('${retain}'=='2')
		{				
			nn=parseFloat(mm).toFixed(1)+'0';
		}
		if('${retain}'=='3')
		{				
			nn=parseFloat(mm).toFixed(2);
		}
	}else{
		if('${retain}'=='1')
		{
			if (accSub(Number(mm),Number(Math.floor(mm))) >= 1 ){
				nn=parseFloat(mm).toFixed(2);
			}else{
				nn=parseFloat(Math.floor(mm)).toFixed(2);
		    }
		}
		if('${retain}'=='2')
		{				
			if (accSub(Number(accMul(mm,10)),Number(Math.floor(accMul(mm,10)))) >= 1 ){
				nn=parseFloat(mm).toFixed(2);
			}else{
				nn=parseFloat(accDiv(Math.floor(accMul(mm,10)),10)).toFixed(2);
		    }
		}
		if('${retain}'=='3')
		{				
			if (accSub(Number(accMul(mm,100)),Number(Math.floor(accMul(mm,100)))) >= 1 ){
				nn=parseFloat(mm).toFixed(2);
			}else{
				nn=parseFloat(accDiv(Math.floor(accMul(mm,100)),100)).toFixed(2);
		    }
		}
	}
	
	return nn;
}

function getSum2asd(mm){
	return parseFloat(mm).toFixed(2);
}

function isrowamount(obj){
	var rowindex = $(obj).attr("trindex");
	if($("input[name=salesDetailPo.ssesdpricesums][trindex="+rowindex+"]").attr("taocan") == "taocan"){
		return;
	}else{
		rowamount(obj);
	}
}

function rowamount(obj){
	var rowindex = $(obj).attr("trindex");
	
	var shuliangv = $("input[name=salesDetailPo.ssesdnumbers][trindex="+rowindex+"]");
	var barcode = $("input[name=salesDetailPo.ssesdsalesitemids][trindex="+rowindex+"]").val();
	var iscustomizesv = $("input[name=salesDetailPo.iscustomizes][trindex="+rowindex+"]");
	if(barcode.substring(2,4).toUpperCase() == 'ZZ'){
	}else{
		if('${systemParameterPo.fspsalestype}' != '1' && '${systemParameterPo.fspglassischecknumber}' != '1'){//不允许负库存 同时 成品片也不允许负库存
			var wnumberamount = 0;
			$("input[name=salesDetailPo.ssesditemids][value="+barcode+"]").each(function (){
				wnumberamount = wnumberamount + parseFloat($(this).parent().parent().find("input[name=salesDetailPo.ssesdnumbers]").val());
			});
			if(parseFloat(shuliangv.attr("maxgoodsquantity")) < parseFloat(wnumberamount)){
				if (iscustomizesv.val() != 'D' && iscustomizesv.val() != 'd'){
					shuliangv.val(parseFloat(shuliangv.attr("maxgoodsquantity")) - (parseFloat(wnumberamount) - parseFloat(shuliangv.val())));
				}
			}
		}
	}
	var danjiav   = $("input[name=salesDetailPo.ssesdsprices][trindex="+rowindex+"]");
	var yuanjias  = $("input[name=salesDetailPo.ssesdpricesums][trindex="+rowindex+"]");
	var zhekoulv  = $("input[name=salesDetailPo.ssesddiscountrates][trindex="+rowindex+"]");
	var zhekouv   = $("input[name=salesDetailPo.ssesddiscountnums][trindex="+rowindex+"]");
	var molingv   = $("input[name=salesDetailPo.ssesdrenums][trindex="+rowindex+"]");
	var yingshouv = $("input[name=salesDetailPo.ssesdsalesvalues][trindex="+rowindex+"]");
	var youhuiv   = $("input[name=salesDetailPo.ssesdfavorables][trindex="+rowindex+"]");
	var namev   = $("input[name=salesDetailPo.ssesdsalesitemnames][trindex="+rowindex+"]");
	if((/^(\+|-)?\d+$/.test( shuliangv.val() ))&& parseFloat(shuliangv.val()) > 0){  
		yuanjias.val(parseFloat(danjiav.val()*shuliangv.val()).toFixed(2));
	}else{
		alert("商品数量格式有误！");
		shuliangv.select();
		shuliangv.focus();
		return;
	}
	
	zhekouv.val(accMul(yuanjias.val(),accSub('1',zhekoulv.val())).toFixed(3));
	var mm=accSub(accSub(accSub(accSub(yuanjias.val(),'0'),molingv.val()),youhuiv.val()),zhekouv.val());
	yingshouv.val(getSumasd(mm));
	
	totalamount();
}

function totalamount(){
    var fujiatotal = 0;
    $("input[name=amountMoney]").each(function (){
    	if($(this).val() != ""){
    		fujiatotal = accAdd(fujiatotal,$(this).val()).toFixed(2);
    	}
    });
    //原价合计
    var yuanjiatotal = 0;
	$("input[name=salesDetailPo.ssesdpricesums]").each(function (){
		if($(this).val() == ""){
    		$(this).val('0');
    	}
    	yuanjiatotal = accAdd(yuanjiatotal,$(this).val()).toFixed(2);
    });
	yuanjiatotal = accAdd(yuanjiatotal,fujiatotal).toFixed(2);
    $("span[id=yjje]").text("￥"+yuanjiatotal);
    $("input[name=salesBasicPo.ssesbpricesum]").val(yuanjiatotal);
	//折扣金额
    var zhekoutotal = 0;
	$("input[name=salesDetailPo.ssesddiscountnums]").each(function (){
    	if($(this).val() == ""){
    		$(this).val('0');
    	}
    	zhekoutotal = accAdd(zhekoutotal,$(this).val()).toFixed(2);
    });
    $("span[id=zkje]").text("￥"+parseFloat(zhekoutotal).toFixed(2));
    $("input[name=salesBasicPo.ssesbdiscountnum]").val(zhekoutotal);

    //优惠金额
    var youhuitotal = 0;
    $("input[name=salesDetailPo.ssesdfavorables]").each(function (){
    	youhuitotal = accAdd(youhuitotal,$(this).val());
    });
    $("span[id=yhje]").text("￥"+parseFloat(youhuitotal).toFixed(2));
	
    //抹零金额
    var molingtotal = 0;
	$("input[name=salesDetailPo.ssesdrenums]").each(function (){
		if($(this).val() == ""){
    		$(this).val('0.00');
    	}
    	molingtotal = accAdd(molingtotal,$(this).val()).toFixed(2);
    });
    $("span[id=mljes]").text("￥"+parseFloat(molingtotal).toFixed(2));
    $("input[name=salesBasicPo.ssesbrenums]").val(molingtotal);
    $("input[id=td10t]").val(molingtotal);
    //应收金额
    var yingshoutotal = 0;
	$("input[name=salesDetailPo.ssesdsalesvalues]").each(function (){
		if($(this).val() == ""){
    		$(this).val('0');
    	}
    	yingshoutotal = accAdd(yingshoutotal,$(this).val());
    });
	yingshoutotal = accAdd(yingshoutotal,fujiatotal).toFixed(2);
    $("span[id=ysje]").text("￥"+yingshoutotal);
    $("input[name=salesBasicPo.ssesbsalesvalue]").val(yingshoutotal);

    $("span[id=ssje]").text("￥"+yingshoutotal);
    $("input[name=salesBasicPo.ssesbpsalsvalue]").val(yingshoutotal);
}

function openGoodSingleGiftsValues(){
	if($('#smecicustomerid').val()==''){
		alert('请先输入会员卡号!');
		return;
	}
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;		

	if('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2'){
		if(is_iPad()){
			showPopWin("initGoodsSingleGiftsBatchSel.action?isselect=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleGiftsBatchSel.action?isselect=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}				
	}else{
		if(is_iPad()){
			showPopWin("selGoodsSingleGifts.action?hid=" + "",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selGoodsSingleGifts.action?hid=" + "",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	}
	document.getElementById('popupTitle').innerHTML="【赠品查询】";
}

function clearOp(){
	$("select[id=optometryPerson]").val('');
	changeOptometryPerson();
	$("input[id=btnlock]").show();
	$("input[id=checkboxwl]").attr("checked","");
	$('select[id=selectwf]').val('');
	$('div[id=wfdiv]').hide();
	$('input[name=optometryID]').val('${optometryID}');
	getTadayDate();
}

function clearGoods(){
	$("tr[trsl=trsl]").each(function (){
		if($(this).attr("style") != "DISPLAY: none"){
			$(this).remove();
		}
	});
	$("tr[trfjf=trfjf]").each(function (){
		if($(this).attr("style") != "DISPLAY: none"){
			$(this).remove();
		}
	});
	$("tr[trjgyq=trjgyq]").each(function (){
		if($(this).attr("style") != "DISPLAY: none"){
			$(this).remove();
		}
	});
	$("tr[trzp=trzp]").each(function (){
		if($(this).attr("style") != "DISPLAY: none"){
			$(this).remove();
		}
	});
	$("input[id=downprice]").val("0.00");
	$("input[id=oneprice]").val("");
	$("input[id=maxfavorable]").val("0.00");
	totalamount();
	attrdiscountandrenumopen();
}

//Check for salestype equal one
function checkFrameSales(type){
	var framesize = 0;
	var odsize = 0;
	var ossize = 0;
	$("input[id=ssesdglassflags]").each(function (){
		if($(this).val() == 'F'){
			framesize = framesize + 1;
		}else if($(this).val() == 'R'){
			odsize = odsize + 1;
		}else if($(this).val() == 'L'){
			ossize = odsize + 1;
		}
	});
	/*
    if (framesize >= 1 && type == ''){
    	alert('镜架数量过多!');
        return false;
    }
    */
    if (odsize >= 1 && type == 'R'){
		alert('右眼镜片数量过多!');
		return false;
	}

    if (ossize >= 1 && type == 'L'){
		alert('左眼镜片数量过多!');
		return false;
	}

	return true;
}

function alertNotBrandGlass(json){
    for(var i = 0; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
        if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(0,1) == '3' && $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(0,7) != json.bgigoodsid.substring(0,7)){
			alert('所选镜片属不同品种!');
			return;
        }
	}
}

function checkContactSales(goodsid,type){
    var checknum = 0;
    var cpp = 0;
    var djp = 0;
    for(var i = 0; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
        if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(0,1) == '4'){
			if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(8,9) == 'D' || $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(8,9) == 'd'){
				djp = djp + 1;
			}else{
				cpp = cpp + 1;
			}
        }
	}

	if(djp > 0 && (goodsid.substring(8,9) != 'D' && goodsid.substring(8,9) != 'd') && goodsid.substring(0,1) == '4'){ 
    	alert("隐形成品片与订制片不可同时进行销售！"); 
    	return; 
	} 

	if(cpp > 0 && (goodsid.substring(8,9) == 'D' || goodsid.substring(8,9) == 'd') && goodsid.substring(0,1) == '4'){ 
    	alert("隐形成品片与订制片不可同时进行销售！"); 
    	return; 
	} 

	for(var i = 0; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
		if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(0,1) == '4'){
	    	if(djp > 0 && ($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val().substring(2,4) != goodsid.substring(2,4)) && goodsid.substring(0,1) == '4'){ 
		    	alert("隐形订制片需要销售同一制造商的商品！"); 
		    	return; 
	    	}
    	}
	}

	return true; 
}

//check change takeglassdepartmentid
function checkFrontMoney(){
    
	var logindepartmentid = $("input[name=logindepartmentid]").val();
	var takeglassdepartmentid = $("select[id=ssesblocation]").val();
	if(logindepartmentid != takeglassdepartmentid){
		var ssesbsalesvalue = $("input[name=salesBasicPo.ssesbsalesvalue]").val();
		var ssesbpsalsvalue = $("input[name=salesBasicPo.ssesbpsalsvalue]").val();
		if(parseFloat(ssesbpsalsvalue) < ssesbsalesvalue){
			alert("异店取镜不能使用订金结算，必须全款结算！");
			$("input[name=salesBasicPo.ssesbpsalsvalue]").val(parseFloat($("input[name=salesBasicPo.ssesbsalesvalue]").val()).toFixed(2));
			$('#ssje').text('￥'+parseFloat($("input[name=salesBasicPo.ssesbsalesvalue]").val()).toFixed(2));
			return;
		}
	}
}

//替换打折、抹零方法
function attrdiscountandrenumclose(){
	for(var i=0; i<$('input[id=chk]').length; i++){
		if($('input[id=chk]').eq(i).attr("disabled")){
			$("input[name=salesDetailPo.ssesdnumbers]").eq(i).attr("readonly","readonly");
		}
	}
}

//打开打折、抹零方法
function attrdiscountandrenumopen(){
	for(var i=0; i<$('input[id=chk]').length; i++){
		if($('input[id=chk]').eq(i).attr("disabled")){
			$("input[name=salesDetailPo.ssesdnumbers]").eq(i).attr("readonly","");
		}
	}
	
	$('input[name=salesDetailPo.ssesdnumbers]').each(function (){
		if($(this).val() > 0){
		    rowamount($(this));
		}
	});
}

/**
 *  checkbox全选
 */	
function chkAll(){
    var chk=document.getElementsByName("chk");
    var chks=document.all.chks;
    for(var i=0;i<chk.length;i++){
        if(!$("input[id=chk]").eq(i).is(":hidden")){
        	chk[i].checked = chks.checked;
        }
    }
}

function clearTC(){
	if(isCustomerExist()){
       return;
    }
    
    var goodsids = "";
    var goodsnums = "";
    $('input[name=salesDetailPo.ssesdsalesitemids]').each(function (){
		if($('input[value='+$(this).val()+']').size() > 1 && goodsids.indexOf($(this).val()) == -1){
			goodsids = goodsids + $(this).val() + ','
			goodsnums = goodsnums + $('input[value='+$(this).val()+']').size() + ','
		}
    });
    
    goodsids = goodsids.split(",");
    goodsnums = goodsnums.split(",");
    
    var numc  = 0;
    var numc1 = 0;
    var numc2 = 0;
    for(var i=0; i<goodsids.length-1; i++){
    	if(goodsids[i].substring(0,1) != '3' && goodsids[i].substring(0,1) != '4'){
    		numc = $('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+']').eq(0).val();
    	}else{
    		if(!isNaN($('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=R]').eq(0).val())){
    			numc1 = $('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=R]').eq(0).val();
    		}
    		if(!isNaN($('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=L]').eq(0).val())){
    			numc2 = $('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=L]').eq(0).val();
    		}
    	}
    	
    	for(var j=1; j<goodsnums.length; j++){
    		if(goodsids[i].substring(0,1) != '3' && goodsids[i].substring(0,1) != '4'){
    			numc = accAdd(numc,$('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+']').eq(j).val());
    			$('input[name=salesDetailPo.ssesdsalesitemids][value='+goodsids[i]+']').eq(j).parent().parent().parent().remove();
    		}else{
    			if(!isNaN($('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=R]').eq(j).val())){
		   			numc1 = accAdd(numc1,$('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=R]').eq(j).val());
	   				$('input[name=salesDetailPo.ssesdsalesitemids][value='+goodsids[i]+'][rl=R]').eq(j).parent().parent().parent().remove();
		   			
		   		}
    			if(!isNaN($('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=L]').eq(j).val())){
		   			numc2 = accAdd(numc2,$('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=L]').eq(j).val());
	   				$('input[name=salesDetailPo.ssesdsalesitemids][value='+goodsids[i]+'][rl=L]').eq(j).parent().parent().parent().remove();
		   		}
    		}
    	}
    	
    	if(goodsids[i].substring(0,1) != '3' && goodsids[i].substring(0,1) != '4'){
   			$('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+']').eq(0).val(numc);
   		}else{
   			$('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=R]').eq(0).val(numc1);
   			$('input[name=salesDetailPo.ssesdnumbers][goodsid='+goodsids[i]+'][rl=L]').eq(0).val(numc2);
   		}
    }	
    
    
    
	$('input[name=salesDetailPo.ssesdpricesums]').each(function (){
		$(this).attr("taocan","");
    });
    
	$("input[name=salesDetailPo.ssesdfavorables]").each(function (){
		$(this).val('0.00');
	});
	$("input[id=chk]").attr("disabled","");
	$("input[name=salesDetailPo.ssesdcommoditiesflags]").each(function (){
		if($(this).val() != '1' && $(this).val() != '3' && $("input[name=salestype]:checked").val() != '1'){
			$("input[name=salesDetailPo.ssesdnumbers]").attr("readonly","");
		}
	});
	$("td[id=setmealtitle]").text("");
	$("input[id=ssesbsetmealid]").val("");
	$("input[name=salesDetailPo.ssesdsetmealids]").val("");
	$("input[name=salesDetailPo.ssesdsetmealidnos]").val("");
	$("input[name=salesBasicPo.ssesbisgiveyouintegral]").val("1");
	$("[id=molingdiv]").show();
	
	attrdiscountandrenumopen();
	$("input[id=chk]").attr("checked","checked");
	$("#nohavetc").show();
	$("#havetc").hide();
	$("div[id=nohavetccheckbox]").show();
	$("div[id=havetccheckbox]").hide();
	afreshdiscount();

	$('tr[setsealname=setsealname]').hide();
}

function changeTakeAddress(){
	$('#ssesblocation').attr("disabled","");
}

function clockinspection(){
    var type = $("#recipetype").val();
	$('input[needChange=needChange]').each(function(){
		$(this).unbind("keydown");
	});
			
	// 远用
	if(type == '1'){
		$("[glassType='yuanyong']").each(function(){
			this.readOnly = true;
		});
	}else if (type == '2'){
		$("[glassType='jinyong']").each(function(){
			this.readOnly = true;
		});
	}else if (type == '3'){
		$("[glassType='jianjin']").each(function(){
			this.readOnly = true;
		});
	}else if (type == '5'){
		$("[glassType='zhongyong']").each(function(){
			this.readOnly = true;
		});
	}else if (type == '4'){
		$("[glassType=yinxing]").each(function(){
			this.readOnly = true;
		});
	}else if (type == '6'){
		$("[glassType=suxing]").each(function(){
			this.readOnly = true;
		});
	}else if (type == '7'){
		$("[glassType=shijuexunlian]").each(function(){
			this.readOnly = true;
		});
	}
}

function unClockinspection(){
    var supplierids="";
    $('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function (){
		if($(this).val().substring(2,4)){
			supplierids = supplierids + $(this).val().substring(2,4)+",";
		}
    });    
    showAjaxAdditionalCosts(supplierids);	
    
	if ($('input[name=salesDetailPo\\.ssesdsalesitemids]').size() > 0){
        return;
	}
    var type = $("#recipetype").val();
	$('input[needChange=needChange]').each(function(){
		$(this).bind("keydown",function(){
			OnKeyDownEnter($(this));
		});
	});
				
	// 远用
	if(type == '1'){
		$("[glassType='yuanyong']").each(function(){
			this.readOnly = false;
		});
	}else if (type == '2'){
		$("[glassType='jinyong']").each(function(){
			this.readOnly = false;
		});
	}else if (type == '3'){
		$("[glassType='jianjin']").each(function(){
			this.readOnly = false;
		});
	}else if (type == '5'){
		$("[glassType='zhongyong']").each(function(){
			this.readOnly = false;
		});
	}else if (type == '4'){
		$("[glassType=yinxing]").each(function(){
			this.readOnly = false;
		});
	}else if (type == '6'){
		$("[glassType=suxing]").each(function(){
			this.readOnly = false;
		});
	}else if (type == '7'){
		$("[glassType=shijuexunlian]").each(function(){
			this.readOnly = false;
		});
	}
}

function afreshdiscount(){
	$("#chks").attr("checked","");
	var checktype="";
	$('input[name=salesDetailPo.ssesddiscountrates]').each(function(){
		if($(this).parent().parent().find("#chk").attr("checked")){
			checktype = "1";

			if($(this).attr("customerdiscount")){
				$(this).val($(this).attr("customerdiscount"));
				setDiscountHY($(this).attr("customerdiscount"),'1','','','',$(this).parent().parent().find("input[name=salesDetailPo.ssesdsalesitemids]").val());
			}else{
				$(this).val("1.00");
				setDiscountHY("1.00",'1','','','',$(this).parent().parent().find("input[name=salesDetailPo.ssesdsalesitemids]").val());
			}
		}
	});
	
	$("input[id=chk]").attr("checked","")
	$("input[id=ssesddiscountsources]").val("");
	$("input[id=ssesddiscounttypes]").val("");
}

function checkmaxnumber(obj){
	var barcode = $(obj).parent().parent().find("input[name=salesDetailPo.ssesdsalesitemids]").val();
	if(barcode.substring(2,4).trim().toUpperCase() == 'ZZ'){
		return true;
	}	
	var ctype = $(obj).parent().parent().find("input[name=salesDetailPo.ssesdsalesitemids]").val().substring(0,1);
	var isctype = $(obj).parent().parent().find("input[name=salesDetailPo.iscustomizes]").val();
	//alert(ctype+' '+isctype);
	if('${systemParameterPo.fspsalestype}' == '1'){
		return true;
	}else{
		if(ctype == '3'){
			return true;
		}
		
		if(ctype == '4' && isctype == 'D'){
			return true;
		}
		
		if(parseFloat($(obj).val()) > parseFloat($(obj).parent().parent().find("input[name=maxgoodsquantity]").val())){
			return false;
		}else{
			return true;
		}
	}
}

function formaxnumber(obj){
	if(parseFloat($(obj).val()) > parseFloat($(obj).parent().parent().find("input[name=maxgoodsquantity]").val())){
		if('${systemParameterPo.fspsalestype}' != '1'){
			$(obj).val($(obj).parent().parent().find("input[name=maxgoodsquantity]").val());
		}
	}
}

function printAlertMsg(msg){
    alert(msg);
    return;	
}

function isCustomerExist(){
	if($('#smecicustomerid').val()==''){
		printAlertMsg('请先输入会员卡号!');
	    return true;
	}
    return false;
}


function selectCust(flag){
   if(flag){
    frameSalesForm.action="queryShopSalesMain.action";
    frameSalesForm.submit();
   }
}
//输入会员卡号后回车查询
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			frameSalesForm.action="queryShopSalesMain.action";
			frameSalesForm.submit();
		}
	}
}
	
	
	// 会员详细信息查询开窗
	function details(id){
		if($('#smecicustomerid').val()==''){
			alert('请先输入会员卡号!');
			return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员详细】";
	}
	
	// 会员查询开窗
	function selCustomer(){
        if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
            return;
        }
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
	}
	
	// 会员查询开窗回带会员卡号
	function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		frameSalesForm.action="queryShopSalesMain.action";
		frameSalesForm.submit();
	}

	function printblRport(type,optometryid,flag){
		selGlassType(type);
		printsgjcj(optometryid,flag);
	}
	
	function printsgjcj(optometryid,flag){
		if('${printmedicalhistoryflag}' == '1' && '${systemParameterPo.fspprintmedicalhistory}' == '2'){
			if(flag != '1'){
				var DataURL = "report.action?reportlet=sales_sgjcjl0.cpt&optometryid="+optometryid;
				window.open (DataURL, '病历0', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
			}else{
				var DataURL = "report.action?reportlet=sales_sgjcjl1.cpt&optometryid="+optometryid;
				window.open (DataURL, '病历1', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
			}
		}
	}

	function printReport(ordertype,id){
	    if ($.trim('${systemParameterPo.fspsalesbillname1}') == '' || $.trim('${systemParameterPo.fspsalesbillname3}') == '' || $.trim('${systemParameterPo.fspsalesbillname5}') == ''){
	        alert('请先配置配镜单样式!');
	        return;
	    }
	    
		var DataURL='';
		if(ordertype=='1' || ordertype=='2'){
			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname1}&wflag=1&salesid="+id;		
		}else if(ordertype=='3' || ordertype=='4'){
			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname3}&wflag=1&salesid="+id;
		}else{
			DataURL="report.action?reportlet=${systemParameterPo.fspsalesbillname5}&wflag=1&salesid="+id;
		}
		window.open (DataURL, '结款单', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
	}

	function setSalerPersonList(tid,tdptid){
		$('input[name=salesBasicPo.ssesbsalerid]').val(tid);
		$('#ssesbsalerid').load("getSalerPersonList.action?tid="+tid+"&tdptid="+tdptid);
	}

	function setTakeGlassShopCodeList(tdptid){
		$('#ssesblocation').load("getTakeGlassShopCodeList.action?tdptid="+tdptid);
	}

	function goodsCount(){
	    if ($('input[name=chk]:checked').size() <= 0){
	        alert('请选择需要操作的商品!');
	        return false;
	    }
	    return true;
	}
	
	function showOnePriceNum(){
		var discounttotal = 0;
		var fujiatotal = 0;
	    $("input[name=amountMoney]").each(function (){
	    	if($(this).val() != ""){
	    		fujiatotal = accAdd(fujiatotal,$(this).val()).toFixed(2);
	    	}
	    });
	    
		for(var i=0; i<$('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
			if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val() != ''){
				var copyrow;
				copyrow = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).parent().parent().parent().clone(true);
				var level = copyrow.find("#goodslevel").val();
				
				/////////////////////启用ABC
				var leveldiscount 	= "";
				<c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
					if($("#isqoneprice").val() == '1'){
						leveldiscount 	= $('#qoneprice').attr(level);
					}else{
						leveldiscount 	= $('#ssesbsalerid option:selected').attr(level);
					}
					
				</c:if>
				<c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
					if($("#isqoneprice").val() == '1'){
						leveldiscount 	= $('#qoneprice').attr("discount");
					}else{
						leveldiscount 	= $('#ssesbsalerid option:selected').attr("discount");
						if(leveldiscount == ''){
							leveldiscount = '1.00';
						}
					}
				</c:if>
				if(leveldiscount >= 0.001){
				}else{
					leveldiscount = '1.00';
				}
				
				var maxdiscount 	= copyrow.find("#maxdiscount").val();
				if(maxdiscount >= 0){
				}else{
					maxdiscount = 0;
				}
				var pricesum 	= copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val();
				
				var levelvalue 	= accMul(leveldiscount,pricesum);
				var maxvalue 	= accMul(maxdiscount,pricesum);
				
				if(levelvalue > maxvalue){
					$('input[id=maxfavorable]').eq(i).val(parseFloat(accSub(pricesum,levelvalue)).toFixed(2));
					discounttotal = discounttotal + levelvalue;
				}else{
					$('input[id=maxfavorable]').eq(i).val(parseFloat(accSub(pricesum,maxvalue)).toFixed(2));
					discounttotal = discounttotal + maxvalue;
				}
			}
		}
		
		discounttotal = accAdd(discounttotal,fujiatotal);
		return discounttotal;
	}
	
	function onePrice(obj){
		var saler = $("input[name=salesBasicPo.ssesbsalerid]").val();
		if(!saler){
			alert("请选择销售人员！");
			return;
		}
		
		var fujiatotal = 0;
		var oneprice = parseFloat($(obj).val()).toFixed(0);
		var pricesum = $("input[name=salesBasicPo.ssesbpricesum]").val();
		
		if($(obj).val() == ''){
			return;
		}
		
		if(oneprice != '' && !(parseFloat(oneprice) > 0)){
			alert("请正确填写一口价！");
			$(obj).val('');
			return;
		}
		
	    $("input[name=amountMoney]").each(function (){
	    	if($(this).val() != ""){
	    		fujiatotal = accAdd(fujiatotal,$(this).val()).toFixed(2);
	    	}
	    });
	
		$(obj).val(parseFloat($(obj).val()).toFixed(0));
		var discounttotal = showOnePriceNum();
		if(parseFloat(oneprice) < parseFloat(accAdd(discounttotal,1)).toFixed(0)){
			alert("一口价不能小于（"+parseFloat(accAdd(discounttotal,1)).toFixed(0)+"）！");
			return;
		}
		
		if(parseFloat(oneprice) > parseFloat(pricesum)){
			alert("一口价不能高于原价！");
			return;
		}
		if($("#ssesbsetmealid").val()){
			alert("本次销售已使用套餐，请还原套餐再进行一口价！");
			//clearTC();
			return;
		}
		$("input[id=td10t]").val("0.00");
		$("input[name=salesDetailPo.ssesdrenums]").val("0.00");
		var discountnum = $("input[name=salesBasicPo.ssesbdiscountnum]").val();
		if(discountnum > 0){
			alert("本次销售已使用打折，请还原打折再进行一口价！");
			//setDiscountAllTC('1.00','','','','');
			return;
		}
		
		if(parseFloat(pricesum) == parseFloat(oneprice)){
			resetOnePrice();
			return;
		}
		
		var xfavorablesum = accSub(pricesum,oneprice);
		var yfavorablesum = accSub(pricesum,discounttotal);
		var count = 0;
		
		$('input[name=salesDetailPo.ssesdpricesums]').each(function(){
			if(parseFloat($(this).val()) > 1){
				count = count + 1;
			}
		});
		
		
		var favorable = accSub(pricesum,oneprice);
		
		for(var i=0; i<count; i++){
			if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val() != '' && parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val()) > 1){
				var copyrow;
				copyrow = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).parent().parent().parent().clone(true);
				
				var maxfavorable = $('input[id=maxfavorable]').eq(i).val();
				
				var rowfavorable = parseFloat(parseFloat(accMul(xfavorablesum,accDiv(maxfavorable,yfavorablesum))).toFixed(0)).toFixed(2);
				
				if(i == (count-1)){
					if(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),favorable)<0){
						onePriceAgain(favorable);
					}else{
						$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val(favorable);
					}
				}else{
					$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val(rowfavorable);
				}
				
				favorable = parseFloat(parseFloat(accSub(favorable,rowfavorable)).toFixed(0)).toFixed(2);
				
				rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(i));
			}
		}
		$("#isOnePrice").val("1");
	}
	
	function onePriceAgain(str){
		var oneprice = parseFloat($(obj).val()).toFixed(0);
		var pricesum = $("input[name=salesBasicPo.ssesbpricesum]").val();
		var xfavorablesum = accSub(pricesum,oneprice);
		var yfavorablesum = accSub(pricesum,discounttotal);
		var count = $('input[name=salesDetailPo\\.ssesdsalesitemids]').size();
		var favorable = str;
		
		for(var i=0; i<count; i++){
			if(parseFloat(favorable) > 0){
				if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val() != '' && parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val()) > 0){
					var copyrow = $('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).parent().parent().parent().clone(true);
					
					if(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),favorable)<0){
					}else{
						$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val(favorable);
					}
					
					rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(i));
				}
			}
		}
		
		$("#isOnePrice").val("1");
	}
	
	function resetOnePrice(){
		var oneprice = parseFloat($("#oneprice").val()).toFixed(0);
		var pricesum = $("input[name=salesBasicPo.ssesbpricesum]").val();
		if(oneprice != pricesum){
			if($("#ssesbsetmealid").val()){
				clearTC();
			}
			$("#oneprice").val('');
			$('input[name=salesDetailPo.ssesdfavorables]').val('0.00');
			
			var salesitemids = $('input[name=salesDetailPo.ssesdsalesitemids]');
			var discountrates = $('input[name=salesDetailPo.ssesddiscountrates]');
			for(var i=0; i<salesitemids.size(); i++){
				if(salesitemids.eq(i).val() != ''){
					if(discountrates.eq(i).attr("customerdiscount")){
						discountrates.eq(i).val(discountrates.eq(i).attr("customerdiscount"));
						setDiscountHY(discountrates.eq(i).attr("customerdiscount"),'1','','','',salesitemids.eq(i).val());
					}else{
						$(this).val("1.00");
						setDiscountHY("1.00",'1','','','',salesitemids.eq(i).val());
					}
				}
			}
			$("input[id=ssesddiscountsources]").val("");
			$("input[id=ssesddiscounttypes]").val("");
		}
		
		$("#isOnePrice").val("0");
		$("#isqoneprice").val("0");
	}
	
	function checkDiscount(){
		var isoneprice = $("#isOnePrice").val();
		if(isoneprice == '1'){
			alert("请还原一口价后，再进行操作！");
			return false;
		}else{
			return true;
		}
	}
	
	function resetOnePrice1(){
		var oneprice = parseFloat($("#oneprice").val()).toFixed(0);
		var pricesum = $("input[name=salesBasicPo.ssesbpricesum]").val();
		if(oneprice != pricesum){
			for(var i=0; i<$('input[name=salesDetailPo.ssesdsalesitemids]').size(); i++){
				if($('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(i).val() != '' && $("input[name=salesDetailPo.ssesdpricesums]").eq(i).attr("taocan") != "taocan"){
					$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val('0.00');
					rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(i));
				}
			}
			
			$("#oneprice").val('');
		}
		
		$("#isOnePrice").val("0");
		$("#isqoneprice").val("0");
	}
	
	function QOnePrice(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
	
		if(is_iPad()){
			showPopWin("initSelectQOnePrice.action",600,400,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelectQOnePrice.action",600,400,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【一口价签批】";
	}
</script>

</HTML>
