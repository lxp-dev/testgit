<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品二维信息查询</title>
</head>
<script>
	
	function search(){
		if($('#supplierID').val()==''){
			alert("请选择制造商！");
			return;
		}
		if($('#brandID').val()==''){
			alert("请选择品种！");
			return;
		}
	$("img").removeAttr("onclick");
		glassesFrameForm.action = "selgalessDWOpen.action?justType=Retail";
		glassesFrameForm.submit();		
	}
	function clean(){
		document.getElementById('supplierID').value = "";
		document.getElementById('supplierName').value = "";
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		$('#ls').hide();
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=${fn:substring(goodsCategoryID,0,1)}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=${fn:substring(goodsCategoryID,0,1)}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
			showPopWin("selBrandOpen.action?categoryID_open=${fn:substring(goodsCategoryID,0,1)}&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=${fn:substring(goodsCategoryID,0,1)}&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
<form name="glassesFrameForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="parent" id="parent" value="${parent}" >
<input type="hidden" name="goodsTree" id="goodsTree" value="${goodsTree}" >
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID" value="${goodsCategoryID }">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" height="100%" border=0>
  <TBODY>
  <c:if test="${ishide!=1}">
  <tr >
  	 <Td align="right" valign="bottom">&nbsp;
   	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title3');changeShowOrHidden();" />
   	</Td>
  </tr>
  <%--报表查询条件 begin --%> 
   <TR id="title3">
    <TD><!-- ?? Start -->
      
      <TABLE cellSpacing=0 cellPadding=0 width="100%" height="100%" align=center border=0>
        <TBODY>
       <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx }/img/pic/tab_bg.gif>
            
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
                  
                    <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	<TD width="9%" height="26" class="table_body">商品类型</TD>
					  	<TD class="table_none">
					  		<select id="goodsCategoryID" name="goodsCategoryID" disabled="disabled">
					  			<option value="">---请选择---</option>
								<option value="30" ${goodsCategoryID=='30'? 'selected':''  }>成品镜片</option>
								<option value="3D" ${goodsCategoryID=='3D'? 'selected':''  }>定制镜片</option>
								<option value="40" ${goodsCategoryID=='40'? 'selected':''  }>隐形成品</option>
								<option value="4D" ${goodsCategoryID=='4D'? 'selected':''  }>隐形定制</option>
					  		</select>
					  	</TD>
						   <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input160" type="text"  id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
							   		<input type="hidden" id="supplierID" name="supplierID" value="${requestScope.supplierID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
							   </li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						  </li>
			               </TD>
                        </TR>
						<TR>
							<TD  height="26" class="table_body">零售价格</TD>
							 <TD  height="26" class="table_none" colspan="5"><select id="whichretail" name="whichretail">
	                            <c:if test="${systemParameterPo.fspretailprice=='1' }">
									<option value="1" ${whichretail == '1' ? 'selected':'' }>标准零售价格</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricea=='1' }">
									<option value="2" ${whichretail == '2' ? 'selected':'' }>零售价格2</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceb=='1' }">
									<option value="3" ${whichretail == '3' ? 'selected':'' }>零售价格3</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricec=='1' }">
									<option value="4" ${whichretail == '4' ? 'selected':'' }>零售价格4</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriced=='1' }">
									<option value="5" ${whichretail == '5' ? 'selected':'' }>零售价格5</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricee=='1' }">
									<option value="6" ${whichretail == '6' ? 'selected':'' }>零售价格6</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricef=='1' }">
									<option value="7" ${whichretail == '7' ? 'selected':'' }>零售价格7</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceg=='1' }">
									<option value="8" ${whichretail == '8' ? 'selected':'' }>零售价格8</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpriceh=='1' }">
									<option value="9" ${whichretail == '9' ? 'selected':'' }>零售价格9</option>
								</c:if>
								<c:if test="${systemParameterPo.fspretailpricei=='1' }">
									<option value="10" ${whichretail == '10' ? 'selected':'' }>零售价格10</option>
								</c:if>
	                      	  </select></TD>
						</TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							 <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->	
  					
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
    <TD height=5></TD></TR></c:if>
    <%--报表查询条件 end --%>
   <%--报表内容  begin--%> 
   
  <TR height="100%">
    <TD height="100%"><!-- ?? Start -->
      
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0 height="100%">
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
	                    <c:if test="${permissionPo.keyf =='1'}">
	                      <TD width=3><IMG id=tabImgLeft__1 height=22 
	                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
	                      <TD class=tab id=tabLabel__1 
	                      background=${ctx }/img/pic/tab_unactive_bg.gif
	                      onclick="JavaScript:window.location.href='selgalessDWOpen.action?moduleID=${requestScope.moduleID}&justType=Cost&categoryID=${goodsCategoryID }&supplierID=${supplierID }&brandID=${brandID}&supplierName=${supplierName }&brandName=${brandName}&whichretail=${whichretail}&ishide=${ishide }';"
	                      UNSELECTABLE="on">成本价格</TD>
	                      <TD width=3><IMG id=tabImgRight__1 height=22 
	                        src="${ctx }/img/pic/tab_unactive_right.gif" 
	                    width=3></TD>
	                    </c:if>
	                 
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif  
                      UNSELECTABLE="on">零售价格</TD>
                     <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    <c:if test="${systemParameterPo.fspwholesalepriceset eq '0'}">
	                   <c:if test="${permissionPo.keyj ==1}">
	                    <TD width=3><IMG id=tabImgLeft__1 height=22 
	                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
	                      <TD class=tab id=tabLabel__1 
	                      background=${ctx }/img/pic/tab_unactive_bg.gif
	                      onclick="JavaScript:window.location.href='selgalessDWOpen.action?moduleID=${requestScope.moduleID}&justType=Wholesale&categoryID=${goodsCategoryID }&supplierID=${supplierID }&brandID=${brandID}&supplierName=${supplierName }&brandName=${brandName}&whichretail=${whichretail}&ishide=${ishide }';"
	                      UNSELECTABLE="on">批发价格</TD>
	                     <TD width=3><IMG id=tabImgRight__1 height=22 
	                        src="${ctx }/img/pic/tab_unactive_right.gif" 
	                    width=3></TD>
	                    </c:if>
                    </c:if>
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR height="100%">
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 height="100%" width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px;overflow: auto" 
                vAlign=top><DIV id="ls">
                <c:if test="${brandID!=''}">
                <c:if test="${fn:substring(goodsCategoryID,1,2)!='D'}">
                  <iframe id="reportFrame" src="report.action?reportlet=selgalessDWRetailOpen.cpt&supplierid=${supplierID }&brandid=${brandID}&goodscategoryid=${fn:substring(goodsCategoryID,0,1)}&iscustomize=${fn:substring(goodsCategoryID,1,2)}&rt=${whichretail}" width="100%" height="100%">
				</iframe><%--成品 --%>
				</c:if>
				<c:if test="${fn:substring(goodsCategoryID,1,2)=='D'}">
	                <iframe id="reportFrame" src="report.action?reportlet=selgalessDWRetail_DOpen.cpt&supplierid=${supplierID }&brandid=${brandID}&goodscategoryid=${fn:substring(goodsCategoryID,0,1)}&iscustomize=${fn:substring(goodsCategoryID,1,2)}" width="100%" height="100%">
					</iframe><%--订制 --%>
					</c:if>
				</c:if>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR>
    <%--报表内容  end--%>
    </TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>