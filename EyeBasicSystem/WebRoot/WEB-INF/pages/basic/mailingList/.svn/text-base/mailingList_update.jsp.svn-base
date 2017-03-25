<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息维护</title>
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

	function clean(){
		printBillTemplateForm.reset();

        $('#bftsalestype').removeAttr('noValidate');
        $('#bftsalestype').removeAttr('disabled');
        $('#bftsalestype').val('');
	}
	
	function save(){
	    if(checkForm(printBillTemplateForm)){	  
       		  
		    $('img').removeAttr("onclick"); 
		    printBillTemplateForm.action = "updateMailingList.action";
		    printBillTemplateForm.submit();
		}
	}



	function changeBillTemplateType(obj){

        if (obj.value == '1'){
            $('#bftsalestype').removeAttr('noValidate');
            $('#bftsalestype').removeAttr('disabled');
            $('#bftsalestype').val('');
        }else if (obj.value == ''){
            $('#bftsalestype').val('');
        }else{
            $('#bftsalestype').attr('disabled','disabled');
            $('#bftsalestype').attr('noValidate','noValidate');
            $('#bftsalestype').val('');
        }
    }
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>	
<DIV>
<form name="printBillTemplateForm" method="post" action="" >
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">


<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <tr height="20"><td></td></tr>
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
						   <TD width="5%" height="26" class="table_body">邮寄单名称 </TD>
			               <TD class="table_none" width="10%">
			               <input id="btmlid" name="mailingListPo.btmlid" value="${mailingListPo.btmlid}" type="hidden"  />
                              <input id="btmlname" name="mailingListPo.btmlname" value="${mailingListPo.btmlname}" clean="clean" type="text" class="text_input160" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写邮寄单名称!'}]"/>
                              <label style="color:red;">&nbsp;*</label>
			              </TD>		
						   <TD width="5%" height="26" class="table_body">报表文件名称 </TD>
			               <TD class="table_none" width="10%">
                              <input id="btmlreportname" name="mailingListPo.btmlreportname" value="${mailingListPo.btmlreportname}" clean="clean" type="text" class="text_input160" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写报表文件名称!'}]"/>
                              <label style="color:red;">&nbsp;*</label>
			              </TD>		
			              <TD width="5%" height="26" class="table_body">寄件公司 </TD>
			               <TD class="table_none" width="12%">
                              <input id="btmlcompany" name="mailingListPo.btmlcompany" value="${mailingListPo.btmlcompany}" clean="clean" type="text" class="text_input160" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写寄件公司!'}]"/>
                              <label style="color:red;">&nbsp;*&nbsp;</label>
			              </TD>				              
                        </TR>
                        <TR>
						   <TD width="5%" height="26" class="table_body">地址 </TD>
			               <TD class="table_none" width="10%" colspan="5">
                              <input id="btmladdress" name="mailingListPo.btmladdress" value="${mailingListPo.btmladdress}" clean="clean" type="text" class="text_input240" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写地址!'}]"/>
                               <label style="color:red;">&nbsp;*</label>
			              </TD>			              
                        </TR>
                        <TR>
						   <TD width="5%" height="26" class="table_body">区号 </TD>
			               <TD class="table_none" width="10%">
                              <input id="btmlareacode" name="mailingListPo.btmlareacode" maxlength="5" value="${mailingListPo.btmlareacode}" clean="clean" type="text" class="text_input160" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写区号!'},{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '区号格式错误！'}]"/>
                              <label style="color:red;">&nbsp;*</label>
			              </TD>		
						   <TD width="5%" height="26" class="table_body">联系电话 </TD>
			               <TD class="table_none" colspan="3">
                              <input id="btmlphone" name="mailingListPo.btmlphone" value="${mailingListPo.btmlphone}" maxlength="18" clean="clean" type="text" class="text_input160" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写联系电话!'},{'Type' : Type.String, 'Formula' :  Formula.PhoneORNULL, 'Message' : '联系电话格式错误！'}]"/>

                              <label style="color:red;">&nbsp;*</label>
			              </TD>		
			              
                        </TR>
                  
                        <TR>
						   <TD width="5%" height="26" class="table_body">备注说明</TD>
			               <TD class="table_none" width="50%" colspan="5">
			                  <textarea clean=clean id="btmlremark" name="mailingListPo.btmlremark" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [50]}, 'Message' : '说明内容不能超过50字！'}]" >${mailingListPo.btmlremark}</textarea>
			                  <label style="color:red;">&nbsp;</label>
			               </TD>						
                        </TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                       <TR>
                          <TD align="left">
                          		<input type="checkbox" id="btmluseflag" name="mailingListPo.btmluseflag" value="1" ${mailingListPo.btmluseflag!= '1'  ? '' : 'checked="checked"' }>启用当前样式
                          </TD>
					   </TR>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save()">
                        	  <img src="${ctx }/img/newbtn/btn_reset_0.png" btn=btn title='重置' onClick="clean()">
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