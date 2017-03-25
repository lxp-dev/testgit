<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银台管理</title>
</head>
<script>
	function insert(){
		showPopWin("","initCreditCardAccountFeesInsert.action",screen.width-150,screen.height-150, '',null,true);
		selectHidden();
	}	
	/**
	 *回车事件
	 */
	function selectCustomer(){
		if(document.getElementById('sseccardid').value.trim() != ''){
			if(event.keyCode == 13)
				document.forms[0].submit();
	    }
		$("img").removeAttr("onclick");
		creditCardAccountFeesForm.action = "selCreditCardAccountFees.action";
    }
    
	/*充值金额*/
	function dianji1(){
	
	    var number1=document.getElementById('ssecrecharge').value="50.00";
	
	}
	function dianji2(){
	
	    var number1=document.getElementById('ssecrecharge').value="100.00";
	 
	}
	function dianji3(){
	
	    var number1=document.getElementById('ssecrecharge').value="200.00";
	}
	
	/*充值功能*/
	function recharge(){
		if(checkForm(document.all.creditCardAccountFeesForm)){
		//if(document.getElementById('ssecrecharge').value==''){
		//	alert('请选择充值金额！');
		//	return;
		//}

			if(confirm("您确认是否充值！！"))
			{
				   $("img").removeAttr("onclick");
				   creditCardAccountFeesForm.action = "updateCardAndProcurementReceiptInsert.action";
			       creditCardAccountFeesForm.submit();
			}
		}
	}
	
		
var validate={
	num : function(obj){	
		var	valueO = obj.value;
		obj.value = obj.value.replace(/^[^1-9][0-9]*/g,'');
	},
	dotNum : function(obj){
		obj.value = obj.value.replace(/[^0-9.][0-9]*/g,'');
	}, 
	bcc : function(obj){
		obj.value = obj.value.replace(/[^-0-9.][0-9]*/g,'');
	},
	level : function(obj){
		if(/^[\+\-]/.test(obj.value)){
			obj.value = obj.value.substring(0,1) + obj.value.replace(/[^0-9]/g,'');
		}else{
			obj.value = obj.value.replace(/[^0-9]/g,'');
		}
		//obj.value = obj.value.replace(/^[^\+-]|[^\d]*$/,'');
	}
};

	$(this).ready(function(){
		$('#aca').bind('keyup',function(){
			validate.dotNum($('#aca').get(0))
		});
		
		$('#smeciavailableamount').bind('blur',function(){
			if($('#aca').val() != ''){
				$('#aca').val(parseFloat($('#aca').val()).toFixed(2));
				this.style.backgroundColor="";
			}
		});
		
		
		$('input[id=ssecrecharge]').each(function(){
			($(this).get(0)).maxLength='7';
			$(this).bind('keyup',function(){
				validate.dotNum($(this).get(0));
			});
			
		});
		
		$('input[id=ssecrecharge]').each(function(){
			$(this).bind('blur',function(){
			if($(this).val()!=''){
					$(this).val(parseFloat($(this).val()).toFixed(2));
					}
			});
		});
		
		
		$('input[id=validateLevel]').each(function(){
			($(this).get(0)).maxLength='7';
			$(this).bind('keyup',function(){
				validate.dotNum($(this).get(0));
			});
		});
		
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
	});
	
	
	
	
	
    /**
	 *聚焦
	 */
	window.onload=function(){
		document.getElementById('sseccardid').focus();  
	}
	function permissionMessage(){
       alert('您无此操作权限');
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="creditCardAccountFeesForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>银台管理</TD>
            <TD class=menubar_readme_text vAlign=bottom>&nbsp;</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：检查充值卡充值</TD>
            <TD class=menubar_function_text align=right>&nbsp;</TD>
          </TR>
          <TR>
            <TD colSpan=2 height=5></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--ťStart-->  <c:if test="${permissionPo.keya=='1'}">
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                  
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initCardAndRechargeRecordNew.action?moduleID=${ requestScope.moduleID}&customerID=${customerInfoPo.smecicustomerid }';" 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">新建检查充值卡</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                  </c:if>
                    <c:if test="${permissionPo.keyb=='1'}">
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      onclick="JavaScript:void(0);"
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">检查充值卡充值</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD></c:if>
                      <c:if test="${permissionPo.keyc=='1'}">
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='selCreditCardAccountFeesClear.action?moduleID=${ requestScope.moduleID}&customerID=${customerInfoPo.smecicustomerid }';" 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">检查充值卡清零</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    </c:if>
                      <c:if test="${permissionPo.keyd=='1'}">
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initCreditCardAccountFeesRechargeUpCaed.action?moduleID=${ requestScope.moduleID}&customerID=${customerInfoPo.smecicustomerid }';" 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">检查充值卡补卡</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    </c:if>
					</TR></TBODY></TABLE></TD>
			</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                    <TABLE width="100%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="Privateborder">
                      <TBODY>
                        <TR>
                          <TD width="12%" class="table_body " align="right">检查充值卡号</TD>
                          <TD width="22%" class="table_none ">
								<li class="horizontal_onlyRight">
						   		<font size="1"><input type="text" id="sseccardid" name="cardPo.sseccardid" class="text_input100" value="${cardPo.sseccardid }" onkeyup="selectCustomer();" :=""
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入检查充值卡号！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '检查充值卡号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [12]}, 'Message' : '检查充值卡号不能超过11位！'}]"></font>
					            <input type="hidden" id="sseccustomerid" name="sseccustomerid" class="text_input100" value="${cardPo.sseccustomerid }">
						   		</li>
						   <li class="horizontal_onlyRight">
                            </TD>
						</TR>
                        <TR>
                          <TD width="12%" height="30"  class="table_body " align="right">顾客姓名</TD>
                          <TD width="22%" class="table_none ">${cardPo.ssecname }&nbsp;
                          </TD>
                        </TR>
                        <TR>
                          <TD width="12%" height="30" class="table_body " align="right">卡内金额</TD>
                          <TD width="22%" class="table_none ">${cardPo.ssecamount }&nbsp;
                             <input type="hidden" id="ssecamount" name="ssecamount"  value="${cardPo.ssecamount }">
                          </TD>
                        </TR>
                        <TR>
                          <TD width="12%" height="30" class="table_body " align="right">可用金额</TD>
                          <TD width="22%" class="table_none ">${cardPo.ssecavailableamount }&nbsp;
                          <input type="hidden" id="ssecavailableamount" name="ssecavailableamount"  value="${cardPo.ssecavailableamount }">
                          </TD>
                        </TR>
	                        <TR>
                          <TD width="12%" height="30" class="table_body " align="right"><font color="red">充值金额</font></TD>
                          <TD width="22%" class="table_none ">
                           <li class="horizontal_onlyRight">
						   		<input  id="ssecrecharge" name="ssecrecharge" class="text_input100"  
						   		validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入充值金额！'}]">
						   </li>
						   <li class="horizontal_onlyRight">
	                            <input icon='icon-save' type='button' id="btn1"  value="50.00"   onClick="dianji1()" />
	                            <input icon='icon-save' type='button' id="btn2"  value="100.00"  onClick="dianji2();" />
	                            <input icon='icon-save' type='button' id="btn3"  value="200.00"  onClick="dianji3();" />
						   </li>
                          
                            </TD>
		                </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">
                              <input icon='icon-save' type='button' value="充值"  onClick="recharge()"/>
                              &nbsp;&nbsp;</div></TD></TR>
                      </TBODY>
                    </TABLE>
                    </DIV>
                </DIV>
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></HTML>
