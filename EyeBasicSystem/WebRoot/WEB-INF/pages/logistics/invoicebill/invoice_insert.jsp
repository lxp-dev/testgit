<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/orderItem.js"></script>
<script type='text/javascript' src='${ctx }/js/module/autoLoadSupplier.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<title>发票管理</title>
</head>
<script>
    var isAuto = 1;
    var index = 0;
    function updateAuto(obj){
       isAuto = obj;
        if(obj==0){
       $(':input').removeAttr("readonly");
       $(':input').removeAttr("style");}
       if(obj==1){
        $('input[name=invoiceEntryPo.lieienottaxrateamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});
		$('input[name=invoiceEntryPo.lieietaxamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});	
		$('input[name=invoiceEntryPo.lieiecostpriceamount]').each(function(){
			$(this).attr({readonly:"readonly"});
			$(this).attr({style:"background-color:#ACA899"});
		});

       }
    }
    	
	function deleteItem(){
	    if($('.row').size()==0){
			alert('请选择要删除的单据!');
			return;
		}
		$('input[name=chk]:checked').each(function(){
			$(this).parent().parent().remove();		
		});
		document.all.chks.checked = false;
		amount();
	}
	
	function deleteItems(){
		$('input[name=chk]').each(function(){
			$(this).parent().parent().remove();		
		});
		document.all.chks.checked = false;
		amount();
	}
	
	function amount(){
		for(var i=1;i<=6;i++){
			var total=0;
			$('td[id=td'+i+']').each(function(){
				if($(this).text()==''){
					total=parseFloat(accAdd(total,$(this).find("input").val())).toFixed(2);
				}else{
					total=parseFloat(accAdd(total,$(this).text())).toFixed(2);
				}
			});
			$('#td'+i+'t').text(parseFloat(total).toFixed(2));
		}
	}
		
	/**
	 * 输入成本合计
	 */
	function chengbenCal(obj){
		var hanshuidanjia=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').attr("value");
		var chengbenheji = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		var hexiaoshuliang = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		if (chengbenheji == '' || chengbenheji == null){
		    alert("成本合计数据有误!");
		    obj.focus();
		    var danweichengben = $(obj).parent().parent().find('span[id=lieienottaxrate]').text();//attr("value")
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accMul(danweichengben,hexiaoshuliang)).toFixed(2));
		    return;	
		}		
		var cstietaxrate = $(obj).parent().parent().find('input[name=cstietaxrate]').attr("value");	
		if(cstietaxrate=="NaN")
		{
		  cstietaxrate=0.17;
		}	
		
		if (isAuto == 0){
		    return;
		}
		
		//反填单位成本
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));
		
		//反填税额合计
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,eval(cstietaxrate*0.01))).toFixed(2));
		//反填价税合计
		var shuieheji = $(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val();			
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accAdd(chengbenheji,shuieheji)).toFixed(2));
			
		//反填含税单价
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		
		amount();
	}
			
	/**
	 * 输入税额合计
	 */
	function shuieCal(obj){		
		var hexiaoshuliang=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecheckgoodsquantity]').attr("value");
		var cstietaxrate=$(obj).parent().parent().find('input[name=cstietaxrate]').attr("value");
		if(cstietaxrate=="NaN")
		{
		  cstietaxrate=0.17;
		}	
		var chengbenheji = "0";
		var shuieheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').attr("value");
		if(shuieheji == '' || shuieheji == null){
		    alert("税额合计数据有误!");
		    obj.focus();
		    chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");		    
		    $(obj).parent().parent().find('input[name=invoiceEntryPo.lieietaxamount]').val(parseFloat(accMul(chengbenheji,cstietaxrate*0.01)).toFixed(2));
		    return;
		}		
		
		if (isAuto == 0){
		    return;
		}
		
		//反填成本合计	
		chengbenheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrateamount]').val(parseFloat(accDiv(shuieheji,parseFloat(cstietaxrate*0.01))).toFixed(2));	
	
		//反填单位成本		
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieienottaxrate]').val(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(2));
		$(obj).parent().parent().find('span[id=lieienottaxrate]').text(parseFloat(accDiv(chengbenheji,hexiaoshuliang)).toFixed(6));		
						
		//反填价税合计					
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').val(parseFloat(accAdd(chengbenheji,shuieheji)).toFixed(2));
		//alert(parseFloat(accAdd(chengbenheji,shuieheji)).toFixed(2));
			
		//反填含税单价
		var jiashuiheji=$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostpriceamount]').attr("value");
		$(obj).parent().parent().find('input[name=invoiceEntryPo.lieiecostprice]').val(parseFloat(accDiv(jiashuiheji,hexiaoshuliang)).toFixed(2));
		amount();
	}
	
	function save(){
		if($('.row').size()==0){
			alert('请选择单据!');
			return;
		}
		if($('#invoiceStartDate').val()==''){
			alert('请核销日期!');
			return;
		}
		if (vailAmount()){
			alert('金额填写有误,请重新填写!');
			return;
		}

		$("img").removeAttr("onclick");
	    var auditState = document.getElementsByName("auditState");
	    if (auditState != null  && auditState.length != 0 ){
		    if (!auditState[0].checked){
	            invoiceForm.action = "invoiceByBillInsert.action?auditState=0";
	        }else{
	            invoiceForm.action = "invoiceByBillInsert.action?auditState=1";
	        }
	    }else{
	        invoiceForm.action = "invoiceByBillInsert.action?auditState=0";
	    }

		invoiceForm.submit();
	}
	
	function toFixAndNan(obj){
		obj.value=obj.value.replace(/[^0-9.][0-9]*/g,'');
	}
    function toFixAndNum(obj){
		obj.value=obj.value.replace(/[^0-9][0-9]*/g,'');
	}
	
	function toFix(obj){
		if(obj.value != ''){
			obj.value=parseFloat(obj.value).toFixed(2);
		}
	}

	//向下事件税额合计
	function jiashuiDown(thisnum){

		if(event.keyCode == 40){

			var i = thisnum.id.substr(7);
			i=++i;
			document.getElementById("jiashui"+i).focus();
			document.getElementById("jiashui"+i).select();	
		}
	}
	//向下事件价税合计
	function hexiaoDown(thisnum){

		if(event.keyCode == 40){

			var i = thisnum.id.substr(6);
			i=++i;
			document.getElementById("hexiao"+i).focus();
			document.getElementById("hexiao"+i).select();	
		}
	}

    /**
	 * 制造商开窗
	 */
	function openSupplier(){
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selSupplierOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSupplierOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【制造商查询】";
	}
	
	/**
	 * 开窗赋值实现方法
	 */
	function openSupplierValues(json){
		$("#supplierID").val(json.id);
		$("#supplierName").val(json.value);
		deleteItems();
	}
	
	/**
	 *  checkbox全选
	 */
    function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }
    
    /**
	 *  选择单据开窗 
	 */
    function openSelectBill(){
		   
        if($("#invoiceType").val()==''){
			alert('请选择发票类型!');
			return;
		}
    	if($("#supplierID").val()==''){
    		alert('请先选择制造商!');
    		return;
    	}
			
		var typeid = document.getElementsByName('invoiceEntryPo.lieiebillid')[0];
		if (typeid == null){
		    typeid = 1;
		}else{
		    if (typeid.value.substring(0,3)=="PIN" || typeid.value.substring(0,3)=="CPI"){
		        typeid = 1;
		    }else{
		        typeid = 2;
		    }
		}
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initDealingBillByInvoiceOpenSel.action?typeid="+typeid+"&supplierID="+document.getElementById('supplierID').value+"&supplierName="+EncodeUtf8(document.getElementById('supplierName').value)+"&moduleID=${moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDealingBillByInvoiceOpenSel.action?typeid="+typeid+"&supplierID="+document.getElementById('supplierID').value+"&supplierName="+EncodeUtf8(document.getElementById('supplierName').value)+"&moduleID=${moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【单据查询】";
    } 
    
    function openGoodSingleValues2(json){
    
    	var goodInfos = eval('(' + json + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			addRow(goodInfos[i]);
		}	
	}
	
	function addRow(bill){
	
		var typeid = document.getElementsByName('invoiceEntryPo.lieiebillid')[0];
		if (typeid == null){
		    typeid = 0;
		}else{
		    if (typeid.value.substring(0,3)=="PIN" || typeid.value.substring(0,3)=="CPI"){
		        typeid = '采购收货单';
		    }else{
		        typeid = '采购退货单';
		    }
		}
		
		// 商品id去重	
		var issubmit = '0';
		$("input[id=chk]").each(function(){
		    if($(this).val() == bill.billid){
			    issubmit='1';
            }
         	if(typeid == 0 || (typeid != bill.billtypeid)){
				issubmit='1';
            }
		});
		if(issubmit == '1'){
	        return;
	    }
		
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);
		
		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		var c6 = row.insertCell(5);
		var c7 = row.insertCell(6);
		var c8 = row.insertCell(7);
		var c9 = row.insertCell(8);
		var c10 = row.insertCell(9);
		
		row.className = 'row';
		c1.height="26";
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" value="'+bill.billid+'">';
        c2.innerHTML = bill.billid + '<input type="hidden" name="invoiceEntryPo.lieiebillid" value="'+bill.billid+'" />';
        c3.innerHTML = bill.billtypeid + '<input type="hidden" name="invoiceEntryPo.cstiebilltypeid" value="'+bill.billtypeid+'" />';
		c4.innerHTML = bill.billdate + '<input type="hidden" name="invoiceEntryPo.invoiceDate" value="'+bill.billdate+'" />';
		
		c5.innerHTML = bill.billcb + '<input type="hidden" name="invoiceEntryPo.lieiesourcenottaxrateamount" value="'+bill.billcb+'" />';
		c6.innerHTML = bill.billse + '<input type="hidden" name="invoiceEntryPo.lieiesourcetaxamount" value="'+bill.billse+'" />';

		c5.id="td1";
		c6.id="td2";		
		c7.id="td3";
		c8.id="td4";
		c9.id="td5";
		c10.id="td6";
		
		c7.innerHTML = bill.billjs + '<input type="hidden" name="invoiceEntryPo.lieiesourcecostpriceamount" value="'+bill.billjs+'" class="text_input60" >';	
		
		c8.innerHTML =  '<input onkeyup="toFixAndNan(this);amount();" onblur="toFix(this);" type="text" name="invoiceEntryPo.lieienottaxrateamount" value="'+bill.billcb+'" id="chengben${idx.index}" class="text_input60">';		
		c9.innerHTML = '<input onkeyup="toFixAndNan(this);amount();" onblur="toFix(this);" type="text" value="'+bill.billse+'" name="invoiceEntryPo.lieietaxamount" class="text_input60" id="shuie${idx.index}" />';
		c10.innerHTML = '<input onkeyup="toFixAndNan(this);amount();" onblur="toFix(this);" type="text" name="invoiceEntryPo.lieiecostpriceamount" value="'+bill.billjs+'"  id="jiashui${idx.index}" class="text_input60" >';
	
		$('#del' + index).btn().init();
		 
		amount();

		$("#btn1").checked = true;
	}
	
    $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
    
    //子页面删除单行
	function openGoodSingleDeleteValues(objValue){
		var goodInfos = eval('(' + objValue + ')');
		
		for(var i = 0; i < goodInfos.length; i++){
			deleterow(goodInfos[i]);
			
		}
		
		amount();
	}
    
    function deleterow(goodInfo){
    	// 商品id去重
		var table = document.getElementById('addTable');
		
		$("input[id=chk]").each(function(){
         	if($(this).val()== goodInfo.billid){
			   $(this).parent().parent().remove();	
           }
		});
		
		amount();
    }	

    function vailAmount(){
        var scb = document.getElementsByName('invoiceEntryPo.lieiesourcenottaxrateamount');
        var sse = document.getElementsByName('invoiceEntryPo.lieiesourcetaxamount');
        var sjs = document.getElementsByName('invoiceEntryPo.lieiesourcecostpriceamount');
        var dcb = document.getElementsByName('invoiceEntryPo.lieienottaxrateamount');
        var dse = document.getElementsByName('invoiceEntryPo.lieietaxamount');
        var djs = document.getElementsByName('invoiceEntryPo.lieiecostpriceamount');

        for (var i = 0 ; i < scb.length ; i++){
            if ((Number(scb[i].value) < Number(dcb[i].value)) || (Number(sse[i].value) < Number(dse[i].value)) || (Number(sjs[i].value) < Number(djs[i].value))){
                return true;
            }
            if (Number(accAdd(Number(dcb[i].value),Number(dse[i].value))) != Number(djs[i].value)){
                return true;
            }
        }

        return false;
    }
    
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }><form name="invoiceForm" method="post">

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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR height="26">
                          <TD width="9%" class="table_body">发票号</TD>
                          <TD width="24%" class="table_none">${invoiceID }<input type="hidden" name="invoiceID" value="${invoiceID}"/></TD>
                          <TD width="9%" class="table_body">制单日期</TD>
                          <TD width="24%" class="table_none">
                          
                          <input id="invoiceStartDate"
					       name="invoicePo.liidate"
					       type="text" class="text_input140" 
					       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'invoiceEndDate\')}'})"
					       value="${invoiceStartDate }" />                         
                          <input type="hidden" id="invoiceEndDate"  value="${invoiceEndDate }"/>
                          </TD>
                         <TD width="9%" class="table_body">制造商</TD>
			               <TD width="30%" class="table_none">
						   			<li class="horizontal_onlyRight">
							   			<input id="supplierName" readonly="readonly" class="text_input160" name="supplierName" value="${supplierName}"  ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } />
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' }/>
									</li>
						   			<li class="horizontal_onlyRight">
						  			    <img btn=btn src="${ctx }/img/newbtn/btn_change_0.png" title="选择" onClick="openSupplier();" >	
						  			</li>
						   	</TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body" >制单部门</TD>
                          <TD class="table_none" >${person.bdpdepartmentname}<input type="hidden" name="invoicePo.liidepartmentid" value="${ person.departmentID}"/></TD>
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none" >${person.personName }<input type="hidden" name="invoicePo.liicreatepersonid" value="${person.id}"/></TD>
                          <TD class="table_body">发票类型</TD>
                          <TD class="table_none"> 
					           <SELECT id="invoiceType" name="invoiceType" onchange="deleteItems();">
					               <option value="">----请选择----</option>
					             <s:iterator value="invoiceTypeList">
                                   <option value="${sLitID}"} ${typeID == sLitID ? 'selected="selected"' : '' }>${sLitType}</option>
	     	                     </s:iterator> 
					           </SELECT>
					       </TD>
                        </TR>
                        <TR>
                          <TD class="table_body" height="62">备注</TD>
                          <TD class="table_none" colSpan=6>
                            <label>
                              <textarea name="remark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${remark}</textarea>
                            </label>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <img btn=btn src="${ctx }/img/newbtn/btn_xzdj_0.png" title="选择单据" onClick="javascript:openSelectBill()" >
                            <img btn=btn src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onclick="deleteItem()" >
                          </TD>
                        </TR>
                        <TR>
                          <TD align="left" colspan="2">
                             <font color="red">发票审核后,退货单成本合计、税额合计、价税合计变为负值!</font>
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
                        <TR height="26px" class=table_title align=middle >
                           <TH scope=col width="5%" ><li class="horizontal_onlyRight"><input onclick="chkAll()" id="chks" type="checkbox"></li><li class="horizontal_onlyRight">选择</li></TH>
                          <TH scope=col width="18%" >单据编号</TH>
                          <TH width="7%" scope=col>单据类型</TH>                        
                          <TH scope=col width="7%">结算日期</TH>
						  <TH scope=col width="8%">单据成本合计</TH>
                          <TH scope=col width="8%">单据税额合计</TH>
						  <TH scope=col width="8%">单据价税合计</TH>
						  <TH scope=col width="8%">来票成本合计</TH>
                          <TH scope=col width="8%">来票税额合计</TH>
						  <TH scope=col width="8%">来票价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle height="26">
						  <TD >合计：</TD>
						  <TD>&nbsp;</TD>
                          <TD>&nbsp;</TD>
						  <TD>&nbsp;</TD>
                          <TD><div align="center" id="td1t"></div></TD>
                          <TD><div align="center" id="td2t"></div></TD>
                          <TD><div align="center" id="td3t"></div></TD>
                          <TD><div align="center" id="td4t"></div></TD>
                          <TD><div align="center" id="td5t"></div></TD>
                          <TD><div align="center" id="td6t"></div></TD>
                          </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                      <TR>						  
						  <TD align="left">
                          <li class="horizontal_onlyRight"><img btn=btn id="saveBtn" name="saveBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()"></li>
                          <li class="horizontal_onlyRight">
                          <c:if test="${permissionPo.keyj=='1'}"> <input type="checkbox" id="auditState" name="auditState" value="1">保存并审核</c:if> </li>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>