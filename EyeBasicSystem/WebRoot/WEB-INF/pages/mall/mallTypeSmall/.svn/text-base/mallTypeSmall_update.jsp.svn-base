<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城管理</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});
	
	function save(){
		if(checkForm(document.all.mallTypeSmallForm)){	
			$("img").removeAttr("onclick");   
			mallTypeSmallForm.action = "updateMallTypeSmallPo.action";
			mallTypeSmallForm.submit();
		}
	}
</script>
<%@ include file="/commons/uploadFile.jsp" %>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<DIV>
<form name="mallTypeSmallForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="mallTypeSmallPo.mtsid" value="${mallTypeSmallPo.mtsid }" /> 
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>    
                        <TR>
						 <TD class="table_body" width="10%" height="26">商品类型</TD>
			             <TD class="table_none" width="20%">
						  	<select id="mtslargeid" name="mallTypeSmallPo.mtslargeid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品类型不能为空！'}]">
						  		<option value=""></option>
						  		<s:iterator value="mallTypeLargeList">
								<option value="${mtlid}" ${mtlid eq mallTypeSmallPo.mtslargeid ? 'selected="selected"' : '' } >${mtlname}</option>
	     	               		</s:iterator>
							</select>
							<label style="color:red;">&nbsp;*&nbsp;</label>
						 </TD>
						 <TD class="table_body" width="10%" height="26">商品品种</TD>
			             <TD class="table_none" width="20%">
						  	<select id="mtsbrandid" name="mallTypeSmallPo.mtsbrandid" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品品种不能为空！'}]">
						  		<option value=""></option>
						  		<s:iterator value="mallBrandList">
								<option value="${mbid}" ${mbid eq mallTypeSmallPo.mtsbrandid ? 'selected="selected"' : '' } >${mbname}</option>
	     	               		</s:iterator>
							</select>
							<label style="color:red;">&nbsp;*&nbsp;</label>
						 </TD>	
			             <TD class="table_body" width="10%" height="26">商品专区</TD>
			             <TD class="table_none">
						  	<select id="mtsareaid" name="mallTypeSmallPo.mtsareaid">
						  		<option value=""></option>
						  		<s:iterator value="mallAreaList">
								<option value="${maid}" ${maid eq mallTypeSmallPo.mtsareaid ? 'selected="selected"' : '' } >${maname}</option>
	     	               		</s:iterator>
							</select>
						 </TD>						 					 
						</TR>	
                        <TR>
						  <TD class="table_body" height="26">商品原价</TD>
                          <TD class="table_none"><input class="text_input100" id="mtspriceold" name="mallTypeSmallPo.mtspriceold" value="${mallTypeSmallPo.mtspriceold }" maxlength="10" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if($.trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
                          <TD class="table_body" height="26">商品现价</TD>
                          <TD class="table_none" colspan="3"><input class="text_input100" id="mtspricenew" name="mallTypeSmallPo.mtspricenew" value="${mallTypeSmallPo.mtspricenew }" maxlength="10" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if($.trim(this.value)!='')this.value = new Number(this.value).toFixed(2);}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '金额不能为空！'}, {'Type' : Type.Number, 'Formula' : '', 'Expansion' : {Type : Expansion.DecimalValidation, Params : [2]}, 'Message' : '金额格式错误！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
                        </TR>											
						<TR>
						 <TD class="table_body" height="26">商品名称</TD>
                          <TD class="table_none" colspan="5"><input class="text_input400" id="mtsname" name="mallTypeSmallPo.mtsname" value="${mallTypeSmallPo.mtsname }" maxlength="100" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '商品名称不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '商品名称不能大于100字！'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
                        </TR>                              
                        <TR>
						  <TD class="table_body" height="26">库存数量</TD>
                          <TD class="table_none"><input class="text_input100" id="mtsstockcount" name="mallTypeSmallPo.mtsstockcount" value="${mallTypeSmallPo.mtsstockcount }" onKeyUp="value=value.replace(/[^\d\.]/g,'')" maxlength="10"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '数量不能为空！'}, {'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '数量只能输入整数'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
                          <TD class="table_body" height="26">已销数量</TD>
                          <TD class="table_none" colspan="3"><input class="text_input100" id="mtssalecount" name="mallTypeSmallPo.mtssalecount" value="${mallTypeSmallPo.mtssalecount }" onKeyUp="value=value.replace(/[^\d\.]/g,'')" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '数量不能为空！'}, {'Type' : Type.String, 'Formula' : Formula.UINT, 'Message' : '数量只能输入整数'}]"><label style="color:red;">&nbsp;*&nbsp;</label></TD>
                        </TR> 
						<TR>
						 <TD class="table_body" height="26">商品型号</TD>
                          <TD class="table_none" colspan="5"><input class="text_input400" id="mtsspec" name="mallTypeSmallPo.mtsspec" value="${mallTypeSmallPo.mtsspec }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [201]}, 'Message' : '商品型号不能大于100字！'}]"/><label style="color:red;">&nbsp;以逗号隔开(如：型号1，型号2...</label></TD>
                        </TR>   
						<TR>
						 <TD class="table_body" height="26">商品颜色</TD>
                          <TD class="table_none" colspan="5"><input class="text_input400" id="mtscolor" name="mallTypeSmallPo.mtscolor" value="${mallTypeSmallPo.mtscolor }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [201]}, 'Message' : '商品颜色不能大于100字！'}]"/><label style="color:red;">&nbsp;以逗号隔开(如：白色，红色...)</label></TD>
                        </TR>                                                                      
                        <TR>
						  <TD class="table_body" height="26">商品列表图</TD>
						  <td class="table_none" colspan="5">
                            <input type="hidden" class="text_input300" name="mallTypeSmallPo.mtspicurl" id="mtspicurl" value="${mallTypeSmallPo.mtspicurl2}" readonly="readonly"/>
                            <input type="button" onclick="startLoad('/upload/mall','1','mtspicurl','mtspicurlDiv','320','160','update')" value="图片上传"/>
                            <label style="color:red;">(图片大小建议为640*320。)&nbsp;</label>
                          </td>
                        </TR>
                        <TR>
						  <TD class="table_body" height="26">图片预览</TD>
						  <td class="table_none" colspan="5">
                            <div id="mtspicurlDiv">
				               	<c:if test="${mallTypeSmallPo.mtspicurl ne ''}" >
				               		<p><img src="${ctx}${mallTypeSmallPo.mtspicurl}" width="320" height="160" border="0" title='点击查看大图' width2="640" height2="320" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${mallTypeSmallPo.mtspicurl}","mtspicurl");>删除</a></p>
				               	</c:if>
			               	</div>                            
                          </td>
                        </TR>
                        <TR>
			              <TD height="50" class="table_body">图文详细</TD>
			              <TD class="table_none" colspan="5">
		               		<FCK:editor instanceName="content" height="300px" width="100%">
								<jsp:attribute name="value">
									${mallTypeSmallPo.mtscontent}
								</jsp:attribute>
							</FCK:editor>
                          </TD>
                        </TR>                                                                       
                        <TR>
                          <TD colspan="6">
                          	<li class="horizontal_onlyRight"><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()"></li>
                          	<li class="horizontal_onlyRight"><input id="stateFlag" name="stateFlag" type="checkbox" value="1" ${mallTypeSmallPo.mtsflag eq '1'? ' checked':''}></li>发布
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
    <TD height=5></TD></TR></TBODY></TABLE>
    </form></DIV></BODY></HTML>
<%@ include file="/WEB-INF/inc/message.jsp" %>