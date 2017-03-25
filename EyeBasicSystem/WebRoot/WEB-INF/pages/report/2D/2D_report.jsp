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

	function search(){
		if ($('#categoryID').val() == ''){
		    alert('请选择商品类别!');
		    return;
		}
		
		if ($('#supplierID').val() == ''){
		    alert('请选择制造商!');
		    return;
		}
		if ($('#brandID').val() == ''){
		    alert('请选择商品品种!');
		    return;
		}	
		goodsForm.action = "goodsOpen_dimensional.action";
		goodsForm.submit();
	}

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    dimensiionalFlag.style.display = 'none';

        var goodscategoryID = document.getElementById('goodscategoryID').value;
		if (goodscategoryID == ''){
		    goodscategoryID = $('#categoryID').val();
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=" + goodscategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=" + goodscategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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

	  	var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    dimensiionalFlag.style.display = 'none';

		var goodscategoryID=document.getElementById('goodscategoryID').value;
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
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodscategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;
		search();
	}
		
	/**
	 *  调用页面赋值
	 */
	function setValue(){
		if ($('#categoryID').val() == ''){
		    alert('请选择商品类别!');
		    return;
		}
		
		if ($('#supplierID').val() == ''){
		    alert('请选择制造商!');
		    return;
		}
		if ($('#brandID').val() == ''){
		    alert('请选择商品品种!');
		    return;
		}	
        var axgrid = document.getElementById('axgrid');
		var goodInfos = eval('(' + axgrid.content + ')');
		if (goodInfos == null || goodInfos == ""){
		    alert("请先选取商品!");
		    return;
		}
		var goodsids = "";
		var tdvs = "";
		var coordinate="";
		for(var i = 0; i < goodInfos.length; i++){
		  	if(goodInfos[i].v!=''){
		  		goodsids = goodsids + goodInfos[i].goodsid + ",";
		  		tdvs = tdvs + goodInfos[i].v + ",";
		  	}		
		}
		
		window.parent.$("#tdgoodsids").val(goodsids);
		window.parent.$("#tdvs").val(tdvs);
		window.parent.addtdgoods();
		/*if(goodInfos.length<201){
			window.parent.openGoodsDimensionValues(axgrid.content);
        	alert('您选择的商品信息已添加到商品列表中！');
		}else{
			alert('选取数据过多，请分批输入！');
		}*/
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
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
        $("#goodsCategoryID").val($("#categoryID").val());
		var dflag = '${dimensiionalFlag}';
	   	if(dflag == '1'){
	    	var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    	dimensiionalFlag.style.display = 'block';
	   	}	   
	   	if('${requestScope.brandID}'){
	   		if($("[id=dimensiionalFlag]").attr("style").toUpperCase() == "display: none".toUpperCase()){
	   			search();
	   		}
		}
    });
    
    function changeCategory(obj){
        $('#goodsCategoryID').val(obj.value);
    }
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" name="brandID_open" value="${brandID_open }" />
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />
<input type="hidden" name="cstibillid" value="${requestScope.cstibillid}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD colspan="3" align="right"></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				 
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                        <td class="table_none">
								<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onclick="setValue()">
							</td>
                           <TD width="7%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" width="15%">
			                <c:if test="${empty(categoryID_open) }">
					   			<input type="hidden" id="goodsCategoryID" name="goodsCategoryID" value="${categoryID_open}"/>
                            	<select id="categoryID" onchange="changeCategory(this)" ${categoryID_open != '' ? 'disabled="disabled"' :''}>
	                                <option value="3" ${goodsCategoryID == '3' ? 'selected="selected"' : '' }>框镜成品镜片</option>
	                                <option value="4" ${goodsCategoryID == '4' ? 'selected="selected"' : '' }>隐形成品镜片</option>
                            	</select>
					  	    </c:if>
					  	    <c:if test="${not empty(categoryID_open) }">
					   			<input type="hidden" id="goodsCategoryID" name="goodsCategoryID" value="${categoryID_open}"/>
					   			<c:if test="${categoryID_open == '3'}">
					   				框镜成品镜片
					   			</c:if>
					   			<c:if test="${categoryID_open == '4'}">
					   				隐形成品镜片
					   			</c:if>
					  	    </c:if>
			               </TD>
			               <TD height="26" class="table_body" width="7%">制造商</TD>
			               <TD class="table_none" width="20%">
			               		<c:if test="${empty(supplierID_open) }">
					   			<li class="horizontal_onlyRight">
						   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}" readonly="readonly"/>
						   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" />
								</li>
					   			<li class="horizontal_onlyRight">
					  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openSupplier()">
					  			</li>
					  			</c:if>
					  			<c:if test="${not empty(supplierID_open) }">
					   			<li class="horizontal_onlyRight">
						   			${supplierName}
						   			<input type="hidden" id="supplierName" name="supplierName" value="${supplierName}"/>
						   			<input type="hidden" id="supplierID"   name="supplierID"   value="${supplierID }" />
								</li>
					  			</c:if>
			               </TD>			               
						   <TD height="26" class="table_body" width="7%">商品品种</TD>
			               <TD class="table_none">
	                           <li class="horizontal_onlyRight">
							   		<input class="text_input160" type="text" id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
							   		<input type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							   		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openBrand();">
							   </li>
			               </TD>
                        </TR>
 
                      </TBODY>
                    </TABLE>
           
	<!-- ------------------------------------------------------------------------------ -->
  	        <div style="display:none">
      	       <select id="goodsContext"  name="goodsContext">
      		     <s:iterator value="goodsInfoList">
				    <option value="${stringContext}">,${stringContext}</option>
	     	     </s:iterator>
      	       </select>
      	    </div>
  	 <div id="dimensiionalFlag" style="display:none">
		<object classid="clsid:5F019427-2649-4468-BD28-F6FBD96E1B51"  width="100%" height="600" id="axgrid" codebase="<%=request.getContextPath()%>/AxGrid.ocx#version=1,0,0,0" name="axgrid">
		<param name="RowStart" value="${goodsInfoPo.maxSph}"/>		<!--行起始值-->
		<param name="RowEnd" value="${goodsInfoPo.minSph}"/>		<!--行终止值-->
		<param name="RowStep" value="-0.25"/>	<!--行步长-->
		<param name="ColStart" value="${goodsInfoPo.maxCyl}"/>		<!--列起始值-->
		<param name="ColEnd" value="${goodsInfoPo.minCyl}"/>		<!--列终止值-->
		<param name="ColStep" value="-0.25"/>		<!--列步长-->
		<param name="ColPrecision" value="2"/>	<!--列表头的精度-->
		<param name="RowPrecision" value="2"/>	<!--行表头的精度-->
		<param name="InputPrecision" value="0"/><!--内容的精度。小数点后几个0-->
		<param name="ColWidth" value="50"/>		<!--列宽-->
		<param name="RowHeight" value="22"/>	<!--行高-->
		<param name="Title" value="球镜/柱镜"/>
		<param name="RowHeaderColor" value="236, 245, 251"/>	<!--行表头的颜色-->
		<param name="ColHeaderColor" value="236, 245, 251"/>	<!--列表头的颜色-->
		<param name="GridLineColor" value="140, 140, 140"/>		<!--网格线的颜色-->
		<param name="OddLineColor" value="255,255,255"/>		<!--奇数行的背景颜色-->
		<param name="EvenLineColor" value="255, 255, 255"/>		<!--偶数行的背景颜色-->
		<param name="SelectedColor" value="217, 234, 247"/>		<!--选择项的颜色-->
		<param name="DisableColor" value="192, 192, 192"/>		<!--不可用单元格的颜色-->
		</object>
	 </div>
     <!-- ------------------------------------------------------------------------------ -->
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
    	    </TBODY></TABLE></DIV>
</form>
</body>
<script>
	var contents;
	contents = $("#goodsContext").text().substring(2,$("#goodsContext").text().length);
	var axgrid = document.getElementById( 'axgrid' );
	axgrid.content = '['+contents+']';
	//axgrid.content = '[{"x":77,"y":6,"v":25},{"x":5,"y":4,"v":35}]';
</script>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
