<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顾客回访管理</title>
</head>
<script> 
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
		if($("#title1").is(":visible"))
        {
        	$("input:text")[0].focus();
        }
	});

	function search(optometryID,optometryBasicID,flag){
		if(checkForm(document.all.customerInfoForm)){ 
			$("img").removeAttr("onclick");
			customerInfoForm.action = "optometryCaseSel.action";
			customerInfoForm.submit();
			showLoadingBar();
		}
	}
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerInfoForm.action=link;
	  	customerInfoForm.submit();
		showLoadingBar();
	}	
 
 
	function clean(){
		$('#sopoydiffusepupil').val('');
		$('#sopoyballglassodmax').val('');
		$('#sopoyballglassodmin').val('');
		$('#sopoypostglassodmax').val('');
		$('#sopoypostglassodmin').val('');
		$('#sopoyfarworth').val('');
		$('#sopoyacamin').val('');
		$('#sopoyfarhetelevelmin').val('');
		$('#sopoyfarHeteuprightnessmin').val('');
		$('#sopoyclosehetelevelmin').val('');
		$('#sopoycloseheteuprightnessmin').val('');
		$('#sopoyacamax').val('');
		$('#sopoyfarhetelevelmax').val('');
		$('#sopoyfarHeteuprightnessmax').val('');
		$('#sopoyclosehetelevelmax').val('');
		$('#sopoycloseheteuprightnessmax').val('');
		
		$('#sopoybccmin').val('');
		$('#sopoypramin').val('');
		$('#sopoynramin').val('');
		$('#sopoybccmax').val('');
		$('#sopoypramax').val('');
		$('#sopoynramax').val('');
		$('#sopoybegindate').val('');
		$('#sopoyenddate').val('');
		$('#sopoymemberid').val('');
		$('#sopoyname').val('');
		$('#departmentid').val('');
		$('#sopoypersonid').val('');
		
	}	
	function permissionMessage(){
       alert('您无此操作权限');
	}
	
	function details(optometryID,customerID,flag,chuyanfuyan){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initRefractiveSelect.action?optometryID="+optometryID+"&customerID="+customerID+"&moduleID="+'${moduleID}',970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initRefractiveSelect.action?optometryID="+optometryID+"&customerID="+customerID+"&moduleID="+'${moduleID}',screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【验光信息详细】";
	}
 
 	/** 
     * 时间对象的格式化
     */  
    Date.prototype.format = function(format) {  
        /* 
         * eg:format="YYYY-MM-dd hh:mm:ss"; 
         */  
        var o = {  
            "M+" :this.getMonth() + 1, // month  
            "d+" :this.getDate(), // day  
            "h+" :this.getHours(), // hour  
            "m+" :this.getMinutes(), // minute  
            "s+" :this.getSeconds(), // second  
            "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter  
            "S" :this.getMilliseconds()  
        // millisecond  
        }  
      
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
      
        for ( var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
    
    function today(){
		var now = new Date().format("yyyy-MM-dd");  //设置你想要的格式
		
		document.getElementById('sopoybegindate').value = now;
		document.getElementById('sopoyenddate').value = now;		
	}
    function checkNumberType(thiz){
		if($(thiz).val()!=''){
			if(parseFloat($(thiz).val())>0){
				var str='+'+parseFloat($(thiz).val().replace('+','')).toFixed(2);
				$(thiz).val(str);
			}else if(parseFloat($(thiz).val())<0){
				$(thiz).val(parseFloat($(thiz).val()).toFixed(2));
			}else if(parseFloat($(thiz).val())==0){
				$(thiz).val('0.00');
			}
		}
	}
	
	function trim(str){
　　      return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }
</script>
<body>
<form name="customerInfoForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="S0606">
 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光管理</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：验光记录查询</TD>
            <td align="right" valign="bottom">&nbsp;
            	<img src="${ctx }/img/newbtn/btn_isshowsearch_0.png" btn=btn title="显隐查询条件" onClick="JavaScript:searchContentShowOrHidden('title0,title1,title2');changeShowOrHidden();" />
            </td>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><table></table></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx}/img/pic/tab_bg.gif>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryCondition.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
							<table width="100%"  border=0 align=center cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">顾客卡号</TD>
			               <TD class="table_none" width="22%"><input type="text" class="text_input160"  maxlength="20" id="sopoymemberid" name="sopoymemberid" value="${sopoymemberid }"/></TD>
			               <TD width="8%" height="26" class="table_body">顾客姓名</TD>
			               <TD class="table_none" width="23%"><input type="text" class="text_input160" maxlength="20" id="sopoyname" name="sopoyname" value="${sopoyname }"/></TD>
			               <TD width="10%" height="26" class="table_body">验光时间</TD>
			               <TD class="table_none">
			               <li class="horizontal_onlyRight">
                            <input id="sopoybegindate"
					       name="sopoybegindate" 
					       type="text" class="text_input100" 
					       onFocus="WdatePicker({readOnly:true, maxDate:'#F{$dp.$D(\'sopoyenddate\')}'})"
					       value="${sopoybegindate }" /> 至 
					       <input id="sopoyenddate"
					       name="sopoyenddate" 
					       type="text" class="text_input100" 
					       onfocus="WdatePicker({readOnly:true, minDate:'#F{$dp.$D(\'sopoybegindate\')}'})" 
					        value="${sopoyenddate }" />
					       </li>
					       <li class="horizontal_onlyRight">
					  	   <img src="${ctx }/img/newbtn/btn_today_0.png" btn=btn title="今天" onClick="today()"></li>
					      </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">验光师工号</TD>
			               <TD class="table_none"><input type="text" maxlength="20" class="text_input160" id="sopoypersonid" name="sopoypersonid" value="${sopoypersonid }"/></TD>
						   <TD height="26" class="table_body">验光类型</TD>
			               <TD class="table_none"><select id="sopoydiffusepupil" name="sopoydiffusepupil">
			                 <option value="">----请选择----</option>
			                 <OPTION value="1" ${sopoydiffusepupil != '1' ? '':'selected=selected'}>快速散瞳</OPTION>
			                 <OPTION value="2" ${sopoydiffusepupil != '2' ? '':'selected=selected'}>慢速散瞳</OPTION>
                             <OPTION value="3" ${sopoydiffusepupil != '3' ? '':'selected=selected'}>显然验光</OPTION>
			                 <OPTION value="4" ${sopoydiffusepupil != '4' ? '':'selected=selected'}>复验</OPTION>
			                 </select></TD>
			               <TD width="60" height="26" class="table_body">部门</TD>
			               <TD class="table_none">
                           <select id="departmentid" name="departmentID">
      		                 	<option value="">----请选择----</option>
                             	<c:if test="${not empty(departmentsList)}">
				               	  <s:iterator value="departmentsList">
                    	           <OPTION value="${bdpdepartmentid}" ${requestScope.departmentID!= bdpdepartmentid  ? '' : 'selected="selected"' } >(${bdpdepartmentid})${bdpdepartmentname}</OPTION>
                    	          </s:iterator>
                    	        </c:if> 
      	                   </select>
			               </TD>
                        </TR>
                         <TR>
						   <TD height="26" class="table_body">球镜区间 </TD>
			               <TD class="table_none">
			               	<input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" id="sopoyballglassodmin" name="sopoyballglassodmin" value="${sopoyballglassodmin }" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '球镜填写有误，请重新填写！'}]">
			               	-
			               	<input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" id="sopoyballglassodmax" name="sopoyballglassodmax" value="${sopoyballglassodmax }" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '球镜填写有误，请重新填写！'}]"></TD>
			               <TD height="26" class="table_body">柱镜区间 </TD>
			               <TD class="table_none">
			               	<input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" id="sopoypostglassodmin" name="sopoypostglassodmin" value="${sopoypostglassodmin }" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '柱镜填写有误，请重新填写！'}]">
			               	-
			               	<input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" id="sopoypostglassodmax" name="sopoypostglassodmax" value="${sopoypostglassodmax }" validate="[{'Type' : Type.String, 'Formula' : Formula.SphCylOrNull, 'Message' : '柱镜填写有误，请重新填写！'}]"></TD>
						   <TD height="26" class="table_body">WORTH 4 DOT </TD>
			               <TD class="table_none"><select id="sopoyfarworth" name="sopoyfarworth">
			                 <option value="">----请选择----</option>
			                 <OPTION value="2dots" ${sopoyfarworth != '2dots' ? '':'selected=selected' }>2dots</OPTION>
			                 <OPTION value="3dots" ${sopoyfarworth != '3dots' ? '':'selected=selected' }>3dots</OPTION>
			                 <OPTION value="4dots" ${sopoyfarworth != '4dots' ? '':'selected=selected' }>4dots</OPTION>
			                 <OPTION value="5dots" ${sopoyfarworth != '5dots' ? '':'selected=selected' }>5dots</OPTION>
			                 </select></TD>
                        </TR>						
                         <TR>
                           <TD height="26" class="table_body">AC/A</TD>
			               <TD class="table_none">
			               	<input type="text" class="text_input80" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoyacamin" name="sopoyacamin" value="${sopoyacamin }"/>
			               	-
			                <input type="text" class="text_input80" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoyacamax" name="sopoyacamax" value="${sopoyacamax }"/>
			               </TD>
						   <TD height="26" class="table_body">远隐斜：水平</TD>
			               <TD class="table_none">
                             <input type="text" class="text_input80" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoyfarhetelevelmin" name="sopoyfarhetelevelmin" value="${sopoyfarhetelevelmin }"/>
                             - 
                             <input type="text" class="text_input80" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoyfarhetelevelmax" name="sopoyfarhetelevelmax" value="${sopoyfarhetelevelmax }"/>                        
                           </TD>
			               <TD height="26" class="table_body">远隐斜：垂直</TD>
			               <TD class="table_none">
			               	<input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoyfarHeteuprightnessmin" name="sopoyfarHeteuprightnessmin" value="${sopoyfarHeteuprightnessmin }"/>			               
			                -
			                <input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoyfarHeteuprightnessmax" name="sopoyfarHeteuprightnessmax" value="${sopoyfarHeteuprightnessmax }"/>
			               </TD>
                        </TR>
                        <TR>
						   <TD height="26" class="table_body">近隐斜：水平</TD>
			               <TD class="table_none">
                             <input type="text" maxlength="20" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" class="text_input80" id="sopoyclosehetelevelmin" name="sopoyclosehetelevelmin" value="${sopoyclosehetelevelmin }"/>                           
                             -
                             <input type="text" maxlength="20" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" class="text_input80" id="sopoyclosehetelevelmax" name="sopoyclosehetelevelmax" value="${sopoyclosehetelevelmax }"/>
                           </TD>
			               <TD height="26" class="table_body">近隐斜：垂直</TD>
			               <TD class="table_none">
			               	<input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoycloseheteuprightnessmin" name="sopoycloseheteuprightnessmin" value="${sopoycloseheteuprightnessmin }"/>		
			               	-
			               	<input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoycloseheteuprightnessmax" name="sopoycloseheteuprightnessmax" value="${sopoycloseheteuprightnessmax }"/>	               
			               </TD>
						   <TD height="26" class="table_body">BCC</TD>
			               <TD class="table_none">
			               <input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoybccmin" name="sopoybccmin" value="${sopoybccmin }"/>		
			               	-
			               <input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoybccmax" name="sopoybccmax" value="${sopoybccmax }"/>	               
                           </TD>
			               
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">NRA</TD>
			               <TD class="table_none">
			               <input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoynramin" name="sopoynramin" value="${sopoynramin }"/>		
			               	-
			               <input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoynramax" name="sopoynramax" value="${sopoynramax }"/>	 
                           </TD>
						   <TD height="26" class="table_body">PRA</TD>
			               <TD class="table_none">
			               <input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoypramin" name="sopoypramin" value="${sopoypramin }"/>		
			               	-
			               <input class="text_input80" type="text" onKeyUp="value=value.replace(/[^(-?\d+)(\.\d+)?]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" maxlength="20" id="sopoypramax" name="sopoypramax" value="${sopoypramax }"/>
							</TD>
							<TD height="26" class="table_body">双眼视功能检查</TD>
			                <TD class="table_none">
                          		<select moveorder="44" id="doublecheck" name="doublecheck" mysel="mysel">
									<option value=""  ${doublecheck == '' ? 'selected="selected"':'' }>----请选择----</option>
									<option value="1" ${doublecheck == '1' ? 'selected="selected"':'' }>已检查</option>
									<option value="0" ${doublecheck == '0' ? 'selected="selected"':'' }>未检查</option>
								</select>                           
							</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    
                    <table id="title2" cellspacing="2">
						<tr height="10">
							<td>
								<img src="${ctx }/img/newbtn/btn_search_0.png" btn=btn id="submitButton" title='查询' onclick="search();">
								<img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title="清空" onclick="clean();">
							</td>
						</tr>
					</table>
					<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
					</script>  
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						                          
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					
					<c:if test="${optometryPos != null}"> 
					
					
					<table width="100%"   border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                              <TBODY>
                                <TR>
                                  <TD width="5%"><div><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20"></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                     </TABLE>
 
					  <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder">
                      <TBODY>
                      
                        <TR class=table_title align=middle>
                          <TH width="4%" scope=col>操作</TH>
                          <TH width="15%" height="26" scope=col>验光病历号</TH>
						  <TH width="15%" scope=col>门店</TH>						
						  <TH width="10%" scope=col>顾客姓名</TH>
						  <TH width="10%" scope=col>联系电话</TH>
                          						  <TH width="10%" scope=col>验光师</TH>
						  <TH width="15%" scope=col>验光时间</TH>
						  </TR>
						 	<c:forEach var="po" items="${optometryPos}">
		                        <TR class="row" onMouseOver="mover(this,'#a2c1eb')" onMouseOut="mout(this,'#cadee8')">
		                          <TD>
	                       			<img src="${ctx }/img/newbtn/search_0.png" btn=btn title='详细' onClick="details('${po.sopoyoptometryid }','${po.sopoycustomerid }','')">
		                          </TD>
		                          <TD height="26">${po.sopoyoptometryid }</TD>
		                          <TD>${po.sopoydepartmentname }</TD>
								  <td>${po.sopoyname }</td>
		                          <TD>${po.sopoyphone}</TD>
	                              <TD>${po.sopoypersonname}</TD>
		                          <TD>${fn:substring(po.sopoytime,0,16)}</TD>
		                        </TR>
                         	</c:forEach>
                         	
                      </TBODY>
                    </TABLE>
                    
                    <!-- BEGIN 分页-->
						<div id="dividePage" align="center">        
							<jsp:include page="/WEB-INF/inc/Pagination.jsp" />
						</div>
					<!-- END 分页 -->
	               </c:if>
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
  

