<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>委外订单管理</title>
</head>
<script>
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
			$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
			$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	function isshow(){
	
		if(${consignProcessOrderPo.cstcpoordergoodscategory} == "2"){
		
			$('[id=xj]').show();
			$('[id=lj]').show();
			$('[id=jd]').show();
			$('[id=ql]').hide();
			$('[id=zj]').hide();

		}

		if(${consignProcessOrderPo.cstcpoordergoodscategory} == "4"){
			$('[id=xj]').hide();
			$('[id=lj]').hide();
			$('[id=jd]').hide();
			$('[id=ql]').show();
			$('[id=zj]').show();

		}
	}   
	
	function addRow(salesInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		//var chk=document.getElementsByName("chk");
		//for(i = 0; i < chk.length; i++){
		//	if (chk[i].value == salesInfo.cstcpodgoodsid && chk[i].cstcpodglassflag == salesInfo.cstcpodglassflag) return;
		//}
		
			var row = table.insertRow(table.rows.length);
		
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		var c11 = row.insertCell(10);
		var c12 = row.insertCell(11);
		var c13 = row.insertCell(12);
		var c14 = row.insertCell(13);
		var c15 = row.insertCell(14);
		var c16 = row.insertCell(15);
		
		row.className = 'row';
		row.height="26";

		  c11.id="xj"; 		//下加
		  c12.id="lj";		//棱镜
		  c13.id="jd"; 		//基底
		  c14.id="ql"; 		//曲率
		  c15.id="zj"; 		//直径
		
		//配镜单号 取镜时间 商品名称 镜片
		//类型 数量 球镜 柱镜 轴向 下加 棱镜 基底 曲率 直径 特殊加
		//工要求 
		c1.height="26";
		
        c1.innerHTML = '<a href="javascript:void(0);" onclick="print(\''+salesInfo.cstcpodglassesbillid+'\')" >'+salesInfo.cstcpodglassesbillid+'</a><input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodglassesbillid" value="' + salesInfo.cstcpodglassesbillid +'" />';
        c2.innerHTML = salesInfo.cstcpodcustomername
        c3.innerHTML = salesInfo.cstcpodarriveddate + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodexpecteddate" value="' + salesInfo.cstcpodarriveddate +'" />';
		c4.innerHTML = salesInfo.cstcpodgoodsname + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodgoodsname" value="' + salesInfo.cstcpodgoodsname +'" />';
		if(salesInfo.cstcpoddragstype=="1"){
			c5.innerHTML = "委外订单";
		}
		if(salesInfo.cstcpoddragstype=="2"){
			c5.innerHTML = "委外加工";
		}
		c6.innerHTML = salesInfo.cstcpodglassflag + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodglassflag" value="' + salesInfo.cstcpodglassflag +'" />';
		c7.innerHTML = salesInfo.cstcpodnum + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodnum" value="' + salesInfo.cstcpodnum +'" />';
		c8.innerHTML = salesInfo.cstcpodballglass + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodballglass" value="' + salesInfo.cstcpodballglass +'" />';
		c9.innerHTML = salesInfo.cstcpodpostglass + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodpostglass" value="' + salesInfo.cstcpodpostglass +'" />';
		c10.innerHTML = salesInfo.cstcpodaxes + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodaxes" value="' + salesInfo.cstcpodaxes +'" />';
		c11.innerHTML = salesInfo.cstcpodadd + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodadd" value="' + salesInfo.cstcpodadd +'" />';
		c12.innerHTML = salesInfo.cstcpodarriseglass + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodarriseglass" value="' + salesInfo.cstcpodarriseglass +'" />';
		c13.innerHTML = salesInfo.cstcpodbasis + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodbasis" value="' + salesInfo.cstcpodbasis +'" />';
		c14.innerHTML = salesInfo.cstcpodeyecurvature + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodeyecurvature" value="' + salesInfo.cstcpodeyecurvature +'" />';		
		c15.innerHTML = salesInfo.cstcpoddiameter + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpoddiameter" value="' + salesInfo.cstcpoddiameter +'" />';
		c16.innerHTML = salesInfo.cstcpodrequirement + '<input type="hidden" name="consignProcessOrderDetailsTemp.cstcpodrequirement" value="' + salesInfo.cstcpodrequirement +'" />';
	
	   	isshow();
    }
	function addRowReTable1(salesInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		var row = table.insertRow(table.rows.length);
		row.height="28";
		row.className = 'table_title';
		row.align="center";
		if('2'=='${consignProcessOrderPo.cstcpoordergoodscategory}'){
			var c1 = row.insertCell(0);
			var c2 = row.insertCell(1);
			var c3 = row.insertCell(2);
			var c4 = row.insertCell(3);
			var c5 = row.insertCell(4);
			var c6 = row.insertCell(5);
			var c7 = row.insertCell(6);
			var c8 = row.insertCell(7);
			var c9 = row.insertCell(8);
			c1.colSpan=2;
			c2.colSpan=3;
			c7.colSpan=2;
			c8.colSpan=2;
			c1.innerHTML = '销售备注('+salesInfo.cstcpodglassesbillid+')';
			c2.innerHTML = '处方备注';
			c5.innerHTML = '中梁';
			c6.innerHTML = '对角线';
			c7.innerHTML = '框型';
			c8.innerHTML = '镜片通道';
			c3.innerHTML = '片高';
			c4.innerHTML = '片宽';
			c9.innerHTML = '直径';
		}
		if('4'=='${consignProcessOrderPo.cstcpoordergoodscategory}'){
			var c1 = row.insertCell(0);
			var c2 = row.insertCell(1);
			c1.colSpan=5;
			c2.colSpan=11;
			c1.innerHTML = '销售备注('+salesInfo.cstcpodglassesbillid+')';
			c2.innerHTML = '处方备注';
		}
    }
	function addRowReTable2(salesInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		var row = table.insertRow(table.rows.length);
		row.height="28";
		row.className = 'row';
		if('2'=='${consignProcessOrderPo.cstcpoordergoodscategory}'){
			var c1 = row.insertCell(0);
			var c2 = row.insertCell(1);
			var c3 = row.insertCell(2);
			var c4 = row.insertCell(3);
			var c5 = row.insertCell(4);
			var c6 = row.insertCell(5);
			var c7 = row.insertCell(6);
			var c8 = row.insertCell(7);
			var c9 = row.insertCell(8);
			c1.colSpan=2;
			c2.colSpan=3;
			c7.colSpan=2;
			c8.colSpan=2;
			c3.innerHTML = salesInfo.ssesbglasshige;
			c4.innerHTML = salesInfo.ssesbglasswigth;
			c5.innerHTML = salesInfo.ssesbframemiddlesize;
			c6.innerHTML = salesInfo.ssesbgiagonalline;
			c7.innerHTML = salesInfo.ssesbframeform;
			c8.innerHTML = salesInfo.ssesbgalssroad;
			c1.innerHTML = salesInfo.cstcposalesremark;
			c2.innerHTML = salesInfo.cstcpodignosisre;
			c9.innerHTML = salesInfo.ssesbframedia;
		}
		if('4'=='${consignProcessOrderPo.cstcpoordergoodscategory}'){
			var c1 = row.insertCell(0);
			var c2 = row.insertCell(1);
			c1.colSpan=5;
			c2.colSpan=11;
			c1.innerHTML = salesInfo.cstcposalesremark;
			c2.innerHTML = salesInfo.cstcpodignosisre;
		}
    }
    
    function print(id){
        if (id.substring(0,1) != 'X'){
            alert('外部配镜单没有详细信息!');
            return;
        }
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selectInTransitDetails.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selectInTransitDetails.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单信息】";
	}  
    
    
    function init(){
	   	<c:forEach var="po" items="${consignProcessOrderDetails}">
		if(''!='${po.cstcpodgoodsid}'){
		   	addRow({'cstcpodglassesbillid':'${po.cstcpodglassesbillid}',
		   			'cstcpodgoodsid':'${po.cstcpodgoodsid}','cstcposalesremark':'${po.cstcposalesremark}','cstcpodignosisre':'${po.cstcpodignosisre}',
		   			'cstcpodcustomername':'${po.cstcpodcustomername}','ssesbglasshige':'${po.ssesbglasshige}','ssesbglasswigth':'${po.ssesbglasswigth}','ssesbframemiddlesize':'${po.ssesbframemiddlesize}',
		   			'cstcpodbilltype':'${po.cstcpodbilltype}','ssesbgalssroad':'${po.ssesbgalssroad}','ssesbgiagonalline':'${po.ssesbgiagonalline}','ssesbframeform':'${po.ssesbframeform}',
		           	'cstcpodarriveddate':'${fn:substring(po.cstcpodexpecteddate,0,10)}','ssesbgiagonalline':'${po.ssesbgiagonalline}',
		           	'cstcpodgoodsname':'${po.cstcpodgoodsname}',
		           	'cstcpodglassflag':'${po.cstcpodglassflag}',
		           	'cstcpodnum':'${po.cstcpodnum}',
		           	'cstcpodballglass':'${po.cstcpodballglass}',
		           	'cstcpodpostglass':'${po.cstcpodpostglass}',
		           	'cstcpodaxes':'${po.cstcpodaxes}',
		           	'cstcpodadd':'${po.cstcpodadd}',
		           	'cstcpodarriseglass':'${po.cstcpodarriseglass}',
		           	'cstcpodbasis':'${po.cstcpodbasis}',
		           	'cstcpodeyecurvature':'${po.cstcpodeyecurvature}',
		           	'cstcpoddiameter':'${po.cstcpoddiameter}',
		           	'cstcpodrequirement':'${po.cstcpodrequirement}',
		           	'ssesbcustomerid':'${po.cstcpodcustomerid}',
		           	'cstcpodordertype':'${po.cstcpodordertype}','ssesbframedia':'${po.ssesbframedia}',
		           	'cstcpodrequirement1':'${po.cstcpodrequirement1}','cstcpoddragstype':'${po.cstcpoddragstype}','cstcpodcustomername':'${po.cstcpodcustomername}'});
 	}else{
   		
   		addRowReTable1({'cstcpodglassesbillid':'${po.cstcpodglassesbillid}',
   			'cstcpodgoodsid':'${po.cstcpodgoodsid}','cstcposalesremark':'${po.cstcposalesremark}','cstcpodignosisre':'${po.cstcpodignosisre}',
   			'cstcpodcustomername':'${po.cstcpodcustomername}','ssesbglasshige':'${po.ssesbglasshige}','ssesbglasswigth':'${po.ssesbglasswigth}','ssesbframemiddlesize':'${po.ssesbframemiddlesize}',
   			'cstcpodbilltype':'${po.cstcpodbilltype}','ssesbgalssroad':'${po.ssesbgalssroad}','ssesbgiagonalline':'${po.ssesbgiagonalline}','ssesbframeform':'${po.ssesbframeform}',
           	'cstcpodarriveddate':'${fn:substring(po.cstcpodarriveddate,0,10)}','ssesbgiagonalline':'${po.ssesbgiagonalline}',
           	'cstcpodgoodsname':'${po.cstcpodgoodsname}',
           	'cstcpodglassflag':'${po.cstcpodglassflag}',
           	'cstcpodnum':'${po.cstcpodnum}',
           	'cstcpodballglass':'${po.cstcpodballglass}',
           	'cstcpodpostglass':'${po.cstcpodpostglass}',
           	'cstcpodaxes':'${po.cstcpodaxes}',
           	'cstcpodadd':'${po.cstcpodadd}',
           	'cstcpodarriseglass':'${po.cstcpodarriseglass}',
           	'cstcpodbasis':'${po.cstcpodbasis}',
           	'cstcpodeyecurvature':'${po.cstcpodeyecurvature}',
           	'cstcpoddiameter':'${po.cstcpoddiameter}',
           	'cstcpodrequirement':'${po.cstcpodrequirement}',
           	'ssesbcustomerid':'${po.cstcpodcustomerid}',
           	'cstcpodordertype':'${po.cstcpodordertype}','ssesbframedia':'${po.ssesbframedia}',
           	'cstcpodrequirement1':'${po.cstcpodrequirement1}','cstcpodinter':'${po.cstcpodinter}','cstcpoddragstype':'${po.cstcpoddragstype}','cstcpodsalesbillid':'${po.cstcpodsalesbillid}','cstcpodsalesid':'${po.cstcpodsalesid}'});
   		addRowReTable2({'cstcpodglassesbillid':'${po.cstcpodglassesbillid}',
   			'cstcpodgoodsid':'${po.cstcpodgoodsid}','cstcposalesremark':'${po.cstcposalesremark}','cstcpodignosisre':'${po.cstcpodignosisre}',
   			'cstcpodcustomername':'${po.cstcpodcustomername}','ssesbglasshige':'${po.ssesbglasshige}','ssesbglasswigth':'${po.ssesbglasswigth}','ssesbframemiddlesize':'${po.ssesbframemiddlesize}',
   			'cstcpodbilltype':'${po.cstcpodbilltype}','ssesbgalssroad':'${po.ssesbgalssroad}','ssesbgiagonalline':'${po.ssesbgiagonalline}','ssesbframeform':'${po.ssesbframeform}',
           	'cstcpodarriveddate':'${fn:substring(po.cstcpodarriveddate,0,10)}','ssesbgiagonalline':'${po.ssesbgiagonalline}',
           	'cstcpodgoodsname':'${po.cstcpodgoodsname}',
           	'cstcpodglassflag':'${po.cstcpodglassflag}',
           	'cstcpodnum':'${po.cstcpodnum}',
           	'cstcpodballglass':'${po.cstcpodballglass}',
           	'cstcpodpostglass':'${po.cstcpodpostglass}',
           	'cstcpodaxes':'${po.cstcpodaxes}',
           	'cstcpodadd':'${po.cstcpodadd}',
           	'cstcpodarriseglass':'${po.cstcpodarriseglass}',
           	'cstcpodbasis':'${po.cstcpodbasis}',
           	'cstcpodeyecurvature':'${po.cstcpodeyecurvature}',
           	'cstcpoddiameter':'${po.cstcpoddiameter}',
           	'cstcpodrequirement':'${po.cstcpodrequirement}',
           	'ssesbcustomerid':'${po.cstcpodcustomerid}',
           	'cstcpodordertype':'${po.cstcpodordertype}','ssesbframedia':'${po.ssesbframedia}',
           	'cstcpodrequirement1':'${po.cstcpodrequirement1}','cstcpodinter':'${po.cstcpodinter}','cstcpoddragstype':'${po.cstcpoddragstype}','cstcpodsalesbillid':'${po.cstcpodsalesbillid}','cstcpodsalesid':'${po.cstcpodsalesid}'});
   	}
	   	</c:forEach>
	   	amount();
    }
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("consignProcessOrderDetailsTemp.cstcpodnum");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
    
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onload="init();" >

