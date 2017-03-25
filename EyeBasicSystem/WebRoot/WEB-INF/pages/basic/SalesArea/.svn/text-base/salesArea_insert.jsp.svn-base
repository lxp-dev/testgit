<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>价格区间维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
    	$('#butid').focus();
    	var typeID = "${requestScope.typeID}";
    	if(typeID == "") {
        	typeID = "1";
    	}
    	
    	setDisabled(typeID);
	});

	function clean(){
		document.getElementById('rrcsapricemin').value = "";
		document.getElementById('rrcsapricemax').value = "";
		$("input[clean=clean]").each(function() {
			if($(this).attr("type") == "checkbox") {
				$(this).attr("checked", false);
			} else {
				$(this).val("");
			}
		});
	}
	function save(){
		if($("#rrcsapricemax").val() == ''){
			$("#rrcsarange").attr('noValidate','noValidate');
		}
		if(checkForm(document.all.unitForm)){
			$("#rrcsarange").removeAttr('noValidate','noValidate');			
			if($("#rrcsapricemax").val() != '' && Number($("#rrcsapricemin").val()) > Number($("#rrcsapricemax").val())){
				alert("请重新填写价格区间,价格下限大于上限!");
				$("#rrcsapricemax").select();
				return;
			}
			if($("#rrcsapricemax").val() != ''){
	            var range = accSub(Number($("#rrcsapricemax").val()),Number($("#rrcsapricemin").val()));
	            if (Number(range) < Number($("#rrcsarange").val()) || Number($("#rrcsarange").val()) == 0){
	    			alert("请重新输入价格区间级差!");
	    			$("#rrcsarange").select();
	    			return;
	                
	            }
			}else{
				$("#rrcsarange").val('0.00');
			}
			
			var count = 0;
			var msg = "";
			if ($('#type').val() == '1'){
				$("input[id=categoryID]").each(function() {
					if($(this).attr("checked") == true) {
						count = accAdd(count,1);
					}
				});
				msg = "请选择商品类型!";
			}else{
				$("input[id=saleTypeID]").each(function() {
					if($(this).attr("checked") == true) {
						count = accAdd(count,1);
					}
				});
				msg = "请选择销售类型!";
			}
		    if(count <= 0) {
				alert(msg);
				return;
			}
				    
			$("img").removeAttr("onclick");
			unitForm.action = "insertSalesArea.action";
			unitForm.submit();
		}
	}
	
	function setDisabled(typeId) {
		if(typeId == 1) {
			$("input[id=saleTypeID]").attr("disabled", true);
			$("input[id=categoryID]").attr("disabled", false);
			$("input[id=saleTypeID]").attr("checked", false);
			$("tr[id=salesTr]").attr("style", "display:none");
			$("tr[id=goodsTr]").attr("style", "");
		} else {
			$("input[id=categoryID]").attr("disabled", true);
			$("input[id=saleTypeID]").attr("disabled", false);
			$("input[id=categoryID]").attr("checked", false);
			$("tr[id=goodsTr]").attr("style", "display:none");
			$("tr[id=salesTr]").attr("style", "");
		}

		$("input[clean=clean]").each(function() {
			if($(this).attr("type") == "checkbox") {
				$(this).attr("checked", false);
			}
		});
		
		$("#type").val(typeId);
	}
	
	function checkAllSales() {
		$("input[chk=chkSales]").attr("checked", $("#chksSales").attr("checked"));
		$("input[chk=chkGoods]").attr("checked", false);
		$("#chksGoods").attr("checked", false);
	}
	
	function checkAllGoods() {
		$("input[chk=chkGoods]").attr("checked", $("#chksGoods").attr("checked"));
		$("input[chk=chkSales]").attr("checked", false);
		$("#chksSales").attr("checked", false);
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form name="unitForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">


<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
					<table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="8%" height="26" class="table_body">价格区间下限</TD>
			               <TD class="table_none" width="20%"><input class="text_input100" clean=clean id="rrcsapricemin" name="salesAreaPo.rrcsapricemin" maxlength="15" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写价格下限!'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请重新填写价格下限!'}]" onblur="if(!isNaN(this.value)) { if($.trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"><label style="color:red;">&nbsp;*</label></TD>						
						   <TD width="8%" class="table_body">价格区间上限</TD>
                           <TD class="table_none" width="20%"><input class="text_input100" clean=clean id="rrcsapricemax" name="salesAreaPo.rrcsapricemax" maxlength="15" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写价格上限!'}]" onblur="this.value=$.trim(this.value);if(!isNaN(this.value)) { if($.trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"></TD>
                           <TD width="8%" class="table_body">区间级差</TD>
                           <TD class="table_none"><input class="text_input100" clean=clean id="rrcsarange" name="salesAreaPo.rrcsarange" maxlength="15" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写价格区间级差!'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请重新填写价格区间级差!'}]" onblur="if(!isNaN(this.value)) { if($.trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"></TD>
                        </TR>
                        <TR>
						   <TD width="10%" height="26" class="table_body">价格区间类型</TD>
			               <TD width="90%" class="table_none" colspan="5">
			                 <select id="type" name="typeID" onchange="setDisabled(this.selectedIndex+1)" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取价格区间类型!'}]">
			                 	<option ${requestScope.typeID eq 1 ? 'selected="selected"' : "" } value="1">商品类型</option>
			                 	<option ${requestScope.typeID eq 2 ? 'selected="selected"' : "" } value="2">销售类型</option>
			                 </select>
			               </TD>
                       </TR>
                        <TR id="goodsTr">
						   <TD width="8%" height="26" class="table_body">商品类别</TD>
			               <TD class="table_none" width="20%" colspan="5">
                             <TABLE>
                               <TR>
                                 <TD colspan="9"><input clean=clean type="checkbox" id="chksGoods" onclick="checkAllGoods()"/>全选</TD>
                               </TR>
                               <TR>
                                 <s:iterator value="goodsCategoryList">
                                   <TD>
                                     <input clean=clean chk="chkGoods" type="checkbox" id="categoryID" name="goodsCategoryID" value="${bgcid }"/>${bgcgoodscategoryname }
                                   </TD>
                                 </s:iterator>
                                   <TD><label style="color:red;">&nbsp;*</label></TD>
                               </TR>
                             </TABLE>
			               </TD>						
                        </TR>
                        <TR id="salesTr">
						   <TD width="10%" height="26" class="table_body">销售类别</TD>
			               <TD width="90%" class="table_none" colspan="5">
                             <TABLE>
                               <TR>
                                 <TD>
                                   <input clean=clean type="checkbox" id="chksSales" onclick="checkAllSales()"/>全选
                                 </TD>
                               </TR>
                               <TR>
                                 <TD>
                                   <input clean=clean type="checkbox" chk="chkSales" id="saleTypeID" name="salesTypeID" value="1" ${requestScope.salesTypeID eq 1 ? 'checked="checked"' : "" }/>框镜成品
                                 </TD>
                                 <TD>
                                   <input clean=clean type="checkbox" chk="chkSales" id="saleTypeID" name="salesTypeID" value="2" ${requestScope.salesTypeID eq 2 ? 'checked="checked"' : "" }/>框镜订制
                                 </TD>
                                 <TD>
                                   <input clean=clean type="checkbox" chk="chkSales" id="saleTypeID" name="salesTypeID" value="3" ${requestScope.salesTypeID eq 3 ? 'checked="checked"' : "" }/>隐形成品
                                 </TD>
                                 <TD>
                                   <input clean=clean type="checkbox" chk="chkSales" id="saleTypeID" name="salesTypeID" value="4" ${requestScope.salesTypeID eq 4 ? 'checked="checked"' : "" }/>隐形订制
                                 </TD>
                                 <TD>
                                   <input clean=clean type="checkbox" chk="chkSales" id="saleTypeID" name="salesTypeID" value="5" ${requestScope.salesTypeID eq 5 ? 'checked="checked"' : "" }/>辅料
                                 </TD>
                                  <TD><label style="color:red;">&nbsp;*</label></TD>
                               </TR>

                             </TABLE>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                            <label style="color:red;">&nbsp;统计售价在【价格区间下限】金额以上(包含)且低于(不包含)【价格区间上限】金额之间的商品或配镜单。</label>
                          </TD>
                        </TR>
                      
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()">
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
    <TD height=5></TD></TR></TBODY></TABLE>
    </form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>