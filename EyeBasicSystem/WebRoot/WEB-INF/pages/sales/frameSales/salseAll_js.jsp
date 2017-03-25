<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<html>
<script language="javascript">

	function getAjaxCustomerDiscount(goodsid,maxdiscount){
   	   	$.ajax({           
	   	 	type: "POST",          
   	   	    url: "getAjaxCustomerDiscount.action",          
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
	function changeWF() { 
		var recipetype = $("#recipetype").val();
		if('${systemParameterPo.fspupdateinspection}'!='1'){
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
				}
			}
		}
	}

	$(document).ready(function() { 
	    $("div[btn=btn]").attr("style","cursor: hand;"); 
	    $("div[btn=btn]").mouseover(function () { 
	    	$(this).removeClass('giftShortcut_mouseover');
	    	$(this).addClass('giftShortcut_mouseout');
	    }).mouseout(function () { 
	    	$(this).removeClass('giftShortcut_mouseout');
	    	$(this).addClass('giftShortcut_mouseover');
	    }); 
	    changeWF();

	    if ('${systemParameterPo.fspshowcustomertable}' == '1'){
		    printcustomer('${customerInfoPo.smecicustomerid }');
		}
	});

    $(document).ready(function() {
        $('#mailMsg').hide();
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
	});
	function openMember(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInsertCustomerInfo.action?arg0=salseall&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertCustomerInfo.action?arg0=salseall&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员新增】";
	}
	function printcustomer(customerid){
		if('${customerprinttype}'&&'${begin}'){
			var DataURL='';
	   		DataURL="report.action?reportlet=sales_hydy.cpt&customerID="+customerid;
	    	window.open (DataURL, '会员卡打印', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
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
	
	function changeOptometryPerson(){
		$('#optometryPerson').attr("disabled","");
	}
	
	function disabledOptometryPersonSelect()
	{

		$('#optometryPerson').attr("disabled","disabled");
		$('#optometryPersonID').val($('#optometryPerson').val());
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
	 	
		if ('${systemParameterPo.fspdefgetglassestime}' === '2'){
			$('#ssesbtakeglassdata').val(DateAdd('d',day,uValue)+' '+vHour+':'+vMin);
	    }
	}
	
	
	function selLocation()
	{	
		var isd = 0;
		if($("input[id=salestype]:checked").val() != '2' && $("input[id=salestype]:checked").val() != '4'){
			$("input[name=salesDetailPo.ssesdsalesitemids]").each(function (){
				if($(this).val().substring(8,9) == 'D'){
					isd = isd + 1;
				}
			});
			if(isd == 0){
				var mm="k"+$('#ssesblocation').val();
				var dp=0;
				if($('#'+mm).val()!="")
				{
					dp=$('#'+mm).val();
				}
				calculateHours(dp);
			}
			$("input[name=salesBasicPo.ssesblocation]").val($('#ssesblocation').val());
			$('#ssesblocation').attr("disabled","disabled");
		}
	}
	
	
	function selGlassType(type)
	{
		var checkaccessories = '${systemParameterPo.fspcheckaccessories }';
		if(type==4)
		{
			$('#yumen1').hide();
			$('#yumen2').show();
			$('input[name=salestype][value=3]').attr("checked","checked");
			$("table[id=kj]").hide();
			$("table[id=yx]").show();
			if(checkaccessories == '1'){
				$("table[id=pj]").hide();
			}else{
				$("table[id=pj]").show();
			}
			$("#ourframeorglass").hide();
		}else if(type==2||type==1){
			if($('input[name=salestype]:checked').val() == '1'){
				$('#yumen2').hide();
				$('#yumen1').show();
				$('input[name=salestype][value=1]').attr("checked","checked");
				$("table[id=kj]").show();
				$("table[id=yx]").hide();
				if(checkaccessories == '1'){
					$("table[id=pj]").hide();
				}else{
					$("table[id=pj]").show();
				}
				$("#ourframeorglass").show();
			}else if($('input[name=salestype]:checked').val() == '5'){
				$('#yumen2').hide();
				$('#yumen1').show();
				$('input[name=salestype][value=5]').attr("checked","checked");
				$("table[id=kj]").hide();
				$("table[id=yx]").hide();
				$("table[id=pj]").show();
			}else{
				$('#yumen2').hide();
				$('#yumen1').show();
				$('input[name=salestype][value=1]').attr("checked","checked");
				$("table[id=kj]").show();
				$("table[id=yx]").hide();
				if(checkaccessories == '1'){
					$("table[id=pj]").hide();
				}else{
					$("table[id=pj]").show();
				}
				$("#ourframeorglass").show();
			}
		}else{
			$('#yumen2').hide();
			$('#yumen1').show();
			$('input[name=salestype][value=1]').attr("checked","checked");
			$("table[id=kj]").show();
			$("table[id=yx]").hide();
			if(checkaccessories == '1'){
				$("table[id=pj]").hide();
			}else{
				$("table[id=pj]").show();
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
			$("input[id=salestype_input]").val('1');
		}else if(type == '5'){		//中用
			$('#yuanyong').hide();	//远用
			$('#jinyong').hide();	//近用
			$('#zhongyong').show();	//中用
			$('#jianjin').hide();	//双光渐进
			$('#yinxing').hide();	//隐形
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
		} else {
			$('#yuanyong').hide();	// 远用
			$('#jinyong').hide();	// 近用
			$('#jianjin').hide();	// 双光渐进
			$('#zhongyong').hide();	// 中用
			$('#yinxing').hide();	// 隐形
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
			
			$("input[id=salestype_input]").val('');
		}
		if('${systemParameterPo.fspupdateinspection}'!='1'){
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
		if(Datetime.substring(0,10)!=CurrentDate){
		   alert("您选择的处方非当日处方!");
		}
		$("#optometryID").val('${inspectionPos[0].sopipoptometryid }');
		$('#ssetmsenddate').val(Datetime);
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
				$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].focus();
				return;
			}
			if($('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].focus();
				return;
			}
			if($('input[glassType="yuanyong"][name$="ssesbinterhighod"]')[0].value==''){
				alert('请填写右眼远用瞳距!');
				$('input[glassType="yuanyong"][name$="ssesbinterhighod"]')[0].focus();
				return;
			}
			if($('input[glassType="yuanyong"][name$="ssesbinterhighos"]')[0].value==''){
				alert('请填写左眼远用瞳距!');
				$('input[glassType="yuanyong"][name$="ssesbinterhighos"]')[0].focus();
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
				$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].focus();
				return;
			}
			if($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].focus();
				return;
			}
			if($('input[glassType="jinyong"][name$="ssesbinterdistanceod"]')[0].value==''){
				alert('请填写右眼近用瞳距!');
				$('input[glassType="jinyong"][name$="ssesbinterdistanceod"]')[0].focus();
				return;
			}
			if($('input[glassType="jinyong"][name$="ssesbinterdistanceos"]')[0].value==''){
				alert('请填写左眼近用瞳距!');
				$('input[glassType="jinyong"][name$="ssesbinterdistanceos"]')[0].focus();
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
				$('input[glassType="jianjin"][name$="ssesbballglassod"]')[0].focus();
				return;
			}
			if($('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].focus();
				return;
			}
			
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighod"]')[0].value=='')){
				alert('请填写右眼瞳距!');
				$('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].focus();
				return;
			}
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighos"]')[0].value=='')){
				alert('请填写左眼瞳距!');
				$('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].focus();
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
				$('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0].focus();
				return;
			}
			if($('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].focus();
				return;
			}
			if($('input[glassType="zhongyong"][name$="ssesbinterhighod"]')[0].value==''){
				alert('请填写右眼远用瞳距!');
				$('input[glassType="zhongyong"][name$="ssesbinterhighod"]')[0].focus();
				return;
			}
			if($('input[glassType="zhongyong"][name$="ssesbinterhighos"]')[0].value==''){
				alert('请填写左眼远用瞳距!');
				$('input[glassType="zhongyong"][name$="ssesbinterhighos"]')[0].focus();
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
	
	$(document).ready(function(){
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		if('${arg0}'=='salseall'){
			$('#smecimemberid').val('${regMemberID}');
			if(document.getElementById('smecimemberid').value.trim() != ''){
				frameSalesForm.action="initSalesAll.action";
				frameSalesForm.submit();
			}
		}
	
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
		
		$("input[noreadonly=noreadonly][valuetype=number]").each(function(){
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
		if('${wbd}' != '')
		{
			//alert('${wbd}');
		}
		getTadayDate();
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
				}else if("sopipglassmaterial" == $(this).attr("id")){ 
					$(this).text(json.sopipglassmaterial);
				}else if("sopipdisposemanner" == $(this).attr("id")){ 
					$(this).text(json.sopipdisposemanner);
				}else if("sopipsuggestframe" == $(this).attr("id")){ 
					$(this).text(json.sopipsuggestframe);
				}else if("sopipframeheight" == $(this).attr("id")){ 
					$(this).text(json.sopipframeheight);
				}
			});
			$("[glassType='yuanyong'][noreadonly=noreadonly]").each(function(){
				this.readOnly = false;
			});
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
				}else if("sopipglassmaterial" == $(this).attr("id")){ 
					$(this).text(json.sopipglassmaterial);
				}else if("sopipdisposemanner" == $(this).attr("id")){ 
					$(this).text(json.sopipdisposemanner);
				}else if("sopipsuggestframe" == $(this).attr("id")){ 
					$(this).text(json.sopipsuggestframe);
				}else if("sopipframeheight" == $(this).attr("id")){ 
					$(this).text(json.sopipframeheight);
				}
			});
			
			$("[glassType='jinyong'][noreadonly=noreadonly]").each(function(){
				this.readOnly = false;
			});
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
				}else if("sopipglassmaterial" == $(this).attr("id")){ 
					$(this).text(json.sopipglassmaterial);
				}else if("sopipdisposemanner" == $(this).attr("id")){ 
					$(this).text(json.sopipdisposemanner);
				}else if("sopipsuggestframe" == $(this).attr("id")){ 
					$(this).text(json.sopipsuggestframe);
				}else if("sopipframeheight" == $(this).attr("id")){ 
					$(this).text(json.sopipframeheight);
				}
			});
			$("[glassType='jianjin'][noreadonly=noreadonly]").each(function(){
				this.readOnly = false;
			});
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
				}else if("sopipglassmaterial" == $(this).attr("id")){ 
					$(this).text(json.sopipglassmaterial);
				}else if("sopipdisposemanner" == $(this).attr("id")){ 
					$(this).text(json.sopipdisposemanner);
				}else if("sopipsuggestframe" == $(this).attr("id")){ 
					$(this).text(json.sopipsuggestframe);
				}else if("sopipframeheight" == $(this).attr("id")){ 
					$(this).text(json.sopipframeheight);
				}
			});
			$("[glassType='zhongyong'][noreadonly=noreadonly]").each(function(){
				this.readOnly = false;
			});
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

				if(json.sopipcommendglasses.split(',').length > 1){
					$('input[name=syjp]')[0].value = json.sopipcommendglasses.split(',')[0].trim();
					$('input[name=syjp]')[1].value = json.sopipcommendglasses.split(',')[1].trim();
				}else{
					$('input[name=syjp]')[0].value = json.sopipcommendglasses.split(',')[0].trim();
				}
				$('input[name=syjpnum]')[0].value=json.sopipconlenodnum;
				$('input[name=syjpnum]')[1].value=json.sopipconlenosnum;
				
				$('#jyhly').text(json.sopipcommendcardwater);
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
			//克隆行
			$("#copyrow").show();
        	$("#copyrow").clone(true).appendTo($("#copyrow"));
        	$("#copyrow").hide();
        	
        	//取goods行索引
        	var tt=$('input[name=salesDetailPo\\.ssesdsalesitemids]').size()-2;
        	
        	var mm=$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(tt).attr('trindex');
        	var index=$('#copyrow+tr').size()+1;
        	var trindex=0;
        	if(typeof(mm) == 'undefined')
        	{
        		trindex=$('#copyrow+tr').size()+1;
            }else
            {
            	trindex=parseInt(mm+1);
            }
        	
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
	        	$('input[name=salesDetailPo.ssesdguaranteeperiods]').get(index).value=json.guaranteeperiod;
			}else{
				$('input[name=salesDetailPo.ssesdguaranteeperiods]').get(index).value='';
			}
	        $('input[name=salesDetailPo.ssesdguaranteeperiods]').eq(index).attr("trindex",trindex);

	        if(json.batch){
	        	$('input[name=salesDetailPo.ssesdbatchs]').get(index).value=json.batch;
			}else{
				$('input[name=salesDetailPo.ssesdbatchs]').get(index).value='';
			}
	        $('input[name=salesDetailPo.ssesdbatchs]').eq(index).attr("trindex",trindex);
     		
	        var goodsdiscount;    
	        var titlediscounttmp ="1.0";

	 	    if (Number(titlediscounttmp) < Number(json.maxdiscount)){
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
	        $('input[name=salesDetailPo\\.ssesdsalesvalues]').get(index).value=ssje;
	        $('input[name=salesDetailPo\\.ssesdsalesvalues]').eq(index).attr("trindex",trindex);

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
	        if(json.bgigoodscategoryid == '1' || json.bgigoodscategoryid == '2' || json.bgigoodscategoryid == '5' || json.bgigoodscategoryid == '6' || json.bgigoodscategoryid == '7' || json.bgigoodscategoryid == '8' || json.bgigoodscategoryid == '9'){
	        	$('input[name=salesDetailPo\\.ssesditemids]').get(index).value=json.bgigoodsbarcode;
			}else if(json.bgigoodscategoryid == '4'){
				if(json.iscustomize == '0'){
					$('input[name=salesDetailPo\\.ssesditemids]').get(index).value=json.bgigoodsbarcode;
				}
			}else{
				$('input[name=salesDetailPo\\.ssesditemids]').get(index).value='';
			}
         $('input[name=salesDetailPo\\.ssesditemids]').eq(index).attr("maxgoodsquantity",json.maxgoodsquantity);
         if(json.bgiordercycle!=''){
         	if(json.bgiordercycle>bgiordercycle){
         		bgiordercycle=parseInt(json.bgiordercycle);
         		calculate(bgiordercycle);
         	}
         }else if(bgiordercycle==0&&json.bgiordercycle==''&&json.glassflag!=undefined){
  			calculateHours(${departmentsPo.bdptakeglassdate});//成品片取景时间加小时
         }

        $('input[id=chks]').attr("checked","");
     	$('input[id=chk]').attr("checked","");
        attrdiscountandrenumopen();
        totalamount();
        var supplierids="";
        $('input[name=salesDetailPo.ssesdsalesitemids]').each(function (){
			if($(this).val().substring(2,4)){
				supplierids = supplierids + $(this).val().substring(2,4)+",";
			}
        });
        showAjaxAdditionalCosts(supplierids);
        clockinspection();
        
        var titlediscounttmp = json.customerdiscount;
        if (titlediscounttmp==null || $.trim(titlediscounttmp)=='' || isNaN(titlediscounttmp)){
            titlediscounttmp="1.0";
 	    }
 	    if (Number(titlediscounttmp) < Number(json.maxdiscount)){
 	    	titlediscounttmp=json.maxdiscount;        
	 	} 
 	    $('input[name=maxdiscount]').eq(index).value=json.maxdiscount;
 	    $('input[name=salesDetailPo.ssesddiscountrates]').eq(index).attr("customerdiscount",json.customerdiscount);
	    $('input[name=maxdiscount]').eq(index).attr("trindex",trindex);
    	$('input[name=salesDetailPo\\.ssesdsalesitemids][value='+json.bgigoodsid+']').parent().parent().parent().find("#chk").attr("checked","checked");
		setDiscount1(titlediscounttmp,'','','','',json.bgigoodsid);
		$('input[name=salesDetailPo\\.ssesdsalesitemids][value='+json.bgigoodsid+']').parent().parent().parent().find("#chk").attr("checked","");
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

	function date2str(yy, mm, dd,n) {
	    var s, d, t, t2;
	    t = Date.UTC(yy, mm, dd);
	    t2 = n * 1000 * 3600 * 24;
	    t+= t2;
	    d = new Date(t);
	    s = d.getUTCFullYear() + "-";
	    s += ("00"+(d.getUTCMonth()+1)).slice(-2) + "-";
	    s += ("00"+d.getUTCDate()).slice(-2);
	    return s;
	}
	

	function calculateDays(days){
		if(days > 0){
		}else{
			alert("该商品未正确设置订制片默认取镜时间！");
			return;
		}
		var d = new Date(Date.parse(new Date())+parseInt(1000*60*60*24*days));
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
		var d = new Date(Date.parse(new Date())+parseInt(1000*60*60*hours));
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
	function addGifts(json){
		var json = eval('(' + json + ')');
		if('${customerInfoPo.smecimemberid }'==''){
				alert('请先输入会员卡号!');
				return;
		}
		json = json[0];
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
       	$('input[name=giftsPo\\.bgsstockid]').get(index).value=json.bgiwarehouseid;
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
		if(!$('select[id=additionalCosts]').val()&&!$(obj).val()){
			alert('请选择附加费用!');
			return;
		}
		/*if(!$(obj).attr("id")){
			var isadd = '';
			$("input[name=additionalCDetailPo.ssenumber]").each(function (){
				if($('#additionalCosts').val().split(',')[0] == $(this).attr("id")){
					if(parseFloat($(this).val()) >= 99){
						return;
					}else{
						$(this).val(parseFloat($(this).val())+1);
						$(this).parent().parent().find('span[id=amountMoney]').text("￥"+accMul($(this).parent().parent().find('input[name=additionalCostsPo.facamount]').val(),parseFloat(this.value)).toFixed(2));
						$(this).parent().parent().find('input[id=amountMoney]').val(accMul($(this).parent().parent().find('input[name=additionalCostsPo.facamount]').val(),parseFloat(this.value)).toFixed(2));
						isadd = '1';
					}
				}
			});
			if(isadd=='1'){
				var famount = 0;
	       		$('input[id=amountMoney]').each(function (){
	       			famount1 = accAdd(famount, $(this).val());
	       		});
	       		fujiafei = famount;
	       		totalamount();
				return;
			}
		}*/
		
		var ishave = "";
		$('input[name=additionalCDetailPo\\.sseadditionalid]').each(function (){
			if($("#additionalCosts").val().trim().split(",")[0] == $(this).val().trim() && $(obj).val() == ''){
				ishave = '1';
			}
		});
		if(ishave == '1'){
			alert("当前附加费已选择！");
			return;
		}
		
	       	//各种金额计算
  		if((/^(\+|-)?\d+$/.test( obj.value ))&& obj.value > 0){  
  			$(obj).parent().parent().find('span[id=amountMoney]').text("￥"+accMul($(obj).parent().parent().find('input[name=additionalCostsPo.facamount]').val(),parseFloat(obj.value)).toFixed(2));
			$(obj).parent().parent().find('input[id=amountMoney]').val(accMul($(obj).parent().parent().find('input[name=additionalCostsPo.facamount]').val(),parseFloat(obj.value)).toFixed(2));
       		var famount = 0;
       		$('input[id=amountMoney]').each(function (){
       			famount = accAdd(famount, $(this).val());
       		});
       		fujiafei = famount;
	    }else if(typeof(obj.value)=='undefined'){
       		$("#copyrowCosts").show();
        	$("#copyrowCosts").clone(true).removeAttr("id=copyrowCosts").appendTo($("#copyrowCosts"));
        	$("#copyrowCosts").hide();
        	var index=$('#copyrowCosts+tr').size()+1;
        	$('input[name=additionalCDetailPo\\.sseadditionalid]').get(index).value=$('#additionalCosts').val().split(',')[0];
        	$('input[name=additionalCostsPo\\.facname]').get(index).value=$('#additionalCosts').val().split(',')[0];	
        	$('input[name=additionalCostsPo\\.facamount]').get(index).value=$('#additionalCosts').val().split(',')[1];	
        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写附加费数量！'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '附加费数量应为正整数！'}]";
        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).value="1";
        	$('input[name=additionalCDetailPo\\.ssenumber]').get(index).id=index;
        	$('span[id=costs]').get(index).innerText=$('#additionalCosts :selected').text();	
        	$('span[id=costsMoney]').get(index).innerText="￥"+$('#additionalCosts').val().split(',')[1];	
        	$('span[id=amountMoney]').get(index).innerText="￥"+$('#additionalCosts').val().split(',')[1];
        	$('input[id=amountMoney]').get(index).value=$('#additionalCosts').val().split(',')[1];
       		fujiafei=accAdd(fujiafei,$('#additionalCosts').val().split(',')[1]);
       		$('input[name=additionalCDetailPo\\.ssenumber]').eq(index).attr("id",$('#additionalCosts').val().split(',')[0]);
		}else{
   			alert("附加费数量格式有误！");
   			obj.focus();
   			obj.select();
   			return;
		}
  		totalamount();
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

			if ('${systemParameterPo.fspdefgetglassestime}' === '2'){
				$('#ssesbtakeglassdata').val(PlusDay($('#ssesbtakeglassdata').val(),parseFloat('-'+cycle))+' '+vHour+':'+vMin);
			}
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

		var supplierids="";
        $('input[name=salesDetailPo.ssesdsalesitemids]').each(function (){
			if($(this).val().substring(2,4)){
				supplierids = supplierids + $(this).val().substring(2,4)+",";
			}
        });
	}
	
	/*
	结算
	*/
	function save(){
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
		if($("#goodstable tr").length > 2 || $("#fjftable tr").length > 2 || $("#zptable tr").length > 2){
		}else{
			alert("请选择相应商品或费用！");
			return;
		}

		var smecigoodscategoryid = "${customerInfoPo.smecigoodscategoryid }";
		var accessorysalestype = "${systemParameterPo.fspaccessorysalestype }";
		var goodsarray = document.getElementsByName('salesDetailPo.ssesdsalesitemids');		
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
						$('input[glassType="zhongyong"][name$="ssesbpostglassod"]')[0].value='0.00';
					}
					if($('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0].value==''){
						$('input[glassType="zhongyong"][name$="ssesbpostglassos"]')[0].value='0.00';
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
		if($("input[name=salestype][checked]").val() == '1' || $("input[name=salestype][checked]").val() == '2'){
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
			if($("input[name=salestype][checked]").val() != '5'){
				var iscustomizestype = '';
				$("input[name=salesDetailPo.iscustomizes]").each(function (){
					if($(this).val() == 'D'){
						iscustomizestype = 'D';
					}
				});

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
		
		if($("input[name=salestype][checked]").val() != '5'){
			if($('select[name=optometryPerson]').val() == ''){
				alert("请选择验光师！");
				return;
			}
			
			if($("input[id=ssetmsenddate]").val() == ''){
				alert("请选择验光时间！");
				return;
			}
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
		
		if(checkForm(document.all.frameSalesForm)){ 
			var recipetype = $('#recipetype').val();
			$("img").removeAttr("onclick");
			gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
			frameSalesForm.action="salesAll.action?recipetype="+recipetype;
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
		 
		totalamount();
	}
	
	/*
	删除附加费重新计算
	*/
	function deleteVar2(item){
		totalamount();
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

		$('input[name=salesDetailPo.ssesdsalesitemids]').each(function(){
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
			if(checkcount == 1){
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
			var firstcheckstr = $("input[id=chk]:checked").eq(0).parent().parent().find("#goodslevel").val();
			if(!firstcheckstr){
				firstcheckstr = $("input[id=chk]:checked").eq(1).parent().parent().find("#goodslevel").val();
			}
			var isdiscount = "";
			$("input[id=chk]:checked").each(function (){
				if(isdiscount = ""){
					isdiscount = "2";
				}else if($(this).parent().parent().find("#goodslevel").val() != firstcheckstr){
					isdiscount = '1';
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
	

	function setDiscount1(discount,discounttype,discountperson,ddiscounttype,ddiscountsource,goodsid,firstcheckstr){//2012/2/2 零折
		if(!discount != '' || discount == 0){
			$('input[name=salesBasicPo\\.ssesbdiscountrate]').val(discount);
		}
		if(discounttype != ''){
			if(parseFloat(discounttype) > parseFloat($('input[name=salesBasicPo\\.ssesbdiscounttype]').val()) || $('input[name=salesBasicPo\\.ssesbdiscounttype]').val() == ''){
				$('input[name=salesBasicPo\\.ssesbdiscounttype]').val(discounttype);//2012/2/2 零折
			}
		}
		if(firstcheckstr != ''){
			$('input[name=salesBasicPo.ssesbgoodslevel]').val(firstcheckstr);//2012/2/2 零折
		}
		if(discountperson != ''){
			$('input[name=salesBasicPo\\.ssesbdiscountperson]').val(discountperson);//2012/2/2 零折
		}
		//折扣率赋值
		for(var i = 0; i < $('input[name=salesDetailPo.ssesdsalesitemids]').size(); i++){
			if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).parent().parent().parent().find("#chk").attr("checked")){
	            if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val() != ''){		
	            	if($('input[name=salesDetailPo.ssesdpricesums]').eq(i).attr("taocan") == 'taocan'){
	        		    var ssje=getSumasd(accMul(discount,accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val())));
	                    var zkje=parseFloat(accSub(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje),$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val())).toFixed(2);
	                    $('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(parseFloat(zkje).toFixed(3));
	                    $('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
	                    $('input[name=salesDetailPo.ssesddiscounttypes]').eq(i).val("3");
	        		}else{
			            if(discounttype != '2'){
				            var maxdiscount = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).attr("maxdiscount");
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
		
		$('input[name=salesDetailPo\\.ssesdsalesvalues]')[0].value="";

		//折扣金额赋值
		/*var zkindex=0;
		$('input[name=salesDetailPo\\.ssesddiscountnums]').each(function(){
			try{
				var zkje=Math.round(accMul(Subtr(discount,'1'),$('input[name=salesDetailPo\\.ssesdpricesums]')[zkindex].value)*100)/100;
				$(this).val(parseFloat(zkje).toFixed(2));
			}catch(e){
			
			}
			finally{
				zkindex++;
			}
		});*/

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
		for(var i = 0; i < $('input[name=salesDetailPo.ssesdsalesitemids]').size(); i++){
			if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val() == goodsid){
	            if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).val() != ''){		
	            	if($('input[name=salesDetailPo.ssesdpricesums]').eq(i).attr("taocan") == 'taocan'){
	        		    var ssje=getSumasd(accMul(discount,$('input[name=salesDetailPo.ssesdsalesvalues]').eq(i).val()));
	                    var zkje=parseFloat(accSub(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje),$('input[name=salesDetailPo.ssesdfavorables]').eq(i).val())).toFixed(2);
	                    $('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val("0.000");
	                    $('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val("1.00");
	        		}else{
			            if(discounttype != '2'){
				            var maxdiscount = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).attr("maxdiscount");
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
		
		$('input[name=salesDetailPo\\.ssesdsalesvalues]')[0].value="";

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
		for(var i = 0; i < $('input[name=salesDetailPo.ssesdsalesitemids]').size(); i++){
           	$('input[name=salesDetailPo.ssesddiscountrates]').eq(i).val(parseFloat(discount).toFixed(2));
			var ssje=accMul(discount,$('input[name=salesDetailPo.ssesdpricesums]').eq(i).val());
     	            var zkje=parseFloat(accSub($('input[name=salesDetailPo.ssesdpricesums]').eq(i).val(),ssje)).toFixed(2);
			$('input[name=salesDetailPo.ssesddiscountnums]').eq(i).val(getSumasd(zkje));
		}
	    									
			
		/*$('input[name=salesDetailPo\\.ssesddiscountrates]').each(function(){
			$(this).val(discount);
		});*/
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
		$('input[name=salesDetailPo\\.ssesdsalesvalues]')[0].value="";

		//折扣金额赋值
		/*var zkindex=0;
		$('input[name=salesDetailPo\\.ssesddiscountnums]').each(function(){
			try{
				var zkje=Math.round(accMul(Subtr(discount,'1'),$('input[name=salesDetailPo\\.ssesdpricesums]')[zkindex].value)*100)/100;
				$(this).val(parseFloat(zkje).toFixed(2));
			}catch(e){
			
			}
			finally{
				zkindex++;
			}
		});*/

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
			$('input[name=salesBasicPo.ssesbgoodslevel]').val(firstcheckstr);//2012/2/2 零折
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
				var maxdiscount = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(rownumber).attr("maxdiscount");
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
		var maxdiscount = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(rownumber).attr("maxdiscount");
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

        for (var i = 1; i < accAdd(sSsesdSalesValues.length,'0'); i++){
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
	
	function getTadayDate(){
		var myDate = new Date();
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
					$("input[id=salestype_input]").val($(obj).val());
					clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();
					$("div[id=divopmessage]").show();
					$("#ourframeorglass").show();
					selGlassType("1");
				}else if($(obj).val() == '3' || $(obj).val() == '4'){
					$("table[id=kj]").hide();
					$("table[id=yx]").show();
					$("table[id=pj]").hide();
					$("input[id=salestype_input]").val($(obj).val());
					$("div[id=divopmessage]").show();
					$("#ourframeorglass").hide();
					clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();
					selGlassType("4");
				}else if($(obj).val() == '5'){
					$("table[id=kj]").hide();
					$("table[id=yx]").hide();
					$("table[id=pj]").show();
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
				$("div[id=divopmessage]").show();
				$("#ourframeorglass").show();
				$("input[id=salestype_input]").val($(obj).val());
				clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();clearGoods();
				selGlassType("1");
			}else if($(obj).val() == '3'){
				$("table[id=kj]").hide();
				$("table[id=yx]").show();
				$("table[id=pj]").hide();
				$("div[id=divopmessage]").show();
				$("#ourframeorglass").hide();
				$("input[id=salestype_input]").val($(obj).val());
				clearGoods();clearValue();clearOp();$('#nwtype').val('');wlLock();clearGoods();
				selGlassType("4");
			}else if($(obj).val() == '5'){
				$("table[id=kj]").hide();
				$("table[id=yx]").hide();
				$("table[id=pj]").show();
				if('${systemParameterPo.fspoldglasssalestype}'!='1'){
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
	function addSalesGoods(goodscategory,direction, materialType,accessoryType,oneselfframe,iscustomize){				
		if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}	
		var path = "";
		path = getGlassOptometryDate(direction,materialType);
	    if(path == ''){
	        return;
	    }

		$("input[id=inputscanbarcode]").val('');
		
		//销售类型
		var salestype = $("input[name=salestype][checked]").val(); 
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
			if ($('input[name=salestype]:checked').val() == '1' || $('input[name=salestype]:checked').val() == '3'){
			    iscustomize='0';
			}
		}

		var other = '';
		if(goodscategory == 'other'){
			goodscategory = '1';
			other = '1';
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2') && (goodscategory=="4" || goodscategory=="5")){
			if(is_iPad()){
				showPopWin("selectSellMirrorFrameBatch.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1&customertype="+'${customerInfoPo.smecicardtype}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selectSellMirrorFrameBatch.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1&customertype="+'${customerInfoPo.smecicardtype}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
		}else{
			if(is_iPad()){
				showPopWin("selectSellMirrorFrameAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1&customertype="+'${customerInfoPo.smecicardtype}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selectSellMirrorFrameAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&accessoryType="+accessoryType+"&oneselfframe="+oneselfframe+"&iscustomize="+iscustomize+path+"&other="+other+"&kucun=1&whichretail=1&select_retail=1&customertype="+'${customerInfoPo.smecicardtype}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
		}
		
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}	


	
	function getGlassOptometryDate(direction, materialType){
		if($('#recipetype').val()=='0'&&$('#recipetype').attr('disabled')==false)
		{
			alert('请选择处方类型!');
			return '';
		}
		//球镜   sph
		//柱镜  cyl
	 	//下加 add
		var sph = '';
		var cyl = '';
		var add = '';
		var materialType = (direction == 'R') ? $('input[name=materialTypeR]:checked').val() : $('input[name=materialTypeL]:checked').val();
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
		}
		
		return "&sph="+sph.value+"&cyl="+cyl.value+"&add="+ ((add != '') ? add.value : '') +"&glassFlag=" + direction+"&materialType="+materialType+"&recipeType="+recipeType;
	}
	
	function getGlassOptometryDate2(direction, materialType){

		if(glassOD=='R'&&direction=='R'){
			alert('右眼镜片数量过多!');
			return '';
		}
		if(glassOS=='L'&&direction=='L'){                                         
			alert('左眼镜片数量过多!');
			return '';
		}
		if($('#recipetype').val()=='0'&&$('#recipetype').attr('disabled')==false)
		{
			alert('请选择处方类型!');
			return '';
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
				$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].focus();
				return '';
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
				$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].focus();
				return '';
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
				$('input[glassType="jianjin"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].focus();
				return '';
			}
			
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighod"]')[0].value=='')){
				alert('请填写右眼瞳距!');
				$('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].focus();
				return '';
			}
			if(($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighos"]')[0].value=='')){
				alert('请填写左眼瞳距!');
				$('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].focus();
				return '';
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
				$('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0].focus();
				return '';
			}
			if($('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].value==''){
				alert('请填写左眼球镜!');
				$('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].focus();
				return '';
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
		return "&lsph="+sph.value+"&lcyl="+cyl.value+"&ladd="+ ((add != '') ? add.value : '') +"&lglassFlag=" + direction+"&lmaterialType="+materialType+"&lrecipeType="+recipeType;
	}
	
	function getStealthOptometryDate(direction, materialType){
		var sph = '';
		var cyl = '';
		var add = '';
		var syjp='';

	    if($('input[name$="ssesbballglassod"]')[0].value==''&&direction=='R'){
			alert('请填写右眼球镜!');
			$('input[name$="ssesbballglassod"]')[0].focus();
			return '';
		}
		if($('input[name$="ssesbballglassos"]')[0].value==''&&direction=='L'){
			alert('请填写左眼球镜!');
			$('input[name$="ssesbballglassos"]')[0].focus();
			return '';
		}
		
		turnPrescription($('input[name$="ssesbballglassod"]')[0]
				, $('input[name$="ssesbpostglassod"]')[0]
				, $('input[name$="ssesbaxesod"]')[0]);
		turnPrescription($('input[name$="ssesbballglassos"]')[0]
				, $('input[name$="ssesbpostglassos"]')[0]
				, $('input[name$="ssesbaxesos"]')[0]);
				
		sph = (direction == 'R') ? $('input[name$="ssesbballglassod"]')[0] : $('input[name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? $('input[name$="ssesbpostglassod"]')[0] : $('input[name$="ssesbpostglassos"]')[0];				
		syjp = (direction == 'R') ? $('input[name=syjp]')[0] : $('input[name=syjp]')[1];

		return "&sph="+sph.value+"&cyl="+cyl.value+"&glassFlag=" + direction+"&syjp="+EncodeUtf8(syjp.value);
	}
	
	
	
	function getGlassOptometryBar(direction, materialType){
		if($('#recipetype').val()=='0'&&$('#recipetype').attr('disabled')==false)
		{
			alert('请选择处方类型!');
			return '';
		}
		//球镜   sph
		//柱镜  cyl
	 	//下加 add
		var sph = '';
		var cyl = '';
		var add = '';
		var materialType = (direction == 'R') ? $('input[name=materialTypeR]:checked').val() : $('input[name=materialTypeL]:checked').val();
		var recipeType = $('#ssesbrecipetype').val();
		if(recipeType == 1){ //远用
			// 翻方子
			if(direction == 'R')
			{
				if($('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value=='')
				{
					alert('请填写右眼球镜!');
					$('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].focus();
					return '';
				}
				if($('input[glassType="yuanyong"][name$="ssesbinterhighod"]')[0].value=='')
				{
					alert('请填写右眼远用瞳距!');
					$('input[glassType="yuanyong"][name$="ssesbinterhighod"]')[0].focus();
					return '';
				}
			}
			if(direction == 'L')
			{
				if($('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value==''){
					alert('请填写左眼球镜!');
					$('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].focus();
					return '';
				}
				
				if($('input[glassType="yuanyong"][name$="ssesbinterhighos"]')[0].value==''){
					alert('请填写左眼远用瞳距!');
					$('input[glassType="yuanyong"][name$="ssesbinterhighos"]')[0].focus();
					return '';
				}
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
			if(direction == 'R')
			{
				if($('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value=='')
				{
					alert('请填写右眼球镜!');
					$('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].focus();
					return '';				
				}
				if($('input[glassType="jinyong"][name$="ssesbinterdistanceod"]')[0].value=='')
				{
					alert('请填写右眼近用瞳距!');
					$('input[glassType="jinyong"][name$="ssesbinterdistanceod"]')[0].focus();
					return '';
				}
			}
			if(direction == 'L')
			{
				if($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value==''){
					alert('请填写左眼球镜!');
					$('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].focus();
					return '';
				}
				
				if($('input[glassType="jinyong"][name$="ssesbinterdistanceos"]')[0].value==''){
					alert('请填写左眼近用瞳距!');
					$('input[glassType="jinyong"][name$="ssesbinterdistanceos"]')[0].focus();
					return '';
				}
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
			if(direction == 'R')
			{
				if($('input[glassType="jianjin"][name$="ssesbballglassod"]')[0].value=='')
				{
					alert('请填写右眼球镜!');
					$('input[glassType="jianjin"][name$="ssesbballglassod"]')[0].focus();
					return '';
				}
				
				if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighod"]')[0].value==''))
				{
					alert('请填写右眼瞳距!');
					$('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].focus();
					return '';
				}
			}
			if(direction == 'L')
			{
				if($('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].value=='')
				{
					alert('请填写左眼球镜!');
					$('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].focus();
					return '';
				}
				
				if(($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighos"]')[0].value==''))
				{
					alert('请填写左眼瞳距!');
					$('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].focus();
					return '';
				}
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
			
			if(direction == 'R')
			{
				if($('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0].value==''){
					alert('请填写右眼球镜!');
					$('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0].focus();
					return '';
				}
				if($('input[glassType="zhongyong"][name$="ssesbinterhighod"]')[0].value==''){
					alert('请填写右眼远用瞳距!');
					$('input[glassType="zhongyong"][name$="ssesbinterhighod"]')[0].focus();
					return '';
				}
			}
			if(direction == 'L')
			{
				if($('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].value==''){
					alert('请填写左眼球镜!');
					$('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].focus();
					return '';
				}
				
				if($('input[glassType="zhongyong"][name$="ssesbinterhighos"]')[0].value==''){
					alert('请填写左眼远用瞳距!');
					$('input[glassType="zhongyong"][name$="ssesbinterhighos"]')[0].focus();
					return '';
				}
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
		}else if(recipeType == 4){ //远用
			// 翻方子
			
			if(direction == 'R')
			{
				if($('input[glassType="yinxing"][name$="ssesbballglassod"]')[0].value==''){
					alert('请填写右眼球镜!');
					$('input[glassType="yinxing"][name$="ssesbballglassod"]')[0].focus();
					return '';
				}
			
			}
			if(direction == 'L')
			{
				if($('input[glassType="yinxing"][name$="ssesbballglassos"]')[0].value==''){
					alert('请填写左眼球镜!');
					$('input[glassType="yinxing"][name$="ssesbballglassos"]')[0].focus();
					return '';
				}							
			}
				
			turnPrescription($('input[glassType="yinxing"][name$="ssesbballglassod"]')[0]
				, $('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0]
				, $('input[glassType="yinxing"][name$="ssesbaxesod"]')[0]);
			turnPrescription($('input[glassType="yinxing"][name$="ssesbballglassos"]')[0]
				, $('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0]
				, $('input[glassType="yinxing"][name$="ssesbaxesos"]')[0]);
				
			sph = (direction == 'R') ? 
				$('input[glassType="yinxing"][name$="ssesbballglassod"]')[0] : $('input[glassType="yinxing"][name$="ssesbballglassos"]')[0];
			cyl = (direction == 'R') ? 
				$('input[glassType="yinxing"][name$="ssesbpostglassod"]')[0] : $('input[glassType="yinxing"][name$="ssesbpostglassos"]')[0];
		}
		return "&sph="+sph.value+"&cyl="+cyl.value+"&add="+ ((add != '') ? add.value : '') +"&glassFlag=" + direction+"&materialType="+materialType+"&recipeType="+recipeType;
	}
	
	function getGlassOptometryBar2(direction, materialType){

		if(glassOD=='R'&&direction=='R'){
			alert('右眼镜片数量过多!');
			return '';
		}
		if(glassOS=='L'&&direction=='L'){                                         
			alert('左眼镜片数量过多!');
			return '';
		}
		if($('#recipetype').val()=='0'&&$('#recipetype').attr('disabled')==false)
		{
			alert('请选择处方类型!');
			return '';
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
			
			if(direction == 'R')
			{
				if($('input[glassType="yuanyong"][name$="ssesbballglassod"]')[0].value==''){
					alert('请填写右眼球镜!');
					return '';
				}
				if($('input[glassType="yuanyong"][name$="ssesbinterhighod"]')[0].value==''){
					alert('请填写右眼远用瞳距!');
					return '';
				}
			}
			if(direction == 'L')
			{
				if($('input[glassType="yuanyong"][name$="ssesbballglassos"]')[0].value==''){
					alert('请填写左眼球镜!');
					return '';
				}	
				if($('input[glassType="yuanyong"][name$="ssesbinterhighos"]')[0].value==''){
					alert('请填写左眼远用瞳距!');
					return '';
				}					
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
			
			if(direction == 'R')
			{
				if($('input[glassType="jinyong"][name$="ssesbballglassod"]')[0].value==''){
					alert('请填写右眼球镜!');
					return '';
				}
				if($('input[glassType="jinyong"][name$="ssesbinterdistanceod"]')[0].value==''){
					alert('请填写右眼近用瞳距!');
					return '';
				}
			}
			if(direction == 'L')
			{
				if($('input[glassType="jinyong"][name$="ssesbballglassos"]')[0].value==''){
					alert('请填写左眼球镜!');
					return '';
				}
				if($('input[glassType="jinyong"][name$="ssesbinterdistanceos"]')[0].value==''){
					alert('请填写左眼近用瞳距!');
					return '';
				}				
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
		
			if(direction == 'R')
			{
				if($('input[glassType="jianjin"][name$="ssesbballglassod"]')[0].value==''){
					alert('请填写右眼球镜!');
					return '';
				}
				if(($('input[glassType="jianjin"][name$="ssesbinterdistanceod"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighod"]')[0].value=='')){
					alert('请填写右眼瞳距!');
					return '';
				}
			}
			if(direction == 'L')
			{
				if($('input[glassType="jianjin"][name$="ssesbballglassos"]')[0].value==''){
					alert('请填写左眼球镜!');
					return '';
				}
				if(($('input[glassType="jianjin"][name$="ssesbinterdistanceos"]')[0].value=='')&&($('input[glassType="jianjin"][name$="ssesbinterhighos"]')[0].value=='')){
					alert('请填写左眼瞳距!');
					return '';
				}			
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
			
			if(direction == 'R')
			{
				if($('input[glassType="zhongyong"][name$="ssesbballglassod"]')[0].value==''){
					alert('请填写右眼球镜!');
					return '';
				}
				if($('input[glassType="zhongyong"][name$="ssesbinterhighod"]')[0].value==''){
					alert('请填写右眼远用瞳距!');
					return '';
				}
			}
			if(direction == 'L')
			{
				if($('input[glassType="zhongyong"][name$="ssesbballglassos"]')[0].value==''){
					alert('请填写左眼球镜!');
					return '';
				}
				if($('input[glassType="zhongyong"][name$="ssesbinterhighos"]')[0].value==''){
					alert('请填写左眼远用瞳距!');
					return '';
				}		
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
		return "&lsph="+sph.value+"&lcyl="+cyl.value+"&ladd="+ ((add != '') ? add.value : '') +"&lglassFlag=" + direction+"&lmaterialType="+materialType+"&lrecipeType="+recipeType;
	}
	
   /*
	*   扫描商品开窗
	*/
	function scanGoods(obj)
	{  
	    if (event.keyCode==13){
		    if('${customerInfoPo.smecimemberid }'==''){
				alert('请先输入会员卡号!');
				return;
			}
		    var checkaccessories = '${systemParameterPo.fspcheckaccessories }';
			var goodscategory="";
		    var iscustomize="";
	        var temp=$("input[name=salestype][checked]").val();  // 销售类型	        
	        var mm=obj.value.substring(0,1);

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
	        	if(mm!='1' && mm!='2' && mm!='5' && mm!='6' && mm!='8' && mm!='9' && mm!='7')
	        	{
	        		alert("请扫描非镜片或非隐形商品!");
	        		return;
	        	}else
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
			if(odsize == 0 && goodscategory == '3'){
				direction = "R";
			}else if(ossize == 0 && goodscategory == '3'){
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
						showPopWin("scanGoodsSelAllBatch.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}else{
						showPopWin("scanGoodsSelAllBatch.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}
				}else{
					if(is_iPad()){
						showPopWin("scanGoodsSelAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}'+"&ordertype="+temp,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}else{
						showPopWin("scanGoodsSelAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}'+"&ordertype="+temp,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
					}
				}
			}else{
				if(is_iPad()){
					showPopWin("scanGoodsSelAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}'+"&ordertype="+temp,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("scanGoodsSelAll.action?moduleID=${requestScope.moduleID}&goodscategory="+goodscategory+"&iscustomize="+iscustomize+"&goodsbar=" + obj.value.trim()+path+"&direction="+direction+"&rl="+direction+"&kucun=1&customertype="+'${customerInfoPo.smecicardtype}'+"&ordertype="+temp,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
			}
			document.getElementById('popupTitle').innerHTML="【商品查询】";
			$("#inputscanbarcode").val('');
	    }
	}
	
	function getStealthOptometryDate2(direction, materialType){
		var sph = '';
		var cyl = '';
		var add = '';
		var syjp='';

	    if($('input[name$="ssesbballglassod"]')[0].value==''&&direction=='R'){
			alert('请填写右眼球镜!');
			return '';
		}
		if($('input[name$="ssesbballglassos"]')[0].value==''&&direction=='L'){
			alert('请填写左眼球镜!');
			return '';
		}
		turnPrescription($('input[name$="ssesbballglassod"]')[0]
				, $('input[name$="ssesbpostglassod"]')[0]
				, $('input[name$="ssesbaxesod"]')[0]);
		turnPrescription($('input[name$="ssesbballglassos"]')[0]
				, $('input[name$="ssesbpostglassos"]')[0]
				, $('input[name$="ssesbaxesos"]')[0]);
				
		sph = (direction == 'R') ? $('input[name$="ssesbballglassod"]')[0] : $('input[name$="ssesbballglassos"]')[0];
		cyl = (direction == 'R') ? $('input[name$="ssesbpostglassod"]')[0] : $('input[name$="ssesbpostglassos"]')[0];				
		syjp =(direction == 'R') ? $('input[name=syjp]')[0] : $('input[name=syjp]')[1];
		
		return "&lsph="+sph.value+"&lcyl="+cyl.value+"&lglassFlag=" + direction+"&lsyjp="+EncodeUtf8(syjp.value);
	}

    /*
	 *   套餐开窗
	 */
    function querySetMealGoods(){
	    if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
	    if('${customerInfoPo.smeciisfavorable }'=='0'){
			alert('当前会员卡不能参与套餐优惠活动!');
			return;
		}
		
		var count = 0;
		$('input[name=salesDetailPo.ssesdsalesitemids]').each(function (){
			count=count+1;
		});
		if (count <= 1){
			alert('请先选取商品!');
			return;          
		}
		
		var hidstr = "";
		
		for(var i = 1; i < $("input[name=salesDetailPo.ssesdsalesitemids]").size(); i++){
			if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(i).parent().parent().parent().find("#chk").attr("checked")){
				hidstr = hidstr + $("input[name=salesDetailPo.ssesdsalesitemids]").eq(i).val()+"-"+$("input[name=salesDetailPo.ssesdnumbers]").eq(i).val()+",";
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
		if(goodsinfo.goodsClass == "1"){
			//alert(goodsinfo.goodsID.toLocaleUpperCase() +"=="+ $('input[name=salesDetailPo.ssesdsalesitemids]').eq(index).val().substring(0,1).toLocaleUpperCase());
			if(goodsinfo.goodsID.toLocaleUpperCase() == $('input[name=salesDetailPo.ssesdsalesitemids]').eq(index).val().substring(0,1).toLocaleUpperCase()){
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
			if(goodsinfo.goodsID.toLocaleUpperCase() == $('input[name=salesDetailPo.ssesdsalesitemids]').eq(index).val().substring(0,4).toLocaleUpperCase()){
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
			if(goodsinfo.goodsID.toLocaleUpperCase() == $('input[name=salesDetailPo.ssesdsalesitemids]').eq(index).val().substring(0,7).toLocaleUpperCase()){
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
			if(goodsinfo.goodsID.toLocaleUpperCase() == $('input[name=salesDetailPo.ssesdsalesitemids]').eq(index).val().toLocaleUpperCase()){
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
		$('input[name=salesDetailPo.ssesdsalesitemids]').each(function (){
			count=count+1;
		});
		if(count>1){
			$('span[vid=td4t]').text("￥"+parseFloat(obj.value).toFixed(2));
    		$('input[name=salesBasicPo.ssesbrenums]').val(parseFloat(obj.value).toFixed(2));
        	changeSalesValue(obj);
        }
		//objValue = "["
		//			+"{'favorableflag':'4','detailid':'','activemoney':'1','id':'no1','goodsID':'6.41.07.000000118.0001','goodsQuantity':'1','retailPrice':'12021','creditPrice':'1000','title':'FUCK','discountrate':'0.70','isintegralsum':'2'}"
		//			+",{'favorableflag':'3','detailid':'11','activemoney':'2','id':'no1','goodsID':'3.00.03.CB0300200.0000','goodsQuantity':'2','retailPrice':'1','creditPrice':'1000','title':'FUCK','discountrate':'0.80'}"
		//			+"]";
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
			//alert(goodInfos[i].goodsClass);
			var copyrow = "";
		    // 套餐ID
            //alert(goodInfos[i].detailid+"--"+goodInfos[i].favorableflag);
			if(goodInfos[i].detailid == '23'){
				/*setDiscountAllTC(goodInfos[i].discountrate,'','','','');
				for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
					if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
					}
				}*/

				for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
					if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != ''){
						$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(accMul(accAdd(1,-goodInfos[i].discountrate),$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2));
						if(goodInfos[i].isdiscount!='1'){
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
						}
						$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
						rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
					}
				}
				
			}else if(goodInfos[i].detailid == '22'){
				var creditPrice = goodInfos[i].creditPrice;
				//alert("creditPrice"+creditPrice);
				for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
					if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
						givenumber = creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val();
						if(creditPrice%$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() == 0 && parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) > creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() && $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() > 1 && givenumber > 0){
							copyrow = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().clone(true);
							var tt=$('input[name=salesDetailPo\\.ssesdsalesitemids]').size()-2;
				        	
				        	var mm=$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(tt).attr('trindex');
				        	var index=$('#copyrow+tr').size()+1;
				        	var trindex=0;
				        	if(typeof(mm) == 'undefined')
				        	{
				        		trindex=$('#copyrow+tr').size()+1;
				            }else
				            {
				            	trindex=parseInt(mm+1);
				            }
				        	copyrow.find("input").attr("trindex",accAdd(trindex,1));
							copyrow.find("input[name=salesDetailPo.ssesdnumbers]").val(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val());
							copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
							copyrow.find("input[name=salesDetailPo.ssesdfavorables]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
							copyrow.find("input[name=salesDetailPo.ssesdsalesvalues]").val("0.00");
							copyrow.find("div[id=nohavetccheckbox]").hide();
							copyrow.find("div[id=havetccheckbox]").show();
							$('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(accAdd($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(),-givenumber));
							rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
							creditPrice = 0;
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
							$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
							rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						}
						if(goodInfos[i].isdiscount!='1'){
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
						}
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
					}
				}
			}else if(goodInfos[i].detailid == '24'){ 
				var creditPrice = 0;
				//alert(goodInfos[i].activemoney+"----"+goodInfos[i].creditPrice);
				if(goodInfos[i].activemoney&&goodInfos[i].favorableflag == '4'){
					creditPrice = accAdd(yjTotal,-goodInfos[i].activemoney);
				}else if(goodInfos[i].creditPrice&&goodInfos[i].creditPrice > 0){
					creditPrice = goodInfos[i].creditPrice;
				}
				//alert(creditPrice);
				for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
					if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
						givenumber = creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val();
						if(creditPrice%$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() == 0 && parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) > creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() && $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() > 1 && givenumber > 0){
							copyrow = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().clone(true);
							var tt=$('input[name=salesDetailPo\\.ssesdsalesitemids]').size()-2;
				        	
				        	var mm=$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(tt).attr('trindex');
				        	var index=$('#copyrow+tr').size()+1;
				        	var trindex=0;
				        	if(typeof(mm) == 'undefined')
				        	{
				        		trindex=$('#copyrow+tr').size()+1;
				            }else
				            {
				            	trindex=parseInt(mm+1);
				            }
				        	copyrow.find("input").attr("trindex",accAdd(trindex,1));
							copyrow.find("input[name=salesDetailPo.ssesdnumbers]").val(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val());
							copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
							copyrow.find("input[name=salesDetailPo.ssesdfavorables]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
							copyrow.find("input[name=salesDetailPo.ssesdsalesvalues]").val("0.00");
							copyrow.find("div[id=nohavetccheckbox]").hide();
							copyrow.find("div[id=havetccheckbox]").show();
							$('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(accAdd($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(),-givenumber));
							rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
							creditPrice = 0;
						}else{
							if(creditPrice > parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ){
								$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2));
								creditPrice = accAdd(creditPrice,-$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val());
							}else{
								$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat(creditPrice).toFixed(2));
								creditPrice = 0;
							}
							$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
							rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
						}
						if(goodInfos[i].isdiscount!='1'){
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
						}
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
					}
				}
			}else{
				if(goodInfos[i].favorableflag == '1'){
					for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
						if(tctj(j,goodInfos[i])){
							if(goodInfos[i].isdiscount!='1'){
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
							}
						}
						$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
						$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
					}
				}else if(goodInfos[i].favorableflag == '2'){
					for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
						if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
							//alert(goodInfos[i].goodsID +","+ $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val()+","+goodInfos[i].goodsClass);
							//alert(tctj(j,goodInfos[i]));
							if(tctj(j,goodInfos[i])){
								$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat( accMul(accAdd(1,-goodInfos[i].discountrate),$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ).toFixed(2));
								rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
								if(goodInfos[i].isdiscount!='1'){
									$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
									$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
									$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
								}
							}
							$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
							rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
						}
					}
				}else if(goodInfos[i].favorableflag == '3'){
				//if(goodInfos[i].detailid == '11'){
					var creditPrice = goodInfos[i].creditPrice;
					//alert(creditPrice);
					for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
						if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
							if(creditPrice != '' && creditPrice != null && creditPrice > 0){
								//alert(goodInfos[i].goodsID +","+ $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val()+","+goodInfos[i].goodsClass);
								if(tctj(j,goodInfos[i])){
									givenumber = creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val();
									//alert(creditPrice+"%"+$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() +"=="+ 0 +"&&"+ parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) +">"+ creditPrice+"/"+$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() +"&&"+ $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() +"> 1 && "+givenumber +"> 0");
									if(creditPrice%$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() == 0 && parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) > creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() && $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() > 1 && givenumber > 0){
										//alert("in1");
										copyrow = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().clone(true);
										var tt=$('input[name=salesDetailPo\\.ssesdsalesitemids]').size()-2;
							        	var mm=$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(tt).attr('trindex');
							        	var index=$('#copyrow+tr').size()+1;
							        	var trindex=0;
							        	if(typeof(mm) == 'undefined'){
							        		trindex=$('#copyrow+tr').size()+1;
							            }else{
							            	trindex=parseInt(mm+1);
							            }
							        	copyrow.find("input").attr("trindex",accAdd(trindex,1));
										copyrow.find("input[name=salesDetailPo.ssesdnumbers]").val(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val());
										copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
										copyrow.find("input[name=salesDetailPo.ssesdfavorables]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
										copyrow.find("input[name=salesDetailPo.ssesdsalesvalues]").val("0.00");
										copyrow.find("div[id=nohavetccheckbox]").hide();
										copyrow.find("div[id=havetccheckbox]").show();
										$('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(accAdd($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(),-givenumber));
										rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
										creditPrice = 0;
									}else{
										if( parseFloat(creditPrice) > parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ){
											$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val( parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2) );
											creditPrice = accAdd(creditPrice,-$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val());
											//alert(creditPrice); 
										}else{
											//alert(creditPrice); 
											$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val( parseFloat(creditPrice).toFixed(2) );
											creditPrice = 0;
										}
									}
								}
							}
							$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
							rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
							if(goodInfos[i].isdiscount!='1'){
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
							}
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
							$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
						}
					}
				}else if(goodInfos[i].favorableflag == '4'){
					var dyjTotal = 0;
					for(var k=0;k<$('input[name=salesDetailPo.ssesdsalesitemids]').size();k++){
						if(tctj(k,goodInfos[i])){
							if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(k).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(k).parent().parent().parent().find("#chk").attr("checked")){
								dyjTotal = accAdd(dyjTotal,$('input[name=salesDetailPo.ssesdsalesitemids]').eq(k).parent().parent().parent().find("input[name=salesDetailPo.ssesdpricesums]").val());
							}
						}
					}
					var creditPrice = accAdd(dyjTotal,-goodInfos[i].activemoney);
					for(var j=0;j<$('input[name=salesDetailPo.ssesdsalesitemids]').size();j++){
						if($('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val() != '' && $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("checked")){
							//alert(goodInfos[i].goodsID +","+ $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).val()+","+goodInfos[i].goodsClass);
							if(tctj(j,goodInfos[i])){
								givenumber = creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val();
								if(creditPrice%$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() == 0 && parseFloat($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val()) > creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val() && $('input[name=salesDetailPo.ssesdnumbers]').eq(j).val() > 1 && givenumber > 0){
									copyrow = $('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().clone(true);
									var tt=$('input[name=salesDetailPo\\.ssesdsalesitemids]').size()-2;
						        	var mm=$('input[name=salesDetailPo\\.ssesdsalesitemids]').eq(tt).attr('trindex');
						        	var index=$('#copyrow+tr').size()+1;
						        	var trindex=0;
						        	if(typeof(mm) == 'undefined'){
						        		trindex=$('#copyrow+tr').size()+1;
						            }else{
						            	trindex=parseInt(mm+1);
						            }
						        	copyrow.find("input").attr("trindex",accAdd(trindex,1));
									copyrow.find("input[name=salesDetailPo.ssesdnumbers]").val(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val());
									copyrow.find("input[name=salesDetailPo.ssesdpricesums]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
									copyrow.find("input[name=salesDetailPo.ssesdfavorables]").val(parseFloat(copyrow.find("input[name=salesDetailPo.ssesdsprices]").val()*(creditPrice/$('input[name=salesDetailPo.ssesdsprices]').eq(j).val())).toFixed(2));
									copyrow.find("input[name=salesDetailPo.ssesdsalesvalues]").val("0.00");
									if(goodInfos[i].isdiscount!='1'){
										copyrow.find("div[id=nohavetccheckbox]").hide();
										copyrow.find("div[id=havetccheckbox]").show();
									}
									$('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(accAdd($('input[name=salesDetailPo.ssesdnumbers]').eq(j).val(),-givenumber));
									rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
									creditPrice = 0;
								}else{
									if(creditPrice > parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()) ){
										$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat($('input[name=salesDetailPo.ssesdpricesums]').eq(j).val()).toFixed(2));
										creditPrice = accAdd(creditPrice,-$('input[name=salesDetailPo.ssesdpricesums]').eq(j).val());
									}else{
										$('input[name=salesDetailPo.ssesdfavorables]').eq(j).val(parseFloat(creditPrice).toFixed(2));
										creditPrice = 0;
									}
									$('input[name=salesDetailPo.ssesdpricesums]').eq(j).attr("taocan","taocan");
									rowamount($('input[name=salesDetailPo.ssesdnumbers]').eq(j));
								}
								if(goodInfos[i].isdiscount!='1'){
									$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("#chk").attr("disabled","disabled");
									$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=nohavetccheckbox]").hide();
									$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("div[id=havetccheckbox]").show();
								}
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealids]").val(goodInfos[i].id);
								$('input[name=salesDetailPo.ssesdsalesitemids]').eq(j).parent().parent().parent().find("input[name=salesDetailPo.ssesdsetmealidnos]").val(mealcount);
							}
						}
					}
				}
			}
			
			if(copyrow) {
				copyrow.appendTo($("#copyrow")); 
			}
		}

		
		$('input[id=chks]').attr("checked","");
     	$('input[id=chk]').attr("checked","");
        totalamount();
        attrdiscountandrenumclose();
		$("[id=molingdiv]").hide();
		//$("#nohavetc").hide();
		//$("#havetc").show();
    }
	function getSumasd(mm)
	{		
		var nn="";
		if('${systemParameterPo.fspsalescounttype}' == '1'){
			if(${retain}==1)
			{
				nn=parseFloat(mm).toFixed(0)+'.00';
			}
			if(${retain}==2)
			{				
				nn=parseFloat(mm).toFixed(1)+'0';
			}
			if(${retain}==3)
			{				
				nn=parseFloat(mm).toFixed(2);
			}
		}else{
			if(${retain}==1)
			{
				if (accSub(Number(mm),Number(Math.floor(mm))) >= 1 ){
					nn=parseFloat(mm).toFixed(2);
				}else{
					nn=parseFloat(Math.floor(mm)).toFixed(2);
			    }
			}
			if(${retain}==2)
			{				
				if (accSub(Number(accMul(mm,10)),Number(Math.floor(accMul(mm,10)))) >= 1 ){
					nn=parseFloat(mm).toFixed(2);
				}else{
					nn=parseFloat(accDiv(Math.floor(accMul(mm,10)),10)).toFixed(2);
			    }
			}
			if(${retain}==3)
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
	function getSum2asd(mm)
	{
		return parseFloat(mm).toFixed(2);
	}
	
    function rowamount(obj){
    	var trindex = $(obj).attr("trindex");
		var shuliangv = $("input[name=salesDetailPo.ssesdnumbers][trindex="+trindex+"]");
		var barcode = shuliangv.parent().parent().find("input[name=salesDetailPo.ssesditemids]").val();
		if(barcode.substring(1,3).toUpperCase() == 'ZZ'){
		}else{
			if('${systemParameterPo.fspsalestype}' != '1'){
				var wnumberamount = 0;
				$("input[name=salesDetailPo.ssesditemids][value="+barcode+"]").each(function (){
					wnumberamount = wnumberamount + parseFloat($(this).parent().parent().find("input[name=salesDetailPo.ssesdnumbers]").val());
				});
				if(parseFloat(shuliangv.attr("maxgoodsquantity")) < parseFloat(wnumberamount)){
					shuliangv.val(parseFloat(shuliangv.attr("maxgoodsquantity")) - (parseFloat(wnumberamount) - parseFloat(shuliangv.val())));
				}
			}
		}
		var danjiav   = $("input[name=salesDetailPo.ssesdsprices][trindex="+trindex+"]");
		var yuanjias  = $("input[name=salesDetailPo.ssesdpricesums][trindex="+trindex+"]");
		var zhekoulv  = $("input[name=salesDetailPo.ssesddiscountrates][trindex="+trindex+"]");
		var zhekouv   = $("input[name=salesDetailPo.ssesddiscountnums][trindex="+trindex+"]");
		var molingv   = $("input[name=salesDetailPo.ssesdrenums][trindex="+trindex+"]");
		var yingshouv = $("input[name=salesDetailPo.ssesdsalesvalues][trindex="+trindex+"]");
		var youhuiv   = $("input[name=salesDetailPo.ssesdfavorables][trindex="+trindex+"]");
		
		if((/^(\+|-)?\d+$/.test( shuliangv.val() ))&& parseFloat(shuliangv.val()) > 0){  
			yuanjias.val(parseFloat(danjiav.val()*shuliangv.val()).toFixed(2));
		}else{
			alert("商品数量格式有误！");
			shuliangv.select();
			shuliangv.focus();
			return;
		}
		
		zhekouv.val(accMul(yuanjias.val(),accSub('1',zhekoulv.val())).toFixed(3));
		var mm=accSub(accSub(accSub(yuanjias.val(),zhekouv.val()),molingv.val()),youhuiv.val());
		
		//alert(yuanjias.val()+"  "+zhekouv.val()+"  "+molingv.val()+"  "+youhuiv.val());
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
        //alert("原价合计："+yuanjiatotal);
		//折扣金额
        var zhekoutotal = 0;
    	$("input[name=salesDetailPo.ssesddiscountnums]").each(function (){
        	if($(this).val() == ""){
        		$(this).val('0');
        	}
        	zhekoutotal = accAdd(zhekoutotal,$(this).val()).toFixed(2);
        });
        $("span[id=zkje]").text("￥"+zhekoutotal);
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
        $("span[id=mljes]").text("￥"+molingtotal);
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
	    if('${customerInfoPo.smecimemberid }'==''){
			alert('请先输入会员卡号!');
			return;
		}
    	var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		

		if('${systemParameterPo.fspstealtheffective}' == '1' || '${systemParameterPo.fspstealtheffective}' == '2'){
			if(is_iPad()){
				showPopWin("selGoodsSingleGiftsBatch.action?isselect=1",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("selGoodsSingleGiftsBatch.action?isselect=1",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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

  	//Check for salestype equal three 
    function checkContactSales(goodsid,type){
        var checknum = 0;
        var cpp = 0;
        var djp = 0;
        for(var i = 1; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
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

    	for(var i = 1; i < $('input[name=salesDetailPo\\.ssesdsalesitemids]').size(); i++){
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
            if(!$("input[id=chk]").eq(i).attr("disabled")){
            	chk[i].checked = chks.checked;
            }
        }
    }

    function clearTC(){
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
		$("input[name=salesBasicPo.ssesbisgiveyouintegral]").val("1");
		$("[id=molingdiv]").show();
		
		attrdiscountandrenumopen();
		$("input[id=chk]").attr("checked","checked");
		$("#nohavetc").show();
		$("#havetc").hide();
		$("div[id=nohavetccheckbox]").show();
		$("div[id=havetccheckbox]").hide();
		afreshdiscount();
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
	
</script>
<script type="text/javascript" language="javascript" src="${ctx}/js/calenderJS.js"></script>

</HTML>