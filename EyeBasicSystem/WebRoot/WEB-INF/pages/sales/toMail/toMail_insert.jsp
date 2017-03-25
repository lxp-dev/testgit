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

	function printReport(id){
	
		var reporturl='${toMailPo.ssetmtoreportname}';
		var DataURL = "report.action?reportlet="+reporturl+"&ssetmuuid="+id;									                    
	    var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		
		window.open(DataURL,'','toolbar=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,width='+(screen.width)+',height='+(screen.height-100)); 
		
	
		document.getElementById('popupTitle').innerHTML="【邮寄单】";
	}
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
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
	});

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

			if($("#ssetmissupport").attr("checked")){
				if($("#ssetmsupportvalue").val() == ""){
					alert("保价金额不能为空！");
					$('#ssetmsupportvalue').focus();
					return;
				}
			}
		
			$("img").removeAttr("onclick");
			toMailForm.action = "toMailInsert.action";
			toMailForm.submit();
		}
	}
 
	function clean(){
		toMailForm.reset();
		if($("#ssetmissupport").attr("checked")){
			$("div[id=bjv]").show();
		}else{
			$("div[id=bjv]").hide();
			$("#ssetmsupportvalue").val("");
		}
	}
	function permissionMessage(){
        alert('您无此操作权限');
	}
 
 
	
	function searchSalesOpen(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initToMailOpenSalesSel.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initToMailOpenSalesSel.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【配镜单查询】";
	}
	
	function setCustomer(ssetmlinksalesid ,ssetmcustomername, ssetmcustomerphone ,ssetmmemberid,ssetmcustomerid,ssesbsalesvalue){
		$('#ssetmlinksalesid').val(ssetmlinksalesid);
		$('#ssetmcustomername').val(ssetmcustomername);
		$('#ssetmcustomerphone').val(ssetmcustomerphone);
		$('#ssetmmemberid').val(ssetmmemberid);
		$('#ssetmlinkman').val(ssetmcustomername);
		$('#ssetmcustomerid').val(ssetmcustomerid);

		// 计算保价金额
		if('${systemParameterPo.fspisbaojiaflag}' == '2'){
			if (accSub(ssesbsalesvalue,'3000') >= 0 ){
		        $('#ssetmissupport').val('1');
		        $('#ssetmsupportvalue').val(accDiv(ssesbsalesvalue,2));
		        $('#supportvalue').text(accDiv(ssesbsalesvalue,2));
			}else{
		        $('#ssetmissupport').val('0');
		        $('#ssetmsupportvalue').val();
		        $('#supportvalue').text(0.00);
			}
		}
		
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
	
	function show(){
		if($('#ssetmmaiilaudit').attr('checked')){
			$('#showtr1').attr('style','');
		}else{
			$('#showtr1').attr('style','display:none');
		}
		if($("#ssetmmailcompanyname").val()==''){
		    $("#ssetmmailcompanyname").val($("#ssetmtomaillistid").find("option:selected").text());
		}
	}
	
	function isshowbjv(obj) {
		if($(obj).attr("checked")){
			$("div[id=bjv]").show();
		}else{
			$("div[id=bjv]").hide();
			$("#ssetmsupportvalue").val("");
		}
	}
</script>
<body>
<form name="toMailForm" method="post" action="">
<input type="hidden" name="moduleID" value="${moduleID }">
<input type="hidden" id="ssetmcustomerid" name="toMailPo.ssetmcustomerid" value="${toMailPo.ssetmcustomerid }">
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
                          <TD width="8%" height="26" class="table_body">配镜单号</TD>
					  	  <TD width="23%" class="table_none"><li class="horizontal_onlyRight"><input type="text" class="text_input160" readonly="readonly" style="background-color: #E0E0E0" id="ssetmlinksalesid" name="toMailPo.ssetmlinksalesid" value="${toMailPo.ssetmlinksalesid }"/></li>
					  	  
					  	  <li class="horizontal_onlyRight">
					  		<img src="${ctx }/img/newbtn/btn_change_0.png" btn=btn title="选择" onclick="searchSalesOpen();"></li>
					  		<label style="color:red;">&nbsp;*&nbsp;</label> 
					  	  </TD>
					  	  <TD width="8%" height="26" class="table_body">会员卡号</TD>
					  	  <TD width="23%" class="table_none"><input type="text" readonly="readonly" class="text_input160" style="background-color: #E0E0E0" id="ssetmmemberid" name="toMailPo.ssetmmemberid" value="${toMailPo.ssetmmemberid }"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
					  	  <TD width="8%" height="26" class="table_body">顾客姓名</TD>
                    	  <TD class="table_none"><input class="text_input160" type="text"  id="ssetmcustomername" name="toMailPo.ssetmcustomername" value="${toMailPo.ssetmcustomername }" maxlength="16" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '顾客姓名不能为空!'}]"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
					  	</TR>
                    	<TR>
                    	  <TD width="8%" height="26" class="table_body">联系人</TD>
                    	  <TD class="table_none"><input class="text_input160" type="text"  id="ssetmlinkman" name="toMailPo.ssetmlinkman" value="${toMailPo.ssetmlinkman}" maxlength="16" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '联系人不能为空!'}]"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
                    	  <TD height="26" class="table_body">顾客区号</TD>
                    	  <TD class="table_none">                   	  
                    	    <input class="text_input160" type="text"  id="ssetmareacode" name="toMailPo.ssetmareacode" value="${toMailPo.ssetmareacode}" maxlength="5" />
                    	  </TD>
                    	  <TD height="26" class="table_body">顾客电话</TD>
                    	  <TD class="table_none">                   	  
                    	    <input class="text_input160" type="text"  id="ssetmcustomerphone" name="toMailPo.ssetmcustomerphone" value="${toMailPo.ssetmcustomerphone }" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '顾客电话不能为空!'},{'Type' : Type.String, 'Formula' :  Formula.PhoneORNULL, 'Message' : '顾客电话格式错误！'}]"/>
                    	  <label style="color:red;">&nbsp;*&nbsp;</label> 
                    	  </TD>
                    	</TR>
                    	<TR>
                    	  <TD height="26" class="table_body">邮寄单</TD>
                    	  <TD class="table_none" colspan="5">
                    	   <select clean=clean id="ssetmtomaillistid" name="toMailPo.ssetmtomaillistid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '邮寄单不能为空!'}]">
      		                 	<option value="">----请选择----</option>
				               	  <s:iterator value="mailingList">
                    	           <OPTION value="${btmlid}" ${mailingListPo.btmlid!= btmlid  ? '' : 'selected="selected"' } >${btmlname}</OPTION>
                    	          </s:iterator>
      	                    </select>
      	                    <label style="color:red;">&nbsp;*&nbsp;</label> 
                    	  </TD>
                  	  </TR>
                    	<TR  style="display:none" id="showtr1">
                    	  <TD height="26" class="table_body">快递公司</TD>
                    	  <TD class="table_none"><input class="text_input160" type="text"  id="ssetmmailcompanyname" name="toMailPo.ssetmmailcompanyname" value="${toMailPo.ssetmmailcompanyname }" maxlength="20"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
                    	  <TD height="26" class="table_body">快递单号</TD>
                    	  <TD class="table_none">
                    	  <input id="ssetmmailid" name="toMailPo.ssetmmailid" type="text" class="text_input160" value="${toMailPo.ssetmmailid }" maxlength="30"/><label style="color:red;">&nbsp;*&nbsp;</label> </TD>
                    	  <TD height="26" class="table_body">邮寄时间</TD>
                    	  <TD class="table_none">
                   			   <li class="horizontal_onlyRight">         
                   				<input class="text_input120"
				               id="ssetmsenddate"
						       name="toMailPo.ssetmsenddate" value="${toMailPo.ssetmsenddate }"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d'})" 
						       readonly="readonly" />
						       </li>
						       <li class="horizontal_onlyRight">
					  			<img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onclick="getTadayDate()">
					  		   </li>
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
                  	  
                  	  <c:if test="${systemParameterPo.fspisbaojiaflag == '2'}">          						  
                         <TR>
                    	  <TD height="26" class="table_body">保价</TD>
                    	  <TD class="table_none" colspan="5"><span id="supportvalue">0.00</span>&nbsp;元
                    	    <input type="hidden" id="ssetmissupport" name="toMailPo.ssetmissupport" value="" readonly="readonly"/>
                    	    <input type="hidden" id="ssetmsupportvalue" name="toMailPo.ssetmsupportvalue" value="" readonly="readonly"/>
                    	  </TD>
                  	    </TR>	
                      </c:if>                  	  
                  	  
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

