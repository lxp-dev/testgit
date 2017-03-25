<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>采购订单管理</title>
</head>
<script>
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) return;
		}
		
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
		var c11 = row.insertCell(10);	//曲率
		var c12 = row.insertCell(11);	//直径
		var c13 = row.insertCell(12);	//框架材质
		var c14 = row.insertCell(13);	//框架尺寸
		var c15 = row.insertCell(14);	//配件型
		var c16 = row.insertCell(15);	//使用类型 
		var c17 = row.insertCell(16);	//抛弃型分类
		var c18 = row.insertCell(17);	//老花镜度数
		var c19 = row.insertCell(18);	//厂家色号 
		var c20 = row.insertCell(19);	//主容量
		var c21 = row.insertCell(20);	//次容量

    	if('${permissionPo.keyh}' == '1'){
    		var c22 = row.insertCell(21);   //含税成本
    		var c23 = row.insertCell(22);   //数量
    		var c24 = row.insertCell(23);   //备注
    	}else{
    		var c23 = row.insertCell(21);   //数量
    		var c24 = row.insertCell(22);   //备注
    	}
		
		row.className = 'row';
		row.height="26";
		c1.height="26";
		
		c4.id="ys";		    //色号
	    c5.id="qj";		    //球镜
	    c6.id="zj"; 		//柱镜
	    c7.id="xjg"; 		//下加光
	    c8.id="zsl"; 		//折射率
	    c9.id="gdfl"; 		//光度分类
	    c10.id="clfl";		//材料分类
	    c11.id="ql"; 		//曲率
	    c12.id="zhj"; 		//直径
	    c13.id="kjcz"; 		//框架材质
	    c14.id="kjcc"; 		//框架尺寸
	    c15.id="pjlx"; 		//配件型
	    c16.id="sylx"; 		//使用类型 
	    c17.id="pqxfl";		//抛弃型分类
	    c18.id="lhjds";		//老花镜度数
	    c19.id="cjsh"; 		//厂家色号 
	    c20.id="zrl"; 		//主容量
	    c21.id="crl"; 		//次容量
	    
        c1.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c2.innerHTML = goodInfo.bgigoodsname;
		c3.innerHTML = goodInfo.bgispec;
		c4.innerHTML = goodInfo.bgisuppliercolor;
		c5.innerHTML = goodInfo.bgisph;		
		c6.innerHTML = goodInfo.bgicyl;				
		c7.innerHTML = goodInfo.bgibelowplusluminosity;
		c8.innerHTML = goodInfo.bgirefractive;
		var string1='';
		var string2='';
		var string3='';
		var string4='';
		var string5='';
		var string6='';
		 if(goodInfo.bgiismutiluminosity=="M"){string1='多光';}
		else if(goodInfo.bgiismutiluminosity=="0"){string1='单光';}
		else if(goodInfo.bgiismutiluminosity=="Q"){string1='其它';}
		else if(goodInfo.bgiismutiluminosity=="K"){string1='抗疲劳';}
		else if(goodInfo.bgiismutiluminosity=="J"){string1='渐近';}
		else {string1='';}
		 c9.innerHTML =string1;
		if(goodInfo.bgieyeglassmaterialtype=="1"){string2='树脂';}
			else if(goodInfo.bgieyeglassmaterialtype=="2"){string2='玻璃';}
			else if(goodInfo.bgieyeglassmaterialtype=="3"){string2='PC';}
			else{string2='';}
		c10.innerHTML = string2;
		
		c11.innerHTML = goodInfo.bgicurvature1;
		c12.innerHTML = goodInfo.bgidia;
		c13.innerHTML = goodInfo.bgiframematerialtypename;
		c14.innerHTML = goodInfo.bgiframesize;
		if(goodInfo.bgiframematerialtype=="1"){string4='框镜';}
		else if(goodInfo.bgiframematerialtype=="2"){string4='隐形';}
		else{string4='';}
		c15.innerHTML = string4;
		if(goodInfo.bgiusetype=="1"){string5='常带型';}
		else if(goodInfo.bgiusetype=="2"){string5='抛弃型';} 
		else if(goodInfo.bgiusetype=="3"){string5='塑形镜';} 
		else{string5='';}
		 c16.innerHTML = string5;
		if(goodInfo.bgistealthclass=="1"){string6='日抛';}
						else if(goodInfo.bgistealthclass=="2"){string6='周抛';} 
						else if(goodInfo.bgistealthclass=="9"){string6='双周抛';} 
						else if(goodInfo.bgistealthclass=="3"){string6='月抛';}
						else if(goodInfo.bgistealthclass=="4"){string6='季抛';}
						else if(goodInfo.bgistealthclass=="5"){string6='半年抛';}
						else if(goodInfo.bgistealthclass=="6"){string6='年抛';}
						else if(goodInfo.bgistealthclass=="7"){string6='RGP';}
						else if(goodInfo.bgistealthclass=="8"){string6='塑形镜';}
						else{string6='';}
		c17.innerHTML = string6;
		c18.innerHTML = goodInfo.bgisph;
		c19.innerHTML = goodInfo.bgisuppliercolor;
		c20.innerHTML = goodInfo.bgicapacity;
		c21.innerHTML = goodInfo.bgicapacityentry;

		if('${permissionPo.keyh}' == '1'){
		    c22.innerHTML = goodInfo.bgicostprice;
		}
		c23.innerHTML = goodInfo.bgigoodsquantity + '<input type="hidden" name="goodsInfoTempPo.goodsquantity" onblur="amount();" value="' + goodInfo.bgigoodsquantity+ '" maxlength="18" />'
		c24.innerHTML = goodInfo.remark;
		
		$('#del' + index).btn().init();
    }
   
    function init(){
  		<s:iterator value="procurementOrdersEntrys">
  		
  	    var json = {'bgigoodsid':'${cstpegoodsid}','bgigoodsbarcode':'${bgiGoodsBarCode}','bgigoodsname':'${bgigoodsname}',
  	    				'bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}','bginottaxrate':'${bginottaxrate}',
  	    				'bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}',
  	    				'bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}',
  	    				'bgigoodsquantity':'${cstpeordernumber}','bgipcbarcode':'${bgiGoodsBarCode }'+'00000000',
  	    				'bgiframematerialtype':'${bgiframematerialtype }','bgiframesize':'${bgiframesize}','bgiaccessoriestype':'${bgiaccessoriestype}',
  	                   'bgibelowplusluminosity':'${bgibelowplusluminosity }','bgirefractive':'${bgirefractive}','bgiismutiluminosity':'${bgiismutiluminosity}',
  	                   'bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgiusetype':'${bgiusetype}','bgistealthclass':'${bgistealthclass}',
  	                   'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry}','bgisuppliercolor':'${bgisuppliercolor}','bgiframematerialtypename':'${bgiframematerialtypename}',
  	    				'bgisource':'${bgisource}','remark':'${cstperemark}'};
  	    addRow(json)                
  		</s:iterator>
  		isshow($('#goodstype').val());
  		amount();

    }
    
    function amount(){
    	var goodsquantityTotal = 0;
		var goodsquantity = document.getElementsByName("goodsInfoTempPo.goodsquantity");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = parseFloat(goodsquantityTotal)+parseFloat(goodsquantity[i].value);
		}
		
		document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
	}
    
    function deleteitem(){
    
    	// 商品id去重
		var chk=document.getElementsByName("chk");
		var table = document.getElementById('a ddTable');
		for(i = 0; i < chk.length; i++){
			if (chk[i].checked ) {
				var curRow = chk[i].parentNode.parentNode;		

				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}
		
		document.all.chks.checked = false;
    }
    
    /**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }

	  function isshow(ordertype){
	    	if(ordertype==""){
	    		type = $('#cstpgoodscategory').val();
	    	}else{
	    		type = ordertype;
	    		$('#cstpgoodscategory').val(ordertype);
	    	}
	    	
	    	if(type == ""){
	    		$('#div_goodslist').attr("style","display: none;");
	    	}else{
	    		if(type!=3&&type!=4){
	    			$('#addTable').attr("style","display: block;");
	    			$('#addTable1').attr("style","display: none;");
	    		}else{
	    			$('#addTable').attr("style","display: none;");
	    			$('#addTable1').attr("style","display: block;");
	    		}
	    		if(type == "1"){
	    		
	    			$('[id=ys]').show();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').show();
	    			$('[id=kjcc]').show();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();

	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","7");
	    			}else{
	    				$('#heji').attr("colSpan","6");
		    		}	    	        

	    		}else if(type == "2"){
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').show();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();

	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","5");
	    			}else{
	    				$('#heji').attr("colSpan","4");
		    		}
				
	    		}else if(type == "3"){
	    			$('[id=ys]').hide();
	    			$('[id=qj]').show();
	    			$('[id=zj]').show();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').show();
	    			$('[id=zsl]').show();
	    			$('[id=gdfl]').show();
	    			$('[id=clfl]').show();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","10");
	    			}else{
	    				$('#heji').attr("colSpan","9");
		    		}					
	    			
	    		}else if(type == "4"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').show();
	    			$('[id=zj]').show();
	    			$('[id=ql]').show();
	    			$('[id=zhj]').show();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').show();
	    			$('[id=pqxfl]').show();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","10");
	    			}else{
	    				$('#heji').attr("colSpan","9");
		    		}	
	    			
	    		}else if(type == "5"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').show();
	    			$('[id=crl]').show();

	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","6");
	    			}else{
	    				$('#heji').attr("colSpan","5");
		    		}					
	    			
	    		}else if(type == "6"){
	    		
	    			$('[id=ys]').show();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').show();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","6");
	    			}else{
	    				$('#heji').attr("colSpan","5");
		    		}				
	    			
	    		}else if(type == "8"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').show();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').show();
	    			$('[id=cjsh]').show();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","7");
	    			}else{
	    				$('#heji').attr("colSpan","6");
		    		}				
	    			
	    		}else if(type == "7"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","4");
	    			}else{
	    				$('#heji').attr("colSpan","3");
		    		}				
	    			
	    		}else if(type == "9"){
	    		
	    			$('[id=ys]').hide();
	    			$('[id=qj]').hide();
	    			$('[id=zj]').hide();
	    			$('[id=ql]').hide();
	    			$('[id=zhj]').hide();
	    			$('[id=xjg]').hide();
	    			$('[id=zsl]').hide();
	    			$('[id=gdfl]').hide();
	    			$('[id=clfl]').hide();
	    			$('[id=kjcz]').hide();
	    			$('[id=kjcc]').hide();
	    			$('[id=pjlx]').hide();
	    			$('[id=sylx]').hide();
	    			$('[id=pqxfl]').hide();
	    			$('[id=lhjds]').hide();
	    			$('[id=cjsh]').hide();
	    			$('[id=zrl]').hide();
	    			$('[id=crl]').hide();
	    			
	    			if('${permissionPo.keyh}' == '1'){
	    				$('#heji').attr("colSpan","4");
	    			}else{
	    				$('#heji').attr("colSpan","3");
		    		}				
	    		}

	    		$('#div_goodslist').attr("style","display:");
	    	}
	    }  

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

    	$("input[name=checkedBrandid]").each(function(){
        	if($(this).val()=='${bid}'){
            	$(this).attr("checked",true);
        	}
        });
	});
	function checkIsShowTable(){
		var ishowValue=$("input[name=isShowProcurementOrders]:checked").val();
		if(ishowValue=='1'){
			$('#addTable').attr("style","display: none;");
			$('#addTable1').attr("style","display: block;");
		}
		if(ishowValue=='2'){
			$('#addTable').attr("style","display: block;");
			$('#addTable1').attr("style","display: none;");
		}
	}

    function queryCheckBrandGoodsInformation(){
        var bid=$("input[name=checkedBrandid]:checked").val();
        procurementOrdersForm.action = "initProcurementOrdersView.action?hid=${procurementOrdersPo.cstpid}&checkedBrandid="+bid+"&checkedtype=1";
        procurementOrdersForm.submit();
    }

    function setIframeHeight(iframe) {
    	if (iframe) {
    	var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
    	if (iframeWin.document.body) {
    	iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
    	}
    	}
    	};

    	window.onload = function () {
    	setIframeHeight(document.getElementById('external-frame'));
    	};
    
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onload="init();" >

<form name="procurementOrdersForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="goodstype" id="goodstype" value="${procurementOrdersPo.cstpgoodscategory}" /> 

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE width="100%" cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                    <c:if test="${statusPo.cshastatusapplybillid != null}">
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD width="95" class=tab id=tabLabel__1 onclick="JavaScript:window.location.href='allocationApplyDetails.action?hid=${statusPo.cshastatusapplybillid}';"                    
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">调拨申请单详细</TD>
                        <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                    <TD width=3><IMG id=tabImgLeft__0 height=22
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD width="80" align="center" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">采购订单详细</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
					<c:if test="${statusPo.cshastatusreceiptid != null}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD width="95" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='procurementReceiptDetails.action?hid=${statusPo.cshastatusreceiptid}';"
                      UNSELECTABLE="on">采购收货单详细</TD>
					    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                    </c:if>
                    <c:if test="${statusPo.cshastatusbillid != null}">
                        <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                        <TD width="95" class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif onclick="JavaScript:window.location.href='allocationDetails.action?hid=${statusPo.cshastatusbillid}';"
                      UNSELECTABLE="on">商品调拨单详细</TD>
					    <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3 ></TD>
                    </c:if>  
                    </TD>
                    <td width=auto align="right" valign="top">
                    	<s:action name="getFittingTemplateTypeInfo" executeResult="true">
                    		<c:choose>
                    			<c:when test="${procurementOrdersPo.cstpgoodscategory eq 3 || procurementOrdersPo.cstpgoodscategory eq 4 }">
                    				<s:param name="actionTypeID">6</s:param>
                    			</c:when>                    		
                    			<c:when test="${procurementOrdersPo.cstpgoodscategory ne 3 && procurementOrdersPo.cstpgoodscategory ne 4 }">
                    				<s:param name="actionTypeID">7</s:param>
                    			</c:when>
                    		</c:choose>
                    		<s:param name="actionImgUrl">${ctx}/img/newbtn/btn_print_0.png</s:param>
                    		<s:param name="actionFinereportRequestString">&logincompanyid=${person.personcompanyid}&poID=${procurementOrdersPo.cstpid}&querycost=${permissionPo.keyh}</s:param>
                    		<s:param name="actionReportingServiceRequestString">&logincompanyid=${person.personcompanyid}&poID=${procurementOrdersPo.cstpid}</s:param>
                    		<s:param name="actionReportTitle">采购订单</s:param>
                    	</s:action>
                    </td>
					</TR>
					</TBODY></TABLE></TD>
					<td></td>
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
					<table width="100%" id="title0"  border=0 align=center cellpadding=1 cellspacing=1 class="privateTable">
                      <TBODY>
                        <TR>
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=3 width="100%" align=center class="privateBorder" border=0>
                      <TBODY>
                        <TR>
                          <TD height="26" width="9%" class="table_body">单据编号</TD>
                          <TD width="24%" class="table_none">${procurementOrdersPo.cstpid }&nbsp;<input class="text_input200" type="hidden" name="procurementOrdersPo.cstpid" readonly="readonly" value="${procurementOrdersPo.cstpid }"></TD>
                          <TD width="9%" class="table_body" height="26">调拨申请单号</TD>
                          <TD width="24%" class="table_none" height="26">${procurementOrdersPo.cshaaabillid }&nbsp;<input class="text_input200" type="hidden" id='cshaaabillid' name="procurementOrdersPo.cshaaabillid" readonly="readonly" value="${procurementOrdersPo.cshaaabillid }"></TD>
                          <TD width="9%" class="table_body">采购类型</TD>
                          <TD class="table_none">
                          	  <input type="hidden" name="procurementOrdersPo.cstpgoodscategory" value="${procurementOrdersPo.cstpgoodscategory }" />
                          	   <c:choose>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 1 }">镜架</c:when>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 2 }">配件</c:when>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 3 }">镜片</c:when>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 4 }">隐形</c:when>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 5 }">护理液</c:when>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 6 }">太阳镜</c:when>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 8 }">老花镜</c:when>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 7 }">耗材</c:when>
                          	  	<c:when test="${procurementOrdersPo.cstpgoodscategory == 9 }">视光</c:when>
                          	  </c:choose>&nbsp;
						  </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">制造商</TD>
						  <TD align="left" class="table_none">
						   		${procurementOrdersPo.bspsuppliername}&nbsp;
						   		<input id="bspsuppliername" type="hidden" class="text_input120" name="bspsuppliername" readonly="readonly" value="${procurementOrdersPo.bspsuppliername }" />
						   		<input type="hidden" id="cstpsupplierid" name="procurementOrdersPo.cstpsupplierid" value="${procurementOrdersPo.cstpsupplierid }" />
						  </TD>
						  <TD class="table_body" height="26">制单人</TD>
                          <TD class="table_none">${procurementOrdersPo.createPersonName }&nbsp;<input class="text_input100" type="hidden" name="procurementOrdersPo.cstpcreateperson" value="${procurementOrdersPo.cstpcreateperson }"></TD>
                          <TD class="table_body">单据日期</TD>
                          <TD class="table_none" >${fn:substring(procurementOrdersPo.cstpcreatedate,0,16)}&nbsp;</TD>
						</TR> 
						<TR>
                          <TD class="table_body" height="26">审核人</TD>
                          <TD class="table_none">${procurementOrdersPo.auditPersonName }&nbsp;<input class="text_input100" type="hidden" name="procurementOrdersPo.cstpcreateperson" value="${procurementOrdersPo.cstpcreateperson }"></TD>
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none" colspan="3">${fn:substring(procurementOrdersPo.cstpauditdate,0,16)}&nbsp;
                          </TD>
                        </TR>
						<TR>
					      <TD class="table_body" height="26">收货联系人</TD>
                          <TD class="table_none">${procurementOrdersPo.cstpordersdeliveryperson}&nbsp;</TD>
                          <TD class="table_body">收货联系传真</TD>
                          <TD class="table_none">${procurementOrdersPo.cstpordersdeliveryfax}&nbsp;</TD>
                          <TD class="table_body">收货联系电话</TD>
                          <TD class="table_none">${procurementOrdersPo.cstpordersdeliveryphone}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="26">收货地址</TD>
                          <TD class="table_none" colspan="5">${procurementOrdersPo.cstpordersdeliveryaddress}&nbsp;</TD>
                        </TR>
                        <TR>
                          <TD height="40" class="table_body">备注</TD>
                          <TD class="table_none" colSpan=6><label>
                          ${procurementOrdersPo.cstpremark }&nbsp;
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <div id="showProcurementOrders" align="left">
                    	<input type="radio" checked="checked" name="isShowProcurementOrders" value="1" onclick="checkIsShowTable();">二维模式显示单据&nbsp;
                    	<input type="radio" name="isShowProcurementOrders" value="2" onclick="checkIsShowTable();">表单模式显示单据
                    </div>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table  id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" style="display: none;">
                      <TBODY>
                        <TR class=table_title align=middle>
						  <TH scope=col width="17%" height="26">商品代码</TH>
						  <TH scope=col width="20%">商品名称</TH>
                          <TH scope=col width="7%">型号</TH>
                          <TH width="6%" scope=col id=ys>厂家色号</TH>
                          <TH width="6%" scope=col id=qj>球镜</TH>
                          <TH width="6%" scope=col id=zj>柱镜</TH>
                          <TH width="6%" scope=col id=xjg>下加光</TH>
                          <TH width="6%" scope=col id=zsl>折射率</TH>
                          <TH width="6%" scope=col id=gdfl>光度分类</TH>
                          <TH width="6%" scope=col id=clfl>材料分类</TH>
                          <TH width="6%" scope=col id=ql>曲率</TH>
                          <TH width="6%" scope=col id=zhj>直径</TH> 
                          <TH width="6%" scope=col id=kjcz>框架材质</TH>
                          <TH width="6%" scope=col id=kjcc>框架尺寸</TH>
                          <TH width="6%" scope=col id=pjlx>配件型 </TH>
                          <TH width="6%" scope=col id=sylx>使用类型  </TH>
                          <TH width="6%" scope=col id=pqxfl>抛弃型分类  </TH>
                          <TH width="6%" scope=col id=lhjds>老花镜度数 </TH>
                          <TH width="6%" scope=col id=cjsh>厂家色号 </TH>
                          <TH width="6%" scope=col id=zrl>主容量 </TH>
                          <TH width="6%" scope=col id=crl>次容量 </TH>
                      <c:if test="${permissionPo.keyh == '1'}">
                          <TH scope=col width="5%">含税单价</TH>
                      </c:if>    
                          <TH scope=col width="5%">采购数量</TH>
                          <TH scope=col width="5%">备注</TH>
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26" id='heji' colSpan=10 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
					    	<TH scope=col width="10%" >&nbsp;</TH>
				   		</TR>
                      </TBODY>
                    </TABLE>
                    <table height="600px;"  id="addTable1" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" style="display: none;">
                      <TBODY>
                      <TR>
                      	  <td height="8" id="checkB">
	                      	<s:iterator value="goodsInfoPos" status="idx">
			                      	<input type="radio" name="checkedBrandid" value="${bgibrandid }" onclick="queryCheckBrandGoodsInformation();"> ${bgibrandname }&nbsp;&nbsp;&nbsp;&nbsp;
		                      </s:iterator>
	                      </td>
		              </TR>
                      <TR class=table_title align=middle>
	                      <td vAlign=top>
	                      	<iframe  id="reportFrame" src="report.action?reportlet=storage_procurementOrdersRpt2.cpt&poID=${procurementOrdersPo.cstpid }&brandid=${bid}" scrolling="no" width="100%" height="100%"></iframe>
	                      </td>
                      </TR>
                      </TBODY>
                    </table>
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
</body>
<script type="text/javascript">
	$('#showProcurementOrders').hide();
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
	    	$(this).attr("src",$(this).attr("src").replace("0","1"));
		}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
		});
		if('${procurementOrdersPo.cstpgoodscategory}'!=3&&'${procurementOrdersPo.cstpgoodscategory}'!=4){
		$('#showProcurementOrders').hide();
		}else{
			$('#showProcurementOrders').show();
		}
	});
</script>
</html>

<%@ include file="/WEB-INF/inc/message.jsp" %>