<form name="procurementOrdersForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 



<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD align="right" colspan="3">
               	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
					<s:param name="actionTypeID">
						<c:choose>
		               		<c:when test="${consignProcessOrderPo.cstcpoordergoodscategory == 2 }">11</c:when>
		               		<c:when test="${consignProcessOrderPo.cstcpoordergoodscategory == 4 }">46</c:when>
                   	 	</c:choose>
					</s:param>
               		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
               		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&selesCounts=${selesCounts}&cstcpoorderbillid=${consignProcessOrderPo.cstcpoorderbillid}</s:param>
               		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&cstcpoorderbillid=${consignProcessOrderPo.cstcpoorderbillid}</s:param>
               		<s:param name="actionReportTitle">委外订单打印</s:param>
               	</s:action>	          	
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
                vAlign=top>
                <DIV id=tabContent__1>
                  <DIV>
					<table width="100%" id="title0" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR>
                          <TD width="9%" height="26" class="table_body">单据编号</TD>
                          <TD width="24%" class="table_none">&nbsp;${consignProcessOrderPo.cstcpoorderbillid }<input class="text_input200" type="hidden" name="consignProcessOrderPo.cstcpoorderbillid" readonly="readonly" value="${consignProcessOrderPo.cstcpoorderbillid }"></TD>
                          <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">&nbsp;${fn:substring(consignProcessOrderPo.cstcpobilldate,0,16)}                        
                          <input class="text_input100" type="hidden"
					       name="consignProcessOrderPo.cstcpobilldate" type="text" readonly="readonly" 
					       		value="${consignProcessOrderPo.cstcpobilldate}" /></TD>						   
						  <TD height="26" class="table_body">订单类型</TD>
                          <TD class="table_none" >
                          	<c:choose>
                          		<c:when test="${consignProcessOrderPo.cstcpoordergoodscategory == 2 }">&nbsp;框镜订做片</c:when>
                          		<c:when test="${consignProcessOrderPo.cstcpoordergoodscategory == 4 }">&nbsp;隐形订做片</c:when>
                          	</c:choose>
                          	<input type="hidden" id="cstcpoordergoodscategory" name="consignProcessOrderPo.cstcpoordergoodscategory" value="${consignProcessOrderPo.cstcpoordergoodscategory }" />
						  </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">制单人</TD>
                          <TD class="table_none">&nbsp;${consignProcessOrderPo.createPersonName }</TD>
                           <TD width="9%" class="table_body">制造商</TD>
						   <TD height="26" align="left" class="table_none" colspan="3">
						   &nbsp;${consignProcessOrderPo.bspsuppliername }<input type="hidden" id="cstcposupplierid" name="consignProcessOrderPo.cstcposupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '制造商不能为空！'}]" value="${consignProcessOrderPo.cstcposupplierid }"/>
						   </TD>
						</TR>
						<TR>
                          <TD class="table_body" height="26">收货联系人</TD>
                          <TD class="table_none">&nbsp;${consignProcessOrderPo.cstcpodeliveryperson}</TD>
                          <TD class="table_body">收货联系电话</TD>
                          <TD class="table_none">&nbsp;${consignProcessOrderPo.cstcpodeliveryphone}</TD>
                          <TD class="table_body">收货联系传真</TD>
                          <TD class="table_none">&nbsp;${consignProcessOrderPo.cstcpodeliveryfax}</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">收货地址</TD>
                          <TD class="table_none" colspan="5">&nbsp;${consignProcessOrderPo.cstcpodeliveryaddress}</TD>
                        </TR>
                        <TR>
                          <TD height="62" class="table_body">备注</TD>
                          <TD class="table_none" colspan="5">&nbsp;${consignProcessOrderPo.cstcporemark }</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH scope=col width="12%" height="26">配镜单号</TH>
						  <TH scope=col width="10%" height="26">顾客姓名</TH>
                          <TH scope=col width="10%">取镜时间</TH>
                          <TH scope=col width="14%">商品名称</TH>
                          <TH scope=col width="6%">委外方式</TH>
                          <TH scope=col width="5%">镜片类型</TH>
                          <TH scope=col width="5%">数量</TH>
                          <TH scope=col width="5%">球镜</TH>
                          <TH scope=col width="5%">柱镜</TH>
                          <TH scope=col width="3%">轴向</TH>
                          <TH scope=col width="3%" id=xj>下加</TH>
                          <TH scope=col width="3%" id=lj>棱镜</TH>
                          <TH scope=col width="3%" id=jd>基底</TH>
                          <TH scope=col width="4%" id=ql>曲率</TH>
                          <TH scope=col width="3%" id=zj>直径</TH>
                          <TH scope=col width="8%">加工<br/>要求</TH>

                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col  height="26" id="goodsquantityTotal">0</TH>
					    	<TH scope=col  >&nbsp;</TH>
					    	<TH scope=col  >&nbsp;</TH>
					    	<TH scope=col  >&nbsp;</TH>
					    	<TH scope=col  id=xj>&nbsp;</TH>
					    	<TH scope=col  id=lj>&nbsp;</TH>
					    	<TH scope=col  id=jd>&nbsp;</TH>
					    	<TH scope=col  id=ql>&nbsp;</TH>
					    	<TH scope=col  id=zj>&nbsp;</TH>
					    	<TH scope=col  >&nbsp;</TH>
				   		</TR>
				   		<c:if test="${selesCount==1}">
				   			<tr class=table_title><td colspan="14" height="26" >&nbsp;销售备注：${consignProcessOrderPo.cstcposalesremark}</td></tr>
				   		</c:if>
				   		<c:if test="${selesCounts==1}">
				   			<tr class=table_title><td colspan="14" height="26" >&nbsp;处方备注：${consignProcessOrderPo.cstcpodignosisre}</td></tr>
				   		</c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>