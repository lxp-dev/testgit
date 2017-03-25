<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>仓库管理</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	procurementReceiptForm.action=link;
	  	procurementReceiptForm.submit();
		showLoadingBar();
	}

	function search(){
		var sid = $('#supplierID').val();
		var sname = $('#supplierName').val();

		var warehouseID = $("#warehouseID").val();
		var goodscategoryID= document.all.goodscategoryID.value;

		if(!goodscategoryID){
			alert("请选择商品类别！");
			return;
		}

		if(sid == '' || sname == ''){
			alert("请选择制造商！");
			return;
		}
		
		if(warehouseID == ''){
			alert("请选择仓位！");
			return;
		}
		
		$("img").removeAttr("onclick");
		procurementReceiptForm.action = "selOpenInvisible.action";
		procurementReceiptForm.submit();
		showLoadingBar();
	}	

	function clean(){
	    document.all.goodsID.value="";
	    document.all.goodsName.value="";
	    document.all.goodscategoryID.value="";
	    if ('${empty(supplierID_open)}' == true){
		    document.all.supplierID.value="";
		    document.all.supplierName.value="";
		}
	    document.all.brandID.value="";
	    document.all.brandName.value="";
	    document.all.warehouseID.value="";	
	    document.all.goodsBarcode.value="";
	    document.all.RetailPrice.value="";
	    document.all.sumnum.value="";
	    document.all.sumnum1.value="";
	    document.all.invisibletype.value="";
	    document.all.maxandmin.value="";
	    document.all.mindown.value="";
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
			/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodscategoryID= document.all.goodscategoryID.value;

		if(!goodscategoryID){
			alert("请选择商品类别！");
			return;
		}
		
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
	    var supplierID=document.getElementById('supplierID').value;
	    var goodscategoryID= document.all.goodscategoryID.value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + document.getElementById('supplierID').value,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种 查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}

	function amount(){
    	var goodsquantityTotal = 0;

		var goodsquantity = document.getElementsByName("sxhsumnum");
		
		for(i=0;i<goodsquantity.length;i++){
			if(goodsquantity[i].value == '') continue;
			goodsquantityTotal = (parseFloat(goodsquantityTotal).add(parseFloat(goodsquantity[i].value))).toFixed(0);
		}
		if(document.getElementById("goodsquantityTotal")!=null){
			document.getElementById("goodsquantityTotal").innerText=goodsquantityTotal;
		}
	}
	
	$(document).ready(function(){
		amount();
	});
	
	function selectContact(obj){
		var act = document.activeElement.id; 
		
		if(act == "pageNos"){
			$('#'+act).onkeyup();
		}else{
			if(event.keyCode==13){
				search();
			}
		}
	}
	/**
	 *  调用单个页面赋值添加
	 */
    function setSingleValue(obj){
        var objValue="["+obj.value+"]";
        if(obj.checked==true){
        	var goodInfos = eval('(' + objValue + ')');
           window.parent.openGoodSingleValues(objValue);
        }else if(obj.checked==false){
           // alert(1)
           window.parent.openGoodSingleDeleteValues(objValue);
        }
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
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chks=document.all.chks;

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
    $(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
			$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
			$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		setCheckValue();
	});
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } onkeyup="selectContact(this)">
<form name="procurementReceiptForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="supplierID_open" value="${requestScope.supplierID_open}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          
          <TR>
            <TD align="right" colspan="3">
          <br/></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
		  </TD>
		</TR>
		
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
			               <TD class="table_none" width="23%">
                            <input class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			              
						   <TD width="8%" height="26" class="table_body" >商品条码</TD>
			               <TD class="table_none" width="23%">
                            <input class="text_input160" type="text"  id="goodsBarcode" name="goodsBarcode" value="${goodsBarcode}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <select id="goodscategoryID" name="goodscategoryID"}>
      		                   <option value="">----请选择----</option>
      		                   <option value="4" ${goodscategoryID == 4 ? 'selected="selected"' : '' }>隐形</option>
      		                   <option value="5" ${goodscategoryID == 5 ? 'selected="selected"' : '' }>护理液</option>
      	                   </select>
			               </TD>
                        </TR>
                        <TR>
                           
					       <TD height="26" class="table_body">商品名称</TD>
			               <TD class="table_none">
                            <input class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" readonly="readonly" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${not empty(supplierID_open) ? supplierID_open:supplierID }"/>
									</li>
									<c:if test="${empty(supplierID_open)}">
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
						  			</li>
						  			</c:if>
			               </TD>			               
						   <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						  </li>
			               </TD>
                        </TR>
					      <TD height="26" class="table_body">仓位名称</TD>
			               <TD class="table_none">
                            <select id="warehouseID" name="warehouseID">
                               <option value="">----请选择----</option>
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid}" ${stockID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>
			                <TD height="26" class="table_body">仓储数量</TD>			            
			                <TD class="table_none">
			                	<input class="text_input100" type="text" id="sumnum" name="sumnum" value="${requestScope.sumnum}">—<input class="text_input100" type="text"  id="sumnum1" name="sumnum1" value="${requestScope.sumnum1}">
                        	</TD>
                        	<TD height="26" class="table_body">单价</TD>			            
			                <TD class="table_none">
			                	<input class="text_input160" onkeypress="var k=event.keyCode; if ((k==46)||(k<=57 && k>=48)) return true;else return false" type="text"  id="RetailPrice" name="RetailPrice" value="${requestScope.RetailPrice}">
                        	</TD>
                        </TR>
                        <tr>                        	
                        	<TD height="26" class="table_body">效期状态</TD>			            
			                <TD class="table_none">
								<select id="invisibletype" name="invisibletype">
								   <option value="">----请选择----</option>
								   <option value="1" ${invisibletype == '1' ? 'selected=selected':'' }>正常贮备</option>
								   <option value="2" ${invisibletype == '2' ? 'selected=selected':'' }>滞销退货</option>
								   <option value="3" ${invisibletype == '3' ? 'selected=selected':'' }>即将失效</option>
								   <option value="4" ${invisibletype == '4' ? 'selected=selected':'' }>已失效</option>
							    </select>
                        	</TD>			            
			                <TD class="table_none" colspan="2">
			                	<input class="text_input160" type="text" id="maxandmin" name="maxandmin" value="${maxandmin }">
			                	天内进入滞销退货期 
                        	</TD>
                        	<TD class="table_none" colspan="2">
			                	<input class="text_input160" type="text" id="mindown" name="mindown" value="${mindown }">
			                	天内将失效 
                        	</TD>
                        </tr>
                      </TBODY>
                    </table>
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
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<c:if test="${not empty(goodsDetailsList)}"> 
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
                        <TR class=table_title align=middle>     
                          <TH width="5%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                  
                          <TH width="10%" scope=col>商品代码</TH>
                          <TH width="12%" scope=col>商品条码</TH>
                          <TH width="13%" scope=col>商品名称</TH>
                          <TH width="5%" scope=col>商品类别</TH>
                          <TH width="10%" scope=col>所属制造商</TH> 
                          <TH width="5%" scope=col>贮备状态</TH>   
                          <TH width="5%" scope=col>有效天数</TH>  
                          <TH width="7%" scope=col>失效日期</TH>                      
                          <TH width="5%" scope=col>零售价格</TH>
                          <TH width="5%" scope=col>仓位</TH>
                          <TH width="4%" scope=col>数量</TH>
						</TR>
						<TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=11 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>  
						<s:iterator value="goodsDetailsList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">    
                          <TD height="26">
                          <input type="checkbox" id="chk" onclick="setSingleValue(this);" goodsid='${sxhGoodsBarCode}' 
                           value="{'bgigoodsid':'${sxhGoodsId}','bgipcbarcode':'${sxhGoodsBarCode}','bgigoodsbarcode':'${sxhGoodsBarCode}','bgigoodsname':'${sxhGoodsName}','bgiunitname':'${sxhunitname}','bgicostprice':'${sxhcostprice}','bgiretailprice':'${sxhRetailPrice}','bgitaxrate':'${sxhtaxrate}',
                           'bginottaxrate':'${sxhnottaxrate}','bgispec':'${sxhspec}','bgisuppliername':'${sxhSupplierName }','bgisupplierid':'${sxhSupplierID }','bginumber':'${sxhsumnum }','cshaaemaxquantity':'${sxhsumnum }','bgigoodsquantity':'${sxhsumnum }'}">
                          </TD>
                          <TD>${sxhGoodsId}</TD>
                          <TD>${sxhGoodsBarCode}</TD>
                          <TD>${sxhGoodsName}</TD>
                          <TD>${sxhGoodsCategoryName}</TD>                          
                          <TD>${sxhSupplierName}</TD>
                          <TD>${sxhinvisibletype }</TD>
                          <TD><c:if test="${sxhinvisibletype =='未设置'}">--</c:if><c:if test="${sxhinvisibletype !='未设置'}">${sxhDay }</c:if></TD>
                          <TD>${sxhguaranteeperiod }</TD>
                          <TD>${sxhRetailPrice}</TD>
                          <TD>${sxhWarehouseName}</TD>
                          <TD>${sxhsumnum}<input type="hidden" name="sxhsumnum" value="${sxhsumnum}"/></TD>                          
						</TR>
						</s:iterator>
						<TR class=table_title align=middle> 
						  	<TH width="40%" height="26" colSpan=11 scope=col align="right">库存合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%">${titlenum}</TH>
				   		</TR>  
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