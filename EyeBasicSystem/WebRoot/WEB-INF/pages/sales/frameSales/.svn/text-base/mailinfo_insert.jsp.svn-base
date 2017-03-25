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
<title>邮寄管理</title>
</head>
<script>	
	function trim(str){ //删除左右两端的空格
　　  	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }

  	function save(){
		if(checkForm(document.all.toMailForm)){
			if($('#ssetmcustomername').val()==''){
				alert("顾客姓名不能为空！");
				$('#ssetmcustomername').focus();
				return;
			}
			
			if($('#ssetmcustomerphone').val()==''){
				alert("顾客联系电话不能为空！");
				$('#ssetmcustomerphone').focus();
				return;
			}

			var regPhone = /^((1[3|5|7|8][0-9]\d{4,8})|((0{1,1}[1-9]{2,3}-)?[1-9]{1,1}[0-9]{6,7}))$/				
			if(regPhone.exec($("#ssetmcustomerphone").val()) == null) {
				alert("顾客联系电话格式不正确！");
				$('#ssetmcustomerphone').focus();
				$('#ssetmcustomerphone').select();
				return;
			}
			
			parent.$('#ssetmmemberid').val($('#ssetmmemberid').val());
			parent.$('#ssetmcustomername').val($('#ssetmcustomername').val());
			parent.$('#ssetmcustomerphone').val($('#ssetmcustomerphone').val());
			parent.$('#ssetmareacode').val($('#ssetmareacode').val());
			parent.$('#ssetmlinkman').val($('#ssetmlinkman').val());
			parent.$('#ssetmtomaillistid').val($('#ssetmtomaillistid').val());
			parent.$('#ssetmmaiiladdress').val($('#ssetmmaiiladdress').val());
			
			parent.$('#ssetmprovinces').val($('#ssetmprovinces').val());
			parent.$('#ssetmcity').val($('#ssetmcity').val());
			parent.$('#ssetmdistrict').val($('#ssetmdistrict').val());
			parent.$('#ssetmstreet').val($('#ssetmstreet').val());
			parent.$('#ssetmissupport').val($('#ssetmissupport').val());      // 是否保价
			parent.$('#ssetmsupportvalue').val($('#ssetmsupportvalue').val());      // 保价金额
			parent.$('#mailMsg').text('邮寄信息已填写!');

			parent.hidePopWin();
		}
	}
 
	function clean(){
		toMailForm.reset();
	}

	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	    
	    $("[order=order]").keydown(function(){
        	if(event.keyCode == 13){
        		$(this).next().focus();
        	}
        });
        
        if(parent.$('#ssetmsupportvalue').val() != ''){
        	$("#bjv").show();
        }
        
	    $('#ssetmmemberid').val(parent.$('#ssetmmemberid').val());
	    $('#ssetmcustomername').val(parent.$('#ssetmcustomername').val());
	    $('#ssetmcustomerphone').val(parent.$('#ssetmcustomerphone').val());
	    $('#ssetmareacode').val(parent.$('#ssetmareacode').val());
	    $('#ssetmlinkman').val(parent.$('#ssetmlinkman').val());
	    $('#ssetmtomaillistid').val(parent.$('#ssetmtomaillistid').val());
	    $('#ssetmmaiiladdress').val(parent.$('#ssetmmaiiladdress').val()); 
	    
	    $('#ssetmprovinces').val(parent.$('#ssetmprovinces').val()); 
	    $('#ssetmcity').val(parent.$('#ssetmcity').val()); 
	    $('#ssetmdistrict').val(parent.$('#ssetmdistrict').val()); 
	    $('#ssetmstreet').val(parent.$('#ssetmstreet').val()); 
	    if(parent.$('#ssetmissupport').val() == '1'){
	    	$('#ssetmissupport').attr("checked","checked");
	    } 
	    $('#ssetmsupportvalue').val(parent.$('#ssetmsupportvalue').val()); 
    }); 
    
    function isshowbjv(obj) {
		if($(obj).attr("checked")){
			$("div[id=bjv]").show();
		}else{
			$("div[id=bjv]").hide();
			$("#ssetmsupportvalue").val("");
		}
	}
