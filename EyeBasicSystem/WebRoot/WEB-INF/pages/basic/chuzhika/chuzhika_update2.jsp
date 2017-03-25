<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>储值卡修改</title> 
</head>
<script>
	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
    	
		setPaw();
    	
        $('input[type=text]').bind('blur',function(){
            $(this).val($.trim( $(this).val()));
        });
        
    	$('#cstczknewid').removeAttr('validate');
    	$('#cstczkcardnewpassword').removeAttr('validate');
	});

	function setPaw(){
    	if('${chuzhikaPo.cstczkcardpassword}' != '' && '${chuzhikaPo.cstczkcardpassword}' != null){
    		$("#showpwd").attr("checked","checked");
    		$("#divpwd1").attr("style","");
			$("#cstczkcardpassword").attr("disabled","");
    	}else{
    		$('#cstczkcardpassword').removeAttr('validate');    		
        }
	}


	function selCustomer(type){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action?type="+type,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action?type="+type,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
	}

    function setCustomer1(memberid,name,cphone,cintegral,customerid){
		document.getElementById('cstczkcustomerid').value = customerid;
		document.getElementById('cstczkcustomername').value = name;
	}
	
	function emptyf(){
		document.getElementById('cstczkcustomerid').value = "";
		document.getElementById('cstczkcustomername').value = "";
	}	

	
	function save(){
		if(checkForm(document.all.chuzhikaForm)){  
			if($("#cstczkidcard").val() == ''){
			}else{
				if($("#cstczkidcard").val().length < 15){
					alert("身份证位数不足！");
					$("#cstczkidcard").val('');
					$("#cstczkidcard").focus();
					return;
				}
			}
		
		    $("img").removeAttr("onclick");
			chuzhikaForm.action = "chuzhikaUpdate2.action";
			chuzhikaForm.submit();
		}
	}
	
	function showpwdinput(){
		if($("#showpwd").attr("checked")){
			$("#divpwd1").attr("style","");
			$("#cstczkcardpassword").attr("disabled","");
			$('#cstczkcardpassword').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写储值卡密码！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Word, \'Message\' : \'密码应为数字或字母！\'}]");
		}else{
			$("#divpwd1").attr("style","display: none");
			$("#cstczkcardpassword").attr("disabled","disabled");
			$("#cstczkcardpassword").val('');
			$('#cstczkcardpassword').removeAttr('validate'); 
		}
	}
	
	function shownewpwdinput(){
		if($("#shownewpwd").attr("checked")){
			$("#divnewpwd").show();
			$('#cstczkcardnewpassword').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写储值卡密码！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Word, \'Message\' : \'密码应为数字或字母！\'}]");
		}else{
			$("#divnewpwd").hide();
			$("#cstczkcardnewpassword").val('');
	    	$('#cstczkcardnewpassword').removeAttr('validate');
		}
	}
	
	function show(){
		if($('#ischangecard').attr('checked')){
			$('#showtr1').show();
			$('#cstczknewid').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写储值卡号！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Word, \'Message\' : \'储值卡号应为数字或字母！\'}]");
			if($("#shownewpwd").attr("checked")){
			    $('#cstczkcardnewpassword').attr("validate","[{\'Type\' : Type.String, \'Formula\' : Formula.notNull, \'Message\' : \'请填写储值卡密码！\'},{\'Type\' : Type.String, \'Formula\' : Formula.Word, \'Message\' : \'密码应为数字或字母！\'}]");
			}
		}else{
			$('#showtr1').hide();
	    	$('#cstczknewid').removeAttr('validate');
	    	$('#cstczkcardnewpassword').removeAttr('validate');
	    	$("#cstczknewid").val('');
	    	$("#cstczkcardnewpassword").val('');		
		}
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="chuzhikaForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" id="moduleID" name="moduleID" value="${requestScope.moduleID}" >

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><br/>
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
						    <TD width="8%" height="26" class="table_body">储值卡号</TD>
			                <TD width="25%" class="table_none">
	                            ${chuzhikaPo.cstczkcardid}
	                            <input type="hidden"  name="chuzhikaPo.cstczkid" value="${chuzhikaPo.cstczkid}" />	
			               	</TD>
                            <TD width="8%" class="table_body">
							   	储值金额
						    </TD>
			                <TD width="20%" class="table_none">
			                	${chuzhikaPo.cstczkjine}	                
			                </TD>
			               	<TD width="8%" class="table_body">发放部门</TD>
			               	<TD class="table_none" valign="middle">
	                            <select id="cstczkshopcode" name="chuzhikaPo.cstczkshopcode">
	      		                 	<option value="">-----请选择----</option>
	      		                 	<c:forEach var="po" items="${departmentsList}" >
	      		                 		<OPTION value="${po.bdpdepartmentid}" ${(po.bdpdepartmentid eq chuzhikaPo.cstczkshopcode) ? ' selected':''}>${po.bdpdepartmentname}</OPTION>                                     	
									</c:forEach> 
      	                   		</select>			               	               	
                            </TD>			                                            
			            </TR>
			            <TR>
						    <TD class="table_body">绑定会员</TD>
			                <TD class="table_none">
                            	<li class="horizontal_onlyRight">
									<input class="text_input160" type="hidden" yyorder="12" id="cstczkcustomerid" maxlength="20" name="chuzhikaPo.cstczkcustomerid" value="${chuzhikaPo.cstczkcustomerid }">
									<input class="text_input60" readOnly="readOnly" id="cstczkcustomername" name="chuzhikaPo.cstczkcustomername" value="${chuzhikaPo.cstczkcustomername }">
								</li>
								<li class="horizontal_onlyRight"><img id="submitButton" btn=btn src="${ctx}/img/newbtn/btn_search_0.png" title='查询' onClick="selCustomer('1');"></li>
								<li class="horizontal_onlyRight"><img id="submitButton" btn=btn src="${ctx}/img/newbtn/btn_empty_0.png" title='清空' onClick="emptyf();"></li>
			                </TD>
			                <TD class="table_body">身份证</TD>
			                <TD class="table_none" valign="middle">
                            	<input class="text_input200" type="text" id="cstczkidcard" maxlength="18" value="${chuzhikaPo.cstczkidcard}" name="chuzhikaPo.cstczkidcard" validate="[{'Type' : Type.String, 'Formula' : Formula.IdentityCardORNULL, 'Message' : '请按正确的身份证格式填写！'}]">
                            </TD>
						    <TD class="table_body">
							    <input type="checkbox" id="showpwd" onclick="showpwdinput();"/>设置密码
						    </TD>
			                <TD class="table_none">
			                	<div id="divpwd1" style="display: none;"><input class="text_input160" id="cstczkcardpassword" maxlength="10" value="${chuzhikaPo.cstczkcardpassword}" type="text" name="chuzhikaPo.cstczkcardpassword" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请填写储值卡密码！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '密码应为英文或数字！'}]"></div>
			                </TD>
			             </TR>
			             <TR>
						    <TD height="26" class="table_body">备注</TD>
			                <TD class="table_none" colspan="5">
			                	<textarea id="cstczkremark" name="chuzhikaPo.cstczkremark" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [200]}, 'Message' : '备注不能大于200字符'}]">${chuzhikaPo.cstczkremark}</textarea>
			               </TD>
			             </TR>
	                       </TBODY>
	                    </table>
                    	</div>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          <img id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn  title='保存' onclick="save();">
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