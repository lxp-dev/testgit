<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
	function search(){
	$("img").removeAttr("onclick");
		goodsForm.action = "selGoodsModifyPrice.action";
		goodsForm.submit();
		showLoadingBar();
	}
	function clean(){
		 clean1();
	    <c:if test="${empty(supplierID_open) }">
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    </c:if>
	    <c:if test="${empty(categoryID_open) }">
	    document.all.goodscategoryID.value="";
	    </c:if>
	    category1();
	   
	  
	}	
	function cleanSB(){
		document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    document.all.brandID.value="";
	    document.all.brandName.value="";
	}
	function clean1(){
       $('input[clean=clean]').each(function(){
           $(this).val('');
       });
       $('select[clean=clean]').each(function(){
           $(this).val('');
       });		
	}
	
	function permissionMessage(){
       alert('您无此操作权限');
	}
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var goodscategoryID= document.all.goodscategoryID.value;
	    var supplierID=document.getElementById('supplierID').value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
			
		document.getElementById('popupTitle').innerHTML="【品种查询】";
		
		//showPopWin("","selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
	/**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext="";
        $("input[id=chk]",window.parent.document).each(function(){
			chktext=chktext+","+$(this).val();
		});

          $("input[id=chk]").each(function(){
         	if(chktext.indexOf($(this).attr("goodsid"))>=0){
              $(this).attr("checked","checked");
           }
		});
    }
	/**
	 *  调用单个页面赋值添加
	 */
    function setSingleValue(obj){
        var objValue="["+obj.value+"]";
        if(obj.checked==true){
           window.parent.openGoodSingleValues(objValue);
        }else if(obj.checked==false){
           window.parent.openGoodSingleDeleteValues(objValue);
        }

    }
	/**
	 *  调用页面赋值删除
	 */
	function setDelValue(){ 	         

        var objValue="";
        var count=0;

        $("input[id=chk]").each(function(){
         	if($(this).attr("checked")==false){
           	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;  
	         }  
		});
        
         if(count==0){
          alert('请选择商品!');
          return false;
        }
        objValue="["+objValue+"]";
        window.parent.openGoodSingleDeleteValues(objValue);
        
	}		
	/**
	 *  调用页面赋值
	 */
	function setValue(){ 	         

        var objValue="";
        var count=0;
        $("input[id=chk]").each(function(){
         	if($(this).attr("checked")==true){
           	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;    
		     }
		});
         if(count==0){
          alert('请选择商品!');
          return false;
        }
        objValue="["+objValue+"]";
        window.parent.openGoodSingleValues(objValue);
	}
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chks=document.all.chks;

        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
        if(chks.checked){
          setValue();
        }else{
          setDelValue();
        }
        
    }
	function selectContact(obj){
		var act = document.activeElement.id;
		
		if(act == "pageNos"&&event.keyCode==13){
			document.getElementById(act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
	}
	$(document).ready(function (){
		setCheckValue();
		var category = '${categoryID_open}';
		if(category=="")
		{
			var category = document.getElementById('categoryID').value;
		}
		if(category == ''){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").hide();
		}
		
		if(category == '1' ){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '2' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").show();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '3' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").show();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '4' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").show();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '5' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").show();
		}
		if(category == '6' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").show();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '7' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '8' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").show();
			$("tr[id=yxhly]").hide();
		}
		if(category == '9' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
	});
	
	function category1()
	{
		var category = document.getElementById('goodscategoryID').value;
		if(category == ''){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").hide();
		}
		
		if(category == '1' ){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '2' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").show();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '3' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").show();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '4' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").show();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '5' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").show();
		}
		if(category == '6' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").show();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '7' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
		if(category == '8' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").show();
			$("tr[id=yxhly]").hide();
		}
		if(category == '9' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
		}
	}

	function category()
	{
		clean1();
		var category = document.getElementById('goodscategoryID').value;
		if(category == ''){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").hide();
		}
		
		if(category == '1' ){
			$("tr[id=jj]").show();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").show();
		}
		if(category == '2' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").show();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").hide();
		}
		if(category == '3' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").show();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").hide();
		}
		if(category == '4' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").show();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").hide();
		}
		if(category == '5' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").show();
			$("tr[id=xh]").hide();
		}
		if(category == '6' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").show();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").show();
		}
		if(category == '7' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").hide();
		}
		if(category == '8' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").show();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").show();
		}
		if(category == '9' ){
			$("tr[id=jj]").hide();
			$("tr[id=jp]").hide();
			$("tr[id=pj]").hide();
			$("tr[id=yx]").hide();
			$("tr[id=tyj]").hide();
			$("tr[id=lhj]").hide();
			$("tr[id=yxhly]").hide();
			$("tr[id=xh]").hide();
		}
	}

	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id='categoryID_open' name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" id='categoryID' name="categoryID" value="${goodscategoryID}" />
