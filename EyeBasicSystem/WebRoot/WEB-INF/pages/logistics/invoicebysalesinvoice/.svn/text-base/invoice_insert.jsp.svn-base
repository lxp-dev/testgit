<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>发票管理</title>
<script type="text/javascript">
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
		document.getElementById('supplierID').value = json.id;
		document.getElementById('supplierName').value = json.value;			
		delRows();
	 }
	        
	/**
	 *  清除表格中所有行
	 */        
	 function delRows(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(i = 0; i < chk.length; i++){
			var curRow = chk[i].parentNode.parentNode;		
			table.deleteRow(curRow.rowIndex);
			i = -1;
		}
        amount();
     }
	
	/**
	 *  增加其他付款单
	 */        
	 function save(){
	    if (checkForm(insertPayMentFrm)){
		    
			if($('.row').size()==0){
				alert('请选择填写来票金额!');
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
					    
		    var chk = document.getElementsByName("chk").length;	     
	        if (chk != 0){ 
			    var auditState = document.getElementsByName("auditState");
			    if (auditState != null  && auditState.length != 0 ){
				    if (!auditState[0].checked){
			            insertPayMentFrm.action = "invoiceBySalesInvoiceInsert.action?auditState=0";
			        }else{
			            insertPayMentFrm.action = "invoiceBySalesInvoiceInsert.action?auditState=1";
			        }
			    }else{
			        insertPayMentFrm.action = "invoiceBySalesInvoiceInsert.action?auditState=0";
			    }
	            $("img").removeAttr("onclick");   
		        insertPayMentFrm.submit();  

		            
	        } else{
	            alert('请先选择来票!');
	        }
	        return; 
	    }   

	 }

    var index = 0;
	function addRow(){
		var table = document.getElementById('addTable');
		index = accAdd(index,table.rows.length - 1);

		var row = table.insertRow(table.rows.length);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		
		row.className = 'row';
		c1.height="26";

		c3.id="td1";
		c4.id="td2";		
		c5.id="td3";
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" >';
		c2.innerHTML = '<input class="text_input120" type="text" name="invoiceEntryPo.lieiebillid" maxlength="50" validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写来票号!\'}]" />';	 
        c3.innerHTML = '<input class="text_input60" type="text" name="invoiceEntryPo.lieienottaxrateamount" value="0.00" onblur="toFixAndNan(this,'+index+')" maxlength="18"/>';
        c4.innerHTML = '<input class="text_input60" type="text" name="invoiceEntryPo.lieietaxamount" value="0.00" onblur="toFixAndNan(this,'+index+')" maxlength="18"/>';
        c5.innerHTML = '<input class="text_input60" type="text" name="invoiceEntryPo.lieiecostpriceamount" value="0.00" onblur="toFixAndNan(this,'+index+')" maxlength="18"/>';
		
    }

	function toFixAndNan(obj,index){
		if (obj.value == '' || obj.value == null || obj.value == 'NaN' || isNaN(obj.value)){
		    alert("不正确的金额!");
            obj.value = parseFloat(0.00).toFixed(2);
            amount();
		    return;
		}
		      
        //验证小数点只有0个或1个并且不能以小数点开始
        var objLength = obj.value.length;
        var strIndexOf = obj.value.indexOf('.');
        var strLastIndexOf = obj.value.lastIndexOf('.');
        
        if (strLastIndexOf + 1 == objLength){
            return true;
        }
        
        if (strIndexOf != strLastIndexOf || strIndexOf == 0){
            alert("不正确的金额!");
            obj.value = parseFloat(0.00).toFixed(2);
            amount();
            return;
        }
       
        //判断是否只有数字或数字和1个小数点组成       
        var str = '-0123456789.';
        var count = 0;
        for(var i = 0; i < obj.value.length; i++){
            for(var j = 0; j < str.length; j++){
                if (obj.value.charAt(i) == str.charAt(j)){                    
                    count = 1;
                    break;
                }
            }
            if (count == 0){
                alert("不正确的金额!");
                obj.value = parseFloat(0.00).toFixed(2);
                return;
            }
            count = 0;
        }        
        
        //金额只能保留两位小数     
        if (strLastIndexOf >= 0 && objLength-strLastIndexOf > 3){
            alert("金额只能保留两位小数!");            
        }
        obj.value = parseFloat(obj.value).toFixed(2);        
        amount();
	}
    
    /**
	 *  删除表格中选中的行
	 */	       
	 function del(){
	    var chk = document.getElementsByName("chk");
		var table = document.getElementById('addTable');
		for(var i = 0; i < chk.length; i++){
			if (chk[i].checked) {
				var curRow = chk[i].parentNode.parentNode;		
				table.deleteRow(curRow.rowIndex);
				i = -1;
			}
		}				
		document.all.chks.checked = false;
		amount();
	 }
	        
	/**
	 *  自动计算相关数据
	 */	       
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
	 *  checkbox全选
	 */	
	function chkAll(){  
        var chks=document.all.chks;
        $('input[id=chk]').each(function(){ 
            $(this).attr("checked",chks.checked);
        }); 
    }

    $(document).ready(function(){    		 
         amount();
	});

    $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    });

    function vailAmount(){
        var dcb = document.getElementsByName('invoiceEntryPo.lieienottaxrateamount');
        var dse = document.getElementsByName('invoiceEntryPo.lieietaxamount');
        var djs = document.getElementsByName('invoiceEntryPo.lieiecostpriceamount');

        for (var i = 0 ; i < dcb.length ; i++){
            if (Number(accAdd(Number(dcb[i].value),Number(dse[i].value))) != Number(djs[i].value)){
                return true;
            }
        }

        return false;
    } 
     
