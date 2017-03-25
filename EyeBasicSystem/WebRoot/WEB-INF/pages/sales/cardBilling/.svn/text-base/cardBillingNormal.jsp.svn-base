<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
	<TITLE>FrameWork</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</HEAD>
<script type="text/javascript">
$(document).ready(function(){
	
});

function cost(){
	if('${cardPo.sseccardid }'==''){
		alert('请输入检查充值卡号!');
		return;
	}
	if($('#arrears tr[id=checkRow]').size()==0){
		alert('请选择检查项目!');
		return;
	}
	var mobanLength=accAdd('${fn:length(opList)}','${fn:length(rcdList)}');
	if(accAdd($('#amountTotal').text(),'-'+'${cardPo.ssecavailableamount}')>0||'${cardPo.ssecavailableamount}'==''){
			alert('顾客卡内余额不足!');
			return;
		}
	else
	{
		if(confirm('本次计费'+$('#amountTotal').text()+'元,您确定要刷卡吗?')){
			$('#ssecavailableamount').val(accAdd('${cardPo.ssecavailableamount}','-'+$('#amountTotal').text()));
			$('#ssecamount').val(accAdd('${cardPo.ssecamount}','-'+$('#amountTotal').text()));
			cardBillingForm.action="cardBillingNormal.action?mobanLength="+mobanLength;
			cardBillingForm.submit();
		}
	}
}
function cal(){
	var amountTotal=0;
	$('#arrears span[id=amount]').each(function(){
		amountTotal=accAdd(amountTotal,$(this).text());
	});
	$('#amountTotal').text(amountTotal.toFixed(2));
}
function check(item){
	if('${cardPo.sseccardid }'==''){
		alert('请先输入检查充值卡号');
		return;
	}
	$(item).parent().parent().parent().clone().appendTo($("#copyrow"));
	$('#arrears tr[id=checkRow]').each(function(){
		$(this).find('button').each(function(){
			$(this).parent().html('<button class="z-btn-text icon-delete" onclick=del(this)>删除</button>');
		});
	});
	
	cal();
}
function del(item){
	$(item).parent().parent().parent().parent().parent().parent().parent().parent().remove();
	cal();
}

function selCard(){
	if(event.keyCode == 13){
		$("img").removeAttr("onclick");
		cardBillingForm.action="selCard.action";
		cardBillingForm.submit();
	}
}

</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="cardBillingForm" method="post">
<input type="hidden" name="cardPo.ssecavailableamount" id="ssecavailableamount"/>

