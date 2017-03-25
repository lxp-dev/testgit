<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品退货</title>
<style type="text/css">
.STYLE1 {	color: #FF0000;
	font-weight: bold;
}
</style>
</head>
<script>
	function save(){
	    if(checkForm(document.all.preSalesForm)){ 
			if($('.row').size() == 0) {
				alert("请选择销售门店!");
				return;
			}

			$("img").removeAttr("onclick");
			preSalesForm.action = "prePersonSalesInsert.action";
			preSalesForm.submit();
		}
	}
	
	$(document).ready(function() { 
		$("img[btn=btn]").attr("style","cursor: hand"); 
		$("img[btn=btn]").mouseover(function () { 
		$(this).attr("src",$(this).attr("src").replace("0","1")); 
		}).mouseout(function () { 
		$(this).attr("src",$(this).attr("src").replace("1","0")); 
		}); 
	});

	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		var predate = $('#startTime').val() + '-' + $('#endTime').val();
		
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == (goodInfo.personid + predate)) return;
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);	
		var c6 = row.insertCell(5);	 
		var c7 = row.insertCell(6);	       
		
		row.className = 'row';
		row.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goodInfo.personid + '" >';
        c2.innerHTML = goodInfo.personid + '<input type="hidden" id="ssepspersonid" name="preShopSalesTempPo.ssepspersonid" value="' + goodInfo.personid +'" />';
        c3.innerHTML = goodInfo.personName ;
        c4.innerHTML = goodInfo.departmentName + '<input type="hidden" id="ssepsshopcode" name="preShopSalesTempPo.ssepsshopcode" value="' + goodInfo.departmentID  +'" />';
        c5.innerHTML = $('#startTime').val() + '<input type="hidden" id="ssepspredate" name="preShopSalesTempPo.ssepsprebgndate" value="' + $('#startTime').val() +'" />';
        c6.innerHTML = $('#endTime').val() + '<input type="hidden" id="ssepspredate" name="preShopSalesTempPo.ssepspreenddate" value="' + $('#endTime').val() +'" />';
        c7.innerHTML = '<input  type="text" id="quantity" onblur="amount()" name="preShopSalesTempPo.ssepssalesprice" class="text_input60" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写计划销售金额!!\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请重新填写计划销售金额!!\'}]" onblur="toFix(this)" />';	
    }

	function toFix(obj){
		if(obj.value!=''){
			obj.value=parseFloat(obj.value).toFixed(2);
		}
	}
	
	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
		}
	}
	function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		$("input[id=chk]").each(function(){
			
         	if($(this).val()== goodInfo.personid){
			   $(this).parent().parent().remove();	
           }
		});
    }
	
	  function deleteitem(){
			var chk=document.getElementsByName("chk");
			var table = document.getElementById('addTable');
			for(i = 0; i < chk.length; i++){
				if (chk[i].checked ) {
					var curRow = chk[i].parentNode.parentNode;		
					table.deleteRow(curRow.rowIndex);
					i = -1;
				}
			}
			document.all.chks.checked = false;
			amount();
	    }

	function amount() {
		var sum = 0;
		$("input[id=quantity]").each(function() {
			sum = accAdd($(this).val(),sum);
		})
		$("TH[id=goodsquantityTotal]").html(parseFloat(sum).toFixed(2));
	}

	function checkAll() {
		$("input[id=chk]").each(function() {
			$(this).attr("checked", $("#chks").attr("checked"));
		});
	}

	function batchUpdate() {
		var val = $("#batchValue").val();
		if($("input[id=chk]:checked").length <= 0) {
			alert("请先选取销售人员!");
		} else {
			if(!val || isNaN(val)) {
				alert("请重新填入计划金额!");
				$("#batchValue").focus();
			} else {
				$('input[id=chk]:checked').parent().parent().find('input[id=quantity]').val(val);
			}
		}	

		amount();
	}

	/**
	 * 部门开窗
	 */
	function openDepartment(){
		if($('#startTime').val() == '' || $('#endTime').val() == ''){
            alert('请选取任务日期!');
            return;
	    }
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initPrePersonSalesOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initPrePersonSalesOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【员工查询】";
	}

	/**
	 * 开窗赋值实现方法
	 */
	function openDepartmentValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRow(goodInfos[goodsI]);
		}
	}
	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="preSalesForm" method="post" action=""> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
                          <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                          <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                        </TR>
                      </TBODY>
                    </TABLE>                  
                    <TABLE cellSpacing=1 cellPadding=0 width="100%" align=center class="privateBorder"
                  border=0>
                      <TBODY>
                        <TR height="26">
			               <TD width="5%" height="26" class="table_body">任务年月</TD>               
			               <TD class="table_none" width="20%">
	                            <li class="horizontal_onlyRight">
	                               <input id="startTime"
							       name="startTime" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取起始日期！'}]" 
							       type="text" class="text_input80" clean=clean  
							       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'endTime\')}'})" />
							                  至 
							       <input id="endTime" clean=clean 
							       name="endTime" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取截止日期！'}]" 
							       type="text" class="text_input80" 
							       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'startTime\')}'})" />
						       </li>
						       <li class="horizontal_onlyRight">
								  <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today('startTime','endTime')">
							   </li>
							   <span class="STYLE1">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							   <li class="horizontal_onlyRight">	
      	                          <img src="${ctx}/img/newbtn/btn_tjyg_0.png" btn=btn title="添加员工" onClick="javascript:openDepartment();">
      	                       </li>
						   </TD>
						</TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>                        
                          <TD align="left">
                           <li class="horizontal_onlyRight">
						   <input class="text_input80" id="batchValue" type="text" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.UFloatORNULL, 'Message' : '请重新填写计划金额！'}]" onblur="if(!isNaN(this.value)) { if($.trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"/>
						   </li>
                           <li class="horizontal_onlyRight">
						   <img src="${ctx }/img/newbtn/btn_plxg_0.png" btn=btn title='批量修改' onClick="batchUpdate()">
						   </li>
						   <li class="horizontal_onlyRight">
						   <img id="del" src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title='删除' onClick="deleteitem();">
						   </li>
                         </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                       <TBODY>
                         <TR>
                           <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                           <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                         </TR>
                       </TBODY>
                    </TABLE>
					<TABLE id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="7%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="checkAll()"></TH>                        
                          <TH width="15%" scope=col>员工编号</TH>
                          <TH width="15%" scope=col>员工姓名</TH>
                          <TH width="15%" scope=col>销售门店</TH>
                          <TH width="10%" scope=col>起始日期</TH>
                          <TH width="10%" scope=col>截止日期</TH>
                          <TH width="20%" scope=col>计划销售金额</TH>
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=6 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
						  	<TH scope=col width="5%" id="goodsquantityTotal">0</TH>
				   		</TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR>
                          <TD align="left">
                          	<li class="horizontal_onlyRight">

                          		<img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
                          	</li>
                          	<%--<li class="horizontal_onlyRight">
                          		<input type="checkbox" id="cstiauditstate" name="inventoryPo.cstiauditstate" value="1">保存并审核
                          	</li>--%>
                           </TD>
					   </TR>
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