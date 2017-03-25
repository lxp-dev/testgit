<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/zone.js"></script>
<title>配置管理</title>
</head>
<script>
	$(document).ready(function() { 
	    $("img[btn=btn]").attr("style","cursor: hand;");
	    $("img[btn=btn]").mouseover(function () { 
	    $(this).attr("src",$(this).attr("src").replace("0","1")); 
	    }).mouseout(function () { 
	      $(this).attr("src",$(this).attr("src").replace("1","0")); 
	    });

	    <c:if test="${configurationPo.wcrkftype eq '2'}" >
		    document.getElementById("displayID").style.display="";
			document.getElementById("wcrkftype").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'微客服URL不能为空！\'}]";
	    </c:if>

    }); 

    function save(){
    	if(checkForm(companyNameForm)){
        	var str = document.getElementById('wcrurl').value;
    		if(str==''){
        		alert("请填写EIMS公网地址！");
        		document.getElementById('wcrurl').focus();
        		return;
        	}else if(str.substring(0,7) !='http://'){
        		alert("请填写以http://开头的网址！");
        		document.getElementById('wcrurl').focus();
				return;
        	}
    		$("img").removeAttr("onclick");
    		companyNameForm.action = "insertWeiXinConfiguration.action?";
    		companyNameForm.submit();
        }
    }

	function configMenu(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initConfigWeixinMenu.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(false),false);
		}else{
			showPopWin("initConfigWeixinMenu.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(false),false);
		}
		document.getElementById('popupTitle').innerHTML="【微信菜单配置】";
	}	

	function dataConfig(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWeixinDataConfigSel.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(false),false);
		}else{
			showPopWin("initWeixinDataConfigSel.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(false),false);
		}
		document.getElementById('popupTitle').innerHTML="【微信数据配置】";
	}	

	function registerDepartment(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWeiXinRegisterDepartmentSelect.action?moduleID=${requestScope.moduleID}",970,screen.height-200,topRows,topCols,returnRefresh(false),false);
		}else{
			showPopWin("initWeiXinRegisterDepartmentSelect.action?moduleID=${requestScope.moduleID}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(false),false);
		}
		document.getElementById('popupTitle').innerHTML="【微信公众号配置】";
	}
		
	function confiDailyAttendance(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWeiDailyAttendanceSel.action?moduleID=${requestScope.moduleID}",400,140,returnRefresh(false),false);
		}else{
			showPopWin("initWeiDailyAttendanceSel.action?moduleID=${requestScope.moduleID}",400,140,topRows,topCols,returnRefresh(false),false);
		}
		document.getElementById('popupTitle').innerHTML="【每日签到积分设定】";
	}

	function insert(){		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initWeiDaijinquanSetInsert.action?moduleID=${requestScope.moduleID}",450,200,topRows,topCols,returnRefresh(false),false);
		}else{
			showPopWin("initWeiDaijinquanSetInsert.action?moduleID=${requestScope.moduleID}",450,200,topRows,topCols,returnRefresh(false),false);
		}
		document.getElementById('popupTitle').innerHTML="【代金券配置】";
	}

	function changeRadioType(obj){    
    	var objValue=obj.value;
    	if(objValue=="1"){  
    		document.getElementById("displayID").style.display="none";  
    		document.getElementById("wcrkfurl").validate="";
    	}else{
    		document.getElementById("displayID").style.display="";
    		document.getElementById("wcrkfurl").validate="[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'URL不能为空！\'}]";
    	}
    }
</script>

