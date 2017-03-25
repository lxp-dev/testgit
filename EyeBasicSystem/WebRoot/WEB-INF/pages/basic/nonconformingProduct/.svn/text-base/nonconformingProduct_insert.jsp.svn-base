<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>不合格品现象维护</title>
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	$('#fnpcontent').focus();
	});
	
		
		
	function save(){
		if(checkForm(nonconformingProductForm)){
			$("img").removeAttr("onclick");
			nonconformingProductForm.action = "insertNonconformingProduct.action";
			nonconformingProductForm.submit();
		}
	}
	
	function changeRadioType(obj){    
    	var objValue=obj.value;
    	if(objValue=="1"){  
    		document.getElementById("displayID").style.display="none";  
    		document.getElementById("fnpparented").validate="";    		
    	}else{
    		document.getElementById("displayID").style.display="";
    		document.getElementById("fnpparented").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'所属原因不能为空！\'}]";  		
    	}
    }
	
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="nonconformingProductForm" method="post" action="">
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
					               <c:if test="${not empty nonconformingProductPo.fnpdeptid }" >
							   			<input name="nonconformingProductPo.fnpdeptid" id="fnpdeptid" type="radio" value="1"  ${nonconformingProductPo.fnpdeptid == 1 ?  'checked="checked"':'' }   onClick="changeRadioType(this)"/>原因
			  				  		  	<input type="radio" id="fnpdeptid" name="nonconformingProductPo.fnpdeptid" value="2" ${nonconformingProductPo.fnpdeptid == 2 ?  'checked="checked"':'' } onClick="changeRadioType(this)"/>现象
			  				  	   </c:if>
			  				  	   <c:if test="${empty nonconformingProductPo.fnpdeptid }" >
			  				  	   		<input name="nonconformingProductPo.fnpdeptid" id="fnpdeptid" type="radio" value="1"  checked="checked"  onClick="changeRadioType(this)"/>原因
			  				  		  	<input type="radio" id="fnpdeptid" name="nonconformingProductPo.fnpdeptid" value="2"  onClick="changeRadioType(this)"/>现象
			  				  	   </c:if>
			  				  	   </TD>
			  				  	</TR>
			  				  	<c:if test="${empty nonconformingProductPo.fnpparented }" >
			  				  	
			  				  	<TR id="displayID" style="display:none;">
								   <TD width="10%" height="26" class="table_body">所属原因</TD>
					               <TD width="40%" colspan="3" class="table_none">			               	
					               		<select id="fnpparented" name="nonconformingProductPo.fnpparented" validate="">
					               		<option value="">----请选择----</option>
								  		<c:if test="${not empty(nonconformingProductMaxList)}">
						               	  <s:iterator value="nonconformingProductMaxList">
		                    	           <OPTION value="${fnpid}">${fnpcontent}</OPTION>
		                    	          </s:iterator>
		                    	        </c:if>
									</select><label style="color:red;">&nbsp;*</label>
					               </TD>
								</TR>
								</c:if>
								<c:if test="${not empty nonconformingProductPo.fnpparented }" >
			  				  	
			  				  	<TR id="displayID" style="display: ;">
								   <TD width="10%" height="26" class="table_body">所属原因</TD>
					               <TD width="40%" colspan="3" class="table_none">			               	
					               		<select id="fnpparented" name="nonconformingProductPo.fnpparented" validate="">
					               		<option value="">----请选择----</option>
								  		<c:if test="${not empty(nonconformingProductMaxList)}">
						               	  <s:iterator value="nonconformingProductMaxList">
		                    	           <OPTION value="${fnpid}" ${nonconformingProductPo.fnpparented == fnpid ?  'selected="selected"':'' } >${fnpcontent}</OPTION>
		                    	          </s:iterator>
		                    	        </c:if>
									</select><label style="color:red;">&nbsp;*</label>
					               </TD>
								</TR>
								</c:if>
								
								<tr>					   
								   <TD width="10%" class="table_body">内容</TD>
								   <TD width="40%" height="26" align="left" colspan="3" class="table_none">
								   	  <input class="text_input160" type="text" id="fnpcontent" name="nonconformingProductPo.fnpcontent" value="${nonconformingProductPo.fnpcontent }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '内容不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
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