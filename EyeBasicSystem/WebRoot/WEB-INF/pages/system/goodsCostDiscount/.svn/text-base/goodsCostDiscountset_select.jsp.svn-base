<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品成本折扣</title>
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

	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsCostDiscountSetUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGoodsCostDiscountSetUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品成本折扣修改】";
	}
	
	function search(){
		$("img").removeAttr("onclick");
		maxDiscountFrm.action = "goodsCostDiscountSetSel.action";
		maxDiscountFrm.submit();
		showLoadingBar();
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsCostDiscountSetInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGoodsCostDiscountSetInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【商品成本折扣新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initGoodsCostDiscountSetDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【商品成本折扣删除】";
	}
	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });
	}
	
	function batchUpdate(){
    	var billID='';				
		$('input[id=chk]:checked').each(function(){		
				billID=billID+$(this).val()+',';
		});

		if (billID == ''){
		    alert("请选择需要设置的商品!");
		    return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsCostDiscountSetBatchUpdate.action?hid="+billID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initGoodsCostDiscountSetBatchUpdate.action?hid="+billID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【批量修改】";
    }
    
    function batchDetele(){    		
		var billID='';				
		$('input[id=chk]:checked').each(function(){		
				billID=billID+$(this).val()+',';
		});
		if (billID == ''){
		    alert("请选择需要设置的商品!");
		    return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initGoodsCostDiscountSetBatchDelete.action?hid="+billID,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【批量删除】";
    }

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
		    
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var firGoodsCategoryID = document.getElementById("goodsCategoryID").value.substring(0,1);
	    if(firGoodsCategoryID==''){
	      alert('请选择商品类别!');
	      return false;
	    }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+firGoodsCategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+firGoodsCategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;		
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
	}
	
	function changeGoodsCategory(){
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';		
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
	}	
			
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var firGoodsCategoryID = document.getElementById("goodsCategoryID").value.substring(0,1);
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商!');
	      return false;
	    }	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+firGoodsCategoryID+"&supplierID_open=" +supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+firGoodsCategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="maxDiscountFrm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>营销管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品成本折扣</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${permissionPo.keya == 1}">
            		<img src="${ctx }/img/newbtn/btn_zdzkszadd_0.png" btn=btn title="商品成本折扣新增" onclick="insert();"/>
            	</c:if>
            	<img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
    	  <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
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
					  		<TD width="9%" height="26" class="table_body">商品类别</TD>
	                          <TD width="24%" class="table_none">
							  	<select clean=clean id="goodsCategoryID" name="goodsCategoryID" onchange="changeGoodsCategory();">
							  		<option value="">----请选择----</option>
							  		<option value="1" ${goodsCategoryID == '1' ? 'selected="selected"' : '' } >镜架</option>
							  		<option value="2" ${goodsCategoryID == '2' ? 'selected="selected"' : '' } >配件</option>
							  		<option value="3_0" ${goodsCategoryID == '3_0' ? 'selected="selected"' : '' } >成品片</option>
							  		<option value="3_D" ${goodsCategoryID == '3_D' ? 'selected="selected"' : '' } >订做片</option>
							  		<option value="4_0" ${goodsCategoryID == '4_0' ? 'selected="selected"' : '' } >隐形成品片</option>
							  		<option value="4_D" ${goodsCategoryID == '4_D' ? 'selected="selected"' : '' } >隐形订做片</option>
							  		<option value="5" ${goodsCategoryID == '5' ? 'selected="selected"' : '' } >护理液</option>
							  		<option value="6" ${goodsCategoryID == '6' ? 'selected="selected"' : '' } >太阳镜</option>
							  		<option value="7" ${goodsCategoryID == '7' ? 'selected="selected"' : '' } >耗材</option>
							  		<option value="8" ${goodsCategoryID == '8' ? 'selected="selected"' : '' } >老花镜</option>
							  		<option value="9" ${goodsCategoryID == '9' ? 'selected="selected"' : '' } >视光</option>
								</select></TD>
						   <TD width="8%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input clean=clean id="supplierName" class="text_input160" name="supplierName" value="${supplierName }" readonly="readonly" />
						   		<input clean=clean type="hidden" id="supplierID" name="supplierID" value="${supplierID }"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li></TD>
                           <TD width="9%" class="table_body">商品品种</TD>
			               <TD width="24%" class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}" />
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" ></li>
			               </TD>
                        </tr>
                        <tr>
						   <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}" maxlength="50">
			               </TD>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none" colspan="3">
                            <input clean=clean class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}" maxlength="200">
			               </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                     
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
						    <c:if test="${permissionPo.keyd == 1}">	
		                        <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
						    </c:if>	
							<c:if test="${permissionPo.keyc=='1'}">	
								<img src="${ctx }/img/newbtn/btn_plxg_0.png" btn=btn title='批量修改' onClick="javascript:batchUpdate()">
							</c:if>
							<c:if test="${permissionPo.keyb=='1'}">	
								<img src="${ctx }/img/newbtn/btn_plsc_0.png" btn=btn title='批量删除' onClick="batchDetele()">
							</c:if>
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(MaxDiscountList)}"> 
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
                          <TH width="5%" scope=col><input id=chks type="checkbox" onclick="chkAll()">全选</TH>
                          <TH width="8%" scope=col colspan="2">操作</TH>
                          <TH width="8%" height="26" scope=col>商品类别</TH>
                          <TH width="15%" scope=col>制造商简称</TH>
                          <TH width="15%" scope=col>商品品种</TH>
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>商品成本折扣</TH>
						</TR>
						<s:iterator value="MaxDiscountList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <td>
                            <input id=chk type="checkbox" value="${fmdid}">
                          </td>
                          <TD width="4%"  height="26">
		                  	<c:if test="${permissionPo.keyc == 1}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${fmdid}')">
		                  	</c:if>
		                  </TD>
		                  <TD  width="4%">
		                  	<c:if test="${permissionPo.keyb == 1}">
		                     <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${fmdid}')">
		                  	</c:if>
		                  </TD>
                          <TD>${fmdgoodscategoryname }</TD>
                          <TD>${fmdsuppliername }</TD>
                          <TD>${fmdbrandname }</TD>
                          <Td>${fmdgoodsid}</Td>
                          <TD>${fmdgoodsname}</TD>                          
                          <TD>${fmdmaxdiscount }</TD>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>