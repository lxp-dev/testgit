<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成镜类维护</title>
</head>
<script>	
	function disableWhole(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initDisableAllWholeAR.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initDisableAllWholeAR.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【批发停用】";
	}
	function ableWhole(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initAbleAllWholeAR.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initAbleAllWholeAR.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【批发启用】";
	}


	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	glassesFinishForm.action=link;
	  	glassesFinishForm.submit();		
		showLoadingBar();
	}
	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initGlassesFinishUpdateAR.action?moduleID=${requestScope.moduleID}&goodsTree="+goodsTree+"&parent="+parent+"&hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGlassesFinishUpdateAR.action?moduleID=${requestScope.moduleID}&goodsTree="+goodsTree+"&parent="+parent+"&hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【太阳镜修改】";
	}
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGlassesFinishDetailsAR.action?moduleID=${requestScope.moduleID}&hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGlassesFinishDetailsAR.action?moduleID=${requestScope.moduleID}&hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【太阳镜详细】";
	}
	function search(){
		$("img").removeAttr("onclick");
		glassesFinishForm.action = "selGlassesFinishAR.action";
		glassesFinishForm.submit();		
		showLoadingBar();
	}
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initGlassesFinishInsertAR.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGlassesFinishInsertAR.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【太阳镜新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){ 
		showPopWin("initGlassesFinishDeleteAR.action?hid="+id+"&goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initGlassesFinishDeleteAR.action?hid="+id+"&goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【太阳镜删除】";
	}
	function disableGlassesFinish(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initGlassesFinishDisableAR.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initGlassesFinishDisableAR.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【太阳镜停用】";
	}
	function ableGlassesFinish(id){
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin("initGlassesFinishAbleAR.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin("initGlassesFinishAbleAR.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		} 
		document.getElementById('popupTitle').innerHTML="【太阳镜启用】";
	}
	function clean(){
		document.getElementById('goodsID').value = "";
		document.getElementById('goodsName').value = "";
		$('#supplierID').val("");
		$('#supplierName').val("");
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('bgiretailbeginprice').value = "";
		document.getElementById('bgiretailendprice').value = "";
		document.getElementById('bgicostbeginprice').value = "";
		document.getElementById('bgicostendprice').value = "";
		document.getElementById('isClosed').value = "";
		document.getElementById('bgispecjj').value = "";
		document.getElementById('bgicolorjj').value = "";
		document.getElementById('bgiframesizejj').value = "";
		document.getElementById('barcodeflag').value = "";
		document.getElementById('bgipayfeeid').value = "";
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
			showPopWin("selSupplierOpen.action?categoryID_open=6",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=6",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open=6&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=6&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 

		var isshow = '${select_retail }';
		if(isshow == '1'){
			$("#div_retail").show();
		}else{
			$("#div_retail").hide();
			$("#bgiretailbeginprice").val("");
			$("#bgiretailendprice").val("");
		}

		if('${bgiissetflag}' == ''){
			$('#radioBtn_1').attr('checked',true);
		}
		if('${bgiissetflag}' != '3'){
			$('#bgipayfeeid').attr("disabled","disabled");
		}
		$('#radioBtn_3').click(function(){
			$('#bgipayfeeid').attr("disabled","");
		});
		$('#radioBtn_1').click(function(){
			$('#bgipayfeeid').val("");
			$('#bgipayfeeid').attr("disabled","disabled");
		})
		$('#radioBtn_2').click(function(){
			$('#bgipayfeeid').val("");
			$('#bgipayfeeid').attr("disabled","disabled");
		})
	});

	function ismendretail(){
		var isshow = $("#select_retail").val();
		if(isshow == '1'){
			$("#div_retail").show();
		}else{
			$("#div_retail").hide();
			$("#bgiretailbeginprice").val("");
			$("#bgiretailendprice").val("");
		}
	}

	function xiaoshou(type){
        if ($('input[id=chk]:checked').size() == 0){
            alert('请选取商品!');
            return;
        }

        var billID = '';
        $('input[id=chk]:checked').each(function(){ 
        	billID = billID + $(this).val() + ',';
        }); 
          
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initGoodsSalesAbleBatch.action?moduleID=${requestScope.moduleID}&hid="+billID+"&type="+type,400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【批量销售启用/停用】";
	}

	function pifajia(type){
        if ($('input[id=chk]:checked').size() == 0){
            alert('请选取商品!');
            return;
        }

        var billID = '';
        $('input[id=chk]:checked').each(function(){ 
        	billID = billID + $(this).val() + ',';
        }); 
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initGoodsWholePriceAbleBatch.action?moduleID=${requestScope.moduleID}&hid="+billID+"&type="+type,400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【批量批发价启用/停用】";
	}

	function shanchu(){
        if ($('input[id=chk]:checked').size() == 0){
            alert('请选取商品!');
            return;
        }

        var billID = '';
        $('input[id=chk]:checked').each(function(){ 
        	billID = billID + $(this).val() + ',';
        }); 
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initGoodsInfoDeleteBatch.action?moduleID=${requestScope.moduleID}&hid="+billID,400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【批量删除】";
	}

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
    
    function inserts(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initGlassesFinishManyInsertAR.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGlassesFinishManyInsertAR.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		
		document.getElementById('popupTitle').innerHTML="【太阳镜类批量新增】";
	}
    function changeflag(str){
		document.getElementById('bgiissetflag').value = str;
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFinishForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>商品信息维护</TD>
            <TD align="left"  width="30%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：太阳镜维护</TD>
            <td align="right" width="55%" valign="bottom">&nbsp;
            	<a href="${ctx}/img/example/商品批量录入模板.xls" ><img style="vertical-align:middle" border="0" src="${ctx }/img/newbtn/btn_framemodel_0.png" btn=btn title="镜架批量导入模板下载"/></a>
            	<c:if test="${(permissionPo.keya==1)}">
            		<img src="${ctx }/img/newbtn/btn_tyjladd_0.png" btn=btn title="太阳镜类新增" onClick="insert()">
            		<img src="${ctx }/img/newbtn/btn_tyjladds_0.png" btn=btn title="太阳镜类批量新增" onClick="inserts()">
            	</c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          
          <TR>
			<TD class=menubar_function_text colspan="3">
				<table></table></TD>
		  </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif
                      onclick="JavaScript:window.location.href='initGlassesFrameSelAR.action?moduleID=${requestScope.moduleID}';" 
                      UNSELECTABLE="on">镜架</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initGlassesAccessoriesSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">配件</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initLensFinishedSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">成品镜片</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initLensCustomSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">车房镜片</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initStealthFinishedSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">软性接触镜成品</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initStealthCustomLensesSelDAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">软性接触镜订制</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initStealthCustomLensesSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">硬性接触镜</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initStealthAccessoriesSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">护理液</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      onclick="JavaScript:window.location.href='initGlassesFinishSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">太阳镜</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPresbyopicGlassesSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">老花镜</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initOtherGoodsSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">耗材</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initVisualOpticsSelAR.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">其他视光产品</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                   
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
						   <TD width="60" height="26" class="table_body" align="left">商品代码</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD width="60" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
				                <c:if test="${person.syspsupplierid ne ''}">
							   		<li class="horizontal_onlyRight">
							   		${person.syspsuppliername }
							   		<input type="hidden" name="supplierID" value="${person.syspsupplierid }" />
								   	</li>
							   	</c:if>
							   	<c:if test="${person.syspsupplierid eq ''}">
							   		<li class="horizontal_onlyRight">
							   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
							   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
								    </li>
								    <li class="horizontal_onlyRight">
								    <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
								    </li>
							   	</c:if>

			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" ></li>
			               </TD>
			               <TD  height="26" class="table_body"><select id="whichretail" name="whichretail">
	                            <c:if test="${systemParameterPo.fspretailprice=='1' }">
									<option value="1" ${whichretail == '1' ? 'selected':'' }>标准零售价格</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricea=='1' }">
									<option value="2" ${whichretail == '2' ? 'selected':'' }>零售价格2</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceb=='1' }">
									<option value="3" ${whichretail == '3' ? 'selected':'' }>零售价格3</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricec=='1' }">
									<option value="4" ${whichretail == '4' ? 'selected':'' }>零售价格4</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriced=='1' }">
									<option value="5" ${whichretail == '5' ? 'selected':'' }>零售价格5</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricee=='1' }">
									<option value="6" ${whichretail == '6' ? 'selected':'' }>零售价格6</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricef=='1' }">
									<option value="7" ${whichretail == '7' ? 'selected':'' }>零售价格7</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceg=='1' }">
									<option value="8" ${whichretail == '8' ? 'selected':'' }>零售价格8</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceh=='1' }">
									<option value="9" ${whichretail == '9' ? 'selected':'' }>零售价格9</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricei=='1' }">
									<option value="10" ${whichretail == '10' ? 'selected':'' }>零售价格10</option>
								</c:if>
	                      	  </select></TD>
			               <TD  class="table_none">
			               <select id="select_retail" name="select_retail" onclick="ismendretail()">
			               	<option value="1" ${select_retail == '1' ? 'selected':'' }>已设置零售价</option>
			               	<option value="0" ${select_retail == '0' ? 'selected':'' }>未设置零售价</option>
			               </select>
			               <div id="div_retail"><input class="text_input100" type="text"  id="bgiretailbeginprice" name="bgiretailbeginprice" 

