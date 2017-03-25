<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ include file="/commons/select_many_checked.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
#１ {	color: #F00;
}
.STYLE1 {color: #FF0000;
	font-weight: bold;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验光师维护</title>
<style type="text/css">
    img
    {
        filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);
    }
</style>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
		$('#personid').focus();
	});

	function save(){
		getSelectValue('wdwangdian2','wdwangdian');
		getSelectValue('wdzhenliao2','wdzhenliao');
		getSelectValue('wdworkday2','wdworkday');
		
		if(checkForm(doctorForm)){
			$("img").removeAttr("onclick");
			doctorForm.action = "updateWeiXinDoctorPo.action";
			doctorForm.submit();
		}
	
	}
     
</script>
<%@ include file="/commons/uploadFile.jsp" %>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="doctorForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            </TD>					
			  </TR>
        <TR>
          <TD bgColor=#ffffff><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
            <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                    <DIV>
                      <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>    
						<TR>
						   <TD width="10%" height="30" class="table_body">内部验光师工号</TD>
			               <TD class="table_none">
			                <li class="horizontal_onlyRight">
			                	<input type="hidden" id="id" name="weiXinDoctorPo.wdid" value="${weiXinDoctorPo.wdid }"  readonly="readonly">
			               		${weiXinDoctorPo.wdpersonid }
			                </li>
						   	<input id="wdfirstshow" name="wdfirstshow" type="checkbox" value="1" ${(weiXinDoctorPo.wdfirstshow eq '1' ? 'checked=checked':'')}>&nbsp;显示在专家列表的第一位
			               </TD>
			            </tr>
						<TR>
						   <TD width="10%" height="30" class="table_body">好评率</TD>
			               <TD class="table_none">
				               	<c:choose>
	                          		<c:when test="${weiXinDoctorPo.wdhaopinglv eq '-1'}">
	                          			暂无评价
	                          		</c:when>
	                          		<c:otherwise>
	                          			${weiXinDoctorPo.wdhaopinglv}%
	                          		</c:otherwise>
	                          	</c:choose>
                         	</TD>
			            </tr>			            
			            <tr>
							<TD width="10%" height="30" class="table_body">内部验光师姓名</TD>
                          	<TD class="table_none">${weiXinDoctorPo.wdname }</TD>
                        </tr>
                        <tr>
						  	<TD width="10%" height="30" class="table_body">所属网点</TD>
                         	<TD class="table_none">
							<select clean=clean id="wdwangdian2" name="wdwangdian2" multiple="multiple" size="20">
      		                 	<option value="" selected></option>
								<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
									<c:if test="${optionParamPoTmp.fopparentid=='weixin_wangdian'}">
										<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
									</c:if>	                                      	
								</c:forEach> 
      	                   </select>
      	                   <input type="hidden" clean=clean id="wdwangdian" name="weiXinDoctorPo.wdwangdian" readonly="readonly" value="${weiXinDoctorPo.wdwangdian }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择网点！'}]"/>
                        </TD>
                        </TR>
                        <tr>
						  	<TD width="10%" height="30" class="table_body">所属诊疗项目</TD>
                         	<TD class="table_none">
                         	<select clean=clean id="wdzhenliao2" name="wdzhenliao2" multiple="multiple" size="20">
      		                 	<option value="" selected></option>
								<c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
									<c:if test="${optionParamPoTmp.fopparentid=='weixin_zhenliao'}">
										<option value="${optionParamPoTmp.fopparamid }">${optionParamPoTmp.fopparamname}</option>
									</c:if>	                                      	
								</c:forEach> 
      	                   </select>
      	                   <input type="hidden" clean=clean id="wdzhenliao" name="weiXinDoctorPo.wdzhenliao" readonly="readonly" value="${weiXinDoctorPo.wdzhenliao }" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择诊疗项目！'}]"/>
                        </TD>
                        </TR>                        
                        <TR>
						  <TD class="table_body" height="26">简介职称</TD>
                          <TD class="table_none"><input class="text_input400" id="wdzhicheng" name="weiXinDoctorPo.wdzhicheng" value="${weiXinDoctorPo.wdzhicheng }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '职称不能大于50个字！'}]"><label style="color:red;">&nbsp;*&nbsp;例：教授（特邀）</label></TD>
                        </TR>                           
                        <TR>
						  <TD class="table_body" height="26">简介职务</TD>
                          <TD class="table_none"><input class="text_input400" id="wdzhiwu" name="weiXinDoctorPo.wdzhiwu" value="${weiXinDoctorPo.wdzhiwu }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [101]}, 'Message' : '职务不能大于50个字！'}]"><label style="color:red;">&nbsp;*&nbsp;例：主任医师</label></TD>
                        </TR>    
                        <TR>
						  <TD class="table_body" height="26">简介出诊时间</TD>
                          <TD class="table_none">
							<select clean=clean id="wdworkday2" name="wdworkday2" multiple="multiple" size="20" class="text_input100">
      		                 	<option value="" selected></option>
      		                 	<option value="1">周一</option>
      		                 	<option value="2">周二</option>
      		                 	<option value="3">周三</option>
      		                 	<option value="4">周四</option>
      		                 	<option value="5">周五</option>
      		                 	<option value="6">周六</option>
      		                 	<option value="0">周日</option>
      	                   </select>
      	                   <input type="hidden" clean=clean id="wdworkday" name="weiXinDoctorPo.wdworkday" readonly="readonly" value="${weiXinDoctorPo.wdworkday }"/>
                           <label style="color:red;">&nbsp;*&nbsp;</label>		
						  </TD>
                        </TR>                                                
                        <TR>
						  <TD class="table_body" height="26">简介头像</TD>
						  <td class="table_none">
                            <input type="text" class="text_input300" name="weiXinDoctorPo.wdpicurl" id="wdpicurl" value="${weiXinDoctorPo.wdpicurl2}" readonly="readonly"/>
                            <input type="button" onclick="startLoad('/upload/weixin','1','wdpicurl','wdpicurlDiv','123','152','update')" value="图片上传"/>
                            <label style="color:red;">(图片大小建议为123:152。)&nbsp;</label>
                          </td>
                        </TR> 
                        <TR>
						  <TD class="table_body" height="26">头像预览</TD>
						  <td class="table_none">
                            <div id="wdpicurlDiv">
				               	<c:if test="${weiXinDoctorPo.wdpicurl ne ''}" >
				               		<p><img src="${ctx}${weiXinDoctorPo.wdpicurl}" width="123" height="152" border="0" title='点击查看大图' width2="246" height2="304" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${weiXinDoctorPo.wdpicurl}","wdpicurl");>删除</a></p>
				               	</c:if>
				            </div>                            
                          </td>
                        </TR>                                                  
                        <TR>
		               	 <TD height="50" class="table_body">简介内容</TD>
			              <TD class="table_none">
		               		<FCK:editor instanceName="content" height="300px" width="100%">
								<jsp:attribute name="value">
									${weiXinDoctorPo.wdcontent}
								</jsp:attribute>
							</FCK:editor>
                          </TD>
                        </TR>  
                        <TR>
                          <TD>
                          	<img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">
                          </TD>
                        </TR>                   
                      </TBODY>
                    </TABLE>
                    </DIV>
                </DIV>
                    <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" 
width=1></TD>
              </TR>
            </TBODY>
          </TABLE></TD>
        </TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<script>
	initSelectList('wdwangdian2','wdwangdian');
	initSelectList('wdzhenliao2','wdzhenliao');
	initSelectList('wdworkday2','wdworkday');
</script>
<%@ include file="/WEB-INF/inc/message.jsp" %>