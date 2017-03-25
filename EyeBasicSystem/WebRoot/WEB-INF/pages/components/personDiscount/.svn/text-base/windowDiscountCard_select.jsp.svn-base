<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	personDiscountForm.action=link;
	  	personDiscountForm.submit();
	}
	function selectDiscount(){
		if(event.keyCode==13){
			var fdkdiscountcode = document.getElementById('fdkdiscountcode').value;
			if(fdkdiscountcode==''){
				alert("请输入员工打折券！");
				document.getElementById('fdkdiscountcode').focus();
				return false;
			}
			
			$("img").removeAttr("onclick");
			personDiscountForm.action = "selectDiscountCard.action";
			personDiscountForm.submit();
		}
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function discount(){
		var discounttype = $("input[name=discounttype]:checked").val();
		var discountperson = $("#fpdpersonid").val();
		var specialdiscount = $("#specialdiscount").val();

		var mindiscount = document.getElementById('mindiscount').value;
		var fpdpersonid = document.getElementById('fpddiscount').value;
		var discountnumber = $('input[name=discountnumber]').val();

		if(fpdpersonid > 0){
		}else{
			alert("折扣格式有误！");
			$("#fpddiscount").select();
			$("#fpddiscount").focus();
			return;
		}
		
	    if(mindiscount == null || mindiscount == ""){
			alert('您的打折权限不够!');
			return false;
		}
		if(discounttype=="2"){
			if(parseFloat(discountnumber)>=1){
			}else{
				alert('您的特殊打折次数不足!');
				document.getElementById('fpddiscount').focus();
				return false;
			}
			
			if(fpdpersonid < specialdiscount && fpdpersonid > 0){
				alert('您的特殊打折权限不够!');
				document.getElementById('fpddiscount').focus();
				return false;
			}
		}else{
			if(fpdpersonid < mindiscount && fpdpersonid >= 0){
				alert('您的普通打折权限不够!');
				document.getElementById('fpddiscount').focus();
				return false;
			}
		}
		
		
		if(fpdpersonid > 1 || fpdpersonid < 0 ){
			alert("请输入正确的折扣数!");
			document.getElementById('fpddiscount').focus();
			return false;
		}

		/*
		parent.$('input[name=salesDetailPo.ssesdsalesitemids]').each(function(){
			<s:iterator value="maxDiscountPos">
			if($(this).val()=='${fmdgoodsid }'){
				$(this).attr("maxdiscount",'${fmdmaxdiscount }');
			}
			</s:iterator>
		});
		*/
		
		if('${arg0}'=='1'){//单品打折
			parent.setDiscount2(fpdpersonid,'${rownumber}',discounttype,discountperson,"3",'${discountShortcutKeysPo.fdkdiscountcode }');
		}else{
			parent.setDiscount1(fpdpersonid,discounttype,discountperson,"3",'${discountShortcutKeysPo.fdkdiscountcode }');
		}
		parent.hidePopWin();
	}
	$(document).ready(function(){
		$("input[name=fdkdiscountcode]").focus();
		if('${discountShortcutKeysPo.fdkdiscountcode }' != ''){
			$("tr[id=trdown]").show();
			$("table[id=trdown]").show();
		}

		var goodsids = "";
		parent.$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function(){
			if($(this).val() != ''){
				goodsids = goodsids + $(this).val()+",";
			}
		});
		$('input[name=goodsids]').val(goodsids.substring(0,goodsids.length-1));
		<c:if test="${not empty(discountShortcutKeysPo.fdkdiscountcode)}">
			discount();
		</c:if>
	});

	function discount1(){
		if(event.keyCode==13){
			discount();
		}
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
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="personDiscountForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="rownumber" value="${requestScope.rownumber}">
<input type="hidden" name="arg0" value="${requestScope.arg0}">
<input type="hidden" name="discountnumber" value="${personInfoPo.fpdspecialdiscountnumber}">
<input type="hidden" name="personid" value="${personInfoPo.id }">

<input type="hidden" name="goodsids" value="${requestScope.goodsids}">
<input type="hidden" name="firstcheckstr" value="${requestScope.firstcheckstr}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx }/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
				  <c:if test="${sysyg == '3'}">
				  <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPersonDiscountSelect.action?rownumber=${requestScope.rownumber}&arg0=${requestScope.arg0}&firstcheckstr=${firstcheckstr }';"
                      UNSELECTABLE="on">员工打折权限</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    </c:if>
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">打折码打折</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    <c:if test="${sysvip == '1'}">
                    <TD>
                    <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initPersonDiscountCardSelect.action?rownumber=${requestScope.rownumber}&arg0=${requestScope.arg0}&firstcheckstr=${firstcheckstr }';"
                      UNSELECTABLE="on">打折卡打折</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
                    </c:if>
                    </TR></TBODY></TABLE></TD>
					</TR></TBODY></TABLE>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>		
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                      <TR>
                      	<TD height="26" class="table_body" align="right" >打折码:</TD>
                      	<TD class="table_none" colspan="3" >
                            <input class="text_input200" type="text" id="fdkdiscountcode" name="fdkdiscountcode" value="${discountShortcutKeysPo.fdkdiscountcode }" onkeydown="selectDiscount()">&nbsp;&nbsp;<font color="red">按回车确认打折码</font>
			               </TD>
                      </TR>
                      <TR style="display: none;">
                      	<TD width="%35" height="30" class="table_body" align="right">最大折扣:</TD>
                      	<TD width="%65" class="table_none" colspan="3">
                            ${discountShortcutKeysPo.fdkkeyvalues}
                            <input type="hidden" id="mindiscount" name="mindiscount" value="${discountShortcutKeysPo.fdkkeyvalues}">
			            </TD>
                      </TR>
                      <TR style="display: none;">
                      	<TD width="%35" height="30" class="table_body" align="right">折扣:</TD>
                      	<TD width="%65" class="table_none" colspan="3" >
                            <input class="text_input100" type="text" id="fpddiscount" maxlength="6" value="${discountShortcutKeysPo.fdkkeyvalues}" name="fpddiscount" >
			            </TD>
                      </TR>
                      </TBODY>
                      <br/>
                    </table>
                    <table width="100%" id="title2" cellspacing="2">
						<tr height="10" id="trdown" style="display: none;">
							<td align="right">
								<img id="submitButton" src="${ctx}/img/newbtn/btn_define_0.png" btn=btn  title='确定' onClick="javascript:discount()">
							</td>
						</tr>
					</table>
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
        <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