<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="companyNameForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}">
<input type="hidden" name="configurationPo.wcrid" value="${configurationPo.wcrid}">
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>微信管理</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：配置管理 </td>
          <td align="right" valign="bottom">&nbsp;
              <img src="${ctx}/img/newbtn/btn_wxgongzhonghao_0.png" btn=btn id="submitButton" title='微信用户注册部门配置' onclick="registerDepartment();">
              <img src="${ctx}/img/newbtn/btn_wxconfigdata_0.png" btn=btn id="submitButton" title='数据配置' onclick="dataConfig();">
              <img src="${ctx}/img/newbtn/btn_wxcdpz_0.png" btn=btn id="submitButton" title='配置菜单' onclick="configMenu();">
              <img src="${ctx}/img/newbtn/btn_mrqdjfsd_0.png" btn=btn id="submitButton" title='每日签到积分设定' onclick="confiDailyAttendance();">
              <img src="${ctx }/img/newbtn/btn_djqpz_0.png" title='代金券配置' btn=btn  onclick="JavaScript:insert();" />
			  <!-- <img src="${ctx}/img/newbtn/btn_weixinViewMenu_0.png" btn=btn id="submitButton" title='预览微信' onclick="view();">  -->
          </td>
        </TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
          <TD class=menubar_function_text align=right>
			<TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
                <TR>
                  <TD class=menubar_button></TD>
                </TR>
              </TBODY>
            </TABLE>
	      </TD>
        </TR>
        </TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
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
                  <fieldset style="border-color:#FF0000">
					<legend style="font-size: 14;color: red">
					<b>[微信公众号信息]</b>
					</legend>
                    <table width="100%" border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>   
                        <TR valign="middle">
                       	<TD width="12%" height="30" class="table_body" align="right">EIMS公网地址</TD>
                       	<TD class="table_none">
                       		<input type="text" class="text_input400" id="wcrurl" name="configurationPo.wcrurl" value="${configurationPo.wcrurl }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写EIMS公网地址！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;需以域名形式填写，必须按照样例格式：http://www.pengshengsoft.com/eims</b></label>
                       	</TD>
                       </TR>  
                        <TR valign="middle">
                       	<TD height="30" class="table_body" align="right">token</TD>
                       	<TD class="table_none">
                       		<input type="text" class="text_input400" name="configurationPo.wcrtoken" value="${configurationPo.wcrtoken }" maxlength="50" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写token！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '请重新填写token！'}]">
                       		<label style="color:red;"><b>&nbsp;*&nbsp;自定义字符串，必须微信公众平台填写的token一致。（默认：pengsheng）</b></label>
                       	</TD>
                       </TR> 			                               					   
                      </TBODY>
                    </TABLE>                    
                  </fieldset> 
                  </br>
                  <fieldset style="border-color:#FF0000">
					<legend style="font-size: 14;color: red">
					<b>[其他配置信息]</b>
					</legend>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title2">
                      <TBODY>  
                       <TR valign="middle">
                       	<TD width="25%" height="30" class="table_body" align="right">注册验证方式</TD>
                       	<TD class="table_none">
                       		<input name="configurationPo.wcrregistertype" id="wcrregistertype" type="radio" value="1" ${(configurationPo.wcrregistertype eq '1') ? 'checked=checked':''}/>短信验证码(推荐)
			  				<input type="radio" id="wcrregistertype" name="configurationPo.wcrregistertype" value="2" ${(configurationPo.wcrregistertype eq '2') ? 'checked=checked':''}/>系统生成验证码
                       	</TD>
                       </TR>   
                       <TR valign="middle">
                       	<TD height="30" class="table_body" align="right">微客服</TD>
                       	<TD class="table_none">
                       		<input name="configurationPo.wcrkftype" id="wcrkftype" type="radio" value="1" onClick="changeRadioType(this)" ${(configurationPo.wcrkftype eq '1') ? 'checked=checked':''}/>微信客服（多客服）
			  				<input type="radio" id="wcrkftype" name="configurationPo.wcrkftype" value="2" onClick="changeRadioType(this)" ${(configurationPo.wcrkftype eq '2') ? 'checked=checked':''}/>第三方客服（如：百度商桥）
                       	</TD>
                       </TR>  
	  				   <TR id="displayID" style="display: none;">
						   <TD height="30" class="table_body" align="right">第三方客服URL</TD>
			               <TD class="table_none">			               	
			               		<input class="text_input500" type="text" id="wcrkfurl" name="configurationPo.wcrkfurl"  maxlength="500" value="${configurationPo.wcrkfurl }"><label style="color:red;">&nbsp;*</label></TD>
			               </TD>
					   </TR>
                       <TR valign="middle">
                       	<TD height="30" class="table_body" align="right">医师评价</TD>
                       	<TD class="table_none">
                       		<input name="configurationPo.wcrpingjiatype" id="wcrpingjiatype" type="radio" value="1" ${(configurationPo.wcrpingjiatype eq '1') ? 'checked=checked':''}/>每人针对一次诊疗信息能评价一次
			  				<input type="radio" id="wcrpingjiatype" name="configurationPo.wcrpingjiatype" value="2" ${(configurationPo.wcrpingjiatype eq '2') ? 'checked=checked':''}/>每人针对一次诊疗信息能评价多次
                       	</TD>
                       </TR>	
                       <TR valign="middle">
                       	<TD height="30" class="table_body" align="right">邀请好友送积分</TD>
                       	<TD class="table_none">
                       		<input name="configurationPo.wcryqhysjftype" id="wcryqhysjftype" type="radio" value="1" ${(configurationPo.wcryqhysjftype eq '1') ? 'checked=checked':''}/>启用（当被邀请人获得第一笔积分时，等值送邀请人积分或福分）
			  				<input type="radio" id="wcryqhysjftype" name="configurationPo.wcryqhysjftype" value="2" ${(configurationPo.wcryqhysjftype ne '1') ? 'checked=checked':''}/>不启用
                       	</TD>
                       </TR> 
                       <TR valign="middle">
                       	<TD height="30" class="table_body" align="right">个人中心底部导航栏是否显示</TD>
                       	<TD class="table_none">
                       		<input name="configurationPo.wcrpersoncenterisshow" id="wcrpersoncenterisshow" type="radio" value="0" ${(configurationPo.wcrpersoncenterisshow ne '1') ? 'checked=checked':''}/>显示
			  				<input type="radio" id="wcrpersoncenterisshow" name="configurationPo.wcrpersoncenterisshow" value="1" ${(configurationPo.wcrpersoncenterisshow eq '1') ? 'checked=checked':''}/>不显示
                       	</TD>
                       </TR>
                       <TR valign="middle">
                       	<TD height="30" class="table_body" align="right">个人中心菜单中我的病例是否显示</TD>
                       	<TD class="table_none">
                       		<input name="configurationPo.wcrmycasehistoryisshow" id="wcrmycasehistoryisshow" type="radio" value="0" ${(configurationPo.wcrmycasehistoryisshow ne '1') ? 'checked=checked':''}/>显示
			  				<input type="radio" id="wcrmycasehistoryisshow" name="configurationPo.wcrmycasehistoryisshow" value="1" ${(configurationPo.wcrmycasehistoryisshow eq '1') ? 'checked=checked':''}/>不显示
                       	</TD>
                       </TR>
                       <TR valign="middle">
                       	<TD height="30" class="table_body" align="right">个人中心首页是显示会员剩余积分还是储值卡余额</TD>
                       	<TD class="table_none">
                       		<input name="configurationPo.wcrjifenorchuzhi" id="wcrjifenorchuzhi" type="radio" value="0" ${(configurationPo.wcrjifenorchuzhi ne '1') ? 'checked=checked':''}/>积分
			  				<input type="radio" id="wcrjifenorchuzhi" name="configurationPo.wcrjifenorchuzhi" value="1" ${(configurationPo.wcrjifenorchuzhi eq '1') ? 'checked=checked':''}/>储值卡
                       	</TD>
                       </TR>                                                                                             					
                      </TBODY>
                    </TABLE>                   
                  </fieldset>
                  </br>
                  <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="submitButton" title='保存' onclick="save();"> 
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
    <TD height=5></TD></TR></TBODY></TABLE></DIV></BODY>

    </html>
<%@ include file="/WEB-INF/inc/message.jsp" %>