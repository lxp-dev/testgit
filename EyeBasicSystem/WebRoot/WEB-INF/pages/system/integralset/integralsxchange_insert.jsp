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

	function deleteItem(){
	    if($('.row').size()==0){
			alert('请选择要删除的单据!');
			return;
		}
		$('input[name=chk]:checked').each(function(){
			$(this).parent().parent().remove();		
		});
		document.all.chks.checked = false;
	}
	
	function openGoodSingle(){//商品开窗
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initExchangeGoodsOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initExchangeGoodsOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goods = eval('(' + objValue + ')');
		for(var i = 0; i < goods.length; i++){	
			addRow(goods[i]);			
		}	
	}

	var index = 0;
	function addRow(goods){
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);

		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
		    if (chk[i].value == goods.goodsID) return;
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
		c1.height="26";
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="' + goods.goodsID + '" >';
        c2.innerHTML = goods.goodsID + '<input type="hidden" name="goodsInfoTempPo.goodsid" value="' + goods.goodsID +'" />';
        c3.innerHTML = goods.goodsName + '<input type="hidden" name="goodsInfoTempPo.goodsname" value="' + goods.goodsName +'"  />';
        c4.innerHTML = '<input type="text" class="text_input100" name="goodsInfoTempPo.goodsquantity" value="0" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写积分数！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的积分数！\'}]" maxlength="20" onblur="if(isNaN(this.value)) {this.value = \'0\';}"/>';
        c5.innerHTML = '<input type="text" class="text_input100" name="goodsInfoTempPo.personNum" value="0" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写每人最多兑换数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的数量！\'}]" maxlength="20" onblur="if(isNaN(this.value)) {this.value = \'0\';}"/>';
        c6.innerHTML = '<input type="text" class="text_input100" name="goodsInfoTempPo.SumNum" value="0" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品总数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的数量！\'}]" maxlength="20" onblur="if(isNaN(this.value)) {this.value = \'0\';}"/>';
        c7.innerHTML = '<input type="text" class="text_input120" name="goodsInfoTempPo.easyName" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品简称！\'}]" maxlength="20" />';
        
	 }

	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }

	function save(){
		if(!$('#departmentID').val()){
			alert('请选择兑换门店!');
			return;
		}
	    if($('.row').size()==0){
			alert('请选择商品!');
			return;
		}

		var issubmit = "0";
		$("input[name=goodsInfoTempPo.goodsquantity]").each(function (){
			if($(this).val() < 0){
				alert("请正确填写积分！");
				issubmit = "1";
				$(this).focus();
				$(this).select();
				return;
			}
		});

		if(issubmit == "1"){
			return;
		}
		
		if(checkForm(integralFrm)){		    
			$("img").removeAttr("onclick");
			integralFrm.action = "insertIntegralExchangeSet.action";
		    integralFrm.submit();
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
         	if($(this).val()== goodInfo.goodsID){
			   $(this).parent().parent().remove();	
           }
		});
    }

	function openAllGoodsValues(json){
		integralFrm.action="queryExchangeGoods.action?goodsCategoryID="+json.goodsCategoryID+"&supplierID="+json.supplierID+"&brandID="+json.brandID+"&goodsID="+json.goodsID+"&goodsName="+json.goodsName+"&moduleID=${moduleID}"+"&costprice="+json.costprice+"&retailprice="+json.retailprice+"&teachnologyType="+json.teachnologyType;
		integralFrm.submit();
	}

	$(document).ready(function(){
		 <s:iterator value="goodsList" status="idx">
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
				
		// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == '${bgigoodsid}')  return;
		}
		
		row.className = 'row';
		c1.height="26";

		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="${bgigoodsid}">';
        c2.innerHTML = '${bgigoodsid}'+ '<input type="hidden" name="goodsInfoTempPo.goodsid" value="${bgigoodsid}" />';
        c3.innerHTML = '${bgigoodsname}'+ '<input type="hidden" name="goodsInfoTempPo.goodsname" value="${bgigoodsname}" />';
        c4.innerHTML = '<input type="text" class="text_input100" name="goodsInfoTempPo.goodsquantity" value="0" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写积分数！\'},{\'Type\' : Type.String, \'Formula\' : Formula.UFloat, \'Message\' : \'请填写正确的积分数！\'}]" maxlength="20" onblur="if(isNaN(this.value)) {this.value = \'0\';}"/>';
        c5.innerHTML = '<input type="text" class="text_input100" name="goodsInfoTempPo.personNum" value="0" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写每人最多兑换数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的数量！\'}]" maxlength="20" onblur="if(isNaN(this.value)) {this.value = \'0\';}"/>';
        c6.innerHTML = '<input type="text" class="text_input100" name="goodsInfoTempPo.SumNum" value="0" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品总数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'请填写正确的数量！\'}]" maxlength="20" onblur="if(isNaN(this.value)) {this.value = \'0\';}"/>';
        c7.innerHTML = '<input type="text" class="text_input120" name="goodsInfoTempPo.easyName" value="" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品简称！\'}]" maxlength="20" />';
        
		 </s:iterator>
	});	

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
	function chkAllgoods(thiz){
		if ($(thiz).attr('checked')){
			$("input[id=chk]").attr("checked",true);
		}else{
			$("input[id=chk]").attr("checked",false);
		}
	}
	function openDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selDepartmentOpen.action?departmentType=1&isclosed=0",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【兑换门店查询】";
	}

	function cleanDepartment(){
		document.getElementById('departmentID').value = '';
		document.getElementById('bdpdepartmentname').value = '';
		document.getElementById('ds').value = '';
		$('#chks').attr('checked',false);
	}

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
				    <table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
                      <table width="100%"  border=0 align=center cellpadding=0 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
				        <TR>                             
			                <TD height="26" class="table_body" width="10%">兑换门店<br/>
			                	<input type="checkbox" id="chks" name="chks" onclick="chkAll(this)">所有门店
			                </TD>
			             	<TD height="26" class="table_none" colspan="5">
								<li class="horizontal_onlyRight">
								    <input clean=clean class="text_input300" id="bdpdepartmentname" value="" type="hidden" />
								    <textarea clean=clean id="ds"  name="ds" readonly="readonly" style="width:1000" value=""></textarea>&nbsp;<span class="STYLE1">*</span>
								    <input clean=clean type="hidden" id="departmentID" name="departmentID" value="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选取兑换门店！'}]"/>
								    
								</li>
								<li class="horizontal_onlyRight">						  		
									<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="openDepartment();">
								    <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn name="reset" title='清空' onclick="cleanDepartment();" >
							    </li>  	 	            	
			               </TD>
				        </TR>
                    </TABLE>
                    <br/>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img src="${ctx}/img/newbtn/btn_addgoods_0.png" btn=btn  title="单品添加商品" onclick="openGoodSingle();">
                          <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onclick="deleteItem()" >
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
                    <br/>
					  <table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="5%" scope=col><input type="checkbox" id="chks" name="chks" onclick="chkAllgoods(this)">全选</TH>
                          <TH width="15%" height="26" scope=col>商品代码</TH>
                          <TH width="20%" scope=col>商品名称</TH>
                          <TH width="8%" scope=col>兑换积分</TH>
                          <TH width="8%" scope=col>每人最多兑换数量</TH>
                          <TH width="8%" scope=col>商品总数量</TH>
                          <TH width="8%" scope=col>兑换商品简称</TH>
						</TR>
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