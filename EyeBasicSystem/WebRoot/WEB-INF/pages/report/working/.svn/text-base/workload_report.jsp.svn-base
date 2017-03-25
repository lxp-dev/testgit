<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表中心</title>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
</head>
<script>	
	function search(){
		if(!is_iPad()){
			createForm();
		}
		
		var ShopCode = $('#departmentID').val();
		if(ShopCode == ''){
			ShopCode = $("#dids").val()
		}
		
		var BeginDate = document.all.startTime2.value;
		var End = document.all.endTime2.value;
		var isShow = $('input[name=isShow2]:checked').val();
		var queryClassify = $('input[name=queryClassify2]:checked').val();
		var showCompanyName = $( 'input[name=showCompanyName2]:checked').val();
		var queryWay = $('input[name=queryWay2]:checked').val();
		var lookWay = $('input[name=lookWay2]:checked').val();
		var customAmountForm = $('input[name=customAmountForm2]:checked').val();
		var queryPersonID = $.trim($('#queryPersonID2').val());
        var countperfrom=$("#countperfrom2").val();
        var companyid = $("#companysid").val();
        $('input[name=countperfrom]').get(0).value = countperfrom;
        $('input[name=companyid]').get(0).value = companyid;

		if(queryClassify == "" || queryClassify == null){
			alert('请选择查询分类!');
			return false;
		}
		if(queryWay == "" || queryWay == null){
			alert('请选择查询方式!');
			return false;
		}
		if(lookWay == "" || lookWay == null){
			alert('请选择查看分类!');
			return false;
		}
		if(BeginDate==""){
			alert('请选择起始查询日期!');
			document.all.startTime2.focus();
			return false;
		}
		if(End==""){
			alert('请选择截止查询日期!');
			document.all.endTime2.focus();
			return false;
		}

		var customAmountText = '';
        switch(customAmountForm){
        case '1':
        	customAmountText = '订金按应收金额计入结款日收入,商品金额计入结款日收入';
            break;
        case '2':
        	customAmountText = '订金按应收金额计入补齐日收入,商品金额计入补齐日收入';
            break;
        case '3':
        	customAmountText = '订金结款日收入,补齐金额计入补齐日收入,商品金额计入结款日收入';
            break;  
        default:
	        return;
        }
        
		var ShopCodeName=document.getElementById("bdpdepartmentname").value;
		if (ShopCodeName == ''){
			if($("#dnames").val() == ''){
				ShopCodeName = '所有部门';
			}else{
				ShopCodeName = $("#dnames").val();
			}
		}
		var queryWayText = queryWay == '1' ? '按部门' : '按人员';
		var lookWayText = lookWay == '1' ? '按数据列表' : '按图表';
		
        var reportUrl = "&logincompanyid="+'${person.personcompanyid}'+"&companyid="+companyid+"&showCompanyName="+showCompanyName+"&customAmountName="+EncodeUtf8(customAmountText)+"&ShopCodeName="+EncodeUtf8(ShopCodeName)+"&queryWay="+EncodeUtf8(queryWayText)+"&lookWay="+EncodeUtf8(lookWayText)+"&isShow="+isShow;
        $('input[name=showCompanyName]').get(0).value = showCompanyName;
        $('input[name=customAmountName]').get(0).value = customAmountText;
        $('input[name=ShopCodeName]').get(0).value = ShopCodeName;
        $('input[name=queryWay]').get(0).value = queryWayText;
        $('input[name=lookWay]').get(0).value = lookWayText;
        $('input[name=isShow]').get(0).value = isShow;
        $('input[name=logincompanyid]').get(0).value = '${person.personcompanyid}';

		var reportName = '';
		var reportParem = '';
		var formAction = '';
        switch(queryClassify){
	        case '1':
	            if (queryWay == '1'){   // 验光师
	            	reportName = "sales_optometryWorkManyStoreRpt.cpt";
	            	reportParem = "departmentid="+ShopCode+"&bgndate="+BeginDate+"&enddate="+End;
	            	formAction = "ygs1";
	            }else{
	            	reportName = "sales_optometryWorkOnlyStoreRpt.cpt";
	            	reportParem = "departmentid="+ShopCode+"&bgndate="+BeginDate+"&enddate="+End+"&queryPersonID="+queryPersonID;
	            	formAction = "ygs2";
		            $('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=departmentid]').get(0).value = ShopCode;
	            $('input[name=bgndate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;           
	            
	            break;
	        case '2':      // 营业员
	            if (queryWay == '1'){
	                switch(customAmountForm){
		    	        case '1':
		    	        	reportName = "sales_salesPersonManyStoreRpt.cpt"; 
		    	            formAction = "yyy11";
		    	            break;
		    	        case '2':
		    	        	reportName = "sales_salesPersonManyStoreRpt2.cpt";
		    	            formAction = "yyy12";  
		    	            break;
		    	        case '3':
		    	        	reportName = "sales_salesPersonManyStoreRpt3.cpt"; 
		    	            formAction = "yyy13"; 
		    	            break;  
		    	        default:
		    		        return;
                    }
            	    reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End;
	            }else{	            	
	                switch(customAmountForm){
		    	        case '1':
		    	        	reportName = "sales_salesPersonOnlyStoreRpt.cpt"; 
				            formAction = "yyy21";
		    	            break;
		    	        case '2':
		    	        	reportName = "sales_salesPersonOnlyStoreRpt2.cpt";
				            formAction = "yyy22";  
		    	            break;
		    	        case '3':
		    	        	reportName = "sales_salesPersonOnlyStoreRpt3.cpt";
				            formAction = "yyy23";  
		    	            break;  
		    	        default:
		    		        return;
	                }
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;

	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=begDate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break; 
	        case '3':      // 收银员
	            if (queryWay == '1'){
	                switch(customAmountForm){
		    	        case '1':
		    	        	reportName = "sales_CashierManyStoreRpt.cpt"; 
		    	            formAction = 'syy11';
		    	            break;
		    	        case '2':
		    	        	reportName = "sales_CashierManyStoreRpt2.cpt";
		    	            formAction = 'syy12';  
		    	            break;
		    	        case '3':
		    	        	reportName = "sales_CashierManyStoreRpt3.cpt";
		    	            formAction = 'syy13';  
		    	            break;  
		    	        default:
		    		        return;
                    }
            	    reportParem = "departmentid="+ShopCode+"&startTime="+BeginDate+"&endTime="+End+"&begDate="+BeginDate+"&endDate="+End+"&countperfrom="+countperfrom;

	            }else{	            	
	                switch(customAmountForm){
		    	        case '1':
		    	        	reportName = "sales_CashierOnlyStoreRpt.cpt";
				            formAction = 'syy21'; 
		    	            break;
		    	        case '2':
		    	        	reportName = "sales_CashierOnlyStoreRpt2.cpt";
				            formAction = 'syy22';  
		    	            break;
		    	        case '3':
		    	        	reportName = "sales_CashierOnlyStoreRpt3.cpt";
				            formAction = 'syy23';  
		    	            break;  
		    	        default:
		    		        return;
	                }
	            	reportParem = "departmentid="+ShopCode+"&startTime="+BeginDate+"&endTime="+End+"&queryPersonID="+queryPersonID+"&countperfrom"+countperfrom;

	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=departmentid]').get(0).value = ShopCode;
	            $('#rptFrm input[id=startTime]').get(0).value = BeginDate;
	            $('#rptFrm input[id=endTime]').get(0).value = End;

	            break;
	        case '4':     //  挂号台
	            if (queryWay == '1'){
	            	reportName = "sales_registrationDeskManyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End;
	            	formAction = 'ght1';
	            }else{
	            	reportName = "sales_registrationDeskOnlyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;
	            	formAction = 'ght2';
	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=begDate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break;
	        case '5':     // 检查人员
	            if (queryWay == '1'){
	            	reportName = "sales_inspectPersonManyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End;
	            	formAction = 'jcry1';
	            }else{
	            	reportName = "sales_inspectPersonOnlyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;
	            	formAction = 'jcry2';
	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=begDate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break;
	        case '6':    // 取镜人员
	            if (queryWay == '1'){
	            	reportName = "sales_getBackEyeglassPersonManyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End;
		            formAction = 'qjry1';
	            }else{
	            	reportName = "sales_getBackEyeglassPersonOnlyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;
		            formAction = 'qjry2';
	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=begDate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break;
	        case '7':    // 发料人员
	            if (queryWay == '1'){
	            	reportName = "process_sendMaterialManyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End;
		            formAction = 'flry1';
	            }else{
	            	reportName = "process_sendMaterialOnlyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;
		            formAction = 'flry2';
	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=begDate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break;
	        case '8':     // 初检
	            if (queryWay == '1'){
	            	reportName = "process_firstCheckManyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End;
		            formAction = 'cj1';
	            }else{
	            	reportName = "process_firstCheckOnlyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;
		            formAction = 'cj2';
	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=begDate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break;
	        case '9':     // 加工
	            if (queryWay == '1'){
		            if($('#jiagongtype').val()==1){
	            		reportName = "process_processWorkingManyStoreRpt.cpt";
		            }else{
		            	reportName = "sales_anydatesalesamount12.cpt";
		            }
	            	reportParem = "shopCode="+ShopCode+"&bgnDate="+BeginDate+"&endDate="+End;
		            formAction = 'jg1';
	            }else{
	            	reportName = "process_processWorkingOnlyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&bgnDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;
		            formAction = 'jg2';
	            	//$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=bgndate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break;
	        case '10':     // 质检人员
	            if (queryWay == '1'){
	            	reportName = "process_endCheckManyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End;
		            formAction = 'zj1';
	            }else{
	            	reportName = "process_endCheckOnlyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;
		            formAction = 'zj2';
	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=begDate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break;
	        case '11':    // 配送人员
	            if (queryWay == '1'){
	            	reportName = "process_peisongManyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End;
		            formAction = 'psry1';
	            }else{
	            	reportName = "process_peisongOnlyStoreRpt.cpt";
	            	reportParem = "shopCode="+ShopCode+"&begDate="+BeginDate+"&endDate="+End+"&queryPersonID="+queryPersonID;
		            formAction = 'psry2';
	            	$('input[name=queryPersonID]').get(0).value = queryPersonID;
	            }

	            $('input[name=shopCode]').get(0).value = ShopCode;
	            $('input[name=begDate]').get(0).value = BeginDate;
	            $('input[name=endDate]').get(0).value = End;
	            
	            break;                                                                                       
	        default:
		        return;
        }

		var DataURL = "report.action?reportlet=" + reportName +"&__bypagesize__=false" + "&" + reportParem + reportUrl;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{

			DataURL = "report.action?reportlet=" + reportName+"&__bypagesize__=false";
			queryReport(DataURL,formAction);

			return;
			
		}		
		document.getElementById('popupTitle').innerHTML="【工作量表 】";
	}

	function createForm(){
		
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";  
		rptFrm.method = "post";    

	    var departmentid = document.createElement("input");	     
	    departmentid.type = "hidden";
	    departmentid.name = "departmentid";
	    departmentid.value = '';	  
	    rptFrm.appendChild(departmentid);  

	    var bgndate = document.createElement("input");	     
	    bgndate.type = "hidden";
	    bgndate.name = "bgndate";
	    bgndate.value = '';	  
	    rptFrm.appendChild(bgndate); 

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.name = "endDate";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate);  

	    var shopCode = document.createElement("input");	     
	    shopCode.type = "hidden";
	    shopCode.name = "shopCode";
	    shopCode.value = '';	  
	    rptFrm.appendChild(shopCode);  

	    var begDate = document.createElement("input");	     
	    begDate.type = "hidden";
	    begDate.name = "begDate";
	    begDate.value = '';	  
	    rptFrm.appendChild(begDate); 

	    var queryPersonID = document.createElement("input");	     
	    queryPersonID.type = "hidden";
	    queryPersonID.name = "queryPersonID";
	    queryPersonID.value = '';	  
	    rptFrm.appendChild(queryPersonID);    

	    var startTime = document.createElement("input");	     
	    startTime.type = "hidden";
	    startTime.id = "startTime";
	    startTime.name = "startTime";
	    startTime.value = '';	  
	    rptFrm.appendChild(startTime);  

	    var endTime = document.createElement("input");	     
	    endTime.type = "hidden";
	    endTime.id = "endTime";
	    endTime.name = "endTime";
	    endTime.value = '';	  
	    rptFrm.appendChild(endTime); 
	    
	    var showCompanyName = document.createElement("input");	     
	    showCompanyName.type = "hidden";
	    showCompanyName.name = "showCompanyName";
	    showCompanyName.value = '';	  
	    rptFrm.appendChild(showCompanyName);    

	    var customAmountName = document.createElement("input");	     
	    customAmountName.type = "hidden";
	    customAmountName.name = "customAmountName";
	    customAmountName.value = '';	  
	    rptFrm.appendChild(customAmountName);  

	    var ShopCodeName = document.createElement("input");	     
	    ShopCodeName.type = "hidden";
	    ShopCodeName.name = "ShopCodeName";
	    ShopCodeName.value = '';	  
	    rptFrm.appendChild(ShopCodeName); 

	    var queryWay = document.createElement("input");	     
	    queryWay.type = "hidden";
	    queryWay.name = "queryWay";
	    queryWay.value = '';	  
	    rptFrm.appendChild(queryWay);    

	    var lookWay = document.createElement("input");	     
	    lookWay.type = "hidden";
	    lookWay.name = "lookWay";
	    lookWay.value = '';	  
	    rptFrm.appendChild(lookWay);  

	    var isShow = document.createElement("input");	     
	    isShow.type = "hidden";
	    isShow.name = "isShow";
	    isShow.value = '';	  
	    rptFrm.appendChild(isShow); 

	    var countperfrom = document.createElement("input");	     
	    countperfrom.type = "hidden";
	    countperfrom.name = "countperfrom";
	    countperfrom.value = '';	  
	    rptFrm.appendChild(countperfrom);
		
		var companyid = document.createElement("input");	     
	    companyid.type = "hidden";
	    companyid.name = "companyid";
	    companyid.value = '';	  
	    rptFrm.appendChild(companyid);
	    
	    var logincompanyid = document.createElement("input");	     
	    logincompanyid.type = "hidden";
	    logincompanyid.name = "logincompanyid";
	    logincompanyid.value = '';	  
	    rptFrm.appendChild(logincompanyid);
		
	    document.body.appendChild(rptFrm);
    }
    
	function queryReport(DataURL,formAction){
		
		var rptFrm = document.getElementById('rptFrm');
		rptFrm.action = DataURL;    
		rptFrm.target = formAction;    

		var handler = function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}
		if (rptFrm.attachEvent){
			rptFrm.attachEvent("onsubmit",handler); 		  
		}else{
			rptFrm.addEventListener("onsubmit",handler); 		  
		}
	
		if (rptFrm.fireEvent){
			rptFrm.fireEvent("onsubmit");	
		}else{
			rptFrm.removeEventListener("onsubmit",handler, false);	
		}         

	    rptFrm.submit();  
	  
	    document.body.removeChild(rptFrm); 
    }
	
	function clean(){
		goodsForm.reset();
		$("input[type=radio]").eq(0).attr("checked","checked");
		today('startTime2','endTime2');
		$('#subscriptionTab').hide();
		$('#jiagongs').hide();
	}
	
	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var companyid = $("#companysid").val();
		var queryClassify = $('input[name=queryClassify2]:checked').val();
		var queryWay = $('input[name=queryWay2]:checked').val();
		
		var departmentType = "1";
        if (queryClassify == '8' || queryClassify == '10' ){
        	departmentType = "2";
        }
        if (queryClassify == '7' || queryClassify == '11' ){
        	departmentType = "";
        }
		if(queryClassify == '9' ){
			if($('#jiagongtype').val()==1){
				departmentType = "2";
			}else{
				departmentType = "1";
			}
		}
		if(queryClassify == "" || queryClassify == null){
			alert('请选择查询分类!');
			return false;
		}
		if(queryWay == "" || queryWay == null){
			alert('请选择查询方式!');
			return false;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType="+departmentType+"&isclosed=0&companyid="+companyid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType="+departmentType+"&isclosed=0&companyid="+companyid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var arrayID = new Array();
		var arrayName = new Array();
		var departments = eval('(' + objValue + ')');
		for(var i = 0; i < departments.length; i++){	
			arrayID[i] = departments[i].bdpdepartmentid;
			arrayName[i] = departments[i].bdpdepartmentname;
		}

		$('#departmentID').val(arrayID.join(","));
		document.getElementById('bdpdepartmentname').value = arrayName.join(",");
		document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
	}

	$(document).ready(function() {
		$("input[type=radio]").eq(0).attr("checked","checked");
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    	$(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	    	$(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 

	    if ('${permissionPo.keyd}' != '1' && '${permissionPo.keye}' != '1'){
		    $('#subscriptionTab').hide();
		}

	    $('#personTab').hide();
	    $('#jiagongs').hide();  
	    
        if('${person.personcompanytype}' == '2'){
        	loadDepartmentids('${person.personcompanyid}');
        }
    }); 

	function cleanDepartment(){
		var queryClassify = $('input[name=queryClassify2]:checked').val();
        if (queryClassify == '2' || queryClassify == '3'){
        	$('#subscriptionTab').show();
        	$('#jiagongs').hide();
        }else{
        	$('#subscriptionTab').hide();
        	if(queryClassify == '9' ){
        		 if ($('input[name=queryWay2]:checked').val() == '1'){
        			$('#jiagongs').show();
        		 }else{
        			 $('#jiagongs').hide();
        		 }
        	}else{
        		$('#jiagongs').hide();
        	}
        }
        $("#customAmount" + '${systemParameterPo.fspcustomamount}').attr('checked','checked');
        showQuartzInfo(queryClassify);	
        
        loadDepartmentids($("#companysid").val());
    }

    function cleanPerson(){
    	var queryClassify = $('input[name=queryClassify2]:checked').val();
        if ($('input[name=queryWay2]:checked').val() == '1'){
        	$('#queryPersonID2').val('');
        	$('#personTab').hide();    
        	if(queryClassify == '9' ){
        		$('#jiagongs').show();
        	}	
        }else{
        	if('${person.departmenttype }'  != '1' && '${person.departmenttype }'  != '2'){
	        	<c:if test="${person.personcompanytype == '1'}">
	        	$("#bdpdepartmentname").val("");
	        	$("#ds").val("");
	        	$("#departmentID").val("");
	        	$("#companysid").val("");
	        	</c:if>  
        	}
        	$("#jiagongtype").val("1");
        	$('#personTab').show();
        	 $('#jiagongs').hide();
             <c:if test="${permissionPo.keyr == '1'}">
               $('#queryPersonID2').val('${person.id}'); 
             </c:if>  
        }
    }

    function help(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWorkLoadReportHelpSel.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			window.open('initWorkLoadReportHelpSel.action?moduleID=${requestScope.moduleID}','','toolbar=0,directories=0,status=0,menubar=0,scrollbars=yes,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-100));
		}
		document.getElementById('popupTitle').innerHTML="【报表使用说明 】";
    }
    
	$(document).ready(function() { 
		today('startTime2','endTime2');
    	$('#personTab').show();
    	showQuartzInfo($('input[name=queryClassify2]:checked').val());
	});

	function showQuartzInfo(flag){
		$('div[class=reportHelp]').hide(); 
		
        if (flag == '1'){
        	$('div[class=reportHelp][id=ygs]').show();      
        }
        if (flag == '2'){
        	$('div[class=reportHelp][id=yyy]').show();      
        } 
        if (flag == '3'){
        	$('div[class=reportHelp][id=syy]').show();      
        } 
        if (flag == '5'){
        	$('div[class=reportHelp][id=jcry]').show();      
        }  
        if (flag == '6'){
        	$('div[class=reportHelp][id=qjry]').show();      
        } 
        if (flag == '7'){
        	$('div[class=reportHelp][id=flry]').show();      
        }   
        if (flag == '9'){
        	$('div[class=reportHelp][id=jgry]').show();      
        }             
    }
    
    function loadDepartmentids(cid) { 
    	var queryClassify = $('input[name=queryClassify2]:checked').val();
		
		var departmentType = "1";
        if (queryClassify == '8' || queryClassify == '10' ){
        	departmentType = "2";
        }
        if (queryClassify == '7' || queryClassify == '11' ){
        	departmentType = "";
        }
		if(queryClassify == '9' ){
			if($('#jiagongtype').val()==1){
				departmentType = "2";
			}else{
				departmentType = "1";
			}
		}
     
		if(cid == ''){
			$("#departmentID").val('');
	   		$("#bdpdepartmentname").val('');
	   		$("#ds").val('');
	   		$("#dids").val('');
			$("#dnames").val('');
		}else{
			$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "getAjaxDepartmentForCompanyID.action",          
	   	   	    async: true, 
	   	   	    data: "companysid="+cid+"&type="+departmentType,     
	   	   	    success: function(msg){
	   	   	    	var item = msg.split("/");
	                <c:if test="${person.departmenttype!=1}">
	                	$("#departmentID").val(item[0]);
	   	   	    		$("#bdpdepartmentname").val(item[1]);
	   	   	    		$("#ds").val(item[1]);
	   	   	    		$("#dids").val(item[0]);
	   	   	    		$("#dnames").val(item[1]);
					</c:if>  
	   	   	    }
			});
		}
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form id="goodsForm" name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="dids" name="dids" value="">
<input type="hidden" id="dnames" name="dnames" value="">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>工作量类报表</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：工作量表</TD>
            <TD align=right>
                <img src="${ctx }/img/newbtn/reporthelp_0.png" btn=btn title='帮助' onclick="help();">	
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD class="table_body" height="26">查询分类</TD>
			               <TD class="table_none" colspan="3">
			               <c:if test="${permissionPo.keyd == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="2" onclick="cleanDepartment();"/><a title="可查询实时数据">营业员</a>&nbsp;
                           </c:if>
                           <c:if test="${permissionPo.keye == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="3" onclick="cleanDepartment();"/><a title="可查询实时数据">收银员</a>&nbsp;
                           </c:if>
			               <c:if test="${permissionPo.keyc == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="1" onclick="cleanDepartment();"/><a title="可查询实时数据">验光师</a>&nbsp;
                           </c:if>

                           <!--
                           <c:if test="${permissionPo.keyf == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="4" onclick="cleanDepartment();"/>挂号台&nbsp;
                           </c:if>
                           -->
                           <c:if test="${permissionPo.keyg == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="5" onclick="cleanDepartment();"/><a title="可查询实时数据">检查人员</a>&nbsp;
                           </c:if>
                           <c:if test="${permissionPo.keyh == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="6" onclick="cleanDepartment();"/><a title="可查询实时数据">取镜人员</a>&nbsp;
                           </c:if>
                           <c:if test="${person.departmenttype!=1}">
                           <c:if test="${permissionPo.keyi == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="7" onclick="cleanDepartment();"/><a title="可查询实时数据">发料人员</a>&nbsp;
                           </c:if>
                           <c:if test="${permissionPo.keyj == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="8" onclick="cleanDepartment();"/><a title="可查询实时数据">初检人员</a>&nbsp;  
                           </c:if>
                           <c:if test="${permissionPo.keyk == '1'}">
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="9" onclick="cleanDepartment();"/><a title="可查询实时数据">加工人员</a>&nbsp;
                           </c:if>
                           <c:if test="${permissionPo.keyl == '1'}">                      
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="10" onclick="cleanDepartment();"/><a title="可查询实时数据">质检人员</a>&nbsp;
                           </c:if>
                           </c:if>
                           <c:if test="${permissionPo.keym == '1'}">   
                               <input type="radio" id="queryClassify2" name="queryClassify2" value="11" onclick="cleanDepartment();"/><a title="可查询实时数据">配送人员</a>
                           </c:if>                                                
                           <label style="color:red;">&nbsp;*&nbsp;</label> 
                           <input type="hidden" name="countperfrom2" id="countperfrom2" value="${systemParameterPo.fspiscountperfrom}">                                                    
			               </TD>
                        </TR>
                        <TR>
			               <TD class="table_body" height="26">查询方式</TD>
			               <TD class="table_none">
			                   <c:if test="${permissionPo.keyn == '1'}">   
                                   <input type="radio" id="queryWay2" name="queryWay2" value="1" onclick="cleanPerson();"/>按部门&nbsp;
                               </c:if>
                               <c:if test="${permissionPo.keyo == '1'}">   
                                   <input type="radio" id="queryWay2" name="queryWay2" value="2" onclick="cleanPerson();" checked="checked">按人员
                               </c:if>
                               <label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>
			               <TD class="table_body" height="26">查看分类</TD>
			               <TD class="table_none">
			                   <c:if test="${permissionPo.keyp == '1'}">   
                                   <input type="radio" id="lookWay2" name="lookWay2" value="1" checked="checked"/>按数据列表&nbsp;
                               </c:if>

                               &nbsp;
			               </TD>
                        </TR>
                        <TR>
						   <TD width="10%" height="26" class="table_body">所属公司</TD>
			               <TD height="26" class="table_none" colspan="3">
			                <c:if test="${person.personcompanytype eq '2'}">
			                	${person.personcompanyname }
	                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        </c:if>
	                        
	                        <c:if test="${person.personcompanytype ne '2'}">
	                        	<c:if test="${person.departmenttype!=1}">
							   		<select clean="clean" id="companysid" name="companysid" onchange="loadDepartmentids(this.options[this.options.selectedIndex].value)" >
		                              <option value="">----请选择----</option>
		                              <s:iterator value="companyNamePos">
		                              <option value="${fcnId}" ctype="${fcnmasterorvice }" ${companysid == fcnId ? 'selected="selected"':''}>${fcnName}</option>
		                              </s:iterator>
		                            </select>
								</c:if>  
							    <c:if test="${person.departmenttype==1}">
		                            ${person.personcompanyname }
		                        	<input type="hidden" id="companysid" name="companysid" value="${person.personcompanyid }">
	                        	</c:if>
	                        </c:if>
                           </TD>
                        </TR>
                       <TR>
						   <TD width="10%" height="26" class="table_body">查询部门</TD>
			               <TD class="table_none" width="40%">
			               <input type="hidden" name="nnd" id="nnd" value="${person.departmenttype}"/>
		               <c:if test="${person.departmenttype!=1}">
			               <li class="horizontal_onlyRight">
						   		<input class="text_input300" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" value="${personInfoPo.bdpdepartmentname }" type="hidden" />
						   		<textarea class="text_input200" id="ds"  name="ds" style='height:50px;width: 300px' readonly="readonly" ></textarea>
						   		
						   		<input type="hidden" id="departmentID" name="personInfoPo.departmentID" value="${personInfoPo.departmentID }"
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择查询部门！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">						  		
						  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
						  		</li>
						</c:if>  
						   <c:if test="${person.departmenttype == 1 }">
                            ${person.bdpdepartmentname}<input type="hidden" name="departmentID2" value="${person.departmentID}" id="departmentID"/>
                            <input class="text_input300" id="bdpdepartmentname" name="personInfoPo.bdpdepartmentname" value="${person.bdpdepartmentname }" type="hidden" />
      	                   </c:if>
						  
						  </TD>
						  <TD class="table_body">查询日期</TD>
			               <TD class="table_none">
                               <jsp:include page="/commons/report_date.jsp" flush="true">
                                    <jsp:param name="fromDate" value="startTime2"/> 
                                    <jsp:param name="toDate" value="endTime2"/>             
                               </jsp:include>
                               <label style="color:red;">&nbsp;*&nbsp;</label>
			               </TD>
                        </TR>
                       <c:if test="${permissionPo.keyr != '1'}"> 
                        <TR id="personTab">
			               <TD class="table_body" height="26">人员工号</TD>
			               <TD class="table_none" colspan="3">
                                <input type="text" name="queryPersonID2" id="queryPersonID2"/>
			               </TD>
                        </TR>
                        </c:if>
                        <c:if test="${permissionPo.keyr == '1'}"> 
                            <input type="hidden" name="queryPersonID2" id="queryPersonID2" value="${person.id}"/>
                        </c:if>
                         <TR id="jiagongs">
			               <TD class="table_body" height="26">报表类型</TD>
			               <TD class="table_none" colspan="3">
                                <select id="jiagongtype" name="jiagongtype">
                                	<option value="1">加工部门</option>
                                	<option value="2">销售部门</option>
                                </select>
			               </TD>
                        </TR>
                        <TR id="subscriptionTab">
                           <TD height="78" class="table_body">订金方式</TD>
			               <TD class="table_none" colspan="5">
                               <input type="radio" name="customAmountForm2" id="customAmount1" value="1" ${systemParameterPo.fspcustomamount eq '1' ? "checked" : "" }>订金按应收金额计入结款日收入,商品金额计入结款日收入<br/>
                               <input type="radio" name="customAmountForm2" id="customAmount2" value="2" ${systemParameterPo.fspcustomamount eq '2' ? "checked" : "" }>订金按应收金额计入补齐日收入,商品金额计入补齐日收入<br/>
                               <input type="radio" name="customAmountForm2" id="customAmount3" value="3" ${systemParameterPo.fspcustomamount eq '3' ? "checked" : "" }>订金结款日收入,补齐金额计入补齐日收入,商品金额计入结款日收入<br/>
			               </TD>
                        </TR>
                        <TR>
			               <TD class="table_body" height="26">显示查询条件</TD>
			               <TD class="table_none">
                               <input type="radio" id="isShow2" name="isShow2" value="0" ${systemParameterPo.fspshowrptcondition eq 0 ? "checked" : "" }/>是
                               <input type="radio" id="isShow2" name="isShow2" value="1" ${systemParameterPo.fspshowrptcondition eq 1 ? "checked" : "" }/>否
			               </TD>
			               <TD class="table_body" height="26">显示公司名称</TD>
			               <TD class="table_none">
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="1" checked="checked"/>是
                               <input type="radio" id="showCompanyName2" name="showCompanyName2" value="2"/>否
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr>
							<td height="26">
							<c:if test="${permissionPo.keya == '1'}">   
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" >	
							</c:if>						
							</td>
						</tr>
					</table>
		    <c:if test="${systemParameterPo.fspreporthelpshow eq '1'}">		
					<br/><br/>
					<div class="reportHelp" id="yyy">												
                                                             如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【营业员工作量统计】这个定时任务重新汇总数据。<br/>
					</div>
					<div class="reportHelp" id="syy">												
                                                             如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【收银员工作量统计】这个定时任务重新汇总数据。<br/>
					</div>
					<div class="reportHelp" id="ygs">												
                                                             如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【验光师工作量统计】这个定时任务重新汇总数据。<br/>
					</div>
					<div class="reportHelp" id="jcry">												
                                                             如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【检查人员工作量统计】这个定时任务重新汇总数据。<br/>
					</div>	
					<div class="reportHelp" id="qjry">												
                                                             如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【取镜人员工作量统计】这个定时任务重新汇总数据。<br/>
					</div>
					<div class="reportHelp" id="jgry">												
                                                             如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【加工人员工作量统计】这个定时任务重新汇总数据。<br/>
					</div>
					<div class="reportHelp" id="flry">												
                                                             如果需要重新汇总数据，可以进入【定时任务维护】模块，通过【发料人员工作量统计】这个定时任务重新汇总数据。<br/>
					</div>																																					
			</c:if>	
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
