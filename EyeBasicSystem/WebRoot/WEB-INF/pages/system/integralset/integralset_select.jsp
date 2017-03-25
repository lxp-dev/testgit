<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>积分管理</title>
</head>
<script>
/**
 * 会员卡类别开窗
 */
function openMemberType(){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("selMemberTypeOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("selMemberTypeOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	
	document.getElementById('popupTitle').innerHTML="【会员卡类别查询】";
}

/**
 * 会员卡类别开窗赋值实现方法
 */
function openMemberTypeValues(objValue){
	var arrayID = new Array();
	var arrayName = new Array();
	var membertypes = eval('(' + objValue + ')');
	for(var i = 0; i < membertypes.length; i++){	
		arrayID[i] = membertypes[i].firmembertype;
		arrayName[i] = membertypes[i].firmembertypename;
	}
	
	document.getElementById('firmembertype').value = arrayID.join(",");
	document.getElementById('firmembertypename').value = arrayName.join(",");
	document.getElementById('memberds').value = document.getElementById('firmembertypename').value;
}

/**
 * 清空会员卡类别
 */
function cleanMemberType(){
	document.getElementById('firmembertype').value = '';
	document.getElementById('firmembertypename').value = '';
	document.getElementById('memberds').value = '';

}

function chkAll(obj){
	if ($(obj).attr('checked')){
		document.getElementById('departmentID').value = '${allDepartmentID}';
		document.getElementById('bdpdepartmentname').value = '${allDepartmentName}';
		document.getElementById('ds').value = '${allDepartmentName}';
	}else{
		document.getElementById('departmentID').value = '';
		document.getElementById('bdpdepartmentname').value = '';
		document.getElementById('ds').value = '';
	}
}
/**
 * 活动门店开窗
 */
function openDepartment(){
	var topRows = top.document.getElementById("total").rows;
	var topCols = top.document.getElementById("btmframe").cols;
	if(is_iPad()){
		showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}else{
		showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
	}
	
	document.getElementById('popupTitle').innerHTML="【活动门店查询】";
}

/**
 * 活动门店开窗赋值实现方法
 */
function openDepartmentValues(objValue){
	var arrayID = new Array();
	var arrayName = new Array();
	var departments = eval('(' + objValue + ')');
	for(var i = 0; i < departments.length; i++){	
		arrayID[i] = departments[i].bdpdepartmentid;
		arrayName[i] = departments[i].bdpdepartmentname;
	}
	
	document.getElementById('departmentID').value = arrayID.join(",");
	document.getElementById('bdpdepartmentname').value = arrayName.join(",");
	document.getElementById('ds').value = document.getElementById('bdpdepartmentname').value;
}

/**
 * 清空活动部门
 */
function cleanDepartment(){
	document.getElementById('departmentID').value = '';
	document.getElementById('bdpdepartmentname').value = '';
	document.getElementById('ds').value = '';
	$('#chks').attr('checked',false);
}
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

    	if ('${focusMsg}' == ''){
    		$('#firID').focus();
        }
    	if ('${focusMsg}' == '1'){
    		$('#firGoodsCategoryID').focus();
        }
    	if ('${focusMsg}' == '2'){
    		$('#supplierName').focus();
        }
    	if ('${focusMsg}' == '3'){
    		$('#brandName').focus();
        }
    	if ('${focusMsg}' == '4'){
    		$('#firGoodsName').focus();
        }
    	
	});
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function update(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initIntegralSetUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initIntegralSetUpdate.action?hid="+id+"&moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【积分累计规则修改】";
	}
	
	function search(){
		integralFrm.action = "integralSetSel.action";
		integralFrm.submit();
		showLoadingBar();
	}
	
	function insert(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initIntegralSetInsert.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initIntegralSetInsert.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【积分累计规则新增】";
	}
	function del(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initIntegralSetDelete.action?hid="+id+"&moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【积分累计规则删除】";
	}
	
	function clean(){
        $('input[clean=clean]').each(function(){
            $(this).val('');
        });
        $('select[clean=clean]').each(function(){
            $(this).val('');
        });
        $('textarea[clean=clean]').each(function(){
            $(this).val('');
        });
	}
	
	function batchUpdate(){
    	var billID='';				
		$('input[id=chk]:checked').each(function(){		
			billID=billID+$(this).val()+',';
		});
		if (billID == ''){
		    alert("请选择积分累计规则!");
		    return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initIntegralSetBatchUpdate.action?hid="+billID,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initIntegralSetBatchUpdate.action?hid="+billID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【批量修改】";
    }
    
    function batchDetele(){    		
		var billID='';				
		$('input[id=chk]:checked').each(function(){		
			billID=billID+$(this).val()+',';
		});
		if (billID == ''){
		    alert("请选择积分累计规则!");
		    return;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		showPopWin("initIntegralSetBatchDelete.action?hid="+billID,450,140,topRows,topCols,returnRefresh(true),true);
		document.getElementById('popupTitle').innerHTML="【批量删除】";
    }

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
		    
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var firGoodsCategoryID = document.getElementById("goodsCategoryID").value.substring(0,1);
	    if(firGoodsCategoryID==''){
	      alert('请选择商品类别!');
	      return false;
	    }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+firGoodsCategoryID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+firGoodsCategoryID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;		
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
	}
	
	function changeGoodsCategory(){
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';		
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
	}	
			
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var firGoodsCategoryID = document.getElementById("goodsCategoryID").value.substring(0,1);
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商!');
	      return false;
	    }	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+firGoodsCategoryID+"&supplierID_open=" +supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+firGoodsCategoryID+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="integralFrm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>营销管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：积分管理</TD>
            <td align="right" valign="bottom">&nbsp;
            	<c:if test="${permissionPo.keya == 1}">
            		<img src="${ctx }/img/newbtn/btn_jfljgzxz_0.png" btn=btn title="积分累计规则新增" onclick="insert();"/>
            	</c:if>
            	<img btn=btn src="${ctx }/img/newbtn/btn_isshowsearch_0.png" title='显隐查询条件' onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
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
                    <TD>
                    <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1                       
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">积分累计规则</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE>
                    </TD>
                    <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1   
                      onclick="JavaScript:window.location.href='integralExchangeSetSel.action?moduleID=${requestScope.moduleID}';"                    
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">积分兑换设置</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
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
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  		<TD width="9%" height="26" class="table_body">商品类别</TD>
	                          <TD width="24%" class="table_none">
							  	<select clean=clean id="goodsCategoryID" name="goodsCategoryID" onchange="changeGoodsCategory();">
							  		<option value="">----请选择----</option>
							  		<option value="1" ${goodsCategoryID == '1' ? 'selected="selected"' : '' } >镜架</option>
							  		<option value="2" ${goodsCategoryID == '2' ? 'selected="selected"' : '' } >配件</option>
							  		<option value="3-0" ${goodsCategoryID == '3-0' ? 'selected="selected"' : '' } >成品片</option>
							  		<option value="3-D" ${goodsCategoryID == '3-D' ? 'selected="selected"' : '' } >订做片</option>
							  		<option value="4-0" ${goodsCategoryID == '4-0' ? 'selected="selected"' : '' } >隐形成品片</option>
							  		<option value="4-D" ${goodsCategoryID == '4-D' ? 'selected="selected"' : '' } >隐形订做片</option>
							  		<option value="5" ${goodsCategoryID == '5' ? 'selected="selected"' : '' } >隐形护理液</option>
							  		<option value="6" ${goodsCategoryID == '6' ? 'selected="selected"' : '' } >太阳镜</option>
							  		<option value="7" ${goodsCategoryID == '7' ? 'selected="selected"' : '' } >耗材</option>
							  		<option value="8" ${goodsCategoryID == '8' ? 'selected="selected"' : '' } >老花镜</option>
							  		<option value="9" ${goodsCategoryID == '9' ? 'selected="selected"' : '' } >视光</option>
								</select></TD>
						   <TD width="8%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input clean=clean id="supplierName" class="text_input160" name="supplierName" value="${supplierName }" readonly="readonly" />
						   		<input clean=clean type="hidden" id="supplierID" name="supplierID" value="${supplierID }"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li></TD>
                           <TD width="9%" class="table_body">商品品种</TD>
			               <TD width="24%" class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="brandName" value="${requestScope.brandName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="brandID" value="${requestScope.brandID}" />
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" ></li>
			               </TD>
                        </tr>
                        <tr>
						   <TD height="26" class="table_body">商品代码</TD>
			               <TD class="table_none">
                            <input clean=clean class="text_input160" type="text"  id="goodsID" name="goodsID" value="${requestScope.goodsID}" maxlength="50">
			               </TD>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none" colspan="3">
                            <input clean=clean class="text_input160" type="text"  id="goodsName" name="goodsName" value="${requestScope.goodsName}" maxlength="200">
			               </TD>
                        </tr>
                       <TR>                             
				                 <TD height="26" class="table_body">活动门店
				                 
				                 </TD>
				             	<TD height="26" class="table_none" colspan="5">
									<li class="horizontal_onlyRight">
									    <input clean=clean class="text_input300" id="bdpdepartmentname" name="bdpdepartmentname" value="${bdpdepartmentname }" type="hidden" />
									    <textarea clean=clean id="ds"  name="ds" readonly="readonly" style="width:800" value="${bdpdepartmentname}">${bdpdepartmentname }</textarea>&nbsp;
									    <input clean=clean class="text_input100" type="hidden" id="departmentID" name="departmentID" value="${departmentID }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取活动部门！'}]"/>
									    
									</li>
									<li class="horizontal_onlyRight">						  		
										<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
									    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="cleanDepartment();" >
								    </li>  	 	            	
				               </TD>
				        </TR>
				        <TR>                             
				                 <TD height="26" class="table_body">会员卡类别
				                 </TD>
				             	<TD height="26" class="table_none" colspan="5">
									<li class="horizontal_onlyRight">
									    <input clean=clean class="text_input300" id="firmembertypename" name="membertypename" value="${membertypename}" type="hidden" />
									    <textarea clean=clean id="memberds"  name="memberds" readonly="readonly" style="width:800" >${membertypename }</textarea>&nbsp;
									    <input clean=clean class="text_input100" type="hidden" id="firmembertype" name="membertype" value="${membertype }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取会员卡类别！'}]"/>
									    
									</li>
									<li class="horizontal_onlyRight">						  		
										<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openMemberType();">
									    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset2" title='清空' onclick="cleanMemberType();" >
								    </li>  	 	            	
				               </TD>
				        </TR>
                      </TBODY>
                    </TABLE>
                     
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
						    <c:if test="${permissionPo.keyd == 1}">	
		                        <img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn title='查询' onClick="javascript:search()">
							    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onClick="clean()">
						    </c:if>	
							<c:if test="${permissionPo.keyc=='1'}">	
								<img src="${ctx }/img/newbtn/btn_plxg_0.png" btn=btn title='批量修改' onClick="javascript:batchUpdate()">
							</c:if>
							<c:if test="${permissionPo.keyb=='1'}">	
								<img src="${ctx }/img/newbtn/btn_plsc_0.png" btn=btn title='批量删除' onClick="batchDetele()">
							</c:if>
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
					<c:if test="${not empty(integralList)}"> 
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
                          <TH width="5%" scope=col><input id=chks type="checkbox" onclick="chkAll()">全选</TH>
                          <TH width="8%" scope=col colspan="2">操作</TH>
                          <TH width="8%" height="26" scope=col>商品类别</TH>
                          <TH width="10%" scope=col>制造商简称</TH>
                          <TH width="10%" scope=col>商品品种</TH>
                          <TH width="10%" scope=col>商品代码</TH>
                          <TH width="10%" scope=col>商品名称</TH>
                          <TH width="10%" scope=col>活动门店</TH>
                          <TH width="10%" scope=col>会员卡类别</TH>
                          <TH width="8%" scope=col>1元兑换积分数</TH>
						</TR>
						<s:iterator value="integralList">
                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
                          <td>
                            <input id=chk type="checkbox" value="${firID}">
                          </td>
                          <TD width="4%"  height="26">
		                  	<c:if test="${permissionPo.keyc == 1}">
		                     <img src="${ctx }/img/newbtn/edit_0.png" btn=btn title='修改' onClick="javascript:update('${firID}')">
		                  	</c:if>
		                  </TD>
		                  <TD  width="4%">
		                  	<c:if test="${permissionPo.keyb == 1}">
		                     <img src="${ctx }/img/newbtn/delete_0.png" btn=btn title='删除' onClick="javascript:del('${firID}')">
		                  	</c:if>
		                  </TD>
                          <TD>${firGoodsCategoryName }</TD>
                          <TD>${firSupplierName }</TD>
                          <TD>${firBrandName }</TD>
                          <TD>${firGoodsID}</TD>
                          <TD>${firGoodsName}</TD> 
                          <TD>${firdepartmentname}</TD>
                          <TD>${firmembertypename}</TD>                          
                          <TD>${firIntegralCount }</TD>
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