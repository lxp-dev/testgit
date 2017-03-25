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
var jsonTemp='';
function addSpecial(json){
	
	var json=eval('('+json+')');
	
	$('#copyrow').show();
	if(jsonTemp==''){
		for(var i=0;i<json.length;i++){
	        	$("#copyrow").clone(true).appendTo($('#copyrow'));
	        	$('input[name=registeredDetailsPo\\.scrrdregistername]')[i+1].value=json[i].name;
	        	$('input[name=registeredDetailsPo\\.scrrdmoney]')[i+1].value=json[i].money;
	        	$('input[name=registeredDetailsPo\\.scrrdregisterid]')[i+1].value=json[i].id;	
		}	
	}else{
		for(var i=$('tr[id=copyrow]').size(),j=0;i<json.length+$('tr[id=copyrow]').size(),j<json.length;i++,j++){
	        	$("#copyrow").clone(true).appendTo($('#copyrow'));
	        	$('input[name=registeredDetailsPo\\.scrrdregistername]')[i].value=json[j].name;
	        	$('input[name=registeredDetailsPo\\.scrrdmoney]')[i].value=json[j].money;
	        	$('input[name=registeredDetailsPo\\.scrrdregisterid]')[i].value=json[j].id;	
		}	
	}	
	$("#copyrow").hide();
	jsonTemp=json;
}

function cardBillingSpecial()
{
	if($('tr[id=copyrow]').size()==1){
		alert('请选择特殊检查费用!');
		return;
	}
	$("img").removeAttr("onclick");
	cardBillingForm.action="cardBillingSpecial.action";
	cardBillingForm.submit();
}
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="cardBillingForm" method="post">
<input name="customerInfoPo.smecicustomerid" value="${customerInfoPo.smecicustomerid }" type="hidden"> 
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
				<TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：费用提交</TD>
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
                                        <TD width="32%" class="table_body"><div align="center">删除</div></TD>
                                      </TR>
                                      <TR id="copyrow" style="display: none">
                                       
                                        <TD height="28" class="table_none"><div align="center">
                                        <input style="background:transparent;border:0px;text-align: center"  name="registeredDetailsPo.scrrdregistername" readonly="readonly"  class="text_inputhidden"></div></TD>
                                        <TD class="table_none"><div align="center">
                                          <input type="hidden"  name="registeredDetailsPo.scrrdregisterid" ><input style="background:transparent;border:0px;text-align: center"  name="registeredDetailsPo.scrrdmoney" readonly="readonly"  class="text_inputhidden"></div></TD>
                                        <TD class="table_none"><div align="center">
                                          <input name="button322" type='button' icon="icon-delete" onclick="$(this).parent().parent().parent().remove()" value='删除' align="left">
                                        </div></TD>
                                      </TR>
                                      
                                    </TBODY>
                                </TABLE></td>
                              </tr>
                            </table>
					      </fieldset>	
						<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD align="left">
                            <div align="left">
                              <input icon='icon-add' type='button' value="添加特殊视功能检查项目"  onclick='showPopWin("","cardBillingSpecialOpen.action",screen.width-200,screen.height-200, "",null,true);'  >
                              &nbsp;&nbsp;
                              <input icon='icon-save' type='button' value="费用提交"  onClick="cardBillingSpecial()">
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