</script>
<BODY bgColor=#ffffff topMargin=5  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' } >
<form name="toMailForm" method="post" action="">
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
				</TD></TR>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
					  	  <TD height="26" class="table_body">会员卡号</TD>
					  	  <TD class="table_none"><input type="text" readonly="readonly" style="background-color: #E0E0E0" id="ssetmmemberid" value=""/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
					  	  <TD width="10%" height="26" class="table_body">顾客姓名</TD>
                    	  <TD width="30%" class="table_none"><input class="text_input200" type="text"  id="ssetmcustomername" value="" maxlength="16" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '顾客姓名不能为空!'}]"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
                    	  <TD width="10%" class="table_body">顾客电话</TD>
                    	  <TD class="table_none">
                    	    <input class="text_input200" type="text"  id="ssetmcustomerphone" value="" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '顾客电话不能为空!'},{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '顾客电话格式错误!'}]"/>
                    	  <label style="color:red;">&nbsp;*&nbsp;</label> 
                    	  </TD>
                    	  
					  	</TR>
                    	<TR>
                    	  <TD height="26" class="table_body">顾客区号</TD>
                    	  <TD class="table_none">                   	  
                    	    <input class="text_input160" type="text"  id="ssetmareacode" value="" maxlength="5" />
                    	  </TD>
                   	      <TD width="8%" height="26" class="table_body">收件人</TD>
                    	  <TD class="table_none"><input class="text_input160" type="text"  id="ssetmlinkman" value="" maxlength="16" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '联系人不能为空!'}]"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>                   	
                    	  <TD height="26" class="table_body">邮寄单</TD>
                    	  <TD class="table_none" colspan="3">
                    	   <select clean=clean id="ssetmtomaillistid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '邮寄单不能为空!'}]">>
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="mailingList">
                    	           <OPTION value="${btmlid}">${btmlname}</OPTION>
                    	          </s:iterator>
      	                    </select>
      	                    <label style="color:red;">&nbsp;*&nbsp;</label> 
                    	  </TD>
                  	    </TR>
                        <TR>
                    	  <TD height="26" class="table_body">地址</TD>
                          <TD class="table_none" colspan="6" height="26">
                          	<input class="text_input80" type="text" order=order id="ssetmprovinces" name="toMailPo.ssetmprovinces" value="${toMailPo.ssetmprovinces }" maxlength="20"/>
                          	&nbsp;&nbsp;省&nbsp;&nbsp;
                          	<input class="text_input80" type="text" order=order id="ssetmcity" name="toMailPo.ssetmcity" value="${toMailPo.ssetmcity }" maxlength="20"/>
                          	&nbsp;&nbsp;市&nbsp;&nbsp;
                          	<input class="text_input80" type="text" order=order id="ssetmdistrict" name="toMailPo.ssetmdistrict" value="${toMailPo.ssetmdistrict }" maxlength="20"/>
                          	&nbsp;&nbsp;区（县）&nbsp;&nbsp;
                          	<input class="text_input80" type="text" order=order id="ssetmstreet" name="toMailPo.ssetmstreet" value="${toMailPo.ssetmstreet }" maxlength="20"/>
                            &nbsp;&nbsp;路（街）
                            <input type="text" order=order class="text_input200" name="toMailPo.ssetmmaiiladdress" id="ssetmmaiiladdress" value="${toMailPo.ssetmmaiiladdress }" maxlength="100"/>

                          </TD>
                        </TR>
                    <c:if test="${systemParameterPo.fspisbaojiaflag == '1'}">    
                        <TR>
                    	  <TD height="26" class="table_body">保价</TD>
                    	  <TD class="table_none" colspan="5">
                    	    <input type="checkbox"  id="ssetmissupport" name="toMailPo.ssetmissupport" value="1" onclick="isshowbjv(this)"/>&nbsp;&nbsp;
                    	    <div id="bjv" style="display: none;">
                    	    <input class="text_input80" type="text" id="ssetmsupportvalue" name="toMailPo.ssetmsupportvalue" value="" maxlength="20" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}"/>&nbsp;元
                    	    </div>
                    	  </TD>
                  	  </TR>
                  	</c:if>
                      </TBODY>
                    </TABLE>
                     
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img btn=btn id="submitBtn" name="submitBtn" src="${ctx}/img/newbtn/btn_save_0.png" title='保存' onclick="save()">
								<img src="${ctx }/img/newbtn/btn_reset_0.png" btn=btn title='重置'  onClick="clean()" >
							</td>
						</tr>
					</table>
					
					 
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  
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

