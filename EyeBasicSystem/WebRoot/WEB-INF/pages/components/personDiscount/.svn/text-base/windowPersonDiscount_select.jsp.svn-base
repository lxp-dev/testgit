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
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	 var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	personDiscountForm.action=link;
	  	personDiscountForm.submit();
	}
	
	function selectDiscount(){
		if(event.keyCode==13){
			if($("input[name=idorcard]:checked").val() != "2"){
				var fpdpersonid = document.getElementById('fpdpersonid').value;
				var fpdpersonpassword =	document.getElementById('fpdpersonpassword').value;
				if(fpdpersonid==''){
					alert("请输入员工工号!");
					document.getElementById('fpdpersonid').focus();
					return false;
				}
				if(fpdpersonpassword==''){
					alert("请输入员工密码!");
					document.getElementById('fpdpersonpassword').focus();
					return false;
				}
			}else{
				var cardid = $("input[name=cardid]").val();
				if(cardid==''){
					alert("请输入员工卡!");
					document.getElementById('cardid').focus();
					return false;
				}
			}
			$("img").removeAttr("onclick");
			personDiscountForm.action = "selectPersonDiscount.action";
			personDiscountForm.submit();
		}
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function discount(){
		var discounttype = $("input[name=discounttype]:checked").val();
		var discountperson = $("#fpdpersonid").val();
		var specialdiscount = parseFloat($("#specialdiscount").val());

		var mindiscount = parseFloat(document.getElementById('mindiscount').value);
		var fpdpersonid = parseFloat(document.getElementById('fpddiscount').value);
		var discountnumber = $('input[name=discountnumber]').val();

	    if(!document.getElementById('mindiscount').value){
			alert('您的打折权限不够!');
			return false;
		}

		if(fpdpersonid >= 0){
		}else{
			alert("折扣格式有误！");
			$("#fpddiscount").select();
			$("#fpddiscount").focus();
			return;
		}
		
		if(discounttype=="2"){
			if('${systemParameterPo.fspisusegoodslevel}' == '1'){
				if(checknum > parseFloat(discountnumber)){
					alert('您的特殊打折次数不足!');
					document.getElementById('fpddiscount').focus();
					return false;
				}
				
				if(checkdiscountcount()+goodsnnum >= parseFloat(discountnumber)){
					alert('您的特殊打折次数不足!');
					document.getElementById('fpddiscount').focus();
					return false;
				}
			}
		
			if(parseFloat(discountnumber)>=1){
			}else{
				alert('您的特殊打折次数不足!');
				document.getElementById('fpddiscount').focus();
				return false;
			}
			if(fpdpersonid < specialdiscount && fpdpersonid >= 0){
				alert('您的特殊打折权限不够!');
				document.getElementById('fpddiscount').focus();
				return false;
			}
		}else{
			if(fpdpersonid < mindiscount || fpdpersonid < 0){
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
		
		if('${arg0}'=='1'){//单品打折
			parent.setDiscount2(fpdpersonid,'${rownumber}',discounttype,discountperson,"1",'${personInfoPo.id }','${requestScope.firstcheckstr}');
		}else{
			parent.setDiscount1(fpdpersonid,discounttype,discountperson,"1",'${personInfoPo.id }','','${requestScope.firstcheckstr}');
		}
		parent.hidePopWin();
		
	}
	
	var goodsnnum = 0;
	var checknum = 0;
	$(document).ready(function(){
		if('${idorcard}' != '2'){
			$("input[name=idorcard][value=1]").attr("checked","checked");
			$("tr[id=trid1]").show();
			$("tr[id=trid2]").show();
			$("tr[id=trcard1]").hide();
		}else{
			$("input[name=idorcard][value=2]").attr("checked","checked");
			$("tr[id=trid1]").hide();
			$("tr[id=trid2]").hide();
			$("tr[id=trcard1]").show();
		}
		
		var goodsids = "";
		parent.$('input[name=salesDetailPo\\.ssesdsalesitemids]').each(function(){
			if($(this).val() != ''){
				goodsids = goodsids + $(this).val()+",";
			}
		});
		
		var tgoodsids = "";
		parent.$('input[name=chk]:checked').each(function(){
			if($(this).parent().parent().parent().find("input[name=salesDetailPo.ssesdsalesitemids]").val() != '' && $(this).parent().parent().parent().find("input[name=salesDetailPo.ssesddiscounttypes]").val().trim() == '2'){
				tgoodsids = tgoodsids + $(this).parent().parent().parent().find("input[name=salesDetailPo.ssesdsalesitemids]").val()+",";
			}
		});
		
		goodsnnum = tgoodsids.split(',').length - 1;
		
		var checkgoods = "";
		parent.$('input[name=chk]:checked').each(function(){
			if($(this).parent().parent().parent().find("input[name=salesDetailPo.ssesdsalesitemids]").val() != '' && $(this).parent().parent().parent().find("input[name=salesDetailPo.ssesddiscounttypes]").val().trim() != '2'){
				checkgoods = checkgoods + $(this).parent().parent().parent().find("input[name=salesDetailPo.ssesdsalesitemids]").val()+",";
			}
		});
		
		checknum = checkgoods.split(',').length - 1;
		
		$('input[name=goodsids]').val(goodsids.substring(0,goodsids.length-1));

		if('${personInfoPo.personName}'){
			$('#fpddiscount').focus();
		}else{
			if($('input[name=idorcard]:checked').val() != '2'){
				$("input[name=fpdpersonid]").focus();
			}else{
				if('${idorcard}' == '2'){
					$("input[name=cardid]").focus();
				}
			}
		}
		if('${selectC}'=='1'){
			document.getElementById('fpddiscount').focus();
		}
	});

	function idorcardclick(obj){
		personDiscountForm.action = "initPersonDiscountSelect.action";
		personDiscountForm.submit();
	}
	
	function discount1(){
		if(event.keyCode==13){
			discount();
		}
			
	}
	
	function pointout(){
		alert("特殊折扣只能在相关主管领导授权后使用，其他情况慎用！");
	}
	
	function checkdiscountcount(){
		var count = 0;
		var goodslevel = "";
		
		parent.$('input[name=chk]:checked').each(function(){
			if($(this).parent().parent().parent().find("input[name=salesDetailPo.ssesdgoodslevels]").val() != ''){
				goodslevel = $(this).parent().parent().parent().find("input[name=salesDetailPo.ssesdgoodslevels]").val();
			}
		});
		
		window.parent.$("input[name=salesDetailPo.ssesddiscounttypes]").each(function (){
			if($(this).val().trim() == '2' && $(this).parent().parent().find("input[name=salesDetailPo.ssesdgoodslevels]").val() == goodslevel){
				count = count + 1;
			}
		});
		return count;
	}
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
				<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">员工打折权限</TD>
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    
                    <c:if test="${sysdzm == '2'}">
                    <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__1 
                      background=${ctx }/img/pic/tab_unactive_bg.gif 
                      onclick="JavaScript:window.location.href='initSelectDiscountCard.action?rownumber=${requestScope.rownumber}&arg0=${requestScope.arg0}&firstcheckstr=${firstcheckstr }';"
                      UNSELECTABLE="on">打折码打折</TD>
                      
                      <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx }/img/pic/tab_unactive_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
                    </c:if>
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
                    width=3></TD></TR></TBODY></TABLE></TD>
                    </c:if>
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
                      <tr>
                      	<td width="%35" class="table_body" align="right">打折方式:</td>
                      	<td class="table_none"><input type="radio" name="idorcard" value="1" onclick="idorcardclick();" checked="checked"/>员工工号打折
                      		 <!-- &nbsp;&nbsp;&nbsp;<input type="radio" name="idorcard" value="2" onclick="idorcardclick()"/>员工卡打折 -->
                        </td>
                      </tr>
                      <TR id="trid1">
                      	<TD height="26" class="table_body" align="right" >员工工号:</TD>
                      	<TD class="table_none" colspan="3" >
                            <input class="text_input200" type="text" id="fpdpersonid" onkeydown="if(event.keyCode==13)$('#fpdpersonpassword').focus()" name="fpdpersonid" value="${requestScope.fpdpersonid }">
			            </TD>
                      </TR>
                      <TR id="trid2">
                      	<TD height="26" class="table_body" align="right">员工密码:</TD>
                      	<TD class="table_none" colspan="3" >
                            <input class="text_input200" type="password" id="fpdpersonpassword" name="fpdpersonpassword" value="${requestScope.fpdpersonpassword }" onkeydown="selectDiscount()"><font color="red">填写工号及密码按回车</font>
			               </TD>
                      </TR>
                      <TR id="trcard1" style="display: none">
                      	<TD height="26" class="table_body" align="right" >员工卡号:</TD>
                      	<TD class="table_none" colspan="3" >
                            <input class="text_input200" type="password" id="cardid" name="cardid" value="${requestScope.cardid }" onkeydown="selectDiscount()">&nbsp;&nbsp;<font color="red">填写卡号按回车</font>
			               </TD>
                      </TR>
                      <c:if test="${not empty(personInfoPo)}">
                      <tr>
                      <td colspan="4" width="%100" height="26" class="table_none" align="center">
                      	当前打折用户&nbsp;<font color="blue">${personInfoPo.personName}</font>
                      	<c:if test="${systemParameterPo.fspisshowdiscount3detail eq '1'}">
                      		&nbsp;&nbsp;&nbsp;&nbsp;普通折扣&nbsp;<font color="blue">${personInfoPo.personDiscount}</font>
                      	</c:if>
                      	&nbsp;&nbsp;&nbsp;&nbsp;特殊折扣次数&nbsp;<font color="blue">${personInfoPo.fpdspecialdiscountnumber}</font>
                      	<c:if test="${systemParameterPo.fspisshowdiscount3detail eq '1'}">
                      		&nbsp;&nbsp;&nbsp;&nbsp;特殊折扣&nbsp;<font color="blue">${personInfoPo.fpdspecialdiscount}</font>
                      	</c:if>
                      </td>
                      </tr>
                      <TR>
                      	<TD height="26" class="table_body" align="right">折扣类型:</TD>
                      	<TD class="table_none" colspan="3" >
                            <input type="radio" name="discounttype" id="discounttype" value="1" checked="checked"/>&nbsp;正常折扣&nbsp;
							<input type="radio" name="discounttype" id="discounttype" value="2" onclick="pointout();"/>&nbsp;特殊折扣&nbsp;
			            </TD>
                      </TR>
                      <TR>
                      	<TD height="26" class="table_body" align="right">折扣:</TD>
                      	<TD class="table_none" colspan="3" >
                            <input class="text_input100" type="text" id="fpddiscount" maxlength="6" name="fpddiscount" onkeydown="discount1()">
                            <input type="hidden" id="mindiscount" name="mindiscount" value="${personInfoPo.personDiscount}">
                            <input type="hidden" id="specialdiscount" name="specialdiscount" value="${personInfoPo.fpdspecialdiscount}">
			               </TD>
                      </TR>
                      </c:if>
                      </TBODY>
                      <br/>
                    </table>
                    <c:if test="${not empty(personInfoPo)}"> 
                    <table width="100%" id="title2" cellspacing="2">
						<tr height="10" >
							<td align="right">
								<img id="submitButton" src="${ctx}/img/newbtn/btn_define_0.png" btn=btn  title='确定' onClick="javascript:discount()" onkeydown="discount1()">
							</td>
						</tr>
					</table>
					</c:if>
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