</script>
	</head>
	<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
	<form action="" method="post" id="insertPayMentFrm" name="insertPayMentFrm">
	<input type="hidden" id="indexs" name="indexs">
	<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
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
							   			<input type="hidden" id="supplierID" name="supplierID" value="${supplierID }" ${not empty(supplierID_open) ? 'disabled="disabled"' : '' } validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请先选取制造商!'}]" />
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
					           <SELECT id="invoiceType" name="invoiceType" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请先选取发票类型!'}]">
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
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn2" src="${ctx }/img/newbtn/btn_xzdj_0.png" title="添加单据" onClick="addRow();" >	
                            </li>
                            <li class="horizontal_onlyRight">
                             <img btn=btn id="delBtn" src="${ctx }/img/newbtn/btn_delete_0.png" title="删除" onClick="del()">
                            </li>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>                   
                    <table width="100%" border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                        <TBODY>
                          <TR>
                            <TD width="5%"><div align="left"><img src="${ctx}/img/pic/danjuti.gif" width="86" height="20"></div></TD>
                            <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                          </TR>
                        </TBODY>
                      </TABLE>

              		<table id="addTable" width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                        <TR class=table_title align='middle'>
                          <TH scope=col width="5%" height="26"><input type="checkbox" id="chks" onclick="chkAll()">选择</TH>
                          <TH scope=col width="12%" >来票号</TH>
                          <TH scope=col width="12%" >成本合计</TH>
                          <TH scope=col width="12%" >税额合计</TH>
                          <TH scope=col width="12%" >价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26" colspan="2" align="right">合计：</TD> 
                          <TD><div align="center" id="td1t"></div></TD>
                          <TD><div align="center" id="td2t"></div></TD>
                          <TD><div align="center" id="td3t"></div></TD>
                        </TR>

                      </TBODY>
                    </TABLE>
              
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                       <TR>                         
                          <TD align="left">
                          <li class="horizontal_onlyRight"><img btn=btn id="submitBtn" name="submitBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()"></li>
                          <li class="horizontal_onlyRight">
                          <c:if test="${permissionPo.keyf=='1'}"><input type="checkbox" id="auditState" name="auditState" value="1">保存并审核</c:if> </li>
                          </TD>
					   </TR>
                      </TBODY>
                    </TABLE>
                  </DIV>
               </div>
                </TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>