<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工打折券维护</title>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#fdkdiscountcode').focus();
	});

	function save(){
		if(checkForm(additionalCostsForm)){	
			var fdkkeyvalues= parseFloat(document.all.fdkkeyvalues.value);
		    if(fdkkeyvalues>1||fdkkeyvalues<0){
		      alert('折扣必须在0-1之间');
		      document.all.fdkkeyvalues.focus();
		      return false;
		    }
		    
			$("img").removeAttr("onclick");
			additionalCostsForm.action = "insertDiscountShortcutKeys.action";
			additionalCostsForm.submit();
		}
	}
	$(document).ready(function(){
		$('#fdkkeyvalues').bind("keyup",function(){	
			$('#fdkkeyvalues').val(
				$('#fdkkeyvalues').val().replace(/[^0-9.][0-9]*/g,'')
			);
		});
	});
	
	
	function clean(){
		document.getElementById('fdkdiscountcode').value = "";
		document.getElementById('fdkkeyname').value = "";
		document.getElementById('fdkkeyvalues').value = "";
	}
	
	
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="additionalCostsForm">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
                          <TD width="8%" height="26" class="table_body">打折券</TD>
                          <TD width="23%" class="table_none"><input class="text_input160" name="discountShortcutKeysPo.fdkdiscountcode" id="fdkdiscountcode" value="${discountShortcutKeysPo.fdkdiscountcode}" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '打折码不能为空！'},{'Type' : Type.String, 'Formula' : Formula.NO_CN, 'Message' : '打折码不包含中文！'}]"><label style="color:red;">&nbsp;*</label></TD>
						  <TD width="8%" height="26" class="table_body">打折券名称</TD>
                          <TD width="23%" class="table_none"><input class="text_input160" name="discountShortcutKeysPo.fdkkeyname" id="fdkkeyname" value="${discountShortcutKeysPo.fdkkeyname}" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '快捷键名称不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
						  <TD width="8%" height="26" class="table_body">折扣率</TD>
                          <TD class="table_none"><input class="text_input100" maxlength="4" name="discountShortcutKeysPo.fdkkeyvalues" id="fdkkeyvalues" value="${discountShortcutKeysPo.fdkkeyvalues }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '快捷键折扣不能为空！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请重新填写快捷键折扣！'}]"><label style="color:red;">&nbsp;*折扣在0-1之间</label></TD>
			            </TR>
			            <TR>
                          <TD width="8%" height="26" class="table_body">是否启用</TD>                          
                          <TD width="23%" class="table_none">
                          	<select name="discountShortcutKeysPo.fdkenable" id="fdkenable" class="text_input160">
					  		<option value="1">是</option>
					  		<option value="0">否</option>
                          	</select>
                          </TD>
						  <TD width="8%" height="26" class="table_body">&nbsp;</TD>
                          <TD width="23%" class="table_none">
                          	<input type="hidden" name="discountShortcutKeysPo.fdkisshow" id="fdkisshow" value="1" class="text_input160">
                          </TD>
                          <TD height="26" class="table_body">&nbsp;</TD>
                          <TD class="table_none">
                          	&nbsp;
                          </TD>
			            </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                    <br/>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <s:iterator value="selectGoodsLevelList">
                      	<tr>
                    	  <TD height="26" class="table_body" width="8%">商品级别</TD>
			              <td align="left" class="table_none" width="23%">
				               	<input type="hidden" value="${bgluuid}" name="discountShortcutKeysDetailsPo.fdkdgoodslevels">${bglname}
                          </td>
                          <TD height="26" class="table_body" width="8%">折扣率</TD>
			              <td align="left" class="table_none">
				               	<input type="text" class="text_input100" value="" name="discountShortcutKeysDetailsPo.fdkddiscounts" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣！'},{'Type' : Type.String, 'Formula' : Formula.UFloat, 'Message' : '请正确填写折扣！'}]">
                          </td>
                        </tr>
                      </s:iterator>
                      </TBODY>
                    </table>
                    </c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
							<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn id="button4" title='清空' onClick="clean()">
                          </TD>
                        </TR>
                      </TBODY>
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
    </BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>