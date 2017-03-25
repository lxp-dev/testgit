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

	function save(){
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
		lensCustomForm.action = "updateLensCustom.action";
		lensCustomForm.submit();
		}
	}

	
		
	$(document).ready(function(){
		$('#bgisphup').attr("value",'${goodsInfoPo.bgisphup}');
		$('#bgisphul').attr("value",'${goodsInfoPo.bgisphul}');
	});
	
	function clean(){
		document.lensCustomForm.reset();
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
<form name="lensCustomForm" method="post" action="">
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
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="7%" height="26" class="table_body">商品代码</TD>
			               <TD width="27%" class="table_none">
                            ${goodsInfoPo.bgigoodsid}<input class="text_input200" type="hidden" id="bgigoodsid" name="goodsInfoPo.bgigoodsid" value="${goodsInfoPo.bgigoodsid}">
			               </TD>
			               <TD width="7%" class="table_body">商品条码</TD>
			               <TD width="27%" class="table_none">
                            ${goodsInfoPo.bgigoodsbarcode}<input class="text_input200" type="hidden" id="bgigoodsbarcode" name="goodsInfoPo.bgigoodsbarcode" value="${goodsInfoPo.bgigoodsbarcode}">
			               </TD>
			               <TD width="7%" class="table_body">商品名称</TD>
			               <TD class="table_none">
                             <input class="text_input200" type="text" id="bgigoodsname" name="goodsInfoPo.bgigoodsname" value="${goodsInfoPo.bgigoodsname}" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">                             
                           ${goodsInfoPo.bgisuppliername}		               
			               </TD>
                           <TD class="table_body">商品品种</TD>
			               <TD class="table_none">
                           ${goodsInfoPo.bgibrandname}&nbsp;
			               </TD>
			               <TD class="table_body">型号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgispec}&nbsp;
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">商品编号</TD>
			               <TD class="table_none">
                             ${goodsInfoPo.bgicolor}&nbsp;
			               </TD>
			               <TD class="table_body">计量单位</TD>
			               <TD class="table_none" colspan="3">
                            <select id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]" >
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			            </TR>
                        <TR>
                           <TD class="table_body">球镜</TD>
			               <TD class="table_none">
	                             <select id="bgisphup" name="goodsInfoPo.bgisphup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜下限不能为空！'}]">
      		                 		<option value="">---请选择---</option>
      		                 		<c:forEach var="x" begin="1" end="249" step="1" varStatus="index">
			               				<c:set var="lens" value="${31.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisphup + 0 != lens ? '' : 'selected="selected"'}>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select>
      	                   		 -
      	                   		 <select id="bgisphul" name="goodsInfoPo.bgisphul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜上限不能为空！'}]">
      		                 		<option value="">---请选择---</option>
      		                 		<c:forEach var="x" begin="1" end="249" step="1" varStatus="index">
			               				<c:set var="lens" value="${31.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisphul + 0 != lens ? '' : 'selected="selected"'}>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
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
						   <TD class="table_body" height="26">柱镜</TD>
			               <TD class="table_none">
      	                   		 <select id="bgicylup" name="goodsInfoPo.bgicylup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜下限不能为空！'}]">
      		                 		<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="41" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens }" ${goodsInfoPo.bgicylup + 0 != lens ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select>
      	                   		 -
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
						   <TD class="table_body">下加光</TD>
			               <TD class="table_none">
								 <select id="bgibelowplusluminosityup" name="goodsInfoPo.bgibelowplusluminosityup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '下加光下限不能为空！'}]">
      		                 		<option value="">---请选择---</option>
      		                 		<option value="0.00" ${goodsInfoPo.bgibelowplusluminosityup!='0.00'?'':'selected="selected"'}>0.00</option>
      		                 		<c:forEach var="x" begin="2" end="17" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 + (0.25 * (index.index - 1))}" />
										<option value="${lens!=0?'+':'' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${ goodsInfoPo.bgibelowplusluminosityup+0 != lens ? '' : 'selected="selected"' }>${lens!=0?'+':'' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select>
      	                   		 -
      	                   		 <select id="bgibelowplusluminosityul" name="goodsInfoPo.bgibelowplusluminosityul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '下加光上限不能为空！'}]">
      		                 		<option value="">---请选择---</option>
      		                 		<option value="0.00" ${goodsInfoPo.bgibelowplusluminosityul!='0.00'?'':'selected="selected"'}>0.00</option>
      		                 		<c:forEach var="x" begin="2" end="17" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 + (0.25 * (index.index - 1))}" />
										<option value="${lens!=0?'+':'' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgibelowplusluminosityul+0 != lens ? '' : 'selected="selected"' }>${lens!=0?'+':'' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   		 </select>
      	                   		 <label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                        <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                        <TR>
                        	<TD class="table_body">轴位</TD>
			                <TD class="table_none">
			                	<input class="text_input100" type="text" id="bgiaxis" name="goodsInfoPo.bgiaxis" value="${goodsInfoPo.bgiaxis }" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '轴位不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '轴位不能大于10字符'}]"><label style="color:red;">&nbsp;*</label>
			                </TD>
			               	<TD height="26" class="table_body">材料分类</TD>
			                <TD class="table_none" >
			               		<select id="bgieyeglassmaterialtype"  name="goodsInfoPo.bgieyeglassmaterialtype" >
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgieyeglassmaterialtype != "1" ? '' : 'selected="selected"' }>树脂</option>
			               			<option value="2" ${goodsInfoPo.bgieyeglassmaterialtype != "2" ? '' : 'selected="selected"' }>玻璃</option>
			               			<option value="3" ${goodsInfoPo.bgieyeglassmaterialtype != "3" ? '' : 'selected="selected"' }>PC</option>
			               		</select>
			                </TD>
			                 <TD class="table_body">订做周期</TD>
			                 <TD class="table_none">
	                         	<input class="text_input80" type="text" id="bgiordercycle" name="goodsInfoPo.bgiordercycle" value="${goodsInfoPo.bgiordercycle}" maxlength="5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订做周期不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '订做周期应为数字！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '订做周期只允许输入正整数！'}]">天<label style="color:red;">&nbsp;*</label>
			                 </TD>
			             </TR>
                        <TR>
			                 <TD class="table_body">商品级别</TD>
			               	 <td align="left" class="table_none" colspan="3">
			                	<select id="bgidefaultdiscountvalue" name="goodsInfoPo.bgidefaultdiscountvalue">
			                		<option value="">---请选择---</option>
			                		<s:iterator value="selectGoodsLevelList">
						               	<option value="${bgluuid}" ${goodsInfoPo.bgidefaultdiscountvalue eq bgluuid ? 'selected="selected"' : '' }>${bglname}</option>
			     	                </s:iterator>
			                	</select>
                           	 </td>
                        </TR>
                        </c:if>
                        <c:if test="${systemParameterPo.fspisusegoodslevel ne '1'}">
                        <TR>
                        	<TD class="table_body">轴位</TD>
			                <TD class="table_none"> 
			                	<input class="text_input100" type="text" id="bgiaxis" name="goodsInfoPo.bgiaxis" value="${goodsInfoPo.bgiaxis }" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '轴位不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [11]}, 'Message' : '轴位不能大于10字符'}]"><label style="color:red;">&nbsp;*</label>
			                </TD>
			               	<TD height="26" class="table_body">材料分类</TD>
			                <TD class="table_none" >
			               		<select id="bgieyeglassmaterialtype"  name="goodsInfoPo.bgieyeglassmaterialtype" >
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgieyeglassmaterialtype != "1" ? '' : 'selected="selected"' }>树脂</option>
			               			<option value="2" ${goodsInfoPo.bgieyeglassmaterialtype != "2" ? '' : 'selected="selected"' }>玻璃</option>
			               			<option value="3" ${goodsInfoPo.bgieyeglassmaterialtype != "3" ? '' : 'selected="selected"' }>PC</option>
			               		</select>
			                </TD>
			                 <TD class="table_body">订做周期</TD>
			                 <TD class="table_none">
	                         	<input class="text_input80" type="text" id="bgiordercycle" name="goodsInfoPo.bgiordercycle" value="${goodsInfoPo.bgiordercycle}" maxlength="5" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '订做周期不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '订做周期应为数字！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '订做周期只允许输入正整数！'}]">天<label style="color:red;">&nbsp;*</label>
			                 	<input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="1.00" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写商品默认折扣！'},{'Type' : Type.String, 'Formula' : Formula.UDiscount, 'Message' : '请重新填写的商品默认折扣！'}]">
			                 </TD>
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
			               	<TD height="26" class="table_body" width="9%">镜片种类</TD>
			               	<TD class="table_none" width="24%">
	                          <select id="bgiismutiluminosity"  name="goodsInfoPo.bgiismutiluminosity" onchange="changeMutiluminosity();">
                              <option value="0" ${goodsInfoPo.bgiismutiluminosity != '0' ? '' : 'selected="selected"' }>单光</option>
                              <option value="M" ${goodsInfoPo.bgiismutiluminosity != 'M' ? '' : 'selected="selected"' }>多光</option>
                              <option value="J" ${goodsInfoPo.bgiismutiluminosity != 'J' ? '' : 'selected="selected"' }>渐进</option>
                              <option value="K" ${goodsInfoPo.bgiismutiluminosity != 'K' ? '' : 'selected="selected"' }>抗疲劳</option>
                              <option value="Q" ${goodsInfoPo.bgiismutiluminosity != 'Q' ? '' : 'selected="selected"' }>其它</option>
                              </select>
			               	</TD>
			                <TD class="table_body" width="9%">渐进片分类</TD>
			                <TD class="table_none" width="24%">
			               		<select id="bgigradualclass"  name="goodsInfoPo.bgigradualclass">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgigradualclass != "1" ? '' : 'selected="selected"' }>青少年渐进</option>
			               			<option value="2" ${goodsInfoPo.bgigradualclass != "2" ? '' : 'selected="selected"' }>成人渐进</option>
			               		</select>
			                </TD>
                        	<TD height="26" class="table_body" width="9%">折射率</TD>
                        	<TD class="table_none">
                            <select clean=clean id="bgirefractive"  name="goodsInfoPo.bgirefractive" >
      		                 <option value="">----请选择----</option>
      		                    <s:iterator value="refractiveSetList">
				               <option value="${brfname}" ${goodsInfoPo.bgirefractive == brfname ? 'selected="selected"' : '' }>${brfname}</option>
	     	                   </s:iterator>
      	                     </select>
      	                	</TD>	
      	               	</TR> 
                        <TR>  
						   <TD height="26" class="table_body">镜片功能</TD>
			               <TD class="table_none">
                           	  <select id="bgifunctionclass" clean=clean name="goodsInfoPo.bgifunctionclass">
                                   <option value="" selected>---请选择---</option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='gn'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(goodsInfoPo.bgifunctionclass == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                             	</select>
			               </TD>
			               <TD class="table_body">联合光度</TD>
			               <TD class="table_none">
	                          <input clean=clean class="text_input80" type="text" id="bgiunionsphcyl" name="goodsInfoPo.bgiunionsphcyl" value="${goodsInfoPo.bgiunionsphcyl}" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '联合光度只允许输入正数！'}]">
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
			                  <c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">         
			                       <TR>
			                       	   <TD height="26" class="table_body" width="9%">税率</TD>
						               <TD class="table_none" width="24%">
			                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
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
						               <TD class="table_none">${goodsInfoPo.bgiwholesaleprice}&nbsp;
						               <input class="text_input100" type="hidden" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" maxlength="10" readonly="readonly"/>
						               </TD>
			                        </TR>
			                 </c:if>
			                 <c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">         
			                       <TR>
			                       <TD height="26" class="table_body">税率</TD>
						               <TD class="table_none">
			                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
						               </TD>                         
			                           <TD class="table_body">含税单价</TD>
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
			                        <tr>
			                           <TD height="26" class="table_body" width="9%">税率</TD>
						               <TD class="table_none" colspan="5">
			                             <input class="text_input100" type="text" id="bgitaxrate" onKeyUp="value=value.replace(/[^\d\.]/g,'')" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate}" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
						               </TD> 
						               <input class="text_input100" type="hidden" id="bgicostprice" name="goodsInfoPo.bgicostprice" value="${goodsInfoPo.bgicostprice}" maxlength="10" readonly="readonly"/>
						               <input class="text_input100" type="hidden" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" maxlength="10" readonly="readonly"/>
			                        </tr>
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