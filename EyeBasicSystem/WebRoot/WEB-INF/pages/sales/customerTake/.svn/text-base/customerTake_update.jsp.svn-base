<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顾客取镜</title>
</head>
<script>
	function update()
	{
		if(document.getElementById("chk").checked){
			if(checkForm(document.all.postForm)){
				$("img").removeAttr("onclick");
				postForm.action = "insertCustInTranit.action";
				postForm.submit();
			}
		}else{
			$("img").removeAttr("onclick");
			postForm.action =     "insertCustInTranit.action";
			postForm.submit();
		}
	}
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function doSelect(item){	
		if(item.checked){
			document.getElementById("remarkmsg").style.display="block";
			document.getElementById("chkValue").value="1";
		}else{
			document.getElementById("remarkmsg").style.display="none";
			document.getElementById("chkValue").value="";
		}	
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="postForm">
<input type="hidden" name="sales" value="${sales}">
<input type="hidden" name="ssesbMemberId" value="${ssesbMemberId}">
<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
<input type="hidden" name="content" id="content" value="${content}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="10"><td></td></tr>
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 id="title1">
                      <TBODY>                        
                      	<TR>
						   <TD width="60%" height="26">●&nbsp;&nbsp;会员卡号：${ssesbMemberId} 确认取镜?</TD>
						   <TD width="40%">
						   	<input type="checkbox" name="chk" id="chk"  onClick="javascript:doSelect(this)"/>
						   	<input type="hidden" name="chkValue" id="chkValue" value="" />
						   	填写备注信息</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE width="100%" border=0 align=center cellPadding=3 cellSpacing=1 class="Privateborder" id="remarkmsg" style="display:none;">
                      <TBODY>						
                        <TR height="25">
                          <TD width="25%" class="table_body " align="right">姓名</TD>
                          <TD width="75%" class="table_none ">
                           <input class="text_input100" type="text" yyorder="1" id="name" name="name" value=""
			              validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '取镜人姓名不能为空！'}]"/><label style="color:red;">&nbsp;*&nbsp;</label></TD>
					    </TR>
                        <TR height="25">
                        <li class="horizontal_onlyRight">
                          
                          <TD class="table_body " align="right">电话</TD>
                          <TD class="table_none ">
                          <input class="text_input120" type="text" yyorder="7" value="" 
                          id="telphone" name="telphone" maxlength="18" validate="[{'Type' : Type.String, 'Formula' : Formula.TelPhone, 'Message' : '电话格式不正确！'}]"><label style="color:red;">&nbsp;*&nbsp;</label>
                          </TD>																										
					   </TR>
            			<TR height="25">
                          <TD class="table_body " align="right">身份证</TD>
                          <TD class="table_none ">
                           <input class="text_input200" type="text" yyorder="12" value="" maxlength="20" 
                           id="identitycard" name="identitycard" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写身份证！'},{'Type' : Type.String, 'Formula' : Formula.IdentityCard, 'Message' : '请填写正确的身份证格式！'}]">
                           <label style="color:red;">&nbsp;*&nbsp;</label>
                          </TD>
					    </TR> 		        					
 						<TR height="25">
                          <TD class="table_body " align="right">备注</TD>
                          <TD class="table_none ">
                          <textarea id="remark" name="remark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '备注不能大于100字！'}]"></textarea>
      	                  </TD>
						</TR>
                      </TBODY>
                    </TABLE>                 
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
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
                        <TR>
                          <TD><img src="${ctx }/img/newbtn/btn_define_0.png" btn=btn id="submitButton" title='确定' onClick="javascript:update()">
							
                          
                          
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