<input type="hidden" id='supplierID_open' name="supplierID_open" value="${supplierID_open }" />

<input type="hidden" id="isrefresh" value="1" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	<br/></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
		  </TD>
		</TR>
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
						   <TD width="60" height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input class="text_input160" clean=clean type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}" onkeyup="selectContact(this)">
			               </TD>
			               <TD width="60" height="26"  class="table_body">商品条码</TD>
			               <TD class="table_none">
                            <input class="text_input160" clean=clean type="text"  id="goodscode" name="goodscode" value="${requestScope.goodscode}" onkeyup="selectContact(this)">
			               </TD>
                           <TD width="60" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input160" clean=clean type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}" onkeyup="selectContact(this)">
			               </TD>
                        </TR>
                        <TR>
                         <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } readonly="readonly"/>
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						   				<c:if test="${empty(supplierID_open)}">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();" ></li>
						   				</c:if>
						   	</TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text" clean=clean id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" clean=clean name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
			              </TD>
                        </TR>
                        <tr>
                        <TD width="60" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" colspan="5">
			               
                            <select id="goodscategoryID" name="goodscategoryID" onchange="category();cleanSB();" ${not empty(categoryID_open) ? 'disabled="disabled"' : '' }>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" <c:if test="${not empty goodscategoryID}"> ${goodscategoryID == bgcid ? 'selected="selected"' : '' }</c:if><c:if test="${empty goodscategoryID}">${categoryID_open == bgcid ? 'selected="selected"' : '' }</c:if>>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                    </select>
      	                   
			               </TD>
                        </tr>
                          <tr id="jj">
						   <TD width="9%" height="26" class="table_body" >厂家色号</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" clean=clean type="text"  id="bgisuppliercolorjj" name="bgisuppliercolorjj" value="${requestScope.bgisuppliercolorjj}">
			               </TD>
			               <TD height="26" class="table_body">镜架尺寸</TD>
			               <TD class="table_none">
                            <input class="text_input160" clean=clean type="text"  id="bgiframesizejj" name="bgiframesizejj" value="${requestScope.bgiframesizejj}">
			               </TD>
			                <TD width="60" height="26" class="table_body">镜架材质</TD>
			               <TD class="table_none" >
                            <select id="bgiframematerialtypejj" clean=clean name="bgiframematerialtypejj" >
      		                 <option value="">----请选择----</option>
				                <s:iterator value="frameMateriallist">
				               <option value="${bfmid}" ${bgiframematerialtypejj != bfmid ? '' : 'selected="selected"' }>${bfmname}</option>
	     	                 </s:iterator>
      	                    </select>
			               </TD>
                        </tr>
                          <TR id="jj">	
			               <TD width="60" height="26"  class="table_body">工艺类型</TD>
			               <TD class="table_none" colspan="5">
                            <select id="technologyTypeIDjj" clean=clean name="technologyTypeIDjj">
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="technologyType">
				               <option value="${fttid}" ${requestScope.technologyTypeIDjj == fttid ? 'selected="selected"' : '' }>${fttname}</option>
	     	                 </s:iterator>
      	                    </select>
			               </TD>
			             </tr>
			             <TR id="pj">	
			               <TD width="60" height="26" class="table_body">配件型 </TD>
			               <TD class="table_none" colspan="5">
                            <select id="bgiaccessoriestypepj" clean=clean name="bgiaccessoriestypepj">
      		                 <option value="">----请选择----</option>
      		                 <option value="1" ${requestScope.bgiaccessoriestypepj == '1' ? 'selected="selected"' : '' }>框镜</option>
				             <option value="2" ${requestScope.bgiaccessoriestypepj == '2' ? 'selected="selected"' : '' }>隐形</option>
      	                    </select>
			               </TD>
			              </tr>
			               <tr id="jp">
			              
                        	<TD height="26" class="table_body">球镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" clean=clean maxlength="10"  type="text"  id="minSphjp" name="minSphjp" value="${requestScope.minSphjp}">
                            	至
                            <input class="text_input80" clean=clean maxlength="10" type="text"  id="maxSphjp" name="maxSphjp" value="${requestScope.maxSphjp}">
			               </TD>
						   <TD height="26" class="table_body" >柱镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  clean=clean maxlength="10" id="minCyljp" name="minCyljp" value="${requestScope.minCyljp}">
                            	至
                            <input class="text_input80" type="text"  clean=clean maxlength="10" id="maxCyljp" name="maxCyljp" value="${requestScope.maxCyljp}">
			               </TD>
			              <TD width="8%" height="26" class="table_body">镜片型</TD>
			               <TD class="table_none">
			                <SELECT id="iscustomizekj" name="iscustomizekj" clean=clean>
                           	<option value="0" ${iscustomizekj=='0'?'selected="selected"':''}>成品片</option>
                           	<option value="D" ${iscustomizekj=='D'?'selected="selected"':''}>订做片</option>
                           </SELECT>
			               </TD>  
                        </tr>
			               <tr id="jp">
			                <TD height="26" class="table_body" >下加光</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text"  clean=clean maxlength="10" id="minbgibelowplusluminosityjp" name="minbgibelowplusluminosityjp" value="${requestScope.minbgibelowplusluminosityjp}">
                            	至
                            <input class="text_input80" type="text"  clean=clean maxlength="10" id="maxbgibelowplusluminosityjp" name="maxbgibelowplusluminosityjp" value="${requestScope.maxbgibelowplusluminosityjp}">
			               </TD>
                        	<TD height="26" class="table_body">材料分类</TD>
			                <TD class="table_none">
                            	<select id="bgieyeglassmaterialtypejp" clean=clean name="bgieyeglassmaterialtypejp"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${requestScope.bgieyeglassmaterialtypejp == '1' ? 'selected="selected"' : '' }>树脂</option>
				               		<option value="2" ${requestScope.bgieyeglassmaterialtypejp == '2' ? 'selected="selected"' : '' }>玻璃</option>
				               		<option value="3" ${requestScope.bgieyeglassmaterialtypejp == '3' ? 'selected="selected"' : '' }>PC</option>
      	                   		</select>
			                </TD>
						    <TD height="26" class="table_body">折射率</TD>
			                <TD class="table_none">
                            	<select id="bgirefractivejp" clean=clean name="bgirefractivejp">
      		                 	<option value="">----请选择----</option>
			               		 <s:iterator value="refractiveSetPos">
				                   <option value="${brfname}" ${requestScope.bgirefractivejp == brfname ? 'selected="selected"' : '' }>${brfname}</option>
		     	                 </s:iterator>
      	                   		</select>
			                </TD>
			              
                        </tr>
			               <tr id="jp">
			                 <TD height="26" class="table_body">光度分类</TD>
			                <TD class="table_none">
                            	<select id="bgiismutiluminosityjp" clean=clean name="bgiismutiluminosityjp"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="0" ${requestScope.bgiismutiluminosityjp == '0' ? 'selected="selected"' : '' }>单光片</option>
				               		<option value="M" ${requestScope.bgiismutiluminosityjp == 'M' ? 'selected="selected"' : '' }>多光片</option>
				               		<option value="J" ${requestScope.bgiismutiluminosityjp == 'J' ? 'selected="selected"' : '' }>渐进片</option>
				               		<option value="K" ${requestScope.bgiismutiluminosityjp == 'K' ? 'selected="selected"' : '' }>抗疲劳</option>
				               		<option value="Q" ${requestScope.bgiismutiluminosityjp == 'Q' ? 'selected="selected"' : '' }>其他</option>
      	                   		</select>
			               </TD>
                        	<TD height="26" class="table_body">镜片功能</TD>
			                <TD class="table_none">
                            	<select id="bgifunctionclassjp" clean=clean name="bgifunctionclassjp"}>
      		                 		<option value="">----请选择----</option>
				               		<option value="1" ${requestScope.bgifunctionclassjp == '1' ? 'selected="selected"' : '' }>白色片</option>
		                            <option value="2" ${requestScope.bgifunctionclassjp == '2' ? 'selected="selected"' : '' }>变色片</option>
		                            <option value="3" ${requestScope.bgifunctionclassjp == '3' ? 'selected="selected"' : '' }>偏光片</option>
		                            <option value="4" ${requestScope.bgifunctionclassjp == '4' ? 'selected="selected"' : '' }>变色偏光片</option>
		                            <option value="5" ${requestScope.bgifunctionclassjp == '5' ? 'selected="selected"' : '' }>染色片</option>
		                            <option value="6" ${requestScope.bgifunctionclassjp == '6' ? 'selected="selected"' : '' }>抗疲劳片</option>
		                            <option value="7" ${requestScope.bgifunctionclassjp == '7' ? 'selected="selected"' : '' }>抗疲劳变色片</option>
				               		<option value="8" ${requestScope.bgifunctionclassjp == '8' ? 'selected="selected"' : '' }>偏光抗疲劳片</option>
      	                   		</select>
			                </TD>
						    <TD height="26" class="table_body">渐进片分类</TD>
			                <TD class="table_none" >
                            	<select id="bgigradualclassjp" clean=clean name="bgigradualclassjp"}>
      		                 	<option value="">----请选择----</option>
			               		<option value="1" ${requestScope.bgigradualclassjp == '1' ? 'selected="selected"' : '' }>青少年渐进</option>
				                <option value="2" ${requestScope.bgigradualclassjp == '2' ? 'selected="selected"' : '' }>成人渐进</option>
				               		
      	                   		</select>
			                </TD>
                        </tr>
                        <tr id="yx">
                        	<TD height="26" class="table_body">球镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" clean=clean maxlength="10" id="minSphyx" name="minSphyx" value="${requestScope.minSphyx}">
                            	至
                            <input class="text_input80" type="text" clean=clean maxlength="10" id="maxSphyx" name="maxSphyx" value="${requestScope.maxSphyx}">
			               </TD>
						   <TD height="26" class="table_body" >柱镜范围</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" clean=clean id="minCylyx" maxlength="10" name="minCylyx" value="${requestScope.minCylyx}">
                            	至
                            <input class="text_input80" type="text" clean=clean id="maxCylyx" maxlength="10" name="maxCylyx" value="${requestScope.maxCylyx}">
			               </TD>
			               <TD height="26" class="table_body">曲率</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" clean=clean id="bgicurvature1yx" maxlength="10" name="bgicurvature1yx" value="${requestScope.bgicurvature1yx}">
			               </TD>
                        </tr>
                         <tr id="yx">
                        	<TD height="26" class="table_body">直径</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" clean=clean id="bgidiayx" maxlength="10" name="bgidiayx" value="${requestScope.bgidiayx}">
			               </TD>
						   <TD height="26" class="table_body">使用类型</TD>
			               <TD class="table_none">
                            <select id="bgiusetypeyx" clean=clean name="bgiusetypeyx" >
      		                 <option value="">----请选择----</option>
      		                 <option value="1" ${requestScope.bgiusetypeyx == '1' ? 'selected="selected"' : '' }>常戴型</option>
      		                 <option value="2" ${requestScope.bgiusetypeyx == '2' ? 'selected="selected"' : '' }>抛弃型</option>
      		                 <option value="3" ${requestScope.bgiusetypeyx == '3' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   </select>
			               </TD>
			               <TD height="26" class="table_body">抛弃型分类</TD>
							<td class="table_none">
							<select id="bgistealthclassyx" clean=clean name="bgistealthclassyx" >
      		                 <option value="">----请选择----</option>
                             <option value="1" ${requestScope.bgistealthclassyx == '1' ? 'selected="selected"' : '' }>日抛</option>
                             <option value="2" ${requestScope.bgistealthclassyx == '2' ? 'selected="selected"' : '' }>周抛</option>
                             <option value="9" ${requestScope.bgistealthclassyx == '9' ? 'selected="selected"' : '' }>双周抛</option>
                             <option value="3" ${requestScope.bgistealthclassyx == '3' ? 'selected="selected"' : '' }>月抛</option>
                             <option value="4" ${requestScope.bgistealthclassyx == '4' ? 'selected="selected"' : '' }>季抛</option>
                             <option value="5" ${requestScope.bgistealthclassyx == '5' ? 'selected="selected"' : '' }>半年抛</option>
                             <option value="6" ${requestScope.bgistealthclassyx == '6' ? 'selected="selected"' : '' }>年抛</option>
                             <option value="7" ${requestScope.bgistealthclassyx == '7' ? 'selected="selected"' : '' }>RGP</option>
      	                   </select>
                           </TD>
                        </tr>
                        <tr id="yx">
                        	<TD width="8%" height="26" class="table_body">镜片型</TD>
			               <TD class="table_none" colspan="5">
			                <SELECT id="iscustomizeyx" name="iscustomizeyx" clean=clean>
                           	<option value="0" ${iscustomizeyx=='0'?'selected="selected"':''}>成品片</option>
                           	<option value="D" ${iscustomizeyx=='D'?'selected="selected"':''}>订做片</option>
                           </SELECT>
			               </TD>
			            </tr> 
                         <tr id="yxhly">
                        	<TD height="26" class="table_body">主容量</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" clean=clean id="bgicapacityyxhly" name="bgicapacityyxhly" value="${requestScope.bgicapacityyxhly}">
			               </TD>
						   <TD height="26" class="table_body">次容量</TD>
			               <TD class="table_none" colspan="3">
                             <input class="text_input80" type="text" clean=clean id="bgicapacityentryyxhly" name="bgicapacityentryyxhly" value="${requestScope.bgicapacityentryyxhly}">
			               </TD>
                        </tr>
                        
                         <tr id="tyj">
                        	<TD height="26" class="table_body">厂家色号</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" clean=clean id="bgisuppliercolortyj" name="bgisuppliercolortyj" value="${requestScope.bgisuppliercolortyj}">
			               </TD>
						   <TD height="26" class="table_body">镜架尺寸</TD>
			               <TD class="table_none" colspan="3">
                             <input class="text_input80" type="text" clean=clean id="bgiframesizetyj" name="bgiframesizetyj" value="${requestScope.bgiframesizetyj}">
			               </TD>
                        </tr>
                        <tr id="lhj">
                       	  <TD height="26" class="table_body">老花镜度数</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" clean=clean id="minSphlhj" name="minSphlhj" value="${requestScope.minSphlhj}">
                            	至
                            <input class="text_input80" type="text" clean=clean id="maxSphlhj" name="maxSphlhj" value="${requestScope.maxSphlhj}">
			               </TD>
                        	<TD height="26" class="table_body">厂家色号</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" clean=clean id="bgisuppliercolorlhj" name="bgisuppliercolorlhj" value="${requestScope.bgisuppliercolorlhj}">
			               </TD>
						   <TD height="26" class="table_body">镜架尺寸</TD>
			               <TD class="table_none" colspan="3">
                             <input class="text_input80" type="text" clean=clean id="bgiframesizelhj" name="bgiframesizelhj" value="${requestScope.bgiframesizelhj}">
			               </TD>
                        </tr>
                        <tr id="xh">
                        	 <TD  height="26" class="table_body">型号</TD>
			               <TD class="table_none"  colspan="5">
                            <input class="text_input160" clean=clean type="text" id="bgispecs" name="bgispecs" value="${requestScope.bgispecs}">
			               </TD>
                        </tr>
		               <tr>		               
						   <TD height="26" class="table_body">含税单价价格</TD>
			               <TD class="table_none" colspan="5">
			               <input class="text_input100" type="text" clean=clean id="bgicostbeginprice" name="bgicostbeginprice" value="${requestScope.bgicostbeginprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"> ~ 
			               <input class="text_input100" type="text" clean=clean id="bgicostendprice" name="bgicostendprice" value="${requestScope.bgicostendprice}" onKeyUp="value=value.replace(/[^\d\.]/g,'')"></TD>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
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
					<c:if test="${not empty(goodsList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
					<!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <c:choose>
                          	<c:when test="${goodscategoryID == '1' }">
                          	<TH scope=col width="15%">商品代码</TH>
	                          <TH scope=col width="20%">商品名称</TH>
	                          <TH scope=col width="10%">型号</TH>
	                          <TH scope=col width="6%">单位</TH>
	                          <TH scope=col width="8%">含税单价价格</TH>
	                           <TH scope=col width="10%">厂家色号 </TH>
	                           <TH scope=col width="10%">镜架材质 </TH>
	                           <TH scope=col width="10%">镜架尺寸</TH> 
                          	</c:when>
                          	<c:when test="${goodscategoryID == '2' }">
                          		<TH scope=col width="15%">商品代码</TH>
	                         	<TH scope=col width="18%">商品名称</TH>
	                         	<TH scope=col width="10%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="8%">含税单价价格</TH>
	                          
                          		
	                           	<TH scope=col width="15%">配件型 </TH>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '3'}">
                          		<TH scope=col width="15%">商品代码</TH>
	                          	<TH scope=col width="18%">商品名称</TH>
	                          	<TH scope=col width="3%">单位</TH>
	                          	<TH scope=col width="8%">含税单价价格</TH>
	                          	<TH scope=col width="6%">球镜</TH>
	                           	<TH scope=col width="6%">柱镜 </TH>
	                           	<TH scope=col width="6%">下加光 </TH>
	                           	<TH scope=col width="6%">折射率</TH> 
	                           	<TH scope=col width="6%">光度分类 </TH>
	                           	<TH scope=col width="6%">材料分类</TH> 
	                           	<TH scope=col width="5%">渐进片分类</TH> 
                          		<TH scope=col width="5%">镜片功能</TH> 
                          	</c:when>
                          	<c:when test="${goodscategoryID == '4'}">
                          		<TH scope=col width="15%">商品代码</TH>
	                          	<TH scope=col width="18%">商品名称</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="8%">含税单价价格</TH>
	                          	
	                          	<TH scope=col width="6%">球镜</TH>
	                           	<TH scope=col width="6%">柱镜 </TH>
	                           	<TH scope=col width="6%">曲率 </TH>
	                           	<TH scope=col width="6%">直径</TH> 
	                           	<TH scope=col width="6%">使用类型 </TH>
	                           	<TH scope=col width="6%">抛弃型分类</TH>                          	
                          	</c:when>
                          	<c:when test="${goodscategoryID == '5' }">
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="10%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="8%">含税单价价格</TH>
	                           	<TH scope=col width="15%">主容量 </TH>
	                           	<TH scope=col width="15%">次容量 </TH>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '6' }">
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="10%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="8%">含税单价价格</TH>
                          		
	                           	<TH scope=col width="15%">厂家色号 </TH>
	                           	<TH scope=col width="15%">镜架尺寸 </TH>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '8' }">
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="15%">型号 </TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="8%">含税单价价格</TH>
	                          
                          		<TH scope=col width="10%">老花镜度数</TH>
	                           	
	                           	<TH scope=col width="10%">镜架尺寸 </TH>  
	                           	<TH scope=col width="10%">厂家色号 </TH>                        		
                          	</c:when>
                          	<c:when test="${goodscategoryID == '9' }">
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="20%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="8%">含税单价价格</TH>
	                          
                          		
                          	</c:when>
                          	<c:otherwise>
                          		<TH scope=col width="18%">商品代码</TH>
	                         	<TH scope=col width="20%">商品名称</TH>
	                         	<TH scope=col width="10%">型号</TH>
	                          	<TH scope=col width="5%">单位</TH>
	                          	<TH scope=col width="8%">含税单价价格</TH>
                          	</c:otherwise>
						 </c:choose>                                                                                   
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                          <input type="checkbox" onClick="setSingleValue(this);" id="chk" goodsid="${bgigoodsid}"
                           value="{'bgigoodsid':'${bgigoodsid}','bgigoodsbarcode':'${bgigoodsbarcode}','bgigoodsname':'${bgigoodsname}','bgiunitname':'${bgiunitname}','bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}',
                           'bginottaxrate':'${bginottaxrate}','bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}','bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}','bgibrandname':'${bgibrandname}',
                           'bgipcbarcode':'${bgipcbarcode }','bgisuppliername':'${bgisuppliername }','bgisupplierid':'${bgisupplierid }',
                           'bgiframematerialtype':'${bgiframematerialtype }','bgiframesize':'${bgiframesize}','bgiaccessoriestype':'${bgiaccessoriestype}',
                           'bgibelowplusluminosity':'${bgibelowplusluminosity }','bgirefractive':'${bgirefractive}','bgiismutiluminosity':'${bgiismutiluminosity}',
                           'bgieyeglassmaterialtype':'${bgieyeglassmaterialtype }','bgiusetype':'${bgiusetype}','bgistealthclass':'${bgistealthclass}',
                           'bgicapacity':'${bgicapacity }','bgicapacityentry':'${bgicapacityentry}','bgisuppliercolor':'${bgisuppliercolor}','bgiframematerialtypename':'${bgiframematerialtypename}',bgiwholesaleprice:'${bgiwholesaleprice}',
                           'bgisource':'${bgisource }'}">
                          </TD>
                           <c:choose>
                          	<c:when test="${goodscategoryID == '1' }">
	                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD >${bgispec}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
	                           <TD scope=col >${bgisuppliercolor} </TD>
	                           <TD scope=col >${bgiframematerialtypename}</TD>
	                           <TD scope=col >${bgiframesize}</TD> 
                          	</c:when>
                          	<c:when test="${goodscategoryID == '2' }">
                          	 	<TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>                          		
	                        	<TD scope=col >
		                          	<c:if test="${bgiaccessoriestype=='1'}"> 框镜</c:if>
		                          	<c:if test="${bgiaccessoriestype=='2'}"> 隐形</c:if>
	                           </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '3'}">
                          		 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
                          		<TD scope=col >
                          		<c:choose>
                          			<c:when test="${not empty bgisph}">${bgisph}</c:when>
		                          	<c:otherwise>${bgisphul} <c:if test="${not empty bgisphul}">/</c:if>${bgisphup }</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicyl}">${bgicyl}</c:when>
		                          	<c:otherwise>${bgicylul} <c:if test="${not empty bgisphul}">/</c:if>${bgicylup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgibelowplusluminosity}">${bgibelowplusluminosity}</c:when>
		                          	<c:otherwise>${bgibelowplusluminosityul} <c:if test="${not empty bgibelowplusluminosityul}">/</c:if>${bgibelowplusluminosityup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >${bgirefractive} </TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiismutiluminosity=='M'}">  多光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='0'}"> 单光</c:if>
		                          	<c:if test="${bgiismutiluminosity=='Q'}"> 其它</c:if>
		                          	<c:if test="${bgiismutiluminosity=='K'}"> 抗疲劳</c:if>
		                          	<c:if test="${bgiismutiluminosity=='J'}"> 渐近</c:if>
	                           </TD>
	                           <TD scope=col>
		                          	<c:if test="${bgieyeglassmaterialtype=='1'}"> 树脂</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='2'}"> 玻璃</c:if>
		                          	<c:if test="${bgieyeglassmaterialtype=='3'}"> PC</c:if>		                          	
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgigradualclass=='1'}">青少年渐进</c:if>
		                          	<c:if test="${bgigradualclass=='2'}"> 成人渐进</c:if>	                          	
	                           </TD>
	                           
	                           <TD scope=col >
		                          	<c:if test="${bgifunctionclass=='1'}">白色片</c:if>
		                          	<c:if test="${bgifunctionclass=='2'}">变色片</c:if>	 
		                          	<c:if test="${bgifunctionclass=='3'}">偏光片</c:if>
		                          	<c:if test="${bgifunctionclass=='4'}"> 变色偏光片</c:if>	
		                          	<c:if test="${bgifunctionclass=='5'}">染色片</c:if>
		                          	<c:if test="${bgifunctionclass=='6'}"> 抗疲劳片</c:if>
		                          	<c:if test="${bgifunctionclass=='7'}"> 抗疲劳变色片</c:if>
		                          	<c:if test="${bgifunctionclass=='8'}"> 偏光抗疲劳片</c:if>	                         	
	                           </TD>
	                           
                          	</c:when>
                          	<c:when test="${goodscategoryID == '4'}">
                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
                          		<TD scope=col >
                          		<c:choose>
                          			<c:when test="${not empty bgisph}">${bgisph}</c:when>
		                          	<c:otherwise>${bgisphul} <c:if test="${not empty bgisphul}">/</c:if>${bgisphup}</c:otherwise>
	                          	</c:choose>
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicyl}">${bgicyl}</c:when>
		                          	<c:otherwise>${bgicylul} <c:if test="${not empty bgisphul}">/</c:if>${bgicylup}</c:otherwise>
	                          	</c:choose> 
	                          	</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgicurvature1}">${bgicurvature1}</c:when>
		                          	<c:otherwise>${bgicurvature1ul} <c:if test="${not empty bgicurvature1ul}">/</c:if>${bgicurvature1up}</c:otherwise>
	                          	</c:choose> 
                          		</TD>
                          		<TD scope=col >
                          		<c:choose>
		                          	<c:when test="${not empty bgidia}">${bgidia}</c:when>
		                          	<c:otherwise>${bgidiaul} <c:if test="${not empty bgidiaul}">/</c:if>${bgidiaup}</c:otherwise>
	                          	</c:choose> 
                          		</TD>
	                        	<TD scope=col >
		                          	<c:if test="${bgiusetype=='1'}"> 常带型</c:if>
		                          	<c:if test="${bgiusetype=='2'}">抛弃型</c:if>		                          	
	                           </TD>
	                           <TD scope=col >
		                          	<c:if test="${bgistealthclass=='1'}"> 日抛</c:if>
		                          	<c:if test="${bgistealthclass=='2'}"> 周抛</c:if>
		                          	<c:if test="${bgistealthclass=='9'}"> 双周抛</c:if>
		                          	<c:if test="${bgistealthclass=='3'}"> 月抛</c:if>		
		                          	<c:if test="${bgistealthclass=='4'}"> 季抛</c:if>
		                          	<c:if test="${bgistealthclass=='5'}"> 半年抛</c:if>
		                          	<c:if test="${bgistealthclass=='6'}"> 年抛</c:if>	  
		                          	<c:if test="${bgistealthclass=='7'}"> RGP</c:if>	                         	
	                           </TD>
                          		
                          		
                          	</c:when>
                          
                          	<c:when test="${goodscategoryID == '5' }">
                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
                          		<TD scope=col >${bgicapacity} </TD>
                          		<TD scope=col >${bgicapacityentry} </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '6' }">
                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
                          		<TD scope=col >${bgisuppliercolor} </TD>
                          		<TD scope=col >${bgiframesize} </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '8' }">
                          	 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
                          		<TD scope=col >${bgisph} </TD>
                          		<TD scope=col >${bgiframesize} </TD>
                          		<TD scope=col >${bgisuppliercolor} </TD>
                          	</c:when>
                          	<c:when test="${goodscategoryID == '9' }">
                          	 	<TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
                          		
                          	</c:when>
                          	<c:when test="${goodscategoryID == '7' }">
                          	 	<TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 	<TD scope=col >${bgispec} </TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
                          	
                          	</c:when>
                          	  <c:otherwise>
                         		 <TD>${bgigoodsid}</TD>
	                         	 <TD>${bgiviewgoodsname}</TD>
	                         	 <TD scope=col >${bgispec}</TD>
	                          	 <TD>${bgiunitname}</TD>
	                          	<TD>${bgicostprice}</TD>
                          </c:otherwise>
						 </c:choose>
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
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
