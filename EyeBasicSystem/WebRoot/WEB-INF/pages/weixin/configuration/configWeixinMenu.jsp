<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport"
		content="initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>微信菜单配置</title>
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

    function save(){
    	if(checkForm(configMenuForm)){
        	
    		$("img").removeAttr("onclick");
    		configMenuForm.action = "insertConfigWeixinMenu.action";
    		configMenuForm.submit();
        }
    }

	function configMenuDetail(menuID){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConfigWeixinMenuDetail.action?menuID="+menuID,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initConfigWeixinMenuDetail.action?menuID="+menuID,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【微信菜单参数配置】";
	}
    
	function viewMenu(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initViewWeixinMenu.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initViewWeixinMenu.action",380,500,topRows,topCols,returnRefresh(false),false);
		}
		document.getElementById('popupTitle').innerHTML="【微信菜单预览】";
	}

	function createMenu(){
		var weiXinID = document.getElementById("wrddepartmentid").value;
		if(weiXinID ==''){
			alert("请选择要生成菜单的微信公众号!");
			return;
		}else{
			$.ajax({           
		   	 	type: "POST",          
	   	   	    url: "GenerationMenuManager.action?weiXinID=" + weiXinID, 
	   	  	 	data: "hid=1",            
	   	   	    async: true, 
	   	   	    success: function(msg){
		   	   		if(""!=msg){
			   	  	 	alert(msg)
		   	   		}
	   	   	    }    
		   	});	
		}    		
	}	

   	function changeSelect(str){
   		document.getElementById("input"+str).value = "";
		if(document.getElementById("select"+str).value == 'system_website'){
			//document.getElementById("input"+str).readOnly = false;
		}else{			
			//document.getElementById("input"+str).readOnly = true;
		}
   	}

   	function zhuChange(obj){
	//alert(obj.value);
   	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="configMenuForm" method="post" action="">	
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<table width="1000" border=0 align=center cellpadding=1 cellspacing=1
	class="privateBorder">
	<tr>
		<td width="100" height="90" align="center" class="table_title">
			子菜单：1
		</td>
		<td align="left" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid11" value="11" />
			<select name="weiXinMenuPo.wmcflag11">
				<option value="1" ${(weiXinMenuPo.wmcflag11 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag11 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('11');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname11" maxlength="50" value="${weiXinMenuPo.wmcname11 }" maxlength="20"></br>	
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid11}">${wmtname }</c:if>
                </s:iterator>			
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid21" value="21" />
			<select name="weiXinMenuPo.wmcflag21">
				<option value="1" ${(weiXinMenuPo.wmcflag21 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag21 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('21');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname21" maxlength="50" value="${weiXinMenuPo.wmcname21 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid21}">${wmtname }</c:if>
                </s:iterator>				
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid31" value="31" />
			<select name="weiXinMenuPo.wmcflag31">
				<option value="1" ${(weiXinMenuPo.wmcflag31 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag31 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('31');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname31" maxlength="50" value="${weiXinMenuPo.wmcname31 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid31}">${wmtname }</c:if>
                </s:iterator>			
		</td>
	</tr>
	<tr>
		<td height="90" align="center" class="table_title">
			子菜单：2
		</td>
		<td align="left" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid12" value="12" />
			<select name="weiXinMenuPo.wmcflag12">
				<option value="1" ${(weiXinMenuPo.wmcflag12 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag12 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('12');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname12" maxlength="50" value="${weiXinMenuPo.wmcname12 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid12}">${wmtname }</c:if>
                </s:iterator>										
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid22" value="22" />
			<select name="weiXinMenuPo.wmcflag22">
				<option value="1" ${(weiXinMenuPo.wmcflag22 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag22 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('22');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname22" maxlength="50" value="${weiXinMenuPo.wmcname22 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid22}">${wmtname }</c:if>
                </s:iterator>							
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid32" value="32" />
			<select name="weiXinMenuPo.wmcflag32">
				<option value="1" ${(weiXinMenuPo.wmcflag32 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag32 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('32');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname32" maxlength="50" value="${weiXinMenuPo.wmcname32 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid32}">${wmtname }</c:if>
                </s:iterator>						
		</td>
	</tr>
	<tr>
		<td height="90" align="center" class="table_title">
			子菜单：3
		</td>
		<td align="left" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid13" value="13" />
			<select name="weiXinMenuPo.wmcflag13">
				<option value="1" ${(weiXinMenuPo.wmcflag13 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag13 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('13');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname13" maxlength="50" value="${weiXinMenuPo.wmcname13 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid13}">${wmtname }</c:if>
                </s:iterator>						
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid23" value="23" />
			<select name="weiXinMenuPo.wmcflag23">
				<option value="1" ${(weiXinMenuPo.wmcflag23 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag23 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('23');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname23" maxlength="50" value="${weiXinMenuPo.wmcname23 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid23}">${wmtname }</c:if>
                </s:iterator>						
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid33" value="33" />
			<select name="weiXinMenuPo.wmcflag33">
				<option value="1" ${(weiXinMenuPo.wmcflag33 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag33 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('33');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname33" maxlength="50" value="${weiXinMenuPo.wmcname33 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid33}">${wmtname }</c:if>
                </s:iterator>						
		</td>
	</tr>
	<tr>
		<td height="90" align="center" class="table_title">
			子菜单：4
		</td>
		<td align="left" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid14" value="14" />
			<select name="weiXinMenuPo.wmcflag14">
				<option value="1" ${(weiXinMenuPo.wmcflag14 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag14 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('14');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname14" maxlength="50" value="${weiXinMenuPo.wmcname14 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid14}">${wmtname }</c:if>
                </s:iterator>						
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid24" value="24" />
			<select name="weiXinMenuPo.wmcflag24">
				<option value="1" ${(weiXinMenuPo.wmcflag24 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag24 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('24');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname24" maxlength="50" value="${weiXinMenuPo.wmcname24 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid24}">${wmtname }</c:if>
                </s:iterator>						
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid34" value="34" />
			<select name="weiXinMenuPo.wmcflag34">
				<option value="1" ${(weiXinMenuPo.wmcflag34 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag34 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('34');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname34" maxlength="50" value="${weiXinMenuPo.wmcname34 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid34}">${wmtname }</c:if>
                </s:iterator>						
		</td>
	</tr>
	<tr>
		<td height="90" align="center" class="table_title">
			子菜单5
		</td>
		<td align="left" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid15" value="15" />
			<select name="weiXinMenuPo.wmcflag15">
				<option value="1" ${(weiXinMenuPo.wmcflag15 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag15 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('15');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname15" maxlength="50" value="${weiXinMenuPo.wmcname15 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid15}">${wmtname }</c:if>
                </s:iterator>						
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid25" value="25" />
			<select name="weiXinMenuPo.wmcflag25">
				<option value="1" ${(weiXinMenuPo.wmcflag25 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag25 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('25');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname25" maxlength="50" value="${weiXinMenuPo.wmcname25 }" maxlength="20"></br>
			&nbsp;链接类型：<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid25}">${wmtname }</c:if>
                </s:iterator>							
		</td>
		<td align=""left"" class="table_body" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid35" value="35" />
			<select name="weiXinMenuPo.wmcflag35">
				<option value="1" ${(weiXinMenuPo.wmcflag35 eq '1')? ' selected':''}>显示菜单</option>
				<option value="0" ${(weiXinMenuPo.wmcflag35 ne '1')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('35');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname35" maxlength="50" value="${weiXinMenuPo.wmcname35 }" maxlength="20"></br>
			&nbsp;链接类型：<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid35}">${wmtname }</c:if>
                </s:iterator>							
		</td>
	</tr>
	<tr>
		<td align="center" class="table_title">
			主菜单
		</td>
		<td align="left" class="table_title" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid1" value="1" />
			<select name="weiXinMenuPo.wmcflag1" onchange="zhuChange(this,);">
				<option value="1" ${(weiXinMenuPo.wmcflag1 eq '1')? ' selected':''}>显示菜单(含子菜单)</option>
				<option value="2" ${(weiXinMenuPo.wmcflag1 eq '2')? ' selected':''}>显示菜单(无子菜单)</option>				
				<option value="0" ${(weiXinMenuPo.wmcflag1 eq '0')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('1');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname1" maxlength="50" value="${weiXinMenuPo.wmcname1 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid1}">${wmtname }</c:if>
                </s:iterator>					
		</td>
		<td align=""left"" class="table_title" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid2" value="2" />
			<select name="weiXinMenuPo.wmcflag2" onchange="zhuChange(this);">
				<option value="1" ${(weiXinMenuPo.wmcflag2 eq '1')? ' selected':''}>显示菜单(含子菜单)</option>
				<option value="2" ${(weiXinMenuPo.wmcflag2 eq '2')? ' selected':''}>显示菜单(无子菜单)</option>				
				<option value="0" ${(weiXinMenuPo.wmcflag2 eq '0')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('2');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname2" maxlength="50" value="${weiXinMenuPo.wmcname2 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid2}">${wmtname }</c:if>
                </s:iterator>						
		</td>
		<td align=""left"" class="table_title" valign="top">
			<input type="hidden" name="weiXinMenuPo.wmcid3" value="3" />
			<select name="weiXinMenuPo.wmcflag3" onchange="zhuChange(this);">
				<option value="1" ${(weiXinMenuPo.wmcflag3 eq '1')? ' selected':''}>显示菜单(含子菜单)</option>
				<option value="2" ${(weiXinMenuPo.wmcflag3 eq '2')? ' selected':''}>显示菜单(无子菜单)</option>				
				<option value="0" ${(weiXinMenuPo.wmcflag3 eq '0')? ' selected':''}>隐藏菜单</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/img/newbtn/btn_weixinConfigMenuDetail_0.png" btn=btn title='参数配置' onclick="configMenuDetail('3');"></br>
			&nbsp;菜单名称：<input class="text_input200" name="weiXinMenuPo.wmcname3" maxlength="50" value="${weiXinMenuPo.wmcname3 }" maxlength="20"></br>
			&nbsp;链接类型：
				<s:iterator value="weiXinMenuTypeList">
					<c:if test="${wmtid eq weiXinMenuPo.wmctypeid3}">${wmtname }</c:if>
                </s:iterator>				
		</td>
	</tr>
	<tr><td height="10" colspan="4">&nbsp;</td></tr>
	<tr>
		<td colspan="4">
			<li class="horizontal_onlyRight">
			<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();">
			</li>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<li class="horizontal_onlyRight">
			<select id="wrddepartmentid" name="wrddepartmentid">
				<OPTION value="">请选择公众号</OPTION>
		    	<c:forEach var="po" items="${registerDepartmentList}" varStatus="poIndex">
		    		<OPTION value="${po.wrdid}">${po.wrdcompanyname}</OPTION>
		    	</c:forEach>
	    	</select>
	    	</li>
			<li class="horizontal_onlyRight">
			<img src="${ctx}/img/newbtn/btn_weixinGM_0.png" btn=btn id="submitButton" title='生成菜单' onclick="createMenu();">
			</li>
		</td>
	</tr>
</table>
</form>
</body>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>