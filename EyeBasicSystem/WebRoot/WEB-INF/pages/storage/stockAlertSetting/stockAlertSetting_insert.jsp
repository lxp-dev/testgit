<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存预警设置</title>
</head>
<script>
	function save(){
		if(checkForm(document.all.stockAlertSettingForm)){ 
			var bgistorageupperlimit=parseInt(document.getElementById('bgistorageupperlimit').value);
		    var bgistoragelowerlimit=parseInt(document.getElementById('bgistoragelowerlimit').value);
		    var bgistorageredlimit=parseInt(document.getElementById('bgistorageredlimit').value);
	
		    if(bgistoragelowerlimit>bgistorageupperlimit){
		      alert('库存下限不能大于库存上限');
		      document.all.bgistorageupperlimit.focus();
		      return false;
		    }

		    if(bgistorageredlimit>bgistoragelowerlimit){
		      alert('红色预警不能大于库存下限');
		      document.all.bgistorageredlimit.focus();
		      return false;
		    }
	    
			<c:if test="${param.goodsType == 0 }" >
			var bgisphul=parseFloat(document.all.bgisphul.value);
		    var bgisphup=parseFloat(document.all.bgisphup.value);
		    if(bgisphul<bgisphup){
		      alert('球镜下限不能大于球镜上限');
		      document.all.bgisphul.focus();
		      return false;
		    }
		    
		    var bgicylul=parseFloat(document.all.bgicylul.value);
		    var bgicylup=parseFloat(document.all.bgicylup.value);
		    if(bgicylul<bgicylup){
		      alert('柱镜下限不能大于柱镜上限');
		      document.all.bgicylup.focus();
		      return false;
		    }
		    </c:if>

		    if(parseFloat($('#bgistorageupperlimit').val())<0){
		    $('#bgistorageupperlimit').focus();
		    	alert('上限不能为负!');
		    	return;
		    }
		     if(parseFloat($('#bgistoragelowerlimit').val())<0){
		     $('#bgistoragelowerlimit').focus();
		    	alert('下限不能为负!');
		    	return;
		    }
		    
		    $("img").removeAttr("onclick");
			stockAlertSettingForm.action = "insertStockAlertSetting.action";
			stockAlertSettingForm.submit();
		}
	}
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open=${param.goodsType == 0 ? '3,4' : '1,2,5,6,7,8'}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open=${param.goodsType == 0 ? '3,4' : '1,2,5,6,7,8'}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】"
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('bgisupplierid').value = json.id;
		document.getElementById('bgisuppliername').value = json.value;
		document.getElementById('bgibrandid').value = "";
		document.getElementById('bgibrandname').value = "";
	}
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var bgisupplierid=document.getElementById('bgisupplierid').value;
	    if(bgisupplierid==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?&supplierID_open=" + document.getElementById('bgisupplierid').value +"&arg0=${param.goodsType}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?&supplierID_open=" + document.getElementById('bgisupplierid').value +"&arg0=${param.goodsType}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【品种查询】"
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('bgibrandid').value = json.brandID;
		document.getElementById('bgibrandname').value = json.brandName;
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});
	
	function clean(){
		document.stockAlertSettingForm.reset();
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="stockAlertSettingForm" method="post" action="">
<input type="hidden" name="goodsType" value="${param.goodsType }"/>
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
    <c:if test="${param.goodsType == 0 }" >    
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">库存预警设置(区间)</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initStockAlertSettingInsert2D.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">库存预警设置(二维)</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
		</c:if>
		<c:if test="${param.goodsType != 0 }" >
		<tr><td height="20"></td></tr>
		 <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
            </TD>
		</TR>
		</c:if>		
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD width="24%" class="table_none">                             
			               	<li class="horizontal_onlyRight">
						   		<input id="bgisuppliername" class="text_input160" name="alertSettingPo.csasasuppliername"  readonly="readonly" value="${alertSettingPo.csasasuppliername}" />
						   		<input type="hidden" value="${alertSettingPo.csasasupplierid}" id="bgisupplierid" name="alertSettingPo.csasasupplierid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属制造商不能为空！'}]"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						    <img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" btn=btn name=ctl00$PageBody$Button1 onClick="openSupplier();">
						  				</li>			               
			               </TD>
						   <TD width="9%" class="table_body">所属品种</TD>
			               <TD width="24%" class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input id="bgibrandname" class="text_input160" name="alertSettingPo.csasabrandname" readonly="readonly" value="${alertSettingPo.csasabrandname}"/>
						   		<input type="hidden" id="bgibrandid" name="alertSettingPo.csasabrandid"  value="${alertSettingPo.csasabrandid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '所属品种不能为空！'}]"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" btn=btn onClick="openBrand();"></li>
			               </TD>	
			               <TD height="26" class="table_body">仓位</TD>
			               <TD class="table_none">
                            <select id="warehouseID" name="alertSettingPo.csasastockid">
      		                 <s:iterator value="warehouselist">
				               <option value="${bwhid }" ${'yybhgpc' == bwhid ? 'selected="selected"' : '' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
			               </TD>		                
                        </TR>
						<c:if test="${param.goodsType == 0 }" >
						<c:if test="${empty(alertSettingPo.csasasphul)}" ></c:if>
                        <TR>
						   <TD height="26" class="table_body">球镜</TD>
			               <TD class="table_none">
	                             <select id="bgisphul" name="alertSettingPo.csasasphul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜上限不能为空！'}]">
      		                 		<option value="">请选择球镜上限</option>
      		                 		<c:if test="${empty(alertSettingPo.csasasphul)}" >
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${26.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>">${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>
										</option>
			               			</c:forEach>
			               			</c:if>
			               			<c:if test="${not empty(alertSettingPo.csasasphul)}" >
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${26.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${alertSettingPo.csasasphul + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>
										</option>
			               			</c:forEach>
			               			</c:if>
      	                   		 </select> - 
	                             <select id="bgisphup" name="alertSettingPo.csasasphup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '球镜下限不能为空！'}]">
      		                 		<option value="">请选择球镜下限</option>
      		                 		<c:if test="${empty(alertSettingPo.csasasphup)}" >
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${26.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>">${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
			               			</c:if>
			               			<c:if test="${not empty(alertSettingPo.csasasphup)}" >
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${26.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${alertSettingPo.csasasphup + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
			               			</c:if>
      	                   		 </select>
			               </TD>
						   <TD class="table_body">柱镜</TD>
			               <TD class="table_none" colspan="3">
			               <c:if test="${systemParameterPo.fspnegative==1}">
								 <select id="bgicylul" name="alertSettingPo.csasacylul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜上限不能为空！'}]">
      		                 		<option value="">请选择柱镜上限</option>
      		                 		<c:if test="${empty(alertSettingPo.csasacylul)}" >
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${26.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>">${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
			               			</c:if>
			               			<c:if test="${not empty(alertSettingPo.csasacylul)}" >
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${26.00 - (0.25 * (index.index - 1))}" />
										<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>"  ${alertSettingPo.csasacylul + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
			               			</c:if>
      	                   		 </select> 
      	                   	</c:if>
      	                   	<c:if test="${systemParameterPo.fspnegative!=1}">
								 <select id="bgicylul" name="alertSettingPo.csasacylul" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜上限不能为空！'}]">
      		                 		<option value="">请选择柱镜上限</option>
      		                 		<c:if test="${empty(alertSettingPo.csasacylul)}" >
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
										<option value="<fmt:formatNumber value="${lens }" pattern="0.00"/>"><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
			               			</c:if>
			               			<c:if test="${not empty(alertSettingPo.csasacylul)}" >
      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
			               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
										<option value="<fmt:formatNumber value="${lens }" pattern="0.00"/>"  ${alertSettingPo.csasacylul + 0 != lens ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
			               			</c:forEach>
			               			</c:if>
      	                   		 </select> 
      	                   	</c:if>
      	                   		 - 
      	                   		  <c:if test="${systemParameterPo.fspnegative==1}">
	      	                   		 <select id="bgicylup" name="alertSettingPo.csasacylup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜下限不能为空！'}]">
	      		                 		<option value="">请选择柱镜下限</option>
	      		                 		<c:if test="${empty(alertSettingPo.csasacylup)}" >
	      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
				               				<c:set var="lens" value="${26.00 - (0.25 * (index.index - 1))}" />
											<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" >${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
				               			</c:forEach>
				               			</c:if>
				               			<c:if test="${not empty(alertSettingPo.csasacylup)}" >
	      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
				               				<c:set var="lens" value="${26.00 - (0.25 * (index.index - 1))}" />
											<option value="${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${alertSettingPo.csasacylup + 0 != lens ? '' : 'selected="selected"' }>${lens > 0 ? '+' : '' }<fmt:formatNumber value="${lens }" pattern="0.00"/></option>
				               			</c:forEach>
				               			</c:if>
	      	                   		 </select>
      	                   		 </c:if>
      	                   		  <c:if test="${systemParameterPo.fspnegative!=1}">
	      	                   		 <select id="bgicylup" name="alertSettingPo.csasacylup" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '柱镜下限不能为空！'}]">
	      		                 		<option value="">请选择柱镜下限</option>
	      		                 		<c:if test="${empty(alertSettingPo.csasacylup)}" >
	      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
				               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
											<option value="<fmt:formatNumber value="${lens }" pattern="0.00"/>" ><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
				               			</c:forEach>
				               			</c:if>
				               			<c:if test="${not empty(alertSettingPo.csasacylup)}" >
	      		                 		<c:forEach var="x" begin="1" end="209" step="1" varStatus="index">
				               				<c:set var="lens" value="${0.00 - (0.25 * (index.index - 1))}" />
											<option value="<fmt:formatNumber value="${lens }" pattern="0.00"/>" ${alertSettingPo.csasacylup + 0 != lens ? '' : 'selected="selected"' }><fmt:formatNumber value="${lens }" pattern="0.00"/></option>
				               			</c:forEach>
				               			</c:if>
	      	                   		 </select>
      	                   		 </c:if>
							</TD>
							
                        </TR>
                        </c:if>
						<TR>
						   <TD height="26" class="table_body">库存上限</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistorageupperlimit" name="alertSettingPo.csasastockcap" 
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '库存上限不能为空！'},{'Type' : Type.String, 'Formula' : Formula.ZINT, 'Message' : '库存上限应为正整数！'}]">
			               </TD>
			               <TD height="26" class="table_body">库存下限</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistoragelowerlimit" name="alertSettingPo.csasastocklower" 
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '库存下限不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '库存下限应为整数！'}]">
			               </TD>
			               <TD height="26" class="table_body">红色预警</TD>
			               <TD class="table_none">
                             <input class="text_input100" type="text" id="bgistorageredlimit" name="alertSettingPo.csasastockred" 
                             	validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '红色预警不能为空！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '红色预警应为整数！'}]">
			               </TD>
			            </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          	<TD>
                          		<img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                        	  	<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
                          	</TD>
						</TR>
                      </TBODY>
                    </TABLE>
                	
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background="${ctx}/img/pic/tab_bg.gif"><IMG height=1  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>