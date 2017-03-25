<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>凭证管理</title>		
<script type="text/javascript">
	/**
	 *  新增凭证
	 */ 
	function insert2(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initVoucherTallyInsert.action?moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initVoucherTallyInsert.action?moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【凭证新增】";
	}
	
/**
 *  初始化修改凭证
 */ 
	function update2(voucherID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initVoucherTallyUpdate.action?voucherID="+voucherID+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initVoucherTallyUpdate.action?voucherID="+voucherID+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【凭证修改】";
	}
	
/**
 *  初始化删除凭证
 */ 
	function del2(voucherID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initVoucherDelete.action?voucherID="+voucherID+"&moduleID=${moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【凭证删除】";
	}
	
/**
 *  查询凭证详细信息
 */ 
	function detail2(voucherID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selVoucherTallyDetail.action?voucherID="+voucherID+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selVoucherTallyDetail.action?voucherID="+voucherID+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【凭证详细】";
	}

    /*
	 * 反审核凭证
	 */
	function auditVoucher2(voucherID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initAuditUnVoucherTally.action?voucherID="+voucherID+"&moduleID=${moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【凭证反审核】";
	}
		
   /**
    *  新增凭证
    */ 
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initPayMentVoucherInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPayMentVoucherInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【凭证新增】";		
	}
		
   /**
    *  初始化删除凭证
    */ 
	function del(voucherID,typeID){
		if (typeID == '131'){
			del2(voucherID);
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initPayMentVoucherDelete.action?voucherID="+voucherID+"&moduleID=${requestScope.moduleID}",450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【凭证删除】";		
	}

   /**
    *  初始化修改凭证
    */ 
	function update(voucherID,typeID){
		if (typeID == '131'){
			update2(voucherID);
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initPayMentVoucherUpdate.action?voucherID="+voucherID+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initPayMentVoucherUpdate.action?voucherID="+voucherID+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【凭证修改】";			
	}
	
   /**
    *  重置
    */        
	function clean(){
	    $('#clear').find("input[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#clear').find("select[clean=clean]").each(function(){
			$(this).val('');
		});
		$('#parentID').val('');
		document.all.sVoucherType.options.length = 0;
		document.all.sVoucherType.options.add(new Option("----请选择----",""));
	}
	
   /**
    *  根据条件查询相关凭证
    */        
	function search(){
	    voucherSelFrm.action = "selPayMentVoucher.action";
	    voucherSelFrm.submit();
		showLoadingBar();
	 }
	 
   /**
    *  根据凭证基本类型改变凭证具体类型
    */        
	 function changeParentID(){	    
	    $("#parentID").val($("#bVoucherType").val());
	    
        if ($('#bVoucherType').val() == '12'){           
            $('#voucherClassif').text('客户名称');
        }else{
        	$('#voucherClassif').text('制造商');
        }
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';
		
        $('#'+'sVoucherType').load("initVoucherTypeByParentID.action?parentID="+$("#parentID").val()); 
	 }
	  
   /**
    *  导入总账
    */ 
	 function posting(){
	    if ($('#softwarePath').val() == ''){
	        alert("尚未连接任何财务软件!");
	    }else{
	        var topRows = top.document.getElementById("total").rows;
			var topCols = top.document.getElementById("btmframe").cols;
			showPopWin($('#softwarePath').val(),450,140,topRows,topCols,returnRefresh(true),true);
			document.getElementById('popupTitle').innerHTML="【凭证传递】";
	    }
	 }
	 
	$(document).ready(function(){    		 
		if (document.all.sVoucherType.options.length == 0){
		    document.all.sVoucherType.options.add(new Option("----请选择----","")); 
		}
		
	});
	
   /**
    *  生成记账凭证开窗
    */
	function detail(voucherID,typeID){
		if (typeID == '131'){
			detail2(voucherID);
			return;
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selPayMentVoucherDetail.action?voucherID="+voucherID+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("selPayMentVoucherDetail.action?voucherID="+voucherID+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【凭证详细】";		
	}
	
	 /**
	  * 制造商开窗
	  */
	 function openSupplier(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		var url = '';
		var title = '';
        if ($('#bVoucherType').val() == '12'){           
        	url = 'selOnlyFranchiseeOpen.action';
        	title = "【客户查询】";
        }else{
        	url = 'selSupplierOpen.action';
        	title = "【制造商查询】";
        }
        		
		if(is_iPad()){
			showPopWin(url,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin(url,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML=title;
	 }
	
	 /**
	  * 开窗赋值实现方法
	  */
	 function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;
	 }
	 
	 $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    });

	/**
	 * 部门开窗
	 */
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selDepartmentInOrOutStorageOpen.action?isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentInOrOutStorageOpen.action?isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【部门查询】";
	}

	/**
	 * 部门开窗赋值实现方法
	 */
	function openDepartmentValues(json){
		document.getElementById('departmentID').value = json.id;
		document.getElementById('bdpdepartmentname').value = json.value;
	}
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form method="post" id="voucherSelFrm" action="">
<input id="parentID" name="parentID" type="hidden" value="${requestScope.parentID}">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="softwarePath" name="softwarePath" value="${requestScope.softwarePath}">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 id="clear">
  <TBODY>
  <TR>
    <TD><!-- ͷ˵ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>&nbsp;凭证管理</TD>
          <TD align="left" width="45%"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：凭证查询</TD>
          <TD align="right" width="45%" valign="bottom">&nbsp;
          <c:if test="${permissionPo.keyi == '1'}">
              <img btn=btn src="${ctx }/img/newbtn/btn_jzpzxz_0.png" title='记账凭证新增' onClick="insert2()">
          </c:if>
          <c:if test="${permissionPo.keya == '1'}">
              <img btn=btn src="${ctx }/img/newbtn/btn_pzxz_0.png" title='凭证新增' onClick="insert()" > 
          </c:if>
          <c:if test="${permissionPo.keyh == '1'}">
              <img btn=btn src="${ctx }/img/newbtn/btn_drcwrj_0.png" title='导入财务软件' onClick="posting()" > 
          </c:if>
          <img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
          </TD>
        </TR>
        <TR>
            <TD class=menubar_function_text colspan="3">
            	<table></table>
            </TD>
          </TR>
      
      </TBODY></TABLE><!-- ͷ˵ End --><!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26px">
                          <TD width="8%" class="table_body">凭证号</TD>
                          <TD width="26%" class="table_none"><input clean=clean class="text_input160" id="voucherID" name="voucherID" type="text" value="${voucherID}" maxlength="19"></TD>
                          <TD class="table_body" width="8%">凭证日期</TD>
                          <TD class="table_none" width="26%">
                        <li class="horizontal_onlyRight">
                           <input id="billStartTime" clean=clean
					       name="billStartTime" 
					       type="text" class="text_input80" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'billEndTime\')}'})"
					       value="${billStartTime }" /> 至 
					       <input id="billEndTime" clean=clean
					       name="billEndTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'billStartTime\')}'})" 
					        value="${billEndTime }" />
					        
					       </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('billStartTime','billEndTime')"></li>
					        
					      </TD>
                          <TD width="7%" class="table_body" >审核状态</TD>
                           <TD class="table_none" width="26%">
						   <select clean=clean name="auditStatue">
                            <option value="">----请选择----</option>
                            <option value='0' ${auditStatue == '0' ? 'selected="selected"' : '' }>未审核</option>
                            <option value='1' ${auditStatue == '1' ? 'selected="selected"' : '' }>已审核</option>
                          </select>						   
                          </TD>
                        </TR>
                        <TR height="26px">	
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">
                        <li class="horizontal_onlyRight">  
                           <input id="auditStartTime" clean=clean
					       name="auditStartTime" 
					       type="text" class="text_input80" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'auditEndTime\')}'})"
					       value="${auditStartTime }" /> 至 
					       <input id="auditEndTime" clean=clean
					       name="auditEndTime" 
					       type="text" class="text_input80" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'auditStartTime\')}'})" 
					        value="${auditEndTime }" /> 
					    </li><li class="horizontal_onlyRight">
                            <img btn=btn src="${ctx }/img/newbtn/btn_today_0.png" title="今天" onClick="today('auditStartTime','auditEndTime')"></li>
					    </TD>
					      <TD class="table_body">制作人</TD>
                          <TD class="table_none" ${softwarePath != '' ? '' : 'colspan="3"' }>
                            <input clean=clean type="text" class="text_input160" id="createPersonID" name="createPersonID" value="${createPersonID}">
                          </TD>   
                     <c:if test="${softwarePath != ''}">        
                          <TD width="7%" class="table_body" >过账状态</TD>
                          <TD class="table_none">
						   <select clean=clean name="postStatue">
                            <option value="">----请选择----</option>
                            <option value='0' ${postStatue == '0' ? 'selected="selected"' : '' }>未过账</option>
                            <option value='1' ${postStatue == '1' ? 'selected="selected"' : '' }>已过账</option>
                          </select>						   
                          </TD>
                      </c:if>
                        </TR>
                        <TR height="26px"> 
                          <TD class="table_body">凭证类型</TD>
                          <TD class="table_none">
                            <li class="horizontal_onlyRight">
                            <select clean=clean id="bVoucherType" name="bVoucherType" ${empty(voucherTopIDList) ? 'disabled="disabled"' : ''} onChange="changeParentID()">
                                <option value="">----请选择----</option>
                              <s:iterator value="voucherTopIDList">
                                    <c:if test="${person.personcompanytype == '1'}">
		                                <c:if test="${sLvtvtId=='11' || sLvtvtId=='12' || sLvtvtId=='13'}">
		                                    <option value="${sLvtvtId}"} ${parentID == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
			     	                    </c:if>                                    
                                    </c:if>
                                    
                                    <c:if test="${person.personcompanytype == '2'}">
		                                <c:if test="${sLvtvtId=='11' || sLvtvtId=='13'}">
		                                    <option value="${sLvtvtId}"} ${parentID == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
			     	                    </c:if>
                                    </c:if>
	     	                  </s:iterator>                            
                            </select></li>
                            <li class="horizontal_onlyRight">                               
                            <select clean=clean name="sVoucherType" id="sVoucherType">                                  
                              <s:iterator value="voucherSubsetIDList">
                                <option value="${sLvtvtId}"} ${subID == sLvtvtId ? 'selected="selected"' : '' }>${sLvtvtTypeName}</option>
	     	                  </s:iterator> 
                            </select>
                            </li>
                          </TD>
                          <TD class="table_body"><span id="voucherClassif">制造商</span></TD>
                          <TD class="table_none">
                          <li class="horizontal_onlyRight">
                            <input clean=clean type="text" id="supplierName" name="supplierName" class="text_input160" readonly="readonly" value="${supplierName}">
                            <input clean=clean type="hidden" id="supplierID" name="supplierID" class="text_input160" readonly="readonly" value="${supplierID}">
                          </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onclick="openSupplier();">
                            </li>
                          </TD> 
                          <TD class="table_body">部门</TD>
                          <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input class="text_input160" id="bdpdepartmentname" name="bdpdepartmentname" type="text" clean=clean value="${bdpdepartmentname}"/>						   		
						   		<input type="hidden" id="departmentID" name="departmentID" class="text_input160" clean=clean value="${departmentID}"/>
						   </li>
						   <li class="horizontal_onlyRight">
						  		<img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openDepartment();">
						   </li>
                          </TD>
                        </TR>
                        </TBODY>
                    </TABLE>
					<table id="title2" cellspacing="2">
                      <TBODY>
                        <TR>
                          <TD align="left">
                          <c:if test="${permissionPo.keyd == '1'}">

							<img btn=btn src="${ctx }/img/newbtn/btn_search_0.png" title='查询' onclick="search();" >			
                            <img btn=btn src="${ctx }/img/newbtn/btn_empty_0.png" title='清空' onclick="clean();" >	
						  </c:if>	
						  </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
                    <c:if test="${not empty(voucherList)}">
					 <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                     </TABLE>
					 <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH scope=col width="12%" colspan="3">操作</TH>
                          <TH scope=col width="15%" height="26">凭证号</TH>
						  <TH scope=col width="16%">制造商/部门/客户</TH>						
                          <TH scope=col width="10%">凭证日期</TH>
                          <TH scope=col width="8%">制作人</TH>
                          <TH scope=col width="7%">审核人</TH>
						  <TH scope=col width="8%">金额</TH>	
                        </TR>
                      <s:iterator value="voucherList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                        <c:if test="${sLvvAuditStatue=='1'}">                         
                          <TD width="4%">
                           <c:if test="${permissionPo.keye == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLvvID}','${sLvvVoucherTypeID}')">
                             </c:if>
		                  </TD>
		                  <c:if test="${sLvvPosting=='1'}">
		                  <TD width="4%">
		                   <c:if test="${permissionPo.keyc == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/edit_2.png" title='修改'>
                             </c:if>
		                  </TD>
                          <TD width="4%">
                          <c:if test="${permissionPo.keyb == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/delete_2.png" title='删除'>
                             </c:if>
		                  </TD>
		                  </c:if>
		                  <c:if test="${sLvvPosting=='0'}">
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyc == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/edit_2.png" title='修改'>
                             </c:if>
		                  </TD>
                          <TD width="4%">
                          <c:if test="${permissionPo.keyb == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/delete_0.png" title='删除' onClick="javascript:del('${sLvvID}','${sLvvVoucherTypeID}')">
                             </c:if>
		                  </TD>
		                  </c:if>
		                  </c:if>		                  
		                  <c:if test="${sLvvAuditStatue=='0'}">
                          <TD width="4%">
                          <c:if test="${permissionPo.keye == '1'}">
                               <img btn=btn src="${ctx }/img/newbtn/search_0.png" title='详细' onClick="javascript:detail('${sLvvID}','${sLvvVoucherTypeID}')">
                              </c:if>
		                  </TD>
		                 
		                  <TD width="4%">
		                   <c:if test="${permissionPo.keyc == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/edit_0.png" title='修改' onClick="javascript:update('${sLvvID}','${sLvvVoucherTypeID}')">
                             </c:if>
		                  </TD>
		                  
		                  <TD width="4%">
		                  <c:if test="${permissionPo.keyb == '1'}">
                             <img btn=btn src="${ctx }/img/newbtn/delete_0.png" title='删除' onClick="javascript:del('${sLvvID}','${sLvvVoucherTypeID}')">
                             </c:if>
		                  </TD>
		                  </c:if>
                          <TD height="26">${sLvvID}</TD>
                          <TD>${sLvvSupplierName}</TD>
                          <TD>${fn:substring(sLvvDate,0,10)}</TD>
                          <TD>${sLvvPersonName}</TD>
                          <TD>${sLvvAuditPersonName}</TD> 
                          <TD>${sLvvCostPriceAmount}</TD>

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
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></form></DIV></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp"%>