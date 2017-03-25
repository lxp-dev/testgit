<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>其他付款单管理</title>
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

	    	var count = 0;
            if ($('#sLpbpbPayMentDptID').val() != ''){
                count = accAdd(count,1);
            }
            if ($('#supplierID').val() != ''){
            	count = accAdd(count,1);
            }
            if (count > 1){
                alert('不能同时选取部门和制造商!');
                return;
            }
            if (count == 0){
                alert('请先选取部门或制造商!');
                return;
            }
		    
		    var chk = document.getElementsByName("chk").length;	     
	        if (chk != 0){ 
	        	var obj = document.getElementsByName("payMentBillEntryTempPo.sLpbpbeInvoiceID");
		        for (var i = 0; i < obj.length; i++){
		            if (obj[i].value == '' || obj[i].value == null){
		                alert("请选择科目!");
		                return;
		            }
		        }
			    var auditState = document.getElementsByName("auditState");
			    if (auditState != null  && auditState.length != 0 ){
				    if (!auditState[0].checked){
			            insertPayMentFrm.action = "insertPayMentBillOther.action?auditState=0";
			        }else{
			            insertPayMentFrm.action = "insertPayMentBillOther.action?auditState=1";
			        }
			    }else{
			        insertPayMentFrm.action = "insertPayMentBillOther.action?auditState=0";
			    }
	            $("img").removeAttr("onclick");   
		        insertPayMentFrm.submit();  

		            
	        } else{
	            alert('请先选择数据!');
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
		
		row.className = 'row';
		c1.height="26";
		
		c1.innerHTML = '<input id="chk" name="chk" type="checkbox" >';
		c2.innerHTML = '<li class="horizontal_onlyRight"><input id=InOrOutComeType'+index+' readonly="readonly" class="text_input160" />'
		               +'<input type="hidden" id=InOrOutComeTypeID'+index+' name="payMentBillEntryTempPo.sLpbpbeInvoiceID" /></li>'
		              +'<li class="horizontal_onlyRight"><img btn=btn src="${ctx}/img/newbtn/btn_change_0.png" onClick="openSubject('+index+');" onmouseover="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_1.png\');" onmouseout="JavaScript:$(this).attr(\'src\',\'${ctx }/img/newbtn/btn_change_0.png\');" style="cursor: hand;"/></li>';          		
		       
        c3.innerHTML = '<input style="width:100" id="notpayamount'+index+'" type="text" name="payMentBillEntryTempPo.sLpbpbeCostPriceAmount" value="0.00" onblur="toFixAndNan(this,'+index+')" maxlength="18"/>';
		c4.innerHTML = '<input style="width:350" type="text" name="payMentBillEntryTempPo.sLpbpbeRemark" maxlength="200"/>';	
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
		var total = 0;
		$('input[name=payMentBillEntryTempPo.sLpbpbeCostPriceAmount]').each(function(){
            total=parseFloat(accAdd(total,$(this).val())).toFixed(2);    
		});
		$('#costPriceAmountTotal').text(parseFloat(total).toFixed(2));
		$('#costPriceAmount').val(parseFloat(total).toFixed(2));
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
	
	/**
	 * 支出类型开窗
	 */ 
     function openInOrOutComeType(value){
         document.getElementById("indexs").value = value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initInOrOutComeTypeOpen.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initInOrOutComeTypeOpen.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【支出类型查询】";
     }
     
    /**
	 * 支出类型开窗赋值
	 */ 
     function openInOrOutComeTypeValue(json){         
         var indes= document.getElementById("indexs").value;
         document.getElementById("InOrOutComeType"+indes).value=json.typeName;
         document.getElementById("InOrOutComeTypeID"+indes).value=json.typeID;
     }
     
        
    /**
	 * 科目开窗
	 */ 
     function openSubject(value){
        document.getElementById("indexs").value = value;
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("selSubjectOpenTree.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("selSubjectOpenTree.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}		
		document.getElementById('popupTitle').innerHTML="【会计科目查询】";
     }
     
    /**
	 * 科目开窗赋值
	 */ 
     function openSubjectValue(json){         
         var indes= document.getElementById("indexs").value;
         document.getElementById("InOrOutComeType"+indes).value=json.subject;        
         document.getElementById("InOrOutComeTypeID"+indes).value=json.subjectID;
     }
     
     $(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
    }); 
     
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
                        <TR height="26px">
                          <TD width="9%" class="table_body">其他付款单号</TD>
                          <TD width="24%" class="table_none">
                              ${payMentID}
                              <input type="hidden" id="payMentID" name="payMentBillPo.sLpbpbID" class="text_input160" value="${payMentID}" readonly="readonly">
                          </TD>
                          <TD width="9%" class="table_body">付款日期</TD>
                          <TD width="24%" class="table_none">
                              ${payMentDate}
                              <input type="hidden" id="payMentDate" name="payMentBillPo.sLpbpbDate" class="text_input160" value="${payMentDate}" readonly="readonly" >
                          </TD>
                          <TD width="9%" class="table_body">制造商</TD>
                          <TD width="30%" class="table_none">
                          <li class="horizontal_onlyRight">
                            <input type="text" id="supplierName" name="supplierName" class="text_input160" readonly="readonly" value="${supplierName}">
                            <input type="hidden" id="supplierID" name="payMentBillPo.sLpbpbSupplierID" class="text_input160" value="${supplierID}">
                          </li>
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn" name="searchBtn" src="${ctx }/img/newbtn/btn_change_0.png" title="选 择" onClick="openSupplier();" >	
                            </li></TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none">
                              ${createPerson}
                              <input type="hidden" id="createPerson" name="payMentBillPo.sLpbpbCreatePersonID" class="text_input200" value="${createPersonID}" readonly="readonly">
                          </TD>
                          <TD class="table_body" >部门名称</TD>
                          <TD class="table_none" colspan="5">
						   	   <select id="sLpbpbPayMentDptID" name="payMentBillPo.sLpbpbPayMentDptID">      		                       
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}">${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
      	                       </select>
                          </TD>
                        </TR>
                        <TR height="62px">
                          <TD class="table_body">摘要</TD>
                          <TD class="table_none" colSpan=6><label>
                            <textarea name="payMentBillPo.sLpbpbRemark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${remark}</textarea>
                            </label></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <li class="horizontal_onlyRight">
                              <img btn=btn id="searchBtn2" src="${ctx }/img/newbtn/btn_tjkm_0.png" title="添加科目" onClick="addRow();" >	
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
                          <TH scope=col width="12%" >科目名称</TH>
                          <TH scope=col width="6%">金额(含税)</TH>
                          <TH scope=col width="20%">备注</TH>
                        </TR>
                        <TR class="table_title" align=middle>
						  <TD height="26" colspan="2" align="right">合计：</TD> 
                          <TD><div id="costPriceAmountTotal" name="costPriceAmountTotal"></div><input type="hidden" id="costPriceAmount" name="payMentBillPo.sLpbpbCostPriceAmount"></TD>
                          <TD></TD>
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