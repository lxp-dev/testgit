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
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	cardBillingForm.action=link;
	  	cardBillingForm.submit();
	}
function add(){
	var json='';
	$('input[name=checkbox2]:checked').each(function(){
		json=json+$(this).val()+',';
		
	});
	json='['+json.substring(0,json.length-1)+']';
	window.parent.addSpecial(json);
}

function checkAll(){
	$('input[name=checkbox2]').each(function(){
		$(this).attr("checked",$('#checkAll').attr("checked"));
	});
}


$(document).ready(function(){
	$('#checkAll').click(function(){
		checkAll();
	});
});
</script>
<BODY bgColor=#ffffff topMargin=5 ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="cardBillingForm" method="post">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
		<!-- ͷ˵ Start -->
		  <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TBODY>
			  <TR>
				<TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>特殊检查费用</TD>
				<TD class=menubar_readme_text vAlign=bottom><div align="right">
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="显隐查询条件" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                      </TR>
                    </TBODY>
                  </TABLE>
			    </div></TD>
			  </TR>
			  <TR>
				<TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：特殊检查费用</TD>
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
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top>
						<fieldset>
							<legend>特殊检查费用</legend>
						    <table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                <td><TABLE width="99%" 
                   border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
                                    <TBODY>
                                      <TR>
                                        <TD height="30" width="30%" class="table_body"><div align="center">选择
                                          <input type="checkbox" name="checkbox" id="checkAll" value="checkbox">
                                        </div></TD>
                                        <TD width="35%" class="table_body"><div align="center">特殊检查名称</div></TD>
                                        <TD width="35%" class="table_body"><div align="center">金额</div></TD>
                                      </TR>
                                      <s:iterator value="rCList">
                                      <TR>
                                        <TD height="28" class="table_none"><div align="center">
                                          <input type="checkbox" name="checkbox2" value="{'name':'${frcregisteredname}','money':'${ frcmoney}','id':'${frcid }'}">
                                        </div></TD>
                                        <TD class="table_none"><div align="center">
                                          ${frcregisteredname }
                                        </div></TD>
                                        <TD class="table_none"><div align="center">
                                       ${ frcmoney}</div></TD>
                                      </TR>
                                     </s:iterator>
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
                              <input icon='icon-add' type='button' value="添加" onClick="javascript:add();parent.hidePopWin();">
                              </div></TD></TR>
                      </TBODY>
                    </TABLE>	
                     <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->	
                  <!--ݿEnd--></TD>
                </TR></TBODY></TABLE></TD></TR>
        </TBODY></TABLE><!--ѡ End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form></BODY></HTML>
