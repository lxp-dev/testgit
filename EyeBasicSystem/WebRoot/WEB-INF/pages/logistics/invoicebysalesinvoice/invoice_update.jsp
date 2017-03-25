<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>发票管理</title>
<script type="text/javascript">

	/**
     *  修改其他付款单
     */        
	function save(voucherID){
		if (checkForm(updatePayMentBillFrm)){
			
			if($('.row').size()==0){
				alert('请选择填写来票金额!');
				return;
			}
			if (vailAmount()){
				alert('金额填写有误,请重新填写!');
				return;
			}
			
			var auditState = document.getElementsByName("auditState");
		    if (auditState != null  && auditState.length != 0 ){
			    if (!auditState[0].checked){
		            updatePayMentBillFrm.action = "invoiceBySalesInvoiceUpdate.action?auditState=0";
		        }else{
		            updatePayMentBillFrm.action = "invoiceBySalesInvoiceUpdate.action?auditState=1";
		        }
		    }else{
		        updatePayMentBillFrm.action = "invoiceBySalesInvoiceUpdate.action?auditState=0";
		    }
		    $("img").removeAttr("onclick");  
	        updatePayMentBillFrm.submit();
	        auditState.disabled="disabled";
		}

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
     
     $(document).ready(function(){    		 
         amount();
	});
	
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
<form action="" method="post" id="updatePayMentBillFrm" name="updatePayMentBillFrm">

<input type="hidden" id="indexs" name="indexs">	
<input type="hidden" name="invoiceID" value="${invoicePo.liiid }"/>
<input type="hidden" name="billID" id="billID" value=""/>
<input type="hidden" name="supplierID" value="${invoicePo.liisupplierid}"/>
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
                        <TR height="26" >
                          <TD width="9%" class="table_body">发票号</TD>
                          <TD width="24%" class="table_none">${invoicePo.liiid }</TD>
                          <TD width="9%" class="table_body">制单日期</TD>
                          <TD width="24%" class="table_none">
                           ${fn:substring(invoicePo.liidate,0,10)}<input type="hidden" name="liidate" value="${invoicePo.liidate}" />
                          </TD>
                         <TD class="table_body" width="9%">制造商</TD>
			             <TD class="table_none" width="30%">
						   	<li class="horizontal_onlyRight">
							   ${invoicePo.liisuppliername}
							</li>
						 </TD>

                          </TR>
                        <TR height="26px">
                        <TD class="table_body" >制单部门</TD>
                          <TD class="table_none" >${invoicePo.liidepartmentname }</TD>
                          <TD class="table_body" >制单人</TD>
                          <TD class="table_none" >${invoicePo.liicreatepersonname}<input type="hidden" id="liicreatepersonid" name="liicreatepersonid" value="${invoicePo.liicreatepersonid}" /></TD>
                          <TD class="table_body">审核人</TD>
                          <TD class="table_none">${invoicePo.liiauditpersonName}</TD>
                          </TR>
                        <TR height="26px">
                          <TD class="table_body">审核日期</TD>
                          <TD class="table_none">${fn:substring(invoicePo.liiauditdate,0,10)}</TD>
                          <TD class="table_body">发票类型</TD>
                          <TD class="table_none" colspan="3">${invoicePo.liitypeName}<input type="hidden" name="liitypeID" value="${invoicePo.liitypeID}" /></TD>
                          </TR>
                        <TR height="62px">
                        	<TD class="table_body">备注</TD>
                            <TD class="table_none" colSpan=8>
                            <label>
                              <textarea name="remark" id="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [2001]}, 'Message' : '备注不能大于2000字！'}]">${invoicePo.liiremark }</textarea>
                            </label>
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
                        <TR class=table_title align=middle height="26">
                          <TH scope=col width="9%" >来票号</TH> 
						  <TH scope=col width="8%">成本合计</TH>
                          <TH scope=col width="8%">税额合计</TH>
						  <TH scope=col width="8%">价税合计</TH>
                        </TR>
                        <TR class="table_title" align=middle height="26">
						  <TD align="right">合计：</TD>   
                          <TD><div align="center" id="td1t"></div></TD>
                          <TD><div align="center" id="td2t"></div></TD>
                          <TD><div align="center" id="td3t"></div></TD>
                        </TR>
                        <s:iterator value="invoiceEntryList" status="index">
	                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')" height="26">	
							  <TD height="26"><input class="text_input120" type="text" name="invoiceEntryPo.lieiebillid" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写来票号!'}]" value="${lieiebillid }"/></TD>
	                          <TD id="td1"><input class="text_input60" type="text" name="invoiceEntryPo.lieienottaxrateamount" value="${lieienottaxrateamount }" onblur="toFixAndNan(this,'${index.index }')" maxlength="18"/></TD>
							  <TD id="td2"><input class="text_input60" type="text" name="invoiceEntryPo.lieietaxamount" value="${lieietaxamount }" onblur="toFixAndNan(this,'${index.index }')" maxlength="18"/></TD>
	                          <TD id="td3"><input class="text_input60" type="text" name="invoiceEntryPo.lieiecostpriceamount" value="${lieiecostpriceamount}" onblur="toFixAndNan(this,'${index.index }')" maxlength="18"/></TD>
	                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                       <TR>
                          <TD align="left">
                          <li class="horizontal_onlyRight"><img btn=btn id="submitBtn" name="submitBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()"></li>
                          <li class="horizontal_onlyRight">
                          <c:if test="${permissionPo.keyg=='1'}"><input type="checkbox" id="auditState" name="auditState" value="1">保存并审核</c:if> </li>
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>