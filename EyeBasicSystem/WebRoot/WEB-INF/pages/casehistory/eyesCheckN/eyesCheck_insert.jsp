<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>眼部检查管理</title>
<script type='text/javascript' src='${ctx }/js/HISjs/HIS.js'></script>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		if('${systemParameterPo.fsphisflag}' == '0' || '${person.bdplinkhisflag}' == '0'){
			document.getElementById('smecimemberid').focus(); 
        }
		
		var tt='${eyesCheckPo.sopecfruit}';
		if( tt== '1' ){
			$("div[id=illdiv]").show(); 
		}else{
			$("div[id=illdiv]").hide();
		}
		
		
		var countperfrom = '${eyesCheckPo.sopecills}'.split(',');
		for(var i=0; i<countperfrom.length; i++){
			$('[id=sopecills][value='+countperfrom[i].trim()+']').attr("checked","checked");
		}
	});
window.onload=function(){
		if('${isopt}'=='1'&&('${person.bdplinkhisflag}'=='1')&&('${systemParameterPo.fsphisflag}' == '2')){
			if('${requestScope.sopoytreatmentnum}'==''){
			    alert('此卡持有人未挂号！');
			}
	 	}
		if('${isGO}'=='1' && $('#smecimemberid').val() == ''){
	    	$('img[his=his]').trigger("click");
		}
}
	function save(){
	if(checkForm(document.all.mydriasisForm)){    
        $("img").removeAttr("onclick");
			mydriasisForm.action = "insertEyesCheckN.action";
			mydriasisForm.submit();
		}
	}
	
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员信息】";	
	}
	
	  /*   单个汉字的宽度,根据你的字体大小自行设定   */   
	  var   wordWidth   =   '14';   
	  function   setWidth()   
	  {   
		  obj   =   event.srcElement;   
		  obj.style.width   =   obj.value.replace(/[^\x00-\xff]/g,"**").length*wordWidth/2+5;   
	  }
	  function eyesChargePut(){
		showPopWin("","initEyesChargePutInsert.action",700,500,'',null,true);
		selectHidden();
	}


	/**
	 *查看
	 */
	function selCustomerInfo(){
        if ('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
            return;
        }
        
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
   }


    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");   
		mydriasisForm.action = "selEyesCheckForCustomerN.action";
		mydriasisForm.submit();
	}
	
	function isShowIll(){
		if($('input[id=isCheckHealth]:checked').val() == '0'){
			$("div[id=illdiv]").hide(); 
		}else{
			$("div[id=illdiv]").show();
		}
		$('input[id=sopecills]').removeAttr('checked');
	}
	
