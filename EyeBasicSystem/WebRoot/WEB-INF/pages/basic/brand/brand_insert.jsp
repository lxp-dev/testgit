<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>品种维护</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
    	if('${person.syspsupplierid}' != ''){
    		createcategory('${person.syspsuppliercategoryid}');
    	}
	});

	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });		
	}
	
	function save(){
        if (($('#bbdgoodscategory').val() == '4' || $('#bbdgoodscategory').val() == '5') && ('${systemParameterPo.fspisregistrationnum}' == '1')){
        	if ($('#bbdgoodscategory').val() == '4'){
        		$('#bbdregistrationnum').removeAttr('noValidate');
            }else{
            	$('#bbdregistrationnum2').removeAttr('noValidate');
            }
        }else{
        	$('#bbdregistrationnum').attr('noValidate','noValidate');
        	$('#bbdregistrationnum2').attr('noValidate','noValidate');
        }
		
		if(checkForm(brandForm)){
			var bbdsettlementmonth = $("#bbdsettlementmonth").val();
			if($("#bbdsettlement").val() == '2') {
				if(bbdsettlementmonth != "" && isNaN(bbdsettlementmonth) || bbdsettlementmonth.indexOf("\.") >= 0 || bbdsettlementmonth<= 0) {
					alert("月数只能输入正整数!");
					$("#bbdsettlementmonth").select();
					return;
				}
			}
			
			$("img").removeAttr("onclick");
			brandForm.action = "insertBrand.action";
			brandForm.submit();
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
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bbdsupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
		document.getElementById('bspcategoryid').value = json.bspcategoryid;
		document.getElementById('bbdsettlement').value = json.bspsettlement;
		document.getElementById('bbdsettlementmonth').value = json.bspsettlementmonth;
		showMonth();
        createcategory(json.bspcategoryid);
	}
	
	function createcategory(value){
		var array = new Array();
		var bspcategoryids = value;
		array = bspcategoryids.split(',');
		brandForm.bbdgoodscategory.options.length = 0;
		brandForm.bbdgoodscategory.options.add(new Option("----请选择----",""));

		var categoryID = "${brandPo.bbdgoodscategory }";
		for (var i = 0; i < array.length; i++) {
			var obj;
			if (array[i] == '1') {
				obj = new Option("镜架",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			if (array[i] == '2') {
				obj = new Option("配件",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			if (array[i] == '3') {
				obj = new Option("镜片",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			if (array[i] == '4') {
				obj = new Option("隐形镜片",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			if (array[i] == '5') {
				obj = new Option("隐形护理液",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			if (array[i] == '6') {
				obj = new Option("太阳镜",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			if (array[i] == '8') {
				obj = new Option("老花镜",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			if (array[i] == '7') {
				obj = new Option("耗材",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			if (array[i] == '9') {
				obj = new Option("视光",array[i]);
				obj.setAttribute("selected", (array[i] == categoryID))
				brandForm.bbdgoodscategory.options.add(obj); 
			}
			
			$("#bbdgoodscategory").val("");
		}
	}
	
	function clicks(){
		var goodsType = document.getElementById("bbdgoodscategory").value;
		if(goodsType=='1'){
			//显示下拉菜单
	    	$('#goodscatory1').show();
	    	
	    	$('#bbdmaterialclass').removeAttr('validate').val('');
	    	$('#bbdluminosityclass').removeAttr('validate').val('');
	    	$('#bbdgradualclass').removeAttr('validate').val('');
	    	$('#bbdfunctionclass').removeAttr('validate').val('');
	    	$('#bbdrefractive').removeAttr('validate').val('');
	    	$('#bbdusetype').removeAttr('validate').val('');
	    	$('#bbdstealthclass').removeAttr('validate').val('');    		
	    		    	
	    	//隐藏下拉菜单
	    	$('#goodscatory4').hide();
	    	$('#goodscatory5').hide();
	    	$('#goodscatory301').hide();
	    	$('#goodscatory302').hide();
	    	
		}else if(goodsType=='3'){
			//显示下拉菜单
	    	$('#goodscatory301').show();
	    	$('#goodscatory302').show();
	    	
	    	$('#bbdframematerialtype').removeAttr('validate').val('');  
	    	$('#bbdusetype').removeAttr('validate').val('');
	    	$('#bbdstealthclass').removeAttr('validate').val(''); 	    	
	    	//隐藏下拉菜单
	    	$('#goodscatory4').hide();
	    	$('#goodscatory5').hide();
	    	$('#goodscatory1').hide();
		}else if(goodsType=='4'){
			//显示下拉菜单
	    	$('#goodscatory4').show();
	    	
	    	$('#bbdmaterialclass').removeAttr('validate').val('');
	    	$('#bbdluminosityclass').removeAttr('validate').val('');
	    	$('#bbdgradualclass').removeAttr('validate').val('');
	    	$('#bbdfunctionclass').removeAttr('validate').val('');
	    	$('#bbdrefractive').removeAttr('validate').val('');
            $('#bbdframematerialtype').removeAttr('validate').val('');            
	    	//隐藏下拉菜单
	    	$('#goodscatory1').hide();
	    	$('#goodscatory5').hide();
	    	$('#goodscatory301').hide();
	    	$('#goodscatory302').hide();
		}else if(goodsType=='5'){
			//显示下拉菜单
	    	$('#goodscatory5').show();
	    	
	    	$('#bbdmaterialclass').removeAttr('validate').val('');
	    	$('#bbdluminosityclass').removeAttr('validate').val('');
	    	$('#bbdgradualclass').removeAttr('validate').val('');
	    	$('#bbdfunctionclass').removeAttr('validate').val('');
	    	$('#bbdrefractive').removeAttr('validate').val('');
            $('#bbdframematerialtype').removeAttr('validate').val('');            
	    	//隐藏下拉菜单
	    	$('#goodscatory1').hide();
	    	$('#goodscatory4').hide();
	    	$('#goodscatory301').hide();
	    	$('#goodscatory302').hide();
		}else{
	    	//隐藏下拉菜单
	    	$('#bbdmaterialclass').removeAttr('validate').val('');
	    	$('#bbdluminosityclass').removeAttr('validate').val('');
	    	$('#bbdgradualclass').removeAttr('validate').val('');
	    	$('#bbdfunctionclass').removeAttr('validate').val('');
	    	$('#bbdrefractive').removeAttr('validate').val('');
	    	$('#bbdusetype').removeAttr('validate').val('');
	    	$('#bbdstealthclass').removeAttr('validate').val(''); 
            $('#bbdframematerialtype').removeAttr('validate').val('');   
                
	    	$('#goodscatory1').hide();
	    	$('#goodscatory4').hide();
	    	$('#goodscatory5').hide();
	    	$('#goodscatory301').hide();
	    	$('#goodscatory302').hide();
		}
	}

	function clicks2(obj){
		if(obj.value=='J'){
	    	$('#goodscatory303').show();
	    	$('#bbdgradualclass').show();
		}else{
		    $('#bbdgradualclass').removeAttr('validate');  
			$('#goodscatory303').hide();
			$('#bbdgradualclass').val('');
	    	$('#bbdgradualclass').hide();
		}
	}

	function showMonth() {
		if($("select[id=bbdsettlement]").val() == "jxfs2") {
			$("span[month=month]").show();
			$("input[month=month]").show();
		} else {
			$("span[month=month]").hide();
			$("input[month=month]").hide();
			$("input[month=month]").val("");
		}
	}
	function checkBrandId(thiz){
		$(thiz).val($(thiz).val().toUpperCase());
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="brandForm" method="post" action="">
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" /> 
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="bspcategoryid" name="bspcategoryid" value="${bspcategoryid}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                        <TBODY>
                          <TR>
                            <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                            <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                          </TR>
                        </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">品种代码</TD>
			               <TD width="19%" class="table_none">
			               	<input clean=clean class="text_input100" id="bbdid" name="brandPo.bbdid" onkeyup="checkBrandId(this);" maxlength="2"  value="${brandPo.bbdid }"
			               	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '品种代码不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '品种代码只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.EQLength, Params : [2]}, 'Message' : '品种代码应为2位字符'}]"><label style="color:red;">&nbsp;*&nbsp;品种代码必须为两位数</label>
			               </TD>
					   
						   <TD width="9%" height="26" class="table_body">品种名称</TD>
			               <TD width="25%" class="table_none">
			               	<input clean=clean class="text_input160" id="bbdbrandname" name="brandPo.bbdbrandname" maxlength="50" value="${brandPo.bbdbrandname }"
			               	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '品种名称不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD width="9%" class="table_body">制造商</TD>
						   <TD width="19%" height="26" align="left" class="table_none">
						    <c:if test="${person.syspsupplierid ne ''}">
						   		<li class="horizontal_onlyRight">
						   		${person.syspsuppliername }
						   		<input type="hidden" name="brandPo.bbdsupplierid" value="${person.syspsupplierid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
							   	</li>
						   	</c:if>
						   	<c:if test="${person.syspsupplierid eq ''}">
						   		<li class="horizontal_onlyRight">
						   		<input clean=clean id="bspsuppliername" class="text_input160" name="brandPo.bspsuppliername" value="${brandPo.bspsuppliername }" readonly="readonly" />
						   		<input clean=clean type="hidden" id="bbdsupplierid" name="brandPo.bbdsupplierid" value="${brandPo.bbdsupplierid }"
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
							    </li>
							    <li class="horizontal_onlyRight">
							  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn id=ctl00_PageBody_Button1 title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();">
							    </li>
							    <label style="color:red;">&nbsp;*</label>
						   	</c:if>
						   </TD>
						</TR>	
                        <TR>
                        <TD height="26" class="table_body">商品类别</TD>
                        <TD class="table_none" ><select clean=clean id="bbdgoodscategory" name="brandPo.bbdgoodscategory" onchange="clicks()" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择商品类别！'}]">
                            <option value="">----请选择----</option>
                          </select><label style="color:red;">&nbsp;*</label></TD>
                       <TD height="26" class="table_body">产地</TD>
			           <TD class="table_none">
			               	<input clean=clean class="text_input160" id="bbdplace" name="brandPo.bbdplace" maxlength="50" value="${brandPo.bbdplace }"/></TD>   
                       <TD height="26" class="table_body">计量单位</TD>
			               <TD class="table_none">
                            <select clean=clean id="bbdunit" name="brandPo.bbdunit" >
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}"  ${brandPo.bbdunit eq butid ? 'selected="selected"' : '' } >${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                </TD>                    
                      </TR>
                      <TR id="goodscatory1"> 
                       <TD height="26" class="table_body">镜架材质</TD>
			               <TD class="table_none" colspan="5">
                            <select clean=clean id="bbdframematerialtype" name="brandPo.bbdframematerialtype" >
      		                 <option value="">----请选择----</option>
								<s:iterator value="frameMateriallist"> 
								<option value="${bfmid}" ${brandPo.bbdframematerialtype eq bfmid ? 'selected="selected"' : ''}>${bfmname}</option> 
								</s:iterator>
      	                   </select>
      	                </TD>                    
                      </TR>
                     <TR id="goodscatory4"> 
                       <TD height="26" class="table_body">使用类型</TD>
			               <TD class="table_none">
                            <select clean=clean id="bbdusetype" name="brandPo.bbdusetype" >
                              <option value="" ${brandPo.bbdusetype eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                             <option value="1" ${brandPo.bbdusetype eq '1' ? 'selected="selected"' : '' }>常带型</option>
                             <option value="2" ${brandPo.bbdusetype eq '2' ? 'selected="selected"' : '' }>抛弃型</option>
                             <option value="3" ${brandPo.bbdusetype eq '3' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   </select>
      	                </TD> 
      	                <TD height="26" class="table_body">抛弃型分类</TD>
			               <TD class="table_none">
                            <select clean=clean id="bbdstealthclass" name="brandPo.bbdstealthclass" >
      		                 <option value="">----请选择----</option>
                             <option value="1" {brandPo.bbdstealthclass=='1'?'selected="selected"' : ''}>日抛</option>
                             <option value="2" {brandPo.bbdstealthclass=='2'?'selected="selected"' : ''}>周抛</option>
                             <option value="9" {brandPo.bbdstealthclass=='9'?'selected="selected"' : ''}>双周抛</option>
                             <option value="3" {brandPo.bbdstealthclass=='3'?'selected="selected"' : ''}>月抛</option>
                             <option value="4" {brandPo.bbdstealthclass=='4'?'selected="selected"' : ''}>季抛</option>
                             <option value="5" {brandPo.bbdstealthclass=='5'?'selected="selected"' : ''}>半年抛</option>
                             <option value="6" {brandPo.bbdstealthclass=='6'?'selected="selected"' : ''}>年抛</option>
                             <option value="7" {brandPo.bbdstealthclass=='7'?'selected="selected"' : ''}>RGP</option>
                             <option value="8" {brandPo.bbdstealthclass=='8'?'selected="selected"' : ''}>塑形镜</option>
      	                   </select>
      	                </TD>
      	                <TD height="26" class="table_body">注册证号</TD>
			            <TD class="table_none">
                            <input clean=clean class="text_input160" id="bbdregistrationnum" name="registrationnum" maxlength="50" value="${brandPo.bbdregistrationnum}" noValidate = "noValidate" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '注册证号不能为空！'}]"/>
      	                </TD>                      
                      </TR>
                      <TR id="goodscatory5"> 
      	                <TD height="26" class="table_body">注册证号</TD>
			            <TD class="table_none" colspan="5">
                            <input clean=clean class="text_input160" id="bbdregistrationnum2" name="registrationnum2" maxlength="50" value="${brandPo.bbdregistrationnum}" noValidate = "noValidate" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '注册证号不能为空！'}]"/>
      	                </TD>                      
                      </TR>
                      <TR id="goodscatory301"> 
                       <TD height="26" class="table_body">材料分类</TD>
			               <TD class="table_none">
                            <select clean=clean id="bbdmaterialclass" name="brandPo.bbdmaterialclass" >
      		                 <option value="" ${brandPo.bbdmaterialclass eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                             <option value="1" ${brandPo.bbdmaterialclass eq '1' ? 'selected="selected"' : '' }>树脂</option>
                             <option value="2" ${brandPo.bbdmaterialclass eq '2' ? 'selected="selected"' : '' }>玻璃</option>
                             <option value="3" ${brandPo.bbdmaterialclass eq '3' ? 'selected="selected"' : '' }>PC</option>
      	                   </select>
      	                </TD> 
      	                <TD height="26" class="table_body">折射率</TD>
			               <TD class="table_none">
                            <select clean=clean id="bbdrefractive" name="brandPo.bbdrefractive" >
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="refractiveSetList">
				               <option value="${brfname}"  ${brandPo.bbdrefractive eq brfname ? 'selected="selected"' : '' }>${brfname}</option>
	     	               </s:iterator>
      	                   </select>
      	                </TD>
                        <TD height="26" class="table_body">镜片功能</TD>
			               <TD class="table_none">
                            <select clean=clean id="bbdfunctionclass" name="brandPo.bbdfunctionclass"  >
      		                 <option value="">----请选择----</option>
                             <option value="1" ${brandPo.bbdfunctionclass eq '1' ? 'selected="selected"' : '' }>白色片</option>
                             <option value="2" ${brandPo.bbdfunctionclass eq '2' ? 'selected="selected"' : '' }>变色片</option>
                             <option value="3" ${brandPo.bbdfunctionclass eq '3' ? 'selected="selected"' : '' }>偏光片</option>
                             <option value="4" ${brandPo.bbdfunctionclass eq '4' ? 'selected="selected"' : '' }>变色偏光片</option>
                             <option value="5" ${brandPo.bbdfunctionclass eq '5' ? 'selected="selected"' : '' }>染色片</option>
                             <option value="6" ${brandPo.bbdfunctionclass eq '6' ? 'selected="selected"' : '' }>抗疲劳片</option>
                             <option value="7" ${brandPo.bbdfunctionclass eq '7' ? 'selected="selected"' : '' }>抗疲劳变色片</option>
                             <option value="8" ${brandPo.bbdfunctionclass eq '8' ? 'selected="selected"' : '' }>偏光抗疲劳片</option>
      	                   </select>
      	                </TD>
                      </TR>
                      <TR id="goodscatory302"> 

      	                <TD height="26" class="table_body">光度分类</TD>
			            <TD class="table_none">
                            <select clean=clean id="bbdluminosityclass" name="brandPo.bbdluminosityclass"  onChange="clicks2(this)" >
      		                 <option value="" ${brandPo.bbdluminosityclass eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                             <option value="0" ${brandPo.bbdluminosityclass eq '0' ? 'selected="selected"' : '' }>单光</option>
                             <option value="M" ${brandPo.bbdluminosityclass eq 'M' ? 'selected="selected"' : '' }>多光</option>
                             <option value="J" ${brandPo.bbdluminosityclass eq 'J' ? 'selected="selected"' : '' }>渐进</option>
                             <option value="K" ${brandPo.bbdluminosityclass eq 'K' ? 'selected="selected"' : '' }>抗疲劳</option>
                             <option value="Q" ${brandPo.bbdluminosityclass eq 'Q' ? 'selected="selected"' : '' }>其他</option>
      	                   </select>
      	                </TD>  
      	                <TD height="26" class="table_body"><span id="goodscatory303">渐进片分类</span>&nbsp;</TD>
			            <TD class="table_none" colspan="3">
                            <select clean=clean id="bbdgradualclass" name="brandPo.bbdgradualclass" >
      		                 <option value="" ${brandPo.bbdgradualclass eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                             <option value="1" ${brandPo.bbdgradualclass eq '1' ? 'selected="selected"' : '' }>青少年渐进</option>
                             <option value="2" ${brandPo.bbdgradualclass eq '2' ? 'selected="selected"' : '' }>成人渐进</option>
      	                   </select>
      	                </TD>
                     
                      </TR>
                      <TR> 
      	                <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
      	                	<TD height="26" class="table_body">采购结算方式</TD>
				            <TD class="table_none">
							     <li class="horizontal_onlyRight">
							     <select id="bbdsettlement" name="brandPo.bbdsettlement" onChange="showMonth()">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='jxfs'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(brandPo.bbdsettlement == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                            	 </select>
	                            </li>&nbsp;&nbsp;
	      	                   <span month="month">
	      	                     <input clean=clean type="text" class="text_input80" name="brandPo.bbdsettlementmonth" id="bbdsettlementmonth" month="month" maxlength="4" value="${brandPo.bbdsettlementmonth }" />
	      	                     &nbsp;&nbsp;天
							   </span>
	      	                </TD> 
	      	                <TD height="26" class="table_body">批号管理</TD>
			                <td align="left" class="table_none" width="6%" colspan="3">
			                	<input type="radio" name="brandPo.bbdbarcodeflag" value="1">是<input type="radio" name="brandPo.bbdbarcodeflag" value="0" checked="checked" />否
                            </td> 
      	                </c:if>
      	                
      	                <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
      	                	<TD height="26" class="table_body">采购结算方式</TD>
				            <TD class="table_none">
							     <li class="horizontal_onlyRight">
	                            <select id="bbdsettlement" name="brandPo.bbdsettlement" onChange="showMonth()">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='jxfs'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(brandPo.bbdsettlement == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                            	 </select></li>&nbsp;&nbsp;
	      	                   <span month="month">
	      	                     <input clean=clean type="text" class="text_input80" name="brandPo.bbdsettlementmonth" id="bbdsettlementmonth" month="month" maxlength="4" value="${brandPo.bbdsettlementmonth }" />
	      	                     &nbsp;&nbsp;天
							   </span>
	      	                </TD>
	      	                <TD height="26" class="table_body">商品级别</TD>
			                <td align="left" class="table_none" width="6%">
			                	<select id="bbddefaultdiscount" name="brandPo.bbddefaultdiscount">
			                		<option value="">---请选择---</option>
			                		<s:iterator value="selectGoodsLevelList">
						               	<option value="${bgluuid}"  ${brandPo.bbddefaultdiscount eq bgluuid ? 'selected="selected"' : '' }>${bglname}</option>
			     	                </s:iterator>
			                	</select>
                            </td>
	      	                <TD height="26" class="table_body">批号管理</TD>
			                <td align="left" class="table_none" width="6%">
			                	<input type="radio" name="brandPo.bbdbarcodeflag" value="1" ${brandPo.bbdbarcodeflag eq '1' ? 'checked="checked"' : '' } />是<input type="radio" name="brandPo.bbdbarcodeflag" value="0" ${brandPo.bbdbarcodeflag ne '1' ? 'checked="checked"' : '' } />否
                            </td>                            
      	                </c:if>
                      </TR>
                      <TR> 
                        <TD height="26" class="table_body">促销金额</TD>
			               <TD class="table_none">
			                 <input clean=clean class="text_input160" id="bbdpromotion" name="brandPo.bbdpromotion" maxlength="9" value="${brandPo.bbdpromotion}" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写促销金额！'}]"/>
      	                </TD> 
      	                <TD height="30" class="table_body">速记码</TD>
                        <TD class="table_none" colspan="3">
                        	<input class="text_input100" id="bbdmnemoniccode" name="brandPo.bbdmnemoniccode" maxlength="25" value="${brandPo.bbdmnemoniccode }"></label>
			            </TD>                
                      </TR>
                      
                      <c:if test="${systemParameterPo.fsphisflag == '2'}">
	                      <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
								   <li class="horizontal_onlyRight">
								     <select id="bbdpayfeeid" name="brandPo.bbdpayfeeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收费项目！'}]">
	                                   <option value="">---请选择---</option>
	                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
			                               <option value="${optionParamPoTmp.fopparamid }" ${(brandPo.bbdpayfeeid == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                              </c:if>	                                      	
		                               </c:forEach> 
	                            	 </select>
		                           </li>
		                           <label style="color:red;">&nbsp;*</label>
		      	             </TD>                
	                      </TR>
                      </c:if>
                      
                      </TBODY>
                    </TABLE>
 		
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();" >
                        	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()">
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
                
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
    <script>	
    $(document).ready(function(){
    	$('tr[id=goodscatory302]').hide();
        $('tr[id=goodscatory302]').hide();
        $('tr[id=goodscatory1]').hide();
        $('tr[id=goodscatory4]').hide();
        $('tr[id=goodscatory5]').hide();
        checkid();
    	
    	var categoryid=${brandPo.bspcategoryid}+'';
    	if(categoryid != ''){
        	createcategory(categoryid);
        }

		var showMonth = "${brandPo.bbdsettlement }";
		if(showMonth != "2") {
	    	$("input[month=month]").hide();
	    	$("span[month=month]").hide();
		}
		if ('${errormsg}' != ''){
    	    alert('${errormsg}');
    	}
    	
    	$('#bbdid').focus();
	});
	function checkid(){
		var goodsType = '${bbdgoodscategory}';
		if(goodsType=='1'){
			//显示下拉菜单
	    	$('#goodscatory1').show();
	    	
	    	$('#bbdmaterialclass').removeAttr('validate').val('');
	    	$('#bbdluminosityclass').removeAttr('validate').val('');
	    	$('#bbdgradualclass').removeAttr('validate').val('');
	    	$('#bbdfunctionclass').removeAttr('validate').val('');
	    	$('#bbdrefractive').removeAttr('validate').val('');
	    	$('#bbdusetype').removeAttr('validate').val('');
	    	$('#bbdstealthclass').removeAttr('validate').val('');    		
	    		    	
	    	//隐藏下拉菜单
	    	$('#goodscatory4').hide();
	    	$('#goodscatory5').hide();
	    	$('#goodscatory301').hide();
	    	$('#goodscatory302').hide();
	    	
		}else if(goodsType=='3'){
			//显示下拉菜单
	    	$('#goodscatory301').show();
	    	$('#goodscatory302').show();
	    	
	    	$('#bbdframematerialtype').removeAttr('validate').val('');  
	    	$('#bbdusetype').removeAttr('validate').val('');
	    	$('#bbdstealthclass').removeAttr('validate').val(''); 	    	
	    	//隐藏下拉菜单
	    	$('#goodscatory4').hide();
	    	$('#goodscatory5').hide();
	    	$('#goodscatory1').hide();
		}else if(goodsType=='4'){
			//显示下拉菜单
	    	$('#goodscatory4').show();
	    	
	    	$('#bbdmaterialclass').removeAttr('validate').val('');
	    	$('#bbdluminosityclass').removeAttr('validate').val('');
	    	$('#bbdgradualclass').removeAttr('validate').val('');
	    	$('#bbdfunctionclass').removeAttr('validate').val('');
	    	$('#bbdrefractive').removeAttr('validate').val('');
            $('#bbdframematerialtype').removeAttr('validate').val('');            
	    	//隐藏下拉菜单
	    	$('#goodscatory1').hide();
	    	$('#goodscatory5').hide();
	    	$('#goodscatory301').hide();
	    	$('#goodscatory302').hide();
		}else if(goodsType=='5'){
			//显示下拉菜单
	    	$('#goodscatory5').show();
	    	
	    	$('#bbdmaterialclass').removeAttr('validate').val('');
	    	$('#bbdluminosityclass').removeAttr('validate').val('');
	    	$('#bbdgradualclass').removeAttr('validate').val('');
	    	$('#bbdfunctionclass').removeAttr('validate').val('');
	    	$('#bbdrefractive').removeAttr('validate').val('');
	    	$('#bbdusetype').removeAttr('validate').val('');
	    	$('#bbdstealthclass').removeAttr('validate').val(''); 
            $('#bbdframematerialtype').removeAttr('validate').val('');   
                
	    	$('#goodscatory1').hide();
	    	$('#goodscatory4').hide();
	    	$('#goodscatory301').hide();
	    	$('#goodscatory302').hide();
		}else{
	    	//隐藏下拉菜单
	    	$('#bbdmaterialclass').removeAttr('validate').val('');
	    	$('#bbdluminosityclass').removeAttr('validate').val('');
	    	$('#bbdgradualclass').removeAttr('validate').val('');
	    	$('#bbdfunctionclass').removeAttr('validate').val('');
	    	$('#bbdrefractive').removeAttr('validate').val('');
	    	$('#bbdusetype').removeAttr('validate').val('');
	    	$('#bbdstealthclass').removeAttr('validate').val(''); 
            $('#bbdframematerialtype').removeAttr('validate').val('');   
                
	    	$('#goodscatory1').hide();
	    	$('#goodscatory4').hide();
	    	$('#goodscatory5').hide();
	    	$('#goodscatory301').hide();
	    	$('#goodscatory302').hide();
		}
	}
		</script>	
    </html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
