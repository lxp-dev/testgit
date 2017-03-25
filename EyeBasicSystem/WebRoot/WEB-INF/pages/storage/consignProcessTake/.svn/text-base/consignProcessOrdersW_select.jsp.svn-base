<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择委外配镜单</title>
</head>
<script>	
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
	
	function search(){
		if(checkForm(supplierOpenForm)){  
			$("img").removeAttr("onclick");
			supplierOpenForm.action = "selectSalesIdsW.action";
			supplierOpenForm.submit();
			showLoadingBar();
		}

	}
	
	function clean(){
		document.getElementById('supplierID').value = "";
		document.getElementById('startTime').value = "";
		document.getElementById('endTime').value = "";
	    document.getElementById('glassid').value = "";
	    document.getElementById('deptID').value = "";
	    document.getElementById('cstcpoordergoodscategory').value = "";
	    document.getElementById('ssesbsalesdatestarttime').value = "";
	    document.getElementById('ssesbsalesdateendtime').value = "";
	    document.getElementById('goodsName').value = "";
	    document.getElementById('remark').value = "";
		document.getElementById('minSphjp').value = "";
		document.getElementById('minCyljp').value = "";
        <c:if test="${systemParameterPo.fspdjsbm == '1'}">
        document.getElementById('djsbm').value = "";
        </c:if>		
	}	
	function permissionMessage(){
        alert('您无此操作权限');
	}
	
	function setValue(billID, salesid){	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("consignProcessTakeInsert.action?moduleID=${moduleID}&billID="+billID+"&salesid="+salesid,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("consignProcessTakeInsert.action?moduleID=${moduleID}&billID="+billID+"&salesid="+salesid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【委外收货新增】";

	}
	
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var supplierID=document.getElementById('selsupplierid').value;
	    if(supplierID==''){
	      alert('请选择所属制造商');
	      return false;
	    }			
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
	 * 制造商开窗
	 */
	function openSupplier(){
		// 开窗条件 categoryID_open
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商添加】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('selsupplierid').value = json.id;
		document.getElementById('selsuppliername').value = json.value;
		document.getElementById('brandID').value = "";
		document.getElementById('brandName').value = "";
	}
	
	$(document).ready(function(){
		$('#billtype').attr("value","${requestScope.billtype}");
	});

	$(document).ready(function() { 
	$("img[btn=btn]").attr("style","cursor: hand"); 
	$("img[btn=btn]").mouseover(function () { 
	$(this).attr("src",$(this).attr("src").replace("0","1")); 
	}).mouseout(function () { 
	$(this).attr("src",$(this).attr("src").replace("1","0")); 
	}); 
	});

	function today(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('startTime').value = now;
		document.getElementById('endTime').value = now;		
	}
	
	function today1(){
		
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('ssesbsalesdatestarttime').value = now;
		document.getElementById('ssesbsalesdateendtime').value = now;		
	}
function insert(){
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConsignProcessTakeInsert.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initConsignProcessTakeInsert.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【委外收货新增】";
	}

	function checkNumberType(thiz){
		if($(thiz).val()!=''){
			if(parseFloat($(thiz).val())>0){
				var str='+'+parseFloat($(thiz).val().replace('+','')).toFixed(2);
				$(thiz).val(str);
			}else if(parseFloat($(thiz).val())<0){
				$(thiz).val(parseFloat($(thiz).val()).toFixed(2));
			}else if(parseFloat($(thiz).val())==0){
				$(thiz).val('0.00');
			}
		}
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="supplierOpenForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="categoryID_open" value="${categoryID_open }" />


<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
    <!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>采购管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：委外收货管理</TD>
             <td align="right" width="40%" valign="bottom">&nbsp;
             <c:if test="${(permissionPo.keya==1)}">
            		 <img src="${ctx }/img/newbtn/btn_wwshadd_0.png" btn=btn title="委外收货新增" onClick="insert()"> 
            	</c:if>
				<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR><TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
          <!--?Start-->
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                       onclick="JavaScript:window.location.href='initSalesIdsSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">未收货委外配镜单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">未收货委外重订单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD>
                   
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                       onclick="JavaScript:window.location.href='initConsignProcessTakeSel.action?moduleID=${requestScope.moduleID}';"
                      UNSELECTABLE="on">已收货委外配镜单</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
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
                    </TABLE>
					<table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <TR>
						   <TD width="8%" height="26" class="table_body">配镜单号</TD>
			               <TD width="28%" class="table_none">
                            <input class="text_input160" type="text"  id="glassid" name="glassid" value="${requestScope.glassid}">
			               </TD>
			               <TD width="8%" height="26" class="table_body">制造商</TD>
			               <TD  class="table_none" width="28%">
                           <select id="supplierID" name="supplierID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="supplierList">
				               <option value="${bspid}" ${supplierID == bspid ? 'selected="selected"' : '' }>${bspsuppliername}</option>
	     	                 </s:iterator></select>			               
			               </TD>
			               <TD width="8%" height="26" class="table_body">销售门店</TD>
			               <TD class="table_none" width="23%">
			               <select id="deptID" name="deptID">
                             <option value="">----请选择----</option>
      		                 <s:iterator value="deptList">
				               <option value="${bdpdepartmentid}" ${requestScope.deptID == bdpdepartmentid ? 'selected="selected"' : '' }>${bdpdepartmentname}</option>
	     	                 </s:iterator>
      	                   </select>	
                            <input class="text_input160" type="hidden" id="billid" name="billid" value="${requestScope.billid}">
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">配镜时间</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight">
                           <input id="ssesbsalesdatestarttime"
					       name="ssesbsalesdatestarttime" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'ssesbsalesdateendtime\')}'})"
					       value="${ssesbsalesdatestarttime}" /> 至 
					       <input id="ssesbsalesdateendtime"
					       name="ssesbsalesdateendtime" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'ssesbsalesdatestarttime\')}'})" 
					        value="${ssesbsalesdateendtime}" />
					        </li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today1()"></li>
					        </TD>	
			               <TD height="26" class="table_body">取镜日期</TD>
			               <TD class="table_none">
                            <li class="horizontal_onlyRight"><input id="startTime"
					      		name="startTime" 
					       		type="text" class="text_input100" 
					       		onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})"
					       		value="${requestScope.startTime }" /> 至 <input id="endTime"
					       		name="endTime" 
					       		type="text" class="text_input100" 
					       		onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" 
					        	value="${requestScope.endTime }" /></li><li class="horizontal_onlyRight">
