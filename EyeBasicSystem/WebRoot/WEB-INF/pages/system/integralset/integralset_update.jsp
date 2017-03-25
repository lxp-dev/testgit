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
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function save(){
		if(checkForm(integralFrm)){		    
			$("img").removeAttr("onclick");
			integralFrm.action = "updateIntegralSet.action";
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
						       <input type="hidden" id="firID" class="text_input160" name="integralPo.firID" value="${integralPo.firID }" maxlength="50"/>
                               <input type="hidden" id="firGoodsCategoryID" class="text_input160" name="integralPo.firGoodsCategoryID" value="${integralPo.firGoodsCategoryID }" maxlength="50"/>
                               <input type="hidden" id="firSupplierName" class="text_input160" name="integralPo.firSupplierName" value="${integralPo.firSupplierName }" maxlength="50"/>
                               <input type="hidden" id="firSupplierID" class="text_input160" name="integralPo.firSupplierID" value="${integralPo.firSupplierID }" maxlength="50"/>
                               <input type="hidden" id="firBrandName" class="text_input160" name="integralPo.firBrandName" value="${integralPo.firBrandName }" maxlength="50"/>
                               <input type="hidden" id="firBrandID" class="text_input160" name="integralPo.firBrandID" value="${integralPo.firBrandID }" maxlength="50"/>
                               <input type="hidden" id="firGoodsName" class="text_input160" name="integralPo.firGoodsName" value="${integralPo.firGoodsName }" maxlength="50"/>
                               <input type="hidden" id="firGoodsID" class="text_input160" name="integralPo.firGoodsID" value="${integralPo.firGoodsID }" maxlength="50"/>
                               <input type="hidden" id="firGoodsCategoryName" class="text_input160" name="integralPo.firGoodsCategoryName" value="${integralPo.firGoodsCategoryName }" maxlength="50"/>
						   <TD width="9%" height="26" class="table_body">商品类别</TD>
	                          <TD width="24%" class="table_none">
							  	 ${integralPo.firGoodsCategoryName } &nbsp;
                              </TD>
						   <TD width="9%" class="table_body">制造商</TD>
						   	<TD width="24%" height="26" align="left" class="table_none">
						   		${integralPo.firSupplierName }&nbsp;
						   </TD>
						   <TD width="9%" class="table_body">商品品种</TD>
			               <TD width="24%" class="table_none">
                                 ${integralPo.firBrandName}&nbsp;
			               </TD>
                        </tr>
                        <tr>
			               <TD class="table_body">商品名称</TD>
			               <TD class="table_none">
                                 ${integralPo.firGoodsName}&nbsp;
			               </TD>
							<TD  height="26" class="table_body">消费1元可兑换</TD>
                          	<TD class="table_none" colspan="3">
                          	   <input class="text_input100" id="firIntegralCount" name="integralPo.firIntegralCount" value="${integralPo.firIntegralCount }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写积分数！'},{'Type' : Type.String, 'Formula' : Formula.Float, 'Message' : '请填写正确的积分数！'}]" maxlength="20" >&nbsp;个积分
                          	</TD>

                        </tr>
                                                <TR>                             
				                 <TD height="26" class="table_body">活动门店
				                 
				                 </TD>
				             	<TD height="26" class="table_none" colspan="5">
  	 	            	${integralPo.firdepartmentname}
				               </TD>
				        </TR>
				        <TR>                             
				                 <TD height="26" class="table_body">会员卡类别<br/>
				                 
				                 </TD>
				             	<TD height="26" class="table_none" colspan="5">
	 	            	${integralPo.firmembertypename}
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