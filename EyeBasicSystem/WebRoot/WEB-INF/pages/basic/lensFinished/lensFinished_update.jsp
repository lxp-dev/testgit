<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成品镜片维护</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
　　 	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }
	function save(){
		if(checkForm(document.all.lensFinishedForm)){  
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
		    
		    $("img").removeAttr("onclick");
			lensFinishedForm.action = "updateLensFinished.action";
			lensFinishedForm.submit();
		}
	}
	$(document).ready(function(){
		$('#bgisph').attr('value','${goodsInfoPo.bgisph}');
	});
	
	function clean(){
		document.lensFinishedForm.reset();
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
<form name="lensFinishedForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />

<input type="hidden" name="type" id="type" value="" /> 
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
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
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
                           ${goodsInfoPo.bgisuppliername}&nbsp;	               
			               </TD>
                           <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           ${goodsInfoPo.bgibrandname}&nbsp;
			               </TD>
			               <TD height="26" class="table_body">商品编号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgicolor}
			               </TD> 
                        </TR>
                        <TR>
			              <TD height="26" class="table_body">计量单位</TD>
			               <TD class="table_none">
                            <select id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]"  >
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">球镜</TD>
			               <TD class="table_none">
                           <select disabled="disabled" id="bgisph" name="goodsInfoPo.bgisph" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜不能为空！'}]">
      		                 		<option value="">----请选择----</option>
									<c:forEach var="x" begin="1" end="205" step="1" varStatus="index">
			               				<c:set var="lens" value="${20.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisph + 0 != lens ? '' : 'selected="selected"'}>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   </select> 
			               </TD>
                          <TD class="table_body">柱镜</TD>
			               <TD class="table_none">
                            <c:if test="${systemParameterPo.fspnegative==1}">
                           <select id="bgicyl" disabled="disabled" name="goodsInfoPo.bgicyl" onChange="getGoodsID('bgicyl',document.all.bgicyl.value);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="49" step="1" varStatus="index">
		               				<c:set var="lens" value="${6.00 - (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicyl + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select><label style="color:red;">&nbsp;*</label>
      	                   </c:if>
      	                   <c:if test="${systemParameterPo.fspnegative!=1}">
                           <select id="bgicyl" disabled="disabled" name="goodsInfoPo.bgicyl" onChange="getGoodsID('bgicyl',document.all.bgicyl.value);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="25" step="1" varStatus="index">
		               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicyl + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select><label style="color:red;">&nbsp;*</label>
      	                   </c:if>
			               </TD>
			            </TR>
			            <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <tr>
                           <TD height="26" class="table_body">下加光</TD>
			               <TD class="table_none">
			               		<select id="bgibelowplusluminosity" name="goodsInfoPo.bgibelowplusluminosity" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '下加光不能为空！'}]">
                            		 <option value="">----请选择----</option>
                            		<c:forEach var="x" begin="1" end="41" step="1" varStatus="index">
		               					<c:set var="lens1" value="${0.00 + (0.25 * (index.index - 1))}" />
										<option value="<fmt:formatNumber value="${lens1 }" pattern="0.00"/>" ${goodsInfoPo.bgibelowplusluminosity + 0 != lens1 ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens1 }" pattern="0.00"/></option>
		               				</c:forEach>
                           		</select>
                             <label style="color:red;">&nbsp;*</label> </TD>
			                 <TD class="table_body">材料分类</TD>
			                 <TD class="table_none">
			               		<select id="bgieyeglassmaterialtype"  name="goodsInfoPo.bgieyeglassmaterialtype">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgieyeglassmaterialtype != "1" ? '' : 'selected="selected"' }>树脂</option>
			               			<option value="2" ${goodsInfoPo.bgieyeglassmaterialtype != "2" ? '' : 'selected="selected"' }>玻璃</option>
			               			<option value="3" ${goodsInfoPo.bgieyeglassmaterialtype != "3" ? '' : 'selected="selected"' }>PC</option>
			               		</select>
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
							<TR>
	      	               		<TD height="26" class="table_body">批号管理</TD>
			               		<td align="left" class="table_none" colspan="5">
			               		<input type="radio" id="bgibarcodeflagid1" name="goodsInfoPo.bgibarcodeflag" value="1" ${goodsInfoPo.bgibarcodeflag eq '1' ? 'checked="checked"' : '' } />是<input type="radio" id="bgibarcodeflagid2" name="goodsInfoPo.bgibarcodeflag" value="0" ${goodsInfoPo.bgibarcodeflag ne '1' ? 'checked="checked"' : '' } />否<label style="color:red;">&nbsp;*</label>
                           		</td> 
							</TR>                        
                        </c:if>
                        <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
                        <tr>
                           <TD height="26" class="table_body">下加光</TD>
			               <TD class="table_none">
			               <select id="bgibelowplusluminosity" name="goodsInfoPo.bgibelowplusluminosity" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '下加光不能为空！'}]">
                            		 <option value="">----请选择----</option>
                            		 <c:forEach var="x" begin="1" end="41" step="1" varStatus="index">
		               				<c:set var="lens1" value="${0.00 + (0.25 * (index.index - 1))}" />
									<option value="<fmt:formatNumber value="${lens1 }" pattern="0.00"/>" ${goodsInfoPo.bgibelowplusluminosity + 0 != lens1 ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens1 }" pattern="0.00"/></option>
		               			</c:forEach>
                                    	</select>
                             <label style="color:red;">&nbsp;*</label> </TD>
			                 <TD class="table_body">材料分类</TD>
			                 <TD class="table_none">
			               		<select id="bgieyeglassmaterialtype"  name="goodsInfoPo.bgieyeglassmaterialtype">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgieyeglassmaterialtype != "1" ? '' : 'selected="selected"' }>树脂</option>
			               			<option value="2" ${goodsInfoPo.bgieyeglassmaterialtype != "2" ? '' : 'selected="selected"' }>玻璃</option>
			               			<option value="3" ${goodsInfoPo.bgieyeglassmaterialtype != "3" ? '' : 'selected="selected"' }>PC</option>
			               		</select>
			               		<input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="${goodsInfoPo.bgidefaultdiscountvalue}">
			                 </TD>
	      	               		<TD class="table_body">批号管理</TD>
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
					<legend><font style="font-size: 14;font: bold">&nbsp;&nbsp;非&nbsp;必&nbsp;填&nbsp;项&nbsp;&nbsp;</font></legend>
                    <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			                <TD height="26" class="table_body" width="9%">光度分类</TD>
			                <TD class="table_none" width="24%">
	                          <select id="bgiismutiluminosity" name="goodsInfoPo.bgiismutiluminosity" onchange="changeMutiluminosity();">
		                          <option value="">----请选择----</option>
	                              <option value="0" ${goodsInfoPo.bgiismutiluminosity != "0" ? '' : 'selected="selected"' }>单光</option>
	                              <option value="M" ${goodsInfoPo.bgiismutiluminosity != "M" ? '' : 'selected="selected"' }>多光</option>
	                              <option value="J" ${goodsInfoPo.bgiismutiluminosity != "J" ? '' : 'selected="selected"' }>渐进</option>
	                              <option value="K" ${goodsInfoPo.bgiismutiluminosity != "K" ? '' : 'selected="selected"' }>抗疲劳</option>
	                              <option value="Q" ${goodsInfoPo.bgiismutiluminosity != "Q" ? '' : 'selected="selected"' }>其它</option>
                           	  </select>
			                </TD>
			                <TD class="table_body" width="9%">渐进片分类</TD>
			                <TD class="table_none" width="24%">
			               		<select id="bgigradualclass" name="goodsInfoPo.bgigradualclass">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgigradualclass != "1" ? '' : 'selected="selected"' }>青少年渐进</option>
			               			<option value="2" ${goodsInfoPo.bgigradualclass != "2" ? '' : 'selected="selected"' }>成人渐进</option>
			               		</select>
			                </TD>
	                       	<TD class="table_body" width="9%">折射率</TD>
	                        <TD class="table_none">
	                            <select clean=clean id="bgirefractive"  name="goodsInfoPo.bgirefractive" >
	      		                 <option value="">----请选择----</option>
	      		                   <s:iterator value="refractiveSetList">
					               <option value="${brfname}" ${goodsInfoPo.bgirefractive == brfname ? 'selected="selected"' : '' }>${brfname}</option>
		     	                   </s:iterator>
	      	                   </select>
	      	                </TD>	
			            </tr>
                        <TR>
                         	 <TD height="26" class="table_body">镜片功能</TD>
			                 <TD class="table_none" colspan="5">
                           	 	<select id="bgifunctionclass" clean=clean name="goodsInfoPo.bgifunctionclass">
                                   <option value="" selected>---请选择---</option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='gn'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgifunctionclass == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
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
                    <table width="99%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
              <c:if test="${(permissionPo.keyf==1)}">  
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                        <TR>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">含税单价</TD>
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
			               <TD class="table_none" width="24%" >${goodsInfoPo.bgiwholesaleprice}&nbsp;
                             <input class="text_input100" type="hidden" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10">
			               </TD>
                        </TR>
                    </c:if>
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
                        <TR>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">含税单价</TD>
			                 <TD class="table_none" colspan="3">
				               	<c:if test="${(permissionPo.keyn!=1)}">  
					                ${goodsInfoPo.bgicostprice}&nbsp;
					                <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
					            </c:if>
					            <c:if test="${(permissionPo.keyn==1)}"> 
					                <input class="text_input100" clean=clean type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')"  value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"  maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
					            </c:if>
			                 </TD>
                        </TR>
                    </c:if>
             </c:if>
             <c:if test="${(permissionPo.keyf!=1)}">  
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">  
                      <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                        <TR>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none" colspan="3" >${goodsInfoPo.bgiwholesaleprice}&nbsp;
                             <input class="text_input100" type="hidden" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10">
			               </TD>
                        </TR>
                    </c:if>
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">  
                      <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                      <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
                        <TR>
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" colspan="5">
                             <input class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
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
							<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                        	  <img src="${ctx }/img/newbtn/btn_reset_0.png" btn=btn title='重置' onClick="clean()"> 
                          </TD>
						  </TR>
						  <tr>
						  	<td>
								<br>
								<br>
								成品镜片:<br>
								商品代码组成说明：<br>
								<IMG src="${ctx}/img/pic/jingpian.png" ><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品条码会根据商品代码自动生成。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">商品名称默认为选择的品种的名称，可以自行调整。</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">计量单位、光度分类、折射率、镜片功能等选项是直接从品种信息中带入，同时可以自行调整。</font><br>
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