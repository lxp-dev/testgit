<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  include file="/commons/allcommons.jsp" %>
<%@  taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>配镜单维护</title>
</head>
<script>	
	function doList(link,perPage_Select,perPage_Text_Hidden){
     	var objOne = document.all[perPage_Select];
	  	document.all[perPage_Text_Hidden].value = objOne.options[objOne.selectedIndex].value;
	  	customerInfoForm.action=link;
	  	customerInfoForm.submit();
	}
	/*修改事件  */
	function updateState(id){
		if(checkForm(document.all.doorStoreDeliveryForm)){
				if($('input[name=ssesbsalesid]:checked').length==0){
					alert("请选择修改配镜单号!");
					return;
				}	
		}
		//document.all.hid.value = id;
		//document.all.submitButton.disabled="true";
		//doorStoreDeliveryForm.action = "updateDoorStoreDelivery.action";
		//doorStoreDeliveryForm.submit();
	}
	function save(){
		if(checkForm(delayWarningForm)){
			$("img").removeAttr("onclick");
			delayWarningForm.action = "insertDelayWarning.action";
			delayWarningForm.submit();
		}
	}

	function permissionMessage(){
       alert('您无此操作权限');
	}

	
	/**
	 *  checkbox全选
	 */	
	function chkAll(){
        var chk=$("input[id=chk]");
        var chks=$("#chks");
        var ischeck = chks.attr("checked");
        chk.each(function (){
        	$(this).attr("checked",ischeck);
        });
    }
</script>
<body>
<form name="delayWarningForm" method="post" action="">
<input type="hidden" name="hid">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="S1101">
<input type="hidden" name="customerID" value="">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
          <TR>
            <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>基础信息维护</TD>
            <TD align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：预误期提醒设定</TD>
          </TR>
          <TR>
            <TD class=menubar_function_text colspan="3"><Table></Table></TD>
          </TR>
          <TR>
            <TD height=20></TD>
          </TR>
        </TBODY>
      </TABLE>
      <!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 1px" 
          background=${ctx}/img/pic/tab_bg.gif>
				</TD></TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 5px; HEIGHT: 100px" 
                vAlign=top>
                
                <DIV id=tabContent__1>
                
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
                          <TD width="15%" height="26" class="table_body">距取镜时间</TD>
                          <TD width="85%" class="table_none">
                          <input type="hidden" name="delayWarningPo.bdwuuid" value="${delayWarningPo.bdwuuid }"/>
                            <input class="text_input120" type="text" id="bdwwarningdate" name="delayWarningPo.bdwwarningdate" value="${delayWarningPo.bdwwarningdate }" validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '只能为整数！'}]" >&nbsp;&nbsp;天提醒
                          </TD>
                        </TR> 
                        <TR>
                        <TD height="26" class="table_body">配镜单状态</TD>
                        <TD class="table_none" colspan="3">
                        	<input id="chks" type=checkbox onclick="chkAll()">
                            	全选<br/>
                          	<input id="chk" type=checkbox name='delayWarningPo.bdwpmf' value='1' ${delayWarningPo.bdwpmf != '1' ? '':'checked' }>
                            	已配送没有发料
                            <input id="chk" type=checkbox name='delayWarningPo.bdwfmj' value='1' ${delayWarningPo.bdwfmj != '1' ? '':'checked' }>
                            	已发料没有加工
                            <input id="chk" type=checkbox name='delayWarningPo.bdwjmj' value='1' ${delayWarningPo.bdwjmj != '1' ? '':'checked' }>
                            	已加工没有检验
                            <input id="chk" type=checkbox name='delayWarningPo.bdwjmp' value='1' ${delayWarningPo.bdwjmp != '1' ? '':'checked' }>
                            	已检验没有配送
                            <input id="chk" type=checkbox name='delayWarningPo.bdwwsmf' value='1' ${delayWarningPo.bdwwsmf != '1' ? '':'checked' }>
                            	委外订单已收货未发料<br/>
                            <input id="chk" type=checkbox name='delayWarningPo.bdwwsmp' value='1' ${delayWarningPo.bdwwsmp != '1' ? '':'checked' }>
                            	委外订单已收货未配送
                        </TD>
					  	</TR>
                      </TBODY>
                    </TABLE>
                    <table id="title2" cellspacing="2">
						   <TR>
							 <TD height="30" valign="bottom">
							 	<img src="${ctx}/img/newbtn/btn_save_0.png" onmouseover="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_1.png');" 

onmouseout="JavaScript:$(this).attr('src','${ctx }/img/newbtn/btn_save_0.png');" id="submitButton" title='保存' onclick="save()">
                            </TD>
						   </TR>
					</table>
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
