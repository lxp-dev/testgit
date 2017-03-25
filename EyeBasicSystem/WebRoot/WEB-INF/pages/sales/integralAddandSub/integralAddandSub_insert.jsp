<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css"> 
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>积分赠送管理</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

    	if ('${errormsg}' == '1'){
            alert('此会员卡信息不存在,请重新确认会员卡号!');
    		$('#customername').val('');
    		$('#phone').val('');
    		$('#smeasyintegral').val('');
    		$('#smeascustomerid').val('');
        }
    	if ('${errormsg}' == '2'){
            alert('此会员卡号与会员信息不符,请重新确认会员卡号!');
        }
    	if ('${errormsg}' == '3'){
            alert('此会员为副卡，直接带入主卡信息!');
        }
    	$('#smeasmemberid').focus();
	});

	function save(){
		if(checkForm(document.all.customerComplainForm)){ 
			if($('#smeasmemberid').val()==''){
				alert("请选择会员！");
				var topRows = top.document.getElementById("total").rows;
				var topCols = top.document.getElementById("btmframe").cols;
				if(is_iPad()){
					showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}else{
					showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
				}
				document.getElementById('popupTitle').innerHTML="【会员查询】";
				return;
			}
			
			if (Number($('#smeascintegral').val()) == 0){
                alert('请重新填写赠送积分,积分不能为0!');
                return;
			}else{
				$('#smeascintegral').val(Number($('#smeascintegral').val()));
			}
			$("img").removeAttr("onclick");
			customerComplainForm.action = "insertIntegralAddandSub.action";
			customerComplainForm.submit();
		}
	}
 
	function clean(){
	    document.customerComplainForm.reset(); 
	}	
	
	function setCustomer(memberid ,cname, cphone, cintegral,customerid){
		$('#customername').val(cname);
		$('#phone').val(cphone);
		$('#smeasmemberid').val(memberid);
		$('#smeasyintegral').val(cintegral);
		$('#smeascustomerid').val(customerid);
		customerComplainForm.action = 'integralCustomerSel.action';
		customerComplainForm.submit();
	}

	function selCustomerInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
    }

	function selectCustomer(){
		if(document.getElementById('smeasmemberid').value.trim() != ''){
			if(event.keyCode == 13){
				$("img").removeAttr("onclick");
				customerComplainForm.action = 'integralCustomerSel.action';
				customerComplainForm.submit();
			}
		}
	}
</script>
<body>
<form name="customerComplainForm" id="customerComplainForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }">

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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/danjutou.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
                          <TD width="8%" height="26" class="table_body">会员卡号</TD>
					  	  <TD width="24%" class="table_none">
					  	  <li class="horizontal_onlyRight">
					  	  	<input type="text" class="text_input160" id="smeasmemberid" name="integralAddandSubPo.smeasmemberid" value="${integralAddandSubPo.smeasmemberid }" onkeyup="this.value = $.trim(this.value);selectCustomer();" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请先填写会员卡号！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '会员卡号只允许输入整数和字母！'}]" maxlength="50"/>
					  	  <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					  	  </li>
					  	  </TD>
					  	  <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                    	  <TD width="24%" class="table_none"><input class="text_input160" readonly="readonly" type="text" style="background-color: #E0E0E0" id="customername" value="${integralAddandSubPo.smeascustomername}" name="integralAddandSubPo.smeascustomername" /><input readonly="readonly" type="hidden" id="smeascustomerid" name="integralAddandSubPo.smeascustomerid" value="${integralAddandSubPo.smeascustomerid }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请先选取会员！'}]"/></TD>
                    	  <TD width="8%" height="26" class="table_body">顾客电话</TD>
                    	  <TD class="table_none"><input class="text_input160" readonly="readonly" type="text" style="background-color: #E0E0E0" id="phone" name="integralAddandSubPo.smeascustomerphone" value="${integralAddandSubPo.smeascustomerphone}"/></TD>
					  	</TR>
                    	<TR>
                    	  <TD width="8%" height="26" class="table_body">顾客积分</TD>
                    	  <TD class="table_none">
                    	  	<input class="text_input160" readonly="readonly" type="text" style="background-color: #E0E0E0" name="integralAddandSubPo.smeasyintegral" id="smeasyintegral" value="${integralAddandSubPo.smeasyintegral }"/>
                    	  </TD>
			              <TD height="26" class="table_body">赠送积分</TD>
                    	  <TD class="table_none" colspan="3">
                    	  	<input class="text_input160" type="text" name="integralAddandSubPo.smeascintegral" id="smeascintegral" value="${integralAddandSubPo.smeascintegral }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写积分！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '赠送积分数应为整数！'}]" maxlength="10" onblur="this.value = $.trim(this.value);"/>
                    	  </TD>
                    	</TR>
                    	<TR>
                          <TD height="26" class="table_body">备注</TD>
                          <TD class="table_none" colspan="5">
                            <textarea name="integralAddandSubPo.smeasremark" id="smeasremark" 
                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注内容不能大于100字！'}]">${integralAddandSubPo.smeasremark }</textarea>
                          </TD>
                        </TR>
                        <!--  
                        <c:if test="${first==1}" >                      
	                        <TR>
	                          <TD height="26" class="table_body">短信内容</TD>
	                          <TD class="table_none" colspan="5">                         
	                            <textarea name="content" readonly="readonly" id="content" >${content }</textarea>
	                          </TD>
	                        </TR>
                        </c:if>
                        -->
                        <input type="hidden" name="content" id="content" value="${content}">
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
                    <c:if test="${first==1}" >   
						<c:choose>
							<c:when test="${second==1}">
								<input type="hidden" id="isSend" name="isSend" value="1" >
								
							</c:when>
							<c:otherwise>
								<input type="hidden" id="isSend" name="isSend" value="0" >
							</c:otherwise>
						</c:choose>
                    </c:if>  
						<tr height="10">
							<td>
								<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()" >								
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空'  onClick="clean()" >
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
        <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>