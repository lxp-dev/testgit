<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品调价管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	adjustmentPriceForm.action=link;
	  	adjustmentPriceForm.submit();
		showLoadingBar();
	}
	function search(){
		if($('#goodscategoryID').val()==''){
			alert('请选择商品类别!');
			return;
		}
		if($('#supplierName').val()==''){
			alert('请选择制造商!');
			return;
		}
		if($('#brandName').val()==''){
			alert('请选择商品品种!');
			return;
		}
		if(parseFloat(document.getElementById('sphup').value)>parseFloat(document.getElementById('sphul').value)){
			alert('球镜下限大于上限，请重新选择!');
			return;
		}
		if(parseFloat(document.getElementById('cylup').value)>parseFloat(document.getElementById('cylul').value)){
			alert('柱镜下限大于上限，请重新选择!');
			return;
		}
		
		adjustmentPriceForm.action = "moreAdjustmentPriceSel.action";
		adjustmentPriceForm.submit();
		showLoadingBar();
	}
	function clean(){
	    $('input[type!=select]').each(function(){
	 		$(this).val('');
	 	}
	 	)
	 	$("select").attr("value","");
	 	$("#goodscategoryID").attr("value","");
	 	$('#glassType').attr("value","0");
	 	$('#sphAndCylTr').hide();
   		$('#glassTypeContent').hide();
   		$('#glassType').hide();
   		$('#cols').get(0).colSpan="3";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
		/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;
		if(goodscategoryID==''){
			alert('请先选择商品分类!');
			return;
		}
		//showPopWin("","selSupplierOpen.action?categoryID_open="+goodscategoryID,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商添加】";
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
		if(goodscategoryID==''){
			alert('请先选择商品分类!');
			return;
		}
		if(supplierID==''){
			alert('请先选择制造商!');
			return;
		}
		//showPopWin("","selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value ,screen.width-200,screen.height-200, '', null, true);
		//selectHidden();
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种添加】";
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
	function setValue(){ 	         
        var chk=document.getElementsByName("chk");
        var objValue="";
        var count=0;
        for(var i=0;i<chk.length;i++){
           if(chk[i].checked==true){
           	 if(objValue==""){
	           objValue=chk[i].value;
	         }else{
	           objValue=objValue+","+chk[i].value;
	         }  
	         count++;          
           }
        }
        if(count==0){
          alert('请选择商品!');
          return false;
        }
        objValue="["+objValue+"]";
        window.parent.openGoodSingleValues(objValue);
        alert('您选择的商品信息已添加到商品列表中！');
        
	}
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
   	$(document).ready(function(){
   		$('#sphAndCylTr').hide();
   		$('#glassTypeContent').hide();
   		$('#glassType').hide();
   		$("#sphup").attr("value",'${sphup}');
   		$("#sphul").attr("value",'${sphul}');
   		$("#cylul").attr("value",'${cylul}');
   		$("#cylup").attr("value",'${cylup}');
   		
   		if($('#goodscategoryID').val()=='3'||$('#goodscategoryID').val()=='4'){
   				$('#glassType').show();
   				$('#glassTypeContent').show();
   				$('#cols').get(0).colSpan="1";
   				$('#sphAndCylTr').show();
   		}
   		$('#goodscategoryID').bind("change",function(){
   			if($(this).val()=='3'||$('#goodscategoryID').val()=='4'){
   				$('#glassType').show();
   				$('#glassTypeContent').show();
   				$('#cols').get(0).colSpan="1";

   			}else{
   				$('#glassType').hide();
   				$('#glassTypeContent').hide();
   				$('#cols').get(0).colSpan="3";
   			}
   			if($(this).val()=='3'||$(this).val()=='4'){
   				$('#sphAndCylTr').show();
   			}else{
   				$('#sphAndCylTr').hide();
   			}
   		})
   	});
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
<form name="adjustmentPriceForm" method="post" action="">


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
          background=${ctx}/img/pic/tab_bg.gif>
            </TD>
					</TR></TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD  width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
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
                           <TD width="60" height="30" class="table_body">商品类别</TD>
			               <TD class="table_none" id="cols" colspan="3">
                            <select id="goodscategoryID" name="goodscategoryID" ${not empty(categoryID_open) ? 'disabled="disabled"' : '' }>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>

			               </TD>
			               <TD id="glassType" height="30" class="table_body">镜片型</TD>
			               <TD class="table_none" id="glassTypeContent">
                                 	                    <select id="glassType" name="glassType" >
                                 	                   <c:if test="${glassType eq '0' || empty(glassType)}">
      	                    <option value="0" selected="selected">成品片</option>
      	                    <option value="D" >订做片</option>
      	                    </c:if>
      	                    
      	                      <c:if test="${glassType eq 'D'}">
      	                    <option value="0" >成品片</option>
      	                    <option value="D" selected="selected">订做片</option>
      	                    </c:if>
      	                    </select>
			               </TD>
                        <TD height="30" class="table_body">制造商简称</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}"  readonly="readonly"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
						  				</li>
						   	</TD>	               
						   <TD height="30" class="table_body">商品品种</TD>
			               <TD class="table_none" >
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						  </li>
			               </TD>
			               
			               
                        </TR>
                          	<TR id="sphAndCylTr">
						   <TD height="30" class="table_body">球镜度数</TD>
			               <TD class="table_none" colspan="3">
			               			 <select id="sphul" name="sphul">
                        <option value="" selected>请选择球镜上限</option>
                       <c:forEach var="x" begin="1" end="205" step="1" varStatus="index">
			               				<c:set var="lens" value="${20.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>">${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
                      </select>
                            &nbsp;至&nbsp;<select id="sphup" name="sphup">
                        <option value="" selected>请选择球镜下限</option>
                      <c:forEach var="x" begin="1" end="205" step="1" varStatus="index">
			               				<c:set var="lens" value="${20.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>">${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach></select>
			               </TD>
			               <TD class="table_body">柱镜度数</TD>
			               <TD class="table_none" colspan="3">
			               <select id="cylul" name="cylul">
                        <option value="" selected>请选择柱镜上限</option>
                       <c:forEach var="x" begin="1" end="25" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
										<option value="<fmt:formatNumber value="${lens }" pattern="0.00"/>"><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach></select>
                              &nbsp;至&nbsp;<select id="cylup" name="cylup">
                        <option value="" selected>请选择柱镜下限</option>
                        <c:forEach var="x" begin="1" end="25" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
										<option value="<fmt:formatNumber value="${lens }" pattern="0.00"/>"><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
                      </select>
			               </TD>

                        </TR>
                        
                        
                        
                      </TBODY>
                    </TABLE>
                	<TABLE id="title2" cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
	                    <TBODY>
		                    <TR>
		                      <TD align="left">
		                      <img id="submitButton" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
										<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
										<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="setValue();" >
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
                          <TH width="8%" height="30" scope=col>全选<input type="checkbox" id="chks" name="chks" onclick="chkAll()"></TH>                        
                          <TH width="15%" scope=col>商品代码</TH>
                          <TH width="15%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>单位</TH>
                          <TH width="8%" scope=col>成本价格</TH>
                          <TH width="8%" scope=col>型号</TH>
                          <TH width="6%" scope=col>颜色</TH>                          
                          <TH width="7%" scope=col>球镜</TH>
                          <TH width="7%" scope=col>柱镜</TH>
                          <TH width="7%" scope=col>轴向</TH>
                          <TH width="7%" scope=col>曲率</TH>
                          <TH width="7%" scope=col>直径</TH>                                                                                                                                  

						  </TR>
						<s:iterator value="goodsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">                         
                          <TD height="28">
                          <input type="checkbox" id="chk"  name="chk" 
                           value="{'bgigoodsid':'${bgigoodsid}','bgigoodsbarcode':'${bgigoodsbarcode}','bgigoodsname':'${bgigoodsname}','bgiunitname':'${bgiunitname}','bgicostprice':'${bgicostprice}','bgiretailprice':'${bgiretailprice}','bgitaxrate':'${bgitaxrate}',
                           'bginottaxrate':'${bginottaxrate}','bgispec':'${bgispec}','bgicolor':'${bgicolor}','bgisph':'${bgisph}','bgicyl':'${bgicyl}','bgiaxis':'${bgiaxis}','bgicurvature1':'${bgicurvature1}','bgidia':'${bgidia}','bgibrandname':'${bgibrandname}','bgiwholesaleprice':'${bgiwholesaleprice}'}">
                          </TD>
                          <TD>${bgigoodsid}</TD>
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgiunitname}</TD>
                          <TD>${bgicostprice}</TD>
                          <TD>${bgispec}</TD>
                          <TD>${bgicolor}</TD>                          
                          <TD>${bgisph}</TD>
                          <TD>${bgicyl}</TD>
                          <TD>${bgiaxis}</TD>
                          <TD>${bgicurvature1}</TD>
                          <TD>${bgidia}</TD>                        
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
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>


