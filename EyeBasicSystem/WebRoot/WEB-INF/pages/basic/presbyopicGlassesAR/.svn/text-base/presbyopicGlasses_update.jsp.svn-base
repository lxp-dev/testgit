<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老花镜维护</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
	    return str.replace(/(^\s*)|(\s*$)/g, "");
	}

	function save(){
		if($('#bgisupplierspec').val()==''){
			alert("厂家型号不允许为空!");
			$('#bgisupplierspec').focus();
			$('#bgisupplierspec').select();
			return;
		}
		
		if(checkForm(document.all.presbyopicGlassesForm)){  
		    var bgitaxrate= parseInt(document.all.bgitaxrate.value);
		    if(bgitaxrate>100||bgitaxrate<=-1){
		      alert('税率必须在0-100之间');
		      document.all.bgitaxrate.focus();
		      return false;
		    }   
		    $("img").removeAttr("onclick");
			presbyopicGlassesForm.action = "updatePresbyopicGlassesAR.action";
			presbyopicGlassesForm.submit();
		}
	}
	$(document).ready(function(){
		$('#bgisph').attr('value','${goodsInfoPo.bgisph}');
	});
	
	function clean(){
		document.presbyopicGlassesForm.reset();
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
<form name="presbyopicGlassesForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}">
<input type="hidden" name="parent" id="parent" value="${parent}">
<DIV>
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
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">老花镜修改</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initGlassesFramePhotoUpdate.action?moduleID=${requestScope.moduleID}&goodsid=${goodsInfoPo.bgigoodsid}';"
                      UNSELECTABLE="on">图片上传</TD>
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
                    <br/>
                    <fieldset>
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsid}<input class="text_input200" type="hidden" id="bgigoodsid" name="goodsInfoPo.bgigoodsid" value="${goodsInfoPo.bgigoodsid}">
			               </TD>
			                <TD width="9%" class="table_body">商品条码</TD>
			               <TD width="24%" class="table_none">
                            ${goodsInfoPo.bgigoodsbarcode}<input class="text_input200" type="hidden" id="bgigoodsbarcode" name="goodsInfoPo.bgigoodsbarcode" value="${goodsInfoPo.bgigoodsbarcode}">
			               </TD>
			               <TD width="9%" class="table_body">商品名称</TD>
			               <TD class="table_none">
                             <input class="text_input200" type="text" id="bgigoodsname" name="goodsInfoPo.bgigoodsname" value="${goodsInfoPo.bgigoodsname}" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                        <TR>
                         <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">                             
                            ${goodsInfoPo.bgisuppliername}			               
			               </TD>	
                           <TD class="table_body">商品品种</TD>
			               <TD class="table_none">
                            ${goodsInfoPo.bgibrandname}
			               </TD>					  
			               <TD class="table_body">型号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgispec}
			               </TD>
                        </TR>
			             <TR>
			               <TD height="26" class="table_body">厂家色号</TD>
			               <TD class="table_none">
                             <input class="text_input160" type="text"  value="${goodsInfoPo.bgisuppliercolor}" id="bgisuppliercolor" name="goodsInfoPo.bgisuppliercolor" maxlength="30" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '厂家色号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '厂家色号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '厂家色号不能包含中文！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">计量单位</TD>
			               <TD class="table_none">
                            <select id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]">
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			              
                           		<TD class="table_body">老花镜度数</TD>
					        	<TD class="table_none">
									<select id="bgisph" name="goodsInfoPo.bgisph" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '老花镜度数不能为空！'}]">
										<option value="">----请选择----</option>
								<option value="+0.00" >+0.00</option>
								<option value="+0.25" >+0.25</option>
								<option value="+0.50" >+0.50</option>
								<option value="+0.75" >+0.75</option>
								<option value="+1.00" >+1.00</option>
								<option value="+1.25" >+1.25</option>
								<option value="+1.50" >+1.50</option>
								<option value="+1.75" >+1.75</option>
								<option value="+2.00" >+2.00</option>
								<option value="+2.25" >+2.25</option>
								<option value="+2.50" >+2.50</option>
								<option value="+2.75" >+2.75</option>
								<option value="+3.00" >+3.00</option>
								<option value="+3.25" >+3.25</option>
								<option value="+3.50" >+3.50</option>
								<option value="+3.75" >+3.75</option>
								<option value="+4.00" >+4.00</option>
								<option value="+4.25" >+4.25</option>
								<option value="+4.50" >+4.50</option>
								<option value="+4.75" >+4.75</option>
								<option value="+5.00" >+5.00</option>
								<option value="+5.25" >+5.25</option>
								<option value="+5.50" >+5.50</option>
								<option value="+5.75" >+5.75</option>
								<option value="+6.00" >+6.00</option>
								<option value="+6.25" >+6.25</option>
								<option value="+6.50" >+6.50</option>
								<option value="+6.75" >+6.75</option>
								<option value="+7.00" >+7.00</option>
								<option value="+7.25" >+7.25</option>
								<option value="+7.50" >+7.50</option>
								<option value="+7.75" >+7.75</option>
								<option value="+8.00" >+8.00</option>
								<option value="+8.25" >+8.25</option>
								<option value="+8.50" >+8.50</option>
								<option value="+8.75" >+8.75</option>
								<option value="+9.00" >+9.00</option>
								<option value="+9.25" >+9.25</option>
								<option value="+9.50" >+9.50</option>
								<option value="+9.75" >+9.75</option>
								<option value="+10.00" >+10.00</option>
								<option value="+10.25" >+10.25</option>
								<option value="+10.50" >+10.50</option>
								<option value="+10.75" >+10.75</option>
								<option value="+11.00" >+11.00</option>
								<option value="+11.25" >+11.25</option>
								<option value="+11.50" >+11.50</option>
								<option value="+11.75" >+11.75</option>
								<option value="+12.00" >+12.00</option>
								<option value="+12.25" >+12.25</option>
								<option value="+12.50" >+12.50</option>
								<option value="+12.75" >+12.75</option>
								<option value="+13.00" >+13.00</option>
								<option value="+13.25" >+13.25</option>
								<option value="+13.50" >+13.50</option>
								<option value="+13.75" >+13.75</option>
								<option value="+14.00" >+14.00</option>
								<option value="+14.25" >+14.25</option>
								<option value="+14.50" >+14.50</option>
								<option value="+14.75" >+14.75</option>
								<option value="+15.00" >+15.00</option>
								<option value="+15.25" >+15.25</option>
								<option value="+15.50" >+15.50</option>
								<option value="+15.75" >+15.75</option>
								<option value="+16.00" >+16.00</option>
								<option value="+16.25" >+16.25</option>
								<option value="+16.50" >+16.50</option>
								<option value="+16.75" >+16.75</option>
								<option value="+17.00" >+17.00</option>
								<option value="+17.25" >+17.25</option>
								<option value="+17.50" >+17.50</option>
								<option value="+17.75" >+17.75</option>
								<option value="+18.00" >+18.00</option>
								<option value="+18.25" >+18.25</option>
								<option value="+18.50" >+18.50</option>
								<option value="+18.75" >+18.75</option>
								<option value="+19.00" >+19.00</option>
								<option value="+19.25" >+19.25</option>
								<option value="+19.50" >+19.50</option>
								<option value="+19.75" >+19.75</option>
								<option value="+20.00" >+20.00</option>
					       		   </select><label style="color:red;">&nbsp;*</label>
								</TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <tr>
                           <TD height="26" class="table_body">厂家型号</TD>
			               <TD class="table_none">
			               		<input class="text_input100" type="text"   id="bgisupplierspec" value="${goodsInfoPo.bgisupplierspec}"  name="goodsInfoPo.bgisupplierspec" maxlength="30"><label style="color:red;">&nbsp;*</label>
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
	      	               <TD class="table_body">批号管理</TD>
			               <td align="left" class="table_none">
			               		<input type="radio" id="bgibarcodeflagid1" name="goodsInfoPo.bgibarcodeflag" value="1" ${goodsInfoPo.bgibarcodeflag eq '1' ? 'checked="checked"' : '' } />是<input type="radio" id="bgibarcodeflagid2" name="goodsInfoPo.bgibarcodeflag" value="0" ${goodsInfoPo.bgibarcodeflag ne '1' ? 'checked="checked"' : '' } />否<label style="color:red;">&nbsp;*</label>
                           </td>                           
                        </TR>
                        </c:if>
                        <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
                        <tr>
                           <TD height="26" class="table_body">厂家型号</TD>
			               <TD class="table_none">
			               		<input class="text_input100" type="text"   id="bgisupplierspec" value="${goodsInfoPo.bgisupplierspec}"  name="goodsInfoPo.bgisupplierspec" maxlength="30"><label style="color:red;">&nbsp;*</label>
			               		<input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="${defaultdiscountvalue }">
			               </TD>
	      	               <TD class="table_body">批号管理</TD>
			               <td align="left" class="table_none" colspan="3">
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
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;非&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD height="26" class="table_body" width="9%">镜架尺寸</TD>
			              <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\w\d]/g,'')" id="bgiframesize" value="${goodsInfoPo.bgiframesize}" name="goodsInfoPo.bgiframesize"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.WordNull, 'Message' : '镜架尺寸只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.NO_CNORNULL, 'Message' : '镜架尺寸不能包含中文！'}]">
			              </TD>
			              <TD class="table_body" width="9%">颜色</TD>
			               <TD class="table_none">
			               	<select id="bgichinesecolor"  name="goodsInfoPo.bgichinesecolor" >
			               	 <option value="">----请选择----</option>
			                 <s:iterator value="colorList">
				               <option value="${bcid}" ${goodsInfoPo.bgichinesecolor == bcid ? 'selected="selected"' : '' }>${bccolorname}</option>
	     	               	 </s:iterator>
	     	               	</select>
			               </TD>
			               <TD height="26" class="table_body">款式</TD>
			               	<TD class="table_none">
			               	<select id="bgiframestyle" clean=clean name="goodsInfoPo.bgiframestyle" >
			               	 <option value="">----请选择----</option>
			                 	<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                              <c:if test="${optionParamPoTmp.fopparentid=='ks'}">
	                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgiframestyle == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
	                              </c:if>	                                      	
                                </c:forEach>
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
			            </tr>
                  </c:if>
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">        
                       <TR>   
                       	   <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>                    
                           <TD class="table_body" width="9%">爱尔结算价</TD>
			               <TD class="table_none" colspan="3">
					            <c:if test="${(permissionPo.keyn!=1)}">  
					                ${goodsInfoPo.bgicostprice}&nbsp;
					                <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
					            </c:if>
					            <c:if test="${(permissionPo.keyn==1)}"> 
					                <input class="text_input100" clean=clean type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
					            </c:if>
			               </TD>
			               <input class="text_input100" type="hidden" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" maxlength="10" readonly="readonly"/>
			            </tr>
                  </c:if>
             </c:if>
             <c:if test="${(permissionPo.keyf!=1)}">  
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}"> 
             			<TR>   
                       	   <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD> 
                           <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none" colspan="3">${goodsInfoPo.bgiwholesaleprice}&nbsp;
			               <input class="text_input100" type="hidden" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" maxlength="10" readonly="readonly"/>
			               </TD>
			            </TR>
			               <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
			      </c:if>
				<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}"> 
             			<TR>   
                       	   <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" colspan="5">
                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD> 
			            </TR>
			               <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
			               <input class="text_input100" type="hidden" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" maxlength="10" readonly="readonly"/>
			      </c:if>
             </c:if>
                      </TBODY>
                    </TABLE>
                    <%@ include file="/commons/basic_retailPrices.jsp" %>
                    </fieldset>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
<img src="${ctx }/img/newbtn/btn_reset_0.png" btn=btn title='重置' onClick="clean()"> 
                          </TD>
						  </TR>
						    <tr>
						  	<td>
								<br>
								<br>
								老花镜：<br>
								商品代码组成说明：<br>
								<IMG src="${ctx}/img/pic/laohuajing.png" ><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品条码会根据商品代码自动生成。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品名称默认为选择的品种的名称，可以自行调整。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">型号通常是写在镜腿上的规格号。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">厂家色号镜架的颜色号。</font><br>
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
<script>
	if(document.all.bgisph!=null){
		var index_bgisph = 0;
		var arr = document.all.bgisph.options.length;
		for(i=0;i<arr;i++){
			if(document.all.bgisph.options.options[i].value == '<c:out value="${goodsInfoPo.bgisph}"/>'){
				document.all.bgisph.options.selectedIndex = index_bgisph;
				break;
			}
			index_bgisph++;
		}
	}
</script>