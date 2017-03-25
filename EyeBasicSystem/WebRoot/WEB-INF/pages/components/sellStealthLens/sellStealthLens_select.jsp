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
	function openSupplier(){
		//showPopWin("","selSupplierOpen.action?categoryID_open=3",screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
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
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;	
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	   
		//showPopWin("","selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=3&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		goodsForm.action="sellStealthLensSel.action";
		goodsForm.submit();
		showLoadingBar();
	}
	$(document).ready(function(){
		if('${goodsInfoTempPo.iscustomize}'!=''){
			$('#iscustomize').attr("value",'${goodsInfoTempPo.iscustomize}');
		}
		if('${goodsInfoTempPo.ismutiluminosity}'!=''){
			$('#ismutiluminosity').attr("value",'${goodsInfoTempPo.ismutiluminosity}');
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
	function setValue(json){
		/*alert(json.bgigoodsid);
		alert(json.bgigoodsname);
		alert(json.bgiretailprice);
		alert(json.bgigoodsbarcode);
		alert(json.bgicostprice);
		alert(json.bginottaxrate);
		alert(json.glassflag);	*/
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

<input type="hidden" name="goodsInfoTempPo.sph" value="${goodsInfoTempPo.sph }" />
<input type="hidden" name="goodsInfoTempPo.cyl" value="${goodsInfoTempPo.cyl }" />
<input type="hidden" name="goodsInfoTempPo.add" value="${goodsInfoTempPo.add }" />
<input type="hidden" name="goodsInfoTempPo.materialtype" value="${goodsInfoTempPo.materialtype }" />
<input type="hidden" name="goodsInfoTempPo.glassFlag" value="${goodsInfoTempPo.glassFlag }" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>选择商品</TD>
            <TD class=menubar_readme_text vAlign=bottom>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：选择镜片</TD>
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
						   <TD width="60" height="30" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="goodsID" name="goodsid" value="${goodsid}">
			               </TD>
			               <TD width="60" height="30" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input200" type="text"  id="goodsName" name="goodsname" value="${goodsname}">
			               </TD>

                        </TR>
                        <TR>
                          
			               <TD height="30" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input100" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>																					
						   			<li class="horizontal_onlyRight">
						  				<INPUT class=button_bak icon="icon-zoom" type=button value="选 择" onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }></li>
						   	</TD>
						   	 <TD height="30" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <input icon="icon-zoom" type=button value="选 择" onClick="openBrand();"></li>
			               </TD>
                        </TR>
                        <TR>			               
						   <TD height="30" class="table_body">镜片型</TD>
			               <TD class="table_none">
                           <SELECT id="iscustomize" name="iscustomize">
                           	<option value="0">成品片</option>
                           	<option value="D">订做片</option>
                           	<option value="ZZ">自带片</option>
                           </SELECT>
			               </TD>
			              
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
								<input id="submitButton" icon='icon-search' type='button' value='查询' onClick="javascript:search()">
								<input icon='icon-retry' type='button' value="清空" onClick="clean()">
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
                                                                                                                          
						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row">
						  <TD  height="28"><input icon="icon-apply" type='button' value='选择' onClick="setValue({'bgigoodsid':'${bgigoodsid}','bgigoodsname':'${bgigoodsname}','bgiretailprice':'${bgiretailprice }','bgigoodsbarcode':'${bgigoodsbarcode }','bgicostprice':'${bgicostprice }','bginottaxrate':'${bginottaxrate }','glassflag':'${goodsInfoTempPo.glassFlag }'});"></TD>
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