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
		$('input[isc=isc]').each(function(){
			if($(this).val()=='${iscustomize}'){
				$(this).attr("checked",true);
			}
	});
	});
	function ReAutoLoad(){
		window.close();
	}

		setTimeout(ReAutoLoad,5000); 
	/**
	* 商品成本、零售价、批发价二维表查询
	* yangyang
	* 2013-08-02
	*/
	function selectDW(){
		if(document.readyState != "complete"){
			return;
		}
		var category='${brandPos.bbdgoodscategory}';
		$('input[isc=isc]').each(function(){
				if($(this).attr("checked")){
					category=category+$(this).val();
				}
		});
		if(category.length=='1'){
			alert("请选择订制或成品!")
			return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selgalessDWOpen.action?moduleID=${requestScope.moduleID}&brandID=${brandPos.bbdid}&brandName="+EncodeUtf8('${brandPos.bbdbrandname}')+"&supplierID=${brandPos.bbdsupplierid}&supplierName="+EncodeUtf8('${brandPos.bspsuppliername}')+"&ishide=1&categoryID="+category,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selgalessDWOpen.action?moduleID=${requestScope.moduleID}&brandID=${brandPos.bbdid}&brandName="+EncodeUtf8('${brandPos.bbdbrandname}')+"&supplierID=${brandPos.bbdsupplierid}&supplierName="+EncodeUtf8('${brandPos.bspsuppliername}')+"&ishide=1&categoryID="+category,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品成本、零售价、批发价二维表查询】";
	}
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	brandForm.action=link;
	  	brandForm.submit();		
		showLoadingBar();
	}
	function search(){
		brandForm.action = "selBrand.action";
		brandForm.submit();		
		showLoadingBar();
	}	
	function isIscustomers(){
		var category='';
		$('input[isc=isc]').each(function(){
				if($(this).attr("checked")){
					category=$(this).val();
				}
		});
		brandForm.action = "selBrandTree.action?selbbdid=${brandPos.bbdid}&selbbdsupplierid=${brandPos.bbdsupplierid}&iscustomize="+category;
		brandForm.submit();	
		showLoadingBar();
	}
	function detail(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("brandDetail.action?hid="+id + '&bbdsupplierid=' + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("brandDetail.action?hid="+id + '&bbdsupplierid=' + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种详细】";
	}
	function update(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initBrandUpdate.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandUpdate.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种更新】";
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){
			showPopWin("initBrandInsert.action?goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种新增】";
	}

	function del(id, supplierID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;

		if(is_iPad()){
			showPopWin("initBrandDelete.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid="+ supplierID+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandDelete.action?hid="+id + "&parent="+parent+"&goodsTree="+goodsTree+"&bbdsupplierid=" + supplierID+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种删除】";
	}	
	function enbled(id, supplierID, flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initBrandEnbled.action?hid="+id + '&bbdsupplierid=' + supplierID+"&moduleID=${requestScope.moduleID}" + '&flag=' + flag,400,140,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initBrandEnbled.action?hid="+id + '&bbdsupplierid=' + supplierID+"&moduleID=${requestScope.moduleID}" + '&flag=' + flag,400,140,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种启用/停用】";
	}
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function clean(){
		document.getElementById('selbbdid').value = "";
		document.getElementById('selbbdbrandname').value = "";
		document.getElementById('selbspcategoryid').value = "";
		document.getElementById('selbspsuppliername').value = "";
		document.getElementById('selbbdsupplierid').value = "";
		document.getElementById('isClosed').value = "";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + document.all.selbspcategoryid.value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bbdsupplierid').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
	}
	function detailsGoods(id,iscustomize){
		 var arrDetails=new Array(); 
		 arrDetails[1]="initGlassesFrameDetails";
		 arrDetails[2]="initGlassesAccessoriesDetails";
		 if(id.substr(0,1)=='3'&&iscustomize=='D'){
			 arrDetails[3]="initLensCustomDetails";
		 }else if(id.substr(0,1)=='3'&&iscustomize=='0'){
			 arrDetails[3]="initLensFinishedDetails";	 
		 }
		 if(id.substr(0,1)=='4'&&iscustomize=='D'){
			 arrDetails[4]="initStealthCustomLensesDetails";
		 }else if(id.substr(0,1)=='4'&&iscustomize=='0'){
			 arrDetails[4]="initStealthFinishedDetails";	 
		 }
		 arrDetails[5]="initStealthAccessoriesDetails";
		 arrDetails[6]="initGlassesFinishDetails";
		 arrDetails[7]="initOtherGoodsDetails";
		 arrDetails[8]="initPresbyopicGlassesDetails";
		 arrDetails[9]="initVisualOpticsDetails";
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin(arrDetails[id.substr(0,1)]+".action?moduleID=${requestScope.moduleID}&hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(arrDetails[id.substr(0,1)]+".action?moduleID=${requestScope.moduleID}&hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
	}
	function updateGoods(id,iscustomize){
		var arrDetails=new Array(); 
		 arrDetails[1]="initGlassesFrameUpdate";
		 arrDetails[2]="initGlassesAccessoriesUpdate";
		 if(id.substr(0,1)=='3'&&iscustomize=='D'){
			 arrDetails[3]="initLensCustomUpdate";
		 }else if(id.substr(0,1)=='3'&&iscustomize=='0'){
			 arrDetails[3]="initLensFinishedUpdate";	 
		 }
		 if(id.substr(0,1)=='4'&&iscustomize=='D'){
			 arrDetails[4]="initStealthCustomLensesUpdate";
		 }else if(id.substr(0,1)=='4'&&iscustomize=='0'){
			 arrDetails[4]="initStealthFinishedUpdate";	 
		 }
		 arrDetails[5]="initStealthAccessoriesUpdate";
		 arrDetails[6]="initGlassesFinishUpdate";
		 arrDetails[7]="initOtherGoodsUpdate";
		 arrDetails[8]="initPresbyopicGlassesUpdate";
		 arrDetails[9]="initVisualOpticsUpdate";
		 
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		
		if(is_iPad()){
			showPopWin(arrDetails[id.substr(0,1)]+".action?moduleID=${requestScope.moduleID}&goodsTree="+goodsTree+"&parent="+parent+"&hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin(arrDetails[id.substr(0,1)]+".action?moduleID=${requestScope.moduleID}&goodsTree="+goodsTree+"&parent="+parent+"&hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
	}
	function delGoods(id,iscustomize){
		var arrDetails=new Array(); 
		 arrDetails[1]="initGlassesFrameDelete";
		 arrDetails[2]="initGlassesAccessoriesDelete";
		 if(id.substr(0,1)=='3'&&iscustomize=='D'){
			 arrDetails[3]="initLensCustomDelete";
		 }else if(id.substr(0,1)=='3'&&iscustomize=='0'){
			 arrDetails[3]="initLensFinishedDelete";	 
		 }
		 if(id.substr(0,1)=='4'&&iscustomize=='D'){
			 arrDetails[4]="initStealthCustomLensesDelete";
		 }else if(id.substr(0,1)=='4'&&iscustomize=='0'){
			 arrDetails[4]="initStealthFinishedDelete";	 
		 }
		 arrDetails[5]="initStealthAccessoriesDelete";
		 arrDetails[6]="initGlassesFinishDelete";
		 arrDetails[7]="initOtherGoodsDelete";
		 arrDetails[8]="initPresbyopicGlassesDelete";
		 arrDetails[9]="initVisualOpticsDelete";
		 
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		var goodsTree=document.getElementById("goodsTree").value;
		var parent=document.getElementById("parent").value;
		if(is_iPad()){ 
		showPopWin(arrDetails[id.substr(0,1)]+".action?hid="+id+"&goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin(arrDetails[id.substr(0,1)]+".action?hid="+id+"&goodsTree="+goodsTree+"&parent="+parent+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		} 
	}
	function disableGoods(id,iscustomize){

		var arrDetails=new Array(); 
		 arrDetails[1]="initGlassesFrameDisable";
		 arrDetails[2]="initGlassesAccessoriesDisable";
		 if(id.substr(0,1)=='3'&&iscustomize=='D'){
			 arrDetails[3]="initLensCustomDisable";
		 }else if(id.substr(0,1)=='3'&&iscustomize=='0'){
			 arrDetails[3]="initLensFinishedDisable";	 
		 }
		 if(id.substr(0,1)=='4'&&iscustomize=='D'){
			 arrDetails[4]="initStealthCustomLensesDisable";
		 }else if(id.substr(0,1)=='4'&&iscustomize=='0'){
			 arrDetails[4]="initStealthFinishedDisable";	 
		 }
		 arrDetails[5]="initStealthAccessoriesDisable";
		 arrDetails[6]="initGlassesFinishDisable";
		 arrDetails[7]="initOtherGoodsDisable";
		 arrDetails[8]="initPresbyopicGlassesDisable";
		 arrDetails[9]="initVisualOpticsDisable";
		
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin(arrDetails[id.substr(0,1)]+".action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin(arrDetails[id.substr(0,1)]+".action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		} 
	}
	function ableGoods(id,iscustomize){

		var arrDetails=new Array(); 
		 arrDetails[1]="initGlassesFrameAble";
		 arrDetails[2]="initGlassesAccessoriesAble";
		 if(id.substr(0,1)=='3'&&iscustomize=='D'){
			 arrDetails[3]="initLensCustomAble";
		 }else if(id.substr(0,1)=='3'&&iscustomize=='0'){
			 arrDetails[3]="initLensFinishedAble";	 
		 }
		 if(id.substr(0,1)=='4'&&iscustomize=='D'){
			 arrDetails[4]="initStealthCustomLensesAble";
		 }else if(id.substr(0,1)=='4'&&iscustomize=='0'){
			 arrDetails[4]="initStealthFinishedAble";	 
		 }
		 arrDetails[5]="initStealthAccessoriesAble";
		 arrDetails[6]="initGlassesFinishAble";
		 arrDetails[7]="initOtherGoodsDisable";
		 arrDetails[8]="initPresbyopicGlassesAble";
		 arrDetails[9]="initVisualOpticsAble";
		
		var topRows = top.document.getElementById("total").rows; 
		var topCols = top.document.getElementById("btmframe").cols; 
		if(is_iPad()){ 
		showPopWin(arrDetails[id.substr(0,1)]+".action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		}else{ 
		showPopWin(arrDetails[id.substr(0,1)]+".action?hid="+id+"&moduleID=${requestScope.moduleID}",400,160, topRows,topCols,returnRefresh(true),true); 
		} 
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }> 
<form name="brandForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" />
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree }" />
<input type="hidden" name="cateid" id="cateid" value="${cateid }" />
<input type="hidden" name="parent" id="parent" value="${parent}" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
    
    <!-- ?? Start -->
      <%--<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：品种维护</TD>
            <Td align="right" valign="bottom">&nbsp;
            	<c:if test="${(permissionPo.keya==1)}">
            	<img btn=btn src="${ctx }/img/newbtn/btn_brandinsert_0.png" title="品种新增" onClick="insert()">
            	</c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </Td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      --%><!-- ?? End --><!-- ?? Start -->
      
      
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
				</TD></TR>
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
				  <%--<table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>--%>
				   <%--<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  		<TD width="8%" height="26" class="table_body">商品类别</TD>
	                          <TD width="20%" class="table_none">
							  	<select id="selbspcategoryid" name="selbspcategoryid">
							  		<option value="">----请选择----</option>
							  		<s:iterator value="goodsCategorys">
									<option value="${bgcid}" ${selbspcategoryid == bgcid ? 'selected="selected"' : '' } >${bgcgoodscategoryname}</option>
		     	               		</s:iterator>
								</select></TD>
						   <TD width="8%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input id="bspsuppliername" class="text_input160" name="selbspsuppliername" value="${selbspsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="bbdsupplierid" name="selbbdsupplierid" value="${selbbdsupplierid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li></TD>
                        	<TD width="8%" height="26" class="table_body">品种代码</TD>
			               	<TD class="table_none"><input class="text_input100" type="text" id="selbbdid" name="selbbdid" value="${selbbdid }" /></TD>
                        </tr>
                        <tr>
							<TD  height="26" class="table_body">品种名称</TD>
                          	<TD class="table_none"><input class="text_input160" id="selbbdbrandname" name="selbbdbrandname" value="${selbbdbrandname }"></TD>
							<TD height="26" class="table_body">
						                     启用状态
							</TD>
							<TD class="table_none" colspan="3">
								<select id="isClosed" name="isClosed">
                            	<option value="">----请选择----</option>
                            	<option value="1" ${requestScope.isClosed eq 1 ? 'selected="selected"' : '' }>启用</option>
                            	<option value="0" ${requestScope.isClosed eq 0 ? 'selected="selected"' : '' }>停用</option>
								</select>
							</TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
						<c:if test="${(permissionPo.keyd==1)}">
							  <td>
								  <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onclick="search();" >
								  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="clean();" >
							  </td>
						</c:if>
							  
						</tr>
					</table>--%>
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
					<c:if test="${not empty(brands)}">
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/brandInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="12%" scope=col colspan="4">操作</TH>
                          <TH width="12%" height="26" scope=col>品种代码</TH>
                          <TH width="32%" scope=col>品种名称</TH>
						  <th width="10%">商品类别</th>
                          <TH scope=col>制造商简称</TH>
                        </TR>
                        <c:forEach var="po" items="${brands}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyg==1)}">
                          		<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="detail('${po.bbdid }', '${po.bbdsupplierid }')">
                          	</c:if>
                          </TD>
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyb==1)}">
                          		<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="update('${po.bbdid }', '${po.bbdsupplierid }')">
                          	</c:if>
                          </TD>
                          <TD width="3%">
                          	<c:if test="${(permissionPo.keyc==1)}">
                          		<img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="del('${po.bbdid }', '${po.bbdsupplierid }')" >
                          	</c:if>		
                          </TD>
	                   		<TD width="3%">
	                   			<c:if test="${(permissionPo.keye==1)}">
	                    			<c:if test="${po.bbdsalesstatue == '0'}">
	                    				<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='启用' onClick="enbled('${po.bbdid }', '${po.bbdsupplierid }', '1')" >
	                    			</c:if>
	                    			<c:if test="${po.bbdsalesstatue == '1'}">
	                    				<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='停用' onClick="enbled('${po.bbdid }', '${po.bbdsupplierid }', '0')" >
	                    			</c:if>
	                   			</c:if>
	                   		</TD>
                          <TD height="26">${po.bbdid }</TD>
                          <TD>${po.bbdbrandname }</TD>
						  <td>${po.bgcgoodscategoryname } </td>
                          <TD>${po.bspsuppliername }</TD>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx }/img/pic/danjuti.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx }/img/pic/msgbg.png" colspan="3">&nbsp;</TD>
                                </TR>
                                <c:if test="${(brandPos.bbdgoodscategory==4)||(brandPos.bbdgoodscategory==3)}">
                                 <TR >
                                 <TD align="right" >
                                  	<input type="radio" id="iscustomize1" isc=isc onclick="isIscustomers(this);" name="iscustomize" value="">全部
                                  	</TD>
                                  <TD align="center" width="10%">
                                  	<input type="radio"  isc=isc name="iscustomize" onclick="isIscustomers(this);" value="0">成品
                                  	</TD>
                                  	<TD align="left" width="10%">
                                 	 <input type="radio"  isc=isc onclick="isIscustomers(this);" name="iscustomize" value="D">订制&nbsp; &nbsp;
                                 	</TD>
                                 	<TD align="left" >
                                  <img src="${ctx }/img/newbtn/btn_CRWdw_0.png" btn=btn title="二维表" onClick="selectDW()">
                                 </TD>
                                </TR>
                                </c:if>
                              </TBODY>
                    </TABLE>
                    <c:if test="${not empty(goodsInfoList)}">
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="12%" scope=col colspan="4">操作</TH>
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="26%" scope=col>商品名称</TH>
						  <th scope=col>商品品种</th>
                          <TH scope=col width="5%">单位</TH>
                          <TH scope=col width="8%">零售价格</TH>
                          <TH scope=col width="8%">当前状态</TH>
                        </TR>
                        
                        <c:forEach var="goods" items="${goodsInfoList}">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD width="3%" scope=col >
                          	<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="detailsGoods('${goods.bgigoodsid }','${goods.bgiiscustomize }')">
						  </TD>
                          <TD width="3%" scope=col >
                          	<img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="updateGoods('${goods.bgigoodsid }','${goods.bgiiscustomize }')">
                          </TD>
                          <TD width="3%" scope=col >
                            <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="delGoods('${goods.bgigoodsid }','${goods.bgiiscustomize }')" >
						  </TD>
                          <TD width="3%" scope=col >
							<c:if test="${goods.bgiflag == '0'}">
	                    		<img src="${ctx }/img/newbtn/unenabled_0.png" btn=btn title='启用' onClick="ableGoods('${goods.bgigoodsid }','${goods.bgiiscustomize }')" >
	                    	</c:if>
	                    	<c:if test="${goods.bgiflag == '1'}">
	                    		<img src="${ctx }/img/newbtn/enabled_0.png" btn=btn title='停用' onClick="disableGoods('${goods.bgigoodsid }','${goods.bgiiscustomize }')" >
	                    	</c:if>
						  </TD>
                          <TD height="26" scope=col>${goods.bgigoodsid }</TD>
                          <TD scope=col>${goods.bgigoodsname }</TD>
						  <TD>${goods.bgibrandname }</TD>
                          <TD scope=col>${goods.bgiunitname }</TD>
                          <TD scope=col>${goods.bgiretailprice }</TD>
                          <c:if test="${goods.bgiflag==1 }">
                          <TD scope=col>启用</TD>
                          </c:if>
                           <c:if test="${goods.bgiflag!=1 }">
                          <TD scope=col>停用</TD>
                          </c:if>
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					</c:if>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>
