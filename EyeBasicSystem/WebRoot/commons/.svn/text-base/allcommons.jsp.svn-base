<%@ include file="taglibs.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="shortcut icon" href="${ctx}/img/favicon.ico" type="image/x-icon" />
<link href="<%=request.getContextPath()%>/css/Css.css" type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/Site_Css.css" type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/subModal.css" type="text/css" rel="stylesheet">
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/css/button/style/button.css">
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/css/button/style/icon.css">

<script src="<%=request.getContextPath()%>/js/common.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath()%>/js/orderItem.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath()%>/js/subModal.js" type="text/javascript" charset="utf-8"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.3.2.min.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/css/button/script/button.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/mouseEvent.js"></script>
<script src="<%=request.getContextPath()%>/js/pengsheng-checkform.js" type="text/javascript" charset="utf-8"></script>
<script type='text/javascript' src='${ctx }/js/currentDate.js'></script>
<c:set var="gansuluDepartmentID" value=""/>
<c:set var="reporturl" value=""/>

<c:set var="alertSwitch" value="1"/> <!-- alert  -->
<c:set var="confirmSwitch" value="1"/> <!-- confirm  -->
<c:set var="errorSwitch" value="0"/> <!-- error  -->

<script type="text/javascript" charset="utf-8">
	var isMaxWindowOpen=true;
	function changeShowOrHidden()
	{ 
	    if ($('#showhider').val()=='2')
	    {    	
	        $('#showhider').val('0');
	    }else{   	
	        $('#showhider').val('2')
	        if($("#title1").is(":visible"))
	        {
	        	try{
		        	$("input:text")[0].focus();
				}catch(e){
				}
	        }
	    }
	}
	
	
	$(document).ready(function() {		
		try{  
			if(typeof(eval(initWarehouseList))=="function"){
				initWarehouseList();
			}
		}catch(e){
		}
		
		var showhider = '${showhider}';
		if(showhider == '0'){
			try{
			    searchContentShowOrHidden('title0,title1,title2');
			}catch(e){
				}
			if (document.getElementById("showhider") != null){
		        document.getElementById("showhider").value = '0';
		    }
		}else if(showhider == '2'){		
			if (document.getElementById("showhider") != null){
		        document.getElementById("showhider").value = '2';
		    }
		}else{
		    if (document.getElementById("showhider") != null){
		        document.getElementById("showhider").value = '2';
		    }			
		}	

	});

    
	//天津眼科单据识别码测试打印期间，会员卡
	function printGSL_HYK(memberID,departmentID){
		if('${gansuluDepartmentID}' == 'AllDepartment' || departmentID == '${gansuluDepartmentID}'){
			var DataURL="report.action?reportlet=sales_hydy2.cpt&MemberId="+memberID+"&customerID=";
        	window.open (DataURL, 'gslhuiyuanka', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');			
		}
	}

	//天津眼科单据识别码测试打印期间，挂号费
	function printGSL_GHF(departmentID,id){		
		if('${gansuluDepartmentID}' == 'AllDepartment' || departmentID == '${gansuluDepartmentID}'){
	    	var DataURL='';
	    	DataURL="report.action?reportlet=print_tjykghf.cpt&salseID="+id;
	    	window.open (DataURL, 'gslguahaofei', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
    	}
	}
	
   //天津眼科单据识别码测试打印期间，结款
   function printGSL(departmentID,id,checkflag){
		if('${gansuluDepartmentID}' == 'AllDepartment' || departmentID == '${gansuluDepartmentID}'){
	    	var DataURL='';
	    	DataURL="report.action?reportlet=print_peijingdan_tjykrm.cpt&salesid="+id;
	    	window.open (DataURL, 'gslshoukuan', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	    	if(checkflag=='1'){
	    		DataURL="report.action?reportlet=print_peijingdan_tjykrmdingjin.cpt&wflag=1&salesid="+id;
		    	window.open (DataURL, 'gsldingjin', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');
	    	}	    		
	   	}
	}

   //天津眼科单据识别码测试打印期间，退款
   function printGSL_TH(departmentID,id){		
		if('${gansuluDepartmentID}' == 'AllDepartment' || departmentID == '${gansuluDepartmentID}'){
	    	var DataURL='';
	    	DataURL="report.action?reportlet=print_peijingdan_tjykrmtui.cpt&salesid="+id;
	    	window.open (DataURL, 'gsltuikuan', 'fullscreen=no, top=150,left=150, toolbar=no, menubar=no, scrollbars=yes, location=no, status=no,resizable=yes');	
	   	}
	}
</script>

<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>

<script type='text/javascript' src='${ctx }/js/windowOpen.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />

<style type="text/css">
.autocut{
  width:350;  
  overflow:hidden;  
  white-space:nowrap;  
  text-overflow:ellipsis;  
  -o-text-overflow:ellipsis;  
  -icab-text-overflow: ellipsis;  
  -khtml-text-overflow: ellipsis;  
  -moz-text-overflow: ellipsis;  
  -webkit-text-overflow: ellipsis;   
}

.autocut50{
  width:100;  
  overflow:hidden;  
  white-space:nowrap;  
  text-overflow:ellipsis;  
  -o-text-overflow:ellipsis;  
  -icab-text-overflow: ellipsis;  
  -khtml-text-overflow: ellipsis;  
  -moz-text-overflow: ellipsis;  
  -webkit-text-overflow: ellipsis;   
}

.autocut80{
  width:160;  
  overflow:hidden;  
  white-space:nowrap;  
  text-overflow:ellipsis;  
  -o-text-overflow:ellipsis;  
  -icab-text-overflow: ellipsis;  
  -khtml-text-overflow: ellipsis;  
  -moz-text-overflow: ellipsis;  
  -webkit-text-overflow: ellipsis;   
}

.autocut100{
  width:200;  
  overflow:hidden;  
  white-space:nowrap;  
  text-overflow:ellipsis;  
  -o-text-overflow:ellipsis;  
  -icab-text-overflow: ellipsis;  
  -khtml-text-overflow: ellipsis;  
  -moz-text-overflow: ellipsis;  
  -webkit-text-overflow: ellipsis;   
}
</style>