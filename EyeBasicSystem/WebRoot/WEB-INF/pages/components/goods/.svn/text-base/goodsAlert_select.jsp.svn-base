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

    /**
	 *  初始化判断checkbox的状态
	 */
    function setCheckValue(){
        var chktext="";
        $("input[id=chk]",window.parent.document).each(function(){
			chktext=chktext+","+$(this).val();
		});

        $("input[id=chk]").each(function(){
         	if(chktext.indexOf($(this).attr("goodsid"))>=0){
              $(this).attr("checked","checked");
           }
		});
    }

	$(document).ready(function (){
		setCheckValue();
	});
	
	function search(){
		if(document.getElementById('departmentId').value!="" && document.getElementById('warehouseID').value ==""){
			alert('请选择仓位!');
			document.getElementById('warehouseID').focus();
			return;
		}
		$("img").removeAttr("onclick");	
		goodsForm.action = "selGoodsAlert.action";
		goodsForm.submit();
		showLoadingBar();
	}
	function clean(){
		document.getElementById('goodsID').value = "";
		document.getElementById('goodsName').value = "";

	    <c:if test="${empty(brandID_open) }">
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	    </c:if>
		
	    <c:if test="${empty(supplierID_open) }">
	    document.all.supplierID.value="";
	    document.all.supplierName.value="";
	    </c:if>
	    <c:if test="${empty(categoryID_open) }">
	    document.all.goodscategoryID.value="";
	    </c:if>
	    document.getElementById('alerttype').value = "";
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
        var chks=document.all.chks;
        if(window.parent.$("#bgiwhichretail").val()){
	        if(window.parent.$("#bgiwhichretail").val() != '${whichretail}'){
				alert("请选择同一种零售价格商品！");
				$('input[id=chks]').attr("checked","");
				return;
			}
        }
		
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
        if(chks.checked){
          setValue();
        }else{
          setDelValue();
        }
        
    }

	/**
	 *  调用单个页面赋值添加
	 */
    function setSingleValue(obj){
        var objValue="["+obj.value+"]";
        if(obj.checked==true){
           if(window.parent.$("#bgiwhichretail").val()){
        	    var goodInfos = eval('(' + objValue + ')');
				if(window.parent.$("#bgiwhichretail").val() != goodInfos[0].bgiwhichretail){
					alert("请选择同一种零售价格商品！");
					obj.checked = false;
					return;
				}
           }
           window.parent.openGoodSingleValues(objValue);
        }else if(obj.checked==false){
           window.parent.openGoodSingleDeleteValues(objValue);
        }
    }
	/**
	 *  调用页面赋值删除
	 */
	function setDelValue(){ 	         
        var objValue="";
        var count=0;

        $("input[id=chk]").each(function(){
         	if($(this).attr("checked")==false){
           	 if(objValue==""){
	           objValue=$(this).val();
	         }else{
	           objValue=objValue+","+$(this).val();
	         }
	         count++;  
	         }  
		});
        
         if(count==0){
          alert('请选择商品!');
          return false;
        }
        objValue="["+objValue+"]";
        window.parent.openGoodSingleDeleteValues(objValue);
        
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
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="brandID_open" value="${brandID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" id="departmentId" name="departmentId" value="${departmentId }" />
<input type="hidden" id="permissionPokeyg" name="permissionPokeyg" value="${permissionPokeyg }" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right">
            	<br/> </TD>
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
						   <TD width="9%" height="26" class="table_body">商品代码</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD width="9%" height="26" class="table_body">商品名称</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
                           <TD width="9%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID" ${not empty(categoryID_open) ? 'disabled="disabled"' : '' }>
      		                 <option value="">----请选择----</option>
      		                 <s:iterator value="goodsCategorys">
				               <option value="${bgcid}" ${goodscategoryID == bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
                        </TR>
                        <c:if test="${(systemParameterPo.fspisshowsupplierandbrand == '1') || departmenttype != '1' }"> 
                        <TR>
                           <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
					   			<li class="horizontal_onlyRight">
						   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
						   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
								</li>
					   			<li class="horizontal_onlyRight">
					   			<c:if test="${empty(supplierID_open)}">
					  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openSupplier();" >
		               			</c:if>
		               			</li>
			               </TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly" ${not empty(brandID_open) ? 'disabled="disabled"' : '' }>
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}" ${not empty(brandID_open) ? 'disabled="disabled"' : '' }/>
						   </li>
						   <li class="horizontal_onlyRight">
						   <c:if test="${empty(brandID_open)}">
						  	<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onClick="openBrand();">
						   </c:if>
						   </li>
			               </TD>
                        </TR>
                        </c:if>
 						<TR>	
 						   <TD height="26" class="table_body">仓位</TD>
			               <TD class="table_none" >
                            <select id="warehouseID" name="warehouseID">
                             <option value="" ${warehouseID == '' ? 'selected="selected"' : '' }>---请选择---</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${warehouseID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
                           <TD height="26" class="table_body">预警状态</TD>
			               <TD class="table_none" colspan="3">
                           <select id="alerttype" name="alerttype">
                             <option value="">----请选择----</option>
                             <option value="4" ${alerttype == '4' ? 'selected="selected"' : '' }>小于等于红色预警</option>
			                 <option value="3" ${alerttype == '3' ? 'selected="selected"' : '' }>大于红色预警并小于等于库存量下限</option>
			                 <option value="2" ${alerttype == '2' ? 'selected="selected"' : '' }>大于库存量下限并小于等于库存量上限</option>
			                 <option value="1" ${alerttype == '1' ? 'selected="selected"' : '' }>大于库存量上限</option>
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
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="12%" scope=col>商品代码</TH>
                          <TH width="12%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>单位</TH>
                          <TH width="5%" scope=col>零售价格</TH>
                          <TH width="5%" scope=col>型号</TH>
                          <TH width="5%" scope=col>颜色</TH>                          
                          <TH width="5%" scope=col>球镜</TH>
                          <TH width="5%" scope=col>柱镜</TH>
                          <TH width="5%" scope=col>轴向</TH>
                          <TH width="5%" scope=col>曲率</TH>
                          <TH width="5%" scope=col>直径</TH>  
                          <TH width="5%" scope=col>仓位</TH>                                                                                                                                 
                          <TH width="5%" scope=col>库存数量</TH>
                          <c:if test="${permissionPokeyg == '1'}"> 
                          <TH width="5%" scope=col>在途数量</TH>
                          </c:if>
                          <TH width="5%" scope=col>库存上限</TH>
                          <TH width="5%" scope=col>库存下限</TH>
                          <TH width="5%" scope=col>红色预警</TH>
                          <TH width="5%" scope=col>采购数量</TH> 
						  </TR>
						<c:forEach var="po" items="${goodsList}">
                        <c:if test="${po.alerttype eq '4' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: red;">   
                        </c:if>
						<c:if test="${po.alerttype eq '3' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: #9F0050;">   
                        </c:if>
                        <c:if test="${po.alerttype eq '2' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">   
                        </c:if>
                        <c:if test="${po.alerttype eq '1' }">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" style="color: blue;">   
                        </c:if>                       
                          <TD height="26">
                          <input type="checkbox" id="chk" goodsid="${po.bgigoodsid}" onclick="setSingleValue(this)"
                           value="{'bgisuppliername':'${po.bgisuppliername}','bgisupplierid':'${po.bgisupplierid}','bgigoodsid':'${po.bgigoodsid}','bgigoodsbarcode':'${po.bgigoodsbarcode}','bgigoodsname':'${po.bgigoodsname}','bgiunitname':'${po.bgiunitname}','bgicostprice':'${po.bgicostprice}','bgiretailprice':'${po.bgiretailprice}','bgitaxrate':'${po.bgitaxrate}',
                           'bginottaxrate':'${po.bginottaxrate}','bgispec':'${po.bgispec}','bgicolor':'${po.bgicolor}','bgisph':'${po.bgisph}','bgicyl':'${po.bgicyl}','bgiaxis':'${po.bgiaxis}','bgicurvature1':'${po.bgicurvature1}','bgidia':'${po.bgidia}', 
                           'bgiframematerialtype':'${po.bgiframematerialtype }','bgiframesize':'${po.bgiframesize}','bgiaccessoriestype':'${po.bgiaccessoriestype}',
                           'bgibelowplusluminosity':'${po.bgibelowplusluminosity }','bgirefractive':'${po.bgirefractive}','bgiismutiluminosity':'${po.bgiismutiluminosity}',
                           'bgieyeglassmaterialtype':'${po.bgieyeglassmaterialtype }','bgiusetype':'${po.bgiusetype}','bgistealthclass':'${po.bgistealthclass}',
                           'bgicapacity':'${po.bgicapacity }','bgicapacityentry':'${po.bgicapacityentry}','bgisuppliercolor':'${po.bgisuppliercolor}','bgiframematerialtypename':'${po.bgiframematerialtypename}',
                           'goodsquantity': '${permissionPokeyg == '1' ? (po.bgistorageupperlimit-po.bgigoodsquantity-po.zaitu) : (po.bgistorageupperlimit-po.bgigoodsquantity)}'}">
                          </TD>
                          <TD>${po.bgigoodsid}</TD>
                          <TD>${po.bgigoodsname}</TD>
                          <TD>${po.bgiunitname}</TD>
                          <TD>${po.bgiretailprice}</TD>
                          <TD>${po.bgispec}</TD>
                          <TD>${po.bgicolor}</TD>                          
                          <TD>${po.bgisph}</TD>
                          <TD>${po.bgicyl}</TD>
                          <TD>${po.bgiaxis}</TD>
                          <TD>${po.bgicurvature1}</TD>
                          <TD>${po.bgidia}</TD> 
                          <TD>${po.bgiwarehousename}</TD> 
                          <TD>${po.bgigoodsquantity}</TD>
                          <c:if test="${permissionPokeyg == '1'}"> 
                          <TD>${po.zaitu}</TD>
                          </c:if>
                          <TD>${po.bgistorageupperlimit}</TD>
                          <TD>${po.bgistoragelowerlimit}</TD>
                          <TD>${po.bgistorageredlimit}</TD>
                          <c:if test="${permissionPokeyg == '1'}"> 
                          <TD>${po.bgistorageupperlimit-po.bgigoodsquantity-po.zaitu}</TD>   
                          </c:if>
                          <c:if test="${permissionPokeyg != '1'}"> 
                          <TD>${po.bgistorageupperlimit-po.bgigoodsquantity}</TD>   
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
