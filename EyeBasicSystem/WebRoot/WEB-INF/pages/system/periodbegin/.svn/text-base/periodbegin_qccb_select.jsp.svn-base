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

		showSubMenu('${companyID}','${dptID}');	
	});

	function search(){
	    $("img").removeAttr("onclick");
	    qccbFrm.action = "selectPeriodBeginQccb.action";
	    qccbFrm.submit();
		showLoadingBar();
	}
	
	function clean(){
        $('[clean="clean"]').val('');
        showSubMenu('','');
	}

    function importBegGoods(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("initPeriodBeginLogistics.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPeriodBeginLogistics.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【导入期初成本】";
    }

    function exportAmountGoods(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("initExportAmountFile.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initExportAmountFile.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【导出财务期初商品】";
    }

    function importportAmountGoods(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("initImportAmountFile.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initImportAmountFile.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【导入财务期初商品】";
    }

    function showSubMenu(cid,did) {        
        $('#dptID').load("getAjaxDepartmentMenuForCompanyID.action?id="+ cid + "&did="+did);
    }

    function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("initPeriodBeginQccbUpdate.action?moduleID=${moduleID}&hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPeriodBeginQccbUpdate.action?moduleID=${moduleID}&hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【调整商品期初成本】";
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
        	   <img btn=btn src="${ctx }/img/newbtn/btn_dcqckc_0.png" title='导出期初商品' onclick="exportAmountGoods();" >	
               <img btn=btn src="${ctx }/img/newbtn/btn_drjcxxqccb_0.png" title='按基础信息导入期初成本' onclick="importBegGoods();" >
               <img btn=btn src="${ctx }/img/newbtn/btn_drqccb_0.png" title='导入期初成本' onclick="importportAmountGoods();" >	
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
			               <TD height="26" class="table_none">
						   		<select id="companyID" clean="clean" name="companyID" onchange="showSubMenu(this.options[this.options.selectedIndex].value,'')" noValidate = "noValidate" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属公司！'}]">
	                              <option value="">----请选择----</option>
	                              <s:iterator value="companyNamePos">
	                              <option value="${fcnId}" ${fcnId == companyID ? 'selected="selected"' : ''}>${fcnName}</option>
	                              </s:iterator>
	                            </select>
                           </TD>
                           
                           <TD height="26" class="table_body">所属部门</TD>
			               <TD class="table_none">			   
							   	<select id="dptID" clean="clean" name="dptID">
	                              <option value="">----请选择----</option>
	                            </select><label style="color:red;">&nbsp;选取所属公司后，才会显示所属部门</label>                            						  
						   </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">商品代码</TD>
                          <TD class="table_none">
                              <input type="text" clean="clean" class="text_input200" id="goodsID" name="goodsID" value="${goodsID}"/><label style="color:red;">&nbsp;(可向右模糊查询)</label>  
						  </TD>
                          <TD height="26" class="table_body">商品名称</TD>
                          <TD class="table_none">
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
	                        </td>
						</tr>
						
						<tr height="26">
	                        <td>
	                       		<label style="color:red;"><b>&nbsp;此功能只能查询并修改参与成本计算的商品的期初库存和期初成本，修改期初库存或期初成本后，不会影响商品的实际库存，只影响以后各月的加权平均成本和相关成本类报表的准确性!</b></label>
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
					<c:if test="${not empty(goodsInfoList)}">		
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
                        <TR class=table_title align=middle>
                          <TH width="3%" height="52" scope=col rowspan="2">操作</TH>
                          <TH width="5%" scope=col rowspan="2">商品类型</TH>
                          <TH width="10%" scope=col rowspan="2">制造商</TH>
						  <th width="10%" scope=col rowspan="2">商品品种</th>
                          <TH width="10%" scope=col rowspan="2">商品代码</TH>
                          <TH width="20%" scope=col rowspan="2">商品名称</TH>
                          <TH width="10%" scope=col rowspan="2">所属公司</TH>
                          <TH width="10%" scope=col rowspan="2">所属部门</TH>
                          <TH width="8%" scope=col rowspan="2">期初日期</TH>
                          <TH width="10%" height="26" scope=col colspan="2">期初(${fquartzSwitchPo.fqscbjs eq '1' ? '不含税' : '含税'})</TH>
                        </TR>
                        <TR class=table_title align=middle>
                          <TH width="5%" height="26" scope=col >数量</TH>
                          <TH width="5%" scope=col>成本</TH>
                        </TR>
                        <s:iterator value="goodsInfoList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <TD height="26"><img src="${ctx }/img/newbtn/edit_0.png" title="调整成本" onclick="update('${bgiqcid}')" btn=btn></TD>
                          <TD>${bgigoodscategoryname}</TD>
                          <TD>${bgisuppliername}</TD>
                          <TD>${bgibrandname}</TD>
                          <TD>${bgigoodsid}</TD>	
                          <TD>${bgigoodsname}</TD>
                          <TD>${bgicompanyname}</TD>
                          <TD>${bgidepartmentname}</TD>
                          <TD>${bgiqcdate}</TD>
                          <TD>${bgiqcnum}</TD>   
                          <TD>${bgiqcaouumt}</TD>               
                        </TR>
                        </s:iterator>
                        <TR class=table_title align=middle>
                          <TH height="26" scope=col colspan="9">总合计：</TH>
                          <TH scope=col>${totalnum }</TH>
                          <TH scope=col>${totalamount }</TH>                          
                        </TR>
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