<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其他商品类维护</title>
</head>
<script>

	function clean(){
		$("input[clean=clean]").val('');
		$("input[cleans=cleans]").val('17');
		$("input[goodsid=goodsid]").val('7.00.00.000000000.0000');
		$("input[goodscode=goodscode]").val('700000000000000000');
		$("select[clean=clean]").val('');
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
		bgiothergoodsbigclassOnChange();
		if('${person.syspsupplierid}' != ''){
			getGoodsID('supplier','${person.syspsupplierid}');
		}
	});
	function bgiothergoodsbigclassOnChange(){
		var selectedOption = "${goodsInfoPo.bgiothergoodssmallclass}";
		var obj;
		if(otherGoodsForm.bgiothergoodsbigclass.value=="Q"){//其它材料
			otherGoodsForm.bgiothergoodssmallclass.options.length=0;
			otherGoodsForm.bgiothergoodssmallclass.options.add(new Option("----请选择----",""));
			
			obj = new Option("办公用品","001");
			obj.setAttribute("selected", (selectedOption == "001"));
			otherGoodsForm.bgiothergoodssmallclass.options.add(obj); 

			obj = new Option("印刷品","002");
			obj.setAttribute("selected", (selectedOption == "002"));
			otherGoodsForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("眼镜用具","003");
			obj.setAttribute("selected", (selectedOption == "003"));
			otherGoodsForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("其它","004");
			obj.setAttribute("selected", (selectedOption == "004"));
			otherGoodsForm.bgiothergoodssmallclass.options.add(obj);
			
		}else if(otherGoodsForm.bgiothergoodsbigclass.value=="D"){//低值易耗品
			otherGoodsForm.bgiothergoodssmallclass.options.length=0;
			otherGoodsForm.bgiothergoodssmallclass.options.add(new Option("----请选择----","")); 

			obj = new Option("加工工具","001");
			obj.setAttribute("selected", (selectedOption == "001"));
			otherGoodsForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("办公工具","002"); 
			obj.setAttribute("selected", (selectedOption == "002"));
			otherGoodsForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("验配工具","003");
			obj.setAttribute("selected", (selectedOption == "003"));
			otherGoodsForm.bgiothergoodssmallclass.options.add(obj);

			obj = new Option("其它","004");
			obj.setAttribute("selected", (selectedOption == "004"));
			otherGoodsForm.bgiothergoodssmallclass.options.add(obj);
		}		
	}
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
         var length=9-value.length;
         if(length>0){
           for(var i=0;i<length;i++){
             value='0'+value;
           }
         }else{
           value = value.substring(value.length-9,value.length);
         }
         goodsID=goodsID1+value+goodsID2;
      }else if(name=='color'){
         if(value.length>10){
           alert('商品编码不能大于10字符');
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
          var length=9-value.length;
          if(length>0){
              for(var i=0;i<length;i++){
                value='0'+value;
              }
          }else{
              value = value.substring(value.length-9,value.length);
          }
          goodsID=goodsID1+value+goodsID2;
      }

      var goodscode = goodsID.split(".").join("") ;   
      document.all.bgigoodsid.value=goodsID.toUpperCase();
      document.all.bgigoodsbarcode.value=goodscode.toUpperCase();
	}
	function save(){
	if(checkForm(document.all.otherGoodsForm)){  

	    var bgitaxrate= parseInt(document.all.bgitaxrate.value);
	    if(bgitaxrate>100||bgitaxrate<0){
	      alert('税率必须在0-100之间');
	      document.all.bgitaxrate.focus();
	      return false;
	    } 
	    $("img").removeAttr("onclick");
		otherGoodsForm.action = "insertOtherGoodsAR.action";
		otherGoodsForm.submit();
		}
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=7",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=7",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
			showPopWin("selBrandOpen.action?categoryID_open=7&supplierID_open=" + document.getElementById('bgisupplierid').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=7&supplierID_open=" + document.getElementById('bgisupplierid').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		$('#bgidefaultdiscountvalue').val(json.bbddefaultdiscount);
		$('#bgipayfeeid').val(json.bbdpayfeeid);

		if(json.bbdbarcodeflag=="1"){
			document.getElementById('bgibarcodeflagid1').checked="checked";
		}else{
			document.getElementById('bgibarcodeflagid2').checked="checked";
		}
		
		$('#bgiunitid').val(json.unit);
		getGoodsID('brand',document.getElementById('bgibrandid').value);
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="otherGoodsForm" method="post" action="">

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
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
                            <c:if test="${!empty goodsInfoPo.bgigoodsid}">
                            <input class="text_input200" type="text" id="bgigoodsid" goodsid=goodsid value="${goodsInfoPo.bgigoodsid}" name="goodsInfoPo.bgigoodsid" readonly="readonly">
			               </c:if>
			                <c:if test="${empty goodsInfoPo.bgigoodsid}">
                            <input class="text_input200" type="text" id="bgigoodsid" goodsid=goodsid name="goodsInfoPo.bgigoodsid" value="7.00.00.000000000.0000" readonly="readonly">
			               </c:if>
			               </TD>
			                  <TD width="9%" class="table_body">商品条码</TD>
			               <TD width="24%" class="table_none">
			               <c:if test="${!empty goodsInfoPo.bgigoodsbarcode}">
                            <input class="text_input200" goodscode=goodscode type="text" id="bgigoodsbarcode" readonly="readonly" value="${goodsInfoPo.bgigoodsbarcode}" name="goodsInfoPo.bgigoodsbarcode"  maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品条码不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </c:if>
			                <c:if test="${empty goodsInfoPo.bgigoodsbarcode}">
                            <input class="text_input200" goodscode=goodscode type="text" id="bgigoodsbarcode" readonly="readonly" name="goodsInfoPo.bgigoodsbarcode" value="700000000000000000" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品条码不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </c:if>
			               </TD>
			               <TD width="9%" class="table_body">商品名称</TD>
			               <TD class="table_none">
                             <input class="text_input160" clean=clean type="text" id="bgigoodsname" value="${goodsInfoPo.bgigoodsname}" name="goodsInfoPo.bgigoodsname" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
	                    </TR>
                        <TR>
                         <TD height="26" class="table_body">制造商</TD>
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
						   		<input type="hidden" clean=clean id="bgisupplierid" value="${goodsInfoPo.bgisupplierid}" name="goodsInfoPo.bgisupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						     <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" ></li><label style="color:red;">&nbsp;*</label>
							   	</c:if>                          
			               </TD>
                           <TD  class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input id="bgibrandname" clean=clean class="text_input160" value="${goodsInfoPo.bgibrandname}" name="goodsInfoPo.bgibrandname" readonly="readonly"/>
						   		<input type="hidden" clean=clean id="bgibrandid" value="${goodsInfoPo.bgibrandid}" name="goodsInfoPo.bgibrandid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属品种不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" ></li><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">厂家型号</TD>
			               <TD class="table_none">
                             <input class="text_input100" clean=clean type="text" id="bgisupplierspec" value="${goodsInfoPo.bgisupplierspec}"  onkeyup="getGoodsID('sspec',document.all.bgisupplierspec.value);" onchange="getGoodsID('sspec',document.all.bgisupplierspec.value);" name="goodsInfoPo.bgisupplierspec" maxlength="30"><label style="color:red;">&nbsp;*</label>
			               </TD>
	                    </TR>
                        <TR>
                           <TD height="26" class="table_body">型号</TD>
			               <TD class="table_none">
                             <input class="text_input100" clean=clean type="text" id="bgispec" value="${goodsInfoPo.bgispec}" name="goodsInfoPo.bgispec" onkeyup="value=value.replace(/[^\w\d]/g,'');getGoodsID('spec',document.all.bgispec.value);" onchange="this.value = this.value.toUpperCase();getGoodsID('spec',document.all.bgispec.value);" maxlength="30" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '型号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '型号不能包含中文！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '型号只允许输入整数和字母！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                           <TD class="table_body">商品编号</TD>
			               <TD class="table_none">
                             <input class="text_input100" clean=clean type="text" id="bgicolor" value="${goodsInfoPo.bgicolor}" name="goodsInfoPo.bgicolor" onkeyup="value=value.replace(/[^\w\d]/g,'');getGoodsID('color',document.all.bgicolor.value);" onchange="getGoodsID('color',document.all.bgicolor.value);" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '商品编号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '商品编号不能包含中文！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">其它商品大类</TD>
			               <TD class="table_none">
                             <select clean=clean onChange="bgiothergoodsbigclassOnChange()" id="bgiothergoodsbigclass" name="goodsInfoPo.bgiothergoodsbigclass" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '其它商品大类不能为空！'}]">
      		                   <option value="">----请选择----</option>
				               <option ${goodsInfoPo.bgiothergoodsbigclass eq "Q" ? 'selected="selected"' : '' } value="Q" >其它材料</option>
				               <option ${goodsInfoPo.bgiothergoodsbigclass eq "D" ? 'selected="selected"' : '' } value="D" >低值易耗品</option>
      	                     </select><label style="color:red;">&nbsp;*</label>
			               </TD>
			            </tr>
			            <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
			            <tr>
			               <TD height="26" class="table_body">其它商品小类</TD>
			               <TD class="table_none">
                             <select clean=clean id="bgiothergoodssmallclass" name="goodsInfoPo.bgiothergoodssmallclass" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '其它商品小类不能为空！'}]">
      		                   <option value="">----请选择----</option>
      	                    </select><label style="color:red;">&nbsp;*</label>
			               </TD>
                          <TD  class="table_body">计量单位</TD>
			               <TD class="table_none">
                             <select clean=clean id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]">
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">商品级别</TD>
			               <td align="left" class="table_none">
			                	<select id="bgidefaultdiscountvalue" name="goodsInfoPo.bgidefaultdiscountvalue">
			                		<option value="">---请选择---</option>
			                		<s:iterator value="selectGoodsLevelList">
						               	<option value="${bgluuid}" ${goodsInfoPo.bgidefaultdiscountvalue eq bgluuid ? 'selected="selected"' : '' }>${bglname}</option>
			     	                </s:iterator>
			                	</select>
                           </td>
                        </TR>
                        <tr>
	      	               <TD height="26" class="table_body">批号管理</TD>
			               <td align="left" class="table_none" colspan="5">
			               		<input type="radio" id="bgibarcodeflagid1" name="goodsInfoPo.bgibarcodeflag" value="1" ${goodsInfoPo.bgibarcodeflag eq '1' ? 'checked="checked"' : '' } />是<input type="radio" id="bgibarcodeflagid2" name="goodsInfoPo.bgibarcodeflag" value="0" ${goodsInfoPo.bgibarcodeflag ne '1' ? 'checked="checked"' : '' } />否<label style="color:red;">&nbsp;*</label>
                           </td>                        	
                        </tr>
                        </c:if>
                        <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
			            <tr>
			               <TD height="26" class="table_body">其它商品小类</TD>
			               <TD class="table_none">
                             <select clean=clean id="bgiothergoodssmallclass" name="goodsInfoPo.bgiothergoodssmallclass" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '其它商品小类不能为空！'}]">
      		                   <option value="">----请选择----</option>
      	                    </select><label style="color:red;">&nbsp;*</label>
			               </TD>
                          <TD class="table_body">计量单位</TD>
			               <TD class="table_none">
                             <select clean=clean id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]">
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
      	                    <input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="${defaultdiscountvalue }">
			               </TD>
	      	               <TD height="26" class="table_body">批号管理</TD>
			               <td align="left" class="table_none">
			               		<input type="radio" id="bgibarcodeflagid1" name="goodsInfoPo.bgibarcodeflag" value="1" ${goodsInfoPo.bgibarcodeflag eq '1' ? 'checked="checked"' : '' } />是<input type="radio" id="bgibarcodeflagid2" name="goodsInfoPo.bgibarcodeflag" value="0" ${goodsInfoPo.bgibarcodeflag ne '1' ? 'checked="checked"' : '' } />否<label style="color:red;">&nbsp;*</label>
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
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;价&nbsp;格&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                   <c:if test="${(permissionPo.keyf==1)}">    
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">   
                        <tr>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">爱尔结算价</TD>
			               <TD class="table_none" width="24%">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgicostprice" value="${goodsInfoPo.bgicostprice}" name="goodsInfoPo.bgicostprice"  maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">*</label>
			               </TD>                        
                         <TD class="table_body" width="9%">批发价格</TD>
                         <TD class="table_none">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			             </TD>
			           </tr>
			           <%--<tr>
			             <TD height="26" class="table_body">加权平均成本</TD>
			             <TD class="table_none" colspan="5">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgiaveragenotnaxrate}" id="bgiaveragenotnaxrate" name="goodsInfoPo.bgiaveragenotnaxrate" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(6);}"  maxlength="10" ><label style="color:red;">&nbsp;*</label>
			             </TD>
			           </tr>--%>
			         </c:if>  
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">   
                        <tr>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">爱尔结算价</TD>
			               <TD class="table_none" colspan="3">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgicostprice" value="${goodsInfoPo.bgicostprice}" name="goodsInfoPo.bgicostprice"  maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">*</label>
			               </TD>             
			               <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />           
			           </tr>
			           <%--<tr>
			             <TD height="26" class="table_body">加权平均成本</TD>
			             <TD class="table_none" colspan="5">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgiaveragenotnaxrate}" id="bgiaveragenotnaxrate" name="goodsInfoPo.bgiaveragenotnaxrate" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(6);}"  maxlength="10" ><label style="color:red;">&nbsp;*</label>
			             </TD>
			           </tr>--%>
			         </c:if>
			      </c:if>
			      	<c:if test="${(permissionPo.keyf != 1)}">
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}"> 
			      		<tr>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>                     
                           <TD class="table_body" width="9%">批发价格</TD>
                           <TD class="table_none" colspan="3">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                      		<input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                      	</tr>
                   </c:if>
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}"> 
			      		<tr>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" colspan="5">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                      		<input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                      		<input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
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
								耗材：<br>
								商品代码组成说明：<br>
								<IMG src="${ctx}/img/pic/haocai.png" ><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品条码会根据商品代码自动生成。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品名称默认为选择的品种的名称，可以自行调整。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">型号用于区分相同制造商、品种下的不同商品。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品编号用于区分相同制造商、品种、型号的商品。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">成本价格为爱尔结算价。</font><br>
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