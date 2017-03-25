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
    	document.getElementById("smecimemberid").focus();
	});  

	  /*   单个汉字的宽度,根据你的字体大小自行设定   */   
	  var   wordWidth   =   '14';   
	  function   setWidth()   
	  {   
		  obj   =   event.srcElement;   
		  obj.style.width   =   obj.value.replace(/[^\x00-\xff]/g,"**").length*wordWidth/2+5;   
	  }
	  function eyesChargePut(){
		showPopWin("","initEyesChargePutInsert.action",700,500,'',null,true);
		selectHidden();
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
		yjCheckForm.action = "selectYjCheckEyesCheck.action";
		yjCheckForm.submit();
	}
	
	function getCustomer(obj){ 
	    if(event.keyCode==13){  
		    if ($.trim(obj.value) == ''){
                alert('请输入会员卡号!');
                return;
			}
	    	$("img").removeAttr("onclick");   
	    	yjCheckForm.action = "selectYjCheckEyesCheck.action";
	    	yjCheckForm.submit();
		}
	}  

	function save(){
		if(checkForm(document.all.yjCheckForm)){    
        	$("img").removeAttr("onclick");
        	yjCheckForm.action = "insertEyeCheckYjCheck.action";
        	yjCheckForm.submit();
		}
	}

	function details(id){
		var topRows = top.document.getElementById("total").rows;
		var topCols = top.document.getElementById("btmframe").cols;		
		if(is_iPad()){
			showPopWin("initDetailsCustomerInfo.action?hid="+id,970,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}else{
			showPopWin("initDetailsCustomerInfo.action?hid="+id,screen.width-100,screen.height-200,topRows,topCols,returnRefresh(true),false);
		}
		document.getElementById('popupTitle').innerHTML="【会员信息】";	
	}
	
    function ybjkjc(id){
        var url = "";
        if (typeof(id) != 'undefined' && id != null && id != ''){
            url = "selEyesCheckForCustomerHydsy.action?moduleID=${moduleID}&smecimemberid=" + id;           
        }else{
        	url = "initEyesCheckInsertHydsy.action?moduleID=${moduleID}";
        }
        window.location.href = url;
    }

    function djs(id){
        var url = "";
        if (typeof(id) != 'undefined' && id != ''){
            url = "&smecimemberid=" + id;
        }
    	window.location.href = 'selectGlassesHistoryEyesCheck.action?moduleID=${moduleID}' + url;
    }
</script>
<body  ${sessionScope.systemParameterPo.fsprightshowurl eq '1' ? 'onkeydown="KeyDown()" oncontextmenu="event.returnValue=false" onhelp="Showhelp();return false;"' : '' }>
<form name="yjCheckForm" method="post" action="">

<input type="hidden" name="type" id="type" value="" /> 
<input type="hidden" name="moduleID" value="${moduleID }" /> 
<input type="hidden" name="customerID" value="${customerInfoPo.smecicustomerid }">

<DIV>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD><!-- ?? Start -->
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD class=menubar_title width="10%"><img border='0' src='${ctx}/img/pic/module.gif' align='absmiddle' hspace='3' vspace='3'>验光管理</TD>
          <td align="left"><%@ include file="/commons/helpMovie.jsp" %>目前操作功能：眼肌检查</td>
          </TD></TR>
        <TR>
          <TD class=menubar_function_text colspan="3"><table></table></TD>
		</TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
        <TBODY>
        <TR>
          <TD style="PADDING-LEFT: 2px; HEIGHT: 22px" background=${ctx}/img/pic/tab_top_bg.gif>
			<TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD width=3><IMG id=tabImgLeft__1 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
				<TD class=tab id=tabLabel__1 onclick="ybjkjc('${customerInfoPo.smecimemberid}');"  background=${ctx}/img/pic/tab_unactive_bg.gif UNSELECTABLE="on">眼部检查新增</TD>
                <TD width=3><IMG id=tabImgRight__1 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3></TD>
				<TD width=3><IMG id=tabImgLeft__1 height=22 src="${ctx}/img/pic/tab_unactive_left.gif" width=3></TD>
				<TD class=tab id=tabLabel__1 onclick="djs('${customerInfoPo.smecimemberid}');" background=${ctx}/img/pic/tab_unactive_bg.gif UNSELECTABLE="on">戴镜史</TD>
                <TD width=3><IMG id=tabImgLeft__0 height=22 src="${ctx}/img/pic/tab_active_left.gif" width=3></TD>
                <TD class=tab id=tabLabel__0 background=${ctx}/img/pic/tab_active_bg.gif UNSELECTABLE="on">眼肌检查</TD>
                <TD width=3><IMG id=tabImgRight__0 height=22 src="${ctx}/img/pic/tab_active_right.gif" width=3></TD>                    
				<TD class=tab id=tabLabel__1 onclick="JavaScript:window.location.href='initEyesCheckSelHydsy.action?smecimemberid=${customerInfoPo.smecimemberid}'" background=${ctx}/img/pic/tab_unactive_bg.gif UNSELECTABLE="on">眼部检查查询</TD>
                <TD width=3><IMG id=tabImgRight__1 height=22 src="${ctx}/img/pic/tab_unactive_right.gif" width=3></TD>
			  </TR>
			  </TBODY>
			</TABLE>          
          </TD>
		</TR>
        <TR>
          <TD bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
                <TD style="PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; PADDING-TOP: 15px; HEIGHT: 100px" vAlign=top>
                <DIV id=tabContent__1>
                  <DIV>
				  <fieldset>
					<legend>【顾客资料】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td align="center">
						  <table width="99%" class="Privateborder privateTable" border="0" cellpadding="1" cellspacing="1">
							  <tr>
								<td class="table_body">
								<li class="horizontal">  顾客卡号：
								  <input onpropertychange="setWidth()" style="text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" id="smecimemberid" name="smecimemberid" class="text_input100" value="${customerInfoPo.smecimemberid}" onkeydown="getCustomer(this);" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
								  <input name="yjCheckPo.sopyjcustomerid" type="hidden" value="${customerInfoPo.smecicustomerid}" validate="[{'Type' : Type.String, 'Formula' : Formula.notNull, 'Message' : '卡号不能为空！'}]">
								  &nbsp;&nbsp;</li>
								  <li class="horizontal">
					              	<img src="${ctx }/img/newbtn/btn_search_0.png" name="button22" title='查找' btn=btn onclick="selCustomerInfo();" >
					              </li> 
								 <li class="horizontal">  姓名：
								  <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smeciname" value="${customerInfoPo.smeciname}" class="text_input80" readOnly="readOnly">
								  &nbsp;&nbsp; </li>
								 <li class="horizontal">  性别：
									<c:if test="${customerInfoPo.smecisex==0}">
	                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="男" class="text_input20" readOnly="readOnly">
	                                </c:if>
	                                <c:if test="${customerInfoPo.smecisex==1}">
	                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="女" class="text_input20" readOnly="readOnly">
	                                </c:if>
	                                <c:if test="${empty(customerInfoPo.smecisex)}">
	                                <input style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecisex" value="" class="text_input20" readOnly="readOnly">
	                                </c:if>
	                              &nbsp;&nbsp;
	                             </li>
	                             <li class="horizontal">  年龄：
								   <input onpropertychange="setWidth()" style="height=17px;text-align:center;background-color:transparent;BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: solid;" name="smecibirthday" value="${customerInfoPo.fmmage}" class="text_input100" readOnly="readOnly">
								   <c:if test="${not empty(customerInfoPo.smecicustomerid)}">								  
								      &nbsp;
								 </li>
								 <li class="horizontal"> <input name="button32" type='button' value='详情' align="left" onClick="javascript:details('${customerInfoPo.smecicustomerid}')">
								  </c:if>
								 </li>							
								</td>
							  </tr>
						  </table>
						</td>
					  </tr>
				  </table>
				</fieldset>		
				<fieldset>
					<legend>【眼位检查】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center border=0>
                          <TBODY>
                            <TR>
                              <TD width="10%" class="table_body" align="center">代偿头位</TD>
                              <TD colspan="4" class="table_none">头向
                                <select name="yjCheckPo.sopyjdctwtouxiang">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj001'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(yjCheckPo.sopyjdctwtouxiang == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                                </select>&nbsp;&nbsp;&nbsp;&nbsp;肩倾
                                <select name="yjCheckPo.sopyjdctwjianqing">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj002'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(yjCheckPo.sopyjdctwjianqing == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                                </select>&nbsp;&nbsp;&nbsp;&nbsp;歪头试验&nbsp;&nbsp;                                     
                                <select name="yjCheckPo.sopyjdctwwaitoushiyan">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj003'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(yjCheckPo.sopyjdctwwaitoushiyan == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                                </select>&nbsp;&nbsp;侧 
                              	(+)
                              </TD>
                            </TR>
                            <TR>
                              <TD width="10%" rowspan="2" class="table_body" align="center">角膜映光</TD>
                              <TD width="40%" colspan="2" class="table_none">裸眼
                                <input typt="text" id="sopyjjmygdaijing" name="yjCheckPo.sopyjjmygluoyan" value = "${yjCheckPo.sopyjjmygluoyan}" maxlength="25" class="text_input200">                                   
                              </TD>
                              <TD width="10%" class="table_body" align="center">控制正位</td>
                              <TD width="40%" class="table_none">
								<input type="radio" name="yjCheckPo.sopyjjmygkongzhizhengwei" id="sopyjjmygkongzhizhengwei" value="y" ${yjCheckPo.sopyjjmygkongzhizhengwei eq 'y' ? 'checked="checked"' : ''}>能
								<input type="radio" name="yjCheckPo.sopyjjmygkongzhizhengwei" id="sopyjjmygkongzhizhengwei" value="n" ${yjCheckPo.sopyjjmygkongzhizhengwei eq 'n' ? 'checked="checked"' : ''}>否
                              </TD>
                            </TR>
                            <TR>
                              <TD width="40%" colspan="2" class="table_none">戴镜
                                <input typt="text" id="sopyjjmygdaijing" name="yjCheckPo.sopyjjmygdaijing" value = "${yjCheckPo.sopyjjmygdaijing}" maxlength="25" class="text_input200">                                        
                              </TD>
                              <TD width="10%" class="table_body" align="center">主视眼</td>
                              <TD width="40%" class="table_none">
								<input type="radio" name="yjCheckPo.sopyjjmygzhudaoyan" id="sopyjjmygzhudaoyan" value="y" ${yjCheckPo.sopyjjmygzhudaoyan eq 'y' ? 'checked="checked"' : ''}>右
								<input type="radio" name="yjCheckPo.sopyjjmygzhudaoyan" id="sopyjjmygzhudaoyan" value="z" ${yjCheckPo.sopyjjmygzhudaoyan eq 'z' ? 'checked="checked"' : ''}>左
                              </TD>
                            </TR>   
							<TR>
                              <TD width="10%" rowspan="5" class="table_body" align="center">三棱镜&nbsp;&nbsp;&nbsp;&nbsp;</br>
                              	<input type="radio" name="yjCheckPo.sopyjslj" id="sopyjslj" value="1" ${yjCheckPo.sopyjslj eq '1' ? 'checked="checked"' : ''}>中和&nbsp;&nbsp;&nbsp;&nbsp;</br>
								<input type="radio" name="yjCheckPo.sopyjslj" id="sopyjslj" value="2" ${yjCheckPo.sopyjslj eq '2' ? 'checked="checked"' : ''}>遮盖&nbsp;&nbsp;&nbsp;&nbsp;</br>
								<input type="radio" name="yjCheckPo.sopyjslj" id="sopyjslj" value="3" ${yjCheckPo.sopyjslj eq '3' ? 'checked="checked"' : ''}>Maddox
                              </TD>
                              <TD width="40%" colspan="2" align="center" class="table_body" height="30">5m</TD>
                              <TD colspan="2" align="center" class="table_body">33cm</td>
                            </TR>
                            <TR>
                              <TD width="5%" rowspan="2" align="center" class="table_body">OD</TD>
                              <TD width="35%" class="table_none">裸眼&nbsp;&nbsp;
                              	<input typt="text" id="sopyjslj5modluoyan" name="yjCheckPo.sopyjslj5modluoyan" value = "${yjCheckPo.sopyjslj5modluoyan}" maxlength="25" class="text_input100">
                              	<select id="sljlyqselectod" name="yjCheckPo.sljlyqselectod">
                              		<option value=""></option>
                              		<option value="BI" ${yjCheckPo.sljlyqselectod eq 'BI' ? 'selected':'' }>BI</option>
                              		<option value="BO" ${yjCheckPo.sljlyqselectod eq 'BO' ? 'selected':'' }>BO</option>
                              		<option value="BU" ${yjCheckPo.sljlyqselectod eq 'BU' ? 'selected':'' }>BU</option>
                              		<option value="BD" ${yjCheckPo.sljlyqselectod eq 'BD' ? 'selected':'' }>BD</option>
                              	</select>
                              </TD>
                              <TD colspan="2" class="table_none">
                                <input typt="text" id="sopyjslj3modluoyan" name="yjCheckPo.sopyjslj3modluoyan" value = "${yjCheckPo.sopyjslj3modluoyan}" maxlength="25" class="text_input100">
                              	<select id="sljlyhselectod" name="yjCheckPo.sljlyhselectod">
                              		<option value=""></option>
                              		<option value="BI" ${yjCheckPo.sljlyhselectod eq 'BI' ? 'selected':'' }>BI</option>
                              		<option value="BO" ${yjCheckPo.sljlyhselectod eq 'BO' ? 'selected':'' }>BO</option>
                              		<option value="BU" ${yjCheckPo.sljlyhselectod eq 'BU' ? 'selected':'' }>BU</option>
                              		<option value="BD" ${yjCheckPo.sljlyhselectod eq 'BD' ? 'selected':'' }>BD</option>
                              	</select>
                              </td>
                            </TR> 
                            <TR>
                              <TD width="35%" class="table_none">戴镜&nbsp;&nbsp;
                              	<input typt="text" id="sopyjslj5moddaijing" name="yjCheckPo.sopyjslj5moddaijing" value = "${yjCheckPo.sopyjslj5moddaijing}" maxlength="25" class="text_input100">
							  	<select id="sljdjqselectod" name="yjCheckPo.sljdjqselectod">
                              		<option value=""></option>
                              		<option value="BI" ${yjCheckPo.sljdjqselectod eq 'BI' ? 'selected':'' }>BI</option>
                              		<option value="BO" ${yjCheckPo.sljdjqselectod eq 'BO' ? 'selected':'' }>BO</option>
                              		<option value="BU" ${yjCheckPo.sljdjqselectod eq 'BU' ? 'selected':'' }>BU</option>
                              		<option value="BD" ${yjCheckPo.sljdjqselectod eq 'BD' ? 'selected':'' }>BD</option>
                              	</select>
							  </TD>
                              <TD colspan="2" class="table_none">
                                <input typt="text" id="sopyjslj3moddaijing" name="yjCheckPo.sopyjslj3moddaijing" value = "${yjCheckPo.sopyjslj3moddaijing}" maxlength="25" class="text_input100">
                              	<select id="sljdjhselectod" name="yjCheckPo.sljdjhselectod">
                              		<option value=""></option>
                              		<option value="BI" ${yjCheckPo.sljdjhselectod eq 'BI' ? 'selected':'' }>BI</option>
                              		<option value="BO" ${yjCheckPo.sljdjhselectod eq 'BO' ? 'selected':'' }>BO</option>
                              		<option value="BU" ${yjCheckPo.sljdjhselectod eq 'BU' ? 'selected':'' }>BU</option>
                              		<option value="BD" ${yjCheckPo.sljdjhselectod eq 'BD' ? 'selected':'' }>BD</option>
                              	</select>
                              </td>
                            </TR>
							<TR>
                              <TD width="5%" rowspan="2" align="center" class="table_body">OS</TD>
                              <TD width="35%" class="table_none">裸眼&nbsp;&nbsp;
                              	<input typt="text" id="sopyjslj5mosluoyan" name="yjCheckPo.sopyjslj5mosluoyan" value = "${yjCheckPo.sopyjslj5mosluoyan}" maxlength="25" class="text_input100">
							  	<select id="sljlyqselectos" name="yjCheckPo.sljlyqselectos">
                              		<option value=""></option>
                              		<option value="BI" ${yjCheckPo.sljlyqselectos eq 'BI' ? 'selected':'' }>BI</option>
                              		<option value="BO" ${yjCheckPo.sljlyqselectos eq 'BO' ? 'selected':'' }>BO</option>
                              		<option value="BU" ${yjCheckPo.sljlyqselectos eq 'BU' ? 'selected':'' }>BU</option>
                              		<option value="BD" ${yjCheckPo.sljlyqselectos eq 'BD' ? 'selected':'' }>BD</option>
                              	</select>
							  </TD>
                              <TD colspan="2" class="table_none">
                                <input typt="text" id="sopyjslj3mosluoyan" name="yjCheckPo.sopyjslj3mosluoyan" value = "${yjCheckPo.sopyjslj3mosluoyan}" maxlength="25" class="text_input100">
                              	<select id="sljlyhselectos" name="yjCheckPo.sljlyhselectos">
                              		<option value=""></option>
                              		<option value="BI" ${yjCheckPo.sljlyhselectos eq 'BI' ? 'selected':'' }>BI</option>
                              		<option value="BO" ${yjCheckPo.sljlyhselectos eq 'BO' ? 'selected':'' }>BO</option>
                              		<option value="BU" ${yjCheckPo.sljlyhselectos eq 'BU' ? 'selected':'' }>BU</option>
                              		<option value="BD" ${yjCheckPo.sljlyhselectos eq 'BD' ? 'selected':'' }>BD</option>
                              	</select>
                              </td>
                            </TR>
							<TR>
                              <TD width="35%" class="table_none">戴镜&nbsp;&nbsp;
                              	<input typt="text" id="sopyjslj5mosdaijing" name="yjCheckPo.sopyjslj5mosdaijing" value = "${yjCheckPo.sopyjslj5mosdaijing}" maxlength="25" class="text_input100">
                              	<select id="sljdjqselectos" name="yjCheckPo.sljdjqselectos">
                              		<option value=""></option>
                              		<option value="BI" ${yjCheckPo.sljdjqselectos eq 'BI' ? 'selected':'' }>BI</option>
                              		<option value="BO" ${yjCheckPo.sljdjqselectos eq 'BO' ? 'selected':'' }>BO</option>
                              		<option value="BU" ${yjCheckPo.sljdjqselectos eq 'BU' ? 'selected':'' }>BU</option>
                              		<option value="BD" ${yjCheckPo.sljdjqselectos eq 'BD' ? 'selected':'' }>BD</option>
                              	</select>
                              </TD>
                              <TD colspan="2" class="table_none">
                                <input typt="text" id="sopyjslj3mosdaijing" name="yjCheckPo.sopyjslj3mosdaijing" value = "${yjCheckPo.sopyjslj3mosdaijing}" maxlength="25" class="text_input100">
                              	<select id="sljdjhselectos" name="yjCheckPo.sljdjhselectos">
                              		<option value=""></option>
                              		<option value="BI" ${yjCheckPo.sljdjhselectos eq 'BI' ? 'selected':'' }>BI</option>
                              		<option value="BO" ${yjCheckPo.sljdjhselectos eq 'BO' ? 'selected':'' }>BO</option>
                              		<option value="BU" ${yjCheckPo.sljdjhselectos eq 'BU' ? 'selected':'' }>BU</option>
                              		<option value="BD" ${yjCheckPo.sljdjhselectos eq 'BD' ? 'selected':'' }>BD</option>
                              	</select>
                              </td>
                           	</TR>
                          </TBODY>
                        </TABLE>
                        </td>
					  </tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>【眼球运动】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<table class="privateBorder privateTable" cellspacing=1 cellpadding=3 width="99%" align=center border=0>
						  <tbody>
						    <tr>
						      <td width="5%" align="center" class="table_body">双眼</td>
						      <td colspan="4" align="left" class="table_none">
						        <input typt="text" id="sopyjsljyqydshuangyan" name="yjCheckPo.sopyjsljyqydshuangyan" value = "${yjCheckPo.sopyjsljyqydshuangyan}" maxlength="200" class="text_input500">
						      </td>
						    </tr>
						    <tr>
						      <td width="5%" align="center" class="table_body">单眼</td>
						      <td colspan="4" align="left" class="table_none">
						        <input typt="text" id="sopyjsljyqyddanyan" name="yjCheckPo.sopyjsljyqyddanyan" value = "${yjCheckPo.sopyjsljyqyddanyan}" maxlength="200" class="text_input500">
						      </td>
						    </tr>
						  </tbody>
						</table>
						</td>
					  </tr>
					</table>
				</fieldset>					
				<fieldset>
					<legend>【同视机检查】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<table class="privateBorder privateTable" cellspacing=1 cellpadding=3 width="99%" align=center border=0>
						  <tbody>
						    <tr>
						      <td width="5%" rowspan="2" align="center" class="table_body">Ⅰ级</td>
						      <td width="5%" rowspan="2" align="center" class="table_body">自觉</br></br>斜角</td>
						      <td width="30%" class="table_none">裸眼&nbsp;&nbsp;
						      	<input typt="text" id="sopyjtsj1zjxjluoyan" name="yjCheckPo.sopyjtsj1zjxjluoyan" value = "${yjCheckPo.sopyjtsj1zjxjluoyan}" maxlength="25" class="text_input200">  
							  </td>
						      <td width="5%" rowspan="2" align="center" class="table_body">他觉</br></br>斜角</td>
						      <td class="table_none">裸眼&nbsp;&nbsp;
						        <input typt="text" id="sopyjtsj1tjxjluoyan" name="yjCheckPo.sopyjtsj1tjxjluoyan" value = "${yjCheckPo.sopyjtsj1tjxjluoyan}" maxlength="25" class="text_input200">
						      </td>
						    </tr>
						    <tr>
						      <td class="table_none">戴镜&nbsp;&nbsp;
						        <input typt="text" id="sopyjslj1zjxjdaijing" name="yjCheckPo.sopyjslj1zjxjdaijing" value = "${yjCheckPo.sopyjslj1zjxjdaijing}" maxlength="25" class="text_input200">
						      </td>
						      <td class="table_none">戴镜&nbsp;&nbsp;
						        <input typt="text" id="sopyjslj1tjxjdaijing" name="yjCheckPo.sopyjslj1tjxjdaijing" value = "${yjCheckPo.sopyjslj1tjxjdaijing}" maxlength="25" class="text_input200">
						      </td>
						    </tr>
						    <tr>
						      <td width="5%" align="center" class="table_body">Ⅱ级</td>
						      <td colspan="4" align="left" class="table_none">&nbsp;&nbsp;融合点&nbsp;&nbsp;
						        <input typt="text" id="sopyjtsj2ronghedian" name="yjCheckPo.sopyjtsj2ronghedian" value = "${yjCheckPo.sopyjtsj2ronghedian}" maxlength="25" class="text_input200">
						        &nbsp;&nbsp;&nbsp;&nbsp;融合范围&nbsp;&nbsp;
						        <input typt="text" id="sopyjslj2ronghefanwei" name="yjCheckPo.sopyjslj2ronghefanwei" value = "${yjCheckPo.sopyjslj2ronghefanwei}" maxlength="25" class="text_input200">
						      </td>
						    </tr>
						    <tr>
						      <td width="5%" align="center" class="table_body">Ⅲ级</td>
						      <td colspan="2" align="left" class="table_none">&nbsp;&nbsp;立体视&nbsp;&nbsp;
						      	<input type="radio" name="yjCheckPo.sopyjtsj3litishi" id="sopyjtsj3litishi" value="y" ${yjCheckPo.sopyjtsj3litishi eq 'y' ? 'checked="checked"' : ''}>有
								<input type="radio" name="yjCheckPo.sopyjtsj3litishi" id="sopyjtsj3litishi" value="w" ${yjCheckPo.sopyjtsj3litishi eq 'w' ? 'checked="checked"' : ''}>无
						      </td>
						      <td align="left" class="table_none" colspan="2">Titmus立体视&nbsp;&nbsp;
					          	<input typt="text" id="sopyjslj3titmuslitishi" name="yjCheckPo.sopyjslj3titmuslitishi" value = "${yjCheckPo.sopyjslj3titmuslitishi}" maxlength="25" class="text_input200">
					          </td>
						    </tr>
						  </tbody>
						</table>
						</td>
					  </tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>【同视机9方位】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td><TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center border=0>
					      <TBODY>
					        <TR>
					          <TD width="5%" align="center" class="table_body">L</TD>
					          <TD width="900" height="300" align="center" class="table_none"><TABLE class="privateBorder privateTable" cellSpacing=0 cellPadding=0 width="100%" align=center border=0 background="${ctx}/img/pic/jingzitu.png">
					            <tr>
					              <td width="300" height="100" align="center" style="border-top:2px #fff  solid;">
                                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjazfradio" id="sopyjtsjazfradio" value="0" ${yjCheckPo.sopyjtsjazfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjazfradio" id="sopyjtsjazfradio" value="1" ${yjCheckPo.sopyjtsjazfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjazfinput" name="yjCheckPo.sopyjtsjazfinput" value = "${yjCheckPo.sopyjtsjazfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjarlradio" id="sopyjtsjarlradio" value="0" ${yjCheckPo.sopyjtsjarlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjarlradio" id="sopyjtsjarlradio" value="1" ${yjCheckPo.sopyjtsjarlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjarlinput" name="yjCheckPo.sopyjtsjarlinput" value = "${yjCheckPo.sopyjtsjarlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjaexradio" id="sopyjtsjaexradio" value="0" ${yjCheckPo.sopyjtsjaexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjaexradio" id="sopyjtsjaexradio" value="1" ${yjCheckPo.sopyjtsjaexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjaexinput" name="yjCheckPo.sopyjtsjaexinput" value = "${yjCheckPo.sopyjtsjaexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table></td>
					              <td width="300" align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjbzfradio" id="sopyjtsjbzfradio" value="0" ${yjCheckPo.sopyjtsjbzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjbzfradio" id="sopyjtsjbzfradio" value="1" ${yjCheckPo.sopyjtsjbzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjbzfinput" name="yjCheckPo.sopyjtsjbzfinput" value = "${yjCheckPo.sopyjtsjbzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjbrlradio" id="sopyjtsjbrlradio" value="0" ${yjCheckPo.sopyjtsjbrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjbrlradio" id="sopyjtsjbrlradio" value="1" ${yjCheckPo.sopyjtsjbrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjbrlinput" name="yjCheckPo.sopyjtsjbrlinput" value = "${yjCheckPo.sopyjtsjbrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjbexradio" id="sopyjtsjbexradio" value="0" ${yjCheckPo.sopyjtsjbexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjbexradio" id="sopyjtsjbexradio" value="1" ${yjCheckPo.sopyjtsjbexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjbexinput" name="yjCheckPo.sopyjtsjbexinput" value = "${yjCheckPo.sopyjtsjbexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
								  </td>
					              <td width="300" align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjczfradio" id="sopyjtsjczfradio" value="0" ${yjCheckPo.sopyjtsjczfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjczfradio" id="sopyjtsjczfradio" value="1" ${yjCheckPo.sopyjtsjczfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjczfinput" name="yjCheckPo.sopyjtsjczfinput" value = "${yjCheckPo.sopyjtsjczfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjcrlradio" id="sopyjtsjcrlradio" value="0" ${yjCheckPo.sopyjtsjcrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjcrlradio" id="sopyjtsjcrlradio" value="1" ${yjCheckPo.sopyjtsjcrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjcrlinput" name="yjCheckPo.sopyjtsjcrlinput" value = "${yjCheckPo.sopyjtsjcrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjcexradio" id="sopyjtsjcexradio" value="0" ${yjCheckPo.sopyjtsjcexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjcexradio" id="sopyjtsjcexradio" value="1" ${yjCheckPo.sopyjtsjcexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjcexinput" name="yjCheckPo.sopyjtsjcexinput" value = "${yjCheckPo.sopyjtsjcexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
				                </tr>
					            <tr>
					              <td height="100" align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjdzfradio" id="sopyjtsjdzfradio" value="0" ${yjCheckPo.sopyjtsjdzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjdzfradio" id="sopyjtsjdzfradio" value="1" ${yjCheckPo.sopyjtsjdzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjdzfinput" name="yjCheckPo.sopyjtsjdzfinput" value = "${yjCheckPo.sopyjtsjdzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjdrlradio" id="sopyjtsjdrlradio" value="0" ${yjCheckPo.sopyjtsjdrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjdrlradio" id="sopyjtsjdrlradio" value="1" ${yjCheckPo.sopyjtsjdrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjdrlinput" name="yjCheckPo.sopyjtsjdrlinput" value = "${yjCheckPo.sopyjtsjdrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjdexradio" id="sopyjtsjdexradio" value="0" ${yjCheckPo.sopyjtsjdexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjdexradio" id="sopyjtsjdexradio" value="1" ${yjCheckPo.sopyjtsjdexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjdexinput" name="yjCheckPo.sopyjtsjdexinput" value = "${yjCheckPo.sopyjtsjdexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
					              <td align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjezfradio" id="sopyjtsjezfradio" value="0" ${yjCheckPo.sopyjtsjezfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjezfradio" id="sopyjtsjezfradio" value="1" ${yjCheckPo.sopyjtsjezfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjezfinput" name="yjCheckPo.sopyjtsjezfinput" value = "${yjCheckPo.sopyjtsjezfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjerlradio" id="sopyjtsjerlradio" value="0" ${yjCheckPo.sopyjtsjerlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjerlradio" id="sopyjtsjerlradio" value="1" ${yjCheckPo.sopyjtsjerlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjerlinput" name="yjCheckPo.sopyjtsjerlinput" value = "${yjCheckPo.sopyjtsjerlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjeexradio" id="sopyjtsjeexradio" value="0" ${yjCheckPo.sopyjtsjeexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjeexradio" id="sopyjtsjeexradio" value="1" ${yjCheckPo.sopyjtsjeexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjeexinput" name="yjCheckPo.sopyjtsjeexinput" value = "${yjCheckPo.sopyjtsjeexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
					              <td align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjfzfradio" id="sopyjtsjfzfradio" value="0" ${yjCheckPo.sopyjtsjfzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjfzfradio" id="sopyjtsjfzfradio" value="1" ${yjCheckPo.sopyjtsjfzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjfzfinput" name="yjCheckPo.sopyjtsjfzfinput" value = "${yjCheckPo.sopyjtsjfzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjfrlradio" id="sopyjtsjfrlradio" value="0" ${yjCheckPo.sopyjtsjfrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjfrlradio" id="sopyjtsjfrlradio" value="1" ${yjCheckPo.sopyjtsjfrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjfrlinput" name="yjCheckPo.sopyjtsjfrlinput" value = "${yjCheckPo.sopyjtsjfrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjfexradio" id="sopyjtsjfexradio" value="0" ${yjCheckPo.sopyjtsjfexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjfexradio" id="sopyjtsjfexradio" value="1" ${yjCheckPo.sopyjtsjfexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjfexinput" name="yjCheckPo.sopyjtsjfexinput" value = "${yjCheckPo.sopyjtsjfexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
				                </tr>
					            <tr>
					              <td height="100" align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjgzfradio" id="sopyjtsjgzfradio" value="0" ${yjCheckPo.sopyjtsjgzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjgzfradio" id="sopyjtsjgzfradio" value="1" ${yjCheckPo.sopyjtsjgzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjgzfinput" name="yjCheckPo.sopyjtsjgzfinput" value = "${yjCheckPo.sopyjtsjgzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjgrlradio" id="sopyjtsjgrlradio" value="0" ${yjCheckPo.sopyjtsjgrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjgrlradio" id="sopyjtsjgrlradio" value="1" ${yjCheckPo.sopyjtsjgrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjgrlinput" name="yjCheckPo.sopyjtsjgrlinput" value = "${yjCheckPo.sopyjtsjgrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjgexradio" id="sopyjtsjgexradio" value="0" ${yjCheckPo.sopyjtsjgexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjgexradio" id="sopyjtsjgexradio" value="1" ${yjCheckPo.sopyjtsjgexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjgexinput" name="yjCheckPo.sopyjtsjgexinput" value = "${yjCheckPo.sopyjtsjgexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
					              <td align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjhzfradio" id="sopyjtsjhzfradio" value="0" ${yjCheckPo.sopyjtsjhzfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjhzfradio" id="sopyjtsjhzfradio" value="1" ${yjCheckPo.sopyjtsjhzfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjhzfinput" name="yjCheckPo.sopyjtsjhzfinput" value = "${yjCheckPo.sopyjtsjhzfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjhrlradio" id="sopyjtsjhrlradio" value="0" ${yjCheckPo.sopyjtsjhrlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjhrlradio" id="sopyjtsjhrlradio" value="1" ${yjCheckPo.sopyjtsjhrlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjhrlinput" name="yjCheckPo.sopyjtsjhrlinput" value = "${yjCheckPo.sopyjtsjhrlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjhexradio" id="sopyjtsjhexradio" value="0" ${yjCheckPo.sopyjtsjhexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjhexradio" id="sopyjtsjhexradio" value="1" ${yjCheckPo.sopyjtsjhexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjhexinput" name="yjCheckPo.sopyjtsjhexinput" value = "${yjCheckPo.sopyjtsjhexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
					              <td align="center">
					              <table width="100%" border="0" cellspacing="0" cellpadding="0">
					                <tr>
					                  <td width="300" height="30" align="center">&nbsp;&nbsp;-
					                  	<input type="radio" name="yjCheckPo.sopyjtsjizfradio" id="sopyjtsjizfradio" value="0" ${yjCheckPo.sopyjtsjizfradio eq '0' ? 'checked="checked"' : ''}>
					                    /+
					                    <input type="radio" name="yjCheckPo.sopyjtsjizfradio" id="sopyjtsjizfradio" value="1" ${yjCheckPo.sopyjtsjizfradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjizfinput" name="yjCheckPo.sopyjtsjizfinput" value = "${yjCheckPo.sopyjtsjizfinput}" maxlength="25" class="text_input100">
									  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center">&nbsp;&nbsp;<SUP>R</SUP>/<sub>L</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjirlradio" id="sopyjtsjirlradio" value="0" ${yjCheckPo.sopyjtsjirlradio eq '0' ? 'checked="checked"' : ''}>
					                    /<SUP>L</SUP>/<sub>R</sub>
					                    <input type="radio" name="yjCheckPo.sopyjtsjirlradio" id="sopyjtsjirlradio" value="1" ${yjCheckPo.sopyjtsjirlradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjirlinput" name="yjCheckPo.sopyjtsjirlinput" value = "${yjCheckPo.sopyjtsjirlinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
					                <tr>
					                  <td height="30" align="center"> ex
					                    <input type="radio" name="yjCheckPo.sopyjtsjiexradio" id="sopyjtsjiexradio" value="0" ${yjCheckPo.sopyjtsjiexradio eq '0' ? 'checked="checked"' : ''}>
					                    /in
					                    <input type="radio" name="yjCheckPo.sopyjtsjiexradio" id="sopyjtsjiexradio" value="1" ${yjCheckPo.sopyjtsjiexradio eq '1' ? 'checked="checked"' : ''}>
					                    <input typt="text" id="sopyjtsjiexinput" name="yjCheckPo.sopyjtsjiexinput" value = "${yjCheckPo.sopyjtsjiexinput}" maxlength="25" class="text_input100">
					                  </td>
				                    </tr>
				                  </table>
				                  </td>
				                </tr>
				              </TABLE></TD>
                              <TD width="5%" align="center" class="table_body">R</TD>
                              <TD align="center" class="table_body">&nbsp;</TD>
				            </TR>
					        <TR>
					          <TD align="left" class="table_none" colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						      	<input type="radio" name="yjCheckPo.sopyjtsjreflefradio" id="sopyjtsjreflefradio" value="0" ${yjCheckPo.sopyjtsjreflefradio eq '0' ? 'checked="checked"' : ''}>REF
								<input type="radio" name="yjCheckPo.sopyjtsjreflefradio" id="sopyjtsjreflefradio" value="1" ${yjCheckPo.sopyjtsjreflefradio eq '1' ? 'checked="checked"' : ''}>LEF		
							  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  	<input type="radio" name="yjCheckPo.sopyjtsjccscradio" id="sopyjtsjccscradio" value="0" ${yjCheckPo.sopyjtsjccscradio eq '0' ? 'checked="checked"' : ''}><span style="line-height:1;border-top:solid 1px #000;">CC</span>
								<input type="radio" name="yjCheckPo.sopyjtsjccscradio" id="sopyjtsjccscradio" value="1" ${yjCheckPo.sopyjtsjccscradio eq '1' ? 'checked="checked"' : ''}><span style="line-height:1;border-top:solid 1px #000;">SC</span>		
							  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  	<input type="radio" name="yjCheckPo.sopyjtsj1050radio" id="sopyjtsj1050radio" value="0" ${yjCheckPo.sopyjtsj1050radio eq '0' ? 'checked="checked"' : ''}>10片
								<input type="radio" name="yjCheckPo.sopyjtsj1050radio" id="sopyjtsj1050radio" value="1" ${yjCheckPo.sopyjtsj1050radio eq '1' ? 'checked="checked"' : ''}>50片		
							  </TD>
				            </TR>				            
				          </TBODY>
					      </TABLE></td>
				      </tr>
				  </table>
				</fieldset>	
				<fieldset>
					<legend>【复像检查】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center border=0>
                          <TBODY>  
                            <TR>
                              <TD class="table_none">
                              <textarea  id="sopyjfxjc" name="yjCheckPo.sopyjfxjc" validate="[{'Type' : Type.String, 'Formula' : '', 'Expansion' : {Type : Expansion.LessThanLengthORNULL, Params : [101]}, 'Message' : '复像检查不能大于100字！'}]" style="width:100%" cols="80" rows="7">${fn:trim(yjCheckPo.sopyjfxjc) }</textarea>
                              </TD>
                            </TR>                            
                          </TBODY>
                        </TABLE>
                        </td>
					  </tr>
					</table>
				</fieldset>	
				<fieldset>
					<legend>【特殊检查】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<TABLE class="privateBorder privateTable" cellSpacing=1 cellPadding=3 width="99%" align=center border=0>
                          <TBODY>
                            <TR>
                              <TD align="left" class="table_none">&nbsp;&nbsp;
                              	<select name="yjCheckPo.sopyjtsjcselect">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj004'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(yjCheckPo.sopyjtsjcselect == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <input typt="text" id="sopyjtsjcinput" name="yjCheckPo.sopyjtsjcinput" value = "${yjCheckPo.sopyjtsjcinput}" maxlength="200" class="text_input500">
							  </TD>
                            </TR>  
                          </TBODY>
                        </TABLE>
                        </td>
					  </tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>【调节灵敏度】</legend>
					<table width="99%" class="privateTable" border="0" cellpadding="0" cellspacing="0">
					  <tr>
						<td>
						<table class="privateBorder privateTable" cellspacing=1 cellpadding=3 width="99%" align=center border=0>
						  <tbody>
						    <tr>
						      <td align="left" class="table_none">&nbsp;双面镜度数
                              	<select name="yjCheckPo.sopyjtjlmdshuangmianjingdushu">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj005'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(yjCheckPo.sopyjtjlmdshuangmianjingdushu == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                                </select>&nbsp;&nbsp;&nbsp;&nbsp;视标
                                <select name="yjCheckPo.sopyjtjlmdshibiao">
                                   <option value="" selected></option>
                                   <c:forEach var="optionParamPoTmp" items="${optionParamPolist}" >
		                              <c:if test="${optionParamPoTmp.fopparentid=='yj006'}">
		                               <option value="${optionParamPoTmp.fopparamid }" ${(yjCheckPo.sopyjtjlmdshibiao == optionParamPoTmp.fopparamid)? 'selected=selected' :'' }>${optionParamPoTmp.fopparamname}</option>
		                              </c:if>	                                      	
	                               </c:forEach> 
                                </select>
							  </td>
					        </tr>
						    <tr>
						      <td align="left" class="table_none">&nbsp;
	                              OU&nbsp;<input typt="text" id="sopyjtjlmdou" name="yjCheckPo.sopyjtjlmdou" value = "${yjCheckPo.sopyjtjlmdou}" maxlength="25" class="text_input200">&nbsp;&nbsp;&nbsp;&nbsp;
	                              OD&nbsp;<input typt="text" id="sopyjtjlmdod" name="yjCheckPo.sopyjtjlmdod" value = "${yjCheckPo.sopyjtjlmdod}" maxlength="25" class="text_input200">&nbsp;&nbsp;&nbsp;&nbsp;
	                              OS&nbsp;<input typt="text" id="sopyjtjlmdos" name="yjCheckPo.sopyjtjlmdos" value = "${yjCheckPo.sopyjtjlmdos}" maxlength="25" class="text_input200">&nbsp;&nbsp;&nbsp;&nbsp;
                              </td>
					        </tr>
						  </tbody>
						</table>
						</td>
					  </tr>
					</table>
				</fieldset>				
                    <TABLE id=ctl00_PageBody_PostButton cellSpacing=1 cellPadding=3 width="100%" align=center border=0>
                      <TBODY>
                        <TR>
                          <TD>
                          	  <input type="hidden" name="moduleID" value="${requestScope.moduleID}">
                          	  <img src="${ctx}/img/newbtn/btn_save_0.png" btn=btn id="button1" title='保存' onClick="save()">
                          </TD>
						  </TR>
                      </TBODY>
                    </TABLE>															
                </DIV>
              </DIV>
                  <!--?End--></TD>
              <TD width=1 background=${ctx}/img/pic/tab_bg.gif><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD>
             </TR>
           	</TBODY>
      		</TABLE>
         </TD>
        </TR>
        <TR>
          <TD background=${ctx}/img/pic/tab_bg.gif bgColor=#ffffff><IMG height=1 src="${ctx}/img/pic/tab_bg.gif" width=1></TD></TR></TBODY></TABLE><!--?? End--></TD></TR>
  <TR>
    <TD height=5></TD></TR></TBODY></TABLE></DIV>
</form>
</body></html>
<%@ include file="/WEB-INF/inc/message.jsp" %>