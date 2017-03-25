<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工打折管理</title>
</head>
<script>
	function trim(str){ //删除左右两端的空格
　　 	return str.replace(/(^\s*)|(\s*$)/g, "");
　　 }

	$(document).ready(function() {
		$("img[btn=btn]").attr("style","cursor: hand");
		$("img[btn=btn]").mouseover(function () {
        	$(this).attr("src",$(this).attr("src").replace("0","1"));
    	}).mouseout(function () {
			$(this).attr("src",$(this).attr("src").replace("1","0"));
    	});
	});

	function save(){
		if(checkForm(document.all.personDiscountForm)){ 
		    if ($.trim($('#fpdspecialdiscount').val()) != ''){
			    if ($.trim($('#fpdspecialdiscountnumber').val()) == ''){
                    alert('请填写特殊折扣打折次数!');
                    $("#fpdspecialdiscountnumber").select();
                    return;
				}
			}else{
				$('#fpdspecialdiscountnumber').val('');
		    }
		     
		    $("img").removeAttr("onclick");
			personDiscountForm.action = "insertPersonDiscount.action";
			personDiscountForm.submit();
		}
	}
	
    function scanBarCode(obj) {
	if (event.keyCode == 13) {		
		if (obj.value == null || obj.value == '') {
			alert("请输入工号！");
			obj.select();
			return;
		}	
		personDiscountForm.action = "insertPersonDiscountSel.action";
		personDiscountForm.submit();
		}
	}
	function blurFun(obj){
		if (obj.value == null || obj.value == '') {
				//alert("请输入工号！");
				//obj.select();
				return;
			}	
			personDiscountForm.action = "insertPersonDiscountSel.action";
		personDiscountForm.submit();
	}
	$(document).ready(function(){
		$('#fpddiscount').bind("keyup",function(){	
			$('#fpddiscount').val(
				$('#fpddiscount').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
		
		$('#fpdspecialdiscount').bind("keyup",function(){	
			$('#fpdspecialdiscount').val(
				$('#fpdspecialdiscount').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
		
		$('#fpdspecialdiscountnumber').bind("keyup",function(){	
			$('#fpdspecialdiscountnumber').val(
				$('#fpdspecialdiscountnumber').val().replace(/[^0-9.][0-9]*/g,'')
				);
		});
	});
	function yzZheKou(){
		var vl=$('#fpddiscount').val();
		b=".";
		if(ReplaceDemo(vl)>1){
			alert("折扣有问题,请重新输入！");
			$('#fpddiscount').focus();
			$('#fpddiscount').select();
			return;
		}
		var indexNum=vl.indexOf(".");
		
		if(indexNum==0){
			vl=0+vl;
			$('#fpddiscount').val(vl)
		}
		
	}
	function yzTSZheKou(){
		var vl=$('#fpdspecialdiscount').val();
		b=".";
		if(ReplaceDemo(vl)>1){
			alert("折扣有问题,请重新输入！");
			$('#fpdspecialdiscount').focus();
			$('#fpdspecialdiscount').select();
			return;
		}
		var indexNum=vl.indexOf(".");
		if(indexNum==0){
			vl=0+vl;
			$('#fpdspecialdiscount').val(vl)
		}
		
	}

	function checkSpecialDiscount() {
		var regSpecialDiscount = /^([0|1])$|^([0]\.[1-9][0-9])$/;
		var specialDiscount = $("#fpdspecialdiscount").val();
		if(specialDiscount) {
			if(regSpecialDiscount.exec(specialDiscount) == null) {
				return false;
			}
		}
		return true;
	}
	
	function ReplaceDemo(ss){ 
	   var r, re;   
	   var strlength = ss.length; 
	   re = /\./;        // 创建正则表达式模式。 
	   while(re.test(ss)){ 
	   		ss = ss.replace(re, "");   
	   }  
	   return (strlength-ss.length); 
	} 
	
	function checkDiscount(obj){
		if(parseFloat($(obj).val()) > 1 || parseFloat($(obj).val()) < 0){
			alert("折扣填写有误！");
			$(obj).focus();
			$(obj).select();
		}
	}
</script>
<body ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="personDiscountForm" method="post" action="">
<input type="hidden" name="moduleID" value="${requestScope.moduleID}" />
<input type="hidden" name="type" id="type" value="" /> 

<DIV>
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
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                      <TBODY>
					  	<TR>
						   <TD width="8%" height="26" class="table_body">员工工号</TD>
			               <TD width="24%" class="table_none">
                            <input class="text_input100" type="text"  id="personid" name="personDiscountPo.fpdpersonid" value="${personDiscountPo.fpdpersonid}" onkeypress="document.getElementById('button1').disabled = true;scanBarCode(this)" maxlength="10" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '员工卡号不能为空！'}]"><font color="red">&nbsp;&nbsp;请按回车查询数据</font>
			               </TD>
			               <TD width="8%" height="26" class="table_body">姓名</TD>
			               <TD width="24%" class="table_none">
                            ${personDiscountPo.fpdpersonname}&nbsp;
			               </TD>
			               <TD width="8%" height="26" class="table_body">角色</TD>
			               <TD class="table_none">
                            ${personDiscountPo.fpdrolename}&nbsp;
			               </TD>
                        </TR>
                        <TR>
                           <TD height="26" class="table_body">折扣</TD>
			               <TD class="table_none">
                            <input maxlength="4" class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);};checkDiscount(this);"  id="fpddiscount" name="personDiscountPo.fpddiscount" value="${personDiscountPo.fpddiscount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '折扣不能为空！'}]">&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
			               </TD>
			               <TD height="26" class="table_body">特殊折扣次数</TD>
			               <TD class="table_none">
                            <input maxlength="4" class="text_input100" type="text"  id="fpdspecialdiscountnumber" name="personDiscountPo.fpdspecialdiscountnumber" value="${personDiscountPo.fpdspecialdiscountnumber}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINTOrNULL, 'Message' : '请重新填写特殊折扣打折次数！'}]">&nbsp;
			               </TD>
			               <TD height="26" class="table_body">特殊折扣</TD>
			               <TD class="table_none">
                            <input maxlength="4" class="text_input100" type="text" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);};checkDiscount(this);" id="fpdspecialdiscount" name="personDiscountPo.fpdspecialdiscount" value="${personDiscountPo.fpdspecialdiscount}" >&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
			               </TD>
                        </TR>
                      </TBODY>
                    </TABLE>
                    <c:if test="${systemParameterPo.fspisusegoodslevel eq '1'}">
                    <c:if test="${empty(personDiscountDetailsPos)}">
                    <br/>
                    <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                        <TBODY>
                        <s:iterator value="selectGoodsLevelList">
                        <TR>
					       <td class="table_body" width="8%">
					       		<input type="hidden" name="personDiscountDetailsPo.fpddgoodslevels" value="${bgluuid}">
					       		<input type="hidden" class="text_input100" name="" value="${bglname}">
					       		${bglname}
					       </td>
					       <td class="table_body" width="8%">
					       		折扣
					       </td>
					       <td class="table_none" width="16%">
					       		<input type="text" class="text_input100" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);};checkDiscount(this);" name="personDiscountDetailsPo.fpdddiscounts" value="" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '折扣不能为空！'}]">&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
					       </td>
					       <td class="table_body" width="8%">
					       		特殊折扣次数
					       </td>
					       <td class="table_none" width="24%">
					       		<input type="text" class="text_input100" name="personDiscountDetailsPo.fpddspecialdiscountnumbers" value="" validate="[{'Type' : Type.String, 'Formula' : Formula.UINTOrNULL, 'Message' : '请重新填写特殊折扣打折次数！'}]">&nbsp;
					       </td>
					       <td class="table_body" width="8%">
					       		特殊折扣
					       </td>
					       <td class="table_none">
					       		<input type="text" class="text_input100" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);};checkDiscount(this);" name="personDiscountDetailsPo.fpddspecialdiscounts" value="" >&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
					       </td>
                        </TR>
                        </s:iterator>
                        </TBODY>
                        </table>
                        </c:if>
                        <c:if test="${not empty(personDiscountDetailsPos)}">
                        <br/>
                        <table width="100%"  border=0 align=center cellpadding=1 cellspacing=1 class="privateBorder" id="title1">
                        <TBODY>
                        <s:iterator value="personDiscountDetailsPos">
                        <TR>
					       <td class="table_body" width="8%">
					       		<input type="hidden" name="personDiscountDetailsPo.fpddgoodslevels" value="${fpddgoodslevel}">
					       		<input type="hidden" class="text_input100" name="" value="${fpddgoodslevelname}">
					       		${fpddgoodslevelname}
					       </td>
					       <td class="table_body" width="8%">
					       		折扣
					       </td>
					       <td class="table_none" width="16%">
					       		<input type="text" class="text_input100" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);};checkDiscount(this);" name="personDiscountDetailsPo.fpdddiscounts" value="${fpdddiscount}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '折扣不能为空！'}]">&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
					       </td>
					       <td class="table_body" width="8%">
					       		特殊折扣次数
					       </td>
					       <td class="table_none" width="24%">
					       		<input type="text" class="text_input100" name="personDiscountDetailsPo.fpddspecialdiscountnumbers" value="${fpddspecialdiscountnumber}" validate="[{'Type' : Type.String, 'Formula' : Formula.UINTOrNULL, 'Message' : '请重新填写特殊折扣打折次数！'}]">&nbsp;
					       </td>
					       <td class="table_body" width="8%">
					       		特殊折扣
					       </td>
					       <td class="table_none">
					       		<input type="text" class="text_input100" onKeyUp="value=value.replace(/[^\d\.]/g,'')" onblur="if(!isNaN(this.value)) { if(trim(this.value)!='')this.value = new Number(this.value).toFixed(2);};checkDiscount(this);" name="personDiscountDetailsPo.fpddspecialdiscounts" value="${fpddspecialdiscount}" >&nbsp;<font color="red">&nbsp;折扣在0-1之间</font>
					       </td>
                        </TR>
                        </s:iterator>
                      </TBODY>
                    </TABLE>
                    </c:if>
                    </c:if>
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img  id="button1" src="${ctx}/img/newbtn/btn_save_0.png" btn=btn title='保存' onClick="save()">
                        	  <!-- <input icon='icon-reload' type='reset' value='清空' > -->
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
	
	
	




