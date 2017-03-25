<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
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

	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action = "selWindowInspectionOtherOpen.action";
		goodsForm.submit();
		showLoadingBar();
	}
	
	function clean(){
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		$('#goodsname').val("");
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";

	}	

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=${goodscategoryID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=${goodscategoryID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var goodscategoryID='';
		if(supplierID == ''){
			alert("请选择制造商！");
			return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open=${goodscategoryID}&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=${goodscategoryID}&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		
	/**
	 *  调用页面赋值
	 */
	function setValue(objValue,index){ 
		var side = $('#side').val();	
		var xzindex = $('#xzindex').val();	     
		var json = {'brandName':objValue,'glassType':'${glassType}','xzindex':xzindex,'side':side};
        window.parent.openGoodSingleValues(json);
       	parent.hidePopWin();
		
	}
	function selectContact(obj){
		if(event.keyCode==13){
			search();
		}
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="goodsForm" method="post" action="">

<input type="hidden" name="glassType" value="${glassType}">
<input type="hidden" name="goodscategoryID" value="4">
<input type="hidden" name="sopipballglass" value="${sopipballglass}">
<input type="hidden" name="sopippostglass" value="${sopippostglass}">
<input type="hidden" name="xzindex" id="xzindex" value="${xzindex}">
<input type="hidden" name="side" id="side" value="${side}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
		  </TD>
		</TR>
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
                      <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                        <TR>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" readonly="readonly" class="text_input200" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" title="选择" btn=btn onClick="openSupplier();" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } ></li>
						   	</TD>
						   	<TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" title="选择" btn=btn onClick="openBrand();"></li>
			               </TD>
                        </TR>
                      </c:if>
                        <TR>
			               <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none" colspan="5">
					   			<input id="goodsname" class="text_input200" name="goodsname" value="${goodsname}"/>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="searchBar" cellspacing="2">
						<tr height="10">
							<td>
							 <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn  title='查询' onclick="javascript:search()">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onclick="clean()" >
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
                          <TH width="4%" height="26" scope=col >操作</TH>     
                        <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">                    
                          <TH width="20%" scope=col>制造商</TH>                        
                          <TH width="19%" scope=col>品种名称</TH> 
                        </c:if>  
                          <TH width="19%" scope=col>商品名称</TH>                        
                          <TH width="19%" scope=col>镜片型</TH>     
                          <TH width="19%" scope=col>零售价格</TH>    
						</TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><img src="${ctx }/img/newbtn/select_0.png" btn=btn title='选择' onClick="setValue('${bgigoodsname}');"></TD>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1' || departmenttype != '1'}">
                          <TD>${bgisuppliername}</TD>
                          <TD>${bgibrandname}</TD>  
                          </c:if>
                          <TD>${bgigoodsname}</TD>
                          <TD>
                              <c:if test="${bgiiscustomize == 'D'}">
					                                  订做片
					          </c:if>
					          <c:if test="${bgiiscustomize == '0'}">
					                                  成品片
					          </c:if> 
					      </TD> 
                          <TD>${bgiretailprice}</TD>    
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
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
