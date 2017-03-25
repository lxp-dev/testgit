<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/select_many_checked.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/zone.js"></script>
<title>会员管理</title>
</head>
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<script>	
	
	$(document).ready(function() {	
		$('#memberid').focus();
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		var ddaystrs= new Array(); 
		ddaystrs = '${salestypeid}'.split(",");
		for(var i=0;i<ddaystrs.length;i++){
			$("input[name=salestype]").each(function(){
				if($(this).val()==ddaystrs[i]){
					$(this).attr("checked",true);
				}
			}); 
		}
		
		changeAddressType('${systemParameterPo.fspaddresstype}');
		if('${address}'){
			if('${systemParameterPo.fspaddresstype}' == 0){
				var address = '${address}'.split(",");
				if(address.length == 1){
					addaddress([address[0],"---请选择---","---请选择---"]);
				}else if(address.length == 2){
					addaddress([address[0],address[1],"---请选择---"]);
				}else if(address.length == 3){
					addaddress([address[0],address[1],address[2]]);
				}
			}
		}else{
			initaddress();
		}
	});
	
	var s = '';
	var opt0 = ["---请选择---","---请选择---","---请选择---"];
	
	function initaddress() {
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
		
		var zones=opt0;	
			
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
	}
	
	function emptyaddress() {
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
		
		var zones=opt0;	
			
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
	}
	
	function addaddress(str) {
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
		
		var zones=str;	
			
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
	}
	
	 function details(id,dontshow){
		document.all.hid.value = id;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id+"&dontshow="+dontshow,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id+"&dontshow="+dontshow,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【会员信息详细】";
	}
	function update(id){
		document.all.hid.value = id;
		var moduleID = document.getElementById("moduleID").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;

		if(is_iPad()){
			showPopWin("initUpdateCustomerInfo.action?hid="+id+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initUpdateCustomerInfo.action?hid="+id+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【会员信息修改】";
	}
	
	function sendMessage(){
		var tem=$("input[name=phoneflag]:checked").size();
		if(tem==0){
			alert("发送短信查询条件仅手机必须勾选！");
			return false;
		}
		
		var interestpolists = '';
		$('input[name=interestpolists]').each(function(){
            if ($(this).attr('checked') == true){
                if (interestpolists == ''){
                	interestpolists = $(this).val();
                }else{
                	interestpolists = interestpolists + ',' + $(this).val();
                }                	
            }
		});

		var salestypeid = '';
		$('input[name=salestype]').each(function(){
            if ($(this).attr('checked') == true){
                if (salestypeid == ''){
                	salestypeid = $(this).val();
                }else{
                	salestypeid = salestypeid + ',' + $(this).val();
                }                	
            }
		});
		
		var DataUrl = "&address="+EncodeUtf8('${address}')+"&memberid="+$('#memberid').val()+"&name="+EncodeUtf8($('#name').val())+"&phone="+$('#phone').val()+"&sex="+$('#sex').val()+"&agemin="+$('#agemin').val()+"&agemax="+$('#agemax').val()+"&departmentid="+$('#departmentid').val()+"&startTime="+$('#startTime').val()+"&endTime="+$('#endTime').val()+"&startTime1="+$('#startTime1').val()+"&endTime1="+$('#endTime1').val()+"&integralmin="+$('#integralmin').val()+"&integralmax="+$('#integralmax').val()+"&numbermin="+$('#numbermin').val()+"&numbermax="+$('#numbermax').val()+"&pricemin="+$('#pricemin').val()+"&pricemax="+$('#pricemax').val()+"&allpricemin="+$('#allpricemin').val()+"&allpricemax="+$('#allpricemax').val()+"&selbspsuppliername="+EncodeUtf8($('#selbspsuppliername').val())+"&selcstpsupplierid="+$('#selcstpsupplierid').val()+"&brandName="+EncodeUtf8($('#brandName').val())+"&brandID="+$('#brandID').val()+"&goodsname="+EncodeUtf8($('#goodsname').val())+"&goodsid="+$('#goodsid').val()+"&technologyTypeID="+$('#technologyTypeID').val()+"&bbdframematerialtype="+$('#bbdframematerialtype').val()+"&bbdmaterialclass="+$('#bbdmaterialclass').val()+"&bbdrefractive="+$('#bbdrefractive').val()+"&bbdluminosityclass="+$('#bbdluminosityclass').val()+"&bbdfunctionclass="+$('#bbdfunctionclass').val()+"&bbdusetype="+$('#bbdusetype').val()+"&bbdstealthclass="+$('#bbdstealthclass').val()+"&phoneflag="+($('#phoneflag').attr('checked') ? "1" : "")+"&work="+$('#work').val()+"&memberoRigin="+$('#memberoRigin').val()+"&cardtype="+$('#cardtype').val()+"&interestpolists="+EncodeUtf8(interestpolists)+"&srStartTime="+$('#srStartTime').val()+"&srEndTime="+$('#srEndTime').val()+"&huifangcishu="+$('#huifangcishu').val()+"&openid="+$('#openid').val()+"&customerenable="+$('#customerenable').val()+"&salestypeid="+salestypeid+"&persontype="+$('#persontype').val()+"&salsepersonname="+EncodeUtf8($('#salsepersonname').val())+"&hyremark="+EncodeUtf8($('#hyremark').val());
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selCustomerSendMessage.action?moduleID=${moduleID}" + DataUrl,500,310,topRows,topCols,returnRefresh(false),false);
		}else{
			showPopWin("selCustomerSendMessage.action?moduleID=${moduleID}" + DataUrl,500,310,topRows,topCols,returnRefresh(false),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员高级管理发送短信】";
	}
	
	function search(){
		getSelectValue('departmentid2','departmentid');
		getSelectValue('memberoRiginid','memberoRigin');
		
		var salestypeid="";
		$("input[name=salestype]").each(function(){
			if($(this).attr("checked")){
				salestypeid=salestypeid+","+$(this).val();
			}
		});
    	if(checkForm(customerInfoForm)){ 
    		$("img").removeAttr("onclick");
    		customerInfoForm.action = "selCustomerHighLevelInfo.action?salestypeid="+salestypeid;
    		customerInfoForm.submit();
    		showLoadingBar();
        }
	}
	
	function selectmember1(){
		if(event.keyCode==13){
			search();
		}
	}
	
	/*甘肃路店会员新增*/
	
	function gslinsert(){
		showPopWin("","initCreditCardAccountFeesInsert.action",screen.width-200,screen.height-160, '',null,true);
		selectHidden();
	}
	function insert(){
		var moduleID =document.getElementById('moduleID').value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initInsertCustomerInfo.action?moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initInsertCustomerInfo.action?moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【会员信息新增】";
	}
	function del(id){
		var moduleID = document.getElementById("moduleID").value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initDeleteCustomerInfo.action?hid="+id+"&moduleID="+moduleID,450,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDeleteCustomerInfo.action?hid="+id+"&moduleID="+moduleID,450,140,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【会员信息删除】";
	}

	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });	
        $('input[name=interestpolists]').each(function(){
            $(this).attr('checked',false);

        });
        $('input[name=phoneflag]').each(function(){
        	$(this).attr('checked',false);

        });
        $("input[name=salestype]").each(function(){
				$(this).attr("checked",false);
		}); 
    	
        resetSelectList('departmentid2');
        resetSelectList('memberoRiginid');
		emptyaddress();
	}
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
		//showPopWin("","selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
	}

	/**
	 * 品种开窗
	 */
	function openBrand(){

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
	    var supplierID=document.getElementById('selcstpsupplierid').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		if(is_iPad()){
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";

	}


	function openGoodSingle(){//商品开窗
		var supplierID=$('#selcstpsupplierid').val();
		var brand_open=$('#brandID').val();
		var supplierName = $('#selbspsuppliername').val();
		var brandName = $('#brandName').val();

	    if(supplierID==''){
		    alert('请选择所属制造商!');
		    return false;
		}
	    if(brand_open==''){
		    alert('请选择所属品种!');
		    return false;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selGoodsSingles.action?supplierID_open=" + supplierID+"&brand_open=" + brand_open+"&supplierName="+EncodeUtf8(supplierName)+"&brandName="+EncodeUtf8(brandName),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selGoodsSingles.action?supplierID_open=" + supplierID+"&brand_open=" + brand_open+"&supplierName="+EncodeUtf8(supplierName)+"&brandName="+EncodeUtf8(brandName),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selcstpsupplierid').value = json.id;
		document.getElementById('selbspsuppliername').value = json.value;
		
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('goodsid').value = "";
		document.getElementById('goodsname').value = "";
	}

	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
		document.getElementById('goodsid').value = "";
		document.getElementById('goodsname').value = "";
	}

	/**
	 * 开窗赋值实现方法
	 */
	function openGoodsValues(json){
		document.getElementById('goodsid').value = json.id;
		document.getElementById('goodsname').value = json.value;
	}
	
	
	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	
	function today1(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime1').value = now;
		document.getElementById('endTime1').value = now;		
	}

	//导出会员信息
	function exportCashCoupon(){
	    if ($('#addTable').size() == 0){
		    alert("请先查询出需要导出的顾客信息！");
		    return;
		}else{
			var interestpolists = '';
			$('input[name=interestpolists]').each(function(){
	            if ($(this).attr('checked') == true){
	                if (interestpolists == ''){
	                	interestpolists = $(this).val();
	                }else{
	                	interestpolists = interestpolists + ',' + $(this).val();
	                }                	
	            }
			});

			var salestypeid = '';
			$('input[name=salestype]').each(function(){
	            if ($(this).attr('checked') == true){
	                if (salestypeid == ''){
	                	salestypeid = $(this).val();
	                }else{
	                	salestypeid = salestypeid + ',' + $(this).val();
	                }                	
	            }
			});
			var DataUrl = "&address="+EncodeUtf8('${address}')+"&memberid="+$('#memberid').val()+"&name="+EncodeUtf8($('#name').val())+"&phone="+$('#phone').val()+"&sex="+$('#sex').val()+"&agemin="+$('#agemin').val()+"&agemax="+$('#agemax').val()+"&departmentid="+$('#departmentid').val()+"&startTime="+$('#startTime').val()+"&endTime="+$('#endTime').val()+"&startTime1="+$('#startTime1').val()+"&endTime1="+$('#endTime1').val()+"&integralmin="+$('#integralmin').val()+"&integralmax="+$('#integralmax').val()+"&numbermin="+$('#numbermin').val()+"&numbermax="+$('#numbermax').val()+"&pricemin="+$('#pricemin').val()+"&pricemax="+$('#pricemax').val()+"&allpricemin="+$('#allpricemin').val()+"&allpricemax="+$('#allpricemax').val()+"&selbspsuppliername="+EncodeUtf8($('#selbspsuppliername').val())+"&selcstpsupplierid="+$('#selcstpsupplierid').val()+"&brandName="+EncodeUtf8($('#brandName').val())+"&brandID="+$('#brandID').val()+"&goodsname="+EncodeUtf8($('#goodsname').val())+"&goodsid="+$('#goodsid').val()+"&technologyTypeID="+$('#technologyTypeID').val()+"&bbdframematerialtype="+$('#bbdframematerialtype').val()+"&bbdmaterialclass="+$('#bbdmaterialclass').val()+"&bbdrefractive="+$('#bbdrefractive').val()+"&bbdluminosityclass="+$('#bbdluminosityclass').val()+"&bbdfunctionclass="+$('#bbdfunctionclass').val()+"&bbdusetype="+$('#bbdusetype').val()+"&bbdstealthclass="+$('#bbdstealthclass').val()+"&phoneflag="+($('#phoneflag').attr('checked') ? "1" : "")+"&work="+$('#work').val()+"&memberoRigin="+$('#memberoRigin').val()+"&cardtype="+$('#cardtype').val()+"&interestpolists="+EncodeUtf8(interestpolists)+"&srStartTime="+$('#srStartTime').val()+"&srEndTime="+$('#srEndTime').val()+"&huifangcishu="+$('#huifangcishu').val()+"&openid="+$('#openid').val()+"&customerenable="+$('#customerenable').val()+"&salestypeid="+salestypeid+"&persontype="+$('#persontype').val()+"&salsepersonname="+EncodeUtf8($('#salsepersonname').val())+"&hyremark="+EncodeUtf8($('#hyremark').val());
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			if(is_iPad()){
				showPopWin("initExportCustomerInfo.action?moduleID=${moduleID}"+DataUrl,400,140,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin("initExportCustomerInfo.action?moduleID=${moduleID}"+DataUrl,400,140,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【会员信息导出】";
		}

	}

	function setCustomerExportProperty(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selCustomerExportProperty.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selCustomerExportProperty.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员导出信息配置】";
	}

	//导出会员信息
	function exportCashCoupon2(customerInfoForm2){
	    if ('${confirmSwitch}' == '1'){
	        if (confirm("此功能将根据您在查询条件中输入的数据导出顾客信息，是否确认导出？")){
	    	    if ($('#addTable').size() == 0){
		            alert("请先查询出需要导出的顾客信息！");
		            return;
		        }else{
		        	//$("img").removeAttr("onclick");
		        	customerInfoForm2.action="exportCustomerInfo.action";
		            customerInfoForm2.submit();
		        }	
	       }
	    }else{
		    if ($('#addTable').size() == 0){
			    alert("请先查询出需要导出的顾客信息！");
			    return;
			}else{
				//$("img").removeAttr("onclick");
				customerInfoForm2.action="exportCustomerInfo.action";
			    customerInfoForm2.submit();
			}
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
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="customerInfoForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input id="moduleID" type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：会员高级管理</TD>
            <td align="right" valign="bottom">&nbsp;
                <c:if test="${(permissionPo.keyf==1)}">
            		<img src="${ctx }/img/newbtn/btn_hyzldcxpz_0.png" title="会员资料导出项配置" btn=btn onClick="setCustomerExportProperty()">
            	</c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">会员卡号</TD>
			               <TD class="table_none" width="28%">
                            <input clean=clean class="text_input160" type="text"  id="memberid" name="memberid" value="${requestScope.memberid}" onkeydown="selectmember1()" />
			               </TD>
			               <TD width="8%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="28%">
                             <input clean=clean class="text_input160" type="text"  id="name" name="name" value="${requestScope.name}" onkeydown="selectmember1()" />
			               </TD>
						   <TD width="8%" height="26" class="table_body">联系电话</TD>
			               <TD class="table_none" >
                            <input clean=clean class="text_input100" type="text"  id="phone" name="phone" value="${requestScope.phone}" onkeydown="selectmember1()" />

			                <input type=checkbox id="phoneflag" name='phoneflag' value='1' ${phoneflag=='1'? 'checked="checked"' : ''}>仅手机
			               </TD>
                        </TR>
                        <TR>
                           <TD  height="26" class="table_body">顾客性别</TD>
			               <TD class="table_none">
                            <select clean=clean id="sex" name="sex">
                            	<option value="">----请选择----</option>
      		                 	<option value="0" ${requestScope.sex!= "0"  ? '' : 'selected="selected"' }>男</option>
      		                 	<option value="1" ${requestScope.sex!= "1"  ? '' : 'selected="selected"' }>女</option>
      	                    </select>
			               </TD>
						   <TD  height="26" class="table_body">注册部门</TD>
			               <TD class="table_none">
			               <select clean=clean id="departmentid2" name="departmentid2" multiple="multiple" size="20">
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}">(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
      	                   </select>
      	                   <input type="hidden" clean=clean id="departmentid" name="departmentid" readonly="readonly" value="${requestScope.departmentid }"/>
			               </TD>
			                <TD  height="26" class="table_body">会员年龄</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input60" type="text"  id="agemin" name="agemin" value="${requestScope.agemin}"/>&nbsp;至
                            <input clean=clean class="text_input60" type="text"  id="agemax" name="agemax" value="${requestScope.agemax}"/>&nbsp;(岁)			               
                           </TD>
                        </TR>
                        <TR height="26" id="tradress3">
                          <TD class="table_body ">地区(3级)</TD>
                          <TD class="table_none " colspan="5">
                          <select id="zone1" yyorder="8"  name="zone1" value="${companyNamePo.fcnzone}"></select>
                          <select id="zone2" yyorder="9" name="zone2"></select>
                          <select id="zone3" yyorder="10" name="zone3"></select><label style="color:red;">&nbsp;*&nbsp;</label>
                          </TD>
					    </TR>
                        <TR height="26" id="tradress5">
                          <TD class="table_body ">地区(5级)</TD>
                          <TD class="table_none " colspan="5">
	                          <select id="t1" name="t1" clean=clean onchange="getAreaAjaxData('2',this.options[this.options.selectedIndex].value)">
	                          	 <option value="">---请选择---</option>
	                             <s:iterator value="area1List">
	                                 <option value="${faid}" ${(faid eq t1)? 'selected':''}>${faname}</option>
	                             </s:iterator>
	                          </select>
	                          <select id="t2" name="t2" clean=clean onchange="getAreaAjaxData('3',this.options[this.options.selectedIndex].value)">
	                          	<option value="">---请选择---</option>
	                          	 <s:iterator value="area2List">
	                                 <option value="${faid}" ${(faid eq t2)? 'selected':''}>${faname}</option>
	                             </s:iterator>
	                          </select>
	                          <select id="t3" name="t3" clean=clean onchange="getAreaAjaxData('4',this.options[this.options.selectedIndex].value)">
	                          	<option value="">---请选择---</option>
	                          	 <s:iterator value="area3List">
	                                 <option value="${faid}" ${(faid eq t3)? 'selected':''}>${faname}</option>
	                             </s:iterator>	
	                          </select>
	                          <select id="t4" name="t4" clean=clean onchange="getAreaAjaxData('5',this.options[this.options.selectedIndex].value)">
	                          	<option value="">---请选择---</option>
	                          	 <s:iterator value="area4List">
	                                 <option value="${faid}" ${(faid eq t4)? 'selected':''}>${faname}</option>
	                             </s:iterator>	
	                          </select>
	                          <select id="t5" name="t5" clean=clean>
	                          	<option value="">---请选择---</option>
	                          	 <s:iterator value="area5List">
	                                 <option value="${faid}" ${(faid eq t5)? 'selected':''}>${faname}</option>
	                             </s:iterator>	
	                          </select>                      	                          	                          	                          
                          </TD>
					    </TR>	
                         <TR height="26">
                          <TD class="table_body " >兴趣爱好</TD>
                          <TD width="65%" class="table_none " colspan="5">&nbsp;
                           <c:forEach items="${interestpolist}"  var="interestpolist" varStatus="linerole">
                             <input type=checkbox id="interestpolists" name='interestpolists' value='${interestpolist.birid}' ${interestpolist.flag=='1'? 'checked="checked"' : ''}>${interestpolist.birname}
                             </c:forEach>
                         </TD>
						</TR>
                        <TR>
                           <TD  height="26" class="table_body">注册时间</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})" clean=clean
					       value="${startTime }" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" clean=clean
					        value="${endTime }" />
					        </li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
			               </TD>
						   <TD  height="26" class="table_body">销售时间</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight"><input id="startTime1" clean=clean 
					       name="startTime1" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime1\')}'})"
					       value="${startTime1 }" /> 至 <input id="endTime1" clean=clean
					       name="endTime1" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime1\')}'})" 
					        value="${endTime1 }" />
					        </li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today1()"></li>
			               </TD>
			               <TD  height="26" class="table_body">积分范围</TD>
			               <TD class="table_none">
                           <input clean=clean class="text_input60" type="text"  id="integralmin" name="integralmin" value="${requestScope.integralmin}"/>&nbsp;至
                            <input clean=clean class="text_input60" type="text"  id="integralmax" name="integralmax" value="${requestScope.integralmax}"/>
			               </TD>
                        </TR>
                         <TR>
                          <TD  height="26" class="table_body">消费笔数</TD>
			               <TD class="table_none">
                           <input clean=clean class="text_input60" type="text"  id="numbermin" name="numbermin" value="${requestScope.numbermin}"/>&nbsp;至
                            <input clean=clean class="text_input60" type="text"  id="numbermax" name="numbermax" value="${requestScope.numbermax}"/>&nbsp;(笔)
			               </TD>
                           <TD  height="26" class="table_body">单笔消费</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input60" type="text"  id="pricemin" name="pricemin" value="${requestScope.pricemin}"/>&nbsp;至
                            <input clean=clean class="text_input60" type="text"  id="pricemax" name="pricemax" value="${requestScope.pricemax}"/>&nbsp;(元)
			               </TD>
						   <TD  height="26" class="table_body">消费总金额</TD>
			               <TD class="table_none">
                           <input clean=clean class="text_input60" type="text"  id="allpricemin" name="allpricemin" value="${requestScope.allpricemin}"/>&nbsp;至
                            <input clean=clean class="text_input60" type="text"  id="allpricemax" name="allpricemax" value="${requestScope.allpricemax}"/>&nbsp;(元)
			               </TD>
			              
                        </TR>
                        <TR>
                          <TD  height="26" class="table_body">职业</TD>
			               <TD class="table_none">
                            <select clean=clean id="work" name="work">
                            	<option value="">----请选择----</option>
								<s:iterator value="worktypepolist">
									<option value="${bwtid}" ${work == bwtid ? 'selected="selected"':'' }>
									${bwtname}
									</option>
								</s:iterator>
      	                    </select>
			               </TD>
                           <TD  height="26" class="table_body">会员来源</TD>
			               <TD class="table_none">
                            <select clean=clean id="memberoRiginid" name="memberoRiginid">
      		                 	<option value="">----请选择----</option>
								<s:iterator value="memberoriginpolist">
									<option value="${bmoid}" ${memberoRigin == bmoid ? 'selected="selected"':'' }>${bmoname}</option>
								</s:iterator>
      	                    </select>
      	                    <input type="hidden" value="${memberoRigin}" id="memberoRigin" name="memberoRigin" />
			               </TD>	
			               <TD  height="26" class="table_body">会员卡类型</TD>
			               <TD class="table_none">
	                          <select clean=clean id="cardtype" name="cardtype">
	                                 <option value="">----请选择----</option>
	                             <s:iterator value="memberManagementList">
	                                 <option value="${fmmid}" ${cardtype == fmmid ? 'selected="selected"':'' }>${fmmmembername}</option>
	                             </s:iterator>
	                          </select>
			               </TD>		              
                        </TR>
                        <TR>
                           <TD  height="26" class="table_body">购买商品包含</TD>
			               <TD class="table_none" colspan="5">
			               	<li class="horizontal_onlyRight">
						   		<input clean=clean id="selbspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input clean=clean type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_changesupplier_0.png" btn=btn title="选择制造商" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				
			             	 <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						
						   <img src="${ctx }/img/newbtn/btn_changebrand_0.png" btn=btn title="选择品种" onClick="openBrand();"></li>
						   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="goodsname" name="goodsname" value="${requestScope.goodsname}" readonly="readonly">
						   		<input clean=clean type="hidden" id="goodsid" name="goodsid" value="${requestScope.goodsid}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						   <img  name="button2" src="${ctx}/img/newbtn/btn_changegoods_0.png" btn=btn title="选择商品" onClick="javascript:openGoodSingle();"></li>
			             
			             </TD>
                        </TR>
                        <TR>
                           <TD  height="26" class="table_body">购买镜架包含</TD>
			               <TD class="table_none" colspan="5">工艺类型
			               <select clean=clean id="technologyTypeID" name="technologyTypeID" >
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="technologyType">
				               <option value="${fttid}" ${requestScope.technologyTypeID == fttid ? 'selected="selected"' : '' }>${fttname}</option>
	     	                 </s:iterator>
      	                    </select>
      	                   		&nbsp;&nbsp;&nbsp;镜架材质
			               <select clean=clean id="bbdframematerialtype" name="bbdframematerialtype" >
	      		                 <option value="" >----请选择----</option>
	                            <s:iterator value="frameMateriallist">
				              	 <option value="${bfmid}" ${requestScope.bbdframematerialtype != bfmid ? '' : 'selected="selected"' }>${bfmname}</option>
	     	                	 </s:iterator>
	      	                   </select>
			             </TD>
                        </TR>
                        <TR>
                           <TD  height="26" class="table_body">购买镜片包含</TD>
			               <TD class="table_none" colspan="5">材料分类
			              <select clean=clean id="bbdmaterialclass" name="bbdmaterialclass" >
      		                 <option value="" ${requestScope.bbdmaterialclass eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                             <option value="1" ${requestScope.bbdmaterialclass eq '1' ? 'selected="selected"' : '' }>树脂</option>
                             <option value="2" ${requestScope.bbdmaterialclass eq '2' ? 'selected="selected"' : '' }>玻璃</option>
                             <option value="3" ${requestScope.bbdmaterialclass eq '3' ? 'selected="selected"' : '' }>PC</option>
      	                   </select>
      	                 			  &nbsp;&nbsp;&nbsp;折射率
      	                   <select clean=clean id="bbdrefractive" name="bbdrefractive" >
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="refractiveSetList">
				               <option value="${brfname}"  ${requestScope.bbdrefractive eq brfname ? 'selected="selected"' : '' }>${brfname}</option>
	     	               </s:iterator>
      	                   </select>
      	                   		 &nbsp;&nbsp;&nbsp;光度分类
      	                   <select clean=clean id="bbdluminosityclass" name="bbdluminosityclass" >
      		                 <option value="" ${requestScope.bbdluminosityclass eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                             <option value="0" ${requestScope.bbdluminosityclass eq '0' ? 'selected="selected"' : '' }>单光</option>
                             <option value="M" ${requestScope.bbdluminosityclass eq 'M' ? 'selected="selected"' : '' }>多光</option>
                             <option value="J" ${requestScope.bbdluminosityclass eq 'J' ? 'selected="selected"' : '' }>渐进</option>
                             <option value="K" ${requestScope.bbdluminosityclass eq 'K' ? 'selected="selected"' : '' }>抗疲劳</option>
                             <option value="Q" ${requestScope.bbdluminosityclass eq 'Q' ? 'selected="selected"' : '' }>其他</option>
      	                   </select>
      	                   		&nbsp;&nbsp;&nbsp;镜片功能
      	                   	<select clean=clean id="bbdfunctionclass" name="bbdfunctionclass" >
      		                   <option value="" ${requestScope.bbdfunctionclass eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                     	       <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
                                   <c:if test="${optionParamPoTmp.fopparentid == 'gn'}">
                               	       <option value="${optionParamPoTmp.fopparamid }" ${(requestScope.bbdfunctionclass == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
                                   </c:if>	                                      	
                               </c:forEach>
      	                   </select>
			             </TD>
                        </TR>
                        <TR>
                           <TD  height="26" class="table_body">购买隐形包含</TD>
			               <TD  class="table_none" colspan="5">使用类型
			                 <select clean=clean id="bbdusetype" name="bbdusetype" >
                             <option value="" ${requestScope.bbdusetype eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                             <option value="1" ${requestScope.bbdusetype eq '1' ? 'selected="selected"' : '' }>常带型</option>
                             <option value="2" ${requestScope.bbdusetype eq '2' ? 'selected="selected"' : '' }>抛弃型</option>
                              <option value="3" ${requestScope.bbdusetype eq '3' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   </select>
      	                   		&nbsp;&nbsp;&nbsp;抛弃型分类
			                  <select clean=clean id="bbdstealthclass" name="bbdstealthclass" >
      		                 <option value="" ${requestScope.bbdstealthclass eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                             <option value="1" ${requestScope.bbdstealthclass eq '1' ? 'selected="selected"' : '' }>日抛</option>
                             <option value="2" ${requestScope.bbdstealthclass eq '2' ? 'selected="selected"' : '' }>周抛</option>
                             <option value="9" ${requestScope.bbdstealthclass eq '9' ? 'selected="selected"' : '' }>双周抛</option>
                             <option value="3" ${requestScope.bbdstealthclass eq '3' ? 'selected="selected"' : '' }>月抛</option>
                             <option value="4" ${requestScope.bbdstealthclass eq '4' ? 'selected="selected"' : '' }>季抛</option>
                             <option value="5" ${requestScope.bbdstealthclass eq '5' ? 'selected="selected"' : '' }>半年抛</option>
                             <option value="6" ${requestScope.bbdstealthclass eq '6' ? 'selected="selected"' : '' }>年抛</option>
                             <option value="7" ${requestScope.bbdstealthclass eq '7' ? 'selected="selected"' : '' }>RGP</option>
                             <option value="8" ${requestScope.bbdstealthclass eq '8' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   </select>
			             </TD>
                        </TR>
                        <TR>
			                 <TD  height="26" class="table_body">销售类型</TD>
			                <TD class="table_none" >
	      	                   <input type="checkbox" name="salestype" value="1" >&nbsp;框镜成品
	      	                   <input type="checkbox" name="salestype" value="2" >&nbsp;框镜订制
	      	                   <input type="checkbox" name="salestype" value="3" >&nbsp;隐形成品<br />
	      	                   <input type="checkbox" name="salestype" value="4" >&nbsp;隐形订制
	      	                   <input type="checkbox" name="salestype" value="5" >&nbsp;辅料
			               </TD>
                        	  <TD  height="26" class="table_body">销售人员</TD>
				               <TD class="table_none" >
				               		<input type="text" clean=clean class="text_input160" name="salsepersonname" id="salsepersonname" value="${salsepersonname }" >
				               </TD>
				                <TD  height="26" class="table_body">回访次数</TD>
				                <TD class="table_none" >
				               		<input type="text" clean=clean class="text_input160" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="9" name="huifangcishu" id="huifangcishu" value="${huifangcishu }" >
				               </TD>
                        </TR>
                        <TR>
                        	  <TD  height="26" class="table_body">微信会员</TD>
			               <TD class="table_none" >
			               	<select id="openid" clean=clean name="openid">
                            	<option value="">----请选择----</option>
      		                 	<option value="1" ${requestScope.openid!= "1"  ? '' : 'selected="selected"' }>是</option>
      		                 	<option value="0" ${requestScope.openid!= "0"  ? '' : 'selected="selected"' }>否 </option>
      	                    </select>
			               </TD>
			               <TD  class="table_body " >人群分类</TD>
                          <TD class="table_none "  >
                          <select id="persontype" clean=clean  name="persontype" >
      		                 	<option value="">----请选择----</option>
								<s:iterator value="persontypepolist">
									<option value="${bptid}" ${requestScope.persontype!= bptid  ? '' : 'selected="selected"' }>
										${bptname}
									</option>
								</s:iterator>
      	                    </select>
      	                  </TD>
      	                  <TD  class="table_body " >会员生日</TD>
                          <TD class="table_none "  >
                          		 <li class="horizontal_onlyRight"><input id="srStartTime"
					       name="srStartTime" 
					       type="text" class="text_input80" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'srEndTime\')}', dateFmt:'MM-dd'})" clean=clean
					       value="${srStartTime }" /> 至 <input id="srEndTime"
					       name="srEndTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'srStartTime\')}', dateFmt:'MM-dd'})" clean=clean
					        value="${srEndTime }" />
					        </li>
                          </TD>
                        </TR>
                        <tr>
			               <TD height="26" class="table_body">启用状态</TD>
			               <TD class="table_none">
			               	<select id="customerenable" name="customerenable" clean="clean">
			               		<option value="" ${requestScope.customerenable == ""  ? 'selected="selected"' : '' }>----全部----</option>
								<option value="1" ${customerenable == "1"  ? 'selected="selected"' : '' }>启用</option>			               	
      		                 	<option value="0" ${requestScope.customerenable == "0"  ? 'selected="selected"' : '' }>停用 </option>
      	                    </select>
			               </TD>
			               <TD  height="26" class="table_body">会员备注</TD>
				           <TD class="table_none" colspan="3">
				               	<input type="text" clean=clean class="text_input160" maxlength="1000" name="hyremark" id="hyremark" value="${hyremark }" >
				           </TD>
                        </tr>                        
                      </TBODY>
                    </TABLE>
                    <c:if test="${permissionPo.keyb=='1'}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()" onkeydown="selectmember1()" >
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
								<c:if test="${(permissionPo.keyg==1)}">
				            		<img src="${ctx }/img/newbtn/btn_exportexecl_0.png" btn=btn title='导出EXCEL' onclick="exportCashCoupon()">
				            	</c:if>
								
								<c:if test="${systemParameterPo.fspshortmessage eq '1' || systemParameterPo.fspshortmessage eq '2'}">
								<img src="${ctx }/img/newbtn/btn_sendmessage_0.png" btn=btn title='发送短信' onclick="sendMessage()">
								</c:if>
							</td>							
						</tr>
					</table>
					</c:if>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(customerInfoList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table id="addTable" name="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="9%" scope=col colspan="3">操作</TH>
                          <TH width="13%" height="26" scope=col>会员卡号</TH>
						  <TH width="10%" scope=col>会员姓名</TH>						
						  <TH width="8%" scope=col>会员积分</TH>
						  <TH width="8%" scope=col>会员类型</TH>
						  <TH width="5%" scope=col>性别</TH>
						  <TH width="5%" scope=col>年龄</TH>
						  <TH width="15%" scope=col>联系电话1</TH>
						  <TH width="30%" scope=col>备注</TH>
						  </TR>
						 <s:iterator value="customerInfoList">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD width="3%">
	                          	<c:if test="${permissionPo.keye=='1'}">
		                      	 <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:details('${smecicustomerid}','1')">
			                  	</c:if>
			                  </TD>
			                   
			                  <TD width="3%">
			                  	<c:if test="${permissionPo.keyc=='1'}">
	                             <img btn=btn src="${ctx }/img/newbtn/edit_0.png"  title='修改' onClick="javascript:update('${smecicustomerid}')">
			                  	</c:if>
			                  </TD>
			                  
			                   
			                  <TD width="3%">
			                  	<c:if test="${permissionPo.keyd=='1'}">
	                             <img btn=btn src="${ctx }/img/newbtn/delete_0.png"  title='删除' onClick="javascript:del('${smecicustomerid}')">
			                  	</c:if>
			                  </TD>
	                          <TD height="26">${smecimemberid}</TD>
	                          <TD>${smeciname}</TD>
							  <td>${smeciintegral}</td>
	                          <TD>${fmmmembername}</TD>
	                          <TD>
	                          <c:if test="${smecisex==0}">
	                              	男
	                          </c:if>
	                          <c:if test="${smecisex==1}">
	                             	 女
	                          </c:if>
	                          </TD>
	                          <TD>${fmmage}</TD>
                          	  <TD>${smeciphone}</TD>
                          	  <TD>${smeciremark}</TD>
	                        </TR>
                         </s:iterator>	
                      </TBODY>
                    </TABLE>
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<script>
	initSelectList('departmentid2','departmentid');
	initSelectList('memberoRiginid','memberoRigin');
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>