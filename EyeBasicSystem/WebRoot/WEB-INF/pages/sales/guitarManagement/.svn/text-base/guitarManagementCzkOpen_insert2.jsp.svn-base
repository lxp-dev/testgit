<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>储值卡付款</title>
</head>
<script>	

	
	function selectDiscount(){
		if(event.keyCode==13){
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
			
			$("img").removeAttr("onclick");
			
			personDiscountForm.action = "selectPersonDiscount.action?indexid="+'${indexid}';
			personDiscountForm.submit();
		}
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function discount(){
		var mindiscount = document.getElementById('mindiscount').value;
		var fpdpersonid = document.getElementById('fpddiscount').value;
	    if(mindiscount == null || mindiscount == ""){
			alert('您的打折权限不够!');
			return false;
		}
		
		if(fpdpersonid < mindiscount && fpdpersonid > 0){
			alert('您的打折权限不够!');
			document.getElementById('fpddiscount').focus();
			return false;
		}
		if(fpdpersonid > 1 || fpdpersonid <= 0 ){
			alert("请输入正确的折扣数!");
			document.getElementById('fpddiscount').focus();
			return false;
		}
		if('${arg0}'=='1'){//单品打折
			parent.setDiscount2(fpdpersonid,'${rownumber}');
		}else{
			parent.setDiscount1(fpdpersonid);
		}
		parent.hidePopWin();
		
	}
	
	function discount1(){
		if(event.keyCode==13){
			var mindiscount = document.getElementById('mindiscount').value;
			var fpdpersonid = document.getElementById('fpddiscount').value;
		    if(mindiscount == null || mindiscount == ""){
				alert('您的打折权限不够!');
				return false;
			}
			
			if(fpdpersonid < mindiscount && fpdpersonid > 0){
				alert('您的打折权限不够!');
				document.getElementById('fpddiscount').focus();
				return false;
			}
			if(fpdpersonid > 1 || fpdpersonid <= 0 ){
				alert("请输入正确的折扣数!");
				document.getElementById('fpddiscount').focus();
				return false;
			}
			if('${arg0}'=='1'){//单品打折
				parent.setDiscount2(fpdpersonid,'${rownumber}');
			}else{
				parent.setDiscount1(fpdpersonid);
			}
			parent.hidePopWin();parent.toRound();
		}
	}
	
	function selCzk(){
		if(event.keyCode==13){
			var isuse = "";
			window.parent.$("input[cstczkcardid=cstczkcardid]").each(function (){
				if($(this).val() == $("#cstczkcardid").val()&& window.parent.$("input[cstczkcardid=cstczkcardid]").eq('${indexid }').val() != $("#cstczkcardid").val()){
					isuse = "1"
				}
			});

			if(isuse == "1"){
				alert("储值卡号："+$("#cstczkcardid").val()+"已被使用！");
				return false;
			}else{
			var salseValue = $('input[name=salseValue]').val();
			$("img").removeAttr("onclick");
			var salesid=window.parent.$("input[id=salesid]").val();
			guitarMangermentForm.action = "selCzkPo2.action?salseValue="+salseValue+"&cstczkcardid="+$("#cstczkcardid").val()+"&salesid="+salesid;
			guitarMangermentForm.submit();
			}
		}
	}
	
	function setValue(id){
		if($("#inczkpassword").val() != $("#czkpassword").val() && $("#czkpassword").val()){
			alert('储值卡密码错误！');
			return;
		}
		
		var ffje = parseFloat($('input[name=ffje]').val());
		var fpddiscount = parseFloat($('input[name=fpddiscount]').val());
		var salseValue = Math.abs(parseFloat(window.parent.$('#salseValue').val()));
		var salseValue1 = parseFloat(window.parent.$('#salseValue').val());
		var cstczkcardid = parseFloat($('input[name=cstczkcardid]').val());
		
		if(salseValue1 > 0){
			if(ffje < 0){
				alert('金额输入错误！');
				$('input[name=ffje]').select();
				return false;
			}
		}
		
		if(salseValue1 < 0){
			if(ffje > 0){
				alert('金额输入错误！');
				$('input[name=ffje]').select();
				return false;
			}
		}
		
		/*if (!(/^([1-9]\d*|\d+\.\d+|\d+\.|0)$/.test(ffje))){
			alert('数字格式输入错误！');
			$('input[name=ffje]').select();
			return false;
		}*/
		if(window.parent.$("#return").val().trim() == '1'){
			if(parseFloat(salseValue) < parseFloat(ffje)){
				alert('退款金额不得大于应收金额！');
				$('input[name=ffje]').select();
				return false;
			}
		}else{
			if(fpddiscount<ffje){
				alert('付费金额不得大于余额！');
				$('input[name=ffje]').select();
				return false;
			}
			
			if(salseValue < ffje){
				alert('付费金额不得大于应收金额！');
				$('input[name=ffje]').select();
				return false;
			}
		}
		
		
		fpddiscount = accAdd(fpddiscount, "-"+ffje);
		if('${returntype}'=='1'){
			parent.toRound(accAdd(ffje,0).toFixed(2),accAdd('${chuzhikaPo.cstczkjine }',+ffje).toFixed(2),'${chuzhikaPo.cstczkid}',fpddiscount,'${indexid}');
		}else{
			parent.toRound(accAdd(ffje,0).toFixed(2),accAdd('${chuzhikaPo.cstczkjine }',-ffje).toFixed(2),'${chuzhikaPo.cstczkid}',fpddiscount,'${indexid}');
		}
		parent.hidePopWin();
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    document.getElementById('cstczkcardid').focus();
    }); 
    	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="guitarMangermentForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="rownumber" value="${requestScope.rownumber}">
