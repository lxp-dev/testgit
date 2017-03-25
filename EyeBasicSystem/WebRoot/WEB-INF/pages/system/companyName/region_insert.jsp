<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='${ctx }/js/module/autocomplete.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/thickbox-compressed.js'></script>
<script type='text/javascript' src='${ctx }/js/jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="${ctx }/css/module/jquery.autocomplete.css" />
<style type="text/css">
    img{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);}
    /* #sysLogo{ position:absolute; z-index:12; filter:alpha(opacity:0); opacity:0;} */
    
.input_text{ width:398px; margin-right:8px; border:1px solid #e0dfde; padding-left:4px; height:30px; line-height:30px;}
.input_file{width:72px; margin-left:-76px; filter:alpha(opacity=0); opacity:0; height:30px;}
.input_file_button{ height:30px; width:67px;}

</style>
<title>区域维护</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;"); 
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    }); 
	}); 	

	function insert(){
		if(checkForm(document.all.regionForm)){			    
       		$("img").removeAttr("onclick");     		
			regionForm.action = "insertRegion.action";
			regionForm.submit();
		}
	}
	
	function checkSupplierId(thiz){
		$(thiz).val($(thiz).val().toUpperCase());
	}
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="regionForm" method="post" action="" enctype="multipart/form-data">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" value="2" name="dengji" id="dengji" />
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <tr height="20"><td></td></tr>
        <TR>
		    <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" background=${ctx}/img/pic/tab_bg.gif></TD>					
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
                                  <TD width="5%"><div align="left"><img src="${ctx}/img/pic/queryInfo.gif" width="86" height="20" ></div></TD>
                                  <TD width="95%" background="${ctx}/img/pic/msgbg.png" >&nbsp;</TD>
                                </TR>
                              </TBODY>
                            </TABLE>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
			           <TR>
			           	  <TD height="26" class="table_body " align="right">区域ID</TD>
                          <TD class="table_none ">
                            <input class="text_input240"  id="fcnName" onkeyup="checkSupplierId(this);" name="companyNamePo.fcnjrid" maxlength="4" value="${companyNamePo.fcnjrid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写区域ID！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '区域ID只允许输入整数和字母！'}]">
                          </TD>
                          <TD height="26" class="table_body " align="right">区域名称</TD>
                          <TD class="table_none ">
                            <input class="text_input240"  id="fcnName"  name="companyNamePo.fcnjrname" maxlength="20" value="${companyNamePo.fcnjrname}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写区域名称！'}]">
                          </TD>
					   </TR> 
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="insert();">
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></form></BODY></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>
