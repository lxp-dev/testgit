<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>软性接触镜成品维护</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
	    return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	
	function save(){
	if(checkForm(document.all.stealthFinishedForm)){  
	    var bgitaxrate= parseInt(document.all.bgitaxrate.value);
	    if(bgitaxrate>100||bgitaxrate<0){
	      alert('税率必须在0-100之间');
	      document.all.bgitaxrate.focus();
	      return false;
	    } 
	    
	    var bbdvaliddateUL = Number(document.getElementById('bgireturnmax').value);
		var bbdvaliddateUP = Number(document.getElementById('bgireturnmin').value);

		if (bbdvaliddateUL < bbdvaliddateUP) {
			alert("上限效期不能小于下限效期！");
			document.getElementById('bgireturnmax').select();
			return false;
		}
	    
        $("img").removeAttr("onclick");	      
		stealthFinishedForm.action = "updateStealthFinishedAR.action";
		stealthFinishedForm.submit();
		}
	}
	$(document).ready(function(){
		$('input[toValidate=toValidate]').each(function(){
			$(this).bind("keyup",function(){
				$(this).val(
				$(this).val().replace(/[^0-9.][0-9]*/g,'')
				);
			});
			
			$(this).bind("blur",function(){
				if($(this).val()!='')
			$(this).val(parseFloat($(this).val()).toFixed(2));
			});
		});
		
		$('#bgisph').attr('value','${goodsInfoPo.bgisph}');
		
	});
	
	
	function clean(){
		document.stealthFinishedForm.reset();
		$('#bgisph').attr('value','${goodsInfoPo.bgisph}');
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
<form name="stealthFinishedForm" method="post" action="">

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
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsid}<input class="text_input160" type="hidden" id="bgigoodsid" name="goodsInfoPo.bgigoodsid" value="${goodsInfoPo.bgigoodsid}">
			               </TD>
			               <TD width="9%" class="table_body">商品条码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsbarcode}<input class="text_input160" type="hidden" id="bgigoodsbarcode" name="goodsInfoPo.bgigoodsbarcode" value="${goodsInfoPo.bgigoodsbarcode}">
			               </TD>
			               <TD width="9%" class="table_body">商品名称</TD>
			               <TD class="table_none">
                             <input class="text_input160" type="text" id="bgigoodsname" name="goodsInfoPo.bgigoodsname" value="${goodsInfoPo.bgigoodsname}" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>				   
                        <TR>
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">                             
                           	${goodsInfoPo.bgisuppliername}		               
			               </TD>
                           <TD class="table_body">商品品种</TD>
			               <TD class="table_none">
                           ${goodsInfoPo.bgibrandname}
			               </TD>
			               <TD class="table_body">商品编号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgicolor}&nbsp;
			               </TD>
                        </TR>
                        <tr>
                           <TD height="26" class="table_body">计量单位</TD>
			               <TD class="table_none">
	                           <select id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]" >
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">球镜</TD>
			               <TD class="table_none">
                           <select id="bgisph" disabled="disabled"  name="goodsInfoPo.bgisph" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 	<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
		               				<c:set var="lens" value="${-26.00 + (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisph + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select><label style="color:red;">&nbsp;*</label> 
			               </TD>
			               <TD class="table_body">柱镜</TD>
			               <TD class="table_none">
                           <c:if test="${systemParameterPo.fspnegative==1}">
                           <select id="bgicyl" disabled="disabled" name="goodsInfoPo.bgicyl" onChange="getGoodsID('bgicyl',document.all.bgicyl.value);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
		               				<c:set var="lens" value="${-26.00 + (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicyl + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select><label style="color:red;">&nbsp;*</label>
      	                   </c:if>
      	                   <c:if test="${systemParameterPo.fspnegative!=1}">
                           <select id="bgicyl" disabled="disabled" name="goodsInfoPo.bgicyl" onChange="getGoodsID('bgicyl',document.all.bgicyl.value);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
		               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicyl + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select><label style="color:red;">&nbsp;*</label>
      	                   </c:if>
			               </TD>
			             </TR>
                         <TR>
			               <TD height="26" class="table_body">轴向</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" disabled="disabled" value="${goodsInfoPo.bgiaxis}" id="bgiaxis" name="goodsInfoPo.bgiaxis" maxlength="10">
			               </TD>
						   <TD class="table_body">曲率</TD>
			               <TD class="table_none">
                             <input class="text_input100" toValidate=toValidate type="text" id="bgicurvature1" name="goodsInfoPo.bgicurvature1" value="${goodsInfoPo.bgicurvature1}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '曲率不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               </TD>
			               <TD class="table_body">直径</TD>
			               <TD class="table_none" colspan="3">
                             <input class="text_input100" toValidate=toValidate type="text" id="bgidia" name="goodsInfoPo.bgidia" value="${goodsInfoPo.bgidia}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '直径不能为空！'}]"><label style="color:red;">&nbsp;*</label>
			               	 <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
	                              <input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="1.00" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品默认折扣！'},{'Type' : Type.String, 'Formula' : Formula.UDiscount, 'Message' : '请重新填写的商品默认折扣！'}]">
	                         </c:if>
			               </TD>
                        </TR>
                        <TR>
			               <TD height="26" class="table_body">接触镜类别</TD>
			               <TD class="table_none" colspan="5"> 
			               	 	<select id="bgicontacttype" clean=clean name="goodsInfoPo.bgicontacttype">
                                   <option value="" selected>---请选择---</option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='GCType'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgicontacttype == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                             	</select>
			               </TD>
			               </TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <tr>
                           <TD height="26" class="table_body">商品级别</TD>
			               <td align="left" class="table_none" colspan="5">
			                	<select id="bgidefaultdiscountvalue" name="goodsInfoPo.bgidefaultdiscountvalue">
			                		<option value="">---请选择---</option>
			                		<s:iterator value="selectGoodsLevelList">
						               	<option value="${bgluuid}" ${goodsInfoPo.bgidefaultdiscountvalue eq bgluuid ? 'selected="selected"' : '' }>${bglname}</option>
			     	                </s:iterator>
			                	</select>
                           </td>
                        </tr>
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
			               <TD height="26" class="table_body" width="9%">使用类型</TD>
			               <TD class="table_none" width="24%">
                           <select id="bgiusetype" name="goodsInfoPo.bgiusetype">
      		                 <option value="" ${goodsInfoPo.bgiusetype == '' ? 'selected="selected"' : '' }>----请选择----</option>
      		                 <option value="1" ${goodsInfoPo.bgiusetype == '1' ? 'selected="selected"' : '' }>常戴型</option>
      		                 <option value="2" ${goodsInfoPo.bgiusetype == '2' ? 'selected="selected"' : '' }>抛弃型</option>
      		                  <option value="3" ${goodsInfoPo.bgiusetype == '3' ? 'selected="selected"' : '' }>塑形镜</option>
      	                   </select>
			               </TD>
                           <TD class="table_body" width="9%">抛弃型分类</TD>
			               <TD class="table_none" width="24%">
                           <select clean=clean id="bgistealthclass"  name="goodsInfoPo.bgistealthclass" > 
      		                 <option value="">----请选择----</option>
                             <option value="1" ${goodsInfoPo.bgistealthclass != "1" ? '' : 'selected="selected"' }>日抛</option>
                             <option value="2" ${goodsInfoPo.bgistealthclass != "2" ? '' : 'selected="selected"' }>周抛</option>
                             <option value="9" ${goodsInfoPo.bgistealthclass != "9" ? '' : 'selected="selected"' }>双周抛</option>
                             <option value="3" ${goodsInfoPo.bgistealthclass != "3" ? '' : 'selected="selected"' }>月抛</option>
                             <option value="4" ${goodsInfoPo.bgistealthclass != "4" ? '' : 'selected="selected"' }>季抛</option>
                             <option value="5" ${goodsInfoPo.bgistealthclass != "5" ? '' : 'selected="selected"' }>半年抛</option>
                             <option value="6" ${goodsInfoPo.bgistealthclass != "6" ? '' : 'selected="selected"' }>年抛</option>
                             <option value="7" ${goodsInfoPo.bgistealthclass != "7" ? '' : 'selected="selected"' }>RGP</option>
                             <option value="8" ${goodsInfoPo.bgistealthclass != "8" ? '' : 'selected="selected"' }>塑形镜</option>
      	                   </select>
			               </TD>
			               <TD class="table_body" width="9%">产品可使用天数</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input100" type="text" value="${goodsInfoPo.bginumberofdays}" id="bginumberofdays" name="goodsInfoPo.bginumberofdays" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UINTOrNULL, 'Message' : '产品可使用天数必须为数字！'}]">
			               </TD>
                        </TR>
                        <TR>
				            <TD height="26" class="table_body">效期提醒上限</TD>
			               	<TD class="table_none"> 
                           		有效期前&nbsp;<input class="text_input60" id="bgireturnmax" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgireturnmax" value="${goodsInfoPo.bgireturnmax }" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(0);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '上限效期格式错误！'}]">&nbsp;天提醒进入滞销状态
                           	</td>
                           	<TD class="table_body">效期提醒下限</TD>
			               	<TD class="table_none">
                           		有效期前&nbsp;<input class="text_input60" id="bgireturnmin" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgireturnmin" value="${goodsInfoPo.bgireturnmin }" onblur="if(!isNaN(this.value)) {this.value = new Number(this.value).toFixed(0);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '下限效期格式错误！'}]">&nbsp;天提醒进入即将失效状态
                           	</TD>					   
			               <TD class="table_body">颜色</TD>
			               	<TD class="table_none">
			               	<select clean=clean id="bgichinesecolor"  name="goodsInfoPo.bgichinesecolor" >
			               	 <option value="">----请选择----</option>
			                 <s:iterator value="colorList">
				               <option value="${bcid}" ${goodsInfoPo.bgichinesecolor == bcid ? 'selected="selected"' : '' }>${bccolorname}</option>
	     	               	 </s:iterator>
	     	               	</select>
			               	</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;价&nbsp;格&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
              <c:if test="${(permissionPo.keyf==1)}">  
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">        
                       <TR>
                       <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>                         
                           <TD class="table_body" width="9%">爱尔结算价</TD>
			               <TD class="table_none" width="24%">
					            <c:if test="${(permissionPo.keyn!=1)}">  
					                ${goodsInfoPo.bgicostprice}&nbsp;
					                <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
					            </c:if>
					            <c:if test="${(permissionPo.keyn==1)}"> 
					                <input class="text_input100" clean=clean type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
					            </c:if>
			               </TD>
                           <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none">${goodsInfoPo.bgiwholesaleprice}&nbsp;
			               <input class="text_input100" type="hidden" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" maxlength="10" readonly="readonly"/>
			               </TD>
                        </TR>
                </c:if>
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">        
                       <TR>
                       <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>                         
                           <TD height="26" class="table_body" width="9%">爱尔结算价</TD>
			               <TD class="table_none" colspan="3">
					            <c:if test="${(permissionPo.keyn!=1)}">  
					                ${goodsInfoPo.bgicostprice}&nbsp;
					                <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
					            </c:if>
					            <c:if test="${(permissionPo.keyn==1)}"> 
					                <input class="text_input100" clean=clean type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
					            </c:if>
			               </TD>
                           <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
                        </TR>
                </c:if>
             </c:if>
             <c:if test="${(permissionPo.keyf!=1)}"> 
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">          
                        <tr>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>  
                           <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none" colspan="3">${goodsInfoPo.bgiwholesaleprice}&nbsp;
                           <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
			               <input class="text_input100" type="hidden" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" maxlength="10" readonly="readonly"/>
			               </TD>
                        </tr>
                 </c:if>
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">          
                        <tr>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" colspan="5">
                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>  
			               <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
			               <input class="text_input100" type="hidden" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" maxlength="10" readonly="readonly"/>
                        </tr>
                 </c:if>
             </c:if> 
                      </TBODY>
                    </TABLE>
                    <%@ include file="/commons/basic_retailPrices.jsp" %>
                    </fieldset>
                    
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                        	<img src="${ctx }/img/newbtn/btn_reset_0.png" btn=btn title='重置' onClick="clean()"> 
                          </TD>
						</TR>
						<tr>
						  	<td>
								<br>
								<br>
								接触镜镜片：<br>
								商品代码组成说明：<br>
								<IMG src="${ctx}/img/pic/yinxingjingpian.png" ><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品条码会根据商品代码自动生成。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品名称默认为选择的品种的名称，可以自行调整。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品编号用于区分相同制造商、品种、型号的商品。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">接触镜效期大于效期提醒上限。 （正常贮备期）</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">接触镜效期小于效期提醒上限并且大于下限。 （滞销退货期）</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">接触镜效期小于效期提醒下限并且大于过期时间。（即将失效期）</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">接触镜效期小于过期时间。（报废）  </font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">计量单位、使用种类、抛弃型分类、等选项是直接从品种信息中带入，同时可以填选。</font><br>
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