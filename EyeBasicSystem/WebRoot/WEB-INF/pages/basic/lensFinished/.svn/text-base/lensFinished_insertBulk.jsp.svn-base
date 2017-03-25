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

	function getGoodsID(name,value){
      if(name=='supplier'){
         var goodsID1=goodsID.substring(0,2);
         var goodsID2=goodsID.substring(4,22);
         goodsID=goodsID1+value+goodsID2;
      }else if(name=='brand'){
         var goodsID1=goodsID.substring(0,5);
         var goodsID2=goodsID.substring(7,22);
         goodsID=goodsID1+value+goodsID2;
      }else if(name=='spec'){
         if(value.length>9){
           alert('规格不能大于9字符');
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
         }
      }else if(name=='color'){
         if(value.length>10){
	           alert('商品编码不能大于10字符');
	           document.getElementById('bgicolor').value='';
	           return false;
	         }
      	 }
	}
	
	function save(){
		//柱镜
		var bgicylspan = document.getElementById("bgicylspan").value;
		//如果跨度等于 0 不验证下线
		var bgicylupValidate = document.getElementById("bgicylup").validate;
		if (bgicylspan == 0){
			document.getElementById("bgicylup").validate = "";
		}	
		
		//球镜
		var bgisphspan = document.getElementById("bgisphspan").value;
		//如果跨度等于 0 不验证下线
		var bgisphupValidate = document.getElementById("bgisphup").validate;
		if (bgisphspan == 0){
			document.getElementById("bgisphup").validate = "";
		}
		
		if(checkForm(document.all.stealthFinishedForm)){  
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
	    
	    document.all.submitButton.disabled="true";
		stealthFinishedForm.action = "insertBulkLensFinished.action?moduleID=${requestScope.moduleID}";
		stealthFinishedForm.submit();
		}else{
			document.getElementById("bgicylup").validate = bgicylupValidate;
			document.getElementById("bgisphup").validate = bgisphupValidate;
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
        $('#bgiismutiluminosity').val("");
        $('#bgigradualclass').val("");
        $('#bgifunctionclass').val("");
		
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
		$("input[clean=clean][noclean!=noclean]").val('');
		$("input[cleans=cleans]").val('17');
		$("input[cleanbm=cleanbm]").val('0000');
		$("select[clean=clean]").val('');
		$("#bgisphul").val('0.00');
		$("#bgisphup").val('0.00');
		$("#bgicylul").val('0.00');
		$("#bgicylup").val('0.00');
		$("#bgisphspan").val('0.00');
		$("#bgicylspan").val('0.00');
		$("#bgibelowplusluminosity").val('0.00');
	
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

		if(json.bbdbarcodeflag=="1"){
			document.getElementById('bgibarcodeflagid1').checked="checked";
		}else{
			document.getElementById('bgibarcodeflagid2').checked="checked";
		}
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		$("#bgigradualclass").hide();
		
		if($("#bgiismutiluminosity").val() == 'J'){
			$("#bgigradualclass").show();
		}else{
			$("#bgigradualclass").hide();
		}
	});
	
	function clean(){
		$("input[clean=clean]").val('');
		$("input[cleans=cleans]").val('17');
		$("input[cleanbm=cleanbm]").val('0000');
		$("select[clean=clean]").val('');
		$("#bgisphul").val('0.00');
		$("#bgisphup").val('0.00');
		$("#bgicylul").val('0.00');
		$("#bgicylup").val('0.00');
		$("#bgisphspan").val('0.00');
		$("#bgicylspan").val('0.00');
		$("#bgibelowplusluminosity").val('0.00');
	}
	
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
<form name="stealthFinishedForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="type" id="moduleID" value="${requestScope.moduleID}" /> 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
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
			               <TD height="26" class="table_body" width="9%">商品名称</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input200"  clean=clean type="text" id="bgigoodsname" name="goodsInfoPo.bgigoodsname" value="${goodsInfoPo.bgigoodsname }" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">制造商</TD>
			               <TD class="table_none" width="24%">                             
			               		<c:if test="${person.syspsupplierid ne ''}">
							   		<li class="horizontal_onlyRight">
							   		${person.syspsuppliername }
							   		<input type="hidden" id="bgisupplierid" name="goodsInfoPo.bgisupplierid" value="${person.syspsupplierid }" />
							   	</li>
							   	</c:if>
							   	<c:if test="${person.syspsupplierid eq ''}">
							   		<li class="horizontal_onlyRight">
								   		<input id="bgisuppliername" clean=clean noclean=noclean class="text_input160"  value="${goodsInfoPo.bgisuppliername}" name="goodsInfoPo.bgisuppliername"  readonly="readonly" />
								   		<input type="hidden" id="bgisupplierid" noclean=noclean clean=clean  value="${goodsInfoPo.bgisupplierid}" name="goodsInfoPo.bgisupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
								   	</li>
								   	<li class="horizontal_onlyRight">
								    <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
								    </li><label style="color:red;">&nbsp;*</label>
							   	</c:if>		               
			               </TD>
			               <TD class="table_body" width="9%">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input id="bgibrandname" clean=clean class="text_input200" name="goodsInfoPo.bgibrandname" value="${goodsInfoPo.bgibrandname }" readonly="readonly"/>
						   		<input type="hidden" clean=clean id="bgibrandid" name="goodsInfoPo.bgibrandid" value="${goodsInfoPo.bgibrandid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属品种不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						  </li><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">商品编号</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input100" type="text" id="bgicolor" value="${goodsInfoPo.bgicolor}" name="goodsInfoPo.bgicolor" onkeyup="value=value.replace(/[^\w\d]/g,'');" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品编号不能为空！'},
{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '商品编号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '商品编号不能包含中文！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">计量单位</TD>
			               <TD class="table_none" >
                            <select clean=clean id="bgiunitid" name="goodsInfoPo.bgiunitid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]">
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select>
      	                    <label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">材料分类</TD>
			                 <TD  class="table_none">
			               		<select clean=clean id="bgieyeglassmaterialtype" name="goodsInfoPo.bgieyeglassmaterialtype">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgieyeglassmaterialtype != "1" ? '' : 'selected="selected"' }>树脂</option>
			               			<option value="2" ${goodsInfoPo.bgieyeglassmaterialtype != "2" ? '' : 'selected="selected"' }>玻璃</option>
			               			<option value="3" ${goodsInfoPo.bgieyeglassmaterialtype != "3" ? '' : 'selected="selected"' }>PC</option>
			               		</select><label style="color:red;">&nbsp;*</label>
			                 </TD>
                        </TR>
						<tr>
			               <TD height="26" class="table_body">球镜</TD>
			               <TD class="table_none" colspan="3">上限
                           <select id="bgisphul" name="goodsInfoPo.bgisphul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜上限不能为空！'}]">
      		                 		<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="205" step="1" varStatus="index">
			               				<c:set var="lens" value="${-20.00 + (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisphul + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   </select>&nbsp;下限
      	                   <select id="bgisphup" name="goodsInfoPo.bgisphup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜下限不能为空！'}]">
      		                 		<option value="">----请选择----</option>
									<c:forEach var="x" begin="1" end="205" step="1" varStatus="index">
			               				<c:set var="lens" value="${-20.00 + (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgisphup + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
      	                   </select> 跨度
      	                	<select id="bgisphspan" name="goodsInfoPo.bgisphspan" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '跨度不能为空！'}]">
									<option value="0.00" >0.00</option>
									<option value="0.25" >0.25</option>
									<option value="0.50" >0.50</option>
									<option value="0.75" >0.75</option>
									<option value="1.00" >1.00</option>

      	                   </select><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">下加光</TD>
			               <TD class="table_none">
			               <select id="bgibelowplusluminosity" name="goodsInfoPo.bgibelowplusluminosity">
                             <option value="">----请选择----</option>
									<c:forEach var="x" begin="1" end="41" step="1" varStatus="index">
		               				<c:set var="lens1" value="${0.00 + (0.25 * (index.index - 1))}" />
									<option value="<fmt:formatNumber value="${lens1 }" pattern="0.00"/>" ${goodsInfoPo.bgibelowplusluminosity + 0 != lens1 ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens1 }" pattern="0.00"/></option>
		               			</c:forEach>
			               			
      	                   </select><label style="color:red;">&nbsp;*</label>
                           </TD>
			               </tr>
			               <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
			               <tr>
			               <TD  height="26" class="table_body">柱镜</TD>
			               <TD  class="table_none" colspan="3">
                           	上限
                           <c:if test="${systemParameterPo.fspnegative==1}">
                           <select id="bgicylul" name="goodsInfoPo.bgicylul" onChange="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
								<option value="">----请选择----</option>
     		                 	<c:forEach var="x" begin="1" end="49" step="1" varStatus="index">
	               				<c:set var="lens" value="${-6.00 + (0.25 * (index.index - 1))}" />
								<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicylul + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select>
      	                   </c:if>
      	                   <c:if test="${systemParameterPo.fspnegative!=1}">
                           <select id="bgicylul" name="goodsInfoPo.bgicylul" onChange="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="25" step="1" varStatus="index">
		               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicylul + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select>
      	                   </c:if>
      	                   	下限
      	                    <c:if test="${systemParameterPo.fspnegative==1}">
                           <select id="bgicylup" name="goodsInfoPo.bgicylup" onChange="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="49" step="1" varStatus="index">
		               				<c:set var="lens" value="${-6.00 + (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicylup + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select>
      	                   </c:if>
      	                   <c:if test="${systemParameterPo.fspnegative!=1}">
                           <select id="bgicylup" name="goodsInfoPo.bgicylup" onChange="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="25" step="1" varStatus="index">
		               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicylup + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select>
      	                   </c:if>
      	                   	跨度
      	                   <select id="bgicylspan" name="goodsInfoPo.bgicylspan" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '跨度不能为空！'}]">
									<option value="0.00" >0.00</option>
									<option value="0.25" >0.25</option>
									<option value="0.50" >0.50</option>
									<option value="0.75" >0.75</option>
									<option value="1.00" >1.00</option>
      	                   </select><label style="color:red;">&nbsp;*</label>
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
			               <TD class="table_body">柱镜</TD>
			               <TD class="table_none" colspan="3">
                           	上限
                           <c:if test="${systemParameterPo.fspnegative==1}">
                           <select id="bgicylul" name="goodsInfoPo.bgicylul" onChange="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="49" step="1" varStatus="index">
		               				<c:set var="lens" value="${-6.00 + (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicylul + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select>
      	                   </c:if>
      	                   <c:if test="${systemParameterPo.fspnegative!=1}">
                           <select id="bgicylul" name="goodsInfoPo.bgicylul" onChange="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="25" step="1" varStatus="index">
		               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicylul + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select>
      	                   </c:if>
      	                   	下限
      	                    <c:if test="${systemParameterPo.fspnegative==1}">
                           <select id="bgicylup" name="goodsInfoPo.bgicylup" onChange="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="49" step="1" varStatus="index">
		               				<c:set var="lens" value="${-6.00 + (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicylup + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select>
      	                   </c:if>
      	                   <c:if test="${systemParameterPo.fspnegative!=1}">
                           <select id="bgicylup" name="goodsInfoPo.bgicylup" onChange="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜不能为空！'}]">
									<option value="">----请选择----</option>
      		                 		<c:forEach var="x" begin="1" end="25" step="1" varStatus="index">
		               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
									<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${goodsInfoPo.bgicylup + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
		               			</c:forEach>
      	                   </select>
      	                   </c:if>
      	                   	跨度
      	                   <select id="bgicylspan" name="goodsInfoPo.bgicylspan" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '跨度不能为空！'}]">
									<option value="0.00" >0.00</option>
									<option value="0.25" >0.25</option>
									<option value="0.50" >0.50</option>
									<option value="0.75" >0.75</option>
									<option value="1.00" >1.00</option>
      	                   </select><label style="color:red;">&nbsp;*</label>
      	                   <input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="${defaultdiscountvalue }">
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
                    <table width="99%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD height="26" class="table_body" width="9%">镜片种类</TD>
			               <TD class="table_none" width="24%">
	                          <select clean=clean id="bgiismutiluminosity" name="goodsInfoPo.bgiismutiluminosity" onchange="changeMutiluminosity();">
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
			               		<select clean=clean id="bgigradualclass"  name="goodsInfoPo.bgigradualclass">
			               			<option value="">----请选择----</option>
			               			<option value="1" ${goodsInfoPo.bgigradualclass != "1" ? '' : 'selected="selected"' }>青少年渐进</option>
			               			<option value="2" ${goodsInfoPo.bgigradualclass != "2" ? '' : 'selected="selected"' }>成人渐进</option>
			               		</select>
			               </TD>
			               <TD class="table_body" width="9%">折射率</TD>
                           <TD class="table_none">
				               <select clean=clean id="bgirefractive"  name="goodsInfoPo.bgirefractive">
	      		                 <option value="">----请选择----</option>
	      		                    <s:iterator value="refractiveSetList">
					               <option value="${brfname}" ${goodsInfoPo.bgirefractive == brfname ? 'selected="selected"' : '' }>${brfname}</option>
		     	                   </s:iterator>
	      	                   </select>
      	                   </TD>
			            </tr>
                        <TR>
			                 <TD class="table_body">镜片功能</TD>
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
                    <table width="99%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
              <c:if test="${(permissionPo.keyf==1)}">
                        <TR>
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                           <TD height="26" class="table_body" width="9%">税率</TD>
			               <TD class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">含税单价</TD>
			                 <TD  class="table_none" width="24%">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice"  maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">&nbsp;*</label>
			                 </TD>
			               <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			         </c:if>
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
                           <TD  height="26" class="table_body" width="9%">税率</TD>
			               <TD  class="table_none"  width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">含税单价</TD>
			                 <TD  class="table_none" colspan="3" >
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" value="${goodsInfoPo.bgicostprice}" id="bgicostprice" name="goodsInfoPo.bgicostprice"  maxlength="10" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '成本价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]">
                             	<label style="color:red;">&nbsp;*</label>
			                 </TD>
                             <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
			         </c:if>
                        </TR>
              </c:if>
                 <c:if test="${(permissionPo.keyf != 1)}">
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
                      <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                        <TR>
                           <TD  height="26" class="table_body" width="9%">税率</TD>
			               <TD  class="table_none" width="24%">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body" width="9%">批发价格</TD>
			               <TD class="table_none" colspan="3">
                             <input clean=clean class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgiwholesaleprice" value="${goodsInfoPo.bgiwholesaleprice}" name="goodsInfoPo.bgiwholesaleprice" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="10"
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '批发价格不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
                     </c:if>
					<c:if test="${systemParameterPo.fspwholesalepriceset eq '1'}">
                      <input class="text_input100" type="hidden" value='0.00' id="bgicostprice" name="goodsInfoPo.bgicostprice" />
                      <input class="text_input100" type="hidden" value='0.00' id="bgiwholesaleprice" name="goodsInfoPo.bgiwholesaleprice" />
                        <TR>
                           <TD  height="26" class="table_body" width="9%">税率</TD>
			               <TD  class="table_none" colspan="5">
                             <input cleans=cleans class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                        </TR>
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
								成品镜片批量：<br>
								商品代码组成说明：<br>
								 <c:if test="${systemParameterPo.fspnegative==1}">
									<IMG src="${ctx}/img/pic/jinpianfanfang.png" ><br>
								</c:if>
								<c:if test="${systemParameterPo.fspnegative!=1}">
									<IMG src="${ctx}/img/pic/jingpian.png" ><br>
								</c:if>
								&nbsp;&nbsp;&nbsp;&nbsp;<font color="#FF0000">商品条码会根据商品代码自动生成。</font><br>
								&nbsp;&nbsp;&nbsp;&nbsp;<font color="#FF0000">商品名称默认为选择的品种的名称，可以自行调整。</font><br>
								&nbsp;&nbsp;&nbsp;&nbsp;<font color="#FF0000">球镜柱镜选择上下限，并制定跨度,批量生成的镜片信息会根据跨度生成不同的球镜柱镜。</font><br>
								&nbsp;&nbsp;&nbsp;&nbsp;<font color="#FF0000">计量单位、镜片种类、折射率、镜片功能等选项是直接从品种信息中带入，同时可以自行调整。</font><br>
								&nbsp;&nbsp;&nbsp;&nbsp;<font color="#FF0000">成本价格为含税单价。</font><br>
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