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

function clean(){
	document.getElementById('bgigoodsbarcode').value="";
	document.getElementById('supplierID').value="";
	document.getElementById('supplierName').value="";
	document.getElementById('goodsID').value="";
	document.getElementById('goodsName').value="";
	document.getElementById('brandID').value="";
	document.getElementById('brandName').value="";
}
	function openSupplier(){
	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=4",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=4",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
					
		//showPopWin("","selSupplierOpen.action?categoryID_open=4",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
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
			showPopWin("selBrandOpen.action?categoryID_open=4&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=4&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		


		//showPopWin("","selBrandOpen.action?categoryID_open=4&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
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
		goodsForm.action="conLensSel.action";
		goodsForm.submit();
	}
	$(document).ready(function(){
		if('${iscustomize}'!=''){
			$('#iscustomize').attr("value",'${iscustomize}');
		}
		
		if($('#iscustomize').val()=='D'){
				$('tr[id=dzArea]').each(function(){
					$(this).show();
				});
				$('#bgigoodsbarcode').val('');
				$('#bgigoodsbarcode').attr("disabled","disabled");
				$('#bgigoodsbarcode').attr("style","background-color: #E0E0E0");
			}else{
				$('tr[id=dzArea]').each(function(){
					$(this).hide();
				});
				$('#bgigoodsbarcode').removeAttr("style");
				$('#bgigoodsbarcode').removeAttr("disabled");
			}
			
		$('#iscustomize').bind("change",function(){
			if($('#iscustomize').val()=='D'){
				$('tr[id=dzArea]').each(function(){
					$(this).show();
				});
				$('#bgigoodsbarcode').val('');
				$('#bgigoodsbarcode').attr("disabled","disabled");
				$('#bgigoodsbarcode').attr("style","background-color: #E0E0E0");
			}else{
				$('tr[id=dzArea]').each(function(){
					$(this).hide();
				});
				$('#bgigoodsbarcode').removeAttr("style");
				$('#bgigoodsbarcode').removeAttr("disabled");
			}
		});
	});
	
	function selectOthers(obj){
	
		if(event.keyCode==13){
			if (obj.value === ''||obj.value.length<26) {
				alert('条码位数不符!');
				obj.value='';
				obj.focus();
				return;
			}else {
				goodsForm.action = "conLensSel.action";
				goodsForm.submit();
			}
			
		}
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
	}
</script>
<!-- oncontextmenu="event.returnValue=false"  onhelp="Showhelp();return false;"-->
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />

<input type="hidden" name="sph" value="${sph }" />
<input type="hidden" name="cyl" value="${cyl }" />
<input type="hidden" name="add" value="${add }" />
<input type="hidden" name="materialtype" value="${materialtype }" />
<input type="hidden" name="glassFlag" value="${glassFlag }" />
<input type="hidden" name="syjp" value="${syjp }" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>选择隐形商品</TD>
            <TD class=menubar_readme_text vAlign=bottom>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();parent.toRound();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：选择隐形商品</TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
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
                      UNSELECTABLE="on">选择商品</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
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
						   <TD height="30" class="table_body">镜片型</TD>
			               <TD class="table_none">
                           <SELECT id="iscustomize" name="iscustomize">
                           	<option value="0">成品片</option>
                           	<option value="D">订做片</option>
                           </SELECT>
			               </TD>
			                <TD height="30" class="table_body">商品条码</TD>
			               <TD class="table_none">
                           <input class="text_input200" type="text"  onkeydown="selectOthers(this)" id="bgigoodsbarcode" name="bgigoodsbarcode">
                           <font color="red">按回车查询商品</font>
			               </TD>
                        </TR>
					  	<TR id="dzArea" style="display: none">
						   <TD width="60" height="30" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="goodsID" name="goodsID" value="${goodsID}">
			               </TD>
			               <TD width="60" height="30" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="goodsName" name="goodsName" value="${goodsName}">
			               </TD>

                        </TR>
                        <TR id="dzArea" style="display: none">
                          
			               <TD height="30" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input200" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>																					
						   			<li class="horizontal_onlyRight">
						  				<INPUT class=button_bak icon="icon-zoom" type=button value="选 择" onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li>
						   	</TD>
						   	 <TD height="30" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly" >
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <input icon="icon-zoom" type=button value="选 择" onClick="openBrand();"></li>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10" id="dzArea"  style="display: none">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
							</td>
						</tr>
					</table>
					 
					<c:if test="${not empty(goodsList)}">
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
					
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="7%" height="30">
						    选择</TH>
                          <TH scope=col width="15%">商品代码</TH>
                          <TH scope=col width="15%">商品名称</TH>
                          <TH scope=col width="10%">品种</TH>
                          <TH scope=col width="5%">销售价格</TH>
                          <TH scope=col width="7%">型号</TH>
                          <TH scope=col width="5%">球镜</TH>
                          <TH scope=col width="5%">柱镜</TH>
                          <TH scope=col width="5%">轴位</TH>
                          <TH scope="col" width="5%">直径</TH>
                          <TH scope="col" width="5%">商品数量</TH>                                                                                        
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row">
						  <TD  height="28"><input icon="icon-apply" type='button' value='选择' onClick="setValue({'bgigoodsid':'${bgigoodsid}','bgigoodsname':'${bgigoodsname}','bgiretailprice':'${bgiretailprice }','bgigoodsbarcode':'${pcBarcode }','bgicostprice':'${bgicostprice }','bginottaxrate':'${bginottaxrate }','glassflag':'${glassFlag }','bgiiscustomize':'${bgiiscustomize}','bgiordercycle':'${bgiordercycle}'});"></TD>
                          <TD>${bgigoodsid}</TD>
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgibrandname}</TD>
                          <TD>${bgiretailprice}</TD>
                          <TD>${bgispec}</TD>                       
                          <TD><c:if test="${bgisph!=''}">${bgisph}</c:if>
                          <c:if test="${bgisph==null}">${bgisphul}/${bgisphup}</c:if></TD>
                          <TD><c:if test="${bgicyl!=''}">${bgicyl}</c:if>
                          <c:if test="${bgicyl==null}">${bgicylul}/${bgicylup}</c:if></TD>
                          <TD>${bgiaxis }</TD>
                          <td>${bgidia }</td>
						  <td>${bgigoodsquantity}</td>    
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