<img src="${ctx }/img/newbtn/btn_today_0.png"  btn=btn title="今天" onClick="today()"></li>
			               </TD>
			               <TD height="26" class="table_body">配镜类型</TD>
			               <TD class="table_none" >
			               <select id="cstcpoordergoodscategory" name="cstcpoordergoodscategory">
                           	  <option value="">----请选择----</option>
								    <option value="2" ${cstcpoordergoodscategory == 2 ? 'selected="selected"' : '' }>框镜订做片</option>
								    <option value="4" ${cstcpoordergoodscategory == 4 ? 'selected="selected"' : '' }>隐形订做片</option>
                           	  </select>          
			               </TD>
                        </TR>
                        <TR>
                          <TD height="26" class="table_body">商品名称</TD>
                          <TD class="table_none">
                              <input class="text_input160" id="goodsName" name="goodsName" value="${goodsName}" maxlength="100">
                          </TD>    
                          <TD height="26" class="table_body">球镜</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" onchange="checkNumberType(this);"  id="minSphjp" name="minSphjp" value="${requestScope.minSphjp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写球镜度数！'}]">
			               </TD>
						   <TD height="26" class="table_body" >柱镜</TD>
			               <TD class="table_none">
                            <input class="text_input80" type="text" onchange="checkNumberType(this);" id="minCyljp" name="minCyljp" value="${requestScope.minCyljp}" maxlength="6" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '请重新填写柱镜度数！'}]">
			               </TD>                     
                        </TR>
                        <TR> 
						<c:choose>
							<c:when test="${systemParameterPo.fspdjsbm == '1'}">
			                    <TD height="26" class="table_body">备注</TD>
			                    <TD class="table_none">
			                        <input class="text_input160" id="remark" name="remark" value="${remark}" maxlength="100">
			                    </TD>                                                                   
				               	<TD height="26" class="table_body">单据识别码</TD>
				               	<TD class="table_none" colspan="3">
	                              <input class="text_input160" type="text" id="djsbm" name="djsbm" value="${requestScope.djsbm}" onkeyup="selectContact(this)"/>
				               	</TD>							
							</c:when>
							<c:otherwise>
		                        <TD height="26" class="table_body">备注</TD>
		                        <TD class="table_none" colspan="5">
		                            <input class="text_input160" id="remark" name="remark" value="${remark}" maxlength="100">
		                        </TD> 							
							</c:otherwise>
						</c:choose>                                                  
                        </TR>
                      </TBODY>
                    </TABLE>
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
					<c:if test="${not empty(salesidList)}"> 
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
                       	   <TH width="3%" scope=col>操作</TH>
                          <TH width="15%" height="26" scope=col>配镜单号</TH>
                          <TH width="10%"  scope=col>会员姓名</TH>
                          <TH width="10%"  scope=col>销售门店</TH>
                          <TH width="20%" scope=col>镜片制造商</TH>
                          <TH width="8%" scope=col>配镜类型</TH>
                          <TH width="12%" scope=col>配镜时间</TH>
                          <TH width="12%" scope=col>取镜时间</TH>
                          <TH scope=col>备注</TH>
						  </TR>
						<s:iterator value="salesidList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        <TD width="3%">
		                    <img src="${ctx }/img/newbtn/cgsh_0.png" btn=btn title='委外收货' onClick="setValue('${cstcpodorderbilld}', '${cstcpodglassesbillid}');">
		                  </TD>
                          <TD height="26">${cstcpodglassesbillid}</TD>
                          <TD height="26">${cstcpodmembername}</TD>
                          <TD height="26">${cstcpoddepartmentname}</TD>
                          <TD>${cstcposuppliername}</TD>
                           <TD>
                          <c:if test="${cstcpogoodscategory=='2'}">
                        	  框镜订做片
                          </c:if>
                          <c:if test="${cstcpogoodscategory=='4'}">
                          	 隐形订做片
                          </c:if>
                          </TD>
		                  <TD>${fn:substring(cstcpodsalesdatetime,0,16)}</TD>
		                  <TD>${fn:substring(cstcpodarriveddate,0,16)}</TD>
						  <TD>${cstcporemark}</TD>
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