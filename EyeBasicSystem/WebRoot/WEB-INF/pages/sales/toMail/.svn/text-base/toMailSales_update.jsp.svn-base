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
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerInfoForm.action=link;
	  	customerInfoForm.submit();
	}

	function save(){
		if(checkForm(document.all.toMailForm)){
			if($('#ssetmlinksalesid').val()==''){
				alert("请选择对应销售单！");
				return;
			}
		
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
			
			if($('#ssetmmaiiladdress').val()==''){
				alert("邮寄地址不能为空！");
				$('#ssetmmaiiladdress').focus();
				return;
			}
		
			if($('#ssetmmaiilaudit').is(":checked")){
				if($('#ssetmmailcompanyname').val()==''){
					alert("快递公司名称不能为空！");
					$('#ssetmmailcompanyname').focus();
					return;
				}
				
				if($('#ssetmmailid').val()==''){
					alert("快递单号不能为空！");
					$('#ssetmmailid').focus();
					return;
				}
				
				if($('#ssetmsenddate').val()==''){
					alert("邮寄时间不能为空！");
					$('#ssetmsenddate').focus();
					return;
				}
				
			}
			
			$("img").removeAttr("onclick");
			toMailForm.action = "salesOpenToMailUpdate.action";
			toMailForm.submit();
		}
	}
 
	function clean(){
		toMailForm.reset();
	}	
	function permissionMessage(){
        alert('您无此操作权限');
	}
 
    /**
	 *聚焦
	 */
	window.onload=function(){
		
	}
	
	function searchSalesOpen(){
		showPopWin("","initToMailOpenSalesSel.action",screen.width-200,screen.height-160, '',null,true);
		selectHidden();
	}
	
	function setCustomer(ssetmlinksalesid ,ssetmcustomername, ssetmcustomerphone ,ssetmmemberid){
		$('#ssetmlinksalesid').val(ssetmlinksalesid);
		$('#ssetmcustomername').val(ssetmcustomername);
		$('#ssetmcustomerphone').val(ssetmcustomerphone);
		$('#ssetmmemberid').val(ssetmmemberid);
		
	}
	
	function getTadayDate(){
		var myDate = new Date();
		myDate.getFullYear();    //获取完整的年份(4位,1970-????)
		myDate.getMonth();       //获取当前月份(0-11,0代表1月)
		myDate.getDate();        //获取当前日(1-31)
		myDate.getHours();       //获取当前小时数(0-23)
		myDate.getMinutes();     //获取当前分钟数(0-59)
		
		var dateString='';
		dateString=myDate.getFullYear();
		
		if(myDate.getMonth()<9){
			dateString=dateString+'-0'+(myDate.getMonth()+1);
		}else{
			dateString=dateString+'-'+(myDate.getMonth()+1);
		}
		
		if(myDate.getDate()<10){
			dateString=dateString+'-0'+myDate.getDate();
		}else{
			dateString=dateString+'-'+myDate.getDate();
		}
		
		if(myDate.getHours()<10){
			dateString=dateString+' 0'+myDate.getHours();
		}else{
			dateString=dateString+' '+myDate.getHours();
		}
		
		if(myDate.getMinutes()<10){
			dateString=dateString+':0'+myDate.getMinutes();
		}else{
			dateString=dateString+':'+myDate.getMinutes();
		}
		
		$('#ssetmsenddate').val(dateString);
	}
</script>
<body>
<form name="toMailForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }">
<input type="hidden" name="open" value="open">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <Tr height="20"><td></td></Tr>
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
                          <TD height="30" class="table_body">配镜单号</TD>
					  	  <TD class="table_none"><li class="horizontal_onlyRight"><input type="text" readonly="readonly" style="background-color: #E0E0E0" id="ssetmlinksalesid" name="toMailPo.ssetmlinksalesid" value="${toMailPo.ssetmlinksalesid }"/></li>		 
					  	  <input type="hidden" readonly="readonly" style="background-color: #E0E0E0" id="ssetmuuid" name="toMailPo.ssetmuuid" value="${toMailPo.ssetmuuid }"/>
					  	  <label style="color:red;">&nbsp;*&nbsp;</label> 
					  	  </TD>
					  	  <TD height="30" class="table_body">会员卡号</TD>
					  	  <TD class="table_none"><input type="text" readonly="readonly" style="background-color: #E0E0E0" id="ssetmmemberid" name="toMailPo.ssetmmemberid" value="${toMailPo.ssetmmemberid }"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
					  	  </TR>
                    	<TR>
                    	  <TD width="10%" height="30" class="table_body">顾客姓名</TD>
                    	  <TD width="30%" class="table_none"><input class="text_input200" type="text"  id="ssetmcustomername" name="toMailPo.ssetmcustomername" value="${toMailPo.ssetmcustomername }" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '顾客姓名不能为空!'}]"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
                    	  <TD height="26" class="table_body">顾客区号</TD>
                    	  <TD class="table_none">                   	  
                    	    <input class="text_input160" type="text"  id="ssetmareacode" name="toMailPo.ssetmareacode" value="${toMailPo.ssetmareacode}" maxlength="5" />
                    	  </TD>
                    	</TR>
                   					  
                        <TR>
                    	  <TD width="10%" height="30" class="table_body">顾客电话</TD>
                    	  <TD class="table_none">
                    	    <input class="text_input200" type="text"  id="ssetmcustomerphone" name="toMailPo.ssetmcustomerphone" value="${toMailPo.ssetmcustomerphone }" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '顾客电话不能为空!'},{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '顾客电话错误!'}]"/>
                    	    <label style="color:red;">&nbsp;*&nbsp;</label> 
                    	  </TD>

                    	  <TD width="8%" height="26" class="table_body">联系人</TD>
                    	  <TD class="table_none"><input class="text_input160" type="text"  id="ssetmlinkman" name="toMailPo.ssetmlinkman" value="${toMailPo.ssetmlinkman}" maxlength="16" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '联系人不能为空!'}]"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>                   	
                    	</TR>
                   					  
                        <TR>
                    	  <TD height="26" class="table_body">邮寄单</TD>
                    	  <TD class="table_none" colspan="3">
                    	   <select clean=clean id="ssetmtomaillistid" name="toMailPo.ssetmtomaillistid"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '邮寄单不能为空!'}]">>
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="mailingList">
                    	           <OPTION value="${btmlid}" ${mailingListPo.btmlid!= btmlid  ? '' : 'selected="selected"' } >${btmlname}</OPTION>
                    	          </s:iterator>
      	                    </select>
      	                    <label style="color:red;">&nbsp;*&nbsp;</label> 
                    	  </TD>
                    	</TR>
                   					  
                        <TR>
                          <TD height="30" class="table_body">快递地址</TD>
                          <TD class="table_none" colspan="3"><textarea name="toMailPo.ssetmmaiiladdress" id="ssetmmaiiladdress"
                          	validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '地址不能大于100字！'}]">${toMailPo.ssetmmaiiladdress }</textarea>&nbsp;<label style="color:red;">&nbsp;*&nbsp;</label> </TD>
                        </TR>
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

