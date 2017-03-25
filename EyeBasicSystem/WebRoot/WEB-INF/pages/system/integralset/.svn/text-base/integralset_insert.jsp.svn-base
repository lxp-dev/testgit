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
function memberchkAll(obj){
	if ($(obj).attr('checked')){
		document.getElementById('firmembertype').value = '${memberManagementID}';
		document.getElementById('firmembertypename').value = '${memberManagementName}';
		document.getElementById('memberds').value = '${memberManagementName}';
	}else{
		document.getElementById('firmembertype').value = '';
		document.getElementById('firmembertypename').value = '';
		document.getElementById('memberds').value = '';
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

	function save(){
		if(checkForm(integralFrm)){		    
			$("img").removeAttr("onclick");
			integralFrm.action = "insertIntegralSet.action";
		    integralFrm.submit();
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
		    
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var firGoodsCategoryID = document.getElementById("firGoodsCategoryID").value.substring(0,1);
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
		document.getElementById('firGoodsID').value ='';
		document.getElementById('firGoodsName').value = '';
	}
	
	function changeGoodsCategory(){
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';		
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
		document.getElementById('firGoodsID').value ='';
		document.getElementById('firGoodsName').value = '';
	}	
			
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var firGoodsCategoryID = document.getElementById("firGoodsCategoryID").value.substring(0,1);
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
		document.getElementById('firGoodsID').value ='';
		document.getElementById('firGoodsName').value = '';
	}
	
	function openGoodSingle(){//商品开窗
		var supplierID=$('#supplierID').val();
		var categoryID_open=$('#firGoodsCategoryID').val();
		var brand_open=$('#brandID').val();
		var supplierName = $('#supplierName').val();
		var brandName = $('#brandName').val();

	    if(categoryID_open==''){
		    alert('请选择商品类别!');
		    return false;
		}
	    if(supplierID==''){
		    alert('请选择所属制造商!');
		    return false;
		}
	    if(brand_open==''){
		    alert('请选择所属品种!');
		    return false;
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsOpen.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID+"&brand_open=" + brand_open+"&supplierName="+EncodeUtf8(supplierName)+"&brandName="+EncodeUtf8(brandName),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID+"&brand_open=" + brand_open+"&supplierName="+EncodeUtf8(supplierName)+"&brandName="+EncodeUtf8(brandName),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(json){
		document.getElementById('firGoodsID').value=json.goodsID;
		document.getElementById('firGoodsName').value=json.goodsName;
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
    <TD>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="9%" height="26" class="table_body">商品类别</TD>
	                          <TD width="24%" class="table_none">
							  	<select clean=clean id="firGoodsCategoryID" name="integralPo.firGoodsCategoryID" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择商品类别！'}]" onchange="changeGoodsCategory()">
							  		<option value="">----请选择----</option>
							  		<option value="1" ${integralPo.firGoodsCategoryID == '1' ? 'selected="selected"' : '' } >镜架</option>
							  		<option value="2" ${integralPo.firGoodsCategoryID == '2' ? 'selected="selected"' : '' } >配件</option>
							  		<option value="3-0" ${(integralPo.firGoodsCategoryID == '3' && integralPo.firIscustomize == '0') ? 'selected="selected"' : '' } >成品片</option>
							  		<option value="3-D" ${(integralPo.firGoodsCategoryID == '3' && integralPo.firIscustomize == 'D') ? 'selected="selected"' : '' } >订做片</option>
							  		<option value="4-0" ${(integralPo.firGoodsCategoryID == '4' && integralPo.firIscustomize == '0') ? 'selected="selected"' : '' } >隐形成品片</option>
							  		<option value="4-D" ${(integralPo.firGoodsCategoryID == '4' && integralPo.firIscustomize == 'D') ? 'selected="selected"' : '' } >隐形订做片</option>
							  		<option value="5" ${integralPo.firGoodsCategoryID == '5' ? 'selected="selected"' : '' } >隐形护理液</option>
							  		<option value="6" ${integralPo.firGoodsCategoryID == '6' ? 'selected="selected"' : '' } >太阳镜</option>
							  		<option value="7" ${integralPo.firGoodsCategoryID == '7' ? 'selected="selected"' : '' } >耗材</option>
							  		<option value="8" ${integralPo.firGoodsCategoryID == '8' ? 'selected="selected"' : '' } >老花镜</option>
							  		<option value="9" ${integralPo.firGoodsCategoryID == '9' ? 'selected="selected"' : '' } >视光</option>
							</select></TD>
						   <TD width="9%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input id="supplierName" class="text_input160" name="integralPo.firSupplierName" value="${integralPo.firSupplierName }" readonly="readonly" />
						   		<input type="hidden" id="supplierID" name="integralPo.firSupplierID" value="${integralPo.firSupplierID}"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li></TD>
                          <TD width="9%" class="table_body">商品品种</TD>
			               <TD width="24%" class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="integralPo.firBrandName" value="${integralPo.firBrandName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="integralPo.firBrandID" value="${integralPo.firBrandID}" />
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" ></li>
			               </TD>
                        </tr>
                        <tr>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="firGoodsName" name="integralPo.firGoodsName" value="${integralPo.firGoodsName}" readonly="readonly">
						   		<input clean=clean type="hidden" id="firGoodsID" name="integralPo.firGoodsID" value="${integralPo.firGoodsID}" />
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openGoodSingle();" ></li>
			               </TD>
							<TD  height="26" class="table_body">消费1元可兑换</TD>
                          	<TD class="table_none" colspan="3">
                          	   <input class="text_input100" id="firIntegralCount" name="integralPo.firIntegralCount" value="${integralPo.firIntegralCount }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写积分数！'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '请填写正确的积分数！'}]" maxlength="20" >&nbsp;个积分
                          	</TD>

                        </tr>
                        <TR>                             
				                 <TD height="26" class="table_body">活动门店<br/>
				                 <input type="checkbox" id="chks" name="chks" onclick="chkAll(this)">所有门店
				                 </TD>
				             	<TD height="26" class="table_none" colspan="5">
									<li class="horizontal_onlyRight">
									    <input clean=clean class="text_input300" id="bdpdepartmentname" name="integralPo.firdepartmentname" value="${integralPo.firdepartmentname }" type="hidden" />
									    <textarea clean=clean id="ds"  name="ds" readonly="readonly" style="width:1000" value="${integralPo.firdepartmentname}">${integralPo.firdepartmentname }</textarea>&nbsp;
									    <input clean=clean class="text_input100" type="hidden" id="departmentID" name="integralPo.firdepartmentid" value="${integralPo.firdepartmentid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取活动部门！'}]"/>
									    
									</li>
									<li class="horizontal_onlyRight">						  		
										<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
									    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="cleanDepartment();" >
								    </li>  	 	            	
				               </TD>
				        </TR>
				        <TR>                             
				                 <TD height="26" class="table_body">会员卡类别<br/>
				                 <input type="checkbox" id="memberchks" name="memberchks" onclick="memberchkAll(this)">所有会员卡
				                 </TD>
				             	<TD height="26" class="table_none" colspan="5">
									<li class="horizontal_onlyRight">
									    <input clean=clean class="text_input300" id="firmembertypename" name="integralPo.firmembertypename" value="${integralPo.firmembertypename}" type="hidden" />
									    <textarea clean=clean id="memberds"  name="memberds" readonly="readonly" style="width:1000" >${integralPo.firmembertypename }</textarea>&nbsp;
									    <input clean=clean class="text_input100" type="hidden" id="firmembertype" name="integralPo.firmembertype" value="${integralPo.firmembertype }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取会员卡类别！'}]"/>
									    
									</li>
									<li class="horizontal_onlyRight">						  		
										<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openMemberType();">
									    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset2" title='清空' onclick="cleanMemberType();" >
								    </li>  	 	            	
				               </TD>
				        </TR>

                        <tr>
                           <TD class="table_body" height="62">备注</TD>
			               <TD class="table_none" colspan="5">
                               <textarea name="integralPo.firReamrk" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [501]}, 'Message' : '备注不能大于500字！'}]">${integralPo.firReamrk }</textarea>
			               </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
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