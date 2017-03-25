<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜管理</title>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
</head>
<script>	
    var timer;
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand;");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	if('${systemParameterPo.fsppjbillsetup}'=='1'){
			timer=setInterval('search()','${systemParameterPo.fsppjbillsetuptime}'*1000);//执行
    	}
		if($("#title1").is(":visible")){
        	$("input:text")[0].focus();
        }
		changeselect('0');
		changeselect2('0');

		if ('${usesetmeal}' == '1'){
			$('#setmealTab').show();
		}else{
        	$('#setmealtype').val('');
        	$('#setmealtitle').val('');
			$('#setmealTab').hide();
	    }

		if (${empty(yjzt)}){
			checkyj('1');
	    }else{
	    	checkyj('${yjzt}');
		}
		
	});
	var x='${systemParameterPo.fsppjbillsetuptime}';	
	
	function countSecond(){
		x = x-1
		if('${systemParameterPo.fsppjbillsetup}'=='1'){
			　 document.inTransitForm.displayBox.value=x;
			　setTimeout("countSecond()", 1000);
		}
	}

	/*查看*/
	function search(){
		var selecta = $("#intransittype");
		var selectb = $("#intransit");
		var selectc = $("#intransit2");
		if(selecta.val() == '2' || selecta.val() == '3'){
			if(parseFloat(selectc.val()) < parseFloat(selectb.val())){
				alert("查询条件在途状态填写有误！");
				selectc.focus();
				return;
			}
		}
		$("img").removeAttr("onclick");	
		inTransitForm.action = "selectInTransit.action?yjzt="+$('input[type=radio][name=yjztType]:checked').val();
		inTransitForm.submit();
		showLoadingBar();
	}	
	
     /*重置*/
	function clean(){
		document.getElementById('salesid').value = "";
		document.getElementById('customerName').value = "";
		document.getElementById('departmentid').value = "";
		document.getElementById('intransit').value = "";
		document.getElementById('salesdatestarttime').value = "";
		document.getElementById('salesdateendtime').value = "";
		document.getElementById('posdatestarttime').value = "";
		document.getElementById('posdateendtime').value = "";
		document.getElementById('takeglassstartdata').value = "";
		document.getElementById('takeglassenddata').value = "";
		document.getElementById('memberid').value = "";
		document.getElementById('chooseflag').value = "";	
		document.getElementById('worrytype').value = "";	
		document.getElementById('intransittype').value = "1";
		document.getElementById('customerphone').value = "";
		document.getElementById('outpricestarttime').value = "";
		document.getElementById('outpriceendtime').value = "";
		document.getElementById('selcstpsupplierid').value = "";
		document.getElementById('selbspsuppliername').value = "";
        <c:if test="${systemParameterPo.fspdjsbm == '1'}">
        document.getElementById('djsbm').value = "";
        </c:if> 
        			
		$("#intransittype2").val("1");	
		$("#intransit2").val("");	
		$("#intransittype2").hide();;	
		$("#intransit2").hide();
		$("#checkout").val('');
    	$('#usesetmeal').val('');
    	$('#setmealtitle').val('');
    	$('#setmealtype').val('');
    	$('#setmealTab').hide();
    	$('#salerID').val('');
    	$('#salesremark').val('');
	}	
	/*开窗事件*/
	function winPopUp(id){
		clearTimeout(timer);
		document.all.hid.value = id;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initInTransitDetailsSel.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initInTransitDetailsSel.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【在途详细】";
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function selectContact(obj){
		var act = document.activeElement.id; 
		
		if(act == "pageNos"){
			$('#'+act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
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
		
		document.getElementById('salesdatestarttime').value = now;
		document.getElementById('salesdateendtime').value = now;		
	}
	
	function today1(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('takeglassstartdata').value = now;
		document.getElementById('takeglassenddata').value = now;		
	}

	function today2(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('posdatestarttime').value = now;
		document.getElementById('posdateendtime').value = now;		
	}
	function today3(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('outpricestarttime').value = now;
		document.getElementById('outpriceendtime').value = now;		
	}
	function changeselect(obj){
		var selecta = $("#intransittype");
		var selectb = $("#intransit");
		var selectc = $("#intransittype2");
		var selectd = $("#intransit2");
		if(obj == '0'){
			if(selecta.val() == '1' || selecta.val() == '4' || selecta.val() == '5'){
				selectc.hide();
				selectd.hide();
				selectd.val('');
			}else if(selecta.val() == '2' || selecta.val() == '3'){
				selectc.show();
				selectd.show();
			}
		}
	}

	function changeselect2(obj){
		var selecta = $("#intransittype3");
		var selectb = $("#intransit3");
		var selectc = $("#intransittype4");
		var selectd = $("#intransit4");
		if(obj == '0'){
			if(selecta.val() == '1' || selecta.val() == '4' || selecta.val() == '5'){
				selectc.hide();
				selectd.hide();
				selectd.val('');
			}else if(selecta.val() == '2' || selecta.val() == '3'){
				selectc.show();
				selectd.show();
			}
		}
	}

	function changeSetMealUse(obj){
        if (obj.value == '1'){
           $('#setmealTab').show();
        }else{
        	$('#setmealtype').val('');
        	$('#setmealtitle').val('');
        	$('#setmealTab').hide();
        }
    }

	function checkyj(flag){
        if (flag == '1'){
            $('#wyqjTab').show();
            $('#yqjTab').hide();            
        }else{
            $('#wyqjTab').hide();
            $('#yqjTab').show();           
        }
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
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selcstpsupplierid').value = json.id;
		document.getElementById('selbspsuppliername').value = json.value;
	}
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="inTransitForm" method="post" action="" >
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="customerID" value="${requestScope.smecicustomerid }">
<input type="hidden" name="moduleID" value="${requestScope.moduleID }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>配镜管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：配镜单查询     &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;&nbsp;  &nbsp;&nbsp;  &nbsp;<c:if test="${systemParameterPo.fsppjbillsetup==1}"> 距离自动刷新还剩<input type="text" class="text_input10" name="displayBox" value="" readonly="readonly" size=3 >秒</c:if></TD>
            <TD align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </TD>
          </TR>
         <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
          </TD>
					</TR></TBODY></TABLE>
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
                                  <TD width="6%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
		                  <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="7%" height="26" class="table_body">取镜状态</TD>
                          <TD width="30%" class="table_none">
                          	<input type="radio" id="yjzt1" name="yjztType" value="1" onclick="checkyj('1')" ${(yjzt == '1' || empty(yjzt)) ? 'checked="checked"' : ''}>未取镜&nbsp;&nbsp;
                          	<input type="radio" id="yjzt2" name="yjztType" value="2" onclick="checkyj('2')" ${yjzt == '2' ? 'checked="checked"' : ''}>全部
                          </TD>
						  <TD class="table_body">排序方式</TD>
                          <TD class="table_none" colspan="3">
                          	<input type="radio" id="ordertype1" name="ordertype" value="2" ${(ordertype == '2' || empty(ordertype)) ? 'checked="checked"' : ''}>取镜时间&nbsp;&nbsp;
                          	<input type="radio" id="ordertype2" name="ordertype" value="1" ${ordertype == '1' ? 'checked="checked"' : ''}>销售时间
                          </TD>
                        </TR>
                        <TR>
                          <TD width="7%" height="26" class="table_body">配镜单号</TD>
                          <TD width="30%" class="table_none">
                          	<input class="text_input160" type="text" id="salesid" name="salesid" value="${salesid}"  onkeyup="selectContact(this)"><b><font color="red">*重订单号要输入完全</font></b>
                          </TD>
						   <TD width="10%" height="26" class="table_body">配镜类型</TD>
                          <TD class="table_none">
                            <select name="chooseflag" id="chooseflag" >
                            <option value="">----请选择----</option>
                            <option value="1" ${requestScope.chooseflag == 1 ? 'selected="selected"' : '' }>框镜成品</option>
                            <option value="2" ${requestScope.chooseflag == 2 ? 'selected="selected"' : '' }>框镜订做</option>
                            <option value="3" ${requestScope.chooseflag == 3 ? 'selected="selected"' : '' }>隐形成品</option>
                            <option value="4" ${requestScope.chooseflag == 4 ? 'selected="selected"' : '' }>隐形订做</option>
                            <option value="5" ${requestScope.chooseflag == 5 ? 'selected="selected"' : '' }>辅料</option>
                            </select>
			               </TD>
			               <TD height="26" class="table_body">销售门店</TD>
                           <TD class="table_none">
      		                 	<select id="departmentid" name="departmentid">
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentid!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </select>
						  </TD>
                        </TR>
                        <TR> 
			              <TD height="26" class="table_body">顾客卡号</TD>
                          <TD class="table_none">
                            <input class="text_input100" type="text" id="memberid" name="memberid" value="${smecimemberid}">
			               </TD>
			              <TD width="7%" class="table_body">顾客姓名</TD>
                          <TD width="20%" class="table_none">
                          	<input class="text_input100" type="text" id="customerName" name="customerName" value="${customerName}"  >
						  </TD>
			               <TD height="26" class="table_body">销售日期</TD>
                           <TD class="table_none">
                            <li class="horizontal_onlyRight"> <input class="text_input100"
				               id="salesdatestarttime"
						       name="salesdatestarttime" value="${requestScope.ssesbsalesdatestarttime }"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'salesdateendtime\')}'})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly"  />
						       至
					         <input class="text_input100"
						       id="salesdateendtime"
						       name="salesdateendtime" value="${requestScope.ssesbsalesdateendtime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'salesdatestarttime\')}'})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly"  /> </li><li class="horizontal_onlyRight">
							 <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
			               </TD>
                        </TR>                         
                        <TR> 

						   <TD height="26"  class="table_body">取镜日期</TD>
                          <TD class="table_none">
                            <li class="horizontal_onlyRight">   <input class="text_input100"
				               id="takeglassstartdata"
						       name="takeglassstartdata" value="${requestScope.ssesbtakeglassstartdata }"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'takeglassenddata\')}'})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly"/>
						       至
					         <input class="text_input100"
						       id="takeglassenddata"
						       name="takeglassenddata" value="${requestScope.ssesbtakeglassenddata}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'takeglassstartdata\')}'})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly"/></li><li class="horizontal_onlyRight">
                                  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today1()"></li>
			               </TD>
			               <TD height="26" class="table_body">加急状态</TD>
                            <TD class="table_none">
                            <select name="worrytype" id="worrytype"  >
                             <option value="">----请选择----</option>
                             <option value="1" ${requestScope.worrytype == '1' ? 'selected="selected"' : '' }>正常</option>
                             <option value="2" ${requestScope.worrytype == '2' ? 'selected="selected"' : '' }>加急</option>                           
                            </select><b><font color="red">*数据呈红色</font></b>
			                </TD>
			                <TD class="table_body">顾客电话</TD>
                            <TD class="table_none">
                          		<input class="text_input100" type="text" id="customerphone" name="customerphone" value="${customerphone}"  >
						    </TD>
                        </TR>
                        <tr>

			                <TD height="26" class="table_body">结款日期</TD>
                            <TD class="table_none" >
                            <li class="horizontal_onlyRight"> <input class="text_input100"
				               id="posdatestarttime"
						       name="posdatestarttime" value="${requestScope.posdatestarttime }"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'posdateendtime\')}'})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly"  />
						       至
					         <input class="text_input100"
						       id="posdateendtime"
						       name="posdateendtime" value="${requestScope.posdateendtime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'posdatestarttime\')}'})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly"  /> </li><li class="horizontal_onlyRight">
							 <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today2()"></li>
			               </TD>
			               <TD height="26" class="table_body">付款状态</TD>
                            <TD class="table_none" >
                            <select name="checkout" id="checkout"  >
                             <option value="">----请选择----</option>
                             <option value="0" ${requestScope.checkout == '0' ? 'selected="selected"' : '' }>全款</option>
                             <option value="1" ${requestScope.checkout == '1' ? 'selected="selected"' : '' }>欠款</option>
                            </select>
			                </TD>
			                <TD class="table_body">营业员</TD>
                            <TD class="table_none" >
                          	  <input class="text_input200" type="text" id="salerID" name="salerID" value="${salerID}"  >
						  </TD>	
                        </tr>
                        <tr>
						<c:choose>
							<c:when test="${systemParameterPo.fspdjsbm == '1'}">
				                <TD height="26" class="table_body">使用套餐</TD>
				                <TD class="table_none">
				                 <select name="usesetmeal" id="usesetmeal" onchange="changeSetMealUse(this);" >
				                          <option value="">----请选择----</option>
				                          <option value="1" ${usesetmeal == '1' ? 'selected="selected"' : '' }>使用</option>
				                          <option value="0" ${usesetmeal == '0' ? 'selected="selected"' : '' }>未使用</option>
				                         </select>
				                </TD>                                                                   
				               	<TD height="26" class="table_body">单据识别码</TD>
				               	<TD class="table_none" ${(systemParameterPo.fspisshowsupplierandbrand eq '0' && person.departmenttype eq '1') ? 'colspan="3" ' : '' }>
	                              <input class="text_input160" type="text" id="djsbm" name="djsbm" value="${requestScope.djsbm}" onkeyup="selectContact(this)"/>
				               	</TD>
				               	
				            <c:if test="${systemParameterPo.fspisshowsupplierandbrand eq '1' || person.departmenttype != '1'}">
			                	<TD class="table_body">购买商品包含</TD>
                            	<TD class="table_none" >
                          	  	<li class="horizontal_onlyRight">
							   		<input clean=clean id="selbspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
							   		<input clean=clean type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
							   	</li>
							   	<li class="horizontal_onlyRight">
							  		<img src="${ctx }/img/newbtn/btn_changesupplier_0.png" btn=btn title="选择制造商" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li>
						  		</TD>
						  	</c:if>
						  							               								
							</c:when>
							<c:otherwise>
				                <TD height="26" class="table_body">使用套餐</TD>
				                <TD class="table_none" ${(systemParameterPo.fspisshowsupplierandbrand eq '0' && person.departmenttype eq '1') ? 'colspan="5" ' : '' }>
				                 <select name="usesetmeal" id="usesetmeal" onchange="changeSetMealUse(this);" >
				                          <option value="">----请选择----</option>
				                          <option value="1" ${usesetmeal == '1' ? 'selected="selected"' : '' }>使用</option>
				                          <option value="0" ${usesetmeal == '0' ? 'selected="selected"' : '' }>未使用</option>
				                         </select>
				                </TD>
				                
				             <c:if test="${systemParameterPo.fspisshowsupplierandbrand eq '1' || person.departmenttype != '1'}">
			                	<TD class="table_body">购买商品包含</TD>
                            	<TD class="table_none" colspan="3" >
                          	  	<li class="horizontal_onlyRight">
							   		<input clean=clean id="selbspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
							   		<input clean=clean type="hidden" id="selcstpsupplierid" name="selcstpsupplierid" value="${selcstpsupplierid }" />
							   	</li>
							   	<li class="horizontal_onlyRight">
							  		<img src="${ctx }/img/newbtn/btn_changesupplier_0.png" btn=btn title="选择制造商" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li>
						  		</TD>
						  	 </c:if>
						  	 					                							
							</c:otherwise>
						</c:choose>                        
                        </tr>
                        <TR id="setmealTab"> 
			              <TD height="26" class="table_body">套餐分类</TD>
                          <TD class="table_none">
 				                 <select name="setmealtype" id="setmealtype"  >
	                             <option value="">----请选择----</option>
	                             <option value="1" ${setmealtype == '1' ? 'selected="selected"' : '' }>框镜销售</option>
	                             <option value="3" ${setmealtype == '3' ? 'selected="selected"' : '' }>隐形销售</option>
	                             <option value="5" ${setmealtype == '5' ? 'selected="selected"' : '' }>辅料销售</option>
	                            </select>
			               </TD>
			              <TD class="table_body">套餐主题</TD>
                          <TD width="20%" class="table_none" colspan="5">
                          	<input class="text_input200" type="text" id="setmealtitle" name="setmealtitle" value="${setmealtitle}"  >
						  </TD>
                        </TR>
                        <TR id="wyqjTab"> 
                          <TD height="26" class="table_body">在途状态</TD>
                          <TD class="table_none" colspan="5">
                          <select name="intransittype" id="intransittype" onchange="changeselect('0')">
                            <option value="1" ${requestScope.intransittype == '1' ? 'selected="selected"' : '' }>=</option>
                            <option value="2" ${requestScope.intransittype == '2' ? 'selected="selected"' : '' }>>=</option>
                            <option value="3" ${requestScope.intransittype == '3' ? 'selected="selected"' : '' }>></option>
                            <option value="4" ${requestScope.intransittype == '4' ? 'selected="selected"' : '' }><=</option>
                            <option value="5" ${requestScope.intransittype == '5' ? 'selected="selected"' : '' }><</option>
                          </select>
                          <select name="intransit" id="intransit" onchange="changeselect('1')">
                            <option value="">----请选择----</option>
                            <option value="1" ${requestScope.intransit == 1 ? 'selected="selected"' : '' }>销售完成</option>
                            <option value="2" ${requestScope.intransit == 2 ? 'selected="selected"' : '' }>银台结款</option>
                            <option value="3" ${requestScope.intransit == 3 ? 'selected="selected"' : '' }>门店配送</option>
                            <option value="4" ${requestScope.intransit == 4 ? 'selected="selected"' : '' }>委外订单</option>
                            <option value="5" ${requestScope.intransit == 5 ? 'selected="selected"' : '' }>委外收货</option>
                            <option value="6" ${requestScope.intransit == 6 ? 'selected="selected"' : '' }>配镜发料</option>
                            <option value="7" ${requestScope.intransit == 7 ? 'selected="selected"' : '' }>加工初验</option>
                            <option value="8" ${requestScope.intransit == 8 ? 'selected="selected"' : '' }>加工师加工</option>
                            <option value="9" ${requestScope.intransit == 9 ? 'selected="selected"' : '' }>加工检验</option>
                            <option value="10" ${requestScope.intransit == 10 ? 'selected="selected"' : '' }>加工配送</option>
                            <option value="11" ${requestScope.intransit == 11 ? 'selected="selected"' : '' }>隐形配送</option>
                            <option value="12" ${requestScope.intransit == 12 ? 'selected="selected"' : '' }>取镜处收货</option>
                            </select>
                            <select name="intransittype2" id="intransittype2" onchange="changeselect('3')">
                            <option value="1" ${requestScope.intransittype2 == '1' ? 'selected="selected"' : '' }><=</option>
                            <option value="2" ${requestScope.intransittype2 == '2' ? 'selected="selected"' : '' }><</option>
                            </select>
                            <select name="intransit2" id="intransit2" onchange="changeselect('4')">
                            <option value="">----请选择----</option>
                            <option value="1" ${requestScope.intransit2 == 1 ? 'selected="selected"' : '' }>销售完成</option>
                            <option value="2" ${requestScope.intransit2 == 2 ? 'selected="selected"' : '' }>银台结款</option>
                            <option value="3" ${requestScope.intransit2 == 3 ? 'selected="selected"' : '' }>门店配送</option>
                            <option value="4" ${requestScope.intransit2 == 4 ? 'selected="selected"' : '' }>委外订单</option>
                            <option value="5" ${requestScope.intransit2 == 5 ? 'selected="selected"' : '' }>委外收货</option>
                            <option value="6" ${requestScope.intransit2 == 6 ? 'selected="selected"' : '' }>配镜发料</option>
                            <option value="7" ${requestScope.intransit2 == 7 ? 'selected="selected"' : '' }>加工初验</option>
                            <option value="8" ${requestScope.intransit2 == 8 ? 'selected="selected"' : '' }>加工师加工</option>
                            <option value="9" ${requestScope.intransit2 == 9 ? 'selected="selected"' : '' }>加工检验</option>
                            <option value="10" ${requestScope.intransit2 == 10 ? 'selected="selected"' : '' }>加工配送</option>
                            <option value="11" ${requestScope.intransit2 == 11 ? 'selected="selected"' : '' }>隐形配送</option>
                            <option value="12" ${requestScope.intransit2 == 12 ? 'selected="selected"' : '' }>取镜处收货</option>
                            </select>
			               </TD>			               
                        </TR>
                        <TR id="yqjTab">
                          <TD height="26" class="table_body">在途状态</TD>
                          <TD class="table_none">
                          <select name="intransittype3" id="intransittype3" onchange="changeselect2('0')">
                            <option value="1" ${requestScope.intransittype3 == '1' ? 'selected="selected"' : '' }>=</option>
                            <option value="2" ${requestScope.intransittype3 == '2' ? 'selected="selected"' : '' }>>=</option>
                            <option value="3" ${requestScope.intransittype3 == '3' ? 'selected="selected"' : '' }>></option>
                            <option value="4" ${requestScope.intransittype3 == '4' ? 'selected="selected"' : '' }><=</option>
                            <option value="5" ${requestScope.intransittype3 == '5' ? 'selected="selected"' : '' }><</option>
                          </select>
                          <select name="intransit3" id="intransit3" onchange="changeselect2('1')">
                            <option value="">----请选择----</option>
                            <option value="1" ${requestScope.intransit3 == 1 ? 'selected="selected"' : '' }>销售完成</option>
                            <option value="2" ${requestScope.intransit3 == 2 ? 'selected="selected"' : '' }>银台结款</option>
                            <option value="3" ${requestScope.intransit3 == 3 ? 'selected="selected"' : '' }>门店配送</option>
                            <option value="4" ${requestScope.intransit3 == 4 ? 'selected="selected"' : '' }>委外订单</option>
                            <option value="5" ${requestScope.intransit3 == 5 ? 'selected="selected"' : '' }>委外收货</option>
                            <option value="6" ${requestScope.intransit3 == 6 ? 'selected="selected"' : '' }>配镜发料</option>
                            <option value="7" ${requestScope.intransit3 == 7 ? 'selected="selected"' : '' }>加工初验</option>
                            <option value="8" ${requestScope.intransit3 == 8 ? 'selected="selected"' : '' }>加工师加工</option>
                            <option value="9" ${requestScope.intransit3 == 9 ? 'selected="selected"' : '' }>加工检验</option>
                            <option value="10" ${requestScope.intransit3 == 10 ? 'selected="selected"' : '' }>加工配送</option>
                            <option value="11" ${requestScope.intransit3 == 11 ? 'selected="selected"' : '' }>隐形配送</option>
                            <option value="12" ${requestScope.intransit3 == 12 ? 'selected="selected"' : '' }>取镜处收货</option>
                            <option value="13" ${requestScope.intransit3 == 13 ? 'selected="selected"' : '' }>顾客取镜</option>
                            <option value="14" ${requestScope.intransit3 == 14 ? 'selected="selected"' : '' }>顾客退货</option>
                            </select>
                            <select name="intransittype4" id="intransittype4" onchange="changeselect2('3')">
                            <option value="1" ${requestScope.intransittype4 == '1' ? 'selected="selected"' : '' }><=</option>
                            <option value="2" ${requestScope.intransittype4 == '2' ? 'selected="selected"' : '' }><</option>
                            </select>
                            <select name="intransit4" id="intransit4" onchange="changeselect2('4')">
                            <option value="">----请选择----</option>
                            <option value="1" ${requestScope.intransit4 == 1 ? 'selected="selected"' : '' }>销售完成</option>
                            <option value="2" ${requestScope.intransit4 == 2 ? 'selected="selected"' : '' }>银台结款</option>
                            <option value="3" ${requestScope.intransit4 == 3 ? 'selected="selected"' : '' }>门店配送</option>
                            <option value="4" ${requestScope.intransit4 == 4 ? 'selected="selected"' : '' }>委外订单</option>
                            <option value="5" ${requestScope.intransit4 == 5 ? 'selected="selected"' : '' }>委外收货</option>
                            <option value="6" ${requestScope.intransit4 == 6 ? 'selected="selected"' : '' }>配镜发料</option>
                            <option value="7" ${requestScope.intransit4 == 7 ? 'selected="selected"' : '' }>加工初验</option>
                            <option value="8" ${requestScope.intransit4 == 8 ? 'selected="selected"' : '' }>加工师加工</option>
                            <option value="9" ${requestScope.intransit4 == 9 ? 'selected="selected"' : '' }>加工检验</option>
                            <option value="10" ${requestScope.intransit4 == 10 ? 'selected="selected"' : '' }>加工配送</option>
                            <option value="11" ${requestScope.intransit4 == 11 ? 'selected="selected"' : '' }>隐形配送</option>
                            <option value="12" ${requestScope.intransit4 == 12 ? 'selected="selected"' : '' }>取镜处收货</option>
                            <option value="13" ${requestScope.intransit4 == 13 ? 'selected="selected"' : '' }>顾客取镜</option>
                            <option value="14" ${requestScope.intransit4 == 14 ? 'selected="selected"' : '' }>顾客退货</option>
                            </select>
			              </TD>			  
						  <TD height="26"  class="table_body">退款日期</TD>
                          <TD class="table_none" colspan="3">
                            <li class="horizontal_onlyRight">   <input class="text_input100"
				               id="outpricestarttime"
						       name="outpricestarttime" value="${requestScope.outpricestrattime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'outpriceendtime\')}'})"
						       MAXDATE="#F{document.getElementById('endTime').value}" 
						       readonly="readonly"/>
						       至
					         <input class="text_input100"
						       id="outpriceendtime"
						       name="outpriceendtime" value="${requestScope.outpriceendtime}"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'outpricestarttime\')}'})"
						       MINDATE="#F{document.getElementById('startTime').value}"
						       readonly="readonly"/></li><li class="horizontal_onlyRight">
								<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today3()"></li>
			               </TD>
                        </TR>  
                        <TR> 
			              <TD class="table_body">销售备注</TD>
                          <TD width="20%" class="table_none" colspan="7">
                          	<input class="text_input200" type="text" id="salesremark" name="salesremark" value="${salesremark}"  >
						  </TD>
                        </TR>  
                        </TBODY>
                    </TABLE>
                   	<c:if test="${(permissionPo.keya==1)}"> 
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
							<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn  title='查询' onclick="search()">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean();" ></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
                    <c:if test="${not empty(salesBasicList ) }">
		                <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="6%"><div align="left"><img src="${ctx }/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				     <table width="100%" cellspacing="1" cellpadding="1" border="0" align="center" class="privateBorder"> 
                      <tbody> 
                        <tr align="middle" class="table_title"> 
                          <th height="26" width="4%" scope="col">操作</th>
                          <th width="13%" scope="col">配镜单号</th>
                          <th width="6%" scope="col">配镜类型</th> 
						  <th width="7%" scope="col">销售门店</th>
						  <th width="7%" scope="col">取镜地点</th>
                          <th width="6%" scope="col">顾客姓名</th>
                          <th width="6%" scope="col">原价金额</th>
                          <th width="6%" scope="col">应收金额</th>
                          <th width="6%" scope="col">欠款金额</th>
						  <th width="9%" scope="col">销售时间</th>
						  <th width="9%" scope="col">取镜时间</th>
						  <th width="9%" scope="col">结款时间</th>
						  <th width="7%" scope="col">在途状态</th>
						  <th width="6%" scope="col">加急状态</th>
						 </tr> 
				      <s:iterator  value="salesBasicList">
                        <tr class="row" onmouseover="mover(this,'#a2c1eb')" onmouseout="mout(this,'#cadee8')"> 
						  <td width="4%"><img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="winPopUp('${ssesbsalesid }')"/></td>
						  <td height="26" >${ssesbsalesid }</td> 
						  <td>${ssesbchooseflag }</td>
						  <td>${ssesbshopcode }</td>
						  <td ${ssesbshopcode== ssesblocation  ? '' : 'style="color: red;"' }>${ssesblocation }</td>
                          <td>${ssesbcustomerid }</td>
                          <td>${ssesbpricesum}</td>
                          <td>${ssesbsalesvalue}</td>
                          <td>${ssesbarrearsvalue}</td>
						  <td>${fn:substring(ssesbsalesdatetime,0,16) } </td> 
						  <td>${fn:substring(ssesbtakeglassdata,0,16) } </td>
						  <td>${fn:substring(ssesbposdatetime,0,16) } </td>						  
						  <c:if test="${(permissionPo.keyb==1)}">  
						  <td>
                          <c:choose>
								<c:when test="${ssesbintransit == 1 }">
									 销售完成
			                    </c:when> 
			                    <c:when test="${ssesbintransit == 2 }">
									银台结款
			                    </c:when>      
			                    <c:when test="${ssesbintransit == 3 }">
			                   		 门店配送
			                    </c:when>      
			                    <c:when test="${ssesbintransit == 4 }">
			                    	 委外订单
			                    </c:when>
			                    <c:when test="${ssesbintransit == 5 }">
			                   		 委外收货
			                    </c:when>      
			                    <c:when test="${ssesbintransit == 6 }">
			                   		 配镜发料
			                    </c:when>      
			                    <c:when test="${ssesbintransit == 7 }">
			                   		 加工初验
			                    </c:when>   
			                    <c:when test="${ssesbintransit == 8 }">
			                   		 加工师加工
			                    </c:when>      
			                    <c:when test="${ssesbintransit == 9 }">
			                   		 加工检验
			                    </c:when>      
			                    <c:when test="${ssesbintransit == 10 }">
			                   		 加工配送
			                    </c:when>   
			                    <c:when test="${ssesbintransit == 11 }">
			                   		 隐形配送
			                    </c:when>    
			                    <c:when test="${ssesbintransit == 12 }">
			                   		 取镜处收货
			                    </c:when>      
			                    <c:when test="${ssesbintransit == 13 }">
			                   		 顾客取镜
			                    </c:when>      
			                    <c:when test="${ssesbintransit == 14 }">
			                   		 顾客退货
			                    </c:when>     
			                  </c:choose>  
			                </td> 
			                <td ${fn:trim(ssesbworrytype) eq '2' ? 'style="color: red;"' : '' }>
                              <c:choose>
								<c:when test="${fn:trim(ssesbworrytype) eq '2' }">
									  加急
			                    </c:when> 
			                    <c:otherwise>
									正常
			                    </c:otherwise>
			                  </c:choose>  
			                </td> 
						</c:if>
                          </tr> 
                     </s:iterator>
                      </tbody> 
                    </table>
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
				<!--      BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
				<!--	 END 分页 -->
					  </c:if>
                  </DIV>
                </DIV>
           <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
</TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
        
<!--        <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 -->
<!--                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>-->
        </TR></TBODY></TABLE>
            <!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body>
<script>
countSecond();
</script>

</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
