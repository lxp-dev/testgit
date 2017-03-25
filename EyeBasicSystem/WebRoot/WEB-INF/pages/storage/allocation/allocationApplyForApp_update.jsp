<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品调拨管理</title>
</head>
<script>
	//子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		needAmount();
	}
	function addtdgoods(){
		allocationForm.action = "addApplyAllocationForAppDimension.action";
		allocationForm.submit();
	}
	function batchCheckQutity(thiz){
		/*if($(thiz).val()==''){
			alert("请填写商品数量");
			return;
		}
		if(confirm("是否将所有商品数量修改为"+$(thiz).val()+"?")){
			$('input[name=needNumber]').each(function(){
				$(this).val($(thiz).val());
			});
		}*/
	}
	function OnKeyDownEnter(obj){
		if(event.keyCode == 13){
			var index = $("input[name=needNumber]").index(obj)+1;
		    $("input[name=needNumber]").eq(index).focus();
		}
	}

	function deleterow(goodInfo){
		// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
	     	if($(this).val()== goodInfo.bgigoodsid){
			   $(this).parent().parent().remove();	
	       }
		});
		needAmount();
	}

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	/*
	需求数量合计
	*/
	function needAmount(){
		var total=0;
		$('input[name=needNumber]').each(function(){
			total=accAdd(total,$(this).val());
		});
		$('#needTotal').text(total);
	}
	
	/*
	调拨数量合计
	*/
	function amount(item){
  		if('${person.departmenttype}'=='3'){ //仓储调拨数量关联条码数量
	  		if($(item).parent().parent().find('.gbc option').size()!=1){
	  			$(item).parent().find('.number')[0].value=$(item).parent().parent().find('.gbc option').size();  			
	  		}
  		
  			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		}else{
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		}
  	}
	
	function save(){
		if($('.row').size()==0){
			alert('请先选择商品!');
			return;
		}
		
	if(checkForm(document.all.allocationForm)){ 
		var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		if(index==0){
		  alert('请选择商品!');
		  return false;
		}

		if('${systemParameterPo.fspisallocationsupplier}' == '1'){
			if($('#supplierID').val() == ""){
				alert("请选择制造商！");
				return;
			}
		}
		
		$("img").removeAttr("onclick");
		allocationForm.action = "updateApplyAllocationForApp.action";
		allocationForm.submit();
		}
	}

	
	function openGoodSingle(){
	    var categoryID_open = $("#goodscategoryID").val();
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(!categoryID_open){
			categoryID_open = '';
		}

		var supplierID_open = $('#supplierID').val();
		
		if(is_iPad()){
			showPopWin("initGoodsSingleSel.action?whichretail=1&select_retail=1&isshowstealth=1&categoryID_open="+categoryID_open+"&supplierID_open="+supplierID_open,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsSingleSel.action?whichretail=1&select_retail=1&isshowstealth=1&categoryID_open="+categoryID_open+"&supplierID_open="+supplierID_open,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRow(goodInfos[goodsI]);
		}
		needAmount();
		$("input[name='needNumber']").each(function(){
			$(this).bind("keyup",function(){
				$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
			});
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
				}else{
					$(this).val('');
				}
			});	
		});
	}
	
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
			// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) {
				return;
			}
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		
		
		row.className = 'row';
		row.height="28";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" id="goodsid" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec;
		c5.innerHTML = '<input type="text" class="text_input60" ondblclick="batchCheckQutity(this);" maxlength="18" onkeydown="OnKeyDownEnter(this)" name="needNumber" onblur="needAmount();" value="' + ((goodInfo.goodsquantity != "" && goodInfo.goodsquantity != null) ?  goodInfo.goodsquantity : "") + '" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		$('#del'+index).btn().init();
    }

	function openGoodAlert(){
		var categoryID_open = $("#goodscategoryID").val();
		var departmentId =  $("#departmentId").val();
		if('${systemParameterPo.fspisallocationcategory}' == '1'){
			if(categoryID_open == ""){
				alert("请选择商品类别！");
				$("#goodscategoryID").focus();
				$("#goodscategoryID").select();
				return;
			}
		}
		
		if(!categoryID_open){
			categoryID_open = '';
		}

		var supplierID_open = $('#supplierID').val();
		
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		if(is_iPad()){
			showPopWin("initGoodsAlertSel.action?departmentId="+ departmentId +"&categoryID_open="+categoryID_open+"&permissionPokeyg="+'${permissionPo.keyg}&supplierID_open='+supplierID_open,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsAlertSel.action?departmentId="+ departmentId +"&categoryID_open="+categoryID_open+"&permissionPokeyg="+'${permissionPo.keyg}&supplierID_open='+supplierID_open,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		
		document.getElementById('popupTitle').innerHTML="【预警商品查询】";
	}

	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('chaasupplier').value = json.id;
		document.getElementById('bspsuppliername').value = json.value;
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
		needAmount();
		
    }
    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var categoryID_open = document.getElementById('goodscategoryID').value;
	    if(categoryID_open==''){
	      alert('请选择商品类型');
	      return false;
	    }
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("selSupplierOpen.action?categoryID_open="+categoryID_open,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action?categoryID_open="+categoryID_open,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=document.getElementsByName("chk");
        var chks=document.all.chks;
        for(var i=0;i<chk.length;i++){
           chk[i].checked = chks.checked;
        }
    }
    
    window.onload = function(){
    	var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
			
			needAmount();
    };
   
   /**
	*  二维表开窗事件
	*/
	function open2D(){
		var categoryID_open = $("#goodscategoryID").val();
		var supplierID_open = $('#supplierID').val();
		if(!categoryID_open){
			categoryID_open = '';
		}
	
		var goodsIdNew='';
	    var goodsNumNew='';
	    $("input[name=goodsInfoTempPo.goodsid]").each(function(){
	    	goodsIdNew=goodsIdNew+$(this).val()+",";
		});
	    $("input[name=needNumber]").each(function(){
	    	goodsNumNew=goodsNumNew+$(this).val()+",";
		});
	    $('#tdgoodsids').val(goodsIdNew);
	    $('#tdvs').val(goodsNumNew);
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory=" + categoryID_open+"&cstpsupplierid="+supplierID+"&bspsuppliername="+EncodeUtf8(supplierName),970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initGoodsOpen_dimensional.action?tdgoodsids="+$('#tdgoodsids').val()+"&tdvs="+$('#tdvs').val()+"&cstpgoodscategory=" + categoryID_open+"&cstpsupplierid="+supplierID+"&bspsuppliername="+EncodeUtf8(supplierName),screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【商品查询】";
	}
	
	// 二维开窗赋值实现方法
	function openGoodsDimensionValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
		  if(goodInfos[i].v!=''){
			addDimensionRow(goodInfos[i]);	
		  }		
		}
		needAmount();	
	}
	
	function addDimensionRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
			// 商品id去重
		var chk=document.getElementsByName("chk");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.goodsid) {
			    window.close();hidePopWin();selectShow();
				return;
			}
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);		
		
		row.className = 'row';
		row.height="28";
		
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.goodsid + '" >';
        c2.innerHTML = goodInfo.goodsid + '<input type="hidden" id="goodsid" name="goodsInfoTempPo.goodsid" value="' + goodInfo.goodsid +'" />';
        c3.innerHTML = goodInfo.goodsName;
		c4.innerHTML = goodInfo.spec;
		c5.innerHTML = '<input type="text" class="text_input60" ondblclick="batchCheckQutity(this);" maxlength="18" onkeydown="OnKeyDownEnter(this)" name="needNumber" onblur="needAmount();" value="'+goodInfo.v+'" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		$('#del'+index).btn().init();
		
		$("input[name='needNumber']").each(function(){
			$(this).bind("keyup",function(){
				$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
			});
			$(this).bind("blur",function(){
				if(!isNaN($(this).val())){
					$(this).val($(this).val().replace(/[^0-9.][0-9]*/g,''));
				}else{
					$(this).val('');
				}
			});	
		});
   }  
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="smsFlag"  value="${smsFlag }" /> 
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="ioru" name="ioru" value="u" />
<input type="hidden" id="tdgoodsids" name="tdgoodsids" value="${tdgoodsids }" />
<input type="hidden" id="tdvs" name="tdvs" value="${tdvs }" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="supplierID" value="${allocationPo.chaasupplier}" name="allocationPo.chaasupplier"/>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
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
                    <TABLE cellSpacing=1 cellPadding=0 width="100%" align=center 
                  border=0 style='TABLE-LAYOUT: fixed'>
                      <TBODY>
                        <TR>
                          <TD width="9%" class="table_body">申请单号</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" id="cshaabillid" name="allocationPo.cshaabillid" value="${allocationPo.cshaabillid}" readonly="readonly"></TD>
                          <TD width="9%" class="table_body">申请部门</TD>
                          <TD width="24%" class="table_none">
                          ${allocationPo.cshaaoutdepartmentname}
                          <input id="departmentId" name="allocationPo.cshaaindepartmentid" type="hidden" value="${allocationPo.cshaaindepartmentid}"/></TD>	
                          <TD class="table_body" width="9%" height="26" >制单人</TD>
                          <TD class="table_none" width="24%">${allocationPo.cshaacreatepersonname}<input type="hidden" name="allocationPo.cshaacreateperson" value="${person.id}"></TD>			       
			            </TR>
                        <TR>		       
                          <TD class="table_body" width="9%" height="26" >制单日期</TD>
                          <TD class="table_none">
                          ${fn:substring(allocationPo.cshaabilldate,0,10)}
                          </TD>	
                          <c:if test="${systemParameterPo.fspisallocationcategory ne '1'}">
                          <TD width="9%" height="26" class="table_body">接收部门</TD>
                          <TD width="24%" height="26" class="table_none" colspan="3">
                              ${allocationPo.cshaaindepartmentname }
                          </TD>
                          </c:if>
                          <c:if test="${systemParameterPo.fspisallocationcategory eq '1'}">
                          <TD width="9%" height="26" class="table_body">接收部门</TD>
                          <TD width="24%" height="26" class="table_none">
                              ${allocationPo.cshaaindepartmentname }
                          </TD>
                          <TD width="9%" height="26" class="table_body">商品类别</TD>
                          <TD width="24%" height="26" class="table_none">
                              ${allocationPo.goodscategoryname }
                              <input id="goodscategoryID" name="allocationPo.goodscategoryid" type="hidden" value="${allocationPo.goodscategoryid}"/>
                          </TD>
                          </c:if>
						</TR>
						<c:if test="${systemParameterPo.fspisallocationsupplier eq '1'}">
	                        <tr>
	                            <TD width="9%" height="26" class="table_body">制造商</TD>
	                            <TD width="24%" height="26" class="table_none" colspan="5">
	                          		${allocationPo.chaasuppliername}
	                            </TD>                        
	                        </tr>
                        </c:if>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5 style='word-WRAP: break-word'>
                          <textarea id="textarea" name="allocationPo.cshaaremark">${allocationPo.cshaaremark}</textarea>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
						  <img src="${ctx }/img/newbtn/btn_goodsadd_0.png" btn=btn title="单品添加商品" onClick="javascript:openGoodSingle();">
						  <img src="${ctx}/img/newbtn/btn_addredgoods_0.png" btn=btn title="选择预警商品" id="alertGoods" onClick="javascript:openGoodAlert();">
						  <c:if test="${(systemParameterPo.fspisshowsupplierandbrand == '1') || departmenttype != '1' }"> 
						      <img src="${ctx }/img/newbtn/btn_2dadd_0.png" btn=btn title="二维表添加商品" id="2D" onClick="javascript:open2D();"> 
						  </c:if>
						  <img src="${ctx }/img/newbtn/btn_delete_0.png" btn=btn title="删除" onClick="deleteitem();" >
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
					<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align=middle>
                          <TH width="10%" height="26" scope=col>全选<input type="checkbox" id="chks" onclick="chkAll()"></TH>                        
                          <TH width="20%" scope=col>商品代码</TH>
                          <TH width="30%" scope=col>商品名称</TH>
                          <TH width="20%" scope=col>型号</TH>
                          <TH width="20%" scope=col>需求数量</TH>            
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height="26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
					    	<TH scope=col width="5%" id="needTotal">0</TH>

				   		</TR>
                        <s:iterator value="allocationEntryList" status="idx">
                        <TR class="row">
                        <TD height="26"><input id="chk" type="checkbox" value="${cshaaegoodsid}" ></TD>
                        <TD>${cshaaegoodsid}
                        <input id="goodsid" index="${idx.index+1}" type="hidden" name="goodsInfoTempPo.goodsid" value="${cshaaegoodsid}" />
                        <input id="goodsid" type="hidden" name="" value="${idx.index+1}" />
                        </TD>
                        <TD>${cshaaegoodsname}</TD>
                        <TD>${cshaaespec}</TD>
                        <TD><input type="text" ondblclick="batchCheckQutity(this);" class="text_input60" onkeydown="OnKeyDownEnter(this)" name="needNumber" onblur="needAmount()" value="${cshaaerequirementquantity}" onKeyUp="value=value.replace(/[^\d\-]/g,'')" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '数量不能为空'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '数量只能输入整数'}]" /></TD>                                                                        
                        </TR>
                        </s:iterator>
				   		<c:forEach var="po" items="${goodsInfoPos}">
                        <TR class="row">
                        <TD height="26"><input id="chk" type="checkbox" value="${po.bgigoodsid}" ></TD>
                        <TD>${po.bgigoodsid}
                        <input id="goodsid" type="hidden" name="goodsInfoTempPo.goodsid" value="${po.bgigoodsid}" />
                        </TD>
                        <TD>${po.bgigoodsname}</TD>
                        <TD>${po.bgispec}</TD>
                        <TD><input type="text" class="text_input60" onkeydown="OnKeyDownEnter(this)" name="needNumber" onblur="needAmount()" value="${po.bgigoodsquantity}" onKeyUp="value=value.replace(/[^\d\-]/g,'')" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '数量不能为空'},{'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '数量只能输入整数'}]"  /></TD>                                                                        
                        </TR>
                        </c:forEach>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR >
                          <TD align="left">
                          <li class="horizontal_onlyRight">
                          <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onclick="save()">
                          </li>
                          <li class="horizontal_onlyRight">
                          <input type="checkbox" id="cshaaauditstate" name="allocationPo.cshaaauditstate" value="1">保存并审核
                          </li>
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