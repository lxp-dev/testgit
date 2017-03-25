<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行维护</title>
<script>
	$(document).ready(function() {
		
	
        $("input:text")[0].focus();
        
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () 
		{
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	   	
	});

	function save(){
		if(checkForm(postForm))
		{
			$("img").removeAttr("onclick");
			postForm.action = "insertBankPo.action";
			postForm.submit();
		}
	}
	function clean(){
		document.getElementById('mptno').value = "";
		document.getElementById('mptname').value = "";
	} 
</script>
</head>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="postForm">
<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
    <br/>
    
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <TR>
						   <TD width="8%" height="26" class="table_body">类型编号</TD>
			               <TD width="24%" class="table_none"><input class="text_input100"   value="${bankPo.bbnumber}" name="bankPo.bbnumber" id="bbnumber" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '银行编号不能为空！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '银行编号只允许输入整数和字母！'}]"><label style="color:red;">&nbsp;*</label></TD>
						
						  <TD width="8%" height="26" class="table_body">类型名称</TD>
                          <TD width="24%" class="table_none"><input class="text_input160" value="${bankPo.bbname}" name="bankPo.bbname" id="bbname"  maxlength="20" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '银行名称不能为空！'}]"><label style="color:red;">&nbsp;*</label></TD>
			              <TD width="8%" height="26" class="table_body">所属分类</TD>
                          <TD width="24%" class="table_none">	                          
                              <select id="bbtype" name="bankPo.bbtype" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请选择所属分类！'}]">
	                              <option value="" ${bankPo.bbtype eq '' ? 'selected="selected"' : '' }>----请选择----</option>
	                              <option value="2" ${bankPo.bbtype eq '2' ? 'selected="selected"' : '' }>银行卡</option>
	                              <option value="9" ${bankPo.bbtype eq '9' ? 'selected="selected"' : '' }>其他</option>
	                          </select>&nbsp;&nbsp;
<!-- 	                          <input type="checkbox" id="bbstatistics" name="bankPo.bbstatistics" value="1" ${bankPo.bbstatistics eq '1' ? 'checked="checked"' : '' }>&nbsp;参与业绩统计 -->
                              <label style="color:red;">&nbsp;*</label>
                          </TD>
                          
			            </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onClick="save()">	
						 	<!-- <input icon='icon-reload' type='button' value='清空' onClick="clean()"> -->
							  
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
    </BODY>
</html>
<%@ include file="/WEB-INF/inc/message.jsp" %>