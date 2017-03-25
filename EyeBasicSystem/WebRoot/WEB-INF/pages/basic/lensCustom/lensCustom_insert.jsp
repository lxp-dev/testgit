<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订做镜片维护</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
　　 	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }

	function getGoodsID(name,value){
		value=trim(value);
      var goodsID=document.all.bgigoodsid.value;
      if(name=='supplier'){
         var goodsID1=goodsID.substring(0,2);
         var goodsID2=goodsID.substring(4,22);
         goodsID=goodsID1+value+goodsID2;
      }else if(name=='brand'){
         var goodsID1=goodsID.substring(0,5);
         var goodsID2=goodsID.substring(7,22);
         goodsID=goodsID1+value+goodsID2;
      }else if(name=='spec'){
         if(value.length>30){
           alert('规格不能大于30字符');
           document.getElementById('bgispec').value='';
           return false;
         }
         var goodsID1=goodsID.substring(0,8);
         var goodsID2=goodsID.substring(17,22);
         var length=8-value.length;
         if(length>0){
           for(var i=0;i<length;i++){
             value='0'+value;
           }
         }else{
           value = value.substring(value.length-8,value.length);
         }
         goodsID=goodsID1+"D"+value+goodsID2;
      }else if(name=='color'){
         if(value.length>10){
           alert('商品编号不能大于10字符');
           document.getElementById('bgicolor').value='';
           return false;
         }
         var goodsID1=goodsID.substring(0,18);
         var length=4-value.length;
         if(length>0){
           for(var i=0;i<length;i++){
             value='0'+value;
           }
         }else{
           value = value.substring(value.length-4,value.length);
         }
         goodsID=goodsID1+value;
      }else if(name=='sspec'){
    	  value=value.replace(/[^\d\w]/g,'');
    	  $('#bgispec').val(value.substring(value.length-9,value.length));
          if(value.length>30){
              alert('规格不能大于30字符');
              document.getElementById('bgispec').value='';
              return false;
            }
            var goodsID1=goodsID.substring(0,8);
            var goodsID2=goodsID.substring(17,22);
            var length=8-value.length;
            if(length>0){
              for(var i=0;i<length;i++){
                value='0'+value;
              }
            }else{
              value = value.substring(value.length-8,value.length);
            }
            goodsID=goodsID1+"D"+value+goodsID2;
      }

      var goodscode = goodsID.split(".").join("") ;   
      document.all.bgigoodsid.value=goodsID.toUpperCase(); 
      document.all.bgigoodsbarcode.value=goodscode.toUpperCase(); 
	}
	function save(){
		 if($('#bgisupplierspec').val()==''){
				alert("厂家型号不允许为空!");
				$('#bgisupplierspec').focus();
				$('#bgisupplierspec').select();
				return;
			}
	var bgiismutiluminosity = document.getElementById("bgiismutiluminosity");
	var bgibelowplusluminosityulValidate=document.all.bgibelowplusluminosityul.validate;
	var bgibelowplusluminosityupValidate=document.all.bgibelowplusluminosityup.validate;
	
	if (/^[^MJ]$/.test(bgiismutiluminosity.value)){// 镜片型是多光渐进验证下加光
		document.all.bgibelowplusluminosityul.validate = "";
	    document.all.bgibelowplusluminosityup.validate = "";
	}
	
	if(checkForm(document.all.lensCustomForm)){
		var bgisphul=parseFloat(document.all.bgisphul.value);
	    var bgisphup=parseFloat(document.all.bgisphup.value);
	    if(bgisphul<bgisphup){
	      alert('球镜下限不能大于球镜上限');
	      document.all.bgisphul.focus();
	      return false;
	    }

	    var bgicylul=parseFloat(document.all.bgicylul.value);
	    var bgicylup=parseFloat(document.all.bgicylup.value);
	    if(bgicylul<bgicylup){
	      alert('柱镜下限不能大于柱镜上限');
	      document.all.bgicylup.focus();
	      return false;
	    }
	    
	    var bgibelowplusluminosityul=parseFloat(document.all.bgibelowplusluminosityul.value);
	    var bgibelowplusluminosityup=parseFloat(document.all.bgibelowplusluminosityup.value);
	    if(bgibelowplusluminosityul<bgibelowplusluminosityup){
	      alert('下加光下限不能大于下加光上限');
	      document.all.bgibelowplusluminosityup.focus();
	      return false;
	    }

	    if($("#bgiismutiluminosity").val() == 'J'){
			if($("#bgigradualclass").val() == ""){
				alert("请选择渐进片分类！");
				$("#bgigradualclass").focus();
				return;
			}
		}
	    
	    var bgitaxrate= parseInt(document.all.bgitaxrate.value);
	    if(bgitaxrate>100||bgitaxrate<0){
	      alert('税率必须在0-100之间');
	      document.all.bgitaxrate.focus();
	      return false;
	    } 

	    var bgiordercycle= parseInt(document.all.bgiordercycle.value);
	    if(bgiordercycle<0){
	      alert('订做周期不能小于0');
	      document.all.bgiordercycle.focus();
	      return false;
	    } 
	    
	    $("img").removeAttr("onclick");
		lensCustomForm.action = "insertLensCustom.action";
		lensCustomForm.submit();
		}else {
			document.all.bgibelowplusluminosityul.validate = bgibelowplusluminosityulValidate;
		    document.all.bgibelowplusluminosityup.validate = bgibelowplusluminosityupValidate;
		}
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=3",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=3",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bgisupplierid').value = json.id;
		document.getElementById('bgisuppliername').value = json.value;
		
		document.getElementById('bgibrandid').value = "";
		document.getElementById('bgibrandname').value = "";
		document.getElementById('bgigoodsname').value = "";
		
		$('#bgiunitid').val("");
		$('#bgirefractive').val("");

        $('#bgieyeglassmaterialtype').val("");
        $('#bgiismutiluminosity').val('0');
        $('#bgigradualclass').val('');
        $('#bgifunctionclass').val("");
		
		
		getGoodsID('supplier',document.getElementById('bgisupplierid').value);
		
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var bgisupplierid=document.getElementById('bgisupplierid').value;
	    if(bgisupplierid==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('bgisupplierid').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('bgisupplierid').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('bgibrandid').value = json.brandID;
		document.getElementById('bgibrandname').value = json.brandName;
		document.getElementById('bgigoodsname').value = json.brandName;
		
		$('#bgiunitid').val(json.unit);
		$('#bgirefractive').val(json.refractive);
		$('#bgipayfeeid').val(json.bbdpayfeeid);
        $('#bgieyeglassmaterialtype').val(json.bbdmaterialclass);
        $('#bgiismutiluminosity').val(json.bbdluminosityclass);  
        if (json.bbdluminosityclass == 'J'){
        	$('#bgigradualclass').show();
        }else{
        	$('#bgigradualclass').hide();
        	$('#bgigradualclass').val('');
        }
        $('#bgigradualclass').val(json.bbdgradualclass);
        $('#bgifunctionclass').val(json.bbdfunctionclass);
        $('#bgidefaultdiscountvalue').val(json.bbddefaultdiscount);
		
		getGoodsID('brand',document.getElementById('bgibrandid').value);
	}
	
	function clean(){
		$("input[clean=clean]").val('');
		$("input[cleans=cleans]").val('17');
		$("input[goodsid=goodsid]").val('3.00.00.D00000000.0000');
		$("input[goodscode=goodscode]").val('300000000000000000');
		$("select[clean=clean]").val('');
		$("#bgisphul").val('0.00');
		$("#bgisphup").val('0.00');
		$("#bgicylul").val('0.00');
		$("#bgicylup").val('0.00');
		$("#bgiismutiluminosity").val('O');
		if($("#bgiismutiluminosity").val() == 'J'){
			$("#bgigradualclass").show();
		}else{
			$("#bgigradualclass").hide();
		}
		
		if('${person.syspsupplierid}' != ''){
			getGoodsID('supplier','${person.syspsupplierid}');
		}
		
	}

	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		if($("#bgiismutiluminosity").val() == 'J'){
			$("#bgigradualclass").show();
		}else{
			$("#bgigradualclass").hide();
		}
		if('${person.syspsupplierid}' != ''){
			getGoodsID('supplier','${person.syspsupplierid}');
		}
	});

	function changeMutiluminosity(){
		if($("#bgiismutiluminosity").val() == 'J'){
			$("#bgigradualclass").show();
			$("#bgigradualclass").val("");
		}else{
			$("#bgigradualclass").hide();
			$("#bgigradualclass").val("");
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="lensCustomForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" /> 
<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="7%" height="26" class="table_body">商品代码</TD>
			               <TD width="27%" class="table_none">
                            <c:if test="${!empty goodsInfoPo.bgigoodsid}">
                            <input class="text_input160" type="text" id="bgigoodsid" goodsid=goodsid value="${goodsInfoPo.bgigoodsid}" name="goodsInfoPo.bgigoodsid" readonly="readonly">
			               </c:if>
			                <c:if test="${empty goodsInfoPo.bgigoodsid}">
                            <input class="text_input160" type="text" id="bgigoodsid" goodsid=goodsid name="goodsInfoPo.bgigoodsid" value="3.00.00.D00000000.0000" readonly="readonly">
			               </c:if>
			               </TD>
			                 <TD width="7%" height="26" class="table_body">商品条码</TD>
			               <TD width="27%" class="table_none">
			               <c:if test="${!empty goodsInfoPo.bgigoodsbarcode}">
                            <input class="text_input160" type="text" id="bgigoodsbarcode" goodscode=goodscode readonly="readonly" value="${goodsInfoPo.bgigoodsbarcode}" name="goodsInfoPo.bgigoodsbarcode"  maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品条码不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </c:if>
			                <c:if test="${empty goodsInfoPo.bgigoodsbarcode}">
                            <input class="text_input160" type="text" id="bgigoodsbarcode" goodscode=goodscode readonly="readonly" name="goodsInfoPo.bgigoodsbarcode" value="300000000000000000" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品条码不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </c:if>
			               </TD>
			               <TD width="7%" class="table_body">商品名称</TD>
			               <TD class="table_none">
                             <input class="text_input160" clean=clean type="text" id="bgigoodsname" value="${goodsInfoPo.bgigoodsname}" name="goodsInfoPo.bgigoodsname" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>                        
                        <TR>
                         <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">    
			               		<c:if test="${person.syspsupplierid ne ''}">
							   		<li class="horizontal_onlyRight">
							   		${person.syspsuppliername }
							   		<input type="hidden" id="bgisupplierid" name="goodsInfoPo.bgisupplierid" value="${person.syspsupplierid }" />
							   	</li>
							   	</c:if>
							   	<c:if test="${person.syspsupplierid eq ''}">
							   		<li class="horizontal_onlyRight">
								   		<input id="bgisuppliername" clean=clean class="text_input160" value="${goodsInfoPo.bgisuppliername}" name="goodsInfoPo.bgisuppliername"  readonly="readonly" />
								   		<input type="hidden" clean=clean id="bgisupplierid"  value="${goodsInfoPo.bgisupplierid}" name="goodsInfoPo.bgisupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
								   	</li>
								   	<li class="horizontal_onlyRight">
								    <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
								    
								    </li><label style="color:red;">&nbsp;*</label>	
							   	</c:if>                         
			               </TD>
                           <TD  class="table_body">商品品种</TD>
			               <TD  class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input id="bgibrandname" clean=clean class="text_input160" value="${goodsInfoPo.bgibrandname}" name="goodsInfoPo.bgibrandname" readonly="readonly"/>
						   		<input type="hidden" clean=clean id="bgibrandid" value="${goodsInfoPo.bgibrandid}" name="goodsInfoPo.bgibrandid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属品种不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" ></li><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD height="26" class="table_body">厂家型号</TD>
			               <TD class="table_none">
                             <input class="text_input100" clean=clean type="text" id="bgisupplierspec" value="${goodsInfoPo.bgisupplierspec}"  onkeyup="getGoodsID('sspec',document.all.bgisupplierspec.value);" onchange="getGoodsID('sspec',document.all.bgisupplierspec.value);" name="goodsInfoPo.bgisupplierspec" maxlength="30"><label style="color:red;">&nbsp;*</label>
			               </TD>	               
                        </TR>                        
                        <TR>
                           <TD  height="26" class="table_body">型号</TD>
			               <TD  class="table_none">
                             <input class="text_input100" clean=clean type="text" value="${goodsInfoPo.bgispec}" id="bgispec" name="goodsInfoPo.bgispec" onkeyup="value=value.replace(/[^\w\d]/g,'');getGoodsID('spec',document.all.bgispec.value);" onchange="getGoodsID('spec',document.all.bgispec.value);" maxlength="30" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '型号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '型号不能包含中文！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '型号只允许输入整数和字母！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                           <TD  height="26" class="table_body">商品编号</TD>
			               <TD  class="table_none">
                             <input class="text_input100" clean=clean type="text" id="bgicolor" value="${goodsInfoPo.bgicolor}" name="goodsInfoPo.bgicolor" onkeyup="value=value.replace(/[^\w\d]/g,'');getGoodsID('color',document.all.bgicolor.value);" onchange="getGoodsID('color',document.all.bgicolor.value);" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '商品编号不能包含中文！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD  class="table_body">计量单位</TD>
			               <TD  class="table_none">
                            <select clean=clean id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]">
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			            </TR>
			            <tr>
			               <TD  height="26" class="table_body">球镜</TD>
			               <TD  class="table_none">
			               		 <select id="bgisphup" name="goodsInfoPo.bgisphup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜下限不能为空！'}]">
      		                 		<option value="">---请选择---</option>
      		                 		<c:forEach var="x" begin="1" end="249" step="1" varStatus="index">
			               				<c:set var="lens" value="${-31.00 + (0.25 * (index.index - 1))}" />
										<!-- <option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>">${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>-->
			               				<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisphup + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select> -
	                             <select id="bgisphul" name="goodsInfoPo.bgisphul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜上限不能为空！'}]">
      		                 		<option value="">---请选择---</option>
      		                 		<c:forEach var="x" begin="1" end="249" step="1" varStatus="index">
			               				<c:set var="lens" value="${-31.00 + (0.25 * (index.index - 1))}" />
										<!-- <option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" >${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option> -->
			               				<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisphul + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>
										</option>
			               			</c:forEach>
      	                   		 </select>
      	                   		   跨度
	      	                	 <select id="bgisphspan" name="goodsInfoPo.bgisphspan" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '跨度不能为空！'}]">
										<option value="0.25" ${goodsInfoPo.bgisphspan != '0.25' ? '' : 'selected="selected"' }>0.25</option>
										<option value="0.50" ${goodsInfoPo.bgisphspan != '0.50' ? '' : 'selected="selected"' }>0.50</option>
										<option value="0.75" ${goodsInfoPo.bgisphspan != '0.75' ? '' : 'selected="selected"' }>0.75</option>
										<option value="1.00" ${goodsInfoPo.bgisphspan != '1.00' ? '' : 'selected="selected"' }>1.00</option>
	      	                     </select><label style="color:red;">&nbsp;*</label>
			               </TD>
                         <TD  class="table_body">柱镜</TD>
			               <TD  class="table_none">
			               		<select id="bgicylup" name="goodsInfoPo.bgicylup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜下限不能为空！'}]">
      		                 		<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="41" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens }" ${goodsInfoPo.bgicylup + 0 != lens ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select>-
								 <select id="bgicylul" name="goodsInfoPo.bgicylul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜上限不能为空！'}]">
      		                 		<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="41" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens }" ${goodsInfoPo.bgicylul + 0 != lens ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select>
      	                   		   跨度
	      	                     <select id="bgicylspan" name="goodsInfoPo.bgicylspan" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '跨度不能为空！'}]">
										<option value="0.25" ${goodsInfoPo.bgicylspan != '0.25' ? '' : 'selected="selected"' }>0.25</option>
										<option value="0.50" ${goodsInfoPo.bgicylspan != '0.50' ? '' : 'selected="selected"' }>0.50</option>
										<option value="0.75" ${goodsInfoPo.bgicylspan != '0.75' ? '' : 'selected="selected"' }>0.75</option>
										<option value="1.00" ${goodsInfoPo.bgicylspan != '1.00' ? '' : 'selected="selected"' }>1.00</option>
	      	                     </select><label style="color:red;">&nbsp;*</label>
							</TD>
						  <TD  class="table_body">下加光</TD>
			               <TD  class="table_none">
			               		 <select clean=clean id="bgibelowplusluminosityup" name="goodsInfoPo.bgibelowplusluminosityup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '下加光下限不能为空！'}]">
      		                 		<option value="">----请选择----</option>
      		                 		<option value="0.00" ${goodsInfoPo.bgibelowplusluminosityup!='0.00'?'':'selected="selected"'}>0.00</option>
      		                 		<c:forEach var="x" begin="2" end="17" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 + (0.25 * (index.index - 1))}" />
										<option value="${lens!=0?'+':'' }<fmt:formatNumber value="${lens }" pattern="0.00"/>">${lens!=0?'+':'' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select>
			               	      -
      	                   		 <select clean=clean id="bgibelowplusluminosityul" value="${goodsInfoPo.bgibelowplusluminosityul}" name="goodsInfoPo.bgibelowplusluminosityul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '下加光上限不能为空！'}]">
      		                 		<option value="">----请选择----</option>
      		                 		<option value="0.00" ${goodsInfoPo.bgibelowplusluminosityul!='0.00'?'':'selected="selected"'}>0.00</option>
      		                 		<c:forEach var="x" begin="2" end="17" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 + (0.25 * (index.index - 1))}" />
										<option value="${lens!=0?'+':'' }<fmt:formatNumber value="${lens }" pattern="0.00"/>">${lens!=0?'+':'' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select>
      	                   		 <label style="color:red;">&nbsp;*</label>
			               </TD>
			            </TR>
                        <TR>
						   <TD  height="26" class="table_body">轴位</TD>
			               <TD  class="table_none">
	                          <input clean=clean class="text_input100" onkeyup="value=value.replace(/[^\w\d]/g,'');" type="text" id="bgiaxis"  name="goodsInfoPo.bgiaxis" value="0" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '轴位不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '轴位不能大于10字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
						   <TD  height="26" class="table_body">材料分类</TD>
			               <TD  class="table_none" >
			               		<select clean=clean id="bgieyeglassmaterialtype"  name="goodsInfoPo.bgieyeglassmaterialtype" >
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgieyeglassmaterialtype != "1" ? '' : 'selected="selected"' }>树脂</option>
			               			<option value="2" ${goodsInfoPo.bgieyeglassmaterialtype != "2" ? '' : 'selected="selected"' }>玻璃</option>
			               			<option value="3" ${goodsInfoPo.bgieyeglassmaterialtype != "3" ? '' : 'selected="selected"' }>PC</option>
			               		</select>
      
			               </TD>
			               <TD  height="26" class="table_body">订做周期</TD>
			               <TD  class="table_none">
	                          <input clean=clean class="text_input80" type="text" id="bgiordercycle" name="goodsInfoPo.bgiordercycle" value="${goodsInfoPo.bgiordercycle}" maxlength="5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订做周期不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '订做周期应为数字！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '订做周期只允许输入正整数！'}]">天<label style="color:red;">&nbsp;*</label>
			               	  <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
	                              <input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="1.00" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品默认折扣！'},{'Type' : Type.String, 'Formula' : Formula.UDiscount, 'Message' : '请重新填写的商品默认折扣！'}]">
		                      </c:if>
			               </TD>
                        </TR> 
                        <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <TR>
						   <TD height="26" class="table_body">商品级别</TD>
			               <td align="left" class="table_none" width="6%" colspan="5">
			                	<select id="bgidefaultdiscountvalue" name="goodsInfoPo.bgidefaultdiscountvalue">
			                		<option value="">---请选择---</option>
			                		<s:iterator value="selectGoodsLevelList">
						               	<option value="${bgluuid}" ${goodsInfoPo.bgidefaultdiscountvalue eq bgluuid ? 'selected="selected"' : '' }>${bglname}</option>
			     	                </s:iterator>
			                	</select>
                           </td>
                        </TR> 
                        </c:if>
                        <c:if test="${systemParameterPo.fsphisflag == '2'}">
	                      <TR> 
				            <TD height="26" class="table_body">收费项目</TD>
				            <TD class="table_none" colspan="5">
								   <li class="horizontal_onlyRight">
								     <select id="bgipayfeeid" name="goodsInfoPo.bgipayfeeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择收费项目！'}]">
	                                   <option value="">---请选择---</option>
	                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                              <c:if test="${optionParamPoTmp.fopparentid=='his_payfee'}">
			                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgipayfeeid == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
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
                    
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;非&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                        	<TD  height="26" class="table_body" width="9%">镜片种类</TD>
			               	<TD  class="table_none" width="24%">
	                          <select  id="bgiismutiluminosity"  name="goodsInfoPo.bgiismutiluminosity" onchange="changeMutiluminosity();">
                              <option value="0" ${goodsInfoPo.bgiismutiluminosity == "0" ? 'selected="selected"' : '' }>单光</option>
                              <option value="M" ${goodsInfoPo.bgiismutiluminosity == "M" ? 'selected="selected"' : '' }>多光</option>
                              <option value="J" ${goodsInfoPo.bgiismutiluminosity == "J" ? 'selected="selected"' : '' }>渐进</option>
                              <option value="K" ${goodsInfoPo.bgiismutiluminosity == "K" ? 'selected="selected"' : '' }>抗疲劳</option>
                              <option value="Q" ${goodsInfoPo.bgiismutiluminosity == "Q" ? 'selected="selected"' : '' }>其它</option>
                            </select>
			               	</TD>
			                <TD  height="26" class="table_body" width="9%">渐进片分类</TD>
			                <TD  class="table_none" width="24%">
			               		<select clean=clean id="bgigradualclass"  name="goodsInfoPo.bgigradualclass">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgigradualclass != "1" ? '' : 'selected="selected"' }>青少年渐进</option>
			               			<option value="2" ${goodsInfoPo.bgigradualclass != "2" ? '' : 'selected="selected"' }>成人渐进</option>
			               		</select>
			                </TD>
							<TD  height="26" class="table_body" width="9%">折射率</TD>
	                        <TD class="table_none">
	                            <select clean=clean clean=clean id="bgirefractive"  name="goodsInfoPo.bgirefractive" >
	      		                 <option value="">----请选择----</option>
	      		                    <s:iterator value="refractiveSetList">
					               <option value="${brfname}" ${goodsInfoPo.bgirefractive == brfname ? 'selected="selected"' : '' }>${brfname}</option>
		     	                   </s:iterator>
	      	                   </select>
	      	                </TD>	
	      	             </TR>
	      	             <tr>
						  	<TD  height="26" class="table_body">镜片功能</TD>
			                <TD  class="table_none">
                           	 	<select id="bgifunctionclass" clean=clean name="goodsInfoPo.bgifunctionclass">
                                   <option value="" selected>---请选择---</option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='gn'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgifunctionclass == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                             	</select>
			                </TD>
			               <TD  height="26" class="table_body">联合光度</TD>
			               <TD  class="table_none">
	                          <input clean=clean class="text_input80" type="text" id="bgiunionsphcyl" name="goodsInfoPo.bgiunionsphcyl" value="${goodsInfoPo.bgiunionsphcyl}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '联合光度只允许输入正数！'}]">【格式：1.25】
			               </TD>
			               <TD width="12%" height="30" class="table_body">柱镜为-0.25度(-25散)：</TD>
			               	<TD width="38%" class="table_none">
	                          <select id="bgicyl25cannotdo" name="goodsInfoPo.bgicyl25cannotdo">
                              <option value="0" ${goodsInfoPo.bgicyl25cannotdo == "0" ? 'selected="selected"' : '' }>能</option>
                              <option value="1" ${goodsInfoPo.bgicyl25cannotdo == "1" ? 'selected="selected"' : '' }>不能</option>
                            </select>
			               	</TD>			                
                        </TR> 
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;价&nbsp;格&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
               <c:if test="${(permissionPo.keyf==1)}">         
                        <tr>
						  <c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                         	<TD height="26" class="table_body" width="9%">税率</TD>
			                <TD class="table_none" width="24%">
	                          <input cleans=cleans class="text_input80" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			                </TD>
                        	<TD class="table_body" width="9%">含税单价</TD>
			                <TD class="table_none" width="24%">
	                            <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice"   maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">&nbsp;*</label>
			                </TD>
                        	<TD class="table_body" width="9%">批发价格</TD>
			                <TD class="table_none">
                             <input clean=clean class="text_input100" onKeyUp="value=value.replace(/[^\d\.]/g,'')" type="text" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			                </TD>
			              </c:if>
						  <c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
                             <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
                         	<TD height="26" class="table_body">税率</TD>
			                <TD class="table_none">
	                          <input cleans=cleans class="text_input80" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			                </TD>
                        	<TD  height="26" class="table_body">含税单价</TD>
			                <TD  class="table_none" colspan="3">
	                            <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice"   maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">&nbsp;*</label>
			                </TD>
			              </c:if>
                        </tr>
                        <%--<tr>
                        <TD height="26" class="table_body">加权平均成本</TD>
			               <TD class="table_none" colspan="5">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgiaveragenotnaxrate}" id="bgiaveragenotnaxrate" name="goodsInfoPo.bgiaveragenotnaxrate" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(6);}"  maxlength="10" ><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </tr>--%>    
               </c:if>
               	  <c:if test="${(permissionPo.keyf != 1)}">
				    <c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                      <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                        <tr>
                        <TD height="26" class="table_body">税率</TD>
			               <TD class="table_none">
	                          <input cleans=cleans class="text_input80" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        	<TD class="table_body">批发价格</TD>
			                <TD class="table_none" colspan="3">
                             <input clean=clean class="text_input100" onKeyUp="value=value.replace(/[^\d\.]/g,'')" type="text" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			                </TD>
                        </tr> 
                    </c:if>
				    <c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
                      <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                      <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
                        <tr>
                        <TD height="26" class="table_body">税率</TD>
			               <TD  class="table_none" colspan="5">
	                          <input cleans=cleans class="text_input80" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </tr> 
                    </c:if>
                  </c:if>           
                      </TBODY>
                    </TABLE> 
                    <%@ include file="/commons/basic_retailPrices_insert.jsp" %>
                    </fieldset>
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                        	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
                          </TD>
						</TR>
						
						<tr>
						  	<td>
								<br>
								<br>
								订做镜片：<br>
								商品代码组成说明：<br>
								<IMG src="${ctx}/img/pic/dingzhipian.png" ><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品条码会根据商品代码自动生成。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品名称默认为选择的品种的名称，可以自行调整。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品编号用于区分相同制造商、品种、型号的商品。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">球镜柱镜选择光度订制范围的上下限。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">只有多光、渐进需要录入下加光中的值。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">计量单位、镜片种类、折射率、镜片功能等选项是直接从品种信息中带入，同时可以填选。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">成本价格为含税单价。</font><br>
							</td>
						</tr>
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