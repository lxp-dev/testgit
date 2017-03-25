<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
<title>选择商品</title>
</head>

<script>
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	goodsForm.action=link;
	  	goodsForm.submit();
	}
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
        document.getElementById('goodscategoryID').value=$('#categoryID').val();
		document.getElementById('submitBtn').onclick = null;
		goodsForm.action = "adjustPriceGoodsOpen_dimensional.action?retailType=${retailType}";
		goodsForm.submit();
	}

	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    dimensiionalFlag.style.display = 'none';

        var goodscategoryID=document.getElementById('goodscategoryID').value;
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
			showPopWin("selBrandOpen.action?categoryID_open=" + goodscategoryID +"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open=" + goodscategoryID +"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		var dflag = '${dimensiionalFlag}';
	   	if(dflag == '1'){
	    	var dimensiionalFlag = document.getElementById('dimensiionalFlag');
	    	dimensiionalFlag.style.display = 'block';
	   	}	   
    });
    
    function changeCategory(obj){
        $('#goodsCategoryID').val(obj.value);
        document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
		document.getElementById('supplierID').value = "";
		document.getElementById('supplierName').value = "";
    }
    
    /**
	 *  调用页面赋值
	 */
	function setValue(){
        var axgrid = document.getElementById('axgrid');
		var goodInfos = eval('(' + axgrid.content + ')');
		//if(goodInfos.length<100){
		//  window.parent.openGoodsDimensionValues(axgrid.content);
        //  alert('您选择的商品信息已添加到商品列表中！');
		//}else{
		//   alert('选取数据过多，请分批输入！');
		//}
		var goodsids = "";
		var tdvs = "";
		for(var i = 0; i < goodInfos.length; i++){
	  		goodsids = goodsids + goodInfos[i].goodsid + ",";
	  		tdvs = tdvs + goodInfos[i].v + ",";
		}
		if (tdvs.lastIndexOf(',') > -1) {
			tdvs = tdvs.substring(0, tdvs.lastIndexOf(','));
	    }
		var Rtype=$('#whichretail').val()
		window.parent.$("#tdgoodsids").val(goodsids);
		window.parent.$("#tdvs").val(tdvs);
		window.parent.$("#whichretails").val(Rtype);
		window.parent.addtdgoods();
		
	}
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
		if('${retailType}'=='AdjustmentPrice'){
			$('#wl').show();
		}else{
			$('#wl').hide();
		}
	});
    
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="goodsForm" method="post" action="">

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />
<input type="hidden" name="supplierID_open" value="${supplierID_open }" />
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD align="right" colspan="3">
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();"  />
  </TD>
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
                           <TD width="60" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none">
                            <input type="hidden" id="goodsCategoryID" name="goodsCategoryID" value="${categoryID_open}"/>
                            <select id="categoryID" onchange="changeCategory(this)" ${categoryID_open != '' ? 'disabled="disabled"' :''}>
                                <option value="3" ${goodsCategoryID == '3' ? 'selected="selected"' : '' }>框镜成品镜片</option>
                                <option value="4" ${goodsCategoryID == '4' ? 'selected="selected"' : '' }>隐形成品镜片</option>
                            </select>
			               </TD>
			               <TD height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" class="text_input160" name="supplierName" value="${supplierName}" readonly="readonly"/>
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" />
									</li>
						   			<li class="horizontal_onlyRight">
						  				<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
						  				</li>
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
 						<tr id="wl">
 							<TD  height="26" class="table_body"><select id="whichretail" name="whichretail">
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
	                      	  </select></TD><td class="table_none" colspan="5"></td>
 						</tr>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2" width="100%">
						<tr height="10">
							<td align="left">
								<img id="submitBtn" src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
								<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="setValue();">
								
							</td>
						</tr>
					</table>
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
		<param name="InputPrecision" value="2"/><!--内容的精度。小数点后几个0-->
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
  <TR>
    <TD height=5></TD></TR>
    	    </TBODY></TABLE></DIV>
</form>
</body>
<script>
	var contents;
	contents = $("#goodsContext").text().substring(2,$("#goodsContext").text().length);
	
	var axgrid = document.getElementById( 'axgrid' );
	axgrid.content = '['+contents+']';
	//axgrid.content = '[{"x":1,"y":1,"v":25},{"x":5,"y":4,"v":'35'}]';
</script>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