<input type="hidden" name="customerInfoPo.smecicustomerid" value="${customerInfoPo.smecicustomerid}"/>
<input type="hidden" name="cardPo.sseccustomerid" value="${cardPo.sseccustomerid}"/>
<input type="hidden" name="cardPo.ssecamount" id="ssecamount"/>
<input style="display: none" name="" type="text"/>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
		<!-- ͷ˵ Start -->
		  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TBODY>
			  <TR>
				<TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光检查</TD>
          <TD class=menubar_readme_text vAlign=bottom><div align="right">
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
                <TR>
                  <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                </TR>
              </TBODY>
            </TABLE>
          </div></TD>
			  </TR>
			  <TR>
				<TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：刷卡计费</TD>
				<TD class=menubar_function_text align=right>&nbsp;</TD>
			  </TR>
			  <TR>
				<TD colSpan=2 height=5></TD>
			  </TR>
			</TBODY>
		  </TABLE>
		<!-- ͷ˵ End -->
		<!-- ѡ Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
			<TR>
						  <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
						  background=${ctx}/img/pic/tab_top_bg.gif>
							<TABLE cellSpacing=0 cellPadding=0 border=0>
							  <TBODY>
							  <TR><!--ťStart-->
											<TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>

												  <TD width=3><IMG id=tabImgRight__1 height=22 
													src="${ctx}/img/pic/tab_unactive_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
										  <TD>
											  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
												<TBODY>
												<TR>

												  <TD class=tab id=tabLabel__0 
												  onclick="JavaScript:void(0);"
												  background=${ctx}/img/pic/tab_active_bg.gif 
												  UNSELECTABLE="on">费用提交</TD>
												  <TD width=3><IMG id=tabImgRight__0 height=22 
													src="${ctx}/img/pic/tab_active_right.gif" 
												width=3></TD>
												</TR>
												</TBODY>
											  </TABLE>
										  </TD>
									</TR>
								</TBODY>
							</TABLE>
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
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>	
						
						<fieldset>
							<legend>检查费用</legend>
						    <table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td><TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TBODY>
                                      <TR >
                                        <TD height="30" width="34%" class="table_body"><div align="center">检查项目名称</div></TD>
                                        <TD width="34%" class="table_body"><div align="center">价格</div></TD>
                                        <TD width="32%" class="table_body"><div align="center">选择</div></TD>
                                      </TR>
                                      <s:iterator value="opList">
                                      <TR id="checkRow">
                                        <TD height="28" class="table_none"><div align="center">
                                        ${ frcregisteredname}<input type="hidden" name="rechargeRecordPo.sserrsourceid" value="${ frcid}"/><input type="hidden" name="registeredDetailsPo.scrrdid" value="${frcid}"/><input type="hidden" name="isOpto" value="1"/><input type="hidden" name="rechargeRecordPo.sserramount" value="${ frcmoney }" id="sserramount"/></div></TD>
                                        <TD class="table_none"><div align="center">
                                         <span id="amount">   ${ frcmoney}</span></div></TD>
                                          <TD class="table_none"><div align="center">
                                          <input class="checkbutton" name="checkbutton" type='button' icon="icon-cmp" onclick="check(this)" value='选择' align="left">
                                        </div></TD>
                                      </TR></s:iterator>
                                      <s:iterator value="rcdList">
                                      <TR id="checkRow">
                                        <TD height="28" class="table_none"><div align="center">
                                        ${ scrrdregistername}<input type="hidden" name="rechargeRecordPo.sserrsourceid" value="${ scrrdregisterid}"/><input type="hidden" name="registeredDetailsPo.scrrdid" value="${scrrdid}"/><input type="hidden" name="isOpto" value="0"/><input type="hidden" name="rechargeRecordPo.sserramount" value="${scrrdmoney }" id="sserramount"/></div></TD>
                                        <TD class="table_none"><div align="center">
                                         <span id="amount"> ${ scrrdmoney}</span> </div></TD>
                                          <TD class="table_none"><div align="center">
                                          <input class="checkbutton" name="checkbutton" type='button' icon="icon-cmp" onclick="check(this)" value='选择' align="left">
                                        </div></TD>
                                      </TR>
                                      </s:iterator>
                                    </TBODY>
                                </TABLE></td>
                              </tr>
                            </table>
					      </fieldset>	<br>
	
					      
					      <fieldset>
							<legend>待收取检查费用</legend>
						    <table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td><TABLE width="99%" 
                   border=0 align=center id="arrears" cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TBODY>
                                      <TR id="copyrow">
                                        <TD height="30" width="34%" class="table_body"><div align="center">检查项目名称</div></TD>
                                        <TD width="34%" class="table_body"><div align="center">价格</div></TD>
                                        <TD width="32%" class="table_body"><div align="center">删除</div></TD>
                                      </TR>
                                   
                                    </TBODY>
                                </TABLE></td>
                              </tr>
                            </table>
					      </fieldset>	<br>
					      
					      <fieldset>
							<legend>顾客资料</legend>
                              <table width="100%" 
                  border=0 align=center cellpadding=3 cellspacing=1 class="privateTable Privateborder">
                              <tbody>
                                <tr>
                                  <td width="12%" height="30" class="table_body " align="right">检查充值卡号</td>
                                  <td width="22%" class="table_none ">
                                    <input name="cardPo.sseccardid" class="text_input150" onkeyup="selCard()" value="${cardPo.sseccardid }"></td>
                                    <input name="cardPo.sseccardid" type="hidden" value="${cardPo.sseccardid }">
								                                  </tr>
                                <tr>
                                  <td class="table_body " align="right">顾客姓名</td>
                                  <td class="table_none ">${cardPo.ssecname }</td>
								                                  </tr>
                                <tr>
                                  <td height="30" class="table_body " align="right">卡内可用金额</td>
                                  <td class="table_none "><font color="#FF0000">${cardPo.ssecavailableamount==null&&cardPo.sseccardid!=null?'0.00':cardPo.ssecavailableamount}</font></td>
								                                  </tr>
                                <tr>
                                  <td class="table_body " align="right">本次计费金额</td>
                                  <td class="table_none "><span id="amountTotal"></span></td>
								                                  </tr>

                              </tbody>
                            </table>
						</fieldset>	
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">&nbsp;&nbsp;
                              <input icon='icon-save' type='button' value="刷卡计费"  onClick="cost()">
                            </div></TD></TR>
                      </TBODY>
                    </TABLE>		
                  <!--ݿEnd--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form></BODY></HTML>