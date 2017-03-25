<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门维护</title>
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
		if(checkForm(departmentsForm)){
			$("img").removeAttr("onclick");
			departmentsForm.action = "updateWeiDepartment.action";
			departmentsForm.submit();
		}
	}    
</script>
<%@ include file="/commons/uploadFile.jsp" %>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="departmentsForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif></TD>					
		</TR>
        <TR>
          <TD bgColor=#ffffff><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
            <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" vAlign=top>
                <DIV id=tabContent__1>
                    <DIV>
                      <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                        <TBODY>
                          <TR>
                            <TD width="5%"><div align="left"><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                            <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                          </TR>
                        </TBODY>
                      </TABLE>
                      <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                        <TBODY>
                          <TR>
                            <TD width="15%" height="26" class="table_body">部门编码</TD>
                            <TD width="20%" class="table_none">${departmentsPo.bdpdepartmentid }<input type="hidden" name="departmentsPo.bdpdepartmentid" value="${departmentsPo.bdpdepartmentid }"></TD>
                            <TD width="15%" height="26" class="table_body">部门名称</TD>
                            <TD class="table_none" colspan="3">${departmentsPo.bdpdepartmentname }
                              <input class="text_input200" id="bdpdepartmentname" name="departmentsPo.bdpdepartmentname" value="${departmentsPo.bdpdepartmentname }" maxlength="50" type="hidden">
                            </TD>                            
                          </TR>
                            <TR>
                            <TD height="26" class="table_body">部门电话</TD>
                            <TD class="table_none" colspan="5"><input class="text_input200" id="bdpphone" name="departmentsPo.bdpphone" value="${departmentsPo.bdpphone }" maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.PhoneORNULL, 'Message' : '部门电话格式错误！'}]"></TD>

                          </TR>
                           <TR>
                            <TD height="26" class="table_body">部门地址</TD>
                            <TD class="table_none" colspan="5"><input class="text_input400" id="bdpaddress" name="departmentsPo.bdpaddress" value="${departmentsPo.bdpaddress}" maxlength="500"></TD>
                          </TR>
                            <TR>
                            <TD height="26" class="table_body">地址坐标X轴</TD>
                            <TD class="table_none" colspan="5">
                            	<input class="text_input240"  id="bdplocationx" name="departmentsPo.bdplocationx" value="${departmentsPo.bdplocationx}" maxlength="10">
                            	<span class="STYLE1">纬度值</span>
                            </TD>
                          </TR>
                          <TR>
                            <TD height="26" class="table_body">地址坐标Y轴</TD>
                            <TD class="table_none" colspan="5">
                            	<input class="text_input240" id="bdplocationy" name="departmentsPo.bdplocationy" value="${departmentsPo.bdplocationy}" maxlength="10">
                            	<span class="STYLE1">经度值</span>
                            </TD>
                          </TR>
                          <TR>			               
			               <TD height="26" class="table_body">微信标题图</TD>
			               <TD class="table_none" colspan="5">
                            	<input type="text" class="text_input400" name="departmentsPo.bdppicurl" id="bdppicurl" value="${departmentsPo.bdppicurl2}" readonly="readonly"/>
                            	<input type="button" onclick="startLoad('/upload/weixin','1','bdppicurl','bdppicurlDiv','300','200','update')" value="图片上传"/>
                            	<label style="color:red;">(图片要求为3：2比例;在系统中显示为150：100大小；)&nbsp;</label>
			               </TD>
                        </TR>
                        <TR>			               
			               <TD height="26" class="table_body" >标题图预览</TD>
			               <TD class="table_none" colspan="5">
			               	<div id="bdppicurlDiv">
			               	<c:if test="${departmentsPo.bdppicurl ne ''}" >
			               		<p><img src="${ctx}${departmentsPo.bdppicurl}" width="300" height="200" border="0" title='点击查看大图' width2="600" height2="400" onclick="imgclick(this)" style="cursor: hand;" /><a style='cursor:hand' onclick=deleteServerFile(this,"${departmentsPo.bdppicurl}","bdppicurl");>删除</a></p>
			               	</c:if>
			               	</div>
			               </TD>
                        </TR>
                        <TR>			               
			               <TD height="26" class="table_body">微信可见</TD>
			               <TD class="table_none" colspan="5">
			               	<input type="radio" name="departmentsPo.bdpissee" value="0" ${(departmentsPo.bdpissee eq 0 ||departmentsPo.bdpissee eq null) ? "checked" : "" }>可见 
			               	<input type="radio" name="departmentsPo.bdpissee" value="1" ${departmentsPo.bdpissee eq 1 ? "checked" : "" }>不可见
			               </TD>
                        </TR>
                      </TABLE>
                      <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                        <TBODY>
                          <TR>
                            <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" onclick="save();" title='保存'></TD>
                          </TR>
                        </TBODY>
                      </TABLE>
                    </DIV>
                </DIV>
                    <!--?End--></TD>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
              </TR>
            </TBODY>
          </TABLE></TD>
        </TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
        </TR>
       </TBODY>
     </TABLE>
     <!--?? End--></TD>
  </TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
    <%@ include file="/WEB-INF/inc/message.jsp" %>