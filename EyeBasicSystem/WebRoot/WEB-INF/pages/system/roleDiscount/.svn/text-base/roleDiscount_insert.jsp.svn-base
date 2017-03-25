<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员卡管理</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		document.getElementById('frddiscount').focus();  
	});

	function save(){
	if(checkForm(document.all.roleDiscountForm)){ 
	    var frddiscount= parseFloat(document.all.frddiscount.value);
	    
	    if(frddiscount>1||frddiscount<0){
	      alert('折扣必须在0-1之间');
	      document.all.frddiscount.focus();
	      return false;
	    } 
	    $("img").removeAttr("onclick");
		roleDiscountForm.action = "insertRoleDiscount.action";
		roleDiscountForm.submit();
		}
	}
	$(document).ready(function(){
		$('#frddiscount').bind("keyup",function(){	
			$('#frddiscount').val(
				$('#frddiscount').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
		
		
	});

	function clean(){
	   document.getElementById('frddiscount').value = "";
	}

</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="roleDiscountForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="type" id="type" value="" /> 

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
						   <TD width="8%" height="26" class="table_body">角色</TD>
			               <TD width="24%" class="table_none">${roleDiscountPo.frdroleName}<input type="hidden"  id="frdroleid" name="roleDiscountPo.frdroleid" value="${roleDiscountPo.frdroleid}"></TD>                    
                        
                          <TD width="8%" height="26" class="table_body">折扣</TD>
                          <TD width="60%" class="table_none">
                            <input class="text_input100" type="text" maxlength="10" id="frddiscount" name="roleDiscountPo.frddiscount" value="${roleDiscountPo.frddiscount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '折扣不能为空！'},{'Type' : Type.String, 'Formula' : Formula.UDiscount, 'Message' : '请重新输入折扣！'}]">
                            <font color="red">&nbsp;折扣在0-1之间</font>
                            <input type="checkbox" value="changeDiscount" name="changeDiscount" checked="checked" />更新人员打折权限
                            <font color="red">&nbsp;（勾选，更新该角色下所有人员的打折权限，未勾选，则只更新该角色打折权限。）</font>
                          </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                    	<c:if test="${empty(roleDiscountDetailsPos)}">
                    	<br/>
                    	<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                        <TBODY>
                        <s:iterator value="selectGoodsLevelList">
                        <TR>
                           <td class="table_body" width="8%">
					       		商品级别
					       </td>
					       <td class="table_none" width="24%">
					       		<input type="hidden" name="roleDiscountDetailsPo.frddgoodslevels" value="${bgluuid}">
					       		${bglname}
					       </td>
					       <td class="table_body" width="8%">
					       		折扣
					       </td>
					       <td class="table_none">
					       		<input type="text" class="text_input100" name="roleDiscountDetailsPo.frdddiscounts" value="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '折扣不能为空！'},{'Type' : Type.String, 'Formula' : Formula.UDiscount, 'Message' : '请重新填写折扣！'}]">&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
					       </td>
                        </TR>
                        </s:iterator>
                        </TBODY>
                        </table>
                        </c:if>
                        <c:if test="${not empty(roleDiscountDetailsPos)}">
                        <br/>
                        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                        <TBODY>
                        <s:iterator value="roleDiscountDetailsPos">
                        <TR>
                           <td class="table_body" width="8%">
					       		商品级别
					       </td>
					       <td class="table_none" width="24%">
					       		<input type="hidden" name="roleDiscountDetailsPo.frddgoodslevels" value="${frddgoodslevel}">
					       		${frddgoodslevelname}
					       </td>
					       <td class="table_body" width="8%">
					       		折扣
					       </td>
					       <td class="table_none">
					       		<input type="text" class="text_input100" name="roleDiscountDetailsPo.frdddiscounts" value="${frdddiscount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '折扣不能为空！'},{'Type' : Type.String, 'Formula' : Formula.UDiscount, 'Message' : '请重新填写折扣！'}]">&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
					       </td>
                        </TR>
                        </s:iterator>
                        </TBODY>
                        </TABLE>
                    	</c:if>
                    </c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  id="button1" title='保存' onClick="save()">
                        	  <!-- <input icon='icon-reload' type='reset' value='清空' > -->
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
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
	
	
	




