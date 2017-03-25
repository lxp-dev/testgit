<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/zone.js"></script>
<title>会员回访管理</title>
</head>
<script>	
	$(document).ready(function() {
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

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerInfoForm.action=link;
	  	customerInfoForm.submit();
		showLoadingBar();
	}
	function returnVisit(smecvsalesid){
		document.all.hid.value = smecvsalesid;
		var moduleID = document.all.moduleID.value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCustomerReturnVisitIns.action?smecvsalesid="+smecvsalesid+"&moduleID="+moduleID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initCustomerReturnVisitIns.action?smecvsalesid="+smecvsalesid+"&moduleID="+moduleID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员回访信息新增】";
	}	
	
	
	function returnDetails(smecvsalesid){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("insertCustomerReturnDetails.action?smecvsalesid="+smecvsalesid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("insertCustomerReturnDetails.action?smecvsalesid="+smecvsalesid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员回访信息详细】";
	}
	

	function search(){
		var salestypeid="";
		$("input[name=salestype]").each(function(){
			if($(this).attr("checked")){
				salestypeid=salestypeid+","+$(this).val();
			}
		});
		$("img").removeAttr("onclick");
		customerInfoForm.action = "selectCustomerReturnVisit.action?salestypeid="+salestypeid;
		customerInfoForm.submit();
		showLoadingBar();
	}

	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });		
        $("input[name=salestype]").each(function(){
			$(this).attr("checked",false);
		}); 
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
	
	
	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
	
	function today1(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime1').value = now;
		document.getElementById('endTime1').value = now;		
	}

	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	
	function today2(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('takeTimeStart').value = now;
		document.getElementById('takeTimeEnd').value = now;		
	}
	
	function today3(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('returnDateStart').value = now;
		document.getElementById('returnDateEnd').value = now;		
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()"  onhelp="Showhelp();return false;"' : '' }>
<form name="customerInfoForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：会员回访管理</TD>
            <td align="right" valign="bottom">&nbsp;
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
				</TD></TR>
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
						   <TD width="9%" height="26" class="table_body">人群类型</TD>
			               <TD class="table_none" width="28%">
                            <select  clean=clean id="smecvcustomertype" name="smecvcustomertype">
                            	<option value="">----请选择----</option>
      		                 	<option value="1" ${requestScope.smecvcustomertype!= "1"  ? '' : 'selected="selected"' }>普通</option>
      		                 	<option value="2" ${requestScope.smecvcustomertype!= "2"  ? '' : 'selected="selected"' }>高档</option>
      		                 	<option value="3" ${requestScope.smecvcustomertype!= "3"  ? '' : 'selected="selected"' }>青少年渐进</option>
      		                 	<option value="4" ${requestScope.smecvcustomertype!= "4"  ? '' : 'selected="selected"' }>成人渐进</option>
      	                    </select>
			               </TD>
			                <TD height="26" width="8%" class="table_body">回访时间</TD>
			               <TD class="table_none" width="28%">
			               <li class="horizontal_onlyRight">
                            <input clean=clean id="returnDateStart"
					       name="returnDateStart" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'returnDateEnd\')}'})"
					       value="${requestScope.returnDateStart}" /> 至 
					       <input clean=clean id="returnDateEnd"
					       name="returnDateEnd" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'returnDateStart\')}'})" 
					        value="${requestScope.returnDateEnd}" />
					       </li>
					       <li class="horizontal_onlyRight">
					  	   <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today3()">
					  	   </li>
			               </TD>
			               <TD width="8%" height="26" class="table_body">回访类型</TD>
			               <TD class="table_none">
                             <select clean=clean id="smecvreturntype" name="smecvreturntype">
                            	<option value="">----请选择----</option>
      		                 	<option value="0" ${requestScope.smecvreturntype!= "0"  ? '' : 'selected="selected"' }>未回访</option>
      		                 	<option value="1" ${requestScope.smecvreturntype!= "1"  ? '' : 'selected="selected"' }>已回访</option>
      	                    </select>
			               </TD>
                        </TR>
                         <TR>
                           
                           <TD height="26" class="table_body">会员满意度</TD>
			               <TD class="table_none">
                            <select clean=clean id="smecvcontentment" name="smecvcontentment">
                             <option value="">----请选择----</option>
      		                 <c:if test="${not empty(satisfactionList)}">
				               	  <s:iterator value="satisfactionList">
                    	           <OPTION value="${fcsid}" ${requestScope.smecvcontentment!= fcsid  ? '' : 'selected="selected"' } >${fcsname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">取镜时间</TD>
			               <TD  clean=clean class="table_none">
			               <li class="horizontal_onlyRight">
                            <input id="takeTimeStart" clean=clean 
					       name="takeTimeStart" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'takeTimeEnd\')}'})"
					       value="${requestScope.takeTimeStart}" /> 至 
					       <input clean=clean id="takeTimeEnd"
					       name="takeTimeEnd" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'takeTimeStart\')}'})" 
					        value="${requestScope.takeTimeEnd}" /></li>
					       <li class="horizontal_onlyRight">
					  	   <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today2()">
					  	   </li>
			               </TD>
			                <TD height="26" class="table_body">销售单号</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="saleid" name="saleid" value="${requestScope.saleid}"/>
			               </TD>
                        </TR>
                          <TR>
						   <TD width="9%" height="26" class="table_body">会员卡号</TD>
			               <TD class="table_none" width="28%">
                            <input clean=clean class="text_input160" type="text"  id="memberid" name="memberid" value="${requestScope.memberid}"/>
			               </TD>
			               <TD width="8%" height="26" class="table_body">会员姓名</TD>
			               <TD class="table_none" width="28%">
                             <input clean=clean class="text_input160" type="text"  id="name" name="name" value="${requestScope.name}"  />
			               </TD>
						   <TD width="8%" height="26" class="table_body">联系电话</TD>
			               <TD class="table_none" >
                            <input clean=clean class="text_input160" type="text"  id="phone" name="phone" value="${requestScope.phone}" />
			               </TD>
                        </TR>
                         <TR>
                           <TD  height="26" class="table_body">会员性别</TD>
			               <TD class="table_none">
                            <select clean=clean id="sex" name="sex">
                            	<option value="">----请选择----</option>
      		                 	<option value="0" ${requestScope.sex!= "0"  ? '' : 'selected="selected"' }>男</option>
      		                 	<option value="1" ${requestScope.sex!= "1"  ? '' : 'selected="selected"' }>女</option>
      	                    </select>
			               </TD>
						   <TD  height="26" class="table_body">会员年龄</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input80" type="text"  id="agemin" name="agemin" value="${requestScope.agemin}"/>&nbsp;至
                            <input clean=clean class="text_input80" type="text"  id="agemax" name="agemax" value="${requestScope.agemax}"/>&nbsp;(岁)
			               </TD>
			                <TD  height="26" class="table_body">注册部门</TD>
			               <TD class="table_none">
                           <select clean=clean id="departmentid" name="departmentid">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if>
      	                   </select>
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
	      		                 <option value="">----请选择----</option>
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
                             <option value="1" ${requestScope.bbdfunctionclass eq '1' ? 'selected="selected"' : '' }>白色片</option>
                             <option value="2" ${requestScope.bbdfunctionclass eq '2' ? 'selected="selected"' : '' }>变色片</option>
                             <option value="3" ${requestScope.bbdfunctionclass eq '3' ? 'selected="selected"' : '' }>偏光片</option>
                             <option value="4" ${requestScope.bbdfunctionclass eq '4' ? 'selected="selected"' : '' }>变色偏光片</option>
                             <option value="5" ${requestScope.bbdfunctionclass eq '5' ? 'selected="selected"' : '' }>染色片</option>
                             <option value="6" ${requestScope.bbdfunctionclass eq '6' ? 'selected="selected"' : '' }>抗疲劳片</option>
      	                     <option value="7" ${requestScope.bbdfunctionclass eq '7' ? 'selected="selected"' : '' }>抗疲劳变色片</option>
      	                     <option value="8" ${requestScope.bbdfunctionclass eq '8' ? 'selected="selected"' : '' }>偏光抗疲劳片</option>
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
      	                   </select>
			             </TD>
                        </TR>
                          <TR>
			                 <TD  height="26" class="table_body">销售类型</TD>
			                <TD class="table_none" >
			               	  <!--  <select clean=clean id="salesType" name="salesType"  >
	      		                 <option value="" ${requestScope.salseType eq '' ? 'selected="selected"' : '' }>----请选择----</option>
	                             <option value="1" ${requestScope.salseType eq '1' ? 'selected="selected"' : '' }>框镜成品</option>
	                             <option value="2" ${requestScope.salseType eq '2' ? 'selected="selected"' : '' }>框镜订制</option>
	                             <option value="3" ${requestScope.salseType eq '3' ? 'selected="selected"' : '' }>隐形成品</option>
	                             <option value="4" ${requestScope.salseType eq '4' ? 'selected="selected"' : '' }>隐形订制</option>
	                             <option value="5" ${requestScope.salseType eq '5' ? 'selected="selected"' : '' }>辅料</option>
	      	                   </select>  -->
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
				               		<input type="text" clean=clean maxlength="9"  class="text_input160" onkeyup="value=value.replace(/[^\d]/g,'')" name="huifangcishu" id="huifangcishu" value="${huifangcishu }" >
				               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${(permissionPo.keya==1)}">
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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
					<c:if test="${not empty(customerReturnVisitList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="6%" scope=col colspan="2">操作</TH>
                            <TH width="10%" scope=col>会员卡号</TH>						
						  <TH width="8%" scope=col>会员姓名</TH>
                          <TH width="15%" height="26" scope=col>配镜单号</TH>
						  <TH width="10%" scope=col>联系电话</TH>
						  <TH scope=col>配镜日期</TH>
						  <TH width="8%" scope=col>回访状态</TH>
						  <TH scope=col>回访日期</TH>
						  <TH scope=col>回访满意度</TH>
						</TR>
						 <s:iterator value="customerReturnVisitList">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
	                          <TD width="3%">
                          	  	<c:if test="${(permissionPo.keyb==1)}">
                          	  	 <c:if test="${not empty(smecvid)}"> 
	                          		<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="javascript:returnDetails('${smecvsalesid}')">
	                             </c:if>
		                      	 <c:if test="${empty(smecvid)}"> 
	                          		<img src="${ctx }/img/newbtn/search_2.png" btn=btn title='详细' disabled="disabled">
	                             </c:if>
	                            </c:if>
			                  </TD>
	                          <TD width="3%">
	                          	<c:if test="${(permissionPo.keyb==1)}">
		                      	 <img src="${ctx }/img/newbtn/returnvisit_0.png" btn=btn title='回访' onClick="javascript:returnVisit('${smecvsalesid}')">
			                  	</c:if>
			                  </TD>
			                  <TD>${smecvmemberid}</TD>
							  <td>${smecvcustomername}</td>
	                          <TD height="26">${smecvsalesid}</TD>
	                          <TD>${smecvpersonphone}</TD>
	                          <TD>${fn:substring(smecvsalestime,0,16)}</TD>
	                          <c:if test="${not empty(smecvid)}"> 
	                          <TD>已回访</TD>
	                          </c:if>
	                          <c:if test="${empty(smecvid)}"> 
	                          <TD>未回访</TD>
	                          </c:if>
                          	  <TD>${fn:substring(smecvfeedbackdate,0,16)}</TD>
                          	  <TD>${sopoypersonid}</TD>
                          	  
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
<%@ include file="/WEB-INF/inc/message.jsp" %>