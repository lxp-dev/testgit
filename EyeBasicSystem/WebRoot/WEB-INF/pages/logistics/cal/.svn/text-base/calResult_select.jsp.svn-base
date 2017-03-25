<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>期末处理</title>
</head>
<script>

	function changeGoodsCategory(){
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	
	/**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var goodsCategoryID=document.getElementById('goodsCategoryID').value;
	    if(goodsCategoryID==''){
	      alert('请选择商品类型!');
	      return false;
	    }	
	    
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+goodsCategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+goodsCategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	    var goodsCategoryID=document.getElementById('goodsCategoryID').value;
	    if(goodsCategoryID==''){
	      alert('请选择商品类型!');
	      return false;
	    }
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+goodsCategoryID+"&supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+goodsCategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	
	function search(){
		if ($('#year').val() != ''){
			if ($('#month').val() == ''){
                alert('请选取账期月份！');
                return;
			}
		}else{
			if ($('#month').val() != ''){
                alert('请选取账期年份！');
                return;
			}
	    }
		
		if (checkForm(calresultFrm)){
			$("img").removeAttr("onclick");
			calresultFrm.action = "moniSelect.action";
			calresultFrm.submit();
			showLoadingBar();
		}
	}
	
	function clean(){
	    $('input[clean=clean]').each(function(){
            $(this).val('');
		});
	    $('select[clean=clean]').each(function(){
            $(this).val('');
		});	
		
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 

    function query(date,gid,cid){
        alert('未配置该报表');
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="calresultFrm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="9%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;财务管理</TD>
            <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：查看成本</TD>
          </TR>
        <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initSwitchAmount.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">结账</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                    	                                        
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initCalSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">成本计算</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    	width=3></TD>
                    	
                   <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">查看成本</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD>
                    	 	
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
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
                    </TABLE><!-- ?? Start -->
					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	   <TD width="9%" height="26" class="table_body">商品类型</TD>
			               <TD width="24%" class="table_none">
                            	<select id="goodsCategoryID" name="goodsCategoryID" onchange="changeGoodsCategory()" clean=clean>
	                            	<option value="" ${goodsCategoryID eq '' ? 'selected="selected"' : '' }>----请选择----</option>
                                    <s:iterator value="goodsCategoryList">
                                         <option value="${bgcid }" ${goodsCategoryID eq bgcid ? 'selected="selected"' : '' }>${bgcgoodscategoryname}</option>
                                    </s:iterator>
								</select>
			               </TD>
			               <TD width="9%" height="26" class="table_body">制造商</TD>
			               <TD class="table_none">
				               <li class="horizontal_onlyRight">
							   		<input class="text_input160" type="text" clean=clean id="supplierName" name="supplierName" value="${requestScope.supplierName}" readonly="readonly">
							   		<input type="hidden" id="supplierID" clean=clean name="supplierID" value="${requestScope.supplierID}"/>
							   </li>
							   <li class="horizontal_onlyRight">
							   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openSupplier();" >
							   </li>
			               </TD>
			               <TD height="26" class="table_body">商品品种</TD>
			               <TD  class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" type="text" clean=clean id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input type="hidden" id="brandID" clean=clean name="brandID" value="${requestScope.brandID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" >
						  </li>
			               </TD>
                        </TR> 
                        <TR>
                           <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                               <input class="text_input200" type="text" clean=clean id="goodsID" name="goodsID" value="${requestScope.goodsID}">
			               </TD>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none">
                               <input class="text_input200" type="text" clean=clean id="goodsName" name="goodsName" value="${requestScope.goodsName}">
			               </TD>
			               <TD class="table_body">结账账期</TD>
			               <TD class="table_none" >
							   	<select id="year" name="year" clean=clean> 
							   	    <option value="" ${year == '' ? 'selected="selected"' : '' }>----请选择----</option>     		                          
      		                        <c:forEach var="i" begin="2011" end="${currentYear}" step="1"> 
                                      <option value="${i}" ${ year == i ? 'selected="selected"' : ''}>${i}</option>
      		                        </c:forEach>      		                 
      	                        </select>	
			                    <SELECT id="month" name="month" clean=clean>
			                       <option value="" ${month=='' ? 'selected="selected"' : '' }>----请选择----</option>
			                       <option value="01" ${month=='01' ? 'selected="selected"' : '' }>01</option>
			                       <option value="02" ${month=='02' ? 'selected="selected"' : '' }>02</option>
			                       <option value="03" ${month=='03' ? 'selected="selected"' : '' }>03</option>
			                       <option value="04" ${month=='04' ? 'selected="selected"' : '' }>04</option>
			                       <option value="05" ${month=='05' ? 'selected="selected"' : '' }>05</option>
			                       <option value="06" ${month=='06' ? 'selected="selected"' : '' }>06</option>
			                       <option value="07" ${month=='07' ? 'selected="selected"' : '' }>07</option>
			                       <option value="08" ${month=='08' ? 'selected="selected"' : '' }>08</option>
			                       <option value="09" ${month=='09' ? 'selected="selected"' : '' }>09</option>
			                       <option value="10" ${month=='10' ? 'selected="selected"' : '' }>10</option>
			                       <option value="11" ${month=='11' ? 'selected="selected"' : '' }>11</option>
			                       <option value="12" ${month=='12' ? 'selected="selected"' : '' }>12</option>			                       			                       			                       			                       
			                   </SELECT>
			               </TD>
                        </TR>
                        
                    <c:if test="${systemParameterPo.fspcbjstype eq '2' }">    
                        <TR>
                           <TD class="table_body">所属公司</TD>
			               <TD height="26" class="table_none" colspan="5">
						   		<select id="companyID" clean="clean" name="companyID" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属公司！'}]">
	                              <option value="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" ${fcnId == companyID ? 'selected="selected"' : ''}>${fcnName}</option>
	                              </s:iterator>
	                            </select><label style="color: red">*</label>
			               </TD>
                        </TR>
                    </c:if>
                         
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
							 <img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >
                             <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >
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
					<c:if test="${not empty(resultList)}"> 
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
                        <TR class=table_title align=middle >
                          <TH width="8%" height="62" scope=col rowspan="2">账期</TH>
                          <TH width="20%" scope=col rowspan="2">商品代码</TH>
                          <TH width="30%" scope=col rowspan="2">商品名称</TH>
                          <TH width="8%" height="26" scope=col colspan="2">结余（不包含当月的出库）</TH>
                          <TH width="8%" scope=col rowspan="2">回填成本</TH>                          
						</TR>
						<TR class=table_title align=middle >
                          <TH width="8%" height="26" scope=col>数量</TH>
                          <TH width="8%" scope=col>成本</TH>
						</TR>
						<s:iterator value="resultList">
						<TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" >
						  <TD height="26">${lctctdate}</TD>
                          <TD>${lctctgoodsid}</TD>
                          <TD>${bgigoodsname}</TD>
                          <TD>${lctctgoodsquantity}</TD>  
		                  <TD>${lctctgoodsnottaxrateamount }</TD>
		                  
		                  <c:if test="${permissionPo.keyf == '1'}">    
		                  <TD><a href="#" onclick="query('${lctctdate}','${lctctgoodsid}','${companyID}');">${lctctbackfilltaxrate}</a></TD>
		                  </c:if>
		                  
		                  <c:if test="${permissionPo.keyf != '1'}">    
		                  <TD>${lctctbackfilltaxrate}</TD>
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>