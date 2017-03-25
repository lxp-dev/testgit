<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存预警</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	stockAlertSettingForm.action=link;
	  	stockAlertSettingForm.submit();
		showLoadingBar();
	}

	function search(){
		$("img").removeAttr("onclick");
		stockAlertSettingForm.action = "selStockAlertSetting.action";
		stockAlertSettingForm.submit();
		showLoadingBar();
	}	

	function clean(){
	    document.all.goodsID.value="";
	    document.all.goodsName.value="";
	    document.all.goodscategoryID.value="";
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    document.all.brandID.value="";
	    document.all.brandName.value="";
	    document.all.warehouseID.selectedIndex = 0;	    
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;

		//showPopWin("","selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】"
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
		var goodscategoryID= document.all.goodscategoryID.value;
	    var supplierID=document.getElementById('supplierID').value;

	    if(!supplierID) {
		    alert("请先选择制造商!");
		    return;
	    }

		//showPopWin("","selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】"
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
	// 镜片
	function insert(){
		//showPopWin("","initStockAlertSettingInsert.action?goodsType=0&moduleID=${requestScope.moduleID}", screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initStockAlertSettingInsert.action?goodsType=0&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initStockAlertSettingInsert.action?goodsType=0&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【镜片库存预警设置】"
	}
	
	// 非镜片
	function insert2(){
		//showPopWin("","initStockAlertSettingInsert.action?goodsType=1&moduleID=${requestScope.moduleID}", screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initStockAlertSettingInsert.action?goodsType=1&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initStockAlertSettingInsert.action?goodsType=1&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【非镜片库存预警设置】"
	}
	
	function update(id){
		//showPopWin("","initStockAlertSettingUpdate.action?id="+id+"&moduleID=${requestScope.moduleID}", screen.width-200,screen.height-200, '',null,true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initStockAlertSettingUpdate.action?id="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initStockAlertSettingUpdate.action?id="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【库存预警设置修改】"
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

    function batchUpdate(){
    	var billID='';				
		$('input[id=chk]:checked').each(function(){		
			if(billID.indexOf($(this).val())==-1){
				billID=billID+$(this).val()+',';
			}
		});
		if (billID == ''){
		    alert("请选择商品!");
		    return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initStockAlertSettingBatchUpt.action?billID="+billID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initStockAlertSettingBatchUpt.action?billID="+billID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【批量修改】";
    }
    
    function batchDetele(){    		
		var billID='';				
		$('input[id=chk]:checked').each(function(){		
			if(billID.indexOf($(this).val())==-1){
				billID=billID+$(this).val()+',';
			}
		});
		if (billID == ''){
		    alert("请选择商品!");
		    return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initStockAlertSettingBatchDel.action?billID="+billID,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【批量删除】";
    }

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="stockAlertSettingForm" method="post" action="">
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
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：库存量预警设置</TD>
            <TD align="right" vAlign=bottom>&nbsp;
             				<c:if test="${permissionPo.keyc=='1'}">	
								<img src="${ctx }/img/newbtn/btn_plxg_0.png" btn=btn title='批量修改' onClick="javascript:batchUpdate()">
							</c:if>
							<c:if test="${permissionPo.keyd=='1'}">	
								<img src="${ctx }/img/newbtn/btn_plsc_0.png" btn=btn title='批量删除' onClick="batchDetele()">
							</c:if>
             <c:if test="${permissionPo.keyb=='1'}">	
            	<img src="${ctx }/img/newbtn/btn_jplkcyjsz_0.png" btn=btn title="镜片库存预警设置" onClick="insert()">
            	<img src="${ctx }/img/newbtn/btn_fjplkcyjsz_0.png" btn=btn title="非镜片库存预警设置" onClick="insert2()">
             </c:if>
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"  />
            </TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            <table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="goodsID" name="selGoodsID" value="${selGoodsID }" maxlength="25">
			               </TD>
			               <TD width="9%" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none" width="24%">
                            <input class="text_input160" type="text"  id="goodsName" name="selGoodsName" value="${selGoodsName }" maxlength="40">
			               </TD>
                           <TD width="9%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="selGoodscategoryID"}>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${selGoodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
                        </TR>
                        <TR>			 
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" name="selSupplierName" value="${selSupplierName }" readonly="readonly"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="selSupplierID" value="${selSupplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" btn=btn name=ctl00$PageBody$Button1 onClick="openSupplier();">
						  				</li>
			               </TD>              
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="selBrandName" value="${selBrandName }" readonly="readonly">
						   		<input type="hidden" id="brandID" name="selBrandID" value="${selBrandID }"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" btn=btn onClick="openBrand();">			
						  </li>
			               </TD>
						   <TD height="26" class="table_body">仓位</TD>
			               <TD class="table_none">
                            <select id="warehouseID" name="selWarehouseID">
                            <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${selWarehouseID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
                        </TR>
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							<c:if test="${permissionPo.keya=='1'}">	
								<img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
					<c:if test="${not empty(alertList)}"> 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </table>

					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle height="26">
                          <th width="3%" scope=col><input id=chks type="checkbox" onclick="chkAll()"></th>
                          <th width="4%" scope=col>操作</th>
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH scope=col>商品名称</TH>                 
                          <TH width="17%" scope=col>制造商简称</TH>  
                          <TH width="18%" scope=col>品种名称</TH>
                          <th width="8%" scope=col>仓位名称</th>
                          <TH width="6%" scope=col>库存上限</TH>
                          <TH width="6%" scope=col>库存下限</TH>
                          <TH width="6%" scope=col>红色预警</TH>
						  </TR>
						<c:forEach var="alert" items="${alertList}" varStatus="index">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                         <td>
                            <input id=chk type="checkbox" value="${alert.csasaid }">
                        </td>
                        <td>
                        <img btn=btn src="${ctx }/img/newbtn/edit_0.png" title='修改' onclick="update('${alert.csasaid }')" >
                        </td>
						  <td height="26">${alert.csasagoodsid }</td>
						  <td>${alert.csasagoodsname }</td>
                          <td>${alert.csasasuppliername }</td>
                          <td>${alert.csasabrandname }</td>
                          <td>${alert.csasawarehouseName }</td>
                          <td>${alert.csasastockcap }</td>
                          <td>${alert.csasastocklower }</td>
                          <td>${alert.csasastockred }</td>
						</TR>
						</c:forEach>
                      </TBODY>
                    </table>
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
<%@ include file="/WEB-INF/inc/message.jsp" %>