function selectCust(flag){
    if(flag){
	    $("img").removeAttr("onclick");   
		mydriasisForm.action = "selEyesCheckForCustomerN.action";
		mydriasisForm.submit();
    }
}
function selectCustomer(){
    if('${person.bdplinkhisflag}' == '1' && '${systemParameterPo.fsphisflag}' == '2'){
            alert('此门店已经连接HIS系统，不能查询会员!');
         return ;
	}
	if(document.getElementById('smecimemberid').value.trim() != ''){
		if(event.keyCode == 13){
			$("img").removeAttr("onclick");   
			mydriasisForm.action = "selEyesCheckForCustomerN.action";
			mydriasisForm.submit();
		}
	}
}	
</script>
<jsp:include page="/hisCusWin_js.jsp" flush="true" />
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" id="sopoytreatmentnum" name="eyesCheckPo.sopoytreatmentnum" value="${requestScope.sopoytreatmentnum}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光管理</TD>
                    <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：眼部健康检查 
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
					<TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">眼部检查新增</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initEyesCheckSelN.action;'" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">眼部检查查询</TD>
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
					
					</TR>
					
					
					</TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
						  <fieldset>
							<legend><font size="2">顾客资料</font></legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td align="center">
								  <table width="99%" class="Privateborder privateTable" border="0" cellpadding="1" cellspacing="1">
									  <tr>
										<td class="table_body">
										 <li class="horizontal"> 顾客卡号：
										  <input onpropertychange="setWidth()" style="text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" id="smecimemberid" name="smecimemberid" class="text_input100" 
										  value="${customerInfoPo.smecimemberid}" onkeydown="selectCustomer();"${ systemParameterPo.fsphisflag == '2' && person.bdplinkhisflag == '1' ? 'readonly=readonly':'' } validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
										  <input name="eyesCheckPo.sopeccustomerid" type="hidden" value="${customerInfoPo.smecicustomerid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
										  &nbsp;&nbsp;</li>
										  <li class="horizontal">
										    <img src="${ctx }/img/newbtn/btn_hydq_0.png" btn=btn his=his title='查找' >
							                <img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
							              </li> 
						 
										 <li class="horizontal">姓名：
										  <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smeciname" value="${customerInfoPo.smeciname}" class="text_input80" readOnly="readOnly">
										  &nbsp;&nbsp;</li>  <li class="horizontal"> 性别：
											<c:if test="${customerInfoPo.smecisex==0}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="男" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                                <c:if test="${customerInfoPo.smecisex==1}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="女" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                                <c:if test="${empty(customerInfoPo.smecisex)}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                              &nbsp;&nbsp;</li>  <li class="horizontal"> 年龄：
										   <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecibirthday" value="${customerInfoPo.fmmage}" class="text_input100" readOnly="readOnly">
										   <c:if test="${not empty(customerInfoPo.smecicustomerid)}">								  
										      &nbsp;</li>  <li class="horizontal">
										      <img btn=btn src="${ctx }/img/newbtn/btn_details_0.png" title='详情' onClick="javascript:details('${customerInfoPo.smecicustomerid}')">
										  </c:if>	</li>							
										</td>
									  </tr>
								  </table>
								</td>
							  </tr>
						  </table>
						</fieldset>	
						
						<br />		
						<fieldset>
							<legend>检查项目</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE width="99%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="3%" height="30" class="table_body">&nbsp;</TD>
                                      <TD width="17%" class="table_body"><div align="center">外眼</div></TD>
                                      <TD width="22%" class="table_body"><div align="center">结膜充血</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">结膜</div></TD>
                                      <TD width="21%" class="table_body"><div align="center">角膜</div></TD>
                                      <TD width="20%" class="table_body"><div align="center">泪液</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">OD</div></TD>
                                      <TD class="table_none"><div align="center">
                                      
                                        <select name="eyesCheckPo.sopecsurfaceeyeod" style="width:100%">
                                          <option value="" selected></option>
                                           <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='1'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecsurfaceeyeod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>                                                                  
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccongestiveod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='2'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccongestiveod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>   
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecnippleod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='3'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecnippleod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccornealod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='4'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccornealod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopectearosod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='5'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopectearosod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">OS</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecsurfaceeyeos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='1'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecsurfaceeyeos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccongestiveos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='2'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccongestiveos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecnippleos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='3'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecnippleos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccornealos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='4'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccornealos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopectearosos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='5'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopectearosos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
							    <br>
								<TABLE width="99%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="2%" height="30" class="table_body">&nbsp;</TD>
                                      <TD width="11%" class="table_body"><div align="center">前房</div></TD>
                                      <TD width="10%" class="table_body"><div align="center">虹膜</div></TD>
                                      <TD width="16%" class="table_body"><div align="center">晶体</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">眼底</div></TD>
                                      <TD width="10%" class="table_body"><div align="center">眼球运动</div></TD>
                                      <TD width="14%" class="table_body"><div align="center">色觉</div></TD>
                                      <TD colspan="2" class="table_body"><div align="center">眼压</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">OD</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopechyphemaod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='6'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopechyphemaod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecirisod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='7'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecirisod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccrystalod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='8'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccrystalod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecfundusod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='9'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecfundusod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                          <select name="eyesCheckPo.sopeccampaignod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='10'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccampaignod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none">
	                                      <select name="eyesCheckPo.sopeccolorod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='11'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccolorod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                      <TD width="10%" class="table_none"><input name="eyesCheckPo.sopeciopod" class="text_input80" value="${eyesCheckPo.sopeciopod }" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [21]}, 'Message' : '不能大于10字！'}]"></TD>
                                      <TD width="10%" class="table_none">
	                                      <select name="eyesCheckPo.sopeciopselod" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='12'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeciopselod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">OS</div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopechyphemaos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='6'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopechyphemaos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopecirisos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='7'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecirisos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none">
                                      <div align="center">
                                        <select name="eyesCheckPo.sopeccrystalos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='8'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccrystalos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                       </select>	                                      
                                      </div>
                                      </TD>
                                      <TD class="table_none"><div align="center">
                                          <select name="eyesCheckPo.sopecfundusos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='9'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecfundusos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <select name="eyesCheckPo.sopeccampaignos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='10'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccampaignos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </div></TD>
                                      <TD class="table_none">
	                                      <select name="eyesCheckPo.sopeccoloros" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='11'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeccoloros == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                      <TD width="10%" class="table_none"><input name="eyesCheckPo.sopeciopos" class="text_input80" value="${eyesCheckPo.sopeciopos }" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [21]}, 'Message' : '不能大于10字！'}]"></TD>
                                      <TD width="10%" class="table_none">
	                                      <select name="eyesCheckPo.sopeciopselos" style="width:100%">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='12'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeciopselos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
							<TABLE width="99%" border=0 align=center cellPadding=3 cellSpacing=1 class="privateBorder privateTable">
                                  <TBODY>
                                    <TR>
                                      <TD width="10%" height="30" class="table_body">是否散瞳</TD>
                                      <TD width="23%" class="table_none" valign="top">
                                      	<input type="radio" id="sopecismydriasis" name="eyesCheckPo.sopecismydriasis" value="1" checked="checked" ${eyesCheckPo.sopecismydriasis != '1' ? '' : 'checked="checked"'}>是
                                      	<input type="radio" id="sopecismydriasis" name="eyesCheckPo.sopecismydriasis" value="0" ${eyesCheckPo.sopecismydriasis != '0' ? '' : 'checked="checked"'}>否
                                      </TD>
									  <TD width="10%" height="30" class="table_body">散瞳用药</TD>
                                      <TD width="23%" class="table_none" valign="top">
                                      	<select name="eyesCheckPo.sopecanaesthetic" id="sopecanaesthetic" >
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='13'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecanaesthetic == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
									  <TD width="10%" height="30" class="table_body">眼部健康诊断</TD>
                                      <TD width="23%" class="table_none">
                                      <input type="radio" onClick="isShowIll();" value="0" checked="checked" ${eyesCheckPo.sopecfruit != '0' ? '' : 'checked="checked"'} id="isCheckHealth" name="eyesCheckPo.sopecfruit">正常
                                      <input type="radio" onClick="isShowIll();" value="1" ${eyesCheckPo.sopecfruit != '1' ? '' : 'checked="checked"'} id="isCheckHealth" name="eyesCheckPo.sopecfruit">异常
                                      <div id="illdiv" style="display: none;">
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='60'}">
		                                      	<input id="sopecills" name="eyesCheckPo.sopecills" type="checkbox" value="${optionParamPoTmp.fopparamid }"><span name=2>${optionParamPoTmp.fopparamname}</span>
		                                      </c:if>	                                      	
	                                      </c:forEach>                                      
									  </div>
									  </TD>
									</TR>
								</TBODY>
							</TABLE>
							<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorder">
                                  <TBODY>
                                    <TR>
                                      <TD width="20%" height="30" class="table_body">眼病史</TD>
                                      <TD width="80%" class="table_none">1、
                                        <select id="sopecillhistory1" name="eyesCheckPo.sopecillhistory1">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='14'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecillhistory1 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      &nbsp;&nbsp;2、
                                      <select id="sopecillhistory2" name="eyesCheckPo.sopecillhistory2" value="">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='14'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecillhistory2 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      &nbsp;&nbsp;3、
                                      <select id="sopecillhistory3" name="eyesCheckPo.sopecillhistory3">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='14'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecillhistory3 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">遗传史</TD>
                                      <TD class="table_none">
                                        <select id="sopecheredityhistory1" name="eyesCheckPo.sopecheredityhistory1">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='15'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecheredityhistory1 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">过敏史</TD>
                                      <TD class="table_none">
	                                      <select id="sopecallergyhistory1" name="eyesCheckPo.sopecallergyhistory1">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='16'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopecallergyhistory1 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
						</fieldset>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	  <input type="hidden" name="moduleID" value="${requestScope.moduleID}">
                          	  <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
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