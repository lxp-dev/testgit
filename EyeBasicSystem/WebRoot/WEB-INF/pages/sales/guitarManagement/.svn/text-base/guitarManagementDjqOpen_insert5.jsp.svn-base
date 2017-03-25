<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代金券付款</title>
</head>
<script>	
		
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	
	function selCzk(){
		if(event.keyCode==13){
			var isuse = "";
			window.parent.$("input[djqid=djqid]").each(function (){
				if($(this).val() == $("#djqid").val()&& window.parent.$("input[djqid]").eq('${indexid }').val() != $("#djqid").val()){
					isuse = "1"
				}
			});
			var orderType=window.parent.$('input[id=orderType]').val();
			var salesValue=window.parent.$('input[id=salesValue]').val();

			if(isuse == "1"){
				alert("代金券号："+$("#djqid").val()+"已被使用！");
				return;
			}
			var salesid=window.parent.$("input[id=salesid]").val();
			$("img").removeAttr("onclick");
			guitarMangermentForm.action = "selDjqPo5.action?djqid="+$("#djqid").val()+"&orderType="+orderType+"&salesValue="+salesValue+"&salesid="+salesid;
			guitarMangermentForm.submit();
		}
	}
	
	function setValue(id){

		
		var ffje = parseFloat($('input[name=ffje]').val());
		var fpddiscount = parseFloat($('input[name=fpddiscount]').val());
		var salseValue = Math.abs(parseFloat(window.parent.$('input[return=1]').val()));
		var djqid = parseFloat($('input[name=djqid]').val());
		if (!(/^([1-9]\d*|\d+\.\d+|\d+\.|0)$/.test(ffje))){
			alert('数字格式输入错误！');
			$('input[name=ffje]').select();
			return false;
		}
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
			parent.toRound2(accAdd(ffje,0).toFixed(2),accAdd('${cashCouponPo.bccamount}',+ffje).toFixed(2),'${cashCouponPo.bcccard}',fpddiscount,'${indexid}');
		}else{
			parent.toRound2(accAdd(ffje,0).toFixed(2),accAdd('${cashCouponPo.bccamount}',-ffje).toFixed(2),'${cashCouponPo.bcccard}',fpddiscount,'${indexid}');
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
	    document.getElementById('djqid').focus();
    }); 
    	
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="guitarMangermentForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="rownumber" value="${requestScope.rownumber}">
<input type="hidden" name="arg0" value="${requestScope.arg0}">

<input type="hidden" id="indexid" name="indexid" value="${indexid }"> 

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
          background=${ctx }/img/pic/tab_bg.gif>
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
                      	<TD width="%35" height="30" class="table_body" align="right">代金券号</TD>
                      	<TD width="%65" class="table_none" colspan="3" style="color: red;">
                            <input class="text_input200" type="text" id="djqid" onkeydown="selCzk()" name="djqid" value="${cashCouponPo.bcccard}"><label style="color:red;">&nbsp;请点击回车键</label>
                        </TD>
                      </TR>
                      <c:if test="${cashCouponPo.bcccard!=null}"> 
                      <TR>
                      	<TD width="%35" height="30" class="table_body" align="right">金额</TD>
                      	<TD width="%65" class="table_none" colspan="3" >
                            <input class="text_input100" type="text" id="fpddiscount" maxlength="6" style="border: none;background: " name="fpddiscount" value="${cashCouponPo.bccamount }" readonly="readonly">
			               </TD>
                      </TR>
                      <TR>
                      	<TD width="%35" height="30" class="table_body" align="right">付费金额</TD>
                      	<TD width="%65" class="table_none" colspan="3">
                            <input class="text_input100" type="text" id="ffje" maxlength="6" name="ffje" value="${cashCouponPo.bccamount }">
                        </td>
                      </TR>
                      </c:if>
                      </TBODY>
                      <br/>
                    </table>
                    <c:if test="${cashCouponPo.bcccard!=null}"> 
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
