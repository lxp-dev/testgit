<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="${ctx }/js/zone.js"></script>
<title>会员管理</title>
</head>
<script>
	function save(){
		if(checkForm(document.all.creditCardAccountFeesForm)){
		
			if(document.getElementById('smecicardid').value==''){
				alert('请添加检查充值卡号！');
				return;
		     }
	    $("img").removeAttr("onclick");
		creditCardAccountFeesForm.action = "insertCreditCardAccountFees.action";
		creditCardAccountFeesForm.submit();
		}
	}

	var s = '';
	var opt0 = ["省份","地级市","市、县级市、县"];
	
	window.onload=function() {
		document.getElementById('smeciname').focus();  
		s = new Array();
		s[0] = document.getElementById("zone1");
		s[1] = document.getElementById("zone2");
		s[2] = document.getElementById("zone3");

		for(i=0;i<s.length-1;i++){
			s[i].onchange=new Function("change("+(i+1)+")");
		}
		
		change(0);
		document.getElementById("zone1").selectedIndex = 26;
		change(1);
		document.getElementById("zone3").selectedIndex = 2;
		
		//回车
		$(':input[yyorder]').each(function(){
				$(this).unbind("keydown");
				$(this).keydown(function(){
					if(event.keyCode == 13){
						var index=$(this).attr('yyorder');
						$(':input[yyorder='+accAdd(index,1)+']').focus();
					}
				});
			});
		
	};
	
	/*充值金额*/
	function dianji1(){
		document.getElementById("smeciamount").value="50.00";
		document.getElementById("smeciavailableamount").value="50.00";
		
	}
	function dianji2(){
		document.getElementById("smeciamount").value="100.00";
		document.getElementById("smeciavailableamount").value="100.00";
	}
	function dianji3(){
		document.getElementById("smeciamount").value="200.00";
		document.getElementById("smeciavailableamount").value="200.00";
	}
	
	/*失焦事件*/
	function isNumber(){
	
		var smeciavailableamount=document.getElementById("smeciamount").value;
		if(!isNaN(smeciavailableamount)&&smeciavailableamount!=''){
			document.getElementById("smeciavailableamount").value=parseFloat(smeciavailableamount).toFixed(2);
		}
				var validate={
			num : function(obj){	
				var	valueO = obj.value;
				obj.value = obj.value.replace(/^[^1-9][0-9]*/g,'');
			},
			dotNum : function(obj){
				obj.value = obj.value.replace(/[^0-9.][0-9]*/g,'');
			}, 
			bcc : function(obj){
				obj.value = obj.value.replace(/[^-0-9.][0-9]*/g,'');
			},
			level : function(obj){
				if(/^[\+\-]/.test(obj.value)){
					obj.value = obj.value.substring(0,1) + obj.value.replace(/[^0-9]/g,'');
				}else{
					obj.value = obj.value.replace(/[^0-9]/g,'');
				}
				//obj.value = obj.value.replace(/^[^\+-]|[^\d]*$/,'');
			}
		};
		
			$(this).ready(function(){
				$('#aca').bind('keyup',function(){
					validate.dotNum($('#aca').get(0))
				});
				
				$('#smeciavailableamount').bind('blur',function(){
					if($('#aca').val() != ''){
						$('#aca').val(parseFloat($('#aca').val()).toFixed(2));
						this.style.backgroundColor="";
					}
				});
				
				
				$('input[id=smeciavailableamount]').each(function(){
					($(this).get(0)).maxLength='7';
					$(this).bind('keyup',function(){
						validate.dotNum($(this).get(0));
					});
					
				});
				
				$('input[id=smeciavailableamount]').each(function(){
					$(this).bind('blur',function(){
					if($(this).val()!=''){
							$(this).val(parseFloat($(this).val()).toFixed(2));
							}
					});
				});
				
				
				$('input[id=validateLevel]').each(function(){
					($(this).get(0)).maxLength='7';
					$(this).bind('keyup',function(){
						validate.dotNum($(this).get(0));
					});
				});
				
				if('${readOnly}'=='readOnly'){
					$('#smecimemberid').attr("readonly","readonly");
				}
			});
	}
	
	/*补零事件*/
	
