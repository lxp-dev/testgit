<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>期初成本查询</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function search(){
	    $("img").removeAttr("onclick");
	    qccbFrm.action = "selQcInStorage.action";
	    qccbFrm.submit();
		showLoadingBar();
	}
	
	function clean(){
        $('[clean="clean"]').val('');
        $("#dptID option[value!='']").remove();
        $("#warehouseID option[value!='']").remove();
	}

    function importportAmountGoods2(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("initQcInStorageInsert.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initQcInStorageInsert.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【新增非效期商品库存】";
    }

    function importportAmountGoods(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("initImportFile.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initImportFile.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【Excel导入非批号商品库存】";
    }

    function importportAmountGoods3(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("initQcInStorageYxInsert.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initQcInStorageYxInsert.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【新增效期商品库存】";
    }

    function showSubMenu(cid) {        
        $('#dptID').load("getAjaxDepartmentMenuForCompanyID.action?id="+ cid);
    }

    function showSubMenu2(cid) {        
    	$('#warehouseID').load("getAjaxStock.action?id="+ cid);
    }

    function update(wid,bid,gid,bch){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("initQcInStorageUpdate.action?moduleID=${moduleID}&wid="+wid+"&bid="+bid+"&gid="+gid+"&bch="+bch,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initQcInStorageUpdate.action?moduleID=${moduleID}&wid="+wid+"&bid="+bid+"&gid="+gid+"&bch="+bch,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【调整商品期初成本】";
    }

    function printBarCode(){
        if ($('#warehouseID').val() == ''){
            alert("请先选择仓位!");
            return;
        }       
        
        var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initBarCodePrint.action?moduleID=${moduleID}&bgiwarehouseid="+$('#warehouseID').val(),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initBarCodePrint.action?moduleID=${moduleID}&bgiwarehouseid="+$('#warehouseID').val(),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【打印条码】";
    }
    
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="qccbFrm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr align="right">
           <td>
        	   <img btn=btn src="${ctx }/img/newbtn/btn_exceldrfpcspkc_0.png" title='Excel导入非批号商品库存' onclick="importportAmountGoods();" >
               <img btn=btn src="${ctx }/img/newbtn/btn_xzfxqspkc_0.png" title='新增非效期商品库存' onclick="importportAmountGoods2();" >
               
               <c:if test="${systemParameterPo.fspstealtheffective=='1' || systemParameterPo.fspstealtheffective=='2'}"> 
               <img btn=btn src="${ctx }/img/newbtn/btn_xzxqspkc_0.png" title='新增效期商品库存' onclick="importportAmountGoods3();" >		
               </c:if>
           </td>
        </tr>
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
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </table>

					<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD height="26" class="table_body">所属公司</TD>
			               <TD class="table_none" width="25%">
						   		<select id="companyID" clean="clean" name="companyID" onchange="showSubMenu(this.options[this.options.selectedIndex].value,'')">
	                              <option value="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" ${fcnId == companyID ? 'selected="selected"' : ''}>${fcnName}</option>
	                              </s:iterator>
	                            </select>
                           </TD>
                           
                           <TD class="table_body">所属部门</TD>
			               <TD class="table_none" width="25%">			   
							   	<select id="dptID" clean="clean" name="dptID" onchange="showSubMenu2(this.options[this.options.selectedIndex].value,'')">
	                              <option value="">----请选择----</option>
	                              <s:iterator value="departmentsList">
	                                  <option value="${bdpdepartmentid }" ${bdpdepartmentid == dptID ? 'selected="selected"' : ''}>${bdpdepartmentname}</option>
	                              </s:iterator>
	                            </select><label style="color:red;">&nbsp;选取所属公司后，才会显示所属部门</label>	                            						  
						   </TD>
						   
						   <TD class="table_body">所属仓位</TD>
			               <TD class="table_none" width="25%">			   
							   	<select id="warehouseID" clean="clean" name="warehouseID">
	                              <option value="">----请选择----</option>
	                              <s:iterator value="warehousePoList">
	                                  <option value="${bwhid }"${bwhid == warehouseID ? 'selected="selected"' : ''}>${bwhwarehouseName}</option>
	                              </s:iterator>
	                            </select><label style="color:red;">&nbsp;选取所属部门后，才会显示所属仓位</label>	                            						  
						   </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">商品代码</TD>
                          <TD class="table_none">
                              <input type="text" clean="clean" class="text_input200" id="goodsID" name="goodsID" value="${goodsID}"/><label style="color:red;">&nbsp;(可向右模糊查询)</label>
						  </TD>
                          <TD class="table_body">商品名称</TD>
                          <TD class="table_none" colspan="3">
                              <input type="text" clean="clean" class="text_input200" id="goodsName" name="goodsName" value="${goodsName}"/><label style="color:red;">&nbsp;(可向左、右模糊查询)</label>
						  </TD>
                        </TR>   
                      </TBODY>
                    </table>
                    <table id="title2" cellspacing="2">
						<tr height="26">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onClick="javascript:search()">
	                       		<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
	                       		<img btn=btn src="${ctx }/img/newbtn/btn_printbarcode_0.png" title='打印条码' onclick="printBarCode();" >
	                        </td>
						</tr>
						<tr height="26">
	                        <td>
	                       		<label style="color:red;"><b>&nbsp;此功能只能查询并修改新增的期初库存，修改库存后，与库存相关的时英需要执行后时英中的库存数量才会发生变更，除了各月的盘盈盘亏以外，不会影响其他业务单据产生的实际库存!</b></label>
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
					<c:if test="${not empty(gList)}">		
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </table>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                 <c:choose>
	                 <c:when test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2')}">     
	                        <TR class=table_title align=middle>
	                          <TH width="3%" height="52" scope=col rowspan="2">操作</TH>
	                          <TH width="10%" scope=col rowspan="2">所属公司</TH>
	                          <TH width="8%" scope=col rowspan="2">所属部门</TH>
	                          <TH width="8%" scope=col rowspan="2">所属仓位</TH>
	                          <TH width="15%" scope=col rowspan="2">商品代码</TH>
	                          <TH width="15%" scope=col rowspan="2">商品名称</TH>
	                          <TH width="20%" scope=col rowspan="2">商品条码</TH>
	                          <TH width="16%" scope=col colspan="2">隐形和护理液显示此属性</TH>
	                          <TH width="10%" scope=col rowspan="2">库存</TH>
	                        </TR>      
	                        <TR class=table_title align=middle>
	                          <TH width="8%" scope=col>效期</TH>
	                          <TH width="8%" scope=col>批号</TH>
	                        </TR>
	                 </c:when>                 
	                 <c:otherwise>
	                        <TR class=table_title align=middle>
	                          <TH width="3%" height="52" scope=col>操作</TH>
	                          <TH width="10%" scope=col>所属公司</TH>
	                          <TH width="8%" scope=col>所属部门</TH>
	                          <TH width="8%" scope=col>所属仓位</TH>
	                          <TH width="15%" scope=col>商品代码</TH>
	                          <TH width="15%" scope=col>商品名称</TH>
	                          <TH width="20%" scope=col>商品条码</TH>
	                          <TH width="10%" scope=col>库存</TH>
	                        </TR>      
	                 </c:otherwise>
                 </c:choose>
                        
                 <s:iterator value="gList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><img src="${ctx }/img/newbtn/edit_0.png" title="调整库存" onclick="update('${bgiwarehouseid}','${bgigoodsbarcode}','${guaranteeperiod}','${batch}')" btn=btn></TD>
                          <TD>${bgicompanyname}</TD>
                          <TD>${bgidepartmentname}</TD>
                          <TD>${bgiwarehousename}</TD>
                          <TD>${bgigoodsid}</TD>	
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgigoodsbarcode}</TD>
                     <c:if test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2')}">     
                          <TD>${guaranteeperiod}</TD>
                          <TD>${batch}</TD>
                     </c:if>
                          <TD>${bgistockquantity}</TD>            
                        </TR>
                 </s:iterator>

                 <c:choose>
	                 <c:when test="${(systemParameterPo.fspbarcodetype == '1' || systemParameterPo.fspbarcodetype == '2') && (systemParameterPo.fspstealtheffective == '1' || systemParameterPo.fspstealtheffective == '2')}">     
                         <TR class=table_title align=middle>
                             <TH height="26" scope=col colspan="9">总合计：</TH>
                             <TH scope=col>${totalnum }</TH>                        
                         </TR>
	                 </c:when>                 
	                 <c:otherwise>
                         <TR class=table_title align=middle>
                             <TH height="26" scope=col colspan="7">总合计：</TH>
                             <TH scope=col>${totalnum }</TH>                        
                         </TR>      
	                 </c:otherwise>
                 </c:choose>

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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>