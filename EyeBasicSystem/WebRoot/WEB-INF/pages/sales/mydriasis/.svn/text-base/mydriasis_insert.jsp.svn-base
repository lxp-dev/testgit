<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/allcommons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>眼部检查管理</title>
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

	function save(){
		if(checkForm(document.all.mydriasisForm))
		{  
	        document.all.button1.disabled="true";
	        if(document.getElementById('feiyong').value == 23 && document.getElementById('departmentID').value == 01)
			{
				var customerName = document.getElementById('smeciname').value;
				var sex = document.getElementById('smecisex').value;
				var smecibirthday = document.getElementById('smecibirthday').value;
				if(sex==0)
				{
					sex="男";
				}
				else
				{
					sex="女";
				}
				// window.open("http://219.142.75.22:8081/tongrenYgzhWeb/checkServlet?param=savePatientAndCaseAndCheck&sname="+customerName+"&ssex="+sex+"&dtborn="+smecibirthday+"&nhospital=100002&ndid=800219&ncheckid=638", "眼底照相");
			
			}
			mydriasisForm.action = "insertMydriasis.action";
			$("img").removeAttr("onclick");
			mydriasisForm.submit();
		}
	}
	function getCustomer(obj){
	    if(event.keyCode==13){
		    if ($.trim(obj.value) == ''){
                alert('请输入会员卡号!');
                return;
			}
			mydriasisForm.action = "selMydriasisForCustomer.action";
			$("img").removeAttr("onclick");
			mydriasisForm.submit();
		}
	}
	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【会员详细】";
	}
	
	/*   单个汉字的宽度,根据你的字体大小自行设定   */   
  var   wordWidth   =   '14';   
  function   setWidth()   
  {   
	  obj   =   event.srcElement;   
	  obj.style.width   =   obj.value.replace(/[^\x00-\xff]/g,"**").length*wordWidth/2+5;   
  }
  function chargePut(){
		if(mydriasisForm.customerID.value == ""){
		   alert("请输入会员号");
		   return false; 
		}
		
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initCardBillingNormal.action?customerID="+"${customerInfoPo.smecicustomerid}",970,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}else{
			showPopWin("initCardBillingNormal.action?customerID="+"${customerInfoPo.smecicustomerid}",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),true);
		}
		document.getElementById('popupTitle').innerHTML="【收取检查费】";
	}
	/* 特殊加工要求 */
  function specialPut(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		
		showPopWin("","initSpecialRequirementsInsertOpen.action",700,500,'',null,true);
		selectHidden();
	}
	/* 销售镜架  */
  function sellMirrorFrame(){
		showPopWin("","initSellMirrorFrameSel.action",screen.width-200,screen.height-200,'',null,true);
		selectHidden();
	}
			/**
	 *聚焦
	 */
	window.onload = function() {
		document.getElementById('smecimemberid').focus();
		if('${mydriasisPo.sopmdopttype}'=='2'){
			$('#sopmdanaesthetic').attr("disabled","");
		}
		
	}
	
	function isshow(obj){
		if(obj.value == '1'){
			$('#sopmdanaesthetic').attr("disabled","disabled");
		}else{
			$('#sopmdanaesthetic').attr("disabled","");
		}
	}
	
	function clean(){
		$('input[qingkong=qingkong]').val('');
		$('select[qingkong=qingkong]').val('1');
		$('input[id=sopmdopttype1]').attr('checked','checked');
		$('#sopmdanaesthetic').attr("disabled","disabled");
		$('select[qingkong=yd]').val('');
		$('textarea[qingkong=qingkong]').val('');
	}
	
	
   function eyeGround(){

   	if(mydriasisForm.customerID.value == ""){
		   alert("请输入会员号");
		   return false; 
		}
   	 	var customerName = document.getElementById('smeciname').value;
		var sex = document.getElementById('smecisex').value;
		var smecibirthday = document.getElementById('smecibirthday').value;
		//alert(customerName"+"sex"+"smecibirthday);
		if(sex==0)
		{
			sex="男";
		}
		else
		{
			sex="女";
		}
		// window.open("http://219.142.75.22:8081/tongrenYgzhWeb/viewCheckImage.jsp?sname="+customerName+"&ssex="+sex+"&dtborn="+smecibirthday, "眼底照相");
		
		}

	/**
	 *查看
	 */
	function selCustomerInfo(){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;
		if(is_iPad()){
			showPopWin("initSelCustomerInfoWin.action",970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initSelCustomerInfoWin.action",screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员查询】";
   }


    function setCustomer(memberid){
		document.getElementById('smecimemberid').value = memberid;
		$("img").removeAttr("onclick");
		mydriasisForm.action = "selMydriasisForCustomer.action";
		mydriasisForm.submit();
	}
		
    
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="mydriasisForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }" /> 
<input type="hidden" name="customerID" value="${customerInfoPo.smecicustomerid }">
<input type="hidden" name="smeciname" value="${customerInfoPo.smeciname }">
<input type="hidden" name="smecibirthday" value="${fn:substring(customerInfoPo.smecibirthday,0,10)}">
<input type="hidden" name="smecisex" value="${customerInfoPo.smecisex}">
<input type="hidden" id="departmentID" name="departmentID" value="${person.departmentID}" />

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="15%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光管理</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：散瞳检查</td>
                    <TD class=menubar_readme_text vAlign=bottom>
          				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <!-- <TD class=menubar_button id=button_0 
                onmouseover=javascript:MenuOnMouseOut(this); 
                title="关闭页面" onClick="JavaScript:parent.hidePopWin();"
                onmouseout=javascript:MenuOnMouseOver(this);><IMG 
                  src="${ctx}/css/button/style/icons/close.gif" width="15" height="15" 
                  border=0 align=textTop>&nbsp;关闭页面</TD> -->
                   <TD >当前日期：&nbsp;<jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" /></TD> 
                        </TR>
                      </TBODY>
                    </TABLE>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
                      <!-- <TD class=menubar_function_text align=right>
                   
                   <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
				<c:if test="${(person.departmentID=='02jjjjjjjj')&&(permissionPo.keyd==1)}">
              	 <TD class=menubar_button id=button_0 
		             onmouseover=javascript:MenuOnMouseOut(this); 
		             onclick="chargePut();" 
		             onmouseout=javascript:MenuOnMouseOver(this);><IMG 
		             src="${ctx}/img/sys/New.gif" align=textTop 
		             border=0>&nbsp;收取检查费
                 </TD>
                </c:if>
             </TR></TBODY></TABLE>
                      
				<TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>
                          <TD class=menubar_button></TD>
                        </TR>
                      </TBODY>
                </TABLE>
			</TD> -->

			</TR>
        </TBODY></TABLE>
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
                      UNSELECTABLE="on">散瞳检查新增</TD>
                      <TD width=3><IMG id=tabImgRight__0 height=22 
                        src="${ctx}/img/pic/tab_active_right.gif" 
                    width=3></TD></TR></TBODY></TABLE></TD>
					<TD width=3><IMG id=tabImgLeft__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
					<TD class=tab id=tabLabel__1 
                      onclick="JavaScript:window.location.href='initMydriasisSel.action;'" 
                      background=${ctx}/img/pic/tab_unactive_bg.gif 
                      UNSELECTABLE="on">散瞳检查查询</TD>
                       <TD width=3><IMG id=tabImgRight__1 height=22 
                        src="${ctx}/img/pic/tab_unactive_right.gif" 
                    width=3></TD>
					</TR>
					</TBODY></TABLE></TD>
					
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
						  <fieldset>
							<legend><font size="2">顾客资料</font></legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td align="center">
								  <table width="99%" class="Privateborder privateTable" border="0" cellpadding="1" cellspacing="1">
									  <tr>
										<td class="table_body">
										<li class="horizontal">  顾客卡号：
										  <input onpropertychange="setWidth()" style="text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" id="smecimemberid" name="smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid}" onkeydown="getCustomer(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
										  <input name="mydriasisPo.sopmdfcustomerid" type="hidden" value="${customerInfoPo.smecicustomerid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
										  &nbsp;&nbsp;</li>
										  <li class="horizontal">
					              <img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					            </li> 
										 <li class="horizontal">  姓名：
										  <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smeciname" value="${customerInfoPo.smeciname}" class="text_input80" readOnly="readOnly">
										  &nbsp;&nbsp; </li>  <li class="horizontal">  性别：
											<c:if test="${customerInfoPo.smecisex==0}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="男" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                                <c:if test="${customerInfoPo.smecisex==1}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="女" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                                <c:if test="${empty(customerInfoPo.smecisex)}">
			                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="" class="text_input20" readOnly="readOnly">
			                                </c:if>
			                              &nbsp;&nbsp;</li><li class="horizontal">  年龄：
										   <input onpropertychange="setWidth()" style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecibirthday" value="${customerInfoPo.fmmage}" class="text_input100" readOnly="readOnly">
										   <c:if test="${not empty(customerInfoPo.smecicustomerid)}">								  
										      &nbsp;</li><li class="horizontal"> <input name="button32" type='button' value='详情' align="left" onClick="javascript:details('${customerInfoPo.smecicustomerid}')">
										  </c:if>	</li>							
										</td>
									  </tr>
								  </table>
								</td>
							  </tr>
						  </table>
						</fieldset>					
						<br />		
						 <fieldset>
							<legend>病史</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td align="center">
								  <table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td><textarea qingkong=qingkong name="mydriasisPo.sopmdfamilyhistory" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [200]}, 'Message' : '病史不能大于100字符'}]">${mydriasisPo.sopmdfamilyhistory }</textarea></td>
									</tr>
								  </table>
								</td>
							  </tr>
						  </table>						
						 </fieldset><br>
						<fieldset>
							<legend>检查项目</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center 
                  border=0>
                                  <TBODY>
                                    <TR>
                                      <TD width="10%" class="table_body">一般检查</TD>
                                      <TD width="40%" class="table_none"><input qingkong=qingkong class="text_input100" name="mydriasisPo.sopmdgeneralinspection" value="${mydriasisPo.sopmdgeneralinspection }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '一般检查不能大于15字符'}]"></TD>
                                      <TD width="10%" class="table_body">眼底检查</TD>
                                      <TD width="40%" class="table_none"><input qingkong=qingkong class="text_input100" name="mydriasisPo.sopmdfundusinspection" value="${mydriasisPo.sopmdfundusinspection }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '眼底检查不能大于15字符'}]"></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">眼压</TD>
                                      <TD class="table_none"><input qingkong=qingkong class="text_input100" name="mydriasisPo.sopmdfiop" value="${mydriasisPo.sopmdfiop }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '眼压不能大于15字符'}]"></TD>
                                      <TD class="table_body">散瞳剂</TD>
                                      <TD class="table_none"><select qingkong=qingkong id="sopmdanaesthetic" name="mydriasisPo.sopmdanaesthetic" disabled="disabled">
                                        <option value="1" ${mydriasisPo.sopmdanaesthetic != '1' ? '':'selected=selected'}>0.5%复方托吡卡胺(美多丽P)</option>
				                        <option value="2" ${mydriasisPo.sopmdanaesthetic != '2' ? '':'selected=selected'}>1%环戊通</option>
				                        <option value="3" ${mydriasisPo.sopmdanaesthetic != '3' ? '':'selected=selected'}>2%后马托品</option>
				                        <option value="4" ${mydriasisPo.sopmdanaesthetic != '4' ? '':'selected=selected'}>1%阿托品膏</option>	
				                        <option value="阿托品已散瞳" ${mydriasisPo.sopmdanaesthetic != '阿托品已散瞳' ? '':'selected=selected'}>阿托品已散瞳</option>
                                      </select></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">散瞳类型</TD>
                                      <TD class="table_none">显然验光：<input type="radio" id="sopmdopttype1" name="mydriasisPo.sopmdopttype" value="1" onclick="isshow(this)" checked="checked"/>&nbsp;&nbsp;散瞳：<input type="radio" id="sopmdopttype2" name="mydriasisPo.sopmdopttype" ${mydriasisPo.sopmdopttype !='2' ? '':'checked=checked' } value="2" onclick="isshow(this)"/>&nbsp;&nbsp;显加快：<input type="radio" id="sopmdopttype3" name="mydriasisPo.sopmdopttype" ${mydriasisPo.sopmdopttype !='3' ? '':'checked=checked' } value="3" onclick="isshow(this)"/>&nbsp;&nbsp;左散瞳：<input type="radio" id="sopmdopttype4" name="mydriasisPo.sopmdopttype" ${mydriasisPo.sopmdopttype !='4' ? '':'checked=checked' } value="4" onclick="isshow(this)"/>&nbsp;&nbsp;右散瞳：<input type="radio" id="sopmdopttype5" name="mydriasisPo.sopmdopttype" ${mydriasisPo.sopmdopttype !='5' ? '':'checked=checked' } value="5" onclick="isshow(this)"/></TD>
                                      <TD class="table_body">提交费用</TD>
                                      <TD class="table_none"><select qingkong=yd id="feiyong" name="mydriasisPo.sopmdsubmitexpenseid">
                                        <option value="">----请选择----</option>
				                        <option value="23" ${mydriasisPo.sopmdsubmitexpenseid != '23' ? '':'selected=selected'}>眼底照相</option>
                                      </select>
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						</fieldset>	<br>
						<fieldset>
							<legend>视力检查</legend>
							<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
							  <tr>
								<td><TABLE class="privateTable privateBorder" cellSpacing=1 cellPadding=3 width="99%" align=center 
                  border=0>
                                  <TBODY>
                                    <TR>
                                      <TD width="14%" class="table_body">戴镜视力</TD>
                                      <TD width="19%" class="table_none"><div align="right">右：</div></TD>
                                      <TD width="19%" class="table_none"><input qingkong=qingkong class="text_input120" name="mydriasisPo.sopmdrightglassesvision" value="${mydriasisPo.sopmdrightglassesvision }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '戴镜视力右眼不能大于15字符'}]"></TD>
                                      <TD width="19%" class="table_none"><div align="right">左：</div></TD>
                                      <TD width="19%" class="table_none"><input qingkong=qingkong class="text_input120" name="mydriasisPo.sopmdleftglassesvision" value="${mydriasisPo.sopmdleftglassesvision }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '戴镜视力左眼不能大于15字符'}]"></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">裸眼视力</TD>
                                      <TD class="table_none"><div align="right">右：</div></TD>
                                      <TD class="table_none"><input qingkong=qingkong class="text_input120" name="mydriasisPo.sopmdrightnakedvision" value="${mydriasisPo.sopmdrightnakedvision }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '裸眼视力右眼不能大于15字符'}]"></TD>
                                      <TD class="table_none"><div align="right">左：</div></TD>
                                      <TD class="table_none"><input qingkong=qingkong class="text_input120" name="mydriasisPo.sopmdleftnakedvision" value="${mydriasisPo.sopmdleftnakedvision }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '裸眼视力左眼不能大于15字符'}]"></TD>
                                    </TR>
                                    <TR>
                                      <TD class="table_body">近视力</TD>
                                      <TD class="table_none"><div align="right">右：</div></TD>
                                      <TD class="table_none"><input qingkong=qingkong class="text_input120" name="mydriasisPo.sopmdrightnearvision" value="${mydriasisPo.sopmdrightnearvision }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '近视力右眼不能大于15字符'}]"></TD>
                                      <TD class="table_none"><div align="right">左：</div></TD>
                                      <TD class="table_none"><input qingkong=qingkong class="text_input120" name="mydriasisPo.sopmdleftnearvision" value="${mydriasisPo.sopmdleftnearvision }" validate="[{'Type' : Type.String, 'Formula' : Formula.LongDateFormat, 'Expansion' : {Type : Expansion.LessThanLength, Params : [15]}, 'Message' : '近视力左眼不能大于15字符'}]"></TD>
                                    </TR>
                                  </TBODY>
                                </TABLE></td>
							  </tr>
							</table>
						</fieldset>	
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD><img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()"/>
                        	  <img src="${ctx }/img/newbtn/btn_empty_0.png" btn=btn title='清空' onClick="clean()"/>
                        	  <!-- <input id="button2"  type='button' value="眼 底 照 相 查 看" onclick="eyeGround();" /> -->
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
	
	
	




