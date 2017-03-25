<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>折扣设置</title>
</head>
<script>	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
    	$('#fmdmaxdiscount').focus();
	});

	function save(){
		if(checkForm(maxDiscountFrm)){	
			 var fmdmaxdiscount= parseFloat(document.getElementById("fmdmaxdiscount").value);
			    if(fmdmaxdiscount>1||fmdmaxdiscount<0){
			      alert('折扣必须在0-1之间');
			      document.getElementById("fmdmaxdiscount").focus();
			      return false;
			    }	    
			$("img").removeAttr("onclick");
			maxDiscountFrm.action = "updateBatchMemberManagementDiscountSet.action";
			maxDiscountFrm.submit();
		}
	}
	$(document).ready(function(){
		$('#fmdmaxdiscount').bind("keyup",function(){	
			$('#fmdmaxdiscount').val(
				$('#fmdmaxdiscount').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
	});
	function yzZheKou(){
		var vl=$('#fmdmaxdiscount').val();
		b=".";
		if(ReplaceDemo(vl)>1){
			alert("折扣有问题,请重新输入！");
			$('#fmdmaxdiscount').focus();
			$('#fmdmaxdiscount').select();
			return;
		}
		var indexNum=vl.indexOf(".");
		
		if(indexNum==0){
			vl=0+vl;
			$('#fmdmaxdiscount').val(vl)
		}
		
	}
 function ReplaceDemo(ss){ 
		   var r, re;   
		   var strlength = ss.length; 
		   //alert(strlength); 
		   re = /\./;        // 创建正则表达式模式。 
		   while(re.test(ss)){ 
		  ss = ss.replace(re, "");   
		   }  
		   return (strlength-ss.length); 
		} 
</script>

<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="maxDiscountFrm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 

<input type="hidden" name="moduleID" value="${requestScope.moduleID}">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif></TD></TR>
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
                                  <TD width="5%"><div><img src="${ctx}/img/pic/DetailInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
				   <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
                        <tr>
							<TD width="15%" height="26" class="table_body">折扣</TD>
                          	<TD class="table_none">
                          	   <input id="fmdid" class="text_input160" name="memberManagementDiscountPo.fmdid" value="${hid }" type="hidden"/>
                          	   <input class="text_input100" onblur="yzZheKou();" id="fmdmaxdiscount" name="memberManagementDiscountPo.fmddiscount" value="${memberManagementDiscountPo.fmddiscount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写折扣！'}]" maxlength="5">&nbsp;折&nbsp;&nbsp;&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
                          	</TD>
                        </tr>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="submitButton" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
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