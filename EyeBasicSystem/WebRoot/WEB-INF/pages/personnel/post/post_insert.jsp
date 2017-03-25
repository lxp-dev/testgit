<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职务维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#mptcontent').focus();
	});
	
		
		
	function save(){
		if(checkForm(postForm)){
			$("img").removeAttr("onclick");
			postForm.action = "insertPost.action";
			postForm.submit();
		}
	}
	
	function changeRadioType(obj){    
    	var objValue=obj.value;
    	if(objValue=="1"){  
    		document.getElementById("displayID").style.display="none";  
    		document.getElementById("displayID1").style.display="none"; 
    		document.getElementById("mptparented").validate=""; 
    		document.getElementById("mptsalary").validate="";   		
    	}else{
    		document.getElementById("displayID").style.display="";
    		document.getElementById("displayID1").style.display="";    		
    		document.getElementById("mptparented").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'所属职务不能为空！\'}]";  		
    		document.getElementById("mptsalary").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.FloatORNULL, \'Message\' : \'只能是整数或小数！\'},{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'岗位津贴不能为空！\'}]";
    	}
    }
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="postForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

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
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
				  <table width="100%" id="title0"  border=0 align=center cellpadding=0 cellspacing=0 class="privateTable">
                        <TBODY>
                          <TR>
                            <TD width="5%"><div align="left"><img src="${ctx }/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                            <TD width="95%" background="${ctx }/img/pic/msgbg.png" >&nbsp;</TD>
                          </TR>
                        </TBODY>
                    </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                          		 <TR>
								   <TD width="10%" height="26" class="table_body">新增类别</TD>
					               <TD width="40%" colspan="3" class="table_none">
					               <c:if test="${not empty postPo.mptdeptid }" >
							   			<input name="postPo.mptdeptid" id="mptdeptid" type="radio" value="1"  ${postPo.mptdeptid == 1 ?  'checked="checked"':'' }   onClick="changeRadioType(this)"/>职务
			  				  		  	<input type="radio" id="mptdeptid" name="postPo.mptdeptid" value="2" ${postPo.mptdeptid == 2 ?  'checked="checked"':'' } onClick="changeRadioType(this)"/>职级
			  				  	   </c:if>
			  				  	   <c:if test="${empty postPo.mptdeptid }" >
			  				  	   		<input name="postPo.mptdeptid" id="mptdeptid" type="radio" value="1"  checked="checked"  onClick="changeRadioType(this)"/>职务
			  				  		  	<input type="radio" id="mptdeptid" name="postPo.mptdeptid" value="2"  onClick="changeRadioType(this)"/>职级
			  				  	   </c:if>
			  				  	   </TD>
			  				  	</TR>
			  				  	<c:if test="${empty postPo.mptparented }" >
			  				  	
			  				  	<TR id="displayID" style="display:none;">
								   <TD width="10%" height="26" class="table_body">所属职务</TD>
					               <TD width="40%" colspan="3" class="table_none">			               	
					               		<select id="mptparented" name="postPo.mptparented" validate="">
					               		<option value="">----请选择----</option>
								  		<c:if test="${not empty(postMaxList)}">
						               	  <s:iterator value="postMaxList">
		                    	           <OPTION value="${mptid}">${mptcontent}</OPTION>
		                    	          </s:iterator>
		                    	        </c:if>
									</select><label style="color:red;">&nbsp;*</label>
					               </TD>
								</TR>
						<tr id="displayID1" style="display:none;">					   
						   <TD width="10%" class="table_body">岗位津贴</TD>
						   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
						   	  <input class="text_input160" type="text" id="mptsalary" name="postPo.mptsalary" value="${postPo.mptsalary }" maxlength="10"><label style="color:red;">&nbsp;*对应工资模版中的岗位津贴</label></TD>
						</tr>
								</c:if>
									
								<tr>					   
								   <TD width="10%" class="table_body">内容</TD>
								   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
								   	  <input class="text_input160" type="text" id="mptcontent" name="postPo.mptcontent" value="${postPo.mptcontent }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
								</tr>

                      </TBODY>
                    </TABLE>
 		
					<TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img  src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  id="submitButton" title='保存' onclick="save();" >
                        	  <!-- <input icon='icon-reload' type="reset" value='清除' > -->
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
                
                  </DIV>
                </DIV>
                  <!--?End--></TD>
                <TD width=1 background=${ctx }/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx }/img/pic/tab_bg.gif" 
width=1></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD background=${ctx }/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 
            src="${ctx }/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>