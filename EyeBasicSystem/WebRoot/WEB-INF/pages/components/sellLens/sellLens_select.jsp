<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>

<title>销售镜片</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=3",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=3",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;	
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action="sellLensSel.action";
		goodsForm.submit();
		showLoadingBar();
	}
	$(document).ready(function(){
		if('${iscustomize}'!=''){
			$('#iscustomize').attr("value",'${iscustomize}');
		}
		if('${ismutiluminosity}'!=''){
			$('#ismutiluminosity').attr("value",'${ismutiluminosity}');
		}
		if($('#iscustomize').val()==''||$('#iscustomize').val()=='0'||$('#iscustomize').val()=='ZZ')
		{
			$('#ismutiluminosity').attr("disabled","disabled");
		}
		$('#iscustomize').bind("change",function(){
			if($('#iscustomize').val()=='D')
			{
				$('#ismutiluminosity').removeAttr("disabled");
			}else{
				$('#ismutiluminosity').attr("disabled","disabled");	
			}
		});
	});
	function clean(){
		$(':input[type!=button][type!=hidden]').val('');
		$('select').each(function(){
			$(this)[0].selectedIndex=0;
		});
		
		$('#supplierID').val('');
		$('#brandID').val('');
	}
	function setValue(json){
		parent.addGoods(json);
		parent.hidePopWin();parent.toRound();
		
	}
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
		showLoadingBar();
	}
</script>
<!-- oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;"-->
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />

<input type="hidden" name="sph" value="${sph }" />
<input type="hidden" name="cyl" value="${cyl}" />
<input type="hidden" name="add" value="${add }" />
<input type="hidden" name="materialType" value="${materialType }" />
<input type="hidden" name="glassFlag" value="${glassFlag }" />
<input type="hidden" name="recipeType" value="${recipeType }" />

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
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                     <TBODY>
                       <TR>
                         <TD width="5%"><div align="left"><img src="${ctx }/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                         <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                       </TR>
                     </TBODY>
                   </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">商品代码</TD>
			               <TD width="25%" class="table_none">
                            <input class="text_input200" type="text"  id="goodsID" name="goodsid" value="${goodsid}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">商品名称</TD>
			               <TD width="25%" class="table_none">
                            <input class="text_input200" type="text"  id="goodsName" name="goodsname" value="${goodsname}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">镜片型</TD>
			               <TD class="table_none">
                           <SELECT id="iscustomize" name="iscustomize">
                           	<option value="0">成品片</option>
                           	<option value="D" ${recipeType==3?'selected="selected"':''}>订做片</option>
                           	<option value="ZZ">自带片</option>
                           </SELECT>
			               </TD>
                        </TR>
                        <TR>
                           	<TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
				   			<li class="horizontal_onlyRight">
					   			<input id="supplierName" class="text_input200" name="supplierName" readonly="readonly" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
					   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
							</li>																					
				   			<li class="horizontal_onlyRight">
				  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li>
						   	</TD>
						   	<TD height="26" class="table_body">品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
			               </TD>               
			                <TD height="26" class="table_body">镜片种类</TD>
			               <TD class="table_none">
                           <SELECT id="ismutiluminosity" name="ismutiluminosity">
                           <option value="">请选择镜片种类</option>
                           <option value="M">多光</option>
                           	<option selected="selected" value="0">单光</option>
                           	<option value="J">渐进</option>
                           	<option value="K">抗疲劳</option>
                           	<option value="Q">其他</option>
                           </SELECT>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								document.getElementById("searchBar").style.display="none";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(goodsList)}">
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
					
					  <table width="100%" border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="4%" height="26">
						    操作</TH>
                          <TH scope=col width="15%">商品代码</TH>
                          <TH scope=col width="20%">商品名称</TH>
                          <TH scope=col width="20%">品种</TH>
                          <TH scope=col width="10%">销售价格</TH>
                          <TH scope=col width="10%">型号</TH>
                          <TH scope=col width="5%">球镜</TH>
                          <TH scope=col width="5%">柱镜</TH>
                          <TH scope=col width="5%">轴位</TH>
                          <TH scope=col>商品数量</TH>                                                                                                
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row">
						  <TD  height="26"><img src="${ctx }/img/newbtn/select_0.png" btn=btn alte='选择' onClick="setValue({'bgiordercycle':'${bgiordercycle }','bgigoodsid':'${bgigoodsid}','bgigoodsname':'${bgigoodsname}','bgiretailprice':'${bgiretailprice }','bgigoodsbarcode':'${bgigoodsbarcode }','bgicostprice':'${bgicostprice }','bginottaxrate':'${bginottaxrate }','glassflag':'${goodsInfoTempPo.glassFlag }','iscustomize':'${ goodsInfoTempPo.iscustomize}'});"></TD>
                          <TD>${bgigoodsid}</TD>
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgibrandname}</TD>
                          <TD>${bgiretailprice}</TD>
                          <TD>${bgispec}</TD>                       
                          <TD><c:if test="${bgisph!=''}">${bgisph}</c:if>
                          <c:if test="${bgisph==null}">${bgisphul}/${bgisphup}</c:if></TD>
                          <TD><c:if test="${bgicyl!=''}">${bgicyl}</c:if>
                          <c:if test="${bgicyl==null}">${bgicylul}/${bgicylup}</c:if></TD>
                          <TD>${bgiaxis}</TD>
						  <TD>${bgigoodsquantity }</TD>
                          </TR>
                          </s:iterator>
                      </TBODY>
                    </TABLE>
                   
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>