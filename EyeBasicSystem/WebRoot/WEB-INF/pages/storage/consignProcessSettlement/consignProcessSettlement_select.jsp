<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外收货结算</title>
</head>
<!-- jquery.autocomplete -->
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/module/thickbox.css" /> -->
<!-- jquery.autocomplete end -->  
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	consignProcessSettlementForm.action=link;
	  	selConsignProcessSettlement.submit();
		showLoadingBar();
	}
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConsignProcessSettlementDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initConsignProcessSettlementDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【委外财务结算详细】";
	}	
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConsignProcessSettlementUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initConsignProcessSettlementUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【委外财务结算更新】";
	}
	function search(){
		$("img").removeAttr("onclick");
		consignProcessSettlementForm.action = "selConsignProcessSettlement.action";
		consignProcessSettlementForm.submit();
		showLoadingBar();
	}

	function clean(){
		document.getElementById('selbillID').value = "";
		document.getElementById('sourceBillID').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
		document.getElementById('auditState').value = "";
		document.getElementById('selbspsuppliername').value = "";
		document.getElementById('instockID').value = "";
		document.getElementById('financeAuditPersonName').value = "";
		document.getElementById('selcstpsupplierid').value = ""; 
		document.getElementById('goodsName').value = "";
		document.getElementById('categoryid').value = "";
		document.getElementById('goodsID').value = "";
		$("#createStartTime").val("");  
		$("#createEndTime").val("");  
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.categoryid.value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.categoryid.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商添加】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selcstpsupplierid').value = json.id;
		document.getElementById('selbspsuppliername').value = json.value;
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
	
	function today(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
			$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
			$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 	

		if($("#title1").is(":visible")){
        	$("input:text")[0].focus();
        }
	});

	function queryReport(DataURL,formAction){
		var rptFrm = document.getElementById('rptFrm');
		rptFrm.action = DataURL;    
		rptFrm.target = formAction;    

		if (rptFrm.attachEvent){
			rptFrm.attachEvent("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}); 		  
		}else{
			rptFrm.addEventListener("onsubmit",function(){ window.open('',formAction,'toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=0, top=0,width='+(screen.width)+',height='+(screen.height-50));}); 		  
		}
	
		if (rptFrm.fireEvent){
			rptFrm.fireEvent("onsubmit");	
		}else{
			//rptFrm.removeEventListener("onsubmit");	
		}         

	    rptFrm.submit();  
	  
	    document.body.removeChild(rptFrm); 
    }
    
    function createForm(){
		var rptFrm = document.createElement("form"); 
		rptFrm.id = "rptFrm";
		rptFrm.method = "post";
		
	    var billIDrpt = document.createElement("input");	     
	    billIDrpt.type = "hidden";
	    billIDrpt.name = "billIDrpt";
	    billIDrpt.value = '';	  
	    rptFrm.appendChild(billIDrpt); 

	    var sourceBillIDrpt = document.createElement("input");	     
	    sourceBillIDrpt.type = "hidden";
	    sourceBillIDrpt.name = "sourceBillIDrpt";
	    sourceBillIDrpt.value = '';	  
	    rptFrm.appendChild(sourceBillIDrpt);  

	    var selcstpsupplieridrpt = document.createElement("input");	     
	    selcstpsupplieridrpt.type = "hidden";
	    selcstpsupplieridrpt.name = "selcstpsupplieridrpt";
	    selcstpsupplieridrpt.value = '';	  
	    rptFrm.appendChild(selcstpsupplieridrpt);  

	    var instockIDrpt = document.createElement("input");	     
	    instockIDrpt.type = "hidden";
	    instockIDrpt.name = "instockIDrpt";
	    instockIDrpt.value = '';	  
	    rptFrm.appendChild(instockIDrpt); 

	    var auditStaterpt = document.createElement("input");	     
	    auditStaterpt.type = "hidden";
	    auditStaterpt.name = "auditStaterpt";
	    auditStaterpt.value = '';	  
	    rptFrm.appendChild(auditStaterpt);    

	    var startTimerpt = document.createElement("input");	     
	    startTimerpt.type = "hidden";
	    startTimerpt.name = "startTimerpt";
	    startTimerpt.value = '';
	    rptFrm.appendChild(startTimerpt);

	    var endTimerpt = document.createElement("input");	     
	    endTimerpt.type = "hidden";
	    endTimerpt.name = "endTimerpt";
	    endTimerpt.value = '';	  
	    rptFrm.appendChild(endTimerpt); 
	    
	    var financeAuditPersonNamerpt = document.createElement("input");	     
	    financeAuditPersonNamerpt.type = "hidden";
	    financeAuditPersonNamerpt.name = "financeAuditPersonNamerpt";
	    financeAuditPersonNamerpt.value = '';	  
	    rptFrm.appendChild(financeAuditPersonNamerpt);    

	    var categoryidrpt = document.createElement("input");	     
	    categoryidrpt.type = "hidden";
	    categoryidrpt.name = "categoryidrpt";
	    categoryidrpt.value = '';	  
	    rptFrm.appendChild(categoryidrpt);  

	    var goodsNamerpt = document.createElement("input");	     
	    goodsNamerpt.type = "hidden";
	    goodsNamerpt.name = "goodsNamerpt";
	    goodsNamerpt.value = '';	  
	    rptFrm.appendChild(goodsNamerpt); 

	    var goodsIDrpt = document.createElement("input");	     
	    goodsIDrpt.type = "hidden";
	    goodsIDrpt.name = "goodsIDrpt";
	    goodsIDrpt.value = '';	  
	    rptFrm.appendChild(goodsIDrpt);  

	    var bgnDate = document.createElement("input");	     
	    bgnDate.type = "hidden";
	    bgnDate.id = "bgnDate";
	    bgnDate.name = "bgnDate";
	    bgnDate.value = '';
	    rptFrm.appendChild(bgnDate);

	    var endDate = document.createElement("input");	     
	    endDate.type = "hidden";
	    endDate.id = "endDate";
	    endDate.name = "endDate";
	    endDate.value = '';	  
	    rptFrm.appendChild(endDate); 

	    var companyID = document.createElement("input");	     
	    companyID.type = "hidden";
	    companyID.name = "companyID";
	    companyID.value = '';	  
	    rptFrm.appendChild(companyID); 
	    
	    document.body.appendChild(rptFrm);
    }

	function setReportEvent(reportFileName,reportServer,showtype){
		switch(reportServer)
		{
		case "1":
		  fineReportEvent(reportFileName,showtype);
		  break;
		case "2":
		  reportingServiceEvent(reportFileName,showtype);
		  break;
		default:
		  alert("单据配置异常！");
		}				
	}

	function reportingServiceEvent(reportFileName,showtype){
		alert("ReporttingService 报表方法没有编写！");
	}
	
    function fineReportEvent(reportFileName,showtype){

		createForm();
		var billIDrpt = $('input[id=billID]').val();	
		var sourceBillIDrpt = $('input[id=sourceBillID]').val();
		var selcstpsupplieridrpt = $('input[id=selcstpsupplierid]').val();
		var instockIDrpt = $('input[id=instockID]').val();
		var auditStaterpt = $('input[id=auditState]').val();
		var startTimerpt = $('input[id=startTime]').val();
		var endTimerpt = $('input[id=endTime]').val();
		var financeAuditPersonNamerpt = $('input[id=financeAuditPersonName]').val();
		var categoryidrpt = $('select[id=categoryid]').val();
		var goodsNamerpt = $('input[id=goodsName]').val();
		var goodsIDrpt = $('input[id=goodsID]').val();
		var bgnDate = $('input[id=createStartTime]').val();
		var endDate = $('input[id=createEndTime]').val();
		var companyid = '';
		if ('${person.personcompanytype}' == '2'){
			companyid = '${person.personcompanyid}';
		}

		$("input[name=companyID]").val(companyid);
		$("input[name=billIDrpt]").val(billIDrpt);
		$("input[name=sourceBillIDrpt]").val(sourceBillIDrpt);
		$("input[name=selcstpsupplieridrpt]").val(selcstpsupplieridrpt);
		$("input[name=instockIDrpt]").val(instockIDrpt);
		$("input[name=auditStaterpt]").val(auditStaterpt);
		$("input[name=startTimerpt]").val(startTimerpt);
		$("input[name=endTimerpt]").val(endTimerpt);
		$("input[name=financeAuditPersonNamerpt]").val(financeAuditPersonNamerpt);
		$("input[name=categoryidrpt]").val(categoryidrpt);
		$("input[name=goodsNamerpt]").val(goodsNamerpt);
		$("input[name=goodsIDrpt]").val(goodsIDrpt);
		$("input[name=bgnDate]").val(bgnDate);
		$("input[name=endDate]").val(endDate);
	    
		var DataURL = '';
		formAction = 'receives';
		DataURL = "report.action?reportlet="+reportFileName+"&__bypagesize__=false"
		+"&billIDrpt="+billIDrpt
	    +"&sourceBillIDrpt="+sourceBillIDrpt
	    +"&selcstpsupplieridrpt="+selcstpsupplieridrpt
	    +"&instockIDrpt="+instockIDrpt
	    +"&auditStaterpt="+auditStaterpt
	    +"&startTimerpt="+startTimerpt
	    +"&endTimerpt="+endTimerpt
	    +"&financeAuditPersonNamerpt="+financeAuditPersonNamerpt
	    +"&categoryidrpt="+categoryidrpt
	    +"&goodsNamerpt="+goodsNamerpt
	    +"&goodsIDrpt="+goodsIDrpt
	    +"&bgnDate="+bgnDate
	    +"&endDate="+endDate
		+"&companyid="+companyid;

		DataURL = DataURL.replace(eval("/undefined/gi"),""); 

		switch(showtype)
		{
		case "1":
			var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;		
			if(is_iPad()){
				showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}else{
				showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
			}
			document.getElementById('popupTitle').innerHTML="【委外收货结算汇总单 】";
		  break;
		case "2":
			DataURL = "report.action?reportlet=" + reportFileName + "&__bypagesize__=false";
			queryReport(DataURL,formAction);
		  break;
		default:
		  alert("单据配置异常！");
		}	
	}
	
function todayCreate(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('createStartTime').value = now;
		document.getElementById('createEndTime').value = now;		
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="consignProcessSettlementForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="billID" value="${requestScope.billID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>采购管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：委外收货结算</TD>
            <TD align="right" width="40%" valign="bottom" >&nbsp;
            <img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"  />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start --><br/>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="8"><td></td></tr>
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
						   <TD width="9%" height="26" class="table_body">单据编号</TD>
			               <TD class="table_none" width="20%">
                            <input class="text_input160" type="text"  id="billID" name="selbillID" value="${selbillID}">
			               </TD>
			                <TD width="9%" height="26" class="table_body">运单编号</TD>
			               <TD class="table_none" width="20%">
                            <input class="text_input160" type="text"  id="sourceBillID" name="sourceBillID" value="${requestScope.sourceBillID}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight">
						   		<input id="selbspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" ></li>
						  </TD>
                        </TR>
                    	<TR>	
                    	   <TD height="26" class="table_body">收入仓位</TD>
			               <TD class="table_none">
                            <select id="instockID" name="instockID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="warehouseList">
				               <option value="${bwhid}" ${requestScope.instockID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>					  
			               <TD height="26" class="table_body">审核状态</TD>
			               <TD class="table_none">
                            <select id="auditState" name="auditState" value="${requestScope.auditState}">
                                    <option value="">----请选择----</option>
							  		<option value="1" ${requestScope.auditState!= "1"  ? '' : 'selected="selected"' }>已审核</option>
							  		<option value="0" ${requestScope.auditState!= "0"  ? '' : 'selected="selected"' }>未审核</option>
	                          </select>
			               </TD>
			               <TD height="26" class="table_body">审核日期</TD>
			               <TD class="table_none">
                             <li class="horizontal_onlyRight"> 
						       <input class="text_input100"
				               id="startTime"
						       name="startTime" value="${requestScope.startTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="endTime"
						       name="endTime" value="${requestScope.endTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})"
						       readonly="readonly" /></li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today()"></li>
			               </TD>			               
                        </TR>
                    	<TR>
                    	 <TD height="26" class="table_body">结算人姓名</TD>
			               <TD class="table_none">
	                            <input class="text_input160" type="text"  id="financeAuditPersonName" name="financeAuditPersonName" value="${financeAuditPersonName}">
			               </TD>
			              <TD class="table_body" height="26">商品类别</TD>
                          <TD class="table_none">

						  <select id="categoryid" name="categoryid">
                           	  <option value="">----请选择----</option>
							  <option value="3" ${categoryid == 3 ? 'selected="selected"' : '' }>框镜订做片</option>
							  <option value="4" ${categoryid == 4 ? 'selected="selected"' : '' }>隐形订做片</option>
                          </select>          
			               </TD>
						  </TD>
			              <TD height="26" class="table_body">商品名称</TD>
                          <TD class="table_none" >
                              <input class="text_input200" id="goodsName" name="goodsName" value="${goodsName}" maxlength="100">
                          </TD>  
                        </TR>   
                    	<TR>
			              <TD height="26" class="table_body">商品代码</TD>
                          <TD class="table_none" >
                              <input class="text_input200" id="goodsID" name="goodsID" value="${goodsID}" maxlength="100">
                          </TD>  
                            <TD height="26" class="table_body">制单日期</TD>
			               <TD class="table_none" colspan="3">
 							<li class="horizontal_onlyRight"> <input class="text_input100"
				               id="createStartTime"
						       name="createStartTime" value="${requestScope.createStartTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'createEndTime\')}'})"
						       readonly="readonly" />
						       至
					         <input class="text_input100"
						       id="createEndTime"
						       name="createEndTime" value="${requestScope.createEndTime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'createStartTime\')}'})"
						       readonly="readonly" /></li><li class="horizontal_onlyRight">
								<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="todayCreate()">
								</li>
						       
			               </TD>		
                        </TR>                                              
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td width="20%" align="left">
							<c:if test="${(permissionPo.keya==1)}">
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="javascript:search()">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()" >
							</c:if>
							</td>
							<td width="80%" align="right">
							<table>
								<tr>
									<td>
										<font color="red">*根据查询条件汇总结算单</font>
									</td>
									<td>
										<img src="${ctx }/img/newbtn/btn_printcgjsds_0.png" btn=btn title='打印结算单' onclick="setReportEvent('${fittingTemplateTypePo.bftfilename}','${fittingTemplateTypePo.bftserver}','${fittingTemplateTypePo.bfttshowtype}')">
									</td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
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
					<c:if test="${not empty(consignProcessSettlementList) }"> 
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
                        <TH width="6%" height="26" scope=col colspan="2">操作</TH>
                          <TH height="26" scope=col>单据编号</TH>
						  <TH width="13%" scope=col>运单编号</TH>						
                          <TH width="14%" scope=col>制造商</TH>
						  <TH width="7%" scope=col>商品类型</TH>
						  <TH width="13%" scope=col>收入仓位</TH>				  
						  <TH width="12%" scope=col>单据日期</TH>
						  <TH width="7%" scope=col>审核人</TH>
						  <TH width="12%" scope=col>审核日期</TH>
						  </TR>
						 <s:iterator value="consignProcessSettlementList">
						 <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
						  <TD width="3%">
	                          <c:if test="${(permissionPo.keyc==1)}">
			                     <c:if test="${cstifinanceauditstate == 1}">
	                          		  <img src="${ctx }/img/newbtn/search_0.png" title='详细' btn=btn onClick="javascript:details('${cstibillid}')">
			                  </c:if>
	                          	<c:if test="${cstifinanceauditstate != 1}">
	                          		  <img src="${ctx }/img/newbtn/search_2.png" title='详细'>
	                          	</c:if>
			                  </c:if>
			                   </TD>
			                   <TD width="3%">
			                  <c:if test="${(permissionPo.keyb==1)}">
	                          
	                          	<c:if test="${cstifinanceauditstate != 1}">
	                          		<img src="${ctx }/img/newbtn/edit_0.png" title='修改' btn=btn onClick="javascript:update('${cstibillid}')">
	                          	</c:if>
	                          	<c:if test="${cstifinanceauditstate == 1}">
	                          		<img src="${ctx }/img/newbtn/edit_2.png" title='修改'>
	                          	</c:if>
	                          </c:if>
	                          </TD>
	                          <TD height="26">${cstibillid}</TD>
	                          <TD>${deliveryID}</TD>
	                          <TD>${cstisuppliername}</TD>
	                          <TD>
	                           <c:choose>
				               	<c:when test="${cstibilltypeid=='1'}">
				               		采购收货
				               	</c:when>
				               	<c:when test="${cstibilltypeid=='7'}">
				               		其他入库
				               	</c:when>
				               	<c:when test="${cstibilltypeid=='9'}">
				               		委外收货
				               	</c:when>
				               	<c:otherwise>
				               		未知单据
				               	</c:otherwise>
				               </c:choose>
	                          </TD>
	                          <TD>${cstiinstockname}</TD>
	                          <TD>${fn:substring(cstibilldate,0,16)}</TD>
	                          <TD>${cstifinanceauditpersonname}</TD>                          	  
                          	  <TD>${fn:substring(cstifinanceauditdate,0,16)}</TD>
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