<input type="hidden" name="arg0" value="${requestScope.arg0}">
<input type="hidden" id="salseValue" maxlength="6" name="salseValue" value="${requestScope.salseValue }">
<input type="hidden" id="indexid" name="indexid" value="${indexid }"> 
<input type="hidden" id="returntype" name="returntype" value="${returntype }"> 
<input class="text_input200" type="hidden" id="czkpassword" name="czkpassword" value="${chuzhikaPo.cstczkcardpassword }">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px"  background=${ctx }/img/pic/tab_bg.gif> </TD></TR>
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
                      	<TD width="%35" height="30" class="table_body" align="right">储值卡号</TD>
                      	<TD width="%65" class="table_none" colspan="3" style="color: red;">
                            <input class="text_input200" type="text" id="cstczkcardid" onkeydown="selCzk()" name="cstczkcardid" value="${chuzhikaPo.cstczkcardid}"><label style="color:red;">&nbsp;请点击回车键</label>
                        </TD>
                      </TR>
                      <c:if test="${not empty(chuzhikaPo.cstczkcardpassword)}">
                      <TR>
                      	<TD width="%35" height="30" class="table_body" align="right">密码</TD>
                      	<TD width="%65" class="table_none" colspan="3" style="color: red;">
                            <input class="text_input200" type="password" id="inczkpassword" name="inczkpassword" value="">
                        </TD>
                      </TR>
                      </c:if>
                      <c:if test="${chuzhikaPo.cstczkcardid!=null}"> 
                      <TR>
                      	<TD width="%35" height="30" class="table_body" align="right">余额</TD>
                      	<TD width="%65" class="table_none" colspan="3" >
                            <input class="text_input100" type="text" id="fpddiscount" maxlength="6" style="border: none;background: " name="fpddiscount" value="${chuzhikaPo.cstczkjine }" readonly="readonly">
			               </TD>
                      </TR>
                      <TR>
                      	<TD width="%35" height="30" class="table_body" align="right">付费金额</TD>
                      	<TD width="%65" class="table_none" colspan="3">
                            <input class="text_input100" type="text" id="ffje" maxlength="6" name="ffje" value="" onkeypress="if(event.keyCode==13) {setValue();return false;}"><label style="color:red;">&nbsp;请点击回车键</label>
                        </td>
                      </TR>
                      </c:if>
                      </TBODY>
                      <br/>
                    </table>
                    <c:if test="${chuzhikaPo.cstczkcardid!=null}"> 
                    <table width="100%" id="title2" cellspacing="2">
						<tr height="10" >
							<td align="center">
                        	<img src="${ctx }/img/newbtn/btn_pay_0.png" btn=btn id="jfButton" name="jfButton" title='缴费' onClick="setValue(this)">
			            	</TD>
							<td >
                        	</TD>
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