var validate={
	num : function(obj){	
		var	valueO = obj.value;
		obj.value = obj.value.replace(/^[^1-9][0-9]*/g,'');
	},
	dotNum : function(obj){
		obj.value = obj.value.replace(/[^0-9.][0-9]*/g,'');
	}, 
	bcc : function(obj){
		obj.value = obj.value.replace(/[^-0-9.][0-9]*/g,'');
	},
	level : function(obj){
		if(/^[\+\-]/.test(obj.value)){
			obj.value = obj.value.substring(0,1) + obj.value.replace(/[^0-9]/g,'');
		}else{
			obj.value = obj.value.replace(/[^0-9]/g,'');
		}
		//obj.value = obj.value.replace(/^[^\+-]|[^\d]*$/,'');
	}
};

	$(this).ready(function(){
		$('#aca').bind('keyup',function(){
			validate.dotNum($('#aca').get(0))
		});
		
		$('#smeciavailableamount').bind('blur',function(){
			if($('#aca').val() != ''){
				$('#aca').val(parseFloat($('#aca').val()).toFixed(2));
				this.style.backgroundColor="";
			}
		});
		
		
		$('input[id=smeciamount]').each(function(){
			($(this).get(0)).maxLength='7';
			$(this).bind('keyup',function(){
				validate.dotNum($(this).get(0));
			});
			
		});
		
		$('input[id=smeciamount]').each(function(){
			$(this).bind('blur',function(){
			if($(this).val()!=''){
					$(this).val(parseFloat($(this).val()).toFixed(2));
					}
			});
		});
		
		
		$('input[id=validateLevel]').each(function(){
			($(this).get(0)).maxLength='7';
			$(this).bind('keyup',function(){
				validate.dotNum($(this).get(0));
			});
		});
		
		if('${readOnly}'=='readOnly'){
			$('#smecimemberid').attr("readonly","readonly");
		}
		
	});
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="creditCardAccountFeesForm" method="post" action="">
<input type="hidden" name="type" id="type" value="" /> 
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>会员管理</TD>
                    <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD>
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text height=27><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：会员新增</TD>
                      <TD class=menubar_function_text align=right>
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                    </TABLE>
			</TD></TR>
        <TR>
          <TD colSpan=2 height=5></TD></TR></TBODY></TABLE><!-- ?? End --><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" 
          background=${ctx}/img/pic/tab_top_bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR><!--?Start-->
                <TD>
                  <TABLE height=22 cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=3><IMG id=tabImgLeft__0 height=22 
                        src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                      <TD class=tab id=tabLabel__0 
                      background=${ctx}/img/pic/tab_active_bg.gif 
                      UNSELECTABLE="on">会员新增</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>

					</TR></TBODY></TABLE></TD>
					
					</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 
                  src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD 
                style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" 
                vAlign=top><DIV id=tabContent__1>
                  <DIV>
                 <TABLE width="100%" 
                  border=0 align=center cellPadding=3 cellSpacing=1 class="Privateborder">
                      <TBODY>
                        <TR>
                          <TD width="35%" class="table_body " align="right">顾客姓名</TD>
                          <TD width="65%" class="table_none ">
                           <input class="text_input100" type="text" yyorder="1" id="smeciname" name="customerInfoPo.smeciname" maxlength="10"
			             validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '顾客姓名不能为空！'},
			              {'Type' : Type.String, 'Formula' : Formula.ALL_CN, 'Message' : '顾客姓名应为中文！'}]"></TD>
					    </TR>
                        <TR>
                          <TD width="35%" class="table_body " align="right">顾客性别</TD>
                          <TD width="65%" class="table_none "><select id="smecisex" yyorder="2" name="customerInfoPo.smecisex">
      		                 	<option value="0">男</option>
      		                 	<option value="1">女</option>
      	                    </select>
					    </TR>
                        <TR>
                          <TD width="35%" class="table_body " align="right">出生日期</TD>
                          <TD width="65%" class="table_none " >
                          	<input class="text_input100" yyorder="3"
				               id="smecibirthday"
						       name="customerInfoPo.smecibirthday"
						       type="text" 
						       onFocus="WdatePicker({readOnly:true})"
						       readonly="readonly" />
                          </TD>
					     <TR>
                          <TD width="35%" class="table_body " align="right">联系电话</TD>
                          <TD width="65%" class="table_none ">
                           <input class="text_input200" type="text" yyorder="4" id="smeciphone" name="customerInfoPo.smeciphone" maxlength="15"
                           validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '联系电话不能为空！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [16]}, 'Message' : '联系电话长度不能大于15个字符！'},{'Type' : Type.String, 'Formula' : Formula.INT, 'Message' : '联系电话必须为数字！'}]">
                          </TD>
                        </TR>
                        <TR>
                          <TD width="35%" class="table_body " align="right">会员卡号</TD>
                          <TD width="65%" class="table_none ">
                          <input class="text_input200" type="text" yyorder="5" id="smecimemberid" name="customerInfoPo.smecimemberid" maxlength="11" 
                          validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入会员卡号！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '会员卡号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [12]}, 'Message' : '会员卡号不能超过11位！'}]">
                          </TD>
					   </TR>

					    <TR>
                          <TD width="35%" class="table_body " align="right">会员卡类型</TD>
                          <TD width="65%" class="table_none "><select id="smecicardtype" yyorder="6" name="customerInfoPo.smecicardtype ">
                              <option value="4028806725d42d300125d47c76d60004">普通卡</option>
                              <option value="4028806926a11d710126a15546260003">白金卡</option>
                              <option value="4028806926a11d710126a15546260003">黄金会员</option>
                              <option value="402880672577af31012577e5726c0005">至尊卡</option>
                          </select></TD>
                        </TR>
					   
                        <TR>
                          <TD width="35%" class="table_body " align="right">地区</TD>
                          <TD width="65%" colspan="3" class="table_none ">
                          <select id="zone1" yyorder="7" name="customerInfoPo.smecizone"  validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '地区不能为空！'}]"></select><select id="zone2" yyorder="8" name="customerInfoPo.smecizone"></select><select id="zone3" yyorder="9" name="customerInfoPo.smecizone"></select>
                            </TD>
					  </TR>
                        <TR>
                          <TD width="35%" class="table_body " align="right">E-Mail</TD>
                          <TD width="65%" class="table_none ">
                           <input class="text_input200" type="text" yyorder="10" id="smeciemail" name="customerInfoPo.smeciemail" validate="[{'Type' : Type.String, 'Formula' : Formula.emailORNULL, 'Message' : '请填写正确的E-Mail格式！'}]">
                          </TD>
                        </TR>
                        <TR>
                          <TD width="35%" class="table_body " align="right">地址</TD>
                          <TD width="65%" class="table_none ">
                          <input class="text_input200" yyorder="11" type="text" maxlength="25" id="smeciaddress" name="customerInfoPo.smeciaddress" validate="[{'Type' : Type.String, 'Formula' : Formula.CNORNULL, 'Message' : '地址应为中文！'}]">
                          </TD>
					    </TR>
                        <TR>
                          <TD width="35%" class="table_body " align="right">邮编</TD>
                          <TD width="65%" class="table_none ">
                          <input class="text_input100" type="text" yyorder="12" id="smecipostcode" name="customerInfoPo.smecipostcode" maxlength="6"  validate="[{'Type' : Type.String, 'Formula' : Formula.INTORNULL, 'Message' : '邮编应为整形！'}]">
                          </TD>
						</TR>
                        <TR>
                          <TD width="35%" class="table_body " align="right"><font color="red">检查充值卡号</font></TD>
                          <TD width="65%" class="table_none ">
                          <input class="text_input150" type="text" yyorder="13" id="smecicardid" name="smecicardid" 
                          validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '请输入检查充值卡号！'},{'Type' : Type.String, 'Formula' : Formula.Word, 'Message' : '检查充值卡号只允许输入整数和字母！'},{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [12]}, 'Message' : '检查充值卡号不能超过11位！'}]">
                          </TD>																			  
						</TR>
                        <TR>
                          <TD width="12%" class="table_body " align="right"><font color="red">充值金额</font></TD>
                          <TD width="22%" class="table_none ">
                            <li class="horizontal_onlyRight">
                             <input id=smeciamount yyorder="14" onblur="isNumber()" class="text_input100" name="smeciamount" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '充值金额不能为空！'}]" >
						   </li>
						   <li class="horizontal_onlyRight">
	                            <input icon='icon-save' type='button' id="btn1"  value="50.00"   onClick="dianji1()" />
	                            <input icon='icon-save' type='button' id="btn2"  value="100.00"  onClick="dianji2();" />
	                            <input icon='icon-save' type='button' id="btn3"  value="200.00"  onClick="dianji3();" />
						   </li>
                            
                          </TD>
						</TR>
						  <TR>
                          <TD width="35%" class="table_body " align="right"><font color="red">可用金额</font></TD>
                          <TD width="65%" class="table_none ">
                          <input class="text_input100" type="text"  id="smeciavailableamount" name="smeciavailableamount" readonly="readonly">
                          		
                          </TD>
						</TR>
                      </TBODY>
                    </TABLE>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><input id="submitButton" icon='icon-save' type='button' value='保存' onClick="save()">
                        	  <input icon='icon-reload' type='reset' value='清空' >
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