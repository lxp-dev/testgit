<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<title>商品负调拨管理</title>
</head>
<script>
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
	副调拨数量合计
	*/
	function amount(item){
  		if('${person.departmenttype}'=='3'){ //仓储副调拨数量关联条码数量
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
	//页面内扫码，并将条码付到对应的条码框中
	function onBlurBarCode(barCodeInputObj,goodsId){
		if(event.keyCode==13){  
			var goodsId = goodsId.replace(/\./g,  "").toUpperCase();
			var barCode = barCodeInputObj.val().toUpperCase().substring(0,18);
			if(goodsId != barCode){
				alert("商品代码与商品条码不符！");
				barCodeInputObj.val('');
				return;
			}
			if(barCodeInputObj.val().length<26)
			{
				alert("商品条码位数不符！");
				barCodeInputObj.val('');
				return;
			} 
			$(barCodeInputObj).parent().find('.gbc').get(0).options.add(new Option(barCodeInputObj.val().toUpperCase(),barCodeInputObj.val().toUpperCase()));
			barCodeInputObj.val('');
			barCodeInputObj.focus();
			$(barCodeInputObj).parent().parent().find('.number')[0].value=$(barCodeInputObj).parent().find('.gbc option').size();
			var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		}
		
		
	}
	/*
	移除条码
	*/
	function removeOption(item){
		$(item).parent().find('.gbc').find('option:selected').remove();
		$(item).parent().parent().find('.number')[0].value=$(item).parent().find('.gbc option').size();
		var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
		
	}
	function save(){
		if($('.row').size()==0){
			alert('请先选择商品!');
			return;
		}
		
		for(var i=0;i<document.getElementsByName('goodsInfoTempPo.goodsbarcode').length;i++){
			if(document.getElementsByName('goodsInfoTempPo.goodsbarcode')[i].options.length==0){
				alert('商品条码不能为空!');
				return false;
			}	
		}
	$('select[id=selectGbc]').each(function(){
		
		for(i=0;i<$(this).find("option").length;i++){
			$(this).find("option")[i].selected='selected';
		}
	});
	
	if(checkForm(document.all.allocationForm)){ 
		var table = document.getElementById('addTable');
		var index = table.rows.length-1;
		if(index==0){
		  alert('请选择商品!');
		  return false;
		}
		
        var cshaainstockid=document.all.cshaainstockid.value;
        var cshaaoutstockid=document.all.cshaaoutstockid.value;
        if(cshaainstockid==cshaaoutstockid){
          alert('发出仓位和接受仓位不能一致!');
		  return false;
        } 
		document.all.button1.disabled="true";
		allocationForm.action = "updateReAllocation.action";
		allocationForm.submit();
		}
	}

	
	function openGoodSingle(){
		var supplierID='';
		var categoryID_open='';	
		showPopWin("","initGoodsSingleSel.action?categoryID_open="+categoryID_open+"&supplierID_open=" + supplierID ,screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
	function openGoodSingleValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(goodsI = 0; goodsI < goodInfos.length; goodsI++){
			addRow(goodInfos[goodsI]);
		}
		
	
	}
	var status=1;
	function addRow(goodInfo){
		var table = document.getElementById('addTable');
		var index = table.rows.length - 1;
		
			// 商品id去重
		var chk=document.getElementsByName("chk");
		var goodsquantity=document.getElementsByName("goodsInfoTempPo.goodsquantity");
		for(i = 0; i < chk.length; i++){
			if (chk[i].value == goodInfo.bgigoodsid) {
				goodsquantity[i].style.backgroundColor="red";
				return;
				}
		}
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);      
		var c6 = row.insertCell(5);
		
		row.className = 'row';
		row.height="28";
		c1.innerHTML = '<input id="chk" type="checkbox" value="' + goodInfo.bgigoodsid + '" >';
        c2.innerHTML = goodInfo.bgigoodsid + '<input type="hidden" index="'+goodInfo.bgigoodsid+'" id="goodsid" name="goodsInfoTempPo.goodsid" value="' + goodInfo.bgigoodsid +'" />';
        c3.innerHTML = goodInfo.bgigoodsname;
		c4.innerHTML = goodInfo.bgispec 
		if(goodInfo.bgigoodsid.substring(0,1)=='2'||goodInfo.bgigoodsid.substring(0,1)=='5'||goodInfo.bgigoodsid.substring(0,1)=='7'){
		c5.innerHTML = '<input type="text" class="text_input60 number" maxlength="18" name="goodsInfoTempPo.goodsquantity" value="0" onblur="amount(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}else{
		c5.innerHTML = '<input  readOnly="readOnly" type="text" class="text_input60 number" maxlength="18" name="goodsInfoTempPo.goodsquantity" value="" onblur="amount(this);" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写商品数量！\'},{\'Type\' : Type.String, \'Formula\' : Formula.INT, \'Message\' : \'商品数量应为整数！\'}]"/>';
		}
		c6.innerHTML = '<select id="selectGbc" name="goodsInfoTempPo.goodsbarcode" multiple="multiple" class="text_input200 gbc" style="height:40px" onmousemove="this.style.height=\'100px\';" '+ ' onmouseout="this.style.height=\'30px\';"></select><br/>'+
					'<input index="index'+goodInfo.bgigoodsid+'" onkeyup="this.value=this.value.toUpperCase()" maxlength="26"  onblur="this.value=this.value.toUpperCase()" type="text" maxlength="26" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode($(this),\''+goodInfo.bgigoodsid+'\');"/><br/>'+
					'<input id="del'+status+'" icon=icon-delete type="button" value="删除" onclick="removeOption(this)" >';
		$('#del'+status).btn().init();
		status=status+1;
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
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		document.getElementById('cstisupplierid').value = json.id;
		document.getElementById('cstisuppliername').value = json.value;
		
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
        
    function showSubMenu(obj) {  
    	$('#' + 'cshaainstockid').load("reGetAjaxStock.action?id="+ obj);
    }
    
    window.onload = function(){
    	var total=0;
			$('input[name=goodsInfoTempPo\\.goodsquantity]').each(function(){
				total=accAdd(total,$(this).val());
			});
			$('#goodsquantityTotal').text(total);
			
			needAmount();
    };
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////
       //扫描商品条码事件
	function scanBarCode(obj) {
		if (event.keyCode == 13) {
			if (obj.value === ''||obj.value.length<26) {
				alert('条码位数不符!');
				obj.value='';
				obj.focus();
				return;
			}else {
				searchBar(obj.value);
				obj.value='';
				obj.focus();
			}
		}
	}
	
	function searchBar(obj){
		var indexval = null;
		var goodidval = null;
		$('input[name=goodsInfoTempPo.goodsid]').each(function (){
			if(obj.toUpperCase().substring(0,18)==$(this).val().replace(/\./g,  "").toUpperCase()){
				indexval = $(this).attr("index");
				goodidval = $(this).val();
				
			}
						
		});
		if(indexval==null){
			alert("该商品条码没有匹配的商品！");
			return;
		}
		$('input[index=index'+indexval+']').val(obj);
		var getinput = $('input[index=index'+indexval+']')
		onBlurBarCode(getinput,goodidval);
		
	}
	
	function openGoodMirrorGoods(){
		showPopWin("","initSellMirrorGoodsSel.action",screen.width-200,screen.height-200, '', null, true);
		selectHidden();
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="allocationForm" method="post" action="">
<input type="hidden" name="smsFlag"  value="${smsFlag }" /> 
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<div style="width:100px;height:12px;left:expression(document.body.clientWidth-scrollWidth);top:expression(scrollHeight+15+document.body.scrollTop-this.offsetHeight);position:absolute">
			<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                        <c:if test="${smsFlag!='1'}">
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                  </c:if>
                   <c:if test="${smsFlag=='1'}">
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:window.close();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                  </c:if>
                        </TR>
                      </TBODY>
                    </TABLE></div>

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>商品负调拨管理</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：商品负调拨修改</td>
        </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
	      </TD>
        </TR>
       </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                    <TABLE class="privateBorder" cellSpacing=1 cellPadding=0 width="100%" align=center 
                  border=0>
                      <TBODY>
                        <TR>
                          <TD  height="26" width="9%" class="table_body">负调拨单号</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" id="cshaabillid" name="allocationPo.cshaabillid" value="${allocationPo.cshaabillid}" readonly="readonly"></TD>
                          <TD width="9%" class="table_body">单据日期</TD>
                          <TD width="24%" class="table_none">
                          ${fn:substring(allocationPo.cshaabilldate,0,10)}
                          </TD>					       
						  <TD width="9%" class="table_body">申请部门</TD>
                          <TD class="table_none">
                          ${allocationPo.cshaaoutdepartmentname}
                          </TD>					       
						</TR>
						<TR>
						  <TD height="26" class="table_body">发出仓位</TD>
						  <TD class="table_none">
						   <select id="cshaaoutstockid" name="allocationPo.cshaaoutstockid">
      		                 <s:iterator value="outwarehouselist">
				               <option value="${bwhid}" ${allocationPo.cshaaoutstockid!= bwhid  ? '' : 'selected="selected"' }>${bwhwarehouseName}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
						  <TD height="26" class="table_body">接收部门</TD>
                          <TD class="table_none" >
                            <select id="cshaaindepartmentid" name="allocationPo.cshaaindepartmentid" onchange="showSubMenu(this.options[this.options.selectedIndex].value)" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '接收部门不能为空！'}]">
      		                 <s:iterator value="indepartmentsList">
				               <option value="${bdpdepartmentid}" ${allocationPo.cshaaindepartmentid!= bdpdepartmentid  ? '' : 'selected="selected"' }>${bdpdepartmentname}</option>
	     	                 </s:iterator>
      	                   </select>
                          </TD>
                          <TD class="table_body">接收仓位</TD>
                          <TD class="table_none" >
                            <select id="cshaainstockid" name="allocationPo.cshaainstockid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '接收仓位不能为空！'}]">
								<s:iterator value="inwarehouselist">
                              		<option value="${bwhid}" ${allocationPo.cshaainstockid != bwhid ? '':'selected="selected"'}>${bwhwarehouseName}</option>
                                </s:iterator>
				      	    </select>
                          </TD>
                        </TR>
                        <TR>
                          <TD class="table_body"  height="26">制单人</TD>
                          <TD class="table_none" colspan="5">${allocationPo.cshaacreatepersonname}<input type="hidden" name="allocationPo.cshaacreateperson" value="${person.id}"></TD>
                        </TR>
                        <TR>
                          <TD class="table_body">备注</TD>
                          <TD class="table_none" colSpan=5><label>
                          <textarea id="textarea" name="allocationPo.cshaaremark">${allocationPo.cshaaremark}</textarea>
                          </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
						  <input icon='icon-edit' type='button' value="单品添加商品" onClick="javascript:openGoodSingle();">
						  <input icon='icon-edit' type='button' value="扫码添加商品" onClick="javascript:openGoodMirrorGoods();">
						  <input id="del" icon="icon-delete" type="button" value="删除" onClick="deleteitem();" >
                         </TD>
                           <TD width="20%" align="right"><strong>扫描条码</strong></TD>
                          <TD width="20%" align="left"><input id="scancode" name="scancode" onkeypress="scanBarCode(this)" type="text" maxlength="26" size="30"></TD>
						  
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
                          <TH width="10%" scope=col>型号</TH>
                           <TH width="10%" scope=col>负调拨数量</TH>                               
                          <TH width="20%" scope=col>商品条码</TH> 
                     
                        </TR>
                        <TR class=table_title align=middle> 
						  	<TH width="40%" height=26"  colSpan=4 scope=col align="right">合计：&nbsp;&nbsp;&nbsp;&nbsp;</TH>
 
					    	<TH scope=col width="10%" id="goodsquantityTotal">0</TH>
					    	<TH scope=col width="10%" >&nbsp;</TH>

				   		</TR>
                        <s:iterator value="allocationEntryList" status="idx">
                        <TR class="row">
                        <TD height="26"><input id="chk" type="checkbox" value="${cshaaegoodsid}" ></TD>
                        <TD>${cshaaegoodsid}
                        <input id="goodsid" type="hidden" index="${cshaaegoodsid}" name="goodsInfoTempPo.goodsid" value="${cshaaegoodsid}" />
                        </TD>
                        <TD>${cshaaegoodsname}</TD>
                        <TD>${cshaaespec}</TD>

                       <td>
                        <c:if test="${fn:substring(cshaaegoodsid,0,1)==2||fn:substring(cshaaegoodsid,0,1)==7}">
                       <input type="text" class="text_input60 number" value="${cshaaeallocationquantity}" name="goodsInfoTempPo.goodsquantity"  onblur="amount(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写负调拨数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '负调拨数量应为整数！'}]"/>
                       </c:if>
                       <c:if test="${fn:substring(cshaaegoodsid,0,1)!=2&&fn:substring(cshaaegoodsid,0,1)!=7}">
                       <input type="text" readonly="readonly" class="text_input60 number" value="${cshaaeallocationquantity}" name="goodsInfoTempPo.goodsquantity"  onblur="amount(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写负调拨数量！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '负调拨数量应为整数！'}]"/>
                       </c:if>
                       
                       </td>      
                        <TD>
                
                        <select id="selectGbc" name="goodsInfoTempPo.goodsbarcode" multiple="multiple" class="text_input200 gbc" style="height:40px;" onmousemove="this.style.height='100px'" onmouseout="this.style.height='30px'" />
                     <s:iterator value="allocationBarcodeLists">
                    	 <c:if test="${cshabgoodsid eq cshaaegoodsid}">
                        <option value="${ cshabgoodsbarcode}">${ cshabgoodsbarcode }</option>
                        </c:if>
                        </s:iterator>
                        </select><br/>
					<input onkeyup="this.value=this.value.toUpperCase()" index="index${cshaaegoodsid}"  onblur="this.value=this.value.toUpperCase()" type="text" class="text_input200" name="barCodeInput" onfocus="this.select();" onkeydown="onBlurBarCode(this,'${cshaaegoodsid}');"/><br/>
					<input  icon=icon-delete id="del${cshaaegoodsid}" type="button" value="删除" onclick="removeOption(this)" ></TD>  
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TR >
                      
                          <TD align="left"><c:if test="${permissionPo.keyf=='1'}"><input type="checkbox" id="cshaaauditstate" name="allocationPo.cshaaauditstate" value="1">保存并审核</c:if>
                           </TD>
                        
					   </TR>
					   <TR>
						  <TD align="left"><input id="button1" icon='icon-save' type='button' value='保存' onclick="save()"></TD>
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