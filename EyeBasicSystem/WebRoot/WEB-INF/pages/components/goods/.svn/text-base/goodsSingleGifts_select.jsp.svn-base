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
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 
	function search(){
		$("img").removeAttr("onclick");
		goodsForm.action = "selGoodsSingleGifts.action";
		goodsForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('goodsID').value = "";
		document.getElementById('goodsName').value = "";
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('goodscode').value = "";
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    document.all.goodscategoryID.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;

		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var goodscategoryID= document.all.goodscategoryID.value;
	    var supplierID=document.getElementById('supplierID').value;
	    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	 *  调用页面赋值删除
	 */
	function setDelValue(obj){
		var json = eval('(' + obj + ')');
		$(parent.$('input[name=giftsPo.bgsgoodsid]')).each(function(){
    		if($(this).val() == json[0].bgsgoodsid){
    			$(this).parent().parent().remove();
        	}
		});
	}
		
	/**
	 *  调用页面赋值
	 */
	function setValue(obj){

		var objValue="["+obj.value+"]";
		if($(obj).attr("checked") == false){
			setDelValue(objValue);
			return;
	    }
	    
	    if('${systemParameterPo.fspsalestype}' == '1'){	    	    
	        window.parent.addGifts(objValue);
		}else{
			var json = eval('(' + objValue + ')');
			var num = accSub(Number(json[0].bgigoodsquantity),Number(json[0].bgiintransitgoodsnum));
			if(Number(num) > 0 || $('#iscustomize').val()=='D' || '${oneselfframe}'=='ZZ'){
				window.parent.addGifts(objValue);
			}else{
				alert("该商品库存不足！");
				$("input[goodsid="+json[0].bgsgoodsid+"]").attr("checked","");
				return;
			}
		}
	}

	function inTransitDetail(goodsid,goodsbarcode,warehouseid,flag){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("getGoodsInTransitDetail.action?goodsID="+goodsid+"&goodsBarCode="+goodsbarcode+"&warehouseID="+warehouseid+"&flag="+flag,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("getGoodsInTransitDetail.action?goodsID="+goodsid+"&goodsBarCode="+goodsbarcode+"&warehouseID="+warehouseid+"&flag="+flag,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【商品在途库存详细】";
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" id="isrefresh" value="1" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	<br/></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
					  	<TR>
						   <TD width="60" height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD width="60" height="26" class="table_body">商品条码</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodscode" name="goodscode" value="${requestScope.goodscode}">
			               </TD>
                           <TD width="60" height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
                        </TR>
                        <TR>
                         <TD width="60" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" ${systemParameterPo.fspisshowsupplierandbrand == '1' ? '' : 'colspan="5"'}>
                            <select id="goodscategoryID" name="goodscategoryID" >
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                    </select>
			               </TD>
			               <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1'}">
                         <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } readonly="readonly"/>
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						   				<c:if test="${empty(supplierID_open)}">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();" ></li>
						   				</c:if>
						   	</TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();"></li>
			              </TD>
			              </c:if>
                        </TR>
                          <TR>
						   <TD class="table_body" height="26">赠品类型</TD>
                            <TD class="table_none" colspan="5">
                          	  <select id="typeid" name="typeid">
                          	  <option value=""></option>
                          		<option value="1" ${typeid eq '1'? ' selected':''}>门店赠品类</option>
                          		<option value="2" ${typeid eq '2'? ' selected':''}>通用赠品类</option>
                          	  </select>
                            </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
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
					<!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col>选择</TH>                      
                          <TH scope=col>商品代码</TH>
                          <TH scope=col>商品名称</TH>
                          <TH scope=col>赠品类型</TH>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1'}">
                          <TH scope=col>制造商</TH>
                          </c:if>
                          <TH scope=col>单位</TH>
                          <TH scope=col>零售价格</TH>
                          <TH scope=col>型号</TH>
                          <TH scope=col>颜色</TH>
                          <TH scope=col>仓位</TH>
                          <TH scope=col>数量</TH>
                         <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}">   
                          <TH scope=col>在途数量</TH>
                         </c:if>
						</TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="26">
                           <input type="checkbox" id="chk"  onClick="setValue(this);" goodsid="${bgigoodsid}"
                           value="{'bgsgoodsid':'${bgigoodsid}','bgsgoodsbarcode':'${bgigoodsbarcode}','bgigoodsname':'${bgigoodsname}','bgiunitname':'${bgiunitname}','bgscostprice':'${bgicostprice}','bgiretailprice':'0.00','bgitaxrate':'${bgitaxrate}',
                           'bgsnottaxrate':'${bginottaxrate}','bgsgoodstype':'','bgicolor':'${bgicolor}','bgsviewname':'${bgigoodsname}','bgicyl':'${bgicyl}','bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}','bgibrandname':'${bgibrandname}','bgisuppliername':'${bgisuppliername }','bgisupplierid':'${bgisupplierid }',bgisource:'${bgisource }','bgiwarehousename':'${bgiwarehousename}','bgiwarehouseid':'${bgiwarehouseid}','bgigoodsquantity':'${bgigoodsquantity}','bgiintransitgoodsnum':'${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}'}">
                          </TD>
                          <TD>${bgigoodsid}</TD>
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgigifttype eq '1'? '门店赠品类':'通用赠品类'}</TD>
                          <c:if test="${systemParameterPo.fspisshowsupplierandbrand == '1'}">
                          <TD>${bgisuppliername}</TD>
                          </c:if>
                          <TD>${bgiunitname}</TD>
                          <TD>0.00</TD>
                          <TD>${bgispec}</TD>
                          <TD>${bgicolor}</TD>
                          <TD>${bgiwarehousename}</TD>
                          <TD>${bgigoodsquantity}</TD>
                      <c:if test="${systemParameterPo.fspintransitstorageflag == '1'}"> 
                          <TD><a href="javascript:inTransitDetail('${bgigoodsid}','${bgigoodsbarcode}','${bgiwarehouseid}','0');">${empty(bgiintransitgoodsnum) ? '0':bgiintransitgoodsnum}</a></TD>  
                      </c:if>                        
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
    <TD height=5>&nbsp;</TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
