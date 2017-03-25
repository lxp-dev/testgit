<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>镜架维护</title> 
</head>
<script>
	$(document).ready(function() {
		$("[id=f2]").each(function (){
			if($(this).text() >= 0 && $(this).text()){
				$(this).text(parseFloat($(this).text()).toFixed(2));
			}
		});
    });

	function trim(str){ //删除左右两端的空格
　　      return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }
	
	function save(){
		var goodscount = $("[id=addTable]").find("tr").size();
		if (goodscount < 2){
            alert("请选择需要上传的文档!");
            return;
        }
		
	    if (validateBrandYear()){
	           return;
		}
		
		if(checkForm(document.all.glassesFrameForm)){  
		    var bgitaxrate= parseInt(document.all.bgitaxrate.value);
		    if(bgitaxrate>100||bgitaxrate<=-1){
		      alert('税率必须在0-100之间');
		      document.all.bgitaxrate.focus();
		      return false;
		    }
		    var checkcount = "";
			$("[id=ck]").each(function (){
				checkcount = accAdd(checkcount,$(this).val());
			});
			
			if(checkcount > 0){
				alert("导入信息中存在错误！");
				return;
			}
			
			var checkrow = $("[cktype=1]").size();
			if(checkrow){
				alert("商品编码重复！");
				return;
			}
			
		    $("img").removeAttr("onclick");
			glassesFrameForm.action = "insertGlassesManyFinishAR.action";
			glassesFrameForm.submit();
		}
	}

    function validateBrandYear(){
        var brandYear = $('#bgibrandyear').val();
        if (brandYear == ''){
            return false;
        }
        if (brandYear.length != 4){
            alert('采购年份长度不足!');
            return true;
        }
        if (Number(brandYear.substring(2,4)) > 12){
            alert('采购月份输入有误!');
            return true;
        }

        return false;
    }
    function checkYearMonth(thiz){
		if($(thiz).val() && '00'>=$(thiz).val().substring($(thiz).val().length-2,$(thiz).val().length)){alert("输入月份有误");$(thiz).focus();$(thiz).select();}
		if($(thiz).val() && '12'<$(thiz).val().substring($(thiz).val().length-2,$(thiz).val().length)){alert("输入月份有误");$(thiz).focus();$(thiz).select();}
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
		document.getElementById('bgisupplierid').value = json.id;
		document.getElementById('bgisuppliername').value = json.value;
		document.getElementById('bgibrandid').value = "";
		document.getElementById('bgibrandname').value = "";
		document.getElementById('bgigoodsname').value = "";
		
		$('#bgiframeprocesscrafttype').val("");
		$('#bgiunitid').val("");
		$('#bgiframematerialtype').val("");
		
				
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
			showPopWin("selBrandOpen.action?categoryID_open=6&supplierID_open=" + document.getElementById('bgisupplierid').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=6&supplierID_open=" + document.getElementById('bgisupplierid').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		
		$('#bgiframeprocesscrafttype').val(json.processcraftType);
		$('#bgiunitid').val(json.unit);
		$('#bgiframematerialtype').val(json.bbdframematerialtype);
		$('#bgidefaultdiscountvalue').val(json.bbddefaultdiscount);
		$('#bgipayfeeid').val(json.bbdpayfeeid);
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	
	function clean(){
		$("input[clean=clean]").val('');
		$("input[cleans=cleans]").val('17');
		$("input[goodsid=goodsid]").val('1.00.00.000000000.0000');
		$("input[goodscode=goodscode]").val('100000000000000000');
		$("select[clean=clean]").val('');
	}
	
	function importFile(){
		if ($("#file").val() == ""){
            alert("请选择需要上传的文档!");
            return;
        }
	
		glassesFrameForm.action = "importGlassesFinishManyExcel.action";
		glassesFrameForm.submit();
		showLoadingBar();
	}
	
	var AllImgExt = ".xls";
	var FileExt = "";
	function CheckExt(obj){
		if(obj.value == ""){
			return false;
		}
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();		
		if(AllImgExt.indexOf(FileExt) != -1){
	        obj.value = getPath(obj);
            return true;

		}else{
			alert("该文件类型不允许上传。请上传 " + AllImgExt + " 类型的文件，\n当前文件类型为" + FileExt);

			return false;
		}
	}
	
	function getPath(obj){
		if(obj){
	    	if (window.navigator.userAgent.indexOf("MSIE") >= 1){ 
	        	obj.select();      
	            return document.selection.createRange().text;	               
	        }
	        else if(window.navigator.userAgent.indexOf("Firefox") >= 1){	               
	        	if(obj.files){ 	                           
	            	return obj.files.item(0).getAsDataURL();
	            }
	        	return obj.value;
           	}
	    	return obj.value;
		}
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="glassesFrameForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" >
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
                    <table width="99%" border=0 align=center style="PADDING-TOP: 10px;" cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD width="9%" class="table_body">商品名称</TD>
			               <TD class="table_none" width="23%">
                             <input class="text_input160" clean=clean type="text" id="bgigoodsname" value="${goodsInfoPo.bgigoodsname}" name="goodsInfoPo.bgigoodsname" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字符'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
                         <TD height="26" class="table_body" width="9%">制造商</TD>
			               <TD class="table_none" width="23%">
			               		<c:if test="${person.syspsupplierid ne ''}">
							   		<li class="horizontal_onlyRight">
							   		${person.syspsuppliername }
							   		<input type="hidden" id="bgisupplierid" name="goodsInfoPo.bgisupplierid" value="${person.syspsupplierid }" />
							   	</li>
							   	</c:if>
							   	<c:if test="${person.syspsupplierid eq ''}">
							   		<li class="horizontal_onlyRight">
								   		<input id="bgisuppliername" clean=clean class="text_input160"  value="${goodsInfoPo.bgisuppliername}" name="goodsInfoPo.bgisuppliername"  readonly="readonly" />
								   		<input type="hidden" id="bgisupplierid" clean=clean  value="${goodsInfoPo.bgisupplierid}" name="goodsInfoPo.bgisupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
								   	</li>
								   	<li class="horizontal_onlyRight">
								    <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
							   	</c:if>                             
						    </li><label style="color:red;">&nbsp;*</label>
			               </TD>
                           <TD class="table_body" width="9%">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input id="bgibrandname" class="text_input160" clean=clean value="${goodsInfoPo.bgibrandname}" name="goodsInfoPo.bgibrandname" readonly="readonly"/>
						   		<input type="hidden" id="bgibrandid" clean=clean value="${goodsInfoPo.bgibrandid}" name="goodsInfoPo.bgibrandid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属品种不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		 <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						  		</li><label style="color:red;">&nbsp;*</label>
			               </TD>
			            </TR>
			            <tr>
			               <TD height="26" class="table_body">计量单位</TD>
			               <TD class="table_none">
                            <select id="bgiunitid" name="goodsInfoPo.bgiunitid" clean=clean validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '计量单位不能为空！'}]" >
      		                 <option value="">----请选择----</option>
      		               <s:iterator value="unitList">
				               <option value="${butid}" ${goodsInfoPo.bgiunitid == butid ? 'selected="selected"' : '' }>${butunitname}</option>
	     	               </s:iterator>
      	                   </select><label style="color:red;">&nbsp;*</label>
      	                   <input type="hidden" class="text_input100" maxlength="10" name="goodsInfoPo.bgidefaultdiscountvalue" value="${defaultdiscountvalue }">
			               </TD>
                           <TD height="26" class="table_body" width="9%">税率（%）</TD>
			               <TD class="table_none" width="24%">
                             <input class="text_input100" cleans=cleans onKeyUp="value=value.replace(/[^\d\.]/g,'')" type="text" id="bgitaxrate" name="goodsInfoPo.bgitaxrate" value="${empty(goodsInfoPo.bgitaxrate) ? '17' : goodsInfoPo.bgitaxrate }" maxlength="2" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '税率不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '税率应为整数！'}]"><label style="color:red;">&nbsp;*</label>
			               </TD>
			               <TD class="table_body">批号管理</TD>
		               		<td align="left" class="table_none">
		               		<input type="radio" id="bgibarcodeflagid1" name="goodsInfoPo.bgibarcodeflag" value="1" ${goodsInfoPo.bgibarcodeflag eq '1' ? 'checked="checked"' : '' } />是<input type="radio" id="bgibarcodeflagid2" name="goodsInfoPo.bgibarcodeflag" value="0" ${goodsInfoPo.bgibarcodeflag ne '1' ? 'checked="checked"' : '' } />否<label style="color:red;">&nbsp;*</label>
                          	</td> 
                        </tr>
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
                    <table width="99%" border=0 align=center style="PADDING-TOP: 10px;" cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD class="table_body" width="9%">功能</TD>
			               <TD class="table_none" width="24%">
                             <select clean=clean id="bgiframematerialtype"  name="goodsInfoPo.bgiframematerialtype" >
                                 <option value="" ${goodsInfoPo.bgiframematerialtype == '' ? 'selected="selected"' : '' }>----请选择----</option>
                                 <option value="1" ${goodsInfoPo.bgiframematerialtype == '1' ? 'selected="selected"' : '' }>遮阳</option>
                                 <option value="2" ${goodsInfoPo.bgiframematerialtype == '2' ? 'selected="selected"' : '' }>偏光</option>
                             </select>
			               </TD>    
			               <TD height="26" class="table_body">采购年份</TD>
			               <TD class="table_none" colspan="3">
                             <input class="text_input100" clean=clean  onKeyUp="value=value.replace(/[^\d]/g,'')" type="text" id="bgibrandyear" name="goodsInfoPo.bgibrandyear" value="${goodsInfoPo.bgibrandyear}" maxlength="4" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '请重新填写采购年份!'}]"><label style="color:red;">&nbsp;(年份后两位+两位月份)</label>
			               </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    </fieldset>
                    <fieldset>
                    <TABLE width="99%" border=0 align=center style="PADDING-TOP: 10px;" cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                    <tr>
                       	<TD width="9%" height="26" class="table_body">文档路径</TD>
		               	<TD class="table_none" colspan="3">
		               	<input type="file" name="upload" id="file" style="width: 600" onchange="CheckExt(this)"><label style="color:red;">&nbsp;*&nbsp;文件格式为 .xls </label>
		               	<img id="button1" src="${ctx}/img/newbtn/btn_import2_0.png" btn=btn  tltle='导入' onclick="importFile();">
		               	</TD>
                    </tr>
                    </TABLE>
                    </fieldset>
                    <c:if test="${not empty(goodsInfoManyPos)}">
                    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                        <TR class=table_title align=middle>                     
                          <TH scope=col width="10%" height="26">厂家型号</TH>
                          <TH scope=col width="7%" height="26">型号</TH>
						  <TH scope=col width="10%">厂家色号</TH>
						  <TH scope=col width="7%">色号</TH>
						  <TH scope=col width="7%">颜色</TH>
						  <TH scope=col width="7%">款式</TH>
						  <TH scope=col width="7%">尺寸</TH>
                          <TH scope=col width="7%">爱尔结算价</TH>  
 						  <TH scope=col width="7%">标准零售价格</TH>	
 						  <TH scope=col width="7%">批发价格</TH> 
				   		</tr>
				   		<s:iterator value="goodsInfoManyPos">
                        <TR id=cktr class="row" ${bgiisinserted eq '1' ? 'style="background-color: red;"':'' } ${bgiisinserted eq '1' ? 'cktype="1"':'' }>
                          <TD height="26" ${bgisupplierspecck eq '1' ? 'style="background-color: red;"':'' }>
                          	${bgisupplierspec}
                          	<input type="hidden" name="goodsInfoManyPo.bgisupplierspecs" value="${bgisupplierspec }"/>
                          	<input type="hidden" id="ck" value="${bgisupplierspecck }"/>
                          </TD>
                          <TD ${bgispecck eq '1' ? 'style="background-color: red;"':'' }>
                          	${bgispec}
                          	<input type="hidden" name="goodsInfoManyPo.bgispecs" value="${bgispec }"/>
                          	<input type="hidden" id="ck" value="${bgispecck }"/>
                          </TD>
                          <TD ${bgisuppliercolorck eq '1' ? 'style="background-color: red;"':'' }>
                          	${bgisuppliercolor}
                          	<input type="hidden" name="goodsInfoManyPo.bgisuppliercolors" value="${bgisuppliercolor }"/>
                          	<input type="hidden" id="ck" value="${bgisuppliercolorck }"/>
                          </TD>
                          <TD ${bgicolorck eq '1' ? 'style="background-color: red;"':'' }>
                          	${bgicolor}
                          	<input type="hidden" name="goodsInfoManyPo.bgicolors" value="${bgicolor }"/>
                          	<input type="hidden" id="ck" value="${bgicolorck }"/>
                          </TD>
                          <TD ${bgichinesecolorck eq '1' ? 'style="background-color: red;"':'' }>
                          	${bgichinesecolor}
                          	<input type="hidden" name="goodsInfoManyPo.bgichinesecolors" value="${bgichinesecolor }"/>
                          	<input type="hidden" id="ck" value="${bgichinesecolorck }"/>
                          </TD>
                          <TD ${bgiframestyleck eq '1' ? 'style="background-color: red;"':'' }>
                          	${bgiframestyle}
                          	<input type="hidden" name="goodsInfoManyPo.bgiframestyles" value="${bgiframestyle }"/>
                          	<input type="hidden" id="ck" value="${bgiframestyleck }"/>
                          </TD>
                          <TD ${bgiframesizeck eq '1' ? 'style="background-color: red;"':'' }>
                          	${bgiframesize}
                          	<input type="hidden" name="goodsInfoManyPo.bgiframesizes" value="${bgiframesize }"/>
                          	<input type="hidden" id="ck" value="${bgiframesizeck }"/>
                          </TD>
                          <TD ${bgicostpriceck eq '1' ? 'style="background-color: red;"':'' }>
                          	<div id=f2>${bgicostprice}</div>
                          	<input type="hidden" name="goodsInfoManyPo.bgicostprices" value="${bgicostprice }"/>
                          	<input type="hidden" id="ck" value="${bgicostpriceck }"/>
                          </TD>
                          <TD ${bgiretailpriceck eq '1' ? 'style="background-color: red;"':'' }>
                          	<div id=f2>${bgiretailprice}</div>
                          	<input type="hidden" name="goodsInfoManyPo.bgiretailprices" value="${bgiretailprice }"/>
                          	<input type="hidden" id="ck" value="${bgiretailpriceck }"/>
                          </TD>
                          <TD ${bgiwholesalepriceck eq '1' ? 'style="background-color: red;"':'' }>
                          	<div id=f2>${bgiwholesaleprice}</div>
                          	<input type="hidden" name="goodsInfoManyPo.bgiwholesaleprices" value="${bgiwholesaleprice }"/>
                          	<input type="hidden" id="ck" value="${bgiwholesalepriceck }"/>
                          </TD>
						</TR>
						</s:iterator>
				   	</TABLE>
				   	</c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  tltle='保存' onclick="save();">
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
                          </TD>
						</TR>
                      </TBODY>
                    </TABLE>
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
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
						<tr>
						  	<td>
								<br>
								<br>
								太阳镜类批量文档说明：<br><br/>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">厂家型号:小于等于20位</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">型号:小于等于9位（包括0-9、A-Z、a-z等字符）</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">厂家色号:小于等于20位</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">色号:小于等于4位（包括0-9、A-Z、a-z等字符）</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">颜色、款式:所录内容必须在系统中提前录入</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">镜架尺寸:必须为数字类型</font><br>
								&nbsp; &nbsp; &nbsp; &nbsp; <font color="#FF0000">相应价格:必须为数字类型</font><br>
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