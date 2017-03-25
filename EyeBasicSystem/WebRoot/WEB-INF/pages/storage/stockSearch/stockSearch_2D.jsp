<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/select_many_checked.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
<title>库存综合查询(二维)</title>
</head>

<script>
	$(document).ready(function() {
		if ('${usingWarehouse}' == '1'){
			$("#warehouseID").hide();      
		}

		if ('${usingWarehouse}' == '0'){
			$("#warehouseID3").hide();      
		}
				
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		showAndHideSalsedate();
	});

	function search(){

        if ('${wCount}' == '0') {
            alert('系统中未设置仓位，请先建立仓位之后再查询库存！');
            return
        }
		
		if('${systemParameterPo.fspisshowsupplierandbrand}' == '1'){
			if ($('#categoryID').val() == ''){
			    alert('请选择商品类别!');
			    return;
			}
			if ($('#supplierID').val() == ''){
			    alert('请选择制造商!');
			    return;
			}
		}
		if ($('#brandID').val() == ''){
		    alert('请选择商品品种!');
		    return;
		}


	    if (document.getElementById("usingWarehouse").value=='0'){
	    	document.getElementById("warehouseIDs").value=$('#warehouseID').val();
	    }else if (document.getElementById("usingWarehouse").value=='1'){
	    	document.getElementById("warehouseIDs").value=$('#warehouseID3').val();
	    }
	    
		if ($('#warehouseIDs').val() == ''){
		    alert('请选择仓位!');
		    return;
		}
			    
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
			if('${fquartzSwitchPo.fqswzhzstd}'=='2'){
				var DataURL = "selectStockSearch2D.action?goodsCategoryID="+$('#categoryID').val()+"&supplierID="+$('#supplierID').val()+"&brandID="+$('#brandID').val()+"&warehouseID="+$('#warehouseIDs').val()+"&queryType="+$("input[name=queryType]:checked").val()+"&makeinvoiceflag="+$("#makeinvoiceflag").val()+"&startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val();
			}else{
				var DataURL = "selectStockSearch2D.action?goodsCategoryID="+$('#categoryID').val()+"&supplierID="+$('#supplierID').val()+"&brandID="+$('#brandID').val()+"&warehouseID="+$('#warehouseIDs').val()+"&queryType="+$("input[name=queryType]:checked").val()+"&startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val();
			}	
		if(is_iPad()){
			showPopWin(DataURL,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(DataURL,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}	
		if($("input[name=queryType]:checked").val()==1){	
			document.getElementById('popupTitle').innerHTML="【库存综合查询(二维)】";
		}else if($("input[name=queryType]:checked").val()==2){
			document.getElementById('popupTitle').innerHTML="【销售综合查询(二维)】";
		}else{
			document.getElementById('popupTitle').innerHTML="【销售库存对比综合查询(二维)】";
		}
	}

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
        var goodscategoryID=document.getElementById('goodsCategoryID').value;
		if (goodscategoryID == ''){
		    goodscategoryID = $('#categoryID').val();
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
		var goodscategoryID=document.getElementById('goodsCategoryID').value;
		if (goodscategoryID == ''){
		    goodscategoryID = $('#categoryID').val();
		}	
	    var supplierID=document.getElementById('supplierID').value;
        if (supplierID == ''){
            alert("请选择制造商!");
            return;
        }
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
	 * 品种开窗
	 */
	function openBrand1(){
		var goodscategoryID=document.getElementById('goodsCategoryID').value;
		if (goodscategoryID == ''){
		    goodscategoryID = $('#categoryID').val();
		}
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpenWithoutSupplier.action?categoryID_open="+goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpenWithoutSupplier.action?categoryID_open="+goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues1(json){
		document.getElementById('categoryID').value = json.categoryID;
		document.getElementById('supplierID').value = json.supplierID;
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
	}
    
    function changeCategory(obj){
        $('#goodsCategoryID').val(obj.value);
        document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('supplierID').value = "";
		document.getElementById('supplierName').value = "";
    }
    
    function changeWarehouse(val){
		$('#usingWarehouse').val(val);

	    if (val=='0'){
			$("#warehouseID").show();
			$("#warehouseID3").hide();
	    }else if (val=='1'){
			$("#warehouseID").hide();
			$("#warehouseID3").show();		
	    
	    }
	}
    /** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }
        return format;
    }
	
	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	function showAndHideSalsedate(){
		var salseDateFlg=$("input[name=queryType]:checked").val();
		if(salseDateFlg==1){
			$("#salseDate").hide();
		}
		if(salseDateFlg==2){
			$("#salseDate").show();
		}
		if(salseDateFlg==3){
			$("#salseDate").show();
		}
	}
</script>
<script>

</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<input type="hidden" id="categoryID_open" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" id="supplierID_open" name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" id="warehouseIDs" name="warehouseID" value="${warehouseID}">
<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" />
<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx }/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>库存管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：库存综合查询</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
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
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initStockSearchSel.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">商品库存实时查询</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存综合查询(二维)</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    
        <c:if test="${departmenttype eq '3'}">                      
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initSelectStockSearchWarehouse.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">库存综合查询(仓位)</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
        </c:if>               
                 <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onClick="JavaScript:window.location.href='initSelectStockSearchAnyTimeSel.action?moduleID=${requestScope.moduleID}' ;"
                      UNSELECTABLE="on">任意时段商品库存查询(任意时段)</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>            
         
                    </TR></TBODY></TABLE></TD>
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
                      	 <TD width="60" height="26" class="table_body">查询类型</TD>
                      	 <TD class="table_none" colspan="5">
                      	 	 <input type="radio" name="queryType"  value="1" checked="checked" onclick="showAndHideSalsedate();">库存
                      	 	 <c:if test="${departmenttype eq '3'}"> 
      	                   	 <input type="radio" name="queryType" value="2"  onclick="showAndHideSalsedate();">销售
      	                   	 <input type="radio" name="queryType" value="3"  onclick="showAndHideSalsedate();">销售库存对比
      	                   	 </c:if>
                      	 </TD>
                      </TR>
                        <TR>
                           <TD width="60" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <input type="hidden" id="goodsCategoryID" name="goodsCategoryID" value="${categoryID_open}"/>
                            <select id="categoryID" onchange="changeCategory(this)">
                                <option value="3" ${goodsCategoryID == '3' ? 'selected="selected"' : '' }>框镜成品镜片</option>
                                <option value="4" ${goodsCategoryID == '4' ? 'selected="selected"' : '' }>隐形成品镜片</option>
                            </select>
			               </TD>
			               <c:if test="${systemParameterPo.fspisshowsupplierandbrand eq '1' || person.departmenttype eq '3'}">
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input200" name="supplierName" value="${supplierName}" readonly="readonly"/>
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn  title="选 择" onclick="openSupplier()"></li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onclick="openBrand();"></li>
			               </TD>
			               </c:if>
			               <c:if test="${systemParameterPo.fspisshowsupplierandbrand ne '1' && person.departmenttype ne '3'}">
			               <TD height="26" class="table_body">商品品种</TD>
			               <TD class="table_none" colspan="3">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input200" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" onclick="openBrand1();"></li>
			               </TD>
			               </c:if>
                        </TR>
                        <TR>			               
						   <TD height="26" class="table_body">仓位名称</TD>
			               <TD class="table_none" colspan="5">
							<input type="hidden" id="usingWarehouse" name="usingWarehouse" value="${usingWarehouse}">
      	                    <input type="radio" id="radioBtn_0" name="radioBtn" value="0" onclick="changeWarehouse('0');" ${usingWarehouse == '0' ? 'checked' : '' }>启用仓
      	                    <input type="radio" id="radioBtn_1" name="radioBtn" value="1" onclick="changeWarehouse('1');" ${usingWarehouse == '1' ? 'checked' : '' }>停用仓
	      	                </li>&nbsp;&nbsp;&nbsp;
	      	                   <li class="horizontal_onlyRight">
	      	                   <select id="warehouseID" name="warehouseID2">
	                           	<option value="">----请选择----</option>
	      		                 <s:iterator value="warehouselist">
					               <c:if test="${bwhisclosed == '0'}">
					                   <option value="${bwhid}" ${warehouseID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option><!--${warehouseID == bwhid ? 'selected="selected"' : '' }  -->
					               </c:if>
		     	                 </s:iterator>
	      	                   </select>
	      	                   
	      	                   <select id="warehouseID3" name="warehouseID3">
	                           	<option value="">----请选择----</option>
	      		                 <s:iterator value="warehouselist">
					               <c:if test="${bwhisclosed == '1'}">
					                   <option value="${bwhid}" ${warehouseID == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option><!--${warehouseID == bwhid ? 'selected="selected"' : '' }  -->
					               </c:if>
		     	                 </s:iterator>
	      	                   </select>
	      	                   </li>
			               </TD>
                        </TR>
 						<c:if test="${fquartzSwitchPo.fqswzhzstd==2}">  
                        <TR>  
                          <TD height="26" class="table_body">是否开票</TD>
                          <TD class="table_none" colspan="5">
                               <select id="makeinvoiceflag" name="makeinvoiceflag" value="${requestScope.makeinvoiceflag}">
                                    <option value="" ${requestScope.makeinvoiceflag!= ""  ? '' : 'selected="selected"' }>----请选择----</option>
							  		<option value="1"  ${requestScope.makeinvoiceflag!= "1"  ? '' : 'selected="selected"' } >开票</option>
							  		<option value="0" ${requestScope.makeinvoiceflag!= "0"  ? '' : 'selected="selected"' }>不开票</option>
	                          </select>
                          </TD>
                        </TR>  
                        </c:if> 
                         <TR id="salseDate">  
                          <TD height="26" class="table_body" >销售时间</TD>
                               <TD class="table_none" colspan="5"><li class="horizontal_onlyRight"><input id="startTime"
					       name="startTime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       value="${startTime }" /> 至 <input id="endTime"
					       name="endTime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        value="${endTime }" />
					        </li><li class="horizontal_onlyRight">
							<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
                        	 </TD>
                          </TD>
                        </TR>  
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td align="left">
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitBtn" title='查询' onclick="search();">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="goodsForm.reset();">
							</td>
						</tr>
					</table>
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
    <TD height=5></TD></TR>
    	    </TBODY></TABLE></DIV>
</form>
</body>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
