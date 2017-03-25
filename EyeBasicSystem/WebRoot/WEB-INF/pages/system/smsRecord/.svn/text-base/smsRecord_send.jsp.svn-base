<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>短信记录管理</title>
</head>
<script>
	function reSend()
	{
		if(checkForm(document.all.postForm))
		{
			if($('input[name=sendContent]:checked').val()==1 && $('newSendContent').val()==''){
		            alert("发送内容不能为空！");
		            return;
		    }
			$("img").removeAttr("onclick");
			postForm.action = "insertReSendMessage.action";
			postForm.submit();
			showLoadingBar();
		}
	}

	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerForm.action=link;
	  	customerForm.submit();		
		showLoadingBar();
	}
	
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function isNewSendContent(){
		 if($('input[name=sendContent]:checked').val()==0){
	            $('#sendContentNew').hide();
	        }
		 if($('input[name=sendContent]:checked').val()==1){
	            $('#sendContentNew').show();
	        }
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form action="" method="post" name="postForm">
<input type="hidden" name="fsrreceiptpersont" value="${fsrreceiptpersont}">
<input type="hidden" name="fsrreceipttelt" value="${fsrreceipttelt}">
<input type="hidden" name="fsrbegindate" value="${fsrbegindate}">
<input type="hidden" name="fsrenddate" value="${fsrenddate}">
<input type="hidden" name="fsrsendpersont" value="${fsrsendpersont}">
<input type="hidden" name="fsrsendpersonnamet" value="${fsrsendpersonnamet}">
<input type="hidden" name="fsrsendflagt" value="${fsrsendflagt}">
<input type="hidden" name="fsrsendtypet" value="${fsrsendtypet}">

<input type="hidden" value="${moduleID }" name="moduleID" id="moduleID" />
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
                          <TD height="26" class="table_body" width="20%">短信内容</TD>
                          <TD class="table_none">                         
                            <input type="radio" value="0" onclick="isNewSendContent(this);" id="sendContent0" name="sendContent" checked="checked">
                           		原内容
                           	<input type="radio" value="1" onclick="isNewSendContent(this);" id="sendContent1" name="sendContent">
                           		重新设定发送内容
                          </TD>
                        </TR>                       
                        <TR id="sendContentNew" style="display: none;">
                          <TD height="26" class="table_body" width="20%">新短信内容</TD>
                          <TD class="table_none">                         
                            <textarea name="newSendContent" id="newSendContent" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [500]}, 'Message' : '短信内容不能大于500字符'}]"></textarea>
                          </TD>
                        </TR>                                          
                      	<TR>
						   <TD width="95%" height="26" colspan="2">						   
						   		待发送短信共 ${count }条，是否确定重发送短信？
						   </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=title2 cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx }/img/newbtn/btn_define_0.png" btn=btn id="submitButton" title='确定' onClick="javascript:reSend()">												                         
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->
					<table id="loadingBar" width="100%" STYLE="display:none">
					  <tr><td height="10">&nbsp;</td></tr>
					  <tr>                         
					    <td style="padding-top:5px; padding-left:5px;padding-right:5px;" >
					    <div STYLE="padding-left:5px;border:1px dashed #000;"><img src="${ctx}/img/sys/loading.gif" border="0" width="50"/>正在进行查询，由于数据量较大可能需要较长时间，请耐心等候...</div>
						<script>
							function showLoadingBar(){
								gPopupMask.style.height=theBody.scrollHeight+107+"px";gPopupMask.style.width=theBody.scrollWidth+"px";gPopupMask.style.display = "block";
								document.getElementById("loadingBar").style.display="";
							}
						</script>                            
					    </td>
					</tr>
					</table>                      
					<!-- Loading Bar ----------------------------------------------------------------------------------------------------------------->                	
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
