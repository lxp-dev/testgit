<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最大折扣设置</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
    	$('#firID').focus();
	});

	function save(){
		if(checkForm(MaxDiscountFrm)){		
			 var fmdmaxdiscount= parseFloat(document.getElementById("fmdmaxdiscount").value);
			    if(fmdmaxdiscount>1||fmdmaxdiscount<0){
			      alert('折扣必须在0-1之间');
			      document.getElementById("fmdmaxdiscount").focus();
			      return false;
			    }
					    
			$("img").removeAttr("onclick");
			MaxDiscountFrm.action = "insertMaxDiscountSet.action";
		    MaxDiscountFrm.submit();
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
	    var fmdgoodscategoryid = document.getElementById("fmdgoodscategoryid").value.substring(0,1);
	    if(fmdgoodscategoryid==''){
	      alert('请选择商品类别!');
	      return false;
	    }
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;	
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+fmdgoodscategoryid,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+fmdgoodscategoryid,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
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
		document.getElementById('fmdgoodsid').value ='';
		document.getElementById('fmdgoodsname').value = '';
	}
	
	function changeGoodsCategory(){
		document.getElementById('supplierID').value = '';
		document.getElementById('supplierName').value = '';		
		document.getElementById('brandID').value = '';
		document.getElementById('brandName').value = '';
		document.getElementById('fmdgoodsid').value ='';
		document.getElementById('fmdgoodsname').value = '';
	}	
			
	/**
	 * 品种开窗
	 */
	function openBrand(){
	    var fmdgoodscategoryid = document.getElementById("fmdgoodscategoryid").value.substring(0,1);
	    var supplierID=document.getElementById('supplierID').value;
	    if(supplierID==''){
	      alert('请选择所属制造商!');
	      return false;
	    }	
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selBrandOpen.action?categoryID_open="+fmdgoodscategoryid+"&supplierID_open=" +supplierID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selBrandOpen.action?categoryID_open="+fmdgoodscategoryid+"&supplierID_open=" + supplierID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【品种查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openBrandValues(json){
		document.getElementById('brandID').value = json.brandID;
		document.getElementById('brandName').value = json.brandName;		
		document.getElementById('fmdgoodsid').value ='';
		document.getElementById('fmdgoodsname').value = '';
	}
	
	function openGoodSingle(){//商品开窗
		var supplierID=$('#supplierID').val();
		var categoryID_open=$('#fmdgoodscategoryid').val();
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
			showPopWin("goodsOpen.action?goodsCategoryID="+categoryID_open+"&supplierID=" + supplierID+"&brandID=" + brand_open+"&supplierName="+EncodeUtf8(supplierName)+"&brandName="+EncodeUtf8(brandName),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("goodsOpen.action?goodsCategoryID="+categoryID_open+"&supplierID=" + supplierID+"&brandID=" + brand_open+"&supplierName="+EncodeUtf8(supplierName)+"&brandName="+EncodeUtf8(brandName),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(json){
		document.getElementById('fmdgoodsid').value=json.goodsID;
		document.getElementById('fmdgoodsname').value=json.goodsName;
	}

	$(document).ready(function(){
		$('#fmdmaxdiscount').bind("keyup",function(){	
			$('#fmdmaxdiscount').val(
				$('#fmdmaxdiscount').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
	});
</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="MaxDiscountFrm" method="post" action="">
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
							  	<select clean=clean id="fmdgoodscategoryid" name="maxDiscountPo.fmdgoodscategoryid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择商品类别！'}]" onchange="changeGoodsCategory()">
							  		<option value="">----请选择----</option>
							  		<option value="1" ${maxDiscountPo.fmdgoodscategoryid == '1' ? 'selected="selected"' : '' } >镜架</option>
							  		<option value="2" ${maxDiscountPo.fmdgoodscategoryid == '2' ? 'selected="selected"' : '' } >配件</option>
							  		<option value="3-0" ${(maxDiscountPo.fmdgoodscategoryid == '3' && maxDiscountPo.fmdiscustomize == '0') ? 'selected="selected"' : '' } >成品片</option>
							  		<option value="3-D" ${(maxDiscountPo.fmdgoodscategoryid == '3' && maxDiscountPo.fmdiscustomize == 'D') ? 'selected="selected"' : '' } >订做片</option>
							  		<option value="4-0" ${(maxDiscountPo.fmdgoodscategoryid == '4' && maxDiscountPo.fmdiscustomize == '0') ? 'selected="selected"' : '' } >隐形成品片</option>
							  		<option value="4-D" ${(maxDiscountPo.fmdgoodscategoryid == '4' && maxDiscountPo.fmdiscustomize == 'D') ? 'selected="selected"' : '' } >隐形订做片</option>
							  		<option value="5" ${maxDiscountPo.fmdgoodscategoryid == '5' ? 'selected="selected"' : '' } >护理液</option>
							  		<option value="6" ${maxDiscountPo.fmdgoodscategoryid == '6' ? 'selected="selected"' : '' } >太阳镜</option>
							  		<option value="7" ${maxDiscountPo.fmdgoodscategoryid == '7' ? 'selected="selected"' : '' } >耗材</option>
							  		<option value="8" ${maxDiscountPo.fmdgoodscategoryid == '8' ? 'selected="selected"' : '' } >老花镜</option>
							  		<option value="9" ${maxDiscountPo.fmdgoodscategoryid == '9' ? 'selected="selected"' : '' } >视光</option>
							</select></TD>
						   <TD width="9%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   	<li class="horizontal_onlyRight">
						   		<input id="supplierName" class="text_input160" name="maxDiscountPo.fmdsuppliername" value="${maxDiscountPo.fmdsuppliername }" readonly="readonly" />
						   		<input type="hidden" id="supplierID" name="maxDiscountPo.fmdsupplierid" value="${maxDiscountPo.fmdsupplierid}"/>
						   	</li>
						   	<li class="horizontal_onlyRight">
						  <img id=ctl00_PageBody_Button1 src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选 择" name=ctl00$PageBody$Button1 onClick="openSupplier();"></li></TD>
                         <TD class="table_body">商品品种</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="brandName" name="maxDiscountPo.fmdbrandname" value="${maxDiscountPo.fmdbrandname}" readonly="readonly">
						   		<input clean=clean type="hidden" id="brandID" name="maxDiscountPo.fmdbrandid" value="${maxDiscountPo.fmdbrandid}" />
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openBrand();" ></li>
			               </TD>
                        </tr>
                        <tr>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none">
                           <li class="horizontal_onlyRight">
						   		<input clean=clean class="text_input160" type="text"  id="fmdgoodsname" name="maxDiscountPo.fmdgoodsname" value="${maxDiscountPo.fmdgoodsname}" readonly="readonly">
						   		<input clean=clean type="hidden" id="fmdgoodsid" name="maxDiscountPo.fmdgoodsid" value="${maxDiscountPo.fmdgoodsid}" />
						   </li>
						   <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title='选择' onClick="openGoodSingle();" ></li>
			               </TD>
							<TD  height="26" class="table_body">最大折扣</TD>
                          	<TD class="table_none" colspan="3">
                          	   <input class="text_input100" id="fmdmaxdiscount" name="maxDiscountPo.fmdmaxdiscount" value="${maxDiscountPo.fmdmaxdiscount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣数！'}]" maxlength="4" >&nbsp;折&nbsp;&nbsp;&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
                          	</TD>

                        </tr>
                        <tr>
                           <TD class="table_body" height="62">备注</TD>
			               <TD class="table_none" colspan="5">
                               <textarea name="maxDiscountPo.fmdreamrk" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [501]}, 'Message' : '备注不能大于500字！'}]">${maxDiscountPo.fmdreamrk }</textarea>
			               </TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                    <br/>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <s:iterator value="selectGoodsLevelList">
                      	<tr>
                    	  <TD height="26" class="table_body" width="8%">商品级别</TD>
			              <td align="left" class="table_none" width="23%">
				               	<input type="hidden" value="${bgluuid}" name="maxDiscountDetailsPo.fmddgoodslevels">${bglname}
                          </td>
                          <TD height="26" class="table_body" width="8%">折扣率</TD>
			              <td align="left" class="table_none">
				               	<input type="text" class="text_input100" value="" name="maxDiscountDetailsPo.fmdddiscounts" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写折扣！'}]">
                          </td>
                        </tr>
                      </s:iterator>
                      </TBODY>
                    </table>
                    </c:if>
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