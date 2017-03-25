<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/select_many_checked.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>眼部检查管理</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});

		document.getElementById('smecimemberid').focus();	
		if($('input[id=isCheckHealth]:checked').val() == '0'){
			$("div[id=illdivtype]").hide();
			$("div[id=illdiv1]").hide();
			$("div[id=illdiv2]").hide();
		}else{
			$("div[id=illdivtype]").show();
			$("div[id=illdiv1]").hide();
			$("div[id=illdiv2]").hide();
		}
	});

	function save(){
		getSelectValue('sopecsurfaceeyeod','sopecsurfaceeyeodHidden');	//外眼-右
		getSelectValue('sopeccongestiveod','sopeccongestiveodHidden');	//结膜充血-右
		getSelectValue('sopecnippleod','sopecnippleodHidden');	//结膜-右
		getSelectValue('sopeccornealod','sopeccornealodHidden');	//角膜-右
		getSelectValue('sopecapparatusod','sopecapparatusodHidden');	//泪器-右
		getSelectValue('sopecsurfaceeyeos','sopecsurfaceeyeosHidden');	//外眼-左
		getSelectValue('sopeccongestiveos','sopeccongestiveosHidden');	//结膜充血-左
		getSelectValue('sopecnippleos','sopecnippleosHidden');	//结膜-左		
		getSelectValue('sopeccornealos','sopeccornealosHidden');	//角膜-左
		getSelectValue('sopecapparatusos','sopecapparatusosHidden');	//泪器-左	
		getSelectValue('sopechyphemaod','sopechyphemaodHidden');	//前房-右
		getSelectValue('sopecirisod','sopecirisodHidden');	//虹膜-右
		getSelectValue('sopeccrystalod','sopeccrystalodHidden');	//晶体-右	
		getSelectValue('sopeccolorod','sopeccolorodHidden');	//色觉-右
		getSelectValue('sopechyphemaos','sopechyphemaosHidden');	//前房-左
		getSelectValue('sopecirisos','sopecirisosHidden');	//虹膜-左	
		getSelectValue('sopeccrystalos','sopeccrystalosHidden');	//晶体-左
		getSelectValue('sopeccoloros','sopeccolorosHidden');	//色觉-左
		getSelectValue('sopecillhistory1','sopecillhistory1Hidden');	//眼病史-1
		getSelectValue('sopecheredityhistory1','sopecheredityhistory1Hidden');	//遗传史
		getSelectValue('sopipglasstypes','sopipglasstypesHidden');	//框架眼镜
		getSelectValue('sopiptouchglass','sopiptouchglassHidden');	//角膜接触镜
		getSelectValue('sopiptraintypes','sopiptraintypesHidden');	//视觉训练
		
		if(checkForm(document.all.mydriasisForm)){    
        	$("img").removeAttr("onclick");
			mydriasisForm.action = "insertEyesCheckHydsy.action";
			mydriasisForm.submit();
		}
	}
	function getCustomer(obj){ 
	    if(event.keyCode==13){  
		    if ($.trim(obj.value) == ''){
                alert('请输入会员卡号!');
                return;
			}
	    	$("img").removeAttr("onclick");   
			mydriasisForm.action = "selEyesCheckForCustomerHydsy.action";
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
		mydriasisForm.action = "selEyesCheckForCustomerHydsy.action";
		mydriasisForm.submit();
	}
	
	function isShowIll(){	
		$("[yc=yc]").val('');
		
		if($('input[id=isCheckHealth]:checked').val() == '0'){
			$("div[id=illdivtype]").hide();
			$("div[id=illdiv1]").hide();
			$("div[id=illdiv2]").hide();
		}else{
			$("div[id=illdivtype]").show();
			$("div[id=illdiv1]").hide();
			$("div[id=illdiv2]").hide();
		}
		
	}
	
	function allnormal(){
		resetSelectList('sopecsurfaceeyeod');	//外眼-右
		resetSelectList('sopeccongestiveod');	//结膜充血-右
		resetSelectList('sopecnippleod');	//结膜-右
		resetSelectList('sopeccornealod');	//角膜-右
		resetSelectList('sopecapparatusod');	//泪器-右
		resetSelectList('sopecsurfaceeyeos');	//外眼-左
		resetSelectList('sopeccongestiveos');	//结膜充血-左
		resetSelectList('sopecnippleos');	//结膜-左		
		resetSelectList('sopeccornealos');	//角膜-左
		resetSelectList('sopecapparatusos');	//泪器-左	
		resetSelectList('sopechyphemaod');	//前房-右
		resetSelectList('sopecirisod');	//虹膜-右
		resetSelectList('sopeccrystalod');	//晶体-右		
		resetSelectList('sopeccolorod');	//色觉-右
		resetSelectList('sopechyphemaos');	//前房-左	
		resetSelectList('sopecirisos');	//虹膜-左
		resetSelectList('sopeccrystalos');	//晶体-左
		resetSelectList('sopeccoloros');	//色觉-左
		resetSelectList('sopecillhistory1');	//眼病史-1
		resetSelectList('sopecheredityhistory1');	//遗传史
		resetSelectList('sopipglasstypes');	//框架眼镜
		resetSelectList('sopiptouchglass');	//角膜接触镜
		resetSelectList('sopiptraintypes');	//视觉训练

		$('input[type=checkbox][content=正常]').each(function(){
			$(this).attr('checked',true);
			$('[id='+$(this).attr("id")+']').find("span").html('正常');
	    });
    }


    function djs(id){
        var url = "";
        if (typeof(id) != 'undefined' && id != ''){
            url = "&smecimemberid=" + id;
        }
    	window.location.href = 'selectGlassesHistoryEyesCheck.action?moduleID=${moduleID}' + url;
    }
    
    function yjcheck(id){
        var url = "";
        if (typeof(id) != 'undefined' && id != ''){
            url = "&smecimemberid=" + id;
        }
    	window.location.href = 'selectYjCheckEyesCheck.action?moduleID=${moduleID}' + url;
    }    

    function changeIlltype(objValue){
		$("#sopecillsConent").val('');
    	switch(objValue)
    	{
    	case '1':
    		$("div[id=illdiv1]").show();
    		$("div[id=illdiv2]").hide();
    	  break;
    	case '2':
    		$("div[id=illdiv1]").hide();
    		$("div[id=illdiv2]").show();
    	  break;
    	case '3':
    		$("div[id=illdiv1]").hide();
    		$("div[id=illdiv2]").show();
    	  break;
    	case '4':
    		$("div[id=illdiv1]").hide();
    		$("div[id=illdiv2]").show();
    	  break;    	  
    	default:
    		$("div[id=illdiv1]").hide();
			$("div[id=illdiv2]").hide();
    	}

    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
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
                      onclick="djs('${customerInfoPo.smecimemberid}');" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">戴镜史</TD>
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="yjcheck('${customerInfoPo.smecimemberid}');" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">眼肌检查</TD>
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>                    
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initEyesCheckSelHydsy.action?smecimemberid=${customerInfoPo.smecimemberid}'" 
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
										  <input onpropertychange="setWidth()" style="text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" id="smecimemberid" name="smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid}" onkeydown="getCustomer(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
										  <input name="eyesCheckPo.sopeccustomerid" type="hidden" value="${customerInfoPo.smecicustomerid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
										  &nbsp;&nbsp;</li>
										  <li class="horizontal">
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
						<legend>
							主诉
						</legend>
							<table width="99%" border=0 align=center cellpadding=1	cellspacing=1 class="privateTable privateBorder">
								<tbody>
									<tr bgcolor="#CADEE8" height="26px">
										<TD class="PrivateBorderBlue" width="10%">
										<div align="center">主诉</div>
										</TD>
										<TD>
											<textarea  id="soprcustomersay" name="eyesCheckPo.soprcustomersay" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '主诉不能大于100字！'}]" style="width:100%" cols="80" rows="7">${fn:trim(eyesCheckPo.soprcustomersay) }</textarea>
										</TD>
									</tr>
								</tbody>
							</table>
						</fieldset>
						<br />
						<table width="99%" border=0 align=center cellpadding=0	cellspacing=0>
								<tbody>
									<tr height="26px">
										<TD align="right">
											<img src="${ctx}/img/newbtn/btn_normal_0.png" btn=btn title='正常' onClick="allnormal()">	
										</TD>
									</tr>
								</tbody>
						</table>												
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
                                      <TD width="20%" class="table_body"><div align="center">泪器</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">右</div></TD>
                                      <TD class="table_none"><div align="left">                                      
                                        <select id="sopecsurfaceeyeod" name="sopecsurfaceeyeod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                           <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='1'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>                                                                  
                                        </select>
                                        <input type="hidden" clean=clean id="sopecsurfaceeyeodHidden" name="eyesCheckPo.sopecsurfaceeyeod" readonly="readonly" value="${eyesCheckPo.sopecsurfaceeyeod }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopeccongestiveod" name="sopeccongestiveod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='2'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>   
                                        </select>
                                        <input type="hidden" clean=clean id="sopeccongestiveodHidden" name="eyesCheckPo.sopeccongestiveod" readonly="readonly" value="${eyesCheckPo.sopeccongestiveod }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopecnippleod" name="sopecnippleod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='3'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                        <input type="hidden" clean=clean id="sopecnippleodHidden" name="eyesCheckPo.sopecnippleod" readonly="readonly" value="${eyesCheckPo.sopecnippleod }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopeccornealod" name="sopeccornealod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='4'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                        <input type="hidden" clean=clean id="sopeccornealodHidden" name="eyesCheckPo.sopeccornealod" readonly="readonly" value="${eyesCheckPo.sopeccornealod }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopecapparatusod" name="sopecapparatusod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='61'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                        <input type="hidden" clean=clean id="sopecapparatusodHidden" name="eyesCheckPo.sopecapparatusod" readonly="readonly" value="${eyesCheckPo.sopecapparatusod }"/>
                                      </div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">左</div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopecsurfaceeyeos" name="sopecsurfaceeyeos" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='1'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                        <input type="hidden" clean=clean id="sopecsurfaceeyeosHidden" name="eyesCheckPo.sopecsurfaceeyeos" readonly="readonly" value="${eyesCheckPo.sopecsurfaceeyeos }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopeccongestiveos" name="sopeccongestiveos" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='2'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                        <input type="hidden" clean=clean id="sopeccongestiveosHidden" name="eyesCheckPo.sopeccongestiveos" readonly="readonly" value="${eyesCheckPo.sopeccongestiveos }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopecnippleos" name="sopecnippleos" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='3'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                        <input type="hidden" clean=clean id="sopecnippleosHidden" name="eyesCheckPo.sopecnippleos" readonly="readonly" value="${eyesCheckPo.sopecnippleos }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopeccornealos" name="sopeccornealos" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='4'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach> 
                                        </select>
                                        <input type="hidden" clean=clean id="sopeccornealosHidden" name="eyesCheckPo.sopeccornealos" readonly="readonly" value="${eyesCheckPo.sopeccornealos }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopecapparatusos" name="sopecapparatusos" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='61'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopecapparatusosHidden" name="eyesCheckPo.sopecapparatusos" readonly="readonly" value="${eyesCheckPo.sopecapparatusos }"/>
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
                                      <TD width="14%" class="table_body"><div align="center">色觉</div></TD>
                                      <TD colspan="2" class="table_body"><div align="center">眼压</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">分级</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">schirme5</div></TD>
                                      <TD width="17%" class="table_body"><div align="center">BUT</div></TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">右</div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopechyphemaod" name="sopechyphemaod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='6'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopechyphemaodHidden" name="eyesCheckPo.sopechyphemaod" readonly="readonly" value="${eyesCheckPo.sopechyphemaod }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopecirisod" name="sopecirisod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='7'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopecirisodHidden" name="eyesCheckPo.sopecirisod" readonly="readonly" value="${eyesCheckPo.sopecirisod }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopeccrystalod" name="sopeccrystalod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='8'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopeccrystalodHidden" name="eyesCheckPo.sopeccrystalod" readonly="readonly" value="${eyesCheckPo.sopeccrystalod }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="center">
                                        <input type="text" id="sopecfundusod" name="eyesCheckPo.sopecfundusod" value = "${eyesCheckPo.sopecfundusod}" maxlength="10" class="text_input120">
                                      </div></TD>
                                      <TD class="table_none">
	                                      <select id="sopeccolorod" name="sopeccolorod" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='11'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopeccolorodHidden" name="eyesCheckPo.sopeccolorod" readonly="readonly" value="${eyesCheckPo.sopeccolorod }"/>
                                      </TD>
                                      <TD width="10%" class="table_none"><input name="eyesCheckPo.sopeciopod" class="text_input80" value="${eyesCheckPo.sopeciopod }" maxlength="10"></TD>
                                      <TD width="10%" class="table_none">
	                                      <select name="eyesCheckPo.sopeciopselod">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='12'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeciopselod == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>                                      
                                    <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                     <select id="sophctearfilmgradeod1" name="eyesCheckPo.sophctearfilmgradeod1" value="${eyesCheckPo.sophctearfilmgradeod1 }" >
                                       <option value="" selected></option>
                                       <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                <c:if test="${optionParamPoTmp.fopparentid=='37'}">
			                                	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sophctearfilmgradeod1 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                </c:if>	                                      	
                                       </c:forEach>
                                     </select>
                                   </div></TD>
                                   <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                     <input name="eyesCheckPo.sophcschirme5od" class="text_input60" value="${eyesCheckPo.sophcschirme5od }" maxlength="10">mm
                                   </div></TD>
                                   <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                     <input name="eyesCheckPo.sophcbu7od" class="text_input60" value="${eyesCheckPo.sophcbu7od }" maxlength="10">s
                                   </div></TD> 
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body"><div align="center">左</div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopechyphemaos" name="sopechyphemaos" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='6'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopechyphemaosHidden" name="eyesCheckPo.sopechyphemaos" readonly="readonly" value="${eyesCheckPo.sopechyphemaos }"/>
                                      </div></TD>
                                      <TD class="table_none"><div align="left">
                                        <select id="sopecirisos" name="sopecirisos" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='7'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopecirisosHidden" name="eyesCheckPo.sopecirisos" readonly="readonly" value="${eyesCheckPo.sopecirisos }"/>
                                      </div></TD>
                                      <TD class="table_none">
                                      <div align="left">
                                        <select id="sopeccrystalos" name="sopeccrystalos" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='8'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                       </select>
                                       <input type="hidden" clean=clean id="sopeccrystalosHidden" name="eyesCheckPo.sopeccrystalos" readonly="readonly" value="${eyesCheckPo.sopeccrystalos }"/>	                                      
                                      </div>
                                      </TD>
                                      <TD class="table_none"><div align="center">
                                        <input type="text" id="sopecfundusos" name="eyesCheckPo.sopecfundusos" value = "${eyesCheckPo.sopecfundusos}" maxlength="10" class="text_input120">
                                      </div></TD>
                                      <TD class="table_none">
	                                      <select id="sopeccoloros" name="sopeccoloros" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='11'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopeccolorosHidden" name="eyesCheckPo.sopeccoloros" readonly="readonly" value="${eyesCheckPo.sopeccoloros }"/>
                                      </TD>
                                      <TD width="10%" class="table_none"><input name="eyesCheckPo.sopeciopos" class="text_input80" value="${eyesCheckPo.sopeciopos }" maxlength="10"></TD>
                                      <TD width="10%" class="table_none">
	                                      <select name="eyesCheckPo.sopeciopselos">
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='12'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sopeciopselos == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                      </TD>
                                     <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                     <select id="sophctearfilmgradeos1" name="eyesCheckPo.sophctearfilmgradeos1" value="${eyesCheckPo.sophctearfilmgradeos1 }" >
                                       <option value="" selected></option>
                                       <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
			                                <c:if test="${optionParamPoTmp.fopparentid=='37'}">
			                                	<option value="${optionParamPoTmp.fopparamid }" ${(eyesCheckPo.sophctearfilmgradeos1 == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
			                                </c:if>	                                      	
                                       </c:forEach>
                                     </select>
                                   </div></TD>
                                   <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                     <input name="eyesCheckPo.sophcschirme5os" class="text_input60" value="${eyesCheckPo.sophcschirme5os }" maxlength="10">mm
                                   </div></TD>
                                   <TD bgcolor="#E9F2F7" class="Privateborder"><div align="center">
                                     <input name="eyesCheckPo.sophcbu7os" class="text_input60" value="${eyesCheckPo.sophcbu7os }" maxlength="10">s
                                   </div></TD> 
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
                                    </tr>
                                    <tr>
									  <TD width="10%" height="30" class="table_body" rowspan="2">诊断</TD>
                                      <TD width="23%" class="table_none" colspan="5">
                                      <input type="radio" onClick="isShowIll();" value="0" checked="checked" ${eyesCheckPo.sopecfruit != '0' ? '' : 'checked="checked"'} id="isCheckHealth" name="eyesCheckPo.sopecfruit">正常
                                      <input type="radio" onClick="isShowIll();" value="1" ${eyesCheckPo.sopecfruit != '1' ? '' : 'checked="checked"'} id="isCheckHealth" name="eyesCheckPo.sopecfruit">异常
									</TR>
									<tr>
										<td class="table_none" colspan="5"><div id="illdivtype">
										屈光不正	<input type="text" yc=yc name="eyesCheckPo.sopdezdqgbz" class="text_input140" maxlength="50">&nbsp;&nbsp;
										弱视		<input type="text" yc=yc name="eyesCheckPo.sopdezdrs" 	class="text_input140" maxlength="50">&nbsp;&nbsp;
										斜视		<input type="text" yc=yc name="eyesCheckPo.sopdezdxs" 	class="text_input140" maxlength="50">&nbsp;&nbsp;
										其他		<input type="text" yc=yc name="eyesCheckPo.sopdezdqt" 	class="text_input140" maxlength="50">&nbsp;&nbsp;
										</div></td>
									</tr>
								</TBODY>
							</TABLE>
							<TABLE width="99%" border=0 align=center cellPadding=1 cellSpacing=1 class="privateTable PrivateBorder">
                                  <TBODY>
                                    <TR>
                                      <TD width="20%" height="30" class="table_body">眼病史</TD>
                                      <TD width="80%" class="table_none">
                                        <select id="sopecillhistory1" name="sopecillhistory1" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='14'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopecillhistory1Hidden" name="eyesCheckPo.sopecillhistory1" readonly="readonly" value="${eyesCheckPo.sopecillhistory1 }"/>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">遗传史</TD>
                                      <TD class="table_none">
                                        <select id="sopecheredityhistory1" name="sopecheredityhistory1" multiple="multiple" size="20" clean=clean>
                                          <option value="" selected></option>
                                          <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                                      <c:if test="${optionParamPoTmp.fopparentid=='15'}">
		                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
		                                      </c:if>	                                      	
	                                      </c:forEach>
                                        </select>
                                        <input type="hidden" clean=clean id="sopecheredityhistory1Hidden" name="eyesCheckPo.sopecheredityhistory1" readonly="readonly" value="${eyesCheckPo.sopecheredityhistory1 }"/>
                                      </TD>
                                    </TR>
                                    <TR>
                                      <TD height="30" class="table_body">过敏史</TD>
                                      <TD class="table_none">
                                        <input type="text" id="sopecallergyhistory1" name="eyesCheckPo.sopecallergyhistory1" value = "${eyesCheckPo.sopecallergyhistory1}" maxlength="16" class="text_input200" style="width: 200">
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><table width="99%" 
	                 border=0 align=center cellpadding=1 cellspacing=1 class="privateTable privateBorder">
	                                 <tbody>
								  <tr>
								  	<td height="30" bgcolor="#CADEE8" valign="bottom" class="table_none">
									框架眼镜：
                                       <select id="sopipglasstypes" name="sopipglasstypes" multiple="multiple" size="20" clean=clean>
                                         <option value="" selected></option>
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      <c:if test="${optionParamPoTmp.fopparentid=='48'}">
	                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
	                                      </c:if>	                                      	
                                      </c:forEach>
                                       </select>
                                       <input type="hidden" clean=clean id="sopipglasstypesHidden" name="eyesCheckPo.sopipglasstypes" readonly="readonly" value="${eyesCheckPo.sopipglasstypes }"/>									
									 	角膜接触镜：
									 <select id="sopiptouchglass" name="sopiptouchglass" multiple="multiple" size="20" clean=clean>
                                         <option value="" selected></option>
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      <c:if test="${optionParamPoTmp.fopparentid=='49'}">
	                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
	                                      </c:if>	                                      	
                                      </c:forEach>
                                       </select>
                                       <input type="hidden" clean=clean id="sopiptouchglassHidden" name="eyesCheckPo.sopiptouchglass" readonly="readonly" value="${eyesCheckPo.sopiptouchglass }"/>									 	
											视觉训练：
									 <select id="sopiptraintypes" name="sopiptraintypes" multiple="multiple" size="20" clean=clean>
                                         <option value="" selected></option>
                                         <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
	                                      <c:if test="${optionParamPoTmp.fopparentid=='50'}">
	                                      	<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
	                                      </c:if>	                                      	
                                      </c:forEach>
                                       </select>
                                       <input type="hidden" clean=clean id="sopiptraintypesHidden" name="eyesCheckPo.sopiptraintypes" readonly="readonly" value="${eyesCheckPo.sopiptraintypes }"/>									 											
										手术：<input type="text" id="sopioperation" name="eyesCheckPo.sopioperation" value = "${eyesCheckPo.sopioperation}" maxlength="50" class="text_input200">								
									</td>
								  </tr>								  
								  </tbody>	
	                              </table>
								</td>
								</tr>
								</table>                                
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
  </TBODY></TABLE></DIV>
</form>
</body></html>
<script>
	initSelectList('sopecsurfaceeyeod','sopecsurfaceeyeodHidden');	//外眼-右
	initSelectList('sopeccongestiveod','sopeccongestiveodHidden');	//结膜充血-右
	initSelectList('sopecnippleod','sopecnippleodHidden');	//结膜-右
	initSelectList('sopeccornealod','sopeccornealodHidden');	//角膜-右
	initSelectList('sopecapparatusod','sopecapparatusodHidden');	//泪器-右
	initSelectList('sopecsurfaceeyeos','sopecsurfaceeyeosHidden');	//外眼-左
	initSelectList('sopeccongestiveos','sopeccongestiveosHidden');	//结膜充血-左
	initSelectList('sopecnippleos','sopecnippleosHidden');	//结膜-左		
	initSelectList('sopeccornealos','sopeccornealosHidden');	//角膜-左
	initSelectList('sopecapparatusos','sopecapparatusosHidden');	//泪器-左	
	initSelectList('sopechyphemaod','sopechyphemaodHidden');	//前房-右
	initSelectList('sopecirisod','sopecirisodHidden');	//虹膜-右
	initSelectList('sopeccrystalod','sopeccrystalodHidden');	//晶体-右		
	initSelectList('sopeccolorod','sopeccolorodHidden');	//色觉-右
	initSelectList('sopechyphemaos','sopechyphemaosHidden');	//前房-左	
	initSelectList('sopecirisos','sopecirisosHidden');	//虹膜-左
	initSelectList('sopeccrystalos','sopeccrystalosHidden');	//晶体-左
	initSelectList('sopeccoloros','sopeccolorosHidden');	//色觉-左
	initSelectList('sopecillhistory1','sopecillhistory1Hidden');	//眼病史-1

	initSelectList('sopecheredityhistory1','sopecheredityhistory1Hidden');	//遗传史
	initSelectList('sopipglasstypes','sopipglasstypesHidden');	//框架眼镜
	initSelectList('sopiptouchglass','sopiptouchglassHidden');	//角膜接触镜
	initSelectList('sopiptraintypes','sopiptraintypesHidden');	//视觉训练
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>