value="${requestScope.bgiretailbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"> ~ <input class="text_input100" type="text"  id="bgiretailendprice" 

name="bgiretailendprice" value="${requestScope.bgiretailendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"></div>
			               </TD>
                        <c:if test="${(permissionPo.keyf==1)}">
			               <TD  height="26" class="table_body">爱尔结算价</TD>
			               <TD  class="table_none"> <input class="text_input100" type="text"  id="bgicostbeginprice" name="bgicostbeginprice" value="${requestScope.bgicostbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"> ~ <input class="text_input100" type="text"  id="bgicostendprice" name="bgicostendprice" value="${requestScope.bgicostendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"></TD>
                        </c:if>
                        <c:if test="${(permissionPo.keyf==0)}">
			               <TD  height="26" class="table_body">&nbsp;</TD>
			               <TD  class="table_none">&nbsp;</TD>
                        </c:if>
                        </TR>
                        <tr>
                           <TD height="26" class="table_body">型号</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="bgispecjj" name="bgispecjj" value="${requestScope.bgispecjj}" maxlength="30">
			               </TD>
						   <TD height="26" class="table_body" >色号</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgicolorjj" name="bgicolorjj" value="${bgicolorjj}" maxlength="10">
			               </TD>
			               <TD height="26" class="table_body">尺寸</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="bgiframesizejj" name="bgiframesizejj" value="${requestScope.bgiframesizejj}" maxlength="10">
			               </TD>
                        </tr>
                        <TR>
						  <TD height="26" class="table_body">
						                     启用状态
							</TD>
							<TD class="table_none">
								<select id="isClosed" name="isClosed">
                            	<option value="">----请选择----</option>
                            	<option value="1" ${requestScope.isClosed eq 1 ? 'selected="selected"' : '' }>启用</option>
                            	<option value="0" ${requestScope.isClosed eq 0 ? 'selected="selected"' : '' }>停用</option>
								</select>
							</TD>
                        	<TD height="26" class="table_body">批号管理</TD>
			                <TD class="table_none" colspan="3">
                            <select id="barcodeflag" name="barcodeflag">
                            	<option value="">----请选择----</option>
                            	<option value="1" ${barcodeflag eq 1 ? 'selected="selected"' : '' }>是</option>
                            	<option value="0" ${barcodeflag eq 0 ? 'selected="selected"' : '' }>否</option>
                            </select>
			               </TD>
			            </tr>
			            <c:if test="${systemParameterPo.fsphisflag eq '2'}">
                        <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
								   <li class="horizontal_onlyRight">
								 <input type="hidden" id="bgiissetflag" name="bgiissetflag" value="${bgiissetflag}">
                                   <input type="radio" id="radioBtn_1" name="radioBtn" value="1" onclick="changeflag('1')" ${bgiissetflag == '1' ? 'checked' : '' }>全部
      	                           <input type="radio" id="radioBtn_2" name="radioBtn" value="2" onclick="changeflag('2')" ${bgiissetflag == '2' ? 'checked' : '' }>未设置
      	                           <input type="radio" id="radioBtn_3" name="radioBtn" value="3" onclick="changeflag('3')" ${bgiissetflag == '3' ? 'checked' : '' }>已设置
		                           </li>
								   <li class="horizontal_onlyRight">
								     <select id="bgipayfeeid" name="bgipayfeeid" >
	                                   <option value="">---请选择---</option>
	                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
			                               <option value="${optionParamPoTmp.fopparamid }" ${(bgipayfeeid == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                              </c:if>	                                      	
		                               </c:forEach> 
	                            	 </select>
		                           </li>
		      	             </TD>                
	                      </TR>
	                      </c:if>
                      </TBODY>
                    </TABLE>
                    
                    <table id="title2" cellspacing="2">
						<tr height="26">
							<td width="100%">
							<c:if test="${(permissionPo.keyd==1)}">
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
								</c:if>
							</td>
							<td width="20%" align="right">
							   <c:if test="${permissionPo.keyk==1}">
								 <img btn=btn  src="${ctx }/img/newbtn/btn_plxsqy_0.png" title="批量销售启用" onClick="javascript:xiaoshou('1')">
							   </c:if>
							</td>
							<td width="20%" align="right">
							   <c:if test="${permissionPo.keyk==1}">
								 <img btn=btn  src="${ctx }/img/newbtn/btn_plxsty_0.png" title="批量销售停用" onClick="javascript:xiaoshou('0')">
							   </c:if>
							</td>
							<td width="20%" align="right">
							   <c:if test="${permissionPo.keyl==1 && systemParameterPo.fspwholesalepriceset == '0' }">
								 <img btn=btn  src="${ctx }/img/newbtn/btn_plpfjqy_0.png" title="批量批发价启用" onClick="javascript:pifajia('1')">
							   </c:if>
							</td>
							<td width="20%" align="right">
							   <c:if test="${permissionPo.keyl==1 && systemParameterPo.fspwholesalepriceset == '0' }">
								 <img btn=btn  src="${ctx }/img/newbtn/btn_plpfjty_0.png" title="批量批发价停用" onClick="javascript:pifajia('0')">
							   </c:if>
							</td>
							<td width="20%" align="right">
							   <c:if test="${permissionPo.keym==1}">
								 <img btn=btn  src="${ctx }/img/newbtn/btn_plsc_0.png" title="批量删除" onClick="javascript:shanchu()">
							   </c:if>
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
					<c:if test="${not empty(glassesFinishList)}"> 
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
                        <TH width="3%" scope=col><input type="checkbox" id="chks" name="chks" onclick="chkAll()"></TH>
                        <TH width="15%" height="26" scope=col colspan="5">操作</TH>
                          <TH width="16%" scope=col>商品代码</TH>
                          <TH scope=col>商品名称</TH>
                          <TH width="20%" scope=col>商品品种</TH>
                          <TH width="4%" scope=col>单位</TH>
                          <TH width="8%" scope=col>
                          		<c:if test="${whichretail=='1'}">
                        			标准零售价格
								</c:if>
								<c:if test="${whichretail=='2'}">
                        			零售价格2
								</c:if>
								<c:if test="${whichretail=='3'}">
                        			零售价格3
								</c:if>
								<c:if test="${whichretail=='4'}">
                        			零售价格4
								</c:if>
								<c:if test="${whichretail=='5'}">
                        			零售价格5
								</c:if>
								<c:if test="${whichretail=='6'}">
                        			零售价格6
								</c:if>
								<c:if test="${whichretail=='7'}">
                        			零售价格7
								</c:if>
								<c:if test="${whichretail=='8'}">
                        			零售价格8
								</c:if>
								<c:if test="${whichretail=='9'}">
                        			零售价格9
								</c:if>
								<c:if test="${whichretail=='10'}">
                        			零售价格10
								</c:if>
						  </TH>

                          <c:if test="${(permissionPo.keyf==1)}">
                          <TH width="7%" scope=col>爱尔结算价</TH>
                          </c:if>
                         <TH width="5%" scope=col>状态</TH>
						  </TR>
						<s:iterator value="glassesFinishList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD>
			                 <input type="checkbox" id="chk" name="chk" value="${bgigoodsid}">
			              </TD>
                         <TD width="3%">
			                   <c:if test="${(permissionPo.keye==1)}">
			                  <c:if test="${bgiflag==1}">
			                    <img src="${ctx }/img/newbtn/enabled_0.png" title='销售停用' btn=btn onClick="javascript:disableGlassesFinish('${bgigoodsid}')">	
			                  </c:if>
			                  <c:if test="${bgiflag==0}">
			                  <img src="${ctx }/img/newbtn/unenabled_0.png" title='销售启用' btn=btn onClick="javascript:ableGlassesFinish('${bgigoodsid}')">	
			                  </c:if>
			                    </c:if>		                     
			                  </TD>
			             <TD width="3%">
		                  <c:if test="${(permissionPo.keyh==1) && systemParameterPo.fspwholesalepriceset == '0' }">
			                  <c:if test="${bgiwholegoodsisable==1}">
			                    <img src="${ctx }/img/newbtn/enabled_0.png" title='批发停用' btn=btn onClick="javascript:disableWhole('${bgigoodsid}')">	
			                  </c:if>
			                  <c:if test="${bgiwholegoodsisable==0}">
			                  <img src="${ctx }/img/newbtn/unenabled_0.png" title='批发启用' btn=btn onClick="javascript:ableWhole('${bgigoodsid}')">	
			                  </c:if>
		                  </c:if>		                     
		                  </TD>
			                   <TD width="3%">
		                   <c:if test="${(permissionPo.keyg==1)}">
		                     <img src="${ctx }/img/newbtn/search_0.png" title='详细' btn=btn onClick="javascript:details('${bgigoodsid}')">       
		                 </c:if>
		                  </TD>
			                  <TD width="3%">
			                   <c:if test="${(permissionPo.keyb==1)}">
			                     <img src="${ctx }/img/newbtn/edit_0.png" title='修改' btn=btn onClick="javascript:update('${bgigoodsid}')">
						                 
			                 </c:if>
			                  </TD>
			                  <TD width="3%">
			                  <c:if test="${(permissionPo.keyc==1)}">
			                      <img src="${ctx }/img/newbtn/delete_0.png" title='删除' btn=btn onClick="javascript:del('${bgigoodsid}')">	
				               	
			                  </c:if>
			               </TD>
                          <TD height="26">${bgigoodsid}</TD>
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgibrandname}</TD>
                          <TD>${bgiunitname}</TD>
                          <TD>${bgiretailprice}</TD>
                          <c:if test="${(permissionPo.keyf==1)}">
                          <TD>${bgicostprice}</TD>
                          </c:if>
                           <TD>
                          <c:if test="${bgiflag==1}">
                           	启用
                           </c:if>
                           <c:if test="${bgiflag==0}">
                           	停用
                           </c:if>
                           </TD>
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